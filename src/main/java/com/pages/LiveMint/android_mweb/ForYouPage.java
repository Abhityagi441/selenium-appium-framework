package com.pages.LiveMint.android_mweb;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonForYouPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class ForYouPage extends CommonForYouPage {
    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(xpath = "//div[@class='btnSection clearfix']")
    private static WebElement exploreMenu;

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

    @FindBy(xpath="//a[@class='active']")
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

    @FindBy(xpath="//a[@id='fixedNav_foryou']")
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


    public ForYouPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
      // commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkForYouLayout(){
         commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(ForYouNav,10,"ForYouNav");
        boolean mintlogo=commonFunctions.isElementDisplayed(pageTitle, 10,"minlogo");
        boolean Exploremenu=commonFunctions.isElementDisplayed(exploreMenu,10,"Exploremenu");
        boolean epaper=commonFunctions.isElementDisplayed(ePaper,10,"epaper");
       boolean getappcta=commonFunctions.isElementDisplayed(getAppCta,10,"getAppCTA");
       boolean signinlink=commonFunctions.isElementDisplayed(Signinlink ,10,"signinlink");

        if(mintlogo && Exploremenu &&epaper && signinlink && getappcta)
        {
            return true;
        }
        else
        { return false;
        }
    }



    @Override
    public boolean lHSNAVLinks(){
         boolean Lhshome=commonFunctions.isElementDisplayed (LHSHome,10,"HOME Button");
        boolean Lshlatest=commonFunctions.isElementDisplayed (LHSLatest,10,"LATEST Button");
        boolean LshMarket=commonFunctions.isElementDisplayed (LHSMarkets,10,"MARKET Button");
        boolean Lshpremium=commonFunctions.isElementDisplayed (LHSPremium,10,"PREMIUM Button");
        boolean LshForyou=commonFunctions.isElementDisplayed (LHSForYou,10,"FOR YOY Button");

        if(Lhshome && Lshlatest && LshMarket  && LshForyou && Lshpremium)
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
        boolean checklHSNAVLinksforSubLogin=commonFunctions.checklHSNAVLinksforSub(LHSHome,LHSLatest,LHSMarkets,LHSPremium,LHSForYou,ForYouNav);
        commonFunctions.clickElement(Myaccount,10,"Myaccount");
        commonFunctions.scrollToBottom();
        commonFunctions.dummyWait(20);

        if(checklHSNAVLinksforSubLogin )
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkFirstStoryForYou()
    {
        commonFunctions.navigateToPageThroughTopNav(ForYouNav,"FOR YOU PAGE");
        boolean story=commonFunctions.checkStory(ForUFirstStory,ForUFrstStoryHeadline);
        return story;
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
    public boolean rHSNAVLinks (){
        return false;
    }
    public boolean checkrHSNAVLinksforSubscribeduser() {return false;}

    @Override
    public boolean checkFontSizeAtTopAndBottomOnStoryDetailPage() {
        return false;
    }


}
