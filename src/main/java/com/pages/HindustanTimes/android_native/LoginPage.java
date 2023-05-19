package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.ApiUtils;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonLoginPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;

    //@AndroidFindBy(id = "com.ht.news:id/onboardingSkip")
    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private static MobileElement hamBurger;

    @AndroidFindBy(id = "com.ht.news:id/ivProfile")
    private static MobileElement singInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private static MobileElement LoginInButton;

    @AndroidFindBy(id = "com.ht.news:id/google_btn")
    private static MobileElement continueWithGoogleButton;

    @AndroidFindBy(id = "com.ht.news:id/apple_btn")
    private static MobileElement continueWithAppleID;

    @AndroidFindBy(id = "com.ht.news:id/facebook_btn")
    private static MobileElement continueWithFacebookButton;

    @AndroidFindBy(id = "com.ht.news:id/et_email_or_mobile")
    private static MobileElement emailTextBoxMainSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/bt_continue")
    private static MobileElement continueButtonSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/et_password")
    private static MobileElement passwordTextBoxMainSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/bt_continue")
    private static MobileElement signInButtonMainSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/tv_forgetPassword")
    private static MobileElement forgotPassword;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(id = "com.ht.news:id/verifyBtn")
    private static MobileElement verifyOtpButton;

    @AndroidFindBy(xpath = "//div[text()='Use another account']")
    private static MobileElement useAnotherAccountGmailSignInPage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='identifierId']")
    private static MobileElement emailOrPhoneGmailSignInPage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone or Email'] ")
    private static MobileElement emailOrPhoneFacebookSignInPage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private static MobileElement passwordFacebookSignInPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN']")
    private static MobileElement loginButtonFacebookSignInPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    private static MobileElement continueButtonFacebookSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/text_profile")
    private static MobileElement profileOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Profile']/android.widget.ImageView")
    private static MobileElement profile;

    @AndroidFindBy(id = "com.ht.news:id/navigation_home_section")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.ht.news:id/profile")
    private static MobileElement profileButton;

    @AndroidFindBy(id = "com.ht.news:id/rounded_text")
    private static MobileElement initialOption;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Edit Profile']")
    private static MobileElement editProfile;

    @AndroidFindBy(id = "com.ht.news:id/txtViewName")
    private static MobileElement profileName;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    private static MobileElement nextButtonGmailSignInPage;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='passwordNext']")
    private static MobileElement nextButtonGmailPasswordPage;

    @AndroidFindBy(className = "android.widget.EditText")
    private static MobileElement passwordTextBoxGmailSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/tv_profileName")
    private static MobileElement userNameLabelAfterLogin;

    @AndroidFindBy(id = "com.ht.news:id/tv_signout")
    private static MobileElement signoutButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_signout")
    private static MobileElement LogoutButton;

    @AndroidFindBy(id = "com.ht.news:id/generate_otp_tv")
    private static MobileElement generateOtpMainSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/tv_generateOTP")
    private static MobileElement generateOtp;

    @AndroidFindBy(id = "com.ht.news:id/otpHeadingTv")
    private static MobileElement validateOtpPageHeader;

    @AndroidFindBy(id = "com.ht.news:id/resendOtpTv")
    private static MobileElement reGenerateOtpMainSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/verifyBtn")
    private static MobileElement verifyOTPButton;

    @AndroidFindBy(id = "android:id/button1")
    private static MobileElement yesButtonLogoutPopUp;

    @AndroidFindBy(id = "com.ht.news:id/ep_txt")
    private static MobileElement ePaperTextLabel;

    @AndroidFindBy(id = "com.ht.news:id/digitOneTv")
    private static MobileElement otpOne;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(id = "com.ht.news:id/tv_loginOrResister")
    private static MobileElement loginOrRegister;

    @AndroidFindBy(id = "com.ht.news:id/country_code_tv")
    private static MobileElement countryCode;

    @AndroidFindBy(id = "com.ht.news:id/tv_welcomeBack")
    private static MobileElement welcomeBackLoginUser;

    @AndroidFindBy(id = "com.ht.news:id/tv_editText")
    private static MobileElement editLoginUser;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement editUserProfilePageHeader;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private static MobileElement permissionDenyButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeter")
    private static MobileElement mayLaterButton;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Later Button");
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        commonFunctions.clickElementIfDisplayed(permissionDenyButton, 5, "Permission Deny Button");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(190, 1907);
        /*commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available
        */apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {

        boolean isLoginSuccessful = false;
        commonFunctions.clickElement(LoginInButton, 5, "Login Button");
        commonFunctions.clickElement(continueWithFacebookButton, 5, "Login with Facebook");
        commonFunctions.isElementDisplayed(emailOrPhoneFacebookSignInPage, 5, "EmailOrPhone");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 5, "EmailOrPhone");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 5, "Password");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 5, "FB Login Button");
