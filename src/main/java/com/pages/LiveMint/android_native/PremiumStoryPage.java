package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonPremiumStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PremiumStoryPage extends CommonPremiumStoryPage {
    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonHomePage homePage;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/tvNo")
    private static MobileElement noButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;

    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    private static MobileElement storyWidgetFirstStory;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Premium']")
    private static MobileElement premiumButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewTextSize")
    private static MobileElement textSizeButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewHeader")
    private static MobileElement firstStory;

    @AndroidFindBy(id = "com.htmedia.mint:id/touch_outside")
    private static MobileElement touchOutside;

    @AndroidFindBy(id = "com.htmedia.mint:id/tvSelectFontSize")
    private static MobileElement selectFontSizeTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='See All']")
    private static MobileElement seeAllIcon;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewEpaper")
    private static MobileElement signInButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement emailInbox;

    @AndroidFindBy(id = "com.htmedia.mint:id/continue_btn")
    private static MobileElement emailContinueButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/password_et")
    private static MobileElement passwordInbox;

    @AndroidFindBy(id = "android:id/button1")
    private static MobileElement okRefreshButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/continue_btn")
    private static List<MobileElement> passwordContinueButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/premium_tag_tv")
    private static List<MobileElement> firstVisiblePremimiumStroy;

    @AndroidFindBy(id = "com.htmedia.mint:id/imageViewAppLogo")
    private static MobileElement mintPremiumLogo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PREMIUM']")
    private static MobileElement mintPremiumStoryPageTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txt_my_account")
    private static MobileElement myAccountButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewPlanName")
    private static MobileElement subscriptionPlanDetails;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtLogout")
    private static MobileElement logOutButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewBody1")
    private static MobileElement payWallElement;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> headLinesWallElement;

    @AndroidFindBy(id = "com.htmedia.mint:id/recyclerViewMarketTicker")
    private static MobileElement marketTickerElements;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewParagraph")
    private static List<MobileElement> paraGraphs;

    @AndroidFindBy(id = "com.htmedia.mint:id/listClick")
    private static List<MobileElement> premiumListGraphs;

    @AndroidFindBy(id = "com.htmedia.mint:id/layoutContentAdsBG")
    private static MobileElement ads;
    @FindBy(xpath = "//android.widget.TextView[@text='back']")
    private static MobileElement backBtn;
    @AndroidFindBy(xpath = "(//android.view.View[1]/android.view.View)[1]")
    private static MobileElement adsBanner;
    @FindBy(xpath = "//android.widget.TextView[@text='Chrome']")
    private static MobileElement mintGenieWebPageChrome;
    @FindBy(id = "android:id/button_once")
    private static MobileElement justOnce;
    @FindBy(id = "com.android.chrome:id/url_bar")
    private static MobileElement webPage;
    @AndroidFindBy( accessibility= "Home")
    private static MobileElement webPageHomeIcon;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(id = "com.htmedia.mint:id/txtViewClose")
    private static MobileElement storyCloseIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/detail_premium_tag_tv")
    private static MobileElement premiumTagSticker;
    @FindBy(xpath = "//android.widget.TextView[@text='Advertisement']")
    private static MobileElement firstAdsAdvertisementLabel;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement storyDetailPageHeadline;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement paywallSubscribe;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewSignIn")
    private static MobileElement paywallSignIn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign-in to Unlock for free']")
    private static MobileElement freemiumPaywallSignIn;
    @AndroidFindBy(id = "com.htmedia.mint:id/unlockToastRL")
    private static MobileElement unlockFreemiumCount;
    @AndroidFindBy(id = "com.htmedia.mint:id/email_or_mobile_et")
    private static MobileElement emailTextBoxMainSignInPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewAlreadySubscribed")
    private static MobileElement subscribedBtn;


    public PremiumStoryPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        homePage= CommonHomePage.getInstance();
    }

    @Override
    public boolean checkStory() {
        return false;
    }

    @Override
    public boolean mintPremiumWidget(String email, String password, String mintPrimiumText) {
        boolean isMintPremiumWidgetTrue = true;

        homePage.clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.clickElement(signInButton, 10, "Sign In Button");
        commonFunctions.sendKeyBoolean(emailInbox, email, 10);
        commonFunctions.clickElement(emailContinueButton, 10, "Continue button after email");
        commonFunctions.sendKeyBoolean(passwordInbox, password, 10);
        Utils.logStepInfo(true, "Click on the continue button to login.");
        clickContinueButton(passwordContinueButton);
        commonFunctions.clickElementIfDisplayed(okRefreshButton, 10, "Ok button to refresh before login page.");
        clickOnlyFirstStory(firstVisiblePremimiumStroy);
        commonFunctions.scrollDownToElement(seeAllIcon);
        commonFunctions.clickElement(seeAllIcon, 10, "See all icon");
        isMintPremiumWidgetTrue &= commonFunctions.isElementVisible(mintPremiumLogo, 10, "Mint Logo");
        isMintPremiumWidgetTrue &= commonFunctions.isElementVisible(mintPremiumStoryPageTitle, 10, "Mint Logo");
        String liveMintPremiumPageTitle = commonFunctions.getElementText(mintPremiumStoryPageTitle, 10);
        Utils.logStepInfo(true, "Compare text of current page title with " + mintPrimiumText + " text");
        isMintPremiumWidgetTrue &= commonFunctions.isCompareTextTrue(liveMintPremiumPageTitle, mintPrimiumText);
        commonFunctions.clickElement(myAccountButton, 10, "My Account button");
        if(commonFunctions.isElementNotDisplayed(logOutButton,10,"logout button"))
        {
            commonFunctions.clickElement(myAccountButton, 10, "My Account button");
        }
        commonFunctions.scrollDownToElement(logOutButton,"logout button");
        commonFunctions.clickElement(logOutButton, 10, "Logout button");
        while (commonFunctions.isElementNotDisplayed(homeButton,10,"home button")) {
            commonFunctions.tapBackButton();
        }
        return isMintPremiumWidgetTrue;
    }

    @Override
    public boolean storyPageTextSizeSelection() {
        return false;
    }

    @Override
    public boolean moreFromSectionWidget() {
        return false;
    }

    @Override
    public boolean checkAdsRemovedPremiumPage() {
        homePage.clickOnHomeButtonWithHandlingDarkMode();
        return clickOnPremiumAndCheckAdsNotPresent();
    }

    @Override
    public boolean checkAdsPresentPremiumPage() {
        boolean isShowing;
        homePage.clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        isShowing = commonFunctions.checkElementText(mintPremiumStoryPageTitle, "PREMIUM", 10, "premium title text");
        commonFunctions.clickElement(firstVisiblePremimiumStroy.get(0), 10, "first Story premium");
        commonFunctions.scrollUpUntilElementFound(ads);
        commonFunctions.isElementDisplayed(ads, 10, "ads found on premium page");
        commonFunctions.clickElement(backBtn, 10, "back button");
        isShowing &= commonFunctions.checkElementText(mintPremiumStoryPageTitle,"PREMIUM", 10, "premium title text");
        return isShowing;
    }

    @Override
    public boolean checkAdsRedirection() {
        boolean isShowing;
        homePage.clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(ads, 10, "ads found on home page");
        commonFunctions.isElementDisplayedAndPresent(adsBanner, 10, "ads banner present");
        commonFunctions.clickElement(adsBanner, 10, "ads banner");
        commonFunctions.clickElementIfDisplayed(mintGenieWebPageChrome, 10, "chrome browser");
        commonFunctions.clickElementIfDisplayed(justOnce, 10, "just once option");
        isShowing &= commonFunctions.isElementDisplayed(webPage, 10, "webpage");
        isShowing &= commonFunctions.isElementDisplayed(webPageHomeIcon, 10, "home icon webPage");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkPageSwitching(String email, String password, String premiumText) {
        String premiumListPageTitle=null;
        boolean isPremiumStoryPageDetailsTrue;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        premiumListPageTitle = commonFunctions.getElementText(mintPremiumStoryPageTitle, 10);
        boolean isPremiumPageTitleMatchTrue = commonFunctions.isCompareTextTrue(premiumListPageTitle, premiumText);
        commonFunctions.clickElement(premiumListGraphs.get(0), 10, "First premium story from the premium Storylist.");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(325,162);
        isPremiumStoryPageDetailsTrue = paragraphVisibilty(paraGraphs);
        commonFunctions.clickElement(homeButton,10,"Home button");
        boolean isHomePageOpened = commonFunctions.isElementVisible(marketTickerElements, 10, "Market Ticker at Home Page");
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        premiumListPageTitle = commonFunctions.getElementText(mintPremiumStoryPageTitle, 10);
        isPremiumPageTitleMatchTrue &= commonFunctions.isCompareTextTrue(premiumListPageTitle, premiumText);
        return isPremiumPageTitleMatchTrue && isHomePageOpened && isPremiumStoryPageDetailsTrue;
    }

    @Override
    public boolean checkNoPayWallToSubscribedUser(String email, String password) {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        isShowing = commonFunctions.isElementDisplayed(mintPremiumStoryPageTitle, 10, "Premium Page Title");
        commonFunctions.clickElement(firstVisiblePremimiumStroy.get(0), 10, "first Story premium");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(332,162);
       if (!commonFunctions.scrollDownSlowToElement(payWallElement,3)){
           Utils.logStepInfo(true, "payWall Not displayed, This is expected !!!!!!!");
       }
       else{
           Utils.logStepInfo(false, "payWall displayed,verification Failed !!!!!!!");
       }
        return isShowing;
    }

    @Override
    public boolean mintPremiumWidgetListingStory() {
        return false;
    }

    public boolean clickContinueButton(List<MobileElement> elementList) {
        boolean isClickContinueButtonTrue = false;
        try {
            for (MobileElement ele : elementList) {
                isClickContinueButtonTrue = commonFunctions.clickElement(ele, 10, "Continue related button");
            }
        } catch (Exception e) {
            isClickContinueButtonTrue = false;
        }
        return isClickContinueButtonTrue;
    }

    public boolean clickOnlyFirstStory(List<MobileElement> elementList) {
        boolean isClickContinueButtonTrue = false;
        try {
            for (int i = 0; i <= elementList.size(); i++) {
                MobileElement ele = elementList.get(i);
                commonFunctions.scrollDownToElement(ele);
                isClickContinueButtonTrue = commonFunctions.clickElement(ele, 10, "First premium story");
                break;
            }
        } catch (Exception e) {
            isClickContinueButtonTrue = false;
        }
        return isClickContinueButtonTrue;
    }


    public boolean paragraphVisibilty(List<MobileElement> elementList) {
        boolean isParagraphVisibilityTrue = false;
        MobileElement ele;
        try {
            for (int i = 0; i < elementList.size(); i++) {
                ele = elementList.get(i);
                if (ele.isDisplayed()) {
                    Utils.logStepInfo(true, i + " paragraph of the the story is displaying.");
                    isParagraphVisibilityTrue = true;
                } else if (!ele.isDisplayed()) {
                    Utils.logStepInfo(true, "Scroll down to find the " + i + " paragraph.");
                    commonFunctions.scrollDownToElement(ele);
                    if (ele.isDisplayed()) {
                        Utils.logStepInfo(true, i + " paragraph of the the story is displaying.");
                        isParagraphVisibilityTrue = true;
                    }
                }
            }
        } catch (Exception e) {
            isParagraphVisibilityTrue = false;
            Utils.logStepInfo(false, "Paragraphs of the story is not displaying.");
        }
        return isParagraphVisibilityTrue;
    }

    @Override
    public boolean subscribedUserAdsFreePremiumStoryDetailPage() {
        boolean isShowing;
        isShowing = homePage.checkMyAccountLink();
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 10, "Close Ad");
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        isShowing &= commonFunctions.isElementDisplayed(mintPremiumStoryPageTitle, 10, "Premium Page Title");
        commonFunctions.clickElement(firstVisiblePremimiumStroy.get(0), 10, "first Story premium");
        commonFunctions.scrollToBottomForAndroidNative();
        isShowing &= commonFunctions.isElementNotDisplayed(ads, 10, "ads not found on premium page");
        commonFunctions.navigateBack();
        isShowing &= commonFunctions.checkElementText(mintPremiumStoryPageTitle,"PREMIUM", 10, "premium title text");
        return isShowing;
    }

    @Override
    public boolean subscribedUserAdsFreePremiumListingPage() {
        boolean isShowing;
        isShowing = homePage.checkMyAccountLink();
        isShowing &= clickOnPremiumAndCheckAdsNotPresent();
        return isShowing;
    }

    @Override
    public boolean nonSubscribedUserAdsFreePremiumListingPage() {
       return clickOnPremiumAndCheckAdsNotPresent();
    }

    private boolean clickOnPremiumAndCheckAdsNotPresent() {
        boolean isShowing;
        commonFunctions.clickElementIfDisplayed(popUpAdClose, 10, "Close Ad");
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        isShowing = commonFunctions.isElementDisplayed(mintPremiumStoryPageTitle, 10, "Premium Page Title");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToBottomForAndroidNative();
        isShowing &= commonFunctions.isElementNotDisplayed(ads, 10, "Advertisement not displayed");
        return isShowing;
    }

    @Override
    public boolean checkBackButton() {return false;}

    @Override
    public boolean checkPremiumPageSubNavTabs() {
        return false;
    }

    @Override
    public boolean checkPremiumPageCompaniesSubNav() {
        return false;
    }

    @Override
    public boolean checkPremiumPageTechnologySubNav() {
        return false;
    }

    @Override
    public boolean checkPremiumPageMoneySubNav() {
        return false;
    }

    @Override
    public boolean checkPremiumPageMarketsSubNav() {
        return false;
    }

    @Override
    public boolean checkPremiumPageCompaniesDataLoad() {
        return false;
    }

    @Override
    public boolean checkPremiumPageMutualFundsSubNav() {
        return false;
    }

    @Override
    public boolean checkPremiumPageIndustrySubNav() {
        return false;
    }

    @Override
    public boolean checkPremiumWidgetViewAll(String Heading, String Url, String AmpUrl) {
        return false;
    }

    @Override
    public boolean checkPremiumPagePersonalFinanceSubNav() {
        return false;
    }

    @Override
    public boolean checkPremiumPageAutoSubNav() {
        return false;
    }

    @Override
    public boolean checkAdsNotPresentOnStoryDetailPage() {
       boolean isShowing= openPremiumStoryDetailPage();
        isShowing &= commonFunctions.isElementNotDisplayed(firstAdsAdvertisementLabel, 5, "ads not found on premium story detail page");
        return isShowing;
    }

    private boolean openPremiumStoryDetailPage() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        isShowing = commonFunctions.checkElementText(mintPremiumStoryPageTitle, "PREMIUM", 10, "premium title text");
        commonFunctions.clickElement(firstVisiblePremimiumStroy.get(0), 10, "first Story premium");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(325, 169);
        commonFunctions.dummyWait(1);
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story Detail Page Headline");
        return isShowing;
    }

    @Override
    public boolean checkPremiumStickerPresentOnStoryDetailPage() {
       boolean isShowing= openPremiumStoryDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(premiumTagSticker, 10, "premium sticker on premium story detail page");
        return isShowing;
    }

    @Override
    public boolean checkPremiumStickerDisappearOnStoryDetailPage() {
        boolean isShowing = openPremiumStoryDetailPage();
        commonFunctions.swipeElementUsingTouchAction(448, 1550, 466, 300);
        isShowing &= commonFunctions.isElementNotDisplayed(premiumTagSticker, 5, "premium sticker on premium story detail page");
        return isShowing;
    }

    @Override
    public boolean checkPaywallForPremiumStories() {
        boolean isShowing = openPremiumStoryDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(paywallSubscribe, "Paywall");
        return isShowing;
    }

    @Override
    public boolean clickOnSignInFromPaywall() {
        boolean isShowing = checkPaywallForPremiumStories();
        commonFunctions.checkElementVisibilityByScrolling(paywallSignIn, "paywall sign-in");
        commonFunctions.clickElement(paywallSignIn, 10, "paywall sign-in");
        return isShowing;
    }

    @Override
    public boolean checkPaywallAndAds() {
        boolean isShowing = openPremiumStoryDetailPage();
        commonFunctions.isElementDisplayed(firstAdsAdvertisementLabel,5,"ads");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(paywallSubscribe, "Paywall");
        return isShowing;
    }

    @Override
    public boolean checkNoPaywallAndAdsForSubscribedUser() {
        boolean isShowing = openPremiumStoryDetailPage();
        isShowing = commonFunctions.isElementNotDisplayed(firstAdsAdvertisementLabel, 5, "ads");
        isShowing &= commonFunctions.elementNotDisplayByScrolling(paywallSubscribe, 5, "paywall");
        return isShowing;
    }

    @Override
    public boolean checkSignInFromFreemium() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.clickElement(premiumButton, 10, "Premium button");
        isShowing = commonFunctions.checkElementText(mintPremiumStoryPageTitle, "PREMIUM", 10, "premium title text");
        commonFunctions.swipeElementUsingTouchAction(448, 1754, 448, 381);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(firstVisiblePremimiumStroy.get(0), 10, "first Story premium");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(325, 169);
        commonFunctions.dummyWait(1);
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story Detail Page Headline");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freemiumPaywallSignIn,"freemium paywall");
        commonFunctions.clickElement(freemiumPaywallSignIn,5,"freemium paywall");
        int attempts = 0;
        while (attempts < 4) {
            System.out.println("**** Iteration: " + attempts);
            if (isShowing=commonFunctions.isElementDisplayedAndPresent(emailTextBoxMainSignInPage, 5, "signIn Page")) {
                isShowing = true;
                break;
            }else {
                commonFunctions.navigateBack();
                commonFunctions.clickElement(firstVisiblePremimiumStroy.get(attempts+1), 10, attempts+1+" Story Freemium");
                commonFunctions.checkElementVisibilityByScrolling(freemiumPaywallSignIn,"freemium paywall");
                commonFunctions.clickElement(freemiumPaywallSignIn,5,"freemium paywall");
            }
            attempts++;
        }
        return isShowing;
    }

    @Override
    public boolean checkNoPaywall() {
        boolean isShowing = openPremiumStoryDetailPage();
        isShowing &= commonFunctions.elementNotDisplayByScrolling(paywallSubscribe, 4, "premium paywall");
        commonFunctions.navigateBack();
        commonFunctions.swipeElementUsingTouchAction(448, 1754, 448, 381);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(firstVisiblePremimiumStroy.get(0), 10, "first Story premium");
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story Detail Page Headline");
        isShowing &=commonFunctions.elementNotDisplayByScrolling(freemiumPaywallSignIn, 4, "freemium paywall");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedBtnNotDisplayedOnPaywall() {
        boolean isShowing = openPremiumStoryDetailPage();
        isShowing &= commonFunctions.elementNotDisplayByScrolling(subscribedBtn, 4, "subscribed button on paywall");
        return isShowing;
    }


}