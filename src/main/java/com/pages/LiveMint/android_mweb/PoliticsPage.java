package com.pages.LiveMint.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPoliticsPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PoliticsPage extends CommonPoliticsPage {
    private static AndroidDriver<WebElement> driver;
    private static ApiValidation apiValidation;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;


    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(id = "moe-mobile_dontallow_button")
    private static WebElement DoNotAllow;
    @FindBy(xpath = "//img[@id='headerMintLogo']")
    private static WebElement mintLogo;
    @FindBy(id = "hamburgerElement")
    private static WebElement explore;
    @FindBy(xpath = "//li[@id='sectionp_politics']")
    private static WebElement politics;
    @FindBy(xpath = "//li[@id='sectionp_news']/a")
    private static WebElement news;
    @FindBy(xpath = "(//a[@href='/market'])[1]")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "//a[@class='btnSearch clearfix']")
    private static WebElement search;
    @FindBy(xpath = "(//a[@href='/notifications'])[2]")
    private static WebElement notification;
    @FindBy(xpath = "(//span[@id='mobNavTab']/a)[1]")
    private static WebElement epaperIcon;
    @FindBy(xpath = "(//div[@class='fr'])[1]")
    private static WebElement myAccount;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement marketsFirstHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement marketsSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement marketsSecondStory;
    @FindBy(xpath = "(//div[@id='socialHolder'])[1]")
    private static WebElement iconsBox;
    @FindBy(xpath = "(//div[@class='linkclick-candidate'])[1]")
    private static WebElement firstStoryImg;
    @FindBy(xpath = "//div[@class='FirstEle']")
    private static WebElement firstPara;
    @FindBy(css = ".summary")
    private static WebElement summary;

    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List<WebElement> iconsList;


    public PoliticsPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        apiValidation = ApiValidation.getInstance();

        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

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
        String Headline= commonFunctions.getElementText(firstStory);
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


