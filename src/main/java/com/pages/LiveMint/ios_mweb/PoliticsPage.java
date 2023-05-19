package com.pages.LiveMint.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPoliticsPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PoliticsPage extends CommonPoliticsPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;
    private static ApiValidation apiValidation;

    @FindBy(xpath = "//a[@title='Notification']/span")
    private static WebElement notificationBell;

    @FindBy(id = "noTCounter")
    private static WebElement notificationBadge;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static WebElement notificationHeading;

    @FindBy(id = "notification_new")
    private static WebElement notificationNew;

    @FindBy(xpath = "(//div[@class='tableBox'])[1]//a[@class='newlink']")
    private static List <WebElement> nifty50IndicesList;
    @FindBy(xpath = "//section[2]//ol/li[1]")
    private static List<WebElement> indianIndiceList;

    @FindBy(xpath = "//button[@class='subscribe'][1]")
    private static WebElement doItLater;
    @FindBy(xpath = "//a[@id='fixedNav_foryou']")
    private static WebElement forYou;
    @FindBy(xpath = "//div[@class='offerMob']//a")
    private static WebElement subscribe;
    @FindBy(xpath = "//div[@class='offerMob']")
    private static WebElement offer;
    @FindBy(xpath = "(//a[@id='fixedNav_popular'])[1]")
    private static WebElement markets;
    @FindBy(xpath = "//div[@class='mobileAd']")
    private static WebElement headAdMarkets;
    @FindBy(xpath = "(//div[@class='listtostory clearfix'])[17]")
    private static WebElement marketsPageLStory;
    @FindBy(xpath = "(//div[@class='listtostory clearfix'])[28]")
    private static MobileElement marketsPage2Story;
    @FindBy(xpath = "//img[@id='headerMintLogo']")
    private static WebElement mintLogo;
    @FindBy(id = "hamburgerElement")
    private static WebElement explore;
    @FindBy(xpath = "//li[@id='sectionp_news']/a")
    private static WebElement news;
    @FindBy(xpath = "(//a[@href='/market'])[1]")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "//li[@id='sectionp_politics']")
    private static WebElement politics;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')]/div)[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement marketsFirstHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement marketsSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement marketsSecondStory;
    @FindBy(xpath = "(//div[@id='socialHolder'])[1]")
    private static WebElement iconsBox;
    @FindBy(xpath = "(//div[@class='linkclick-candidate'])[1]/figure")
    private static WebElement firstStoryImg;
    @FindBy(xpath = "//div[@class='FirstEle']")
    private static WebElement firstPara;
    @FindBy(xpath = "(//p[@class='summary'])[1]")
    private static WebElement summary;

    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List <WebElement> iconsList;

    @FindBy(xpath = "//a[@class='btnSearch clearfix']")
    private static WebElement search;
    @FindBy(xpath = "(//a[@href='/notifications'])[2]")
    private static WebElement notification;
    @FindBy(xpath = "(//span[@id='mobNavTab']/a)[1]")
    private static WebElement epaperIcon;
    @FindBy(xpath = "(//div[@class='fr'])[1]")
    private static WebElement myAccount;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;


    public PoliticsPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        apiValidation = ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }



    @Override
    public boolean checkPoliticsPageLayout(String amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(explore, 10, "Explore Menu");
        commonFunctions.scrollDownToElement(politics);
        boolean isShowing= commonFunctions.clickElementWithJS(politics, 20, "Politics Section");
        isShowing &=commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        String Headline= commonFunctions.getElementText(marketsFirstHeadline);
        String Header=commonFunctions.getElementText(marketsFirstHeadline);
        isShowing &=commonFunctions.checkTextContains(Header, Headline, "First Story verified card view");
        isShowing &=commonFunctions.isElementDisplayed(marketsSecondStory, 10, "Second Story");
        String Headline1= commonFunctions.getElementText(marketsSecondStory);
        String Heading=commonFunctions.getElementText(marketsSecondHeadline);
        isShowing &=commonFunctions.checkTextContains(Heading, Headline1, "Second Story verified list view");
        return isShowing;
    }

    @Override
    public boolean checkLHSMenuOnPoliticsPage() {
        return false;
    }

    @Override
    public boolean checkRHSMenuOnPoliticsPage() {
        return false;
    }

    @Override
    public boolean checkShareIconsPoliticsPage(String Amp) {
    commonFunctions.navigateToURL(globalVars.getURL());
    boolean isShowing=commonFunctionsWeb.checkShareIconsPolitics(explore, politics, firstStory, iconsBox, iconsList);
    return isShowing;
    }

    @Override
    public boolean checkParagraphOnPoliticsStoryPage() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctionsWeb.checkParagraphOnPoliticsPageStory(explore, politics, firstStoryImg, firstPara);

        return isShowing;
    }


    @Override
    public boolean checkSummaryOnPoliticsStoryPage() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctionsWeb.checkSummaryOnPoliticsPageStory(explore, politics, firstStoryImg, summary);

        return isShowing;
    }


}


