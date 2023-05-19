package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonAdvertisementPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdvertisementPage extends CommonAdvertisementPage {

    //    private AndroidDriver driver;
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @AndroidFindBy(accessibility = "Latest")
    private static MobileElement latestMenuButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtSubscribe")
    private static MobileElement subscribeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/imageViewAppLogo")
    private static MobileElement mintLogo;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement chooseAPlanButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/collection_title")
    private static MobileElement premiumStories;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView[1]")
    private static MobileElement firstPremiumStory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='RECOMMENDED FOR YOU']")
    private static MobileElement recommendedForYouCarousel;
    @AndroidFindBy(id = "com.htmedia.mint:id/layoutContentAdsBG")
    private static MobileElement adAfterStories;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement premiumCollectOfferButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement choosePlansHeader;
    @AndroidFindBy(id = "com.htmedia.mint:id/layoutContentAdsBG")
    private static MobileElement homePageAdsBanner;
    @AndroidFindBy(id = "com.htmedia.mint:id/layoutHeaderAdsBG")
    private static MobileElement sponsoredAd;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewThumbnailStory")
    private static List<MobileElement> latestPageStories;

    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;

    @FindBy(xpath = "//span[@id='noTCounter']")
    private static MobileElement notificationBadge;
    @FindBy(xpath = "//android.widget.ScrollView/android.widget.RelativeLayout")
    private static MobileElement browsersOptionPopUp;
    @FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[1]")
    private static MobileElement chromeBrowserOption;
    @FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]")
    private static MobileElement ucBrowserOption;
    @FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[3]")
    private static MobileElement firefoxBrowserOption;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static MobileElement notificationHeading;

    @FindBy(xpath = "//div[@id='notification_new']")
    private static MobileElement notificationNew;

    @FindBy(xpath = "//android.widget.TextView[@text='Companies']")
    private static MobileElement companies;

    @FindBy(xpath = "//android.widget.TextView[@text='COMPANIES']")
    private static MobileElement companiesPage;

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

    @FindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static MobileElement storyHeadline;

    @FindBy(xpath = "//android.widget.LinearLayout[2]//android.widget.RelativeLayout")
    private static MobileElement secondStory;

    @FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout")
    private static MobileElement forYouStory;

    @FindBy(xpath = "//android.view.ViewGroup[1]//android.widget.LinearLayout[3]")
    private static MobileElement forYouSecondStory;

    @FindBy(xpath = "//android.view.ViewGroup[1]//android.widget.LinearLayout[4]")
    private static MobileElement forYouThirdStory;

    @FindBy(xpath = "//android.widget.LinearLayout[5]/android.widget.FrameLayout")
    private static MobileElement forYouFourthStory;

    @FindBy(xpath = "//android.widget.LinearLayout[3]//android.widget.RelativeLayout")
    private static MobileElement thirdStory;

    @FindBy(xpath = "//android.widget.LinearLayout[4]//android.widget.RelativeLayout")
    private static MobileElement fourthStory;

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

    @FindBy(id = "com.htmedia.mint:id/imgViewDetailBookmark")
    private static MobileElement bookmarkIcon;

    @FindBy(id = "agree")
    private static MobileElement acceptCookie;

    @FindBy(xpath = "//android.widget.TextView[@text='\uE902']")
    private static MobileElement closePopUp;

    @FindBy(id = "com.htmedia.mint:id/layoutCloseButton")
    private static MobileElement closeBtn;

    @FindBy(id = "com.htmedia.mint:id/nav_home")
    private static MobileElement home;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;

    @FindBy(xpath = "//android.view.View/android.view.View")
    private static MobileElement interstitialAds;

    @FindBy(xpath = "//android.widget.TextView[@text='Close']")
    private static MobileElement interstitialAdsClose;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='close-button-icon']")
    private static MobileElement interstitialAdClose;

    @FindBy(xpath = "//android.widget.TextView[@text='Advertisement']")
    private static MobileElement secondAd;

    @FindBy(id = "com.htmedia.mint:id/txtViewDetailImageCaption")
    private static MobileElement imageCaption;

    @FindBy(xpath = "//android.widget.TextView[@text='BSE SENSEX']")
    private static MobileElement marketBSESENSEX;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY 50']")
    private static MobileElement marketNifty50;

    @FindBy(xpath = "//android.widget.TextView[@text='NIFTY BANK']")
    private static MobileElement marketNiftyBank;

    @FindBy(xpath = "//android.widget.TextView[@text='BSE MIDCAP']")
    private static MobileElement marketBSEMIDCAP;

    @FindBy(xpath = "//android.widget.TextView[@text='GOLD']")
    private static MobileElement marketGOLD;

    @FindBy(xpath = "//android.widget.TextView[@text='SILVER']")
    private static MobileElement marketSILVER;

    @FindBy(id = "com.htmedia.mint:id/indAmount")
    private static MobileElement marketSENSEXIndex;

    @FindBy(id = "com.htmedia.mint:id/txtCommodityValue")
    private static MobileElement marketGoldIndex;

    @FindBy(xpath = "//android.widget.TextView[@text='back']")
    private static MobileElement backBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='LATEST']")
    private static MobileElement latestLandingPage;

    @FindBy(xpath = "//android.widget.TextView[@text='TRENDING']")
    private static MobileElement trendingLandingPage;

    @FindBy(id = "com.htmedia.mint:id/nav_latest")
    private static MobileElement latest;

    @FindBy(id = "com.htmedia.mint:id/nav_popular")
    private static MobileElement trending;

    @FindBy(id = "com.htmedia.mint:id/nav_myReads")
    private static MobileElement premium;

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

    @FindBy(xpath = ".//android.widget.ImageView[@resource-id='com.htmedia.mint:id/imgViewHeader']")
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
    private static MobileElement removeAd;
    @FindBy(xpath = "//android.widget.TextView[@text='MINT PREMIUM']")
    private static MobileElement mintPremium;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;


    public AdvertisementPage() {
        globalVars = GlobalVars.getInstance();
//        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    @Override
    public boolean checkAdsOnHomePage() {
        boolean isAdsDisplayedOnHomePage=true;
        commonFunctions.clickElement(home, 10, "Home Page Button");
        commonFunctions.scrollDownToElement(recommendedForYouCarousel);
        commonFunctions.isElementDisplayed(recommendedForYouCarousel, 10, "Recommended for you carousel");
        isAdsDisplayedOnHomePage=commonFunctions.isElementDisplayed(homePageAdsBanner, 10, "Ads Banner above recommended for you carousel");
        return isAdsDisplayedOnHomePage;
    }

    @Override
    public boolean checkAdsOnSectionPage() {
        boolean isAdsDisplayedOnLatestPage=true;
        commonFunctions.clickElement(homeButton, 10, "Home Page Button");
        commonFunctions.clickElement(latestMenuButton, 10, "Latest menu button");
        commonFunctions.isElementDisplayedOfListOfElements(latestPageStories, "Latest Page Stories Thumbnail");
        commonFunctions.scrollDownToElement(adAfterStories);
        isAdsDisplayedOnLatestPage=commonFunctions.isElementDisplayed(adAfterStories, 10, "Ads Banner on Latest Section Page After Stories");
        return isAdsDisplayedOnLatestPage;
    }

    @Override
    public boolean checkSponsoredAd() {
        commonFunctions.clickElement(homeButton, 10, "Home Page Button");
        commonFunctions.clickElement(sponsoredAd, 10, "Homepage Sponsored Ad");
        commonFunctions.isElementDisplayed(browsersOptionPopUp, 10, "Ad open pop up");
        commonFunctions.isElementDisplayed(chromeBrowserOption, 10, "Chrome option in popup");
        commonFunctions.isElementDisplayed(ucBrowserOption, 10, "Uc Browser option in popup");
        boolean isBrowserPopupDisplayed=commonFunctions.isElementDisplayed(firefoxBrowserOption, 10, "Firefox Browser option in popup");
        commonFunctions.pressAndroidBackKey();
        return isBrowserPopupDisplayed;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityOnTopicPage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "HomePage Tab");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.checkElementVisibilityByScrolling(companies, "Companies Topic Section");
        commonFunctions.clickElement(companies, 10, "Companies Topic Page");
        isShowing=commonFunctions.isElementDisplayed(companiesPage, 10, "Companies Page");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        commonFunctions.clickElement(backBtn, 10, "Back to Explore Page");
        return isShowing;
    }

    @Override
    public boolean checkLeadsAdsOnHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "HomePage Tab");
        commonFunctions.dummyWait(5);
        isShowing=commonFunctions.isElementDisplayed(removeAd, 10, "Lead Image on Homepage");
        return isShowing;
    }

    private boolean ClickOnAdsAndVerifyPlanPageAndBack() {
        boolean isShowing;
        commonFunctions.clickElement(removeAd, 10, "remove ads");
        isShowing = commonFunctions.isElementDisplayed(choosePlansHeader, 10, "Plan page");
        commonFunctions.clickElement(backBtn, 10, "Back button plan page");
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityAndBackButton() {
        boolean isShowing;
        isShowing = checkLeadsAdsOnHomePage();
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        isShowing &= commonFunctions.isElementDisplayed(firstStory, 10, "Home page");
        return isShowing;
    }

    @Override
    public boolean checkSecondAdsRemoveAdsFunctionalityAndBackButton() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home button");
        commonFunctions.checkElementVisibilityByScrolling(mintPremium, "Mint Premium on Homepage");
        commonFunctions.dummyWait(5);
        isShowing=commonFunctions.checkElementVisibilityByScrolling(secondAd, "Second Ad");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        commonFunctions.clickElement(home, 10, "Home Page Tab");
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityOnLatestAndTrendingPage() {
        boolean isShowing;
        commonFunctions.clickElement(latest, 10, "Latest Tab");
        isShowing = commonFunctions.isElementDisplayed(latestLandingPage, 10, "Latest Page");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        commonFunctions.clickElement(trending, 10, "Trending Tab");
        commonFunctions.isElementDisplayed(trendingLandingPage, 10, "Trending Page");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityOnStoryDetailPage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home tab");
        commonFunctions.clickElement(latest, 10, "Latest Tab");
        isShowing = commonFunctions.isElementDisplayed(latestLandingPage, 10, "Latest Page");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        isShowing &= commonFunctions.isElementDisplayed(removeAd, 10, "remove ads");
        commonFunctions.clickElement(latest, 10, "Latest Tab");
        isShowing &= commonFunctions.isElementDisplayed(latestLandingPage, 10, "Latest Page");
        return isShowing;
    }

    @Override
    public boolean checkFirstInterstitialAds() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home tab");
        commonFunctions.clickElement(storyImage, 10, "First story");
        isShowing=commonFunctions.isElementDisplayed(storyAuthor, 10, "First Open Story");
        commonFunctions.clickElement(home, 10, "Home Page");
        commonFunctions.scrollDownToElement(secondStory);
        commonFunctions.clickElement(secondStory, 10, "Second Story");
        isShowing &=commonFunctions.isElementDisplayed(interstitialAds, 10, "First Interstitial Ad");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(interstitialAdsClose, 10, "First Interstitial Ads Close Button");
        commonFunctions.clickElementIfDisplayed(interstitialAdClose, 10, "First Interstitial Ad Close Button");
        commonFunctions.pressAndroidBackKey();
        return isShowing;
    }

    @Override
    public boolean checkSecondInterstitialAds() {
        boolean isShowing;
        checkFirstInterstitialAds();
        commonFunctions.clickElement(latest,10, "For You tab");
        commonFunctions.clickElement(forYouStory, 10, "First Story");
        commonFunctions.clickElement(latest, 10, "For You tab");
        commonFunctions.clickElement(forYouSecondStory, 10, "Second Story");
        commonFunctions.clickElement(latest,10, "For You tab");
        commonFunctions.clickElement(forYouThirdStory, 10, "Third Story");
        commonFunctions.clickElement(latest,10, "For You tab");
        commonFunctions.scrollDownToElement(forYouFourthStory);
        commonFunctions.clickElement(forYouFourthStory, 10, "Fourth Story");
        isShowing=commonFunctions.isElementDisplayed(interstitialAds, 10, "Second Interstitial Ad");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(interstitialAdsClose, 10, "Interstitial Ads Close Button");
        commonFunctions.clickElementIfDisplayed(interstitialAdClose, 10, "Interstitial Ad Close Button");
        commonFunctions.pressAndroidBackKey();
        return isShowing;
    }


    @Override
    public boolean checkAdsOnSubscribedHomePage(){
        return false;
    }

    @Override
    public boolean checkAdsOnSubscribedStoryPage(){
        return false;
    }

    @Override
    public boolean checkAdsOnSubscribedlistingPage(String pageName){
        return false;
    }
}

