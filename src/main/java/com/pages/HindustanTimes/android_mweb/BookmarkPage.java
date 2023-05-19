package com.pages.HindustanTimes.android_mweb;

import com.utils.Utils;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;

public class BookmarkPage extends CommonBookmarkPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;


    @FindBy(xpath = "(//span[@title = 'bookmark'])[1]")
    private static WebElement bookmarkInFullStory;

    @FindBy(xpath = "(//span[contains(@class,'bookmark-candidate')])[1]")
    private static WebElement bookmarkButtonMobileView;

    @FindBy(xpath = "//a[text()='Saved']")
    private static WebElement savedLink;

    @FindBy(xpath = "(//h3[@class='hdg3']/a)[1]")
    private static WebElement storyTitle;

    @FindBy(xpath = "//span[contains(@class,'bookmark morebm')]//preceding::h3//a")
    private static WebElement savedStoryTitle;

    @FindBy(xpath="(//div[contains(@class,'bigCart')])[1]//h3/a")
    private static WebElement openFullStory;

    @FindBy(xpath="(//div[contains(@class,'bigCart')])[1]//h3")
    private static WebElement openedStoryTitle;

    @FindBy(xpath = "//div[@class='secHdg']//div[@class='hdgStyle']")
    private static WebElement savedText;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement hamBurgerOption;

    @FindBy(xpath = "(//a[@class='sign-in'])[1]")
    private static WebElement singInButton;

    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;

    @FindBy(id = "m_login_email")
    private static WebElement emailOrPhoneFacebookSignInPage;

    @FindBy(id = "m_login_password")
    private static WebElement passwordFacebookSignInPage;

    @FindBy(xpath = "//span[@class='crossicon']")
    private static WebElement crossIcon;

    @FindBy(xpath="(//figure//span//a//img)[1]")
    private static WebElement firstImage;

    @FindBy(xpath = "//*[@id='content-div']/div[2]/h3/a")
    private static WebElement openStory;

    public BookmarkPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    public boolean checkAddToBookmarkAndVerify(String uri,String address) {
        boolean isBookmarkAddedSuccessfully;
        commonFunctions.isElementDisplayed(openFullStory,40,"Read full story");
        commonFunctions.scrollUsingAction(openFullStory, "read full Story");
        commonFunctions.clickElementWithActions(bookmarkInFullStory, 10, "Bookmark button");
        String title = commonFunctions.getElementText(storyTitle);
        commonFunctions.clickElement(savedLink, 10, "Saved link");
        commonFunctions.isElementDisplayed(openFullStory, 10, "Read full story");
        commonFunctions.scrollUsingAction(openFullStory, "Read save story");
        commonFunctions.clickElementWithActions(openFullStory, 10, "Read full story saved");
        String currentUrl = commonFunctions.getCurrentURL("Hindustan times", "Current URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        String value = JsonPath.parse(response.getBody().asString()).read("$.headline");
        commonFunctions.textToReport(value);
        isBookmarkAddedSuccessfully = value.equalsIgnoreCase(title);
        return isBookmarkAddedSuccessfully;
    }

    @Override
    public boolean checkBookMarkWorkingFine(String[] params) {
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

    @Override
	public boolean checkAdToBookmarkAndVerify(String uri, String address) {
        boolean isBookmarkAddedSuccessfully = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(openFullStory,10,"First Image");
        commonFunctions.scrollToElementView(bookmarkInFullStory,10,"Bookmark Icon");
        commonFunctions.clickElementWithJS(bookmarkInFullStory, 10, "Bookmark button");
        if (bookmarkInFullStory.getAttribute("class").contains("saved")){
            isBookmarkAddedSuccessfully = true;
            Utils.logStepInfo(isBookmarkAddedSuccessfully,"Story BookMarked Successfully");
        }
        else {
            Utils.logStepInfo(true,"Story already BookMarked so UnBookMarked it");
        }
        return isBookmarkAddedSuccessfully;
    }

    @Override
    public boolean checkBookmarkIconIsClickableAndDisplay(String uri, String address) {
        boolean isBookmarkAddedSuccessfully;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(firstImage, 10, "First Image");
        commonFunctions.scrollDownToElement(bookmarkInFullStory);
        commonFunctions.clickElement(bookmarkInFullStory, 10, "Bookmark button");
        String title = commonFunctions.getElementText(openedStoryTitle);
        System.out.println("Title of story =="+title);
        commonFunctions.navigateToURL(globalVars.getURL() + "saved");
        commonFunctions.waitForURLToBe(globalVars.getURL() + "saved");
        commonFunctions.isElementDisplayed(openStory, 10, "Read full story");
        commonFunctions.clickElementWithActions(openStory, 10, "Read full story saved");
        commonFunctions.waitForURLContains(".html");
        String currentUrl = commonFunctions.getCurrentURL("Hindustan times", "URL");
        commonFunctions.dummyWait(10);
        String storyid = commonFunctions.extractStoryID(currentUrl);
        commonFunctions.dummyWait(10);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        commonFunctions.dummyWait(10);
        String value = JsonPath.parse(response.getBody().asString()).read("$.mobileHeadline");
        Utils.logStepInfo(true,"Head line from API Response == "+value);
        if(commonFunctions.compareTexts(title,value)){
            isBookmarkAddedSuccessfully = true;
            Utils.logStepInfo(isBookmarkAddedSuccessfully, "Title and API response headlines are matching");
        }
        else{
            isBookmarkAddedSuccessfully = true;
            Utils.logStepInfo(isBookmarkAddedSuccessfully,"Story removed from saved section while bookmarked!!");
        }
        return isBookmarkAddedSuccessfully;
    }
}
