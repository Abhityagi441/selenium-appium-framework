package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonCompaniesPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CompaniesPage extends CommonCompaniesPage {
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
    @FindBy(id = "headerMintLogo")
    private static WebElement mintLogo;

    @FindBy(xpath = "//div[@title='Explore']")
    private static WebElement explore;
    @FindBy(xpath = "//li[@id='sectionsub_companies_start-ups']")
    private static WebElement startUps;
    @FindBy(xpath = "//li[@id='sectionp_companies']/a")
    private static WebElement companies;
    @FindBy(xpath = "(//div[@class='subnavArrow'])[1]")
    private static WebElement companiesExpand;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement epaper;
    @FindBy(xpath = "//a[@class='userSignin epaperheader']")
    private static WebElement signIn;
    @FindBy(xpath = "//div[@title='Search']")
    private static WebElement search;
    @FindBy(xpath = "//a[@title='Notification']")
    private static WebElement notification;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//li[contains(@id,'sectionsub_companies')]")
    private static List<WebElement> companiesSubSection;
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
    @FindBy(xpath = "//ul[@class='navCategories']//li[16]")
    private static WebElement politics;
    @FindBy(xpath = "//div[contains(@class,'desktopAd adSpace')]")
    private static WebElement headAdMarkets;
    @FindBy(xpath = "(//a[@href='/market'])[1]")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "//a[@id='topic_Stock Markets']")
    private static WebElement stockMarkets;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement marketsFirstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement firstStoryHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement secondStoryHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement secondStory;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "//div[@class='FirstEle']")
    private static WebElement firstPara;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement heading;
    @FindBy(xpath = "(//p[@class='summary'])[1]")
    private static WebElement summary;

    @FindBy(xpath = "(//div[@id='socialHolder'])[1]")
    private static WebElement iconsBox;

    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List <WebElement> iconsList;

    @FindBy(xpath = "//a[@alt='Notification']")
    private static List <WebElement> notificationIcon;

    @FindBy(xpath = "(//div[@title='Search'])[1]")
    private static WebElement searchIconOnHeader;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaperOnHeader;

    @FindBy(xpath = "//div[@title='Explore']")
    private static WebElement exploreOnTopNav;

    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
    private static WebElement signInIconOnHeader;



    public CompaniesPage() {
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
    public boolean checkCompaniesPageTopNav(String amp) {
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(explore, 10, "Explore Menu");
        commonFunctions.scrollToElement(companies, "Companies Section");
        boolean isShowing= commonFunctions.clickElement(companies, 10, "Companies Section");
        isShowing &=commonFunctions.isElementDisplayed(mintLogo, 10, "Mint Logo");
        isShowing &=commonFunctions.isElementDisplayed(epaper, 10, "Epaper");
        isShowing &=commonFunctions.isElementDisplayed(signIn, 10, "Sign In");
        isShowing &=commonFunctions.isElementDisplayed(search, 10, "Search");
        isShowing &=commonFunctions.isElementDisplayed(notification, 10, "Notification");
        return isShowing;
    }

    @Override
    public boolean checkCompaniesSection(String Link, String Amp) {
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(explore, 10, "Explore Menu");
        commonFunctions.scrollToElement(companies, "Companies Section");
        boolean isShowing= commonFunctions.clickElement(companies, 10, "Companies Section");
        commonFunctions.dummyWait(10);
        isShowing &=commonFunctions.checkPageUrlContainsText(Link, 10, "Companies Page Url");
        return isShowing;
    }

    @Override
    public boolean checkOpenAppButton(String Amp) {
        return false;
    }

    @Override
    public boolean checkOpenAppButtonInOpenStory(String Amp) {
        return false;
    }

    @Override
    public boolean checkShareIconsCompanieStoryPage(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsWeb.checkShareIconsOnCompaniesStory(explore, companies, firstStory, iconsBox, iconsList);
        return isShowing;
    }

    @Override
    public boolean checkCompaniesPageLayout(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsWeb.checkCompaniesPageLayout(explore, companies, firstStory, firstStoryHeadline, secondStory, secondStoryHeadline);
        return isShowing;
    }


    @Override
    public boolean checkSummaryOnCompaniesStoryPage() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.scrollToElementViewAndClick(companies, 10, "Companies");
        commonFunctions.clickElement(firstStory, 10, "First Story");
        commonFunctions.isElementDisplayed(summary, 10, "Story Page Summary");

        return isShowing;
    }


    @Override
    public boolean checkParagraphOnCompaniesStoryPage() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElement(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(companies, 10, "Companies");
        isShowing &=commonFunctions.clickElement(firstStory, 10, "First Story");
        isShowing &=commonFunctions.scrollToViewElement(firstPara, "First Para", 15);
        return isShowing;
    }



    @Override
    public boolean checkStartUpsSubSection() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElement(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(companiesExpand, 10, "Companies Expand");
        isShowing &=commonFunctions.isElementDisplayedOfListOfElements(companiesSubSection, "Companies Subsection");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctions.clickElement(startUps, 10, "Start Ups");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayed(heading,15, "StartUps Headline");
        return isShowing;
    }

    @Override
    public boolean checkStartUpsTopNav() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElement(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(companiesExpand, 10, "Companies Expand");
        isShowing &=commonFunctions.isElementDisplayedOfListOfElements(companiesSubSection, "Companies Subsection");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctions.clickElement(startUps, 10, "Start Ups");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayed(ePaperOnHeader,15, "StartUps Headline");
        isShowing &=commonFunctions.isElementDisplayed(searchIconOnHeader,15, "StartUps Headline");
        isShowing &=commonFunctions.isElementDisplayed(notificationIcon,15, "StartUps Headline");
        isShowing &=commonFunctions.isElementDisplayed(exploreOnTopNav,15, "StartUps Headline");
        isShowing &=commonFunctions.isElementDisplayed(signInIconOnHeader,15, "StartUps Headline");
        return isShowing;
    }

}


