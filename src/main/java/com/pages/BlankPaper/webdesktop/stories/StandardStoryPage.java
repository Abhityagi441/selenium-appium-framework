package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonLoginPage;
import com.pages.BlankPaper.genericPages.CommonStandardStoryPage;
import com.utils.DbUtils;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;


import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StandardStoryPage extends CommonStandardStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;
    public static String imageSrcValue;
    public static CommonLoginPage loginPage;
    public static DbUtils dbUtils;
    private static LiveBlogPage liveBlogPage;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//div[@class='storytype']//li//button[@class='standard' and text()='Standard']")
    private static WebElement selectStory;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[1]/div")
    private static WebElement enterHeadlineTextBox;


    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//div[@class='contentList']/div[1]//child::ul")
    private static WebElement selectedStoryClick;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[2]/div")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and text()='Save']")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;

    @FindBy(id = "bylineFilter")
    private static WebElement byline;

    @FindBy(xpath = "//span[contains(@class,'exact')]/..")
    private static WebElement exactAllStoriesButton;

    @FindBy(xpath = "//div[contains(@class,'formStory')]//descendant::li[contains(@class,'headline')]//label[contains(text(),'Landing')]")
    private static WebElement storyButton;

    @FindBy(xpath = "//div[@class='contentList']//div[@class='storyListing']//li[@class='headline spImg']//descendant::div[2]")
    private static List<WebElement> searchAllStoriesListItem;

    @FindBy(xpath = "(//div[@class='selected-list']/div)[1]")
    private static WebElement notificationType;

    @FindBy(xpath = "//li[@class='pure-checkbox']/label")
    private static List<WebElement> notificationTypeOptions;

    @FindBy(xpath = "//div[contains(@class,'right')]//div[contains(@class,'storybtn')]//button[@class='purple']")
    private static WebElement buttonFileStoryForEdit;

    @FindBy(xpath = "//div[contains(@class,'right')]//div[contains(@class,'storybtn')]//button[@class='blue']")
    private static WebElement buttonFinishedEditing;

    @FindBy(xpath = "//ul[@id='myTags']//li[@class='tagit-new']//input[contains(@placeholder,'Byline')]")
    private static WebElement inputAddByLineText;

    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static WebElement inputAddSectionText;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "(//input[@id='inputAddSubSectionText'])[2]")
    private static WebElement inputAddSubSectionL2Text;

    @FindBy(xpath = "//input[@placeholder='Enter text to search Topics..']")
    private static WebElement inputAddTopicText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(xpath = "//input[@placeholder='Add Location here..']")
    private static WebElement inputAddLocationText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/p")
    private static WebElement addParagraphText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[contains(@class,'secondary')]//span[@class='threedots']")
    private static WebElement ellipsis;

    @FindBy(xpath = "//li//button[contains(text(),'Move Back')]")
    private static WebElement buttonMoveBack;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::li//button[contains(text(),'Soft')]")
    private static WebElement buttonSoftPublish;

    @FindBy(xpath = "//div[@class='leadMedia']//span[@class='editBtn']/i[@class='icon-pickup']")
    private static WebElement buttonEditForImage;

    @FindBy(xpath = "//div[@id='addCaptionForImage']/div/ckeditor")
    private static WebElement addCaptionForImage;

    //div[@class='leadMedia']//div[@class='editimage']//div[@class='dataField']//ckeditor[contains(@class,'ng-valid ng-touched')]//div/p

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement addTitleForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[3]//child::div[@class='wid50 fl padr20']//descendant::input")
    private static WebElement addNameForImage;

    @FindBy(xpath = "//div[contains(@class,'bdrfill')]//div[@class='editimage']//div[contains(@class,'wid100 right')]//child::button[text()='Done']")
    private static WebElement captionSubmitButton;

    @FindBy(xpath = "//div[@class='editimage']//div[contains(@class,'wid100 right')]")
    private static WebElement divAreaForScrollView;

    @FindBy(xpath = "//div[@class='unlockStory']//following::div[contains(@class,'ptb15')]")
    private static WebElement scrollToDivForCropping;

    @FindBy(xpath = "//span[@class='handle sortpara']")
    private static WebElement buttonDragAndDrop;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Change URL')]")
    private static WebElement buttonChangeUrl;

    @FindBy(xpath = "//button[contains(text(),'Kill Story')]")
    private static WebElement buttonKillStory;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Purge Story')]")
    private static WebElement buttonPurgeStory;

    @FindBy(xpath = "//div//descendant::button[contains(text(),'Discard Story')]")
    private static WebElement buttonDiscardStory;

    @FindBy(xpath = "//*[@class='snotifyToast__body' and contains(text(),'Purge request accepted')]")
    private static WebElement toastPurgeStory;

    @FindBy(xpath = "//button[@class='orange' and contains(text(),'Schedule to Publish')]")
    private static WebElement buttonScheduleToPublish;

    @FindBy(xpath = "//button[@class='orange' and contains(text(),'Schedule to Publish')]")
    private static List<WebElement> buttonScheduleToPublishAvailable;

    @FindBy(xpath = "(//button[contains(text(),'Apply')])[last()]")
    private static WebElement buttonApplyScheduleToPublish;

    @FindBy(xpath = "//span[@class='created' and contains(text(),'SCHEDULED TO BE PUBLISHED')]")
    private static WebElement textScheduleToBePublished;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'End time of liveblog changed successfully')]")
    private static WebElement ToastScheduleToBePublished;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='hourselect']")
    private static WebElement selectHour;

    @FindBy(xpath = "//div[@class='calendar left single']//child::div//descendant::select[@class='minuteselect']")
    private static WebElement selectMinute;

    @FindBy(xpath = "//textarea[@placeholder='Enter URL body here…']")
    private static WebElement addUrlForHeadline;

    @FindBy(xpath = "//textarea[@id='description']")
    private static WebElement notificationDescription;

    @FindBy(xpath = "//div[contains(@class,'fr wid100')]//button[contains(@class,'blue ml10')]")
    private static WebElement buttonSubmitUrlForHeadline;

    @FindBy(xpath = "//textarea[@placeholder='Enter Redirect URL here…']")
    private static WebElement addUrlForKillStory;

    @FindBy(xpath = "//div[contains(@class,'fr wid')]//button[contains(@class,'add blue')]")
    private static WebElement submitUrlForKillStory;

    @FindBy(xpath = "//span[@id='summary1']")
    private static WebElement buttonDeleteSummary;

    @FindBy(xpath = "//div[@class='paragraph ']//span[@class='deleteHeadline']/i")
    private static WebElement buttonDeleteParagraph;

    @FindBy(xpath = "//li[@class='headline fl100']/div[@class='storyaction']//child::span[@class='plusHeadline']/i")
    private static WebElement buttonAddCoustomHeadline;

    @FindBy(xpath = "//*[@id=\"headline3\"]//descendant::div/child::ul/li[1]/div/textarea")
    private static WebElement textBoxCoustomHeadline;

    @FindBy(xpath = "//button[@class='discard blue']")
    private static WebElement buttonCancelCoustomHeadline;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='domainselect']")
    private static WebElement hoverOnLeftPanel;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement labelUserNameAfterLogin;

    @FindBy(xpath = "//div[@class='userName spImg']//span[contains(text(),'Deepesh Saini')]")
    private static WebElement userNameLabel;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(xpath = "//div[@class='storybtnContent']/span[@class='created' and contains(text(),'EDITED')]")
    private static WebElement statusEdited;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> buttonYesForHtNewPopup;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button")
    private static WebElement yesBtn;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Story Killed')]")
    private static WebElement toastKillStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'URL changed successfuly')]")
    private static WebElement toastChangeUrl;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Soft Published successfully')]")
    private static WebElement toastSoftPublish;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//section[@class='mainContainer']//ul[@class='menuContent']//descendant::span")
    private static List<WebElement> leftPanelMenuContent;

    @FindBy(xpath = "//*[text()='Logout']")
    private static WebElement singOutButton;

    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;

    @FindBy(xpath = "//*[@class='ng-pristine ng-valid ng-touched']/child::div[2]/child::div[@class='ck ck-editor__main']/descendant::p")
    private static WebElement headline;

    @FindBy(xpath = "//div[@class='ck ck-editor__main']/div/ul/li")
    private static WebElement summary;

    @FindBy(xpath = "//div[@class='dataField bdrfill']//descendant::ckeditor[contains(@class,'ng')]")
    private static WebElement storyId;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement dropDownRecordListInPagination;

    @FindBy(xpath = "//div[@class='contentList']/div[@class='storyListing']")
    private static List<WebElement> storyContentsListInPagination;

    @FindBy(xpath = "//div[@class='dataField']//descendant::span[contains(@class,'i')]/i[@class='icon-image']")
    private static WebElement iconForImageUpload;

    @FindBy(xpath = "//div[@class='imageAction block']//descendant::div[@class='pickimage']/span[@class='pickimageBtn']")
    private static WebElement imagePicFromLib;

    @FindBy(xpath = "//div[contains(@class,'internaldisplay')]//descendant::li/i[@class='icon-list']")
    private static WebElement imageListViewIcon;

    @FindBy(xpath = "//div[@class='imagecontain']/span[@class='hover']//child::button[@class='blue']")
    private static WebElement buttonUseImage;

    @FindBy(xpath = "//div[@class='contentList']//div[contains(@class,'search')]/ul[1]")
    private static WebElement listImageSearchResult;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> popupConfirmImageSize;

    @FindBy(xpath = "//button[contains(@class,'ml10') and contains(text(),'Done')]")
    private static WebElement buttonCropingDone;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Cropped successfully')]")
    private static WebElement toastCropingDone;

    @FindBy(xpath = "//div[@class='storyaction']//span[2]//child::i[@class='icon-crop']")
    private static WebElement cropIconButton;

    @FindBy(xpath = "//div[@class='story_icons']//following-sibling::li[@class='image_icon']//child::i[@class='icon-image']")
    private static WebElement buttonInsertImage;

    @FindBy(xpath = "//div[@class='story_icons']//following-sibling::li[@class='market_icon']//child::i[@class='icon-market']")
    private static WebElement buttonInsertMarket;

    @FindBy(xpath = "//*[@id=\"myTags\"]//descendant::input[@class='textBox ng-pristine ng-valid ng-touched']")
    private static WebElement inputAddMarketName;

    @FindBy(xpath = "//div/button[@class='add blue ml10 ']")
    private static WebElement buttonSubmitForMarket;

    @FindBy(xpath = "//div[@class='story_icons']//descendant::li[contains(@class,'related_icon')]")
    private static WebElement buttonRelatedStory;

    @FindBy(xpath = "(//div[@class='imageblock']//img)[1]")
    private static WebElement firstImage;

    @FindBy(xpath = "(//div[@class='imageblock']//img)[2]")
    private static WebElement SecondImage;

    @FindBy(xpath = "//div[@class='contentList']//descendant::ul[1]")
    private static WebElement listRelatedStory;

    @FindBy(xpath = "//div[@class='right']//following::button[@class='save blue']")
    private static WebElement buttonSubmitForRelatedStory;

    @FindBy(xpath = "//ul[@class='para_icons']//descendant::li//i[@class='icon-embed']")
    private static WebElement buttonInsertEmbed;

    @FindBy(xpath = "//div[@class='embedInsert']/span[contains(text(),'Insert Embed')]")
    private static List<WebElement> insertEmbedForHT;

    @FindBy(xpath = "//div[contains(@class,'wid100')]//following::textarea[@placeholder='Enter for the Facebook, tweet, etc here…']")
    private static WebElement inputAddEmbedUrl;

    @FindBy(xpath = "//div[contains(@class,'wid100')]//following::textarea[@placeholder='Enter Source url here']")
    private static WebElement inputAddEmbedSourceUrl;

    @FindBy(xpath = "//div/button[contains(@class,'add blue') and text()='Done']")
    private static WebElement buttonSubmitEmbed;

    @FindBy(xpath = "//div[@class='story_icons']//following-sibling::li[@class='video_icon']//child::i[@class='icon-video']")
    private static WebElement buttonInsertVideo;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement userName;

    @FindBy(xpath = "//div[@class='leadMedia']/div[@class='storyaction']/span[contains(@class,'handle sortpara')]/i")
    private static WebElement dragAndDropForImageIcon;

    @FindBy(xpath = "//*/div[@class='paragraph']/div[@class='storyaction']/span[contains(@class,'handle sortpara')]/i")
    private static WebElement dragAndDropForParagraphIcon;

    @FindBy(xpath = "(//i[@class='icon-move'])[1]")
    private static WebElement dragAndDropForEmbedIcon;

    @FindBy(xpath = "(//i[@class='icon-move'])[2]")
    private static WebElement dragAndDropForRelatedStoryIcon;

    @FindBy(xpath = "//div//li[contains(@class,'summary')]/div[@class='storyaction']/span[contains(@class,'editBtn')]/i")
    private static List<WebElement> buttonRelatedStoryEditIcon;

    @FindBy(xpath = "//div[@class='contentList']//child::ul[2]")
    private static WebElement listCellRelatedStoryForEdit;

    @FindBy(xpath = "//div[@class='embeddcode']//descendant::div[@class='storyaction']/span[contains(@class,'editBtn')]/i[@class='icon-pickup']")
    private static WebElement buttonEmbedEditIcon;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='storyaction']/span[contains(@class,'editBtn')]/i[@class='icon-pickup']")
    private static WebElement buttonImageEditIcon;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='storyaction']/span[contains(@class,'deleteHead')]/i[contains(@class,'icon')]")
    private static WebElement buttonDeleteIconForImage;

    @FindBy(xpath = "//div[@class='search-results']/ul//li[@class='image']//img")
    private static List<WebElement> listOfImagesInListTab;

    @FindBy(xpath = "//div[contains(@class,'form')]//descendant::li[contains(@class,'element')]//li[2]//descendant::div[2]//span[@class='deleteHeadline']/i")
    private static WebElement buttonDeleteIconForMultipleImage;

    @FindBy(xpath = "//div//li[contains(@class,'summary rel')]//descendant::div[@class='storyaction']/span[contains(@class,'deleteHead')]/i[contains(@class,'icon')]")
    private static List<WebElement> buttonDeleteIconForRelatedStory;

    @FindBy(xpath = "//div[@class='top']//div[@class='embeddcode']//descendant::span[@class='deleteHeadline']//i[contains(@class,'icon')]")
    private static List<WebElement> buttonDeleteIconForEmbed;

    @FindBy(xpath = "//div[@class='contentList']/div[@class='storyListing']")
    private static WebElement getSelectedStory;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "(//div[contains(@class,'addHeadline')]//li//textarea)[2]")
    private static WebElement landingPageHeadline;

    @FindBy(xpath = "(//div[contains(@class,'addHeadline')]//li//textarea)[3]")
    private static WebElement mobileAppNotificationHeadline;

    @FindBy(xpath = "(//div[contains(@class,'addHeadline')]//li//textarea)[4]")
    private static WebElement browserNotificationHeadline;

    @FindBy(xpath = "(//div[contains(@class,'addHeadline')]//li//textarea)[5]")
    private static WebElement facebookHeadline;

    @FindBy(xpath = "(//div[contains(@class,'addHeadline')]//li//textarea)[6]")
    private static WebElement twitterHeadline;

    @FindBy(xpath = "(//div[contains(@class,'addHeadline')]//li//textarea)[7]")
    private static WebElement newsletterHeadline;

    @FindBy(xpath = "(//i[@class='icon-add-headline'])[1]")
    private static WebElement headlineAddButton;

    @FindBy(xpath = "//button[@class='save blue' and text()='Save']")
    private static WebElement saveButtonHeadline;

    @FindBy(xpath = "//span[@class='link']")
    private static WebElement storyUrl;

    @FindBy(xpath = "//li[contains(@class,'active')]")
    private static WebElement topicValueSelect;

    @FindBy(xpath = "//div[@class='imageblock']")
    private static List<WebElement> multipleImagesList;

    @FindBy(xpath = "//li[1]//div[contains(@class,'listCell')]")
    private static WebElement dashboardHeadline;
    @FindBy(xpath = "//div[@class='pagination']//descendant::li[5]")
    private static WebElement pageTwentyInPagination;

    @FindBy(xpath = "//div[contains(@class,'recordList')]")
    private static WebElement recordConformation;

    @FindBy(xpath = "//div[contains(@class,'autosuggestion')]//li/span")
    private static WebElement inputBylineActiveText;

    @FindBy(xpath = "(//div[contains(@class,'autosuggestion')]//li/span)[1]")
    private static WebElement inputSectionActiveText;

    @FindBy(xpath = "//div[contains(@class,'recordList borderNone')]")
    private static WebElement singleConformationRecord;

    @FindBy(xpath = "//div[contains(@class,'autosuggestion')]//ul//span[not(contains(.,'No Results'))]")
    private static WebElement inputAddByLineSuggestionPopup;

    @FindBy(xpath = "//div[contains(@class,'storybtn')]//span[contains(@class,'created')]")
    private static WebElement publishedDate;

    @FindBy(css = "i.icon-table")
    private static WebElement insertTable;

    @FindBy(xpath = "//div[contains(@class,'unlockStory')]//p[contains(@class,'ck-placeholder')]")
    private static WebElement insertTableInputBox;

    @FindBy(xpath = "(//button[contains(@class,'add blue ml10')])[3]")
    private static WebElement insertTableDoneButton;

    @FindBy(xpath = "(//div[contains(@class,'chartBlock')]//img)[1]")
    private static WebElement firstChartPosition;

    @FindBy(xpath = "(//button[contains(text(),'Use')])[1]")
    private static WebElement useVideo;

    @FindBy(xpath = "(//li[contains(@class,'tagit-new')]/input)[6]")
    private static WebElement marketCompanyNameInputBox;

    @FindBy(css = "span.name")
    private static WebElement marketCompanyNameInputData;

    @FindBy(xpath = "//li[contains(@class,'chart_icon')]")
    private static WebElement insertChartIcon;

    @FindBy(xpath = "//li[contains(@class,'pdf_icon')]/i")
    private static WebElement insertPdf;

    @FindBy(xpath = "(//div[contains(@class,'lightBoxVideo')]//div[contains(@class,'imagecontain')]//img)[1]")
    private static WebElement firstVideoOnVideoPage;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Pdf file Uploaded Successfully')]")
    private static WebElement popupPdfButton;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[2]")
    private static WebElement firstParagraph;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[3]")
    private static WebElement secondParagraph;

    @FindBy(xpath = "(//button[contains(@class,'dropdown')])[3]")
    private static WebElement firstParagraphHDropdown;

    @FindBy(xpath = "(//button[contains(@class,'heading2')])[1]")
    private static WebElement firstParagraphHeadline2;

    @FindBy(xpath = "//div[contains(@class,'editor')]//h2")
    private static WebElement firstParagraphH2Text;

    @FindBy(xpath = "(//button[contains(@class,'heading3')])[1]")
    private static WebElement firstParagraphHeadline3;

    @FindBy(xpath = "//div[contains(@class,'editor')]//h3")
    private static WebElement firstParagraphH3Text;

    @FindBy(xpath = "//button[contains(@class,'button')]//span[text()='Paragraph']")
    private static WebElement firstParagraphParagraphText;

    @FindBy(xpath = "//ul[@class='listingul active']//li[7]/div/div")
    private static List<WebElement> listOfUpdatedBy;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "(//div[contains(@class,'lastModi ')]//div[@class='dataField']/span)[1]")
    private static WebElement lastModifiedBy;

    @FindBy(xpath = "(//div[contains(@class,'lastModi ')]//div[@class='dataField']/span)[2]")
    private static WebElement lastModifiedAt;

    @FindBy(xpath = "//div[contains(@class,'snotifyToast__buttons')]/button[contains(text(),'Yes')]")
    private static WebElement popupYesForLockedStoryOnPage;

    @FindBy(xpath = "//div[@class='imageblock']/img")
    private static WebElement imageSrc;

    @FindBy(css = "i.icon-scorecard")
    private static WebElement insertScorecard;

    @FindBy(xpath = "(//input[contains(@class,'textBox ng')])[9]")
    private static WebElement scorecardSearchSeries;

    @FindBy(xpath = "//div[contains(@class,'autosuggestion block')]")
    private static WebElement scorecardAutosuggestionSeriesName;

    @FindBy(xpath = "(//div[contains(@class,'autosuggestion block')]//span)[1]")
    private static WebElement scorecardAutosuggestionFirstSeriesName;

    @FindBy(xpath = "//button[contains(@class,'add blue')]")
    private static WebElement scorecardMatchDetailDoneButton;

    @FindBy(xpath = "//div[contains(@class,'selectBoxCompany')]/select")
    private static WebElement scorecardSelectMatchDropDown;
    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;
    @FindBy(xpath = "//label[text()='Breaking News']/following::span[1]")
    private static WebElement breakingNewsButton;
    @FindBy(xpath = "//label[text()='Sponsored']/following::span[1]")
    private static WebElement sponsoredButton;
    @FindBy(xpath = "//label[text()='Mark UnImportant']/following::span[1]")
    private static WebElement markUnImportantButton;
    @FindBy(xpath = "//em[contains(@class,'sponsored')]")
    private static WebElement sponsoredIcon;
    @FindBy(xpath = "//em[contains(@class,'notimportant')]")
    private static WebElement unImportantIcon;
    @FindBy(xpath = "//em[contains(@class,'breakingnews')]")
    private static WebElement breakingNewsIcon;
    @FindBy(xpath = "//label[text()='Big Story']/following::span[1]")
    private static WebElement bigStoryButton;
    @FindBy(xpath = "//label[text()='Mark As Editors Pick']/following::span[1]")
    private static WebElement EditorPickButton;
    @FindBy(xpath = "//label[text()='Blog']/following::span[1]")
    private static WebElement BlogButton;

    @FindBy(xpath = "//label[text()='Premium Story']/following::span[1]")
    private static WebElement PremiumButton;

    @FindBy(xpath = "//label[text()='Specials']/following::span[1]")
    private static WebElement SpecialsButton;
    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']")
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//div[@id='addCaptionForImage']//p | //div[@id='addCaptionForImage']//input")
    private static WebElement firstImageCaption;

    @FindBy(xpath = "//span[@class='i_video']/i")
    private static WebElement uploadVideoIcon;

    @FindBy(xpath = "(//ul[@class='videolist']//div[@class='imagecontain'])[1]")
    private static WebElement uploadVideo;

    @FindBy(xpath = "//button[@class='blue' and contains(text(), 'Use')]")
    private static WebElement useVideoButton;

    @FindBy(xpath = "//button[@id='buttonCropingDone']")
    private static WebElement doneButton;

    @FindBy(xpath = "//div[@class='jw-media jw-reset']/video")
    private static WebElement uploadedVideo;

    @FindBy(xpath = "//div[@class='respVideo']/iframe")
    private static WebElement uploadedFrame;

    @FindBy(xpath = "//ul[@class='leadMediaIcon']/li/span/i")
    private static WebElement imgIcon;

    @FindBy(xpath = "//div[@class='imageAction block']/div/div//span[@class='pickimageBtn']")
    private static WebElement chouseIcon;

    @FindBy(xpath = "(//div[@class='imagecontain']//img)[1]")
    private static WebElement recentImage;

    @FindBy(xpath = "(//button[@class='blue' and contains(text(), 'Use')])[1]")
    private static WebElement useImage;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement yesButton;

    @FindBy(xpath = "//button[@name='saveStory']")
    private static WebElement saveImageButton;

    @FindBy(xpath = "//div[@id='buttonRelatedStory']")
    private static WebElement relatedStoryButton;

    @FindBy(id = "buttonPublish")
    private static WebElement publishButton;

    @FindBy(xpath = "//div[@class='tiimeline']")
    private static WebElement storyTimeline;

    @FindBy(xpath = "//div[@class='updateby']/p")
    private static List<WebElement> publishStory;

    @FindBy(xpath = "(//div[@class='updateby']/div)[1]")
    private static WebElement storyTimelineUser;

    @FindBy(xpath = "//div[@class='fl imageratio' and contains(text(), '4:3 Ratio')]/..")
    private static WebElement fourThreeRatio;

    @FindBy(id = "ellipsis")
    private static WebElement softAssertionEclipse;

    @FindBy(id = "softPublish")
    private static WebElement softAssertionButton;

    @FindBy(id = "buttonRelatedStory")
    private static WebElement relatedStoryIcon;

    @FindBy(xpath = "//li[@class='actions']/span/label/span")
    private static List<WebElement> relatedActionCheckBox;

    @FindBy(xpath = "//div[@class='searchtxt']/input")
    private static WebElement relatedSearchBox;

    @FindBy(id = "inputAddMetaTitleText")
    private static WebElement metaTitleText;

    @FindBy(xpath = "//textarea[@placeholder='Enter meta description here…']")
    private static WebElement metaDescText;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "//span[@id='exactAllStoriesButton']")
    private static WebElement searchButton;

    @FindBy(xpath = "(//div[@id='storiesListing']/div)[1]/ul/div/li")
    private static List<WebElement> resultList;

    @FindBy(xpath = "//label[text()= 'Edit Disclaimer']/following-sibling::label/span")
    private static WebElement editDisclaimerCheckBox;

    @FindBy(xpath = "//textarea[@placeholder='Enter the blog disclaimer']")
    private static WebElement disclaimerTextArea;

    @FindBy(xpath = "//li[contains(@class,'spImg_podcast_podcast')]")
    private static WebElement spImgPodcastIcon;

    @FindBy(xpath = "//ul[@class='podCastEpisodesList']/li")
    private static List<WebElement> podCastEpisodesList;

    @FindBy(xpath = "//span[@class='hover']/button")
    private static List<WebElement> usePodcastButtonList;

    @FindBy(xpath = "//div[@class='podcastBlock']/div/div")
    private static List<WebElement> podcastBlockList;

    @FindBy(id = "buttonRelatedStory")
    private static List<WebElement> buttonRelatedStoryList;

    @FindBy(xpath = "//div[@class='contentList']/ul")
    private static List<WebElement> contentList;

    @FindBy(xpath = "//div[@class='right']//button[@name='discard']")
    private static WebElement contentListCloseButton;

    @FindBy(id = "buttonSubmitForRelatedStory")
    private static WebElement contentListChoseButton;

    @FindBy(xpath = "//div[@class='relatedstory']")
    private static WebElement howToStoryLabel;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> buttonYesForAlertPopup;

    @FindBy(id = "buttonAddCoustomHeadline")
    private static WebElement plusIconHeading;

    @FindBy(xpath = "(//div[@class='addHeadline']/ul/li/label)[8]")
    private static WebElement plusHeadingH2;

    @FindBy(xpath = "(//div[@class='addHeadline']/ul/li/label/following-sibling::div/textarea)[8]")
    private static WebElement plusHeadingH2Text;

    @FindBy(xpath = "(//div[@class='addHeadline']/ul/li/label)[9]")
    private static WebElement plusHeadingH3;

    @FindBy(xpath = "(//div[@class='addHeadline']/ul/li/label/following-sibling::div/textarea)[9]")
    private static WebElement plusHeadingH3Text;

    @FindBy(xpath = "(//span[@id='headline1']/i)[2]")
    private static WebElement plusIconSummary;

    @FindBy(xpath = "//div[@class='dataField heightQuickRead']/textarea")
    private static WebElement quickReadSummary;

    @FindBy(id = "quickSummaryError")
    private static WebElement quickSummaryError;

    @FindBy(xpath = "//div[@class='right']//button[@name='save']")
    private static WebElement quickSummarySave;

    @FindBy(xpath = "//li[contains(@class, 'spImg_recipeIcon')]")
    private static WebElement recipaIcon;

    @FindBy(xpath = "//textarea[@formcontrolname ='recipeName']")
    private static WebElement recipeName;

    @FindBy(xpath = "//div[contains(@class, 'right pad')]/button[@name='unlock']")
    private static WebElement recipeDoneButton;

    @FindBy(xpath = "(//span[@class='requiredField'])[1]")
    private static WebElement recipeReqMsg;

    @FindBy(xpath = "(//span[@class='requiredField'])[2]")
    private static WebElement recipeReqErrorMsg;

    @FindBy(xpath = "//div[@class='stepBlock']//following-sibling::div[contains(@class, 'ck-editor__main')]/div")
    private static WebElement recipeStepText;

    @FindBy(xpath = "//div[@class='howToStepBlock']")
    private static WebElement recipeBlock;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[2]")
    private static WebElement buttonNo;

    @FindBy(xpath = "//textarea[@formcontrolname ='description']")
    private static WebElement recipeDescription;

    @FindBy(xpath = "//textarea[@formcontrolname ='recipeYield']")
    private static WebElement recipeYield;

    @FindBy(xpath = "//textarea[@formcontrolname ='preparationTimeHr']")
    private static WebElement recipePreparationTimeHr;

    @FindBy(xpath = "//textarea[@formcontrolname ='preparationTimeMinute']")
    private static WebElement preparationTimeMinute;

    @FindBy(xpath = "//textarea[@formcontrolname ='cookingTimeHr']")
    private static WebElement cookingTimeHr;

    @FindBy(xpath = "//textarea[@formcontrolname ='cookingTimeMinute']")
    private static WebElement cookingTimeMinute;

    @FindBy(xpath = "//textarea[@formcontrolname ='totalTimeHr']")
    private static WebElement totalTimeHr;

    @FindBy(xpath = "//textarea[@formcontrolname ='totalTimeMinute']")
    private static WebElement totalTimeMinute;

    @FindBy(xpath = "(//div[contains(@class,'stepblock')]//ul[@id='myTags']//input)[1]")
    private static WebElement ingredients;

    @FindBy(xpath = "//h3[@class='pad30']")
    private static WebElement recipeHeading;

    @FindBy(xpath = "(//ul[@id='myTags']/li/input[contains(@class, 'ng-valid') and @id=''])[1]")
    private static WebElement ingredientsAfterInsert;

    @FindBy(xpath = "(//div[contains(@class,'stepblock')]//ul[@id='myTags']//input)[2]")
    private static WebElement keyword;

    @FindBy(xpath = "(//div[contains(@class,'autosuggestion')]//span)[1]")
    private static WebElement suggestionValue;


    @FindBy(xpath = "(//div[@class='autosuggestion block']//span)[1]")
    private static WebElement clickKeywordValue;

    @FindBy(xpath = "(//ul[@id='myTags']/li/input[contains(@class, 'ng-valid') and @id=''])[2]")
    private static WebElement keywordAfterInsert;

    @FindBy(xpath = "//textarea[@formcontrolname ='recipeCuisine']")
    private static WebElement recipeCuisine;

    @FindBy(xpath = "//textarea[@formcontrolname ='recipeCategory']")
    private static WebElement recipeCategory;

    @FindBy(xpath = "(//div[@class='imageLibrary'])[2]")
    private static WebElement imageLibrary;

    @FindBy(xpath = "//div[contains(@class,'photogallerylist')]//div[@class='imageblock']/div[@class='image']")
    private static WebElement recipeImgIcon;

    @FindBy(xpath = "(//div[@class='heading'])[1]")
    private static WebElement recipeNameValue;

    @FindBy(xpath = "(//div[@class='heading'])[2]")
    private static WebElement recipeDescriptionValue;

    @FindBy(xpath = "(//div[@class='heading'])[3]")
    private static WebElement recipeYieldValue;

    @FindBy(xpath = "(//div[@class='heading'])[4]")
    private static WebElement recipePreparationTimeValue;

    @FindBy(xpath = "(//div[@class='heading'])[5]")
    private static WebElement recipeCookingTimeValue;

    @FindBy(xpath = "(//div[@class='heading'])[6]")
    private static WebElement recipeTotalTimeValue;

    @FindBy(xpath = "(//div[@class='heading'])[7]/following-sibling::div[1]")
    private static WebElement recipeKeywordsValue;

    @FindBy(xpath = "(//div[@class='heading'])[8]")
    private static WebElement recipeCuisineValue;

    @FindBy(xpath = "(//div[@class='heading'])[9]")
    private static WebElement recipeCategoryValue;

    @FindBy(xpath = "(//div[@class='heading'])[10]/following-sibling::div[1]")
    private static WebElement recipeIngredientsValue;

    @FindBy(xpath = "//ckeditor[@class='ng-untouched ng-pristine']/div/p")
    private static WebElement recipeStepValue;

    @FindBy(xpath = "//div[@class='stepAnswer']")
    private static WebElement recipeImageValue;

    @FindBy(xpath = "(//div[@class='storyaction']/span[@class='editBtn']/i)")
    private static WebElement recipeEditIcon;

    @FindBy(xpath = "//li[@class='sendNotificationUpdate']/div/p/a")
    private static WebElement sendNotificationLink;

    @FindBy(xpath = "//h3[@class='flSendNoti']")
    private static WebElement sendNotificationText;

    @FindBy(xpath = "(//div[@class='head'])")
    private static List<WebElement> socialNotificationHeading;

    @FindBy(xpath = "//label[@for='imageUrl']")
    private static WebElement imgUrlLabel;

    @FindBy(xpath = "//input[@id='imageUrl']")
    private static WebElement imgUrlText;

    @FindBy(xpath = "//button[@name='cancel']")
    private static WebElement socialNotificationCancelButton;

    @FindBy(xpath = "//button[@name='send']")
    private static WebElement socialNotificationSendButton;

    @FindBy(xpath = "//div[@class='snotifyToast__body']")
    private static WebElement socialNotificationSuccessMessage;

    @FindBy(xpath = "//button[@id='backlinkID']/i")
    private static WebElement backLinkID;

    @FindBy(xpath = "//div[contains(@class, 'searchaddlink')]/button")
    private static WebElement addLinkButton;

    @FindBy(xpath = "//div[contains(@class, 'searchaddlink')]/input[contains(@class, 'search-components')]")
    private static WebElement searchAddLinkText;

    @FindBy(xpath = "//div[@class='scrollY']/ul/li/div[1]")
    private static List<WebElement> searchedStoryList;

    @FindBy(xpath = "//div[contains(@class, 'ck-link-actions')]/a")
    private static WebElement selectedLink;

    @FindBy(xpath = "//div[@class='scrollY']/ul/div")
    private static WebElement hyperLinkValidationMessage;

    @FindBy(xpath = "(//div[@class='dataField']/input)[4]")
    private static WebElement canonicalUrlText;

    @FindBy(xpath = "//div[@class='FirstEle']/p/a")
    private static WebElement canonicalUrlHyperlink;

    @FindBy(xpath = "//section[contains(@class, 'cardHolder')]/article/a/h1")
    private static WebElement hyperlinkHeadingName;

    @FindBy(id = "deny")
    private static WebElement denyButton;

    @FindBy(xpath = "(//div[@class = 'ck-balloon-rotator__content']/div/button)[1]")
    private static WebElement hyperlinkEditButton;

    @FindBy(xpath = "//input[contains(@class, 'ck-input-text')]")
    private static WebElement hyperlinkEditText;

    @FindBy(xpath = "//button[contains(@class, 'ck-button-save')]")
    private static WebElement hyperlinkEditSaveButton;

    @FindBy(xpath = "(//div[@class = 'ck-balloon-rotator__content']/div/button)[2]")
    private static WebElement hyperlinkUnlinkButton;

    @FindBy(xpath = "(//input[contains(@class, 'search-components')])[2]")
    private static WebElement hyperlinkSearchText;

    @FindBy(xpath = "//button[@name='cancel']")
    private static WebElement notificationCancelButton;

    @FindBy(xpath = "//em[contains(@class, 'bellIcon')]")
    private static WebElement notificationBellIcon;

    @FindBy(xpath = "(//div[@class='snotifyToast__body'])[1]")
    private static WebElement notificationSuccess;

    @FindBy(xpath = "//input[@id='storyUrl' and contains(@class, form-control)]")
    private static WebElement notificationImgUrlText;

    @FindBy(xpath = "(//h2[@id='allDomain'])[1]")
    private static WebElement crossTenant;

    @FindBy(xpath = "//div[@class='imagecontain']/img")
    private static List<WebElement> crossTenantImages;

    @FindBy(xpath = "(//span[@class='deleteHeadline']/i)[3]")
    private static WebElement uploadedImgDeleteButton;

    @FindBy(id = "buttonInsertImage")
    private static WebElement inlineInsertImgIcon;

    @FindBy(xpath = "(//div[@class='upload-btn-wrapper'])[1]")
    private static WebElement imgUploadTxt;

    @FindBy(xpath = "(//div[@class='upload-btn-wrapper']/input)[1]")
    private static WebElement imgUploadTxtBox;

    @FindBy(id = "addCaptionText")
    private static WebElement captionText;

    @FindBy(xpath = "//li[@class='headline']/small/div/div")
    private static List<WebElement> relatedStoryList;

    @FindBy(xpath = "//li[@class='actions']/span/label/span")
    private static List<WebElement> relatedStoryCheckList;

    @FindBy(id = "buttonSubmitForRelatedStory")
    private static WebElement relatedStoryChooseButton;

    @FindBy(xpath = "//div[@class='relatedstory']/label")
    private static WebElement relatedStoryHeadline;

    @FindBy(xpath = "(//button[contains(@class, 'ck-button_with-text')])[1]")
    private static WebElement hButton;

    @FindBy(xpath = "//button[(contains(@class, 'ck-heading_heading')) or (contains(@class, 'ck-button_with-text'))]")
    private static List<WebElement> hButtonOptions;

    @FindBy(id = "moreFilter")
    private static WebElement moreFilterButton;

    @FindBy(id = "locationFilter")
    private static WebElement locationFilterButton;

    @FindBy(id = "locationFilterInputBox")
    private static WebElement locationFilterText;

    @FindBy(xpath = "(//label[contains(@id, 'typeFilterValue')]/span)[last()]")
    private static WebElement locationFilterValue;

    @FindBy(xpath = "(//div[@class='dataField']/label/span)[last()]")
    private static WebElement outdatedFlag;

    @FindBy(xpath = "//input[@name='createCard']")
    private static WebElement outdatedFlagDate;

    @FindBy(xpath = "//li[@class='headline spImg']/div/div")
    private static List<WebElement> locationFilterResult;

    @FindBy(xpath = "//button[(contains(@class, 'ck-heading_heading')) or (contains(@class, 'ck-button_with-text'))]/..")
    private static List<WebElement> hButtonOp;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/p")
    private static WebElement optionParagraph;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/h2")
    private static WebElement optionHeadingTwo;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/h3")
    private static WebElement optionHeadingThree;

    @FindBy(xpath = "//div[@class='respVideo']/iframe")
    private static WebElement insertedVideoFfame;

    @FindBy(xpath = "//div[@class='videoImage']/img")
    private static WebElement insertedImageFfame;

    @FindBy(xpath = "//span[@class='i_video']/i")
    private static WebElement videoIcon;

    @FindBy(xpath = "(//div[contains(@class, 'ck-editor__main')]/div)[3]")
    private static WebElement videoCaptionText;

    @FindBy(xpath = "(//div[contains(@class, 'ck-editor__main')]/div)[3]")
    private static WebElement imageCaptionText;

    @FindBy(xpath = "//button[@name='saveStory']")
    private static WebElement captionDoneBtn;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/p")
    private static List<WebElement> optionParagraphList;

    @FindBy(id = "buttonDragAndDrop")
    private static WebElement sixDotsButton;

    @FindBy(xpath = "//div[contains(@class, 'ck-alignment-dropdown')]/button")
    private static WebElement alignmentButton;

    @FindBy(xpath = "(//span[@class='deleteHeadline']/i)[3]")
    private static WebElement paragraphDeleteButton;

    @FindBy(xpath = "(//label[@class='switch']/span)[7]")
    private static WebElement outdatedFlagToggle;

    @FindBy(xpath = "(//label[@class='switch']/span)[6]")
    private static WebElement blogToggle;

    @FindBy(xpath = "//input[@name='createCard']")
    private static WebElement validityTimeText;

    @FindBy(xpath = "(//td[contains(@class, 'today') and contains(@class, 'active')]/following-sibling::td)[1]")
    private static WebElement validityTimeNextDay;

    @FindBy(xpath = "//div[contains(@class,'single')]//button[contains(@class, 'applyBtn')]")
    private static WebElement validityTimeApplyBtn;

    @FindBy(xpath = "(//label[@class='switch']/span)[last()-2]")
    private static WebElement randomToggle;

    @FindBy(xpath = "(//button[@name='unlock'])[1]")
    private static WebElement autoBacklinkingButton;

    @FindBy(xpath = "//div[@class='snotifyToast__body']")
    private static WebElement autoBacklinkingSuccess;

    @FindBy(id = "email")
    private static WebElement moengageEmail;

    @FindBy(id = "password")
    private static WebElement moengagePassword;

    @FindBy(xpath = "//button[@type = 'submit']")
    private static WebElement moengageLogin;

    @FindBy(xpath = "(//input[contains(@class, 'mds-input__input__text ')])[1]")
    private static WebElement moengageStorySearchTxt;

    @FindBy(xpath = "//tr[@class='campaign-row']/td/a/span")
    private static List<WebElement> moengageStorySearchResult;

    @FindBy(xpath = "(//div[contains(@class, 'mds-input--icon')]/i)[1]")
    private static WebElement moengageStorySearchIcon;

    @FindBy(xpath = "//button[@name='createCard']")
    private static WebElement scheduleNotificationButton;

    @FindBy(xpath = "(//td[contains(@class, 'today')]/following-sibling::td)[1]")
    private static WebElement scheduleNotificationNextDay;

    @FindBy(xpath = "//button[contains(@class, 'applyBtn')]")
    private static WebElement scheduleNotificationApplyBtn;

    @FindBy(xpath = "(//div[@class='relatedstory']/label)[2]")
    private static WebElement relatedStorySecHeadline;

    @FindBy(id = "buttonRelatedStoryEditIcon")
    private static WebElement relatedStoryEditIcon;

    @FindBy(xpath = "//div[@class='form']/ul/li[4]//button")
    private static WebElement seoScoreButton;

    @FindBy(xpath = "//tbody//td[10]")
    private static WebElement getSeoScore;

    @FindBy(xpath = "//input[@type='search']")
    private static WebElement seoSearch;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/h2")
    private static WebElement getParagraphText;

    @FindBy(xpath = "//span[@id='storyUrl']/..")
    private static WebElement generatedUrl;

    @FindBy(xpath = "(//div[@class='form']/ul)[6]")
    private static WebElement generatedUrlText;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[2]")
    private static WebElement noBtn;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(), 'Story with matching title & summary found')]")
    private static WebElement matchingValidationMsg;

    @FindBy(xpath = "(//i[@class='icon-delete'])[2]")
    private static WebElement deleteSummaryButton;


    @FindBy(xpath = "//span[@class='edited']")
    private static WebElement storyStatusEdited;

    @FindBy(xpath = "//span[@class='scheduled']")
    private static WebElement storyStatusScheduled;

    @FindBy(xpath = "//span[@class='filed']")
    private static WebElement storyStatusFiled;

    @FindBy(xpath = "(//span[@class='scheduled'])[1]")
    private static WebElement scheduledStory;

    @FindBy(xpath = "//i[@class='icon-image-gallery']")
    private static WebElement sampleImagesElement;

    @FindBy(xpath = "(//li[@id='leadMedia']//i)[1]")
    private static WebElement leadMediaIcon;

    @FindBy(xpath = "//div[contains(@class,'imageAction block')]//div[@class='uploadimage']")
    private static WebElement uploadNewFilesOption;

    @FindBy(xpath = "(//input[@type='file'])[1]")
    private static WebElement uploadNewImageFile;

    @FindBy(xpath = "//div[contains(@class,'imageAction block')]//div[@class='pickimage']")
    private static WebElement pickImageOption;

    @FindBy(xpath = "//ul[@class='imagelist search-results']//li[1]")
    private static WebElement imgInLib;

    @FindBy(xpath = "//ul[@class='imagelist search-results']//li[4]")
    private static WebElement imgInLibSecond;

    @FindBy(xpath = "//div[contains(@class,'choosephotos')]/button[2]")
    private static WebElement chooseButtonInImageGallery;


    @FindBy(xpath = "//div[@class='sampleimg']")
    private static List<WebElement> uploadedSampleImages;

    @FindBy(xpath = "//input[contains(@class,'ck-input-text')]")
    private static WebElement addHyperLink;


    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement submitHyperLink;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]//a")
    private static WebElement hyperLinkedWord;

    @FindBy(xpath = "(//input[@id='inputAddSubSectionText'])[2]")
    private static WebElement SubSectionL2Field;

    @FindBy(xpath = "//div[@class='imageblock']")
    private static WebElement leadImage;

    @FindBy(xpath = "//span[@id='moreFilter']")
    private static WebElement moreFilter;

    @FindBy(xpath = "//span[@id='statusFilter']")
    private static WebElement statusFilter;

    @FindBy(xpath = "//label[@id='typeFilterValueScheduled']")
    private static WebElement statusScheduled;

    @FindBy(xpath = "(//span[@class='scheduled'])[1]")
    private static WebElement StoryStatusScheduled;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(), 'Publishing without checking for duplicates')]")
    private static WebElement matchingValidationMsgs;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//button[@name='saveStory']")
    private static WebElement imageEditDoneButton;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//label")
    private static WebElement firstImageCaptionNameData;


    @FindBy(xpath = "//i[@class='icon-broken-link1']")
    private static WebElement unlinkWork;


    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/p/a")
    private static WebElement hyperLinkedParagraphWord;


    @FindBy(xpath = "//div[contains(@class,'listrelatedstories')]//div[@class='searchSection']//input")
    private static WebElement searchTextInRelatedStories;


    @FindBy(xpath = "(//li[@class='format']//span)[2]")
    private static WebElement SectionTextInRelatedStories;


    @FindBy(xpath = "(//div[@class='imageInfo']//span)[1]")
    private static WebElement imageCaptionOfLibImg;


    public StandardStoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        dbUtils = DbUtils.getInstance();
    }

    @Override
    public boolean createStoryAndVerify(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        boolean isStoryCreated;
        createStandardStory(headline, summary, paragraph, byline, section, subsection, keyword, location, topic);
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
//        commonFunctions.waitForElementToBeVisibleAndClickable(singleRecordConformation, 50, "Single record");
//        commonFunctions.waitAndGetElementTextAndCheck(singleConformationRecord, "Showing 1 results", 30, "record conformation");
        isStoryCreated = commonFunctions.waitAndGetElementTextAndCheck(storyStatus, "CREATED", 30, "Correct text is");
        return isStoryCreated;
    }

    private void createStandardStory(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();

    }

    private void saveStandardStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 30, "save story button");
        commonFunctions.isElementDisplayed(toastSaveButton, 20, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
    }

    private void inputLocation(String location) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 5, "location box")) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        }
    }

    private void inputKeywords(String keyword) {
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
    }

    private void inputSubSection(String subsection) {
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 30, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "wait for Save changes text");
    }

    private void inputSubSectionL2(String subsectionL2) {
        commonFunctions.sendKeys(inputAddSubSectionL2Text, subsectionL2, 30, "sub-section L2 box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionL2Text, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "wait for Save changes text");
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }

    private void inputByLine(String byline) {
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for changes saved label ");
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
    }

    private void inputTopic(String topic) {
        String actualText = null;
        if (!globalVars.getBpTenant().equalsIgnoreCase("Live Mint") && !globalVars.getBpTenant().equalsIgnoreCase("Tech")) {
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
            if (commonFunctions.isElementDisplayedAndPresent(inputAddTopicText, 20, "topic box")) {
                commonFunctions.clickElementIfDisplayed(inputAddTopicText, 10, "Topic input box");
                commonFunctions.sendKeyWithActions(inputAddTopicText, topic);
                //commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
                //commonFunctions.clickElementWithJS(topicValueSelect, "Topic Value Click", 10);
                commonFunctions.isElementDisplayed(topicValueSelect, 30, "topic text");
                actualText = commonFunctions.getElementText(topicValueSelect, 20);
                if (actualText.equalsIgnoreCase(topic))
                    commonFunctions.clickElementWithJS(topicValueSelect, 20, "topic value");
            }
        }
    }

    private void inputParagraph(String paragraph) {
        commonFunctions.isElementDisplayedAndPresent(addParagraphText, 30, "paragraph");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        commonFunctions.sendKey(addParagraphText, paragraph, 25);
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        //commonFunctions.sendKey(addParagraphText, paragraph);
    }

    private void inputSummary(String summary) {
        commonFunctions.isElementDisplayedAndPresent(addSummaryText, 20, "Summary field");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        commonFunctions.clearText(addSummaryText);
        commonFunctions.hardWait(2000);
        commonFunctions.sendKeys(addSummaryText, " ", 10, "Enter blank text");
        commonFunctions.sendKeyWithActions(addSummaryText, summary);
    }

    private void inputHeadline(String headline) {
        commonFunctions.hardWait(1000);
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        commonFunctions.sendKeyWithActions(enterHeadlineText, headline);
    }

    private void selectStandardStory() {
        commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectStory, 30, " standard story button");
    }

    private void openNewStandardStory() {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    @Override
    public boolean editStoryAndVerify(String editHeadline) {
        boolean isEdited;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.sendKeyWithActions(enterHeadlineText, editHeadline);
        fileStoryAndFinishEditing();
        commonFunctions.clickElementWithJS(appLogo, 20);
        searchStoryByID(storyIdNumber);
//        commonFunctions.waitForElementIgnoringStaleElement(storyStatus,30,"story Status");
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 10, "Single record");
        commonFunctions.getElementTextAndCheck(dashboardHeadline, editHeadline, 30, "Story headline");
        isEdited = commonFunctions.checkElementText(storyStatus, "EDITED", 10, "Correct text is");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 25, "story list item");
        commonFunctions.getElementTextAndCheck(enterHeadlineText, editHeadline, 30, "headline text");
        return isEdited;
    }

    private void fileStoryAndFinishEditing() {
        commonFunctions.clickElementWithJS(buttonFileStoryForEdit, 10, "File Button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementWithJS(buttonFinishedEditing, 25, "Finished Editing button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.isElementDisplayedWithoutTryCatch(statusEdited, 20, "Story edited");
    }

    @Override
    public boolean publishStory() {
        boolean isPublished;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.isElementDisplayed(ellipsis, 60, "three dot button");
        publishStoryAndVerify();
        searchStoryByID(storyIdNumber);

//        commonFunctions.waitForElementIgnoringStaleElement(storyStatus,30,"Story status ");
        //isPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 40, "Correct text is");
        commonFunctions.waitForElementIgnoringStaleElement(storyStatus, 30, "Story status ");
        isPublished = commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "PUBLISHED", 40, "Correct text is");
        return isPublished;
    }

    private void publishStoryAndVerify() {
        boolean isPublishSuccessfully;
        boolean isReadabilityPopup;
        commonFunctions.clickElementWithJS(buttonPublish, 40, "publish story");
        commonFunctions.hardWait(2000);
        if (commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20)) {
            Utils.logStepInfo("Success Message is displaying");
        } else {
            if (commonFunctions.isElementPresentWithTryCatch(yesBtn, 20)) {
                commonFunctions.clickElementIfDisplayed(yesBtn, 5);
            }
        }
        isPublishSuccessfully = commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 10, "Publish toaster");
        if (!isPublishSuccessfully) {
            isReadabilityPopup = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 15, "Popup for HTNew domain is");
            if (isReadabilityPopup) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 30, "Yes button on popup");
                commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 10, "Publish toaster");
            }
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
        commonFunctions.isElementDisplayed(byline, 20);
    }

    @Override
    public boolean purgeStoryAndVerify() {
        boolean isStoryPurged;
        commonFunctions.waitForElementIgnoringStaleElement(selectedStory, 20, "story Status ");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "standard story list item");
        commonFunctions.clickElementWithJS(ellipsis, 60, "three dot button");
        commonFunctions.clickElementIgnoringStaleElement(buttonPurgeStory, 15, "purge story button");
        isStoryPurged = commonFunctions.getElementTextAndCheck(toastPurgeStory, "Purge request accepted", 30, "Correct text is");
