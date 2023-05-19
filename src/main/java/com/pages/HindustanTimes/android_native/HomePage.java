package com.pages.HindustanTimes.android_native;


import java.time.Duration;
import java.util.List;

import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.sun.javafx.scene.traversal.Direction;
import com.utils.ApiValidation;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends CommonHomePage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static ApiValidation apiValidation;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='E-Paper']")
    private static MobileElement epaperOption;

    @AndroidFindBy(id = "deny")
    private static AndroidElement deny;

    @AndroidFindBy(xpath = "//a[text()='Continue']")
    private static AndroidElement continueBtn;

    @AndroidFindBy(xpath = "(//button[@class='skip_button'])[1]")
    private static AndroidElement skipWebNotification;

    @AndroidFindBy(xpath = "//header[@class='header is_subscribe_cta']")
    private static AndroidElement headerSection;

    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreMenu;

    @AndroidFindBy(accessibility = "Quickreads")
    private static MobileElement quickReadsMenu;

    @AndroidFindBy(accessibility = "Premium")
    private static MobileElement premiumMenu;

    //using this Appium generated xpath below, as there is no other locator present
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private static MobileElement logoHT;

    @AndroidFindBy(xpath = "//*[@text='Entertainment']")
    private static MobileElement entertainmentNews;

    @AndroidFindBy(xpath = "//*[@text='Cities']")
    private static MobileElement citiesNews;

    @AndroidFindBy(xpath = "//*[@text='Epaper']")
    private static MobileElement ePaper;

    @AndroidFindBy(id = "com.ht.news:id/epaper")
    private static MobileElement ePaperButtonOnHeader;

    @AndroidFindBy(id = "com.ht.news:id/navigation_quickread")
    private static MobileElement quickreadsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Chrome')]")
    private static MobileElement chromeOption;

    @AndroidFindBy(id = "android:id/button_once")
    private static MobileElement onceOptionWeb;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private static MobileElement epaperWebUrlBox;

    @AndroidFindBy(xpath = "//*[@text='Home']")
    private static MobileElement home;

    @AndroidFindBy(xpath = "//*[@text='India']")
    private static MobileElement indiaNews;

    @AndroidFindBy(xpath = "//*[@text='Elections']")
    private static MobileElement electionsNews;

    @AndroidFindBy(xpath = "//*[@text='Opinion']")
    private static MobileElement opinion;

    @AndroidFindBy(xpath = "//*[@text='Cricket']")
    private static MobileElement cricketNews;

    @AndroidFindBy(xpath = "//*[@text='Trending']")
    private static MobileElement trending;

    @AndroidFindBy(xpath = "//*[@text='Videos']")
    private static MobileElement videos;

    @AndroidFindBy(xpath = "//*[@text='World']")
    private static MobileElement worldNews;

    @AndroidFindBy(xpath = "//*[@text='Quickreads']")
    private static MobileElement quickReads;

    @AndroidFindBy(xpath = "//*[@text='Lifestyle']")
    private static MobileElement lifeStyle;

    @AndroidFindBy(xpath = "//*[@text='Education']")
    private static MobileElement education;

    @AndroidFindBy(xpath = "//*[@text='Podcasts']")
    private static MobileElement podcasts;

    @AndroidFindBy(xpath = "//*[@text='Sports']")
    private static MobileElement sports;

    @AndroidFindBy(xpath = "//*[@text='Photos']")
    private static MobileElement photos;

    @AndroidFindBy(xpath = "//*[@text='Delhi News']")
    private static MobileElement delhiNews;

    @AndroidFindBy(xpath = "//*[@text='TV News']")
    private static MobileElement tvNews;

    @AndroidFindBy(xpath = "//*[@text='Mumbai News']")
    private static MobileElement mumbaiNews;

    @AndroidFindBy(xpath = "//*[@text='Business']")
    private static MobileElement business;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ht.news:id/ad_view_320_100']")
    private static MobileElement headerAd;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ht.news:id/ad_view']")
    private static MobileElement footerAd;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resoure-id='com.ht.news:id/parent']")
    private static MobileElement scrollTillBottom;

    @AndroidFindBy(xpath = "//*[@text='Home']")
    private static MobileElement redirectToHome;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Home']/android.widget.TextView")
    private static MobileElement highLightingHome;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ht.news:id/titleTv']")
    private static List<MobileElement> bottom;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_name")
    private static List<MobileElement> hamburgerMenuOptions;

    @AndroidFindBy(id = "com.ht.news:id/thumb_image")
    private static MobileElement tapOnStory;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement headLine;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private static MobileElement backButton;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id='com.ht.news:id/imgViewThumbnail'])[1]")
    private static MobileElement ads;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static MobileElement redirectionToHome;

    @AndroidFindBy(id = "com.ht.news:id/moreFromSectionTv") //com.ht.news:id/afterArticleWidgetTv
    private static MobileElement youMayLikeAlso;

    @AndroidFindBy(id = "com.ht.news:id/swipeUpHint")
    private static MobileElement nextStory;

    @AndroidFindBy(id = "com.ht.news:id/layoutParent")
    private static List<MobileElement> parentLayout;

    @AndroidFindBy(id = "com.ht.news:id/tv_advertisement")
    private static List<MobileElement> AdvAtTheEndOfStory;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='twitter-widget-0']")
    private static MobileElement embedsInStory;

    @AndroidFindBy(id = "com.ht.news:id/fav_drawer")
    private static MobileElement savedArticles;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement summary;

    @AndroidFindBy(accessibility = "//android.widget.ImageButton[@content-desc='Collapse']")
    private static MobileElement backFromArticles;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='View on Twitter']")
    private static MobileElement embedTwitter;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc]")
    private static List<MobileElement> hometabHeader;

    @AndroidFindBy(id = "com.ht.news:id/searchLayout")
    private static MobileElement searchField;

    @AndroidFindBy(id = "com.ht.news:id/search_drawer")
    private static MobileElement searchTab;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static MobileElement firstStorySearch;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement headLineInSearch;

    @AndroidFindBy(xpath = "com.ht.news:id/etSearch")
    private static MobileElement searchBar;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> firstStory;

    @AndroidFindBy(id = "com.ht.news:id/titleSubSection")
    private static List<MobileElement> listOfSubSectionsInDailyDigestStoriesPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private static MobileElement homePagePremium;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Premium']")
    private static MobileElement sectionPremium;

    @AndroidFindBy(xpath = "com.ht.news:id/newsTypeIconIsExclusive")
    private static MobileElement firstStoryExclusiveTag;

    @AndroidFindBy(xpath = "com.ht.news:id/newsTypeIconIsBlog")
    private static MobileElement secondStoryExclusiveTag;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static MobileElement firstStoryPremiumTitle;

    @AndroidFindBy(id = "com.ht.news:id/premiumIv")
    private static MobileElement InLineStoryExclusiveTag;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement firstStoryPremiumHeadLine;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chrome']")
    private static MobileElement chooseChrome;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='All']/android.widget.TextView")
    private static MobileElement quickReadsAllTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='India News']/android.widget.TextView")
    private static MobileElement quickReadsIndiaNewsTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Business']/android.widget.TextView")
    private static MobileElement quickReadsBusinessNewsTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Sports']/android.widget.TextView")
    private static MobileElement quickReadsSportsNewsTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Astrology']/android.widget.TextView")
    private static MobileElement quickReadsAstrologyNewsTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Cricket']/android.widget.TextView")
    private static MobileElement quickReadsCricketTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Cities']/android.widget.TextView")
    private static MobileElement quickReadsCitiesTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='World News']/android.widget.TextView")
    private static MobileElement quickReadsWorldNewsTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Lifestyle']/android.widget.TextView")
    private static MobileElement quickReadsLifeStyleTab;

    @AndroidFindBy(id = "android:id/button_always")
    private static MobileElement always;

    @AndroidFindBy(accessibility = "Interstitial close button")
    private static MobileElement adPopUpInApp;

    @AndroidFindBy(id = "com.ht.news:id/profile")
    private static MobileElement profileButton;

    @AndroidFindBy(accessibility = "Home")
    private static MobileElement homeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private static MobileElement loginText;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Entertainment']/android.widget.TextView")
    private static MobileElement quickreadEntertainmentTab;

    //using this Appium generated xpath below, as there is no other locator present
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private static MobileElement htLogo;

    @AndroidFindBy(id = "com.ht.news:id/et_email_or_mobile")
    private static MobileElement emailTextArea;

    @AndroidFindBy(id = "com.ht.news:id/epaper")
    private static MobileElement epaperButton;

    @AndroidFindBy(id = "com.ht.news:id/et_password")
    private static MobileElement passwordTextArea;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_heading")
    private static MobileElement popularSectionPage;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']")
    private static MobileElement videoSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daily Digest']")
    private static MobileElement dailyDigestSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    private static MobileElement photosSection;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement sectionPageHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRIVACY POLICY']")
    private static MobileElement privacyPolicyHeader;

    @AndroidFindBy(id = "com.ht.news:id/txtEnterEmailAddress")
    private static MobileElement enterEmailAddressNewsLetterText;

    @AndroidFindBy(id = "com.ht.news:id/bt_continue")
    private static MobileElement loginContinueButton;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static MobileElement storyHeadline;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static MobileElement openStoryHeadline;

    @AndroidFindBy(id = "com.ht.news:id/recent_notification")
    public static MobileElement premiumPage;

    @AndroidFindBy(id = "com.ht.news:id/adIndicator")
    public static MobileElement firstAd;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top News']")
    private static MobileElement topNewsSection;

    @AndroidFindBy(id = "com.ht.news:id/titleSubSection")
    private static List<MobileElement> storySectionName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India']")
    private static MobileElement indiaSection;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> storyHeadlines;

    @AndroidFindBy(id = "com.ht.news:id/tvQuickreadsImvTitle")
    private static List<MobileElement> firstStoryInQuickRead;

    @AndroidFindBy(id = "com.ht.news:id/imvFacebook")
    private static MobileElement facebookShareBtn;

    @AndroidFindBy(id = "com.ht.news:id/tvQuickreadsFullStory")
    private static MobileElement readFullStoryBtnQuickRead;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Newsletters']")
    private static MobileElement newsLettersWindow;
    @AndroidFindBy(xpath="//android.widget.TextView[1][@text='Daily News Capsule']")
    private static MobileElement dailyNewsCapsuleOption;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Daily News Capsule']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private static MobileElement dailyNewsCapsuleSubscribeButton;

    @AndroidFindBy(id ="com.ht.news:id/heading_tv")
    private  static MobileElement nonLoggedInUserHeading;

    @AndroidFindBy(id ="com.ht.news:id/ivCancel")
    private  static MobileElement homePageCancelButton;

    @AndroidFindBy(xpath="//android.widget.Button[@text='Register Now']")
    private static MobileElement registerNowButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='@HT_Ed Calling']")
    private static MobileElement ht_EdCallingOption;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='HT Wknd']")
    private static MobileElement htWkndCardOption;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='@HT_Ed Calling']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private static MobileElement ht_EdCallingOptionSubscribeButton;

    @AndroidFindBy(id ="com.ht.news:id/tvEmailorMobileNumber")
    private static MobileElement emailPrefilledOption;

    @AndroidFindBy(id ="com.ht.news:id/txtSubscribeNow")
    private static MobileElement subsribeNowButton;

    @AndroidFindBy(id = "com.ht.news:id/customAlertMsg")
    private  static MobileElement newsletterSubscribepopup;

    @AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='com.ht.news:id/tv_title_name']")
    private static List<MobileElement> newsLetterCarousel;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='HT Wknd']")
    private static MobileElement htWkndOption;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='HT Wknd']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private  static MobileElement htWkndSubscribeButton;

    @AndroidFindBy(id = "com.ht.news:id/headlineTv")
    private static MobileElement homePageBottomElment;

    @AndroidFindBy(id = "com.ht.news:id/viewAllTv")
    private static List<MobileElement> viewAllButtons;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Latest Videos']")
    private static MobileElement latestVideosCarousel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Cricket']")
    private static MobileElement cricketCarousel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Quickreads']")
    private static List<MobileElement> quickReadsForCrousl;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'ADVERTISEMENT']")
    private static MobileElement secondAdAfterFiveStories;


    @AndroidFindBy(id ="com.ht.news:id/headlineTv")
    private static MobileElement dontMissCarousel;

    @AndroidFindBy(id = "com.ht.news:id/adsContainerRootLayout")
    private static MobileElement adAfterDontMissSection;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static List<MobileElement> threeDotButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_bookmark")
    private static MobileElement bookMarkOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Share']")
    private static MobileElement shareOption;

    @AndroidFindBy(id = "android:id/title")
    private static MobileElement shareSheet;

    @AndroidFindBy(id = "com.ht.news:id/btn_cancel")
    private static MobileElement cancelBtn;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat")
    private static MobileElement threeDotMsgBox;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.ht.news:id/titleTv'])[1]")
    private static MobileElement clickFirstStory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Web Stories']")
    private static MobileElement webStoriesSection;

    @AndroidFindBy(id = "com.ht.news:id/constraintLayout")
    private static List<MobileElement> allStoriesInWebStories;

    @AndroidFindBy(xpath = "/android.view.View/android.widget.TextView[1]")
    private static MobileElement headingInOpenWebStories;

    @AndroidFindBy (xpath = "//android.widget.Image[@text = 'ht logo']")
    private static MobileElement htLogoInWebStory;

    @AndroidFindBy (id = "com.ht.news:id/ht_logo")
    private static List<MobileElement> htLogosInWebStoriesPage;

    @AndroidFindBy (id = "com.ht.news:id/dot")
    private static List<MobileElement> threeDotInAllWebStories;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text = 'Quickreads'])[1]")
    private static MobileElement quickReadsCraousel;

    @AndroidFindBy(id = "com.ht.news:id/card_layout")
    private static List<MobileElement> storyListInQuickReads;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Read']")
    private static MobileElement mostReadSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Newsletters']")
    private static MobileElement newsLettersCarousel;

    @AndroidFindBy(id = "com.ht.news:id/btnClose")
    private static MobileElement registerNowCancelButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='HT Week Ahead']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private  static MobileElement htWeekAheadSubscribeButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='HT Capital Letters']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private  static MobileElement htCapitalLettersSubscribeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wired Wisdom']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private static MobileElement wiredWisdomSubscribeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HT City']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private static MobileElement htCitySubscribeButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HT Mind the Gap']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private static MobileElement htMindTheGapSubscribeButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HT Kick Off']/parent::android.widget.LinearLayout//*[contains(@text,'Subscribe')]")
    private static MobileElement htKickOffSubscribeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Recommended For You']")
    private static MobileElement recommendedForYouCarousel;

    @AndroidFindBy(id = "com.ht.news:id/viewAllTv")
    private static MobileElement viewAllButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='For You']")
    private static MobileElement forYouTab;
    @AndroidFindBy(id = "com.ht.news:id/title")
    private static List<MobileElement> recommendedForYouStoryList;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement forYouStoryHeadline;

    @AndroidFindBy(id = "com.ht.news:id/tv_preview")
    private static List<MobileElement> readNowInNewsLetter;

    @AndroidFindBy(id = "com.ht.news:id/layoutParent")
    private static List<MobileElement> listOfStoriesOnDailyDigestPage;

    @AndroidFindBy(id = "com.ht.news:id/img_news")
    private static MobileElement leadImage;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement caption;

    @AndroidFindBy(id = "com.ht.news:id/btnClose")
    private static MobileElement newsLetterCloseButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> listOfSectionInQuickReads;

    @AndroidFindBy(id ="com.ht.news:id/tvQuickreadsNextStory")
    private static MobileElement swipeUpInQuickReads;

    @AndroidFindBy (id="com.ht.news:id/navigation_bar_item_icon_view")
    private static List<MobileElement> listOfBottomNavOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='City News']")
    private static MobileElement cityNewsInHomepage;

    @AndroidFindBy(id = "com.ht.news:id/ll_city")
    private static List<MobileElement> listOfCitiesInCityNews;

    @AndroidFindBy(id = "com.ht.news:id/subViewAllTv")
    private static MobileElement viewAllInCityNews;

    @AndroidFindBy(id = "com.ht.news:id/topicChip")
    private static MobileElement popUpOnCities;

    @AndroidFindBy(id = "com.ht.news:id/bt_continue")
    private static MobileElement gotItButtonOnCitiesPopUp;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Cities\"]")
    private static MobileElement citiesSection;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[contains(@content-desc,\"\")]//android.widget.TextView)[1]")
    private static MobileElement firstSectionAtTop;

    @AndroidFindBy(id = "com.ht.news:id/may_be_later_btn")
    private static MobileElement mayBeLaterButtonOnCitiesSection;

    @AndroidFindBy(id = "com.ht.news:id/add_city_btn")
    private static MobileElement addCitiesOption;

    @AndroidFindBy(xpath = "//android.widget.TextView [@text='Delhi']")
    private static MobileElement delhiSelectButton;

    @AndroidFindBy(id = "com.ht.news:id/save_btn")
    private static MobileElement saveChangesButtonOnCitiesSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Add your')]")
    private static MobileElement addFavouriteCities;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Noida']")
    private static MobileElement noidaCitySelectButton;

    @AndroidFindBy(id="com.ht.news:id/bookmark")
    private static MobileElement bookMark;

    private static int expecteElementListSizeInQuickRead = 1;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        //commonFunctions.clickElementIfDisplayed(skipButton,5,"Skip Button");
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        /*commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(206, 1950);
        commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);*///As skip/next button in the prompt locator is not available
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");


        //next four lines are temporary code to click on skip/next in the prompt
//        commonFunctions.clickElementWithCoordinates(713, 1917);
//        commonFunctions.clickElementWithCoordinates(713, 1917);
//        commonFunctions.clickElementWithCoordinates(920, 1917);
//        commonFunctions.clickElementWithCoordinates(920, 1917);
    }

    @Override
    public boolean checkEpaperCTALogoRedirection(String params[]) {

        boolean isRedirectionSuccessful = false;
        commonFunctions.isElementDisplayed(epaperOption, 5, "Epaper Option");
        commonFunctions.clickElement(epaperOption, 5, "Epaper Option");
        try {
            Thread.sleep(8000);
            if (chooseChrome.isDisplayed() == true) {
                commonFunctions.clickElement(chooseChrome, 5, "choose chrome option");
                commonFunctions.clickElement(always, 5, "Always option");
            } else {
                commonFunctions.clickElement(always, 5, "Always option");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Utils.logStepInfo(String.valueOf(driver.getContextHandles()));
        commonFunctions.changeContextToWeb();
        String currentUrl = commonFunctions.getCurrentURL("epaper", "current url");
        if (currentUrl.contains(params[2])) {
            isRedirectionSuccessful = true;
            Utils.logStepInfo(true, "Redirection is successful");
        }
        commonFunctions.pressAndroidBackKey();
        return isRedirectionSuccessful;
    }

    @Override
    public boolean checkAdDisplayingHomePage() {
        return false;
    }

    public boolean checkClickOnStory(String title) {
        //commonFunctions.clickElement(exploreMenu,5);
        commonFunctions.clickElement(searchField, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(searchBar, 5);
        commonFunctions.sendKeyWithAction(title, "Entered search text");
        commonFunctions.clickElementIfDisplayed(skipButton, 5, "Skip Button");
        //press enter key is not working
        commonFunctions.pressEnterKey();
        return commonFunctions.clickElement(firstStorySearch);

    }


    public boolean checkRedirectedToStory(String title) {
        String text = commonFunctions.getElementText(headLine, 5);
        return text.contains(title);
    }

    public boolean checkStoryCompletelyLoaded() {
        return commonFunctions.isElementDisplayed(summary, 5, "Storypage completely loaded");
    }

    public boolean scrollTopToBottomOfStory() {
        int sizeOfAd = AdvAtTheEndOfStory.size();
        commonFunctions.scrollUpToElementDisplayed(AdvAtTheEndOfStory.get(sizeOfAd - 1));
        Utils.logStepInfo(true, AdvAtTheEndOfStory.get(sizeOfAd - 1) + " available");
        return commonFunctions.isElementDisplayed(AdvAtTheEndOfStory.get(sizeOfAd - 1));

    }

    public boolean checkEmbedDisplay() {
        //commonFunctions.scrollUpToElementDisplayed(embedTwitter);
        if (commonFunctions.isElementDisplayed(embedTwitter, 5, "Embeds")) {
            Utils.logStepInfo(true, embedTwitter + " available");
        } else {
            Utils.logStepInfo(false, embedTwitter + " Not Available");
        }
        return true;
    }

    public boolean checkRedirectionToHomePage() {
        commonFunctions.clickElementIfDisplayed(skipButton, 5, "Skip Button");
        commonFunctions.clickElement(backButton, 5);
        commonFunctions.dummyWait(5);
        /*commonFunctions.pressBackKey();
        commonFunctions.pressBackKey();
        commonFunctions.pressBackKey();*/
        return commonFunctions.isElementDisplayed(redirectionToHome, 5, "Back to Home Page");
    }

    public boolean checkNextStoryAndYouMayAlsoLike() {


		/*commonFunctions.clickElementNoException(adPopUpInApp, "Popup in App");
		try{commonFunctions.tapByCoordinate(220,1904,"close button");}
		catch (Exception e){
			e.printStackTrace();
		}*/
        commonFunctions.clickElement(firstStory.get(0), 5);
//    	commonFunctions.scrollUpToElementDisplayed(youMayLikeAlso);
        int sizeOfAd = AdvAtTheEndOfStory.size();
        commonFunctions.scrollUpToElementDisplayed(AdvAtTheEndOfStory.get(sizeOfAd - 1));
        commonFunctions.scrollTillVisibleText("next story", "next story");
        boolean nextstory = commonFunctions.isElementDisplayed(nextStory, 5, "next story");
        commonFunctions.scrollUpToElementDisplayed(youMayLikeAlso);
        boolean youmaylike = commonFunctions.isElementDisplayed(youMayLikeAlso, 5, "you may also like");
        return nextstory && youmaylike;
    }

    public boolean isHtLogoDisplayed() {
        return commonFunctions.isElementDisplayed(logoHT, 5, "HT Logo");
    }

    public boolean checkAdDisplayingTopAd() {
        return commonFunctions.isElementDisplayed(headerAd, 5, "Header Advertise");
    }

    public boolean checkAdDisplayingFooterAd() {
        return commonFunctions.isElementDisplayed(footerAd, 5, "Footer Advertise");
    }

    public boolean scrollTopToBottomInHomePage() {
        boolean isPageScrolled = false;
        boolean ele = commonFunctions.isElementDisplayed(bottom.get(2), 5, "bottom of the page");
        try {
            if (ele == true) {
                for (int i = 0; i < 25; i++) {
                    commonFunctions.scrollToBottom();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        isPageScrolled = commonFunctions.isElementDisplayed(bottom.get(2), 5, "bottom of the page");
        return isPageScrolled;
    }

    public boolean clickOnExplorerMenu() {
        return commonFunctions.clickElement(exploreMenu, 5, "Explore Menu");

    }

    public boolean checkHamburgerMenuHomeOptionDisplayed() {
        return commonFunctions.isElementDisplayed(home, 5, "Home");
    }

    public boolean checkHamburgerMenuQuickReadsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(quickReads, 5, "QuickReads");
    }

    public boolean checkHamburgerMenuIndiaNewsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(indiaNews, 5, "India News");
    }

    public boolean checkHamburgerMenuWorldOptionDisplayed() {
        return commonFunctions.isElementDisplayed(worldNews, 5, "World News");
    }

    public boolean checkHamburgerMenuCitiesOptionDisplayed() {
        return commonFunctions.isElementDisplayed(citiesNews, 5, "Cities News");
    }

    public boolean checkHamburgerMenuOpinionOptionDisplayed() {
        return commonFunctions.isElementDisplayed(opinion, 5, "Opinion News");
    }

    public boolean checkHamburgerMenuCricketOptionDisplayed() {
        return commonFunctions.isElementDisplayed(cricketNews, 5, "Cricket News");
    }

    public boolean checkHamburgerMenuElectionNewsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(electionsNews, 5, "Election News");
    }

    public boolean checkHamburgerMenuEpaperOptionDisplayed() {
        return commonFunctions.isElementDisplayed(ePaper, 5, "Epaper");
    }

    public boolean checkHamburgerMenuTrendingOptionDisplayed() {
        return commonFunctions.isElementDisplayed(trending, 5, "Trending News");
    }

    public boolean checkHamburgerMenuVideosOptionDisplayed() {
        return commonFunctions.isElementDisplayed(videos, 5, "videos News");
    }

    public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(entertainmentNews, 5, "Entertainment News");
    }

    public boolean checkHamburgerEducationOptionDisplayed() {
        return commonFunctions.isElementDisplayed(education, 5, "Education");
    }

    public boolean checkHamburgerLifeStyleOptionDisplayed() {
        return commonFunctions.isElementDisplayed(lifeStyle, 5, "LifeStyle");
    }

    public boolean checkHamburgerPodcastsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(podcasts, 5, "Podcasts");
    }

    public boolean checkHamburgerSportsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(sports, 5, "Sports");
    }

    public boolean checkHamburgerTVNewsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(tvNews, 5, "TV News");
    }

    public boolean checkHamburgerDelhiNewsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(delhiNews, 5, "Delhi News");
    }

    public boolean checkHamburgerMumbaiNewsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(mumbaiNews, 5, "QuickReads");
    }

    public boolean checkHamburgerBusinessNewsOptionDisplayed() {
        return commonFunctions.isElementDisplayed(business, 5, "Business News");
    }

    public boolean checkHamburgerPhotoOptionDisplayed() {
        return commonFunctions.isElementDisplayed(photos, 5, "Photo News");
    }

    public boolean scrollUpInHamburger() {
        boolean isStepTrue = false;
        commonFunctions.scrollTillVisibleText(education, "education option");
        isStepTrue = commonFunctions.isElementDisplayed(delhiNews, 5);
        return isStepTrue;
    }

    public boolean checkRedirectionToHomeSection() {
        boolean isStepTrue = false;
        commonFunctions.scrollTillVisibleText(redirectToHome, "home");
        isStepTrue = commonFunctions.clickElement(redirectToHome, 5, "redirect to home");
        return isStepTrue;
    }

    @Override
    public boolean checkHomePageLoaded(String[] params) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean htLogo = isHtLogoDisplayed();
        boolean topAdv = checkAdDisplayingTopAd();
