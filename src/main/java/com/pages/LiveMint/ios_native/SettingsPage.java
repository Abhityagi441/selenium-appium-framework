package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.generic.CommonSettingsPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends CommonSettingsPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @iOSXCUITFindBy(id = "agree")
    private static MobileElement acceptCookie;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;
    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;
    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement explore;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Yes, I am In']")
    private static MobileElement darkThemeYes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Settings']")
    private static MobileElement settings;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@value=1]")
    private static MobileElement notificationToggleOn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@value=0]")
    private static MobileElement notificationToggleOff;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[`value == '50%'`]")
    private static MobileElement fontSelector;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(id = "Settings")
    private static MobileElement settingOption;
    @iOSXCUITFindBy(id = "Select Font Size")
    private static MobileElement frontSizeText;
    @iOSXCUITFindBy(id = "APP SETTINGS")
    private static MobileElement settingPageTitle;
    @iOSXCUITFindBy(id = "EXPLORE")
    private static MobileElement explorePage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement exploreHamburger;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='notification']/preceding::XCUIElementTypeButton[@name='ic settings']")
    private static MobileElement settingIcon;


    public SettingsPage() {
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
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkNotificationToggle() {
        boolean checkNotificationToggleStatus;
        commonFunctions.clickElement(notificationToggleOff, 10, "Notification Toggle");
        checkNotificationToggleStatus = commonFunctions.isElementDisplayed(notificationToggleOn, 10, "Notifications turned on");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        return checkNotificationToggleStatus;
    }

    @Override
    public boolean checkThemeSelector() {
        return false;
    }

    @Override
    public boolean checkFontSelection() {
        boolean checkFontSelectionStatus;
        checkFontSelectionStatus = clickOnExploreAndOpenSettingPage();
        commonFunctions.isElementDisplayed(fontSelector, 20, "Font Selection is Displayed");
        checkFontSelectionStatus &= commonFunctions.isElementClickable(fontSelector, 10, "Font Selection is Enabled");
        backToHomePage();
        return checkFontSelectionStatus;
    }

    private boolean clickOnExploreAndOpenSettingPage() {
        commonFunctions.clickElement(home, 10, "home tab");
        commonFunctions.clickElement(explore, 10, "Explore Bottom");
        boolean isShowing = commonFunctions.isElementDisplayed(explorePage, 10, "explore page");
        commonFunctions.scrollDownToElement(settings);
        commonFunctions.clickElement(settings, 10, "setting");
        isShowing &= commonFunctions.isElementDisplayed(settingPageTitle, 10, "setting page title");
        return isShowing;
    }

    private void backToHomePage(){
        commonFunctions.clickElement(back,10,"back button setting page");
        commonFunctions.killAppAndReLaunch();
    }

    @Override
    public boolean checkFontSizeOption() {
        boolean isShowing = clickOnExploreAndOpenSettingPage();
        isShowing &= commonFunctions.isElementDisplayed(frontSizeText, 1, "front size");
        backToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkExploreSettingIconAndPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(home, exploreHamburger, explorePage);
        commonFunctions.clickElement(settingIcon, 10, "setting icon right to bell icon");
        isShowing &= commonFunctions.isElementDisplayed(settingPageTitle, 10, "setting page title");
        backToHomePage();
        return isShowing;
    }
}