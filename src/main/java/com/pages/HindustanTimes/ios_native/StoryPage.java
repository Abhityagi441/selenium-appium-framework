package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class StoryPage extends CommonStoryPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement hamburgerMenu;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='india'][1]")
//    private static MobileElement india;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='India']")
    private static MobileElement india;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='E-Paper']")
    private static MobileElement ePaperCTA;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='banner']/XCUIElementTypeOther[3]/XCUIElementTypeImage")
    private static WebElement homeEpaper;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Photos']")
    private static MobileElement photos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Videos']")
    private static MobileElement videos;

    @iOSXCUITFindBy(id = "VIDEOS")
    private static MobileElement videoOnVideosPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeButton[@name='three white']/following-sibling::XCUIElementTypeStaticText\n")
    private static MobileElement videoStroyTitle;

    @iOSXCUITFindBy(id = "play new")
    private static MobileElement playButton;

    @iOSXCUITFindBy(id = "PHOTOS")
    private static MobileElement allPhoto;

   // @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'Photos:')])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='icn photos featured'])[1]")
    private static MobileElement photoStory;


    @iOSXCUITFindBy(id = "btn next enabled")
    private static MobileElement buttonnext;

    @iOSXCUITFindBy(id = "share default")
    private static MobileElement shareDefault;

    @iOSXCUITFindBy(accessibility = "you may also like...")
    private static MobileElement youMayAlsoLike;

    @iOSXCUITFindBy(id = "back new")
    private static MobileElement backButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='share default']/preceding-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> storiesBelowYouMayAlsoLike;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next Gallery']")
    private static MobileElement nextStory;

    String nextStoryAccesibility = "next story";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='next story']/following-sibling:: XCUIElementTypeStaticText")
    private static MobileElement storybesideNextStroy;

    @iOSXCUITFindBy(accessibility = "Next Video")
    private static MobileElement nextVideo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Tokyo')]")
    private static MobileElement sports;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cities']")
    private static MobileElement cities;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Elections']")
    private static MobileElement elections;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Opinion']")
    private static MobileElement opinion;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='World']")
    private static MobileElement world;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'1/')]")
    private static MobileElement noOfNext;

    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private static MobileElement storyText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Video')]")
    private static MobileElement videoPlayer;

    @iOSXCUITFindBy(id = "Label")
    private static MobileElement storyContents;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='share whatsapp']/following-sibling:: XCUIElementTypeStaticText")
    private static MobileElement storyDetails;

    @iOSXCUITFindBy(id = "play new")
    private static List<MobileElement> noOfVideos;

    @iOSXCUITFindBy(id = "ht nav logo")
    private static MobileElement htLogo;

    @iOSXCUITFindBy(id = "htNewLogo")
    private static MobileElement htLogoOnStoryPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[5]")
    private static MobileElement linkStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'ebBannerIFrame')]")
    private static MobileElement advertise;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Blank\"])[2]/XCUIElementTypeOther[4]")
    private static MobileElement topAddver;

    @iOSXCUITFindBy(className = "XCUIElementTypeLink")
    private static List<MobileElement> bottomAdver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'• ')]")
    private static MobileElement liveBlogStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'next story')]")
    private static MobileElement nextStoryOnLiveBlog;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'you may also like')]")
    private static MobileElement youMayAlsoLikeOnLiveBlog;

    @iOSXCUITFindBy(id = "Label")
    private static MobileElement storyDetailPage;

    private static String youMayAlsoLikeString = "you may also like...";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static MobileElement threeDots;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Related Topics']")
    private static MobileElement relatedTopics;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='topic']")
    private static MobileElement topic;

    @iOSXCUITFindBy(id = "twitter")
    private static MobileElement twitter;

    @iOSXCUITFindBy(id = "share whatsapp")
    private static MobileElement whatsApp;

    @iOSXCUITFindBy(id="Home")
    private static MobileElement home;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Explore']")
    private static MobileElement exploreButton;

    @iOSXCUITFindBy(id = "India")
    private static MobileElement indiaSection;

    @iOSXCUITFindBy(id = "INDIA")
    private static MobileElement indiaLandingPage;

    @iOSXCUITFindBy(id = "Bookmark")
    private static MobileElement bottomActionSheet;

    @iOSXCUITFindBy(id = "Share")
    private static MobileElement shareOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Messages']")
    private static MobileElement shareSheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Close']")
    private static MobileElement cancel;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='ADVERTISEMENT'])[1]")
    private static MobileElement topAdvertisement;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='three white'])[1]")
    private static MobileElement leadImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static List<MobileElement> allStories;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='INDIA NEWS']")
    private static MobileElement sectionNameBelowTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='INDIA NEWS']")
    private static MobileElement sectionPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText")
    private  static  MobileElement firstStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cities']/following-sibling::XCUIElementTypeButton")
    private static MobileElement CitiesExploreButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Noida']")
    private static MobileElement noidaSubSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText[1]")
    private static MobileElement clickFirstStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NOIDA NEWS']")
    private static MobileElement SubsectionPageOfNoida;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'BY')]")
    private static MobileElement authorNameInStory;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
    private static MobileElement updatedBy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Premium']")
    private static MobileElement premiumButton;
    //XCUIElementTypeImage[@name='premiumHeader']
    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeImage[@name='premiumHeader']")
    private static MobileElement imagePremium;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name='Related Topics']")
    private static MobileElement relatedTopic;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name='Related Topics']/parent:: XCUIElementTypeCell/XCUIElementTypeStaticText")
    private static List<MobileElement> relatedTopicsList;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeButton[@name='back new']/parent::XCUIElementTypeNavigationBar//XCUIElementTypeStaticText[contains(@name,'')]")
    private static MobileElement relatedTopicPageHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyCaption;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[4]")
    private static MobileElement storyParagraph;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']/parent::XCUIElementTypeCell/XCUIElementTypeButton[2]")
    private static MobileElement sectionNameInFirstStoryInTopic;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Close']")
    private static MobileElement  closeBtnInAd;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Read Aloud']")
    private static MobileElement readAloudOptionInStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeStaticText[@name='Cities']/following-sibling::XCUIElementTypeButton")
    private static MobileElement downArrowInCities;

    @iOSXCUITFindBy(id = "Close")
    private static MobileElement closeBtnInShareSheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cities']")
    private static MobileElement citiesSection;

    @iOSXCUITFindBy(id= "Got It")
    private static MobileElement gotItButtonOnCitiesPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='DeselectdCity']/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listOfUnselectedCities;

    @iOSXCUITFindBy(id = "Save Changes")
    private static MobileElement saveChangesButtonOnCitiesSection;

    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        // Utils.logStepInfo("This is sttarted");
        /*commonFunctions.clickElementIfDisplayed(allowTracking, 15, "Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 15, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(skipButton, 15, "skipButton");
        commonFunctions.clickElementIfDisplayed(notificationLater, 15, "notificationLater");*/
    }
    public boolean liveBlogContentValidation(String uri, String address, String url) {
        boolean isHomePage = commonFunctions.isElementDisplayed(htLogo, 5, "home page");
        boolean isLiveStory = commonFunctions.scrollToMobileElement(liveBlogStory);
        boolean clickLiveStory = false;
        String liveStoryHeadline="";
        if (isLiveStory) {
            liveStoryHeadline=commonFunctions.getAtribute(liveBlogStory,"name");
            clickLiveStory = commonFunctions.clickElement(liveBlogStory, 5, "live story");
        } else {
            Utils.logStepInfo("Live blog story not found");
        }
        String searchparam[]=liveStoryHeadline.split(" ");
        boolean storyLoadedProperly = checkStoryDetailPageLoaded(searchparam[2]);
        commonFunctions.scrollUsingNameiOS(nextStoryAccesibility);
        boolean isNextStory = commonFunctions.scrollToMobileElement(nextStory);
        boolean isStory = commonFunctions.isElementDisplayed(storybesideNextStroy, 5, "Story beside next story");

        boolean isYouMayAlso = commonFunctions.scrollToMobileElement(youMayAlsoLike);
        boolean isStoryBelow = storiesBelowMayAlso();

        return isHomePage && isLiveStory && clickLiveStory && storyLoadedProperly && isNextStory && isStory && isYouMayAlso && isStoryBelow;
    }


    public boolean storiesBelowMayAlso() {

        boolean isStep = false;
        for (int i = 0; i < 2; i++) {
            isStep = commonFunctions.isElementDisplayed(storiesBelowYouMayAlsoLike.get(i), 5, "Stories below you may also like");
        }
        return isStep;
    }

    public boolean checkStoryDetailPageLoaded(String value) {
        boolean storyContent = commonFunctions.isElementDisplayed(commonFunctions.getElementByNameContains(value), 10, "Check story details");
        boolean onStoryPage = commonFunctions.isElementDisplayed(storyDetailPage, 10, "Story page");


        return storyContent && onStoryPage;
    }

    public boolean checkStoryDetailPageLoaded() {
        boolean storyContent = commonFunctions.isElementDisplayed(storyText);
        boolean onStoryPage = commonFunctions.isElementDisplayed(storyDetailPage, 10, "Story page");


        return storyContent && onStoryPage;
    }

    @Override
    public boolean checkLastPublishedDate(String[] params) {
        return false;
    }

    @Override
    public boolean photosGalleryContentValidation() {
        return false;
    }


    public boolean videoStoryContentValidation(String params[]) {
        boolean clickHamburger = commonFunctions.clickElement(hamburgerMenu);
        Utils.logStepInfo(clickHamburger, "Clicked on Hamburger");
        boolean isIndia = commonFunctions.isElementDisplayed(india);
        Utils.logStepInfo(isIndia, "India is visible");


        boolean isCity = commonFunctions.isElementDisplayed(cities);
        Utils.logStepInfo(isCity, "City is displayed");

        boolean isOpinion = commonFunctions.isElementDisplayed(opinion);
        Utils.logStepInfo(isOpinion, "Lifestyle is displayed");

        boolean isWorld = commonFunctions.isElementDisplayed(world);
        Utils.logStepInfo(isWorld, "World is displayed");

        commonFunctions.scrollUpToElementDisplayed(videos);
//        Utils.logStepInfo("Scroll till Videos");
        commonFunctions.dummyWait(5);

        boolean clickVideo = commonFunctions.clickElement(videos);
        Utils.logStepInfo(clickVideo, "Click on Videos");

        boolean checkVideo = commonFunctions.isElementDisplayed(videoOnVideosPage, 10, "video on Videos");
        Utils.logStepInfo(checkVideo, "Successfully Landed on Videos page");


        String storyTitle = commonFunctions.getElementText(videoStroyTitle, 10);
        Utils.logStepInfo(storyTitle);
        String [] name=storyTitle.split(" ");
        boolean openVideo = commonFunctions.clickElement(videoStroyTitle, 10, "Video Story");
        Utils.logStepInfo(openVideo, "Opened video");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip button");

        boolean isVideoPlaying = commonFunctions.isElementDisplayed(videoPlayer, 10, "Video Player");
        Utils.logStepInfo(isVideoPlaying, "Video is playing");

        boolean storyDetail = commonFunctions.isElementDisplayed(commonFunctions.getElementByNameContains(name[0]), 10, "Check story details");
        Utils.logStepInfo(storyDetail, "Verified Video Story details");

//        boolean storyContent = commonFunctions.isElementDisplayed(storyContents, 10, "Verifying Story contents");
//        Utils.logStepInfo(storyContent, "Story Content is displayed");


        commonFunctions.scrollDown();
        boolean wthmre = commonFunctions.isElementDisplayed(nextVideo, 10, "Next Video");

        commonFunctions.clickElement(backButton);


        return isIndia && isCity  && isOpinion && isWorld && clickHamburger && clickVideo && checkVideo && wthmre;
    }


    public boolean photoHeadLineSummaryBookMarkAndShare(String uri, String address) {
        boolean clickHamburger = commonFunctions.clickElement(hamburgerMenu);
        Utils.logStepInfo(clickHamburger, "Clicked on Hamburger");
        boolean isIndia = commonFunctions.isElementDisplayed(india, 10, "India");
        Utils.logStepInfo(isIndia, "India is visible");
        commonFunctions.scrollDown();
        Utils.logStepInfo("Scroll till photos");
        boolean clickPhoto = commonFunctions.clickElement(photos);
        Utils.logStepInfo(clickPhoto, "Click on Photos");
        boolean allPhotoDisplayed = commonFunctions.isElementDisplayed(allPhoto, 5, "All Photo");
        Utils.logStepInfo(allPhotoDisplayed, "Verify all photos visible");
        boolean clickPhotoStory = commonFunctions.tapElementWithCoOrdinates(200,250,"photo story");
        //boolean clickPhotoStory = commonFunctions.clickElement(photoStory);
        Utils.logStepInfo(clickPhotoStory, "Click in photo story");
        commonFunctions.clickElement(skip,30,"Skip Button");
        //This part is no more applicable in the new App
      /*  boolean waitforNextButton = commonFunctions.isElementDisplayed(buttonnext, 5, "Next button");
        Utils.logStepInfo(waitforNextButton, "Next button is displayed");
        String num = commonFunctions.getElementText(noOfNext);
        char countC = num.charAt(2);
        int count = Character.getNumericValue(countC);

        for (int i = 1; i < count; i++) {
            boolean clickNext = commonFunctions.clickElement(buttonnext);
            Utils.logStepInfo(clickNext, "Click on next button");
            //TODO: Please validate headline of story detail page instead of element
            boolean storyContent = commonFunctions.isElementDisplayed(storyText);
            Utils.logStepInfo(storyContent, "Verified story content");
        }
*/
        //commonFunctions.scrollDown();
        commonFunctions.scrollUntilElementFound(nextStory);
        boolean nextSt = commonFunctions.isElementDisplayed(nextStory);
        Utils.logStepInfo(nextSt, "Next story is dislpayed");
        //youMayAlsoLike is not displayed in the new app
        /*boolean youMayAlso = commonFunctions.isElementDisplayed(youMayAlsoLike, 10, "you may also like");
        Utils.logStepInfo(youMayAlso, "You may like is also visible");
*/
        commonFunctions.clickElement(backButton);

        return clickHamburger && clickPhoto && allPhotoDisplayed && clickPhotoStory && nextSt && isIndia; //&& waitforNextButton;
    }

    @Override
    public boolean checkStandardStoryPagination(String uri, String address) {
        return false;
    }

    @Override
    public boolean checkContentImagesAndEmbeds(String[] params) {
        return false;
    }

    @Override
    public boolean checkSignInWallOnStoryPage() {
        return false;
    }

    @Override
    public boolean checkReadFullStoryClickable(String quickReadURL, String readSFullStoryText) {
        return false;
    }

    @Override
    public boolean checkReadFullStoryClickableinQuickReads() {
        return false;
    }

    @Override
    public boolean checkSignInWallOnStoryPage(String readtext, String premium, String saveArticles, String signIn, String signUp, String skip) {
        return false;
    }

    @Override
    public boolean checkLeadImage() {
        return commonFunctions.isVisible(leadImage);
    }

    @Override
    public boolean checkHeadline() {
        return false;
    }

    @Override
    public boolean checkStoryIsExpanded() {
        return false;
    }

    @Override
    public boolean checkDateTime() {
        boolean isDateTimeDisplay = false;
        commonFunctions.clickElement(home, 10, "Home Page");
        commonFunctions.clickElement(firstStory, 20,"First Story");
        commonFunctions.clickElement(skip, 10, "Skip");
        isDateTimeDisplay = commonFunctions.isElementDisplayed(updatedBy,10, "Latest Uploaded time");
        return isDateTimeDisplay;
    }

    @Override
    public boolean checkAuthorName() {
        boolean isAuthorNameInStory = false;
        commonFunctions.clickElement(home, 10, "Home Page");
        commonFunctions.clickElement(firstStory, 20,"First Story");
        commonFunctions.clickElement(skip, 10, "Skip");
        isAuthorNameInStory = commonFunctions.isElementDisplayed(authorNameInStory, 10, "Author Name");
        String authorName = commonFunctions.getElementText(authorNameInStory,10);
        return isAuthorNameInStory;
    }
    public boolean checkStoryPageHeader() {
        return false;
    }

    @Override
    public boolean checkTrendingTopicsCarouselDispayed() {
        return false;
    }

    @Override
    public boolean checkFullStoryCloseButton() {
        return false;
    }

    @Override
    public boolean checkNewsletterBannerDisplayed() {
        return false;
    }

    @Override
    public boolean checkImagePremiumDisplayed() {
        commonFunctions.clickElement(home, 10, "Home Button");
        Utils.logStepInfo("Clicking on Premium tab to open Premium Section.");
        commonFunctions.clickElement(premiumButton, 20, "Premium Button");
        commonFunctions.clickElement(clickFirstStory, 10, "Click First Story");
        commonFunctions.clickElement(skip, 10, "Skip");
        commonFunctions.dummyWait(5);
        boolean isImagePremiumDisplayed = commonFunctions.isElementEnabled(imagePremium,  "Premium Image");
        return isImagePremiumDisplayed;
    }


    @Override
    public boolean checkStoriesDisplayedLastPublished(String[] params) {
        return false;
    }

    @Override
    public boolean checkStandardStoriesAreDisplayed(String uri, String address) {
        commonFunctions.clickElement(home, 60, "Home button");
        boolean checkHomePageLoadedProperly = homePageLoadedProperly();
        commonFunctions.tapByCoordinate(180, 360, "story page");
        commonFunctions.dummyWait(5);
        boolean checkStoryPage = commonFunctions.isElementDisplayed(htLogoOnStoryPage, 5);
        boolean storyLoadedProperly = checkStoryDetailPageLoaded();
        boolean scrollBottom=scrollToBottom();
        boolean checkAdvertisement=commonFunctions.scrollToMobileElement(advertise);
        boolean checkNextStory = commonFunctions.isElementDisplayed(nextStory,5,"Next Story");
        boolean checkYouMayAlsoLike = commonFunctions.scrollToMobileElement(youMayAlsoLike);
        commonFunctions.clickElement(backButton, 5, "back button");
        boolean htLgo = commonFunctions.isElementDisplayed(htLogo, 5, "htLogo");

        return checkHomePageLoadedProperly && checkStoryPage && storyLoadedProperly && checkNextStory && checkYouMayAlsoLike && scrollBottom&& htLgo && checkAdvertisement;
    }

    public boolean scrollToBottom()

    {
        boolean onStoryPage = commonFunctions.isElementDisplayed(storyDetailPage, 10, "Story page loaded properly");
        boolean checkNextStory = commonFunctions.scrollToMobileElement(nextStory);

        return onStoryPage && checkNextStory;
    }


    public boolean homePageLoadedProperly()
    {
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"htLogo");
        //commonFunctions.scrollToTopOniOSNative();
        boolean topAdd=commonFunctions.isElementDisplayed(topAddver,10,"top advertisment");

        boolean botAdd=commonFunctions.isElementDisplayed(bottomAdver.get(bottomAdver.size()-3),10,"Bottom advertisment");

        return htLgo && topAdd && botAdd;

    }
    public boolean checkLeadImage3DotOption()
    {
        commonFunctions.clickElement(home, 60, "Home button");
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"htLogo");
        boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,10,"Three DOts");
        return htLgo && threeDotsDisplayed;

    }
    public boolean checkWhatsAppTwitterRelatedTopicPage()
    {
        commonFunctions.clickElement(home, 60, "Home button");
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"htLogo");
         //commonFunctions.clickElement(storyContents,30,"Story Contents");
         //commonFunctions.clickElementWithCoordinates(100,400);
        commonFunctions.clickElement(firstStory,5,"First Story");
        commonFunctions.clickElement(skip,10,"Skip");
        boolean twitterStatus =commonFunctions.isElementDisplayed(twitter,5,"Twitter");
        boolean whatsAppStatus =commonFunctions.isElementDisplayed(whatsApp,5,"Whatsapp");
        return htLgo && twitterStatus && whatsAppStatus;

    }
    public boolean checkShareStory3DotOption()
    {
        commonFunctions.clickElement(home, 5, "Home button");
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"htLogo");
        commonFunctions.clickElement(exploreButton, 5, "Profile page");
        commonFunctions.clickElement(indiaSection, 5, "Section page");
        boolean indiaSectionDisplayed=commonFunctions.isElementDisplayed(sectionPage,5,"INDIA NEWS");
        boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,5,"Three DOts");
        commonFunctions.clickElement(threeDots,5,"Three DOts");
        boolean isBottomActionSheetDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,5,"Bottom Action Sheet");
        commonFunctions.clickElement(shareOption,5,"Share");
        commonFunctions.isElementDisplayed(shareSheet,5,"Share Sheet");
        commonFunctions.clickElementIfDisplayed(closeBtnInShareSheet,5,"Close button");
        commonFunctions.clickElement(backButton,5,"Back button");
        return indiaSectionDisplayed && htLgo && threeDotsDisplayed&&isBottomActionSheetDisplayed;

    }
    public boolean checkActionSheetCancelOption()
    {
        commonFunctions.clickElement(home, 60, "Home button");
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"htLogo");
        commonFunctions.clickElement(exploreButton, 5, "Profile page");
