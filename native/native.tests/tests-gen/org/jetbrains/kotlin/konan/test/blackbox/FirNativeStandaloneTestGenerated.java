/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.test.blackbox;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.junit.jupiter.api.Tag;
import org.jetbrains.kotlin.konan.test.blackbox.support.EnforcedProperty;
import org.jetbrains.kotlin.konan.test.blackbox.support.ClassLevelProperty;
import org.jetbrains.kotlin.konan.test.blackbox.support.group.UseStandardTestCaseGroupProvider;
import org.jetbrains.kotlin.konan.test.blackbox.support.group.FirPipeline;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.GenerateNativeTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("native/native.tests/testData/standalone")
@TestDataPath("$PROJECT_ROOT")
@Tag("standalone")
@EnforcedProperty(property = ClassLevelProperty.TEST_KIND, propertyValue = "STANDALONE_NO_TR")
@UseStandardTestCaseGroupProvider()
@Tag("frontend-fir")
@FirPipeline()
public class FirNativeStandaloneTestGenerated extends AbstractNativeBlackBoxTest {
  @Test
  public void testAllFilesPresentInStandalone() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/standalone"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("funptr.kt")
  public void testFunptr() {
    runTest("native/native.tests/testData/standalone/funptr.kt");
  }

  @Test
  @TestMetadata("kt56048.kt")
  public void testKt56048() {
    runTest("native/native.tests/testData/standalone/kt56048.kt");
  }

  @Test
  @TestMetadata("workerSignals.kt")
  public void testWorkerSignals() {
    runTest("native/native.tests/testData/standalone/workerSignals.kt");
  }

  @Nested
  @TestMetadata("native/native.tests/testData/standalone/checkers")
  @TestDataPath("$PROJECT_ROOT")
  @Tag("standalone")
  @EnforcedProperty(property = ClassLevelProperty.TEST_KIND, propertyValue = "STANDALONE_NO_TR")
  @UseStandardTestCaseGroupProvider()
  @Tag("frontend-fir")
  @FirPipeline()
  public class Checkers {
    @Test
    public void testAllFilesPresentInCheckers() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/standalone/checkers"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("leakMemoryWithRunningThreadChecked.kt")
    public void testLeakMemoryWithRunningThreadChecked() {
      runTest("native/native.tests/testData/standalone/checkers/leakMemoryWithRunningThreadChecked.kt");
    }

    @Test
    @TestMetadata("leakMemoryWithRunningThreadUnchecked.kt")
    public void testLeakMemoryWithRunningThreadUnchecked() {
      runTest("native/native.tests/testData/standalone/checkers/leakMemoryWithRunningThreadUnchecked.kt");
    }
  }

  @Nested
  @TestMetadata("native/native.tests/testData/standalone/console")
  @TestDataPath("$PROJECT_ROOT")
  @Tag("standalone")
  @EnforcedProperty(property = ClassLevelProperty.TEST_KIND, propertyValue = "STANDALONE_NO_TR")
  @UseStandardTestCaseGroupProvider()
  @Tag("frontend-fir")
  @FirPipeline()
  public class Console {
    @Test
    public void testAllFilesPresentInConsole() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/standalone/console"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("fprintf.kt")
    public void testFprintf() {
      runTest("native/native.tests/testData/standalone/console/fprintf.kt");
    }

    @Test
    @TestMetadata("printf.kt")
    public void testPrintf() {
      runTest("native/native.tests/testData/standalone/console/printf.kt");
    }

    @Test
    @TestMetadata("println.kt")
    public void testPrintln() {
      runTest("native/native.tests/testData/standalone/console/println.kt");
    }

    @Test
    @TestMetadata("puts.kt")
    public void testPuts() {
      runTest("native/native.tests/testData/standalone/console/puts.kt");
    }

    @Test
    @TestMetadata("readLine.kt")
    public void testReadLine() {
      runTest("native/native.tests/testData/standalone/console/readLine.kt");
    }

    @Test
    @TestMetadata("readLineEmpty.kt")
    public void testReadLineEmpty() {
      runTest("native/native.tests/testData/standalone/console/readLineEmpty.kt");
    }

    @Test
    @TestMetadata("readLineSingleEmptyLine.kt")
    public void testReadLineSingleEmptyLine() {
      runTest("native/native.tests/testData/standalone/console/readLineSingleEmptyLine.kt");
    }

    @Test
    @TestMetadata("readln.kt")
    public void testReadln() {
      runTest("native/native.tests/testData/standalone/console/readln.kt");
    }

    @Test
    @TestMetadata("readlnEmpty.kt")
    public void testReadlnEmpty() {
      runTest("native/native.tests/testData/standalone/console/readlnEmpty.kt");
    }

