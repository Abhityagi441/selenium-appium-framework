package com.pages.LiveMint.AndroidWebPages;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {

    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static DriverController driverController;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(className = "userSignin")
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

    @FindBy(xpath = "//div[@id='uName']//strong")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(xpath = "//a[text()='Logout']")
    private static WebElement LogoutButton;

    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id = "verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(className = "closebtn")
    private static WebElement closeIconHamburger;

    @FindBy(xpath = "//a[@title='epaper']")
    private static WebElement epaperIcon;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        driverController=DriverController.getInstance();
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        String mainWindow = driver.getWindowHandle();
//        String urlVariable = globalVars.getEnvironment() + "Url";
//        driver.get(globalVars.getProp().getProperty(urlVariable));
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.clickElementWithActions(continueWithFacebookButton, 10, "Login with Facebook");
        Set<String> allWindows = commonFunctions.getWindowHandles();
        for (String fbLoginWindow : allWindows) {
            if (!fbLoginWindow.equals(mainWindow)) {
                commonFunctions.switchToWindow(fbLoginWindow);
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 20, "Email Text Box");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password Textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(loginButtonFacebookSignInPage, 10, "Login Button");
        commonFunctions.switchToWindow(mainWindow);
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
        }
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();
//        String urlVariable = globalVars.getEnvironment() + "Url";
//        driver.get(globalVars.getProp().getProperty(urlVariable));
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.clickElement(continueWithGoogleButton, 10, "Google Login Button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 10, "Email Textbox");
        commonFunctions.clickElementWithActions(nextButtonGmailSignInPage, 10, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "Password textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(nextButtonGmailPasswordPage, 10, "Next Button");
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
        }
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
//        String urlVariable = globalVars.getEnvironment() + "Url";
//        driver.get(globalVars.getProp().getProperty(urlVariable));
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        //TODO: remove this hard wait after getting it fixed.
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
        }
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
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
    public boolean loginWithNonSuscribedUser(String [] params) {
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

    @Override
    public  boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName){
    boolean isLoginSuccessful;
        ApiUtils utils = new ApiUtils();
//        String urlVariable = globalVars.getEnvironment() + "Url";
//        driver.get(globalVars.getProp().getProperty(urlVariable));
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 10, "Generate OTP");
        String OTPPassword = utils.getOTP(apiURI, mode, auth);
        Utils.logStepInfo(true, "OTP: " + OTPPassword);
        for (int i = 0; i < OTPPassword.length(); i++) {
            System.out.println("OTP Digit: " + OTPPassword.charAt(i));
            commonFunctions.sendKeyBoolean(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "", 5);
        }
        commonFunctions.hideKeyboard();

        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage,10,"Login Button");
        try

    {
        Thread.sleep(15000);
    }catch(
    Exception e)

    {
    }
        commonFunctions.clickElement(singInButton,10,"Sign In Button");
    isLoginSuccessful =commonFunctions.checkElementText(userNameLabelAfterLogin,expectedUserName,60,"UserName");
        return isLoginSuccessful;
}

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        return false;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElement(LogoutButton, 10, "Logout");
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(emailTextBoxMainSignInPage, 10, "Sign-In button");
        return isLogoutSuccessful;
    }

    public static void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        new com.pages.LiveMint.AndroidWebPages.LoginPage();
    }

    public static void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        new com.pages.LiveMint.AndroidWebPages.LoginPage();
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
