package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonDailyDigestPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DailyDigestPage extends CommonDailyDigestPage {

    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreHamburger;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @FindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YOUR DAILY DIGEST']")
    private static MobileElement DailyDigestPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDailyDigest")
    private static MobileElement exploreDailyDigestOption;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivdailyDigestBanner")
    private static MobileElement dailyDigestBanner;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvGoodMorning")
    private static MobileElement dailyDigestBannerGM;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Good Evening']")
    private static MobileElement dailyDigestBannerGE;



    public DailyDigestPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
    }

    private boolean checkDailyDigestPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        commonFunctions.clickElement(exploreDailyDigestOption, 10, "Daily digest");
        isShowing &= commonFunctions.isElementDisplayed(DailyDigestPage, 10, "Daily Digest page");
        return isShowing;
    }

    @Override
    public boolean checkYourDailyDigestPage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        commonFunctions.clickElement(exploreDailyDigestOption, 10, "Daily digest");
        isShowing &= commonFunctions.isElementDisplayed(DailyDigestPage, 10, "Daily Digest page");
        commonFunctionsMobile.doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkDailyDigestBannerMorningAndDailyDigestPage() {
        commonFunctions.clickElement(homeButton, 10, "home tab");
        boolean isShowing = commonFunctions.isElementDisplayed(dailyDigestBannerGM, 10, "daily digest banner: Good Morning");
        commonFunctions.clickElement(dailyDigestBanner, 10, "Daily digest banner");
        isShowing &= commonFunctions.isElementDisplayed(DailyDigestPage, 10, "Daily Digest page");
        return isShowing;
    }

    @Override
    public boolean checkDailyDigestBannerEveningAndDailyDigestPage() {
        commonFunctions.clickElement(homeButton, 10, "home tab");
        boolean isShowing = commonFunctions.isElementDisplayed(dailyDigestBannerGE, 10, "Daily digest banner: Good Evening");
        commonFunctions.clickElement(dailyDigestBanner, 10, "Daily digest banner");
        isShowing &= commonFunctions.isElementDisplayed(DailyDigestPage, 10, "Daily Digest page");
        return isShowing;
    }




}

