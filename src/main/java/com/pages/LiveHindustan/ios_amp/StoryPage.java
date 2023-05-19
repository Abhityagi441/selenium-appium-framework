package com.pages.LiveHindustan.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class StoryPage extends CommonStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private CommonFunctionsMobileLH commonFunctionsMobileLH;

    @FindBy(xpath = "(//div[@class='newscardbig']/a)[1]")
    private static WebElement firstPramukhStory;

    @FindBy(xpath = "//h1[@class='stry-title']")
    private static List<WebElement> pageDetailStoriesHeading;

    @FindBy(xpath = "//h2[@class='sty-sht-head']")
    private static List<WebElement> pageDetailStoriesSummary;

    @FindBy(xpath = "//div[@class='shre-stick']//amp-social-share")
    private static List<WebElement> socialSharing;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[2]")
    private static WebElement breadCrumbText;

    @FindBy(xpath = "//div[@class='bread-crumbs']")
    private static WebElement breadCrumbs;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[1]")
    private static WebElement breadCrumbsHindiNews;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[2]")
    private static WebElement breadCrumbsCategory;

    @FindBy(xpath = "//div[@class='wdgt-hdng']/h1/a")
    private static WebElement breadCrumbsCategoryName;

    @FindBy(xpath = "//div[@class='wdgt-title']/h1/a")
    private static WebElement breadCrumbsNewCategoryName;

    @FindBy(xpath = "//div[@class='wdgt-title']/h1/a")
    private static WebElement breadCrumbsCategoryNameHomePage;

    @FindBy(id = "anchor-openapp")
    private static WebElement appPerPadhe;

    @FindBy(xpath = "//div[@id='track-rel-story']/h3/a")
    private static WebElement sambandhitKhabre;

    @FindBy(id = "whtspp-stick")
    private static WebElement whatsUpAmp;

    @FindBy(id = "fb-stick")
    private static WebElement facebookAmp;

    @FindBy(id = "twt-stick")
    private static WebElement twitterAmp;

    @FindBy(xpath = "//div[contains(@class, 'flw-us')]/a")
    private static WebElement followUsAmp;

    @FindBy(xpath = "(//div[@class='footersubTable']/span/a)[1]")
    private static WebElement newsWidgetSection;

    @FindBy(xpath = "(//*[contains(text(), 'amp_')])[last()]")
    private static WebElement ampLast;

    @FindBy(xpath = "//div[@class='hastag crsel']/a")
    private static List<WebElement> tagsList;

    @FindBy(xpath = "//a[@class='thembtn']")
    private static WebElement aurPadheOnAMP;

    @FindBy(xpath = "//div[@class='bread-crumbs']//span")
    private static WebElement FirstStoryHeadingInBreadCrumb;

    @FindBy(xpath = "//h1[@class='stry-title']")
    private static WebElement stroyTitle;
    @FindBy(xpath = "//div[@class='auth-info']")
    private static WebElement storyImageByLines;
    @FindBy(xpath = "//h2[@class='sty-sht-head']")
    private static WebElement summaryOnStoryPage;
    @FindBy(xpath = "//div[@id='track-rel-story']//div[@class='rlt-list list-view']")
    private static List<WebElement> listOfSambahanditKhabre;

    private static final String entertainmentHindi = "मनोरंजन";

    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkStoryDetailPage(){
        return false;
    }

    @Override
    public boolean checkStoryPageBreadcrumb(){
        clickFirstPramukhStory();
        boolean breadCrumbsflag = commonFunctions.isElementDisplayed(breadCrumbs, 10, "Bread Crumbs");
        boolean breadCrumbsCatflag = commonFunctions.clickBreadCrumbsAndVerifyLanding(breadCrumbsCategory, 10, commonFunctions.getElementText(breadCrumbsCategory, 10).trim(), breadCrumbsNewCategoryName);
        clickFirstPramukhStory();
        commonFunctions.isElementDisplayed(breadCrumbs, 10, "Bread Crumbs");
        commonFunctions.dummyWait(2);
        boolean breadCrumbsHomeflag = commonFunctions.clickBreadCrumbsAndVerifyLanding(breadCrumbsHindiNews, 10, "Hindi News", breadCrumbsCategoryNameHomePage);
        commonFunctions.dummyWait(5);
        boolean breadCrumbsUrlflag = commonFunctions.getCurrentURL().trim().equals(globalVars.getURL().trim());
        if(!breadCrumbsflag){
            Utils.logStepInfo("Bread Crumbs is not displaying");
        }

        if(!breadCrumbsCatflag){
            Utils.logStepInfo("Bread Crumbs category is not redirecting");
        }

        if(!breadCrumbsHomeflag){
            Utils.logStepInfo("Bread Crumbs Home is not redirecting");
        }

        if(!breadCrumbsUrlflag){
            Utils.logStepInfo("Home is not redirecting");
        }
        return breadCrumbsflag && breadCrumbsCatflag && breadCrumbsHomeflag && breadCrumbsUrlflag;
    }


    @Override
    public boolean checkStoryTags()
    {
        commonFunctionsMobileLH.clickFirstPramukhStory(firstPramukhStory);
        return commonFunctionsMobileLH.checkStoryTagsOnAMP(tagsList,firstPramukhStory);
    }

    @Override
    public boolean checkAdFor2ndAnd3rdByNumberOfWords(){return false;}

    @Override
    public boolean checkFirstAdComesAfterFirstParagraph(){return false;}

    @Override
    public boolean checkSummaryOfTheStoryPage() {
        commonFunctionsMobileLH.clickFirstPramukhStory(firstPramukhStory);
        boolean isSummaryVisible = commonFunctions.isElementDisplayed(summaryOnStoryPage, 5, "Summary on Story Page");
        boolean isSummaryNonEmpty = !commonFunctions.getElementText(summaryOnStoryPage).isEmpty();
        return isSummaryVisible && isSummaryNonEmpty;
    }

    @Override
    public boolean checkStoryPage(){return false;}

    @Override
    public boolean checkListingPageForNational(){return false;}
    

    @Override
    public boolean checkNextPageAppending(){return false;}

    @Override
    public boolean checkStoryPageRHS(){return false;}

    @Override
    public boolean checkStoryPageOneTapFunctionality(){return false;}

    @Override
    public boolean checkWebStoryDetailPage(){return false;}
    @Override
    public boolean checkUrlMustChange(){
        clickFirstPramukhStory();
        commonFunctions.dummyWait(5);
        String urlBeforScroll = commonFunctions.getCurrentURL();
        /*commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        //commonFunctions.scrollAccordingToGivenCount(1);
        commonFunctions.scrollToElement(sambandhitKhabre, 10, "Sambandhit Khabre");
        commonFunctions.dummyWait(5);*/
        commonFunctions.scrollAccordingToGivenCount(50);
        commonFunctions.dummyWait(5);
        if(commonFunctions.isElementPresentWithTryCatch(ampLast, 10, "ampLast")){
            commonFunctions.clickElementWithJSTryCatch(ampLast, 10, "ampLast");
        }
        commonFunctions.dummyWait(5);
        String urlAfterScroll = commonFunctions.getCurrentURL();
        return !urlBeforScroll.equals(urlAfterScroll);
    }

    @Override
    public boolean checkAurPadheButtonOnAmpStoryPage(){
        clickFirstPramukhStory();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollAccordingToGivenCount(2);
        commonFunctions.scrollToElement(sambandhitKhabre, 10, "Sambandhit Khabre");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollAccordingToGivenCount(50);
        commonFunctions.dummyWait(5);
        if(commonFunctions.isElementPresentWithTryCatch(ampLast, 10, "ampLast")){
            commonFunctions.clickElementWithJSTryCatch(ampLast, 10, "ampLast");
            commonFunctions.dummyWait(5);
            commonFunctions.scrollAccordingToGivenCount(50);
        }
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(aurPadheOnAMP, 10, "Aur Padhe On AMP");
        commonFunctions.clickElementWithJSTryCatch(aurPadheOnAMP, 10, "Aur Padhe On AMP");
        commonFunctions.dummyWait(5);

        String aurPadheUrl = commonFunctions.getCurrentURL();
        return aurPadheUrl.contains("-2") && !aurPadheUrl.contains("amp");
    }

    @Override
    public boolean checkAppPerPadheFunctionalityInstalled(){
        clickFirstPramukhStory();
        commonFunctions.waitForPageToLoad();
        boolean flag = commonFunctions.isElementDisplayed(appPerPadhe, 10, "App Per Padhe");
        flag &= commonFunctions.isElementClickable(appPerPadhe, 10, "App Per Padhe");
        return flag;
    }

    @Override
    public boolean checkAppPerPadheFunctionalityNotInstalled(){
        clickFirstPramukhStory();
        commonFunctions.waitForPageToLoad();
        boolean flag = commonFunctions.isElementDisplayed(appPerPadhe, 10, "App Per Padhe");
        flag &= commonFunctions.isElementClickable(appPerPadhe, 10, "App Per Padhe");
        return flag;
    }

    @Override
    public boolean checkRelatedNewsWidgetOnStoryDetail(){
        clickFirstPramukhStory();
        commonFunctions.scrollAccordingToGivenCount(5);
        boolean isSambhandhitKhabreDisplayed = commonFunctions.isElementDisplayed(sambandhitKhabre, 10, "Sambandhit Khabre");
        commonFunctions.scrollToElement(sambandhitKhabre, 10, "Sambandhit Khabre");
        boolean isSambhandhitKhabreTextMatches= commonFunctions.getElementText(sambandhitKhabre, 10).trim().equals("संबंधित खबरें");
        boolean isSambhanditKhabreHave8Stories = listOfSambahanditKhabre.size()==4;
        return isSambhandhitKhabreDisplayed && isSambhandhitKhabreTextMatches && isSambhanditKhabreHave8Stories;
    }
    public void clickFirstPramukhStory() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(firstPramukhStory);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(firstPramukhStory, 10, "First pramukh khabar on home page");
    }

    public boolean checkListViewInSambahanditKhabreWidgetInStoryPages()
    {
        return false;
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
    public boolean checkURLShouldChangeWhileScrollingOnSlideStory(String slideStoryUrl ) {
        return false;
    }

    @Override
    public boolean checkBreadcrumbOnSlideStory(String slideStoryUrl) {
        commonFunctions.navigateToURL(slideStoryUrl);
        commonFunctions.waitForPageToLoad();

        return commonFunctionsMobileLH.breadcrumbOnSlideStory(breadCrumbText,entertainmentHindi,FirstStoryHeadingInBreadCrumb,stroyTitle);
    }

    public boolean checkTheListViewAndPagesNumberAtFooterOnTagPage()
    {
        return false;
    }

    @Override
    public boolean checkSocialSharingOnSlideStory(String slideStoryUrl){
        commonFunctions.navigateToURL(commonFunctions.getURL() + slideStoryUrl);
        commonFunctions.dummyWait(10);
        return commonFunctionsMobileLH.socialSharingOnSlideStory(socialSharing);
    }

    @Override
    public boolean checkAglaLekhFooterGetsHighlighted() {
        return false;}

    @Override
    public boolean checkSocialSharingRedirectionOnStoryDetailPage()
    {
        boolean whatsUpAmpFlag = false;
        boolean facebookAmpFlag = false;
        boolean twitterAmpFlag = false;
        boolean followUsAmpFlag = false;
        try {
            clickFirstPramukhStory();
            commonFunctions.waitForPageToLoad();
            commonFunctions.scrollToElement(whatsUpAmp, 10, "Whats Up");
            commonFunctions.clickElementWithJS(whatsUpAmp, 10, "Whats Up");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            whatsUpAmpFlag = commonFunctions.getCurrentURL().contains("whatsapp");
            commonFunctions.closeAllWindowsExceptMasterTab();
            clickFirstPramukhStory();
            commonFunctions.scrollToElement(facebookAmp, 10, "Facebook");
            commonFunctions.clickElementWithJS(facebookAmp, 10, "Facebook");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsLists = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsLists.get(windowsLists.size() - 1));
            facebookAmpFlag = commonFunctions.getCurrentURL().contains("facebook");
            commonFunctions.closeAllWindowsExceptMasterTab();
            clickFirstPramukhStory();
            commonFunctions.scrollToElement(twitterAmp, 10, "Twitter");
            commonFunctions.clickElementWithJS(twitterAmp, 10, "Twitter");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsListss = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsListss.get(windowsListss.size() - 1));
            twitterAmpFlag = commonFunctions.getCurrentURL().contains("twitter");
            commonFunctions.closeAllWindowsExceptMasterTab();
            clickFirstPramukhStory();
            commonFunctions.scrollAccordingToGivenCount(1);
            commonFunctions.dummyWait(5);
            commonFunctions.clickElementWithAction(followUsAmp, 10, "Follow Us");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsLis = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsLis.get(windowsLis.size() - 1));
            followUsAmpFlag = commonFunctions.getCurrentURL().contains("google");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }catch(Exception e) {
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        return whatsUpAmpFlag && facebookAmpFlag && twitterAmpFlag && followUsAmpFlag;
    }
    public boolean checkHeadlineAndImageBylineOnStoryDetailPage()
    {
        clickFirstPramukhStory();
        boolean isHeadlineTextNotEmpty = !commonFunctions.getElementText(pageDetailStoriesHeading.get(0), 10).isEmpty();
        boolean isSummaryTextNotEmpty = !commonFunctions.getElementText(pageDetailStoriesSummary.get(0), 10).isEmpty();
        boolean isImageByLineDisplay = commonFunctions.isElementDisplayed(storyImageByLines, 10, "First story by line");
        return isHeadlineTextNotEmpty && isSummaryTextNotEmpty && isImageByLineDisplay;
    }
}