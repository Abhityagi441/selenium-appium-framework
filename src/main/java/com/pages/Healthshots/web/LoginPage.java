package com.pages.Healthshots.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.Healthshots.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "signInBtn")
    private static WebElement singInButton;
    @FindBy(xpath = "//input[@id='phoneEmail']")
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin")
    private static WebElement signInButtonMainSignInPage;
    @FindBy(id = "userName")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "/html/body/header/div/div[2]/ul/li/a")
    private static WebElement signOutButton;
    @FindBy(xpath = "//div[@id='signOutBtn']/a/small")
    private static WebElement userNameDisplay;
    @FindBy(xpath = "//a[@id='fbmBtn']")
    private static WebElement signInFb;
    @FindBy(xpath = "//input[@id='email']")
    private static WebElement fbUserEmailId;
    @FindBy(xpath = "//input[@id='pass']")
    private static WebElement fbUSerPassword;
    @FindBy(xpath = "//input[@name='login']")
    private static WebElement fbLoginButton;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;


    public LoginPage(){
        globalVars= GlobalVars.getInstance();
        driver =globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions= CommonFunctionsWeb.getInstance();
        long t1=System.currentTimeMillis();
        commonFunctions.clickElementIfDisplayed(allow, 10,"Allow Notifications");
        long t2=System.currentTimeMillis();
        System.out.println("Cookie time for "+globalVars.getProjectName()+" >> "+(t2-t1));
        System.out.println("****************** Test started for :"+globalVars.getProjectName());

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
        //preSetInitializationForFaceBook();
       // commonFunctions.navigateToHomePageSC();
        //Using the timeout - 60secs due to visibility of element as it is a manual issue
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        commonFunctions.clickElement(signInFb, 10, "Sign in with FaceBook Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKey(fbUserEmailId, email, 10);
        commonFunctions.sendKey(fbUSerPassword, password, 10);
        commonFunctions.clickElement(fbLoginButton, 10, "Login Button");
        commonFunctions.switchToWindow(windowsList.get(0));
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 10, "UserName");
        return isLoginSuccessful;
    }

    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean loginWithEmailAndPassword(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        commonFunctions.navigateToHomePageSC();
        //Using the timeout - 60secs due to visibility of element as it is a manual issue
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 30);
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password text box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
        commonFunctions.waitForPageToLoad();
        commonFunctions.isElementClickable(userNameDisplay,30,"UserName Label");
        commonFunctions.clickElementIfDisplayed(userNameDisplay,10,"UserName Label");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 60, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean loginWithMobileAndPassword(String phone, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        //Using the timeout - 60secs due to visibility of element as it is a manual issue
        commonFunctions.clickElement(singInButton, 10, "Sign In Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKey(emailTextBoxMainSignInPage, phone, 30);
        commonFunctions.clickElement(continueButtonSignInPage, 10, "Continue Button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "Password text box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 10, "Login Button");
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
        signOutStatus = commonFunctions.isElementDisplayedAndPresent(singInButton, 70, "Sign In");
        return signOutStatus;
    }
}
