package com.pages.LiveHindustan.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "//span[@id='show-header-login']")
    private static WebElement singInButton;

    @FindBy(xpath = "//div[@class='hdr-lft']/span")
    private static WebElement hamburgerMenuButton;

    @FindBy(id = "customBtn") //img[@id='customBtn']
    private static WebElement continueWithGoogleButton;

    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;

    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;

    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;

    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;

    @FindBy(id = "btnLogin") //login
    private static WebElement signInButtonMainSignInPage;

    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;

    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;

    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;

    @FindBy(xpath = "//input[@type='submit']") //input[@value='Log In']
    private static WebElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;

    @FindBy(xpath = "//input[@name='password']")
    private static WebElement passwordTextBoxGmailSignInPage;

    //    @FindBy(id = "//span[@id='isLoginUser']")
    @FindBy(xpath = "//a[@id='hamburger-login-name']")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//i[@id='hamburger-close-icon']")
    private static WebElement hamburgerCloseButton;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(xpath = "//div[@id='myDropdown']")
    private static WebElement singOutButton;

    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement OTPNotificationSentLabel;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;

    @FindBy(xpath = "//button[@id='deny']")
    private static WebElement notificationDeny;

    @FindBy(id = "agree")
    private static WebElement continueButtonCookie;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(xpath = "//span[text()='Try another way' or contains(text(), 'Andere Option')]")
    private static WebElement tryWithAnotherWayLink;

    @FindBy(xpath = "//div[text()='Enter one of your 8-digit backup codes' or contains(text(), 'Back-up-Codes')]")
    private static WebElement backupCodeLink;

    @FindBy(id = "backupCodePin")
    private static WebElement backupInput;

    @FindBy(xpath = "(//button[@type ='button']/span)[1]")
    private static WebElement backupNextBtn;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        commonFunctions.clickElement(singInButton, 45, "Sign In Button");

        commonFunctions.clickElement(continueWithFacebookButton, 25, "Sign in with FaceBook Button");

        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "Email/Phone Textbox");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password TextBox");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "Login Button");
        commonFunctions.switchToWindow(windowsList.get(0));
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean logoutStatus;
        commonFunctions.clickElement(hamburgerMenuButton, 10, "Hamburger menu on HT home page");
        commonFunctions.clickElement(userNameLabelAfterLogin, 45, "Display Name");
        commonFunctions.clickElement(singOutButton, 60, "Logout Button");
        commonFunctions.isElementDisplayed(hamburgerMenuButton, 20, "Hamburger menu");
        commonFunctions.clickElement(hamburgerMenuButton, 20, "Hamburger menu on HT home page");
        logoutStatus = commonFunctions.isElementDisplayed(singInButton, 70, "Sign-In Button");
        commonFunctions.clickElement(hamburgerCloseButton, 10, "Hamburger close button");
        return logoutStatus;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        //preSetInitializationForGoogle();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(hamburgerMenuButton, 10, "Hamburger menu on HT home page");
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 25, "continue with Google button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email or phone box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 10, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "password box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 15, "next button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
//        preSetInitialization();

        boolean isLoginSuccessful;
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(hamburgerMenuButton, 10, "Hamburger menu on HT home page");
        commonFunctions.clickElement(singInButton, 35, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "Email/Phone Button");
        commonFunctions.clickElement(continueButtonSignInPage, 40, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 20, "Password Textbox");
        commonFunctions.clickElement(signInButtonMainSignInPage, 20, "Login Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(hamburgerMenuButton, 35, "Hamburger menu on HT home page");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        commonFunctions.clickElement(hamburgerCloseButton, 10, "Hamburger close button");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        boolean isLoginSuccessful;
        ApiUtils utils = new ApiUtils();
        commonFunctions.clickElement(singInButton, 30, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 30, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 30, "generate OTP button");
        commonFunctions.isElementDisplayedIgnoringStaleElement(OTPNotificationSentLabel, 30, "OTP notification sent label");
        String OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        for (int i = 0; i < OTPPassword.length(); i++) {
            System.out.println("OTP Digit: " + OTPPassword.charAt(i));
            commonFunctions.sendKey(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
        }

        commonFunctions.clickElement(verifyOTPToProceedButton, 30, "verify OTP to process button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    public static void preSetInitialization() {
        //commonFunctions.deleteCookiesAndNavigateToHomePage();
        if (!commonFunctions.presetHomePage(singInButton)) {
            new LoginPage();
        }
    }

    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean loginWithGoogleAccount(String email, String password, String expectedUserName, String backupCodeWeb, String backupCodeAndroidWeb, String backupCodeIosWeb){
        boolean isLoginSuccessful;
        //preSetInitializationForGoogle();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(hamburgerMenuButton, 10, "Hamburger menu on HT home page");
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 25, "continue with Google button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email or phone box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 10, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "password box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 15, "next button");
        if(commonFunctions.isElementDisplayed(tryWithAnotherWayLink, 10)){
            commonFunctions.clickElement(tryWithAnotherWayLink, 10, "Try With Another Way Link");
            commonFunctions.clickElement(backupCodeLink, 10, "Backup Code Link");
            commonFunctions.sendKeyBoolean(backupInput, backupCodeAndroidWeb, 10, "Backup box");
            commonFunctions.clickElement(backupNextBtn, 15, "next button");
        }
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(hamburgerMenuButton, 10, "Hamburger menu on HT home page");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        commonFunctions.clickElement(hamburgerCloseButton, 10, "Hamburger close button");
        return isLoginSuccessful;
    }
}