//        commonFunctions.checkElementTextIgnoringStaleElement(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryPurged;
    }

    @Override
    public boolean killStoryAndVerify() {
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

    @Override
    public boolean checkChangeUrl(String headline) {
        boolean isStoryUrlChanged;
//        int urlIndex;
//        Random randomNo = new Random();
//        urlIndex = randomNo.nextInt(1000);

        String changeUrlName = headline;

        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElementWithJS(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
        commonFunctions.sendKeys(addUrlForHeadline, changeUrlName, 20, "url box");
        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
        isStoryUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
        String url = commonFunctions.getElementText(storyUrl, 10);
        String[] changedUrl = url.split("-");
        String[] value = changedUrl[changedUrl.length - 2].split("/");
        String data = value[value.length - 1];
        if (data.equals(changeUrlName)) {
            isStoryUrlChanged = isStoryUrlChanged && true;
        } else {
            isStoryUrlChanged = false;
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStoryUrlChanged;
    }

    @Override
    public boolean softPublishAndVerify() {
        if (globalVars.isProdRun()) {
            Select dropDown = new Select(dropDownRecordListInPagination);
            dropDown.selectByVisibleText("200");
            //commonFunctions.clickElement(pageTwentyInPagination, 15, "page one");
            //commonFunctions.clickElement(storyContentsListInPagination.get(0));
            dashboardPage.openPublishedAndUnlockedStory("Standard");

        } else {
            searchStoryByIDAndSelect(storyIdNumber);
        }
        return softPublishStory();
    }

    private boolean softPublishStory() {
        boolean isSoftPublished;
        boolean isReadabilityPopupAvailable;
//        commonFunctions.sendKeys(enterHeadlineText, editHeadline, 20, "edit headline");
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.isElementDisplayedAndPresent(buttonSoftPublish, 10, "soft publish button");
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

    @Override
    public boolean discardStoryAndVerify() {
        boolean isDiscardStory;
        searchStoryByIDAndSelect(storyIdNumber);
        discardStory();
        searchStoryByID(storyIdNumber);
        commonFunctions.checkElementText(recordConformation, "Showing 0 results", 50, "0 record conformation");
        isDiscardStory = commonFunctions.checkElementText(textNoData, "No Data", 30, "Correct text is");
        dashboardPage.clearSearch();
        return isDiscardStory;
    }

    private void discardStory() {
        commonFunctions.clickElementWithJS(ellipsis, 50, "Three dot button");
        commonFunctions.hardWait(2000);
        commonFunctions.clickElementWithJS(buttonDiscardStory, 15, "discard story button");
        commonFunctions.hardWait(5000);
    }

    @Override
    public boolean verifyImageCropping() {
        boolean isStorySavedStatus = false;
        commonFunctions.clickElement(storyStatus, 15, "standard story list");
        commonFunctions.clickElement(cropIconButton, 15, "crop icon button");
        commonFunctions.scrollPageWithJS(buttonCropingDone, 10);
        commonFunctions.clickElement(buttonCropingDone, 25, "crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "text is");
        isStorySavedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        if (isStorySavedStatus) {
            commonFunctions.clickElement(appLogo, 20);
            return isStorySavedStatus = true;
        }
        return isStorySavedStatus;
    }

    @Override
    public boolean verifyUploadImage(String storyId) {
        boolean isStoryUploadedStatus = false;
        boolean isConfirmImageSize = false;
        boolean isImageIconButton = false;
//        commonFunctions.sendKeys(searchAllStoriesText, "id:" + storyId, 10, "search box");
//        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
        commonFunctions.waitForElementBeDisplayAndClick(selectedStory, 30, "selected story");
        //        isImageIconButton = commonFunctions.isElementDisplayedAndPresent(iconForImageUpload, 7, "image icon button is");
//        if (!isImageIconButton) {
        commonFunctions.clickElementWithJS(buttonDeleteIconForImage, 20, "delete icon for image");
        commonFunctions.clickElement(iconForImageUpload, 25, "image icon button");
        commonFunctions.clickElementWithJS(imagePicFromLib, 25, "image library button");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "listview image icon button");

        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab, 20, "images loading");
        for (int i = 0; i <= listOfImagesInListTab.size() - 1; i++) {
            if ((listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws"))) {
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i), 20, "Click on Image having src tab");
                break;
            }
        }

        //commonFunctions.clickElement(listImageSearchResult, 40, "image records of result list item");
        isConfirmImageSize = commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 30, "popup image size conformation:Yes");
        if (isConfirmImageSize) {
            commonFunctions.clickElements(popupConfirmImageSize, 20, "popup for confirm image size button");
        }
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 30);
        commonFunctions.clickElement(buttonCropingDone, 25, "crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        commonFunctions.scrollPageWithJS(addTitleForImage, 30);
        // addCaptionForImage.clear();
        // commonFunctions.sendKeys(addCaptionForImage, "caption for the test", 15, "textbox");

        // commonFunctions.sendKeys(addTitleForImage, "tilte", 30, "textbox");
        commonFunctions.scrollPageWithJS(divAreaForScrollView, 30);
        commonFunctions.waitForElementBeDisplayAndClick(captionSubmitButton, 30, "caption submit button");
        //}
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        isStoryUploadedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        if (isStoryUploadedStatus) {
            commonFunctions.clickElement(appLogo, 20);
            return isStoryUploadedStatus = true;
        }
        return isStoryUploadedStatus;
    }

    @Override
    public boolean verifyUploadMultipleImages() {
        int i;
        boolean isStorySavedStatus = false;
        searchStoryByIDAndSelect(storyIdNumber);
        //commonFunctions.clickElement(storyStatus, 15, "standard story list item");
        //setStoryId();
        for (i = 0; i < 2; i++) {
            commonFunctions.dummyWait(30);
            commonFunctions.clickElement(buttonInsertImage, 25, "image icon button");
            commonFunctions.clickElement(imagePicFromLib, 25, "image library button");
            commonFunctions.clickElementWithActions(imageListViewIcon, 25, "listview image icon button");
            commonFunctions.clickElement(listImageSearchResult, 25, "image records of result list");
            commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
            commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
            commonFunctions.clickElementIfDisplayed(buttonEditForImage, 10, "image edit ");
            commonFunctions.scrollPageWithJS(divAreaForScrollView, 15);
            if (i == 1) {
                commonFunctions.isElementDisplayedAndPresent(SecondImage, 30, "Wait for Image upload");
            }
            commonFunctions.waitForElementBeDisplayAndClick(captionSubmitButton, 35, "submit caption button");
            commonFunctions.isElementDisplayedAndPresent(firstImage, 30, "Wait for Image list to be displayed");
        }
        isStorySavedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        if (isStorySavedStatus) {
            commonFunctions.clickElement(appLogo, 20);
            commonFunctions.isElementDisplayed(byline, 20);
            commonFunctions.isElementDisplayed(searchAllStoriesText, 20);
        }
        boolean isMultipleImagesUpload = verifyMultipleImages();
        return isStorySavedStatus && isMultipleImagesUpload;
    }

    @Override
    public boolean verifyInsertEmbed() {
        boolean isStorySavedStatus;
        //TODO: embed url is still hardcoded inside verifyInsertEmbed() method, need to take this from test data sheet
        String embedUrl = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/RbSlW8jZFe8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonInsertEmbed, 20, "insert embed icon");
        if (commonFunctions.isElementDisplayedAndPresent(insertEmbedForHT, 20, "Correct Text is")) {
            commonFunctions.clickElements(insertEmbedForHT, 15, "embed button");
        }
        commonFunctions.sendKeys(inputAddEmbedUrl, embedUrl, 15, "embed textbox");
        commonFunctions.clickElement(buttonSubmitEmbed, 15, "submit embed button");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
        isStorySavedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStorySavedStatus;
    }


    @Override
    public boolean verifyDragAndDrop() {
        boolean isDragDropStatus;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(dragAndDropForRelatedStoryIcon, 20, "RelatedStory Drag icon");
        isDragDropStatus = commonFunctions.dragAndDrop(dragAndDropForRelatedStoryIcon, dragAndDropForEmbedIcon, 35, "draged & dropped");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        isDragDropStatus &= commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        //TODO: after drag and drop verification is missing
        commonFunctions.clickElementWithAction(appLogo, 10, "App logo");
        return isDragDropStatus;
    }

    @Override
    public boolean verifyInsertRelatedStory() {
        boolean isStorySavedStatus;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElementWithJS(buttonRelatedStory, 25, "insert related story icon button");
        if (commonFunctions.isElementDisplayedAndPresent(listRelatedStory, 20, "related story list cell")) {
            commonFunctions.clickElementWithJS(listRelatedStory, 40, "related story list cell");
            commonFunctions.clickElementWithJS(buttonSubmitForRelatedStory, 15, "submit button");
        }
        saveStandardStoryAndVerify();
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        isStorySavedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20, "App logo");
        return isStorySavedStatus;
    }

    @Override
    public boolean deleteStoryContentAndVerify() {
        boolean isElementTextDeleted;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonDeleteParagraph, 15, "delete paragarph ");
        commonFunctions.clickElement(buttonDeleteSummary, 15, "delete summary ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        saveStandardStoryAndVerify();
        commonFunctions.refreshPage();
        isElementTextDeleted = commonFunctions.getElementTextAndCheck(addSummaryText, "", 20, "Summary text deletion");
        //isElementTextDeleted = isElementTextDeleted && commonFunctions.getElementTextAndCheck(addParagraphText, "", 20, "Paragraph text deletion");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
        return isElementTextDeleted;
    }

    @Override
    public boolean checkEditStoryContent(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {

        commonFunctions.waitForElementBeDisplayAndClick(selectedStory, 30, "selected story");
        String expected = headline + commonFunctions.generateRandomNum() + "aw";
        inputHeadline(expected);
        inputSummary(summary + commonFunctions.generateRandomNum() + "aw");
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();
        commonFunctions.navigateBack();
        searchStoryByIDAndSelect(storyIdNumber);
        String actual = commonFunctions.getElementText(enterHeadlineText, 10);

        return actual.equalsIgnoreCase(expected);
    }

    @Override
    public boolean updateCustomHeadline(String landing, String mobile, String browser, String facebook, String twitter, String newsletter, String domain) {
        boolean isCustomHeadingUpdated;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(headlineAddButton, 15, "headline add button");
        commonFunctions.isElementDisplayed(landingPageHeadline, 20);
        commonFunctions.sendKeys(landingPageHeadline, landing, 10, "landing page headline");
        commonFunctions.sendKeys(mobileAppNotificationHeadline, mobile, 10, "landing page headline");
        commonFunctions.sendKeys(browserNotificationHeadline, browser, 10, "landing page headline");
        commonFunctions.sendKeys(facebookHeadline, facebook, 10, "landing page headline");
        commonFunctions.sendKeys(twitterHeadline, twitter, 10, "landing page headline");
        if (!(domain.equals("Tech") || domain.equals("Hindi") || domain.equals("Bangla") || domain.equals("Auto") || domain.equals("Smart 24") || domain.equals("Mint Lounge"))) {
            commonFunctions.sendKeys(newsletterHeadline, newsletter, 10, "landing page headline");
        }
        isCustomHeadingUpdated = commonFunctions.clickElement(saveButtonHeadline, 10, "save button");
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
        return isCustomHeadingUpdated;
    }

    //Moved two methods to DashboardPage class,hence removed these from here: selectPaginationDropDown(), verifyPagination()

    @Override
    public boolean schedulePublishAndVerify() {
        boolean isScheduled;
        searchStoryByIDAndSelect(storyIdNumber);
        schedulePublish();
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isScheduled = commonFunctions.checkElementText(storyStatus, "SCHEDULED", 30, "Correct text is");
        return isScheduled;
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
        commonFunctions.checkElementText(ToastScheduleToBePublished, "End time of liveblog changed successfully", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
    }

    @Override
    public boolean verifyKeywordSearchTabOnTop(String searchKeyword) {
        commonFunctions.sendKeys(searchAllStoriesText, searchKeyword, 10, "search box");

        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 10);
        commonFunctions.clickElementIgnoringStaleElement(exactAllStoriesButton, 15, "exact icon button");

        ArrayList<String> arrayElementAllStories = new ArrayList<String>();
        arrayElementAllStories = commonFunctions.handleStaleElement(searchAllStoriesListItem);
        if (arrayElementAllStories.toString().toLowerCase().trim().contains(searchKeyword.toLowerCase().trim())) {
            Utils.logStepInfo(true, " Keyword search is matched in All Stories");
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyExactMatchSearchTabOnTop(String exactMatch) {
        searchAllStoriesText.clear();
        commonFunctions.sendKeys(searchAllStoriesText, exactMatch, 10, "search box");
        commonFunctions.clickElement(exactAllStoriesButton, 10, "exact icon button");
        ArrayList<String> arrayElementAllStories = new ArrayList<String>();
        arrayElementAllStories = commonFunctions.handleStaleElement(searchAllStoriesListItem);
        if (arrayElementAllStories.toString().toLowerCase().trim().contains(exactMatch.toLowerCase().trim())) {
            Utils.logStepInfo(true, " Exact keyword search is matched in All Stories");
            searchAllStoriesText.clear();
            return true;
        }
        return false;
    }

    @Override
    public boolean verifySpecialCharMatchSearchTabOnTop() {
        searchAllStoriesText.clear();
        boolean isSpecialCharMatched = false;
        String[] patternString = {"$", "@"};
        for (int searchElement = 0; searchElement < patternString.length; searchElement++) {
            commonFunctions.sendKeys(searchAllStoriesText, patternString[searchElement], 20, "search box");
            commonFunctions.sendKeysWithEnter(searchAllStoriesText, 10);
            ArrayList<String> arrayElementAllStories = new ArrayList<String>();
            arrayElementAllStories = commonFunctions.handleStaleElement(searchAllStoriesListItem);
            Pattern pattern = Pattern.compile(patternString[searchElement], Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(arrayElementAllStories.toString());
            if (matcher.find()) {
                Utils.logStepInfo(true, " Special char keyword search is matched");
                searchAllStoriesText.clear();
                isSpecialCharMatched = true;
            } else {
                isSpecialCharMatched = false;
            }
        }
        return isSpecialCharMatched;
    }

    @Override
    public boolean verifyMinCharMatchSearchTabOnTop(String minCharMatch) {
        boolean isStorySearched;
        searchAllStoriesText.clear();
        commonFunctions.sendKeys(searchAllStoriesText, minCharMatch, 10, "search box");
        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 10);
        ArrayList<String> arrayElementAllStories = new ArrayList<String>();
        arrayElementAllStories = commonFunctions.handleStaleElement(searchAllStoriesListItem);
        if (arrayElementAllStories.toString().toLowerCase().trim().contains(minCharMatch.toLowerCase().trim())) {
            Utils.logStepInfo(true, " min char keyword search is matched in All Stories");
            searchAllStoriesText.clear();
            isStorySearched = true;
        } else {
            Utils.logStepInfo(false, " min char keyword search is not matched in All Stories");
            isStorySearched = false;
        }
        return isStorySearched;
    }


    @Override
    public boolean verifyMaxCharMatchSearchTabOnTop(String maxCharMatch) {
        boolean isStorySearched;
        searchAllStoriesText.clear();
        commonFunctions.sendKeys(searchAllStoriesText, maxCharMatch, 20, "search box");
        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 10);
        ArrayList<String> arrayElementAllStories = new ArrayList<String>();
        arrayElementAllStories = commonFunctions.handleStaleElement(searchAllStoriesListItem);
        if (arrayElementAllStories.toString().toLowerCase().trim().contains(maxCharMatch.toLowerCase().trim())) {
            Utils.logStepInfo(true, " max chars keyword search is matched in All Stories");
            searchAllStoriesText.clear();
            isStorySearched = true;
        } else {
            Utils.logStepInfo(false, " max char keyword search is not matched in All Stories");
            isStorySearched = false;
        }
        return isStorySearched;
    }

    private void searchStoryByIDAndSelect(String id) {
        searchStoryByID(id);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
//        commonFunctions.isElementDisplayedAndPresent(selectedStory, 15, "dashboard item");
//        commonFunctions.waitForElementIgnoringStaleElement(selectedStory,20,"story list item");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
    }

    private void searchStoryByID(String id) {
        commonFunctions.sendKeysOnElementVisibility(searchAllStoriesText, "id:" + id, 30, "search box");
        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 30);
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementIgnoringStaleElement(exactAllStoriesButton, 30, "exact icon button");
    }

    public String setStoryId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
        return storyIdNumber;
    }

    @Override
    public boolean verifyMultipleImages() {
        boolean multipleImages = false;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.hardWait(10000);
        commonFunctions.isElementDisplayedAndPresent(inputAddByLineText, 20, "Wait got page load");
        if (multipleImagesList.size() > 1) {
            multipleImages = true;
        }
        return multipleImages;
    }

    @Override
    public boolean softPublishWithNewHeadline(String newHeadline) {
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(publishedDate, 30, "wait for time to be displayed");
        timeOnPublishedStory = getPublishedDateFromStoryParser();
        return softPublishStoryWithNewHeadline(newHeadline);
    }

    private boolean softPublishStoryWithNewHeadline(String newHeadline) {
        boolean isSoftPublished;
        boolean isReadabilityPopupAvailable;
        commonFunctions.sendKeys(enterHeadlineText, newHeadline, 20, "edit headline");
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.isElementDisplayedAndPresent(buttonSoftPublish, 10, "soft publish button");
        commonFunctions.clickElement(buttonSoftPublish, 10, "soft publish button");
        isSoftPublished = commonFunctions.isElementDisplayedAndPresent(toastSoftPublish, 10, "soft publish toaster");
        if (!isSoftPublished) {
            isReadabilityPopupAvailable = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopupAvailable) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 10, "Yes button on popup ");
                isSoftPublished = commonFunctions.checkElementText(toastSoftPublish, "Soft Published successfully", 7, "Correct text is");
            }
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isSoftPublished;
    }

    public Date getPublishedDateFromStoryParser() {

        String publishDate = publishedDate.getText();
        Date date = commonFunctions.getPublishedDateTime(publishDate);
        return date;
    }

    @Override
    public boolean createStoryWithAllInLineElements(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String embedUrl, String companyName, String tableInputData, String imageCaption, String domain) {
        boolean isStoryCreated;
        String storyIdNumber = createStandardStory(headline, summary, paragraph, byline, section, subsection, keyword, location, topic, embedUrl);
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        isStoryCreated = commonFunctions.waitAndGetElementTextAndCheck(storyStatus, "CREATED", 30, "Correct text is");
        this.storyIdNumber = storyIdNumber;
        return isStoryCreated;
    }

    private String createStandardStory(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String embedUrl) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        String storyId = commonFunctions.createStory(headline, summary, paragraph, subsection, byline,
                keyword, location,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);

        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        return storyId;
    }

    private void insertImage(String imageCaption) {
        commonFunctions.clickElementWithJS(buttonInsertImage, 30, "insert image button");
        commonFunctions.clickElementWithJS(imagePicFromLib, 30, "pick From Image Library");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "listview image icon button");
        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab, 20, "images loading");
        for (int i = 0; i <= listOfImagesInListTab.size() - 1; i++) {
            if ((listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws"))) {
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i), 20, "Click on Image having src .jpg");
                break;
            }

        }
        commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 5, "image cropping ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        if (!commonFunctions.isElementDisplayedAndPresent(captionSubmitButton, 15, "caption submit button")) {
            commonFunctions.scrollPageWithJS(buttonEditForImage, 20);
            commonFunctions.isElementDisplayedAndPresent(buttonEditForImage, 20, "edit icon");
            commonFunctions.clickElementIfDisplayed(buttonEditForImage, 10, "image edit ");
            commonFunctions.isElementDisplayedAndPresent(captionSubmitButton, 15, "caption submit button");
            commonFunctions.isElementDisplayedAndPresent(addCaptionForImage, 20, "caption field");
        }
        commonFunctions.scrollPageWithJS(captionSubmitButton, 20);
        commonFunctions.isElementDisplayedAndPresent(addTitleForImage, 20, "image title field");
        commonFunctions.clickElementIfDisplayed(addCaptionForImage, 20, "caption clickable");
        if (addCaptionForImage.getText().length() > 0) {
            addCaptionForImage.clear();
        }
        commonFunctions.sendKeyWithActions(addCaptionForImage, imageCaption);
        commonFunctions.checkElementText(addCaptionForImage, imageCaption, 30, "caption image matched");
        commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 5, "image cropping done");
        commonFunctions.clickElementIfDisplayed(addTitleForImage, 20, "image title field");
        commonFunctions.scrollPageWithJS(captionSubmitButton, 20);
        commonFunctions.clickElementWithJS(captionSubmitButton, 30, "caption submit button");
        commonFunctions.clickElementIfDisplayed(captionSubmitButton, 10, "caption submit button");
        commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 5, "image cropping done");
        imageSrcValue = commonFunctions.getAttributeValue(imageSrc, 30, "src");
        System.out.println(imageSrcValue);
    }

    public void verifyInsertEmbed(String embedUrl) {
        commonFunctions.clickElementIfDisplayed(inputAddByLineText, 20, "byline");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementWithJS(buttonInsertEmbed, 20, "insert embed icon");
        commonFunctions.sendKeys(inputAddEmbedUrl, embedUrl, 15, "embed textbox");
        commonFunctions.clickElement(buttonSubmitEmbed, 15, "submit embed button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
    }

    private void insertRelatedStory(String domain) {
        if (domain.equals("Live Mint")) {
            commonFunctions.clickElementIfDisplayed(inputAddByLineText, 20, "byline");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
            commonFunctions.isElementDisplayedAndPresent(buttonRelatedStory, 30, "related story");
            commonFunctions.clickElementWithJS(buttonRelatedStory, 25, "insert related story icon button");
            if (commonFunctions.isElementDisplayedAndPresent(listRelatedStory, 20, "related story list cell")) {
                commonFunctions.clickElementWithJS(listRelatedStory, 40, "related story list cell");
                commonFunctions.clickElementWithJS(buttonSubmitForRelatedStory, 15, "submit button");
            }
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        }
    }

    private void insertTable(String tableInputData, String domain) {
        commonFunctions.clickElementIfDisplayed(inputAddByLineText, 20, "byline");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementWithJS(insertTable, 30, "insert Table");
        commonFunctions.clickElementIfDisplayed(insertTableInputBox, 20, "table input box");
        commonFunctions.sendKeyWithActions(insertTableInputBox, tableInputData);
        if (domain.equals("Live Mint")) {
            commonFunctions.clickElementWithJS(insertTableDoneButton, 30, "done button insert Table");
        }
        if (domain.equals("Bangla")) {
            commonFunctions.clickElementWithJS(scorecardMatchDetailDoneButton, 30, "done button insert Table");
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
    }

    private void insertVideo() {
        commonFunctions.clickElementWithJS(buttonInsertVideo, 30, "insert video");
        commonFunctions.isElementDisplayedAndPresent(firstVideoOnVideoPage, 20, "Mouse Hover to First video");
        commonFunctions.moveToElementWithActions(firstVideoOnVideoPage, 20, "Mouse Hover to First video");
        commonFunctions.clickElementWithJS(useVideo, 30, "use video");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
    }

    private void insertMarket(String companyName) {
        if (commonFunctions.isElementDisplayedAndPresent(buttonInsertMarket, 10, "insert market")) {
            commonFunctions.clickElementWithJS(buttonInsertMarket, 30, "insert market");
            commonFunctions.clickElementIfDisplayed(marketCompanyNameInputBox, 20, "company box");
            commonFunctions.sendKeysOnElementVisibility(marketCompanyNameInputBox, companyName, 30, "company name");
            commonFunctions.isElementDisplayedAndPresent(inputAddByLineSuggestionPopup, 80, "Wait for Auto Sugestion popup displayed");
            commonFunctions.clickElementWithJS(marketCompanyNameInputData, 30, "company name ");
            commonFunctions.clickElementWithJS(insertTableDoneButton, 30, "done button company");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        }
    }

    private void insertScorecard() {
        if (commonFunctions.isElementDisplayedAndPresent(insertScorecard, 15, "insert Scorecard button")) {
            commonFunctions.clickElementWithJS(insertScorecard, 30, "insert Scorecard button");
            commonFunctions.clickElementWithJS(scorecardSearchSeries, 30, "search series box");
            commonFunctions.isElementDisplayedAndPresent(inputAddByLineSuggestionPopup, 10, "series name");
//            commonFunctions.clickElementWithJS(scorecardSearchSeries, 30, "search series box");
//            commonFunctions.isElementDisplayedAndPresent(scorecardAutosuggestionSeriesName, 50, "autosuggestion Series Name");
            commonFunctions.clickElementWithJS(scorecardAutosuggestionFirstSeriesName, 30, "Autosuggestion First Series Name");
            commonFunctions.isElementDisplayedWithoutTryCatch(scorecardSelectMatchDropDown, 30, "scorecard Select Match DropDown");
            Select dropDown = new Select(scorecardSelectMatchDropDown);
            dropDown.selectByIndex(1);
            commonFunctions.clickElementWithJS(scorecardMatchDetailDoneButton, 30, "match detail done button");
        }
    }

    private void insertChart(String domain) {
        if (domain.equals("Live Mint")) {
            commonFunctions.clickElementWithJS(insertChartIcon, 30, "chart icon");
            commonFunctions.isElementDisplayedAndPresent(firstChartPosition, 20, "Mouse Hover to First chart");
            commonFunctions.moveToElementWithActions(firstChartPosition, 20, "Mouse Hover to First chart");
            commonFunctions.clickElementWithJS(useVideo, 30, "use video");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        }
    }

    private void insertPdf() {
        commonFunctions.clickElementIfDisplayed(inputAddByLineText, 20, "byline");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementIfDisplayed(insertPdf, 10, "insert pdf");
        String filePath = System.getProperty("user.dir") + ".\\src\\main\\resources\\insertPdf-converted.pdf";
        commonFunctions.uploadFile(filePath);
        commonFunctions.isElementDisplayedWithoutTryCatch(popupPdfButton, 20, "pdf toaster massage");
    }

    @Override
    public boolean createStandardStoryWithAddingInLineEmbedInBetweenParagraph(String headline, String summary, String firstParagraphData, String secondParagraphData, String embedUrl, String section, String subsection, String topic, String keyword, String location, String byline) {
        boolean isStoryCreated;
        createStoryWithAddingInLineEmbedInBetweenParagraph(headline, summary, firstParagraphData, secondParagraphData, embedUrl, section, subsection, topic, keyword, location, byline);
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        isStoryCreated = commonFunctions.waitAndGetElementTextAndCheck(storyStatus, "CREATED", 30, "Correct text is");
        return isStoryCreated;
    }

    private boolean createStoryWithAddingInLineEmbedInBetweenParagraph(String headline, String summary, String firstParagraphData, String secondParagraphData, String embedUrl, String section, String subsection, String topic, String keyword, String location, String byline) {
        boolean isShowing;
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headline);
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        inputSummary(summary);
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        inputParagraph(firstParagraphData);
        isShowing = paragraphHeaderH2AndHeaderH3(firstParagraphData);
        isShowing &= addingInLineEmbedInBetweenParagraph(embedUrl, secondParagraphData, firstParagraphData);
        inputSection(section);
        inputSubSection(subsection);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        inputByLine(byline);
        saveStandardStoryAndVerify();
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        return isShowing;
    }

    private boolean paragraphHeaderH2AndHeaderH3(String firstParagraphData) {
        boolean isShowing;
        isShowing = commonFunctions.checkElementText(firstParagraph, firstParagraphData, 20, " first paragraph text");
        commonFunctions.clickElementWithJS(firstParagraphHDropdown, 30, "first paragraph H dropdown");
        commonFunctions.clickElementWithJS(firstParagraphHeadline2, 30, "paragraph headline 2");
        isShowing &= commonFunctions.checkElementText(firstParagraphH2Text, firstParagraphData, 20, " H2 first paragraph text");
        commonFunctions.clickElementWithJS(firstParagraphHDropdown, 30, "first paragraph H dropdown");
        commonFunctions.clickElementWithJS(firstParagraphHeadline3, 30, "paragraph headline 3");
        isShowing &= commonFunctions.checkElementText(firstParagraphH3Text, firstParagraphData, 20, " H3 first paragraph text");
        commonFunctions.clickElementWithJS(firstParagraphHDropdown, 30, "first paragraph H dropdown");
        commonFunctions.clickElementWithJS(firstParagraphParagraphText, 30, " Text Paragraph");
        isShowing &= commonFunctions.checkElementText(firstParagraph, firstParagraphData, 20, "first paragraph text");
        return isShowing;
    }

    private boolean addingInLineEmbedInBetweenParagraph(String embedUrl, String secondParagraphData, String firstParagraphData) {
        boolean isShowing;
        commonFunctions.clickElementIfDisplayed(firstParagraph, 20, "paragraph text");
        commonFunctions.sendKeysWithEnter(firstParagraph, 20);
        commonFunctions.sendKey(secondParagraph, secondParagraphData, 25);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.clickElementIfDisplayed(inputAddByLineText, 20, "byline");
        commonFunctions.isElementDisplayedAndPresent(firstParagraph, 20, "first paragraph");
        commonFunctions.clickElementIfDisplayed(firstParagraph, 20, " first paragraph");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
        commonFunctions.clickElementWithJS(buttonInsertEmbed, 20, "insert embed icon");
        commonFunctions.sendKeys(inputAddEmbedUrl, embedUrl, 15, "embed textbox");
        commonFunctions.clickElement(buttonSubmitEmbed, 15, "submit embed button");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        isShowing = commonFunctions.checkElementText(firstParagraph, firstParagraphData, 20, "first paragraph text");
        isShowing &= commonFunctions.checkElementText(secondParagraph, secondParagraphData, 20, "second paragraph text after inline embed");
        return isShowing;
    }

    @Override
    public boolean selectPublishedStoryAndVerifyLastModifiedInfo(String userIdG, String passwordG, String expectedUserNameG, String userIdQA, String passQA, String eUserNameQA, String storyType, String newHeadline, String createdBy, String domain) {
        boolean isShowing = true;
        isShowing &= loginPage.logout();
        isShowing &= loginPage.loginWithId(userIdG, passwordG, expectedUserNameG);
        dashboardPage.clickOnDashboard();
        dashboardPage.domainSelection(domain);
        String[] userName = commonFunctions.getElementText(userNameLabelAfterLogin, 20).split("\\R");
        String loginUserName = userName[userName.length - 2];
        commonFunctions.isElementDisplayedAndPresent(dropDownRecordListInPagination, 20, "drop down pagination");
        Select dropDown = new Select(dropDownRecordListInPagination);
        dropDown.selectByVisibleText("200");
        isShowing &= dashboardPage.publishedStory(storyType);
        dashboardPage.createdByFilter(createdBy);
        commonFunctions.isElementDisplayedAndPresent(listOfUpdatedBy, 20, "list of updated by ");
        for (int i = 0; i <= listOfUpdatedBy.size() - 1; i++) {
            if (!(listOfUpdatedBy.get(i).getText().trim().equalsIgnoreCase(loginUserName))) {
                commonFunctions.clickElementIfDisplayed(listOfUpdatedBy.get(i), 20, "Click on published story");
                break;
            }
        }
        String lastModifiedByBeforeEdit = commonFunctions.getElementText(lastModifiedBy, 20);
        String lastModifiedAtBeforeEdit = commonFunctions.getElementText(lastModifiedAt, 20);
        commonFunctions.clickElementIfDisplayed(popupYesForLockedStoryOnPage, 3, "popup Yes for Locked Stories");
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        commonFunctions.sendKeys(enterHeadlineText, newHeadline, 20, "edit headline");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        saveStandardStoryAndVerify();
        String lastModifiedByAfterEdit = commonFunctions.getElementText(lastModifiedBy, 20);
        String lastModifiedAtAfterEdit = commonFunctions.getElementText(lastModifiedAt, 20);
        if (lastModifiedByBeforeEdit != lastModifiedByAfterEdit && lastModifiedAtBeforeEdit != lastModifiedAtAfterEdit && lastModifiedByAfterEdit.trim().equalsIgnoreCase(expectedUserNameG)) {
            Utils.logStepInfo(true, "last Modified Info is verified !!!!!!");
            isShowing &= true;
        } else {
            Utils.logStepInfo(false, "last Modified Info is Not verified !!!!!!!");
            isShowing &= false;
        }
        dashboardPage.clickOnBlankPaperLogo();
        isShowing &= loginPage.logout();
        isShowing &= loginPage.loginWithId(userIdQA, passQA, eUserNameQA);
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    @Override
    public boolean changeUrlAndPublishStory(String urlHeadline, String domain) {
        boolean isShowing = true;
        searchStoryByIDAndSelect(storyIdNumber);
        dashboardPage.changeUrl(urlHeadline, domain);

        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
        publishStoryAndVerify();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        isShowing &= commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isShowing;
    }

    @Override
    public boolean metaDataValues(String headline, String summary) {
        boolean isShowing;
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "story list item");
        //TODO: meta title,description text is not present in DOM,hence we can,t validate.
//        isShowing = commonFunctions.checkElementText(,headline, 20, "meta Title field");
//        isShowing &= commonFunctions.checkElementText(, summary,20, "meta Description field");
        commonFunctions.clickElementWithJS(sponsoredButton, 20, "sponsored Button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementWithJS(markUnImportantButton, 20, "mark UnImportant Button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        isShowing = commonFunctions.isElementDisplayedIgnoringStaleElementWithCatch(sponsoredIcon, 20, "sponsored Icon");
        isShowing &= commonFunctions.isElementDisplayedIgnoringStaleElementWithCatch(unImportantIcon, 20, "unImportant Icon");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
        commonFunctions.clickElementWithJS(breakingNewsButton, 20, "breaking News Button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        isShowing &= commonFunctions.isElementDisplayedIgnoringStaleElementWithCatch(breakingNewsIcon, 20, "breaking News Icon");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
        commonFunctions.clickElementWithJS(bigStoryButton, 20, "big Story Button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;

    }

    @Override
    public boolean EditorMetaDataValues(String headline, String summary) {
        boolean isShowing;
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "story list item");
        commonFunctions.clickElementWithJS(EditorPickButton, 20, "Mark As Editors Pick");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        searchStoryByID(storyIdNumber);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "story list item");
        commonFunctions.clickElementWithJS(EditorPickButton, 20, "Mark As Editors Pick");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        searchStoryByID(storyIdNumber);
        isShowing = commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");

        return isShowing;
    }

    @Override
    public boolean BlogMetaDataValues(String headline, String summary) {
        boolean isShowing;
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "story list item");
        commonFunctions.clickElementWithJS(BlogButton, 20, "Mark As Blog");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        searchStoryByID(storyIdNumber);
        isShowing = commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        return isShowing;
    }


    @Override
    public boolean PremiumMetaDataValues(String headline, String summary) {
        boolean isShowing;
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "story list item");
        commonFunctions.clickElementWithJS(PremiumButton, 20, "Mark As Premium");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        searchStoryByID(storyIdNumber);
        isShowing = commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        return isShowing;
    }

    @Override
    public boolean specialsMetaDataValues(String headline, String summary) {
        boolean isShowing;
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "story list item");
        commonFunctions.scrollPageWithJS(SpecialsButton, 20);
        commonFunctions.clickElementWithJS(SpecialsButton, 20, "Mark As Specials");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        dashboardPage.clickOnBlankPaperLogo();
        searchStoryByID(storyIdNumber);
        isShowing = commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "story Status");
        return isShowing;
    }

    public boolean verifyThatUserCanAddLeadImageForVideoTasks() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean uploadVideoIconVisiblityStatus = commonFunctions.isElementDisplayed(uploadVideoIcon, 10, "Video Icon");
        commonFunctions.clickElement(uploadVideoIcon, 10, "Video Icon");
        commonFunctions.isElementDisplayed(uploadVideo, 10, "Video");
        commonFunctions.mouseHoverOnElement(uploadVideo, 20, "Video");
        commonFunctions.clickElement(useVideoButton, 10, "Use Video Button");
        commonFunctions.clickElement(doneButton, 10, "Done Button");
        commonFunctions.switchToFrame(uploadedFrame, 10);
        boolean uploadVideoVisiblityStatus = commonFunctions.isElementPresent(uploadedVideo, 20);

        return uploadVideoIconVisiblityStatus && uploadVideoVisiblityStatus;
    }

    @Override
    public boolean checkUsernameToBeShownWithEachVersion(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String userName) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        String storyId = commonFunctions.createStory(headline, summary, paragraph, subsection, byline,
                keyword, location,
                allChangesSaved, enterHeadlineText, addSummaryText,
                addParagraphText, inputAddSubSectionText, inputAddByLineText,
                inputAddLocationText, inputAddKeywordText,
                saveButton, toastSaveButton);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        addImageCaption("lead media image");
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        if (commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }
        commonFunctions.hardWait(5000);
        commonFunctions.moveToElementWithActions(storyTimeline, 10, "Story Timeline");
        int count = publishStory.size();
        commonFunctions.inputLocation("Delhi", inputAddLocationText);
        commonFunctions.isElementDisplayed(softAssertionEclipse, 10, "Soft Assertion Eclipse");
        commonFunctions.moveToElementWithActions(softAssertionEclipse, 10, "Soft Assertion Eclipse");
        commonFunctions.clickElement(softAssertionEclipse, 10, "Soft Assertion Eclipse");
        commonFunctions.isElementDisplayed(softAssertionButton, 10, "Soft Assertion Button");
        commonFunctions.clickElement(softAssertionButton, 10, "Soft Assertion Button");
        if (commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }
        commonFunctions.hardWait(5000);
        boolean storyTimelineStatus = publishStory.size() == count + 1;
        boolean stortTimelineUserNameStatus = storyTimelineUser.getText().trim().equalsIgnoreCase(userName.trim());
        return storyTimelineStatus && stortTimelineUserNameStatus;
    }

    @Override
    public boolean checkResizeImagesInFourAndThreeAspectRatio() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Tech", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(imgIcon, 10, "Image");
        commonFunctions.clickElement(imgIcon, 10, "Image");

        commonFunctions.isElementDisplayed(chouseIcon, 10, "Lib Image");
        commonFunctions.clickElement(chouseIcon, 10, "Lib Image");

        commonFunctions.isElementDisplayed(recentImage, 10, "Lib Image");
        commonFunctions.mouseHoverOnElement(recentImage, 10, "Lib Image");

        commonFunctions.isElementDisplayed(useImage, 10, "Use Button");
        commonFunctions.clickElement(useImage, 10, "Use Button");

        if (commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }

        return commonFunctions.isElementDisplayed(fourThreeRatio, 10, "4:3 dimension image to crop");

    }

    @Override
    public boolean checkThatUserCanSelectOneOrMultipleStoriesFromTheListOfStories() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Tech", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        commonFunctions.isElementDisplayed(relatedStoryIcon, 10, "Related Story Icon");
        commonFunctions.clickElementWithJS(relatedStoryIcon, 10, "Related Story Icon");
        commonFunctions.dummyWait(10);
        commonFunctions.isElementDisplayed(relatedSearchBox, 20, "Related Search Box");

        commonFunctions.isElementDisplayed(relatedActionCheckBox.get(0), 10, "Related Action Check Box");
        boolean firstActionCheckBox = commonFunctions.clickElementWithJS(relatedActionCheckBox.get(0), 10, "Related Action Check Box");

        commonFunctions.isElementDisplayed(relatedActionCheckBox.get(1), 10, "Related Action Check Box");
        boolean secoundActionCheckBox = commonFunctions.clickElementWithJS(relatedActionCheckBox.get(1), 10, "Related Action Check Box");
        commonFunctions.isElementDisplayed(relatedActionCheckBox.get(2), 10, "Related Action Check Box");
        boolean thirdActionCheckBox = commonFunctions.clickElementWithJS(relatedActionCheckBox.get(2), 10, "Related Action Check Box");

        return firstActionCheckBox && secoundActionCheckBox && thirdActionCheckBox;
    }

    @Override
    public boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnStadardStoryTheSameDataIsPresentInMetatitleOrNot() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectStandardStory();
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
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        String inputHeadingText = "Test Meta Title " + commonFunctions.generateRandomNum();
        commonFunctions.inputSummary(inputHeadingText, addSummaryText);
        commonFunctions.scrollToElement(metaDescText, "Meta Description Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaDescText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Description");


    }

    @Override
    public boolean checkThatStandardStoryDataGoesToMasterDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.isElementPresent(popupPublishButton, 20);
        System.out.println("id:- " + storyIdNumber);
        return dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", storyIdNumber, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline);
    }

    @Override
    public boolean checkThatUserCanEditDisclaimer(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String disclaimer) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Tech", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.isElementPresent(popupPublishButton, 20);

        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.hardWait(3000);
        commonFunctions.selectStory(headLine, searchAllStoriesText, searchButton, resultList);
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(editDisclaimerCheckBox, 10);
        commonFunctions.clickElementWithJS(editDisclaimerCheckBox, 20, "Edit Disclaimer Check Box");
        commonFunctions.sendKeys(disclaimerTextArea, disclaimer, 20, "Disclaimer");
        commonFunctions.clickElement(saveButton, 30, "save story button");
        commonFunctions.isElementDisplayed(toastSaveButton, 20, "Toast message for saved status is");
        commonFunctions.dummyWait(3);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(disclaimerTextArea, 10, "ng-reflect-model"), disclaimer.trim(), "Disclaimer");
    }

    @Override
    public boolean checkPodcastCarouselShouldBePresent() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Live Mint", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.isElementDisplayed(spImgPodcastIcon, 10, "Podcast Icon");
    }

    @Override
    public boolean checkPodcastShouldBeAddedToTheStory() {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Live Mint", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(spImgPodcastIcon, 10, "Podcast Icon");
        commonFunctions.clickElement(spImgPodcastIcon, 10, "Podcast Icon");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(podCastEpisodesList.get(0), 20, "Podcast Cast Episode");
        commonFunctions.mouseHoverOnElement(podCastEpisodesList.get(0), 10, "Podcast Cast Episode");
        commonFunctions.isElementDisplayed(usePodcastButtonList.get(0), 10, "Use Podcast Cast Button");
        commonFunctions.clickElement(usePodcastButtonList.get(0), 10, "Use Podcast Cast Button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(podcastBlockList, 10, "Podcast Block");
    }

    @Override
    public boolean checkIconInsertHowToStoryPresentInTheInlineElements(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.dummyWait(3);
        commonFunctions.selectStory(headLine, searchAllStoriesText, searchButton, resultList);
        commonFunctions.dummyWait(3);
        return commonFunctions.isElementPresent(buttonRelatedStoryList.get(1), 20);
    }

    public boolean createStdStory(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();

        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(2000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        return commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);
    }

    @Override
    public boolean checkAllHowToStoriesDisplayedInListing(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.hardWait(3000);
        commonFunctions.refreshPage();
        commonFunctions.hardWait(5000);
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(buttonRelatedStoryList.get(1), 10, "Insert how to story Icon");
        commonFunctions.clickElement(buttonRelatedStoryList.get(1), 10, "Insert how to story Icon");
        commonFunctions.sendKeys(searchTextInRelatedStories,headLine,10,"headline text");
        commonFunctions.sendKeysWithEnter(searchTextInRelatedStories,10);
        boolean result=commonFunctions.getElementTextAndCheck(SectionTextInRelatedStories,"How to",10,"section text");
        commonFunctions.clickElementWithJS(contentListCloseButton,10);
        commonFunctions.hardWait(2000);
        return result;
    }

    public boolean allRelatedStoriesDisplayedInListing(String section) {
        boolean flag = false;
        commonFunctions.isElementDisplayed(contentList.get(0), 10, "Data List");
        boolean contentListStatus = contentList.size() > 0;

        for (int i = 0; i < contentList.size(); i++) {
            List<WebElement> liList = contentList.get(i).findElements(By.tagName("li"));
            commonFunctions.scrollPageWithJS(liList.get(3), 10);
            if (liList.get(3).getText().trim().equalsIgnoreCase(section.trim()) || liList.get(3).getText().trim().contains("How") || liList.get(3).getText().trim().contains("how")) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return contentListStatus && flag;
    }

    public boolean storyDisplayedInListing(String headLine, boolean selectStatus) {
        boolean flag = false;
        commonFunctions.isElementDisplayed(contentList.get(0), 10, "Data List");

        for (int i = 0; i < contentList.size(); i++) {
            List<WebElement> liList = contentList.get(i).findElements(By.tagName("li"));
            commonFunctions.scrollPageWithJS(liList.get(0), 10);
            if (liList.get(0).getText().trim().equalsIgnoreCase(headLine.trim())) {
                flag = true;
                if (selectStatus) {
                    commonFunctions.clickElement(liList.get(0), 10, headLine + " story");
                }
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean checkUserShouldBeAbleToAddHowToStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.dummyWait(3);
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(buttonRelatedStoryList.get(1), 10, "Insert how to story Icon");
        commonFunctions.clickElement(buttonRelatedStoryList.get(1), 10, "Insert how to story Icon");
        storyDisplayedInListing(headLine, true);
        commonFunctions.scrollPageWithJS(contentListChoseButton, 10);
        commonFunctions.clickElement(contentListChoseButton, 10, "Choose Story");
        commonFunctions.dummyWait(3);
        return commonFunctions.checkTextEquals(headLine.trim(), commonFunctions.getElementText(howToStoryLabel, headLine.trim(), 10).trim(), "How to story label");
    }


    @Override
    public boolean StoryMatchPopup(String headline, String summary) {
        boolean isShowing;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.hardWait(5000);
        commonFunctions.isElementDisplayed(ellipsis, 60, "three dot button");
        commonFunctions.clickElementWithJS(buttonPublish, 40, "publish story");
        commonFunctions.hardWait(2000);
        isShowing = commonFunctions.isElementPresentWithTryCatch(matchingValidationMsgs, 20) || commonFunctions.isElementPresentWithTryCatch(matchingValidationMsg, 20);
        return isShowing;
    }

    @Override
    public boolean checkTextBoxesWithHeadersH2AndH3(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.dummyWait(3);
        commonFunctions.selectStory(headLine, searchAllStoriesText, searchButton, resultList);
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresent(plusIconHeading, 20);
        commonFunctions.clickElement(plusIconHeading, 10, "Plus Icon");
        return commonFunctions.checkElementTextWithEqualIgnoreCase(commonFunctions.getElementText(plusHeadingH2).trim(), "H2", "H2 Header")
                && commonFunctions.isElementPresent(plusHeadingH2Text, 10)
                && commonFunctions.checkElementTextWithEqualIgnoreCase(commonFunctions.getElementText(plusHeadingH3).trim(), "H3", "H3 Header")
                && commonFunctions.isElementPresent(plusHeadingH3Text, 10);
    }

    @Override
    public boolean verifyUserCanCreateStandardStoryWithHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        return createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
    }

    @Override
    public boolean checkQuickReadMaxAndMinLimitForAutomatedQuickRead(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String oneWord, String fourtyNineWord, String fiftyWord, String hundredWord, String hundredAndOneWord) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(plusIconSummary, 10);
        commonFunctions.clickElement(plusIconSummary, 10, "Plus Icon");
        commonFunctions.isElementPresentWithTryCatch(quickReadSummary, 10);
        commonFunctions.sendKeys(quickReadSummary, oneWord, 10, "Quick Read Summary");
        boolean errorStatus = commonFunctions.isElementPresentWithTryCatch(quickSummaryError, 10);
        boolean saveButtonStatus = commonFunctions.checkElementEnableDisable("Disable", quickSummarySave, 10, "Quick Summary Save Button");
        commonFunctions.sendKeys(quickReadSummary, fourtyNineWord, 10, "Quick Read Summary");
        errorStatus &= commonFunctions.isElementPresentWithTryCatch(quickSummaryError, 10);
        saveButtonStatus &= commonFunctions.checkElementEnableDisable("Disable", quickSummarySave, 10, "Quick Summary Save Button");
        commonFunctions.sendKeys(quickReadSummary, fiftyWord, 10, "Quick Read Summary");
        errorStatus &= !commonFunctions.isElementPresentWithTryCatch(quickSummaryError, 10);
        saveButtonStatus &= commonFunctions.checkElementEnableDisable("Enable", quickSummarySave, 10, "Quick Summary Save Button");
        commonFunctions.sendKeys(quickReadSummary, hundredWord, 10, "Quick Read Summary");
        errorStatus &= !commonFunctions.isElementPresentWithTryCatch(quickSummaryError, 10);
        saveButtonStatus &= commonFunctions.checkElementEnableDisable("Enable", quickSummarySave, 10, "Quick Summary Save Button");
        commonFunctions.sendKeys(quickReadSummary, hundredAndOneWord, 10, "Quick Read Summary");
        errorStatus &= commonFunctions.isElementPresentWithTryCatch(quickSummaryError, 10);
        saveButtonStatus &= commonFunctions.checkElementEnableDisable("Disable", quickSummarySave, 10, "Quick Summary Save Button");

        return errorStatus && saveButtonStatus;
    }

    @Override
    public boolean checkQuickReadMinimumLimitFifty(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String fourtyNineWord) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(plusIconSummary, 10);
        commonFunctions.clickElement(plusIconSummary, 10, "Plus Icon");
        commonFunctions.isElementPresentWithTryCatch(quickReadSummary, 10);
        commonFunctions.sendKeys(quickReadSummary, fourtyNineWord, 10, "Quick Read Summary");
        commonFunctions.dummyWait(3);
        boolean errorStatus = commonFunctions.isElementPresentWithTryCatch(quickSummaryError, 10);
        boolean saveButtonStatus = commonFunctions.checkElementEnableDisable("Disable", quickSummarySave, 10, "Quick Summary Save Button");
        return errorStatus && saveButtonStatus;
    }

    @Override
    public boolean checkQuickReadMaximumLimitHundred(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String hundredAndOneWord) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(plusIconSummary, 10);
        commonFunctions.clickElement(plusIconSummary, 10, "Plus Icon");
        commonFunctions.isElementPresentWithTryCatch(quickReadSummary, 10);
        commonFunctions.sendKeys(quickReadSummary, hundredAndOneWord, 10, "Quick Read Summary");
        commonFunctions.dummyWait(3);
        boolean errorStatus = commonFunctions.isElementPresentWithTryCatch(quickSummaryError, 10);
        boolean saveButtonStatus = commonFunctions.checkElementEnableDisable("Disable", quickSummarySave, 10, "Quick Summary Save Button");
        return errorStatus && saveButtonStatus;
    }

    @Override
    public boolean checkRecipeIconOnInlineElementBar(String property, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputParagraph(paragraph);
        commonFunctions.clickElement(addSummaryText, 10, "Add Summary Text");
        boolean repiceIconStatus = commonFunctions.isElementPresentWithTryCatch(recipaIcon, 10);
        commonFunctions.clickElementWithJS(recipaIcon, 10, "Recipa Icon");
        boolean recipeNameStatus = commonFunctions.isElementPresentWithTryCatch(recipeName, 10);
        return repiceIconStatus & recipeNameStatus;
    }

    @Override
    public boolean checkMandatoryFieldValidationForRecipe(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String recipeName, String stepInformation, String nameErrorMsg, String stepErrorMsg) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.dummyWait(5);
        return checkMandatoryFieldsForRecipe(recipeName, stepInformation, nameErrorMsg, stepErrorMsg);
    }

    public boolean checkMandatoryFieldsForRecipe(String recName, String stepInformation, String nameErrorMsg, String stepErrorMsg) {
        commonFunctions.clickElementWithJS(recipaIcon, 10, "Recipa Icon");
        commonFunctions.isElementPresentWithTryCatch(recipeName, 10);
        commonFunctions.clickElementWithJS(recipeDoneButton, 10, "Recipe Done Button");
        boolean errorMessageStatus = commonFunctions.checkElementText(recipeReqMsg, nameErrorMsg.trim(), 10, "Name Error Msg") && commonFunctions.checkElementText(recipeReqErrorMsg, stepErrorMsg.trim(), 10, "Step Error Msg");
        commonFunctions.sendKeys(recipeName, recName, 10, "Recipe Name");
        commonFunctions.clickElementWithJS(recipeDoneButton, 10, "Recipe Done Button");
        errorMessageStatus &= commonFunctions.checkElementText(recipeReqMsg, stepErrorMsg.trim(), 10, "Step Error Msg");
        commonFunctions.scrollPageWithJS(recipeStepText, 10);
        commonFunctions.sendKeys(recipeStepText, stepInformation, 10, "Step Information");
        commonFunctions.clickElementWithJS(recipeDoneButton, 10, "Recipe Done Button");
        commonFunctions.dummyWait(3);
        errorMessageStatus &= !commonFunctions.isElementPresentWithTryCatch(recipeReqMsg, 10) && !commonFunctions.isElementPresentWithTryCatch(recipeReqErrorMsg, 10);
        commonFunctions.scrollPageWithJS(recipeBlock, 10);
        boolean recipeBlockStatus = commonFunctions.isElementPresentWithTryCatch(recipeBlock, 10);
        return errorMessageStatus && recipeBlockStatus;
    }

    @Override
    public boolean checkElementSavingForRecipe(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String recipName, String stepInformation, String recipeDescription, String recipeYield, String recipePreparationHour, String recipePreparationMinute, String recipeCookingHour, String recipeCookingMinute, String recipeTotalHour, String recipeTotalMinute, String recipeIngredients, String recipeCuisine, String recipeCategory, String recipeKeywords) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.dummyWait(5);
        inputRecipeData(recipName, stepInformation, recipeDescription, recipeYield, recipePreparationHour, recipePreparationMinute, recipeCookingHour, recipeCookingMinute, recipeTotalHour, recipeTotalMinute, recipeIngredients, recipeCuisine, recipeCategory, recipeKeywords);
        selectRecipeImageFromLibrary();
        commonFunctions.dummyWait(3);
        commonFunctions.clickElementWithJS(recipeDoneButton, 10, "Recipe Done Button");
        commonFunctions.dummyWait(5);
        return validateRecipeSavedValue(recipName, stepInformation, recipeDescription, recipeYield, recipePreparationHour, recipePreparationMinute, recipeCookingHour, recipeCookingMinute, recipeTotalHour, recipeTotalMinute, recipeIngredients, recipeCuisine, recipeCategory, recipeKeywords);
    }

    @Override
    public boolean checkChangesAreSavingForRecipe(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String recipName, String stepInformation, String recipeDescription, String recipeYield, String recipePreparationHour, String recipePreparationMinute, String recipeCookingHour, String recipeCookingMinute, String recipeTotalHour, String recipeTotalMinute, String recipeIngredients, String recipeCuisine, String recipeCategory, String recipeKeywords, String recipeUpdateName, String recipeUpdateDesc) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        if(commonFunctions.isElementDisplayedWithExceptionHandling(leadImage,10,"lead image")) {
            commonFunctions.clickElementIfDisplayed(buttonDeleteIconForImage,10,"delete image");
        }
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.hardWait(5000);
        inputRecipeData(recipName, stepInformation, recipeDescription, recipeYield, recipePreparationHour, recipePreparationMinute, recipeCookingHour, recipeCookingMinute, recipeTotalHour, recipeTotalMinute, recipeIngredients, recipeCuisine, recipeCategory, recipeKeywords);
        commonFunctions.hardWait(3000);
        commonFunctions.clickElementWithJS(recipeDoneButton, 10, "Recipe Done Button");
        commonFunctions.hardWait(5000);
        editRecipeNameAndDescription(recipeUpdateName, recipeUpdateDesc);
        commonFunctions.clickElementWithJS(recipeDoneButton, 10, "Recipe Done Button");
        commonFunctions.hardWait(5000);
        return validateUpdatedRecipeNameAndDescription(recipeUpdateName, recipeUpdateDesc);
    }

    @Override
    public boolean checkSendNotificationLinkIsClickable(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationLinkClickableStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        return sendNotificationLinkClickableStatus;

    }

    public boolean validateUpdatedRecipeNameAndDescription(String recipeUpdateName, String recipeUpdateDesc) {
        commonFunctions.scrollPageWithJS(recipeNameValue, 10);
        boolean recipeNameStatus = commonFunctions.checkElementTextWithTryCatch(recipeNameValue, recipeUpdateName, 10, "recipName");
        commonFunctions.scrollPageWithJS(recipeDescriptionValue, 10);
        boolean recipeDescriptionStatus = commonFunctions.checkElementTextWithTryCatch(recipeDescriptionValue, recipeUpdateDesc, 10, "recipeDescriptionValue");
        return recipeNameStatus && recipeDescriptionStatus;
    }

    public void editRecipeNameAndDescription(String recipeUpdateName, String recipeUpdateDesc) {
        commonFunctions.scrollPageWithJS(recipeCuisineValue, 10);
        commonFunctions.isElementPresentWithTryCatch(recipeEditIcon, 10);
        commonFunctions.clickElementWithJS(recipeEditIcon, 10, "recipeEditIcon");
        commonFunctions.isElementPresentWithTryCatch(recipeName, 10);
        inputRecipeName(recipeUpdateName);
        inputDescription(recipeUpdateDesc);
    }

    public boolean validateRecipeSavedValue(String recipName, String stepInformation, String recipeDescription, String recipeYield, String recipePreparationHour, String recipePreparationMinute, String recipeCookingHour, String recipeCookingMinute, String recipeTotalHour, String recipeTotalMinute, String recipeIngredients, String recipeCuisine, String recipeCategory, String recipeKeywords) {
        commonFunctions.scrollPageWithJS(recipeNameValue, 10);
        boolean recipeNameStatus = commonFunctions.checkElementTextWithTryCatch(recipeNameValue, recipName, 10, "recipName");
        commonFunctions.scrollPageWithJS(recipeDescriptionValue, 10);
        boolean recipeDescriptionStatus = commonFunctions.checkElementTextWithTryCatch(recipeDescriptionValue, recipeDescription, 10, "recipeDescriptionValue");
        commonFunctions.scrollPageWithJS(recipeYieldValue, 10);
        boolean recipeYieldStatus = commonFunctions.checkElementTextWithTryCatch(recipeYieldValue, recipeYield, 10, "recipeYieldValue");
        commonFunctions.scrollPageWithJS(recipePreparationTimeValue, 10);
        boolean recipePreparationTimeStatus = commonFunctions.checkElementTextWithTryCatch(recipePreparationTimeValue, recipePreparationHour, 10, "recipePreparationHour");
        commonFunctions.scrollPageWithJS(recipePreparationTimeValue, 10);
        boolean recipePrepTimeStatus = commonFunctions.checkElementTextWithTryCatch(recipePreparationTimeValue, recipePreparationMinute, 10, "recipePreparationMinute");
        commonFunctions.scrollPageWithJS(recipeCookingTimeValue, 10);
        boolean recipeCookingTimeStatus = commonFunctions.checkElementTextWithTryCatch(recipeCookingTimeValue, recipeCookingHour, 10, "recipeCookingHour");
        commonFunctions.scrollPageWithJS(recipeCookingTimeValue, 10);
        boolean recipeCookTimeStatus = commonFunctions.checkElementTextWithTryCatch(recipeCookingTimeValue, recipeCookingMinute, 10, "recipeCookingMinute");
        commonFunctions.scrollPageWithJS(recipeTotalTimeValue, 10);
        boolean recipeTotalTimeStatus = commonFunctions.checkElementTextWithTryCatch(recipeTotalTimeValue, recipeTotalHour, 10, "recipeTotalHour");
        commonFunctions.scrollPageWithJS(recipeTotalTimeValue, 10);
        boolean recipeTotTimeStatus = commonFunctions.checkElementTextWithTryCatch(recipeTotalTimeValue, recipeTotalMinute, 10, "recipeTotalMinute");
        commonFunctions.scrollPageWithJS(recipeKeywordsValue, 10);
        boolean recipeKeywordsStatus = commonFunctions.checkElementTextWithTryCatch(recipeKeywordsValue, recipeKeywords, 10, "recipeKeywords");
        commonFunctions.scrollPageWithJS(recipeCuisineValue, 10);
        boolean recipeCuisinestatus = commonFunctions.checkElementTextWithTryCatch(recipeCuisineValue, recipeCuisine, 10, "recipeCuisine");
        commonFunctions.scrollPageWithJS(recipeCategoryValue, 10);
        boolean recipeCategoryStatus = commonFunctions.checkElementTextWithTryCatch(recipeCategoryValue, recipeCategory, 10, "recipeCategory");
        commonFunctions.scrollPageWithJS(recipeIngredientsValue, 10);
        boolean recipeIngredientsStatus = commonFunctions.checkElementTextWithTryCatch(recipeIngredientsValue, recipeIngredients, 10, "recipeIngredients");
        commonFunctions.scrollPageWithJS(recipeImageValue, 10);
        boolean recipeImageStatus = !commonFunctions.getElementText(recipeImageValue).isEmpty();
        return recipeNameStatus && recipeDescriptionStatus && recipeYieldStatus && recipePreparationTimeStatus && recipePrepTimeStatus && recipeCookingTimeStatus && recipeCookTimeStatus && recipeTotalTimeStatus && recipeTotTimeStatus && recipeKeywordsStatus && recipeCuisinestatus && recipeCategoryStatus && recipeIngredientsStatus && recipeImageStatus;
    }

    public void selectRecipeImageFromLibrary() {
        commonFunctions.scrollPageWithJS(imageLibrary, 10);
        commonFunctions.isElementDisplayed(imageLibrary, 10, "Lib Image");
        commonFunctions.clickElement(imageLibrary, 10, "Lib Image");

        commonFunctions.isElementDisplayed(recipeImgIcon, 10, "Lib Image");
        commonFunctions.mouseHoverOnElement(recipeImgIcon, 10, "Lib Image");

        commonFunctions.isElementDisplayed(useImage, 10, "Use Button");
        commonFunctions.clickElement(useImage, 10, "Use Button");

        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 10)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }

        commonFunctions.isElementDisplayed(doneButton, 10, "Done Button");
        commonFunctions.clickElement(doneButton, 10, "Done Button");
    }

    public void inputRecipeData(String recipName, String stepInformation, String recipeDescription, String recipeYield, String recipePreparationHour, String recipePreparationMinute, String recipeCookingHour, String recipeCookingMinute, String recipeTotalHour, String recipeTotalMinute, String recipeIngredients, String recipeCuisine, String recipeCategory, String recipeKeywords) {
        commonFunctions.clickElementWithJS(recipaIcon, 10, "Recipa Icon");
        commonFunctions.isElementPresentWithTryCatch(recipeName, 10);
        inputRecipeName(recipName);
        inputDescription(recipeDescription);
        inputRecipeYield(recipeYield);
        inputRecipePreparationTimeHr(recipePreparationHour);
        inputPreparationTimeMinute(recipePreparationMinute);
        inputCookingTimeHr(recipeCookingHour);
        inputCookingTimeMinute(recipeCookingMinute);
        inputTotalTimeHr(recipeTotalHour);
        inputTotalTimeMinute(recipeTotalMinute);
        inputKeyword(recipeKeywords);
        inputIngredients(recipeIngredients);
        inputrecipeCuisine(recipeCuisine);
        inputrecipeCategory(recipeCategory);
        inputStepInformation(stepInformation);
    }

    public void inputStepInformation(String stepInformationValue) {
        commonFunctions.scrollPageWithJS(recipeStepText, 10);
        commonFunctions.sendKeys(recipeStepText, stepInformationValue, 10, "Step Information");
    }

    public void inputRecipeName(String recName) {
        commonFunctions.scrollPageWithJS(recipeName, 10);
        commonFunctions.sendKeys(recipeName, recName, 10, "Recipe Name");
    }

    public void inputDescription(String desc) {
        commonFunctions.scrollPageWithJS(recipeDescription, 10);
        commonFunctions.sendKeys(recipeDescription, desc, 10, "Recipe Description");
    }

    public void inputRecipeYield(String yield) {
        commonFunctions.scrollPageWithJS(recipeYield, 10);
        commonFunctions.sendKeys(recipeYield, yield, 10, "Recipe RecipeYield");
    }

    public void inputRecipePreparationTimeHr(String time) {
        commonFunctions.scrollPageWithJS(recipePreparationTimeHr, 10);
        commonFunctions.sendKeys(recipePreparationTimeHr, time, 10, "Recipe RecipePreparationTimeHr");
    }

    public void inputPreparationTimeMinute(String time) {
        commonFunctions.scrollPageWithJS(preparationTimeMinute, 10);
        commonFunctions.sendKeys(preparationTimeMinute, time, 10, "Recipe PreparationTimeMinute");
    }

    public void inputCookingTimeHr(String time) {
        commonFunctions.scrollPageWithJS(cookingTimeHr, 10);
        commonFunctions.sendKeys(cookingTimeHr, time, 10, "Recipe CookingTimeHr");
    }

    public void inputCookingTimeMinute(String time) {
        commonFunctions.scrollPageWithJS(cookingTimeMinute, 10);
        commonFunctions.sendKeys(cookingTimeMinute, time, 10, "Recipe CookingTimeMinute");
    }

    public void inputTotalTimeHr(String time) {
        commonFunctions.scrollPageWithJS(totalTimeHr, 10);
        commonFunctions.sendKeys(totalTimeHr, time, 10, "Recipe TotalTimeHr");
    }

    public void inputTotalTimeMinute(String time) {
        commonFunctions.scrollPageWithJS(totalTimeMinute, 10);
        commonFunctions.sendKeys(totalTimeMinute, time, 10, "Recipe TotalTimeMinute");
    }

    public void inputIngredients(String ingredientsValue) {
        commonFunctions.scrollPageWithJS(ingredients, 10);
        commonFunctions.sendKeys(ingredients, ingredientsValue, 20, "ingredients Text");
        commonFunctions.hardWait(3000);
        commonFunctions.sendKeysWithEnter(ingredients, 10);
    }

    public void inputKeyword(String keywordValue) {
        commonFunctions.scrollPageWithJS(keyword, 10);
        commonFunctions.sendKeys(keyword, keywordValue, 20, "keyword box");
        commonFunctions.hardWait(10000);
        commonFunctions.clickElement(suggestionValue,10);
//        commonFunctions.sendKeysWithEnter(keywordAfterInsert, 10);
    }

    public void inputrecipeCuisine(String recipeCuisineValue) {
        commonFunctions.scrollPageWithJS(recipeCuisine, 10);
        commonFunctions.sendKeys(recipeCuisine, recipeCuisineValue, 10, "Recipe CuisineValue");
    }

    public void inputrecipeCategory(String recipeCategoryValue) {
        commonFunctions.scrollPageWithJS(recipeCategory, 10);
        commonFunctions.sendKeys(recipeCategory, recipeCategoryValue, 10, "Recipe Category");
    }

    @Override
    public boolean checkPhotoUploaded(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 10);
        return commonFunctions.isElementPresentWithTryCatch(imageSrc, 20);
    }

    @Override
    public boolean checkUserIsAbleToCreateStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        boolean storyUiStatus = createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(5);
        boolean storyDbStatus = dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", storyIdNumber, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline);
        return storyUiStatus && storyDbStatus;
    }

    @Override
    public boolean checkSocialNotificationSectionIsPresent(String property) {
        boolean isResult=false;
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        for(int i=0;i<socialNotificationHeading.size();i++){
            System.out.println(i);
            isResult=commonFunctions.checkElementTextWithTryCatch(socialNotificationHeading.get(i), "Social Notification", 10, "Social Notification Heading");
            if (isResult) return true;
        }
        return false;
    }

    @Override
    public boolean checkSendNotificationLinkPresence(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        return commonFunctions.isElementPresentWithTryCatch(sendNotificationLink, 10);
    }

    @Override
    public boolean checkSendNotificationPopupShouldOpen(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationPopUpStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        return sendNotificationPopUpStatus;
    }

    @Override
    public boolean checkSendNotificationPopupHaveImageUrlField(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationPopUpStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        commonFunctions.scrollPageWithJS(imgUrlLabel, 10);
        boolean imgUrlLabelStatus = commonFunctions.isElementPresentWithTryCatch(imgUrlLabel, 20);
        boolean imgUrlTextStatus = commonFunctions.isElementPresentWithTryCatch(imgUrlText, 20);
        return sendNotificationPopUpStatus && imgUrlLabelStatus && imgUrlTextStatus;
    }

    @Override
    public boolean checkImageUrlFieldShouldNotBeKeptEmpty(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(10);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationPopUpStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        commonFunctions.scrollPageWithJS(imgUrlLabel, 10);
        boolean imgUrlLabelStatus = commonFunctions.isElementPresentWithTryCatch(imgUrlLabel, 20);
        boolean imgUrlTextStatus = commonFunctions.isElementPresentWithTryCatch(imgUrlText, 20);
        boolean imageUrlTextValueStatus = !commonFunctions.getAttributeValue(imgUrlText, 10, "ng-reflect-model").isEmpty();
        return sendNotificationPopUpStatus && imgUrlLabelStatus && imgUrlTextStatus && imageUrlTextValueStatus;
    }

    @Override
    public boolean checkSendAndCancelButtonOnSendNotificationPopup(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationPopUpStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        commonFunctions.scrollPageWithJS(socialNotificationCancelButton, 10);
        boolean cancelButtonStatus = commonFunctions.isElementPresentWithTryCatch(socialNotificationCancelButton, 10);
        commonFunctions.scrollPageWithJS(socialNotificationSendButton, 10);
        boolean sendButtonStatus = commonFunctions.isElementPresentWithTryCatch(socialNotificationSendButton, 10);
        return sendNotificationPopUpStatus && cancelButtonStatus && sendButtonStatus;
    }

    @Override
    public boolean checkSendButtonIsWorking(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.hardWait(3000);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationPopUpStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        commonFunctions.scrollPageWithJS(socialNotificationSendButton, 10);
        if(imgUrlText.getAttribute("ng-reflect-model").length()==0){
            commonFunctions.hardWait(2000);
            commonFunctions.sendKeys(imgUrlText,"https",10,"image url");
        }
        commonFunctions.hardWait(2000);
        commonFunctions.clickElement(socialNotificationSendButton, 10, "Social Notification Send Button");
        commonFunctions.hardWait(1000);
        return sendNotificationPopUpStatus && commonFunctions.isElementPresentWithTryCatch(socialNotificationSuccessMessage, 10);
    }

    @Override
    public boolean checkAddPhotoStoriesButtonIsAvailable(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.clickElement(buttonEditForImage, 10, "Image edit");
        commonFunctions.scrollToElement(relatedStoryButton, "related stories button");
        boolean addRelatedStoryButton = commonFunctions.isElementDisplayed(relatedStoryButton, 10, "add/replace related story");
        return addRelatedStoryButton;
    }

    public boolean checkUserCanSelectDesiredStoryToHyperlink(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.hardWait(3000);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
        commonFunctions.clickElementWithJS(backLinkID, 10, "Back Link");
        commonFunctions.hardWait(3000);
        commonFunctions.clickElementIfDisplayed(searchedStoryList.get(0),10,"related story");
        String storyText=commonFunctions.getElementText(searchedStoryList.get(0),10);
        commonFunctions.clickElementIfDisplayed(addLinkButton, 10,"add link button");
        commonFunctions.hardWait(2000);
        String hyperLinkedText=hyperLinkedParagraphWord.getAttribute("href");
        storyText=storyText.replace(" ","-").toLowerCase();
        Utils.logStepInfo("heading is: "+storyText+"link test is: "+hyperLinkedText);
        return hyperLinkedText.contains(storyText);
    }

    @Override
    public boolean checkActionOnClickOfHyperlinkStoryTextIcon(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.hardWait(3000);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
        commonFunctions.clickElementWithJS(backLinkID, 10, "Back Link");
        commonFunctions.hardWait(5000);
        return commonFunctions.isElementDisplayed(searchedStoryList.get(0),10);
    }

    @Override
    public boolean checkHyperlinkStoryTextIcon(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.dummyWait(3);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.hardWait(1000);
        return commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
    }

    public boolean selectDesiredStoryToHyperlink(String headLine, boolean selectStatus) {
        boolean flag = false;
        if (!commonFunctions.isElementPresentWithTryCatch(searchedStoryList.get(0), 10)) {
            commonFunctions.clickElement(hyperlinkSearchText, 10, "Hyperlink Search Text");
            commonFunctions.backSpace(hyperlinkSearchText);
            commonFunctions.dummyWait(5);
            commonFunctions.isElementPresentWithTryCatch(searchedStoryList.get(0), 10);
        }
        flag &= commonFunctions.isElementPresentWithTryCatch(searchedStoryList.get(0), 10);

        for (int i = 0; i < searchedStoryList.size(); i++) {
            commonFunctions.scrollPageWithJS(searchedStoryList.get(i), 10);
            if (searchedStoryList.get(i).getText().trim().equalsIgnoreCase(headLine.trim())) {
                flag = true;
                if (selectStatus) {
                    commonFunctions.clickElement(searchedStoryList.get(i), 10, headLine + " story");
                }
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean checkProperValidationMessageIfNoMatchingData(String property, String headLine, String summary, String byline, String section, String subsection, String keyword, String location, String topic, String paraTextNoMatching, String expValidationMessage) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paraTextNoMatching);
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.hardWait(3000);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
        commonFunctions.clickElementWithJS(backLinkID, 10, "Back Link");
        commonFunctions.isElementPresentWithTryCatch(hyperLinkValidationMessage, 20);
        return commonFunctions.checkElementTextWithEqualIgnoreCase(commonFunctions.getElementText(hyperLinkValidationMessage, expValidationMessage.trim(), 10).trim(), expValidationMessage.trim(), "hyperLinkValidationMessage");
    }

    @Override
    public boolean checkUserCanSelectMoreThanOneWordsToHyperlink(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.hardWait(3000);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.tripleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
        commonFunctions.clickElementWithJS(backLinkID, 10, "Back Link");
        commonFunctions.hardWait(3000);
        commonFunctions.clickElementIfDisplayed(searchedStoryList.get(0),10,"related story");
        commonFunctions.clickElementIfDisplayed(addLinkButton, 10,"add link button");
        commonFunctions.hardWait(2000);
        return commonFunctions.isElementDisplayed(hyperLinkedParagraphWord,10,"hyper link");
    }

    @Override
    public boolean checkWordsHyperlinkedAreRedirectedToTheRightStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String paraText) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine + " " + commonFunctions.generateRandomNum(), summary + " " + commonFunctions.generateRandomNum(), paraText, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.dummyWait(3);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
        commonFunctions.clickElementWithJS(backLinkID, 10, "Back Link");
        commonFunctions.isElementPresentWithTryCatch(addLinkButton, 10);
        commonFunctions.dummyWait(5);
        selectDesiredStoryToHyperlink(headLine, true);
        commonFunctions.dummyWait(5);
        String selectedLinkText = null;
        if (!commonFunctions.getAttributeValue(searchAddLinkText, 10, "ng-reflect-model").isEmpty()) {
            selectedLinkText = commonFunctions.getAttributeValue(searchAddLinkText, 10, "ng-reflect-model");
            commonFunctions.clickElement(addLinkButton, 10, "Add Link Button");
            commonFunctions.dummyWait(5);
            commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
            commonFunctions.dummyWait(2);
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        commonFunctions.isElementPresentWithTryCatch(addParagraphText, 10);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        boolean selecteLinkStatus = commonFunctions.isElementPresentWithTryCatch(selectedLink, 20);
        boolean selecteLinkTextStatus = commonFunctions.checkTextContains(selectedLinkText.trim(), commonFunctions.getAttributeValue(selectedLink, 10, "href").trim(), "Linked Story");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.dummyWait(3);
        String hyperlinkUrl = commonFunctions.getAttributeValue(canonicalUrlText, 10, "value");
        commonFunctions.navigateToURL(hyperlinkUrl);
        if (commonFunctions.isElementPresentWithTryCatch(denyButton, 20)) {
            commonFunctions.scrollPageWithJS(denyButton, 10);
            commonFunctions.clickElementWithJS(canonicalUrlHyperlink, 10, "Deny Button");
        }
        commonFunctions.scrollPageWithJS(canonicalUrlHyperlink, 20);
        commonFunctions.clickElementWithJS(canonicalUrlHyperlink, 20, "CanonicalUrlHyperlink Word");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        if (commonFunctions.isElementPresentWithTryCatch(denyButton, 20)) {
            commonFunctions.scrollPageWithJS(denyButton, 10);
            commonFunctions.clickElementWithJS(canonicalUrlHyperlink, 10, "Deny Button");
        }
        commonFunctions.scrollPageWithJS(hyperlinkHeadingName, 10);
        return commonFunctions.getElementTextAndCheck(hyperlinkHeadingName, headLine.trim(), 20, "HeadLine Text") && selecteLinkStatus && selecteLinkTextStatus;
    }

    @Override
    public boolean checkOnceHyperlinkedUserCanEditTheHyperlink(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String url) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.hardWait(3000);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.hardWait(1000);
        commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
        commonFunctions.clickElementWithJS(backLinkID, 10, "Back Link");
        commonFunctions.hardWait(3000);
        commonFunctions.clickElementIfDisplayed(searchedStoryList.get(0),10,"related story");
        commonFunctions.clickElementIfDisplayed(addLinkButton, 10,"add link button");
        commonFunctions.hardWait(2000);
        String oldLink=hyperLinkedParagraphWord.getAttribute("href");
        commonFunctions.clickElement(hyperLinkedParagraphWord,10,"link");
        commonFunctions.doubleClick(hyperLinkedParagraphWord,10,"link");
        commonFunctions.isElementPresentWithTryCatch(hyperlinkEditButton, 10);
        commonFunctions.clickElementWithJS(hyperlinkEditButton, 10, "Hyperlink Edit Button");
        commonFunctions.isElementPresentWithTryCatch(hyperlinkEditText, 10);
        commonFunctions.sendKeys(hyperlinkEditText, url, 10, "Hyperlink Edit Text");
        commonFunctions.isElementPresentWithTryCatch(hyperlinkEditSaveButton, 10);
        commonFunctions.clickElementWithJS(hyperlinkEditSaveButton, 10, "Hyperlink Edit Button");
        String newLink=hyperLinkedParagraphWord.getAttribute("href");
        return !oldLink.equals(newLink);
    }

    @Override
    public boolean checkUserCanUnlinkTheHyperlinkedWord(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.hardWait(3000);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.doubleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(backLinkID, 10);
        commonFunctions.clickElementWithJS(backLinkID, 10, "Back Link");
        commonFunctions.hardWait(3000);
        commonFunctions.clickElementIfDisplayed(searchedStoryList.get(0),10,"related story");
        commonFunctions.clickElementIfDisplayed(addLinkButton, 10,"add link button");
        commonFunctions.hardWait(2000);
        commonFunctions.clickElement(hyperLinkedParagraphWord,10,"link");
        commonFunctions.doubleClick(hyperLinkedParagraphWord,10,"link");
        commonFunctions.clickElementIfDisplayed(unlinkWork,10,"unlink the word");
        return !commonFunctions.isElementDisplayedWithExceptionHandling(hyperLinkedParagraphWord,5,"hyperlinked word");
    }

    @Override
    public boolean checkCancelButtonIsWorking(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationPopUpStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        commonFunctions.scrollPageWithJS(notificationCancelButton, 10);
        commonFunctions.clickElement(notificationCancelButton, 10, "Social Notification Send Button");
        return sendNotificationPopUpStatus && !commonFunctions.isElementPresentWithTryCatch(socialNotificationSuccessMessage, 10) && !commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 10);
    }

    @Override
    public boolean checkNotificationBellIconIsPresentOnDashboard(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.hardWait(3000);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        boolean sendNotificationPopUpStatus = commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        if (commonFunctions.getAttributeValue(imgUrlText, 10, "value").isEmpty()) {
            String linkText = commonFunctions.getAttributeValue(notificationImgUrlText, 10, "value");
            commonFunctions.sendKeys(imgUrlText, linkText.trim(), 10, "Image Url");
            commonFunctions.hardWait(2000);
        }
        commonFunctions.scrollPageWithJS(socialNotificationSendButton, 10);
        commonFunctions.clickElement(socialNotificationSendButton, 10, "Social Notification Send Button");
        commonFunctions.hardWait(2000);
        commonFunctions.isElementPresentWithTryCatch(notificationSuccess, 10);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        boolean bellIconStatus = searchStoryByIdAndVerifyNotificationBellIcon(storyIdNumber);
        return bellIconStatus && sendNotificationPopUpStatus;
    }

    private boolean searchStoryByIdAndVerifyNotificationBellIcon(String id) {
        commonFunctions.sendKeysOnElementVisibility(searchAllStoriesText, "id:" + id, 30, "search box");
        commonFunctions.sendKeysWithEnter(searchAllStoriesText, 30);
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(notificationBellIcon, 10);
    }

    @Override
    public boolean checkImageUploadedForOneTenantIsVisibleInOtherTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String otherTenent) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        String imgUrl = commonFunctions.selectImageAndReturnImgSrc(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton, imageEditDoneButton);
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 3)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 10);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, otherTenent, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return verifyCrossTenantImage(imgUrl);
    }

    public boolean verifyCrossTenantImage(String imgUrl) {
        boolean flag = false;
        commonFunctions.isElementDisplayed(imgIcon, 10, "Image");
        commonFunctions.clickElement(imgIcon, 10, "Image");
        commonFunctions.isElementDisplayed(chouseIcon, 10, "Lib Image");
        commonFunctions.clickElement(chouseIcon, 10, "Lib Image");
        boolean crossTenaneTabStatus = commonFunctions.isElementDisplayed(crossTenant, 10, "Cross Tenant");
        commonFunctions.clickElement(crossTenant, 10, "Cross Tenant");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(recentImage, 20);
        int imageSize = crossTenantImages.size();
        for (int i = 0; i < imageSize; i++) {
            String imgUrlFromCrossTenant = commonFunctions.getAttributeValue(crossTenantImages.get(i), 10, "src");
            if (imgUrl.trim().equalsIgnoreCase(imgUrlFromCrossTenant.trim())) {
                flag = true;
                break;
            }
        }
        return flag && crossTenaneTabStatus;
    }

    @Override
    public boolean checkUploadImageDisplayedUnderCrossDomainTab(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String otherTenent, String otherByLine) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.selectImageAndReturnImgSrc(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton,imageEditDoneButton);
        commonFunctions.hardWait(2000);
        addImageCaption("lead media caption");
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 3)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 10);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, otherTenent, "tenant");
        createStdStory(headLine, summary, paragraph, otherByLine, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(uploadedImgDeleteButton, 20);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(uploadedImgDeleteButton, 10, "Uploaded Img Delete Button");
        commonFunctions.selectCrossTenantTabImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton, crossTenant);
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 3)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
            commonFunctions.dummyWait(2);
        }
        return commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 10);
    }

    public boolean addImageCaption(String caption) {
        commonFunctions.isElementDisplayedAndPresent(buttonImageEditIcon, 20, "three Dots First Image");
        commonFunctions.clickElementWithJS(buttonImageEditIcon, 20, "three Dots First Image");
        commonFunctions.isElementDisplayedAndPresent(firstImageCaption, 10, "image caption");
        commonFunctions.scrollPageWithJS(leadImage,10);
        commonFunctions.clickElementIfDisplayed(firstImageCaption, 10, "click on image caption field");
        if (firstImageCaption.getText().length() > 0) {
            firstImageCaption.clear();
        }
        commonFunctions.clickElementIfDisplayed(firstImageCaption);
        commonFunctions.sendKeyWithActions(firstImageCaption, caption);
        commonFunctions.scrollPageWithJS(imageEditDoneButton, 5);
        commonFunctions.hardWait(2000);
        commonFunctions.clickElementWithJS(imageEditDoneButton, 10, "first image done button");
        boolean isShowing = commonFunctions.checkElementText(firstImageCaptionNameData, caption, 15, "first image Caption name");
        return isShowing;
    }

    @Override
    public boolean checkUploadImageDisplayedUnderCrossDomainTabFromInline(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String otherTenent, String otherByLine) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.selectImageAndReturnImgSrc(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton, imageEditDoneButton);
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 3)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(yesButton, 3)) {
                commonFunctions.clickElement(yesButton, 10, "Yes Button");
            }
        }
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 10);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, otherTenent, "tenant");
        createStdStory(headLine, summary, paragraph, otherByLine, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(uploadedImgDeleteButton, 20);
        commonFunctions.clickElement(uploadedImgDeleteButton, 10, "Uploaded Img Delete Button");
        commonFunctions.dummyWait(5);
        commonFunctions.selectCrossTenantTabImageFromInlineElement(inlineInsertImgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton, crossTenant);
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 3)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(yesButton, 3)) {
                commonFunctions.clickElement(yesButton, 10, "Yes Button");
            }
            commonFunctions.dummyWait(2);
        }
        return commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 10);
    }

    @Override
    public boolean checkUploadedImageShouldBeDisplayedInInternalTab(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String imgSrc) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(imgIcon, 10);
        commonFunctions.clickElement(imgIcon, 10, "Image");
        String projectPath =System.getProperty("user.dir")+"/testimage.jpeg";
        uploadNewImageFile.sendKeys(projectPath);
        commonFunctions.clickElementIfDisplayed(doneButton,10);
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementWithJS(imageEditDoneButton,10);
        addImageCaption("nature");
        commonFunctions.clickElementWithJS(saveButton);
        commonFunctions.hardWait(10000);
        commonFunctions.refreshPage();
        commonFunctions.hardWait(2000);
        commonFunctions.clickElement(uploadedImgDeleteButton, 10, "Uploaded Img Delete Button");
        commonFunctions.clickElement(imgIcon, 10, "Image");
        commonFunctions.clickElementWithJS(imagePicFromLib,10);
        return commonFunctions.getElementTextAndCheck(imageCaptionOfLibImg,"nature...",10,"image caption");
    }

    public boolean verifyUploadedImage(String imgDate) {
        boolean flag = false;
        commonFunctions.isElementDisplayed(imgIcon, 10, "Image");
        commonFunctions.clickElement(imgIcon, 10, "Image");
        commonFunctions.isElementDisplayed(chouseIcon, 10, "Lib Image");
        commonFunctions.clickElement(chouseIcon, 10, "Lib Image");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(recentImage, 20);
        int imageSize = crossTenantImages.size();
        for (int i = 0; i < imageSize; i++) {
            String imgUrlFromCrossTenant = commonFunctions.getAttributeValue(crossTenantImages.get(i), 10, "src");
            if (imgUrlFromCrossTenant.trim().contains(imgDate.trim())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void selectImageFromMac() {
        try {
            Robot r = new Robot();
            /*
             * use the Robot class to type out the path of the document
             * "/Users/d111841/Downloads/123.jpg"
             */
            r.keyPress(KeyEvent.VK_SLASH);
            r.keyRelease(KeyEvent.VK_SLASH);
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_U);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_U);
            r.keyPress(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_S);
            r.keyPress(KeyEvent.VK_E);
            r.keyRelease(KeyEvent.VK_E);
            r.keyPress(KeyEvent.VK_R);
            r.keyRelease(KeyEvent.VK_R);
            r.keyPress(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_S);
            r.keyPress(KeyEvent.VK_SLASH);
            r.keyRelease(KeyEvent.VK_SLASH);
            r.keyPress(KeyEvent.VK_D);
            r.keyRelease(KeyEvent.VK_D);
            r.keyPress(KeyEvent.VK_1);
            r.keyRelease(KeyEvent.VK_1);
            r.keyPress(KeyEvent.VK_1);
            r.keyRelease(KeyEvent.VK_1);
            r.keyPress(KeyEvent.VK_1);
            r.keyRelease(KeyEvent.VK_1);
            r.keyPress(KeyEvent.VK_8);
            r.keyRelease(KeyEvent.VK_8);
            r.keyPress(KeyEvent.VK_4);
            r.keyRelease(KeyEvent.VK_4);
            r.keyPress(KeyEvent.VK_1);
            r.keyRelease(KeyEvent.VK_1);
            r.keyPress(KeyEvent.VK_SLASH);
            r.keyRelease(KeyEvent.VK_SLASH);
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_D);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_D);
            r.keyPress(KeyEvent.VK_O);
            r.keyRelease(KeyEvent.VK_O);
            r.keyPress(KeyEvent.VK_W);
            r.keyRelease(KeyEvent.VK_W);
            r.keyPress(KeyEvent.VK_N);
            r.keyRelease(KeyEvent.VK_N);
            r.keyPress(KeyEvent.VK_L);
            r.keyRelease(KeyEvent.VK_L);
            r.keyPress(KeyEvent.VK_O);
            r.keyRelease(KeyEvent.VK_O);
            r.keyPress(KeyEvent.VK_A);
            r.keyRelease(KeyEvent.VK_A);
            r.keyPress(KeyEvent.VK_D);
            r.keyRelease(KeyEvent.VK_D);
            r.keyPress(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_S);
            r.keyPress(KeyEvent.VK_SLASH);
            r.keyRelease(KeyEvent.VK_SLASH);
            r.keyPress(KeyEvent.VK_1);
            r.keyRelease(KeyEvent.VK_1);
            r.keyPress(KeyEvent.VK_2);
            r.keyRelease(KeyEvent.VK_2);
            r.keyPress(KeyEvent.VK_3);
            r.keyRelease(KeyEvent.VK_3);
            r.keyPress(KeyEvent.VK_PERIOD);
            r.keyRelease(KeyEvent.VK_PERIOD);
            r.keyPress(KeyEvent.VK_J);
            r.keyRelease(KeyEvent.VK_J);
            r.keyPress(KeyEvent.VK_P);
            r.keyRelease(KeyEvent.VK_P);
            r.keyPress(KeyEvent.VK_G);
            r.keyRelease(KeyEvent.VK_G);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean checkRelatedStoryHeadline(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine + " " + commonFunctions.generateRandomNum(), summary + " " + commonFunctions.generateRandomNum(), paragraph + " " + commonFunctions.generateRandomNum(), byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.dummyWait(3);
        findRelatedStory(true, headLine.trim());
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(relatedStoryChooseButton, 10);
        commonFunctions.clickElement(relatedStoryChooseButton, 10, "relatedStoryChooseButton");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(relatedStoryHeadline, 10);
        return commonFunctions.getElementText(relatedStoryHeadline, headLine.trim(), 10).trim().equals(headLine.trim());
    }

    public boolean findRelatedStory(Boolean clickStatus, String headLine) {
        boolean flag = false;
        commonFunctions.isElementPresentWithTryCatch(buttonRelatedStoryList.get(0), 10);
        commonFunctions.clickElement(buttonRelatedStoryList.get(0), 10, "Inline Related Story Icon");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(relatedStoryList.get(0), 10);
        int size = relatedStoryList.size();
        for (int i = 0; i < size; i++) {
            commonFunctions.scrollPageWithJS(relatedStoryList.get(i), 10);
            if (commonFunctions.getElementText(relatedStoryList.get(i)).trim().equals(headLine.trim())) {
                flag = true;
                if (clickStatus) {
                    commonFunctions.clickElement(relatedStoryList.get(i), 10, headLine);
                }
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean checkHButtonPresentWhileCreatingStandardStory(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.isElementPresentWithTryCatch(hButton, 20);
    }

    @Override
    public boolean checkHButtonHasThreeOptionsForParagraph(String property, String paraOne, String paraTwo, String paraThree) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOptions.get(1), 10);
        List<String> hButtonOptionsList = new ArrayList<String>();
        List<String> expectedHButtonOptionsList = new ArrayList<String>();
        for (int i = 0; i < hButtonOptions.size(); i++) {
            hButtonOptionsList.add(hButtonOptions.get(i).getText().trim());
        }
        expectedHButtonOptionsList.add(paraOne.trim());
        expectedHButtonOptionsList.add(paraTwo.trim());
        expectedHButtonOptionsList.add(paraThree.trim());
        return commonFunctions.compareTwoLists(expectedHButtonOptionsList, hButtonOptionsList);
    }

    @Override
    public boolean checkHButtonOptionsAreSelectable(String property, String paraOne, String paraTwo, String paraThree) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOptions.get(1), 10);
        List<String> hButtonOptionsList = new ArrayList<String>();
        List<String> expectedHButtonOptionsList = new ArrayList<String>();
        for (int i = 0; i < hButtonOptions.size(); i++) {
            hButtonOptionsList.add(hButtonOptions.get(i).getText().trim());
        }
        expectedHButtonOptionsList.add(paraOne.trim());
        expectedHButtonOptionsList.add(paraTwo.trim());
        expectedHButtonOptionsList.add(paraThree.trim());
        boolean optionVisibleStatus = commonFunctions.compareTwoLists(expectedHButtonOptionsList, hButtonOptionsList);
        boolean optionSelectableStatus = commonFunctions.isElementClickable(hButtonOptions.get(1), 10, "H Button Option");
        optionSelectableStatus &= commonFunctions.isElementClickable(hButtonOptions.get(2), 10, "H Button Option");
        optionSelectableStatus &= commonFunctions.isElementClickable(hButtonOptions.get(3), 10, "H Button Option");
        return optionVisibleStatus && optionSelectableStatus;
    }

    @Override
    public boolean checkCityFilterInDashboard(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.dummyWait(3);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        commonFunctions.isElementPresentWithTryCatch(moreFilterButton, 10);
        commonFunctions.clickElement(moreFilterButton, 10, "More Filter Button");
        commonFunctions.isElementPresentWithTryCatch(locationFilterButton, 10);
        commonFunctions.clickElement(locationFilterButton, 10, "Location Filter Button");
        commonFunctions.isElementPresentWithTryCatch(locationFilterText, 10);
        commonFunctions.sendKeys(locationFilterText, location.trim(), 10, "Location Filter Text");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementPresentWithTryCatch(locationFilterValue, 10);
        commonFunctions.clickElement(locationFilterValue, 10, "Location Filter Button");
        commonFunctions.dummyWait(10);
        return findStoryAccordingToLocationFilter(false, headLine.trim());
    }

    public boolean findStoryAccordingToLocationFilter(Boolean clickStatus, String headLine) {
        boolean flag = false;
        commonFunctions.isElementPresentWithTryCatch(locationFilterResult.get(0), 10);
        int size = locationFilterResult.size();
        for (int i = 0; i < size; i++) {
            commonFunctions.scrollPageWithJS(locationFilterResult.get(i), 10);
            if (commonFunctions.getElementText(locationFilterResult.get(i), headLine.trim(), 10).trim().equals(headLine.trim())) {
                flag = true;
                if (clickStatus) {
                    commonFunctions.clickElement(locationFilterResult.get(i), 10, headLine);
                }
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean checkHoveringMouseOnOptionsBackColorShouldBeGrey(String property, String hoverColor) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(1), 10);
        commonFunctions.mouseHoverOnElement(hButtonOp.get(1), 10, "Heading 2");
        commonFunctions.dummyWait(3);
        boolean hoverBgColor = commonFunctions.compareTexts(commonFunctions.getParticularCssValue(hButtonOp.get(1), 10, "Heading 2", "--ck-color-button-default-hover-background"), hoverColor);
        commonFunctions.mouseHoverOnElement(hButtonOp.get(2), 10, "Heading 3");
        commonFunctions.dummyWait(3);
        hoverBgColor &= commonFunctions.compareTexts(commonFunctions.getParticularCssValue(hButtonOp.get(2), 10, "Heading 3", "--ck-color-button-default-hover-background"), hoverColor);
        commonFunctions.mouseHoverOnElement(hButtonOp.get(3), 10, "Paragraph");
        commonFunctions.dummyWait(3);
        hoverBgColor &= commonFunctions.compareTexts(commonFunctions.getParticularCssValue(hButtonOp.get(3), 10, "Paragraph", "--ck-color-button-default-hover-background"), hoverColor);
        return hoverBgColor;
    }

    @Override
    public boolean checkSelectingOnOptionsBackgroundColorShouldBlue(String property, String selectingColor) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(1), 10);
        commonFunctions.clickElement(hButtonOp.get(1), 10, "Heading 2");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(1), 10);
        boolean hoverBgColor = commonFunctions.compareTexts(commonFunctions.getParticularCssValue(hButtonOp.get(1), 10, "Heading 2", "--ck-color-list-button-on-background"), selectingColor);
        commonFunctions.clickElement(hButtonOp.get(2), 10, "Heading 3");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(2), 10);
        hoverBgColor &= commonFunctions.compareTexts(commonFunctions.getParticularCssValue(hButtonOp.get(2), 10, "Heading 3", "--ck-color-list-button-on-background"), selectingColor);
        commonFunctions.clickElement(hButtonOp.get(3), 10, "Paragraph");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(3), 10);
        hoverBgColor &= commonFunctions.compareTexts(commonFunctions.getParticularCssValue(hButtonOp.get(3), 10, "Paragraph", "--ck-color-list-button-on-background"), selectingColor);
        return hoverBgColor;
    }

    @Override
    public boolean checkOptionsParagraphShouldBeChangedAccordingly(String property, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        inputParagraph(paragraph);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(1), 10);
        commonFunctions.clickElement(hButtonOp.get(1), 10, "Heading 2");
        commonFunctions.dummyWait(3);
        boolean elemmetStatus = commonFunctions.isElementPresentWithTryCatch(optionHeadingTwo, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(2), 10);
        commonFunctions.clickElement(hButtonOp.get(2), 10, "Heading 2");
        commonFunctions.dummyWait(3);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionHeadingThree, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(3), 10);
        commonFunctions.clickElement(hButtonOp.get(3), 10, "Heading 2");
        commonFunctions.dummyWait(3);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionParagraph, 10);
        return elemmetStatus;
    }

    @Override
    public boolean checkSentencesIsDisplayedInFormOfHeadlineTwo(String property, String headline, String summary, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(1), 10);
        commonFunctions.clickElement(hButtonOp.get(1), 10, "Heading 2");
        commonFunctions.dummyWait(3);
        boolean elemmetStatus = commonFunctions.isElementPresentWithTryCatch(optionHeadingTwo, 10);
        return elemmetStatus;
    }

    @Override
    public boolean checkSentencesIsDisplayedInFormOfHeadlineThree(String property, String headline, String summary, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(2), 10);
        commonFunctions.clickElement(hButtonOp.get(2), 10, "Heading 3");
        commonFunctions.dummyWait(3);
        boolean elemmetStatus = commonFunctions.isElementPresentWithTryCatch(optionHeadingThree, 10);
        return elemmetStatus;
    }

    @Override
    public boolean checkVideoAndImageAreAdded(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElementWithJS(videoIcon, 30, "insert video");
        commonFunctions.isElementPresentWithTryCatch(firstVideoOnVideoPage, 20);
        commonFunctions.moveToElementWithActions(firstVideoOnVideoPage, 20, "Mouse Hover to First video");
        commonFunctions.clickElementWithJS(useVideo, 30, "use video");
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 10)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }
        commonFunctions.isElementPresentWithTryCatch(doneButton, 10);
        commonFunctions.clickElement(doneButton, 10, "Done Button");
        commonFunctions.dummyWait(10);
        boolean videoStatus = commonFunctions.isElementPresentWithTryCatch(insertedVideoFfame, 10);
        boolean imageStatus = commonFunctions.isElementPresentWithTryCatch(insertedImageFfame, 10);
        return videoStatus & imageStatus;
    }

    @Override
    public boolean checkVideoAndImageAreAddedWithCaption(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElementWithJS(videoIcon, 30, "insert video");
        commonFunctions.isElementPresentWithTryCatch(firstVideoOnVideoPage, 20);
        commonFunctions.moveToElementWithActions(firstVideoOnVideoPage, 20, "Mouse Hover to First video");
        commonFunctions.clickElementWithJS(useVideo, 30, "use video");
        if (commonFunctions.isElementPresentWithTryCatch(yesButton, 10)) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }
        commonFunctions.isElementPresentWithTryCatch(doneButton, 10);
        commonFunctions.clickElement(doneButton, 10, "Done Button");
        if (commonFunctions.isElementPresentWithTryCatch(videoCaptionText, 10)) {
            commonFunctions.scrollPageWithJS(videoCaptionText, 10);
            commonFunctions.sendKeys(videoCaptionText, "Automation Video Caption " + commonFunctions.generateRandomNum(), 10, "Video Caption");
        }
        if (commonFunctions.isElementPresentWithTryCatch(captionDoneBtn, 10)) {
            commonFunctions.clickElement(captionDoneBtn, 10, "Video Caption Done");
        }
        if (commonFunctions.isElementPresentWithTryCatch(imageCaptionText, 10)) {
            commonFunctions.scrollPageWithJS(imageCaptionText, 10);
            commonFunctions.sendKeys(imageCaptionText, "Automation Image Caption " + commonFunctions.generateRandomNum(), 10, "Image Caption");
        }
        if (commonFunctions.isElementPresentWithTryCatch(captionDoneBtn, 10)) {
            commonFunctions.clickElement(captionDoneBtn, 10, "Image Caption Done");
        }
        commonFunctions.dummyWait(10);
        boolean videoStatus = commonFunctions.isElementPresentWithTryCatch(insertedVideoFfame, 10);
        boolean imageStatus = commonFunctions.isElementPresentWithTryCatch(insertedImageFfame, 10);
        return videoStatus && imageStatus;
    }

    @Override
    public boolean checkOutdatedFlagToggleButton(String property) {
        boolean isOutDatedFlagAvailable = false;
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        enableOutdatedFlagButton();
        isOutDatedFlagAvailable = commonFunctions.isElementPresentWithTryCatch(outdatedFlagDate, 10);
        return isOutDatedFlagAvailable;
    }

    @Override
    public boolean checkOutdatedFlagTimeFiled(String property) {
        boolean isDefaultTimeAvailable = false;
        String[] currentMonth;
        String currentDateAndTime = "";
        String defaultDate = "";
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        enableOutdatedFlagButton();
        if (commonFunctions.isElementPresentWithTryCatch(outdatedFlagDate, 10)) {
            defaultDate = outdatedFlagDate.getAttribute("value");
            currentMonth = defaultDate.split("/");
            if (!currentMonth[0].equals("10") && !currentMonth[0].equals("11") && !currentMonth[0].equals("12"))
                currentDateAndTime = commonFunctions.getCurrentDate("M/dd/yyyy hh:mm");
            else
                currentDateAndTime = commonFunctions.getCurrentDate("MM/dd/yyyy hh:mm");
            if (defaultDate.equals(currentDateAndTime)) {
                isDefaultTimeAvailable = true;
                Utils.logStepInfo(true, "Default date and current system date are matched");
            }
        }
        return isDefaultTimeAvailable;
    }

    public void enableOutdatedFlagButton() {
        commonFunctions.isElementPresentWithTryCatch(outdatedFlag, 10);
        commonFunctions.scrollToViewElement(outdatedFlag, "Outdated flag toggle button", 10);
        if (commonFunctions.clickElementWithJS(outdatedFlag, 10, "Outdated flag"))
            Utils.logStepInfo(true, "outdated toggle button is working");
    }

    @Override
    public boolean checkSentencesIsDisplayedInFormOfParagraph(String property, String headline, String summary, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(2), 10);
        commonFunctions.clickElement(hButtonOp.get(2), 10, "Heading 3");
        commonFunctions.dummyWait(3);
        boolean elemmetStatus = commonFunctions.isElementPresentWithTryCatch(optionHeadingThree, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(3), 10);
        commonFunctions.clickElement(hButtonOp.get(3), 10, "Paragraph");
        commonFunctions.dummyWait(5);
        elemmetStatus &= !commonFunctions.isElementPresentWithTryCatch(optionHeadingThree, 10);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionParagraph, 10);
        return elemmetStatus;
    }

    @Override
    public boolean checkWholeSentenceShouldBeAffected(String property, String headline, String summary, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 100);
        commonFunctions.tripleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(hButton, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(1), 10);
        commonFunctions.clickElement(hButtonOp.get(1), 10, "Heading 2");
        commonFunctions.dummyWait(5);
        boolean elemmetStatus = commonFunctions.isElementPresentWithTryCatch(optionHeadingTwo, 10);
        boolean elemmetTextStatus = commonFunctions.compareTexts(paragraph.trim(), commonFunctions.getElementText(optionHeadingTwo).trim());
        commonFunctions.scrollPageWithJS(hButton, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(2), 10);
        commonFunctions.clickElement(hButtonOp.get(2), 10, "Heading 2");
        commonFunctions.dummyWait(5);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionHeadingThree, 10);
        elemmetTextStatus &= commonFunctions.compareTexts(paragraph.trim(), commonFunctions.getElementText(optionHeadingThree).trim());
        commonFunctions.scrollPageWithJS(hButton, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(3), 10);
        commonFunctions.clickElement(hButtonOp.get(3), 10, "Heading 2");
        commonFunctions.dummyWait(5);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionParagraph, 10);
        elemmetTextStatus &= commonFunctions.compareTexts(paragraph.trim(), commonFunctions.getElementText(optionParagraph).trim());
        return elemmetStatus && elemmetTextStatus;
    }

    @Override
    public boolean checkOnlyHeadingShouldBeAffected(String property, String headline, String summary, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        inputHeadline(headline);
        inputSummary(summary);
        String paragraphText = paragraph;
        paragraphText = paragraphText.replace("newlinefun", Keys.chord(Keys.ENTER, Keys.ENTER));
        inputParagraph(paragraphText);
        String pText[] = paragraph.split("newlinefun");
        String headingText = pText[0].trim();
        String paraText = pText[1].trim();
        int width = addParagraphText.getSize().getWidth();
        width = ((width / 2) - 600);
        commonFunctions.tripleClickWithWidth(addParagraphText, -width, 0, 10, "Paragraph Text");
        commonFunctions.dummyWait(3);
        commonFunctions.scrollPageWithJS(hButton, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(1), 10);
        commonFunctions.clickElement(hButtonOp.get(1), 10, "Heading 2");
        commonFunctions.dummyWait(5);
        boolean elemmetStatus = commonFunctions.isElementPresentWithTryCatch(optionHeadingTwo, 10);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionParagraph, 10);
        boolean elemmetTextStatus = commonFunctions.compareTexts(headingText.trim(), commonFunctions.getElementText(optionHeadingTwo).trim()) || commonFunctions.compareTexts(headingText.trim(), commonFunctions.getElementText(optionParagraphList.get(optionParagraphList.size() - 1)).trim());
        elemmetTextStatus &= commonFunctions.compareTexts(paraText.trim(), commonFunctions.getElementText(optionHeadingTwo).trim()) || commonFunctions.compareTexts(paraText.trim(), commonFunctions.getElementText(optionParagraphList.get(optionParagraphList.size() - 1)).trim());
        commonFunctions.scrollPageWithJS(hButton, 10);
        commonFunctions.clickElement(hButton, 10, "H Button");
        commonFunctions.isElementPresentWithTryCatch(hButtonOp.get(2), 10);
        commonFunctions.clickElement(hButtonOp.get(2), 10, "Heading 2");
        commonFunctions.dummyWait(5);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionHeadingThree, 10);
        elemmetStatus &= commonFunctions.isElementPresentWithTryCatch(optionParagraph, 10);
        elemmetTextStatus &= commonFunctions.compareTexts(headingText.trim(), commonFunctions.getElementText(optionHeadingThree).trim()) || commonFunctions.compareTexts(paraText.trim(), commonFunctions.getElementText(optionHeadingThree).trim());
        elemmetTextStatus &= commonFunctions.compareTexts(headingText.trim(), commonFunctions.getElementText(optionParagraphList.get(optionParagraphList.size() - 1)).trim()) || commonFunctions.compareTexts(paraText.trim(), commonFunctions.getElementText(optionParagraphList.get(optionParagraphList.size() - 1)).trim());
        return elemmetStatus && elemmetTextStatus;
    }

    @Override
    public boolean checkUserCanEnterParagraph(String property, String headline, String summary, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.dummyWait(5);
        boolean elemmetStatus = commonFunctions.isElementPresentWithTryCatch(optionParagraph, 10);
        boolean textStatus = commonFunctions.compareTexts(paragraph.trim(), commonFunctions.getElementText(optionParagraph).trim());
        return elemmetStatus && textStatus;
    }

    @Override
    public boolean checkHButtonFloatingAlongWithThreeButtons(String property, String headline, String summary, String paragraph) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean elementStatus = commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        elementStatus &= !commonFunctions.isElementPresentWithTryCatch(sixDotsButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(alignmentButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(paragraphDeleteButton, 20);
        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(addSummaryText, 10, "Summary Text");
        commonFunctions.dummyWait(5);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(sixDotsButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(alignmentButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(paragraphDeleteButton, 20);
        return elementStatus;
    }

    @Override
    public boolean checkEditParagraphAndHButtonFloatingWithThreeButtons(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean elementStatus = commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        elementStatus &= !commonFunctions.isElementPresentWithTryCatch(sixDotsButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(alignmentButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(paragraphDeleteButton, 20);
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(addSummaryText, 10, "Summary Text");
        commonFunctions.dummyWait(5);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(sixDotsButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(alignmentButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(paragraphDeleteButton, 20);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        createStdStory(headLine + " " + commonFunctions.generateRandomNum() + "aw", summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.dummyWait(5);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(sixDotsButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(alignmentButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(paragraphDeleteButton, 20);
        commonFunctions.scrollPageWithJS(addParagraphText, 10);
        inputParagraph(paragraph + " " + commonFunctions.generateRandomNum());
        saveStandardStoryAndVerify();
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(sixDotsButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(alignmentButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(paragraphDeleteButton, 20);
        return elementStatus;
    }

    @Override
    public boolean checkChangingTheValueInValidityTimeField(String property) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.scrollPageWithJS(blogToggle, 10);
        commonFunctions.clickElement(outdatedFlagToggle, 10, "Outdated Flag Toggle");
        commonFunctions.isElementPresentWithTryCatch(validityTimeText, 10);
        String initialValidityText = commonFunctions.getAttributeValue(validityTimeText, 10, "value");
        commonFunctions.clickElement(validityTimeText, 10, "Validity Time Text");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(validityTimeNextDay, 10);
        commonFunctions.clickElement(validityTimeNextDay, 10, "Validity Time Next Day");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(validityTimeApplyBtn, 10);
        commonFunctions.clickElement(validityTimeApplyBtn, 10, "Validity Time Apply Btn");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(validityTimeText, 10);
        String updatedValidityText = commonFunctions.getAttributeValue(validityTimeText, 10, "value");
        return commonFunctions.checkTextNotEquals(initialValidityText.trim(), updatedValidityText.trim(), "Validity Time Text");
    }

    @Override
    public boolean checkOutdatedFlagValueInDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStandardStoryWithoutSwitch(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        editValidityTimeAndVerify();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);

        //Need to implement DB part and change return value accordingly. As ravinder is working on DB part after that we need to implement.
        System.out.println(dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", storyIdNumber, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline));
        return true;
    }

    private void createStandardStoryWithoutSwitch(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        inputHeadline(headline);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();
    }

    public boolean editValidityTimeAndVerify() {
        commonFunctions.scrollPageWithJS(blogToggle, 10);
        commonFunctions.clickElementWithJS(outdatedFlagToggle, 10, "Outdated Flag Toggle");
        commonFunctions.isElementPresentWithTryCatch(validityTimeText, 10);
        String initialValidityText = commonFunctions.getAttributeValue(validityTimeText, 10, "value");
        commonFunctions.clickElement(validityTimeText, 10, "Validity Time Text");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(validityTimeNextDay, 10);
        commonFunctions.clickElement(validityTimeNextDay, 10, "Validity Time Next Day");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(validityTimeApplyBtn, 10);
        commonFunctions.clickElement(validityTimeApplyBtn, 10, "Validity Time Apply Btn");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(validityTimeText, 10);
        String updatedValidityText = commonFunctions.getAttributeValue(validityTimeText, 10, "value");
        return commonFunctions.checkTextNotEquals(initialValidityText.trim(), updatedValidityText.trim(), "Validity Time Text");
    }

    @Override
    public boolean checkAutoBacklinkDetailsInDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String expMessage) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStandardStoryWithoutSwitch(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.scrollPageWithJS(randomToggle, 10);
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithJS(autoBacklinkingButton, 10, "Auto Backlinking Button");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.dummyWait(2);
        boolean backlinkingSuccessStatus = commonFunctions.checkElementTextWithTryCatch(autoBacklinkingSuccess, expMessage.trim(), 10, "Auto Backlinking Success");
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        commonFunctions.dummyWait(2);
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);

        //Need to implement DB part and change return value accordingly. As ravinder is working on DB part after that we need to implement.
        System.out.println(dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", storyIdNumber, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline));
        return backlinkingSuccessStatus;
    }

    @Override
    public boolean checkTheNameConventionForMoengageNotification(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String moengageUrl, String moengageLoginUserName, String moengageLoginPassword) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStandardStoryWithoutSwitch(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.hardWait(2000);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        commonFunctions.hardWait(2000);
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);
        commonFunctions.hardWait(5000);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        commonFunctions.scrollPageWithJS(socialNotificationSendButton, 10);
        commonFunctions.clickElement(socialNotificationSendButton, 10, "Social Notification Send Button");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(socialNotificationSuccessMessage, 10);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        return observeMoengageDashboard(moengageUrl, moengageLoginUserName, moengageLoginPassword, storyIdNumber);
    }

    public boolean observeMoengageDashboard(String url, String userName, String password, String articleId) {
        commonFunctions.navigateToUrl(url);
        commonFunctions.isElementPresentWithTryCatch(moengageEmail, 20);
        commonFunctions.sendKeys(moengageEmail, userName, 10, "User Name");
        commonFunctions.isElementPresentWithTryCatch(moengagePassword, 20);
        commonFunctions.sendKeys(moengagePassword, password, 10, "Password");
        commonFunctions.isElementPresentWithTryCatch(moengageLogin, 20);
        commonFunctions.clickElement(moengageLogin, 10, "Moengage Login Btn");
        commonFunctions.isElementPresentWithTryCatch(moengageStorySearchTxt, 20);
        commonFunctions.dummyWait(10);
        int count = 0;
        boolean storyStatus = false;
        do {
            commonFunctions.sendKeys(moengageStorySearchTxt, articleId, 10, "Moengage Story Search Txt");
            commonFunctions.dummyWait(5);
            commonFunctions.sendKeysWithEnter(moengageStorySearchTxt, 10);
            commonFunctions.dummyWait(10);
            if (moengageStorySearchResult.size() > 0) {
                storyStatus = commonFunctions.checkTextContains(articleId, commonFunctions.getElementText(moengageStorySearchResult.get(0)), "Moengage Story Search");
                break;
            }

            count = count + 1;
        } while (count < 10);

        return storyStatus;
    }

    @Override
    public boolean checkTheNameConventionForScheduledNotification(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String moengageUrl, String moengageLoginUserName, String moengageLoginPassword) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStandardStoryWithoutSwitch(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        commonFunctions.dummyWait(2);
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
        }
        commonFunctions.dummyWait(2);
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 20);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollPageWithJS(sendNotificationLink, 20);
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "sendNotificationLink");
        commonFunctions.isElementPresentWithTryCatch(sendNotificationText, 20);
        commonFunctions.clickElement(scheduleNotificationButton, 10, "Schedule Notification Button");
        commonFunctions.isElementPresentWithTryCatch(scheduleNotificationNextDay, 20);
        commonFunctions.clickElement(scheduleNotificationNextDay, 10, "Next Day");
        commonFunctions.isElementPresentWithTryCatch(scheduleNotificationApplyBtn, 20);
        commonFunctions.clickElement(scheduleNotificationApplyBtn, 10, "Next Day");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementPresentWithTryCatch(socialNotificationSuccessMessage, 10);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        return observeMoengageDashboard(moengageUrl, moengageLoginUserName, moengageLoginPassword, storyIdNumber);
    }

    @Override
    public boolean checkSlugOptionInNotificationWindows(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String slugNotification) {
        String actualText = "";
        boolean status = false;
        checkSendNotificationPopupShouldOpen(property, headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.clickElementWithJS(notificationType, 10, "Notification dropdown");
        for (WebElement ele : notificationTypeOptions) {
            actualText = commonFunctions.getElementText(ele, 20);
            if (slugNotification.equalsIgnoreCase(actualText)) {
                status = true;
                Utils.logStepInfo(true, "Slug option is available");
                break;
            }
        }
        return status;
    }

    @Override
    public boolean checkNotificationTypeAsSlug(String property, String title, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String slugNotification) {
        String actualText = "";
        boolean status = false;
        checkSendNotificationPopupShouldOpen(property, title, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.clickElementWithJS(notificationType, 10, "Notification dropdown");
        for (WebElement ele : notificationTypeOptions) {
            actualText = commonFunctions.getElementText(ele, 20);
            if (slugNotification.equalsIgnoreCase(actualText)) {
                commonFunctions.clickElementWithJS(ele, 10, "slug dropdown value");
                status = commonFunctions.compareTexts(commonFunctions.getAttributeValue(notificationDescription, 10, "ng-reflect-model"), title);
                break;
            }
        }
        return status;
    }

    @Override
    public boolean checkSelectRelatedStoriesMutipleTimesInStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElement(buttonRelatedStoryList.get(1), 10, "Insert how to story Icon");
        boolean isResult = commonFunctions.isElementDisplayed(contentListCloseButton,10);
        commonFunctions.clickElementWithJS(contentListCloseButton,10);
        commonFunctions.hardWait(2000);
        inputParagraph(paragraph);
        commonFunctions.clickElementWithJS(saveButton,10);
        commonFunctions.hardWait(5000);
        commonFunctions.clickElement(buttonRelatedStoryList.get(1), 10, "Insert how to story Icon");
        if(commonFunctions.isElementDisplayedWithExceptionHandling(socialNotificationSuccessMessage,10,"pop up message")){
            commonFunctions.clickElement(buttonRelatedStoryList.get(1), 10, "Insert how to story Icon");
        }
        isResult &= commonFunctions.isElementDisplayed(contentListCloseButton,10);
        commonFunctions.clickElementWithJS(contentListCloseButton,10);
        return isResult;
    }

    @Override
    public boolean checkSelectOtherRelatedStories(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.hardWait(3000);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        String secoundHeadLine = headLine + " " + commonFunctions.generateRandomNum();
        createStdStory(secoundHeadLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.hardWait(3000);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        String thirdHeadLine = secoundHeadLine + " " + commonFunctions.generateRandomNum();
        createStdStory(thirdHeadLine, summary + " " + commonFunctions.generateRandomNum(), paragraph + " " + commonFunctions.generateRandomNum(), byline, section, subsection, keyword, location, topic);
        commonFunctions.hardWait(3000);
        findRelatedStory(true, headLine.trim());
        commonFunctions.hardWait(3000);
        commonFunctions.scrollPageWithJS(relatedStoryChooseButton, 10);
        commonFunctions.clickElement(relatedStoryChooseButton, 10, "relatedStoryChooseButton");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(relatedStoryHeadline, 10);
        boolean firstRelatedStoryStatus = commonFunctions.getElementText(relatedStoryHeadline, headLine.trim(), 10).trim().equals(headLine.trim());
        commonFunctions.clickElementWithJS(relatedStoryEditIcon, 10, "Related Story Edit Icon");
        boolean checkStatus = validateRelatedStoryCheckedStatus(false, headLine.trim(), "rgb(33, 150, 243)", "border");
        boolean uncheckStatus = validateRelatedStoryCheckedStatus(true, secoundHeadLine.trim(), "rgb(221, 221, 221)", "border");
        commonFunctions.hardWait(3000);
        commonFunctions.scrollPageWithJS(relatedStoryChooseButton, 10);
        commonFunctions.clickElement(relatedStoryChooseButton, 10, "relatedStoryChooseButton");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(relatedStorySecHeadline, 10);
        boolean secoundRelatedStoryStatus = commonFunctions.getElementText(relatedStorySecHeadline, secoundHeadLine.trim(), 10).trim().equals(secoundHeadLine.trim());

        return firstRelatedStoryStatus && secoundRelatedStoryStatus && checkStatus && uncheckStatus;
    }

    public boolean validateRelatedStoryCheckedStatus(Boolean clickStatus, String headLine, String cValue, String cssName) {
        boolean flag = false;
        commonFunctions.dummyWait(10);
        commonFunctions.isElementPresentWithTryCatch(relatedStoryList.get(0), 10);
        int checkSize = relatedStoryCheckList.size();
        int size = relatedStoryList.size();
        for (int i = 0; i < size; i++) {
            commonFunctions.scrollPageWithJS(relatedStoryList.get(i), 10);
            if (commonFunctions.getElementText(relatedStoryList.get(i)).trim().equals(headLine.trim())) {
                String cssValue = commonFunctions.getParticularCssValue(relatedStoryCheckList.get(i), 10, "Related Story Check Box", cssName);
                System.out.println("cssValue: " + cssValue);
                if (cssValue.contains(cValue)) {
                    flag = true;
                }
                if (clickStatus) {
                    commonFunctions.clickElement(relatedStoryList.get(i), 10, headLine);
                }
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean checkSelectSameRelatedStoryInOtherPostsForSingleStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String cssName, String cssValue) {
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        commonFunctions.hardWait(3000);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        String thirdHeadLine = headLine + " " + commonFunctions.generateRandomNum();
        createStdStory(thirdHeadLine, summary + " " + commonFunctions.generateRandomNum(), paragraph + " " + commonFunctions.generateRandomNum(), byline, section, subsection, keyword, location, topic);
        commonFunctions.hardWait(3000);
        findRelatedStory(true, headLine.trim());
        commonFunctions.hardWait(3000);
        commonFunctions.scrollPageWithJS(relatedStoryChooseButton, 10);
        commonFunctions.clickElement(relatedStoryChooseButton, 10, "relatedStoryChooseButton");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(relatedStoryHeadline, 10);
        boolean firstRelatedStoryStatus = commonFunctions.getElementText(relatedStoryHeadline, headLine.trim(), 10).trim().equals(headLine.trim());
        inputParagraph(paragraph + " " + commonFunctions.generateRandomNum());
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(buttonRelatedStoryList.get(0), 10);
        commonFunctions.clickElement(buttonRelatedStoryList.get(0), 10, "Inline Related Story Icon");
        commonFunctions.hardWait(5000);
        boolean checkStatus = validateRelatedStoryCheckedStatus(true, headLine.trim(), cssValue, cssName);
        commonFunctions.hardWait(3000);
        commonFunctions.scrollPageWithJS(relatedStoryChooseButton, 10);
        commonFunctions.clickElement(relatedStoryChooseButton, 10, "relatedStoryChooseButton");
        commonFunctions.hardWait(3000);
        commonFunctions.isElementPresentWithTryCatch(relatedStorySecHeadline, 10);
        boolean secoundRelatedStoryStatus = commonFunctions.getElementText(relatedStorySecHeadline, headLine.trim(), 10).trim().equals(headLine.trim());

        return firstRelatedStoryStatus && checkStatus && secoundRelatedStoryStatus;
    }

    @Override
    public boolean checkIfSeoScorePrePublish(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword1, String keyword2) {
        openNewStandardStory();
        Set<String> windowsList1 = null;
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, keyword1, keyword2);
        commonFunctions.scrollToElementView(seoScoreButton, 10, "scroll to seo score");
        commonFunctions.clickElement(seoScoreButton, 10);
        windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
        commonFunctions.switchToLastWindow(windowsList1);
        commonFunctions.sendKey(seoSearch, headLine);
        commonFunctions.sendKeysWithEnter(seoSearch, 10);
        String seoScore = commonFunctions.getElementText(getSeoScore, 10);
        int bySymbol = seoScore.indexOf("/");
        String seoScoreTrimmed = seoScore.substring(0, bySymbol);
        return Integer.parseInt(seoScoreTrimmed) >= 0 && Integer.parseInt(seoScoreTrimmed) <= 100;
    }

    @Override
    public boolean checkIfSeoScorePostPublish(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword1, String keyword2) {
        openNewStandardStory();
        Set<String> windowsList1 = null;
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, keyword1, keyword2);
        commonFunctions.clickElementIfDisplayed(publishButton);
        boolean isPublished = commonFunctions.isElementDisplayed(popupPublishButton, 10);
        String seoScore = "";
        String seoScoreTrimmed = "";
        if (isPublished) {
            commonFunctions.scrollToElementView(seoScoreButton, 10, "scroll to seo score");
            commonFunctions.clickElement(seoScoreButton, 10);
            windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            commonFunctions.switchToLastWindow(windowsList1);
            commonFunctions.sendKey(seoSearch, headLine);
            commonFunctions.sendKeysWithEnter(seoSearch, 10);
            seoScore = commonFunctions.getElementText(getSeoScore, 10);
            int bySymbol = seoScore.indexOf("/");
            seoScoreTrimmed = seoScore.substring(0, bySymbol);
        }
        return Integer.parseInt(seoScoreTrimmed) >= 0 && Integer.parseInt(seoScoreTrimmed) <= 100;
    }

    public void fillStoryDetails(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword1, String keyword2) {
        boolean elementStatus = commonFunctions.isElementPresentWithTryCatch(hButton, 20);
        elementStatus &= !commonFunctions.isElementPresentWithTryCatch(sixDotsButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(alignmentButton, 20);
        elementStatus &= commonFunctions.isElementPresentWithTryCatch(paragraphDeleteButton, 20);
        headLine = headLine + commonFunctions.generateRandomNum();
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputByLine(byline);
        inputSection(section);
        inputSubSection(subsection);
        inputKeywords(keyword1);
        inputKeywords(keyword2);
        inputLocation("pune");
    }

    @Override
    public boolean checkIfWatchAsPrefixIsDisplayedInBoldAboveVideoEmbed(String preText) {
        openNewStandardStory();
        insertVideo();
        commonFunctions.isElementDisplayed(getParagraphText, 10);
        String text = commonFunctions.waitAndGetElementTextIgnoringStaleElement(getParagraphText, 10, "element text");
        return text.substring(0, 6).equalsIgnoreCase(preText);
    }

    @Override
    public boolean checkIfUserIsAbleToCreateStandardStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        boolean isPublished = createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        if (isPublished) {
            commonFunctions.hardWait(2000);
            commonFunctions.scrollToElementViewAndClick(generatedUrl, 10, "url generated");
            Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            if (windowsList.size() == 3) return true;
        }
        return false;
    }

    @Override
    public boolean checkIfGeneratedUrlRedirectingToTheCorrectFrontendStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        boolean isPublished = createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        if (isPublished) {
            commonFunctions.hardWait(2000);
            commonFunctions.scrollToElementView(generatedUrl, 10, "url generated");
            String urlGenerated = commonFunctions.getElementText(generatedUrl, 10);
            commonFunctions.scrollToElementViewAndClick(generatedUrl, 10, "url generated");
            Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            if (windowsList.size() == 3) {
                commonFunctions.switchToLastWindow(windowsList);
                String storyUrl = commonFunctions.getURL();
                if (urlGenerated.equals(storyUrl)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkEditStory(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {

        commonFunctions.waitForElementBeDisplayAndClick(selectedStory, 30, "selected story");
        editHeadline(headline);
        editSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();
        commonFunctions.navigateBack();
        searchStoryByIDAndSelect(storyIdNumber);
        String actual = commonFunctions.getElementText(enterHeadlineText, 10);
        Utils.logStepInfo(true,"actual:- "+actual);
        Utils.logStepInfo(true,"headline:- "+headline);

        return actual.trim().equalsIgnoreCase(headline.trim());
    }

    @Override
    public boolean checkIfTheStatusColumnIsDisplayedCreatedTextIfUserCreatedTheStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String embedUrl) {
        String storyId = createStandardStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic, embedUrl);
        searchStoryByID(storyId);
        return commonFunctions.waitAndGetElementTextAndCheck(storyStatus, "CREATED", 30, "Correct text is");
    }

    @Override
    public boolean checkIfTheStatusColumnShouldDisplayEditedTextIfUserDoNotApplyScheduleTimeToPublishTheStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, keyword, leadMediaCaption);
        String storyId = setStoryId();
        fileStoryAndFinishEditing();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        searchStoryByID(storyId);
        return commonFunctions.waitAndGetElementTextAndCheck(storyStatusEdited, "EDITED", 30, "Correct text is");
    }

    @Override
    public boolean checkIfTheStatusColumnShouldDisplayScheduledTextIfUserScheduleFixTimeToPublishTheStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, keyword, leadMediaCaption);
        String storyId = setStoryId();
        schedulePublish();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        searchStoryByID(storyId);
        return commonFunctions.waitAndGetElementTextAndCheck(storyStatusScheduled, "SCHEDULED", 30, "Correct text is");

    }

    @Override
    public boolean checkIfTheStatusColumnShouldDisplayFiledTextIfStoryIsOnlyFiled(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, keyword, leadMediaCaption);
        String storyId = setStoryId();
        commonFunctions.clickElementWithJS(buttonFileStoryForEdit, 10, "File Button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        searchStoryByID(storyId);
        return commonFunctions.waitAndGetElementTextAndCheck(storyStatusFiled, "FILED", 30, "Correct text is");
    }

    @Override
    public boolean checkIfUserIsAbleToKillThePublishedStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        boolean isPublished = createStdStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        if (isPublished) {
            commonFunctions.clickElement(appLogo, 20);
        }
        return killStoryAndVerify();
    }

    @Override
    public boolean checkIftUserIsAbleToOpenStoryOfMintGenieTenant() {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        return windowsList.size() == 2;
    }

    @Override
    public boolean checkIfTheBackgroundColorOfScheduledTextIsSameAsTextColor(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption, String backgroundColor, String textColor) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, keyword, leadMediaCaption);
        String storyId = setStoryId();
        schedulePublish();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        searchStoryByID(storyId);
        boolean isBgColorSame = commonFunctions.getBackgroundColorOfWebElement(scheduledStory, 10, "scheduled status", "background-color").equalsIgnoreCase(backgroundColor);
        boolean isColorSame = commonFunctions.getColorOfWebElement(scheduledStory, 10, "scheduled status", "color").equalsIgnoreCase(textColor);
        return isBgColorSame && isColorSame;
    }

    public void filterScheduledStories(){
        commonFunctions.clickElementIfDisplayed(moreFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(statusScheduled,10);
    }
    @Override
    public boolean CheckIfGreyBackgroundColorShouldBePresentAroundScheduledText(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption, String backgroundColor) {
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, keyword, leadMediaCaption);
        schedulePublish();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.refreshPage();
        filterScheduledStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.hardWait(3000);
        return commonFunctions.getBackgroundColorOfWebElement(StoryStatusScheduled,10,"scheduled status","background-color").equalsIgnoreCase(backgroundColor);
    }

    private void editHeadline(String headline) {
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        commonFunctions.sendKeys(enterHeadlineText, headline, 10, "HeadlineText");
    }

    private void editSummary(String summary) {
        commonFunctions.isElementDisplayedAndPresent(addSummaryText, 20, "Summary field");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        commonFunctions.clickElement(deleteSummaryButton, 10, "deleteSummaryButton");
        commonFunctions.hardWait(5000);
        commonFunctions.refreshPage();
        commonFunctions.hardWait(5000);
        commonFunctions.clickElement(addSummaryText, 10, "addSummaryText");
        commonFunctions.sendKeyWithActions(addSummaryText, summary);
    }

    @Override
    public boolean checkIfInsertSampleImagesElementIsPresentInInlineElements() {
        openNewStandardStory();
        return commonFunctions.isElementDisplayed(sampleImagesElement, 10, "sample images element");
    }

    @Override
    public boolean checkActionOnClickOfClickInsertSampleImagesElementIcon() {
        openNewStandardStory();
        commonFunctions.clickElementIfDisplayed(sampleImagesElement, 10, "sample images element");
        return commonFunctions.isElementDisplayed(uploadNewFilesOption, 10, "upload new files") &&
                commonFunctions.isElementDisplayed(pickImageOption, 10, "pick from image library");
    }

    private void selectMultipleImageFromSampleImagesLibrary() {
        commonFunctions.clickElementIfDisplayed(pickImageOption, 10, "pick from image library");
        commonFunctions.hardWait(5000);
        commonFunctions.clickElement(imgInLib, 10, "Library Image");
        commonFunctions.hardWait(3000);
        commonFunctions.clickElement(imgInLibSecond, 10, "Library Image");
        commonFunctions.scrollPageWithJS(chooseButtonInImageGallery, 10);
        commonFunctions.clickElementWithJS(chooseButtonInImageGallery, 10, "choose Button");
        commonFunctions.checkElementText(allChangesSaved, "SAVING CHANGES...", 20, "wait for saving changes ");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for all changed are saved");
    }

    @Override
    public boolean checkIfUserIsAbleToUploadFilesUsingPickFromGalleryButton() {
        openNewStandardStory();
        commonFunctions.clickElementIfDisplayed(sampleImagesElement, 10, "sample images element");
        selectMultipleImageFromSampleImagesLibrary();
        return commonFunctions.isElementDisplayed(uploadedSampleImages.get(0),10,"first image") &&
                commonFunctions.isElementDisplayed(uploadedSampleImages.get(1),10,"second image");
    }

    @Override
    public boolean checkIfSampleImageIdsPresentInMasterDb() {
        openNewStandardStory();
        commonFunctions.clickElementIfDisplayed(sampleImagesElement, 10, "sample images element");
        selectMultipleImageFromSampleImagesLibrary();
        commonFunctions.hardWait(10000);
        return commonFunctions.isElementDisplayed(uploadedSampleImages.get(0)) &&
                commonFunctions.isElementDisplayed(uploadedSampleImages.get(1));
        //DB verification will be done once I get the KT session from raj.
    }

    @Override
    public boolean checkIfUserIsAbleToAddHyperLinkToRequiredWord(String hyperLink, String paragraphText) {
        openNewStandardStory();
        commonFunctions.hardWait(2000);
        inputParagraph(paragraphText);
        commonFunctions.clickElementIfDisplayed(addParagraphText, 10);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("a");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        actions.keyDown(Keys.CONTROL);
        actions.keyDown(Keys.SHIFT);
        actions.sendKeys("h");
        actions.keyUp(Keys.CONTROL);
        actions.keyUp(Keys.SHIFT);
        actions.build().perform();
        commonFunctions.hardWait(5000);
        commonFunctions.sendKeys(addHyperLink, hyperLink, 10, "hyperlink");
        commonFunctions.clickElementIfDisplayed(submitHyperLink, 10);
        return commonFunctions.isElementDisplayed(hyperLinkedWord, 10, "hyperlinkedWord");
    }

    @Override
    public boolean checkIfUserIsAbleToSeeSubSectionL2FieldInMetaDataSection() {
        openNewStandardStory();
        commonFunctions.hardWait(2000);
        return commonFunctions.isElementDisplayedAndPresent(SubSectionL2Field, 10, "sub section L2");
    }

    private boolean publishStoryOperation(WebElement publishButton, WebElement yesButton, WebElement popupPublishButton) {
        boolean result = true;
        commonFunctions.clickElement(publishButton, 10, "Publish Button");
        if (!commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 10, "published successfully message")) {
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
            result = commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 10, "published successfully message");
        }
        return result;
    }

    @Override
    public boolean checkIfUserIsAbleToCreateStandardStoryAfterFillingSubSectionL2Field(String headLine, String summary, String paragraph, String byline, String section, String subsection, String subsectionL2) {
        boolean flag = false;
        openNewStandardStory();
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, section, subsection);
        inputSubSectionL2(subsectionL2);
        flag = publishStoryOperation(publishButton, yesButton, popupPublishButton);
        return flag;
    }

    @Override
    public boolean checkIfSubSectionl2ShouldNotBeUsedToCreateUrlOfTheStory(String headLine, String summary, String paragraph, String byline, String section, String subsection, String subsectionL2) {
        boolean flag = false;
        String urlText="";
        openNewStandardStory();
        fillStoryDetails(headLine, summary, paragraph, byline, section, subsection, section, subsection);
        inputSubSectionL2(subsectionL2);
        flag = publishStoryOperation(publishButton, yesButton, popupPublishButton);
        if (flag) {
            commonFunctions.scrollPageWithJS(generatedUrl, 10);
             urlText= commonFunctions.getElementText(generatedUrl,10);
        }
        return !urlText.contains("ui-sub-subsection-L2");
    }

    @Override
    public boolean checkIfUserIsAbleToClickOnStandardStory() {
        selectStandardStory();
        Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        return windowsList.size() == 2;
    }

    @Override
    public boolean checkIfUserCanSeeHeadlineSummaryAndParagraphInNewStory() {
        openNewStandardStory();
        return commonFunctions.isElementDisplayed(enterHeadlineText,10,"headline field") &&
                commonFunctions.isElementDisplayed(addSummaryText,10,"summary field") &&
                commonFunctions.isElementDisplayed(addParagraphText,10,"paragraph field");
    }

    @Override
    public boolean checkIfUserIsAbleToAddHeadlineToStory(String headline) {
        openNewStandardStory();
        commonFunctions.hardWait(1000);
        inputHeadline(headline);
        return commonFunctions.getElementTextAndCheck(enterHeadlineText,headline,10,"headline text");
    }

    @Override
    public boolean checkIfUserIsAbleToAddSummaryToStory(String summary) {
        openNewStandardStory();
        commonFunctions.hardWait(1000);
        inputSummary(summary);
        return commonFunctions.getElementTextAndCheck(addSummaryText,summary,10,"summary text");
    }

    @Override
    public boolean checkIfUserIsAbleToAddParagraphToStory(String paragraph) {
        openNewStandardStory();
        commonFunctions.hardWait(1000);
        inputParagraph(paragraph);
        return commonFunctions.getElementTextAndCheck(addParagraphText,paragraph,10,"paragraph text");
    }

    @Override
    public boolean checkIfUserIsAbleToSeeHeadlineSummaryParagraphInDb(String headline, String summary, String paragraph) {
        boolean isResult=true;
        openNewStandardStory();

        commonFunctions.waitForElementToBeVisibleAndClickable(enterHeadlineText,10,"headline");
        inputHeadline(headline);
        isResult&=commonFunctions.getElementTextAndCheck(enterHeadlineText,headline,10,"headline text");

        commonFunctions.waitForElementToBeVisibleAndClickable(addSummaryText,10,"headline");
        inputSummary(summary);
        isResult&=commonFunctions.getElementTextAndCheck(addSummaryText,summary,10,"summary text");

        commonFunctions.waitForElementToBeVisibleAndClickable(addParagraphText,10,"headline");
        inputParagraph(paragraph);
        isResult&=commonFunctions.getElementTextAndCheck(addParagraphText,paragraph,10,"paragraph text");
        commonFunctions.clickElement(saveButton,10);

        saveStandardStoryAndVerify();
        setStoryId();
        return isResult;
    }

    @Override
    public boolean checkIfParagraphElementCreatedAfterInsertingVideo() {
        openNewStandardStory();
        insertVideo();
        return commonFunctions.isElementDisplayed(secondParagraph,10,"paragraph element");
    }

    @Override
    public boolean checkIfUserCanUploadImagesFromUploadNewFilesOptionInInline() {
        openNewStandardStory();
        String projectPath =System.getProperty("user.dir")+"/testimage.jpeg";
        commonFunctions.clickElement(sampleImagesElement,10);
        commonFunctions.clickElement(uploadNewImageFile);
        uploadNewImageFile.sendKeys(projectPath);
        commonFunctions.clickElementIfDisplayed(doneButton,10);
        commonFunctions.hardWait(10000);
        return commonFunctions.isElementDisplayedWithExceptionHandling(leadImage,10,"lead image");

    }


}