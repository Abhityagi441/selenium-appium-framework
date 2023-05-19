package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPoliticsPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PoliticsPage extends CommonPoliticsPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;

    @FindBy(xpath = "//a[@title='Notification']/span")
    private static WebElement notificationBell;

    @FindBy(id = "noTCounter")
    private static WebElement notificationBadge;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static WebElement notificationHeading;

    @FindBy(id = "notification_new")
    private static WebElement notificationNew;

    @FindBy(id = "hamburgerElement")
    private static WebElement explore;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//nav[@id='leftNav']//li")
    private static List<WebElement> leftNavMenu;
    @FindBy(xpath = "//div[contains(@class,'rightAd')]")
    private static List<WebElement> rhsAds;
    @FindBy(xpath = "(//div[@class='rightHead clearfix'])")
    private static List<WebElement> rhsMenuHeaders;



    @FindBy(xpath = "//div[contains(@class,'rightAd')][1]")
    private static WebElement rhsTopAd;
    @FindBy(xpath = "(//a[@id='fixedNav_popular'])[1]")
    private static WebElement markets;
    @FindBy(xpath = "//li[@id='sectionp_politics']/a")
    private static WebElement politics;
    @FindBy(xpath = "//div[contains(@class,'desktopAd adSpace')]")
    private static WebElement headAdMarkets;
    @FindBy(xpath = "(//a[@href='/market'])[1]")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "//a[@id='topic_Stock Markets']")
    private static WebElement stockMarkets;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement marketsFirstHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement marketsSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement marketsSecondStory;
    @FindBy(xpath = "//div[@class='FirstEle']")
    private static WebElement firstPara;
    @FindBy(css = ".summary")
    private static WebElement summary;

    @FindBy(xpath = "(//div[@id='socialHolder'])[1]")
    private static WebElement iconsBox;

    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List<WebElement> iconsList;




    public PoliticsPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        apiValidation = ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkPoliticsPageLayout(String amp) {
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(explore, 10, "Explore Menu");
        commonFunctions.scrollToElement(politics, "Politics Section");
        boolean isShowing= commonFunctions.clickElementWithJS(politics, 10, "Politics Section");
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

    private boolean clickOnPoliticsSection(){
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(explore, 10, "Explore Menu");
        commonFunctions.scrollToElement(politics, "Politics Section");
        return commonFunctions.clickElement(politics, 10, "Politics Section");
    }

    @Override
    public boolean checkLHSMenuOnPoliticsPage() {
        clickOnPoliticsSection();
        boolean isShowing = commonFunctions.isElementDisplayedOfListOfElements(leftNavMenu, "Politics Page LHS Menu");
        for (int i = 0; i < leftNavMenu.size(); i++) {
            String elementText = leftNavMenu.get(i).getText();
            System.out.println(elementText + " is available");
        }
        return isShowing;
    }


    @Override
    public boolean checkRHSMenuOnPoliticsPage() {
        clickOnPoliticsSection();
        boolean isShowing = commonFunctions.isElementDisplayedOfListOfElements(rhsAds, "Politics Page RHS Ads");
        for (int i = 0; i < rhsAds.size(); i++) {
            String elementText = rhsAds.get(i).getText();
            System.out.println(elementText + " is available");
        }
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(rhsMenuHeaders, "Politics Page RHS Menu Headers");
        for (int i = 0; i < rhsMenuHeaders.size(); i++) {
            String elementText = rhsMenuHeaders.get(i).getText();
            System.out.println(elementText + " is available");
        }
        return isShowing;
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
        boolean isShowing=commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.scrollDown(politics);
        isShowing &=commonFunctions.clickElement(politics, 10, "Politics Section");
        isShowing &=commonFunctions.clickElement(firstStory, 10, "First Story");
        isShowing &=commonFunctions.scrollToViewElement(firstPara, "First Para", 15);
        return isShowing;
    }


    @Override
    public boolean checkSummaryOnPoliticsStoryPage() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.scrollDown(politics);
        isShowing &=commonFunctions.clickElement(politics, 10, "Politics Section");
        isShowing &=commonFunctions.clickElement(firstStory, 10, "First Story");
        isShowing &=commonFunctions.scrollToViewElement(summary, "Summary", 15);
        return isShowing;
    }



}


