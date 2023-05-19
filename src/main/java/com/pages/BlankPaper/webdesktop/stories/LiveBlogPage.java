package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonLiveBlogPage;
import com.utils.DbUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class LiveBlogPage extends CommonLiveBlogPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;

    public static DbUtils dbUtils;
    List<String> titleList = new ArrayList<String>();

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//span[@id='summary1']")
    private static WebElement buttonDeleteSummary;

    @FindBy(id = "editImageName")
    private static WebElement editImage;

    @FindBy(xpath = "//div[contains(@class,'formStory')]//descendant::li[contains(@class,'headline')]//label[contains(text(),'Landing')]")
    private static WebElement storyButton;

    @FindBy(xpath = "//div[@class='storytype']//li//button[text()='Live Blog']")
    private static WebElement selectStory;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    public static String selectedStoryXPath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li";

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')]//p)[1]")
    private static WebElement enterHeadlineText;


//    @FindBy(xpath = "//p[contains(@data-placeholder,'Headline')]") //div[contains(@data-placeholder,'Headline')]//p//ul[@class='storyuL']//descendant::li[contains(@class,'headline')]//descendant::ckeditor//descendant::div/p
//    private static WebElement enterHeadlineText;

    @FindBy(xpath = "//p[contains(@data-placeholder,'Summary')]")
    //*[@data-placeholder='Enter the summary..' or @data-placeholder='Enter Summary']
    private static WebElement addSummaryText;

    @FindBy(xpath = "//p[contains(@id,'enterIntroPara')]")
    //*[@data-placeholder='Paragraph...' or @data-placeholder='Enter Intro Para']
    private static WebElement addParagraphText;

    @FindBy(xpath = "//p[@id='addPostTitle']")
    //div[@class='blockShow']//descendant::li[@class='headline']//descendant::ckeditor//descendant::div/p
    private static WebElement addPostTitleText;

    @FindBy(xpath = "//div[@class='blockShow']//descendant::li[@class='summary']//descendant::ckeditor//descendant::div/p")
    //div[@class='blockShow']//descendant::li[@class='summary']//descendant::ckeditor//descendant::div/p
    private static WebElement addPostBodyText;

    @FindBy(xpath = "//div[@class='dataField']//button[@class='yellow' and text()='Add Post']")
    private static WebElement buttonAddPost;

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

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[text()='Save']")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//div[contains(@class,'storybtn')]//button[@class='purple']")
    private static WebElement buttonFileStoryForEdit;

    @FindBy(xpath = "//div[contains(@class,'storybtn')]//button[@class='blue']")
    private static WebElement buttonFinishedEditing;

    @FindBy(xpath = "//button[@class='orange' and contains(text(),'Schedule to Publish')]")
    private static List<WebElement> buttonScheduleToPublishAvailable;

    @FindBy(xpath = "//div/span[@class='created' and contains(text(),'EDITED')]")
    private static WebElement statusEdited;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and text()='Publish']")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[@class='dataField']//descendant::i[@class='icon-image']")
    private static WebElement iconForImageUpload;

    @FindBy(xpath = "//div[@class='imageAction block']//descendant::div[@class='pickimage']/span[@class='pickimageBtn']")
    private static WebElement imagePicFromLib;

    @FindBy(xpath = "//div[@class='internaldisplayView fl100']//descendant::li/i[@class='icon-list']")
    private static WebElement imageListViewIcon;

    @FindBy(xpath = "//div[@class='imagecontain']/span[@class='hover']//child::button[@class='blue']")
    private static WebElement buttonUseImage;

    @FindBy(xpath = "//div[@class='search-results']/ul[1]")
    private static WebElement listImageSearchResult;

    @FindBy(xpath = "//div[@class='search-results']/ul//li[@class='image']//img")
    private static List<WebElement> listOfImagesInListTab;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> popupConfirmImageSize;

    @FindBy(id = "buttonCropingDone")
    private static WebElement buttonCropingDone;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Cropped successfully')]")
    private static WebElement toastCropingDone;

    @FindBy(xpath = "//label[contains(text(),'This is Testing')]")
    private static WebElement imageCaptionText;

    @FindBy(css = "i.icon-crop") //div[@class='storyaction']//span[@class='cropimage']//child::i[@class='icon-crop']
    private static WebElement buttonCropIcon;

    @FindBy(xpath = "//div[@class='unlockStory']//following::div[contains(@class,'ptb15')]")
    private static WebElement scrollToDivForCropping;

    @FindBy(xpath = "//div[@class='crop169']//div[contains(@class,'fr')]/input")
    private static WebElement imageCropRatio;

    @FindBy(xpath = "//div[@class='leadMedia']//div[@class='editimage']//div[@class='dataField']//ckeditor[contains(@class,'ng-valid ng-touched')]//div/p | //div[@class='leadMedia']//div[@class='editimage']//div[@class='dataField']//ckeditor[contains(@class,'ng-valid ng-touched')]//div/p[@class] | //p[contains(@data-placeholder,'Add Caption here')]")
    private static WebElement addCaptionForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement addTitleForImage;

    @FindBy(xpath = "//div[@class='editimage']//ul[contains(@class,'leadimageform')]")
    private static WebElement editImageBlock;


    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[3]//child::div[@class='wid50 fl padr20']//descendant::input")
    private static WebElement addNameForImage;

    @FindBy(xpath = "//button[@class='save blue' and text()='Done']")
    private static WebElement captionSubmitButton;

    @FindBy(xpath = "//div[@class='fr wid100 right']")
    private static WebElement divAreaForScrollView;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='storyaction']/span[contains(@class,'editBtn')]/i[@class='icon-pickup']")
    private static WebElement buttonImageEditIcon;

    @FindBy(xpath = "//div[@class='storybtnContent']//span[@class='threedots']")
    private static WebElement ellipsis;

    @FindBy(xpath = "//li//button[contains(text(),'Move Back')]")
    private static WebElement buttonMoveBack;

    @FindBy(xpath = "//div[@class='dataField bdrfill']//descendant::ckeditor[contains(@class,'ng')]")
    private static WebElement storyId;

    @FindBy(xpath = "//div//descendant::button[contains(text(),'Discard Story')]")
    private static WebElement buttonDiscardStory;

    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;

    @FindBy(xpath = "//div[contains(@class,'footer')]/div[contains(@class,'recordList') and contains(text(),'results')]")
    private static WebElement showingResult;

    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;

    @FindBy(xpath = "//span[contains(@class,'exact')]")
    private static WebElement exactAllStoriesButton;

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

    @FindBy(xpath = "//button[@class='orange' and contains(text(),'Schedule to Publish')]")
    private static WebElement buttonScheduleToPublish;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='hourselect']")
    private static WebElement selectHour;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='minuteselect']")
    private static WebElement selectMinute;

    @FindBy(xpath = "(//button[contains(text(),'Apply')])[last()]")
    private static WebElement buttonApplyScheduleToPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'End time of liveblog changed successfully')]")
    private static WebElement ToastScheduleToBePublished;

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

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='domainselect']")
    private static WebElement hoverOnLeftPanel;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement userName;

    @FindBy(xpath = "//section[@class='mainContainer']//ul[@class='menuContent']//descendant::span")
    private static List<WebElement> leftPanelMenuContent;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement labelUserNameAfterLogin;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement dropDownRecordListInPagination;

    @FindBy(xpath = "//div[contains(@class,'published')]//div[@class='time']")
    private static WebElement publishedDate;

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

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> buttonYesForHtNewPopup;

    @FindBy(xpath = "//span[@class='link']")
    private static WebElement storyUrl;

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

    @FindBy(xpath = "//label[contains(text(),'Caption')]")
    private static WebElement captionLabelImage;

    @FindBy(xpath = "//p[contains(@data-placeholder,'Add Caption here')]")
    private static WebElement imageCaption;

    @FindBy(xpath = "//input[contains(@placeholder,'Add Title here')]")
    private static WebElement imageTitle;

    @FindBy(xpath = "//p[@data-placeholder='Add Caption here']")
    private static WebElement noImageCaption;

    @FindBy(xpath = "//div[@class='search-results']/ul[1]//li/img")
    private static WebElement firstImage;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'URL headline is not in English')]")
    private static WebElement urlHeadlineToasterMassage;
    @FindBy(xpath = "//div[contains(@class,'blockShow')]//span/i[contains(@class,'icon-image')]")
    private static WebElement postImageIcon;
    @FindBy(xpath = "(//div[contains(@class,'blockShow')]//span/i[contains(@class,'icon-image')])[1]")
    private static WebElement secondPostImageIcon;
    @FindBy(xpath = "(//div[contains(@class,'blockShow')]//span/i[contains(@class,'icon-embed')])[1]")
    private static WebElement secondPostEmbedIcon;
    @FindBy(xpath = "//div[contains(@class,'unlockStory')]//textarea[1]")
    private static WebElement enterEmbedUrlText;
    @FindBy(xpath = "//button[contains(@class,'add blue')]")
    private static WebElement buttonSubmitUrl;
    @FindBy(xpath = "//div[contains(@class,'respVideo')]/iframe")
    private static WebElement embedSrc;
    @FindBy(xpath = "//div[@class='dataField']/button[1]")
    private static WebElement buttonPublishPost;
    @FindBy(xpath = "(//i[contains(@class,'icon-pin')])[2]")
    private static WebElement secondButtonPinPost;
    @FindBy(xpath = "(//i[contains(@class,'icon-pin')])[3]")
    private static WebElement thirdButtonPinPost;
    @FindBy(xpath = "(//i[contains(@class,'icon-pin')])[1]")
    private static WebElement firstButtonPinPost;
    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;
    @FindBy(xpath = "(//span[contains(@class,'pinnedElement')])[1]")
    private static WebElement firstPositionPinnedElement;
    @FindBy(xpath = "(//span[contains(@class,'pinnedElement')])[2]")
    private static WebElement secondPositionPinnedElement;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']")
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[1]/div")
    private static WebElement enterHeadlineTextBox;

    @FindBy(id = "inputAddMetaTitleText")
    private static WebElement metaTitleText;

    @FindBy(xpath = "//textarea[@placeholder='Enter meta description here…']")
    private static WebElement metaDescText;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "(//i[@class='icon-image'])[1]")
    private static WebElement leadMediaToggle;

    @FindBy(xpath = "(//span[@class='pickimageBtn'])[1]")
    private static WebElement leadMediaLib;

    @FindBy(xpath = "(//div[@class='imagecontain'])[1]")
    private static WebElement recentUseImage;

    @FindBy(xpath = "//button[@class='blue' and contains(text(), 'Use Image')]")
    private static WebElement useImageButton;

    @FindBy(id = "buttonCropingDone")
    private static WebElement doneButton;

    @FindBy(xpath = "//div[contains(@class, 'editimage')]/div/span[@class='threedots']")
    private static WebElement threeDotForPost;

    @FindBy(xpath = "(//div[@class='revertStoryBlock']/ul/li/button)[3]")
    private static WebElement cropOption;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')]//p)[3]")
    private static WebElement addCaptionText;

    @FindBy(xpath = "//button[@name='saveStory']")
    private static WebElement addCaptionSaveButton;

    @FindBy(xpath = "//div[@id='load-more']/button")
    private static WebElement loadMoreBtn;

    @FindBy(xpath = "//div[@class='ck ck-editor__main']/div/p")
    private static List<WebElement> postList;

    @FindBy(xpath = "//i[@class='icon-scorecard']")
    private static WebElement scroboardIcon;

    @FindBy(xpath = "//label[@class='toggleName']/following-sibling::div/input")
    private static WebElement scroboardSearchText;

    @FindBy(xpath = "(//div[contains(@class, 'autosuggestion')]/ul/li)[1]")
    private static WebElement scroboardSearchResult;

    @FindBy(xpath = "//div[@class= 'selectBoxCompany']/select")
    private static WebElement resultMatchSelect;

    @FindBy(xpath = "//button[@name='unlock']")
    private static WebElement matchDoneButton;

    @FindBy(xpath = "//div[@class='embeddcode']/div/p")
    private static WebElement crecateCardPara;

    @FindBy(xpath = "//i[@class='icon-table']")
    private static WebElement introTable;

    @FindBy(xpath = "(//button[contains(@class, 'ck-off ck-dropdown__button')])[last()]")
    private static WebElement introTableDroDown;

    @FindBy(xpath = "(//div[@class='ck-insert-table-dropdown__grid']/div)[2]")
    private static WebElement introTableDroDownValue;

    @FindBy(xpath = "//div[contains(@class, 'bdrfill table')]")
    private static WebElement introAddedTable;

    @FindBy(id = "buttonInsertVideo")
    private static WebElement introVideoIcon;

    @FindBy(xpath = "(//div[@class='imagecontain']/img)[1]")
    private static WebElement introVideosList;

    @FindBy(xpath = "(//button[contains(text(),'Use')])[1]")
    private static WebElement introVideosUseVideoBtn;

    @FindBy(xpath = "//div[@class = 'respVideo']")
    private static WebElement introAddedVideo;

    @FindBy(xpath = "//span[@class='editBtn']/i[@class='icon-pickup']")
    private static WebElement introTableEditIcon;

    @FindBy(xpath = "(//button[contains(@class, 'ck-off ck-dropdown__button')])[2]")
    private static WebElement introTableEditDropDown;

    @FindBy(xpath = "(//div[@class='ck-insert-table-dropdown__grid']/div)[12]")
    private static WebElement introTableEditDropDownValue;

    @FindBy(xpath = "//i[@id='buttonInsertEmbed']/..")
    private static WebElement buttonInsertEmbed;

    @FindBy(xpath = "(//textarea[contains(@class, 'ng-pristine')])[2]")
    private static WebElement embedText;

    @FindBy(xpath = "//div[@class='embeddcode']/div/div")
    private static WebElement addedEmbed;

    @FindBy(id = "buttonInsertImage")
    private static WebElement buttonInsertImage;

    @FindBy(xpath = "//div[contains(@class, 'block')]/div[@class='blockContain']/div[@class='pickimage']/i/following-sibling::span")
    private static WebElement imageFromLib;

    @FindBy(xpath = "(//div[@class='imagecontain']/img)[1]")
    private static WebElement introImageList;

    @FindBy(xpath = "(//span[@class='hover']/button)[1]")
    private static WebElement introImageUseVideoBtn;

    @FindBy(xpath = "//div[@class='imageblock']/img")
    private static WebElement introIAddedImage;

    @FindBy(xpath = "(//div[@class='liveblogEmbedblock']/ul/li)[last()]")
    private static WebElement introPodcastIcon;

    @FindBy(xpath = "(//div[@class='imagecontain']/img)[1]")
    private static WebElement introPodcastList;

    @FindBy(xpath = "(//span[@class='hover']/button)[1]")
    private static WebElement introPodcastUseVideoBtn;

    @FindBy(xpath = "(//div[@class='podcastBlock']/div)[1]")
    private static WebElement introAddedPodcast;

    @FindBy(xpath = "(//div[@class='liveblogEmbedblock']/../div)[last()-1]")
    private static WebElement beforeEmbededBlock;

    @FindBy(xpath = "(//div[@class='snotifyToast__body'])[1]")
    private static WebElement velidationMessage;

    @FindBy(xpath = "//div[contains(@class, 'ck-editor__editable')]/ul/li/../..")
    private static WebElement summaryTxtAfterFilling;

    @FindBy(xpath = "(//div[contains(@class, 'systemmeta')])[1]")
    private static WebElement storyInfoSection;

    @FindBy(id = "storyUrl")
    private static WebElement storyInfoUrl;

    @FindBy(xpath = "//span[@class='editBtn']/span/i")
    private static WebElement storyInfoUrlCopyIcon;

    @FindBy(xpath = "//div[@class='snotifyToast__body']")
    private static WebElement storyInfoUrlCopyMsg;

    @FindBy(xpath = "//div[@class='leftSpace']/following-sibling::h1")
    private static WebElement liveBlogName;

    @FindBy(xpath = "//div[@id='addCaptionForImage']//p | //div[@id='addCaptionForImage']//input")
    private static WebElement firstImageCaption;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//label")
    private static WebElement firstImageCaptionNameData;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//button[@name='saveStory']")
    private static WebElement editDoneButton;

    @FindBy(id = "expireAt")
    private static WebElement endLiveBlogButton;


    @FindBy(xpath = "(//div[contains(@class,'show-calendar')])[2]")
    private static WebElement showCalender;

    @FindBy(xpath = "//span[@id='storyUrl']/..")
    private static WebElement generatedUrl;


    @FindBy(xpath = "//div[@class='livenow']")
    private static WebElement liveUpdatesRadioButton;

    @FindBy(xpath = "((//select[@class='hourselect'])[1]/option)")
    private static List<WebElement> selectHourDropDown;

    @FindBy(xpath = "((//select[@class='minuteselect'])[1]/option)")
    private static List<WebElement> selectMinuteDropDown;

    @FindBy(xpath = "//div[contains(@class,'snotify-error')]")
    private static WebElement croppingDoneError;


    @FindBy(xpath = "(//span[@class='created'])[2]")
    private static WebElement blogEndedMessage;


    public LiveBlogPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        dbUtils = DbUtils.getInstance();
    }

    @Override
    public boolean createAndVerifyLiveBlog(String headline, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        boolean isStoryCreated;

        storyIdNumber = createLiveBlog(headline, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        searchStoryByID(storyIdNumber);
        isStoryCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        return isStoryCreated;
    }

    private String createLiveBlog(String headline, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        inputSection(section);
        String id = commonFunctions.createStory(headline, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);

       /* ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline+commonFunctions.generateRandomNum()+"aw");
        inputSummary(summary+commonFunctions.generateRandomNum()+"aw");
        inputParagraph(paragraph);
        inputPost(postTitle, postBody);

        inputSubSection(subsection);
        inputByLine(byline);
        inputKeyWords(keyword);
        inputLocation(location);
        saveLiveBlogAndVerify();
        setStoryId();
        */

        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        return id;
    }

    private void saveLiveBlogAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        commonFunctions.isElementDisplayedWithoutTryCatch(toastSaveButton, 40, "Toast message on saved status");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
    }

    private void inputLocation(String location) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 3, "location box")) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
        }
    }

    private void inputKeyWords(String keyword) {
        commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 10, "location box");
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
    }

    private void inputSubSection(String subsection) {
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 20, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
    }

    private void inputByLine(String byline) {
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
    }

    private void inputPost(String postTitle, String postBody) {
        commonFunctions.scrollUsingAction(addPostBodyText, "Post Body");
        commonFunctions.isElementDisplayedAndPresent(addPostBodyText, 10, "wait for Body to be displayed");
        commonFunctions.clickElement(addPostBodyText, 10, "Body Text");
        commonFunctions.sendKeys(addPostTitleText, postTitle, 15, "post title box");
        commonFunctions.scrollUsingAction(addPostBodyText, "Body Text");
        commonFunctions.sendKeys(addPostBodyText, postBody, 15, "post body box");
        commonFunctions.scrollUsingAction(buttonAddPost, "Add Button");
        commonFunctions.clickElement(buttonAddPost, 15, "button add post");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
    }

    private void inputParagraph(String paragraph) {
        commonFunctions.isElementDisplayedAndPresent(addParagraphText, 20, "wait for intro para to be displayed");
        commonFunctions.sendKey(addParagraphText, paragraph);
    }

    private void inputSummary(String summary) {
        commonFunctions.sendKeys(addSummaryText, summary, 25, "summary box");
    }

    private void inputHeadline(String headline) {
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        commonFunctions.sendKeyWithActions(enterHeadlineText, headline);

    }

    private void selectLiveBlog() {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectStory, 25, "liveblog story button");
    }

    private void searchStoryByIDAndSelect(String id) {
        searchStoryByID(id);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 20, "Single record");
        commonFunctions.isElementDisplayedAndPresent(selectedStory, 20, "dashboard item");
        commonFunctions.waitForElementIgnoringStaleElement(selectedStory, 20, "gallery list item");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 25, "gallery list item");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
    }

    private void searchStoryByID(String id) {
        commonFunctions.sendKeys(searchAllStoriesText, "id:" + id, 10, "search box");
        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 15);
        commonFunctions.isElementDisplayedAndPresent(showingResult, 20, "Wait for Filter result");
        commonFunctions.clickElementIgnoringStaleElement(exactAllStoriesButton, 15, "exact icon button");
    }

    @Override
    public boolean editLiveBlogAndVerify(String editHeadline) {
        boolean isGalleryEdited, isDisplayed;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.sendKeys(enterHeadlineText, editHeadline, 50, "headline edit name");
        fileStoryAndFinishEditing();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isGalleryEdited = commonFunctions.checkElementText(storyStatus, "EDITED", 10, "Correct text is");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "gallery list item");
        isDisplayed = commonFunctions.getElementTextAndCheck(enterHeadlineText, editHeadline, 50, "edited headline name");
        return isGalleryEdited && isDisplayed;
    }

    private void fileStoryAndFinishEditing() {
        commonFunctions.clickElement(buttonFileStoryForEdit, 10, "File Button");
        commonFunctions.isElementDisplayedAndPresent(buttonFinishedEditing, 20, "click Finish Editing button");
        commonFunctions.clickElementWithJS(buttonFinishedEditing, 25, "Finished Editing button");
    }

    @Override
    public boolean publishStoryAndVerify() {
        boolean isPublished;
        searchStoryByIDAndSelect(storyIdNumber);
        publishStory();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(storyStatus, 20, "Story Status");
        isPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isPublished;
    }

    private void publishStory() {
        boolean isPublishSuccessfully;
        boolean isReadabilityPopup;
        commonFunctions.isElementDisplayedAndPresent(buttonPublish, 20, "wait for Publish button to be displayed");
        commonFunctions.isElementDisplayedAndPresent(ellipsis, 10, "three dot button");
        commonFunctions.clickElementWithJS(buttonPublish, 30, "publish story");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
        if (commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 30)) {
            Utils.logStepInfo("Success Message is displaying");
        } else {
            if (commonFunctions.isElementPresentWithTryCatch(buttonYesForHtNewPopup, 20)) {
                commonFunctions.clickElement(buttonYesForHtNewPopup.get(0), 10, "Yes Button");
            }
        }
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
        isPublishSuccessfully = commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 20, "Publish toaster");
        if (!isPublishSuccessfully) {
            isReadabilityPopup = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopup) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 20, "Yes button on popup");
                commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 15, "Publish toaster");
            }

        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
    }

    @Override
    public boolean purgeStoryAndVerify() {
        boolean isStoryPurged;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonPurgeStory, 15, "purge story button");
        isStoryPurged = commonFunctions.checkElementText(toastPurgeStory, "Purge request accepted", 30, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryPurged;
    }

    @Override
    public boolean verifyKillStory() {
        boolean isStoryKilled;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonKillStory, 15, "kill story button ");
        commonFunctions.clickElement(submitUrlForKillStory, 20, "submit url button");
        isStoryKilled = commonFunctions.checkElementText(toastKillStory, "Story Killed", 30, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryKilled;
    }

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
        if (data.equals("automationtesting" + urlIndex)) {
            isStoryUrlChanged = isStoryUrlChanged && true;
        } else {
            isStoryUrlChanged = false;
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryUrlChanged;
    }

    @Override
    public boolean softPublish() {
        if (globalVars.isProdRun()) {
            Select dropDown = new Select(dropDownRecordListInPagination);
            dropDown.selectByVisibleText("200");
            dashboardPage.openPublishedAndUnlockedStory("Live Blog");
        } else {
            searchStoryByIDAndSelect(storyIdNumber);
        }
        return softPublishStoryLiveBlogAndVerify();
    }

    @Override
    public boolean softPublish(String newHeadline) {
        if (globalVars.isProdRun()) {
            Select dropDown = new Select(dropDownRecordListInPagination);
            dropDown.selectByVisibleText("200");
            dashboardPage.openPublishedAndUnlockedStory("Live Blog");
        } else {
            searchStoryByIDAndSelect(storyIdNumber);
            commonFunctions.isElementDisplayedAndPresent(publishedDate, 30, "wait for time to be displayed");
            timeOnPublishedStory = getPublishedDateFromStoryParser();
        }
        return softPublishStoryLiveBlogAndVerify(newHeadline);
    }

    private boolean softPublishStoryLiveBlogAndVerify() {
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
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isSoftPublished;
    }

    private boolean softPublishStoryLiveBlogAndVerify(String newHeadline) {
        boolean isSoftPublished;
        boolean isReadabilityPopupAvailable;
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "wait for headline to be displayed");
        commonFunctions.sendKeys(enterHeadlineText, newHeadline, 30, "Enter new Headline");
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
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isSoftPublished;
    }

    @Override
    public boolean schedulePublishAndVerify() {
        boolean isGalleryScheduled;
        searchStoryByIDAndSelect(storyIdNumber);
        schedulePublish();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isGalleryScheduled = commonFunctions.checkElementText(storyStatus, "SCHEDULED", 10, "Correct text is");
        return isGalleryScheduled;
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
            addMinValue = Integer.parseInt(currentMinute[1]) + 1;
        } else {
            currentHour[0] = currentHour[0] + 1;
            addMinValue = Integer.parseInt("02");
        }
        commonFunctions.selectOptionFromDropDown(selectHour, 10, currentHour[0], "Hour value");
        commonFunctions.selectOptionFromDropDown(selectMinute, 10, String.valueOf(addMinValue), "Minute value");
        commonFunctions.clickElement(buttonApplyScheduleToPublish, 10, "apply button");
        commonFunctions.isElementPresentWithTryCatch(ToastScheduleToBePublished, 20);
        commonFunctions.checkElementText(ToastScheduleToBePublished, "End time of liveblog changed successfully", 20, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 10, "Correct text is");
    }

    @Override
    public boolean uploadLiveBlogImage() {
        boolean isStorySavedStatus;
        searchStoryByIDAndSelect(storyIdNumber);
        isStorySavedStatus = addImageInLiveBlog();
        isStorySavedStatus &= dashboardPage.checkImageAfterUploadOnStoryPage();
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStorySavedStatus;
    }

    private boolean addImageInLiveBlog() {
        boolean isShowing;
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.isElementDisplayedAndPresent(iconForImageUpload, 20, "wait for page load");
        commonFunctions.clickElement(iconForImageUpload, 25, "image icon");
        commonFunctions.clickElement(imagePicFromLib, 25, "image library button");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "image listview icon button");
        commonFunctions.hardWait(30000);
        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab, 20, "images loading");
        for (int i = 0; i <= listOfImagesInListTab.size() - 1; i++) {
            if (listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws")) {
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i), 20, "Click on Image having src tab");
                break;
            }
        }
        if (commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 7, "popup confirm image size")) {
            commonFunctions.clickElements(popupConfirmImageSize, 20, "popup confirm button");
        }
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 30);
        commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 10, "Correct text is");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(editImage, 10, "edit");
        //commonFunctions.sendKeys(editImage, "test", 10, "edit");
        commonFunctions.waitForElementBeDisplayAndClick(buttonCropingDone, 25, "crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        isShowing = dashboardPage.changeFirstImageCaptionName("Testing Caption Name");
        commonFunctions.clickElement(saveButton, 10, "save story button");
        return isShowing;
    }

    @Override
    public boolean verifyEditStoryContent(String storyId) {
        boolean isElementTextEdited;
        commonFunctions.sendKeys(searchAllStoriesText, "id:" + storyId, 10, "search box");
        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 10);
        commonFunctions.waitForElementBeDisplayAndClick(selectedStory, 15, "selected story");
        commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "image edit icon button");
        commonFunctions.scrollPageWithJS(addTitleForImage, 30);
        commonFunctions.sendKeys(addTitleForImage, "Test tilte", 30, "title textbox");

        commonFunctions.sendKeys(addNameForImage, "Test name", 30, "name textbox");
        commonFunctions.scrollPageWithJS(divAreaForScrollView, 15);
        commonFunctions.clickElementWithJS(captionSubmitButton, 35, "submit caption button");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isElementTextEdited = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        if (isElementTextEdited) {
            commonFunctions.clickElement(appLogo, 20);
            return isElementTextEdited = true;
        }
        return isElementTextEdited;
    }

