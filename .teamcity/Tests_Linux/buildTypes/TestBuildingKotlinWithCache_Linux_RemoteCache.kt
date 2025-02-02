package Tests_Linux.buildTypes

import _Self.buildTypes.BuildKotlinToDirectoryCache
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.freeDiskSpace
import jetbrains.buildServer.configs.kotlin.buildFeatures.notifications
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle

object TestBuildingKotlinWithCache_Linux_RemoteCache : BuildType({
    name = "🐧 Test building Kotlin with REMOTE cache (Linux)"

    artifactRules = """
        **/build/libs/*.jar => build-libs.zip
        .gradle/caches/transforms-*/** => transforms.zip
    """.trimIndent()
    buildNumberPattern = "%build.number.default%"

    params {
        param("gradleParameters", """%globalGradleParameters% --no-configuration-cache -Pkotlin.build.cache.local.enabled=true -Pkotlin.build.cache.local.directory=%teamcity.build.checkoutDir%/build-cache -Pkotlin.build.cache.check.enabled=true "-Dscan.value.Configuration=Test building Kotlin with REMOTE cache (Linux)"""")
        text("requirement.jdk16", "%env.JDK_1_6%", display = ParameterDisplay.HIDDEN)
        param("teamcity.internal.gradle.runner.launch.mode", "gradle-tooling-api")
        text("requirement.jdk18", "%env.JDK_1_8%", display = ParameterDisplay.HIDDEN)
        param("system.deployVersion", "%build.number%")
        text("requirement.jdk17", "%env.JDK_1_7%", display = ParameterDisplay.HIDDEN)
        param("globalGradleParameters", """-Pteamcity=true "-Pbuild.number=%build.number%" --configuration-cache %globalGradleCacheNodeParameters% %globalGradleBuildScanParameters%""")
        param("build.number.default", "${BuildKotlinToDirectoryCache.depParamRefs.buildNumber}-%build.counter%")
        param("globalGradleCacheNodeParameters", " -Pkotlin.build.cache.url=https://gradle-cache.kotlin.intellij.net/cache/ -Pkotlin.build.cache.user=%kotlin.build.cache.user% -Pkotlin.build.cache.password=%kotlin.build.cache.password% -Pkotlin.build.cache.push=true")
        param("globalGradleBuildScanParameters", "-Pkotlin.build.scan.url=%gradle.enterprise.url% -Dscan.tag.kotlin-build-test")
        text("requirement.jdk9", "%env.JDK_9_0%", display = ParameterDisplay.HIDDEN)
        param("env.GRADLE_USER_HOME", "%teamcity.build.checkoutDir%/.gradle")
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => kotlin-in-different-directory")

        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
    }

    steps {
        gradle {
            name = "Build with cache"
            tasks = "dist compileAll"
            buildFile = "build.gradle.kts"
            workingDir = "kotlin-in-different-directory"
            gradleParams = "%gradleParameters% --parallel"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
    }

    features {
        notifications {
            enabled = false
            notifierSettings = slackNotifier {
                connection = "PROJECT_EXT_486"
                sendTo = "#kotlin-bots"
                messageFormat = verboseMessageFormat {
                    addStatusText = true
                }
            }
            branchFilter = "+:<default>"
            buildFailed = true
            firstFailureAfterSuccess = true
        }
        freeDiskSpace {
            requiredSpace = "10gb"
            failBuild = true
        }
        perfmon {
        }
    }

    dependencies {
        snapshot(_Self.buildTypes.BuildKotlinToDirectoryCache) {
            onDependencyFailure = FailureAction.FAIL_TO_START
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Linux")
        contains("system.cloud.profile_id", "-aws")
        startsWith("system.cloud.profile_id", "aquarius")
        equals("teamcity.agent.hardware.cpuCount", "4")
        noLessThan("teamcity.agent.hardware.memorySizeMb", "15000")
        noMoreThan("teamcity.agent.hardware.memorySizeMb", "17000")
    }
})
