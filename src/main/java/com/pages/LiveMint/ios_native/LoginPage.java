package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonLoginPage;

import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask')]")
    private static MobileElement notificationAskNotToTrack;

    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SKIP']")
    private static MobileElement skipButton;

   @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic profile dark'`][2]")
    //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Sign in'])[2]")
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

    @iOSXCUITFindBy(id = "Your WSJ subscription is active")
    private static MobileElement WSJSubscriptionText;

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

    @iOSXCUITFindBy(id = "Logout")
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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static MobileElement googleSignInOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Apple')]")
    private static MobileElement continueWithAppleButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[@name='Turn On Siri']")
    private static MobileElement siriAllow;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "Cancel")
    private static MobileElement linkUserCancelButton;
    @iOSXCUITFindBy(id = "my profile cross")
    private static MobileElement myProfileCrossIcon;
    @iOSXCUITFindBy(accessibility = "logo01Latest")
    private static MobileElement mintLogo;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'premiumLiveMintLogo'`][2]")
    private static MobileElement mintPremiumLogo;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(siriAllow,10, "Siri Allow");
//        commonFunctions.clickElementIfDisplayed(acceptAllCookies, 10, "accept cookie button");
//        commonFunctions.clickElementIfDisplayed(trackingDenielButton, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");    }


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
    public boolean logout() {
        commonFunctions.clickElement(home,10,"Home button");
        commonFunctions.clickElement(signInButton, 10, "My Account Button");
        commonFunctions.scrollDownToElement(LogoutButton);
        commonFunctions.clickElement(LogoutButton, 10, "Logout Button");
        commonFunctions.clickElementIfDisplayed(okButtonLogoutPopUp, 10, "ok Button Logout PopUp");
        return commonFunctions.isElementDisplayed(signInButton, 10, "post SignIn Button Text");
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful, checkEmailStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        boolean isSignInButtonDisplayed=commonFunctions.isElementDisplayed(signInButton, 10, "signInButton");
        if(isSignInButtonDisplayed){
            commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        }else{
            commonFunctions.tapElementWithCoOrdinates(350, 73, "signInButton");
        }
        boolean isLoginOrRegisterLabel = commonFunctions.isElementDisplayed(loginOrRegister, 10, "Login or Register label");
        boolean signInWithFacebookLabelStatus = commonFunctions.isElementDisplayed(continueWithFacebookLabel, 10, "Continue With Facebook label");
        commonFunctions.clickElement(continueWithFacebookLabel, 10, "Continue With Facebook label");
        String alertValue = commonFunctions.getAlertText("Mint Wants to Use facebook.com to Sign In alert", 10);
        if (alertValue.contains("“Mint” Wants to Use “facebook.com” to Sign In")) {
            Utils.logStepInfo(true, "“Mint” Wants to Use “facebook.com” to Sign In is displayed in alert");
        } else {
            Utils.logStepInfo(true, "“Mint” Wants to Use “facebook.com” to Sign In is NOT displayed in alert");
        }
        commonFunctions.switchToDefaultContent();
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continueButtonSignInPage");
        commonFunctions.clickElementIfDisplayed(acceptAllCookies, 10, "accept All Cookies");
        commonFunctions.clickElement(emailOrPhoneFacebookSignInPage, 10, "Email/Phone Button in Facebook");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "Email/Phone Button in Facebook");
        commonFunctions.clickElement(passwordFacebookSignInPage, 10, "Password text box in facebook");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password text box in facebook");
        commonFunctions.dummyWait(5);
        boolean isFbSignInButtonDisplayed=commonFunctions.isElementDisplayed(loginButtonFacebookSignInPage, 10, "signInButton in fb");
        if(isFbSignInButtonDisplayed){
            commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "Sign In Button in fb");
        }else if(isFbSignInButtonDisplayed=commonFunctions.isElementDisplayed(loginButtonFacebookSignInPage2, 10, "signInButton in fb")){
            commonFunctions.clickElement(loginButtonFacebookSignInPage2, 10, "Sign In Button2 in fb");
        }else{
            commonFunctions.tapElementWithCoOrdinates(100, 310, "tap Login button in Facebook");
        }
        commonFunctions.clickElement(continueButton, 10, "Continue Button in Facebook");
        commonFunctions.clickElement(proceedWithoutAppleID, 10, "proceedWithoutAppleID");
        commonFunctions.clickElement(MyAccount, 10, "My Account Button");
        commonFunctions.isElementDisplayed(editProfile, 10, "Edit Option");
        checkEmailStatus = commonFunctions.checkElementText(emailAfterLoginWithFacebook, email, 10, "Email id ");
        commonFunctions.clickElement(closeIconInProfile, 10, "closeIcon in edit profile");
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
        commonFunctions.clickElementIfDisplayed(home, 10, "Home");
        commonFunctions.dummyWait(5);
        boolean isSignInButtonDisplayed=commonFunctions.isElementDisplayed(signInButton, 20, "sign In Button");
        if(isSignInButtonDisplayed){
            commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        }else{
            commonFunctions.tapElementWithCoOrdinates(353, 63, "sign In Button");
        }
        commonFunctions.clickElement(emailTextBoxMainSignInPage, 15, "email Text Box Main SignIn Page");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 10, "email Text Box Main SignIn Page");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue Button SignIn Page");
        commonFunctions.clickElement(passwordTextBoxMainSignInPage, 10, "password Text Box Main SignIn Page");
        commonFunctions.sendKey(passwordTextBoxMainSignInPage, password, 10, "password Text Box Main SignIn Page");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue Button SignIn Page");
        commonFunctions.clickElement(proceedWithoutAppleID, 10, "proceed Without AppleID");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button");
        commonFunctions.clickElementIfDisplayed(closeWhatsupIcon, 10, "Close whatsapp button");
        commonFunctions.clickElement(signInButton, 10, "sign In Button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName,10, "User Name Label - ");
        commonFunctions.clickElement(closeIconInProfile,10,"Close MyAccount");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithPassword(String[] params) {
        boolean isShowing;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        String email = params[2];
        String password = params[1];
        String expectedUserName = params[0];
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(signInButton, 10, "sign In Button");
        if (isShowing) {
            commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        } else {
            commonFunctions.tapElementWithCoOrdinates(353, 63, "sign In Button");
        }
        commonFunctions.clickElement(emailTextBoxMainSignInPage, 10, "email Text Box Main SignIn Page");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 10, "email Text Box Main SignIn Page");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue Button SignIn Page");
        commonFunctions.clickElement(passwordTextBoxMainSignInPage, 10, "password Text Box Main SignIn Page");
        commonFunctions.sendKey(passwordTextBoxMainSignInPage, password, 10, "password Text Box Main SignIn Page");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continue Button SignIn Page");
        commonFunctions.clickElementIfDisplayed(linkUserCancelButton, 10, "link User Cancel Button");
        commonFunctions.clickElementIfDisplayed(proceedWithoutAppleID, 10, "proceed Without AppleID");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button");
        commonFunctions.clickElementIfDisplayed(closeWhatsupIcon, 10, "Close whatsapp button");
        commonFunctions.clickElement(signInButton, 10, "sign In Button");
        isShowing &= commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName,10, "User Name Label - ");
        commonFunctions.clickElement(myProfileCrossIcon, 10, "cross icon");
        return isShowing;
    }

    @Override
    public boolean loginWithSubScribedUser(String[] params) {
        boolean isShowing;
        isShowing = loginWithPassword(params[2], params[1], params[0]);
        isShowing &= commonFunctions.isElementDisplayed(mintPremiumLogo, 10, "mintPremium logo");
        return isShowing;
    }

    @Override
    public boolean loginWithNonSubScribedUser(String[] params) {
        boolean isShowing;
        isShowing = loginWithPassword(params[2], params[1], params[0]);
        isShowing &= commonFunctions.isElementNotDisplayed(mintPremiumLogo, 10, "mintPremium logo");
        return isShowing;
    }

    @Override
    public boolean verifyPlanDetails(){
        commonFunctions.clickElement(myAccountButton,10,"Click Account button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(WSJSubscriptionText,10,"WSJ text");
    }

    @Override
    public boolean loginWithNonSuscribedUser(String[] params) {
        boolean isSignInButtonDisplayed;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        isSignInButtonDisplayed=commonFunctions.isElementDisplayed(signInButton, 10, "signInButton");
        return isSignInButtonDisplayed;
    }

    @Override
    public boolean checkSignInLinkRedirection() {
        boolean checkSignInLinkRedirectionStatus;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
       boolean isSignInButtonDisplayed=commonFunctions.isElementDisplayed(signInButton, 10, "signInButton");
        if(isSignInButtonDisplayed){
            commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        }else{
            commonFunctions.tapElementWithCoOrdinates(350, 73, "signInButton");
        }
        commonFunctions.dummyWait(5);
        boolean checkSignInLinkEmailStatus=commonFunctions.isElementDisplayed(emailTextBoxMainSignInPage, 10, "Email");
        boolean checkSignInLinkFBStatus=commonFunctions.isElementDisplayed(continueWithFacebookButton, 10, "FB");
        boolean checkSignInLinkAppleStatus=commonFunctions.isElementDisplayed(continueWithAppleButton, 10, "Apple");
        boolean checkSignInLinkGoogleStatus=commonFunctions.isElementDisplayed(continueWithGoogleButton, 10, "Google");
        commonFunctions.clickElement(back, 10, "Back to Home");
        if (checkSignInLinkEmailStatus && checkSignInLinkFBStatus && checkSignInLinkAppleStatus && checkSignInLinkGoogleStatus) {
            checkSignInLinkRedirectionStatus = true;
        } else {
            checkSignInLinkRedirectionStatus = false;
        }
        return checkSignInLinkRedirectionStatus;
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