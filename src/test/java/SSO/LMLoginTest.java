package SSO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonExplorePage;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonPremiumStoryPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LMLoginTest extends BaseTest {
    private static CommonLoginPage loginPage;
    private static CommonPremiumStoryPage premiumStoryPage;
    private static CommonExplorePage explorePage;

    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        loginPage = CommonLoginPage.getInstance();
        premiumStoryPage=CommonPremiumStoryPage.getInstance();
        explorePage = CommonExplorePage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6199(android_native): Verify all login option")
    @Test
    public void verifyAllLoginOption() {
        boolean isStepTrue = loginPage.checkAllLoginOption();
        Assert.assertTrue(isStepTrue, "all login option verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6200(android_native): Verify login with email")
    @Test
    public void verifyLoginWithEmail() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        boolean isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6210(android_native): verify login from premium article paywalls")
    @Test
    public void verifyLoginFromPremiumArticlePaywall() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        boolean isStepTrue = premiumStoryPage.clickOnSignInFromPaywall();
        Assert.assertTrue(isStepTrue, "signIn paywall verification failed*****");

        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "NonSubscribed user login verification Failed*******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6211(android_native): Verify sign in from explore menu")
    @Test
    public void verifySignInFromExploreMenu() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        boolean isStepTrue =explorePage.checkSignInButtonFromExplore();
        Assert.assertTrue(isStepTrue, "signIn explore verification failed*****");

        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "NonSubscribed user login verification Failed*******");

        isStepTrue =explorePage.checkBackExplorePageToHomePage();
        Assert.assertTrue(isStepTrue, "home page verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6220(android_native): Verify sign in from Top nav bar")
    @Test
    public void verifySignInFromTopNavBar() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "NonSubscribed user login verification Failed*******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6221(android_native): Verify sign in from Top nav bar")
    @Test
    public void verifySignInFromEpaper() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = explorePage.checkSignInButtonFromEpaper();
        Assert.assertTrue(isStepTrue, "signIn epaper verification failed*****");

        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "NonSubscribed user login verification Failed*******");

        isStepTrue = explorePage.checkBackToHomePageFromEpaperSubscribeNow();
        Assert.assertTrue(isStepTrue, "homepage verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6222(android_native): Verify sso sign in from Freemium paywall")
    @Test
    public void verifySignInFromFreemiumPaywall() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = premiumStoryPage.checkSignInFromFreemium();
        Assert.assertTrue(isStepTrue, "signIn from freemium paywall verification failed*****");

        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "NonSubscribed user login verification Failed*******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar raj")
    @Description("QAAUT-6234(android native): To verify SignIn functionality via Google login")
    @Test
    public void verifyLoginWithGoogle() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithGoogle");
        isStepTrue = loginPage.loginWithGoogle(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Google account failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Giridhar raj")
    @Description("QAAUT-6246(android native): To verify SignIn functionality via Facebook login")
    @Test
    public void verifyLoginWithFacebook() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithFacebook");
        isStepTrue = loginPage.loginWithFacebook(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Facebook account failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from Facebook failed!!");

    }


}