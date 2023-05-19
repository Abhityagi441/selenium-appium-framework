package com.pages.LiveHindustan.genericPages;

import com.pages.SSO.AbstractLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage extends AbstractLoginPage {
    private static CommonLoginPage commonLoginPage;


    public static CommonLoginPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        GlobalVars globalVars = GlobalVars.getInstance();
        if (commonLoginPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= com.pages.LiveHindustan.AMPPages.LoginPage.getInstance();
//                    break;
                case Constants.DESKTOP_WEB:
                    commonLoginPage = new com.pages.LiveHindustan.DesktopBrowserPages.LoginPage();
                    break;
                case Constants.ANDROID_AMP:
                case Constants.ANDROID_WEB:
                    commonLoginPage = new com.pages.LiveHindustan.android_mweb.LoginPage();
                    break;
                case Constants.IOS_WEB:
                    commonLoginPage = new com.pages.LiveHindustan.ios_mweb.LoginPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonLoginPage = new com.pages.LiveHindustan.AndroidNativePages.LoginPage();
                    break;
                case Constants.IOS_NATIVE:
                    //commonLoginPage= com.pages.LiveHindustan.IOSPages.LoginPage.getInstance();
                    break;
                case Constants.IOS_AMP:
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonLoginPage;
    }

    public static void resetCommonLoginPage() {
        commonLoginPage = null;
    }

    public abstract boolean loginWithGoogle(String email, String password, String expectedUserName);

    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName);

    public abstract boolean loginWithPassword(String email, String password, String expectedUserName);

    public abstract boolean loginWithAppleID(String email, String password, String expectedUserName);

    public abstract boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName);

    public abstract boolean logout();

    public abstract boolean loginWithGoogleAccount(String email, String password, String expectedUserName, String backupCodeWeb, String backupCodeAndroidWeb, String backupCodeIosWeb);
}
