package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPremiumStoryPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PremiumStoryPage extends CommonPremiumStoryPage {
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
    @FindBy(xpath = "(//div[@role='listitem'])[3]/a")
    private static WebElement technology;
    @FindBy(xpath = "(//div[@role='listitem'])[5]/a")
    private static WebElement money;
    @FindBy(xpath = "(//div[@role='listitem'])[4]/a")
    private static WebElement markets;
    @FindBy(xpath = "//div[@class='premiumNav']//div[2]//a[1]")
    private static WebElement companies;
    @FindBy(xpath = "((//a[contains(@href,'/market')])/amp-img)[1]")
    private static WebElement marketsFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/market')])/amp-img)[2]")
    private static WebElement marketsSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/market')])/amp-img)[3]")
    private static WebElement marketsThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/money')])/amp-img)[1]")
    private static WebElement moneyFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/money')])/amp-img)[2]")
    private static WebElement moneySecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/money')])/amp-img)[3]")
    private static WebElement moneyThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/technology')])/amp-img)[1]")
    private static WebElement technologyFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/technology')])/amp-img)[2]")
    private static WebElement technologySecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/technology')])/amp-img)[3]")
    private static WebElement technologyThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/companies')])/amp-img)[1]")
    private static WebElement companiesFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/companies')])/amp-img)[2]")
    private static WebElement companiesSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/companies')])/amp-img)[3]")
    private static WebElement companiesThirdStory;

    @FindBy(xpath = "(//div[@class='gSpecs'])")
    private static List<WebElement> iconsList;

    @FindBy(xpath = "//div[@class='premiumNav']//div[contains(@class,'slides')]")
    private static List<WebElement> subNavTab;
    @FindBy(id = "exclusive")
    private static WebElement premium;
    @FindBy(xpath = "//a[contains(@class,'seeAllSlider')]")
    private static WebElement premiumViewAll;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement premiumPageHeader;
    @FindBy(xpath = "(//div[@role='listitem'])[9]/a")
    private static WebElement industry;
    @FindBy(xpath = "((//a[contains(@href,'/industry')])/amp-img)[1]")
    private static WebElement industryFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/industry')])/amp-img)[2]")
    private static WebElement industrySecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/industry')])/amp-img)[3]")
    private static WebElement industryThirdStory;
    @FindBy(xpath = "(//div[contains(@class,'next')])[1]")
    private static WebElement nextbutton;
    @FindBy(xpath = "(//a[contains(@href,'/amp-auto-news')])[2]")
    private static WebElement auto;
    @FindBy(xpath = "(//a[contains(@href,'/personal-finance')])[2]")
    private static WebElement personalFinance;
    @FindBy(xpath = "((//a[contains(@href,'/personal')])/img)[1]")
    private static WebElement personalFinanceFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/personal')])/img)[2]")
    private static WebElement personalFinanceSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/personal')])/img)[3]")
    private static WebElement personalFinanceThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/auto')])//img)[1]")
    private static WebElement autoFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/auto')])//img)[1]")
    private static WebElement autoSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/auto')])//img)[1]")
    private static WebElement autoThirdStory;


    @FindBy(xpath = "(//div[@role='listitem'])[6]/a")
    private static WebElement mutualFunds;
    @FindBy(xpath = "((//a[contains(@href,'mutual-fund')])/amp-img)[1]")
    private static WebElement mutualfundFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'mutual-fund')])/amp-img)[2]")
    private static WebElement mutualfundSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'mutual-fund')])/amp-img)[3]")
    private static WebElement mutualfundThirdStory;

    @FindBy(xpath = "(//div[@class='share-icons-box']")
    private static WebElement iconsBox;


    @FindBy(xpath = "//a[contains(@href,'/companies')]/amp-img")
    private static List <WebElement> companiesPageStories;

    @FindBy(xpath = "//button[@class='subscribe'][1]")
    private static WebElement doItLater;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;


    public PremiumStoryPage() {
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
    public boolean checkStory() {
        return false;
    }

    @Override
    public boolean mintPremiumWidget(String email, String password, String mintPrimiumText) {
        return false;
    }

    @Override
    public boolean storyPageTextSizeSelection() {
        return false;
    }

    @Override
    public boolean moreFromSectionWidget() {
        return false;
    }

    @Override
    public boolean checkAdsRemovedPremiumPage() {
        return false;
    }

    @Override
    public boolean checkAdsPresentPremiumPage() {
        return false;
    }

    @Override
    public boolean checkAdsRedirection() {
        return false;
    }

    @Override
    public boolean checkPageSwitching(String email, String password, String premiumText) {
        return false;
    }

    @Override
    public boolean checkNoPayWallToSubscribedUser(String email, String password) {
        return false;
    }

    @Override
    public boolean mintPremiumWidgetListingStory() {
        return false;
    }

    @Override
    public boolean subscribedUserAdsFreePremiumStoryDetailPage() {
        return false;
    }

    @Override
    public boolean subscribedUserAdsFreePremiumListingPage() {
        return false;
    }

    @Override
    public boolean nonSubscribedUserAdsFreePremiumListingPage() {
        return false;
    }

    @Override
    public boolean checkBackButton() {
        return false;
    }

    @Override
    public boolean checkPremiumPageSubNavTabs() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing=commonFunctionsWeb.checkSubNavOnPremiumPage(premium, subNavTab);
        return isShowing;
    }


    @Override
    public boolean checkPremiumPageCompaniesSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(companies, 10, "Companies");
        isShowing &=commonFunctions.isElementDisplayed(companiesFirstStory, 10, "Companies First Story");
        isShowing &=commonFunctions.isElementDisplayed(companiesSecondStory, 10, "Companies Second Story");
        isShowing &=commonFunctions.isElementDisplayed(companiesThirdStory, 10, "Companies Third Story");
        return isShowing;
    }

    @Override
    public boolean checkPremiumPageTechnologySubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(technology, 10, "Technology");
        isShowing &=commonFunctions.isElementDisplayed(technologyFirstStory, 10, "Technology First Story");
        isShowing &=commonFunctions.isElementDisplayed(technologySecondStory, 10, "Technology Second Story");
        isShowing &=commonFunctions.isElementDisplayed(technologyThirdStory, 10, "Technology Third Story");
        return isShowing;
    }

    @Override
    public boolean checkPremiumPageMoneySubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(money, 10, "money");
        isShowing &=commonFunctions.isElementDisplayed(moneyFirstStory, 10, "money First Story");
        isShowing &=commonFunctions.isElementDisplayed(moneySecondStory, 10, "money Second Story");
        isShowing &=commonFunctions.isElementDisplayed(moneyThirdStory, 10, "money Third Story");
        return isShowing;
    }

    @Override
    public boolean checkPremiumPageMarketsSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(markets, 10, "markets");
        isShowing &=commonFunctions.isElementDisplayed(marketsFirstStory, 10, "markets First Story");
        isShowing &=commonFunctions.isElementDisplayed(marketsSecondStory, 10, "markets Second Story");
        isShowing &=commonFunctions.isElementDisplayed(marketsThirdStory, 10, "markets Third Story");
        return isShowing;
    }

    @Override
    public boolean checkPremiumPageCompaniesDataLoad() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(companies, 10, "Companies");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayedOfListOfWebElements(companiesPageStories,  "Companies Page Stories");
        return isShowing;
    }

    @Override
    public boolean checkPremiumPageAutoSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        commonFunctions.clickElementIfDisplayed(nextbutton, 10, "Next Button");
        isShowing &=commonFunctions.clickElementWithJS(auto, 10, "Auto News");
        isShowing &=commonFunctions.isElementDisplayed(autoFirstStory, 10, "Auto News First Story");
        isShowing &=commonFunctions.isElementDisplayed(autoSecondStory, 10, "Auto News Second Story");
        isShowing &=commonFunctions.isElementDisplayed(autoThirdStory, 10, "Auto News Third Story");
        return isShowing;
    }


    @Override
    public boolean checkPremiumPagePersonalFinanceSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        commonFunctions.clickElementIfDisplayed(nextbutton, 10, "Next Button");
        isShowing &=commonFunctions.clickElementWithJS(personalFinance, 10, "Personal Finance");
        isShowing &=commonFunctions.isElementDisplayed(personalFinanceFirstStory, 10, "Personal Finance First Story");
        isShowing &=commonFunctions.isElementDisplayed(personalFinanceSecondStory, 10, "Personal Finance Second Story");
        isShowing &=commonFunctions.isElementDisplayed(personalFinanceThirdStory, 10, "Personal Finance Third Story");
        return isShowing;
    }



    @Override
    public boolean checkPremiumPageMutualFundsSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        commonFunctions.clickElementIfDisplayed(nextbutton, 10, "Next Button");
        isShowing &=commonFunctions.clickElementWithJS(mutualFunds, 10, "Mutual Funds");
        isShowing &=commonFunctions.isElementDisplayed(mutualfundFirstStory, 10, "Mutual Funds First Story");
        isShowing &=commonFunctions.isElementDisplayed(mutualfundSecondStory, 10, "Mutual Funds Second Story");
        isShowing &=commonFunctions.isElementDisplayed(mutualfundThirdStory, 10, "Mutual Funds Third Story");
        return isShowing;
    }


    @Override
    public boolean checkPremiumPageIndustrySubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        commonFunctions.clickElementIfDisplayed(nextbutton, 10, "Next Button");
        isShowing &=commonFunctions.clickElementWithJS(industry, 10, "Industry");
        isShowing &=commonFunctions.isElementDisplayed(industryFirstStory, 10, "Industry First Story");
        isShowing &=commonFunctions.isElementDisplayed(industrySecondStory, 10, "Industry Second Story");
        isShowing &=commonFunctions.isElementDisplayed(industryThirdStory, 10, "Industry Third Story");
        return isShowing;
    }


    @Override
    public boolean checkPremiumWidgetViewAll(String Heading, String Url, String AmpUrl) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.scrollToElementViewAndClick(premiumViewAll, 10, "Premium View All");
        isShowing &=commonFunctions.isElementDisplayed(premiumPageHeader, 10, "Header Premium Page");
        isShowing &=commonFunctions.checkElementText(premiumPageHeader, Heading, 10, "Page Heading Verified");
        isShowing &=commonFunctions.checkPageUrlContainsText(AmpUrl, 10, "Page Url Verified");
        return isShowing;
    }

    @Override
    public boolean checkAdsNotPresentOnStoryDetailPage() {
        return false;
    }

    @Override
    public boolean checkPremiumStickerPresentOnStoryDetailPage() {
        return false;
    }

    @Override
    public boolean checkPremiumStickerDisappearOnStoryDetailPage() {
        return false;
    }

    @Override
    public boolean checkSubscribedBtnNotDisplayedOnPaywall() {
        return false;
    }

    @Override
    public boolean checkNoPaywall() {
        return false;
    }

    @Override
    public boolean checkSignInFromFreemium() {
        return false;
    }

    @Override
    public boolean checkNoPaywallAndAdsForSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkPaywallAndAds() {
        return false;
    }

    @Override
    public boolean clickOnSignInFromPaywall() {
        return false;
    }

    @Override
    public boolean checkPaywallForPremiumStories() {
        return false;
    }


}

