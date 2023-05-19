package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HamburgerPage extends CommonHamburgerPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(id="WORLD NEWS")
    private static MobileElement redirectionWorld;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement hamburgerMenu;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='World']")
    private static List<MobileElement> world;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='World']/following-sibling::XCUIElementTypeStaticText")
    private static MobileElement redirectionToWorld;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Tokyo')]")
    private static MobileElement sports;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Cities']")
    private static MobileElement cities;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Elections']")
    private static MobileElement elections;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Opinion']")
    private static MobileElement opinion;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Entertainment']")
    private static MobileElement entertainment;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='photos']")
    private static MobileElement photos;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='videos']")
    private static MobileElement videos;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Popular Sections']")
    private static MobileElement popularSections;

    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell/XCUIElementTypeStaticText")
    private static List<MobileElement> sectionNames;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;

    public HamburgerPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
       // Utils.logStepInfo("This is sttarted");
       /* commonFunctions.clickElementIfDisplayed(allowTracking,5,"Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 5, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(continueButton,5,"Continue Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,5,"Later Button");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");*/
    }


    @Override
    public boolean checkHamberburgerCases() {
        return false;
    }

    @Override
    public boolean checkHamburgerElementsClickable() {
        boolean clickHamburger= commonFunctions.clickElement(hamburgerMenu);
        Utils.logStepInfo(clickHamburger,"Clicked on Hamburger");

        boolean isIndia=commonFunctions.isElementDisplayed(world.get(0),5);
        Utils.logStepInfo(isIndia,"World is visible");

        boolean clickSection=commonFunctions.clickElement(world.get(0));
        Utils.logStepInfo(clickSection,"Clicked in section");

        boolean isStep=commonFunctions.isElementDisplayed(redirectionWorld,10,"redirection section");
        Utils.logStepInfo(isStep,"Redirection successful");

        return isStep&&clickHamburger&&clickSection&&isIndia;
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        commonFunctions.clickElement(home, 5, "Home page");
        boolean clickHamburger= commonFunctions.clickElement(hamburgerMenu);
        Utils.logStepInfo(clickHamburger,"Clicked on Explore");
        commonFunctions.scrollUpUntilElementFound(popularSections);
        boolean isPopularSections=commonFunctions.isElementDisplayed(popularSections,5,"Popular Sections");
        Utils.logStepInfo(isPopularSections,"Popular Sections is visible");
        commonFunctions.clickElement(hamburgerMenu);
        return clickHamburger&&isPopularSections;
    }

    @Override
    public boolean checkSectionsDisplayed() {
        commonFunctions.clickElement(home, 5, "Home page");
        boolean sectionsDisplayed;
        boolean clickHamburger= commonFunctions.clickElement(hamburgerMenu);
        Utils.logStepInfo(clickHamburger,"Clicked on Explore");
        boolean isPopularSections=commonFunctions.isElementDisplayed(popularSections,5,"Popular Sections");
        if (sectionNames.size()>=1){
            sectionsDisplayed = true;
            Utils.logStepInfo(true,"Sections are visible");
        }
        else{
            sectionsDisplayed = false;
            Utils.logStepInfo(false,"Sections are not visible");
        }
        commonFunctions.clickElement(hamburgerMenu);
        return clickHamburger&&isPopularSections&&sectionsDisplayed;
    }

    @Override
    public boolean clickOnExplorerMenu() throws Exception {
        return false;
    }

    @Override
    public boolean checkHamburgerMenuAllOptionDisplayed() throws Exception {
        return false;
    }

    @Override
    public boolean clickOnEntertainmentSection() throws Exception {
        return false;
    }

    @Override
    public boolean checkRedirectionToEntertainmentSection() throws Exception {
        return false;
    }

    @Override
    public boolean checkAnySectionPage() {
        return false;
    }

    @Override
    public boolean checkIndiaNewsPageScrollable() {
        return false;
    }

    @Override
    public boolean checkNavigationIndiaNews() {
        return false;
    }

    @Override
    public boolean breadcrumbDisplayedOtherThanHomePage() {
        return false;
    }

    @Override
    public boolean checkNavigationPopularNews() {
        return false;
    }

    @Override
    public boolean checkNavigationCricketNews() {
        return false;
    }

    @Override
    public boolean checkNavigationEditorialNews() {
        return false;
    }

    @Override
    public boolean checkNavigationEntertainmentNews() {
        return false;
    }

    @Override
    public boolean checkNavigationCitiesNews() {
        return false;
    }

    @Override
    public boolean checkNavigationLatestNews() {
        return false;
    }

    @Override
    public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() throws Exception {
        return false;
    }

    @Override
    public boolean clickWorldNewsSectionOnHamburgerMenu() {
        return false;
    }

    @Override
    public boolean checkExploreHTOptionDisplayedOnHamburgerMenu() {
        return false;
    }
}
