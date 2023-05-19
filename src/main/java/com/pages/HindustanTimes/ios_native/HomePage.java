package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.sun.javafx.scene.traversal.Direction;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;


public class HomePage extends CommonHomePage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(id  = "Explore")
    private static MobileElement hamburgerMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='Continue']")
    private static MobileElement continueLink;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SKIP']")
    private static MobileElement skipONBrowser;

    @iOSXCUITFindBy(id = "ht nav logo")
    private static MobileElement htLogo;

    @iOSXCUITFindBy(className = "XCUIElementTypeLink")
    private static List<MobileElement> advertisment;

   // @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Blank'])[2]/XCUIElementTypeOther[4]")
   @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='ADVERTISEMENT']")
    private static List<MobileElement> topAddver;

    //@iOSXCUITFindBy(className = "XCUIElementTypeLink")
    @iOSXCUITFindBy(id = "ht nav logo")
    private static List<MobileElement> bottomAdver;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='india'][1]")
//    private static MobileElement india;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Saved')]")
    private static MobileElement saved;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Epaper']")
    private static MobileElement ePaper;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='ePaper']")
    private static MobileElement ePaperButtonOnHeader;

    @iOSXCUITFindBy(id="Home")
    private static MobileElement home;

    @iOSXCUITFindBy(id="India")
    private static MobileElement indiaWithId;

    @iOSXCUITFindBy(id="Quickreads")
    private static MobileElement quickReads;

    @iOSXCUITFindBy(id="Swipe Up For Next Story")
    private static MobileElement quickReadsPage;

    @iOSXCUITFindBy(id="Swipe Up For Next Story")
    private static MobileElement swipeUp;

    @iOSXCUITFindBy(id = "profileBarButton")
    private static MobileElement profile;

    @iOSXCUITFindBy(id="Premium")
    private static MobileElement premium;

    @iOSXCUITFindBy(id="ACCOUNT")
    private static MobileElement profilePage;

    @iOSXCUITFindBy(id="HT Premium")
    private static MobileElement premiumPage;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='India']")
    private static MobileElement india;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Tokyo')]")
    private static MobileElement sports;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Cities']")
    private static MobileElement cities;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Elections']")
    private static MobileElement elections;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Opinion']")
    private static MobileElement opinion;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='lifestyle']")
    private static MobileElement lifestyle;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='World']")
    private static MobileElement world;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Daily Digest']")
    private static MobileElement dailyDigest;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'min read')]/parent::XCUIElementTypeCell//XCUIElementTypeButton[contains(@name,'three grey list')]//preceding-sibling::XCUIElementTypeButton[contains(@name,'')]")
    private static List<MobileElement> listOfSubSectionsInDailyDigestStoriesPage;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='MORNING BRIEF'] | //XCUIElementTypeStaticText[@name='EVENING BRIEF']")
    private static MobileElement sectionPageHeader;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='DAILY NEWS CAPSULE']")
    private static MobileElement dailyNewsCapsuleHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyCaption;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Opinion']")
    private static MobileElement opinions;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Cricket']")
    private static MobileElement cricket;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Entertainment']")
    private static MobileElement entertainment;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Photos']")
    private static MobileElement photos;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Videos']")
    private static MobileElement videos;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Explore Apps']")
    private static MobileElement exploreApps;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Notifications']")
    private static MobileElement notifications;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Settings']")
    private static MobileElement settings;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='E-Paper']")
    private static MobileElement ePaperCTA;

    //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='URL'])[1]")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='URL']")
    @iOSXCUITFindBy(id="URL")
    private static MobileElement urlElement;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='banner']/XCUIElementTypeOther[3]/XCUIElementTypeImage")
    private static WebElement homeEpaper;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'SafariWindow')]")
    private static WebElement browserContext;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = " //XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement exploreButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Popular Sections']")
    private static MobileElement exploreButtonPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Photos']")
    private static MobileElement photosSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PHOTOS']")
    private static MobileElement photosLandingPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Videos']")
    private static MobileElement videosSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VIDEOS']")
    private static MobileElement videosLandingPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back new']")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top News']")
    private static MobileElement topNewsSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Trending Topics')]")
    private static MobileElement trendingTopics;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Don't Miss']")
    private static MobileElement dontMiss;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='whiteCross']")
    private static MobileElement headerPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Cricket']")
    private static MobileElement cricketSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Web Stories']")
    private static MobileElement webStories;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static MobileElement threeDots;

    @iOSXCUITFindBy(id = "Bookmark")
    private static MobileElement bottomBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Close']")
    private static MobileElement cancel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Most Read']")
    private static MobileElement mostRead;

    @iOSXCUITFindBy(id = "Subscribe to Newsletter")
    private static MobileElement subscribeToNewsletter;

    @iOSXCUITFindBy(id = "whiteCross")
    private static MobileElement subscribeToNewsletterClose;

    @iOSXCUITFindBy(id = "blackForward")
    private static MobileElement subscribeToNewsletterArrow;

    @iOSXCUITFindBy(id = "Bookmark")
    private static MobileElement bottomActionSheet;

    @iOSXCUITFindBy(id = "Share")
    private static MobileElement shareOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Messages']")
    private static MobileElement shareSheet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Close']")
    private static MobileElement cancelBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther")
    private static List<MobileElement> storiesInQuickReads;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Read Full Story']/following-sibling::XCUIElementTypeButton")
    private static MobileElement readFullStory;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='twitter']/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
    private static MobileElement quickReadStoryTitle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyheader;

    @iOSXCUITFindBy(id = "twitter")
    private static MobileElement twitter;

    @iOSXCUITFindBy(id = "share whatsapp")
    private static MobileElement whatsApp;

    @iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name='ADVERTISEMENT'])[1]")
    private static MobileElement topAdInQuickReadOpenStory;

    @iOSXCUITFindBy(id = "share day")
    private static MobileElement shareStoryOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Quickreads']")
    private static MobileElement quickReadsOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = 'Quickreads']/following-sibling::XCUIElementTypeButton[@name = 'View All']")
    private static MobileElement viewAllInquickReadsCarousel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Latest Videos']")
    private static MobileElement latestVideosCarousel;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText)[1]")
    private static MobileElement firstStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText[1]")
    private static MobileElement clickFirstStory;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell[2]//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyHeadingText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Label'`][2]")
    private static MobileElement openStoryHeadingText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name = 'Latest Videos']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private static MobileElement storyInLatestVideosCarousel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name = 'Photos']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private static MobileElement storyInPhotosCarousel;

    @iOSXCUITFindBy(id = "Close Advertisement")
    private static MobileElement closeButtonAdvertisement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name = 'Web Stories']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private static MobileElement storyInWebStoriesCarousel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Share story']")
    private static MobileElement shareStory;

    @iOSXCUITFindBy(id = "ht_logo")
    private static List<MobileElement> htLogosInWebStories;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static List<MobileElement> ThreeDotsInWebStoriesPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name = 'Quickreads']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    private static MobileElement storyInQuickReadsCarousel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Newsletters']")
    private static MobileElement newsLettersCarousel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Daily News Capsule']")
    private static MobileElement firstCardInNewsLetters;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='@HT_Ed Calling']")
    private static MobileElement secondCardInNewsLetters;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='HT Wknd']")
    private static MobileElement thirdCardInNewsLetters;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'Subscribe')])[1]")
    private static MobileElement subscribeButtonOnFirstNewsLetter;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Subscribe Now']")
    private static MobileElement subsribeNowButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Subscribed']")
    private static MobileElement subscribedButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Enter your email address')]")
    private static MobileElement enterEmailAddressNewsLetterText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Daily News Capsule']")
    private static MobileElement dailyNewsCapsuleOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Button']")
    private static MobileElement newsLetterCloseButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Read Now']")
    private static List<MobileElement> readNowInNewsLetter;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DAILY NEWS CAPSULE']")
    private static MobileElement dailyNewsPageHeading;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Quickreads']")
    private static MobileElement quickReadOnBottomNav;

    @iOSXCUITFindBy(id = "Cricket")
    private static MobileElement cricketModule;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Button' AND name == 'Button' AND type == 'XCUIElementTypeButton'")
    private static MobileElement closeBtnInSubscribe;

    @iOSXCUITFindBy(id = "Recommended For You")
    private static MobileElement recommendedForYouCarousel;

    @iOSXCUITFindBy(id = "View All")
    private  static MobileElement viewAllButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please register to manage your newsletter subscription']")
    private  static MobileElement nonLoggedInUserHeading;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='PRIVACY POLICY']")
    private  static MobileElement privacyPolicyHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private  static MobileElement emailPrefilledOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='For You']")
    private  static MobileElement forYouTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Daily Digest']")
    private static MobileElement dailyDigestSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='All']")
    private static MobileElement quickReadsAllTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Swipe Up For Next Story']")
    private static MobileElement quickReadsMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='India News']")
    private static MobileElement quickReadsIndiaNewsTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Entertainment']")
    private static MobileElement quickReadsEntertainmentTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cricket']")
    private static MobileElement quickReadsCricketTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cities']")
    private static MobileElement quickReadsCitiesTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='World News']")
    private static MobileElement quickReadsWorldNewsTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lifestyle']")
    private static MobileElement quickReadsLifestyleTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Astrology']")
    private static MobileElement quickReadsAstrologyTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sports']")
    private static MobileElement quickReadsSportsTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Business']")
    private static MobileElement quickReadsBusinessTab;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Recommended For You']//following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText[contains(@name,'')])[1]")
    private static MobileElement recommendedForYouStoryList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private static List<MobileElement> listOfSectionInQuickReads;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Cricket']")
    private static MobileElement cricketHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText")
    private static List<MobileElement> listOfSectionsInQuickReads;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Read Now'])[2]")
    private static MobileElement readNowInDailyNewsCapsule;

    @iOSXCUITFindBy(id = "City News")
    private static MobileElement cityNewsInHomepage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'°C')]/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listOfCitiesInCityNews;

    @iOSXCUITFindBy(id = "View All")
    private static MobileElement viewAllInCityNews;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Welcome')]")
    private  static MobileElement popUpOnCities;

    @iOSXCUITFindBy(id= "Got It")
    private static MobileElement gotItButtonOnCitiesPopUp;

    @iOSXCUITFindBy(id = "Maybe Later")
    private static MobileElement mayBeLaterButtonOnCitiesSection;

    @iOSXCUITFindBy(id = "Save Changes")
    private static MobileElement saveChangesButtonOnCitiesSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Add Cities')]")
    private static MobileElement addCitiesOption;

    @iOSXCUITFindBy(id = "Delhi")
    private static MobileElement delhiSelectButton;

    @iOSXCUITFindBy(id= "Add your favourite cities")
    private static MobileElement addFavouriteCities;

    @iOSXCUITFindBy(id = "Noida")
    private static MobileElement noidaCitySelectButton;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        /*commonFunctions.clickElementIfDisplayed(allowTracking,15,"Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 15, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(continueButton,30,"Continue Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,30,"Later Button");
        commonFunctions.clickElementIfDisplayed(skip,30,"Skip Button");
        commonFunctions.clickElementIfDisplayed(skip,30,"Skip Button");*/

    }

    public boolean allHamburgerMenuDisplayed(String [] params)
    {   boolean isStep=false;
        // Calling param here as test method has differnt signature
       // String[] params;//=globalVars.getParamsDataSingleProperty("verifyHomePageLoadingVerification");
        for (int i=0;i<params.length;i++)
        {
            Utils.logStepInfo(true,"Verifying Menu Option -- " +params[i]);
             isStep=isSubMenuDisplayed(driver,params[i]);
            Utils.logStepInfo(isStep,params[i]+" is Displayed");

        }
    return isStep;
    }

    public boolean isSubMenuDisplayed(IOSDriver<MobileElement> driver,String name){

        MobileElement element = commonFunctions.getElement(name);
        boolean isSubmenuVisible = commonFunctions.scrollDownSlowToElement(element,2);
        commonFunctions.scrollToTopOniOSNative();
        return  isSubmenuVisible;
    }


    @Override
    public boolean checkAdDisplayingHomePage() {
        return false;
    }

    @Override
    public boolean checkEpaperCTALogoRedirection(String[] params) {
        boolean epaperVisible=commonFunctions.isElementDisplayed(ePaperCTA);
        Utils.logStepInfo(epaperVisible,"epaper is visible");
        boolean clickEPaper =commonFunctions.clickElement(ePaperCTA);
        Utils.logStepInfo(clickEPaper,"Successsfully clicked on ePaper");


       // commonFunctions.isElementDisplayed(continueLink,5,"");
        //commonFunctions.clickElementNoException(continueLink,"continue link");
        commonFunctions.clickElement(continueLink,5,"Continue");
        commonFunctions.clickElement(skipONBrowser,5,"Skip button on browser");

        //commonFunctions.isElementDisplayed(skipONBrowser,5,"");
       // commonFunctions.clickElementNoException(skipONBrowser,"Skip button on browser");
        //commonFunctions.isElementDisplayed(urlElement,20,"Url");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String url=urlElement.getText();

        boolean validateUrl=url.contains(params[4]);
        Utils.logStepInfo(validateUrl,"Validated url");

        commonFunctions.tapByCoordinate(64,37,"redirection to home page");

        return epaperVisible&&clickEPaper&&validateUrl;
    }

    @Override
    public boolean checkHomePageLoaded(String[] params) {
        commonFunctions.clickElement(home,5,"Home Tab");
        boolean htLgo = commonFunctions.isElementDisplayed(htLogo,5,"htLogo");
        boolean topAdd = commonFunctions.isElementDisplayed(topAddver.get(0),10,"Top Advertisement");
        boolean tapHB = commonFunctions.clickElement(hamburgerMenu,5,"Hamburger");
        boolean isAllHamburgerStep = allHamburgerMenuDisplayed(params);
        //commonFunctions.clickElementIfDisplayed(hamburgerMenu,5,"Hamburger Menu");
        Utils.logStepInfo(true,"htLgo = "+htLgo);
        Utils.logStepInfo(true,"topAdd = "+topAdd);
        Utils.logStepInfo(true,"tapHB = "+tapHB);
        Utils.logStepInfo(true,"isAllHamburgerStep = "+isAllHamburgerStep);
        return htLgo && topAdd && tapHB || isAllHamburgerStep;
    }

    @Override
    public boolean checkRedirectionOnPhotosFromExplore() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElement(exploreButton, 5, "Explore button");
        commonFunctions.scrollDownToElement(photos);
        commonFunctions.clickElement(photos, 5, "Photos section in Explore page");
        boolean photosRedirection = commonFunctions.getElementText(photosLandingPage, 5).equalsIgnoreCase("Photos");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return photosRedirection;
    }

    @Override
    public boolean checkQuickReadsRedirection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue=commonFunctions.isElementDisplayed(quickReadsPage, 5, "Quick reads page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(quickReads, 5, "Quick reads button");
        return isRedirectionTrue && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkProfileRedirection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        Utils.logStepInfo("Tap on Profile");
        commonFunctions.clickElement(profile, 5, "Profile on Home page");
        boolean isRedirectionTrue=commonFunctions.isElementDisplayed(profilePage, 5, "Profile page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(home, 5, "HT home button");
        return isRedirectionTrue && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkPremiumRedirection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        Utils.logStepInfo("Tap on Premium");
        commonFunctions.clickElement(premium, 5, "Quick reads on Home page");
        boolean isRedirectionTrue=commonFunctions.isElementDisplayed(premiumPage, 5, "Premium page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(premium, 5, "Premium button");
        return isRedirectionTrue && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkExploreRedirection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        commonFunctions.clickElement(topNewsSection, 5, "Top news");
        Utils.logStepInfo("Tap on Explore");
        commonFunctions.clickElement(exploreButton, 5, "Quick reads on Home page");
        boolean isRedirectionTrue=commonFunctions.isElementDisplayed(exploreButtonPage, 5, "Explore page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(exploreButton, 5, "Explore button");
        return isRedirectionTrue && isHTHomeButtonSelected;
    }

    @Override
    public boolean checkSectionHomeIsHighlightedInBottomNav() {
        commonFunctions.clickElement(home, 5, "HT home button");
       boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        Utils.logStepInfo("Tap on any section (eg. India section)");
        commonFunctions.clickElement(india, 5, "India news on Home page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(home, 5, "HT home button");
        return isHTHomeButtonSelected;
    }

    @Override
    public boolean checkSectionIndiaHighlit() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        commonFunctions.clickElement(india,5,"India");
        boolean isIndiaSelected = commonFunctions.isElementDisplayed(indiaWithId,5,"India Section");
        return isHTHomeButtonSelected && isIndiaSelected;
    }

    @Override
    public boolean checkGetPersonalizedExperiencePageNotDisplay() {
        Utils.logStepInfo("Looking for Get Personalized Experience page should not display.");
        return !commonFunctions.isElementDisplayed(continueButton, 5, "Continue button at Get personalized Experience page");

    }

    @Override
    public boolean checkAllBottomNavDisplay() {
        commonFunctions.clickElement(home, 5, "HT home button");
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        boolean isAllNavButtonDisplay = commonFunctions.isElementDisplayed(home, 5, "HT home module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(quickReads, 5, "Quickreads module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(exploreButton, 5, "Explore module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(cricketModule, 5, "Cricket module");
        isAllNavButtonDisplay &= commonFunctions.isElementDisplayed(premium, 5, "Premium module");
        return isHTHomeButtonSelected && isAllNavButtonDisplay;
    }

    @Override
    public boolean checkTapOnSectionSubsectionRedirectToSectionPage() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnVideoFromExplore() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElement(exploreButton, 5, "Explore button");
//        commonFunctions.scrollUpUntilElementFound(videosSection);
        commonFunctions.clickElement(videosSection, 5, "Videos section in Explore page");
        boolean videosRedirection = commonFunctions.getElementText(videosLandingPage, 5).equalsIgnoreCase("Videos");
        commonFunctions.clickElement(back, 5, "Back to Explore page");
        return videosRedirection;
    }

    @Override
    public boolean checkTrendingTopicsCarousel() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.scrollDownToElement(trendingTopics);
        boolean trendingTopicsTrue = commonFunctions.isElementDisplayed(trendingTopics, 5,"Trending Topics Carousel");
        commonFunctions.scrollToTopOniOSNative();
        return trendingTopicsTrue;
    }

    @Override
    public boolean checkQuickReadsFunctionality() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue=commonFunctions.isElementDisplayed(quickReadsPage, 5, "Quick reads page");
        isHTHomeButtonSelected &= commonFunctions.isElementSelected(quickReads, 5, "Quick reads button");
        boolean isSwipeUpDisplayed=commonFunctions.isElementDisplayed(swipeUp, 5, "Swipe Up page");

        return isRedirectionTrue && isHTHomeButtonSelected && isSwipeUpDisplayed;
    }

    @Override
    public boolean checkDontMissOption() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isTopAdDisplayed = commonFunctions.isElementDisplayed(topAddver.get(0), 15, "Top Ad");
        commonFunctions.scrollDownToElement(dontMiss);
        boolean isDontMissVisible = commonFunctions.isElementDisplayed(dontMiss, 5, "Don't Miss");
        commonFunctions.scrollDownToElement(cricketSection);
        boolean adDisplayed = commonFunctions.isElementDisplayed(topAddver.get(2), 15, "Ad");
        return  isHTHomeButtonSelected && isTopAdDisplayed && isDontMissVisible&&adDisplayed;
    }
    @Override
    public boolean checkPhotosSection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(photosSection);
        boolean isPhotosVisible = commonFunctions.isElementDisplayed(photosSection, 5, "Photos Section");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        Utils.logStepInfo(true,"isHTHomeButtonSelected = "+isHTHomeButtonSelected);
        Utils.logStepInfo(true,"isPhotosVisible = "+isPhotosVisible);
        return  isHTHomeButtonSelected && isPhotosVisible;
    }
    @Override
        public boolean  checkCricketSection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isTopAdDisplayed = commonFunctions.isElementDisplayed(topAddver.get(0), 5, "Top Ad");
        commonFunctions.scrollDownToElement(topAddver.get(2));
        boolean isCricketVisible = commonFunctions.isElementDisplayed(cricketSection, 5, "Cricket Section");
        commonFunctions.killAppAndReLaunch();
        return  isHTHomeButtonSelected && isTopAdDisplayed && isCricketVisible;
    }
    @Override
    public boolean checkWebStoriesSection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isTopAdDisplayed = commonFunctions.isElementDisplayed(topAddver.get(0), 15, "Top Ad");
        commonFunctions.scrollDownToElement(webStories);
        boolean isWebStoriesVisible = commonFunctions.isElementDisplayed(webStories, 5, "Web Stories Section");
        commonFunctions.killAppAndReLaunch();
        return  isHTHomeButtonSelected && isTopAdDisplayed && isWebStoriesVisible;
    }
    @Override
    public boolean checkMostReadSection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(mostRead,home,25);
        boolean isMostReadVisible = commonFunctions.isElementDisplayed(mostRead, 5, "Most Read Section");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return  isHTHomeButtonSelected && isMostReadVisible;
    }
    @Override
    public boolean checkSubscribeToNewsletterBehaviour() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter, 5, "Daily News Capsule");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Daily news subscribe button");
        commonFunctions.clickElementIfDisplayed(closeBtnInSubscribe,5,"Close button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        if(!isHomePage){
            commonFunctions.clickByCoordinates(368,547);//getting Some BrowserStack Related error so clicking by Coordinate
            isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        }
        isHomePage &= commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter,5,"Subscribe To Newsletter in First Card");
        commonFunctions.killAppAndReLaunch();

        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isHomePage = "+isHomePage);

        return  isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage;
    }

    @Override
    public boolean check3DotMsgBoxDisplayed()
    {
        commonFunctions.clickElement(home, 5, "Home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isTopAdDisplayed = commonFunctions.isElementDisplayed(topAddver.get(0), 15, "Top Ad");
        boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,5,"Three DOts");
        commonFunctions.clickElement(threeDots,5,"Three DOts");
        boolean bottomBoxDisplayed=commonFunctions.isElementDisplayed(bottomBox,5,"Bottom Box");
        commonFunctions.clickElement(cancel,5,"Cancel");
        boolean bottomBoxNotDisplayed=commonFunctions.isElementNotDisplayed(bottomBox,5,"Bottom Box");
        return isHTHomeButtonSelected&&isTopAdDisplayed&&threeDotsDisplayed&&bottomBoxDisplayed&&bottomBoxNotDisplayed;

    }

    @Override
    public boolean checkShareOption()
    {
        commonFunctions.clickElement(home, 5, "Home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 20, "HT home page Top News Section");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isTopAdDisplayed = commonFunctions.isElementDisplayed(topAddver.get(0), 20, "Top Ad");
        boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,5,"Three Dots");
        commonFunctions.clickElement(threeDots,5,"Three Dots");
        boolean isBottomActionSheetDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,5,"Bottom Action Sheet");
        commonFunctions.clickElement(shareOption,5,"Share");
        commonFunctions.killAppAndReLaunch();
        /*commonFunctions.clickByCoordinates(68,68,"OutSide the Share Pop up to Close it...");
        commonFunctions.clickElementIfDisplayed(back,5,"Back Button");*/
        Utils.logStepInfo(true,"isHTHomeButtonSelected = "+isHTHomeButtonSelected);
        Utils.logStepInfo(true,"isTopAdDisplayed = "+isTopAdDisplayed);
        Utils.logStepInfo(true,"threeDotsDisplayed = "+threeDotsDisplayed);
        Utils.logStepInfo(true,"isBottomActionSheetDisplayed = "+isBottomActionSheetDisplayed);
        return isHTHomeButtonSelected && isTopAdDisplayed && threeDotsDisplayed && isBottomActionSheetDisplayed;

    }

    @Override
    public boolean checkQuickReadHaveOneStoryAtATime() {
        boolean isRedirectedToQuickReadPage = checkQuickReadsRedirection();
       boolean isQuickReadHaveOnlyOneStory = false;
       int numOfStories = storiesInQuickReads.size();
       System.out.println("Number stories present in Quick Read = " +numOfStories);
       if(storiesInQuickReads.size()==2){
           isQuickReadHaveOnlyOneStory = true;
           Utils.logStepInfo(true, "Only one story is displayed in Quickreads");
       } else {
           isQuickReadHaveOnlyOneStory = false;
           Utils.logStepInfo(false, "More Than one stories are displayed in Quickreads");
       }
        return isRedirectedToQuickReadPage && isQuickReadHaveOnlyOneStory;
    }

    @Override
    public boolean checkQuickReadFirstAndSecondWithSwipe() {
        commonFunctions.clickElement(home,5,"Home");
        commonFunctions.clickElement(quickReads,5,"Quick Read Option");
        String firstStoryTitle = quickReadStoryTitle.getText();
        System.out.println("First Story Title ----- " + firstStoryTitle);
        commonFunctions.swipeElementUsingTouchAction(103,673,128,191);
        //scrollDownTillStoryIsNotChangedInQuickRead(firstStoryTitle,quickReadStoryTitle);
        String secondStoryTitle = quickReadStoryTitle.getText();
        System.out.println("Second Story Title ----- " + secondStoryTitle);
        commonFunctions.scrollToTopOniOSNative();
        String firstStoryTitleAfterSwipUp = quickReadStoryTitle.getText();
        System.out.println("First Story Title After Swip up----- " + firstStoryTitleAfterSwipUp);
        boolean isFirstStorytitle = firstStoryTitle.equalsIgnoreCase(firstStoryTitleAfterSwipUp);
        return isFirstStorytitle;
    }

    @Override
    public boolean checkQuickReadReadFullStoryRedirection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        String storyTitle = quickReadStoryTitle.getText();
        System.out.println("Quick Read Story title is ---- " +storyTitle);
        boolean isReadFullStoryOption = commonFunctions.isElementDisplayed(readFullStory,5,"Read full Story Option");
        commonFunctions.clickElement(readFullStory,5,"Read Full Story");
        commonFunctions.clickElement(skip,5,"Skip");
        commonFunctions.dummyWait(5);
        boolean isShareStoryOption = commonFunctions.isElementDisplayed(shareStoryOption,5,"Share Option");
        return isReadFullStoryOption || isShareStoryOption;
    }

    @Override
    public boolean checkFirstAdAfter4StoriesInQuickReadPage() {
        boolean isRedirectedToQuickReadPage =  checkQuickReadsRedirection();
        for (int i =0; i<4; i++){
            commonFunctions.swipeElementUsingTouchAction(103,673,128,191);
        }
        boolean isFirstAd = (!commonFunctions.isElementDisplayed(quickReadStoryTitle,5,"Quick Read Story Title"));
        return isFirstAd;
    }

    @Override
    public boolean checkViewAllLinkRightToQuickread() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isTopAdDisplayed = commonFunctions.isElementDisplayed(topAddver.get(0), 5, "Top Ad");
        commonFunctions.scrollDownToElement(quickReadsOption);
        boolean isQuickRead = commonFunctions.isElementDisplayed(quickReadsOption, 5, "Quick Reads Section");
        isQuickRead &= commonFunctions.isElementDisplayed(viewAllInquickReadsCarousel,5,"View ALL in QuickRead Carousel");
        if(isQuickRead){
            commonFunctions.clickElement(viewAllInquickReadsCarousel,5,"View ALL QuickRead click");
            isQuickRead &= commonFunctions.isElementDisplayed(readFullStory,5,"Quick Read Story open");
        }
        return  isHTHomeButtonSelected && isTopAdDisplayed && isQuickRead;
    }

    @Override
    public boolean checkQuickreadsReadFullStoryRedirectionForBackpress() {
        boolean isFullStoryRedirectionTrue = checkQuickReadReadFullStoryRedirection();
        commonFunctions.clickElementWithJS(back,5,"Back button");
        boolean isReadFullStoryDisplayed = commonFunctions.isElementDisplayed(readFullStory,5,"Quick Read Story open");
        return isFullStoryRedirectionTrue || isReadFullStoryDisplayed;
    }

    @Override
    public boolean checkShareOptionInQuickRead() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        commonFunctions.clickElement(readFullStory,5,"Quick Read Story open");
        commonFunctions.clickElement(skip,5,"Skip");
        boolean isShareOptionDisplayed = commonFunctions.isElementDisplayed(shareStoryOption,5,"Share Option");
        return isShareOptionDisplayed;
    }

    @Override
    public boolean checkTappingOnViewAllOnLatestVideoCarousel() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        try{
            commonFunctions.scrollDownToElement(carouselOption("Latest Videos"));
        }
        catch(org.openqa.selenium.NoSuchElementException e){
            System.out.println(e.getMessage());
            commonFunctions.scrollDownToElement(latestVideosCarousel);
        }
       boolean islatestVideos  = commonFunctions.isElementDisplayed(carouselOption("Latest Videos"), 5, "Latest Videos Carousel");
       islatestVideos &= commonFunctions.isElementDisplayed(viewAllInCarouselOption("Latest Videos"),5,"View ALL in Latest Videos Carousel");
        if(islatestVideos){
            commonFunctions.clickElement(viewAllInCarouselOption("Latest Videos"),5,"View ALL QuickRead click");
            islatestVideos &= commonFunctions.isElementDisplayed(firstStory,5,"Latest Videos Section opened");
        }
        return  islatestVideos;
    }

    @Override

    public boolean checkEPaperOptionFromHeader() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        commonFunctions.clickElement(quickReads,5,"Quick Read");
        boolean isEpaperDisplaye=commonFunctions.isElementDisplayed(ePaperButtonOnHeader, 5, "E-paper on top");
        return isEpaperDisplaye;
    }

    @Override
    public boolean checkEPaperOptionFromQuickReadHeader() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        commonFunctions.clickElementIfDisplayed(quickReadOnBottomNav,5,"QuickRead from Bottom Nav");
        boolean isEpaperDisplaye=commonFunctions.isElementDisplayed(ePaperButtonOnHeader, 5, "E-paper on top");
        return isEpaperDisplaye;
    }

    public boolean checkAppearanceOfLatestVideoCarousel() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(latestVideosCarousel);
        boolean islatestVideosAppear  = commonFunctions.isElementDisplayed(carouselOption("Latest Videos"), 5, "Latest Videos Carousel");
        return islatestVideosAppear;
    }

    @Override
    public boolean checkAdAfterDontMissSection() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isTopAdDisplayed = commonFunctions.isElementDisplayed(topAddver.get(0), 10, "Top Ad");
        commonFunctions.scrollDownToElement(dontMiss);
        boolean isDontMissVisible = commonFunctions.isElementDisplayed(dontMiss, 5, "Don't Miss");
        commonFunctions.scrollDownToElement(cricketSection);
        boolean adDisplayedAtEndDontMiss = commonFunctions.isElementDisplayed(topAddver.get(2), 15, "Ad");
        return  isHTHomeButtonSelected && isTopAdDisplayed && isDontMissVisible && adDisplayedAtEndDontMiss;
    }

    @Override
    public boolean checkRedirectToRespectiveStory() {
        commonFunctions.clickElement(home,5,"Home");
        String firstStoryTextInStoryList = firstStory.getText();
        System.out.println("First Story text = " + firstStoryTextInStoryList);
        commonFunctions.clickElement(clickFirstStory, 5, "First Story in Entertainment Section");
        commonFunctions.clickElementIfDisplayed(skip, 5, "Skip");
        commonFunctions.dummyWait(3);
        System.out.println("Opened Story's heading text = " + openStoryHeadingText.getText());
        boolean isStoryOpened = commonFunctions.compareTexts(firstStoryTextInStoryList, openStoryHeadingText.getText());
        boolean isDisplayOpenedStory = commonFunctions.isElementDisplayed(openStoryHeadingText, 5, "Story Heading");
        commonFunctions.killAppAndReLaunch(notificationLater,4,"Later");
        return isStoryOpened || isDisplayOpenedStory;
    }

    @Override
    public boolean checkRedirectToStoryFromLatestVideoCarousel() {
        boolean latestVideoCarousel = checkAppearanceOfLatestVideoCarousel();
        boolean isStoryDiaplyedInLatestVideos = commonFunctions.isElementDisplayed(storyInLatestVideosCarousel,5,"Story in Latest Videos");
        if(isStoryDiaplyedInLatestVideos){
            commonFunctions.clickElement(storyInLatestVideosCarousel,5,"Story In Latest Videos");
        }
        else{
            commonFunctions.scrollDownSlowToElement(storyInLatestVideosCarousel,2);
            commonFunctions.clickElement(storyInLatestVideosCarousel,5,"Story In Latest Videos");
        }
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip");
        boolean isStoryPageOpen = commonFunctions.isElementDisplayed(whatsApp,5,"Whatsup") && commonFunctions.isElementDisplayed(twitter,5,"Twitter");
        commonFunctions.clickElementIfDisplayed(back,5,"Back to Home page");
        commonFunctions.scrollDownSlowToElement(latestVideosCarousel,2);
        latestVideoCarousel &= commonFunctions.isElementDisplayed(latestVideosCarousel, 5, "Latest Videos Carousel");
        return latestVideoCarousel && isStoryDiaplyedInLatestVideos && isStoryPageOpen;
    }

    @Override
    public boolean checkRedirectToStoryFromPhotoCarousel() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(photosSection);
        boolean isPhotosAppear  = commonFunctions.isElementDisplayed(carouselOption("Photos"), 5, "Photos Carousel");
        boolean isStoryDiaplyedInPhotos = commonFunctions.isElementDisplayed(storyInPhotosCarousel,5,"Story in Photos");
        if(isStoryDiaplyedInPhotos){
            commonFunctions.clickElement(storyInPhotosCarousel,5,"Story In Photos");
        }
        else{
            commonFunctions.scrollDownSlowToElement(storyInPhotosCarousel,2);
            commonFunctions.clickElement(storyInPhotosCarousel,5,"Story In Photos");
        }
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip");
        boolean isStoryPageOpen = commonFunctions.isElementDisplayed(whatsApp,5,"Whatsup") && commonFunctions.isElementDisplayed(twitter,5,"Twitter");
        commonFunctions.clickElement(home,5,"Home Button");
        commonFunctions.killAppAndReLaunch(notificationLater,4,"Later");
        return isPhotosAppear && isStoryDiaplyedInPhotos && isStoryPageOpen;
    }

    @Override
    public boolean checkRedirectToStoryFromWebStoriesCarousel() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(webStories);
        boolean isWebStoriesVisible = commonFunctions.isElementDisplayed(webStories, 5, "Web Stories Section");
        commonFunctions.scrollDownSlowToElement(storyInWebStoriesCarousel,5);
        boolean isStoryInWebStories = commonFunctions.isElementDisplayed(storyInWebStoriesCarousel,5,"Story in Web Stories Section");
        String webStoryText = storyInWebStoriesCarousel.getText();
        System.out.println("Web Story Text **** ---- " +webStoryText);
        commonFunctions.clickElement(storyInWebStoriesCarousel,5,"Story in Web Stories");
        boolean isStoryPageOfWebStory = commonFunctions.isElementDisplayed(shareStory,5,"Share Story");
        return isWebStoriesVisible && isStoryInWebStories && isStoryPageOfWebStory;
    }

    @Override
    public boolean checkViewAllFromWebStoriesCarousel() {
        commonFunctions.clickElement(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(webStories);
        boolean isWebStoriesVisible = commonFunctions.isElementDisplayed(webStories, 5, "Web Stories Section");
        boolean isViewAllOptionInWebStory = commonFunctions.isElementDisplayed(viewAllInCarouselOption("Web Stories"),5,"View ALL in Web Stories");
        if(isViewAllOptionInWebStory){
            commonFunctions.clickElement(viewAllInCarouselOption("Web Stories"),5, "View All Click");
        }
        boolean isStoriesInWebStories = commonFunctions.compareWithSizeListOfElements(ThreeDotsInWebStoriesPage,1,"Stories In Web Stories Page");
        boolean isHtLogosInWebStoriesPage = commonFunctions.compareWithSizeListOfElements(htLogosInWebStories,1,"HT Logos in Web Stories Page");
        return isWebStoriesVisible && isViewAllOptionInWebStory && isStoriesInWebStories && isHtLogosInWebStoriesPage;
    }

    @Override
    public boolean checkQuickReadsCraouselDisplayedOnHome() {
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(home, 5, "HT home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(quickReadsOption);
        boolean isQuickRead = commonFunctions.isElementDisplayed(quickReadsOption, 5, "Quick Reads Section");
        isQuickRead &= commonFunctions.isElementDisplayed(viewAllInquickReadsCarousel,5,"View ALL in QuickRead Carousel");
        return isHTHomeButtonSelected && isQuickRead;
    }

    @Override
    public boolean checkRedirectToStoryFromQuickReadsCraousel() {
        boolean isQuickReadDisplayed = checkQuickReadsCraouselDisplayedOnHome();
        boolean isStoryDisplayed = commonFunctions.isElementDisplayed(storyInQuickReadsCarousel,5, "Story in Quickreads");
        if(isStoryDisplayed) {
            commonFunctions.clickElement(storyInQuickReadsCarousel, 5, "Story in QuickReads");
        }
        else{
            commonFunctions.scrollDownSlowToElement(storyInQuickReadsCarousel,2);
            commonFunctions.clickElement(storyInQuickReadsCarousel, 5, "Story in QuickReads");
        }
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip");
        boolean isQuickReadsStoryOpen = commonFunctions.isElementDisplayed(twitter,5,"Twitter Share Option") && commonFunctions.isElementDisplayed(whatsApp,5,"WhatsUp Share Option");
        return isQuickReadDisplayed && isStoryDisplayed && isQuickReadsStoryOpen;
    }

    @Override
    public boolean  checkNewslettersCarouselDisplayed() {
        commonFunctions.clickElement(home,5,"Home");
        commonFunctions.scrollDownToElement(newsLettersCarousel);
        boolean isNewsLettersDisplayed = commonFunctions.isElementDisplayed(newsLettersCarousel,5,"Newsletters Carousel");
        return isNewsLettersDisplayed;
    }

    @Override
    public boolean checkScrollrightToLeftAndLeftToRightOnNewsletters() {
        boolean isNewsLettersCardDisplayed = checkSecondCardIsHTEDCallingOnNewsletters();
        int firstElement[] = commonFunctions.getElementXYCoordinate(firstCardInNewsLetters);
        int secondElement[] = commonFunctions.getElementXYCoordinate(secondCardInNewsLetters);
        commonFunctions.swipeElementUsingTouchAction(secondElement[0],secondElement[1],firstElement[0],firstElement[1]);
        commonFunctions.dummyWait(5);
        commonFunctions.swipeElementUsingTouchAction(firstElement[0],firstElement[1],secondElement[0],secondElement[1]);
        boolean isFirstCardDisplayedAfterScrolling = commonFunctions.isElementDisplayed(firstCardInNewsLetters,5,"1st card Daily News Capsule");
        return isNewsLettersCardDisplayed && isFirstCardDisplayedAfterScrolling;
    }

    @Override
    public boolean checkFirstCardIsDailyNewsCapsuleOnNewsletters() {
        boolean isDisplayed = checkNewsletterScroll(readNowInDailyNewsCapsule);
        isDisplayed &= commonFunctions.isElementDisplayed(firstCardInNewsLetters,5,"Daily News Capsule");
        return isDisplayed;
    }

    @Override
    public boolean checkSecondCardIsHTEDCallingOnNewsletters() {
        boolean isDisplayed = checkNewsletterScroll(readNowInDailyNewsCapsule);
        isDisplayed &= commonFunctions.isElementDisplayed(secondCardInNewsLetters,5,"@HT_Ed Calling");
        return isDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTabOnReadNowOnNewsletters() {
        boolean isFirstCardInNewsLetter = checkFirstCardIsDailyNewsCapsuleOnNewsletters();
        commonFunctions.clickOnReadNowInNewsLetter(readNowInNewsLetter,1);
        boolean isFirstCardPageOpen = commonFunctions.isElementDisplayed(dailyNewsPageHeading,5,"Daily News Page Heading");
        return isFirstCardInNewsLetter && isFirstCardPageOpen;
    }

    @Override
    public boolean checkTopAdsClickable() {
        return false;
    }

    @Override
    public boolean checkHamburgerMenuAllOptionDisplayed() throws Exception {
        return false;
    }

    @Override
    public boolean checkLiveblogPaginationEmbeds(String title) {
        return false;
    }

    @Override
    public boolean checkHomePageLoadingVerification() {
        return false;
    }

    @Override
    public boolean checkLeftPaneDisplayed() {
        return false;
    }

    @Override
	public boolean checkEpaperCta(String[] params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkHomePageItems() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean checkPremiumArtExclusiveTag() {
        return false;
    }

    @Override
    public boolean checkHTAutoRedirection() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTappingProfile() {
        return false;
    }

    @Override
    public boolean checkMayBeLaterOptionBehaviour() {
        return false;
    }

    @Override
    public boolean checkEmailTextArea() {
        return false;
    }

    @Override
    public boolean checkPasswordTextArea() {
        return false;
    }

    @Override
    public boolean checkHindustanTimesLogoDisplayed() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTappingExplore() {
        return false;
    }

    @Override
    public boolean checkEpaperAndSearchDisplayed() {
        return false;
    }

    @Override
    public boolean checkHomeTabHeader() {
        return false;
    }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnDailyNewsCapsule() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnDailyNewsCapsule(String emailId) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter, 5, "Daily News Capsule");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Daily news subscribe button");
        System.out.println("Email id - "+emailId);
        commonFunctions.sendKeyBoolean(emailPrefilledOption,emailId);
        boolean isEmailIdPrefilled =checkEmailIdPrefilled(emailId);
        boolean isDailyNewsCapsuleSubscribedSuccessfully = checkSubscribeSuccessfully();
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isEmailIdPrefilled = "+isEmailIdPrefilled);
        Utils.logStepInfo(true,"isDailyNewsCapsuleSubscribedSuccessfully = "+isDailyNewsCapsuleSubscribedSuccessfully);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isEmailIdPrefilled || isDailyNewsCapsuleSubscribedSuccessfully;
    }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTEdCalling() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTEdCalling(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTWknd() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTWknd(String email) { return false; }
    public boolean scrollDownTillStoryIsNotChangedInQuickRead(String text, MobileElement ele) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            while (!commonFunctions.getElementText(ele, 5).contains(text)) {
                new TouchAction(driver).press(PointOption.point(height / 2, width / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(height / 2, width / 10)).release().perform();
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public MobileElement carouselOption(String carouselToElement){
        MobileElement carousel = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='"+carouselToElement+"']"));
        return carousel;
    }

    public MobileElement viewAllInCarouselOption(String viewAllOption){
        MobileElement viewAll = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name = '"+viewAllOption+"']/following-sibling::XCUIElementTypeButton[@name = 'View All']"));
        return viewAll;
    }

    @Override
    public boolean checkEmailIdPrefilled(String email) {
        boolean emailIdPrefilled= commonFunctions.getElementTextAndCheckWithContains(emailPrefilledOption,email,5,"EmailID prefilled");
        return emailIdPrefilled;
    }

    @Override
    public boolean checkNewsletterScroll(MobileElement ele) {
        commonFunctions.clickElement(home, 5, "Home Button");
        boolean isHTHomePageDisplayed = commonFunctions.isElementDisplayed(home, 5, "HT HomePage highlighted");
        commonFunctions.scrollToElementDown(ele);
        return isHTHomePageDisplayed;
    }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTWeekAhead() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTWeekAhead(String email) {return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTCapitalLetters() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTCapitalLetters(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnWiredWisdom() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnWiredWisdom(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTCity() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTCity(String email) { return false; }

    @Override
    public boolean checkRegisterNowButton() { return false; }

    @Override
    public boolean checkSubscribeSuccessfully() {
        commonFunctions.clickElement(subsribeNowButton,5,"Subscribe now button");
        commonFunctions.dummyWait(2);
        boolean isSubscribeMessageChecked = commonFunctions.isElementDisplayed(subscribedButton,5,"Newsletter subscribed successfully");
        return isSubscribeMessageChecked;
    }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTMindTheGap() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTMindTheGap(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTKickOff() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTKickOff(String email) { return false; }

    @Override
    public boolean checkRecommendedForYouCarouselOnHome() {
        commonFunctions.clickElement(home,5,"Home button");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        commonFunctions.scrollDownToElement(recommendedForYouCarousel,20);
        boolean isRecommendedForYouCarouselDisplayed = commonFunctions.isElementDisplayed(recommendedForYouCarousel,5,"Recommended For You Carousel");
        return isRecommendedForYouCarouselDisplayed;
    }

    @Override
    public boolean checkViewAllLinkOnRecommendedForYouCarousel() {
        boolean isRecommendedForYouCarouselDisplayed = checkRecommendedForYouCarouselOnHome();
        boolean isViewAllLinkDisplayed = commonFunctions.isElementDisplayed(viewAllButton,5,"View All Link Button");
        return isRecommendedForYouCarouselDisplayed && isViewAllLinkDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTapOnViewAllLinkFromRecommendedForYouCarousel() {
        boolean isViewAllLinkDisplayed = checkViewAllLinkOnRecommendedForYouCarousel();
        commonFunctions.clickElement(viewAllButton,5,"View all button from Recommended for you carousel");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isRedirectedToForYouListingPage = commonFunctions.isElementSelected(forYouTab,5,"For You Listing page");
        commonFunctions.killAppAndReLaunch(notificationLater,4,"Later");
        return isViewAllLinkDisplayed;
    }

    @Override
    public boolean checkForYouTabOnL1() {
        commonFunctions.clickElement(home,5,"Home page");
        commonFunctions.clickElementIfDisplayed(headerPopup, 5, "Header Popup");
        boolean isForYouTabDisplayed = commonFunctions.isElementDisplayed(forYouTab,5,"After Top News Tab, For You Tab");
        return isForYouTabDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTapOnStoryFromRecommendedForYouCarousel() {
        boolean isRedirectToForYouStroy = true;
        boolean isRecommendedForYouCarouselDisplayed = checkRecommendedForYouCarouselOnHome();
        commonFunctions.clickElement(recommendedForYouStoryList, 5, "Story Tap from Recommended For You");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip button");
        isRedirectToForYouStroy = commonFunctions.isElementDisplayed(storyCaption,5,"Redirected to any story from Recommended for you Carousel");
        return isRecommendedForYouCarouselDisplayed && isRedirectToForYouStroy;
    }

    public boolean navigateToDailyDigestSection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        commonFunctions.clickElement(exploreButton, 5, "Explore button");
        commonFunctions.clickElementIfDisplayed(dailyDigest, 5, "Daily Digest section in Explore page");
        return commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("MORNING BRIEF") || commonFunctions.getElementText(sectionPageHeader, 5).equalsIgnoreCase("EVENING BRIEF");
    }

    @Override
    public boolean checkDailyDigestRedirection() {
        boolean checkSection = navigateToDailyDigestSection();
        commonFunctions.clickElement(back,5,"Back Button");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(home, 5, "Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        return checkSection && isHomePage;
    }

    @Override
    public boolean checkDailyDigestSectionRedirection() {
        boolean checkSection = navigateToDailyDigestSection();
        String sectionName= commonFunctions.getElementText(listOfSubSectionsInDailyDigestStoriesPage.get(0),5);
        commonFunctions.clickElementIfDisplayed(listOfSubSectionsInDailyDigestStoriesPage.get(0),5,"CLick on first story section");
        boolean isHeaderMatched=commonFunctions.getElementText(sectionPageHeader,5).equalsIgnoreCase(sectionName);
        commonFunctions.clickElement(back,5,"Back Button");
        commonFunctions.dummyWait(5);
        return checkSection && isHeaderMatched;
    }

    @Override
    public boolean checkDailyDigestStoryRedirection() {
        boolean checkSection = navigateToDailyDigestSection();
        commonFunctions.clickElementIfDisplayed(firstStory,5,"CLick on first story");
        commonFunctions.clickElementIfDisplayed(skip, 5, "Skip button");
        commonFunctions.dummyWait(3);
        boolean isStoryDisplayed= commonFunctions.isElementDisplayed(storyCaption,5,"Story Caption");
        Utils.logStepInfo(true,"checkSection = "+checkSection);
        Utils.logStepInfo(true,"isStoryDisplayed = "+isStoryDisplayed);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return checkSection && isStoryDisplayed;
    }

    @Override
    public boolean checkDailyDigestStoryShare() {
        boolean checkSection = navigateToDailyDigestSection();
        commonFunctions.clickElementIfDisplayed(threeDots,5,"CLick on first story");
        boolean isBookMarkOption = commonFunctions.isElementDisplayed(shareOption,5,"Share Option");
        commonFunctions.clickElement(shareOption,5,"Share Option");
        boolean isShareSheetDisplayed= commonFunctions.isElementDisplayed(shareSheet,5,"Share Sheet");
        commonFunctions.isElementDisplayed(cancelBtn,5,"Cancel Btn");
        commonFunctions.clickByCoordinates(360,416,"Close Button in Share Pop up");
        commonFunctions.clickElementIfDisplayed(back,5,"Back Button");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        Utils.logStepInfo(true,"checkSection = "+checkSection);
        Utils.logStepInfo(true,"isBookMarkOption = "+isBookMarkOption);
        Utils.logStepInfo(true,"isShareSheetDisplayed = "+isShareSheetDisplayed);
        return checkSection && isBookMarkOption && isShareSheetDisplayed;
    }

    @Override
    public boolean checkLoggedInUserCloseButtonOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Daily news subscribe button");
        commonFunctions.clickElementIfDisplayed(newsLetterCloseButton,5,"Close button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage;
    }

    @Override
    public boolean checkLoggedInUserBackButtonOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(dailyNewsCapsuleOption, 5, "Daily News Capsule");
        commonFunctions.clickElement(readNowInNewsLetter.get(1), 5, "Daily news Read Now button");
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed;
    }

    @Override
    public boolean checkTabOnXInSubscribeToNewsletterBehaviour() {
        boolean isScrollTillNewsletter =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isSubscribeButtonInFirstCard = commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter, 5, "Subscribe TButton in First Card");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Subscribe To Newsletter in First Card");
        commonFunctions.clickElementIfDisplayed(closeBtnInSubscribe,5,"Close button");
        boolean isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        if(!isHomePage){
            commonFunctions.clickByCoordinates(368,547);//getting Some BrowserStack Related error so clicking by Coordinate
            isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        }
        isHomePage &= commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter,5,"Subscribe To Newsletter in First Card");
        commonFunctions.killAppAndReLaunch();
        Utils.logStepInfo(true,"isScrollTillNewsletter = "+isScrollTillNewsletter);
        Utils.logStepInfo(true,"isSubscribeButtonInFirstCard = "+isSubscribeButtonInFirstCard);
        Utils.logStepInfo(true,"isHomePage = "+isHomePage);
        return isScrollTillNewsletter && isSubscribeButtonInFirstCard && isHomePage;
    }

    @Override
    public boolean checkPrivacyPolicyLinkOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter, 5, "Daily News Capsule");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Subscribe button");
        //No Xpath for Privacy policy link
        commonFunctions.tapElementWithCoOrdinates(300,816,"Click on Privacy Policy link");
        commonFunctions.dummyWait(3);
        boolean isHeaderDisplayed = commonFunctions.isElementDisplayed(privacyPolicyHeader,5,"Privacy Policy Header");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isHeaderDisplayed = "+isHeaderDisplayed);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed || isHeaderDisplayed;
    }

    @Override
    public boolean checkEmailAddressNewslettersTextOnDailyNewsCapsule() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter, 5, "Subscribe Button On First NewsLetter");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Subscribe button");
        boolean isTextMatched= commonFunctions.isElementDisplayed(enterEmailAddressNewsLetterText,10,"Email ID label text");
        commonFunctions.clickElementIfDisplayed(newsLetterCloseButton,5,"Close Newsletter popup");
        //Bypass click on close button
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isTextMatched = "+isTextMatched);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isTextMatched;
    }

    @Override
    public boolean checkEmailIsPreFilledTextOnDailyNewsCapsule(String email) {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(subscribeButtonOnFirstNewsLetter);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter, 5, "Subscribe Button in Daily News Capsule");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Subscribe button");
        boolean isEmailIdPrefilled = checkEmailIdPrefilled(email);
        commonFunctions.clickElementIfDisplayed(newsLetterCloseButton,5,"NewsLetter Close Button");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        Utils.logStepInfo(true,"isHTHomePageHighlighted = "+isHTHomePageHighlighted);
        Utils.logStepInfo(true,"isDailyNewsCapsuleDisplayed = "+isDailyNewsCapsuleDisplayed);
        Utils.logStepInfo(true,"isEmailIdPrefilled = "+isEmailIdPrefilled);
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isEmailIdPrefilled;
    }

    @Override
    public boolean checkTextOnNewsLetterForNonLoggedInUser() {
        boolean isHTHomePageHighlighted =checkNewsletterScroll(readNowInDailyNewsCapsule);
        boolean isDailyNewsCapsuleDisplayed = commonFunctions.isElementDisplayed(subscribeButtonOnFirstNewsLetter, 5, "Daily News Capsule");
        if(commonFunctions.getElementText(subscribeButtonOnFirstNewsLetter,5).equalsIgnoreCase("Subscribed")){
            Utils.logStepInfo(true,"it's already subscribed so firstly unsubscribe it....");
            commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter,5,"Subscribed Button for UnSubscribed it");
            commonFunctions.dummyWait(2);
        }
        commonFunctions.clickElement(subscribeButtonOnFirstNewsLetter, 5, "Subscribe button");
        boolean isHeadingMatched= commonFunctions.isElementDisplayed(nonLoggedInUserHeading,5, "Not Signed in user heading");
        commonFunctions.clickElementIfDisplayed(newsLetterCloseButton,5,"Close Newsletter popup");
        //Bypass click on close button
        commonFunctions.clickByCoordinates(200,384,"Click Outside popup");
        commonFunctions.scrollUp();
        commonFunctions.clickElementIfDisplayed(home,10,"Click on Home");
        boolean isHomePage = commonFunctions.isElementDisplayed(home, 5, "Home Button");
        return isHTHomePageHighlighted && isDailyNewsCapsuleDisplayed && isHomePage && isHeadingMatched;
    }

    @Override
    public boolean checkQuickReadsEntertainmentRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsEntertainmentTab, false, 0, home, topNewsSection,  home,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsAllTabRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsAllTab, false, 0, home, topNewsSection,  home,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsIndiaNewsTabRedirection() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsIndiaNewsTab, false, 0, home, topNewsSection,  home,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsBusinessTabRedirection() {
        return commonFunctionsMobile.getTabRedirectionInQuickreads(quickReadsBusinessTab,quickReadsWorldNewsTab,quickReadsAstrologyTab,home,quickReads,quickReadsMenu);
    }

    @Override
    public boolean checkQuickReadsSportsTabRedirection() {
        return commonFunctionsMobile.getTabRedirectionInQuickreads(quickReadsSportsTab,quickReadsWorldNewsTab,quickReadsAstrologyTab,home,quickReads,quickReadsMenu);
    }

    @Override
    public boolean checkAstrologySectionAfterLifestyleInQuickReads() {
        return commonFunctionsMobile.verifySectionNameAfterAnotherSectionName("Astrology","Lifestyle",listOfSectionsInQuickReads,quickReadsWorldNewsTab,quickReadsAstrologyTab,quickReadsAstrologyTab,home,quickReads,quickReadsMenu);
    }

    public boolean checkDailyDigestDisplayedOnExplore() {
        return commonFunctionsMobile.dailyDigestOptionDisplayedInExplore(home,exploreButton,dailyDigestSection);
    }

    @Override
    public boolean checkRedirectToCricketSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsCricketTab, true, 1, home, topNewsSection,  home,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkRedirectToCitiesSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsCitiesTab, true, 1, home, topNewsSection,  home,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkRedirectToWorldNewsSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsWorldNewsTab, true, 1, home, topNewsSection,  home,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkRedirectToLifeStyleSectionFromQuickReads() {
        return commonFunctionsMobile.redirectToSectionFromQuickReads(quickReadsLifestyleTab, true, 1, home, topNewsSection,  home,  quickReads,  quickReadsMenu);
    }

    @Override
    public boolean checkRedirectToAstrologyTabFromQuickRead() {
        return commonFunctionsMobile.getTabRedirectionInQuickreads(quickReadsAstrologyTab,quickReadsWorldNewsTab,quickReadsAstrologyTab,home,quickReads,quickReadsMenu);
    }

    @Override
    public boolean checkWorldNewsDisplayedAfterCitiesSectionInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("World News", "Cities", listOfSectionsInQuickReads, true, 1, home, topNewsSection, home, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkAllTabInQuickRead() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.clickElement(quickReadOnBottomNav,5,"Quick Reads");
        boolean isAllOptionDisplayed = commonFunctions.isElementDisplayed(quickReadsAllTab,5,"All Tab In Quick Reads");
        return isAllOptionDisplayed;
    }

    @Override
    public boolean checkLifeStyleSectionAfterWorldNewsInQuickReads() {
        return commonFunctionsMobile.verifySectionNameAfterAnotherSectionName("Lifestyle","World News",listOfSectionsInQuickReads,quickReadsWorldNewsTab,quickReadsLifestyleTab,quickReadsAstrologyTab,home,quickReads,quickReadsMenu);
    }

    @Override
    public boolean checkBusinessSectionAfterSportsInQuickReads() {
        return commonFunctionsMobile.verifySectionNameAfterAnotherSectionName("Business","Sports",listOfSectionsInQuickReads,quickReadsWorldNewsTab,quickReadsBusinessTab,quickReadsAstrologyTab,home,quickReads,quickReadsMenu);
    }

    @Override
    public boolean checkIndiaNewsSectionAfterAllTabInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("India News", "All", listOfSectionsInQuickReads, false, 1, home, topNewsSection, home, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkEntertainmentSectionAfterIndiaNewsInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Entertainment", "India News", listOfSectionsInQuickReads, false, 1, home, topNewsSection, home, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkCricketSectionAfterEntertainmentInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Cricket", "Entertainment", listOfSectionsInQuickReads, false, 1, home, topNewsSection, home, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkCitiesSectionAfterCricketInQuickReads() {
        return commonFunctionsMobile.verifySectionDisplayAfterSectionInQuickReads("Cities", "Cricket", listOfSectionsInQuickReads, false, 1, home, topNewsSection, home, quickReads, quickReadsMenu);
    }

    @Override
    public boolean checkSportsSectionAfterAstrologyInQuickReads() {
        return commonFunctionsMobile.verifySectionNameAfterAnotherSectionName("Sports","Astrology",listOfSectionsInQuickReads,quickReadsWorldNewsTab,quickReadsSportsTab,quickReadsAstrologyTab,home,quickReads,quickReadsMenu);
    }

    @Override
    public boolean checkSwipeUpAndAdAfter4StoriesInQuickReads() {
        boolean isAdDisplayed = checkFirstAdAfter4StoriesInQuickReadPage();
        boolean isSwipeUp = commonFunctions.isElementDisplayed(swipeUp,5,"Swipe Up text");
        return isAdDisplayed && isSwipeUp;
    }

    @Override
    public boolean checkOtherSectionBySwipingLeftToRightInQuickReads() {
        boolean isRedirectToIndiaNews = checkQuickReadsIndiaNewsTabRedirection();
        commonFunctions.swipeElementUsingTouchAction(72, 282, 340, 282);
        boolean isAllSection = commonFunctions.isElementDisplayed(quickReadsAllTab,5,quickReadsAllTab.getText()+ " tab");
        return isRedirectToIndiaNews && isAllSection;
    }

    @Override
    public boolean checkOtherSectionBySwipingRightToLeftInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        commonFunctions.swipeElementUsingTouchAction(360, 412, 72, 412);
        boolean isIndiaNewsSection = commonFunctions.isElementDisplayed(quickReadsIndiaNewsTab,5,quickReadsIndiaNewsTab.getText()+ " tab");
        return isRedirectToAllTab && isIndiaNewsSection;
    }

    @Override
    public boolean checkSwipeTopToBottomInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        String storyTitleBeforeSwipe = commonFunctions.getElementText(quickReadStoryTitle,5);
        commonFunctions.swipeElementUsingTouchAction(185, 696, 191, 183);
        commonFunctions.swipeElementUsingTouchAction(191, 183, 185, 696);
        String storyTitleAfterSwipe = commonFunctions.getElementText(quickReadStoryTitle,5);
        boolean isPreviousStoryAfterSwipe = storyTitleAfterSwipe.equalsIgnoreCase(storyTitleBeforeSwipe);
        return isRedirectToAllTab && isPreviousStoryAfterSwipe;
    }

    @Override
    public boolean checkSwipeBottomToTopInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        String storyTitleBeforeSwipe = commonFunctions.getElementText(quickReadStoryTitle,5);
        commonFunctions.swipeElementUsingTouchAction(185, 696, 191, 183);
        commonFunctions.dummyWait(5);
        String storyTitleAfterSwipe = commonFunctions.getElementText(quickReadStoryTitle,5);
        boolean isPreviousStoryAfterSwipe = commonFunctions.isElementDisplayed(quickReadStoryTitle,5,"QuickRead story title");
        return isRedirectToAllTab && isPreviousStoryAfterSwipe;
    }

    @Override
    public boolean checkSecondAdAfter8SwipeInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        for (int i =0; i<9; i++){
            commonFunctions.swipeElementUsingTouchAction(103,673,128,191);
        }
        boolean isSecondAd = (commonFunctions.isElementNotDisplayed(quickReadStoryTitle,5,"Quick Read Story Title"));
        return isSecondAd;
    }

    @Override
    public boolean checkSwipeUpOptionInFirstAdInQuickReads() {
        boolean isAdDisplayedAfter4Swipe = checkFirstAdAfter4StoriesInQuickReadPage();
        boolean isSwipeUpOptionDisplayed = commonFunctions.isElementDisplayed(swipeUp,5,"Swipe Up For Next Story");
        return isAdDisplayedAfter4Swipe & isSwipeUpOptionDisplayed;
    }

    @Override
    public boolean checkRedirectToStoryIfTabOnBlankSpaceInQuickReads() {
        boolean isRedirectToAllTab = checkQuickReadsAllTabRedirection();
        commonFunctions.tapElementWithCoOrdinates(192,701);
        commonFunctions.clickElement(skip,5,"Skip Btn");
        boolean isDisplayOpenedStory = commonFunctions.isElementDisplayed(storyHeadingText, 5, "Story Heading");
        commonFunctions.killAppAndReLaunch(notificationLater,4,"Later");
        return isRedirectToAllTab && isDisplayOpenedStory;
    }

    @Override
    public boolean checkEPaperOptionFromCricketHeader() {
        return commonFunctionsMobile.verifyEPaperOptionInSectionForIos(cricketHeader, home, ePaperButtonOnHeader);
    }

    @Override
    public boolean checkEPaperOptionFromPremiumHeader() {
        return commonFunctionsMobile.verifyEPaperOptionInSectionForIos(premium, home, ePaperButtonOnHeader);

    }

    @Override
    public boolean checkEPaperOptionFromExploreHeader() {
        return commonFunctionsMobile.verifyEPaperOptionInSectionForIos(exploreButton, home, ePaperButtonOnHeader);
    }

    @Override
    public boolean checkRedirectToDailyDigestFromExplore() {
        return navigateToDailyDigestSection();
    }

    @Override
    public boolean checkCityNewsInHomepageDisplayed() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        boolean isCityNewsDisplayed = commonFunctions.isElementDisplayed(cityNewsInHomepage,5,"City news");
        commonFunctions.killAppAndReLaunch();
        return isCityNewsDisplayed;
    }

    @Override
    public boolean checkListOfCitiesInCityNewsDisplayed() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        commonFunctions.isElementDisplayed(cityNewsInHomepage,5,"City news");
        boolean isListOfCitiesInCityNewsDisplayed = commonFunctions.isElementDisplayedOfListOfElements(listOfCitiesInCityNews,"List of cities in City News");
        commonFunctions.killAppAndReLaunch();
        return isListOfCitiesInCityNewsDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenUserTapsOnViewAllInCityNews() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        boolean isCityNewsDisplayed = commonFunctions.isElementDisplayed(cityNewsInHomepage,5,"City news");
        boolean isViewAllInCityNewsDisplayed = commonFunctions.clickElementIfDisplayed(viewAllInCityNews,5,"View all in City news");
        commonFunctions.clickElementIfDisplayed(gotItButtonOnCitiesPopUp,5,"Got it button");
        boolean isRedirectToCitySection = commonFunctions.isElementDisplayed(cities,5,"Cities Section");
        commonFunctions.killAppAndReLaunch();
        return isCityNewsDisplayed && isViewAllInCityNewsDisplayed && isRedirectToCitySection;
    }

    @Override
    public boolean checkSectionPageSelectedCityShownInHomePage() {
        boolean isCitiesSectionDisplayed = commonFunctionsMobile.checkTextOnCitiesSection(home,cities,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi City",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida City",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getRedirectionToSectionFromLeftToRight(topNewsSection,"Top news");
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        boolean isDelhiCityDisplayed = commonFunctions.isElementDisplayed(delhiSelectButton,5,"Delhi City in Homepage");
        boolean isNoidaCityDisplayed = commonFunctions.isElementDisplayed(noidaCitySelectButton,5,"Noida City in Homepage");
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Deselect Noida City",saveChangesButtonOnCitiesSection);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitiesSectionDisplayed && isCitySelected && isDelhiCityDisplayed && isNoidaCityDisplayed;
    }

    @Override
    public boolean checkHomePageSelectedCityShownInSectionPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.scrollToElementDown(cityNewsInHomepage);
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.clickElementIfDisplayed(gotItButtonOnCitiesPopUp,5,"Got it");
        boolean isCitySelected = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida City",saveChangesButtonOnCitiesSection);
        commonFunctionsMobile.getRedirectionToSectionFromRightToLeft(cities,"Cities");
        boolean isDelhiCityDisplayed = commonFunctions.isElementDisplayed(delhiSelectButton,5,"Delhi City in Section page");
        boolean isNoidaCityDisplayed = commonFunctions.isElementDisplayed(noidaCitySelectButton,5,"Noida City in Section page");
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Deselect Noida City",saveChangesButtonOnCitiesSection);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitySelected && isDelhiCityDisplayed && isNoidaCityDisplayed;
    }

    @Override
    public boolean checkAllL1SubMenuPresentAnd200StatusCode() {
        return false;
    }

    @Override
    public boolean checkAllL2SubMenuPresentAnd200StatusCode() {
        return false;
    }

    @Override
    public boolean checkFirstCollectionTopNews() {
        return false;
    }

    @Override
    public boolean checkHeaderTopAd() {
        return false;
    }

    @Override
    public boolean checkMoreOptionInL2() {
        return false;
    }

    @Override
    public boolean checkLHSAndRHSCollectionAndStories() {
        return false;
    }

    @Override
    public boolean checkAdInTopAndAfterCollectionInRHS() {
        return false;
    }

    @Override
    public boolean checkFooterAndData() {
        return false;
    }

    @Override
    public boolean checkAdsAfterEveryCollectionInMiddleLayer() {
        return false;
    }

    @Override
    public boolean checkL3SubMenuAnd200SuccessCode() {
        return false;
    }

    @Override
    public boolean checkAllTopicSuccessCode200() {
        return false;
    }
}

