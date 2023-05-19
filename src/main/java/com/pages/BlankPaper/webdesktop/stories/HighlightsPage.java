package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonHighlightsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class HighlightsPage extends CommonHighlightsPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(id = "bylineFilter")
    private static WebElement byline;

    @FindBy(xpath = "//div//descendant::label[contains(text(),'Landing page headline')]")
    private static WebElement storyButton;

    @FindBy(xpath = "//div[@class='storytype']//li//child::button[contains(text(),'Highlights')]")
    private static WebElement selectStory;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]") //ul[@class='storyuL']//descendant::li[contains(@class,'headline')]//descendant::ckeditor//descendant::div/p
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "//*[@data-placeholder='Enter the summary..' or @data-placeholder='Enter Summary']")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//*[contains(@data-placeholder,'Para')]") //*[@data-placeholder='Paragraph...' or @data-placeholder='Enter Intro Para']
    private static WebElement addParagraphText;

    @FindBy(xpath = "//div[@class='blockShow']//descendant::li[@class='summary']//div/p") //div[@class='blockShow']//descendant::li[@class='summary']//descendant::ckeditor//descendant::div/p
    private static WebElement addHighlightsItemText;

    @FindBy(xpath = "//div[@class='addnewlist']//span[contains(text(),'Save Highlights item')]")
    private static WebElement buttonSaveHighlightsItem;

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

    @FindBy(xpath = "//div[contains(@class,'right')]//div[contains(@class,'storybtn')]//button[@class='purple']")
    private static WebElement buttonFileStoryForEdit;

    @FindBy(xpath = "//div[contains(@class,'right')]//div[contains(@class,'storybtn')]//button[@class='blue']")
    private static WebElement buttonFinishedEditing;

    @FindBy(xpath = "//button[@class='orange' and contains(text(),'Schedule to Publish')]")
    private static List<WebElement> buttonScheduleToPublishAvailable;

    @FindBy(xpath = "//div/span[@class='created' and contains(text(),'EDITED')]")
    private static WebElement statusEdited;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and text()='Publish']")
    private static WebElement buttonPublish;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "//div[contains(@class,'secondary')]//span[@class='threedots']")
    private static WebElement buttonThreeDots;

    @FindBy(xpath = "//li//button[contains(text(),'Move Back')]")
    private static WebElement buttonMoveBack;

    @FindBy(xpath = "//div[@class='dataField bdrfill']//descendant::ckeditor[contains(@class,'ng')]")
    private static WebElement storyId;

    @FindBy(xpath = "//div//descendant::button[contains(text(),'Discard Story')]")
    private static WebElement buttonDiscardStory;

    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;

    @FindBy(xpath = "//span[contains(@class,'exact')]")
    private static WebElement exactAllStoriesButton;

    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Purge Story')]")
    private static WebElement buttonPurgeStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Purge request accepted')]")
    private static WebElement toastPurgeStory;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Kill Story')]")
    private static WebElement buttonKillStory;

    @FindBy(xpath = "//textarea[@placeholder='Enter Redirect URL here…']")
    private static WebElement addUrlForKillStory;

    @FindBy(xpath = "//div[contains(@class,'fr wid')]//button[contains(@class,'add blue')]")
    private static WebElement submitUrlForKillStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Story Killed')]")
    private static WebElement toastKillStory;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Change URL')]")
    private static WebElement buttonChangeUrl;

    @FindBy(xpath = "//textarea[@placeholder='Enter URL body here…']")
    private static WebElement addUrlForHeadline;

    @FindBy(xpath = "//div[contains(@class,'fr wid100')]//button[contains(@class,'blue ml10')]")
    private static WebElement buttonSubmitUrlForHeadline;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'URL changed successfuly')]")
    private static WebElement toastChangeUrl;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::li//button[contains(text(),'Soft')]")
    private static WebElement buttonSoftPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Soft Published successfully')]")
    private static WebElement toastSoftPublish;

    @FindBy(id = "scheduleToPublish")
    private static WebElement buttonScheduleToPublish;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='hourselect']")
    private static WebElement selectHour;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='minuteselect']")
    private static WebElement selectMinute;

    @FindBy(xpath = "(//button[contains(text(),'Apply')])[last()]")
    private static WebElement buttonApplyScheduleToPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'End time of liveblog changed successfully')]")
    private static WebElement ToastScheduleToBePublished;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='domainselect']")
    private static WebElement hoverOnLeftPanel;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement userName;

    @FindBy(xpath = "//section[@class='mainContainer']//ul[@class='menuContent']//descendant::span")
    private static List<WebElement> leftPanelMenuContent;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement labelUserNameAfterLogin;

    @FindBy(xpath = "//ul[@class='storyuL']//li[contains(@class,'fl100')]//descendant::span[@class='plusHeadline']/i")
    private static WebElement buttonAddCoustomHeadline;

    @FindBy(xpath = "//div[@class='dataField']//span[@class='fieldValidation']")
    private static List<WebElement> labelDataValidation;

    @FindBy(xpath = "//div[@class='right']//button[@class='discard blue']")
    private static WebElement buttonCancelCoustomHeadline;

    @FindBy(xpath = "//div[@class='right']//button[@class='save grey']")
    private static WebElement buttonSubmitCoustomHeadline;

    @FindBy(xpath = "//*[@id='headline3']//descendant::ul/li[1]/div[@class='dataField']/textarea")
    private static WebElement textBoxCoustomHeadline;

    @FindBy(xpath = "//div[@class='right']")
    private static WebElement divArea;

    @FindBy(xpath = "//div[@class='addHeadline']//ul//li//label[text()='Twitter - 56/280']")
    private static WebElement labelArea;

    @FindBy(xpath = "//div[@class='dataField']//descendant::i[@class='icon-image']")
    private static WebElement iconForImageUpload;

    @FindBy(xpath = "//div[@class='search-results']/ul//li[@class='image']//img")
    private static List<WebElement> listOfImagesInListTab;

    @FindBy(xpath = "//div[@class='imageAction block']//descendant::div[@class='pickimage']/span[@class='pickimageBtn']")
    private static WebElement imagePicFromLib;

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

    @FindBy(xpath = "//div[@class='storyaction']//span[@class='cropimage']//child::i[@class='icon-crop']")
    private static WebElement buttonCropIcon;

    @FindBy(xpath = "//div[@class='unlockStory']//following::div[contains(@class,'ptb15')]")
    private static WebElement scrollToDivForCropping;

    @FindBy(xpath = "//div[@class='crop169']//div[contains(@class,'fr')]/input")
    private static WebElement imageCropRatio;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement addTitleForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[3]//child::div[@class='wid50 fl padr20']//descendant::input")
    private static WebElement addNameForImage;

    @FindBy(xpath = "//button[@class='save blue' and text()='Done']")
    private static WebElement captionSubmitButton;

    @FindBy(xpath = "//div[@class='fr wid100 right']")
    private static WebElement divAreaForScrollView;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='storyaction']/span[contains(@class,'editBtn')]/i[@class='icon-pickup']")
    private static WebElement buttonImageEditIcon;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement dropDownRecordListInPagination;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//child::div[@class='recordList']")
    private static WebElement noOfRecordInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[1]")
    private static List<WebElement> pageOneInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[2]")
    private static List<WebElement> pageTwoInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[3]")
    private static List<WebElement> pageThreeInPagination;

    @FindBy(xpath = "//div[@class='contentList']/div[@class='storyListing']")
    private static List<WebElement> storyContentsListInPagination;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[contains(@class,'secondary')]//span[@class='threedots']")
    private static WebElement ellipsis;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement toastPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> buttonYesForHtNewPopup;

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
    private static WebElement headlineAddButtton;

    @FindBy(xpath = "//button[@class='save blue' and text()='Save']")
    private static WebElement saveButtonHeadline;

    @FindBy(xpath = "//span[@id='summary1']")
    private static WebElement buttonDeleteSummary;

    @FindBy(xpath = "//div[@class='element-module']/descendant::div[@class='storyaction']/child::span[@class='deleteHeadline']/i")
    private static WebElement buttonDeleteParagraph;

    @FindBy(xpath = "//span[@class='link']")
    private static WebElement storyUrl;

    @FindBy(xpath = "//div[@class='search-results']/ul[1]//li/img")
    private static WebElement firstImage;
    @FindBy(xpath = "(//span[@class='cropimage']//following::span//i[@class='icon-delete'])[1]")
    private static WebElement deleteImageIcon;

    @FindBy(xpath = "(//div[contains(@class,'imageratio')])[1]")
    private static WebElement imageRatio;

    @FindBy(xpath = "(//div[contains(@class,'autosuggestion')]//li/span)[1]")
    private static WebElement inputActiveText;

    @FindBy(xpath = "//div[contains(@class,'autosuggestion')]//ul//span[not(contains(.,'No Results'))]")
    private static WebElement inputAddByLineSuggestionPopup;

    @FindBy(xpath = "//div[contains(@class,'storybtn')]//span[contains(@class,'created')]")
    private static WebElement publishedDate;

    @FindBy(xpath = "//span[@class='cropimage']/following-sibling::span/i[@class='icon-delete']")
    private static WebElement deleteImage;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//span[@id='storyUrl']/..")
    private static WebElement generatedUrl;


    public HighlightsPage(){
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    @Override
    public boolean createHighLight(String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;
        createStory(headline, summary, paragraph, highlightsItem, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        isStoryCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        dashboardPage.clearSearch();
        return isStoryCreated;
    }

    @Override
    public boolean checkHighlightsStoryWithLiveHindustanAffiliateTenant(String property, String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location){
        boolean isStoryCreated;
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStory(headline, summary, paragraph, highlightsItem, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        isStoryCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        dashboardPage.clearSearch();
        return isStoryCreated;
    }

    private void createStory(String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectStory, 60, "highlights story button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
//        commonFunctions.clickElementWithJS(storyButton, 25, "headline text label");
//        commonFunctions.sendKeyWithActions(enterHeadlineText, headline);
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText,30,"headline field");
        char headlineText[]=headline.toCharArray();
        for(int i=0;i<=headlineText.length-1;i++){
            commonFunctions.sendKeyWithActions(enterHeadlineText,Character.toString(headlineText[i]));
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.sendKeys(addSummaryText, summary, 25, "summary box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.sendKeys(addParagraphText, paragraph, 25, "paragraph box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.sendKeys(addHighlightsItemText, highlightsItem, 25, "highlights item box");
        commonFunctions.clickElement(buttonSaveHighlightsItem, 25, "button add highlights item");
        dashboardPage.inputSection(section);

        char subsectionText[]=subsection.toCharArray();
        for(int i=0;i<=subsectionText.length-1;i++){
            commonFunctions.sendKey(inputAddSubSectionText,Character.toString(subsectionText[i]));
        }
        commonFunctions.waitAndGetElementTextIgnoringStaleElement(inputActiveText,20,"sub-section active text");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
        /*char bulineText[]=byline.toCharArray();
        for(int i=0;i<=bulineText.length-1;i++){
            commonFunctions.sendKey(inputAddByLineText,Character.toString(bulineText[i]));
        }*/
        //commonFunctions.waitAndGetElementTextIgnoringStaleElement(inputActiveText,20,"sub-section active text");
        //commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");


        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
        if (commonFunctions.isElementPresent(inputAddLocationText, 1)) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
        }
        commonFunctions.clickElement(saveButton, 10, "save story button");
        commonFunctions.isElementDisplayedWithoutTryCatch(toastSaveButton, 20, "Toast message on saved status");
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    private void searchStoryByIDAndSelect(String id){
        searchStoryByID(id);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 10, "Single record");
        commonFunctions.isElementDisplayedAndPresent(selectedStory, 15, "dashboard item");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 35, "story list item");
    }

    private void searchStoryByID(String id) {
        commonFunctions.isElementDisplayed(byline, 20);
        commonFunctions.sendKeys(searchAllStoriesText, "id:" + id, 10, "search box");
        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
        commonFunctions.dummyWait(5);
    }

    private void fileStoryAndFinishEditing() {
        commonFunctions.clickElement(buttonFileStoryForEdit, 10, "File Button");
        commonFunctions.clickElementWithJS(buttonFinishedEditing, 25, "Finished Editing button");
        commonFunctions.isElementDisplayedWithoutTryCatch(statusEdited, 20, "Story edited");
    }

    @Override
    public boolean editHighLightAndVerify(){
        boolean isHighLightEdited;
        searchStoryByIDAndSelect(storyIdNumber);
        fileStoryAndFinishEditing();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isHighLightEdited = commonFunctions.checkElementText(storyStatus, "EDITED", 10, "Correct text is");
        return isHighLightEdited;
    }

//    @Override
//    public boolean editHighLightAndVerify(String storyId) {
//        boolean isScheduleToPublishButton = false;
//        boolean isStoryEdited = false;
//        driver.navigate().refresh();
//        commonFunctions.sendKeys(searchAllStoriesText, "id:" + storyId, 10, "search box");
//        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
//        //commonFunctions.clickElement(selectedStoryClick, 15, "standard story list item");
//        commonFunctions.waitForElementBeDisplayAndClick(selectedStory, 15, "selected story");
//        isScheduleToPublishButton = commonFunctions.isElementDisplayedAndPresent(buttonScheduleToPublishAvailable, 7, "schedule to publish button is");
//        if (isScheduleToPublishButton) {
//            commonFunctions.clickElement(buttonThreeDots, 20, "three dot button");
//            commonFunctions.clickElement(buttonMoveBack, 20, "move back button");
//            commonFunctions.clickElement(buttonThreeDots, 20, "again three dot button");
//            commonFunctions.clickElement(buttonMoveBack, 20, "again move back button");
//        }
//        commonFunctions.clickElementWithJS(buttonFileStoryForEdit, 25, "edit button");
//        commonFunctions.clickElementWithJS(buttonFinishedEditing, 25, "finished editing button");
//        // commonFunctions.isElementDisplayed(statusEdited, 20, "Story edited");
//        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "text is");
//        commonFunctions.clickElement(appLogo, 10);
//        isStoryEdited = commonFunctions.checkElementText(storyStatus, "EDITED", 30, "Correct text is");
//        return isStoryEdited;
//    }


    public boolean publishHighLightAndVerify(){
        boolean isStoryPublished;
        searchStoryByIDAndSelect(storyIdNumber);
        publishStoryAndVerify();
        searchStoryByID(storyIdNumber);
        isStoryPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isStoryPublished;
    }

    private void publishStoryAndVerify() {
        boolean isPublishSuccessfully;
        boolean isReadabilityPopup;
        commonFunctions.isElementDisplayed(ellipsis, 60, "three dot button");
        commonFunctions.clickElementWithJS(buttonPublish, 30, "publish video");
        commonFunctions.hardWait(3000);
        if(commonFunctions.isElementPresentWithTryCatch(toastPublish, 20)){
            Utils.logStepInfo("Success Message Found");
        }else{
            if(commonFunctions.isElementPresentWithTryCatch(buttonYesForHtNewPopup, 20)){
                commonFunctions.clickElements(buttonYesForHtNewPopup, 20, "Yes button on popup");
            }
        }
        isPublishSuccessfully = commonFunctions.isElementDisplayedAndPresent(toastPublish, 5, "Publish toaster");
        if (!isPublishSuccessfully) {
            isReadabilityPopup = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopup) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 20, "Yes button on popup");
                commonFunctions.isElementDisplayedWithoutTryCatch(toastPublish, 10, "Publish toaster");
            }
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
        commonFunctions.isElementDisplayed(byline, 20);
    }

