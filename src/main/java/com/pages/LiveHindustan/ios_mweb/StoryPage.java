package com.pages.LiveHindustan.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class StoryPage extends CommonStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobileLH;

    @FindBy(xpath = "(//div[@class='sm-rght']/h3/a)[1]")
    private static WebElement homePageStory;

    @FindBy(xpath = "(//*[@class='page-hdng'])[1]")
    private static WebElement storyPageStory;

    @FindBy(xpath = "//a[@class='big-news-title']")
    private static WebElement firstPramukhStory;

    @FindBy(xpath = "(//small[@class='inner-txt'])[2]")
    private static WebElement agleLekhSection;

    @FindBy(xpath = "(//div[text()='RECOMMENDED'])[1]")
    private static WebElement recommendedSection;

    @FindBy(xpath = "//div[@class='shre-innr']")
    private static WebElement shareThruSocialMedia;

    @FindBy(xpath = "(//a[@class='nxt-Artcl'])[1]")
    private static WebElement aglelekhpadeText;

    @FindBy(xpath = "//*[@class='stry-shrt-head']")
    private static List<WebElement> summariesOnCurrentPage;

    @FindBy(xpath = "//article[contains(@class,'card-sm card-sm-devider')]//h3/a")
    private static List<WebElement> otherHomePageStoriesTitle;

    @FindBy(xpath = "(//div[@class='prlads'])[1]")
    private static WebElement firstAdFirstStory;

    @FindBy(xpath = "(//div[@class='prlads'])[1]/following-sibling::p")
    private static List<WebElement> paragraphsAfterFirstAd;

    @FindBy(xpath = "(//div[@class='prlads'])[2]")
    private static WebElement secoundAdFirstStory;

    @FindBy(xpath = "(//div[@class='stry-bdy'])[2]/p")
    private static List<WebElement> paragraphsAfterSecondAd;

    @FindBy(xpath = "(//div[@class='prlads'])[1]/preceding-sibling::p")
    private static List<WebElement> firstAdInStory;

    @FindBy(xpath = "//span[@class='livblg-btn']/ancestor::article/h1/a")
    private static List<WebElement> liveBlogStoryTitle;

    @FindBy(xpath = "//a[@title='वेब स्टोरी']")
    private static WebElement webStoryHomePage;

    @FindBy(xpath = "(//ul[@id='webStories']/li)[1]")
    private static WebElement webStoryStoryPage;

    @FindBy(xpath = "//div[@class='stry-imgblck']")
    private static List<WebElement> slideStoryImages;
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
    @FindBy(xpath = "//div[@class='tags']/a")
    private static List<WebElement> tagNameOnCurrentPage;
    @FindBy(xpath = "(//a[contains(@class,'shre-icn twt-icn')])[1]")
    private static WebElement twitterIcon;

    @FindBy(xpath = "(//a[contains(@class,'shre-icn fb-icn')])[1]")
    private static WebElement facebookIcon;

    @FindBy(xpath = "(//a[contains(@class,'gogle-follow shre-icn')])[1]")
    private static WebElement humeFollowKarenIcon;
    @FindBy(xpath = "//h1[@class='page-hdng']")
    private static List<WebElement> pageDetailStoriesHeading;
    @FindBy(xpath = "//div[@class='athr-info']")
    private static List<WebElement> storyImageByLines;
    @FindBy(xpath = "//h2[@class='stry-shrt-head']")
    private static List<WebElement> pageDetailStoriesSummary;
    @FindBy(xpath = "(//div[@class='articles']//h1)[2]")
    private static WebElement secondStoryOnStoryDetailPage;
    @FindBy(xpath = "//span[@class='brd-crum-last']")
    private static List<WebElement> breadcrumbsOnCurrentPage;
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
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkStoryDetailPage()
    {
        return false;
    }

    @Override
    public boolean checkStoryPageBreadcrumb()
    {
        commonFunctionsMobileLH.clickFirstPramukhStory(firstPramukhStory);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        String navigateURL = commonFunctions.getCurrentURL();
        String firstStoryTitle = commonFunctions.getElementText(pageDetailStoriesHeading.get(0), 10);
        String breadcrumsTextForFirstStory = commonFunctions.getElementText(breadcrumbsOnCurrentPage.get(0), 10);
        boolean breadCrumbRedirection = commonFunctionsMobileLH.isAllElementsClickableAndGiving200Status(storyDetailBreadCrumb,2,navigateURL,brdCrumRedFirst,brdCrumRedSecound,dummy);
        return breadCrumbRedirection && commonFunctions.compareTexts(firstStoryTitle, breadcrumsTextForFirstStory);
    }


    @Override
    public boolean checkStoryTags()
    {
        commonFunctionsMobileLH.clickFirstPramukhStory(firstPramukhStory);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctionsMobileLH.checkStoryTagsOnMweb(tagNameOnCurrentPage);
    }

    @Override
    public boolean checkAdFor2ndAnd3rdByNumberOfWords()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollDownToElement(firstPramukhStory);
        if (isItLiveBlogStory(firstPramukhStory)) {
            commonFunctions.scrollDownToElement(otherHomePageStoriesTitle.get(0));
            commonFunctions.clickElementWithJS(otherHomePageStoriesTitle.get(0), 10, "Other story titile from home page");
            commonFunctions.waitForPageToLoad();
        } else {
            commonFunctions.clickElementWithJS(firstPramukhStory, 20, "First story on Home page");
            commonFunctions.waitForPageToLoad();
        }
        commonFunctions.scrollToElementView(firstAdFirstStory, 10, "First Ad in first story");
        boolean is2ndAdCameAfter_120Words = getParagraphWordCount(paragraphsAfterFirstAd) > 120;
        commonFunctions.scrollToElementView(secoundAdFirstStory, 10, "Secound Ad in first story");
        boolean is3rdAdCameAfter_120Words = getParagraphWordCount(paragraphsAfterSecondAd) > 120;
        return is2ndAdCameAfter_120Words && is3rdAdCameAfter_120Words;
    }

    @Override
    public boolean checkFirstAdComesAfterFirstParagraph()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(firstPramukhStory,10,"Big news");
        commonFunctions.moveToElementWithActions(firstPramukhStory,10,"big news");
        commonFunctions.clickElementWithJS(firstPramukhStory,10,"big news");
        commonFunctions.dummyWait(5);
        return firstAdInStory.size() == 1;
    }

    @Override
    public boolean checkSummaryOfTheStoryPage()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(firstPramukhStory, 10, "First pramukh khabar on Home page");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        boolean summaryIsVisible = commonFunctions.isElementDisplayed(summariesOnCurrentPage.get(0), 10, "First story summary");
        boolean summaryIsNotEmpty = !commonFunctions.getElementText(summariesOnCurrentPage.get(0), 5).isEmpty();
        return summaryIsNotEmpty && summaryIsVisible;
    }

    @Override
    public boolean checkStoryPage()
    {
        return false;
    }

    @Override
    public boolean checkListingPageForNational()
    {
        return false;
    }


    @Override
    public boolean checkNextPageAppending()
    {
        commonFunctionsMobileLH.clickFirstPramukhStory(firstPramukhStory);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        for(int k =0;k<5;k++) {
            commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
            commonFunctions.dummyWait(1);
        }
        commonFunctions.scrollToElementView(firstSambandhitKhabreWidget, 10, "firstSambandhitKhabreWidget");
        commonFunctions.scrollToElementView(secondStoryOnStoryDetailPage, 10, "Second appended story with opened story detail page");
        return commonFunctions.isElementDisplayed(secondStoryOnStoryDetailPage, 10, "Second appended story with opened story detail page");
    }

    @Override
    public boolean checkStoryPageRHS()
    {
        return false;
    }

    @Override
    public boolean checkStoryPageOneTapFunctionality(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(homePageStory, "Home Page Story");
        String storyTitle=commonFunctions.getElementText(homePageStory, 10);
        commonFunctions.clickElementWithJS(homePageStory, 10);
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(storyPageStory, 20, "Story detail Page Story");
        boolean storyPage = commonFunctions.isElementPresent(storyPageStory, 10, "Story detail Page Story");
        boolean titleCom = isTextPresentInStoryPage(storyTitle, commonFunctions.getElementText(storyPageStory, 10));
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        boolean storyPageAfterLogin = commonFunctions.isElementPresent(storyPageStory, 10, "Story detail Page Story");
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
        return commonFunctionsMobileLH.checkListViewInSambahanditKhabreWidgetInStoryPagesOnMweb(firstPramukhStory, sambahanditKhabre, listOfSambahanditKhabre);
    }

    @Override
    public boolean checkAglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading() {
        boolean agleLekhPadeFooterSectionDisplay=commonFunctionsMobileLH.isReadNextArticleVisible(homePageStory,agleLekhSection,recommendedSection,aglelekhpadeText);
        boolean agleLekhPadeFooterSectionNotDisplayed=commonFunctionsMobileLH.aglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading(shareThruSocialMedia,aglelekhpadeText);

        return agleLekhPadeFooterSectionDisplay && agleLekhPadeFooterSectionNotDisplayed;
    }

    @Override
    public boolean checkAglaLekhInWebStoryPagesAsStickyBottom() {
        return false;
    }

    @Override
    public boolean checkURLShouldChangeWhileScrollingOnSlideStory(String slideStoryUrl) {
        boolean firstImage = false;
        boolean isUrlChanged = false;
        int count = 1;
        commonFunctions.navigateToURL(globalVars.getURL() + slideStoryUrl);
        String beforeSlideStoryClick = commonFunctions.getCurrentURL();
        for (int i = 0; i < slideStoryImages.size(); i++) {
            commonFunctions.scrollToViewElement(slideStoryImages.get(i), "Slide story image " + i, 10);
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
        return false;}

    @Override
    public boolean checkSocialSharingRedirectionOnStoryDetailPage()
    {
        boolean facebookFlag = false,twitterFlag=false,followUsFlag = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollDownToElement(firstPramukhStory);
        commonFunctions.clickElementWithJS(firstPramukhStory, 10, commonFunctions.getElementText(firstPramukhStory, 5));
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(pageDetailStoriesSummary.get(0),"Facebook icon");
        if(commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook share option")) {
            commonFunctions.clickElement(facebookIcon, 10, "FaceBook Icon");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            facebookFlag = commonFunctions.getCurrentURL().contains("facebook");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        commonFunctions.scrollToElement(pageDetailStoriesSummary.get(0),"Twitter icon");
        if(commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter share option")) {
            commonFunctions.clickElement(twitterIcon, 10, "Twitter");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsListss = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsListss.get(windowsListss.size() - 1));
            twitterFlag = commonFunctions.getCurrentURL().contains("twitter");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        commonFunctions.scrollToElement(pageDetailStoriesSummary.get(0),"हमें फॉलो करें icon");
        if(commonFunctions.isElementDisplayed(humeFollowKarenIcon, 10, "हमें फॉलो करें  share option"))
        {
            commonFunctions.clickElement(humeFollowKarenIcon, 10, "Follow Us");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsLis = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsLis.get(windowsLis.size() - 1));
            followUsFlag = commonFunctions.getCurrentURL().contains("google");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        return facebookFlag && twitterFlag && followUsFlag;
    }
    public boolean checkHeadlineAndImageBylineOnStoryDetailPage()
    {
        commonFunctionsMobileLH.clickFirstPramukhStory(firstPramukhStory);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(3);
        commonFunctions.scrollDownToElement(pageDetailStoriesHeading.get(0));
        boolean isHeadlineTextNotEmpty = !commonFunctions.getElementText(pageDetailStoriesHeading.get(0), 10).isEmpty();
        commonFunctions.scrollToElementView(storyImageByLines.get(0), 10, "First story by line");
        boolean isSummaryTextNotEmpty = !commonFunctions.getElementText(pageDetailStoriesSummary.get(0), 10).isEmpty();
        boolean isImageByLineDisplay = commonFunctions.isElementDisplayed(storyImageByLines.get(0), 10, "First story by line");
        return isHeadlineTextNotEmpty && isSummaryTextNotEmpty&&isImageByLineDisplay;
    }
}