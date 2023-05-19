package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.LoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage extends AbstractLoginPage {
    private static com.pages.HindustanTimes.generic.CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static com.pages.HindustanTimes.generic.CommonLoginPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");
        globalVars= GlobalVars.getInstance();
        if(commonLoginPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
//                    commonLoginPage= com.pages.HindustanTimes.AMPPages.LoginPage.getInstance();
                    break;
                case Constants.DESKTOP_WEB:
                    commonLoginPage = new com.pages.HindustanTimes.web.LoginPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonLoginPage = new com.pages.HindustanTimes.android_amp.LoginPage();
                    break;
                case Constants.IOS_AMP:
                    commonLoginPage = new com.pages.HindustanTimes.ios_amp.LoginPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonLoginPage = new com.pages.HindustanTimes.android_mweb.LoginPage();
                    break;
                case Constants.IOS_WEB:
                    commonLoginPage = new com.pages.HindustanTimes.ios_mweb.LoginPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonLoginPage = new com.pages.HindustanTimes.android_native.LoginPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonLoginPage= new com.pages.HindustanTimes.ios_native.LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLoginPage;
    }

    public abstract boolean loginWithGoogle(String email, String password, String expectedUserName);
    public abstract boolean loginWithPassword(String email, String password, String expectedUserName);
    public abstract boolean logout();
    public abstract boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName);
    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName);
    public abstract boolean loginWithAppleID(String email, String password, String expectedUserName);
    public abstract boolean forgotPassword(String email);
    public abstract boolean forgotPasswordMobile(String mobile);

    public abstract boolean validateOTPPage(String email);
    public abstract boolean generateOTP(String email);

    public abstract boolean checkPasswordRedirection(String email, String password, String expectedUserName);
    public abstract boolean checkLoginOrRegisterPageDisplay();

    public abstract boolean checkEditProfileRedirection();

    public abstract boolean checkLoginOrRegisterPageDisplayBackRedirection();

    public abstract boolean checkCountryCodeAdded(String mobile);
}
