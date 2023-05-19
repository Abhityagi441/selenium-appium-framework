package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.jayway.jsonpath.JsonPath;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonMarketPage;
import com.utils.GlobalVars;
import com.utils.ApiValidation;
import com.utils.Utils;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Market extends CommonMarketPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;

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
    @FindBy(id = "sectionp_politics")
    private static WebElement politics;



    @FindBy(xpath = "(//div[@class='subnavArrow'])[3]")
    private static WebElement expandMarkets;
    @FindBy(id = "sectionsub_markets_live blog")
    private static WebElement liveBlog;
    @FindBy(xpath = "(//h2[@class='headline'])[1]")
    private static WebElement blogHeadline;
    @FindBy(xpath = "(//h1[@class='headline'])[1]")
    private static WebElement blogOpenHeadline;
    @FindBy(xpath = "//figure[@data-vars-mediatype='image']")
    private static WebElement leadImage;
    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement caption;
    @FindBy(xpath = "((//aside[@class='fl'])[1]//a)[1]")
    private static WebElement firstStoryBookmark;
    @FindBy(xpath = "(//div[@onclick='share(this)'])[1]")
    private static WebElement firstStoryShare;
    @FindBy(xpath = "//div[contains(@class,'bcrumb')]")
    private static WebElement breadcrumb;
    @FindBy(xpath = "//div[contains(@class,'rightAd')][1]")
    private static WebElement topRightAd;

    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List <WebElement> iconsList;

    @FindBy(xpath = "//div[@class='whiteOverlay2']")
    private static WebElement hamburgerOverlay;

    @FindBy(xpath = "(//div[@class='listtostory clearfix'])[13]")
    private static WebElement marketsPageStory;
    @FindBy(xpath = "(//div[@class='listtostory clearfix'])[17]")
    private static WebElement marketsPageLStory;
    @FindBy(xpath = "(//div[@class='listtostory clearfix'])[24]")
    private static WebElement marketsPage2Story;

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

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement liveBlogTitle;


    @FindBy(xpath = "(//*[@class='headline'])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//div[@id='socialHolder'])[1]")
    private static WebElement iconsBox;

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

    @FindBy(xpath = "//div[@class='fr']//a[2]")
    private static WebElement myAccount;

    @FindBy(id = "fixedNav_latest")
    private static WebElement latestPage;

    @FindBy(xpath = "//a[contains(text(),'Trending')]")
    private static WebElement trendingPage;

    @FindBy(xpath = "//a[contains(text(),'Markets')]")
    private static WebElement marketsPage;

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

    @FindBy(xpath = "//a[@class='LinkCTA'][3]")
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

    @FindBy(xpath = "//section[@data-vars-cardtype='marketsindices']")
    private static WebElement listIndianIndices;


    @FindBy(xpath = "//h2[@class='cardheading'][1]")
    private static WebElement headerIndianIndices;

    @FindBy(xpath = "//h2[contains(@class,'cardheading fl')][1]")
    private static WebElement headerIndianIndicesdashboard;

    @FindBy(xpath = "//h2[@class='cardheading']")
    private static WebElement headerIndianIndicesdashboardniftbank;

    @FindBy(xpath = "(//div[contains(@class,'subnavArrow')]/img)")
    private static WebElement arrow;
