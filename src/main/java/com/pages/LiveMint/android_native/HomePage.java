
package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonHomePage {

    //    private AndroidDriver driver;
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @FindBy(xpath = "//a[@title='Notification']/span")
    private static MobileElement notificationBell;
    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;
    @AndroidFindBy(accessibility = "Navigate up")
    private static MobileElement navigateUpButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtSubscribe")
    private static MobileElement subscribeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/ad_headline")
    private static MobileElement brandedContent;
    @AndroidFindBy(id = "com.htmedia.mint:id/layoutContentAdsBG")
    private static MobileElement firstAdHomePage;
    @AndroidFindBy(id = "com.htmedia.mint:id/imageViewAppLogo")
    private static MobileElement mintLogo;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement chooseAPlanButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/collection_title")
    private static MobileElement premiumStories;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]")
    private static MobileElement firstPremiumStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement premiumCollectOfferButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement choosePlansHeader;

    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;

    @FindBy(xpath = "//span[@id='noTCounter']")
    private static MobileElement notificationBadge;
    @FindBy(id = "com.htmedia.mint:id/layoutContentAdsBG")
    private static MobileElement secondBannerAd;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static MobileElement notificationHeading;

    @FindBy(xpath = "//div[@id='notification_new']")
    private static MobileElement notificationNew;

    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement explore;

    @FindBy(xpath = "//h1[text()='BSE SENSEX']")
    private static MobileElement verifyNifty;

    @FindBy(xpath = "//section[@class='mainSec']/h1[text()='Markets']")
    private static MobileElement listMarkets;

    @FindBy(xpath = "(//a[contains(@class,'icoBookmark')])[1]")
    private static MobileElement bookmarkFirstIcon;

    @FindBy(xpath = "(//span/img[@class='lozad fade'])[1]")
    private static MobileElement imageFirstStory;

    @FindBy(xpath = "(//link[@href='https://images.livemint.com/icons/mintfavi.svg'])[1]")
    private static MobileElement favIcon;

    @FindBy(id = "com.htmedia.mint:id/action_profile")
    private static MobileElement myAccount;

    @FindBy(id = "com.htmedia.mint:id/textViewSummary")
    private static MobileElement summary;

    @FindBy(xpath = "(//div[@class='FirstEle']/p)[1]")
    private static MobileElement paragraph;

    @FindBy(xpath = "(//span[@class='articleInfo pubtime'])[1]/span")
    private static MobileElement updatedTimeStamp;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private static MobileElement back;

    @FindBy(id = "com.htmedia.mint:id/imageViewAppLogo")
    private static MobileElement mintTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement planPage;

    @FindBy(xpath = "(//h2[@class='headline'])[1]/a")
    private static MobileElement notificationFirstStory;

    @FindBy(xpath = "//span[contains(@class,'wewidgeticon we_close icon-large')]")
    private static MobileElement closeButtonForUnlimitedDigitalAccessPopup;

    @FindBy(xpath = "//span[contains(@class,'dblock')]/img")
    private static MobileElement firstImage;

    @FindBy(xpath = "(//h2[@class='headline'])[1]/a")
    private static MobileElement firstTitleInPage;

    @FindBy(xpath = "//div[@class='topTxt clearfix']//div[text()[contains(..,'Subscribe to continue reading')]]")
    private static MobileElement subscribeToContinueReading;

    @FindBy(xpath = "//a[text()='Start 15 Days Trial']")
    private static MobileElement start15DaysTrail;

    @FindBy(xpath = "(//span[contains(@class,'exclusive')])[1]")
    private static MobileElement premiumText;

    @FindBy(id = "com.htmedia.mint:id/editTextName")
    private static MobileElement nameTemp;

    @FindBy(id = "com.htmedia.mint:id/btnSave")
    private static MobileElement saveButton;

    @FindBy(xpath = "//div[@id='uName']/strong")
    private static MobileElement accountName;

    @FindBy(id = "com.htmedia.mint:id/radioBtnMale")
    private static MobileElement radioGender;

    @FindBy(id = "com.htmedia.mint:id/old_password_et")
    private static MobileElement enterOldPass;

    @FindBy(id = "com.htmedia.mint:id/new_password_et")
    private static MobileElement enterNewPass;

    @FindBy(id = "com.htmedia.mint:id/confirm_password_et")
    private static MobileElement enterConfirmPass;

    @FindBy(xpath = "//input[@id='btChangePassword']")
    private static MobileElement updateBtn;

    @FindBy(xpath = "//input[@id='btSubmit']")
    private static MobileElement genderSaveBtn;

    @FindBy(xpath = "//input[@value='testinglivemint@gmail.com']")
    private static MobileElement presentEmailId;

    @FindBy(xpath = "//ul[@class='navCategories'][2]/li[3]/a")
    private static MobileElement linkSiteMap;

    @FindBy(id = "com.htmedia.mint:id/txtViewPhone")
    private static MobileElement addYourContactNo;

    @FindBy(xpath = "//div[@id='myAccount']/a[text()='Logout']")
    private static MobileElement logout;

    @FindBy(id = "com.htmedia.mint:id/email")
    private static MobileElement userEmailUsed;

    @FindBy(xpath = "//div[@id='uName']/strong")
    private static MobileElement userName;

    @FindBy(id = "com.htmedia.mint:id/imgViewName")
    private static MobileElement name;

    @FindBy(id = "com.htmedia.mint:id/imgViewPassword")
    private static MobileElement password;

    @FindBy(id = "com.htmedia.mint:id/imgViewGender")
    private static MobileElement gender;

    @FindBy(xpath = "//a[@class='back']")
    private static MobileElement goBack;

    @FindBy(id = "com.htmedia.mint:id/txtViewMyReads")
    private static MobileElement myReads;

    @FindBy(xpath = "//android.widget.TextView[@text='View All']")
    private static MobileElement viewAll;

    @FindBy(xpath = "//android.widget.EditText[@text='Search or type web address']")
    private static MobileElement searchBar;

    @FindBy(xpath = "//android.widget.TextView[@text='https://www.livemint.com']")
    private static MobileElement clickLivemint;

    @FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.android.chrome:id/infobar_close_button']")
    private static MobileElement closeaddtoHomeScreen;

    @FindBy(xpath = "//android.widget.Button[@text='Allow']")
    private static MobileElement allowNotifications;

    @FindBy(xpath = "android.widget.Button[@text='Block']")
    private static MobileElement blockNotifications;

    @FindBy(id = "com.htmedia.mint:id/txtViewEmailCaption")
    private static MobileElement emailID;

    @FindBy(id = "com.htmedia.mint:id/txtViewViewAll")
    private static MobileElement viewAllButton;

    @FindBy(xpath = "//android.widget.TextView[@text='HOME']")
    private static MobileElement homePage;

    @FindBy(xpath = "//android.view.View[@resource-id='close-button-container']")
    private static MobileElement closeAd;

    @FindBy(xpath = "//android.widget.TextView[@text='NOTIFICATION']")
    private static MobileElement listHeading;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY 50']")
    private static MobileElement marketNifty;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.htmedia.mint:id/imageViewAppLogo']")
    private static MobileElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.htmedia.mint:id/txtViewDetailNewsHeadline']")
    private static MobileElement storyPage;

    @FindBy(id = "com.htmedia.mint:id/txtViewClose")
    private static MobileElement closeStory;

    @FindBy(xpath = "//android.view.View[@index=0]")
    private static MobileElement bookmarkPage;

    @FindBy(xpath = "//android.view.View[@index=2]")
    private static MobileElement bookmarkPageLogin;

    @FindBy(xpath = "//android.widget.ImageView[reid='com.htmedia.mint:id/close']")
    private static MobileElement closeMyAccount;

    @FindBy(xpath = "//android.widget.TextView[@text='FOR YOU']")
    private static MobileElement latestPage;

    @FindBy(xpath = "//android.widget.TextView[@text='MARKETS']")
    private static MobileElement trendingPage;

    @FindBy(xpath = "//android.widget.TextView[@text='Remove Ad']")
    private static MobileElement firstAdsRemoveAdButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Advertisement']")
    private static MobileElement firstAdsAdvertisementLabel;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.htmedia.mint:id/txtViewDetailNewsHeadline']")
    private static MobileElement pageContent;

    @FindBy(xpath = "//android.widget.TextView[@text='Bluetooth']")
    private static MobileElement facebookIcon;

    @FindBy(id = "com.htmedia.mint:id/recyclerViewMarketTicker")
    private static MobileElement marketTicker;

    // --------Story Locator -------//
    @FindBy(id = "com.htmedia.mint:id/imgViewHeader")
    private static MobileElement storyImage;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailReadTime")
    private static MobileElement minutesToRead;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailDateTime")
    private static MobileElement timestamp;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement firstStory;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailByLine")
    private static MobileElement storyAuthor;

    @FindBy(id = "com.htmedia.mint:id/textViewSummary")
    private static MobileElement stortSummary;

    @FindBy(id = "com.htmedia.mint:id/imgViewDetailShare")
    private static MobileElement shareIcon;

    @FindBy(xpath = "//android.view.View[@index=2]")
    private static MobileElement whatsappIcon;

    @FindBy(xpath = "(//android.view.View[@index=3]")
    private static MobileElement linkedinIcon;

    @FindBy(xpath = "//android.view.View[@index=4]")
    private static MobileElement twitterIcon;

    @FindBy(xpath = "//android.widget.Button[@text='CANCEL']")
    private static MobileElement cancel;

    @FindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    private static MobileElement loginButton;

    @FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.ImageView[1]")
    private static MobileElement bookmarkIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/action_bookmark")
    private static MobileElement detailPageBookmarkIcon;

    @FindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement loginBox;

    @FindBy(id = "android:id/message")
    private static MobileElement loginPopup;

    @FindBy(id = "agree")
    private static MobileElement acceptCookie;

    @FindBy(xpath = "//android.widget.TextView[@text='\uE902']")
    private static MobileElement closePopUp;

    @FindBy(id = "com.htmedia.mint:id/layoutCloseButton")
    private static MobileElement closeBtn;

    @FindBy(id = "com.htmedia.mint:id/ad_headline")
    private static MobileElement sponsoredStory;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.htmedia.mint:id/imgViewBookmark']")
    private static MobileElement sponsoredStoryBookmarkButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement home;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailImageCaption")
    private static MobileElement imageCaption;

    @FindBy(id = "com.htmedia.mint:id/imgViewBookmark")
    private static MobileElement bookmarkStory;

    @FindBy(id = "com.htmedia.mint:id/tvNewArticle")
    private static MobileElement newArticle;

    @FindBy(id = "com.htmedia.mint:id/txtGainerLoserHeading")
    private static MobileElement gainerLoser;

    @FindBy(id = "com.htmedia.mint:id/txtCommodityName")
    private static MobileElement gainerLoserList;

    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE SENSEX']")
    private static MobileElement marketBSESENSEX;

    @FindBy(xpath = "//android.widget.TextView[@text='Top Gainers']")
    private static MobileElement topGainers;

    @FindBy(xpath = "//android.widget.TextView[@text='Top Losers']")
    private static MobileElement topLosers;

    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE SENSEX']")
    private static MobileElement marketTickerBSESENSEX;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Markets']")
    private static MobileElement marketTab;

    @FindBy(xpath = "//android.widget.TextView[@text='MARKETS']")
    private static MobileElement marketPage;

    @FindBy(xpath = "//android.widget.TextView[@text='Remove Ad']")
    private static MobileElement homePageLeadAd;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY 50']")
    private static MobileElement marketNifty50;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY Bank']")
    private static MobileElement marketNiftyBank;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY Bank']")
    private static MobileElement niftyBank;

    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE Midcap']")
    private static MobileElement marketBSEMIDCAP;

    @FindBy(xpath = "//android.widget.TextView[@text='GOLD']")
    private static MobileElement marketGOLD;

    @FindBy(xpath = "//android.widget.TextView[@text='SILVER']")
    private static MobileElement marketSILVER;

    @FindBy(xpath = "//android.widget.TextView[@text='INDIAN INDICES']")
    private static MobileElement indianIndices;

    @FindBy(xpath = "//android.widget.TextView[@text='INDICES']")
    private static MobileElement indicesHeader;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'CHANGE')]")
    private static MobileElement priceAndChange;

    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE 100']")
    private static MobileElement bse100;
    @FindBy(xpath = "//android.widget.TextView[contains(@text,'BSE 200')]")
    private static MobileElement bse200;
    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE 500']")
    private static MobileElement bse500;
    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Bankex')]")
    private static MobileElement bankex;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Auto')]")
    private static MobileElement auto;

    @FindBy(xpath = "//android.widget.TextView[@text='NEWS - S&P BSE 100']")
    private static MobileElement newsBse100;

    @FindBy(id = "com.htmedia.mint:id/indAmount")
    private static MobileElement marketSENSEXIndex;

    @FindBy(id = "com.htmedia.mint:id/txtCommodityName")
    private static MobileElement stock;

    @FindBy(id = "com.htmedia.mint:id/txtCurrentPrice")
    private static MobileElement currentPrice;

    @FindBy(id = "com.htmedia.mint:id/txtPercentChange")
    private static MobileElement percerntChange;

    @FindBy(id = "com.htmedia.mint:id/txtCommodityValue")
    private static MobileElement marketGoldIndex;

    @FindBy(xpath = "//android.widget.TextView[@text='Back']")
    private static MobileElement backBtn;

    @FindBy(id = "com.htmedia.mint:id/nav_latest")
    private static MobileElement latest;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Markets']")
    private static MobileElement market;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Premium']")
    private static MobileElement premium;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY Bank']")
    private static MobileElement niftyBankDetailPage;

    @FindBy(id = "com.htmedia.mint:id/imgViewShare")
    private static MobileElement shareIconUnderStory;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.htmedia.mint:id/imgViewShare'])[1]")
    private static MobileElement shareIconUnderDiffTab;

    @FindBy(id = "com.htmedia.mint:id/txtViewClose")
    private static MobileElement closeFloat;

    @FindBy(id = "//android.widget.TextView[@text='WhatsApp']")
    private static MobileElement whatsappPage;

    @FindBy(id = "com.htmedia.mint:id/txtViewSearch")
    private static MobileElement search;

    @FindBy(id = "com.htmedia.mint:id/searchEditText")
    private static MobileElement textSearch;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement searchResult;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.htmedia.mint:id/txtViewDetailNewsHeadline']")
    private static MobileElement searchResultOutput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.htmedia.mint:id/txtViewDetailNewsHeadline']")
    private static MobileElement searchNotificationResult;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.htmedia.mint:id/txtViewNewsHeadline'])[2]")
    private static MobileElement firstNotification;

    @FindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement premiumTitle;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.htmedia.mint:id/txtViewNewsHeadline'])[1]")
    private static MobileElement premiumFirstStory;

    @FindBy(id = "com.htmedia.mint:id/detail_premium_tag_tv")
    private static MobileElement premiumTag;
    @FindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement subscribeNow;
    //com.htmedia.mint:id/txt2
    //com.htmedia.mint:id/imgViewOffer
    //com.htmedia.mint:id/btnSubscribe
    @FindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private static MobileElement messagesIcon;
    @FindBy(xpath = "//android.widget.Button[@text='CREATE NEW FACEBOOK ACCOUNT']")
    private static MobileElement createFacebookAccount;
    @FindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement closeEditProfile;
    @FindBy(id = "com.htmedia.mint:id/carausolScrollView")
    private static MobileElement bookmarkScrollView;
    @FindBy(id = "com.htmedia.mint:id/imgViewBookmark_inner_collection")
    private static MobileElement bookmarkedIcon;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='News']")
    private static MobileElement news;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.htmedia.mint:id/group_indicator'])[3]")
    private static MobileElement marketsArrowBtn;
    @FindBy(xpath = "//android.widget.TextView[@text='Stock Markets']")
    private static MobileElement stockMarkets;
    @FindBy(id = "android:id/title")
    private static MobileElement ShareHeading;
    @FindBy(xpath = "//android.widget.Button[@text='NEW MESSAGE']")
    private static MobileElement newMessage;
    @FindBy(xpath = "//android.widget.Button[@text='CANCEL']")
    private static MobileElement cancelMessage;
    @FindBy(id = "com.htmedia.mint:id/txtTrendingTopic")
    private static MobileElement trendingTopics;
    @FindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static MobileElement stories;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.htmedia.mint:id/txtViewNewsHeadline']")
    private static MobileElement selectFirstStory;
    @FindBy(xpath = "//a[@class='LinkCTA']")
    private static MobileElement myReads2;
    @FindBy(id = "com.htmedia.mint:id/btnEditProfile")
    private static MobileElement editProfile;
    @FindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement landingPage;
    @FindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private static MobileElement privacyPolicy;
    @FindBy(xpath = "//android.widget.TextView[@text='Terms of Use']")
    private static MobileElement termsOfUse;
    @FindBy(xpath = "//android.widget.TextView[@text='Cookie Policy']")
    private static MobileElement cookiePolicy;
    @FindBy(xpath = "//android.widget.TextView[@text='Subscriber Agreement']")
    private static MobileElement subscriberAgreement;

    @FindBy(id = "com.htmedia.mint:id/txtViewName")
    private static MobileElement editedName;
    @FindBy(id = "com.htmedia.mint:id/continue_btn")
    private static MobileElement reset;
    @FindBy(id = "com.htmedia.mint:id/imgViewHeader")
    private static MobileElement imageUnderTitle;
    @FindBy(id = "com.htmedia.mint:id/txtSummary")
    private static MobileElement apiSummary;
    @FindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
    private static MobileElement editProfilePage;
    @FindBy(id = "com.htmedia.mint:id/radioBtnFemale")
    private static MobileElement femaleGenderRadioButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Female']")
    private static MobileElement female;
    @FindBy(id = "com.htmedia.mint:id/radioBtnMale")
    private static MobileElement maleGenderRadioButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Male']")
    private static MobileElement male;
    @FindBy(className = "android.widget.ImageButton")
    private static MobileElement backArrow;
    @FindBy(id = "com.htmedia.mint:id/collection_container")
    private static MobileElement BookmarkSwiperBox;
    @FindBy(id = "com.htmedia.mint:id/title_inner_collection")
    private static List<MobileElement> bookmarksSwiperBoxElementsList;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.htmedia.mint:id/imgViewBookmark_inner_collection'])[1]")
    private static MobileElement bookmarkIconInSwiperBox;
    @FindBy(xpath = "//android.widget.TextView[@text='STORIES']")
    private static MobileElement StoriesInSwiperBox;
    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE SENSEX']")
    private static MobileElement marketBseSensexLandingPage;
    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE Midcap']")
    private static MobileElement marketBseMidCapLandingPage;
    @FindBy(xpath = "(//android.widget.TextView[@text='GOLD'])[1]")
    private static MobileElement marketGoldLandingPage;
    @FindBy(xpath = "(//android.widget.TextView[@text='SILVER'])[1]")
    private static MobileElement marketSilverLandingPage;
    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY 50']")
    private static MobileElement marketNifty50LandingPage;
    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY Bank']")
    private static MobileElement marketNiftyBankLandingPage;
    @FindBy(id = "com.htmedia.mint:id/txtViewCommodity")
    private static List<MobileElement> marketTickerElementsList;
    @FindBy(id = "com.htmedia.mint:id/tvEpaper")
    private static MobileElement e_paperLink;
    @FindBy(id = "com.htmedia.mint:id/action_signin")
    private static MobileElement signInButton;
    @FindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement emailInbox;
    @FindBy(id = "com.htmedia.mint:id/continue_btn")
    private static MobileElement emailContinueButton;
    @FindBy(id = "com.htmedia.mint:id/password_et")
    private static MobileElement passwordInbox;
    @FindBy(id = "com.htmedia.mint:id/continue_btn")
    private static List<MobileElement> passwordContinueButton;
    @FindBy(id = "android:id/button1")
    private static MobileElement okRefreshButton;
    @FindBy(id = "com.htmedia.mint:id/open_epaper")
    private static MobileElement mintEpaperBannerButtonID;
    @FindBy(xpath = "//android.widget.Button[@text='Later')")
    private static MobileElement closeButtonOnWelcomeBackPopup;
    @FindBy(xpath = "//android.widget.TextView[text()='Try Mint E-paper']")
    private static MobileElement mintEpaperBannerButton;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Mint epaper 29 Nov 2021\"]/android.widget.Image")
    private static MobileElement e_paperMainPageLogo;
    @FindBy(xpath = "//android.widget.TextView[@text='Choose a plan']")
    private static MobileElement subscribeChoosePlanText;
    @FindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement darkModeYes;
    @FindBy(id = "com.htmedia.mint:id/login_heading_tv")
    private static MobileElement loginOrRegisterText;
    @FindBy(xpath = "//android.widget.TextView[@text='Google']")
    private static MobileElement continueWithGoogleButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Facebook']")
    private static MobileElement continueWithFacebookButton;
    @FindBy(id = "com.htmedia.mint:id/txtAppleTV")
    private static MobileElement continueWithAppleButton;
    @FindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement loginWithEmailOrMobile;
    @FindBy(id = "com.htmedia.mint:id/imgWsjLogo")
    private static MobileElement wsjLogo;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/imgWsjLogo']/following::*[@resource-id='com.htmedia.mint:id/title_inner_collection']")
    private static List<MobileElement> firstStoryWsj;
    @FindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement firstStoryHeadline;
    @FindBy(id = "com.htmedia.mint:id/tvClickHereHeader")
    private static MobileElement removeAd;
    @FindBy(id = "com.htmedia.mint:id/collection_image")
    private static MobileElement mintLoungeCarousel;
    @FindBy(xpath = "//android.widget.Image[@text='Mint Lounge']")
    private static MobileElement MintLoungeHeader;
    @FindBy(xpath = "//android.widget.Image[@text='logo']")
    private static MobileElement ePaperWebPageMintLogo;
    @FindBy(xpath = "//android.widget.Image[@text='opt-img-3']")
    private static MobileElement mintGenieBanner;
    @FindBy(xpath = "//android.widget.Image[@text='Mintgenie']")
    private static MobileElement mintGenieWebPageLogo;
    @FindBy(xpath = "//android.widget.TextView[@text='1D']")
    private static MobileElement graph1Day;
    @FindBy(xpath = "//android.widget.TextView[@text='5D']")
    private static MobileElement graph5Days;
    @FindBy(xpath = "//android.widget.TextView[@text='1M']")
    private static MobileElement graph1Month;
    @FindBy(xpath = "//android.widget.TextView[@text='1Y']")
    private static MobileElement graph1Year;
    @FindBy(xpath = "//android.widget.TextView[@text='5Y']")
    private static MobileElement graph5Year;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @FindBy(id = "com.htmedia.mint:id/ind_open_price")
    private static MobileElement openingPrice;
    @FindBy(id = "com.htmedia.mint:id/prevCloseLabel")
    private static MobileElement prevClosingPrice;
    @FindBy(id = "com.htmedia.mint:id/dayHighLabel")
    private static MobileElement dayHighPrice;
    @FindBy(id = "com.htmedia.mint:id/dayLowLabel")
    private static MobileElement dayLowPrice;
    @FindBy(id = "com.htmedia.mint:id/WH52Label")
    private static MobileElement yearHighPrice;
    @FindBy(id = "com.htmedia.mint:id/WH52Label")
    private static MobileElement yearLowPrice;
    @FindBy(id = "com.htmedia.mint:id/financialsHeading")
    private static MobileElement financials;
    @FindBy(xpath = "//android.widget.TextView[@text='Chrome']")
    private static MobileElement chromeBrowserOption;
    @FindBy(id = "android:id/button_once")
    private static MobileElement justOnce;
    @FindBy(id = "com.htmedia.mint:id/chart")
    private static MobileElement lineGraph;
    @FindBy(id = "com.android.chrome:id/negative_button")
    private static MobileElement mintGenieNotificationBlock;
    @FindBy(id = "com.htmedia.mint:id/txtViewTitleExplore")
    private static MobileElement explorePageText;
    @FindBy(xpath = "//android.widget.TextView[@text='View All']")
    private static MobileElement bookmarkViewAll;
    @FindBy(xpath = "//android.widget.TextView[@text='MINT PREMIUM']//following::android.widget.TextView[@text='View All']")
    private static MobileElement mintPremium;
    @FindBy(xpath = "(//android.widget.TextView[@text='View all'])[1]")
    private static MobileElement viewAllTopGainers;
    @FindBy(xpath = "(//android.widget.TextView[@text='BSE'])[2]")
    private static MobileElement bseStockDetail;
    @FindBy(xpath = "(//android.widget.TextView[@text='NSE'])[2]")
    private static MobileElement nseStockDetail;
    @FindBy(xpath = "//android.widget.TextView[@text='TOP GAINERS']")
    private static MobileElement topGainersHeader;
    @FindBy(xpath = "(//android.widget.TextView[@text='View all'])[2]")
    private static MobileElement viewAllTopLosers;
    @FindBy(id = "com.htmedia.mint:id/layoutBse")
    private static MobileElement bseGainerLoser;
    @FindBy(id = "com.htmedia.mint:id/layoutNse")
    private static MobileElement nseGainerLoser;
    @FindBy(xpath = "(//android.widget.TextView[@text='TOP GAINERS'])[1]")
    private static MobileElement topGainerPage;
    @FindBy(xpath = "(//android.widget.TextView[@text='TOP LOSERS'])[1]")
    private static MobileElement topLosersPage;
    @FindBy(id = "com.htmedia.mint:id/recyclerViewMarketDetail")
    private static MobileElement listOfTopGainerCompany;
    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView)[3]/android.widget.LinearLayout")
    private static MobileElement listOfTop4GainerCompany;
    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView)[4]/android.widget.LinearLayout")
    private static MobileElement listOfTop4LoserCompany;
    @FindBy(id = "com.htmedia.mint:id/layoutBg")
    private static List<MobileElement> listOfTop4CompanySeperateCards;
    @FindBy(id = "com.htmedia.mint:id/txtUpdatedDate")
    private static MobileElement updateTime;
    @FindBy(xpath = "//android.widget.TextView[@text='MOST ACTIVE BY VOLUME']")
    private static MobileElement mostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/layoutBse")
    private static MobileElement bseTagMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/layoutNse")
    private static MobileElement nseTagMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/txtUpdatedDate")
    private static MobileElement updateStatusMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/txt_security")
    private static MobileElement securityTagMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/txt_volume")
    private static MobileElement volumeTagMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/txt_change")
    private static MobileElement changeTagMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/recyclerview_most_active")
    private static MobileElement topFourMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/security")
    private static List<MobileElement> topFirstMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/viewAll")
    private static MobileElement mostActiveByVolumeViewAll;
    @FindBy(xpath = "(//android.widget.TextView[@text='MOST ACTIVE BY VOLUME'])[2]")
    private static MobileElement mostActiveByVolumeOnDetailPage;
    @FindBy(xpath = "(//android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView[2])[2]")
    private static MobileElement secondVolMostActiveByVolumeOnDetailPage;
    @FindBy(xpath = "(//android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2])[2]")
    private static MobileElement firstVolMostActiveByVolumeOnDetailPage;
    @FindBy(id = "com.htmedia.mint:id/companySName")
    private static MobileElement smallCompanyNameOnMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/companyDName")
    private static MobileElement fullCompanyNameOnMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/indAmount")
    private static MobileElement priceOnMostActiveByVolume;
    @FindBy(xpath = "//android.widget.TextView[@text='1D']")
    private static MobileElement oneDTag;
    @FindBy(xpath = "//android.widget.TextView[@text='5D']")
    private static MobileElement fiveDTag;
    @FindBy(xpath = "//android.widget.TextView[@text='1M']")
    private static MobileElement oneMTag;
    @FindBy(xpath = "//android.widget.TextView[@text='1Y']")
    private static MobileElement oneYTag;
    @FindBy(xpath = "//android.widget.TextView[@text='5Y']")
    private static MobileElement fiveYTag;
    @FindBy(id = "com.htmedia.mint:id/chart")
    private static MobileElement chartSection;
    @FindBy(id = "com.htmedia.mint:id/ind_open_price_label")
    private static MobileElement openPriceLabel;
    @FindBy(id = "com.htmedia.mint:id/dayHighLabel")
    private static MobileElement dayHighLabel;
    @FindBy(id = "com.htmedia.mint:id/WH52Label")
    private static MobileElement weekHigh52Label;
    @FindBy(id = "com.htmedia.mint:id/bidQuantityLabel")
    private static MobileElement bidQuantityLabel;
    @FindBy(id = "com.htmedia.mint:id/prevCloseLabel")
    private static MobileElement preCloseLabel;
    @FindBy(id = "com.htmedia.mint:id/dayLowLabel")
    private static MobileElement dayLowLabel;
    @FindBy(id = "com.htmedia.mint:id/WL52Label")
    private static MobileElement weekLow52Label;
    @FindBy(id = "com.htmedia.mint:id/volumeLabel")
    private static MobileElement volumeLabel;
    @FindBy(xpath = "//android.widget.TextView[@text='FINANCIALS']")
    private static MobileElement financialsSection;
    @FindBy(id = "com.htmedia.mint:id/incomeStatement")
    private static MobileElement incomeStatementLabel;
    @FindBy(id = "com.htmedia.mint:id/balanceSheet")
    private static MobileElement balanceSheetLabel;
    @FindBy(id = "com.htmedia.mint:id/dateDropDownLayout")
    private static MobileElement dateDropDownLabel;
    @FindBy(id = "com.htmedia.mint:id/standAloneLabel")
    private static MobileElement standaloneLabel;
    @FindBy(id = "com.htmedia.mint:id/standAloneBackGround")
    private static MobileElement incomeRelatedInfo;
    @FindBy(id = "com.htmedia.mint:id/standAloneBackGround")
    private static MobileElement balanceSheetRelatedInfo;
    @FindBy(xpath = "//android.widget.TextView[@text='COMPANY INFORMATION']")
    private static MobileElement companyInfoSection;
    @FindBy(id = "com.htmedia.mint:id/rExpandLayout")
    private static MobileElement aboutExpandTag;
    @FindBy(id = "com.htmedia.mint:id/mExpandLayout")
    private static MobileElement managementExpandTag;
    @FindBy(id = "com.htmedia.mint:id/managementName")
    private static MobileElement managementSection;
    @FindBy(id = "com.htmedia.mint:id/registrarChildLayout")
    private static MobileElement aboutDetail;
    @FindBy(id = "com.htmedia.mint:id/managementChildLayout")
    private static MobileElement managementDetail;
    @FindBy(id = "com.htmedia.mint:id/registrarName")
    private static MobileElement aboutSection;
    @FindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView)[3]/android.widget.LinearLayout")
    private static List<MobileElement> Top4GainerCompany;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='News']")
    private static MobileElement newsTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEWS']")
    private static MobileElement newsPage;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Latest']")
    private static MobileElement oldLatestTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='RECOMMENDED FOR YOU']")
    private static MobileElement recommendedForYouCarousel;
    @FindBy(id = "com.htmedia.mint:id/btReadNow")
    private static MobileElement newsLetterReadNow;
    @FindBy(id = "com.htmedia.mint:id/story_short_layout")
    private static MobileElement otherStorySize;
    @FindBy(id = "com.htmedia.mint:id/llCardLayout")
    private static MobileElement newsLetterPosition;
    @AndroidFindBy(xpath = "(//android.view.View[@text='TOP OF THE MORNING'])[1]")
    private static MobileElement topOfTheMorningWebView;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='RECOMMENDED FOR YOU']")
    private static MobileElement webViewCloseButton;
    @FindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement firstStoryHeadlineOnStoryDetailPage;
    @FindBy(id = "com.htmedia.mint:id/story_short_layout")
    private static MobileElement secondStoryOnHomePage;
    @FindBy(xpath = "(//android.widget.LinearLayout[3])[2]")
    private static MobileElement thirdStoryOnHomePage;
    @FindBy(xpath = "//android.widget.TextView[@text='MINT SNAPVIEW']//following::android.widget.TextView[@text='View All']")
    private static MobileElement snapView;
    @FindBy(id = "com.htmedia.mint:id/action_epaper")
    private static MobileElement ePaperIcon;
    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreBottomNavigation;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtSubscribe")
    private static MobileElement Subscribe;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(xpath = "//android.widget.TextView[@text='TOP PERFORMING MUTUAL FUNDS']")
    private static MobileElement mutualFundsSection;
    @FindBy(xpath = "//android.widget.Spinner[@resource-id='com.htmedia.mint:id/spinner']//android.widget.TextView")
    private static MobileElement mutualFundsSectionDropDownValue;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Debt']")
    private static MobileElement mutualFundDebtCategory;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tabs']/following::*[@resource-id='com.htmedia.mint:id/spinner']")
    private static MobileElement mutualFundsSectionDropDown;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Commodities']")
    private static MobileElement mutualFundCommoditiesCategory;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Equity']")
    private static MobileElement mutualFundEquityCategory;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Global Fund of Funds']")
    private static MobileElement mutualFundGlobalCategory;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Hybrid']")
    private static MobileElement mutualFundHybridCategory;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Index Funds']")
    private static MobileElement mutualFundIndexFundsCategory;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Other']")
    private static MobileElement mutualFundOtherCategory;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Solutions Oriented']")
    private static MobileElement mutualFundSolutionsOrientedCategory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCASTS']")
    private static MobileElement podCastSection;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCASTS']/following-sibling::android.widget.TextView[@text='View All']")
    private static MobileElement podCastViewAllIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCAST']")
    private static MobileElement podCastViewAllPage;
    @FindBy(xpath = "//android.widget.TextView[@text='Market Dashboard']")
    private static MobileElement marketDashboard;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/txtCommodityName'])[5]")
    private static MobileElement gainerLoserStock;
    @FindBy(xpath = "//android.widget.TextView[@text='COMPANY INFORMATION']")
    private static MobileElement companyinfo;
    @FindBy(xpath = "(//android.widget.TextView[@text='View all'])[2]")
    private static MobileElement viewAllMutualFund;
    @FindBy(xpath = "//android.widget.TextView[@text='MUTUAL FUNDS - TOP PERFORMERS']")
    private static MobileElement subtitleMutualFundPage;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/txtGainerLoserHeading'])[2]")
    private static MobileElement companyNews;
    @FindBy(id = "com.htmedia.mint:id/action_epaper")
    private static MobileElement epaperIcon;
    @FindBy(id = "com.htmedia.mint:id/action_signin")
    private static MobileElement signInIcon;
    @FindBy(id = "com.htmedia.mint:id/action_subscribe")
    private static MobileElement subscribeIcon;
    @FindBy(id = "com.htmedia.mint:id/tabs")
    private static MobileElement L1Menu;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Top News']")
    private static MobileElement L1MenuTopNews;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Markets']")
    private static MobileElement L1MenuMarkets;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Companies']")
    private static MobileElement L1MenuCompanies;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Industry']")
    private static MobileElement L1MenuIndustry;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Money']")
    private static MobileElement L1MenuMoney;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Mutual Funds']")
    private static MobileElement L1MenuMutualFunds;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Opinion']")
    private static MobileElement L1MenuOpinion;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Insurance']")
    private static MobileElement L1MenuInsurance;
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Technology']")
    private static MobileElement L1MenuTechnology;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tabs']//following-sibling::android.widget.LinearLayout")
    private static List<MobileElement> L1MenuAllOption;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tvNewsSubType']")
    private static List<MobileElement> sectionName;
    @FindBy(id = "com.htmedia.mint:id/txtViewDelay")
    private static MobileElement TickerD;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/imgArrow']")
    private static List<MobileElement> tickerArrow;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='For You']")
    private static MobileElement forYouTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FOR YOU']")
    private static MobileElement forYouPage;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tabs']//android.widget.TextView")
    private static List<MobileElement> l1TabAllOption;
    @FindBy(id = "com.htmedia.mint:id/layoutCloseButton")
    private static MobileElement storyCloseButton;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/imgWsjLogo']/following::*[@resource-id='com.htmedia.mint:id/title_inner_collection'])[1]")
    private static MobileElement WsjStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreMenuButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    private static MobileElement technologyButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement technologyTitle;
    @FindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @AndroidFindBy(id = "com.htmedia.mint:id/largeLabel")
    private static MobileElement homePageHighlighted;
    @AndroidFindBy(id = "com.htmedia.mint:id/action_search_left")
    private static MobileElement homePageSearchIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/action_signin")
    private static MobileElement myAccounts;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/imgPlanTab']")
    private static List<MobileElement> listOfActivePlan;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewAlreadySubscribed")
    private static MobileElement signin;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_choose_coupon")
    private static MobileElement applyCoupon;
    @AndroidFindBy(className = "android.widget.LinearLayout")
    private static List<MobileElement> allStories;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgEdit")
    private static MobileElement editProfileIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewPhone")
    private static MobileElement editPhoneNumber;
    @AndroidFindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement phoneNumberInputBox;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnSave")
    private static MobileElement profileSaveButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewGender")
    private static MobileElement profileGender;
    @AndroidFindBy(id = "com.htmedia.mint:id/radioBtnMale")
    private static MobileElement profileGenderMaleBtn;
    @AndroidFindBy(id = "com.htmedia.mint:id/login_heading_tv")
    private static MobileElement loginPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement emailTextBoxMainSignInPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewGender")
    private static MobileElement profileGenderInputBox;
    @AndroidFindBy(id = "com.htmedia.mint:id/action_profile")
    private static MobileElement MyAccount;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='News']")
    private static MobileElement newsButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Premium']")
    private static MobileElement premiumButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Markets']")
    private static MobileElement marketButton;
    @AndroidFindBy(xpath ="//android.widget.FrameLayout[@content-desc='For You']")
    private static MobileElement forYouButton;
    @AndroidFindBy(id ="com.htmedia.mint:id/llSubscription")
    private static MobileElement subsInfo;
    @AndroidFindBy(id ="com.htmedia.mint:id/tvCurrentPlanCaption")
    private static MobileElement currentPlan;
    @AndroidFindBy(id ="com.htmedia.mint:id/tvPlanName")
    private static MobileElement planName;
    @AndroidFindBy(id ="com.htmedia.mint:id/llRenewNow")
    private static MobileElement upgradeNowBtn;


    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }


    @Override
    public boolean checkVisibilityOfSponsoredStoryOnHomePage() {
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        commonFunctions.launchAppFromBackground(5);
        commonFunctions.scrollUntilElementFound(sponsoredStory);
        return commonFunctions.isElementDisplayed(sponsoredStory, 10, "first sponsored story");
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryOnHomePage() {
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementNotDisplayed(sponsoredStory, 10, "first sponsored story");
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryBookmarkButtonHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
//        commonFunctions.scrollToBottomForAndroidNative();
        commonFunctions.checkElementVisibilityByScrolling(sponsoredStory, "sponsored story");
        isShowing = commonFunctions.isElementDisplayed(sponsoredStory, 10, "first sponsored story");
        isShowing &= commonFunctions.isElementNotDisplayed(sponsoredStoryBookmarkButton, 10, "first sponsored story Bookmark button");
        return isShowing;
    }

    @Override
    public boolean notification(String apiURL, String faviconURL) {
        boolean notificationStatus;

        return false;
    }

    @Override
    public boolean pageTitle() {
        return false;
    }

    @Override
    public boolean siteMap(String siteMapURL) {
        return false;
    }

    @Override
    public boolean checkHamburger() {
        return false;
    }

    @Override
    public boolean subscribedUserPaywall() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        isShowing = checkPremiumLandingPage();
        isShowing &= checkPremiumLabel();
        isShowing &= commonFunctions.isElementDisplayed(imageCaption, 10, "Image caption");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribeNow, "Subscribe Now");
        return isShowing;
    }

    @Override
    public boolean checkDuplicateEntriesForLatestNews() {
        return false;
    }

    @Override
    public boolean checkStoryPageWidgets() {
        return false;
    }

    @Override
    public boolean checkLMPremiumPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkRHSWidgetsHomePage(String[] params) {
        return false;
    }

    @Override
    public boolean listenToArticle() {
        return false;
    }

    @Override
    public boolean checkHindustanWidgetHomePage(String[] params) {
        return false;
    }

    @Override
    public boolean checkMintEPaperBanner() {
        boolean isMintEPaperBannerVisibilityTrue;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        isMintEPaperBannerVisibilityTrue = commonFunctions.isElementVisible(e_paperLink, 10, "E-paper link on Home page");
        return isMintEPaperBannerVisibilityTrue;
    }

    @Override
    public boolean checkHomePageSrollsTillEnd() {
        boolean endOfPage = false;
        commonFunctions.clickElement(home, 10, "Home");
        String previousPageSource = driver.getPageSource();
        while (!endOfPage) {
            for (int i = 0; i <= 2; i++) {
                commonFunctions.scrollToBottomForAndroidNative();
            }
            endOfPage = previousPageSource.equals(driver.getPageSource());
            previousPageSource = driver.getPageSource();
        }
        commonFunctions.clickElement(home, 10, "Home");
        return endOfPage;
    }

    @Override
    public boolean checkEPaperSubscribedUser() {
        boolean isShowing;
        commonFunctions.clickElement(ePaperIcon, 10, "E-paper link on Home page");
        isShowing = commonFunctions.isElementDisplayed(ePaperWebPageMintLogo, 10, "E-paper main page mint logo");
        commonFunctions.navigateBack();
        return isShowing;
    }

    public boolean clickContinueButton(List<MobileElement> elementList) {
        boolean isClickContinueButtonTrue = false;
        try {
            for (MobileElement ele : elementList) {
                isClickContinueButtonTrue = commonFunctions.clickElement(ele, 10, "Continue related button");
            }
        } catch (Exception e) {
            isClickContinueButtonTrue = false;
        }
        return isClickContinueButtonTrue;
    }

    @Override
    public boolean checkEPaperNonSubscribedUser() {
        boolean isMintEPaperNonSubscribedUserVisibilityTrue;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(e_paperLink, 10, "E-paper link on Home page");
        isMintEPaperNonSubscribedUserVisibilityTrue = commonFunctions.isElementVisible(subscribeNow, 10, "E-paper non subscribed user alert");
        commonFunctions.navigateBack();
        return isMintEPaperNonSubscribedUserVisibilityTrue;
    }

    @Override
    public boolean checkMintLogo() {
        boolean isMintLogoPresent = true;
        commonFunctions.clickElementIfDisplayed(yesIAmButton, 10, "Yes I am Button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad close");
        commonFunctions.clickElement(homeButton, 10, "Home menu button");
        Utils.logStepInfo(true, "Checking for Live Mint logo present at the home page.");
        isMintLogoPresent &= commonFunctions.isElementVisible(mintTitle, 10, "Mint logo");

        return isMintLogoPresent;
    }

    @Override
    public boolean checkMintLogoLocation() {
        boolean isMintLogoPresentAtLocationTrue = true;

        commonFunctions.clickElementIfDisplayed(yesIAmButton, 10, "Yes I am Button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad close");
        commonFunctions.clickElement(homeButton, 10, "Home menu button");
        Utils.logStepInfo(true, "Checking for Live Mint logo location.");
        isMintLogoPresentAtLocationTrue &= commonFunctions.isElementVisible(mintTitle, 10, "Mint logo");

        return isMintLogoPresentAtLocationTrue;
    }

    @Override
    public boolean checkBottomNavigation() {
        return false;
    }

    @Override
    public boolean checkBottomNavigationAllPages() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        isShowing = checkAllNavigationButton();
        commonFunctions.clickElement(market, 10, "market tab");
        isShowing &= checkAllNavigationButton();
        commonFunctions.clickElement(newsTab, 10, "news tab");
        isShowing &= checkAllNavigationButton();
        commonFunctions.clickElement(premium, 10, "premium tab");
        isShowing &= checkAllNavigationButton();
        commonFunctions.clickElement(forYouTab, 10, "forYou tab");
        isShowing &= checkAllNavigationButton();
        return isShowing;
    }

    @Override
    public boolean checkBottomNavigationFocus() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        isShowing = commonFunctions.isElementDisplayed(marketTicker, 10, "market Ticker");
        isShowing &= checkNews();
        isShowing &= marketPage();
        isShowing &= checkPremium();
        commonFunctions.clickElement(forYouTab, 10, "forYou tab");
        isShowing &= commonFunctions.isElementDisplayed(forYouPage, 10, "for you page");
        return isShowing;
    }

    @Override
    public boolean clickAndVerifyMintLoungeStory() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUntilElementFound(mintLoungeCarousel);
