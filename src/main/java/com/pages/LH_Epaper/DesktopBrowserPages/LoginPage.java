package com.pages.LH_Epaper.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LH_Epaper.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(className = "usermenu")
    private static WebElement signInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail")
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin")
    private static WebElement signInButtonMainSignInPage;
    @FindBy(xpath = "//div[text()='Use another account']")
    private static WebElement useAnotherAccountGmailSignInPage;
    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;
    @FindBy(id = "account_name_text_field")
    private static WebElement emailAppleSignInPage;
    @FindBy(id = "password_text_field")
    private static WebElement passwordAppleSignInPage;
    @FindBy(id = "sign-in")
    private static WebElement appleSignInNextButton;
    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;
    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;
    @FindBy(xpath = "//input[@type='submit']") //input[@name='login']
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(id = "user_name")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(id = "LogoutId")
    private static WebElement signOutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(xpath = "//a[@class='cookie_iagree']")
    private static WebElement acceptCookie;
    @FindBy(className = "skip_button")
    private static WebElement skipButton;
    @FindBy(className = "contentSec2")
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(className = "user-name")
    private static WebElement userNameInDocker;
    @FindBy(id = "toggle-sidebar-right")
    private static WebElement sidebarRight;
    @FindBy(id = "closeSubscription")
    private static WebElement closeButtonRight;
    @FindBy(id = "webklipper-publisher-widget-container-notification-close-div")
    private static WebElement closeAdBanner;
    @FindBy(xpath = "//iframe[contains(@name,'notification-frame')]")
    private static WebElement adBannerFrame;
    @FindBy(id="gdprContinue")
    private static WebElement continueBtn;
    @FindBy(className = "skip_button")
    private static WebElement skipBtn;
    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctions.clickElementIfDisplayed(continueBtn,60,"continueBtn");
        commonFunctions.clickElementIfDisplayed(skipBtn,60,"skipBtn");
        if (commonFunctions.switchToFrame(adBannerFrame, 20)) {
            commonFunctions.clickElementIfDisplayed(closeAdBanner, 15, "ad banner");
        }
        commonFunctions.clickElementIfDisplayed(acceptCookie, 15, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        commonFunctions.clickElement(signInButton, 45, "Sign In Button");
        commonFunctions.clickElement(continueWithFacebookButton, 10, "Facebook Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "email");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "Login Button");
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.clickElement(userNameLabelAfterLogin, 60, "UserName");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 45, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();
        commonFunctions.clickElement(signInButton, 35, "Sign In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 35, "continue with Google button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email or phone box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 10, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "password box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 15, "next button");
        commonFunctions.clickElementWithActions(userNameLabelAfterLogin, 50, "UserName");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.waitForPageLoad();
        commonFunctions.clickElement(signInButton, 45, "Sign-In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.clickElementWithActions(userNameLabelAfterLogin, 50, "UserName");
        //commonFunctions.clickElementWithFluentWait(userNameLabelAfterLogin, 50, "UserName");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 45, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        boolean isLoginSuccessful;
        ApiUtils utils = new ApiUtils();
        commonFunctions.waitForPageLoad();
        commonFunctions.clickElement(signInButton, 30, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 30, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "continue button");
        commonFunctions.clickElementReload(generateOtpMainSignInPage, 20, "generate OTP button");
        String OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        for (int i = 0; i < OTPPassword.length(); i++) {

            System.out.println("OTP Digit: " + OTPPassword.charAt(i));

            commonFunctions.sendKeyBoolean(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "",60,"OTPInputBoxList");
        }

        commonFunctions.clickElement(verifyOTPToProceedButton, 30, "verify OTP to procees button");
        commonFunctions.clickElementWithJS(userNameLabelAfterLogin, 55, "UserName");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 45, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElementReload(signOutButton, 60, "Logout button");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(signInButton, 70, "Sign In");
        return isLogoutSuccessful;
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
}