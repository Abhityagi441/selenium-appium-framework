package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.pages.HindustanTimes.generic.CommonLatestStoriesPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LatestStoryiesPage extends CommonLatestStoriesPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='hamburger menu']")
    private static MobileElement hamburgerMenu;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='india'][1]")
//    private static MobileElement india;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='india']")
    private static MobileElement india;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='E-Paper']")
    private static MobileElement ePaperCTA;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='banner']/XCUIElementTypeOther[3]/XCUIElementTypeImage")
    private static WebElement homeEpaper;

    public LatestStoryiesPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
       // Utils.logStepInfo("This is sttarted");
       // commonFunctions.clickElementIfDisplayed(allowTracking,15,"Allow Tracking");
        //commonFunctions.clickElementIfDisplayed(notificationAllow, 15, "notificationAllow");
        //commonFunctions.clickElementIfDisplayed(skipButton, 15, "skipButton");
        //commonFunctions.clickElementIfDisplayed(notificationLater, 60, "notificationLater");
        }


    @Override
    public boolean checkStoriesPublishedOnDateDisplayedOnTopOfPage()  {


        return false;
    }
}
