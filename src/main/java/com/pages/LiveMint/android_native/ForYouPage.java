package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonForYouPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ForYouPage extends CommonForYouPage {

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
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='For You']")
    private static MobileElement forYouTab;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewHeader")
    private static MobileElement bannerStoryImage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FOR YOU']")
    private static MobileElement forYouPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewShare")
    private static List<MobileElement> forYouPageShareIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewBookmark")
    private static List<MobileElement> forYouPageBookmarkIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> listOfStoryHeadline;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewDetailListenBottom")
    private static MobileElement textToSpeechButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static List<MobileElement> headlineStoryDetailPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/action_share")
    private static MobileElement shareIconStoryDetailPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/cardViewNewsItem")
    private static List<MobileElement> listOfStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/largeLabel")
    private static MobileElement bottomTabHighlightAfterClick;
    @AndroidFindBy(id = "com.htmedia.mint:id/action_bookmark")
    private static MobileElement bookmarkIconStoryDetailPage;
    @FindBy(xpath = "//android.widget.TextView[@text='Remove Ad']")
    private static MobileElement AdsRemoveAdButton;
    @FindBy(xpath = "//android.widget.TextView[@text='MINT PREMIUM']")
    private static MobileElement mintPremium;
    @FindBy(xpath= "(//*[@resource-id='com.htmedia.mint:id/txtViewDetailNewsHeadline'])[1]")
    private static MobileElement firstStoryHeadlineOnStoryDetailPage;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(id = "com.htmedia.mint:id/imgViewTextSize")
    private static MobileElement fontSizeTop;
    @FindBy(id = "com.htmedia.mint:id/imgViewTextSizeBottom")
    private static MobileElement fontSizeBottom;
    @FindBy(xpath = "//*[@text='RECOMMENDED FOR YOU']")
    private static MobileElement rfu;


    public ForYouPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }


    private boolean checkForYouPage() {
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        return commonFunctions.isElementDisplayed(forYouPage, 10, "for you page");
    }

    @Override
    public boolean checkForYouPageAndIcon() {
        return checkForYouPage();
    }

    @Override
    public boolean checkBannerStory() {
        boolean isShowing;
        isShowing = checkForYouPage();
        isShowing &= commonFunctions.isElementNotDisplayed(bannerStoryImage, 10, "Banner story");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkForYouIconInactive(String forYouText) {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(forYouTab, 10, "for you tab");
        isShowing &= commonFunctions.getElementTextAndCheck(bottomTabHighlightAfterClick, forYouText, 10, "for you tab inactive");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkShareAndBookmarkIconOnForYouPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(forYouPageShareIcon, 5, "share icon");
        isShowing &= commonFunctions.compareWithSizeListOfElements(forYouPageBookmarkIcon, 5, "bookmark icon");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkShareAndBookmarkStoryDetailPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(listOfStoryHeadline.get(1), 10, "first story");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(600,388);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(shareIconStoryDetailPage, "share icon on story detail page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(bookmarkIconStoryDetailPage, "bookmark icon on story detail page");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkTextToSpeechOnStoryDetailPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(listOfStoryHeadline.get(1), 10, "first story");
        commonFunctions.dummyWait(3);
        commonFunctions.clickByCoordinates(318,162);
        isShowing &= commonFunctions.isElementDisplayed(textToSpeechButton, 10, "text to speech on story detail page");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkAdsOnForYouPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        isShowing &= commonFunctions.isElementNotDisplayed(AdsRemoveAdButton, 5, "ads");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkAdOnStoryDetailPage() {
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(listOfStoryHeadline.get(1), 10, "first story");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(600,388);
        isShowing &= commonFunctions.isElementDisplayed(firstStoryHeadlineOnStoryDetailPage, 10, "first tory on story detail page");
        isShowing &= commonFunctions.isElementNotDisplayed(AdsRemoveAdButton, 3, "ads");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(rfu, "recommended for You");
        isShowing &= commonFunctions.isElementNotDisplayed(AdsRemoveAdButton, 3, "ads");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }

    @Override
    public boolean checkForYouNoOfStories(String noOfStories) {
        return false;
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
        boolean isShowing;
        isShowing = checkForYouPage();
        commonFunctions.clickElement(listOfStoryHeadline.get(1), 10, "first story");
        isShowing &= commonFunctions.isElementDisplayed(firstStoryHeadlineOnStoryDetailPage, 10, "first tory on story detail page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fontSizeTop, "Top position Font size");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(fontSizeBottom, "Bottom position Font Size");
        commonFunctions.clickElement(homeButton, 10, "home tab");
        return isShowing;
    }
    @Override
    public boolean checkFirstStoryForYou()
    {
        return false;
    }
    @Override
    public boolean checkFirstStoryForYouforSubscribedUser() {
        return false;
    }
    }

