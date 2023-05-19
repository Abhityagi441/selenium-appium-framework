package com.pages.LiveHindustan.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StoryPage extends CommonStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    private static CommonFunctionsMobileLH commonFunctionsMobileLH;

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
    @FindBy(xpath = "//span[@class='livblg-btn']/ancestor::article/h1/a")
    private static List<WebElement> liveBlogStoryTitle;

    @FindBy(xpath = "//div[@class='theiaStickySidebar']//h2/a")
    private static List<WebElement> allRHSWidgets;

    @FindBy(xpath = "//div[@class='wdgt-wrap']//h3/a")
    private static List<WebElement> allPramukhStoriesLink;

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

    @FindBy(xpath = "//span[text()='शहर चुनें']")
    private static WebElement sheharChuneLink;

    @FindBy(xpath = "//input[@id='search-field']")
    private static WebElement searchField;

    @FindBy(xpath = "//span[@id='cls-sehr']")
    private static WebElement closeSheharChune;

    @FindBy(className = "closebtn btn")
    private static WebElement googlePopUpCloseButton;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;

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

    @FindBy(xpath = "//div[@class='wdgt-lft']//h3")
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

    @FindBy(xpath = "//h1[@class='page-hdng']")
    private static List<WebElement> pageDetailStoriesHeading;

    @FindBy(xpath = "//div[@class='img-hgt-blk']")
    private static List<WebElement> pageDetailsImages;

    @FindBy(xpath = "(//div[@class='stry-bdy'])[1]/p")
    private static List<WebElement> firstStoryParagraphs;

    @FindBy(xpath = "//span[@class='brd-crum-last']")
    private static List<WebElement> breadcrumbsOnCurrentPage;

    @FindBy(xpath = "(//div[@class='tags'])[1]/a")
    private static List<WebElement> tagNameOnCurrentPage;

    @FindBy(xpath = "//div[@class='athr-info']")
    private static List<WebElement> storyImageByLines;

    @FindBy(xpath = "(//div[@class='prlads'])[1]/following-sibling::p")
    private static List<WebElement> paragraphsAfterFirstAd;

    @FindBy(xpath = "(//div[@class='stry-bdy'])[2]/p")
    private static List<WebElement> paragraphsAfterSecondAd;

    @FindBy(xpath = "(//div[@class='prlads'])[1]")
    private static WebElement firstAdFirstStory;

    @FindBy(xpath = "(//div[@class='prlads'])[2]")
    private static WebElement secoundAdFirstStory;


    @FindBy(xpath = "(//div[@class='prlads'])[1]/preceding-sibling::p")
    private static List<WebElement> firstAdInStory;

    @FindBy(xpath = "//h2[@class='stry-shrt-head']")
    private static List<WebElement> summariesOnCurrentPage;

    @FindBy(xpath = "//section[contains(@class,'main-wdgt listing article')]//a")
    private static List<WebElement> newsListingOnNationalPage;

    @FindBy(xpath = "//div[contains(@class,'wdgt-nav pg-nav')]//a")
    private static List<WebElement> allSubOptionOnDharamPage;
    @FindBy(xpath = "//div[@class='articles']//h3")
    private static List<WebElement> storyOnStoriesListingPage;

    @FindBy(xpath = "(//div[@class='articles']//h1)[2]")
    private static WebElement secondStoryOnStoryDetailPage;

    @FindBy(xpath = "//span[@class='livblg-btn']/ancestor::article//h3/a")
    private static WebElement liveBlockStoryTitle;
    @FindBy(xpath = "//aside[@class='rhs-cont']//h2")
    private static List<WebElement> widgetsRHS;
    @FindBy(xpath = "//aside[@class='rhs-cont']//h2/a")
    private static List<WebElement> widgetsRHSLinks;
    @FindBy(xpath = "//div[@class='articles']//h1/span")
    private static WebElement viralNewsPageHeadingTitle;
    @FindBy(xpath = "//article[contains(@class,'card-sm card-sm-devider')]//h3/a")
    private static List<WebElement> otherHomePageStoriesTitle;

    @FindBy(xpath = "(//div[@class='sm-rght']/h3/a)[1]")
    private static WebElement homePageStory;

    @FindBy(xpath = "(//small[@class='inner-txt'])[2]")
    private static WebElement agleLekhSection;

    @FindBy(xpath = "(//div[text()='RECOMMENDED'])[1]")
    private static WebElement recommendedSection;

    @FindBy(xpath = "(//a[@class='nxt-Artcl'])[1]")
    private static WebElement aglelekhpadeText;

    @FindBy(xpath = "//div[@class='stry-imgblck']")
    private static List<WebElement> slideStoryImages;

    @FindBy(xpath = "(//h1[@class='page-hdng'])[2]")
    private static WebElement readNextArticleHeading;

    @FindBy(xpath = "//div[@class='shre-innr']")
    private static WebElement shareThruSocialMedia;

    @FindBy(xpath = "(//*[@class='page-hdng'])[1]")
    private static WebElement storyPageStory;

    @FindBy(xpath = "//a[@title='वेब स्टोरी']")
    private static WebElement webStoryHomePage;

    @FindBy(xpath = "(//ul[@id='webStories']/li)[1]")
    private static WebElement webStoryStoryPage;

    @FindBy(xpath = "(//div[@class='tags']//a)[1]")
    private static WebElement firstTag;

    @FindBy(xpath = "//h1[@class='wdgt-hdng']//span")
    private static WebElement tagPageHeading;

    @FindBy(xpath = "//h1[@class='wdgt-hdng']//following-sibling::a")
    private static List<WebElement> listOnTagsPage;

    @FindBy(xpath = "//div[@class='pagination common-bg']//a")
    private static List<WebElement> pagesNumberAtTagPage;
    @FindBy(xpath = "(//div[contains(@class,'rfu-stry')]/div[@class='wdgt-hdng']//a)[1]")
    private static WebElement firstSambandhitKhabreWidget;
    @FindBy(xpath = "//article[1]//div[contains(@class,'rfu-stry')]//div[@id='rfu-slider']//a")
    private static List<WebElement> listOfSambahanditKhabre;
    @FindBy(xpath = "//article[1]//div[contains(@class,'rfu-stry')]//div[@id='rfu-slider']")
    private static WebElement sambahanditKhabre;
    @FindBy(xpath = "//h2[@class='stry-shrt-head']")
    private static List<WebElement> pageDetailStoriesSummary;
    @FindBy(xpath = "(//div[@class='brd-crum'])[1]/a")
    private static List<WebElement> storyDetailBreadCrumb;
    @FindBy(xpath = "//h1[contains(@class, 'wdgt-hdng')]/span")
    private static WebElement brdCrumRedFirst;
    @FindBy(xpath = "(//div[@class='wdgt-hdng']//a)[1]")
    private static WebElement brdCrumRedSecound;
    @FindBy(xpath = "null")
    private static WebElement dummy;

    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
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
    public boolean checkStoryDetailPage() {
        return false;
    }

    public boolean allRHSWidgetsDisplay(List<WebElement> elementList) {
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

    @Override
    public boolean checkStoryPageBreadcrumb() {
        clickFirstPramukhStory();
        String navigateURL = commonFunctions.getCurrentURL();
        String firstStoryTitle = commonFunctions.getElementText(pageDetailStoriesHeading.get(0), 10);
        String breadcrumsTextForFirstStory = commonFunctions.getElementText(breadcrumbsOnCurrentPage.get(0), 10);
        boolean breadCrumbRedirection = commonFunctionsMobileLH.isAllElementsClickableAndGiving200Status(storyDetailBreadCrumb,2,navigateURL,brdCrumRedFirst,brdCrumRedSecound,dummy);
        return breadCrumbRedirection && commonFunctions.compareTexts(firstStoryTitle, breadcrumsTextForFirstStory);
    }

    @Override
    public boolean checkStoryTags() {
        commonFunctionsMobileLH.clickFirstPramukhStory(firstPramukhStory);
        return commonFunctionsMobileLH.checkStoryTagsOnMweb(tagNameOnCurrentPage);
    }

    @Override
    public boolean checkAdFor2ndAnd3rdByNumberOfWords() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(firstPramukhStory);
        if (isItLiveBlogStory(firstPramukhStory)) {
            commonFunctions.scrollDownToElement(otherHomePageStoriesTitle.get(0));
            commonFunctions.clickElement(otherHomePageStoriesTitle.get(0), 10, "Other story titile from home page");
            commonFunctions.waitForPageToLoad();
        } else {
            commonFunctions.clickElement(firstPramukhStory, 20, "First story on Home page");
            commonFunctions.waitForPageToLoad();
        }
        commonFunctions.scrollToElementView(firstAdFirstStory, 10, "First Ad in first story");
        boolean is2ndAdCameAfter_120Words = getParagraphWordCount(paragraphsAfterFirstAd) > 120;
        commonFunctions.scrollToElementView(secoundAdFirstStory, 10, "Secound Ad in first story");
        boolean is3rdAdCameAfter_120Words = getParagraphWordCount(paragraphsAfterSecondAd) > 120;
        return is2ndAdCameAfter_120Words && is3rdAdCameAfter_120Words;
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

    public int getParagraphWordCount(List<WebElement> elementList) {
        int wordCount = 0;
        for (WebElement ele : elementList) {
            if (commonFunctions.getAttributeValue(ele, 10, "class").isEmpty()) {
                wordCount += commonFunctions.getElementText(ele, 5).split(" ").length;
            } else {
                break;
            }
        }
        return wordCount;
    }

    @Override
    public boolean checkFirstAdComesAfterFirstParagraph() {
        clickFirstPramukhStory();
        return firstAdInStory.size() == 1;
    }

    @Override
    public boolean checkSummaryOfTheStoryPage() {
        clickFirstPramukhStory();
        boolean summaryIsVisible = commonFunctions.isElementDisplayed(summariesOnCurrentPage.get(0), 10, "First story summary");
        boolean summaryIsNotEmpty = !commonFunctions.getElementText(summariesOnCurrentPage.get(0), 5).isEmpty();
        return summaryIsNotEmpty && summaryIsVisible;
    }

    @Override
    public boolean checkStoryPage() {
        clickFirstPramukhStory();
        String currentUrl = commonFunctions.getCurrentURL();
        commonFunctions.refreshPage();
        return commonFunctions.getCurrentURL().contains(currentUrl);
    }

    @Override
    public boolean checkListingPageForNational() {
        boolean isListingPageTrue = false;
        boolean isLandingOnRastreeyPageTrue = landingOnRashtreeyKhabreyPage();
        if (newsListingOnNationalPage.size() >= 20)
            isListingPageTrue = true;
        return isListingPageTrue && isLandingOnRastreeyPageTrue;
    }

    @Override
    public boolean checkStoryPageOneTapFunctionality(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(homePageStory, 10, "Home Page Story");
        String storyTitle=commonFunctions.getElementText(homePageStory, 10);
        commonFunctions.clickElementWithJS(homePageStory, 10);
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(storyPageStory, 20, "Story detail Page Story");
        boolean storyPage = commonFunctions.isElementDisplayed(storyPageStory, 10);
        boolean titleCom = isTextPresentInStoryPage(storyTitle, commonFunctions.getElementText(storyPageStory, 10));
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        boolean storyPageAfterLogin = commonFunctions.isElementDisplayed(storyPageStory, 10);
        boolean titleComAfterLogin = isTextPresentInStoryPage(storyTitle, commonFunctions.getElementText(storyPageStory, 10));
        return storyPage && titleCom && storyPageAfterLogin && titleComAfterLogin;
    }

    @Override
    public boolean checkWebStoryDetailPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(webStoryHomePage, "Home Page Web Story");
        commonFunctions.clickElementWithJS(webStoryHomePage, 20, "Home Page Web Story");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(10);
        commonFunctions.scrollToElement(webStoryStoryPage, "Story Page Web Story");
        boolean story = commonFunctions.isElementPresent(webStoryStoryPage, 20, "Story Page Web Story");
        boolean storyDisplay = commonFunctions.clickElementWithJS(webStoryStoryPage, 20, "Story Page Web Story");
        return story && storyDisplay;
    }

    public boolean isTextPresentInStoryPage(String homeStory, String storyPageStory){
        int count = 0;
        String [] arrayString = homeStory.split(" ");
        for(int i=0;i<arrayString.length;i++){
            if(storyPageStory.contains(arrayString[i])){
                count = count + 1;
            }
        }
        if(count>3){
            return true;
        }else {
            return false;
        }
    }

    public boolean landingOnRashtreeyKhabreyPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, "देश");
        clickElementWithGivenText(allSubOptionOnDharamPage, "राष्ट्रीय खबरें");
        return commonFunctions.getCurrentURL().contains("/national");
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
    public boolean checkNextPageAppending() {
        clickFirstPramukhStory();
        commonFunctions.scrollToElementView(secondStoryOnStoryDetailPage, 10, "Second appended story with opened story detail page");
        return commonFunctions.isElementDisplayed(secondStoryOnStoryDetailPage, 10, "Second appended story with opened story detail page");
    }

    @Override
    public boolean checkStoryPageRHS() {
        clickFirstPramukhStory();
        isAllElementClickable(widgetsRHS);
        commonFunctions.scrollToElementView(widgetsRHSLinks.get(0), 10, "Clickable widget");
        String widgetRHSLinkTitle = commonFunctions.getElementText(widgetsRHSLinks.get(0), 5).split(" ")[0];
        commonFunctions.clickElement(widgetsRHSLinks.get(0), 10, commonFunctions.getElementText(widgetsRHSLinks.get(0), 5));
        return commonFunctions.getElementText(viralNewsPageHeadingTitle, 5).contains(widgetRHSLinkTitle);
    }

    public boolean isAllElementClickable(List<WebElement> elementList) {
        boolean isAllelementClickableTrue = true;
        for (WebElement ele : elementList) {
            commonFunctions.dummyWait(5);
            commonFunctions.isElementDisplayed(ele,10,"element");
            commonFunctions.moveToElementWithActions(ele, 20, commonFunctions.getElementText(ele, 20));
            if (commonFunctions.isElementClickable(ele, 20, "Pramukh stories")) {
                isAllelementClickableTrue &= true;
            } else {
                isAllelementClickableTrue &= false;
            }
        }
        return isAllelementClickableTrue;
    }

    public void clickFirstPramukhStory() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(firstPramukhStory);
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on home page");
    }
    @Override
    public boolean checkAppPerPadheFunctionalityInstalled(){
        return false;
    }

    @Override
    public boolean checkAppPerPadheFunctionalityNotInstalled(){
        return false;
    }

    @Override
    public boolean checkRelatedNewsWidgetOnStoryDetail(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        return commonFunctionsMobileLH.checkRelatedNewsWidgetOnStoryDetailOnMweb(firstPramukhStory,firstSambandhitKhabreWidget,listOfSambahanditKhabre);
    }
    @Override
    public boolean checkUrlMustChange(){
        return false;
    }
    @Override
    public boolean checkAurPadheButtonOnAmpStoryPage(){
        return false;
    }
    @Override
    public boolean checkListViewInSambahanditKhabreWidgetInStoryPages()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        return commonFunctionsMobileLH.checkListViewInSambahanditKhabreWidgetInStoryPagesOnMweb(firstPramukhStory,sambahanditKhabre,listOfSambahanditKhabre);
    }

    @Override
    public boolean checkAglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading(){
        boolean agleLekhPadeFooterSectionDisplay=commonFunctionsMobileLH.isReadNextArticleVisible(homePageStory,agleLekhSection,recommendedSection,aglelekhpadeText);
        boolean agleLekhPadeFooterSectionNotDisplayed=commonFunctionsMobileLH.aglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading(shareThruSocialMedia,aglelekhpadeText);

        return agleLekhPadeFooterSectionDisplay && agleLekhPadeFooterSectionNotDisplayed;
    }

    @Override
    public boolean checkAglaLekhInWebStoryPagesAsStickyBottom(){
        boolean agleLekhPadeFooterSectionDisplay=commonFunctionsMobileLH.isReadNextArticleVisible(homePageStory,agleLekhSection,recommendedSection,aglelekhpadeText);
        String agleLekhText=commonFunctions.getElementText(aglelekhpadeText,10);
        boolean isReadNextArticleClickable=commonFunctions.clickElementWithJS(aglelekhpadeText,10,"अगला लेख पढ़ें link");
        boolean isReadNextArticleDisplayed=commonFunctions.isElementDisplayed(readNextArticleHeading,10,"Next article is displayed");
        String nextArticleHeading =commonFunctions.getElementText(readNextArticleHeading,10);
        boolean isSameArticleDisplayed=commonFunctions.compareTexts(agleLekhText,nextArticleHeading);

        return agleLekhPadeFooterSectionDisplay && isReadNextArticleClickable && isReadNextArticleDisplayed && isSameArticleDisplayed ;

    }

    @Override
    public boolean checkURLShouldChangeWhileScrollingOnSlideStory(String slideStoryUrl) {
        boolean firstImage = false;
        boolean isUrlChanged = false;
        int count = 1;
        commonFunctions.navigateToURL(globalVars.getURL() + slideStoryUrl);
        String beforeSlideStoryClick = commonFunctions.getCurrentURL();
        for (int i = 0; i < slideStoryImages.size(); i++) {
            commonFunctions.scrollToViewElement(slideStoryImages.get(i), "Slide story image" + i, 10);
            commonFunctions.dummyWait(5);
            if (i == 0) {
                firstImage = commonFunctions.getCurrentURL().equalsIgnoreCase(beforeSlideStoryClick);
            } else {
                count++;
                isUrlChanged = commonFunctions.getCurrentURL().contains("slide" + count);
            }
        }
        return firstImage && isUrlChanged;
    }

    @Override
    public boolean checkBreadcrumbOnSlideStory(String slideStoryUrl) {
        return false;
    }
    public boolean checkTheListViewAndPagesNumberAtFooterOnTagPage()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        return commonFunctionsMobileLH.checkTheListViewAndPagesNumberAtFooterOnTagPage(firstPramukhStory,firstTag,tagPageHeading,listOnTagsPage,pagesNumberAtTagPage);
    }

    @Override
    public boolean checkSocialSharingOnSlideStory(String slideStoryUrl) {
        return false;
    }

    @Override
    public boolean checkAglaLekhFooterGetsHighlighted() {
        return false;
    }

    @Override
    public boolean checkSocialSharingRedirectionOnStoryDetailPage()
    {
        boolean facebookFlag = false,twitterFlag=false,followUsFlag = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollDownToElement(firstPramukhStory);
        commonFunctions.clickElementWithJS(firstPramukhStory, 10, commonFunctions.getElementText(firstPramukhStory, 5));
        commonFunctions.scrollToElement(facebookIcon,"Facebook icon");
        if(commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook share option")) {
            commonFunctions.clickElementWithJS(facebookIcon, 10, "FaceBook Icon");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            facebookFlag = commonFunctions.getCurrentURL().contains("facebook");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        commonFunctions.scrollToElement(twitterIcon,"Twitter icon");
        if(commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter share option")) {
            commonFunctions.clickElementWithJS(twitterIcon, 10, "Twitter");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsListss = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsListss.get(windowsListss.size() - 1));
            twitterFlag = commonFunctions.getCurrentURL().contains("twitter");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        commonFunctions.scrollToElement(humeFollowKarenIcon,"हमें फॉलो करें icon");
        if(commonFunctions.isElementDisplayed(humeFollowKarenIcon, 10, "हमें फॉलो करें  share option"))
        {
            commonFunctions.clickElementWithJS(humeFollowKarenIcon, 10, "Follow Us");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsLis = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsLis.get(windowsLis.size() - 1));
            followUsFlag = commonFunctions.getCurrentURL().contains("google");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        return facebookFlag && twitterFlag && followUsFlag;}
    public boolean checkHeadlineAndImageBylineOnStoryDetailPage()
    {
        clickFirstPramukhStory();
        boolean isHeadlineTextNotEmpty = !commonFunctions.getElementText(pageDetailStoriesHeading.get(0), 10).isEmpty();
        commonFunctions.scrollToElementView(storyImageByLines.get(0), 10, "First story by line");
        boolean isSummaryTextNotEmpty = !commonFunctions.getElementText(pageDetailStoriesSummary.get(0), 10).isEmpty();
        boolean isImageByLineDisplay = commonFunctions.isElementDisplayed(storyImageByLines.get(0), 10, "First story by line");
        return isHeadlineTextNotEmpty && isSummaryTextNotEmpty&&isImageByLineDisplay;
    }
}