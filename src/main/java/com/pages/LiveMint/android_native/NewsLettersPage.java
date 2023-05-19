package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonNewsLettersPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsLettersPage extends CommonNewsLettersPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreMenuButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    private static MobileElement technologyButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement technologyTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitleExplore")
    private static MobileElement explorePageTitle;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_privacy")
    private static MobileElement explorePagePrivacyPolicy;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> technologyPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brand Stories']")
    private static MobileElement brandStoriesButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NewsLetters']")
    private static MobileElement newsLetters;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView[2]")
    private static MobileElement subscribePaidNewsLetterButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private static MobileElement privacyPolicyPageHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quick Reads']")
    private static MobileElement quickReadsButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement quickReadStory;
    @AndroidFindBy(id = "com.htmedia.mint:id/newsletter_heading_tv")
    private static MobileElement newsLetterPageHeader;
    @AndroidFindBy(id = "com.htmedia.mint:id/logo_newsletter")
    private static MobileElement newsLettersLogo;
    @AndroidFindBy(id = "com.htmedia.mint:id/newsletter_free_title")
    private static MobileElement freeNewsLetters;
    @AndroidFindBy(id = "com.htmedia.mint:id/newsletter_paid_title")
    private static MobileElement subscribersOnlyNewsLetters;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_privacy")
    private static MobileElement privacyPolicyNewsLettersPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/preview")
    private static MobileElement newsLetterPreview;
    @AndroidFindBy(id = "com.htmedia.mint:id/newsletter_paid_title")
    private static MobileElement paidNewsLetter;
    @AndroidFindBy(id = "com.htmedia.mint:id/login_heading_tv")
    private static MobileElement loginPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtUnsubscribe")
    private static MobileElement unsubscribeNewsLetterButton;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Plain Facts']")
    private static MobileElement paidNewsLetterSecond;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView[2]")
    private static MobileElement subscribeFreeNewsLetterButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Subscribed']")
    private static MobileElement subscribedTag;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NewsLetter']")
    private static MobileElement previewHeader;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brand Post']")
    private static MobileElement brandPostButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top of the Morning']")
    private static MobileElement freeNewsLetterFirstOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ticker']")
    private static MobileElement freeNewsLetterSecondOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Company Outsider']")
    private static MobileElement freeNewsLetterThirdOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Crypto Notes']")
    private static MobileElement freeNewsLetterFourthOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Easynomics']")
    private static MobileElement freeNewsLetterFifthOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saturday Feeling']")
    private static MobileElement freeNewsLetterSixthOption;
    @AndroidFindBy(id = "com.htmedia.mint:id/ll_paid_list")
    private static MobileElement subscribeNewsLetterFirstOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Monday']")
    private static MobileElement subscribeNewsLetterSecondOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tuesday']")
    private static MobileElement subscribeNewsLetterThirdOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wednesday']")
    private static MobileElement subscribeNewsLetterFourthOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Friday']")
    private static MobileElement subscribeNewsLetterFifthOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sunday']")
    private static MobileElement subscribeNewsLetterSixthOption;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView[1]")
    private static MobileElement editorsChoice;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_topic")
    private static MobileElement anotherSearchPageHeadline;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']")
    private static MobileElement videosSection;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VIDEOS']")
    private static MobileElement videoPageTitle;
    @AndroidFindBy(className = "android.widget.Button")
    private static List<MobileElement> allowDontAllow;
    @FindBy(id = "com.htmedia.mint:id/txtViewTitleExplore")
    private static MobileElement explorePageText;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @FindBy(xpath = "//android.widget.TextView[@text='NEWSLETTERS']")
    private static MobileElement newsLetterCarousel;
    @FindBy(xpath = "//android.widget.TextView[@text='NEWSLETTERS']/following-sibling::*[@text='View All']")
    private static MobileElement newsLetterCarouselViewAll;
    @FindBy(xpath = "//android.widget.TextView[@text='NEWSLETTERS']/ancestor::*[@resource-id='com.htmedia.mint:id/header_layout']")
    private static MobileElement newsLetterCarouselSection;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/bottomCard']")
    private static List<MobileElement> newsLetterType;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY-FRIDAY']")
    private static MobileElement newsLetterTypeMondayToFriday;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']")
    private static MobileElement newsLetterTypeMonday;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/imgViewHeader_inner_collection']")
    private static List<MobileElement> newsLetterImage;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/iv_premium']")
    private static List<MobileElement> newsLetterFreeTag;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/txtHeading']")
    private static List<MobileElement> newsLetterHeadline;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/txtDes']")
    private static List<MobileElement> newsLetterDes;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/preview']")
    private static List<MobileElement> newsLetterReadButton;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/txtSubscribe']")
    private static List<MobileElement> newsLetterSubscribeButton;
    @FindBy(id = "com.htmedia.mint:id/newsletter_heading_tv")
    private static MobileElement newsLetterPage;
    @FindBy(xpath = "//android.widget.TextView[@text='NewsLetter']")
    private static MobileElement newsLetterPageWebView;
    @FindBy(id = "com.htmedia.mint:id/subscribe")
    private static MobileElement newLetterSubscribedTag;
    @FindBy(xpath = "(//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/txtSubscribe'])[1]")
    private static MobileElement newLetterFirstSubscribedTag;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/iv_premium'][1]")
    private static MobileElement newsLetterSecondFreeTag;
    @FindBy(xpath = "//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/iv_premium'][2]")
    private static MobileElement newsLetterFirstFreeTag;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreHamburger;
    @FindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @FindBy(xpath = "//*[@text='Unsubscribe']")
    private static List<MobileElement> unSubscribedTagNewsletter;
    @FindBy(xpath = "(//android.widget.TextView[@text='MONDAY']/preceding::*[@resource-id='com.htmedia.mint:id/preview'])[1]")
    private static MobileElement newsLetterFirstReadButton;
    @FindBy(id = "com.htmedia.mint:id/txt_choose_plan")
    private static MobileElement chosePlan;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/iv_premium']")
    private static List<MobileElement> newsLetterPremiumTag;

    public NewsLettersPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
    }


    @Override
    public boolean checkNewsLetterFunctionality() {
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        boolean isShowing = commonFunctions.isElementDisplayed(newsLettersLogo, 10, "News Letter page logo");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPageHeader, 10, "News Letter Page Top Info");
        commonFunctions.isElementDisplayed(freeNewsLetters, 10, "Free Users News Letters");
        commonFunctions.scrollUntilElementFound(subscribersOnlyNewsLetters);
        isShowing &= commonFunctions.isElementDisplayed(subscribersOnlyNewsLetters, 10, "Subscribers Only News Letters");
        doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkFirstNewsLettersOption() {
        boolean isOptionsDisplayed;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        commonFunctions.isElementDisplayed(freeNewsLetters, 10, "Free Users News Letters");
        isOptionsDisplayed = commonFunctions.isElementDisplayed(freeNewsLetterFirstOption, 10, "Top of the morning");
        isOptionsDisplayed &= commonFunctions.isElementDisplayed(freeNewsLetterSecondOption, 10, "Ticker");
        commonFunctions.scrollUntilElementFound(freeNewsLetterThirdOption);
        isOptionsDisplayed &= commonFunctions.isElementDisplayed(freeNewsLetterThirdOption, 10, "Company Outsider");
        commonFunctions.scrollUntilElementFound(freeNewsLetterFourthOption);
        isOptionsDisplayed &= commonFunctions.isElementDisplayed(freeNewsLetterFourthOption, 10, "Crypto Notes");
        commonFunctions.scrollUntilElementFound(freeNewsLetterFifthOption);
        isOptionsDisplayed &= commonFunctions.isElementDisplayed(freeNewsLetterFifthOption, 10, "Easynomics");
        commonFunctions.scrollUntilElementFound(freeNewsLetterSixthOption);
        isOptionsDisplayed &= commonFunctions.isElementDisplayed(freeNewsLetterSixthOption, 10, "Saturday Feeling");
        commonFunctions.pressAndroidBackKey();
        return isOptionsDisplayed;
    }

    @Override
    public boolean checkFreeNewsLettersTypes() {
        boolean isSubscribeOptionsDisplayed = true;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        commonFunctions.isElementDisplayed(freeNewsLetters, 10, "Free Users News Letters");
        commonFunctions.scrollUntilElementFound(subscribeNewsLetterFirstOption);
        isSubscribeOptionsDisplayed &= commonFunctions.isElementDisplayed(subscribeNewsLetterFirstOption, 10, "Monday-Friday Subscribe Option");
        isSubscribeOptionsDisplayed &= commonFunctions.isElementDisplayed(subscribeNewsLetterSecondOption, 10, "Monday Subscribe Option");
        commonFunctions.scrollUntilElementFound(subscribeNewsLetterThirdOption);
        isSubscribeOptionsDisplayed &= commonFunctions.isElementDisplayed(subscribeNewsLetterThirdOption, 10, "Tuesday Subscribe Option");
        commonFunctions.scrollUntilElementFound(subscribeNewsLetterFourthOption);
        isSubscribeOptionsDisplayed &= commonFunctions.isElementDisplayed(subscribeNewsLetterFourthOption, 10, "Wednesday Subscribe Option");
        commonFunctions.scrollUntilElementFound(subscribeNewsLetterFifthOption);
        isSubscribeOptionsDisplayed &= commonFunctions.isElementDisplayed(subscribeNewsLetterFifthOption, 10, "Friday Subscribe Option");
        commonFunctions.scrollUntilElementFound(subscribeNewsLetterSixthOption);
        isSubscribeOptionsDisplayed &= commonFunctions.isElementDisplayed(subscribeNewsLetterSixthOption, 10, "Saturday Subscribe Option");
        doubleBackToHomePage();
        return isSubscribeOptionsDisplayed;
    }

    @Override
    public boolean checkPreviewFunctionality() {
        boolean isPreviewWorking;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        commonFunctions.isElementDisplayed(freeNewsLetters, 10, "Free Users News Letters");
        commonFunctions.isElementEnabled(freeNewsLetterFirstOption, 10, "Free First News Letter");
        commonFunctions.clickElement(newsLetterPreview, 10, "Free First News Letter Preview Option");
        commonFunctions.isElementDisplayed(previewHeader, 10, "Preview window header");
        commonFunctions.navigateBack();
        commonFunctions.scrollDownToElement(subscribeNewsLetterFirstOption);
        commonFunctions.clickElement(newsLetterPreview, 10, "Free Subscribers Only News Letter Preview Option");
        isPreviewWorking = commonFunctions.isElementDisplayed(previewHeader, 10, "Preview window header");
        commonFunctions.dummyWait(5);
        commonFunctions.navigateBack();
        doubleBackToHomePage();;
        return isPreviewWorking;
    }

    @Override
    public boolean checkLoginPopUpForSubscribeFreeNewsLetters() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        commonFunctions.isElementDisplayed(freeNewsLetters, 10, "Free Users News Letters");
        commonFunctions.clickElement(subscribeFreeNewsLetterButton, 10, "subscribed FreeNewsLetter Button");
        isShowing = commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        commonFunctions.dummyWait(5);
        commonFunctions.navigateBack();
        doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkLoginPopUpForSubscribePaidNewsLetters() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(paidNewsLetter, "PaidNewsLetter");
        commonFunctions.clickElement(subscribePaidNewsLetterButton, 10, "subscribe PaidNewsLetter Button");
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        commonFunctions.dummyWait(5);
        commonFunctions.navigateBack();
        doubleBackToHomePage();;
        return isShowing;
    }

    @Override
    public boolean checkPlanPageForPaidNewsLettersSubscribeButton() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(paidNewsLetter, "PaidNewsLetter");
        commonFunctions.clickElement(subscribePaidNewsLetterButton, 10, "subscribe PaidNewsLetter Button");
        isShowing &= commonFunctions.isElementDisplayed(chosePlan, 10, "plan page");
        commonFunctions.dummyWait(5);
        commonFunctions.navigateBack();
        doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagForFreeNewsLetters() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        commonFunctions.isElementDisplayed(freeNewsLetters, 10, "Free Users News Letters");
        commonFunctions.clickElement(subscribeFreeNewsLetterButton, 10, "subscribe FreeNewsLetter Button");
        isShowing = commonFunctions.isElementDisplayed(subscribedTag, 10, "subscribed Tag Free News Letters");
        isShowing &= commonFunctions.clickElement(unsubscribeNewsLetterButton, 10, "unsubscribe FreeNewsLetter Button");
        isShowing &= commonFunctions.isElementDisplayed(subscribeFreeNewsLetterButton, 10, "subscribe FreeNewsLetter Button");
        doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagForPaidNewsLetters() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "HomePage Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        commonFunctions.checkElementVisibilityByScrolling(paidNewsLetterSecond, "PaidNewsLetter");
        commonFunctions.clickElement(subscribePaidNewsLetterButton, 10, "subscribe PaidNewsLetter Button");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(subscribedTag, "subscribed Tag PaidNewsLetter Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(unsubscribeNewsLetterButton, "unSubscribe Tag Paid News Letters");
        commonFunctions.clickElement(unsubscribeNewsLetterButton, 10, "click again for unsubscribe");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "subscribe button Paid news letters");
        doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkPrivacyPolicyNewsLetters() {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home Button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Button");
        commonFunctions.clickElement(newsLetters, 10, "NewsLetter Page");
        commonFunctions.checkElementVisibilityByScrolling(editorsChoice, "Editor's Choice");
        commonFunctions.checkElementVisibilityByScrolling(explorePagePrivacyPolicy, "Privacy Policy Button");
        commonFunctions.scrollDownToElement(explorePagePrivacyPolicy,1);
        commonFunctions.clickByCoordinates(620, 1975);
        isShowing = commonFunctions.isElementDisplayed(privacyPolicyPageHeader, 10, "Privacy Policy Page Header");
        commonFunctions.dummyWait(5);
        commonFunctions.navigateBack();
        doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagForPaidAndFreeNewsLetters() {
        return false;
    }

    @Override
    public boolean checkNoSubscribedNewsLettersIsShowing() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagAndUnSubscribedPaidAndFreeNewsLetters() {
        return false;
    }

    @Override
    public boolean checkNewsletterPageLayout() {
        return false;
    }

    @Override
    public boolean checkNewsletterPageLayoutForSubscribedUsers() {
        return false;
    }

    public boolean checkNewslettersTopNav() {
        return false;
    }

    public boolean checkRHSOnNewslettersSubscribedUsers() {
        return false;
    }

    public boolean checkLHSOnNewslettersPage() {
        return false;
    }

    public boolean checkEasynomicsOnNewslettersPage() {
        return false;
    }

    public boolean checkCryptoNotesOnNewslettersPage() {
        return false;
    }

    public boolean checkCompanyOutsiderOnNewslettersPage() {
        return false;
    }

    public boolean checkTickerOnNewslettersPage() {
        return false;
    }

    public boolean checkSaturdayFeelingOnNewslettersPage() {
        return false;
    }

    public boolean checkEditorChoiceOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }

    public boolean checkMintMoneyOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }


    public boolean checkMintTechOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }

    public boolean checkMintPrimerOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }

    public boolean checkTOTMOnNewslettersPage() {
        return false;
    }

    public boolean checkPlainsFactOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }

    public boolean checkMarkToMarketOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }

    public boolean checkTwichOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }

    @Override
    public boolean checkLikeShareSuscribeOnNewslettersPageForSubscriberOnlyNewsletters() {
        return false;
    }

    @Override
    public boolean previewUrlValidation(WebElement element, String title) {
        return false;
    }

    private boolean newsLetterCarouselOnHomePage() {
        boolean isShowing;
        if (!commonFunctions.isElementDisplayedAndPresent(newsLetterCarouselSection, 5, "newsLetter section")) {
            commonFunctions.clickElement(homeButton, 10, "home tab");
            commonFunctions.scrollToElementDown(newsLetterCarouselSection);
            commonFunctions.checkElementVisibilityByScrolling(newsLetterCarouselSection,"newsletters carousel");
        }
        commonFunctions.dummyWait(3);
        isShowing =  commonFunctions.scrollDownToElement(newLetterFirstSubscribedTag,1);
        return isShowing;
    }

    @Override
    public boolean checkNewsLetterCarouselTitleOnHomePage() {
        return newsLetterCarouselOnHomePage();
    }

    @Override
    public boolean checkNewsLetterViewAllButton() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(newsLetterCarouselViewAll, 10, "newsLetter ViewAll");
        return isShowing;
    }

    @Override
    public boolean checkNewsletterCardDesign() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(newsLetterTypeMondayToFriday, 10, "monday-Friday");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterTypeMonday, 10, "Monday");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterImage.get(0), 10, "first card image");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterImage.get(1), 10, "second card image");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterFreeTag.get(0), 10, "first free tag");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterFreeTag.get(1), 10, "second free tag");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterHeadline.get(0), 10, "first title headline");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterHeadline.get(1), 10, "second title headline");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterDes.get(0), 10, "first description");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterDes.get(1), 10, "second description");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterReadButton.get(0), 10, "first Read button");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterReadButton.get(1), 10, "second Read button");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterSubscribeButton.get(0), 10, "first subscribe button");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterSubscribeButton.get(1), 10, "second subscribe button");
        return isShowing;
    }

    @Override
    public boolean checkNewsLetterViewAllFunctionality() {
        boolean isShowing;
        isShowing = checkNewsLetterViewAllButton();
        commonFunctions.clickElement(newsLetterCarouselViewAll, 10, "view all");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPage, 10, "newLetters Page");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkNewsletterSubscribeButton() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(newLetterFirstSubscribedTag,"first subscribe button");
        return isShowing;
    }

    @Override
    public boolean checkNewsletterReadButtonAndFunctionality() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(newsLetterReadButton.get(0), 10, "first Read button");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterReadButton.get(1), 10, "second Read button");
        commonFunctions.clickElement(newsLetterReadButton.get(0), 10, "first Read button");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPageWebView, 10, "newsletter web view");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkNewsletterFreeTag() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(newsLetterFreeTag.get(0), 10, "first free tag");
        return isShowing;
    }

    private boolean clickOnSubscribeButton() {
        boolean isShowing;
        isShowing = checkNewsletterSubscribeButton();
        commonFunctions.clickElement(newsLetterSubscribeButton.get(0), 10, "first subscribe button");
        return isShowing;
    }

    @Override
    public boolean checkFreeNewsLetterSubscribeByNonLoggedInUser() {
        boolean isShowing;
        isShowing = clickOnSubscribeButton();
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        commonFunctions.navigateBack();
        commonFunctions.clickElement(homeButton,10,"home tab");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagByClickingOnSubscribeButton() {
        boolean isShowing;
        isShowing = clickOnSubscribeButton();
        if (!commonFunctions.isElementDisplayedAndPresent(newLetterSubscribedTag, 5, "subscribed tag")) {
            commonFunctions.clickElement(homeButton, 10, "home tab");
            isShowing &= commonFunctions.checkElementVisibilityByScrolling(newLetterSubscribedTag, "subscribed tag");
        }
        commonFunctions.clickElement(homeButton,10,"home button");
        return isShowing;
    }
    @Override
    public boolean checkFreeSubscriptionFlowInCaseOfNonLoggedInUsers() {
        return false;
    }

    @Override
    public boolean checkSwipeFunctionality() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        commonFunctions.checkElementVisibilityByScrolling(newsLetterSecondFreeTag,"subscribe tag");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(newsLetterFreeTag,1,"second free tag");
        int FirstEle[] = commonFunctions.getListOfElementXYCoordinate(newsLetterFreeTag,0,"first Free tag");
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], FirstEle[0], FirstEle[1]);
        commonFunctions.swipeElementUsingTouchAction(FirstEle[0], FirstEle[1],secondEle[0], secondEle[1]);
        return isShowing;
    }
    @Override
    public boolean checkRHSOnNewslettersPage() {
        return false;
    }
    @Override
    public boolean checkPreviewLinkOnNewslettersPage(){return false;}
    public boolean checkFreeNewsLetterSubscriptionByNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkPaidNewsLetterSubscriptionByNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagAndClickOnUnsubscribed() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        commonFunctions.clickElement(newsLetters, 10, "News Letters Section");
        isShowing = commonFunctions.isElementDisplayed(newsLettersLogo, 10, "News Letter page logo");
        commonFunctions.swipeElementUsingTouchAction(455, 1902, 508, 1309);
        if (unSubscribedTagNewsletter.size() != 0) {
            commonFunctions.clickElementIfDisplayed(unSubscribedTagNewsletter.get(0), 5, "1 UnSubscribed tag");
            commonFunctions.dummyWait(10);
            commonFunctions.clickElementIfDisplayed(unSubscribedTagNewsletter.get(0), 10, "2 UnSubscribed tag");
        }
        doubleBackToHomePage();
        return isShowing;
    }

    public void doubleBackToHomePage(){
        commonFunctions.dummyWait(5);
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(5);
        commonFunctions.navigateBack();
    }

    @Override
    public boolean checkPremiumTag() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        commonFunctions.checkElementVisibilityByScrolling(newsLetterSecondFreeTag, "subscribe tag");
        int secondEle0[] = commonFunctions.getListOfElementXYCoordinate(newsLetterFreeTag, 1, "second free tag");
        int FirstEle0[] = commonFunctions.getListOfElementXYCoordinate(newsLetterFreeTag, 0, "first Free tag");
        commonFunctions.swipeElementUsingTouchAction(secondEle0[0], secondEle0[1], FirstEle0[0], FirstEle0[1]);
        for (int i = 0; i < 8; i++) {
            int secondEle[] = commonFunctions.getListOfElementXYCoordinate(newsLetterFreeTag, 1, "second free tag");
            int FirstEle[] = commonFunctions.getListOfElementXYCoordinate(newsLetterFreeTag, 0, "first Free tag");
            commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], FirstEle[0], FirstEle[1]);
        }
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPremiumTag.get(1), 2, "Newsletter type: Premium");
        return isShowing;
    }
}

