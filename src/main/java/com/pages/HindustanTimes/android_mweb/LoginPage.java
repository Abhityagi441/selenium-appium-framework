package com.pages.HindustanTimes.android_mweb;

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

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement hamBurger;

    @FindBy(xpath = "//a[@class='sign-in']")
    private static WebElement signInButton;

    @FindBy(xpath = "//div[@class='fSignOut']")
    private static WebElement signedOut;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

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

    @FindBy(name = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;

    @FindBy(name = "pass")
    private static WebElement passwordFacebookSignInPage;

    @FindBy(name = "login") //button[@value='Log In']
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

    @FindBy(xpath = "//a[@title='epaper']")
    private static WebElement epaperIcon;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(className = "crossicon")
    private static WebElement crossIcon;

    @FindBy(id = "userName2")
    private static WebElement hamburgerUsername;

    @FindBy(xpath = "//button[@value='Continue']")
    private static WebElement continueLoginButton;

    //@FindBy(xpath = "//div[contains(@class,'userName')]/a")
    @FindBy(id = "userName2")
    private static WebElement myAccountButton;

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
        boolean isUserRedirectedToSamePageAfterLogin = false;
        boolean isUsernameDisplayed = false;
        //commonFunctions.waitForURLToBe(globalVars.getProdUrl());
        AndroidBase.navigateToHomePageUrl();
        commonFunctions.clickElementWithActions(hamBurger, 45, "Hamburger");
        commonFunctions.clickElement(indiaNews, 45, "india news");
        String beforeLoginCheckURL = commonFunctions.getCurrentURL("India news section", "URL");
        commonFunctions.clickElementWithActions(hamBurger, 45, "Hamburger");
        commonFunctions.clickElement(signInButton, 20, "Sign In Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElementWithActions(continueWithFacebookButton, 35, "Login with Facebook");
        windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        String loginURL = commonFunctions.getCurrentURL("URL");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 25, "Email Text Box");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 25, "Password Textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(loginButtonFacebookSignInPage, 25, "Login Button");
        boolean isButtonDisplayed = commonFunctions.isElementDisplayed(continueLoginButton, 10, "Continue button");
        if (isButtonDisplayed == true) {
            commonFunctions.clickElement(continueLoginButton, 10, "Continue button");
        } else {
            Utils.logStepInfo("Continue button may not available");
        }
        windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(0));
        String afterLoginCheckURL = commonFunctions.getCurrentURL("URL");
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
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        AndroidBase.navigateToHomePageUrl();
        String mainWindow;
        commonFunctions.clickElement(hamBurger, 25, "Hamburger");
        mainWindow = commonFunctions.getWindowHandle();
        commonFunctions.clickElement(signInButton, 25, "Sign In Button");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        commonFunctions.clickElement(continueWithGoogleButton, 25, "Google Login Button");
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 25, "Email Textbox");
        commonFunctions.clickElementWithActions(nextButtonGmailSignInPage, 25, "Next Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 25, "Password textbox");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithActions(nextButtonGmailPasswordPage, 25, "Next Button");
        commonFunctions.switchToWindow(mainWindow);
       // commonFunctions.clickElementWithJS(crossIcon,25,"crossicon");
        boolean isHamburburgerDisplayed =commonFunctions.isElementDisplayed(hamBurger,10,"Hamburger");
        if(isHamburburgerDisplayed == true ){
            commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
            Utils.logStepInfo("Hamburger clicked");
        } else{
            Utils.logStepInfo("Hamburger not clickable");
        }
        boolean userName=commonFunctions.isElementDisplayed(userNameLabelAfterLogin,20,"UseName");
        if(userName) {
            isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 20, "UserName");
           System.out.println(userNameLabelAfterLogin.getText());
            return isLoginSuccessful;
        }else{
            Utils.logStepInfo("UserName Not Displayed");
            return false;
        }
    }


    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        AndroidBase.navigateToHomePageUrl();
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElementIfDisplayed(crossIcon,10,"crossicon");
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        commonFunctions.scrollToElementViewAndClick(signInButton, 10, "Sign In Button");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));

        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password box");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        AndroidBase.navigateToHomePageUrl();
        commonFunctions.pageRefresh();
        AndroidBase.navigateToHomePageUrl();
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(myAccountButton,20,"My Account Button");
        isLoginSuccessful = commonFunctions.checkTextContains(expectedUserName,  userNameLabelAfterLogin.getText(),"UserName");
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
        AndroidBase.navigateToHomePageUrl();

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
        String OTPPassword = getOtp.getOTP(apiURI, mode, auth);


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
        AndroidBase.navigateToHomePageUrl();
        commonFunctions.clickElementWithJS(hamBurger, 20, "Hamburger");
        commonFunctions.clickElementWithJS(LogoutButton, 20, "Logout");
        AndroidBase.navigateToHomePageUrl();
        commonFunctions.clickElementWithJS(hamBurger, 45, "Hamburger");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(signedOut, 15, "Signed-Out");
        commonFunctions.clickElementWithJS(closeIconHamburger, 20, "close Button");
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
