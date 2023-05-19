package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonBookmarkPage;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookmarkPage extends CommonBookmarkPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonHomePage homePage;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    //android.widget.ImageButton[@content-desc='Open navigation drawer']
    private static MobileElement hamBurger;

   /* @AndroidFindBy(id = "com.ht.news:id/ivProfile")
    ////a[text()='Sign in']//div[@id='divsso']/a[1]  //accessibility = "Sign in Hindustantimes Login" ////android.view.View[@content-desc='Sign in']/android.widget.TextView
    private static MobileElement singInButton;*/

    @AndroidFindBy(id = "com.htmedia.mint:id/action_epaper")
    private static MobileElement SignInButton;
    // com.htmedia.mint:id/txtViewEpaper
    @AndroidFindBy(id = "com.ht.news:id/google_btn")
    private static MobileElement continueWithGoogleButton;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;

    @FindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement darkModeYes;
    @FindBy(id = "com.htmedia.mint:id/layoutHeaderAdsBG")
    private static MobileElement homepageTopAd;

    @AndroidFindBy(id = "com.ht.news:id/apple_btn")
    private static MobileElement continueWithAppleID;

    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement explore;

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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MY READS']")
    private static MobileElement myReadsPageHeader;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView")
    private static MobileElement myReadsEmptyImage;

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
    @FindBy(xpath = "//android.widget.TextView[@text='My Reads']")
    private static MobileElement myReads;

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
    @AndroidFindBy(id = "com.htmedia.mint:id/close_iv")
    private static MobileElement whatsappCloseIcon;
    @FindBy(id = "com.htmedia.mint:id/imgViewBookmark")
    private static MobileElement bookmarkIcon;
    @FindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement loginBox;
    @FindBy(id = "com.htmedia.mint:id/password_et")
    private static MobileElement passwordBox;
    @FindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    private static MobileElement loginButton;
    @FindBy(id = "android:id/button1")
    private static MobileElement loginPopup;
    @FindBy(id = "com.htmedia.mint:id/continue_btn")
    private static MobileElement continueLogin;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;


    public BookmarkPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        homePage = CommonHomePage.getInstance();
    }


    @Override
    public boolean checkBookmarkFunctionalityRedirectionToLoginPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkFunctionalityRedirectionAfterLogin(String email, String password) {
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.clickElement(bookmarkIcon, 10 , "Bookmark Button");
        boolean LoginPopupAppears=commonFunctions.isElementDisplayed(loginPopup, 10, "Login Popup");
        commonFunctions.clickElement(loginButton, 10 , "Login Button in Popup");
        boolean LoginButtonRedirection=commonFunctions.isElementDisplayed(loginBox, 10, "Email or Mobile Login Box");
        commonFunctions.sendKey(loginBox, email, 10, "Email id");
        commonFunctions.clickElement(continueLogin, 10, "Continue for login");
        commonFunctions.isElementDisplayed(passwordBox, 10, "Password box");
        commonFunctions.sendKeyBoolean(passwordBox, password, 10, "Password");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Continue Sign in button");
        boolean BookmarkFocus= commonFunctions.isElementDisplayed(bookmarkIcon, 10, "Story Bookmark button");
        commonFunctions.clickElement(bookmarkIcon, 10, "Bookmark Story");

        return LoginPopupAppears && LoginButtonRedirection && BookmarkFocus;
    }


    public void clickOnHomeButtonWithHandlingDarkMode(){
        commonFunctions.clickElement(home, 10, "Home button");
    }

    @Override
    public boolean checkBookmarkFunctionalityRedirectionAsSubscribedUser(String email, String password) {
        return false;
    }

    @Override
    public boolean checkBookmarkFunctionalityOnStoryDetailPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkPageEmptyForNonLoggedUser() {
        commonFunctions.clickElement(home, 10, "HomePage Button");
        commonFunctions.clickElement(explore, 10, "Explore Button");
        commonFunctions.dummyWait(5);
        boolean checkBookmarkPage = commonFunctions.isElementDisplayed(myReads, 10, "My Reads/Bookmark Button");
        commonFunctions.clickElement(myReads, 10, "My Reads Page");
        boolean isBookmarkPageAccessable = commonFunctions.isElementDisplayed(myReadsPageHeader, 10, "My Reads Page Header");
        commonFunctions.isElementDisplayed(myReadsEmptyImage, 10, "MyReads Page Empty Image");
        boolean isEmptyImageDisplayed = commonFunctions.isElementVisible(myReadsEmptyImage, 10, "MyReads Page Empty Image");
        commonFunctions.navigateBack();
        commonFunctions.navigateBack();
        commonFunctions.clickElement(home, 10, "HomePage Button");
        return checkBookmarkPage && isBookmarkPageAccessable && isEmptyImageDisplayed;
    }

    @Override
    public boolean checkBookmarkStoryOnBookmarkPage(String email, String password) {
        return false;
    }
}
