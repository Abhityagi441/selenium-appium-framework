package com.pages.LiveMint.web;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonForYouPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class ForYouPage extends CommonForYouPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsLM;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(xpath = "//div[@class='btnSection clearfix']")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaper;

    @FindBy(xpath = "//div[@class='headerDate']")
    private static WebElement timestamp;

    @FindBy(xpath = "//a[@class='icoBell iconSprite']")
    private static WebElement allowNotification;

    @FindBy(xpath = "//a[@class='userSignin epaperheader']")
    private static WebElement Signinlink;

    @FindBy(xpath = "//div[@class='offerHead']")
    private static WebElement Susbcribebutton;

    @FindBy(xpath = "//span[@class='blink']")
    private static WebElement Offertext;

    @FindBy(id="adfreeDeskSpace")
    private static WebElement mastHeadAdspace;

    @FindBy(id="rhs-ad-0")
    private static WebElement RHSTopAdContainer;

    @FindBy(xpath=" //a[@class='active']")
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

    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
    private static WebElement singInButton;

    @FindBy(xpath = "//a[@class='userSignin epaperheader loggedin']")
    private static WebElement Myaccount;

   @FindBy(xpath = "//a[@id='fixedNav_foryou']")
   private static WebElement ForuYou;

    @FindBy(xpath = "//div[@id='myAccount']/a[text()='Logout']")
    private static WebElement LogoutButton;

    @FindBy(xpath = "//div[@class='rightBlock']")
    private static WebElement Subpopularvideo;

    @FindBy(xpath = "//div[@id='rhsWSJ']")
    private static WebElement SubWSJ;

    @FindBy(xpath = "//div[@class='headlineSec'][1]")
    private static WebElement ForUFirstStory;

    @FindBy(xpath = "//h2[@class='headline'][1]")
    private static WebElement ForUFrstStoryHeadline;

    public ForYouPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsLM= CommonFunctionsWebLM.getInstance();

       // commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


@Override
public boolean checkForYouLayout(){
    commonFunctions.navigateToURL(globalVars.getURL());
    commonFunctions.clickElement(ForuYou,10,"ForYouNav");
    boolean mintlogo=commonFunctions.isElementDisplayed(pageTitle, 10,"minlogo");
    boolean Exploremenu=commonFunctions.isElementDisplayed(exploreMenu,10,"Exploremenu");
    boolean epaper=commonFunctions.isElementDisplayed(ePaper,10,"epaper");
    boolean datestam=commonFunctions.isElementDisplayed(timestamp,20,"datestam");
    boolean notification=commonFunctions.isElementDisplayed(allowNotification ,10,"notification");
    boolean signinlink=commonFunctions.isElementDisplayed(Signinlink ,10,"signinlink");

        if(mintlogo && Exploremenu &&epaper && datestam &&notification &&signinlink)
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
    public boolean rHSNAVLinks(){

        boolean RhsTrending=commonFunctions.isElementDisplayed (RHSTrending,10,"RHS Trending widget");
        boolean Rshlatest=commonFunctions.isElementDisplayed (RHSlatest,10,"RHS LATEST Widget");
        boolean Rhsprimer=commonFunctions.isElementDisplayed (RHSprimer,10,"RHS Primer Widget");
        boolean Rhslongstory=commonFunctions.isElementDisplayed (RHSlongstory,10,"RHS Long Story Widget");
        boolean Rhspremium=commonFunctions.isElementDisplayed (RHSpremium,10,"RHS Premium Widget");
        boolean Rhspopularvideo=commonFunctions.isElementDisplayed (RHSpopularvideos,10,"RHS Popular Videos Widget");
        boolean Rhscompnies=commonFunctions.isElementDisplayed (RHScompanies,10,"RHS Companies Widget");
        boolean Rhswsj=commonFunctions.isElementDisplayed (RHSwsj,10,"RHS WSJ Widget");
        boolean Rhspersonalfinance=commonFunctions.isElementDisplayed (RHSpersonalfinance,10,"RHS Personal Finance Widget");
        boolean Rhstrendingsticky=commonFunctions.isElementDisplayed (RHStrendingsticky,10,"RHS Trending Sticky Widget");


        if(RhsTrending && Rshlatest && Rhsprimer  && Rhslongstory && Rhspremium && Rhspopularvideo && Rhscompnies && Rhswsj && Rhspersonalfinance && Rhstrendingsticky)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkForYouLayoutsubScribedUser(){

        boolean checkForYouLayoutsubSubUserLogin=commonFunctions.checkForYouLayoutsubSub(pageTitle,exploreMenu,ePaper,timestamp,allowNotification,Myaccount,ForuYou);
        commonFunctions.clickElement(Myaccount,10,"MyAccount");
        commonFunctions.scrollToBottom();

        if(checkForYouLayoutsubSubUserLogin)
        {
            return true;
        }
        else
        { return false;
        }
    }

    @Override
    public boolean checklHSNAVLinksforSubscribeduser(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(ForuYou,10,"ForYouNav");
        boolean checklHSNAVLinksforSubLogin=commonFunctions.checklHSNAVLinksforSub(LHSHome,LHSLatest,LHSMarkets,LHSPremium,LHSForYou,ForuYou);
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
    public boolean checkrHSNAVLinksforSubscribeduser(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(ForuYou,10,"ForYouNav");
        boolean Rhspopularvideo=commonFunctions.isElementDisplayed (Subpopularvideo,10,"Sub RHS Popular Videos Widget");
        boolean Rhswsj=commonFunctions.isElementDisplayed (SubWSJ,10,"Sub RHS WSJ Widget");
        commonFunctions.clickElement(Myaccount,10,"Myaccount");
        commonFunctions.scrollToBottom();
        if(Rhspopularvideo && Rhswsj)
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
        commonFunctionsLM.navigateToPageThroughLhsNav(ForuYou,"FOR YOU PAGE");
        boolean story=commonFunctionsLM.checkStory(ForUFirstStory,ForUFrstStoryHeadline);
        return story;
    }

    @Override
    public boolean checkFirstStoryForYouforSubscribedUser()
    {
        commonFunctionsLM.navigateToPageThroughLhsNav(ForuYou,"FOR YOU PAGE");
        boolean story=commonFunctionsLM.checkStory(ForUFirstStory,ForUFrstStoryHeadline);
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

    @Override
    public boolean checkFontSizeAtTopAndBottomOnStoryDetailPage() {
        return false;
    }
}