//    @Override
//    public boolean publishHighLightAndVerify() {
//        boolean isStoryPublished = false;
//        commonFunctions.clickElement(selectedStory, 15, "highlights story list item");
//        commonFunctions.clickElement(buttonPublish, 15, "publish button");
//        isStoryPublished = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
//        if (isStoryPublished) {
//            commonFunctions.clickElementWithJS(appLogo, 20);
//            isStoryPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
//            return isStoryPublished = true;
//        }
//        return isStoryPublished;
//    }

    @Override
    public boolean verifyPurgeStory() {
        boolean isStoryPurged;
        searchStoryByIDAndSelect(storyIdNumber);
//        commonFunctions.clickElement(selectedStory, 15, "highlights story list item");
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonPurgeStory, 15, "purge story button");
        isStoryPurged = commonFunctions.checkElementText(toastPurgeStory, "Purge request accepted", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryPurged;
    }

    @Override
    public boolean verifyKillStory() {
        boolean isStoryKilled;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 15, "three dots ");
        commonFunctions.clickElement(buttonKillStory, 10, "Kill button");
        commonFunctions.clickElement(submitUrlForKillStory, 10, "done button");
        commonFunctions.isElementDisplayedAndPresent(toastKillStory, 10, "kill story toaster");
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isStoryKilled = commonFunctions.checkElementText(storyStatus, "KILLED", 30, "Correct text is");
        return isStoryKilled;
    }

