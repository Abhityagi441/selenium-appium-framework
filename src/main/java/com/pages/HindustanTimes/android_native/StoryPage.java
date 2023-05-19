package com.pages.HindustanTimes.android_native;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import com.jayway.jsonpath.JsonPath;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.response.Response;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StoryPage extends CommonStoryPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.ht.news:id/titleTv'])[1]")
    private static MobileElement clickFirstStory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cities']")
    private static MobileElement citiesSection;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Noida']")
    private static MobileElement noidaSubSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India']")
    private static MobileElement indiaSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='INDIA']")
    private static MobileElement indiaSectionHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share']")
    private static MobileElement shareOption;

    @AndroidFindBy(id = "android:id/title")
    private static MobileElement shareOptionHeader;

    @AndroidFindBy(id = "com.ht.news:id/btn_cancel")
    private static MobileElement cancelButton;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement storyDetailPage;

    @AndroidFindBy(id = "com.ht.news:id/navigation_explore")
    private static MobileElement explore;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static MobileElement dotsMenu;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static List<MobileElement> searchResults;

    @FindBy(xpath = "//div[@class='dateTime']")
    private static List<WebElement> lastPublished;

    @AndroidFindBy(id = "com.ht.news:id/txt_author")
    private static MobileElement storyTime;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> listOfStories;

    @AndroidFindBy(id = "com.ht.news:id/titlePublishTime")
    private static List<MobileElement> storyPublishTime;

    @AndroidFindBy(id = "com.ht.news:id/titleTimeToRead")
    private static List<MobileElement> storyPublishReadTime;

    @AndroidFindBy(id = "com.ht.news:id/title")
    private static MobileElement searchStory;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.ht.news:id/txt_date_time'])[1]")
    private static MobileElement getStoryTime;

    @AndroidFindBy(id = "android.widget.RelativeLayout")
    private static MobileElement homePage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ht.news:id/tv_newsIndia']")
    private static MobileElement sectionName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NOIDA NEWS']")
    private static MobileElement subSectionName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Premium']")
    private static MobileElement premiumSection;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.RelativeLayout")
    private static MobileElement firstStory;

    @AndroidFindBy(id = "com.ht.news:id/detail_recycler")
    private static MobileElement storySection;

    @AndroidFindBy(id = "com.ht.news:id/toolbarLayout")
    private static MobileElement homePageSection;

    @AndroidFindBy(id = "com.ht.news:id/adsContainerLayout")
    private static MobileElement contentAd;

    @AndroidFindBy(id = "com.ht.news:id/adIndicator")
    private static MobileElement firstAdPremiumPage;

    @AndroidFindBy(id = "com.ht.news:id/tv_advertisement")
    private static MobileElement storyEndAd;

    @AndroidFindBy(id = "com.ht.news:id/afterArticleWidgetTv")
    private static MobileElement moreFromThisSection;

    @AndroidFindBy(id = "com.ht.news:id/moreFromSectionTv")
    private static MobileElement moreFromSection;

    @AndroidFindBy(id = "com.ht.news:id/swipeUpHint")
    private static MobileElement nextStory;

    @AndroidFindBy(id = "com.ht.news:id/moreFromSectionTv")
    private static MobileElement youMayAlsoLike;

    @AndroidFindBy(accessibility = "Fav")
    private static MobileElement bookmarkOption;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private static MobileElement hamburger;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private static List<MobileElement> TopAd;

    @AndroidFindBy(id = "com.ht.news:id/ads_layout")
    private static MobileElement bottomAd;

    @AndroidFindBy(id = "com.ht.news:id/tv_advertisement")
    private static MobileElement storySectionAd;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private static MobileElement LoginInButton;

    @AndroidFindBy(id = "com.ht.news:id/password_et")
    private static MobileElement passwordTextBoxMainSignInPage;

    @AndroidFindBy(id = "com.ht.news:id/email_or_mobile_et")
    private static MobileElement emailTextBoxMainSignInPage;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private static MobileElement hamburgerButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_name")
    private static MobileElement categoryList;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_name")
    private static MobileElement newsCategoryList;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Photos']")
    private static MobileElement tapOnPhotos;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Videos']")
    private static MobileElement tapOnVideos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PHOTOS']")
    private static MobileElement redirectionPhotos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VIDEOS']")
    private static MobileElement redirectionVideos;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static MobileElement firstPhotoStory;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static MobileElement firstVideoStory;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement photoStroyPage;

    @AndroidFindBy(id = "com.ht.news:id/image_button_swipe_right")
    private static MobileElement swipeRightButton;

    @AndroidFindBy(id = "com.ht.news:id/img_gallery_item")
    private static MobileElement checkPhotoStoryDetailPage;

    @AndroidFindBy(id = "com.ht.news:id/videoLayout")
    private static MobileElement checkVideoStoryDetailPage;

    @AndroidFindBy(id = "com.ht.news:id/txt_count")
    private static MobileElement contentChangeTxtCount;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement contentChangeTxtCaption;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement contentOfVideoStory;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Volume']")
    private static MobileElement volumeBtnOfVideoStoryPage;

    @AndroidFindBy(id = "com.ht.news:id/swipeUpHint")
    private static MobileElement nextStorySection;

    @AndroidFindBy(id = "//com.ht.news:id/moreFromSectionTv")
    private static MobileElement sectionYouMayAlsoLike;

    @AndroidFindBy(id = "com.ht.news:id/layoutParent")
    private static MobileElement sectionToScrollToView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='watch more...']")
    private static MobileElement watchMoreSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Next Video']")
    private static MobileElement nextVideoSwipeUP;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> photoStoryTitle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.ht.news:id/titleTv'])[1]")
    private static MobileElement homeTitle;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement summary;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement photoInLineStoryHeadLinesTxt;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    private static MobileElement menuPhotoOptionText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PHOTOS']")
    private static MobileElement redirectedPhotosPageText;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static MobileElement videoStoryTitle;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement videoInLineStoryHeadLinesTxt;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Videos']")
    private static MobileElement menuVideosOptionText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VIDEOS']")
    private static MobileElement redirectedVideosPageText;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> listOfStoriesInPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Premium']")
    private static MobileElement premiumStorySection;

    @AndroidFindBy(id = "com.ht.news:id/exclusiveIv")
    private static List<MobileElement> exclusiveTag;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement storyTitle;

    @AndroidFindBy(id = "com.ht.news:id/signInBtn")
    private static MobileElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    private static MobileElement skipButtonInSignInWall;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hi! Please Login to Continue Reading']")
    private static MobileElement continueReadingText;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@index='1'])[3]")
    private static MobileElement accessToPremiumArticles;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@index='1'])[4]")
    private static MobileElement shareAndSaveArticles;

    @AndroidFindBy(id = "com.ht.news:id/signUpBtn")
    private static MobileElement signUpButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private static MobileElement hamBurger;

    @AndroidFindBy(id = "com.ht.news:id/search")
    private static MobileElement searchField;

    @AndroidFindBy(id = "com.ht.news:id/etSearch")
    private static MobileElement searchBar;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement headLine;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> paragraph;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement caption;

    @AndroidFindBy(id = "com.ht.news:id/img_share")
    private static MobileElement shareIcon;

    @AndroidFindBy(id = "com.ht.news:id/bookmark")
    private static MobileElement bookMark;

    @AndroidFindBy(id = "com.ht.news:id/img_news")
    private static MobileElement leadImage;

    @AndroidFindBy(id = "com.ht.news:id/storyDetailAdContainer")
    private static MobileElement AdvertisementAtBottom;

    @AndroidFindBy(id = "com.ht.news:id/signInWallLayout")
    private static MobileElement signInWall;

    @AndroidFindBy(id = "com.ht.news:id/navigation_home_section")
    private static MobileElement home;

    @AndroidFindBy(accessibility = "Home")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static List<MobileElement> pageStoryList;

    @AndroidFindBy(id = "com.ht.news:id/topicChip")
    private static List<MobileElement> relatedTopicsList;

    @AndroidFindBy(id = "com.ht.news:id/paragraphTv")
    private static MobileElement storyParagraph;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement storyCaption;

    @AndroidFindBy(id = "com.ht.news:id/img_news")
    private static MobileElement storyImage;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement storyHeadline;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement relatedTopicPageHeader;

    @AndroidFindBy(id = "//android.widget.TextView[@text='Close']")
    private static MobileElement closeAppAdBtn;

    @AndroidFindBy(id = "com.ht.news:id/topicsTv")
    private static MobileElement relatedTopic;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(accessibility = "Premium")
    private static MobileElement premiumButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(id = "com.ht.news:id/ad_view_320_100")
    private static MobileElement headerAd;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PREMIUM']")
    private static MobileElement imagePremium;

    @AndroidFindBy(accessibility = "Interstitial close button")
    private static MobileElement adPopUpInApp;

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private static MobileElement storySummary;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_name")
    private static List<MobileElement> videosOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Explore']/android.widget.FrameLayout/android.widget.ImageView")
    private static MobileElement exploreMenu;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement sectionPageHeader;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static List<MobileElement> threeDotButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_bookmark")
    private static MobileElement bookmarkOptionThreeDot;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share']")
    private static MobileElement shareOptionThreeDot;

    @AndroidFindBy(id = "com.ht.news:id/btn_cancel")
    private static MobileElement cancelOptionThreeDot;

    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreButton;

    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India']")
    private static MobileElement indiaSectionExplorePage;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement pageHeaderName;

    @AndroidFindBy(id = "com.ht.news:id/recent_notification")
    private static MobileElement premiumPageHeader;

    @AndroidFindBy(id = "com.ht.news:id/newsTypeIconIsBlog")
    private static List<MobileElement> storyTypesNews;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement openedStoryHeadline;

    @AndroidFindBy(id = "com.ht.news:id/iv_image")
    private static MobileElement photoPagePhoto;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.ImageButton[[@content-desc='Interstitial close button']]")
    private static MobileElement closeAd;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Close']")
    private static MobileElement adCloseButton;

    @AndroidFindBy(id = "com.ht.news:id/newsTypeIconIsExclusive")
    private static MobileElement premiumStoryHomePage;

    @AndroidFindBy(id = "com.ht.news:id/newsTypeIconIsBlog")
    private static List<MobileElement> premiumStories;

    @AndroidFindBy(id = "com.ht.news:id/iv_profile")
    private static MobileElement continueReadingBox;

    @AndroidFindBy(id = "com.ht.news:id/titleSubSection")
    private static List<MobileElement> storySubSectionName;

    @FindBy(xpath = "//button[@class='android.widget.ImageButton']")
    private static WebElement crossAdOption;

    @AndroidFindBy(id = "com.ht.news:id/signUpBtn")
    private static MobileElement premiumStorySignInButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat")
    private static MobileElement threeDotMsgBox;

    @AndroidFindBy (id = "com.ht.news:id/tv_speaker")
    private static MobileElement readAloudOptionInStory;

    @AndroidFindBy (id = "com.ht.news:id/paragraphTv")
    private static MobileElement paraGraph;

    @AndroidFindBy(id = "com.ht.news:id/bt_continue")
    private static MobileElement gotItButtonOnCitiesPopUp;

    @AndroidFindBy(id = "com.ht.news:id/itemInfoTv")
    private static List<MobileElement> listOfCitiesInSection;

    @AndroidFindBy(id = "com.ht.news:id/save_btn")
    private static MobileElement saveChangesButtonOnCitiesSection;

    @AndroidFindBy(id="com.ht.news:id/facebook_share_in_story")
    private static MobileElement facebookShareOptionINOpenStory;

    @AndroidFindBy(xpath = "//*[@text='Quickreads']")
    private static MobileElement quickReads;

    private static final String htPremium = "HT Premium";

    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        /*commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available*/
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    public boolean clickHamburgerButtonAndCheckNewsCategoryList() {
        boolean isStepTrue;
        commonFunctions.clickElement(exploreMenu, 5, "hamburgerButton");
        isStepTrue = commonFunctions.isElementDisplayed(newsCategoryList, 5, "newsCategoryList");
        return isStepTrue;
    }

    public boolean checkPhotosOptionAndRedirection() {
        boolean isStepTrue;
        commonFunctions.scrollTillVisibleText("Photos", "Menu Photo Option Text");
        String menuPhotosOption = menuPhotoOptionText.getText();
        isStepTrue = commonFunctions.scrollTillVisibleTextAndClick("Photos", "tap On Photos");
        commonFunctions.isElementDisplayed(redirectionPhotos, 5, "Redirection Photos");
        String redirectedPhotoPage = redirectedPhotosPageText.getText();
        if (menuPhotosOption.equalsIgnoreCase(redirectedPhotoPage)) {
            isStepTrue = true;
        }
        return isStepTrue;
    }

    public boolean checkPhotoStoryTitleAndHeadLine() {
        boolean isStepTrue;
        commonFunctions.isElementDisplayed(photoStoryTitle.get(0), 5, "redirectionPhotos");
        String photoStoryPageTitle = photoStoryTitle.get(0).getText();
        photoStoryPageTitle = photoStoryPageTitle.trim();
        commonFunctions.isElementDisplayed(firstPhotoStory, 5, "firstPhotoStory");
        isStepTrue = commonFunctions.clickElement(firstPhotoStory, 5, "firstPhotoStory");
        commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.clickByCoordinates(537, 515);
        commonFunctions.isElementDisplayed(photoInLineStoryHeadLinesTxt, 5, "photoInLineStoryHeadLinesTxt");
        String photoInLineStoryHeadLines = photoInLineStoryHeadLinesTxt.getText();
        Utils.logStepInfo(true,"photoStoryPageTitle = "+photoStoryPageTitle);
        Utils.logStepInfo(true,"photoInLineStoryHeadLines = "+photoInLineStoryHeadLines);
        if (photoStoryPageTitle.contains(photoInLineStoryHeadLines)) {
            isStepTrue = true;
        }
        Utils.logStepInfo(true,"isStepTrue = "+isStepTrue);
        return isStepTrue;
    }

    public boolean checkPhotoStoryDetailPageContent() {
        boolean isStepTrue = false;
        try {
            commonFunctions.isElementDisplayed(checkPhotoStoryDetailPage, 5, "checkPhotoStoryDetailPage");
            String str = contentChangeTxtCount.getText();
            String getText[] = str.split("/");
            String getNumPhotos = getText[1];
            System.out.println("number of photos" + getNumPhotos);
            int numOfPhotos = Integer.parseInt(getNumPhotos);

            for (int i = 0; i < numOfPhotos; i++) {
                commonFunctions.isElementDisplayed(checkPhotoStoryDetailPage, 5, "checkPhotoStoryDetailPage");
                commonFunctions.isElementDisplayed(contentChangeTxtCount, 5, "contentChangeTxtCount");
                commonFunctions.isElementDisplayed(contentChangeTxtCaption, 5, "contentChangeTxtCaption");
                commonFunctions.scrollDown();
                commonFunctions.isElementDisplayed(nextStorySection, 5, "nextStorySection");
                commonFunctions.isElementDisplayed(sectionYouMayAlsoLike, 5, "sectionYouMayAlsoLike");
                commonFunctions.scrollUp();
                if (swipeRightButton.isDisplayed()) {
                    isStepTrue = commonFunctions.clickElement(swipeRightButton, 5, "swipeRightButton");
                } else if (!swipeRightButton.isDisplayed() && i == numOfPhotos - 1) {
                    isStepTrue = true;
                    break;
                } else {
                    isStepTrue = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isStepTrue;
    }

    public boolean clickHamburgerButton() {
        boolean isStepTrue;
        isStepTrue = commonFunctions.clickElement(exploreMenu, 5, "hamburgerButton");
        return isStepTrue;
    }

    public boolean checkNewCategoryList() {
        boolean isStepTrue;
        isStepTrue = commonFunctions.isElementDisplayed(newsCategoryList, 5, "newsCategoryList");
        return isStepTrue;
    }

    public boolean checkVideosOptionAndRedirection() {
        boolean isStepTrue;
        commonFunctions.isElementDisplayed(videosOption.get(9));
        String menuVideosOption = videosOption.get(9).getText();
        isStepTrue = commonFunctions.clickElement(videosOption.get(9));
        boolean isVideoDisplayed = commonFunctions.isElementDisplayed(redirectionVideos, 5, "redirectionVideos");
        String redirectedVideoPage = redirectedVideosPageText.getText();
        if (menuVideosOption.equalsIgnoreCase(redirectedVideoPage)) {
            isStepTrue = true;
        }
        return isStepTrue && isVideoDisplayed;
    }

    public boolean checkVideoStroyTitleAndHeadline() {
        boolean isStepTrue;
        boolean isVideoStoryTitleDisplayed = commonFunctions.isElementDisplayed(videoStoryTitle, 5, "videoStoryTitle");
        String videoStoryPageTitle = videoStoryTitle.getText();
        boolean isFirstVideoStoryDisplayed = commonFunctions.isElementDisplayed(firstVideoStory, 5, "firstVideoStory");
        isStepTrue = commonFunctions.clickElement(firstVideoStory, 5, "firstVideoStory");
        if (!commonFunctions.isElementClickable(homeButton, 5, "HT home button")) {
            commonFunctions.pressAndroidBackKey();
        }
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details to interact with story page detail elements!!!!!!!!!");
        commonFunctions.clickByCoordinates(537, 515);
        commonFunctions.clickByCoordinates(543, 1349);
        boolean isVideoInLineStoryHeadLinesTxt = commonFunctions.isElementDisplayed(videoInLineStoryHeadLinesTxt, 5,
                "videoInLineStoryHeadLinesTxt");
        String videoInLineStoryHeadLines = videoInLineStoryHeadLinesTxt.getText();
        if (videoStoryPageTitle.equals(videoInLineStoryHeadLines)) {
            isStepTrue = true;
        }
        return isStepTrue && isFirstVideoStoryDisplayed && isVideoStoryTitleDisplayed && isVideoInLineStoryHeadLinesTxt;
    }

    public boolean checkVideoStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = commonFunctions.isElementDisplayed(checkVideoStoryDetailPage, 5, "checkVideoStoryDetailPage");
        return isStepTrue;
    }

    public boolean checkContentOfVideoStory() {
        boolean isStepTrue;
        isStepTrue = commonFunctions.isElementDisplayed(volumeBtnOfVideoStoryPage, 5, "Volume on off button");
        return isStepTrue;
    }

    public boolean checkWatchMoreSectionDisplayed() {
        boolean isStepTrue = false;
        commonFunctions.scrollDown();
        isStepTrue = commonFunctions.isElementDisplayed(nextVideoSwipeUP, 5, "Next Video button");
        return isStepTrue;
    }

    @Override
    public boolean videoStoryContentValidation(String params[]) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean hamburgerMenu = clickHamburgerButton();
        boolean newsCategoryList = checkNewCategoryList();
        boolean videosOption = checkVideosOptionAndRedirection();
        boolean redirectedVideosCategory = checkVideoStroyTitleAndHeadline();
        boolean videoStory = checkVideoStoryDetailPage();
        boolean redirectedVideoStoryDetail = checkContentOfVideoStory();
        boolean watchMoreSection = checkWatchMoreSectionDisplayed();
//        commonFunctions.pressAndroidBackKey();
//        commonFunctions.pressAndroidBackKey();

        return hamburgerMenu && newsCategoryList && videosOption && redirectedVideosCategory && videoStory
                && redirectedVideoStoryDetail && watchMoreSection;
    }

    @Override
    public boolean checkLastPublishedDate(String params[]) {
        return false;
    }

    @Override
    public boolean photosGalleryContentValidation() {
        boolean hamburgerMenu = clickHamburgerButtonAndCheckNewsCategoryList();
        boolean photosOption = checkPhotosOptionAndRedirection();
        boolean photoStory = checkPhotoStoryTitleAndHeadLine();
        boolean checkAllPhotos = checkPhotoStoryDetailPageContent();
        return hamburgerMenu && photosOption && photoStory && checkAllPhotos;
    }

    @Override
    public boolean checkStandardStoryPagination(String uri, String address) {
        return false;
    }

    @Override
    public boolean checkContentImagesAndEmbeds(String[] params) {
        Utils.logStepInfo(true,"params[0] = "+params[0]);
        Utils.logStepInfo(true,"params[1] = "+params[1]);
        Utils.logStepInfo(true,"params[2] = "+params[2]);
        Utils.logStepInfo(true,"params[3] = "+params[3]);
        boolean headLine = checkHeadLine(params[2], params[3],params[0],params[1]);
        boolean leadImage = checkLeadImage();
        boolean caption = checkCaption(params[3],params[0],params[1]);
        boolean imageCredit = checkImageCredits(params[3], params[0], params[1]);
        boolean summary = checkSummary(params[3],params[0],params[1]);
        boolean paragraph = checkParagraph(params[3],params[0],params[1]);
        //boolean advertisement = checkAdvertisement();
        boolean shareIcon = checkShareIcon();
        boolean bookMark = checkBookMark();
        commonFunctions.pressAndroidBackKey();
        Utils.logStepInfo(true,"headLine = "+headLine);
        Utils.logStepInfo(true,"leadImage = "+leadImage);
        Utils.logStepInfo(true,"caption = "+caption);
        Utils.logStepInfo(true,"imageCredit = "+imageCredit);
        Utils.logStepInfo(true,"paragraph = "+paragraph);
        Utils.logStepInfo(true,"summary =" +summary);
        Utils.logStepInfo(true,"shareIcon = "+shareIcon);
        Utils.logStepInfo(true,"bookMark = "+bookMark);

        return headLine && leadImage && caption && imageCredit && paragraph &&
                shareIcon && bookMark && summary;
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
    public boolean liveBlogContentValidation(String uri, String address, String url) {
        return false;
    }

    public boolean checkRedirectionOnFirstStory() {
        boolean isStoryDisplayed;

        String storyTitle = listOfStories.get(0).getText();
        commonFunctions.clickElement(listOfStories.get(0), 5, "First story of the current page");
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details to interact with story page detail elements!!!!!!!!!");
        commonFunctions.clickByCoordinates(537, 515);
        isStoryDisplayed = commonFunctions.isElementDisplayed(storyDetailPage, 5, "First Story");
        String expectTitle = storyDetailPage.getText();

        if (storyTitle.equalsIgnoreCase(expectTitle)) {

            isStoryDisplayed = true;
        }

        return isStoryDisplayed;
    }

    public Long StoryTime() {
        String firstStory = storyTime.getText();
        String regexOne = firstStory.replaceAll("[\\D+]", "");
        long storyTime = Long.parseLong(regexOne);
        return storyTime;
    }

    public boolean checkPublishedTimeIsChanged() {
        boolean isStoriesAreDisplayed = false;
        try {
            isStoriesAreDisplayed = commonFunctions.isElementDisplayed(storyTime, 5, "Story Time");
            Long storyTime1 = StoryTime();
            commonFunctions.pressAndroidBackKey();
            commonFunctions.clickElement(listOfStories.get(1), 5, "Second story");
            isStoriesAreDisplayed = commonFunctions.isElementDisplayed(storyDetailPage, 5, "Second Story");
            Long storyTime2 = StoryTime();
            isStoriesAreDisplayed = commonFunctions.isElementDisplayed(storyTime, 5, "Second story time");
            if (storyTime1 > storyTime2) {
                isStoriesAreDisplayed = true;
                Utils.logStepInfo(true, "Second story publishing time is before than the first story publishing time");
            } else {
                Utils.logStepInfo("Second story and First story publishing time is same");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isStoriesAreDisplayed;
    }

    public boolean checkStoriesAreLastPublished(String params[]) {
        boolean isLastPublished = false;
        commonFunctions.clickElement(exploreMenu, 5);
        commonFunctions.clickElement(searchField, 5);
        commonFunctions.sendKeysOnAndroid(searchBar, params[0]);
        commonFunctions.pressEnterKey();
        String publishedTime = getStoryTime.getText();
        Date date1 = new Date(publishedTime);
        long time = date1.getTime() - Calendar.getInstance().getTimeZone().getOffset(date1.getTime());
        Date d = new Date(time);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String lastPublishedDate = dateFormat.format(d);
        Response response = commonFunctions.getResponseFromURI(params[2], params[3] + params[1]);
        String value = JsonPath.parse(response.getBody().asString()).read("$.lastPublishedDate");
        Utils.logStepInfo(value);
        isLastPublished = value.contains(lastPublishedDate);

        return isLastPublished;
    }

	/*public boolean checkRedirectionOnHighlightLink(String email, String password) {

		boolean isRedirectionSuccessful = false;

		commonFunctions.clickElement(LoginInButton, 5,, "Login Button");
		commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 5,, "emailOrPhone");
		commonFunctions.pressEnterKey();
		commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 5,, "Password");
		commonFunctions.pressEnterKey();
		commonFunctions.clickElement(hamburger, 5,, "Hamburger Option");
		commonFunctions.tapByCoordinate(55, 485, "Saved Articles");
		return isRedirectionSuccessful;
	}*/

    public boolean checkHomePageLoadedSuccessful() {
        return commonFunctions.isElementDisplayed(homeTitle, 5, "Home page properly loaded");
    }

    public boolean clickOnStorySection() {
        boolean isContentPaginationDisplayed = false;
//        isContentPaginationDisplayed = commonFunctions.isElementDisplayed(homePage, 5,, "HomePage Option");
        String currentTitle = listOfStories.get(0).getText();
        commonFunctions.clickElement(listOfStories.get(0), 5, "Story Headline");
        commonFunctions.toGetRidOfAd(homeButton, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        commonFunctions.isElementDisplayed(storyDetailPage, 5, "storyDetailPage");
        String expectTitle = storyDetailPage.getText();
        if (currentTitle.equalsIgnoreCase(expectTitle)) {
            isContentPaginationDisplayed = true;
        }
        return isContentPaginationDisplayed;
    }

    public boolean checkStoryCompletelyLoaded() {
        return commonFunctions.isElementDisplayed(summary, 5, "Storypage completely loaded");
    }

    public boolean scrollDownToBottom() {
        boolean isStoryLoadedSuccessful;
        isStoryLoadedSuccessful = commonFunctions.isElementDisplayed(nextStory, 5, "Next Story swipe up button");
        if (!isStoryLoadedSuccessful) {
            commonFunctions.scrollUpToElementDisplayed(nextStory);
            isStoryLoadedSuccessful = commonFunctions.isElementDisplayed(nextStory, 5, "Next Story swipe up button");
        }
        return isStoryLoadedSuccessful;
    }

    public boolean checkAdNextStoryIsDisplayed() {
        boolean isAdNextStoryYouMayAlsoDisplayed;
        boolean isAdDisplayed = commonFunctions.isElementDisplayed(storyEndAd, 5, "Content Ad");

//		boolean isNextStoryDisplayed = commonFunctions.scrollTillVisibleText("next story", "next story");

        boolean isNextStoryDisplayed = false;
        try {
//			commonFunctions.scrollUpToElementDisplayed(youMayAlsoLike);
            isNextStoryDisplayed = commonFunctions.isElementDisplayed(nextStory, 5, "Next Story");
            if (!commonFunctions.isElementDisplayed(homeButton, 5, "HT home button still")) {
                commonFunctions.pressAndroidBackKey();
            }
            commonFunctions.scrollUpToElementDisplayed(youMayAlsoLike);
            isAdNextStoryYouMayAlsoDisplayed = commonFunctions.isElementDisplayed(youMayAlsoLike, 5,
                    "You may also like");
        } catch (Exception e) {
            isAdNextStoryYouMayAlsoDisplayed = commonFunctions.isElementDisplayed(youMayAlsoLike, 5,
                    "You may also like");
        }
        return isAdNextStoryYouMayAlsoDisplayed && isAdDisplayed && isNextStoryDisplayed;
    }

    public boolean checkHomepageSectionIsDisplayed() {
        boolean isRedirectionSuccessful;
        commonFunctions.pressAndroidBackKey();
//        isRedirectionSuccessful = commonFunctions.isElementDisplayed(homePageSection, 5,, "Home Page section");
        isRedirectionSuccessful = commonFunctions.isElementDisplayed(homeButton, 5, "HT Home button Page");
        return isRedirectionSuccessful;
    }

    public boolean checkSummary(String id, String uri, String address) {

        commonFunctions.scrollDownToPage(0.80, 0.10);
        commonFunctions.isElementDisplayed(storySummary, 5, "Story Summary");
        String summary = commonFunctions.getElementText(storySummary,10);
        Utils.logStepInfo(true,"Summary in UI = "+summary);
        Response response = apiValidation.getResponseFromURI(uri, address + id);
        String value = JsonPath.parse(response.getBody().asString()).read("$.summary");
        Utils.logStepInfo(true, "Value from API Response = " + value);
        boolean isSummaryMatch = value.contains(summary);
        Utils.logStepInfo(true, "isSummaryMatch = " + isSummaryMatch);
        return isSummaryMatch;
    }


    @Override
    public boolean checkStoriesDisplayedLastPublished(String params[]) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        long firstStoryPublishTime = getPublishedTime(0);
        long secondStoryPublishTime = getPublishedTimeSecondStory(1);
        boolean isStoryDisplayedForFirstStory = checkRedirectionOnFirstStory(0);
        boolean isStoryDisplayedForSecondStory = checkRedirectionOnFirstStory(1);
        boolean isLastPublished = secondStoryPublishTime > firstStoryPublishTime;

        return isStoryDisplayedForFirstStory && isStoryDisplayedForSecondStory && isLastPublished;
    }

    public long getPublishedTime(int storyPostition) {
        String publishTimeValue = commonFunctions.getElementText(storyPublishTime.get(storyPostition), 5);
        String publishTimeReadValue = commonFunctions.getElementText(storyPublishReadTime.get(storyPostition), 5);
        String[] numberOfText1 = publishTimeValue.split(" ");
        String[] numberOfText2 = publishTimeReadValue.split(" ");
        if (numberOfText1[1].contains("hour")) {
            return (Long.parseLong(numberOfText1[0]) * 60) + (Long.parseLong(numberOfText2[1]));
        } else {
            return (Long.parseLong(numberOfText1[0])) + (Long.parseLong(numberOfText2[1]));
        }
    }

    public long getPublishedTimeSecondStory(int storyPostition) {
        String publishTimeValue = commonFunctions.getElementText(storyPublishTime.get(storyPostition), 5);
        String publishTimeReadValue = commonFunctions.getElementText(storyPublishReadTime.get(storyPostition), 5);
        String[] numberOfText1 = publishTimeValue.split(" ");
        String[] numberOfText2 = publishTimeReadValue.split(" ");
        if (numberOfText1[1].contains("hour")) {
            return (Long.parseLong(numberOfText1[0]) * 60) + (Long.parseLong(numberOfText2[2]));
        } else {
            return (Long.parseLong(numberOfText1[0])) + (Long.parseLong(numberOfText2[2]));
        }
    }

    public boolean checkRedirectionOnFirstStory(int storyNumber) {
        boolean isStoryDisplayed;

        String storyTitle = commonFunctions.getElementText(listOfStories.get(storyNumber));
        commonFunctions.clickElement(listOfStories.get(storyNumber), 5, "First story of the current page");
        if (!commonFunctions.isElementDisplayed(homeButton, 5, "HT home button")) {
            commonFunctions.pressAndroidBackKey();
        }
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details to interact with story page detail elements!!!!!!!!!");
        commonFunctions.clickByCoordinates(537, 515);
        isStoryDisplayed = commonFunctions.isElementDisplayed(storyDetailPage, 5, "First Story");
        String expectTitle = commonFunctions.getElementText(storyDetailPage);

        if (storyTitle.equalsIgnoreCase(expectTitle)) {

            isStoryDisplayed = true;
        }
        commonFunctions.pressAndroidBackKey();

        return isStoryDisplayed;
    }


    @Override
    public boolean checkStandardStoriesAreDisplayed(String uri, String address) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean isHomePageLoaded = checkHomePageLoadedSuccessful();
        boolean isContentPaginationDisplayed = clickOnStorySection();
        boolean isStoryLoadedComplete = checkStoryCompletelyLoaded();
        boolean isStoryLoadedSuccessful = scrollDownToBottom();
        boolean adDisplay = commonFunctions.isElementDisplayed(storyEndAd, 5, "Ad of story detail page.");
//        since you may also not present anywhere in the story details page.
//        boolean isAdNextStoryYouMayAlsoDisplayed = checkAdNextStoryIsDisplayed();
        boolean isRedirectionSuccessful = checkHomepageSectionIsDisplayed();
        return isContentPaginationDisplayed && isStoryLoadedComplete && isStoryLoadedSuccessful && isHomePageLoaded
                && adDisplay && isRedirectionSuccessful;
    }

    public boolean checkPremiumStory() {
        boolean isLoadedSuccessful = false;
        commonFunctions.clickElement(premiumButton, 5, "Premium tab on HT home page");
//        commonFunctions.scrollTillVisibleText("PREMIUM", "Premium");
        boolean isDisplayed = commonFunctions.isElementDisplayed(listOfStories.get(0), 5, "Premium Story section");
        String beforeClickTitle = commonFunctions.getElementText(listOfStories.get(0), 5);

        commonFunctions.clickElement(listOfStories.get(0), 5, "First Premium story on the HT Home page");
//        commonFunctions.clickElementIfDisplayed(closeAd, 5,, "Ad featuring in between execution");
        commonFunctions.toGetRidOfAd(homeButton, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        String afterClickTitle = commonFunctions.getElementText(storyTitle, 5);
        if (commonFunctions.compareTexts(beforeClickTitle, afterClickTitle)) {
            isLoadedSuccessful = true;
            Utils.logStepInfo(isLoadedSuccessful, "Redirected Story is loaded successfully");
        }
        return isLoadedSuccessful && isDisplayed;
    }

    public boolean scrollDownTillElementDisplayed(MobileElement ele) {
        boolean isDisplayed = false;
        try {
            TouchAction action = new TouchAction(driver);
            Dimension size = driver.manage().window().getSize();
            int height = size.getHeight();
            int width = size.getWidth();
            int i = 0;
            while (!isDisplayed && i < 20) {
                action.press(PointOption.point(width / 2, (int) (height * 0.90)))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(width / 2, (int) (height * 0.10))).release()
                        .perform();
                for (MobileElement element : storyTypesNews) {
                    if (commonFunctions.getElementText(element).equals("PREMIUM") && commonFunctions.isVisible(element)) {
                        return isDisplayed;
                    }
                }
                i = i + 1;
            }
        } catch (Exception e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public boolean checkSignInWallDisplayed() {
//        commonFunctions.scrollTillVisibleText("Hi! Please Login to Continue Reading", "Hi! Please Login to Continue Reading");
        commonFunctions.scrollDownToElementWithWhile(continueReadingBox);
        boolean isDisplayed = commonFunctions.isElementDisplayed(signInWall, 5, "SignIn Wall");
        return isDisplayed;
    }

    public boolean checkContinueReading(String readText) {
        boolean isContinueDisplayed = commonFunctions.isElementDisplayed(continueReadingText, 5, "Sign In To Continue reading ");
        String continueReading = commonFunctions.getElementText(continueReadingText, 5);
        if (commonFunctions.compareTexts(continueReading, readText)) {
            isContinueDisplayed = true;
        }
        ;
        return isContinueDisplayed;
    }


    public boolean checkSignInWallFunctions(WebElement element, String elementName, String actualText) {

        boolean isSignInWallFunctionsDisplayed = commonFunctions.isElementDisplayed(element, 5, elementName);
        if (!isSignInWallFunctionsDisplayed) {
            isSignInWallFunctionsDisplayed = commonFunctions.scrollDownToElementWithWhile((MobileElement) element);
        }
        String expectedText = commonFunctions.getElementText(element, 5).toString();
        if (commonFunctions.compareTexts(actualText, expectedText)) {
            isSignInWallFunctionsDisplayed = true;
        } else {
            isSignInWallFunctionsDisplayed = false;
        }
        return isSignInWallFunctionsDisplayed;
    }

    public boolean tapOnSkipbutton() {
        boolean isSignInRemovedSuccessful = false;
        commonFunctions.clickElement(skipButtonInSignInWall, 5, "skip option");
//		boolean isDisplayed = commonFunctions.isElementDisplayed(moreFromSection, 5,, "more from section");
        if (moreFromSection.isDisplayed() | contentAd.isDisplayed()) {
//		boolean isDisplayed = commonFunctions.isElementDisplayed(contentAd.get(0), 5,, "more from section");

            isSignInRemovedSuccessful = true;
            Utils.logStepInfo(isSignInRemovedSuccessful, "SignIn wall is removed");
        }
        return isSignInRemovedSuccessful;
    }

    @Override
    public boolean checkSignInWallOnStoryPage(String readText, String premium, String saveArticles, String signIn, String signUp, String skip) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean isHomePageLoad = checkHomePageLoadedSuccessful();
        boolean isStoryLoaded = checkPremiumStory();
        boolean isSignInWallDisplayed = checkSignInWallDisplayed();
        boolean isReadingDisplayed = checkContinueReading(readText);
        boolean isPremiumDisplayed = checkSignInWallFunctions(accessToPremiumArticles, "Get access to premium articles", premium);
        boolean isShareArticlesDisplayed = checkSignInWallFunctions(shareAndSaveArticles, "share and save articles", saveArticles);
        boolean isSignInDisplayed = checkSignInWallFunctions(signInButton, "SignIn Button", signIn);
        commonFunctions.scrollDownToElementWithWhile(signUpButton);
        boolean isSignUpDisplayed = checkSignInWallFunctions(signUpButton, "Sign up Link", signUp);
//        commonFunctions.getElementText(signUpButton,)
        return isHomePageLoad && isStoryLoaded && isReadingDisplayed && isSignInWallDisplayed && isPremiumDisplayed && isShareArticlesDisplayed && isSignInDisplayed
                && isSignUpDisplayed;
    }

    public boolean checkHeadLine(String title, String id, String uri, String address) {
        //commonFunctions.clickElement(exploreMenu, 5,);
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,10);
        commonFunctions.clickElement(searchField, 5,"Search page");
        Utils.logStepInfo(true,"title in UI = " +title);
        commonFunctions.clickElementIfDisplayed(searchBar,20,"Click on Search box");
        commonFunctions.sendKeysOnAndroid(searchBar, title);
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(986,2083,"Enter Key");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(listOfStoriesInPage.get(0),10,"First Story in Search");
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        String mobileheadline = commonFunctions.getElementText(headLine, 5).trim();
        Response response = apiValidation.getResponseFromURI(uri, address + id);
        String value = JsonPath.parse(response.getBody().asString()).read("$.title");
        Utils.logStepInfo(true, "Value from API response = " + value);
        boolean isHeadLineCompare = value.trim().contains(mobileheadline);
        Utils.logStepInfo(true,"isHeadLineCompare = "+isHeadLineCompare);
        return isHeadLineCompare;
    }

    public boolean checkParagraph(String id, String uri, String address) {
        commonFunctions.scrollDownToPage(0.60, 0.20);
        String text = paraGraph.getText().trim();
        Utils.logStepInfo(true,"paragraph text of UI - "+text);
        Response response = apiValidation.getResponseFromURI(uri, address + id);
        LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read("$.listElement[0].paragraph");
        String value = paragraph.toString().trim();
        Utils.logStepInfo(true, "Paragraph Value from API response - " + value);
        boolean isParagraphMatch = value.contains(text.substring(0,20));
        Utils.logStepInfo(true,"isParagraphMatch = "+isParagraphMatch);
        return isParagraphMatch;
    }

    public boolean checkCaption(String id, String uri, String address) {
        String captionOfStory = commonFunctions.getElementText(caption, 5);
        Utils.logStepInfo(true,"captionOfStory in UI = "+captionOfStory);
        Response response = apiValidation.getResponseFromURI(uri, address + id);
        String value = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
        Utils.logStepInfo(true, "Caption from API Response = " + value);
        boolean isCaptionMatch = captionOfStory.contains(value);
        Utils.logStepInfo(true,"isCaptionMatch = "+isCaptionMatch);
        return isCaptionMatch;
    }

    public boolean checkShareIcon() {
        return commonFunctions.isVisible(shareIcon);
    }

    public boolean checkBookMark() {
        return commonFunctions.isVisible(bookMark);
    }

    public boolean checkAdvertisement() {
        commonFunctions.scrollUpToElementDisplayed(AdvertisementAtBottom);
        return commonFunctions.isVisible(AdvertisementAtBottom);
    }

    public boolean checkLeadImage() {
        boolean isLeadImageDisplayed = commonFunctions.isElementDisplayed(leadImage,10,"Lead Image");
        Utils.logStepInfo(true,"isLeadImageDisplayed = "+isLeadImageDisplayed);
        return isLeadImageDisplayed;
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
        return false;
    }

    @Override
    public boolean checkAuthorName() {
        return false;
    }

    @Override
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

    public boolean checkImageCredits(String id, String uri, String address) {
        String imageCredits = commonFunctions.getElementText(caption, 5);
        Response response = apiValidation.getResponseFromURI(uri, address + id);
        String value = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
        Utils.logStepInfo(true, "Value from API Response - " + value);
        Boolean isImageCredit = imageCredits.contains(value);
        Utils.logStepInfo(true,"isImageCredit = "+isImageCredit);
        return isImageCredit;
    }


    @Override
    public boolean photoHeadLineSummaryBookMarkAndShare(String uri, String address) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean hamburgerMenu = clickHamburgerButtonAndCheckNewsCategoryList();
        boolean photosOption = checkPhotosOptionAndRedirection();
        boolean photoStory = checkPhotoStoryTitleAndHeadLine();
        boolean checkAllPhotos = allPhotoFromSameStoryDisplay(photoPagePhoto);
        Utils.logStepInfo(true,"hamburgerMenu = "+hamburgerMenu);
        Utils.logStepInfo(true,"photosOption = "+photosOption);
        Utils.logStepInfo(true,"photoStory = "+photoStory);
        Utils.logStepInfo(true,"checkAllPhotos = "+checkAllPhotos);
        return hamburgerMenu && photosOption && photoStory && checkAllPhotos;
    }

    public boolean allPhotoFromSameStoryDisplay(MobileElement elementList) {
        boolean isPhotosDisplay = false;
        int i = 0;
        isPhotosDisplay = commonFunctions.isElementDisplayed(elementList, 5, "Photo of current story");
        while (isPhotosDisplay && !(commonFunctions.isElementDisplayed(nextStory, 5, "Next story upswing mark")) && i <= 5) {
            isPhotosDisplay = commonFunctions.scrollDownToElement(elementList,bookMark);
            commonFunctions.toGetRidOfAd(bookMark, 5);
            i++;
        }
        return isPhotosDisplay;
    }


    @Override
    public boolean checkImagePremiumDisplayed() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        Utils.logStepInfo("I Click on Premium tab to open Premium Section.");
        commonFunctions.clickElement(premiumButton, 5, "Premium Button");
        boolean isImagePremiumDisplayed = commonFunctions.isElementDisplayed(imagePremium, 5, "Premium Image");
        return isImagePremiumDisplayed;
    }

    @Override
    public boolean checkLeadImage3DotOption() {
        return false;
    }

    @Override
    public boolean checkAfterHeaderAdFirstStoryIsDisplayed() {
        commonFunctions.clickElement(home, 5, "Home Button");
        commonFunctions.isElementDisplayed(headerAd, 5, "Header Advertisement");
        boolean isFirstStoryDisplayed = commonFunctions.isElementDisplayed(firstStory, 5, "First Story After Header Ad");
        return isFirstStoryDisplayed;
    }

    @Override
    public boolean checkWhatsAppTwitterRelatedTopicPage() {
        return false;
    }

    @Override
    public boolean checkSectionNameisDispayed() {
        boolean isSectionNameDiplayed = false;
        commonFunctions.clickElement(home, 5, "Home Button");
        commonFunctions.clickElement(clickFirstStory, 5, "First Story");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(537, 515);
        commonFunctions.clickElementIfDisplayed(skipButton, 5, "SkipButtonInPopup");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 5, "Close Ad Button");
        commonFunctions.clickElementIfDisplayed(crossAdOption, 5, "crossicon");
        isSectionNameDiplayed = commonFunctions.isElementDisplayed(sectionName, 5, "Story Section Name");
        commonFunctions.getElementText(sectionName, 5);
        return isSectionNameDiplayed;
    }

    @Override
    public boolean checkSubSectionNameisDispayed() {
        boolean isSubSectionNameDiplayed = false;
        commonFunctions.clickElement(home, 5, "Home Button");
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(citiesSection, 5, "Cities Section");
        commonFunctions.clickElement(noidaSubSection, 5, "Noida Sub section");
        commonFunctions.clickElement(clickFirstStory, 5, "Story");
        commonFunctions.clickElementIfDisplayed(skipButton, 5, "SkipButtonInPopup");
        commonFunctions.clickElementIfDisplayed(closeAd, 5, "Close Ad");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 5, "Close Ad Button");
        commonFunctions.clickElementIfDisplayed(crossAdOption, 5, "crossicon");
        commonFunctions.isElementDisplayed(subSectionName, 5, "Sub Section Name Displayed");
        try {
            String subSection = commonFunctions.getElementText(subSectionName, 5);
            isSubSectionNameDiplayed = commonFunctions.checkTextEquals("NOIDA NEWS", subSection, "SubSection Name Displayed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isSubSectionNameDiplayed;
    }

    @Override
    public boolean checkShareStory3DotOption() {
        commonFunctions.clickElement(home, 5, "Home Button");
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(indiaSection, 5, "India Section");
        boolean IndiaHeading = commonFunctions.isElementDisplayed(indiaSectionHeader, 5, "India Section Page Header");
        commonFunctions.clickElement(dotsMenu, 5, "3 Dots Menu");
        commonFunctions.isElementDisplayed(shareOption, 5, "Share Story option");
        commonFunctions.clickElement(shareOption, 5, "Share Story Option");
        boolean ShareOptionWorking = commonFunctions.isElementDisplayed(shareOptionHeader, 5, "Share Option Header");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.clickElement(cancelButton, 5, "Cancel Button");
        return IndiaHeading && ShareOptionWorking;
    }

    @Override
    public boolean checkActionSheetCancelOption() {
        return false;
    }

    @Override
    public boolean checkIndiaPageThreeDotTapDisplayBottomAction() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(exploreButton, 5, "Home button");
        commonFunctions.clickElement(indiaSection, 5, "India section on explore");
        boolean sectionPageHeaderDisplay = commonFunctions.getElementText(sectionPageHeader, 5).contains("INDIA");
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story three dot button");
        boolean shareOptionDisplay = commonFunctions.isElementDisplayed(shareOptionThreeDot, 5, "Share option display after click on three dot");
        boolean bookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        boolean cancelOptionDisplay = commonFunctions.isElementDisplayed(cancelOptionThreeDot, 5, "Cancel option display after click on three dot");
        commonFunctions.pressAndroidBackKey();

        return sectionPageHeaderDisplay && shareOptionDisplay && bookmarkOptionDisplay && cancelOptionDisplay;
    }

    @Override
    public boolean checkIndiaPageRedirectionFromExplore() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(exploreButton, 5, "Home button");
        commonFunctions.clickElement(indiaSection, 5, "India section on explore");
        return commonFunctions.getElementText(sectionPageHeader, 5).contains("INDIA");
    }

    @Override
    public boolean checkCloseTabCloseBottomActionSheet() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(exploreButton, 5, "Home button");
        commonFunctions.clickElement(indiaSection, 5, "India section on explore");
        boolean sectionPageHeaderDisplay = commonFunctions.getElementText(sectionPageHeader, 5).contains("INDIA");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story three dot button");
        boolean shareOptionDisplay = commonFunctions.isElementDisplayed(shareOptionThreeDot, 5, "Share option display after click on three dot");
        boolean bookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        boolean cancelOptionDisplay = commonFunctions.isElementDisplayed(cancelOptionThreeDot, 5, "Cancel option display after click on three dot");
        commonFunctions.clickElement(cancelOptionThreeDot, 5, "Home button");
        boolean homeButtonIsDisplay = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        return sectionPageHeaderDisplay && shareOptionDisplay && bookmarkOptionDisplay && cancelOptionDisplay && homeButtonIsDisplay;
    }

    @Override
    public boolean checkRedirectionOnTappingAnyStoryOnIndiaPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(exploreBtn, 5, "Explore button");
        commonFunctions.clickElement(indiaSectionExplorePage, 5, "India Section button from Explore");
        boolean isIndiaPageRediretionTrue = commonFunctions.getElementText(pageHeaderName, 5).contains("INDIA");
        String firstStoryText = commonFunctions.getElementText(listOfStories.get(0), 5);
        commonFunctions.clickElement(listOfStories.get(0), 5, "First story from India section page");
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Clicking on bookmark Skip button to explore story details.");
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        boolean relatedStoryPageDisplay = commonFunctions.getElementText(openedStoryHeadline, 5).contains(firstStoryText);
        return isIndiaPageRediretionTrue && relatedStoryPageDisplay;
    }

    @Override
    public boolean checkRedirectionFromStoryDetailsPageOnTappingAnyStoryOnIndiaPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(exploreBtn, 5, "Explore button");
        commonFunctions.clickElement(indiaSectionExplorePage, 5, "India Section button from Explore");
        boolean isIndiaPageRediretionTrue = commonFunctions.getElementText(pageHeaderName, 5).contains("INDIA");
        String firstStoryText = commonFunctions.getElementText(listOfStories.get(0), 5);
        commonFunctions.clickElement(listOfStories.get(0), 5, "First story from India section page");
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Clicking on bookmark Skip button to explre story details.");
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        boolean relatedStoryPageDisplay = commonFunctions.getElementText(openedStoryHeadline, 5).contains(firstStoryText);
        commonFunctions.clickElement(hamburgerButton, 5, "App back button at top left");
        isIndiaPageRediretionTrue &= commonFunctions.getElementText(pageHeaderName, 5).contains("INDIA");
        return isIndiaPageRediretionTrue && relatedStoryPageDisplay;
    }

    @Override
    public boolean checkShareStoryFromIndia() {
        return false;
    }

    @Override
    public boolean checkAllStoriesArePremiumOnPremmiumPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean firstStroyIsPremium = commonFunctions.isElementDisplayed(premiumStoryHomePage, 5, "Premium logo on the first premium page story");
        boolean isAllStoriesPremium = scrollWhileAllStoriesArePremium();
        return firstStroyIsPremium && isAllStoriesPremium;
    }

    @Override
    public boolean checkPremiumPageDisplay() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        return commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
    }

    @Override
    public boolean checkPremiumPageHTPremiumDisplay() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isHTPremiumDisplay = commonFunctions.getElementText(premiumPageHeader, 10).contains(htPremium);
        return isHTPremiumDisplay;
    }

    @Override
    public boolean checkFirstStoryDisplayAfterTitle() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isPremiumPageHearderDisplay = commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
        boolean isPremiumFirstStoryDisplay = commonFunctions.isElementDisplayed(photoStoryTitle.get(0), 5, "First story at Premium page");
        return isPremiumFirstStoryDisplay && isPremiumPageHearderDisplay;
    }

    @Override
    public boolean checkFirstStoryImageDisplayWithPremiumTag() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isPremiumPageHearderDisplay = commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
        boolean isPremiumFirstStoryDisplay = commonFunctions.isElementDisplayed(photoStoryTitle.get(0), 5, "First story at Premium page");
        boolean isPremiumTagOnFirstStoryDisplay = commonFunctions.isElementDisplayed(premiumStoryHomePage, 5, "First story image of Premium page with Premium tag on it");
        return isPremiumPageHearderDisplay && isPremiumFirstStoryDisplay && isPremiumTagOnFirstStoryDisplay;
    }

    @Override
    public boolean checkOtherStoryAreAlsoPremium() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isPremiumPageHearderDisplay = commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
        boolean isAllOtherPremiumStoryDisplay = scrollWhileAllStoriesArePremium();
        return isPremiumPageHearderDisplay && isAllOtherPremiumStoryDisplay;
    }

    @Override
    public boolean checkAllOtherStoryHavePremiumTagAtBottom() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isPremiumPageHearderDisplay = commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
        Utils.logStepInfo("We will check all the stories apart from top leading story having premium tag.");
        boolean isAllOtherPremiumStoryDisplay = scrollWhileAllStoriesArePremium();
        return isPremiumPageHearderDisplay && isAllOtherPremiumStoryDisplay;
    }

    @Override
    public boolean checkStoryHaveSubSectionBelowTitle() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isPremiumPageHearderDisplay = commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
        Utils.logStepInfo("We will check Story have Subsection below title name of the story in Premium page.");
        boolean isSubSectionNameDisplay = commonFunctions.isElementDisplayed(storySubSectionName.get(1), 5, "First story subsection name display");
        return isPremiumPageHearderDisplay && isSubSectionNameDisplay;
    }

    @Override
    public boolean checkStoryDisplayOnItsSectionPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isPremiumPageHeaderDisplay = commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
        Utils.logStepInfo(true,"We will check Story have Subsection below title name of the story in Premium page.");
        boolean isSubSectionNameDisplay = commonFunctions.isElementDisplayed(storySubSectionName.get(1), 5, "First story subsection name display");

        String firstStoryTitle = commonFunctions.getElementText(photoStoryTitle.get(1), 5);
        Utils.logStepInfo(true,"firstStoryTitle = "+firstStoryTitle);

        String subSectionNameText = commonFunctions.getElementText(storySubSectionName.get(1), 5);
        Utils.logStepInfo(true,"subSectionNameText = "+subSectionNameText);

        commonFunctions.clickElement(storySubSectionName.get(1), 5, "Subsection of the first story");
        commonFunctions.dummyWait(5);
        String subSectionPageHeaderName = commonFunctions.getElementText(relatedTopicPageHeader, 10);
        boolean weAreAtTheRightPage = commonFunctions.compareTexts(subSectionNameText, subSectionPageHeaderName);
        boolean storyIsAvailableAtSubSectionPage = commonFunctions.scrollTillVisibleText(firstStoryTitle, firstStoryTitle + " related story in " + subSectionNameText);
        Utils.logStepInfo(true,"weAreAtTheRightPage = "+weAreAtTheRightPage);
        Utils.logStepInfo(true,"isSubSectionNameDisplay = "+isSubSectionNameDisplay);
        Utils.logStepInfo(true,"isPremiumPageHeaderDisplay = "+isPremiumPageHeaderDisplay);
        Utils.logStepInfo(true,"storyIsAvailableAtSubSectionPage = "+storyIsAvailableAtSubSectionPage);
        return weAreAtTheRightPage && isSubSectionNameDisplay && isPremiumPageHeaderDisplay || storyIsAvailableAtSubSectionPage;
    }

    @Override
    public boolean checkNonLoggedUserOnPremiumPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(premiumButton, 5, "Premium button on Home page");
        boolean isPremiumPageHearderDisplay = commonFunctions.getElementText(premiumPageHeader, 5).contains(htPremium);
        commonFunctions.clickElement(photoStoryTitle.get(1), 5, "First Story of the premium page");
        commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        boolean loginOptionAvailable = commonFunctions.checkElementVisibilityByScrolling(premiumStorySignInButton, "Sign In box appear on Premium story page");
        return isPremiumPageHearderDisplay && loginOptionAvailable;
    }

    public boolean scrollWhileAllStoriesArePremium() {
        boolean isPremiumStoryDisplay;
        int i = 0;
        while (i <= 10 && !commonFunctions.getElementText(imagePremium, 5).contains("Premium")) {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                    moveTo(PointOption.point(width / 2, height / 10)).release().perform();
            i++;
        }
        if (commonFunctions.isElementDisplayed(imagePremium, 5, "Logo of Premium of premium page")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean scrollDownToRelatedTopicsSection(){
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(quickReads,5,"Quick Reads");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(pageStoryList.get(2), 5, "First Story of the current page");
        commonFunctions.toGetRidOfAd(bookMark,5);
        Utils.logStepInfo("Click of skip button should be performed to continue further app interaction.");
        commonFunctions.dummyWait(3);
        commonFunctions.clickByCoordinates(537, 515);
        boolean isScrollDownTillTopics = commonFunctions.scrollDownToElement(relatedTopic,bookMark,25);
        Utils.logStepInfo(true,"isScrollDownTillTopics = "+isScrollDownTillTopics);
        if (commonFunctions.isElementNotDisplayed(relatedTopicsList.get(0),5,"First Related Topic")){
            commonFunctions.swipeElementUsingTouchAction(568,1253,499,373);
        }
        return isScrollDownTillTopics;
    }

    @Override
    public boolean checkRelatedTopicHeadingDisplayed() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isPageTitleDisplay= commonFunctions.getElementText(relatedTopic,10).equalsIgnoreCase("Related Topics");
        return isPageTitleDisplay && relatedTopicDisplay;
    }

    @Override
    public boolean checkRelatedTopicsDisplayed() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isPageTitleDisplay= commonFunctions.getElementText(relatedTopic,10).equalsIgnoreCase("Related Topics");
        commonFunctions.scrollDownSlowToElement(relatedTopicsList.get(0),10);
        boolean isTopicsDisplay= relatedTopicsList.size()>0;
        return isPageTitleDisplay && relatedTopicDisplay && isTopicsDisplay;
    }

    @Override
    public boolean checkRelatedTopicsRedirection() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isRelatedTopicHeaderDisplayed=commonFunctions.isRelatedTopicHeaderDisplayed(relatedTopic,relatedTopicsList,relatedTopicPageHeader);
        return isRelatedTopicHeaderDisplayed && relatedTopicDisplay;
    }

    @Override
    public boolean checkRelatedTopicsPageStoryRedirection() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        boolean isRelatedTopicHeaderDisplayed=commonFunctions.isRelatedTopicHeaderDisplayed(relatedTopic,relatedTopicsList,relatedTopicPageHeader);
        commonFunctions.clickElement(pageStoryList.get(0), 5, "First Story of the current page");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(closeAppAdBtn,5,"Another application close button");
        commonFunctions.toGetRidOfAd(bookMark,5);
        commonFunctions.clickByCoordinates(537,515);
        boolean isStoryDisplayed= commonFunctions.isElementDisplayed(storyCaption,10,"Story Caption")
                && commonFunctions.isElementDisplayed(storyImage,10,"Story Image")
                && commonFunctions.isElementDisplayed(storyHeadline,10,"Story Headline");
        commonFunctions.scrollUntilElementFound(storyParagraph);
        boolean isParagraphDisplayed = commonFunctions.isElementDisplayed(storyParagraph,5,"Paragraph displayed");
        Utils.logStepInfo(true,"isRelatedTopicHeaderDisplayed = "+isRelatedTopicHeaderDisplayed);
        Utils.logStepInfo(true,"relatedTopicDisplay = "+relatedTopicDisplay);
        Utils.logStepInfo(true,"isStoryDisplayed = "+isStoryDisplayed);
        Utils.logStepInfo(true,"isParagraphDisplayed = "+isParagraphDisplayed);
        return isRelatedTopicHeaderDisplayed && relatedTopicDisplay && isStoryDisplayed && isParagraphDisplayed;
    }

    @Override
    public boolean checkRedirectionOnTopicStoryIfTabOnbBackBtn() {
        boolean relatedTopicDisplay=scrollDownToRelatedTopicsSection();
        String firstTopicText = commonFunctions.getElementText(relatedTopicsList.get(0),5);
        commonFunctions.clickElement(relatedTopicsList.get(0),5,"Click on Topic");
        boolean isTopicHeader = commonFunctions.getElementText(relatedTopicPageHeader,5).equalsIgnoreCase(firstTopicText);
        commonFunctions.clickElement(hamburgerButton,5,"back Button");
       commonFunctions.toGetRidOfAd(bookMark,5);
       //boolean isHomePage = commonFunctions.isElementDisplayed(home,5,"Home Page");
        boolean isStoryPageAfterBack = false;
       if(commonFunctions.isElementNotDisplayed(relatedTopic,5,"Related Topic - "))
       {
           commonFunctions.pressAndroidBackKey();
           commonFunctions.dummyWait(5);
           isStoryPageAfterBack = commonFunctions.isElementDisplayed(relatedTopic,5,"Related Topic under if condition...");
       }
       else{
           isStoryPageAfterBack = true;
           Utils.logStepInfo(true, "Back from Topic successfully and Story Page Displayed");
       }
       Utils.logStepInfo(true,"relatedTopicDisplay = "+relatedTopicDisplay);
       Utils.logStepInfo(true,"isTopicHeader = "+isTopicHeader);
       Utils.logStepInfo(true,"isStoryPageAfterBack = "+isStoryPageAfterBack);
       return relatedTopicDisplay && isTopicHeader && isStoryPageAfterBack;
    }

    @Override
    public boolean checkShareStoryFromTopicScreen() {
        boolean relatedTopicDisplay = scrollDownToRelatedTopicsSection();
        commonFunctions.clickElement(relatedTopicsList.get(0),5,"Click on Topic");
        commonFunctions.clickElement(threeDotButton.get(0),5,"Three Dots");
        boolean is3DotMsgBox = commonFunctions.isElementDisplayed(threeDotMsgBox,5,"3 Dot Msg Box");
        boolean isBookMarkOption = commonFunctions.isElementDisplayed(shareOption,5,"Share Option");
        commonFunctions.clickElement(shareOption,5,"Share Option");
        Utils.logStepInfo(true, "relatedTopicDisplay = "+relatedTopicDisplay);
        Utils.logStepInfo(true, "is3DotMsgBox = "+is3DotMsgBox);
        Utils.logStepInfo(true, "isBookMarkOption = "+isBookMarkOption);
        return relatedTopicDisplay && is3DotMsgBox && isBookMarkOption;
    }

    @Override
    public boolean checkRedirectionOnStoryIfTabOnSectionName() {
        boolean isRedirectToSection=true;
        boolean relatedTopicDisplay = scrollDownToRelatedTopicsSection();
        commonFunctions.clickElement(relatedTopicsList.get(0),5,"Click on Topic");
        String sectionName = commonFunctions.getElementText(storySubSectionName.get(0),5);
        commonFunctions.clickElement(storySubSectionName.get(0),5,"Section Name in first Story in topic Story");
        String sectionNameInSectionPage = commonFunctions.getElementText(storySubSectionName.get(0),5);
        String sectionNameInListingPage = null;
        if(sectionName.equalsIgnoreCase(sectionNameInSectionPage)){
            sectionNameInListingPage = commonFunctions.getElementText(sectionPageHeader,5);
            isRedirectToSection &= true;
        }
        isRedirectToSection &= commonFunctions.isElementDisplayed(sectionPageHeader,5,"Page Header");
        Utils.logStepInfo(true,"isRedirectToSection = "+isRedirectToSection);
        Utils.logStepInfo(true,"relatedTopicDisplay = "+relatedTopicDisplay);
        return isRedirectToSection && relatedTopicDisplay;
    }

    @Override
    public boolean checkReadAloudOptionInStoryPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(photoStoryTitle.get(0), 5, "First Story");
        commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        boolean isReadAloudOption = commonFunctions.isElementDisplayed(readAloudOptionInStory,5,"Read Aloud Option in Story Page");
        return isReadAloudOption;
    }

    @Override
    public boolean checkRedirectionWhenUserTapsOnStoryInCitiesSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.swipeElementUsingTouchAction(830,275,400,275);
        boolean isCitiesSectionDisplay = commonFunctions.clickElementIfDisplayed(citiesSection,5,"Cities");
        boolean isPopMessageDisplayed = commonFunctions.clickElementIfDisplayed(gotItButtonOnCitiesPopUp,5,"Got it button");
        if (isPopMessageDisplayed) {
            commonFunctions.clickElement(listOfCitiesInSection.get(0),5,"First City");
            commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save Changes");
        }
        commonFunctions.clickElement(clickFirstStory,5,"First story on cities section");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        boolean isStoryDetailingPageDisplayed = commonFunctions.isElementDisplayed(storyDetailPage,5,"Story detailing page");
        commonFunctions.pressAndroidBackKey();
        return isCitiesSectionDisplay && isStoryDetailingPageDisplayed;
    }

    @Override
    public boolean checkSubscriptionPaywall(String HTPremiumPageUrl, String email, String password) {
        return false;
    }
}