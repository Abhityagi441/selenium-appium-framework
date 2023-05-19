package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.*;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWebLM;

    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "lmSsoinput")
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
    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;
    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;
    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "//div[@id='uName']//strong")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "//div[@id='myAccount']/a[text()='Logout']")
    private static WebElement LogoutButton;
    @FindBy(id="otpScreen")
    private static WebElement otpScreen;
    @FindBy (xpath="//div[@id='otpScreen']//div[contains(@class,'otpfield')]/input")
    private static List<WebElement> newOTPinput;
    @FindBy(xpath = "//div[@id='otpScreen']//span[@class='errorBox']")
    private static WebElement incorrectOTPError;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement OTPNotificationSentLabel;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private static WebElement MyAccount;
    @FindBy(xpath = "//a[text()='Sign in with Facebook']")
    private static WebElement signInWithFacebookLabel;
    @FindBy(id = "uName")
    private static WebElement userEmailUsed;
    @FindBy(xpath = "//div[@class='userDetails']")
    private static WebElement userAccount;
    @FindBy(className = "logo")
    private static WebElement mintLogo;
    @FindBy(xpath = "//button[@name='__CONFIRM__']")
    private static WebElement continueButtonFacebookSignInPage;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private static WebElement myAccount;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLM=CommonFunctionsWebLM.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

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
        commonFunctions.clickElement(mintLogo, 60, "mint Logo");
        commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email/Phone Button");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password text box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabledReload(MyAccount, 60, "MyAccount")) {
                System.out.println("Waiting for element to be present MyAccount");
            } else {
                commonFunctions.clickElement(MyAccount, 60, "Sign In Button");
                break;
            }
        }
        commonFunctions.isElementDisplayedAndPresent(userNameLabelAfterLogin,60,"username");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        if (isMintLogoAlignedToCenter && isLoginSuccessful) {
            isLoginSuccessful = true;
        } else {
            isLoginSuccessful = false;
        }
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean logoutStatus;
        commonFunctions.clickElement(MyAccount, 15, "My Account");
        commonFunctions.clickElement(LogoutButton, 60, "Logout button");
        logoutStatus = commonFunctions.isElementDisplayed(singInButton, 70, "Sign In");
        return logoutStatus;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String accessAccount, String cookie, String refreshAPI) {
        boolean loginSuccesfull;
        boolean OTPLimitReached;
        String otp;
        int refreshAttempt=0;
        commonFunctions.clickElement(singInButton,10,"sign In");
        commonFunctions.waitForURLContains("accounts");
        commonFunctions.sendKeys(emailTextBoxMainSignInPage,email,20,"email");
        commonFunctions.clickElement(continueButtonSignInPage,10,"continue");
        commonFunctions.waitForPageLoading();
        OTPLimitReached=commonFunctions.isElementNotDisplayed(otpScreen,20,"OTP input");
        otp=commonFunctionsWebLM.getOTPForLogin(apiURI,refreshAPI,cookie,accessAccount,OTPLimitReached);
        while(OTPLimitReached && refreshAttempt<=1)
        {
            commonFunctions.clickElementIgnoringStaleElement (continueButtonSignInPage,10,"Continue");
            OTPLimitReached=commonFunctions.isElementNotDisplayed(otpScreen,20,"OTP input");
            otp=commonFunctionsWebLM.getOTPForLogin(apiURI,refreshAPI,cookie,accessAccount,OTPLimitReached);
            refreshAttempt++;

        }

        if(otp.length()<5)
        { commonFunctions.clickElementIgnoringStaleElement (continueButtonSignInPage,10,"Continue");
        OTPLimitReached=commonFunctions.isElementNotDisplayed(otpScreen,20,"OTP input");
        otp=commonFunctionsWebLM.getOTPForLogin(apiURI,refreshAPI,cookie,accessAccount,OTPLimitReached);}
        for(int i=0;i<newOTPinput.size();i++)
            commonFunctions.sendKey(newOTPinput.get(i),otp.substring(i,i+1));
        boolean errorNotDisplayed=commonFunctions.isElementNotDisplayed(incorrectOTPError,10,"incorrect OTP error");
        commonFunctions.waitForURLToBe(globalVars.getURL());
        loginSuccesfull=commonFunctions.isElementDisplayed(MyAccount,15,"My account");
        if (errorNotDisplayed && loginSuccesfull)
            return true;
        else{
            return false;

        }}

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful;
        String parentWindowHandle = commonFunctions.getWindowHandle();
        commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
        boolean checkURLChangedToHTAccountsURLStatus = checkURLChangedToHTAccountsURL(htAccountsURL);
        boolean signInWithFacebookLabelStatus = commonFunctions.isElementDisplayed(signInWithFacebookLabel, 70, "Sign In With Facebook label");
        commonFunctions.clickElement(continueWithFacebookButton, 60, "Facebook Button");
        commonFunctions.switchToWindowWithTitle("Facebook", 60, 2);
        boolean facebookLoginURLStatus = commonFunctions.checkPageURL("facebook.com", 60, "facebook login url");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 30, "Email/Phone Button in Facebook");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 30, "Password text box in facebook");
        commonFunctions.clickElementWithJS(loginButtonFacebookSignInPage, 30, "Login Button in Facebook");
        commonFunctions.clickElementIfDisplayed(continueButtonFacebookSignInPage, 30, "Continue Button in Facebook");
        commonFunctions.switchToWindow(parentWindowHandle);
        commonFunctions.waitForURLToBe(Utils.getUrl());
        boolean liveMintURLStatus = commonFunctions.checkPageURL(Utils.getUrl(), 30, "livemint url");
        commonFunctions.clickElement(MyAccount, 60, "My Account Button");
        boolean checkEmailIDUsedForLoginStatus = checkEmailIDUsedForLogin(email);
        boolean checkColorCodeStatus = commonFunctions.checkCSSProperty(userAccount, "background", "rgb(247, 148, 30)", "orange color");
        if (isMintLogoAlignedToCenter && checkURLChangedToHTAccountsURLStatus && signInWithFacebookLabelStatus && facebookLoginURLStatus && liveMintURLStatus && checkColorCodeStatus && checkEmailIDUsedForLoginStatus) {
            isLoginSuccessful = true;
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
        commonFunctions.isElementDisplayed(userEmailUsed, 60, "Email");
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
