package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonPremiumStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PremiumStoryPage extends CommonPremiumStoryPage {
//    private IOSDriver driver;
    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    String expectedPlainText;

    @iOSXCUITFindBy(id = "captionID")
    private static MobileElement imageCaption;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'BSE SENSEX'`]")
    private static MobileElement marketSensex;

    @iOSXCUITFindBy(id = "S&P BSE SENSEX")
    private static MobileElement marketSensexLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'NIFTY 50'`]")
    private static MobileElement marketNifty;

    @iOSXCUITFindBy(id = "Nifty 50")
    private static MobileElement marketNiftyLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'NIFTY BANK'`]")
    private static MobileElement marketNiftyBank;

    @iOSXCUITFindBy(id = "Nifty Bank")
    private static MobileElement marketNiftyBankLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'BSE MIDCAP'`]")
    private static MobileElement marketBSEMidCap;

    @iOSXCUITFindBy(id = "S&P BSE Mid-Cap")
    private static MobileElement marketBSEMidCapLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'GOLD'`]")
    private static MobileElement marketGold;

    @iOSXCUITFindBy(id = "Gold")
    private static MobileElement marketGoldLanding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'SILVER'`]")
    private static MobileElement marketSilver;

    @iOSXCUITFindBy(id = "Silver")
    private static MobileElement marketSilverLanding;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
    private static MobileElement summary;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[4]")
    private static MobileElement summary2;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText")
    private static List<MobileElement> summaryList;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
    private static MobileElement saveButton;

    @iOSXCUITFindBy(id = "my profile cross")
    private static MobileElement closeIconInProfile;

    @FindBy(name = "My Account")
    private static MobileElement myAccountWithArrow;

    @FindBy(name = "Name")
    private static MobileElement nameEditProfile;

    @FindBy(name = "Email")
    private static MobileElement emailEditProfile;

    @FindBy(name = "Gender")
    private static MobileElement genderEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Edit Profile']")
    private static MobileElement editProfile;

    @FindBy(name = "Edit Profile")
    private static MobileElement editProfilePage;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement Name;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement Email;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement mobileNumber;

    @iOSXCUITFindBy(id = "com.htmedia.mint:id/close")
    private static MobileElement genderOption;

    @FindBy(id = "Logout")
    private static MobileElement logoutBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name='Logout']")
    private static MobileElement logoutPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private static MobileElement okBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Sign in'`][2]")
    private static MobileElement signInButton;

    @iOSXCUITFindBy(id = "Privacy Policy")
    private static MobileElement privacyPolicy;

    @iOSXCUITFindBy(id = "Terms of Use")
    private static MobileElement termsOfUse;

    @FindBy(id = "Cookie Policy")
    private static MobileElement cookiePolicy;

    @FindBy(id = "Subscriber Agreement")
    private static MobileElement subscriberAgreement;

    @iOSXCUITFindBy(id = "PRIVACY POLICY")
    private static MobileElement privacyPolicyLandingPage;

    @iOSXCUITFindBy(id = "TERMS OF USE")
    private static MobileElement termsOfUseLandingPage;

    @FindBy(id = "COOKIE POLICY")
    private static MobileElement cookiePolicyLandingPage;

    @FindBy(id = "SUBSCRIBER AGREEMENT")
    private static MobileElement subscriberAgreementLandingPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Subscribe Now']")
    private static MobileElement SubscribeNow;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name=='Back'`][2]")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement proceedWithoutAppleID;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell//XCUIElementTypeStaticText)[2]")
    private static MobileElement userNameMyAccount;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell//XCUIElementTypeStaticText)[3]")
    private static MobileElement userEmailMyAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeButton[4]")
    private static MobileElement editNameBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeButton[3]")
    private static MobileElement editGenderBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther//XCUIElementTypeTextField")
    private static MobileElement editPasswordField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='editPasswordButton'])[1]")
    private static MobileElement editPasswordBtn;

    @FindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeSecureTextField)[1]")
    private static MobileElement enterNewPass;

    @FindBy(xpath = "(//XCUIElementTypeOther//XCUIElementTypeSecureTextField)[2]")
    private static MobileElement enterConfirmPass;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Reset'`]")
    private static MobileElement resetPassword;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeTextField")
    private static MobileElement name;

    @iOSXCUITFindBy(id = "Add your Contact Number")
    private static MobileElement addYourContactNo;

    @FindBy(name = "editAddIcon")
    private static MobileElement editContactBtn;

    @FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Female')]")
    private static MobileElement femaleGenderRadioButton;

    @FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Male')]")
    private static MobileElement maleGenderRadioButton;

    @FindBy(id = "Female")
    private static MobileElement female;

    @FindBy(id = "Male")
    private static MobileElement male;

    @iOSXCUITFindBy(id = "Close")
    private static MobileElement closeStory;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'MTicker'`][1]")
    private static MobileElement marketTicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'MTicker'`]")
    private static List<MobileElement> marketTickerElementList;

    @iOSXCUITFindBy(id = "publishedID")
    private static MobileElement timestamp;

    @iOSXCUITFindBy(id = "Label")
    private static MobileElement firstStory;

    @iOSXCUITFindBy(id = "headlineID")
    private static MobileElement headline;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    private static MobileElement firstStoryInLandingPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    private static MobileElement firstStoryInPremium; //**/XCUIElementTypeStaticText[`label == ''`][7]

    @iOSXCUITFindBy(id = "To Continue Reading, Subscribe Now")
    private static MobileElement continueReadingSubscribeNow;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeStaticText)[2]")
    private static MobileElement firstStoryInSearchResults;

    @iOSXCUITFindBy(id = "exclusive_big")
    private static MobileElement premiumLabel;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == 'exclusive_big'`]")
    private static List<MobileElement> premiumLabelList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='headlineID']//following::XCUIElementTypeImage[1]")
    private static List<MobileElement> storyImageAfterTheTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Label']//preceding::XCUIElementTypeImage[1]")
    private static MobileElement storyImage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeImage")
    private static List<MobileElement> storyImageList;

    @iOSXCUITFindBy(id = "authorID")
    private static MobileElement storyAuthor;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Label'`][1]")
    private static  List<MobileElement> storySummary;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'bookmark'`][1]")
    private static MobileElement bookmarkIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'bookmark'`][1]")
    private static List<MobileElement> bookmarkIconList;

    @iOSXCUITFindBy(id = "My Reads")
    private static MobileElement myReadsMenu;

    @iOSXCUITFindBy(id = "bookmarksliderspace")
    private static MobileElement bookmarksSwiperBox;

    @FindBy(xpath = "//div[@id='bookmarksliderspace']//div[@id='swiper_b']//h2/a")
    private static List<MobileElement> bookmarksSwiperBoxElementsList;

    @iOSXCUITFindBy(id = "agree")
    private static MobileElement acceptCookie;

    @iOSXCUITFindBy(id = "Close")
    private static MobileElement closeButtonInShareOverlay;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Back'`][1]")
    private static MobileElement backInEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;

    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;

    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;

    @iOSXCUITFindBy(id = "Latest")
    private static MobileElement latest;

    @iOSXCUITFindBy(id = "LATEST")
    private static MobileElement latestLandingPage;

    @iOSXCUITFindBy(id = "Trending")
    private static MobileElement trending;

    @iOSXCUITFindBy(id = "TRENDING")
    private static MobileElement trendingLandingPage;

    @iOSXCUITFindBy(id = "Premium")
    private static MobileElement premium;

    @iOSXCUITFindBy(id = "PREMIUM")
    private static MobileElement premiumLandingPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement explore;

    @iOSXCUITFindBy(id = "notification")
    private static MobileElement notificationIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch")
    private static MobileElement notificationFlag;

    @iOSXCUITFindBy(id = "News")
    private static MobileElement news;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Markets']//following::XCUIElementTypeOther[2]")
    private static MobileElement marketsArrowBtn;

    @iOSXCUITFindBy(id = "Stock Markets")
    private static MobileElement stockMarkets;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='STOCK MARKETS']")
    private static MobileElement stockMarketsLandingPage;

    @iOSXCUITFindBy(id = "Search")
    private static MobileElement searchButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[2]")
    private static MobileElement searchTextField;

    @iOSXCUITFindBy(id = "TRENDING TOPICS")
    private static MobileElement trendingTopics;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    private static List<MobileElement> storiesList;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'share'`][1]")
    private static List<MobileElement> shareIconsList;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'share'`][1]")
    private static MobileElement shareIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == 'share'`][1]")
    private static MobileElement shareIconUnderStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TRENDING TOPICS']//following::XCUIElementTypeStaticText[2]")
    private static MobileElement storyInTopics;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == 'Messages'`]")
    private static MobileElement messagesIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == 'AirDrop'`]")
    private static MobileElement airDropIcon;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText/XCUIElementTypeOther[`label BEGINSWITH 'Plain Text'`]")
    private static MobileElement plainText;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == 'messageBodyField'`]")
    private static MobileElement messageBody;

    @iOSXCUITFindBy(id = "my profile cross")
    private static MobileElement closeEditProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement cancelButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'aa'`][1]")
    private static MobileElement textSizeSelection;

    @iOSXCUITFindBy(id = "Select Font Size")
    private static MobileElement sizeSelectionPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;

    @iOSXCUITFindBy(id = "viewAll")
    private static MobileElement mintPremiumSeeAll;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PREMIUM']")
    private static MobileElement premiumStoryPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='See All']")
    private static MobileElement seeMore;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Companies']")
    private static MobileElement companies;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COMPANIES']")
    private static MobileElement companiesLanding;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COMPANIES']")
    private static MobileElement landingPageSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='Mint']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeButton[1]")
    private static MobileElement textToSpeech;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COMPANIES']")
    private static MobileElement elapsedTime;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Advertisement'`]")
    private static MobileElement ads;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Remove Ad'`]")
    private static MobileElement removeAd;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'INSTALL'`]")
    private static MobileElement openAd;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`label == 'Revolut'`]")
    private static MobileElement getApp;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Done'`]")
    private static MobileElement done;

    @iOSXCUITFindBy(id = "viewAll")
    private static MobileElement firstStoryUnderSeeAll;

    @iOSXCUITFindBy(id = "storyHeadline")
    private static MobileElement storyHeadline;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'MINT PREMIUM'`][1]")
    private static MobileElement homePageMintPremium;
    @iOSXCUITFindBy(id = "banner cross")
    private static MobileElement mintPreTopCrossBanner;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;


    public PremiumStoryPage() {
        globalVars = GlobalVars.getInstance();
//        this.driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
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
    public boolean checkAdsRemovedPremiumPage() {
        boolean checkAdsRemovedPremiumPage;
        commonFunctions.clickElement(premium, 10, "Premium");
        commonFunctions.dummyWait(5);
        boolean checkListingPageStatus = commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium stories listing page");
        commonFunctions.tapElementWithCoOrdinates(150,180, "First story in the premium"); //Tap on the fist story in the premium
        commonFunctions.dummyWait(5);
        boolean adsStatusbottom = commonFunctions.isElementNotDisplayed(ads, 10,"Ads");
        commonFunctions.scrollToBottom();
        boolean adsStatustop = commonFunctions.isElementNotDisplayed(ads, 10,"Ads");
        commonFunctions.clickElement(back, 10, "Go back");
        commonFunctions.dummyWait(5);
        boolean checkBackToListingPageStatus = commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium stories listing page");
        if (checkListingPageStatus&&adsStatusbottom&&checkBackToListingPageStatus&&adsStatustop) {
            checkAdsRemovedPremiumPage = true;
        } else {
            checkAdsRemovedPremiumPage = false;
        }
        return checkAdsRemovedPremiumPage;
    }

    @Override
    public boolean checkAdsPresentPremiumPage() {
        boolean isShowing;
        commonFunctions.clickElement(premium, 10, "Premium");
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium stories listing page");
       commonFunctions.clickElementIfDisplayed(mintPreTopCrossBanner,10,"mint premium top small banner");
        commonFunctions.tapElementWithCoOrdinates(150,180, "First story in the premium"); //Tap on the fist story in the premium
        commonFunctions.dummyWait(5);
        //boolean premiumStoryDetailOpenStatus = commonFunctions.isElementDisplayed(closeStory, 10, "Premium story detail page");
        commonFunctions.scrollToBottom();
        //commonFunctions.scrollToTop();
        commonFunctions.scrollUpUntilElementFound(ads);
        isShowing &= commonFunctions.isElementDisplayed(ads, 10);
        commonFunctions.clickElement(back, 10, "Go back");
        commonFunctions.clickElementIfDisplayed(closeStory, 10, "Go back");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium stories listing page");
        return isShowing;
    }

    @Override
    public boolean checkAdsRedirection() {
        boolean checkAdsRedirectionStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(removeAd, 10, "Top Ad");
        commonFunctions.clickElement(openAd, 10, "Open Ad");
        commonFunctions.dummyWait(5);
        checkAdsRedirectionStatus = commonFunctions.isElementDisplayed(getApp, 10, "Ad page");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(done, 10, "Go back");
        return checkAdsRedirectionStatus;
    }

    @Override
    public boolean storyPageTextSizeSelection() {
        boolean storyPageStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.clickElement(firstStory, 10, "Story");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUntilElementFound(textSizeSelection);
        commonFunctions.clickElement(textSizeSelection, 10, "textSizeSelection");
        boolean checkPopUpStatus = commonFunctions.isElementDisplayed(sizeSelectionPopUp, 10, "sizeSelectionPopUp");
        commonFunctions.clickByCoordinates(100,100);
        if (checkPopUpStatus) {
            storyPageStatus = true;
        } else {
            storyPageStatus = false;
        }
        return storyPageStatus;
    }

    @Override
   public boolean moreFromSectionWidget() {
        boolean moreFromSectionWidgetStatus;
        //boolean premiumLabelStatus;
        commonFunctions.clickElement(home, 10, "Home");
       commonFunctions.clickElement(explore, 10, "Explore");
       commonFunctions.dummyWait(5);
       commonFunctions.clickElement(companies, 10, "Companies");
       commonFunctions.dummyWait(5);
        commonFunctions.clickElement(firstStory, 10, "Open Story");
        commonFunctions.waitForPageLoading(10);
       String sectionName = commonFunctions.getElementText(landingPageSection,10);
        commonFunctions.scrollUntilElementFound(seeMore);

        commonFunctions.clickElement(seeMore, 10, "See More");
        commonFunctions.waitForPageLoading(10);
        moreFromSectionWidgetStatus=checkLandingPage(landingPageSection,sectionName,10);
        commonFunctions.clickElement(home, 10, "Home");

        return moreFromSectionWidgetStatus;
    }

    @Override
    public boolean checkStory() {
        return false;
    }


    @Override
    public boolean mintPremiumWidget(String email, String password, String mintPrimiumText) {
        boolean mintPremiumWidgetStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(premium, 10, "Premium");
        commonFunctions.clickElement(premium, 10, "Premium");
       commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium Landing page");
        commonFunctions.tapElementWithCoOrdinates(150,180, "First story in the premium"); //Tap on the fist story in the premium
        commonFunctions.waitForPageLoading(10);
        commonFunctions.scrollUntilElementFound(mintPremiumSeeAll);
        commonFunctions.clickElement(mintPremiumSeeAll, 10, "Mint Premium SeeAll");
        mintPremiumWidgetStatus=checkLandingPage(premiumLandingPage, "PREMIUM", 10);
        commonFunctions.clickElement(back, 10, "Back to Home");

        return mintPremiumWidgetStatus;
    }

    @Override
    public boolean checkPageSwitching(String email, String password, String premiumText) {
        boolean isShowing;
        commonFunctions.clickElement(premium, 10, "Premium tab");
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium stories listing page");
        commonFunctions.tapElementWithCoOrdinates(150, 180, "First story in the premium"); //Tap on the fist story in the premium
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(back, 10, "Back to Explore Menu");
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.dummyWait(5);
        if (globalVars.isProdRun()) {
            isShowing &= commonFunctions.isElementDisplayed(firstStory,10,"home page first story");}
            if (globalVars.isStgRun()) {
            isShowing &= commonFunctions.isElementDisplayed(homePageMintPremium, 10, "Home page");}
        commonFunctions.clickElement(premium, 10, "Premium");
        commonFunctions.clickElement(premium, 10, "Premium");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium Landing page");
        return isShowing;
    }

    @Override
    public boolean checkNoPayWallToSubscribedUser(String email, String password) {
        return false;
    }

    @Override
    public boolean mintPremiumWidgetListingStory() {
        boolean mintPremiumWidgetListingStoryStatus;
        commonFunctions.clickElement(home, 10, "Home");
        commonFunctions.isElementDisplayed(premium, 10, "Premium");
        commonFunctions.clickElement(premium, 10, "Premium");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium Landing page");
        commonFunctions.tapElementWithCoOrdinates(150,180, "First story in the premium"); //Tap on the fist story in the premium
        commonFunctions.waitForPageLoading(10);
        commonFunctions.scrollUntilElementFound(mintPremiumSeeAll);
        String storyBeforeRedirection = commonFunctions.getElementText(firstStoryUnderSeeAll);
        commonFunctions.clickElement(firstStoryUnderSeeAll, 10, "First Story Mint Premium SeeAll");
        String storyAfterRedirection = commonFunctions.getElementText(storyHeadline);
        mintPremiumWidgetListingStoryStatus=commonFunctions.checkTextNotEquals(storyBeforeRedirection,storyAfterRedirection,"Story");
        commonFunctions.clickElement(back, 10, "Back to Home");

        return mintPremiumWidgetListingStoryStatus;
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
/*

   public boolean checkTextToSpeech() {
        boolean isAudioPlayButton = false;
        boolean isAudioElapsedTime = false;
        try {
            commonFunctions.clickElement(home, 10, "Home");
            commonFunctions.clickElement(firstStory, 10, "Story");
            commonFunctions.dummyWait(5);
            commonFunctions.scrollUntilElementFound(textToSpeech);
            commonFunctions.clickElement(textToSpeech, 10, "Text To Speech");
            commonFunctions.dummyWait(5);
            */
/*commonFunctions.scrollToElementView(checkBookMark, 10, "checkBookMark");
            commonFunctions.scrollToElementView(firstVideobox, 10, "firstVideobox");
            commonFunctions.switchToFrame(videoIframe, 10);
            */

    @Override
    public boolean subscribedUserAdsFreePremiumListingPage() {
        return false;
    }
    @Override
    public boolean subscribedUserAdsFreePremiumStoryDetailPage() {
        return false;
    }

    @Override
    public boolean nonSubscribedUserAdsFreePremiumListingPage() {return false;}

    @Override
    public boolean checkBackButton() {
        boolean isShowing;
        commonFunctions.clickElement(premium, 10, "premium page");
        isShowing = commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium Landing page");
        commonFunctions.tapElementWithCoOrdinates(150, 176, "First story in the premium");
        commonFunctions.clickElement(back, 10, "Go back");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(premiumLandingPage, 10, "Premium Landing page");
        return isShowing;
    }

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
        return false;
    }

    @Override
    public boolean checkPremiumStickerPresentOnStoryDetailPage() {
        return false;
    }

    @Override
    public boolean checkPremiumStickerDisappearOnStoryDetailPage() {
        return false;
    }

    @Override
    public boolean checkSubscribedBtnNotDisplayedOnPaywall() {
        return false;
    }

    @Override
    public boolean checkNoPaywall() {
        return false;
    }

    @Override
    public boolean checkSignInFromFreemium() {
        return false;
    }

    @Override
    public boolean checkNoPaywallAndAdsForSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkPaywallAndAds() {
        return false;
    }

    @Override
    public boolean clickOnSignInFromPaywall() {
        return false;
    }

    @Override
    public boolean checkPaywallForPremiumStories() {
        return false;
    }
    /*

            String str = elapsedTime.getText();
            String getText[] = str.split(":");
            String time = getText[1];
            System.out.println("elapsed time" + time);
            int timeDuration = Integer.parseInt(time);
            if (timeDuration > 4) {
                isAudioElapsedTime = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  isAudioPlayButton && isAudioElapsedTime;
    }

*/



}