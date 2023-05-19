package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonPhotoGalleryPage;
import com.utils.DbUtils;
import com.utils.GlobalVars;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;


public class PhotoGalleryPage extends CommonPhotoGalleryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;
    public static String storyHeadlineText;

    public static DbUtils dbUtils;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//div[@class='storytype']//li//button[@class='standard' and text()='Photo Gallery']")
    private static WebElement selectPhotoGallery;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "//div[contains(@class,'footer')]/div[contains(@class,'recordList') and contains(text(),'results')]")
    private static WebElement showingResult;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "//div[@class='listCell']")
    private static WebElement selectedStory;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[2]")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and text()='Save']")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;

    @FindBy(xpath = "//div[@id='allStories']//descendant::div['searchfilter']//span[contains(@class,'exact')]")
    private static WebElement exactAllStoriesButton;

    @FindBy(xpath = "//div[contains(@class,'right')]//div[contains(@class,'storybtn')]//button[@class='purple']")
    private static WebElement buttonFileStoryForEdit;

    @FindBy(xpath = "//div[contains(@class,'right')]//div[contains(@class,'storybtn')]//button[@class='blue']")
    private static WebElement buttonFinishedEditing;

    @FindBy(xpath = "//ul[@id='myTags']//li[@class='tagit-new']//input[contains(@placeholder,'Byline')]")
    private static WebElement inputAddByLineText;

    @FindBy(xpath = "//div[contains(@class,'autosuggestion')]//ul//span[not(contains(.,'No Results'))]")
    private static WebElement inputAddByLineSuggestionPopup;

    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static WebElement inputAddSectionText;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(xpath = "//input[@placeholder='Add Location here..']")
    private static WebElement inputAddLocationText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::li//button[contains(text(),'Soft')]")
    private static WebElement buttonSoftPublish;

    @FindBy(xpath = "//div[@id='addCaptionForImage']//input | //div[@id='addCaptionForImage']//p")
    private static WebElement addCaptionForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement addTitleForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[3]//child::div[@class='wid50 fl padr20']//descendant::input")
    private static WebElement addNameForImage;

    @FindBy(xpath = "//div[contains(@class,'bdrfill')]//div[@class='editimage']//div[contains(@class,'wid100 right')]//child::button[text()='Done']")
    private static WebElement captionSubmitButton;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Change URL')]")
    private static WebElement buttonChangeUrl;

    @FindBy(xpath = "//button[contains(text(),'Kill Story')]")
    private static WebElement buttonKillStory;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Purge Story')]")
    private static WebElement buttonPurgeStory;

    @FindBy(xpath = "//div//descendant::button[contains(text(),'Discard Story')]")
    private static WebElement buttonDiscardStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Purge request accepted')]")
    private static WebElement toastPurgeStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Do you still want to proceed?')]")
    private static WebElement croppingVerifyToaster;

    @FindBy(xpath = "//button[@class='orange' and contains(text(),'Schedule to Publish')]")
    private static WebElement buttonScheduleToPublish;

    @FindBy(id = "buttonEditForImage")
    private static WebElement buttonImageEditIcon;

    @FindBy(xpath = "//div[@class='editimage']//ul[contains(@class,'leadimageform')]")
    private static WebElement editImageBlock;

    @FindBy(xpath = "(//button[contains(text(),'Apply')])[last()]")
    private static WebElement buttonApplyScheduleToPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'End time of liveblog changed successfully')]")
    private static WebElement ToastScheduleToBePublished;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='hourselect']")
    private static WebElement selectHour;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='minuteselect']")
    private static WebElement selectMinute;

    @FindBy(xpath = "//textarea[@placeholder='Enter URL body here…']")
    private static WebElement addUrlForHeadline;

    @FindBy(xpath = "//div[contains(@class,'fr wid100')]//button[contains(@class,'blue ml10')]")
    private static WebElement buttonSubmitUrlForHeadline;

    @FindBy(xpath = "//div[contains(@class,'fr wid')]//button[contains(@class,'add blue')]")
    private static WebElement submitUrlForKillStory;

    @FindBy(xpath = "//span[@id='summary1']")
    private static WebElement buttonDeleteSummary;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//div[@class='storybtnContent']/span[@class='created' and contains(text(),'EDITED')]")
    private static WebElement statusEdited;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> buttonYesForHtNewPopup;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static WebElement yesForPopup;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Story Killed')]")
    private static WebElement toastKillStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'URL changed successfuly')]")
    private static WebElement toastChangeUrl;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Soft Published successfully')]")
    private static WebElement toastSoftPublish;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;

    @FindBy(xpath = "//div[@class='uploadimage']")
    private static WebElement uploadImage;

    @FindBy(xpath = "//span[@class='pickimageBtn']")
    private static WebElement imagePicFromLib;

    @FindBy(xpath = "//button[contains(@class,'ml10') and contains(text(),'Done')]")
    private static WebElement buttonCropingDone;

    @FindBy(xpath = "//div[contains(@class,'snotify-error')]")
    private static WebElement croppingDoneError;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Cropped successfully')]")
    private static WebElement toastCropingDone;

    @FindBy(xpath = "//ul[@class='imagelist search-results']//li[1]")
    private static WebElement imgInLib;

    @FindBy(xpath = "//ul[@class='imagelist search-results']//li//img")
    private static List<WebElement> imgInLibList;

    @FindBy(xpath = "//ul[@class='imagelist search-results']//li[4]")
    private static WebElement imgInLibSecond;

    @FindBy(xpath = "//div[contains(@class,'choosephotos')]/button[2]")
    private static WebElement chooseButtonInImageGallery;

    @FindBy(xpath = "//div[@class='storybtnContent']//span[@class='threedots']")
    private static WebElement ellipsis;

    @FindBy(xpath = "//ul[@class='wid100 fl leadimageform']//li[@class='selectlead']//span[@class='slider round']")
    private static WebElement leadMediaToggle;

    @FindBy(xpath = "//ul[@class='wid100 fl leadimageform']//li[@class='selectlead']//span[@class='slider round']")
    private static List<WebElement> leadMediaToggleList;

    @FindBy(xpath = "//button[@name='saveStory' and text()='Done']")
    private static WebElement leadImageDoneButton;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

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
    private static WebElement headlineAddButtton;

    @FindBy(xpath = "//button[@class='save blue' and text()='Save']")
    private static WebElement saveButtonHeadline;

    @FindBy(xpath = "(//i[@class='icon-move'])[2]")
    private static WebElement secondImageAnchor;

    @FindBy(xpath = "(//i[@class='icon-move'])[1]")
    private static WebElement firstImageAnchor;

    @FindBy(xpath = "(//div[@class='imageblock']//img)[1]")
    private static WebElement photoGalleryImgUrlsFirst;

    @FindBy(xpath = "(//div[@class='imageblock']//img)[2]")
    private static WebElement photoGalleryImgUrlsSecond;

    @FindBy(xpath = "//span[@class='link']")
    private static WebElement storyUrl;

    @FindBy(xpath = "//div[@id='addCaptionForImage']//div[@role='textbox']")
    private static WebElement imageCaption;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement imageTitle;

    @FindBy(xpath = "//p[@data-placeholder='Add Caption here']")
    private static WebElement noImageCaption;

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

