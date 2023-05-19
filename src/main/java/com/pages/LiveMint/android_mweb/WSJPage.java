package com.pages.LiveMint.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonWSJPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WSJPage extends CommonWSJPage {
    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsLM;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pagelogo;

    @FindBy(id = "hamburgerElement")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//a[@class='wsj marZero']")
    private static WebElement WSJ;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaper;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppCta;

    @FindBy(xpath = "//a[@class='userSignin epaperheader']")
    private static WebElement Signinlink;

    @FindBy(xpath = " //div[@class='offerMob']")
    private static WebElement Susbcribebutton;

    @FindBy(xpath = "//span[@class='blink']")
    private static WebElement Offertext;

    @FindBy (id="showTopics")
    private static WebElement WsjPageTitle;

    @FindBy(id="fixedNav_home")
    private static WebElement TopHome;

    @FindBy(id="fixedNav_latest")
    private static WebElement TopLatest;

    @FindBy(id="fixedNav_popular")
    private static WebElement TopMarkets;

    @FindBy(xpath="//a[@id='exclusive']")
    private static WebElement TopPremium;

    @FindBy(id="fixedNav_foryou")
    private static WebElement TopForYou;

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

    @FindBy(xpath="//a[@id='fixedNav_foryou']")
    private static WebElement ForYouNav;

    @FindBy(xpath = "//a[@class='userSignin epaperheader loggedin']")
    private static WebElement Myaccount;

    @FindBy(xpath = "//a[@class='getapp']")
    private static WebElement SUbgetapp;

    @FindBy(xpath = "//span[@class='mobNavTab']")
    private static WebElement SUbepaper;

    @FindBy(xpath = "//div[@class='headlineSec'][1]")
    private static WebElement WsjFirstStory;

    @FindBy(xpath = "//h2[@class='headline'][1]")
    private static WebElement WsjFrstStoryHeadline;

    public WSJPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsLM= CommonFunctionsMobileLM.getInstance();
        // commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    public  boolean checkWSJPagelayout()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,WSJ,"wsj");
        boolean checkNonLoginPageLayout=commonFunctions.checkWSJ(pagelogo,exploreMenu,ePaper,getAppCta);
        commonFunctions.isElementDisplayed(Signinlink,10,"Signin CTA");
        commonFunctions.isElementDisplayed(Susbcribebutton,10,"Subscribe Now CTA");
        commonFunctions.isElementDisplayed(Offertext,10,"Offertext");

        return checkNonLoginPageLayout;
    }

    public  boolean checkTopNavLink()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,WSJ,"wsj");
        boolean checkNonLoginUserTopNavWsj=commonFunctions.checkTopNAVLinksWSJ(TopHome,TopLatest,TopMarkets,TopPremium,TopForYou);
        commonFunctions.isElementDisplayed(WsjPageTitle,10,"WSJ Page Title displayed successfully");
        return checkNonLoginUserTopNavWsj;

    }

    public  boolean checkWSJPagelayoutSubscribedUSer()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,WSJ,"wsj");
        boolean checkSubscribedUserPageLayout=commonFunctions.checkWSJ(pagelogo,exploreMenu,SUbepaper,SUbgetapp);
        commonFunctions.isElementDisplayed(Myaccount,10,"Myaccount CTA");
        commonFunctions.clickElement(Myaccount, 10, "MyAccount");
        commonFunctions.scrollToBottom();
        return checkSubscribedUserPageLayout;
    }

    public  boolean checkTopNavLinkSubscribeduser()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,WSJ,"wsj");
        boolean checkSubscribedUserTopNavWsj=commonFunctions.checkTopNAVLinksWSJ(TopHome,TopLatest,TopMarkets,TopPremium,TopForYou);
        commonFunctions.isElementDisplayed(WsjPageTitle,10,"WSJ Page Title displayed successfully");
        return checkSubscribedUserTopNavWsj;
    }

    @Override
    public boolean checkFirstStory()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,WSJ,"wsj");
        boolean story=commonFunctions.checkStory(WsjFirstStory,WsjFrstStoryHeadline);
        return story;
    }

    @Override
    public boolean checkFirstStoryWSjForSubscribedUser()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,WSJ,"wsj");
        commonFunctions.dummyWait(10);
        boolean story=commonFunctionsLM.checkStory(WsjFirstStory,WsjFrstStoryHeadline);

        return story;
    }

    public boolean checklshWSJPage()
    {
        return false;
    }
    public boolean checkrhsWSJPage()
    {
        return false;
    }
    public boolean checklshWSJPageforSubscribedUser()
    {
        return false;
    }
    public boolean checkrHSNAVLinksforSubscribeduserWsj()
    {
        return false;
    }

}

