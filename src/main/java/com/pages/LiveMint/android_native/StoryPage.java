package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonStoryPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StoryPage extends CommonStoryPage {

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

    @AndroidFindBy(accessibility = "Home")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/action_text")
    private static MobileElement textSizeButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewHeader")
    private static MobileElement firstStory;

    @AndroidFindBy(id = "com.htmedia.mint:id/touch_outside")
    private static MobileElement touchOutside;

    @AndroidFindBy(id = "com.htmedia.mint:id/tvSelectFontSize")
    private static MobileElement selectFontSizeTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/collection_viewall")
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

    @AndroidFindBy(id = "com.htmedia.mint:id/title_inner_collection")
    private static MobileElement firstVisiblePremimiumStroy;

    @AndroidFindBy(id = "com.htmedia.mint:id/imageViewAppLogo")
    private static MobileElement mintPremiumLogo;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement storyPageTitle;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Premium']")
    private static MobileElement premium;
    @FindBy(id = "com.htmedia.mint:id/imgViewDetailListenBottom")
    private static MobileElement audioButton;
    @FindBy(id = "com.htmedia.mint:id/nav_latest")
    private static MobileElement latest;
    @FindBy(id = "com.htmedia.mint:id/imgViewOffer")
    private static MobileElement freeArticles;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='For You']")
    private static MobileElement forYouTab;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FOR YOU']")
    private static MobileElement forYouPage;

    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        homePage = CommonHomePage.getInstance();
    }




    @Override
    public boolean mintPremiumWidget() {
        return false;
    }


    @Override
    public boolean storyPageTextSizeSelection() {
        boolean isTextSizeTrue;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(firstStory, 10, "First story");
        commonFunctions.dummyWait(3);
        commonFunctions.clickByCoordinates(318,187);
        commonFunctions.dummyWait(3);
        commonFunctions.clickElement(textSizeButton, 10, "Text Size Button");
        isTextSizeTrue = commonFunctions.isElementDisplayed(selectFontSizeTitle, 10, "Select Font Size Title");
        commonFunctions.navigateBack();
        return isTextSizeTrue;
    }

    @Override
    public boolean checkSimilarStoryWidget() {
        boolean isSimilarStoryWidgetTrue;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(firstStory, 10, "First Story");
        commonFunctions.scrollDownToElement(storyWidgetFirstStory);
        isSimilarStoryWidgetTrue = commonFunctions.isElementClickable(storyWidgetFirstStory, 10, "Story Widget First Story");
        isSimilarStoryWidgetTrue &= commonFunctions.clickElement(storyWidgetFirstStory, 10, "Story Widget First STory");
        return isSimilarStoryWidgetTrue;
    }

    @Override
    public boolean checkTextToSpeechNotPresent() {
        boolean isShowing;
        homePage.clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.clickElement(premium, 10, "premium tab");
        isShowing = commonFunctions.checkElementText(storyPageTitle, "PREMIUM", 10, "premium title text");
        commonFunctions.tapElementWithCoOrdinates(282, 409, "premium first story");
        isShowing &=  commonFunctions.isElementNotDisplayed(audioButton, 10, "listing audio icon");
        return isShowing;
    }

    @Override
    public boolean checkTextToSpeechPresent() {
        return false;
    }

    @Override
    public boolean moreFromSectionWidget() {
        return false;
    }

    @Override
    public boolean TextToSpeechFeatureNotPresentOnStoryWithPaywall() {
        boolean isShowing;
        homePage.clickOnHomeButtonWithHandlingDarkMode();
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        isShowing=commonFunctions.isElementDisplayed(forYouPage, 10, "for you page");
        commonFunctions.clickByCoordinates(399, 1055, "latest second story");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(332,152);
        if (isShowing &= commonFunctions.isElementNotDisplayed(audioButton, 10, "listing audio icon")) {
            commonFunctions.scrollDownToElement(freeArticles, "scroll free");
            isShowing &= commonFunctions.isElementDisplayed(freeArticles, 10, "paywall free articles");
        }
        return isShowing;
    }


}