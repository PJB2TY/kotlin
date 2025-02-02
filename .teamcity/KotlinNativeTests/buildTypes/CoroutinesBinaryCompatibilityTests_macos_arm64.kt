package KotlinNativeTests.buildTypes

import _Self.buildTypes.BuildNumber
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object CoroutinesBinaryCompatibilityTests_macos_arm64 : BuildType({
    name = "🍏ᵐ Coroutines binary compatibility test (Native, Macos aarch64)"
    description = "Tests binary compatibility with Coroutines (Macos aarch64)"

    artifactRules = """
        **/hs_err*.log=>internal/hs_err.zip
        **/*.hprof=>internal/hprof.zip
        **/build/reports/dependency-verification=>internal/dependency-verification
        build/reports/configuration-cache/**/**/configuration-cache-report.html
        **/build/reports/tests/**=>internal/test_results.zip
        **/build/test-results/**=>internal/test_results.zip
    """.trimIndent()
    buildNumberPattern = "%kotlin.native.version%"

    params {
        param("gradleParameters", "%globalGradleBuildScanParameters% -Pkotlin.build.testRetry.maxRetries=0 -Pkotlin.build.isObsoleteJdkOverrideEnabled=true")
        param("kotlin.native.performance.server.url", "https://kotlin-native-perf-summary-internal.labs.jb.gg")
        param("kotlin.native.version", "${BuildNumber.depParamRefs["deployVersion"]}")
        param("kotlin.native.test_dist", "%teamcity.build.checkoutDir%%teamcity.agent.jvm.file.separator%test_dist")
        param("env.KONAN_USE_INTERNAL_SERVER", "1")
        param("kotlin.native.artifacts.llvm.dumps", "%system.teamcity.build.tempDir%/kotlin_native_llvm_module_dump*.ll")
        param("kotlin.native.artifacts.logs", "**/hs_err_pid*.log")
        text("requirement.jdk16", "%env.JDK_1_6%", display = ParameterDisplay.HIDDEN)
        param("env.JDK_1_6", "%env.JDK_1_8%")
        param("konanVersion", "%kotlin.native.version%")
        text("requirement.jdk18", "%env.JDK_1_8%", display = ParameterDisplay.HIDDEN)
        text("requirement.jdk17", "%env.JDK_17_0%", display = ParameterDisplay.HIDDEN)
        param("env.JDK_9_0", "%env.JDK_11_0%")
        param("env.JDK_1_7", "%env.JDK_1_8%")
        param("konanMetaVersion", "%build.number.native.meta.version%")
        param("kotlin.native.target_opts", "")
        text("requirement.jdk9", "%env.JDK_9_0%", display = ParameterDisplay.HIDDEN)
        text("requirement.jdk11", "%env.JDK_11_0%", display = ParameterDisplay.HIDDEN)
    }

    vcs {
        root(DslContext.settingsRoot, "+:. => kotlin")
        root(KotlinNativeTests.vcsRoots.Kotlinx_Coroutines, "+:. => kotlinx.coroutines")

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
        script {
            name = "Print KONAN_USE_INTERNAL_SERVER value"
            scriptContent = "printenv | grep KONAN_USE_INTERNAL_SERVER || true"
        }
        script {
            name = "Print current Xcode version"
            scriptContent = "xcode-select -p"
        }
        script {
            name = "Print processes list sorted by memory usage"
            scriptContent = "echo '%MEM    RSS      VSZ   PID     ELAPSED USER             COMMAND'; ps -aexo pmem,rss,vsize,pid,etime,user,command | sort -r"
        }
        gradle {
            name = "Compile and run Coroutines test (old compiler)"
            tasks = ":kotlinx-coroutines-core:compileTestKotlinMacosArm64 :kotlinx-coroutines-core:linkDebugTestMacosArm64 :kotlinx-coroutines-core:macosArm64Test"
            buildFile = "build.gradle"
            workingDir = "kotlinx.coroutines"
            gradleParams = "%gradleParameters% --parallel"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
        script {
            workingDir = "kotlinx.coroutines"
            scriptContent = """
                cat > runOnlyTheseTasks.init.gradle.kts <<EOF
                               val allowedTaskPaths = gradle.startParameter.taskNames.toSet()
                
                gradle.addListener(object : BuildAdapter(), TaskExecutionListener {
                    val executedTaskPaths = mutableSetOf<String>()
                
                    override fun beforeExecute(task: Task) {}
                
                    @Synchronized
                    override fun afterExecute(task: Task, state: TaskState) {
                        if (!state.skipped)
                            executedTaskPaths += task.path
                    }
                
                    @Synchronized
                    override fun buildFinished(result: BuildResult) {
                        try {
                            // Should we also check order?
                            check(allowedTaskPaths == executedTaskPaths) {
                                buildString {
                                    appendln("Executed task mismatch:")
                                    append(" Expected: ")
                                    allowedTaskPaths.joinTo(this)
                                    appendln()
                                    append(" Actual: ")
                                    executedTaskPaths.joinTo(this)
                                    appendln()
                                    append("Make sure you use full task paths when invoking Gradle")
                                }
                            }
                        } finally {
                            executedTaskPaths.clear()
                        }
                    }
                })
                
                allprojects {
                    afterEvaluate {
                        tasks.configureEach {
                            if (this.path !in allowedTaskPaths) {
                                logger.info("DISABLE " + this)
                                this.enabled = false
                            }
                        }
                    }
                }
            """.trimIndent()
        }
        gradle {
            name = "Compile Coroutines test (old compiler)"
            tasks = "clean :kotlinx-coroutines-core:compileTestKotlinMacosArm64"
            buildFile = "build.gradle"
            workingDir = "kotlinx.coroutines"
            gradleParams = "%gradleParameters% --parallel"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
        gradle {
            name = "Build and run Coroutines test (new compiler)"
            tasks = ":kotlinx-coroutines-core:linkDebugTestMacosArm64 :kotlinx-coroutines-core:macosArm64Test"
            buildFile = "build.gradle"
            workingDir = "kotlinx.coroutines"
            gradleParams = "%gradleParameters% --parallel -I runOnlyTheseTasks.init.gradle.kts -Pkotlin.native.home=%kotlin.native.test_dist%"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
        gradle {
            name = "Compile Coroutines (old compiler)"
            tasks = "clean :kotlinx-coroutines-core:compileKotlinMacosArm64"
            buildFile = "build.gradle"
            workingDir = "kotlinx.coroutines"
            gradleParams = "%gradleParameters% --parallel"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
        gradle {
            name = "Build and run Coroutines test (new compiler) with Coroutines (built with old compiler)"
            tasks = ":kotlinx-coroutines-core:compileTestKotlinMacosArm64 :kotlinx-coroutines-core:linkDebugTestMacosArm64 :kotlinx-coroutines-core:macosArm64Test"
            buildFile = "build.gradle"
            workingDir = "kotlinx.coroutines"
            gradleParams = "%gradleParameters% --parallel -I runOnlyTheseTasks.init.gradle.kts -Pkotlin.native.home=%kotlin.native.test_dist%"
            enableStacktrace = false
            jdkHome = "%env.JDK_11_0%"
        }
    }

    failureConditions {
        executionTimeoutMin = 240
    }

    dependencies {
        snapshot(_Self.buildTypes.BuildNumber) {
            onDependencyFailure = FailureAction.FAIL_TO_START
        }
        dependency(KotlinNative.buildTypes.KotlinNativeDist_macos_arm64_BUNDLE) {
            snapshot {
                onDependencyFailure = FailureAction.FAIL_TO_START
            }

            artifacts {
                artifactRules = "kotlin-native-prebuilt-macos-aarch64-%kotlin.native.version%.tar.gz!kotlin-native-prebuilt-macos-aarch64-%kotlin.native.version%/** => %kotlin.native.test_dist%"
            }
        }
    }

    requirements {
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        moreThan("teamcity.agent.work.dir.freeSpaceMb", "2048")
        contains("teamcity.agent.jvm.os.arch", "aarch64")
        doesNotContain("teamcity.agent.name", "aquarius-kotlin-k8s-native-xcode-stable-macos")
        doesNotContain("teamcity.agent.name", "aquarius-kotlin-k8s-native-xcode-beta-macos")
        doesNotContain("teamcity.agent.name", "aquarius-kotlin-k8s-latest-xcode-kmp-test-macos")
        noLessThanVer("tools.xcode.version", "13.0")
        startsWith("teamcity.agent.jvm.os.name", "Mac")
        moreThan("teamcity.agent.work.dir.freeSpaceMb", "2048")
        contains("teamcity.agent.jvm.os.arch", "aarch64")
        doesNotContain("teamcity.agent.name", "aquarius-kotlin-k8s-native-xcode-stable-macos")
        doesNotContain("teamcity.agent.name", "aquarius-kotlin-k8s-native-xcode-beta-macos")
        doesNotContain("teamcity.agent.name", "aquarius-kotlin-k8s-latest-xcode-kmp-test-macos")
    }
})
