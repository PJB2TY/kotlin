package KotlinNative.buildTypes

import _Self.buildTypes.BuildNumber
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.freeDiskSpace
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.retryBuild

object KotlinNativeDist_linux_x64_LIGHT_BUNDLE : BuildType({
    name = "🐧 Compiler Dist: no cross-target libs (Native, Linux x86_64)"
    description = "Build configuration"

    artifactRules = """
        kotlin/build/repo => native-maven
        kotlin/kotlin-native/kotlin-native-linux-x86_64-%kotlin.native.version%.tar.gz
        kotlin/kotlin-native/kotlin-native-prebuilt-linux-x86_64-%kotlin.native.version%.tar.gz
        kotlin/kotlin-native/build/kotlin-native-linux-x86_64-%kotlin.native.version%.tar.gz.sha256
        kotlin/kotlin-native/build/kotlin-native-prebuilt-linux-x86_64-%kotlin.native.version%.tar.gz.sha256
        kotlin/kotlin-native/build/spdx/regular/kotlin-native-linux-x86_64-%kotlin.native.version%.spdx.json
        kotlin/kotlin-native/build/spdx/prebuilt/kotlin-native-prebuilt-linux-x86_64-%kotlin.native.version%.spdx.json
        %kotlin.native.artifacts.logs%
        %kotlin.native.artifacts.llvm.dumps%
    """.trimIndent()
    buildNumberPattern = "%kotlin.native.version%"

    params {
        param("gradleParameters", "--info %globalGradleBuildScanParameters% %globalGradleCacheNodeParameters%")
        param("kotlin.native.performance.server.url", "https://kotlin-native-perf-summary-internal.labs.jb.gg")
        param("kotlin.native.version", "${BuildNumber.depParamRefs["deployVersion"]}")
        param("kotlin.native.test_dist", "%teamcity.build.checkoutDir%%teamcity.agent.jvm.file.separator%test_dist")
        param("env.KONAN_USE_INTERNAL_SERVER", "1")
        param("kotlin.native.artifacts.llvm.dumps", "%system.teamcity.build.tempDir%/kotlin_native_llvm_module_dump*.ll")
        param("kotlin.native.artifacts.logs", "**/hs_err_pid*.log")
        text("requirement.jdk16", "%env.JDK_1_6%", display = ParameterDisplay.HIDDEN)
        param("konanVersion", "%kotlin.native.version%")
        text("requirement.jdk18", "%env.JDK_1_8%", display = ParameterDisplay.HIDDEN)
        param("system.deployVersion", "%kotlin.native.version%")
        text("requirement.jdk17", "%env.JDK_1_7%", display = ParameterDisplay.HIDDEN)
        param("konanMetaVersion", "%build.number.native.meta.version%")
        text("requirement.jdk9", "%env.JDK_9_0%", display = ParameterDisplay.HIDDEN)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => kotlin")

        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
    }

    steps {
        script {
            name = "Set up Git"
            scriptContent = """
                "%env.TEAMCITY_GIT_PATH%" -C "%teamcity.build.checkoutDir%/kotlin" config user.email teamcity-demo-noreply@jetbrains.com
                "%env.TEAMCITY_GIT_PATH%" -C "%teamcity.build.checkoutDir%/kotlin" config user.name TeamCity
            """.trimIndent()
        }
        gradle {
            name = "Build Compiler Dist: bundle without cross-target libs"
            tasks = ":kotlin-native:publish"
            buildFile = "build.gradle.kts"
            workingDir = "%teamcity.build.checkoutDir%/kotlin"
            gradleParams = """
                %gradleParameters% --parallel -Pbuild.number=%kotlin.native.version%
                -Pkotlin.native.enabled=true
                -Pkotlin.native.allowRunningCinteropInProcess=true
                -Pkotlin.incremental=false
            """.trimIndent()
            enableStacktrace = true
            jdkHome = "%env.JDK_11_0%"
        }
    }

    triggers {
        retryBuild {
            attempts = 2
            moveToTheQueueTop = true
            branchFilter = "+:master"
        }
    }

    failureConditions {
        executionTimeoutMin = 200
    }

    features {
        freeDiskSpace {
            requiredSpace = "16gb"
            failBuild = true
        }
    }

    dependencies {
        snapshot(_Self.buildTypes.BuildNumber) {
            onDependencyFailure = FailureAction.FAIL_TO_START
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Linux")
        moreThan("teamcity.agent.work.dir.freeSpaceMb", "2048")
        equals("teamcity.agent.hardware.cpuCount", "8")
        noLessThan("teamcity.agent.hardware.memorySizeMb", "15000")
        noMoreThan("teamcity.agent.hardware.memorySizeMb", "17000")
        noLessThan("teamcity.agent.hardware.memorySizeMb", "15000")
        noMoreThan("teamcity.agent.hardware.memorySizeMb", "17000")
        contains("system.cloud.profile_id", "-aws")
        startsWith("system.cloud.profile_id", "aquarius")
    }
})
