package com.pages.LiveMint.ios_amp;

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

    @FindBy(xpath = "//a[@class='logo']")
    private static WebElement pagelogo;

    @FindBy(xpath = "//button[@class='ampstart-btn caps m2']")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//a[@class='epaper2']")
    private static WebElement ePaper;

    @FindBy(xpath = "//div[@class='headerDate']")
    private static WebElement timestamp;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppCta;

    @FindBy(xpath = "//a[@class='ml15 epaper2 signin']")
    private static WebElement Signinlink;

    @FindBy(xpath = "//div[@class='offerMob']")
    private static WebElement Susbcribebutton;

    @FindBy(xpath = "//span[@class='blink']")
    private static WebElement Offertext;

    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement PageTitle;

    @FindBy(xpath = "//a[@href='/amp-money']")
    private static WebElement MoneySection;

    @FindBy(xpath = "//button[@class='subscribe'][1]")
    private static WebElement Idothislater;

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

    @FindBy(xpath ="//h2[@class='headline']")
    private static WebElement FirstStoryCarView;

    @FindBy(xpath = "//div[@class='headlineSec']")
    private static WebElement FirstStoryHeadline;

    public MoneyPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>)  globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
    @Override
    public  boolean checkMoneyPagelayout()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(exploreMenu,10,"explore");
        commonFunctions.scrollToElementView(MoneySection,10,"Money");
        commonFunctions.clickElementWithJS(MoneySection,10,"Money");
        commonFunctions.dummyWait(10);
        boolean checkNonLoginPageLayout=commonFunctions.isElementDisplayed(pagelogo,10,"Logo");
        checkNonLoginPageLayout &=commonFunctions.isElementDisplayed(exploreMenu,10,"Explor Menu");
        checkNonLoginPageLayout &=commonFunctions.isElementDisplayed(ePaper,10,"E-paper");
        checkNonLoginPageLayout &=commonFunctions.isElementDisplayed(getAppCta,10,"getapp");
        checkNonLoginPageLayout &=commonFunctions.isElementDisplayed(PageTitle,10,"pagetitle");
       checkNonLoginPageLayout &=commonFunctions.isElementDisplayed(Signinlink,10,"Signin CTA");
        checkNonLoginPageLayout &= commonFunctions.isElementDisplayed(Susbcribebutton,10,"Subscribe Now CTA");
        checkNonLoginPageLayout &=commonFunctions.isElementDisplayed(Offertext,10,"Offertext");
        return checkNonLoginPageLayout;

    }
    @Override
    public  boolean checkTopNavLink()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(Idothislater,10,"I do later Notification");
        commonFunctions.clickElement(exploreMenu,10,"exp");
        commonFunctions.clickElement(MoneySection,10,"Money");
        commonFunctions.dummyWait(10);
        boolean checkNonLoginUserTopNav=commonFunctions.checkTopNAVLinksWSJ(TopHome,TopLatest,TopMarkets,TopPremium,TopForYou);
        commonFunctions.isElementDisplayed(PageTitle,10,"Money Page Title displayed successfully");
        return checkNonLoginUserTopNav;
    }
    @Override
    public boolean checkFirstStoryMoney()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
       // commonFunctions.clickElement(Idothislater,10,"I do later Notification");
        commonFunctions.clickElement(exploreMenu,10,"exp");
        commonFunctions.scrollToElementView(MoneySection,10,"Money");
        commonFunctions.clickElement(MoneySection,10,"Money");
        commonFunctions.dummyWait(10);
        boolean story=commonFunctionsLM.checkStory(FirstStoryCarView,FirstStoryHeadline);
        return story;
    }
    public  boolean checklshMoneyPage(){
        return false;
    }
    public boolean checkrhsMoneyPage() { return false;}
    public boolean checMoneyPagelayoutSubscribedUSer()
    {
        return false;
    }
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
