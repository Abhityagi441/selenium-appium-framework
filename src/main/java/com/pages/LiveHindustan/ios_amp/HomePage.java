package com.pages.LiveHindustan.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.ConstantPackage.LHConstants;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class HomePage extends CommonHomePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private CommonFunctionsMobileLH commonFunctionsMobile;

    @FindBy(xpath = "(//div[@class='related-news'])[1]/div/a")
    private static List<WebElement> homePageWidgets;

    @FindBy(xpath = "//div[@class='newscardbig']/a")
    private static List<WebElement> allPramukhStoriesLink;

    @FindBy(xpath = "//div[@class='brnd-ads-new']")
    private static WebElement sponsoredLink;

    @FindBy(xpath = "(//div[@class='related-news'])[1]/div[@class='newscardbig' or @class='rlt-list']/a")
    private static List<WebElement> pramukhStoriesLink;

    @FindBy(xpath = "//small[@id='app-download']/a")
    private static WebElement headerDownload;

    @FindBy(xpath = "//small[@id='epaper-header']/a")
    private static WebElement headerEpaper;

    @FindBy(xpath = "//div[@class='section-title-logo']/div/a")
    private static WebElement liveLogo;

    @FindBy(xpath = "//div[@class='lhs-menu']/a")
    private static List<WebElement> topMenuOptions;

    @FindBy(xpath="//nav[@class='lhs-nav']")
    private static WebElement topSection;

    @FindBy(xpath = "//ul//a")
    private static List<WebElement> allLinksInHamburgerMenu;

    @FindBy(xpath = "//div[@class='logo']//i[@id='hamburger-open']")
    private static WebElement hamburgerMenuButton;

    @FindBy(xpath = "//amp-img[@role='button']/img[contains(@alt,'close sidebar')]")
    private static WebElement hamburgerCloseButton;

    @FindBy(xpath = "//div[@class='lhs-menu']/a[@title='न्यूज़ ब्रीफ']")
    private static WebElement newsBrefMenu;

    @FindBy(xpath = "//a[@class='lh-logo']")
    private static WebElement pageHeaderLogo;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile= CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkHeaderDisplay() {
        commonFunctions.navigateToURL(globalVars.getURL());
        return commonFunctions.isElementDisplayed(pageHeaderLogo,10,"Live Hindustan Logo");
    }

    @Override
    public boolean checkHomePageRHSWidgets() {
        return false;
    }

    @Override
    public boolean checkScrollOnHomePage() {
        return false;
    }

    @Override
    public boolean checkTopNevBar() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();

        commonFunctions.scrollToElement(headerDownload, "Download");
        boolean downloadDisplayStatus = commonFunctions.isElementDisplayed(headerDownload, 10, "Download");
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);

        boolean logoDisplayStatus = commonFunctions.isElementDisplayed(liveLogo, 10, "Logo");
        commonFunctions.clickElementWithJS(liveLogo, 10, "Logo Icon");
        commonFunctions.waitForPageToLoad();
        boolean logoClickStatus = commonFunctions.checkPageUrlContainsText("livehindustan", 10, "Logo Icon");
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);

        boolean epaperDisplayStatus = commonFunctions.isElementDisplayed(headerEpaper, 10, "EPaper");
        commonFunctions.clickElement(headerEpaper, 10, "EPaper Icon");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(10);
        Set<String> window = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        Iterator it = window.iterator();
        String windowId = (String) it.next();
        windowId = (String) it.next();
        driver.switchTo().window(windowId);
        commonFunctions.dummyWait(5);
        boolean epaperClickStatus = commonFunctions.checkPageUrlContainsText("epaper", 10, "EPaper Icon");
        commonFunctions.closeAllWindowsExceptMasterTab();

        return downloadDisplayStatus && logoDisplayStatus && logoClickStatus && epaperDisplayStatus && epaperClickStatus;

    }

    @Override
    public boolean checkWidgetOnHomePage() {
        return false;
    }




    @Override
    public boolean checkApkeLiaKhasWidgetsAndStoryClickable() {
        return false;
    }

    @Override
    public boolean checkTextToSpeechPlayAndPauseFunctionality() {
        return false;
    }

    @Override
    public boolean checkTopAdAndBottomAdLoadProperly() {
        return false;
    }

    @Override
    public boolean checkAllPageAreLoadingProperly() {
        return false;
    }

    @Override
    public boolean checkPhotoGalleryLandingPage() {
        return false;
    }

    @Override
    public boolean checkRHSAdLoadProperly() {
        return false;
    }

    @Override
    public boolean checkBetweenWidgetsAdsLoad() {
        return false;
    }

    @Override
    public boolean checkRFUApkeLiaKhasWidget() {
        return false;
    }

    @Override
    public boolean checkHomePageRFUWidgets() {
        return false;
    }
    @Override
    public boolean checkNumerologyPage() {
        return false;
    }

    @Override
    public boolean checkAstrologyLandingPageSubMenu() {
        return false;
    }

    @Override
    public boolean checkRHSWidgets() {
        return false;
    }

    @Override
    public boolean checkLiveBlogButtonOnHome() {
        return false;
    }

    @Override
    public boolean checkRefreshButtonOnLiveBlogDetailPage() {
        return false;
    }

    @Override
    public boolean checkLivBlogLiveUpdateButtonOnDetailPage() {
        return false;
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
    public boolean checkHomePageRhsAdLoad() {
        return false;
    }

    @Override
    public boolean checkMwebHomePageRfuWidget() {
        return false;
    }

    @Override
    public boolean checkMwebVideoLandingPage() {
        return false;
    }

    @Override
    public  boolean checkNewsBriefOnAmp(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(newsBrefMenu, "News Bref Menu");
        commonFunctions.clickElementWithJS(newsBrefMenu, 5, "News Bref Menu");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctions.getCurrentURL().contains("news-brief");
    }

    @Override
    public boolean checkIosAmpHomePage(){
        boolean flag=true;
        commonFunctions.navigateToURL(globalVars.getURL());
        waitForPageLoading(10);
        int size = homePageWidgets.size();
        for(int i=0;i<size;i++){
            commonFunctions.scrollToElement(homePageWidgets.get(i), 10, "Home Page Widgets");
            commonFunctions.dummyWait(2);
            flag &= commonFunctions.isElementClickable(homePageWidgets.get(i), 10, "Home Page Widgets");
        }
        return flag;
    }

    public boolean waitForPageLoading(int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            return wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean checkPramukhKhabreWidget(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        int pramukhStoriesSize = pramukhStoriesLink.size();
        boolean isAllElementClickableTrue = commonFunctionsMobile.isAllElementClickableAndReturns200(allPramukhStoriesLink, "WidgitValuesForRandomNumber");

        return pramukhStoriesSize==10 && isAllElementClickableTrue;
    }

    @Override
    public boolean checkTopMenuBar() {
        int topMenuSize=topMenuOptions.size();
        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(topSection,topMenuOptions,topMenuSize, "MenuValuesForRandomNumber");
    }

    @Override
    public boolean checkSeoContentOnThePages(){
        return false;
    }

    @Override
    public boolean checkAllTopicAreGiving200StatusCode() {
        return false;
    }

    @Override
    public boolean checkEntertainmentWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkPhotoGalleryWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkHindustanPahalLinkWidgetRedirectionAndStatusCodeIs200() {
        return false;
    }

    @Override
    public boolean checkDharmWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkCricketWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkNationalWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkBusinessWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkCareerWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkGadgetsWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkTopVideoWidgetIsHaving5StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkAutoWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkApnaSheherChuneWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkLifestyleWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkHTWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkLMWidgetIsHaving6StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkKhabrePhotoAndVideoShouldHaveNewsListedUnderItOnSearching(String searchKeyword,String section1,String section2,String section3) {
        return false;
    }

    @Override
    public boolean checkNewsBriefWidgetIsHaving7StoriesAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkRashifalWidgetIsHaving12RashiPresentAndStatusIs200() {
        return false;
    }

    @Override
    public boolean checkHomePageAndWidgets()
    {return false;}

    @Override
    public boolean checkInfiniteScrollingOnListingPage(){return false;}

}
