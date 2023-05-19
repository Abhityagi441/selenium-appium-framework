package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonDailyDigestPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DailyDigestPage extends CommonDailyDigestPage {

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
    @iOSXCUITFindBy(id = "FOR YOU")
    private static MobileElement forYouPage;
    @iOSXCUITFindBy(id = "For You")
    private static MobileElement forYouTab;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement homeTab;
    @iOSXCUITFindBy(id = "Label")
    private static MobileElement bannerStory;
    @iOSXCUITFindBy(id = "share")
    private static List<MobileElement> listOfShareIcon;
    @iOSXCUITFindBy(id = "bookmark")
    private static List<MobileElement> listOfBookmarkIcon;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[5]")
    private static MobileElement firstStoryOnForYouPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='share'])[1]")
    private static MobileElement shareIconOnStoryDetailPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton")
    private static MobileElement textToSpeechOnStoryDetailPage;
    @iOSXCUITFindBy(id = "play Expand")
    private static MobileElement audioPlayButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyDetailPageHeadline;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='bookmark'])[1]")
    private static MobileElement bookmarkIconOnStoryDetailPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Got it']")
    private static MobileElement gotIt;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CLOSE']")
    private static MobileElement close;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'audioPlayer Cross'`]")
    private static MobileElement audioPlayerCrossButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Remove Ad'`]")
    private static MobileElement AdsRemoveAdButton;
    @iOSXCUITFindBy(id = "SIMILAR STORIES")
    private static MobileElement similarStoriesSection;
    @iOSXCUITFindBy(id = "MINT PREMIUM")
    private static MobileElement mintPremium;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,',')])")
    private static List<MobileElement> allStoriesForYoyPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='aa'])[1]")
    private static MobileElement fontSizeTop;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='aa'])[2]")
    private static MobileElement fontSizeBottom;


    public DailyDigestPage() {
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
    public boolean checkYourDailyDigestPage() {
        return false;
    }

    @Override
    public boolean checkDailyDigestBannerMorningAndDailyDigestPage() {
        return false;
    }

    @Override
    public boolean checkDailyDigestBannerEveningAndDailyDigestPage() {
        return false;
    }
}

