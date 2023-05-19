package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonMoneyPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage extends CommonMoneyPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsLM;

    @FindBy(xpath = "//a[@class='logo']")
    private static WebElement pagelogo;

    @FindBy(id = "hamburgerElement")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//li[@id='sectionp_money']")
    private static WebElement MoneySection;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaper;

    @FindBy(id = "showCurrentDateTime")
    private static WebElement timestamp;

    @FindBy(xpath = "//a[@class='icoBell iconSprite']")
    private static WebElement NotificationIcon;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppCta;

    @FindBy(xpath = "//a[@class='userSignin epaperheader']")
    private static WebElement Signinlink;

    @FindBy(xpath ="//div[@class='offerMob']")
    private static WebElement Susbcribebutton;

    @FindBy(xpath ="//span[@class='blink']")
    private static WebElement Offertext;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement PageTitle;
    @FindBy(xpath="//a[@id='fixedNav_home']")
    private static WebElement LHSHome;

    @FindBy(id="fixedNav_latest")
    private static WebElement LHSLatest;

    @FindBy(id="fixedNav_popular")
    private static WebElement LHSMarkets;

    @FindBy(xpath="//a[@id='exclusive']")
    private static WebElement LHSPremium;

    @FindBy(id="fixedNav_foryou")
    private static WebElement LHSForYou;

    @FindBy(id="fixedNav_watchlist")
    private static WebElement LHSWatchlist;


    @FindBy(xpath="//div[@id='RFUHomeFeed']")
    private static WebElement RHSRfu;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][1]")
    private static WebElement rhsTopAds;

    @FindBy(xpath="//div[@id='RFUHomeFeed']")
    private static WebElement RHSRFU;

    @FindBy(xpath="//div[@id='trendingRHSFeed']")
    private static WebElement RHSTrending;

    @FindBy(xpath="//div[@id='latestRHSFeed']")
    private static WebElement RHSlatest;

    @FindBy(xpath ="//div[@class='rightAd rightBlock'][2]")
    private static WebElement secondADSOnRHS;

    @FindBy(xpath="//div[@id='topicRHSFeed-primer']")
    private static WebElement RHSprimer;

    @FindBy(xpath="//div[@id='topicRHSFeed-long-story']")
    private static WebElement RHSlongstory;

    @FindBy(xpath ="//div[@class='rightAd rightBlock'][3]")
    private static WebElement thirdAdsOnRHS;

    @FindBy(xpath="//div[@id='premiumRHSFeed']")
    private static WebElement RHSpremium;

    @FindBy(xpath="//div[@id='sectionRHSFeed-market']")
    private static WebElement RHSMarket;

    @FindBy(xpath="//div[@id='rhsPopularVideosNotAdFree']")
    private static WebElement RHSpopularvideos;

    @FindBy(xpath ="//div[@class='rightAd rightBlock'][4]")
    private static WebElement fourthAdsOnRHS;

    @FindBy(xpath="//div[@id='sectionRHSFeed-companies']")
    private static WebElement RHScompanies;

    @FindBy(xpath ="//div[@class='rightAd rightBlock'][5]")
    private static WebElement fifthAdsOnRHS;

    @FindBy(xpath="//div[@id='rhsWsjNotAdFree']")
    private static WebElement RHSwsj;

    @FindBy(xpath="//div[@id='personalFinance']")
    private static WebElement RHSpersonalfinance;

    @FindBy(xpath="//div[@id='rhsTrendingSticky']")
    private static WebElement RHStrendingsticky;

    @FindBy(xpath ="//div[@class='rightAd rightBlock lastBlockAd']")
    private static WebElement StickyAdsOnRHS;

    @FindBy(xpath="//div[@id='rhsWsjNotAdFree']")
    private static WebElement RHSWSJWidget;

    @FindBy(xpath ="//a[contains(@class,'userSignin')]")
    private static WebElement Myaccount;

    @FindBy(xpath="//div[@id='RFUHomeFeed']")
    private static WebElement SubRHSRfu;

    @FindBy(xpath ="//div[@class='rightBlock']")
    private static WebElement Subpopularvideo;
    @FindBy(xpath = "//div[@id='rhsWSJ']")
    private static WebElement RHSSubWsj;

    @FindBy(xpath ="//div[@class='linkclick-candidate']")
    private static WebElement FirstStoryCarView;
    @FindBy(xpath = "//h2[@class='headline'][1]")
    private static WebElement FirstStoryHeadline;


    public MoneyPage()
    {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(driver, this);
        commonFunctions =CommonFunctionsWeb.getInstance();
        commonFunctionsLM= CommonFunctionsWebLM.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkMoneyPagelayout()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money");
        boolean checkNonLoginPageLayout=commonFunctionsLM.checkWSJ(pagelogo,exploreMenu,ePaper,NotificationIcon,timestamp,PageTitle);
        commonFunctions.isElementDisplayed(Signinlink,10,"SignIn CTA");
        commonFunctions.isElementDisplayed(Susbcribebutton,10,"Subscrib Now CTA");
        commonFunctions.isElementDisplayed(Offertext,10,"Offer Text");
        return checkNonLoginPageLayout;
    }

    @Override
    public boolean checklshMoneyPage()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money");
        boolean checkNonLoginUserLsh=commonFunctions.checklHSNAVLinksWSJ(LHSHome,LHSLatest,LHSMarkets,LHSPremium,LHSForYou);
        commonFunctions.isElementDisplayed(PageTitle,10,"Money Page Title displayed successfully");
        commonFunctions.isElementDisplayed(LHSWatchlist,10,"LHS Watchlist");
        return checkNonLoginUserLsh;
    }

    public boolean checkrhsMoneyPage() {

        commonFunctions.navigateToPageThroughExploremenu(exploreMenu, MoneySection, "Money");
        commonFunctions.isElementDisplayed(PageTitle, 10, "Money Page Title displayed successfully");
        boolean RHSWSJvisibil = commonFunctions.isElementDisplayed(rhsTopAds, 10, "RHS top ads visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSRfu, 10, "RHS RFU Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSTrending, 10, "RHS Trending Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSlatest, 10, "RHS Latest Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(secondADSOnRHS, 10, "Second RHS Ad Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSprimer, 10, "RHS Primer Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSlongstory, 10, "RHS Long Story Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(thirdAdsOnRHS, 10, "Third RHS Ad Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSpremium, 10, "RHS Premium Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSpopularvideos, 10, "RHS Popular Video Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(fourthAdsOnRHS, 10, "Fourth RHS Ad Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHScompanies, 10, "RHS Companies Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSWSJWidget, 10, "RHS WSJ Widget Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(fifthAdsOnRHS, 10, "Fifth RHS Ad Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHSpersonalfinance, 10, "RHS Personal Finance Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(RHStrendingsticky, 10, "RHS Trending Sticky Visibil");
        RHSWSJvisibil &= commonFunctions.isElementDisplayed(StickyAdsOnRHS, 10, "Sticky RHS Ad Visibil");
        return RHSWSJvisibil;
    }

    @Override
    public boolean checMoneyPagelayoutSubscribedUSer()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu, MoneySection, "Money");
        commonFunctions.dummyWait(10);
        commonFunctions.isElementDisplayed(PageTitle, 10, "Money Page Title displayed successfully");
        boolean checkSubscribedUserPageLayout = commonFunctions.checkWSJ(pagelogo, exploreMenu, ePaper, NotificationIcon, timestamp);
        commonFunctions.isElementDisplayed(Myaccount,10,"Mayaccount CTA");
        commonFunctions.clickElement(Myaccount, 10, "MyAccount");
        commonFunctions.scrollToBottom();
        return checkSubscribedUserPageLayout;
    }
    @Override
    public boolean checklshMoneyPageforSubscribedUser()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money");
        boolean checkSubscribedUserLshWsj=commonFunctions.checklHSNAVLinksWSJ(LHSHome,LHSLatest,LHSMarkets,LHSPremium,LHSForYou);
        commonFunctions.isElementDisplayed(PageTitle,10,"WSJ Page Title displayed successfully");
        commonFunctions.clickElement(Myaccount, 10, "MyAccount");
        commonFunctions.scrollToBottom();
        return checkSubscribedUserLshWsj;
    }
    @Override
    public boolean checkrHSNAVLinksforSubscribeduserMoney(){
        boolean RhsSubVisibil;
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money");
        commonFunctions.dummyWait(10);
        RhsSubVisibil =commonFunctions.isElementDisplayed(SubRHSRfu,10,"RHS RFU");
        RhsSubVisibil &=commonFunctions.isElementDisplayed (Subpopularvideo,10,"Sub RHS Popular Videos Widget");
        RhsSubVisibil &=commonFunctions.isElementDisplayed (RHSSubWsj,10,"Sub RHS WSJ Widget");
        commonFunctions.isElementDisplayed(PageTitle,10,"Money Page Title displayed successfully");
        commonFunctions.clickElement(Myaccount,10,"Myaccount");
        return RhsSubVisibil;
    }
    @Override
    public boolean checkFirstStoryMoney()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money");
        commonFunctions.dummyWait(10);
        boolean story=commonFunctionsLM.checkStory(FirstStoryCarView,FirstStoryHeadline);
        return story;
    }

    @Override
    public boolean checkFirstStoryMoneyforsubscribeusder()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money");
        commonFunctions.dummyWait(10);
        boolean story=commonFunctionsLM.checkStory(FirstStoryCarView,FirstStoryHeadline);
        return story;
    }
    @Override
    public  boolean checkTopNavLink(){
        return false;
    }
}
