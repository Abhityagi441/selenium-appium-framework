package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonSubscriptionPage;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends CommonHomePage {
    //    private IOSDriver driver;
    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonSubscriptionPage subscriptionPage;
    String expectedPlainText;

    @iOSXCUITFindBy(id = "captionID")
    private static MobileElement imageCaption;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'BSE SENSEX'`]")
    private static MobileElement marketSensex;

    @iOSXCUITFindBy(id = "S&P BSE SENSEX")
    private static MobileElement marketSensexLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'NIFTY 50'`]")
    private static MobileElement marketNifty;

    @iOSXCUITFindBy(id = "Nifty 50")
    private static MobileElement marketNiftyLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'NIFTY BANK'`]")
    private static MobileElement marketNiftyBank;

    @iOSXCUITFindBy(id = "Nifty Bank")
    private static MobileElement marketNiftyBankLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'BSE MIDCAP'`]")
    private static MobileElement marketBSEMidCap;

    @iOSXCUITFindBy(id = "S&P BSE Mid-Cap")
    private static MobileElement marketBSEMidCapLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'GOLD'`]")
    private static MobileElement marketGold;

    @iOSXCUITFindBy(id = "Gold")
    private static MobileElement marketGoldLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'SILVER'`]")
    private static MobileElement marketSilver;

    @iOSXCUITFindBy(id = "Silver")
    private static MobileElement marketSilverLanding;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
    private static MobileElement summary;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[4]")
    private static MobileElement summary2;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText")
    private static List<MobileElement> summaryList;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
    private static MobileElement saveButton;

    @iOSXCUITFindBy(id = "Try Mint E-paper")
    private static MobileElement try_Mint_Epaper;

    @iOSXCUITFindBy(id = "Mint Genie")
    private static MobileElement mint_Genie_Epaper;

    @iOSXCUITFindBy(id = "Mint Lounge")
    private static MobileElement mintLoungeCarousel;

    @iOSXCUITFindBy(id = "Mint Lounge[1]")
    private static MobileElement firstStoryOnMintLoungeCarousel;

    @iOSXCUITFindBy(id = "closeEpaperWall")
    private static MobileElement try_Mint_Epaper_Close_Button;

    @iOSXCUITFindBy(id = "my profile cross")
    private static MobileElement closeIconInProfile;

    @FindBy(name = "My Account")
    private static MobileElement myAccountWithArrow;

    @FindBy(name = "Name")
    private static MobileElement nameEditProfile;

    @FindBy(name = "Email")
    private static MobileElement emailEditProfile;

    @FindBy(name = "Gender")
    private static MobileElement genderEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Edit Profile']")
    private static MobileElement editProfile;

    @FindBy(name = "Edit Profile")
    private static MobileElement editProfilePage;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement Name;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement Email;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement mobileNumber;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement genderOption;

    @FindBy(id = "Logout")
    private static MobileElement logoutBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Logout']")
    private static MobileElement logoutPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private static MobileElement okBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Sign in'`][2]")
    private static MobileElement signInButton;

    @iOSXCUITFindBy(id = "Privacy Policy")
    private static MobileElement privacyPolicy;

    @iOSXCUITFindBy(id = "Terms of Use")
    private static MobileElement termsOfUse;

    @FindBy(id = "Cookie Policy")
    private static MobileElement cookiePolicy;

    @FindBy(id = "Subscriber Agreement")
    private static MobileElement subscriberAgreement;

    @iOSXCUITFindBy(id = "PRIVACY POLICY")
    private static MobileElement privacyPolicyLandingPage;

    @iOSXCUITFindBy(id = "TERMS OF USE")
    private static MobileElement termsOfUseLandingPage;

    @FindBy(id = "COOKIE POLICY")
    private static MobileElement cookiePolicyLandingPage;

    @FindBy(id = "SUBSCRIBER AGREEMENT")
    private static MobileElement subscriberAgreementLandingPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Subscribe Now']")
    private static MobileElement SubscribeNow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Subscribe to Continue')]")
    private static MobileElement subscribeToContinueReadingBanner;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Subscribe to Continue')]")
    private static MobileElement firstStoryHeadingOnStoryDetailPage;

    @iOSXCUITFindBy(accessibility = "Subscribe to Continue Reading")
    private static MobileElement subscribeToContinueReadingPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement proceedWithoutAppleID;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell//XCUIElementTypeStaticText)[2]")
    private static MobileElement userNameMyAccount;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell//XCUIElementTypeStaticText)[3]")
    private static MobileElement userEmailMyAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeButton[4]")
    private static MobileElement editNameBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeButton[3]")
    private static MobileElement editGenderBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther//XCUIElementTypeTextField")
    private static MobileElement editPasswordField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='editPasswordButton'])[1]")
    private static MobileElement editPasswordBtn;

    @FindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeSecureTextField)[1]")
    private static MobileElement enterNewPass;

    @FindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeSecureTextField)[2]")
    private static MobileElement enterConfirmPass;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Reset'`]")
    private static MobileElement resetPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeTextField")
    private static MobileElement name;

    @iOSXCUITFindBy(id = "Add your Contact Number")
    private static MobileElement addYourContactNo;

    @FindBy(name = "editAddIcon")
    private static MobileElement editContactBtn;

    @FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Female')]")
    private static MobileElement femaleGenderRadioButton;

    @FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Male')]")
    private static MobileElement maleGenderRadioButton;

    @FindBy(id = "Female")
    private static MobileElement female;

    @FindBy(id = "Male")
    private static MobileElement male;

    @iOSXCUITFindBy(id = "closeButton")
    private static MobileElement closeStory;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    private static MobileElement marketTicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'MTicker'`]")
    private static List<MobileElement> marketTickerElementList;

    @iOSXCUITFindBy(id = "publishedID")
    private static MobileElement timestamp;

    @iOSXCUITFindBy(id = "Label")
    private static MobileElement firstStory;

    @iOSXCUITFindBy(id = "headlineID")
    private static MobileElement headline;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    private static MobileElement firstStoryInLandingPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    private static MobileElement firstStoryInPremium;

    @iOSXCUITFindBy(id = "To Continue Reading, Subscribe Now")
    private static MobileElement continueReadingSubscribeNow;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeStaticText)[2]")
    private static MobileElement firstStoryInSearchResults;

    @iOSXCUITFindBy(id = "exclusive_big")
    private static MobileElement premiumLabel;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == 'exclusive_big'`]")
    private static List<MobileElement> premiumLabelList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='headlineID']//following::XCUIElementTypeImage[1]")
    private static List<MobileElement> storyImageAfterTheTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Label']//preceding::XCUIElementTypeImage[1]")
    private static MobileElement storyImage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeImage")
    private static List<MobileElement> storyImageList;

    @iOSXCUITFindBy(id = "authorID")
    private static MobileElement storyAuthor;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Label'`][1]")
    private static List<MobileElement> storySummary;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'bookmark'`][1]")
    private static MobileElement bookmarkIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'bookmar')]")
    private static List<MobileElement> bookmarkIconList;

    @iOSXCUITFindBy(id = "My Reads")
    private static MobileElement myReadsMenu;

    @iOSXCUITFindBy(id = "bookmarksliderspace")
    private static MobileElement bookmarksSwiperBox;

    @FindBy(xpath = "//div[@id='bookmarksliderspace']//div[@id='swiper_b']//h2/a")
    private static List<MobileElement> bookmarksSwiperBoxElementsList;

    @iOSXCUITFindBy(id = "agree")
    private static MobileElement acceptCookie;

    @iOSXCUITFindBy(id = "Close")
    private static MobileElement closeButtonInShareOverlay;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Back'`][1]")
    private static MobileElement backInEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;

    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;

    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;

    @iOSXCUITFindBy(id = "Latest")
    private static MobileElement latest;

    @iOSXCUITFindBy(id = "LATEST")
    private static MobileElement latestLandingPage;

    @iOSXCUITFindBy(id = "Trending")
    private static MobileElement trending;

    @iOSXCUITFindBy(id = "TRENDING")
    private static MobileElement trendingLandingPage;

    @iOSXCUITFindBy(id = "Premium")
    private static MobileElement premium;

    @iOSXCUITFindBy(id = "PREMIUM")
    private static MobileElement premiumLandingPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement explore;

    @iOSXCUITFindBy(id = "notification")
    private static MobileElement notificationIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch")
    private static MobileElement notificationFlag;

    @iOSXCUITFindBy(id = "News")
    private static MobileElement news;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Markets']//following::XCUIElementTypeOther[2]")
    private static MobileElement marketsArrowBtn;

    @iOSXCUITFindBy(id = "Stock Markets")
    private static MobileElement stockMarkets;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='STOCK MARKETS']")
    private static MobileElement stockMarketsLandingPage;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@id='viewAll']")
    private static MobileElement viewAllMintPremiumCarousel;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@id='viewAll']")
    private static MobileElement viewAllWSJCarousel;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@id='viewAll']")
    private static MobileElement viewAllMintLoungeCarousel;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name='Label']")
    private static MobileElement firstStoryOnWSJPremium;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name='Label']")
    private static MobileElement firstStoryInWSJLandingPage;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name='MINT PREMIUM']")
    private static MobileElement mintPremiumCarousel;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name='FROM THE WALL STREET JOURNAL']")
    private static MobileElement wSJCarousel;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name='Premium']")
    private static MobileElement premiumHeaderText;

    @iOSXCUITFindBy(id = "Search")
    private static MobileElement searchButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    private static MobileElement searchTextField;

    @iOSXCUITFindBy(id = "TRENDING TOPICS")
    private static MobileElement trendingTopics;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    private static List<MobileElement> storiesList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'share')]")
    private static List<MobileElement> shareIconsList;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private static List<MobileElement> ListOfStory;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'share'`][1]")
    private static MobileElement shareIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'share'`][1]")
    private static MobileElement shareIconUnderStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TRENDING TOPICS']//following::XCUIElementTypeStaticText[2]")
    private static MobileElement storyInTopics;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == 'Messages'`]")
    private static MobileElement messagesIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == 'AirDrop'`]")
    private static MobileElement airDropIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText/XCUIElementTypeOther[`label BEGINSWITH 'Plain Text'`]")
    private static MobileElement plainText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == 'messageBodyField'`]")
    private static MobileElement messageBody;

    @iOSXCUITFindBy(id = "my profile cross")
    private static MobileElement closeEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement cancelButton;

    @iOSXCUITFindBy(id = "e-paper")
    private static MobileElement ePaper;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'e-paper'`][1]")
    private static MobileElement ePaperSubscribed;

    @iOSXCUITFindBy(accessibility = "logo01Latest")
    private static MobileElement mintLogo;

    @iOSXCUITFindBy(id = "closeEpaperWall")
    private static MobileElement closeEPaperPopUp;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Subscribe'`][2]")
    private static MobileElement subscribeButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'SPONSORED'`][1]")
    private static MobileElement sponsoredStory;
    @iOSXCUITFindBy(id = "RECOMMENDED FOR YOU")
    private static MobileElement recommendedForYouCarousel;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='SPONSORED'])[1]/following::XCUIElementTypeStaticText[1]")
    private static MobileElement firstSponsoredStory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='SPONSORED'])[1]/following::XCUIElementTypeOther[2]/following-sibling::XCUIElementTypeButton[contains(@name,'bookmar')]")
    private static MobileElement firstSponsoredStoryBookmarkButton;
    @iOSXCUITFindBy(id = "New Articles")
    private static MobileElement newArticles;
    @iOSXCUITFindBy(id = "BSE SENSEX")
    private static MobileElement marketTickerBseSenSex;
    @iOSXCUITFindBy(id = "NIFTY 50")
    private static MobileElement marketTickerNifty50;
    @iOSXCUITFindBy(id = "Nifty 50")
    private static MobileElement marketTickerNifty50LandingPage;
    @iOSXCUITFindBy(id = "NIFTY BANK")
    private static MobileElement marketTickerNiftyBank;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'back'`]")
    private static MobileElement backButton;
    @iOSXCUITFindBy(id = "Nifty Bank")
    private static MobileElement marketTickerNiftyBankLandingPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'MINT PREMIUM'`][1]")
    private static MobileElement homePageMintPremium;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Advertisement'`][1]")
    private static MobileElement firstAdsAdvertisementLabel;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Remove Ad'`]")
    private static MobileElement firstAdsRemoveAdButton;
    @iOSXCUITFindBy(id = "Choose a plan")
    private static MobileElement planPage;
    @iOSXCUITFindBy(id = "Markets")
    private static MobileElement marketTab;
    @iOSXCUITFindBy(accessibility = "MARKETS")
    private static MobileElement marketTickerPage;
    @iOSXCUITFindBy(id = "NIFTY Bank")
    private static MobileElement marketTickerPageNiftyBank;
    @iOSXCUITFindBy(id = "S&P BSE SENSEX")
    private static MobileElement marketTickerPageSensex;
    @iOSXCUITFindBy(id = "S&P BSE Midcap")
    private static MobileElement marketTickerPageMindCap;
    @iOSXCUITFindBy(id = "NIFTY 50")
    private static MobileElement marketTickerPageNifty50;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'NIFTY Bank'`][2]")
    private static MobileElement marketTickerPageNiftyBankDetailPage;
    @iOSXCUITFindBy(id = "For You")
    private static MobileElement forYouTab;
    @iOSXCUITFindBy(accessibility = "FOR YOU")
    private static MobileElement forYouPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All'`][1]")
    private static MobileElement viewAllMarketPage;
    @iOSXCUITFindBy(accessibility = "INDIAN INDICES")
    private static MobileElement indianIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfElementOnIndianIndicesPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='S&P BSE 500']")
    private static MobileElement secondIndianIndices;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='S&P BSE 500'])[1]")
    private static MobileElement secondIndianIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '5D'`]")
    private static MobileElement fiveDOnIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '1M'`]")
    private static MobileElement oneMOnIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '1Y'`]")
    private static MobileElement oneYOnIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '5Y'`]")
    private static MobileElement fiveYOnIndicesPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'%')])[5]")
    private static MobileElement priceChangeInPercentage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,',')])[2]")
    private static MobileElement latestPrice;
    @iOSXCUITFindBy(accessibility = "GAINERS & LOSERS")
    private static MobileElement gainerAndLosers;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`][1]")
    private static MobileElement gainerAndLosersBse;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`][1]")
    private static MobileElement gainerAndLosersNse;
    @iOSXCUITFindBy(accessibility = "Top Gainers")
    private static MobileElement topGainer;
    @iOSXCUITFindBy(accessibility = "Top Losers")
    private static MobileElement topLoser;
    @iOSXCUITFindBy(accessibility = "S&P BSE 100")
    private static MobileElement firstIndianIndices;
    @iOSXCUITFindBy(accessibility = "S&P BSE 500")
    private static MobileElement thirdIndianIndices;
    @iOSXCUITFindBy(accessibility = "S&P BSE Bankex")
    private static MobileElement fourthIndianIndices;
    @iOSXCUITFindBy(accessibility = "NEWS - S&P BSE 100")
    private static MobileElement NewsBse100;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'View All'`][2]")
    private static MobileElement topLoserViewAll;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'View All'`][3]")
    private static MobileElement topGainerViewAll;
    @iOSXCUITFindBy(accessibility = "TOP GAINERS")
    private static MobileElement topGainerDetailPage;
    @iOSXCUITFindBy(accessibility = "TOP LOSERS")
    private static MobileElement topLoserDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfElementOnTopGainersPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfElementOnTopLosersPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'Updated')])[1]")
    private static MobileElement gainersLoserUpdateStatus;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`][1]")
    private static MobileElement gainersLoserBseTab;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`][1]")
    private static MobileElement gainersLoserNseTab;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='View All'])[2]/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listOfElementOnGainerLoserSection;
    @iOSXCUITFindBy(id = "MOST ACTIVE BY VOLUME")
    private static MobileElement mostActiveByVolume;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`][2]")
    private static MobileElement mostActiveByVolumeBseTab;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`][2]")
    private static MobileElement mostActiveByVolumeNseTab;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]")
    private static MobileElement mostActiveByVolumeUpdateStatus;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All'`][4]")
    private static MobileElement mostActiveByVolumeViewAll;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSegmentedControl)[2]/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listOfElementOnMostActiveByVolumeSection;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[2]")
    private static MobileElement mostActiveByVolumeFirstHighestLevel;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[4]")
    private static MobileElement mostActiveByVolumeSecondHighestLevel;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[5]")
    private static MobileElement mostActiveByVolumeThirdHighestLevel;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[7]")
    private static MobileElement mostActiveByVolumeFourthHighestLevel;
    @iOSXCUITFindBy(id = "SECURITY")
    private static MobileElement mostActiveByVolumeSecurity;
    @iOSXCUITFindBy(id = "VOL(000’S)")
    private static MobileElement mostActiveByVolumeVol;
    @iOSXCUITFindBy(id = "CHANGE")
    private static MobileElement mostActiveByVolumeChange;
    @iOSXCUITFindBy(id = "MOST ACTIVE BY VOLUME")
    private static MobileElement mostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfCompanyOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`]")
    private static MobileElement nseTabOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`]")
    private static MobileElement bseTabOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='NSE']/following-sibling::XCUIElementTypeStaticText)[3]")
    private static MobileElement companyShortNameOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='NSE']/following-sibling::XCUIElementTypeStaticText)[4]")
    private static MobileElement companyFullNameOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='NSE']/following-sibling::XCUIElementTypeStaticText)[4]")
    private static MobileElement stockPriceOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText)[2]")
    private static MobileElement firstCompanyVolumeOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeCell)[3]/XCUIElementTypeStaticText)[2]")
    private static MobileElement secondCompanyVolumeOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeCell)[4]/XCUIElementTypeStaticText)[2]")
    private static MobileElement thirdCompanyVolumeOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeSegmentedControl)[2]/following-sibling::XCUIElementTypeStaticText)[2]")
    private static MobileElement firstCompanyNameOnMostActiveByVolume;
    @iOSXCUITFindBy(id = "Prv close")
    private static MobileElement previousCloseSection;
    @iOSXCUITFindBy(id = "Open price")
    private static MobileElement openPriceSection;
    @iOSXCUITFindBy(id = "Day high")
    private static MobileElement dayHighSection;
    @iOSXCUITFindBy(id = "Day low")
    private static MobileElement dayLowSection;
    @iOSXCUITFindBy(id = "52 week low")
    private static MobileElement Week52LowSection;
    @iOSXCUITFindBy(id = "52 week high")
    private static MobileElement Week52HighSection;
    @iOSXCUITFindBy(id = "Bid quantity")
    private static MobileElement BidQuantitySection;
    @iOSXCUITFindBy(id = "Volume")
    private static MobileElement volumeSection;
    @iOSXCUITFindBy(id = "FINANCIALS")
    private static MobileElement finanicalSection;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Balance sheet'`]")
    private static MobileElement BalanceSheetSection;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Income statement'`]")
    private static MobileElement incomeStatementSection;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DATE']/following-sibling::XCUIElementTypeTextField")
    private static MobileElement dateDropDownSection;
    @iOSXCUITFindBy(id = "Standalone")
    private static MobileElement standaloneSection;
    @iOSXCUITFindBy(id = "Total Revenue ")
    private static MobileElement totalRevenueTag;
    @iOSXCUITFindBy(id = "Cash ")
    private static MobileElement cashTag;
    @iOSXCUITFindBy(id = "COMPANY INFORMATION")
    private static MobileElement companyInfoSection;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'About ')]")
    private static MobileElement companyInfoAboutSection;
    @iOSXCUITFindBy(id = "Management")
    private static MobileElement companyInfoManagementSection;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == '+'`][1]")
    private static MobileElement companyInfoAboutPlusButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == '+'`][2]")
    private static MobileElement companyInfoManagementPlusButton;
    @iOSXCUITFindBy(id = "Industry")
    private static MobileElement companyInfoAboutInDetail;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == '-'`][3]")
    private static MobileElement companyInfoAboutCollepsedButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Chief ')]")
    private static MobileElement companyInfoManagementInDetail;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='gainersId'])[1]")
    private static MobileElement topGainerFirstCompanyName;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[2]//XCUIElementTypeStaticText)[5]")
    private static MobileElement FirstCompanyDetailNameGainerDetailPage;
    @iOSXCUITFindBy(id = "Line Chart. 1 dataset. ")
    private static MobileElement lineGraph;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'%')])[3]")
    private static MobileElement priceChangeInPercentageOnDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,',')])[5]")
    private static MobileElement latestPriceOnDetailPage;
    @iOSXCUITFindBy(id = "OPEN PRICE")
    private static MobileElement openPriceTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "PREVIOUS CLOSE")
    private static MobileElement preCloseTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "DAY HIGH")
    private static MobileElement dayHighTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "DAY LOW")
    private static MobileElement dayLowTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "52 WEEK HIGH")
    private static MobileElement week52HighTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "52 WEEK LOW")
    private static MobileElement week52LowTagOnIndicesDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'.')])[1]")
    private static MobileElement niftyLatestChangesPrice;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'%')])[3]")
    private static MobileElement niftyLatestChangesPriceInPercentage;
    @iOSXCUITFindBy(id = "News")
    private static MobileElement newsTab;
    @iOSXCUITFindBy(id = "MINT SNAPVIEW")
    private static MobileElement mintSnapView;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEWSLETTERS']")
    private static MobileElement newsLetterSection;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Top of the Morning')]")
    private static MobileElement newsLetterMorning;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@label='Read'])[3]")
    private static MobileElement newsLetterReadNow;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[13]")
    private static MobileElement storyListSize;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[45]")
    private static MobileElement newsLetterPosition;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[45]/XCUIElementTypeOther[1]")
    private static MobileElement newsLetterTopSpace;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Address'`]")
    private static MobileElement topOfTheWebView;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Good Morning'`]")
    private static MobileElement morningWebView;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Close'`]")
    private static MobileElement webViewCloseButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[2])[1]")
    private static MobileElement secondStoryOnHomePage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='storyHeadlineId'])[1]")
    private static MobileElement storyDetailPageHeadline;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All '`][1]")
    private static MobileElement mintPremiumViewAllStoryDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
    private static MobileElement firstStoryOnHomePage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All '`][2]")
    private static MobileElement secondViewAllStoryDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='aa'])[2]")
    private static MobileElement fontSizeOnStoryDetailPage;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;
    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement exploreBottomNavigation;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic newsletter dark'`][2]")
    private static MobileElement ePaperIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MARKETS']")
    private static MobileElement MarketCardPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='ic profile dark'])[2]")
    private static MobileElement signInButtonOnTop;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Subscribe'`][2]")
    private static MobileElement subscribe;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Settings'`]")
    private static MobileElement settingsIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Market Dashboard']")
    private static MobileElement marketDashboard;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='MOST ACTIVE BY VOLUME']/following-sibling::XCUIElementTypeStaticText)[2]")
    private static MobileElement stockSuzlonEnergy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MOST ACTIVE BY VOLUME']")
    private static MobileElement mostActiveVolume;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEWS - SUZLON ENERGY']")
    private static MobileElement newsSuzlonEnergy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='TOP PERFORMING MUTUAL FUNDS']")
    private static MobileElement topPerformingMutualFunds;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='View All'])[3]")
    private static MobileElement viewAllMutualFund;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Mutual Funds-Top Performers']")
    private static MobileElement subtitleMutualFundPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='TOP PERFORMING MUTUAL FUNDS'])[1]")
    private static MobileElement mutualFundTPMF;
    @iOSXCUITFindBy(iOSClassChain = "//XCUIElementTypeOther[@name='TOP PERFORMING MUTUAL FUNDS']/XCUIElementTypeTextField")
    private static MobileElement mutualFundTPMFDropDown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Debt'])[1]")
    private static MobileElement mutualFundDebtCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Equity'])[1]")
    private static MobileElement mutualFundEquityCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Global Fund of Funds'])[1]")
    private static MobileElement mutualFundGlobalFundCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Hybrid'])[1]")
    private static MobileElement mutualFundHybridCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Index Funds'])[1]")
    private static MobileElement mutualFundIndexFundCategory;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'e-paper'`][1]")
    private static MobileElement epaperIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Subscribe'`][1]")
    private static MobileElement subscribeIcon;
    @iOSXCUITFindBy(accessibility = "My Account")
    private static MobileElement signInIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton[4]")
    private static MobileElement l1Tab;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    private static List<MobileElement> l1TabAllOption;
    @iOSXCUITFindBy(accessibility = "D")
    private static MobileElement TickerD;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Markets']")
    private static List<MobileElement> sectionName;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        subscriptionPage = CommonSubscriptionPage.getInstance();
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean checkShareIconPresentOnEachStoryPage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        isShowing = commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(latest, 10, "Latest");
        commonFunctions.isElementDisplayed(latestLandingPage, 10, "Latest Landing Page");
        isShowing &= commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(trending, 10, "Trending");
        commonFunctions.isElementDisplayed(trendingLandingPage, 10, "Trending Landing Page");
        isShowing &= commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(premium, 10, "Premium");
        commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium Landing Page");
        isShowing &= commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(news, 10, "News");
        isShowing &= commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(backInEditProfile, 10, "Back");
        commonFunctions.clickElement(marketsArrowBtn, 10, "Markets Arrow Button");
        commonFunctions.clickElement(stockMarkets, 10, "Stock Markets");
        isShowing &= commonFunctions.isElementDisplayed(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0, 47, "explore close icon");
        return isShowing;
    }

    @Override
    public boolean notification(String apiURL, String faviconURL) {
        return false;
    }

    @Override
    public boolean marketTicker(String[] params) {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        isShowing = commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        commonFunctions.clickElement(marketTickerBseSenSex, 10, "market Ticker Bse SenSex");
        isShowing &= commonFunctions.isElementDisplayed(marketSensexLanding, 10, "Bse Sensex Landing page");
        commonFunctions.clickElement(backButton, 10, "back to home page");
        commonFunctions.clickElement(marketTickerNifty50, 10, "market Ticker Nifty50");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerNifty50LandingPage, 10, "Nifty50 Landing Page");
        commonFunctions.clickElement(backButton, 10, "back to home page");
        commonFunctions.swipeElementUsingTouchAction(310, 210, 110, 210);
        commonFunctions.dummyWait(5);
        if (!commonFunctions.isElementDisplayedAndPresent(marketTickerNiftyBank, 20, "market Ticker Nifty Bank"))
            commonFunctions.swipeElementUsingTouchAction(310, 277, 110, 270);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(marketTickerNiftyBank, 20, "market Ticker Nifty Bank");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerNiftyBankLandingPage, 10, "NiftyBank Landing Page");
        commonFunctions.clickElement(backButton, 10, "back to home page");
        return isShowing;
    }

    @Override
    public boolean storyPage() {
        boolean storyPageStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(firstStory, 10, "Story");
        boolean checkStoryOpensStatus = checkStoryOpens();
        if (storyImageAfterTheTitle.size() > 0) {
            Utils.logStepInfo(true, "Story image after the title is displayed");
        } else {
            Utils.logStepInfo(false, "Story image after the title is not displayed");
        }
        boolean checkCloseIconIsStickyStatus = checkCloseIconIsSticky();
        commonFunctions.clickElement(closeStory, 10, "Close Story");
        boolean checkImageCaptionStatus = commonFunctions.isElementNotDisplayed(imageCaption, 10, "Image caption");
        if (storyImageList.size() > 0) {
            Utils.logStepInfo(true, "Story image is displayed");
        } else {
            Utils.logStepInfo(false, "Story image is not displayed");
        }
        if (checkStoryOpensStatus && checkCloseIconIsStickyStatus && checkImageCaptionStatus) {
            storyPageStatus = true;
        } else {
            storyPageStatus = false;
        }
        return storyPageStatus;
    }

    public boolean checkStoryOpens() {
        boolean checkStoryOpensStatus;
        commonFunctions.tapElementWithCoOrdinates(100, 400, "Story image");
        checkStoryOpensStatus = commonFunctions.isElementDisplayed(imageCaption, 10, "Image caption");
        return checkStoryOpensStatus;
    }

    @Override
    public boolean apiForFirstStory(String[] params) {
        boolean apiForFirstStoryStatus;
        String apiURL = params[0];
        String storyText = params[3];
        String storyId = params[4];
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(searchButton, 10, "Search button");
        commonFunctions.clickElement(searchTextField, 10, "Search Text field");
        commonFunctions.sendKey(searchTextField, storyText, 10, "Search Text field");
        commonFunctions.clickElement(searchButton, 10, "Search button");
        commonFunctions.isElementDisplayed(imageCaption, 15, "image caption");// added for dummy wait
        commonFunctions.tapElementWithCoOrdinates(150, 210, "First story in search results");
        commonFunctions.isElementDisplayed(imageCaption, 10, "image caption");
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        System.out.println(response.asString());
        boolean checkCaptionInAPIStatus = checkCaptionInAPI(response);
        boolean checkTimeToReadInAPIStatus = checkTimeToReadInAPI(response);
        boolean checkStoryAuthorStatus = checkStoryAuthor(response);
        boolean checkSummaryInAPIStatus = checkSummaryInAPI(response);
        if (checkCaptionInAPIStatus && checkTimeToReadInAPIStatus && checkStoryAuthorStatus && checkSummaryInAPIStatus) {
            apiForFirstStoryStatus = true;
        } else {
            apiForFirstStoryStatus = false;
        }
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0, 47, "explore close icon");
        return apiForFirstStoryStatus;
    }

    public boolean checkStoryAuthor(Response response) {
        boolean checkStoryAuthorStatus;
        String expectedStoryAuthorFromAPI = RestUtils.getValueFromResponse(response, "content[0].metadata.authors[0]");
        String actualStoryAuthorFromUI = commonFunctions.getProperty(storyAuthor, "value");
        checkStoryAuthorStatus = commonFunctions.checkTextContains(expectedStoryAuthorFromAPI, actualStoryAuthorFromUI, "Story author in API");
        return checkStoryAuthorStatus;
    }

    public boolean checkTimeToReadInAPI(Response response) {
        boolean checkTimeToReadInAPIStatus;
        String expectedTimeToReadFromAPI = RestUtils.getValueFromResponse(response, "content[0].timeToRead");
        String actualTimeToReadFromUI = commonFunctions.getProperty(timestamp, "value");
        checkTimeToReadInAPIStatus = commonFunctions.checkTextContains(expectedTimeToReadFromAPI, actualTimeToReadFromUI, "TimeToRead in API");
        return checkTimeToReadInAPIStatus;
    }

    public boolean checkCaptionInAPI(Response response) {
        boolean checkCaptionInAPIStatus;
        String expectedCaptionFromAPI = RestUtils.getValueFromResponse(response, "content[0].leadMedia.image.caption");
        expectedCaptionFromAPI = Utils.formatAPIText(expectedCaptionFromAPI);
        String actualCaptionFromUI = commonFunctions.getProperty(imageCaption, "value");
        checkCaptionInAPIStatus = commonFunctions.checkTextContains(expectedCaptionFromAPI, actualCaptionFromUI, "Caption in API");
        return checkCaptionInAPIStatus;
    }

    public boolean checkSummaryInAPI(Response response) {
        boolean checkSummaryInAPIStatus;
        String expectedSummaryFromAPI = RestUtils.getValueFromResponse(response, "content[0].summary");
        expectedSummaryFromAPI = Utils.formatAPIText(expectedSummaryFromAPI);
        String actualSummaryFromUI = commonFunctions.getProperty(summary, "value");
        actualSummaryFromUI = actualSummaryFromUI.replaceAll("\n", "");
        checkSummaryInAPIStatus = commonFunctions.checkTextContains(expectedSummaryFromAPI, actualSummaryFromUI, "Summary in API");
        return checkSummaryInAPIStatus;
    }

    @Override
    public boolean shareStory() {
        boolean shareStoryStatus;
        commonFunctions.swipeElementUsingTouchAction(100, 100, 100, 100);
        boolean isShareIconDisplayed = commonFunctions.isElementDisplayed(shareIcon, 10, "Share Icon");
        boolean isShareIconClickable = commonFunctions.isElementClickable(shareIcon, 10, "Share Icon");
        expectedPlainText = commonFunctions.getProperty(headline, "value");
        expectedPlainText = Utils.formatAPIText(expectedPlainText);
        boolean checkOverlayPlainTextWithHeadlineStatus = checkOverlayPlainTextWithHeadline();
        boolean checkSharingIconsVisibleAsPerAvailableStatus = checkSharingIconsVisibleAsPerAvailable();
        commonFunctions.clickElement(closeStory, 10, "Close icon");
        if (isShareIconDisplayed && isShareIconClickable && checkOverlayPlainTextWithHeadlineStatus && checkSharingIconsVisibleAsPerAvailableStatus) {
            shareStoryStatus = true;
        } else {
            shareStoryStatus = false;
        }
        return shareStoryStatus;
    }

    public boolean checkCloseIconIsSticky() {
        boolean checkCloseIconIsStickyStatus;
        commonFunctions.swipeElementUsingTouchAction(380, 680, 380, 100);
        checkCloseIconIsStickyStatus = commonFunctions.isElementDisplayed(closeStory, 10, "Close icon");
        return checkCloseIconIsStickyStatus;
    }

    @Override
    public boolean bookmarkStory() {
        boolean bookmarkStatus;
        commonFunctions.isElementDisplayed(bookmarkIcon, 10, "Bookmark Icon");
        bookmarkStatus = commonFunctions.isElementClickable(bookmarkIcon, 10, "BookMark Icon");
        return bookmarkStatus;
    }

    @Override
    public boolean bookmarkStoryLoggedInUser() {
        boolean isShowing;
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(firstStory, 10, "First story headline");
        commonFunctions.checkElementVisibilityByScrolling(bookmarkIcon, "bookmark icon on story detail page");
        commonFunctions.clickElement(bookmarkIcon, 10, "Bookmark Icon");
        isShowing = checkBookMarkIconIsActive();
        String bookmarkStoryId = commonFunctions.getProperty(bookmarkIcon, "id");
        System.out.println("bookmarkStoryId: " + bookmarkStoryId);
        bookmarkStoryId = bookmarkStoryId.split("_")[1];
        navigateToMyReadsPage();
        commonFunctions.isElementDisplayedAndPresent(bookmarksSwiperBox, 10, "BookMark Swiper Box");
        isShowing &= checkBookmarkedStoryIdInBookmarkSwiperBox(bookmarkStoryId, true);
        String bookmarkStoryIdXpath = "//h2//a[contains(@href,'" + bookmarkStoryId + "')]";
        MobileElement bookMarkIconInSwiperBox = (MobileElement) globalVars.getWebDriver().findElement(By.xpath(bookmarkStoryIdXpath));
        commonFunctions.clickElementWithJS(bookMarkIconInSwiperBox, 10, "BookMark Icon in BookMark Swiper Box");
        isShowing &= checkBookmarkedStoryIdInBookmarkSwiperBox(bookmarkStoryId, false);
        return isShowing;
    }


    public void navigateToMyReadsPage() {
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(myReadsMenu, 10, "MyReads Menu");
    }

    public boolean checkBookMarkIconIsActive() {
        boolean checkBookMarkIconIsActiveStatus = false;
        try {
            boolean isSelected = bookmarkIcon.isSelected();
            if (!isSelected) {
                commonFunctions.clickElement(bookmarkIcon, 10, "BookMark Icon");
                commonFunctions.dummyWait(2);
                isSelected = bookmarkIcon.isSelected();
            }
            if (isSelected) {
                System.out.println("Bookmark Icon is selected");
                Utils.logStepInfo(true, "Bookmark Icon is selected");
                checkBookMarkIconIsActiveStatus = true;
            } else {
                System.out.println("Bookmark Icon is not selected");
                Utils.logStepInfo(false, "Bookmark Icon is not selected");
            }
        } catch (Exception e) {

        }
        return checkBookMarkIconIsActiveStatus;
    }

    public boolean checkBookmarkedStoryIdInBookmarkSwiperBox(String bookmarkStoryId, boolean isAvailable) {
        boolean checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus;
        ArrayList<String> bookmarkStoryIdList = new ArrayList<String>();
        for (MobileElement e : bookmarksSwiperBoxElementsList) {
            String href = e.getAttribute("href");
            int index = href.lastIndexOf("-");
            String storyId = href.substring(index + 1, index + 15);
            bookmarkStoryIdList.add(storyId);
        }
        if (isAvailable) {
            if (bookmarkStoryIdList.contains(bookmarkStoryId)) {
                Utils.logStepInfo(true, "BookMarked Story Id is available in Bookmark swiper box");
                checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus = true;
            } else {
                Utils.logStepInfo(false, "BookMarked Story Id is Not available in Bookmark swiper box");
                checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus = false;
            }
        } else {
            if (!bookmarkStoryIdList.contains(bookmarkStoryId)) {
                Utils.logStepInfo(true, "BookMarked Story Id is Not available in Bookmark swiper box. This is expected");
                checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus = true;
            } else {
                Utils.logStepInfo(false, "BookMarked Story Id is available in Bookmark swiper box. This is not expected. Bookmark should be removed from the Bookmark swiper box");
                checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus = false;
            }
        }
        return checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus;
    }

    @Override
    public boolean pageTitle() {
        return false;
    }

    @Override
    public boolean nonSubscribedUserPaywall(String apiURL) {
        return false;
    }

    @Override
    public boolean pageContent(String apiURL) {
        boolean pageContentStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(home, 10, "Home");
        boolean checkHomeLandingPageStatus = commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        //Added dummy steps for Workaround to load all the story elements
        commonFunctions.clickElement(premium);
        commonFunctions.isElementDisplayed(premiumLandingPage, 10, "First Story");

        boolean checkLatestLandingPageStatus = checkLandingPage(latest, latestLandingPage, "LATEST", 10, "Latest");
        if (!checkLatestLandingPageStatus) {
            Assert.fail("Latest Landing Page is not displayed");
        }
        boolean checkTrendingLandingPageStatus = checkLandingPage(trending, trendingLandingPage, "TRENDING", 10, "Trending");
        if (!checkTrendingLandingPageStatus) {
            Assert.fail("Trending Landing Page is not displayed");
        }
        //Premium landing page is commented as it takes long time to load and causing to the script fail
//        boolean checkPremiumLandingPageStatus = checkLandingPage(premium,premiumLandingPage,"PREMIUM",10,"Premium");
//        if (!checkPremiumLandingPageStatus) {
//            commonFunctions.clickElement(latest);
//            commonFunctions.isElementDisplayed(latestLandingPage, 10, "dummy move for Latest landing");
//            checkPremiumLandingPageStatus = checkLandingPage(premium,premiumLandingPage,"PREMIUM",10,"Premium");
//            if (!checkPremiumLandingPageStatus) {
//                Assert.fail("Premium Landing Page is not displayed");
//            }
//        }
        if (checkHomeLandingPageStatus && checkLatestLandingPageStatus && checkTrendingLandingPageStatus) {
            pageContentStatus = true;
        } else {
            pageContentStatus = false;
        }
        return pageContentStatus;
    }

    public boolean checkLandingPage(MobileElement element, MobileElement landingElement, String landingPageName, int timeOut, String elementName) {
        boolean checkLandingPageStatus;
        boolean storiesStatus;
        commonFunctions.isElementDisplayed(element, timeOut, elementName);
        commonFunctions.clickElement(element, timeOut, elementName);
        commonFunctions.isElementDisplayed(landingElement, timeOut, elementName + "Landing page");
        String actualLandingPageName = commonFunctions.getElementText(landingElement, timeOut);
        if (actualLandingPageName.equals(landingPageName)) {
            checkLandingPageStatus = true;
            Utils.logStepInfo(true, landingPageName + " Page displayed successfully");
        } else {
            checkLandingPageStatus = false;
            Utils.logStepInfo(false, landingPageName + " Page is not displayed");
        }
        commonFunctions.dummyWait(5);
        commonFunctions.waitForPageLoading(10);
        if (shareIconsList.size() > 4 || bookmarkIconList.size() > 0 || ListOfStory.size() > 4) {
            Utils.logStepInfo(true, "Share icons list is present in the page: " + elementName);
            storiesStatus = true;
        } else {
            Utils.logStepInfo(false, "Share icons list is not present in the page: " + elementName);
            storiesStatus = false;
        }
        if (checkLandingPageStatus && storiesStatus) {
            checkLandingPageStatus = true;
        } else {
            checkLandingPageStatus = false;
        }
        return checkLandingPageStatus;
    }

    @Override
    public boolean shareStoryFunctionality() {
        boolean isShowing;
        isShowing = checkShareIconPresentOnEachStoryPage();
        isShowing &= checkShareIconIsClickable();
        isShowing &= checkOverlayPlainTextWithHeadline();
        isShowing &= checkSharingIconsVisibleAsPerAvailable();
        isShowing &= checkStoryLinkInTextAreaInSharingApp();
        return isShowing;
    }

    public boolean checkShareIconIsClickable() {
        boolean checkShareIconIsClickableStatus = true;
        commonFunctions.clickElement(home, 10, "Home");
        checkShareIconIsClickableStatus = commonFunctions.isElementClickable(shareIconUnderStory, 10, "Share Icon");
        expectedPlainText = commonFunctions.getProperty(firstStory, "value");
        expectedPlainText = Utils.formatAPIText(expectedPlainText);
        return checkShareIconIsClickableStatus;
    }


    public boolean checkOverlayPlainTextWithHeadline() {
        boolean checkOverlayPlainTextWithHeadlineStatus = false;
        commonFunctions.clickElement(shareIconUnderStory, 10, "Share Icon");
        commonFunctions.isElementDisplayed(messagesIcon, 10, "Messages Icon");
        String actualPlainText = commonFunctions.getElementText(plainText);
        if (actualPlainText.contains(expectedPlainText)) {
            Utils.logStepInfo(true, "Plain text is displayed with Story headline");
            checkOverlayPlainTextWithHeadlineStatus = true;
        } else {
            Utils.logStepInfo(false, "Plain text is not displayed with Story headline. Expected:" + expectedPlainText + ", Actual:" + actualPlainText);
        }
        return checkOverlayPlainTextWithHeadlineStatus;
    }

    public boolean checkSharingIconsVisibleAsPerAvailable() {
        boolean checkSharingIconsVisibleAsPerAvailableStatus;
        boolean messageIconStatus = commonFunctions.isElementDisplayed(messagesIcon, 10, "Messages Icon");
        boolean airdropIconStatus = commonFunctions.isElementDisplayed(airDropIcon, 10, "Airdrop Icon");
        if (messageIconStatus && airdropIconStatus) {
            checkSharingIconsVisibleAsPerAvailableStatus = true;
        } else {
            checkSharingIconsVisibleAsPerAvailableStatus = false;
        }
        return checkSharingIconsVisibleAsPerAvailableStatus;
    }

    public boolean checkStoryLinkInTextAreaInSharingApp() {
        boolean checkStoryLinkInTextAreaInSharingAppStatus = false;
        String expectedStoryLinkText = commonFunctions.getElementText(plainText);
        commonFunctions.clickElement(messagesIcon, 10, "Message Icon");
        commonFunctions.isElementDisplayed(messageBody, 10, "Messages Body");
        String actualStoryLinkText = commonFunctions.getElementText(messageBody);
        int index = actualStoryLinkText.indexOf("https://");
        actualStoryLinkText = actualStoryLinkText.substring(index, actualStoryLinkText.length());
        if (expectedStoryLinkText.contains(actualStoryLinkText)) {
            Utils.logStepInfo(true, "Story Link is displayed in the respected text area");
            checkStoryLinkInTextAreaInSharingAppStatus = true;
        } else {
            Utils.logStepInfo(false, "Story Link is NOT displayed in the respected text area. Expected:" + expectedStoryLinkText + ", Actual:" + actualStoryLinkText);
        }
        commonFunctions.clickElement(cancelButton, 10, "Cancel button in Message area");
        commonFunctions.clickElement(closeButtonInShareOverlay, 10, "close Button InShare Overlay");
        commonFunctions.clickElement(home, 10, "Home");
        return checkStoryLinkInTextAreaInSharingAppStatus;
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
        commonFunctions.clickElement(premium, 10, "Premium");
        isShowing = commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium Landing page");
        commonFunctions.waitForPageLoading(10);
        commonFunctions.tapElementWithCoOrdinates(150, 180, "First story in the premium"); //Tap on the fist story in the premium
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(premiumLabelList.get(1), 10, "Premium Landing page");
        commonFunctions.swipeElementUsingTouchAction(380, 680, 380, 100);
        isShowing &= commonFunctions.isElementNotDisplayed(continueReadingSubscribeNow, 10, "Continue Reading subscribe now");
        commonFunctions.clickElement(home, 10, "Home");
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
    public boolean myAccountFunctionality(String password, String newPassword, String expectedUserName, String newName, String email, String manageProfileURL) {
        boolean myAccountFunctionalityStatus;
        commonFunctions.isElementDisplayed(myAccountWithArrow, 10, "My Account");
        commonFunctions.clickElement(myAccountWithArrow, 10, "My Account");
        commonFunctions.checkTextEquals(expectedUserName, commonFunctions.getElementText(userNameMyAccount), "Check UserName");
        commonFunctions.checkTextEquals(email, commonFunctions.getElementText(userEmailMyAccount), "Check Email");
        commonFunctions.isElementDisplayed(editProfile, 10, "Edit Option");
        commonFunctions.clickElement(editProfile, 10, "Edit option");
        commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        commonFunctions.isElementDisplayed(nameEditProfile, 10, "Name");
        commonFunctions.isElementDisplayed(emailEditProfile, 10, "Email");
        commonFunctions.isElementDisplayed(addYourContactNo, 10, "Add your contact number");
        commonFunctions.isElementDisplayed(genderEditProfile, 10, "Gender");
        boolean checkNameChangeStatus = checkNameChange(newName, expectedUserName);
        boolean checkPasswordChangeStatus = checkPasswordChange(newPassword, password);
        boolean checkGenderChangeStatus = checkGenderChange();
        commonFunctions.clickElement(back, 10, "Back");
        commonFunctions.checkTextEquals(expectedUserName, commonFunctions.getElementText(userNameMyAccount), "Check UserName");
        commonFunctions.clickElement(privacyPolicy, 10, "Privacy Policy");
        boolean privacyPolicyLandingPageStatus = commonFunctions.isElementDisplayed(privacyPolicyLandingPage, 10, "Privacy Policy Landing page");
        commonFunctions.clickElement(backInEditProfile, 10, "Back in edit profile");
        commonFunctions.clickElement(termsOfUse, 10, "Term Of Use");
        boolean termsOfUseLandingPageStatus = commonFunctions.isElementDisplayed(termsOfUseLandingPage, 10, "Term Of Use Landing page");
        commonFunctions.clickElement(backInEditProfile, 10, "Back in edit profile");
        commonFunctions.clickElement(cookiePolicy, 10, "Cookie Policy");
        boolean cookiePolicyLandingPageStatus = commonFunctions.isElementDisplayed(cookiePolicyLandingPage, 10, "Cookie Policy Landing page");
        commonFunctions.clickElement(backInEditProfile, 10, "Back in edit profile");
        commonFunctions.clickElement(subscriberAgreement, 10, "Subscriber Agreement");
        boolean subscriberAgreementLandingPageStatus = commonFunctions.isElementDisplayed(subscriberAgreementLandingPage, 10, "Subscriber Agreement Landing page");
        commonFunctions.clickElement(backInEditProfile, 10, "Back in edit profile");
        commonFunctions.clickElement(closeIconInProfile, 10, "closeIcon in edit profile");
        if (checkNameChangeStatus && checkPasswordChangeStatus && checkGenderChangeStatus && privacyPolicyLandingPageStatus && termsOfUseLandingPageStatus && cookiePolicyLandingPageStatus && subscriberAgreementLandingPageStatus) {
            myAccountFunctionalityStatus = true;
        } else {
            myAccountFunctionalityStatus = false;
        }

        return myAccountFunctionalityStatus;
    }

    public boolean checkNameChange(String newName, String oldName) {
        boolean checkChangeNameStatus;
        commonFunctions.clickElement(editNameBtn, 10, "Name");
        name.clear();
        commonFunctions.sendKey(name, newName, 10);
        globalVars.getAppiumDriver().getKeyboard().sendKeys(Keys.ENTER);
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        checkChangeNameStatus = commonFunctions.checkTextEquals(newName, commonFunctions.getElementText(userNameMyAccount), "Check UserName");
        commonFunctions.clickElement(editNameBtn, 10, "Name");
        commonFunctions.clickElement(name, 10, "Name Field");
        name.clear();
        commonFunctions.sendKey(name, oldName, 10);
        commonFunctions.sendKeyStroke(Keys.ENTER);
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        return checkChangeNameStatus;
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
        commonFunctions.clickElement(editPasswordBtn, 10, "Password");
        commonFunctions.clickElement(editPasswordField, 10, "oldPassword ");
        commonFunctions.dummyWait(2);
        commonFunctions.sendKey(editPasswordField, oldPassword, 10);
        commonFunctions.clickElement(enterNewPass, 10, "new Password ");
        commonFunctions.dummyWait(2);
        commonFunctions.sendKey(enterNewPass, newPassword, 10);
        commonFunctions.clickElement(enterConfirmPass, 10, "confirm Password ");
        commonFunctions.sendKey(enterConfirmPass, newPassword, 10);
        commonFunctions.dummyWait(2);
        commonFunctions.sendKeyStroke(Keys.ENTER);
        changePasswordStatus = commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        return changePasswordStatus;
    }

    public boolean checkGenderChange() {
        boolean checkGenderChangeStatus;
        commonFunctions.clickElement(editGenderBtn, 10, "Edit Gender");
        commonFunctions.clickElement(femaleGenderRadioButton, 10, "FeMale Gender Radio button");
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        checkGenderChangeStatus = commonFunctions.isElementDisplayed(female, 10, "FeMale Text");
        commonFunctions.clickElement(editGenderBtn, 10, "Edit Gender");
        commonFunctions.clickElement(maleGenderRadioButton, 10, "Male Gender Radio button");
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        commonFunctions.isElementDisplayed(male, 10, "Male Text");
        return checkGenderChangeStatus;
    }

    @Override
    public boolean checkMintEPaperBanner() {

        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUntilElementFound(try_Mint_Epaper);
        //commonFunctions.scrollToBottomOniOSNative();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(try_Mint_Epaper, 10, "Try Mint EPaper");
        commonFunctions.dummyWait(5);
        String bannerText = commonFunctions.getElementText(subscribeToContinueReadingBanner, 10);
        commonFunctions.dummyWait(4);
        commonFunctions.clickElement(try_Mint_Epaper_Close_Button, 15, "Close Mint Epaper banner");
        commonFunctions.dummyWait(4);
        return bannerText.equals("Subscribe to Continue  Reading");
    }

    @Override
    public boolean checkHomePageSrollsTillEnd() {
        boolean endOfPage = false;
        commonFunctions.clickElement(home, 10, "Home");
        String previousPageSource = driver.getPageSource();
        while (!endOfPage) {
            for (int i = 0; i <= 1; i++) {
                commonFunctions.scrollToBottomOniOSNative();
            }
            endOfPage = previousPageSource.equals(driver.getPageSource());
            previousPageSource = driver.getPageSource();
        }
        commonFunctions.scrollUpUntilElementFound(try_Mint_Epaper);
        return endOfPage;
    }

    @Override
    public boolean checkEPaperSubscribedUser() {
        boolean checkEPaperSubscribedUserStaus = false;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.clickElement(ePaperSubscribed, 10, "ePaper");
        commonFunctions.dummyWait(5);
        commonFunctions.changeContextToWeb();
        checkEPaperSubscribedUserStaus = commonFunctions.checkPageURL("epaper.livemint.com", 10, "E paper Page");
        return checkEPaperSubscribedUserStaus;
    }

    @Override
    public boolean checkEPaperNonSubscribedUser() {
        boolean checkEPaperNonSubscribedUserStaus = false;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(ePaper, 10, "ePaper");
        commonFunctions.clickElement(ePaper, 10, "ePaper");
        commonFunctions.dummyWait(5);
        checkEPaperNonSubscribedUserStaus = commonFunctions.isElementDisplayed(subscribeToContinueReadingBanner, 10, "Subscribe banner");
        commonFunctions.clickElement(closeEPaperPopUp, 10, "close ePaper Wall");
        return checkEPaperNonSubscribedUserStaus;
    }

    @Override
    public boolean checkMintLogo() {
        boolean checkMintLogoStatus;
      /*  commonFunctions.clickElement(home,10,"Home");
        commonFunctions.dummyWait(5);*/
        checkMintLogoStatus = commonFunctions.isElementEnabled(mintLogo, "Mint Logo");
        return checkMintLogoStatus;
    }

    @Override
    public boolean checkMintLogoLocation() {
        return false;
    }

    @Override
    public boolean checkBottomNavigation() {
        boolean checkBottomNavigationStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        boolean homeShortcutStatus = commonFunctions.isElementDisplayed(home, 10, "home");
        boolean latestShortcutStatus = commonFunctions.isElementDisplayed(forYouTab, 10, "forYou");
        boolean trendingShortcutStatus = commonFunctions.isElementDisplayed(marketTab, 10, "market");
        boolean premiumShortcutStatus = commonFunctions.isElementDisplayed(premium, 10, "premium");
        if (homeShortcutStatus && latestShortcutStatus && trendingShortcutStatus && premiumShortcutStatus) {
            checkBottomNavigationStatus = true;
        } else {
            checkBottomNavigationStatus = false;
        }
        return checkBottomNavigationStatus;
    }

    @Override
    public boolean checkBottomNavigationAllPages() {
        boolean checkBottomNavigationStatus;
        boolean checkBottomNavigationFromLatestStatus = checkBottomNavigationFromAllPages(forYouTab, "forYou Page");
        boolean checkBottomNavigationFromTrendingStatus = checkBottomNavigationFromAllPages(marketTab, "marketTicker page");
        if (checkBottomNavigationFromLatestStatus && checkBottomNavigationFromTrendingStatus) {
            checkBottomNavigationStatus = true;
        } else {
            checkBottomNavigationStatus = false;
        }
        return checkBottomNavigationStatus;
    }

    public boolean checkBottomNavigationFromAllPages(MobileElement element, String elementName) {
        boolean checkBottomNavigationAllPagesStatus;
        commonFunctions.clickElement(element, 10, elementName);
        commonFunctions.dummyWait(5);
        boolean homeShortcutStatus = commonFunctions.isElementDisplayed(home, 10, "home page");
        boolean latestShortcutStatus = commonFunctions.isElementDisplayed(forYouTab, 10, "forYou page");
        boolean trendingShortcutStatus = commonFunctions.isElementDisplayed(marketTab, 10, "market page");
        boolean premiumShortcutStatus = commonFunctions.isElementDisplayed(premium, 10, "premium page");
        if (homeShortcutStatus && latestShortcutStatus && trendingShortcutStatus && premiumShortcutStatus) {
            checkBottomNavigationAllPagesStatus = true;
        } else {
            checkBottomNavigationAllPagesStatus = false;
        }
        return checkBottomNavigationAllPagesStatus;
    }

    public boolean checkBottomNavigationFocusAllPages(MobileElement element, MobileElement elementLanding, String elementName) {
        commonFunctions.clickElement(element, 10, elementName);
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(elementLanding, 10, elementName);
    }

    @Override
    public boolean checkBottomNavigationFocus() {
        boolean isShowing = false;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        if (globalVars.isProdRun()) {
            isShowing = checkBottomNavigationFocusAllPages(home, firstStory, "home");
        }
        if (globalVars.isStgRun()) {
            isShowing &= checkBottomNavigationFocusAllPages(home, homePageMintPremium, "Home page");
        }
        isShowing &= checkBottomNavigationFocusAllPages(forYouTab, forYouPage, "forYou page");
        isShowing &= checkBottomNavigationFocusAllPages(marketTab, marketTickerPage, "market page");
        isShowing &= checkBottomNavigationFocusAllPages(premium, premiumLandingPage, "premium");
        return isShowing;
    }

    @Override
    public boolean clickAndVerifyMintLoungeStory() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayedAndPresent(mintLoungeCarousel, 10, "Mint Lounge Carousel");
        commonFunctions.scrollUntilElementFound(mintLoungeCarousel);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(firstStoryOnMintLoungeCarousel, 10, "First Story on Mint lounge carousel");
        commonFunctions.dummyWait(5);
        String bannerText = commonFunctions.getElementText(firstStoryHeadingOnStoryDetailPage, 10);
        return bannerText.equals("Story heading Text");
    }

    @Override
    public boolean checkMintGenieBanner() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayedAndPresent(mint_Genie_Epaper, 10, "Mint Lounge Carousel");
        commonFunctions.scrollUntilElementFound(mint_Genie_Epaper);
        //commonFunctions.scrollToBottomOniOSNative();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(mint_Genie_Epaper, 10, "Mint Genie EPaper");
        commonFunctions.dummyWait(5);
        //Need to switch to WebView
        String bannerText = commonFunctions.getElementText(subscribeToContinueReadingBanner, 10);
        return bannerText.equals("Subscribe to Continue  Reading");
    }

    @Override
    public boolean checkViewAllButtonOnMintPremium() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToBottomOniOSNative();
        commonFunctions.clickElement(viewAllMintPremiumCarousel, 10, "View ALl button On Mint premium");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(premiumHeaderText, 10, "latest page");
    }

    @Override
    public boolean checkAndVerifyViewAllOnMintPremiumCarousel() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayedAndPresent(mintPremiumCarousel, 10, "Mint Premium Carousel");
        commonFunctions.scrollDownToElement(mintPremiumCarousel, "Scroll to Mint Premium");
        commonFunctions.clickElement(viewAllMintPremiumCarousel, 10, "View ALl button On Mint premium");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(premiumHeaderText, 10, "Premium page");
    }

    @Override
    public boolean checkAndVerifyViewAllOnWSJCarousel() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayedAndPresent(wSJCarousel, 10, "WSJ Carousel");
        commonFunctions.scrollDownToElement(wSJCarousel, "Scroll to WSJ Carousel");
        commonFunctions.clickElement(viewAllWSJCarousel, 10, "View ALl button On Mint premium");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(premiumHeaderText, 10, "Premium page");
    }

    @Override
    public boolean checkAndVerifyStoryOnWSJCarousel() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayedAndPresent(wSJCarousel, 10, "WSJ Carousel");
        commonFunctions.scrollDownToElement(wSJCarousel, "Scroll to WSJ Carousel");
        commonFunctions.clickElement(firstStoryOnWSJPremium, 10, "View ALl button On Mint premium");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(firstStoryInWSJLandingPage, 10, "Premium page");
    }

    @Override
    public boolean checkAndVerifyViewAllOnMintLoungeCarousel() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayedAndPresent(mintLoungeCarousel, 10, "WSJ Carousel");
        commonFunctions.scrollDownToElement(mintLoungeCarousel, "Scroll to Mint Lounge Carousel");
        commonFunctions.clickElement(viewAllMintLoungeCarousel, 10, "View ALl button On Mint premium");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(premiumHeaderText, 10, "Premium page");
    }

    @Override
    public boolean checkSignInLink() {
        return false;
    }

    @Override
    public boolean checkSubscribeLink() {
        return false;
    }

    @Override
    public boolean checkSubscribeRedirection(String choosePlan) {
        return false;
    }

    @Override
    public boolean checkSignInLinkRedirection(String loginRegisterText, String google, String facebook, String apple, String emailOrMobile) {
        return false;
    }

    @Override
    public boolean checkStoryNavigationWSJCrousel(String text) {
        return false;
    }

    @Override
    public boolean checkBottomNavigationSection() {
        return false;
    }

    @Override
    public boolean checkMyAccountLink() {
        return false;
    }

    @Override
    public void clickOnHomeButtonWithHandlingDarkMode() {
    }

    @Override
    public boolean subscribedUserAdsFreeHomepage() {
        return false;
    }

    @Override
    public boolean checkHomePage() {
        commonFunctions.clickElement(home, 10, "home button");
        return checkMintLogo();
    }

    @Override
    public boolean subscribedUserAdsFreeApp() {
        commonFunctions.isElementNotDisplayed(subscribeButton, 10, "subscribed button");
        return subscriptionPage.checkSubscribedUserIsAdFree();
    }

    @Override
    public boolean sponsoredStory() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToBottomOniOSNative();
        commonFunctions.scrollDownToElement(sponsoredStory);
        isShowing = commonFunctions.isElementDisplayed(sponsoredStory, 10, "first sponsored story");
        commonFunctions.clickElement(firstSponsoredStory, 10, "sponsored story");
        return isShowing;
    }

    @Override
    public boolean checkBookmarkBeforeLogin() {
        return false;
    }

    @Override
    public boolean checkBrandedContent() {
        return checkVisibilityOfSponsoredStoryOnHomePage();
    }

    @Override
    public boolean checkTopGainersViewAll() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        commonFunctions.clickElement(viewAllMarketPage, 10, "view all");
        commonFunctions.isElementDisplayed(indianIndicesPage, 10, "indian Indices Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnIndianIndicesPage, 10, "list Of Element On Indian Indices Page");
        return isShowing;
    }

    @Override
    public boolean checkGainerLosersDesign(String gainerLoserText) {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.isElementDisplayed(gainersLoserUpdateStatus, 10, "update status Gainer & Losers");
        isShowing &= commonFunctions.isElementDisplayed(gainersLoserBseTab, 10, "Bse Tab");
        isShowing &= commonFunctions.isElementDisplayed(gainersLoserNseTab, 10, "Nse Tab");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.swipeElementUsingTouchAction(360, 318, 50, 277);
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnGainerLoserSection, 30, "list Of company On top Losers and Top Gainers Page");
        return isShowing;
    }

    @Override
    public boolean checkBseTabsGainerLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.clickElement(gainersLoserBseTab, 10, "Bse tab");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnGainerLoserSection, 30, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkNseTabsGainerLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.clickElement(gainersLoserNseTab, 10, "Nse tab");
        commonFunctions.swipeElementUsingTouchAction(360, 318, 50, 277);
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnGainerLoserSection, 30, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkTopLosersViewAllFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.swipeElementUsingTouchAction(360, 318, 50, 277);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topLoserViewAll, "top losers view all");
        commonFunctions.clickElement(topLoserViewAll, 10, "Top Losers View All");
        isShowing &= commonFunctions.isElementDisplayed(topLoserDetailPage, 10, "top Losers Detail Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnTopLosersPage, 10, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkTopGainersViewAllFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.clickElement(topGainerViewAll, 10, "top gainers View All");
        commonFunctions.isElementDisplayed(topGainerDetailPage, 10, "top Gainer Detail Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnTopGainersPage, 10, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesList() {
        boolean isShowing;
        isShowing = checkTickerStockMarketNiftyAndSenSex();
        isShowing &= commonFunctions.isElementDisplayed(firstIndianIndices, 10, "first indian indices");
        isShowing &= commonFunctions.isElementDisplayed(secondIndianIndices, 10, "second indian indices");
        isShowing &= commonFunctions.isElementDisplayed(thirdIndianIndices, 10, "third indian indices");
        isShowing &= commonFunctions.isElementDisplayed(fourthIndianIndices, 10, "fourth indian indices");
        commonFunctions.clickElement(viewAllMarketPage, 10, "viewAll indian indices section");
        isShowing &= commonFunctions.isElementDisplayed(indianIndicesPage, 10, "indian Indices Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnIndianIndicesPage, 10, "list Of company On top Losers and Top Gainers Page");
        return isShowing;
    }

    public boolean clickOnMarketTabAndVerifyMarketPage() {
        commonFunctions.clickElement(marketTab, 10, "market tab");
        return commonFunctions.isElementDisplayed(marketTickerPage, 10, "market ticker Page");
    }

    @Override
    public boolean checkIndicesSection() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(secondIndianIndices, 10, "second indian indices name");
        isShowing &= commonFunctions.isElementDisplayed(priceChangeInPercentage, 10, "price Change In Percentage");
        isShowing &= commonFunctions.isElementDisplayed(latestPrice, 10, "latest price");
        return isShowing;
    }

    @Override
    public boolean checkNseTop4GainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkBseTop4GainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkGainersAndLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(gainerAndLosers, 10, "gainer and loser");
        isShowing &= commonFunctions.isElementDisplayed(gainerAndLosersBse, 10, "gainer and loser Bse");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainer, "top gainer");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topLoser, "top gainer");
        commonFunctions.clickElement(gainerAndLosersNse, 10, "gainer and loser Nse");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainer, "top gainer");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topLoser, "top gainer");
        return isShowing;
    }

    @Override
    public boolean checkBse100NewsSection() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(firstIndianIndices, 10, "first indian indices");
        String text = commonFunctions.getElementText(firstIndianIndices, 10);
        commonFunctions.clickElement(firstIndianIndices, 10, "first indian indices");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(secondIndianIndicesPage, text, 10, "second Indian Indices");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(NewsBse100, "News S&P Bse100");
        return isShowing;
    }

    @Override
    public boolean checkIndicesRedirectionFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        String text1 = commonFunctions.getElementText(secondIndianIndices, 10);
        commonFunctions.clickElement(secondIndianIndices, 10, "second option Indian Indices");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(secondIndianIndicesPage, text1, 10, "second Indian Indices");
        isShowing &= commonFunctions.isElementDisplayed(fiveDOnIndicesPage, 10, "5D On Indices Page");
        isShowing &= commonFunctions.isElementDisplayed(oneMOnIndicesPage, 10, "1M On Indices Page");
        isShowing &= commonFunctions.isElementDisplayed(oneYOnIndicesPage, 10, "1Y On Indices Page");
        isShowing &= commonFunctions.isElementDisplayed(fiveYOnIndicesPage, 10, "5Y On Indices Page");
        return isShowing;
    }

    @Override
    public boolean checkAppRefreshFunctionality() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        commonFunctions.launchAppFromBackground(10);
        isShowing = commonFunctions.isElementDisplayed(newArticles, 10, "New Articles on Home page after relaunch the app");
        isShowing &= commonFunctions.isElementDisplayed(home, 10, "Home tab");
        isShowing &= commonFunctions.isElementDisplayed(firstStory, 10, "home page first story");
        return isShowing;
    }

    @Override
    public boolean checkNewArticlesOnlyOnHomePage() {
        boolean isShowing;
        isShowing = checkAppRefreshFunctionality();
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        isShowing &= commonFunctions.isElementDisplayed(forYouPage, 10, "for You Page");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticles, 5, "New Articles");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing = commonFunctions.isElementDisplayed(marketTickerPage, 10, "market ticker Page");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticles, 5, "New Articles");
        commonFunctions.clickElement(premium, 10, "premium tab");
        isShowing &= commonFunctions.isElementDisplayed(premiumLandingPage, 10, "premium page");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticles, 5, "New Articles");
        commonFunctions.clickElement(explore, 10, "explore tab");
        isShowing &= commonFunctions.isElementDisplayed(explore, 10, "Explore page");
        isShowing &= commonFunctions.isElementNotDisplayed(newArticles, 5, "New Articles");
        commonFunctions.clickByCoordinates(0, 47, "explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkInVisibilityOfNewArticleOnHomePageAfterClickOnNewArticle() {
        boolean isShowing;
        isShowing = checkAppRefreshFunctionality();
        commonFunctions.clickElement(newArticles, 10, "New Articles on Home page after relaunch the app");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementNotDisplayed(newArticles, 7, "New Articles on Home page after click");
        return isShowing;
    }

    @Override
    public boolean checkInVisibilityOfNewArticleAfterRefreshedHomePage() {
        boolean isShowing;
        isShowing = checkAppRefreshFunctionality();
        commonFunctions.scrollToTopOniOSNative();
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementNotDisplayed(newArticles, 7, "New Articles on Home page after click");
        return isShowing;
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryBookmarkButtonHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToBottomOniOSNative();
        commonFunctions.scrollDownToElement(sponsoredStory);
        isShowing = commonFunctions.isElementDisplayed(sponsoredStory, 10, "first sponsored story");
        isShowing &= commonFunctions.isElementNotDisplayed(firstSponsoredStoryBookmarkButton, 10, "first sponsored story Bookmark button");
        return isShowing;
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryOnHomePage() {
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToTopOniOSNative();
        return commonFunctions.isElementNotDisplayed(sponsoredStory, 10, "first sponsored story");
    }

    @Override
    public boolean checkVisibilityOfSponsoredStoryOnHomePage() {
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToTopOniOSNative();
        return commonFunctions.checkElementVisibilityByScrolling(firstSponsoredStory, "first sponsored story");
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryOn() {
        boolean isShowing;
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        isShowing = commonFunctions.isElementDisplayed(forYouPage, 10, "for You Page");
        isShowing &= commonFunctions.isElementNotDisplayed(sponsoredStory, 10, "sponsored story");
        commonFunctions.clickElement(marketTab, 10, "market ticker tab");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerPage, 10, "market ticker Page");
        isShowing &= commonFunctions.isElementNotDisplayed(sponsoredStory, 10, "sponsored story");
        return isShowing;
    }

    @Override
    public boolean checkAdvertisementLabelAndRemoveAdsButtonPosition(String advertisement, String removeAd) {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "first Story home page");
        String advLabel = firstAdsAdvertisementLabel.getLocation().toString();
        String removeAdButton = firstAdsRemoveAdButton.getLocation().toString();
        if (advLabel.equals(advertisement) || removeAdButton.equals(removeAd)) {
            isShowing &= true;
            Utils.logStepInfo(true, "Advertisement label present at top left & Remove Ads is present at top right of Ads box verification successfully !!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "Advertisement label NOT present at top left & Remove Ads NOT present at top right of Ads box verification Fail*****");
        }
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
    public boolean checkTickerStockMarketNiftyAndSenSex() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(marketTickerPageNiftyBank, 10, "market ticker Page Nifty Bank");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerPageSensex, 10, "market ticker Page SenSex");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailLineGraph() {
        return false;
    }

    @Override
    public boolean checkDetailPageOfNseAndBse() {
        return false;
    }

    @Override
    public boolean checkMarketTickerNiftyBankDetailPage() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnNiftyAndCheckDetailPage();
        commonFunctions.clickElement(backButton, 10, "back to market page");
        return isShowing;
    }

    private boolean clickOnNiftyAndCheckDetailPage() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(marketTickerPageNiftyBank, 10, "market ticker Page Nifty Bank");
        commonFunctions.clickElement(marketTickerPageNiftyBank, 10, "Nifty bank category");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerPageNiftyBankDetailPage, 10, "Nifty Bank detail Page");
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolume() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        int v1 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeFirstHighestLevel, 10));
        int v2 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeSecondHighestLevel, 10));
        int v3 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeThirdHighestLevel, 10));
        int v4 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeFourthHighestLevel, 10));
        if ((isShowing &= v1 > v2) && (v2 > v3) && (v3 > v4)) {
            isShowing &= true;
            Utils.logStepInfo(true, " most active by volume stock volume displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "most active by volume stock volume displayed *****failed*****");
        }
        isShowing = commonFunctions.compareWithSizeListOfElements(listOfElementOnMostActiveByVolumeSection, 4, "MostActiveByVolume list of 4 stock");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeUpdateStatus, 10, "update status");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeBseTab, 10, "BSE tab");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeNseTab, 10, "NSE tab");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeSecurity, 10, "security coloum");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeVol, 10, "volume coloum");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeChange, 10, "Change coloum");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnMostActiveByVolumeSection, 4, "MostActiveByVolume list of 4 stock");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        commonFunctions.clickElement(mostActiveByVolumeViewAll, 10, "view all");
        commonFunctions.isElementDisplayed(mostActiveByVolumeDetailPage, 10, "mostActiveByVolume Detail page");
        commonFunctions.compareWithSizeListOfElements(listOfCompanyOnMostActiveByVolumeDetailPage, 10, "list of stock company");
        int v1 = Integer.parseInt(commonFunctions.getElementText(firstCompanyVolumeOnMostActiveByVolumeDetailPage, 10));
        int v2 = Integer.parseInt(commonFunctions.getElementText(secondCompanyVolumeOnMostActiveByVolumeDetailPage, 10));
        int v3 = Integer.parseInt(commonFunctions.getElementText(thirdCompanyVolumeOnMostActiveByVolumeDetailPage, 10));
        if ((isShowing &= v1 > v2) && (v2 > v3)) {
            isShowing &= true;
            Utils.logStepInfo(true, " most active by volume stock volume in Descending order displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "most active by volume stock volume in Descending order displayed *****failed*****");
        }
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;

    }

    private boolean clickOnFirstCompanyMostByVolume() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        commonFunctions.clickElement(firstCompanyNameOnMostActiveByVolume, 10);
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        String cName = commonFunctions.getElementText(firstCompanyNameOnMostActiveByVolume, 10);
        commonFunctions.clickElement(mostActiveByVolumeFirstHighestLevel, 10, "first stock company");
        isShowing &= checkDesignAndLineGraph(cName);
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkDesignAndLineGraph(String cName) {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(companyShortNameOnMostActiveByVolumeDetailPage, 10, "company short name");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(companyFullNameOnMostActiveByVolumeDetailPage, cName, 10, "company Full name");
        isShowing &= commonFunctions.isElementDisplayed(stockPriceOnMostActiveByVolumeDetailPage, 10, "stock price on detail page");
        commonFunctions.clickElement(fiveDOnIndicesPage, 10, "5D On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneMOnIndicesPage, 10, "1M On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneYOnIndicesPage, 10, "1Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(fiveYOnIndicesPage, 10, "5Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageInfo() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyMostByVolume();
        isShowing &= checkCompanyInfo();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    public boolean checkCompanyInfo() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(companyInfoSection, "company Information section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoAboutSection, "company Information About section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoManagementSection, "company Information Management section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoManagementPlusButton, "company Information collapse button");
        commonFunctions.clickElement(companyInfoManagementPlusButton, 10, "company management plus collapse button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoManagementInDetail, "company management in Detail");
        commonFunctions.scrollUpUntilElementFound(companyInfoAboutPlusButton);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoAboutPlusButton, "company Information plus collapse button");
        commonFunctions.clickElement(companyInfoAboutPlusButton, 10, "company Information plus collapse button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoAboutInDetail, "company Information in Detail");
        return isShowing;
    }

    @Override
    public boolean checkFinancialStandalone() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyMostByVolume();
        isShowing &= checkFinancialSectionStandalone();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkFinancialSectionStandalone() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(finanicalSection, "financial section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dateDropDownSection, "dropdown year");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(incomeStatementSection, "income statement");
        commonFunctions.clickElement(incomeStatementSection, 10, "income Statement Section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(totalRevenueTag, "income related information");
        commonFunctions.scrollUpUntilElementFound(BalanceSheetSection);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(BalanceSheetSection, "Balance sheet");
        commonFunctions.clickElement(BalanceSheetSection, 10, "Balance sheet Section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(cashTag, "Balance sheet related information");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPagePriceHistoryGainerLoser() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeBelowGainernLoser() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesSection() {
        return false;
    }

    @Override
    public boolean checkGainersAndLosersBelowIndianIndices() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPagePriceHistory() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyMostByVolume();
        isShowing &= checkPriceHistory();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkPriceHistory() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(previousCloseSection, "previous Close");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(openPriceSection, "open Price");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dayHighSection, "day High");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dayLowSection, "day Low");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(Week52LowSection, "Week 52 Low");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(Week52HighSection, "Week 52 High");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(BidQuantitySection, "Bid Quantity");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(volumeSection, "volume");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageGainerLoser() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerFirstCompanyName, "gainer & loser first company name");
        String text = commonFunctions.getElementText(topGainerFirstCompanyName, 10);
        commonFunctions.clickElement(topGainerFirstCompanyName, 10, "top Gainer First Company Name");
        isShowing &= commonFunctions.checkElementText(FirstCompanyDetailNameGainerDetailPage, text, 10, "Company Detail Name on Gainer loser  Detail Page");
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean clickOnFirstCompanyGainerLoser() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerFirstCompanyName, "top gainer first company name");
        commonFunctions.clickElement(topGainerFirstCompanyName, 10, "top Gainer First Company Name");
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageCompanyInfo() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= checkCompanyInfo();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserFinancialStandalone() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= checkFinancialSectionStandalone();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPagePriceHistory() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= checkPriceHistory();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerFirstCompanyName, "gainer & loser first company name");
        String cName = commonFunctions.getElementText(topGainerFirstCompanyName, 10);
        commonFunctions.clickElement(topGainerFirstCompanyName, 10, "top Gainer First Company Name");
        isShowing &= checkDesignAndLineGraph(cName);
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageSpecificIndianIndices() {
        boolean isShowing;
        isShowing = checkIndicesRedirectionFunctionality();
        isShowing &= commonFunctions.isElementDisplayed(openPriceTagOnIndicesDetailPage, 10, "open price");
        isShowing &= commonFunctions.isElementDisplayed(preCloseTagOnIndicesDetailPage, 10, "pre close");
        isShowing &= commonFunctions.isElementDisplayed(dayHighTagOnIndicesDetailPage, 10, "day high");
        isShowing &= commonFunctions.isElementDisplayed(dayLowTagOnIndicesDetailPage, 10, "day low");
        isShowing &= commonFunctions.isElementDisplayed(week52HighTagOnIndicesDetailPage, 10, "52 week high tag");
        isShowing &= commonFunctions.isElementDisplayed(week52LowTagOnIndicesDetailPage, 10, "52 week low tag");
        isShowing &= checkDetailPage();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkDetailPage() {
        boolean isShowing;
        commonFunctions.isElementDisplayed(priceChangeInPercentageOnDetailPage, 10, "price in percentage");
        commonFunctions.isElementDisplayed(latestPriceOnDetailPage, 10, "latest price");
        commonFunctions.clickElement(fiveDOnIndicesPage, 10, "5D On Detail Page");
        isShowing = commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneMOnIndicesPage, 10, "1M On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneYOnIndicesPage, 10, "1Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(fiveYOnIndicesPage, 10, "5Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        return isShowing;
    }

    @Override
    public boolean checkTickerDetailPage() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnNiftyAndCheckDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(openPriceTagOnIndicesDetailPage, 10, "open price");
        isShowing &= commonFunctions.isElementDisplayed(preCloseTagOnIndicesDetailPage, 10, "pre close");
        isShowing &= commonFunctions.isElementDisplayed(dayHighTagOnIndicesDetailPage, 10, "day high");
        isShowing &= commonFunctions.isElementDisplayed(dayLowTagOnIndicesDetailPage, 10, "day low");
        isShowing &= commonFunctions.isElementDisplayed(week52HighTagOnIndicesDetailPage, 10, "52 week high tag");
        isShowing &= commonFunctions.isElementDisplayed(week52LowTagOnIndicesDetailPage, 10, "52 week low tag");
        isShowing &= checkDetailPage();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkTickerPriceAndPercentage() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(niftyLatestChangesPrice, 10, "change price");
        isShowing &= commonFunctions.isElementDisplayed(niftyLatestChangesPriceInPercentage, 10, "price change percentage");
        return isShowing;
    }

    @Override
    public boolean checkMarket() {
        return clickOnMarketTabAndVerifyMarketPage();
    }

    @Override
    public boolean checkExploreHamburgerPosition(String iosExplorePos, String androidExplorePos) {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "first Story home page");
        if (explore.getLocation().toString().equals(iosExplorePos)) {
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
        isShowing &= commonFunctions.isElementNotDisplayed(latest, 5, "latest tab");
        return isShowing;
    }

    @Override
    public boolean checkNoAdsOnHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "home page first story");
        //TODO:: as of now RFU is disable after login with subscribed user
