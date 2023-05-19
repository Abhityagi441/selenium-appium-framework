package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonForYouPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ForYouPage extends CommonForYouPage {

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


    public ForYouPage() {
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


    private boolean checkForYouPage() {
        commonFunctions.clickElement(forYouTab,10,"for you tab");
        return commonFunctions.isElementDisplayed(forYouPage,10,"for you page");
    }

    @Override
    public boolean checkBannerStory() {
        boolean isShowing;
        isShowing = checkForYouPage();
        isShowing &= commonFunctions.isElementNotDisplayed(bannerStory, 10, "Banner story");
        commonFunctions.clickElement(homeTab, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkForYouIconInactive(String forYouText) {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        commonFunctions.clickElement(homeTab,10,"home tab");
        return isShowing;
    }

    @Override
    public boolean checkShareAndBookmarkIconOnForYouPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfShareIcon,5,"share icon" );
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfBookmarkIcon,5,"bookmark icon" );
        commonFunctions.clickElement(homeTab,10,"home tab");
        return isShowing;
    }

    @Override
    public boolean checkShareAndBookmarkStoryDetailPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(firstStoryOnForYouPage, 10, "first story");
        isShowing &=commonFunctions.isElementDisplayed(storyDetailPageHeadline,10,"story Detail Page Headline");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(shareIconOnStoryDetailPage, "share icon on story detail page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(bookmarkIconOnStoryDetailPage, "bookmark icon on story detail page");
        commonFunctions.clickElement(homeTab,10,"home tab");
        return isShowing;
    }

    @Override
    public boolean checkForYouPageAndIcon() {
        return checkForYouPage();
    }

    @Override
    public boolean checkTextToSpeechOnStoryDetailPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(firstStoryOnForYouPage, 10, "first story");
        commonFunctions.clickElementIfDisplayed(gotIt, 10, "Got It");
        isShowing &=commonFunctions.isElementDisplayed(storyDetailPageHeadline,10,"story Detail Page Headline");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(textToSpeechOnStoryDetailPage, 10, "text to speech on story detail page");
        commonFunctions.clickElement(textToSpeechOnStoryDetailPage,10,"text to speech button");
        isShowing &= commonFunctions.isElementDisplayed(audioPlayButton, 15, "text to speech Audio Play");
        commonFunctions.clickElement(audioPlayerCrossButton,10,"audio player close button");
        commonFunctions.clickElement(homeTab,10,"home tab");
        return isShowing;
    }

    @Override
    public boolean checkAdsOnForYouPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.isElementNotDisplayed(AdsRemoveAdButton,10,"ads");
        commonFunctions.clickElement(homeTab, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkAdOnStoryDetailPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(firstStoryOnForYouPage, 10, "first story");
        isShowing &=commonFunctions.isElementDisplayed(storyDetailPageHeadline,10,"story Detail Page Headline");
        commonFunctions.scrollDownToElement(mintPremium);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mintPremium, "home page mint premium");
        isShowing &=commonFunctions.isElementNotDisplayed(AdsRemoveAdButton,10,"ads");
        commonFunctions.clickElement(homeTab,10,"home tab");
        return isShowing;
    }

    @Override
    public boolean checkForYouNoOfStories(String noOfStories) {
        boolean isShowing;
        isShowing = checkForYouPage();
        if (allStoriesForYoyPage.size()==Integer.parseInt(noOfStories)){
            isShowing &= true;
            Utils.logStepInfo(true,  "No. of Stories "+noOfStories+" displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "No. of Stories "+noOfStories+" Not displayed *****failed*****");
        }
        commonFunctions.clickElement(homeTab,10,"home tab");
        return isShowing;
    }

    @Override
    public boolean checkForYouLayout(){return false;}

    @Override
    public boolean lHSNAVLinks()
    {
        return false;
    }
    @Override
    public boolean rHSNAVLinks (){
        return false;
    }
    @Override
    public boolean checkForYouLayoutsubScribedUser()
    {
        return false;
    }
    @Override
    public boolean checklHSNAVLinksforSubscribeduser() {return false;}
    @Override
    public boolean checkrHSNAVLinksforSubscribeduser() {return false;}

    @Override
    public boolean checkFontSizeAtTopAndBottomOnStoryDetailPage() {
        boolean isShowing = checkForYouPage();
        isShowing &= commonFunctions.isElementDisplayed(firstStoryOnForYouPage, 10, "first listing story headline");
        commonFunctions.clickElement(firstStoryOnForYouPage, 10, "first story");
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story Detail Page Headline");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fontSizeTop, "Top position Font size");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fontSizeBottom, "Bottom position Font Size");
        commonFunctions.clickElement(homeTab, 10, "home tab");
        return isShowing;
    }
    @Override
    public boolean checkFirstStoryForYou()
    {
        return false;
    }
    @Override
    public boolean checkFirstStoryForYouforSubscribedUser()
    {
        return false;
    }
}

