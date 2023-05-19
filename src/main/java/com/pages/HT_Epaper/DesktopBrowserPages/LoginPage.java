package com.pages.HT_Epaper.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_Epaper.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;
    @FindBy(id = "toggle-sidebar-right")
    private static WebElement singInButton;
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
    @FindBy(xpath = "//input[@type='submit']") //input[@value='Log In']
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
    @FindBy(id = "flush-headingSix")
    private static WebElement singOutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(id = "gdprContinue")
    private static WebElement acceptCookie;
    @FindBy(className = "skip_button")
    private static WebElement skipButton;
    @FindBy(className = "contentSec2")
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(id = "p-username")
    private static WebElement userNameInDocker;
    @FindBy(xpath = "//span[contains(@class,'ic_usermenu')]/i")
    private static WebElement mobileDocker;
    @FindBy(id = "toggle-sidebar-right")
    private static WebElement sidebarRight;
    @FindBy(id = "close-btn-right")
    private static WebElement closeButtonRight;
    @FindBy(id = "agree")
    private static WebElement continueButtonCookie;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        driver.switchTo().parentFrame();
        commonFunctions.switchToFrame("webpush-onsite");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 15, "notification deny");
        commonFunctions.switchToDefaultContent();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        commonFunctions.clickElementIfDisplayed(skipButton, 10, "skip button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        System.out.println("**************************************************");

    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;

        preSetInitializationForFaceBook();
        commonFunctions.clickElement(singInButton, 20, "sign in button");

        commonFunctions.clickElement(continueWithFacebookButton, 10, "Continue with Facebook Button");

        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "Email");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "Login Button");
        driver.switchTo().window(windowsList.get(0));
        commonFunctions.clickElement(userNameLabelAfterLogin, 30, "User Name After Login");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();
        commonFunctions.clickElement(singInButton, 30);
        commonFunctions.clickElement(continueWithGoogleButton, 25, "continue button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email of phone text box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 25, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 20, "password text box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 25, "next button");
        commonFunctions.clickElement(sidebarRight, 30, "user name label");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.clickElement(singInButton, 60, "Sign-In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Enter email or phone");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password");
        commonFunctions.clickElement(signInButtonMainSignInPage, 15, "Login Button");
        commonFunctions.clickElement(sidebarRight, 30, "Right Side bar");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        boolean isLoginSuccessful;
        long date = System.currentTimeMillis();
        ApiUtils utils = new ApiUtils();
        commonFunctions.clickElement(singInButton, 60, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "email text box");
        commonFunctions.clickElement(continueButtonSignInPage, 30, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 30, "generate OTP button");
        commonFunctions.isElementDisplayedIgnoringStaleElement(OTPNotificationSentLabel, 25, "OTP notification sent label");
        String OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        for (int i = 0; i < OTPPassword.length(); i++) {
            System.out.println("OTP Digit: " + OTPPassword.charAt(i));
            commonFunctions.sendKey(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
        }
        commonFunctions.clickElement(verifyOTPToProceedButton, 30, "verify OTP to procees button");

        if (mode.equals("mobile")) {

            commonFunctions.clickElementWithJS(sidebarRight, 35, "userNameLabelAfterLogin");
        } else {
            commonFunctions.clickElement(userNameLabelAfterLogin, 30, "user name label");
        }
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        String actualUserName = "";
        boolean isLoginSuccessful;
        commonFunctions.clickElement(singInButton, 60, "sign in button");

        commonFunctions.clickElement(continueWithAppleID, 30, "continue with apple button");

        commonFunctions.sendKeyBoolean(emailAppleSignInPage, email, 30, "email box");

        commonFunctions.clickElement(appleSignInNextButton, 30, "next button");
        commonFunctions.sendKeyBoolean(passwordAppleSignInPage, password, 30, "password box");

        commonFunctions.clickElement(appleSignInNextButton, 30, "next button");

        commonFunctions.clickElement(userNameLabelAfterLogin, 30, "user name label");


        actualUserName = commonFunctions.getElementText(userNameInDocker, 45);
        commonFunctions.clickElement(closeButtonRight, 10, "close icon");
        isLoginSuccessful = actualUserName.equalsIgnoreCase(expectedUserName);

        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        //commonFunctions.clickElementWithJS(singOutButton, 40, "Logout button");
        commonFunctions.clickElementWithActions(singOutButton, 40, "Logout button");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(singInButton, 70, "Sign In");
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
