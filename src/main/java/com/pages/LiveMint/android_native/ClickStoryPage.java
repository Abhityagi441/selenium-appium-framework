package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonClickStoryPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickStoryPage extends CommonClickStoryPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvNo")
    private static MobileElement noButton;
    @AndroidFindBy(accessibility = "Home")
    private static MobileElement homeButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewHeader")
    private static MobileElement firstStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/collection_viewall")
    private static MobileElement seeAllIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvClickHereHeader")
    private static MobileElement removeAdOption;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    private static MobileElement firstPremiumStory;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='back']")
    private static MobileElement navigateBackToHomePage;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/more_stories_heading']")
    private static MobileElement moreStoriesSectionOnDetailPage;
    @AndroidFindBy(id ="com.htmedia.mint:id/collection_viewall")
    private static MobileElement premiumViewAllOption;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgWsjLogo")
    private static MobileElement wsjCrousel;
    @AndroidFindBy(xpath = "//*[@text='FROM THE WALL STREET JOURNAL']/following-sibling::*[@text='View All']")
    private static MobileElement wsjSeeAllIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement wsjStoryPageHeader;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MINT PREMIUM']")
    private static MobileElement premiumStoryCrousel;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement premiumStoryPageHeader;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement mintLoungeCrousel;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView")
    private static MobileElement firstLoungeStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnSubscribe")
    private static MobileElement premiumCollectOfferButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mint Lounge\"]/android.widget.Image")
    private static MobileElement mintLoungeTitle;
    @AndroidFindBy(id = "com.htmedia.mint:id/imgViewDetailListenBottom")
    private static MobileElement textToSpeechButton;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/imgViewBookmark']")
    private static MobileElement storyBookmarkIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement choosePlansHeader;
    @FindBy(xpath = "//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;


    public ClickStoryPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }


    @Override
    public boolean checkStoryPage() {
        boolean isStoryScrollableTrue=true;
        commonFunctions.clickElementIfDisplayed(yesIAmInButton, 10, "Yes I am in button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad Close Button");
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(firstStory, 10, "First story");
        commonFunctions.scrollDownToElement(seeAllIcon);
        isStoryScrollableTrue=commonFunctions.isElementDisplayed(seeAllIcon, 10, "See All Icon");


        return isStoryScrollableTrue;
    }

    @Override
    public boolean checkSectionPage() {
        boolean isSectionPageLoad;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(firstStory, 10, "First story");
        commonFunctions.dummyWait(3);
        commonFunctions.clickByCoordinates(339,152);
        commonFunctions.dummyWait(3);
        commonFunctions.checkElementVisibilityByScrolling(moreStoriesSectionOnDetailPage,"view all");
        commonFunctions.clickElement(seeAllIcon,10, "See All Button");
        isSectionPageLoad = commonFunctions.isElementDisplayed(storyBookmarkIcon,10,"Section First Headline");
        return isSectionPageLoad;
    }

    @Override
    public boolean checkNavigationToPremiumListedStory() {
        boolean isPremiumListedStoryLoad=true;
        commonFunctions.clickElementIfDisplayed(yesIAmInButton, 10, "Yes I am in Button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad Close Button");
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.scrollDownToElement(firstPremiumStory);
        commonFunctions.clickElement(firstPremiumStory,10,"First Premium Story");
        commonFunctions.scrollDownToElement(premiumCollectOfferButton);
        isPremiumListedStoryLoad = commonFunctions.isElementDisplayed(premiumCollectOfferButton,10,"Choose A Plan Header");

        return isPremiumListedStoryLoad;
    }




    @Override
    public boolean checkNavigationToPremiumViewAll() {
        boolean isPremiumViewAllLoad;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.scrollDownToElement(firstPremiumStory);
        commonFunctions.clickElement(premiumViewAllOption,10,"Premium Story View All Option");
        isPremiumViewAllLoad = commonFunctions.isElementDisplayed(premiumStoryPageHeader,10,"Premium StoryPage Header");
        return isPremiumViewAllLoad;
    }

    @Override
    public boolean checkNavigationToWsjViewAll() {
        boolean isWsjViewAllLoad;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.scrollDownSlowToElement(wsjSeeAllIcon,10);
        commonFunctions.clickElement(wsjSeeAllIcon,10,"WSJ View All Option");
        commonFunctions.isElementDisplayed(wsjStoryPageHeader,10,"WSJ StoryPage Header");
        isWsjViewAllLoad = commonFunctions.checkElementText(wsjStoryPageHeader, "WSJ", 10, "WSJ StoryPage Header");
       commonFunctions.navigateBack();
        return isWsjViewAllLoad;
    }

    @Override
    public boolean checkRemoveAdOption() {
        boolean isRemoveAdOption;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.scrollUpToElementDisplayed(removeAdOption);
        commonFunctions.clickElement(removeAdOption, 10, "Click Here To Remove Ad Option");
        isRemoveAdOption = commonFunctions.isElementDisplayed(choosePlansHeader,10,"Premium StoryPage Header");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(navigateBackToHomePage, 10, "Navigate Back To HomePage");
        return isRemoveAdOption;
    }

    @Override
    public boolean checkNavigationToLoungeListedStory() {
        boolean isLoungeListedStoryLoad=true;
        commonFunctions.clickElementIfDisplayed(yesIAmInButton, 10, "Yes I am in Button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad Close Button");
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.scrollDownToElement(firstPremiumStory);
        commonFunctions.scrollDownToElement(mintLoungeCrousel);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(firstLoungeStory);
        commonFunctions.clickElement(firstLoungeStory,10,"First Mint Lounge Story");
        commonFunctions.dummyWait(5);
        isLoungeListedStoryLoad = commonFunctions.isElementDisplayed(mintLoungeTitle,10,"Mint Lounge Story Page");

        return isLoungeListedStoryLoad;
    }


    }