//        isShowing &= commonFunctions.checkElementVisibilityByScrolling(recommendedForYouCarousel, "RFU carousel");
        isShowing &= commonFunctions.isElementNotDisplayed(firstAdsRemoveAdButton, 10, "ads");
        return isShowing;
    }

    @Override
    public boolean newsLetterFunctionalityAndDesign() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(newsLetterReadNow, "news letter");
        isShowing &= newsLetterBannerDesign();
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPosition, 10, "position of NewsLetter");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterTopSpace, 10, "top space");
        commonFunctions.clickElement(newsLetterReadNow, 10, "read now button");
        isShowing &= commonFunctions.isElementDisplayed(topOfTheWebView, 10, "top of the web view");
        isShowing &= commonFunctions.isElementDisplayed(morningWebView, 10, "morning web view");
        commonFunctions.clickElement(webViewCloseButton, 10, "close button webView");
        return isShowing;
    }

    private boolean newsLetterBannerDesign() {
        int previousStoryWidth = storyListSize.getSize().getWidth();
        int previousStoryLength = storyListSize.getSize().getHeight();
        int newsLetterWidth = newsLetterPosition.getSize().getWidth();
        int newsLetterLength = newsLetterPosition.getSize().getHeight();
        if (previousStoryWidth == newsLetterWidth || previousStoryLength == newsLetterLength + 5) {
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
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "home page first story");
        isShowing &= commonFunctions.isElementNotDisplayed(firstAdsRemoveAdButton, 10, "ads");
        return isShowing;
    }

    @Override
    public boolean checkAdOnStoryDetailPagePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "home page first story");
        isShowing &= secondStoryOnHomePage.isEnabled();
        commonFunctions.clickElement(secondStoryOnHomePage, 10, "second story on home page");
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing &= storyDetailPageAdVisibility(fontSizeOnStoryDetailPage, "last paragraph of story");
        isShowing &= commonFunctions.isElementDisplayed(firstStoryOnHomePage, 10, "home page first story");
        commonFunctions.clickElement(firstStoryOnHomePage, 10, "first story headline");
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing &= storyDetailPageAdVisibility(fontSizeOnStoryDetailPage, "mint premium");
        return isShowing;
    }

    private boolean storyDetailPageAdVisibility(MobileElement element, String elementName) {
        boolean isShowing;
        isShowing = commonFunctions.isElementEnabled(storyDetailPageHeadline, "story headline");
        commonFunctions.scrollDownToElement(element);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(element, elementName);
        isShowing &= commonFunctions.isElementNotDisplayed(firstAdsRemoveAdButton, 10, "ads on story detail page");
        commonFunctions.clickElement(home, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkExploreAsHamburger() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementDisplayed(explore, 10, "Explore");
    }

    @Override
    public boolean checkExploreRemoveFromNavigation() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementNotDisplayed(exploreBottomNavigation, 10, "explore bottom");
    }

    @Override
    public boolean checkEPaperIcon() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementDisplayed(ePaperIcon, 10, "Explore");
    }

    @Override
    public boolean checkSubscribeIcon() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementDisplayed(subscribe, 10, "Subscribe icon");

    }

    @Override

    public boolean checkMyaccountIcon() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.isElementDisplayed(signInButtonOnTop, 10, "MyAccount icon");
    }

    @Override
    public boolean checkNewsLetterBanner() {
        return false;
    }

    @Override
    public boolean checkPositionOfNewsLetterForSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkSqureCardContainsForThatStory() {
        return false;
    }

    @Override
    public boolean checkMarketCardtypePagefunctionality() {
        boolean isShowing;
        commonFunctions.clickElement(marketTab, 5, "market Tab");
        isShowing = commonFunctions.isElementDisplayed(MarketCardPage, 10, "Market Card type page");
        isShowing &= commonFunctions.isElementDisplayed(indianIndicesPage, 10, "Header Indian Indices");
        isShowing &= commonFunctions.isElementDisplayed(gainerAndLosers, 10, "Header Gainer And Losers");
        isShowing &= commonFunctions.scrollDownToElement(mostActiveByVolume);
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolume, 10, "Header Most Active By Volume");
        return isShowing;
    }

    @Override
    public boolean checkMutualFundsWidgetAndSubCategoryDropDown() {
        return false;

    }

    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        boolean isShowing;
        isShowing =  commonFunctions.clickElement(home, 10, "home tab");
        isShowing &= commonFunctions.clickElement(explore, 10, "Tap on explore Button");
        isShowing &= commonFunctions.clickElement(searchButton, 10, "Tap on search bar");
        isShowing = commonFunctions.sendKeysOnAndroid(searchButton, "Market Dashboard");
        isShowing = commonFunctions.pressEnterKey();
        isShowing = commonFunctions.clickElement(marketDashboard, 10, "Tap Market Dashboard");
        isShowing = commonFunctions.scrollDownToElement(mostActiveVolume);
        isShowing =  commonFunctions.clickElement(stockSuzlonEnergy, 15, "Tap on Any stock to access Company detail page");
        isShowing &= commonFunctions.scrollDownToElement(newsSuzlonEnergy, "Company Related News");
        isShowing &= commonFunctions.isElementDisplayed(newsSuzlonEnergy, 10, "Verify to Company related News");
        return isShowing;
    }

    private boolean checkMarketPage() {
        commonFunctions.clickElement(marketTab, 10, "market tab");
        return commonFunctions.isElementDisplayed(marketTickerPage, 10, "market page");
    }

    @Override
    public boolean checkMutualFundWidgetTitle() {
        boolean isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMF, "mutual fund widgets title");
        return isShowing;
    }

    @Override
    public boolean checkSubCategoryDropDown() {
        boolean isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMFDropDown, "mutual fund DropDown");
        return isShowing;
    }

    @Override
    public boolean checkSubCategoryDefaultSection() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMF, "mutual fund widgets");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMFDropDown, "dropDown");
        String text1 = commonFunctions.getElementText(mutualFundTPMFDropDown, 10);
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
        return false;
    }

    @Override
    public boolean checkSubTitleoFMutualFundPage() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing = commonFunctions.scrollUpToElementDisplayed(topPerformingMutualFunds);
        isShowing = commonFunctions.clickElement(viewAllMutualFund, 10, "View All Icon For Mutual Fund");
        isShowing &= commonFunctions.isElementDisplayed(subtitleMutualFundPage, 10, "Sub-title of Mutual fund page is Mutual Funds- top performers");
        return isShowing;
    }

    @Override
    public boolean checkNewEpaperIconOnTop() {
        commonFunctions.clickElement(home, 10, "Home button");
        return commonFunctions.isElementEnabled(epaperIcon, "new Epaper icon");
    }

    @Override
    public boolean checkNewSignInIconOnTop() {
        commonFunctions.clickElement(home, 10, "Home button");
        return commonFunctions.isElementEnabled(signInIcon, "new SignIn icon");
    }

    @Override
    public boolean checkNewSubscribeIconOnTop() {
        commonFunctions.clickElement(home, 10, "Home button");
        return commonFunctions.isElementEnabled(subscribeIcon,"new subscribe icon");
    }

    @Override
    public boolean checkL1TabOnHomePage() {
        commonFunctions.clickElement(home, 10, "home button");
        boolean isShowing = commonFunctions.isElementDisplayed(l1Tab, 10, "home page L1 menu");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(0), 10, "L1 menu: Top news");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(1), 10, "L1 menu: Markets");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(2), 10, "L1 menu: Companies");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(3), 10, "L1 menu: Industry");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(4), 10, "L1 menu: Money");
        int firstEle[] = commonFunctions.getElementXYCoordinate(l1TabAllOption.get(1));
        int secondEle[] = commonFunctions.getElementXYCoordinate(l1TabAllOption.get(4));
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(5), 10, "L1 menu: Mutual Funds");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(6), 10, "L1 menu: Opinion");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(7), 10, "L1 menu: Insurance");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(8), 10, "L1 menu: Technology");
        return isShowing;
    }

    private boolean clickOnSecondL1Tab() {
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        boolean isShowing = commonFunctions.isElementDisplayed(l1Tab, 10, "home page L1 menu");
        isShowing &= commonFunctions.isElementDisplayed(l1TabAllOption.get(1), 10, "L1 menu: second option");
        isShowing &= commonFunctions.clickElement(l1TabAllOption.get(1), 10, "L1 menu: second option");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementSelected(l1TabAllOption.get(1), 20, "L1 menu: second option");
        return isShowing;
    }

    @Override
    public boolean checkL1TabSelection() {
        boolean isShowing = clickOnSecondL1Tab();
        isShowing &= commonFunctions.isElementSelected(home, 10, "Home button");
        return isShowing;
    }

    @Override
    public boolean checkL1TabBackButtonFunctionality() {
        return false;
    }

    @Override
    public boolean checkFocusOnL1TabClickingOnHomeButton() {
        boolean isShowing = clickOnSecondL1Tab();
        isShowing &= commonFunctions.clickElement(home, 10, "Home button");
        isShowing &= commonFunctions.isElementSelected(l1TabAllOption.get(0), 10, "L1 menu: first option");
        return isShowing;
    }

    @Override
    public boolean checkL1MenuSelectionBySwipingTheHomePage() {
        commonFunctions.clickElement(home, 10, "home button");
        commonFunctions.dummyWait(5);
        boolean isShowing = commonFunctions.isElementDisplayed(l1Tab, 10, "home page L1 menu");
        commonFunctions.swipeElementUsingTouchAction(395, 420, 30, 419);
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementSelected(l1TabAllOption.get(1), 10, "L1 menu: first option");
        return isShowing;
    }

    @Override
    public boolean checkTickerCategoryD() {
        commonFunctions.clickElement(home, 10, "home button");
        return commonFunctions.isElementVisible(TickerD, 10, "category D");
    }

    @Override
    public boolean checkSectionNameWithListedStory() {
        commonFunctions.clickElement(home, 10, "home button");
        boolean isShowing = commonFunctions.isElementDisplayed(l1TabAllOption.get(1), 10, "L1 menu: second option");
        isShowing &= commonFunctions.clickElement(l1TabAllOption.get(1), 10, "L1 menu: second option");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(sectionName, "market section name");
        return isShowing;
    }

    @Override
    public boolean checkTickerArrow() {
        return false;
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
        return false;
    }

    @Override
    public boolean checkMintTop50MFForSubscribedUsers(String pageTitle) {
        return false;
    }

    @Override
    public boolean checkColumnsSubSectionInTopNav() { return false; }

    @Override
    public boolean checkMFSectionInTopNav() { return false; }

    @Override
    public boolean checkNewsSubsectionUnderMFInTopNav() { return false; }

    @Override
    public boolean checkViewsSubsectionUnderOpinionInTopNav() { return false; }

    @Override
    public boolean checkViewsSubsectionStoryPage() { return false; }

    @Override
    public boolean checkViewsSubsectionPageLayout() { return false; }

    @Override
    public boolean checkIndustryPageLayout() { return false; }

    @Override
    public boolean checkSubscriptionInformation() {
        return false;
    }

    @Override
    public boolean checkHomePageAsExpected() {
        return false;
    }

    @Override
    public boolean checkEditProfileGender() {
        return false;
    }

    @Override
    public boolean checkLoginInPage() {
        return false;
    }

    @Override
    public boolean checkHeaderNavigationOfEachTab() {
        return false;
    }

    @Override
    public boolean checkPremiumIconOnBottom() {
        return false;
    }

    @Override
    public boolean checkPlanPageAllActivePlan() {
        return false;
    }

    @Override
    public boolean checkApplyCouponAndSignInOption() {
        return false;
    }

    @Override
    public boolean checkAppLaunch() {
        return false;
    }

    @Override
    public boolean checkHeaderElements() {
        return false;
    }

    @Override
    public boolean checkOpinionsSectionInTopNav() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbOnCompaniesPage() { return false;}

    @Override
    public boolean checkTwitterPageWhenTapOnTwitterIcon() { return false; }

    @Override
    public boolean checkLinkedinPageWhenTapOnLinkedinIcon() { return false; }

    @Override
    public boolean checkFacebookPageWhenTapOnFacebookIcon() { return false; }

    @Override
    public boolean checkOpinionSectionStoryDetails() { return false; }

    @Override
    public boolean checkShareholdingWidget() { return false; }

    @Override
    public boolean checkCompaniesLandingPage() { return false; }

    @Override
    public boolean checkPodcastEpisodePage() { return false; }

    @Override
    public boolean checkPodcastEpisode() { return false; }

    @Override
    public boolean checkVideoListingLandingPageStructure() { return false; }

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