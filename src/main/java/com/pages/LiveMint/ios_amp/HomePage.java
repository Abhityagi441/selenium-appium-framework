package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends CommonHomePage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsMobileLM;

    @FindBy(xpath = "//div[contains(@class,'icoBell iconSprite')]/following-sibling::div")
    private static WebElement notificationBell;

    @FindBy(xpath = "//span[@id='noTCounter']")
    private static WebElement notificationBadge;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static WebElement notificationHeading;

    @FindBy(xpath = "//div[@id='notification_new']")
    private static WebElement notificationNew;

    @FindBy(xpath = "//button[contains(@class,'ampstart-btn caps m2')]")
    private static WebElement explore;

    @FindBy(xpath = "//div[contains(@id,'hamburgerElement')]")
    private static WebElement exploreAmp;

    @FindBy(xpath = "//a[@href='/amp-mutual-fund']/parent::li//h6")
    private static WebElement mutualFundsExpand;

    @FindBy(xpath = "//li//a[@href='/amp-mutual-fund']/parent::li//li//a[contains(@data-vars-event-action,'Mint 50')]")
    private static WebElement mutualFundsTop50SubSection;

    @FindBy(xpath = "//li//a[@href='/amp-mutual-fund']/parent::li//li//a[contains(@data-vars-event-action,'News')]")
    private static WebElement mutualFundsNewsSubSection;

    @FindBy(xpath = "(//ol[@class='slider'])[1]/a")
    private static WebElement marketSENSEX;

    @FindBy(xpath = "//li[contains(text(),'SENSEX')]")
    private static WebElement verifySENSEX;

    @FindBy(xpath = "//section[@class='mainSec']/h1[text()='Markets']")
    private static WebElement listMarkets;

    @FindBy(xpath = "//img[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(xpath = "//section[@id='box_11626232429277']")
    private static WebElement firstStory;

    @FindBy(xpath = "(//a[contains(@class,'btnClose')])[1][normalize-space()='Close']")
    private static WebElement closeStory;

    @FindBy(xpath = "(//div[contains(@class,'icoShare')])[1]")
    private static WebElement shareIcon;

    @FindBy(xpath = "(//amp-social-share[@type='facebook'])[1]")
    private static WebElement facebookIcon;

    @FindBy(xpath = "(//amp-social-share[@type='linkedin'])[1]")
    private static WebElement linkedinIcon;

    @FindBy(xpath = "(//amp-social-share[@type='twitter'])[1]")
    private static WebElement twitterIcon;

    @FindBy(xpath = "(//amp-social-share[@type='whatsapp'])[1]")
    private static WebElement whatsappIcon;

    @FindBy(xpath = "(//a[contains(@class,'icoBookmark')])[2]")
    private static WebElement bookmarkPage;

    @FindBy(xpath = "(//a[contains(@class,'icoBookmark')])[1]")
    private static WebElement bookmarkFirstIcon;

    @FindBy(xpath = "(//div[@id='socialHolder']//a[contains(@class,'icoBookmark')])[1]")
    private static WebElement bookmarkIcon;

    @FindBy(xpath = "(//span[@class='articleInfo pubtime'])[1]/em/span")
    private static WebElement minutesToRead;

    @FindBy(xpath = "(//span[@class='articleInfo pubtime'])[1]")
    private static WebElement timestamp;

    @FindBy(xpath = "(//span/img[@class='lozad fade'])[1]")
    private static WebElement imageFirstStory;

    @FindBy(xpath = "(//link[@rel='icon'])[1]")
    private static WebElement favIcon;

    @FindBy(xpath = "(//div/a[@class='closebtn'])[1]")
    private static WebElement closeMyAccount;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private static WebElement myAccount;

    @FindBy(xpath = "//div[@class='acorHead']/div")
    private static WebElement loggedInUserName;

    @FindBy(xpath = "//a[@id='fixedNav_latest']")
    private static WebElement latestPage;

    @FindBy(xpath = "//a[contains(text(),'Trending')]")
    private static WebElement trendingPage;

    @FindBy(xpath = "//a[@id='exclusive']")
    private static WebElement premiumPage;

    @FindBy(xpath = "(//div[contains(@class,'listing ')])[1]")
    private static WebElement pageContent;

    @FindBy(xpath = "//section[@id='story1']//figure/figcaption")
    private static WebElement imageCaption;

    @FindBy(xpath = "(//div[@class='mainArea']//p)[1]")
    private static WebElement summary;

    @FindBy(xpath = "(//section[contains(@amp-access,'subscribed')]/p)[1]")
    private static WebElement paragraph;

    @FindBy(xpath = "(//span[@class='articleInfo pubtime'])[1]/span")
    private static WebElement updatedTimeStamp;

    @FindBy(xpath = "//img[@title='mint']")
    private static WebElement mintTitle;

    @FindBy(xpath = "(//h2[@class='headline'])[1]")
    private static WebElement latestFirstStory;

    @FindBy(xpath = "(//h2[@class='headline'])[1]/a")
    private static WebElement notificationFirstStory;

    @FindBy(xpath = "//span[contains(@class,'wewidgeticon we_close icon-large')]")
    private static WebElement closeButtonForUnlimitedDigitalAccessPopup;

    @FindBy(xpath = "(//img[contains(@class,'i-amphtml-fill-content i-amphtml-replaced-content')])[3]")
    private static WebElement firstImage;

    @FindBy(xpath = "(//h2[@class='headline'])[1]/a")
    private static WebElement firstTitleInPage;

    @FindBy(xpath = "//div[@class='topTxt clearfix']")
    private static WebElement subscribeToContinueReading;

    @FindBy(xpath = "//a[text()='Start 15 Days Trial']")
    private static WebElement start15DaysTrail;

    @FindBy(xpath = "(//span[contains(@class,'exclusive')])[1]")
    private static WebElement premiumText;

    @FindBy(id = "accept")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static WebElement listHeading;

    @FindBy(xpath = "(//div/h2[@class='headline']/a)[1]")
    private static WebElement storyPage;

    @FindBy(xpath = "(//div[contains(@class,'headline')])[2]")
    private static WebElement openStoryPage;

    @FindBy(xpath = "//section[@id='story1']/article/h1")
    private static WebElement openHomeStoryPage;

    @FindBy(xpath = "(//*[@class='lozad fade'])[1]")
    private static WebElement imagefirstStory;

    @FindBy(xpath = "//nav//a[@id='fixedNav_home']")
    private static WebElement homePage;

    @FindBy(xpath = "//*[@id='topic_Market Dashboard'])[1]")
    private static WebElement marketDashboard;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.chrome:id/positive_button']")
    private static WebElement allowNotification;

    @FindBy(xpath = "(//button[@class='subscribe'])[2]")
    private static WebElement allowNotificationAmp;

    @FindBy(xpath = "(//button[@class='subscribe'])[1]")
    private static WebElement denyNotification;

    @FindBy(xpath = "//button[@id='moe-dontallow_button']")
    private static WebElement laterButtonOnNotification;

    @FindBy(xpath = "//div[contains(@class,'mwebsearch')] | //a[contains(@class,'mwebsearch')]")
    private static WebElement searchButton;

    @FindBy(xpath = "//div[@class='amp-push-notification']")
    private static WebElement notificationPanel;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]")
    private static WebElement premiumHeadline;

    @FindBy(xpath = "//div[@class='CtaSec']/a[@id='subClick']")
    private static WebElement startTrialBtn;

    @FindBy(xpath = "(//h6[contains(@class,'subnavArrow')])[1]")
    private static WebElement subArrow;

    @FindBy(xpath = "(//ul/li/a[@data-vars-event-action='News'])[2]")
    private static WebElement subNews;

    @FindBy(xpath = "//li/a[@data-vars-event-action='News']")
    private static WebElement news;

    @FindBy(xpath = "(//a[contains( @id,'topic_Long Story')])[1]")
    private static WebElement longStory;

    @FindBy(xpath = "(//h6[contains(@class,'subnavArrow')])[3]")
    private static WebElement marketsArrow;

    @FindBy(xpath = "(//a[contains(@class,'icoBookmark')])[3]")
    private static WebElement bookmarkPageLogin;

    @FindBy(xpath = "//li/a[contains(text(),'Stock Markets')]")
    private static WebElement stockMarket;

    @FindBy(xpath = "//div[@class='headlineSec']/h2/a")
    private static WebElement stockMarketHeadline;

    @FindBy(xpath = "(//div[contains(text(),'Share Via')])[1]")
    private static WebElement shareVia;

    @FindBy(xpath = "//div[@class='share-icons-box']/amp-social-share[@type='facebook']")
    private static WebElement storyDetailFacebookIcon;

    @FindBy(xpath = "//div[@class='share-icons-box']/amp-social-share[@type='linkedin']")
    private static WebElement storyDetailLinkedinIcon;

    @FindBy(xpath = "//div[@class='share-icons-box']/amp-social-share[@type='twitter']")
    private static WebElement storyDetailTwitterIcon;

    @FindBy(xpath = "(//img[contains(@class,'lozad')])[1]")
    private static WebElement imageOtherPagesfirstStory;

    @FindBy(xpath = "(//div/a[contains(@class,'imgSec')])[1]")
    private static WebElement secondImage;

    @FindBy(xpath = "(//span[contains(@class,'author')])[1]")
    private static WebElement authorName;

    @FindBy(xpath = "//ul[@class='navCategories']/li")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//section/a[@data-vars-event-action='Subscribe']")
    private static WebElement subscribe;

    @FindBy(xpath = "//a[contains(text(),'My Reads')]")
    private static WebElement myReads;

    @FindBy(xpath = "//a[@data-vars-event-action='e-paper']")
    private static WebElement ePaper;

    @FindBy(xpath = "//a[@data-vars-event-action='newsletter']")
    private static WebElement newsLetter;

    @FindBy(xpath = "//a[contains(text(),'IFSC Code Finder')]")
    private static WebElement ifscCode;

    @FindBy(xpath = "(//section/h6[contains(@class,'subnavArrow')])")
    private static WebElement arrow;

    @FindBy(xpath = "//ul[@class='navCategories']/li/a")
    private static List<WebElement> hamburgerList;

    @FindBy(xpath = "//ul[@class='navCategories']")
    private static WebElement hamburgerElement;

    @FindBy(xpath = "//div[@class='whiteOverlay2']")
    private static WebElement overlay;

    @FindBy(xpath = "//div[@class='errorHolder']")
    private static WebElement error;

   @FindBy(xpath = "//ol[@class='slider']")
    private static WebElement marketTicker;

    @FindBy(xpath = "(//ol[@class='slider'])[1]/a")
    private static WebElement marketSensex;

    @FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'S&P BSE SENSEX')]")
    private static WebElement marketSensexLanding;

    @FindBy(xpath = "//div[@id='I0002']//li[contains(.,'NIFTY 50')][1]")
    private static WebElement marketNifty;

    @FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'NIFTY 50')]")
    private static WebElement marketNiftyLanding;

    @FindBy(xpath = "//div[@id='I0006']//li[contains(.,'NIFTY BANK')][1]")
    private static WebElement marketNiftyBank;

    @FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'NIFTY Bank')]")
    private static WebElement marketNiftyBankLanding;

    @FindBy(xpath = "//div[@id='I0036']//li[contains(.,'BSE MIDCAP')][1]")
    private static WebElement marketBSEMidCap;

    @FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'S&P BSE Midcap')]")
    private static WebElement marketBSEMidCapLanding;

    @FindBy(xpath = "(//a[contains(.,'GOLD')])[1]")
    private static WebElement marketGold;

    @FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'GOLD')]")
    private static WebElement marketGoldLanding;

    @FindBy(xpath = "(//a[contains(.,'SILVER')])[1]")
    private static WebElement marketSilver;

    @FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'SILVER')]")
    private static WebElement marketSilverLanding;

    @FindBy(xpath = "//div[contains(@class,'next_swiper_stat')]")
    private static WebElement marketNextIcon;

    @FindBy(xpath = "//div[contains(@class,'prev_swiper_stat')]")
    private static WebElement marketPrevIcon;

    @FindBy(xpath = "//h1[text()='BSE SENSEX']")
    private static WebElement verifyNifty;

    @FindBy(xpath = "//div[@class='share-icons-box']/amp-social-share[@type='whatsapp']")
    private static WebElement storyDetailWhatsappIcon;

    @FindBy(xpath = "(//*[local-name()='svg' and @fill='#FFF']/*[local-name()='path'])[1]")
    private static WebElement closeButtonIngGoogleAdPopup;

    @FindBy(xpath = "//span[text()='Close']")
    private static WebElement closeButtonIngGoogleAdPopup2;

    @FindBy(xpath = "//i[contains(@class,'we_close')]")
    private static WebElement closeButtonInFivePercentDiscountAdPopup;

    @FindBy(xpath = "//span[contains(@class,'we_close')]")
    private static WebElement closeButtonInDownloadTheAppAdPopup;

    @FindBy(xpath = "(//iframe[contains(@id,'aswift')])[2]")
    private static WebElement googleAdFrame;

    @FindBy(xpath = "//iframe[@id='ad_iframe']")
    private static WebElement googleAdFrame2;

    @FindBy(xpath = "//iframe[contains(@name,'notification-frame')]")
    private static WebElement notificationAdFrame;

    @FindBy(xpath = "//h1[@class='headline']")
    private static WebElement storyDetailPage;

    @FindBy(xpath = "//section[contains(@class,'cardHolder')]/article/a/h1")
    private static WebElement homeStoryHeadLine;

    @FindBy(xpath = "//h2[@class='headline']/a")
    private static WebElement premiumStoryHeadLine;

    @FindBy(xpath = "//div/a[@class='btnSub']")
    private static WebElement subscribeNow;

    @FindBy(xpath = "//li[contains(text(),'GOLD')]")
    private static WebElement goldMT;

    @FindBy(xpath = " (//div[contains(@class,'listtostory clearfix')])[1]")
    private static WebElement mintPageContent;

    @FindBy(xpath = "(//div[contains(@class,'listingAmp')])[1] ")
    private static WebElement scrollToShare;

    @FindBy(xpath = "(//div/a[@data-vars-icontype='facebook'])[1]")
    private static WebElement commonFacebookIcon;

    @FindBy(xpath = "(//div/a[@data-vars-icontype='linkedin'])[1]")
    private static WebElement commonLinkedinIcon;

    @FindBy(xpath = "(//div/a[@data-vars-icontype='twitter'])[1]")
    private static WebElement commonTwitterIcon;

    @FindBy(xpath = "(//div/a[@data-vars-icontype='whatsapp'])[1]")
    private static WebElement commonWhatsappIcon;

    @FindBy(xpath = "//div[@class='openinApp']")
    private static WebElement openApp;

    @FindBy(xpath = "(//div[contains(@class,'bcrumb')]/a)[2]")
    private static WebElement breadcrumsSection;

    @FindBy(xpath = "(//div[contains(@class,'bcrumb')]/text())[3]")
    private static WebElement breadcrumsHeadline;

    @FindBy(xpath = "//div[contains(@class,'bcrumb')]")
    private static WebElement breadcrums;

    @FindBy(xpath = "(//div[contains(@class,'bcrumb')]/a)[1]")
    private static WebElement breadcrumsHome;

    @FindBy(xpath = "(//div[contains(@class,'bcrumb')]/a)[3]")
    private static WebElement breadcrumsSubSection;

    @FindBy(xpath = "//section[@class='marketStat']")
    private static WebElement epaperPromo;

    //@FindBy(xpath = "//ol[@class='slider']")
    @FindBy(xpath = "//div[@class='swiper-slide']")
    private static List<WebElement> marketTickerElementList;

    @FindBy(xpath = "//ol[@class='slider']/a/li/strong")
    private static List<WebElement> marketTickerStats;

    @FindBy(xpath = "(//*[@class='headline'])[1]")
    private static WebElement storyPageHeadline;

    @FindBy(xpath = "//div[@class='subscriptionBox']")
    private static WebElement subscriptionPaywall;

    @FindBy(xpath = "//nav/a[contains(@class,'explore')]")
    private static List<WebElement> hamburgerTopmost;

    @FindBy(xpath = "//img[@class='close-icon']")
    private static WebElement closeSubscribePopUp;

    @FindBy(id = "sidebar-left")
    private static WebElement hamburgerElement2;

    @FindBy(xpath = "//div[@onclick='closeNav()']")
    private static WebElement closeHamburger;

    @FindBy(xpath = "//div[@class='amp-push-notification']")
    private static WebElement notificationPopup;
    @FindBy(xpath = "(//div[contains(@class,'socialHolder')]//a[@data-vars-icontype='facebook'])[1]")
    private static WebElement facebookIconNonAMP;

    @FindBy(xpath = "(//div[contains(@class,'socialHolder')]//a[@data-vars-icontype='linkedin'])[1]")
    private static WebElement linkedinIconNonAMP;

    @FindBy(xpath = "(//div[contains(@class,'socialHolder')]//a[@data-vars-icontype='twitter'])[1]")
    private static WebElement twitterIconNonAMP;

    @FindBy(xpath = "(//div[contains(@class,'socialHolder')]//a[@data-vars-icontype='whatsapp'])[1]")
    private static WebElement whatsappIconNonAMP;

    @FindBy(xpath = "//amp-iframe[contains(@class,'mutualfundwidgetamp')]")
    private static WebElement tickerIframe;

    @FindBy(xpath = "//iframe[@name='amp_iframe0']")
    private static WebElement tickerInnerIframe;

    @FindBy(xpath = "//div[@class='subscriptionBox']")
    private static WebElement subscribeToContinueReadingNOnAMP;

    @FindBy(xpath = "//div[@class='FirstEle']/p")
    private static WebElement paraBeforePaywall;
    @FindBy(xpath = "(//div[@class='mainArea']/section/p)[1]")
    private static WebElement paraBeforePaywallAMP;

    @FindBy(xpath = "//div[@id='adHeightstory']")
    private static WebElement adBeforePaywall;

    @FindBy(xpath = "//div[@class='sub']//div[@class='fixadheight']")
    private static WebElement adBeforePaywallAMP;

    @FindBy(xpath = "//nav//a[contains(@href,'latest-news')]")
    private static WebElement latestNewsLinkOnHeader;

    @FindBy(xpath = "//a[contains(@href,'latest-news/page-2')]")
    private static WebElement viewMoreButton;

    @FindBy(xpath = "//a[@alt='mint']")
    private static WebElement mintLogo;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaperOnHeader;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppOnHeader;

    @FindBy(xpath = "//a[text()='Subscribe Now']")
    private static WebElement subscribeNowButton;

    @FindBy(xpath = "//a[contains(@id,'topnav-sign-in')]")
    private static WebElement signInButton;

    @FindBy(xpath = "//a[contains(@class,'btnSubscribe')]")
    private static WebElement subscribeOnHamburgerMenu;

    @FindBy(xpath = "//a[@href='/amp-industry']/parent::li//h6")
    private static WebElement industryExpand;

    @FindBy(xpath = "//a[@href='/amp-industry']")
    private static WebElement industrySection;

    @FindBy(xpath = "//a[@href='/amp-opinion']/parent::li//h6")
    private static WebElement opinionExpand;

    @FindBy(xpath = "//a[@href='/amp-opinion']/parent::li//li//a[contains(@href,'/opinion/columns')]")
    private static WebElement columnsInOpinion;

    @FindBy(xpath = "//a[@href='/amp-opinion']/parent::li//li//a[contains(@href,'/opinion/online-views')]")
    private static WebElement viewsInOpinion;

    @FindBy(xpath = "//div[contains(@class,'listing')]")
    private static List<WebElement> listOfStoriesInColumns;

    @FindBy(xpath = "//a[@href='/amp-opinion']/parent::li/a")
    private static WebElement opinionSection;

    @FindBy(xpath = "//div[@class='headlineSec']//a")
    private static List<WebElement> listOfStoryTitles;

    @FindBy(xpath = "//div[@class='stickyWhatsapp']")
    private static WebElement stickyWhatsappIcon;

    @FindBy(xpath = "(//section[@id='story1']//div[@class='mainArea']//section[not (@amp-access-hide)]//p) | (//div[@id='mainArea']//div[@class='FirstEle'])")
    private static List<WebElement> listofStoryParagraphs;

    @FindBy(xpath = "//div[contains(@class,'listing')]")
    private static List<WebElement> listOfStoriesInMutualFundSection;

    @FindBy(xpath = "//div[contains(@class,'listing')]//img")
    private static List<WebElement> thumpIconInStory;

    @FindBy(xpath = "//h1[text()='Columns']")
    private static WebElement columnInHomepage;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement pageHeadingOnSectionPage;

    @FindBy(xpath = "//a[@href='/amp-mutual-fund']")
    private static WebElement mutualFundsSection;

    @FindBy(xpath = "//a[text()='Companies']")
    private static WebElement companiesInExplore;

    @FindBy(xpath = "(//h2[@class='headline'])[1]/a")
    private static WebElement firstStoryInBreadcrumb;

    @FindBy(xpath = "//h2[@class='headline']")
    private static List<WebElement> listOfStoriesHeadline;

    @FindBy(xpath = "//a[@href='/amp-videos']")
    private static WebElement videosSection;

    @FindBy(xpath = "//section[@class='mainSec listView']/a")
    private static WebElement moreTabInVideos;

    @FindBy(xpath = "//a[@href='/amp-sports']")
    private static WebElement sportsSection;

    @FindBy(xpath = "//nav[@id='leftNav']")
    private static WebElement l1Nav;

    @FindBy(xpath = "//nav[@id='leftNav']//a")
    private static List<WebElement> listOfSectionsInL1;

    @FindBy(xpath = "//div[text()='Mint Premium']")
    private static WebElement mintPremiumCarousel;

    @FindBy(xpath = "//div[@class='listingAmp clearfix']")
    private static List<WebElement> listOfStoriesInMintPremium;

    @FindBy(xpath = "//div[@class='listingAmp clearfix']//span")
    private static WebElement premiumTag;

    @FindBy(xpath = "//ul[@class='highlights']")
    private static WebElement synopsisOfStory;

    public HomePage() {

        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLM=CommonFunctionsMobileLM.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 60, "agreeCookieButton");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean notification(String apiURL, String faviconURL) {
        return false;
    }

    @Override
    public boolean marketTicker(String[] params) {
        boolean marketTickerStatus;

        String marketStatsAMPURL = params[16];
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        commonFunctions.switchToFrame(tickerIframe,10,"ticker iframe");
        commonFunctions.switchToFrame(tickerInnerIframe,10,"ticker inner iframe");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerStatus = checkOrderListPresentInTheMarketTicker();
        commonFunctions.isElementClickable(marketTicker, 10, "Market Ticker");
        commonFunctions.clickElementWithJS(marketSensex, 10, "Click BSE SENSEX");
        commonFunctions.switchToWindowWithTitle("S&P BSE SENSEX: Live S&P BSE SENSEX, S&P BSE SENSEX Stock Price, Stock Performance & Comparison Chart",20,2);
        boolean urlStatus = checkURLChangedToMarketStatsURL(marketStatsAMPURL);
        boolean marketTickerLanding = commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");

        if (checkOrderListPresentInTheMarketTickerStatus && urlStatus && marketTickerLanding ) {
            marketTickerStatus = true;
        } else {
            marketTickerStatus = false;
        }
        return marketTickerStatus;
    }

    public boolean checkURLChangedToMarketStatsURL(String marketStatsURL) {
        boolean checkURLChangedToMarketStatsURLStatus;
        commonFunctions.clickElement(marketSensex, 10, "Market Sensex");
        commonFunctions.waitForURLContains(marketStatsURL);
        commonFunctions.dummyWait(10);
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToMarketStatsURLStatus = commonFunctions.checkTextEquals(marketStatsURL, actualURL, "Market Stats URL");
        return checkURLChangedToMarketStatsURLStatus;
    }

    public boolean checkOrderListPresentInTheMarketTicker() {
        boolean checkOrderListPresentInTheMarketTickerStatus;
        if (marketTickerElementList.size() >=4) {
            Utils.logStepInfo(true, "Ordered list is present in the Market ticker");
            checkOrderListPresentInTheMarketTickerStatus = true;
        } else {
            Utils.logStepInfo(false, "Ordered list is NOT present in the Market ticker");
            checkOrderListPresentInTheMarketTickerStatus = false;
        }
        return checkOrderListPresentInTheMarketTickerStatus;
    }

    public boolean checkEachMarketLandingPagesAreNotBlank(String nifty50LandingPage,String niftyBankLandingPage,String bseMidcapLandingPage) {
        boolean checkEachMarketLandingPagesAreNotBlankStatus;

        dragAndDropAndClickMarketTicker(marketNifty, marketSensex, "Market Nifty");
        boolean marketNiftyLandingStatus = checkMarketTickerLandingPage(marketNiftyLanding, nifty50LandingPage, 30);
        commonFunctions.isElementDisplayed(marketTicker, 60, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInNiftyPage = checkOrderListPresentInTheMarketTicker();

        dragAndDropAndClickMarketTicker(marketNiftyBank, marketNifty, "Market Nifty Bank");
        boolean marketNiftyBankLandingStatus = checkMarketTickerLandingPage(marketNiftyBankLanding, niftyBankLandingPage, 30);
        commonFunctions.isElementDisplayed(marketTicker, 60, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInNiftyBankPage = checkOrderListPresentInTheMarketTicker();

        dragAndDropAndClickMarketTicker(marketBSEMidCap, marketNiftyBank, "Market Midcap");
        boolean marketBSEMidcapLandingStatus = checkMarketTickerLandingPage(marketBSEMidCapLanding, bseMidcapLandingPage, 30);
        commonFunctions.isElementDisplayed(marketTicker, 60, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInBSEMidCapPage = checkOrderListPresentInTheMarketTicker();



        if (marketNiftyLandingStatus && marketNiftyBankLandingStatus && marketBSEMidcapLandingStatus &&  checkOrderListPresentInTheMarketTickerInBSEMidCapPage && checkOrderListPresentInTheMarketTickerInNiftyPage && checkOrderListPresentInTheMarketTickerInNiftyBankPage) {
            checkEachMarketLandingPagesAreNotBlankStatus = true;
        } else {
            checkEachMarketLandingPagesAreNotBlankStatus = false;
        }
        return checkEachMarketLandingPagesAreNotBlankStatus;
    }

    public boolean checkMarketTickerLandingPage(WebElement landingPageElement, String landingPageElementName, int timeOut) {
        boolean checkLandingPageStatus;
        commonFunctions.isElementDisplayed(landingPageElement, timeOut, landingPageElementName + " Landing page");
        String actualLandingPageName = commonFunctions.getElementText(landingPageElement, timeOut);
        if (actualLandingPageName.equals(landingPageElementName)) {
            checkLandingPageStatus = true;
            Utils.logStepInfo(true, landingPageElementName + " Landing Page displayed successfully");
        } else {
            checkLandingPageStatus = false;
            Utils.logStepInfo(false, landingPageElementName + " Landing Page is not displayed. Expected: " + landingPageElementName + ", Actual: " + actualLandingPageName);
        }
        return checkLandingPageStatus;
    }

    public void dragAndDropAndClickMarketTicker(WebElement element1, WebElement element2, String elementName) {
        for (int i = 1; i <= 3; i++) {
            try {
                commonFunctions.clickElementIfDisplayed(acceptCookie, 2, "accept cookie button");
                commonFunctions.clickElementWithJS(element1, 8, elementName);
                break;
            } catch (Exception e) {
                commonFunctions.dragAndDrop(element1, element2);
                commonFunctions.waitForPageLoading(30);
                if (i == 3) {
                    commonFunctions.clickElementIfDisplayed(acceptCookie, 2, "accept cookie button");
                    commonFunctions.clickElementWithJS(element1, 8, elementName);
                }
            }
        }
    }

    @Override
    public boolean nonSubscribedUserPaywall(String apiURL) {
        boolean nonSubscribedUserPayWallStatus;
        boolean paywallPresentStatus;
       commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(pageContent, 10, "Home Page");
        commonFunctions.clickElement(premiumPage, 10, "Premium");
        commonFunctions.waitForURLToBe(globalVars.getURL() + "-premium");
        boolean checkPremiumPageStatus = commonFunctions.checkPageURL(globalVars.getURL() + "-premium",10,"Premium Landing Page");
        commonFunctions.clickElement(firstTitleInPage, 10, "First Title in Premium Page");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.waitForPageLoading(10);
        boolean checkPremiumLabel = commonFunctions.checkElementText(premiumText, "PREMIUM", 10, "Premium Label");
        boolean premiumStoryStatus = checkDataUsingStoryAPI("true", "Premium Story in API", "content[0].metadata.premiumStory", apiURL);
        boolean paragraphAMP= commonFunctions.scrollToElementView(paraBeforePaywallAMP,10,"para");
if(paragraphAMP)
        {

            commonFunctions.scrollToElementView(adBeforePaywallAMP,10,"AMP ad");
           // commonFunctions.scrollToElement(subscribeToContinueReading, "Scroll Subscribe ");
            paywallPresentStatus=commonFunctions.isElementDisplayed(subscribeToContinueReading, 10, "Subscribe to continue reading");
        }
        else
        {
            commonFunctions.scrollToElementView(paraBeforePaywall,10,"para");
            commonFunctions.scrollToElementView(adBeforePaywall,10,"Ads before paywall");
            //commonFunctions.scrollToElement(subscribeToContinueReadingNOnAMP,10,"paywall box");
            paywallPresentStatus= commonFunctions.isElementDisplayed(subscribeToContinueReadingNOnAMP, 10, "Subscribe to continue reading");
        }

        if (checkPremiumPageStatus && paywallPresentStatus && checkPremiumLabel && premiumStoryStatus) {
            nonSubscribedUserPayWallStatus = true;
        } else {
            nonSubscribedUserPayWallStatus = false;
        }
        return nonSubscribedUserPayWallStatus;
    }

    public boolean checkDataUsingStoryAPI(String expectedValue, String elementName, String jsonPath, String apiURL) {
        boolean checkDataUsingStoryAPIStatus;
        String storyId = commonFunctions.getStoryIdFromURL();
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        String actualValueFromAPI = RestUtils.getValueFromResponse(response, jsonPath);
        actualValueFromAPI = Utils.formatAPIText(actualValueFromAPI);
        checkDataUsingStoryAPIStatus = commonFunctions.checkTextContains(expectedValue, actualValueFromAPI, elementName);
        return checkDataUsingStoryAPIStatus;
    }

    @Override
    public boolean pageContent(String apiURL) {
        boolean pageContentStatus;
        String expectedText;
        commonFunctions.navigateToURL(globalVars.getURL());

        commonFunctions.dummyWait(10);
        boolean homePageTitleAndUrlStatus = checkPageURLandTitle(homePage, "Home", "", "Business News Today: Read Latest Business News, Live India Share Market News, Finance & Economy News | Mint", 10);
        boolean latestPageTitleAndUrlStatus = checkPageURLandTitle(latestPage, "Latest Page", "-latest-news", "Latest News Today: Latest News Headlines, Breaking News, Current News | Mint", 10);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElementWithJS(firstImage, 10, "Open First Story");
        expectedText = commonFunctions.getElementText(storyDetailPage, 10);
        boolean latestPageStoryStatus = checkDataUsingStoryAPI(expectedText, "Latest Headline in API", "content[0].headline", apiURL);
       /* boolean trendingPageTitleAndUrlStatus = checkPageURLandTitle(trendingPage, "Trending", "-mostpopular", "Trending News: Today's Trending News, Viral News, Popular News Headlines - Mint", 60);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(firstImage, 60, "Open First Story");
        expectedText = commonFunctions.getElementText(storyDetailPage, 60);
        boolean trendingPageStoryStatus = checkDataUsingStoryAPI(expectedText, "Trending Headline in API", "$.content[0].headline", apiURL);
        boolean premiumPageTitleAndUrlStatus = checkPageURLandTitle(premiumPage, "Premium", "-premium", "Read Premium News and Stories on Mint", 60);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(premiumStoryHeadLine, 60, "Open First Story");
        expectedText = commonFunctions.getElementText(storyDetailPage, 60);
        boolean premiumPageStoryStatus = checkDataUsingStoryAPI(expectedText, "Premium Headline in API", "$.content[0].headline", apiURL);
*/
        if (homePageTitleAndUrlStatus && latestPageTitleAndUrlStatus && latestPageStoryStatus){//&& trendingPageTitleAndUrlStatus && premiumPageTitleAndUrlStatus && trendingPageStoryStatus  && premiumPageStoryStatus) {
            pageContentStatus = true;
        } else {
            pageContentStatus = false;
        }
        return pageContentStatus;
    }
    @Override
    public boolean shareStoryFunctionality() {

        boolean shareStoryStatus;
        commonFunctions.clickElement(mintTitle, 10, "Home");
        boolean shareIconLatestPageStatus = checkShareIcon(latestPage, "Latest Page Share");
        commonFunctions.clickElement(mintTitle, 10, "Home");
        boolean shareIconPremiumPageStatus = checkShareIcon(premiumPage, "Premium Share");
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(explore, 10, "Explore");
        boolean shareIconNewsPageStatus = checkShareIcon(news, "News Share");
        boolean shareIconStoryDetailPageStatus = checkHamburgerSocialMediaShare(globalVars.getAmpUrl() + "-topic/long-story");
        boolean shareIconSubNewsDetailPageStatus = checkHamburgerSocialMediaShare(globalVars.getAmpUrl() + "-companies/news");
        boolean shareIconStockMarketPageStatus = checkHamburgerSocialMediaShare(globalVars.getAmpUrl() + "-market/stock-market-news");
        checkShareIconsHomePage();

        if (shareIconLatestPageStatus  && shareIconPremiumPageStatus && shareIconSubNewsDetailPageStatus && shareIconStockMarketPageStatus && shareIconNewsPageStatus && shareIconStoryDetailPageStatus)
            shareStoryStatus = true;
        else
            shareStoryStatus = false;

        return shareStoryStatus;
    }

    public boolean checkShareIconsHomePage() {
        commonFunctions.clickElement(homePage, 60, "Home Page");
        commonFunctions.clickElement(homeStoryHeadLine, 60, "Home Story");
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(facebookIcon, "Scroll");
        boolean facebookIconShareViaPageStatus = commonFunctions.isElementClickable(facebookIcon, 60, "Facebook Icon");
        boolean twitterIconShareViaPageStatus = commonFunctions.isElementClickable(linkedinIcon, 60, "LinkedIn Icon");
        boolean linkedInIconShareViaPageStatus = commonFunctions.isElementClickable(twitterIcon, 60, "Twitter Icon");
        boolean whatsAppIconShareViaPageStatus = commonFunctions.isElementClickable(whatsappIcon, 60, "Whatsapp Icon");
        boolean clickTwitterShareStatus = checkShareIconsUrl(twitterIcon, "twitter.com", "Twitter Icon");
        boolean clickFacebookShareStatus = checkShareIconsUrl(facebookIcon, "facebook.com", "Facebook Icon");
        if (facebookIconShareViaPageStatus && twitterIconShareViaPageStatus && linkedInIconShareViaPageStatus && whatsAppIconShareViaPageStatus && clickFacebookShareStatus && clickTwitterShareStatus)
            return true;
        else
            return false;
    }

    public boolean checkShareIconsUrl(WebElement element, String expectedText, String elementName) {
        boolean clickShareIconStatus;

        if (expectedText.equalsIgnoreCase("twitter.com")) {
            String expectedURL = checkSocialMediaShare(element, elementName, expectedText);
            expectedURL = ((expectedURL.substring(expectedURL.indexOf("%2F") + 1)).replaceAll("2F%2F", "")).replaceAll("%2F", "");
            String actualURL = commonFunctions.getCurrentURL();
            actualURL = ((actualURL.replaceAll("https://", "")).replaceAll("/", "")).replaceAll("amp", "");
            clickShareIconStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "URL");
        } else if (expectedText.equalsIgnoreCase("facebook.com")) {
            String expectedURL = checkSocialMediaShare(element, elementName, expectedText);
            expectedURL = (((expectedURL.substring(0, expectedURL.indexOf(".html"))).substring(expectedURL.indexOf("w.") + 1)).replaceAll("%252F", "")).replaceAll("F", "");
            String actualURL = commonFunctions.getCurrentURL();
            actualURL = ((((actualURL.replaceAll("https://", "")).replaceAll("/", "")).replaceAll("amp", "")).replaceAll(".html", "")).replace("www", "");
            clickShareIconStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "URL");
        } else
            clickShareIconStatus = false;

        return clickShareIconStatus;
    }

    public boolean checkHamburgerSocialMediaShare(String url) {
        boolean shareIconStatus;
        commonFunctions.navigateToURL(url);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(stockMarketHeadline, 60, "Sub News Story Headline");
        boolean facebookIconPageStatus = commonFunctions.isElementClickable(storyDetailFacebookIcon, 60, "Facebook Icon in Story Detail");
        boolean twitterIconPageStatus = commonFunctions.isElementClickable(storyDetailTwitterIcon, 60, "Twitter Icon  in Story Detail");
        boolean linkedInIconPageStatus = commonFunctions.isElementClickable(storyDetailLinkedinIcon, 60, "LinkedIn Icon  in Story Detail");
        boolean whatsAppIconPageStatus = commonFunctions.isElementClickable(storyDetailWhatsappIcon, 60, "Whatsapp Icon in Story Detail");
        if (facebookIconPageStatus && twitterIconPageStatus && linkedInIconPageStatus && whatsAppIconPageStatus)
            shareIconStatus = true;
        else
            shareIconStatus = false;

        return shareIconStatus;
    }

    public String checkSocialMediaShare(WebElement element, String elementName, String elementExpected) {
        String checkSocialMediaShare;
        String parentWin = globalVars.getAppiumDriver().getWindowHandle();
        commonFunctions.clickElement(element, 60, elementName);
        commonFunctions.waitForPageLoading();
        String subWindowHandler = null;
        Set<String> handles = globalVars.getAppiumDriver().getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        commonFunctions.switchToWindow(subWindowHandler);
        commonFunctions.checkTextContains(elementExpected, commonFunctions.getCurrentURL(), "Text Contains");
        checkSocialMediaShare = commonFunctions.getCurrentURL();
        commonFunctions.closeAllWindowsExceptMasterTab();
        globalVars.getAppiumDriver().switchTo().window(parentWin);
        commonFunctions.waitForPageLoading();
        return checkSocialMediaShare;
    }

    public boolean checkShareIcon(WebElement element, String elementName) {
        boolean checkShareIconStatus;
        commonFunctions.clickElement(element, 10, elementName);
        commonFunctions.clickElement(storyPage, 10, "Open first Story");
        commonFunctions.waitForPageLoading();
        boolean facebookIconShareViaPageStatus;
        boolean twitterIconShareViaPageStatus;
        boolean linkedInIconShareViaPageStatus;
        boolean whatsAppIconShareViaPageStatus;
        if(commonFunctions.getCurrentURL().contains("amp-")) {
            commonFunctions.scrollToElement(facebookIcon, "Facebook");
            facebookIconShareViaPageStatus = commonFunctions.isElementClickable(facebookIcon, 10, "Facebook Icon");
            twitterIconShareViaPageStatus = commonFunctions.isElementClickable(linkedinIcon, 10, "LinkedIn Icon");
            linkedInIconShareViaPageStatus = commonFunctions.isElementClickable(twitterIcon, 10, "Twitter Icon");
            whatsAppIconShareViaPageStatus = commonFunctions.isElementClickable(whatsappIcon, 10, "Whatsapp Icon");
        }
        else
        {
            commonFunctions.scrollToElement(facebookIconNonAMP, "Facebook");
            facebookIconShareViaPageStatus = commonFunctions.isElementClickable(facebookIconNonAMP, 10, "Facebook non amp Icon");
            twitterIconShareViaPageStatus = commonFunctions.isElementClickable(linkedinIconNonAMP, 10, "LinkedIn non amp  Icon");
            linkedInIconShareViaPageStatus = commonFunctions.isElementClickable(twitterIconNonAMP, 10, "Twitter non amp Icon");
            whatsAppIconShareViaPageStatus = commonFunctions.isElementClickable(whatsappIconNonAMP, 10, "Whatsapp non amp Icon");

        }
        System.out.println(elementName);
        if (facebookIconShareViaPageStatus && twitterIconShareViaPageStatus && linkedInIconShareViaPageStatus && whatsAppIconShareViaPageStatus)
            checkShareIconStatus = true;
        else
            checkShareIconStatus = false;
        return checkShareIconStatus;
    }


    public boolean checkPageURLandTitle(WebElement element, String elementName, String expectedTextURL, String expectedTextTitle, int timeOutInSecond) {
        boolean checkPageURLandTitleStatus;
        boolean PageNameTextColorStatus;
        commonFunctions.clickElementWithJS(element, timeOutInSecond, elementName);
        commonFunctions.waitForURLToBe(globalVars.getURL() + expectedTextURL);
        commonFunctions.dummyWait(10);
        commonFunctions.checkPageURL(globalVars.getURL() + expectedTextURL, timeOutInSecond, elementName);
        commonFunctions.checkPageTitle(expectedTextTitle, timeOutInSecond, elementName);
        commonFunctions.dummyWait(10);
        checkPageURLandTitleStatus = commonFunctions.isElementDisplayed(pageContent, timeOutInSecond, elementName);
        PageNameTextColorStatus = commonFunctions.checkCSSProperty(element, "color", "rgba(255, 138, 0, 1)", elementName);
        if (PageNameTextColorStatus && checkPageURLandTitleStatus)
            return true;
        else
            return false;
    }

    @Override
    public boolean siteMap(String siteMapURL) {
        return false;
    }

    @Override
    public boolean myAccountFunctionality(String password, String newPassword, String expectedUserName, String newName, String email, String manageProfileURL) {
        return false;
    }

    @Override
    public boolean subscribedUserPaywall() {
        return false;
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
        return false;
    }

    @Override
    public boolean checkHomePageSrollsTillEnd() {
        return false;
    }

    @Override
    public boolean checkEPaperSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkEPaperNonSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkMintLogo() {
        return mintLogo.isDisplayed();
    }

    @Override
    public boolean checkMintLogoLocation() {
        return false;
    }

    @Override
    public boolean checkBottomNavigation() {
        return false;
    }

    @Override
    public boolean checkBottomNavigationAllPages() {
        return false;
    }

    @Override
    public boolean checkBottomNavigationFocus() {
        return false;
    }

    @Override
    public boolean clickAndVerifyMintLoungeStory() {
        return false;
    }
    @Override
    public boolean checkViewAllButtonOnMintPremium() {
 return false;
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
            return false;
        }

    @Override
    public boolean checkAndVerifyViewAllOnMintLoungeCarousel() {
        return false;
    }

    public boolean checkHamburger() {
        boolean checkHamburgerStatus;
        commonFunctions.clickElementWithJS(explore, 10, "explore");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithCoordinates(1000, 500);
        commonFunctions.dummyWait(10);
        boolean isHamburgerPresentAfterClickingOutside = commonFunctions.isElementNotDisplayed(hamburgerElement2,30,"hamburgerElement");
        commonFunctions.clickElementWithJS(explore, 10, "explore");
        boolean isHamburgerPresent = commonFunctions.isElementDisplayed(hamburgerElement, 30, "hamburgerElement");
        boolean isHamburgerNotBlank = checkHamburgerNotBlank();
        checkTopMostHamburgerElements();
        boolean checkLinksInHamburgerStatus = checkAllLinksInHamburger();

        if (isHamburgerPresent && isHamburgerNotBlank && checkLinksInHamburgerStatus && isHamburgerPresentAfterClickingOutside) {
            checkHamburgerStatus = true;
        } else {
            checkHamburgerStatus = false;
        }
        return checkHamburgerStatus;
    }

    public boolean checkAllLinksInHamburger() {
        boolean checkAllLinksInHamburgerStatus;
        boolean isLinkClickable = false;
        boolean isLinkDisplayed = false;
        boolean isURLCorrectStatus = false;
        boolean isPageBrokenStatus = false;

        try {
            for (int i = 0; i < 2; i++) {
                commonFunctions.waitForPageLoading(10);
                commonFunctions.scrollToElement(hamburgerList.get(i), 10,"Scrolled to:: " + i);
                String hrefValue = hamburgerList.get(i).getAttribute("href");
                String propValue = hamburgerList.get(i).getAttribute("text").toLowerCase();
                isLinkDisplayed = commonFunctions.isElementDisplayed(hamburgerList.get(i), 10, propValue);
                isLinkClickable = commonFunctions.isElementClickable(hamburgerList.get(i), 10, propValue);
                commonFunctions.clickElementWithJS(hamburgerList.get(i),10,propValue);
                //hamburgerList.get(i).click();
                commonFunctions.waitForTheURLContains("text");
                commonFunctions.waitForPageLoading(10);
                isURLCorrectStatus = commonFunctions.checkPageURL(hrefValue, 10, "");
                isPageBrokenStatus = commonFunctions.isElementNotDisplayed(error, 10, "error");
                commonFunctions.clickElement(explore, 10, "explore");
            }
        } catch (Exception e) {
            Utils.logStepInfo(e.getMessage());
        }
        if (isLinkClickable && isLinkDisplayed && isURLCorrectStatus && isPageBrokenStatus) {
            checkAllLinksInHamburgerStatus = true;
        } else {
            checkAllLinksInHamburgerStatus = false;
        }
        return checkAllLinksInHamburgerStatus;

    }

    public boolean checkHamburgerNotBlank() {
        boolean checkHamburgerNotBlankStatus = false;
        try {
            if (hamburgerList.size() != 0) {
                checkHamburgerNotBlankStatus = true;
                Utils.logStepInfo("Hamburger List Not Blank");
            } else {
                checkHamburgerNotBlankStatus = false;
                Utils.logStepInfo("Hamburger List is Blank");
            }
        } catch (Exception e) {
            checkHamburgerNotBlankStatus = true;
            e.printStackTrace();
        }
        return checkHamburgerNotBlankStatus;
    }

    public boolean checkElementNotPresent(WebElement element) {
        boolean isElementStatus;
        try {
            if (!element.isDisplayed()) {
                isElementStatus = true;
                Utils.logStepInfo(element + "::Element Not present");
            } else {
                isElementStatus = false;
                Utils.logStepInfo(element + "::Element Present");
            }

        } catch (Exception e) {
            isElementStatus = true;
            e.printStackTrace();
        }
        return isElementStatus;
    }

    public boolean checkTopMostHamburgerElements() {
        boolean checkAllLinksInHamburgerStatus = true;
        boolean isLinkClickable;
        boolean isLinkDisplayed;

        try {
            for (int i = 0; i < hamburgerTopmost.size(); i++) {
                isLinkDisplayed = commonFunctions.isElementDisplayed(hamburgerTopmost.get(i), 10, hamburgerTopmost.get(i).getAttribute("text"));
                isLinkClickable = commonFunctions.isElementClickable(hamburgerTopmost.get(i), 10, hamburgerTopmost.get(i).getAttribute("text"));
                if (isLinkDisplayed && isLinkClickable) {
                    checkAllLinksInHamburgerStatus = true;
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            checkAllLinksInHamburgerStatus = false;
            e.printStackTrace();

        }
        return checkAllLinksInHamburgerStatus;
    }

    @Override
    public boolean storyPage(){
        boolean storyPageStatus;
        boolean notificationStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        notificationStatus=commonFunctions.isElementDisplayed(notificationPopup);
        if(notificationStatus) {
            commonFunctions.clickElement(denyNotification, 10, "I'll do this later Notification");
        }
        commonFunctions.isElementDisplayed(homeStoryHeadLine, 10, "First Story");
        commonFunctions.clickElementWithJS(homeStoryHeadLine, 10, "First Story");
        commonFunctions.waitForPageLoading();

        boolean checkURLChangedToStoryURLStatus = checkStoryURLIsAmpURL();
        String storyURL=commonFunctions.getCurrentURL();


        boolean checkShareIconStatus = checkShareIcon();
        commonFunctions.scrollToTop();

        boolean checkBreadFormatStatus =checkBreadcrumsFormat();
        boolean checkBreadcrumsHeadline=checkBreadcrumsHeadline();
        boolean checkBreadcrumsSectionStatus = checkBreadcrumsSection(breadcrumsSection,"Section");
        if(!commonFunctionsMobileLM.waitForURLContains(".html"))
        {
            commonFunctions.navigateToURL(storyURL);
            commonFunctionsMobileLM.waitForURLContains(".html");
        }

        boolean checkBreadcrumsSubSectionStatus = checkBreadcrumsSection(breadcrumsSubSection,"Sub Section");
        if( !commonFunctionsMobileLM.waitForURLContains(".html"))
        {
            commonFunctions.navigateToURL(storyURL);
            commonFunctionsMobileLM.waitForURLContains(".html");
        }

        boolean checkBreadcrumsHomeStatus=checkBreadcrumsSection(breadcrumsHome,"Home");
        if( !commonFunctionsMobileLM.waitForURLContains(".html"))
        {
            commonFunctions.navigateToURL(storyURL);
            commonFunctionsMobileLM.waitForURLContains(".html");
        }


        if (checkURLChangedToStoryURLStatus  && checkShareIconStatus && checkBreadcrumsSectionStatus && checkBreadcrumsSubSectionStatus && checkBreadcrumsHomeStatus && checkBreadFormatStatus && checkBreadcrumsHeadline)
            storyPageStatus = true;
        else
            storyPageStatus = false;

        return storyPageStatus;
    }

    @Override
    public boolean shareStory()
    {
        return true;
    }

    public boolean checkBreadcrumsFormat(){
        boolean checkBreadcrumsFormat =true;
        String ExceptedBreadcrums = commonFunctions.getElementText(breadcrums);
        ExceptedBreadcrums = ExceptedBreadcrums.replaceAll(" ","");
            checkBreadcrumsFormat = ExceptedBreadcrums.matches("[a-zA-Z]+\\/[a-zA-Z]+\\/[a-zA-Z\\W]+\\/[a-zA-Z0-9\\W]*");
        return checkBreadcrumsFormat;
    }

    public boolean checkBreadcrumsHeadline(){
        boolean checkBreadcrumsFormat;
        checkBreadcrumsFormat =checkType();
        commonFunctions.checkCSSProperty(breadcrums,"color","rgba(117, 117, 117, 1)","HeadLine Color");
        return checkBreadcrumsFormat;
    }


    public boolean checkBreadcrumsSection(WebElement element, String elementName){
        boolean checkBreadcrumsStatus;
        commonFunctions.isElementClickable(element,10,elementName);
        String expectedURL=commonFunctions.getProperty(element,"href");
        commonFunctions.checkCSSProperty(element,"color","rgba(247, 148, 30, 1)","Check Color");
        commonFunctions.clickElementFluentWait(element,10,elementName);
        checkBreadcrumsStatus = commonFunctions.checkTextContains(expectedURL, commonFunctions.getCurrentURL(), "URL Validate Successfully");
        commonFunctions.navigateBack();
        return checkBreadcrumsStatus;
    }


    public boolean checkShareIcon(){
        boolean checkShareIcon;
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(facebookIcon,"Scroll");
        boolean facebookIconShareViaPageStatus = commonFunctions.isElementClickable(facebookIcon, 60, "Facebook Icon");
        boolean twitterIconShareViaPageStatus = commonFunctions.isElementClickable(linkedinIcon, 60, "LinkedIn Icon");
        boolean linkedInIconShareViaPageStatus = commonFunctions.isElementClickable(twitterIcon, 60, "Twitter Icon");
        boolean whatsAppIconShareViaPageStatus = commonFunctions.isElementClickable(whatsappIcon, 60, "Whatsapp Icon");

        if(facebookIconShareViaPageStatus && twitterIconShareViaPageStatus && linkedInIconShareViaPageStatus && whatsAppIconShareViaPageStatus )
            checkShareIcon=true;
        else
            checkShareIcon=false;

        return  checkShareIcon;
    }

    @Override
    public boolean apiForFirstStory(String[] params) {
        boolean apiForFirstStoryStatus;
        String apiURL=params[0];
        commonFunctions.scrollToTop();
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForURLToBe(globalVars.getURL());
        commonFunctions.clickElementWithJS(homeStoryHeadLine, 30, "First Story");
        commonFunctions.waitForURLContains(".html");
        String storyId = commonFunctions.getStoryIdFromURL();
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        boolean checkHeadlineInAPIStatus = checkHeadlineInAPI(response);
        boolean checkSummaryInAPIStatus = checkSummaryInAPI(response);
        boolean checkCaptionInAPIStatus = checkCaptionInAPI(response);
        boolean checkParagraphInAPIStatus = checkParagraphInAPI(response);
        boolean checkSectionInAPIStatus = checkSectionInAPI(response);
        boolean checkSubSectionInAPIStatus =checkSubSectionInAPI(response);
        if (checkHeadlineInAPIStatus && checkSectionInAPIStatus && checkSummaryInAPIStatus && checkSubSectionInAPIStatus &&checkCaptionInAPIStatus && checkParagraphInAPIStatus) {
            apiForFirstStoryStatus = true;
        } else {
            apiForFirstStoryStatus = false;
        }
        return apiForFirstStoryStatus;
    }


    @Override
    public boolean pageTitle() {
        boolean pageTitleStatus;
        commonFunctions.navigateToURL(globalVars.getURL());

        commonFunctions.dummyWait(10);
        boolean checkHomePageTitleStatus = checkPageTitle(homePage,"" ,"Business News Today: Read Latest Business News, Live India Share Market News, Finance & Economy News | Mint", "Mint Home Page Title");
        boolean checkLatestPageTitleStatus = checkPageTitle(latestPage,"-latest-news", "Latest News Today: Latest News Headlines, Breaking News, Current News | Mint", "Mint Latest Page Title");
        /*boolean checkTrendingPageTitleStatus = checkPageTitle(trendingPage,"-mostpopular","Trending News: Today's Trending News, Viral News, Popular News Headlines - Mint", "Mint Trending Page Title");
        boolean checkPremiumPageTitleStatus = checkPageTitle(premiumPage,"-premium", "Read Premium News and Stories on Mint", "Mint Premium Page Title");
        commonFunctions.clickElement(explore, 60, "Explore");
        commonFunctions.clickElement(news, 60, "news");
        boolean checkNewsArticleTitleStatus = commonFunctions.checkPageTitle( "News: Latest Breaking News, National News, World News - Mint", 60,"Section Title");
        commonFunctions.clickElement(explore, 60, "Explore");
        commonFunctions.clickElementWithJS(marketsArrow, 60, "marketsArrow");
        commonFunctions.scrollToElement(marketsArrow, "marketsArrow");
        commonFunctions.clickElementWithJS(stockMarket);
        commonFunctions.clickElementWithJS(stockMarketHeadline);
        commonFunctions.waitForURLContains(".html");
        String expectedText=storyDetailPage.getText();
        boolean checkStockMarketTitleStatus = commonFunctions.checkPageTitle(expectedText,60,"Story Headline");
        commonFunctions.waitForPageLoading();
        String subNewsUrl = globalVars.getAmpUrl()+"-companies/news";
        commonFunctions.navigateToURL(subNewsUrl);
        boolean checkSubSectionPageTitleStatus = commonFunctions.checkPageTitle("Company News: Latest Company News, Indian Company News, Company News Headlines",30,  "News Subsection");
        String longStoryURL = globalVars.getAmpUrl() + "-topic/long-story-short";
        commonFunctions.navigateToURL(longStoryURL);
        boolean checkLongStoryTitleStatus = commonFunctions.checkPageTitle("Long Story Short Videos", 60, "long story title");
*/
        if (checkHomePageTitleStatus && checkLatestPageTitleStatus ){//&& checkTrendingPageTitleStatus && checkPremiumPageTitleStatus && checkStockMarketTitleStatus && checkNewsArticleTitleStatus && checkSubSectionPageTitleStatus && checkLongStoryTitleStatus) {
            pageTitleStatus = true;
        } else {
            pageTitleStatus = false;
        }
        return pageTitleStatus;
    }

    public boolean checkPageTitle(WebElement element,String Url, String expectedText, String elementName) {
        boolean checkPageTitleStatus;
        boolean pageNameTextColorStatus;
        boolean pageTitleStatus;
        commonFunctions.clickElement(element, 10, elementName);
        commonFunctions.waitForURLToBe(globalVars.getURL()+Url);
        pageTitleStatus = commonFunctions.checkPageTitle(expectedText, 10, elementName);
        pageNameTextColorStatus = commonFunctions.checkCSSProperty(element, "color", "rgba(255, 138, 0, 1)", elementName);
        if (pageTitleStatus && pageNameTextColorStatus) {
            checkPageTitleStatus = true;
        } else {
            checkPageTitleStatus = false;
        }
        return checkPageTitleStatus;
    }


    public boolean checkSectionInAPI(Response response){
        boolean checkSectionInAPIStatus;
        String expectedSectionFromAPI = RestUtils.getValueFromResponse(response, "content[0].metadata");
        expectedSectionFromAPI = expectedSectionFromAPI.substring(6, expectedSectionFromAPI.indexOf("/",expectedSectionFromAPI.indexOf("/")+1));
        String actualSectionFromUI = commonFunctions.getElementText(breadcrumsSection);
        checkSectionInAPIStatus = commonFunctions.checkTextContains(expectedSectionFromAPI.toLowerCase(), actualSectionFromUI.toLowerCase(), "Section in API");
        return checkSectionInAPIStatus;
    }

    public boolean checkSubSectionInAPI(Response response){
        boolean checkSubSectionInAPIStatus;
        String expectedSubSectionFromAPI = RestUtils.getValueFromResponse(response, "content[0].metadata");
        expectedSubSectionFromAPI = expectedSubSectionFromAPI.substring(6, expectedSubSectionFromAPI.indexOf("/",expectedSubSectionFromAPI.indexOf("/",expectedSubSectionFromAPI.indexOf("/")+1)+1));
        expectedSubSectionFromAPI = expectedSubSectionFromAPI.substring(expectedSubSectionFromAPI.indexOf("/")+1);
        String actualSubSectionFromUI = breadcrumsSubSection.getAttribute("href");
        actualSubSectionFromUI = actualSubSectionFromUI.substring(actualSubSectionFromUI.indexOf('/')+1);
        checkSubSectionInAPIStatus = commonFunctions.checkTextContains(expectedSubSectionFromAPI.toLowerCase(), actualSubSectionFromUI.toLowerCase(), "SubSection in API");
        return checkSubSectionInAPIStatus;
    }

    @Override
    public boolean bookmarkStory() {
        return true;
    }

    @Override
    public boolean bookmarkStoryLoggedInUser() {
        boolean bookmarkStatus = false;
        commonFunctions.clickElementWithJS(mintTitle, 60, "Close My Account Button");
        commonFunctions.clickElementWithJS(imageOtherPagesfirstStory, 60, "Image First Story");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.isElementDisplayed(bookmarkIcon, 60, "BookMark Icon");
        commonFunctions.isElementClickable(bookmarkIcon, 60, "BookMark Icon");
        commonFunctions.clickElement(closeMyAccount, 45, "Close My Account Button");
        commonFunctions.closePopupIfExist(closeButtonForUnlimitedDigitalAccessPopup, "Unlimited Digital Access");
        commonFunctions.scrollToElement(bookmarkFirstIcon, "BookMark First Icon");
        String classProperty = commonFunctions.getProperty(bookmarkIcon, "class");
        if (!classProperty.contains("active")) {
            commonFunctions.clickElement(bookmarkIcon, 60, "BookMark Icon");
            classProperty = commonFunctions.getProperty(bookmarkIcon, "class");
        }
        if (classProperty.contains("active")) {
            Utils.logStepInfo(true, "Bookmark Icon class property contains active");
            bookmarkStatus = true;
        } else {
            Utils.logStepInfo(false, "Bookmark Icon class property not contains active");
        }
        commonFunctions.clickElement(myAccount, 60, "My Account");
        return bookmarkStatus;
    }

    public boolean checkStoryURLIsAmpURL() {
        boolean checkStoryURLIsAmpURLStatus;
        String expectedURL = "/amp-"+commonFunctions.getStoryIdFromURL()+".html";
        commonFunctions.waitForURLContains(".html");
        String actualURL = commonFunctions.getCurrentURL();
        System.out.println(actualURL.contains(expectedURL));
        checkStoryURLIsAmpURLStatus =actualURL.contains(expectedURL);
        return checkStoryURLIsAmpURLStatus;
    }

    public boolean checkOpenAppIsSticky(){
        boolean checkOpenAppIsStickyStatus;
        commonFunctions.isElementDisplayed(openApp,60,"OPEN APP");
        commonFunctions.isElementClickable(openApp,60,"OPEN APP");
        checkOpenAppIsStickyStatus = commonFunctions.checkCSSProperty(openApp, "position", "fixed", "OPEN APP");
        return checkOpenAppIsStickyStatus;
    }

    public boolean checkHeadlineInAPI(Response response) {
        boolean checkHeadlineInAPIStatus;
        String expectedHeadlineFromAPI = RestUtils.getValueFromResponse(response, "content[0].headline");
        expectedHeadlineFromAPI = expectedHeadlineFromAPI.replaceAll("&nbsp;", " ");
        expectedHeadlineFromAPI = expectedHeadlineFromAPI.replaceAll("\\s{2,}", " ");
        expectedHeadlineFromAPI = expectedHeadlineFromAPI.replaceAll("<span>", "");
        expectedHeadlineFromAPI = expectedHeadlineFromAPI.replaceAll("</span>", "");
        expectedHeadlineFromAPI = expectedHeadlineFromAPI.replaceAll("<span class='webrupee'>", "");
        expectedHeadlineFromAPI = expectedHeadlineFromAPI.trim();
        expectedHeadlineFromAPI = Utils.formatAPIText(expectedHeadlineFromAPI);
        String actualHeadlineFromUI = commonFunctions.getElementText(openHomeStoryPage);
        checkHeadlineInAPIStatus = commonFunctions.checkTextContains(expectedHeadlineFromAPI, actualHeadlineFromUI, "Headline in API");
        return checkHeadlineInAPIStatus;
    }

    public boolean checkSummaryInAPI(Response response) {
        boolean checkSummaryInAPIStatus;
        String expectedSummaryFromAPI = RestUtils.getValueFromResponse(response, "content[0].listElement[0].paragraph.body");
        expectedSummaryFromAPI = expectedSummaryFromAPI.replaceAll("<p>", "");
        expectedSummaryFromAPI = expectedSummaryFromAPI.replaceAll("</p>", "");
        expectedSummaryFromAPI = Utils.formatAPIText(expectedSummaryFromAPI);
        expectedSummaryFromAPI=expectedSummaryFromAPI.trim();
        String actualSummaryFromUI = commonFunctions.getElementText(summary,30);
        actualSummaryFromUI=actualSummaryFromUI.trim();
        checkSummaryInAPIStatus = commonFunctions.checkTextContains(expectedSummaryFromAPI, actualSummaryFromUI, "Summary in API");
        return checkSummaryInAPIStatus;
    }

    public boolean checkCaptionInAPI(Response response) {
        boolean checkCaptionInAPIStatus;
        String expectedCaptionFromAPI = RestUtils.getValueFromResponse(response, "content[0].leadMedia.image.caption");
        //expectedCaptionFromAPI=expectedCaptionFromAPI.replaceAll(",","");
        expectedCaptionFromAPI = Utils.formatAPIText(expectedCaptionFromAPI);
        String actualCaptionFromUI = commonFunctions.getElementText(imageCaption);
        actualCaptionFromUI=actualCaptionFromUI.trim();
        checkCaptionInAPIStatus = commonFunctions.checkTextContains(expectedCaptionFromAPI, actualCaptionFromUI, "Caption in API");
        return checkCaptionInAPIStatus;
    }
    public String processString(String expectedValue) {
        expectedValue = expectedValue.replaceAll("amp;", "");
        expectedValue = expectedValue.replaceAll("<p>", "");
        expectedValue = expectedValue.replaceAll("</p>", "");
        expectedValue = expectedValue.replaceAll("&nbsp;", "");
        expectedValue = expectedValue.replaceAll("\\s{2,}", " ");
        //expectedValue = expectedValue.replaceAll("<span>", "");
        expectedValue = expectedValue.replaceAll("</span>", "");
        expectedValue = expectedValue.replaceAll("<span class='webrupee'>", "");
        expectedValue = expectedValue.trim();
        return expectedValue;
    }

    public boolean checkParagraphInAPI(Response response) {
        boolean checkParagraphInAPIStatus;
        String expectedParagraphFromAPI = RestUtils.getValueFromResponse(response, "content[0].listElement[0].paragraph.body");
        expectedParagraphFromAPI = expectedParagraphFromAPI.replaceAll("amp;", "");
        expectedParagraphFromAPI = expectedParagraphFromAPI.replaceAll("<p>", "");
        expectedParagraphFromAPI = expectedParagraphFromAPI.replaceAll("</p>", "").trim();
        expectedParagraphFromAPI = Utils.formatAPIText(expectedParagraphFromAPI);
        expectedParagraphFromAPI=expectedParagraphFromAPI.substring(expectedParagraphFromAPI.indexOf(":")+1,expectedParagraphFromAPI.length());
        String actualParagraphFromUI = commonFunctions.getElementText(paragraph);
        actualParagraphFromUI=actualParagraphFromUI.substring(actualParagraphFromUI.indexOf(":") + 1, actualParagraphFromUI.length());
        checkParagraphInAPIStatus = commonFunctions.checkTextContains(expectedParagraphFromAPI, actualParagraphFromUI, "Paragraph in API");
        return checkParagraphInAPIStatus;
    }

    public boolean checkType(){
        boolean checkBreadcrumHeadline;
        try{
            checkBreadcrumHeadline=commonFunctions.isElementClickable(breadcrumsHeadline,10,"BreadCrum HeadLine");
            if(checkBreadcrumHeadline)
                checkBreadcrumHeadline= false;
            else
                checkBreadcrumHeadline= true;
        }catch(Exception ex){
            checkBreadcrumHeadline = true;
        }
        return checkBreadcrumHeadline;
    }
    /*public static void closeAllThePopups(){
        commonFunctions.switchToFrame(googleAdFrame, 10,"Google Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup, "Close button in google popup", 6);
        commonFunctions.switchToFrame(googleAdFrame2, 10,"Google Ad Frame2");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup2, "Close button in google popup", 6);
        commonFunctions.switchToFrame(notificationAdFrame, 5,"Notification Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonInFivePercentDiscountAdPopup, "Close button in Five percent discount popup", 6);
        commonFunctions.switchToDefaultContent();
    }*/
    @Override
    public boolean checkSignInLink() { return false; }
    @Override
    public boolean checkSubscribeLink() {
        return false;
    }
    @Override
    public boolean checkSubscribeRedirection(String choosePlan) { return false; }
    @Override
    public boolean checkSignInLinkRedirection(String loginRegisterText, String google, String facebook, String apple, String emailOrMobile) {
        return false;
    }

    @Override
    public boolean checkRemoveAdButtonFunctionality() {
        return false;
    }

    @Override
    public boolean checkAdvertisementLabelAndRemoveAdsButtonPosition(String advertisement, String removeAd) {
        return false;
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryOn() {
        return false;
    }

    @Override
    public boolean checkVisibilityOfSponsoredStoryOnHomePage() {
        return false;
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryOnHomePage() {
        return false;
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryBookmarkButtonHomePage() {
        return false;
    }

    @Override
    public boolean checkStoryNavigationWSJCrousel(String text) { return false; }
    @Override
    public boolean checkBottomNavigationSection() { return false; }
    @Override
    public boolean checkMyAccountLink() {return false;}
    @Override
    public void clickOnHomeButtonWithHandlingDarkMode() {}

    @Override
    public boolean subscribedUserAdsFreeHomepage() {
        return false;
    }
    @Override
    public boolean checkHomePage() {return false;}
    @Override
    public boolean subscribedUserAdsFreeApp() {return false;}
    @Override
    public boolean sponsoredStory() {return false;}

    @Override
    public boolean checkBookmarkBeforeLogin() {
        return false;
    }

    @Override
    public boolean checkBrandedContent() {
        return false;
    }

    @Override
    public boolean checkInVisibilityOfNewArticleAfterRefreshedHomePage() {
        return false;
    }

    @Override
    public boolean checkInVisibilityOfNewArticleOnHomePageAfterClickOnNewArticle() {
        return false;
    }

    @Override
    public boolean checkNewArticlesOnlyOnHomePage() {
        return false;
    }

    @Override
    public boolean checkAppRefreshFunctionality() {
        return false;
    }

    @Override
    public boolean checkExploreHamburgerPosition(String iosExplorePos, String androidExplorePos) {
        return false;
    }

    @Override
    public boolean checkNewsSectionReplacingLatestSection() {
        return false;
    }

    @Override
    public boolean newsLetterFunctionalityAndDesign() {
        return false;
    }

    @Override
    public boolean checkNoAdsOnHomePage() {
        return false;
    }

    @Override
    public boolean checkExploreAsHamburger() {
        return false;
    }

    @Override
    public boolean checkExploreRemoveFromNavigation() {
        return false;
    }

    @Override
    public boolean checkEPaperIcon() {
        return false;
    }

    @Override
    public boolean checkAdOnHomePage() {
        return false;
    }

    @Override
    public boolean checkAdOnStoryDetailPagePage() {
        return false;
    }

    @Override
    public boolean checkSubscribeIcon() {
        return false;
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean checkMyaccountIcon() {
        return false;
    }

    @Override
    public boolean checkMarketCardtypePagefunctionality() {
        return false;
    }


    @Override
    public boolean checkMutualFundsWidgetAndSubCategoryDropDown() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        return false;
    }

    @Override
    public boolean checkMutualFundWidgetTitle() {
        return false;
    }

    @Override
    public boolean checkSubCategoryDropDown() {
        return false;
    }

    @Override
    public boolean checkSubCategoryDefaultSection() {
        return false;
    }

    @Override
    public boolean checkMutualFundCategoryTabs() {
        return false;
    }

    @Override
    public boolean checkSubTitleoFMutualFundPage() {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAllFunctionality() {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAllFunctionality() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesList() {
        return false;
    }

    @Override
    public boolean checkIndicesSection() {
        return false;
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
        return false;
    }

    @Override
    public boolean checkTopGainersViewAll() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAll() {
        return false;
    }

    @Override
    public boolean checkGainerLosersDesign(String gainerLoserText) {
        return false;
    }

    @Override
    public boolean checkBseTabsGainerLosers() {
        return false;
    }

    @Override
    public boolean checkNseTabsGainerLosers() {
        return false;
    }

    @Override
    public boolean checkBse100NewsSection() {
        return false;
    }

    @Override
    public boolean checkIndicesRedirectionFunctionality() {
        return false;
    }

    @Override
    public boolean checkTickerStockMarketNiftyAndSenSex() {
        return false;
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
    public boolean checkMostActiveByVolume() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeDesign() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeViewAll() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageDesign() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageInfo() {
        return false;
    }

    @Override
    public boolean checkFinancialStandalone() {
        return false;
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
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageGainerLoser() {
        return false;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageCompanyInfo() {
        return false;
    }

    @Override
    public boolean checkGainerLoserFinancialStandalone() {
        return false;
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
        return false;
    }

    @Override
    public boolean checkMarketTickerNiftyBankDetailPage() {
        return false;
    }

    @Override
    public boolean checkNewEpaperIconOnTop() {
        return false;
    }

    @Override
    public boolean checkNewSignInIconOnTop() {
        return false;
    }

    @Override
    public boolean checkNewSubscribeIconOnTop() {
        return false;
    }

    @Override
    public boolean checkL1TabOnHomePage() {
        return false;
    }

    @Override
    public boolean checkL1TabSelection() {
        return false;
    }

    @Override
    public boolean checkL1TabBackButtonFunctionality() {
        return false;
    }

    @Override
    public boolean checkFocusOnL1TabClickingOnHomeButton() {
        return false;
    }

    @Override
    public boolean checkL1MenuSelectionBySwipingTheHomePage() {
        return false;
    }

    @Override
    public boolean checkTickerCategoryD() {
        return false;
    }

    @Override
    public boolean checkSectionNameWithListedStory() {
        return false;
    }

    @Override
    public boolean checkTickerArrow() {
        return false;
    }

    @Override
    public boolean checkLatestScrollOnLatestNewsPage() {
        boolean isScrollWorked=false;
        int count = 0;
        commonFunctions.clickElementIfDisplayed(latestNewsLinkOnHeader,10,"Latest News");
        while(!isScrollWorked) {
            commonFunctions.scrollDownOnce();
            count++;
            if(commonFunctions.isElementDisplayed(viewMoreButton,20) && commonFunctions.isElementClickable(viewMoreButton,10,"View More button")){
                isScrollWorked=true;
            }
            if(count == 200){
                break;
            }
        }
        return isScrollWorked;
    }

    @Override
    public boolean checkMintTop50MF(String pageTitle) {
        boolean isElementDisplayed=true;
        commonFunctions.clickElementIfDisplayed(explore,10,"Click Explore button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand,10,"Scroll down to Mutual Funds");
        commonFunctions.clickElementIfDisplayed(mutualFundsTop50SubSection,10,"Click on Top 50 MF");
        isElementDisplayed &= checkMintLogo() && breadcrums.isDisplayed() && exploreAmp.isDisplayed() && ePaperOnHeader.isDisplayed() && getAppOnHeader.isDisplayed() && subscribeNowButton.isDisplayed();
        isElementDisplayed &= driver.getTitle().equalsIgnoreCase(pageTitle);
        commonFunctions.clickElementIfDisplayed(exploreAmp,10,"CLick Explore button");
        isElementDisplayed &= signInButton.isDisplayed();
        return isElementDisplayed;
    }

    @Override
    public boolean checkL1TabSelectionDiffStory() {
        return false;
    }

    @Override
    public boolean checkMintTop50MFForSubscribedUsers(String pageTitle) {
        boolean isElementDisplayed=true;
        commonFunctions.clickElementIfDisplayed(explore,10,"Click Explore button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand,10,"Scroll down to Mutual Funds");
        commonFunctions.clickElementIfDisplayed(mutualFundsTop50SubSection,10,"Click on Top 50 MF");
        isElementDisplayed &= checkMintLogo() && breadcrums.isDisplayed() && exploreAmp.isDisplayed() && ePaperOnHeader.isDisplayed() && getAppOnHeader.isDisplayed() && subscribeNowButton.isDisplayed();
        isElementDisplayed &= driver.getTitle().equalsIgnoreCase(pageTitle);
        commonFunctions.clickElementIfDisplayed(exploreAmp,10,"CLick Explore button");
        isElementDisplayed &= signInButton.isDisplayed();
        return isElementDisplayed;
    }

    @Override
    public boolean checkColumnsSubSectionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(columnsInOpinion, 5, "Columns in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.isElementDisplayed(columnInHomepage, 5, "Columns in homepage");
        return isElementDisplayed;
    }

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
    public boolean checkMFSectionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand, 5, "Scroll down to Mutual Funds");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(mutualFundsSection, 5, "Mutual Funds section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInMutualFundSection.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInMutualFundSection.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage,10).equalsIgnoreCase("Mutual Funds");
        return isElementDisplayed;
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
    public boolean checkIndustryPageLayout() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(industryExpand, 5, "Scroll down to Industry");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(industrySection, 5, "Industry section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInMutualFundSection.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInMutualFundSection.get(1), 5, "Second story");
        return isElementDisplayed;
    }

    @Override
    public boolean checkNewsSubsectionUnderMFInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand, 5, "Scroll down to Mutual Funds");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(mutualFundsNewsSubSection, 5, "News section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInMutualFundSection.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInMutualFundSection.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage,10).equalsIgnoreCase("News");
        return isElementDisplayed;
    }

    @Override
    public boolean checkViewsSubsectionUnderOpinionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Views in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Views");
        return isElementDisplayed;
    }

    @Override
    public boolean checkOpinionsSectionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(opinionSection, 5, "Views in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Opinion");
        return isElementDisplayed;
    }


    @Override
    public boolean checkViewsSubsectionStoryPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Views in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoryTitles.get(0), 5, "Story titles");
        commonFunctions.clickElementIfDisplayed(listOfStoryTitles.get(0), 5, "Story titles");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listofStoryParagraphs.get(0), 5, "First Paragraph");
        isElementDisplayed &= commonFunctions.isElementDisplayed(stickyWhatsappIcon, 5, "Whatsapp Icon");
        return isElementDisplayed;
    }

    @Override
    public boolean checkViewsSubsectionPageLayout() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Views in opinion");
        commonFunctions.clickElementIfDisplayed(denyNotification, 10, "I'll do this later Notification");
        commonFunctions.clickElementIfDisplayed(laterButtonOnNotification, 10, "later button Notification");
        isElementDisplayed &= commonFunctions.isElementDisplayed(mintLogo, 5, "Mint Logo");
        isElementDisplayed &= commonFunctions.isElementDisplayed(breadcrums, 5, "Breadcrumb");
        isElementDisplayed &= commonFunctions.isElementDisplayed(exploreAmp, 5, "Explore");
        isElementDisplayed &= commonFunctions.isElementDisplayed(searchButton, 5, "Search button");
        isElementDisplayed &= commonFunctions.isElementDisplayed(ePaperOnHeader, 5, "E paper on header");
        isElementDisplayed &= commonFunctions.isElementDisplayed(getAppOnHeader, 5, "Get App button");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Views");

        return isElementDisplayed;
    }

    @Override
    public boolean checkBreadcrumbOnCompaniesPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(companiesInExplore,15,"Scroll down to Companies");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(firstStoryInBreadcrumb,5,"First story in Companies page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(breadcrums,5,"Breadcrumb");
        isElementDisplayed &=  commonFunctions.getElementText(breadcrums,5).contains("Home / Companies /");//headline can not verify because special characters remove from breadcrumb
        return isElementDisplayed;
    }

    @Override
    public boolean checkTwitterPageWhenTapOnTwitterIcon() { return false; }

    @Override
    public boolean checkLinkedinPageWhenTapOnLinkedinIcon() { return false; }

    @Override
    public boolean checkFacebookPageWhenTapOnFacebookIcon() { return false; }

    @Override
    public boolean checkOpinionSectionStoryDetails() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionSection, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story in list view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story in list view");
        commonFunctions.clickElement(notificationFirstStory,5,"First story");
        commonFunctions.scrollToElementView(paragraph,10,"First paragraph of story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(paragraph, 5, "Paragraph");
        commonFunctions.scrollToElement(storyDetailFacebookIcon, "Scroll to Social icons");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailWhatsappIcon, 10, "Whatsapp Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailFacebookIcon, 10, "Facebook Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailTwitterIcon, 10, "Twitter Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailLinkedinIcon, 10, "LinkedIn Icon");
        return isElementDisplayed;
    }

    @Override
    public boolean checkShareholdingWidget() { return false; }

    @Override
    public boolean checkCompaniesLandingPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(companiesInExplore,15,"Scroll down to Companies");
        isElementDisplayed &= commonFunctions.isElementDisplayed(pageHeadingOnSectionPage,5,"Companies landing page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0),5,"First story in list view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(0),5,"First story headline");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1),5,"Second story in list view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(1),5,"Second story headline");
        return isElementDisplayed;
    }

    @Override
    public boolean checkPodcastEpisodePage() { return false; }

    @Override
    public boolean checkPodcastEpisode() { return false; }

    @Override
    public boolean checkVideoListingLandingPageStructure() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(videosSection, 5, "Scroll down to videos");
        commonFunctions.dummyWait(5);
        String actualURL = commonFunctions.getCurrentURL();
        isElementDisplayed &= commonFunctions.checkTextEquals("https://www.livemint.com/amp-videos",actualURL,"Videos landing page URL");
        commonFunctions.scrollToElementView(moreTabInVideos,70,"More tab");
        String moreHref = commonFunctions.getAtribute(moreTabInVideos,"href");
        isElementDisplayed &= commonFunctions.checkTextEquals("https://www.livemint.com/videos/page-2",moreHref,"More tab href");
        return isElementDisplayed;
    }

    @Override
    public boolean checkAuthorDetailsPage() { return false; }

    @Override
    public boolean checkAuthorPageLayout() { return false; }

    @Override
    public boolean checkSportsLandingPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection,15,"Scroll down to Sports");
        isElementDisplayed &= commonFunctions.isElementDisplayed(pageHeadingOnSectionPage,5,"Sports landing page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0),5,"First story in list view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(0),5,"First story headline");
        return isElementDisplayed;
    }

    @Override
    public boolean checkL1NavInSportsLandingPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection,15,"Scroll down to Sports");
        isElementDisplayed &= commonFunctions.isElementDisplayed(pageHeadingOnSectionPage,5,"Sports landing page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(l1Nav,5,"L1 on sports landing page");
        if (listOfSectionsInL1.size()== 12) {
            isElementDisplayed &= true;
        } else {
            isElementDisplayed &= false;
        }
        return isElementDisplayed;
    }

    @Override
    public boolean checkLHSGainerLoserWidget(String pageName, String widgetName)
    {
        return false;
    }

    @Override
    public boolean checkMintPremiumCarousel() {
        boolean isElementDisplayed = true;
        commonFunctions.scrollToElementView(mintPremiumCarousel,5,"Mint premium Carousel");
        isElementDisplayed &= commonFunctions.isElementDisplayed(mintPremiumCarousel,5,"Mint premium Carousel");
        if (listOfStoriesInMintPremium.size() == 10) {
            isElementDisplayed &= true;
        } else {
            isElementDisplayed &=false;
        }
        isElementDisplayed &= commonFunctions.isElementDisplayed(premiumTag,5,"Premium tag");
        return isElementDisplayed;
    }

    @Override
    public boolean checkSummaryOnSportsStoryPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection,15,"Scroll down to Sports");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(notificationFirstStory,5,"First story");
        isElementDisplayed &= commonFunctions.scrollToElementView(synopsisOfStory,5,"Summary of story");
        return isElementDisplayed;
    }

    @Override
    public boolean checkParagraphOnSportsPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribeOnHamburgerMenu,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection,15,"Scroll down to Sports");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(notificationFirstStory,5,"First story");
        isElementDisplayed &= commonFunctions.scrollToElementView(paragraph,5,"First Paragraph");
        return isElementDisplayed;
    }
}