package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonAdvertisementPage;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdvertisementPage extends CommonAdvertisementPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonSectionPage sectionPage;

    @iOSXCUITFindBy(id = "agree")
    private static MobileElement acceptCookie;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;
    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;
    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;
    @iOSXCUITFindBy(id = "RECOMMENDED FOR YOU")
    private static MobileElement recommendedForYouCarousel;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[6]")
    private static MobileElement homePageAdsBanner;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Top News')]")
    private static MobileElement topNewsHomePage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'BSE SENSEX'`]")
    private static MobileElement marketSensex;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Remove Ad'`][1]")
    private static MobileElement removeAd;
    @iOSXCUITFindBy(id = "Choose a plan")
    private static MobileElement planPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement backButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Advertisement'`][2]")
    private static MobileElement secondAdsAdvertisement;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Companies']")
    private static MobileElement companies;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COMPANIES']")
    private static MobileElement companiesLanding;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Got it')]")
    private static MobileElement gotIt;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;
    @iOSXCUITFindBy(id = "Latest")
    private static MobileElement latest;
    @iOSXCUITFindBy(id = "LATEST")
    private static MobileElement latestLandingPage;
    @iOSXCUITFindBy(id = "Trending")
    private static MobileElement trending;
    @iOSXCUITFindBy(id = "TRENDING")
    private static MobileElement trendingLandingPage;
    @iOSXCUITFindBy(id = "Label")
    private static MobileElement firstStory;
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell[3]")
    private static MobileElement homePageSecondStory;
    @iOSXCUITFindBy(id = "close round")
    private static MobileElement closeButtonMintPremiumPopup;
    @iOSXCUITFindBy(id = "Close Advertisement")
    private static MobileElement closeButtonAdvertisement;
    @iOSXCUITFindBy(id = "For You")
    private static MobileElement forYouTab;
    @iOSXCUITFindBy(accessibility = "FOR YOU")
    private static MobileElement forYouPage;
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell[2]")
    private static MobileElement forYouPageFirstStory;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Back'`][2]")
    private static MobileElement forYouStoryDetailPageBackButton;
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell[3]")
    private static MobileElement forYouPageSecondStory;
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell[4]")
    private static MobileElement forYouPageThirdStory;
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell[5]")
    private static MobileElement forYouPageFourthStory;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;


    public AdvertisementPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        sectionPage = CommonSectionPage.getInstance();
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkAdsOnHomePage() {
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUpToElementDisplayed(recommendedForYouCarousel);
        return commonFunctions.isElementDisplayed(homePageAdsBanner, 10, "ads banner");
    }

    @Override
    public boolean checkAdsOnSectionPage() {
        return false;
    }

    private boolean ClickOnAdsAndVerifyPlanPageAndBack() {
        boolean isShowing;
        commonFunctions.clickElement(removeAd, 10, "remove ads");
        isShowing = commonFunctions.isElementDisplayed(planPage, 10, "Plan page");
        commonFunctions.clickElement(backButton, 10, "Back button plan page");
        return isShowing;
    }

    @Override
    public boolean checkLeadsAdsOnHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home tab");
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(firstStory, 10, "Home page");
        isShowing &= commonFunctions.isElementDisplayed(removeAd, 10, "Leads Ads on home page");
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityAndBackButton() {
        boolean isShowing;
        isShowing = checkLeadsAdsOnHomePage();
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        isShowing &= commonFunctions.isElementDisplayed(topNewsHomePage, 10, "Top News on Home page");
        return isShowing;
    }

    @Override
    public boolean checkSecondAdsRemoveAdsFunctionalityAndBackButton() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home tab");
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.checkElementVisibilityByScrolling(secondAdsAdvertisement, "second ads advertisement");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        commonFunctions.clickElement(home, 10, "Home tab");
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityOnTopicPage() {
        boolean isShowing;
        sectionPage.clickOnHomeAndExploreTab();
        isShowing = commonFunctions.checkElementVisibilityByScrolling(companies, "companies");
        commonFunctions.clickElement(companies, 10, "Companies");
        isShowing &= commonFunctions.checkElementText(companiesLanding, "COMPANIES", 10, "text: companies");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        commonFunctions.clickElement(back, 10, "Back to explore page");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityOnLatestAndTrendingPage() {
        boolean isShowing;
        commonFunctions.clickElement(latest, 10, "Latest Tab");
        isShowing = commonFunctions.isElementDisplayed(latestLandingPage, 10, "Latest Page");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        commonFunctions.clickElement(trending, 10, "Trending Tab");
        commonFunctions.isElementDisplayed(trendingLandingPage, 10, "Trending Page");
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        return isShowing;
    }

    @Override
    public boolean checkRemoveAdsFunctionalityOnStoryDetailPage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home tab");
        commonFunctions.clickElement(forYouTab, 10, "forYou Tab");
        isShowing = commonFunctions.isElementDisplayed(forYouPage, 10, "forYou Page");
        commonFunctions.clickElementWithCoordinates(153,429);
        isShowing &= ClickOnAdsAndVerifyPlanPageAndBack();
        isShowing &= commonFunctions.isElementDisplayed(removeAd, 10, "remove ads");
        commonFunctions.clickElement(forYouTab, 10, "forYou Tab");
        isShowing &= commonFunctions.isElementDisplayed(forYouPage, 10, "forYou Page");
        return isShowing;
    }

    @Override
    public boolean checkFirstInterstitialAds() {
        boolean isShowing;
        commonFunctions.killAppAndReLaunch();
        commonFunctions.clickElementIfDisplayed(closeButtonMintPremiumPopup, 5, "close Button Mint Premium Popup");
        commonFunctions.clickElement(home, 10, "home page");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(homePageSecondStory,"second story");
        commonFunctions.clickElement(homePageSecondStory, 10, "home page second story");
        commonFunctions.clickElementIfDisplayed(gotIt, 10, "Pop up");
        commonFunctions.clickElement(home, 10, "HomePage");
        commonFunctions.clickElement(firstStory, 10, "home page first story");
        isShowing &= commonFunctions.isElementDisplayed(closeButtonAdvertisement, 10, "First interstitial advertisement");
        commonFunctions.clickElement(closeButtonAdvertisement, 10, "close button advertisement");
        isShowing &= commonFunctions.isElementDisplayed(home, 10, "home page");
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        isShowing &= commonFunctions.isElementDisplayed(forYouPage, 10, "for You Page");
        commonFunctions.clickElement(forYouPageFirstStory, 10, "ForYou Page first story");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        commonFunctions.clickElement(forYouPageSecondStory, 10, "ForYou Page Second story");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        commonFunctions.clickElement(forYouPageThirdStory, 10, "ForYou Page Third story");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(forYouPageFourthStory,"Fourth story");
        commonFunctions.clickElement(forYouPageFourthStory, 10, "ForYou Page Fourth story");
        isShowing &= commonFunctions.isElementDisplayed(closeButtonAdvertisement, 10, "second Interstitial advertisement");
        commonFunctions.clickElement(closeButtonAdvertisement, 30, "close button advertisement");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        return isShowing;
    }

    @Override
    public boolean checkSecondInterstitialAds() {
        boolean isShowing;
        isShowing = checkFirstInterstitialAds();
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        isShowing &= commonFunctions.isElementDisplayed(forYouPage, 10, "for You Page");
        commonFunctions.clickElement(forYouPageFirstStory, 10, "ForYou Page first story");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        commonFunctions.clickElement(forYouPageSecondStory, 10, "ForYou Page Second story");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        commonFunctions.clickElement(forYouPageThirdStory, 10, "ForYou Page Third story");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(forYouPageFourthStory,"Fourth story");
        commonFunctions.clickElement(forYouPageFourthStory, 10, "ForYou Page Fourth story");
        isShowing &= commonFunctions.isElementDisplayed(closeButtonAdvertisement, 10, "second Interstitial advertisement");
        commonFunctions.clickElement(closeButtonAdvertisement, 30, "close button advertisement");
        commonFunctions.clickElement(forYouStoryDetailPageBackButton, 10, "back button story detail page");
        return isShowing;
    }

    @Override
    public boolean checkAdsOnSubscribedHomePage(){
        return false;
    }

    @Override
    public boolean checkAdsOnSubscribedStoryPage(){
        return false;
    }

    @Override
    public boolean checkAdsOnSubscribedlistingPage(String pageName){
        return false;
    }

    @Override
    public boolean checkSponsoredAd() {
        return false;
    }
}