/*
    @FindBy(xpath = "(//ol[contains(@class,'up clearfix')]//@class['up clearfix'][1])")
    private static WebElement expandedIndicesList;*/

    @FindBy(xpath = "(//div[@class='BSEHolder']//ol)")
    private static List<WebElement> expandedIndicesList;
    @FindBy(xpath = "//ul[@class='navCategories']/li/a")
    private static List<WebElement> hamburgerList;
    @FindBy(xpath = "//a[@class='newlink']")
    private static List<WebElement> indianIndList;
    @FindBy(xpath = "//a[@class='newlink']//li[1]")
    private static WebElement indianIndStock;
    @FindBy(xpath = "//a[@class='newlink']//li[2]")
    private static WebElement indianIndStockPrice;
    @FindBy(xpath = "//a[@class='newlink']//li[3]")
    private static WebElement indianIndStockPercent;
    @FindBy(xpath = "(//a[@class='newlink']//li[1])[1]")
    private static WebElement indianFirstIndice;
    @FindBy(xpath = "(//a[@class='newlink']//li[2])[1]")
    private static WebElement indianFirstIndicePrice;
    @FindBy(xpath = "(//a[@class='newlink']//li[3])[1]")
    private static WebElement indianFirstIndicePercent;

    @FindBy(xpath = "//ul[@class='navCategories']")
    private static WebElement hamburgerElement;

    @FindBy(xpath = "//div[@class='whiteOverlay2']")
    private static WebElement overlay;

    @FindBy(xpath = "//div[@class='errorHolder']")
    private static WebElement error;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement epaperIcon;
    @FindBy(xpath = "//a[@class='userSignin epaperheader']")
    private static WebElement signIn;
    @FindBy(xpath = "//button[@id='moe-dontallow_button']")
    private static WebElement laterPopUp;
    @FindBy(id = "phoneEmail")
    private static WebElement emailBox;
    @FindBy(id = "btSubmit")
    private static WebElement submitEmail;
    @FindBy(id = "upass")
    private static WebElement passwordBox;
    @FindBy(id = "btnLogin")
    private static WebElement continueLogin;
    @FindBy(id = "uName")
    private static WebElement subscribedUserName;



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

    @FindBy(xpath = "(//h2[@class='cardheading'])[1]")
    private static WebElement indianIndices;

    @FindBy(xpath = "//h2[@class='cardheading'][1]")
    private static WebElement indianIndicesmidcap;

    @FindBy(xpath = "(//section[@data-vars-cardtype='marketsindices'])[1]")
    private static WebElement indianIndicesList;

    @FindBy(xpath = "//div[@id='market-box-3']")
    private static WebElement indianIndicesListStatics;


    @FindBy(xpath = "(//a[@class='listLink']//li)[1]")
    private static WebElement bse100;
    @FindBy(xpath = "(//ol[@class='up clearfix'])[2]")
    private static WebElement bse200;
    @FindBy(xpath = "//img[@id='headerMintLogo']")
    private static WebElement mintLogo;
    @FindBy(xpath = "//a[@id='topic_Market Dashboard']")
    private static WebElement marketDashboard;
    @FindBy(xpath = "//div[@id='market-box-2']/div[1]/button[2]")
    private static WebElement niftyBankTicker;
    //div[@id='marketTicker']//ol)[3]
    @FindBy(xpath = "(//a[@class='listLink']//li)[17]")
    private static WebElement bseMidcapTicker;
    @FindBy(xpath = "//a[contains(@class,'btnViewAll analytics-readmore')]")
    private static WebElement niftyBankViewAll;
    @FindBy(xpath = "//h1[@class='cardheading']")
    private static WebElement niftyBankPageHeader;
    @FindBy(xpath = "//section[4]/h4")
    private static WebElement niftyBankTableHeader;
    @FindBy(xpath = "(//a[@class='listLink']//li)[21]")
    private static WebElement bseSensexTicker;
    @FindBy(xpath = "(//a[@class='listLink']//li)[24]")
    private static WebElement niftyFiftyTicker;
    @FindBy(xpath = "//section[2]//a[1]//li[1]")
    private static WebElement bse100Indice;


    @FindBy(xpath = "//a[contains(@class,'anchorhover2 clearfix')]")
    private static List<WebElement> niftyBankViewAllList;
    @FindBy(xpath = "//a[contains(@class,'anchorhover2 clearfix')]")
    private static List<WebElement> bseSensexAllStocksList;
    @FindBy(xpath = "//a[@class='anchorhover2']")
    private static List<WebElement> niftyBankStockList;
    @FindBy(xpath = "//section[2]//ol/li[1]")
    private static List<WebElement> indianIndiceList;
    @FindBy(xpath = "//nav[@id='leftNav']//li")
    private static List<WebElement> marketLeftNav1;
    @FindBy(xpath = "//span[@class='mobNavs']/a")
    private static List<WebElement> marketLeftNav2;
    @FindBy(xpath = "//li[contains(text(),'S&P BSE SENSEX')]")
    private static WebElement tickerBseSensex;
    @FindBy(xpath = "//li[contains(text(),'NIFTY 50')]")
    private static WebElement tickerNiftyFifty;

    @FindBy(xpath = "//li[contains(text(),'NIFTY BANK')]")
    private static WebElement tickerNiftyFiftybank;


    @FindBy(xpath = "(//section[2]//ol/li[1])[1]")
    private static WebElement indianIndiceName;
    @FindBy(xpath = "//section[4]//a[1]//li[1]")
    private static WebElement niftyBankStockName;
    @FindBy(xpath = "//section[2]//a[1]//li[1]")
    private static WebElement niftyBankStock;
    @FindBy(xpath = "//section[2]//a[1]//li[2]")
    private static WebElement niftyBankStockPChange;
    @FindBy(xpath = "//section[4]//a[1]//li[2]")
    private static WebElement niftyBankStockPrice;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[3]")
    private static WebElement niftyBankStockPriceChange;


    @FindBy(xpath = "(//h2[@class='cardheading fl'])[1]")
    private static WebElement gainersAndLosers;
    @FindBy(xpath = "(//section[@data-vars-cardtype='gainerslosers'])[1]")
    private static WebElement gainersAndLosersList;

    @FindBy(xpath = "//button[@id='gainerbseTab']")
    private static WebElement topGainers;
    @FindBy(xpath = "(//div[@id='bseGain'])[1]")
    private static WebElement topGainersList;
    @FindBy(xpath = "//div[@id='bse4']")
    private static WebElement topGainersListondasboard;

    @FindBy(xpath = "//section[@data-vars-cardtype='indices']//h1")
    private static WebElement headlineSPBseMidcap;

    @FindBy(xpath = "(//h1[@class='cardheading delay'])[1]")
    private static WebElement headlineNifty50;
    @FindBy(xpath = "//div[contains(@class,'indPrice down')]//span")
    private static WebElement bse100TimeStamp;

    @FindBy(xpath = "//div[@id='topgainersbse']//li[1]")
    private static List<WebElement> topGainerList;
    @FindBy(xpath = "//div[@id='topgainersbse']/div[@class='listmore']/a")
    private static WebElement topGainersViewAll;
    @FindBy(xpath = "//div[@id='BSEGainer']/div//a")
    private static List<WebElement> viewAllBseList;
    @FindBy(xpath = "(//div[@id='market-box-4']/div/button)[2]")
    private static WebElement topGainersNseCTA;
    @FindBy(xpath = "(//div[@id='market-box-4']/div/button)[1]")
    private static WebElement topGainersBseCTA;
    @FindBy(xpath = "(//div[@id='bseGain']//li[1])[1]")
    private static WebElement topGainersBseCompany;
    @FindBy(xpath = "//div[@id='nse4']/div")
    private static WebElement topGainersNseList;
    @FindBy(xpath = "//div[@id='bse4']/div")
    private static WebElement topGainersBseList;

    @FindBy(xpath = "//div[@id='NSEGainer']/div//a")
    private static List<WebElement> viewAllNseList;

    @FindBy(xpath = "(//section[2]//div[1]/div/a[2])[1]")
    private static WebElement viewAllNse;

    @FindBy(xpath = "//div[@id='bse3']")
    //////section[2]/div/a
    private static WebElement indianIndicesViewAll;

    @FindBy(xpath = "//div[@id='bse3']/div")
     private static WebElement indianIndicesViewAllclick;
    //////section[2]/div/a
    @FindBy(xpath = "//div[@id='bse3']")
    private static WebElement indianIndicesViewAllSensex;

    @FindBy(xpath = "//a[@class='btnViewAll']")
    private static WebElement indianIndicesViewAllSensexCta;


    @FindBy(xpath = "//section[@class='cardHolder editorPick page-view-candidate indices'][1]")
    private static WebElement indianIndicesViewAllSensexMidcap;
    @FindBy(xpath = "//a[@class='btnViewAll']")
    private static WebElement indianIndicesViewAllMidcap;

    //a[@class='btnViewAll'])[1]
    @FindBy(xpath = "//h4[@class='cardheading']")
    private static WebElement bseSensexStockTableHeader;
    @FindBy(xpath = "//section[2]//h1")
    private static WebElement expandedIndianIndicesHeader;
    @FindBy(xpath = "//section[2]//div[2]")
    private static WebElement expandedIndianIndicesTable;
    @FindBy(xpath = "//section[4]//div[1]//a[7]")
    private static WebElement bseSensexStockTableViewAll;
    @FindBy(xpath = "//h1[@class='cardheading']")
    private static WebElement bseSensexViewAllPageHeader;
    @FindBy(xpath = "//a[1]//strong[1]")
    private static WebElement bseSensexViewAllCompany;
    @FindBy(xpath = "//a[1]//ol[1]/li[2]")
    private static WebElement bseSenVAllCompanyPricenChange;
    @FindBy(xpath = "(//section[2]//ol/li[2])[1]")
    private static WebElement indianIndicePChange;


    @FindBy(xpath = "//div[@id='bse4']//button[2]")
    private static WebElement topLosers;
    @FindBy(xpath = "//div[@id='nse4']/div")
    private static WebElement topLosersNseList;
    @FindBy(xpath = "//div[@id='bseLose']/div[2]")
    private static WebElement topLosersBseList;
    @FindBy(xpath = "(//section[2]//div[1]/div/a[1])[1]")
    private static WebElement viewAllBse;
    @FindBy(xpath = "//span[@class='subTitle fl']")
    private static WebElement topLosersHeader;
    @FindBy(xpath = "(//span[@class='subTitle fl'])[1]")
    private static WebElement topGainersHeader;
    @FindBy(xpath = "//div[@id='toploosersbse']/div[@class='listmore']/a")
    private static WebElement topLosersViewAll;
    @FindBy(xpath = "//div[@id='bse4']//button[2]")
    private static WebElement topLoserButton;
    @FindBy(xpath = "(//section/div[1]/div[1])[3]")
    private static WebElement sliderMF;
    @FindBy(xpath = "(//div[@aria-label='Next slide'])[1]")
    private static WebElement sliderMFSwipeRight;
    @FindBy(xpath = "(//div[@aria-label='Previous slide'])[1]")
    private static WebElement sliderMFSwipeLeft;
    @FindBy(xpath = "(//div[contains(@class,'active')])[2]")
    private static WebElement sliderMFCommodities;
    @FindBy(xpath = "(//body[@id='search']//a/h2)[1]")
    private static WebElement companyMF;
    @FindBy(xpath = "//body[@id='search']//a/h2")
    private static List<WebElement> companiesListMF;
    @FindBy(xpath = "//div[@class='fundsNavItem']")
    private static List<WebElement> companyMFNavData;
    @FindBy(xpath = "(//h2[@class='cardheading'])[2]")
    private static WebElement mostActiveByVol;

    @FindBy(xpath = "//div[@id='market-box-7']")
    private static WebElement mostActiveByVolondashboard;

    @FindBy(xpath = "//a[@id='bseVolTab']")
    private static WebElement mostActiveByVolBseCTA;
    @FindBy(xpath = "//div[@id='bseVol']//li[1]")
    private static List<WebElement> bseCompanyList;
    @FindBy(xpath = "//a[@id='nseVolTab']")
    private static WebElement mostActiveByVolNseCTA;
    @FindBy(xpath = "(//section[@data-vars-cardtype='marketsvols'])[1]")
    private static WebElement mostActiveByVolList;
    @FindBy(xpath = "(//a[@class='btnViewAll readmore'])[2]")
    private static WebElement mostActiveByVolViewAll;
    @FindBy(xpath = "//div[@id='nseVol']/ol/li[1]")
    private static WebElement mostActiveByVolSecurity;
    @FindBy(xpath = "//div[@id='nseVol']/ol/li[2]")
    private static WebElement mostActiveByVolumeVol;
    @FindBy(xpath = "//div[@id='nseVol']/ol/li[3]")
    private static WebElement mostActiveByVolChange;
    @FindBy(xpath = "//section[2]//div[1]/div/a[1]")
    private static WebElement mostActiveByVolBse;
    @FindBy(xpath = "(//div[@id='bseVol'])[1]")
    private static WebElement mostActiveByVolBseList;
    @FindBy(xpath = "(//div[@id='bseVol']//li[1])[1]")
    private static WebElement mostActiveByVolBseCompany;
    @FindBy(xpath = "//section[2]//div[1]/div/a[2]")
    private static WebElement mostActiveByVolNse;
    @FindBy(xpath = "(//div[@id='nseVol'])[1]")
    private static WebElement mostActiveByVolNseList;
    @FindBy(xpath = "//div[@id='nseVol']/a[1]/ol")
    private static WebElement mostActiveByVolNseCompany;
    @FindBy(xpath = "(//h2[@class='cardheading fl'])[3]")
    private static WebElement mostActiveByVolHeader;
    @FindBy(xpath = "(//div[@id='trendingRHSFeed'])[1]")
    private static WebElement rhsTrendingWidget;
    @FindBy(xpath = "(//div[@class='swiper-button-next next_swiper_stat'])[1]")
    private static WebElement marketTickerSwipe;
    @FindBy(xpath = "(//li[contains(text(),'S&P BSE MIDCAP')])[2]")
    private static WebElement marketTickerSnPBseMidcap;

    @FindBy(xpath = "//div[@id='I0001']/ol/li")
    private static WebElement marketTickerSnPBseMidcaphome;

    @FindBy(xpath = "(//ol[@class='slider delay'])[1]")
    private static WebElement marketTickerNifty50;
    @FindBy(xpath = "(//ol[@class='slider'])[2]")
    private static WebElement marketTickerSnPBseSensex;
    @FindBy(xpath = "(//h4[@class='cardheading'])[1]")
    private static WebElement BseSnPMidcap;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[1]")
    private static WebElement BseSnPMidcapCompany;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[2]")
    private static WebElement BseSnPMidcapCompanyPrice;
    @FindBy(xpath = "(//div[@class='tableBox'])[2]")
    private static WebElement BseSnPMidcapTable;
    @FindBy(xpath = "//section[4]//div[1]")
    private static WebElement nifty50Table;
    @FindBy(xpath = "(//a[@id='fixedNav_popular'])[1]")
    private static WebElement markets;
    @FindBy(xpath = "//div[contains(@class,'desktopAd adSpace')]")
    private static WebElement headAdMarkets;
    @FindBy(id = "sectionp_market")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "//a[@id='topic_Stock Markets']")
    private static WebElement stockMarkets;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement marketsFirstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement marketsFirstHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement marketsSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement marketsSecondStory;

    @FindBy(xpath = "(//div[@class='listingHolder news'])[1]")
    private static WebElement newsList;
    @FindBy(xpath = "(//div[@id='bseLose'])[1]")
    private static WebElement topLosersList;
    @FindBy(xpath = "//div[@id='toploosersbse']")
    private static WebElement topLosersListtoggle;

    @FindBy(xpath = "//div[@id='toploosersbse']//ol/li[1]")
    private static List<WebElement> topLosersNames;
    @FindBy(xpath = "//div[@id='NSEGainer']//a[1]")
    private static WebElement viewAllNseCompany;
    @FindBy(xpath = "//div[@id='NSEGainer']//a[1]//li[2]")
    private static WebElement viewAllNseCompanySPrice;
    @FindBy(xpath = "//div[@id='NSEGainer']//a[1]//li[2]/span")
    private static WebElement viewAllNseCompanySPriceChange;


    @FindBy(xpath = "//div[@id='bse3']/a[1]")
    private static WebElement bse100Header;
