package com.pages.HT_AUTO.genericPages;


import com.pages.HT_AUTO.DesktopBrowserPages.LoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage {
    private static CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static CommonLoginPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonLoginPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonLoginPage = new LoginPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonLoginPage= new com.pages.HT_AUTO.AndroidWebPages.LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLoginPage;
    }

    public abstract boolean loginWithMobileAndPassword(String mobile, String password, String expectedUserName);
    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName);
    public abstract boolean loginWithGoogleAndPassword(String email,String password,String expectedUserName) ;
    public abstract boolean logout();
}