
package com.pages.HindustanTimes.web;

import java.util.List;

import com.utils.RestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.restassured.response.Response;

public class BookmarkPage extends CommonBookmarkPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static ApiValidation apiValidation;

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

    @FindBy(xpath = "(//span[contains(@class,'bookmark-candidate')])[1]")
    private static WebElement bookmarkButton;

    @FindBy(xpath = "//div[@class='actionDiv openSocial']//a[@title='bookmark']")
    private static WebElement bookmarkStoryButton;

    @FindBy(xpath = "//div[contains(@class,'showRightPop')]/div[4]/a")
    private static WebElement savedLink;

    @FindBy(xpath = "//a[normalize-space()='Saved']")
    private static WebElement savedSectionButton;

    @FindBy(xpath="//span[contains(@class,'bookmark-candidate')]//preceding::h3//a")
    private static WebElement storyTitle;

    @FindBy(xpath = "//span[contains(@class,'bookmark morebm')]//preceding::h3//a")
    private static WebElement savedStoryTitle;

    @FindBy(xpath="//h1[@class = 'hdg1']")
    private static WebElement openFullStory;

    @FindBy(xpath="(//figure//span//a//img)[1]")
    private static WebElement firstImage;

    @FindBy(xpath = "//div[contains(@class,'bigCart')]/h3/a")
    private static WebElement firstHeadline;

    @FindBy(xpath="//a[contains(text(),'READ')]")
    private static WebElement openFullStorySaved;

    @FindBy(xpath = "//div[contains(@class,'afterLogin')]")
    private static WebElement myAccountButton;

    @FindBy(xpath = "(//div[contains(@class,'cartHolder')]/h3)[1]/a")
    private static WebElement openStory;

    @FindBy(xpath = "//div[@id='content-div']/div[2]/h3/a")
    private static WebElement bookmarkedStory;

    @FindBy(xpath = "//div[@id='content-div']/div[2]/h3")
    private static WebElement bookmarkedOpenStory;

    @FindBy(xpath = "//div[@id='dataHolder']/div[1]/h1")
    private static WebElement openHeadline;

    @FindBy(xpath = "(//span[contains(@class,'share')])[1]")
    private  static WebElement firstShareIcon;

    @FindBy(xpath = "//section[contains(@class,'ht-ad-holder')][1]//h3[@class='hdg3'][1]//a")
    private static WebElement firstStoryTitle;

    @FindBy(xpath = "(//a[@title = 'bookmark'])[1]")
    private static WebElement bookmarkOptionInStory;

    public BookmarkPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        apiValidation=ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkAdToBookmarkAndVerify(String uri, String address) {
        boolean isBookmarkAddedSuccessfully;
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isFirstStory = commonFunctions.scrollToElementViewAndClick(firstStoryTitle, 20, "first Story Title");
        commonFunctions.scrollToElement(bookmarkOptionInStory, "Bookmark Button");
        commonFunctions.clickElementWithJS(bookmarkOptionInStory, 5, "Bookmark button");
        String title = commonFunctions.getElementText(openFullStory);
        Utils.logStepInfo(true,"title of story = "+title);
        commonFunctions.scrollToTop();
        commonFunctions.clickElementWithJS(myAccountButton,40,"My Account Button");
        commonFunctions.clickElementWithJS(savedLink, 10, "Saved link");
        commonFunctions.dummyWait(5);
        commonFunctions.waitForURLToBe(Utils.getUrl()+"saved");
        String value = commonFunctions.getElementText(bookmarkedOpenStory);
        Utils.logStepInfo(true, "Value text = "+value);
        isBookmarkAddedSuccessfully = value.equalsIgnoreCase(title);
        Utils.logStepInfo(true,"isBookmarkAddedSuccessfully = "+isBookmarkAddedSuccessfully);
        return isBookmarkAddedSuccessfully;

    }

    @Override
    public boolean checkBookmarkIconIsClickableAndDisplay(String uri, String address) {
        boolean isBookmarkAddedSuccessfully=true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoad();
        commonFunctions.isElementDisplayed(firstHeadline,20,"First Image");
        commonFunctions.clickElementWithJS(firstHeadline, 20, "First Headline");
        commonFunctions.isElementDisplayed(openHeadline, 20, "First Open Story");
        String title = commonFunctions.getElementText(openHeadline);
        commonFunctions.scrollToElement(bookmarkButton, "Bookmark Button");
        commonFunctions.clickElementWithJS(bookmarkButton, 20, "Bookmark button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithActions(savedLink, 20, "Saved link");
        commonFunctions.dummyWait(5);
        commonFunctions.waitForURLContains("saved");
        commonFunctions.isElementDisplayed(bookmarkedStory, 10, "Bookmarked Saved Story");
        commonFunctions.clickElementWithJS(bookmarkedStory, 20, "Read full story saved");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.isElementDisplayed(bookmarkedOpenStory,20, "Saved Open Story");
        String savedStoryTitle=commonFunctions.getElementText(bookmarkedOpenStory,20);
        isBookmarkAddedSuccessfully=commonFunctions.checkTextContains(title,savedStoryTitle,"Story Title");

        return isBookmarkAddedSuccessfully;
    }


    @Override
    public boolean checkBookMarkWorkingFine(String[] params)
    {
        return false;
    }

    @Override
    public boolean checkRemoveAllLinkBookMarkPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkClickThreeDotDisplayDifferentOptions() {
        return false;
    }

    @Override
    public boolean checkBookMarkRedirectionLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkBookMarkRedirectionNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkOptionsInSettings() {
        return false;
    }

    @Override
    public boolean checkBottomActionPageOnIndiaPage() {
        return false;
    }

    @Override
    public boolean checkBookmark3DotOption() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTapBackFromBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkSomeArticleIsBookmarked() {
        return false;
    }

    @Override
    public boolean checkBookmarkPageHeadingInCenter() {
        return false;
    }

    @Override
    public boolean checkTextDisplayAfterBookmarkPageHeading() {
        return false;
    }

    @Override
    public boolean checkRedirectionStoryPageOnTap() {
        return false;
    }

    @Override
    public boolean checkRedirectionSectionPageOfStoryOnTap() {
        return false;
    }

    @Override
    public boolean checkBottomNavDisplayOnBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkHomeisSelectedBottomNavOnBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkIconDisplayBeforeImageStory() {
        return false;
    }

    @Override
    public boolean checkTapOnBookmarkIconAtBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkStoryDisplay() {
        return false;
    }

    @Override
    public boolean checkBookmarkStoryDisplayForAnySectionSavedArticles() {
        return false;
    }

    @Override
    public boolean bookMarkStoryFromSportsSection() {
        return false;
    }

    @Override
    public boolean sportStoryInBookMarkedArtical() {
        return false;
    }

    @Override
    public boolean bookMarkStoryFromPhotosSection() {
        return false;
    }

    @Override
    public boolean photoStoryInBookMarkedArtical() {
        return false;
    }

    @Override
    public boolean checkCountOfBookMarkedStoriesSame() {
        return false;
    }

    @Override
    public boolean checkBookMarkMsgForLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkBookMarkMsgBoxForNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryOfVideoSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkedStoryFromVideoSection() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryOfPhotosSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromSectionListingPage() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryInBookmarkSectionFromSectionListingPage() {
        return false;
    }

    @Override
    public boolean checkBackRedirectionFromBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromSearchPage() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryFromSearchPage() {
        return false;
    }

    @Override
    public boolean checkSearchBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestUnBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromTopicPage() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryFromTopicPage() {
        return false;
    }

    @Override
    public boolean checkTopicBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkedStoryFromDailyDigest() {
        return false;
    }

}
