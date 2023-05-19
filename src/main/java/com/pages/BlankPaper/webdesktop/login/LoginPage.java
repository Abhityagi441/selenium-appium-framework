package com.pages.BlankPaper.webdesktop.login;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LoginPage extends CommonLoginPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "(//p[@class='signgoogle']/img)")
    private static WebElement singInButton;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//span[text()='Logout']")
    private static WebElement singOutButton;
    @FindBy(xpath = "//div/button[@type='button']")
    private static WebElement signInWithDiffWay;
    @FindBy(xpath = "//div[@class='vxx8jf']//parent::strong[contains(text(), 'Google Authenticator')]")
    private static WebElement signInWithGoogleAuth;
    @FindBy(id = "totpPin")
    private static WebElement twoFactorAuthPin;
    @FindBy(xpath = "//span[text()='Next']//parent::button[@type='button']")
    private static WebElement twoFactorAuthNextButton;
    @FindBy(css = "input[formcontrolname='email']")
    private static WebElement emailIdSignInPage;
    @FindBy(css = "input[type='password']")
    private static WebElement passwordSignInPage;
    @FindBy(css = "button[type='submit']")
    private static WebElement SignInButton;
    @FindBy(xpath = "//button[contains(@class,'btn')]")
    private static WebElement ldapButton;

    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        long t1 = System.currentTimeMillis();
        //commonFunctions.clickElementIfDisplayed(acceptCookie, 5);
        long t2 = System.currentTimeMillis();
        System.out.println("Cookie time for " + globalVars.getProjectName() + " >> " + (t2 - t1));
        System.out.println("****************** Test started for :" + globalVars.getProjectName());
    }

    @Override
    public boolean loginWithGoogle(String email, String password, String expectedUserName) {
        boolean isLoginSuccessful;
        String parentWindow = driver.getWindowHandle();
        commonFunctions.clickElement(singInButton, 30, "sign in button");
        Set<String> allWindows = commonFunctions.getWindowHandles();
        for (String childWindow : allWindows) {
            if (!childWindow.equals(parentWindow)) {
                commonFunctions.switchToWindow(childWindow);
                break;
            }
        }
        commonFunctions.sendKeyBoolean(emailOrPhoneGmailSignInPage, email, 20, "email or phone box");
        commonFunctions.clickElement(nextButtonGmailSignInPage, 15, "next button");
        commonFunctions.sendKeyBoolean(passwordTextBoxGmailSignInPage, password, 20, "password box");
        commonFunctions.clickElement(nextButtonGmailPasswordPage, 15, "next button");
//        commonFunctions.waitForElementBeDisplayAndClick(signInWithDiffWay, 30, "try another way");
//        commonFunctions.clickElement(signInWithGoogleAuth, 15, "sing in with google authenticator");
//        commonFunctions.sendKeyBoolean(twoFactorAuthPin, TwoFASecretKeyGenerator.getTwoFactorCode(), 20, "two factor auth pin box");
//        commonFunctions.clickElement(twoFactorAuthNextButton, 15, "next button");
        commonFunctions.switchToWindow(parentWindow);
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 30, "UserName");
        return isLoginSuccessful;
    }

    @Override
    public boolean logout() {
        boolean isLogoutSuccessful;
        commonFunctions.clickElement(userNameLabelAfterLogin, 55, "user name label");
        commonFunctions.clickElementWithActions(singOutButton, 15);
        isLogoutSuccessful = commonFunctions.isElementDisplayedWithoutTryCatch(singInButton, 30, "sign in button");
        return isLogoutSuccessful;
    }

    @Override
    public boolean loginWithId(String userId, String password, String expectedUserName){
        boolean isLoginSuccessful;
        commonFunctions.isElementDisplayedAndPresent(ldapButton,50,"LDAP button");
        commonFunctions.clickElementWithJS(ldapButton,50,"LDAP button");
        commonFunctions.isElementDisplayedAndPresent(emailIdSignInPage,50,"userid field");
        commonFunctions.sendKeys(emailIdSignInPage,userId,50,"userId field");
        commonFunctions.sendKeys(passwordSignInPage,password,50,"Password field");
        commonFunctions.clickElementWithJS(SignInButton,30,"sign in button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 30, "UserName");
        return isLoginSuccessful;
    }

}
