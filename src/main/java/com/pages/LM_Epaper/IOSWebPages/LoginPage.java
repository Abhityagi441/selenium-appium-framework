package com.pages.LM_Epaper.IOSWebPages;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LM_Epaper.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static DriverController driverController;

    @FindBy(xpath = "//span[@id = 'right-sidebar-login']/i")
    private static WebElement signInButton;

    @FindBy(id = "toggle-sidebar-right")
    private static WebElement singInButtonAfter;

    @FindBy(xpath = "//aside[@class='headerIcon']//a[3]")
    private static WebElement signInButtonLiveMintWebSite;

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

    @FindBy(xpath = "//a[text()='My Account']")
    private static WebElement myAccount;

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

    @FindBy(id = "m_login_email")
    private static WebElement emailOrPhoneFacebookSignInPage;

    @FindBy(id = "m_login_password")
    private static WebElement passwordFacebookSignInPage;

    @FindBy(xpath = "//button[@value='Log In']")
    private static WebElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailPasswordPage;

    @FindBy(xpath = "//div[@id='password']//input")
    private static WebElement passwordTextBoxGmailSignInPage;

    @FindBy(className = "user-name")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(id = "ancrMyFav1")
    private static WebElement logoutButton;

    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id = "verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(id = "close-btn-right")
    private static WebElement closeIconHamburger;

    @FindBy(id = "gdprContinue")
    private static WebElement acceptCookie;

    @FindBy(className = "skip_button")
    private static WebElement skipButton;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        driverController= DriverController.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 60, "acceptCookie");

    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(signInButton, 10, "Sign-In Button");
        String SignInWindow = commonFunctions.getWindowHandle();
        commonFunctions.clickElement(continueWithFacebookButton, 15, "Login with facebook Button");
        Set<String> allWindows = commonFunctions.getWindowHandles();
        for (String fbLoginWindow : allWindows) {
            if (!(fbLoginWindow.equals(SignInWindow))) {
                commonFunctions.switchToWindow(fbLoginWindow);
            }
        }
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "Email/Phone TextBox");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password TextBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "FB login Button");
        commonFunctions.switchToWindow(SignInWindow);
        commonFunctions.clickElement(singInButtonAfter, 20, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }


    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(signInButton, 10, "Sign-In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 10, "Google Login Button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 10, "Email Textbox");
        commonFunctions.clickElementWithActions(nextButtonGmailSignInPage, 10, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "Password Textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(nextButtonGmailPasswordPage, 10, "Next Button");
        commonFunctions.clickElement(singInButtonAfter, 60, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElementWithJS(signInButton,25,"SingIn Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 30, "Email/Phone TextBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 30, "Continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 60, "Password textBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 60, "Login Button");
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 60, "singInButtonLiveMintWebSite")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElement(signInButton, 60, "singInButtonLiveMintWebSite");
                break;
            }
        }
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        boolean isLoginSuccessful;
        String OTPPassword;
        ApiUtils utils = new ApiUtils();
        commonFunctions.navigateToHomePage();
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 60, "signInButton")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElement(signInButton, 60, "Sign-In Button");
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 60, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 60, "Continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 60, "Generate OTP");
        OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        for (int i = 0; i < OTPPassword.length(); i++) {
            System.out.println("OTP Digit: " + OTPPassword.charAt(i));
            commonFunctions.sendKey(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
        }
        commonFunctions.hideKeyboard();

        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage, 60, "Login Button");
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(singInButtonAfter, 60, "singInButtonAfter")) {
                System.out.println("Waiting for element to be present singInButtonAfter");
            } else {
                commonFunctions.clickElement(singInButtonAfter, 60, "User Profile");
                break;
            }
        }
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isUserSignedOut = false;
        commonFunctions.clickElement(logoutButton, 60, "Logout Button");
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButtonLiveMintWebSite, 60, "signInButton")) {
                System.out.println("Waiting for element to be present signInButtonLiveMintWebSite");
            } else {
                isUserSignedOut = commonFunctions.isElementDisplayed(signInButtonLiveMintWebSite, 60, "signInButton");
                break;
            }
        }
        return isUserSignedOut;
    }

    public static void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        new com.pages.LM_Epaper.IOSWebPages.LoginPage();
    }

    public static void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        new com.pages.LM_Epaper.IOSWebPages.LoginPage();
    }
}