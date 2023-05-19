package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends CommonLoginPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;


    @FindBy(id = "firstLetterBtn")
    private static WebElement hamburgerMenu;
    @FindBy(id = "userLogInBtn")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueFacebookButton;
    @FindBy(id = "phoneEmail")
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
    @FindBy(xpath = "//a[contains(@id,'bike') and contains(@data-itemseq,'3')]")
    private static WebElement findBikes;
    @FindBy(xpath = "//select[contains(@id,'bike-brand-selector')]")
    private static WebElement selectBrand;
    @FindBy(xpath = "//select[contains(@id,'bike-model-selector')]")
    private static WebElement selectModel;
    @FindBy(xpath = "//input[contains(@onclick,'searchBikes()')]")
    private static WebElement searchBike;
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
    @FindBy(xpath = "//span[contains(@class,'VfPpkd-vQzf8d')]")
    private static WebElement googleTryAgain;
    @FindBy(xpath = "//input[@type='submit']") //input[@value='Log In']
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(id = "loggedInName")
    private static WebElement userNameLabelLogin;
    @FindBy(className = "closeIcon")
    private static WebElement closeButton;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(className = "logoutBtn")
    private static WebElement logoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement otpNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(xpath = "//div[contains(@class,'mdlNumber')]/span[1]")
    private static WebElement expectedText;
    @FindBy(id = "email")
    private static WebElement usernameBoxFacebook;
    @FindBy(id = "pass")
    private static WebElement passwordBoxFacebook;
    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement submitBtnFacebook;
    @FindBy(id="identifierId")
    private static WebElement userNameBox;
    @FindBy(id="identifierNext")
    private static WebElement nextBtn;
    @FindBy(xpath = "//input[@type='password]")
    private static WebElement passwordBox;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctionsMobile = CommonFunctionsMobile.getInstance();

        boolean isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 30, "Explore");

        commonFunctionsMobile.clickElementWithJS(userNameLabelLogin, 60, "user name label");
        commonFunctionsMobile.clickElementWithJS(logoutButton, 15, "sign out button");
        isLogoutSuccessful = commonFunctionsMobile.isElementDisplayed(singInButton, 70, "sign in button");
        return isLogoutSuccessful;
    }

    @Override
    public boolean loginWithMobileAndPassword(String mobile, String password, String expectedUserName) {
        boolean isLoginSuccessful=true;
        boolean isElementPresent;

        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 2, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        commonFunctionsMobile.clickElementWithJS(singInButton, 30, "sign in button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctionsMobile.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctionsMobile.sendKeyBoolean(emailTextBoxMainSignInPage, mobile, 35, "email box");
        commonFunctionsMobile.clickElementWithJS(continueButtonSignInPage, 10, "continue button");
        commonFunctionsMobile.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 35, "password box");
        commonFunctionsMobile.clickElementWithJS(signInButtonMainSignInPage, 15, "sign in button");
        isLoginSuccessful &=commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 30, "Explore");
        isLoginSuccessful &= commonFunctionsMobile.checkElementText(userNameLabelLogin, expectedUserName, 30, "UserName");
        commonFunctionsMobile.clickElementWithJS(closeButton,10,"closeButton");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessfulWithFacebook = true;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 30, "Explore");
        commonFunctionsMobile.clickElementWithJS(singInButton, 30, "sign in button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctionsMobile.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctionsMobile.clickElementWithJS(continueFacebookButton, 10, "Sign In with Facebook");
        windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(3));
        commonFunctionsMobile.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctionsMobile.sendKeyBoolean(usernameBoxFacebook, email, 10, "Email ID for facbook login");
        commonFunctionsMobile.sendKeyBoolean(passwordBoxFacebook, password, 10, "Password for facebook login");
        commonFunctionsMobile.clickElementWithJS(submitBtnFacebook, 10, "Submit button for facebook");
        windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctionsMobile.switchToWindow(windowsList.get(0));
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu,40,"Explore button clicked to see successful signedIn");
        isLoginSuccessfulWithFacebook &= commonFunctionsMobile.checkElementText(userNameLabelLogin, expectedUserName, 30, "UserName");
        return isLoginSuccessfulWithFacebook;
    }

    @Override
    public boolean loginWithGoogleAndPassword(String email,String password,String expectedUserName) {
        boolean isLoginSuccessful=true;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isLoginSuccessful &=commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 30, "Explore");
        isLoginSuccessful &=commonFunctionsMobile.clickElementWithJS(singInButton, 30, "sign in button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctionsMobile.switchToWindow(windowsList.get(windowsList.size() - 1));
        isLoginSuccessful &=commonFunctionsMobile.clickElementWithJS(continueGoogleButton,10,"Sign In via google");
        isLoginSuccessful &=commonFunctionsMobile.sendKeyBoolean(userNameBox, email, 35, "email box");
        isLoginSuccessful &=commonFunctionsMobile.clickElementWithJS(nextBtn, 15, "Next button");
        isLoginSuccessful &=commonFunctionsMobile.sendKeyBoolean(passwordBox, password, 35, "password box");
        isLoginSuccessful &=commonFunctionsMobile.clickElementWithJS(nextBtn, 15, "Next button");
        windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctionsMobile.switchToWindow(windowsList.get(0));
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 30, "Explore");
        isLoginSuccessful &=commonFunctionsMobile.checkElementText(userNameLabelLogin, expectedUserName, 30, "UserName");

        return isLoginSuccessful;
    }
}