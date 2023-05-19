package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.ios_native.LoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage extends AbstractLoginPage {
    private static CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static CommonLoginPage getInstance(){
        System.out.println("******************* beforeMethod LoginPage starts here *******************");
        globalVars= GlobalVars.getInstance();
        if(commonLoginPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
//                    commonLoginPage= com.pages.LiveMint.AMPPages.LoginPage.getInstance();
                    break;
                case Constants.DESKTOP_WEB:
                    commonLoginPage = new com.pages.LiveMint.web.LoginPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonLoginPage = new com.pages.LiveMint.android_amp.LoginPage();
                    break;
                case Constants.IOS_AMP:
                    commonLoginPage = new com.pages.LiveMint.ios_amp.LoginPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonLoginPage = new com.pages.LiveMint.android_mweb.LoginPage();
                    break;
                case Constants.IOS_WEB:
                 commonLoginPage = new com.pages.LiveMint.ios_mweb.LoginPage();
                    break;
                case Constants.ANDROID_NATIVE:
                   commonLoginPage = new com.pages.LiveMint.android_native.LoginPage();
                    break;
                case Constants.IOS_NATIVE:
                   commonLoginPage= new LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod LoginPage ends here *******************");
        return commonLoginPage;
    }

    public abstract boolean loginWithGoogle(String email, String password, String expectedUserName);
    public abstract boolean loginWithPassword(String email, String password, String expectedUserName);
    public abstract boolean logout();
    public abstract boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName);
    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL);
    public abstract boolean loginWithAppleID(String email, String password, String expectedUserName);
    public abstract boolean checkSignInLinkRedirection();
    public abstract boolean loginWithNonSuscribedUser(String [] params);

    public abstract boolean loginWithPassword(String[] params);
    public abstract boolean verifyPlanDetails();
    public abstract boolean loginWithSubscribedUser(String email,String password,String expectedUserName);
    public abstract boolean loginWithNonSubscribedUser(String email,String password,String expectedUserName);

    public abstract boolean checkSubscribedUserLogin(String email, String password, String expectedUserName);
    public abstract boolean loginWithSubScribedUser(String [] params);
    public abstract boolean loginWithNonSubScribedUser(String [] params);

    public abstract boolean loginWithOTPSubScribedUser(String email, String apiURI, String accessAccount, String cookie, String refreshAPI, String expectedUserName);

    public abstract boolean loginWithOTPNonSubScribedUser(String email, String apiURI, String accessAccount, String cookie, String refreshAPI, String expectedUserName);

    public abstract boolean checkAllLoginOption();
}
