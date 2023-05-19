package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonLoginPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsMobileLM;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    //android.widget.ImageButton[@content-desc='Open navigation drawer']
    private static MobileElement hamBurger;

   /* @AndroidFindBy(id = "com.ht.news:id/ivProfile")
    ////a[text()='Sign in']//div[@id='divsso']/a[1]  //accessibility = "Sign in Hindustantimes Login" ////android.view.View[@content-desc='Sign in']/android.widget.TextView
    private static MobileElement singInButton;*/

    @AndroidFindBy(id = "com.htmedia.mint:id/action_signin")
    private static MobileElement SignInButton;
    // com.htmedia.mint:id/txtViewEpaper
    @AndroidFindBy(id = "com.ht.news:id/google_btn")
    private static MobileElement continueWithGoogleButton;

    @FindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement darkModeYes;
    @FindBy(id = "com.htmedia.mint:id/layoutHeaderAdsBG")
    private static MobileElement homepageTopAd;

    @AndroidFindBy(id = "com.ht.news:id/apple_btn")
    private static MobileElement continueWithAppleID;

    @AndroidFindBy(id = "com.htmedia.mint:id/fb_login_container")
    private static MobileElement continueWithFacebookButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement emailTextBoxMainSignInPage;

    @AndroidFindBy(id = "com.htmedia.mint:id/continue_btn")
    private static MobileElement continueButtonSignInPage;

    @AndroidFindBy(id = "com.htmedia.mint:id/password_et")
    private static MobileElement passwordTextBoxMainSignInPage;

    @AndroidFindBy(xpath = "(//android.widget.Button[@text='Continue'])[2]")
    private static MobileElement signInButtonMainSignInPage;

    @AndroidFindBy(xpath = "//div[text()='Use another account']")
    private static MobileElement useAnotherAccountGmailSignInPage;

    @AndroidFindBy(className = "android.widget.EditText")
    private static MobileElement emailOrPhoneGmailSignInPage;

    //    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='m_login_email']")
    @AndroidFindBy(xpath = "(//android.widget.EditText[@class='android.widget.EditText'])[1]")
    private static MobileElement emailOrPhoneFacebookSignInPage;

    //    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='m_login_password']")
    @AndroidFindBy(xpath = "(//android.widget.EditText[@class='android.widget.EditText'])[2]")
    private static MobileElement passwordFacebookSignInPage;

    //    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log In']")