////h1[@class='cardheading delay']
    @FindBy(xpath = "(//h1[@class='listheading'])[1]")
    private static WebElement marketPageHeader;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement marketPageHeaderStatistics;

    @FindBy(xpath = "//section[@id='marketStats']")
    private static WebElement marketTicker;

    @FindBy(xpath = "(//div[@id='graphHolder'])[1]")
    private static WebElement graph;
    @FindBy(xpath = "(//a[@class='listLink']//li)[9]")
    private static WebElement bse500Indice;
    @FindBy(xpath = "//a[@class='btnViewAll analytics-readmore']")
    private static WebElement bse500TableViewAll;

    @FindBy(xpath = "(//div[@id='graphHolder'])")
    private static WebElement graphBse100;

    @FindBy(xpath = "//button[@id='1d']")
    private static WebElement button1D;

    @FindBy(xpath = "//button[@id='5d']")
    private static WebElement button5D;

    @FindBy(xpath = "//button[@id='1m']")
    private static WebElement button1M;

    @FindBy(xpath = "//button[@id='1y']")
    private static WebElement button1Y;

    @FindBy(xpath = "//button[@id='5y']")
    private static WebElement button5Y;
    @FindBy(xpath = "//div[@title='Search']")
    private static WebElement search;


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

    @FindBy(id = "amazon-ai-player-container")
    //div[@id='amazon-ai-player-label']/following-sibling::div/audio[@id='amazon-ai-player']
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

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads_iframe')])[1]")
    private static WebElement mastHeadAdiFrame;
    @FindBy (xpath = "//div[@class='swiper-button-next next_swiper_stat']")
    private static  WebElement tickerScroller;
    @FindBy (xpath = "(//div[@id='topgainersbse']//li[3])[2]")
    private static  WebElement gainerListChangevalue;

    @FindBy (xpath = "//div[@id='market-box-4a']/div[1]/button[2]")
    private static WebElement toploserstoggle;

    @FindBy(xpath = "//div[@id='bse7']")
    private static WebElement activeStockViewAll;
    @FindBy(xpath = "//div[@id='bse7']/div")
    private static WebElement activeStockViewAllCta;
    @FindBy(xpath = "//div[@id='market-box-7']/div[1]/button[2]")
    private static WebElement activeStockNseCTA;
    @FindBy(xpath = "(//div[@id='nse7'])[1]")
    private static WebElement activeStockNseList;
    @FindBy(xpath = "(//div[@id='bse7'])[1]")
    private static WebElement activeStockBseList;
    @FindBy(xpath = "(//h2[@class='cardheading fl'])[3]")
    private static WebElement mostActiveByVolHeadercolor;
    @FindBy(xpath = "//div[@id='market-box-7']/div[1]/button[1]")
    private static WebElement activeStockBseCTA;







    public Market() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        apiValidation = ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkIndianIndicesPage(String Url) {
        commonFunctions.navigateToURl(Url);
        commonFunctions.waitForURLContains("market");
        commonFunctions.scrollToElement(marketDashboard, "Market Dasboard");
        commonFunctions.clickElementIfDisplayed(marketDashboard, 10, "Market Dashbaord");
        commonFunctions.isElementDisplayed(indianIndices, 10, "Indian Indices List");
        commonFunctions.scrollDownOnce();
        commonFunctions.isElementDisplayed(bse100, 10, "BSE 100");
        String Indice = commonFunctions.getElementText(bse100);
        commonFunctions.dummyWait(20);
        commonFunctions.clickElementIfDisplayed(bse100, 10, "S&P BSE 100");
        commonFunctions.isElementDisplayed(bse100Header, 10, "S&P BSE100 Detail Page");
        boolean isShowing = commonFunctions.checkElementText(bse100Header, Indice, 10, "Indice Header");
        return isShowing;
    }

    @Override
    public boolean checkMarketDashboardPage(String Url) {
       commonFunctions.navigateToURl(Url);
       //commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing = commonFunctions.isElementDisplayed(mintLogo, 10, "Mint Logo on Homepage");
       /* commonFunctions.scrollToElement(marketDashboard, "Market Dashbaord");
        commonFunctions.clickElement(marketDashboard, 10, "Market Dashbaord");*/
        isShowing &= commonFunctions.isElementDisplayed(marketPageHeaderStatistics, 10, "Market Page Header");
        commonFunctions.dummyWait(10);
        commonFunctions.scrollToElementView(headerIndianIndicesdashboard,10,"Indices view port");
         isShowing &= commonFunctions.isElementDisplayed(indianIndicesListStatics, 10, "Indian Indices List");
        commonFunctions.scrollToElementView(topGainers, 10, "Top Gainers");
        isShowing &= commonFunctions.isElementDisplayed(topGainersListondasboard, 10, "Top Gainers List");
        commonFunctions.scrollToElementView(topLosers, 10, "Top Losers");
        commonFunctions.clickElementWithJS(toploserstoggle,10,"Click on TopLosers toggle");
        isShowing &= commonFunctions.isElementDisplayed(topLosersListtoggle, 10, "Top Losers List");
        commonFunctions.scrollToElement(mostActiveByVolondashboard,  "Most Active By Volume");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolondashboard, 10, "Most Active by Volume List");
        isShowing &= commonFunctions.isElementDisplayed(rhsTrendingWidget, 10, "RHS Trending Widget");
        return isShowing;
    }

    @Override
    public boolean checkMarketSnPBseMidcapLandingPage( ) {
        commonFunctions.clickElementWithJS(marketTickerSnPBseMidcaphome, 10, "S&P BSE Midcap Ticker");
        commonFunctions.scrollDownOnce();
        boolean isShowing = commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        isShowing &= commonFunctions.isElementDisplayed(headlineSPBseMidcap, 10, "S&P BSE Midcap Headline");
        isShowing &= commonFunctions.scrollToElementView(indianIndicesmidcap, 10, "Indian Indices Table");
        isShowing &= commonFunctions.scrollToElementView(BseSnPMidcapTable, 10, "S&P BSE Midcap Stocks Table");
        isShowing &= commonFunctions.scrollToElementView(newsList, 10, "Market Stocks News List");
        return isShowing;
    }

    @Override
    public boolean checkMarketNifty50LandingPage(String Url, String Header) {
        commonFunctions.clickElementIfDisplayed(marketTickerNifty50, 10, "Nifty 50 Ticker");
        boolean isShowing = commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        isShowing &= commonFunctions.isElementDisplayed(headlineNifty50, 10, "Nifty 50 Headline");
        isShowing &= commonFunctions.scrollToElementView(indianIndices, 10, "Indian Indices Table");
        isShowing &= commonFunctions.scrollToElementView(nifty50Table, 10, "Nifty 50 Stocks Table");
        isShowing &= commonFunctions.scrollToElementView(newsList, 10, "Market Stocks News List");
        return isShowing;
    }

    @Override
    public boolean checkMarketNifty50Graph(String[] params) {
        String HighlitedColor = params[0];
//        commonFunctions.scrollToElement(marketDashboard, "Market Dashbaord");
//        commonFunctions.clickElementIfDisplayed(marketDashboard, 10, "Market Dashbaord");
        commonFunctions.clickElementIfDisplayed(marketTickerNifty50, 10, "Nifty 50 Ticker");
        commonFunctions.isElementDisplayed(headlineNifty50, 10, "Nifty 50 Headline");
        boolean isShowing = commonFunctions.scrollToElementView(graph, 10, "Nifty 50 graph");
        commonFunctions.isElementDisplayed(graph, 10, "1D Graph");
        String Button1D = button1D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1D, "1D Button Highlighted");
        commonFunctions.clickElementWithJS(button5D, 10, "Button 5D");
        commonFunctions.isElementDisplayed(graph, 10, "5D Graph");
        String Button5D = button5D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5D, "5D Button Highlighted");
        commonFunctions.clickElementWithJS(button1M, 10, "Button 1M");
        commonFunctions.isElementDisplayed(graph, 10, "1M Graph");
        String Button1M = button1M.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1M, "1M Button Highlighted");
        commonFunctions.clickElementWithJS(button1Y, 10, "Button 1Y");
        commonFunctions.isElementDisplayed(graph, 10, "1Y Graph");
        String Button1Y = button1Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1Y, "1Y Button Highlighted");
        commonFunctions.clickElementWithJS(button5Y, 10, "Button 5Y");
        commonFunctions.isElementDisplayed(graph, 10, "5Y Graph");
        String Button5Y = button5Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5Y, "5Y Button Highlighted");
        return isShowing;
    }

    @Override
    public boolean checkSnPBseSensexGraph(String[] params) {
        String HighlitedColor = params[0];
//        commonFunctions.scrollToElement(marketDashboard, "Market Dashbaord");
//        commonFunctions.clickElementIfDisplayed(marketDashboard, 10, "Market Dashbaord");
        commonFunctions.clickElementIfDisplayed(marketTickerSnPBseSensex, 10, "S&P BSE Sensex Ticker");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean isShowing = commonFunctions.scrollToElementView(graph, 10, "S&P BSE Sensex graph");
        commonFunctions.isElementDisplayed(graph, 10, "1D Graph");
        String Button1D = button1D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1D, "1D Button Highlighted");
        commonFunctions.clickElementWithJS(button5D, 10, "Button 5D");
        commonFunctions.isElementDisplayed(graph, 10, "5D Graph");
        String Button5D = button5D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5D, "5D Button Highlighted");
        commonFunctions.clickElementWithJS(button1M, 10, "Button 1M");
        commonFunctions.isElementDisplayed(graph, 10, "1M Graph");
        String Button1M = button1M.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1M, "1M Button Highlighted");
        commonFunctions.clickElementWithJS(button1Y, 10, "Button 1Y");
        commonFunctions.isElementDisplayed(graph, 10, "1Y Graph");
        String Button1Y = button1Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1Y, "1Y Button Highlighted");
        commonFunctions.clickElementWithJS(button5Y, 10, "Button 5Y");
        commonFunctions.isElementDisplayed(graph, 10, "5Y Graph");
        String Button5Y = button5Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5Y, "5Y Button Highlighted");
        return isShowing;
    }

    @Override
    public boolean checkNiftyBankGraph(String[] params) {
        String HighlitedColor = params[0];
//        commonFunctions.scrollToElement(marketDashboard, "Market Dashbaord");
//        commonFunctions.clickElementIfDisplayed(marketDashboard, 10, "Market Dashbaord");
        commonFunctions.clickElementIfDisplayed(marketNiftyBank, 10, "Nifty Bank Ticker");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean isShowing = commonFunctions.scrollToElementView(graph, 10, "Nifty Bank graph");
        commonFunctions.isElementDisplayed(graph, 10, "1D Graph");
        String Button1D = button1D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1D, "1D Button Highlighted");
        commonFunctions.clickElementWithJS(button5D, 10, "Button 5D");
        commonFunctions.isElementDisplayed(graph, 10, "5D Graph");
        String Button5D = button5D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5D, "5D Button Highlighted");
        commonFunctions.clickElementWithJS(button1M, 10, "Button 1M");
        commonFunctions.isElementDisplayed(graph, 10, "1M Graph");
        String Button1M = button1M.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1M, "1M Button Highlighted");
        commonFunctions.clickElementWithJS(button1Y, 10, "Button 1Y");
        commonFunctions.isElementDisplayed(graph, 10, "1Y Graph");
        String Button1Y = button1Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1Y, "1Y Button Highlighted");
        commonFunctions.clickElementWithJS(button5Y, 10, "Button 5Y");
        commonFunctions.isElementDisplayed(graph, 10, "5Y Graph");
        String Button5Y = button5Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5Y, "5Y Button Highlighted");
        return isShowing;
    }

    @Override
    public boolean checkSnPBseMidcapGraph(String[] params) {
        String HighlitedColor = params[0];
        commonFunctions.refreshPage();
        commonFunctions.clickElement(tickerScroller,10,"ticker scroller");
        commonFunctions.dummyWait(1);
        commonFunctions.clickElement(tickerScroller,10,"ticker scroller");
        commonFunctions.isElementDisplayed(marketTickerSnPBseMidcap, 10, "S&P BSE Midcap Ticker");

        commonFunctions.clickElement(marketTickerSnPBseMidcap, 10, "S&P BSE Midcap Ticker");
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean isShowing = commonFunctions.scrollToElementView(graph, 10, "S&P BSE Midcap graph");
        commonFunctions.isElementDisplayed(graph, 10, "1D Graph");
        String Button1D = button1D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1D, "1D Button Highlighted");
        commonFunctions.clickElementWithJS(button5D, 10, "Button 5D");
        commonFunctions.isElementDisplayed(graph, 10, "5D Graph");
        String Button5D = button5D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5D, "5D Button Highlighted");
        commonFunctions.clickElementWithJS(button1M, 10, "Button 1M");
        commonFunctions.isElementDisplayed(graph, 10, "1M Graph");
        String Button1M = button1M.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1M, "1M Button Highlighted");
        commonFunctions.clickElementWithJS(button1Y, 10, "Button 1Y");
        commonFunctions.isElementDisplayed(graph, 10, "1Y Graph");
        String Button1Y = button1Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button1Y, "1Y Button Highlighted");
        commonFunctions.clickElementWithJS(button5Y, 10, "Button 5Y");
        commonFunctions.isElementDisplayed(graph, 10, "5Y Graph");
        String Button5Y = button5Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(HighlitedColor, Button5Y, "5Y Button Highlighted");
        return isShowing;
    }


    @Override
    public boolean checkMostActiveVolViewAll() {

        commonFunctions.scrollToElement(marketDashboard, "Market Dashbaord");
        commonFunctions.clickElementIfDisplayed(marketDashboard, 10, "Market Dashbaord");
        commonFunctions.scrollToElementView(mostActiveByVol, 10, "Most Active By Volume Widget");
        boolean isShowing = commonFunctions.scrollToElementView(activeStockViewAll, 10, "Most Active By Volume View All");
        commonFunctions.clickElementWithJS(activeStockViewAllCta, 10, "Most Active By Volume View All");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolHeader, 10, "Most Active By Volume Page Header");
        commonFunctions.scrollToElementView(mostActiveByVolBse, 10, "Most Active By Volume BSE");
        isShowing &= commonFunctions.isElementDisplayed(activeStockBseList, 10, "Most Active By Volume BSE Companies List");
        commonFunctions.scrollToElementView(activeStockNseCTA, 10, "Most Active By Volume NSE");
        commonFunctions.clickElementWithJS(activeStockNseCTA, 10, "Most Active By Volume NSE");
        isShowing &= commonFunctions.isElementDisplayed(activeStockNseList, 10, "Most Active By Volume NSE Companies List");
      /*  isShowing &= commonFunctions.isElementClickable(mostActiveByVolNseCompany, 10, "Company Name");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolSecurity, 10, "Most Active By Volume Security");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeVol, 10, "Most Active By Volume Category");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolChange, 10, "Most Active By Volume Change");*/
        return isShowing;
    }

    @Override
    public boolean checkTopGainersViewAll(String[] params) {
        String Link = params[0];
        commonFunctions.navigateToURl(Link);
        commonFunctions.scrollToElementView(topGainersViewAll, 10, "Top Gainers");
        commonFunctions.clickElementWithJS(topGainersViewAll, 10, "Top Gainers View All");
        commonFunctions.isElementDisplayed(topGainersHeader, 10, "Top Gainers Header");
        commonFunctions.isElementDisplayed(viewAllBse, 10, "Top Gainers BSE");
        boolean isShowing = commonFunctions.isElementDisplayed(viewAllBseList, 10, "Top Gainers BSE List");
        commonFunctions.clickElementWithJS(viewAllNse, 10, "Top Gainers NSE");
        isShowing &= commonFunctions.isElementDisplayed(viewAllNseList, 10, "Top Gainers NSE List");
        isShowing &= commonFunctions.isElementClickable(viewAllNseCompany, 10, "Top Gainers NSE Company");
        isShowing &= commonFunctions.isElementDisplayed(viewAllNseCompanySPrice, 10, "Top Gainers NSE Company Share Price");
        isShowing &= commonFunctions.isElementDisplayed(viewAllNseCompanySPriceChange, 10, "Top Gainers NSE Company Share Price Change");
        return isShowing;
    }

    @Override
    public boolean checkTopLosersViewAll(String[] params) {
        String Link = params[0];
        commonFunctions.navigateToURl(Link);
        commonFunctions.scrollToElementView(topGainersViewAll, 10, "Top Gainers");
        //commonFunctions.scrollToElementView(topLosersViewAll, 10, "Top Losers");
        commonFunctions.clickElementWithJS(topLoserButton, 10, "Top Losers header");
        commonFunctions.clickElementWithJS(topLosersViewAll,10,"Top loser view all");
        commonFunctions.isElementDisplayed(topLosersHeader, 10, "Top Losers Header");
        commonFunctions.isElementDisplayed(viewAllBse, 10, "Top Loser BSE");
        boolean isShowing = commonFunctions.isElementDisplayed(viewAllBseList, 10, "Top Loser BSE List");
        commonFunctions.clickElementWithJS(viewAllNse, 10, "Top Loser NSE");
        isShowing &= commonFunctions.isElementDisplayed(viewAllNseList, 10, "Top Loser NSE List");
        isShowing &= commonFunctions.isElementClickable(viewAllNseCompany, 10, "Top Loser NSE Company");
        isShowing &= commonFunctions.isElementDisplayed(viewAllNseCompanySPrice, 10, "Top Loser NSE Company Share Price");
        isShowing &= commonFunctions.isElementDisplayed(viewAllNseCompanySPriceChange, 10, "Top Loser NSE Company Share Price Change");
        return isShowing;
    }

    @Override
    public boolean checkMFDetailPage(String[] params) {
        String Link = params[0];
        commonFunctions.navigateToURl(Link);
        boolean isShowing = commonFunctions.isElementDisplayed(sliderMF, 10, "Slider MF");
        isShowing &= commonFunctions.clickElementWithJS(sliderMFSwipeRight, 10, "Slider MF Swipe Right");
        commonFunctions.clickElementWithJS(sliderMFSwipeLeft, 10, "Slider MF Swipe Left");
        isShowing &= commonFunctions.clickElementWithJS(sliderMFCommodities, 10, "Slider MF Commodities");
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(companiesListMF, "MF Companies List");
        isShowing &= commonFunctions.isElementClickable(companyMF, 10, "MF Company Name");
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(companyMFNavData, "MF Companies List");
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesGraph(String Link, String Color) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.scrollToElementView(bse100, 10, "S&P BSE100");
        commonFunctions.clickElementWithJS(bse100, 10, "S&P BSE100");
        boolean isShowing = commonFunctions.scrollToElementView(graphBse100, 10, "S&P BSE100 graph");
        commonFunctions.scrollUp();
        commonFunctions.isElementDisplayed(graph, 10, "1D Graph");
        String Button1D = button1D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1D, "1D Button Highlighted");
        commonFunctions.clickElementWithJS(button5D, 10, "Button 5D");
        commonFunctions.isElementDisplayed(graph, 10, "5D Graph");
        String Button5D = button5D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button5D, "5D Button Highlighted");
        commonFunctions.clickElementWithJS(button1M, 10, "Button 1M");
        commonFunctions.isElementDisplayed(graph, 10, "1M Graph");
        String Button1M = button1M.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1M, "1M Button Highlighted");
        commonFunctions.clickElementWithJS(button1Y, 10, "Button 1Y");
        commonFunctions.isElementDisplayed(graph, 10, "1Y Graph");
        String Button1Y = button1Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1Y, "1Y Button Highlighted");
        commonFunctions.clickElementWithJS(button5Y, 10, "Button 5Y");
        commonFunctions.isElementDisplayed(graph, 10, "5Y Graph");
        String Button5Y = button5Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button5Y, "5Y Button Highlighted");
        return isShowing;
    }

    @Override
    public boolean checkBseTop4GainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkNseTop4GainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAll() {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAll() {
        return false;
    }

    @Override
    public boolean checkMostActByVolViewAll() {
        return false;
    }

    @Override
    public boolean checkSnPBseMidcapStockTable(String Link, String Header, String URI, String ID, String Stocks) {
        boolean isShowing;
        commonFunctions.navigateToURl(Link);
        isShowing = commonFunctions.clickElementWithJS(marketTickerSwipe, 10, "Market Ticker Swipe Right");
        String Midcap = commonFunctions.getElementText(marketTickerSnPBseMidcap);
        commonFunctions.clickElementWithJS(marketTickerSnPBseMidcap, 10, "S&P BSE Midcap Ticker");
        commonFunctions.scrollToElementView(BseSnPMidcap, 10, "S&P BSE Midcap Stock Table Header");
        commonFunctions.checkTextContains(Midcap, Header, "S&P BSE Midcap Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String dName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        isShowing &= commonFunctions.checkElementText(BseSnPMidcapCompany, dName, 10, "company name");
        String priceValue = JsonPath.parse(response.getBody().asString()).read("$.[0].price").toString().trim();
        if (BseSnPMidcapCompanyPrice.getText().trim().replace(",", "").equals(priceValue)) {
            Utils.logStepInfo(true, "Company price verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Company price not verified !!!!");
        }
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeMarketDashbaord(String Link, String Color, String URI, String Companies) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(marketDashboard, 10, "Market Dashbaord");
        commonFunctions.scrollToElementView(mostActiveByVolHeadercolor,  10,"Most Active By Volume Widget");
        String HeadlineColor = mostActiveByVolHeadercolor.getCssValue("color");
        boolean isShowing = commonFunctions.checkTextEquals(Color, HeadlineColor, "Most Active By volume Headline Colour");
        commonFunctions.clickElementWithJS(activeStockNseCTA, 10, "Most Active By Volume NSE");
        isShowing &= commonFunctions.isElementDisplayed(activeStockNseList, 10, "Most Active By Volume NSE Companies List");

        commonFunctions.clickElementWithJS(activeStockBseCTA, 10, "Most Active By Volume BSE");
        isShowing &= commonFunctions.isElementDisplayed(activeStockBseList, 10, "Most Active By Volume BSE Companies List");
       /* int CompanyList = bseCompanyList.size();
        if (String.valueOf(CompanyList).trim().equals(Companies)) {
            Utils.logStepInfo(true, "Most Active Vol No. Of Companies verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Most Active Vol No. Of Companies not verified !!!!");
        }*/
        commonFunctions.scrollToElement(activeStockViewAllCta, "Most Active BY Volume View ALl");
        commonFunctions.isElementDisplayed(activeStockViewAllCta, 10, "Most Active BY Volume View ALl");
        return isShowing;
    }

    @Override
    public boolean checkTopGainerMarketDashbaord(String Link, String Color, String URI, String Gainers) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(marketDashboard, 10, "Market Dashbaord");
        commonFunctions.scrollToElementView(topGainers, 10, "Gainers & Losers Widget");
        commonFunctions.isElementDisplayed(topGainersViewAll, 10, "Top Gainers view All");
        String HeadlineColor = gainerListChangevalue.getCssValue("color");
        boolean isShowing = commonFunctions.checkTextEquals(Color, HeadlineColor, "Top Gainers Headline Font Green Colour Verified");
        commonFunctions.clickElementWithJS(topGainersNseCTA, 10, "Top Gainers NSE");
        isShowing &= commonFunctions.isElementDisplayed(topGainersNseList, 10, "Top Gainers NSE Companies List");
        commonFunctions.clickElementWithJS(topGainersBseCTA, 10, "Top Gainers BSE");
        isShowing &= commonFunctions.isElementDisplayed(topGainersBseList, 10, "Top Gainers BSE Companies List");
        int CompanyList = topGainerList.size();
        if (String.valueOf(CompanyList).trim().equals(Gainers)) {
            Utils.logStepInfo(true, "Top Gainers No. Of Companies verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Top Gainers No. Of Companies verification Failed!!!!");
        }
        return isShowing;
    }

    @Override
    public boolean checkTopLoserMarketDashbaord(String Link, String Color, String URI, String Losers) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.scrollToElementView(topGainersViewAll, 10, "Top Gainers");
        commonFunctions.clickElementWithJS(topLoserButton, 10, "Top Losers View All");
        commonFunctions.isElementDisplayed(topLosersViewAll, 10, "Top Losers view All");
        String HeadlineColor = topLosers.getCssValue("color");
        boolean isShowing = commonFunctions.checkTextEquals(Color, HeadlineColor, "Top Losers Headline Font Red Colour Verified");
        commonFunctions.clickElementWithJS(topGainersNseCTA, 10, "Top Losers NSE");
        isShowing &= commonFunctions.isElementDisplayed(topLosersNseList, 10, "Top Losers NSE Companies List");
        commonFunctions.clickElementWithJS(topGainersBseCTA, 10, "Top Losers BSE");
        isShowing &= commonFunctions.scrollToElementView(topGainersBseList, 10, "Top Losers BSE Companies List");
        int LosersList = topLosersNames.size();
        if (String.valueOf(LosersList).trim().equals(Losers)) {
            Utils.logStepInfo(true, "Top Losers No. Of Companies verified successfully!!!");
        } else {
            System.out.println(String.valueOf(LosersList).trim()+ " " + Losers);
            Utils.logStepInfo(false, "Top Losers No. Of Companies verification Failed!!!!");
        }
        return isShowing;
    }

    @Override
    public boolean checkStockTableNiftyBank(String Link, String Header, String URI, String ID, String Stocks) {
        boolean isShowing = commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(niftyBankTableHeader, 10, "Nifty Bank Stock Table Header");
        if (niftyBankTableHeader.getText().trim().equalsIgnoreCase(Header)) {
            Utils.logStepInfo(true, "Nifty Bank Table Header verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Nifty Bank Table Header verification Failed!!!");
        }
        ;
        int StocksList = niftyBankStockList.size();
        if (String.valueOf(StocksList).trim().equals(Stocks)) {
            Utils.logStepInfo(true, "Nifty Bank Stock list verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Nifty Bank Stock list verification Failed!!!");
        }
//        Response response = apiValidation.getResponseFromURI(URI, ID);
//        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
//        String CompanyName = niftyBankStockName.getText();
//        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        String CompanyPrice = niftyBankStockPrice.getText();
//        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Price).trim(), CompanyPrice, "Company Price");
//        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
//        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
//        String PercentChange = String.valueOf(Pchange).trim() + " (" + String.valueOf(Percent).trim() + "%)";
//        String Changepercent = commonFunctions.getElementText(niftyBankStockPriceChange);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        return isShowing;
    }


    @Override
    public boolean checkStockTableBseSensex(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURl(Link);
        boolean isShowing = commonFunctions.clickElementWithJS(bseSensexTicker, 10, "S&P Bse Sensex Ticker");
        commonFunctions.scrollToElementView(bseSensexStockTableHeader, 10, "S&P Bse Sensex Stock Table Header");
        if (bseSensexStockTableHeader.getText().trim().equals(Header)) {
            Utils.logStepInfo(true, "S&P Bse Sensex Stock Table Header verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "S&P Bse Sensex Stock Table Header verification Failed!!!");
        }
        ;
        int StocksList = niftyBankStockList.size();
        if (String.valueOf(StocksList).trim().equals(Stocks)) {
            Utils.logStepInfo(true, "S&P Bse Sensex Stock Table list verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "S&P Bse Sensex Stock Table list verification Failed!!!");
        }
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStockName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = niftyBankStockPrice.getText();
        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), (String.valueOf(Price).replace(".", "").trim()), "Company Price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PercentChange = String.valueOf(Pchange).trim() + " (" + String.valueOf(Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(niftyBankStockPriceChange);
        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        for (int i = 0; i < StocksList; i++) {
            isShowing &= commonFunctions.isElementClickable(niftyBankStockList.get(i), 10, "Bse Sensex Stock List");
        }
        return isShowing;
    }


    @Override
    public boolean checkStockTableBseSensexViewAll(String Link, String Header, String URI, String ID) {
        commonFunctions.navigateToURl(Link);
        boolean isShowing = commonFunctions.clickElementWithJS(bseSensexTicker, 10, "S&P Bse Sensex Ticker");
        commonFunctions.scrollToElementView(bseSensexStockTableViewAll, 10, "S&P Bse Sensex Stock Table View All");
        commonFunctions.clickElementWithJS(bseSensexStockTableViewAll, 10, "S&P Bse Sensex Stock Table View All");
        isShowing &= commonFunctions.isElementDisplayed(bseSensexViewAllPageHeader, 10, "Sensex Page Header");
        commonFunctions.checkElementText(bseSensexViewAllPageHeader, Header, 10, "Sensex Page Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = bseSensexViewAllCompany.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
//        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
//        String PriceChange = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
//        String PriceChange1 = bseSenVAllCompanyPricenChange.getText().replace(" ", "");
//        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StocksList = bseSensexAllStocksList.size();
        System.out.println("Total Number BSE Sensex stocks in table are =" + StocksList);
        return isShowing;
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
        commonFunctions.navigateToURl(Link);
        commonFunctions.scrollToElementView(indianIndices, 10, "Indian Indices Table Header");
        boolean isShowing = commonFunctions.checkElementText(indianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndiceName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChange = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
        String PriceChange1 = indianIndicePChange.getText().replace(" ", "");
        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");

        int StocksList = indianIndiceList.size();
        if (String.valueOf(StocksList).trim().equals(Stocks)) {
            Utils.logStepInfo(true, "Indian Indice list verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Indian Indice list verification Failed!!!");
        }
        for (int i = 0; i < StocksList; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndiceList.get(i), 10, "Bse Sensex Stock List");
        }
        commonFunctions.isElementClickable(indianIndicesViewAll, 10, "Indian Indice View All");
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAll(String Link, String Header, String URI, String ID, String URL) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.scrollToElementView(indianIndicesViewAll, 10, "Indian Indices View All");
        commonFunctions.dummyWait(5);
        boolean isShowing = commonFunctions.clickElement(indianIndicesViewAllclick, 10, "Indian Indices View All");
        commonFunctions.waitForURLToBe("https://www.livemint.com/market/market-stats/india-market-indices");
        if ((commonFunctions.getCurrentURL().equalsIgnoreCase(URL))) {
            Utils.logStepInfo(true, "Indian Indices View ALl Functionality verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Indian Indices View ALl Functionality verification Failed!!!");
        }
        isShowing &= commonFunctions.checkElementText(expandedIndianIndicesHeader, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndiceName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChang = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + String.valueOf(Percent).trim();
        String PriceChange = PriceChang.replaceAll("[^a-zA-Z0-9]", "");
        String PriceChange1 = indianIndicePChange.getText().replaceAll("[^a-zA-Z0-9]", "");
        String firstthreechr;
        String firstthreechre1;
        if(PriceChang.length()>3)
        {
            firstthreechr=PriceChange.substring(0,3);
        }
        else
        {
            firstthreechr=PriceChang;
        }

        if(PriceChange1.length()>3)
        {
            firstthreechre1=PriceChange1.substring(0,3);
        }
        else
        {
            firstthreechre1=PriceChange1;
        }
        isShowing &= commonFunctions.checkTextEquals(firstthreechre1,String.valueOf(firstthreechr),"Price First Three chr");
        int StocksList = indianIndiceList.size();
        System.out.println("Indian Indices diplayed are " + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkNiftyBankStocksViewAll(String Link, String Link1, String Header, String URI, String ID, String URL, String Stocks) {
        commonFunctions.navigateToURl(globalVars.getURL()+Link1);
        commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(niftyBankViewAll, 10, "Nifty Bank Stocks View All");
        boolean isShowing = commonFunctions.clickElementWithJS(niftyBankViewAll, 10, "Nifty Bank Stocks View All");
        if ((commonFunctions.getCurrentURL().equals(URL))) {
            Utils.logStepInfo(true, "Nifty Bank Stocks View All Functionality verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Nifty Bank Stocks View All Functionality verification Failed!!!");
        }
        isShowing &= commonFunctions.checkElementText(niftyBankPageHeader, Header, 10, "Nifty Bank Stocks Page Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStock.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PriceChange = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
        String PriceChange1 = indianIndicePChange.getText().replace(" ", "");
        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StocksList = indianIndiceList.size();
        commonFunctions.checkTextEquals(Stocks, String.valueOf(StocksList), "Stocks in List are 12");
        return isShowing;
    }


    @Override
    public boolean checkStockNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        boolean isShowing = commonFunctions.clickElementWithJS(tickerNiftyFifty, 10, "Nifty 50 Ticker");
        commonFunctions.scrollToElementView(bseSensexStockTableHeader, 10, "Nifty 50 Stocks Table Header");
        commonFunctions.checkElementText(bseSensexStockTableHeader, Header, 20, "Nifty 50 Stocks Table Header");
        int StocksList = niftyBankStockList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(StocksList), Stocks, "Total No of Stocks Displayed");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStockName.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        String CompanyPrice = niftyBankStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), (String.valueOf(Price).replace(".", "").trim()), "Company Price");
//        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
//        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
//        String PercentChange = String.valueOf(Pchange).trim() + " (" + String.valueOf(Percent).trim() + "%)";
//        String Changepercent = commonFunctions.getElementText(niftyBankStockPriceChange);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        for (int i = 0; i < StocksList; i++) {
            isShowing &= commonFunctions.isElementClickable(niftyBankStockList.get(i), 10, "Nifty 50 Stock List");
        }
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesOnBseSensex(String Link, String Header, String URI, String ID, String URL) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(bseSensexTicker, 10, "BSE Sensex Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
//        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
//        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
//        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
//        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        System.out.println("Total no of indices in list are " + String.valueOf(+Indices));
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndList.get(i), 10, "Indian Indices On Bse Sensex Stock List");
        }
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensexCta, 10, "Indian Indices View All");
        isShowing &= commonFunctions.checkPageURL(URL, 20, "Indian Indices View all redirection");
        return isShowing;
    }


    @Override
    public boolean checkIndianIndicesOnNiftyBank(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURl(Link);
       // commonFunctions.scrollToElementView(niftyBankTicker,5,"Scroll to NIFTY");
        commonFunctions.clickElementWithJS(tickerNiftyFiftybank, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(headerIndianIndicesdashboardniftbank, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndicesdashboardniftbank, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
//        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
//        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
//        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
//        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndList.get(i), 10, "Indian Indices On Bse Sensex Stock List");
        }
        return isShowing;
    }


    @Override
    public boolean checkIndianIndicesOnBseMidcap(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(bseMidcapTicker, 10, "Bse Midcap Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
//        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
//        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
//        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
//        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndList.get(i), 10, "Indian Indices Stock List");
        }
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesOnNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(niftyFiftyTicker, 10, "Nifty Fifty Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
//        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
//        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
//        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
//        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndList.get(i), 10, "Indian Indices Stock List");
        }
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllBseMidcap(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(bseMidcapTicker, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(indianIndicesViewAllSensexMidcap, 20, "Indices View All");
        commonFunctions.clickElementWithJS(indianIndicesViewAllMidcap, 20, "Indices View All");
        boolean isShowing = commonFunctions.isElementDisplayed(expandedIndianIndicesHeader, 10, "Indian Indices page Header");
        isShowing &= commonFunctions.checkElementText(expandedIndianIndicesHeader, Header, 20, "Indices Header Verified");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = niftyBankStock.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChang = Price.trim() + Pchange.trim()+ Percent.trim();
        String PriceChange =PriceChang.replaceAll("[^a-zA-Z0-9]", "");
        String PriceChange1 = indianIndicePChange.getText().replaceAll("[^a-zA-Z0-9]", "");
        String firstthreechr;
        String firstthreechre1;
        if(PriceChang.length()>3)
        {
            firstthreechr=PriceChange.substring(0,3);
        }
        else
        {
            firstthreechr=PriceChang;
        }

        if(PriceChange1.length()>3)
        {
            firstthreechre1=PriceChange1.substring(0,3);
        }
        else
        {
            firstthreechre1=PriceChange1;
        }
        isShowing &=commonFunctions.checkTextEquals(firstthreechre1, String.valueOf(firstthreechr),"Price First Three chr") ;
       int StocksList = expandedIndicesList.size();
        isShowing &= commonFunctions.checkTextEquals(Stocks, String.valueOf(StocksList), "No of Stocks in List are 110");
        System.out.println("Total no.of Indices in list are " + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllNiftyBank(String Link, String Header, String URI, String ID) {
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
      /*  commonFunctions.scrollToElementView(headerIndianIndices, 10, "Indices Header");
        commonFunctions.dummyWait(5);*/
        commonFunctions.scrollToElementView(indianIndicesViewAllSensex, 10, "Indices View All");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(indianIndicesViewAllclick, 10, "Indices View All");
        boolean isShowing = commonFunctions.isElementDisplayed(expandedIndianIndicesHeader, 10, "Indian Indices page Header");
        isShowing &= commonFunctions.checkElementText(expandedIndianIndicesHeader, Header, 10, "Indices Header Verified");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = niftyBankStock.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChange = Price.trim() + Pchange.trim() + "(" + Percent.trim() + "%)";
        String PriceChange1 = niftyBankStockPChange.getText().replace(" ", "");
        PriceChange1=PriceChange1.replace("+","");
        PriceChange1=PriceChange1.replace(",","");
        String firstthreechr;
        String firstthreechre1;
        if(PriceChange.length()>3)
        {
            firstthreechr=PriceChange.substring(0,3);
        }
        else
        {
            firstthreechr=PriceChange;
        }

        if(PriceChange1.length()>3)
        {
            firstthreechre1=PriceChange1.substring(0,3);
        }
        else
        {
            firstthreechre1=PriceChange1;
        }
        isShowing &= commonFunctions.checkTextEquals(firstthreechre1,String.valueOf(firstthreechr),"Price First Three chr");
        int StocksList = expandedIndicesList.size();
        System.out.println("Total no.of Indices in list are " + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllOnBseSensex(String Link, String Amp, String Header, String URI, String ID, String Stocks, String ampURL, String webURL, String url3) {
       // commonFunctions.navigateToURl(globalVars.getURL(Link);
        commonFunctions.navigateToURl(Link);
        commonFunctions.clickElementWithJS(tickerBseSensex, 10, "BSE Sensex Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 20, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
//        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
//        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
//        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
//        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextContains(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        commonFunctions.clickElement(indianIndicesViewAllSensexCta, 10, "View All Indices");
        String URL1 = commonFunctions.getCurrentURL();
       // isShowing &= commonFunctions.checkTextEquals(URL1, Link, "View All page Url Verified");
        return isShowing;
    }

    @Override
    public boolean checkStocksTableOnIndicePage(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURl(Link);
        boolean isShowing = commonFunctions.clickElementWithJS(bse500Indice, 10, "BSE 500 Indice");
        commonFunctions.scrollToElementView(bseSensexStockTableHeader, 10, "Header BSE 500 Stocks Table");
        isShowing &= commonFunctions.checkElementText(bseSensexStockTableHeader, Header, 20, "BSE 500 Stocks Header");
        commonFunctions.scrollToElementView(bse500TableViewAll, 10, "BSE 500 Stocks Table View All");
        commonFunctions.clickElementWithJS(bse500TableViewAll, 10, "BSE 500 Indice Table View All");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
//        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
//        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
//        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
//        String PriceChange = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
//        String PriceChange1 = niftyBankStockPChange.getText().replace(" ", "");
//        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StocksList = niftyBankViewAllList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(StocksList), Stocks, "Stock List");
        for (int i = 0; i < StocksList; i++) {
            isShowing &= commonFunctions.isElementClickable(niftyBankViewAllList.get(i), 10, "Bse 500 Stocks List");
        }
        return isShowing;
    }

    @Override
    public boolean checkStocksTableOnIndicePageAMP(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkMarketsTopNaV(String Link, String Link2) {
        commonFunctions.navigateToURL(Link);
        boolean isShowing = commonFunctions.isElementDisplayed(mintLogo, 5, "Mint Logo on markets page");
        isShowing &= commonFunctions.isElementDisplayed(explore, 5, "Explore Menu on markets page");
        isShowing &= commonFunctions.isElementDisplayed(epaperIcon, 5, "Epaper Icon on markets page");
        isShowing &= commonFunctions.isElementDisplayed(signIn, 5, "SignIn Button on markets page");
        isShowing &= commonFunctions.isElementDisplayed(search, 5, "Search Icon on markets page");
        isShowing &= commonFunctions.isElementDisplayed(notificationBell, 5, "Notifications Bell on markets page");
        return isShowing;
    }

    @Override
    public boolean checkSubscribeBannerForYouPage(String Link, String Link2, String Name) {
        return false;
    }

    @Override
    public boolean checkMaketPageScroll(String Link, String Page) {
        boolean isShowing = commonFunctions.clickElement(markets, 10, "Markets Section");
        commonFunctions.scrollToElementView(marketsPageLStory, 15, "Last story on Page 1");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElementView(marketsPage2Story, 15, "Story on Page 2");
        isShowing &= commonFunctions.checkPageUrlContainsText(Page, 10, "Page 2");
        return isShowing;
    }

    @Override
    public boolean checkIndicesDetails(String Link, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkLeftNavOnMarketPage() {
        commonFunctions.navigateToUrl(globalVars.getProdUrl());
        commonFunctions.clickElementWithJS(markets, 10, "Markets Sections");
        boolean isShowing = commonFunctions.isElementDisplayedOfListOfElements(marketLeftNav1, "Market Page LHS Menu1");
        for (int i = 0; i < marketLeftNav1.size(); i++) {
            String elementText = marketLeftNav1.get(i).getText();
            System.out.println(elementText + " is available");
        }
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(marketLeftNav2, "Market Page LHS Menu2");
        for (int i = 0; i < marketLeftNav2.size(); i++) {
            String elementText = marketLeftNav2.get(i).getText();
            System.out.println(elementText + " is available");
        }
        return isShowing;
    }

    @Override
    public boolean checkTopNavOnMarketPageSubscribedUser() {
        boolean isShowing= commonFunctions.clickElementWithJS(markets, 10, "Markets Section");
        isShowing &= commonFunctions.isElementDisplayed(mintLogo, 10, "Mint Logo");
        isShowing &=  commonFunctions.isElementDisplayed(explore, 10, "Explore");
        isShowing &= commonFunctions.isElementDisplayed(epaperIcon, 10, "Epaper");
        isShowing &= commonFunctions.isElementDisplayed(myAccount, 10, "MyAccount");
        isShowing &=  commonFunctions.isElementDisplayed(search, 10, "Search");
        isShowing &=  commonFunctions.isElementDisplayed(notificationBell, 10, "Notification Bell");
        return isShowing;
    }


    @Override
    public boolean checkMarketPageLayout() {
        commonFunctions.navigateToUrl(globalVars.getProdUrl());
        boolean isShowing= commonFunctions.clickElement(markets, 10, "Markets Section");
        isShowing &=commonFunctions.isElementDisplayed(marketsFirstStory, 10, "First Story");
        String Headline= commonFunctions.getElementText(marketsFirstStory);
        String Header=commonFunctions.getElementText(marketsFirstHeadline);
        isShowing &=commonFunctions.checkTextContains(Header, Headline, "First Story verified card view");
        isShowing &=commonFunctions.isElementDisplayed(marketsSecondStory, 10, "Second Story");
        String Headline1= commonFunctions.getElementText(marketsSecondStory);
        String Heading=commonFunctions.getElementText(marketsSecondHeadline);
        isShowing &=commonFunctions.checkTextContains(Heading, Headline1, "Second Story verified list view");
        return isShowing;
    }


    @Override
    public boolean checkMarketPageMastHeadAd() {
        commonFunctions.navigateToUrl(globalVars.getProdUrl());
        boolean isShowing= commonFunctions.clickElement(markets, 10, "Markets Section");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementDisplayed(headAdMarkets, 10, "Mast Head Ad on Markets Page");
        return isShowing;
    }


    @Override
    public boolean checkNewsSectionInExplore() {
        commonFunctions.navigateToUrl(globalVars.getProdUrl());
        boolean isShowing= commonFunctions.clickElement(explore, 10, "Explore menu");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementDisplayed(news, 10, "News section in explore menu");
        return isShowing;
    }
    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        return false;
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
    public boolean checkMarketTickerNiftyBankDetailPage() {
        return false;
    }

    @Override
    public boolean checkIndicesRedirectionFunctionality() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAll() {
        return false;
    }

    @Override
    public boolean checkGainersAndLosers() {
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
    public boolean checkBse100NewsSection() {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAllFunctionality() {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAllFunctionality() {
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
    public boolean checkGainerLosersDesign(String gainerLoserText) {
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
    public boolean checkCompanyDetailPageDesign() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeViewAll() {
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
    public boolean checkCompanyDetailPagePriceHistory() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageGainerLoser() {
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
    public boolean checkMutualFundDetailPage() {
        return false;
    }

    @Override
    public boolean checkDefaultSelectionCategoryTab() {
        return false;
    }

    @Override
    public boolean checkMutualFundListingPageTitle() {
        return false;
    }

    @Override
    public boolean checkMutualFundNavValue() {
        return false;
    }

    @Override
    public boolean checkMutualFundDetailPageTopSectionTitle() {
        return false;
    }

    @Override
    public boolean checkMutualFundStories() {
        return false;
    }

    @Override
    public boolean checkMutualFundReturnType() {
        return false;
    }

    @Override
    public boolean checkMutualFundReturnTable() {
        return false;
    }

    @Override
    public boolean checkTopHoldingSection() {
        return false;
    }

    @Override
    public boolean checkPortfolioSection() {
        return false;
    }

    @Override
    public boolean checkNavPriceGraph() {
        return false;
    }


    @Override
    public boolean checkLiveBlogPage(String Amp, String Link, String LinkAmp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        isShowing &=commonFunctions.checkTextContains(Link, Page, "Page Url");
        isShowing &=commonFunctions.checkFirstLiveBlog(blogHeadline, blogOpenHeadline, liveBlog);
        return isShowing;
    }

    @Override
    public boolean checkLiveBlogLeadImagenCaption(String Amp, String Link, String LinkAmp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        isShowing &=commonFunctions.checkTextContains(Link, Page, "Page Url");
        isShowing &=commonFunctions.checkFirstLiveBlog(blogHeadline, blogOpenHeadline, liveBlog);
        isShowing &=commonFunctions.checkLiveBlogImagenCaption(leadImage, caption);
        return isShowing;
    }


    @Override
    public boolean checkLiveBlogSocialnBookmarkIcons(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        isShowing &=commonFunctions.checkLiveBlogSocialIcons(iconsList);
        return isShowing;
    }

    @Override
    public boolean checkLiveBlogPageTitle(String Amp, String Link, String LinkAmp, String Title) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        isShowing &=commonFunctions.checkTextContains(Link, Page, "Page Url");
        isShowing &=commonFunctions.checkLiveBlogPageTitle(pageTitle, Title);
        return isShowing;
    }


    @Override
    public boolean checkMarketPageContent(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElement(markets, 10, "Markets" );
        isShowing &=commonFunctions.isElementDisplayed(liveBlogTitle, 10, "Page Title");
        isShowing &=commonFunctions.isElementDisplayed(firstImage, 10, "First Story Image");
        isShowing &=commonFunctions.isElementDisplayed(blogHeadline, 10, "First Story Headline");
        isShowing &=commonFunctions.isElementDisplayed(breadcrumb, 10, "MarketPage Breadcrumb");
        isShowing &=commonFunctions.isElementDisplayed(firstStoryBookmark, 10, "First Story Bookmark");
        isShowing &=commonFunctions.isElementDisplayed(firstStoryShare,10, "First Story Share");
        return isShowing;
    }

    @Override
    public boolean checkSubCategoryAvailableOption() {
        return false;
    }

    @Override
    public boolean checkFundDetailPageAboutFund() {
        return false;
    }

    @Override
    public boolean CheckFundSectionDesign() {
        return false;
    }

    @Override
    public boolean checkTopRightAdMarketPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing= commonFunctions.clickElement(explore, 10, "Explore" );
        isShowing &=commonFunctions.clickElement(exploreMarkets, 10, "Markets" );
        isShowing &=commonFunctions.isElementDisplayed(topRightAd, 10, "Top Right Ad on market page");
        return isShowing;
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
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsWeb.checkShareIconsPolitics(explore, politics, firstStory, iconsBox, iconsList);
        return isShowing;
    }

    @Override
    public boolean checkMutualFundMaximumFundListing() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeDetailPageAndBackBtn() {
        return false;
    }

    @Override
    public boolean checkStockDetailPageL1Tab() {
        return false;
    }

    @Override
    public boolean checkStockTitleWithShareIcon() {
        return false;
    }

    @Override
    public boolean checkStockAddToWatchList() {
        return false;
    }

    @Override
    public boolean checkStockPrice() {
        return false;
    }

    @Override
    public boolean checkStockPriceBSENSE() {
        return false;
    }

    @Override
    public boolean checkStockPriceGraph() {
        return false;
    }

    @Override
    public boolean checkStockPriceRange() {
        return false;
    }

    @Override
    public boolean checkStockKeyMatrics() {
        return false;
    }

    @Override
    public boolean checkStockAnaysis() {
        return false;
    }

    @Override
    public boolean checkStockRiskMeter() {
        return false;
    }

    @Override
    public boolean checkStockRecos() {
        return false;
    }

    @Override
    public boolean checkStockForecast() {
        return false;
    }

    @Override
    public boolean checkStockFinancials() {
        return false;
    }

    @Override
    public boolean checkStockTechnical() {
        return false;
    }

    @Override
    public boolean checkStockPeersSection() {
        return false;
    }

    @Override
    public boolean checkStockAboutCompany() {
        return false;
    }

    @Override
    public boolean checkL1TabOverview() {
        return false;
    }

    @Override
    public boolean checkL1TabScrollable() {
        return false;
    }

    @Override
    public boolean checkNewsSectionOnDetailPage() {
        return false;
    }

    @Override
    public boolean checkTrendingStockLeftAndRightSwipeFunctionality() {
        return false;
    }

    @Override
    public boolean checkTrendingStocksMarketDashboard() {
        return false;
    }

    @Override
    public boolean checkTrendingGainerStockDetailPage() {
        return false;
    }

    @Override
    public boolean checkTrendingStocksWidgetTop3Loser() {
        return false;
    }

    @Override
    public boolean checkTrendingLoserStockDetailPage() {
        return false;
    }

    @Override
    public boolean checkHomeTrendingStocksWidget() {
        return false;
    }

    @Override
    public boolean checkTrendingStocksWidgetTop3Gainer() {
        return false;
    }

    @Override
    public boolean checkNewsDesignAndNewsCount() {
        return false;
    }

    @Override
    public boolean checkWatchlistViewStockAndToasterMassage(String expText) {
        return false;
    }

    @Override
    public boolean checkWatchlistNewsSectionNotDisplayed() {
        return false;
    }

    @Override
    public boolean checkWatchlistIconAndStocks() {
        return false;
    }
}


