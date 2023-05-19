package com.pages.LM_Epaper.genericPages;

import com.pages.SSO.AbstractLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage extends AbstractLoginPage {
    private static CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static CommonLoginPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if(commonLoginPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonLoginPage = new com.pages.LM_Epaper.DesktopBrowserPages.LoginPage();
                    break;
                case Constants.ANDROID_AMP:
                case Constants.IOS_AMP:
                case Constants.ANDROID_WEB:
                    commonLoginPage= new com.pages.LM_Epaper.AndroidWebPages.LoginPage();
                    break;
                case Constants.IOS_WEB:
                    commonLoginPage= new com.pages.LM_Epaper.IOSWebPages.LoginPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLoginPage;
    }

    public abstract boolean loginWithGoogle(String email, String password, String expectedUserName);
    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName);
    public abstract boolean loginWithPassword(String email, String password, String expectedUserName);
    public abstract boolean loginWithAppleID(String email, String password, String expectedUserName);
    public abstract boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName);
    public abstract boolean logout();
}

