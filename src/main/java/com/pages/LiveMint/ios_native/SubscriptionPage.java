package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonSubscriptionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage extends CommonSubscriptionPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Subscribe']")
    private static MobileElement subscribe;

    @iOSXCUITFindBy(id = "Premium")
    private static MobileElement premiumFromBottomNavigation;

   /* @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell//XCUIElementTypeOther/XCUIElementTypeOther)[1]")
    private static MobileElement firstStoryInPremium;*/

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    private static MobileElement firstStoryInPremium;

    @iOSXCUITFindBy(id = "Label")
    private static MobileElement firstStory;

    @iOSXCUITFindBy(iOSNsPredicate = "**/XCUIElementTypeButton[`label == 'Start 14 days free trial'`]")
    private static MobileElement start14FreeTrailButton;

    @iOSXCUITFindBy(id = "Choose a plan")
    private static MobileElement planPage;

    @iOSXCUITFindBy(id = "Subscribe")
    private static MobileElement subscribeHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Start 14 days free trial'])[1]")
    private static MobileElement plan1;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Start 14 days free trial'])[2]")
    private static MobileElement plan2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Remove Ad'`]")
    private static MobileElement removeAd;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Subscribe Now'])[1]")
    private static MobileElement stgPlan1;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;

    String storyTitleBeforeLogin;
    String storyTitleAfterLogin;

    public SubscriptionPage() {
        globalVars = GlobalVars.getInstance();
        //this.driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
//        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
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
    public boolean checkPlanPage(){
        boolean checkPlanPageStatus;
        commonFunctions.clickElement(home, 10, "Home");
//        commonFunctions.clickElement(explore, 10, "Explore");
        commonFunctions.clickElement(subscribe, 10, "Subscribe");
        commonFunctions.dummyWait(10);
        checkPlanPageStatus=checkLandingPage(planPage, "Choose a plan",10);
        commonFunctions.clickElement(back, 10, "Back");
        return checkPlanPageStatus;
    }

    @Override
    public boolean checkSubscribeNavigation() {
        return false;
    }

    @Override
    public boolean checkPlansVisible(){
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.clickElement(subscribeHeader, 10, "Subscribe");
        commonFunctions.dummyWait(10);
        isShowing = commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(planPage, "Choose a plan", 10, "text: choose a plan");
        isShowing &= commonFunctions.isElementDisplayed(plan1, 10, "first plan");
        if (globalVars.isStgRun()) {
            isShowing &= commonFunctions.isElementDisplayed(stgPlan1, 10, "stg first plan");
        }
        if (globalVars.isProdRun()) {
            isShowing &= commonFunctions.isElementDisplayed(plan2, 10, "second plan");
        }
        commonFunctions.clickElement(back, 10, "Back");
        commonFunctions.clickElement(home, 10, "Home");
        return isShowing;
    }

    @Override
    public boolean checkPremiumStoryPlansVisible(){
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(firstStoryInPremium,10,"First Premium story");
        commonFunctions.scrollUntilElementFound(start14FreeTrailButton);
        commonFunctions.clickElement(start14FreeTrailButton,10,"Collect your offer button");
        isShowing = commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(planPage, "Choose a plan", 10, "text: choose a plan");
        isShowing &= commonFunctions.isElementDisplayed(plan1, 10, "first plan");
        isShowing &= commonFunctions.isElementDisplayed(plan2, 10, "second plan");
        commonFunctions.clickElement(back, 10, "Back");
        commonFunctions.clickElement(home, 10, "Home");
        return isShowing;
    }
    @Override
    public boolean checkSubscribeLink(){
        boolean checkSubscribeLinkStatus;
        commonFunctions.clickElement(home, 10, "Home");
        checkSubscribeLinkStatus=commonFunctions.isElementDisplayed(subscribeHeader, 10, "Subscribe");
        return checkSubscribeLinkStatus;
    }

    @Override
    public boolean checkRemoveAd(){
        boolean checkRemoveAdClickStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.scrollUntilElementFound(removeAd);
        commonFunctions.clickElement(removeAd, 10, "Remove Ad");
        commonFunctions.dummyWait(10);
        checkRemoveAdClickStatus=checkLandingPage(planPage, "Choose a plan",10);
        commonFunctions.clickElement(back, 10, "Back");
        return checkRemoveAdClickStatus;
    }

    @Override
    public boolean checkSubscribedUserStories(){
        boolean checkPlanPageStatus;
        commonFunctions.clickElement(home, 10, "Explore");
        commonFunctions.dummyWait(10);
        storyTitleAfterLogin=commonFunctions.getElementText(firstStory);
        checkPlanPageStatus=commonFunctions.checkTextNotEquals(storyTitleAfterLogin, storyTitleBeforeLogin, "Story");
        return checkPlanPageStatus;
    }

    @Override
    public boolean checkPlanVisibilityAndClickable() {
        return false;
    }

    @Override
    public boolean checkValidationOfSubscriptionsPlanDetails() {
        return false;
    }

    public boolean checkNonLoggedInUserStories(){
        commonFunctions.clickElement(home, 10, "Explore");
        commonFunctions.dummyWait(10);
        storyTitleBeforeLogin=commonFunctions.getElementText(firstStory);
        return true;
    }

    @Override
    public boolean checkSubscribedUserIsAdFree() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home");
        isShowing = commonFunctions.isElementNotDisplayed(removeAd, 10, "Ads");
        commonFunctions.scrollToBottomOniOSNative();
        isShowing &= commonFunctions.isElementNotDisplayed(removeAd, 10, "Ads");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }


    public boolean checkLandingPage(MobileElement landingPageElement,String landingPageElementName, int timeOut){
        boolean checkLandingPageStatus;
        commonFunctions.isElementDisplayed(landingPageElement, timeOut, landingPageElementName +" Landing page");
        String actualLandingPageName=commonFunctions.getElementText(landingPageElement,timeOut);
        if(actualLandingPageName.equals(landingPageElementName)){
            checkLandingPageStatus=true;
            Utils.logStepInfo(true, landingPageElementName + " Landing Page displayed successfully");
        }else{
            checkLandingPageStatus=false;
            Utils.logStepInfo(false, landingPageElementName + " Landing Page is not displayed");
        }
        return checkLandingPageStatus;
    }

}