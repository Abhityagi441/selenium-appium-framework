package com.pages.HindustanTimes.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SectionPage extends CommonSectionPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbsName;

    @FindBy(className = "//ul[@class='leftFixedNav']//a[contains(@data-id,'India')]")
    private static WebElement indiaNewsLinkFromNavigationMenu;

    @FindBy(xpath = "(//button[@class='subscribe'])[1]")
    private static WebElement doThisLaterButton;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(xpath = "(//div[@class = 'btnExplore'])[1]")
    private static WebElement explore;

    @FindBy(xpath = "//div[@class='listPagination']")
    private static WebElement scrollDownToListPagination;

    @FindBy(xpath = "//*[@class ='actionDiv flexElm']/div[1]")
    private static List<MobileElement> indiaNewsSection;


    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.navigateToURL(globalVars.getURL());
    }

    @Override
    public boolean checkIsSectionIndiaNewsScrollable() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Do this later button on push notification");
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElementIfDisplayed(explore,10,"Explore if Displayed");
        commonFunctions.clickElementWithJS(indiaNews, 10, "India News");
        commonFunctions.dummyWait(10);
        commonFunctions.scrollToElementView(scrollDownToListPagination,20,"Pagination in Page");
        boolean scrollIndiaNews = commonFunctions.isElementDisplayed(scrollDownToListPagination, 10, "Bottom of Page");
        return scrollIndiaNews;
    }

    @Override
    public boolean checkIsSectionIndiaNewsDisplayedClickable() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Do this later button on push notification");
        commonFunctions.dummyWait(0);
        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElementIfDisplayed(explore, 10, "Explore if displayed");
        commonFunctions.clickElementWithJS(indiaNews, 10, "India News");
        boolean scrollIndiaNews = commonFunctions.isElementDisplayedOfListOfElements(indiaNewsSection, "India News Section name in top of every story");
        int numberOfSection = indiaNewsSection.size();
        System.out.println("number Of India Section Story = "+numberOfSection);
        Random rand = new Random();
        // Obtain a number between [0 - size of Section names].
        int n = rand.nextInt(numberOfSection - 1);
        commonFunctions.clickElementWithJS(indiaNewsSection.get(n), 10, "India News");
        Utils.logStepInfo(true, "Current url = "+driver.getCurrentUrl() );
        boolean currentURL = driver.getCurrentUrl().contains("india-news");
        boolean scrollIndiaNewsRefresh = commonFunctions.isElementDisplayedOfListOfElements(indiaNewsSection, "India News Section name in top of every story after refresh");
        return scrollIndiaNews && scrollIndiaNewsRefresh && currentURL;
    }

    @Override
    public boolean checkFullStoryVisisbleAndClickableInQuickRead(String quickReadURL, String readSFullStoryText, String target1, String target2) {
        return false;
    }

    @Override
    public boolean checkTopicPage(String topicURL) {
        return false;
    }

    @Override
    public boolean checkTopicLandingPage(String topicURL) {
        return false;
    }

    @Override
    public boolean checkL1LandingPage() {
        return false;
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