package com.pages.LiveMint.IOSNativePages;

import com.commonFunctions.CommonFunctionsMobile;

import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;
import java.util.List;


public class LoginPage extends CommonLoginPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Not')]")
    private static MobileElement trackingDenielButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(id = "agree")
    private static MobileElement acceptCookie;

    @iOSXCUITFindBy(id = "Ask App Not to Track")
    private static MobileElement notificationAskNotToTrack;

    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Sign in'`][2]")
    private static MobileElement signInButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Sign in'])[2]")
    private static MobileElement postSignInButton;

    @iOSXCUITFindBy(xpath = " //XCUIElementTypeStaticText[@name='Sign in']")
    private static MobileElement postSignInButtonText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    private static List<MobileElement> signInButtonAfterLogOut;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Continue')]")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Proceed')]")
    private static MobileElement verifyOtpToProceedButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Google')]")
    private static MobileElement continueWithGoogleButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueWithGoogleConfirmationPrompt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement proceedWithoutAppleID;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow//XCUIElementTypeButton[@name='My Account']")
    private static MobileElement myAccountButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='My Account']")
    private static MobileElement myAccountText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Latest']")
    private static MobileElement navLatestButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Facebook')]")
    private static MobileElement continueWithFacebookButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    //uemail  //android.widget.EditText[@resource-id='uemail']
    private static MobileElement emailTextBoxMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButtonSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")  //android.widget.EditText[@resource-id='upass']
    private static MobileElement passwordTextBoxMainSignInPage;

    @iOSXCUITFindBy(id = "com.ht.news:id/continue_btn") //login //android.widget.Button[@resource-id='login']
    private static MobileElement signInButtonMainSignInPage;

    @iOSXCUITFindBy(xpath = "//div[text()='Use another account']")
    private static MobileElement useAnotherAccountGmailSignInPage;

    @iOSXCUITFindBy(className = "android.widget.EditText")
    private static MobileElement emailOrPhoneGmailSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField") //m_login_email
    private static MobileElement emailOrPhoneFacebookSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField") //m_login_email
    private static List<MobileElement> otpTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private static MobileElement passwordFacebookSignInPage;

    //    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeButton[@name='Log In']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Log In'`]")
    private static MobileElement loginButtonFacebookSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField//following-sibling::XCUIElementTypeButton[1]")
    private static MobileElement loginButtonFacebookSignInPage2;

    @iOSXCUITFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private static MobileElement nextButtonGmailSignInPage;

    @iOSXCUITFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private static MobileElement nextButtonGmailPasswordPage;

    @iOSXCUITFindBy(className = "android.widget.EditText")
    private static MobileElement passwordTextBoxGmailSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
    private static MobileElement userNameLabelAfterLogin;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[4]//XCUIElementTypeButton")
    private static MobileElement continueButtonFacebookAfterUsernamePassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[8]")
    private static MobileElement LogoutButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'OTP')]")
    private static MobileElement generateOtpMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Resend')]")
    private static MobileElement reGenerateOtpMainSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Verify')]")
    private static MobileElement sigInWithOtpButtonMainSignInPage;

    @iOSXCUITFindBy(className = "crossicon")
    private static MobileElement closeIconHamburger;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name ='OK']")
    private static MobileElement okButtonLogoutPopUp;

    @iOSXCUITFindBy(id = "com.ht.news:id/ep_txt")
    private static MobileElement ePaperTextLabel;

    @iOSXCUITFindBy(id = "Ok")
    private static MobileElement okButton;

    @iOSXCUITFindBy(id = "my profile cross")
    private static MobileElement closeIconInProfile;

    @iOSXCUITFindBy(id = "bannerCross")
    private static MobileElement closeWhatsupIcon;

    @FindBy(name = "My Account")
    private static WebElement myAccountWithArrow;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'My Account'`]")
    private static MobileElement MyAccount;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Continue with Facebook'`]")
    private static MobileElement continueWithFacebookLabel;

    @iOSXCUITFindBy(id = "Login or Register")
    private static MobileElement loginOrRegister;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Edit Profile']")
    private static MobileElement editProfile;

    @iOSXCUITFindBy(id = "You previously logged in to Mint with Facebook.")
    private static MobileElement facebookLoginText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]")
    private static MobileElement emailAfterLoginWithFacebook;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;

    @iOSXCUITFindBy(id = "Accept All")
    private static MobileElement acceptAllCookies;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptAllCookies, 10, "accept cookie button");
        commonFunctions.clickElementIfDisplayed(trackingDenielButton, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 10, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 10, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 10, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 10, "notification Later");
    }


    @Override
    public boolean logout() {
        boolean isUserSignedOut = false;
        commonFunctions.clickElement(MyAccount, 20, "My Account Button");
        commonFunctions.clickElement(LogoutButton, 20, "LogoutButton");
//        for (int i = 0; i < 4; i++) {
//            if (!commonFunctions.isElementDisplayed(okButtonLogoutPopUp, 20, "okButtonLogoutPopUp")) {
//                System.out.println("Waiting for element to be present okButtonLogoutPopUp");
//            } else {
//                commonFunctions.clickElement(okButtonLogoutPopUp, 20, "okButtonLogoutPopUp");
//                break;
//            }
//        }
        commonFunctions.clickElementIfDisplayed(okButtonLogoutPopUp, 20, "okButtonLogoutPopUp");
        isUserSignedOut = commonFunctions.checkElementTextReload(signInButton, "Sign in", 20, "postSignInButtonText");
        return isUserSignedOut;

    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful, checkEmailStatus;
        commonFunctions.clickElement(home, 20, "Home");
        commonFunctions.dummyWait(20);
        boolean isSignInButtonDisplayed=commonFunctions.isElementDisplayed(signInButton, 20, "signInButton");
        if(isSignInButtonDisplayed){
            commonFunctions.clickElement(signInButton, 20, "Sign In Button");
        }else{
            commonFunctions.tapElementWithCoOrdinates(350, 73, "signInButton");
        }
        boolean isLoginOrRegisterLabel = commonFunctions.isElementDisplayed(loginOrRegister, 20, "Login or Register label");
        boolean signInWithFacebookLabelStatus = commonFunctions.isElementDisplayed(continueWithFacebookLabel, 20, "Continue With Facebook label");
        commonFunctions.clickElement(continueWithFacebookLabel, 20, "Continue With Facebook label");
        String alertValue = commonFunctions.getAlertText("Mint Wants to Use facebook.com to Sign In alert", 20);
        if (alertValue.contains("“Mint” Wants to Use “facebook.com” to Sign In")) {
            Utils.logStepInfo(true, "“Mint” Wants to Use “facebook.com” to Sign In is displayed in alert");
        } else {
            Utils.logStepInfo(true, "“Mint” Wants to Use “facebook.com” to Sign In is NOT displayed in alert");
        }
        commonFunctions.switchToDefaultContent();
        commonFunctions.clickElement(continueButtonSignInPage, 20, "continueButtonSignInPage");
        commonFunctions.clickElementIfDisplayed(acceptAllCookies, 20, "accept All Cookies");
        commonFunctions.clickElement(emailOrPhoneFacebookSignInPage, 20, "Email/Phone Button in Facebook");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 20, "Email/Phone Button in Facebook");
        commonFunctions.clickElement(passwordFacebookSignInPage, 20, "Password text box in facebook");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 20, "Password text box in facebook");
        commonFunctions.dummyWait(20);
        boolean isFbSignInButtonDisplayed=commonFunctions.isElementDisplayed(loginButtonFacebookSignInPage, 20, "signInButton in fb");
        if(isFbSignInButtonDisplayed){
            commonFunctions.clickElement(loginButtonFacebookSignInPage, 20, "Sign In Button in fb");
        }else if(isFbSignInButtonDisplayed=commonFunctions.isElementDisplayed(loginButtonFacebookSignInPage2, 20, "signInButton in fb")){
            commonFunctions.clickElement(loginButtonFacebookSignInPage2, 20, "Sign In Button2 in fb");
        }else{
            commonFunctions.tapElementWithCoOrdinates(200, 320, "tap Login button in Facebook");
        }
        commonFunctions.clickElement(continueButton, 20, "Continue Button in Facebook");
        commonFunctions.clickElement(proceedWithoutAppleID, 20, "proceedWithoutAppleID");
        commonFunctions.clickElement(MyAccount, 20, "My Account Button");
        commonFunctions.isElementDisplayed(editProfile, 20, "Edit Option");
        checkEmailStatus = commonFunctions.checkElementText(emailAfterLoginWithFacebook, email, 20, "Email id ");
        commonFunctions.clickElement(closeIconInProfile, 20, "closeIcon in edit profile");
        if (isLoginOrRegisterLabel && signInWithFacebookLabelStatus && checkEmailStatus) {
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
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions.clickElement(home, 20, "Home");
        commonFunctions.dummyWait(20);
        boolean isSignInButtonDisplayed=commonFunctions.isElementDisplayed(signInButton, 20, "signInButton");
        if(isSignInButtonDisplayed){
            commonFunctions.clickElement(signInButton, 20, "Sign In Button");
        }else{
            commonFunctions.tapElementWithCoOrdinates(350, 73, "signInButton");
        }
        commonFunctions.clickElement(emailTextBoxMainSignInPage, 20, "emailTextBoxMainSignInPage");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 20, "emailTextBoxMainSignInPage");
        commonFunctions.clickElement(continueButtonSignInPage, 20, "continueButtonSignInPage");
        commonFunctions.clickElement(passwordTextBoxMainSignInPage, 20, "passwordTextBoxMainSignInPage");
        commonFunctions.sendKey(passwordTextBoxMainSignInPage, password, 20, "passwordTextBoxMainSignInPage");
        commonFunctions.clickElement(continueButtonSignInPage, 20, "continueButtonSignInPage");
        commonFunctions.clickElement(proceedWithoutAppleID, 20, "proceedWithoutAppleID");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button");
        commonFunctions.clickElementIfDisplayed(closeWhatsupIcon, 10, "Close whatsapp button");
        isLoginSuccessful = commonFunctions.isElementDisplayed(myAccountWithArrow, 20, "My Account");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithNonSuscribedUser(String [] params) {
        boolean isSignInButtonDisplayed;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions.clickElement(home, 20, "Home");
        commonFunctions.dummyWait(20);
        isSignInButtonDisplayed=commonFunctions.isElementDisplayed(signInButton, 20, "signInButton");
        return isSignInButtonDisplayed;
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
    public boolean loginWithSubscribedUser(String email, String password,String expectedUserName) {return false;}
    @Override
    public boolean loginWithNonSubscribedUser(String email, String password, String expectedUserName) {return false;}

    @Override
    public boolean checkSubscribedUserLogin(String email, String password, String expectedUserName) {
        return false;
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