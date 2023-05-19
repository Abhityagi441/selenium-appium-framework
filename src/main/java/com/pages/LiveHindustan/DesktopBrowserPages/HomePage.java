package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends CommonHomePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLH commonFunctionsWebLH;

    @FindBy(xpath = "//a[@title='साइन इन']")
    private static WebElement singInButton;

    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;

    @FindBy(id = "agree")
    private static WebElement continueButtonCookie;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//img[contains(@class,'logo-img')]")
    private static WebElement pageHeader;

    @FindBy(xpath = "//a[@class='big-news-title']")
    private static WebElement firstPramukhStory;

    @FindBy(xpath = "//div[@class='brnd-ads-new']")
    private static WebElement sponsoredLink;

    @FindBy(xpath = "//h3[@class='wdgt-subtitle3']")
    private static List<WebElement> allRHSWidgets;

    @FindBy(xpath = "//div[@class='wdgt-wrap']//h3/a")
    private static List<WebElement> allPramukhStoriesLink;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[2]//a")
    private static List<WebElement> manoranjanStoriesLink;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[6]//a")
    private static List<WebElement> photoGalleryStoriesLink;

    @FindBy(xpath = "//div[@id='widget-rs-4937']//a[@title='धर्म']")
    private static WebElement dharmStoriesSection;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='क्रिकेट']")
    private static WebElement cricketStoriesSection;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='देश']")
    private static WebElement nationalStoriesSection;

    @FindBy(xpath = "//div[@id='widget-rs-4950']//a[@title='बिजनेस']")
    private static WebElement businessSection;

    @FindBy(xpath = "//div[@id='widget-rs-4950']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> businessStoriesLink;

    @FindBy(xpath = "//div[@id='widget-rs-4979']//a[@title='करियर']")
    private static WebElement careerSection;

    @FindBy(xpath = "//div[@id='widget-rs-4979']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> careerStoriesLink;

    @FindBy(xpath = "//div[@id='widget-rs-4955']//a[@title='बिजनेस']")
    private static WebElement gadgetsSection;

    @FindBy(xpath = "//div[@id='widget-rs-4955']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> gadgetsStoriesLink;

    @FindBy(xpath = "//section[@id='widget-rs-5006']//a[@title='टॉप वीडियो']")
    private static WebElement topVideoSection;

    @FindBy(xpath = "//section[@id='widget-rs-5006']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> topVideoStoriesLink;

    @FindBy(xpath = "//div[@id='widget-rs-4962']//a[@title='ऑटो']")
    private static WebElement autoSection;

    @FindBy(xpath = "//div[@id='widget-rs-4962']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> autoStoriesLink;

    @FindBy(xpath = "(//h2[@class='wdgt-hdng']//span)[1]")
    private static WebElement chooseCitySection;

    @FindBy(xpath = "//div[@id='small-card-space']//a")
    private static List<WebElement> chooseCityStoriesLink;

    @FindBy(xpath = "//h2[@class='wdgt-hdng']//a[@title='लाइफस्टाइल']")
    private static WebElement lifeStyleSection;

    @FindBy(xpath = "//div[@id='common-lifestyle']//a")
    private static List<WebElement> lifeStyleStoriesLink;

    @FindBy(xpath = "//div[@class='wdgt-hdng']/h2/a[@title='हिन्दुस्तान टाइम्स ']")
    private static WebElement HTSection;

    @FindBy(xpath = "//div[@id='ht-top-news']//div/a")
    private static List<WebElement> HTStorySection;

    @FindBy(xpath = "//div[@class='wdgt-hdng']/h2/a[@title='लाइवमिंट ']")
    private static WebElement LMSection;

    @FindBy(xpath = "//div[@id='lm-top-news']//div/a")
    private static List<WebElement> LMStorySection;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='फोटो गैलरी']")
    private static WebElement photoGallerySection;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='मनोरंजन']")
    private static WebElement manoranjanSection;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[4]//a")
    private static List<WebElement> cricketStoriesLink;

    @FindBy(xpath = "//div[@id='widget-rs-4911']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> nationalStoriesLink;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[3]//a")
    private static List<WebElement> dharmStoriesLink;

    @FindBy(xpath = "//a[@title='हिन्दुस्तान पहल']")
    private static WebElement hindustanPahal;

    @FindBy(xpath = "//img[@class='mob-hide img']")
    private static WebElement hindustanPahalLink;

    @FindBy(xpath = "//div[@class='shiksha-bnr']/a")
    private static WebElement hindustanPahalUrl;

    @FindBy(xpath = "//a[@class='ctgry']")
    private static List<WebElement> allPramuckStoriesGeoName;

    @FindBy(className = "ftr-cpyrgt")
    private static WebElement homePageFooter;

    @FindBy(xpath = "//section[contains(@class,'lft-cont')]//h2/a")
    private static List<WebElement> homePageTopics;

    @FindBy(className = "bid-ads-top")
    private static WebElement topAd;

    @FindBy(xpath = "//a[@id='srch-lnk']")
    private static WebElement serachButton;

    @FindBy(xpath = "//a[@title='ई-पेपर']")
    private static WebElement ePaperLink;

    @FindBy(xpath = "//section[@id='sehr-chune']/h3")
    private static WebElement sheharChuneSection;

    @FindBy(xpath = "//a[@id='seher-chune']")
    private static WebElement sheharChuneLink;

    @FindBy(xpath = "//input[@id='search-field']")
    private static WebElement searchField;

    @FindBy(xpath = "//a[@id='srch-lnk']")
    private static WebElement searchLink;

    @FindBy(xpath = "//button[@id='srch-btn']")
    private static WebElement searchButton;

    @FindBy(xpath = "//div[@class='crsel']")
    private static WebElement searchResultsSection;

    @FindBy(xpath = "//a[contains(@class,'card-sm')]")
    private static WebElement resultsInKabrePhotoVideo;

    @FindBy(xpath = "//section[@id='widget-rs-1349046']//a[@title='न्यूज़ ब्रीफ']")
    private static WebElement newsBriefSection;

    @FindBy(xpath = "//a[@class='nb-cta-sld ']//parent::div//following-sibling::div")
    private static List<WebElement> newsBriefInactiveElement;

    @FindBy(xpath = "//a[@class='nb-cta-sld ']//parent::div//following-sibling::div//a")
    private static List<WebElement> newsBriefStoriesLink;

    @FindBy(xpath = "(//button[@type='button']//i[@class='icon-arrw'])[4]")
    private static WebElement newsBriefNextArrow;

    @FindBy(xpath = "(//h2[@class='wdgt-hdng'])[5]")
    private static WebElement rasifalSection;

    @FindBy(xpath = "//div[@id='common-rashifal']//section[@class='rashifal']/a")
    private static List<WebElement> rasifalStorySection;

    @FindBy(xpath = "//div[@class='crsel']//a")
    private static List<WebElement> kabrePhotoVideo;

    @FindBy(xpath = "//span[@id='cls-sehr']")
    private static WebElement closeSheharChune;

    @FindBy(className = "closebtn btn")
    private static WebElement googlePopUpCloseButton;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;

    @FindBy(xpath = "//span[@class='ns-uh6dc-e-18']")
    private static WebElement adDisplay;

    @FindBy(xpath = "(//div[@class='ft-sctn'])[4]//a")
    private static List<WebElement> partnerSites;

    @FindBy(xpath = "//div[contains(@class,'wdgt-nav')]//a")
    private static List<WebElement> pageSubMenuTitles;

    @FindBy(xpath = "//a[text()='टॉप वीडियो']")
    private static WebElement videoLinkHomePage;

    @FindBy(xpath = "//p[@class='moregallery']")
    private static WebElement aanyaGalleryIcon;

    @FindBy(xpath = "(//i[@class='epndicon'])[1]")
    private static WebElement expandIcon;

    @FindBy(xpath = "//div[@id='anya-gallery']/span")
    private static WebElement aanyaGalleryCloseButton;

    @FindBy(xpath = "//a[@id='nxt-btn']")
    private static WebElement aanyaGalleryButton;

    @FindBy(xpath = "//button[@class='owl-prev']")
    private static WebElement prevButtonSlider;

    @FindBy(xpath = "//button[@class='owl-next']")
    private static WebElement nextButtonSlider;

    @FindBy(xpath = "//div[@class='wdgt-lft card-lg-2']//a[2]")
    private static List<WebElement> photoPageMainTitles;

    @FindBy(xpath = "//div[@class='wdgt-lft']")
    private static List<WebElement> videoPageMainTitles;

    @FindBy(xpath = "//i[@class='epndicon']")
    private static List<WebElement> expandIconsOnPhotoPage;

    @FindBy(xpath = "//a[contains(@class,'shre-icn twt-icn')]")
    private static WebElement twitterIcon;

    @FindBy(xpath = "//a[contains(@class,'shre-icn fb-icn')]")
    private static WebElement facebookIcon;

    @FindBy(xpath = "//a[contains(@class,'gogle-follow shre-icn')]")
    private static WebElement humeFollowKarenIcon;

    @FindBy(xpath = "//div[@class='brd-crum']/a")
    private static List<WebElement> breadCrumbCurrentPage;

    @FindBy(xpath = "//div[@class='tags']/a")
    private static List<WebElement> currentPageStoryRelatedWidgets;

    @FindBy(xpath = "//div[@class='vd-cnt']/h1")
    private static WebElement storyHeadLine;

    @FindBy(xpath = "//div[contains(@class,'main-wdgt glry-bg')]/h2/a")
    private static WebElement currnetStoryRelatedWidget;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(xpath = "//h2[@class='wdgt-hdng']")
    private static List<WebElement> widgetsHeadings;

    @FindBy(xpath = "//div[@id='home-de']//h3")
    private static List<WebElement> widgetsHeadingsAllStories;

    @FindBy(xpath = "(//div[@id='text-player'])[1]")
    private static WebElement firstTextToSpeechBox;

    @FindBy(xpath = "(//div[@id='play-btn'])[1]")
    private static WebElement playAndPauseControl;

    @FindBy(xpath = "//div[@id='first-story-body']")
    private static WebElement firstStoryBody;

    @FindBy(xpath = "(//div[@class='play-container'])[1]/div")
    private static WebElement playAndPauseConfirmation;

    @FindBy(xpath = "//div[@id='top-ad']")
    private static WebElement topMostAd;

    @FindBy(xpath = "(//div[@class='adclass'])[15]")
    private static WebElement lastAd;

    @FindBy(xpath = "//div[contains(@class,'brd-crum mrgn-lr')]")
    private static WebElement pageBreadcrumb;

    @FindBy(xpath = "//div[contains(@class,'adclass rhsad')]")
    private static WebElement firstRHSAdOnHomePage;

    @FindBy(xpath = "//div[@class='bid-ads']/parent::div/following-sibling::section")
    private static List<WebElement> adBetweenWidgets;

    @FindBy(xpath = "//span[@id='prev-arrow']/parent::div")
    private static WebElement previousArrowButtonApkeLiaKhas;
    @FindBy(xpath = "//span[@id='prev-arrow']")
    private static WebElement prevButton;
    @FindBy(xpath = "//span[@id='next-arrow']")
    private static WebElement nextArrowButtonApkeLiaKhas;
    @FindBy(xpath = "//div[@id='home-de']")
    private static WebElement apkeLiaKhashSwipSection;
    @FindBy(xpath = "//span[@class='zoom-wrap']/following-sibling::h3")
    private static List<WebElement> allStoriesInApkeLiaKhas;

    @FindBy(xpath = "//div[@class='wdgt-hdng']")
    private static List<WebElement> allWidgetsOnHomePage;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//h2/a")
    private static List<WebElement> allWidgetsLinksOnHomePage;
    @FindBy(xpath = "//nav[contains(@class,'crsel')]//a")
    private static List<WebElement> allSubOptionOnDharamPage;
    @FindBy(xpath = "//div[contains(@class,'rashi tabs crsel')]//a")
    private static List<WebElement> allTabsOnAnkRashiPage;
    @FindBy(xpath = "//span[@class='brd-crum-last']")
    private static WebElement breadcrumbLastWord;

    @FindBy(xpath = "//div[@class='adclass']")
    private static List<WebElement> adsOnCurrentPage;

    @FindBy(xpath = "//div[contains(@class,'rashifal-wrap common-bg clearfix')]//a[@class='read-more']")
    private static List<WebElement> puraPadheyLinks;

    @FindBy(xpath = "//div[@id='rashi-crsl']//a")
    private static List<WebElement> rashiFalLinks;

    @FindBy(xpath = "//div[@id='hsh-hm']//div//div//div//a")
    private static List<WebElement> topicLinks;

    @FindBy(xpath = "//div[contains(@class,'adclass rhsad')]")
    private static WebElement allRHSWidgetsOnHomePage;
    @FindBy(xpath = "//div[@class='theiaStickySidebar']/div[@class='adclass']")
    private static List<WebElement> adsAfterFirstOnRHS;
    @FindBy(xpath = "//span[@class='livblg-btn']/following-sibling::a")
    private static List<WebElement> liveBlogButtonStory;

    @FindBy(xpath = "//div[@class='main-wdgt listing lvbloglsting']/a")
    private static List<WebElement> liveStory;

    @FindBy(xpath = "//div[@class='lv-hd']/p")
    private static WebElement liveUpdateOnStoryDetailPage;
    @FindBy(xpath = "//div[@class='lv-hd']//i")
    private static WebElement refreshButtonOnLiveBlogStoryDetailPage;

    @FindBy(xpath = "//h2//a[@title='आपके लिए खास']")
    private static WebElement apkeLiaKhasTitle;

    @FindBy(xpath = "//div[contains(@class, 'adclass')]/div/div/iframe")
    private static List<WebElement> addRhsLoading;

    @FindBy(xpath = "//div[@class='articles']//h3")
    private static List<WebElement> storyOnStoriesListingPage;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLH=CommonFunctionsWebLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    private static final String sheharChuneHindi = "शहर चुनें";
    private static final String signInHindi = "साइन इन";
    private static final String videoHindi = "वीडियो";
    private static final String cricketHindi = "क्रिकेट";
    private static final String photoHindi = "फोटो";
    private static final String entertainmentHindi = "मनोरंजन";
    private static final String homeHindi = "होम";
    private static final String nationHindi = "देश";
    private static final String stateHindi = "राज्य";
    private static final String gadgetsHindi = "गैजेट्स";
    private static final String dharmInHindi = "धर्म";


    @Override
    public boolean checkHeaderDisplay() {
        commonFunctions.navigateToURL(globalVars.getURL());
        return commonFunctions.isElementDisplayed(pageHeader, 10, commonFunctions.getElementText(pageHeader));
    }

    @Override
    public boolean checkHomePageRHSWidgets() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(topAd, 10, "Top Ad on Homepage");
        return isAllElementsVisible(allRHSWidgets);
    }

    @Override
    public boolean checkPramukhKhabreWidget() {
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        int pramukhStoriesSize = allPramukhStoriesLink.size();
        commonFunctions.scrollToViewElement(sponsoredLink, "last pramukh story", 10);
        if(commonFunctions.isElementDisplayed(sponsoredLink, 10, "sponsored link")){
            pramukhStoriesSize = pramukhStoriesSize + 1;
        }
        isAllElementClickableTrue = isAllElementClickableAndReturns200(allPramukhStoriesLink);
        return pramukhStoriesSize == 10 && isAllElementClickableTrue;

    }
    public boolean isAllElementClickableAndReturns200(List<WebElement> allLinks){
        boolean isUrlClickable = true;
        boolean isLinkReturn200=true;
        for (int i = 0; i <= allLinks.size() - 1; i++) {
            commonFunctions.moveToElementWithActions(allLinks.get(i),10,"links");
            isUrlClickable &= commonFunctions.clickElementWithJS(allLinks.get(i), 10,commonFunctions.getElementText(allLinks.get(i)));
            commonFunctions.dummyWait(5);
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.dummyWait(5);
        }
        return  isUrlClickable && isLinkReturn200;
    }
    @Override
    public boolean checkScrollOnHomePage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        return isAllElementsVisible(homePageTopics);
    }

    @Override
    public boolean checkTopNevBar() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        boolean isSheharChuneClickable = commonFunctions.isElementClickable(sheharChuneLink, 10, "शहर चुनें");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(sheharChuneLink, 10, "शहर चुनें");
        commonFunctions.dummyWait(5);
        boolean isSheharChuneSectionDisplay = commonFunctions.isElementDisplayed(sheharChuneSection, 20, sheharChuneSection.getText().trim());
        commonFunctions.clickElement(closeSheharChune, 10, "Close " + sheharChuneHindi + " section button");
        boolean isSearchButtonClickable = commonFunctions.isElementClickable(serachButton, 10, "Search button on Home page");
        commonFunctions.clickElement(serachButton, 10, "Search button  on Home page");
        boolean isSearchButtonWorked = commonFunctions.isElementDisplayed(searchField, 10, "यहाँ लिखें");
        commonFunctions.dummyWait(10);
        boolean isEpaperLinkClickable = commonFunctions.isElementClickable(ePaperLink, 10, "ई-पेपर button");
        commonFunctions.clickElement(ePaperLink, 10, "ई-पेपर button");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean isCurrentUrlOfEpaper = commonFunctions.getCurrentURL().contains("epaper");
        return isSearchButtonClickable && isSearchButtonWorked && isSheharChuneClickable && isSheharChuneSectionDisplay && isEpaperLinkClickable && isCurrentUrlOfEpaper;
    }

    @Override
    public boolean checkTopMenuBar() {
        commonFunctions.navigateToURL(globalVars.getURL());
        return isAllElementsClickableAndNavigatedToCorrectURL();
    }

    @Override
    public boolean checkWidgetOnHomePage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollToElementView(partnerSites.get(1), 10, "Partner site near footer");
        clickElementWithGivenText(partnerSites, "HT Auto");
        boolean isAutoPageOpened = openPageWithSwitchWindow("auto");
        clickElementWithGivenText(partnerSites, "HT Tech");
        boolean isTechPageOpened = openPageWithSwitchWindow("tech");
        clickElementWithGivenText(partnerSites, "Hindustan Times");
        boolean isHindustanPageOpened = openPageWithSwitchWindow("hindustantimes");
        clickElementWithGivenText(partnerSites, "Mint");
        boolean isLiveMintpageOpened = openPageWithSwitchWindow("livemint");
        clickElementWithGivenText(partnerSites, "Healthshots");
        boolean isHealthShotsOpened = openPageWithSwitchWindow("healthshots");


        return isAutoPageOpened && isHindustanPageOpened && isTechPageOpened && isHealthShotsOpened && isLiveMintpageOpened;
    }

    @Override
    public boolean checkApkeLiaKhasWidgetsAndStoryClickable() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isApkeLiaKhasVisible = commonFunctions.scrollToElementView(widgetsHeadings.get(0), 10, "आपके लिए खास widgets");
        boolean isAllStoriesClickable = isAllElementClickable(widgetsHeadingsAllStories);
        return isApkeLiaKhasVisible && isAllStoriesClickable;
    }

    @Override
    public boolean checkTextToSpeechPlayAndPauseFunctionality() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, commonFunctions.getElementText(firstPramukhStory, 5));
        commonFunctions.waitForPageToLoad();
        commonFunctions.moveToElementWithActions(firstTextToSpeechBox, 20, "First Text to Speech box");
        boolean isPlayTextContains = commonFunctions.getAttributeValue(playAndPauseConfirmation, 10, "class").split(" ")[1].contains("play");
        commonFunctions.clickElementWithJS(playAndPauseControl,10,"Play button");
        boolean isPauseTextContains = commonFunctions.getAttributeValue(playAndPauseConfirmation, 10, "class").split(" ")[1].contains("pause");

        return isPlayTextContains && isPauseTextContains;
    }

    @Override
    public boolean checkTopAdAndBottomAdLoadProperly() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isTopAdLoadProperly = commonFunctions.isElementDisplayed(topMostAd, 20, "Top most ad on Home Page");
        commonFunctions.scrollToBottom();
        boolean isLastAdLoadProperly = commonFunctions.isElementDisplayed(lastAd, 10, "Last visible Ad on bottom of the home page");
        return isTopAdLoadProperly && isLastAdLoadProperly;
    }

    @Override
    public boolean checkAllPageAreLoadingProperly() {
        boolean isAllPageAreLoadingProperlyTrue = true;
        commonFunctions.navigateToURL(globalVars.getURL());

        clickElementWithGivenText(topMenuOptions, homeHindi);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getAttributeValue(getSelectedElement(topMenuOptions, homeHindi), 10, "class").contains("active");

        clickElementWithGivenText(topMenuOptions, videoHindi);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(videoHindi);

        clickElementWithGivenText(topMenuOptions, entertainmentHindi);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(entertainmentHindi);

        clickElementWithGivenText(topMenuOptions, photoHindi);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(photoHindi);

        clickElementWithGivenText(topMenuOptions, nationHindi);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(nationHindi);

        clickElementWithGivenText(topMenuOptions, stateHindi);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(stateHindi);

        clickElementWithGivenText(topMenuOptions, gadgetsHindi);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(gadgetsHindi);

        return isAllPageAreLoadingProperlyTrue;
    }

    @Override
    public boolean checkPhotoGalleryLandingPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        boolean isLandingToPhotoGalleryCorret = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        return commonFunctions.getElementText(pageBreadcrumb, 10).contains(photoHindi) && isLandingToPhotoGalleryCorret;
    }

    @Override
    public boolean checkRHSAdLoadProperly() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        return commonFunctions.isElementDisplayed(firstRHSAdOnHomePage, 10, "First RHS Ad on Home page");
    }

    @Override
    public boolean checkBetweenWidgetsAdsLoad() {
        commonFunctions.navigateToURL(globalVars.getURL());
        return isAllElementsVisible(adBetweenWidgets);
    }

    @Override
    public boolean checkRFUApkeLiaKhasWidget() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollToElementView(apkeLiaKhasTitle,10,"आपके लिए खास");
        commonFunctions.scrollToViewElement(nextArrowButtonApkeLiaKhas,"Next button for Apke lia Khas widget", 10);
        commonFunctions.moveToElementToClick(nextArrowButtonApkeLiaKhas);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToViewElement(apkeLiaKhasTitle,"Prev button for Apke lia Khas widget", 10);
        commonFunctions.moveToElementToClick(prevButton);
        commonFunctions.moveToElementToClick(prevButton);
        commonFunctions.dummyWait(5);
        boolean isPreviousButtonDisabled = commonFunctions.getAttributeValue(previousArrowButtonApkeLiaKhas, 15, "class").contains("prev-disable");
        commonFunctions.scrollToViewElement(apkeLiaKhasTitle,"Prev button for Apke lia Khas widget", 10);
        commonFunctions.moveToElementToClick(nextArrowButtonApkeLiaKhas);
        commonFunctions.dummyWait(5);
        boolean isPreviousButtonEnabled = commonFunctions.getAttributeValue(apkeLiaKhashSwipSection, 15, "class").contains("prev-enable");
        return isPreviousButtonDisabled && isPreviousButtonEnabled;
    }

    @Override
    public boolean checkHomePageRFUWidgets() {
        boolean isApkeLiaKhasDisplayTrue = checkRFUApkeLiaKhasWidget();
        boolean isAllStoryInApkeLiaKhasClickable = isAllElementClickable(allStoriesInApkeLiaKhas);
        return isApkeLiaKhasDisplayTrue && isAllStoryInApkeLiaKhasClickable;
    }

    @Override
    public boolean checkNumerologyPage() {
        boolean isLandingOnAstrologyPageTrue = isLandingPageIsAstrology();
        clickElementWithGivenText(allSubOptionOnDharamPage, "अंक राशि");
        boolean isUrlChangesTrue = commonFunctions.getCurrentURL().contains("/astrology/numerology/");
        boolean isLandingOnToNumerologyPageTrue = commonFunctions.getElementText(breadcrumbLastWord, 5).contains("अंक राशि");
        boolean isAllTabsOnNumerologyPageClickable = isAllElementClickable(allTabsOnAnkRashiPage);
        return isLandingOnToNumerologyPageTrue && isUrlChangesTrue && isLandingOnAstrologyPageTrue && isAllTabsOnNumerologyPageClickable;
    }

    @Override
    public boolean checkAstrologyLandingPageSubMenu() {
        boolean isLandingOnToDharamPageTrue = isLandingPageIsAstrology();
        boolean isAllSubMenuClickable = isAllElementClickable(allSubOptionOnDharamPage);
        boolean isAllLandingPageTrue = isAllRelatedLandingPageTrue(allSubOptionOnDharamPage);
        return isAllSubMenuClickable && isLandingOnToDharamPageTrue && isAllLandingPageTrue;
    }

    @Override
    public boolean checkRHSWidgets() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.moveToElementWithActions(allRHSWidgetsOnHomePage, 10, "First Ad on the home page");
        boolean isFirstAdDisplay = commonFunctions.isElementDisplayed(allRHSWidgetsOnHomePage, 10, "First Ad on the home page");
        boolean isAllRHSWidgetsAreDisplay = isAllElementClickable(allRHSWidgets);
        boolean isAdsAfterFirstOneDisplay = isAllElementClickable(adsAfterFirstOnRHS);

        return isFirstAdDisplay && isAllRHSWidgetsAreDisplay && isAdsAfterFirstOneDisplay;
    }

    @Override
    public boolean checkLiveBlogButtonOnHome() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        String storyTitleWithLiveBlog = commonFunctions.getAttributeValue(liveBlogButtonStory.get(0), 5, "title");
        commonFunctions.clickElement(liveBlogButtonStory.get(0), 10, storyTitleWithLiveBlog);
        return commonFunctions.getElementText(breadcrumbLastWord, 10).equals(storyTitleWithLiveBlog);
    }

    @Override
    public boolean checkRefreshButtonOnLiveBlogDetailPage() {
        commonFunctions.navigateToURL(globalVars.getURL()+"/"+"live-blog");
        commonFunctions.waitForPageLoading();
        String storyTitleWithLiveBlog = commonFunctions.getAttributeValue(liveStory.get(0), 5, "title");
        commonFunctions.clickElement(liveStory.get(0), 10, storyTitleWithLiveBlog);
        commonFunctions.clickElement(refreshButtonOnLiveBlogStoryDetailPage, 10, "Refresh button for story detail page");
        boolean isLiveBlogStillVisible = commonFunctions.isElementDisplayed(liveUpdateOnStoryDetailPage, 10, "Live Blog Icon in story detail page");
        boolean isRefreshButtonWorks = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        return isLiveBlogStillVisible && isRefreshButtonWorks;
    }

    @Override
    public boolean checkLivBlogLiveUpdateButtonOnDetailPage() {
        commonFunctions.navigateToURL(globalVars.getURL()+"/"+"live-blog");
        commonFunctions.waitForPageLoading();
        String storyTitleWithLiveBlog = commonFunctions.getAttributeValue(liveStory.get(0), 5, "title");
        commonFunctions.clickElement(liveStory.get(0), 10, storyTitleWithLiveBlog);
        commonFunctions.waitForPageLoading();
        return commonFunctions.isElementDisplayed(liveUpdateOnStoryDetailPage, 10, commonFunctions.getElementText(liveUpdateOnStoryDetailPage,5));
    }

    @Override
    public boolean checkWebStoryDetailPage() {
        return false;
    }

    @Override
    public boolean checkAmpHomePage() {
        return false;
    }

    @Override
    public boolean checkAllHamburgerLinksFunctionality() {
        return false;
    }
    @Override
    public  boolean checkHomePageRhsAdLoad(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(topAd, 10, "Top Ad on Homepage");
        return isHomePageRhsAdLoad(addRhsLoading);
    }

    @Override
    public boolean checkMwebHomePageRfuWidget(){
        return false;
    }

    @Override
    public boolean checkMwebVideoLandingPage(){
        return false;
    }

    public boolean isAllRelatedLandingPageTrue(List<WebElement> elementList) {
        String rashifalUrl = commonFunctions.getCurrentURL();
        String breadcrumbText = null;
        boolean isAllLandingPageAreRelated = true;
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            breadcrumbText = commonFunctions.getElementText(elementList.get(i), 5);
              commonFunctions.clickElement(elementList.get(i), 10, breadcrumbText);
            if (!breadcrumbText.equals("विशेष दिवस"))
                isAllLandingPageAreRelated &= commonFunctions.getElementText(pageBreadcrumb, 5).contains(breadcrumbText);
            commonFunctions.navigateToURL(rashifalUrl);
        }
        return isAllLandingPageAreRelated;
    }

    public boolean isLandingPageIsAstrology() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(allWidgetsLinksOnHomePage, dharmInHindi);
        boolean isUrlChangesTrue = commonFunctions.getCurrentURL().contains("/astrology/");
        boolean isLandingOnToDharamPageTrue = commonFunctions.getElementText(pageBreadcrumb, 5).contains(dharmInHindi);
        return isLandingOnToDharamPageTrue && isUrlChangesTrue;
    }

    public WebElement getSelectedElement(List<WebElement> elementList, String text) {
        for (WebElement ele : elementList) {
            if (commonFunctions.getElementText(ele, 10).contains(text)) {
                return ele;
            }
        }
        return null;
    }

    public void clickNextSliderButtonTillNotDisabled() {
        while (!commonFunctions.isElementDisplayed(aanyaGalleryButton, 10, "class")) {
            commonFunctions.clickElement(nextButtonSlider, 10);
        }
    }

    public boolean openPageWithSwitchWindow(String text) {
        boolean isOpenPageWithSwitchWindow;
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isOpenPageWithSwitchWindow = commonFunctions.getCurrentURL().contains(text);
        commonFunctions.switchToWindow(windowsList.get(0));
        return isOpenPageWithSwitchWindow;
    }

    public boolean isAllElementsVisible(List<WebElement> elementList) {
        boolean isAllElementDisplay = false;
        for (int i = 0; i < elementList.size(); i++) {
            if (commonFunctions.scrollToElementView(elementList.get(i), 10, "Element")) {
                Utils.logStepInfo(elementList.get(i).getText() + " display successfully.");
                isAllElementDisplay = true;
            } else {
                isAllElementDisplay = false;
            }
        }
        return isAllElementDisplay;
    }

    public boolean isAllElementClickable(List<WebElement> elementList) {
        boolean isAllelementClickableTrue = true;
        for (WebElement ele : elementList) {
            commonFunctions.scrollToViewElement(ele, commonFunctions.getElementText(ele, 5), 10);
            if (commonFunctions.isElementClickable(ele, 10, commonFunctions.getElementText(ele, 5))) {
                isAllelementClickableTrue &= true;
            } else {
                isAllelementClickableTrue &= false;
            }
        }
        return isAllelementClickableTrue;
    }

    public boolean isAllElementsClickableAndNavigatedToCorrectURL() {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200=true;
                for(int i=0;i<=topMenuOptions.size()-1;i++){
                    String url=commonFunctions.getAttributeValue(topMenuOptions.get(i),10,"href");
                    String menuTitle=topMenuOptions.get(i).getText();
                    isUrlClickable &= commonFunctions.clickElementWithJS(topMenuOptions.get(i),10,menuTitle +" menu link");
                    commonFunctions.dummyWait(5);
                    isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                    if(!(commonFunctions.getCurrentURL().contains("google_vignette"))){
                        isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
                    }
                }

        return isUrlClickable && isLinkReturn200 && isUrlMatches;
    }

    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElement(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public boolean checkIfListContainsText(List<WebElement> elementList, String expectedText) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedText)) {
                return true;
            }
        }
        return false;
    }

    public boolean isHomePageRhsAdLoad(List<WebElement> elementList){
        boolean flag = false;
        for(int i=0;i<elementList.size();i++){
            if(elementList.get(i).getAttribute("data-load-complete").trim().equalsIgnoreCase("true")){
                flag = true;
            }else{
                flag = false;
                break;
            }
        }
        
        return flag;
    }

    @Override
    public  boolean checkNewsBriefOnAmp(){
        return false;
    }

    @Override
    public boolean checkIosAmpHomePage(){
        return false;
    }

    @Override
    public boolean checkSeoContentOnThePages(){
        return false;
    }
    @Override
    public boolean checkHomePageAndWidgets()
    {return false;}

    @Override
    public boolean checkAllTopicAreGiving200StatusCode(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return isAllElementClickableAndReturns200(topicLinks);
    }

    @Override
    public boolean checkEntertainmentWidgetIsHaving6StoriesAndStatusIs200(){
        int entertainmentSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(manoranjanSection,manoranjanStoriesLink,entertainmentSize);
    }

    @Override
    public boolean checkPhotoGalleryWidgetIsHaving6StoriesAndStatusIs200(){
        int photoSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(photoGallerySection,photoGalleryStoriesLink,photoSize);
    }

    @Override
    public boolean checkHindustanPahalLinkWidgetRedirectionAndStatusCodeIs200(){
        boolean isHindustanSectionDisplayed;
        boolean isHindustanSectionClickable;
        boolean isURLMatched;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(hindustanPahal,"hindustan section");
        String url=commonFunctions.getAttributeValue(hindustanPahalUrl,10,"href");
        isHindustanSectionDisplayed=commonFunctions.isElementDisplayed(hindustanPahal,10,"hindustan section");
        isHindustanSectionClickable = commonFunctions.clickElement(hindustanPahalLink,10,"hindustan link");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isURLMatched=commonFunctions.getCurrentURL().equals(url);
        System.out.println(commonFunctions.getCurrentURL());
        return isHindustanSectionDisplayed && isHindustanSectionClickable && isURLMatched;
    }

    @Override
    public boolean checkDharmWidgetIsHaving6StoriesAndStatusIs200(){
        int dharmSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(dharmStoriesSection,dharmStoriesLink,dharmSize);
    }

    @Override
    public boolean checkCricketWidgetIsHaving6StoriesAndStatusIs200(){
        int cricketSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(cricketStoriesSection,cricketStoriesLink,cricketSize);
    }

    @Override
    public boolean checkNationalWidgetIsHaving6StoriesAndStatusIs200(){
        int nationalSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(nationalStoriesSection,nationalStoriesLink,nationalSize);
    }

    @Override
    public boolean checkInfiniteScrollingOnListingPage() {
        boolean isLandingOnRastreeyPageTrue = landingOnRashtreeyKhabreyPage();
        boolean isPageStoryListingTrue = isScrollingTill20StoryChangeUrl();
        return isLandingOnRastreeyPageTrue && isPageStoryListingTrue;
    }

    public boolean landingOnRashtreeyKhabreyPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, "देश");
        clickElementWithGivenText(allSubOptionOnDharamPage, "राष्ट्रीय खबरें");
        return commonFunctions.getCurrentURL().contains("/national");
    }

    public boolean isScrollingTill20StoryChangeUrl() {
        boolean isPageStoryListingTrue = false;
        String currentUrl = commonFunctions.getCurrentURL();
        for (int i = 0; i < storyOnStoriesListingPage.size(); i++) {
            commonFunctions.moveToElementWithActions(storyOnStoriesListingPage.get(i), 10, commonFunctions.getElementText(storyOnStoriesListingPage.get(i)));
            if (!commonFunctions.getCurrentURL().equals(currentUrl)) {
                isPageStoryListingTrue = true;
                break;
            }
        }
        return isPageStoryListingTrue;
    }

    @Override
    public boolean checkBusinessWidgetIsHaving6StoriesAndStatusIs200(){
        int businessStorySize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(businessSection,businessStoriesLink,businessStorySize);
    }

    @Override
    public boolean checkCareerWidgetIsHaving6StoriesAndStatusIs200(){
        int careerStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(careerSection,careerStoriesLink,careerStoriesSize);
    }

    @Override
    public boolean checkGadgetsWidgetIsHaving6StoriesAndStatusIs200(){
        int gadgetsStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(gadgetsSection,gadgetsStoriesLink,gadgetsStoriesSize);
    }

    @Override
    public boolean checkTopVideoWidgetIsHaving5StoriesAndStatusIs200(){
        int topVideoStoriesSize=5;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(topVideoSection,topVideoStoriesLink,topVideoStoriesSize);
    }

    @Override
    public boolean checkAutoWidgetIsHaving6StoriesAndStatusIs200(){
        int autoStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(autoSection,autoStoriesLink,autoStoriesSize);
    }

    @Override
    public boolean checkApnaSheherChuneWidgetIsHaving6StoriesAndStatusIs200(){
        int chooseCityStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(chooseCitySection,chooseCityStoriesLink,chooseCityStoriesSize);
    }

    @Override
    public boolean checkLifestyleWidgetIsHaving6StoriesAndStatusIs200(){
        int lifeStyleStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(lifeStyleSection,lifeStyleStoriesLink,lifeStyleStoriesSize);
    }

    @Override
    public boolean checkHTWidgetIsHaving6StoriesAndStatusIs200(){
        int HTStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(HTSection,HTStorySection,HTStoriesSize);
    }

    @Override
    public boolean checkLMWidgetIsHaving6StoriesAndStatusIs200(){
        int LMStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(LMSection,LMStorySection,LMStoriesSize);
    }

    @Override
    public boolean checkKhabrePhotoAndVideoShouldHaveNewsListedUnderItOnSearching(String searchKeyword,String section1,String section2,String section3) {
        boolean searchResult = true;
        String[] resultsSectionName = {section1, section2, section3};
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        boolean isSearchLinkClickable = commonFunctions.clickElement(searchLink, 10, "search");
        commonFunctions.isElementDisplayed(searchField, 10, "यहाँ लिखें");
        boolean isSearchFieldDisplayed = commonFunctions.clickElement(searchField, 10, "search");
        commonFunctions.sendKey(searchField, searchKeyword, 10);
        boolean isSearchButtonClickable = commonFunctions.clickElement(searchButton, 10, "search button");
        commonFunctions.moveToElementWithActions(searchResultsSection, 10, "search results");
        for (int i = 0; i <= kabrePhotoVideo.size() - 1; i++) {
            commonFunctions.scrollToElement(kabrePhotoVideo.get(i), "results");
            commonFunctions.clickElementWithJS(kabrePhotoVideo.get(i), 10, "top results");
            commonFunctions.dummyWait(5);
            String sectionName = commonFunctions.getAttributeValue(kabrePhotoVideo.get(i), 10, "title");
            if (sectionName.equals(resultsSectionName[i]))
                searchResult &= commonFunctions.isElementDisplayed(resultsInKabrePhotoVideo, 10, "results");
            else
                searchResult = false;
        }
        return isSearchLinkClickable && isSearchFieldDisplayed && isSearchButtonClickable && searchResult;
    }

    @Override
    public boolean checkNewsBriefWidgetIsHaving7StoriesAndStatusIs200(){
        boolean isAllElementsClickable=false;
        int newsBriefStoriesSize = 7;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        if (commonFunctions.isElementDisplayed(newsBriefSection, 10, "news brief section")){
            isAllElementsClickable = clickActiveAndInactiveElements(newsBriefStoriesLink, newsBriefInactiveElement, newsBriefNextArrow, newsBriefStoriesSize);
        }
        return isAllElementsClickable;
    }

    public boolean clickActiveAndInactiveElements(List<WebElement> allStories,List<WebElement> inactiveElement,WebElement nextArrow,int storySize) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        boolean storiesSize = false;
        int widgetStoriesCount = 0;
        int widgetStoriesSize = allStories.size();
        if (widgetStoriesSize == storySize) {
            for (int i = 0; i <= allStories.size() - 1; i++) {
                commonFunctions.moveToElementWithActions(allStories.get(i), 10, "next element");
                String activeStatus = commonFunctions.getAttributeValue(inactiveElement.get(i), 10, "class");
                if (activeStatus.equals("owl-item")) {
                    commonFunctions.moveToElementToClick(nextArrow);
                    commonFunctions.dummyWait(5);
                }
                widgetStoriesCount++;
                commonFunctions.moveToElementWithActions(allStories.get(i), 10, "next element");
                String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
                commonFunctions.moveToElementWithActions(allStories.get(i), 10, "next element");
                isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, allStories.get(i).getText());
                commonFunctions.dummyWait(5);
                Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
                commonFunctions.navigateBack(2);
                commonFunctions.dummyWait(5);
            }
            if (widgetStoriesCount == storySize)
                storiesSize = true;
        } else {
            Utils.logStepInfo(false, "Mismatch in expected and actual widget story size");
        }
        return isUrlClickable && isLinkReturn200 && isUrlMatches && storiesSize;
    }

    @Override
    public boolean checkRashifalWidgetIsHaving12RashiPresentAndStatusIs200(){
        int rashifalStoriesSize=12;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(rasifalSection,rasifalStorySection,rashifalStoriesSize);
    }

}
