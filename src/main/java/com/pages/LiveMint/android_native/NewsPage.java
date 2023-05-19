package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonNewsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage extends CommonNewsPage {

    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='News']")
    private static MobileElement newsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEWS']")
    private static MobileElement newsPage;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='News']/android.view.ViewGroup/android.widget.TextView")
    private static MobileElement newsTabPosition;
    @FindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement paywallSubscribeNow;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/txtViewNewsHeadline'])[2]")
    private static MobileElement firstListingStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewDetailListenBottom")
    private static MobileElement textToSpeechButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='RECOMMENDED FOR YOU']")
    private static MobileElement recommendedForYou;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement storyDetailPageHeadline;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe Right for next story']")
    private static MobileElement swipeRightForNextStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailImageCaption")
    private static MobileElement imageCaption;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/txtViewDetailReadTime'])[1]")
    private static MobileElement readTime;
    @AndroidFindBy(id = "com.htmedia.mint:id/llSummary")
    private static MobileElement storySummary;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewParagraph")
    private static MobileElement storyParagraph;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewHeader")
    private static MobileElement homePageFirstStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/largeLabel")
    private static MobileElement homePageHighlighted;


    public NewsPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    private boolean checkNewsPage() {
        commonFunctions.clickElement(newsButton,10,"news tab");
        return commonFunctions.isElementDisplayed(newsPage,10,"news page");
    }

    @Override
    public boolean checkNewsSection() {
        return commonFunctions.isElementDisplayed(newsButton, 10, "news section");
    }

    @Override
    public boolean checkNewsSectionPosition() {
        String newsPosition = "(283, 1964)";
        String newsLabel = newsTabPosition.getLocation().toString();
        if (newsPosition.equals(newsLabel)) {
            Utils.logStepInfo(true, "news tab position Verification Successfully !!!!!");
            return true;
        } else {
            Utils.logStepInfo(false, "news tab position Verification Failed !!!!!");
            return false;
        }
    }

    @Override
    public boolean checkNewsSectionStoriesIsFree() {
        boolean isShowing;
        isShowing = checkNewsPage();
        commonFunctions.tapElementWithCoOrdinates(102,399, "First story in the premium");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementNotDisplayed(paywallSubscribeNow, 10, "paywall subscribe now");
        commonFunctions.clickElement(newsButton,10,"news tab");
        commonFunctions.clickElement(homeButton, 10, "Home tab");
        return isShowing;
    }

    @Override
    public boolean checkStoryFunctionalityTextToSpeech() {
        boolean isShowing = checkNewsPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(firstListingStory, "first listing story");
        commonFunctions.clickElement(firstListingStory, 10, "listing story");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(textToSpeechButton, "text to speech on story detail page");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkRecommendedForYouOnStoryDetailPage() {
        boolean isShowing = checkNewsPage();
        isShowing &= checkStoryDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(recommendedForYou, "Recommended ForYou on story detail page");
        return isShowing;
    }

    private boolean checkStoryDetailPage() {
        boolean isShowing = commonFunctions.checkElementVisibilityByScrolling(firstListingStory, "first listing story");
        commonFunctions.clickElement(firstListingStory, 10, "listing story");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(325, 169);
        commonFunctions.dummyWait(1);
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story Detail Page Headline");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailAllField() {
        boolean isShowing = checkNewsPage();
        isShowing &= checkStoryDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(imageCaption, 10, "image caption");
        isShowing &= commonFunctions.isElementDisplayed(readTime, 10, "story read time");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(storySummary, "story summary");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(storyParagraph, "story Paragraph");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailSwipePopup() {
        boolean isShowing = checkNewsPage();
        isShowing &= checkStoryDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(swipeRightForNextStory, 10, "swipe Right For Next Story");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.clickElement(homePageFirstStory, 10, "home Page First Story");
        return commonFunctions.isElementDisplayed(homePageHighlighted, 10, "home Page Highlighted");
    }

    @Override
    public boolean checkStoryDetailPageAfterClickOnListingStory() {
        boolean isShowing = checkNewsPage();
        isShowing &= checkStoryDetailPage();
        return isShowing;
    }

    @Override
    public boolean checkHorizontallySwipeForNextStory() {
        boolean isShowing = checkStoryDetailPageAfterClickOnListingStory();
        String text1 = commonFunctions.getElementText(storyDetailPageHeadline, 5);
        commonFunctions.swipeElementUsingTouchAction(988, 1278, 124, 1271);
        commonFunctions.dummyWait(3);
        if (!text1.equals(storyDetailPageHeadline.getText())) {
            Utils.logStepInfo(true, "Swipe horizontally Verification Successfully !!!!!");
            isShowing &= true;
        } else {
            Utils.logStepInfo(false, "Swipe horizontally Verification Failed !!!!!");
            isShowing = false;
        }
        return isShowing;
    }

}