//    @Override
//    public boolean verifyKillStory() {
//        boolean isStroyKilled = false;
//        String url = "https://staging.livemint.com/education/news/automation-testing-or-test-autom-tion-is-a-oftware-te-ting-tec-n-que-that-per-11617617936368.html";
//        commonFunctions.clickElement(selectedStory, 15, "highlights story list item");
//        commonFunctions.clickElementWithActions(buttonThreeDots, 10, "three dot button");
//        commonFunctions.clickElement(buttonKillStory, 15, "kill story button ");
//        commonFunctions.sendKeys(addUrlForKillStory, url, 20, "url box");
//        commonFunctions.clickElement(submitUrlForKillStory, 20, "submit url button");
//        isStroyKilled = commonFunctions.checkElementText(toastKillStory, "Story Killed", 30, "Correct text is");
//        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
//        commonFunctions.clickElement(appLogo, 20);
//        return isStroyKilled;
//    }

    @Override
    public boolean checkChangeUrl() {
        boolean isStoryUrlChanged;
        int urlIndex;
        Random randomNo = new Random();
        urlIndex = randomNo.nextInt(1000);
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
        commonFunctions.sendKeys(addUrlForHeadline, "automationtesting" + urlIndex, 20, "url box");
        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
        isStoryUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
        String url = commonFunctions.getElementText(storyUrl, 10);
        String[] changedUrl = url.split("-");
        String[] value = changedUrl[changedUrl.length - 2].split("/");
        String data = value[value.length - 1];
        if(data.equals("automationtesting" + urlIndex)){
            isStoryUrlChanged = isStoryUrlChanged && true;
        }else {
            isStoryUrlChanged = false;
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryUrlChanged;
    }

//    @Override
//    public boolean checkChangeUrl(String storyId) {
//        boolean isStroyUrlChanged = false;
//        String headline="Automation Testing";
//        int urlIndex;
//        Random randomNo = new Random();
//        urlIndex = randomNo.nextInt(1000);
//        driver.navigate().refresh();
//        commonFunctions.sendKeys(searchAllStoriesText, "id:" + storyId, 10, "search box");
//        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
//        commonFunctions.waitForElementBeDisplayAndClick(selectedStory, 15, "selected story");
//        commonFunctions.clickElement(saveButton, 10, "save story button");
//        commonFunctions.clickElementWithActions(buttonThreeDots, 10, "three dot button");
//        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
//        addUrlForHeadline.clear();
//        commonFunctions.sendKeys(addUrlForHeadline, headline+urlIndex, 20, "url box");
//        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
//        isStroyUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
//        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
//        commonFunctions.clickElement(appLogo, 20);
//        return isStroyUrlChanged;
//    }

    @Override
    public boolean scheduleHighLightAndVerify(){
        boolean isVideoStoryEdited;
        searchStoryByIDAndSelect(storyIdNumber);
        schedulePublish();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "Single record");
        isVideoStoryEdited = commonFunctions.checkElementText(storyStatus, "SCHEDULED", 10, "Correct text is");
        return isVideoStoryEdited;
    }

    private void schedulePublish() {
        String currentDateAndTime = "";
        String[] currentHour = {};
        String[] currentMinute = {};
        int addMinValue = 0;
        fileStoryAndFinishEditing();
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 10, "Correct text is");
        commonFunctions.clickElement(buttonScheduleToPublish, 10, "schedule to publish button");
        commonFunctions.hardWait(1000);
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
        commonFunctions.hardWait(1000);
        commonFunctions.selectOptionFromDropDown(selectMinute, 10, String.valueOf(addMinValue), "Minute value");
        commonFunctions.hardWait(1000);
        commonFunctions.clickElement(buttonApplyScheduleToPublish, 10, "Apply Button");
        commonFunctions.checkElementText(ToastScheduleToBePublished, "End time of liveblog changed successfully", 20, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 10, "Correct text is");
    }

