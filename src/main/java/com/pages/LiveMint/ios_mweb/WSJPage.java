package com.pages.LiveMint.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonWSJPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSJPage extends CommonWSJPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsLM;
    private static CommonLoginPage loginPage;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pagelogo;

    @FindBy(xpath = "//div[@id='hamburgerElement']")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//a[@class='wsj marZero']")
    private static WebElement WSJ;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaper;

    @FindBy(xpath = "//a[text()='Get APP']")
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
    @FindBy(xpath = "//img[@id='headerMintLogo']")
    private static WebElement mintLogo;
    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement MyAccount;
    @FindBy(xpath = "(//a[@id='getAppId'])[1]")
    private static WebElement getApp;

    public WSJPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsLM=CommonFunctionsMobileLM.getInstance();
        loginPage = CommonLoginPage.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
  @Override
    public  boolean checkWSJPagelayout() {
      commonFunctions.navigateToURL(globalVars.getURL());
      commonFunctions.clickElementWithJS(mintLogo, 10, "mint logo");
      commonFunctions.clickElementWithJS(exploreMenu, 10, "Click on Exp");
      if (commonFunctions.isElementDisplayedAndPresent(MyAccount, 20, "My account")) {
          loginPage.logout();
      } else {
          commonFunctions.pageRefresh();
      }
      boolean checkNonLoginPageLayout = commonFunctions.navigateToPageThroughExploremenu(exploreMenu, WSJ, "wsj");
      checkNonLoginPageLayout &= commonFunctions.checkWSJ(pagelogo, exploreMenu, ePaper, getApp);
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
        commonFunctions.isElementDisplayed(WsjPageTitle,10,"WSJ Page Title displayed successfully");
        boolean checkSubscribedUserPageLayout=commonFunctions.checkWSJ(pagelogo,exploreMenu,SUbepaper,getAppCta);
        return checkSubscribedUserPageLayout;

    }
    public  boolean checkTopNavLinkSubscribeduser() {
        boolean checkSubscribedUserTopNavWsj = commonFunctions.navigateToPageThroughExploremenu(exploreMenu, WSJ, "wsj");
        checkSubscribedUserTopNavWsj &= commonFunctions.isElementDisplayed(WsjPageTitle, 10, "WSJ Page Title displayed successfully");
        checkSubscribedUserTopNavWsj &= commonFunctions.checkTopNAVLinksWSJ(TopHome, TopLatest, TopMarkets, TopPremium, TopForYou);
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
