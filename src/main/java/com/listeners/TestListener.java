package com.listeners;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static GlobalVars globalVars;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        globalVars = GlobalVars.getInstance();
        Utils.renameExtentTest(iTestResult.getMethod().getMethodName());
        Utils.setAuthorInExtentReport(iTestResult);
        Utils.testInfo(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Utils.closeExtentTest();
        globalVars.setLastTestCasePass(true);
//        Log.endTestCase(iTestResult.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("*******************onTestFailure start*******************");
        //Log.endTestCase(iTestResult.getTestName());
        Utils.logFailedStepThrowableAndAddScreenshot(iTestResult.getThrowable(), iTestResult);
        Utils.closeExtentTest();

        if (globalVars.getPlatformName().equalsIgnoreCase(Constants.DESKTOP_WEB)) {
            CommonFunctionsWeb commonFunctions = CommonFunctionsWeb.getInstance();
            if (!globalVars.getProjectName().equalsIgnoreCase(Constants.BLANK_PAPER)) {
                commonFunctions.navigateToUrl(globalVars.getURL());
            }
        } else if (globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_WEB)
                || globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_WEB)
                || globalVars.getPlatformName().contains(Constants.ANDROID_AMP)
                || globalVars.getPlatformName().contains(Constants.IOS_AMP)) {
            CommonFunctionsMobile commonFunctions = CommonFunctionsMobile.getInstance();
            commonFunctions.deleteCookiesAndNavigateToHomePage();
        } else if (globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE)
                || globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
            DriverController driverController = DriverController.getInstance();
            driverController.closeDriver();
            driverController.initializeDriver();
        } else {
            CommonFunctionsMobile commonFunctions = CommonFunctionsMobile.getInstance();
            commonFunctions.navigateToHomePage();
        }

        globalVars.setLastTestCasePass(false);

//        try {
//            Utils.captureScreenshot(iTestResult);
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("*******************onTestFailure ends*******************");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.getCurrentXmlTest().getAllParameters();
        Utils.initializeExtentTest(iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        globalVars = GlobalVars.getInstance();
        globalVars.getTestCaseListRunModeTrue().remove(iTestContext.getName());
    }

}

