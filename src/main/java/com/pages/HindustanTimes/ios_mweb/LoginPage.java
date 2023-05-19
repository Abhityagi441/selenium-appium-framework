package com.pages.HindustanTimes.ios_mweb;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static DriverController driverController;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(xpath = "//div[contains(@class,'footerLogin')]/div[2]/a")
    private static WebElement singInButton;

    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;

    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;

    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;

    @FindBy(id = "phoneEmail")
    private static WebElement emailTextBoxMainSignInPage;

    @FindBy(id="userName2")
    private static WebElement myAccountBtn;

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

    @FindBy(id = "uName")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;


    @FindBy(xpath = "//div[@class='acorBox']//amp-accordion")
    private static WebElement logoutDropdownButton;

    @FindBy(xpath = "//a[@class='sign-out']")
    private static WebElement LogoutButton;

    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id ="reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id="verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(className="crossicon")
    private static WebElement closeIconHamburger;

    @FindBy(className = "closebtn")
    private static WebElement closeUserInfoBtn;

    @FindBy(xpath = "//a[@title='epaper']")
    private static WebElement epaperIcon;

    @FindBy(xpath = "//button[@value='Continue']")
    private static WebElement continueLoginButton;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(id = "userName2")
    private static WebElement hamburgerUsername;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(className = "crossicon")
    private static WebElement crossIcon;

    @FindBy(xpath = "//div[@class='nav-sec']/ul[1]/li[1]/a")
    private static WebElement homeIcon;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        driverController = DriverController.getInstance();
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
        commonFunctions.clickElement(singInButton, 120, "Sign In Button");
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
        boolean isLoginSuccessful;
        String mainWindow;
        preSetInitializationForGoogle();
        commonFunctions.clickElement(hamBurger, 10, "Hamburger");
        mainWindow = driver.getWindowHandle();
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        Set<String> allWindows = commonFunctions.getWindowHandles();
        for (String loginWindow : allWindows) {
            if (!loginWindow.equals(mainWindow)) {
                commonFunctions.switchToWindow(loginWindow);
                break;
            }
        }
        commonFunctions.clickElement(continueWithGoogleButton, 10, "Google Login Button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 10, "Email Textbox");
        commonFunctions.clickElementWithActions(nextButtonGmailSignInPage, 10, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 10, "Password textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(nextButtonGmailPasswordPage, 10, "Next Button");
        commonFunctions.switchToWindow(mainWindow);
        try {
            Thread.sleep(5000);
        }catch (Exception e){}
        commonFunctions.isElementDisplayed(epaperIcon, 20, "Epaper Icon");
        commonFunctions.clickElementWithActions(hamBurger, 20, "Hamburger");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        driverController.navigateToApplicationHomePage(false);
        commonFunctions.goToURL("https://accounts.hindustantimes.com/");
        if(!commonFunctions.isElementDisplayed(emailTextBoxMainSignInPage,10,"email or Phone Box")){
            driver.manage().deleteAllCookies();
            driver.close();
            commonFunctions.scrollToElementView(hamBurger,10,"Scroll to HamBurger");
            commonFunctions.getURL("https://accounts.hindustantimes.com/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String s = "https://accounts.hindustantimes.com/";
            js.executeScript("window.location = \'"+s+"\'");
            System.out.println("Navigating to URL = https://accounts.hindustantimes.com by JS **** Actual URL is - " + commonFunctions.getCurrentURL());
            if(!commonFunctions.getCurrentURL().contains(s)){
                commonFunctions.clickElement(hamBurger, 10, "HamBurger Click");
                if(commonFunctions.isElementDisplayed(singInButton,10,"Sign-In Button Display")){
                    commonFunctions.clickElement(singInButton,10,"Sing-In click");
                    commonFunctions.clickElementIfDisplayed(singInButton,10,"Sign-In");
                    System.out.println("Navigating to URL = https://accounts.hindustantimes.com by JS **** Actual URL is - " + commonFunctions.getCurrentURL());
                }

            }
            commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "email or phone box");
        }
        else {
            commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "email or phone box");
        }
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 20, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 20, "Password box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 20, "Login Button");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(hamBurger, 20, "Hamburger");
        commonFunctions.clickElementIfDisplayed(hamBurger, 10, "Hamburger");
        commonFunctions.clickElementWithJS(myAccountBtn,10,"myAccountBtn");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeUserInfoBtn,10,"closeUserInfoBtn");
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
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
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
        String OTPPassword = getOtp.getOTP(apiURI,mode,auth);
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
        commonFunctions.clickElementWithJS(hamBurger,20,"hamburger");
        commonFunctions.clickElementIfDisplayed(hamBurger,20,"hamburger");
        commonFunctions.clickElementWithJS(LogoutButton, 20, "Logout");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithJS(hamBurger,10,"hamburger");
        commonFunctions.clickElementIfDisplayed(hamBurger,20,"hamburger");
        commonFunctions.scrollDownOnce();
        isLogoutSuccessful = commonFunctions.isElementDisplayed(singInButton, 20, "Sign-In button");
        commonFunctions.clickElementWithJS(closeIconHamburger, 10, "close Button");
        commonFunctions.clickElementIfDisplayed(closeIconHamburger,10,"Close button if display");
        return isLogoutSuccessful;
    }

    public static void preSetInitializationForFaceBook(){
        commonFunctions.deleteFacebookCookies();
        new com.pages.HindustanTimes.ios_mweb.LoginPage();
    }

    public static void preSetInitializationForGoogle(){
        commonFunctions.deleteGoogleCookies();
        new com.pages.HindustanTimes.ios_mweb.LoginPage();
    }
}
