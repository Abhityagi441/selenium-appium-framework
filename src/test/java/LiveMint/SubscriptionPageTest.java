package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonSubscriptionPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SubscriptionPageTest extends BaseTest {
    private static CommonSubscriptionPage subscriptionPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();


    @BeforeMethod
    public void beforeMethod() {
        subscriptionPage = CommonSubscriptionPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam,Gulshan Tomar")
    @Description("QAAUT-1315(ios_native):Verify navigation by clicking on subscribe in explore menu, QAAUT-1232(android_native):Verify navigation by clicking on subscribe from home page")
    @Test
    public void verifyPlanPage() {
        boolean isStepTrue;
        isStepTrue = subscriptionPage.checkPlanPage();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1233(android_native):Verify navigation by clicking on subscribe in explore menu")
    @Test
    public void verifySubscribeNavigation() {
        boolean isStepTrue;
        isStepTrue = subscriptionPage.checkSubscribeNavigation();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");

    }

    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1317(ios_native), QAAUT-1235:Validate all the plans should be visible and clickable for the user to subscribe")
    @Test
    public void verifyPlansVisible() {
        boolean isStepTrue;
        isStepTrue = subscriptionPage.checkPlansVisible();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
    }

    @Author(name = "Ravinder Singh, Gulshan Tomar")
    @Description("QAAUT-1316(ios_native) QAAUT-1234(android_native):Verify navigation by clicking on subscribe/collect your offer in story deails when paywall is visible")
    @Test
    public void verifyPlanPageFromPremiumStory() {
        boolean isStepTrue;
        isStepTrue = subscriptionPage.checkPremiumStoryPlansVisible();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1285(ios_native) : Verify the Subscribe link(un-subscribe user).")
    @Test
    public void verifySubscribeLink() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySubscribeLink");
        isStepTrue = loginPage.loginWithSubScribedUser(paramsMap.values().toArray(new String[3]));
        Assert.assertTrue(isStepTrue, "Login failed");
        isStepTrue = subscriptionPage.checkSubscribeLink();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1286(ios_native):Verify the Remove Ad option")
    @Test
    public void verifyRemoveAd() {
        boolean isStepTrue;
        isStepTrue = subscriptionPage.checkRemoveAd();
        Assert.assertTrue(isStepTrue, "Remove Ad redirection to Plan Page verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1289(ios_native) : Verify subscribed user (different story)")
    @Test
    public void verifySubscribedUserDifferentStory() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySubscribedUserDifferentStory");
        isStepTrue = subscriptionPage.checkNonLoggedInUserStories();
        isStepTrue = loginPage.loginWithSubScribedUser(paramsMap.values().toArray(new String[3]));
        Assert.assertTrue(isStepTrue, "Login failed");
        isStepTrue = subscriptionPage.checkSubscribedUserStories();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1288(ios_native) : Verify subscribed user (ad-free homepage)")
    @Test
    public void verifySubscribedUserIsAdFree() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySubscribedUserIsAdFree");
        isStepTrue=loginPage.loginWithSubScribedUser(paramsMap.values().toArray(new String[3]));
        Assert.assertTrue(isStepTrue, "Login failed");
        isStepTrue = subscriptionPage.checkSubscribedUserIsAdFree();
        Assert.assertTrue(isStepTrue, "Subscribed User Ad Free verification failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1237(android_native):Validate plan details in my account")
    @Test
    public void verifySubscriptionsPlanDetails() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = subscriptionPage.checkValidationOfSubscriptionsPlanDetails();
        Assert.assertTrue(isStepTrue, "Subscribing plan details verification failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Facebook Failed!!");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1236(android_native):Validate by subscribing to any plan listed on the plan page")
    @Test
    public void verifyPlansVisibleAndClickable() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyPlansVisibleAndClickable");
        isStepTrue = subscriptionPage.checkPlanVisibilityAndClickable();
        Assert.assertTrue(isStepTrue, "Subscribing to any plan verification failed");
    }

}