//        commonFunctions.scrollUpUntilElementFound(indiaSection);
        commonFunctions.clickElement(indiaSection, 5, "Section page");
        boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,10,"Three DOts");
        commonFunctions.clickElement(threeDots,10,"Three DOts");
        boolean isBottomActionSheetDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,10,"Bottom Action Sheet");
        boolean clickCancelStatus=commonFunctions.clickElement(cancel,10,"Cancel");
        commonFunctions.isElementDisplayed(threeDots,10,"Three DOts");
        return htLgo && threeDotsDisplayed&&isBottomActionSheetDisplayed&&clickCancelStatus;

    }

    public boolean checkShareStoryFromIndia()
    {
        commonFunctions.clickElement(home, 20, "Home button");
        boolean homeSelected =commonFunctions.isElementSelected(home,5,"Home button");
        commonFunctions.clickElement(india, 5, "Section page");
        boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,10,"Three Dots");
        commonFunctions.clickElement(threeDots,10,"Three DOts");
        boolean isBottomActionSheetDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,10,"Bottom Action Sheet");
        commonFunctions.clickElement(shareOption,10,"Share");
        commonFunctions.isElementDisplayed(shareSheet,10,"Share Sheet");
        return homeSelected && threeDotsDisplayed&&isBottomActionSheetDisplayed;

    }

    @Override
    public boolean checkAllStoriesArePremiumOnPremmiumPage() {
        return false;
    }

    @Override
    public boolean checkPremiumPageDisplay() {
        return false;
    }

    @Override
    public boolean checkPremiumPageHTPremiumDisplay() {
        return false;
    }

    @Override
    public boolean checkFirstStoryDisplayAfterTitle() {
        return false;
    }

    @Override
    public boolean checkFirstStoryImageDisplayWithPremiumTag() {
        return false;
    }

    @Override
    public boolean checkOtherStoryAreAlsoPremium() {
        return false;
    }

    @Override
    public boolean checkAllOtherStoryHavePremiumTagAtBottom() {
        return false;
    }

    @Override
    public boolean checkStoryHaveSubSectionBelowTitle() {
        return false;
    }

    @Override
    public boolean checkStoryDisplayOnItsSectionPage() {
        return false;
    }

    @Override
    public boolean checkNonLoggedUserOnPremiumPage() {
        return false;
    }


    @Override
    public boolean checkSectionNameisDispayed() {
        boolean isSectionNameDisplayed;
        commonFunctions.clickElement(home, 20, "Home Button");
        boolean homeSelected =commonFunctions.isElementSelected(home,5,"Home button");
        boolean isLeadStoryTrue=commonFunctions.isElementDisplayed(leadImage, 20, "Lead Image");
        boolean otherStoriesTrue=commonFunctions.isElementDisplayedOfListOfElements(allStories,  "Other stories");
        isSectionNameDisplayed = commonFunctions.isElementDisplayed(sectionNameBelowTitle, 20, "Story Section Name below title");
        String sectionNameBelowStory=commonFunctions.getElementText(sectionNameBelowTitle, 20);
        commonFunctions.clickElement(sectionNameBelowTitle, 20, "Story Section Name below title");
        boolean isCorrectSectionNameDisplayed = commonFunctions.getElementText(sectionPage, 20).equalsIgnoreCase(sectionNameBelowStory);
        return homeSelected&&isLeadStoryTrue&&otherStoriesTrue&&isSectionNameDisplayed&&isCorrectSectionNameDisplayed;
    }

    @Override
    public boolean checkIndiaPageThreeDotTapDisplayBottomAction() {
        return false;
    }

    @Override
    public boolean checkIndiaPageRedirectionFromExplore() {
        return false;
    }

    @Override
    public boolean checkCloseTabCloseBottomActionSheet() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTappingAnyStoryOnIndiaPage() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromStoryDetailsPageOnTappingAnyStoryOnIndiaPage() {
        return false;
    }

    @Override
    public boolean checkSubSectionNameisDispayed() {
        boolean isSubSectionNameDiplayed = false;
        commonFunctions.clickElement(home, 20, "Home Button");
        commonFunctions.clickElement(exploreButton, 20, "Explore Button");
        commonFunctions.clickElement(CitiesExploreButton, 20, "Cities explore Button");
        commonFunctions.clickElement(noidaSubSection, 20, "Noida Sub section");
        commonFunctions.clickElement(clickFirstStory, 20, "Story");
        commonFunctions.clickElementIfDisplayed(skipButton, 15, "SkipButtonInPopup");
        commonFunctions.isElementDisplayed(SubsectionPageOfNoida, 20, "Sub Section Name Displayed");
        try {
            String subSection = commonFunctions.getElementText(SubsectionPageOfNoida, 20);
            isSubSectionNameDiplayed = commonFunctions.checkTextEquals("NOIDA NEWS", subSection, "SubSection Name Displayed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        commonFunctions.clickElementIfDisplayed(backButton,5,"Back Button");
        commonFunctions.clickElementIfDisplayed(backButton,5,"Back Button");
        commonFunctions.clickElementIfDisplayed(downArrowInCities,5,"Down arrow");
        return isSubSectionNameDiplayed;
    }

    @Override
    public boolean checkAfterHeaderAdFirstStoryIsDisplayed() {
        commonFunctions.clickElement(home, 20, "Home Button");
        commonFunctions.isElementDisplayed(topAdvertisement, 20, "Header Advertisement");
        boolean isFirstStoryDisplayed = commonFunctions.isElementDisplayed(firstStory, 20, "First Story After Header Ad");
        return isFirstStoryDisplayed;
    }

    public boolean scrollDownToRelatedTopicsSection(){
        commonFunctions.clickElement(home, 5, "Home button");
        commonFunctions.clickElement(firstStory, 20,"First Story");
//        commonFunctions.dummyWait(5);
//        commonFunctions.clickByCoordinates(338,742, "Enter Key");
        Utils.logStepInfo("Click of skip button should be performed to continue further app interaction.");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(skip,10,"Skip Button");
        boolean isScrollDownTillRelatedTopics = commonFunctions.scrollDownSlowToElement(relatedTopic,20);
        if(!isScrollDownTillRelatedTopics){
            commonFunctions.clickElementIfDisplayed(closeBtnInAd,5,"Close Add");
            commonFunctions.clickByCoordinates(364,62,"Close Add");
            commonFunctions.clickElementIfDisplayed(skip,5,"Skip button");
            commonFunctions.toGetRidOfAd(home,20);
            commonFunctions.scrollDownSlowToElement(relatedTopic,20);
            isScrollDownTillRelatedTopics=true;
        }
        return isScrollDownTillRelatedTopics;
    }

    @Override
    public boolean checkRelatedTopicHeadingDisplayed() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isPageTitleDisplay= commonFunctions.getElementText(relatedTopic,10).equalsIgnoreCase("Related Topics");
        commonFunctions.clickElement(backButton, 5, "back button");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(home,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home,5,"Home Button");
        return isPageTitleDisplay && isHomePage && relatedTopicDisplay;
    }

    @Override
    public boolean checkRelatedTopicsDisplayed() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isPageTitleDisplay= commonFunctions.getElementText(relatedTopic,10).equalsIgnoreCase("Related Topics");
        commonFunctions.scrollDownSlowToElement(relatedTopicsList.get(0),15);
        boolean isTopicsDisplay= relatedTopicsList.size()>0;
        commonFunctions.clickElement(backButton, 5, "back button");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(home,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home,5,"Home Button");
        return isPageTitleDisplay && isHomePage && relatedTopicDisplay && isTopicsDisplay;
    }

    @Override
    public boolean checkRelatedTopicsRedirection() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isRelatedTopicDisplayed=commonFunctions.isRelatedTopicHeaderDisplayed(relatedTopic,relatedTopicsList,relatedTopicPageHeader);
        commonFunctions.clickElement(backButton, 5, "back button");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(home,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home,5,"Home Button");
        return isRelatedTopicDisplayed && isHomePage && relatedTopicDisplay;
    }

    @Override
    public boolean checkRelatedTopicsPageStoryRedirection() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isRelatedTopicDisplayed=commonFunctions.isRelatedTopicHeaderDisplayed(relatedTopic,relatedTopicsList,relatedTopicPageHeader);
        boolean isStoryDisplayed= commonFunctions.isElementDisplayed(storyCaption,10,"Story Caption");
        commonFunctions.scrollUntilElementFound(storyParagraph);
        boolean isParagraphDisplayed = commonFunctions.isElementDisplayed(storyParagraph,20,"Paragraph displayed");
        commonFunctions.clickByCoordinates(646,503,"Click on Skip button on Bookmark page");
        commonFunctions.clickElement(backButton, 5, "back button");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(home,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home,5,"Home Button");
        return isRelatedTopicDisplayed && isHomePage && relatedTopicDisplay && isStoryDisplayed && isParagraphDisplayed;
    }

    @Override
    public boolean checkRedirectionOnTopicStoryIfTabOnbBackBtn() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.clickElement(clickFirstStory,5,"First Story Open");
        commonFunctions.clickElement(skip,5,"Skip Btn");
        commonFunctions.scrollDownToElement(relatedTopicsList.get(0));
        String firstTopicText = commonFunctions.getElementText(relatedTopicsList.get(1),5);
        commonFunctions.clickElement(relatedTopicsList.get(1),5,"First Topic From Related Topics");
        boolean isTopicHeader = commonFunctions.getElementText(relatedTopicPageHeader,5).equalsIgnoreCase(firstTopicText);
        commonFunctions.clickElement(backButton,5,"Back Btn");
        boolean isStoryPageAfterBack = commonFunctions.scrollDownToElement(relatedTopic);
        return isTopicHeader && isStoryPageAfterBack;
    }

    @Override
    public boolean checkShareStoryFromTopicScreen() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        commonFunctions.clickElement(relatedTopicsList.get(1),5,"First Topic From Related Topics");
        commonFunctions.clickElement(threeDots,5,"Three Dots");
        boolean isBottomActionSheetDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,5,"Bottom Action Sheet");
        commonFunctions.clickElement(shareOption,10,"Share");
        isBottomActionSheetDisplayed &= commonFunctions.isElementDisplayed(shareSheet,5,"Share Sheet");
        return relatedTopicDisplay && isBottomActionSheetDisplayed;
    }

    @Override
    public boolean checkRedirectionOnStoryIfTabOnSectionName() {
        boolean isRedirectToSection = true;
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        if(!relatedTopicDisplay){
            scrollDownToRelatedTopicsSection();
            relatedTopicDisplay = true;
        }
        commonFunctions.clickElement(relatedTopicsList.get(1),5,"First Topic From Related Topics");
        String sectionName = commonFunctions.getElementText(sectionNameInFirstStoryInTopic,5);
        commonFunctions.clickElement(sectionNameInFirstStoryInTopic,5,"Section Name in first Story in topic Story");
        String sectionNameInSectionPage = commonFunctions.getElementText(sectionNameInFirstStoryInTopic,5);
        MobileElement sectionNameInListingPage = null;
        if(sectionName.equalsIgnoreCase(sectionNameInSectionPage)){
            sectionNameInListingPage = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+sectionName.toUpperCase()+"']"));
            isRedirectToSection &= true;
        }
        isRedirectToSection &= commonFunctions.isElementDisplayed(sectionNameInListingPage,5,"Section Name in Listing Page");
        return isRedirectToSection && relatedTopicDisplay;
    }

    @Override
    public boolean checkReadAloudOptionInStoryPage() {
        commonFunctions.clickElement(home, 5, "Home Button");
        commonFunctions.clickElement(clickFirstStory, 5, "Click First Story");
        commonFunctions.clickElement(skip, 5, "Skip");
        commonFunctions.dummyWait(5);
        boolean isReadAloudOption = commonFunctions.isElementDisplayed(readAloudOptionInStory,5,"Read Aloud option in Story Page");
        return isReadAloudOption;
    }

    @Override
    public boolean checkRedirectionWhenUserTapsOnStoryInCitiesSection() {
        commonFunctions.clickElement(home,5,"Home button");
        commonFunctions.clickElement(citiesSection,5,"Cities");
        boolean isPopMessageDisplayed = commonFunctions.clickElementIfDisplayed(gotItButtonOnCitiesPopUp,5,"Got it button");
        if (isPopMessageDisplayed) {
            commonFunctions.clickElement(listOfUnselectedCities.get(0),5,"First City");
            commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save Changes");
        }
        commonFunctions.clickElement(firstStory,5,"First story on cities section");
        commonFunctions.clickElement(skip,5,"Skip");
        boolean isStoryDetailingPageDisplayed = commonFunctions.isElementDisplayed(storyDetailPage,5,"Story detailing page");
        commonFunctions.clickElement(backButton,5,"Back button");
        return isStoryDetailingPageDisplayed;
    }

    @Override
    public boolean checkSubscriptionPaywall(String HTPremiumPageUrl, String email, String password) {
        return false;
    }
}
