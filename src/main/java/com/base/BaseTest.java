package com.base;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.listeners.TestListener;
import com.utils.*;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Set;

@Listeners(TestListener.class)
public class BaseTest {
    public static DataReader dataReader = null;
    private static DriverController driverController = null;
    private static GlobalVars globalVars;

    public static void instantiateClasses() {
        driverController = DriverController.getInstance();
        dataReader = DataReader.getInstance();
    }

    public static void initializeLoggingAndReporting() {
        Utils.initializeExtentReport();
        if (!globalVars.getIsBrowserStack()) {
            if (globalVars.getIsAutoStartAppium())
                AppiumServer.startServer();

        }
    }

    public static void tearDownSuite(ITestContext context) {
        if (!globalVars.getTestCaseListRunModeTrue().isEmpty()) {
            if (!globalVars.getIsBrowserStack()) {
                if (globalVars.getIsAutoStartAppium())
                    AppiumServer.stopServer();
            }
            driverController.closeDriver();
        }
    }

    public static void markTestResultOnBrowserStack(ITestContext context) {
        StringBuilder resultMessageFailTests = new StringBuilder();
        String resultFailTests = "";

        boolean failTestExists = !context.getFailedTests().getAllResults().isEmpty();
        if (failTestExists) {
            Set<ITestResult> testResults = context.getFailedTests().getAllResults();
            for (ITestResult result : testResults) {
                String msg = result.getThrowable().getMessage();
                if (msg != null) {
                    if (msg.contains("Build info:")) {
                        msg = msg.substring(0, msg.indexOf("Build info:"));
                    }
                    String exceptionName = result.getThrowable().toString();
                    exceptionName = exceptionName.substring(0, exceptionName.indexOf(":"));
                    String exceptionMessage = "Exception: " + exceptionName + " | Message: " + msg;

                    resultMessageFailTests.append(" || Test: ").append(result.getName()).append("| ").append(exceptionMessage);
                }
            }
            resultFailTests = resultMessageFailTests.toString().replaceFirst("||", "");
            System.out.println("Master message: " + resultFailTests);
        }
        Utils.markTestResultOnBrowserStack(resultFailTests, failTestExists);
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("******************* beforeSuite starts here *******************");
        globalVars = GlobalVars.getInstance();
        instantiateClasses();
        globalVars.setApplicationName(globalVars.getProjectName());
        if (globalVars.getIsBrowserStackLocal()) {
            BrowserStackLocal.bsLocalStart();
        }
        if (!globalVars.getTestCaseListRunModeTrue().isEmpty()) {
            driverController.initializeDriver();
            initializeLoggingAndReporting();
        }
        System.out.println("******************* beforeSuite ends here *******************");
    }

    @AfterSuite
    public void afterSuite(ITestContext iTestContext) {
        try {
            BaseTest.tearDownSuite(iTestContext);
            if (globalVars.getIsBrowserStackLocal()) {
                BrowserStackLocal.bsLocalStop();
            }
        } finally {
            Iterator<ITestResult> failedTestCases = iTestContext.getFailedTests().getAllResults().iterator();
            while (failedTestCases.hasNext()) {
                ITestResult failedTestCase = failedTestCases.next();
                ITestNGMethod method = failedTestCase.getMethod();
                if (iTestContext.getFailedTests().getResults(method).size() > 1) {
                    System.out.println("failed test case remove as dup:" + failedTestCase.getTestClass().toString());
                    failedTestCases.remove();
                } else if (iTestContext.getPassedTests().getResults(method).size() > 0) {
                    System.out.println("failed test case remove as pass retry:" + failedTestCase.getTestClass().toString());
                    failedTestCases.remove();
                }
            }
            try {
                AllureReport.removeUnknownTestCases();
            } catch (RuntimeException e) {
                System.out.println("Unable to remove unknown test cases from allure report due to :: ");
                e.printStackTrace();
            }
        }
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("===========BeforeTest Started-------------");
        driverController = DriverController.getInstance();
        driverController.initializeDriver();
        switch (globalVars.getPlatformName()) {
            case Constants.ANDROID_AMP:
            case Constants.IOS_AMP:
            case Constants.ANDROID_WEB:
            case Constants.IOS_WEB:
                CommonFunctionsMobile.getInstance();
                break;
            case Constants.DESKTOP_WEB:
                CommonFunctionsWeb.getInstance();
                break;
        }

        System.out.println("===========BeforeTest End-------------");
    }

    @AfterTest
    public void afterTest(ITestContext context) {
        System.out.println("===========AfterTest Started-------------");
        try {
            markTestResultOnBrowserStack(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driverController.closeDriver();
        System.out.println("===========AfterTest End-------------");
    }
}
