package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SectionPage extends CommonSectionPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(id = "agree")
    private static MobileElement acceptCookie;

    @iOSXCUITFindBy(id = "Close")
    private static MobileElement closeButtonInShareOverlay;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'back'`][1]")
    private static MobileElement backInEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;

    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;

    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;

    @iOSXCUITFindBy(id = "Latest")
    private static MobileElement latest;

    @iOSXCUITFindBy(id = "LATEST")
    private static MobileElement latestLandingPage;

    @iOSXCUITFindBy(id = "Trending")
    private static MobileElement trending;

    @iOSXCUITFindBy(id = "TRENDING")
    private static MobileElement trendingLandingPage;

    @iOSXCUITFindBy(id = "Premium")
    private static MobileElement premium;

    @iOSXCUITFindBy(id = "PREMIUM")
    private static MobileElement premiumLandingPage;

    @iOSXCUITFindBy(id = "notification")
    private static MobileElement notificationIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch")
    private static MobileElement notificationFlag;

    @iOSXCUITFindBy(id = "News")
    private static MobileElement news;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Markets']//following::XCUIElementTypeOther[2]")
    private static MobileElement marketsArrowBtn;

    @iOSXCUITFindBy(id = "Stock Markets")
    private static MobileElement stockMarkets;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='STOCK MARKETS']")
    private static MobileElement stockMarketsLandingPage;

    @iOSXCUITFindBy(id = "Search")
    private static MobileElement searchButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    private static MobileElement searchTextField;

    @iOSXCUITFindBy(id = "TRENDING TOPICS")
    private static MobileElement trendingTopics;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    private static List<MobileElement> storiesList;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'share'`][1]")
    private static List<MobileElement> shareIconsList;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'share'`][1]")
    private static MobileElement shareIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'share'`][1]")
    private static MobileElement shareIconUnderStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TRENDING TOPICS']//following::XCUIElementTypeStaticText[2]")
    private static MobileElement storyInTopics;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == 'Messages'`]")
    private static MobileElement messagesIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == 'AirDrop'`]")
    private static MobileElement airDropIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText/XCUIElementTypeOther[`label BEGINSWITH 'Plain Text'`]")
    private static MobileElement plainText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == 'messageBodyField'`]")
    private static MobileElement messageBody;

    @iOSXCUITFindBy(id = "my profile cross")
    private static MobileElement closeEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement cancelButton;

    //New Locators Start Here
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement explore;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Auto News']")
    private static MobileElement autoNews;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='AUTO NEWS']")
    private static MobileElement autoNewsLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Podcast']")
    private static MobileElement podcast;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Brand Post']")
    private static MobileElement brandPost;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BRAND POST']")
    private static MobileElement brandPostLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Brand Stories']")
    private static MobileElement brandStories;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BRAND STORIES']")
    private static MobileElement brandStoriesLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Budget 2022']")
    private static MobileElement budget;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='BUDGET 2022'])[1]")
    private static MobileElement budgetLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Industry']")
    private static MobileElement industry;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='INDUSTRY']")
    private static MobileElement industryLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Education']")
    private static MobileElement education;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='EDUCATION']")
    private static MobileElement educationLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Companies']")
    private static MobileElement companies;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COMPANIES']")
    private static MobileElement companiesLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Technology']")
    private static MobileElement technology;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TECHNOLOGY']")
    private static MobileElement technologyLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sports']")
    private static MobileElement sports;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SPORTS']")
    private static MobileElement sportsLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Markets']")
    private static MobileElement markets;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MARKETS']")
    private static MobileElement marketsLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Yes, I am In']")
    private static MobileElement darkThemeYes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lounge']")
    private static MobileElement lounge;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Quick Reads']")
    private static MobileElement quickReads;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='QUICK READS']")
    private static MobileElement quickReadsHeading;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Politics']")
    private static MobileElement politics;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='POLITICS']")
    private static MobileElement politicsLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Money']")
    private static MobileElement money;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MONEY']")
    private static MobileElement moneyLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Insurance']")
    private static MobileElement insurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='INSURANCE']")
    private static MobileElement insuranceLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mutual Funds']")
    private static MobileElement mutualFund;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MUTUAL FUNDS']")
    private static MobileElement mutualFundLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Opinion']")
    private static MobileElement opinion;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OPINION']")
    private static MobileElement opinionLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Photos']")
    private static MobileElement photos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PHOTOS']")
    private static MobileElement photosLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Videos']")
    private static MobileElement videos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VIDEOS']")
    private static MobileElement videosLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Video')]")
    private static MobileElement videoPlayer;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
    //(//XCUIElementTypeButton[@name='play new'])[1]/preceding-sibling:: XCUIElementTypeStaticText
    private static MobileElement videoStoryTitle;
    @iOSXCUITFindBy(id = "Mint e-paper")
    private static MobileElement exploreTabEPaper;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;


    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
//        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

@Override
    public void clickOnHomeAndExploreTab() {
        commonFunctions.clickElement(home, 10, "Home Tab");
        commonFunctions.clickElement(explore, 10, "Explore Tab");
        commonFunctions.scrollUpToElementDisplayed(exploreTabEPaper);
    }

    @Override
    public boolean checkOpinionPageMastHead() {
        return false;
    }

    @Override
    public boolean checkBankingSubSectionPage() {
        return false;
    }

    @Override
    public boolean checkBankingPageTopNav() {
        return false;
    }

    @Override
    public boolean checkIndustryPageParagraphShare() {
        return false;
    }

    @Override
    public boolean checkAutoNewsPage(String[] params) {
        boolean checkAutoNewsPageStatus;
        clickOnHomeAndExploreTab();
        checkAutoNewsPageStatus = commonFunctions.checkElementVisibilityByScrolling(autoNews, "autoNews");
        commonFunctions.clickElement(autoNews, 10, "Auto News");
        checkAutoNewsPageStatus &= commonFunctions.checkElementText(autoNewsLanding, "AUTO NEWS", 10, "text: auto news");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkAutoNewsPageStatus;
    }

    @Override
    public boolean checkBrandStoriesPage(String[] params) {
        boolean checkBrandStoriesPageStatus;
        clickOnHomeAndExploreTab();
        checkBrandStoriesPageStatus = commonFunctions.checkElementVisibilityByScrolling(brandStories, "brandStories");
        commonFunctions.clickElement(brandStories, 10, "Brand Stories");
        checkBrandStoriesPageStatus &= commonFunctions.checkElementText(brandStoriesLanding, "BRAND STORIES", 10, "text: brand stories");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkBrandStoriesPageStatus;
    }

    @Override
    public boolean checkBrandPostPage(String[] params) {
        boolean checkAutoNewsPageStatus;
        clickOnHomeAndExploreTab();
        checkAutoNewsPageStatus = commonFunctions.checkElementVisibilityByScrolling(brandPost, "brandPost");
        commonFunctions.clickElement(brandPost, 10, "Brand Post");
        checkAutoNewsPageStatus &= commonFunctions.checkElementText(brandPostLanding, "BRAND POST", 10, "text: brand post");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkAutoNewsPageStatus;
    }

    @Override
    public boolean checkBudgetPage(String[] params) {
        boolean checkAutoNewsPageStatus;
        clickOnHomeAndExploreTab();
        checkAutoNewsPageStatus =commonFunctions.checkElementVisibilityByScrolling(budget, "budget");
        commonFunctions.clickElement(budget, 10, "Budget 2022");
        checkAutoNewsPageStatus &= commonFunctions.checkElementText(budgetLanding, "BUDGET 2022", 20, "text: budget");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkAutoNewsPageStatus;
    }

    @Override
    public boolean checkPodcastPage(String[] params) {
        boolean checkPodcastPageStatus;
        clickOnHomeAndExploreTab();
        checkPodcastPageStatus = commonFunctions.checkElementVisibilityByScrolling(podcast, "podcast");
        commonFunctions.clickElement(podcast, 10, "Podcast");
        commonFunctions.dummyWait(5);
        commonFunctions.changeContextToWeb();
        checkPodcastPageStatus &= commonFunctions.checkPageURL("htsmartcast", 10, "Podcast Page");
        commonFunctions.tapBackButton();
        commonFunctions.clickElementIfDisplayed(exploreCloseIcon,10,"explore Close Icon");
        return checkPodcastPageStatus;
    }

    @Override
    public boolean checkLoungePage() {
        boolean checkLoungePageStatus;
        clickOnHomeAndExploreTab();
        commonFunctions.checkElementVisibilityByScrolling(lounge, "lounge");
        commonFunctions.clickElement(lounge, 10, "Lounge");
        commonFunctions.dummyWait(5);
        commonFunctions.changeContextToWeb();
        checkLoungePageStatus = commonFunctions.checkPageURL("lifestyle.livemint.com", 10, "Lounge Page");
        commonFunctions.tapBackButton();
        commonFunctions.clickElementIfDisplayed(exploreCloseIcon,10,"explore Close Icon");
        return checkLoungePageStatus;
    }

    @Override
    public boolean checkCompaniesSectionPage(String[] params) {
        boolean checkCompaniesSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkCompaniesSectionPageStatus = commonFunctions.checkElementVisibilityByScrolling(companies, "companies");
        commonFunctions.clickElement(companies, 10, "Companies");
        checkCompaniesSectionPageStatus &= commonFunctions.checkElementText(companiesLanding, "COMPANIES", 10, "text: companies");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkCompaniesSectionPageStatus;
    }

    @Override
    public boolean checkEducationSectionPage(String[] params) {
        boolean checkEducationSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkEducationSectionPageStatus =commonFunctions.checkElementVisibilityByScrolling(education, "education");
        commonFunctions.clickElement(education, 10, "Education");
        checkEducationSectionPageStatus &= commonFunctions.checkElementText(educationLanding, "EDUCATION", 10, "text: education");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkEducationSectionPageStatus;
    }

    @Override
    public boolean checkIndustrySectionPage(String[] params) {
        boolean isIndustrySectionPageNotBlank;
        clickOnHomeAndExploreTab();
        isIndustrySectionPageNotBlank =commonFunctions.checkElementVisibilityByScrolling(industry, "industry");
        commonFunctions.clickElement(industry, 10, "Industry");
        isIndustrySectionPageNotBlank &= commonFunctions.checkElementText(industryLanding, "INDUSTRY", 10, "text: industry");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return isIndustrySectionPageNotBlank;
    }

    @Override
    public boolean checkMarketSectionPage(String[] params) {
        boolean checkMarketSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkMarketSectionPageStatus =commonFunctions.checkElementVisibilityByScrolling(markets, "markets");
        commonFunctions.clickElement(markets, 10, "Markets");
        commonFunctions.dummyWait(5);
        checkMarketSectionPageStatus &= commonFunctions.checkElementText(marketsLanding, "MARKETS", 10, "text: market");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkMarketSectionPageStatus;
    }

    @Override
    public boolean checkTechnologySectionPage(String[] params) {
        boolean checkTechnologySectionPageStatus;
        clickOnHomeAndExploreTab();
        checkTechnologySectionPageStatus = commonFunctions.checkElementVisibilityByScrolling(technology, "technology");
        commonFunctions.clickElement(technology, 10, "Technology");
        checkTechnologySectionPageStatus &= commonFunctions.checkElementText(technologyLanding, "TECHNOLOGY", 10, "text: technology");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkTechnologySectionPageStatus;
    }

    @Override
    public boolean checkSportsSectionPage(String[] params) {
        boolean checkSportsSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkSportsSectionPageStatus = commonFunctions.checkElementVisibilityByScrolling(sports, "sports");
        commonFunctions.clickElement(sports, 10, "Sports");
        checkSportsSectionPageStatus &= commonFunctions.checkElementText(sportsLanding, "SPORTS", 10, "text :sports");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkSportsSectionPageStatus;
    }

    @Override
    public boolean checkPoliticsSectionPage(String[] params) {
        boolean checkPoliticsSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkPoliticsSectionPageStatus =commonFunctions. checkElementVisibilityByScrolling(politics, "politics");
        commonFunctions.clickElement(politics, 10, "Politics");
        checkPoliticsSectionPageStatus &= commonFunctions.checkElementText(politicsLanding, "POLITICS", 10, "text: politics");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkPoliticsSectionPageStatus;
    }

    @Override
    public boolean checkInsuranceSectionPage(String[] params) {
        boolean isShowing;
        clickOnHomeAndExploreTab();
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.checkElementVisibilityByScrolling(insurance, "insurance");
        commonFunctions.clickElement(insurance, 10, "insurance section");
        isShowing &= commonFunctions.checkElementText(insuranceLanding, "INSURANCE", 10, "insurance text");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkMoneySectionPage(String[] params) {
        boolean checkInsuranceSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkInsuranceSectionPageStatus =commonFunctions.checkElementVisibilityByScrolling(money, "Money");
        commonFunctions.clickElement(money, 10, "Money");
        checkInsuranceSectionPageStatus &= commonFunctions.checkElementText(moneyLanding, "MONEY", 10, "text: money");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkInsuranceSectionPageStatus;
    }

    @Override
    public boolean checkMutualFundSectionPage(String[] params) {
        boolean checkInsuranceSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkInsuranceSectionPageStatus =commonFunctions.checkElementVisibilityByScrolling(mutualFund, "Mutual Funds");
        commonFunctions.clickElement(mutualFund, 10, "Mutual Funds");
        commonFunctions.dummyWait(5);
        checkInsuranceSectionPageStatus &= commonFunctions.checkElementText(mutualFundLanding, "MUTUAL FUNDS", 10, "text: mutual funds");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkInsuranceSectionPageStatus;
    }

    @Override
    public boolean checkOpinionSectionPage(String[] params) {
        boolean checkOpinionSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkOpinionSectionPageStatus = commonFunctions.checkElementVisibilityByScrolling(opinion, "opinion");
        commonFunctions.clickElement(opinion, 10, "Opinion");
        commonFunctions.dummyWait(5);
        checkOpinionSectionPageStatus &= commonFunctions.checkElementText(opinionLanding, "OPINION", 10, "text: opinion");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkOpinionSectionPageStatus;
    }

    @Override
    public boolean checkPhotosSectionPage(String[] params) {
        boolean checkPhotosSectionPageStatus;
        clickOnHomeAndExploreTab();
        checkPhotosSectionPageStatus =commonFunctions.checkElementVisibilityByScrolling(photos, "photos");
        commonFunctions.clickElement(photos, 10, "Photos");
        commonFunctions.dummyWait(5);
        checkPhotosSectionPageStatus &= commonFunctions.checkElementText(photosLanding, "PHOTOS", 10, "text: photos");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return checkPhotosSectionPageStatus;
    }

    @Override
    public boolean checkQuickReadsPage(String[] params) {
        boolean checkAutoNewsPageStatus = false;
        clickOnHomeAndExploreTab();
        commonFunctions.scrollUpUntilElementFound(quickReads);
        if (quickReads.isDisplayed()) {
            commonFunctions.clickElement(quickReads, 10, "Quick Reads");
            checkAutoNewsPageStatus = commonFunctions.checkElementText(quickReadsHeading, "QUICK READS", 10, "text:quicks reads");
            commonFunctions.clickElement(back, 10, "Back to Explore Menu");
            commonFunctions.clickByCoordinates(0,47,"explore close icon");
        } else if (!quickReads.isDisplayed()) {
            checkAutoNewsPageStatus = true;
        }
        return checkAutoNewsPageStatus;
    }

    public boolean videoValidation() {
        boolean clickExplore = commonFunctions.clickElement(explore);
        Utils.logStepInfo(clickExplore, "Clicked on Explore");
        boolean preConditionIsSectionVisible =commonFunctions.checkElementVisibilityByScrolling(videos, "videos");
        if (!preConditionIsSectionVisible) {
            commonFunctions.clickElement(explore, 10, "Explore");
           commonFunctions.checkElementVisibilityByScrolling(videos, "videos");
        }
        //commonFunctions.scrollUntilElementFound(videos);
        boolean clickVideo = commonFunctions.clickElement(videos);
        Utils.logStepInfo(clickVideo, "Click on Videos");
        boolean checkVideoPage = commonFunctions.isElementDisplayed(videosLanding, 10, "Videos Page");
        Utils.logStepInfo(checkVideoPage, "Successfully Landed on Videos page");
        boolean openVideo = commonFunctions.clickElement(videoStoryTitle, 10, "Video Story");
        Utils.logStepInfo(openVideo, "Opened video");
        boolean isVideoPlaying = commonFunctions.isElementDisplayed(videoPlayer, 10, "Video Player");
        Utils.logStepInfo(isVideoPlaying, "Video is playing");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return clickVideo && checkVideoPage && openVideo && clickExplore && clickVideo && isVideoPlaying;
    }

    @Override
    public boolean checkSearchSectionPage(String serachText) {
        return false;
    }

    @Override
    public boolean checkAppVersionDisplayed() {
        return false;
    }


}