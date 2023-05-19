package com.pages.LiveMint.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonMoneyPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage extends CommonMoneyPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsLM;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pagelogo;

    @FindBy(xpath = "//div[@id='hamburgerElement']")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//a[@class='wsj marZero']")
    private static WebElement WSJ;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaper;

    @FindBy(xpath = "(//a[@id='getAppId'])[1]")
    private static WebElement getAppCta;

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

    @FindBy(xpath = "//span[@id='mobNavTab']/a[1]")
    private static WebElement SubePaper;

    @FindBy(xpath = "//a[@class='getapp']")
    private static WebElement SubgetAppCta;


    public MoneyPage()
    {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsLM=CommonFunctionsMobileLM.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
    @Override
    public  boolean checkMoneyPagelayout() {
        commonFunctionsLM.navigateToPageThroughExploremenu(exploreMenu,MoneySection,"Money page");
         return commonFunctionsLM.checkMwebPagelout(pagelogo,exploreMenu,ePaper,getAppCta,PageTitle);
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
        commonFunctionsLM.navigateToPageThroughExploremenu(exploreMenu, MoneySection, "Money");
        commonFunctions.isElementDisplayed(PageTitle, 10, "Money Page Title displayed successfully");
        boolean checkSubscribedUserPageLayout = commonFunctions.checkWSJ(pagelogo, exploreMenu,SubePaper,SubgetAppCta);
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
