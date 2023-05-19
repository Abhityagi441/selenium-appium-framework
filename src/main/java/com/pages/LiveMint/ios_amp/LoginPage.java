package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class LoginPage extends CommonLoginPage {


    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(id = "agree")
    private static WebElement agreeCookieButton;

    @FindBy(xpath = "//a[contains(@class,'ml15 epaper2 signin')]")
    private static WebElement signInButton;

    @FindBy(xpath = "//a[contains(@text(),'Sign in')]")
    private static WebElement signInText;

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

    @FindBy(xpath = "//button[@name='login']")
    private static WebElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailPasswordPage;

    @FindBy(xpath = "//div[@id='password']//input")
    private static WebElement passwordTextBoxGmailSignInPage;

    @FindBy(xpath = "//div[@id='uName']/strong")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(xpath = "//a[text()='Logout']")
    private static WebElement logoutButton;

    @FindBy(xpath="//a[contains(@class,'acorOut')]")
    private static WebElement signOutAMP;

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

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private static WebElement MyAccount;

    @FindBy(xpath = "//div[@id='webklipper-publisher-widget-container-notification-close-div']/span")
    private static WebElement offerAd;

    @FindBy(xpath = "//a[contains(@class,'ml15 epaper2 signin')]")
    private static WebElement singInButton;

    @FindBy(className = "logo")
    private static WebElement mintLogo;

    @FindBy(xpath = "//a[text()='Sign in with Facebook']")
    private static WebElement signInWithFacebookLabel;

    @FindBy(id = "uName")
    private static WebElement userEmailUsed;

    @FindBy(xpath = "//div[@class='userDetails']")
    private static WebElement userAccount;

    @FindBy(xpath = "//button[@name='__CONFIRM__']")
    private static WebElement continueButtonFacebookSignInPage;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(agreeCookieButton, 10, "agreeCookieButton");
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful;
        preSetInitialization();
        String mainWindow=commonFunctions.getWindowHandle();
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        commonFunctions.waitForURLContains(htAccountsURL);
        boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
        boolean checkURLChangedToHTAccountsURLStatus=checkURLChangedToHTAccountsURL(htAccountsURL);
        boolean signInWithFacebookLabelStatus = commonFunctions.isElementDisplayed(signInWithFacebookLabel, 70, "Sign In With Facebook label");
        commonFunctions.clickElement(continueWithFacebookButton, 60, "Facebook Button");
        boolean facebookLoginURLStatus = commonFunctions.checkPageURL("facebook.com", 30, "facebook login url");
        Set<String> allWindows = commonFunctions.getWindowHandles();
        for (String fbLoginWindow : allWindows) {
            if (!fbLoginWindow.equals(mainWindow)) {
                commonFunctions.switchToWindow(fbLoginWindow);
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 30, "Email/Phone Button in Facebook");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 30, "Password text box in facebook");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithJS(loginButtonFacebookSignInPage, 30, "Login Button in Facebook");
        commonFunctions.clickElementIfDisplayed(continueButtonFacebookSignInPage, 30, "Continue Button in Facebook");
        commonFunctions.switchToWindow(mainWindow);
        commonFunctions.waitForURLToBe(Utils.getUrl());
        boolean liveMintURLStatus = commonFunctions.checkPageURL(globalVars.getProdUrl(), 30, "livemint url");
        commonFunctions.clickElementWithJS(MyAccount, 60, "My Account Button");
        commonFunctions.clickElementIfDisplayed(offerAd, 60, "Close Ad Button");
        boolean checkEmailIDUsedForLoginStatus = checkEmailIDUsedForLogin(email);
        boolean checkColorCodeStatus = commonFunctions.checkCSSProperty(userAccount, "background", "rgb(247, 148, 30)", "orange color");

        if (isMintLogoAlignedToCenter && checkURLChangedToHTAccountsURLStatus && signInWithFacebookLabelStatus && facebookLoginURLStatus && liveMintURLStatus && checkColorCodeStatus && checkEmailIDUsedForLoginStatus) {    isLoginSuccessful = true;
        } else {
            isLoginSuccessful = false;
        }
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
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitialization();
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButton, 60, "singInButton")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElement(signInButton, 60, "Sign In Button");
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 60, "email or phone box");
        commonFunctions.hideKeyboard();
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(continueButtonSignInPage, 60, "continueButtonSignInPage")) {
                System.out.println("Waiting for element to be clickable continueButtonSignInPage");
            } else {
                commonFunctions.clickElement(continueButtonSignInPage, 60, "continue button");
                break;
            }
        }
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 60, "Password box");
        commonFunctions.hideKeyboard();
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButtonMainSignInPage, 60, "signInButtonMainSignInPage")) {
                System.out.println("Waiting for an element to be present signInButtonMainSignInPage");
            } else {
                commonFunctions.clickElement(signInButtonMainSignInPage, 60, "Login Button");
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabledReload(MyAccount, 60, "MyAccount")) {
                System.out.println("Waiting for element to be present MyAccount");
            } else {
                commonFunctions.clickElement(MyAccount, 60, "Sign In Button");
                break;
            }
        }
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful = false;
        commonFunctions.clickElementWithJS(signOutAMP, 60, "Logout");
        for (int i = 0; i < 10; i++) {
            if (!commonFunctions.isElementEnabledReload(signInButton, 60, "signInButton")) {
                System.out.println("Waiting for element to be present MyAccount");
            } else {
                isLogoutSuccessful = commonFunctions.isElementDisplayed(signInButton, 60, "Sign-In button");
                commonFunctions.pageRefresh();
                break;
            }
        }
        return isLogoutSuccessful;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        return false;
    }


    public static void preSetInitialization() {
        commonFunctions.deleteCookiesAndNavigateToHomePage();
        new LoginPage();
    }

    public static void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        new LoginPage();
    }

    public static void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        new LoginPage();
    }
    public boolean checkMintLogoIsAlignedToCenter() {
        boolean checkMintLogoIsAlignedToCenterStatus;
        commonFunctions.isElementDisplayed(mintLogo, 60, "Mint Logo");
        checkMintLogoIsAlignedToCenterStatus = commonFunctions.checkCSSProperty(mintLogo, "text-align", "center", "Mint Logo");
        return checkMintLogoIsAlignedToCenterStatus;
    }

    public boolean checkURLChangedToHTAccountsURL(String htAccountsURL) {
        boolean checkURLChangedToHTAccountsURLStatus;
        commonFunctions.waitForURLContains("Login");
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToHTAccountsURLStatus = commonFunctions.checkTextContains(htAccountsURL, actualURL, "HT accounts Login URL");
        return checkURLChangedToHTAccountsURLStatus;
    }
    public boolean checkEmailIDUsedForLogin(String email) {
        boolean checkEmailIDUsedForLoginStatus;
        commonFunctions.isElementDisplayed(userEmailUsed,60,"Email");
        String actualEmail = commonFunctions.getElementText(userEmailUsed);
        actualEmail = actualEmail.replaceAll("TestAutomation", "").replaceAll("\n", "").trim();
        checkEmailIDUsedForLoginStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID");
        return checkEmailIDUsedForLoginStatus;
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
