package com.pages.LM_Epaper.DesktopBrowserPages;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LM_Epaper.genericPages.CommonLoginPage;
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
    private static DriverController driverController;

    @FindBy(id = "Sign_In")
    private static WebElement singInButton;

    @FindBy(xpath = "//a[text()='Sign in']")
    private static WebElement mainWebsiteSignInButton;

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

    @FindBy(id = "LogoutId")
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

    @FindBy(className = "user-name")
    private static WebElement userNameInDocker;

    @FindBy(id = "toggle-sidebar-right")
    private static WebElement sidebarRight;

    @FindBy(id = "close-btn-right")
    private static WebElement closeButtonRight;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        driverController=DriverController.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();

        commonFunctions.clickElement(singInButton, 30, "Sign In Button");

        commonFunctions.clickElement(continueWithFacebookButton, 10, "Continue with Facebook Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 20, "email");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "Login Button");
        driver.switchTo().window(windowsList.get(0));
        commonFunctions.clickElement(sidebarRight, 55, "Right Side bar");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();

        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 25, "continue button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email of phone text box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 25, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 20, "password text box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 25, "next button");
        commonFunctions.clickElement(sidebarRight, 55, "user name label");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        //commonFunctions.navigateToHomePage();
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        commonFunctions.clickElement(singInButton, 10, "Sign-In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password");
        commonFunctions.clickElement(signInButtonMainSignInPage, 15, "Login Button");
        //commonFunctions.clickElement(sidebarRight, 55, "Right Side bar");
        commonFunctions.clickElementWithFluentWait(sidebarRight, 55, "Right Side bar");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName){
        boolean isLoginSuccessful;
        ApiUtils utils = new ApiUtils();
//        commonFunctions.navigateToHomePage();
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElement(singInButton, 30, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 30, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 20, "generate OTP button");
        commonFunctions.isElementDisplayedIgnoringStaleElement(OTPNotificationSentLabel, 15, "OTP notification sent label");
        String OTPPassword = utils.getOTP(apiURI,mode, auth);

            Utils.logStepInfo(true, "OTP: " + OTPPassword);
            for (int i = 0; i < OTPPassword.length(); i++) {
                System.out.println("OTP Digit: " + OTPPassword.charAt(i));
                commonFunctions.sendKey(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
            }

        commonFunctions.clickElement(verifyOTPToProceedButton, 30, "verify OTP to procees button");
        commonFunctions.clickElementWithFluentWait(sidebarRight, 55, "Right Side bar");
        isLoginSuccessful = commonFunctions.checkElementText(userNameInDocker, expectedUserName, 35, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElementWithActions(singOutButton, 45, "Logout button");
        isLogoutSuccessful = commonFunctions.isElementDisplayedReload(mainWebsiteSignInButton, 70, "Sign In");
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
