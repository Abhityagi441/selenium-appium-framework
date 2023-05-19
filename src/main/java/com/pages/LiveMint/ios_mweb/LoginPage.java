package com.pages.LiveMint.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
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
    private  static CommonFunctionsMobileLM commonFunctionsMobileLM;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(id = "agree")
    private static WebElement agreeCookieButton;

    @FindBy(id = "topnav-sign-in")
    private static WebElement signInButton;

    @FindBy(xpath = "//a[contains(@text(),'Sign in')]")
    private static WebElement signInText;

    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;

    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;

    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;


    @FindBy(xpath = "//input[@id='lmSsoinput']")
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

    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement MyAccount;

    @FindBy(xpath = "//div[@id='webklipper-publisher-widget-container-notification-close-div']/span")
    private static WebElement offerAd;

    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
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

    //@FindBy(xpath="//*[contains(text(),'Accept')]")
    @FindBy(id="accept-cookie-banner-label")
    private static WebElement acceptAll;

    @FindBy(xpath = "(//div[@class='ng-binding'])[1]")
    private static WebElement moEngagePopupDoItLater;
    @FindBy(id = "topnav-sign-in")
    private static WebElement signInButtonInExplore;

    @FindBy(xpath =  "//div[@id='topnav-myaccount']/a")
    private static WebElement myAccountInExploreMenu;

    @FindBy(id =  "close")
    private static WebElement googleSignInPromptClose;
    @FindBy(xpath = "//div[@id='hamburgerElement']")
    private static WebElement exploreMenu;
    @FindBy(id = "headerMintLogo")
    private static WebElement getMintLogo;
    @FindBy(id="otpScreen")
    private static WebElement otpScreen;
    @FindBy (xpath="//div[@id='otpScreen']//div[contains(@class,'otpfield')]/input")
    private static List<WebElement> newOTPinput;
    @FindBy(xpath = "//div[@id='otpScreen']//span[@class='errorBox']")
    private static WebElement incorrectOTPError;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLM=CommonFunctionsMobileLM.getInstance();
        commonFunctions.clickElementIfDisplayed(agreeCookieButton, 10, "agreeCookieButton");
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
        //commonFunctions.deleteCookiesAndNavigateToHomePage();
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "Moengage notification");
        commonFunctions.clickElementWithJS(getMintLogo, 10, "mint logo");
        commonFunctions.clickElementWithJS(exploreMenu, 10, "Click on Exp");
        if (commonFunctions.isElementDisplayedAndPresent(MyAccount, 20, "My account")) {
            // commonFunctions.clickElementWithJS(MyAccount);
            logout();
            commonFunctionsMobileLM.clickElement(exploreMenu, moEngagePopupDoItLater, 10, "Click on Exp", "Notification button");
        }


        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabledReload(signInButton, 10, "singInButton")) {
                System.out.println("Waiting for element to be present signInButton");
            } else {
                commonFunctions.clickElementWithJS(signInButton, 10, "Sign In Button");
                break;
            }
        }
        commonFunctions.clickElementWithJS(emailTextBoxMainSignInPage, 10, "emil box");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "email or phone box");
        commonFunctions.hideKeyboard();
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(continueButtonSignInPage, 10, "continueButtonSignInPage")) {
                System.out.println("Waiting for element to be clickable continueButtonSignInPage");
            } else {
                commonFunctions.clickElement(continueButtonSignInPage, 10, "continue button");
                break;
            }
        }
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password box");
        commonFunctions.hideKeyboard();
        for (int i = 0; i < 4; i++) {
            if (!commonFunctions.isElementEnabled(signInButtonMainSignInPage, 10, "signInButtonMainSignInPage")) {
                System.out.println("Waiting for an element to be present signInButtonMainSignInPage");
            } else {
                commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
                break;
            }
        }
        commonFunctions.waitForURLToBe(globalVars.getURL());
        commonFunctions.clickElementWithJS(getMintLogo, 10, "mint logo");
        commonFunctions.isElementDisplayed(exploreMenu, 20, "explore menu");
        commonFunctions.clickElementWithJS(exploreMenu, 10, "click on exp");
        int attempts = 0;
        while (attempts < 5) {
            System.out.println("**** Iteration: " + attempts);
            if (commonFunctions.isElementDisplayedAndPresent(MyAccount, 10, "mu account")) {
                commonFunctions.clickElementWithJS(MyAccount, 10, "My account button");
                break;
            } else {
                Utils.logStepInfo(true, "Waiting for element to be present MyAccount");
            }
            attempts++;
        }
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
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
        commonFunctions.clickElementIfDisplayed(continueButtonFacebookSignInPage, 10, "Continue Button in Facebook");
        commonFunctions.switchToWindow(mainWindow);
        commonFunctions.dummyWait(10);
        commonFunctions.waitForURLToBe(Utils.getUrl());
        boolean liveMintURLStatus = commonFunctions.checkPageURL(Utils.getUrl(), 30, "livemint url");
        commonFunctions.dummyWait(90);
        commonFunctions.clickElementWithJS(MyAccount, 60, "My Account Button");
        commonFunctions.clickElementIfDisplayed(offerAd, 10, "Close Ad Button");
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
    public boolean logout() {
        boolean isLogoutSuccessful = false;
        boolean isMyAccountDisplayed;
        commonFunctions.pageRefresh();
        commonFunctions.scrollToTop();
        if (commonFunctions.isElementNotDisplayed(myAccountInExploreMenu, 20, "my account")) {
            commonFunctions.clickElementWithJS(exploreMenu, 10, "Click on explore");
        }
        isMyAccountDisplayed = commonFunctions.isElementDisplayed(myAccountInExploreMenu, 20, "My Account button");
        if (!isMyAccountDisplayed) {
            for (int i = 0; i < 3; i++) {
                if (commonFunctions.isElementNotDisplayed(exploreMenu, 10, "explore menu button")) {

                    //commonFunctions.refreshPage();
                    //commonFunctionsMobileLM.clickElement(exploreMenu,moEngagePopupDoItLater,10,"Click on explore","Notification pop up");
                    isMyAccountDisplayed = commonFunctions.isElementDisplayed(myAccountInExploreMenu, 30, "My Account button");
                } else {
                    commonFunctions.pageRefresh();
                    commonFunctionsMobileLM.clickElement(exploreMenu, moEngagePopupDoItLater, 10, "Click on explore", "Notification pop up");
                    isMyAccountDisplayed = commonFunctions.isElementDisplayed(myAccountInExploreMenu, 20, "My Account button");
                }
                if (isMyAccountDisplayed) {
                    break;
                }

            /*if (!commonFunctions.isElementEnabledReload(myAccountInExploreMenu, 10, "My acccount ")) {
                System.out.println("Waiting for element to be present My Account button");
            } else {
                 commonFunctions.isElementDisplayed(myAccountInExploreMenu, 20, "My Account button");
                break;
            }*/
            }
        }
        commonFunctionsMobileLM.clickElement(MyAccount, moEngagePopupDoItLater, 20, "My Accouont", "Moengage pop up");
        commonFunctions.clickElementWithJS(logoutButton, 10, "Logout");
        commonFunctions.waitForURLToBe(globalVars.getURL());
        int attempts = 0;
        while (attempts < 5) {
            System.out.println("**** Iteration: " + attempts);
            if (!commonFunctions.isElementDisplayedAndPresent(exploreMenu, 20, "explore menu")) {
                Utils.logStepInfo(true, "Waiting for element to be present explore button");
            } else {
                commonFunctions.clickElementWithJS(exploreMenu, 20, "Click on exp");
                isLogoutSuccessful = commonFunctions.isElementDisplayed(signInButton, 20, "Sign-In button");
                commonFunctions.pageRefresh();
                break;
            }
            attempts++;
        }
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
        commonFunctions.clickElementIfDisplayed(googleSignInPromptClose,10,"Google sign in prompt close button");
        commonFunctionsMobileLM.clickElement(exploreMenu,moEngagePopupDoItLater,10,"explore menu click","Moengage notification");
        commonFunctions.clickElementWithJS(signInButtonInExplore, 20, "Sign In Button in explore menu");
        commonFunctions.waitForURLContains("account");
        commonFunctions.sendKey(emailTextBoxMainSignInPage,email,10,"email");
        commonFunctions.clickElement(continueButtonSignInPage,10,"continue");
        commonFunctions.waitForPageLoading();
        OTPLimitReached=commonFunctions.isElementNotDisplayed(newOTPinput.get(0),10,"OTP input");
        otp=commonFunctionsMobileLM.getOTPForLogin(apiURI,refreshAPI,cookie,accessAccount,OTPLimitReached);
        while(OTPLimitReached && refreshAttempt<=1)
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


    public static void preSetInitialization() {
        commonFunctions.deleteCookiesAndNavigateToHomePage();
        new com.pages.LiveMint.ios_mweb.LoginPage();
    }

    public static void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        new com.pages.LiveMint.ios_mweb.LoginPage();
    }

    public static void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        new com.pages.LiveMint.ios_mweb.LoginPage();
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
