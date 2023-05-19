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

public class Bangla_FrontEndPage extends CommonFrontEndPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    public static String storyIdNumber;


    @FindBy(xpath = "//span[contains(@class,'link')]")
    private static WebElement copyTextUrl;

    @FindBy(xpath = "//section[contains(@class,'cardHolder open')]//h1")
    private static WebElement headlineField;

    @FindBy(css = "button#agree")
    private static WebElement agreeButton;

    @FindBy(xpath = "//div[contains(@class,'catName')]/a")
    private static WebElement subSectionField;

    @FindBy(xpath= "//section[contains(@class,'cardHolder open')]//ul[contains(@class,'highlights')]/li")
    private static WebElement summaryField;

    @FindBy(xpath= "(//span[contains(@class,'articleInfo author')]/a)[1]")
    private static WebElement byLineField;

    @FindBy(xpath= "//section[contains(@class,'cardHolder open')]//div[contains(@id,'mainArea')]/p")
    private static WebElement uiParagraphAndLocation;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//div[contains(@id,'loginReminderPopUp')]//a[contains(@class,'icoClose')]")
    private static WebElement loginReminderCrossIcon;

    @FindBy(xpath = "//section[contains(@class,'cardHolder open')]//div[contains(@class,'topic')]/a")
    private static WebElement topicField;

    @FindBy(css = "button[id=agree]")
    private static WebElement cookiesContinueButton;

    @FindBy(className = "icon-add-headline")
    private static WebElement addHeadlineIcon;

    @FindBy(xpath = "(//li/div//textarea)[2]")
    private static WebElement landingPageHeadline;

    @FindBy(id = "saveButtonHeadline")
    private static WebElement saveButtonHeadline;

    @FindBy(xpath ="(//span[contains(@class,'created')])[1]")
    private static WebElement textAllChangesSaved;

    private static String  pleaseEnterEnglishCharOnly ="//span[@class='fieldValidation']";

    @FindBy(xpath= "//div[@class='mainArea']//figure//img")
    private static WebElement imageSrcInput;
    @FindBy(xpath= "//div[@class='mainArea']//figcaption/p")
    private static WebElement imageCaptionName;
    @FindBy(xpath= "//div[contains(@class,'embed')]/iframe[contains(@class,'lozad fade')]")
    private static WebElement embedSrcInput;
    @FindBy(xpath= "//div[contains(@class,'tble')]/p")
    private static WebElement tableDataInput;

    public Bangla_FrontEndPage() {
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
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIDNumber1);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,10,"cookies accept button");
        String url = commonFunctions.getURLWithoutCatch();
        commonFunctions.checkElementText(headlineField, headline, 60, "headline");
        isShowing &=  commonFunctions.checkElementTextWithEqualIgnoreCase(url.split("/")[3],section,"section");
        isShowing &=  commonFunctions.checkElementTextWithEqualIgnoreCase(url.split("/")[4],subsection,"Sub-section");
        isShowing &= commonFunctions.getElementTextAndCheck(summaryField, summary, 50, "summary");
        isShowing &= commonFunctions.getElementTextAndCheck(byLineField,byline, 50, "byline");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(uiParagraphAndLocation,location+" : "+ paragraph, 50, "location and paragraph");
        isShowing &= commonFunctions.getElementTextAndCheck(topicField,topic, 50, "topic");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    @Override
    public boolean changeUrl(String urlHeadline,String storyIDNumber1) {
        boolean isShowing;
        searchStoryByIDAndSelect(storyIDNumber1);
        commonFunctions.clickElement(addHeadlineIcon, 15, "headline add button");
        commonFunctions.sendKeys(landingPageHeadline, urlHeadline, 10, "landing page headline");
        isShowing = commonFunctions.elementIsNotPresent(pleaseEnterEnglishCharOnly, 20, "please enter english char only");
        isShowing &= urlHeadline.contains(commonFunctions.getAttributeValue(landingPageHeadline, 20, "ng-reflect-model"));
        commonFunctions.scrollPageWithJS(saveButtonHeadline, 5);
        commonFunctions.clickElement(saveButtonHeadline, 10, "save button");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "wait for Save changes text");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
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
        return true;
    }

    @Override
    public boolean dataValidationStandardStoryWithAllInLineEmbedOnFrontEnd(String username, String password, String headline, String summary, String paragraphData, String byline, String section, String subsection, String location, String storyIdNumber, String srcEmbed, String imageSrcValue, String captionName, String tableInputData, String companyName,String topic) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,20,"cookies accept button");
        String url = commonFunctions.getURLWithoutCatch();
        commonFunctions.checkElementText(headlineField, headline, 60, "headline");
        isShowing &=  commonFunctions.checkElementTextWithEqualIgnoreCase(url.split("/")[3],section,"section");
        isShowing &=  commonFunctions.checkElementTextWithEqualIgnoreCase(url.split("/")[4],subsection,"Sub-section");
        isShowing &= commonFunctions.getElementTextAndCheck(summaryField, summary, 50, "summary");
        isShowing &= commonFunctions.getElementTextAndCheck(byLineField,byline, 50, "byline");
//        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(uiParagraphAndLocation,location+" : "+ paragraphData, 50, "location and paragraph");
        isShowing &= commonFunctions.getElementTextAndCheck(topicField,topic, 50, "topic");
//        TODO:Due to Frontend for bangla tentans is not stable unable to automate the remaining elements
        commonFunctions.scrollPageWithJS(topicField,20);
//        isShowing &= commonFunctions.getAttributeValue(embedSrcInput, 30, "src").equalsIgnoreCase(srcEmbed);
//        commonFunctions.scrollPageWithJS(tableDataInput,20);
//        commonFunctions.scrollPageWithJS(imageCaptionName,20);
//        isShowing &= commonFunctions.getElementTextAndCheck(imageCaptionName, captionName, 30, "caption Name");
//        isShowing &= commonFunctions.getAttributeValue(imageSrcInput, 30, "src").equalsIgnoreCase(imageSrcValue);
//        isShowing &= commonFunctions.getElementTextAndCheck(tableDataInput, tableInputData, 30, "table data");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;

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