//    @Override
//    public boolean verifySchedulePublish() {
//        String currentDateAndTime = "";
//        String[] currentHour = {};
//        String[] currentMinute = {};
//        int addMinValue = 0;
//        boolean isHighlightsStoryScheduled = false;
//        commonFunctions.clickElement(selectedStory, 15, "highlights story list item");
//        commonFunctions.clickElement(buttonFileStoryForEdit, 25, "edit button");
//        commonFunctions.clickElement(buttonFinishedEditing, 25, "finished editing button");
//        commonFunctions.clickElement(buttonScheduleToPublish, 15, "schedule to publish button");
//        currentDateAndTime = commonFunctions.getCurrentDateAndTime();
//        currentHour = currentDateAndTime.split(":");
//        if (!currentHour[0].equals("10") && !currentHour[0].equals("20")) {
//            currentHour[0] = currentHour[0].replaceFirst("0", "");
//        }
//        currentMinute = currentDateAndTime.split(":");
//        addMinValue = Integer.parseInt(currentMinute[1]) + 1;
//        commonFunctions.selectOptionFromDropDown(selectHour, 15, currentHour[0], "Hour value");
//        commonFunctions.selectOptionFromDropDown(selectMinute, 15, String.valueOf(addMinValue), "Minute value");
//        commonFunctions.clickElement(buttonApplyScheduleToPublish, 15, "apply button");
//        commonFunctions.checkElementText(ToastScheduleToBePublished, "End time of liveblog changed successfully", 50, "Correct text is");
//        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
//        commonFunctions.clickElement(appLogo, 10);
//        isHighlightsStoryScheduled = commonFunctions.checkElementText(storyStatus, "SCHEDULED", 30, "Correct text is");
//        return isHighlightsStoryScheduled;
//    }

    @Override
    public boolean verifySoftPublish() {
        if(globalVars.isProdRun()){
            //commonFunctions.refreshPage();
            //commonFunctions.waitForElementToBeInvisible(dropDownRecordListInPagination, 20);
            commonFunctions.getSelectedOption(dropDownRecordListInPagination, 30, "Records is");
            Select dropDown = new Select(dropDownRecordListInPagination);
            dropDown.selectByVisibleText("200");
            dashboardPage.openPublishedAndUnlockedStory("Highlights");
        }else {
            searchStoryByIDAndSelect(storyIdNumber);
        }
        return dashboardPage.softPublishStory();
    }

    public boolean verifyUploadImage() {
        boolean isStorySavedStatus;
        boolean isConfirmImageSize;
        searchStoryByIDAndSelect(storyIdNumber);

        if (globalVars.isProdRun()) {
            commonFunctions.clickElementIfDisplayed(deleteImageIcon, 25, "image icon");
        }

        commonFunctions.clickElement(iconForImageUpload, 25, "image icon");
        commonFunctions.clickElement(imagePicFromLib, 25, "image library button");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "image listview icon button");
        //commonFunctions.clickElementWithJS(firstImage, 40, "image records of result list item");

        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab,20,"images loading");
        for(int i=0;i<=listOfImagesInListTab.size()-1;i++){
            if((listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws"))){
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i),20,"Click on Image having src tab");
                break;
            }
        }
        isConfirmImageSize = commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 7, "Correct Text is");
        if (isConfirmImageSize) {
            commonFunctions.clickElements(popupConfirmImageSize, 20, "popup confirm button");
        }
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 30);
        commonFunctions.checkElementText(imageRatio, "16:9 Ratio", 20, "image size");
        commonFunctions.clickElement(buttonCropingDone, 25, "crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        commonFunctions.clickElementWithJS(captionSubmitButton, 30, "caption submit button");
        isStorySavedStatus = dashboardPage.checkImageAfterUploadOnStoryPage();
        isStorySavedStatus &= commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStorySavedStatus;
    }

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

    @Override
    public boolean discardHighLightAndVerify(){
        boolean isStoryDiscarded;
        searchStoryByIDAndSelect(storyIdNumber);
        discardStory();
        searchStoryByID(storyIdNumber);
        isStoryDiscarded = commonFunctions.checkElementText(textNoData, "No Data", 10, "Correct text is");
        dashboardPage.clearSearch();
        return isStoryDiscarded;
    }

    private void discardStory() {
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.hardWait(2000);
        commonFunctions.clickElement(buttonDiscardStory, 10, "Discard button");
        commonFunctions.hardWait(2000);
    }

