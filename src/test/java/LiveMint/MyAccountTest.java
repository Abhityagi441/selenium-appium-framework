package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class MyAccountTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Manoj Patil, Ravikumar Makam")
    @Description("QAAUT-785(Web), 796(MWeb-Android), 825(ios_native), 816(android_native):Validate the myaccount functionality")
    @Test
    public void verifyMyAccountFunctionality() {
        boolean isStepTrue;
        SoftAssert sa = new SoftAssert();
        if(globalVars.getPlatformName().contains("web"))
        {
            Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndOTP");
            isStepTrue = loginPage.loginWithOTP(params.get("email"), params.get("apiURI"), params.get("accessAccount") , params.get("Cookie"),params.get("refreshAPI"));
            Assert.assertTrue(isStepTrue, "user login verification Failed*******");
            Map<String, String> params2
                    = globalVars.getParamsDataSinglePropertySingleProperty("verifyMyAccountFunctionalityWeb");
            isStepTrue = homePage.myAccountFunctionality(params2.get("password"), params2.get("newPassword"),params2.get("expectedUserName"),params2.get("newName"),params2.get("email"), params2.get("manageProfileURL"));
            sa.assertTrue(isStepTrue, "My Account Functionality verification failed******");
            sa.assertAll();
        }
        else if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
            Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
            isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
            Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");
            Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMyAccountFunctionality");
            isStepTrue = homePage.myAccountFunctionality(params.get("password"), params.get("newPassword"),params.get("expectedUserName"),params.get("newName"),params.get("email"), params.get("manageProfileURL"));
            Assert.assertTrue(isStepTrue, "My Account Functionality verification failed");

        }
        else {
            Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMyAccountFunctionality");
            isStepTrue = loginPage.loginWithOTP(params.get("email"), params.get("apiURI"), params.get("accessAccount"), params.get("Cookie"), params.get("refreshAPI"));
            Assert.assertTrue(isStepTrue, "user login verification Failed*******");
            isStepTrue = homePage.myAccountFunctionality(params.get("password"), params.get("newPassword"),params.get("expectedUserName"),params.get("newName"),params.get("email"), params.get("manageProfileURL"));
            Assert.assertTrue(isStepTrue, "My Account Functionality verification failed");
        }
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout verification failed");
    }
}



