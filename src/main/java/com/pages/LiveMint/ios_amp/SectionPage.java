package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SectionPage extends CommonSectionPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;
    private static ApiValidation apiValidation;


    @FindBy(id = "accept")
    private static WebElement acceptCookie;
    @FindBy(xpath = "(//button[contains(@on,'tap')])[3]")
    private static WebElement explore;
    @FindBy(xpath = "//div[@class='icoMenu']")
    private static WebElement bankingExplore;
    @FindBy(css = "a[href='/amp-opinion']")
    private static WebElement opinion;
    @FindBy(xpath = "//a[contains(@class,'icoSearch')]")
    private static WebElement search;
    @FindBy(xpath = "(//div[contains(@class,'icoSearch')])[2]")
    private static WebElement bankingSearch;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement epaper;
    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getApp;
    @FindBy(xpath = "//a[@class='logo']")
    private static WebElement mintLogo;
    @FindBy(xpath = "(//div[@class='adHolder'])[1]")
    private static WebElement mastHeadAd;
    @FindBy(xpath = "//a[@data-vars-event-label='/industry']")
    private static WebElement industry;
    @FindBy(xpath = "(//h6[contains(@class,'subnavArrow')])[8]")
    private static WebElement industryExpand;
    @FindBy(xpath = "//a[@data-vars-event-label='/industry/banking']")
    private static WebElement banking;
    @FindBy(xpath = "(//h2[@class='headline']/a)[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//div[@class='mainArea']//p)[1]")
    private static WebElement firstPara;
    @FindBy(xpath = "//div[@class='gSpecs']")
    private static List <WebElement> shareIcons;



    public SectionPage() {
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


    /*public static void closeAllThePopups(){
        commonFunctions.switchToFrame(googleAdFrame, 10,"Google Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup, "Close button in google popup", 6);
        commonFunctions.switchToFrame(googleAdFrame2, 10,"Google Ad Frame2");
        commonFunctions.closePopupIfExist(closeButtonIngGoogleAdPopup2, "Close button in google popup", 6);
        commonFunctions.switchToFrame(notificationAdFrame, 5,"Notification Ad Frame");
        commonFunctions.closePopupIfExist(closeButtonInFivePercentDiscountAdPopup, "Close button in Five percent discount popup", 6);
        commonFunctions.switchToDefaultContent();
    }*/

    @Override
    public void clickOnHomeAndExploreTab() {

    }


    @Override
    public boolean checkOpinionPageMastHead() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing=commonFunctionsWeb.checkMastHeadOnOpinionPage(explore, opinion, mastHeadAd);
        return isShowing;
    }


    @Override
    public boolean checkBankingSubSectionPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
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
        boolean isShowing=commonFunctions.isElementDisplayed(bankingExplore, 10, "Explore");
        isShowing &=commonFunctions.isElementDisplayed(bankingSearch, 10, "Search");
        isShowing &=commonFunctions.isElementDisplayed(epaper, 10, "Epaper");
        isShowing &=commonFunctions.isElementDisplayed(mintLogo, 10, "Mint Logo");
        isShowing &=commonFunctions.isElementDisplayed(getApp, 10, "Get App");
        return isShowing;
    }


    @Override
    public boolean checkIndustryPageParagraphShare() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.clickElementWithJS(industry, 10, "Industry");
        isShowing &=commonFunctions.clickElementWithJS(firstStory, 10, "First Story");
        isShowing &=commonFunctions.isElementDisplayedOfListOfWebElements(shareIcons,  "Share Icons");
        return isShowing;
    }



}




