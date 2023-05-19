package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.android_mweb.LoginPage;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StoryPage extends CommonStoryPage {
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

    @FindBy(xpath = "(//div[@class='shre-innr'])[2]")
    private static WebElement shareOptions;

    @FindBy(xpath = "(//div[@class='owl-item active']//a)[2]")
    private static WebElement highlightStatus;

    @FindBy(xpath = "(//div[@class='owl-stage']//a)[2]")
    private static WebElement footerText;

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

    @FindBy(xpath = "//div[@class='stry-imgblck']")
    private static List<WebElement> slideStoryImages;

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

    @FindBy(xpath = "(//div[@class='stry-bdy'])[1]/child::div/following-sibling::*")
    private static List<WebElement> paragraphsAfterFirstAd;

    @FindBy(xpath = "(//div[@class='stry-bdy'])[1]/child::div[@class='ads']/following-sibling::p")
    private static List<WebElement> paragraphsAfterSecondAd;

    @FindBy(xpath = "(//div[@class='prlads'])[1]")
    private static WebElement firstAdFirstStory;

    @FindBy(xpath = "(//div[@class='prlads'])[1]/preceding-sibling::p")
    private static List<WebElement> firstAdInStory;

    @FindBy(xpath = "//*[@class='stry-shrt-head']")
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
    @FindBy(xpath = "//aside[@class='rhs-cont']//h2/span")
    private static List<WebElement> widgetsRHS;
    @FindBy(xpath = "//aside[@class='rhs-cont']//a")
    private static List<WebElement> widgetsRHSLinks;
    @FindBy(xpath = "(//div[@class='articles']//h1)[1]")
    private static WebElement viralNewsPageHeadingTitle;

    @FindBy(xpath = "//article[1]//div[contains(@class,'rfu-stry')]//div[@id='rfu-slider']")
    private static WebElement sambahanditKhabre;

    @FindBy(xpath = "//article[1]//div[contains(@class,'rfu-stry')]//div[@id='rfu-slider']//a")
    private static List<WebElement> listOfSambahanditKhabre;

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
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLH = CommonFunctionsWebLH.getInstance();
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

    @Override
    public boolean checkStoryDetailPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First story on Home page");
        boolean isHeadlineTextNotEmpty = !commonFunctions.getElementText(pageDetailStoriesHeading.get(0), 10).isEmpty();
        boolean isImageByLineDisplay = commonFunctions.isElementDisplayed(storyImageByLines.get(0), 10, "First story by line");
        boolean isAllContentComingProperly = allRHSWidgetsDisplay(firstStoryParagraphs);
        return isHeadlineTextNotEmpty && isImageByLineDisplay && isAllContentComingProperly;
    }

    @Override
    public boolean checkStoryPageBreadcrumb() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First story on Home page");
        String navigateURL = commonFunctions.getCurrentURL();
        String firstStoryTitle = commonFunctions.getElementText(pageDetailStoriesHeading.get(0), 10);
        String breadcrumsTextForFirstStory = commonFunctions.getElementText(breadcrumbsOnCurrentPage.get(0), 10);
        boolean breadCrumbRedirection = commonFunctionsWebLH.isAllElementsClickableAndGiving200Status(storyDetailBreadCrumb,2,navigateURL,brdCrumRedFirst,brdCrumRedSecound,dummy);
        return breadCrumbRedirection && commonFunctions.compareTexts(firstStoryTitle, breadcrumsTextForFirstStory);
    }

    @Override
    public boolean checkStoryTags() {
        boolean isFirstTagIsClickable = true;
        boolean isTagStatusCode200 = true;
        boolean isTagRedirectionCorrect = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First story on Home page");
        for(int i=0;i<tagNameOnCurrentPage.size();i++)
        {
            commonFunctions.scrollToElementView(tagNameOnCurrentPage.get(i), 10, tagNameOnCurrentPage.get(i).getText());
            String expectedURL = tagNameOnCurrentPage.get(i).getAttribute("href");
            isFirstTagIsClickable &= commonFunctions.isElementClickable(tagNameOnCurrentPage.get(i), 10, commonFunctions.getElementText(tagNameOnCurrentPage.get(i)));
            commonFunctions.clickElementWithJS(tagNameOnCurrentPage.get(i));
            commonFunctions.waitForPageToLoad();
            isTagStatusCode200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            isTagRedirectionCorrect &= commonFunctions.getCurrentURL().contains(expectedURL);
            commonFunctions.dummyWait(2);
            driver.navigate().back();
            commonFunctions.waitForPageToLoad();
        }
        return isFirstTagIsClickable && isTagStatusCode200 && isTagRedirectionCorrect;
    }

    @Override
    public boolean checkAdFor2ndAnd3rdByNumberOfWords() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First story on Home page");
        commonFunctions.waitForPageLoad();
        commonFunctions.scrollToElementView(firstAdFirstStory, 10, "First Ad in first story");
        boolean is2ndAdCameAfter_120Words = getParagraphWordCount(paragraphsAfterFirstAd) > 120;
        boolean is3rdAdCameAfter_120Words = getParagraphWordCount(paragraphsAfterSecondAd) > 120;
        return is2ndAdCameAfter_120Words && is3rdAdCameAfter_120Words;
    }

    @Override
    public boolean checkFirstAdComesAfterFirstParagraph() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on Home page");
        return firstAdInStory.size() == 1;
    }

    @Override
    public boolean checkSummaryOfTheStoryPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoad();
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on Home page");
        commonFunctions.waitForPageLoad();
        boolean summaryIsVisible = commonFunctions.isElementDisplayed(summariesOnCurrentPage.get(0), 10, "First story summary");
        boolean summaryIsNotEmpty = !commonFunctions.getElementText(summariesOnCurrentPage.get(0), 5).isEmpty();
        return summaryIsNotEmpty && summaryIsVisible;
    }

    @Override
    public boolean checkStoryPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on Home page");
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
    public boolean checkNextPageAppending() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on home page");
        commonFunctions.scrollToElementView(secondStoryOnStoryDetailPage, 10, "Second appended story with opened story detail page");
        return commonFunctions.isElementDisplayed(secondStoryOnStoryDetailPage, 10, "Second appended story with opened story detail page");
    }

    @Override
    public boolean checkStoryPageRHS() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoad();
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on home page");
        commonFunctions.waitForPageLoad();
        isAllElementClickable(widgetsRHS);
        commonFunctions.scrollToElementView(widgetsRHSLinks.get(0), 10, "Clickable widget");
        String widgetRHSLinkTitle = commonFunctions.getElementText(widgetsRHSLinks.get(0), 5).split(" ")[0];
        commonFunctions.clickElementWithJS(widgetsRHSLinks.get(0), 10, commonFunctions.getElementText(widgetsRHSLinks.get(0), 5));
        commonFunctions.waitForPageLoad();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.getElementText(viralNewsPageHeadingTitle, 5).contains(widgetRHSLinkTitle);
    }
    @Override
    public boolean checkListViewInSambahanditKhabreWidgetInStoryPages()
    {
        boolean sambahanditKhabreInListView = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on Home page");
        commonFunctions.waitForPageToLoad();
        commonFunctions.isElementPresent(sambahanditKhabre,10);
        Utils.logStepInfo("Sambahandit Khabre Widget is present");
        commonFunctions.scrollToViewElement(sambahanditKhabre,"ListInsambahanditKhabre",5);
        List<WebElement> countOfsambahanditKhabre = listOfSambahanditKhabre;
        if(countOfsambahanditKhabre.size()==4) {
            sambahanditKhabreInListView = true;
            return sambahanditKhabreInListView;
        }
        else
            return sambahanditKhabreInListView;
    }

    @Override
    public boolean checkAglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading() {
        return false;
    }

    @Override
    public boolean checkAglaLekhInWebStoryPagesAsStickyBottom() {
        return false;
    }

    @Override
    public boolean checkStoryPageOneTapFunctionality(){
        return false;
    }

    @Override
    public boolean checkWebStoryDetailPage(){
        return false;
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
        commonFunctions.clickElement(firstPramukhStory, 15, commonFunctions.getElementText(firstPramukhStory, 5));
        commonFunctions.dummyWait(5);
        commonFunctions.moveToElementWithActions(firstSambandhitKhabreWidget,10,"संबंधित खबरें Widget");
        commonFunctions.dummyWait(2);
        String actualText = firstSambandhitKhabreWidget.getText().trim();
        boolean isSambhanditKhabreWidgetPresent = commonFunctions.checkTextContains(actualText,"संबंधित खबरें",firstSambandhitKhabreWidget.getText());
        boolean isSambhanditKhabreHave4Stories = listOfSambahanditKhabre.size()==4;
        boolean isSambhanditKhabrePresent = commonFunctions.isElementDisplayed(firstSambandhitKhabreWidget, 10, commonFunctions.getElementText(firstSambandhitKhabreWidget, 5));
        return isSambhanditKhabreWidgetPresent && isSambhanditKhabreHave4Stories && isSambhanditKhabrePresent;
    }
    @Override
    public boolean checkUrlMustChange(){
        return false;
    }
    @Override
    public boolean checkAurPadheButtonOnAmpStoryPage(){
        return false;
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

    public boolean landingOnRashtreeyKhabreyPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, "देश");
        clickElementWithGivenText(allSubOptionOnDharamPage, "राष्ट्रीय खबरें");
        return commonFunctions.getCurrentURL().contains("/national");
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

    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElement(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public boolean isAllElementClickable(List<WebElement> elementList) {
        boolean isAllelementClickableTrue = true;
        for (WebElement ele : elementList) {
            commonFunctions.moveToElementWithActions(ele, 10, commonFunctions.getElementText(ele, 5));
            if (commonFunctions.isElementClickable(ele, 10, "Pramukh stories")) {
                isAllelementClickableTrue &= true;
            } else {
                isAllelementClickableTrue &= false;
            }
        }
        return isAllelementClickableTrue;
    }

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
    @Override
    public boolean checkTheListViewAndPagesNumberAtFooterOnTagPage()
    {
        boolean isListPresentOnTagsPage = false;
        boolean isPagesNumberAtTagPagePresent = false;
        commonFunctions.clickElement(firstPramukhStory, 10, "First story on Home page");
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollUsingAction(firstTag,"First Tag on Story Page");
        String tagText = firstTag.getText();
        commonFunctions.clickElement(firstTag,5);
        commonFunctions.waitForPageToLoad();
        boolean isTagTextSame = commonFunctions.checkTextContains(tagText,commonFunctions.getElementText(tagPageHeading),"Tag Page Heading");
        if(listOnTagsPage.size()==10)
        {
            isListPresentOnTagsPage = commonFunctions.isElementDisplayedAndPresent(listOnTagsPage,10,"List view on Tag page");
        }
        if(pagesNumberAtTagPage.size()==4)
        {
            isPagesNumberAtTagPagePresent = commonFunctions.isElementDisplayedAndPresent(pagesNumberAtTagPage,10,"Pages Number on Tag page");
        }
        return isTagTextSame && isListPresentOnTagsPage && isPagesNumberAtTagPagePresent;
    }

    @Override
    public boolean checkSocialSharingOnSlideStory(String slideStoryUrl) {
        return false;
    }
    @Override
    public boolean checkSocialSharingRedirectionOnStoryDetailPage()
    {
        boolean facebookFlag = false,twitterFlag=false,followUsFlag = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(firstPramukhStory, 10, commonFunctions.getElementText(firstPramukhStory));
        if(commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook share option")) {
            commonFunctions.dummyWait(5);
            commonFunctions.clickElementWithJS(facebookIcon, 10, "FaceBook Icon");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            facebookFlag = commonFunctions.getCurrentURL().contains("facebook");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        if(commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter share option")) {
            commonFunctions.clickElementWithJS(twitterIcon, 10, "Twitter Icon");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsListss = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsListss.get(windowsListss.size() - 1));
            twitterFlag = commonFunctions.getCurrentURL().contains("twitter");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        if(commonFunctions.isElementDisplayed(humeFollowKarenIcon, 10, "हमें फॉलो करें  share option"))
        {
            commonFunctions.clickElementWithJS(humeFollowKarenIcon, 10, "Follow Us Icon");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsLis = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsLis.get(windowsLis.size() - 1));
            followUsFlag = commonFunctions.getCurrentURL().contains("google");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        return facebookFlag && twitterFlag && followUsFlag;
    }

    @Override
    public boolean checkAglaLekhFooterGetsHighlighted() {
        boolean storyStatus=false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(firstPramukhStory, 10, "Story on Home page");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElementView(shareOptions,10,"sharing options");
        commonFunctions.dummyWait(5);
        commonFunctions.moveToElementWithActions(footerText,10,"footer");
        String storyActiveStatus=commonFunctions.getAttributeValue(highlightStatus,10,"class");
        if(storyActiveStatus.equals("card-sm activebg"))
            storyStatus=true;
        return storyStatus;
    }

    public boolean checkHeadlineAndImageBylineOnStoryDetailPage()
    {
        return false;
    }

}