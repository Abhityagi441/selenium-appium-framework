package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonMintLoungePage;
import com.pages.LiveMint.genericPages.CommonPodCastPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MintLoungePage extends CommonMintLoungePage {

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
    @AndroidFindBy(id = "com.htmedia.mint:id/collection_image")
    private static MobileElement mintLoungeSection;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.htmedia.mint:id/collection_image']/following-sibling::android.widget.TextView[@text='View All']")
    private static MobileElement mintLoungeViewAll;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/imgViewHeader_inner_collection'])[1]//following::*[@resource-id='com.htmedia.mint:id/title_inner_collection'][1]")
    private static MobileElement mintLoungeStoryName;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/imgViewHeader_inner_collection'])[1]/following::*[@resource-id='com.htmedia.mint:id/time_inner_collection'][1]")
    private static MobileElement mintLoungeTimeStamp;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/cardViewBg']")
    private static List<MobileElement> mintLoungeListOfStoryCard;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MINT LOUNGE']")
    private static MobileElement mintLoungePage;
    @AndroidFindBy(id = "com.htmedia.mint:id/cardViewNewsItem")
    private static List<MobileElement> mintLoungePageListOfStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreHamburger;
    @AndroidFindBy(id = "com.htmedia.mint:id/iv_close")
    private static MobileElement exploreCloseIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lounge']")
    private static MobileElement exploreMintLoungeOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
    private static MobileElement backButton;
    @FindBy(xpath = "//android.widget.TextView[@text='MINT SNAPVIEW']")
    private static MobileElement snapView;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/imgViewHeader_inner_collection'])[1]//following::*[@resource-id='com.htmedia.mint:id/title_inner_collection']")
    private static List<MobileElement> mintLoungeListOfStoryCardName;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/collection_image']//following::*[@resource-id='com.htmedia.mint:id/imgViewBookmark_inner_collection']")
    private static MobileElement bookmarkIcon;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/listClick']")
    private static List<MobileElement> mintLoungePageListOfListingStory;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/imgViewBookmark']")
    private static List<MobileElement> mintLoungePageListOfBookmarkStory;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/imgViewShare']")
    private static List<MobileElement> mintLoungePageListOfShareIconStory;
    @FindBy(xpath = "//android.widget.TextView[@text='Share']")
    private static MobileElement mintLoungePageShareTitleText;
    @FindBy(xpath = "//android.widget.TextView[@text='Bluetooth']")
    private static MobileElement mintLoungePageBluetoothText;
    @FindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    private static MobileElement mintLoungePageGmailText;
    @FindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private static MobileElement mintLoungePageMessageText;
    @FindBy(xpath = "//android.widget.TextView[@text='Save to Drive']")
    private static MobileElement mintLoungePageDriveText;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/txtViewDetailNewsHeadline']")
    private static MobileElement storyDetailPage;
    @FindBy(xpath = "//android.widget.TextView[@content-desc='Share']")
    private static MobileElement shareIconOnStoryDetailPage;
    @FindBy(xpath = "//android.widget.TextView[@content-desc='Text size']")
    private static MobileElement fontIconOnStoryDetailPage;
    @FindBy(xpath = "//android.widget.TextView[@text='Advertisement']")
    private static MobileElement AdAdvertisementLabel;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;


    public MintLoungePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    @Override
    public boolean checkMintLoungeCarousel() {
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.scrollToElementDown(mintLoungeSection);
        return commonFunctions.checkElementVisibilityByScrolling(mintLoungeSection, "mintLounge Carousel");
    }

    @Override
    public boolean checkAllMintLoungeStoryCardSizeSame() {
        boolean isShowing;
        isShowing = checkMintLoungeCarousel();
        int firstCardWidth = mintLoungeListOfStoryCard.get(0).getSize().getWidth();
        int firstCardHeight = mintLoungeListOfStoryCard.get(0).getSize().getHeight();
        int secondCardWidth = mintLoungeListOfStoryCard.get(1).getSize().getWidth();
        int secondCardHeight = mintLoungeListOfStoryCard.get(1).getSize().getHeight();
        if (isShowing &= firstCardWidth == secondCardWidth || firstCardHeight == secondCardHeight) {
            Utils.logStepInfo(true, "all story card size are same verified successfully !!!!!");
            isShowing &= true;
        } else {
            Utils.logStepInfo(false, "all story card size are Not same ******verification failed *******");
            isShowing &= false;
        }
        return isShowing;
    }

    @Override
    public boolean checkMintLoungeStoryCardDesign() {
        boolean isShowing;
        isShowing = checkMintLoungeCarousel();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mintLoungeStoryName, "story name below of image");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mintLoungeTimeStamp, "time stamp below of image");
        return isShowing;
    }

    private boolean checkMintLoungeViewAll() {
        boolean isShowing;
        isShowing = checkMintLoungeCarousel();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mintLoungeViewAll, "mintLounge VewAll");
        return isShowing;
    }

    @Override
    public boolean checkMintLoungeVewAllFunctionality() {
        boolean isShowing;
        isShowing = checkMintLoungeViewAll();
        commonFunctions.clickElement(mintLoungeViewAll, 10, "mintLounge ViewAll");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePage, 10, "mintLounge page");
        return isShowing;
    }

    @Override
    public boolean checkMintLoungePageAndBackButtonByHomePage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        commonFunctions.clickElement(backButton, 10, "back button on mintLounge page");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungeSection, 10, "mintLounge carousel");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkMintLoungePageAndBackButtonByExploreHamburger() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.clickElement(exploreHamburger, 10, "explore hamburger");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(exploreMintLoungeOption, "mintLounge option");
        commonFunctions.clickElement(exploreMintLoungeOption, 10, "mintLounge");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePage, 10, "mintLounge page");
        commonFunctions.clickElement(backButton, 10, "back button on mintLounge page");
        isShowing &= commonFunctions.isElementDisplayed(explorePage, 10, "explore page");
        commonFunctions.clickElement(exploreCloseIcon, 10, "explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkMintLoungeCarouselSlider() {
        boolean isShowing;
        isShowing = checkMintLoungeStoryCardDesign();
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(mintLoungeListOfStoryCardName,0,"third story");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(mintLoungeListOfStoryCardName,2,"first story");
        String thirdStoryTextBeforeSlide = commonFunctions.getElementText(mintLoungeListOfStoryCardName.get(2), 10);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        String thirdStoryTextAfterSlide = commonFunctions.getElementText(mintLoungeListOfStoryCardName.get(2), 10);
        if (isShowing &= thirdStoryTextBeforeSlide != thirdStoryTextAfterSlide) {
            isShowing &= true;
            Utils.logStepInfo(true, "card swipe successfully*****");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "card Not swipe failed!!!!");
        }
        return isShowing;
    }

    @Override
    public boolean checkBookmarkIcon() {
        boolean isShowing;
        isShowing = checkMintLoungeViewAll();
        isShowing &= commonFunctions.isElementNotDisplayed(bookmarkIcon, 5, "bookmark icon");
        return isShowing;
    }

    @Override
    public boolean checkMintLoungeListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(mintLoungePageListOfListingStory, "mintLounge listing page same as other listing page");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkNoBookmarkIconOnMintLoungeListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        isShowing &= commonFunctions.compareWithSizeListOfElements(mintLoungePageListOfBookmarkStory, 0, "no bookmark icon is present on mintLounge listing page");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkShareIconAllAvailableOptionOnMintLoungeListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        commonFunctions.clickElement(mintLoungePageListOfShareIconStory.get(1), 10, "first story share icon");
        isShowing &= allAvailableShareOption();
        commonFunctions.navigateBack();
        commonFunctions.navigateBack();
        return isShowing;
    }

    private boolean allAvailableShareOption() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(mintLoungePageShareTitleText, 10, "share text");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageBluetoothText, 10, "bluetooth option");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageGmailText, 10, "Gmail option");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageMessageText, 10, "Message option");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageDriveText, 10, "Drive option");
        return isShowing;
    }

    @Override
    public boolean checkAdsOnListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        isShowing &= commonFunctions.isElementNotDisplayed(AdAdvertisementLabel, 10, "ads on mintLounge page");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        commonFunctions.clickElement(mintLoungePageListOfListingStory.get(1), 10, "first story on listing page");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(335,166);
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPage, 10, "story detail page headline");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailPageShareFunctionality() {
        boolean isShowing;
        isShowing = checkStoryDetailPage();
        commonFunctions.clickElement(shareIconOnStoryDetailPage,10,"share icon");
        isShowing &= allAvailableShareOption();
        commonFunctions.navigateBack();
        commonFunctions.navigateBack();
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailPageFontSize() {
        boolean isShowing;
        isShowing = checkStoryDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(fontIconOnStoryDetailPage, 10, "font size");
        commonFunctions.navigateBack();
        return isShowing;
    }

}