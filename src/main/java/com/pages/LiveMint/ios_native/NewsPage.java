package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonNewsPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage extends CommonNewsPage {

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
    @iOSXCUITFindBy(id = "NEWS")
    private static MobileElement newsPage;
    @iOSXCUITFindBy(id = "News")
    private static MobileElement newsTab;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'News'`]")
    private static MobileElement newsTabPosition;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
    private static MobileElement firstStoryOnNewsPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyDetailPageHeadline;
    @iOSXCUITFindBy(id = "To Continue Reading, Subscribe Now")
    private static MobileElement continueReadingSubscribeNow;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,',')])[2]")
    private static MobileElement firstStoryHeadline;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton")
    private static MobileElement textToSpeechOnStoryDetailPage;
    @iOSXCUITFindBy(id = "play Expand")
    private static MobileElement audioPlayButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'audioPlayer Cross'`]")
    private static MobileElement audioPlayerCrossButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Got it']")
    private static MobileElement gotIt;


    public NewsPage() {
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
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");;
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    private boolean checkNewsPage() {
        commonFunctions.clickElement(newsTab,10,"news tab");
        return commonFunctions.isElementDisplayed(newsPage,10,"news page");
    }

    @Override
    public boolean checkNewsSection() {
       return commonFunctions.isElementDisplayed(newsTab,10,"news tab");
    }

    @Override
    public boolean checkNewsSectionPosition() {
        commonFunctions.clickElement(newsTabPosition, 10,"news tab");
        return commonFunctions.isElementDisplayed(newsPage, 10, "news page");
    }


    @Override
    public boolean checkNewsSectionStoriesIsFree() {
        boolean isShowing;
        isShowing = checkNewsPage();
        commonFunctions.tapElementWithCoOrdinates(370, 290, "First story in the News"); //Tap on the fist story in the premium
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(gotIt, 10, "Pop Up");
        isShowing &= commonFunctions.isElementNotDisplayed(continueReadingSubscribeNow, 10, "Continue Reading subscribe now");
        commonFunctions.clickElement(newsTab,10,"news tab");
        commonFunctions.clickElement(home, 10, "Home tab");
        return isShowing;
    }

    @Override
    public boolean checkStoryFunctionalityTextToSpeech() {
        boolean isShowing = checkNewsPage();
        commonFunctions.clickByCoordinates(370, 290, "first story");
        commonFunctions.clickElementIfDisplayed(gotIt, 10, "Pop Up");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(storyDetailPageHeadline, "story Detail Page Headline");
        isShowing &= commonFunctions.isElementDisplayed(textToSpeechOnStoryDetailPage, 10, "text to speech on story detail page");
        commonFunctions.clickElement(textToSpeechOnStoryDetailPage, 10, "text to speech button");
        isShowing &= commonFunctions.isElementDisplayed(audioPlayButton, 10, "text to speech Audio Play");
        commonFunctions.clickElement(audioPlayerCrossButton, 10, "audio player close button");
        commonFunctions.clickElement(home, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailAllField() {
        return false;
    }

    @Override
    public boolean checkStoryDetailSwipePopup() {
        return false;
    }

    @Override
    public boolean checkStoryDetailHomePage() {
        return false;
    }

    @Override
    public boolean checkHorizontallySwipeForNextStory() {
        return false;
    }

    @Override
    public boolean checkStoryDetailPageAfterClickOnListingStory() {
        return false;
    }

    @Override
    public boolean checkRecommendedForYouOnStoryDetailPage() {
        return false;
    }
}

