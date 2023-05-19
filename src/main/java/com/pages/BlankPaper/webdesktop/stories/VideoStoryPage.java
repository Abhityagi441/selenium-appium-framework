package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonVideoStoryPage;
import com.utils.DbUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class VideoStoryPage extends CommonVideoStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;
    public static DbUtils dbUtils;
    public static String embedUrl;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//div//descendant::label[contains(text(),'Landing page headline')]")
    private static WebElement storyButton;

    @FindBy(xpath = "//div[@class='storytype']//li//child::button[contains(text(),'Video')]")
    private static WebElement selectVideoStory;

    @FindBy(xpath = "//div[@class='contentList']/div[1]//child::ul//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "//div[contains(@class,'unlockStory')]//textarea")
    private static WebElement enterEmbedUrlText;

    @FindBy(xpath = "//div[@class='unlockStory']//div[contains(@class,'wid100')]//button[contains(@class,'add blue')]")
    private static WebElement buttonSubmitUrl;

    @FindBy(xpath = "//ul[@class='storyuL']//descendant::li[contains(@class,'headline')]//descendant::ckeditor//descendant::div/p")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "//*[@data-placeholder='Enter the summary..' or @data-placeholder='Enter Summary']")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//input[@placeholder='Add Byline here..']")
    private static WebElement inputAddByLineText;

    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static WebElement inputAddSectionText;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(xpath = "//input[@placeholder='Add Location here..']")
    private static WebElement inputAddLocationText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and contains(text(),'Save')]")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//div[@class='storybtnContent']//button[@class='purple' and contains(text(),'File Story')]")
    private static WebElement buttonFileStoryForEdit;

    @FindBy(xpath = "//div[@class='storybtnContent']//button[@class='blue' and contains(text(),'Finished Editing')]")
    private static WebElement buttonFinishedEditing;

    @FindBy(xpath = "//div/span[@class='created' and contains(text(),'EDITED')]")
    private static WebElement statusEdited;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and text()='Publish']")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;

    @FindBy(xpath = "//div[@id='allStories']//descendant::div['searchfilter']//span[contains(@class,'exact')]")
    private static WebElement exactAllStoriesButton;

    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;

    @FindBy(xpath = "//div[@class='storybtnContent']//span[@class='threedots']")
    private static WebElement ellipsis;

    @FindBy(xpath = "//div//descendant::button[contains(text(),'Discard Story')]")
    private static WebElement buttonDiscardStory;

    @FindBy(xpath = "//button[@class='orange' and contains(text(),'Schedule to Publish')]")
    private static WebElement buttonScheduleToPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'End time of liveblog changed successfully')]")
    private static WebElement ToastScheduleToBePublished;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='hourselect']")
    private static WebElement selectHour;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='minuteselect']")
    private static WebElement selectMinute;

    @FindBy(xpath = "(//button[contains(text(),'Apply')])[last()]")
    private static WebElement buttonApplyScheduleToPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> buttonYesForHtNewPopup;

    @FindBy(xpath = "//button[contains(text(),'Soft')]")
    private static WebElement buttonSoftPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Soft Published successfully')]")
    private static WebElement toastSoftPublish;

    @FindBy(xpath = "//button[contains(text(),'Kill Story')]")
    private static WebElement buttonKillStory;

    @FindBy(xpath = "//div[contains(@class,'fr wid')]//button[contains(@class,'add blue')]")
    private static WebElement submitUrlForKillStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Story Killed')]")
    private static WebElement toastKillStory;

    @FindBy(xpath = "//button[contains(text(),'Purge Story')]")
    private static WebElement buttonPurgeStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Purge request accepted')]")
    private static WebElement toastPurgeStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement toastPublish;

    @FindBy(xpath = "(//li/div//textarea)[3]")
    private static WebElement landingPageHeadline;

    @FindBy(xpath = "(//li/div//textarea)[4]")
    private static WebElement mobileAppNotificationHeadline;

    @FindBy(xpath = "(//li/div//textarea)[5]")
    private static WebElement browserNotificationHeadline;

    @FindBy(xpath = "(//li/div//textarea)[6]")
    private static WebElement facebookHeadline;

    @FindBy(xpath = "(//li/div//textarea)[7]")
    private static WebElement twitterHeadline;

    @FindBy(xpath = "(//li/div//textarea)[8]")
    private static WebElement newsletterHeadline;

    @FindBy(xpath = "(//i[@class='icon-add-headline'])[1]")
    private static WebElement headlineAddButton;

    @FindBy(xpath = "//button[@class='save blue' and text()='Save']")
    private static WebElement saveButtonHeadline;

    @FindBy(xpath = "//button[contains(text(),'Change URL')]")
    private static WebElement buttonChangeUrl;

    @FindBy(css = "textarea[placeholder='Enter URL body here…']")
    private static WebElement addUrlForHeadline;

    @FindBy(xpath = "//button[text()='Done']")
    private static WebElement buttonSubmitUrlForHeadline;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'URL changed successfuly')]")
    private static WebElement toastChangeUrl;

    @FindBy(xpath = "//span[@id='summary1']")
    private static WebElement buttonDeleteSummary;

    @FindBy(xpath = "//span[@class='link']")
    private static WebElement storyUrl;

    @FindBy(xpath = "//div[@class='dataField']//descendant::i[@class='icon-image']")
    private static WebElement iconForImageUpload;

    @FindBy(xpath = "//div[@class='imageAction block']//descendant::div[@class='pickimage']/span[@class='pickimageBtn']")
    private static WebElement imagePicFromLib;

    @FindBy(xpath = "//div[@class='search-results']/ul//li[@class='image']//img")
    private static List<WebElement> listOfImagesInListTab;

    @FindBy(xpath = "//div[@class='internaldisplayView fl100']//descendant::li/i[@class='icon-list']")
    private static WebElement imageListViewIcon;

    @FindBy(xpath = "//div[@class='imagecontain']/span[@class='hover']//child::button[@class='blue']")
    private static WebElement buttonUseImage;

    @FindBy(xpath = "//div[@class='search-results']/ul[1]")
    private static WebElement listImageSearchResult;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> popupConfirmImageSize;

    @FindBy(xpath = "//button[contains(@class,'ml10') and contains(text(),'Done')]")
    private static WebElement buttonCropingDone;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Cropped successfully')]")
    private static WebElement toastCropingDone;

    @FindBy(xpath = "//label[contains(text(),'This is Testing')]")
    private static WebElement imageCaptionText;

    @FindBy(xpath = "//div[@class='storyaction']//span[@class='cropimage']//child::i[@class='icon-crop']")
    private static WebElement buttonCropIcon;

    @FindBy(xpath = "//div[@class='unlockStory']//following::div[contains(@class,'ptb15')]")
    private static WebElement scrollToDivForCropping;

    @FindBy(xpath = "//div[@class='crop169']//div[contains(@class,'fr')]/input")
    private static WebElement imageCropRatio;

    @FindBy(xpath = "//div[@class='leadMedia']//div[@class='editimage']//div[@class='dataField']//ckeditor[contains(@class,'ng-valid ng-touched')]//div/p")
    private static WebElement addCaptionForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement addTitleForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[3]//child::div[@class='wid50 fl padr20']//descendant::input")
    private static WebElement addNameForImage;

    @FindBy(xpath = "//button[@class='save blue' and text()='Done']")
    private static WebElement captionSubmitButton;

    @FindBy(xpath = "//div[@class='search-results']/ul[1]//li/img")
    private static WebElement firstImage;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//child::div[@class='recordList']")
    private static WebElement noOfRecordInPagination;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement dropDownRecordListInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[1]")
    private static List<WebElement> pageOneInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[2]")
    private static List<WebElement> pageTwoInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[3]")
    private static List<WebElement> pageThreeInPagination;

    @FindBy(xpath = "//div[@class='contentList']/div[@class='storyListing']")
    private static List<WebElement> storyContentsListInPagination;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Enter a valid embed')]")
    private static WebElement popupValidEmbedCode;

    @FindBy(className = "icon-add-headline")
    private static WebElement addHeadlineIcon;

    @FindBy(xpath = "//span[text()='Please Enter English Characters Only']")
    private static WebElement englishCharactersValidation;

    @FindBy(xpath = "(//button[@name='discard'])[last()]")
    private static WebElement discardButton;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'URL headline is not in English')]")
    private static WebElement urlHeadlineToasterMassage;

    @FindBy(xpath = "//div[contains(@class,'unlockStory')]//h3")
    private static WebElement addVideoEmbedText;

    @FindBy(xpath = "//div[contains(@class,'autosuggestion')]//li/span")
    private static WebElement inputBylineActiveText;

    @FindBy(xpath = "(//div[contains(@class,'autosuggestion')]//li/span)[1]")
    private static WebElement inputSectionActiveText;

    @FindBy(xpath = "//div[contains(@class,'storybtn')]//span[contains(@class,'created')]")
    private static WebElement publishedDate;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[1]/div")
    private static WebElement enterHeadlineTextBox;

    @FindBy(id = "inputAddMetaTitleText")
    private static WebElement metaTitleText;

    @FindBy(xpath = "//textarea[@placeholder='Enter meta description here…']")
    private static WebElement metaDescText;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(xpath = "(//textarea[contains(@class, 'textBoxSmall')])[1]")
    private static WebElement durationMinute;

    @FindBy(xpath = "(//textarea[contains(@class, 'textBoxSmall')])[2]")
    private static WebElement durationSecound;


    @FindBy(xpath = "//button[contains(@class,'add blue ml10')]")
    private static WebElement doneButton;

    @FindBy(xpath = "//span[@id='storyUrl']/..")
    private static WebElement generatedUrl;



    public VideoStoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        dbUtils = DbUtils.getInstance();
    }

    @Override
    public boolean createVideoStoryAndVerify(String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;
        createVideoStory(headline, summary, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        isStoryCreated = commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "CREATED", 30, "Correct text is");
        return isStoryCreated;
    }

