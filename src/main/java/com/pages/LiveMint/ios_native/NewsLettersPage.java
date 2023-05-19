package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonNewsLettersPage;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsLettersPage extends CommonNewsLettersPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(id = "agree")
    private static MobileElement acceptCookie;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;
    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;
    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;
    @iOSXCUITFindBy(id = "Newsletters")
    private static MobileElement newslettersSection;
    @iOSXCUITFindBy(id = "Mint Newsletters & Email Alerts")
    private static MobileElement newslettersSectionPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='FREE NEWSLETTERS']")
    private static MobileElement freeNewsLetterText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SUBSCRIBERS ONLY NEWSLETTERS']")
    private static MobileElement subscribedOnlyNewsLetterText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;
    @iOSXCUITFindBy(id = "EXPLORE")
    private static MobileElement explorePage;
    @iOSXCUITFindBy(id = "Mint e-paper")
    private static MobileElement mintEPaper;
    @iOSXCUITFindBy(id = "Subscribe")
    private static MobileElement Subscribe;
    @iOSXCUITFindBy(id = "Newsletters")
    private static MobileElement newsLetters;
    @iOSXCUITFindBy(id = "My Reads")
    private static MobileElement myReads;
    @iOSXCUITFindBy(id = "Top Sections")
    private static MobileElement topSection;
    @iOSXCUITFindBy(id = "Top of the Morning")
    private static MobileElement freeNewsLetterFirstTypeOption;
    @iOSXCUITFindBy(id = "Ticker")
    private static MobileElement freeNewsLetterSecondTypeOption;
    @iOSXCUITFindBy(id = "Company Outsider")
    private static MobileElement freeNewsLetterThirdTypeOption;
    @iOSXCUITFindBy(id = "Crypto Notes")
    private static MobileElement freeNewsLetterFourthTypeOption;
    @iOSXCUITFindBy(id = "Easynomics")
    private static MobileElement freeNewsLetterFifthTypeOption;
    @iOSXCUITFindBy(id = "Saturday Feeling")
    private static MobileElement freeNewsLetterSixthTypeOption;
    @iOSXCUITFindBy(id = "Monday-Friday")
    private static MobileElement freeNewsLetterTypeMondayToFriday;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Monday'])[1]")
    private static MobileElement freeNewsLetterTypeMonday;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Tuesday'])[1]")
    private static MobileElement freeNewsLetterTypeTuesday;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Wednesday'])[1]")
    private static MobileElement freeNewsLetterTypeWednesday;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Friday'])[1]")
    private static MobileElement freeNewsLetterTypeFriday;
    @iOSXCUITFindBy(id = "Saturday")
    private static MobileElement freeNewsLetterTypeSaturday;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Preview'])[1]")
    private static MobileElement freeNewsLetterPreviewButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='URL']")
    private static MobileElement newsLetterPreviewPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Close']")
    private static MobileElement newsLetterPreviewPageCloseButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SUBSCRIBERS ONLY NEWSLETTERS']//following-sibling::XCUIElementTypeCell[1]//XCUIElementTypeStaticText[@name='Preview']")
    private static MobileElement subscribedOnlyNewsLetterPreviewButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='FREE NEWSLETTERS']//following::XCUIElementTypeButton[contains(@name,'subscribeNewletter')][1]")
    private static MobileElement subscribeFreeNewsLetterButton;
    @iOSXCUITFindBy(id = "Login or Register")
    private static MobileElement loginPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SUBSCRIBERS ONLY NEWSLETTERS']//following::XCUIElementTypeButton[contains(@name,'subscribeNewletter')][1]")
    private static MobileElement subscribePaidNewsLetterButton;
    @iOSXCUITFindBy(id = "Choose a plan")
    private static MobileElement planPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Subscribed'])[1]")
    private static MobileElement subscribedTagFreeNewsLetters;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Unsubscribe']")
    private static MobileElement unSubscribeTagFreeNewsLetters;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='SUBSCRIBERS ONLY NEWSLETTERS']//following::XCUIElementTypeStaticText[@name='Subscribed'])[1]")
    private static MobileElement subscribedTagPaidNewsLetters;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='SUBSCRIBERS ONLY NEWSLETTERS']//following::XCUIElementTypeButton[@name='Unsubscribe'])[1]")
    private static MobileElement unSubscribeTagPaidNewsLetters;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Privacy Policy']")
    private static MobileElement privacyPolicyNewsLettersPage;
    @iOSXCUITFindBy(accessibility = "PRIVACY POLICY")
    private static MobileElement privacyPolicyPage;
    @iOSXCUITFindBy(accessibility = "Editor's Choice")
    private static MobileElement editorChoice;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement explore;
    @iOSXCUITFindBy(id = "Mint e-paper")
    private static MobileElement exploreTabEPaper;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEWSLETTERS']/following-sibling::XCUIElementTypeOther[2]")
    private static MobileElement newslettersCarouselSection;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEWSLETTERS']")
    private static MobileElement newsLetterCarousel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NEWSLETTERS']/following-sibling::XCUIElementTypeButton[1]")
    private static MobileElement newsLettersCarouselViewAll;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Mint Newsletters & Email Alerts'`][1]")
    private static MobileElement newsLetterPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Subscribe'`][1]")
    private static MobileElement newsLetterSubscribeButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Read'`][3]")
    private static MobileElement newsLetterReadButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Close'`]")
    private static MobileElement newsLetterWebViewCloseButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Address'`]")
    private static MobileElement newsLetterWebViewPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Read']")
    private static List<MobileElement> newsLetterListOfReadButton;



    public NewsLettersPage() {
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
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public void clickOnHomeAndExploreTab() {
        commonFunctions.clickElement(home, 10, "Home Tab");
        commonFunctions.clickElement(explore, 10, "Explore Tab");
//        commonFunctions.clickElement(explore, 10, "Explore Tab");
        commonFunctions.scrollUpToElementDisplayed(exploreTabEPaper);
    }

    private boolean checkNewsLettersPageVisibility() {
        boolean isShowing;
        clickOnHomeAndExploreTab();
        isShowing = commonFunctions.checkElementVisibilityByScrolling(newslettersSection, "newsLetters");
        commonFunctions.clickElement(newslettersSection, 10, "news letters section");
        isShowing &= commonFunctions.isElementDisplayed(newslettersSectionPage, 30, "newsletters Section Page");
        return isShowing;
    }

    @Override
    public boolean checkNewsLetterFunctionality() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.isElementDisplayed(freeNewsLetterText, 10, "Free NewsLetter Text");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribedOnlyNewsLetterText, "Subscribed Only News letter");
        isShowing &= commonFunctions.isElementDisplayed(subscribedOnlyNewsLetterText, 10, "Subscribed Only NewsLetter Text");
        commonFunctions.scrollUpUntilElementFound(back);
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        isShowing &= commonFunctions.isElementDisplayed(explorePage, 30, "explore page");
        isShowing &= commonFunctions.isElementDisplayed(mintEPaper, 10, "mintEPaper");
        isShowing &= commonFunctions.isElementDisplayed(Subscribe, 10, "Subscribe");
        isShowing &= commonFunctions.isElementDisplayed(newsLetters, 10, "newsLetters");
        isShowing &= commonFunctions.isElementDisplayed(myReads, 10, "myReads");
        isShowing &= commonFunctions.isElementDisplayed(topSection, 10, "topSection");
        commonFunctions.clickElement(exploreCloseIcon,10,"explore Close Icon");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkFirstNewsLettersOption() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.isElementDisplayed(freeNewsLetterText, 10, "First Free NewsLetter Text");
        isShowing &= commonFunctions.isElementDisplayed(freeNewsLetterFirstTypeOption, 10, "first option: Top of the Morning");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterSecondTypeOption, "Second option: Ticker");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterThirdTypeOption, "Third option: Company Outsider");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterFourthTypeOption, "Fourth option: Crypto Notes");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterFifthTypeOption, "Fifth option: Easynomics");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterSixthTypeOption, "Sixth option: Saturday Feeling");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "Back button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkFreeNewsLettersTypes() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.isElementDisplayed(freeNewsLetterText, 10, "First Free NewsLetter Text");
        isShowing &= commonFunctions.isElementDisplayed(freeNewsLetterTypeMondayToFriday, 10, "Type: Monday-Friday");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterTypeMonday, "Type: Monday");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterTypeTuesday, "Type: Tuesday");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterTypeWednesday, "Type: Wednesday");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterTypeFriday, "Type: Friday");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(freeNewsLetterTypeSaturday, "Type: Saturday");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "Back button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkPreviewFunctionality() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        commonFunctions.clickElement(freeNewsLetterPreviewButton, 10, "Free NewsLetter: first Preview Button");
        commonFunctions.dummyWait(10);
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPreviewPage, 10, "preview page");
        commonFunctions.clickElement(newsLetterPreviewPageCloseButton, 10, "Free NewsLetter: PreviewPage Close Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribedOnlyNewsLetterPreviewButton, "Subscribed Only NewsLetter: first preview button");
        commonFunctions.clickElement(subscribedOnlyNewsLetterPreviewButton, 10, "subscribed Only NewsLetter: First Preview Button");
        commonFunctions.dummyWait(10);
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPreviewPage, 10, "preview page");
        commonFunctions.clickElement(newsLetterPreviewPageCloseButton, 10, "Subscribed only NewsLetter: PreviewPage Close Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "Back button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkLoginPopUpForSubscribeFreeNewsLetters() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        commonFunctions.clickElement(subscribeFreeNewsLetterButton, 10, "subscribed FreeNewsLetter Button");
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        commonFunctions.clickElement(back, 10, "Back to newsLetters Page");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkLoginPopUpForSubscribePaidNewsLetters() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "subscribe PaidNewsLetter Button");
        commonFunctions.clickElement(subscribePaidNewsLetterButton, 10, "subscribe PaidNewsLetter Button");
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        commonFunctions.clickElement(back, 10, "Back to NewsLetters Page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "Back button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkPlanPageForPaidNewsLettersSubscribeButton() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "subscribe PaidNewsLetter Button");
        commonFunctions.clickElement(subscribePaidNewsLetterButton, 10, "subscribe PaidNewsLetter Button");
        isShowing &= commonFunctions.isElementDisplayed(planPage, 10, "Plan page");
        commonFunctions.clickElement(back, 10, "Back to NewsLetters Page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "Back button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagForFreeNewsLetters() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        commonFunctions.clickElement(subscribeFreeNewsLetterButton, 10, "subscribe Free NewsLetters Button");
        isShowing &= commonFunctions.isElementDisplayed(subscribedTagFreeNewsLetters, 20, "subscribed Tag Free News Letters");
        isShowing &= commonFunctions.isElementDisplayed(unSubscribeTagFreeNewsLetters, 20, "unSubscribe Tag Free News Letters");
        commonFunctions.clickElement(unSubscribeTagFreeNewsLetters, 10, "click again for unsubscribe");
        isShowing &= commonFunctions.isElementDisplayed(subscribeFreeNewsLetterButton, 10, "subscribe button free news letters");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagForPaidNewsLetters() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "subscribe PaidNewsLetter Button");
        commonFunctions.clickElement(subscribePaidNewsLetterButton, 10, "subscribe PaidNewsLetter Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribedTagPaidNewsLetters, "subscribed Tag PaidNewsLetter Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(unSubscribeTagPaidNewsLetters, "unSubscribe Tag Paid News Letters");
        commonFunctions.clickElement(unSubscribeTagPaidNewsLetters, 10, "click again for unsubscribe");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "subscribe button Paid news letters");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "back Button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkPrivacyPolicyNewsLetters() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        commonFunctions.scrollToBottomOniOSNative();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(editorChoice, "editor choice section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(privacyPolicyNewsLettersPage, "privacy policy text");
        commonFunctions.clickElement(privacyPolicyNewsLettersPage, 10, "privacy policy");
        isShowing &= commonFunctions.isElementDisplayed(privacyPolicyPage, 10, "privacy Policy Page");
        commonFunctions.clickElement(back, 10, "Back to news letters page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "back Button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagForPaidAndFreeNewsLetters() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribeFreeNewsLetterButton, "Subscribe Tag Free News Letters");
        commonFunctions.clickElement(subscribeFreeNewsLetterButton, 10, "subscribe Free NewsLetters Button");
        isShowing &= commonFunctions.isElementDisplayed(subscribedTagFreeNewsLetters, 10, "subscribed Tag Free News Letters");
        isShowing &= commonFunctions.isElementDisplayed(unSubscribeTagFreeNewsLetters, 10, "unSubscribe Tag Free News Letters");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "subscribe PaidNewsLetter Button");
        commonFunctions.clickElement(subscribePaidNewsLetterButton, 10, "subscribe PaidNewsLetter Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribedTagPaidNewsLetters, "subscribed Tag PaidNewsLetter Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(unSubscribeTagPaidNewsLetters, "unSubscribe Tag Paid News Letters");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "back Button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        commonFunctions.clickElement(home, 10, "Home Tab");
        return isShowing;
    }

    @Override
    public boolean checkNoSubscribedNewsLettersIsShowing() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribeFreeNewsLetterButton, "Subscribe Tag Free News Letters Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "Subscribe Paid News Letter Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "back Button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        commonFunctions.clickElement(home, 10, "Home Tab");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagAndUnSubscribedPaidAndFreeNewsLetters() {
        boolean isShowing;
        isShowing = checkNewsLettersPageVisibility();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribedTagFreeNewsLetters, "subscribed Tag Free News Letters");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(unSubscribeTagFreeNewsLetters, "unSubscribe Tag Free News Letters");
        commonFunctions.clickElement(unSubscribeTagFreeNewsLetters, 10, "click again for unsubscribe");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribeFreeNewsLetterButton, "subscribe button free news letters");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribedTagPaidNewsLetters, "subscribed Tag PaidNewsLetter Button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(unSubscribeTagPaidNewsLetters, "unSubscribe Tag Paid News Letters");
        commonFunctions.clickElement(unSubscribeTagPaidNewsLetters, 10, "click again for unsubscribe");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(subscribePaidNewsLetterButton, "subscribe button Paid news letters");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(back, "back Button");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(16,65,"explore close icon");
        commonFunctions.clickElement(home,10,"Home tab");
        return isShowing;
    }

    @Override
    public boolean checkNewsletterPageLayout() {
        return false;
    }
    @Override
    public boolean checkNewsletterPageLayoutForSubscribedUsers() {
        return false;
    }
    @Override
    public  boolean checkNewslettersTopNav(){
        return false;
    }
    @Override
    public   boolean checkRHSOnNewslettersSubscribedUsers(){return false;}
    @Override
    public   boolean checkLHSOnNewslettersPage(){return false;}
    @Override
    public   boolean checkEasynomicsOnNewslettersPage(){return false;}
    @Override
    public   boolean checkCryptoNotesOnNewslettersPage(){return false;}
    @Override
    public  boolean checkCompanyOutsiderOnNewslettersPage(){return false;}
    @Override
    public boolean checkTickerOnNewslettersPage(){return false;}
    @Override
    public  boolean checkSaturdayFeelingOnNewslettersPage(){return false;}
    @Override
    public   boolean checkEditorChoiceOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}
    @Override
    public  boolean checkMintMoneyOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}
    @Override

    public  boolean checkMintTechOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}
    @Override
    public   boolean checkMintPrimerOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}
    @Override
    public  boolean checkTOTMOnNewslettersPage(){return false;}
    @Override
    public   boolean checkPlainsFactOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}
    @Override
    public   boolean checkMarkToMarketOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}
    @Override
    public   boolean checkTwichOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}
    @Override
    public  boolean checkLikeShareSuscribeOnNewslettersPageForSubscriberOnlyNewsletters(){return false;}

    @Override
    public boolean previewUrlValidation(WebElement element, String title) {
        return false;
    }

    private boolean newsLetterCarouselOnHomePage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(newslettersCarouselSection, "newsletters carousel section");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterCarousel, 10, "newsLettres carousel");
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
        isShowing &= commonFunctions.isElementDisplayed(newsLettersCarouselViewAll, 10, "newLetters view all");
        isShowing &= commonFunctions.getElementTextAndCheck(newsLettersCarouselViewAll, "View All", 10, "view all button");
        return isShowing;
    }

    @Override
    public boolean checkNewsletterCardDesign() {
        return false;
    }

    @Override
    public boolean checkNewsLetterViewAllFunctionality() {
        boolean isShowing;
        isShowing = checkNewsLetterViewAllButton();
        commonFunctions.clickElement(newsLettersCarouselViewAll, 10, "newLetters view all");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterPage, 10, "newsletters Page");
        commonFunctions.clickElement(back, 10, "back button on newsletters page");
        return isShowing;
    }

    @Override
    public boolean checkNewsletterSubscribeButton() {
        boolean isShowing;
        isShowing = checkNewsLetterViewAllButton();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(newsLetterSubscribeButton, "subscribe button");
        return isShowing;
    }

    @Override
    public boolean checkNewsletterReadButtonAndFunctionality() {
        boolean isShowing;
        isShowing = newsLetterCarouselOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(newsLetterReadButton, 10, "newsletters Read button");
        commonFunctions.clickElement(newsLetterReadButton, 10, "read button");
        isShowing &= commonFunctions.isElementDisplayed(newsLetterWebViewPage, 10, "newLetters WebView Page");
        commonFunctions.clickElement(newsLetterWebViewCloseButton, 10, "close button on webView page");
        return isShowing;
    }

    @Override
    public boolean checkNewsletterFreeTag() {
        return false;
    }

    private boolean clickOnSubscribeButton() {
        boolean isShowing;
        isShowing = checkNewsletterSubscribeButton();
        int result[] = commonFunctions.getElementXYCoordinate(newsLetterSubscribeButton);
        commonFunctions.clickByCoordinates(result[0]+15, result[1]+9,"subscribe button");
        return isShowing;
    }



    @Override
    public boolean checkFreeNewsLetterSubscribeByNonLoggedInUser() {
        boolean isShowing;
        isShowing = clickOnSubscribeButton();
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        commonFunctions.clickElement(back, 10, "back button login page");
        return isShowing;
    }

    @Override
    public boolean checkSubscribedTagByClickingOnSubscribeButton() {
        boolean isShowing;
        isShowing = clickOnSubscribeButton();
        commonFunctions.clickElement(home, 10, "home tab");
        //TODO subscribed button element locator is not present in app source;
//      isShowing &=commonFunctions.checkElementVisibilityByScrolling(,10,"subscribed button");
        return isShowing;
    }

    @Override
    public boolean checkSwipeFunctionality() {
      boolean  isShowing = checkNewsletterSubscribeButton();
        commonFunctions.checkElementVisibilityByScrolling(newsLetterReadButton,"first Read tag");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(newsLetterListOfReadButton,2,"third free tag");
        int FirstEle[] = commonFunctions.getListOfElementXYCoordinate(newsLetterListOfReadButton,0,"first Free tag");
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], FirstEle[0], FirstEle[1]);
        commonFunctions.swipeElementUsingTouchAction(FirstEle[0], FirstEle[1],secondEle[0], secondEle[1]);
        return isShowing;
    }

    @Override
    public boolean checkFreeSubscriptionFlowInCaseOfNonLoggedInUsers(){ return false;}
    @Override
    public boolean checkRHSOnNewslettersPage() {
        return false;
    }
    @Override
    public boolean checkPreviewLinkOnNewslettersPage(){return false;}
    @Override
    public boolean checkFreeNewsLetterSubscriptionByNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkPaidNewsLetterSubscriptionByNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagAndClickOnUnsubscribed() {
        return false;
    }

    @Override
    public boolean checkPremiumTag() {
        return false;
    }
}