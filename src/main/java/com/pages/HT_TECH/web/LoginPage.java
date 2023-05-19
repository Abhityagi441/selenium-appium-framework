package com.pages.HT_TECH.web;
import com.base.DesktopBase;
import com.commonFunctions.CommonFunctionsWeb;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.HT_TECH.generic.CommonLoginPage;

public class LoginPage extends CommonLoginPage{
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath="//span[@id='afterSignIn']")
    private static WebElement singInButton;

    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;

    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;

    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;

    @FindBy(id = "btnLogin") //login
    private static WebElement signInButtonMainSignInPage;

   // @FindBy(id = "uName")
    @FindBy(xpath="//div[@id='afterLogin']//div[@class='name']")
    private static WebElement userNameLabelAfterLogin;



    public LoginPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

     //   boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
     //   if (isElementPresent) {
      //      commonFunctions.clickElementIfDisplayed(acceptCookie, 10,"acceptCookie");
      //  }
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
    public boolean loginWithPassword(String email, String password, String expectedUserName){
        boolean isLoginSuccessful;
        DesktopBase.navigateToHomePageUrl();
        commonFunctions.waitForPageLoading();
        String url=globalVars.getURL();
        commonFunctions.clickElement(singInButton, 10, "sign in button");
        commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 35, "email box");
        commonFunctions.clickElement(continueButtonSignInPage, 8, "continue button");
        commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 35, "password box");
        commonFunctions.clickElement(signInButtonMainSignInPage, 15, "sign in button");
        isLoginSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 50, "UserName");
        return isLoginSuccessful;
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
    public boolean logout(){
        return false;
    }
}
