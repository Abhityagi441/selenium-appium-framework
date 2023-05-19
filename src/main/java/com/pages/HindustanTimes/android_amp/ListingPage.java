package com.pages.HindustanTimes.android_amp;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonListingPage;
import com.utils.GlobalVars;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ListingPage extends CommonListingPage {

	private static AndroidDriver<WebElement> driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsMobile commonFunctions;
	private static String changedUrl = "entertainment/page-2";


	@FindBy(xpath = "//div[@class='nav-sec']//li[3]//a")
	private static WebElement entertainmentOption;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li//a[contains(@href,'/entertainment/amp')]")
    private static WebElement entertainmentOptionOnTopNav;

	@FindBy(xpath = "//span[text()='view more']")
	private static WebElement viewMoreOption;

	@FindBy(xpath = "//div[@class='pageName']")
	private static WebElement pageName;

	@FindBy(className = "listPagination")
    private static WebElement paginationWidget;

	@FindBy(xpath = "//h1[text()='Entertainment']")
	private static WebElement heading;

	@FindBy(xpath = "//ul[@class='leftFixedNav']//li[6]/a")
	private static WebElement entertainmentSection;

	@FindBy(xpath = "//div[@class='container']//button")
	private static WebElement hamBurger;

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

    @FindBy(xpath = "//div[@class='container']//button")
    private static WebElement exploreButton;

    @FindBy(xpath="//a[@data-vars-event-label='India News']//em")
    private static WebElement indiaNewsHamburgerMenu;

    @FindBy(xpath="//li[not(@class='next')]//a[@href='/entertainment/page-2']")
    private static WebElement clickAtNumber2Page;

    @FindBy(xpath="//div[@class='listPagination']")
    private static WebElement scrollDownToListPagination;

    @FindBy(xpath="//a[@class='view']")
    private static WebElement viewMoreButton;

    @FindBy(css = ".navIco")
    private static WebElement explore;

    @FindBy(xpath="(//button[@class='subscribe'])[1]")
    private static WebElement doThisLaterButton;

    @FindBy(xpath="//a[contains(@data-id,'world-news')]")
    private static WebElement worldNewsOption;

    @FindBy(xpath="//div[@class='btnExplore']/button")
    private static WebElement hamburgerButton;
    @FindBy(xpath="(//a[@class='view'])[2]")
    private static WebElement viewMore;


    public ListingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
    }


    public boolean clickOnExplorerMenu() {
        boolean isExplorermenuClickSuccessful = false;
        try {
            isExplorermenuClickSuccessful = commonFunctions.clickElementWithJS(exploreButton, 20, "exploreButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExplorermenuClickSuccessful;
    }

    public boolean clickOnEntertainmentSection() {
        boolean isClickOnEntertainmentSuccessful = false;
        try {
            isClickOnEntertainmentSuccessful = commonFunctions.clickElement(entertainmentOption, 20, "entertainmentOption");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnEntertainmentSuccessful;
    }

    public boolean checkRedirectionToEntertainmentSection() {
        boolean isRedirectToEntertainmentSuccessful = false;
        try {
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getAmpUrl() + "entertainment")) {
                isRedirectToEntertainmentSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRedirectToEntertainmentSuccessful;
    }

    public boolean scrollDownToBottomOfTheEntertainmentPage() {
        boolean isScrollDownToBottomOfPage = false;
        try {
            isScrollDownToBottomOfPage=commonFunctions.clickElementWithJS(viewMoreButton,40,"Scroll down to Bottom");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollDownToBottomOfPage;
    }

    @Override
    public boolean scrollDownToBottomOfTheWorldNewsPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.clickElementWithJS(hamburgerButton, 20,"hamburgerButton");
        commonFunctions.clickElementWithJS(worldNewsOption, 20,"worldNewsOption");
        commonFunctions.scrollDownToBottom();
        boolean isScrollDownToBottomOfPage = commonFunctions.isElementDisplayed(paginationWidget,10,"paginationWidget");
        commonFunctions.pressAndroidBackKey();
        return isScrollDownToBottomOfPage;
    }

    @Override
    public boolean checkViewMoreButtonOnListingPages() {
        return false;
    }

    public boolean checkRedirectionToTopOfThePage2OfSameSection() {
        boolean isRedirectionToPage2Successful = false;
        try {
            commonFunctions.dummyWait(10);
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getProdUrl() + "entertainment/page-2")) {
                isRedirectionToPage2Successful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRedirectionToPage2Successful;
    }


    @Override
    public boolean checkPaginationWorkingOnListingPages() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing = commonFunctions.clickElementWithJS(entertainmentSection, 10, "Entertainment");
        commonFunctions.scrollToBottom();
        isShowing &=commonFunctions.clickElementWithJS(viewMore, 20, "View More");
        commonFunctions.scrollDownOnce();
        isShowing &=commonFunctions.checkPageUrlContainsText("entertainment/page-2", 15, "Page");
        return isShowing;
    }

    @Override
    public boolean checkViewMoreButton() {
        return false;
    }

    @Override
    public boolean clickAtNumber2PaginationOption() {
        return false;
    }
}

