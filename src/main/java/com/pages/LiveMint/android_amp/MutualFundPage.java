package com.pages.LiveMint.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonMutualFundPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MutualFundPage extends CommonMutualFundPage {

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
    @FindBy(css = "h1[class=listheading]")
    private static WebElement pageHeader;
    @FindBy(css = "a[href='/amp-mutual-fund']")
    private static WebElement mutualFund;
    @FindBy(xpath = "(//h6[@role='button'])[5]")
    private static WebElement mutualFundExpand;
    @FindBy(xpath = "//a[@href='/mutual-fund/mf-news']")
    private static WebElement mutualFundNews;
    @FindBy(css = "a[href='/amp-politics']")
    private static WebElement politics;
    @FindBy(xpath = "(//div[contains(@class,'icoSearch')])[2]")
    private static WebElement searchSubsectionPage;
    @FindBy(xpath = "//a[contains(@class,'icoSearch')]")
    private static WebElement search;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement epaper;
    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getApp;
    @FindBy(xpath = "//span[@class='blink']")
    private static WebElement offerText;
    @FindBy(xpath = "//div[@id='offerMob']/a")
    private static WebElement subscribeNowCta;
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



    public MutualFundPage() {
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
    public boolean checkWidgetHeader(String categories, String MFurl) {
        return false;
    }

    @Override
    public boolean checkCategoriesInMFWidget(String header, String categories) {
        return false;
    }

    @Override
    public boolean selectCategory(String category) {
        return false;
    }

    @Override
    public boolean checkMFListingCountinWidget(String category) {
        return false;
    }

    @Override
    public boolean checkAssetsizeFieldInMFWidget(String header, String key) {
        return false;
    }

    @Override
    public boolean checkMFListingDataheaders(String category, String key) {
        return false;
    }

    @Override
    public boolean checkDropdownHaveMFOptions(String category) {
        return false;
    }

    @Override
    public boolean checkMFListedDisplayedForSelectedMF(String category, String SubCategory, String mfAPIUrl) {
        return false;
    }


    @Override
    public boolean checkMFSectionInHamburger(String Offer) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(mutualFund, 10, "Mutual Fund");
        isShowing &=commonFunctions.isElementDisplayed(pageHeader, 10, "Page Header");
        isShowing &=commonFunctions.isElementDisplayed(getApp, 10, "Get App");
        isShowing &=commonFunctions.isElementDisplayed(epaper, 10, "Epaper");
        isShowing &= commonFunctions.isElementClickable(search, 10, "Search");
        return isShowing;
    }


    @Override
    public boolean checkMFNewsSubSectionInHamburger(String Offer) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.scrollToElementViewAndClick(mutualFundExpand, 10, "Mutual Fund Expand");
        commonFunctions.clickElementWithJS(mutualFundNews, 10, "MF News");
        isShowing &=commonFunctions.isElementDisplayed(pageHeader, 10, "Page Header");
        isShowing &=commonFunctions.checkElementText(offerText, Offer, 10, "Offer Text");
        isShowing &=commonFunctions.isElementDisplayed(epaper, 10, "Epaper");
        isShowing &= commonFunctions.isElementClickable(searchSubsectionPage, 10, "Search");
        isShowing &=commonFunctions.isElementDisplayed(getApp, 10, "Get App");
        isShowing &= commonFunctions.isElementClickable(subscribeNowCta, 10, "Subscribe Now");
        return isShowing;
    }

}

