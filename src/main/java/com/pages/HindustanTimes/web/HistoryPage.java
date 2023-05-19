package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonHistoryPage;
import com.pages.SSO.AbstractLoginPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HistoryPage extends CommonHistoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;
    private static AbstractLoginPage loginPage;

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


    @FindBy(xpath = "(//div[contains(@class,'bigCart')])[1]//h3/a")
    private static WebElement openFullstory;

    @FindBy(xpath = "//div[@class='storyShortDetail']")
    private static WebElement topics;

    @FindBy(xpath = "(//span[text()='RECOMMENDED'])[1]")
    private static WebElement recommended;

    @FindBy(xpath = "(//h3[@class='hdg3'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "//a[text()='My Reads']")
    private static WebElement myRead;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;

    @FindBy(xpath = "//*[@id='content-div']/div[2]/h3/a")
    private static WebElement myReadsFirstHeadLine;

    @FindBy(id = "allow")
    private static WebElement allowButton;

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads')])[2]")
    private static WebElement firstAdvertisement;

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads')])[3]")
    private static WebElement secondAdvertisement;


    @FindBy(xpath = "(//div[@class='adMinHeight313']/following-sibling::*)[1]")
    private static WebElement paragraph1;

    @FindBy(xpath = "(//div[@class='adMinHeight313']/following-sibling::*)[2]")
    private static WebElement paragraph2;

    @FindBy(xpath = "(//div[@class='adMinHeight313']/following-sibling::*)[3]")
    private static WebElement paragraph3;

    @FindBy(xpath = "//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "//a[text()='Most Read']")
    private static WebElement popularStory;

    @FindBy(xpath = "//strong[text()='Explore']")
    private static WebElement exploremenu;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(xpath = "//a[@data-id='cricket,9']/em")
    private static WebElement cricket;

    @FindBy(xpath = "//em[text()='Editorials']")
    private static WebElement editorials;

    @FindBy(xpath = "//em[text()='Cities']")
    private static WebElement cities;

    @FindBy(xpath = "//em[text()='Entertainment']")
    private static WebElement entertainment;

    @FindBy(xpath = "//a//em[text()='Photos']")
    private static WebElement photos;

    @FindBy(xpath = "(//img[@class='lazy'])[1]")
    private static WebElement firstphoto;

    @FindBy(xpath = "//div[@class='socialEl']")
    private static WebElement shareAndBookMarkVisibility;

    @FindBy(xpath = "(//a[contains(text(),'ALL PHOTOS')])[1]")
    private static WebElement viewAllPhotos;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement captionOfStory;

    @FindBy(xpath = "//h1[@class='hdg1']/a")
    private static WebElement headLineOfStory;

    @FindBy(xpath = "//div[@class='shortText']/ul/li")
    private static WebElement summaryLineOfPhoto;

    @FindBy(xpath = "(//h1)[2]")
    private static WebElement nextGallery;

    @FindBy(xpath = "(//img[@class='lazy'])[2]")
    private static WebElement secondPhoto;

    @FindBy(xpath = "//a[@class='closebtn']")
    private static WebElement closeMyAccountMenu;

    @FindBy(xpath = "//div[@class='afterLogin myaccountbtntop']")
    private static WebElement accountMenu;

    @FindBy(xpath = "//section[@id='dataHolder']/div[3]/h3/a")
    private static WebElement storyTitleInMyRead;

    public HistoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        apiValidation = ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkMyReadsHasHistoryOfAllStoriesRead(String uri, String address) {
        boolean isStep = false;
        commonFunctions.clickElementWithActions(closeMyAccountMenu, 10);
        commonFunctions.scrollUsingAction(openFullstory, "openFullStory located");
        commonFunctions.clickElementWithJS(openFullstory, 10, "Open Full Story");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.dummyWait(10);
        String url = commonFunctions.getCurrentURL("Url Navigation Successfull");
        commonFunctions.scrollUsingAction(topics, "Topics is visible and moved to");
        String storyid = commonFunctions.extractStoryID(url);
        commonFunctions.dummyWait(10);
        Response response = apiValidation.getResponseFromURI(uri, address + storyid);
        commonFunctions.dummyWait(20);
        String value = RestUtils.getValueFromResponse(response, "$.mobileHeadline").trim();
        Utils.logStepInfo(true, "API Response Value --" + value);
        commonFunctions.scrollToTop();
        commonFunctions.clickElementWithActions(accountMenu, 10, "Account menu");
        commonFunctions.clickElementWithJS(myRead, 10, "MyReads in left navigation");
        String title = commonFunctions.getElementText(myReadsFirstHeadLine, 10);
        Utils.logStepInfo(true, "Title ---" + title);
        if (title == null || title.equals("")) {
            commonFunctions.scrollUsingAction(storyTitleInMyRead, "Story Title in My Read");
            title = commonFunctions.getElementText(storyTitleInMyRead, 20);
            Utils.logStepInfo(true, "Title after Scrolling --" + title);
        }
        isStep = commonFunctions.compareTexts(title.trim(), value);
        return isStep;
    }
}
