package com.listeners;


import com.base.DriverController;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        GlobalVars globalVars = GlobalVars.getInstance();

        if(!globalVars.getProjectName().equalsIgnoreCase(Constants.BLANK_PAPER)) {
            if (!iTestResult.isSuccess()) {                      //Check if test not succeed
                int maxTry = 1;
                if (count < maxTry) {                            //Check if maxtry count is reached
                    count++;                                     //Increase the maxTry count by 1
                    iTestResult.setStatus(ITestResult.FAILURE);
                    (new TestListener()).onTestFailure(iTestResult);//Mark test as failed
                    DriverController driverController = DriverController.getInstance();
                    driverController.navigateToApplicationHomePage(true);
                    return true;                                 //Tells TestNG to re-run the test
                } else {
                    iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
                }
            } else {
                iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
            }
        }
        return false;
    }

}