//		commonFunctions.clickElement(continueButtonFacebookSignInPage,5,"Continue button");
        commonFunctions.clickElement(profileOption, 5, "profile option");
        commonFunctions.clickElement(editProfile, 5, "Edit Profile");
        String name = profileName.getText();
        if (name.equalsIgnoreCase(expectedUserName)) {
            isLoginSuccessful = true;
            Utils.logStepInfo(true, "Facebook login details that user entered previously is correct");
        }
        return isLoginSuccessful;
    }


    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
//        to be added for smooth login
        commonFunctions.toGetProfileButtonVisibleAndClick(profileButton,5);
        commonFunctions.clickElementIfDisplayed(mayLaterButton,5,"May be Latter");
        commonFunctions.clickElement(LoginInButton, 5, "Login Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 5, "emailOrPhone");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 15, "Password");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 5, "Sign-In Button");
        //commonFunctions.clickElement(profile, 5, "Profile");
        isLoginSuccessful = commonFunctions.getElementText(userNameLabelAfterLogin, 5).contains(expectedUserName);
        Utils.logStepInfo(true,"isLoginSuccessful = "+isLoginSuccessful);
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean forgotPassword(String email) {
//        commonFunctions.clickElement(homeButton, 30, "Home");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile");
        commonFunctions.clickElementIfDisplayed(mayLaterButton,5,"may be Latter");
        commonFunctions.clickElement(LoginInButton, 5, "Login Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 5, "emailOrPhone");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "Continue Button");
        commonFunctions.clickElement(forgotPassword, 5, "Forgot Password Button");
        boolean checkforgotPasswordRedirection = commonFunctions.isElementDisplayed(validateOtpPageHeader, 5, "Validate OTP Page Header");
        if(!checkforgotPasswordRedirection){
            checkforgotPasswordRedirection = commonFunctions.isElementDisplayed(forgotPassword,5,"Forget password Link");
            if(checkforgotPasswordRedirection) {
                Utils.logStepInfo(true, "Exceeded OTP limit so please try after 24 hours hence its passed!!!");
            }
        }
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "May Be Later Button");
        return checkforgotPasswordRedirection;
    }

    @Override
    public boolean forgotPasswordMobile(String mobile) {
        return false;
    }

    @Override
    public boolean validateOTPPage(String email) {
        boolean isValidateOtpPageDisplayed = true;
//        commonFunctions.clickElement(homeButton, 30, "Home");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile");
        commonFunctions.clickElementIfDisplayed(mayLaterButton,5,"may be Latter");
        commonFunctions.clickElement(LoginInButton, 5, "Login Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 5, "emailOrPhone");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "Continue Button");
        commonFunctions.clickElement(generateOtp, 5, "Generate Otp Button");
        commonFunctions.dummyWait(5);
        isValidateOtpPageDisplayed = commonFunctions.isElementDisplayed(validateOtpPageHeader, 5, "Validate Otp Page Header");
        return isValidateOtpPageDisplayed;
    }

    @Override
    public boolean generateOTP(String email) {
        return false;
    }


    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        boolean isLoginSuccessful;
        long date = System.currentTimeMillis();
        ApiUtils getOtp = new ApiUtils();
        commonFunctions.clickElement(hamBurger, 5, "Hamburger");
        commonFunctions.clickElement(LoginInButton, 5, "Login Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 5, "emailOrPhone");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "Continue Button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 5, "Generate OTP");
        String OTPPassword = getOtp.getOTP(apiURI, mode, auth);


        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        commonFunctions.sendKeyWithAction(OTPPassword, "OTP");
        commonFunctions.hideKeyboard();

        commonFunctions.clickElement(verifyOTPButton, 5, "Verify OTP Button");
        commonFunctions.clickElement(hamBurger, 5, "Hamburger");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 5, "UserName");
        return isLoginSuccessful;
    }


    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful = false;
        commonFunctions.clickElement(LoginInButton, 5, "Login Button");
        commonFunctions.clickElement(continueWithGoogleButton, 5, "Login with Google");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 5, "Email");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 5, "Next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 5, "Password");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(nextButtonGmailSignInPage, 5, "Next button");
        commonFunctions.isElementDisplayed(initialOption, 5, "Initial Option");
        String initial = initialOption.getText();
        commonFunctions.clickElement(profileOption, 5, "profile option");
        commonFunctions.clickElement(editProfile, 5, "profile option");
        String name = profileName.getText();
        if (name.equalsIgnoreCase(expectedUserName)) {
            isLoginSuccessful = true;
            Utils.logStepInfo(true, "Google login details that user entered previously is correct");
        }
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        commonFunctions.toGetProfileButtonVisibleAndClick(profileButton, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(LogoutButton,homeButton,3);
        commonFunctions.clickElement(LogoutButton, 5, "Logout Button");
        commonFunctions.clickElement(yesButtonLogoutPopUp, 5, "Yes popup button");
        commonFunctions.scrollUpToElementDisplayedWithCoordinates(LoginInButton);
        return commonFunctions.isElementDisplayed(LoginInButton, 5, "Sign-In Button");
    }

    @Override
    public boolean checkPasswordRedirection(String email, String password, String expectedUserName) {
        boolean isPasswordRedirection = true;
//        commonFunctions.clickElement(homeButton, 30, "Home");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile");
        commonFunctions.clickElementIfDisplayed(mayLaterButton,5,"may be Latter");
        commonFunctions.clickElement(LoginInButton, 5, "Login Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 5, "emailOrPhone");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 5, "Password");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 5, "Sign-In Button");
        //commonFunctions.clickElement(profile, 5, "Profile");
        isPasswordRedirection = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 30, "UserName");
        commonFunctions.scrollDownToElement(signoutButton,homeButton);
        commonFunctions.clickElement(signoutButton, 5, "User Sign Out Button");
        commonFunctions.clickElement(yesButtonLogoutPopUp, 5, "Sign Out Yes Button");
        return isPasswordRedirection;
    }

    @Override
    public boolean checkLoginOrRegisterPageDisplay() {
        boolean loginOrRegiserDisplay = true;
//        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElementIfDisplayed(mayLaterButton,5,"may be Latter");
        commonFunctions.clickElement(LoginInButton, 5, "Login button");
        loginOrRegiserDisplay &= commonFunctions.isElementDisplayed(loginOrRegister, 5, "Login or Register of Login page");
        Utils.logStepInfo("Verify Login or Register element text.");
        loginOrRegiserDisplay &= commonFunctions.getElementText(loginOrRegister, 5).contains("Login or Register");
        commonFunctions.pressAndroidBackKey();

        return loginOrRegiserDisplay;
    }

    @Override
    public boolean checkEditProfileRedirection() {
//        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile");
        commonFunctions.clickElementIfDisplayed(mayLaterButton,5,"may be Latter");
        boolean isUserDetailsDisplayed = commonFunctions.getElementText(welcomeBackLoginUser, 5).contains("Welcome back,");
        commonFunctions.clickElement(editLoginUser, 5, "Edit Option for logged in user");
        boolean isEditProfileDisplayed = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EDIT PROFILE");
        commonFunctions.pressAndroidBackKey();
        return isUserDetailsDisplayed && isEditProfileDisplayed;
    }

    @Override
    public boolean checkLoginOrRegisterPageDisplayBackRedirection() {
        boolean loginOrRegiserDisplay = true;
        boolean profilePageDisplay = true;
//        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElementIfDisplayed(mayLaterButton,5,"may be Latter");
        commonFunctions.clickElement(LoginInButton, 5, "Login button from Profile page");
        Utils.logStepInfo("Verify Login or Register element text.");
        loginOrRegiserDisplay &= commonFunctions.isElementDisplayed(loginOrRegister, 5, "Login or Register of Login page");
        loginOrRegiserDisplay &= commonFunctions.getElementText(loginOrRegister, 5).contains("Login or Register");
//        commonFunctions.pressAndroidBackKey();
        commonFunctions.toGetProfileButtonVisibleAndClick(profileButton,5);
        commonFunctions.clickElement(homeButton,5,"HT home Page");
        profilePageDisplay &= commonFunctions.isElementDisplayed(profileButton, 5, "Profile page");
        return loginOrRegiserDisplay && profilePageDisplay;
    }

    @Override
    public boolean checkCountryCodeAdded(String mobile) {
//        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(LoginInButton, 5, "Login button from Profile page");
        boolean loginOrRegiserDisplay = commonFunctions.isElementDisplayed(loginOrRegister, 5, "Login or Register of Login page");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, mobile, 5, "email box");
        boolean contryCodeVisible = commonFunctions.isElementDisplayed(countryCode, 5, "Country Code");
        contryCodeVisible &= commonFunctions.getElementText(countryCode, 5).contains("+91");
        commonFunctions.pressAndroidBackKey();

        return loginOrRegiserDisplay && contryCodeVisible;
    }

}
