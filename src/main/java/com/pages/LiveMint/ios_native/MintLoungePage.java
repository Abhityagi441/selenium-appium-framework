package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonMintLoungePage;
import com.pages.LiveMint.genericPages.CommonPodCastPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MintLoungePage extends CommonMintLoungePage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;
    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;
    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(id = "MINT LOUNGE")
    private static MobileElement mintLoungePage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private static List<MobileElement> mintLoungePageListOfStory;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='bookmark']")
    private static List<MobileElement> mintLoungePageListOfBookmarkIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='share']")
    private static List<MobileElement> mintLoungePageListOfShareIcon;
    @iOSXCUITFindBy(id = "ActivityListView")
    private static MobileElement mintLoungePageListOfShareOption;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='AirDrop']")
    private static MobileElement mintLoungePageShareOptionAirDrop;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Messages']")
    private static MobileElement mintLoungePageShareOptionMessage;
    @iOSXCUITFindBy(id = "More")
    private static MobileElement mintLoungePageShareOptionMore;
    @iOSXCUITFindBy(id = "Close")
    private static MobileElement mintLoungePageShareOptionCloseButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[82]//XCUIElementTypeStaticText")
    private static List<MobileElement> mintLoungeCarouselListOfElement;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[82]//XCUIElementTypeStaticText)[1]")
    private static MobileElement mintLoungeCarouselCard;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LoungeViewAllId']/following-sibling::XCUIElementTypeButton[@name='bookMarkId']")
    private static MobileElement mintLoungeCarouseBookmarkIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[82]/XCUIElementTypeButton/XCUIElementTypeStaticText")
    private static MobileElement mintLoungeViewAll;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'share'`][1]")
    private static MobileElement storyDetailPageShareIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'aa'`][1]")
    private static MobileElement storyDetailPageSizeIcon;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,' ')])[14]")
    private static MobileElement storyDetailPageHeadline;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Got it']")
    private static MobileElement gotIt;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement exploreHamburger;
    @iOSXCUITFindBy(id = "Lounge")
    private static MobileElement ExploreLoungeOption;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement backButton;
    @iOSXCUITFindBy(id = "EXPLORE")
    private static MobileElement explorePage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Remove Ad'`]")
    private static MobileElement firstAdsRemoveAdButton;


    public MintLoungePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        System.out.println("****************** MintLounge Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkMintLoungeCarousel() {
        return false;
    }

    private boolean checkMintLoungeViewAll() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(mintLoungeCarouselCard, "mintLounge section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mintLoungeViewAll, "mintLounge VewAll");
        return isShowing;
    }

    private boolean mintLoungeSectionOnHomePage() {
        commonFunctions.clickElement(home, 10, "home tab");
        return commonFunctions.checkElementVisibilityByScrolling(mintLoungeCarouselCard, "mintLounge section");
    }

    @Override
    public boolean checkAllMintLoungeStoryCardSizeSame() {
        return false;
    }

    @Override
    public boolean checkMintLoungeStoryCardDesign() {
        boolean isShowing;
        isShowing = mintLoungeSectionOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(mintLoungeCarouselListOfElement.get(0), 10, "mintLounge card time stamp");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungeCarouselListOfElement.get(1), 10, "mintLounge card story name");
        return isShowing;
    }

    @Override
    public boolean checkMintLoungeVewAllFunctionality() {
        boolean isShowing;
        isShowing = checkMintLoungeViewAll();
        commonFunctions.clickElement(mintLoungeViewAll, 10, "mint lounge view all");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePage, 10, "mintLounge page");
        return isShowing;
    }

    @Override
    public boolean checkMintLoungePageAndBackButtonByHomePage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        commonFunctions.dummyWait(10);
        commonFunctions.scrollToTopOniOSNative();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mintLoungeCarouselCard, "mintLounge section");
        return isShowing;
    }

    @Override
    public boolean checkMintLoungePageAndBackButtonByExploreHamburger() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        commonFunctions.clickElement(exploreHamburger, 10, "explore hamburger");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(ExploreLoungeOption, "lounge option");
        commonFunctions.clickElement(ExploreLoungeOption, 10, "mint lounge");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePage, 10, "mintLounge page");
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        isShowing &= commonFunctions.isElementDisplayed(explorePage, 10, "explore page");
        commonFunctions.killAppAndReLaunch();
        return isShowing;
    }

    @Override
    public boolean checkMintLoungeCarouselSlider() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home Tab");
        isShowing =commonFunctions.scrollDownToElementInBottom(mintLoungeCarouselCard, 25);
       /* isShowing = mintLoungeSectionOnHomePage();*/
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(mintLoungeCarouselListOfElement,1,"first element");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(mintLoungeCarouselListOfElement,3,"third element");
        String thirdStoryTextBeforeSlide = commonFunctions.getElementText(mintLoungeCarouselListOfElement.get(5), 10);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        String thirdStoryTextAfterSlide = commonFunctions.getElementText(mintLoungeCarouselListOfElement.get(5), 10);
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
    public boolean checkMintLoungeListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(mintLoungePageListOfStory, "mintLounge listing page same as other listing page");
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        return isShowing;
    }

    @Override
    public boolean checkBookmarkIcon() {
        boolean isShowing;
        isShowing = mintLoungeSectionOnHomePage();
        isShowing &= commonFunctions.isElementNotDisplayed(mintLoungeCarouseBookmarkIcon, 5, "bookmark icon");
        return isShowing;
    }

    @Override
    public boolean checkNoBookmarkIconOnMintLoungeListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        if (isShowing &= mintLoungePageListOfBookmarkIcon.isEmpty()) {
            isShowing &= true;
            Utils.logStepInfo(true, "bookmark icon not displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "bookmark icon is displayed *****failed*****");
        }
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        return isShowing;
    }

    @Override
    public boolean checkShareIconAllAvailableOptionOnMintLoungeListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        commonFunctions.clickElement(mintLoungePageListOfShareIcon.get(1), 10, "first story share icon");
        isShowing &= shareIconAllAvailableOption();
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        return isShowing;
    }

    private boolean shareIconAllAvailableOption() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(mintLoungePageListOfShareOption, 10, "share all available option popup");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageShareOptionAirDrop, 10, "AirDrop option");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageShareOptionMessage, 10, "Message option");
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageShareOptionMore, 10, "More option");
        commonFunctions.clickElement(mintLoungePageShareOptionCloseButton, 10, "cross icon");
        return isShowing;
    }

    @Override
    public boolean checkAdsOnListingPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        commonFunctions.isElementNotDisplayed(firstAdsRemoveAdButton, 10, "Ads");
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailPage() {
        boolean isShowing;
        isShowing = checkMintLoungeVewAllFunctionality();
        isShowing &= commonFunctions.isElementDisplayed(mintLoungePageListOfStory.get(2), 10, "first listing story");
        commonFunctions.clickElement(mintLoungePageListOfStory.get(2), 10, "first listing story");
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story detail page headline");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailPageShareFunctionality() {
        boolean isShowing;
        isShowing = checkStoryDetailPage();
        commonFunctions.checkElementVisibilityByScrolling(storyDetailPageShareIcon,"share icon");
        commonFunctions.clickElement(storyDetailPageShareIcon, 10, "share icon");
        isShowing &= shareIconAllAvailableOption();
        commonFunctions.clickElement(backButton, 10, "back button story detail page page");
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        return isShowing;
    }

    @Override
    public boolean checkStoryDetailPageFontSize() {
        boolean isShowing;
        isShowing = checkStoryDetailPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(storyDetailPageSizeIcon, "size icon");
        commonFunctions.clickElement(backButton, 10, "back button story detail page page");
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        return isShowing;
    }

}



