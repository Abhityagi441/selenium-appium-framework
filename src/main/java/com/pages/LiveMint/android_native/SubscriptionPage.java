package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonSubscriptionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubscriptionPage extends CommonSubscriptionPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    String withoutLoginInFirstStoryHeadlineHomePage;
    String subscribedUserFirstStoryHeadlineHomePage;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;
    @AndroidFindBy(accessibility = "Navigate up")
    private static MobileElement navigateUpButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreMenuButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtSubscribe")
    private static MobileElement subscribeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement chooseAPlanButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/cl_applogo")
    private static MobileElement premiumStories;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Subscribe']")
    private static MobileElement subscribe;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose a plan']")
    private static MobileElement planPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewHeader_inner_collection")
    private static List<MobileElement> firstPremiumStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement premiumCollectOfferButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement choosePlansHeader;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgPlanTab")
    private static List<MobileElement> allPlans;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement startPlanSubscribe;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewAlreadySubscribed")
    private static MobileElement alreadyASubscriber;
    @AndroidFindBy(id = "com.htmedia.mint:id/imageViewAppLogo")
    private static MobileElement mintLogo;
    @AndroidFindBy(id = "com.htmedia.mint:id/login_heading_tv")
    private static MobileElement loginRegister;
    @AndroidFindBy(id = "com.htmedia.mint:id/action_signin")
    private static MobileElement SignInButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement emailInbox;
    @AndroidFindBy(id = "com.htmedia.mint:id/continue_btn")
    private static MobileElement emailContinueButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/password_et")
    private static MobileElement passwordInbox;
    @FindBy(xpath = "//android.widget.Button[@text='OK']")
    private static MobileElement okButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/close_iv")
    private static MobileElement whatsappCloseIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/continue_btn")
    private static List<MobileElement> passwordContinueButton;
    @AndroidFindBy(id = "android:id/button1")
    private static MobileElement okRefreshButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='My Account']")
    private static MobileElement myAccountButton;
    @AndroidFindBy(xpath = "//*[@text='Mint Digital']")
    private static MobileElement subscriptionPlanDetails;
    @AndroidFindBy(xpath = "//*[@text='Logout']")
    private static MobileElement LogoutButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement firstStoryHomePage;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;

    public SubscriptionPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    @Override
    public boolean checkPlanPage() {
        boolean checkPlanPageStatus;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(subscribeButton, 10, "Subscribe Button");
        checkPlanPageStatus = commonFunctions.isElementDisplayed(chooseAPlanButton, 10, "Choose A Plan Button");
        commonFunctions.dummyWait(2);
        commonFunctions.navigateBack();
        return checkPlanPageStatus;
    }

    @Override
    public boolean checkSubscribeNavigation() {
        boolean checkPlanPageStatus;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.clickElement(subscribe, 10, "Subscribe");
        checkPlanPageStatus = commonFunctions.isElementDisplayed(chooseAPlanButton, 10, "Plan Page Header");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(navigateUpButton, 10, "Navigate back");
        commonFunctions.navigateBack();
        return checkPlanPageStatus;
    }

    @Override
    public boolean checkPlansVisible() {
        boolean checkPlansAreVisibleStatus;
        commonFunctions.clickElementIfDisplayed(yesIAmInButton, 10, "Yes I am in Button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad Close Button");
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(subscribeButton, 10, "Subscribe Button");
        checkPlansAreVisibleStatus = commonFunctions.isElementDisplayed(chooseAPlanButton, 10, "Choose A Plan Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(navigateUpButton, 10, "Navigate back");
        return checkPlansAreVisibleStatus;
    }


    @Override
    public boolean checkPremiumStoryPlansVisible() {
        boolean isPremiumStoryPlansLoad;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.scrollDownToElement(premiumStories);
        commonFunctions.clickElement(firstPremiumStory.get(0), 10, "First Premium Story");
        commonFunctions.scrollDownToElement(premiumCollectOfferButton);
        commonFunctions.clickElement(premiumCollectOfferButton, 10, "Collect Offer/Subscribe Button");
        commonFunctions.dummyWait(2);
        isPremiumStoryPlansLoad = commonFunctions.isElementDisplayed(choosePlansHeader, 10, "Choose A Plan Header");
        commonFunctions.navigateBack();
        commonFunctions.navigateBack();
        return isPremiumStoryPlansLoad;
    }


    @Override
    public boolean checkSubscribeLink() {
        return false;
    }

    @Override
    public boolean checkRemoveAd() {
        return false;
    }

    @Override
    public boolean checkNonLoggedInUserStories() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        isShowing = commonFunctions.isElementDisplayed(firstStoryHomePage, 10, "first story headline");
        withoutLoginInFirstStoryHeadlineHomePage = commonFunctions.getElementText(firstStoryHomePage, 10);
        return isShowing;
    }

    @Override
    public boolean checkSubscribedUserStories() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "home button");
        isShowing = commonFunctions.isElementDisplayed(firstStoryHomePage, 10, "first story headline");
        subscribedUserFirstStoryHeadlineHomePage = commonFunctions.getElementText(firstStoryHomePage, 10);
        isShowing &= commonFunctions.checkTextNotEquals(withoutLoginInFirstStoryHeadlineHomePage, subscribedUserFirstStoryHeadlineHomePage, "Story headline");
        return isShowing;
    }

    @Override
    public boolean checkPlanVisibilityAndClickable() {
        boolean isPlanVisibilityAndClickableTrue = true;
        commonFunctions.clickElementIfDisplayed(yesIAmInButton, 10, "Yes I am Button");
        commonFunctions.clickElement(homeButton, 10, "Home button");
        isPlanVisibilityAndClickableTrue &= commonFunctions.clickElement(subscribeButton, 10, "Subscribe button on top of Homepage");
        isPlanVisibilityAndClickableTrue &= isAllElementsAreClickable(allPlans, "Subscribe plans");
        isPlanVisibilityAndClickableTrue &= commonFunctions.clickElement(startPlanSubscribe, 10, "Start trial for 14 days");
        String loginRegisterText = commonFunctions.getElementText(loginRegister, 10);
        isPlanVisibilityAndClickableTrue &= commonFunctions.checkElementText(loginRegister, loginRegisterText,10, "Login or Register page Header");
        commonFunctions.pressAndroidBackKey();
        return isPlanVisibilityAndClickableTrue;
    }

    @Override
    public boolean checkValidationOfSubscriptionsPlanDetails() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(myAccountButton, 10, "My Account button");
        isShowing = commonFunctions.isElementDisplayed(subscriptionPlanDetails, 10, "subscription plan: Mint Digital");
        commonFunctions.navigateBack();
        return isShowing;
    }

    public boolean clickContinueButton() {
        boolean isClickContinueButtonTrue = false;
        try {
            for (MobileElement ele : passwordContinueButton) {
                isClickContinueButtonTrue = commonFunctions.clickElement(ele, 10, "Continue related button");
            }
        } catch (Exception e) {
            isClickContinueButtonTrue = false;
        }
        return isClickContinueButtonTrue;
    }

    @Override
    public boolean checkSubscribedUserIsAdFree() {
        return false;
    }

    public boolean isAllElementsAreClickable(List<MobileElement> elementList, String elementName) {
        boolean isAllElementsAreClickableTrue = false;
        try {
            for (MobileElement ele : elementList) {
                isAllElementsAreClickableTrue = commonFunctions.isElementVisible(ele, 10, elementName + " related element");
                isAllElementsAreClickableTrue &=true;
                Utils.logStepInfo(true, "All elements related to " + elementName + " are clickable");
            }
        } catch (Exception e) {
            isAllElementsAreClickableTrue = false;
            Utils.logStepInfo(false, "All elements related to " + elementName + " are not clickable");
        }
        return isAllElementsAreClickableTrue;
    }

}