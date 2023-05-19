package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.commonFunctions.CommonFunctionWebHTAuto;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import com.pages.HT_AUTO.genericPages.CommonLoginPage;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionWebHTAuto commonFunctionsHt;


    @FindBy(xpath = "//a[contains(@class,'btnSection')]")
    private static WebElement explore;
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
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])//li[2]/a")
    private static WebElement logoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(xpath="//div[@id='userArea']/a")
    private static WebElement myAccountDropDown;
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
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt = new CommonFunctionWebHTAuto().getInstance();

        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctions.clickElementIfDisplayed(acceptCookie, 10,"acceptCookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.dummyWait(5);
        commonFunctions.moveElementWithActions(myAccountDropDown,logoutButton,10,"MyAccount");

      //  commonFunctions.clickElement(logoutButton, 15, "sign out button");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(singInButton, 70, "sign in button");
        return isLogoutSuccessful;
    }

    @Override
    public boolean loginWithMobileAndPassword(String mobile, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        boolean isElementPresent;

        commonFunctions.navigateToHomePage();
        commonFunctionsHt.waitForPageLoading();
//        isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 5, "Accept Cookie");
//        if (isElementPresent) {
//            commonFunctions.clickElement(acceptCookie, 10, "Accept cookie");
//        }
        commonFunctions.clickElement(singInButton, 10, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, mobile, 10, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 8, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "password box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "sign in button");
        commonFunctions.moveElementWithActions(myAccountDropDown,10,"My Account");
        commonFunctions.moveElementWithActions(userNameLabelLogin,10,"userNameLabelLogin");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelLogin, expectedUserName, 30, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessfulWithFacebook = true;

        commonFunctions.waitForPageToLoad();
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(explore, 30, "Explore");
        commonFunctions.clickElement(singInButton, 30, "sign in button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElement(continueFacebookButton, 10, "Sign In with Facebook");
        windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKeyBoolean(usernameBoxFacebook, email, 10, "Email ID for facbook login");
        commonFunctions.sendKeyBoolean(passwordBoxFacebook, password, 10, "Password for facebook login");
        commonFunctions.clickElement(submitBtnFacebook, 10, "Submit button for facebook");
        windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.clickElementWithJS(explore,40,"Explore button clicked to see successful signedIn");
        isLoginSuccessfulWithFacebook &= commonFunctions.checkElementText(userNameLabelLogin, expectedUserName, 30, "UserName");
        return isLoginSuccessfulWithFacebook;
    }

    @Override
    public boolean loginWithGoogleAndPassword(String email,String password,String expectedUserName) {
        boolean isLoginSuccessful=true;

        commonFunctions.waitForPageToLoad();
        commonFunctions.navigateToHomePage();
        isLoginSuccessful &=commonFunctions.clickElement(explore, 30, "Explore");
        isLoginSuccessful &=commonFunctions.clickElement(singInButton, 30, "sign in button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isLoginSuccessful &=commonFunctions.clickElement(continueGoogleButton,10,"Sign In via google");
        isLoginSuccessful &=commonFunctions.sendKeyBoolean(userNameBox, email, 35, "email box");
        isLoginSuccessful &=commonFunctions.clickElement(nextBtn, 15, "Next button");
        isLoginSuccessful &=commonFunctions.sendKeyBoolean(passwordBox, password, 35, "password box");
        isLoginSuccessful &=commonFunctions.clickElement(nextBtn, 15, "Next button");
        windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.clickElement(explore, 30, "Explore");
        isLoginSuccessful &=commonFunctions.checkElementText(userNameLabelLogin, expectedUserName, 30, "UserName");

        return isLoginSuccessful;
    }
}