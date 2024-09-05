package KotlinNativeLatestXcodeTests

import KotlinNativeLatestXcodeTests.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("KotlinNativeLatestXcodeTests")
    name = "Latest Xcode Tests"

    buildType(NativeTest_K2_tvos_arm64_bundle_oM_o_cM_n_gT_s_gS_ag_a_m_cO_e_stable)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_oM_n_cM_n_gT_n_gS_ad_a_m_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_gT_c_gS_ad_a_c_custom)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_oM_o_cM_n_gT_c_gS_m_a_c_custom)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_f_gT_n_gS_ad_a_c_beta)
    buildType(KotlinNativeSamples_macos_arm64_custom)
    buildType(NativeTest_Without_K2_watchos_arm64_bundle_cM_n_gT_p_uTSC_e_cO_e_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_m_1_gT_s_gS_ad_a_c_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_m_1_gT_s_gS_ad_a_c_custom)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_n_gT_n_gS_ag_a_s_uTSC_e_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_m_1_oM_o_cM_n_gT_p_gS_m_a_m_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_oM_n_cM_n_gT_p_gS_ad_a_m_custom)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_m_1_oM_o_cM_n_gT_n_gS_ad_a_s_stable)
    buildType(NativeTest_Without_K2_tvos_simulator_arm64_bundle_m_1_cM_n_gT_c_gS_ag_a_s_uTSC_e_beta)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_uTSC_e_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle__stable)
    buildType(NativeTest_K2_macos_arm64_bundle__beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_f_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_oM_n_cM_n_gT_c_custom)
    buildType(KotlinNativeiOS_Upload_Test_macos_arm64_custom)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_oM_n_cM_n_gT_s_gS_ag_a_c_stable)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_oM_o_cM_n_gT_c_gS_m_a_c_beta)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_oM_o_cM_n_gT_s_gS_ag_a_m_beta)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_oM_o_cM_n_gT_s_gS_ag_a_m_custom)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_cM_n_gT_p_gS_m_a_m_uTSC_e_custom)
    buildType(NativeTest_Without_K2_tvos_simulator_arm64_bundle_m_1_cM_n_gT_c_gS_ag_a_s_uTSC_e_custom)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_e_gT_n_gS_ad_a_c_custom)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_gT_s_gS_m_a_s_uTSC_e_beta)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_a_m_beta)
    buildType(NativeTest_K2_macos_arm64_bundle_gT_c_gS_ad_a_c_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_oM_n_cM_n_gT_c_gS_ag_a_m_stable)
    buildType(KotlinNativeDist_macos_arm64_BUNDLE_beta)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_m_1_cM_e_gT_s_gS_ad_a_c_beta)
    buildType(NativeTest_Without_K2_watchos_arm64_bundle_cM_n_gT_p_uTSC_e_cO_e_stable)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_cM_n_gT_p_gS_ag_a_s_uTSC_e_beta)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_cM_n_gT_p_gS_m_a_m_uTSC_e_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_oM_n_cM_n_gT_c_gS_ag_a_m_beta)
    buildType(NativeTest_Without_K2_watchos_simulator_arm64_bundle_m_1_oM_n_cM_n_gT_c_gS_m_a_s_custom)
    buildType(NativeTest_K2_macos_arm64_bundle__custom)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_cM_n_gT_p_gS_ag_a_s_uTSC_e_stable)
    buildType(NativeTest_K2_macos_arm64_bundle__stable)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_cM_n_gT_p_gS_ag_a_s_uTSC_e_custom)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_uTSC_e_stable)
    buildType(NativeTest_Without_K2_watchos_simulator_arm64_bundle_m_1_oM_n_cM_n_gT_c_gS_m_a_s_stable)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_e_gT_p_gS_ad_a_c_custom)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_oM_o_cM_n_custom)
    buildType(NativeTest_Without_K2_watchos_arm64_bundle_cM_n_gT_p_uTSC_e_cO_e_custom)
    buildType(KotlinNativeRuntime_Tests_macos_arm64_beta)
    buildType(NativeCompilerUnitTest_macos_arm64_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_e_gT_p_gS_ad_a_c_stable)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_oM_o_cM_n_stable)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_oM_n_cM_n_gT_c_gS_ag_a_m_custom)
    buildType(NativeTest_K2_tvos_arm64_bundle_oM_o_cM_n_gT_s_gS_ag_a_m_cO_e_custom)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_f_gT_p_gS_ad_a_c_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_m_1_oM_o_cM_n_gT_p_gS_m_a_m_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle__beta)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_f_gT_p_gS_ad_a_c_custom)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_e_gT_p_gS_ad_a_c_beta)
    buildType(KotlinNativeSamples_macos_arm64_beta)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_oM_n_cM_n_gT_s_gS_ag_a_c_beta)
    buildType(NativeTest_Without_K2_watchos_simulator_arm64_bundle_m_1_oM_n_cM_n_gT_c_gS_m_a_s_beta)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_n_gT_n_gS_ag_a_s_uTSC_e_beta)
    buildType(KotlinNativeiOS_Upload_Test_macos_arm64_beta)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_oM_o_cM_n_gT_s_gS_ag_a_m_stable)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_f_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_m_1_cM_f_gT_c_gS_ad_a_c_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_m_1_gT_s_gS_ad_a_c_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_gT_n_gS_ad_a_c_beta)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_e_gT_n_gS_ad_a_c_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_gT_c_gS_ad_a_c_stable)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_cM_n_gT_p_gS_m_a_m_uTSC_e_stable)
    buildType(KotlinNativeDist_macos_arm64_BUNDLE_custom)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_uTSC_e_custom)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle__custom)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_m_1_cM_n_gT_n_gS_m_a_m_uTSC_e_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_f_custom)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_oM_n_cM_n_gT_p_gS_ad_a_m_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_oM_n_cM_n_gT_c_beta)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_m_1_oM_o_cM_n_gT_p_gS_m_a_m_custom)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_m_1_oM_o_cM_n_gT_n_gS_ad_a_s_custom)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_cM_n_gT_s_gS_ad_a_c_uTSC_e_custom)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_oM_o_cM_n_gT_c_gS_m_a_c_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_n_gT_n_gS_ag_a_s_uTSC_e_custom)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_oM_n_cM_n_gT_n_gS_ad_a_m_custom)
    buildType(NativeCompilerUnitTest_macos_arm64_custom)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_oM_n_cM_n_gT_s_gS_ag_a_c_custom)
    buildType(KotlinNativeiOS_Upload_Test_macos_arm64_stable)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_cM_n_gT_s_gS_ad_a_c_uTSC_e_beta)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_gT_p_gS_ad_a_c_beta)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_e_gT_c_gS_ad_a_c_stable)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_a_m_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_e_gT_c_gS_ad_a_c_beta)
    buildType(NativeTest_K2_ios_arm64_bundle_cM_e_cO_e_custom)
    buildType(NativeCompilerUnitTest_macos_arm64_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_n_gT_s_gS_ad_a_c_custom)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_m_1_cM_n_gT_n_gS_m_a_m_uTSC_e_stable)
    buildType(KotlinNativeRuntime_Tests_macos_arm64_stable)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_f_gT_s_gS_ad_a_c_beta)
    buildType(NativeTest_Without_K2_tvos_simulator_arm64_bundle_m_1_cM_n_gT_c_gS_ag_a_s_uTSC_e_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_f_gT_n_gS_ad_a_c_custom)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_a_m_custom)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_gT_s_gS_m_a_s_uTSC_e_custom)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_n_gT_s_gS_ad_a_c_stable)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_cM_n_gT_s_gS_ad_a_c_uTSC_e_stable)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_e_gT_c_gS_ad_a_c_custom)
    buildType(KotlinNativeDist_macos_arm64_BUNDLE_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_n_gT_s_gS_ad_a_c_beta)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_m_1_cM_e_gT_s_gS_ad_a_c_stable)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_cM_n_gT_s_gS_m_a_s_uTSC_e_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_m_1_cM_e_gT_s_gS_ad_a_c_custom)
    buildType(NativeTest_K2_tvos_simulator_arm64_bundle_oM_n_cM_n_gT_n_gS_ad_a_m_beta)
    buildType(NativeTest_K2_macos_arm64_bundle_oM_n_cM_n_gT_c_stable)
    buildType(NativeTest_K2_ios_arm64_bundle_cM_e_cO_e_beta)
    buildType(NativeTest_Without_K2_ios_simulator_arm64_bundle_m_1_cM_n_gT_n_gS_m_a_m_uTSC_e_custom)
    buildType(KotlinNativeRuntime_Tests_macos_arm64_custom)
    buildType(NativeTest_K2_macos_arm64_bundle_cM_f_gT_n_gS_ad_a_c_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_f_gT_p_gS_ad_a_c_beta)
    buildType(NativeTest_K2_macos_arm64_bundle_gT_n_gS_ad_a_c_stable)
    buildType(KotlinNativeSamples_macos_arm64_stable)
    buildType(NativeTest_K2_watchos_simulator_arm64_bundle_m_1_oM_o_cM_n_gT_n_gS_ad_a_s_beta)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_m_1_cM_f_gT_c_gS_ad_a_c_stable)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_f_gT_s_gS_ad_a_c_stable)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_gT_p_gS_ad_a_c_stable)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_cM_f_gT_s_gS_ad_a_c_custom)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_m_1_cM_f_gT_c_gS_ad_a_c_custom)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_gT_p_gS_ad_a_c_custom)
    buildType(NativeTest_K2_ios_simulator_arm64_bundle_oM_o_cM_n_beta)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_oM_n_cM_n_gT_p_gS_ad_a_m_beta)
    buildType(NativeTest_K2_ios_arm64_bundle_cM_e_cO_e_stable)
    buildType(NativeTest_K2_tvos_arm64_bundle_oM_o_cM_n_gT_s_gS_ag_a_m_cO_e_beta)
    buildType(NativeTest_K2_macos_arm64_bundle_gT_n_gS_ad_a_c_custom)
    buildType(NativeTest_Without_K2_macos_arm64_bundle_cM_e_gT_n_gS_ad_a_c_beta)
})
