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

public class LiveMint_FrontEndPage extends CommonFrontEndPage {


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
//    public static String storyIdNumber;


    @FindBy(xpath = "//span[contains(@class,'link')]")
    private static WebElement copyTextUrl;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(css = "button[id=agree]")
    private static WebElement cookiesContinueButton;

    @FindBy(xpath = "//section[contains(@class,'cardHolder')]//h1")
    private static WebElement headlineField;

    @FindBy(xpath = "//div[contains(@class,'bcrumb')]/a[2]")
    private static WebElement sectionField;

    @FindBy(xpath = "//div[contains(@class,'bcrumb')]/a[3]")
    private static WebElement subsectionField;

    @FindBy(xpath= "(//span[contains(@class,'articleInfo author')]/a)[1]")
    private static WebElement byLineField;

    @FindBy(xpath= "//ul[contains(@class,'highlights')]/li")
    private static WebElement summaryField;

    @FindBy(xpath= "//div[contains(@class,'mainArea')]//p")
    private static WebElement highlightsItemField;

    @FindBy(xpath= "//div[contains(@class,'liveSecIntro')]//strong")
    private static WebElement locationField;

    @FindBy(xpath= "//div[contains(@class,'liveSecIntro')]//p")
    private static WebElement paragraphField;

    @FindBy(xpath = "//div[contains(@class,'block published')]//div//p[contains(text(),'PUBLISHED')]")
    private static WebElement PublishedText;

    @FindBy(xpath = "//span[contains(@class,'articleInfo pubtime')]/span")
    private static WebElement frontEndStandardStoryDateAndTime;

    @FindBy(xpath= "//section[contains(@class,'cardHolder')]//div[contains(@class,'FirstEle')]//p")
    private static WebElement firstParagraphField;

    @FindBy(xpath= "(//section[contains(@class,'cardHolder')]//div[contains(@class,'paywall')]//p)[1]")
    private static WebElement secondParagraphField;

    @FindBy(xpath= "//section[contains(@class,'cardHolder')]//div[contains(@class,'embed')]")
    private static WebElement embedSrc;

    @FindBy(xpath= "//section[contains(@class,'cardHolder')]//div[contains(@class,'FirstEle')]//strong")
    private static WebElement standardStoryLocationField;

    @FindBy(xpath= "//img[contains(@class,'storyEmbedImg')]")
    private static WebElement imageSrcInput;

    @FindBy(xpath= "//div[contains(@class,'paywall')]//figcaption")
    private static WebElement imageCaptionName;

    @FindBy(xpath= "(//section[contains(@class,'cardHolder')]//div[contains(@class,'embed')])[1]")
    private static WebElement embedSrcInput;

    @FindBy(xpath= "//section[contains(@class,'cardHolder')]//div[contains(@class,'tableData')]")
    private static WebElement tableDataInput;

    @FindBy(xpath= "(//section[contains(@class,'cardHolder')]//h2/a)[1]")
    private static WebElement marketName;

    @FindBy(xpath= "//figure[contains(@id,'gid-1')]/figcaption")
    private static WebElement photoGalleryFirstImageCaption;

    public LiveMint_FrontEndPage() {
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
    public boolean dataValidationOnFrontEndUI(String username, String password, String headline,String section, String subsection, String summary, String byline, String paragraph, String location, String topic, String storyIDNumber) {
        return false;
    }
    @Override
    public boolean changeUrl(String urlHeadline, String storyIDNumber1) {
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
        boolean isShowing = false;
        searchStoryByIDAndSelect(storyIdNumber);
        int attempts = 0;
        while (attempts < 20) {
            System.out.println("**** Iteration: " + attempts);
            if (!commonFunctions.isElementDisplayedAndPresent(PublishedText, 10, " Timeline published")) {
                commonFunctions.refreshPage();
                if (isShowing = commonFunctions.isElementDisplayedAndPresent(PublishedText, 10, " Timeline Published")) {
                    isShowing = true;
                    break;
                }
            }
            attempts++;
        }
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
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
    public boolean dataValidationWithPublishTimeStandardStoryOnFrontEnd(String username, String password, String headline, String summary,String paragraph, String byline,String highlightsItem,String section, String subsection,String location, String storyIdNumber, Date time) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,20,"cookies accept button");
        Date dateFromUI = commonFunctions.getPublishedDateTimeHighlightsFromFrontEnd(frontEndStandardStoryDateAndTime.getText());
        isShowing &= checkElementTextOfHeadlineSectionSubsectionBylineSummary( headline, section, subsection, byline, summary);
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(locationField, location, 30, "location");
        String[] text1 = commonFunctions.getElementText(paragraphField, 10).split(":");
        String paragraphText = text1[text1.length - 1].trim();
        isShowing &= commonFunctions.checkElementTextWithEqualIgnoreCase(paragraphText, paragraph, "paragraph");
        isShowing &= commonFunctions.getElementTextAndCheck(highlightsItemField, highlightsItem, 30, "highlights item");
        isShowing &= dateFromUI.equals(time);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }


