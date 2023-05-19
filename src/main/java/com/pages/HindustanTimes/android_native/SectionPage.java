package com.pages.HindustanTimes.android_native;


import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.List;

public class SectionPage extends CommonSectionPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static ApiValidation apiValidation;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.ht.news:id/titleTv'])[1]")
    private static MobileElement clickFirstStory;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement storyDetailPage;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static List<MobileElement> searchResults;

    @FindBy(xpath = "//div[@class='dateTime']")
    private static List<WebElement> lastPublished;

    @AndroidFindBy(id = "com.ht.news:id/txt_author")
    private static MobileElement storyTime;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> listOfStories;

    @AndroidFindBy(id = "com.ht.news:id/title")
    private static MobileElement searchStory;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.ht.news:id/txt_date_time'])[1]")
    private static MobileElement getStoryTime;

    @AndroidFindBy(id = "android.widget.RelativeLayout")
    private static MobileElement homePage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Premium']")
    private static MobileElement premiumSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
    private static MobileElement businessSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mumbai News']")
    private static MobileElement mumbaiNewsSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BUSINESS']")
    private static MobileElement businessPageHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Market Statistics']")
    private static MobileElement marketStatistics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daily Sudoku']")
    private static MobileElement sudokuSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DAILY SUDOKU']")
    private static MobileElement sudokuPageHeader;


    @AndroidFindBy(id = "com.ht.news:id/detail_recycler")
    private static MobileElement storySection;

    @AndroidFindBy(id = "com.ht.news:id/toolbarLayout")
    private static MobileElement homePageSection;

    @AndroidFindBy(id = "com.ht.news:id/adsContainerLayout")
    private static MobileElement contentAd;

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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']")
    private static MobileElement videoSectionOption;

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

    @AndroidFindBy(id = "com.ht.news:id/swipeUpHint")
    private static MobileElement nextStorySection;

    @AndroidFindBy(id = "//com.ht.news:id/moreFromSectionTv")
    private static MobileElement sectionYouMayAlsoLike;

    @AndroidFindBy(id = "com.ht.news:id/layoutParent")
    private static MobileElement sectionToScrollToView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='watch more...']")
    private static MobileElement watchMoreSection;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static MobileElement photoStoryTitle;

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
    private static List<MobileElement> premiumStory;

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

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout/android.widget.TextView)[2]")
    private static MobileElement continueReadingText;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@index='1'])[4]")
    private static MobileElement accessToPremiumArticles;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@index='2'])[2]")
    private static MobileElement shareAndSaveArticles;

    @AndroidFindBy(id = "com.ht.news:id/signUpBtn")
    private static MobileElement signUpButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private static MobileElement hamBurger;

    @AndroidFindBy(id = "com.ht.news:id/search_tv")
    private static MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='search']")
    private static MobileElement searchBar;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement headLine;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> paragraph;

    @AndroidFindBy(id = "com.ht.news:id/ll_caption")
    private static MobileElement caption;

    @AndroidFindBy(id = "com.ht.news:id/share_layout")
    private static MobileElement shareIcon;

    @AndroidFindBy(id = "com.ht.news:id/bookmark")
    private static MobileElement bookMark;

    @AndroidFindBy(id = "com.ht.news:id/img_news")
    private static MobileElement leadImage;

    @AndroidFindBy(id = "com.ht.news:id/storyDetailAdContainer")
    private static MobileElement AdvertisementAtBottom;

    @AndroidFindBy(id = "com.ht.news:id/signInWallLayout")
    private static MobileElement signInWall;

    @AndroidFindBy(accessibility = "Interstitial close button")
    private static MobileElement adPopUpInApp;

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private static MobileElement storySummary;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Popular Sections']")
    private static MobileElement popularSections;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_name")
    private static List<MobileElement> videosOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Explore']/android.widget.FrameLayout/android.widget.ImageView")
    private static MobileElement exploreMenu;

    @AndroidFindBy(id = "com.ht.news:id/tabLayout")
    private static MobileElement topSection;

    @AndroidFindBy(id = "com.ht.news:id/navigation_explore")
    private static MobileElement explore;

    @AndroidFindBy(id = "com.ht.news:id/toolbarLayout")
    private static MobileElement exploreTopHeader;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_name")
    private static List<MobileElement> sectionNamesList;

    @AndroidFindBy(accessibility = "Top News")
    private static MobileElement topNewSection;

    @AndroidFindBy(id = "com.ht.news:id/tv_section_heading")
    private static MobileElement popularSectionPage;

    @AndroidFindBy(accessibility = "Home")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNewsButton;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement sectionPageHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cities']")
    private static MobileElement citiesSection;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement citiesPageHeader;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Noida']")
    private static MobileElement noidaSubSection;

    @AndroidFindBy(id = "com.ht.news:id/titleSubSection")
    private static MobileElement noidaSubSectionTag;

    @AndroidFindBy(id = "com.ht.news:id/imv_icon")
    private static MobileElement downArrowButtonCities;

    @AndroidFindBy(id = "com.ht.news:id/linear_layout_sub_category")
    private static MobileElement citiesList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    private static MobileElement photosSection;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='World']")
    private static MobileElement worldSectionPageButton;

    @AndroidFindBy(id = "com.ht.news:id/titleSubSection")
    private static List<MobileElement> sectionNamePageList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Election']")
    private static MobileElement electionSection;

    @AndroidFindBy(id = "com.ht.news:id/newsTypeIconIsLive")
    private static MobileElement liveBlogStoryRedDot;

    @AndroidFindBy(id = "com.ht.news:id/newsTypeIconIsBlog")
    private static MobileElement premiumStoryTag;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Opinion']")
    private static MobileElement topNewLastElement;

    @AndroidFindBy(id = "com.ht.news:id/headlineTv")
    private static MobileElement recommendedForYouCarousel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']")
    private static MobileElement videosSection;

    @AndroidFindBy(id = "com.ht.news:id/profile")
    private static MobileElement profileButton;

    @AndroidFindBy(accessibility = "Premium")
    private static MobileElement premiumButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Entertainment']")
    private static MobileElement entertainmentSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Bollywood']")
    private static MobileElement bollywoodInEntertainmnet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'TV']")
    private static MobileElement tvInEntertainmnet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Music']")
    private static MobileElement musicInEntertainmnet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Hollywood']")
    private static MobileElement hollywoodInEntertainmnet;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@index='1'])[2]")
    private static MobileElement extractEntertainmentSubSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Trending']")
    private static MobileElement trendingSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='News']")
    private static MobileElement newsSubSectionInVideosSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='World News']")
    private static MobileElement worldNewsSubSectionInVideosSection;

    @AndroidFindBy(id = "com.ht.news:id/adIndicator")
    private static MobileElement firstAdInVideoSection;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ImageView[1]")
    private static MobileElement videoPlayIconInFirstVideoStory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']/following-sibling::android.widget.ImageView")
    private static MobileElement downArrowButtonVideos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Astrology']")
    private static MobileElement astrologyOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lifestyle']")
    private static MobileElement lifeStyleSectionOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lifestyle']/following-sibling::android.widget.ImageView")
    private static MobileElement downArrowButtonLifeStyle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    private static MobileElement educationOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fashion']")
    private static MobileElement fashionSubSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Exam Results']")
    private static MobileElement examResultInEducation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Competitive Exams']")
    private static MobileElement competitiveExamSubSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Board Exams']")
    private static MobileElement boardExamInEducation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Admission News']")
    private static MobileElement admissionNewsInEducation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sports']")
    private static MobileElement sportOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sports']/following-sibling::android.widget.ImageView")
    private static MobileElement downArrowButtonSports;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text = 'Cricket'])[1]")
    private static MobileElement cricketInSports;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Football']")
    private static MobileElement footballInSports;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Tennis']")
    private static MobileElement tennisInSports;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Other Sports']")
    private static MobileElement otherSportsInSports;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Opinion']")
    private static MobileElement opinionSection;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Cricket'])[1]")
    private static MobileElement cricketOption;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")
    private static MobileElement fivthStoryInHomePage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'ADVERTISEMENT']")
    private static MobileElement secondAdAfterFiveStories;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout/android.widget.ImageView)[1]")
    private static MobileElement threeDotInFirstStory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    private static MobileElement photosOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[1][@text = 'Display & Text Size']")
    private static MobileElement displayTextSize;

    @AndroidFindBy(id = "com.ht.news:id/darkTV")
    private static MobileElement darkThemes;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
    private static MobileElement businessOnHomePage;

    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreBtn;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement pageHeaderName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share']")
    private static MobileElement shareOptionThreeDot;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private static MobileElement messageOptionOnShareSheet;

    @AndroidFindBy(id = "android:id/title")
    private static MobileElement shareSheet;


    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static List<MobileElement> threeDotButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_bookmark")
    private static MobileElement bookmarkOptionThreeDot;

    @AndroidFindBy(id = "com.ht.news:id/marketTv")
    private static MobileElement marketStatisticsText;

    @AndroidFindBy(id = "com.ht.news:id/bseTv")
    private static List<MobileElement> bussinessPageOptions;

    @AndroidFindBy(id = "com.ht.news:id/bseValueTv")
    private static List<MobileElement> firstSubMarketStatisticsElements;

    @AndroidFindBy(id = "com.ht.news:id/bsePlTv")
    private static List<MobileElement> secondSubMarketStatisticsElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delhi News']")
    private static MobileElement delhiNewsSection;

    @AndroidFindBy(xpath = "//*[@text='TV News']")
    private static MobileElement tvNews;

    @AndroidFindBy(id = "com.ht.news:id/photo_count")
    private static List<MobileElement> countOfPhotos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Web Stories']")
    private static MobileElement webStoriesSection;

    @AndroidFindBy(id = "com.ht.news:id/siv")
    private static List<MobileElement> allStoriesInWebStoriesPage;

    @AndroidFindBy(id ="com.ht.news:id/view_line")
    private static List<MobileElement> allhorizontalLinesInWebStories;

    @AndroidFindBy (id = "com.ht.news:id/ht_logo")
    private static List<MobileElement> htLogosInWebStories;

    @AndroidFindBy (id = "com.ht.news:id/dot")
    private static List<MobileElement> threeDotInAllWebStories;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='For You']")
    private static MobileElement forYouSectionTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc]//android.widget.TextView")
    private static List<MobileElement> sectionsNameList;

    @AndroidFindBy(id = "com.ht.news:id/tv_editText")
    private static MobileElement editProfile;

    @AndroidFindBy(id="com.ht.news:id/txtViewEmailCaption")
    private static MobileElement emailCaptionInEditProfile;

    @AndroidFindBy(id="com.ht.news:id/txtViewNameCaption")
    private static MobileElement nameCaptionInEditProfile;

    @AndroidFindBy(id="com.ht.news:id/txtViewPhoneCaption")
    private static MobileElement phoneCaptionInEditProfile;

    @AndroidFindBy(id="com.ht.news:id/txtViewGenderCaption")
    private static MobileElement genderCaptionInEditProfile;

    @AndroidFindBy(id="com.ht.news:id/txtViewPasswordCaption")
    private static MobileElement passwordCaptionInEditProfile;

    @AndroidFindBy(id = "com.ht.news:id/topicChip")
    private static MobileElement popUpOnCities;

    @AndroidFindBy(id = "com.ht.news:id/bt_continue")
    private static MobileElement gotItButtonOnCitiesPopUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Add your')]")
    private static MobileElement addFavouriteCities;

    @AndroidFindBy(id = "com.ht.news:id/plusIv")
    private static MobileElement plusSignBeforeCity;

    @AndroidFindBy(id = "com.ht.news:id/iconIv")
    private static MobileElement horizontalLinesTab;

    @AndroidFindBy(id = "com.ht.news:id/may_be_later_btn")
    private static MobileElement mayBeLaterButtonOnCitiesSection;

    @AndroidFindBy(id = "com.ht.news:id/save_btn")
    private static MobileElement saveChangesButtonOnCitiesSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Others']")
    private static MobileElement othersOptionInCities;

    @AndroidFindBy(id = "com.ht.news:id/add_city_btn")
    private static MobileElement addCitiesOption;

    @AndroidFindBy(xpath = "//android.widget.TextView [@text='Delhi']")
    private static MobileElement delhiSelectButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save Changes']")
    private static MobileElement delhisaveButton;

    @AndroidFindBy(id = "com.ht.news:id/customAlertMsg")
    private static MobileElement citySuccessfulPopUp;

    @AndroidFindBy(id = "com.ht.news:id/city_sub_date_display")
    private static MobileElement dateOnSelectedCity;

    @AndroidFindBy(id = "com.ht.news:id/city_sub_temp_display")
    private static MobileElement temperatureInCities;

    @AndroidFindBy(id = "com.ht.news:id/ad_view_320_100")
    private static MobileElement adInCities;

    @AndroidFindBy(id = "com.ht.news:id/city_sub_text_display")
    private static MobileElement citiNameWithNews;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Noida']")
    private static MobileElement noidaCitySelectButton;

    @AndroidFindBy(id = "com.ht.news:id/itemInfoTv")
    private static List<MobileElement> listOfCitiesInSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gurugram']")
    private static MobileElement gurugramCitySelectButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mumbai']")
    private static MobileElement mumbaiCitySelectButton;

    @AndroidFindBy(xpath = "//*[@text='Quickreads']")
    private static MobileElement quickReads;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[contains(@content-desc,\"\")]//android.widget.TextView)[1]")
    private static MobileElement firstSectionAtTop;

    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        /*commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNewsButton, 5, "Start Reading News");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available*/
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkIsSectionIndiaNewsScrollable() {
        return false;
    }

    @Override
    public boolean checkIsSectionIndiaNewsDisplayedClickable() {
        return false;
    }

    @Override
    public boolean checkFullStoryVisisbleAndClickableInQuickRead(String quickReadURL, String readSFullStoryText, String target1, String target2) {
        return false;
    }

    @Override
    public boolean checkTopicPage(String topicURL) {
        return false;
    }

    @Override
    public boolean checkTopicLandingPage(String topicURL) {
        return false;
    }

    @Override
    public boolean checkL1LandingPage() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbDisplayedFromGoogle(String url, String searchText) {
        return false;
    }

    @Override
    public boolean checkL2NewTag() {
        return false;
    }

    @Override
    public boolean checkAppLaunchDisplayTopSection() {
        Utils.logStepInfo("Checking to confirm the top news section display.");

        return commonFunctions.isElementDisplayed(topNewSection, 5, "Top section");
    }

    @Override
    public boolean checkBottomNavHomeSelected() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(worldSectionPageButton, 5, "World Section page button");
        return commonFunctions.isElementSelected(homeButton, 5, "Home button");
    }

    @Override
    public boolean checkBottomNavDispalyFromAnotherSectionPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(worldSectionPageButton, 5, "World Section page button");
        return commonFunctions.isElementDisplayed(homeButton, 5, "Bottom nav");
    }

    @Override
    public boolean checkSectionRedirectionPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(sectionsNameList.get(2), 5, "Any Section page button");
        return commonFunctions.isElementSelected(sectionsNameList.get(2),5,"Section Selected");
    }

    @Override
    public boolean checkBusinessSection() {
        boolean isMarketStaticsDisplayed = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Menu");
        commonFunctions.scrollDownToElement(businessSection,homeButton);
        commonFunctions.clickElement(businessSection, 5, "Business Section");
        commonFunctions.isElementDisplayed(businessPageHeader, 5, "Buisness Section Header");
        isMarketStaticsDisplayed = commonFunctions.isElementDisplayed(marketStatistics, 5, "Market Statistics");
        commonFunctions.clickElement(homeButton, 5, "Home");
        return isMarketStaticsDisplayed;
    }

    @Override
    public boolean checkSudokuSection() {
        boolean isSudokuRedirectionTrue = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Menu");
        commonFunctions.scrollDownToElement(sudokuSection,homeButton);
        commonFunctions.clickElement(sudokuSection, 5, "Sudoku Section");
        commonFunctions.isElementDisplayed(sudokuPageHeader, 5, "Sudoku Section Header");
        isSudokuRedirectionTrue = commonFunctions.checkElementText(sudokuPageHeader, "DAILY SUDOKU", 5, "Sudoku Page Header");
        commonFunctions.clickElement(homeButton, 5, "Home");
        return isSudokuRedirectionTrue;
    }

    @Override
    public boolean checkClickCityDisplayCitiesInExplore() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        commonFunctions.clickElement(downArrowButtonCities, 5, "Down arrow button for cities");
        return commonFunctions.isElementDisplayed(citiesList, 5, "Cities name list");
    }

    @Override
    public boolean checkClickExplorePageAppearAgain() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        commonFunctions.scrollDownToElement(photosSection,homeButton);
        commonFunctions.clickElement(photosSection, 5, "Photos section in Explore page");
        boolean sectionPageHeaderDisplay = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("Photos");
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        boolean explorePageHeaderDisplay = commonFunctions.getElementText(popularSectionPage, 5).equalsIgnoreCase("Popular Sections");
        return sectionPageHeaderDisplay && explorePageHeaderDisplay;
    }

    public boolean checkAllElementsAreVisible(List<MobileElement> elementList, String text) {
        boolean isAllElementAreVisibleTrue = false;
        System.out.println("Total Stories in tag = " + elementList.size());
        int count = 0;
        for (MobileElement ele : elementList) {
            if (count < 4) {
                if (commonFunctions.isElementDisplayed(ele, 5, ele.getText()) && ele.getText().equalsIgnoreCase(text)) {
                    isAllElementAreVisibleTrue = true;
                    count++;
                }
            } else {
                System.out.println("Elements are available more that " + count + " times. so breaking the loop");
                break;
            }
        }
        if (isAllElementAreVisibleTrue == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkCitiesSectionNameisDispayed() {
        boolean isCitiesSectionNameDiplayed = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(citiesSection, 5, "Cities Section");
        commonFunctions.isElementDisplayed(citiesPageHeader, 5, "Cities Page Header");
        String SectionName = commonFunctions.getElementText(citiesPageHeader);
        isCitiesSectionNameDiplayed = commonFunctions.checkTextEquals("CITIES", SectionName, "Section Name");
        return isCitiesSectionNameDiplayed;
    }

    @Override
    public boolean checkNoidaSubSectionNameisDispayed() {
        boolean isSubSectionNameDiplayed = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(citiesSection, 5, "Cities Section");
        commonFunctions.clickElement(noidaSubSection, 5, "Noida Sub section");
        commonFunctions.isElementDisplayed(noidaSubSectionTag, 5, "Noida News Tag");
        String SubSection = commonFunctions.getElementText(noidaSubSectionTag);
        isSubSectionNameDiplayed = commonFunctions.checkTextEquals("NOIDA NEWS", SubSection, "SubSection Name");

        return isSubSectionNameDiplayed;
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        boolean isPopularSectionsDisplayed = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.isElementDisplayed(exploreTopHeader, 5, "Top Header");
        String PupularSections = commonFunctions.getElementText(popularSections);
        isPopularSectionsDisplayed = commonFunctions.checkTextEquals("Popular Sections", PupularSections, "Popular Sections");
        return isPopularSectionsDisplayed;
    }

    @Override
    public boolean checkSectionNamesDisplayed() {
        boolean isSectionNamesDisplayed = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.isElementDisplayed(exploreTopHeader, 5, "Top Header");
        commonFunctions.isElementDisplayed(popularSections, 5, "Popular Sections Header");
        isSectionNamesDisplayed = commonFunctions.isElementDisplayedOfListOfElements(sectionNamesList, "Section Names");
        return isSectionNamesDisplayed;
    }

    @Override
    public boolean checkSectionLiveBlogWithRedDotOnStory() {
        boolean isRedDotLiveBlogDisplayTrue = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(quickReads,5,"QuickReads");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        if (commonFunctions.isElementNotDisplayed(liveBlogStoryRedDot, 5, "Live blog red dot before relevant story")) {
            commonFunctions.scrollDownToElement(liveBlogStoryRedDot,homeButton);
        }
        isRedDotLiveBlogDisplayTrue &= commonFunctions.isElementDisplayed(liveBlogStoryRedDot, 5, "Live blog red dot before relevant story");
        return isRedDotLiveBlogDisplayTrue;
    }

    @Override
    public boolean checkRedirectionFromExploreToPhotos() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        commonFunctions.scrollDownToElement(photosSection,homeButton);
        commonFunctions.clickElement(photosSection, 5, "Photos section in Explore page");
        return commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("Photos");
    }

    @Override
    public boolean checkRedirectionFromExploreToVideos() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreMenu, 5, "Explore button");
        commonFunctions.clickElement(videosSection, 5, "Videos section in Explore page");
        return commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("VIDEOS");
    }

    @Override
    public boolean checkPremiumStoryInsideSectionPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(quickReads,5,"QuickRead option");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        boolean isHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        boolean isTopNewSectionSelected = commonFunctions.isElementSelected(topNewSection, 5, "Top News top section button");
        commonFunctions.clickElement(topNewSection, 5, "Top News top section button");
