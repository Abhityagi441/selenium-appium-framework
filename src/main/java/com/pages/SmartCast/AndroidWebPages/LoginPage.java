package com.pages.SmartCast.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.SmartCast.generic.CommonLoginPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LoginPage extends CommonLoginPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "signInBtn")
    private static WebElement singInButton;
    @FindBy(id = "phoneEmail")
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin")
    private static WebElement signInButtonMainSignInPage;
    @FindBy(id = "userName")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//ul[@class='userProfile']//ul//li[2]/a")
    private static WebElement signOutButton;
    @FindBy(id = "fbmBtn")
    private static WebElement signInFb;
    @FindBy(id = "m_login_email")
    private static WebElement fbUserEmailId;
    @FindBy(id = "m_login_password")
    private static WebElement fbUSerPassword;
    @FindBy(xpath = "//button[@name='login']")
    private static WebElement fbLoginButton;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;
    @FindBy(id = "accept-cookie-banner-label")
    private static WebElement acceptAll;


    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(allow, 10, "allow notifications");
        if (isElementPresent) { commonFunctions.clickElementIfDisplayed(allow,20,"allow notifications"); }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithPassword(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithAppleID(String email, String password, String expectedUserName) {
        return false;
    }

    @Override
    public boolean loginWithOTP(String email, String apiURI, String auth, String mode, String expectedUserName) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean loginWithFacebook(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        preSetInitializationForFaceBook();
        commonFunctions.clickElement(singInButton, 45, "Sign In Button");
        commonFunctions.clickElement(signInFb, 45, "Sign in with FaceBook Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptAll, 10, "accept-cookie");
        if (isElementPresent) { commonFunctions.clickElementIfDisplayed(acceptAll,10,"accept-cookie"); }
        commonFunctions.sendKey(fbUserEmailId, email, 10);
        commonFunctions.sendKey(fbUSerPassword, password, 10);
        commonFunctions.clickElement(fbLoginButton, 10, "Login Button");
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.isElementDisplayedAndPresent(userNameLabelAfterLogin,10,"Username");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public boolean loginWithEmailAndPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 30);
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password text box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.isElementDisplayedAndPresent(userNameLabelAfterLogin,10,"Username");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithMobileAndPassword(String phone, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.clickElement(singInButton, 60, "Sign In Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKey(emailTextBoxMainSignInPage, phone, 30);
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password text box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.isElementDisplayedAndPresent(userNameLabelAfterLogin,10,"Username");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean signOut() {
        boolean signOutStatus;
        commonFunctions.waitForPageToLoad();
        commonFunctions.isElementDisplayedAndPresent(userNameLabelAfterLogin,20,"Username");
        commonFunctions.clickElement(userNameLabelAfterLogin, 45, "userName");
        commonFunctions.isElementDisplayedAndPresent(signOutButton,10,"SignOut button");
        commonFunctions.clickElement(signOutButton, 60, "SignOut button");
        signOutStatus = commonFunctions.isElementDisplayedAndPresent(singInButton, 70, "Sign In");
        return signOutStatus;
    }
}
