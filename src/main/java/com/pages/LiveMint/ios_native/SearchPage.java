package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.LiveMint.generic.CommonSearchPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends CommonSearchPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;

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

    @iOSXCUITFindBy(accessibility = "Search")
    private static MobileElement searchField;

    @iOSXCUITFindBy(id = "search")
    private static MobileElement searchButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
    private static MobileElement firstResult;

    @iOSXCUITFindBy(id = "storyHeadline")
    private static MobileElement storyHeadline;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;

    public SearchPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
//        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkSearchIsWorking(String[] params) {
        boolean clickExplore= commonFunctions.clickElement(explore);
        Utils.logStepInfo(clickExplore,"Clicked on Explore");

        boolean clickSearch=commonFunctions.clickElement(searchField);
        Utils.logStepInfo(clickSearch,"Clicked search field");

        //commonFunctions.sendKey(searchFieldMain.get(1),params[3],10);
        commonFunctions.sendKeyWithAction(params[0],"");

        boolean keyBoard=commonFunctions.isKeyboardVisible();
        Utils.logStepInfo(keyBoard,"Keyboard is visible");

        boolean tapSearch=commonFunctions.clickElement(searchButton);
        Utils.logStepInfo(tapSearch,"Tapped search button on keyboard");

        String valFromResultList=commonFunctions.getElementText(firstResult);
        commonFunctions.clickElement(firstResult);
        commonFunctions.dummyWait(5);
        String valFromStory = commonFunctions.getElementText(storyHeadline);

        boolean validation=valFromResultList.equalsIgnoreCase(valFromStory);
        Utils.logStepInfo(validation,"Verifying search results");

        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return clickExplore&&clickSearch&&tapSearch&&validation;
    }


}