package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "//a[@title='साइन इन']")
    private static WebElement singInButton;

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

    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;

    @FindBy(id = "header-login-name")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(xpath = "//a[@title='साइन आउट']")
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

    @FindBy(xpath = "//span[text()='Try another way']")
    private static WebElement tryWithAnotherWayLink;

    @FindBy(xpath = "//div[text()='Enter one of your 8-digit backup codes']")
    private static WebElement backupCodeLink;

    @FindBy(id = "backupCodePin")
    private static WebElement backupInput;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement backupNextBtn;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 5, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 10, "Notification deny");
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
        commonFunctions.scrollToTop();
        commonFunctions.clickElement(userNameLabelAfterLogin, 45, "Display Name");
        commonFunctions.clickElement(singOutButton, 60, "Logout Button");
        logoutStatus = commonFunctions.isElementDisplayed(singInButton, 70, "Sign-In Button");
        return logoutStatus;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitialization();
        commonFunctions.refreshPage();
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(10);
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
        preSetInitialization();

        boolean isLoginSuccessful;
        commonFunctions.refreshPage();
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithActions(singInButton, 50, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "Email/Phone Button");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 20, "Password Textbox");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
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
            new com.pages.LiveHindustan.DesktopBrowserPages.LoginPage();
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
        preSetInitialization();
        commonFunctions.refreshPage();
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 25, "continue with Google button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email or phone box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 10, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "password box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 15, "next button");

        if(commonFunctions.isElementDisplayed(tryWithAnotherWayLink, 10)){
            commonFunctions.clickElement(tryWithAnotherWayLink, 10, "Try With Another Way Link");
            commonFunctions.dummyWait(3);
            commonFunctions.clickElementWithJS(backupCodeLink, 10, "Backup Code Link");
            commonFunctions.dummyWait(3);
            commonFunctions.sendKeyBoolean(backupInput, backupCodeWeb, 10, "Backup box");
            commonFunctions.dummyWait(3);
            commonFunctions.clickElement(backupNextBtn, 15, "next button");
        }
        commonFunctions.dummyWait(10);
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }
}
