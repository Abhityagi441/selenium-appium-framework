package com.pages.HindustanTimes.generic;

import com.pages.HindustanTimes.ios_native.SSOPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSSOPage {
    private static CommonSSOPage commonOtherPages;
    private static GlobalVars globalVars;

    public static CommonSSOPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonOtherPages==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    break;
                case Constants.ANDROID_AMP:
                    break;
                case Constants.IOS_AMP:
                     break;
                case Constants.ANDROID_WEB:
                    break;
                case Constants.IOS_WEB:
                    break;
                case Constants.ANDROID_NATIVE:
                    break;
                case Constants.IOS_NATIVE:
                    commonOtherPages= new SSOPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonOtherPages;
    }

    public abstract boolean checkInvalidSSOMobileEmail(String email, String mobile);
    public abstract boolean checkLoginSuccessful(String email, String password, String expectedUserName);
    public abstract boolean checkForgotPassword(String email);
    public abstract boolean logout();
}
