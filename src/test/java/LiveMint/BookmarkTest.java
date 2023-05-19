package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonBookmarkPage;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class BookmarkTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    private static CommonBookmarkPage bookmarkPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        bookmarkPage = CommonBookmarkPage.getInstance();
    }

    @Author(name = "Ravikumar Makam, Manoj Patil")
    @Description("QAAUT-781(Web), 792(MWeb-Android), 803(MWeb-IOS), 812(android_native):Validate the bookmark functionality when user is logged in")
    @Test
    public void verifyBookmark() {
        boolean isStepTrue;
        SoftAssert sa = new SoftAssert();
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookmark");
        isStepTrue = loginPage.loginWithOTP(params.get("email"), params.get("apiURI"), params.get("accessAccount"), params.get("Cookie"), params.get("refreshAPI"));
        Assert.assertTrue(isStepTrue, "Login verification failed");
        if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
            Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
            isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
            Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");
        }
        isStepTrue = homePage.bookmarkStoryLoggedInUser();
        //Assert.assertTrue(isStepTrue, "Bookmark Story for Logged In User verification failed");
        sa.assertTrue(isStepTrue, "Bookmark Story for Logged In User verification failed");
        sa.assertAll();
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Facebook Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1849(ios_native) :Validate the bookmark functionality before login")
    @Test
    public void VerifyBookmarkFunctionalityBeforeLogin() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyBookmarkFunctionalityBeforeLogin");
        boolean isStepTrue = bookmarkPage.checkBookmarkFunctionalityRedirectionToLoginPage();
        Assert.assertTrue(isStepTrue, "Bookmark Story Functionality verification failed********");
    }

    @Author(name = "Giridhar Raj,Gulshan Tomar")
    @Description("QAAUT-1883(android_native),QAAUT-1878(ios_native):: Verify the Bookmark functionality by completing the Login process")
    @Test
    public void VerifyBookmarkFunctionalityAfterLogin() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyBookmarkFunctionalityAfterLogin");
        isStepTrue = bookmarkPage.checkBookmarkFunctionalityRedirectionAfterLogin(params.get("email"), params.get("password"));
        Assert.assertTrue(isStepTrue, "Bookmark Story Functionality verification failed********");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1890(ios_native):: Verify the Bookmark functionality by completing the Login process as subscribed user")
    @Test
    public void VerifyBookmarkFunctionalityAsLoginSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyBookmarkFunctionalityAsLoginSubscribedUser");
        isStepTrue = bookmarkPage.checkBookmarkFunctionalityRedirectionAsSubscribedUser(params.get("email"), params.get("password"));
        Assert.assertTrue(isStepTrue, "Bookmark Story Functionality subscribed user verification failed********");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1908(ios_native):: Verify the Bookmark functionality on story detail page")
    @Test
    public void VerifyBookmarkButtonOnStoryDetailPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyBookmarkButtonOnStoryDetailPage");
        isStepTrue = bookmarkPage.checkBookmarkFunctionalityOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Bookmark Story detail page verification failed********");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1910,1911,1912(ios_native), QAAUT-1916,1917,1918(android_native):: Verify the Bookmark page,empty list and empty image")
    @Test
    public void verifyBookmarkPageAndEmptyListAndEmptyImageForNonLoggedUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBookmarkPageAndEmptyListAndEmptyImageForNonLoggedUser");
        isStepTrue = bookmarkPage.checkBookmarkPageEmptyForNonLoggedUser();
        Assert.assertTrue(isStepTrue, "Bookmark page verification failed********");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1913(ios_native):: Verify the Bookmark Story on Bookmark page")
    @Test
    public void VerifyBookmarkStoryOnBookmarkPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyBookmarkStoryOnBookmarkPage");
        isStepTrue = bookmarkPage.checkBookmarkStoryOnBookmarkPage(params.get("email"), params.get("password"));
        Assert.assertTrue(isStepTrue, "Bookmark Story on Bookmark page verification failed********");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }
}

