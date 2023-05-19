package com.pages.LiveMint.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SectionPage extends CommonSectionPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;

    @FindBy(id = "accept")
    private static WebElement acceptCookie;
    @FindBy(css = ".ampstart-btn.caps.m2")
    private static WebElement explore;
    @FindBy(xpath = "//div[@class='icoMenu']")
    private static WebElement bankingExplore;
    @FindBy(xpath = "(//div[contains(@class,'icoSearch')])[2]")
    private static WebElement bankingSearch;
    @FindBy(css = "a[href='/amp-opinion']")
    private static WebElement opinion;
    @FindBy(css = "a[href='/amp-politics']")
    private static WebElement politics;
    @FindBy(xpath = "//a[contains(@class,'icoSearch')]")
    private static WebElement search;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement epaper;
    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getApp;
    @FindBy(xpath = "//a[@class='logo']")
    private static WebElement mintLogo;
    @FindBy(xpath = "(//div[@class='adHolder'])[1]")
    private static WebElement mastHeadAd;
    @FindBy(xpath = "(//h6[contains(@class,'subnavArrow')])[8]")
    private static WebElement industryExpand;
    @FindBy(xpath = "//a[@data-vars-event-label='/industry']")
    private static WebElement industry;
    @FindBy(xpath = "//a[@data-vars-event-label='/industry/banking']")
    private static WebElement banking;
    @FindBy(xpath = "(//div[contains(@class,'listing')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//a[@class='imgSec'])[1]")
    private static WebElement firstStoryImg;
    @FindBy(xpath = "(//div[@class='mainArea']//p)[1]")
    private static WebElement firstPara;
    @FindBy(xpath = "//div[@class='gSpecs']")
    private static List<WebElement> shareIcons;



    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);

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