    @Override
    public boolean dataValidationLiveBlogStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph,  String postTitle, String postBody, String storyIdNumber) {
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
    public boolean dataValidationHighlightsStoryOnFrontEnd(String username, String password, String headline, String summary,String paragraph, String byline,String highlightsItem,String section, String subsection,String location, String storyIDNumber1) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIDNumber1);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,20,"cookies accept button");
        isShowing &= checkElementTextOfHeadlineSectionSubsectionBylineSummary( headline, section, subsection, byline, summary);
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(locationField, location, 30, "location");
        String[] text1 = commonFunctions.getElementText(paragraphField, 10).split(":");
        String paragraphText = text1[text1.length - 1].trim();
        isShowing &= commonFunctions.checkElementTextWithEqualIgnoreCase(paragraphText, paragraph, "paragraph");
        isShowing &= commonFunctions.getElementTextAndCheck(highlightsItemField, highlightsItem, 30, "highlights item");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
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
        boolean isShowing;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIDNumber1);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,20,"cookies accept button");
        isShowing = commonFunctions.getElementTextAndCheck(headlineField, storyHeadlineText, 30, "headline");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationStandardStoryParagraphWithInLineEmbedOnFrontEnd(String username, String password, String headline, String summary,String firstParagraphData,String secondParagraphData, String byline,String section, String subsection,String location, String storyIdNumber,String srcEmbed) {
        boolean isShowing = true;
       dashboardPage.selectStoryCopyUrlOpenNewTab(username, password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,20,"cookies accept button");
        isShowing &= checkElementTextOfHeadlineSectionSubsectionBylineSummary(headline, section, subsection, byline, summary);
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(standardStoryLocationField, location, 30, "location");
        String[] text1 = commonFunctions.getElementText(firstParagraphField, 10).split(":");
        String paragraphText = text1[text1.length - 1].trim();
        isShowing &= commonFunctions.checkElementTextWithEqualIgnoreCase(paragraphText, firstParagraphData, "first paragraph");
        isShowing &= commonFunctions.getElementTextAndCheck(secondParagraphField, secondParagraphData, 30, "second paragraph");
        isShowing &= commonFunctions.getAttributeValue(embedSrc, 30, "data-src").equalsIgnoreCase(srcEmbed);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    public boolean checkElementTextOfHeadlineSectionSubsectionBylineSummary(String headline, String section, String subsection, String byline, String summary) {
        boolean isShowing = true;
        isShowing &= commonFunctions.getElementTextAndCheck(headlineField, headline, 30, "headline");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(sectionField, section, 30, "section");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(subsectionField, subsection, 30, "subsection");
        isShowing &= commonFunctions.getElementTextAndCheck(byLineField, byline, 30, "byline");
        isShowing &= commonFunctions.getElementTextAndCheck(summaryField, summary, 30, "summary");
        return isShowing;
    }

    @Override
    public boolean dataValidationStandardStoryWithAllInLineEmbedOnFrontEnd(String username, String password, String headline, String summary,String paragraphData, String byline,String section, String subsection,String location, String storyIdNumber,String srcEmbed,String imageSrcValue,String captionName,String tableInputData,String companyName, String topic) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab(username, password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton,20,"cookies accept button");
        isShowing &= checkElementTextOfHeadlineSectionSubsectionBylineSummary(headline, section, subsection, byline, summary);
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(standardStoryLocationField, location, 30, "location");
        String[] text1 = commonFunctions.getElementText(firstParagraphField, 10).split(":");
        String paragraphText = text1[text1.length - 1].trim();
        isShowing &= commonFunctions.checkElementTextWithEqualIgnoreCase(paragraphText, paragraphData, "paragraph");
        commonFunctions.scrollPageWithJS(embedSrcInput,20);
        isShowing &= commonFunctions.getAttributeValue(imageSrcInput, 30, "src").equalsIgnoreCase(imageSrcValue);
        isShowing &= commonFunctions.getElementTextAndCheck(imageCaptionName, captionName, 30, "caption Name");
        isShowing &= commonFunctions.getAttributeValue(embedSrcInput, 30, "data-src").equalsIgnoreCase(srcEmbed);
        isShowing &= commonFunctions.getElementTextAndCheck(tableDataInput, tableInputData, 30, "table data");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(marketName, companyName, 30, "market company data");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationImageCaptionName(String username, String password,String storyIDNumber1,String firstCaptionName,String storyHeadlineText) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab(username, password, storyIDNumber1);
        commonFunctions.clickElementIfDisplayed(cookiesContinueButton, 20, "cookies accept button");
        isShowing &= commonFunctions.getElementTextAndCheck(headlineField, storyHeadlineText, 30, "headline");
        String[] text1 = commonFunctions.getElementText(photoGalleryFirstImageCaption, 10).split("/");
        String FirstImageCaptionName= text1[text1.length - 1].trim();
        isShowing &= commonFunctions.checkElementTextWithEqualIgnoreCase(FirstImageCaptionName.substring(1), firstCaptionName,"first image caption name");
        return isShowing;
    }

    @Override
    public boolean waitForPublished(String storyIdNumber){
        return false;
    }

}
