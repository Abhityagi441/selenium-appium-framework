package com.pages.Subscription.LiveMint.genericPages;


import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLoginPage{
    private static CommonLoginPage commonLoginPage;
    private static GlobalVars globalVars;

    public static CommonLoginPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");
        commonLoginPage=null;
        globalVars= GlobalVars.getInstance();
        if(commonLoginPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.DESKTOP_WEB:
                    commonLoginPage = new com.pages.Subscription.LiveMint.web.LoginPage();
                    break;
                default:
                    try {
                        throw new Exception("Incorrect platform name or Platform does not exist");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLoginPage;
    }

    public abstract void signinUsingOTP(String email);

    public abstract boolean loginWithGoogle(String email, String password, String expectedUserName);
    public abstract boolean loginWithPassword(String email, String password, String expectedUserName);
    public abstract boolean logout();
    public abstract boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName);
    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL);
    public abstract boolean loginWithAppleID(String email, String password, String expectedUserName);
    public abstract boolean checkSignInLinkRedirection();
    public abstract boolean loginWithNonSuscribedUser(String [] params);
    public abstract boolean loginWithFacebook(String email, String password, String expectedUserName) ;


    public abstract boolean loginWithPassword(String[] params);
    public abstract boolean verifyPlanDetails();
    public abstract boolean loginWithSubscribedUser(String email,String password,String expectedUserName);
    public abstract boolean loginWithNonSubscribedUser(String email,String password,String expectedUserName);

    public abstract boolean checkSubscribedUserLogin(String email, String password, String expectedUserName);

    public abstract void loginWithPasswordfromHomePage(String s, String s1, String ram);

    public abstract void signupWithOTP(String Emailfirstpart);

    public abstract void SignupUsingAPI(String email);

    public abstract void signUpUsingOTPAPI(String email);

    public abstract String fetchOTP(String email, String OtpAPI, String accessAccount);

    public abstract boolean enterLoginTextBox(String email);

    public abstract boolean clickContinueButton();

    public abstract boolean enterOTP(String OTP);

    public abstract boolean isLoginPageTextPresent();

    public abstract boolean isOTPBox1Present();

    public abstract void refreshOtpLimit(String email, String OtpRefreshAPI, String accessAccount);

    public abstract boolean clickDoThisLater();

    public abstract boolean enterOTPwithRefresh(String email, String otpRefreshAPI, String otpAPI, String accessAccount);

    public abstract boolean fetchOTPandType(String email, String OtpAPI, String accessAccount);

    public abstract boolean facebookLogin(String emailOrPhone , String password );
}
