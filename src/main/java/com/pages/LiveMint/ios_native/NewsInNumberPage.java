package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonNewsInNumberPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;


public class NewsInNumberPage extends CommonNewsInNumberPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
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


    public NewsInNumberPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
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
    public boolean checkNewsInNumberWidgetOnHomePage() {
        return false;
    }

    @Override
    public boolean checkOnlyOneCardVisibleOnNewsInNumberListingPage() {
        return false;
    }

    @Override
    public boolean checkThreeDotsAndBackFunctionalityOnNewsInNumberListingPage() {
        return false;
    }

    @Override
    public boolean checkTitleAndSubTitleOnNewsInNumberListingPage() {
        return false;
    }

    @Override
    public boolean checkReadFullStoryButtonAndFunctionality() {
        return false;
    }

    @Override
    public boolean checkSwipeTextAtButton() {
        return false;
    }

    @Override
    public boolean checkCardSwipeFunctionality() {
        return false;
    }

    @Override
    public boolean checkViewAllFunctionality() {
        return false;
    }

    @Override
    public boolean checkCardVisibilityOnNewsInNumberWidget() {
        return false;
    }

    @Override
    public boolean checkLatestDataOnNewsInNumberWidget() {
        return false;
    }

    @Override
    public boolean checkDiffCardInfoOnWidgetNewsInNumber() {
        return false;
    }

    @Override
    public boolean checkNewTagAndTitleOnWidgetNewsInNumber() {
        return false;
    }

    @Override
    public boolean checkShareIconAndFunctionalityOnNewsInNumberListingPage() {
        return false;
    }
}

