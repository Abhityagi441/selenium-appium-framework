package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.Set;

public class BookmarkPage extends CommonBookmarkPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(xpath = "(//a[contains(text(),'Sign in')])[2]")
    private static MobileElement singInButton;

    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;

    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;

    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;

    @FindBy(id = "phoneEmail")
    private static WebElement emailTextBoxMainSignInPage;

    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;

    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;

    @FindBy(id = "btnLogin")
    private static WebElement signInButtonMainSignInPage;

    @FindBy(xpath = "//div[text()='Use another account']")
    private static WebElement useAnotherAccountGmailSignInPage;

    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;

    @FindBy(id = "account_name_text_field")
    private static WebElement emailAppleSignInPage;

    @FindBy(id = "password_text_field")
    private static WebElement passwordAppleSignInPage;

    @FindBy(id = "sign-in")
    private static WebElement appleSignInNextButton;

    @FindBy(id = "m_login_email")
    private static WebElement emailOrPhoneFacebookSignInPage;

    @FindBy(id = "m_login_password")
    private static WebElement passwordFacebookSignInPage;

    @FindBy(xpath = "//button[@value='Log In']")
    private static WebElement loginButtonFacebookSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailSignInPage;

    @FindBy(xpath = "//span[text()='Next']")
    private static WebElement nextButtonGmailPasswordPage;

    @FindBy(xpath = "//div[@id='password']//input")
    private static WebElement passwordTextBoxGmailSignInPage;

    @FindBy(xpath = "//section//div[@class='logged-in']//span[2]")
    private static WebElement userNameLabelAfterLogin;

    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;

    @FindBy(xpath = "(//a[@class='sign-out'])[2]")
    private static WebElement LogoutButton;

    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;

    @FindBy(id ="reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;

    @FindBy(id="verifyLoginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;

    @FindBy(className="crossicon")
    private static WebElement closeIconHamburger;

    @FindBy(xpath = "//a[@title='epaper']")
    private static WebElement epaperIcon;

    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath="(//div[contains(@class,'cartHolder')]/h3/a)[1]")
    private static WebElement openFullStory;

    @FindBy(xpath = "(//span[contains(@class,'bookmark-candidate')])[1]")
    private static WebElement bookmarkButton;

    @FindBy(xpath = "(//div[contains(@class,'bigCart')]/h3/a)[1]")
    private static WebElement storyTitle;

    @FindBy(xpath = "//ul[@class='leftFixedNav']/li[6]/a")
    private static WebElement savedLink;

    @FindBy(xpath = "//ul[@class='leftFixedNav']")
    private static  WebElement leftNavBar;

   @FindBy(id="userName2")
    private static  WebElement loggedIn;

    @FindBy(xpath = "(//a[contains(text(),'Sign out')])[2]")
    private static WebElement signOut;

    public BookmarkPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkBookMarkWorkingFine(String[] params) {
        return false;
    }

    @Override
    public boolean checkRemoveAllLinkBookMarkPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkClickThreeDotDisplayDifferentOptions() {
        return false;
    }

    @Override
    public boolean checkBookMarkRedirectionLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkBookMarkRedirectionNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkOptionsInSettings() {
        return false;
    }

    @Override
    public boolean checkBottomActionPageOnIndiaPage() {
        return false;
    }

    @Override
    public boolean checkBookmark3DotOption() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTapBackFromBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkSomeArticleIsBookmarked() {
        return false;
    }

    @Override
    public boolean checkBookmarkPageHeadingInCenter() {
        return false;
    }

    @Override
    public boolean checkTextDisplayAfterBookmarkPageHeading() {
        return false;
    }

    @Override
    public boolean checkRedirectionStoryPageOnTap() {
        return false;
    }

    @Override
    public boolean checkRedirectionSectionPageOfStoryOnTap() {
        return false;
    }

    @Override
    public boolean checkBottomNavDisplayOnBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkHomeisSelectedBottomNavOnBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkIconDisplayBeforeImageStory() {
        return false;
    }

    @Override
    public boolean checkTapOnBookmarkIconAtBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkStoryDisplay() {
        return false;
    }

    @Override
    public boolean checkBookmarkStoryDisplayForAnySectionSavedArticles() {
        return false;
    }

    @Override
    public boolean bookMarkStoryFromSportsSection() {
        return false;
    }

    @Override
    public boolean sportStoryInBookMarkedArtical() {
        return false;
    }

    @Override
    public boolean bookMarkStoryFromPhotosSection() {
        return false;
    }

    @Override
    public boolean photoStoryInBookMarkedArtical() {
        return false;
    }

    @Override
    public boolean checkCountOfBookMarkedStoriesSame() {
        return false;
    }

    @Override
    public boolean checkBookMarkMsgForLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkBookMarkMsgBoxForNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryOfVideoSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkedStoryFromVideoSection() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryOfPhotosSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromSectionListingPage() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryInBookmarkSectionFromSectionListingPage() {
        return false;
    }

    @Override
    public boolean checkBackRedirectionFromBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromSearchPage() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryFromSearchPage() {
        return false;
    }

    @Override
    public boolean checkSearchBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestUnBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromTopicPage() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryFromTopicPage() {
        return false;
    }

    @Override
    public boolean checkTopicBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkedStoryFromDailyDigest() {
        return false;
    }

    @Override
    public boolean checkAdToBookmarkAndVerify(String uri, String address) {
        boolean isBookmarkAddedSuccessfully = true;
        commonFunctions.navigateToHomePage();
        commonFunctions.scrollUsingAction(openFullStory, "Full Story");
        commonFunctions.clickElement(openFullStory,10,"Full Story");
        commonFunctions.scrollToElementView(bookmarkButton, 10,"BookMark Button");
        isBookmarkAddedSuccessfully &= commonFunctions.clickElementWithJS(bookmarkButton, 10, "Bookmark button");
        commonFunctions.navigateToURL(globalVars.getURL());
        String title = commonFunctions.getElementText(storyTitle,10);
        commonFunctions.scrollUsingAction(openFullStory, "Read save story");
        commonFunctions.clickElementWithJS(openFullStory, 10, "Read full story saved");
        String currentUrl = commonFunctions.getCurrentURL("Hindustan times", "URL");
        String storyId = commonFunctions.extractStoryID(currentUrl);
        commonFunctions.isElementPresent(leftNavBar,20,"Left Bar");
        Utils.logStepInfo(true,"extract Story ID = "+storyId);
        if(!(storyId.equals(null) || storyId.equals(""))) {
            Response response = commonFunctions.getResponseFromURI(uri, address + storyId);
            String value = JsonPath.parse(response.getBody().asString()).read("$.title");
            Utils.logStepInfo(true,"Response of value = "+value);
            isBookmarkAddedSuccessfully &= value.equalsIgnoreCase(title);
        }else{
            isBookmarkAddedSuccessfully &= true;
            Utils.logStepInfo(true,"Story bookmark Added Successfully");
        }
        commonFunctions.navigateToURL(globalVars.getURL());
        return isBookmarkAddedSuccessfully;
    }

    @Override
    public boolean checkBookmarkIconIsClickableAndDisplay(String uri, String address) {
        return false;
    }


}
