package com.pages.LiveMint.AndroidNativePages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonLoginPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    //android.widget.ImageButton[@content-desc='Open navigation drawer']
    private static MobileElement hamBurger;

    @AndroidFindBy(id = "com.ht.news:id/ivProfile")
    ////a[text()='Sign in']//div[@id='divsso']/a[1]  //accessibility = "Sign in Hindustantimes Login" ////android.view.View[@content-desc='Sign in']/android.widget.TextView
    private static MobileElement singInButton;

    @AndroidFindBy(id = "com.ht.news:id/text_profile")
    private static MobileElement SignInButton;

    @AndroidFindBy(id = "com.ht.news:id/google_btn")
    private static MobileElement continueWithGoogleButton;

    @AndroidFindBy(id = "com.ht.news:id/apple_btn")
    private static MobileElement continueWithAppleID;

    @AndroidFindBy(id = "com.htmedia.mint:id/fb_login_container")
    private static MobileElement continueWithFacebookButton;

    @AndroidFindBy(id = "com.ht.news:id/email_or_mobile_et")
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

    @AndroidFindBy(id = "com.htmedia.mint:id/name")
    private static MobileElement userNameLabelAfterLogin;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Continue')]")
    private static MobileElement continueButtonFacebookAfterUsernamePassword;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtLogout")
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    private static MobileElement MyAccount;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Edit Profile']")
    private static MobileElement editProfile;

    @AndroidFindBy(id = "com.htmedia.mint:id/email")
    private static MobileElement emailIDUsed;

    @FindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement closeEditProfile;

    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private static MobileElement okButton;

    @FindBy(id = "com.htmedia.mint:id/nav_home")
    private static MobileElement home;

    @FindBy(id="c5503239-903a-4c4c-88a4-fbc1eb49052c")
    private static MobileElement skipBtn;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }


    @Override
    public boolean logout() {
        boolean isUserSignedOut = false;
        commonFunctions.clickElement(home, 60, "Home");
        commonFunctions.clickElement(MyAccount, 60, "My Account Button");
        commonFunctions.dummyWait(10);
        commonFunctions.swipeElementUsingTouchAction(900,1900, 900, 1200);
        commonFunctions.clickElement(LogoutButton, 60, "LogoutButton");
        isUserSignedOut = commonFunctions.isElementDisplayed(SignInButton, 20, "Sign-In Button");
        return isUserSignedOut;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
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
        commonFunctions.clickElementWithJS(skipBtn,60,"Skip button.");
        commonFunctions.clickElementWithJS(SignInButton, 60, "Sign-In button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 60, "Email/Phone TextBox");
        commonFunctions.clickElementWithJS(continueButtonSignInPage, 60, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 60, "Password Textbox");
        commonFunctions.clickElement(signInButtonMainSignInPage, 60, "Sign-In button");
        commonFunctions.clickElementIfDisplayed(okButton,10,"ok button");
        commonFunctions.clickElement(profileButton, 60, "Profile Icon");
        isLoginSuccessful = commonFunctions.checkElementTextReload(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        commonFunctions.clickElement(closeEditProfile, 60, "closeIcon in edit profile");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful, checkEmailStatus;
        commonFunctions.clickElement(SignInButton, 60, "Sign In Button");
        boolean isLoginOrRegisterLabel = commonFunctions.isElementDisplayed(loginOrRegister, 60, "Login or Register label");
        boolean signInWithFacebookLabelStatus = commonFunctions.isElementDisplayed(continueWithFacebookLabel, 30, "Continue With Facebook label");
        commonFunctions.clickElement(continueWithFacebookLabel, 60, "Continue With Facebook label");
        commonFunctions.clickElement(emailOrPhoneFacebookSignInPage, 60, "Email/Phone Button in Facebook");
        commonFunctions.sendKeyBoolean(emailOrPhoneFacebookSignInPage, email, 60, "Email/Phone Button in Facebook");
        commonFunctions.clickElement(passwordFacebookSignInPage, 60, "Password text box in facebook");
        commonFunctions.sendKeyBoolean(passwordFacebookSignInPage, password, 60, "Password text box in facebook");
        commonFunctions.clickElement(loginButtonFacebookSignInPage, 60, "LogIn Button in Facebook");
        commonFunctions.clickElement(continueButtonFacebookAfterUsernamePassword, 60, "Continue Button in Facebook");
        commonFunctions.clickElement(MyAccount, 60, "My Account Button");
        commonFunctions.isElementDisplayed(editProfile, 60, "Edit Option");
        String actualEmail = commonFunctions.getElementText(emailIDUsed);
        checkEmailStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID");
        commonFunctions.clickElement(closeEditProfile, 60, "closeIcon in edit profile");
        if (isLoginOrRegisterLabel && signInWithFacebookLabelStatus && checkEmailStatus ) {
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