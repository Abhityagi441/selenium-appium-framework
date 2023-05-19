package com.pages.LiveMint.ios_mweb;

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

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(id = "headerMintLogo")
    private static WebElement mintLogo;

    @FindBy(xpath = "//div[@class='openinApp']")
    private static WebElement openApp;
    @FindBy(xpath = "//div[@class='icoMenu']")
    private static WebElement explore;
    @FindBy(xpath = "//li[@id='sectionp_companies']/a")
    private static WebElement companies;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement epaper;
    @FindBy(xpath = "//a[@class='userSignin epaperheader']")
    private static WebElement signIn;
    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getApp;
    @FindBy(xpath = "(//div[@class='subnavArrow'])[1]")
    private static WebElement companiesExpand;
    @FindBy(xpath = "//li[@id='sectionsub_companies_start-ups']/a")
    private static WebElement startUps;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement heading;

    @FindBy(xpath = "//li[contains(@id,'sectionsub_companies')]")
    private static List<WebElement> companiesSubSection;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement firstStoryHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement secondStoryHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement secondStory;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//div[@class='linkclick-candidate'])[1]")
    private static WebElement firstStoryImg;
    @FindBy(xpath = "//div[@class='FirstEle']")
    private static WebElement firstPara;
    @FindBy(xpath = "//div[contains(@id,'summary')]")
    private static WebElement summary;

    @FindBy(xpath = "(//div[@id='socialHolder'])[1]")
    private static WebElement iconsBox;

    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List<WebElement> iconsList;

    @FindBy(xpath = "//div[@title='Explore']")
    private static WebElement exploreOnTopNav;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement ePaperOnHeader;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppOnHeader;

    @FindBy(xpath = "(//div[@title='Search'])[2]")
    private static WebElement searchIconOnHeader;



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
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkCompaniesPageTopNav(explore, companies, mintLogo, epaper, signIn, getApp);
        return isShowing;
    }

    @Override
    public boolean checkCompaniesSection(String Link, String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkCompaniesSectionPage(explore, companies);
        commonFunctions.checkPageUrlContainsText(Link, 10, "Companies Page Url");
        return isShowing;
    }

    @Override
    public boolean checkOpenAppButton(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkOpenAppButton(mintLogo, openApp);
        return isShowing;
    }

    @Override
    public boolean checkOpenAppButtonInOpenStory(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkOpenAppButtonInStory(mintLogo, firstStory, openApp);
        return isShowing;
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
        boolean isShowing=commonFunctionsWeb.checkSummaryOnCompaniesPage(explore, companies, firstStoryImg, summary);
        return isShowing;
    }


    @Override
    public boolean checkParagraphOnCompaniesStoryPage() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctionsWeb.checkParagraphOnCompaniesStory(explore, companies, firstStoryImg, firstPara);

        return isShowing;
    }

    @Override
    public boolean checkStartUpsSubSection() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(companiesExpand, 10, "Companies Expand");
        isShowing &=commonFunctions.isElementDisplayedOfListOfWebElements(companiesSubSection, "Companies Subsection");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctions.clickElement(startUps, 10, "Start Ups");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayed(heading,10, "StartUps Headline");
        return isShowing;
    }

    @Override
    public boolean checkStartUpsTopNav() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(companiesExpand, 10, "Companies Expand");
        isShowing &=commonFunctions.isElementDisplayedOfListOfWebElements(companiesSubSection, "Companies Subsection");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctions.clickElement(startUps, 10, "Start Ups");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayed(searchIconOnHeader,10, "Search Icon On Header");
        isShowing &=commonFunctions.isElementDisplayed(getAppOnHeader,10, "Get App Icon On Header");
        isShowing &=commonFunctions.isElementDisplayed(exploreOnTopNav,10, "Explore Icon On Header");
        isShowing &=commonFunctions.isElementDisplayed(ePaperOnHeader,10, "ePaper Icon On Header");
        return isShowing;
    }

}


