package com.pages.LiveMint.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SectionPage extends CommonSectionPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;
    private static CommonLoginPage loginPage;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(id = "sectionp_industry")
    private static WebElement industry;
    @FindBy(xpath = "//div[@title='Explore']/div")
    private static WebElement explore;
    @FindBy(xpath = "//li[@id='sectionp_opinion']/a")
    private static WebElement opinion;
    @FindBy(xpath = "//div[contains(@id,'Masthead_Multisize')]")
    private static WebElement mastHeadAd;
    @FindBy(xpath = "//div[@id='hamburgerElement']")
    private static WebElement exploreMenu;
    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement MyAccount;
    @FindBy(xpath = "//li[@id='sectionp_industry']//img")
    private static WebElement industryExpand;
    @FindBy(xpath = "//li[@id='sectionsub_industry_banking']/a")
    private static WebElement banking;
    @FindBy(xpath = "(//div[contains(@class,'icoSearch')])[2]")
    private static WebElement search;
    @FindBy(xpath = "//li[@id='sectionp_industry']/a")
    private static WebElement indstry;
    @FindBy(xpath = "(//h2[@class='headline']/a)[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "//div[@class='FirstEle']/p")
    private static WebElement firstPara;
    @FindBy(xpath = "(//a[contains(@title,'Facebook')])[2]")
    private static WebElement facebookShare;
    @FindBy(xpath = "(//a[contains(@class,'icowhatsapp')])[2]")
    private static WebElement whatsappShare;
    @FindBy(xpath = "(//a[contains(@class,'icolinkedin')])[2]")
    private static WebElement linkedin;
    @FindBy(xpath = "(//a[contains(@class,'icoTwit')])[2]")
    private static WebElement twitter;
    @FindBy(id = "ePaperIconId")
    private static WebElement epaper;
    @FindBy(id = "headerMintLogo")
    private static WebElement mintLogo;
    @FindBy(xpath = "(//a[@id='getAppId'])[1]")
    private static WebElement getApp;

    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        loginPage = CommonLoginPage.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkAutoNewsPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkPodcastPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkBrandStoriesPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkBrandPostPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkQuickReadsPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkBudgetPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkLoungePage() {
        return false;
    }

    @Override
    public boolean checkCompaniesSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkEducationSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkIndustrySectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkMarketSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkTechnologySectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkSportsSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkPoliticsSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkInsuranceSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkMoneySectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkMutualFundSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkOpinionSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkPhotosSectionPage(String[] params) {
        return false;
    }

    @Override
    public boolean videoValidation() {
        return false;
    }

    @Override
    public boolean checkSearchSectionPage(String serachText) {
        return false;
    }

    @Override
    public boolean checkAppVersionDisplayed() {
        return false;
    }

    @Override
    public void clickOnHomeAndExploreTab() {

    }

    @Override
    public boolean checkOpinionPageMastHead() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(mintLogo, 10, "mint logo");
        commonFunctions.clickElementWithJS(exploreMenu, 10, "Click on Exp");
        if (commonFunctions.isElementDisplayedAndPresent(MyAccount, 20, "My account")) {
            loginPage.logout();
        }else {
            commonFunctions.pageRefresh();
        }
        boolean isShowing=commonFunctionsWeb.checkMastHeadOnOpinionPage(explore, opinion, mastHeadAd);
        return isShowing;
    }

    @Override
    public boolean checkBankingSubSectionPage() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElementWithJS(explore,10,"explore" );
        commonFunctions.scrollToViewElement(industry, "Industry", 15);
        isShowing &=commonFunctions.clickElementWithJS(industryExpand, 10, "Industry Expand");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.clickElementWithJS(banking, 10, "Banking");
        return isShowing;
    }

    @Override
    public boolean checkBankingPageTopNav() {
        checkBankingSubSectionPage();
        commonFunctions.dummyWait(3);
        boolean isShowing=commonFunctions.isElementDisplayed(explore, 10, "Explore");
        isShowing &=commonFunctions.isElementDisplayed(search, 10, "Search");
        isShowing &=commonFunctions.isElementDisplayed(epaper, 10, "Epaper");
        isShowing &=commonFunctions.isElementDisplayed(mintLogo, 10, "Mint Logo");
        isShowing &=commonFunctions.isElementDisplayed(getApp, 10, "Get App");
        return isShowing;
    }

    @Override
    public boolean checkIndustryPageParagraphShare() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.clickElementWithJS(indstry, 10, "Industry");
        isShowing &=commonFunctions.clickElementWithJS(firstStory, 10, "First Story");
        isShowing &=commonFunctions.scrollToElementView(firstPara, 10, "First Para");
        isShowing &=commonFunctions.isElementDisplayed(facebookShare, 10, "Facebook Share");
        isShowing &=commonFunctions.isElementDisplayed(whatsappShare, 10, "WhatApp Share");
        isShowing &=commonFunctions.isElementDisplayed(linkedin, 10, "Linkedin Share");
        return isShowing;
    }


}
