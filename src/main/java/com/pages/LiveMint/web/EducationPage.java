package com.pages.LiveMint.web;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.genericPages.CommonEducationPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class EducationPage extends CommonEducationPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "hamburgerElement")
    private static WebElement explore;

    @FindBy(xpath = "//a[@href='/education']")
    private static WebElement education;

    @FindBy(xpath = "//div[@class='linkclick-candidate'][1]")
    private static WebElement educationFirstStory;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement educationFirstHeadline;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement educationSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement educationSecondStory;
    @FindBy(xpath = " //a[@id='fixedNav_home']")
    private static WebElement homeLHS;
    @FindBy(xpath = " //a[@href='/latest-news']")
    private static WebElement latestLHS;

    @FindBy(xpath = " //a[@id='fixedNav_popular']")
    private static WebElement marketsLHS;

    @FindBy(xpath = " //a[@id='exclusive']")
    private static WebElement premiumLHS;

    @FindBy(xpath = " //a[@id='fixedNav_foryou']")
    private static WebElement forYouLHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][1]")
    private static WebElement rhsTopAds;

    @FindBy(xpath = "//div[@id='RFUHomeFeed']")
    private static WebElement rhsRFU;

    @FindBy(xpath = " //div[@id='trendingRHSFeed']")
    private static WebElement trendingOnRHS;

    @FindBy(xpath = " //div[@id='latestRHSFeed']")
    private static WebElement latestOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][2]")
    private static WebElement secondADSOnRHS;

    @FindBy(xpath = "//div[@id='topicRHSFeed-primer']")
    private static WebElement primerOnRHS;

    @FindBy(xpath = "//div[@id='topicRHSFeed-long-story']")
    private static WebElement longStoryOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][3]")
    private static WebElement thirdAdsOnRHS;

    @FindBy(xpath = "//div[@id='premiumRHSFeed']")
    private static WebElement premiumOnRhs;

    @FindBy(xpath = "//div[@id='rhsPopularVideosNotAdFree']")
    private static WebElement popularVideosOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][4]")
    private static WebElement fourthAdsOnRHS;

    @FindBy(xpath = "//div[@id='sectionRHSFeed-companies']")
    private static WebElement companiesOnRHS;

    @FindBy(xpath = "//div[@id='rhsWsjNotAdFree']")
    private static WebElement wsjOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][5]")
    private static WebElement fifthAdsOnRHS;

    @FindBy(xpath = "//div[@id='personalFinance']")
    private static WebElement personalFinanceOnRHS;

    @FindBy(xpath = "//div[@id='rhsTrendingSticky']")
    private static WebElement rhsTrendingSticky;

    @FindBy(xpath = "//div[@class='rightAd rightBlock lastBlockAd']")
    private static WebElement lastAdsOnRHS;

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



    public EducationPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    @Override
    public boolean checkEducationPageLayout(String amp) {
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(explore, 10, "Explore Menu");
        commonFunctions.scrollToElement(education, "Education Section");
        boolean isShowing = commonFunctions.clickElement(education, 10, "Education Section");
        isShowing &= commonFunctions.isElementDisplayed(educationFirstStory, 10, "First Story");
        String Headline = commonFunctions.getElementText(educationFirstStory);
        String Header = commonFunctions.getElementText(educationFirstHeadline);
        isShowing &= commonFunctions.checkTextContains(Header, Headline, "First Story verified card view");
        isShowing &= commonFunctions.isElementDisplayed(educationSecondStory, 10, "Second Story");
        String Headline1 = commonFunctions.getElementText(educationSecondStory);
        String Heading = commonFunctions.getElementText(educationSecondHeadline);
        isShowing &= commonFunctions.checkTextContains(Heading, Headline1, "Second Story verified list view");
        return isShowing;
    }

    @Override
    public boolean clickOnEducationsSection() {
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.clickElement(explore, 10, "Explore Menu");
        commonFunctions.scrollToElement(education, "Education Section");
        return commonFunctions.clickElement(education, 10, "Education Section");
    }

    @Override
    public boolean checkLHSMenuOnEducationPage(){
        commonFunctions.navigateToPageThroughExploremenu(explore,education,"education");
        boolean lhsVisibility=commonFunctions.isElementDisplayed(homeLHS,10,"home should be displyed in lhs");
        lhsVisibility &=commonFunctions.isElementDisplayed(latestLHS,10,"latest should be displayed in lhs");
        lhsVisibility &=commonFunctions.isElementDisplayed(marketsLHS,10,"market should be displayed in LHS");
        lhsVisibility &=commonFunctions.isElementDisplayed(premiumLHS,10,"Premium should visible in LHS");
        lhsVisibility &=commonFunctions.isElementDisplayed(forYouLHS,10,"For you should be visible in LHS");


        return lhsVisibility;

    }
    @Override
    public boolean checkRHSOnEducationPage()
    {

        commonFunctions.navigateToPageThroughExploremenu(explore, education, "education");
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
    public boolean checkTopNavOnEducationPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, education, "education");
        boolean mintLogoDisplayed = commonFunctions.isElementDisplayed(pageTitle, 10, "mint logo");
        boolean iconMenuDisplayed = commonFunctions.isElementDisplayed(iconMenu, 10, "Icon Menu should be displayed");
        boolean searchIconDisplayed = commonFunctions.isElementDisplayed(SearchIcon, 10, "Search icon need to be displayed");
        boolean notificationIconDisplayed = commonFunctions.isElementDisplayed(NotificationBellIcon, 10, "Notification icon need to be displayed in top Nav");
        boolean epaperIconDisplayed = commonFunctions.isElementDisplayed(EpaperIcon, 10, "Epaper icon need to be displayed in top Nav");
        boolean SigninlinkDisplayed = commonFunctions.isElementDisplayed(singInButton, 10, "Sign in button need to be displayed in top nav");
        return (mintLogoDisplayed && iconMenuDisplayed && searchIconDisplayed && notificationIconDisplayed && epaperIconDisplayed && SigninlinkDisplayed);
        }

    }

