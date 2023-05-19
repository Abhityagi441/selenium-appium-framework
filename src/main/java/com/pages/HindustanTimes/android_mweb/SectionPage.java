package com.pages.HindustanTimes.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonSearchPage;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class SectionPage extends CommonSectionPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static ApiValidation apiValidation;

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

    @FindBy(xpath = "(//div[@class='read__more']/a)[1]")
    private static List<WebElement> readFullStoryInQuickRead;

    @FindBy(xpath = "//div[@class='logo']//a")
    private static WebElement htLogo;

    @FindBy(xpath = "//div[@class='tpcTags']/a")
    private static List<WebElement> topics;

    @FindBy(xpath = "//div[@class='hdgStyle']/h1")
    private static WebElement landingPage;

    @FindBy(xpath = "//ul[@class='leftFixedNav']/li/a")
    private static List<WebElement> l1Elements;

    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkIsSectionIndiaNewsScrollable() {
        commonFunctions.clickElementWithJS(explore, 40, "clicked on explore");
        commonFunctions.clickElementWithJS(indiaNews, 10, "clicked on india News");
        commonFunctions.scrollDownToBottom();
        commonFunctions.dummyWait(10);
        boolean scrollIndiaNews = commonFunctions.isElementDisplayed(scrollDownToListPagination, 10, "Bottom of Page");
        return scrollIndiaNews;
    }

    @Override
    public boolean checkIsSectionIndiaNewsDisplayedClickable() {
        commonFunctions.navigateToHomePage();
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

        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(htLogo, 20, "htLogo");
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
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(htLogo, 20, "HTLogo");
        commonFunctions.navigateToURL(globalVars.getURL() + topicURL);
        String landingPageElementName = topics.get(1).getText();
        commonFunctions.clickElementWithJS(topics.get(1), 10, "Topic");
        String landingPageTopics = landingPageElementName.split(" ")[0].toUpperCase();
        boolean checkTopicLandingPageStatus1 = checkSectionLandingPage(landingPage, landingPageTopics, 30);
        commonFunctions.navigateBack();
        landingPageElementName = topics.get(10).getText();
        commonFunctions.clickElementWithJS(topics.get(10), 10, "Topic");
        String landingPageTopics2 = landingPageElementName.split(" ")[0].toUpperCase();

        boolean checkTopicLandingPageStatus2 = checkSectionLandingPage(landingPage, landingPageTopics2, 30);
        commonFunctions.navigateBack();
        commonFunctions.scrollDownToElement(topics.get(199));
        landingPageElementName = topics.get(199).getText();
        String landingPageTopics3 = landingPageElementName.split(" ")[0].toUpperCase();

        commonFunctions.clickElementWithJS(topics.get(199), 10, "Topic");
        boolean checkTopicLandingPageStatus3 = checkSectionLandingPage(landingPage, landingPageTopics3, 30);
        commonFunctions.navigateBack();

        return checkTopicLandingPageStatus1 && checkTopicLandingPageStatus2 && checkTopicLandingPageStatus3;
    }

    public boolean checkSectionLandingPage(WebElement landingPageElement, String landingPageElementName, int timeOut) {
        boolean checkLandingPageStatus;
        commonFunctions.dummyWait(30);
        String actualLandingPageName = commonFunctions.getElementText(landingPageElement, timeOut);
        if (actualLandingPageName.contains(landingPageElementName)) {
            checkLandingPageStatus = true;
            Utils.logStepInfo(true, landingPageElementName + " Landing Page displayed successfully");
        } else {
            checkLandingPageStatus = false;
            Utils.logStepInfo(false, landingPageElementName + " Landing Page is not displayed");
        }
        return checkLandingPageStatus;
    }

    @Override
    public boolean checkL1LandingPage() {

        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(htLogo, 20, "HTLogo");
        String landingPageElementName = l1Elements.get(1).getText();
        commonFunctions.clickElementWithJS(l1Elements.get(1), 10, "L1 Elements");
        String landingPageValue = landingPageElementName.toUpperCase();
        boolean checkTopicLandingPageStatus1 = checkSectionLandingPage(landingPage, landingPageValue, 30);
        commonFunctions.navigateBack();
        landingPageElementName = l1Elements.get(4).getText();
        String landingPageValue2 = landingPageElementName.toUpperCase();
        commonFunctions.clickElementWithJS(l1Elements.get(4), 10, "L1 Elements");
        boolean checkTopicLandingPageStatus2 = checkSectionLandingPage(landingPage, landingPageValue2, 30);
        commonFunctions.navigateBack();
        return checkTopicLandingPageStatus1 && checkTopicLandingPageStatus2;
    }

    @Override
    public boolean checkBreadcrumbDisplayedFromGoogle(String url, String searchText) {
        return false;
    }

    @Override
    public boolean checkL2NewTag() {
        return false;
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
    public boolean checkRedirectionOnForYouSection() {
        return false; }

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
    public boolean checkFourthStoryPartneredStory() {
        return false;
    }

    @Override
    public boolean checkFirstStoryInCardView() {
        return false;
    }
}
