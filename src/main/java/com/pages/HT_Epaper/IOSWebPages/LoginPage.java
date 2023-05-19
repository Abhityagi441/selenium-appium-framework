package com.pages.HT_Epaper.IOSWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_Epaper.genericPages.CommonLoginPage;
import com.utils.*;
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

    @FindBy(id = "toggle-sidebar-right")
    private static WebElement signInButton;

    @FindBy(id = "//div[@class='nav_action_bar']/span[3]/span[2]")
    private static WebElement singInButtonAfter;

    @FindBy(id = "customBtn")  //android.widget.Image[@text='Google']  //accessibility = "Google"
    private static WebElement continueWithGoogleButton;

    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;

    @FindBy(id = "fbmBtn") //android.widget.Image[@text='Facebook']
    private static WebElement continueWithFacebookButton;

    @FindBy(id = "phoneEmail")  //uemail  //android.widget.EditText[@resource-id='uemail']
    private static WebElement emailTextBoxMainSignInPage;

    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;

    @FindBy(id = "upass")  //android.widget.EditText[@resource-id='upass']
    private static WebElement passwordTextBoxMainSignInPage;

    @FindBy(id = "btnLogin") //login //android.widget.Button[@resource-id='login']
    private static WebElement signInButtonMainSignInPage;

    @FindBy(xpath = "//div[text()='Use another account']")
    private static WebElement useAnotherAccountGmailSignInPage;

    @FindBy(id = "identifierId") //android.widget.EditText[@resource-id='identifierId']
    private static WebElement emailOrPhoneGmailSignInPage;

    @FindBy(id = "account_name_text_field")
    private static WebElement emailAppleSignInPage;

    @FindBy(id = "password_text_field")
    private static WebElement passwordAppleSignInPage;

    @FindBy(id = "sign-in")
    private static WebElement appleSignInNextButton;

    @FindBy(id = "m_login_email") //#email
    private static WebElement emailOrPhoneFacebookSignInPage;

    @FindBy(id = "m_login_password") //#pass
    private static WebElement passwordFacebookSignInPage;

    @FindBy(xpath = "//button[@value='Log In']")
    private static WebElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailPasswordPage;

    @FindBy(xpath = "//div[@id='password']//input")
    private static WebElement passwordTextBoxGmailSignInPage;

    ////android.view.View[@content-desc="Htdigital Qa"]
    @FindBy(id = "p-username")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(id = "flush-headingSix")
    private static WebElement logoutButton;

    @FindBy(id = "generate_otp") //android.widget.TextView[@text='Generate OTP']
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id = "verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(id = "close-btn-right") ////div[contains(@class,'closeNav')]/i
    private static WebElement closeIconHamburger;

    @FindBy(id = "gdprContinue")
    private static WebElement acceptCookie;

    @FindBy(className = "skip_button")
    private static WebElement skipButton;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 60, "acceptCookie");
        commonFunctions.clickElementIfDisplayed(skipButton, 60, "skipButton");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        String SignInWindow;
        boolean isLoginSuccessful;
        commonFunctions.clickElementWithJS(signInButton, 60, "Sign-In Button");
        SignInWindow = commonFunctions.getWindowHandle();
        commonFunctions.clickElement(continueWithFacebookButton, 60, "Login with facebook Button");
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
        commonFunctions.clickElement(signInButton, 30, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        // preSetInitializationForGoogle();
        commonFunctions.clickElementWithJS(signInButton, 10, "Sign-In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 10, "Google Login Button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 10, "Email Textbox");
        commonFunctions.clickElementWithActions(nextButtonGmailSignInPage, 10, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "Password Textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(nextButtonGmailPasswordPage, 10, "Next Button");
        commonFunctions.clickElementWithActions(signInButton, 20, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful = false;
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 10, "signInButton")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElementWithJS(signInButton, 10, "Sign-In Button");
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password TextBox");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 10, "signInButton")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElement(signInButton, 10, "signInButton");
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementDisplayed(userNameLabelAfterLogin, 10, "userNameLabelAfterLogin")) {
                System.out.println("Waiting for element to be present userNameLabelAfterLogin");
            } else {
                isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "userNameLabelAfterLogin");
                break;
            }
        }
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName){

        boolean isLoginSuccessful;
        String OTPPassword;
        ApiUtils utils = new ApiUtils();
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 60, "Sign-In Button")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElement(signInButton, 60, "Sign-In Button");
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 60, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 60, "Continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 60, "Generate OTP");
        OTPPassword = utils.getOTP(apiURI,auth,mode);
            Utils.logStepInfo(true, "OTP: " + OTPPassword);
            for (int i = 0; i < OTPPassword.length(); i++) {
                System.out.println("OTP Digit: " + OTPPassword.charAt(i));
                commonFunctions.sendKeyBoolean(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "", 60);
            }

        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage, 60, "Login Button");
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 60, "signInButton")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElement(signInButton, 60, "signInButton");
                break;
            }
        }
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 120, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isUserSignedOut = false;
        commonFunctions.clickElement(logoutButton, 60, "Logout");
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 60, "signInButton")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                isUserSignedOut = commonFunctions.isElementEnabled(signInButton, 60, "signInButton");
                break;
            }
        }
        return isUserSignedOut;
    }

    public static void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        new com.pages.HT_Epaper.IOSWebPages.LoginPage();
    }

    public static void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        new com.pages.HT_Epaper.IOSWebPages.LoginPage();
    }
}