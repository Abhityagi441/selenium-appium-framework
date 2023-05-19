package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.genericPages.CommonAdvertisementPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvertisementPage extends CommonAdvertisementPage {

        private static IOSDriver<WebElement> driver;
        private static GlobalVars globalVars;
        private static CommonFunctionsMobile commonFunctions;

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

        @FindBy(xpath = "(//ol[@class='slider'])[1]")
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

        @FindBy(xpath = "//nav/a[@id='fixedNav_home']")
        private static WebElement homePage;

        @FindBy(xpath = "//*[@id='topic_Market Dashboard'])[1]")
        private static WebElement marketDashboard;

        @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.chrome:id/positive_button']")
        private static WebElement allowNotification;

        @FindBy(xpath = "(//button[@class='subscribe'])[2]")
        private static WebElement allowNotificationAmp;

        @FindBy(xpath = "(//button[@class='subscribe'])[1]")
        private static WebElement denyNotification;

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

        @FindBy(id = "marketTicker")
        private static WebElement marketTicker;

        @FindBy(xpath = "//div[@id='I0001']//li[contains(.,'BSE SENSEX')][1]")
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

        @FindBy(xpath = "//section[@class='cardHolder']/article/a/h1")
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
        @FindBy(xpath = "//*[@class='swiper-slide']")
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

        @FindBy(xpath="(//iframe[contains(@id,'google_ads_iframe')])[1]")
        private static WebElement mastHeadAdiFrame;

        @FindBy(id="subs-adfree")
        private static WebElement subscriberAdContainer;

        @FindBy(xpath="//section[contains(@class,'cardHolder')][4]")
        private static WebElement mintSnapView;

        @FindBy(id="adfreeDeskSpace")
        private static WebElement mastHeadAdspace;

        @FindBy(id="rhs-ad-0")
        private static WebElement RHSTopAdContainer;

        @FindBy(id="subscribeAd")
        private static WebElement storyPageSubscriberAd;

        @FindBy(xpath="//div[contains(@id,'google_ads_iframe_/1055314/LM_MF_WAP_subscription_300x250_0')]")
        private static WebElement subscribedWAPAdUnit;

        @FindBy(xpath="//div[contains(@id,'google_ads_iframe_/1055314/LM_MF_WAP_subscription_300x250')]")
        private static WebElement subscribedDesktopAdUnit;



        public AdvertisementPage() {
                globalVars = GlobalVars.getInstance();
                driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
                PageFactory.initElements(new AppiumFieldDecorator(driver), this);
                commonFunctions = CommonFunctionsMobile.getInstance();
                commonFunctions.clickElementIfDisplayed(acceptCookie, 60, "agreeCookieButton");
                System.out.println("****************** Test started ******************");
                System.out.println("******************" + globalVars.getProjectName() + "******************");
        }
        @Override
        public boolean checkAdsOnSubscribedHomePage(){
                boolean mastheadAdDisplayed=commonFunctions.isElementNotDisplayed(mastHeadAdspace,10,"mast head ad space");
                boolean rhsTopAdDisplayed=commonFunctions.isElementNotDisplayed(RHSTopAdContainer,10,"RHS Top Ad ");
                commonFunctions.scrollToElementView(subscriberAdContainer,10,"Home page Ad container");
                boolean subscriberAdDisplayed= commonFunctions.isElementDisplayed(subscribedDesktopAdUnit,10,"subscriber desktop ad unit");
                if(mastheadAdDisplayed && rhsTopAdDisplayed && subscriberAdDisplayed){
                        return true;
                }
                else{return false;}
        }
        @Override
        public boolean checkAdsOnSubscribedStoryPage(){
                boolean mastheadAdDisplayed=commonFunctions.isElementNotDisplayed(mastHeadAdspace,10,"mast head ad space");
                boolean rhsTopAdDisplayed=commonFunctions.isElementNotDisplayed(RHSTopAdContainer,10,"RHS Top Ad ");
                boolean subscriberAdDisplayed=commonFunctions.scrollToElementView(storyPageSubscriberAd,10,"Subscriber Ad container");
                boolean checkAdunit= commonFunctions.isElementDisplayed(subscribedDesktopAdUnit);
                if(mastheadAdDisplayed && rhsTopAdDisplayed && subscriberAdDisplayed && checkAdunit){
                        return true;
                }
                else{return false;}
        }
        @Override
        public boolean checkAdsOnSubscribedlistingPage(String pageName){
                boolean mastheadAdDisplayed=commonFunctions.isElementNotDisplayed(mastHeadAdspace,10,"mast head ad space");
                boolean rhsTopAdDisplayed=commonFunctions.isElementNotDisplayed(RHSTopAdContainer,10,"RHS Top Ad ");
                boolean subscriberAdDisplayed=commonFunctions.scrollToElementView(storyPageSubscriberAd,10,"Subscriber Ad container");
                boolean checkAdunit= commonFunctions.isElementDisplayed(subscribedDesktopAdUnit);
                if(mastheadAdDisplayed && rhsTopAdDisplayed && subscriberAdDisplayed && checkAdunit){
                        return true;
                }
                else{return false;}
        }

        @Override
        public boolean checkAdsOnHomePage() {
                return false;
        }

        @Override
        public boolean checkAdsOnSectionPage() {
                return false;
        }

        @Override
        public boolean checkSponsoredAd() {
                return false;
        }

        @Override
        public boolean checkLeadsAdsOnHomePage() {
                return false;
        }

        @Override
        public boolean checkRemoveAdsFunctionalityAndBackButton() {
                return false;
        }

        @Override
        public boolean checkSecondAdsRemoveAdsFunctionalityAndBackButton() {
                return false;
        }

        @Override
        public boolean checkRemoveAdsFunctionalityOnTopicPage() {
                return false;
        }

        @Override
        public boolean checkRemoveAdsFunctionalityOnLatestAndTrendingPage() {
                return false;
        }

        @Override
        public boolean checkRemoveAdsFunctionalityOnStoryDetailPage() {
                return false;
        }

        @Override
        public boolean checkFirstInterstitialAds() {
                return false;
        }

        @Override
        public boolean checkSecondInterstitialAds() {
                return false;
        }
}
