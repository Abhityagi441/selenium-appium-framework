package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonExplorePage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExplorePage extends CommonExplorePage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreHamburger;
    @AndroidFindBy(id = "com.htmedia.mint:id/iv_close")
    private static MobileElement exploreCloseIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private static MobileElement settingsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnNotification")
    private static MobileElement notificationToggleButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App Settings']")
    private static MobileElement settingPageTitle;
    @AndroidFindBy(id = "com.htmedia.mint:id/seekBarTextSize")
    private static MobileElement fontSelector;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @AndroidFindBy(id = "com.htmedia.mint:id/marketDashboardTV")
    private static MobileElement exploreMarketDashboard;
    @FindBy(xpath = "//android.widget.TextView[@text='Market Dashboard']")
    private static MobileElement marketsPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/marketPremiumTV")
    private static MobileElement exploreMintPremium;
    @FindBy(xpath = "//android.widget.TextView[@text='PREMIUM']")
    private static MobileElement mintPremiumPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewPodcasts")
    private static MobileElement podcastOption;
    @FindBy(xpath = "//android.widget.TextView[@text='PODCAST']")
    private static MobileElement podcastPage;
    @FindBy(xpath = "//android.widget.TextView[@text='Bluetooth']")
    private static MobileElement bluetoothText;
    @FindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    private static MobileElement gmailText;
    @FindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private static MobileElement messageText;
    @FindBy(xpath = "//android.widget.TextView[@text='Save to Drive']")
    private static MobileElement driveText;
    @FindBy(xpath = "//android.widget.TextView[@text='Share App']")
    private static MobileElement shareApp;
    @FindBy(xpath = "//android.widget.TextView[@text='Rate App']")
    private static MobileElement rateApp;
    @FindBy(xpath = "//android.widget.RatingBar[@text='5.0']")
    private static MobileElement rateApp5Star;
    @FindBy(id = "com.htmedia.mint:id/dismiss")
    private static MobileElement rateAppLater;
    @FindBy(id = "com.htmedia.mint:id/submit")
    private static MobileElement rateAppSubmit;
    @FindBy(id = "com.htmedia.mint:id/after_rating_layout")
    private static MobileElement afterRatingPopup;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.vending:id/0_resource_name_obfuscated']")
    private static List<MobileElement> playStore;
    @FindBy(id = "com.google.android.gm:id/welcome_tour_title")
    private static MobileElement mailBox;
    @FindBy(id = "com.htmedia.mint:id/txtViewUserName")
    private static MobileElement signIn;
    @FindBy(id = "com.htmedia.mint:id/txtViewEpaper")
    private static MobileElement epaper;
    @FindBy(xpath = "//android.widget.TextView[@text='Sign In']")
    private static MobileElement epaperSignIn;
    @FindBy(xpath = "//android.widget.Image[@text='logo']")
    private static MobileElement epaperPage;
    @FindBy(xpath = "//*[@text='Subscribe Now']")
    private static MobileElement subscribeNoBtn;

    public ExplorePage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
    }


    private void backToHomepage(){
        commonFunctions.navigateBack();
        commonFunctions.navigateBack();
    }

    @Override
    public boolean checkMarketDashboardPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        isShowing &= commonFunctionsMobile. clickOnExploreMarketDashboardAndVerifyPage(exploreMarketDashboard,marketsPage);
        backToHomepage();
        return isShowing;
    }

    @Override
    public boolean checkMintPremiumPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        isShowing &= commonFunctionsMobile.clickOnExploreMintPremiumAndVerifyPage(exploreMintPremium, mintPremiumPage);
        backToHomepage();
        return isShowing;
    }

    @Override
    public boolean checkPodcastPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        isShowing &= commonFunctionsMobile.clickOnExplorePodcastAndVerifyPage(podcastOption, podcastPage);
        backToHomepage();
        return isShowing;
    }

    @Override
    public boolean checkShareAppOption() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(shareApp, "share app");
        commonFunctions.clickElement(shareApp, 10, "share app");
        isShowing &= commonFunctions.isElementDisplayed(bluetoothText, 10, "bluetooth option");
        isShowing &= commonFunctions.isElementDisplayed(gmailText, 10, "Gmail option");
        isShowing &= commonFunctions.isElementDisplayed(messageText, 10, "Message option");
        isShowing &= commonFunctions.isElementDisplayed(driveText, 10, "Drive option");
        backToHomepage();
        return isShowing;
    }

    @Override
    public boolean checkRateApp() {
        boolean isShowing = clickOnRateApp();
        backToHomepage();
        return isShowing;
    }

    public boolean clickOnRateApp() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(rateApp, "rate app");
        commonFunctions.clickElement(rateApp, 10, "rate app");
        commonFunctions.isElementDisplayed(rateApp5Star, 10, "5 star");
        commonFunctions.isElementDisplayed(rateAppLater, 10, "rate app: Later");
        commonFunctions.isElementDisplayed(rateAppSubmit, 10, "rate app: Submit");
        return isShowing;
    }

    @Override
    public boolean checkRateAppLaterButton() {
        boolean isShowing = clickOnRateApp();
        commonFunctions.clickElement(rateAppLater, 10, "rate app: Later");
        isShowing &= commonFunctions.isElementNotDisplayed(rateAppLater, 10, "popup close");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkRateAppSubmitButton() {
        boolean isShowing = clickOnRateApp();
        commonFunctions.clickElement(rateAppSubmit, 10, "rate app: submit");
        isShowing &= commonFunctions.isElementDisplayed(afterRatingPopup, 10, "popup after rating");
        commonFunctions.clickElement(rateAppLater, 10, "rate app: Later");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkRateAppWithFiveStarRating() {
        boolean isShowing = clickOnRateApp();
        commonFunctions.clickElement(rateAppSubmit, 10, "rate app: submit");
        isShowing &= commonFunctions.isElementDisplayed(afterRatingPopup, 10, "popup after rating");
        commonFunctions.clickElement(rateAppSubmit, 10, "rate now");
        isShowing &= commonFunctions.isElementDisplayed(playStore.get(1), 10, "play store");
        backToHomepage();
        return isShowing;
    }

    @Override
    public boolean checkRateAppWithBelowFiveStarRating() {
        boolean isShowing = clickOnRateApp();
        commonFunctions.clickByCoordinates(639, 1052, "4 rating");
        commonFunctions.clickElement(rateAppSubmit, 10, "rate app: submit");
        commonFunctions.clickElement(rateAppSubmit, 10, "rate app: yes");
        isShowing &= commonFunctions.isElementDisplayed(mailBox, 10, "mail box");
        commonFunctions.navigateBack();
        backToHomepage();
        return isShowing;
    }

    @Override
    public boolean checkSignInButtonFromExplore() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        commonFunctions.clickElement(signIn, 10, "signIn button");
        return isShowing;
    }

    @Override
    public boolean checkBackExplorePageToHomePage() {
        commonFunctions.navigateBack();
        return commonFunctions.isElementDisplayed(homeButton, 10, "home tab");
    }

    @Override
    public boolean checkSignInButtonFromEpaper() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        commonFunctions.clickElement(epaper, 10, "epaper option");
        isShowing &= commonFunctions.isElementDisplayed(epaperSignIn, 10, "epaper SignIn");
        commonFunctions.clickElement(epaperSignIn, 10, "epaper SignIn");
        return isShowing;
    }

    @Override
    public boolean checkBackToHomePageFromEpaperSubscribeNow() {
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(1);
        commonFunctions.navigateBack();
        return commonFunctions.isElementDisplayed(homeButton, 10, "home tab");
    }

    @Override
    public boolean checkEpaperPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        commonFunctions.clickElement(epaper, 10, "epaper option");
        isShowing &= commonFunctions.isElementDisplayed(epaperPage, 10, "epaper page");
        isShowing &= checkBackToHomePageFromEpaperSubscribeNow();
        return isShowing;
    }

    @Override
    public boolean checkSubscribeNowButtonFromEpaper() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        commonFunctions.clickElement(epaper, 10, "epaper option");
        isShowing &= commonFunctions.isElementNotDisplayed(subscribeNoBtn, 5, "subscribe Now Button");
        isShowing &= checkBackToHomePageFromEpaperSubscribeNow();
        return isShowing;
    }

}
