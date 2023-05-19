package Subscription.LiveMintTest;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DesktopBase;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.Subscription.LiveMint.genericPages.CommonHomePage;
import com.pages.Subscription.LiveMint.genericPages.CommonLoginPage;
import com.pages.Subscription.LiveMint.genericPages.CommonManageSubscriptionPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SignUpVerificationTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    CommonFunctionsWeb commonFunctionsWeb;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("######in before method##########");
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Alok Thakur")
    @Description("SUB-T6168 (desktop_web): Verify SignUp Using OTP on livemint")
    @Test()
    public void verifyOTPSignUp()
    {
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyOTPSignUp");
        String email ="T_" + System.currentTimeMillis()+"@yopmail.com";
        boolean isStepTrue;
        isStepTrue= homePage.clickSignInButton();
        Assert.assertTrue(isStepTrue,"SignIn button not clicked");
        isStepTrue= loginPage.enterLoginTextBox(email);
        Assert.assertTrue(isStepTrue,"Email not entered on login page");
        isStepTrue= loginPage.clickContinueButton();
        Assert.assertTrue(isStepTrue,"Continue button on login page not clicked");
        isStepTrue=loginPage.fetchOTPandType(email, paramsMap.get("otpAPI"),paramsMap.get("accessAccount"));
        Assert.assertTrue(isStepTrue,"OTP not entered during signup");
        isStepTrue=loginPage.clickDoThisLater();
        Assert.assertTrue(isStepTrue,"Click failed on clickDoThisLater");
        isStepTrue=  homePage.isMyAccountPresent();
        Assert.assertTrue(isStepTrue, "My Account not showing up after Signup");
    }

    @AfterMethod
    public void AfterMethod()
    {
        homePage.logout();
        globalVars.getWebDriver().manage().deleteAllCookies();
    }


}