//    @Override
//    public boolean discardHighLighAndVerify() {
//        boolean isDiscardStory = false;
//        String storyIdVar = "";
//        commonFunctions.clickElement(selectedStory, 15, "highlights story list item");
//        commonFunctions.clickElement(saveButton, 10, "save story button");
//        storyIdVar = storyId.getAttribute("id");
//        commonFunctions.clickElementWithActions(buttonThreeDots, 10, "Three dot button");
//        commonFunctions.clickElement(buttonDiscardStory, 15, "discard story button");
//        commonFunctions.clickElement(appLogo, 10);
//        driver.navigate().refresh();
//        commonFunctions.sendKeys(searchAllStoriesText, "id:" + storyIdVar, 10, "search box");
//        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
//        isDiscardStory = commonFunctions.checkElementText(textNoData, "No Data", 30, "Correct text is");
//        return isDiscardStory;
//    }

    @Override
    public boolean updateCustomHeadline(String landing, String mobile, String browser, String facebook, String twitter, String newsletter) {
        boolean isCustomHeadingUpdated;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(headlineAddButtton, 15, "headline add button");
        commonFunctions.sendKeys(landingPageHeadline, landing, 10, "landing page headline");
        commonFunctions.sendKeys(mobileAppNotificationHeadline, mobile, 10, "landing page headline");
        commonFunctions.sendKeys(browserNotificationHeadline, browser, 10, "landing page headline");
        commonFunctions.sendKeys(facebookHeadline, facebook, 10, "landing page headline");
        commonFunctions.sendKeys(twitterHeadline, twitter, 10, "landing page headline");
        commonFunctions.sendKeys(newsletterHeadline, newsletter, 10, "landing page headline");
        isCustomHeadingUpdated = commonFunctions.clickElement(saveButtonHeadline, 10, "save button");
        return isCustomHeadingUpdated;
    }

