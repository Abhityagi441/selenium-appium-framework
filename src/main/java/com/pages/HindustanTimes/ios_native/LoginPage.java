package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.accessibility.Accessible;
import java.util.List;


public class LoginPage extends CommonLoginPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    //XCUIElementTypeButton[@name='Profile']
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='profileBarButton']")
    private static MobileElement profileButton;

    @iOSXCUITFindBy(id = "Login")
    private static MobileElement loginInButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Proceed')]")
    private static MobileElement verifyOtpToProceedButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Google')]")
    private static MobileElement continueWithGoogleButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueWithGoogleConfirmationPrompt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Facebook')]")
    private static MobileElement continueWithFacebookButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@enabled='true']")
    private static MobileElement emailTextBoxMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Email or Mobile Number']")
    private static MobileElement emailTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButtonSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private static MobileElement passwordTextBoxMainSignInPage;

    @iOSXCUITFindBy(xpath = "//div[text()='Use another account']")
    private static MobileElement useAnotherAccountGmailSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Email or phone']")
    private static MobileElement emailOrPhoneGmailSignInPage;

    @FindBy(name = "email")
    private static WebElement emailFB;

    @FindBy(name = "pass")
    private static WebElement passwordFB;

    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    private static List<MobileElement> fbLogin;

    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    private static MobileElement fbPassWord;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField") //m_login_email
    private static MobileElement emailOrPhoneFacebookSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField") //m_login_email
    private static List<MobileElement> otpTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private static MobileElement passwordFacebookSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeButton[@name='Log In']")
    private static MobileElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='लॉग इन करा']")
    private static WebElement loginFB;

    @iOSXCUITFindBy(id = "Next")
    private static MobileElement nextButtonGmailSignInPage;

    @iOSXCUITFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private static MobileElement nextButtonGmailPasswordPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Enter your password']")
    private static MobileElement passwordTextBoxGmailSignInPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Next'])[1]")
    private static MobileElement passwordNext;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText[2])[1]")
    private static MobileElement userNameLabelAfterLogin;

    @iOSXCUITFindBy(id = "Continue")
    private static List<MobileElement> continueButtonFacebookAfterUsernamePassword;

    //@iOSXCUITFindBy(id = "Sign out")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign out']")
    private static MobileElement LogoutButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'OTP')]")
    private static MobileElement generateOtpMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Resend')]")
    private static MobileElement reGenerateOtpMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Verify')]")
    private static MobileElement sigInWithOtpButtonMainSignInPage;

    @iOSXCUITFindBy(id = "OK")
    private static MobileElement okButtonLogoutPopUp;

    @iOSXCUITFindBy(id = "ht nav logo")
    private static MobileElement htLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Forgot Password?']")
    private static MobileElement forgotPassword;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Generate OTP'`]")
    private static MobileElement generateOTP;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Resend OTP'`]")
    private static MobileElement resendOTP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Validate OTP']")
    private static MobileElement validateOTP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You have exceeded otp limits. Please try after 24 hrs.']")
    private static MobileElement sentOTPMessage;

    @iOSXCUITFindBy(id = "back new")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
    private static MobileElement home;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Verify OTP to Proceed']")
    private static MobileElement verifyOTP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='00:25' or @value='00:20']")
    private static MobileElement timer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@enabled='true']")
    private static List<MobileElement> enterOTPBox;

    @iOSXCUITFindBy(id = "Welcome back,")
    private static MobileElement userDetails;

    @iOSXCUITFindBy(id = "Edit")
    private static MobileElement editProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='EDIT PROFILE']")
    private static MobileElement editProfilePage;

    @iOSXCUITFindBy(id = "Login or Register")
    private static MobileElement loginOrRegister;

    @iOSXCUITFindBy(id = "ACCOUNT")
    private static MobileElement profilePage;

    @iOSXCUITFindBy(id = "+91")
    private static MobileElement countryCode;

    @iOSXCUITFindBy(accessibility = "Profile")
    private static MobileElement profileButton1;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[@name='Turn On Siri']")
    private static MobileElement siriAllow;

    @iOSXCUITFindBy(id = "Profile")
    private static MobileElement profileOption;

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    @iOSXCUITFindBy(id = "Cancel")
    private static MobileElement cancel;

    @iOSXCUITFindBy(id="Quickreads")
    private static MobileElement quickReads;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='India']")
    private static MobileElement india;

    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement exploreButton;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(siriAllow,3, "Siri Allow");
        commonFunctions.clickElementIfDisplayed(allowTracking,5,"Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 5, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(continueButton,3,"Continue Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,5,"Later Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,5,"Later Button in Language Selection");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");
    }


    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {

        boolean clickLogin=commonFunctions.clickElement(loginInButton, 10, "login button");
        Utils.logStepInfo(clickLogin,"Clicked on login");
        boolean clickFB =commonFunctions.clickElement(continueWithFacebookButton, 10, "continue with facebook button");
        Utils.logStepInfo(clickFB,"Clicked on Facebook");
        boolean clickContinueFB=commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        Utils.logStepInfo(clickContinueFB,"clicked continue button");
        boolean isFormDisplayed=commonFunctions.isElementDisplayed(fbLogin.get(0),10,"Login form");
        Utils.logStepInfo(isFormDisplayed,"Login form displayed");
        commonFunctions.sendKey(fbLogin.get(0), email, 20, "email or phone text box");
        commonFunctions.sendKey(fbPassWord, password, 20, "password text box");

        boolean loginFaceB=commonFunctions.clickElement(loginFB, 20, "login button");
        Utils.logStepInfo(loginFaceB,"Clicked on login facebook");
        boolean continueFB=commonFunctions.clickElement(continueButtonFacebookAfterUsernamePassword.get(2), 10, "continue button");
        Utils.logStepInfo(continueFB,"Clicked on continue FB");
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"HT logo on home page");
        Utils.logStepInfo(htLgo, "Successfully landed on homepage");
        boolean clickProfileIcon=commonFunctions.clickElement(profileButton, 10, "profile icon");
        Utils.logStepInfo(clickProfileIcon,"Click on profile icon");
        boolean isUserDisplayed = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "userNameLabelAfterLogin");
        return isUserDisplayed;
    }


    @Override
    public boolean logout() {
        boolean isUserSignedOut;
        commonFunctions.clickElement(home,5,"Home button");
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Icon")){
            commonFunctions.clickElement(quickReads,5,"QuickReads");
        }
        commonFunctions.clickElement(profileButton, 10, "profile icon");
        commonFunctions.scrollToBottomOniOSNative();
        commonFunctions.clickElement(LogoutButton, 10, "login button");
        commonFunctions.clickElement(okButtonLogoutPopUp, 20, "ok button logout popup");
        isUserSignedOut = commonFunctions.isElementDisplayed(loginInButton, 20, "loginInButton");
        return isUserSignedOut;
    }

    @Override
    public boolean  loginWithGoogle(String email, String password, String expectedUserName) {

        boolean clickLogin=commonFunctions.clickElement(loginInButton, 10, "login button");
        Utils.logStepInfo(clickLogin,"Clicked on login");
        boolean continueGoogle=commonFunctions.clickElement(continueWithGoogleButton, 10, "continue with google button");
        Utils.logStepInfo(continueGoogle,"Clicked on continue with google");
        boolean clickContinueFB=commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        Utils.logStepInfo(clickContinueFB,"clicked continue button");
        boolean emailField= commonFunctions.isElementDisplayed(emailOrPhoneGmailSignInPage,10,"email field");
        Utils.logStepInfo(emailField,"email field is displayed");
        commonFunctions.sendKey(emailOrPhoneGmailSignInPage, email, 10, "email or phone text box");
        commonFunctions.hideKeyboard();
        boolean clickNext=commonFunctions.clickElement(nextButtonGmailSignInPage, 10, "next button");
        Utils.logStepInfo(clickNext,"Click next button");
        commonFunctions.sendKey(passwordTextBoxGmailSignInPage, password, 10, "password text field");
        commonFunctions.hideKeyboard();
        boolean clickPassNext=commonFunctions.clickElement(passwordNext,10,"Next");
        Utils.logStepInfo(clickPassNext,"Click on next password");
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"HT logo on home page");
        Utils.logStepInfo(htLgo, "Successfully landed on homepage");
        boolean clickProfileIcon=commonFunctions.clickElement(profileButton, 10, "profile icon");
        Utils.logStepInfo(clickProfileIcon,"Click on profile icon");
        boolean isUserDisplayed=commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 20, "userNameLabelAfterLogin");
        return isUserDisplayed;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton, 10, "Profile");
        commonFunctions.clickElementIfDisplayed(mayBeLater,5,"MayBe Latter");
        commonFunctions.clickElement(loginInButton, 10, "login button");
        String emailBoxText=commonFunctions.getElementText(emailTextBox);
        if (emailBoxText.contains("Email or Mobile Number"))
            Utils.logStepInfo(true,"Text \"Email or Mobile Number\" is displayed ");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 10, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 8, "continue button");
        boolean isValidPasswordEntered=commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "password box");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(continueButtonSignInPage, 8, "continue button");
        commonFunctions.clickElementIfDisplayed(cancel,5,"cancel Button");
        commonFunctions.clickElementIfDisplayed(continueButton,5,"Apple id continueButton");
        commonFunctions.clickElementIfDisplayed(cancel,5,"Apple id Cancel");
        commonFunctions.dummyWait(5);
        System.out.println("user Value showing - " + userNameLabelAfterLogin.getText());
        if (!userNameLabelAfterLogin.getText().contains(expectedUserName)){
            System.out.println("Expected value is --- " + expectedUserName);
            String actualValue = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+expectedUserName+"']")).getText();
            System.out.println("Actual Value is --- " +actualValue);
            isLoginSuccessful = actualValue.contains(expectedUserName);
        }
        else {
            isLoginSuccessful = commonFunctions.getElementText(userNameLabelAfterLogin,10).contains(expectedUserName);//checkElementText(userNameLabelAfterLogin, expectedUserName, 20, "user name");
        }
        return isValidPasswordEntered && isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        boolean isLoginSuccessful;
        ApiUtils getOtp;
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton, 20, "Profile");
        commonFunctions.clickElementIfDisplayed(mayBeLater,5,"MayBe Latter");
        commonFunctions.clickElement(loginInButton, 35, "login button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 20, "email text box");
        commonFunctions.clickElement(continueButton, 20, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 20, "generate OTP button");
        getOtp = new ApiUtils();
        String otpPassword = getOtp.getOTP(apiURI, mode, auth);
            for (int i = 0; i < otpPassword.length(); i++) {

                commonFunctions.sendKey(otpTextField.get(i), otpPassword.charAt(i) + "", 20, "otpTextField");
                //commonFunctions.sendKeyBoolean(otpTextField.get(i), otpPassword.charAt(i) + "", 20, "otpTextField");
                commonFunctions.hideKeyboard();
            }

        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage, 20, "sign in with OTP button");
        commonFunctions.clickElement(profileButton, 20, "profile icon");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 20, "user name label");
        return isLoginSuccessful;
    }
    @Override
    public boolean forgotPassword(String email) {
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton, 5, "Profile");
        commonFunctions.clickElementIfDisplayed(mayBeLater,5,"MayBe Latter");
        commonFunctions.clickElement(loginInButton, 5, "login button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 10, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 8, "continue button");
        commonFunctions.clickElement(forgotPassword, 8, "Forgot Password");
        boolean isForgotPasswordPage=commonFunctions.isElementDisplayed(validateOTP, 10,"Forgot Password Redirection Page");
        if(!isForgotPasswordPage){
            isForgotPasswordPage = commonFunctions.isElementDisplayed(forgotPassword,5,"Forget Passowrd Link");
            if(isForgotPasswordPage) {
                Utils.logStepInfo(true, "Exceeded OTP limit so please try after 24 hours hence its passed!!!");
            }
        }
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isForgotPasswordPage;
    }

    @Override
    public boolean forgotPasswordMobile(String mobile) {
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton, 20, "Profile");
        commonFunctions.clickElementIfDisplayed(mayBeLater,10,"MayBe Latter");
        commonFunctions.clickElement(loginInButton, 30, "login button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, mobile, 20, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 20, "continue button");
        commonFunctions.clickElement(forgotPassword, 20, "Forgot Password");
        boolean isForgotPasswordPage=commonFunctions.isElementDisplayed(validateOTP, 10,"Forgot Password Redirection Page");
        if(!isForgotPasswordPage){
            isForgotPasswordPage = commonFunctions.isElementDisplayed(forgotPassword,5,"Forget Passowrd Link");
            if(isForgotPasswordPage) {
                Utils.logStepInfo(true, "Exceeded OTP limit so please try after 24 hours hence its passed!!!");
            }
        }
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isForgotPasswordPage;
    }

    @Override
    public boolean generateOTP(String email) {
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton, 20, "Profile");
        commonFunctions.clickElementIfDisplayed(mayBeLater,10,"MayBe Latter");
        commonFunctions.clickElement(loginInButton, 35, "login button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 20, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 8, "continue button");
        commonFunctions.clickElement(generateOTP,  10,"Generate OTP");
        boolean isForgotPasswordPage=commonFunctions.isElementDisplayed(validateOTP, 10,"Generate OTP Redirection Page");
        if(!isForgotPasswordPage){
            isForgotPasswordPage = commonFunctions.isElementDisplayed(forgotPassword,5,"Forget Passowrd Link");
            if(isForgotPasswordPage) {
                Utils.logStepInfo(true, "Exceeded OTP limit so please try after 24 hours hence its passed!!!");
            }
        }
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isForgotPasswordPage;
    }

    @Override
    public boolean checkPasswordRedirection(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean checkLoginOrRegisterPageDisplay() {
        return false;
    }

    @Override
    public boolean validateOTPPage(String email) {
        boolean isResendOtpEnabled = false;
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton, 5, "Profile");
        commonFunctions.clickElementIfDisplayed(mayBeLater,10,"MayBe Latter");
        commonFunctions.clickElement(loginInButton, 5, "login button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 20, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 8, "continue button");
        if(commonFunctions.isElementDisplayed(validateOTP,5,"Validate OTP Page")){
            isResendOtpEnabled = commonFunctions.isElementDisplayed(resendOTP, 5, "Resend OTP");
            for (int j = 0; j < 5; j++) {
                commonFunctions.sendKey(enterOTPBox.get(j), "1", 5, "email box");
            }
        }
        else if(!commonFunctions.isElementDisplayed(generateOTP,5,"Generate OTP")){
            isResendOtpEnabled = commonFunctions.isElementDisplayed(continueButtonSignInPage,5,"Continue Button in SignIn Page");
            if(isResendOtpEnabled) {
                Utils.logStepInfo(true, "***** Getting message as Exceeded OTP limit so please try after 24 hours hence its passed!!! *****");
            }
        }
        else {
            commonFunctions.clickElementIfDisplayed(generateOTP, 5, "Generate OTP");
            //boolean isTimerDisplayed=commonFunctions.isElementDisplayed(timer, 10,"Timer");
            commonFunctions.dummyWait(20);
            boolean isTimerDisplayedNow = commonFunctions.isElementNotDisplayed(timer, 10, "Timer");
            if (isTimerDisplayedNow) {
                isResendOtpEnabled = commonFunctions.isElementDisplayed(resendOTP, 5, "Resend OTP");
            }
            if (!isResendOtpEnabled) {
                isResendOtpEnabled = commonFunctions.isElementDisplayed(generateOTP, 5, "Generate OTP Link");
                if (isResendOtpEnabled) {
                    Utils.logStepInfo(true, "***** Getting message as Exceeded OTP limit so please try after 24 hours hence its passed!!! *****");
                }
            }
            for (int j = 0; j < 5; j++) {
                commonFunctions.sendKey(enterOTPBox.get(j), "1", 5, "email box");
            }
        }
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isResendOtpEnabled;
    }
    @Override
    public boolean checkEditProfileRedirection() {
        boolean isEditProfileRedirectionSuccessful;
        //commonFunctions.clickElement(profileButton, 20, "Profile");
        boolean isUserDetailsDisplayed=commonFunctions.isElementDisplayed(userDetails, 10, "User Details");
        commonFunctions.clickElement(editProfile, 20, "Edit Option");
        boolean isEditProfileDisplayed=commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        commonFunctions.clickElement(back, 20, "Go back");
        return isUserDetailsDisplayed&&isEditProfileDisplayed;
    }
    @Override
    public boolean checkLoginOrRegisterPageDisplayBackRedirection() {
        boolean loginOrRegiserDisplay=true;
        boolean profilePageDisplay=true;
        commonFunctions.clickElement(home,10,"Home button");
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton,10,"Profile button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,10,"MayBe Latter");
        commonFunctions.clickElement(loginInButton,10,"Login button");
        loginOrRegiserDisplay &=commonFunctions.isElementDisplayed(loginOrRegister,10,"Login or Register of Login page");
        Utils.logStepInfo("Verify Login or Register element text.");
        loginOrRegiserDisplay &=commonFunctions.getElementText(loginOrRegister,10).contains("Login or Register");
        commonFunctions.clickElement(back,10,"Back button");
        profilePageDisplay &=commonFunctions.isElementDisplayed(profilePage,10,"Profile page");
        return loginOrRegiserDisplay&&profilePageDisplay;
    }
    @Override
    public boolean checkCountryCodeAdded(String mobile) {
        boolean loginOrRegiserDisplay=true;
        boolean profilePageDisplay=true;
        commonFunctions.clickElement(home,10,"Home button");
        if(!commonFunctions.isElementDisplayed(profileButton,5,"Profile Button")){
            commonFunctions.clickElement(exploreButton,5,"Explore Button");
        }
        commonFunctions.clickElement(profileButton,10,"Profile button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,10,"MayBe Latter");
        commonFunctions.clickElement(loginInButton,10,"Login button");
        loginOrRegiserDisplay &=commonFunctions.isElementDisplayed(loginOrRegister,10,"Login or Register of Login page");
       commonFunctions.sendKey(emailTextBoxMainSignInPage, mobile, 20, "email box");
        loginOrRegiserDisplay &=commonFunctions.isElementDisplayed(countryCode,10,"Country Code");
        commonFunctions.clickElement(back,10,"Back button");
        return loginOrRegiserDisplay&&profilePageDisplay;
    }
}