//    @FindBy(xpath = "//div[@class='search-results']/ul[1]//li/img")
//    private static WebElement firstImage;

    @FindBy(xpath = "//div[@class='imageblock']")
    private static List<WebElement> multipleImagesList;

    @FindBy(xpath = "//div[contains(@class,'storybtn')]//span[contains(@class,'created')]")
    private static WebElement publishedDate;

    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static List<WebElement> sectionBox;

    @FindBy(xpath = "//div[contains(@class,'internaldisplay')]//descendant::li/i[@class='icon-list']")
    private static WebElement imageListViewIcon;

    @FindBy(xpath = "//div[@class='imagecontain']//img")
    private static List<WebElement> listOfImagesInGridTab;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "//div[contains(@class,'imageblock')]/img")
    private static List<WebElement> listOfImagesSrc;
    @FindBy(xpath = "(//div[@class='contentList']//li[@class='headline spImg']//div[@class='listCell'])[1]")
    private static WebElement firstStoryHeadlineText;
    @FindBy(xpath = "//div[contains(@class,'snotifyToast__buttons')]/button[contains(text(),'Yes')]")
    private static WebElement popupYesForLockedStoryOnPage;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']")
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[1]/div")
    private static WebElement enterHeadlineTextBox;

    @FindBy(id = "inputAddMetaTitleText")
    private static WebElement metaTitleText;

    @FindBy(xpath = "//textarea[@placeholder='Enter meta description here…']")
    private static WebElement metaDescText;

    @FindBy(xpath = "//span[@id='moreFilter']")
    private static WebElement moreFilter;

    @FindBy(xpath = "//span[@id='statusFilter']")
    private static WebElement statusFilter;

    @FindBy(xpath = "//label[@id='typeFilterValuePublished']")
    private static WebElement statusPublished;

    @FindBy(xpath = "//span[@id='typeFilter']")
    private static WebElement typeFilter;

    @FindBy(xpath = "//label[@id='typeFilterValuePhotoGallery']")
    private static WebElement typePhotoGallery;

    @FindBy(xpath = "//div[@class='storyListing'][3]")
    private static WebElement publishedStory;


    @FindBy(xpath = "//div[contains(text(),'Social')]")
    private static WebElement sendNotificationArea;

    @FindBy(xpath = "//li[@class='sendNotificationUpdate']//a")
    private static WebElement sendNotificationButton;

    @FindBy(xpath = "//textarea[@id='title']")
    private static WebElement titleAreaToBeChanged;


    @FindBy(xpath = "//input[@id='email']")
    private static WebElement moEngageMail;

    @FindBy(xpath = "//input[@id='password']")
    private static WebElement moEngagePassword;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement loginButton;

    @FindBy(xpath = "//button[@name='send']")
    private static WebElement SendNotificationButton;

    @FindBy(xpath = "(//input[contains(@class, 'mds-input__input__text ')])[1]")
    private static WebElement searchBar;

    @FindBy(xpath = "//tr[contains(@class,'campaign-row')]")
    private static WebElement rowAvailability;

    @FindBy(xpath = "(//div[contains(@class,'c-btn')])[1]")
    private static WebElement notificationTypeDropDown;

    @FindBy(xpath = "(//ul[@class='lazyContainer'][1]/li[7])[1]")
    private static WebElement slugOption;

    @FindBy(xpath = "(//div[contains(@class,'c-btn')])[4]")
    private static WebElement titleTypeDropDown;

    @FindBy(xpath = "//ul[contains(@class,'imagelist search-results')]//li[8]")
    private static WebElement scrollDownAbit;

    @FindBy(xpath = "//ul[contains(@class,'imagelist search-results')]//li[12]")
    private static WebElement scrollDownTwo;

    @FindBy(xpath = "//ul[contains(@class,'imagelist search-results')]//li[16]")
    private static WebElement scrollDownThree;

    @FindBy(xpath = "(//div[@class='leadMedia'])[20]")
    private static WebElement lastImageAdded;

    @FindBy(xpath = "//div[contains(@class,'snotifyToast__buttons')]/button[1]")
    private static WebElement lockMessage;

    @FindBy(xpath = "//span[@id='storyUrl']/..")
    private static WebElement generatedUrl;

    @FindBy(xpath = "(//div[contains(@class,'ck-content')])[4]")
    private static WebElement addCaptionText1;

    @FindBy(id="addCaptionText")
    private static WebElement addCaptionText2;

    @FindBy(xpath = "(//div[contains(@class,'ck-content')])[4]/p")
    private static WebElement addCaptionTextArea;


    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//button[@name='saveStory']")
    private static WebElement editDoneButton;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//div/p")
    private static WebElement firstImageCaption;

    @FindBy(xpath = "(//div[@class='leadMedia']//input)[1]")
    private static WebElement firstImageCaptionNameData;


    @FindBy(xpath = "//div[contains(@class,'leadimage')]")
    private static WebElement leadImage;

    @FindBy(xpath = "//div[@id='addCaptionForImage']//p | //div[@id='addCaptionForImage']//input")
    private static WebElement leadImageCaptionForBangla;

    @FindBy(xpath = "//input[contains(@class,'ck-input-text')]")
    private static WebElement addHyperLink;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement submitHyperLink;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]//a")
    private static WebElement hyperLinkedWord;


    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//a")
    private static WebElement captionWord;

    @FindBy(xpath = "(//li[@id='leadMedia']//i)[1]")
    private static WebElement leadMediaIcon;

    @FindBy(xpath = "(//input[@type='file'])[1]")
    private static WebElement uploadNewImageFile;

    @FindBy(xpath = "//button[@id='buttonCropingDone']")
    private static WebElement doneButton;





    public PhotoGalleryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        dbUtils = DbUtils.getInstance();
    }

    //TODO: In below function there is no use of paragraph parameter, it needs to be removed
    @Override
    public boolean createPhotoGallery(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;
        createPhotoGallery(headline, summary, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 25, "Single record");
        isStoryCreated = commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "CREATED", 30, "Correct text is");
        return isStoryCreated;
    }

    @Override
    public boolean verifyCreatePhotoGalleryWithMultiplePhotos(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;
        if (globalVars.isProdRun()) {
            searchStoryByIDAndSelect(storyIdNumber);
            selectMultipleImageFromLibrary();
            savePhotoGalleryAndVerify();
            commonFunctions.closeAllWindowsExceptMasterTabOnly();
            dashboardPage.clickOnDashboard();

        } else {
            createPhotoGalleryWithMultipleImages(headline, summary, byline, section, subsection, keyword, location);
        }

        searchStoryByID(storyIdNumber);

        isStoryCreated = commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 25, "Single record");
        return isStoryCreated;
    }

    @Override
    public boolean verifyCreatePhotoGalleryStatus(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;
        createPhotoGallery(headline, summary, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        isStoryCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        return isStoryCreated;
    }

    @Override
    public boolean discardPhotoGallery() {
        boolean isDiscardGallery;
        searchStoryByIDAndSelect(storyIdNumber);
        discardStory();
        searchStoryByID(storyIdNumber);
        isDiscardGallery = commonFunctions.checkElementText(textNoData, "No Data", 10, "Correct text is");
        dashboardPage.clearSearch();
        return isDiscardGallery;
    }

    @Override
    public boolean verifyPublishPhotoGallery() {
        boolean isGalleryPublished;
        searchStoryByIDAndSelect(storyIdNumber);
        publishStoryAndVerify();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(storyStatus, 20, "Wait for Story Status");
        commonFunctions.waitForElementIgnoringStaleElement(storyStatus, 20, "Wait for story");
        isGalleryPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isGalleryPublished;
    }

    @Override
    public boolean softPublishPhotoGallery() {
        if (globalVars.isProdRun()) {
//            commonFunctions.waitForElementToBeVisibleAndClickable(dropDownRecordListInPagination, 20, "dropDownRecordListInPagination");
//            Select dropDown = new Select(dropDownRecordListInPagination);
//            dropDown.selectByVisibleText("200");
            dashboardPage.openPublishedAndUnlockedStory("Photo Gallery");
        } else {
            searchStoryByIDAndSelect(storyIdNumber);
        }
        return softPublishGallery();
    }

    @Override
    public boolean softPublishPhotoGallery(String newHeadline) {
        if (globalVars.isProdRun()) {
            commonFunctions.refreshPage();
            commonFunctions.waitForElementToBeInvisible(dropDownRecordListInPagination, 20);
            Select dropDown = new Select(dropDownRecordListInPagination);
            dropDown.selectByVisibleText("200");
            dashboardPage.openPublishedAndUnlockedStory("Photo Gallery");
        } else {
            searchStoryByIDAndSelect(storyIdNumber);
            commonFunctions.isElementDisplayedAndPresent(publishedDate, 30, "wait for time to be displayed");
            timeOnPublishedStory = getPublishedDateFromStoryParser();
        }
        return softPublishGallery(newHeadline);
    }

    @Override
    public boolean verifyKillPhotoGallery() {
        searchStoryByIDAndSelect(storyIdNumber);
        return killStoryAndVerify();
    }

    @Override
    public boolean verifyPurgePhotoGallery() {
        searchStoryByIDAndSelect(storyIdNumber);
        return purgeGalleryAndVerify();
    }

    @Override
    public boolean editedPhotoGalleryAndVerify() {
        boolean isGalleryEdited;
        searchStoryByIDAndSelect(storyIdNumber);
        fileStoryAndFinishEditing();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isGalleryEdited = commonFunctions.checkElementText(storyStatus, "EDITED", 10, "Correct text is");
        return isGalleryEdited;
    }

    @Override
    public boolean verifySchedulePhotoGallery() {
        boolean isGalleryScheduled;
        searchStoryByIDAndSelect(storyIdNumber);
        schedulePublish();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isGalleryScheduled = commonFunctions.checkElementText(storyStatus, "SCHEDULED", 10, "Correct text is");
        return isGalleryScheduled;
    }

    @Override
    public boolean verifyDeleteGalleryContent() {
        boolean isElementTextDeleted;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonDeleteSummary, 15, "delete summary ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        savePhotoGalleryAndVerify();
        commonFunctions.refreshPage();
        isElementTextDeleted = commonFunctions.getElementTextAndCheck(addSummaryText, "", 20, "Summary text deletion");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        return isElementTextDeleted;
    }

    @Override
    public boolean checkChangeUrlPhotoGallery() {
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
    public boolean updateCustomHeading(String landing, String mobile, String browser, String facebook, String twitter, String newsletter, String domain) {
        boolean isCustomHeadingUpdated;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(headlineAddButtton, 15, "headline add button");
        commonFunctions.sendKeys(landingPageHeadline, landing, 10, "landing page headline");
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

    @Override
    public boolean imageDragAndDropInPhotoGallery() {
        searchStoryByIDAndSelect(storyIdNumber);
        selectSecondImageFromLibrary();
        savePhotoGalleryAndVerify();
        List<String> imgUrlsBefore = new ArrayList<>();
        commonFunctions.scrollPageWithJS(photoGalleryImgUrlsFirst, 15);
        String url = commonFunctions.getAttributeValue(photoGalleryImgUrlsFirst, 10, "src");
        imgUrlsBefore.add(url.substring(0, url.lastIndexOf('.')));
        commonFunctions.scrollPageWithJS(photoGalleryImgUrlsSecond, 15);
        url = commonFunctions.getAttributeValue(photoGalleryImgUrlsSecond, 10, "src");
        imgUrlsBefore.add(url.substring(0, url.lastIndexOf('.')));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(secondImageAnchor, firstImageAnchor).perform();
        savePhotoGalleryAndVerify();
        commonFunctions.refreshPage();
        List<String> imgUrlsAfter = new ArrayList<>();
        commonFunctions.scrollPageWithJS(photoGalleryImgUrlsFirst, 15);
        url = commonFunctions.getAttributeValue(photoGalleryImgUrlsFirst, 10, "src");
        imgUrlsAfter.add(url.substring(0, url.lastIndexOf('.')));
        commonFunctions.scrollPageWithJS(photoGalleryImgUrlsSecond, 15);
        url = commonFunctions.getAttributeValue(photoGalleryImgUrlsSecond, 10, "src");
        imgUrlsAfter.add(url.substring(0, url.lastIndexOf('.')));
        Collections.reverse(imgUrlsAfter);
        if (imgUrlsBefore.containsAll(imgUrlsAfter)) { //imgUrlsBefore.equals(imgUrlsAfter)
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyMultipleImages() {
        boolean multipleImages = false;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(inputAddByLineText, 20, "Wait got page load");
        if (multipleImagesList.size() > 1) {
            multipleImages = true;
        }
        return multipleImages;
    }

    private void createPhotoGallery(String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        inputSummary(summary);
        inputByLine(byline);
        inputSection(section);
        inputSubSection(subsection);
        inputKeyWords(keyword);
        inputLocation(location);
        selectImageFromLibrary();
        checkCaption();
        selectLeadImage();
        inputByLine(byline);
        savePhotoGalleryAndVerify();
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    private void createPhotoGalleryWithMultipleImages(String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        inputSummary(summary);
        inputByLine(byline);
        inputSection(section);
        inputSubSection(subsection);
        inputKeyWords(keyword);
        inputLocation(location);
        selectMultipleImageFromLibrary();
        checkCaption();
        selectLeadImage(0);
        savePhotoGalleryAndVerify();
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    private void checkCaption() {
        commonFunctions.hardWait(5000);
        if (!commonFunctions.isElementPresentWithTryCatch(imageCaption, 10)) {
            commonFunctions.isElementPresentWithTryCatch(buttonImageEditIcon, 20);
            commonFunctions.clickElementIfDisplayed(buttonImageEditIcon, 20, "Click Edit button");
        }
        commonFunctions.waitForElementIgnoringStaleElement(editImageBlock, 10, "editImageBlock");
        //commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        commonFunctions.moveToElementWithActions(editImageBlock, 20, "move to Done button");
        //commonFunctions.scrollPageWithJS(imageTitle,20);
        commonFunctions.clickElementIfDisplayed(imageTitle, 20, "click Image TItle");
        commonFunctions.clickElementIfDisplayed(imageCaption, 20);
        commonFunctions.sendKeyWithActions(imageCaption, "This is Image Testing Campaign");
        commonFunctions.isElementDisplayedAndPresent(leadImageDoneButton, 10, "wait for Done button to be displayed");
        if (imageCaption.getText().isEmpty()) {
            commonFunctions.sendKey(imageCaption, "This is Image Testing Campaign");
        }
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
        commonFunctions.clickElement(buttonApplyScheduleToPublish, 10, "apply button");
        commonFunctions.checkElementText(ToastScheduleToBePublished, "End time of liveblog changed successfully", 10, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 10, "Correct text is");
    }

    private void fileStoryAndFinishEditing() {
        commonFunctions.clickElement(buttonFileStoryForEdit, 10, "File Button");
        commonFunctions.isElementDisplayedAndPresent(buttonFinishedEditing, 20, "wait for button Finish editing");
        commonFunctions.clickElementWithJS(buttonFinishedEditing, 25, "Finished Editing button");
        commonFunctions.isElementDisplayedWithoutTryCatch(statusEdited, 20, "Story edited");
    }

    private boolean purgeGalleryAndVerify() {
        boolean isGalleryPurged;
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonPurgeStory, 15, "purge story button");
        isGalleryPurged = commonFunctions.checkElementText(toastPurgeStory, "Purge request accepted", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
        return isGalleryPurged;
    }

    private void selectLeadImage() {
        commonFunctions.scrollPageWithJS(leadMediaToggle, 10);
        commonFunctions.clickElement(leadMediaToggle, 10, "lead media");
        if (commonFunctions.isElementDisplayedWithCatch(leadMediaToggle, 10)) {
            commonFunctions.clickElementIfDisplayed(yesForPopup, 5, "yes button");
        }
        imageCroppingAndVerify();
        commonFunctions.clickElement(leadImageDoneButton, 10, "Done Button for lead Image");
    }

    private void selectLeadImage(int index) {
        commonFunctions.scrollPageWithJS(leadMediaToggleList.get(index), 10);
        commonFunctions.moveToElementWithActions(leadMediaToggleList.get(index), 20, "Move to Lead Media");
        commonFunctions.moveToElementWithActions(multipleImagesList.get(index), 20, "Move to first image");
        leadMediaToggleList.get(index).click();
        if (commonFunctions.isElementDisplayedWithCatch(leadMediaToggleList.get(index), 10)) {
            commonFunctions.clickElementIfDisplayed(yesForPopup, 5, "yes button");
        }
        imageCroppingAndVerify();
        commonFunctions.clickElement(leadImageDoneButton, 10, "Done Button for lead Image");
    }

    private void discardStory() {
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonDiscardStory, 10, "Discard button");
    }

    private boolean killStoryAndVerify() {
        boolean isGalleryKilled;
        commonFunctions.clickElementIfDisplayed(ellipsis, 10, "three dots ");
        commonFunctions.clickElementIfDisplayed(buttonKillStory, 10, "Kill button");
        commonFunctions.clickElement(submitUrlForKillStory, 10, "done button");
        commonFunctions.isElementDisplayedWithoutTryCatch(toastKillStory, 10, "kill story toaster");
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isGalleryKilled = commonFunctions.checkElementText(storyStatus, "KILLED", 30, "Correct text is");
        return isGalleryKilled;
    }

    private boolean softPublishGallery() {
        boolean isGallerySoftPublished;
        boolean isReadabilityPopup;
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonSoftPublish, 10, "soft publish button");
        isGallerySoftPublished = commonFunctions.isElementDisplayedAndPresent(toastSoftPublish, 10, "soft publish toaster message");
        if (!isGallerySoftPublished) {
            isReadabilityPopup = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopup) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 10, "Yes button on popup ");
                isGallerySoftPublished = commonFunctions.checkElementText(toastSoftPublish, "Soft Published successfully", 7, "Correct text is");
            }
        }
        commonFunctions.clickElement(appLogo, 20);
        return isGallerySoftPublished;
    }

    private boolean softPublishGallery(String newHeadline) {
        boolean isGallerySoftPublished;
        boolean isReadabilityPopup;
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "wait for headline to be displayed");
        commonFunctions.sendKeys(enterHeadlineText, newHeadline, 30, "Enter new Headline");
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonSoftPublish, 10, "soft publish button");
        isGallerySoftPublished = commonFunctions.isElementDisplayedAndPresent(toastSoftPublish, 10, "soft publish toaster message");
        if (!isGallerySoftPublished) {
            isReadabilityPopup = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopup) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 10, "Yes button on popup ");
                isGallerySoftPublished = commonFunctions.checkElementText(toastSoftPublish, "Soft Published successfully", 7, "Correct text is");
            }
        }
        commonFunctions.clickElement(appLogo, 20);
        return isGallerySoftPublished;
    }

    private void publishStoryAndVerify() {
        boolean isPublishSuccessfully;
        boolean isReadabilityPopup;
        commonFunctions.hardWait(5000);
        //commonFunctions.isElementDisplayedAndPresent(buttonPublish,30,"wait for Publish button to be displayed");
        commonFunctions.isElementDisplayed(buttonPublish, 20, "wait for Publish button to be displayed");
        commonFunctions.clickElementWithJS(buttonPublish, 10, "publish gallery");
        commonFunctions.hardWait(2000);
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
    }

    private void selectPhotoGallery() {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectPhotoGallery, 25, "Photo Gallery button");
    }

    private void savePhotoGalleryAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        List<WebElement> elements = new ArrayList<>();
        elements.add(toastSaveButton);
        commonFunctions.isElementDisplayed(elements, 10, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
    }

    private void selectImageFromLibrary() {
        commonFunctions.clickElement(imagePicFromLib, 10, "Picture from Image Library");
        commonFunctions.hardWait(5000);
        commonFunctions.isElementDisplayedAndPresent(imgInLibList, 20, "Wait for list to be loaded");
        //commonFunctions.clickElement(imgInLib, 20, "Library Image");
        for (int i = 0; i <= imgInLibList.size() - 1; i++) {
            if (imgInLibList.get(i).getAttribute("src").contains("amazonaws")) {
                commonFunctions.clickElementIfDisplayed(imgInLibList.get(i), 20, "click on Image having Src value");
                commonFunctions.hardWait(2000);
                break;
            }
        }
        commonFunctions.scrollPageWithJS(chooseButtonInImageGallery, 10);
        //commonFunctions.isElementDisplayedAndPresent(buttonCropingDone, 4, "done button");
        commonFunctions.clickElementWithJS(chooseButtonInImageGallery, 10, "choose Button");
        commonFunctions.checkElementText(allChangesSaved, "SAVING CHANGES...", 20, "wait for saving changes ");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for all changed are saved");
        imageCroppingAndVerify();
    }

    public boolean addImageCaption(String caption) {
        commonFunctions.isElementDisplayedAndPresent(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.isElementDisplayedAndPresent(addCaptionForImage, 10, "image caption");
        commonFunctions.clickElementIfDisplayed(addCaptionForImage, 10, "image caption");
        if (addCaptionForImage.getText().length() > 0) {
            addCaptionForImage.clear();
        }
        commonFunctions.clickElementIfDisplayed(addCaptionForImage);
        commonFunctions.sendKeyWithActions(addCaptionForImage, caption);
        commonFunctions.scrollPageWithJS(editDoneButton, 5);
        commonFunctions.hardWait(2000);
        commonFunctions.clickElementWithJS(editDoneButton, 10, "first image done button");
        commonFunctions.hardWait(5000);
        String text=firstImageCaptionNameData.getAttribute("ng-reflect-model");
        return text.contains(caption);
    }

    private void selectMultipleImageFromLibrary() {
        commonFunctions.clickElement(imagePicFromLib, 10, "Picture from Image Library");
        commonFunctions.clickElement(imgInLib, 10, "Library Image");
        commonFunctions.hardWait(30000);
        commonFunctions.clickElement(imgInLibSecond, 10, "Library Image");
        commonFunctions.hardWait(2000);
        commonFunctions.scrollPageWithJS(chooseButtonInImageGallery, 10);
        commonFunctions.clickElementWithJS(chooseButtonInImageGallery, 10, "choose Button");
        multipleImageCroppingAndVerify();
    }

    private void selectSecondImageFromLibrary() {
        commonFunctions.clickElement(imagePicFromLib, 10, "Picture from Image Library");
        commonFunctions.clickElement(imgInLibSecond, 10, "Library Image");
        commonFunctions.scrollPageWithJS(chooseButtonInImageGallery, 10);
        commonFunctions.clickElementWithJS(chooseButtonInImageGallery, 10, "choose Button");
        imageCroppingAndVerify();
        commonFunctions.clickElement(leadImageDoneButton, 10, "Done Button for lead Image");
    }

    private void imageCroppingAndVerify() {
        if (commonFunctions.isElementPresentWithTryCatch(buttonCropingDone, 30)) {
            commonFunctions.scrollPageWithJS(buttonCropingDone, 10);
            commonFunctions.clickElementWithJS(buttonCropingDone, 20, "done Button");
            if(!commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 20, "Cropped Successfully message is present")){
                commonFunctions.clickElementWithJS(buttonCropingDone, 20, "done Button");
                commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 20, "Cropped Successfully message is present");
            }
            commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for all changed are saved");
        }
    }

    private void multipleImageCroppingAndVerify() {
        if (commonFunctions.isElementDisplayedWithCatch(buttonCropingDone, 10)) {
            commonFunctions.scrollPageWithJS(buttonCropingDone, 10);
            commonFunctions.clickElementWithJS(buttonCropingDone, 20, "done Button");
            commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 20, "Cropped Successfully message is present");
            commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 20, "Cropped Successfully message is present");
        }
    }

    private void inputLocation(String location) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 10, "location box")) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
        }
    }

    private void inputKeyWords(String keyword) {
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
    }

    private void inputSubSection(String subsection) {
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 20, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }

    private void inputByLine(String byline) {
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for changes saved label ");
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
    }

    private void searchStoryByIDAndSelect(String id) {

        searchStoryByID(id);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 10, "Single record");
        commonFunctions.isElementDisplayedAndPresent(selectedStory, 15, "dashboard item");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 15, "gallery list item");
    }

    private void searchStoryByID(String id) {
        commonFunctions.isElementDisplayed(searchAllStoriesText, 20);
        searchAllStoriesText.clear();
        commonFunctions.sendKeys(searchAllStoriesText, "id:" + id, 10, "search box");
        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
        commonFunctions.isElementDisplayedAndPresent(showingResult, 20, "Wait for Filter result");
    }

    private void inputSummary(String summary) {
        commonFunctions.isElementDisplayedAndPresent(addSummaryText, 20, "wait for summary to be displayed");
        commonFunctions.sendKey(addSummaryText, summary);
    }

    private void inputHeadline(String headline) {
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "Wait for headline to be displayed");
        char[] summaryChar = headline.toCharArray();
        for (int i = 0; i <= summaryChar.length - 1; i++) {
            commonFunctions.sendKeyWithActions(enterHeadlineText, Character.toString(summaryChar[i]));
        }
        //commonFunctions.sendKey(enterHeadlineText, headline);
    }

    public void setStoryId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
    }

    public Date getPublishedDateFromStoryParser() {

        String publishDate = publishedDate.getText();
        Date date = commonFunctions.getPublishedDateTime(publishDate);
        return date;
    }

    @Override
    public boolean checkChangeUrlPhotoGallery(String changeUrlHeadline) {
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
    public boolean defaultSection(String headline, String summary, String section, String subsection, String secondSectionName) {
        boolean isShowing = true;
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        inputSummary(summary);
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for changes saved label ");
        commonFunctions.isElementDisplayedAndPresent(inputAddSectionText, 20, "wait for Element display");
        commonFunctions.clickElementIfDisplayed(inputAddSectionText, 20, "wait for Suggestion popuplist");
        commonFunctions.isElementDisplayedAndPresent(inputAddByLineSuggestionPopup, 40, "Wait for Auto Sugestion popup displayed");
        isShowing &= commonFunctions.getAttributeValue(inputAddSectionText, 60, "ng-reflect-model").equalsIgnoreCase(section);
        commonFunctions.sendKeys(inputAddSectionText, secondSectionName, 20, "section box");
        commonFunctions.sendKeysWithEnter(inputAddSectionText, 10);
        isShowing &= commonFunctions.getAttributeValue(inputAddSectionText, 60, "ng-reflect-model") == null;
        inputSubSection(subsection);
        return isShowing;
    }

    @Override
    public boolean createPhotoGalleryWithMultiplesImages(String section, String headline, String summary, String byline, String subsection, String keyword, String location) {
        boolean isShowing = false;
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        inputSummary(summary);
        isShowing = selectMultipleImages();
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for changes saved label ");
        dashboardPage.inputSection(section);
        inputSubSection(subsection);
        inputKeyWords(keyword);
        inputLocation(location);
        inputByLine(byline);
        savePhotoGalleryAndVerify();
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 25, "Single record");
        isShowing &= commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "CREATED", 30, "Correct text is");
        return isShowing;
    }

    private boolean selectMultipleImages() {
        boolean isShowing = false;
        commonFunctions.clickElement(imagePicFromLib, 10, "Picture from Image Library");
        commonFunctions.isElementDisplayedAndPresent(listOfImagesInGridTab, 20, "images loading");
        for (int i = 0; i <= listOfImagesInGridTab.size() - 1; i++) {
            if (listOfImagesInGridTab.get(i).getAttribute("src").contains("amazonaws")) {
                commonFunctions.clickElementIfDisplayed(listOfImagesInGridTab.get(i), 20, "Click on Image having src tab");
                if (isShowing = commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(chooseButtonInImageGallery, "Choose 8 Images", 10, "number of images")) {
                    isShowing = true;
                    break;
                } else {
                    System.out.println("8 images not selected");
                }
            }
        }
        commonFunctions.clickElementWithJS(chooseButtonInImageGallery, 10, "choose Button");
        commonFunctions.checkElementText(allChangesSaved, "SAVING CHANGES...", 30, "wait for saving changes ");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 30, "wait for all changed are saved");
        commonFunctions.scrollPageWithJS(imagePicFromLib, 20);
        if (isShowing = listOfImagesSrc.size() == 8) {
            isShowing = true;
            System.out.println("all images are matched");
        } else {
            isShowing = false;
            System.out.println("all images are not  matched!!!!!!!!");
        }
        return isShowing;
    }

    @Override
    public boolean createPhotoGalleryWithMultiplesImagesCaptionName(String section, String headline, String summary, String byline, String subsection, String keyword, String location, String firstCaption, String secondCaption, String thirdCaption) {
        boolean isShowing = false;
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        inputSummary(summary);
        isShowing = selectMultipleImages();
        isShowing &= dashboardPage.changeFirstImageCaptionName(firstCaption);
        isShowing &= dashboardPage.changeSecondImageCaptionName(secondCaption);
        isShowing &= dashboardPage.changeThirdImageCaptionName(thirdCaption);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for changes saved label ");
        dashboardPage.inputSection(section);
        inputSubSection(subsection);
        inputKeyWords(keyword);
        inputLocation(location);
        inputByLine(byline);
        savePhotoGalleryAndVerify();
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 25, "Single record");
        isShowing &= commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "CREATED", 30, "Correct text is");
        return isShowing;
    }

    @Override
    public boolean changeImageCaptionName(String storyType, String firstCaption) {
        boolean isShowing;
        dashboardPage.clickOnBlankPaperLogo();
        dashboardPage.publishedStory(storyType);
        storyHeadlineText = commonFunctions.getElementText(firstStoryHeadlineText, 30);
        commonFunctions.clickElementIfDisplayed(firstStoryHeadlineText, 30, "first story");
        commonFunctions.clickElementIfDisplayed(popupYesForLockedStoryOnPage, 5, "popup Yes for Locked Stories");
        isShowing = dashboardPage.changeFirstImageCaptionName(firstCaption);
        setStoryId();
        commonFunctions.clickElementWithJS(appLogo, 20, "blankpaper logo");
        return isShowing;
    }

    @Override
    public boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoGalleryTheSameDataIsPresentInMetatitleOrNot() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        String inputHeadingText = "Test Meta Title " + commonFunctions.generateRandomNum();
        commonFunctions.inputHeadline(inputHeadingText, enterHeadlineTextBox);
        commonFunctions.inputSummary(inputHeadingText, addSummaryText);
        commonFunctions.scrollToElement(metaTitleText, "Meta Title Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaTitleText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Title");

    }

    @Override
    public boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        String inputHeadingText = "Test Meta Title " + commonFunctions.generateRandomNum();
        commonFunctions.inputSummary(inputHeadingText, addSummaryText);
        commonFunctions.scrollToElement(metaDescText, "Meta Desc Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaDescText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Description");
    }

    @Override
    public boolean checkMasterDbMetaTitleAndMetaDescriptionComesForPhotoGalleryStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createPhotoGalleryStoryAndPublish(headLine, summary, section, subsection, keyword, location, byline);
        return dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", storyIdNumber, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline);
    }


    public boolean createPhotoGalleryStoryAndPublish(String headline, String summary, String section, String subsection, String keyword, String location, String byline) {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        inputSummary(summary);
        inputSection(section);
        inputSubSection(subsection);
        inputKeyWords(keyword);
        inputLocation(location);
        selectImageFromLibrary();
        checkCaption();
        selectLeadImage();
        inputByLine(byline);
        savePhotoGalleryAndVerify();
        setStoryId();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        return commonFunctions.isElementPresentWithTryCatch(toastPublish, 20);
    }

    @Override
    public boolean checkCreatePhotoGalleryStoryWithLiveHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        return createPhotoGalleryStoryAndPublish(headLine, summary, section, subsection, keyword, location, byline);
    }

    @Override
    public boolean checkIfTheNamingConventionWhileSendingTheNotificationSecondTimeForAPublishedStory(String url, String email, String password) throws InterruptedException {
        String newHeading = "";
        commonFunctions.clickElementIfDisplayed(moreFilter, 10);
        commonFunctions.clickElementIfDisplayed(statusFilter, 10);
        commonFunctions.clickElementIfDisplayed(statusPublished, 10);
        commonFunctions.clickElementIfDisplayed(typeFilter, 10);
        commonFunctions.clickElementIfDisplayed(typePhotoGallery, 10);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 15, "gallery list item");

        Thread.sleep(2000);
        newHeading = sendNotificationFunction();
        Thread.sleep(10000);
        newHeading = sendNotificationFunction();
        Thread.sleep(2000);
        commonFunctions.newTabWithUrl(url);
        Thread.sleep(10000);
        commonFunctions.sendKeys(moEngageMail, email, 10, "mail area");
        commonFunctions.sendKeys(moEngagePassword, password, 10, "password area");
        commonFunctions.clickElement(loginButton, 10, "login button");
        Thread.sleep(10000);
        commonFunctions.sendKeys(searchBar, newHeading, 10, "sending heading");
        commonFunctions.sendKeysWithEnter(searchBar, 10);
        return commonFunctions.isElementPresent(rowAvailability, 10);
    }

    @Override
    public boolean checkIfTheNamingConventionWhileSendingTheNotificationToMoEngageForAPublishedStory(String url, String email, String password) throws InterruptedException {
        String newHeading = "";
        commonFunctions.clickElementIfDisplayed(moreFilter, 10);
        commonFunctions.clickElementIfDisplayed(statusFilter, 10);
        commonFunctions.clickElementIfDisplayed(statusPublished, 10);
        commonFunctions.clickElementIfDisplayed(typeFilter, 10);
        commonFunctions.clickElementIfDisplayed(typePhotoGallery, 10);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 15, "gallery list item");

        Thread.sleep(2000);
        newHeading = sendNotificationFunction();
        Thread.sleep(2000);
        commonFunctions.navigateToUrl(url);
        Thread.sleep(10000);
        commonFunctions.sendKeys(moEngageMail, email, 10, "mail area");
        commonFunctions.sendKeys(moEngagePassword, password, 10, "password area");
        commonFunctions.clickElement(loginButton, 10, "login button");
        Thread.sleep(10000);
        commonFunctions.sendKeys(searchBar, newHeading, 10, "sending heading");
        commonFunctions.sendKeysWithEnter(searchBar, 10);
        return commonFunctions.isElementPresent(rowAvailability, 10);
    }

    public String sendNotificationFunction() {
        commonFunctions.scrollToElement(sendNotificationArea, "scroll to notification element");
        commonFunctions.clickElement(sendNotificationButton);
        String newHeading = commonFunctions.getAttributeValue(metaTitleText, 20, "ng-reflect-model") + String.valueOf(commonFunctions.generateRandomNum());
        commonFunctions.sendKeys(titleAreaToBeChanged, newHeading, 10, "sending text");
        commonFunctions.clickElement(SendNotificationButton, 10);
        return newHeading;
    }

    @Override
    public boolean checkIfTitleFieldDropdownValuesWithSlugOption() {
        commonFunctions.clickElementIfDisplayed(moreFilter, 10);
        commonFunctions.clickElementIfDisplayed(statusFilter, 10);
        commonFunctions.clickElementIfDisplayed(statusPublished, 10);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 15, "gallery list item");
        commonFunctions.hardWait(5000);
        if(commonFunctions.isElementDisplayedWithExceptionHandling(lockMessage,5,"check lock message")){
            System.out.println("inside");
            commonFunctions.clickElement(lockMessage);
        }
        commonFunctions.hardWait(2000);
        commonFunctions.scrollToElement(sendNotificationArea, "scroll to notification element");
        commonFunctions.clickElement(sendNotificationButton);
        commonFunctions.clickElementIfDisplayed(notificationTypeDropDown, 10);
        commonFunctions.clickElementIfDisplayed(slugOption, 10);
        return commonFunctions.waitForElementBeDisplayAndClick(titleTypeDropDown, 10, "title dropdown menu");
    }

    @Override
    public boolean checkIfUserIsAbleToAddMoreThanTenImagesInPhotoGallerySmoothly() {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean result=selectMultipleImagesFromImageLibrary();
        return result;
    }
    private boolean selectMultipleImagesFromImageLibrary() {
        commonFunctions.clickElement(imagePicFromLib, 10, "Picture from Image Library");
        commonFunctions.isElementDisplayedAndPresent(imgInLibList, 10, "Wait for list to be loaded");
        int imageCount=20;
        for (int i = 0; i<imageCount; i++) {
            if(i==8) {
                commonFunctions.scrollToElementView(scrollDownAbit,20,"scrolling down");
                commonFunctions.hardWait(2000);
            }
            if(i==12) {
                commonFunctions.scrollToElementView(scrollDownTwo,20,"scrolling down");
                commonFunctions.hardWait(2000);
            }
            if(i==16) {
                commonFunctions.scrollToElementView(scrollDownThree,20,"scrolling down");
                commonFunctions.hardWait(2000);
            }
            if (imgInLibList.get(i).getAttribute("src").contains("amazonaws")) {
                commonFunctions.clickElementIfDisplayed(imgInLibList.get(i), 20, "click on Image having Src value");
            }
        }
        commonFunctions.clickElementIfDisplayed(chooseButtonInImageGallery,10);
        commonFunctions.checkElementText(allChangesSaved, "SAVING CHANGES...",20, "wait for saving changes ");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED",20, "wait for all changed are saved");
        boolean result=true;
        for(int i=0;i<imageCount;i++){
            commonFunctions.hardWait(1000);
            commonFunctions.clickElementIfDisplayed(buttonCropingDone,10);
            if(commonFunctions.isElementDisplayedWithExceptionHandling(croppingDoneError,10,"error in cropping")){
                commonFunctions.hardWait(5000);
                commonFunctions.clickElementIfDisplayed(buttonCropingDone, 20, "done Button");
                result&=commonFunctions.isElementDisplayedWithExceptionHandling(toastCropingDone, 20, "Cropped Successfully message is present");
            }
            commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for all changed are saved");
        }
        return result;
    }

    @Override
    public boolean checkIfUserIsAbleToCreateStoryPhotoGallery(String property, String headLine, String summary, String byline, String section, String subsection, String keyword, String location,String Caption) {
        boolean isResult;
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        selectImageFromLibrary();
        commonFunctions.hardWait(2000);
        isResult=addImageCaption("Photo gallery");
        if(isResult) {
            commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "three Dots First Image");
            selectLeadImage();
            inputSummary(summary);
            inputByLine(byline);
            inputSection(section);
            inputSubSection(subsection);
            inputKeyWords(keyword);
            inputLocation(location);
            savePhotoGalleryAndVerify();
            setStoryId();
            commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
            boolean result = commonFunctions.isElementPresent(toastPublish, 20);
            if (result) {
                commonFunctions.hardWait(2000);
                commonFunctions.scrollToElementViewAndClick(generatedUrl, 10, "url generated");
                Set<String> windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
                if (windowsList1.size() == 3) return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfUserIsAbleToClickOnPhotoGalleryOptionFromCreateStoryDropDown() {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        return commonFunctions.clickElementWithJS(selectPhotoGallery, 25, "Photo Gallery button");
    }

    @Override
    public boolean checkIfUserIsRedirectedToPhotoGalleryPage() {
        selectPhotoGallery();
        Set<String> windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        if (windowsList1.size() == 2) return true;
        return false;
    }

    @Override
    public boolean checkIfUserIsAbleToSeeUploadANewImageOrPickFromImageLibraryOption() {
        boolean isResult=true;
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isResult&=commonFunctions.isElementDisplayed(uploadImage,10,"upload a new image");
        isResult&=commonFunctions.isElementDisplayed(imagePicFromLib,10,"pick from image library");
        return isResult;
    }

    @Override
    public boolean checkIfUserIsAbleToSelectMultipleImageFromPickFromImageGalleryOption() {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElementIfDisplayed(imagePicFromLib,10,"pick from image library");
        commonFunctions.clickElement(imgInLib, 10, "Library Image");
        commonFunctions.clickElement(imgInLibSecond, 10, "Library Image");
        commonFunctions.scrollPageWithJS(chooseButtonInImageGallery, 10);
        String noOfImages=commonFunctions.getElementText(chooseButtonInImageGallery,10);
        return noOfImages.contains("2");
    }

    @Override
    public boolean checkIfImageIsUploadedWhenUserClickOnChooseImagesButtonOnPopup() {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElementIfDisplayed(imagePicFromLib,10,"pick from image library");
        commonFunctions.clickElement(imgInLib, 10, "Library Image");
        commonFunctions.scrollPageWithJS(chooseButtonInImageGallery, 10);
        commonFunctions.clickElementWithJS(chooseButtonInImageGallery, 10, "choose Button");
        return commonFunctions.isElementDisplayed(leadImage,10,"lead image");
    }

    @Override
    public boolean checkIfUploadedImageIsEditableWhenUserClickOnEditButtonForParticularImage() {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        selectImageFromLibrary();
        commonFunctions.clickElementIfDisplayed(buttonImageEditIcon,10,"edit image");
        return commonFunctions.isElementDisplayed(imageTitle,10,"caption");
    }

    @Override
    public boolean checkIfUserIsAbleToAddCaptionInTheImage(){
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        selectImageFromLibrary();
        commonFunctions.isElementDisplayedAndPresent(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.isElementDisplayedAndPresent(leadImageCaptionForBangla, 10, "image caption");
        commonFunctions.clickElementIfDisplayed(leadImageCaptionForBangla, 10, "image caption");
        if (leadImageCaptionForBangla.getText().length() > 0) {
            leadImageCaptionForBangla.clear();
        }
        commonFunctions.clickElementIfDisplayed(leadImageCaptionForBangla);
        commonFunctions.sendKeyWithActions(leadImageCaptionForBangla, "Photo gallery");
        commonFunctions.scrollPageWithJS(editDoneButton, 5);
        commonFunctions.clickElementWithJS(editDoneButton, 10, "first image done button");
        boolean isShowing = commonFunctions.checkElementText(firstImageCaptionNameData, "Photo gallery", 15, "first image Caption name");
        return isShowing;
    }


    @Override
    public boolean checkIfUserIsAbleToAddHyperLinkToCaptionInTheImage(String hyperLink, String paragraphText) {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        selectImageFromLibrary();
        commonFunctions.isElementDisplayedAndPresent(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.isElementDisplayedAndPresent(leadImageCaptionForBangla, 10, "image caption");
        commonFunctions.clickElementIfDisplayed(leadImageCaptionForBangla, 10, "image caption");
        if (leadImageCaptionForBangla.getText().length() > 0) {
            leadImageCaptionForBangla.clear();
        }
        commonFunctions.clickElementIfDisplayed(leadImageCaptionForBangla);
        commonFunctions.sendKeyWithActions(leadImageCaptionForBangla, "Photo gallery");
        boolean isResult=addHyperLink(hyperLink);
        return isResult;
    }

    @Override
    public boolean checkIfClickOnCaptionHyperlinkIsRedirectedToTheSameLinkInNewTab(String hyperLink, String paragraphText) {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        selectImageFromLibrary();
        commonFunctions.isElementDisplayedAndPresent(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "pencil edit icon");
        commonFunctions.isElementDisplayedAndPresent(leadImageCaptionForBangla, 10, "image caption");
        commonFunctions.clickElementIfDisplayed(leadImageCaptionForBangla, 10, "image caption");
        if (leadImageCaptionForBangla.getText().length() > 0) {
            leadImageCaptionForBangla.clear();
        }
        commonFunctions.clickElementIfDisplayed(leadImageCaptionForBangla);
        commonFunctions.sendKeyWithActions(leadImageCaptionForBangla, "Photo gallery");
        boolean isResult=addHyperLink(hyperLink);
        if(isResult){
            commonFunctions.scrollPageWithJS(editDoneButton, 5);
            commonFunctions.hardWait(2000);
            commonFunctions.clickElementWithJS(editDoneButton, 10, "first image done button");
            commonFunctions.checkElementText(firstImageCaptionNameData, "Photo gallery", 15, "first image Caption name");
            commonFunctions.clickElementIfDisplayed(captionWord,10,"caption word");
            Set<String> windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            commonFunctions.switchToLastWindow(windowsList1);
            String url=commonFunctions.getURL();
            System.out.println(url);
            return url.equals(hyperLink+"/");
        }
        return false;
    }

    @Override
    public boolean checkIfPickFromImageLibraryIsworking() {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        selectImageFromLibrary();
        return commonFunctions.isElementDisplayed(leadImage,10,"lead image");
    }

    public static boolean addHyperLink(String hyperLink){
        commonFunctions.clickElementIfDisplayed(leadImageCaptionForBangla,10);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("k");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        commonFunctions.sendKeys(addHyperLink,hyperLink,10,"hyperlink");
        commonFunctions.clickElementIfDisplayed(submitHyperLink,10);
        boolean isResult=commonFunctions.isElementDisplayed(hyperLinkedWord,10,"hyperlinkedWord");
        return isResult;
    }

    @Override
    public boolean checkIfUserIsAbleToSelectImageWithUploadANewImageOption() {
        selectPhotoGallery();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.hardWait(5000);
        String projectPath =System.getProperty("user.dir")+"/testimage.jpeg";
        uploadNewImageFile.sendKeys(projectPath);
        commonFunctions.clickElementIfDisplayed(doneButton,10);
        return commonFunctions.isElementDisplayed(leadImage,10);

    }
}