//    @Override
//    public boolean verifyCustomHeadlineText(String headline) {
//        boolean isCustomHeadlineTextMatched = false;
//        commonFunctions.clickElement(storyStatus, 15, "live blog story list item");
//        commonFunctions.clickElement(buttonAddCoustomHeadline, 15, "coustom headline icon button");
//        isCustomHeadlineTextMatched = commonFunctions.getElementTextWithGetAttributeValue(textBoxCoustomHeadline, headline, 20, "value", "text area is ");
//        commonFunctions.clickElement(buttonCancelCoustomHeadline, 15, "cancel coustom headline button ");
//        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
//        commonFunctions.clickElement(appLogo, 10);
//        return isCustomHeadlineTextMatched;
//    }

    @Override
    public boolean verifyUrlHeadlineForLanguages(String headline) {
        return false;
    }

    @Override
    public boolean mouseHoverOnLeftPannelAndVerifyElementsAndUser(String expectedUserName) {
        boolean isLeftPanelMouseHover = true;
        commonFunctions.clickElementWithActions(hoverOnLeftPanel, 10, "left panel area");
        for (WebElement traverseElement : leftPanelMenuContent) {
            String elementName = commonFunctions.getElementText(traverseElement, 10);
            if(commonFunctions.isElementEnabledWithCatch(traverseElement, 20, elementName)){
                Utils.logStepInfo(true, elementName + " is enabled");
            }else{
                isLeftPanelMouseHover = false;
                Utils.logStepInfo(false, elementName + " is disabled FAILURE");
            }
        }
        commonFunctions.clickElementWithActions(labelUserNameAfterLogin, 55, "user name label");
        isLeftPanelMouseHover = isLeftPanelMouseHover && commonFunctions.checkElementText(userName, expectedUserName, 15, "Correct text is");
        return isLeftPanelMouseHover;
    }