//    @AndroidFindBy(xpath = "//android.view.View[@resource-id='login_password_step_element']")
    @AndroidFindBy(xpath = "(//android.widget.Button[@class='android.widget.Button'])[1]")
    private static MobileElement loginButtonFacebookSignInPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    //android.widget.Button[@text='Next']  //android.widget.Button[@content-desc='Next ']
    private static MobileElement nextButtonGmailSignInPage;

    @AndroidFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Continue')]")
    private static MobileElement continueButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='NEXT']")
    private static MobileElement nextButtonGmailPasswordPage;

    @AndroidFindBy(className = "android.widget.EditText")
    //android.widget.EditText)[1] //android.widget.EditText[@text='Enter your password']
    private static MobileElement passwordTextBoxGmailSignInPage;

    @AndroidFindBy(id = "com.htmedia.mint:id/tvUserName")
    private static MobileElement userNameLabelAfterLogin;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Continue')]")
    private static MobileElement continueButtonFacebookAfterUsernamePassword;

    @AndroidFindBy(xpath = "//*[@text='LOGOUT']")
    private static MobileElement LogoutButton;

    @AndroidFindBy(id = "generate_otp") //android.widget.TextView[@text='Generate OTP']
    private static MobileElement generateOtpMainSignInPage;

    @AndroidFindBy(id = "reGenOtpForgot")
    private static MobileElement reGenerateOtpMainSignInPage;
    @AndroidFindBy(id = "loginOTP")
    private static MobileElement sigInWithOtpButtonMainSignInPage;

    @AndroidFindBy(className = "crossicon")
    private static MobileElement closeIconHamburger;

    @AndroidFindBy(id = "android:id/button1")
    private static MobileElement yesButtonLogoutPopUp;

    @AndroidFindBy(id = "com.ht.news:id/ep_txt")
    private static MobileElement ePaperTextLabel;

    @AndroidFindBy(id = "com.htmedia.mint:id/action_profile")
    private static MobileElement profileButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/name")
    private static MobileElement username;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue with Facebook']")
    private static MobileElement continueWithFacebookLabel;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='CREATE NEW FACEBOOK ACCOUNT']")
    private static MobileElement createNewFacebookAccount;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone or Email']")
    private static MobileElement facebookEmailID;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private static MobileElement facebookPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login or Register']")
    private static MobileElement loginOrRegister;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN']")
    private static MobileElement LogInButtonFacebook;

    @AndroidFindBy(id = "com.htmedia.mint:id/action_profile")
    private static MobileElement MyAccount;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Edit Profile']")
    private static MobileElement editProfile;

    @AndroidFindBy(id = "com.htmedia.mint:id/email")
    private static MobileElement emailIDUsed;

    @FindBy(id = "com.htmedia.mint:id/imgCrossProfile")
    private static MobileElement closeEditProfile;

    @FindBy(id = "com.htmedia.mint:id/close_iv")
    private static MobileElement closeAdPopUp;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private static MobileElement okButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement home;

    @FindBy(id = "c5503239-903a-4c4c-88a4-fbc1eb49052c")
    private static MobileElement skipBtn;

    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/viewImageShimmer")
    private static MobileElement welcomeBackPopup;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtSubscribe")
    private static MobileElement subscribeButton;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;

    @AndroidFindBy(id = "com.htmedia.mint:id/close_iv")
    private static MobileElement whatsappCloseIcon;

    @AndroidFindBy(id = "com.htmedia.mint:id/dismiss")
    private static MobileElement rateAppLater;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(id = "com.htmedia.mint:id/otp_et")
    private static MobileElement otpInput;
    @FindBy(xpath = "//*[@text='VERIFY EMAIL ID']")
    private static MobileElement otpInputPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Google']")
    private static MobileElement googleOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Facebook']")
    private static MobileElement facebookOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apple']")
    private static MobileElement appleOption;
    @FindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @FindBy(id = "com.htmedia.mint:id/epaper_paywall_container")
    private static MobileElement epaperPaywall;
    @FindBy(xpath = "//*[@resource-id='identifierId']")
    private static MobileElement emailTextBox;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
    private static MobileElement nextButtonGmailSignIn;
    @FindBy(xpath = "//*[@resource-id='password']/android.view.View/android.view.View/android.widget.EditText")
    private static MobileElement passwordTextBox;
    @FindBy(xpath = "//*[@text='I agree']")
    private static MobileElement iAgree;
    @FindBy(xpath = "//android.widget.Button[@text='More']")
    private static MobileElement MoreBtn;
    @FindBy(xpath = "//android.widget.Button[@text='Accept']")
    private static MobileElement acceptBtn;
    @FindBy(xpath = "//android.view.View[@content-desc='facebook']")
    private static MobileElement facebookEmailPage;
    @FindBy(xpath = "//*[@resource-id='m_login_email']")
    private static MobileElement emailInputBox;
    @FindBy(xpath = "//*[@resource-id='m_login_password']")
    private static MobileElement passwordInputBox;
    @FindBy(xpath = "//android.widget.Button[@text='Log in']")
    private static MobileElement loginInBtn;
    @FindBy(xpath = "//android.widget.Button[@text='Continue']")
    private static MobileElement ContinueBtn;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLM= CommonFunctionsMobileLM.getInstance();
        commonFunctions.clickElementIfDisplayed(continueAdsPopup,5,"continue Ads Popup");
        commonFunctions.clickElementIfDisplayed(skipAdsButton, 5, "skip ads Popup");
        commonFunctions.clickElementIfDisplayed(yesIAmInButton, 5, "Yes I am in Popup");
        commonFunctions.clickElementIfDisplayed(skipAdsButton, 5, "skip ads Popup");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(388, 1747);
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
    }


    @Override
    public boolean logout() {
        boolean isUserSignedOut = false;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.clickElement(MyAccount, 10, "My Account Button");
        commonFunctions.dummyWait(5);
        commonFunctions.checkElementVisibilityByScrolling(LogoutButton,"logout");
        commonFunctions.clickElement(LogoutButton, 10, "LogoutButton");
        isUserSignedOut = commonFunctions.isElementDisplayed(SignInButton, 20, "Sign-In Button");
        return isUserSignedOut;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String accessAccount, String cookie, String refreshAPI) {
        return false;
    }


    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isShowing;
        commonFunctions.clickElementIfDisplayed(home, 10, "Homepage Tab");
        commonFunctions.clickElementIfDisplayed(SignInButton, 20, "Sign In Button");
        isShowing = commonFunctions.isElementDisplayed(googleOption, 20, "login option: Google");
        commonFunctions.clickElement(googleOption, 20, "login option: Google");
        commonFunctions.sendKey(emailTextBox, email, 20, "email input box");
        commonFunctions.clickElement(nextButtonGmailSignIn, 10, "Next button email page");
        commonFunctions.isElementDisplayed(passwordTextBox,10,"password text box");
        commonFunctions.sendKey(passwordTextBox, password, 10, "password box");
        commonFunctions.clickElement(nextButtonGmailSignIn, 10, "Next button password page");
        commonFunctions.clickElementIfDisplayed(iAgree, 10, "I agree btn");
        commonFunctions.clickElementIfDisplayed(MoreBtn, 5, "More btn");
        commonFunctions.clickElementIfDisplayed(acceptBtn, 10, "Accept btn");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        isShowing &= commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 20, "closeIcon in edit profile");
        return isShowing;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isShowing;
        commonFunctions.clickElementIfDisplayed(home, 10, "Homepage Tab");
        commonFunctions.clickElementIfDisplayed(SignInButton, 20, "Sign In Button");
        isShowing = commonFunctions.isElementDisplayed(facebookOption, 20, "facebook option: Google");
        commonFunctions.clickElement(facebookOption, 20, "login option: Facebook");
        commonFunctions.isElementDisplayed(facebookEmailPage, 10, "facebook login Page");
        commonFunctions.sendKey(emailInputBox, email, 10, "email Input Box");
        commonFunctions.dummyWait(2);
        commonFunctions.sendKey(passwordInputBox, password, 10, "password input box");
        commonFunctions.isElementDisplayed(loginInBtn, 10, "login btn");
        commonFunctions.clickElement(loginInBtn, 10, "login button");
        commonFunctions.clickElementIfDisplayed(ContinueBtn, 10, "continue button");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        isShowing &= commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 20, "closeIcon in edit profile");
        return isShowing;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.clickElement(home, 10, "Homepage Tab");
        commonFunctions.clickElement(SignInButton, 20, "Sign In Button");
        /*commonFunctions.clickElement()*/
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 20, "Continue Button");
        commonFunctions.isElementDisplayed(passwordTextBoxMainSignInPage, 20, "Password Textbox");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 20, "Password Textbox");
        commonFunctions.clickElement(signInButtonMainSignInPage, 20, "Sign-In button");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button to refresh before login page.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 10, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 5, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        commonFunctions.dummyWait(5);
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 20, "closeIcon in edit profile");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful, checkEmailStatus;
        if (commonFunctions.isElementDisplayed(skipBtn)) {
            commonFunctions.clickElement(skipBtn, 10, "Skip button.");
        }
        if (commonFunctions.isElementDisplayed(yesIAmButton, 10, "Dark theme accept button")) {
            commonFunctions.clickElement(yesIAmButton, 10, "Dark theme accept button");
        }
        commonFunctions.clickElement(SignInButton, 10, "Sign In Button");
        boolean isLoginOrRegisterLabel = commonFunctions.isElementDisplayed(loginOrRegister, 10, "Login or Register label");
        boolean signInWithFacebookLabelStatus = commonFunctions.isElementDisplayed(continueWithFacebookLabel, 10, "Continue With Facebook label");
        commonFunctions.clickElement(continueWithFacebookLabel, 10, "Continue With Facebook label");
        commonFunctions.clickElement(emailOrPhoneFacebookSignInPage, 10, "Email/Phone Button in Facebook");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 10, "Email/Phone Button in Facebook");
        commonFunctions.clickElement(passwordFacebookSignInPage, 10, "Password text box in facebook");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 10, "Password text box in facebook");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 10, "LogIn Button in Facebook");
        commonFunctions.clickElement(continueButtonFacebookAfterUsernamePassword, 10, "Continue Button in Facebook");
        if (commonFunctions.isElementDisplayed(MyAccount, 100, "My Account Button")) {
            commonFunctions.clickElement(MyAccount, 10, "My Account Button");
        }
        commonFunctions.isElementDisplayed(editProfile, 10, "Edit Option");
        String actualEmail = commonFunctions.getElementText(emailIDUsed);
        checkEmailStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID");
        commonFunctions.clickElement(closeEditProfile, 10, "closeIcon in edit profile");
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
    public boolean loginWithNonSuscribedUser(String[] params) {
        return false;
    }

    @Override
    public boolean loginWithPassword(String[] params) {
        boolean isShowing;
        String email= params[2];
        String password=params[1];
        String expectedUserName=params[1];
        commonFunctions.clickElement(home, 10, "Home button");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(SignInButton, 20, "sign-in button");
        commonFunctions.clickElement(SignInButton, 20, "Sign In Button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 20, "email Inbox");
        commonFunctions.clickElement(continueButtonSignInPage, 20, "Continue button after email");
        commonFunctions.sendKey(passwordTextBoxMainSignInPage, password, 20, "password");
        commonFunctions.clickElement(signInButtonMainSignInPage, 20, "Sign-In button");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button to refresh before login page.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 10, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 5, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        isShowing = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 20, "closeIcon in edit profile");
        return isShowing;
    }

    @Override
    public boolean verifyPlanDetails() {
        return false;
    }

    private boolean commonLoginSteps(String email, String password, String expectedUserName) {
        boolean isShowing;
        commonFunctions.clickElement(home,10,"home button");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(SignInButton, 10, "sign-in button");
        commonFunctions.clickElement(SignInButton, 10, "Sign In Button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 10, "email Inbox");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue button after email");
        commonFunctions.sendKey(passwordTextBoxMainSignInPage, password, 10, "password");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Sign-In button");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button to refresh before login page.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 10, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 5, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        isShowing = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 10, "closeIcon in edit profile");
        return isShowing;
    }

    @Override
    public boolean loginWithSubscribedUser(String email, String password, String expectedUserName) {
        boolean isShowing;
        isShowing = commonLoginSteps(email, password, expectedUserName);
        isShowing &= commonFunctions.isElementNotDisplayed(subscribeButton, 10, "subscribe Buttom");
        return isShowing;
    }

    @Override
    public boolean loginWithNonSubscribedUser(String email, String password, String expectedUserName) {
        boolean isShowing;
        isShowing = commonLoginSteps(email, password, expectedUserName);
        isShowing &= commonFunctions.isElementDisplayed(subscribeButton, 10, "subscribe Buttom");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedUserLogin(String email, String password, String expectedUserName) {
        commonFunctions.clickElement(darkModeYes, 10, "Dark Mode Popup");
        commonFunctions.clickElement(home, 10, "HomePage Button");
        commonFunctions.clickElement(SignInButton, 10, "Sign in Button");
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 10, "email Inbox");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue button after email");
        commonFunctions.sendKey(passwordTextBoxMainSignInPage, password, 10, "password");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Sign-In button");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button to refresh before login page.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 10, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 5, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        boolean userLoggedIn=commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 10, "closeIcon in edit profile");
        commonFunctions.clickElement(home, 10, "Homepage button");
        boolean isSubscribedUserAdsFree=commonFunctions.isElementNotDisplayed(homepageTopAd, 10, "Homepage Ad");
        return userLoggedIn && isSubscribedUserAdsFree;
    }

    @Override
    public boolean loginWithSubScribedUser(String[] params) {
        boolean isShowing;
        isShowing = loginWithPassword(params[2], params[1], params[0]);
        isShowing &= commonFunctions.isElementNotDisplayed(subscribeButton, 10, "subscribe Buttom");
        return isShowing;
    }

    @Override
    public boolean loginWithNonSubScribedUser(String[] params) {
        boolean isShowing;
        isShowing = loginWithPassword(params[2], params[1], params[0]);
        isShowing &= commonFunctions.isElementDisplayed(subscribeButton, 10, "subscribe Buttom");
        return isShowing;
    }

    private void commonStepForLogin(String email, String apiURI, String accessAccount, String cookie, String refreshAPI) {
        boolean OTPLimitReached;
        String otp;
        commonFunctions.clickElementIfDisplayed(home, 10, "Homepage Tab");
        commonFunctions.clickElementIfDisplayed(SignInButton, 10, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 20, "Email/Phone TextBox");
        commonFunctions.clickElement(continueButtonSignInPage, 20, "Continue Button");
        OTPLimitReached = commonFunctions.isElementNotDisplayed(otpInputPage, 5, "OTP input");
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
        if(commonFunctions.isElementDisplayedAndPresent(explorePage,5,"explore page")){
            commonFunctions.navigateBack();
        }
        if(commonFunctions.isElementDisplayedAndPresent(epaperPaywall,5,"epaper paywall")){
            commonFunctions.navigateBack();
            commonFunctions.dummyWait(1);
            commonFunctions.navigateBack();
        }
        commonFunctions.clickElementIfDisplayed(okButton, 5, "Ok button to refresh before login page.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 10, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(whatsappCloseIcon, 5, "close icon for Get updates on Whatsapp.");
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Close Ad PopUp");
        commonFunctions.clickElementIfDisplayed(home, 10, "Homepage Tab");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        commonFunctions.dummyWait(5);
        boolean isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 20, "closeIcon in edit profile");
        isLoginSuccessful &= commonFunctions.isElementNotDisplayed(subscribeButton, 10, "subscribe Button");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithOTPNonSubScribedUser(String email, String apiURI, String accessAccount, String cookie, String refreshAPI,String expectedUserName) {
        commonStepForLogin(email,apiURI,accessAccount,cookie,refreshAPI);
        if(commonFunctions.isElementDisplayedAndPresent(explorePage,5,"explore page")){
            commonFunctions.navigateBack();
        }
        if(commonFunctions.isElementDisplayedAndPresent(epaperPaywall,5,"epaper paywall")){
            commonFunctions.navigateBack();
            commonFunctions.dummyWait(1);
            commonFunctions.navigateBack();
        }
        commonFunctions.clickElementIfDisplayed(home, 10, "Homepage Tab");
        commonFunctions.clickElement(MyAccount, 10, "MyAccount button");
        commonFunctions.dummyWait(5);
        boolean isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        commonFunctions.clickElement(closeEditProfile, 20, "closeIcon in edit profile");
        isLoginSuccessful &= commonFunctions.isElementDisplayed(subscribeButton, 10, "subscribe Button");
        return isLoginSuccessful;
    }

    @Override
    public boolean checkAllLoginOption() {
        commonFunctions.clickElement(home, 10, "Homepage Tab");
        commonFunctions.clickElement(SignInButton, 20, "Sign In Button");
        boolean isShowing = commonFunctions.isElementDisplayed(emailTextBoxMainSignInPage, 20, "login option: Email/Phone");
        isShowing &= commonFunctions.isElementDisplayed(googleOption, 20, "login option: Google");
        isShowing &= commonFunctions.isElementDisplayed(facebookOption, 20, "login option: Facebook");
        isShowing &= commonFunctions.isElementDisplayed(appleOption, 20, "login option: Apple");
        commonFunctions.navigateBack();
        return isShowing;
    }


}
