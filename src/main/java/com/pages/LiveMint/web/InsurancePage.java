package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonInsurancePage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InsurancePage extends CommonInsurancePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsWeb;

    @FindBy(id = "hamburgerElement")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//li[@id='sectionp_insurance']/a")
    private static WebElement insurance;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(xpath = "//div[@class='icoMenu']")
    private static WebElement iconMenu;

    @FindBy(xpath = "//div[@onclick='topSearch()']")
    private static WebElement SearchIcon;

    @FindBy(xpath = "//a[@class='icoBell iconSprite']")
    private static WebElement NotificationBellIcon;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement EpaperIcon;

    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
    private static WebElement singInButton;
    @FindBy(id = "showCurrentDateTime")
    private static WebElement timestamp;

    @FindBy(xpath = "//div[@id='offerHead']")
    private static WebElement Offertext;

    @FindBy(xpath = "//a[@id='fixedNav_home']")
    private static WebElement homeLHS;
    @FindBy(xpath = " //a[@href='/latest-news']")
    private static WebElement latestLHS;

    @FindBy(xpath = " //a[@id='fixedNav_popular']")
    private static WebElement marketsLHS;

    @FindBy(xpath = " //a[@id='exclusive']")
    private static WebElement premiumLHS;

    @FindBy(xpath = " //a[@id='fixedNav_foryou']")
    private static WebElement forYouLHS;
    @FindBy(xpath = " //a[@id='fixedNav_watchlist']")
    private static WebElement watchlistOnLHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][1]")
    private static WebElement rhsTopAds;

    @FindBy(id="RFUHomeFeed")
    private static WebElement rhsRFU;

    @FindBy(id="trendingRHSFeed")
    private static WebElement trendingOnRHS;

    @FindBy(id="latestRHSFeed")
    private static WebElement latestOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][2]")
    private static WebElement secondADSOnRHS;

    @FindBy(id="topicRHSFeed-primer")
    private static WebElement primerOnRHS;

    @FindBy(id="topicRHSFeed-long-story")
    private static WebElement longStoryOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][3]")
    private static WebElement thirdAdsOnRHS;

    @FindBy(id="premiumRHSFeed")
    private static WebElement premiumOnRhs;

    @FindBy(id="rhsPopularVideosNotAdFree")
    private static WebElement popularVideosOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][4]")
    private static WebElement fourthAdsOnRHS;

    @FindBy(id="sectionRHSFeed-companies")
    private static WebElement companiesOnRHS;

    @FindBy(id="rhsWsjNotAdFree")
    private static WebElement wsjOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][5]")
    private static WebElement fifthAdsOnRHS;

    @FindBy(id="personalFinance")
    private static WebElement personalFinanceOnRHS;

    @FindBy(id="rhsTrendingSticky")
    private static WebElement rhsTrendingSticky;

    @FindBy(xpath = "//div[@class='rightAd rightBlock lastBlockAd']")
    private static WebElement lastAdsOnRHS;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement firstStoryHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement secondStoryHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement secondStory;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "(//div[@id='socialHolder'])[1]")
    private static WebElement iconsBox;

    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List<WebElement> iconsList;

    @FindBy(xpath = "(//*[@id='socialHolder']/aside[1]/div[2]")
    private static WebElement shareClickable;

    @FindBy(xpath = "//div[@class='linkclick-candidate'][1]")
    private static WebElement insuranceFirstStory;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement insuranceFirstHeadline;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement insuranceSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement insuranceSecondStory;

    public InsurancePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean clickOnInsuranceSection() {
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(exploreMenu, 10, "Explore Menu");
        commonFunctions.scrollToElement(insurance, "Insurance Section");
        return commonFunctions.clickElement(insurance, 10, "Insurance Section");
    }

    @Override
    public boolean checkTopNavOnInsurancePage() {
        boolean topNavVisibilty = commonFunctionsWeb.TopNav(pageTitle, iconMenu, EpaperIcon);
        topNavVisibilty &= commonFunctions.isElementDisplayed(singInButton, 10, "Sign in button need to be displayed in top nav");
        topNavVisibilty &= commonFunctions.isElementDisplayed(Offertext, 10, "Offer Text");
        return topNavVisibilty;
    }

    @Override
    public boolean checkLHSOnInsurancePage() {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu, insurance, "insurance");
        boolean lhsVisibility = commonFunctions.isElementDisplayed(homeLHS, 10, "home should be displyed in lhs");
        lhsVisibility &= commonFunctions.isElementDisplayed(latestLHS, 10, "latest should be displayed in lhs");
        lhsVisibility &= commonFunctions.isElementDisplayed(marketsLHS, 10, "market should be displayed in LHS");
        lhsVisibility &= commonFunctions.isElementDisplayed(premiumLHS, 10, "Premium should visible in LHS");
        lhsVisibility &= commonFunctions.isElementDisplayed(forYouLHS, 10, "For you should be visible in LHS");
        lhsVisibility &= commonFunctions.isElementDisplayed(watchlistOnLHS, 10, "watchlist on LHS");

        return lhsVisibility;
    }
    @Override
    public boolean checkRHSOnInsurancePage()
    {

        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,insurance,"insurance");
        boolean RHSVisibility =commonFunctions.isElementDisplayed(rhsTopAds,10,"RHS top ads visibility");
        RHSVisibility &=commonFunctions.isElementDisplayed(rhsRFU,10,"RFU visibility");
        RHSVisibility &=commonFunctions.isElementDisplayed(trendingOnRHS,10,"trending visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(latestOnRHS,10,"latest visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(secondADSOnRHS,10,"Second ads visibility");
        RHSVisibility &=commonFunctions.isElementDisplayed(primerOnRHS,10,"primer visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(longStoryOnRHS,10,"long story visibilty on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(thirdAdsOnRHS,10,"third ads visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(premiumOnRhs,10,"premium visibilty on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(popularVideosOnRHS,10,"popular videos visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(fourthAdsOnRHS,10,"fourth ads on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(companiesOnRHS,10,"companies visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(wsjOnRHS,10,"wsj visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(fifthAdsOnRHS,10,"fifty ads visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(personalFinanceOnRHS,10,"presonal finance visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(rhsTrendingSticky,10," rhs Trending Sticky visibility");
        RHSVisibility &=commonFunctions.scrollToElementView(lastAdsOnRHS,10,"last ads visible");
        RHSVisibility &=commonFunctions.isElementDisplayed(lastAdsOnRHS,10,"last ads visibility on RHS");
        return RHSVisibility;
    }
    @Override
    public boolean checkshareIconVisibility() {
        commonFunctions.navigateToPageThroughExploremenu(exploreMenu,insurance,"insurance");
        boolean isShowing=commonFunctions.isElementDisplayed(firstStory,10,"first story card visibility");
        isShowing &=commonFunctions.isElementDisplayed(iconsBox,10,"social icon visibility");
        try {
            isShowing &= commonFunctions.clickElementWithJS(shareClickable, 10, "clickable");
        }
        catch(Exception e){
            System.out.println("share clcikable");
        }
        isShowing &=commonFunctions.isElementDisplayed(iconsList,10,"icon list visibility");
        return isShowing;
    }
    @Override
    public boolean checkInsurancePageLayout() {
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(exploreMenu, 10, "Explore Menu");
        commonFunctions.scrollToElement(insurance, "Insurance Section");
        boolean isShowing = commonFunctions.clickElementWithJS(insurance, 10, "Insurance Section");
        isShowing &= commonFunctions.isElementDisplayed(insuranceFirstStory, 10, "First Story");
        String Headline = commonFunctions.getElementText(insuranceFirstStory);
        String Header = commonFunctions.getElementText(insuranceFirstHeadline);
        isShowing &= commonFunctions.checkTextContains(Header, Headline, "First Story verified card view");
        isShowing &= commonFunctions.isElementDisplayed(insuranceSecondStory, 10, "Second Story");
        String Headline1 = commonFunctions.getElementText(insuranceSecondStory);
        String Heading = commonFunctions.getElementText(insuranceSecondHeadline);
        isShowing &= commonFunctions.checkTextContains(Heading, Headline1, "Second Story verified list view");
        return isShowing;
    }
}