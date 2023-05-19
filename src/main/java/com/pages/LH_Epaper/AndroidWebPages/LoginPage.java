package com.pages.LH_Epaper.AndroidWebPages;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LH_Epaper.genericPages.CommonLoginPage;
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

    @FindBy(xpath = "//span[@id='right-sidebar-login']/i")
    private static WebElement singInButton;
    @FindBy(xpath = "//span[@id='toggle-sidebar-right']/i")
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
    @FindBy(xpath = "//span[@id='ancrMyFav1']")
    private static WebElement LogoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(className = "closePopupAccount")
    private static WebElement closeIconHamburger;
    @FindBy(className = "cookie_iagree")
    private static WebElement acceptCookie;
    @FindBy(className = "skip_button")
    private static WebElement skipButton;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(xpath = "//span[@class='wewidgeticon we_close icon-large']")
    private static WebElement closeAdBanner;
    @FindBy(xpath = "//iframe[contains(@name,'notification-frame')]")
    private static WebElement adBannerFrame;
    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        driverController=DriverController.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 15, "Cookies Accept");
        driver.switchTo().parentFrame();
        commonFunctions.switchToFrame("webpush-onsite");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 15, "notification deny");
        commonFunctions.switchToDefaultContent();
        /*if (commonFunctions.switchToFrame(adBannerFrame, 60)) {
            commonFunctions.clickElementIfDisplayed(closeAdBanner, 15, "Close AdBanner");
            driver.switchTo().defaultContent();
        }*/
        commonFunctions.clickElementIfDisplayed(skipButton, 15,"Skip Button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        System.out.println("**************************************************");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(singInButton, 10, "Sign-In Button");
        String SignInWindow = driver.getWindowHandle();
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
        commonFunctions.clickElement(singInButtonAfter, 10, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        //commonFunctions.clickElement(closeIconHamburger, 10, "Close Hamburger");
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
        commonFunctions.clickElement(singInButtonAfter, 60, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        //commonFunctions.clickElement(closeIconHamburger, 10, "Close Hamburger");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        //commonFunctions.navigateToHomePage();
        //commonFunctions.clickElement(acceptCookie, 20);
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElementWithJS(singInButton, 30, "Sign-In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 30, "Email/Phone TextBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 40, "Password textBox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 20, "Login Button");
        commonFunctions.clickElementWithJS(singInButtonAfter, 60, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        //commonFunctions.clickElement(closeIconHamburger, 10, "Close Hamburger");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        boolean isLoginSuccessful;
        ApiUtils utils = new ApiUtils();
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(singInButton, 25, "Sign-In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 10, "Generate OTP");
        String OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        for (int i = 0; i < OTPPassword.length(); i++) {
            System.out.println("OTP Digit: " + OTPPassword.charAt(i));
            commonFunctions.sendKey(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
        }
        commonFunctions.hideKeyboard();

        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage, 10, "Login Button");
        commonFunctions.clickElement(singInButtonAfter, 30, "User Profile");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        //commonFunctions.clickElement(closeIconHamburger, 10, "Close Hamburger");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isUserSignedOut;
        //commonFunctions.clickElement(singInButtonAfter, 10, "User Profile Button");
        commonFunctions.clickElementWithJS(LogoutButton, 20, "Logout Button");
        isUserSignedOut = commonFunctions.isElementDisplayed(singInButton, 35, "Sign-In Button");
        return isUserSignedOut;
    }

    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
