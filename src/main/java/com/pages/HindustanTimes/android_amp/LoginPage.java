package com.pages.HindustanTimes.android_amp;

import com.base.AndroidBase;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends CommonLoginPage {

    private  AndroidDriver<WebElement> driver;
    private  GlobalVars globalVars;
    private  CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "//div[@class = 'btnExplore']/button")
    private static WebElement hamBurger;

    @FindBy(id = "userName2")
    private static WebElement hamburgerUsername;

    @FindBy(xpath = "//a[@class='acorIn']")
    private static MobileElement signInButton;

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

    @FindBy(xpath = "//button[@type='button']") //button[@value='Log In']
    private static WebElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailPasswordPage;

    @FindBy(xpath = "//div[@id='password']//input")
    private static WebElement passwordTextBoxGmailSignInPage;

    @FindBy(xpath = "//h6[contains(@class,'acorHead')]/div")
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

    @FindBy(xpath = "//em[text()='India News']")
   private static WebElement indiaNewsSection;

    @FindBy(xpath="(//button[@class='subscribe'])[1]")
    private static WebElement doThisLaterButton;

    @FindBy(xpath = "//div[contains(@class,'userName')]/a")
    private static WebElement myAccountButton;

    @FindBy(xpath = "//a[@href='/india-news']")
    private static WebElement indiaNewsOption;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful = false;
        commonFunctions.clickElementWithJS(hamBurger, 45, "Hamburger");
        commonFunctions.clickElementWithJS(signInButton, 25, "Sign In Button");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        commonFunctions.clickElementWithActions(continueWithFacebookButton, 35, "Login with Facebook");
        windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 25, "Email Text Box");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 25, "Password Textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(loginButtonFacebookSignInPage, 25, "Login Button");
        windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.clickElementIgnoringStaleElementReferenceException(hamBurger, 20, "Hamburger");
        String user = commonFunctions.getElementText(hamburgerUsername,10);
        if (user.equalsIgnoreCase(expectedUserName)) {
            isLoginSuccessful = true;
        }
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isUserRedirectedToSamePageAfterLogin = false;
        boolean isUsernameDisplayed = false;
        String mainWindow;
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        commonFunctions.clickElementWithJS(indiaNewsSection,20,"india news section");
        String beforeSignInURL = commonFunctions.getCurrentURL("india news section","URL");
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        mainWindow = commonFunctions.getWindowHandle();
        commonFunctions.clickElementWithJS(signInButton, 20, "Sign In Button");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        commonFunctions.clickElement(continueWithGoogleButton, 20, "Google Login Button");
        String googleLoginURL = commonFunctions.getCurrentURL("Google login URL","URL");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "Email Textbox");
        commonFunctions.clickElementWithActions(nextButtonGmailSignInPage, 20, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 20, "Password textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(nextButtonGmailPasswordPage, 20, "Next Button");
        commonFunctions.switchToWindow(mainWindow);
        String afterLoginURL = commonFunctions.getCurrentURL("Current URL", "URL");
             if (beforeSignInURL.equalsIgnoreCase(afterLoginURL) && (!afterLoginURL.equalsIgnoreCase(googleLoginURL)))
                    {
            isUserRedirectedToSamePageAfterLogin = true;
             }
        commonFunctions.clickElementWithActions(hamBurger, 20, "Hamburger");
        isUsernameDisplayed = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 20, "UserName");
        return isUsernameDisplayed && isUserRedirectedToSamePageAfterLogin;
    }



    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Do this later button on push notification");
        commonFunctions.clickElement(hamBurger, 20, "Hamburger");
        commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.dummyWait(5);
        System.out.println(driver.getCurrentUrl());
        commonFunctions.refreshPage();
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Do this later button on push notification");
        commonFunctions.clickElement(hamBurger, 10, "Hamburger");
        commonFunctions.clickElement(indiaNewsOption,5,"India News Option in Explore");
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        System.out.println(driver.getCurrentUrl());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,15,"Do this later button on push notification");
        commonFunctions.clickElement(hamBurger, 10, "Hamburger");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 40, "UserName");
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
        long date = System.currentTimeMillis();
        commonFunctions.navigateToHomePage();
        ApiUtils getOtp = new ApiUtils();
        commonFunctions.clickElement(hamBurger, 20, "Hamburger");
        commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 10, "Generate OTP");
        String OTPPassword = getOtp.getOTP(apiURI, mode,auth);

            Utils.logStepInfo(true, "OTP: " + OTPPassword);
            for (int i = 0; i < OTPPassword.length(); i++) {
                System.out.println("OTP Digit: " + OTPPassword.charAt(i));
                commonFunctions.sendKeyBoolean(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "", 5);
            }
            commonFunctions.hideKeyboard();

        commonFunctions.clickElement(sigInWithOtpButtonMainSignInPage, 10, "Login Button");
        windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.isElementDisplayedIgnoringStaleElementReferenceException(epaperIcon, 45, "Epaper Icon");
        commonFunctions.clickElementIgnoringStaleElementReferenceException(hamBurger, 20, "Hamburger");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 45, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElement(userNameLabelAfterLogin, 55, "User Profile");
        commonFunctions.clickElement(LogoutButton, 20, "Logout");
        commonFunctions.clickElement(hamBurger, 45, "Hamburger");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(signInButton, 45, "Sign-In button");
        commonFunctions.clickElement(closeIconHamburger, 20, "close Button");
        return isLogoutSuccessful;
    }

    public void preSetInitializationForFaceBook(){
        commonFunctions.deleteFacebookCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preSetInitializationForGoogle(){
        commonFunctions.deleteGoogleCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