//        commonFunctions.scrollDownToElementWithWhile(premiumStoryTag);
        commonFunctions.scrollTillVisibleText("Opinion", "Opinion Section on HT home page for premium story tag");
        commonFunctions.clickElement(premiumButton, 5, "profile button");
        boolean isPremiumStoryText = commonFunctions.isElementDisplayed(premiumStoryTag, 5, "Premium section page");
        return isHomeButtonSelected && isTopNewSectionSelected && isPremiumStoryText;
    }

    @Override
    public boolean checkUserScrollToBottomOfTopNewsPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean isHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        boolean isTopNewSectionSelected = commonFunctions.isElementSelected(topNewSection, 5, "Top News top section button");
        commonFunctions.scrollDownToElementWithWhile(recommendedForYouCarousel);
        boolean bottomPageVisible = commonFunctions.isElementDisplayed(recommendedForYouCarousel, 5, "Top News bottom page element");
        return bottomPageVisible && isHomeButtonSelected && isTopNewSectionSelected;
    }

    @Override
    public boolean checkForLiveBlogForTopNewsPage() {
        boolean isRedDotLiveBlogDisplayTrue = true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean isHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        boolean isTopNewSectionSelected = commonFunctions.isElementSelected(topNewSection, 5, "Top News top section button");
        if (!commonFunctions.isElementDisplayed(liveBlogStoryRedDot, 5, "Live blog red dot before relevant story")) {
            commonFunctions.scrollDownToElement(liveBlogStoryRedDot,homeButton);
            isRedDotLiveBlogDisplayTrue &= commonFunctions.isElementDisplayed(liveBlogStoryRedDot, 5, "Live blog red dot before relevant story");
        } else {
            isRedDotLiveBlogDisplayTrue &= commonFunctions.isElementDisplayed(liveBlogStoryRedDot, 5, "Live blog red dot before relevant story");
        }
        return isRedDotLiveBlogDisplayTrue && isHomeButtonSelected && isTopNewSectionSelected;
    }

    @Override
    public boolean checkRedirectionFromWorld() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromCities() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromIndia() {
        return false;
    }

    @Override
    public boolean SubSectionNameInCitiesSection() {
        return false;
    }

    @Override
    public boolean WorldSectionInDarkMode() {
        return false;
    }

    @Override
    public boolean opinionSectionRedirection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        boolean iSOpinionOption = commonFunctions.isElementDisplayed(opinionSection, 10, "Opinion Option");
        if (iSOpinionOption) {
            commonFunctions.clickElement(opinionSection, 5, "Opinion Option");
        }
        boolean iSOpinionSectionPage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("OPINION");
        return iSOpinionOption && iSOpinionSectionPage;
    }

    @Override
    public boolean checkScrollingOnOpinion() {
        opinionSectionRedirection();
        String firstStoryText = photoStoryTitle.getText();
        System.out.println("First Story Text = " + firstStoryText);
        commonFunctions.scrollToBottomForAndroidNative();
        commonFunctions.scrollToTopForAndroidNative();
        boolean isFirstStoryDisplayed = commonFunctions.isElementDisplayed(photoStoryTitle, 5, "Photo Story");
        boolean isFirstStoryText = commonFunctions.getElementText(photoStoryTitle, 5).equalsIgnoreCase(firstStoryText);
        return isFirstStoryDisplayed && isFirstStoryText;
    }

    @Override
    public boolean redirectToStoryFromOpinion() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(opinionSection, 5, "Opinion Section");
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean checkAdAfterFiveStories() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.scrollDownToElement(fivthStoryInHomePage,homeButton);
        commonFunctions.scrollDownToElement(secondAdAfterFiveStories,homeButton);
        commonFunctions.dummyWait(5);
        Boolean isAdAfterFiveStories = commonFunctions.isElementDisplayed(secondAdAfterFiveStories, 5, "Second Ad after Fifth Story");
        return isAdAfterFiveStories;
    }

    @Override
    public boolean redirectToCricketSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(cricketOption, 5, "Cricket Section");
        boolean isCricketheader = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("CRICKET");
        return isCricketheader;
    }

    @Override
    public boolean redirectToEntertainmentSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(entertainmentSection, 5, "Entertainment Section");
        boolean isEntertainmentheader = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("ENTERTAINMENT");
        return isEntertainmentheader;
    }

    @Override
    public boolean redirectToStoryFromEntertainment() {
        redirectToEntertainmentSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean subSectionInEntertainment() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.clickElement(entertainmentSection, 5, "entertainment Explore Button");
        boolean bollyWood = commonFunctions.isElementDisplayed(bollywoodInEntertainmnet, 5, "Bollywood Sub Section");
        boolean tv = commonFunctions.isElementDisplayed(tvInEntertainmnet, 5, "TV Sub Section");
        boolean music = commonFunctions.isElementDisplayed(musicInEntertainmnet, 5, "Music Sub Section");
        boolean hollyWood = commonFunctions.isElementDisplayed(hollywoodInEntertainmnet, 5, "HollyWood Sub Section");
        return (bollyWood && tv && music && hollyWood);
    }

    @Override
    public boolean redirectToSubSectionInEntertainment() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        //Verification of BollyWood Sub-Section
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.clickElement(extractEntertainmentSubSection, 5, "Open Sub Section under Entertainment");
        commonFunctions.clickElement(bollywoodInEntertainmnet, 5, "Bollywood");
        boolean isBollyWoodPage = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("BOLLYWOOD");

        //Verification of TV Sub-Section
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.clickElement(extractEntertainmentSubSection, 5, "Open Sub Section under Entertainment");
        commonFunctions.clickElement(tvInEntertainmnet, 5, "Bollywood");
        boolean isTVPage = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("TV");

        //Verification of Music Sub-Section
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.clickElement(extractEntertainmentSubSection, 5, "Open Sub Section under Entertainment");
        commonFunctions.clickElement(musicInEntertainmnet, 5, "Bollywood");
        boolean isMusicPage = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("MUSIC");

        //Verification of Hollywood Sub-Section
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.clickElement(extractEntertainmentSubSection, 5, "Open Sub Section under Entertainment");
        commonFunctions.clickElement(hollywoodInEntertainmnet, 5, "Bollywood");
        boolean isHollyWoodPage = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("HOLLYWOOD");
        return (isBollyWoodPage && isTVPage && isMusicPage && isHollyWoodPage);
    }

    @Override
    public boolean redirectToToTrendingSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.clickElement(trendingSection, 5, "Trending Section");
        boolean isRedirectToTrendingPage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("TRENDING");
        return isRedirectToTrendingPage;
    }

    @Override
    public boolean redirectToStoryFromTrendingSection() {
        redirectToToTrendingSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean redirectOnVideoSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownSlowToElement(videoSectionOption,4);
        commonFunctions.clickElement(videoSectionOption, 5, "Redirect to Videos Section");
        boolean isRedirectToVideoPage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("VIDEOS");
        return isRedirectToVideoPage;
    }

    @Override
    public boolean subSectionNamesInVideoPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.scrollDownSlowToElement(videoSectionOption,4);
        commonFunctions.clickElement(videoSectionOption, 5, "Redirect to Videos Section");
        boolean isNewsSubSectionInVideosPage = commonFunctions.isElementDisplayed(newsSubSectionInVideosSection, 5, "News Sub Section Under Videos Section");
        boolean isWorldNewsSubSectionInVideosPage = commonFunctions.isElementDisplayed(worldNewsSubSectionInVideosSection, 5, "News Sub Section Under Videos Section");
        return isNewsSubSectionInVideosPage && isWorldNewsSubSectionInVideosPage;
    }

    @Override
    public boolean appearanceOfVideoSectionPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.scrollDownSlowToElement(videoSectionOption,4);
        commonFunctions.clickElement(videoSectionOption, 5, "Redirect to Videos Section");
        boolean isVideosSectionPageDisplayed = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("VIDEOS");
        boolean isFirstImageStory = commonFunctions.isElementDisplayed(photoStoryTitle, 5, "Photo Image Story in Video Section");
        boolean isVideoPlayIcon = commonFunctions.isElementDisplayed(videoPlayIconInFirstVideoStory, 5, "Video Play Icon");
        boolean isListOfStory = false;
        System.out.println("Value of List of Stories =   " + listOfStories.size());
        if (listOfStories.size() >= 1) {
            isListOfStory = true;
            Utils.logStepInfo(true, "List of Videos are visible");
        } else {
            isListOfStory = false;
            Utils.logStepInfo(false, "List of Videos are not visible");
        }
        return (isVideosSectionPageDisplayed && isFirstImageStory && isListOfStory && isVideoPlayIcon);
    }

    @Override
    public boolean redirectToStoryFromVideoSectionPage() {
        redirectOnVideoSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean redirectToSubsectionOfVideoSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.scrollDownSlowToElement(videoSectionOption,3);
        commonFunctions.clickElement(downArrowButtonVideos, 5, "Arrow Down Button Videos");
        commonFunctions.clickElement(newsSubSectionInVideosSection, 5, "News SubSection in Videos Section");
        boolean isSubSectionHeader = commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("NEWS");
        System.out.println("Count of videos are = " + sectionNamePageList.size());
        boolean isTagVisible = checkAllElementsAreVisible(sectionNamePageList, "NEWS");
        return isSubSectionHeader && isTagVisible;
    }

    @Override
    public boolean redirectOnLifeStyleSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(lifeStyleSectionOption,homeButton);
        commonFunctions.clickElement(lifeStyleSectionOption, 5, "Redirect to Life Style Section");
        boolean isRedirectToLifeStylePage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("LIFESTYLE");
        return isRedirectToLifeStylePage;
    }

    @Override
    public boolean redirectToSubSectionOfLifeStyle() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(lifeStyleSectionOption,homeButton);
        commonFunctions.clickElement(downArrowButtonLifeStyle, 5, "Arrow Button Life Style");
        commonFunctions.clickElement(fashionSubSection, 5, "Fashion SubSection");
        boolean isSubSectionHeader = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("FASHION");
        boolean isTagVisible = checkAllElementsAreVisible(sectionNamePageList, "FASHION");
        return isSubSectionHeader && isTagVisible;
    }

    @Override
    public boolean storyInLifeStyleSection() {
        redirectOnLifeStyleSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean redirectToEducationSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(educationOption,homeButton);
        commonFunctions.clickElement(educationOption, 5, "Redirect to Education Section");
        boolean isRedirectToEducationPage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("EDUCATION");
        return isRedirectToEducationPage;
    }

    @Override
    public boolean subSectionOnEducationSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(educationOption,homeButton);
        commonFunctions.clickElement(educationOption, 5, "Redirect to Education Section");
        boolean examResults = commonFunctions.isElementDisplayed(examResultInEducation, 5, "Exam Result Sub Section");
        boolean competitiveExam = commonFunctions.isElementDisplayed(competitiveExamSubSection, 5, "competitive Exam Sub Section");
        boolean boardExam = commonFunctions.isElementDisplayed(boardExamInEducation, 5, "board Exam Sub Section");
        boolean admissionNews = commonFunctions.isElementDisplayed(admissionNewsInEducation, 5, "Admission News Sub Section");
        return (examResults && competitiveExam && boardExam && admissionNews);
    }

    @Override
    public boolean redirectionOnSportSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(sportOption,homeButton);
        commonFunctions.clickElement(sportOption, 5, "Redirect to Sports Section");
        boolean isRedirectToSportPage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("SPORTS");
        return isRedirectToSportPage;
    }

    @Override
    public boolean redirectToSubSectionFromSportSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 10);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(sportOption,homeButton);
        commonFunctions.clickElement(downArrowButtonSports, 5, "Down Arrow Button Sports");
        boolean subSectionInSports = commonFunctions.isElementDisplayed(cricketInSports, 5, "Cricket SubSction") &&
                commonFunctions.isElementDisplayed(footballInSports, 5, "Football SubSection") &&
                commonFunctions.isElementDisplayed(tennisInSports, 5, "Tennis SubSection") &&
                commonFunctions.isElementDisplayed(otherSportsInSports, 5, "Other Sports");
        commonFunctions.clickElement(cricketInSports, 5, "Cricket in Sport");
        boolean isRedirectToCricketSubSection = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("CRICKET");
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(sportOption,homeButton);
        commonFunctions.clickElement(downArrowButtonSports, 5, "Down Arrow Button Sports");
        commonFunctions.clickElement(footballInSports, 5, "Football Subsection");
        boolean isRedirectToFootballSubSection = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("FOOTBALL");
        return subSectionInSports && isRedirectToCricketSubSection && isRedirectToFootballSubSection;
    }

    @Override
    public boolean redirectToStoryFromSportSection() {
        redirectionOnSportSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean redirectToPhotosSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(photosOption,homeButton);
        commonFunctions.clickElement(photosOption, 5, "Redirect to Photos Section");
        boolean isRedirectToSportPage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("PHOTOS");
        return isRedirectToSportPage;
    }


    @Override
    public boolean appearanceOfPhotosSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.scrollDownToElement(photosOption,homeButton);
        commonFunctions.clickElement(photosOption, 5, "Redirect to Photos Section");
        boolean isPhotosSectionPageDisplayed = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("PHOTOS");
        boolean isFirstImageStory = commonFunctions.isElementDisplayed(photoStoryTitle, 5, "Photo Image Story in Photos Section");
        boolean isListOfStory = false;
        System.out.println("Value of List of Stories =   " + listOfStories.size());
        if (listOfStories.size() >= 1) {
            isListOfStory = true;
            Utils.logStepInfo(true, "List of Photos are visible");
        } else {
            isListOfStory = false;
            Utils.logStepInfo(false, "List of Photos are not visible");
        }
        return (isPhotosSectionPageDisplayed && isFirstImageStory && isListOfStory);
    }

    @Override
    public boolean shareStoryFromSportsSection() {
        redirectionOnSportSection();
        commonFunctions.clickElement(threeDotInFirstStory, 10, "Three dot");
        boolean isShareStoryDisplay = commonFunctions.isElementDisplayed(shareIcon, 10, "Share icon");
        return isShareStoryDisplay;
    }

    @Override
    public boolean photoSectionInDarkMode() {
        boolean isPhotosSectionInDarkMode = false;
        applyDarkMode();
        commonFunctions.clickElement(explore, 10, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(photosSection, "Photos Section");
        isPhotosSectionInDarkMode = commonFunctions.isElementDisplayed(photosSection, 10, "Photos Section Option");
        commonFunctions.clickElement(photosSection, 10, "Photos Section");
        isPhotosSectionInDarkMode &= commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("PHOTOS");
        isPhotosSectionInDarkMode &= commonFunctions.isElementDisplayed(photoStoryTitle, 10, "First Story In Photos Section");
        boolean isListOfStory = false;
        System.out.println("Value of List of Stories =   " + listOfStories.size());
        if (listOfStories.size() >= 1) {
            isListOfStory = true;
            Utils.logStepInfo(true, "List of Photos are visible");
        } else {
            isListOfStory = false;
            Utils.logStepInfo(false, "List of Photos are not visible");
        }
        return isPhotosSectionInDarkMode && isListOfStory;
    }

    @Override
    public boolean redirectToPhotoSectionStory() {
        redirectToPhotosSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean redirectToStoryFromPhotosSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.scrollDownToElement(photosOption,homeButton);
        commonFunctions.clickElement(photosOption, 10, "Redirect to Photos Section");
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean shareStoryFromPhotoSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreBtn, 5, "Explore button");
        commonFunctions.scrollDownToElement(photosOption,homeButton);
        commonFunctions.clickElement(photosOption, 5, "Photos option section from top");
        boolean isCurrentPageIsOfPhotos = commonFunctions.getElementText(pageHeaderName, 5).contains("PHOTOS");
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story Three dot icon");
        boolean isBookmarkOptionDisplay = commonFunctions.isElementDisplayed(shareOptionThreeDot, 5, "Share option after click first story three dot icon");
        commonFunctions.clickElement(shareOptionThreeDot, 5, "Share option after click first story three dot icon");
        boolean isShareSheetDisplayTrue = commonFunctions.isElementDisplayed(shareSheet, 5, "Share sheet after tap on share option");
        commonFunctions.clickElement(shareSheet, 5, "Share sheet after tap on share option");
        boolean isMessageOptionDispOnShareSheet = commonFunctions.isElementDisplayed(messageOptionOnShareSheet, 5, "Message option on Share sheet");
        commonFunctions.clickElement(messageOptionOnShareSheet, 5, "Message option on Share sheet");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        return isCurrentPageIsOfPhotos && isBookmarkOptionDisplay && isShareSheetDisplayTrue && isMessageOptionDispOnShareSheet;
    }

    public boolean checkAllElementsContainsProperValues(List<MobileElement> elementList) {
        boolean isAllElementsContainsProperValues = true;
        for (MobileElement ele : elementList) {
            isAllElementsContainsProperValues &= !commonFunctions.getElementText(ele, 5).isEmpty();
        }
        return isAllElementsContainsProperValues;
    }

    @Override
    public boolean marketStatWidgetAfterFirstStory() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreBtn, 5, "HT Explore button");
        boolean isBussinessOptionAvaialableOnSectionPage = commonFunctions.checkElementVisibilityByScrolling(businessSection, "Bussiness Section Scrolling");
        commonFunctions.clickElement(businessSection, 5, "Business option on Section page");
        boolean isCurrentPageIsBussinessTrue = commonFunctions.getElementText(pageHeaderName, 5).contains("BUSINESS");
        boolean isMarketStatisticsDisplayAfterLeadStoryTrue = commonFunctions.getElementText(marketStatisticsText, 5).contains("Market Statistics");
        return isBussinessOptionAvaialableOnSectionPage && isCurrentPageIsBussinessTrue && isMarketStatisticsDisplayAfterLeadStoryTrue;
    }

    @Override
    public boolean redirectToBusinessSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreBtn, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(businessSection, "Bussiness Section Scrolling");
        commonFunctions.clickElement(businessSection, 5, "Section page");
        return commonFunctions.getElementText(pageHeaderName, 5).contains("BUSINESS");
    }

    @Override
    public boolean marketStatWidgetFourOptions() {
        boolean isMarketWidgetAllFourOptionsDisplayTrue = true;
        redirectToBusinessSection();
        isMarketWidgetAllFourOptionsDisplayTrue &= isElementDisplayWithText(bussinessPageOptions, "BSE SENSEX");
        isMarketWidgetAllFourOptionsDisplayTrue &= isElementDisplayWithText(bussinessPageOptions, "NIFTY 50");
        isMarketWidgetAllFourOptionsDisplayTrue &= isElementDisplayWithText(bussinessPageOptions, "NIFTY BANK");
        isMarketWidgetAllFourOptionsDisplayTrue &= isElementDisplayWithText(bussinessPageOptions, "GOLD");
        return isMarketWidgetAllFourOptionsDisplayTrue;
    }

    @Override
    public boolean checkValuesInMarketStatWidget() {
        marketStatWidgetFourOptions();
        boolean isAllFirstSubMarketConatainsValue = checkAllElementsContainsProperValues(firstSubMarketStatisticsElements);
        boolean isAllSecondSubMarketConatainsValue = checkAllElementsContainsProperValues(secondSubMarketStatisticsElements);

        return isAllFirstSubMarketConatainsValue && isAllSecondSubMarketConatainsValue;
    }

    @Override
    public boolean redirectToMumbaiNewsSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreBtn, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(mumbaiNewsSection, "Mumbai News Section Scrolling");
        commonFunctions.clickElement(mumbaiNewsSection, 5, "Mumbai News on Section page");
        return commonFunctions.getElementText(pageHeaderName, 5).contains("MUMBAI NEWS");
    }

    @Override
    public boolean storyDisplayedAfterMarketStatWidget() {
        boolean isRedirectedToBusinessSectionPageTrue = redirectToBusinessSection();
        boolean isMarketStaticsWidgetDisplayAfterLeadStoryTrue = marketStatWidgetFourOptions();
        boolean isFirstStoryAfterMarketStaticsWidgetTrue = commonFunctions.checkElementVisibilityByScrolling(listOfStories.get(0), "Mumbai News Section Scrolling");

        return isRedirectedToBusinessSectionPageTrue && isMarketStaticsWidgetDisplayAfterLeadStoryTrue && isFirstStoryAfterMarketStaticsWidgetTrue;
    }

    @Override
    public boolean checkRedirectToBusinessStory() {
        redirectToBusinessSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean checkRedirectToDelhiNewsSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(delhiNewsSection, "Delhi News Section Scrolling");
        commonFunctions.clickElement(delhiNewsSection, 5, "Delhi News Section page");
        return commonFunctions.getElementText(pageHeaderName, 5).contains("DELHI NEWS");
    }

    @Override
    public boolean redirectToStoryOfMumbaiNewsSection() {
        boolean isRedirectionToStory = redirectToMumbaiNewsSection();
        String firstStoryTitle = commonFunctions.getElementText(listOfStories.get(0), 5);
        commonFunctions.clickElement(listOfStories.get(0), 5, firstStoryTitle);
        commonFunctions.toGetRidOfAd(homeButton, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isRedirectionToCorrentStoryPage = commonFunctions.getElementText(storyTitle, 5).contains(firstStoryTitle);

        return isRedirectionToCorrentStoryPage && isRedirectionToStory;
    }

    @Override
    public boolean checkRedirectToStoryFromDelhiNewsSection() {
        checkRedirectToDelhiNewsSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean checkRedirectToTvNewsSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreBtn, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(tvNews, "TV News Section Scrolling");
        commonFunctions.clickElement(tvNews, 5, "TV News on Section page");
        return commonFunctions.getElementText(pageHeaderName, 5).contains("TV");
    }

    @Override
    public boolean checkRedirectToStoryFromTTvNewsSection() {
        checkRedirectToTvNewsSection();
        return checkRedirectToStoryFromSection();
    }

    @Override
    public boolean checkCameraIconWithNumberOfPhotosInPhotosSection() {
        redirectToPhotosSection();
        boolean isnumDisplayedInLeadStory = commonFunctions.isElementDisplayed(countOfPhotos.get(0),5,"Count of Photos in Lead Story");
        String numOfPhoto = countOfPhotos.get(0).getText();
        System.out.println("Total Count of Photots = " +Integer.parseInt(numOfPhoto));
        return isnumDisplayedInLeadStory;
    }

    @Override
    public boolean countInleadStoryInPhotosSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore, 5, "Explore");
        commonFunctions.scrollDownToElement(photosOption,homeButton);
        commonFunctions.clickElement(photosOption, 5, "Redirect to Photos Section");
        boolean isRedirectToSportPage = commonFunctions.getElementText(sectionPageHeader).equalsIgnoreCase("PHOTOS");
        boolean isnumDisplayedInLeadStory = commonFunctions.isElementDisplayed(countOfPhotos.get(0),5,"Count of Photos in Lead Story");
        System.out.println("Total Count of Photots = " +Integer.parseInt(countOfPhotos.get(0).getText()));
        return isRedirectToSportPage && isnumDisplayedInLeadStory;
    }

    @Override
    public boolean checkWebStoriesSectionFromTopSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        int i = 0;
        while(commonFunctions.isElementNotDisplayed(webStoriesSection,5,"Web Stories")){
            commonFunctions.swipeElementUsingTouchAction(959,306,240,303);
            Utils.logStepInfo(true,(i+1)+" times swipe for Element");
            i++;
            if(i >= 5){
                Utils.logStepInfo(true,"Element not Available in top Section");
                break;
            }
        }
        boolean isWebStoriesDisplayed = commonFunctions.isElementDisplayed(webStoriesSection,5,"Web Stories on Top");
        if(isWebStoriesDisplayed){
            commonFunctions.clickElement(webStoriesSection,5,"Web Stories");
        }
        boolean IsStoriesDisplayedInWebStories = false;
        if (allStoriesInWebStoriesPage.size() >= 1) {
            IsStoriesDisplayedInWebStories = true;
            Utils.logStepInfo(true, "Stories are visible");
        } else {
            IsStoriesDisplayedInWebStories = false;
            Utils.logStepInfo(false, "Stories are not visible");
        }
        return isWebStoriesDisplayed && IsStoriesDisplayedInWebStories;
    }

    @Override
    public boolean checkWebStoriesSectionFromExplore() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(explore,5,"Explore");
        boolean isWebStoriesDisplayed = commonFunctions.isElementDisplayed(webStoriesSection,5,"Web Stories on Top");
        if(isWebStoriesDisplayed){
            commonFunctions.clickElement(webStoriesSection,5,"Web Stories");
        }
        boolean IsStoriesDisplayedInWebStories = false;
        if (allStoriesInWebStoriesPage.size() >= 1) {
            IsStoriesDisplayedInWebStories = true;
            Utils.logStepInfo(true, "Stories are visible");
        } else {
            IsStoriesDisplayedInWebStories = false;
            Utils.logStepInfo(false, "Stories are not visible");
        }
        return isWebStoriesDisplayed && IsStoriesDisplayedInWebStories;
    }

    @Override
    public boolean checkImagesHorizontalLinesInWebStories() {
        boolean isRedirectToWebStoriesFromTop = checkWebStoriesSectionFromTopSection();
        boolean IsHorizontalLinesInAllStories = false;
        if (allStoriesInWebStoriesPage.size() == allhorizontalLinesInWebStories.size()) {
            IsHorizontalLinesInAllStories = true;
            Utils.logStepInfo(true, "Images horizontal lines are displayed in all Web Stories");
        } else {
            IsHorizontalLinesInAllStories = false;
            Utils.logStepInfo(false, "Images horizontal lines displayed failed");
        }
        return isRedirectToWebStoriesFromTop && IsHorizontalLinesInAllStories;
    }

    @Override
    public boolean checkAppLogoInWebStories() {
        boolean isRedirectToWebStoriesFromTop = checkWebStoriesSectionFromTopSection();
        boolean isHtLogosInWebStories = commonFunctions.compareWithSizeListOfElements(htLogosInWebStories,2,"HT logos in Web Stories Page");
        boolean isWebStoriesDisplayed = commonFunctions.compareWithSizeListOfElements(threeDotInAllWebStories,2,"Stories in Web Stories Section");
        Utils.logStepInfo("Number of HT Logo Displayed in Web Stories = "+htLogosInWebStories.size());
        Utils.logStepInfo("Number of Stories Displayed in Web Stories = "+threeDotInAllWebStories.size());
        boolean isLogoCountsMatchWithWebStories = htLogosInWebStories.size() == threeDotInAllWebStories.size();
        Utils.logStepInfo(true,"isRedirectToWebStoriesFromTop = "+isRedirectToWebStoriesFromTop);
        Utils.logStepInfo(true,"isHtLogosInWebStories = "+isHtLogosInWebStories);
        Utils.logStepInfo(true,"isWebStoriesDisplayed = "+isWebStoriesDisplayed);
        Utils.logStepInfo(true,"isLogoCountsMatchWithWebStories = "+isLogoCountsMatchWithWebStories);
        commonFunctionsMobile.getBackToTopInAndroid(homeButton,quickReads);
        return isRedirectToWebStoriesFromTop && isHtLogosInWebStories && isWebStoriesDisplayed && isLogoCountsMatchWithWebStories;
    }

    @Override
    public boolean checkThreeDotsDislpayedInWebStories() {
        boolean isRedirectToWebStoriesFromTop = checkWebStoriesSectionFromTopSection();
        boolean isStoriesInWebStories = commonFunctions.compareWithSizeListOfElements(threeDotInAllWebStories,2,"Three dots In Web Stories Page");
        Utils.logStepInfo("Number of Stories Displayed in Web Stories = "+allStoriesInWebStoriesPage.size());
        Utils.logStepInfo("Number of Three Dots Displayed in Web Stories = "+threeDotInAllWebStories.size());
        boolean isThreeDotsCountsMatchWithWebStories = allStoriesInWebStoriesPage.size() == threeDotInAllWebStories.size();
        return isRedirectToWebStoriesFromTop && isStoriesInWebStories && isThreeDotsCountsMatchWithWebStories;
    }


    public boolean isElementDisplayWithText(List<MobileElement> elementList, String expecteText) {
        boolean isElementDisplayTrue = false;
        for (MobileElement ele : elementList) {
            if (commonFunctions.getElementText(ele, 5).contains(expecteText)) {
                isElementDisplayTrue = true;
                break;
            }
        }
        return isElementDisplayTrue;
    }

    public boolean scrollDownToElement(MobileElement elementToScroll) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < 20; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                if (commonFunctions.isElementDisplayed(elementToScroll, 5, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public boolean checkRedirectToStoryFromSection(){
        String firstStory = photoStoryTitle.getText();
        System.out.println("First Story Heading is --- " + firstStory);
        commonFunctions.clickElement(clickFirstStory, 5, "Click First Story");
        commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(537, 515);//As skip/next button in the prompt locator is not available
        boolean isStoryTitle = commonFunctions.getElementText(storyTitle, 10).equalsIgnoreCase(firstStory);
        return isStoryTitle;
    }

    public void applyDarkMode(){
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(displayTextSize, 5, "Display & Text Size");
        commonFunctions.clickElement(darkThemes, 5, "Dark Theme");
        commonFunctions.dummyWait(5);
    }

    @Override
    public boolean checkRedirectionOnForYouSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(forYouSectionTab,5,"For You tab");
        boolean isForYouTabSelected = commonFunctions.isElementSelected(forYouSectionTab,5,"For You Tab");
        return isForYouTabSelected;
    }

    @Override
    public boolean checkEditProfilePageInDarkMode() {
        applyDarkMode();
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        if(commonFunctions.isElementDisplayed(editProfile,5,"Edit Profile")){
            commonFunctions.clickElement(editProfile,5,"Edit profile");
        }
        boolean isEditProfileInDarkMode = commonFunctions.getElementText(sectionPageHeader,5).equalsIgnoreCase("EDIT PROFILE");
        isEditProfileInDarkMode &= commonFunctions.isElementDisplayed(emailCaptionInEditProfile,5,"Email Caption In Dark Mode");
        isEditProfileInDarkMode &= commonFunctions.isElementDisplayed(phoneCaptionInEditProfile,5,"Phone Caption In Dark Mode");
        isEditProfileInDarkMode &= commonFunctions.isElementDisplayed(nameCaptionInEditProfile,5,"Name Caption In Dark Mode");
        isEditProfileInDarkMode &= commonFunctions.isElementDisplayed(genderCaptionInEditProfile,5,"Gender Caption In Dark Mode");
        isEditProfileInDarkMode &= commonFunctions.isElementDisplayed(passwordCaptionInEditProfile,5,"Password Caption In Dark Mode");
        return isEditProfileInDarkMode;
    }

    @Override
    public boolean checkTextOnCityPopUp() {
        boolean isCitiesSectionDisplay = commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitiesSectionDisplay;
    }

    @Override
    public boolean checkRedirectionOnCitiesSection() {
        boolean isCitiesSectionDisplay = commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isAddYourFavouriteCitiesDisplayed = commonFunctions.isElementDisplayed(addFavouriteCities,5,"Add your favourite cities");
        commonFunctions.scrollDownSlowToElement(mayBeLaterButtonOnCitiesSection,5);
        commonFunctions.clickElement(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"First section");
        return isCitiesSectionDisplay && isAddYourFavouriteCitiesDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTapOnGotItButton() {
        return checkRedirectionOnCitiesSection();
    }

    @Override
    public boolean checkNoRedirectionWhenTapOnWhenAnyWhereExceptGotItButton() {
        checkTextOnCityPopUp();
        commonFunctions.clickElement(popUpOnCities,5,"Tap anywhere on cities pop up except got it button");
        boolean isRedirectedToCitiesSection = commonFunctions.isElementDisplayed(addFavouriteCities,5,"Add to favourite cities");
        if(isRedirectedToCitiesSection == false) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkPlusSignDisplayBeforeCityName() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isPlusSignDisplayedBeforeCityName = commonFunctions.isElementDisplayed(plusSignBeforeCity,5,"\"+\" sign before city name");
        commonFunctions.clickElement(mayBeLaterButtonOnCitiesSection,5,"may be later button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isPlusSignDisplayedBeforeCityName;
    }

    @Override
    public boolean checkHorizontalLinesAtEndOfCityName() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isHorizontalLinesDisplayedAfterCityName = commonFunctions.isElementDisplayed(horizontalLinesTab,5,"Horizontal lines at the end of city name");
        commonFunctions.clickElementIfDisplayed(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isHorizontalLinesDisplayedAfterCityName;
    }

    @Override
    public boolean checkMayBeLaterAndSaveChangesButton() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isMayBeLaterButtonDisplayed = commonFunctions.isElementDisplayed(mayBeLaterButtonOnCitiesSection, 5, "May be later button at the end of screen");
        boolean isSaveChangesButtonDisplayed = commonFunctions.isElementPresent(saveChangesButtonOnCitiesSection, 5, "Save changes button at the end of screen");
        commonFunctions.clickElementIfDisplayed(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isMayBeLaterButtonDisplayed && isSaveChangesButtonDisplayed;
    }

    @Override
    public boolean checkOthersOptionInCities() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.checkElementVisibilityByScrolling(othersOptionInCities,"Others option in cities");
        boolean isOthersDisplayed = commonFunctions.isElementDisplayed(othersOptionInCities,5,"Others option in cities");
        commonFunctions.clickElement(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isOthersDisplayed;
    }

    @Override
    public boolean checkBehaviourWhenUserTapsOnPlusButtonBeforeCityName() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElement(plusSignBeforeCity,5,"Select any city in cities");
        boolean isSaveChangesEnabled = commonFunctions.isElementClickable(saveChangesButtonOnCitiesSection,5,"Save Changes enable");
        commonFunctions.clickElement(plusSignBeforeCity,5,"Unselect a selected city in cities");
        commonFunctions.clickElementIfDisplayed(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isSaveChangesEnabled;
    }

    @Override
    public boolean checkBehaviourWhenUserTapsOnMayBeLaterButton() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElement(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        boolean isAddCitiesDisplayed = commonFunctions.isElementDisplayed(addCitiesOption,5,"Add cities option");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isAddCitiesDisplayed;
    }

    @Override
    public boolean checkBehaviourNoCitySelectedAndTapsOnSaveChangesButton() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save Changes Button");
        boolean isAddYourFavouriteCitiesDisplayed = commonFunctions.isElementDisplayed(addFavouriteCities,5,"Add your favourite cities");
        commonFunctions.clickElementIfDisplayed(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isAddYourFavouriteCitiesDisplayed;
    }

    @Override
    public boolean checkPopUpWhenSelectAnyCity() {
        boolean isRedirect = commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida city",saveChangesButtonOnCitiesSection);
        commonFunctions.dummyWait(1);
        String pageSource = driver.getPageSource();
        boolean isCitySuccessfulPopUpVerified = pageSource.contains("City selected");
        if(isCitySuccessfulPopUpVerified){
            Utils.logStepInfo(true,"City Pop up verified successfully !!!");
        }
        else{
            Utils.logStepInfo(false,"City Pop up verification Failed !!!");
        }
        Utils.logStepInfo(true,"isCitySuccessfulPopUpVerified = "+isCitySuccessfulPopUpVerified);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Deselect Noida city",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitySuccessfulPopUpVerified && isRedirect;
    }

    @Override
    public boolean checkSelectedCityShownUnderCitiesSection() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isSelectedCityDisplayed = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isSelectedCityDisplayed;
    }

    @Override
    public boolean checkBehaviourWhenUserSelectAnyCityAndTapsOnMayBeLaterButton() { return false; }

    @Override
    public boolean checkDateInCitiesAfterSelectedCity() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        boolean isDateDisplayed = commonFunctions.isElementDisplayed(dateOnSelectedCity,5,"Date after selected city");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitySelected && isDateDisplayed;
    }

    @Override
    public boolean checkTemperatureDisplayedInCitiesSection() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        boolean isTemperatureDisplayed = commonFunctions.isElementDisplayed(temperatureInCities,5,"Temperature");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitySelected && isTemperatureDisplayed;
    }

    @Override
    public boolean checkCityNameDisplayedAfterAdWithNews() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctions.isElementDisplayed(adInCities,10,"Advertisement in cities before city name");
        boolean isCityNameDisplayedWithNews = commonFunctions.isElementDisplayed(citiNameWithNews,5,"City name with news");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitySelected && isCityNameDisplayedWithNews;
    }

    @Override
    public boolean checkRedirectionWhenTapOnOtherSelectedCities() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        isCitySelected &= commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida city",saveChangesButtonOnCitiesSection);
        commonFunctions.clickElement(noidaCitySelectButton,5,"Noida city");
        boolean isNoidaNewsDisplayed = commonFunctions.getElementTextAndCheck(citiNameWithNews,"Noida News",5,"City name with news");
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida city",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitySelected && isNoidaNewsDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTapOnMultipleCities() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.clickElement(delhiSelectButton,5,"Deselect selected city");
        commonFunctions.clickElement(listOfCitiesInSection.get(1),5,"Select Second city");
        commonFunctions.clickElement(listOfCitiesInSection.get(0),5,"Select First city");
        String nameOfFirstCity = commonFunctions.getElementText(listOfCitiesInSection.get(0),5);
        commonFunctions.scrollDownSlowToElement(mayBeLaterButtonOnCitiesSection,5);
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes");
        boolean isFirstCitySelected = commonFunctions.getElementTextAndCheck(citiNameWithNews,nameOfFirstCity+" News",5,"First selected city");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.clickElement(listOfCitiesInSection.get(1),5,"Deselect Second selected city");
        commonFunctions.scrollDownSlowToElement(mayBeLaterButtonOnCitiesSection,5);
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitySelected && isFirstCitySelected;
    }

    @Override
    public boolean checkBehaviourWhenUserDeselectAnySelectedCity() {
        commonFunctionsMobile.checkTextOnCitiesSection(homeButton,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.scrollDownSlowToElement(mayBeLaterButtonOnCitiesSection,5);
        commonFunctions.clickElementsByList(listOfCitiesInSection,1,3,5,"Select city");
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes");
        boolean isMumbaiCityDisplayed = commonFunctions.isElementDisplayed(mumbaiCitySelectButton,5,"Mumbai city in L2");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities button");
        commonFunctions.scrollDownSlowToElement(mayBeLaterButtonOnCitiesSection,5);
        commonFunctions.clickElement(mumbaiCitySelectButton,5,"Mumbai city deselect button");
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes button");
        boolean isMumbaiCityNotDisplayed = commonFunctions.isElementNotDisplayed(mumbaiCitySelectButton,5,"Mumbai city in L2");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.scrollDownSlowToElement(mayBeLaterButtonOnCitiesSection,5);
        commonFunctions.clickElementsByList(listOfCitiesInSection,1,2,5,"Deselect selected Cities");
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes button");
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewSection,"Top news");
        return isCitySelected && isMumbaiCityDisplayed && isMumbaiCityNotDisplayed;
    }

    @Override
    public boolean checkViewFullScorecard(String cricketUrl, String liveScorecard) {
        return false;
    }

    @Override
    public boolean checkMatchCard(String cricketUrl) {
        return false;
    }

    @Override
    public boolean checkLHSAndRHSData(String indiaNewsUrl) {
        return false;
    }

    @Override
    public boolean checkPagination(String secondPageUrl,String worldNewsUrl) {
        return false;
    }

    @Override
    public boolean checkThirtyStoryOnSectionPage(String worldNewsUrl) {
        return false;
    }

    @Override
    public boolean checkAdsAfterEveryThreeStory() {
        return false;
    }

    @Override
    public boolean checkFourthStoryPartneredStory() {
        return false;
    }

    @Override
    public boolean checkFirstStoryInCardView() {
        return false;
    }
}