//    @Override
//    public boolean verifyMouseHoverOnLeftPannel(String expectedUserName) {
//        boolean isLeftPanelMouseHover = false;
//        commonFunctions.clickElement(storyStatus, 15, "highlights story list item");
//        commonFunctions.clickElementWithActions(hoverOnLeftPanel, 10, "left panel area");
//        for (WebElement traverseElement : leftPanelMenuContent) {
//            commonFunctions.isElementEnabled(traverseElement, 20, commonFunctions.getElementText(traverseElement, 10));
//        }
//        commonFunctions.clickElementWithActions(labelUserNameAfterLogin, 55, "user name label");
//        isLeftPanelMouseHover = commonFunctions.checkElementText(userName, expectedUserName, 15, "Correct text is");
//        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
//        commonFunctions.clickElement(appLogo, 10);
//        return isLeftPanelMouseHover;
//    }


    @Override
    public boolean verifyEditStoryContent() {
        boolean isElementTextEdited;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonDeleteSummary, 15, "delete summary ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        commonFunctions.clickElement(saveButton, 10, "save story button");
        commonFunctions.refreshPage();
        isElementTextEdited = commonFunctions.getElementTextAndCheck(addSummaryText, "", 20, "Summary text deletion");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        return isElementTextEdited;
    }

    private void saveHighlightsStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        List<WebElement> elements = new ArrayList<>();
        elements.add(toastSaveButton);
        commonFunctions.isElementDisplayed(elements, 10, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
    }

    @Override
    public boolean deleteHighlightContent() {
        boolean isElementTextDeleted;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonDeleteSummary, 15, "delete summary ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        saveHighlightsStoryAndVerify();
        commonFunctions.refreshPage();
        isElementTextDeleted = commonFunctions.getElementTextAndCheck(addSummaryText, "", 20, "Summary text deletion");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 10);
        return isElementTextDeleted;
    }

    @Override
    public void clickOnBlankPaperLogo(){
        commonFunctions.clickElementIfDisplayed(appLogo, 10);
    }

    public void setStoryId(){
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
    }

    @Override
    public boolean createHighLightStory(String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;
        highlightStoryCreate(headline, summary, paragraph, highlightsItem, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "Single record");
        isStoryCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        dashboardPage.clearSearch();
        return isStoryCreated;
    }

    private void highlightStoryCreate(String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectStory, 60, "highlights story button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText,30,"headline field");

        char headlineText[]=headline.toCharArray();
        for(int i=0;i<=headlineText.length-1;i++){
            commonFunctions.sendKeyWithoutClear(enterHeadlineText,Character.toString(headlineText[i]));
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.sendKeys(addSummaryText, summary, 25, "summary box");
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "Correct text is");
        commonFunctions.isElementDisplayedAndPresent(addParagraphText, 30, "paragraph");
        commonFunctions.sendKeyBoolean(addParagraphText, paragraph);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "Correct text is");
        commonFunctions.sendKeys(addHighlightsItemText, highlightsItem, 25, "highlights item box");
        commonFunctions.clickElement(buttonSaveHighlightsItem, 25, "button add highlights item");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.isElementDisplayedAndPresent(inputAddSectionText, 20, "wait for Element display");
        commonFunctions.clickElementIfDisplayed(inputAddSectionText, 20, "wait for Suggestion popuplist");
        commonFunctions.isElementDisplayedAndPresent(inputAddByLineSuggestionPopup, 80, "Wait for Auto Sugestion popup displayed");
        commonFunctions.sendKeys(inputAddSectionText, section, 20, "Input Section");
        commonFunctions.sendKeysWithEnter(inputAddSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 20, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
        if (commonFunctions.isElementPresent(inputAddLocationText, 1)) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
        }
        commonFunctions.clickElement(saveButton, 10, "save story button");
        commonFunctions.isElementDisplayedWithoutTryCatch(toastSaveButton, 20, "Toast message on saved status");
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    @Override
    public boolean checkChangeUrl(String newHeadline) {
        boolean isStoryUrlChanged;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElementIfDisplayed(deleteImage,20,"delete image");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
        commonFunctions.sendKeys(addUrlForHeadline, newHeadline, 20, "url box");
        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
        isStoryUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
        String url = commonFunctions.getElementText(storyUrl, 10);
        String[] changedUrl = url.split("-");
        String[] value = changedUrl[changedUrl.length - 2].split("/");
        String data = value[value.length - 1];
        if(data.equals(newHeadline)){
            isStoryUrlChanged = isStoryUrlChanged && true;
        }else {
            isStoryUrlChanged = false;
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        publishStoryAndVerify();
        return isStoryUrlChanged;
    }

    @Override
    public boolean softPublishWithNewHeadline(String newHeadline) {
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(publishedDate, 30, "wait for time to be displayed");
        timeOnPublishedStory = getPublishedDateFromStoryParser();
        return softPublishStoryWithNewHeadline(newHeadline);
    }

    public boolean softPublishStoryWithNewHeadline(String newHeadline) {
        boolean isSoftPublished;
        boolean isReadabilityPopupAvailable;
        commonFunctions.clickElementIfDisplayed(deleteImage,20,"delete image");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText,30,"headline field");
        commonFunctions.sendKeys(enterHeadlineText,newHeadline,30,"new headline");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonSoftPublish, 10, "soft publish button");
        isSoftPublished = commonFunctions.isElementDisplayedAndPresent(toastSoftPublish, 10, "soft publish toaster");
        if (!isSoftPublished) {
            isReadabilityPopupAvailable = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopupAvailable) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 10, "Yes button on popup ");
                isSoftPublished = commonFunctions.checkElementText(toastSoftPublish, "Published successfully", 7, "Correct text is");
            }
        }
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isSoftPublished;
    }

    public Date getPublishedDateFromStoryParser(){

        String publishDate= publishedDate.getText();
        Date date=commonFunctions.getPublishedDateTime(publishDate);
        return date;
    }

    private void selectHighlightStory() {
        commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectStory, 30, "Listicle story button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    private void inputHeadline(String headline) {
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        commonFunctions.sendKeyWithActions(enterHeadlineText, headline);
    }

    private void inputSummary(String summary) {
        commonFunctions.sendKeys(addSummaryText, summary, 25, "summary box");
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }

    private void inputSubSection(String subsection) {
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 30, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "wait for Save changes text");
    }

    private void inputByLine(String byline) {
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for changes saved label ");
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
    }

    private void inputKeywords(String keyword) {
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
    }

    private void inputLocation(String location) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 5, "location box")) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        }
    }

    private void saveStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 30, "save story button");
        commonFunctions.isElementDisplayed(toastSaveButton, 20, "Toast message for saved status is");
    }
    public boolean createHighlightStory(String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location){
        selectHighlightStory();
        inputHeadline(headLine);
        inputSummary(summary);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputKeywords(keyword);
        inputLocation(location);
        saveStoryAndVerify();
        setStoryId();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        return commonFunctions.isElementPresent(toastPublish, 20);
    }
    @Override
    public boolean checkIfUserAbleToCreateHighlightsStory(String property, String heading, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location) {
        boolean isResult=createHighlightStory(heading,summary,paragraph,byline,section,subsection,keyword,location);
        if(isResult){
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElementViewAndClick(generatedUrl,10,"url generated");
            Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            if(windowsList.size()==3) return true;
        }
        return false;
    }

}
