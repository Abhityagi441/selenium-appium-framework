package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class

AdvertismentPage extends CommonAdvertismentPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;


    @iOSXCUITFindBy(id = "ht nav logo")
    private static MobileElement htLogo;

    @iOSXCUITFindBy(id = "htNewLogo")
    private static MobileElement htLogoOnStoryPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//child:: XCUIElementTypeWebView")
    private static MobileElement secondAdd;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[5]")
    private static MobileElement linkStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'ebBannerIFrame')]")
    private static MobileElement advertise;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='ADVERTISEMENT'])[1]")
    private static MobileElement topAddver;

    @iOSXCUITFindBy(className = "(//XCUIElementTypeOther[@name='Blank'])[2]/XCUIElementTypeOther[3]")
    private static MobileElement bottomAdver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='hamburger menu']")
    private static MobileElement hamburgerMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//child:: XCUIElementTypeWebView")
    private static MobileElement thirdAdd;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='india'][1]")
//    private static MobileElement india;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='India']")
    private static MobileElement india;

    @iOSXCUITFindBy(accessibility = "Search")
    private static MobileElement searchField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//child:: XCUIElementTypeWebView")
    private static MobileElement firstAdd;



    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//child:: XCUIElementTypeWebView/ancestor::XCUIElementTypeCell/preceding-sibling::XCUIElementTypeCell//child::XCUIElementTypeButton[@name='share default']")
    private static List<MobileElement> storiesBeforeAdd;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell//child:: XCUIElementTypeWebView/ancestor::XCUIElementTypeCell/preceding-sibling::XCUIElementTypeCell")
    private static List<MobileElement> stories;

    @iOSXCUITFindBy(id = "search")
    private static List<MobileElement> searchFieldMain;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'items found')]")
    private static MobileElement itemsFound;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;

    public String secondSection="Don\'t Miss";

    public String thirdSection="Latest Videos";


    public AdvertismentPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        apiValidation=ApiValidation.getInstance();
    }

    @Override
    public boolean checkAdDisplayingAfterEveryCollection() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingAfterCollection() {
        return false;
    }

    @Override
    public boolean checkAdsDisplayInLineStory() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingHomePage() {
        boolean checkHomePageLoadedProperly = homePageLoadedProperly();
        boolean checkTopAndBottom=topAndBottomAdver();
        boolean scrollTillFirstAdd=commonFunctions.scrollToMobileElement(firstAdd);

        commonFunctions.scrollUsingNameiOS(secondSection);
        boolean scrollSecondAdd=commonFunctions.scrollToMobileElement(secondAdd);

        commonFunctions.scrollUsingNameiOS(thirdSection);
        boolean scrollThirdAdd=commonFunctions.scrollToMobileElement(thirdAdd);






        return checkHomePageLoadedProperly&&checkTopAndBottom&&scrollTillFirstAdd&&scrollSecondAdd&&scrollThirdAdd;
    }

    @Override
    public boolean checkAdsInlineStories() {
        return false;
    }

    @Override
    public boolean checkAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingHomePageTopAd() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingAtEndOfFirstCollection() {
        return false;
    }

    @Override
    public boolean checkAdDisplayWordCountAndAdRedirection() {
        return false;
    }

    @Override
    public boolean checkHeaderAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkHeaderAdisDisplayed() {
        return false;
    }

    @Override
    public boolean checkHomePageRHSAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkTopAdDisplayOnEverySection() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        boolean homeSelected=commonFunctions.isElementSelected(home,5,"HT home button");
        commonFunctions.clickElement(india,5,"India Section");
        boolean sectionTopAdDisplayed=commonFunctions.isElementDisplayed(topAddver,20,"Current page Top Ad");
        return homeSelected&&sectionTopAdDisplayed;
    }

    public boolean homePageLoadedProperly()
    {
        boolean htLgo =commonFunctions.isElementDisplayed(htLogo,5,"htLogo");


        boolean topAdd=commonFunctions.isElementDisplayed(topAddver,10,"top advertisment");

        boolean botAdd=commonFunctions.isElementDisplayed(bottomAdver,10,"Bottom advertisment");



        return htLgo && topAdd && botAdd;

    }

    public boolean topAndBottomAdver()
    {
        boolean topAdd=commonFunctions.isElementDisplayed(topAddver,10,"top advertisment");


        boolean botAdd=commonFunctions.isElementDisplayed(bottomAdver,10,"Bottom advertisment");

        return botAdd && topAdd;
    }
}

