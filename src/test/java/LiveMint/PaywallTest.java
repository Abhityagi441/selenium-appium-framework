package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class PaywallTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam, Manoj Patil")
    @Description("Updated by Kapil Sisodia : QAAUT-784(web), 834(AMP-Android), 795(MWeb-Android), 806(MWeb-IOS), 815(android_native), 844(AMP-IOS):Verify non subscribed users should see paywall on premium stories")
    @Test
    public void verifyNonSubscribedUserPaywall() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNonSubscribedUserPaywall");
        isStepTrue = homePage.nonSubscribedUserPaywall(paramsMap.get("apiURL"));
        Assert.assertTrue(isStepTrue, "Paywall  is empty");

    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-824(ios_native):Validate the mint functionality for subscribed user")
    @Test
    public void verifySubscribedUserPaywall() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(params.get("email"), params.get("apiURI"), params.get("accessAccount") , params.get("Cookie"),params.get("refreshAPI"),params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");
        isStepTrue = homePage.subscribedUserPaywall();
        Assert.assertTrue(isStepTrue, "Subscribed user Paywall verification failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Facebook Failed!!");
    }
}

