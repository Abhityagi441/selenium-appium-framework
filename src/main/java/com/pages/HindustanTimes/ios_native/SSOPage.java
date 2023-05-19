package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonSSOPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;


public class SSOPage extends CommonSSOPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static MobileElement threeDots;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(id = "ht nav logo")
    private static MobileElement htLogo;

    @iOSXCUITFindBy(id="Home")
    private static MobileElement home;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get Personalised Experience']")
    private static MobileElement personalizedExperience;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Continue with Google']")
    private static MobileElement ssoOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@enabled='true']")
    private static MobileElement emailTextBoxMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Invalid phone number']")
    private static MobileElement invalidPhone;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Invalid Email']")
    private static MobileElement invalidEmail;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private static MobileElement passwordTextBoxMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
    private static MobileElement userNameLabelAfterLogin;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='profileBarButton']")
    private static MobileElement profileButton;

    @iOSXCUITFindBy(id = "Sign out")
    private static MobileElement LogoutButton;

    @iOSXCUITFindBy(id = "OK")
    private static MobileElement okButtonLogoutPopUp;

    @iOSXCUITFindBy(id = "Login")
    private static MobileElement loginInButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Forgot Password?']")
    private static MobileElement forgotPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Validate OTP']")
    private static MobileElement validateOTP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back new']")
    private static MobileElement back;

    @iOSXCUITFindBy(id = "Cancel")
    private static MobileElement cancel;

    public SSOPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(allowTracking,5,"Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 5, "notificationAllow");
    }

    public boolean checkInvalidSSOMobileEmail(String email, String mobile) {
        boolean ssoPageDisplayed =  commonFunctions.isElementDisplayed(ssoOption,5,"SSO Page Displayed");
        emailTextBoxMainSignInPage.clear();
        commonFunctions.sendKey(emailTextBoxMainSignInPage, mobile, 10, "email box");
        commonFunctions.clickElement(continueButton,5,"Continue Button");
        boolean invalidMobileMessage =  commonFunctions.isElementDisplayed(invalidPhone,5,"Invalid phone message");
        emailTextBoxMainSignInPage.clear();
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 5, "email box");
        commonFunctions.clickElement(continueButton,5,"Continue Button");
        boolean invalidEmailMessage =  commonFunctions.isElementDisplayed(invalidEmail,5,"Invalid email message");
        Utils.logStepInfo(true,"ssoPageDisplayed = "+ssoPageDisplayed);
        Utils.logStepInfo(true,"invalidMobileMessage = "+invalidMobileMessage);
        Utils.logStepInfo(true,"invalidEmailMessage = "+invalidEmailMessage);
        return ssoPageDisplayed && invalidMobileMessage && invalidEmailMessage;

    }
    public boolean checkLoginSuccessful(String email, String password, String expectedUserName) {
        commonFunctions.clickElement(continueButton,5,"Continue button");
        boolean ssoPageDisplayed =  commonFunctions.isElementDisplayed(ssoOption,5,"SSO Page Displayed");
        emailTextBoxMainSignInPage.clear();
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 5, "email box");
        commonFunctions.clickElement(continueButton,5,"Continue Button");
        boolean isValidPasswordEntered=commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 20, "password box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementIfDisplayed(continueButton,5,"Continue button");
        commonFunctions.clickElementIfDisplayed(cancel,5,"Apple Id cancel button");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");
        return ssoPageDisplayed&&isValidPasswordEntered;

    }
    @Override
    public boolean checkForgotPassword(String email) {
        boolean ssoPageDisplayed =  commonFunctions.isElementDisplayed(ssoOption,10,"SSO Page");
        emailTextBoxMainSignInPage.clear();
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 5, "email box");
        commonFunctions.clickElement(continueButton, 5, "continue button");
        commonFunctions.clickElement(forgotPassword, 5, "Forgot Password");
        boolean isForgotPasswordPage=commonFunctions.isElementDisplayed(validateOTP, 5,"Forgot Password Redirection Page");
        if(!isForgotPasswordPage){
            isForgotPasswordPage = commonFunctions.isElementDisplayed(forgotPassword,5,"Forgot Password link");
            Utils.logStepInfo(true,"OTP limit has been exceeded!!!");
        }
        for(int i=0;i<2;i++){
            commonFunctions.clickElementIfDisplayed(back, 5, "Back");
        }
        Utils.logStepInfo(true,"ssoPageDisplayed = "+ssoPageDisplayed);
        Utils.logStepInfo(true,"isForgotPasswordPage = "+isForgotPasswordPage);
        return ssoPageDisplayed && isForgotPasswordPage;
    }

    @Override
    public boolean logout() {
        boolean isUserSignedOut;
        commonFunctions.clickElement(home,5,"Home button");
        commonFunctions.clickElement(profileButton, 10, "profile icon");
        commonFunctions.scrollUntilElementFound(LogoutButton);
        commonFunctions.clickElement(LogoutButton, 10, "login button");
        commonFunctions.clickElement(okButtonLogoutPopUp, 20, "ok button logout popup");
        isUserSignedOut = commonFunctions.isElementDisplayed(loginInButton, 20, "loginInButton");
        return isUserSignedOut;
    }
}

