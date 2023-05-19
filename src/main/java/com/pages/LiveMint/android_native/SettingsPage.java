package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.generic.CommonSettingsPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends CommonSettingsPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonHomePage homePage;

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
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Setting']")
    private static MobileElement settingsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnNotification")
    private static MobileElement notificationToggleButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App Settings']")
    private static MobileElement settingPageTitle;
    @AndroidFindBy(id = "com.htmedia.mint:id/seekbarSB")
    private static MobileElement fontSelector;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(id = "com.htmedia.mint:id/tvSelectFontSize")
    private static MobileElement frontSizeText;
    @FindBy(id = "com.htmedia.mint:id/action_setting")
    private static MobileElement settingIcon;


    public SettingsPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        homePage = CommonHomePage.getInstance();
    }

    @Override
    public boolean checkNotificationToggle() {
        boolean isNotificationToggleTrue=true;
        isNotificationToggleTrue = clickOnExploreAndOpenSettingPage();
        isNotificationToggleTrue &= commonFunctions.clickElement(notificationToggleButton,10,"Notification Toggle Radio Button");
        return isNotificationToggleTrue;
    }

    @Override
    public boolean checkThemeSelector() {
        return false;
    }

    private boolean clickOnExploreAndOpenSettingPage() {
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.clickElement(exploreHamburger, 10, "Explore Bottom");
        commonFunctions.scrollDownToElement(settingsButton);
        commonFunctions.clickElement(settingsButton, 10, "setting");
        return commonFunctions.isElementDisplayed(settingPageTitle, 10, "setting page title");
    }

    private void backToHomePage(){
        commonFunctions.navigateBack();
        commonFunctions.clickElement(exploreCloseIcon,10,"explore close icon");
    }

    @Override
    public boolean checkFontSelection() {
        boolean isShowing;
        isShowing = clickOnExploreAndOpenSettingPage();
        isShowing &= commonFunctions.isElementDisplayed(fontSelector, 10, "font Selector");
        backToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkFontSizeOption() {
        boolean isShowing;
        isShowing = clickOnExploreAndOpenSettingPage();
        isShowing &= commonFunctions.isElementDisplayed(frontSizeText, 10, "font Selector");
        backToHomePage();
        return isShowing;
    }
    @Override
    public boolean checkExploreSettingIconAndPage() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.clickElement(exploreHamburger, 10, "Explore Bottom");
        isShowing = commonFunctions.isElementDisplayed(settingIcon, 10, "setting icon");
        commonFunctions.clickElement(settingIcon, 10, "setting");
        isShowing &= commonFunctions.isElementDisplayed(settingPageTitle, 10, "setting page title");
        backToHomePage();
        return isShowing;
    }
}
