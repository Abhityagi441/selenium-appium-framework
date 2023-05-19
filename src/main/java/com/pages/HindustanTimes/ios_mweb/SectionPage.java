package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsWebHt;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class SectionPage extends CommonSectionPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebHt commonFunctionsHt;
    private static CommonFunctionsMobileHt commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(className = "btnExplore")
    private static WebElement explore;

    @FindBy(xpath = "//div[@class='listPagination']")
    private static WebElement scrollDownToListPagination;

    @FindBy(xpath = "//a[text()='india news']")
    private static List<MobileElement> indiaNewsSection;

    @FindBy(xpath = "//ul[@id='cohort_subnav']/li")
    private static List<WebElement> carousalTargetList;

    @FindBy(xpath = "//div[@class='tpcTags']/a")
    private static List<WebElement> topics;

    @FindBy(xpath = "//section[@id='dataHolder']/div[1]/div/h1")
    private static WebElement landingPage;

    @FindBy(xpath = "//ul[contains(@class,'leftSecNav')]/li")
    private static List<WebElement> l1Elements;

    @FindBy(xpath = "//div[text()='Latest News']")
    private static WebElement latestNewsSearch;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private static WebElement searchBox;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbs;

    @FindBy(xpath = "//ul[contains(@class,'leftSecNav')]/li")
    private static List<WebElement> l2Elements;

    @FindBy(xpath = "//ul[contains(@class,'leftSecNav')]/li[contains(@class,'new')]")
    private static List<WebElement> l2ElementsNewTag;

    @FindBy(xpath = "(//div[@class='read__more']/a)[1]")
    private static List<WebElement> readFullStoryInQuickRead;

    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsHt = CommonFunctionsWebHt.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkIsSectionIndiaNewsScrollable() {
        commonFunctions.clickElementWithJS(explore, 10, "clicked on explore");
        commonFunctions.clickElementWithJS(indiaNews, 10, "clicked on india News");
        commonFunctions.scrollDownToBottom();
        commonFunctions.dummyWait(10);
        boolean scrollIndiaNews = commonFunctions.isElementDisplayed(scrollDownToListPagination, 10, "Bottom of Page");
        return scrollIndiaNews;
    }

    @Override
    public boolean checkIsSectionIndiaNewsDisplayedClickable() {
        commonFunctions.clickElementWithJS(explore, 10, "clicked on explore");
        commonFunctions.clickElementWithJS(indiaNews, 10, "clicked on india News");
        commonFunctions.dummyWait(10);
        boolean scrollIndiaNews = commonFunctions.isElementDisplayedOfListOfElements(indiaNewsSection, "India News Section name in top of every story");
        commonFunctions.clickElementWithJS(indiaNewsSection.get(5), 10, "clicked on india News");
        commonFunctions.dummyWait(10);
        boolean scrollIndiaNewsRefresh = commonFunctions.isElementDisplayedOfListOfElements(indiaNewsSection, "India News Section name in top of every story after refresh");
        return scrollIndiaNews && scrollIndiaNewsRefresh;
    }

    @Override
    public boolean checkFullStoryVisisbleAndClickableInQuickRead(String quickReadURL, String readSFullStoryText, String target1, String target2) {
        return commonFunctionsMobile.checkFullStoryVisibleAndClickableMWeb(quickReadURL, readSFullStoryText, target1, target2, carousalTargetList, readFullStoryInQuickRead);
    }

    @Override
    public boolean checkTopicPage(String topicURL) {
        boolean isTop200TrendingTopicDisplayed = true;
        //commonFunctions.navigateToURL(Utils.getUrl());
        commonFunctions.navigateToURL(globalVars.getURL() + topicURL);
        int topicSize = topics.size();
        if (topicSize == 200) {
            isTop200TrendingTopicDisplayed = true;
            Utils.logStepInfo("Top 200 trending topic displayed. This is expected");
        } else
            isTop200TrendingTopicDisplayed = false;
        Utils.logStepInfo("Top 200 trending topic not displayed");
        return isTop200TrendingTopicDisplayed;
    }

    @Override
    public boolean checkTopicLandingPage(String topicURL) {
        commonFunctions.navigateToURL(globalVars.getURL() + topicURL);
        boolean topicLandingPageStatus = commonFunctionsHt.verifyTopicLandingPage(topics,landingPage,1);
        topicLandingPageStatus &= commonFunctionsHt.verifyTopicLandingPage(topics,landingPage,10);
        topicLandingPageStatus &= commonFunctionsHt.verifyTopicLandingPage(topics,landingPage,190);
        return topicLandingPageStatus;
    }

    @Override
    public boolean checkL1LandingPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        String landingPageElementName = l1Elements.get(1).getText();
        commonFunctions.clickElementWithJS(l1Elements.get(0), 10, "L1 Elements");
        commonFunctions.dummyWait(30);
        boolean checkTopicLandingPageStatus1 = commonFunctionsHt.checkSectionLandingPage(landingPage, landingPageElementName, 30);
        commonFunctions.navigateBack();
        landingPageElementName = l1Elements.get(4).getText();
        commonFunctions.dummyWait(30);
        commonFunctions.clickElementWithJS(l1Elements.get(4), 10, "L1 Elements");
        boolean checkTopicLandingPageStatus2 = commonFunctionsHt.checkSectionLandingPage(landingPage, landingPageElementName, 30);
        commonFunctions.navigateBack();
        landingPageElementName = l1Elements.get(15).getText();
        commonFunctions.dummyWait(30);
        commonFunctions.clickElementWithJS(l1Elements.get(15), 10, "L1 Elements");
        boolean checkTopicLandingPageStatus3 = commonFunctionsHt.checkSectionLandingPage(landingPage, landingPageElementName, 30);
        commonFunctions.navigateBack();
        return checkTopicLandingPageStatus1 && checkTopicLandingPageStatus2 && checkTopicLandingPageStatus3;
    }

    @Override
    public boolean checkBreadcrumbDisplayedFromGoogle(String url, String searchText) {
        boolean checkBreadcrumbDisplayedFromGoogleStatus;
        commonFunctions.navigateToURL(url);
        commonFunctions.clickElement(searchBox, 10, "Google Search");
        commonFunctions.sendKey(searchBox, searchText, 60);
        commonFunctions.sendKeyStroke(Keys.ENTER);
        boolean searchStatus = commonFunctions.isElementDisplayed(latestNewsSearch, 10, "latestNewsSearchResult");
        if (!searchStatus) {
            commonFunctions.scrollUntilElementFound(latestNewsSearch);
        }
        commonFunctions.clickElementWithJS(latestNewsSearch, 10, "Latest News");
        commonFunctions.dummyWait(30);
        //The below step returns false although the breadcrumb is visible
        checkBreadcrumbDisplayedFromGoogleStatus = commonFunctions.isElementDisplayed(breadCrumbs, 10, "BreadCrumbs");
        return checkBreadcrumbDisplayedFromGoogleStatus;
    }

    @Override
    public boolean checkL2NewTag() {
        commonFunctions.navigateToURL(globalVars.getURL());
        int l2SectionSize = l2Elements.size();
        if (l2SectionSize >= 1) {
            Utils.logStepInfo(true, "L2 section line up just below the mast head and L1 present");
        } else {
            Utils.logStepInfo(false, "L2 section line up just below the mast head and L1 not present");
        }
        String landingPageElementName = l2ElementsNewTag.get(0).getText();
        commonFunctions.clickElement(l2ElementsNewTag.get(0), 10, "L2 Elements");
        commonFunctions.dummyWait(10);
        boolean checkL2NewTagStatus = commonFunctionsHt.checkSectionLandingPage(landingPage, landingPageElementName, 30);
        Set<String> noOfWindows = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1);
        if (noOfWindows.size() == 1) {
            Utils.logStepInfo(true, "Opened the specific page in same tab. This is expected");
        } else {
            Utils.logStepInfo(false, "Opened the specific page in new tab. This is not expected");
        }
        commonFunctions.navigateBack();
        return checkL2NewTagStatus;

    }

    @Override
    public boolean checkAppLaunchDisplayTopSection() {
        return false;
    }

    @Override
    public boolean checkBottomNavHomeSelected() {
        return false;
    }

    @Override
    public boolean checkBottomNavDispalyFromAnotherSectionPage() {
        return false;
    }

    @Override
    public boolean checkSectionRedirectionPage() {
        return false;
    }

    @Override
    public boolean checkBusinessSection() {
        return false;
    }

    @Override
    public boolean checkSudokuSection() {
        return false;
    }

    @Override
    public boolean checkClickCityDisplayCitiesInExplore() {
        return false;
    }

    @Override
    public boolean checkClickExplorePageAppearAgain() {
        return false;
    }

    @Override
    public boolean checkCitiesSectionNameisDispayed() {
        return false;
    }

    @Override
    public boolean checkNoidaSubSectionNameisDispayed() {
        return false;
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionNamesDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionLiveBlogWithRedDotOnStory() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromExploreToPhotos() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromExploreToVideos() {
        return false;
    }

    @Override
    public boolean checkPremiumStoryInsideSectionPage() {
        return false;
    }

    @Override
    public boolean checkUserScrollToBottomOfTopNewsPage() {
        return false;
    }

    @Override
    public boolean checkForLiveBlogForTopNewsPage() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromWorld() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromCities() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromIndia() {
        return false;
    }

    @Override
    public boolean SubSectionNameInCitiesSection() {
        return false;
    }

    @Override
    public boolean WorldSectionInDarkMode() {
        return false;
    }

    @Override
    public boolean opinionSectionRedirection() {
        return false;
    }

    @Override
    public boolean checkScrollingOnOpinion() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromOpinion() {
        return false;
    }

    @Override
    public boolean checkAdAfterFiveStories() {
        return false;
    }

    @Override
    public boolean redirectToCricketSection() {
        return false;
    }

    @Override
    public boolean redirectToEntertainmentSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromEntertainment() {
        return false;
    }

    @Override
    public boolean subSectionInEntertainment() {
        return false;
    }

    @Override
    public boolean redirectToSubSectionInEntertainment() {
        return false;
    }

    @Override
    public boolean redirectToToTrendingSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromTrendingSection() {
        return false;
    }

    @Override
    public boolean redirectOnVideoSection() {
        return false;
    }

    @Override
    public boolean subSectionNamesInVideoPage() {
        return false;
    }

    @Override
    public boolean appearanceOfVideoSectionPage() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromVideoSectionPage() {
        return false;
    }

    @Override
    public boolean redirectToSubsectionOfVideoSection() {
        return false;
    }

    @Override
    public boolean redirectOnLifeStyleSection() {
        return false;
    }

    @Override
    public boolean redirectToSubSectionOfLifeStyle() {
        return false;
    }

    @Override
    public boolean storyInLifeStyleSection() {
        return false;
    }

    @Override
    public boolean redirectToEducationSection() {
        return false;
    }

    @Override
    public boolean subSectionOnEducationSection() {
        return false;
    }

    @Override
    public boolean redirectionOnSportSection() {
        return false;
    }

    @Override
    public boolean redirectToSubSectionFromSportSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromSportSection() {
        return false;
    }

    @Override
    public boolean redirectToPhotosSection() {
        return false;
    }

    @Override
    public boolean shareStoryFromSportsSection() {
        return false;
    }

    @Override
    public boolean appearanceOfPhotosSection() {
        return false;
    }

    @Override
    public boolean marketStatWidgetAfterFirstStory() {
        return false;
    }

    @Override
    public boolean redirectToBusinessSection() {
        return false;
    }

    @Override
    public boolean marketStatWidgetFourOptions() {
        return false;
    }

    @Override
    public boolean checkValuesInMarketStatWidget() {
        return false;
    }

    @Override
    public boolean redirectToMumbaiNewsSection() {
        return false;
    }

    @Override
    public boolean storyDisplayedAfterMarketStatWidget() {
        return false;
    }

    @Override
    public boolean checkRedirectToBusinessStory() {
        return false;
    }

    @Override
    public boolean checkRedirectToDelhiNewsSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryOfMumbaiNewsSection() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromDelhiNewsSection() {
        return false;
    }

    @Override
    public boolean checkRedirectToTvNewsSection() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromTTvNewsSection() {
        return false;
    }

    @Override
    public boolean checkCameraIconWithNumberOfPhotosInPhotosSection() {
        return false;
    }

    @Override
    public boolean countInleadStoryInPhotosSection() {
        return false;
    }

    @Override
    public boolean checkWebStoriesSectionFromTopSection() {
        return false;
    }

    @Override
    public boolean checkWebStoriesSectionFromExplore() {
        return false;
    }

    @Override
    public boolean checkImagesHorizontalLinesInWebStories() {
        return false;
    }

    @Override
    public boolean checkAppLogoInWebStories() {
        return false;
    }

    @Override
    public boolean checkThreeDotsDislpayedInWebStories() {
        return false;
    }

    @Override
    public boolean photoSectionInDarkMode() {
        return false;
    }

    @Override
    public boolean redirectToPhotoSectionStory() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromPhotosSection() {
        return false;
    }

    @Override
    public boolean shareStoryFromPhotoSection() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnForYouSection() { return false; }

    @Override
    public boolean checkEditProfilePageInDarkMode() {
        return false;
    }

    @Override
    public boolean checkTextOnCityPopUp() { return false; }

    @Override
    public boolean checkRedirectionOnCitiesSection() { return false; }

    @Override
    public boolean checkRedirectionWhenTapOnGotItButton() { return false; }

    @Override
    public boolean checkNoRedirectionWhenTapOnWhenAnyWhereExceptGotItButton() { return false; }

    @Override
    public boolean checkPlusSignDisplayBeforeCityName() { return false; }

    @Override
    public boolean checkHorizontalLinesAtEndOfCityName() { return false; }

    @Override
    public boolean checkMayBeLaterAndSaveChangesButton() { return false; }

    @Override
    public boolean checkOthersOptionInCities() { return false; }

    @Override
    public boolean checkBehaviourWhenUserTapsOnPlusButtonBeforeCityName() {
        return false;
    }

    @Override
    public boolean checkBehaviourWhenUserTapsOnMayBeLaterButton() { return false; }

    @Override
    public boolean checkBehaviourNoCitySelectedAndTapsOnSaveChangesButton() { return false; }

    @Override
    public boolean checkPopUpWhenSelectAnyCity() { return false; }

    @Override
    public boolean checkSelectedCityShownUnderCitiesSection() { return false; }

    @Override
    public boolean checkBehaviourWhenUserSelectAnyCityAndTapsOnMayBeLaterButton() { return false; }

    @Override
    public boolean checkDateInCitiesAfterSelectedCity() { return false; }

    @Override
    public boolean checkTemperatureDisplayedInCitiesSection() { return false; }

    @Override
    public boolean checkCityNameDisplayedAfterAdWithNews() { return false; }

    @Override
    public boolean checkRedirectionWhenTapOnOtherSelectedCities() { return false; }

    @Override
    public boolean checkRedirectionWhenTapOnMultipleCities() { return false; }

    @Override
    public boolean checkBehaviourWhenUserDeselectAnySelectedCity() { return false; }

    @Override
    public boolean checkFourthStoryPartneredStory() {
        return false;
    }

    @Override
    public boolean checkViewFullScorecard(String cricketUrl, String liveScorecard) {
        return false;
    }

    @Override
    public boolean checkMatchCard(String cricketUrl) {
        return false;
    }

    @Override
    public boolean checkLHSAndRHSData(String indiaNewsUrl) {
        return false;
    }

    @Override
    public boolean checkPagination(String secondPageUrl,String worldNewsUrl) {
        return false;
    }

    @Override
    public boolean checkThirtyStoryOnSectionPage(String worldNewsUrl) {
        return false;
    }

    @Override
    public boolean checkAdsAfterEveryThreeStory() {
        return false;
    }

    @Override
    public boolean checkFirstStoryInCardView() {
        return false;
    }
}