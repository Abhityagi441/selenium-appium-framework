package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonMarketPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketPage extends CommonMarketPage {

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
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdButton;
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

    @FindBy(id = "com.htmedia.mint:id/nav_more")
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

    @FindBy(id = "com.htmedia.mint:id/txt_my_account")
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

    @FindBy(xpath = "(//android.widget.TextView[@text='View All'])[1]")
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

    @FindBy(xpath = "//android.widget.TextView[@text='Facebook']")
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

    @FindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement loginBox;

    @FindBy(id = "android:id/message")
    private static MobileElement loginPopup;

    @FindBy(id = "agree")
    private static MobileElement acceptCookie;

    @FindBy(xpath = "//android.widget.TextView[@text='uE902']")
    private static MobileElement closePopUp;

    @FindBy(id = "com.htmedia.mint:id/layoutCloseButton")
    private static MobileElement closeBtn;

    @FindBy(id = "com.htmedia.mint:id/ad_headline")
    private static MobileElement sponsoredStory;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.htmedia.mint:id/imgViewBookmark']")
    private static MobileElement sponsoredStoryBookmarkButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement home;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailImageCaption")
    private static MobileElement imageCaption;

    @FindBy(id = "com.htmedia.mint:id/imgViewBookmark")
    private static MobileElement bookmarkStory;

    @FindBy(id = "com.htmedia.mint:id/tvNewArticle")
    private static MobileElement newArticle;

    @FindBy(xpath = "(//*[@text='GAINERS & LOSERS'])[1]")
    private static MobileElement gainerLoser;

    @FindBy(id = "com.htmedia.mint:id/txtCommodityName")
    private static MobileElement gainerLoserList;

    @FindBy(xpath = "//android.widget.TextView[@text='BSE SENSEX']")
    private static MobileElement marketBSESENSEX;

    @FindBy(xpath = "//android.widget.TextView[@text='Top Gainers']")
    private static MobileElement topGainers;

    @FindBy(xpath = "//android.widget.TextView[@text='Top Losers']")
    private static MobileElement topLosers;

    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE SENSEX']")
    private static MobileElement marketTickerBSESENSEX;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Markets']")
    private static MobileElement marketTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Market Dashboard']")
    private static MobileElement marketPage;

    @FindBy(xpath = "//android.widget.TextView[@text='Remove Ad']")
    private static MobileElement homePageLeadAd;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY 50']")
    private static MobileElement marketNifty50;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY BANK']")
    private static MobileElement marketNiftyBank;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY Bank']")
    private static MobileElement niftyBank;

    @FindBy(xpath = "//android.widget.TextView[@text='BSE MIDCAP']")
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

    @FindBy(id = "(//android.widget.LinearLayout/android.widget.TextView[2])[13]")
    private static MobileElement mostActVolCompanyPrice;
    @FindBy(id = "(//android.widget.RelativeLayout[1]/android.widget.TextView[2])[6]")
    private static MobileElement companycurrentPrice;

    @FindBy(id = "(//android.widget.LinearLayout/android.widget.TextView[3])[10]")
    private static MobileElement mostActVolCompanyPriceChange;
    @FindBy(id = "(//android.widget.RelativeLayout[2]/android.widget.TextView)[8]")
    private static MobileElement companyPriceChange;
    @FindBy(id = "(//android.widget.RelativeLayout[2]/android.widget.TextView)[7]")
    private static MobileElement losersCompanyPriceChange;

    @FindBy(id = "com.htmedia.mint:id/txtPercentChange")
    private static MobileElement percerntChange;

    @FindBy(id = "com.htmedia.mint:id/txtCommodityValue")
    private static MobileElement marketGoldIndex;

    @FindBy(xpath = "//android.widget.TextView[@text='Back']")
    private static MobileElement backBtn;

    @FindBy(id = "com.htmedia.mint:id/nav_latest")
    private static MobileElement latest;

    @FindBy(id = "com.htmedia.mint:id/nav_popular")
    private static MobileElement market;

    @FindBy(id = "com.htmedia.mint:id/nav_myReads")
    private static MobileElement premium;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY Bank']")
    private static MobileElement niftyBankDetailPage;

    @FindBy(id = "com.htmedia.mint:id/imgViewShare")
    private static MobileElement shareIconUnderStory;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.htmedia.mint:id/imgViewShare']")
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

    @FindBy(id = "com.htmedia.mint:id/txt2")
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

    @FindBy(xpath = "//android.widget.TextView[@text='News']")
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

    @FindBy(xpath = "//android.widget.TextView[@text='S&P BSE Mid-Cap']")
    private static MobileElement marketBseMidCapLandingPage;

    @FindBy(xpath = "(//android.widget.TextView[@text='GOLD'])[1]")
    private static MobileElement marketGoldLandingPage;

    @FindBy(xpath = "(//android.widget.TextView[@text='SILVER'])[1]")
    private static MobileElement marketSilverLandingPage;

    @FindBy(xpath = "//android.widget.TextView[@text='Nifty 50']")
    private static MobileElement marketNifty50LandingPage;

    @FindBy(xpath = "//android.widget.TextView[@text='Nifty Bank']")
    private static MobileElement marketNiftyBankLandingPage;

    @FindBy(id = "com.htmedia.mint:id/txtViewCommodity")
    private static List<MobileElement> marketTickerElementsList;

    @FindBy(id = "com.htmedia.mint:id/txtEpaper")
    private static MobileElement e_paperLink;

    @FindBy(id = "com.htmedia.mint:id/txtViewEpaper")
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
    @FindBy(xpath ="//android.widget.TextView[@text='Continue with Google']")
    private static MobileElement continueWithGoogleButton;
    @FindBy(xpath ="//android.widget.TextView[@text='Continue with Facebook']")
    private static MobileElement continueWithFacebookButton;
    @FindBy(id = "com.htmedia.mint:id/apple_login_tv")
    private static MobileElement continueWithAppleButton;
    @FindBy(id = "com.htmedia.mint:id/email_or_mobile_tv")
    private static MobileElement loginWithEmailOrMobile;
    @FindBy(id = "com.htmedia.mint:id/imgWsjLogo")
    private static MobileElement wsjLogo;
    @FindBy(id = "com.htmedia.mint:id/title_inner_collection")
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
    @FindBy(id = "com.htmedia.mint:id/recyclerViewMarketDetail")
    private static MobileElement listOfCompanies;
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
    @FindBy(xpath = "(//android.widget.RelativeLayout/android.widget.ImageView)[2]")
    private static MobileElement popUpAdClose;
    @FindBy(xpath= "//*[@text='Open Price']")
    private static MobileElement openingPrice;
    @FindBy(xpath = "//*[@text='Prev Close']")
    private static MobileElement prevClosingPrice;
    @FindBy(xpath = "//*[@text='Today’s High']")
    private static MobileElement dayHighPrice;
    @FindBy(xpath = "//*[@text='Today’s Low']")
    private static MobileElement dayLowPrice;
    @FindBy(id = "com.htmedia.mint:id/WH52Label")
    private static MobileElement yearHighPrice;
    @FindBy(id = "com.htmedia.mint:id/WH52Label")
    private static MobileElement yearLowPrice;
    @FindBy(id = "com.htmedia.mint:id/financialsHeading")
    private static MobileElement financials;
    @FindBy(xpath= "(//android.widget.TextView[@text='BSE'])[3]")
    private static MobileElement mostActBse;
    @FindBy(xpath= "(//android.widget.TextView[@text='NSE'])[3]")
    private static MobileElement mostActNse;
    @FindBy(id = "com.htmedia.mint:id/recyclerViewMarketDetail")
    private static MobileElement listOfTopLosersCompanies;
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
    @FindBy(xpath = "//android.widget.TextView[@text='MINT PREMIUM']")
    private static MobileElement mintPremium;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/viewPagerGainerLoser']//following::*[@resource-id='com.htmedia.mint:id/txtViewViewAll'])[1]")
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
    @FindBy(xpath = "(//android.widget.TextView[@text='BSE'])[3]")
    private static MobileElement gainerBSE;
    @FindBy(xpath = "(//android.widget.TextView[@text='NSE'])[3]")
    private static MobileElement gainerNSE;
    @FindBy(xpath = "(//android.widget.TextView[@text='BSE'])[2]")
    private static MobileElement losersBSE;
    @FindBy(xpath = "(//android.widget.TextView[@text='NSE'])[2]")
    private static MobileElement losersNSE;
    @FindBy(xpath = "(//android.widget.LinearLayout/android.widget.RelativeLayout[1])[18]")
    private static MobileElement gainerNSECompany;
    @FindBy(xpath = "(//android.widget.RelativeLayout[1]/android.widget.TextView[1])[18]")
    private static MobileElement losersNSECompany;
    @FindBy(xpath = "(//android.widget.LinearLayout/android.widget.TextView[1])[29]")
    private static MobileElement mostActByVolCompany;
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
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/recyclerview_most_active']//following-sibling::*[@resource-id='com.htmedia.mint:id/security']")
    private static List<MobileElement> topFirstMostActiveByVolume;
    @FindBy(id = "com.htmedia.mint:id/viewAll")
    private static MobileElement mostActiveByVolumeViewAll;
    @FindBy(xpath = "//android.widget.TextView[@text='MOST ACTIVE BY VOLUME']")
    private static MobileElement mostActiveByVolumeOnDetailPage;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/volume']")
    private static List<MobileElement> mostActiveByVolumeOnDetailPageVolume;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/parent_layout']//following::android.widget.TextView)[2]")
    private static MobileElement smallCompanyNameOnMostActiveByVolume;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/parent_layout']//following::android.widget.TextView)[1]")
    private static MobileElement fullCompanyNameOnMostActiveByVolume;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/parent_layout']//following::android.widget.TextView)[3]")
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
    @FindBy(xpath = "(//android.widget.TextView[@text='Financials'])[2]")
    private static MobileElement financialsSection;
    @FindBy(id = "com.htmedia.mint:id/incomeName")
    private static MobileElement incomeStatementLabel;
    @FindBy(id = "com.htmedia.mint:id/balanceSheetName")
    private static MobileElement balanceSheetLabel;
    @FindBy(id = "com.htmedia.mint:id/dateDropDownLayout")
    private static MobileElement dateDropDownLabel;
    @FindBy(id = "com.htmedia.mint:id/standAloneLabel")
    private static MobileElement standaloneLabel;
    @FindBy(id = "com.htmedia.mint:id/standAloneBackGround")
    private static MobileElement incomeRelatedInfo;
    @FindBy(id = "com.htmedia.mint:id/standAloneBackGround")
    private static MobileElement balanceSheetRelatedInfo;
    @FindBy(xpath = "//android.widget.TextView[@text='About Company']")
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
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/recyclerViewGainerLoser']/android.widget.LinearLayout")
    private static List<MobileElement> Top4GainerCompany;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(xpath = "//android.widget.TextView[@text='Market Dashboard']")
    private static MobileElement marketDashboard;
    @FindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/txtCommodityName'])[5]")
    private static MobileElement gainerLoserStock;
    @FindBy(xpath = "//android.widget.TextView[@text='COMPANY INFORMATION']")
    private static MobileElement companyinfo;
    @AndroidFindBy(id = "com.htmedia.mint:id/llViewAll")
    private static MobileElement mutualFundViewAll;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MUTUAL FUNDS']")
    private static MobileElement mutualFundListingPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NAV']//following-sibling::*[@resource-id='com.htmedia.mint:id/value']")
    private static List<MobileElement> mutualFundListingPageNav;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tvFundName']")
    private static List<MobileElement> mutualFundName;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/llSummery']//android.widget.TextView)[1]")
    private static MobileElement mutualFundNameDetailPage;
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
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tv_name']")
    private static List<MobileElement> listingPageMutualFundName;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/txtViewNewsHeadline'])[1]")
    private static MobileElement listingStoryHeadline;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='1M'])[1]")
    private static MobileElement oneMReturnPercentage;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='3M'])[1]")
    private static MobileElement threeMReturnPercentage;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='6M'])[1]")
    private static MobileElement sixMReturnPercentage;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='1Y'])[1]")
    private static MobileElement oneYReturnPercentage;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='3Y'])[1]")
    private static MobileElement threeYReturnPercentage;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='5Y'])[1]")
    private static MobileElement fiveYReturnPercentage;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/tabView")
    private static MobileElement tableView;
    @AndroidFindBy(id = "com.htmedia.mint:id/chart")
    private static MobileElement tableChart;
    @AndroidFindBy(id = "com.htmedia.mint:id/holding")
    private static MobileElement topHoldingSection;
    @AndroidFindBy(id = "com.htmedia.mint:id/rvHoldingList")
    private static MobileElement topHoldingSectionList;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tvStokesName']")
    private static List<MobileElement> topHoldingSectionStockName;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tvTotalHoldings']")
    private static List<MobileElement> topHoldingSectionTotalHolding;
    @AndroidFindBy(id = "com.htmedia.mint:id/llPiChart")
    private static MobileElement portfolioSection;
    @AndroidFindBy(id = "com.htmedia.mint:id/chart")
    private static MobileElement portfolioInnerCircle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Asset Allocation']")
    private static MobileElement portfolioAssets;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nav vs Time/Day']")
    private static MobileElement navTimeDay;
    @AndroidFindBy(id = "com.htmedia.mint:id/llReturns")
    private static MobileElement returnSection;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 month']")
    private static MobileElement returnTableOneM;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3 month']")
    private static MobileElement returnTableThreeM;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='6 month']")
    private static MobileElement returnTableSixM;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 year']")
    private static MobileElement returnTableOneY;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2 year']")
    private static MobileElement returnTableTwoY;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3 year']")
    private static MobileElement returnTableThreeY;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='5 year']")
    private static MobileElement returnTableFiveY;
    @AndroidFindBy(id = "com.htmedia.mint:id/llSummery")
    private static MobileElement fundSummery;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvBenchmarkTitle")
    private static MobileElement fundSummeryBenchMark;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvDividendTitle")
    private static MobileElement fundSummeryDividend;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvCategoryTitle")
    private static MobileElement fundSummeryCategory;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvLaunchDateTitle")
    private static MobileElement fundSummeryLaunchDate;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvMinimumSIPTitle")
    private static MobileElement fundSummeryMinimumSip;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvExpenseRatioTitle")
    private static MobileElement fundSummeryExpenseRatio;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NAV']")
    private static List<MobileElement> mutualFundListingPageNavText;
    @AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='com.htmedia.mint:id/et_dropDown']//android.widget.TextView")
    private static MobileElement mutualFundListingPageDropdown;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/security'])[1]")
    private static MobileElement mostActByVolFirstSecurityName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MOST ACTIVE BY VOLUME']//following::*[@resource-id='com.htmedia.mint:id/layoutRelative']")
    private static MobileElement mostActByVolSection;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tablayout']//android.widget.LinearLayout")
    private static List<MobileElement> mostActByVolDetailPageTabLayout;
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc='Overview'])[1]")
    private static MobileElement overviewTabLayout;
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc='Analysis'])[1]")
    private static MobileElement analysisTabLayout;
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc='News'])[1]")
    private static MobileElement newsTabLayout;
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc='Forecast'])[1]")
    private static MobileElement forecastTabLayout;
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc='Financials'])[1]")
    private static MobileElement financialsTabLayout;
    @AndroidFindBy(id = "com.htmedia.mint:id/company_name_new")
    private static MobileElement mostActByVolDetailPageCompanyName;
    @AndroidFindBy(id = "com.htmedia.mint:id/iv_share")
    private static MobileElement mostActByVolDetailPageShareIcon;
    @FindBy(xpath = "//android.widget.TextView[@text='Bluetooth']")
    private static MobileElement bluetoothText;
    @FindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    private static MobileElement gmailText;
    @FindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private static MobileElement messageText;
    @FindBy(xpath = "//android.widget.TextView[@text='Save to Drive']")
    private static MobileElement driveText;
    @AndroidFindBy(id = "com.htmedia.mint:id/btAddStocks")
    private static MobileElement mostActByVolDetailPageAddToWatchList;
    @AndroidFindBy(id = "com.htmedia.mint:id/indAmtPoints")
    private static MobileElement mostActByVolDetailPageAmtPoints;
    @AndroidFindBy(id = "com.htmedia.mint:id/updateTime")
    private static MobileElement mostActByVolDetailPageUpdateTime;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/layoutBse'])[1]")
    private static MobileElement mostActByVolDetailPageBseTab;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/layoutNse'])[1]")
    private static MobileElement mostActByVolDetailPageNseTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Price Range']")
    private static MobileElement mostActByVolDetailPagePriceRange;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Today’s Low']")
    private static MobileElement mostActByVolDetailPagePriceRangeTodayLow;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Today’s High']")
    private static MobileElement mostActByVolDetailPagePriceRangeTodayHigh;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='52 Week Low']")
    private static MobileElement mostActByVolDetailPagePriceRangeWeekLow;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='52 Week High']")
    private static MobileElement mostActByVolDetailPagePriceRangeWeekHigh;
    @AndroidFindBy(id = "com.htmedia.mint:id/keymatrics")
    private static MobileElement mostActByVolDetailPageKewMatrics;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Market Cap (In Cr)']")
    private static MobileElement mostActByVolDetailPageKewMatricsMarketCaps;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TTM P/E']")
    private static MobileElement mostActByVolDetailPageKewMatricsTTM;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sector P/E']")
    private static MobileElement mostActByVolDetailPageKewMatricsSector;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dividend Yield (%)']")
    private static MobileElement mostActByVolDetailPageKewMatricsDividend;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Beta']")
    private static MobileElement mostActByVolDetailPageKewMatricsBeta;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Face Value']")
    private static MobileElement mostActByVolDetailPageKewMatricsFaceValue;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Open Price']")
    private static MobileElement mostActByVolDetailPageKewMatricsOpenPrice;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Prev Close']")
    private static MobileElement mostActByVolDetailPageKewMatricsPrevClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_price_anaylsis")
    private static MobileElement mostActByVolDetailPagePriceAnaylsis;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Analysis'])[2]")
    private static MobileElement mostActByVolDetailPageAnaylsis;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_price")
    private static MobileElement mostActByVolDetailPageAnaylsisChart;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 Week']")
    private static MobileElement mostActByVolDetailPageAnaylsis1Week;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 Month']")
    private static MobileElement mostActByVolDetailPagePriceAnaylsis1Month;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3 Months']")
    private static MobileElement mostActByVolDetailPageAnaylsis3Months;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1 Year']")
    private static MobileElement mostActByVolDetailPageAnaylsis1Year;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_risk_meter")
    private static MobileElement mostActByVolDetailPageRiskFactor;
    @AndroidFindBy(id = "com.htmedia.mint:id/view_drk_green")
    private static MobileElement mostActByVolDetailPageRiskFactorDarkGreen;
    @AndroidFindBy(id = "com.htmedia.mint:id/view_green")
    private static MobileElement mostActByVolDetailPageRiskFactorGreen;
    @AndroidFindBy(id = "com.htmedia.mint:id/view_balance")
    private static MobileElement mostActByVolDetailPageRiskFactorBalance;
    @AndroidFindBy(id = "com.htmedia.mint:id/view_high")
    private static MobileElement mostActByVolDetailPageRiskFactorHigh;
    @AndroidFindBy(id = "com.htmedia.mint:id/view_extreme")
    private static MobileElement mostActByVolDetailPageRiskFactorExtreme;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_recos")
    private static MobileElement mostActByVolDetailPageRecos;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_strong_sell")
    private static MobileElement mostActByVolDetailPageRecosStrongCell;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_sell")
    private static MobileElement mostActByVolDetailPageRecosSell;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_hold")
    private static MobileElement mostActByVolDetailPageRecosHold;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_buy")
    private static MobileElement mostActByVolDetailPageRecosBuy;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_strong_buy")
    private static MobileElement mostActByVolDetailPageRecosStrongBuy;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Forecast'])[2]")
    private static MobileElement mostActByVolDetailPageForecast;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_income")
    private static MobileElement mostActByVolDetailPageForecastIncomeSection;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_return")
    private static MobileElement mostActByVolDetailPageForecastReturnSection;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Financials'])[2]")
    private static MobileElement mostActByVolDetailPageFinancialsSection;
    @AndroidFindBy(id = "com.htmedia.mint:id/incomeName")
    private static MobileElement mostActByVolDetailPageFinancialsIncomeName;
    @AndroidFindBy(id = "com.htmedia.mint:id/balanceSheetName")
    private static MobileElement mostActByVolDetailPageFinancialsBalenceSheet;
    @AndroidFindBy(id = "com.htmedia.mint:id/cashFlowName")
    private static MobileElement mostActByVolDetailPageFinancialsCashFlow;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Technical'])[2]")
    private static MobileElement mostActByVolDetailPageTechnical;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_dma")
    private static MobileElement mostActByVolDetailPageTechnicalSection;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/chart'])[2]")
    private static MobileElement mostActByVolDetailPagePriceChart;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Peers']")
    private static MobileElement mostActByVolDetailPagePeersSection;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_priceLayout")
    private static MobileElement mostActByVolDetailPagePeersTable;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About Company']")
    private static MobileElement mostActByVolDetailPageAboutCompany;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Industry'])[1]")
    private static MobileElement mostActByVolDetailPageAboutCompanyIndustry;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ISIN']")
    private static MobileElement mostActByVolDetailPageAboutCompanyISIN;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BSE Code']")
    private static MobileElement mostActByVolDetailPageAboutCompanyBseCode;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NSE Code']")
    private static MobileElement mostActByVolDetailPageAboutCompanyNseCode;
    @AndroidFindBy(id = "com.htmedia.mint:id/about_company")
    private static MobileElement mostActByVolDetailPageAboutCompanyDetail;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MANAGEMENT']")
    private static MobileElement mostActByVolDetailPageAboutCompanyManagement;
    @AndroidFindBy(id = "com.htmedia.mint:id/managementTeam")
    private static MobileElement mostActByVolDetailPageAboutCompanyManagementTeam;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/parent_layout'])[1]")
    private static MobileElement mostActByVolDetailPageOverview;
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc='Peers'])[1]")
    private static MobileElement peersTabLayout;
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc='About Company'])[1]")
    private static MobileElement aboutCompanyTabLayout;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/newsList']/preceding::*[@resource-id='com.htmedia.mint:id/tv_title']")
    private static List<MobileElement> newsSectionHeadline;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/newsList']")
    private static MobileElement newsSectionList;
    @FindBy(id = "com.htmedia.mint:id/txtGainerLoserHeading")
    private static List<MobileElement> topGainerTopLoser;
    @FindBy(xpath = "//android.widget.TextView[@text='Top Gainers']")
    private static MobileElement topGainer;
    @FindBy(xpath = "//android.widget.TextView[@text='Top Losers']")
    private static MobileElement topLoser;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtWatchList")
    private static MobileElement watchlistIcon;
    @FindBy(xpath = "//android.widget.TextView[@text='MY WATCHLIST']")
    private static MobileElement watchlistIconPage;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/removeStocks']")
    private static List<MobileElement> watchlistPageRemoveIcon;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/rvWatchList']//android.widget.LinearLayout/android.widget.TextView[1]")
    private static List<MobileElement> watchlistPageWatchlistName;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivDelete")
    private static MobileElement watchlistPageDeleteIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_news")
    private static MobileElement watchlistPageNewsSection;
    @AndroidFindBy(id = "com.htmedia.mint:id/llNoData")
    private static MobileElement watchlistPageNoData;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View Stock']")
    private static MobileElement watchlistPageViewStock;
    @AndroidFindBy(id = "com.htmedia.mint:id/etSearch")
    private static MobileElement watchlistPageSearchBox;
    @AndroidFindBy(id = "com.htmedia.mint:id/rvSearchList")
    private static MobileElement watchlistPageSearchList;
    @AndroidFindBy(xpath = "//*[@text='Scroll down to checkout News related to all stocks in your watchlist']")
    private static MobileElement watchlistPageNewsToasterMassage;
    @AndroidFindBy(id = "com.htmedia.mint:id/newsBackground")
    private static MobileElement marketPageNewsSection;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/cardViewNewsItem']")
    private static List<MobileElement> marketPageNews;
    @AndroidFindBy(xpath = "(//*[@text='NEWS-WATCHLIST'])[1]//following-sibling::*/android.widget.LinearLayout")
    private static List<MobileElement> watchlistPageNews;
    @AndroidFindBy(xpath = "//*[@text='TRENDING STOCKS']")
    private static MobileElement widgetTrendingStocks;
    @AndroidFindBy(id = "com.htmedia.mint:id/recyclerViewMarketTicker")
    private static MobileElement widgetTrendingStocksSection;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/card_view_trending']")
    private static List<MobileElement> widgetTrendingStocksFirst3Card;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/card_view_trending'])[1]")
    private static MobileElement widgetTrendingStocksFirstCard;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/imgHigher']")
    private static List<MobileElement> widgetTrendingStocksTop3Gainer;
    @AndroidFindBy(id = "com.htmedia.mint:id/company_name_new")
    private static MobileElement stockDetailPageCompanyName;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/card_view_trending']//following-sibling::android.widget.TextView[contains(@text, '-')]")
    private static List<MobileElement> widgetTrendingStocksTop3Loser;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/card_view_trending']//following-sibling::*[@resource-id='com.htmedia.mint:id/txtTitle']")
    private static List<MobileElement> widgetTrendingStocksCompanyName;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_widget_type1")
    private static MobileElement TrendingStocksMarketDashboard;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitleExploreNew")
    private static MobileElement marketDashboardPage;

    public MarketPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }


    @Override
    public boolean checkIndianIndicesPage(String url) {
        return false;
    }

    @Override
    public boolean checkMarketDashboardPage(String url) {
        return false;
    }

    @Override
    public boolean checkMarketSnPBseMidcapLandingPage( ) {
        return false;
    }

    @Override
    public boolean checkMarketNifty50LandingPage(String url, String Header) {
        return false;
    }
    @Override
    public boolean checkMarketNifty50Graph(String[] params) {
        return false;
    }

    @Override
    public boolean checkSnPBseSensexGraph(String[] params) {
        return false;
    }

    @Override
    public boolean checkNiftyBankGraph(String[] params) {
        return false;
    }

    @Override
    public boolean checkSnPBseMidcapGraph(String[] params) {
        return false;
    }

    @Override
    public boolean checkMostActiveVolViewAll() {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAll(String[] params) {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAll(String[] params) {
        return false;
    }

    @Override
    public boolean checkMFDetailPage(String[] params) {
            return false;}

    @Override
    public boolean checkIndianIndicesGraph(String Link, String Color) {
        return false;
    }

    public boolean clickOnMarketTabAndCheckMarketPage() {
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        return commonFunctions.isElementDisplayedWithoutTryCatch(indianIndices, 10, "Indian Indices");
    }

    @Override
    public boolean checkTopLosersViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(gainerLoser,2);
        commonFunctions.scrollDownToElement(viewAllTopLosers);
        commonFunctions.clickElement(viewAllTopLosers, 10, "view all button");
        isShowing &= commonFunctions.isElementDisplayed(topLosersPage, 10, "top Losers page");
        commonFunctions.clickElement(losersBSE, 10, "Top Losers BSE");
        isShowing &= commonFunctions.isElementDisplayed(listOfTopLosersCompanies, 10, "list Of Top Losers BSE Companies");
        commonFunctions.clickElement(losersNSE, 10, "Top Losers NSE");
        isShowing &= commonFunctions.isElementDisplayed(listOfTopGainerCompany, 10, "list Of Top Losers NSE Companies");
        isShowing &= commonFunctions.isElementClickable(losersNSECompany, 10, "Losers Company Name");
        isShowing &= commonFunctions.isElementClickable(companycurrentPrice, 10, "Company Current price");
        isShowing &= commonFunctions.isElementClickable(losersCompanyPriceChange, 10, "Company Current price Change Percentage");

        return isShowing;
    }
    @Override
    public boolean checkMostActByVolViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(mostActiveByVolume);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        isShowing &= commonFunctions.clickElement(mostActiveByVolumeViewAll,10,"view all");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeOnDetailPage,10,"most Active By Volume Detail Page");
        commonFunctions.clickElement(mostActBse, 10, "Most Active By Volume BSE");
        isShowing &= commonFunctions.isElementDisplayed(listOfCompanies, 10, "List Of Most Active By Volume BSE Companies");
        commonFunctions.clickElement(mostActNse, 10, "Most Active By Volume NSE");
        isShowing &= commonFunctions.isElementDisplayed(listOfCompanies, 10, "List Of Most Active By Volume NSE Companies");
        isShowing &= commonFunctions.isElementClickable(mostActByVolCompany, 10, "Most Active By Volume Company Name");
        isShowing &= commonFunctions.isElementClickable(mostActVolCompanyPrice, 10, "Most Active By Volume Company Current price");
        isShowing &= commonFunctions.isElementClickable(mostActVolCompanyPriceChange, 10, "Most Active By Volume Company Current price Change Percentage");

        return isShowing;
    }

    @Override
    public boolean checkSnPBseMidcapStockTable(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeMarketDashbaord(String Link, String Color, String URI, String Companies) {
        return false;
    }

    @Override
    public boolean checkTopGainerMarketDashbaord(String Link, String Color, String URI, String Gainers) {
        return false;
    }

    @Override
    public boolean checkTopLoserMarketDashbaord(String Link, String Color, String URI, String Losers) {
        return false;
    }

    @Override
    public boolean checkStockTableNiftyBank(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkStockTableBseSensex(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkStockTableBseSensexViewAll(String Link, String Header, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkStockTableBseSensexViewAllAmp(String Link, String Header, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesPageAmp(String Link) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesTable(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAll(String Link, String Header, String URI, String ID, String URL) {
        return false;
    }

    @Override
    public boolean checkNiftyBankStocksViewAll(String Link, String Link1, String Header, String URI, String ID, String URL, String stocks) {
        return false;
    }

    @Override
    public boolean checkStockNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnBseSensex(String Link, String Header, String URI, String ID, String URL) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnNiftyBank(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnBseMidcap(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAllBseMidcap(String Link, String Header, String URI, String ID, String stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAllNiftyBank(String Link, String Header, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAllOnBseSensex(String Link, String Amp, String Header, String URI, String ID, String Stocks, String ampURL, String webURL, String url3) {
        return false;
    }

    @Override
    public boolean checkStocksTableOnIndicePage(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkStocksTableOnIndicePageAMP(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkMarketsTopNaV(String Link, String Link2) {
        return false;
    }

    @Override
    public boolean checkSubscribeBannerForYouPage(String Link, String Link2, String Name) {
        return false;
    }

    @Override
    public boolean checkMaketPageScroll(String Link, String Page) {
        return false;
    }

    @Override
    public boolean checkIndicesDetails(String Link, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkLeftNavOnMarketPage() {
        return false;
    }

    @Override
    public boolean checkTopNavOnMarketPageSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkMarketPageLayout() {
        return false;
    }

    @Override
    public boolean checkMarketPageMastHeadAd() {
        return false;
    }

    @Override
    public boolean checkNewsSectionInExplore() {
        return false;
    }


    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        boolean isShowing;
        isShowing = commonFunctions.clickElement(home, 10, "home tab");
        isShowing &= commonFunctions.clickElement(explore,10,"Tap on explore Button");
        isShowing &= commonFunctions.clickElement(search,5,"Tap on search bar");
        commonFunctions.sendKeysOnAndroid(search,"Market Dashboard");
        commonFunctions.pressEnterKey();
        isShowing = commonFunctions.clickElement(marketDashboard,10,"Tap Market Dashboard");
        commonFunctions.scrollDownToElement(gainerLoser);
        isShowing = commonFunctions.clickElement(gainerLoserStock,10,"Tap on Any stock to access Company detail page");
        isShowing &= commonFunctions.scrollDownToElement(companyinfo,"Company info section");
        return isShowing;
    }
    @Override
    public boolean checkNiftyBankGraph(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkGraphOnIndianIndicesPage(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkGraphOnNifty50Page(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkGraphOnBseSensexPage(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAll(String Link, String amp) {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAll(String Link, String amp) {
        return false;
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
    public boolean checkBseTop4GainersAndLosers() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
        commonFunctions.clickElement(bseGainerLoser, 10, "BSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        return isShowing;
    }

    public boolean topFourGainerLoserCompanyWithSeperateCard() {
        boolean isShowing;
        commonFunctions.dummyWait(5);
        commonFunctions.checkElementVisibilityByScrolling(topGainer,"top gainer section");
        commonFunctions.swipeElementUsingTouchAction(448,1842,455,1144);
        isShowing = commonFunctions.isElementDisplayed(listOfTop4CompanySeperateCards.get(1), 10, "list Of Top 4 Gainers Company Seperate Cards");
        isShowing &= commonFunctions.isElementDisplayed(listOfTop4GainerCompany, 10, "top 4 bse gainer");
        int firstEle[] = commonFunctions.getElementXYCoordinate(topGainer);
        int secondEle[] = commonFunctions.getElementXYCoordinate(topLoser);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        isShowing &= commonFunctions.isElementDisplayed(listOfTop4CompanySeperateCards.get(2), 10, "list Of Top 4 Loser Company Seperate Cards");
        isShowing &= commonFunctions.isElementDisplayed(listOfTop4LoserCompany, 10, "top 4 bse loser");
        return isShowing;
    }

    @Override
    public boolean checkNseTop4GainersAndLosers() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayedWithoutTryCatch(indianIndices, 10, "Indian Indices");
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
        commonFunctions.clickElement(nseGainerLoser, 10, "NSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        return isShowing;
    }

    @Override
    public boolean checkTopGainersViewAll() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser,1);
        commonFunctions.scrollDownToElement(viewAllTopGainers,1);
        commonFunctions.clickElement(viewAllTopGainers, 10, "view all top button");
        isShowing &= commonFunctions.isElementDisplayed(topGainerPage, 10, "top gainers page");
        isShowing &= commonFunctions.isElementDisplayed(listOfTopGainerCompany, 10, "list Of TopGainer Company");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailLineGraph() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton,10,"home tab");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainers loser section");
        commonFunctions.scrollDownToElement(gainerLoser,1);
        commonFunctions.checkElementVisibilityByScrolling(viewAllTopGainers,"view all top gainers");
        commonFunctions.scrollDownToElement(viewAllTopGainers,1);
        commonFunctions.clickElement(viewAllTopGainers, 10, "view all top gainers button");
        isShowing &= commonFunctions.isElementDisplayed(topGainersHeader, 10, "Gainers Page Header");
        commonFunctions.clickByCoordinates(282,639,"top gainer first company");
        isShowing = commonFunctions.isElementDisplayed(lineGraph, 10, "Line graph chart");
        isShowing &= commonFunctions.isElementDisplayed(graph1Day, 10, "Line Graph 1day option");
        commonFunctions.clickElement(graph5Days, 10, "Line Graph 5days option");
        commonFunctions.clickElement(graph1Month, 10, "Line Graph 1month option");
        commonFunctions.clickElement(graph1Year, 10, "Line Graph 1year option");
        commonFunctions.clickElement(graph5Year, 10, "Line Graph 5year option");
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
    public boolean checkIndianIndicesViewAll() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing =  commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
        commonFunctions.clickElement(viewAll, 10, "View All Indian Indices");
        isShowing &= commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices Page Heading");
        return isShowing;
    }

    @Override
    public boolean checkGainersAndLosers() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Homepage Button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser,2);
        isShowing = commonFunctions.isElementDisplayed(topGainers, 10, "Top Gainers List");
        isShowing &= commonFunctions.isElementDisplayed(topLosers, 10, "Top Losers List");
        isShowing &= commonFunctions.isElementDisplayed(gainerLoserList, 10, "Gainers and Losers List");
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
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
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
    public boolean checkBse100NewsSection() {
        boolean isShowing;
        checkIndicesRedirectionFunctionality();
        commonFunctions.scrollDownToElement(newsBse100);
        isShowing = commonFunctions.isElementDisplayed(newsBse100, 10, "S&P BSE 100 News Section Header");
        return isShowing;
    }

    @Override
    public boolean checkTopGainersViewAllFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
        commonFunctions.checkElementVisibilityByScrolling(viewAllTopGainers,"top gainer view all");
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
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser section");
        commonFunctions.checkElementVisibilityByScrolling(topGainer,"top gainer section");
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(topGainerTopLoser,1,"top Gainer");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(topGainerTopLoser,2,"top Loser");
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        commonFunctions.checkElementVisibilityByScrolling(viewAllTopLosers,"view all top loser");
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
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
        commonFunctions.clickElement(bseGainerLoser, 10, "BSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkNseTabsGainerLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
        commonFunctions.clickElement(nseGainerLoser, 10, "NSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkGainerLosersDesign(String gainerLoserText) {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
        isShowing &= commonFunctions.getElementTextAndCheck(gainerLoser, gainerLoserText, 10, "gainer & loser");
        isShowing &= commonFunctions.isElementDisplayed(updateTime, 10, "update time");
        isShowing &= commonFunctions.isElementDisplayed(bseGainerLoser, 10, "BSE tag");
        isShowing &= commonFunctions.isElementDisplayed(nseGainerLoser, 10, "NSE tag");
        isShowing &= topFourGainerLoserCompanyWithSeperateCard();
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkDetailPageOfNseAndBse() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices");
        commonFunctions.scrollDownToElement(gainerLoser,1);
        isShowing = commonFunctions.scrollDownToElement(viewAllTopGainers,1);
        commonFunctions.clickElement(viewAllTopGainers, 10, "view all top button");
        commonFunctions.isElementDisplayed(topGainersHeader, 10, "Gainers Page Header");
        commonFunctions.clickByCoordinates(282,639,"top gainer first company");
        commonFunctions.clickElement(bseStockDetail, 10, "Stock Detail Page BSE");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "Line Graph with multiple option");
        commonFunctions.clickElement(nseStockDetail, 10, "Stock Detail Page NSE");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "Line Graph with multiple option");
        isShowing &= commonFunctions.isElementDisplayed(graph1Day, 10, "Line Graph 1day option");
        isShowing &= commonFunctions.clickElement(graph5Days, 10, "Line Graph 5days option");
        isShowing &= commonFunctions.clickElement(graph1Month, 10, "Line Graph 1month option");
        isShowing &= commonFunctions.clickElement(graph1Year, 10, "Line Graph 1year option");
        isShowing &= commonFunctions.clickElement(graph5Year, 10, "Line Graph 5year option");
        commonFunctions.scrollDownToElement(lineGraph,1);
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPagePriceRangeWeekHigh, 10, "52 Weeks Highest Price");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPagePriceRangeWeekLow, 10, "52 Weeks lowest price");
        commonFunctions.isElementDisplayed(dayHighPrice, 10, "Day Highest Price");
        commonFunctions.isElementDisplayed(dayLowPrice, 10, "Day Lowest Price");
        commonFunctions.scrollDownToElement(openingPrice,1);
        commonFunctions.isElementDisplayed(openingPrice, 10, "Day Opening Price");
        commonFunctions.isElementDisplayed(prevClosingPrice, 10, "Previous Day closing price");

        return isShowing;
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
    public boolean checkMostActiveByVolumeDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollDownToElement(mostActiveByVolume);
        commonFunctions.scrollDownToElement(mostActiveByVolume,1);
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolume, 10, "most active by volume");
        isShowing &= commonFunctions.isElementDisplayed(updateStatusMostActiveByVolume, 10, "update status");
        isShowing &= commonFunctions.isElementDisplayed(bseTagMostActiveByVolume, 10, "Bse tag");
        isShowing &= commonFunctions.isElementDisplayed(nseTagMostActiveByVolume, 10, "Nse tag");
        isShowing &= commonFunctions.isElementDisplayed(securityTagMostActiveByVolume, 10, "security tag");
        isShowing &= commonFunctions.isElementDisplayed(volumeTagMostActiveByVolume, 10, "volume tag");
        isShowing &= commonFunctions.isElementDisplayed(changeTagMostActiveByVolume, 10, "change tag");
        isShowing &= commonFunctions.isElementDisplayed(topFourMostActiveByVolume, 10, "top 4 company list");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        commonFunctions.scrollDownToElement(mostActiveByVolumeViewAll,2);
        isShowing &= commonFunctions.clickElement(mostActiveByVolumeViewAll, 10, "view all");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeOnDetailPage, 10, "most Active By Volume Detail Page");
        int v1 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeOnDetailPageVolume.get(2), 10));
        int v2 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeOnDetailPageVolume.get(3), 10));
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

    @Override
    public boolean checkCompanyDetailPageDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume,"most active by volume");
        commonFunctions.scrollDownToElement(mostActiveByVolumeViewAll,1);
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
    public boolean checkCompanyDetailPageInfo() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyMostActiveByVolume();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoSection, "company information section");
//        isShowing &= companyDetailInfo();
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
    public boolean checkCompanyDetailPagePriceHistory() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= clickOnFirstCompanyMostActiveByVolume();
        isShowing &= priceHistoryOnDetailPage();
        commonFunctions.clickElement(homeButton, 10, "Home button");
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

    private boolean clickOnFirstCompanyMostActiveByVolume() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume");
        isShowing &= commonFunctions.scrollDownToElement(mostActiveByVolume,1);
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(topFirstMostActiveByVolume.get(1), 10, "first stock company");
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
        isShowing= commonFunctions.checkElementVisibilityByScrolling(gainerLoser,"gainer loser");
//        isShowing = commonFunctions.checkElementVisibilityByScrolling(viewAllTopGainers, "view all");
        commonFunctions.scrollDownToElement(gainerLoser,1);
        commonFunctions.clickElement(Top4GainerCompany.get(2), 10, "first company name");
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeBelowGainernLoser() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton,10,"home tab");
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
        commonFunctions.scrollDownToElement(gainerLoser,1);
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
//        isShowing &= companyDetailInfo();
        isShowing = commonFunctions.checkElementVisibilityByScrolling(companyInfoSection, "company information section");
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

    private boolean checkMarketPage() {
        commonFunctions.clickElement(homeButton,10,"home tab");
        commonFunctions.clickElement(marketTab, 10, "market tab");
        return commonFunctions.isElementDisplayedWithoutTryCatch(marketPage, 10, "market page");
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
        int firstEle[] = commonFunctions.getElementXYCoordinate(mutualFundCommoditiesCategory);
        int secondEle[] = commonFunctions.getElementXYCoordinate(mutualFundHybridCategory);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        isShowing &= commonFunctions.isElementDisplayed(mutualFundIndexFundsCategory, 10, "Index Fund category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundOtherCategory, 10, "Other category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundSolutionsOrientedCategory, 10, "Solution Oriented category");
        return isShowing;
    }

    @Override
    public boolean checkMutualFundDetailPage() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundName.get(0), 10, "first fund name");
        String text = commonFunctions.getElementText(mutualFundName.get(0), 10);
        commonFunctions.clickElement(mutualFundName.get(0), 10, "mutual fund first fund name");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(mutualFundNameDetailPage, 10, "detail page fund name");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(mutualFundNameDetailPage, text, 10, "fund name");
        return isShowing;
    }

    @Override
    public boolean checkDefaultSelectionCategoryTab() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundCommoditiesCategory, "commodities category");
        isShowing &= commonFunctions.isElementSelected(mutualFundCommoditiesCategory, 10, "default selected: Commodities");
        return isShowing;
    }

    @Override
    public boolean checkMutualFundListingPageTitle() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundViewAll, "mutual fund view all ");
        commonFunctions.clickElement(mutualFundViewAll,10,"view all");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(mutualFundListingPage, 10, "mutual fund listing page");
        return isShowing;
    }

    @Override
    public boolean checkMutualFundNavValue() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        isShowing &= commonFunctions.isElementDisplayed(mutualFundListingPageNav.get(0), 10, "Nav value");
        isShowing &= commonFunctions.getElementTextAndCheckWithContains(mutualFundListingPageNav.get(0), "₹", 10, "nav price");
        return isShowing;
    }

    @Override
    public boolean checkMarket() {
        return clickOnMarketTabAndCheckMarketPage();
    }



    @Override
    public boolean checkMutualFundDetailPageTopSectionTitle() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        isShowing &= commonFunctions.isElementDisplayed(listingPageMutualFundName.get(0), 10, "listing apge first fund name");
        String text = commonFunctions.getElementText(listingPageMutualFundName.get(0), 10);
        commonFunctions.clickElement(listingPageMutualFundName.get(0), 10, "mutual fund first fund name");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(mutualFundNameDetailPage, 10, "detail page fund name");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(mutualFundNameDetailPage, text, 10, "fund name");
        return isShowing;
    }

    @Override
    public boolean checkMutualFundStories() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(listingStoryHeadline, "listing story");
        return isShowing;
    }

    @Override
    public boolean checkMutualFundReturnType() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        isShowing &= commonFunctions.isElementDisplayed(oneMReturnPercentage, 10, "return type: 1M");
        isShowing &= commonFunctions.isElementDisplayed(threeMReturnPercentage, 10, "return type: 3M");
        isShowing &= commonFunctions.isElementDisplayed(sixMReturnPercentage, 10, "return type: 6M");
        isShowing &= commonFunctions.isElementDisplayed(oneYReturnPercentage, 10, "return type: 1Y");
        isShowing &= commonFunctions.isElementDisplayed(threeYReturnPercentage, 10, "return type: 3Y");
        int firstEle[] = commonFunctions.getElementXYCoordinate(sixMReturnPercentage);
        int secondEle[] = commonFunctions.getElementXYCoordinate(threeYReturnPercentage);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        isShowing &= commonFunctions.isElementDisplayed(fiveYReturnPercentage, 10, "return type: 5Y");
        return isShowing;
    }

    @Override
    public boolean checkMutualFundReturnTable() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        commonFunctions.clickElement(listingPageMutualFundName.get(0), 10, "mutual fund first fund name");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnSection, "return section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnTableOneM, "1 month");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnTableThreeM, "3 month");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnTableSixM, "6 month");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnTableOneY, "1 year");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnTableTwoY, "2 year");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnTableThreeY, "3 year");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(returnTableFiveY, "5 year");
        return isShowing;
    }

    @Override
    public boolean checkTopHoldingSection() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        commonFunctions.clickElement(listingPageMutualFundName.get(0), 10, "mutual fund first fund name");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topHoldingSection, "top holding section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topHoldingSectionList, "top holding list");
        isShowing &= commonFunctions.isElementDisplayed(topHoldingSectionStockName.get(0), 10, "stock name");
        isShowing &= commonFunctions.isElementDisplayed(topHoldingSectionTotalHolding.get(0), 10, "total holding");
        return isShowing;
    }

    @Override
    public boolean checkPortfolioSection() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        commonFunctions.clickElement(listingPageMutualFundName.get(0), 10, "mutual fund first fund name");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(portfolioSection, "portfolio section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(portfolioInnerCircle, "inner circle");
        isShowing &= commonFunctions.isElementDisplayed(portfolioAssets, 10, "assets");
        return isShowing;
    }

    @Override
    public boolean checkNavPriceGraph() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        commonFunctions.clickElement(listingPageMutualFundName.get(0), 10, "mutual fund first fund name");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(navTimeDay, "title: Nav Time/Day ");
        return isShowing;
    }

    @Override
    public boolean checkLiveBlogPage(String Amp, String Link, String LinkAmp) {

        return false;
    }

    @Override
    public boolean checkLiveBlogLeadImagenCaption(String Amp, String Link, String LinkAmp) {
        return false;
    }

    @Override
    public boolean checkLiveBlogSocialnBookmarkIcons(String Amp) {
        return false;
    }

    @Override
    public boolean checkLiveBlogPageTitle(String Amp, String Link, String LinkAmp, String Title) {
        return false;
    }


    @Override
    public boolean checkSubCategoryAvailableOption() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        isShowing &= commonFunctions.isElementDisplayed(mutualFundCommoditiesCategory, 10, "commodities category");
        commonFunctions.clickElement(mutualFundCommoditiesCategory, 10, "category: Commodities");
        commonFunctions.dummyWait(5);
        String text1 = commonFunctions.getElementText(mutualFundListingPageDropdown, 10);
        commonFunctions.clickElement(mutualFundDebtCategory, 10, "Debt category");
        commonFunctions.dummyWait(5);
        String text2 = commonFunctions.getElementText(mutualFundListingPageDropdown, 10);
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
    public boolean checkFundDetailPageAboutFund() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        commonFunctions.clickElement(listingPageMutualFundName.get(0), 10, "mutual fund first fund name");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fundSummery, "fund summery");
        isShowing &= commonFunctions.isElementDisplayed(fundSummeryBenchMark, 10, "title: Bench Mark");
        isShowing &= commonFunctions.isElementDisplayed(fundSummeryDividend, 10, "title: Divided");
        isShowing &= commonFunctions.isElementDisplayed(fundSummeryCategory, 10, "title: Category");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fundSummeryLaunchDate, "title: Launc Date");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fundSummeryMinimumSip, "title: Minimum SPI");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fundSummeryExpenseRatio, "title: BExpense Ratio");
        return isShowing;
    }

    @Override
    public boolean CheckFundSectionDesign() {
        boolean isShowing;
        isShowing = checkMutualFundListingPageTitle();
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(mutualFundListingPageNavText, "Nav text");
        return isShowing;
    }

    @Override
    public boolean checkMarketPageContent(String Amp) {
        return false;
    }

    @Override
    public boolean checkTopRightAdMarketPage() {
        return false;
    }

    @Override
    public boolean checkOpenAppInStory(String Amp) {
        return false;
    }

    @Override
    public boolean checkOpenAppSectionPage(String Amp) {
        return false;
    }

    @Override
    public boolean checkOpenAppSubSectionPage(String Amp) {
        return false;
    }

    @Override
    public boolean checkShareIconsPoliticsPage() {
        return false;
    }

    @Override
    public boolean checkMutualFundMaximumFundListing() {
        boolean  isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundsSection, "mutual fund widgets");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundName.get(0), 10, "mutualFund first Category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundName.get(1), 10, "mutual Fund second Category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundName.get(2), 10, "mutual Fund third Category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundName.get(3), 10, "mutual Fund fourth Category");
        isShowing &= commonFunctions.isElementDisplayed(mutualFundName.get(4), 10, "mutual Fund fifth Category");
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeDetailPageAndBackBtn() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        commonFunctions.clickElement(backBtn,10,"back btn");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolSection, "most active by volume");
        return isShowing;
    }

    public boolean checkMostActiveByVolumeDetailPage() {
        boolean isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolSection, "most active by volume");
        commonFunctions.scrollDownToElement(mostActByVolFirstSecurityName,1);
        commonFunctions.clickElement(mostActByVolFirstSecurityName, 10, "first security name");
        isShowing &= commonFunctions.isElementDisplayedWithoutTryCatch(mostActByVolDetailPageCompanyName, 10, "detail page");
       commonFunctions.dummyWait(5);
        return isShowing;
    }

    @Override
    public boolean checkStockDetailPageL1Tab() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.isElementSelected(overviewTabLayout, 10, "overview");
        isShowing &= commonFunctions.isElementDisplayed(analysisTabLayout, 10, "analysis");
        isShowing &= commonFunctions.isElementDisplayed(newsTabLayout, 10, "news");
        isShowing &= commonFunctions.isElementDisplayed(forecastTabLayout, 10, "forecast");
        isShowing &= commonFunctions.isElementDisplayed(financialsTabLayout, 10, "financials");
        return isShowing;
    }

    @Override
    public boolean checkStockTitleWithShareIcon() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageShareIcon, 10, "share icon");
        commonFunctions.clickElement(mostActByVolDetailPageShareIcon, 10, "share app");
        isShowing &= commonFunctions.isElementDisplayed(bluetoothText, 10, "bluetooth option");
        isShowing &= commonFunctions.isElementDisplayed(gmailText, 10, "Gmail option");
        isShowing &= commonFunctions.isElementDisplayed(messageText, 10, "Message option");
        isShowing &= commonFunctions.isElementDisplayed(driveText, 10, "Drive option");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkStockAddToWatchList() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.clickElement(mostActByVolDetailPageAddToWatchList, 10, "add to watchlist");
        return isShowing;
    }

    @Override
    public boolean checkStockPrice() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageAmtPoints, 10, "price");
        isShowing &= commonFunctions.clickElement(mostActByVolDetailPageUpdateTime, 10, "stock price updated");
        return isShowing;
    }

    @Override
    public boolean checkStockPriceBSENSE() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        commonFunctions.clickElement(mostActByVolDetailPageBseTab, 10, "bse tab");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageAmtPoints, 10, "price");
        isShowing &= commonFunctions.clickElement(mostActByVolDetailPageNseTab, 10, "nse tab");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageAmtPoints, 10, "price");
        return isShowing;
    }

    @Override
    public boolean checkStockPriceGraph() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPagePriceChart, 10, "price chart");
        isShowing &= commonFunctions.isElementDisplayed(graph1Day, 10, "Line Graph 1day option");
        isShowing &= commonFunctions.isElementDisplayed(graph5Days, 10, "Line Graph 5days option");
        isShowing &= commonFunctions.isElementDisplayed(graph1Month, 10, "Line Graph 1month option");
        isShowing &= commonFunctions.isElementDisplayed(graph1Year, 10, "Line Graph 1year option");
        isShowing &= commonFunctions.isElementDisplayed(graph5Year, 10, "Line Graph 5year option");
        return isShowing;
    }

    @Override
    public boolean checkStockPriceRange() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        commonFunctions.swipeElementUsingTouchAction(455,1722,395,1108);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPagePriceRange, "price range");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPagePriceRangeTodayLow, "today low price");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPagePriceRangeTodayHigh, 10, "today high price");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPagePriceRangeWeekLow, "52 week low price");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPagePriceRangeWeekHigh, 10, "52 week high price");
        return isShowing;
    }

    @Override
    public boolean checkStockKeyMatrics() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatrics, "key matrics");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsMarketCaps, "market caps");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsTTM, "TTM");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsSector, "sector");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsDividend, "dividend");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsBeta, "beta");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsFaceValue, "face value");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsOpenPrice, "open price");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageKewMatricsPrevClose, "prec vlose");
        return isShowing;
    }

    @Override
    public boolean checkStockAnaysis() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAnaylsis, "anaylsis");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPagePriceAnaylsis, "price anaylsis");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAnaylsisChart, "anaylsis chart");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAnaylsis1Week, "1 week");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPagePriceAnaylsis1Month, "1 month");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAnaylsis3Months, "3 month");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAnaylsis1Year, "1 year");
        return isShowing;
    }

    @Override
    public boolean checkStockRiskMeter() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRiskFactor, "risk meter");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRiskFactorDarkGreen, "dark green");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRiskFactorGreen, "green");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRiskFactorBalance, "balance");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRiskFactorHigh, "high");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRiskFactorExtreme, "extreme");
        return isShowing;
    }

    @Override
    public boolean checkStockRecos() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRecos, "recos section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageRecosStrongCell, "strong cell");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageRecosSell,10, "sell");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageRecosHold, 10,"hold");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageRecosBuy,10, "buy");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageRecosStrongBuy, 10,"strong buy");
        return isShowing;
    }

    @Override
    public boolean checkStockForecast() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageForecast, "forecast section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageForecastIncomeSection, "income section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageForecastReturnSection, "return section");
        return isShowing;
    }

    @Override
    public boolean checkStockFinancials() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageFinancialsSection, "financials section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageFinancialsIncomeName, "income name");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageFinancialsBalenceSheet, "balance sheet");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageFinancialsCashFlow, "cash flow");
        return isShowing;
    }

    @Override
    public boolean checkStockTechnical() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageTechnical, "technical");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageTechnicalSection, "technical section");
        return isShowing;
    }

    @Override
    public boolean checkStockPeersSection() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPagePeersSection, "peers section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(lineGraph, "peers graph");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPagePeersTable, "peers table");
        return isShowing;
    }

    @Override
    public boolean checkStockAboutCompany() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompany, "about company section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompanyIndustry, "company industry");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompanyISIN, "company ISIN");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompanyBseCode, "company Bse code");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompanyNseCode, "company Nse code");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompanyDetail, "company detail info");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompanyManagement, "company management");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolDetailPageAboutCompanyManagementTeam, "company management team");
        return isShowing;
    }

    @Override
    public boolean checkL1TabOverview() {
        boolean isShowing = checkMostActiveByVolumeDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageOverview, 10, "overview details");
        return isShowing;
    }

    @Override
    public boolean checkL1TabScrollable() {
        boolean isShowing = checkStockDetailPageL1Tab();
        int firstEle[] = commonFunctions.getElementXYCoordinate(analysisTabLayout);
        int secondEle[] = commonFunctions.getElementXYCoordinate(financialsTabLayout);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        isShowing &= commonFunctions.isElementDisplayed(peersTabLayout, 10, "peers option");
        isShowing &= commonFunctions.isElementDisplayed(aboutCompanyTabLayout, 10, "about company");
        return isShowing;
    }

    @Override
    public boolean checkNewsSectionOnDetailPage() {
        boolean isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActByVolSection, "most active by volume");
        commonFunctions.scrollDownToElement(mostActByVolSection,1);
        String securityName = commonFunctions.getElementText(mostActByVolFirstSecurityName, 10);
        commonFunctions.clickElement(mostActByVolFirstSecurityName, 10, "first security name");
        isShowing &= commonFunctions.isElementDisplayed(mostActByVolDetailPageCompanyName, 10, "detail page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(newsSectionList, "news list");
        int e=  newsSectionHeadline.size()-1;
        isShowing &= commonFunctions.isElementDisplayed(newsSectionHeadline.get(e), 10, "news headline");
        isShowing &= commonFunctions.checkElementText(newsSectionHeadline.get(e), securityName + " News", 10, "news headline");
        return isShowing;
    }

    @Override
    public boolean checkWatchlistIconAndStocks() {
        boolean isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume");
        commonFunctions.scrollDownToElement(mostActiveByVolumeViewAll, 1);
        String text = commonFunctions.getElementText(topFirstMostActiveByVolume.get(1), 10);
        commonFunctions.clickElement(topFirstMostActiveByVolume.get(1), 10, "first stock company");
        commonFunctions.clickElement(mostActByVolDetailPageAddToWatchList, 10, "add to watchlist");
        commonFunctions.navigateBack();
        isShowing &= checkWatchlistIconAndPage();
        for (MobileElement m : watchlistPageWatchlistName) {
            if (m.getText().contains(text)) {
                Utils.logStepInfo(true, "stock name displayed in watchlist stock page verification successfully !!!!!!!");
                break;
            } else {
                Utils.logStepInfo(false, "stock name Not Displayed in watchlist stock page verification failed ********");
            }
        }
        commonFunctions.clickElement(watchlistPageRemoveIcon.get(0), 5, "first three dots");
        isShowing &= commonFunctions.isElementDisplayed(watchlistPageDeleteIcon, 5, "delete icon");
        commonFunctions.navigateBack();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(watchlistPageNewsSection, "news section");
        commonFunctions.navigateBack();
        return isShowing;
    }

    private boolean checkWatchlistIconAndPage() {
        commonFunctions.dummyWait(1);
        commonFunctions.swipeElementUsingTouchAction(491, 466, 462, 1571);
        commonFunctions.dummyWait(1);
        commonFunctions.clickElement(watchlistIcon, 10, "watchlist icon");
        return commonFunctions.isElementDisplayed(watchlistIconPage, 5, "watchlist Page");
    }

    @Override
    public boolean checkWatchlistNewsSectionNotDisplayed() {
        boolean isShowing = clickOnMarketTabAndCheckMarketPage();
        isShowing &= checkWatchlistIconAndPage();
        isShowing &= deleteWatchlistStockName();
        isShowing &= commonFunctions.isElementNotDisplayed(watchlistPageNewsSection, 5, "news section");
        commonFunctions.navigateBack();
        return isShowing;
    }


    private boolean deleteWatchlistStockName(){
        if (watchlistPageRemoveIcon.size()>0){
            for (MobileElement m:watchlistPageRemoveIcon){
                commonFunctions.clickElementIfDisplayed(m,5,"remove stock icon");
                commonFunctions.clickElementIfDisplayed(watchlistPageDeleteIcon,5,"delete icon");
            }
        }
      return   commonFunctions.isElementDisplayed(watchlistPageNoData,5,"watchlist stock name is empty");
    }

    @Override
    public boolean checkWatchlistViewStockAndToasterMassage(String expText) {
        boolean isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.clickElement(watchlistIcon, 10, "watchlist icon");
        isShowing &= commonFunctions.isElementDisplayed(watchlistIconPage, 5, "watchlist Page");
        isShowing &= addStocksFromWatchlistSearch();
        isShowing &= clickOnVewStockFromThreeDotsAndVerifySpecificStockPage();
        isShowing &= checkWatchlistNewsToasterMassage(expText);
        return isShowing;
    }

    public boolean addStocksFromWatchlistSearch() {
        commonFunctions.sendKeysOnAndroid(watchlistPageSearchBox, "sbi");
        boolean isShowing = commonFunctions.isElementDisplayed(watchlistPageSearchList, 10, "search stock list");
        commonFunctions.clickByCoordinates(233, 766, "first stock name");
        return isShowing;
    }

    public boolean clickOnVewStockFromThreeDotsAndVerifySpecificStockPage() {
        String text = commonFunctions.getElementText(watchlistPageWatchlistName.get(0));
        commonFunctions.clickElement(watchlistPageRemoveIcon.get(0), 5, "first three dots");
        boolean isShowing = commonFunctions.isElementDisplayed(watchlistPageDeleteIcon, 5, "delete icon");
        isShowing &= commonFunctions.clickElement(watchlistPageViewStock, 5, "view stocks");
        isShowing &= commonFunctions.getElementTextAndCheck(mostActByVolDetailPageCompanyName, text, 10, "stock company name");
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(1);
        commonFunctions.navigateBack();
        return isShowing;
    }

    public boolean checkWatchlistNewsToasterMassage(String expText) {
        commonFunctions.clickElement(marketTab, 5, "market tab");
        commonFunctions.clickElement(watchlistIcon, 10, "watchlist icon");
        return commonFunctions.checkPageSourceContainsText(expText, "news toaster massage");
    }

    @Override
    public boolean checkNewsDesignAndNewsCount() {
        boolean isShowing = clickOnMarketTabAndCheckMarketPage();
        commonFunctions.scrollToElementDown(marketPageNewsSection);
        isShowing &= commonFunctions.isElementDisplayed(marketPageNews.get(0),5, "market page news");
        isShowing &= checkWatchlistIconAndPage();
        isShowing &= addStocksFromWatchlistSearch();
        commonFunctions.dummyWait(3);
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(watchlistPageNews, "watchlist page news");
        int newsCount = watchlistPageNews.size();
        if (isShowing &= newsCount <= 20) {
            isShowing &= true;
            Utils.logStepInfo(true, "No. of news (Actual:" + newsCount + ") should not more than 20 displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "No. of news (Actual:" + newsCount + ") is more than 20 verification failed **********");
        }
        return isShowing;
    }

    @Override
    public boolean checkHomeTrendingStocksWidget() {
        commonFunctions.clickElement(homeButton, 10, "home tab");
        boolean isShowing = commonFunctions.scrollToElementDown(widgetTrendingStocks);
        commonFunctions.swipeElementUsingTouchAction(441,1740,434,1613);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(widgetTrendingStocksSection, "trending stocks card section");
        return isShowing;
    }

    @Override
    public boolean checkTrendingStocksWidgetTop3Gainer() {
        boolean isShowing = checkHomeTrendingStocksWidget();
        int cardCount = widgetTrendingStocksFirst3Card.size();
        int topGainerCount = widgetTrendingStocksTop3Gainer.size();
        if (cardCount == 3 && topGainerCount == 3) {
            isShowing &= true;
            Utils.logStepInfo(true, "Top 3 Gainers displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "Top 3 Gainers not display, (Actual:" + topGainerCount + ") verification failed **********");
        }
        return isShowing;
    }

    private boolean swipeLeftForLoserCard() {
        boolean isShowing;
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(widgetTrendingStocksFirst3Card, 0, "first card");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(widgetTrendingStocksFirst3Card, 2, "third card");
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        int thirdEle[] = commonFunctions.getListOfElementXYCoordinate(widgetTrendingStocksFirst3Card, 1, "third card");
        commonFunctions.swipeElementUsingTouchAction(thirdEle[0], thirdEle[1], firstEle[0], firstEle[1]);
        commonFunctions.dummyWait(2);
        int topLoserCount = widgetTrendingStocksTop3Loser.size();
        if (topLoserCount == 3) {
            isShowing = true;
            Utils.logStepInfo(true, "Top 3 Loser displayed successfully !!!!!!!");
        } else {
            isShowing = false;
            Utils.logStepInfo(false, "Top 3 Loser not display, (Actual:" + topLoserCount + ") verification failed **********");
        }
        return isShowing;
    }

    @Override
    public boolean checkTrendingLoserStockDetailPage() {
        boolean isShowing = checkTrendingStocksWidgetTop3Loser();
        String widgetStocksLoserCompanyName = commonFunctions.getElementText(widgetTrendingStocksCompanyName.get(2), 5);
        commonFunctions.clickElement(widgetTrendingStocksCompanyName.get(2), 5, "second card of loser");
        isShowing &= commonFunctions.isElementDisplayed(stockDetailPageCompanyName, 10, "company detail page");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(stockDetailPageCompanyName, widgetStocksLoserCompanyName, 5, "company name");
        return isShowing;
    }

    @Override
    public boolean checkTrendingStocksWidgetTop3Loser() {
        boolean isShowing = checkHomeTrendingStocksWidget();
        isShowing &= swipeLeftForLoserCard();
        return isShowing;
    }

    @Override
    public boolean checkTrendingGainerStockDetailPage() {
        boolean isShowing = checkTrendingStocksWidgetTop3Gainer();
        String widgetStocksGainerCompanyName = commonFunctions.getElementText(widgetTrendingStocksCompanyName.get(1), 5);
        commonFunctions.clickElement(widgetTrendingStocksCompanyName.get(1), 5, "first card of gainer");
        isShowing &= commonFunctions.isElementDisplayed(stockDetailPageCompanyName, 10, "company detail page");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(stockDetailPageCompanyName, widgetStocksGainerCompanyName, 5, "company name");
        return isShowing;
    }

    @Override
    public boolean checkTrendingStocksMarketDashboard() {
        boolean isShowing = checkHomeTrendingStocksWidget();
        isShowing &= commonFunctions.isElementDisplayed(TrendingStocksMarketDashboard, 10, "Trending Stocks MarketDashboard");
        commonFunctions.clickElement(TrendingStocksMarketDashboard, 10, "Trending Stocks MarketDashboard");
        isShowing &= commonFunctions.isElementDisplayed(marketDashboardPage, 10, "marketDashboard Page");
        return isShowing;
    }

    @Override
    public boolean checkTrendingStockLeftAndRightSwipeFunctionality() {
        boolean isShowing = checkHomeTrendingStocksWidget();
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(widgetTrendingStocksCompanyName, 0, "first card");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(widgetTrendingStocksCompanyName, 2, "third card");
        String firstCardText = commonFunctions.getElementText(widgetTrendingStocksCompanyName.get(0), 10);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        commonFunctions.dummyWait(2);
        String thirdStoryText = commonFunctions.getElementText(widgetTrendingStocksCompanyName.get(0), 10);
        if (firstCardText != thirdStoryText) {
            isShowing &= true;
            Utils.logStepInfo(true, "card swipe to Right-Left successfully *****");
        } else {
            isShowing = false;
            Utils.logStepInfo(false, "card Not swipe to Right-Left verification failed !!!!");
        }
        commonFunctions.swipeElementUsingTouchAction(firstEle[0], firstEle[1], secondEle[0], secondEle[1]);
        commonFunctions.dummyWait(2);
        isShowing &= commonFunctions.getElementTextAndCheck(widgetTrendingStocksCompanyName.get(0), firstCardText, 10, "card swipe to Left-Right");
        return isShowing;
    }

    }