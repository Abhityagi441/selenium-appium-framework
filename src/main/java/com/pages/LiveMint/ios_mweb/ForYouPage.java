package com.pages.LiveMint.ios_mweb;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonForYouPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForYouPage extends CommonForYouPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonLoginPage loginPage;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(xpath = "//div[@class='btnSection clearfix']")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement ePaper;

    @FindBy(xpath = "//div[@class='headerDate']")
    private static WebElement timestamp;

    @FindBy(xpath = "//a[@class='icoBell iconSprite']")
    private static WebElement allowNotification;

    @FindBy(xpath = "(//a[@id='getAppId'])[1]")
    private static WebElement getAppCta;

    @FindBy(xpath = "//a[@class='userSignin epaperheader']")
    private static WebElement Signinlink;

    @FindBy(xpath = " //div[@class='offerMob']")
    private static WebElement Susbcribebutton;

    @FindBy(xpath = " //span[@class='blink']")
    private static WebElement Offertext;

    @FindBy(xpath=" //a[@id='fixedNav_home']")
    private static WebElement LHSHome;

    @FindBy(id="fixedNav_latest")
    private static WebElement LHSLatest;

    @FindBy(id="fixedNav_popular")
    private static WebElement LHSMarkets;

    @FindBy(xpath="//a[@id='exclusive']")
    private static WebElement LHSPremium;

    @FindBy(id="fixedNav_foryou")
    private static WebElement LHSForYou;

    @FindBy(xpath="//div[@id='trendingRHSFeed']")
    private static WebElement RHSTrending;

    @FindBy(xpath="//div[@id='latestRHSFeed']")
    private static WebElement RHSlatest;

    @FindBy(xpath="//div[@id='topicRHSFeed-primer']")
    private static WebElement RHSprimer;

    @FindBy(xpath="//div[@id='topicRHSFeed-long-story']")
    private static WebElement RHSlongstory;

    @FindBy(xpath="//div[@id='premiumRHSFeed']")
    private static WebElement RHSpremium;

    @FindBy(xpath="//div[@id='rhsPopularVideosNotAdFree']")
    private static WebElement RHSpopularvideos;

    @FindBy(xpath="//div[@id='sectionRHSFeed-companies']")
    private static WebElement RHScompanies;

    @FindBy(xpath="//div[@id='rhsWsjNotAdFree']")
    private static WebElement RHSwsj;

    @FindBy(xpath="//div[@id='personalFinance']")
    private static WebElement RHSpersonalfinance;

    @FindBy(xpath="//div[@id='rhsTrendingSticky']")
    private static WebElement RHStrendingsticky;

    @FindBy(xpath = "//a[@id='fixedNav_foryou']")
    private static WebElement ForYouNav;

    @FindBy(xpath = "//a[@class='userSignin epaperheader loggedin']")
    private static WebElement Myaccount;

    @FindBy(xpath = "//a[@class='getapp']")
    private static WebElement SUbgetapp;

    @FindBy(xpath = "//span[@class='mobNavTab']")
    private static WebElement SUbepaper;

    @FindBy(xpath = "//div[@class='headlineSec'][1]")
    private static WebElement ForUFirstStory;

    @FindBy(xpath = "//h2[@class='headline'][1]")
    private static WebElement ForUFrstStoryHeadline;
    @FindBy(xpath = "//img[@id='headerMintLogo']")
    private static WebElement mintLogo;
    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement MyAccount;


    public ForYouPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        loginPage = CommonLoginPage.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkForYouLayout() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(mintLogo, 10, "mint logo");
        commonFunctions.clickElementWithJS(exploreMenu, 10, "Click on Exp");
        if (commonFunctions.isElementDisplayedAndPresent(MyAccount, 20, "My account")) {
            loginPage.logout();
        }else {
            commonFunctions.pageRefresh();
        }
        commonFunctions.clickElement(ForYouNav, 10, "ForYouNav");
        commonFunctions.dummyWait(5);
        boolean isShowing = commonFunctions.isElementDisplayed(pageTitle, 10, "minlogo");
        isShowing &= commonFunctions.isElementDisplayed(exploreMenu, 10, "Exploremenu");
        isShowing &= commonFunctions.isElementDisplayed(ePaper, 10, "epaper");
        isShowing &= commonFunctions.isElementDisplayed(getAppCta, 10, "getAppCTA");
        return isShowing;
    }

    @Override
    public boolean checkFontSizeAtTopAndBottomOnStoryDetailPage() {
        return false;
    }

    @Override
    public boolean lHSNAVLinks(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(ForYouNav, 10, "ForYouNav");
        boolean Lhshome=commonFunctions.isElementDisplayed (LHSHome,10,"HOME Button");
        boolean Lshlatest=commonFunctions.isElementDisplayed (LHSLatest,10,"LATEST Button");
        boolean LshMarket=commonFunctions.isElementDisplayed (LHSMarkets,10,"MARKET Button");
        boolean Lshpremium=commonFunctions.isElementDisplayed (LHSPremium,10,"PREMIUM Button");
        boolean LshForyou=commonFunctions.isElementDisplayed (LHSForYou,10,"FOR YOY Button");

        if(Lhshome && Lshlatest && LshMarket && Lshpremium && LshForyou)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkForYouLayoutsubScribedUser(){
        return commonFunctions.checkForYouLayoutsubSub(pageTitle,exploreMenu,SUbepaper,SUbgetapp,Myaccount,ForYouNav);
    }

    @Override
    public boolean checklHSNAVLinksforSubscribeduser(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(ForYouNav,10,"ForYouNav");
        return commonFunctions.checklHSNAVLinksforSub(LHSHome,LHSLatest,LHSMarkets,LHSPremium,LHSForYou,ForYouNav);
    }

    @Override
    public boolean checkFirstStoryForYou() {
        commonFunctions.navigateToPageThroughTopNav(ForYouNav,"FOR YOU PAGE");
        return commonFunctions.checkStory(ForUFirstStory,ForUFrstStoryHeadline);
    }
    @Override
    public boolean checkFirstStoryForYouforSubscribedUser()
    {
        commonFunctions.navigateToPageThroughTopNav(ForYouNav,"FOR YOU PAGE");
        boolean story=commonFunctions.checkStory(ForUFirstStory,ForUFrstStoryHeadline);
        return story;
    }

    public boolean checkBannerStory() {
        return false;
    }

    public boolean checkForYouIconInactive(String forYouText) {
        return false;
    }

    public boolean checkShareAndBookmarkIconOnForYouPage() {
        return false;
    }

    public boolean checkShareAndBookmarkStoryDetailPage() {
        return false;
    }

    public boolean checkForYouPageAndIcon() {
        return false;
    }

    public boolean checkTextToSpeechOnStoryDetailPage() {
        return false;
    }

    public boolean checkAdOnStoryDetailPage() {
        return false;
    }

    public boolean checkForYouNoOfStories(String noOfStories) {
        return false;
    }
    public boolean checkAdsOnForYouPage(){
        return false;
    }
    public boolean rHSNAVLinks()
    {
        return false;
    }
    public boolean checkrHSNAVLinksforSubscribeduser() {return false;}





}
