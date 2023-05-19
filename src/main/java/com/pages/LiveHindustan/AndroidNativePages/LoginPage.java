package com.pages.LiveHindustan.AndroidNativePages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Date;

public class LoginPage extends CommonLoginPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private static MobileElement hamBurger;

    @AndroidFindBy(id = "com.ht.news:id/ivProfile")
    private static MobileElement singInButton;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/ivProfile")
    private static MobileElement SignInButton;

    @AndroidFindBy(id = "com.ht.news:id/google_btn")
    private static MobileElement continueWithGoogleButton;

    @AndroidFindBy(id = "com.ht.news:id/apple_btn")
    private static MobileElement continueWithAppleID;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/facebook_btn")
    private static MobileElement continueWithFacebookButton;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/email_or_mobile_et")
    private static MobileElement emailTextBoxMainSignInPage;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/continue_btn")
    private static MobileElement continueButtonSignInPage;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/password_et")
    private static MobileElement passwordTextBoxMainSignInPage;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/continue_btn")
    private static MobileElement signInButtonMainSignInPage;

    @AndroidFindBy(xpath = "//div[text()='Use another account']")
    private static MobileElement useAnotherAccountGmailSignInPage;

    @AndroidFindBy(className = "android.widget.EditText")
    private static MobileElement emailOrPhoneGmailSignInPage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone or Email']")
    private static MobileElement emailOrPhoneFacebookSignInPage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private static MobileElement passwordFacebookSignInPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log In']")
    private static MobileElement loginButtonFacebookSignInPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private static MobileElement nextButtonGmailSignInPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private static MobileElement nextButtonGmailPasswordPage;

    @AndroidFindBy(className = "android.widget.EditText")
    private static MobileElement passwordTextBoxGmailSignInPage;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/name")
    private static MobileElement userNameLabelAfterLogin;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    private static MobileElement continueButtonFacebookAfterUsernamePassword;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/txtLogout")
    private static MobileElement LogoutButton;

    @AndroidFindBy(id = "com.hindustan.hindinews:id/generate_otp_tv")
    private static MobileElement generateOtpMainSignInPage;

    @AndroidFindBy(id ="com.hindustan.hindinews:id/resendOtpTv")
    private static MobileElement reGenerateOtpMainSignInPage;

    @AndroidFindBy(id="com.hindustan.hindinews:id/verifyBtn")
    private static MobileElement verifyOTPButton;

    @AndroidFindBy(className="crossicon")
    private static MobileElement closeIconHamburger;

    @AndroidFindBy(id="android:id/button1")
    private static MobileElement yesButtonLogoutPopUp;

    @AndroidFindBy(id="com.ht.news:id/ep_txt")
    private static MobileElement ePaperTextLabel;

    @AndroidFindBy(id = "com.htmedia.mint:id/action_profile")
    private static MobileElement profileButton;

    @AndroidFindBy(id = "android:id/button1")
    private static MobileElement logoutconfirmation;

    @AndroidFindBy(accessibility = "Navigate up")
    private static MobileElement backButton;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.clickElement(SignInButton, 10, "Sign-In button");
        commonFunctions.clickElement(continueWithFacebookButton, 10, "Login with Facebook");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "email TextBox");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "password TextBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "FB login button");
        commonFunctions.clickElement(SignInButton, 30, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isUserSignedOut;
        commonFunctions.clickElement(LogoutButton, 60, "Logout Button");
        commonFunctions.clickElement(logoutconfirmation, 40, "Logout confirmation");
        commonFunctions.clickElement(SignInButton, 60, "Sign-In Button");
        isUserSignedOut = commonFunctions.isElementDisplayed(emailTextBoxMainSignInPage, 70, "Email/Phone TextBox");
        commonFunctions.clickElement(backButton, 20, "Back Button");
        return isUserSignedOut;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.clickElement(SignInButton, 80, "Sign-In button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 80, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 60, "Password Textbox");
        commonFunctions.clickElement(signInButtonMainSignInPage, 60, "Sign-In button");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(SignInButton, 80, "Profile Icon");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 70, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        boolean isLoginSuccessful;
        ApiUtils utils = new ApiUtils();
        commonFunctions.clickElement(SignInButton, 70, "Sign-In button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 60, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 30, "Continue Button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 60, "Generate OTP");
        String OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
            commonFunctions.sendKeyWithAction(OTPPassword, "OTP");
            commonFunctions.hideKeyboard();

        commonFunctions.clickElement(verifyOTPButton, 20, "Verify OTP Button");
        commonFunctions.clickElement(SignInButton, 70, "Profile Icon");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 50, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.clickElement(SignInButton, 60, "Login Button");
        commonFunctions.clickElement(continueWithGoogleButton, 60, "Login with Google");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 60, "Email");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 60, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 60, "Password");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 60, "Next Button");
        commonFunctions.clickElement(SignInButton, 60, "Hamburger");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogleAccount(String email, String password, String expectedUserName, String backupCodeWeb, String backupCodeAndroidWeb, String backupCodeIosWeb){
        return false;
    }

}

