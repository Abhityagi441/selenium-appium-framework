package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPoliticsPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
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

    @FindBy(xpath = "//div[@class='clearfix']//button")
    private static WebElement explore;
    @FindBy(xpath = "//a[@href='/amp-news']")
    private static WebElement news;
    @FindBy(xpath = "//a[@data-vars-event-label='/market']")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "//a[@href='/amp-politics']")
    private static WebElement politics;
    @FindBy(xpath = "(//div[contains(@class,'listing')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement marketsFirstHeadline;
    @FindBy(xpath = "(//a[@class='imgSec'])[1]")
    private static WebElement firstStoryImg;
    @FindBy(xpath = "(//div[@class='mainArea']//p)[1]")
    private static WebElement firstPara;
    @FindBy(css = ".summary")
    private static WebElement summary;

    @FindBy(xpath = "(//div[@class='gSpecs'])")
    private static List<WebElement> iconsList;

    @FindBy(xpath = "(//div[@class='share-icons-box']")
    private static WebElement iconsBox;


    @FindBy(xpath = "//button[@class='subscribe'][1]")
    private static WebElement doItLater;

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
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "Do it Later popup");
        boolean isShowing= commonFunctions.isElementDisplayed(explore,10,"explore");
        isShowing &=commonFunctions.clickElementWithJS(explore,10,"explore" );
        commonFunctions.scrollToElement(politics, 15, "Politics Section");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.clickElement(politics, 10, "Politics");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        String Headline= commonFunctions.getElementText(firstStory);
        String Header=commonFunctions.getElementText(marketsFirstHeadline);
        isShowing &=commonFunctions.checkTextContains(Header, Headline, "First Story verified list view");
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
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctionsWeb.checkShareIconsPolitics(explore, politics, firstStory, iconsBox, iconsList);
        return isShowing;
    }

    @Override
    public boolean checkParagraphOnPoliticsStoryPage() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing=commonFunctionsWeb.checkParagraphOnPoliticsPageStory(explore, politics, firstStoryImg, firstPara);

        return isShowing;
    }


    @Override
    public boolean checkSummaryOnPoliticsStoryPage() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing=commonFunctionsWeb.checkSummaryOnPoliticsPageStory(explore, politics, firstStoryImg, summary);

        return isShowing;
    }



}

