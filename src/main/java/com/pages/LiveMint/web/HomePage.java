package com.pages.LiveMint.web;

import com.annotation.Description;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace;

public class HomePage extends CommonHomePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWebLM;

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
    private static WebElement hamburgerOverlayOutside;

    @FindBy(xpath = "//nav[@class='sidenav']")
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

    /*@FindBy(xpath = "(//a[contains(.,'GOLD')])[1]")
    private static WebElement marketGold;*/

    /*@FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'GOLD')]")
    private static WebElement marketGoldLanding;*/

    /*@FindBy(xpath = "(//a[contains(.,'SILVER')])[1]")
    private static WebElement marketSilver;*/

    /*@FindBy(xpath = "//h1[contains(@class,'cardheading')][contains(.,'SILVER')]")
    private static WebElement marketSilverLanding;*/

    @FindBy(xpath = "//div[contains(@class,'next_swiper_stat')]")
    private static WebElement marketNextIcon;

    @FindBy(xpath = "//div[contains(@class,'prev_swiper_stat')]")
    private static WebElement marketPrevIcon;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(xpath = "(//h2[@class='headline'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "(//h1[@class='headline'])[1]")
    private static WebElement widgetFirstStory;


    @FindBy(xpath = "(//h1[@class='headline'])[1]")
    private static WebElement firstStoryDetailPage;

    @FindBy(xpath = "(//a[contains(@class,'btnClose')])[1][normalize-space()='Close']")
    private static WebElement closeStory;

    @FindBy(xpath = "(//div[@id='socialHolder']//aside/div[2])[1]")
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

    @FindBy(xpath = "(//div[@class='headlineSec']/h2/a)[1]")
    private static WebElement latestPageFirstStoryTitle;


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

    @FindBy(id="fixedNav_markets")
    private static WebElement marketsPage;

    @FindBy(xpath="//a[@id='fixedNav_premium']")
    private static WebElement premiumPage;

    @FindBy(xpath = "(//div[contains(@class, 'listtostory')])[1]")
    private static WebElement pageContent;

    @FindBy(xpath = "//figcaption['figcaption']")
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

    @FindBy(xpath = "//button[@id='moe-dontallow_button']")
    private static WebElement laterButtonOnNotification;

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

    @FindBy(xpath = "(//div//aside/a[@data-vars-icontype='facebook'])[1]")
    private static WebElement storyDetailFacebookIcon;

    @FindBy(xpath = "(//div//aside/a[@data-vars-icontype='linkedin'])[1]")
    private static WebElement storyDetailLinkedinIcon;

    @FindBy(xpath = "(//div//aside/a[@data-vars-icontype='twitter'])[1]")
    private static WebElement storyDetailTwitterIcon;

    @FindBy(xpath = "(//img[contains(@class,'lozad')])[1]")
    private static WebElement imageOtherPagesfirstStory;

    @FindBy(xpath = "//div[@id='mylistView']//section[contains(@class,'cardHolder')]")
    private static WebElement sectionTagOfFirstStory;

    @FindBy(xpath = "(//img[contains(@class,'lozad fade 1')])[1]")
    private static WebElement imageOffirstNoncardStory;

    @FindBy(xpath = "(//img[contains(@class,'lozad')])[2]")
    private static WebElement secondImage;

    @FindBy(xpath = "(//span[contains(@class,'author')])[1]")
    private static WebElement authorName;

    @FindBy(xpath = "//a[text()='SITEMAP']")
    private static WebElement linkSiteMap;

    @FindBy(xpath = "//h1[@class='listheading']")
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

    @FindBy(xpath = "//a[@class='LinkCTA'][3]")
    private static WebElement myReads2;

    @FindBy(xpath = "(//div[@class='label'][1])[2]")
    private static WebElement emailID;

    @FindBy(xpath = "//ul[@class='navCategories']/li")
    private static WebElement exploreMenu;

    @FindBy(xpath = "( //a[contains(@class,'explore')])[1]")
    private static WebElement subscribe;

    @FindBy(xpath = "//li[contains(@class,'submenu')]//a[@href='/industry']")
    private static WebElement industrySection;

    @FindBy(xpath = "//a[@href='/industry']/parent::li//div")
    private static WebElement industryExpand;

    @FindBy(xpath = "//section[contains(@class,'cardHolder')]")
    private static WebElement firstStoryInCardView;

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

    @FindBy(xpath = "//span[text()='RECOMMENDED FOR YOU' or text()='SIMILAR STORIES' or text()='TRENDING STORIES']")
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

    @FindBy(css = "div[id='trendingRHSFeed']")
    private static WebElement trendingWidget;

    @FindBy(css = "div[id='latestRHSFeed'] ")
    private static WebElement latestWidget;

    @FindBy(css = "div[id='topicRHSFeed-primer']")
    private static WebElement primerWidget;

    @FindBy(css = "div[id='topicRHSFeed-long-story'] ")
    private static WebElement longStoryWidget;

    @FindBy(css = "div[id='premiumRHSFeed'] ")
    private static WebElement premiumWidget;

    @FindBy(css = "div[class='rightBlock'] ")
    private static WebElement popularVideosWidget;

    @FindBy(css = "div[id='sectionRHSFeed-companies'] ")
    private static WebElement companiesWidget;

    @FindBy(xpath = "//div[@id='rhsWsjNotAdFree']//img[@alt='WSJ']")
    private static WebElement theWallStreetJournalWidget;

    @FindBy(css = "div[id='personalFinance']")
    private static WebElement personalFinanceWidget;

    @FindBy(xpath = "//div[@id='trendingRHSFeed']/div[1]/h2")
    private static List<WebElement> trendingWidgetHeadline;

    @FindBy(xpath = "//div[@id='latestRHSFeed']/div[1]/h2")
    private static List<WebElement> latestWidgetHeadline;

    @FindBy(xpath = "//div[@id='topicRHSFeed-primer']/div[1]/h2")
    private static List<WebElement> primerWidgetHeadline;

    @FindBy(xpath = "//div[@id='topicRHSFeed-long-story']/div[1]/h2")
    private static List<WebElement> longStoryWidgetHeadline;

    @FindBy(xpath = "//div[@id='premiumRHSFeed']/div[1]/h2")
    private static List<WebElement> premiumWidgetHeadline;

    @FindBy(xpath = "//div[@id='rhsPopularVideosNotAdFree']/div[1]/h2")
    private static List<WebElement> popularVideosWidgetHeadline;

    @FindBy(xpath = "//div[@id='sectionRHSFeed-companies']/div[1]/h2")
    private static List<WebElement> companiesWidgetHeadline;

    @FindBy(xpath = "//div[@id='rhsWsjNotAdFree']/div[1]/h2")
    private static List<WebElement> wsjWidgetHeadline;

    @FindBy(xpath = "//div[@id='personalFinance']/div[1]/h2")
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

    @FindBy(xpath = "//nav//a[contains(@href,'latest-news')]")
    private static WebElement latestNewsLinkOnHeader;

    @FindBy(xpath = "//a[@alt='mint']")
    private static WebElement mintLogo;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaperOnHeader;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppOnHeader;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement pageHeadingOnSectionPage;

    @FindBy(xpath = "//a[text()='Subscribe Now']")
    private static WebElement subscribeNowButton;

    @FindBy(xpath = "//a[contains(@class,'userSign')]")
    private static WebElement signInButton;

    @FindBy(xpath = "//a[@href='/mutual-fund']/parent::li//div")
    private static WebElement mutualFundsExpand;

    @FindBy(xpath = "//a[@href='/mutual-fund']/parent::li//ul//li[contains(@id,'sectionsub_mutual funds_mint 50')]//a")
    private static WebElement mutualFundsTop50SubSection;

    @FindBy(xpath = "//button[@id='moe-dontallow_button']")
    private static WebElement laterPopUp;

    @FindBy(xpath = "//div[contains(@class,'bcrumb')]")
    private static WebElement breadcrums;

    @FindBy(xpath = "//div[@id='offerHead']//span")
    private static WebElement offerHead;

    @FindBy(xpath = "//a[@href='/opinion']/parent::li//div")
    private static WebElement opinionExpand;

    @FindBy(xpath = "//a[@href='/opinion']/parent::li//li//a[contains(@href,'/opinion/online-views')]")
    private static WebElement viewsInOpinion;

    @FindBy(xpath = "//li[@id=\"sectionsub_opinion_columns\"]")
    private static WebElement columnsInOpinion;

    @FindBy(xpath = "//div[contains(@class,'listingNew')]")
    private static List<WebElement> listOfStoriesInColumns;

    @FindBy(xpath = "//div[@class='headlineSec']//a")
    private static List<WebElement> listOfStoryTitles;

    @FindBy(xpath = "//div[@class='stickyWhatsapp']")
    private static WebElement stickyWhatsappIcon;

    @FindBy(xpath = "(//section[@id='story1']//div[@class='mainArea']//section[not (@amp-access-hide)]//p) | (//div[@id='mainArea']//div[@class='FirstEle'])")
    private static List<WebElement> listofStoryParagraphs;

    @FindBy(xpath = "//a[contains(@class,'icoBookmark3')]")
    private static WebElement bookmarkIconInStory;

    @FindBy(xpath = "//div[contains(@class,'icoShare')]")
    private static WebElement shareIconInStory;

    @FindBy(xpath = "//img[contains(@class,'lozad fade 2')]")
    private static WebElement thumpIconInStory;

    @FindBy(xpath = "//h1[text()='Columns']")
    private static WebElement columnInHomepage;

    @FindBy(xpath = "(//a[text()='Companies'])[2]")
    private static WebElement companiesInExplore;

    @FindBy(xpath = "//a[@href='/market']/parent::li//div")
    private static WebElement marketExpand;

    @FindBy(xpath = "//a[@href='/market/live-blog']")
    private static WebElement liveBlogSubsection;

    @FindBy(xpath = "//ul[@class='highlights']")
    private static WebElement synopsisOfStory;

    @FindBy(xpath = "(//a[@data-vars-icontype='twitter'])[2]")
    private static WebElement twitterIconOnStory;

    @FindBy(xpath = "(//a[@data-vars-icontype='linkedin'])[2]")
    private static WebElement linkedinIconOnStory;

    @FindBy(xpath = "(//a[@data-vars-icontype='facebook'])[2]")
    private static WebElement facebookIconOnStory;

    @FindBy(xpath = "//li[contains(@id,'sectionp_opinion')]//a[@href='/opinion']")
    private static WebElement opinionSection;

    @FindBy(xpath = "//div[contains(@class,'stockName')]")
    private static WebElement stockMarketName;

    @FindBy(xpath = "//a[contains(@class,'shareholding')]")
    private static WebElement shareHoldingTab;

    @FindBy(xpath = "//div[contains(@class,'swiper-button-next')]")
    private static WebElement stockNavNextButton;

    @FindBy(xpath = "//div[@id='stock_shareholding']//h2")
    private static List<WebElement> shareholdingWidget;

    @FindBy(xpath = "//h2[@class='headline']")
    private static List<WebElement> listOfStoriesHeadline;

    @FindBy(xpath = "(//a[@href='/podcast'])[1]")
    private static WebElement podcastSection;

    @FindBy(xpath = "(//a[contains(@href,'/podcast/')])[2]")
    private static WebElement podcastStory;

    @FindBy(xpath = "//h1[@class='listheading aboutus']")
    private static WebElement podcastPageTitle;

    @FindBy(xpath = "//div[@class='podcastDetailsMain']//a")
    private static WebElement podcastEpisodeTitle;

    @FindBy(xpath = "//a[contains(@onclick,'facebook')]")
    private static WebElement facebookIconOnPodcast;

    @FindBy(xpath = "//a[contains(@onclick,'twitter')]")
    private static WebElement twitterIconOnPodcast;

    @FindBy(xpath = "//a[contains(@onclick,'linkedin')]")
    private static WebElement linkedinIconOnPodcast;

    @FindBy(xpath = "//a[contains(@href,'whatsapp')]")
    private static WebElement whatsappIconOnPodcast;

    @FindBy(xpath = "//div[@class='podcastDescMain']/a")
    private static WebElement seeMoreInPodcast;

    @FindBy(xpath = "//div[@class='podacstPopup']")
    private static WebElement podcastPopup;

    @FindBy(xpath = "//div[@class='podacstPopup']/a")
    private static WebElement podcastPopupClose;

    @FindBy(xpath = "//div[@class='player']")
    private static WebElement mediaPlayer;

    @FindBy(xpath = "//div[@class='podDesc']/h2")
    private static WebElement episodeName;

    @FindBy(xpath = "//span[@class='articleInfo pubtime']/span")
    private static WebElement episodeDate;

   @FindBy(xpath = "//div[@class='podDesc']/p/a")
   private static WebElement seemoreInEpisode;

   @FindBy(xpath = "//a[@href='/videos']")
   private static WebElement videosSection;

   @FindBy(xpath = "//a[@href='/authors']")
   private static WebElement mintAuthorSection;

   @FindBy(xpath = "//div[@class='authorDesc']//a")
   private static List<WebElement> listOfAuthors;

   @FindBy(xpath = "//h1[@class='marZero']//a")
   private static WebElement authorsName;

   @FindBy(xpath = "//h1[@class='listheading clearfix']")
   private static WebElement articlesByAuthors;

   @FindBy(xpath = "//div[contains(@class,'authorSearch')]/input")
   private static WebElement searchBoxInAuhors;

   @FindBy(xpath = "//div[contains(@class,'swiper-slide')]")
   private static List<WebElement> alphabetSlider;

   @FindBy(xpath = "//a[@href='/sports']")
   private static WebElement sportsSection;

   @FindBy(xpath = "//nav[@class='navNew']")
   private static WebElement l1Nav;

    @FindBy(xpath = "//nav[@class='navNew']//a")
    private static List<WebElement> listOfSectionsInL1;

   @FindBy(id="lhsgainerloser")
   private static WebElement lhsGainerLoser;

    @FindBy(xpath="//div[@id='lhsgainerloser']/a")
    private static List<WebElement> lhsLoserGainerDataLinks;

    @FindBy(xpath="//div[@id='lhsgainerloser']/h2")
    private static WebElement lhsLoserGainerHeader;

    @FindBy(xpath="//div[@id='lhsgainerloser']/span")
    private static WebElement lhsLoserGainerDate;

    @FindBy(id="lhsgainerstab")
    private static WebElement lhsTopgainerCTA;

    @FindBy(id="lhsloserstab")
    private static WebElement lhsToploserCTA;

    @FindBy(xpath = "//div[text()='Mint Premium']")
    private static WebElement mintPremiumCarousel;

    @FindBy(xpath = "//div[@class='listing2 clearfix']")
    private static List<WebElement> listOfStoriesInMintPremium;

    @FindBy(xpath = "//div[@class='listing2 clearfix']//span")
    private static WebElement premiumTag;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLM= CommonFunctionsWebLM.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean notification(String apiURL, String faviconURL) {
        boolean notificationStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        boolean checkFaviconStatusBefore = checkFavicon(faviconURL);
        boolean checkURLChangedToNotificationURLStatus = checkURLChangedToNotificationURL();
        boolean checkNotificationTitleStatus = checkNotificationTitle();
        boolean checkFaviconStatusAfter = checkFavicon(faviconURL);
        boolean checkBlueDotIsRemovedStatus = checkBlueDotIsRemoved();
        boolean checkNotificationInAPIStatus = checkNotificationInAPI(apiURL);
        commonFunctions.isElementDisplayed(notificationFirstStory, 10, "Notification Heading");
        if (checkFaviconStatusBefore && checkFaviconStatusAfter && checkURLChangedToNotificationURLStatus && checkNotificationTitleStatus && checkBlueDotIsRemovedStatus && checkNotificationInAPIStatus) {
            notificationStatus = true;
        } else {
            notificationStatus = false;
        }
        return notificationStatus;
    }

    @Override
    public boolean storyPage() {
        boolean storyPageStatus;
       // String focus;
        commonFunctions.navigateToURL(globalVars.getURL()+"/news");
        //commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
       // focus = commonFunctions.getFocus().toString();
        commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        boolean checkFirstHeadlineStatus = checkFirstHeadline();
        boolean checkURLChangedToStoryURLStatus = checkURLChangedToStoryURL();
        //boolean checkURLChangedToBaseURLStatus = checkURLChangedToBaseURL();
        commonFunctions.isElementDisplayed(minutesToRead, 10, "Min Read");
        commonFunctions.isElementDisplayed(updatedTimeStamp, 10, "Updated TimeStamp");
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        if (checkFirstHeadlineStatus && checkURLChangedToStoryURLStatus ) {
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
        commonFunctions.navigateToURL(globalVars.getURL()+"/news");
        //commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(firstStory, 10, "First Story");
        commonFunctions.waitForURLContains(".html");
        String storyId = commonFunctions.getStoryIdFromURL();
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        boolean checkHeadlineInAPIStatus = checkHeadlineInAPI(response);
        boolean checkSummaryInAPIStatus = checkSummaryInAPI(response);
        boolean checkCaptionInAPIStatus = checkCaptionInAPI(response);
        ArrayList<String> allParagraphsFromUI = getAllParagraphsFromUI();
        boolean checkAllParagraphInAPIStatus = checkAllParagraphsInAPI(response, allParagraphsFromUI);
        boolean checkTimeToReadInAPIStatus = checkTimeToReadInAPI(response);
        if (checkHeadlineInAPIStatus && checkSummaryInAPIStatus && checkCaptionInAPIStatus && checkAllParagraphInAPIStatus && checkTimeToReadInAPIStatus) {
            apiForFirstStoryStatus = true;
        } else {
            apiForFirstStoryStatus = false;
        }
        return apiForFirstStoryStatus;
    }

    @Override
    public boolean shareStory() {
        boolean shareStoryStatus;
        commonFunctions.navigateToURL(globalVars.getURL()+"/news");
        //commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(firstImage, "first Image");
        commonFunctions.isElementClickable(shareIcon, 10, "Share Icon");
        commonFunctions.clickElementWithJS(shareIcon, 10, "Share Icon");
        commonFunctions.isElementDisplayed(shareIcon, 10, "Share Icon");
        commonFunctions.isElementClickable(facebookIcon, 10, "Facebook Icon");
        commonFunctions.isElementClickable(linkedinIcon, 10, "LinkedIn Icon");
        shareStoryStatus = commonFunctions.isElementClickable(twitterIcon, 10, "Twitter Icon");
        return shareStoryStatus;
    }

    @Override
    public boolean bookmarkStory() {
        boolean bookmarkStatus;
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(firstImage, "Image First Story");
        commonFunctions.isElementDisplayed(bookmarkIcon, 10, "BookMark Icon");
        bookmarkStatus = commonFunctions.isElementClickable(bookmarkIcon, 10, "BookMark Icon");
        return bookmarkStatus;
    }

    @Override
    public boolean bookmarkStoryLoggedInUser() {
        boolean bookmarkStoryLoggedInUserStatus = false;
        closeAllThePopups();
        commonFunctions.clickElement(closeMyAccount, 10, "Close My Account Button");
        commonFunctions.isElementDisplayed(bookmarkIcon, 10, "BookMark Icon");
        commonFunctions.isElementClickable(bookmarkIcon, 10, "BookMark Icon");
        commonFunctions.closePopupIfExist(closeButtonForUnlimitedDigitalAccessPopup, "Unlimited Digital Access");
        boolean checkBookMarkIconIsActiveStatus = checkBookMarkIconIsActive();
        String bookmarkStoryId = commonFunctions.getProperty(bookmarkIcon, "id");
        bookmarkStoryId = bookmarkStoryId.split("_")[1];
        navigateToMyReadsPage();
        closeAllThePopups();
        commonFunctions.isElementDisplayed(bookmarksSwiperBox, 10, "BookMark Swiper Box");
        boolean checkBookmarkedStoryIdIsAvailableInBookmarkSwiperBoxStatus = checkBookmarkedStoryIdInBookmarkSwiperBox(bookmarkStoryId, true);
        String bookmarkStoryIdXpath = "//h2//a[contains(@href,'" + bookmarkStoryId + "')]";
        WebElement bookMarkIconInSwiperBox = globalVars.getWebDriver().findElement(By.xpath(bookmarkStoryIdXpath));
        commonFunctions.clickElementWithJS(bookMarkIconInSwiperBox, 10, "BookMark Icon in BookMark Swiper Box");
        boolean checkBookmarkedStoryIdIsNotAvailableInBookmarkSwiperBoxStatus = checkBookmarkedStoryIdInBookmarkSwiperBox(bookmarkStoryId, false);
        commonFunctions.clickElement(myAccount, 10, "My Account");
        if (checkBookMarkIconIsActiveStatus && checkBookmarkedStoryIdIsAvailableInBookmarkSwiperBoxStatus && checkBookmarkedStoryIdIsNotAvailableInBookmarkSwiperBoxStatus) {
            bookmarkStoryLoggedInUserStatus = true;
        } else {
            bookmarkStoryLoggedInUserStatus = false;
        }
        return bookmarkStoryLoggedInUserStatus;
    }

    @Override
    public boolean marketTicker(String[] params) {
        boolean marketTickerStatus;
        String marketStatsURL = params[0];
        commonFunctions.switchToDefaultContent();
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(homePage, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerStatus = checkOrderListPresentInTheMarketTicker();
        commonFunctions.isElementClickable(marketTicker, 10, "Market Ticker");
        commonFunctions.isElementClickable(marketNifty,10,"Market Sensex");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        ClickMarketTickerUntilVisible(marketSensex, "Market Sensex");
        boolean checkURLChangedToMarketStatsURLStatus = checkURLChangedToMarketStatsURL(marketStatsURL);
        boolean checkEachMarketLandingPagesAreNotBlankStatus = checkEachMarketLandingPagesAreNotBlank();
        if (checkOrderListPresentInTheMarketTickerStatus && checkURLChangedToMarketStatsURLStatus && checkEachMarketLandingPagesAreNotBlankStatus) {
            marketTickerStatus = true;
        } else {
            marketTickerStatus = false;
        }
        return marketTickerStatus;
    }

    @Override
    public boolean pageContent(String apiURL) {
        boolean pageContentStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean homePageTitleAndUrlStatus = checkPageURLandTitle(mintTitle, "Home", "", "Business News Today: Read Latest Business News, Live India Share Market News, Finance & Economy News | Mint", 10);
        boolean latestPageTitleAndUrlStatus = checkPageURLandTitle(latestPage, "Latest", "latest-news", "Latest News Today: Latest News Headlines, Breaking News, Current News | Mint", 10);
        commonFunctions.dummyWait(10);
        closeAllThePopups();
        commonFunctions.clickElementWithJS(latestPageFirstStoryTitle, 10, "Open latest Story");
        String expectedText = commonFunctions.getElementText(firstTitleInPage, 10);
        boolean latestPageStoryStatus = checkDataUsingStoryAPI("verifyPageNotBlank", expectedText, "Latest Headline in API", "content[0].headline", apiURL);
        /*boolean trendingPageTitleAndUrlStatus = checkPageURLandTitle(trendingPage, "Trending", "mostpopular", "Trending News: Today's Trending News, Viral News, Popular News Headlines - Mint", 10);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(imageOtherPagesfirstStory, 10, "Trending");
        expectedText = commonFunctions.getElementText(firstTitleInPage);
        boolean trendingPageStoryStatus = checkDataUsingStoryAPI("verifyPageNotBlank", expectedText, "Trending Headline in API", "$.content[0].headline", apiURL);
        boolean premiumPageTitleAndUrlStatus = checkPageURLandTitle(premiumPage, "Premium", "premium", "Read Premium News and Stories on Mint", 10);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(imageOtherPagesfirstStory, 10, "Premium");
        expectedText = commonFunctions.getElementText(firstTitleInPage);
        boolean premiumPageStoryStatus = checkDataUsingStoryAPI("verifyPageNotBlank", expectedText, "Premium Headline in API", "$.content[0].headline", apiURL);
        */
        if (homePageTitleAndUrlStatus && latestPageTitleAndUrlStatus && latestPageStoryStatus) { //&& trendingPageTitleAndUrlStatus && premiumPageTitleAndUrlStatus && trendingPageStoryStatus && premiumPageStoryStatus
            pageContentStatus = true;
        } else {
            pageContentStatus = false;
        }
        return pageContentStatus;
    }

    @Override
    public boolean shareStoryFunctionality() {
        boolean shareStoryStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(firstImage, "Second Image");
        boolean shareIconHomePageStatus = commonFunctions.isElementClickable(shareIcon, 10, "Share Icon");
        commonFunctions.clickElementWithJS(shareIcon, 10, "Share Icon ");
       /* closeAllThePopups();*/
        commonFunctions.getElementText(shareVia, "Share Via", 10);
        boolean facebookIconShareViaPageStatus = commonFunctions.isElementClickable(facebookIcon, 10, "Facebook Icon");
        boolean twitterIconShareViaPageStatus = commonFunctions.isElementClickable(linkedinIcon, 10, "LinkedIn Icon");
        boolean linkedinIconShareViaPageStatus = commonFunctions.isElementClickable(twitterIcon, 10, "Twitter Icon");
        boolean clickfacebookShareStatus = checkSocialMediaShare(facebookIcon, "Facebook Page", "facebook");
        boolean clicktwitterShareStatus = checkSocialMediaShare(twitterIcon, "Twitter Page", "twitter");
        commonFunctions.pageRefresh();
        commonFunctions.waitForURLContains(Utils.getUrl());
        boolean shareIconLatestPageStatus = checkShareIcon(latestPage, "Latest Page");
        boolean shareIconMarketsPageStatus = checkShareIcon(marketsPage, "Markets");
        boolean shareIconPremiumPageStatus = checkShareIcon(premiumPage, "Premium");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(marketsArrow, 10, "marketsArrow");
        boolean shareIconStockMarketPageStatus = checkShareIcon(stockMarket, "stockMarket");
        commonFunctions.clickElement(explore, 10, "Explore");
        boolean shareIconNewsPageStatus = checkShareIcon(news, "News Section");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(subArrow, 10, "subArrow");
        boolean shareIconSubSectionPageStatus = checkShareIcon(subNews, "News Subsection");
        String longStoryURL = Utils.getUrl() + "topic/long-story";
        driver.navigate().to(longStoryURL);
        commonFunctions.waitForPageLoading();
        boolean shareIconStoryDetailPageStatus = commonFunctions.isElementClickable(shareIcon, 10, "Long Story Share Icon");
        commonFunctions.clickElement(stockMarketHeadline, 10, "Long story headline");
        commonFunctions.scrollToElementView(paragraph,10,"First paragraph of story");
        boolean facebookIconStoryDetailPageStatus = commonFunctions.isElementClickable(storyDetailFacebookIcon, 10, "Facebook Icon in Story Detail");
        boolean twitterIconStoryDetailPageStatus = commonFunctions.isElementClickable(storyDetailTwitterIcon, 10, "Twitter Icon  in Story Detail");
        boolean linkedinIconStoryDetailPageStatus = commonFunctions.isElementClickable(storyDetailLinkedinIcon, 10, "LinkedIn Icon  in Story Detail");

        if (shareIconHomePageStatus && shareIconLatestPageStatus && shareIconMarketsPageStatus && shareIconPremiumPageStatus && shareIconStockMarketPageStatus && shareIconNewsPageStatus && shareIconSubSectionPageStatus && shareIconStoryDetailPageStatus && facebookIconStoryDetailPageStatus && twitterIconStoryDetailPageStatus && linkedinIconStoryDetailPageStatus && facebookIconShareViaPageStatus && twitterIconShareViaPageStatus && linkedinIconShareViaPageStatus && clickfacebookShareStatus && clicktwitterShareStatus) {
            shareStoryStatus = true;
        } else {
            shareStoryStatus = false;
        }
        return shareStoryStatus;
    }

    @Override
    public boolean nonSubscribedUserPaywall(String apiURL) {
        boolean nonSubscribedUserPaywallStatus;
        closeAllThePopups();
        //commonFunctions.clickElement(closeMyAccount, 10, "MyAccount");
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(pageContent, 10, "Premium Page");
        commonFunctions.clickElement(premiumPage, 10, "Premium");
        commonFunctions.waitForURLToBe(Utils.getUrl() + "premium");
        boolean checkPremiumPageStatus = commonFunctions.checkPageURL(Utils.getUrl() + "premium", 10, "Premium Landing Page");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithJS(imageOtherPagesfirstStory, 10, "First Title in Premium Page");
        commonFunctions.waitForURLContains(".html");
        boolean checkPremiumLabel = commonFunctions.checkElementText(premiumText, "PREMIUM", 10, "Premium Label");
        boolean premiumStoryStatus = checkDataUsingStoryAPI("verifyNonSubscribedUserPaywall", "true", "Premium Story in API", "content[0].metadata.premiumStory", apiURL);
        commonFunctions.scrollToElement(scrollBeforePayWall, "Scroll Subscribe ");
        boolean payWallPresentStatus = commonFunctions.isElementDisplayed(subscriptionPaywall, 10, "Subscription paywall is displayed for this user ");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithJS(myAccount, 10, "My Account");
        closeAllThePopups();
        if (checkPremiumPageStatus && payWallPresentStatus && checkPremiumLabel && premiumStoryStatus) {
            nonSubscribedUserPaywallStatus = true;
        } else {
            nonSubscribedUserPaywallStatus = false;
        }
        return nonSubscribedUserPaywallStatus;
    }

    @Override
    public boolean myAccountFunctionality(String oldPassword, String newPassword, String oldName, String newName, String email, String manageProfileURL) {
        boolean myAccountFunctionalityStatus;
        boolean elementDisplayed;
        elementDisplayed=commonFunctions.isElementDisplayed(pageTitle, 10, "Mint Title");
        commonFunctions.clickElementWithJS(myAccount,30,"My account");
        elementDisplayed &=commonFunctions.isElementDisplayed(userName, 20, "Account holder");
        boolean checkEmailIDUsedForLoginStatus = checkEmailIDUsedForLogin(email,oldName);
        commonFunctions.clickElementWithJS(profile, 10, "profile");
        boolean checkManageProfilePageURLStatus = commonFunctions.checkPageURL(manageProfileURL, 10, "Manage profile");
        elementDisplayed &=commonFunctions.isElementDisplayed(name, 10, "Name");
        elementDisplayed &=commonFunctions.isElementDisplayed(emailID, 10, "Email ID");
        elementDisplayed &=commonFunctions.isElementDisplayed(addYourContactNo, 10, "Add Your Account");
/*
        commonFunctions.isElementDisplayed(password, 10, "Password");
*/
        elementDisplayed &=commonFunctions.isElementDisplayed(gender, 10, "Gender");
        boolean changeNameStatus = changeName(newName, oldName);
/*
        boolean changePasswordStatus = changePassword(oldPassword, newPassword);
*/
        commonFunctions.clickElementWithJS(myAccount,10,"my account");
        commonFunctions.clickElementWithJS(profile,10,"Edit click");
        commonFunctions.scrollToViewElement(gender,"gender",10);
        commonFunctions.clickElementWithJS(gender, 10, "Gender");
        commonFunctions.clickElementWithJS(radioGender, 10, "Gender Radio Button");
        commonFunctions.clickElementWithJS(genderSaveBtn, 10, "Save Button");
        commonFunctions.clickElementWithJS(goBack, 10, "Go Back");
        elementDisplayed &=commonFunctions.isElementDisplayed(myAccount, 10, "My Account");
        commonFunctions.clickElementWithJS(myAccount, 10, "My Account");
        commonFunctions.clickElementWithJS(myReads2, 10, "My Reads");
        closeAllThePopups();
        boolean checkMyReadsPageURLStatus = commonFunctions.checkPageURL(Utils.getUrl() + "myreads", 10, "My Reads");
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElementWithJS(myAccount, 10, "My Account");
        commonFunctions.scrollDown();
        if (checkManageProfilePageURLStatus && checkMyReadsPageURLStatus && changeNameStatus  && checkEmailIDUsedForLoginStatus && elementDisplayed) {
            myAccountFunctionalityStatus = true;
        } else {
            myAccountFunctionalityStatus = false;
        }
        return myAccountFunctionalityStatus;
    }

    @Override
    public boolean subscribedUserPaywall() {
        return false;
    }

    @Override
    public boolean siteMap(String siteMapURL) {
        boolean sitemapStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.scrollToElement(linkSiteMap, "SITEMAP");
        commonFunctions.clickElement(linkSiteMap, 10, "SITEMAP");
        boolean checkURLChangedToSitemapURLStatus = checkURLChangedToSitemapURL(siteMapURL);
        boolean checkSitemapPageTitleStatus = checkSitemapPageTitle();
        boolean sitemapHeaderStatus = commonFunctions.isElementDisplayed(siteMapHeader, 10, "Sitemap Header");
        boolean checkAllLinksInSitemapStatus = checkAllLinksInSitemap();
        if (checkURLChangedToSitemapURLStatus && checkSitemapPageTitleStatus && sitemapHeaderStatus && checkAllLinksInSitemapStatus) {
            sitemapStatus = true;
        } else {
            sitemapStatus = false;
        }
        return sitemapStatus;
    }


    public boolean checkURLChangedToStoryURL() {
        boolean checkURLChangedToStoryURLStatus;
        String expectedURL = Utils.getUrl();
        //commonFunctions.clickElement(firstStory, 10, "First Story");
        commonFunctions.waitForURLContains(".html");
        /*commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();*/
        commonFunctions.waitForPageLoading();
        String actualURL = commonFunctions.getCurrentURL();
        commonFunctions.dummyWait(10);
        checkURLChangedToStoryURLStatus = commonFunctions.checkTextNotEquals(expectedURL, actualURL, "Story URL");
        return checkURLChangedToStoryURLStatus;
    }

    public boolean checkFirstHeadline() {
        boolean checkFirstHeadlineStatus;
        String expectedHeadline = commonFunctions.getElementText(firstStory);
        commonFunctions.clickElement(firstStory, 10, "First Story");
        closeAllThePopups();
        commonFunctions.waitForURLContains(".html");
        String actualHeadline = commonFunctions.getElementText(firstStoryDetailPage);
        if(actualHeadline.length()>80)
        {
            actualHeadline=commonFunctions.getAtribute(firstStoryDetailPage,"data-mob");
            checkFirstHeadlineStatus=commonFunctions.checkTextContains(expectedHeadline, actualHeadline, " First story Mobile headline");
        }
        else
        {
            checkFirstHeadlineStatus = commonFunctions.checkTextContains(expectedHeadline, actualHeadline, "First Story Headline in UI");
        }
        return checkFirstHeadlineStatus;
    }

    public boolean checkCloseIconIsSticky() {
        boolean checkCloseIconIsStickyStatus;
        commonFunctions.scrollToElement(closeStory, "Close story");
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(closeStory, 10, "Close Story");
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();
        commonFunctions.waitForPageLoading();
        checkCloseIconIsStickyStatus = commonFunctions.checkCSSProperty(closeStory, "position", "sticky", "Close button");
        return checkCloseIconIsStickyStatus;
    }

    public boolean checkURLChangedToBaseURL() {
        boolean checkURLChangedToBaseURLStatus;
        String expectedURL = commonFunctions.getCurrentURL();
        commonFunctions.scrollToTop();
        commonFunctions.waitForURLToBe(expectedURL);
        commonFunctions.dummyWait(10);
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToBaseURLStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "Base URL");
        return checkURLChangedToBaseURLStatus;
    }

    public boolean checkHeadlineInAPI(Response response) {
        boolean checkHeadlineInAPIStatus;
        String expectedHeadlineFromAPI = RestUtils.getValueFromResponse(response, "content[0].headline");
        String expectedMobileHeadlineFromAPI = RestUtils.getValueFromResponse(response, "content[0].mobileHeadline");
        expectedHeadlineFromAPI = Utils.formatAPIText(expectedHeadlineFromAPI);
        expectedMobileHeadlineFromAPI = Utils.formatAPIText(expectedMobileHeadlineFromAPI);
        String actualHeadlineFromUI = commonFunctions.getElementText(firstStoryDetailPage);
        expectedHeadlineFromAPI= commonFunctions.getStringWithoutAngularBrackets(expectedHeadlineFromAPI);
        expectedMobileHeadlineFromAPI= commonFunctions.getStringWithoutAngularBrackets(expectedMobileHeadlineFromAPI);

        if(commonFunctions.checkTextContains(expectedHeadlineFromAPI, actualHeadlineFromUI, "Headline in API"))
        {
            System.out.println("headline matched");
            checkHeadlineInAPIStatus=true;}
        else{
            System.out.println("Headline not matched");
            checkHeadlineInAPIStatus=commonFunctions.checkTextContains(expectedMobileHeadlineFromAPI, actualHeadlineFromUI, "Mobile Headline in API");
        }
        return checkHeadlineInAPIStatus;
    }

    public boolean checkSummaryInAPI(Response response) {
        boolean checkSummaryInAPIStatus;
        String expectedSummaryFromAPI = RestUtils.getValueFromResponse(response, "content[0].summary");
        expectedSummaryFromAPI = Utils.formatAPIText(expectedSummaryFromAPI);
        String actualSummaryFromUI = commonFunctions.getElementText(summary);
        expectedSummaryFromAPI=commonFunctions.getStringWithoutAngularBrackets(expectedSummaryFromAPI);
        actualSummaryFromUI = actualSummaryFromUI.replaceAll("\n", "");
        checkSummaryInAPIStatus = commonFunctions.checkTextContains(expectedSummaryFromAPI, actualSummaryFromUI, "Summary in API");
        return checkSummaryInAPIStatus;
    }

    public boolean checkCaptionInAPI(Response response) {
        boolean checkCaptionInAPIStatus;
        String expectedCaptionFromAPI = RestUtils.getValueFromResponse(response, "content[0].leadMedia.image.caption");
        expectedCaptionFromAPI = Utils.formatAPIText(expectedCaptionFromAPI);
        String actualCaptionFromUI = commonFunctions.getElementText(imageCaption);
        expectedCaptionFromAPI = commonFunctions.getStringWithoutAngularBrackets(expectedCaptionFromAPI);
        checkCaptionInAPIStatus = commonFunctions.checkTextContains(expectedCaptionFromAPI, actualCaptionFromUI, "Caption in API");
        return checkCaptionInAPIStatus;
    }

    public boolean checkParagraphInAPI(Response response) {
        boolean checkParagraphInAPIStatus;
        String expectedParagraphFromAPI = RestUtils.getValueFromResponse(response, "content[0].listElement[0].paragraph.body");
        expectedParagraphFromAPI = Utils.formatAPIText(expectedParagraphFromAPI);
        String actualParagraphFromUI = commonFunctions.getElementText(paragraph);
        expectedParagraphFromAPI= commonFunctions.getStringWithoutAngularBrackets(expectedParagraphFromAPI);
        checkParagraphInAPIStatus = commonFunctions.checkTextContains(expectedParagraphFromAPI, actualParagraphFromUI, "Paragraph in API");
        return checkParagraphInAPIStatus;
    }

    public boolean checkAllParagraphsInAPI(Response response, ArrayList<String> actualParagraphListFromUI) {
        boolean checkAllParagraphsInAPIStatus;
        boolean isAnyParagraphVerificationFailed = false;
        Integer paragraphsSize = RestUtils.getArrayLengthFromResponse(response, "content[0].listElement");
        for (int i = 0; i < paragraphsSize - 2; i++) {
            String expectedParagraphFromAPI = RestUtils.getValueFromResponse(response, "content[0].listElement[" + i + "].paragraph.body");
            expectedParagraphFromAPI = Utils.formatAPIText(expectedParagraphFromAPI);
            expectedParagraphFromAPI= commonFunctions.getStringWithoutAngularBrackets(expectedParagraphFromAPI);
            expectedParagraphFromAPI=expectedParagraphFromAPI.substring(expectedParagraphFromAPI.indexOf(":")+1,expectedParagraphFromAPI.length());
            String actualParagraphFromUI = actualParagraphListFromUI.get(i);
            actualParagraphFromUI = Utils.formatAPIText(actualParagraphFromUI);
            actualParagraphFromUI=actualParagraphFromUI.substring(actualParagraphFromUI.indexOf(":")+1,actualParagraphFromUI.length());
            if (equalToCompressingWhiteSpace(expectedParagraphFromAPI).matches(actualParagraphFromUI)) {
                Utils.logStepInfo(true, i + 1 + " - Paragraph verified successfully in API");
            } else {
                isAnyParagraphVerificationFailed = true;
                Utils.logStepInfo(false, i + 1 + " - Paragraph verification failed in API. Expected: " + expectedParagraphFromAPI + " , Actual: " + actualParagraphFromUI);
            }
        }
        if (isAnyParagraphVerificationFailed) {
            checkAllParagraphsInAPIStatus = false;
        } else {
            checkAllParagraphsInAPIStatus = true;
        }
        return checkAllParagraphsInAPIStatus;
    }

    public boolean checkTimeToReadInAPI(Response response) {
        boolean checkTimeToReadInAPIStatus;
        String expectedTimeToReadFromAPI = RestUtils.getValueFromResponse(response, "content[0].timeToRead");
        String actualTimeToReadFromUI = commonFunctions.getElementText(timestamp);
        checkTimeToReadInAPIStatus = commonFunctions.checkTextContains(expectedTimeToReadFromAPI, actualTimeToReadFromUI, "TimeToRead in API");
        return checkTimeToReadInAPIStatus;
    }

    public boolean checkURLChangedToNotificationURL() {
        boolean checkURLChangedToNotificationURLStatus;
        commonFunctions.clickElement(notificationBell, 10, "Notification Bell");
        String expectedURL = Utils.getUrl() + "notifications";
        commonFunctions.waitForURLToBe(expectedURL);
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToNotificationURLStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "Notification URL");
        return checkURLChangedToNotificationURLStatus;
    }

    public boolean checkNotificationTitle() {
        boolean checkNotificationTitleStatus;
        String notificationTitle = commonFunctions.getTitle();
        checkNotificationTitleStatus = commonFunctions.checkTextEquals("Notifications - mint", notificationTitle, "Notification Page Title");
        return checkNotificationTitleStatus;
    }

    public boolean checkFavicon(String faviconURL) {
        boolean checkFaviconStatus;
        checkFaviconStatus = commonFunctions.checkPropertyContains(favIcon, "href", faviconURL, "Favicon");
        return checkFaviconStatus;
    }

    public boolean checkBlueDotIsRemoved() {
        boolean checkBlueDotIsRemovedStatus;
        checkBlueDotIsRemovedStatus = commonFunctions.checkPropertyContains(notificationBell, "style", "display: none;", "Notification Blue Icon");
        return checkBlueDotIsRemovedStatus;
    }

    public boolean checkNotificationInAPI(String apiURL) {
        boolean checkNotificationInAPIStatus;
        String actualFirstStoryNotificationFromUI = commonFunctions.getElementText(notificationFirstStory);
        Response response = RestUtils.sendGetRequest(apiURL);
        String expectedFirstStoryNotificationFromAPI = RestUtils.getValueFromResponse(response, "[0].headline");
        checkNotificationInAPIStatus = commonFunctions.checkTextContains(expectedFirstStoryNotificationFromAPI, actualFirstStoryNotificationFromUI, "Notification FirstStory in API");
        return checkNotificationInAPIStatus;
    }

    public boolean checkURLChangedToMarketStatsURL(String marketStatsURL) {
        boolean checkURLChangedToMarketStatsURLStatus;
        commonFunctions.waitForURLContains(marketStatsURL);
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToMarketStatsURLStatus = commonFunctions.checkTextEquals(marketStatsURL, actualURL, "Market Stats URL");
        return checkURLChangedToMarketStatsURLStatus;
    }

    public void ClickMarketTickerUntilVisible(WebElement element, String elementName) {
        boolean clickstatus=false;
        for (int i = 1; i <= 10; i++) {
            /*try {
                commonFunctions.clickElement(element, 10, elementName);
                break;
            } catch (Exception e) {
                *//* commonFunctions.scrollToElement(marketPrevIcon,"Market Previous Icon");
-                commonFunctions.dummyWait(1);*//*
                commonFunctions.clickElement(marketNextIcon, 3, "Market Previous Icon");
                if (i == 10) {
                    commonFunctions.clickElement(element, 10, elementName);
                }
            }*/
            clickstatus=commonFunctions.clickElement(element,10,elementName);
            if(clickstatus==true || i==10 )
            {
                break;
            }
            else
            {
                commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
            }
        }
    }

    public boolean checkEachMarketLandingPagesAreNotBlank() {
        boolean checkEachMarketLandingPagesAreNotBlankStatus;

        ClickMarketTickerUntilVisible(marketNifty, "Market Nifty");
        commonFunctions.isElementDisplayed(marketNiftyLanding, 10, "Market Nifty Landing Page");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInNiftyPage = checkOrderListPresentInTheMarketTicker();

        ClickMarketTickerUntilVisible(marketNiftyBank, "Market Nifty Bank");
        commonFunctions.isElementDisplayed(marketNiftyBankLanding, 10, "Market Nifty Bank Landing Page");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInNiftyBankPage = checkOrderListPresentInTheMarketTicker();


        commonFunctions.isElementClickable(marketNifty,10,"Market Nifty");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        //ClickMarketTickerUntilVisible(marketSilver, "Market Silver");
        //commonFunctions.isElementDisplayed(marketSilverLanding, 10, "Market Silver Landing Page");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        //boolean checkOrderListPresentInTheMarketTickerInSilverPage = checkOrderListPresentInTheMarketTicker();


        commonFunctions.isElementClickable(marketNifty,10,"market Nifty");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        //ClickMarketTickerUntilVisible(marketGold, "Market Gold");
        //commonFunctions.isElementDisplayed(marketGoldLanding, 10, "Market Gold Landing Page");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        //boolean checkOrderListPresentInTheMarketTickerInGoldPage = checkOrderListPresentInTheMarketTicker();


        commonFunctions.isElementClickable(marketNifty,10,"Market Nifty");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        commonFunctions.clickElement(marketNextIcon, 3, "Market Next Icon");
        ClickMarketTickerUntilVisible(marketBSEMidCap, "Market BSE MidCap");
        commonFunctions.isElementDisplayed(marketBSEMidCapLanding, 10, "Market BSE MidCap Landing Page");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInBSEMidCapPage = checkOrderListPresentInTheMarketTicker();

        if (checkOrderListPresentInTheMarketTickerInBSEMidCapPage && checkOrderListPresentInTheMarketTickerInNiftyPage && checkOrderListPresentInTheMarketTickerInNiftyBankPage) {
            checkEachMarketLandingPagesAreNotBlankStatus = true;
        } else {
            checkEachMarketLandingPagesAreNotBlankStatus = false;
        }
        return checkEachMarketLandingPagesAreNotBlankStatus;
    }

    public boolean checkOrderListPresentInTheMarketTicker() {
        boolean checkOrderListPresentInTheMarketTickerStatus;
        if (marketTickerElementList.size() > 3) {
            Utils.logStepInfo(true, "Ordered list is present in the Market ticker");
            checkOrderListPresentInTheMarketTickerStatus = true;
        } else {
            Utils.logStepInfo(false, "Ordered list is NOT present in the Market ticker");
            checkOrderListPresentInTheMarketTickerStatus = false;
        }
        return checkOrderListPresentInTheMarketTickerStatus;
    }

    public void navigateToMyReadsPage() {
        commonFunctions.clickElement(humburgIcon, 10, "Humburger Icon");
        commonFunctions.clickElement(myReadsMenu, 10, "MyReads Menu");
    }

    public boolean checkBookmarkedStoryIdInBookmarkSwiperBox(String bookmarkStoryId, boolean isAvailable) {
        boolean checkBookmarkedStoryIsAvailableInBookmarkSwiperBoxStatus;
        ArrayList<String> bookmarkStoryIdList = new ArrayList<String>();
        for (WebElement e : bookmarksSwiperBoxElementsList) {
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

    public boolean checkBookMarkIconIsActive() {
        boolean checkBookMarkIconIsActiveStatus = false;
        commonFunctions.scrollToElement(firstImage, "First Image");
        commonFunctions.closePopupIfExist(closeButtonForUnlimitedDigitalAccessPopup, "Unlimited Digital Access");
        String classProperty = commonFunctions.getProperty(bookmarkIcon, "class");
        if (!classProperty.contains("active")) {
            commonFunctions.clickElementWithJS(bookmarkIcon, 10, "BookMark Icon");
            classProperty = commonFunctions.getProperty(bookmarkIcon, "class");
        }
        if (classProperty.contains("active")) {
            Utils.logStepInfo(true, "Bookmark Icon class property contains active");
            checkBookMarkIconIsActiveStatus = true;
        } else {
            Utils.logStepInfo(false, "Bookmark Icon class property not contains active");
        }
        return checkBookMarkIconIsActiveStatus;
    }

    public ArrayList<String> getAllParagraphsFromUI() {
        ArrayList<String> allParagraphsFromUI = new ArrayList<String>();
        String firstParagraph = commonFunctions.getElementText(paragraph);
       // firstParagraph = firstParagraph.substring(firstParagraph.indexOf(":") + 1, firstParagraph.length());
        allParagraphsFromUI.add(firstParagraph);
        for (int i = 0; i < allParagraphsElementListFromUI.size() - 1; i++) {
            String paragraph = allParagraphsElementListFromUI.get(i).getAttribute("textContent");
            paragraph = Utils.formatAPIText(paragraph);
            allParagraphsFromUI.add(paragraph);
        }
        return allParagraphsFromUI;
    }

    public boolean checkDataUsingStoryAPI(String methodName, String expectedValue, String elementName, String jsonPath, String apiURL) {
        boolean checkDataUsingStoryAPIStatus;
        String storyId = commonFunctions.getStoryIdFromURL();
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        String actualValueFromAPI = RestUtils.getValueFromResponse(response, jsonPath);
        actualValueFromAPI = Utils.formatAPIText(actualValueFromAPI);
        System.out.println(actualValueFromAPI);

        checkDataUsingStoryAPIStatus = commonFunctions.checkTextContains(expectedValue, actualValueFromAPI, elementName);
        return checkDataUsingStoryAPIStatus;
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

    public boolean checkSitemapPageTitle() {
        boolean checkSitemapPageTitleStatus;
        String sitemapTitle = commonFunctions.getTitle();
        checkSitemapPageTitleStatus = commonFunctions.checkTextEquals("Sitemap - mint", sitemapTitle, "Sitemap Page Title");
        return checkSitemapPageTitleStatus;
    }

    public boolean checkAllLinksInSitemap() {
        boolean checkAllLinksInSitemapStatus;
        boolean isAnyLinkFailed = false;
        String url;
        HttpURLConnection huc;
        for (int i = 0; i < siteMapLinksElementList.size(); i++) {
            url = siteMapLinksElementList.get(i).getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println(i + 1 + " - " + url + ", URL is either not configured for anchor tag or it is empty");
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("GET");
                huc.connect();
                int respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    isAnyLinkFailed = true;
                    Utils.logStepInfo(false, i + 1 + " - " + url + ", URL verification failed in API. Expected Response code: 200, Actual Response code: " + respCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (isAnyLinkFailed) {
            checkAllLinksInSitemapStatus = false;
        } else {
            checkAllLinksInSitemapStatus = true;
            Utils.logStepInfo(true, "All URLs verified successfully");
        }
        return checkAllLinksInSitemapStatus;
    }

    public boolean checkURLChangedToSitemapURL(String siteMapURL) {
        boolean checkURLChangedToSitemapURLStatus;
        String expectedURL = Utils.getUrl() + siteMapURL;
        commonFunctions.waitForURLContains(".html");
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToSitemapURLStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "Sitemap URL");
        return checkURLChangedToSitemapURLStatus;
    }

    public boolean checkSocialMediaShare(WebElement element, String elementName, String expectedText) {
        boolean checkSocialMediaShare;
        String parentWin = driver.getWindowHandle();
        commonFunctions.clickElement(element, 10, elementName);
        commonFunctions.waitForPageLoading();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        commonFunctions.switchToWindow(subWindowHandler);
        checkSocialMediaShare = commonFunctions.checkPageURL(expectedText, 10, elementName);
        commonFunctions.closeAllWindowsExceptMasterTab();
        driver.switchTo().window(parentWin);
        return checkSocialMediaShare;
    }

    public boolean checkShareIcon(WebElement element, String elementName) {
        boolean checkShareIconStatus;
        commonFunctions.clickElementWithJS(element, 10, elementName);
        commonFunctions.waitForPageLoading();
        commonFunctions.waitForWindow(1);
        checkShareIconStatus = commonFunctions.isElementClickable(shareIcon, 10, "Share Icon");
        return checkShareIconStatus;
    }

    public boolean checkPageTitleHoveringFavicon(String faviconURL) {
        boolean checkFaviconStatus;
        checkFaviconStatus = commonFunctions.checkPropertyContains(favIcon, "text", faviconURL, "Favicon");
        return checkFaviconStatus;
    }


    @Override
    public boolean pageTitle() {
        boolean pageTitleStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean checkHomePageTitleStatus = checkPageTitle(homePage, "Business News Today:", "Mint Home Page Title");
        boolean checkLatestPageTitleStatus = checkPageTitle(latestPage, "Latest News Today:", "Mint Latest Page Title");
        /*boolean checkTrendingPageTitleStatus = checkPageTitle(trendingPage, "Trending News: Today's Trending News, Viral News, Popular News Headlines - Mint", "Mint Trending Page Title");
        boolean checkPremiumPageTitleStatus = checkPageTitle(premiumPage, "Read Premium News and Stories on Mint", "Mint Premium Page Title");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(marketsArrow, 10, "marketsArrow");
        commonFunctions.scrollToElement(marketsArrow, "marketsArrow");
        commonFunctions.clickElement(stockMarket, 10, "stockMarket");
        closeAllThePopups();
        boolean checkStockMarketTitleStatus = checkPageTitle(stockMarketHeadline, stockMarketHeadline.getText(), "Stock Market Headline");
        commonFunctions.clickElement(explore, 10, "Explore");
        boolean checkNewsArticleTitleStatus = checkPageTitle(news, "News: Latest Breaking News, National News, World News - Mint", "Section Title");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(subArrow, 10, "subArrow");
        boolean checkSubSectionPageTitleStatus = checkPageTitle(subNews, "Company News: Latest Company News, Indian Company News, Company News Headlines", "News Subsection");
        commonFunctions.clickElement(homePage, 10, "Home Page");
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(premiumPage, "Premium");
        commonFunctions.isElementDisplayed(longStory, 10, "Page Title");
        boolean checkLongStoryTitleStatus = checkPageTitle(longStory, longStory.getText(), "Long Story");
*/
        if (checkHomePageTitleStatus && checkLatestPageTitleStatus) {// && checkTrendingPageTitleStatus && checkPremiumPageTitleStatus && checkStockMarketTitleStatus && checkNewsArticleTitleStatus && checkSubSectionPageTitleStatus && checkLongStoryTitleStatus) {
            pageTitleStatus = true;
        } else {
            pageTitleStatus = false;
        }
        return pageTitleStatus;
    }

    public boolean checkPageTitle(WebElement element, String expectedText, String elementName) {
        boolean checkPageTitleStatus;
        commonFunctions.clickElement(element, 10, elementName);
        commonFunctions.waitForPageLoading();
        checkPageTitleStatus = commonFunctions.checkPageTitle(expectedText, 10, elementName);
        return checkPageTitleStatus;
    }

    public boolean changeName(String newName, String oldName) {
        boolean changeNameStatus;
        commonFunctions.clickElementWithJS(name, 10, "Name");
        commonFunctions.sendKey(nameTemp, newName);
        commonFunctions.clickElementWithJS(saveButton, 10, "Save Button");
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElementWithJS(pageTitle, 10, "Mint Title");
        commonFunctions.clickElementWithJS(myAccount, 10, "My account click");
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(accountName, 20, "Name Displayed");
        commonFunctions.clickElementWithJS(profile, 10, "profile");
        commonFunctions.clickElement(name, 10, "Name");
        commonFunctions.sendKey(nameTemp, oldName);
        commonFunctions.clickElementWithJS(saveButton, 10, "Save Button");
        changeNameStatus = commonFunctions.isElementDisplayed(pageTitle, 10, "Home Page");
        return changeNameStatus;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        boolean changePasswordStatus;
        commonFunctions.clickElement(pageTitle, 10, "Home Page");
        commonFunctions.clickElement(myAccount, 10, "My Account");
        commonFunctions.isElementDisplayed(accountName, 20, "Name Displayed");
        commonFunctions.isElementDisplayed(profile, 10, "profile");
        commonFunctions.clickElement(profile, 10, "profile");
        commonFunctions.clickElement(password, 10, "Password");
        commonFunctions.sendKey(oldPasswordTextField, oldPassword);
        commonFunctions.sendKey(newPasswordTextField, newPassword);
        commonFunctions.sendKey(confirmPasswordTextField, newPassword);
        commonFunctions.clickElement(updateBtn, 10, "Update Button");
        commonFunctions.clickElement(password, 10, "Password");
        commonFunctions.sendKey(oldPasswordTextField, newPassword);
        commonFunctions.sendKey(newPasswordTextField, oldPassword);
        commonFunctions.sendKey(confirmPasswordTextField, oldPassword);
        commonFunctions.clickElement(updateBtn, 10, "Update Button");
        changePasswordStatus = commonFunctions.isElementDisplayed(gender, 10, "Gender");
        return changePasswordStatus;
    }

    public boolean checkEmailIDUsedForLogin(String email,String userName) {
        boolean checkEmailIDUsedForLoginStatus;
        String emailText = commonFunctions.getElementText(userEmailUsed);
//        actualEmail = actualEmail.replaceAll("qaautomation"+"Edit", "").replaceAll("\n", "").trim();
        String[] Ele1 = emailText.split(userName, 2);
        String  actualEmail= Ele1[Ele1.length - 1].trim();
        checkEmailIDUsedForLoginStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID");
        return checkEmailIDUsedForLoginStatus;
    }

    @Override
    public boolean checkHamburger() {
        boolean checkHamburgerStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.clickElement(explore, 10, "explore");
        boolean isHamburgerPresent = commonFunctions.isElementDisplayed(hamburgerElement, 10, "hamburgerElement");
        boolean isHamburgerNotBlank = checkHamburgerNotBlank();
        checkTopMostHamburgerElements();
        boolean checkLinksInHamburgerStatus = checkAllLinksInHamburger();
        commonFunctions.clickElementWithJS(explore,10,"");
        commonFunctions.isElementDisplayed(hamburgerOverlay,10,"hamburger overlay");
        commonFunctions.clickElement(hamburgerOverlayOutside,10,"Click outside");
        commonFunctions.dummyWait(10);
        boolean isHamburgerPresentAfterClickingOutside = commonFunctions.isElementNotDisplayed(hamburgerOverlayOutside, 10, "hamburger");

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
                commonFunctions.scrollToElement(hamburgerList.get(i), "Scrolled to:: " + i);
                commonFunctions.dummyWait(10);
                String hrefValue = hamburgerList.get(i).getAttribute("href");
                String propValue = hamburgerList.get(i).getAttribute("text").toLowerCase();
                isLinkDisplayed = commonFunctions.isElementDisplayed(hamburgerList.get(i), 10, propValue);
                isLinkClickable = commonFunctions.isElementClickable(hamburgerList.get(i), 10, propValue);
                hamburgerList.get(i).click();
                String hrefNew = globalVars.getWebDriver().getCurrentUrl();
                String textHref = hrefNew.substring(0, hrefNew.indexOf(".", hrefNew.indexOf(".") + 1));
                String liveMintUrlTrim = Utils.getUrl().replace(".com/", "");
                if (!textHref.equalsIgnoreCase(liveMintUrlTrim)) {
                    isURLCorrectStatus = commonFunctions.checkPageURL("https://lifestyle.livemint.com/", 10, "");
                    isPageBrokenStatus = checkElementNotPresent(error);
                    System.out.println(driver.getCurrentUrl());
                    globalVars.getWebDriver().navigate().back();
                    commonFunctions.waitForPageLoading();
                    commonFunctions.clickElement(explore, 10, "explore");
                } else if (propValue.contains("podcast")) {
                    commonFunctions.switchToChildWindowsExceptMasterTab();
                    isURLCorrectStatus = commonFunctions.checkPageURL("https://www.livemint.com/podcast", 10, "");
                    isPageBrokenStatus = checkElementNotPresent(error);
                    commonFunctions.closeAllWindowsExceptMasterTab();
                } else if (propValue.contains("subscription")) {
                    commonFunctions.switchToChildWindowsExceptMasterTab();
                    isURLCorrectStatus = commonFunctions.checkPageURL("https://www.mintreaders.com/login.php", 10, "");
                    isPageBrokenStatus = checkElementNotPresent(error);
                    commonFunctions.closeAllWindowsExceptMasterTab();
                } else if (propValue.contains("lm brand stories")) {
                    commonFunctions.switchToChildWindowsExceptMasterTab();
                    isURLCorrectStatus = commonFunctions.checkPageURL("http://www.htbrandstudio.com/platforms/mint", 10, "");
                    isPageBrokenStatus = checkElementNotPresent(error);
                    commonFunctions.closeAllWindowsExceptMasterTab();
                } else if (propValue.contains("apps")) {
                    isURLCorrectStatus = commonFunctions.checkPageURL(Utils.getUrl() + "Object/wC06rVfP6BTPgE8g39MR3M/appsHome.html", 10, "");
                    isPageBrokenStatus = checkElementNotPresent(error);
                    commonFunctions.clickElement(explore, 10, "explore");
                } else if (propValue.contains("events")) {
                    commonFunctions.switchToChildWindowsExceptMasterTab();
                    isURLCorrectStatus = commonFunctions.checkPageURL("http://events.livemint.com/", 10, "");
                    isPageBrokenStatus = checkElementNotPresent(error);
                    commonFunctions.closeAllWindowsExceptMasterTab();
                } else {
                    isURLCorrectStatus = commonFunctions.checkPageURL(hrefValue, 10, "");
                    isPageBrokenStatus = checkElementNotPresent(error);
                    commonFunctions.clickElement(explore, 10, "explore");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            System.out.println("Not found in page");
        }
        return checkHamburgerNotBlankStatus;
    }

    public boolean checkElementNotPresent(WebElement element) {
        boolean isElementStatus;
        try {
            if (!element.isDisplayed()) {
                isElementStatus = true;
                Utils.logStepInfo("Page not broken");
            } else {
                isElementStatus = false;
                Utils.logStepInfo("Page broken");
            }

        } catch (Exception e) {
            isElementStatus = true;
            Utils.logStepInfo("Page not broken");
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
        } catch (Exception ex) {
            checkAllLinksInHamburgerStatus = false;
        }
        return checkAllLinksInHamburgerStatus;
    }

    public static void closeAllThePopups() {
        commonFunctions.switchToFrame(googleAdFrame, 10, "Google Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup, "Close button in google popup", 6);
        commonFunctions.switchToFrame(googleAdFrame2, 6, "Google Ad Frame2");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup2, "Close button in google popup", 6);
        commonFunctions.switchToFrame(notificationAdFrame, 6, "Notification Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonInFivePercentDiscountAdPopup, "Close button in Five percent discount popup", 6);
        commonFunctions.closePopupIfExist(closeButtonInDownloadTheAppAdPopup, "Close button in Download the ad popup", 6);
        commonFunctions.switchToDefaultContent();
    }

    @Override
    public boolean checkDuplicateEntriesForLatestNews() {
        boolean checkDuplicateEntriesForLatestNewsStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(latestPage, 10, "latest page");
        commonFunctions.waitForURLContains(Utils.getUrl() + "latest-news");
        boolean checkPageURLStatus = commonFunctions.checkPageURL(Utils.getUrl() + "latest-news", 10, "latest-news");
        boolean checkDuplicateEntriesForHeadlinesInLatestNewsStatus = checkDuplicateEntriesForHeadlinesInLatestNews();
        boolean checkDuplicateEntriesForStoryIdsInLatestNewsStatus = checkDuplicateEntriesForStoryIdsInLatestNews();
        if (checkPageURLStatus && checkDuplicateEntriesForHeadlinesInLatestNewsStatus && checkDuplicateEntriesForStoryIdsInLatestNewsStatus) {
            checkDuplicateEntriesForLatestNewsStatus = true;
        } else {
            checkDuplicateEntriesForLatestNewsStatus = false;
        }
        return checkDuplicateEntriesForLatestNewsStatus;
    }

    @Override
    public boolean checkStoryPageWidgets() {
        boolean checkStoryPageWidgetsStatus = false;
        boolean elementDisplayed=true;
        boolean similarStoriesOrMoreFromThisSectionStatus=false;
        int scrollCount=0;
        commonFunctions.navigateToURL(globalVars.getURL()+"/news");
        //commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        elementDisplayed=commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        String firstStorySection=commonFunctions.getAttributeValue(sectionTagOfFirstStory,10,"data-vars-subsection");
        if(firstStorySection.equalsIgnoreCase("Live Blog"))
        {
            commonFunctions.clickElementIfDisplayed(imageOffirstNoncardStory,30,"First story in list view");
            commonFunctions.waitForURLContains(".html");
        }
        else {

            checkFirstHeadline(); // check story opens
        }

        //commonFunctions.scrollToElementView(similarStoriesOrMoreFromThisSection,10,"Similar stories widget");
        while(!similarStoriesOrMoreFromThisSectionStatus && scrollCount<=5) {
            commonFunctions.scrollDownOnce();
            similarStoriesOrMoreFromThisSectionStatus = commonFunctions.isElementDisplayed(similarStoriesOrMoreFromThisSection, 10, "similarStoriesOrMoreFromThisSection");
            scrollCount++;
        }
        boolean checkWidgetStatus = checkWidget();
        if (elementDisplayed && similarStoriesOrMoreFromThisSectionStatus && checkWidgetStatus) {
            checkStoryPageWidgetsStatus = true;
        } else {
            checkStoryPageWidgetsStatus = false;
        }
        return checkStoryPageWidgetsStatus;
    }

    @Override
    public boolean checkLMPremiumPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkRHSWidgetsHomePage(String[] params) {
        boolean checkRHSWidgetsOnHomePageStatus;
        String trending = params[0];
        String latest = params[1];
        String primer = params[2];
        String longStory = params[3];
        String premium = params[4];
        String popularVideos = params[5];
        String companies = params[6];
        String theWallStreetJournal = params[7];
        String personalFinance = params[8];
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(10);
        boolean theWallStreetWidgetStatus = checkWidget(theWallStreetJournalWidget, theWallStreetJournal, wsjWidgetHeadline, 10);
        System.out.println(theWallStreetWidgetStatus + "RHS WSJ");
        boolean trendingWidgetStatus = checkWidget(trendingWidget, trending, trendingWidgetHeadline, 10);
        System.out.println(trendingWidgetStatus + "RHS TRE");
        boolean latestWidgetStatus = checkWidget(latestWidget, latest, latestWidgetHeadline, 10);
        System.out.println(latestWidgetStatus + "RHS Latest");
        boolean primerWidgetStatus = checkWidget(primerWidget, primer, primerWidgetHeadline, 10);
        System.out.println(primerWidgetStatus + "RHS Primer");
        boolean longStoryWidgetStatus = checkWidget(longStoryWidget, longStory, longStoryWidgetHeadline, 10);
        System.out.println(longStoryWidgetStatus + "RHS LongStory");
        boolean premiumWidgetStatus = checkWidget(premiumWidget, premium, premiumWidgetHeadline, 10);
        System.out.println(premiumWidgetStatus + "RHS Premium");
        boolean popularWidgetStatus = checkWidget(popularVideosWidget, popularVideos, popularVideosWidgetHeadline, 10);
        System.out.println(popularWidgetStatus + "RHS Popular");
        boolean companiesWidgetStatus = checkWidget(companiesWidget, companies, companiesWidgetHeadline, 10);
        System.out.println(companiesWidgetStatus + "RHS Companies");

        boolean personalFinanceWidgetStatus = checkWidget(personalFinanceWidget, personalFinance, personalFinanceWidgetHeadline, 10);
        System.out.println(personalFinanceWidgetStatus + "RHS PersonalFinance");
        if (trendingWidgetStatus && latestWidgetStatus && primerWidgetStatus && longStoryWidgetStatus && premiumWidgetStatus && popularWidgetStatus && companiesWidgetStatus && theWallStreetWidgetStatus && personalFinanceWidgetStatus) {
            checkRHSWidgetsOnHomePageStatus = true;
        } else {
            checkRHSWidgetsOnHomePageStatus = false;
        }
        return checkRHSWidgetsOnHomePageStatus;
    }


    public boolean checkWidget(WebElement widgetElement, String elementName, List<WebElement> storyHeadlineElementsInWidget, int timeOutInSecond) {
        boolean checkWidgetStatus;
        boolean checkStoryHeadlinesStatus, checkWidgetText;
        String actualWidgetText = commonFunctions.getElementText(widgetElement, timeOutInSecond);
         if(!"The Wall street Journal".equals(elementName))
        {
        if (actualWidgetText.equals(elementName))

        {
            checkWidgetText = commonFunctions.isElementDisplayed(widgetElement, timeOutInSecond, elementName);
        }else{
            checkWidgetText = commonFunctions.checkTextContains(elementName, actualWidgetText, elementName);
        }
        }
        else
        {
            checkWidgetText= commonFunctions.isElementDisplayed(theWallStreetJournalWidget,10,"WSJ");
        }
        checkStoryHeadlinesStatus = checkDuplicateEntriesForHeadlines(elementName, storyHeadlineElementsInWidget);
        if (checkWidgetText && checkStoryHeadlinesStatus) {
            checkWidgetStatus = true;
        } else {
            checkWidgetStatus = false;
        }
        return checkWidgetStatus;
    }

    public boolean checkDuplicateEntriesForHeadlines(String elementName, List<WebElement> storyHeadlineElementsInWidget) {
        boolean isDuplicateFound = false, checkAllHeadlines;
        ArrayList<String> allHeadlines = new ArrayList<String>();
        for (int i = 0; i < storyHeadlineElementsInWidget.size() - 1; i++) {
            //TODO: Please do not use articles for the name of WebElement.
            //TODO: Use for eg: widgetHeadlines
            String headline = storyHeadlineElementsInWidget.get(i).getAttribute("textContent");
            allHeadlines.add(headline);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < allHeadlines.size(); i++) {
            if (set.contains(allHeadlines.get(i))) {
                Utils.logStepInfo(false, "Duplicate Headline found: " + allHeadlines.get(i));
                isDuplicateFound = true;
            } else {
                set.add(allHeadlines.get(i));
            }
        }

        if (isDuplicateFound) {
            checkAllHeadlines = false;
            Utils.logStepInfo(true, "All Headlines size in " + elementName + ": " + allHeadlines.size());
            Utils.logStepInfo(true, "All Headlines in " + elementName + ": " + allHeadlines);
        } else {
            checkAllHeadlines = true;
            Utils.logStepInfo(true, " Verified unique Entries successfully For Headlines in " + elementName);
        }
        return checkAllHeadlines;
    }

    public boolean checkWidget() {
        boolean checkWidgetStatus;
        boolean checkTitleForWidgetStatus = checkTitleForWidget();
        boolean checkNumberOStoriesInWidgetStatus = checkNumberOfStoriesInWidget();
        boolean checkLeftAndRightArrowFunctionalityStatus = checkLeftAndRightArrowFunctionality();
        boolean checkStoryNavigationStatus = checkStoryNavigation();
        if (checkTitleForWidgetStatus && checkNumberOStoriesInWidgetStatus && checkLeftAndRightArrowFunctionalityStatus && checkStoryNavigationStatus) {
            checkWidgetStatus = true;
        } else {
            checkWidgetStatus = false;
        }
        return checkWidgetStatus;
    }

    public void checkRecommendedWidget() {
        try {
            commonFunctions.scrollWithCoOrdinates(0, 1000);
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElement(recommended, "Recommended widget");
            commonFunctions.isElementDisplayed(recommended, 10, "Recommended widget");
        } catch (Exception e) {

        }
    }

    public boolean checkTitleForWidget() {
        boolean checkTitleForWidgetStatus;
        String actualTitle = commonFunctions.getElementText(similarStoriesOrMoreFromThisSection, 10);
        if ("RECOMMENDED FOR YOU".equals(actualTitle) || "SIMILAR STORIES".equals(actualTitle) || "TRENDING STORIES".equalsIgnoreCase(actualTitle)) {
            checkTitleForWidgetStatus = true;
        } else {
            checkTitleForWidgetStatus = false;
        }
        return checkTitleForWidgetStatus;
    }

    public boolean checkNumberOfStoriesInWidget() {
        boolean checkNumberOfStoriesInWidgetStatus;
        if (similarStoriesWidgetStories.size() == 8) {
            checkNumberOfStoriesInWidgetStatus = true;
        } else {
            checkNumberOfStoriesInWidgetStatus = false;
        }
        return checkNumberOfStoriesInWidgetStatus;
    }

    public boolean checkImageAndStoryHeadlineWidget() {
        boolean checkImageAndStoryHeadlineWidgetStatus;
        boolean checkStoryHeadlinesWidgetStatus = true;
        boolean checkStoryImagesWidgetStatus = true;
        for (int i = 0; i < similarStoriesWidgetStories.size() - 1; i++) {
            String headline = similarStoriesWidgetStories.get(i).getText();
            if (headline.isEmpty()) {
                checkStoryHeadlinesWidgetStatus = false;
                System.err.println("StoryHeadline is empty in 'MORE FROM THIS SECTION' or 'SIMILAR STORIES' Widget");
            }
        }

        for (int i = 0; i < similarStoriesWidgetImages.size() - 1; i++) {
            String datasrc = similarStoriesWidgetImages.get(i).getAttribute("data-src");
            if (datasrc.isEmpty()) {
                checkStoryImagesWidgetStatus = false;
                System.err.println("Story Image is empty in 'MORE FROM THIS SECTION' or 'SIMILAR STORIES' Widget");
            }
        }
        if (checkStoryHeadlinesWidgetStatus && checkStoryImagesWidgetStatus) {
            checkImageAndStoryHeadlineWidgetStatus = true;
        } else {
            checkImageAndStoryHeadlineWidgetStatus = false;
        }

        return checkImageAndStoryHeadlineWidgetStatus;

    }


    public boolean checkLeftAndRightArrowFunctionality() {
        boolean checkLeftAndRightArrowFunctionalityStatus, nextArrowInSimilarStoriesWidgetDisabledStatus, previousArrowInSimilarStoriesWidgetDisabledStatus;
        commonFunctions.scrollToElement(similarStoriesOrMoreFromThisSection, "similarStoriesOrMoreFromThisSection Widget");
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(nextArrowInSimilarStoriesWidget, 10, "Next Arrow In SimilarStoriesWidget");
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(2);
        String nextArrowClassPropertyValue = commonFunctions.getProperty(nextArrowInSimilarStoriesWidget, "class");
        if (nextArrowClassPropertyValue.contains("disabled")) {
            nextArrowInSimilarStoriesWidgetDisabledStatus = false;
            Utils.logStepInfo(false, " Next Arrow class value is Disabled");
        } else {
            nextArrowInSimilarStoriesWidgetDisabledStatus = true;
            Utils.logStepInfo(true, " Next Arrow class value is not Disabled");
        }
        commonFunctions.clickElementWithJS(previousArrowInSimilarStoriesWidget, 10, "Previous Arrow In SimilarStoriesWidget");
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(2);
        String prevArrowClassPropertyValue = commonFunctions.getProperty(previousArrowInSimilarStoriesWidget, "class");
        if (prevArrowClassPropertyValue.contains("disabled")) {
            previousArrowInSimilarStoriesWidgetDisabledStatus = true;
            Utils.logStepInfo(true, " Prev Arrow class value is Disabled");
        } else {
            previousArrowInSimilarStoriesWidgetDisabledStatus = false;
            Utils.logStepInfo(false, " Prev Arrow class value is not Disabled");
        }
        if (nextArrowInSimilarStoriesWidgetDisabledStatus && previousArrowInSimilarStoriesWidgetDisabledStatus) {
            checkLeftAndRightArrowFunctionalityStatus = true;
        } else {
            checkLeftAndRightArrowFunctionalityStatus = false;
        }
        return checkLeftAndRightArrowFunctionalityStatus;
    }

    public boolean checkStoryNavigation() {
        boolean checkStoryNavigationStatus;
        String expectedHeadline = commonFunctions.getElementText(fistStoryInSimilarStoriesWidget);
        expectedHeadline = expectedHeadline.substring(0, expectedHeadline.length() - 8);
        commonFunctions.clickElement(fistStoryInSimilarStoriesWidget, 10, "First story in SimilarStoriesWidget");
        commonFunctions.waitForURLContains(".html");
        String actualHeadline = commonFunctions.getElementText(widgetFirstStory);
        checkStoryNavigationStatus = commonFunctions.checkTextContains(expectedHeadline, actualHeadline, "First story in SimilarStoriesWidget");
        return checkStoryNavigationStatus;
    }

    public boolean checkDuplicateEntriesForHeadlinesInLatestNews() {
        boolean isDuplicateFound = false, checkAllHeadlines;
        ArrayList<String> allHeadlinesInLatestNews = new ArrayList<String>();
        for (int i = 0; i < latestNewsHeadlines.size() - 1; i++) {
            String headline = latestNewsHeadlines.get(i).getText();
            allHeadlinesInLatestNews.add(headline);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < allHeadlinesInLatestNews.size(); i++) {
            if (set.contains(allHeadlinesInLatestNews.get(i))) {
                Utils.logStepInfo(false, "Duplicate Headline found: " + allHeadlinesInLatestNews.get(i));
                isDuplicateFound = true;
            } else {
                set.add(allHeadlinesInLatestNews.get(i));
            }
        }

        if (isDuplicateFound) {
            checkAllHeadlines = false;
            Utils.logStepInfo(true, "All Headlines in Latest News size: " + allHeadlinesInLatestNews.size());
            Utils.logStepInfo(true, "All Headlines in Latest News: " + allHeadlinesInLatestNews);
        } else {
            checkAllHeadlines = true;
            Utils.logStepInfo(true, " Verified Duplicate Entries For Headlines in LatestNews successfully");
        }
        return checkAllHeadlines;
    }


    public boolean checkDuplicateEntriesForStoryIdsInLatestNews() {
        boolean isDuplicateFound = false, checkAllStoryIds;
        ArrayList<String> allStoryIdsInLatestNews = new ArrayList<String>();
        for (int i = 0; i < latestNewsStoryIds.size() - 1; i++) {
            String storyID = latestNewsStoryIds.get(i).getText();
            allStoryIdsInLatestNews.add(storyID);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < allStoryIdsInLatestNews.size(); i++) {
            if (set.contains(allStoryIdsInLatestNews.get(i))) {
                Utils.logStepInfo(false, "Duplicate StoryId found: " + allStoryIdsInLatestNews.get(i));
                isDuplicateFound = true;
            } else {
                set.add(allStoryIdsInLatestNews.get(i));
            }
        }

        if (isDuplicateFound) {
            checkAllStoryIds = false;
            Utils.logStepInfo(true, "All story ids in Latest News size: " + allStoryIdsInLatestNews.size());
            Utils.logStepInfo(true, "All story ids in Latest News: " + allStoryIdsInLatestNews);
        } else {
            checkAllStoryIds = true;
            Utils.logStepInfo(true, " Verified Duplicate Entries For story ids in LatestNews successfully");
        }
        return checkAllStoryIds;
    }

    @Override
    public boolean listenToArticle() {
        boolean listenToArticleStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean homePageArticleStatus=listenToArticleOperations(mintTitle,"Home");
        boolean latestPageArticleStatus=listenToArticleOperations(latestPage,"Latest");
        boolean trendingPageArticleStatus=listenToArticleOperations(marketsPage,"Markets");

        if (homePageArticleStatus && latestPageArticleStatus && trendingPageArticleStatus) {
            listenToArticleStatus = true;
        } else {
            listenToArticleStatus = false;
        }
        return listenToArticleStatus;
    }

    public boolean listenToArticleOperations(WebElement element, String elementName) {
        boolean listenToArticleOperationsStatus;
        //commonFunctions.scrollToElement(element,elementName);
        commonFunctions.clickElement(element, 10, "Mint Title");
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        String sectionOFirstStory=commonFunctions.getAttributeValue(sectionTagOfFirstStory,10,"data-vars-subsection");
        if(sectionOFirstStory.equalsIgnoreCase("Live Blog"))
        {
            commonFunctions.clickElement(imageOffirstNoncardStory,10,"Image of first story in list view");
        }
        else{
        commonFunctions.clickElement(firstStory, 10, "First Story");}

        commonFunctions.waitForURLContains(".html");
        String storyId = commonFunctions.getStoryIdFromURL();
        commonFunctions.scrollToElement(storyDetailFacebookIcon,"scroll to view");
        commonFunctions.isElementDisplayed(listenLabel, 10, "First Story");
        String listenArticleLabel = listenLabel.getText();
        boolean listenArticleLabelStatus=commonFunctions.checkTextEquals("Listen to this article", listenArticleLabel,"'Listen to this article' label" );
        boolean audioPlayerDisplayedStatus=commonFunctions.isElementDisplayed(audioPlayer, 10, "First Story");
        String mp3FileFormat= audioSource.getAttribute("type");
        boolean mp3FilePresent=commonFunctions.checkTextContains("mpeg", mp3FileFormat, "mp3 file");
        String storyIDMp3= audioSource.getAttribute("src");
        boolean storyIDStatus=commonFunctions.checkTextContains(storyId, storyIDMp3, "Story id in mp3");

        if (listenArticleLabelStatus && audioPlayerDisplayedStatus && mp3FilePresent && storyIDStatus) {
            listenToArticleOperationsStatus = true;
        } else {
            listenToArticleOperationsStatus = false;
        }
        return listenToArticleOperationsStatus;
    }

    @Override
    public boolean checkHindustanWidgetHomePage(String[] params) {
        boolean checkHindustanWidgetOnHomePageStatus,checkHindustanWidgetStatus;
        String htURL = params[0];
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(mintTitle, 60, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(2);
        commonFunctions.scrollToTop();
        commonFunctions.dummyWait(2);
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(2);
        commonFunctions.scrollToTop();
        commonFunctions.dummyWait(2);
        commonFunctions.scrollToElementView(htWidget, 10,"Hindustan Times widget");
        checkHindustanWidgetStatus = commonFunctions.isElementDisplayed(htWidget, 10, "Hindustan Times widget");
        String actualViewAllText = commonFunctions.getElementText(viewAllHTWidget, 10);
        boolean actualViewAllStatus=commonFunctions.checkTextEquals("View All", actualViewAllText, "View All in HT Widget");
        boolean htURLStatus=checkURLChangedToHTURL(htURL);
        boolean checkHTWidgetStatus = checkHTWidget();
        if (checkHindustanWidgetStatus && actualViewAllStatus && htURLStatus && checkHTWidgetStatus) {
            checkHindustanWidgetOnHomePageStatus = true;
        } else {
            checkHindustanWidgetOnHomePageStatus = false;
        }
        return checkHindustanWidgetOnHomePageStatus;
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

    public boolean checkURLChangedToHTURL(String expectedURL) {
        boolean checkURLChangedToHTURL;
        commonFunctions.clickElementWithJS(viewAllHTWidget, 10, "View All");
        commonFunctions.waitForWindow(2);
        commonFunctions.switchToWindowWithTitle("News Headlines",10,2);
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToHTURL = commonFunctions.checkTextContains(expectedURL, actualURL, "HT URL");
        commonFunctions.closeAllWindowsExceptMasterTab();
        return checkURLChangedToHTURL;
    }

    public boolean checkHTWidget() {
        boolean checkWidgetStatus;
        boolean checkNumberOStories = checkNumberOfStoriesInWidget(htWidgetHeadlines,4);
        boolean checkImagesAreClickable = checkElementsAreClickableInWidget(htWidgetImages,10,"Image in HT Widget");
        boolean checkHeadlinesAreClickable = checkElementsAreClickableInWidget(htWidgetHeadlines,10,"Headline in HT Widget");
        boolean checkLeftAndRightArrowFunctionalityStatus = checkLeftAndRightArrowFunctionality(htWidget,"HT widget",prevArrowHTWidget,nextArrowHTWidget,10);
        boolean checkStoryOpensNewTabStatus = checkStoryOpensNewTab();
        if (checkNumberOStories && checkImagesAreClickable && checkHeadlinesAreClickable && checkLeftAndRightArrowFunctionalityStatus && checkStoryOpensNewTabStatus) {
            checkWidgetStatus = true;
        } else {
            checkWidgetStatus = false;
        }
        return checkWidgetStatus;
    }

    public boolean checkNumberOfStoriesInWidget(List<WebElement> elementList, int size) {
        boolean checkNumberOfStoriesInWidgetStatus;
        if (elementList.size() == size) {
            checkNumberOfStoriesInWidgetStatus = true;
        } else {
            checkNumberOfStoriesInWidgetStatus = false;
        }
        return checkNumberOfStoriesInWidgetStatus;
    }

    public boolean checkElementsAreClickableInWidget(List<WebElement> elementList, int timeOutInSecond, String elementName) {
        boolean checkImagesAreClickableWidget, isAnyLinkNotClickable = false;
        for (int i = 0; i < elementList.size() - 1; i++) {
            boolean status=commonFunctions.isElementClickable(elementList.get(i),timeOutInSecond,elementName);
            String link = elementList.get(i).getText();
            if (!status) {
                isAnyLinkNotClickable = true;
                System.err.println(elementName+" is not clickable: "+link);
            }
        }
        if (isAnyLinkNotClickable) {
            checkImagesAreClickableWidget = false;
        } else {
            checkImagesAreClickableWidget = true;
        }
        return checkImagesAreClickableWidget;
    }

    public boolean checkLeftAndRightArrowFunctionality(WebElement widgetElement, String widgetElementName, WebElement prevElement, WebElement nextElement, int timeOutSecond) {
        boolean checkLeftAndRightArrowFunctionalityStatus, nextArrowInSimilarStoriesWidgetDisabledStatus, previousArrowInSimilarStoriesWidgetDisabledStatus;
        commonFunctions.scrollToElement(widgetElement, widgetElementName);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(nextElement, timeOutSecond, "Next Arrow In "+widgetElementName);
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(2);
        String nextArrowClassPropertyValue = commonFunctions.getProperty(nextElement, "class");
        if (nextArrowClassPropertyValue.contains("disabled")) {
            nextArrowInSimilarStoriesWidgetDisabledStatus = true;
            Utils.logStepInfo(true, " Next Arrow class value is Disabled");
        } else {
            nextArrowInSimilarStoriesWidgetDisabledStatus = false;
            Utils.logStepInfo(false, " Next Arrow class value is not Disabled");
        }
        commonFunctions.clickElementWithJS(prevElement, timeOutSecond, "Previous Arrow In "+widgetElementName);
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(2);
        String prevArrowClassPropertyValue = commonFunctions.getProperty(prevElement, "class");
        if (prevArrowClassPropertyValue.contains("disabled")) {
            previousArrowInSimilarStoriesWidgetDisabledStatus = true;
            Utils.logStepInfo(true, " Prev Arrow class value is Disabled");
        } else {
            previousArrowInSimilarStoriesWidgetDisabledStatus = false;
            Utils.logStepInfo(false, " Prev Arrow class value is not Disabled");
        }
        if (nextArrowInSimilarStoriesWidgetDisabledStatus && previousArrowInSimilarStoriesWidgetDisabledStatus) {
            checkLeftAndRightArrowFunctionalityStatus = true;
        } else {
            checkLeftAndRightArrowFunctionalityStatus = false;
        }
        return checkLeftAndRightArrowFunctionalityStatus;
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

    public boolean checkStoryOpensNewTab() {
        boolean checkAllStoryNavigationStatus;
        boolean checkStoryNavigationStatus, isAnyStoryNavigationFailed = false;
        String parentWindowHandle=driver.getWindowHandle();
        for (int i = 0; i < htWidgetHeadlines.size() - 1; i++) {
            String linkHref = htWidgetHeadlines.get(i).getAttribute("href");
            linkHref=linkHref.substring(0,linkHref.indexOf(".html"));
            commonFunctions.clickElement(htWidgetHeadlines.get(i),10,"Link in HT Widget");
            commonFunctions.waitForWindow(2);
            commonFunctions.dummyWait(2);
            Set<String> allHandles=commonFunctions.getWindowHandlesAll();
            for(String handle:allHandles){
                if(!handle.equals(parentWindowHandle)){
                    driver.switchTo().window(handle);
                    String actualURL = commonFunctions.getCurrentURL();
                    actualURL=actualURL.substring(0,actualURL.indexOf(".html"));
                    checkStoryNavigationStatus = commonFunctions.checkTextEquals(linkHref, actualURL, "Link in HT Widget");
                    commonFunctions.closeAllWindowsExceptMasterTab();
                    if (!checkStoryNavigationStatus) {
                        isAnyStoryNavigationFailed = true;
                        Utils.logStepInfo(false," Story Navigation failed: "+linkHref);
                    }
                }

            }

        }
        if (isAnyStoryNavigationFailed) {
            checkAllStoryNavigationStatus = false;
        } else {
            checkAllStoryNavigationStatus = true;
            Utils.logStepInfo(true," All Story Navigation is successful in HT widget");
        }
        return checkAllStoryNavigationStatus;
    }

    @Override
    public boolean checkSignInLink() { return false; }
    @Override
    public boolean checkSubscribeLink() { return false; }
    @Override
    public boolean checkSubscribeRedirection(String choosePlan) { return false; }

    @Override
    public boolean checkSignInLinkRedirection(String loginRegisterText, String google, String facebook, String apple, String emailOrMobile) {
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
    public boolean checkMyaccountIcon() {
        return false;
    }

    @Override
    public boolean checkMarketCardtypePagefunctionality() {
        return false;
    }

    @Override
    public boolean checkSubTitleoFMutualFundPage() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        return false;
    }

    @Override
    public boolean checkMutualFundsWidgetAndSubCategoryDropDown() {
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
            if(commonFunctions.getCurrentURL().contains("page-5")){
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
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElementIfDisplayed(explore,10,"Click Explore button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand,10,"Scroll down to Mutual Funds");
        commonFunctions.clickElementIfDisplayed(mutualFundsTop50SubSection,10,"Click on Top 50 MF");
        isElementDisplayed &= checkMintLogo() && breadcrums.isDisplayed() && explore.isDisplayed() && ePaperOnHeader.isDisplayed()  && subscribeNowButton.isDisplayed() && offerHead.getText().equalsIgnoreCase("20% off*");
        isElementDisplayed &= driver.getTitle().equalsIgnoreCase(pageTitle);
        isElementDisplayed &= signInButton.isDisplayed();
        return isElementDisplayed;
    }

    @Override
    public boolean checkL1TabSelectionDiffStory() {
        return false;
    }

    @Override
    public boolean checkLoginInPage() {
        return false;
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
    public boolean checkMintTop50MFForSubscribedUsers(String pageTitle) {
        boolean isElementDisplayed=true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElementIfDisplayed(explore,10,"Click Explore button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand,10,"Scroll down to Mutual Funds");
        commonFunctions.clickElementIfDisplayed(mutualFundsTop50SubSection,10,"Click on Top 50 MF");
        isElementDisplayed &= checkMintLogo() && breadcrums.isDisplayed() && explore.isDisplayed() && ePaperOnHeader.isDisplayed()  && subscribeNowButton.isDisplayed() && offerHead.getText().equalsIgnoreCase("20% off*");
        isElementDisplayed &= driver.getTitle().equalsIgnoreCase(pageTitle);
        isElementDisplayed &= signInButton.isDisplayed();
        return isElementDisplayed;
    }

    @Override
    public boolean checkColumnsSubSectionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.mouseHoverOnElement(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementView(opinionExpand,10,"Opinion");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(columnsInOpinion, 5, "Columns in opinion");
            isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
            isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
            isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIconInStory, 5, "Bookmark Icon");
            isElementDisplayed &= commonFunctions.isElementDisplayed(shareIconInStory, 5, "Share Icon");
            isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory, 5, "Thumb");
            isElementDisplayed &= commonFunctions.isElementDisplayed(columnInHomepage, 5, "Columns in homepage");
            return isElementDisplayed;
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
    public boolean checkOpinionsSectionInTopNav() {
        return false;
    }

    @Override
    public boolean checkHeaderNavigationOfEachTab() {
        return false;
    }

    @Override
    public boolean checkViewsSubsectionStoryPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Columns in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoryTitles.get(0), 5, "Story titles");
        commonFunctions.clickElementIfDisplayed(listOfStoryTitles.get(0), 5, "Story titles");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listofStoryParagraphs.get(0), 20, "First Paragraph");
        return isElementDisplayed;
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
    public boolean checkViewsSubsectionPageLayout() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Columns in opinion");
        commonFunctions.clickElementIfDisplayed(denyNotification, 10, "I'll do this later Notification");
        commonFunctions.clickElementIfDisplayed(laterButtonOnNotification, 10, "later button Notification");
        isElementDisplayed &= commonFunctions.isElementDisplayed(mintLogo, 5, "Mint Logo");
        isElementDisplayed &= commonFunctions.isElementDisplayed(breadcrums, 5, "Breadcrumb");
        isElementDisplayed &= commonFunctions.isElementDisplayed(explore, 5, "Explore");
        isElementDisplayed &= commonFunctions.isElementDisplayed(signInButton, 5, "Sign in button");
        isElementDisplayed &= commonFunctions.isElementDisplayed(ePaperOnHeader, 5, "E paper on header");
        //isElementDisplayed &= commonFunctions.isElementDisplayed(getAppOnHeader, 5, "Get App button");
        isElementDisplayed &= commonFunctions.isElementDisplayed(subscribeNowButton, 5, "Subscribe now");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Views");
        return isElementDisplayed;
    }

    @Override
    public boolean checkIndustryPageLayout() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(industryExpand, 5, "Scroll down to Industry");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(industrySection, 5, "Industry section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(firstStoryInCardView, 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Third story");
        return isElementDisplayed;
    }

    @Override
    public boolean checkBreadcrumbOnCompaniesPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.clickElement(companiesInExplore,5,"Companies");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(firstStory,5,"First story in Companies page");
        commonFunctions.pageRefresh();
        isElementDisplayed &= commonFunctions.isElementDisplayed(breadcrums,5,"Breadcrumb");
        isElementDisplayed &=  commonFunctions.getElementText(breadcrums,5).contains("Home / Companies /");//headline can not verify because special characters remove from breadcrumb
        return isElementDisplayed;
    }

    @Override
    public boolean checkTwitterPageWhenTapOnTwitterIcon() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(marketExpand,5,"Scroll down to market");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(liveBlogSubsection,5,"Live-blog sub section");
        isElementDisplayed &= commonFunctions.clickElement(notificationFirstStory,5,"First story in live blog");
        commonFunctions.scrollToElementView(synopsisOfStory,5,"Synopsis of story");
        boolean clickTwitterShareStatus = checkSocialMediaShare(twitterIconOnStory, "Twitter Page", "twitter");
        return isElementDisplayed && clickTwitterShareStatus;
    }

    @Override
    public boolean checkLinkedinPageWhenTapOnLinkedinIcon() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(marketExpand,5,"Scroll down to market");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(liveBlogSubsection,5,"Live-blog sub section");
        isElementDisplayed &= commonFunctions.clickElement(notificationFirstStory,5,"First story in live blog");
        commonFunctions.scrollToElementView(synopsisOfStory,5,"Synopsis of story");
        boolean clickLinkedinShareStatus = checkSocialMediaShare(linkedinIconOnStory, "Linkedin Page", "linkedin");
        return isElementDisplayed && clickLinkedinShareStatus;
    }

    @Override
    public boolean checkFacebookPageWhenTapOnFacebookIcon() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(marketExpand,5,"Scroll down to market");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(liveBlogSubsection,5,"Live-blog sub section");
        isElementDisplayed &= commonFunctions.clickElement(notificationFirstStory,5,"First story in live blog");
        commonFunctions.scrollToElementView(synopsisOfStory,5,"Synopsis of story");
        boolean clickLinkedinShareStatus = checkSocialMediaShare(facebookIconOnStory, "Facebook Page", "facebook");
        return isElementDisplayed && clickLinkedinShareStatus;
    }

    @Override
    public boolean checkOpinionSectionStoryDetails() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionSection, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(firstStoryInCardView, 5, "First story in card view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story in list view");
        commonFunctions.clickElement(notificationFirstStory,5,"First story");
        commonFunctions.scrollToElementView(paragraph,10,"First paragraph of story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(paragraph, 5, "Paragraph Text");
        isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIconInStory, 5, "Bookmark Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailFacebookIcon, 10, "Facebook Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailLinkedinIcon, 10, "LinkedIn Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailTwitterIcon, 10, "Twitter Icon");
        return isElementDisplayed;
    }

    @Override
    public boolean checkShareholdingWidget() {
        boolean isElementDisplayed = true;
        commonFunctions.navigateToURL(globalVars.getURL()+"market/market-stats/stocks-vodafone-idea-share-price-nse-bse-s0003014");
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        isElementDisplayed &= commonFunctions.isElementDisplayed(stockMarketName,5,"Stock Market");
        for (int i=0;i<=5;i++) {
            if (commonFunctions.isElementNotDisplayed(shareHoldingTab,5,"Shareholding")) {
                commonFunctions.clickElement(stockNavNextButton,5,"Stock nav next button");
            } else {
                commonFunctions.clickElementIfDisplayed(shareHoldingTab,5,"Shareholding");
                break;
            }
        }
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareholdingWidget.get(0),5,"Shareholding Card");
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareholdingWidget.get(1),5,"Shareholding Pattern");
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareholdingWidget.get(2),5,"Shareholding Trend");
        return isElementDisplayed;
    }

    @Override
    public boolean checkCompaniesLandingPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.clickElement(companiesInExplore,5,"Companies");
        isElementDisplayed &= commonFunctions.isElementDisplayed(siteMapHeader,5,"Companies landing page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(firstStoryInCardView,5,"First story in card view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(0),5,"First story headline");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0),5,"Second story in list view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(1),5,"Second story headline");
        return isElementDisplayed;
    }

    @Override
    public boolean checkPodcastEpisodePage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(podcastSection, 5, "Scroll down to podcast");
        String podcastStoryName = commonFunctions.getElementText(podcastStory);
        commonFunctions.clickElement(podcastStory,5,"Podcast story");
        isElementDisplayed &= commonFunctions.getElementTextAndCheck(podcastPageTitle,"PODCAST EPISODES",5,"Podcast page title");
        isElementDisplayed &= commonFunctions.getElementTextAndCheck(podcastEpisodeTitle,podcastStoryName,5,"Podcast episode title");
        isElementDisplayed &= commonFunctions.isElementDisplayed(facebookIconOnPodcast,5,"Facebook icon on podcast");
        isElementDisplayed &= commonFunctions.isElementDisplayed(twitterIconOnPodcast,5,"Twitter icon on podcast");
        isElementDisplayed &= commonFunctions.isElementDisplayed(linkedinIconOnPodcast,5,"Linkedin icon on podcast");
        isElementDisplayed &= commonFunctions.isElementDisplayed(whatsappIconOnPodcast,5,"Whatsapp icon on podcast");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(seeMoreInPodcast,5,"See more in podcast");
        String podcastPop = commonFunctions.getElementText(podcastPopup);
        isElementDisplayed &= commonFunctions.checkTextContains(podcastStoryName,podcastPop,"Podcast pop up");
        commonFunctions.clickElement(podcastPopupClose,5,"Close button on podcast pop up");
        return isElementDisplayed;
    }

    @Override
    public boolean checkPodcastEpisode() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(podcastSection, 5, "Scroll down to podcast");
        commonFunctions.clickElement(podcastStory,5,"Podcast story");
        isElementDisplayed &= commonFunctions.getElementTextAndCheck(podcastPageTitle,"PODCAST EPISODES",5,"Podcast page title");
        commonFunctions.scrollDownOnce();
        String podcastEpisodeName = commonFunctions.getElementText(episodeName);
        isElementDisplayed &= commonFunctions.isElementDisplayed(mediaPlayer,5,"Media player on episode");
        isElementDisplayed &= commonFunctions.isElementDisplayed(episodeDate,5,"Date on episode");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(seemoreInEpisode,10,"See more in Episode");
        String podcastPop = commonFunctions.getElementText(podcastPopup);
        isElementDisplayed &= commonFunctions.checkTextContains(podcastEpisodeName,podcastPop,"Podcast pop up");
        commonFunctions.clickElement(podcastPopupClose,5,"Close button on podcast pop up");
        return isElementDisplayed;
    }

    @Override
    public boolean checkVideoListingLandingPageStructure() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(videosSection, 5, "Scroll down to videos");
        String actualURL = commonFunctions.getCurrentURL();
        isElementDisplayed &= commonFunctions.checkTextEquals("https://www.livemint.com/videos",actualURL,"Videos landing page URL");
        commonFunctions.scrollToElementView(listOfStoriesHeadline.get(10),70,"10th video story");
        commonFunctions.scrollToElementView(listOfStoriesHeadline.get(25),70,"25th video story");
        String actualURL1 = commonFunctions.getCurrentURL();
        isElementDisplayed &= commonFunctions.checkTextEquals("https://www.livemint.com/videos/page-2",actualURL1,"URL at 25th video");
        return isElementDisplayed;
    }

    @Override
    public boolean checkAuthorDetailsPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(mintAuthorSection, 5, "Scroll down to Mint authors");
        String actualURL = commonFunctions.getCurrentURL();
        isElementDisplayed &= commonFunctions.checkTextEquals("https://www.livemint.com/authors",actualURL,"Videos landing page URL");
        String authorName = commonFunctions.getElementText(listOfAuthors.get(0),5);
        commonFunctions.clickElement(listOfAuthors.get(0),5,"Author");
        isElementDisplayed &= commonFunctions.getElementTextAndCheck(authorsName,authorName,5,"Authors details page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(articlesByAuthors,5,"ARTICLES BY Authors name");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(0),5,"Article below Articles by Author name");
        return isElementDisplayed;
    }

    @Override
    public boolean checkAuthorPageLayout() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(mintAuthorSection, 5, "Scroll down to Mint authors");
        String actualURL = commonFunctions.getCurrentURL();
        isElementDisplayed &= commonFunctions.checkTextEquals("https://www.livemint.com/authors",actualURL,"Mint authors landing page URL");
        String searchBoxText = commonFunctions.getAtribute(searchBoxInAuhors,"placeholder");
        isElementDisplayed &= commonFunctions.checkTextEquals("Type here to search authors",searchBoxText,"Search Box");
        commonFunctions.dummyWait(5);
        if(alphabetSlider.size() == 27) {
            isElementDisplayed &= true;
        } else {
            isElementDisplayed &= false;
        }
        isElementDisplayed &= commonFunctions.isElementDisplayed(stockNavNextButton,5,"Slider icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(alphabetSlider.get(0),5,"All selected");
        isElementDisplayed &= commonFunctions.isElementDisplayed(siteMapHeader,5,"Mint authors");
        return isElementDisplayed;
    }

    @Override
    public boolean checkSportsLandingPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection, 5, "Scroll down to Sports");
        isElementDisplayed &= commonFunctions.isElementDisplayed(siteMapHeader,5,"Sports landing page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(firstStoryInCardView,5,"First story in card view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(0),5,"First story headline");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0),5,"Second story in list view");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesHeadline.get(1),5,"Second story headline");
        return isElementDisplayed;
    }

    @Override
    public boolean checkL1NavInSportsLandingPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection, 5, "Scroll down to Sports");
        isElementDisplayed &= commonFunctions.isElementDisplayed(siteMapHeader,5,"Sports landing page");
        isElementDisplayed &= commonFunctions.isElementDisplayed(l1Nav,5,"L1 on sports landing page");
        if (listOfSectionsInL1.size()== 12) {
            isElementDisplayed &= true;
        } else {
            isElementDisplayed &= false;
        }
        return isElementDisplayed;
    }

    @Description("Input Page name as param1 , Widget name(GainerLoser , 52WeekHighLow, ActiveStocks) in param2, Provide respective xpaths from widget in other params")
    @Override
    public boolean checkLHSGainerLoserWidget(String pageName, String widgetName)
    {
        return  commonFunctionsWebLM.checkLHSWidgetDisplayed("","GainerLoser",lhsGainerLoser,lhsLoserGainerDate,lhsLoserGainerDataLinks,lhsTopgainerCTA,lhsToploserCTA);

    }

    @Override
    public boolean checkMintPremiumCarousel() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        isElementDisplayed &=commonFunctions.scrollToElementView(mintPremiumCarousel,5,"Mint premium Carousel");
        if (listOfStoriesInMintPremium.size() == 10) {
            isElementDisplayed &= true;
        } else {
            isElementDisplayed &=false;
        }
        isElementDisplayed &= commonFunctions.checkElementText(premiumTag,"PREMIUM",5,"Premium tag");
        return isElementDisplayed;
    }

    @Override
    public boolean checkSummaryOnSportsStoryPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection, 5, "Scroll down to Sports");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(notificationFirstStory,5,"First story");
        isElementDisplayed &= commonFunctions.scrollToElementView(synopsisOfStory,5,"Summary of story");
        return isElementDisplayed;
    }

    @Override
    public boolean checkParagraphOnSportsPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection, 5, "Scroll down to Sports");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(notificationFirstStory,5,"First story");
        isElementDisplayed &= commonFunctions.scrollToElementView(paragraph,5,"First Paragraph");
        return isElementDisplayed;
    }
}
