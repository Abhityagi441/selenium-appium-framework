package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonChooseThemePage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseThemePage extends CommonChooseThemePage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreMenuButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Setting']")
    private static MobileElement settingsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App Settings']")
    private static MobileElement settingPageTitle;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvAuto")
    private static MobileElement autoThemeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvLight")
    private static MobileElement lightThemeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvDark")
    private static MobileElement darkThemeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreHamburger;
    @FindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;

    public ChooseThemePage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
    }

    @Override
    public boolean checkThemeChangesAtChooseWorks() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(settingsButton);
        commonFunctions.clickElement(settingsButton, 10, "setting");
        isShowing &= commonFunctions.isElementDisplayed(settingPageTitle, 10, "setting page title");
        isShowing &=commonFunctions.clickElement(autoThemeButton,10,"Auto Theme button");
        isShowing &=commonFunctions.clickElement(lightThemeButton,10,"Light Theme button");
        isShowing &=commonFunctions.clickElement(darkThemeButton,10,"Dark Theme button");
        return isShowing;
    }
}
