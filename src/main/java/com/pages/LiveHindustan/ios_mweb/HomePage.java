package com.pages.LiveHindustan.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.ConstantPackage.LHConstants;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends CommonHomePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobile;

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
    @FindBy(xpath = "(//a[@title='वेब स्टोरी'])[1]")
    private static WebElement webStoriesSection;

    @FindBy(xpath = "//div[@class='theiaStickySidebar']//h2/a")
    private static List<WebElement> allRHSWidgets;

    @FindBy(xpath = "//div[@class='wdgt-wrap']//h3/a")
    private static List<WebElement> allPramukhStoriesLink;

    @FindBy(xpath = "//div[@class='brnd-ads-new']")
    private static WebElement sponsoredLink;

    @FindBy(xpath = "//a[@class='ctgry']")
    private static List<WebElement> allPramuckStoriesGeoName;

    @FindBy(className = "ftr-cpyrgt")
    private static WebElement homePageFooter;

    @FindBy(xpath = "//section[contains(@class,'lft-cont')]//h2/a")
    private static List<WebElement> homePageTopics;

    @FindBy(xpath = "//div[@id='top-ad']")
    private static WebElement topAd;

    @FindBy(xpath = "(//button[@class='srch-btn'])[2]")
    private static WebElement serachButton;

    @FindBy(xpath = "//a[@title='ई-पेपर']")
    private static WebElement ePaperLink;

    @FindBy(xpath = "//a[@id='eppr-hmbr']")
    private static WebElement ePaperIcon;

    @FindBy(xpath = "//section[@id='sehr-chune']/h3")
    private static WebElement sheharChuneSection;

    @FindBy(xpath = "//span[text()='शहर चुनें']")
    private static WebElement sheharChuneLink;

    @FindBy(xpath = "(//input[@class='srch-input'])[2]")
    private static WebElement searchField;

    @FindBy(xpath = "//span[@id='cls-sehr']")
    private static WebElement closeSheharChune;

    @FindBy(className = "closebtn btn")
    private static WebElement googlePopUpCloseButton;

    @FindBy(xpath="//nav[@class='wrap hdr-menu']")
    private static WebElement topSection;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[2]//a")
    private static List<WebElement> manoranjanStoriesLink;

    @FindBy(xpath = "//h1[@class='wdgt-hdng hdng-prmk']")
    private static WebElement topMenuOptionsHome;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[6]//a")
    private static List<WebElement> photoGalleryStoriesLink;

    @FindBy(xpath = "//a[@title='हिन्दुस्तान पहल']")
    private static WebElement hindustanPahal;

    @FindBy(xpath = "//img[@class='des-hide img']")
    private static WebElement hindustanPahalLink;

    @FindBy(xpath = "//div[@class='shiksha-bnr']/a")
    private static WebElement hindustanPahalUrl;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[3]//a")
    private static List<WebElement> dharmStoriesLink;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='क्रिकेट']")
    private static WebElement cricketStoriesSection;

    @FindBy(xpath = "//div[@id='widget-rs-4911']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> nationalStoriesLink;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='देश']")
    private static WebElement nationalStoriesSection;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='फोटो गैलरी']")
    private static WebElement photoGallerySection;

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

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='मनोरंजन']")
    private static WebElement manoranjanSection;

    @FindBy(xpath = "(//div[@class='wdgt-wrap'])[4]//a")
    private static List<WebElement> cricketStoriesLink;

    @FindBy(xpath = "//div[@id='widget-rs-4937']//a[@title='धर्म']")
    private static WebElement dharmStoriesSection;

    @FindBy(xpath = "(//div[@class='wdgt-nav pg-nav']//a)[1]")
    private static WebElement topMenuOptionsGadgets;

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

    @FindBy(xpath = "(//div[@class='text-player'])[1]")
    private static WebElement firstTextToSpeechBox;

    @FindBy(xpath = "(//div[@class='play-container'])[1]")
    private static WebElement playAndPauseControl;

    @FindBy(xpath = "(//div[@class='play-container'])[1]/div")
    private static WebElement playAndPauseConfirmation;

    @FindBy(xpath = "//div[@id='top-ad']")
    private static WebElement topMostAd;

    @FindBy(xpath = "(//div[@class='adclass'])[15]")
    private static WebElement lastAd;

    @FindBy(xpath = "//div[contains(@class,'brd-crum mrgn-lr')]")
    private static WebElement pageBreadcrumb;

    @FindBy(xpath = "//div[contains(@class,'brd-crum mrgn-lr')]//span")
    private static WebElement pageBreadcrumbLink;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//span")
    private static WebElement pageBreadcrumbMano;

    @FindBy(xpath = "//div[contains(@class,'adclass')]")
    private static WebElement firstRHSAdOnHomePage;

    @FindBy(xpath = "//div[@class='bid-ads']/parent::div/following-sibling::section")
    private static List<WebElement> adBetweenWidgets;

    @FindBy(xpath = "//span[@id='prev-arrow']")
    private static WebElement previousArrowButtonApkeLiaKhas;
    @FindBy(xpath = "//span[@id='next-arrow']")
    private static WebElement nextArrowButtonApkeLiaKhas;
    @FindBy(xpath = "//div[@id='home-de']")
    private static WebElement apkeLiaKhashSwipSection;
    @FindBy(xpath = "//section[contains(@class,'glry-cnt')]//h3")
    private static List<WebElement> allStoriesInApkeLiaKhas;

    @FindBy(xpath = "//div[@class='wdgt-hdng']")
    private static List<WebElement> allWidgetsOnHomePage;

    @FindBy(xpath = "//div[@class='wdgt-hdng']/a/preceding-sibling::h2")
    private static List<WebElement> allWidgetsLinksOnHomePage;
    @FindBy(xpath = "//a[@title='धर्म']/ancestor::div/child::div[@class='wdgt-wrap']//a")
    private static List<WebElement> dharamRelatedStoryLinks;
    @FindBy(xpath = "//div[contains(@class,'wdgt-nav pg-nav')]//a")
    private static List<WebElement> allSubOptionOnDharamPage;
    @FindBy(xpath = "//div[contains(@class,'rashi tabs crsel')]//a")
    private static List<WebElement> allTabsOnAnkRashiPage;
    @FindBy(xpath = "//span[@class='brd-crum-last']")
    private static WebElement breadcrumbLastWord;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='धर्म']")
    private static WebElement dharamWidgetTitle;

    @FindBy(xpath = "//div[@class='adclass']")
    private static List<WebElement> adsOnCurrentPage;

    @FindBy(xpath = "//div[@class='blk-2 cnt']//a")
    private static List<WebElement> puraPadheyLinks;

    @FindBy(xpath = "//div[contains(@class,'adclass rhsad')]")
    private static WebElement allRHSWidgetsOnHomePage;
    @FindBy(xpath = "//div[@class='theiaStickySidebar']/div[@class='adclass']")
    private static List<WebElement> adsAfterFirstOnRHS;
    @FindBy(xpath = "//span[@class='livblg-btn']/following-sibling::a")
    private static List<WebElement> liveBlogButtonStory;
    @FindBy(xpath = "//h3[@class='wdgt-subtitle1']")
    private static List<WebElement> liveWebPageStoriesTitle;
    @FindBy(xpath = "//div[@class='lv-hd']/p")
    private static WebElement liveUpdateOnStoryDetailPage;
    @FindBy(xpath = "//div[@class='lv-hd']//i")
    private static WebElement refreshButtonOnLiveBlogStoryDetailPage;

    @FindBy(xpath = "//div[@class='hdr-lft']/span")
    private static WebElement hamburgerMenuButton;

    @FindBy(xpath = "//ul[@id='side-nav']/li/a")
    private static List<WebElement> allLinksInHamburgerMenu;

    @FindBy(xpath = "//div[@class='main-wdgt']//h2/a")
    private static WebElement rashiFalOnHomePage;

    @FindBy(xpath = "//div[@class='wdgt-hdng']/h2/a")
    private static List<WebElement> allWidgetsHeadinLinks;

    @FindBy(xpath = "//i[@id='hamburger-close-icon']")
    private static WebElement hamburgerCloseButton;

    @FindBy(xpath = "//span[@class='livblg-btn']/ancestor::article/h1/a")
    private static List<WebElement> liveBlogStoryTitle;

    @FindBy(xpath = "//article[contains(@class,'card-sm card-sm-devider')]//h3/a")
    private static List<WebElement> otherHomePageStoriesTitle;

    @FindBy(xpath = "//h2[@class='wdgt-hdng']/a")
    private static List<WebElement> otherWidgetsOnHomepage;

    @FindBy(xpath = "//span[@class='zoom-wrap']/following-sibling::h3")
    private static List<WebElement> apkeLiaKhasAllStories;

    @FindBy(xpath = "//div[@class='web-stry-cnt']/p")
    private static List<WebElement> webStoriesPageAllTitles;
    @FindBy(xpath = "(//div[@class='web-stry-cnt']/p)[1]")
    private static WebElement firstWebStory;

    @FindBy(xpath = "//div[@class='prlads']")
    private static List<WebElement> adsOnHomePage;

    @FindBy(xpath = "//section[@id='track']/h2/a")
    private static WebElement aapkeliyakhasText;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a[@title='वीडियो']")
    private static WebElement videoMenu;

    @FindBy(xpath = "(//div[@class='common-bg clearfix']/h1/a)[1]")
    private static WebElement videoSubMenuHeading;

    @FindBy(xpath = "//div[@class='main-wdgt listing article']/a")
    private static List<WebElement> headlineAndVideo;

    @FindBy(xpath = "//a[@title='वीडियो गैलरी']")
    private static WebElement videoGallery;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> videoSubMenus;

    @FindBy(xpath = "//div[@id='home-de']/div/a")
    private static List<WebElement> aapkeliyakhasStories;

    @FindBy(xpath = "//meta[@name = 'description']")
    private static WebElement metaDescription;

    @FindBy(xpath = "//meta[@name = 'keywords']")
    private static WebElement metaKeywords;

    @FindBy(xpath = "//div[@id='hsh-hm']//a")
    private static List<WebElement> topicLinks;

    @FindBy(xpath = "//div[@id='hsh-hm']")
    private static WebElement topicSection;

    @FindBy(xpath = "//link[@rel = 'canonical']")
    private static WebElement metaCanonical;

    @FindBy(xpath = "//div[@class='articles']//h3")
    private static List<WebElement> storyOnStoriesListingPage;

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

    @FindBy(xpath = "//section[@id='widget-rs-1349046']//a[@title='न्यूज़ ब्रीफ']")
    private static WebElement newsBriefSection;

    @FindBy(xpath = "//a[@class='nb-cta-sld ']//parent::div//following-sibling::div//a")
    private static List<WebElement> newsBriefStoriesLink;

    @FindBy(xpath = "(//h2[@class='wdgt-hdng'])[5]")
    private static WebElement rasifalSection;

    @FindBy(xpath = "//div[@id='common-rashifal']//section[@class='rashifal']/a")
    private static List<WebElement> rasifalStorySection;


    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkHeaderDisplay() {
        commonFunctions.navigateToURL(globalVars.getURL());
        return commonFunctions.isElementDisplayed(pageHeader, 10, commonFunctions.getElementText(pageHeader));
    }

    @Override
    public boolean checkHomePageRHSWidgets() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(topAd, 10, "Top Ad on Homepage");
        commonFunctions.scrollDownToElement(rashiFalOnHomePage);
        commonFunctions.scrollToTop();
        return allRHSWidgets();
    }

    public boolean allRHSWidgets() {
        boolean isAllElementDisplay = false;
        for (int i = 0; i < allWidgetsHeadinLinks.size() - 1; i++) {
            if (commonFunctions.scrollToElementView(allWidgetsHeadinLinks.get(i), 10, commonFunctions.getElementText(allWidgetsHeadinLinks.get(i), 5))) {
                Utils.logStepInfo(allWidgetsHeadinLinks.get(i).getText() + " display successfully.");
                isAllElementDisplay = true;
            } else {
                isAllElementDisplay = false;
            }
        }
        return isAllElementDisplay;
    }

    public boolean isAllElementsVisible(List<WebElement> elementList) {
        boolean isAllElementDisplay = false;
        for (int i = 0; i < elementList.size(); i++) {
            if (commonFunctions.scrollToElementView(elementList.get(i), 10, commonFunctions.getElementText(elementList.get(i), 5))) {
                Utils.logStepInfo(elementList.get(i).getText() + " display successfully.");
                isAllElementDisplay = true;
            } else {
                isAllElementDisplay = false;
            }
        }
        return isAllElementDisplay;
    }

    @Override
    public boolean checkPramukhKhabreWidget() {
            return commonFunctionsMobile.pramukhKhabreWidget(allPramukhStoriesLink,sponsoredLink,"IOS_MWeb");
        }

    @Override
    public boolean checkScrollOnHomePage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        return isAllElementsVisible(homePageTopics);
    }

    @Override
    public boolean checkTopNevBar() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(hamburgerMenuButton, 5, "Hamburger menu");
        commonFunctions.clickElement(hamburgerMenuButton, 10, "Hamburger menu");
        boolean isSearchButtonClickable = commonFunctions.isElementClickable(serachButton, 10, "Search button on Home page");
        commonFunctions.moveToElementWithActions(searchField, 10, "YAHAN_LIKHEN field");
        boolean isSearchButtonWorked = commonFunctions.isElementDisplayed(searchField, 10, LHConstants.YAHAN_LIKHEN);
        commonFunctions.moveToElementWithActions(hamburgerCloseButton, 5, "Close button");
        commonFunctions.clickElementWithJS(hamburgerCloseButton, 10, "Hamburger menu close button");
        boolean isSheharChuneClickable = commonFunctions.isElementClickable(sheharChuneLink, 10, "शहर चुनें");
        commonFunctions.clickElementWithJS(sheharChuneLink, 10, LHConstants.SHEHAR_CHUNE_HINDI);
        commonFunctions.dummyWait(5);
        boolean isSheharChuneSectionDisplay = commonFunctions.isElementDisplayed(sheharChuneSection, 10, sheharChuneSection.getText().trim());
        commonFunctions.moveToElementWithActions(closeSheharChune, 10,"close");
        commonFunctions.clickElement(closeSheharChune, 10, String.format("Close %s section button", LHConstants.SHEHAR_CHUNE_HINDI));
        boolean isEpaperLinkClickable = commonFunctions.isElementClickable(ePaperLink, 10, "ई-पेपर button");
        commonFunctions.clickElement(ePaperLink,10,"e paper");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean isCurrentUrlOfEpaper = commonFunctions.getCurrentURL().contains("epaper");
        return isSearchButtonClickable && isSearchButtonWorked && isSheharChuneClickable && isSheharChuneSectionDisplay && isEpaperLinkClickable && isCurrentUrlOfEpaper;

    }

    @Override
    public boolean checkTopMenuBar() {
        int topMenuSize=topMenuOptions.size();
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(topSection,topMenuOptions,topMenuSize, "MenuValuesForRandomNumber");
    }

    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.scrollToElementView(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElementWithJS(elementList.get(i), 10, expectedResult);
                commonFunctions.dummyWait(3);
                break;
            }
        }
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

    public boolean openPageWithSwitchWindow(String text) {
        boolean isOpenPageWithSwitchWindow;
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isOpenPageWithSwitchWindow = commonFunctions.getCurrentURL().contains(text);
        commonFunctions.switchToWindow(windowsList.get(0));
        return isOpenPageWithSwitchWindow;
    }

    @Override
    public  boolean checkHomePageRhsAdLoad(){
        return false;
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
    public void clickNextSliderButtonTillNotDisabled() {
        while (!commonFunctions.isElementDisplayed(aanyaGalleryButton, 10, "class")) {
            commonFunctions.clickElementWithJS(nextButtonSlider, 10);
        }
    }

    @Override
    public boolean checkApkeLiaKhasWidgetsAndStoryClickable() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isApkeLiaKhasVisible = commonFunctions.scrollToElementView(widgetsHeadings.get(0), 10, "आपके लिए खास widgets");
        boolean isAllStoriesClickable = isAllElementClickable(widgetsHeadingsAllStories);
        return isApkeLiaKhasVisible && isAllStoriesClickable;
    }

    public boolean isAllElementClickable(List<WebElement> elementList) {
        boolean isAllelementClickableTrue = true;
        for (WebElement ele : elementList) {
            String elementTxt = commonFunctions.getElementText(ele, 5);
            commonFunctions.moveToElementWithActions(ele, 10, elementTxt);
            if (commonFunctions.isElementClickable(ele, 10, elementTxt)) {
                isAllelementClickableTrue &= true;
            } else if (elementTxt.isEmpty()) {
                isAllelementClickableTrue &= true;
            } else {
                isAllelementClickableTrue &= false;
            }
        }
        return isAllelementClickableTrue;
    }

    @Override
    public boolean checkTextToSpeechPlayAndPauseFunctionality() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollDownToElement(firstPramukhStory);
        if (isItLiveBlogStory(firstPramukhStory)) {
            commonFunctions.scrollDownToElement(otherHomePageStoriesTitle.get(0));
            commonFunctions.clickElementWithJS(otherHomePageStoriesTitle.get(0), 10, "Other story titile from home page");
        } else
            commonFunctions.clickElementWithJS(firstPramukhStory, 20, "First story on Home page");
        commonFunctions.scrollToElementView(playAndPauseConfirmation, 10, "Play/Pause button for text to speech");
        boolean isPlayTextContains = commonFunctions.getAttributeValue(playAndPauseConfirmation, 10, "class").split(" ")[1].contains("play");
        commonFunctions.clickElementWithJS(playAndPauseConfirmation, 10, "Text to speech play/pause control");
        boolean isPauseTextContains = commonFunctions.getAttributeValue(playAndPauseConfirmation, 10, "class").split(" ")[1].contains("pause");

        return isPlayTextContains && isPauseTextContains;
    }

    public boolean isItLiveBlogStory(WebElement ele) {
        String storyText = commonFunctions.getElementText(ele, 5);
        for (int i = 0; i < liveBlogStoryTitle.size(); i++) {
            if (commonFunctions.getElementText(liveBlogStoryTitle.get(i), 10).contains(storyText)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkTopAdAndBottomAdLoadProperly() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isTopAdLoadProperly = commonFunctions.isElementDisplayed(topMostAd, 20, "Top most ad on Home Page");
        commonFunctions.scrollDownToElement(lastAd);
        boolean isLastAdLoadProperly = commonFunctions.isElementDisplayed(lastAd, 10, "Last visible Ad on bottom of the home page");
        return isTopAdLoadProperly && isLastAdLoadProperly;
    }

    @Override
    public boolean checkAllPageAreLoadingProperly() {
        boolean isAllPageAreLoadingProperlyTrue = true;
        commonFunctions.navigateToURL(globalVars.getURL());

        clickElementWithGivenText(topMenuOptions, LHConstants.HOME_HINDI);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(topMenuOptionsHome, 10).contains("Hindi News");

        clickElementWithGivenText(topMenuOptions, LHConstants.STATE_HINDI);
        commonFunctions.moveToElementWithActions(pageBreadcrumb, 10,"state");
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(LHConstants.STATE_HINDI);

        clickElementWithGivenText(topMenuOptions, LHConstants.VIDEO_HINDI);
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumbMano, 10).contains(LHConstants.VIDEO_HINDI);

        clickElementWithGivenText(topMenuOptions, LHConstants.GADGETS_HINDI);
        commonFunctions.moveToElementWithActions(pageBreadcrumb, 10,"gadgets");
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(topMenuOptionsGadgets, 10).contains(LHConstants.GADGETS_HINDI);

        clickElementWithGivenText(topMenuOptions, LHConstants.NATION_HINDI);
        commonFunctions.moveToElementWithActions(pageBreadcrumb, 10,"nation");
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(LHConstants.NATION_HINDI);

        clickElementWithGivenText(topMenuOptions, LHConstants.ENTERTAINMENT_HINDI);
        commonFunctions.moveToElementWithActions(pageBreadcrumb, 10,"entertainment");
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(LHConstants.ENTERTAINMENT_HINDI);

        clickElementWithGivenText(topMenuOptions, LHConstants.PHOTO_HINDI);
        commonFunctions.moveToElementWithActions(pageBreadcrumb, 10,"photo");
        isAllPageAreLoadingProperlyTrue &= commonFunctions.getElementText(pageBreadcrumbMano, 10).contains(LHConstants.PHOTO_HINDI);

        return isAllPageAreLoadingProperlyTrue;
    }

    public WebElement getSelectedElement(List<WebElement> elementList, String text) {
        for (WebElement ele : elementList) {
            if (commonFunctions.getElementText(ele, 10).contains(text)) {
                return ele;
            }
        }
        return null;
    }

    @Override
    public boolean checkPhotoGalleryLandingPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, LHConstants.PHOTO_HINDI);
        boolean isLandingToPhotoGalleryCorret = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        return commonFunctions.getElementText(pageBreadcrumb, 10).contains(LHConstants.PHOTO_HINDI) && isLandingToPhotoGalleryCorret;
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
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(10);
        boolean isApkeLiaKhasWidgetDisplay = checkIfListContainsText(otherWidgetsOnHomepage, "आपके लिए खास");
        boolean isAllStoriesSlidableInApkeLiaKhas = isAllElementClickable(apkeLiaKhasAllStories);
        return isApkeLiaKhasWidgetDisplay && isAllStoriesSlidableInApkeLiaKhas;
    }

    @Override
    public boolean checkHomePageRFUWidgets() {
        boolean isApkeLiaKhasDisplayTrue = checkRFUApkeLiaKhasWidget();
        boolean isAllStoryRFULoadingProperly = isAllElementsVisible(allStoriesInApkeLiaKhas);
        boolean isAllStoryInApkeLiaKhasClickable = isAllElementClickable(allStoriesInApkeLiaKhas);

        return isApkeLiaKhasDisplayTrue && isAllStoryRFULoadingProperly && isAllStoryInApkeLiaKhasClickable;
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

    public boolean isAllRelatedLandingPageTrue(List<WebElement> elementList) {
        String rashifalUrl = commonFunctions.getCurrentURL();
        String breadcrumbText = null;
        boolean isAllLandingPageAreRelated = true;
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            breadcrumbText = commonFunctions.getElementText(elementList.get(i), 10);
            commonFunctions.clickElementWithJS(elementList.get(i), 10, breadcrumbText);
            commonFunctions.dummyWait(5);
            if (breadcrumbText.equals("धर्म") || breadcrumbText.equals("आरती") || breadcrumbText.equals("रोचक") || breadcrumbText.equals("पूजन विधि"))
                isAllLandingPageAreRelated &= commonFunctions.getElementText(pageBreadcrumb, 10).contains(breadcrumbText);
            else if (!breadcrumbText.equals("विशेष दिवस"))
                isAllLandingPageAreRelated &= commonFunctions.getElementText(pageBreadcrumbLink, 10).contains(breadcrumbText);
            commonFunctions.navigateToURL(rashifalUrl);
        }
        return isAllLandingPageAreRelated;
    }

    public boolean isLandingPageIsAstrology() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollDownToElement(dharamRelatedStoryLinks.get(0));
        commonFunctions.clickElementWithJS(dharamWidgetTitle, 10, LHConstants.DHARM_IN_HINDI);
        commonFunctions.dummyWait(10);
        boolean isUrlChangesTrue = commonFunctions.getCurrentURL().contains("/astrology/");
        boolean isLandingOnToDharamPageTrue = commonFunctions.getElementText(pageBreadcrumb, 10).contains(LHConstants.DHARM_IN_HINDI);
        return isLandingOnToDharamPageTrue && isUrlChangesTrue;
    }

    @Override
    public boolean checkRHSWidgets() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isFirstAdDisplay = commonFunctions.isElementDisplayed(topAd, 10, "First Ad on the home page");
        boolean isAllRHSWidgetsAreDisplay = isAllElementClickable(allWidgetsLinksOnHomePage);
        boolean isAdsAfterFirstOneDisplay = isAllElementClickable(adsOnHomePage);

        return isFirstAdDisplay && isAllRHSWidgetsAreDisplay && isAdsAfterFirstOneDisplay;
    }

    @Override
    public boolean checkLiveBlogButtonOnHome() {
        Utils.logStepInfo(String.format("%s title related page opened.", liveBlogPageInteraction()));
        return commonFunctions.getElementText(breadcrumbLastWord, 10).equals(liveBlogPageInteraction());
    }

    @Override
    public boolean checkRefreshButtonOnLiveBlogDetailPage() {
        commonFunctions.navigateToURL(globalVars.getURL() + LHConstants.LIVE_BLOG_URL);
        String storyTitleWithLiveBlog = commonFunctions.getElementText(liveWebPageStoriesTitle.get(0), 5);
        commonFunctions.clickElementWithJS(liveWebPageStoriesTitle.get(0), 10, storyTitleWithLiveBlog);
        Utils.logStepInfo(String.format("%s title related page opened.", liveBlogPageInteraction()));
        commonFunctions.clickElementWithJS(refreshButtonOnLiveBlogStoryDetailPage, 10, "Refresh button for story detail page");
        boolean isLiveBlogStillVisible = commonFunctions.isElementDisplayed(liveUpdateOnStoryDetailPage, 10, "Live Blog Icon in story detail page");
        boolean isRefreshButtonWorks = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        return isLiveBlogStillVisible && isRefreshButtonWorks;
    }

    @Override
    public boolean checkLivBlogLiveUpdateButtonOnDetailPage() {
        Utils.logStepInfo(String.format("%s title related page opened.", liveBlogPageInteraction()));
        return commonFunctions.isElementDisplayed(liveUpdateOnStoryDetailPage, 10, commonFunctions.getElementText(liveUpdateOnStoryDetailPage, 5));
    }

    public String liveBlogPageInteraction() {
        commonFunctions.navigateToURL(String.format("%s%s", globalVars.getURL(), LHConstants.LIVE_BLOG_URL));
        String storyTitleWithLiveBlog = commonFunctions.getElementText(liveWebPageStoriesTitle.get(0), 5);
        commonFunctions.clickElementWithJS(liveWebPageStoriesTitle.get(0), 10, storyTitleWithLiveBlog);
        return storyTitleWithLiveBlog;
    }

    @Override
    public boolean checkWebStoryDetailPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        String urlBeforeWebStoryDetailPageOpen = commonFunctions.getCurrentURL();
        commonFunctions.scrollToElementView(webStoriesSection, 15, "Web Stories Section");
        commonFunctions.clickElement(firstWebStory, 10, "First Web Story");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        boolean isUrlChangedAfterOpeningWebStoryDetailPage = !commonFunctions.getCurrentURL().equals(urlBeforeWebStoryDetailPageOpen);
        commonFunctions.switchToWindow(windowsList.get(0));
        return isUrlChangedAfterOpeningWebStoryDetailPage;
    }

    @Override
    public boolean checkAmpHomePage() {
        return false;
    }

    @Override
    public boolean checkAllHamburgerLinksFunctionality() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(hamburgerMenuButton, 20, "Home hamburger button");
        boolean isAllRelatedLandingPage = commonFunctions.isAllRelatedLandingPageTrue(allLinksInHamburgerMenu, hamburgerMenuButton, hamburgerCloseButton);
        Utils.logStepInfo(true, "isAllRelatedLandingPage = "+isAllRelatedLandingPage);
        return isAllRelatedLandingPage;
    }

    @Override
    public boolean checkMwebVideoLandingPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.clickElementWithJS(videoMenu, 10, "Video Menu");
        commonFunctions.waitForPageToLoad();
        boolean videoGalleryPresent = commonFunctions.isElementPresent(videoGallery, 10, "Video Gallery");
        boolean subMenuClickableAndLoadingWidgetsAndHeadlinesStatus = veryfySubMenuClickableAndLoadingWidgetsAndHeadlines(videoSubMenus);
        return videoGalleryPresent && subMenuClickableAndLoadingWidgetsAndHeadlinesStatus;
    }

    public boolean veryfySubMenuClickableAndLoadingWidgetsAndHeadlines(List<WebElement> listOfMenu){
        boolean flag = false;
        for(int i=0;i<listOfMenu.size();i++){
            commonFunctions.scrollToElement(listOfMenu.get(i), "Video Sub Menu");
            String subMenu = listOfMenu.get(i).getText().trim();
            boolean clickStatus = commonFunctions.clickElementWithJS(listOfMenu.get(i), 10, subMenu);
            commonFunctions.dummyWait(5);
            commonFunctions.scrollToElement(videoSubMenuHeading, "Video Sub Menu Heading");
            String subMenuHeadline = videoSubMenuHeading.getText().trim();
            subMenu = subMenu+" "+"वीडियो गैलरी";
            boolean resPageStatue = commonFunctions.compareTexts(subMenu, subMenuHeadline);
            boolean headLineVideo = headlineAndVideo.size()>0;
            if(clickStatus && resPageStatue && headLineVideo){
                flag = true;
                driver.navigate().back();
                commonFunctions.waitForPageToLoad();
                commonFunctions.dummyWait(5);
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean checkMwebHomePageRfuWidget(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(aapkeliyakhasText, 10, "AApke liye khash widget");
        boolean aapKeLiyaKhasWidgit = commonFunctions.isElementDisplayed(aapkeliyakhasText, 10, "AApke liye khash widget");
        boolean aapKeLiyaKhasStory = moveElementAndCheckIsClickable(aapkeliyakhasStories);
        return aapKeLiyaKhasWidgit && aapKeLiyaKhasStory;
    }

    public boolean moveElementAndCheckIsClickable(List<WebElement> list){
        boolean flag = false;
        for(int i=0;i<list.size();i++) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", list.get(i));
                commonFunctions.isElementClickable(list.get(i), 20, "Aap ke liya khas story");
                flag = true;
            }catch(Exception e){
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
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        boolean titleStatus = !commonFunctions.getTitle().isEmpty();
        boolean keywordStatus = !commonFunctions.getAttributeValue(metaKeywords, "content").isEmpty();
        boolean descStatus = !commonFunctions.getAttributeValue(metaDescription, "content").isEmpty();
        boolean canStatus = !commonFunctions.getAttributeValue(metaCanonical, "href").isEmpty();
        clickElementWithGivenText(topMenuOptions, LHConstants.PHOTO_HINDI);
        commonFunctions.dummyWait(5);
        titleStatus &= !commonFunctions.getTitle().isEmpty();
        keywordStatus &= !commonFunctions.getAttributeValue(metaKeywords, "content").isEmpty();
        descStatus &= !commonFunctions.getAttributeValue(metaDescription, "content").isEmpty();
        canStatus &= !commonFunctions.getAttributeValue(metaCanonical, "href").isEmpty();
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        clickElementWithGivenText(topMenuOptions, LHConstants.VIDEO_HINDI);
        commonFunctions.dummyWait(5);
        titleStatus &= !commonFunctions.getTitle().isEmpty();
        keywordStatus &= !commonFunctions.getAttributeValue(metaKeywords, "content").isEmpty();
        descStatus &= !commonFunctions.getAttributeValue(metaDescription, "content").isEmpty();
        canStatus &= !commonFunctions.getAttributeValue(metaCanonical, "href").isEmpty();
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(firstPramukhStory, 5, "First Pramukh Story");
        commonFunctions.clickElementWithJS(firstPramukhStory, 5, "First Pramukh Story");
        commonFunctions.dummyWait(5);
        titleStatus &= !commonFunctions.getTitle().isEmpty();
        keywordStatus &= !commonFunctions.getAttributeValue(metaKeywords, "content").isEmpty();
        descStatus &= !commonFunctions.getAttributeValue(metaDescription, "content").isEmpty();
        canStatus &= !commonFunctions.getAttributeValue(metaCanonical, "href").isEmpty();

        return titleStatus && keywordStatus && descStatus && canStatus;
    }

    @Override
    public boolean checkAllTopicAreGiving200StatusCode() {
        int topicSize=topicLinks.size();
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(topicSection,topicLinks,topicSize, "TopicValuesForRandomNumber");
    }


    @Override
    public boolean checkEntertainmentWidgetIsHaving6StoriesAndStatusIs200(){
        int entertainmentSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(manoranjanSection,manoranjanStoriesLink,entertainmentSize, "WidgitValuesForRandomNumber");
    }


    @Override
    public boolean checkPhotoGalleryWidgetIsHaving6StoriesAndStatusIs200(){
        int photoSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(photoGallerySection,photoGalleryStoriesLink,photoSize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkHindustanPahalLinkWidgetRedirectionAndStatusCodeIs200() {
        return commonFunctionsMobile.hindustanPahalLinkWidgetRedirectionAndStatusCodeIs200(hindustanPahal,hindustanPahalUrl,hindustanPahalLink);
    }

    @Override
    public boolean checkDharmWidgetIsHaving6StoriesAndStatusIs200(){
        int dharmSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(dharmStoriesSection,dharmStoriesLink,dharmSize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkCricketWidgetIsHaving6StoriesAndStatusIs200() {
        int cricketSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(cricketStoriesSection,cricketStoriesLink,cricketSize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkNationalWidgetIsHaving6StoriesAndStatusIs200() {
        int nationalSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(nationalStoriesSection,nationalStoriesLink,nationalSize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkBusinessWidgetIsHaving6StoriesAndStatusIs200() {
        int businessStorySize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(businessSection,businessStoriesLink,businessStorySize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkCareerWidgetIsHaving6StoriesAndStatusIs200() {
        int businessStorySize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(careerSection,careerStoriesLink,businessStorySize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkGadgetsWidgetIsHaving6StoriesAndStatusIs200() {
        int gadgetsStorySize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(gadgetsSection,gadgetsStoriesLink,gadgetsStorySize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkHomePageAndWidgets()
    {return false;}

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
    public boolean checkTopVideoWidgetIsHaving5StoriesAndStatusIs200(){
        int topVideoStorySize=5;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(topVideoSection,topVideoStoriesLink,topVideoStorySize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkAutoWidgetIsHaving6StoriesAndStatusIs200(){
        int autoStory=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(autoSection,autoStoriesLink,autoStory, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkApnaSheherChuneWidgetIsHaving6StoriesAndStatusIs200(){
        int chooseCityStorySize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(chooseCitySection,chooseCityStoriesLink,chooseCityStorySize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkLifestyleWidgetIsHaving6StoriesAndStatusIs200() {
        int lifeStyleStorySize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(lifeStyleSection,lifeStyleStoriesLink,lifeStyleStorySize, "WidgitValuesForRandomNumber");

    }

    @Override
    public boolean checkHTWidgetIsHaving6StoriesAndStatusIs200(){
        int HTStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectUrlForIos(HTSection,HTStorySection,HTStoriesSize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkLMWidgetIsHaving6StoriesAndStatusIs200(){
        int LMStoriesSize=6;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectUrlForIos(LMSection,LMStorySection,LMStoriesSize, "WidgitValuesForRandomNumber");
    }

    @Override
    public boolean checkKhabrePhotoAndVideoShouldHaveNewsListedUnderItOnSearching(String searchKeyword,String section1,String section2,String section3) {
        return false;
    }

    @Override
    public boolean checkNewsBriefWidgetIsHaving7StoriesAndStatusIs200() {
        boolean isAllElementsClickable=false;
        int newsBriefStoriesSize = 7;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        if (commonFunctions.isElementDisplayed(newsBriefSection, 10, "news brief section")){
            isAllElementsClickable = commonFunctionsMobile.clickActiveAndInactiveElements(newsBriefStoriesLink,newsBriefStoriesSize, "WidgitValuesForRandomNumber");
        }
        return isAllElementsClickable;
       }

    @Override
    public boolean checkRashifalWidgetIsHaving12RashiPresentAndStatusIs200(){
        int rashifalStoriesSize = 12;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        return commonFunctionsMobile.allLinksClickable(rasifalSection,rasifalStorySection, rashifalStoriesSize, "WidgitValuesForRandomNumber");
    }

}
