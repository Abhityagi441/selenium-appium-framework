package com.pages.LiveMint.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends CommonLoginPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;
    @FindBy(xpath = "//a[contains(@class,'signin')]")

    private static WebElement singInButton;
    @FindBy(xpath = "//div[@class='acorHead']//div")
    private static WebElement userName;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail")
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
    @FindBy(xpath =  "//button[contains(text(),'do this later')]")
    private static WebElement pushNotificationButton;
    @FindBy (xpath="//div[@class='acorHead']//div")
    private static WebElement ampLoggedinUserName;
    @FindBy (xpath="(//section[@class='cardHolder']//a)[1]")
    private static WebElement ampStoryPage;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

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
        //preSetInitialization();
      commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading(40);
        commonFunctions.clickElementFluentWait(pushNotificationButton,60,"I'll do this later ");
        commonFunctions.clickElementFluentWait(singInButton, 100, "Sign In Button");
        //commonFunctions.clickElementIfDisplayed(singInButton, 100, "Sign In Button");
        commonFunctions.switchToWindowWithTitle("A Hindustan Times Group Website - One Network. One Account - java",60,2);
        boolean isMintLogoAlignedToCenter = checkMintLogoIsAlignedToCenter();
        if(isMintLogoAlignedToCenter) {
            commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 60, "Email/Phone Button");
            commonFunctions.clickElementIfDisplayed(continueButtonSignInPage, 60, "Continue Button");
            commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 60, "Password text box");
            commonFunctions.clickElementIfDisplayed(signInButtonMainSignInPage, 60, "Login Button");
            commonFunctions.switchToWindowWithTitle("Business News Today: Read Latest Business News, Live India Share Market News, Finance & Economy News | Mint",60,2);
            commonFunctions.clickElement(ampStoryPage,10,"Story link");
            commonFunctions.waitForURLContains(".html");
            String actualUserName;
            try {
                actualUserName = commonFunctions.getElementText(ampLoggedinUserName, 20);
            }
            catch(Exception e)
            {
                actualUserName = commonFunctions.getElementText(ampLoggedinUserName, 20);
            }

            isLoginSuccessful = commonFunctions.checkTextContains(expectedUserName,actualUserName,"Logged in user name");
        }
        else{
            isLoginSuccessful =false;
        }

        if (isMintLogoAlignedToCenter && isLoginSuccessful) {
            isLoginSuccessful = true;
        } else {
            isLoginSuccessful = false;
        }
        commonFunctions.navigateBack();
        return isLoginSuccessful;
    }
    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElementWithJS(ampLoggedinUserName, 15, "User name");
        commonFunctions.clickElementWithJS(LogoutButton, 60, "Logout");
        isLogoutSuccessful = commonFunctions.isElementDisplayed(singInButton, 40, "Sign-In button");
        return isLogoutSuccessful;
    }


    @Override
    public boolean loginWithOTP(String email, String apiURI, String mode, String auth, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName, String htAccountsURL) {
        boolean isLoginSuccessful;
        preSetInitialization();
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
        commonFunctions.waitForURLToBe(globalVars.getProdUrl());
        boolean liveMintURLStatus = commonFunctions.checkPageURL(globalVars.getProdUrl(), 30, "livemint url");
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

    public static void preSetInitialization() {
        commonFunctions.deleteCookiesAndNavigateToHomePage();
        new LoginPage();
    }

    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
        commonFunctions.isElementDisplayed(userEmailUsed,90,"Email");
        String actualEmail = commonFunctions.getElementText(userEmailUsed);
        actualEmail = actualEmail.replaceAll("TestAutomation", "").replaceAll("\n", "").trim();
        checkEmailIDUsedForLoginStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID");
        return checkEmailIDUsedForLoginStatus;
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