//        boolean scrollPage =getBottomOfTheHomePage();
//        boolean scrollPage =commonFunctions.scrollTillVisibleText("Opinion","Bottom of the page.");
        boolean scrollPage = scrollTopToBottomInHomePage();
        boolean exploreMenu = clickOnExplorerMenu();
        boolean hamburgerOptions = checkHamburgerMenuAllOptionDisplayed();
        return htLogo && topAdv && scrollPage && exploreMenu && hamburgerOptions;
    }

    public boolean getBottomOfTheHomePage() {
        int i = 0;
        while (!commonFunctions.getElementText(homePageBottomElment, 5).equals("Opinion") && i <= 5) {
            commonFunctions.scrollDownToElement(homePageBottomElment,homeButton);
            i++;
        }
        return commonFunctions.getElementText(homePageBottomElment, 5).equals("Opinion");
    }

    @Override
    public boolean checkTopAdsClickable() {
        return false;
    }

    @Override
    public boolean checkLiveblogPaginationEmbeds(String title) {
        //locator for ads not available
        boolean homePageLoading = checkHomePageLoadedProperly();
        commonFunctions.dummyWait(5);
        title = commonFunctions.getElementText(firstStorySearch, 5);
        boolean clickOnStory = commonFunctions.clickElement(firstStorySearch, 5, "Explore Menu");
        //checkClickOnStory(title);
        //temporary code to click skip as locator is not available
        commonFunctions.clickElementWithCoordinates(645, 508);
        boolean redirectToStoryPage = checkRedirectedToStory(title);
        boolean storyCompletelyLoaded = checkStoryCompletelyLoaded();
        boolean embed = checkEmbedDisplay();
        boolean scrollToBottomOfStory = commonFunctions.scrollToBottomForAndroidNative();
        //scrollTopToBottomOfStory();
        boolean redirectToHome = checkRedirectionToHomePage();
        boolean nextYouMayLike = checkNextStoryAndYouMayAlsoLike();
        commonFunctions.pressAndroidBackKey();

        return homePageLoading && clickOnStory && redirectToStoryPage && storyCompletelyLoaded &&
                scrollToBottomOfStory && embed && redirectToHome && nextYouMayLike;
    }

    public boolean checkHomePageLoadedProperly() {
        return commonFunctions.isElementDisplayed(headerAd, 5, "HomePage Properly Loaded");
    }

    public boolean checkHamburgerMenuAllOptionDisplayed() {
        boolean isHamburgerMenuAllOptionsDisplayed = false;
        try {
            int menuNamesCount = hamburgerMenuOptions.size();
            for (int i = 0; i < menuNamesCount; i++) {
                String menuName = hamburgerMenuOptions.get(i).getText();
                if (!menuName.isEmpty()) {
                    hamburgerMenuOptions.get(i).isDisplayed();
                    commonFunctions.elementToTextDisplayed(menuName);
                    isHamburgerMenuAllOptionsDisplayed = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        commonFunctions.pressAndroidBackKey();
        return isHamburgerMenuAllOptionsDisplayed;
    }

    public boolean scrollDownToPremiumSection() {
        boolean isScrollDownSuccessful = false;
        try {
            commonFunctions.scrollDownToElement(sectionPremium,homeButton);
            return commonFunctions.isElementDisplayed(sectionPremium, 5, "scrollDownToPremiumSection ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollDownSuccessful;
    }

    public boolean checkFirstStoryExclusiveTag() {
        boolean isExclusiveTagDisplayed = false;
        try {
            CommonFunctionsMobile.scrollDown();
            commonFunctions.scrollUpToElementDisplayed(firstStoryPremiumTitle);
            isExclusiveTagDisplayed = commonFunctions.isElementDisplayed(firstStoryExclusiveTag, 5, "firstStoryExclusiveTag ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExclusiveTagDisplayed;
    }

    public boolean checkSecondStoryExclusiveTag() {
        boolean isExclusiveTagDisplayed = false;
        try {
            commonFunctions.scrollUpToElementDisplayed(secondStoryExclusiveTag);
            isExclusiveTagDisplayed = commonFunctions.isElementDisplayed(secondStoryExclusiveTag, 5, "secondStoryExclusiveTag ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExclusiveTagDisplayed;
    }

    public boolean checkFirstStory() {
        boolean isStepTrue = false;
        commonFunctions.scrollUpToElementDisplayed(firstStoryPremiumTitle);
        boolean isFirstStoryTitleDisplayed = commonFunctions.isElementDisplayed(firstStoryPremiumTitle, 5, "firstStoryPremiumTitle");
        String firstStoryTitle = firstStoryPremiumTitle.getText();
        isStepTrue = commonFunctions.clickElement(firstStoryPremiumTitle, 5, "firstStoryPremiumTitle");
        boolean isFirstInLineStoryHeadLinesTxt = commonFunctions.isElementDisplayed(firstStoryPremiumHeadLine, 5, "firstStoryPremiumHeadLine");
        String firstInLineStoryHeadLine = firstStoryPremiumHeadLine.getText();
        if (firstStoryTitle.equals(firstInLineStoryHeadLine)) {
            isStepTrue = true;
        }
        return isStepTrue && isFirstStoryTitleDisplayed && isFirstInLineStoryHeadLinesTxt;
    }

    public boolean checkInLineStoryExclusiveTag() {
        boolean isExclusiveTagDisplayed = false;
        try {
            isExclusiveTagDisplayed = commonFunctions.isElementDisplayed(InLineStoryExclusiveTag, 5, "InLineStoryExclusiveTag");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExclusiveTagDisplayed;
    }


    @Override
    public boolean checkPremiumArtExclusiveTag() {

        boolean homePageLoading = checkHomePageLoadedProperly();
        boolean scrollDownToPremium = scrollDownToPremiumSection();
        boolean exclusiveTagFirstStory = checkFirstStoryExclusiveTag();
        boolean exclusiveTagSecondStory = checkSecondStoryExclusiveTag();
        boolean clickOnFirstStory = checkFirstStory();
        boolean checkExclusiveTag = checkInLineStoryExclusiveTag();
        commonFunctions.pressAndroidBackKey();
        return homePageLoading && scrollDownToPremium && exclusiveTagFirstStory && exclusiveTagSecondStory && clickOnFirstStory && checkExclusiveTag;
    }

    @Override
    public boolean checkHTAutoRedirection() {
        return false;
    }

    @Override
    public boolean checkHomePageLoadingVerification() {
        return false;
    }

    @Override
    public boolean checkLeftPaneDisplayed() {
        return false;
    }

    @Override
    public boolean checkEpaperCta(String[] params) {
        return false;
    }

    @Override
    public boolean checkHomePageItems() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTappingProfile() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        return commonFunctions.getElementText(loginText).contains("Login");
    }

    @Override
    public boolean checkMayBeLaterOptionBehaviour() {
        Utils.logStepInfo("We are looking into the home page of the application");
        return homeButton.isDisplayed();
    }

    @Override
    public boolean checkEmailTextArea() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        Utils.logStepInfo("I Click on Profile tab to open login feature.");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        Utils.logStepInfo("Lookout for Login option and then click on it.");
        commonFunctions.clickElement(loginText, 5, "Login button");
        boolean emailTextAreaDisplay = commonFunctions.getElementText(emailTextArea).contains("Email or Mobile Number");
        commonFunctions.pressAndroidBackKey();
        return emailTextAreaDisplay;
    }

    @Override
    public boolean checkPasswordTextArea() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        Utils.logStepInfo("Lookout for Login option and then click on it.");
        commonFunctions.clickElement(loginText, 5, "Login button");
        commonFunctions.clickElement(emailTextArea, 5, "Email or Mobile Number");
        commonFunctions.sendKey(emailTextArea, "qaautomation@yopmail.com");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.clickElement(loginContinueButton, 5, "Continue Button");
        commonFunctions.clickElement(passwordTextArea, 5, "Password Box");
        boolean isPasswordTextAreaWorking = commonFunctions.sendKeyWithAction("Digital@123", "Password");
        commonFunctions.hideKeyboard();
        commonFunctions.pressAndroidBackKey();

        return isPasswordTextAreaWorking;
    }

    @Override
    public boolean checkHindustanTimesLogoDisplayed() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        boolean isHTLogoDisplayed = commonFunctions.isElementDisplayed(htLogo, 5, "Hindustan Times Logo");
        return isHTLogoDisplayed;
    }

    @Override
    public boolean checkRedirectionOnTappingExplore() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        commonFunctions.clickElement(exploreMenu, 5, "Explore Button");
        return commonFunctions.isElementDisplayed(popularSectionPage, 5, "Popular section page of Explore page");
    }

    @Override
    public boolean checkEpaperAndSearchDisplayed() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        commonFunctions.dummyWait(5);
        boolean isEpaperDisplayed = commonFunctions.isElementDisplayed(epaperButton, 5, "Hindustan Times Epaper");
        boolean isSearchDisplayed = commonFunctions.clickElement(searchField, 5, "Search Button");
        return isEpaperDisplayed && isSearchDisplayed;
    }

    @Override
    public boolean checkHomeTabHeader() {
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        commonFunctions.dummyWait(5);
        boolean isHtLogoDisplayed = commonFunctions.isElementDisplayed(htLogo, 5, "Hindustan Times Logo");
        boolean isEpaperDisplayed = commonFunctions.isElementDisplayed(epaperButton, 5, "Hindustan Times Epaper");
        boolean isSearchDisplayed = commonFunctions.isElementDisplayed(searchField, 5, "Search Button");
        boolean isHeaderDisplayed = commonFunctions.isElementDisplayedOfListOfElements(hometabHeader, "HomeTab Section Name Header");
        return isHtLogoDisplayed && isEpaperDisplayed && isSearchDisplayed && isHeaderDisplayed;
    }

    @Override
    public boolean checkRedirectionOnVideoFromExplore() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        commonFunctions.clickElement(videoSection, 5, "Video section in Explore page");
        boolean checkSection = commonFunctions.getElementText(sectionPageHeader, 10).equalsIgnoreCase("Videos");
        commonFunctions.pressAndroidBackKey();

        return checkSection;
    }

    @Override
    public boolean checkRedirectionOnPhotosFromExplore() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        commonFunctions.scrollDownToElement(photosSection,homeButton);
        commonFunctions.clickElement(photosSection, 5, "Photos section in Explore page");
        return commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("Photos");
    }

    @Override
    public boolean checkSectionHomeIsHighlightedInBottomNav() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 5, "HT home page Top News Section");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        Utils.logStepInfo("Tap on any section (eg. India section)");
        commonFunctions.clickElement(indiaNews, 5, "India news on Home page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(homeButton, 5, "HT home button");

        return isTopNewsSelected && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkSectionIndiaHighlit() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 5, "HT home page Top News Section");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        Utils.logStepInfo("Tap on any section (eg. India section)");
        commonFunctions.clickElement(indiaNews, 5, "India news on Home page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(indiaNews, 5, "HT home button");

        return isTopNewsSelected && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkGetPersonalizedExperiencePageNotDisplay() {
        Utils.logStepInfo("Looking for Get Personalized Experience page should not display.");
        return !commonFunctions.isElementDisplayed(continueButton, 5, "Continue button at Get personalized Experience page");
    }

    @Override
    public boolean checkAllBottomNavDisplay() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 5, "HT home page Top News Section");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        boolean isAllNavButtonDisplay = commonFunctions.isElementDisplayed(homeButton, 5, "HT home module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(quickReadsMenu, 5, "Quickreads module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(exploreMenu, 5, "Explore module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(profileButton, 5, "Profile module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(premiumMenu, 5, "Premium module");
        return isTopNewsSelected && isHTHomeButtonSelected && isAllNavButtonDisplay;
    }

    @Override
    public boolean checkTapOnSectionSubsectionRedirectToSectionPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 5, "HT home page Top News Section");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        boolean isFirstAdDisplay = commonFunctions.isElementDisplayed(firstAd, 5, "First advertisement of the page");
        boolean isAllHeadlineDisplay = isAllElementDisplay(storyHeadlines);
        Utils.logStepInfo("Click of India section page");
        commonFunctions.clickElement(indiaSection, 5, "India section on Home page");
        boolean isIndiaSectionPageSelected = commonFunctions.isElementSelected(indiaSection, 5, "India section on Home page");
        boolean isAllStoryBelongsToSameSectionPage = checkMobileElementsDisplayWithText(storySectionName, "INDIA");
        return isTopNewsSelected && isHTHomeButtonSelected || isFirstAdDisplay && isAllHeadlineDisplay && isIndiaSectionPageSelected && isAllStoryBelongsToSameSectionPage;
    }

    @Override
    public boolean checkQuickReadsFunctionality() {
        return false;
    }

    @Override
    public boolean checkDontMissOption() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.scrollDownSlowToElement(dontMissCarousel,6);
        boolean isDontMiss = commonFunctions.isElementDisplayed(dontMissCarousel,5,"Don't Miss");
        return isDontMiss;
    }

    @Override
    public boolean checkCricketSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.scrollDownToElement(cricketCarousel,homeButton,20);
        boolean isSecondAdBeforeCriket = commonFunctions.isElementDisplayed(secondAdAfterFiveStories,5,"Second Ad");
        isSecondAdBeforeCriket &= commonFunctions.isElementDisplayed(cricketCarousel,5,"Cricket");
        return isSecondAdBeforeCriket;
    }

    @Override
    public boolean checkPhotosSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.scrollDownToElement(photosSection,home,30);
        Boolean isPhotosSectionDisplayed = commonFunctions.isElementDisplayed(photosSection,5,"Photos Section");
        return isPhotosSectionDisplayed;
    }

    @Override
    public boolean checkWebStoriesSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(quickReads,5,"QuickRead option");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.scrollDownToElement(webStoriesSection,homeButton,30);
        Boolean isWebStoriesDisplayed = commonFunctions.isElementDisplayed(webStoriesSection,5,"Web Stories Section");
        return isWebStoriesDisplayed;
    }

    @Override
    public boolean check3DotMsgBoxDisplayed() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(threeDotButton.get(0),5,"Three Dots in First Story");
        boolean is3DotMsgBox = commonFunctions.isElementDisplayed(threeDotMsgBox,5,"3 Dot Msg Box");
        boolean isBookMarkOption = commonFunctions.isElementDisplayed(bookMarkOption,5,"BookMarkOption");
        boolean isCancelOption = commonFunctions.isElementDisplayed(cancelBtn,5,"Cancel Btn");
        return is3DotMsgBox& isBookMarkOption && isCancelOption;
    }

    @Override
    public boolean checkMostReadSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(quickReads,5,"QuickRead Option");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        boolean isMostReadDisplayed = commonFunctions.scrollDownToElement(mostReadSection,homeButton,25);
        isMostReadDisplayed &= commonFunctions.isElementDisplayed(mostReadSection,5,"Most Read Section");
        return isMostReadDisplayed;
    }

    @Override
    public boolean checkSubscribeToNewsletterBehaviour() {
        return false;
    }

    @Override
    public boolean checkShareOption() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(threeDotButton.get(0),5,"Three Dots in First Story");
        boolean is3DotMsgBox = commonFunctions.isElementDisplayed(threeDotMsgBox,5,"3 Dot Msg Box");
        boolean isBookMarkOption = commonFunctions.isElementDisplayed(shareOption,5,"Share Option");
        commonFunctions.clickElement(shareOption,5,"Share Option");
        return is3DotMsgBox && isBookMarkOption;
    }

    @Override
    public boolean checkQuickReadHaveOneStoryAtATime() {
        boolean isUserRedirectedToQuickReadPageTrue = checkQuickReadsRedirection();
        boolean isQuickReadHaveOnlyOnStoryAtATimeTrue = sizeOfElementList(firstStoryInQuickRead, expecteElementListSizeInQuickRead);

        return isQuickReadHaveOnlyOnStoryAtATimeTrue && isUserRedirectedToQuickReadPageTrue;
    }

    @Override
    public boolean checkQuickReadFirstAndSecondWithSwipe() {
        boolean isUserRedirectedToQuickReadPageTrue = checkQuickReadsRedirection();
        String firstStoryTitleOfQuickRead = commonFunctions.getElementText(firstStoryInQuickRead.get(0), 5);
        scrollDownTillStoryIsNotChangedInQuickRead(firstStoryTitleOfQuickRead, firstStoryInQuickRead.get(0));
        String secondStoryTitleOfQuickRead = commonFunctions.getElementText(firstStoryInQuickRead.get(0), 5);
        Utils.logStepInfo(true, String.format("%s scroll-down to second to story with title is done.", secondStoryTitleOfQuickRead));
        boolean isScrollUpToGoBackToFirstStory = commonFunctions.scrollTillVisibleText(firstStoryTitleOfQuickRead, firstStoryTitleOfQuickRead);
        return isUserRedirectedToQuickReadPageTrue && isScrollUpToGoBackToFirstStory;
    }

    @Override
    public boolean checkQuickReadReadFullStoryRedirection() {
        boolean isUserRedirectedToQuickReadPageTrue = checkQuickReadsRedirection();
        String firstStoryTitleOfQuickRead = commonFunctions.getElementText(firstStoryInQuickRead.get(0), 5);
        commonFunctions.clickElement(readFullStoryBtnQuickRead, 5, firstStoryTitleOfQuickRead + " page Read full story button");
        commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        String headlineTitle = commonFunctions.getElementText(headLine, 5);
        boolean isReaduFullStoryTrue = commonFunctions.compareTexts(firstStoryTitleOfQuickRead, headlineTitle);
        Utils.logStepInfo(true,"isUserRedirectedToQuickReadPageTrue = "+isUserRedirectedToQuickReadPageTrue);
        Utils.logStepInfo(true,"isReaduFullStoryTrue = "+isReaduFullStoryTrue);
        return isUserRedirectedToQuickReadPageTrue && isReaduFullStoryTrue;
    }

    @Override
    public boolean checkFirstAdAfter4StoriesInQuickReadPage() {
        boolean isUserRedirectedToQuickReadPageTrue = checkQuickReadsRedirection();
        return getScrollCountTillFirstAdVisible(firstStoryInQuickRead.get(0)) == 4 && isUserRedirectedToQuickReadPageTrue;
    }

    @Override
    public boolean checkViewAllLinkRightToQuickread() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean isQuickreadsOptionDisplayTrue = scrollDownToElementFromList(quickReadsForCrousl);
        commonFunctions.clickElement(viewAllButtons.get(0), 5, "View all button for Quickreads");
        boolean redirectedToQuickreadsPage = commonFunctions.isElementDisplayed(readFullStoryBtnQuickRead, 5, "Read Full story button on quickreads story page");
        boolean quickreadsIsSelectedInBottomNav = commonFunctions.isElementSelected(quickReadsMenu, 5, "Quickreads highlighted below");
        return isQuickreadsOptionDisplayTrue && redirectedToQuickreadsPage && quickreadsIsSelectedInBottomNav;
    }

    public boolean scrollDownToElementFromList(List<MobileElement> elementList)
    {
        int count = 0;
        boolean isElementDisplayTrue=false;
        while(!(elementList.size() ==2))
        {
            commonFunctions.scrollDownToElement(elementList.get(0),bookMark);
            if (count<4) {
                commonFunctions.toGetRidOfAd(bookMark, 5);
                commonFunctions.clickElementIfDisplayed(backButton, 2, "Back Button");
            }
            isElementDisplayTrue=elementList.size()==2;
            count++;
            System.out.println(count + " times Scroll down for element");
            if(count > 25){
                Utils.logStepInfo(false,"Unable to found element after Scrolling so many times");
                break;
            }
        }
        return isElementDisplayTrue;
    }

    @Override
    public boolean checkQuickreadsReadFullStoryRedirectionForBackpress() {
        boolean isFullStoryRedirectionTrue = checkQuickReadReadFullStoryRedirection();
        commonFunctions.pressAndroidBackKey();
        boolean isRedirectionToQuickReadsTrue = commonFunctions.isElementDisplayed(readFullStoryBtnQuickRead, 5, "Read Full story button on quickreads page");
        return isFullStoryRedirectionTrue && isRedirectionToQuickReadsTrue;
    }

    @Override
    public boolean checkShareOptionInQuickRead() {
        return false;
    }

    @Override
    public boolean checkTappingOnViewAllOnLatestVideoCarousel() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.scrollDownToElement(latestVideosCarousel,homeButton);
        boolean islatestVideos  = commonFunctions.isElementDisplayed(commonFunctions.toGetMobileElementByVisibilityText("Latest Videos"), 5, "Latest Videos Carousel");
        islatestVideos &= commonFunctions.isElementDisplayed(viewAllInCarouselOption("Latest Videos"),5,"View ALL in Latest Videos Carousel");
        if(islatestVideos){
            commonFunctions.clickElement(viewAllInCarouselOption("Latest Videos"),5,"View ALL QuickRead click");
            islatestVideos &= commonFunctions.isElementDisplayed(firstStorySearch,5,"Latest Videos Section opened");
        }
        return  islatestVideos;
    }

    @Override
    public boolean checkAppearanceOfLatestVideoCarousel() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.scrollDownToElement(latestVideosCarousel,homeButton);
        boolean islatestVideosAppeared  = commonFunctions.isElementDisplayed(commonFunctions.toGetMobileElementByVisibilityText("Latest Videos"), 5, "Latest Videos Carousel");
        return islatestVideosAppeared;
    }

    @Override
    public boolean checkAdAfterDontMissSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.scrollDownSlowToElement(dontMissCarousel,10);
        boolean isDontMiss = commonFunctions.isElementDisplayed(dontMissCarousel,5,"Don't Miss");
        commonFunctions.scrollDownSlowToElement(adAfterDontMissSection,4);
        boolean isadAtEndOfDontMiss = commonFunctions.isElementDisplayed(adAfterDontMissSection,5,"Ad at end of Don't Miss");
        return  isDontMiss && isadAtEndOfDontMiss;
    }

    @Override
    public boolean checkRedirectToRespectiveStory() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(quickReads,5,"QuickRead");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        String firstStory = firstStorySearch.getText();
        System.out.println("First Story Heading is --- " + firstStory);
        commonFunctions.clickElement(clickFirstStory, 5, "Click First Story");
        commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isStoryTitle = commonFunctions.getElementText(headLine, 10).equalsIgnoreCase(firstStory);
        return isStoryTitle;
    }

    @Override
    public boolean checkRedirectToStoryFromLatestVideoCarousel() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.scrollDownToElement(latestVideosCarousel,homeButton);
        boolean islatestVideosAppeared  = commonFunctions.isElementDisplayed(commonFunctions.toGetMobileElementByVisibilityText("Latest Videos"), 5, "Latest Videos Carousel");
        boolean isStoryDiaplyedInLatestVideos = commonFunctions.isElementDisplayed(firstStory.get(0),5,"Story in Latest Videos");
        String latestVideosStoryTxt = firstStory.get(0).getText();
        if(isStoryDiaplyedInLatestVideos){
            commonFunctions.clickElement(firstStory.get(0),5,"Story In Latest Videos");
        }
        else{
            commonFunctions.scrollDownSlowToElement(firstStory.get(0),2);
            commonFunctions.clickElement(firstStory.get(0),5,"Story In Latest Videos");
        }
        commonFunctions.clickElementIfDisplayed(skipButton,5,"Skip");
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isStoryPageOpen = commonFunctions.getElementText(headLine,5).equalsIgnoreCase(latestVideosStoryTxt);
        commonFunctions.clickElementIfDisplayed(backButton,5,"Back to Home page");
        commonFunctions.scrollDownSlowToElement(latestVideosCarousel,2);
        islatestVideosAppeared &= commonFunctions.isElementDisplayed(latestVideosCarousel, 5, "Latest Videos Carousel");
        return islatestVideosAppeared  && isStoryDiaplyedInLatestVideos && isStoryPageOpen;
    }

    @Override
    public boolean checkRedirectToStoryFromPhotoCarousel() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.scrollDownToElement(photosSection,homeButton,30);
        /*if(!commonFunctions.isElementDisplayed(photosSection,5,"Photos Section")){
            commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
            commonFunctions.clickElementIfDisplayed(backButton,5,"Back");
            commonFunctions.scrollToTopForAndroidNative();
            commonFunctions.scrollDownToElement(photosSection,homeButton);
        }*/
        boolean isPhotosAppeared  = commonFunctions.isElementDisplayed(photosSection, 5, "Photos Carousel");
        //commonFunctions.scrollDownSlowToElement(firstStorySearch,2);
        boolean isStoryDiaplyedInPhotos = commonFunctions.isElementDisplayed(firstStorySearch,5,"Story in Photos");
        String photosStoryTxt = null;
        if (!isStoryDiaplyedInPhotos) {
            commonFunctions.scrollDownSlowToElement(clickFirstStory, 2);

        }
        photosStoryTxt = firstStorySearch.getText();
        System.out.println("Story text is *** ---  "+photosStoryTxt);
        commonFunctions.clickElement(clickFirstStory,5,"First Story in Photos Section");
        if(!commonFunctions.isElementDisplayed(headLineInSearch,5,"Story Open")){
            commonFunctions.toGetRidOfAd(home,5);
        }
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isStoryPageOpen = commonFunctions.getElementText(headLineInSearch,5).equalsIgnoreCase(photosStoryTxt);
        return isPhotosAppeared && isStoryDiaplyedInPhotos && isStoryPageOpen;
    }

    @Override
    public boolean checkRedirectToStoryFromWebStoriesCarousel() {
        boolean isWebStoriesSection  = checkWebStoriesSection();
        boolean isStoryDiaplyedInPhotos = commonFunctions.isElementDisplayed(allStoriesInWebStories.get(0),5,"Story in Web Stories");
        if(isStoryDiaplyedInPhotos){
            commonFunctions.clickElement(allStoriesInWebStories.get(0),5,"First Story in Web Stories Section");
        }
        else{
            commonFunctions.scrollDownSlowToElement(allStoriesInWebStories.get(0),2);
            commonFunctions.clickElement(allStoriesInWebStories.get(0),5,"First Story in Web Stories Section");

        }
        if(!commonFunctions.isElementDisplayed(headingInOpenWebStories,5,"Story Open")){
            commonFunctions.toGetRidOfAd(home,5);
        }
        boolean isHtLogoInWebStory = commonFunctions.isElementDisplayed(htLogoInWebStory,5,"HT Logo in Web Story");
        //boolean isStoryPageOpen = commonFunctions.isElementDisplayed(headingInOpenWebStories,5,"Open Web Story Title");
        return isWebStoriesSection && isStoryDiaplyedInPhotos /*&& isStoryPageOpen */&& isHtLogoInWebStory;
    }

    @Override
    public boolean checkViewAllFromWebStoriesCarousel() {
        boolean isWebStoriesSection  = checkWebStoriesSection();
        boolean isViewAllOptionInWebStory = commonFunctions.isElementDisplayed(viewAllInCarouselOption("Web Stories"),5,"View ALL in Web Stories");
        if(isViewAllOptionInWebStory){
            commonFunctions.clickElement(viewAllInCarouselOption("Web Stories"),5,"View All in Web Stories");
        }
        boolean isHtLogosInWebStories = commonFunctions.compareWithSizeListOfElements(htLogosInWebStoriesPage,1,"HT logos in Web Stories Page");
        boolean isWebStoriesDisplayed = commonFunctions.compareWithSizeListOfElements(threeDotInAllWebStories,1,"Stories in Web Stories Section");
        return isWebStoriesSection && isViewAllOptionInWebStory && isHtLogosInWebStories && isWebStoriesDisplayed;
    }

    @Override
    public boolean checkQuickReadsCraouselDisplayedOnHome() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isQuickreadsOptionDisplayTrue = scrollDownToElementFromList(quickReadsForCrousl);
        isQuickreadsOptionDisplayTrue &= commonFunctions.isElementDisplayed(quickReadsCraousel,5,"QuickReads Craousel");
        return isQuickreadsOptionDisplayTrue;
    }

    @Override
    public boolean checkRedirectToStoryFromQuickReadsCraousel() {
        boolean isQuickReadDisplayed = checkQuickReadsCraouselDisplayedOnHome();
        boolean isStoryDiaplyedInQuikRead = commonFunctions.isElementDisplayed(storyListInQuickReads.get(0),5,"Story in Web Stories");
        if(isStoryDiaplyedInQuikRead){

            commonFunctions.clickElement(storyListInQuickReads.get(0),5,"First Story in QuickReads Section");
        }
        else{
            commonFunctions.scrollDownSlowToElement(storyListInQuickReads.get(0),2);
            commonFunctions.clickElement(storyListInQuickReads.get(0),5,"First Story in QuickReads Section");
        }
        if(!commonFunctions.isElementDisplayed(headLine,5,"Story headline")){
            commonFunctions.toGetRidOfAd(home,5);
        }
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isStoryPageOpen = commonFunctions.isElementDisplayed(headLine,5,"Quick Read Story HeadLine");
        return isQuickReadDisplayed && isStoryDiaplyedInQuikRead && isStoryPageOpen;
    }

    @Override
    public boolean checkNewslettersCarouselDisplayed() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.scrollDownToElement(newsLettersCarousel,home,20);
        boolean isNewsLettersDisplayed = commonFunctions.isElementDisplayed(newsLettersCarousel,5,"Newsletters Carousel");
        return isNewsLettersDisplayed;
    }

    @Override
    public boolean checkScrollrightToLeftAndLeftToRightOnNewsletters() {
        boolean isNewsLettersCardDisplayed = checkSecondCardIsHTEDCallingOnNewsletters();
        int firstElement[] = commonFunctions.getElementXYCoordinate(dailyNewsCapsuleOption);
        int secondElement[] = commonFunctions.getElementXYCoordinate(ht_EdCallingOption);
        commonFunctions.swipeElementUsingTouchAction(secondElement[0],secondElement[1],firstElement[0],firstElement[1]);
        commonFunctions.dummyWait(5);
        boolean isThirdCardDisplayedAfterScrolling = commonFunctions.isElementDisplayed(htWkndCardOption,5, "3rd card HT Wknd");
        if (isThirdCardDisplayedAfterScrolling){
            int thirdElement[] = commonFunctions.getElementXYCoordinate(htWkndCardOption);
            commonFunctions.swipeElementUsingTouchAction(secondElement[0],secondElement[1],thirdElement[0],thirdElement[1]);
        }
        boolean isFirstCardDisplayedAfterScrolling = commonFunctions.isElementDisplayed(htWkndCardOption,5,"1st card Daily News Capsule");
        return isNewsLettersCardDisplayed && isThirdCardDisplayedAfterScrolling && isFirstCardDisplayedAfterScrolling;
    }

    @Override
    public boolean checkFirstCardIsDailyNewsCapsuleOnNewsletters() {
        boolean isScrollToNewsLetters = checkNewslettersCarouselDisplayed();
        boolean isDisplayedFirstyCard = false;
        if (commonFunctions.isElementDisplayed(dailyNewsCapsuleOption,5,"Daily News Capsule Option")){
            isDisplayedFirstyCard = true;
        }
        else{
            commonFunctions.scrollDownSlowToElement(dailyNewsCapsuleOption,2);
        }
        isDisplayedFirstyCard = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption,5,"Daily News Capsule Option");
        return isScrollToNewsLetters && isDisplayedFirstyCard;
    }

    @Override
    public boolean checkSecondCardIsHTEDCallingOnNewsletters() {
        boolean isScrollToNewsLetters = checkNewslettersCarouselDisplayed();
        boolean isDisplayedSecondCard = false;
        if (commonFunctions.isElementDisplayed(ht_EdCallingOption,5,"@HT_Ed Calling")){
            isDisplayedSecondCard = true;
        }
        else{
            commonFunctions.scrollDownSlowToElement(ht_EdCallingOption,2);
        }
         isDisplayedSecondCard = commonFunctions.isElementDisplayed(ht_EdCallingOption,5,"@HT_Ed Calling");
        return  isScrollToNewsLetters && isDisplayedSecondCard;
    }

    @Override
    public boolean checkRedirectionWhenTabOnReadNowOnNewsletters() {
        boolean isFirstCardInNewsLetter = checkFirstCardIsDailyNewsCapsuleOnNewsletters();
        commonFunctions.clickOnReadNowInNewsLetter(readNowInNewsLetter,0);
        boolean isFirstCardPageOpen = commonFunctions.getElementText(sectionPageHeader,5).equalsIgnoreCase("DAILY NEWS CAPSULE");
        return isFirstCardInNewsLetter && isFirstCardPageOpen;
    }


    public boolean scrollDownTillStoryIsNotChangedInQuickRead(String text, MobileElement ele) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            while (!commonFunctions.getElementText(ele, 5).contains(text)) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public int getScrollCountTillFirstAdVisible(MobileElement ele) {
        int countOfStory = 0;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            while (!commonFunctions.isElementDisplayed(firstAd, 5, "First ad on the page")) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                countOfStory++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countOfStory;
    }

    public boolean sizeOfElementList(List<MobileElement> elementList, int expectedSizeOfTheList) {
        for (MobileElement ele : elementList) {
            if (elementList.size() == 1 && commonFunctions.isElementDisplayed(ele, 5, commonFunctions.getElementText(ele, 5)))
                return true;
        }
        return false;
    }

    public boolean checkMobileElementsDisplayWithText(List<MobileElement> elementList, String text) {
        boolean isMobileElementsDisplayWithTextTrue = false;
        String actualText = null;
        try {
            for (MobileElement ele : elementList) {
                actualText = commonFunctions.getElementText(ele, 5);
                if (actualText.contains(text)) {
                    isMobileElementsDisplayWithTextTrue = true;
                }
            }
        } catch (Exception e) {
            isMobileElementsDisplayWithTextTrue = false;
        }
        return isMobileElementsDisplayWithTextTrue;

    }

    public boolean isAllElementDisplay(List<MobileElement> elementList) {
        boolean isAllElementDisplayTrue = false;
        try {
            for (MobileElement ele : elementList) {
                boolean isElementDisplay = commonFunctions.isElementDisplayed(ele, 5, "Headline of the story display");
                boolean isNotEmppty = commonFunctions.getElementText(ele, 5).isEmpty();
                if (isElementDisplay && isNotEmppty == false) {
                    isAllElementDisplayTrue = true;
                }
            }
        } catch (Exception e) {
            isAllElementDisplayTrue = false;
        }
        return isAllElementDisplayTrue;
    }

    @Override
    public boolean checkTrendingTopicsCarousel() {
        return false;
    }

    @Override
    public boolean checkQuickReadsRedirection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(quickReadsMenu, 5, "Quick reads page");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(quickReads, 5, "Quick reads button");
        Utils.logStepInfo(true,"isRedirectionTrue = "+isRedirectionTrue);
        Utils.logStepInfo(true,"isHTHomeButtonSelected = "+isHTHomeButtonSelected);
        return isRedirectionTrue && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkPremiumRedirection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        Utils.logStepInfo("Tap on Premium");
        commonFunctions.clickElement(premiumMenu, 5, "Quick reads on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(premiumPage, 5, "Premium page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(premiumMenu, 5, "Premium button");
        return isRedirectionTrue && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkProfileRedirection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.toGetProfileButtonVisibleAndClick(profileButton,5);
        boolean isProfileTabDisplayed = commonFunctions.getElementText(sectionPageHeader,5).equalsIgnoreCase("PROFILE");
        return isProfileTabDisplayed;
    }

    @Override
    public boolean checkExploreRedirection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 5, "HT home page Top News Section");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        Utils.logStepInfo("Tap on Explore");
        commonFunctions.clickElement(exploreMenu, 5, "Explore on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(popularSectionPage, 5, "Explore page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(exploreMenu, 5, "Explore button");
        return isRedirectionTrue && isHTHomeButtonSelected && isTopNewsSelected;
    }
    @Override
    public boolean checkNewsletterScroll(MobileElement ele) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(quickReads,5,"Explore Button");
        commonFunctions.dummyWait(5);
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean isScrollTillElement = commonFunctions.scrollDownToElement(ele,homeButton,25);
        Utils.logStepInfo(true,"isScrollTillElement = "+isScrollTillElement);
        return isScrollTillElement;
    }

    @Override
    public boolean checkEmailIdPrefilled(String email) {
        boolean emailIdPrefilled= commonFunctions.getElementTextAndCheckWithContains(emailPrefilledOption,email,5,"EmailID prefilled");
        Utils.logStepInfo(true,"emailIdPrefilled = "+emailIdPrefilled);
        return emailIdPrefilled;
    }
    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnDailyNewsCapsule() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean isHTHomePageHighlighted = checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        if(isDailyNewsCapsuleDisplayed && commonFunctions.getElementText(dailyNewsCapsuleSubscribeButton,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Daily news Unsubscribed");
        }
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Daily news subscribe button");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isRegisterNowDisplayed = "+isRegisterNowDisplayed);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnDailyNewsCapsule(String emailId) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        if(isDailyNewsCapsuleDisplayed && commonFunctions.getElementText(dailyNewsCapsuleSubscribeButton,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Daily news Unsubscribed");
        }
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Daily news subscribe button");
        System.out.println("Email id - "+emailId);
        commonFunctions.sendKeyBoolean(emailPrefilledOption,emailId);
        boolean isEmailIdPrefilled =checkEmailIdPrefilled(emailId);
        boolean isDailyNewsCapsuleSubscribedSuccessfully = checkSubscribeSuccessfully(dailyNewsCapsuleSubscribeButton);
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isEmailIdPrefilled = "+isEmailIdPrefilled);
        Utils.logStepInfo(true,"isDailyNewsCapsuleSubscribedSuccessfully = "+isDailyNewsCapsuleSubscribedSuccessfully);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isEmailIdPrefilled || isDailyNewsCapsuleSubscribedSuccessfully;
    }
    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTEdCalling() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isHT_EdCallingDisplayed = commonFunctions.isElementDisplayed(ht_EdCallingOption, 5, "@HT_Ed Calling ");
        commonFunctions.clickElement(ht_EdCallingOptionSubscribeButton, 5 ,"@Ht_Ed Calling Subscribe Button");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        return isHTHomePageHighlighted && isHT_EdCallingDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTEdCalling(String email){
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isHT_EdCallingDisplayed = commonFunctions.isElementDisplayed(ht_EdCallingOption, 5, "@HT_Ed Calling ");
        if(isHT_EdCallingDisplayed && commonFunctions.getElementText(ht_EdCallingOptionSubscribeButton,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(ht_EdCallingOptionSubscribeButton, 5, "Daily news Unsubscribed");
        }
        commonFunctions.clickElementIfDisplayed(ht_EdCallingOptionSubscribeButton, 5 ,"@Ht_Ed Calling Subscribe Button");
        boolean isEmailIdPrefilled =checkEmailIdPrefilled(email);
        boolean isHT_EdCallingSubscribedSuccessfully = checkSubscribeSuccessfully();
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isHT_EdCallingDisplayed = "+isHT_EdCallingDisplayed);
        Utils.logStepInfo(true,"isEmailIdPrefilled = "+isEmailIdPrefilled);
        Utils.logStepInfo(true,"isHT_EdCallingSubscribedSuccessfully = "+isHT_EdCallingSubscribedSuccessfully);

        return isHTHomePageHighlighted && isHT_EdCallingDisplayed && isEmailIdPrefilled || isHT_EdCallingSubscribedSuccessfully;
    }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTWknd() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        commonFunctions.swipeElementUsingTouchAction(707,269,ht_EdCallingOption,2,htWkndSubscribeButton);
        boolean isHTWkndDisplayed = commonFunctions.isElementDisplayed(htWkndOption, 5, "HT Wknd");
        commonFunctions.clickElement(htWkndSubscribeButton, 5 ,"HT Wknd Subscribe Button");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isHTWkndDisplayed = "+isHTWkndDisplayed);
        Utils.logStepInfo(true,"isRegisterNowDisplayed = "+isRegisterNowDisplayed);
        return isHTHomePageHighlighted && isHTWkndDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTWknd(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(htWkndSubscribeButton);
        commonFunctions.swipeElementAndroid(dailyNewsCapsuleSubscribeButton,Direction.LEFT);
        boolean isHTWkndDisplayed = commonFunctions.isElementDisplayed(htWkndOption, 5, "HT Wknd");
        commonFunctions.clickElement(htWkndSubscribeButton, 5 ,"HT Wknd Subscribe Button");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        boolean isHTWkndSubscribedSuccessfully = checkSubscribeSuccessfully();
        return isHTHomePageHighlighted && isHTWkndDisplayed && isEmailIdPrefilled || isHTWkndSubscribedSuccessfully;
    }


    public MobileElement carouselOption(String carouselToElement){

        return (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeOther[@name='"+carouselToElement+"']"));
    }

    public MobileElement viewAllInCarouselOption(String viewAllOption){

        return (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text = '"+viewAllOption+"']/following-sibling::android.widget.TextView"));
    }

    @Override
    public boolean checkEPaperOptionFromHeader() {
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(ePaperButtonOnHeader, 10, "E-paper on top");
        commonFunctions.clickElementIfDisplayed(chromeOption, 5, "Select chrome option for web");
        commonFunctions.clickElementIfDisplayed(onceOptionWeb, 5, "Select once option for web");
        //boolean isEpaperWebOpened = commonFunctions.isElementDisplayed(epaperWebUrlBox, 5, "Epaper Url box");
        boolean isEpaperWebOpened = epaperWebUrlBox.isDisplayed();
        commonFunctions.pressAndroidBackKey();
        return isEpaperWebOpened;
    }

    @Override
    public boolean checkEPaperOptionFromQuickReadHeader() {
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElementIfDisplayed(quickreadsButton,10,"QuickRead from Bottom Nav");
        commonFunctions.clickElement(ePaperButtonOnHeader, 10, "E-paper on top");
        commonFunctions.clickElementIfDisplayed(chromeOption, 5, "Select chrome option for web");
        commonFunctions.clickElementIfDisplayed(onceOptionWeb, 5, "Select once option for web");
        //boolean isEpaperWebOpened = commonFunctions.isElementDisplayed(epaperWebUrlBox, 5, "Epaper Url box");
        boolean isEpaperWebOpened = epaperWebUrlBox.isDisplayed();
        commonFunctions.pressAndroidBackKey();
        return isEpaperWebOpened;
    }

    @Override
    public boolean checkRegisterNowButton() {
        boolean isElementDisplay = commonFunctions.isElementDisplayed(registerNowButton,5,"Register now");
        commonFunctions.clickElement(registerNowCancelButton,5,"Register now close button");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        return isElementDisplay;
    }


    public boolean checkSubscribeSuccessfully() {
        commonFunctions.clickElement(subsribeNowButton,5,"Subscribe now");
        boolean isSubscribeMessageChecked = false;
        String pageSource = driver.getPageSource();
        Utils.logStepInfo(true,"Page Source - " + pageSource);
        try {
            isSubscribeMessageChecked= commonFunctions.getElementTextAndCheckWithContains(newsletterSubscribepopup,"Newsletter subscribed successfully",5,"Newsletter subscribed successfully");
        }
        catch(org.openqa.selenium.StaleElementReferenceException e){
            isSubscribeMessageChecked = pageSource.contains("Newsletter subscribed successfully");
            Utils.logStepInfo(true,"Pop up Element details is no more in DOM so verify in pop up message in page Source ---- "+e.getClass());
        }
        catch(Exception exception){
            isSubscribeMessageChecked = pageSource.contains("Newsletter subscribed successfully");
            Utils.logStepInfo(isSubscribeMessageChecked, "Getting error --- "+ exception.getMessage().getClass());
        }
        Utils.logStepInfo(true, "isSubscribeMessageChecked = "+isSubscribeMessageChecked);
        return isSubscribeMessageChecked;
    }
    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTWeekAhead() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel,htWeekAheadSubscribeButton,"HT Week Ahead");
        boolean isHTWeekAheadDisplayed = commonFunctions.clickElementIfDisplayed(htWeekAheadSubscribeButton, 5, "HT Week Ahead");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTWeekAheadDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTWeekAhead(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped =commonFunctions.swipeElementToLeftByList(newsLetterCarousel,htWeekAheadSubscribeButton,"HT Week Ahead");
        boolean isHTWeekAheadDisplayed = commonFunctions.clickElementIfDisplayed(htWeekAheadSubscribeButton, 5, "HT Week Ahead");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        boolean isHTWeekAheadSubscribedSuccessfully = checkSubscribeSuccessfully();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTWeekAheadDisplayed && isEmailIdPrefilled && isHTWeekAheadSubscribedSuccessfully;
    }
    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTCapitalLetters() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel,htCapitalLettersSubscribeButton,"HT Capital Letters");
        boolean isHTCapitalLettersDisplayed =commonFunctions.clickElementIfDisplayed(htCapitalLettersSubscribeButton,5,"HT Capitals Letters");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTCapitalLettersDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTCapitalLetters(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel,htCapitalLettersSubscribeButton,"HT Capital Letters");
        boolean isHTCapitalLettersDisplayed =commonFunctions.clickElementIfDisplayed(htCapitalLettersSubscribeButton,5,"HT Capitals Letters");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        boolean isHTCapitalLettersSubscribedSuccessfully = checkSubscribeSuccessfully();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTCapitalLettersDisplayed && isEmailIdPrefilled && isHTCapitalLettersSubscribedSuccessfully;
    }
    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnWiredWisdom() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel,wiredWisdomSubscribeButton,"Wired Wisdom");
        boolean isWiredWisdomDisplayed =commonFunctions.clickElementIfDisplayed(wiredWisdomSubscribeButton,5,"Wired Wisdom");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isWiredWisdomDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnWiredWisdom(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel,wiredWisdomSubscribeButton,"Wired Wisdom");
        boolean isWiredWisdomDisplayed =commonFunctions.clickElementIfDisplayed(wiredWisdomSubscribeButton,5,"Wired Wisdom");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        boolean isWiredWisdomSubscribedSuccessfully = checkSubscribeSuccessfully();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isWiredWisdomDisplayed && isEmailIdPrefilled && isWiredWisdomSubscribedSuccessfully;
    }
    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTCity() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel,htCitySubscribeButton,"HT City");
        boolean isHTCityDisplayed =commonFunctions.clickElementIfDisplayed(htCitySubscribeButton,5,"HT City subscribe button");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTCityDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTCity(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel,htCitySubscribeButton,"HT City");
        boolean isHTCityDisplayed =commonFunctions.clickElementIfDisplayed(htCitySubscribeButton,5,"HT City");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        boolean isHTCitySubscribedSuccessfully = checkSubscribeSuccessfully();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTCityDisplayed && isEmailIdPrefilled && isHTCitySubscribedSuccessfully;
    }
    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTMindTheGap() {
        boolean isHTHomePageHighlighted = checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementToLeftByList(newsLetterCarousel, htMindTheGapSubscribeButton,"HT Mind the Gap");
        boolean isHTMindTheGapDisplayed = commonFunctions.clickElementIfDisplayed(htMindTheGapSubscribeButton,5, "HT Mind the Gap");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTMindTheGapDisplayed && isRegisterNowDisplayed;
    }
    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTMindTheGap(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementUsingTouchAction(707,269,ht_EdCallingOption,10,htMindTheGapSubscribeButton);
        boolean isHTMindTheGapDisplayed = commonFunctions.clickElementIfDisplayed(htMindTheGapSubscribeButton,5,"HT Mind the Gap");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        boolean isHTMindTheGapSubscribedSuccessfully = checkSubscribeSuccessfully();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTMindTheGapDisplayed && isEmailIdPrefilled && isHTMindTheGapSubscribedSuccessfully;
    }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTKickOff() {
        boolean isHTHomePageHighlighted = checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementUsingTouchAction(707,269,ht_EdCallingOption,12,htKickOffSubscribeButton);
        boolean isHTKickOffDisplayed = commonFunctions.clickElementIfDisplayed(htKickOffSubscribeButton, 5, "HT Kick Off");
        boolean isRegisterNowDisplayed = checkRegisterNowButton();
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isHTKickOffDisplayed && isRegisterNowDisplayed;
    }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTKickOff(String email) {
        boolean isHTHomePageHighlighted = checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        commonFunctions.dummyWait(3);
        boolean isNewsCarouselSwiped = commonFunctions.swipeElementUsingTouchAction(707,269, ht_EdCallingOption,12,htKickOffSubscribeButton);
        boolean isHtKickOffCapsuleDisplayed = commonFunctions.isElementDisplayed(htKickOffSubscribeButton,5,"ht KickOff Subscribe");
        if(isHtKickOffCapsuleDisplayed && commonFunctions.getElementText(htKickOffSubscribeButton,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(htKickOffSubscribeButton, 5, "ht KickOff Unsubscribed");
        }
        commonFunctions.dummyWait(3);
        if(commonFunctions.isElementNotDisplayed(htKickOffSubscribeButton,5,"HT Kick Off")){
            isNewsCarouselSwiped = commonFunctions.swipeElementUsingTouchAction(707,269, ht_EdCallingOption,12,htKickOffSubscribeButton);
        }
        commonFunctions.clickElementIfDisplayed(htKickOffSubscribeButton, 5, "HT Kick Off");
        commonFunctions.dummyWait(2);
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        commonFunctions.dummyWait(3);
        boolean isHTKickOffSubscribedSuccessfully = checkSubscribeSuccessfully();
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isNewsCarouselSwiped = "+isNewsCarouselSwiped);
        Utils.logStepInfo(true,"isEmailIdPrefilled = "+isEmailIdPrefilled);
        Utils.logStepInfo(true,"isHTKickOffSubscribedSuccessfully = "+isHTKickOffSubscribedSuccessfully);
        return isHTHomePageHighlighted && isNewsCarouselSwiped && isEmailIdPrefilled || isHTKickOffSubscribedSuccessfully;
    }

    @Override
    public boolean checkRecommendedForYouCarouselOnHome() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.scrollDownToElement(recommendedForYouCarousel,homeButton,30);
        boolean isRecommendedForYouCarouselDisplayed = commonFunctions.isElementDisplayed(recommendedForYouCarousel,5,"Recommended For You Carousel");
        return isRecommendedForYouCarouselDisplayed;
    }

    @Override
    public boolean checkViewAllLinkOnRecommendedForYouCarousel() {
        boolean isRecommendedForYouCarouselDisplayed = checkRecommendedForYouCarouselOnHome();
        boolean isViewAllLinkDisplayed = commonFunctions.isElementDisplayed(viewAllButton,5,"View All Link Button");
        return isRecommendedForYouCarouselDisplayed && isViewAllLinkDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTapOnViewAllLinkFromRecommendedForYouCarousel() {
        boolean isViewAllLinkDisplayed = checkViewAllLinkOnRecommendedForYouCarousel();
        commonFunctions.clickElement(viewAllButton,5,"View all button from Recommended for you carousel");
        boolean isRedirectedToForYouListingPage = commonFunctions.isElementSelected(forYouTab,5,"For You Listing page");
        return isViewAllLinkDisplayed && isRedirectedToForYouListingPage;
    }

    @Override
    public  boolean checkForYouTabOnL1() {
        commonFunctions.clickElement(homeButton,5,"Home page");
        boolean isForYouTabDisplayed = commonFunctions.isElementDisplayed(forYouTab,5,"After Top News Tab, For You Tab");
        return isForYouTabDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTapOnStoryFromRecommendedForYouCarousel() {
        boolean isRedirectToForYouStroy = true;
        boolean isRecommendedForYouCarouselDisplayed = checkRecommendedForYouCarouselOnHome();
        for (int i = 0; i <= recommendedForYouStoryList.size() - 1; i++) {
            String text = commonFunctions.getElementText(recommendedForYouStoryList.get(i),5);
            String[] text2 = text.split(" ");
            commonFunctions.clickElement(recommendedForYouStoryList.get(i), 5, "Story Tap from Recommended For You");
            String text1 = commonFunctions.getElementText(forYouStoryHeadline, 5);
            for(int j=0;j<=text2.length-1;j++) {
                if (text1.contains(text2[j])) {
                    isRedirectToForYouStroy &= true;
                } else {
                    isRedirectToForYouStroy &= false;
                }
            }
        }
        return isRecommendedForYouCarouselDisplayed && isRedirectToForYouStroy;
    }

    public boolean navigateToDailyDigestSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        commonFunctions.clickElement(dailyDigestSection, 5, "Daily Digest section in Explore page");
        return commonFunctions.getElementText(sectionPageHeader, 15).equalsIgnoreCase("MORNING BRIEF") || commonFunctions.getElementText(sectionPageHeader, 15).equalsIgnoreCase("EVENING BRIEF");
    }

    @Override
    public boolean checkDailyDigestRedirection() {
        boolean checkSection = navigateToDailyDigestSection();
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeButton, 5, "Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        return checkSection && isHomePage;
    }

    @Override
    public boolean checkDailyDigestSectionRedirection() {
        boolean checkSection = navigateToDailyDigestSection();
        String sectionName= commonFunctions.getElementText(listOfSubSectionsInDailyDigestStoriesPage.get(0),10);
        commonFunctions.clickElementIfDisplayed(listOfSubSectionsInDailyDigestStoriesPage.get(0),10,"CLick on first story section");
        boolean isHeaderMatched=commonFunctions.getElementText(sectionPageHeader,10).equalsIgnoreCase(sectionName);
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        return checkSection && isHeaderMatched;
    }

    @Override
    public boolean checkDailyDigestStoryRedirection() {
        boolean checkSection = navigateToDailyDigestSection();
        commonFunctions.clickElementIfDisplayed(listOfStoriesOnDailyDigestPage.get(0),10,"CLick on first story");
        boolean isStoryDisplayed=commonFunctions.isElementDisplayed(headLine,10,"Headline") && commonFunctions.isElementDisplayed(caption,10,"Caption") && commonFunctions.isElementDisplayed(leadImage,10,"Lead Image");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        return checkSection && isStoryDisplayed;
    }

    @Override
    public boolean checkDailyDigestStoryShare() {
        boolean checkSection = navigateToDailyDigestSection();
        commonFunctions.clickElementIfDisplayed(threeDotButton.get(0),10,"CLick on first story");
        boolean is3DotMsgBox = commonFunctions.isElementDisplayed(threeDotMsgBox,5,"3 Dot Msg Box");
        boolean isBookMarkOption = commonFunctions.isElementDisplayed(shareOption,5,"Share Option");
        commonFunctions.clickElement(shareOption,5,"Share Option");
        boolean isShareSheetDisplayed= commonFunctions.isElementDisplayed(shareSheet,10,"Share Sheet") && commonFunctions.getElementText(shareSheet,10).equalsIgnoreCase("Share");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.isElementDisplayed(cancelBtn,5,"Cancel Btn");
        commonFunctions.dummyWait(10);
        return checkSection && is3DotMsgBox && isBookMarkOption && isShareSheetDisplayed;
    }

    @Override
    public boolean checkLoggedInUserCloseButtonOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        if(isDailyNewsCapsuleDisplayed && commonFunctions.getElementText(dailyNewsCapsuleSubscribeButton,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Daily news Unsubscribed");
        }
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Daily news subscribe button");
        commonFunctions.clickElementIfDisplayed(newsLetterCloseButton,15,"Close button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage;
    }

    @Override
    public boolean checkLoggedInUserBackButtonOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        commonFunctions.clickElement(readNowInNewsLetter.get(0), 5, "Daily news Read Now button");
        boolean isHeaderMatched=commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("DAILY NEWS CAPSULE");
        commonFunctions.pressAndroidBackKey();
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage && isHeaderMatched;
    }

    @Override
    public boolean checkTabOnXInSubscribeToNewsletterBehaviour() {
        boolean isScrollTillNewsletter =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isSubscribeButtonInFirstCard = commonFunctions.isElementDisplayed(dailyNewsCapsuleSubscribeButton, 5, "Daily News Capsule");
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton,5,"Subscribe To Newsletter in First Card");
        commonFunctions.clickElementIfDisplayed(newsLetterCloseButton,15,"Close button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(dailyNewsCapsuleSubscribeButton,5, "Subscribe To Newsletter in First Card");
        return isScrollTillNewsletter && isSubscribeButtonInFirstCard && isHomePage;
    }

    @Override
    public boolean checkPrivacyPolicyLinkOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Subscribe button");
        //No Xpath for Privacy policy link
        commonFunctions.tapElementWithCoOrdinates(817,2091,"Click on Privacy Policy link");
        boolean isHeaderDisplayed=commonFunctions.isElementDisplayed(privacyPolicyHeader,5,"Privacy Policy Header");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.clickElementIfDisplayed(newsLetterCloseButton,15,"Close button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isHomePage = "+isHomePage);
        Utils.logStepInfo(true,"isHeaderDisplayed = "+isHeaderDisplayed);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage && isHeaderDisplayed;
    }

    @Override
    public boolean checkEmailAddressNewslettersTextOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Subscribe button");
        //No Xpath for Privacy policy link
        boolean isTextMatched= commonFunctions.getElementText(enterEmailAddressNewsLetterText,10).contains("Enter your email address");
        commonFunctions.pressAndroidBackKey();
        boolean isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isHomePage = "+isHomePage);
        Utils.logStepInfo(true,"isTextMatched = "+isTextMatched);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage && isTextMatched;
    }

    @Override
    public boolean checkEmailIsPreFilledTextOnDailyNewsCapsule(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        if(isDailyNewsCapsuleDisplayed && commonFunctions.getElementText(dailyNewsCapsuleSubscribeButton,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Daily news Unsubscribed");
        }
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Subscribe button");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        commonFunctions.pressAndroidBackKey();
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isHomePage = "+isHomePage);
        Utils.logStepInfo(true,"isEmailIdPrefilled = "+isEmailIdPrefilled);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage && isEmailIdPrefilled;
    }

    @Override
    public boolean checkTextOnNewsLetterForNonLoggedInUser() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(dailyNewsCapsuleSubscribeButton);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        commonFunctions.clickElement(dailyNewsCapsuleSubscribeButton, 5, "Subscribe button");
        boolean isHeadingMatched= commonFunctions.getElementText(nonLoggedInUserHeading,10).equalsIgnoreCase("Please register to manage your newsletter subscription");
        commonFunctions.pressAndroidBackKey();
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "Home Button");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isHomePage = "+isHomePage);
        Utils.logStepInfo(true,"isHeadingMatched = "+isHeadingMatched);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage && isHeadingMatched;
    }

    @Override
    public boolean checkQuickReadsEntertainmentRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickreadEntertainmentTab, false, 0, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsAllTabRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsAllTab, false, 0, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsIndiaNewsTabRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsIndiaNewsTab, false, 0, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsBusinessTabRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsBusinessNewsTab, true, 2, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsSportsTabRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsSportsNewsTab, true, 2, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkAstrologySectionAfterLifestyleInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Astrology", "Lifestyle", listOfSectionInQuickReads, true, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkDailyDigestDisplayedOnExplore() {
        return commonFunctionsMobile.dailyDigestOptionDisplayedInExplore(homeButton,exploreMenu,dailyDigestSection);
    }

    @Override
    public boolean checkRedirectToCricketSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsCricketTab, false, 1, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean  checkRedirectToCitiesSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsCitiesTab, false, 1, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkRedirectToWorldNewsSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsWorldNewsTab, true, 1, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkRedirectToLifeStyleSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsLifeStyleTab, true, 1, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkRedirectToAstrologyTabFromQuickRead() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsAstrologyNewsTab, true, 1, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkWorldNewsDisplayedAfterCitiesSectionInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("World News", "Cities", listOfSectionInQuickReads, true, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkAllTabInQuickRead() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsAllTab, false, 0, home, topNewsSection,  homeButton,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkLifeStyleSectionAfterWorldNewsInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Lifestyle", "World News", listOfSectionInQuickReads, true, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkBusinessSectionAfterSportsInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Business", "Sports", listOfSectionInQuickReads, true, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkIndiaNewsSectionAfterAllTabInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("India News", "All", listOfSectionInQuickReads, false, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkEntertainmentSectionAfterIndiaNewsInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Entertainment", "India News", listOfSectionInQuickReads, false, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkCricketSectionAfterEntertainmentInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Cricket", "Entertainment", listOfSectionInQuickReads, false, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkCitiesSectionAfterCricketInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Cities", "Cricket", listOfSectionInQuickReads, false, 1, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkSportsSectionAfterAstrologyInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Sports", "Astrology", listOfSectionInQuickReads, true, 2, home, topNewsSection, homeButton, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkSwipeUpAndAdAfter4StoriesInQuickReads() {
        boolean isFirstAdAfterSwipe = checkFirstAdAfter4StoriesInQuickReadPage();
        boolean isSwipeUpText = commonFunctions.isElementDisplayed(swipeUpInQuickReads,5,"Swipe up text");
        return isFirstAdAfterSwipe && isSwipeUpText;
    }

    @Override
    public boolean checkOtherSectionBySwipingLeftToRightInQuickReads() {
        boolean isIndiaNewsSelected = checkQuickReadsIndiaNewsTabRedirection();
        commonFunctions.swipeElementUsingTouchAction(69, 850, 972, 850);
        boolean isAllTabSelected = commonFunctions.isElementSelected(quickReadsAllTab,5,"All Tab in QuickRead");
        return isIndiaNewsSelected && isAllTabSelected;
    }

    @Override
    public boolean checkOtherSectionBySwipingRightToLeftInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        commonFunctions.swipeElementUsingTouchAction(959, 850, 130, 850);
        boolean isIndiaNewsSelected = commonFunctions.isElementSelected(quickReadsIndiaNewsTab,10,quickReadsIndiaNewsTab.getText()+ " tab");
        return isRedirectToAllTab && isIndiaNewsSelected;
    }

    @Override
    public boolean checkSwipeTopToBottomInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        String storyTitleBeforeSwipe = commonFunctions.getElementText(firstStoryInQuickRead.get(0),5);
        commonFunctions.swipeElementUsingTouchAction(507, 1553, 490, 408);
        commonFunctions.getElementText(firstStoryInQuickRead.get(0),5);
        commonFunctions.swipeElementUsingTouchAction(486, 403, 516, 1600);
        String storyTitleAfterSwipe = commonFunctions.getElementText(firstStoryInQuickRead.get(0),5);
        boolean isPreviousStoryAfterSwipe = storyTitleAfterSwipe.equalsIgnoreCase(storyTitleBeforeSwipe);
        return isRedirectToAllTab && isPreviousStoryAfterSwipe;
    }

    @Override
    public boolean checkSwipeBottomToTopInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        String storyTitleBeforeSwipe = commonFunctions.getElementText(firstStoryInQuickRead.get(0),5);
        commonFunctions.swipeElementUsingTouchAction(507, 1553, 490, 408);
        String storyTitleAfterSwipe = commonFunctions.getElementText(firstStoryInQuickRead.get(0),5);
        boolean compareBothStories = (!commonFunctions.isCompareTextTrue(storyTitleAfterSwipe,storyTitleBeforeSwipe));

        return isRedirectToAllTab && compareBothStories;
    }

    @Override
    public boolean checkSecondAdAfter8SwipeInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        for (int i =0; i<9; i++){
            commonFunctions.swipeElementUsingTouchAction(103,673,128,191);
        }
        boolean isSecondAd = commonFunctions.isElementDisplayed(firstAd,5,"Quick Read Second Ad");
        return isSecondAd;
    }

    @Override
    public boolean checkSwipeUpOptionInFirstAdInQuickReads() {
        boolean isFirstAdAfter4Swipe = checkFirstAdAfter4StoriesInQuickReadPage();
        boolean isSwipeUpOption = commonFunctions.isElementDisplayed(swipeUpInQuickReads,5,"Swipe Up For Next Story");
        return isFirstAdAfter4Swipe & isSwipeUpOption;
    }

    @Override
    public boolean checkRedirectToStoryIfTabOnBlankSpaceInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        String firstStoryTitle = commonFunctions.getElementText(firstStoryInQuickRead.get(0), 5);
        commonFunctions.tapElementWithCoOrdinates(394,1598,"Click on Blank Space");
        commonFunctions.toGetRidOfAd(homeButton, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isStoryTitle = commonFunctions.getElementText(headLine, 10).equalsIgnoreCase(firstStoryTitle);
        return isRedirectToAllTab && isStoryTitle;
    }

    @Override
    public boolean checkEPaperOptionFromCricketHeader() {
        return commonFunctionsMobile.verifyEPaperOptionInSectionForAndroid(listOfBottomNavOption.get(3), homeButton, ePaperButtonOnHeader, chromeOption, onceOptionWeb, epaperWebUrlBox);
    }

    @Override
    public boolean checkEPaperOptionFromPremiumHeader() {
        return commonFunctionsMobile.verifyEPaperOptionInSectionForAndroid(listOfBottomNavOption.get(2), homeButton, ePaperButtonOnHeader, chromeOption, onceOptionWeb, epaperWebUrlBox);
    }

    @Override
    public boolean checkEPaperOptionFromExploreHeader() {
        return commonFunctionsMobile.verifyEPaperOptionInSectionForAndroid(listOfBottomNavOption.get(4), homeButton, ePaperButtonOnHeader, chromeOption, onceOptionWeb, epaperWebUrlBox);
    }

    @Override
    public boolean checkRedirectToDailyDigestFromExplore() {
        return navigateToDailyDigestSection();
    }

    public boolean checkSubscribeSuccessfully(MobileElement capsuleSubscribeButton) {
        boolean isSubscribeMessageChecked = checkSubscribeSuccessfully();
        if (!isSubscribeMessageChecked) {
            isSubscribeMessageChecked = commonFunctions.getElementText(capsuleSubscribeButton, 5).equalsIgnoreCase("Subscribed");
            if (isSubscribeMessageChecked) {
                Utils.logStepInfo(true, "Capsule Subscribed successfully !!!");
            } else {
                Utils.logStepInfo(false, "Capsule Subscribed Failed !!!");
            }
        }
        Utils.logStepInfo(true, "isSubscribeMessageChecked = "+isSubscribeMessageChecked);
        return isSubscribeMessageChecked;
    }


    @Override
    public boolean checkCityNewsInHomepageDisplayed() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        boolean isCityNewsDisplayed = commonFunctions.isElementDisplayed(cityNewsInHomepage,5,"City news");
        commonFunctionsMobile.getBackToTopInAndroid(home,quickreadsButton);
        return isCityNewsDisplayed;
    }

    @Override
    public boolean checkListOfCitiesInCityNewsDisplayed() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        commonFunctions.isElementDisplayed(cityNewsInHomepage,5,"City news");
        boolean isListOfCitiesDisplayed = commonFunctions.isElementDisplayedOfListOfElements(listOfCitiesInCityNews,"List of cities in City News");
        commonFunctionsMobile.getBackToTopInAndroid(home,quickreadsButton);
        return isListOfCitiesDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenUserTapsOnViewAllInCityNews() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        boolean isCityNewsDisplayed = commonFunctions.isElementDisplayed(cityNewsInHomepage,5,"City news");
        boolean isViewAllInCityNewsDisplayed = commonFunctions.clickElementIfDisplayed(viewAllInCityNews,5,"View all in City news");
        commonFunctions.clickElementIfDisplayed(gotItButtonOnCitiesPopUp,5,"Got it button");
        boolean isRedirectToCitySection = commonFunctions.isElementDisplayed(citiesSection,5,"Cities Section");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewsSection,"Top news");
        return isCityNewsDisplayed && isViewAllInCityNewsDisplayed && isRedirectToCitySection;
    }

    @Override
    public boolean checkSectionPageSelectedCityShownInHomePage() {
        boolean isCitiesDisplayed = commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isFirstCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida City",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewsSection,"Top news");
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        boolean isDelhiCityDisplayed = commonFunctions.isElementDisplayed(delhiSelectButton,5,"Delhi City in Homepage");
        boolean isNoidaCityDisplayed = commonFunctions.isElementDisplayed(noidaCitySelectButton,5,"Noida City in Homepage");
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Deselect Noida City",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getBackToTopInAndroid(home,quickreadsButton);
        return isCitiesDisplayed && isFirstCitySelected && isDelhiCityDisplayed && isNoidaCityDisplayed;
    }

    @Override
    public boolean checkHomePageSelectedCityShownInSectionPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.clickElementIfDisplayed(gotItButtonOnCitiesPopUp,5,"Got it");
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida City",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getRedirectionToSectionFromRightToLeft(citiesSection,"Cities");
        boolean isDelhiCityDisplayed = commonFunctions.isElementDisplayed(delhiSelectButton,5,"Delhi City in Section page");
        boolean isNoidaCityDisplayed = commonFunctions.isElementDisplayed(noidaCitySelectButton,5,"Noida City in Section page");
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Deselect Noida City",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewsSection,"Top news");
        return isCitySelected && isDelhiCityDisplayed && isNoidaCityDisplayed;
    }

    @Override
    public boolean checkAllL1SubMenuPresentAnd200StatusCode() {
        return false;
    }

    @Override
    public boolean checkAllL2SubMenuPresentAnd200StatusCode() {
        return false;
    }

    @Override
    public boolean checkFirstCollectionTopNews() {
        return false;
    }

    @Override
    public boolean checkHeaderTopAd() {
        return false;
    }

    @Override
    public boolean checkMoreOptionInL2() {
        return false;
    }

    @Override
    public boolean checkLHSAndRHSCollectionAndStories() {
        return false;
    }

    @Override
    public boolean checkAdInTopAndAfterCollectionInRHS() {
        return false;
    }

    @Override
    public boolean checkFooterAndData() {
        return false;
    }

    @Override
    public boolean checkAdsAfterEveryCollectionInMiddleLayer() {
        return false;
    }

    @Override
    public boolean checkL3SubMenuAnd200SuccessCode() {
        return false;
    }

    @Override
    public boolean checkAllTopicSuccessCode200() {
        return false;
    }
}