    @Test
    @TestMetadata("readlnOrNullEmpty.kt")
    public void testReadlnOrNullEmpty() {
      runTest("native/native.tests/testData/standalone/console/readlnOrNullEmpty.kt");
    }
  }

  @Nested
  @TestMetadata("native/native.tests/testData/standalone/entryPoint")
  @TestDataPath("$PROJECT_ROOT")
  @Tag("standalone")
  @EnforcedProperty(property = ClassLevelProperty.TEST_KIND, propertyValue = "STANDALONE_NO_TR")
  @UseStandardTestCaseGroupProvider()
  @Tag("frontend-fir")
  @FirPipeline()
  public class EntryPoint {
    @Test
    public void testAllFilesPresentInEntryPoint() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/standalone/entryPoint"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("args.kt")
    public void testArgs() {
      runTest("native/native.tests/testData/standalone/entryPoint/args.kt");
    }

    @Test
    @TestMetadata("differentEntry.kt")
    public void testDifferentEntry() {
      runTest("native/native.tests/testData/standalone/entryPoint/differentEntry.kt");
    }

    @Test
    @TestMetadata("differentEntryMultiModule.kt")
    public void testDifferentEntryMultiModule() {
      runTest("native/native.tests/testData/standalone/entryPoint/differentEntryMultiModule.kt");
    }

    @Test
    @TestMetadata("differentEntryNoArgs.kt")
    public void testDifferentEntryNoArgs() {
      runTest("native/native.tests/testData/standalone/entryPoint/differentEntryNoArgs.kt");
    }

    @Test
    @TestMetadata("mainOverloading.kt")
    public void testMainOverloading() {
      runTest("native/native.tests/testData/standalone/entryPoint/mainOverloading.kt");
    }

    @Test
    @TestMetadata("mainOverloadingNoArgs.kt")
    public void testMainOverloadingNoArgs() {
      runTest("native/native.tests/testData/standalone/entryPoint/mainOverloadingNoArgs.kt");
    }
  }

  @Nested
  @TestMetadata("native/native.tests/testData/standalone/termination")
  @TestDataPath("$PROJECT_ROOT")
  @Tag("standalone")
  @EnforcedProperty(property = ClassLevelProperty.TEST_KIND, propertyValue = "STANDALONE_NO_TR")
  @UseStandardTestCaseGroupProvider()
  @Tag("frontend-fir")
  @FirPipeline()
  public class Termination {
    @Test
    public void testAllFilesPresentInTermination() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("native/native.tests/testData/standalone/termination"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("concurrentTerminate.kt")
    public void testConcurrentTerminate() {
      runTest("native/native.tests/testData/standalone/termination/concurrentTerminate.kt");
    }

    @Test
    @TestMetadata("exitProcess.kt")
    public void testExitProcess() {
      runTest("native/native.tests/testData/standalone/termination/exitProcess.kt");
    }

    @Test
    @TestMetadata("globalThrow.kt")
    public void testGlobalThrow() {
      runTest("native/native.tests/testData/standalone/termination/globalThrow.kt");
    }

    @Test
    @TestMetadata("mainThrow.kt")
    public void testMainThrow() {
      runTest("native/native.tests/testData/standalone/termination/mainThrow.kt");
    }

    @Test
    @TestMetadata("processUnhandledException.kt")
    public void testProcessUnhandledException() {
      runTest("native/native.tests/testData/standalone/termination/processUnhandledException.kt");
    }

    @Test
    @TestMetadata("terminateWithUnhandledException.kt")
    public void testTerminateWithUnhandledException() {
      runTest("native/native.tests/testData/standalone/termination/terminateWithUnhandledException.kt");
    }

    @Test
    @TestMetadata("unhandledException.kt")
    public void testUnhandledException() {
      runTest("native/native.tests/testData/standalone/termination/unhandledException.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionHookClosure.kt")
    public void testUnhandledExceptionHookClosure() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionHookClosure.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionHookFun.kt")
    public void testUnhandledExceptionHookFun() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionHookFun.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionHookGet.kt")
    public void testUnhandledExceptionHookGet() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionHookGet.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionHookTerminate.kt")
    public void testUnhandledExceptionHookTerminate() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionHookTerminate.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionHookTerminateWithProcess.kt")
    public void testUnhandledExceptionHookTerminateWithProcess() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionHookTerminateWithProcess.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionHookThrow.kt")
    public void testUnhandledExceptionHookThrow() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionHookThrow.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionHookWithProcess.kt")
    public void testUnhandledExceptionHookWithProcess() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionHookWithProcess.kt");
    }

    @Test
    @TestMetadata("unhandledExceptionInForeignThread.kt")
    public void testUnhandledExceptionInForeignThread() {
      runTest("native/native.tests/testData/standalone/termination/unhandledExceptionInForeignThread.kt");
    }
  }
}
