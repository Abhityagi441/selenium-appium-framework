package com.pages.LiveMint.android_mweb;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.ApiUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginPage extends CommonLoginPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsMobileLM;
    private static DriverController driverController;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;
    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "lmSsoinput")
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
    @FindBy(xpath = "//a[text()='My Account']")
    private static WebElement MyAccount;
    @FindBy(className = "logo")
    private static WebElement mintLogo;
    @FindBy(xpath = "//a[text()='Sign in with Facebook']")
    private static WebElement signInWithFacebookLabel;
    @FindBy(xpath = "//div[@class='userDetails']")
    private static WebElement userAccount;
    @FindBy(id = "uName")
    private static WebElement userEmailUsed;
    @FindBy(xpath = "//button[contains(@data-sigil,'m_login_button')]")
    private static WebElement loginButtonFacebookSignInPage2;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//button[@name='__CONFIRM__']")
    private static WebElement continueButtonFacebookSignInPage;
    @FindBy(xpath =  "//button[@class='subscribe'][1]")
    private static WebElement pushNotificationButton;
    @FindBy(xpath = "(//div[@class='ng-binding'])[1]")
    private static WebElement moEngagePopupDoItLater;
    @FindBy(id = "hamburgerElement")
    private static WebElement exploreMenu;

    @FindBy(id = "topnav-sign-in")
    private static WebElement signInButtonInExplore;

    @FindBy(xpath =  "//div[@id='topnav-myaccount']/a")
    private static WebElement myAccountInExploreMenu;
    @FindBy(id="otpScreen")
    private static WebElement otpScreen;
    @FindBy (xpath="//div[@id='otpScreen']//div[contains(@class,'otpfield')]/input")
    private static List<WebElement> newOTPinput;
    @FindBy(xpath = "//div[@id='otpScreen']//span[@class='errorBox']")
    private static WebElement incorrectOTPError;
    @FindBy(xpath = "//*[@text='VERIFY EMAIL ID']")
    private static MobileElement otpInputPage;
    @FindBy(xpath = "//div[@id='otpScreen']//div[@class='inpHolder otpfield']")
    private static MobileElement otpInput;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLM=CommonFunctionsMobileLM.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(180, TimeUnit.SECONDS);
        driverController=DriverController.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForGoogle();
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
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        String mainWindow = driver.getWindowHandle();
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
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater,20,"Moengage notification");
        commonFunctionsMobileLM.clickElement(exploreMenu,moEngagePopupDoItLater,10,"explore menu click","Moengage notification");
        commonFunctions.clickElement(signInButtonInExplore, 20, "Sign In Button in explore menu");
        boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email/Phone Button");
        commonFunctions.clickElementWithJS(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password text box");
        commonFunctions.clickElementWithJS(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.clickElement(exploreMenu,10,"explore menu click");
        commonFunctions.dummyWait(10);
        commonFunctions.isElementDisplayed(myAccountInExploreMenu,10,"my account visibilty");
        commonFunctions.clickElementWithJS(myAccountInExploreMenu, 10, "My Account Button in explore menu");
        commonFunctions.dummyWait(10);
        //isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        if (isMintLogoAlignedToCenter ) {
            isLoginSuccessful = true;
        } else {
            isLoginSuccessful = false;
        }
        return isLoginSuccessful;
    }


    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading(20);
        commonFunctionsMobileLM.clickElement(exploreMenu,moEngagePopupDoItLater,10,"explore menu","Notification button");
        commonFunctions.clickElementWithJS(myAccountInExploreMenu, 10, "My Account Button");
        commonFunctions.clickElementWithJS(LogoutButton, 10, "Logout");
         commonFunctions.clickElementWithJS(exploreMenu,10,"Click on Exp Menu");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(signInButtonInExplore, 20, "Sign-In button");
        return isLogoutSuccessful;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String accessAccount, String cookie, String refreshAPI) {
        boolean loginSuccesfull;
        boolean OTPLimitReached;
        int refreshAttempt=0;
        String otp;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater,20,"Moengage notification");
        commonFunctionsMobileLM.clickElement(exploreMenu,moEngagePopupDoItLater,10,"explore menu click","Moengage notification");
        commonFunctions.clickElement(signInButtonInExplore, 20, "Sign In Button in explore menu");
        commonFunctions.waitForURLContains("account");
        commonFunctions.sendKey(emailTextBoxMainSignInPage,email,20,"email");
        commonFunctions.clickElement(continueButtonSignInPage,10,"Continue");
        commonFunctions.waitForPageLoading();
        OTPLimitReached=commonFunctions.isElementNotDisplayed(newOTPinput.get(0),10,"OTP input");
        otp=commonFunctionsMobileLM.getOTPForLogin(apiURI,refreshAPI,cookie,accessAccount,OTPLimitReached);
        while((OTPLimitReached) && refreshAttempt<=1)
        {
            commonFunctions.clickElement(continueButtonSignInPage,10,"Continue");
            OTPLimitReached=commonFunctions.isElementNotDisplayed(otpScreen,20,"OTP input");
            otp=commonFunctionsMobileLM.getOTPForLogin(apiURI,refreshAPI,cookie,accessAccount,OTPLimitReached);
            refreshAttempt++;
        }

        if(otp.length()<5)
        { commonFunctions.clickElement (continueButtonSignInPage,10,"Continue");
            OTPLimitReached=commonFunctions.isElementNotDisplayed(otpScreen,20,"OTP input");
            otp=commonFunctionsMobileLM.getOTPForLogin(apiURI,refreshAPI,cookie,accessAccount,OTPLimitReached);}
        for(int i=0;i<newOTPinput.size();i++)
            commonFunctions.sendKey(newOTPinput.get(i),otp.substring(i,i+1));
        commonFunctions.isElementNotDisplayed(incorrectOTPError,15,"incorrect OTP error");
        commonFunctions.waitForURLToBe(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(exploreMenu,10,"Explore menu");
        loginSuccesfull=commonFunctions.isElementDisplayed(myAccountInExploreMenu,10,"My account");
        return loginSuccesfull;
    }


    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful;
        String parentWindowHandle=commonFunctions.getWindowHandle();
        commonFunctions.clickElement(singInButton, 30, "Sign In Button");
        boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
        boolean checkURLChangedToHTAccountsURLStatus = checkURLChangedToHTAccountsURL(htAccountsURL);
        boolean signInWithFacebookLabelStatus = commonFunctions.isElementDisplayed(signInWithFacebookLabel, 70, "Sign In With Facebook label");
        commonFunctions.clickElement(continueWithFacebookButton, 30, "Facebook Button");
        commonFunctions.switchToWindowWithTitle("Facebook",30,2);
        boolean facebookLoginURLStatus = commonFunctions.checkPageURL("facebook.com", 30, "facebook login url");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 30, "Email/Phone Button in Facebook");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 30, "Password text box in facebook");
        commonFunctions.hideKeyboard();
        commonFunctions.clickElementWithJS(loginButtonFacebookSignInPage2, 30, "Login Button in Facebook");
        commonFunctions.clickElementIfDisplayed(continueButtonFacebookSignInPage, 30, "Continue Button in Facebook");
        commonFunctions.switchToWindow(parentWindowHandle);
        commonFunctions.waitForURLToBe(Utils.getUrl());
        boolean liveMintURLStatus = commonFunctions.checkPageURL(Utils.getUrl(), 60, "livemint url");
        commonFunctions.clickElementWithJS(MyAccount, 30, "My Account Button");
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
        new com.pages.LiveMint.android_mweb.LoginPage();
    }

    public void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        new com.pages.LiveMint.android_mweb.LoginPage();
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

    private void commonStepForLogin(String email, String apiURI, String accessAccount, String cookie, String refreshAPI) {
        boolean OTPLimitReached;
        String otp;
        commonFunctions.clickElement(exploreMenu, 10, "Homepage Tab");
        commonFunctions.clickElement(signInButtonInExplore, 20, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 20, "Continue Button");
        OTPLimitReached = commonFunctions.isElementNotDisplayed(otpInputPage, 10, "OTP input");
        otp = commonFunctionsMobileLM.getOTPForLogin(apiURI, refreshAPI, cookie, accessAccount, OTPLimitReached);
        if (OTPLimitReached) {
            commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 20, "email");
            commonFunctions.clickElement(continueButtonSignInPage, 10, "continue");
            commonFunctions.waitForPageLoading();
            if (commonFunctions.isElementDisplayed(otpInputPage, 30, "OTP input")) {
                otp = commonFunctionsMobileLM.getOTPForLogin(apiURI, cookie, accessAccount);
            }
        }
        commonFunctions.sendKey(otpInput, otp, 10, "OTP password box");
    }

    @Override
    public boolean loginWithOTPSubScribedUser(String email, String apiURI, String accessAccount, String cookie, String refreshAPI,String expectedUserName) {
        commonStepForLogin(email,apiURI,accessAccount,cookie,refreshAPI);
        //commonFunctions.clickElementIfDisplayed(okButton, 5, "Ok button to refresh before login page.");
        //commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 10, "close icon for Get updates on Whatsapp.");
        //commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 5, "close icon for Get updates on Whatsapp.");
        //commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        commonFunctions.dummyWait(5);
        boolean isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        //commonFunctions.clickElement(closeEditProfile, 20, "closeIcon in edit profile");
        isLoginSuccessful &= commonFunctions.isElementNotDisplayed(pushNotificationButton, 10, "subscribe Button");
        return isLoginSuccessful;
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
