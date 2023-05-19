package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HamburgerPage extends CommonHamburgerPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(xpath = "(//a[contains(text(),'Sign in')])[2]")
    private static MobileElement singInButton;

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

    @FindBy(xpath = "//section//div[@class='logged-in']//span[2]")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(xpath = "(//a[@class='sign-out'])[2]")
    private static WebElement LogoutButton;

    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id ="reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id="verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(className="crossicon")
    private static WebElement closeIconHamburger;

    @FindBy(xpath = "//a[@title='epaper']")
    private static WebElement epaperIcon;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath="//div[@class='btnExplore']")
    private static WebElement hamburgerButton;

    @FindBy(xpath="//div[@class='nav-sec']//a//em")
    private static List<WebElement> hamburgerMenuOptions;

    @FindBy(xpath="//em[text()='Entertainment']")
    private static WebElement entertainmentOption;

    @FindBy(xpath="(//div[@class='secHdg'])[1]")
    private static WebElement entertainmentHeading;

    public HamburgerPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkHamberburgerCases() {
        return false;
    }

    public boolean clickOnHamburgerButton() {
        boolean isExplorerMenuClickSuccessful=false;
        try{
            isExplorerMenuClickSuccessful= commonFunctions.clickElementWithJS(hamburgerButton, 20,"hamburgerButton");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExplorerMenuClickSuccessful;
    }

    public boolean checkHamburgerMenuAllOptionDisplayed() {
        boolean isHamburgerMenuAllOptionsDisplayed=false;

        try{
            int menuNamesCount = hamburgerMenuOptions.size();
            for(int i=0;i< menuNamesCount/6;i++) {
                String menuName = hamburgerMenuOptions.get(i).getText();
                if(!menuName.isEmpty()) {
                    isHamburgerMenuAllOptionsDisplayed = hamburgerMenuOptions.get(i).isDisplayed();
                    commonFunctions.scrollToElementView(hamburgerMenuOptions.get(i),20,"hamburgerOptions");
                    if(isHamburgerMenuAllOptionsDisplayed) {
                        commonFunctions.elementToTextDisplayed(menuName);
                    } else {
                        isHamburgerMenuAllOptionsDisplayed=false;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            isHamburgerMenuAllOptionsDisplayed =false;
        }
        return isHamburgerMenuAllOptionsDisplayed;
    }


    public boolean clickOnEntertainmentSection() {
        boolean isClickOnEntertainmentSuccessful=false;
        try{
            isClickOnEntertainmentSuccessful = commonFunctions.clickElementWithJS(entertainmentOption, 20,"entertainmentOption");
            commonFunctions.isElementDisplayed(entertainmentHeading,10,"Entertainment Heading");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isClickOnEntertainmentSuccessful;
    }


    public boolean checkRedirectionToEntertainmentSection()  {
        boolean isRedirectToEntertainmentSuccessful=false;
        try{
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL Successful");
            if(currentURL.equals(Utils.getUrl()+"entertainment")) {
                isRedirectToEntertainmentSuccessful = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isRedirectToEntertainmentSuccessful;
    }

    @Override
    public boolean checkAnySectionPage() {
        return false;
    }

    @Override
    public boolean checkIndiaNewsPageScrollable() {
        return false;
    }

    @Override
    public boolean checkHamburgerElementsClickable() {
        boolean clickOnHamburger=clickOnHamburgerButton();
        boolean checkHamburgerMenuOptions=checkHamburgerMenuAllOptionDisplayed();
        commonFunctions.scrollToElementView(hamburgerMenuOptions.get(1),20,"hamburgerOptions");
        boolean clickEntertainmentSection=clickOnEntertainmentSection();
        boolean checkEntertainmentRedirection=checkRedirectionToEntertainmentSection();
        return clickOnHamburger && checkHamburgerMenuOptions && clickEntertainmentSection && checkEntertainmentRedirection;
    }

    @Override
    public boolean clickOnExplorerMenu() throws Exception {
        return false;
    }


    @Override
    public boolean checkNavigationIndiaNews() {
        return false;
    }

    @Override
    public boolean breadcrumbDisplayedOtherThanHomePage() {
        return false;
    }

    @Override
    public boolean checkNavigationPopularNews() {
        return false;
    }

    @Override
    public boolean checkNavigationCricketNews() {
        return false;
    }

    @Override
    public boolean checkNavigationEditorialNews() {
        return false;
    }

    @Override
    public boolean checkNavigationEntertainmentNews() {
        return false;
    }

    @Override
    public boolean checkNavigationCitiesNews() {
        return false;
    }

    @Override
    public boolean checkNavigationLatestNews() {
        return false;
    }

    @Override
    public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() throws Exception {
        return false;
    }

    @Override
    public boolean clickWorldNewsSectionOnHamburgerMenu() {
        return false;
    }

    @Override
    public boolean checkExploreHTOptionDisplayedOnHamburgerMenu() {
        return false;
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionsDisplayed() {
        return false;
    }
}
