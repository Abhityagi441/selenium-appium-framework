package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.genericPages.CommonAdvertisementPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvertisementPage extends CommonAdvertisementPage {

        private static WebDriver driver;
        private static GlobalVars globalVars;
        private static CommonFunctionsWeb commonFunctions;


        @FindBy(xpath = "//a[@title='Notification']/span")
        private static WebElement notificationBell;

        @FindBy(id = "noTCounter")
        private static WebElement notificationBadge;

        @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
        private static WebElement notificationHeading;

        @FindBy(id = "notification_new")
        private static WebElement notificationNew;

        @FindBy(id = "hamburgerElement")
        private static WebElement explore;

        @FindBy(xpath="//div[@class='whiteOverlay2']")
        private static WebElement hamburgerOverlay;

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

        @FindBy(xpath = "//a[@title='mint']")
        private static WebElement pageTitle;

        @FindBy(xpath = "(//*[@class='headline'])[1]")
        private static WebElement firstStory;

        @FindBy(xpath = "(//a[contains(@class,'btnClose')])[1][normalize-space()='Close']")
        private static WebElement closeStory;

        @FindBy(xpath = "(//div[contains(@class,'icoShare')])[1]")
        private static WebElement shareIcon;

        @FindBy(xpath = "(//div/a[@data-vars-icontype='facebook'])[1]")
        private static WebElement facebookIcon;

        @FindBy(xpath = "(//div/a[@data-vars-icontype='linkedin'])[1]")
        private static WebElement linkedinIcon;

        @FindBy(xpath = "(//div/a[@data-vars-icontype='twitter'])[1]")
        private static WebElement twitterIcon;

        @FindBy(xpath = "(//div[@id='socialHolder']//a[contains(@class,'icoBookmark')])[1]")
        private static WebElement bookmarkIcon;

        @FindBy(xpath = "(//span[contains(@class,'articleInfo')])[1]/em/span")
        private static WebElement minutesToRead;

        @FindBy(xpath = "(//span[contains(@class,'articleInfo')])[1]")
        private static WebElement timestamp;

        @FindBy(xpath = "(//span[contains(@class,'articleInfo')])[1]/span")
        private static WebElement updatedTimeStamp;

        @FindBy(xpath = "(//span/img[contains(@class,'lozad')])[1]")
        private static WebElement imageFirstStory;

        @FindBy(xpath = "(//link[@rel='icon'])[1]")
        private static WebElement favIcon;

        @FindBy(xpath = "//div/a[@class='closebtn'][contains(@onclick,'UserSideProfile')]")
        private static WebElement closeMyAccount;

        @FindBy(xpath = "//a[normalize-space()='My Account']")
        private static WebElement myAccount;

        @FindBy(id = "fixedNav_latest")
        private static WebElement latestPage;

        @FindBy(xpath = "//a[contains(text(),'Trending')]")
        private static WebElement trendingPage;

        @FindBy(id = "exclusive")
        private static WebElement premiumPage;

        @FindBy(xpath = "(//div[contains(@class, 'listtostory')])[1]")
        private static WebElement pageContent;

        @FindBy(xpath = "(//div[@class='figcaption'])[1]")
        private static WebElement imageCaption;

        @FindBy(xpath = "//div[contains(@id,'summary')]")
        private static WebElement summary;

        @FindBy(xpath = "(//div[@class='FirstEle'])[1]/p")
        private static WebElement paragraph;

        @FindBy(xpath = "(//div[@class='paywall'])[1]/p")
        private static List<WebElement> allParagraphsElementListFromUI;

        @FindBy(xpath = "//div[@id='bookmarksliderspace']//div[@id='swiper_b']//h2/a")
        private static List<WebElement> bookmarksSwiperBoxElementsList;

        @FindBy(xpath = "//div[@id='marketTicker']//div//ol")
        private static List<WebElement> marketTickerElementList;

        @FindBy(xpath = "//img[@title='mint']")
        private static WebElement mintTitle;

        @FindBy(xpath = "(//h2[@class='headline'])[1]/a")
        private static WebElement notificationFirstStory;

        @FindBy(xpath = "//span[contains(@class,'wewidgeticon we_close icon-large')]")
        private static WebElement closeButtonForUnlimitedDigitalAccessPopup;

        @FindBy(xpath = "//span[contains(@class,'dblock')]//img")
        private static WebElement firstImage;

        @FindBy(xpath = "(//*[@class='headline'])[1]")
        private static WebElement firstTitleInPage;

        @FindBy(xpath = "//div[@class='subscriptionBox']")
        private static WebElement subscriptionPaywall;

        @FindBy(xpath = "//a[text()='Start 15 Days Trial']")
        private static WebElement start15DaysTrail;

        @FindBy(xpath = "(//span[contains(@class,'exclusive')])[1]")
        private static WebElement premiumText;

        @FindBy(xpath = "//div[@class='icoMenu']")
        private static WebElement humburgIcon;

        @FindBy(xpath = "//span[@class='myreads']")
        private static WebElement myReadsMenu;

        @FindBy(id = "bookmarksliderspace")
        private static WebElement bookmarksSwiperBox;

        @FindBy(id = "agree")
        private static WebElement acceptCookie;

        @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
        private static WebElement listHeading;

        @FindBy(xpath = "(//div/h2[@class='headline'])[1]")
        private static WebElement storyPage;

        @FindBy(xpath = "(//div[contains(@class,'headline')])[2]")
        private static WebElement openStoryPage;

        @FindBy(xpath = "(//*[@class='lozad fade'])[1]")
        private static WebElement imagefirstStory;

        @FindBy(id = "fixedNav_home")
        private static WebElement homePage;

        @FindBy(xpath = "//*[@id='topic_Market Dashboard'])[1]")
        private static WebElement marketDashboard;

        @FindBy(xpath = "//div/button[@id='allow']")
        private static WebElement allowNotification;

        @FindBy(xpath = "//div/button[@id='deny']")
        private static WebElement denyNotification;

        @FindBy(xpath = "(//div[@id='webpush-prompt'])[1]")
        private static WebElement notificationPanel;

        @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]")
        private static WebElement premiumHeadline;

        @FindBy(xpath = "//a[contains(text(),'Start 15 Days Trial')]")
        private static WebElement startTrialBtn;

        @FindBy(xpath = "(//div[contains(@class,'subnavArrow')]/img)[1]")
        private static WebElement subArrow;

        @FindBy(xpath = "//li[@id='sectionsub_companies_news']/a")
        private static WebElement subNews;

        @FindBy(xpath = "//li[@id='sectionp_news']/a")
        private static WebElement news;

        @FindBy(xpath = "(//a[contains( @id,'topic_Long Story')])[1]")
        private static WebElement longStory;

        @FindBy(xpath = "(//div[contains(@class,'subnavArrow')]/img)[3]")
        private static WebElement marketsArrow;

        @FindBy(xpath = "(//a[contains(@class,'icoBookmark')])[3]")
        private static WebElement bookmarkPageLogin;

        @FindBy(xpath = "//li/a[contains(text(),'Stock Markets')]")
        private static WebElement stockMarket;

        @FindBy(xpath = "(//div[@class='headlineSec']/h2/a)[1]")
        private static WebElement stockMarketHeadline;

        @FindBy(xpath = "(//div[contains(text(),'Share Via')])[1]")
        private static WebElement shareVia;

        @FindBy(xpath = "(//div/aside/a[@data-vars-icontype='facebook'])[1]")
        private static WebElement storyDetailFacebookIcon;

        @FindBy(xpath = "(//div/aside/a[@data-vars-icontype='linkedin'])[1]")
        private static WebElement storyDetailLinkedinIcon;

        @FindBy(xpath = "(//div/aside/a[@data-vars-icontype='twitter'])[1]")
        private static WebElement storyDetailTwitterIcon;

        @FindBy(xpath = "(//img[contains(@class,'lozad')])[1]")
        private static WebElement imageOtherPagesfirstStory;

        @FindBy(xpath = "(//img[contains(@class,'lozad')])[1]/ancestor::section[contains(@class,'cardHolder')]")
        private static WebElement sectionTagOfFirstStory;

        @FindBy(xpath = "(//img[contains(@class,'lozad fade 1')])[1]")
        private static WebElement imageOffirstNoncardStory;

        @FindBy(xpath = "(//img[contains(@class,'lozad')])[2]")
        private static WebElement secondImage;

        @FindBy(xpath = "(//span[contains(@class,'author')])[1]")
        private static WebElement authorName;

        @FindBy(xpath = "//a[text()='SITEMAP']")
        private static WebElement linkSiteMap;

        @FindBy(xpath = "//div[text()='Sitemap']")
        private static WebElement siteMapHeader;

        @FindBy(xpath = "//div[normalize-space()='Add Your Contact Number']")
        private static WebElement addYourContactNo;

        @FindBy(xpath = "//div[@class='sitemap-col']//a")
        private static List<WebElement> siteMapLinksElementList;

        @FindBy(id = "uName")
        private static WebElement userEmailUsed;

        @FindBy(id = "name")
        private static WebElement nameTemp;

        @FindBy(id = "btSubmit")
        private static WebElement saveButton;

        @FindBy(xpath = "//div[@id='uName']/strong")
        private static WebElement accountName;

        @FindBy(xpath = "//label[@class='containerRadio'][1]")
        private static WebElement radioGender;

        @FindBy(id = "oldpswfield")
        private static WebElement oldPasswordTextField;

        @FindBy(id = "pswfield")
        private static WebElement newPasswordTextField;

        @FindBy(id = "confpswfield")
        private static WebElement confirmPasswordTextField;

        @FindBy(id = "btChangePassword")
        private static WebElement updateBtn;

        @FindBy(id = "btSubmit")
        private static WebElement genderSaveBtn;

        @FindBy(xpath = "//div/a[@id='editProfile']") // //div[@id='uName']/following-sibling::a
        private static WebElement profile;

        @FindBy(xpath = "//div[@id='uName']/strong")
        private static WebElement userName;

        @FindBy(xpath = "//a[contains(@href,'name')]")
        private static WebElement name;

        @FindBy(xpath = "//a[contains(@href,'change_password')]")
        private static WebElement password;

        @FindBy(xpath = "//a[contains(@href,'gender')]")
        private static WebElement gender;

        @FindBy(xpath = "//a[@class='back']")
        private static WebElement goBack;

        @FindBy(xpath = "//a[@class='LinkCTA'][2]")
        private static WebElement myReads2;

        @FindBy(xpath = "(//div[@class='label'][1])[2]")
        private static WebElement emailID;

        @FindBy(xpath = "//ul[@class='navCategories']/li")
        private static WebElement exploreMenu;

        @FindBy(xpath = "( //a[contains(@class,'explore')])[1]")
        private static WebElement subscribe;

        @FindBy(xpath = "//a/span[contains(@class,'myreads')]")
        private static WebElement myReads;

        @FindBy(xpath = "//div[contains(@class,'icoEpaper')]/following-sibling::div")
        private static WebElement ePaper;

        @FindBy(xpath = "//div[contains(@class,'iconewsletter')]/following-sibling::div")
        private static WebElement newsLetter;

        @FindBy(xpath = "(//a[contains(@class,'explore')]/div/following-sibling::div)[5]")
        private static WebElement ifscCode;

        @FindBy(xpath = "(//div[contains(@class,'subnavArrow')]/img)")
        private static WebElement arrow;

        @FindBy(xpath = "//ul[@class='navCategories']/li/a")
        private static List<WebElement> hamburgerList;

        @FindBy(xpath = "//ul[@class='navCategories']")
        private static WebElement hamburgerElement;

        @FindBy(xpath = "//div[@class='whiteOverlay2']")
        private static WebElement overlay;

        @FindBy(xpath = "//div[@class='errorHolder']")
        private static WebElement error;

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

        @FindBy(xpath = "//nav/a[contains(@class,'explore clearfix')]")
        private static List<WebElement> hamburgerTopmost;

        @FindBy(id = "subsLink")
        private static WebElement hamburgerElement2;

        @FindBy(xpath = "(//div[@class='FirstEle'])[1]")
        private static WebElement scrollBeforePayWall;

        @FindBy(xpath = "//div[@id='mylistView']//h2/a")
        private static List<WebElement> latestNewsHeadlines;

        @FindBy(xpath = "//div[@id='mylistView']//h2")
        private static List<WebElement> latestNewsStoryIds;

        @FindBy(xpath = "//span[text()='RECOMMENDED FOR YOU' or text()='SIMILAR STORIES']")
        private static WebElement similarStoriesOrMoreFromThisSection;

        @FindBy(xpath = "(//span[text()='Recommended'])[1]")
        private static WebElement recommended;

        @FindBy(xpath = "(//span[text()='Recommended'])[1]//following::div[1][@class='ob-widget-items-container']//section/span[@data-type='Title']")
        private static List<WebElement> recommendedWidgetStories;

        @FindBy(xpath = "(//div[@class='moreNewsListing'])[1]//h4/a")
        private static List<WebElement> similarStoriesWidgetStories;

        @FindBy(xpath = "(//div[@class='moreNewsListing'])[1]//img")
        private static List<WebElement> similarStoriesWidgetImages;

        @FindBy(xpath = "(//div[contains(@class,'swiper-button-next next_storyswiper')])[1]")
        private static WebElement nextArrowInSimilarStoriesWidget;

        @FindBy(xpath = "(//div[@class='moreNewsListing'])[1]//div[contains(@class,'swiper-button-next') and contains(@class,'swiper-button-disabled')]")
        private static WebElement nextArrowInSimilarStoriesWidgetDisabled;

        @FindBy(xpath = "(//div[contains(@class,'swiper-button-prev prev_storyswiper')])[1]")
        private static WebElement previousArrowInSimilarStoriesWidget;

        @FindBy(xpath = "(//div[@class='moreNewsListing'])[1]//div[contains(@class,'swiper-button-prev') and contains(@class,'swiper-button-disabled')]")
        private static WebElement previousArrowInSimilarStoriesWidgetDisabled;

        @FindBy(xpath = "((//div[@class='moreNewsListing'])[1]//h4/a)[1]")
        private static WebElement fistStoryInSimilarStoriesWidget;

        @FindBy(css = "div[id='trendingRHSFeed'] div[class='rightTitle']")
        private static WebElement trendingWidget;

        @FindBy(css = "div[id='latestRHSFeed'] div[class='rightTitle']")
        private static WebElement latestWidget;

        @FindBy(css = "div[id='topicRHSFeed-primer'] div[class='rightTitle']")
        private static WebElement primerWidget;

        @FindBy(css = "div[id='topicRHSFeed-long-story'] div[class='rightTitle']")
        private static WebElement longStoryWidget;

        @FindBy(css = "div[id='premiumRHSFeed'] div[class='rightTitle']")
        private static WebElement premiumWidget;

        @FindBy(css = "div[class='rightBlock'] div[class='rightTitle']")
        private static WebElement popularVideosWidget;

        @FindBy(css = "div[id='sectionRHSFeed-companies'] div[class='rightTitle']")
        private static WebElement companiesWidget;

        @FindBy(xpath = "//div[@id='rhsWsjNotAdFree']//img[@alt='WSJ']")
        private static WebElement theWallStreetJournalWidget;

        @FindBy(css = "div[id='personalFinance'] div[class='rightTitle']")
        private static WebElement personalFinanceWidget;

        @FindBy(xpath = "//div[@id='trendingRHSFeed']//h2/a")
        private static List<WebElement> trendingWidgetHeadline;

        @FindBy(xpath = "//div[@id='latestRHSFeed']//h2/a")
        private static List<WebElement> latestWidgetHeadline;

        @FindBy(xpath = "//div[@id='topicRHSFeed-primer']//h2/a")
        private static List<WebElement> primerWidgetHeadline;

        @FindBy(xpath = "//div[@id='topicRHSFeed-long-story']//h2/a")
        private static List<WebElement> longStoryWidgetHeadline;

        @FindBy(xpath = "//div[@id='premiumRHSFeed']//h2/a")
        private static List<WebElement> premiumWidgetHeadline;

        @FindBy(xpath = "//div[@id='rhsPopularVideosNotAdFree']//h2/a")
        private static List<WebElement> popularVideosWidgetHeadline;

        @FindBy(xpath = "//div[@id='sectionRHSFeed-companies']//h2/a")
        private static List<WebElement> companiesWidgetHeadline;

        @FindBy(xpath = "//div[@id='rhsWsjNotAdFree']//h2/a")
        private static List<WebElement> wsjWidgetHeadline;

        @FindBy(xpath = "//div[@id='personalFinance']//h2/a")
        private static List<WebElement> personalFinanceWidgetHeadline;

        @FindBy(id = "amazon-ai-player-label")
        private static WebElement listenLabel;

        @FindBy(id = "amazon-ai-player-container") //div[@id='amazon-ai-player-label']/following-sibling::div/audio[@id='amazon-ai-player']
        private static WebElement audioPlayer;

        @FindBy(xpath = "//div[@id='amazon-ai-player-label']/following-sibling::div/audio[@id='amazon-ai-player']/source")
        private static WebElement audioSource;

        @FindBy(xpath = "//img[@src='https://images.livemint.com/img/HT_Logo.png']")
        private static WebElement htWidget;

        @FindBy(xpath = "(//div[contains(@class,'imgHeading')])[1]/following::a[1]")
        private static WebElement viewAllHTWidget;

        @FindBy(xpath = "//div[@id='divMainHTCarousel']//h2//a")
        private static List<WebElement> htWidgetHeadlines;

        @FindBy(xpath = "//div[@id='divMainHTCarousel']//img")
        private static List<WebElement> htWidgetImages;

        @FindBy(xpath = "//div[@id='divMainHTCarousel']//div[contains(@class,'swiper-button-next')]")
        private static WebElement nextArrowHTWidget;

        @FindBy(xpath = "//div[@id='divMainHTCarousel']//div[contains(@class,'swiper-button-prev')]")
        private static WebElement prevArrowHTWidget;

        @FindBy(xpath="(//iframe[contains(@id,'google_ads_iframe')])[1]")
        private static WebElement mastHeadAdiFrame;

        @FindBy(id="subscribeAd")
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

        @FindBy(xpath="//div[contains(@id,'google_ads_iframe_/1055314/LM_MF_Desktop_subscription_300x250')]")
        private static WebElement subscribedDesktopAdUnit;


        @FindBy(xpath="(//div[@class='trendingSimilarHeight'])[1]")
        private static WebElement simillarStoriesWidget;

        @FindBy(xpath="//div[contains(@class,'listingNew')][9]")
        private static WebElement storyBeforeAd;


        public AdvertisementPage() {
                globalVars = GlobalVars.getInstance();
                driver = globalVars.getWebDriver();
                globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                PageFactory.initElements(driver, this);
                commonFunctions = CommonFunctionsWeb.getInstance();

                commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
                System.out.println("****************** Test started ******************");
                System.out.println("******************" + globalVars.getProjectName() + "******************");
        }
        @Override
        public boolean checkAdsOnSubscribedHomePage(){
                boolean mastheadAdDisplayed=commonFunctions.isElementNotDisplayed(mastHeadAdspace,10,"mast head ad space");
                boolean rhsTopAdDisplayed=commonFunctions.isElementNotDisplayed(RHSTopAdContainer,10,"RHS Top Ad ");
                commonFunctions.scrollToElementView(mintSnapView,10,"mint snap view carousal");
                boolean subscriberAdDisplayed= commonFunctions.isElementDisplayed(subscribedDesktopAdUnit,10,"subscriber desktop ad unit");
                if(mastheadAdDisplayed && rhsTopAdDisplayed && subscriberAdDisplayed){
                        return true;
                }
                else{return false;}
        }
        @Override
        public boolean checkAdsOnSubscribedStoryPage(){
                commonFunctions.clickElement(closeMyAccount,10,"Close my Account");
                commonFunctions.clickElement(firstStory,10,"First story of home page");
                commonFunctions.waitForURLContains(".html");
                boolean mastheadAdDisplayed=commonFunctions.isElementNotDisplayed(mastHeadAdspace,10,"mast head ad space");
                boolean rhsTopAdDisplayed=commonFunctions.isElementNotDisplayed(RHSTopAdContainer,10,"RHS Top Ad ");
                 commonFunctions.scrollToElementView(simillarStoriesWidget,10,"widget container");
                commonFunctions.scrollToElementView(subscriberAdContainer,10,"widget container");
                boolean checkAdunit= commonFunctions.isElementDisplayed(subscribedDesktopAdUnit);
                //verify no inline ads of non-subscriber for premium page
                // verify remove ad not displayed
                return mastheadAdDisplayed && rhsTopAdDisplayed  && checkAdunit;
        }
        @Override
        public boolean checkAdsOnSubscribedlistingPage(String pageName){
                //Listing premium page - 1. for subscribed 2. for non subscribed

                switch(pageName){
                        case "latest":
                                checkPageURLandTitle(latestPage,"latest page","latest-news","Latest News Today: Latest News Headlines, Breaking News, Current News",10);
                                break;
                        case "premium":
                                checkPageURLandTitle(premiumPage,"premium page","premium","Read Premium News and Stories on Mint",10);
                                break;
                        case "News":
                                commonFunctions.navigateToURL(globalVars.getURL()+"/news");
                                commonFunctions.checkPageTitle("News: Latest Breaking News, National News, World News - Mint",10,"news page title");
                                break;
                        default:
                                System.out.println("Invalid page name "+pageName+ " please put latest, premium or News");

                }
                boolean mastheadAdDisplayed=commonFunctions.isElementNotDisplayed(mastHeadAdspace,10,"mast head ad space");
                boolean rhsTopAdDisplayed=commonFunctions.isElementNotDisplayed(RHSTopAdContainer,10,"RHS Top Ad ");
                commonFunctions.scrollToElementView(storyBeforeAd,10,"story number 9 ");
                commonFunctions.scrollToElementView(subscriberAdContainer,10,"subscriber ad unit");
                boolean checkAdunit= commonFunctions.isElementDisplayed(subscribedDesktopAdUnit);
                return mastheadAdDisplayed && rhsTopAdDisplayed  && checkAdunit;
        }

        public boolean checkPageURLandTitle(WebElement element, String elementName, String expectedTextURL, String expectedTextTitle, int timeOutInSecond) {
                boolean checkPageURLandTitleStatus;
                commonFunctions.clickElementWithJS(element, timeOutInSecond, elementName);
                commonFunctions.waitForURLContains(Utils.getUrl());
                commonFunctions.checkPageURL(Utils.getUrl() + expectedTextURL, timeOutInSecond, elementName);
                commonFunctions.checkPageTitle(expectedTextTitle, timeOutInSecond, elementName);
                checkPageURLandTitleStatus = commonFunctions.isElementDisplayed(pageContent, timeOutInSecond, elementName);
                return checkPageURLandTitleStatus;
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
