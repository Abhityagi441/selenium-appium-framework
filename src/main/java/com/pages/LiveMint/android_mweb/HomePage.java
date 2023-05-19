package com.pages.LiveMint.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace;

public class HomePage extends CommonHomePage {
    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsMobileLM;

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

    @FindBy(xpath = "(//*[@class='headline'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "(//div[contains(@class,'listtostory')]//h2/a)[1]")
    private static WebElement latestfirstStory;

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

    @FindBy(xpath = "(//div/a[@data-vars-icontype='whatsapp'])[1]")
    private static WebElement whatsappIcon;

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

    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement myAccount;

    @FindBy(id = "fixedNav_latest")
    private static WebElement latestPage;

    @FindBy(xpath = "//a[contains(text(),'Trending')]")
    private static WebElement trendingPage;

    @FindBy(id = "exclusive")
    private static WebElement premiumPage;

    @FindBy(xpath = "(//div[contains(@class, 'listtostory')])[1]")
    private static WebElement pageContent;

    @FindBy(xpath = "//figure/figcaption")
    private static WebElement imageCaption;
    //(//div[@class='figcaption'])[1]

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

    @FindBy(xpath = "//span[contains(@class,'dblock')]//img")
    private static WebElement firstImage;

    @FindBy(xpath = "(//*[@class='headline'])[1]")
    private static WebElement firstTitleInPage;

    @FindBy(xpath = "//div[@class='subinnerDes']")
    private static WebElement subscribeToContinueReading;

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

    @FindBy(id = "fixedNav_home")
    private static WebElement homePage;

    @FindBy(xpath = "//*[@id='topic_Market Dashboard'])[1]")
    private static WebElement marketDashboard;

    @FindBy(xpath = "//div/button[@id='allow']")
    private static WebElement allowNotification;

    @FindBy(xpath = "//div/button[@id='deny']")
    private static WebElement denyNotification;

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

    @FindBy(xpath = "//div/h1[@class='topicsHeading']")
    private static WebElement longStory;

    @FindBy(xpath = "(//div[contains(@class,'subnavArrow')]/img)[3]")
    private static WebElement marketsArrow;

    @FindBy(xpath = "(//a[contains(@class,'icoBookmark')])[3]")
    private static WebElement bookmarkPageLogin;

    @FindBy(xpath = "//li/a[contains(text(),'Stock Markets')]")
    private static WebElement stockMarket;

    @FindBy(xpath = "//div[@class='headlineSec']/h2/a")
    private static WebElement stockMarketHeadline;

    @FindBy(xpath = "(//div[contains(text(),'Share Via')])[1]")
    private static WebElement shareVia;

    @FindBy(xpath = "(//div[@id='socialHolder']/aside/aside/a[2])[1]")
    private static WebElement storyDetailFacebookIcon;

    @FindBy(xpath = " (//div[@id='socialHolder']/aside/aside/a[4])[1]")
    private static WebElement storyDetailLinkedinIcon;

    @FindBy(xpath = "(//div[@id='socialHolder']/aside/aside/a[5])[1]")
    private static WebElement storyDetailTwitterIcon;

    @FindBy(xpath = "//div[@class='stickyWhatsapp']")
    private static WebElement storyDetailWhatsappIcon;

    @FindBy(xpath = "//h2[@class='headline']/a)[1]")
    private static WebElement imageOtherPagesfirstStory;

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

    @FindBy(xpath = "//div/a[@id='editProfile']")
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
    private static WebElement myReads;

    @FindBy(xpath = "(//div[@class='label'][1])[2]")
    private static WebElement emailID;

    @FindBy(xpath = "//span[contains(@class,'wewidgeticon we_close icon-large')]")
    private static WebElement closeButtonForUnlimitedDigitalAccessPopup;

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

    @FindBy(xpath = "//*[@class='headline']")
    private static WebElement storyDetailPage;

    @FindBy(xpath = "//nav/a[contains(@class,'explore')]")
    private static List<WebElement> hamburgerTopmost;

    @FindBy(xpath = "//ul[@class='navCategories']/li/a")
    private static List<WebElement> hamburgerList;

    @FindBy(xpath = "//ul[@class='navCategories']")
    private static WebElement hamburgerElement;

    @FindBy(id = "Sidenav")
    private static WebElement hamburgerElement2;

    @FindBy(xpath = "//div[@class='whiteOverlay2']")
    private static WebElement hamburgerOverlay;

    @FindBy(xpath = "//div[@class='errorHolder']")
    private static WebElement error;

    @FindBy(xpath = "//section[@class='cardHolder']/article/a/h1")
    private static WebElement homeStoryHeadLine;

    @FindBy(xpath = "//div[@class='amp-push-notification']")
    private static WebElement notificationPanel;

    @FindBy(xpath = "(//button[@class='subscribe'])[2]")
    private static WebElement allowNotificationAmp;

    @FindBy(xpath = "(//div[@class='FirstEle'])[1]")
    private static WebElement scrollBeforePayWall;

    @FindBy(xpath = "//div[@class='subscriptionBox']/div")
    private static WebElement subscriptionPaywall;

    @FindBy(xpath = "//a[text()='My Account']")
    private static WebElement MyAccount;

    @FindBy(xpath = "//section[@class='editorPick']")
    private static WebElement myReadsHistory;

    @FindBy(xpath = "(//div[@class='ng-binding'])[1]")
    private static WebElement moEngagePopupDoItLater;

    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement MyaccountExplorMenu;
    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement myAccountInExploreMenu;

    @FindBy(xpath = "//div[@id='hamburgerElement']/div")
    private static WebElement exploreClick;


    @FindBy(xpath = "//div[@id='appDownloadPopup']/div")
    private static WebElement mintAppDownloadPopUp;

    @FindBy(xpath = "//nav//a[contains(@href,'latest-news')]")
    private static WebElement latestNewsLinkOnHeader;

    @FindBy(xpath = "//a[@alt='mint']")
    private static WebElement mintLogo;

    @FindBy(xpath = "//button[@id='moe-dontallow_button']")
    private static WebElement laterButtonOnNotification;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaperOnHeader;

    @FindBy(xpath = "//a[@href='/mutual-fund']/parent::li//ul//li[contains(@id,'sectionsub_mutual funds_news')]//a")
    private static WebElement mutualFundsNewsSubSection;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppOnHeader;

    @FindBy(xpath = "//a[text()='Subscribe Now']")
    private static WebElement subscribeNowButton;

    @FindBy(xpath = "//a[contains(@id,'topnav-sign-in')]")
    private static WebElement signInButton;

    @FindBy(xpath = "//a[@href='/mutual-fund']/parent::li//div")
    private static WebElement mutualFundsExpand;

    @FindBy(xpath = "//a[@href='/mutual-fund']/parent::li//ul//li[contains(@id,'sectionsub_mutual funds_mint 50')]//a")
    private static WebElement mutualFundsTop50SubSection;

    @FindBy(xpath = "//div[contains(@class,'bcrumb')]")
    private static WebElement breadcrums;

    @FindBy(xpath = "//button[@id='moe-dontallow_button']")
    private static WebElement laterPopUp;

    @FindBy(xpath = "//a[text()='OPEN IN APP']")
    private static WebElement openInAppPopup;


    @FindBy(xpath = "( //a[contains(@class,'explore')])[1]")
    private static WebElement subscribe;

    @FindBy(xpath = "//a[@href='/industry']/parent::li//div")
    private static WebElement industryExpand;

    @FindBy(xpath = "//li[contains(@class,'submenu')]//a[@href='/industry']")
    private static WebElement industrySection;

    @FindBy(xpath = "//a[@href='/opinion']/parent::li//div")
    private static WebElement opinionExpand;

    @FindBy(xpath = "//li[@id='sectionsub_opinion_columns']//a")
    private static WebElement columnsInOpinion;

    @FindBy(xpath = "//li[@id='sectionsub_opinion_views']//a")
    private static WebElement viewsInOpinion;

    @FindBy(xpath = "//li[@id='sectionp_opinion']/a")
    private static WebElement opinionSection;

    @FindBy(xpath = "//div[contains(@class,'listingNew')]")
    private static List<WebElement> listOfStoriesInColumns;

    @FindBy(xpath = "//a[contains(@class,'icoBookmark3')]")
    private static List<WebElement> bookmarkIconInStory;

    @FindBy(xpath = "//div[@class='headlineSec']//h2/a")
    private static List<WebElement> listOfStoryTitles;

    @FindBy(xpath = "//div[@class='stickyWhatsapp']")
    private static WebElement stickyWhatsappIcon;

    @FindBy(xpath = "(//section[@id='story1']//div[@class='mainArea']//section[not (@amp-access-hide)]//p) | (//div[@id='mainArea']//div[@class='FirstEle'])")
    private static List<WebElement> listofStoryParagraphs;

    @FindBy(xpath = "//div[contains(@class,'icoShare')]")
    private static List<WebElement> shareIconInStory;

    @FindBy(xpath = "//div[@class='thumbnail']//img")
    private static List<WebElement> thumpIconInStory;

    @FindBy(xpath = "//h1[text()='Columns']")
    private static WebElement columnInHomepage;

    @FindBy(xpath = "//li[contains(@class,'submenu')]//a[@href='/mutual-fund']")
    private static WebElement mutualFundsSection;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement pageHeadingOnSectionPage;

    @FindBy(xpath = "//div[contains(@class,'mwebsearch')] | //a[contains(@class,'mwebsearch')]")
    private static WebElement searchButton;

    @FindBy(xpath = "//section[contains(@class,'cardHolder')]")
    private static WebElement firstStoryInCardView;

    @FindBy(xpath = "(//a[text()='Companies'])[2]")
    private static WebElement companiesInExplore;

    @FindBy(xpath = "(//h2[@class='headline'])[1]/a")
    private static WebElement firstStoryInBreadcrumb;

    @FindBy(xpath = "//a[@href='/market']/parent::li//div")
    private static WebElement marketExpand;

    @FindBy(xpath = "//a[@href='/market/live-blog']")
    private static WebElement liveBlogSubsection;

    @FindBy(xpath = "//ul[@class='highlights']")
    private static WebElement synopsisOfStory;

    @FindBy(xpath = "(//div[@id='socialHolder']/aside/aside/a[3])[1]")
    private static WebElement whatsappIconInStoryDetail;

    @FindBy(xpath = "//div[contains(@class,'stockName')]")
    private static WebElement stockMarketName;

    @FindBy(xpath = "//a[contains(@class,'shareholding')]")
    private static WebElement shareHoldingTab;

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

    @FindBy(xpath = "(//div[@class='podDesc']/p/a)[1]")
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

    @FindBy(xpath = "//div[@class='swiper-slide']")
    private static List<WebElement> alphabetSlider;

    @FindBy(xpath = "//a[@href='/sports']")
    private static WebElement sportsSection;

    @FindBy(xpath = "//nav[@class='navNew']")
    private static WebElement l1Nav;

    @FindBy(xpath = "//nav[@class='navNew']//a")
    private static List<WebElement> listOfSectionsInL1;

    @FindBy(xpath = "//div[text()='Mint Premium']")
    private static WebElement mintPremiumCarousel;

    @FindBy(xpath = "//div[@class='listing2 clearfix']")
    private static List<WebElement> listOfStoriesInMintPremium;

    @FindBy(xpath = "//div[@class='listing2 clearfix']//span")
    private static WebElement premiumTag;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLM = CommonFunctionsMobileLM.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean storyPage() {
        String pageURL = globalVars + "/news";
        boolean storyPageStatus;
        commonFunctions.navigateToURL(pageURL);
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "MoEngage Do it later button");

        commonFunctions.waitForPageLoading();
        //commonFunctions.clickElement(latestPage,10,"Latest page");

        commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        //commonFunctions.clickElement(latestfirstStory,10,"First story on latest");
        commonFunctions.waitForPageLoading();
        boolean checkFirstHeadlineStatus = checkFirstHeadline();
        boolean checkURLChangedToStoryURLStatus = checkURLChangedToStoryURL();
        commonFunctions.clickElementIfDisplayed(mintAppDownloadPopUp, 15, "mint download banner");
        commonFunctions.isElementDisplayed(minutesToRead, 10, "Min Read");
        commonFunctions.isElementDisplayed(updatedTimeStamp, 10, "Updated TimeStamp");

        if (checkFirstHeadlineStatus && checkURLChangedToStoryURLStatus) {
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
        String pageURL = params[1];
        commonFunctions.scrollToTop();
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "Moengage pop up");
        //commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.navigateToURL(pageURL);
        commonFunctions.waitForPageLoading();
        //closeAllThePopups();
        commonFunctions.clickElementWithJS(firstStory, 10, "First Story");
        //closeAllThePopups();
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "Moengage pop up");
        //commonFunctions.clickElementWithJS(firstStory, 10, "First Story");
        commonFunctions.waitForURLContains(".html");
        String storyId = commonFunctions.getStoryIdFromURL();
        commonFunctions.clickElementIfDisplayed(mintAppDownloadPopUp, 15, "mint app download banner");
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
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(firstImage, "first Image");
        commonFunctions.isElementClickable(shareIcon, 10, "Share Icon");
        commonFunctions.clickElementWithJS(shareIcon, 10, "Share Icon");
        commonFunctions.isElementNotDisplayed(shareIcon, 10, "Share Icon");
        commonFunctions.isElementClickable(facebookIcon, 10, "Facebook Icon");
        commonFunctions.isElementClickable(linkedinIcon, 10, "LinkedIn Icon");
        shareStoryStatus = commonFunctions.isElementClickable(twitterIcon, 10, "Twitter Icon");
        return shareStoryStatus;
    }