//    @Override
//    public boolean createVideoStoryAndVerifyStatus(String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
//        boolean isStoryStatusVerified;
//        createVideoStory(headline, summary, byline, section, subsection, keyword, location);
//        searchStoryByID(storyIdNumber);
//        isStoryStatusVerified = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
//        return isStoryStatusVerified;
//    }

    @Override
    public boolean verifyImageCropping() {
        boolean isStorySavedStatus;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonCropIcon, 30, "crop icon button");
        commonFunctions.moveSlider(imageCropRatio, 15, "right side");
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 10);
        commonFunctions.clickElementWithJS(buttonCropingDone, 25, "submit crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        isStorySavedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStorySavedStatus;
    }

    public boolean verifyUploadImage() {
        boolean isStorySavedStatus;
        boolean isConfirmImageSize;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(iconForImageUpload, 25, "image icon");
        commonFunctions.clickElement(imagePicFromLib, 25, "image library button");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "image listview icon button");
        commonFunctions.hardWait(30000);
        //commonFunctions.clickElementWithJS(firstImage, 40, "image records of result list item");
        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab,20,"images loading");
        for(int i=0;i<=listOfImagesInListTab.size()-1;i++){
            if(listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws")){
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i),20,"Click on Image having src tab");
                break;
            }
        }

        isConfirmImageSize = commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 7, "Correct Text is");
        if (isConfirmImageSize) {
            commonFunctions.clickElements(popupConfirmImageSize, 20, "popup confirm button");
        }
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 30);
        commonFunctions.clickElement(buttonCropingDone, 25, "crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.isElementDisplayedAndPresent(captionSubmitButton, 30, "Wait for Done button to be displayed");
        commonFunctions.clickElementWithJS(captionSubmitButton, 30, "caption submit button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        isStorySavedStatus = dashboardPage.checkImageAfterUploadOnStoryPage();
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStorySavedStatus;
    }


    @Override
    public boolean discardVideoStoryAndVerify() {
        boolean isStoryDiscarded;
        searchStoryByIDAndSelect(storyIdNumber);
        //commonFunctions.getElementTextAndCheck(singleRecordConformation, "Showing 1 results", 10, "Single record");
        discardStory();
        searchStoryByID(storyIdNumber);
        isStoryDiscarded = commonFunctions.checkElementText(textNoData, "No Data", 20, "Correct text is");
        return isStoryDiscarded;
    }

    @Override
    public boolean editVideoStoryAndVerify(String editHeadline) {
        boolean isVideoStoryEdited, isDisplayed;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.sendKeys(enterHeadlineText, editHeadline, 50, "headline edit name");
        fileStoryAndFinishEditing();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isVideoStoryEdited = commonFunctions.checkElementText(storyStatus, "EDITED", 10, "Correct text is");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "video list item");
        isDisplayed = commonFunctions.checkElementText(enterHeadlineText, editHeadline, 50, "edited headline name");
        return isVideoStoryEdited && isDisplayed;
    }

    @Override
    public boolean scheduleVideoStoryAndVerify() {
        boolean isVideoStoryEdited;
        searchStoryByIDAndSelect(storyIdNumber);
        schedulePublish();
        commonFunctions.clickElement(appLogo, 30);
        searchStoryByID(storyIdNumber);
        isVideoStoryEdited = commonFunctions.checkElementText(storyStatus, "SCHEDULED", 50, "Correct text is");
        return isVideoStoryEdited;
    }

    @Override
    public boolean softPublishVideoStoryAndVerify() {

        if(globalVars.isProdRun()){
//            commonFunctions.refreshPage();
//            commonFunctions.waitForElementToBeInvisible(dropDownRecordListInPagination, 20);
//            Select dropDown = new Select(dropDownRecordListInPagination);
//            dropDown.selectByVisibleText("200");
            dashboardPage.openPublishedAndUnlockedStory("Video");
        }else {
            searchStoryByIDAndSelect(storyIdNumber);
        }
        return softPublishStory();
    }

    @Override
    public boolean killVideoStoryAndVerify() {
        boolean isStoryKilled;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 15, "three dots ");
        commonFunctions.clickElement(buttonKillStory, 10, "Kill button");
        commonFunctions.clickElement(submitUrlForKillStory, 10, "done button");
        commonFunctions.isElementDisplayedAndPresent(toastKillStory, 10, "kill story toaster");
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isStoryKilled = commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "KILLED", 30, "Correct text is");
        return isStoryKilled;
    }

    @Override
    public boolean purgeVideoStoryAndVerify() {
        boolean isStoryPurged;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 15, "three dot button");
        commonFunctions.clickElement(buttonPurgeStory, 15, "purge story button");
        isStoryPurged = commonFunctions.checkElementText(toastPurgeStory, "Purge request accepted", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
        return isStoryPurged;
    }

    @Override
    public boolean updateCustomHeading(String landing, String mobile, String browser, String facebook, String twitter, String newsletter, String domain) {
        boolean isCustomHeadingUpdated;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(headlineAddButton, 15, "headline add button");
        commonFunctions.clickElement(landingPageHeadline, 15, "landing page headline");
        commonFunctions.sendKeys(landingPageHeadline, landing, 10,"landing page headline");
        commonFunctions.sendKeys(mobileAppNotificationHeadline, mobile, 10, "landing page headline");
        commonFunctions.sendKeys(browserNotificationHeadline, browser, 10, "landing page headline");
        commonFunctions.sendKeys(facebookHeadline, facebook, 10, "landing page headline");
        commonFunctions.sendKeys(twitterHeadline, twitter, 10, "landing page headline");
        if (!(domain.equals("Tech") || domain.equals("Hindi") || domain.equals("Bangla") || domain.equals("Auto") || domain.equals("Smart 24") || domain.equals("Mint Lounge"))) {
            commonFunctions.sendKeys(newsletterHeadline, newsletter, 10, "landing page headline");
        }
        isCustomHeadingUpdated = commonFunctions.clickElement(saveButtonHeadline, 10, "save button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        return isCustomHeadingUpdated;
    }

    public boolean verifyPublishVideoStory() {
        boolean isStoryPublished;
        searchStoryByIDAndSelect(storyIdNumber);
        publishStoryAndVerify();
        searchStoryByID(storyIdNumber);
        isStoryPublished = commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isStoryPublished;
    }

    private void createVideoStory(String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
        embedUrl = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/RbSlW8jZFe8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputEmbeddedURLText(embedUrl);
        inputHeadline(headline);
        inputSummary(summary);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputKeyWords(keyword);
        inputLocation(location);
//        inputHeadline(headline);
        saveVideoStoryAndVerify();
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    private void searchStoryByIDAndSelect(String id) {
        searchStoryByID(id);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "Single record");
        commonFunctions.isElementDisplayedAndPresent(selectedStory, 30, "dashboard item");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "video list item");
    }

    private void searchStoryByID(String id) {
        commonFunctions.sendKeys(searchAllStoriesText, "id:" + id, 10, "search box");
        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 20);
        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
    }

    private void inputEmbeddedURLText(String embedUrl) {
        commonFunctions.clickElementWithJS(enterEmbedUrlText, 25, "submit url button");
        commonFunctions.sendKeys(enterEmbedUrlText, embedUrl, 25, "embed url box");
        commonFunctions.clickElementWithJS(buttonSubmitUrl, 25, "submit url button");
        //commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...",7, "wait for saving changes ");
        //commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
    }

    private void selectVideoStory() {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectVideoStory, 25, "video story button");
    }

    private void inputHeadline(String headline) {
        int number=commonFunctions.generateRandomNum();
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText,20,"headline field");
        commonFunctions.sendKeys(enterHeadlineText, headline,25,"Headline");

    }

    private void inputSummary(String summary) {
        int number=commonFunctions.generateRandomNum();
        commonFunctions.sendKeys(addSummaryText, summary, 25, "summary box");
    }

    private void inputByLine(String byline) {
        //commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.waitAndGetElementTextIgnoringStaleElement(inputBylineActiveText,20,"byline active text");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
    }

    private void inputSubSection(String subsection) {
        //commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.sendKeysIgnoringStaleElement(inputAddSubSectionText, subsection, 20, "sub-section box");
        //commonFunctions.waitAndGetElementTextIgnoringStaleElement(inputSectionActiveText, 20, "sub-Section Active Text");
        if(commonFunctions.isElementDisplayedWithExceptionHandling(inputAddSubSectionText, 10, "inputAddSubSectionText")) {
            commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 20);
        }
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }

    private void inputLocation(String location) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 10, "location box")) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
        }
    }

    private void inputKeyWords(String keyword) {
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
    }

    private void saveVideoStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        List<WebElement> elements = new ArrayList<>();
        elements.add(toastSaveButton);
        commonFunctions.isElementDisplayed(elements, 10, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
    }

    private void discardStory() {
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonDiscardStory, 10, "Discard button");
    }

    private void fileStoryAndFinishEditing() {
        commonFunctions.clickElement(buttonFileStoryForEdit, 10, "File Button");
        commonFunctions.clickElementWithJS(buttonFinishedEditing, 25, "Finished Editing button");
        commonFunctions.isElementDisplayedWithoutTryCatch(statusEdited, 20, "Story edited");
    }

    private void schedulePublish() {
        String currentDateAndTime = "";
        String[] currentHour = {};
        String[] currentMinute = {};
        int addMinValue = 0;
        fileStoryAndFinishEditing();
        commonFunctions.clickElement(buttonScheduleToPublish, 10, "schedule to publish button");
        currentDateAndTime = commonFunctions.getCurrentDateAndTime();
        currentHour = currentDateAndTime.split(":");
        if (!currentHour[0].equals("10") && !currentHour[0].equals("20")) {
            currentHour[0] = currentHour[0].replaceFirst("0", "");
        }
        currentMinute = currentDateAndTime.split(":");
        if (!currentMinute[1].equals("59")) {
            addMinValue = Integer.parseInt(currentMinute[1]) + 2;
        } else {
            currentHour[0] = currentHour[0] + 1;
            addMinValue = Integer.parseInt("02");
        }
        commonFunctions.selectOptionFromDropDown(selectHour, 10, currentHour[0], "Hour value");
        commonFunctions.selectOptionFromDropDown(selectMinute, 10, String.valueOf(addMinValue), "Minute value");
        commonFunctions.clickElement(buttonApplyScheduleToPublish, 40, "apply button");
        commonFunctions.isElementPresentWithTryCatch(ToastScheduleToBePublished, 30);
        commonFunctions.checkElementText(ToastScheduleToBePublished, "End time of liveblog changed successfully", 40, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 10, "Correct text is");
    }

    private void publishStoryAndVerify() {
        boolean isPublishSuccessfully;
        boolean isReadabilityPopup;
        commonFunctions.clickElement(buttonPublish, 40, "publish video");
        commonFunctions.hardWait(2000);
        if(commonFunctions.isElementPresentWithTryCatch(toastPublish, 20)){
            Utils.logStepInfo("Success Message is displaying");
        }else{
            if(commonFunctions.isElementPresentWithTryCatch(buttonYesForHtNewPopup, 20)){
                commonFunctions.clickElement(buttonYesForHtNewPopup.get(0), 10, "buttonYesForHtNewPopup");
            }
        }
        isPublishSuccessfully = commonFunctions.isElementDisplayedAndPresent(toastPublish, 10, "Publish toaster");
        if (!isPublishSuccessfully) {
            isReadabilityPopup = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopup) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 20, "Yes button on popup");
                commonFunctions.isElementDisplayedWithoutTryCatch(toastPublish, 10, "Publish toaster");
            }
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
    }

    private boolean softPublishStory() {
        boolean isSoftPublished;
        boolean isReadabilityPopupAvailable;
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonSoftPublish, 10, "soft publish button");
        isSoftPublished = commonFunctions.isElementDisplayedAndPresent(toastSoftPublish, 10, "soft publish toaster");
        if (!isSoftPublished) {
            isReadabilityPopupAvailable = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopupAvailable) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 10, "Yes button on popup ");
                isSoftPublished = commonFunctions.checkElementText(toastSoftPublish, "Soft Published successfully", 7, "Correct text is");
            }
        }
        commonFunctions.clickElement(appLogo, 20);
        return isSoftPublished;
    }

    public void setStoryId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
    }

    @Override
    public boolean verifyCreateVideoStory(String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;
        createVideoStory(headline, summary, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        isStoryCreated = commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 50, "Single record");
        return isStoryCreated;
    }

    @Override
    public boolean publishVideoStory() {
        boolean isPublished;
        searchStoryByIDAndSelect(storyIdNumber);
        publishStoryAndVerify();
        searchStoryByID(storyIdNumber);
        isPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 50, "Correct text is");
        return isPublished;
    }

    @Override
    public boolean changeUrlVideoStory() {
        boolean isStoryUrlChanged;
        int urlIndex;
        Random randomNo = new Random();
        urlIndex = randomNo.nextInt(10000);
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
        commonFunctions.sendKeys(addUrlForHeadline, "automationtesting" + urlIndex, 20, "url box");
        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
        isStoryUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
        String url = commonFunctions.getElementText(storyUrl, 10);
        String[] seperatedURL = url.split("-");
        String[] value = seperatedURL[seperatedURL.length - 2].split("/");
        String data = value[value.length - 1];
        if (data.equals("automationtesting" + urlIndex)) {
            isStoryUrlChanged = isStoryUrlChanged && true;
        } else {
            isStoryUrlChanged = false;
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
        return isStoryUrlChanged;
    }

    @Override
    public boolean verifyDeleteVideoStoryContent() {
        boolean isElementTextDeleted;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonDeleteSummary, 15, "delete summary ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        saveVideoStoryAndVerify();
        commonFunctions.refreshPage();
        isElementTextDeleted = commonFunctions.getElementTextAndCheck(addSummaryText, "", 20, "Summary text deletion");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 10);
        return isElementTextDeleted;
    }

    @Override
    public boolean embedCodeValidation(String embedUrl) {
        boolean isDisplayed;
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputEmbeddedURLText(embedUrl);
        isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(popupValidEmbedCode, 30, "valid Embed toaster massage");
        return isDisplayed;
    }

    @Override
    public boolean videoTranslateLanguage(String embedUrl, String headline, String domain) {
        boolean isDisplayed = false;
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputEmbeddedURLText(embedUrl);
        inputHeadline(headline);
        commonFunctions.clickElementWithJS(addHeadlineIcon, 30, "add Headline Icon");
        commonFunctions.isElementDisplayedWithoutTryCatch(englishCharactersValidation, 30, "Validation English Characters");
        commonFunctions.scrollPageWithJS(discardButton, 10);
        commonFunctions.clickElementWithJS(discardButton, 30, "discard button");
        commonFunctions.clickElement(buttonPublish, 30, "publish video");
        isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(urlHeadlineToasterMassage, 30, "url Headline Toaster Massage");
        return isDisplayed;
    }

    @Override
    public boolean popupEmbedPage(String embedUrl){
        boolean isDisplayed;
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isDisplayed = commonFunctions.getElementTextAndCheck(addVideoEmbedText, "Add Video Embed",30, "Add video embed text");
        commonFunctions.sendKeys(enterEmbedUrlText, embedUrl, 25, "embed url box");
        return isDisplayed;
    }

    @Override
    public boolean softPublishWithNewHeadline(String newHeadline) {
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(publishedDate, 30, "wait for time to be displayed");
        timeOnPublishedStory = getPublishedDateFromStoryParser();
        return softPublishStory(newHeadline);
    }

    private boolean softPublishStory(String newHeadline) {
        boolean isSoftPublished;
        boolean isReadabilityPopupAvailable;
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText,20,"headline field");
        commonFunctions.sendKeys(enterHeadlineText, newHeadline,30,"new headline");
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonSoftPublish, 10, "soft publish button");
        isSoftPublished = commonFunctions.isElementDisplayedAndPresent(toastSoftPublish, 10, "soft publish toaster");
        if (!isSoftPublished) {
            isReadabilityPopupAvailable = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopupAvailable) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 10, "Yes button on popup ");
                isSoftPublished = commonFunctions.checkElementText(toastSoftPublish, "Soft Published successfully", 7, "Correct text is");
            }
        }
        commonFunctions.clickElement(appLogo, 20);
        return isSoftPublished;
    }

    public Date getPublishedDateFromStoryParser(){

        String publishDate= publishedDate.getText();
        Date date=commonFunctions.getPublishedDateTime(publishDate);
        return date;
    }

    @Override
    public boolean changeUrlVideoStory(String changeUrlHeadline) {
        boolean isStoryUrlChanged;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
        commonFunctions.sendKeys(addUrlForHeadline, changeUrlHeadline, 20, "url box");
        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
        isStoryUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
        String url = commonFunctions.getElementText(storyUrl, 10);
        String[] seperatedURL = url.split("-");
        String[] value = seperatedURL[seperatedURL.length - 2].split("/");
        String data = value[value.length - 1];
        if (data.equals(changeUrlHeadline)) {
            isStoryUrlChanged = isStoryUrlChanged && true;
        } else {
            isStoryUrlChanged = false;
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
        return isStoryUrlChanged;
    }

    @Override
    public boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetatitle(String embedUrl){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        inputEmbeddedURLText(embedUrl);
        String inputHeadingText = "Test Meta Title "+commonFunctions.generateRandomNum();
        commonFunctions.inputHeadline(inputHeadingText,enterHeadlineTextBox);
        commonFunctions.inputSummary(inputHeadingText,addSummaryText);
        commonFunctions.scrollToElement(metaTitleText, "Meta Title Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaTitleText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Title");

    }

    @Override
    public boolean checkWhateverDataWeAreProvidingSameDataIsPresentInMetadescription(String embedUrl){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        inputEmbeddedURLText(embedUrl);
        String inputHeadingText = "Test Meta Summary "+commonFunctions.generateRandomNum();
        commonFunctions.inputSummary(inputHeadingText,addSummaryText);
        commonFunctions.scrollToElement(metaDescText, "Meta Desc Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaDescText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Description");

    }

    @Override
    public boolean checkAfterPublishingVideoStoryTheCompleteDataGoesToMasterDb(String url, String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        createVideoStory(url, headLine, summary, byline, section, subsection, keyword, location);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 5)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.isElementPresent(popupPublishButton, 20);
        return dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", storyIdNumber, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline);
    }

    private void createVideoStory(String youtubeUrl, String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputEmbeddedURLText(youtubeUrl);
        inputHeadline(headline);
        inputSummary(summary);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputKeyWords(keyword);
        inputLocation(location);
        saveVideoStoryAndVerify();
        setStoryId();
    }

    @Override
    public boolean checkCreateVideoStoryWithLiveHindustanAffiliateTenant(String embededUrl, String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createVideoStory(embededUrl, headLine, summary, byline, section, subsection, keyword, location);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 5)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        return commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);
    }

    @Override
    public boolean checkVideoDurationField(String embededUrl, String property){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputEmbeddedURLText(embededUrl);
        return commonFunctions.isElementPresentWithTryCatch(durationMinute, 10) && commonFunctions.isElementPresentWithTryCatch(durationSecound, 10);
    }

    @Override
    public boolean checkVideoDurationFieldValidationWithAlphaCharacter(String embededUrl, String property){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputEmbeddedURLText(embededUrl);
        boolean durationFieldExistanceStatus = commonFunctions.isElementPresentWithTryCatch(durationMinute, 10) && commonFunctions.isElementPresentWithTryCatch(durationSecound, 10);
        commonFunctions.sendKeys(durationMinute, "as", 10, "Duration Minute");
        commonFunctions.dummyWait(3);
        commonFunctions.sendKeys(durationSecound, "as", 10, "Duration Secound");
        boolean minValStatus = commonFunctions.getAttributeValue(durationMinute, 10, "ng-reflect-model").isEmpty();
        boolean secValStatus = commonFunctions.getAttributeValue(durationSecound, 10, "ng-reflect-model").isEmpty();
        return durationFieldExistanceStatus && minValStatus && secValStatus;
    }

    @Override
    public boolean checkVideoDurationFieldValidationWithNumericValue(String embededUrl, String property, String min, String sec){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputEmbeddedURLText(embededUrl);
        boolean durationFieldExistanceStatus = commonFunctions.isElementPresentWithTryCatch(durationMinute, 10) && commonFunctions.isElementPresentWithTryCatch(durationSecound, 10);
        commonFunctions.sendKeys(durationMinute, min, 10, "Duration Minute");
        commonFunctions.dummyWait(3);
        commonFunctions.sendKeys(durationSecound, sec, 10, "Duration Secound");
        commonFunctions.dummyWait(3);
        boolean minValStatus = commonFunctions.getAttributeValue(durationMinute, 10, "ng-reflect-model").equals(min.substring(0, 2));
        boolean secValStatus = commonFunctions.getAttributeValue(durationSecound, 10, "ng-reflect-model").equals(sec.substring(0, 2));
        return durationFieldExistanceStatus && minValStatus && secValStatus;
    }

    @Override
    public boolean checkIfUserCanCreateVideoStory(String property, String headLine, String summary, String embedCode, String byline, String section, String subsection, String keyword, String location) {
        selectVideoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.sendKeys(enterEmbedUrlText,embedCode,10,"embed code area");
        commonFunctions.clickElementIfDisplayed(doneButton,10);
        inputHeadline(headLine);
        inputSummary(summary);
        inputByLine(byline);
        inputSection(section);
        inputSubSection(subsection);
        inputKeyWords(keyword);
        inputLocation(location);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        boolean isResult=commonFunctions.isElementPresent(popupPublishButton, 20);
        if(isResult){
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElementViewAndClick(generatedUrl,10,"url generated");
            Set<String> windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            if(windowsList1.size()==3) return true;
        }
        return false;
    }
}