package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;


public class BookmarkTest extends BaseTest {
    private static CommonBookmarkPage bookmarkPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        bookmarkPage = CommonBookmarkPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }


    @Author(name = "Imran Sayyed")
    @Description("QAAUT-504, QAAUT-527(mWeb),QAAUT-551(ios-mWeb):To verify bookmarks is working when user is logged in")
    @Test
    public void verifyBookmarkFunctionality() {
        boolean isStepTrue;
        try{
            Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookmarkFunctionality");
            isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
            Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

            isStepTrue = bookmarkPage.checkAdToBookmarkAndVerify(params.get("uri"), params.get("address"));
            Assert.assertTrue(isStepTrue, "Add to bookmark functionality failed");
        }
        finally {
            isStepTrue = loginPage.logout();
            Assert.assertTrue(isStepTrue, "Log out failed");
        }
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-575(android),595(iOS):To verify bookmarks is working fine")
    @Test
    public void verifyBookmarkWorkingFine() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookmarkWorkingFine");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookMarkWorkingFine(params.values().toArray(new String[5]));
        Assert.assertTrue(isStepTrue, "check book mark working has been failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma, Gulshan Tomar")
    @Description("QAAUT-1458(mWeb), QAAUT-1457(Web):To verify bookmark icon is displayed and is clickable")
    @Test
    public void verifyBookmarkIconIsClickableAndDisplay() {
        boolean isStepTrue;
        try{
            Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookmarkIconIsClickableAndDisplay");
            isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
            Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

            isStepTrue = bookmarkPage.checkBookmarkIconIsClickableAndDisplay(params.get("uri"), params.get("address"));
            Assert.assertTrue(isStepTrue, "Bookmark is not saved in the save section.");
        }
        finally {
            isStepTrue = loginPage.logout();
            Assert.assertTrue(isStepTrue, "Log out failed");
        }
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1633(iOS):Verify that Remove All link is displayed on the Bookmark Page")
    @Test
    public void verifyRemoveAllLinkBookMarkPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyRemoveAllLinkBookMarkPage");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkRemoveAllLinkBookMarkPage(params.values().toArray(new String[5]));
        Assert.assertTrue(isStepTrue, "Verify that Remove All link is displayed on the Bookmark Page has been failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1654(Android-native):Verify that different options displayed when user tap on 3 dot")
    @Test
    public void verifyClickThreeDotDisplayDifferentOptions() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkClickThreeDotDisplayDifferentOptions();
        Assert.assertTrue(isStepTrue, "Options are not displaying.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-1782(iOS-native), QAAUT-1783(Android-native):Verify the redirection on tapping Bookmarks option for non logged in user")
    @Test
    public void verifyBookMarkRedirectionNonLoggedInUser() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkBookMarkRedirectionNonLoggedInUser();
        Assert.assertTrue(isStepTrue, "Bookmarks option redirection failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1784, QAAUT-1884 (iOS-native),QAAUT-1693(Android-native):Verify the redirection on tapping Bookmarks option for logged in user")
    @Test
    public void verifyBookMarkRedirectionLoggedInUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookMarkRedirectionLoggedInUser();
        Assert.assertTrue(isStepTrue, "Bookmarks option redirection failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1788(iOS-native):Verify that two options like Display & Text Size and Notifications is displayed on the Settings")
    @Test
    public void verifyOptionsInSettings() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkOptionsInSettings();
        Assert.assertTrue(isStepTrue, "Bookmarks option redirection failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1877(Android-native):Verify that On India Page after tapping on three dots on any story, bottom action sheet should opened.")
    @Test
    public void verifyBottomActionPageOnIndiaPage() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkBottomActionPageOnIndiaPage();
        Assert.assertTrue(isStepTrue, "Botton action display is failed.");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1884(iOS-native):Verify that user is able to bookmark the story from the three dots")
    @Test
    public void verifyBookmark3DotOption() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkBookmark3DotOption();
        Assert.assertTrue(isStepTrue, "Bookmarks option failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-2035 (Android-native),QAAUT-2035(iOS):Verify the redirection on tapping back button on the BOOKMARKS page.")
    @Test
    public void verifyRedirectionOnTapBackFromBookmarkPage() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkRedirectionOnTapBackFromBookmarkPage();
        Assert.assertTrue(isStepTrue, "Redirection to Profile is failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2036 (Android-native):Verify the appearance of the Bookmark page when some article is bookmarked")
    @Test
    public void verifySomeArticleIsBookmarked() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySomeArticleIsBookmarked");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkSomeArticleIsBookmarked();
        Assert.assertTrue(isStepTrue, "Bookmark page is empty!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2037 (Android-native), QAAUT-2184 (iOS-native): Verify that Bookmark headign is center aligned and displayed on top of the page")
    @Test
    public void verifyBookmarkPageHeadingInCenter() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkBookmarkPageHeadingInCenter();
        Assert.assertTrue(isStepTrue, "Bookmark heading is not in Center!!!!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-2038 (Android-native), QAAUT-2067(iOS): Verify that text ' Find your bookmarked aticles here, you can tap on the bookmark icon to remove them from the list' is displayed after the heading")
    @Test
    public void verifyTextDisplayAfterBookmarkPageHeading() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTextDisplayAfterBookmarkPageHeading");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkTextDisplayAfterBookmarkPageHeading();
        Assert.assertTrue(isStepTrue, "Given text message is not displaying!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2039, (Android-native), QAAUT-2192  (iOS-native):Verify the redirection when user tap on the Story displayed on the bookmarked page")
    @Test
    public void verifyRedirectionStoryPageOnTap() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyRedirectionStoryPageOnTap");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkRedirectionStoryPageOnTap();
        Assert.assertTrue(isStepTrue, "Redirection towards related story page is failed!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2040 (Android-native), QAAUT-2202 (iOS-native): Verify the redirection when user taps on the Section name displayed after the story title on the bookmarked page")
    @Test
    public void verifyRedirectionSectionPageOfStoryOnTap() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyRedirectionSectionPageOfStoryOnTap");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkRedirectionSectionPageOfStoryOnTap();
        Assert.assertTrue(isStepTrue, "Section page redirection from Bookmark page Story is failed!!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2057 (Android-native), QAAUT-2066 (iOS-native):Verify that bottom nav is displayed on the Bookmark Page")
    @Test
    public void verifyBottomNavDisplayOnBookmarkPage() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkBottomNavDisplayOnBookmarkPage();
        Assert.assertTrue(isStepTrue, "Bottom nav is not displaying!!!!!!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-2058 (Android-native), QAAUT-2062(iOS):Verify that Home is displayed as Selected on the bottom nav when user is on the Bookmark page")
    @Test
    public void verifyHomeisSelectedBottomNavOnBookmarkPage() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkHomeisSelectedBottomNavOnBookmarkPage();
        Assert.assertTrue(isStepTrue, "Home is not selected on Bookmark page!!!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-2060 (Android-native), QAAUT-2065(iOS):Verify that Bookmark icon is displayed just before the Image of the Story")
    @Test
    public void verifyBookmarkIconDisplayBeforeImageStory() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookmarkIconDisplayBeforeImageStory");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookmarkIconDisplayBeforeImageStory();
        Assert.assertTrue(isStepTrue, "Bookmark icon is not displaying!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2061 (Android-native), QAAUT-2799(iOS):Verify the behaviour when user taps on the Bookmark icon displayed on the Bookmark Page")
    @Test
    public void verifyTapOnBookmarkIconAtBookmarkPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTapOnBookmarkIconAtBookmarkPage");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkTapOnBookmarkIconAtBookmarkPage();
        Assert.assertTrue(isStepTrue, "Bookmarked story remain in the bookmark page!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2096 (Android-native): Verify that Article is displayed on the Bookmark Page when user save that Story from the Home Page")
    @Test
    public void verifyBookmarkStoryDisplay() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookmarkStoryDisplay();
        Assert.assertTrue(isStepTrue, "Bookmarked story not displaying in bookmark page!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2099 (Android-native): Verify that Article is displayed on the Bookmark Page when user save that Story from the any Section Page.")
    @Test
    public void verifyBookmarkStoryDisplayForAnySectionSavedArticles() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookmarkStoryDisplayForAnySectionSavedArticles();
        Assert.assertTrue(isStepTrue, "Bookmarked story not displaying in bookmark page!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2316(iOS), QAAUT-2809 (Android-native):Verify that user is able to bookmark the story from the Sports section")
    @Test
    public void verifyBookMarkStoryFromSportSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkStoryFromSportSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.bookMarkStoryFromSportsSection();
        Assert.assertTrue(isStepTrue, "Bookmarked story failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya,Harsh Sharma")
    @Description("QAAUT-2318 (iOS-Native),QAAUT-2813(Android_Native) : Verify that when user boookmark the Story from the Sports section then that story is displayed on the Saved Article")
    @Test
    public void verifySportStoryInBookMarkedArtical() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySportStoryInBookMarkedArtical");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.sportStoryInBookMarkedArtical();
        Assert.assertTrue(isStepTrue, "Bookmarked story failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya,Harsh Sharma")
    @Description("QAAUT-2324 (iOS-Native),QAAUT-2819(Android_Native) : Verify that user is able to bookmark the story from the Photos section")
    @Test
    public void verifyBookMarkStoryFromPhotosSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkStoryFromPhotosSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.bookMarkStoryFromPhotosSection();
        Assert.assertTrue(isStepTrue, "BookMark Story failed from Photos Section !!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2821(Android_Native), QAAUT-2338 (iOS-Native) : Verify that when user boookmark the Story from the Photos section then that story is displayed on the Saved Article.")
    @Test
    public void verifyPhotoStoryInBookMarkedArtical() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPhotoStoryInBookMarkedArtical");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.photoStoryInBookMarkedArtical();
        Assert.assertTrue(isStepTrue, "BookMark Story failed from Photos Section !!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-1787(Android_Native), QAAUT-1786 (iOS-Native) : Verify that count of the Bookmarked Stories is same on the Profile Page with the Count of the Bookmarked Stories on the Bookmark Page")
    @Test
    public void verifyCountOfBookMarkedStoriesSame() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCountOfBookMarkedStoriesSame");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkCountOfBookMarkedStoriesSame();
        Assert.assertTrue(isStepTrue, "count of the Bookmarked Stories !!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2906 (Android_Native), QAAUT-2905 (iOS-Native) : Verify the behaviour when user tap on the Bookmark option displayed on Message box for Logged in user")
    @Test
    public void verifyBookMarkMsgForLoggedInUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkMsgForLoggedInUser");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookMarkMsgForLoggedInUser();
        Assert.assertTrue(isStepTrue, "Message Box Displayed failed !!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2908 (Android-native), QAAUT-2907(iOS): Verify the behaviour when user tap on the Bookmark option displayed on Message box for Non-Logged in user")
    @Test
    public void verifyBookMarkMsgBoxForNonLoggedInUser() {
        boolean isStepTrue;
        isStepTrue = bookmarkPage.checkBookMarkMsgBoxForNonLoggedInUser();
        Assert.assertTrue(isStepTrue, "Message box for Non-Logged in user Failed !!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3531 (Android_Native), QAAUT-3532 (iOS-Native) : Verify that when user bookmark the story from the video Story details page then that story is displayed on the Bookmark Page")
    @Test
    public void verifyBookMarkStoryOfVideoSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkStoryOfVideoSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookMarkedStoryFromVideoSection();
        Assert.assertTrue(isStepTrue, "story is not displayed on the Bookmark Page... failed !!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3090 (Android_Native), QAAUT-3534 (iOS-Native) : Verify that when user un-bookmark the story from the video Story details page then that story is not displayed on the Bookmark Page")
    @Test
    public void verifyUnBookMarkStoryOfVideoSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyUnBookMarkStoryOfVideoSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkUnBookMarkStoryOfVideoSection();
        Assert.assertTrue(isStepTrue, "un-bookmark the Videos story from the Story details page failed !!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3091 (Android_Native), QAAUT-3105 (iOS-Native) : Verify that when user un-bookmark the photo story from the Story details page then that story is not displayed on the Bookmark Page")
    @Test
    public void verifyUnBookMarkStoryOfPhotosSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyUnBookMarkStoryOfPhotosSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkUnBookMarkStoryOfPhotosSection();
        Assert.assertTrue(isStepTrue, "un-bookmark the photo story from the Story details page Failed !!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3092 (Android_Native), QAAUT-3540 (iOS-Native) : Verify that user is able to Bookmark the Story from the Section Listing Page")
    @Test
    public void verifyBookMarkStoryFromSectionListingPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkStoryFromSectionListingPage");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookMarkStoryFromSectionListingPage();
        Assert.assertTrue(isStepTrue, "Unable to Bookmark the Story from the Section Listing Page!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3093 (Android_Native), QAAUT-3541 (iOS-Native) : Verify that when user bookmark the story from the Section Listing Page then that story is displayed on the Bookmark Page")
    @Test
    public void verifyBookMarkStoryInBookmarkSectionFromSectionListingPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkStoryInBookmarkSectionFromSectionListingPage");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookMarkStoryInBookmarkSectionFromSectionListingPage();
        Assert.assertTrue(isStepTrue, "story is displayed on the Bookmark Page failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3096 (Android_Native), QAAUT-3542 (iOS-Native) : Verify the back redirection when user goes to Bookmark Page >> Tap on Story >> Tap back button")
    @Test
    public void verifyBackRedirectionFromBookmarkPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBackRedirectionFromBookmarkPage");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBackRedirectionFromBookmarkPage();
        Assert.assertTrue(isStepTrue, "Back redirection on the Bookmark Page failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3713 (iOS-Native), QAAUT-3714 (Android_Native) : Verify that user is able to bookmark the story from the search page")
    @Test
    public void verifyBookMarkStoryFromSearchPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkStoryFromSearchPage");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkBookMarkStoryFromSearchPage();
        Assert.assertTrue(isStepTrue, "Bookmark the story from the search page failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3715 (iOS-Native), QAAUT-3716 (Android_Native) : Verify that user is able to unbookmark the story from the search page")
    @Test
    public void verifyUnBookMarkStoryFromSearchPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyUnBookMarkStoryFromSearchPage");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkUnBookMarkStoryFromSearchPage();
        Assert.assertTrue(isStepTrue, "UnBookmark the story from the search page failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3717 (iOS-Native), QAAUT-3718 (Android_Native) : Verify that when user bookmark the story from the search page then that story should be displayed on the bookmark page")
    @Test
    public void verifySearchBookMarkStoryDisplayedInBookMarkSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchBookMarkStoryDisplayedInBookMarkSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkSearchBookMarkStoryDisplayedInBookMarkSection();
        Assert.assertTrue(isStepTrue, "Search Page Bookmarked story display in Bookmark failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3867 (iOS-Native), QAAUT-3868 (Android_Native) : Verify that if user bookmark the story from the Daily Digest Page then that story should be displayed on the Bookmark Page")
    @Test
    public void verifyDailyDigestBookMarkStoryDisplayedInBookMarkSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchBookMarkStoryDisplayedInBookMarkSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkDailyDigestBookMarkStoryDisplayedInBookMarkSection();
        Assert.assertTrue(isStepTrue, "Bookmarked story display in Bookmark failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3866 (iOS-Native), QAAUT-3865 (Android_Native) : Verify user able to unbookmark story from Daily Digest Listing Page")
    @Test
    public void verifyDailyDigestUnBookMarkStoryDisplayedInBookMarkSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchBookMarkStoryDisplayedInBookMarkSection");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = bookmarkPage.checkDailyDigestUnBookMarkStoryDisplayedInBookMarkSection();
        Assert.assertTrue(isStepTrue, "UnBookmarked story display in Bookmark failed!!!!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3851 (iOS-Native), QAAUT-3852 (Android_Native) : Verify that user is able to Bookmark the story from the Topic Page")
    @Test
    public void verifyBookMarkStoryFromTopicPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookMarkStoryFromTopicPage");

        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = bookmarkPage.checkBookMarkStoryFromTopicPage();
        Assert.assertTrue(isStepTrue, "User is able to Bookmark the story from the Topic Page failed!!!!!!!!!");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3853 (iOS-Native), QAAUT-3854 (Android_Native) : Verify that user is able to UnBookmark the story from the Topic Page")
    @Test
    public void verifyUnBookMarkStoryFromTopicPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyUnBookMarkStoryFromTopicPage");

        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = bookmarkPage.checkUnBookMarkStoryFromTopicPage();
        Assert.assertTrue(isStepTrue, "User is able to UnBookmark the story from the Topic Page failed!!!!!!!!!");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3855 (iOS-Native), QAAUT-3857 (Android_Native) : Verify that if user bookmark the story from the Topic Page then that story should be displayed on the Bookmark Page")
    @Test
    public void verifyTopicBookMarkStoryDisplayedInBookMarkSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopicBookMarkStoryDisplayedInBookMarkSection");

        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = bookmarkPage.checkTopicBookMarkStoryDisplayedInBookMarkSection();
        Assert.assertTrue(isStepTrue, "Bookmark the story from the Topic Page then that story should be displayed on the Bookmark Page failed!!!!!!!!!");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3863 (iOS-Native), QAAUT-3864 (Android_Native) : Verify user able to bookmark story from Daily Digest Listing Page")
    @Test
    public void verifyBookMarkedStoryFromDailyDigest() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchBookMarkStoryDisplayedInBookMarkSection");

        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = bookmarkPage.checkBookMarkedStoryFromDailyDigest();
        Assert.assertTrue(isStepTrue, "Bookmarked story From Daily Digest failed!!!!!!!!!");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }
}
