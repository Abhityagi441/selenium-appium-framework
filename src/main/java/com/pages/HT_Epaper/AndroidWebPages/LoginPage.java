package com.pages.HT_Epaper.AndroidWebPages;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_Epaper.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {
    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static DriverController driverController;

    @FindBy(xpath = "//span[@id = 'right-sidebar-login']")
    private static WebElement singInButton;
    @FindBy(id = "toggle-sidebar-right")
    private static WebElement singInButtonAfter;
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
    @FindBy(id = "p-username")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(id = "flush-headingSix")
    private static WebElement LogoutButton;
    @FindBy(id = "generate_otp") //android.widget.TextView[@text='Generate OTP']
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
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "Accept Cookies");
        commonFunctions.clickElementIfDisplayed(skipButton, 10, "Skip button");
        driverController=DriverController.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        System.out.println("**************************************************");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        String SignInWindow;
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        commonFunctions.clickElement(singInButton, 10, "Sign-In Button");
        SignInWindow = driver.getWindowHandle();
        commonFunctions.clickElement(continueWithFacebookButton, 15, "Login with facebook Button");
        Set<String> allWindows = driver.getWindowHandles();
        for (String fbLoginWindow : allWindows) {
            if (!(fbLoginWindow.equals(SignInWindow))) {
                driver.switchTo().window(fbLoginWindow);
            }
        }
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "Email/Phone TextBox");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password TextBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "FB login Button");
        driver.switchTo().window(SignInWindow);
        commonFunctions.clickElement(singInButtonAfter, 20, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();
        commonFunctions.clickElement(singInButton, 10, "Sign-In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 10, "Google Login Button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 10, "Email Textbox");
        commonFunctions.clickElementWithActions(nextButtonGmailSignInPage, 10, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "Password Textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(nextButtonGmailPasswordPage, 10, "Next Button");
        commonFunctions.clickElementWithActions(singInButtonAfter, 20, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElementWithJS(singInButtonAfter, 35, "Sign-In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email/Phone TextBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithJS(continueButtonSignInPage, 10, "Continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password TextBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.clickElementWithJS(singInButtonAfter, 20, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {

        boolean isLoginSuccessful;
        String OTPPassword;
        ApiUtils utils = new ApiUtils();
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElement(singInButton, 35, "Sign-In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 10, "Generate OTP");
        OTPPassword = utils.getOTP(apiURI, auth, mode);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        for (int i = 0; i < OTPPassword.length(); i++) {
            System.out.println("OTP Digit: " + OTPPassword.charAt(i));
            commonFunctions.sendKey(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
        }
        commonFunctions.hideKeyboard();

        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage, 10, "Login Button");
        commonFunctions.clickElement(singInButtonAfter, 30, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }


    @Override
    public boolean logout() {
        boolean isUserSignedOut;
        commonFunctions.clickElementWithJS(LogoutButton, 35, "Logout");
        //commonFunctions.clickElementWithJS(singInButtonAfter, 30, "Sign-In Button");
        isUserSignedOut = commonFunctions.isElementDisplayed(singInButtonAfter, 25, "Email/Phone TextBox");
        return isUserSignedOut;
    }

    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}

