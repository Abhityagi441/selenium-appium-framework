package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonBookmarkPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookmarkPage extends CommonBookmarkPage {

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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'bookmark'`][1]")
    private static MobileElement bookmarkButton;
    @iOSXCUITFindBy(accessibility = "Login")
    private static MobileElement loginPopup;
    @iOSXCUITFindBy(id = "Login or Register")
    private static MobileElement loginPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement back;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private static MobileElement emailTextBoxMainSignInPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButtonSignInPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private static MobileElement passwordTextBoxMainSignInPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
    private static MobileElement proceedWithoutAppleID;
    @iOSXCUITFindBy(id = "Ok")
    private static MobileElement okButton;
    @iOSXCUITFindBy(id = "bannerCross")
    private static MobileElement closeWhatsupIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'NIFTY 50'`]")
    private static MobileElement marketNifty;
    @FindBy(name = "My Account")
    private static WebElement myAccountWithArrow;
    @iOSXCUITFindBy(id = "Label")
    private static MobileElement homePageFirstStoryHeadline;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement explore;
    @iOSXCUITFindBy(id = "My Reads")
    private static MobileElement myReadsMenu;
    @iOSXCUITFindBy(id = "MY READS")
    private static MobileElement myReadsPageText;
    @iOSXCUITFindBy(id = "Empty list")
    private static MobileElement emptyMyReadsPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[2]/XCUIElementTypeImage)[2]")
    private static MobileElement emptyImageMyReadsPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;

    public BookmarkPage() {
        globalVars = GlobalVars.getInstance();
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

    private boolean bookmarkRedirectionToLoginPage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home Tab");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(bookmarkButton, 10, "First story bookmark button");
        isShowing = commonFunctions.isElementDisplayed(loginPopup, 10, "login popup");
        commonFunctions.clickElement(loginPopup, 10, "login popup");
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        return isShowing;
    }

    @Override
    public boolean checkBookmarkFunctionalityRedirectionToLoginPage() {
        boolean isShowing;
        isShowing = bookmarkRedirectionToLoginPage();
        commonFunctions.clickElement(back, 10, "Back to Home Menu");
        return isShowing;
    }

    @Override
    public boolean checkBookmarkFunctionalityRedirectionAfterLogin(String email, String password) {
        boolean isShowing;
        isShowing = bookmarkRedirectionToLoginPage();
        commonFunctions.sendKey(emailTextBoxMainSignInPage, email, 10, "emailTextBoxMainSignInPage");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continueButtonSignInPage");
        commonFunctions.sendKey(passwordTextBoxMainSignInPage, password, 10, "passwordTextBoxMainSignInPage");
        commonFunctions.clickElement(continueButtonSignInPage, 10, "continueButtonSignInPage");
        commonFunctions.clickElement(proceedWithoutAppleID, 10, "proceedWithoutAppleID");
        commonFunctions.clickElementIfDisplayed(okButton, 10, "Ok button");
        commonFunctions.clickElementIfDisplayed(closeWhatsupIcon, 10, "Close whatsapp button");
        isShowing &= commonFunctions.isElementDisplayed(myAccountWithArrow, 10, "My Account");
        isShowing &= commonFunctions.isElementDisplayed(homePageFirstStoryHeadline, 10, "home page");
        isShowing &= commonFunctions.isElementSelected(bookmarkButton, 10, "first story bookmark");
        return isShowing;
    }

    @Override
    public boolean  checkBookmarkFunctionalityRedirectionAsSubscribedUser(String email, String password) {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home Tab");
        commonFunctions.dummyWait(5);
        String firstStoryHeadline = commonFunctions.getElementText(homePageFirstStoryHeadline, 10);
        isShowing = checkBookmarkFunctionalityRedirectionAfterLogin(email, password);
        String secondStoryHeadline = commonFunctions.getElementText(homePageFirstStoryHeadline, 10);
        if (isShowing &= !firstStoryHeadline.equals(secondStoryHeadline)) {
            isShowing &= true;
            Utils.logStepInfo(true, "Story Headline text changed after subscribed login");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "Story Headline text --Not-- changed after subscribed login");
        }
        return isShowing;
    }

    @Override
    public boolean checkBookmarkFunctionalityOnStoryDetailPage() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home Tab");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(homePageFirstStoryHeadline, 10, "first story");
        commonFunctions.dummyWait(10);
        commonFunctions.scrollUntilElementFound(bookmarkButton);
        isShowing = commonFunctions.clickElement(bookmarkButton, 10, "story detail page bookmark");
        isShowing &= commonFunctions.isElementDisplayed(loginPopup, 10, "login popup");
        commonFunctions.clickElement(loginPopup, 10, "login popup");
        isShowing &= commonFunctions.isElementDisplayed(loginPage, 10, "login page");
        commonFunctions.clickElement(back, 10, "Back to Home Menu");
        commonFunctions.clickElement(home,10,"home tab");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkBookmarkPageEmptyForNonLoggedUser() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "Home Tab");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(explore, 10, "Explore Tab");
        commonFunctions.clickElement(myReadsMenu, 10, "MyReads Menu");
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.isElementDisplayed(myReadsPageText, 10, "My Reads page");
        isShowing &= commonFunctions.isElementEnabled(emptyMyReadsPage, "Empty My Reads page");
        isShowing &= commonFunctions.isElementEnabled(emptyImageMyReadsPage, "Empty image on My Reads page");
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkBookmarkStoryOnBookmarkPage(String email, String password) {
        boolean isShowing;
        isShowing = checkBookmarkFunctionalityRedirectionAfterLogin(email, password);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(explore, 10, "Explore Tab");
        commonFunctions.clickElement(myReadsMenu, 10, "MyReads Menu");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(myReadsPageText, 10, "My Reads page");
       //TODO: Due to story headline text is null so we can,t validate the same bookmarked story is showing on bookmarks page or not
        commonFunctions.clickElement(back, 10, "Back to Explore Menu");
        commonFunctions.clickByCoordinates(0,47,"explore close icon");
        return isShowing;
    }
}
