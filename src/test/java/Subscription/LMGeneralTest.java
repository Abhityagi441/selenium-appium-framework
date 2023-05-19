package Subscription;

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

public class LMGeneralTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    private static CommonExplorePage explorePage;
    private static CommonPremiumStoryPage premiumStoryPage;

    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        explorePage = CommonExplorePage.getInstance();
        premiumStoryPage=CommonPremiumStoryPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5981(android_native): Verify app launched successfully")
    @Test
    public void verifyAppLaunchedSuccessfully() {
        boolean isStepTrue = homePage.checkAppLaunch();
        Assert.assertTrue(isStepTrue, "app not launched verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5984(android_native): Verify header elements")
    @Test
    public void verifyHeaderElements() {
        boolean isStepTrue = homePage.checkHeaderElements();
        Assert.assertTrue(isStepTrue, "header elements verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6195(android_native): verify Premium icon on the bottom of the page")
    @Test
    public void verifyPremiumIconOnBottom() {
        boolean isStepTrue = homePage.checkPremiumIconOnBottom();
        Assert.assertTrue(isStepTrue, "Premium icon verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6194(android_native): verify navigation from each tab on the header")
    @Test
    public void verifyHeaderNavigationOfEachTab() {
        boolean isStepTrue = homePage.checkHeaderNavigationOfEachTab();
        Assert.assertTrue(isStepTrue, "header navigation verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6198(android_native): verify Open Premium stories and validate the paywall")
    @Test
    public void verifyPaywallForPremiumStories() {
        boolean isStepTrue = premiumStoryPage.checkPaywallForPremiumStories();
        Assert.assertTrue(isStepTrue, "paywall verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6218(android_native): verify Home Page is populated as expected")
    @Test
    public void verifyHomePageAsExpected() {
        boolean isStepTrue = homePage.checkHomePageAsExpected();
        Assert.assertTrue(isStepTrue, "Homepage verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6217(android_native): verify User’s subs information should be available in my accounts section")
    @Test
    public void verifySubscriptionInformation() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        boolean  isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkSubscriptionInformation();
        Assert.assertTrue(isStepTrue, "Homepage verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6231(android_native): verify access to mint epaper for a subscribed user")
    @Test
    public void verifyMintEpaperSubscribedUser() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        boolean  isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = explorePage.checkEpaperPage();
        Assert.assertTrue(isStepTrue, "epaper page verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6231(android_native): verify the premium content for a subscribed user -")
    @Test
    public void verifyPremiumContentForSubscribedUser() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        boolean  isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue =premiumStoryPage.checkNoPaywall();
        Assert.assertTrue(isStepTrue, "No paywall verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6249(android_native): Subscribe Now options should get removed from all the funnels -")
    @Test
    public void verifySubscribeNowGetRemoved() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        boolean  isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed");

        isStepTrue =explorePage.checkSubscribeNowButtonFromEpaper();
        Assert.assertTrue(isStepTrue, "subscribe Now btn on epaper verification failed");

        isStepTrue =premiumStoryPage.checkSubscribedBtnNotDisplayedOnPaywall();
        Assert.assertTrue(isStepTrue, "subscribe Now btn on premium verification failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

}