package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonExplorePage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExplorePage extends CommonExplorePage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;
    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;
    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(accessibility = "Market Dashboard")
    private static MobileElement exploreMarketDashboard;
    @iOSXCUITFindBy(accessibility = "MARKETS")
    private static MobileElement marketPage;
    @iOSXCUITFindBy(accessibility = "Mint Premium")
    private static MobileElement exploreMintPremium;
    @iOSXCUITFindBy(id = "PREMIUM")
    private static MobileElement premiumPage;
    @iOSXCUITFindBy(accessibility = "Podcast")
    private static MobileElement explorePodcast;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement exploreHamburger;
    @iOSXCUITFindBy(accessibility = "EXPLORE")
    private static MobileElement explorePage;
    @iOSXCUITFindBy(accessibility = "PODCAST")
    private static MobileElement podCastPage;
    @iOSXCUITFindBy(accessibility = "Share the App")
    private static MobileElement shareTheApp;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='AirDrop']")
    private static MobileElement airDrop;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Messages']")
    private static MobileElement message;
    @iOSXCUITFindBy(accessibility = "More")
    private static MobileElement moreOption;
    @iOSXCUITFindBy(accessibility = "Close")
    private static MobileElement close;
    @iOSXCUITFindBy(accessibility = "Rate the App")
    private static MobileElement rateTheApp;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;

    public ExplorePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        System.out.println("****************** Test started ******************");
    }

    @Override
    public boolean checkMarketDashboardPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(home, exploreHamburger, explorePage);
        isShowing &= commonFunctionsMobile.clickOnExploreMarketDashboardAndVerifyPage(exploreMarketDashboard, marketPage);
        return isShowing;
    }

    @Override
    public boolean checkMintPremiumPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(home, exploreHamburger, explorePage);
        isShowing &= commonFunctionsMobile.clickOnExploreMintPremiumAndVerifyPage(exploreMintPremium, premiumPage);
        return isShowing;
    }

    @Override
    public boolean checkPodcastPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(home, exploreHamburger, explorePage);
        isShowing &= commonFunctionsMobile.clickOnExplorePodcastAndVerifyPage(explorePodcast, podCastPage);
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.killAppAndReLaunch();
        return isShowing;
    }

    @Override
    public boolean checkShareAppOption() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(home, exploreHamburger, explorePage);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(shareTheApp, "share app");
        commonFunctions.clickElement(shareTheApp, 10, "share app");
        isShowing &= commonFunctions.isElementDisplayed(airDrop, 10, "airDrop option");
        isShowing &= commonFunctions.isElementDisplayed(moreOption, 10, "mre option");
        isShowing &= commonFunctions.isElementDisplayed(message, 10, "Message option");
        commonFunctions.clickElement(close, 10, "close popup");
        commonFunctions.killAppAndReLaunch();
        return isShowing;
    }

    @Override
    public boolean checkRateApp() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(home, exploreHamburger, explorePage);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(rateTheApp, "rate app");
        commonFunctions.killAppAndReLaunch();
        return isShowing;
    }

    @Override
    public boolean checkRateAppLaterButton() {
        return false;
    }

    @Override
    public boolean checkRateAppSubmitButton() {
        return false;
    }

    @Override
    public boolean checkRateAppWithFiveStarRating() {
        return false;
    }

    @Override
    public boolean checkRateAppWithBelowFiveStarRating() {
        return false;
    }

    @Override
    public boolean checkSignInButtonFromExplore() {
        return false;
    }

    @Override
    public boolean checkBackToHomePageFromEpaperSubscribeNow() {
        return false;
    }

    @Override
    public boolean checkBackExplorePageToHomePage() {
        return false;
    }

    @Override
    public boolean checkSubscribeNowButtonFromEpaper() {
        return false;
    }

    @Override
    public boolean checkEpaperPage() {
        return false;
    }

    @Override
    public boolean checkSignInButtonFromEpaper() {
        return false;
    }
}
