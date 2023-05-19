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


public class SignInVerificationTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    private static CommonManageSubscriptionPage manageSubscriptionPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    CommonFunctionsWeb commonFunctionsWeb;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("######in before method##########");
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        manageSubscriptionPage = CommonManageSubscriptionPage.getInstance();
    }

    @Author(name = "Alok Thakur")
    @Description("SUB-T6167 (desktop_web): Verify SignIn Using OTP")
    @Test()
    public void verifyOTPSignIn()
    {
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyOTPSignIn");
        boolean isStepTrue;
        isStepTrue= homePage.clickSignInButton();
        Assert.assertTrue(isStepTrue,"SignIn button not clicked");
        isStepTrue= loginPage.enterLoginTextBox(paramsMap.get("Email"));
        Assert.assertTrue(isStepTrue,"Email not entered on login page");
        isStepTrue= loginPage.clickContinueButton();
        Assert.assertTrue(isStepTrue,"Continue button on login page not clicked");
        isStepTrue=loginPage.enterOTPwithRefresh(paramsMap.get("Email"),paramsMap.get("otpRefreshAPI"),paramsMap.get("otpAPI"),paramsMap.get("accessAccount"));
        Assert.assertTrue(isStepTrue,"OTP not entered");
        isStepTrue=  homePage.isMyAccountPresent();
        Assert.assertTrue(isStepTrue, "My Account not showing up after login");
    }


    @Author(name = "Alok Thakur")
    @Description("SUB-T6165 (desktop_web): Verify SignIn button redirecting to  Login Page")
    @Test()
    public void verifySignInRedirection()
    {   boolean isStepTrue;
        isStepTrue= homePage.clickSignInButton();
        Assert.assertTrue(isStepTrue,"SignIn button not clicked");
        isStepTrue= loginPage.isLoginPageTextPresent();
        Assert.assertTrue(isStepTrue,"Redirection to login page failed after clicking SignIn ");
    }

    @Author(name = "Alok Thakur")
    @Description("SUB-T6166 (desktop_web): Verify redirection to OTP page after entering email and clicking continue button ")
    @Test()
    public void verifyRedirectionToOtpPage()
    {   boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRedirectionToOtpPage");
        isStepTrue= homePage.clickSignInButton();
        Assert.assertTrue(isStepTrue,"SignIn button not clicked");
        isStepTrue= loginPage.enterLoginTextBox(paramsMap.get("Email"));
        Assert.assertTrue(isStepTrue,"Email not entered on login page");
        isStepTrue= loginPage.clickContinueButton();
        Assert.assertTrue(isStepTrue,"Continue button on login page not clicked");
        isStepTrue=loginPage.isOTPBox1Present();
        Assert.assertTrue(isStepTrue,"After clicking continue button on login page redirection to OTP page failed");
    }

    @Author(name = "Alok Thakur")
    @Description("SUB-T6169 (desktop_web): Verify facebook signin")
    @Test()
    public void verifyFacebookSignIn()
    {   boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyFacebookSignIn");
        isStepTrue= homePage.clickSignInButton();
        Assert.assertTrue(isStepTrue,"SignIn button not clicked");
        isStepTrue= loginPage.facebookLogin(paramsMap.get("emailOrPhone"),paramsMap.get("password"));
        Assert.assertTrue(isStepTrue,"Login via facebook verification failed");
        isStepTrue=  homePage.isMyAccountPresent();
        Assert.assertTrue(isStepTrue, "My Account not showing up after login");
    }


    @AfterMethod
    public void AfterMethod()
    {
        homePage.logout();
        globalVars.getWebDriver().manage().deleteAllCookies();
     }


}
