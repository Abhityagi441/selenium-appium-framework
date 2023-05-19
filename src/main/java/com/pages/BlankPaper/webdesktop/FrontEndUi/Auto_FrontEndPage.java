package com.pages.BlankPaper.webdesktop.FrontEndUi;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;

public class Auto_FrontEndPage extends CommonFrontEndPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    public static String storyIdNumber;



    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;
    @FindBy(css = "button[id=agree]")
    private static WebElement cookiesContinueButton;
    @FindBy(xpath = "//div[contains(@class,'StoryTopContent')]//h1")
    private static WebElement headlineField;
    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]/a[2]")
    private static WebElement sectionField;
    @FindBy(xpath = "//div[contains(@class,'breadcrumb')]/a[3]")
    private static WebElement subsectionField;
    @FindBy(xpath= "//div[contains(@class,'authorSocialWrapper')]//div[contains(@class,'whowhen')]/span[1]")
    private static WebElement byLineField;
    @FindBy(xpath= "//div[contains(@class,'StoryTopDesc')]")
    private static WebElement summaryField;
    @FindBy(xpath= "//div[contains(@class,'StoryBodyContent')]//p/strong")
    private static WebElement standardStoryLocationField;

    @FindBy(xpath= "//div[contains(@class,'StoryBodyContent')]//u")
    private static WebElement firstParagraphField;
    @FindBy(xpath= "(//div[contains(@class,'StoryBodyContent')]//p)[3]")
    private static WebElement secondParagraphField;
    @FindBy(xpath= "//div[contains(@class,'embed')]/iframe")
    private static WebElement embedSrc;


    public Auto_FrontEndPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    private void searchStoryByIDAndSelect(String id) {
        dashboardPage.searchStoryByID(id);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
    }

    @Override
    public boolean dataValidationOnFrontEndUI(String username, String password, String headline,String section, String subsection, String summary, String byline, String paragraph, String location,String topic,String storyIDNumber1) {
        return false;
    }

    @Override
    public boolean changeUrl(String urlHeadline,String storyIDNumber1) {
        return false;
    }

    @Override
    public boolean dataValidationOnSoftPublishPhotoGalleryStoryOnFrontEnd(String username, String password, String newHeadline, String section, String subsection, String paragraph, String summary, String storyIdNumber, Date time) {
        return false;
    }

    @Override
    public boolean dataValidationOnFrontEndUI(String username, String password, String headline, String subsection, String summary, String byline, String paragraph, String location, String storyIDNumber) {
        return false;
    }

    @Override
    public boolean waitForSchedulePublishToPublished(String storyIdNumber) {
        return false;
    }

    @Override
    public boolean dataValidationVideoStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String summary, String storyIdNumber) {
        return false;
    }

    @Override
    public boolean dataValidationPhotoGalleryStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String summary, String storyIdNumber) {
        return false;
    }
    @Override
    public boolean dataValidationWithPublishTimeStandardStoryOnFrontEnd(String username, String password, String newHeadline, String section, String subsection, String summary, String byline, String paragraph, String location, String topic, String storyIDNumber1, Date time) {
        return false;
    }

    @Override
    public boolean dataValidationLiveBlogStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String postTitle, String postBody, String storyIdNumber) {
        return false;
    }

    @Override
    public boolean dataValidationSoftPublishLiveBlogStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String postTitle, String postBody, String storyIdNumber, Date publishedStoryTiming) {
        return false;
    }

    @Override
    public boolean dataValidationWithPublishTimeVideoStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String summary, String storyIdNumber, Date time) {
        return false;
    }

    @Override
    public boolean dataValidationFirstStoriesCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String section, String subsection, String summary, String byline, String location, String paragraph, String topic) {
        return false;
    }

    @Override
    public boolean dataValidationSecondStoriesCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String section, String subsection, String summary1, String byline1, String location1, String paragraph1, String topic1, String headline1) {
        return false;
    }
    @Override
    public boolean deleteStoryFromCollectionAndCheckOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String headline1) {
        return false;
    }

    @Override
    public boolean checkHamburgerSectionNameOnFrontEnd(String userAndPasswordURL, String sectionName) {
        return false;
    }

    @Override
    public boolean checkHamburgerDeletedSectionNameOnFrontEnd(String userAndPasswordURL,String sectionName) {
        return false;
    }

    @Override
    public boolean dataValidationSecondStoriesPositionUpAndDownCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String headline1) {
        return false;
    }

    @Override
    public boolean checkHamburgerUpAndDownPositionSectionNameOnFrontEnd(String userAndPasswordURL, String sectionName) {
        return false;
    }

    @Override
    public boolean dataValidationHighlightsStoryOnFrontEnd(String username, String password, String headline, String summary, String paragraph, String byline, String highlightsItem, String section, String subsection,String location, String storyIdNumber) {
        return false;
    }

    @Override
    public boolean checkSectionNameOnFrontEnd(String userAndPasswordURL, String pageSectionName, String sectionUrl, String subsection, String headlineText) {
        return false;
    }

    @Override
    public boolean checkSubSectionNameOnFrontEnd(String userAndPasswordURL, String pageSectionName, String sectionUrl, String subsection, String headlineText, String section) {
        return false;
    }

    @Override
    public boolean dataValidationOnFrontEndUI(String username, String password, String storyHeadlineText, String storyIDNumber1) {
        return false;
    }

    @Override
    public boolean killHighlightsStoryDataValidationOnFrontEndUI(String username, String password, String storyHeadlineText, String storyIDNumber1) {
        return false;
    }

    @Override
    public boolean dataValidationStandardStoryParagraphWithInLineEmbedOnFrontEnd(String username, String password, String headline, String summary, String firstParagraphData, String secondParagraphData, String byline, String section, String subsection, String location, String storyIdNumber, String srcEmbed) {
        boolean isShowing;
        dashboardPage.selectStoryCopyUrlOpenNewTab(username, password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,20,"cookies accept button");
        isShowing = commonFunctions.getElementTextAndCheck(headlineField, headline, 30, "headline");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(sectionField, section, 30, "section");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(subsectionField, subsection, 30, "subsection");
        isShowing &= commonFunctions.getElementTextAndCheck(byLineField, byline, 30, "byline");
        isShowing &= commonFunctions.getElementTextAndCheck(summaryField, summary, 30, "summary");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(standardStoryLocationField, location, 30, "location");
        String[] text1 = commonFunctions.getElementText(firstParagraphField, 10).split(":");
        String paragraphText = text1[text1.length - 1].trim();
        isShowing &= commonFunctions.checkElementTextWithEqualIgnoreCase(paragraphText, firstParagraphData, "first paragraph");
        isShowing &= commonFunctions.getElementTextAndCheck(secondParagraphField, secondParagraphData, 30, "second paragraph");
        commonFunctions.scrollPageWithJS(embedSrc,20);
        isShowing &= commonFunctions.getAttributeValue(embedSrc, 30, "src").equalsIgnoreCase(srcEmbed);
        commonFunctions.closeAllWindowsExceptMasterTab();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationStandardStoryWithAllInLineEmbedOnFrontEnd(String username, String password, String headline, String summary, String paragraphData, String byline, String section, String subsection, String location, String storyIdNumber, String srcEmbed, String imageSrcValue, String captionName, String tableInputData, String companyName,String topic) {
        return false;
    }

    @Override
    public boolean dataValidationImageCaptionName(String username, String password, String storyIDNumber1, String firstCaptionName, String storyHeadlineText) {
        return false;
    }

    @Override
    public boolean waitForPublished(String storyIdNumber){
        return false;
    }
}
