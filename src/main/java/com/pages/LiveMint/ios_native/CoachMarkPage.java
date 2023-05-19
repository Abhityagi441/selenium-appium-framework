package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonCoachMarkPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;


public class CoachMarkPage extends CommonCoachMarkPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'News'`]")
    private static MobileElement newsSectionCoachMark;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Explore'`]")
    private static MobileElement exploreSectionCoachMark;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement skipCoachMark;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Next'`]")
    private static MobileElement nextCoachMark;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Done'`]")
    private static MobileElement doneCoachMark;

    public CoachMarkPage() {
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
        System.out.println("****************** MintLounge Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkCoachMarkOnFirstLaunch() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(newsSectionCoachMark, 10, "news section coachMark");
        isShowing &= commonFunctions.isElementDisplayed(skipCoachMark, 10, "coach mark: Skip");
        isShowing &= commonFunctions.isElementDisplayed(nextCoachMark, 10, "coach mark: Next");
        return isShowing;
    }

    @Override
    public boolean checkCoachMarkSkipButton() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(skipCoachMark, 10, "coach mark: Skip");
        commonFunctions.clickElement(skipCoachMark, 10, "coach mark: Skip");
        isShowing &= commonFunctions.isElementNotDisplayed(skipCoachMark, 10, "coach mark: Skip");
        isShowing &= commonFunctions.isElementNotDisplayed(nextCoachMark, 10, "coach mark: Next");
        return isShowing;
    }

    @Override
    public boolean checkCoachMarkNextButton() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(newsSectionCoachMark, 10, "news section coachMark");
        isShowing &= commonFunctions.isElementDisplayed(nextCoachMark, 10, "coach mark: Next");
        commonFunctions.clickElement(nextCoachMark, 5, "coach mark: Next");
        isShowing &= commonFunctions.isElementDisplayed(nextCoachMark, 10, "coach mark: Next");
        commonFunctions.clickElement(nextCoachMark, 5, "coach mark: Next");
        isShowing &= commonFunctions.isElementDisplayed(exploreSectionCoachMark, 10, "explore section coachMark");
        return isShowing;
    }

    @Override
    public boolean checkCoachMarkDoneButton() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(skipCoachMark, 10, "coach mark: Skip");
        isShowing &= checkCoachMarkNextButton();
        isShowing &= commonFunctions.isElementDisplayed(doneCoachMark, 10, "coach mark: Done");
        isShowing &= commonFunctions.clickElement(doneCoachMark, 10, "coach mark: Skip");
        isShowing &= commonFunctions.isElementNotDisplayed(exploreSectionCoachMark, 10, "explore section coachMark");
        isShowing &= commonFunctions.isElementNotDisplayed(doneCoachMark, 10, "coach mark: Skip");
        return isShowing;
    }

    public void checkAllNotification(){
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
    }

    @Override
    public boolean checkNewsAndExploreCoachMark() {
        boolean isShowing = checkCoachMarkNextButton();
        isShowing &= commonFunctions.isElementDisplayed(doneCoachMark, 10, "coach mark: Done");
        isShowing &= commonFunctions.clickElement(doneCoachMark, 10, "coach mark: Skip");
        return isShowing;
    }


}



