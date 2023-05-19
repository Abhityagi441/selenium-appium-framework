package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @FindBy(xpath = "//div[@class='btnExplore']//span")
    private static WebElement hamBurger;

    @FindBy(xpath = "//a[@class='acorIn']")
    private static MobileElement signInButton;

    @FindBy(xpath = "//a[@data-vars-event-label='India News']")
    private static WebElement indiaNews;

    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;

    @FindBy(xpath = "//button[@value='Continue']")
    private static WebElement continueLoginButton;

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

    @FindBy(id = "userName2")
    private static WebElement hamburgerUsername;

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


    @FindBy(xpath = "//button[@value='Log In' or @value='लॉग इन करा' or @value='Masuk']")
    private static WebElement loginButtonFacebookSignInPage;
//    @FindBy(id = "email")
//    private static WebElement emailOrPhoneFacebookSignInPage;
//
//    @FindBy(id = "pass")
//    private static WebElement passwordFacebookSignInPage;
//
//    @FindBy(name = "login")
//    private static WebElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "(//div[@class='VfPpkd-RLmnJb'])[1]")
    private static WebElement nextButtonGmailSignInPage;

    @FindBy(xpath = "(//div[@class='VfPpkd-RLmnJb'])[1]")
    private static WebElement nextButtonGmailPasswordPage;

    @FindBy(xpath = "//div[@id='password']//input")
    private static WebElement passwordTextBoxGmailSignInPage;

    @FindBy(xpath = "//section//div[@class='logged-in']//span[2]")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(xpath = "(//a[@class='sign-out'])[2]")
    private static WebElement LogoutButton;

    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id ="reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id="verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(className="crossicon")
    private static WebElement closeIconHamburger;

    @FindBy(xpath = "//a[@title='epaper']")
    private static WebElement epaperIcon;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
//        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {

        boolean isUserRedirectedToSamePageAfterLogin = false;
        boolean isUsernameDisplayed = false;
        String mainWindow;
        preSetInitializationForFaceBook();
        commonFunctions.clickElement(hamBurger, 10, "Hamburger");
        commonFunctions.clickElement(indiaNews, 45, "india news");
        String beforeLoginCheckURL = commonFunctions.getCurrentURL("India news section", "URL");
        mainWindow = driver.getWindowHandle();
        commonFunctions.clickElement(hamBurger, 10, "Hamburger");
        commonFunctions.clickElement(signInButton, 120, "Sign In Button");
        Set<String> allWindows = commonFunctions.getWindowHandles();
        for(String loginWindow: allWindows){
            if(!loginWindow.equals(mainWindow)){
                commonFunctions.switchToWindow(loginWindow);
                break;
            }
        }
        String SignInWindow = commonFunctions.getWindowHandle();
        commonFunctions.clickElement(continueWithFacebookButton, 10, "Login with Facebook");
        allWindows = commonFunctions.getWindowHandles();
        for (String fbLoginWindow : allWindows) {
            if (!(fbLoginWindow.equals(SignInWindow)) & !(fbLoginWindow.equals(mainWindow))) {
                commonFunctions.switchToWindow(fbLoginWindow);
                break;
            }
        }
        String loginURL = commonFunctions.getCurrentURL("FaceBook Login Page", "URL");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 20, "Email Text Box");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password Textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "Login Button");
        boolean isButtonDisplayed = commonFunctions.isElementDisplayed(continueLoginButton, 10, "Continue button");
        if (isButtonDisplayed == true) {
            commonFunctions.clickElement(continueLoginButton, 10, "Continue button");
        } else {
            Utils.logStepInfo("Continue button may not available");
        }
        commonFunctions.switchToWindow(mainWindow);
        try {
            Thread.sleep(5000);
        }catch (Exception e){}
        String afterLoginCheckURL = commonFunctions.getCurrentURL("current URL", "URL");
        if (beforeLoginCheckURL.equalsIgnoreCase(afterLoginCheckURL) && (!afterLoginCheckURL.equalsIgnoreCase(loginURL))) {
            isUserRedirectedToSamePageAfterLogin = true;
        }
        Utils.logStepInfo(isUserRedirectedToSamePageAfterLogin, "User redirected to the same page after login successful");
        commonFunctions.clickElementIgnoringStaleElementReferenceException(hamBurger, 20, "Hamburger");
        String user = commonFunctions.getElementText(hamburgerUsername, 10);
        if (user.equalsIgnoreCase(expectedUserName)) {
            isUsernameDisplayed = true;
        }
        return isUserRedirectedToSamePageAfterLogin && isUsernameDisplayed;
