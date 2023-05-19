
package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonListingPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListingPage extends CommonListingPage {
    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

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

    @FindBy(xpath="//div[@class='btnExplore']/button")
    private static WebElement hamburgerButton;

    @FindBy(xpath="(//div[@class='storyAd']//amp-ad)[1]")
    private static WebElement loadPage;

    @FindBy(xpath="//div[@class='btnExplore']/strong")
    private static WebElement exploreButton;

    @FindBy(xpath="//div[@class='nav-sec']//li[3]//a")
    private static WebElement entertainmentOption;

    @FindBy(xpath="//a[@href='/india-news']/em")
    private static WebElement indiaNewsHamburgerMenu;

    @FindBy(xpath="//div[@class='listPagination']//li[@class='active']")
    private static WebElement clickAtNumber2Page;

    @FindBy(className="listPagination")
    private static WebElement scrollDownToListPagination;

    @FindBy(xpath="(//div[@class='viewMoreButton']//a[@class='view'])[2]")
    private static WebElement viewMoreButton;

    @FindBy(xpath="((//div[@class='listPagination']//a)[4]")
    private static WebElement pageNumber3;

    @FindBy(className="pageName")
    private static WebElement pageName2;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[6]/a")
    private static WebElement entertainmentSection;

    @FindBy(xpath="(//a[@class='view'])[2]")
    private static WebElement viewMore;

    @FindBy(xpath="//div[@class='secHdg']//h1")
    private static WebElement checkEntertainment;


    public ListingPage() {
        globalVars = GlobalVars.getInstance();
        driver =(IOSDriver)globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean clickOnExplorerMenu() {
        boolean isExplorerMenuClickSuccessful = false;
        try {
            isExplorerMenuClickSuccessful = commonFunctions.clickElement(hamburgerButton, 20, "hamburgerButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExplorerMenuClickSuccessful;
    }
    
    public boolean clickOnHamburgerMenu() {
        boolean isClickOnHamburgerMenuSuccessful = false;
        try {
            commonFunctions.isElementDisplayed(loadPage,20,"loadPage");
            isClickOnHamburgerMenuSuccessful = commonFunctions.clickElementWithJS(hamburgerButton, 20, "hamburgerButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnHamburgerMenuSuccessful;
    }

    @Override
    public boolean clickOnEntertainmentSection() {
        boolean isClickOnEntertainmentSuccessful = false;
        try {
            isClickOnEntertainmentSuccessful = commonFunctions.clickElementWithJS(entertainmentOption, 30, "entertainmentOption");
            commonFunctions.dummyWait(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnEntertainmentSuccessful;
    }

    public boolean checkRedirectionToEntertainmentSection() {
        boolean isRedirectToEntertainmentSuccessful = false;
        try {
            commonFunctions.dummyWait(10);
            commonFunctions.isElementDisplayed(checkEntertainment,20,"checkEntertainment");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getProdUrl() + "entertainment/amp")) {
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
            isScrollDownToBottomOfPage =commonFunctions.scrollToElementViewAndClick(viewMoreButton,20,"viewMoreButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollDownToBottomOfPage;
    }

    public boolean scrollDownToBottomOfThePage() {
        boolean isScrollDownViewMoreBtn = false;
        try {
            isScrollDownViewMoreBtn = commonFunctions.scrollToElementView(viewMoreButton,20,"viewMoreButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollDownViewMoreBtn;
    }

    public boolean clickOnViewMoreButton() {
        boolean isClickOnViewMoreButtonSuccessful = false;
        try {
            isClickOnViewMoreButtonSuccessful = commonFunctions.scrollToElementViewAndClick(viewMoreButton,20,"viewMoreButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnViewMoreButtonSuccessful;
    }

    @Override
    public boolean checkViewMoreButtonOnListingPages() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean hamburgerMenu= clickOnHamburgerMenu();
        boolean checkEntertainmentSection= clickOnEntertainmentSection();
        boolean checkRedirection= checkRedirectionToEntertainmentSection();
        boolean scrollBottomOfThePage= scrollDownToBottomOfThePage();
        boolean clickOnViewMoreButton= clickOnViewMoreButton();
        boolean checkRedirectionOfPage2AndUrl= checkRedirectionToTopOfThePage2OfSameSection();

        return hamburgerMenu && checkEntertainmentSection && checkRedirection && scrollBottomOfThePage && clickOnViewMoreButton && checkRedirectionOfPage2AndUrl;
    }

    public boolean clickAtNumber2PaginationOption() {
        boolean isClickOnPage2paginationSuccessful = false;
        try {
            commonFunctions.scrollToElementView(scrollDownToListPagination, 20, "scrollDownToListPagination");
            isClickOnPage2paginationSuccessful = commonFunctions.scrollToElementViewAndClick(clickAtNumber2Page, 20, "clickAtNumber2Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnPage2paginationSuccessful;
    }

    @Override
    public boolean checkRedirectionToTopOfThePage2OfSameSection() {
        boolean isRedirectionToPage2Successful = false;
        boolean checkPageNum2=false;
        try {
            commonFunctions.isElementDisplayed(pageName2,20,"pageName2");
            String pageNum2=commonFunctions.getElementText(pageName2);
            if(pageNum2.equals("PAGE 2")){
                commonFunctions.textToReport("PAGE 2 has been displayed top of the page and beneath heading entertainment");
                checkPageNum2=true;
            }
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getProdUrl()+"entertainment/page-2")) {
                isRedirectionToPage2Successful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRedirectionToPage2Successful && checkPageNum2;
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
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean scrollDownToBottomOfTheWorldNewsPage() {
        return false;
    }
}
