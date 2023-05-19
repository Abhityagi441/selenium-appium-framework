
package com.pages.HindustanTimes.web;

import com.base.DesktopBase;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(className = "afterLogin")
    private static WebElement loggedInUserBtn;
    @FindBy(className = "sign-in")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin") //login
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
    @FindBy(xpath = "//div[contains(@class,'afterLogin')]")
    private static WebElement myAccountButton;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath="//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(id = "uName")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "//div[contains(@class,'showRightPop')]/div[8]/a")
    private static WebElement logoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id ="reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id="loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id="verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(id="agree")
    private static WebElement acceptCookie;
    @FindBy(id = "upass")
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement hamburger;
    @FindBy(id = "userName2")
    private static WebElement hamburgerUsername;

    @FindBy(id = "identifierId")
    private static WebElement emailBox;
    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButton;
    @FindBy(name = "password")
    private static WebElement passwordBox;
    @FindBy(id = "userName1")
    private static WebElement userOnSignIn;
    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploreOption;
    @FindBy(id = "userName1")
    private static WebElement userOnExplore;
    @FindBy(id = "email")
    private static WebElement emailFacebook;
    @FindBy(id = "pass")
    private static WebElement passFacebook;
    @FindBy(xpath = "//span[@class='crossicon']")
    private static WebElement closeOption;
    @FindBy(xpath = "//div[@class='signin']")
    private static WebElement myAccountAfterLogin;
    @FindBy(xpath = "//div[@class='logo']//h1")
    private static WebElement htLogo;
    @FindBy(xpath = "//div[@class = 'signin']/div/div[1]")
    private static WebElement signinBtn;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public  boolean loginWithFacebook(String email, String password, String expectedUserName){
        boolean isLoginSuccessful;
//        preSetInitializationForFaceBook();
        commonFunctions.clickElement(singInButton, 45, "sign in button");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        commonFunctions.clickElement(continueWithFacebookButton, 35, "continue with facebook button");
        windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
//        preSetInitializationForFaceBook();
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 20, "email box");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 20, "password box");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 20, "login button");
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.clickElement(myAccountButton, 20, "My Account");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 70, "UserName");
        commonFunctions.clickElement(hamburger, 25, "Hamburger Option");
        String user = commonFunctions.getElementText(hamburgerUsername,10);
        if (user.equalsIgnoreCase(expectedUserName)) {
            isLoginSuccessful = true;
        }
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElementWithJS(myAccountButton,40,"myAcountButton");
        commonFunctions.clickElementWithJS(userNameLabelAfterLogin, 20, "user nama label");
        commonFunctions.clickElementWithJS(logoutButton, 15, "sign out button");
        isLogoutSuccessful=commonFunctions.isElementDisplayed(signinBtn, 30, "sign in button");
        return isLogoutSuccessful;
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        DesktopBase.navigateToHomePageUrl();
        boolean isLoginSuccessful = false;
        commonFunctions.clickElement(singInButton, 10, "sign in button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElement(continueWithGoogleButton, 20, "continue button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email or phone box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 15, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 20, "password box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 15, "next button");
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(hamburger, 25, "Hamburger Option");
        String user = commonFunctions.getElementText(hamburgerUsername,10);
        if (user.trim().equalsIgnoreCase(expectedUserName)) {
            isLoginSuccessful = true;
        }
        commonFunctions.clickElementWithJS(closeOption, 25, "Close Option");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName){
        boolean isLoginSuccessful;
        DesktopBase.navigateToHomePageUrl();
        commonFunctions.waitForPageLoading();
        String url=globalVars.getURL();
        commonFunctions.clickElementWithJS(singInButton, 10, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 35, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 8, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 35, "password box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 15, "sign in button");
        //DesktopBase.navigateToHomePageUrl();
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(htLogo,10,"HT Logo");
        commonFunctions.clickElementWithJS(myAccountButton,40,"My Account Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 50, "UserName");
        Utils.logStepInfo(true,"isLoginSuccessful = "+isLoginSuccessful);
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
        DesktopBase.navigateToHomePageUrl();
        boolean isLoginSuccessful;
        long date = System.currentTimeMillis();
        ApiUtils getOtp = new ApiUtils();
        commonFunctions.clickElement(singInButton, 10, "sign in button");

        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));

        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 5, "continue button");
        commonFunctions.clickElement(generateOtpMainSignInPage, 20, "generate OTP button");
        commonFunctions.isElementDisplayedIgnoringStaleElement(OTPNotificationSentLabel, 20, "OTP notification sent label");
        String username = email.substring(0, email.indexOf("@"));
        long t1=System.currentTimeMillis();
        String OTPPassword = getOtp.getOTP(apiURI, mode, auth);
        long t2=System.currentTimeMillis();
        System.out.println("OTP: " + OTPPassword);
        System.out.println("******* Time taken to read OTP: "+(t2-t1));
        System.out.println("Time stamp after first OTP attempt: "+new Date());
         OTPPassword = getOtp.getOTP(apiURI, mode, auth);
         Utils.logStepInfo(true, "OTP: " + OTPPassword);
            for (int i = 0; i < OTPPassword.length(); i++) {
                System.out.println("OTP Digit: " + OTPPassword.charAt(i));
                commonFunctions.sendKeyBoolean(OTPInputBoxList.get(i), OTPPassword.charAt(i) + "");
            }

        commonFunctions.clickElement(verifyOTPToProceedButton, 10, "verify OTP to procees button");
        commonFunctions.switchToWindow(windowsList.get(0));
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    public void preSetInitializationForFaceBook(){
        commonFunctions.deleteFacebookCookies();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public void preSetInitializationForGoogle(){
        commonFunctions.deleteGoogleCookies();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
    }
}