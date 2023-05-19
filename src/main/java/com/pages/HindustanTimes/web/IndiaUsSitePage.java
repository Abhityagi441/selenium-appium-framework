
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonIndiaUsSitePage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndiaUsSitePage extends CommonIndiaUsSitePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "(//a[@class='sign-in'])[1]")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin") //login
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
    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;
    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;
    @FindBy(xpath = "//input[@type='submit']") //input[@value='Log In']
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "(//div[@class='logged-in']//span[2])[1]")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "(//a[@class='sign-out'])[1]")
    private static WebElement LogoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(xpath="//div[@class='btnExplore']/strong")
    private static WebElement exploreButton;

    @FindBy(xpath="//a[contains(@class,'usa')]")
    private static WebElement toggleUSA;

    @FindBy(xpath="//div[@class='nav-sec']")
    private static WebElement checkHamburgerMenuOptions;

    @FindBy(xpath="//a[@href='/entertainment']/em")
    private static WebElement entertainmentOption;

    @FindBy(xpath="//a[@href='/india-news']/em")
    private static WebElement indiaNewsHamburgerMenu;

    @FindBy(xpath="//a[@class='india']")
    private static WebElement toggleIndia;


    public IndiaUsSitePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean clickOnExplorerMenu() {
        boolean isExplorermenuClickSuccessful=false;
        try {
            isExplorermenuClickSuccessful = commonFunctions.clickElement(exploreButton, 20, "exploreButton");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExplorermenuClickSuccessful;
    }


    public boolean clickOnUsaOnTopHamburger()  {
        boolean isClickUSAHamburgerSuccessful=false;
        try{
        isClickUSAHamburgerSuccessful=commonFunctions.clickElement(toggleUSA, 20,"toggleUSA");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isClickUSAHamburgerSuccessful;
    }

    @Override
    public boolean checkUSPageDisplayed() {
        boolean isUSPageDispalyed=false;
        try{
        String currentURL = commonFunctions.getCurrentURL("getCurrentURL Successful");
        if(currentURL.equals(globalVars.getProdUrl()+"us")) {
            isUSPageDispalyed = true;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isUSPageDispalyed;
    }

    @Override
    public boolean goToIndiaPageHamburgerMenu() {
        boolean isIndiaPageRedirected=false;
        try{
        commonFunctions.clickElement(toggleIndia,20,"toggleIndia");
        String currentURL = commonFunctions.getCurrentURL("getCurrentURL Successful");
        if(currentURL.equals(globalVars.getProdUrl())) {
            isIndiaPageRedirected = true;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isIndiaPageRedirected;
    }

    @Override
    public boolean checkIndiaUsToggleWorking() {
        boolean explorerMenu=clickOnExplorerMenu();
        boolean UsaToggle=clickOnUsaOnTopHamburger();
        boolean USPage=checkUSPageDisplayed();
        boolean explorerMenu1=clickOnExplorerMenu();
        boolean IndiaToggle=goToIndiaPageHamburgerMenu();

        return explorerMenu && UsaToggle && USPage && explorerMenu1 && IndiaToggle;
    }

}
