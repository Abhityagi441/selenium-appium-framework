package com.pages.LiveMint.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.*;
import org.apache.poi.ss.formula.functions.T;
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

    @FindBy(className = "userSignin")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin") //login
    private static WebElement signInButtonMainSignInPage;
    @FindBy(xpath = "//div[text()='Use another account']")
    private static WebElement useAnotherAccountGmailSignInPage;
    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;
    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;
    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;
    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "//div[@id='uName']//strong")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "//div[@id='myAccount']/a[text()='Logout']")
    private static WebElement LogoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement OTPNotificationSentLabel;
    @FindBy(xpath = "//a[text()='My Account']")
    private static WebElement MyAccount;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();
        commonFunctions.clickElement(singInButton, 10, "Sign-In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 10, "continue with Google button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email or phone box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 10, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "password box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 15, "next button");
        commonFunctions.clickElement(MyAccount, 20, "My Account Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }


    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();

        commonFunctions.clickElement(singInButton, 45, "Sign In Button");

        commonFunctions.clickElement(continueWithFacebookButton, 45, "Sign in with FaceBook Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "Email/Phone TextBox");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "Login Button");
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.clickElement(MyAccount, 55, "My Account Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        preSetInitialization();

        boolean isLoginSuccessful;
        commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email/Phone Button");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password text box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.clickElement(MyAccount, 45, "My Account Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        boolean isLoginSuccessful;
        ApiUtils utils = new ApiUtils();
        commonFunctions.clickElement(singInButton, 60, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 30, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 20, "generate OTP button");
        commonFunctions.isElementDisplayedIgnoringStaleElement(OTPNotificationSentLabel, 15, "OTP notification sent label");
        String OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
            for (int i = 0; i < OTPPassword.length(); i++) {
                System.out.println("OTP Digit: " + OTPPassword.charAt(i));
                commonFunctions.sendKey(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
            }

        commonFunctions.clickElement(verifyOTPToProceedButton, 30, "verify OTP to process button");
        commonFunctions.clickElement(MyAccount, 20, "My Account Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        return false;
    }

    @Override
    public boolean logout() {
        boolean logoutStatus;
        commonFunctions.clickElement(LogoutButton, 60, "Logout button");
        logoutStatus = commonFunctions.isElementDisplayed(singInButton, 70, "Sign In");
        return logoutStatus;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean checkSignInLinkRedirection() {
        return false;
    }

    @Override
    public boolean loginWithNonSuscribedUser(String[] params) {
        return false;
    }
    @Override
    public boolean loginWithPassword(String[] params) {
        return false;
    }

    @Override
    public boolean verifyPlanDetails() {
        return false;
    }

    @Override
    public boolean loginWithSubscribedUser(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithNonSubscribedUser(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean checkSubscribedUserLogin(String email, String password, String expectedUserName) {
        return false;
    }


    public static void preSetInitialization() {
        //commonFunctions.deleteCookiesAndNavigateToHomePage();
        if(!commonFunctions.presetHomePage(singInButton)) {
            new com.pages.LiveMint.DesktopBrowserPages.LoginPage();
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
    public boolean loginWithSubScribedUser(String[] params) {
        return false;
    }

    @Override
    public boolean loginWithNonSubScribedUser(String[] params) {
        return false;
    }

    @Override
    public boolean loginWithOTPSubScribedUser(String email, String apiURI, String accessAccount, String cookie, String refreshAPI, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTPNonSubScribedUser(String email, String apiURI, String accessAccount, String cookie, String refreshAPI, String expectedUserName) {
        return false;
    }

    @Override
    public boolean checkAllLoginOption() {
        return false;
    }


}