    @Override
    public boolean pageTitle() {
        boolean pageTitleStatus;
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "Moengage pop up");
        boolean checkHomePageTitleStatus = checkPageTitle(homePage, moEngagePopupDoItLater, "Business News Today: Read Latest Business News, Live India Share Market News, Finance & Economy News | Mint", "Mint Home Page Title");
        boolean checkLatestPageTitleStatus = checkPageTitle(latestPage, moEngagePopupDoItLater, "Latest News Today: Latest News Headlines, Breaking News, Current News | Mint", "Mint Latest Page Title");
        /*boolean checkTrendingPageTitleStatus = checkPageTitle(trendingPage, "Trending News: Today's Trending News, Viral News, Popular News Headlines - Mint", "Mint Trending Page Title");
        boolean checkPremiumPageTitleStatus = checkPageTitle(premiumPage, "Read Premium News and Stories on Mint", "Mint Premium Page Title");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(marketsArrow, 10, "marketsArrow");
        commonFunctions.scrollToElement(marketsArrow, "marketsArrow");
        commonFunctions.clickElementWithJS(stockMarket);
        boolean checkStockMarketTitleStatus = checkPageTitle(stockMarketHeadline, stockMarketHeadline.getText(), "Stock Market Headline");
        commonFunctions.clickElement(explore, 10, "Explore");
        boolean checkNewsArticleTitleStatus = checkPageTitle(news, "News: Latest Breaking News, National News, World News - Mint", "Section Title");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(subArrow, 10, "subArrow");
        boolean checkSubSectionPageTitleStatus = checkPageTitle(subNews, "Company News: Latest Company News, Indian Company News, Company News Headlines", "News Subsection");
        String longStoryURL = Utils.getUrl() + "topic/long-story";
        commonFunctions.navigateToURL(longStoryURL);
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(longStory, 10, "Page Title");
        boolean checkLongStoryTitleStatus = commonFunctions.checkTextContains(globalVars.getAppiumDriver().getTitle().toLowerCase(), longStory.getText().toLowerCase(), "Long Story Title");
*/
        if (checkHomePageTitleStatus && checkLatestPageTitleStatus) {// && checkTrendingPageTitleStatus && checkPremiumPageTitleStatus && checkStockMarketTitleStatus && checkNewsArticleTitleStatus && checkSubSectionPageTitleStatus && checkLongStoryTitleStatus) {
            pageTitleStatus = true;
        } else {
            pageTitleStatus = false;
        }
        return pageTitleStatus;
    }

    @Override
    public boolean pageContent(String apiURL) {
        boolean pageContentStatus;
        String expectedText;
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "Moengage notification");
        boolean homePageTitleAndUrlStatus = checkPageURLandTitle(mintTitle, moEngagePopupDoItLater, "Home Page", "", "Business News Today: Latest Business News, Live India Share Market News, Finance & Economy News | Mint", 10);
        boolean latestPageTitleAndUrlStatus = checkPageURLandTitle(latestPage, moEngagePopupDoItLater, "Latest Page", "latest-news", "Latest News Today: Latest News Headlines, Breaking News, Current News | Mint", 10);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "MoEngage do it later button");
        commonFunctions.scrollToElement(imageOtherPagesfirstStory, 10, "Image of first story");
        commonFunctions.clickElementWithJS(imageOtherPagesfirstStory, 10, "Open First Story");
        expectedText = commonFunctions.getElementText(storyDetailPage, 10);
        boolean latestPageStoryStatus = checkDataUsingStoryAPI(expectedText, "Latest Headline in API", "content[0].headline", apiURL);
       /* boolean trendingPageTitleAndUrlStatus = checkPageURLandTitle(trendingPage, "Trending", "mostpopular", "Trending News: Today's Trending News, Viral News, Popular News Headlines - Mint", 10);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(imageOtherPagesfirstStory, 10, "Open First Story");
        expectedText = commonFunctions.getElementText(storyDetailPage, 10);
        boolean trendingPageStoryStatus = checkDataUsingStoryAPI(expectedText, "Trending Headline in API", "$.content[0].headline", apiURL);
        boolean premiumPageTitleAndUrlStatus = checkPageURLandTitle(premiumPage, "Premium", "premium", "Read Premium News and Stories on Mint", 10);
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(imageOtherPagesfirstStory, 10, "Open First Story");
        expectedText = commonFunctions.getElementText(storyDetailPage, 10);
        boolean premiumPageStoryStatus = checkDataUsingStoryAPI(expectedText, "Premium Headline in API", "$.content[0].headline", apiURL);
*/
        if (homePageTitleAndUrlStatus && latestPageTitleAndUrlStatus && latestPageStoryStatus) {// && trendingPageTitleAndUrlStatus && premiumPageTitleAndUrlStatus && trendingPageStoryStatus  && premiumPageStoryStatus) {
            pageContentStatus = true;
        } else {
            pageContentStatus = false;
        }
        return pageContentStatus;

    }

    @Override
    public boolean shareStoryFunctionality() {
        boolean shareStoryStatus;
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "MoEngage do it later button");
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(firstImage, "first Image");
        boolean shareIconHomePageStatus = commonFunctions.isElementClickable(shareIcon, 10, "Share Icon");
        commonFunctions.clickElement(shareIcon, 10, "Share Icon ");
        commonFunctions.getElementText(shareVia, 10);
        boolean facebookIconShareViaPageStatus = commonFunctions.isElementClickable(facebookIcon, 10, "Facebook Icon");
        boolean twitterIconShareViaPageStatus = commonFunctions.isElementClickable(linkedinIcon, 10, "LinkedIn Icon");
        boolean linkedInIconShareViaPageStatus = commonFunctions.isElementClickable(twitterIcon, 10, "Twitter Icon");
        boolean whatsAppIconShareViaPageStatus = commonFunctions.isElementClickable(whatsappIcon, 10, "Whatsapp Icon");
        commonFunctions.scrollToTop();
        commonFunctions.pageRefresh();
        commonFunctions.waitForPageLoading(10);
        commonFunctions.clickElement(firstTitleInPage, 10, "Open Story");
        commonFunctions.waitForTheURLContains(".html");
        commonFunctions.scrollToElement(authorName, 10, "First Image");
        commonFunctions.clickElementIfDisplayed(mintAppDownloadPopUp, 15, "mint app download pop up");
        commonFunctions.scrollDownOnce();
        boolean clickFacebookShareStatus = checkShareIconsURL(storyDetailFacebookIcon, "Facebook Page", "facebook.com");
        boolean clickTwitterShareStatus = checkShareIconsURL(storyDetailTwitterIcon, "Twitter", "twitter.com");
        commonFunctions.pageRefresh();
        commonFunctions.waitForURLContains(globalVars.getURL());
        boolean shareIconLatestPageStatus = checkShareIcon(latestPage, "Latest Page Share");
        boolean shareIconTrendingPageStatus = checkShareIcon(trendingPage, "Trending Share");
        boolean shareIconPremiumPageStatus = checkShareIcon(premiumPage, "Premium Share");
        commonFunctionsMobileLM.clickElement(explore, moEngagePopupDoItLater, 10, "Explore", "Moengage notification ");
        commonFunctions.clickElementWithJS(marketsArrow, 10, "marketsArrow");
        commonFunctions.scrollToElement(marketsArrow, "marketsArrow");
        commonFunctions.clickElementWithJS(stockMarket);
        boolean shareIconStockMarketPageStatus = commonFunctions.isElementClickable(shareIcon, 10, "stockMarket");
        commonFunctionsMobileLM.clickElement(explore, moEngagePopupDoItLater, 10, "Explore", "Moengage Pop up");
        boolean shareIconNewsPageStatus = checkShareIcon(news, "News Section");
        commonFunctionsMobileLM.clickElement(explore, moEngagePopupDoItLater, 10, "Explore", "pop up");
        commonFunctions.clickElementWithJS(subArrow, 10, "subArrow");
        boolean shareIconSubSectionPageStatus = checkShareIcon(subNews, "News Subsection");
        String longStoryURL = globalVars.getURL() + "topic/long-story";
        commonFunctions.navigateToURL(longStoryURL);
        commonFunctions.waitForPageLoading();
        boolean shareIconStoryDetailPageStatus = commonFunctions.isElementClickable(shareIcon, 10, "Long Story Share Icon");
        commonFunctions.clickElement(stockMarketHeadline, 10, "Long story headline");
        commonFunctions.scrollDownOnce();
        commonFunctions.scrollDownOnce();
        commonFunctions.scrollDownOnce();
        boolean facebookIconStoryDetailPageStatus = commonFunctions.isElementClickable(storyDetailFacebookIcon, 10, "Facebook Icon in Story Detail");
        boolean twitterIconStoryDetailPageStatus = commonFunctions.isElementClickable(storyDetailTwitterIcon, 10, "Twitter Icon  in Story Detail");
        boolean linkedInIconStoryDetailPageStatus = commonFunctions.isElementClickable(storyDetailLinkedinIcon, 10, "LinkedIn Icon  in Story Detail");
        boolean whatsAppIconStoryDetailPageStatus = commonFunctions.isElementClickable(storyDetailWhatsappIcon, 10, "Whatsapp Icon in Story Detail");

        if (shareIconHomePageStatus && shareIconLatestPageStatus && shareIconTrendingPageStatus && shareIconPremiumPageStatus && shareIconStockMarketPageStatus && shareIconNewsPageStatus && shareIconSubSectionPageStatus && shareIconStoryDetailPageStatus && facebookIconStoryDetailPageStatus && twitterIconStoryDetailPageStatus && linkedInIconStoryDetailPageStatus && facebookIconShareViaPageStatus && twitterIconShareViaPageStatus && linkedInIconShareViaPageStatus && clickFacebookShareStatus && clickTwitterShareStatus && whatsAppIconShareViaPageStatus && whatsAppIconStoryDetailPageStatus) {
            shareStoryStatus = true;
        } else {
            shareStoryStatus = false;
        }
        return shareStoryStatus;
    }


    public boolean checkShareIconsURL(WebElement element, String elementName, String expectedText) {
        boolean clickShareIconStatus;
        if (expectedText.equalsIgnoreCase("twitter.com")) {
            String expectedURL = checkSocialMediaShare(element, elementName, expectedText);
            expectedURL = ((expectedURL.substring(expectedURL.indexOf("%2F") + 1)).replaceAll("2F%2F", "")).replaceAll("%2F", "");
            expectedURL = expectedURL.substring(0, expectedURL.indexOf("&"));
            expectedURL = expectedURL.substring(0, expectedURL.indexOf("%"));
            String actualURL = commonFunctions.getCurrentURL();
            actualURL = ((actualURL.replaceAll("https://", "")).replaceAll("/", "")).replaceAll("amp", "");
            clickShareIconStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "URL");
        } else if (expectedText.equalsIgnoreCase("facebook.com")) {
            String expectedURL = checkSocialMediaShare(element, elementName, expectedText);
            expectedURL = (((expectedURL.substring(0, expectedURL.indexOf(".html"))).substring(expectedURL.indexOf("w.") + 1)).replaceAll("%252F", "")).replaceAll("F", "");
            String actualURL = commonFunctions.getCurrentURL();
            actualURL = (((actualURL.replaceAll("https://", "")).replaceAll("/", "")).replaceAll("amp", "").replaceAll(".html", "")).replace("www", "");
            clickShareIconStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "URL");
        } else if (expectedText.equalsIgnoreCase("linkedin.com")) {
            String expectedURL = checkSocialMediaShare(element, elementName, expectedText);
            expectedURL = expectedURL.substring(0, expectedURL.indexOf("?"));
            String actualURL ="https://www.linkedin.com/uas/login";
            clickShareIconStatus = commonFunctions.checkTextContains(expectedURL,actualURL,"URL");
        } else
            clickShareIconStatus = false;
        /*String actualURL = commonFunctions.getCurrentURL();
        clickShareIconStatus = commonFunctions.checkTextContains(expectedURL, actualURL, "URL");
        */
        return clickShareIconStatus;
    }


    public String checkSocialMediaShare(WebElement element, String elementName, String expectedText) {
        String URL;
        String parentWin = globalVars.getAppiumDriver().getWindowHandle();
        commonFunctions.clickElementWithJS(element, 10, elementName);
        commonFunctions.waitForPageLoading();
        String subWindowHandler = null;
        Set<String> handles = globalVars.getAppiumDriver().getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        commonFunctions.switchToWindow(subWindowHandler);
        URL = commonFunctions.getCurrentURL();
        commonFunctions.checkPageURL(expectedText, 10, elementName);
        commonFunctions.closeAllWindowsExceptMasterTab();
        globalVars.getAppiumDriver().switchTo().window(parentWin);
        return URL;
    }

    public boolean checkShareIcon(WebElement element, String elementName) {
        boolean checkShareIconStatus;
        commonFunctions.clickElementWithJS(element, 10, elementName);
        commonFunctions.waitForPageLoading();
        checkShareIconStatus = commonFunctions.isElementClickable(shareIcon, 10, elementName);
        return checkShareIconStatus;
    }

    @Override
    public boolean bookmarkStory() {
        boolean bookmarkStatus;
        commonFunctions.scrollToTop();
        commonFunctions.clickElementWithJS(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToElement(firstStory, "Image First Story");
        commonFunctions.isElementDisplayed(bookmarkIcon, 10, "BookMark Icon");
        bookmarkStatus = commonFunctions.isElementClickable(bookmarkIcon, 10, "BookMark Icon");
        return bookmarkStatus;
    }

    @Override
    public boolean bookmarkStoryLoggedInUser() {
        boolean bookmarkStoryLoggedInUserStatus;
        closeAllThePopups();
        commonFunctions.clickElement(closeMyAccount, 15, "Close My Account Button");
        commonFunctions.clickElementWithJS(imageOtherPagesfirstStory, 10, "Image First Story");
        commonFunctions.isElementDisplayed(bookmarkIcon, 10, "BookMark Icon");
        commonFunctions.isElementClickable(bookmarkIcon, 10, "BookMark Icon");
        boolean checkBookMarkIconIsActiveStatus = checkBookMarkIconIsActive();
        String bookmarkStoryId = commonFunctions.getProperty(bookmarkIcon, "id");
        bookmarkStoryId = bookmarkStoryId.split("_")[1];
        commonFunctions.scrollToTop();
        navigateToMyReadsPage();
        commonFunctions.scrollToElement(bookmarksSwiperBox, "Bookmark Swiper Box");
        commonFunctions.isElementDisplayed(bookmarksSwiperBox, 10, "BookMark Swiper Box");
        boolean checkBookmarkedStoryIdIsAvailableInBookmarkSwiperBoxStatus = checkBookmarkedStoryIdInBookmarkSwiperBox(bookmarkStoryId, true);
        String bookmarkStoryIdXpath = "//aside[@class='fl']//a[@id='bookmark_" + bookmarkStoryId + "']";
        WebElement bookMarkIconInSwiperBox = globalVars.getAppiumDriver().findElement(By.xpath(bookmarkStoryIdXpath));
        commonFunctions.clickElementWithJS(bookMarkIconInSwiperBox, 10, "BookMark Icon in BookMark Swiper Box");
        commonFunctions.pageRefresh();
        commonFunctions.waitForPageLoading();
        commonFunctions.scrollToTop();
        navigateToMyReadsPage();
        boolean checkBookmarkedStoryIdIsNotAvailableInBookmarkSwiperBoxStatus = checkBookmarkedStoryIdInBookmarkSwiperBox(bookmarkStoryId, false);
        commonFunctions.clickElement(explore, 10, "Explore menu");
        commonFunctions.clickElementWithJS(myAccount, 10, "My Account");
        if (checkBookMarkIconIsActiveStatus && checkBookmarkedStoryIdIsAvailableInBookmarkSwiperBoxStatus && checkBookmarkedStoryIdIsNotAvailableInBookmarkSwiperBoxStatus) {
            bookmarkStoryLoggedInUserStatus = true;
        } else {
            bookmarkStoryLoggedInUserStatus = false;
        }
        return bookmarkStoryLoggedInUserStatus;
    }


    @Override
    public boolean notification(String apiURL, String faviconURL) {
        return false;
    }

    @Override
    public boolean marketTicker(String[] params) {
        boolean marketTickerStatus;
        String marketStatsURL = params[0];
        String nifty50LandingPage = params[2];
        String niftyBankLandingPage = params[3];
        String bseMidcapLandingPage = params[13];
        String goldLandingPage = params[5];
        String silverLandingPage = params[6];
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading(10);
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerStatus = checkOrderListPresentInTheMarketTicker();
        commonFunctions.isElementClickable(marketTicker, 10, "Market Ticker");
        commonFunctions.isElementClickable(marketNifty, 10, "Market Sensex");
        boolean checkURLChangedToMarketStatsURLStatus = checkURLChangedToMarketStatsURL(marketStatsURL);
        boolean checkEachMarketLandingPagesAreNotBlankStatus = checkEachMarketLandingPagesAreNotBlank(nifty50LandingPage, niftyBankLandingPage, bseMidcapLandingPage);
        if (checkOrderListPresentInTheMarketTickerStatus && checkURLChangedToMarketStatsURLStatus && checkEachMarketLandingPagesAreNotBlankStatus) {
            marketTickerStatus = true;
        } else {
            marketTickerStatus = false;
        }
        return marketTickerStatus;
    }

    public boolean checkEachMarketLandingPagesAreNotBlank(String nifty50LandingPage, String niftyBankLandingPage, String bseMidcapLandingPage) {
        boolean checkEachMarketLandingPagesAreNotBlankStatus;

        dragAndDropAndClickMarketTicker(marketNifty, marketSensex, "Market Nifty");
        boolean marketNiftyLandingStatus = checkMarketTickerLandingPage(marketNiftyLanding, nifty50LandingPage, 10);
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInNiftyPage = checkOrderListPresentInTheMarketTicker();

        dragAndDropAndClickMarketTicker(marketNiftyBank, marketNifty, "Market Nifty Bank");
        boolean marketNiftyBankLandingStatus = checkMarketTickerLandingPage(marketNiftyBankLanding, niftyBankLandingPage, 10);
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInNiftyBankPage = checkOrderListPresentInTheMarketTicker();

        dragAndDropAndClickMarketTicker(marketBSEMidCap, marketNiftyBank, "Market BSE Midcap");
        boolean marketBSEMidcapLandingStatus = checkMarketTickerLandingPage(marketBSEMidCapLanding, bseMidcapLandingPage, 10);
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInBSEMidCapPage = checkOrderListPresentInTheMarketTicker();

        /*dragAndDropAndClickMarketTicker(marketGold, marketBSEMidCap, "Market Gold");
        boolean marketGoldLandingStatus = checkMarketTickerLandingPage(marketGoldLanding, goldLandingPage,10);
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInGoldPage = checkOrderListPresentInTheMarketTicker();*/

        /*dragAndDropAndClickMarketTicker(marketSilver, marketGold, "Market Silver");
        boolean marketSilverLandingStatus = checkMarketTickerLandingPage(marketSilverLanding, silverLandingPage,10);
        commonFunctions.isElementDisplayed(marketTicker, 10, "Market Ticker");
        boolean checkOrderListPresentInTheMarketTickerInSilverPage = checkOrderListPresentInTheMarketTicker();*/

        if (marketNiftyLandingStatus && marketNiftyBankLandingStatus && marketBSEMidcapLandingStatus && checkOrderListPresentInTheMarketTickerInBSEMidCapPage && checkOrderListPresentInTheMarketTickerInNiftyPage && checkOrderListPresentInTheMarketTickerInNiftyBankPage) {
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
                commonFunctions.clickElement(element1, 10, elementName);
                break;
            } catch (Exception e) {
                commonFunctions.dragAndDrop(element1, element2);
                commonFunctions.waitForPageLoading();
                if (i == 3) {
                    commonFunctions.clickElement(element1, 10, elementName);
                }
            }
        }
    }

    @Override
    public boolean nonSubscribedUserPaywall(String apiURL) {
        boolean nonSubscribedUserPayWallStatus;
        closeAllThePopups();
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(pageContent, 10, "Page Content");
        commonFunctionsMobileLM.clickElement(premiumPage, moEngagePopupDoItLater, 10, "Premium", "Notification button");
        commonFunctions.waitForTheURLContains("premium");
        boolean checkPremiumPageStatus = commonFunctions.checkPageURL(globalVars.getURL() + "premium", 10, "Premium Landing Page");
        commonFunctions.clickElement(imageOtherPagesfirstStory, 10, "First Title in Premium Page");
        commonFunctions.waitForURLContains(".html");
        boolean checkPremiumLabel = commonFunctions.checkElementText(premiumText, "PREMIUM", 10, "Premium Label");
        boolean premiumStoryStatus = checkDataUsingStoryAPI("true", "Premium Story in API", "content[0].metadata.premiumStory", apiURL);
        commonFunctions.scrollToElement(scrollBeforePayWall, 10, "Scroll Subscribe ");
        boolean payWallPresentStatus = commonFunctionsMobileLM.isElementDisplayed(subscriptionPaywall, 20, "Subscription paywall is displayed for this user ");
        if (checkPremiumPageStatus && payWallPresentStatus && checkPremiumLabel && premiumStoryStatus) {
            nonSubscribedUserPayWallStatus = true;
        } else {
            nonSubscribedUserPayWallStatus = false;
        }
        return nonSubscribedUserPayWallStatus;
    }

    @Override
    public boolean checkHamburger() {
        boolean checkHamburgerStatus;
        commonFunctions.clickElementIfDisplayed(moEngagePopupDoItLater, 20, "MoEngage do it later button");
        commonFunctionsMobileLM.clickElement(explore, moEngagePopupDoItLater, 10, "explore", "Notification Button");
        commonFunctions.clickElementWithCoordinates(800, 1500);
        commonFunctions.waitForPageLoading();
        boolean isHamburgerPresentAfterClickingOutside = commonFunctions.isElementNotDisplayed(hamburgerElement2, 10, "hamburgerElement");
        commonFunctions.clickElement(explore, 10, "explore");
        boolean isHamburgerPresent = commonFunctions.isElementDisplayed(hamburgerElement, 10, "hamburgerElement");
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
                commonFunctions.scrollToElement(hamburgerList.get(i), 10, "Scrolled to:: " + i);
                String hrefValue = hamburgerList.get(i).getAttribute("href");
                String propValue = hamburgerList.get(i).getAttribute("text").toLowerCase();
                isLinkDisplayed = commonFunctions.isElementDisplayed(hamburgerList.get(i), 10, propValue);
                isLinkClickable = commonFunctions.isElementClickable(hamburgerList.get(i), 10, propValue);
                hamburgerList.get(i).click();
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

    public boolean checkTopMostHamburgerElements() {
        boolean checkAllLinksInHamburgerStatus = true;
        boolean isLinkClickable;
        boolean isLinkDisplayed;

        try {
            for (int i = 0; i < hamburgerTopmost.size(); i++) {
                isLinkDisplayed = commonFunctions.isElementDisplayed(hamburgerTopmost.get(i), 10, hamburgerTopmost.get(i).getAttribute("text"));
                isLinkClickable = commonFunctions.isElementClickable(hamburgerTopmost.get(i), 20, hamburgerTopmost.get(i).getAttribute("text"));
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
    public boolean myAccountFunctionality(String oldPassword, String newPassword, String oldName, String newName, String email, String manageProfileURL) {
        boolean myAccountFunctionalityStatus;
        boolean fieldsValidations= true;
        /*commonFunctions.isElementDisplayed(pageTitle, 10, "Mint Title");
        commonFunctions.clickElement(explore, 10, "ExplorMenu");*/
        commonFunctions.clickElementWithJS(MyaccountExplorMenu, 10, "My Account on Click");
        fieldsValidations &= commonFunctions.isElementDisplayed(userName, 10, "Account holder user name");
        fieldsValidations &= commonFunctions.isElementDisplayed(profile, 10, "profile");
        boolean checkEmailIDUsedForLoginStatus = checkEmailIDUsedForLogin(email);
        closeAllThePopups();
        commonFunctions.clickElementWithJS(profile, 30, "profile");
        boolean checkManageProfilePageURLStatus = commonFunctions.checkPageURL(manageProfileURL, 10, "Manage profile");
        fieldsValidations &= commonFunctions.isElementDisplayedAndPresent(name, 10, "Name");
        fieldsValidations &= commonFunctions.isElementDisplayedAndPresent(emailID, 10, "Email ID");
        fieldsValidations &= commonFunctions.isElementDisplayedAndPresent(addYourContactNo, 10, "Add Your Account");
/*
        commonFunctions.isElementDisplayed(password, 10, "Password");

*/
        commonFunctions.scrollToElementView(gender,10,"Gender");
        fieldsValidations &= commonFunctions.isElementDisplayed(gender, 10, "Gender");
        boolean changeNameStatus = changeName(newName, oldName);
/*
        boolean changePasswordStatus = changePassword(oldPassword, newPassword);

        commonFunctions.clickElementWithJS(gender, 10, "Gender");
        commonFunctions.clickElementWithJS(radioGender, 20, "Gender Radio Button");
        commonFunctions.clickElementWithJS(genderSaveBtn, 10, "Save Button");
        commonFunctions.clickElementWithJS(goBack, 10, "Go Back");*/
        commonFunctions.clickElementWithJS(exploreClick,10,"Explore");
        fieldsValidations &= commonFunctions.isElementDisplayed(myAccountInExploreMenu, 10, "My Account");
        commonFunctions.clickElement(myAccountInExploreMenu, 10, "My Account");
        commonFunctions.clickElementWithJS(myReads, 10, "My Reads");
        boolean historyStatus=commonFunctions.isElementDisplayed(myReadsHistory);
        if (!historyStatus) {
            commonFunctions.waitForPageLoading();
        }
        boolean checkMyReadsPageURLStatus = commonFunctions.checkPageURL(Utils.getUrl() + "myreads", 10, "My Reads");
        commonFunctions.clickElement(explore, 10, "Explor");
        commonFunctions.clickElement(MyaccountExplorMenu, 10, "My Account");
        if (fieldsValidations && checkManageProfilePageURLStatus && checkMyReadsPageURLStatus && changeNameStatus && checkEmailIDUsedForLoginStatus) {
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

    public boolean verifyLMPremiumPage(String[] params) {
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

    public boolean checkAndVerifyViewAllOnMintLoungeCarousel() {
        return false;
    }

    @Override
    public boolean siteMap(String siteMapURL) {
        boolean sitemapStatus;
        commonFunctions.navigateToHomePage();
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
        expectedURL = expectedURL + "/latest";
        //commonFunctions.clickElement(latestfirstStory, 10, "First Story");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.waitForPageLoading();
        String actualURL = commonFunctions.getCurrentURL();
        System.out.println("Story URL: " + actualURL);
        checkURLChangedToStoryURLStatus = commonFunctions.checkTextNotEquals(expectedURL, actualURL, "Story URL");
        return checkURLChangedToStoryURLStatus;
    }

    public boolean checkFirstHeadline() {
        boolean checkFirstHeadlineStatus;
        String expectedHeadline = commonFunctions.getElementText(firstStory);
        System.out.println("Expected Headline: " + expectedHeadline);
        commonFunctionsMobileLM.clickElement(firstStory, moEngagePopupDoItLater, 10, "First Story", "moengage pop up");
        commonFunctions.waitForURLContains(".html");
        String actualHeadline = commonFunctions.getElementText(firstStory);
        if (actualHeadline.length() > 80) {
            actualHeadline = commonFunctions.getAtribute((MobileElement) firstStory, "data-mob");
            checkFirstHeadlineStatus = commonFunctions.checkTextContains(expectedHeadline, actualHeadline, " First story Mobile headline");
        } else {
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
        String expectedURL = Utils.getUrl();
        commonFunctions.scrollToTop();
        commonFunctions.waitForURLToBe(expectedURL);
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToBaseURLStatus = commonFunctions.checkTextEquals(expectedURL, actualURL, "Base URL");
        return checkURLChangedToBaseURLStatus;
    }

    public boolean checkHeadlineInAPI(Response response) {
        boolean checkHeadlineInAPIStatus;
        String expectedHeadlineFromAPI = RestUtils.getValueFromResponse(response, "content[0].headline");
        expectedHeadlineFromAPI = Utils.formatAPIText(expectedHeadlineFromAPI);
        String actualHeadlineFromUI = commonFunctions.getElementText(firstStory);
        checkHeadlineInAPIStatus = commonFunctions.checkTextContains(expectedHeadlineFromAPI, actualHeadlineFromUI, "Headline in API");
        return checkHeadlineInAPIStatus;
    }

    public boolean checkSummaryInAPI(Response response) {
        boolean checkSummaryInAPIStatus;
        String expectedSummaryFromAPI = RestUtils.getValueFromResponse(response, "content[0].summary");
        expectedSummaryFromAPI = Utils.formatAPIText(expectedSummaryFromAPI);
        String actualSummaryFromUI = commonFunctions.getElementText(summary);
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

    public boolean checkParagraphInAPI(Response response) {
        boolean checkParagraphInAPIStatus;
        String expectedParagraphFromAPI = RestUtils.getValueFromResponse(response, "content[0].listElement[0].paragraph.body");
        expectedParagraphFromAPI = Utils.formatAPIText(expectedParagraphFromAPI);
        String actualParagraphFromUI = commonFunctions.getElementText(paragraph);
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
            String actualParagraphFromUI = actualParagraphListFromUI.get(i);
            actualParagraphFromUI = Utils.formatAPIText(actualParagraphFromUI);
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
        commonFunctions.clickElement(marketSensex, 10, "Market Sensex");
        commonFunctions.waitForURLContains(marketStatsURL);
        String actualURL = commonFunctions.getCurrentURL();
        checkURLChangedToMarketStatsURLStatus = commonFunctions.checkTextEquals(marketStatsURL, actualURL, "Market Stats URL");
        return checkURLChangedToMarketStatsURLStatus;
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
        commonFunctions.clickElementWithJS(humburgIcon, 10, "Humburger Icon");
        commonFunctions.clickElementWithJS(myReadsMenu, 10, "MyReads Menu");
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
        //firstParagraph=firstParagraph.substring(firstParagraph.indexOf(":")+1,firstParagraph.length());
        allParagraphsFromUI.add(firstParagraph);
        for (int i = 0; i < allParagraphsElementListFromUI.size() - 1; i++) {
            String paragraph = allParagraphsElementListFromUI.get(i).getAttribute("textContent");
            paragraph = Utils.formatAPIText(paragraph);
            allParagraphsFromUI.add(paragraph);
        }
        return allParagraphsFromUI;
    }

    public boolean checkDataUsingStoryAPI(String expectedValue, String elementName, String jsonPath, String apiURL) {
        boolean checkDataUsingStoryAPIStatus;
        String storyId = commonFunctions.getStoryIdFromURL();
        commonFunctions.dummyWait(10);
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        commonFunctions.dummyWait(10);
        String actualValueFromAPI = RestUtils.getValueFromResponse(response, jsonPath);
        commonFunctions.dummyWait(10);
        checkDataUsingStoryAPIStatus = commonFunctions.checkTextContains(expectedValue, actualValueFromAPI, elementName);
        return checkDataUsingStoryAPIStatus;
    }

    public boolean checkPageURLandTitle(WebElement element, WebElement interceptElement, String elementName, String expectedTextURL, String expectedTextTitle, int timeOutInSecond) {
        boolean checkPageURLandTitleStatus;
        commonFunctionsMobileLM.clickElement(element, interceptElement, timeOutInSecond, elementName, elementName);
        commonFunctions.waitForURLContains(globalVars.getURL());
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

    public boolean checkPageTitleHoveringFavicon(String faviconURL) {
        boolean checkFaviconStatus;
        checkFaviconStatus = commonFunctions.checkPropertyContains(favIcon, "text", faviconURL, "Favicon");
        return checkFaviconStatus;
    }


    public boolean checkPageTitle(WebElement element, WebElement interceptElement, String expectedText, String elementName) {
        boolean checkPageTitleStatus;
        commonFunctionsMobileLM.clickElement(element, interceptElement, 10, elementName, elementName);
        commonFunctions.waitForPageLoading();
        checkPageTitleStatus = commonFunctions.checkPageTitle(expectedText, 10, elementName);
        return checkPageTitleStatus;
    }

    public boolean changeName(String newName, String oldName) {
        boolean changeNameStatus;
        commonFunctions.clickElement(name, 10, "Name");
        commonFunctions.sendKey(nameTemp, newName);
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        commonFunctions.waitForPageLoading();
        commonFunctions.clickElement(pageTitle, 10, "Home Page");
        commonFunctions.clickElement(explore, 10, "Explor");
        commonFunctions.clickElement(MyaccountExplorMenu, 10, "My account");
        commonFunctions.isElementDisplayed(accountName, 20, "Name Displayed");
        commonFunctions.clickElement(profile, 10, "profile");
        commonFunctions.clickElement(name, 10, "Name");
        commonFunctions.clearText(nameTemp, "Name");
        commonFunctions.sendKey(nameTemp, oldName);
        commonFunctions.clickElement(saveButton, 10, "Save Button");
        changeNameStatus = commonFunctions.isElementDisplayed(pageTitle, 10, "Home Page");
        return changeNameStatus;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        boolean changePasswordStatus;
        commonFunctions.clickElement(pageTitle, 10, "Home Page");
        commonFunctions.clickElement(explore, 10, "Explor Menu");
        commonFunctions.clickElement(MyaccountExplorMenu, 10, "My Account");
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

    public boolean checkEmailIDUsedForLogin(String email) {
        boolean checkEmailIDUsedForLoginStatus;
        String actualEmail = commonFunctions.getElementText(userEmailUsed);
        actualEmail = actualEmail.replaceAll("\n", "").trim();
        checkEmailIDUsedForLoginStatus = commonFunctions.checkTextContains(email, actualEmail, "Email ID");
        return checkEmailIDUsedForLoginStatus;
    }

    public static void closeAllThePopups() {
        commonFunctions.switchToFrame(googleAdFrame, 10, "Google Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup, "Close button in google popup", 6);
        commonFunctions.switchToFrame(googleAdFrame2, 6, "Google Ad Frame2");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup2, "Close button in google popup", 6);
        commonFunctions.switchToFrame(notificationAdFrame, 6, "Notification Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonInFivePercentDiscountAdPopup, "Close button in Five percent discount popup", 6);
        commonFunctions.closePopupIfExist(closeButtonInDownloadTheAppAdPopup, "Close button in Download the ad popup", 6);
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        commonFunctions.switchToDefaultContent();
    }

    public static void closeMonsoonPopup() {
        commonFunctions.switchToFrame(notificationAdFrame, 6, "Notification Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonInDownloadTheAppAdPopup, "Close button in Download the ad popup", 6);
        commonFunctions.switchToDefaultContent();
    }

    @Override
    public boolean checkInVisibilityOfSponsoredStoryOn() {
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

    public void switchToChildWindowsExceptMasterTab() {
        try {

            ArrayList<String> handleList = new ArrayList<>(driver.getWindowHandles());
            if (handleList.size() > 1) {
                for (int i = 1; i < handleList.size(); i++) {
                    driver.switchTo().window(handleList.get(i));
                }
            }
            driver.switchTo().window(handleList.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return false;
    }

    @Override
    public boolean subscribedUserAdsFreeApp() {
        return false;
    }

    @Override
    public boolean sponsoredStory() {
        return false;
    }

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
    public boolean checkSectionNameWithListedStory() {
        return false;
    }

    @Override
    public boolean checkTickerArrow() {
        return false;
    }

    @Override
    public boolean checkLatestScrollOnLatestNewsPage() {
        boolean isScrollWorked = false;
        int count = 0;
        commonFunctions.clickElementIfDisplayed(latestNewsLinkOnHeader, 10, "Latest News");
        while (!isScrollWorked) {
            commonFunctions.scrollDownOnce();
            count++;
            if (commonFunctions.getCurrentURL().contains("page-5")) {
                isScrollWorked = true;
            }
            if (count == 200) {
                break;
            }
        }
        return isScrollWorked;
    }

    @Override
    public boolean checkMintTop50MF(String pageTitle) {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp, 30, "Later button on Popup");
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand, 10, "Scroll down to Mutual Funds");
        commonFunctions.clickElementIfDisplayed(mutualFundsTop50SubSection, 10, "Click on Top 50 MF");
        isElementDisplayed &= checkMintLogo() && breadcrums.isDisplayed() && explore.isDisplayed() && ePaperOnHeader.isDisplayed() && getAppOnHeader.isDisplayed() && subscribeNowButton.isDisplayed();
        isElementDisplayed &= driver.getTitle().equalsIgnoreCase(pageTitle);
        commonFunctions.clickElementIfDisplayed(explore, 10, "CLick Explore button");
        isElementDisplayed &= signInButton.isDisplayed();
        return isElementDisplayed;
    }

    @Override
    public boolean checkL1TabSelectionDiffStory() {
        return false;
    }

    @Override
    public boolean checkHeaderNavigationOfEachTab() {
        return false;
    }

    @Override
    public boolean checkColumnsSubSectionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(columnsInOpinion, 5, "Columns in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIconInStory.get(0), 5, "Bookmark Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareIconInStory.get(0), 5, "Share Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.isElementDisplayed(columnInHomepage, 5, "Columns in homepage");
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
    public boolean checkMFSectionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand, 5, "Scroll down to Mutual Funds");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(mutualFundsSection, 5, "Mutual Funds section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(firstStoryInCardView, 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIconInStory.get(0), 5, "Bookmark Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareIconInStory.get(0), 5, "Share Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Mutual Funds");
        return isElementDisplayed;
    }

    @Override
    public boolean checkNewsSubsectionUnderMFInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand, 5, "Scroll down to Mutual Funds");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(mutualFundsNewsSubSection, 5, "Mutual Funds section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIconInStory.get(0), 5, "Bookmark Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareIconInStory.get(0), 5, "Share Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("News");
        return isElementDisplayed;
    }

    @Override
    public boolean checkViewsSubsectionUnderOpinionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Columns in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIconInStory.get(0), 5, "Bookmark Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareIconInStory.get(0), 5, "Share Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Views");
        return isElementDisplayed;

    }

    @Override
    public boolean checkViewsSubsectionStoryPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Columns in opinion");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoryTitles.get(0), 5, "Story titles");
        commonFunctions.clickElementIfDisplayed(listOfStoryTitles.get(0), 5, "Story titles");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listofStoryParagraphs.get(0), 20, "First Paragraph");
        isElementDisplayed &= commonFunctions.isElementDisplayed(stickyWhatsappIcon, 5, "Whatsapp Icon");
        return isElementDisplayed;
    }

    @Override
    public boolean checkViewsSubsectionPageLayout() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(viewsInOpinion, 5, "Columns in opinion");
        commonFunctions.clickElementIfDisplayed(denyNotification, 10, "I'll do this later Notification");
        commonFunctions.clickElementIfDisplayed(laterButtonOnNotification, 10, "later button Notification");
        isElementDisplayed &= commonFunctions.isElementDisplayed(mintLogo, 5, "Mint Logo");
        isElementDisplayed &= commonFunctions.isElementDisplayed(breadcrums, 5, "Breadcrumb");
        isElementDisplayed &= commonFunctions.isElementDisplayed(explore, 5, "Explore");
        isElementDisplayed &= commonFunctions.isElementDisplayed(searchButton, 5, "Search button");
        isElementDisplayed &= commonFunctions.isElementDisplayed(ePaperOnHeader, 5, "E paper on header");
        isElementDisplayed &= commonFunctions.isElementDisplayed(getAppOnHeader, 5, "Get App button");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Views");
        return isElementDisplayed;
    }


    @Override
    public boolean checkIndustryPageLayout() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(industryExpand, 5, "Scroll down to Industry");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(industrySection, 5, "Industry section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(firstStoryInCardView, 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(0), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Third story");
        return isElementDisplayed;

    }

    @Override
    public boolean checkMintTop50MFForSubscribedUsers(String pageTitle) {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp, 30, "Later button on Popup");
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.scrollToElementViewAndClick(mutualFundsExpand, 10, "Scroll down to Mutual Funds");
        commonFunctions.clickElementIfDisplayed(mutualFundsTop50SubSection, 10, "Click on Top 50 MF");
        isElementDisplayed &= checkMintLogo() && breadcrums.isDisplayed() && explore.isDisplayed() && ePaperOnHeader.isDisplayed() && getAppOnHeader.isDisplayed() && subscribeNowButton.isDisplayed();
        isElementDisplayed &= driver.getTitle().equalsIgnoreCase(pageTitle);
        isElementDisplayed &= commonFunctions.isElementClickable(openInAppPopup, 10, "Open In App");
        commonFunctions.clickElementIfDisplayed(explore, 10, "CLick Explore button");
        isElementDisplayed &= myAccount.isDisplayed();
        return isElementDisplayed;
    }

    @Override
    public boolean checkOpinionsSectionInTopNav() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp, 30, "Later button on Popup");
        commonFunctions.clickElementIfDisplayed(explore, 10, "Click Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(opinionExpand, 5, "Scroll down to opinion");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(opinionSection, 5, "opinion Section");
        isElementDisplayed &= commonFunctions.isElementDisplayed(firstStoryInCardView, 5, "First story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(listOfStoriesInColumns.get(1), 5, "Second story");
        isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIconInStory.get(0), 5, "Bookmark Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(shareIconInStory.get(0), 5, "Share Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(thumpIconInStory.get(0), 5, "Thumb");
        isElementDisplayed &= commonFunctions.getElementText(pageHeadingOnSectionPage, 5).equalsIgnoreCase("Opinion");
        return isElementDisplayed;
    }

    @Override
    public boolean checkBreadcrumbOnCompaniesPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp, 30, "Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(companiesInExplore,5,"Scroll down to Companies");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(firstStoryInBreadcrumb,5,"First story in Companies page");
        commonFunctions.pageRefresh();
        isElementDisplayed &= commonFunctions.isElementDisplayed(breadcrums,5,"Breadcrumb");
        isElementDisplayed &=  commonFunctions.getElementText(breadcrums,5).contains("Home / Companies /");//headline can not verify because special characters remove from breadcrumb
        return isElementDisplayed;
    }

    @Override
    public boolean checkTwitterPageWhenTapOnTwitterIcon() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp, 30, "Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(marketExpand,5,"Scroll down to market");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(liveBlogSubsection,5,"Live-blog sub section");
        isElementDisplayed &= commonFunctions.clickElement(notificationFirstStory,5,"First story in live blog");
        commonFunctions.scrollToElementView(synopsisOfStory,5,"Synopsis of story");
        boolean clickTwitterShareStatus = checkShareIconsURL(storyDetailTwitterIcon, "Twitter", "twitter.com");
        return isElementDisplayed && clickTwitterShareStatus;
    }

    @Override
    public boolean checkLinkedinPageWhenTapOnLinkedinIcon() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp, 30, "Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(marketExpand,5,"Scroll down to market");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(liveBlogSubsection,5,"Live-blog sub section");
        isElementDisplayed &= commonFunctions.clickElement(notificationFirstStory,5,"First story in live blog");
        commonFunctions.scrollToElementView(synopsisOfStory,5,"Synopsis of story");
        boolean clickLinkedinShareStatus = checkShareIconsURL(storyDetailLinkedinIcon, "Linkedin", "linkedin.com");
        return isElementDisplayed && clickLinkedinShareStatus;
    }

    @Override
    public boolean checkFacebookPageWhenTapOnFacebookIcon() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp, 30, "Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe,10,"Subscribe button");
        commonFunctions.scrollToElementViewAndClick(marketExpand,5,"Scroll down to market");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(liveBlogSubsection,5,"Live-blog sub section");
        isElementDisplayed &= commonFunctions.clickElement(notificationFirstStory,5,"First story in live blog");
        commonFunctions.scrollToElementView(synopsisOfStory,5,"Synopsis of story");
        boolean clickLinkedinShareStatus = checkShareIconsURL(storyDetailFacebookIcon, "Facebook", "facebook.com");
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
        isElementDisplayed &= commonFunctions.isElementDisplayed(bookmarkIcon,5,"Bookmark Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailFacebookIcon, 10, "Facebook Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(whatsappIconInStoryDetail,5,"Whatsapp Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailLinkedinIcon, 10, "LinkedIn Icon");
        isElementDisplayed &= commonFunctions.isElementDisplayed(storyDetailTwitterIcon, 10, "Twitter Icon");
        return isElementDisplayed;
    }

    @Override
    public boolean checkShareholdingWidget() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.navigateToURL(globalVars.getURL()+"market/market-stats/stocks-vodafone-idea-share-price-nse-bse-s0003014");
        isElementDisplayed &= commonFunctions.isElementDisplayed(stockMarketName,5,"Stock Market");
        commonFunctions.innerScrollLeftToRight(driver,shareHoldingTab,"Shareholding");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(shareHoldingTab,5,"Shareholding");
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
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(companiesInExplore,5,"Scroll down to Companies");
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
        commonFunctions.scrollDownOnce();
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
        commonFunctions.scrollDownOnce();
        commonFunctions.clickElement(podcastStory,5,"Podcast story");
        isElementDisplayed &= commonFunctions.getElementTextAndCheck(podcastPageTitle,"PODCAST EPISODES",5,"Podcast page title");
        commonFunctions.scrollToElementView(mediaPlayer,5,"Episode");
        String podcastEpisodeName = commonFunctions.getElementText(episodeName);
        isElementDisplayed &= commonFunctions.isElementDisplayed(mediaPlayer,5,"Media player on episode");
        isElementDisplayed &= commonFunctions.isElementDisplayed(episodeDate,5,"Date on episode");
        isElementDisplayed &= commonFunctions.clickElementIfDisplayed(seemoreInEpisode,5,"See more in Episode");
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
        commonFunctions.dummyWait(5);
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
        commonFunctions.scrollDownOnce();
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
        int numberOfAlphabet = alphabetSlider.size();
        if(numberOfAlphabet == 27) {
            isElementDisplayed &= true;
        } else {
            isElementDisplayed &= false;
        }
        isElementDisplayed &= commonFunctions.isElementDisplayed(alphabetSlider.get(0),5,"All selected");
        commonFunctions.innerScrollLeftToRight(driver,alphabetSlider.get(numberOfAlphabet-1),"Alphabet slider");
        isElementDisplayed &= commonFunctions.isElementDisplayed(alphabetSlider.get(numberOfAlphabet-1),5,"Last alphabet");
        isElementDisplayed &= commonFunctions.isElementDisplayed(siteMapHeader,5,"Mint authors");
        return isElementDisplayed;
    }

    @Override
    public boolean checkSportsLandingPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection,5,"Scroll down to Sports");
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
        commonFunctions.scrollToElementViewAndClick(sportsSection,5,"Scroll down to Sports");
        isElementDisplayed &= commonFunctions.isElementDisplayed(siteMapHeader,5,"Sports landing page");
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
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.scrollToElementView(mintPremiumCarousel,5,"Mint premium Carousel");
        isElementDisplayed &= commonFunctions.isElementDisplayed(mintPremiumCarousel,5,"Mint premium Carousel");
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
        commonFunctions.scrollToElementViewAndClick(sportsSection,5,"Scroll down to Sports");
        isElementDisplayed &=  commonFunctions.clickElementIfDisplayed(notificationFirstStory,5,"First story");
        isElementDisplayed &= commonFunctions.scrollToElementView(synopsisOfStory,5,"Summary of story");
        return isElementDisplayed;
    }

    @Override
    public boolean checkParagraphOnSportsPage() {
        boolean isElementDisplayed = true;
        commonFunctions.clickElementIfDisplayed(laterPopUp,30,"Later button on Popup");
        commonFunctions.clickElement(explore,5,"Explore button");
        commonFunctions.moveToElementWithActions(subscribe, 10, "Subscribe button");
        commonFunctions.scrollToElementViewAndClick(sportsSection,5,"Scroll down to Sports");
        isElementDisplayed &=  commonFunctions.clickElementIfDisplayed(notificationFirstStory,5,"First story");
        isElementDisplayed &= commonFunctions.scrollToElementView(paragraph,5,"First Paragraph");
        return isElementDisplayed;
    }
}
