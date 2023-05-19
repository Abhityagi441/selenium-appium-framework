package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPremiumStoryPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PremiumStoryPage extends CommonPremiumStoryPage {
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
    @FindBy(id = "moneyTab")
    private static WebElement money;

    @FindBy(id = "hamburgerElement")
    private static WebElement explore;
    @FindBy(id = "exclusive")
    private static WebElement premium;
    @FindBy(id = "marketsTab")
    private static WebElement market;
    @FindBy(id = "mutualFundsTab")
    private static WebElement mutualFunds;
    @FindBy(id = "companyTab")
    private static WebElement companies;
    @FindBy(id = "technologyTab")
    private static WebElement technology;
    @FindBy(id = "industryTab")
    private static WebElement industry;
    @FindBy(id = "autoTab")
    private static WebElement auto;
    @FindBy(id = "personalFinanceTab")
    private static WebElement personalFinance;

    @FindBy(xpath = "(//a[contains(@class,'seeAll')])[1]")
    private static WebElement premiumViewAll;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement premiumPageHeader;

    @FindBy(xpath = "((//a[contains(@href,'personal')])/img)[1]")
    private static WebElement personalFinanceFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'personal')])/img)[2]")
    private static WebElement personalFinanceSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'personal')])/img)[3]")
    private static WebElement personalFinanceThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'auto')])/img)[1]")
    private static WebElement autoFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'auto')])/img)[2]")
    private static WebElement autoSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'auto')])/img)[3]")
    private static WebElement autoThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'industry')])/img)[1]")
    private static WebElement industryFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'industry')])/img)[2]")
    private static WebElement industrySecondStory;
    @FindBy(xpath = "((//a[contains(@href,'industry')])/img)[3]")
    private static WebElement industryThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'mutual-fund')])/img)[1]")
    private static WebElement mutualfundFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'mutual-fund')])/img)[2]")
    private static WebElement mutualfundSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'mutual-fund')])/img)[3]")
    private static WebElement mutualfundThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/market')])/img)[1]")
    private static WebElement marketFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/market')])/img)[2]")
    private static WebElement marketSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/market')])/img)[3]")
    private static WebElement marketThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/money')])/img)[1]")
    private static WebElement moneyFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/money')])/img)[2]")
    private static WebElement moneySecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/money')])/img)[3]")
    private static WebElement moneyThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/technology')])/img)[1]")
    private static WebElement technologyFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/technology')])/img)[2]")
    private static WebElement technologySecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/technology')])/img)[3]")
    private static WebElement technologyThirdStory;
    @FindBy(xpath = "((//a[contains(@href,'/companies')])/img)[1]")
    private static WebElement companiesFirstStory;
    @FindBy(xpath = "((//a[contains(@href,'/companies')])/img)[2]")
    private static WebElement companiesSecondStory;
    @FindBy(xpath = "((//a[contains(@href,'/companies')])/img)[3]")
    private static WebElement companiesThirdStory;

    @FindBy(xpath = "(//div[contains(@class,'button-next')])[1]")
    private static WebElement nextButton;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "(//div[@class='premiumNav'])//div[contains(@class,'swiper-slide')]")
    private static List<WebElement> subNavTab;
    @FindBy(xpath = "//nav[@id='leftNav']//li")
    private static List<WebElement> leftNavMenu;
    @FindBy(xpath = "//div[contains(@class,'rightAd')]")
    private static List<WebElement> rhsAds;
    @FindBy(xpath = "(//div[@class='rightHead clearfix'])")
    private static List<WebElement> rhsMenuHeaders;
    @FindBy(xpath = "//a[contains(@href,'/companies')]/img")
    private static List <WebElement> companiesPageStories;



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




    public PremiumStoryPage() {
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
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElement(premium, 10, "Premium");
        isShowing &=commonFunctions.isElementDisplayedOfListOfElements(subNavTab, "Premium Page Sub Nav");
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
    public boolean checkPremiumPagePersonalFinanceSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(personalFinance, 10, "Personal Finance");
        isShowing &=commonFunctions.isElementDisplayed(personalFinanceFirstStory, 10, "Personal Finance First Story");
        isShowing &=commonFunctions.isElementDisplayed(personalFinanceSecondStory, 10, "Personal Finance Second Story");
        isShowing &=commonFunctions.isElementDisplayed(personalFinanceThirdStory, 10, "Personal Finance Third Story");
        return isShowing;
    }


    @Override
    public boolean checkPremiumPageAutoSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(auto, 10, "Auto News");
        isShowing &=commonFunctions.isElementDisplayed(autoFirstStory, 10, "Auto News First Story");
        isShowing &=commonFunctions.isElementDisplayed(autoSecondStory, 10, "Auto News Second Story");
        isShowing &=commonFunctions.isElementDisplayed(autoThirdStory, 10, "Auto News Third Story");
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
        isShowing &=commonFunctions.clickElementWithJS(market, 10, "markets");
        isShowing &=commonFunctions.isElementDisplayed(marketFirstStory, 10, "markets First Story");
        isShowing &=commonFunctions.isElementDisplayed(marketSecondStory, 10, "markets Second Story");
        isShowing &=commonFunctions.isElementDisplayed(marketThirdStory, 10, "markets Third Story");
        return isShowing;
    }


    @Override
    public boolean checkPremiumPageCompaniesDataLoad() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(companies, 10, "Companies");
        commonFunctions.dummyWait(3);
        isShowing &=commonFunctions.isElementDisplayedOfListOfElements(companiesPageStories,  "Companies Page Stories");
        return isShowing;
    }


    @Override
    public boolean checkPremiumPageMutualFundsSubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElementWithJS(premium, 10, "Premium");
        isShowing &=commonFunctions.clickElementWithJS(mutualFunds, 10, "Mutual Funds");
        isShowing &=commonFunctions.isElementDisplayed(mutualfundFirstStory, 10, "Mutual Funds First Story");
        isShowing &=commonFunctions.isElementDisplayed(mutualfundSecondStory, 10, "Mutual Funds Second Story");
        isShowing &=commonFunctions.isElementDisplayed(mutualfundThirdStory, 10, "Mutual Funds Third Story");
        return isShowing;
    }


    @Override
    public boolean checkPremiumPageIndustrySubNav() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.clickElement(premium, 10, "Premium");
        for (int i=0; i<=4; i++){
            commonFunctions.clickElement(nextButton, 5, "Next Button");}
        isShowing &=commonFunctions.clickElement(industry, 10, "Industry");
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
        isShowing &=commonFunctions.checkPageUrlContainsText(Url, 5, "Page Url Verified");
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


