package com.base;

import com.utils.*;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.Set;

public abstract class DriverController {
    private static DriverController driverController =null;
    private static GlobalVars globalVars;

    public static DriverController getInstance(){
        globalVars=GlobalVars.getInstance();
        if(driverController ==null) {
            switch (globalVars.getPlatformName()){
                case Constants.ANDROID_NATIVE:
                case Constants.ANDROID_AMP:
                case Constants.ANDROID_WEB:
                    driverController =new AndroidBase();
                    break;
                case Constants.IOS_NATIVE:
                case Constants.IOS_AMP:
                case Constants.IOS_WEB:
                    driverController =new IOSBase();
                    break;
                case Constants.DESKTOP_WEB:
                    driverController =new DesktopBase();
                    break;
                default:
                    System.out.println("********** Incorrect Platform Name **********");
            }
        }
        return driverController;
    }

    public abstract void initializeDriver();
    public abstract void closeDriver();
    public abstract void navigateToApplicationHomePage(boolean deleteCookieFlag);

    public static GlobalVars setup(String param){
        return GlobalVars.getInstance();
    }
}
