package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'KmpSamples_Build'
in the project with id = 'KmpSamples', and delete the patch script.
*/
create(RelativeId("KmpSamples"), BuildType({
    id("KmpSamples_Build")
    name = "🍏ᵐ [Project] KMP Basic Sample"

    vcs {
        root(RelativeId("KmpSamples_HttpsGithubComKotlinKmpBasicSampleGitRefsHeadsMaster"))
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
}))

