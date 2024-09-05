package XcodeUpdate.buildTypes

import _Self.buildTypes.BuildNumber
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.Swabra
import jetbrains.buildServer.configs.kotlin.buildFeatures.freeDiskSpace
import jetbrains.buildServer.configs.kotlin.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.buildFeatures.swabra
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.kotlinScript

object GradleIntegrationTestsLatestXcode_MACOS : BuildType({
    name = "🍏ᵐ Run Kotlin Gradle Plugin Integration tests on Custom Xcode"
    description = """
        Runs Kotlin Gradle Plugin Integration tests part of the Custom Xcode Tests Aggregate.
        Triggers build of image for iCRI virtual machine.
    """.trimIndent()

    artifactRules = """
        **/hs_err*.log=>internal/hs_err.zip
        **/*.hprof=>internal/hprof.zip
        **/build/reports/dependency-verification=>internal/dependency-verification
        build/reports/configuration-cache/**/**/configuration-cache-report.html
        **/build/reports/tests/**=>internal/test_results.zip
        **/build/test-results/**=>internal/test_results.zip
        %env.GRADLE_USER_HOME%/**/*daemon*.log=>internal/logs.zip
        **/testKitCache/test-kit-daemon/**/*daemon*.log=>internal/test-kit-daemon-logs.zip
    """.trimIndent()
    buildNumberPattern = "%build.number.default%"

    params {
        param("gradleParameters", "--no-build-cache -Pkotlin.build.isObsoleteJdkOverrideEnabled=true %globalGradleParameters%")
        text("requirement.jdk18", "%env.JDK_1_8%", display = ParameterDisplay.HIDDEN)
        param("system.versions.kotlin-native", "${BuildNumber.depParamRefs["deployVersion"]}")
        param("build.number.default", "${BuildNumber.depParamRefs.buildNumber}")
        param("mavenParameters", "")
        param("system.maven.repo.local", "%teamcity.build.checkoutDir%/dist/local-repo")
        param("env.GRADLE_USER_HOME", "%teamcity.build.checkoutDir%/.gradle")
        text("requirement.jdk11", "%env.JDK_11_0%", display = ParameterDisplay.HIDDEN)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => kotlin")

        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
    }

    steps {
        gradle {
            name = "Build and install artifacts to local maven repo"
            tasks = "clean install"
            buildFile = "build.gradle.kts"
            workingDir = "%teamcity.build.checkoutDir%/kotlin"
            gradleParams = "%gradleParameters% --parallel -Dmaven.repo.local=%teamcity.build.checkoutDir%/maven/repo -Pkotlin.build.gradle.publish.javadocs=false"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
        gradle {
            name = "Build Gradle plugin integration tests"
            tasks = ":kotlin-gradle-plugin-integration-tests:kgpNativeTests"
            buildFile = "build.gradle.kts"
            workingDir = "%teamcity.build.checkoutDir%/kotlin"
            gradleParams = "%gradleParameters% --parallel -Pkotlin.build.disable.verification.tasks=true -Dscan.tag.verification-tasks-disabled"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
        gradle {
            name = "Run Gradle plugin integration tests"
            tasks = ":kotlin-gradle-plugin-integration-tests:kgpNativeTests"
            buildFile = "build.gradle.kts"
            workingDir = "%teamcity.build.checkoutDir%/kotlin"
            gradleParams = "%gradleParameters% --no-parallel -Dmaven.repo.local=%teamcity.build.checkoutDir%/maven/repo -DkonanDataDirForIntegrationTests=%teamcity.build.checkoutDir%/kotlin/.kotlin/konan-for-gradle-tests -DkotlinNativeVersionForGradleIT=${BuildNumber.depParamRefs["deployVersion"]} -Pkotlin.build.gradle.publish.javadocs=false"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
        kotlinScript {
            name = "Delete local maven repo"
            content = "java.io.File(args[0]).deleteRecursively()"
            arguments = "%teamcity.build.checkoutDir%/maven/repo"
        }
    }

    failureConditions {
        executionTimeoutMin = 300
        supportTestRetry = true
    }

    features {
        freeDiskSpace {
            requiredSpace = "15gb"
            failBuild = false
        }
        swabra {
            lockingProcesses = Swabra.LockingProcessPolicy.KILL
        }
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_486"
                sendTo = "#kotlin-build-tools-build-notifications"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            buildFailed = true
            firstFailureAfterSuccess = true
        }
    }

    dependencies {
        snapshot(AbsoluteId("CloudAgents_teams_kotlin_KotlinMacosKmmStaging")) {
        }
        snapshot(_Self.buildTypes.BuildNumber) {
            onDependencyFailure = FailureAction.FAIL_TO_START
        }
        snapshot(Deploy.buildTypes.KotlinNativePublish) {
            onDependencyFailure = FailureAction.FAIL_TO_START
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        contains("teamcity.agent.jvm.os.arch", "aarch64")
        contains("env.TC_K8S_IMAGE_NAME", "aquarius-kotlin-k8s-latest-xcode-kmp-test-macos")
    }
})
