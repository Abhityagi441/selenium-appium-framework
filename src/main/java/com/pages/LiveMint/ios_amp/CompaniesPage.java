package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonCompaniesPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CompaniesPage extends CommonCompaniesPage {
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

    @FindBy(css = ".ampstart-btn.caps.m2")
    private static WebElement explore;
    @FindBy(xpath = "//a[@href='/amp-companies']")
    private static WebElement companies;
    @FindBy(xpath = "//img[@title='mint']")
    private static WebElement mintLogo;
    @FindBy(xpath = "//a[@class='epaper2']")
    private static WebElement epaper;
    @FindBy(xpath = "//a[@title='Sign In']")
    private static WebElement signIn;
    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getApp;
    @FindBy(xpath = "(//div[contains(@class,'listing')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//a[@class='imgSec'])[1]")
    private static WebElement firstStoryImg;
    @FindBy(xpath = "(//div[@class='mainArea']//p)[1]")
    private static WebElement firstPara;
    @FindBy(xpath = "(//h2[@class='headline'])[1]")
    private static WebElement firstStoryHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listing')])[2]")
    private static WebElement secondStory;
    @FindBy(xpath = "(//h2[@class='headline'])[2]")
    private static WebElement secondStoryHeadline;
    @FindBy(xpath = "//p[@class='summary']")
    private static WebElement summary;
    @FindBy(xpath = "(//section)[2]/h6")
    private static WebElement companiesExpand;
    @FindBy(xpath = "((//section)[2]//li)[2]/a")
    private static WebElement startUps;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement heading;



    @FindBy(xpath = "(//section)[2]//li")
    private static List<WebElement> companiesSubSection;

    @FindBy(xpath = "(//div[@class='gSpecs'])")
    private static List<WebElement> iconsList;

    @FindBy(xpath = "(//div[@class='share-icons-box']")
    private static WebElement iconsBox;



    @FindBy(xpath = "//button[@class='subscribe'][1]")
    private static WebElement doItLater;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//div[contains(@id,'hamburgerElement')]")
    private static WebElement exploreAmp;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaperOnHeader;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppOnHeader;

    @FindBy(xpath = "(//div[contains(@title,'Search')])[2]")
    private static WebElement searchIcon;


    public CompaniesPage() {
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
    public boolean checkCompaniesPageTopNav(String amp) {
        commonFunctions.navigateToURL(globalVars.getURL()+amp);
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "PopUp");
        boolean isShowing=commonFunctions.checkCompaniesPageTopNav(explore, companies, mintLogo, epaper, signIn, getApp);
        return isShowing;
    }


    @Override
    public boolean checkCompaniesSection(String Link, String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctions.checkCompaniesSectionPage(explore, companies);
        commonFunctions.checkPageUrlContainsText(Amp, 15, "Companies Page Url");
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
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctionsWeb.checkShareIconsOnCompaniesStory(explore, companies, firstStory, iconsBox, iconsList);
        return isShowing;
    }



    @Override
    public boolean checkCompaniesPageLayout(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctionsWeb.checkCompaniesPageLayout(explore, companies, firstStory, firstStoryHeadline, secondStory, secondStoryHeadline);
        return isShowing;
    }



    @Override
    public boolean checkSummaryOnCompaniesStoryPage() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing=commonFunctionsWeb.checkSummaryOnCompaniesPage(explore, companies, firstStoryImg, summary);
        return isShowing;
    }


    @Override
    public boolean checkParagraphOnCompaniesStoryPage() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing=commonFunctionsWeb.checkParagraphOnCompaniesStory(explore, companies, firstStoryImg, firstPara);

        return isShowing;
    }


    @Override
    public boolean checkStartUpsSubSection() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(companiesExpand, 10, "Companies Expand");
        isShowing &=commonFunctions.isElementDisplayedOfListOfWebElements(companiesSubSection, "Companies Subsection");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctions.clickElementWithJS(startUps, 10, "Start Ups");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayed(heading,15, "StartUps Headline");
        return isShowing;
    }

    @Override
    public boolean checkStartUpsTopNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(companiesExpand, 10, "Companies Expand");
        isShowing &=commonFunctions.isElementDisplayedOfListOfWebElements(companiesSubSection, "Companies Subsection");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctions.clickElementWithJS(startUps, 10, "Start Ups");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayed(exploreAmp,15, "Explore Icon Headline");
        isShowing &=commonFunctions.isElementDisplayed(getAppOnHeader,15, "Get App Icon Headline");
        isShowing &=commonFunctions.isElementDisplayed(searchIcon,15, "Search Icon Headline");
        isShowing &=commonFunctions.isElementDisplayed(ePaperOnHeader,15, "EPaper Icon Headline");
        return isShowing;
    }

}

