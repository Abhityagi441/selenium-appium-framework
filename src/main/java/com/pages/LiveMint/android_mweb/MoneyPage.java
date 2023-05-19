package com.pages.LiveMint.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonMoneyPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MoneyPage extends CommonMoneyPage {
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

    @FindBy(xpath = "//span[@id='mobNavTab']/a[1]")
    private static WebElement SubePaper;

    @FindBy(xpath = " //a[@id='getAppId']")
    private static WebElement getAppCta;

    @FindBy(xpath = "//a[@class='getapp']")
    private static WebElement SubgetAppCta;

    @FindBy(id = "topnav-sign-in")
    private static WebElement Signinlink;

    @FindBy(xpath = " //div[@class='offerMob']")
    private static WebElement Susbcribebutton;

    @FindBy(xpath = "//span[@class='blink']")
    private static WebElement Offertext;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement PageTitle;

    @FindBy(xpath = "//li[@id='sectionp_money']")
    private static WebElement MoneySection;

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

    @FindBy(id="topnav-myaccount")
    private static WebElement Myaccount;

    @FindBy(xpath ="//div[@class='linkclick-candidate']")
    private static WebElement FirstStoryCarView;

    @FindBy(xpath = "//h2[@class='headline'][1]")
    private static WebElement FirstStoryHeadline;

public MoneyPage() {
    globalVars = GlobalVars.getInstance();
    driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    commonFunctions = CommonFunctionsMobile.getInstance();
    commonFunctionsLM = CommonFunctionsMobileLM.getInstance();
    // commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
    globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

    System.out.println("****************** Test started ******************");
    System.out.println("******************" + globalVars.getProjectName() + "******************");
}

    @Override
    public  boolean checkMoneyPagelayout()
    {
        commonFunctionsLM.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money page");
        boolean checkNonLoginPageLayout=commonFunctionsLM.checkMwebPagelout(pagelogo,exploreMenu,ePaper,getAppCta,PageTitle);
        commonFunctions.isElementDisplayed(Susbcribebutton,10,"Subscribe Now CTA");
        commonFunctions.isElementDisplayed(Offertext,10,"Offertext");
        commonFunctions.clickElementWithJS(exploreMenu,10,"Explore Menu");
        commonFunctions.isElementDisplayed(Signinlink,10,"Signin CTA");
        return checkNonLoginPageLayout;
    }

    @Override
    public  boolean checkTopNavLink()
    {
        commonFunctionsLM.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money Page");
        boolean checkNonLoginUserTopNav=commonFunctions.checkTopNAVLinksWSJ(TopHome,TopLatest,TopMarkets,TopPremium,TopForYou);
        commonFunctions.isElementDisplayed(PageTitle,10,"Money Page Title displayed successfully");
        return checkNonLoginUserTopNav;
    }

    @Override
    public boolean checMoneyPagelayoutSubscribedUSer()
    {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu, MoneySection, "Money");
        commonFunctions.isElementDisplayed(PageTitle, 10, "Money Page Title displayed successfully");
        boolean checkSubscribedUserPageLayout = commonFunctions.checkWSJ(pagelogo, exploreMenu, SubePaper,SubgetAppCta);
        commonFunctions.clickElement(exploreMenu,10,"click on exp");
        commonFunctions.isElementDisplayed(Myaccount,10,"Mayaccount CTA");
        return checkSubscribedUserPageLayout;
    }
    @Override
    public boolean checkFirstStoryMoney()
    {
        commonFunctionsLM.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money");
        commonFunctions.dummyWait(10);
        boolean story=commonFunctionsLM.checkStory(FirstStoryCarView,FirstStoryHeadline);
        return story;
    }
    public  boolean checklshMoneyPage(){
        return false;
    }
    public boolean checkrhsMoneyPage() { return false;}
     public boolean checklshMoneyPageforSubscribedUser()
    {
        return false;
    }
    public boolean checkrHSNAVLinksforSubscribeduserMoney() {
        return false;
    }
   public boolean checkFirstStoryMoneyforsubscribeusder()
    {
        return false;
    }
}