//        commonFunctions.isElementDisplayed(epaperIcon, 20, "Epaper Icon");
//        commonFunctions.clickElement(hamBurger, 20, "Hamburger");
//        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
//        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isUserRedirectedToSamePageAfterLogin = false;
        boolean isUsernameDisplayed = false;
        String mainWindow;
        //        preSetInitializationForGoogle();
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        commonFunctions.clickElementWithJS(indiaNews, 20, "india news section");
        String beforeSignInURL = commonFunctions.getCurrentURL("india news section", "URL");
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        mainWindow = driver.getWindowHandle();
        commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        Set<String> allWindows = commonFunctions.getWindowHandles();
        for (String loginWindow : allWindows) {
            if (!loginWindow.equals(mainWindow)) {
                commonFunctions.switchToWindow(loginWindow);
                break;
            }
        }
        commonFunctions.clickElement(continueWithGoogleButton, 10, "Google Login Button");
        String googleLoginURL = commonFunctions.getCurrentURL("Google login URL","URL");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 10, "Email Textbox");
        commonFunctions.clickElementWithJS(nextButtonGmailSignInPage, 10, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "Password textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithJS(nextButtonGmailPasswordPage, 10, "Next Button");
        commonFunctions.switchToWindow(mainWindow);
        try {
            Thread.sleep(5000);
        }catch (Exception e){}
        String afterLoginURL = commonFunctions.getCurrentURL("Current URL", "URL");
        if (beforeSignInURL.equalsIgnoreCase(afterLoginURL) && (!afterLoginURL.equalsIgnoreCase(googleLoginURL))) {
            isUserRedirectedToSamePageAfterLogin = true;
        }
        commonFunctions.clickElementWithActions(hamBurger, 20, "Hamburger");
        isUsernameDisplayed = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 20, "UserName");
        return isUsernameDisplayed && isUserRedirectedToSamePageAfterLogin;
    }





    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        String mainWindow;
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        mainWindow = driver.getWindowHandle();
        commonFunctions.clickElementWithJS(signInButton, 10, "Sign In Button");
        Set<String> window = commonFunctions.getWindowHandles();
        for(String loginWindow: window){
            if(!loginWindow.equals(mainWindow)){
                commonFunctions.switchToWindow(loginWindow);
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithJS(continueButtonSignInPage, 10, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithJS(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.switchToWindow(mainWindow);
        try {
            Thread.sleep(5000);
        }catch (Exception e){}
        commonFunctions.isElementDisplayed(epaperIcon, 20, "Epaper Icon");
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean forgotPassword(String email) {
        return false;
    }

    @Override
    public boolean forgotPasswordMobile(String mobile) {
        return false;
    }

    @Override
    public boolean validateOTPPage(String email) {
        return false;
    }

    @Override
    public boolean generateOTP(String email) {
        return false;
    }

    @Override
    public boolean checkPasswordRedirection(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean checkLoginOrRegisterPageDisplay() {
        return false;
    }

    @Override
    public boolean checkEditProfileRedirection() {
        return false;
    }

    @Override
    public boolean checkLoginOrRegisterPageDisplayBackRedirection() {
        return false;
    }

    @Override
    public boolean checkCountryCodeAdded(String mobile) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        boolean isLoginSuccessful;
        String mainWindow;
        ApiUtils getOtp = new ApiUtils();
        commonFunctions.clickElement(hamBurger, 20, "Hamburger");
        mainWindow = driver.getWindowHandle();
        commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        Set<String> window = commonFunctions.getWindowHandles();
        for (String loginWindow : window) {
            if (!loginWindow.equals(mainWindow)) {
                commonFunctions.switchToWindow(loginWindow);
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 10, "Generate OTP");
        String OTPPassword = getOtp.getOTP(apiURI, mode, auth);

            Utils.logStepInfo(true, "OTP: " + OTPPassword);
            for (int i = 0; i < OTPPassword.length(); i++) {
                System.out.println("OTP Digit: " + OTPPassword.charAt(i));
                commonFunctions.sendKeyBoolean(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "", 5);
            }
            commonFunctions.hideKeyboard();

        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage, 10, "Login Button");
        commonFunctions.switchToWindow(mainWindow);
        try {
            Thread.sleep(5000);
        }catch (Exception e){}
        commonFunctions.isElementDisplayed(epaperIcon, 20, "Epaper Icon");
        commonFunctions.clickElement(hamBurger, 20, "Hamburger");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElement(userNameLabelAfterLogin, 10, "User Profile");
        commonFunctions.clickElement(LogoutButton, 10, "Logout");
        commonFunctions.clickElement(hamBurger, 10, "Hamburger");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(signInButton, 10, "Sign-In button");
        commonFunctions.clickElement(closeIconHamburger, 10, "close Button");
        return isLogoutSuccessful;
    }

    public static void preSetInitializationForFaceBook(){
        commonFunctions.deleteFacebookCookies();
        new LoginPage();
    }

    public static void preSetInitializationForGoogle(){
        commonFunctions.deleteGoogleCookies();
        new LoginPage();
    }
}