//        commonFunctions.scrollDownToElement(mintLoungeCarousel);
        String headline = commonFunctions.getElementText(firstStoryWsj.get(1), 10);
        commonFunctions.clickElement(firstStoryWsj.get(1), 10, "first Story Wsj");
        isShowing = commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(firstStoryHeadline, headline, 10, "First story headline on story page");
        return isShowing;


//        return ;
    }

    @Override
    public boolean checkViewAllButtonOnMintPremium() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUntilElementFound(mintPremium);
        commonFunctions.clickElement(viewAll, 10, "view all mint premium");
        isShowing = commonFunctions.checkElementText(premiumTitle, "PREMIUM", 10, "premium title text");
        isShowing &= commonFunctions.isElementNotDisplayed(removeAd, 10, "remove Ad icon");
        return isShowing;
    }

    @Override
    public boolean checkAndVerifyViewAllOnMintPremiumCarousel() {
        return false;
    }

    @Override
    public boolean checkAndVerifyViewAllOnWSJCarousel() {
        return false;
    }

    @Override
    public boolean checkAndVerifyStoryOnWSJCarousel() {
        return false;
    }

    @Override
    public boolean checkMintGenieBanner() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.scrollUpToElementDisplayed(mintGenieBanner);
        commonFunctions.clickElement(mintGenieBanner, 10, "mint Genie Banner");
        commonFunctions.clickElementIfDisplayed(chromeBrowserOption, 10, "chrome browser");
        commonFunctions.clickElementIfDisplayed(justOnce, 10, "just once option");
        commonFunctions.clickElementIfDisplayed(mintGenieNotificationBlock, 10, "block notification mintGenie webpage");
        isShowing = commonFunctions.isElementDisplayed(mintGenieWebPageLogo, 10, "mint Genie WebPage Logo");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkAndVerifyViewAllOnMintLoungeCarousel() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.scrollDownToElement(mintLoungeCarousel);
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithCoordinates(928, 1811);
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(MintLoungeHeader, 10, "Mint Lounge Header");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean shareStory() {
        boolean shareStoryStatus;
        boolean checkShareIconsStatus = checkShareIcons();
        if (checkShareIconsStatus) {
            shareStoryStatus = true;
        } else {
            shareStoryStatus = false;
        }
        return shareStoryStatus;
    }

    @Override
    public boolean bookmarkStory() {
        boolean bookmarkStatus;
        commonFunctions.isElementDisplayed(bookmarkIcon, 10, "Bookmark Icon");
        bookmarkStatus = commonFunctions.isElementClickable(bookmarkIcon, 10, "BookMark Icon");
        return bookmarkStatus;
    }

    public boolean checkShareIcons() {
        boolean checkShareIconsStatus;
        commonFunctions.clickElement(shareIcon, 10, "Share Icon");
        commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook Icon");
        checkShareIconsStatus = commonFunctions.isElementDisplayed(messagesIcon, 10, "Messages Icon");
        commonFunctions.navigateBack();
        return checkShareIconsStatus;
    }

    public boolean checkShareIconIsClickable() {
        boolean isShowing;
        commonFunctions.isElementDisplayed(shareIconUnderDiffTab, 10, "Share Icon");
        commonFunctions.clickElement(shareIconUnderDiffTab, 10, "Share Icon");
        isShowing = commonFunctions.isElementDisplayed(ShareHeading, 10, "SHARE");
        isShowing &= commonFunctions.isElementDisplayed(messagesIcon, 10, "Messages Icon");
        isShowing &= commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook Icon");
        commonFunctions.clickElement(messagesIcon, 10, "Messages Icon");
        isShowing &= commonFunctions.isElementDisplayed(newMessage, 10, "New Message");
        commonFunctions.clickElement(cancelMessage, 10, "Cancel Message");
        isShowing &= commonFunctions.isElementDisplayed(mintTitle, 10, "Mint");
        return isShowing;
    }

    public boolean checkNews() {
        boolean checkLatestStatus;
        commonFunctions.clickElement(newsTab, 10, "news");
        checkLatestStatus = commonFunctions.isElementDisplayed(newsPage, 10, "news Heading");
        commonFunctions.isElementDisplayed(stories, 10, "Stories");
        return checkLatestStatus;
    }

    public boolean marketPage() {
        boolean checkTrendingStatus;
        commonFunctions.clickElement(market, 10, "Trending");
        checkTrendingStatus = commonFunctions.isElementDisplayed(indianIndices, 10, "market page");
        return checkTrendingStatus;
    }

    public boolean checkPremium() {
        boolean checkPremiumStatus;
        commonFunctions.clickElement(premium, 10, "Trending");
        checkPremiumStatus = commonFunctions.checkElementText(premiumTitle, "PREMIUM", 10, "premium title text");
        commonFunctions.isElementDisplayed(stories, 10, "Stories");
        return checkPremiumStatus;
    }

    public boolean checkShareIconPresentOnEachStoryPage() {
        boolean isShowing;
        boolean shareIconHomePageStatus = commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(forYouTab, 10, "for you");
        isShowing = commonFunctions.isElementDisplayed(shareIconUnderDiffTab, 10, "Share Icon");
        commonFunctions.isElementDisplayed(premium, 10, "Premium");
        commonFunctions.clickElement(premium, 10, "Premium");
        isShowing &= commonFunctions.isElementDisplayed(shareIconUnderDiffTab, 10, "Share Icon");
        commonFunctions.clickElement(news, 10, "News");
        isShowing &= commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(shareIconUnderDiffTab, 10, "share icon");
        commonFunctions.navigateBack();
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        isShowing &= commonFunctions.isElementDisplayed(explorePage, 10, "explore page");
        commonFunctions.scrollDownToElement(technologyButton);
        isShowing &= commonFunctions.clickElement(technologyButton, 10, "technology Text");
        isShowing &= commonFunctions.getElementTextAndCheck(technologyTitle, "TECHNOLOGY", 10, "page title");
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(2);
        commonFunctions.navigateBack();
        return isShowing;
    }

    public boolean checkPremiumLandingPage() {
        boolean checkPremiumLandingPageStatus;
        commonFunctions.clickElement(premium, 10, "Premium");
        commonFunctions.isElementDisplayed(premiumTitle, 10, "Premium Title");
        checkPremiumLandingPageStatus = commonFunctions.isElementDisplayed(premiumFirstStory, 10, "Premium First Story");
        return checkPremiumLandingPageStatus;
    }

    public boolean checkPremiumLabel() {
        boolean checkPremiumLabelStatus;
        commonFunctions.clickElement(premiumFirstStory, 10, "Premium First Story");
        commonFunctions.dummyWait(3);
        commonFunctions.clickByCoordinates(328, 159);
        commonFunctions.dummyWait(2);
        checkPremiumLabelStatus = commonFunctions.isElementDisplayed(premiumTag, 10, "Premium Tag");
        return checkPremiumLabelStatus;
    }

    public boolean checkStoryOpens() {
        boolean isShowing;
        commonFunctions.clickElement(storyImage, 10, "Story Image");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(346, 162);
        commonFunctions.dummyWait(3);
        isShowing = commonFunctions.isElementDisplayed(imageCaption, 10, "image caption");
        isShowing &= commonFunctions.isElementDisplayed(imageUnderTitle, 10, "image title");
        return isShowing;
    }

    public boolean checkCloseButtonIsFloating() {
        boolean checkCloseButtonIsFloatingStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.clickElement(storyImage, 10, "Home");
        commonFunctions.swipeElementUsingTouchAction(479, 1547, 452, 345);
        boolean checkShareIconIsClickable = commonFunctions.isElementClickable(shareIcon, 10, "Share Icon");
        boolean checkBookmarkIconIsClickable = commonFunctions.isElementClickable(bookmarkIcon, 10, "Bookmark Icon");
        checkCloseButtonIsFloatingStatus = commonFunctions.isElementDisplayed(closeFloat, 10, "Close");

        if (checkShareIconIsClickable && checkBookmarkIconIsClickable && checkCloseButtonIsFloatingStatus) {
            checkCloseButtonIsFloatingStatus = true;
        } else {
            checkCloseButtonIsFloatingStatus = false;
        }
        return checkCloseButtonIsFloatingStatus;
    }

    public boolean checkCloseIconIsClickable() {
        boolean checkCloseIconIsClickableStatus;
        checkCloseIconIsClickableStatus = commonFunctions.isElementClickable(closeFloat, 10, "Close Icon");
        commonFunctions.clickElement(closeFloat, 10, "Close");
        return checkCloseIconIsClickableStatus;
    }

    public boolean checkSearchStoryPage(String storyText) {
        boolean checkSearchStoryPageStatus;
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(search, 10, "Search");
        commonFunctions.clickElement(textSearch, 10, "Search");
        commonFunctions.clickByCoordinates(448, 1911);
        commonFunctions.sendKey(textSearch, storyText);
        commonFunctions.clickByCoordinates(735, 314);
        commonFunctions.clickElement(textSearch, 10, "Search");
        commonFunctions.clickByCoordinates(984, 1923);
        checkSearchStoryPageStatus = commonFunctions.isElementDisplayed(searchResultOutput, 10, "Search Result");
        commonFunctions.clickByCoordinates(452, 655);
        commonFunctions.isElementDisplayed(home, 10, "Home");
        return checkSearchStoryPageStatus;
    }

    public boolean checkSummaryInAPI(Response response) {
        boolean checkSummaryInAPIStatus;
        String expectedSummaryFromAPI = RestUtils.getValueFromResponse(response, "content[0].summary");
        expectedSummaryFromAPI = Utils.formatAPIText(expectedSummaryFromAPI);
        String actualSummaryFromUI = commonFunctions.getElementText(apiSummary);
        actualSummaryFromUI = actualSummaryFromUI.replaceAll("\n", "");
        checkSummaryInAPIStatus = commonFunctions.checkTextContains(expectedSummaryFromAPI, actualSummaryFromUI, "Summary in API");
        return checkSummaryInAPIStatus;
    }

    public boolean checkCaptionInAPI(Response response) {
        boolean checkCaptionInAPIStatus;
        String expectedCaptionFromAPI = RestUtils.getValueFromResponse(response, "content[0].leadMedia.image.caption");
        expectedCaptionFromAPI = Utils.formatAPIText(expectedCaptionFromAPI);
        String actualCaptionFromUI = commonFunctions.getElementText(imageCaption);
        checkCaptionInAPIStatus = commonFunctions.checkTextContains(expectedCaptionFromAPI, actualCaptionFromUI, "Caption in API");
        return checkCaptionInAPIStatus;
    }

    public boolean checkEmailIDUsedForLogin(String email) {
        boolean checkEmailIDUsedForLoginStatus;
        String actualEmail = commonFunctions.getElementText(userEmailUsed);
        checkEmailIDUsedForLoginStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID Used");
        return checkEmailIDUsedForLoginStatus;
    }

    public boolean checkEditProfileOption() {
        boolean checkEditProfileOptionStatus;
        boolean checkEditNamePresentStatus = commonFunctions.isElementDisplayed(name, 10, "Name");
        commonFunctions.isElementDisplayed(emailID, 10, "Email ID");
        boolean checkEditContactNoStatus = commonFunctions.isElementDisplayed(addYourContactNo, 10, "Add Your Account");
        boolean checkEditPasswordStatus = commonFunctions.isElementDisplayed(password, 10, "Password");
        boolean checkEditGenderStatus = commonFunctions.isElementDisplayed(gender, 10, "Gender");
        if (checkEditNamePresentStatus && checkEditContactNoStatus && checkEditPasswordStatus && checkEditGenderStatus) {
            checkEditProfileOptionStatus = true;
        } else {
            checkEditProfileOptionStatus = false;
        }
        return checkEditProfileOptionStatus;
    }

    public boolean changeName(String newName, String oldName) {
        boolean changeNameStatus;
        commonFunctions.clickElement(name, 10, "Name");
        commonFunctions.clear(nameTemp, "Name");
        commonFunctions.sendKey(nameTemp, newName);
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile");
        String actualName = commonFunctions.getElementText(editedName);
        boolean checkNewName = commonFunctions.checkTextContains(newName, actualName, "Name Changed");
        commonFunctions.clickElement(name, 10, "Name");
        commonFunctions.clear(nameTemp, "Name");
        commonFunctions.sendKey(nameTemp, oldName);
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile");
        actualName = commonFunctions.getElementText(editedName);
        boolean checkOldName = commonFunctions.checkTextContains(oldName, actualName, "Name Reverted");
        if (checkNewName && checkOldName) {
            changeNameStatus = true;
        } else {
            changeNameStatus = false;
        }
        return changeNameStatus;
    }

    public boolean checkPasswordChange(String newPassword, String oldPassword) {
        boolean isAbleToSetNewPassword, isAbleToResetOldPassword, checkChangePasswordStatus;
        isAbleToSetNewPassword = changePassword(newPassword, oldPassword);
        isAbleToResetOldPassword = changePassword(oldPassword, newPassword);
        if (isAbleToSetNewPassword && isAbleToResetOldPassword) {
            checkChangePasswordStatus = true;
        } else {
            checkChangePasswordStatus = false;
        }
        return checkChangePasswordStatus;
    }

    public boolean changePassword(String newPassword, String oldPassword) {
        boolean changePasswordStatus;
        commonFunctions.isElementDisplayed(password, 90, "Password");
        commonFunctions.clickElement(password, 10, "Password");
        commonFunctions.sendKey(enterOldPass, oldPassword);
        commonFunctions.sendKey(enterNewPass, newPassword);
        commonFunctions.sendKey(enterConfirmPass, newPassword);
        commonFunctions.clickElement(reset, 10, "Reset Button");
        changePasswordStatus = commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        return changePasswordStatus;
    }

    public boolean checkChangeGender() {
        boolean checkChangeGenderStatus;
        commonFunctions.clickElement(gender, 10, "Edit Gender");
        commonFunctions.clickElement(femaleGenderRadioButton, 10, "FeMale Gender Radio button");
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        boolean checkChangeGenderToFemaleStatus = commonFunctions.isElementDisplayed(female, 10, "FeMale Text");
        commonFunctions.clickElement(gender, 10, "Edit Gender");
        commonFunctions.clickElement(maleGenderRadioButton, 10, "Male Gender Radio button");
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        boolean checkChangeGenderToMaleStatus = commonFunctions.isElementDisplayed(male, 10, "Male Text");
        commonFunctions.clickElement(backBtn, 10, "Back Button");
        if (checkChangeGenderToFemaleStatus && checkChangeGenderToMaleStatus) {
            checkChangeGenderStatus = true;
        } else {
            checkChangeGenderStatus = false;
        }
        return checkChangeGenderStatus;
    }


    public boolean checkLandingPage(MobileElement element, int timeOut, String landingPageElementName) {
        boolean checkLandingPageStatus;
        commonFunctions.isElementDisplayed(element, timeOut, landingPageElementName);
        commonFunctions.clickElement(element, timeOut, landingPageElementName);
        commonFunctions.isElementDisplayed(landingPage, timeOut, landingPageElementName + " Landing page");
        String actualLandingPageName = commonFunctions.getElementText(landingPage, timeOut);
        if (actualLandingPageName.equals(landingPageElementName)) {
            checkLandingPageStatus = true;
            Utils.logStepInfo(true, landingPageElementName + " Landing Page displayed successfully");
        } else {
            checkLandingPageStatus = false;
            Utils.logStepInfo(false, landingPageElementName + " Landing Page is not displayed");
        }
        commonFunctions.clickElement(backArrow, 10, "back Arrow");
        return checkLandingPageStatus;
    }


    public boolean checkRespectiveLinksPresent() {
        boolean checkRespectiveLinksPresentStatus;
        boolean checkPrivacyPolicyStatus = checkLandingPage(privacyPolicy, 10, "Privacy Policy");
        boolean checkTermsOfUseStatus = checkLandingPage(termsOfUse, 10, "Terms of Use");
        boolean checkCookiePolicyStatus = checkLandingPage(cookiePolicy, 10, "Cookie Policy");
        boolean checkSubscriberAgreementStatus = checkLandingPage(subscriberAgreement, 10, "Subscriber Agreement");
        if (checkPrivacyPolicyStatus && checkTermsOfUseStatus && checkCookiePolicyStatus && checkSubscriberAgreementStatus) {
            checkRespectiveLinksPresentStatus = true;
        } else {
            checkRespectiveLinksPresentStatus = false;
        }
        return checkRespectiveLinksPresentStatus;
    }

    public boolean checkBookmarkedStoryInBookmarkSwiperBox(String storyHeadline, boolean isAvailable) {
        boolean checkBookmarkedStoryInBookmarkSwiperBoxStatus;
        ArrayList<String> bookmarkStoryList = new ArrayList<String>();
        for (MobileElement e : bookmarksSwiperBoxElementsList) {
            String text = e.getAttribute("text");
            bookmarkStoryList.add(text);
        }

        if (isAvailable) {
            if (bookmarkStoryList.contains(storyHeadline)) {
                Utils.logStepInfo(true, "BookMarked Story Headline List Present in swiper box");
                checkBookmarkedStoryInBookmarkSwiperBoxStatus = true;
            } else {

                Utils.logStepInfo(false, "BookMarked Story Headline" + storyHeadline + " not Present in swiper box" + bookmarkStoryList);
                checkBookmarkedStoryInBookmarkSwiperBoxStatus = false;
            }
        } else {
            if (!bookmarkStoryList.contains(storyHeadline)) {
                Utils.logStepInfo(true, "BookMarked Story Headline is Not available in Bookmark swiper box. This is expected");
                checkBookmarkedStoryInBookmarkSwiperBoxStatus = true;
            } else {
                Utils.logStepInfo(false, "BookMarked Story Headline is available in Bookmark swiper box. This is not expected. Bookmark should be removed from the Bookmark swiper box");
                checkBookmarkedStoryInBookmarkSwiperBoxStatus = false;
            }
        }
        return checkBookmarkedStoryInBookmarkSwiperBoxStatus;
    }


    public boolean checkMarketTicker(String elementName) {
        boolean checkMarketTickerStatus;

        ArrayList<String> marketTickerList = new ArrayList<String>();
        for (MobileElement e : marketTickerElementsList) {
            String text = e.getAttribute("text");
            marketTickerList.add(text);
        }
        if (marketTickerList.contains(elementName)) {
            Utils.logStepInfo(true, elementName + " is present in the Market Ticker");
            checkMarketTickerStatus = true;
        } else {
            Utils.logStepInfo(false, elementName + " is not present in the Market Ticker. Market Ticker List: " + marketTickerList);
            checkMarketTickerStatus = false;
        }
        return checkMarketTickerStatus;
    }

    public boolean checkLandingPage(MobileElement element, MobileElement landingPageElement, String elementName, String landingPageElementName, int timeOut) {
        boolean checkLandingPageStatus;
        commonFunctions.clickElement(element, timeOut, elementName);
        commonFunctions.isElementDisplayed(landingPageElement, timeOut, elementName + " Landing page");
        String actualLandingPageName = commonFunctions.getElementText(landingPageElement, timeOut);
        if (actualLandingPageName.equals(landingPageElementName)) {
            checkLandingPageStatus = true;
            Utils.logStepInfo(true, landingPageElementName + " Page displayed successfully");
        } else {
            checkLandingPageStatus = false;
            Utils.logStepInfo(false, landingPageElementName + " Page is not displayed");
        }
        commonFunctions.clickElement(backBtn, 10, "Back");
        commonFunctions.isElementDisplayed(firstStory, 10, "Story");
        return checkLandingPageStatus;
    }


    @Override
    public boolean shareStoryFunctionality() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        isShowing = checkShareIconPresentOnEachStoryPage();
        commonFunctions.clickElement(home, 10, "Home");
        isShowing &= checkShareIconIsClickable();
        return isShowing;
    }

    @Override
    public boolean pageContent(String apiURL) {
        boolean pageContentStatus;
        if (commonFunctions.isElementDisplayed(yesIAmInButton)) {
            commonFunctions.clickElement(yesIAmInButton);
        }
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(home, 10, "Home");
        boolean homePageStatus = commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        commonFunctions.isElementDisplayed(latest, 10, "Latest");
        boolean checkLatestStatus = checkNews();
        commonFunctions.isElementDisplayed(market, 10, "Trending");
        boolean checkTrendingStatus = marketPage();
        commonFunctions.isElementDisplayed(premium, 10, "Premium");
        boolean checkPremiumStatus = checkPremium();
        if (homePageStatus && checkLatestStatus && checkTrendingStatus && checkPremiumStatus) {
            pageContentStatus = true;
        } else {
            pageContentStatus = false;
        }
        return pageContentStatus;
    }

    @Override
    public boolean nonSubscribedUserPaywall(String apiURL) {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        isShowing = checkPremiumLandingPage();
        isShowing &= checkPremiumLabel();
        isShowing &= commonFunctions.isElementDisplayed(imageCaption, 10, "Image caption");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribeNow, "Subscribe Now");
        return isShowing;
    }

    public boolean checkCloseIconIsSticky() {
        boolean checkCloseIconIsStickyStatus;
        checkCloseIconIsStickyStatus = commonFunctions.isElementDisplayed(closeStory, 10, "Close icon");
        return checkCloseIconIsStickyStatus;
    }

    @Override
    public boolean storyPage() {
        boolean storyPageStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(firstStory, 10, "Story");
        boolean checkStoryOpensStatus = checkStoryOpens();
        commonFunctions.swipeElementUsingTouchAction(500, 1600, 500, 700);
        commonFunctions.isElementDisplayed(imageCaption, 10, "Image Caption");
        boolean checkMinutesStatus = commonFunctions.isElementDisplayed(minutesToRead, 10, "Minutes");
        boolean checkTimestampStatus = commonFunctions.isElementDisplayed(timestamp, 10, "Updated TimeStamp");
        boolean checkStoryAuthorStatus = commonFunctions.isElementDisplayed(storyAuthor, 10, "Story Author");
        boolean checkCloseIconIsStickyStatus = checkCloseIconIsSticky();
        commonFunctions.clickElement(closeStory, 10, "Close Story");
        boolean checkImageCaptionStatus = commonFunctions.isElementNotDisplayed(imageCaption, 10, "Image caption");
        if (checkStoryOpensStatus && checkMinutesStatus && checkTimestampStatus && checkStoryAuthorStatus && checkCloseIconIsStickyStatus && checkImageCaptionStatus) {
            storyPageStatus = true;
        } else {
            storyPageStatus = false;
        }
        return storyPageStatus;
    }

    @Override
    public boolean apiForFirstStory(String[] params) {
        boolean apiForFirstStoryStatus;
        String apiURL = params[0];
        String storyText = params[1];
        String storyId = params[2];
        boolean checkSearchStoryPageStatus = checkSearchStoryPage(storyText);
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        System.out.println(response.asString());
        boolean checkSummaryInAPIStatus = checkSummaryInAPI(response);
        boolean checkCaptionInAPIStatus = checkCaptionInAPI(response);
        if (checkCaptionInAPIStatus && checkSummaryInAPIStatus && checkSearchStoryPageStatus) {
            apiForFirstStoryStatus = true;
        } else {
            apiForFirstStoryStatus = false;
        }
        return apiForFirstStoryStatus;
    }

    @Override
    public boolean myAccountFunctionality(String oldPassword, String newPassword, String oldName, String newName, String email, String manageProfileURL) {
        boolean myAccountFunctionalityStatus;
        commonFunctions.clickElement(home, 10, "Home");
        boolean checkMyAccountStatus = commonFunctions.isElementDisplayed(myAccount, 10, "My Account");
        commonFunctions.clickElement(myAccount, 10, "My Account");
        boolean checkEmailIDUsedForLoginStatus = checkEmailIDUsedForLogin(email);
        boolean checkEditProfileStatus = commonFunctions.isElementDisplayed(editProfile, 10, "Edit Profile");
        commonFunctions.clickElement(editProfile, 10, "Edit Profile");
        boolean checkEditProfileOptionStatus = checkEditProfileOption();
        boolean changeNameStatus = changeName(newName, oldName);
        boolean checkChangePasswordStatus = checkPasswordChange(newPassword, oldPassword);
        boolean checkChangeGenderStatus = checkChangeGender();
        boolean checkRespectiveLinksPresentStatus = checkRespectiveLinksPresent();
        commonFunctions.clickElement(closeEditProfile, 10, "closeIcon in edit profile");
        if (checkMyAccountStatus && checkEditProfileOptionStatus && checkChangePasswordStatus && changeNameStatus && checkEmailIDUsedForLoginStatus && checkRespectiveLinksPresentStatus && checkEditProfileStatus && checkChangeGenderStatus) {
            myAccountFunctionalityStatus = true;
        } else {
            myAccountFunctionalityStatus = false;
        }
        return myAccountFunctionalityStatus;
    }

    @Override
    public boolean bookmarkStoryLoggedInUser() {
        boolean bookmarkStoryLoggedInUserStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(firstStory, 10, "Story");
        boolean checkUserIsAbleToOpenStoryPageStatus = checkStoryOpens();
        String storyHeadline = commonFunctions.getElementText(firstStory);
        commonFunctions.clickElement(detailPageBookmarkIcon, 10, "Bookmark Icon");
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(myReads, 10, "My Reads");
        bookmarkStoryLoggedInUserStatus = commonFunctions.isElementDisplayed(BookmarkSwiperBox, 10, "Bookmark Swiper Box");
        boolean checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus = checkBookmarkedStoryInBookmarkSwiperBox(storyHeadline, true);
        commonFunctions.clickElement(bookmarkIconInSwiperBox, 10, "Bookmark in Swiper Box");
        commonFunctions.navigateBack();
        commonFunctions.clickElement(myReads, 10, "My Reads");
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(3);
        commonFunctions.navigateBack();
        boolean checkBookmarkedStoryIsNotAvailableInBookmarkSwiperBoxStatus = checkBookmarkedStoryInBookmarkSwiperBox(storyHeadline, false);
        if (checkUserIsAbleToOpenStoryPageStatus && bookmarkStoryLoggedInUserStatus && checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus && checkBookmarkedStoryIsNotAvailableInBookmarkSwiperBoxStatus) {
            bookmarkStoryLoggedInUserStatus = true;
        } else {
            bookmarkStoryLoggedInUserStatus = false;
        }
        return bookmarkStoryLoggedInUserStatus;
    }

    @Override
    public boolean marketTicker(String[] params) {
        boolean isShowing;
        String bseSensexLandingPage = params[7];
        String nifty50LandingPage = params[8];
        String niftyBankLandingPage = params[9];
        String bseMidcapLandingPage = params[10];
        String goldLandingPage = params[5];
        String silverLandingPage = params[6];
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(home, 10, "Home");
        isShowing = commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        commonFunctions.isElementClickable(marketTicker, 10, "Market Ticker");
        isShowing &= checkNavigationForMarketStats(bseSensexLandingPage);
        isShowing &= checkEachMarketLandingPagesAreNotBlank(nifty50LandingPage, niftyBankLandingPage, bseMidcapLandingPage, goldLandingPage, silverLandingPage);
        return isShowing;
    }

    public boolean checkOrderListPresentInTheMarketTicker(String bseSensex, String nifty50, String niftyBank) {
        boolean checkOrderListPresentInTheMarketTickerStatus;
        boolean marketSensexStatus = checkMarketTicker(bseSensex);
        boolean marketNiftyStatus = checkMarketTicker(nifty50);
        boolean marketNiftyBankStatus = checkMarketTicker(niftyBank);
        if (marketSensexStatus && marketNiftyStatus && marketNiftyBankStatus) {
            checkOrderListPresentInTheMarketTickerStatus = true;
        } else {
            checkOrderListPresentInTheMarketTickerStatus = false;
        }
        return checkOrderListPresentInTheMarketTickerStatus;
    }

    public boolean checkNavigationForMarketStats(String bseSensexLandingPage) {
        boolean checkNavigationForMarketStatsStatus;
        commonFunctions.clickElement(marketBSESENSEX, 10, "BSE SENSEX");
        String actualLandingPageName = commonFunctions.getElementText(marketBseSensexLandingPage, 10);
        if (actualLandingPageName.equals(bseSensexLandingPage)) {
            checkNavigationForMarketStatsStatus = true;
            Utils.logStepInfo(true, bseSensexLandingPage + " Page displayed successfully");
        } else {
            checkNavigationForMarketStatsStatus = false;
            Utils.logStepInfo(false, bseSensexLandingPage + " Page is not displayed");
        }
        commonFunctions.clickElement(backBtn, 10, "Back");
        commonFunctions.isElementDisplayed(firstStory, 10, "Story");
        return checkNavigationForMarketStatsStatus;
    }

    public void swipeAndClickMarketTicker(int x1, int y1, int x2, int y2, MobileElement element, String elementName) {
        for (int i = 0; i <= 3; i++) {
            boolean clickStatus;
            try {
                clickStatus = commonFunctions.clickElementIfDisplayed(element, 10, elementName);
                if (clickStatus) {
                    break;
                } else {
                    System.out.println("Not Clicked now will do swipe" + i);
                    commonFunctions.swipeElementUsingTouchAction(x1, y1, x2, y2);
                    commonFunctions.waitForPageLoading(10);
                    if (i == 3) {
                        commonFunctions.clickElement(element, 10, elementName);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public boolean checkEachMarketLandingPagesAreNotBlank(String nifty50LandingPage, String niftyBankLandingPage, String bseMidcapLandingPage, String goldLandingPage, String silverLandingPage) {
        boolean isShowing;
        swipeAndClickMarketTicker(988, 399, 148, 364, marketNiftyBank, "Market Nifty Bank");
        isShowing = checkMarketTickerLandingPage(marketNiftyBankLandingPage, niftyBankLandingPage, 10);

        swipeAndClickMarketTicker(988, 399, 148, 364, marketBSEMIDCAP, "Market Midcap");
        isShowing &= checkMarketTickerLandingPage(marketBseMidCapLandingPage, bseMidcapLandingPage, 10);

        swipeAndClickMarketTicker(988, 399, 148, 364, marketNifty, "Market Nifty");
        isShowing &= checkMarketTickerLandingPage(marketNifty50LandingPage, nifty50LandingPage, 10);

//        swipeAndClickMarketTicker(988, 399, 148, 364, marketGOLD, "Market Gold");
//        boolean marketGoldLandingStatus = checkMarketTickerLandingPage(marketGoldLandingPage, goldLandingPage, 10);

//        swipeAndClickMarketTicker(988, 399, 148, 364, marketSILVER, "Market Silver");
//        boolean marketSilverLandingStatus = checkMarketTickerLandingPage(marketSilverLandingPage, silverLandingPage, 10);

        return isShowing;
    }

    public boolean checkMarketTickerLandingPage(MobileElement landingPageElement, String landingPageElementName, int timeOut) {
        boolean checkLandingPageStatus;
        commonFunctions.isElementDisplayed(landingPageElement, timeOut, landingPageElementName + " Landing page");
        String actualLandingPageName = commonFunctions.getElementText(landingPageElement, timeOut);
        if (actualLandingPageName.equals(landingPageElementName)) {
            checkLandingPageStatus = true;
            Utils.logStepInfo(true, landingPageElementName + " Landing Page displayed successfully");
        } else {
            checkLandingPageStatus = false;
            Utils.logStepInfo(false, landingPageElementName + " Landing Page is not displayed");
        }
        commonFunctions.clickElement(backBtn, 10, "Back");
        commonFunctions.isElementDisplayed(firstStory, 10, "Story");
        return checkLandingPageStatus;
    }

    @Override
    public void clickOnHomeButtonWithHandlingDarkMode() {
        commonFunctions.clickElement(homeButton, 10, "Home button");
    }

    @Override
    public boolean checkSignInLink() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(signInButton, 10, "Sign in Button on Home page");
        return isShowing;
    }

    @Override
    public boolean checkSubscribeLink() {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        isShowing = commonFunctions.isElementVisible(subscribeButton, 10, "subscribe Button on Home page");
        return isShowing;
    }

    @Override
    public boolean checkSubscribeRedirection(String choosePlan) {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.clickElement(subscribeButton, 10, "subscribe Button on Home page");
        isShowing = commonFunctions.isElementDisplayed(subscribeChoosePlanText, 10, "Choose a plan");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkSignInLinkRedirection(String loginRegisterText, String google, String facebook, String apple, String emailOrMobile) {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.clickElement(signInButton, 10, "signIn Button on Home page");
        isShowing = commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(loginOrRegisterText, loginRegisterText, 10, "Login or Register text");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(continueWithGoogleButton, google, 10, "Continue with Google text");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(continueWithFacebookButton, facebook, 10, "Continue with Facebook text");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(continueWithAppleButton, apple, 10, "Continue with Apple text");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(loginWithEmailOrMobile, emailOrMobile, 10, "Continue with Email or Mobile text");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkStoryNavigationWSJCrousel(String text) {
        boolean isShowing;
        clickOnHomeButtonWithHandlingDarkMode();
        isShowing = commonFunctions.checkElementVisibilityByScrolling(wsjLogo, "WSJ logo");
        commonFunctions.checkElementVisibilityByScrolling(WsjStory, "wsj story");
        String headline = commonFunctions.getElementText(firstStoryWsj.get(1), 10);
        commonFunctions.clickElement(firstStoryWsj.get(1), 10, "first Story Wsj");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(firstStoryHeadline, headline, 10, "First story headline on story page");
        return isShowing;
    }

    @Override
    public boolean checkBottomNavigationSection() {
        clickOnHomeButtonWithHandlingDarkMode();
        return checkAllNavigationButton();
    }

    @Override
    public boolean checkMyAccountLink() {
        return commonFunctions.isElementDisplayed(myAccount, 10, "myAccount Buttom");
    }

    @Override
    public boolean subscribedUserAdsFreeHomepage() {
        commonFunctions.scrollToBottomForAndroidNative();
        return commonFunctions.isElementNotDisplayed(removeAd, 10, "remove Ad icon");
    }

    public boolean checkAllNavigationButton() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(homeButton, 10, "Home button");
        isShowing &= commonFunctions.isElementDisplayed(newsTab, 10, "news tab");
        isShowing &= commonFunctions.isElementDisplayed(market, 10, "market Button");
        isShowing &= commonFunctions.isElementDisplayed(premium, 10, "premium Button");
        isShowing &= commonFunctions.isElementDisplayed(forYouTab, 10, "for You Button");
        return isShowing;
    }

    @Override
    public boolean checkHomePage() {
        boolean isHomePageLoaded = true;
        commonFunctions.clickElement(mintLogo, 10, "Mint Logo");
        commonFunctions.dummyWait(5);
        Utils.logStepInfo(true, "Checking for Home Menu button present at the home page.");
        isHomePageLoaded = commonFunctions.isElementDisplayed(homeButton, 10, "Home menu button");

        return isHomePageLoaded;
    }

    @Override
    public boolean subscribedUserAdsFreeApp() {
        boolean adsFree;
        commonFunctions.clickElement(home, 10, "HomePage Button");
        adsFree = commonFunctions.isElementNotDisplayed(subscribeButton, 10, "Subscribe Button");
        adsFree &= commonFunctions.isElementNotDisplayed(removeAd, 10, "Remove Ad Button");
        return adsFree;
    }


    @Override
    public boolean sponsoredStory() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToBottomForAndroidNative();
        isShowing = commonFunctions.scrollDownToElement(sponsoredStory, "Sponsored Story");
        commonFunctions.clickElement(sponsoredStory, 10, "Sponsored Story");
        commonFunctions.pressAndroidBackKey();
        return isShowing;
    }

    @Override
    public boolean checkBookmarkBeforeLogin() {
        commonFunctions.clickElementIfDisplayed(yesIAmButton, 10, "Yes I am in button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad close");
        commonFunctions.clickElement(homeButton, 10, "Homepage Button");
        commonFunctions.clickElement(bookmarkIcon, 10, "Bookmark Button");
        boolean LoginPopupAppears = commonFunctions.isElementDisplayed(loginPopup, 10, "Login Popup");
        commonFunctions.clickElement(loginButton, 10, "Login Button in Popup");
        boolean LoginButtonRedirection = commonFunctions.isElementDisplayed(loginBox, 10, "Email or Mobile Login Box");
        commonFunctions.pressAndroidBackKey();

        return LoginPopupAppears && LoginButtonRedirection;
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryOn() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home Page");
        commonFunctions.clickElement(newsTab, 10, "news button");
        isShowing = commonFunctions.isElementDisplayed(newsPage, 10, "news page");
        isShowing &= commonFunctions.isElementNotDisplayed(sponsoredStory, 10, "sponsored story");
        commonFunctions.clickElement(premium, 10, "trending button");
        isShowing &= commonFunctions.isElementDisplayed(premiumTitle, 10, "premium page");
        isShowing &= commonFunctions.isElementNotDisplayed(sponsoredStory, 10, "sponsored story");
        return isShowing;
    }

    @Override
    public boolean checkBrandedContent() {
        clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.scrollDownToElement(firstAdHomePage);
        commonFunctions.scrollUntilElementFound(brandedContent);
        boolean isBrandedContentDisplayed = commonFunctions.isElementDisplayed(brandedContent, 10, "Branded Content on homepage");
        return isBrandedContentDisplayed;
    }

    @Override
    public boolean checkInVisibilityOfNewArticleAfterRefreshedHomePage() {
        boolean isShowing;
        isShowing = checkAppRefreshFunctionality();
        commonFunctions.clickElement(home, 10, "HomeTab Button");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementNotDisplayed(newArticle, 7, "New Articles on Home page after page refresh");
        return isShowing;
    }

    @Override
    public boolean checkInVisibilityOfNewArticleOnHomePageAfterClickOnNewArticle() {
        boolean isShowing;
        isShowing = checkAppRefreshFunctionality();
        commonFunctions.clickElement(newArticle, 10, "New Articles");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementNotDisplayed(newArticle, 5, "New Articles on Home after click");
        return isShowing;
    }

    @Override
    public boolean checkNewArticlesOnlyOnHomePage() {
        boolean isShowing;
        isShowing = checkAppRefreshFunctionality();
        commonFunctions.clickElement(latest, 10, "Latest Tab");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticle, 5, "New Articles");
        commonFunctions.clickElement(market, 10, "trending tab");
        isShowing &= commonFunctions.isElementDisplayed(market, 10, "trending page");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticle, 5, "New Articles");
        commonFunctions.clickElement(premium, 10, "premium tab");
        isShowing &= commonFunctions.isElementDisplayed(premium, 10, "premium page");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticle, 5, "New Articles");
        commonFunctions.clickElement(explore, 10, "explore tab");
        isShowing &= commonFunctions.isElementDisplayed(explore, 10, "Explore page");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticle, 5, "New Articles");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailLineGraph() {
        boolean isShowing;
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.scrollDownToElement(viewAllTopGainers);
        commonFunctions.clickElement(viewAllTopGainers, 10, "view all top gainers button");
        commonFunctions.isElementDisplayed(topGainersHeader, 10, "Gainers Page Header");
        commonFunctions.clickElement(stock, 10, "Company Stock");
        isShowing = commonFunctions.isElementDisplayed(lineGraph, 10, "Line graph chart");
        isShowing &= commonFunctions.isElementDisplayed(graph1Day, 10, "Line Graph 1day option");
        isShowing &= commonFunctions.clickElement(graph5Days, 10, "Line Graph 5days option");
        isShowing &= commonFunctions.clickElement(graph1Month, 10, "Line Graph 1month option");
        isShowing &= commonFunctions.clickElement(graph1Year, 10, "Line Graph 1year option");
        isShowing &= commonFunctions.clickElement(graph5Year, 10, "Line Graph 5year option");
        return isShowing;
    }

    @Override
    public boolean checkDetailPageOfNseAndBse() {
        boolean isShowing;
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.scrollDownToElement(viewAllTopGainers);
        commonFunctions.clickElement(viewAllTopGainers, 10, "view all top gainers button");
        commonFunctions.isElementDisplayed(topGainersHeader, 10, "Gainers Page Header");
        commonFunctions.clickElement(stock, 10, "Company Stock");
        commonFunctions.clickElement(bseStockDetail, 10, "Stock Detail Page BSE");
        isShowing = commonFunctions.isElementDisplayed(lineGraph, 10, "Line Graph with multiple option");
        commonFunctions.clickElement(nseStockDetail, 10, "Stock Detail Page NSE");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "Line Graph with multiple option");
        commonFunctions.isElementDisplayed(openingPrice, 10, "Day Opening Price");
        commonFunctions.isElementDisplayed(prevClosingPrice, 10, "Previous Day closing price");
        commonFunctions.isElementDisplayed(dayHighPrice, 10, "Day Highest Price");
        commonFunctions.isElementDisplayed(dayLowPrice, 10, "Day Lowest Price");
        isShowing &= commonFunctions.isElementDisplayed(graph1Day, 10, "Line Graph 1day option");
        isShowing &= commonFunctions.clickElement(graph5Days, 10, "Line Graph 5days option");
        isShowing &= commonFunctions.clickElement(graph1Month, 10, "Line Graph 1month option");
        isShowing &= commonFunctions.clickElement(graph1Year, 10, "Line Graph 1year option");
        isShowing &= commonFunctions.clickElement(graph5Year, 10, "Line Graph 5year option");
        commonFunctions.scrollDownToElement(financials);
        isShowing &= commonFunctions.isElementDisplayed(yearHighPrice, 10, "52 Weeks Highest Price");
        isShowing &= commonFunctions.isElementDisplayed(yearLowPrice, 10, "52 Weels lowest price");
        return isShowing;
    }

    @Override
    public boolean checkMarketTickerNiftyBankDetailPage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(viewAll, 10, "View All");
        isShowing = commonFunctions.isElementDisplayed(niftyBank, 10, "market ticker Page Nifty Bank");
        commonFunctions.clickElement(niftyBank, 10, "Market ticker nifty bank");
        isShowing &= commonFunctions.isElementDisplayed(niftyBankDetailPage, 10, "Nifty Bank detail Page");
        commonFunctions.pressAndroidBackKey();

        return isShowing;
    }

    @Override
    public boolean checkTickerStockMarketNiftyAndSenSex() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(viewAll, 10, "View All");
        isShowing = commonFunctions.isElementDisplayed(niftyBank, 10, "market ticker Page Nifty Bank");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerBSESENSEX, 10, "market ticker Page SenSex");
        return isShowing;
    }

    @Override
    public boolean checkTopGainersViewAll() {
        boolean isShowing;
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.scrollDownToElement(viewAllTopGainers);
        commonFunctions.clickElement(viewAllTopGainers, 10, "view all top button");
        isShowing &= commonFunctions.isElementDisplayed(topGainerPage, 10, "top gainers page");
        isShowing &= commonFunctions.isElementDisplayed(listOfTopGainerCompany, 10, "list Of TopGainer Company");
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAll() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        isShowing = commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(viewAll, 10, "View All Indian Indices");
        isShowing &= commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices Page Heading");
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesList() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.isElementDisplayed(indicesHeader, 10, "Indices Names Column");
        commonFunctions.isElementDisplayed(bse100, 10, "Bse 100");
        commonFunctions.isElementDisplayed(bse200, 10, "Bse 200");
        commonFunctions.isElementDisplayed(bse500, 10, "Bse 500");
        commonFunctions.isElementDisplayed(bankex, 10, "Bse Bankex");
        isShowing = commonFunctions.isElementNotDisplayed(auto, 10, "Bse Auto");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(viewAllButton, 10, "View All Indian Indices");
        isShowing &= commonFunctions.isElementDisplayed(auto, 10, "Bse Auto");
        return isShowing;
    }

    @Override
    public boolean checkIndicesSection() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.isElementDisplayed(indicesHeader, 10, "Indices Names Column");
        commonFunctions.isElementDisplayed(priceAndChange, 10, "Current Price & Changes % column Header");
        isShowing = commonFunctions.isElementDisplayed(bse100, 10, "Bse 100");
        isShowing &= commonFunctions.isElementDisplayed(priceAndChange, 10, "Latest Stock Price");
        isShowing &= commonFunctions.isElementDisplayed(percerntChange, 10, "Percent Change in Stock Price");

        return isShowing;
    }

    @Override
    public boolean checkNseTop4GainersAndLosers() {
        boolean isShowing;
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(nseGainerLoser, 10, "NSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        return isShowing;
    }

    @Override
    public boolean checkBseTop4GainersAndLosers() {
        boolean isShowing;
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(bseGainerLoser, 10, "BSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        return isShowing;
    }

    @Override
    public boolean checkGainersAndLosers() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser);
        isShowing = commonFunctions.isElementDisplayed(topGainers, 10, "Top Gainers List");
        isShowing &= commonFunctions.isElementDisplayed(topLosers, 10, "Top Losers List");
        isShowing &= commonFunctions.isElementDisplayed(gainerLoserList, 10, "Gainers and Losers List");
        return isShowing;
    }

    @Override
    public boolean checkBse100NewsSection() {
        boolean isShowing;
        checkIndicesRedirectionFunctionality();
        commonFunctions.scrollDownToElement(newsBse100);
        isShowing = commonFunctions.isElementDisplayed(newsBse100, 10, "S&P BSE 100 News Section Header");
        return isShowing;
    }

    @Override
    public boolean checkIndicesRedirectionFunctionality() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(marketPage, 10, "Markets Section Page Heading");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.clickElement(bse100, 10, "S&P BSE 100 Indice");
        isShowing = commonFunctions.isElementDisplayed(bse100, 10, "S&P BSE 100 Indice Page Header");
        return isShowing;
    }

    @Override
    public boolean checkAppRefreshFunctionality() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.dummyWait(5);
        commonFunctions.launchAppFromBackground(5);
        commonFunctions.isElementDisplayed(home, 10, "Home Tab");
        isShowing = commonFunctions.isElementDisplayed(newArticle, 10, "New Articles on Home page after relaunch the app");
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdButtonFunctionality() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "first Story home page");
        commonFunctions.clickElement(firstAdsRemoveAdButton, 10, "remove ad button");
        isShowing &= commonFunctions.isElementDisplayed(planPage, 10, "plan page ");
        commonFunctions.clickElement(back, 10, "Back");
        return isShowing;
    }

    @Override
    public boolean checkAdvertisementLabelAndRemoveAdsButtonPosition(String advertisement, String removeAd) {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "first Story home page");
        String advertisementPosition = "(100, 418)";
        String removeAdsPosition = "(798, 403)";
        String advLabel = firstAdsAdvertisementLabel.getLocation().toString();
        String removeAdButton = firstAdsRemoveAdButton.getLocation().toString();
        if (advLabel.equals(advertisementPosition) || removeAdButton.equals(removeAdsPosition)) {
            isShowing &= true;
            Utils.logStepInfo(true, "Advertisement label present at top left & Remove Ads is present at top right of Ads box verification successfully !!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "Advertisement label NOT present at top left & Remove Ads NOT present at top right of Ads box verification Fail*****");
        }
        return isShowing;
    }

    @Override
    public boolean checkTopGainersViewAllFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.scrollDownToElement(viewAllTopGainers);
        commonFunctions.clickElement(viewAllTopGainers, 10, "view all top button");
        isShowing &= commonFunctions.isElementDisplayed(topGainerPage, 10, "top gainers page");
        isShowing &= commonFunctions.isElementDisplayed(listOfTopGainerCompany, 10, "list Of TopGainer Company");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkTopLosersViewAllFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.swipeElementUsingTouchAction(1009, 1253, 134, 1345);
        commonFunctions.scrollDownToElement(viewAllTopLosers);
        commonFunctions.clickElement(viewAllTopLosers, 10, "view all top losers button");
        isShowing &= commonFunctions.isElementDisplayed(topLosersPage, 10, "top Losers page");
        isShowing &= commonFunctions.isElementDisplayed(listOfTopGainerCompany, 10, "list Of Toploser Company");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkBseTabsGainerLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(bseGainerLoser, 10, "BSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkNseTabsGainerLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(nseGainerLoser, 10, "NSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkGainerLosersDesign(String gainerLoserText) {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(gainerLoser);
        isShowing &= commonFunctions.getElementTextAndCheck(gainerLoser, gainerLoserText, 10, "gainer & loser");
        isShowing &= commonFunctions.isElementDisplayed(updateTime, 10, "update time");
        isShowing &= commonFunctions.isElementDisplayed(bseGainerLoser, 10, "BSE tag");
        isShowing &= commonFunctions.isElementDisplayed(nseGainerLoser, 10, "NSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    public boolean topFourGainerLoserCompanyWithSeperateCard() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(listOfTop4CompanySeperateCards.get(1), 10, "list Of Top 4 Gainers Company Seperate Cards");
        isShowing &= commonFunctions.isElementDisplayed(listOfTop4GainerCompany, 10, "top 4 bse gainer");
        commonFunctions.swipeElementUsingTouchAction(1009, 1253, 134, 1345);
        isShowing &= commonFunctions.isElementDisplayed(listOfTop4CompanySeperateCards.get(2), 10, "list Of Top 4 Loser Company Seperate Cards");
        isShowing &= commonFunctions.isElementDisplayed(listOfTop4LoserCompany, 10, "top 4 bse loser");
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(mostActiveByVolume);
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolume, 10, "most active by volume");
        isShowing &= commonFunctions.isElementDisplayed(updateStatusMostActiveByVolume, 10, "update status");
        isShowing &= commonFunctions.isElementDisplayed(bseTagMostActiveByVolume, 10, "Bse tag");
        isShowing &= commonFunctions.isElementDisplayed(nseTagMostActiveByVolume, 10, "Nse tag");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        isShowing &= commonFunctions.isElementDisplayed(securityTagMostActiveByVolume, 10, "security tag");
        isShowing &= commonFunctions.isElementDisplayed(volumeTagMostActiveByVolume, 10, "volume tag");
        isShowing &= commonFunctions.isElementDisplayed(changeTagMostActiveByVolume, 10, "change tag");
        isShowing &= commonFunctions.isElementDisplayed(topFourMostActiveByVolume, 10, "top 4 company list");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(mostActiveByVolume);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        String text = commonFunctions.getElementText(topFirstMostActiveByVolume.get(1), 10);
        commonFunctions.clickElement(topFirstMostActiveByVolume.get(1), 10, "first stock company");
        isShowing &= commonFunctions.getElementTextAndCheck(fullCompanyNameOnMostActiveByVolume, text, 10, "detail company name");
        isShowing &= commonFunctions.isElementDisplayed(smallCompanyNameOnMostActiveByVolume, 10, "short company name");
        isShowing &= commonFunctions.isElementDisplayed(priceOnMostActiveByVolume, 10, "price tag");
        commonFunctions.clickElement(oneDTag, 10, "1D On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(chartSection, 10, "chart section On Detail Page");
        commonFunctions.clickElement(fiveDTag, 10, "5D On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(chartSection, 10, "chart section On Detail Page");
        commonFunctions.clickElement(oneMTag, 10, "1M On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(chartSection, 10, "chart section On Detail Page");
        commonFunctions.clickElement(oneYTag, 10, "1Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(chartSection, 10, "chart section On Detail Page");
        commonFunctions.clickElement(fiveYTag, 10, "5Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(chartSection, 10, "chart section On Detail Page");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(mostActiveByVolume);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        isShowing &= commonFunctions.clickElement(mostActiveByVolumeViewAll, 10, "view all");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeOnDetailPage, 10, "most Active By Volume Detail Page");
        int v1 = Integer.parseInt(commonFunctions.getElementText(firstVolMostActiveByVolumeOnDetailPage, 10));
        int v2 = Integer.parseInt(commonFunctions.getElementText(secondVolMostActiveByVolumeOnDetailPage, 10));
        if ((isShowing &= v1 > v2)) {
            isShowing &= true;
            Utils.logStepInfo(true, " most active by volume stock volume in Descending order displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "most active by volume stock volume in Descending order displayed *****failed*****");
        }
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    public boolean clickOnMarketTabAndCheckMarketPage() {
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        return commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
    }

    @Override
    public boolean checkMostActiveByVolume() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(mostActiveByVolume);
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolume, 10, "most active by volume");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        isShowing &= commonFunctions.isElementDisplayed(topFourMostActiveByVolume, 10, "top 4 company list");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageInfo() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyMostActiveByVolume();
        isShowing &= companyDetailInfo();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    private boolean companyDetailInfo() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(companyInfoSection, "company information section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(aboutSection, "about section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(aboutExpandTag, "about expand section");
        commonFunctions.clickElement(aboutExpandTag, 10, "about expand tag");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(aboutDetail, "about detail section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(managementSection, "management section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(managementExpandTag, "management expand section");
        commonFunctions.clickElement(managementExpandTag, 10, "management expand tag");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(managementDetail, "management detail section");
        return isShowing;
    }

    @Override
    public boolean checkFinancialStandalone() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyMostActiveByVolume();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(financialsSection, "financial section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(standaloneLabel, "standalone section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dateDropDownLabel, "date dropdown section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(incomeStatementLabel, "income statement section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(incomeRelatedInfo, "income statement related information");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(balanceSheetLabel, "balance sheet ");
        commonFunctions.clickElement(balanceSheetLabel, 10, "balance sheet section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(balanceSheetRelatedInfo, "balance sheet information section");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    private boolean clickOnFirstCompanyMostActiveByVolume() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        commonFunctions.clickElement(topFirstMostActiveByVolume.get(1), 10, "first stock company");
        return isShowing;
    }

    private boolean priceHistoryOnDetailPage() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(openPriceLabel, "open Price Label");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dayHighLabel, "day High Label");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(weekHigh52Label, "52 week High Label");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(bidQuantityLabel, "bid Quantity Label");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(preCloseLabel, "pre close Label");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dayLowLabel, "day Low Label");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(weekLow52Label, "52 week Low Label");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(volumeLabel, "volume Label");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPagePriceHistory() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyMostActiveByVolume();
        isShowing &= priceHistoryOnDetailPage();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageGainerLoser() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPagePriceHistoryGainerLoser() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= priceHistoryOnDetailPage();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    private boolean clickOnFirstCompanyGainerLoser() {
        boolean isShowing;
        commonFunctions.scrollDownToElement(gainerLoser);
        isShowing = commonFunctions.checkElementVisibilityByScrolling(viewAllTopGainers, "view all");
        commonFunctions.clickElement(Top4GainerCompany.get(1), 10, "first company name");
        return isShowing;
    }


    @Override
    public boolean checkMostActiveByVolumeBelowGainernLoser() {
        boolean isShowing;
        commonFunctions.clickElement(marketTab, 10, "Market Section");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(mostActiveByVolume);
        isShowing = commonFunctions.isElementDisplayed(mostActiveByVolume, 10, "Most active by Volume");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All");
        isShowing &= commonFunctions.isElementDisplayed(topFourMostActiveByVolume, 10, "Top four companies list");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesSection() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage");
        commonFunctions.clickElement(marketTab, 10, "Market Dashbaord");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.isElementDisplayed(indicesHeader, 10, "Indices Names");
        commonFunctions.isElementDisplayed(bse100, 10, "Bse 100");
        commonFunctions.isElementDisplayed(bse200, 10, "Bse 200");
        commonFunctions.isElementDisplayed(bse500, 10, "Bse 500");
        commonFunctions.isElementDisplayed(bankex, 10, "Bse Bankex");
        isShowing = commonFunctions.isElementNotDisplayed(auto, 10, "Bse Auto");
        commonFunctions.scrollDownToElement(gainerLoser);
        commonFunctions.clickElement(viewAllButton, 10, "View All Indian Indices");
        isShowing &= commonFunctions.isElementDisplayed(auto, 10, "Bse Auto");
        return isShowing;
    }

    @Override
    public boolean checkGainersAndLosersBelowIndianIndices() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage");
        commonFunctions.clickElement(marketTab, 10, "Market Dasboard");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser);
        isShowing = commonFunctions.isElementDisplayed(topGainers, 10, "Top Gainers List");
        isShowing &= commonFunctions.isElementDisplayed(topLosers, 10, "Top Losers List");
        isShowing &= commonFunctions.isElementDisplayed(gainerLoserList, 10, "Gainers and Losers List");
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageCompanyInfo() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= companyDetailInfo();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserFinancialStandalone() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(financialsSection, "financial section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dateDropDownLabel, "date dropdown section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(incomeStatementLabel, "income statement section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(balanceSheetLabel, "balance sheet ");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPagePriceHistory() {
        return false;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageDesign() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageSpecificIndianIndices() {
        return false;
    }

    @Override
    public boolean checkTickerDetailPage() {
        return false;
    }

    @Override
    public boolean checkTickerPriceAndPercentage() {
        return false;
    }

    @Override
    public boolean checkMarket() {
        return clickOnMarketTabAndCheckMarketPage();
    }

    @Override
    public boolean checkExploreHamburgerPosition(String iosExplorePos, String androidExplorePos) {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "first Story home page");
        if (explore.getLocation().toString().equals(androidExplorePos)) {
            isShowing &= true;
            Utils.logStepInfo(true, "Explore Hamburger is available at left top of the screen verification successfully !!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "Explore Hamburger is Not available at left top of the screen verification Fail*****");
        }
        return isShowing;
    }

    @Override
    public boolean checkNewsSectionReplacingLatestSection() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(newsTab, 10, "news tab");
        isShowing &= commonFunctions.isElementNotDisplayed(oldLatestTab, 5, "latest tab");
        return isShowing;
    }

    @Override
    public boolean checkNoAdsOnHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        //TODO:: as of now RFU is disable after login with subscribed user
//        isShowing = commonFunctions.checkElementVisibilityByScrolling(recommendedForYouCarousel, "RFU carousel");
        isShowing = commonFunctions.isElementNotDisplayed(firstAdsRemoveAdButton, 10, "ads");
        return isShowing;
    }

    @Override
    public boolean newsLetterFunctionalityAndDesign() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = newsLetterBannerDesign();
        isShowing &= readNowFunctionality();
        return isShowing;
    }

    private boolean readNowFunctionality() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(newsLetterReadNow, "newsletter banner");
        commonFunctions.clickElement(newsLetterReadNow, 10, "read now");
        isShowing &= commonFunctions.isElementDisplayed(topOfTheMorningWebView, 10, "top of the morning text");
        commonFunctions.clickElement(backBtn, 10, "back button on web view page");
        return isShowing;
    }

    private boolean newsLetterBannerDesign() {
        int previousStoryWidth = otherStorySize.getSize().getWidth();
        commonFunctions.checkElementVisibilityByScrolling(newsLetterReadNow, "newsletter banner");
        int newsLetterWidth = newsLetterPosition.getSize().getWidth();
        if (previousStoryWidth == newsLetterWidth) {
            Utils.logStepInfo(true, "Size of the New Letter Banner is same as Story List card size Verification Successfully !!!!!");
            return true;
        } else {
            Utils.logStepInfo(true, "Size of the New Letter Banner is Not same as Story List card size Verification Failed !!!!!");
            return false;
        }
    }

    @Override
    public boolean checkAdOnHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "first Story home page");
        isShowing &= commonFunctions.isElementNotDisplayed(firstAdsRemoveAdButton, 10, "ad on home page");
        return isShowing;
    }

    @Override
    public boolean checkAdOnStoryDetailPagePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "first Story home page");
        commonFunctions.clickElement(secondStoryOnHomePage, 10, "second story on home page");
        isShowing &= storyDetailPageAdVisibility(mintPremium);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(thirdStoryOnHomePage, "third listing story");
        commonFunctions.clickElement(thirdStoryOnHomePage, 10, "third story on home page");
        isShowing &= storyDetailPageAdVisibility(recommendedForYouCarousel);
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    private boolean storyDetailPageAdVisibility(MobileElement element) {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(firstStoryHeadlineOnStoryDetailPage, 10, "first Story on story detail page");
//        commonFunctions.scrollDownToElement(storyCloseButton);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(storyCloseButton, "home page mint premium");
        isShowing &= commonFunctions.isElementNotDisplayed(firstAdsRemoveAdButton, 10, "ads on story detail page");
        return isShowing;
    }

    @Override
    public boolean checkExploreAsHamburger() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementDisplayed(explore, 10, "explore top left of screen");
    }

    @Override
    public boolean checkExploreRemoveFromNavigation() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementNotDisplayed(exploreBottomNavigation, 10, "explore bottom navigation");
    }

    @Override
    public boolean checkEPaperIcon() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementDisplayed(ePaperIcon, 10, "E-Paper icon");
    }

    @Override
    public boolean checkSubscribeIcon() {
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 10, "Popup Close");
        return commonFunctions.isElementDisplayed(Subscribe, 10, "Subscribe icon");

    }

    @Override
    public boolean checkNewsLetterBanner() {
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Popup Close");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        boolean isNewsBannerDisplayTrue = commonFunctions.scrollDownToElement(newsLetterReadNow);
        boolean isReadNowButtonDisplayTrue = commonFunctions.isElementDisplayed(newsLetterReadNow, 5, "Read Now button for News Letter");
        commonFunctions.clickElement(newsLetterReadNow, 10, "Read Now button for News Letter");
        boolean isNewsLetterPageLandingTrue = commonFunctions.isElementDisplayed(landingPage, 10, "News Letter page landing");
        return isNewsBannerDisplayTrue && isReadNowButtonDisplayTrue && isNewsLetterPageLandingTrue;
    }

    @Override
    public boolean checkPositionOfNewsLetterForSubscribedUser() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        return !commonFunctions.scrollDownToElement(newsLetterReadNow);
    }

    @Override
    public boolean checkSubscribedUser() {
        boolean isAdDisplayTrue = !commonFunctions.isElementNotDisplayed(popUpAdClose, 10, "Popup Close");
        boolean isSubscribeDisplayTrue = commonFunctions.isElementNotDisplayed(Subscribe, 10, "Subscribe icon");
        return isSubscribeDisplayTrue && isAdDisplayTrue;
    }

    @Override
    public boolean checkSqureCardContainsForThatStory() {
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 5, "Popup Close");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        return false;
    }

    @Override
    public boolean checkMarketCardtypePagefunctionality() {
        return false;
    }

    @Override
    public boolean checkMyaccountIcon() {
        return false;
    }

    private boolean checkMarketPage() {
        commonFunctions.clickElement(marketTab, 10, "market tab");
        return commonFunctions.isElementDisplayed(marketPage, 10, "market page");
    }

    @Override
    public boolean checkMutualFundsWidgetAndSubCategoryDropDown() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSectionDropDownValue, "dropDown");
        String text1 = commonFunctions.getElementText(mutualFundsSectionDropDownValue, 10);
        commonFunctions.clickElement(mutualFundDebtCategory, 10, "Debt category");
        String text2 = commonFunctions.getElementText(mutualFundsSectionDropDownValue, 10);
        if (text1 != text2) {
            Utils.logStepInfo(true, "DropDown verified successfully");
            isShowing &= true;
        } else {
            Utils.logStepInfo(false, "DropDown ********verification failed *******");
            isShowing &= false;
        }
        return isShowing;
    }

    @Override
    public boolean checkMutualFundWidgetTitle() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets title");
        return isShowing;
    }

    @Override
    public boolean checkSubCategoryDropDown() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSectionDropDown, "dropdown");
        return isShowing;
    }

    @Override
    public boolean checkSubCategoryDefaultSection() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSectionDropDownValue, "dropDown");
        String text1 = commonFunctions.getElementText(mutualFundsSectionDropDownValue, 10);
        if (text1 != null) {
            Utils.logStepInfo(true, "DropDown verified successfully");
            isShowing &= true;
        } else {
            Utils.logStepInfo(false, "DropDown ********verification failed *******");
            isShowing &= false;
        }
        return isShowing;
    }

    @Override
    public boolean checkMutualFundCategoryTabs() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundCommoditiesCategory, "commodities category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundDebtCategory, 10, "Debt category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundEquityCategory, 10, "Equity category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundGlobalCategory, 10, "Global category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundHybridCategory, 10, "Hybrid category");
        String p1 = mutualFundCommoditiesCategory.getLocation().toString().replaceAll("[()]", "");
        String p2 = mutualFundHybridCategory.getLocation().toString().replaceAll("[()]", "");
        String[] firstCatName = p1.split(",", 2);
        String[] secondCatName = p2.split(",", 2);
        String firstCardPlayBtn = firstCatName[firstCatName.length - 2].trim();
        int firstCatXPosition1 = Integer.parseInt(firstCardPlayBtn);
        String firstCardPlayBt = firstCatName[firstCatName.length - 1].trim();
        int firstCatYPosition1 = Integer.parseInt(firstCardPlayBt);
        String SecondCardXPosition = secondCatName[secondCatName.length - 2].trim();
        int secondCatXPosition1 = Integer.parseInt(SecondCardXPosition);
        String secondCardYPost = secondCatName[secondCatName.length - 1].trim();
        int secondCatYPosition1 = Integer.parseInt(secondCardYPost);
        commonFunctions.swipeElementUsingTouchAction(secondCatXPosition1, secondCatYPosition1, firstCatXPosition1, firstCatYPosition1);
        isShowing &= commonFunctions.isElementDisplayed(mutualFundIndexFundsCategory, 10, "Index Fund category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundOtherCategory, 10, "Other category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundSolutionsOrientedCategory, 10, "Solution Oriented category");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        boolean isShowing;
        isShowing = commonFunctions.clickElement(home, 10, "home tab");
        isShowing &= commonFunctions.clickElement(explore, 10, "Tap on explore Button");
        isShowing &= commonFunctions.clickElement(search, 5, "Tap on search bar");
        isShowing &= commonFunctions.sendKeysOnAndroid(search, "Market Dashboard");
        isShowing &= commonFunctions.pressEnterKey();
        isShowing &= commonFunctions.clickElement(marketDashboard, 10, "Tap Market Dashboard");
        isShowing &= commonFunctions.scrollDownToElement(gainerLoser);
        isShowing &= commonFunctions.clickElement(gainerLoserStock, 10, "Tap on Any stock to access Company detail page");
        isShowing &= commonFunctions.scrollDownToElement(companyinfo, "Company Related Info");
        isShowing &= commonFunctions.scrollDownToElement(companyNews, "Company Related News");
        return isShowing;
    }

    @Override
    public boolean checkSubTitleoFMutualFundPage() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.scrollUpToElementDisplayed(mutualFundsSection);
        isShowing &= commonFunctions.clickElement(viewAllMutualFund, 10, "View All Icon For Mutual Fund");
        isShowing &= commonFunctions.isElementDisplayed(subtitleMutualFundPage, 10, "Sub-title of Mutual fund page is Mutual Funds- top performers");
        return isShowing;
    }

    @Override
    public boolean checkNewEpaperIconOnTop() {
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return commonFunctions.isElementDisplayed(epaperIcon, 10, "new Epaper icon");
    }

    @Override
    public boolean checkNewSignInIconOnTop() {
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return commonFunctions.isElementDisplayed(signInIcon, 10, "new SignIn icon");
    }

    @Override
    public boolean checkNewSubscribeIconOnTop() {
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return commonFunctions.isElementDisplayed(subscribeIcon, 10, "new subscribe icon");
    }

    @Override
    public boolean checkL1TabOnHomePage() {
        commonFunctions.clickElement(homeButton, 10, "home button");
        boolean isShowing = commonFunctions.isElementDisplayed(L1Menu, 10, "home page L1 menu");
        isShowing &= allL1TabOption();
        return isShowing;
    }

    private boolean allL1TabOption() {
        boolean isShowing = false;
        String option1 = commonFunctions.getElementText(l1TabAllOption.get(1), 10);
        String option4 = commonFunctions.getElementText(l1TabAllOption.get(4), 10);
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(l1TabAllOption, 1, "L1 first option");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(l1TabAllOption, 4, "L1 fourth option");
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        String afterL1Option1 = commonFunctions.getElementText(l1TabAllOption.get(1), 10);
        String afterL1Option4 = commonFunctions.getElementText(l1TabAllOption.get(4), 10);
        if (option1 != afterL1Option1 && option4 != afterL1Option4) {
            isShowing = true;
            Utils.logStepInfo(true, "L1 tab all option verification successfully !!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "L1 tab all option verification Fail*****");
        }
        return isShowing;
    }

    @Override
    public boolean checkL1TabSelection() {
        boolean isShowing = clickOnSecondL1Tab();
        isShowing &= commonFunctions.isElementSelected(homeButton, 10, "Home button");
        return isShowing;
    }

    private boolean clickOnSecondL1Tab() {
        commonFunctions.clickElement(homeButton, 10, "home button");
        boolean isShowing = commonFunctions.isElementDisplayed(L1Menu, 10, "home page L1 menu");
        isShowing &= commonFunctions.isElementDisplayed(L1MenuAllOption.get(2), 10, "L1 menu: second option");
        isShowing &= commonFunctions.clickElement(L1MenuAllOption.get(2), 10, "L1 menu: second option");
        isShowing &= commonFunctions.isElementSelected(L1MenuAllOption.get(2), 10, "L1 menu: second option");
        return isShowing;
    }

    @Override
    public boolean checkL1TabBackButtonFunctionality() {
        boolean isShowing = clickOnSecondL1Tab();
        commonFunctions.navigateBack();
        isShowing &= commonFunctions.isElementSelected(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkFocusOnL1TabClickingOnHomeButton() {
        boolean isShowing = clickOnSecondL1Tab();
        isShowing &= commonFunctions.clickElement(homeButton, 10, "Home button");
        isShowing &= commonFunctions.isElementSelected(L1MenuAllOption.get(1), 10, "L1 menu: first option");
        return isShowing;
    }

    @Override
    public boolean checkL1MenuSelectionBySwipingTheHomePage() {
        commonFunctions.clickElement(homeButton, 10, "home button");
        boolean isShowing = commonFunctions.isElementDisplayed(L1Menu, 10, "home page L1 menu");
        commonFunctions.swipeElementUsingTouchAction(946, 748, 113, 748);
        isShowing &= commonFunctions.isElementSelected(L1MenuAllOption.get(2), 10, "L1 menu: second option");
        return isShowing;
    }

    @Override
    public boolean checkTickerCategoryD() {
        commonFunctions.clickElement(homeButton, 10, "home button");
        return commonFunctions.isElementDisplayed(TickerD, 10, "category D");
    }

    @Override
    public boolean checkSectionNameWithListedStory() {
        commonFunctions.clickElement(homeButton, 10, "home button");
        return commonFunctions.isElementDisplayedOfListOfElements(sectionName, "category D");
    }

    @Override
    public boolean checkTickerArrow() {
        commonFunctions.clickElement(homeButton, 10, "home button");
        return commonFunctions.isElementDisplayedOfListOfElements(tickerArrow, "ticker Arrow");
    }

    @Override
    public boolean checkLatestScrollOnLatestNewsPage() {
        return false;
    }

    @Override
    public boolean checkMintTop50MF(String pageTitle) {
        return false;
    }

    @Override
    public boolean checkL1TabSelectionDiffStory() {
        boolean isShowing = clickOnSecondL1Tab();
        String secondTabFirstHeadline = commonFunctions.getElementText(firstStory, 10);
        isShowing &= commonFunctions.clickElement(L1MenuAllOption.get(3), 10, "L1 menu: second option");
        isShowing &= commonFunctions.isElementSelected(L1MenuAllOption.get(3), 10, "L1 menu: second option");
        String thirdTabFirstHeadline = commonFunctions.getElementText(firstStory, 10);
        if (!secondTabFirstHeadline.equals(thirdTabFirstHeadline)) {
            isShowing &= true;
            Utils.logStepInfo(true, "Each L1Tab selection has different story verification successfully !!!!!!!");
        } else {
            isShowing = false;
            Utils.logStepInfo(false, "Each L1Tab selection has Not different story verification failed *******");
        }
        return isShowing;
    }

    @Override
    public boolean checkMintTop50MFForSubscribedUsers(String pageTitle) {
        return false;
    }

    @Override
    public boolean checkColumnsSubSectionInTopNav() {
        return false;
    }

    @Override
    public boolean checkMFSectionInTopNav() {
        return false;
    }

    @Override
    public boolean checkNewsSubsectionUnderMFInTopNav() {
        return false;
    }

    @Override
    public boolean checkViewsSubsectionUnderOpinionInTopNav() {
        return false;
    }

    @Override
    public boolean checkViewsSubsectionStoryPage() {
        return false;
    }

    @Override
    public boolean checkViewsSubsectionPageLayout() {
        return false;
    }

    @Override
    public boolean checkIndustryPageLayout() {
        return false;
    }

    @Override
    public boolean checkOpinionsSectionInTopNav() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbOnCompaniesPage() {
        return false;
    }

    @Override
    public boolean checkTwitterPageWhenTapOnTwitterIcon() {
        return false;
    }

    @Override
    public boolean checkLinkedinPageWhenTapOnLinkedinIcon() {
        return false;
    }

    @Override
    public boolean checkFacebookPageWhenTapOnFacebookIcon() {
        return false;
    }

    @Override
    public boolean checkOpinionSectionStoryDetails() {
        return false;
    }

    @Override
    public boolean checkShareholdingWidget() {
        return false;
    }

    @Override
    public boolean checkCompaniesLandingPage() {
        return false;
    }

    public boolean checkAppLaunch() {
        boolean isShowing = commonFunctions.isElementDisplayed(mintLogo, 10, "Mint Logo");
        isShowing &= commonFunctions.isElementDisplayed(homePageHighlighted, 10, "home Page Highlighted");
        return isShowing;
    }

    @Override
    public boolean checkHeaderElements() {
        boolean isShowing = commonFunctions.isElementDisplayed(exploreMenuButton, 10, "explore menu");
        isShowing &= commonFunctions.isElementDisplayed(mintLogo, 10, "Mint Logo");
        isShowing &= commonFunctions.isElementDisplayed(homePageSearchIcon, 10, "Search icon");
        isShowing &= commonFunctions.isElementDisplayed(myAccounts, 10, "myAccounts");
        isShowing &= commonFunctions.isElementDisplayed(subscribeButton, 10, "subscribed button");
        return isShowing;
    }

    @Override
    public boolean checkPremiumIconOnBottom(){
      return commonFunctions.isElementDisplayed(premium,10,"premium bottom");
    }

    @Override
    public boolean checkPlanPageAllActivePlan() {
        commonFunctions.clickElement(subscribeButton, 10, "subscribed button");
        boolean isShowing = commonFunctions.isElementDisplayed(chooseAPlanButton, 10, "choose A Plan text");
        isShowing &= commonFunctions.isElementDisplayed(listOfActivePlan.get(0), 10, "first plan");
        isShowing &= commonFunctions.isElementDisplayed(listOfActivePlan.get(1), 10, "second plan");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkApplyCouponAndSignInOption() {
        commonFunctions.clickElement(subscribeButton, 10, "subscribed button");
        boolean isShowing = commonFunctions.isElementDisplayed(chooseAPlanButton, 10, "choose A Plan text");
        isShowing &= commonFunctions.isElementDisplayed(signin, 10, "sign in option");
        isShowing &= commonFunctions.isElementDisplayed(applyCoupon, 10, "apply Coupon");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkHeaderNavigationOfEachTab() {
        commonFunctions.clickElement(homeButton, 10, "home button");
        boolean isShowing = commonFunctions.isElementDisplayed(L1Menu, 10, "home page L1 menu");
        commonFunctions.clickElement(L1MenuAllOption.get(1), 10, "L1 menu: first option");
        isShowing &= pageNotBlank();
        commonFunctions.clickElement(L1MenuAllOption.get(2), 10, "L1 menu: second option");
        isShowing &= pageNotBlank();
        commonFunctions.clickElement(L1MenuAllOption.get(3), 10, "L1 menu: third option");
        isShowing &= pageNotBlank();
        commonFunctions.clickElement(L1MenuAllOption.get(4), 10, "L1 menu: fourth option");
        isShowing &= pageNotBlank();
        commonFunctions.clickElement(L1MenuAllOption.get(5), 10, "L1 menu: fifth option");
        isShowing &= pageNotBlank();
        return isShowing;
    }

    public boolean pageNotBlank() {
        boolean isShowing;
        if (isShowing = allStories.size() >= 10) {
            isShowing &= true;
            Utils.logStepInfo(true, "Page not Blank verification successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "Page is Blank verification *****failed*****");
        }
        return isShowing;
    }

    @Override
    public boolean checkPodcastEpisodePage() { return false; }

    @Override
    public boolean checkPodcastEpisode() { return false; }

    @Override
    public boolean checkVideoListingLandingPageStructure() { return false; }

    @Override
    public boolean checkLoginInPage() {
        boolean isShowing;
        commonFunctions.clickElement(subscribeButton, 10, "subscribe button");
        isShowing = commonFunctions.isElementDisplayed(chooseAPlanButton, 10, "chose a plan text");
        commonFunctions.clickElement(subscribeNow, 10, "subscribe Now");
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "Login Page");
        isShowing &= commonFunctions.isElementDisplayed(emailTextBoxMainSignInPage, 10, "email/Phone number text box");
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(1);
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkEditProfileGender() {
        boolean isShowing;
        commonFunctions.clickElement(MyAccount, 10, "profile button");
        commonFunctions.clickElement(editProfileIcon, 10, "edit profile button");
        commonFunctions.clickElement(profileGender, 10, "Gender profile");
        isShowing = commonFunctions.isElementDisplayed(profileGenderMaleBtn, 10, "profile Gender Male Btn");
        commonFunctions.clickElement(profileGenderMaleBtn, 10, "profile Gender Male Btn");
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(profileSaveButton, 10, "save button");
        isShowing &= commonFunctions.checkElementText(profileGenderInputBox, "Male", 10, "Gender profile: Male");
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(1);
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkHomePageAsExpected() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(homeButton, 10, "home tab");
        isShowing &= commonFunctions.isElementDisplayed(newsButton, 10, "News tab");
        isShowing &= commonFunctions.isElementDisplayed(premiumButton, 10, "Premium tab");
        isShowing &= commonFunctions.isElementDisplayed(marketButton, 10, "Market tab");
        isShowing &= commonFunctions.isElementDisplayed(forYouButton, 10, "ForYou tab");
        isShowing &= checkHeaderElements();
        isShowing &= commonFunctions.compareWithSizeListOfElements(L1MenuAllOption, 5, "L1 tab");
        return isShowing;
    }

    @Override
    public boolean checkSubscriptionInformation() {
        boolean isShowing;
        commonFunctions.clickElement(myAccount, 10, "my account");
        isShowing = commonFunctions.isElementDisplayed(subsInfo, 10, "subscription information");
        isShowing &= commonFunctions.isElementDisplayed(currentPlan, 10, "current plan");
        isShowing &= commonFunctions.isElementDisplayed(planName, 10, "plan name");
        isShowing &= commonFunctions.isElementDisplayed(upgradeNowBtn, 10, "upgrade btn");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkAuthorDetailsPage() { return false; }

    @Override
    public boolean checkAuthorPageLayout() { return false; }

    @Override
    public boolean checkSportsLandingPage() { return false; }

    @Override
    public boolean checkL1NavInSportsLandingPage() { return false; }

    @Override
    public boolean checkLHSGainerLoserWidget(String pageName, String widgetName)
    {
        return false;
    }

    @Override
    public boolean checkMintPremiumCarousel() { return false; }

    @Override
    public boolean checkSummaryOnSportsStoryPage() {
        return false;
    }

    @Override
    public boolean checkParagraphOnSportsPage() {
        return false;
    }
}