//    @Override
//    public boolean verifyImageCropping(String storyId) {
//        boolean isStorySavedStatus = false;
//        commonFunctions.sendKeys(searchAllStoriesText, "id:" + storyId, 10, "search box");
//        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
//        commonFunctions.waitForElementBeDisplayAndClick(selectedStory, 30, "selected story");
//        commonFunctions.clickElement(buttonCropIcon, 15, "crop icon button");
//        commonFunctions.moveSlider(imageCropRatio, 15, "right side");
//        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 10);
//        commonFunctions.clickElementWithJS(buttonCropingDone, 25, "submit crop button");
//        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        isStorySavedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
//        if (isStorySavedStatus) {
//            commonFunctions.clickElement(appLogo, 20);
//            return isStorySavedStatus = true;
//        }
//        return isStorySavedStatus;
//    }

    public boolean verifyUploadImage() {
        boolean isStorySavedStatus;
        boolean isConfirmImageSize;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(iconForImageUpload, 25, "image icon");
        commonFunctions.clickElement(imagePicFromLib, 25, "image library button");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "image listview icon button");
        commonFunctions.hardWait(30000);
        //commonFunctions.clickElementWithJS(firstImage, 40, "image records of result list item");
        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab, 20, "wait for images to be loaded");
        for (int i = 0; i <= listOfImagesInListTab.size() - 1; i++) {
            if (listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws")) {
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i), 20, "Click on Image having src tab");
                break;
            }
        }
       /* isConfirmImageSize = commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 7, "pop confirm image size");
        if (isConfirmImageSize) {
            commonFunctions.clickElements(popupConfirmImageSize, 20, "popup confirm button");
        }*/
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 30);
        if(commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 10, "Correct text is")) {
            commonFunctions.clickElementIfDisplayed(popupConfirmImageSize.get(0), 5, "Correct text is");
        }
        commonFunctions.isElementDisplayedAndPresent(buttonCropingDone, 25, "crop button");
        commonFunctions.clickElement(buttonCropingDone, 25, "crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        isStorySavedStatus = dashboardPage.changeFirstImageCaptionName("Testing Caption Name");
        isStorySavedStatus &= dashboardPage.checkImageAfterUploadOnStoryPage();
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

    private void saveLiveBlogStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        List<WebElement> elements = new ArrayList<>();
        elements.add(toastSaveButton);
        commonFunctions.isElementDisplayed(elements, 10, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
    }

    @Override
    public boolean deleteLiveBlogContent() {
        boolean isElementTextDeleted;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonDeleteSummary, 15, "delete summary ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        saveLiveBlogStoryAndVerify();
        commonFunctions.refreshPage();
        isElementTextDeleted = commonFunctions.getElementTextAndCheck(addSummaryText, "", 20, "Summary text deletion");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 10);
        return isElementTextDeleted;
    }

    @Override
    public boolean discardLiveBlogAndVerify() {
        boolean isDiscardStory;
        searchStoryByIDAndSelect(storyIdNumber);
        discardStory();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(textNoData, 30, "Correct text is");
        isDiscardStory = commonFunctions.checkElementText(textNoData, "No Data", 30, "Correct text is");
        dashboardPage.clearSearch();
        return isDiscardStory;
    }

    private void discardStory() {
        commonFunctions.clickElement(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardStory, 15, "discard story button");
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
        if (!(domain.equals("Tech") || domain.equals("Bangla") || domain.equals("Auto") || domain.equals("Smart 24") || domain.equals("Mint Lounge"))) {
            commonFunctions.sendKeys(newsletterHeadline, newsletter, 10, "landing page headline");
        }
        isCustomHeadingUpdated = commonFunctions.clickElement(saveButtonHeadline, 10, "save button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        return isCustomHeadingUpdated;
    }

    @Override
    public boolean urlHeadlineForLanguages(String englishHeadline) {
        boolean isDisplayed, isPresent;
        //commonFunctions.waitAndClickForElementIgnoringStaleElement(storyStatus, 15, "live blog story list item");
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonPublish, 30, "publish video");
        commonFunctions.isElementDisplayedWithoutTryCatch(urlHeadlineToasterMassage, 30, "url Headline Toaster Massage");
        commonFunctions.clickElement(buttonAddCoustomHeadline, 15, "custom headline icon button");
        isDisplayed = commonFunctions.isElementDisplayed(labelDataValidation, 10, "Correct Text is");
        commonFunctions.sendKeys(textBoxCoustomHeadline, englishHeadline, 25, "url headline box");
        if (labelDataValidation.size() == 0) {
            isPresent = true;
            Utils.logStepInfo(true, "URL english headline text not present");
        } else {
            isPresent = false;
            Utils.logStepInfo(false, "URL english headline text present");
        }
        commonFunctions.clickElementWithJS(buttonCancelCoustomHeadline, 15, "cancel coustom headline button ");
        commonFunctions.clickElement(appLogo, 10);
        return isDisplayed && isPresent;
    }

    @Override
    public boolean mouseHoverOnLeftPannelAndVerifyElementsAndUser(String expectedUserName) {
        boolean isLeftPanelMouseHover = true;
        commonFunctions.clickElementWithActions(hoverOnLeftPanel, 10, "left panel area");
        for (WebElement traverseElement : leftPanelMenuContent) {
            String elementName = commonFunctions.getElementText(traverseElement, 10);
            if (commonFunctions.isElementEnabledWithCatch(traverseElement, 20, elementName)) {
                Utils.logStepInfo(true, elementName + " is enabled");
            } else {
                isLeftPanelMouseHover = false;
                Utils.logStepInfo(false, elementName + " is disabled FAILURE");
            }
        }
        commonFunctions.clickElementWithActions(labelUserNameAfterLogin, 55, "user name label");
        isLeftPanelMouseHover = isLeftPanelMouseHover && commonFunctions.checkElementText(userName, expectedUserName, 15, "Correct text is");
        return isLeftPanelMouseHover;
    }

    public void setStoryId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
    }

    public Date getPublishedDateFromStoryParser() {

        String publishDate = publishedDate.getText();
        Date date = commonFunctions.getPublishedDateTimeForLiveBlog(publishDate);
        return date;
    }

    @Override
    public boolean checkChangeUrl(String newUrlHeadline) {
        boolean isStoryUrlChanged;
        int urlIndex;
        Random randomNo = new Random();
        urlIndex = randomNo.nextInt(1000);
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
        commonFunctions.sendKeys(addUrlForHeadline, newUrlHeadline, 20, "url box");
        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
        isStoryUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
        String url = commonFunctions.getElementText(storyUrl, 10);
        String[] changedUrl = url.split("-");
        String[] value = changedUrl[changedUrl.length - 2].split("/");
        String data = value[value.length - 1];
        if (data.equals(newUrlHeadline)) {
            isStoryUrlChanged = isStoryUrlChanged && true;
        } else {
            isStoryUrlChanged = false;
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryUrlChanged;
    }

    private void postImageUpload() {
        commonFunctions.scrollPageWithJS(imagePicFromLib, 20);
        commonFunctions.clickElement(imagePicFromLib, 25, "image library button");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "image listview icon button");
        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab, 20, "images loading");
        for (int i = 0; i <= listOfImagesInListTab.size() - 1; i++) {
            if (listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws")) {
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i), 20, "Click on Image having src tab");
                break;
            }
        }
        changesAreSaved();
    }

    private void inputEmbeddedURLText(String embedUrl) {
        commonFunctions.clickElementWithJS(enterEmbedUrlText, 25, "submit url button");
        commonFunctions.sendKeys(enterEmbedUrlText, embedUrl, 25, "embed url box");
        commonFunctions.clickElementWithJS(buttonSubmitUrl, 25, "submit url button");
        changesAreSaved();
    }

    private void changesAreSaved() {
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 5, "wait for saving changes ");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 30, "wait for all changed are saved");
    }

    private void inputPostTitlePostBodyAndPublishPost(String postTitle, String postBody, String urlHeadline, String domain) {
        commonFunctions.scrollPageWithJS(ellipsis, 10);
        dashboardPage.changeUrl(urlHeadline, domain);
        commonFunctions.isElementDisplayedAndPresent(addPostTitleText, 20, "wait for title displayed");
        commonFunctions.isElementDisplayedAndPresent(addPostBodyText, 20, "wait for Body to be displayed");
        commonFunctions.sendKeys(addPostTitleText, postTitle, 25, "post title box");
        commonFunctions.sendKeys(addPostBodyText, postBody, 25, "post body box");
        commonFunctions.clickElement(buttonPublishPost, 25, "button Publish post");
    }

    @Override
    public boolean addingMultipleElementsInSinglePostAndPublishPost(String headline, String summary, String paragraph, String section, String subsection, String byline, String keyword, String location, String postTitle, String postBody, String urlHeadline, String domain, String firstCaption, String secondCaption) {
        boolean isShowing;
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputKeyWords(keyword);
        inputLocation(location);
        commonFunctions.clickElementWithJS(postImageIcon, 20, "post Image Icon");
        postImageUpload();
        commonFunctions.clickElementWithJS(postImageIcon, 20, "post Image Icon");
        postImageUpload();
        dashboardPage.changeFirstImageCaptionName(firstCaption);
        dashboardPage.changeSecondImageCaptionName(secondCaption);
        inputPostTitlePostBodyAndPublishPost(postTitle, postBody, urlHeadline, domain);
        isShowing = dashboardPage.checkImageAfterUploadOnStoryPage();
        return isShowing;
    }

    @Override
    public boolean addingMultipleElementsInSinglePost(String postTitle, String postBody) {
        boolean isShowing;
        commonFunctions.clickElementWithJS(secondPostImageIcon, 20, "post Image Icon");
        postImageUpload();
        commonFunctions.clickElementWithJS(secondPostImageIcon, 20, "post Image Icon");
        postImageUpload();
        inputPost(postTitle, postBody);
        changesAreSaved();
        isShowing = dashboardPage.checkImageAfterUploadOnStoryPage();
        return isShowing;
    }

    @Override
    public boolean addingCombinationOfDifferentElementInSinglePost(String embedUrl, String src, String postTitle, String postBody) {
        boolean isShowing;
        commonFunctions.clickElementWithJS(secondPostImageIcon, 20, "second post Image Icon");
        postImageUpload();
        isShowing = dashboardPage.checkImageAfterUploadOnStoryPage();
        commonFunctions.clickElementWithJS(secondPostEmbedIcon, 20, "embed icon");
        inputEmbeddedURLText(embedUrl);
        isShowing &= commonFunctions.getAttributeValue(embedSrc, 20, "src").equals(src);
        inputPost(postTitle, postBody);
        return isShowing;
    }

    public boolean addingMultipleEmbedInSinglePost(String embedUrl, String src, String postTitle, String postBody) {
        boolean isShowing;
        commonFunctions.clickElementWithJS(secondPostEmbedIcon, 20, "embed icon");
        inputEmbeddedURLText(embedUrl);
        isShowing = commonFunctions.getAttributeValue(embedSrc, 20, "src").equals(src);
        inputPost(postTitle, postBody);
        return isShowing;
    }

    @Override
    public boolean pinMultiplePostAndAllPost() {
        boolean isShowing;
        commonFunctions.isElementDisplayedAndPresent(secondButtonPinPost, 20, "second Button Pin Post");
        commonFunctions.clickElementWithJS(secondButtonPinPost, 20, "second Button Pin Post");
        changesAreSaved();
        isShowing = commonFunctions.isElementDisplayedIgnoringStaleElementWithCatch(firstPositionPinnedElement, 20, "first Position Pinned Element");
        isShowing &= pinThirdElementsCheckPosition();
        isShowing &= pinThirdElementsCheckPosition();
        return isShowing;
    }

    private boolean pinThirdElementsCheckPosition() {
        boolean isShowing;
        commonFunctions.clickElementWithJS(thirdButtonPinPost, 20, "third Button Pin Post");
        changesAreSaved();
        isShowing = commonFunctions.isElementDisplayedIgnoringStaleElementWithCatch(firstPositionPinnedElement, 20, "first Position Pinned Element");
        return isShowing;
    }

    @Override
    public boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnLiveBlogTheSameDataIsPresentInMetatitleOrNot() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectLiveBlog();
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
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        String inputHeadingText = "Test Meta Summary " + commonFunctions.generateRandomNum();
        commonFunctions.inputSummary(inputHeadingText, addSummaryText);
        commonFunctions.scrollToElement(metaDescText, "Meta Desc Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaDescText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Description");
    }

    @Override
    public boolean checkAfterPublishingLiveBlogStoryDataGoesToMasterDb(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        String id = createLiveBlogStory(headLine, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        selectLeadImage();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 5)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.isElementPresent(popupPublishButton, 20);
        return dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", id, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline);
    }

    private void selectLeadImage() {
        commonFunctions.moveToElementWithActions(leadMediaToggle, 10, "Lead Media");
        commonFunctions.clickElement(leadMediaToggle, 10, "lead media");
        commonFunctions.clickElement(leadMediaLib, 10, "lead media from Lib");
        commonFunctions.dummyWait(10);
        commonFunctions.moveToElementWithActions(recentUseImage, 10, "Images");
        commonFunctions.clickElement(useImageButton, 10, "Use Image Button");
        commonFunctions.dummyWait(5);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 10)) {
            commonFunctions.clickElementWithActions(buttonYes, 5, "yes button");
        }
        commonFunctions.clickElement(doneButton, 10, "Done Button for lead Image");
        if (commonFunctions.isElementDisplayedWithExceptionHandling(croppingDoneError, 10, "error in cropping")) {
            commonFunctions.dummyWait(5);
            commonFunctions.clickElementIfDisplayed(buttonCropingDone, 20, "done Button");
        }
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(addCaptionSaveButton, 20);
        commonFunctions.moveToElementWithActions(addCaptionSaveButton, 10, "Done Button");
        commonFunctions.clickElement(addCaptionSaveButton, 10, "Done Button");

    }

    public boolean addImageCaption(String caption) {
        commonFunctions.isElementDisplayedAndPresent(buttonImageEditIcon, 20, "three Dots First Image");
        commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "three Dots First Image");
        commonFunctions.isElementDisplayedAndPresent(firstImageCaption, 10, "image caption");
        commonFunctions.clickElementIfDisplayed(firstImageCaption, 10, "click on image caption field");
        if (firstImageCaption.getText().length() > 0) {
            firstImageCaption.clear();
        }
        commonFunctions.clickElementIfDisplayed(firstImageCaption);
        commonFunctions.sendKeyWithActions(firstImageCaption, caption);
        commonFunctions.scrollPageWithJS(editDoneButton, 5);
        commonFunctions.hardWait(2000);
        commonFunctions.clickElementWithJS(editDoneButton, 10, "first image done button");
        boolean isShowing = commonFunctions.checkElementText(firstImageCaptionNameData, caption, 15, "first image Caption name");
        return isShowing;
    }

    private String createLiveBlogStory(String headline, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        inputSection(section);
        String id = commonFunctions.createStoryForLiveBlog(headline, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        return id;
    }

    @Override
    public boolean checkLiveBlogPostImageCroppingOption(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElementWithJS(postImageIcon, 20, "post Image Icon");
        postImageUpload();
        commonFunctions.moveToElementWithActions(threeDotForPost, 10, "Three Dots");
        commonFunctions.clickElement(threeDotForPost, 10, "Three Dots");
        return commonFunctions.checkElementTextWithEqualIgnoreCase(commonFunctions.getElementText(cropOption).trim(), "Crop", "Crop Option");
    }

    @Override
    public boolean checkCreateLiveBlogStoryWithLiveHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createLiveBlogStory(headLine, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        selectLeadImage();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 5)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        return commonFunctions.isElementPresent(popupPublishButton, 20);
    }

    @Override
    public boolean checkLoadMoreButtonIsAppearingAfterFivePostsInliveBlog(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        addNumberOfPosts(5);
        boolean loadMoreNotDisplayStatus = commonFunctions.isElementNotDisplayed(loadMoreBtn, 10, "Load More Button");
        String title = "Automation Testing " + commonFunctions.generateRandomNum() + "aw";
        String body = "Automation Testing " + commonFunctions.generateRandomNum() + "aw";
        titleList.add(title);
        inputPost(title, body);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUsingAction(loadMoreBtn, "Load More Btn");
        boolean loadMoreDisplayStatus = commonFunctions.isElementPresentWithTryCatch(loadMoreBtn, 10);
        boolean latestPostStatus = verifyAddedPosts(1);
        System.out.println("loadMoreNotDisplayStatus:- " + loadMoreNotDisplayStatus);
        System.out.println("loadMoreDisplayStatus:- " + loadMoreDisplayStatus);
        System.out.println("latestPostStatus:- " + latestPostStatus);
        return loadMoreNotDisplayStatus && loadMoreDisplayStatus && latestPostStatus;
    }

    @Override
    public boolean checkLoadMoreButtonFunctionality(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        addNumberOfPosts(5);
        boolean loadMoreNotDisplayStatus = commonFunctions.isElementNotDisplayed(loadMoreBtn, 10, "Load More Button");
        String title = "Automation Testing " + commonFunctions.generateRandomNum() + "aw";
        String body = "Automation Testing " + commonFunctions.generateRandomNum() + "aw";
        titleList.add(title);
        inputPost(title, body);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUsingAction(loadMoreBtn, "Load More Btn");
        boolean loadMoreDisplayStatus = commonFunctions.isElementPresentWithTryCatch(loadMoreBtn, 10);
        commonFunctions.clickElement(loadMoreBtn, 10, "Load More Btn");
        commonFunctions.dummyWait(5);
        boolean latestPostStatus = verifyAddedPosts(0);
        return loadMoreNotDisplayStatus && loadMoreDisplayStatus && latestPostStatus;
    }

    public void addNumberOfPosts(int num) {
        for (int i = 0; i < num; i++) {
            commonFunctions.dummyWait(3);
            String title = "Automation Testing " + commonFunctions.generateRandomNum() + "aw";
            String body = "Automation Testing " + commonFunctions.generateRandomNum() + "aw";
            titleList.add(title);
            inputPost(title, body);
            commonFunctions.dummyWait(3);
        }
    }

    public boolean verifyAddedPosts(int startingPoint) {
        commonFunctions.dummyWait(10);
        boolean flag = false;
        List<String> list = new ArrayList<String>();
        int size = postList.size();
        for (int i = 5; i < size; i++) {
            commonFunctions.scrollUsingAction(postList.get(i), "Post");
            list.add(postList.get(i).getText().trim());
        }

        for (int i = startingPoint; i < titleList.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                System.out.println("Title Text: " + titleList.get(i));
                System.out.println("Title Tex From UI: " + list.get(j));
                if (titleList.get(i).equalsIgnoreCase(list.get(j))) {
                    count = count + 1;
                    break;
                }
            }

            if (count > 0) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean checkElementIsAddedForCricketScoreboard(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createLiveBlogStory(headLine, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        return selectCricketScroboardAndVerify();
    }

    public boolean selectCricketScroboardAndVerify() {
        commonFunctions.isElementPresentWithTryCatch(scroboardIcon, 10);
        commonFunctions.clickElement(scroboardIcon, 10, "Scroboard Icon");
        commonFunctions.isElementPresentWithTryCatch(scroboardSearchText, 10);
        commonFunctions.clickElement(scroboardSearchText, 10, "Scroboard Search Text");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(scroboardSearchResult, 10);
        commonFunctions.clickElement(scroboardSearchResult, 10, "Scroboard Search Result");
        commonFunctions.dummyWait(5);
        commonFunctions.selectOptionFromDropDownWithIndex(resultMatchSelect, 10, 1, "Select Match");
        commonFunctions.isElementPresentWithTryCatch(matchDoneButton, 10);
        commonFunctions.clickElement(matchDoneButton, 10, "Done Button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(crecateCardPara, 10);
    }

    @Override
    public boolean checkAddMultipleIntroEmbed(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        createLiveBlogStory(headLine, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        boolean cricketBoardStatus = selectCricketScroboardAndVerify();
        boolean introTableStatus = addIntroTableAndVerify();
        boolean introVideoStatus = addIntroVideoAndVerify();
        return cricketBoardStatus && introTableStatus && introVideoStatus;

    }

    public boolean addIntroTableAndVerify() {
        commonFunctions.isElementPresentWithTryCatch(introTable, 10);
        commonFunctions.clickElement(introTable, 10, "Intro Table");
        commonFunctions.isElementPresentWithTryCatch(introTableDroDown, 10);
        commonFunctions.clickElement(introTableDroDown, 10, "Intro Table Drop Down");
        commonFunctions.isElementPresentWithTryCatch(introTableDroDownValue, 10);
        commonFunctions.clickElement(introTableDroDownValue, 10, "Intro Table Drop Down Value");
        commonFunctions.isElementPresentWithTryCatch(matchDoneButton, 10);
        commonFunctions.clickElement(matchDoneButton, 10, "Done Button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(introAddedTable, 10);
    }

    public boolean addIntroVideoAndVerify() {
        commonFunctions.isElementPresentWithTryCatch(introVideoIcon, 10);
        commonFunctions.clickElement(introVideoIcon, 10, "Intro Video Icon");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(introVideosList, 10);
        commonFunctions.mouseHoverOnElement(introVideosList, 10, "Intro Videos List");
        commonFunctions.isElementPresentWithTryCatch(introVideosUseVideoBtn, 10);
        commonFunctions.clickElement(introVideosUseVideoBtn, 10, "Intro Video Icon");
        commonFunctions.hardWait(5000);
        return commonFunctions.isElementPresentWithTryCatch(introAddedVideo, 10);
    }

    @Override
    public boolean checkEditIntroEmbed(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createLiveBlogStory(headLine, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        boolean introTableStatus = addIntroTableAndVerify();
        boolean introTableEditStatus = editIntroTableAndVerify();
        return introTableStatus && introTableEditStatus;
    }

    public boolean editIntroTableAndVerify() {
        commonFunctions.isElementPresentWithTryCatch(introTableEditIcon, 10);
        commonFunctions.clickElement(introTableEditIcon, 10, "Intro Table");
        commonFunctions.isElementPresentWithTryCatch(introTableEditDropDown, 10);
        commonFunctions.clickElement(introTableEditDropDown, 10, "Intro Table Drop Down");
        commonFunctions.isElementPresentWithTryCatch(introTableEditDropDownValue, 10);
        commonFunctions.clickElement(introTableEditDropDownValue, 10, "Intro Table Drop Down Value");
        commonFunctions.isElementPresentWithTryCatch(matchDoneButton, 10);
        commonFunctions.clickElement(matchDoneButton, 10, "Done Button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(introAddedTable, 10);
    }

    @Override
    public boolean checkIntroEmbedInDb(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String emText) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createLiveBlogStory(headLine, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        selectLeadImage();
        boolean cricketBoardStatus = selectCricketScroboardAndVerify();
        boolean introTableStatus = addIntroTableAndVerify();
        boolean introVideoStatus = addIntroVideoAndVerify();
        if (commonFunctions.isElementPresentWithTryCatch(introAddedVideo, 10)) {
            commonFunctions.scrollPageWithJS(introAddedVideo, 10);
        }
        boolean podcaseStatus = addIntroPodcastAndVerify();
        if (commonFunctions.isElementPresentWithTryCatch(introAddedPodcast, 10)) {
            commonFunctions.scrollPageWithJS(introAddedPodcast, 10);
        }
        boolean embededStatus = addEmbedAndVerify(emText);
        if (commonFunctions.isElementPresentWithTryCatch(introAddedPodcast, 10)) {
            commonFunctions.scrollPageWithJS(introAddedPodcast, 10);
        }
        boolean introImageStatus = addIntroImageAndVerify();


        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        boolean publisStatus = commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);

        // Note :- Implementation for DB check is pending.

        return cricketBoardStatus && introTableStatus && introVideoStatus && embededStatus && introImageStatus && publisStatus && podcaseStatus;
    }

    public boolean addEmbedAndVerify(String emText) {
        commonFunctions.isElementPresentWithTryCatch(buttonInsertEmbed, 10);
        commonFunctions.clickElement(buttonInsertEmbed, 10, "Button Insert Embed");
        commonFunctions.isElementPresentWithTryCatch(embedText, 10);
        commonFunctions.sendKeys(embedText, emText, 10, "Embed Text");
        commonFunctions.isElementPresentWithTryCatch(matchDoneButton, 10);
        commonFunctions.clickElement(matchDoneButton, 10, "Done Button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(addedEmbed, 10);
    }

    public boolean addIntroImageAndVerify() {
        commonFunctions.isElementPresentWithTryCatch(buttonInsertImage, 10);
        commonFunctions.clickElement(buttonInsertImage, 10, "Button Insert Image");
        commonFunctions.isElementPresentWithTryCatch(imageFromLib, 10);
        commonFunctions.clickElement(imageFromLib, 10, "Image From Lib");
        commonFunctions.isElementPresentWithTryCatch(introImageList, 10);
        commonFunctions.mouseHoverOnElement(introImageList, 10, "Intro Image List");
        commonFunctions.isElementPresentWithTryCatch(introImageUseVideoBtn, 10);
        commonFunctions.clickElementWithActions(introImageUseVideoBtn, 10, "Intro Image Use Button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(introIAddedImage, 10);
    }

    public boolean addIntroPodcastAndVerify() {
        commonFunctions.isElementPresentWithTryCatch(introPodcastIcon, 10);
        commonFunctions.clickElementWithJS(introPodcastIcon, 10, "Podcast Icon");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(introPodcastList, 10);
        commonFunctions.mouseHoverOnElement(introPodcastList, 10, "Podcast List");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(introPodcastUseVideoBtn, 10);
        commonFunctions.clickElementWithActions(introPodcastUseVideoBtn);
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(introAddedPodcast, 10);
    }

    @Override
    public boolean checkLiveBlogOptionIsVisible(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        return commonFunctions.isElementPresentWithTryCatch(selectStory, 10);
    }

    @Override
    public boolean checkPublishStoryWithoutEnteringHeadline(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String validationMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        inputSection(section);
        commonFunctions.createStoryForLiveBlogWithoutHeadline(summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead media caption");
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(2000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        return commonFunctions.checkElementText(velidationMessage, validationMsg.trim(), 10, "Validation Message");
    }

    @Override
    public boolean checkPublishStoryWithoutSelectingLeadMedia(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String validationMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createLiveBlogStory(headLine, summary, paragraph, postTitle, postBody, byline, section, subsection, keyword, location);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        return commonFunctions.checkElementText(velidationMessage, validationMsg.trim(), 10, "Validation Message");
    }

    @Override
    public boolean checkPublishStoryWithoutSummaryField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String validationMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        commonFunctions.createStoryForLiveBlogWithoutSummary(headLine, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead media caption");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        return commonFunctions.checkElementText(velidationMessage, validationMsg.trim(), 10, "Validation Message");
    }

    @Override
    public boolean checkPublishStoryWithoutSectionField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String validationMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        commonFunctions.createStoryForLiveBlog(headLine, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        return commonFunctions.checkElementText(velidationMessage, validationMsg.trim(), 10, "Validation Message");
    }

    @Override
    public boolean checkPublishStoryWithoutSubSectionField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String validationMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        commonFunctions.createStoryForLiveBlog(headLine, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead media caption");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        return commonFunctions.checkElementText(velidationMessage, validationMsg.trim(), 10, "Validation Message");

    }

    @Override
    public boolean checkPublishStoryWithoutBylineField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String validationMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        commonFunctions.createStoryForLiveBlog(headLine, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead media caption");
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        return commonFunctions.checkElementText(velidationMessage, validationMsg.trim(), 10, "Validation Message");
    }

    @Override
    public boolean checkPublishStoryWithoutPost(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String validationMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        commonFunctions.createStoryForLiveBlogWithoutPost(headLine, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead media caption");
        commonFunctions.dummyWait(5);
        commonFunctions.refreshPage();
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        return commonFunctions.checkElementText(velidationMessage, validationMsg.trim(), 10, "Validation Message");
    }

    public boolean checkPublishLiveBlog(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        commonFunctions.createStoryForLiveBlog(headLine, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead image caption");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        //Need to implement DB part. Ravinder is working on this.

        return commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);
    }

    @Override
    public boolean checkUrlIsGeneratedInStoryInfoSection(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        commonFunctions.createStoryForLiveBlog(headLine, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead media caption");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        //Need to implement DB part. Ravinder is working on this.

        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);
        commonFunctions.hardWait(5000);
        commonFunctions.scrollPageWithJS(storyInfoSection, 10);
        return !commonFunctions.getElementText(storyInfoUrl).isEmpty();
    }

    @Override
    public boolean checkUrlIsGeneratedInStoryInfoSectionIsClickable(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectLiveBlog();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        String idNum = commonFunctions.createStoryForLiveBlog(headLine, summary, paragraph, postTitle,
                postBody, section, subsection, byline,
                keyword, location,
                addPostTitleText, addPostBodyText, buttonAddPost,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        selectLeadImage();
        addImageCaption("lead media caption");
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(1000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 2)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }

        //Need to implement DB part. Ravinder is working on this.

        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);
        commonFunctions.hardWait(5000);
        commonFunctions.scrollPageWithJS(storyInfoSection, 10);
        commonFunctions.clickElementIfDisplayed(generatedUrl,10,"url");
        Set<String> windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
        return windowsList1.size()==3;
    }

    public boolean createAndPublishLiveBlog(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption){
        createLiveBlogStory(headLine, summary, paragraph, title + String.valueOf(commonFunctions.generateRandomNum()), titleBody + String.valueOf(commonFunctions.generateRandomNum()), byline, section, subsection, keyword, location);
        selectLeadImage();
        addImageCaption(leadMediaCaption);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 5)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        boolean result = commonFunctions.isElementPresent(popupPublishButton, 20);
        return result;
    }

    @Override
    public boolean checkIfTheHeadingEndLiveBlogButtonShouldAppearInBackend(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption) {
        boolean result = createAndPublishLiveBlog(property,headLine,summary,paragraph,title,titleBody,byline,section,subsection,keyword,location,leadMediaCaption,postImageCaption);
        if (result) {
            if (commonFunctions.isElementDisplayed(endLiveBlogButton, 10)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfEndLiveBlogButtonIsBeClickableAndShowsCalendar(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption) {
        boolean result = createAndPublishLiveBlog(property,headLine,summary,paragraph,title,titleBody,byline,section,subsection,keyword,location,leadMediaCaption,postImageCaption);
        if (result && commonFunctions.isClickableElementClicked(endLiveBlogButton, 10, "end live blog button")) {
            String calendarText = commonFunctions.getAttributeValue(showCalender, 20, "style").trim();
            return calendarText.contains("display: block");
        }
        ;
        return false;
    }

    @Override
    public boolean checkIfTheLiveUpdateRadioButtonAppearsOnFrontendAlongWithPublishedBlog(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption) {
        boolean result = createAndPublishLiveBlog(property,headLine,summary,paragraph,title,titleBody,byline,section,subsection,keyword,location,leadMediaCaption,postImageCaption);
        if (result) {
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElementViewAndClick(generatedUrl, 10, "url generated");
            Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            commonFunctions.switchToLastWindow(windowsList);
            return commonFunctions.isElementDisplayed(liveUpdatesRadioButton, 10, "live updates radio button");
        }
        return false;
    }

    @Override
    public boolean checkIfUserIsAbleToCreateStoryLiveBlog(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption) {
        boolean result = createAndPublishLiveBlog(property,headLine,summary,paragraph,title,titleBody,byline,section,subsection,keyword,location,leadMediaCaption,postImageCaption);
        if (result) {
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElementViewAndClick(generatedUrl, 10, "url generated");
            Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            if (windowsList.size() == 3) return true;
        }
        return false;
    }

    @Override
    public boolean checkIfEndLiveBlogButtonConvertsIntoChangeEndTimeButtonOnceTimeIsSet(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption) {
        boolean result = createAndPublishLiveBlog(property,headLine,summary,paragraph,title,titleBody,byline,section,subsection,keyword,location,leadMediaCaption,postImageCaption);
        if (result) setLiveBlogEndTime();
        commonFunctions.dummyWait(5);
        return commonFunctions.getElementTextAndCheck(endLiveBlogButton, "change end time", 10, "checking button status");
    }

    @Override
    public boolean checkIfEndLiveBlogButtonConvertIntoTextAfterCertainTimeDurationAfterBlogEnds(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption) {
        boolean result = createAndPublishLiveBlog(property,headLine,summary,paragraph,title,titleBody,byline,section,subsection,keyword,location,leadMediaCaption,postImageCaption);
        if (result) setLiveBlogEndTime();
        commonFunctions.hardWait(5000);
        int breakLoop=0;
        if(commonFunctions.getElementTextAndCheck(endLiveBlogButton, "change end time", 10, "checking button status")){
            while (commonFunctions.isElementDisplayedWithExceptionHandling(endLiveBlogButton,10,"change end time")){
                commonFunctions.hardWait(5000);
                breakLoop++;
                if(breakLoop==25) break;
            }
            String text=commonFunctions.getElementText(blogEndedMessage,10);
            if(text.contains("The BLOG ended")) return true;
        }
        return false;
    }

    @Override
    public boolean checkIfTheLiveUpdateRadioButtonIsAbleToDisappearFromThePostAfterGivenCertainTimeDurationOnFrontend(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption) {
        boolean result = createAndPublishLiveBlog(property,headLine,summary,paragraph,title,titleBody,byline,section,subsection,keyword,location,leadMediaCaption,postImageCaption);
        if (result) setLiveBlogEndTime();
        commonFunctions.hardWait(2000);
        int breakLoop=0;
        if(commonFunctions.getElementTextAndCheck(endLiveBlogButton, "change end time", 10, "checking button status")){
            while (commonFunctions.isElementDisplayedWithExceptionHandling(endLiveBlogButton,10,"change end time")){
                commonFunctions.hardWait(5000);
                breakLoop++;
                if(breakLoop==25) break;
            }
            String text=commonFunctions.getElementText(blogEndedMessage,10);
            if(text.contains("The BLOG ended")){
                commonFunctions.scrollToElementViewAndClick(generatedUrl,10,"generated url");
                Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
                commonFunctions.switchToLastWindow(windowsList);
                while(commonFunctions.isElementDisplayedWithExceptionHandling(liveUpdatesRadioButton,10,"Live updates")){
                    commonFunctions.pageRefresh();
                    commonFunctions.hardWait(5000);
                }
                if(!commonFunctions.isElementDisplayedWithExceptionHandling(liveUpdatesRadioButton,10,"Live updates radio")) return true;
            }
        }
        return false;
    }

    public void setLiveBlogEndTime () {
        commonFunctions.isClickableElementClicked(endLiveBlogButton, 10, "end live blog button");
        String currentHour = "", hourTemp = "", currentMinute = "", minuteTemp = "";
        boolean flag = false;
        currentMinute = commonFunctions.getCurrentDateAndTime().substring(3, 5);
        minuteTemp = selectMinuteDropDown.get(Integer.parseInt(currentMinute)).getText();
        if (Integer.parseInt(minuteTemp) <= 57) commonFunctions.clickElement(selectMinuteDropDown.get(Integer.parseInt(minuteTemp) + 2), 10, "hour selection");
        else {
            commonFunctions.clickElement(selectMinuteDropDown.get((Integer.parseInt(minuteTemp) + 2) % 60), 10, "minute selection");
            flag = true;
        }
        currentHour = commonFunctions.getCurrentDateAndTime().substring(0, 2);
        hourTemp = selectHourDropDown.get(Integer.parseInt(currentHour)).getText();
        if (flag) commonFunctions.clickElement(selectHourDropDown.get(Integer.parseInt(hourTemp) + 1), 10, "hour selection");
        else commonFunctions.clickElement(selectHourDropDown.get(Integer.parseInt(hourTemp)), 10, "hour selection");
        commonFunctions.clickElement(buttonApplyScheduleToPublish, 10);
    }
}
