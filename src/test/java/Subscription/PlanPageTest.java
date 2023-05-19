package Subscription;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlanPageTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;

    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6196(android_native): Verify the plan page shows all the active plans")
    @Test
    public void verifyPlanPageAllActivePlan() {
        boolean isStepTrue = homePage.checkPlanPageAllActivePlan();
        Assert.assertTrue(isStepTrue, "plan page verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6197(android_native): Verify the plan page apply coupon and sign-in option")
    @Test
    public void verifyApplyCouponAndSignInOption() {
        boolean isStepTrue = homePage.checkApplyCouponAndSignInOption();
        Assert.assertTrue(isStepTrue, "apply coupon verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6212(android_native): Verify purchasing a subs in non-logged in mode - user should be prompted to login first")
    @Test
    public void verifyLoginInPage() {
        boolean isStepTrue = homePage.checkLoginInPage();
        Assert.assertTrue(isStepTrue, "login page verification failed*****");
    }


}