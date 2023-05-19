package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest  extends BaseTest {
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod(){
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Kapil Sisodia")
    @Description("Method to login with OTP in LM web")
    @Test
    public void verifyLoginWithEmailAndOTP() throws InterruptedException {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndOTP");
        isStepTrue = loginPage.loginWithOTP(params.get("email"), params.get("apiURI"), params.get("accessAccount") , params.get("Cookie"),params.get("refreshAPI"));
        Assert.assertTrue(isStepTrue, "Login with Email and OTP Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Ataur Rahman")
    @Description("upadted by Kapil Sisoida")
    @Test
    public void verifyLoginWithEmailAndPassword() throws InterruptedException {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }    @Author(name = "Shakeel Alam,Ravikumar Makam, Manoj Patil")
    @Description("QAAUT-775(Web), 786(MWeb-Android), QAAUT-797(MWeb-IOS), 817(ios_native), 808(android_native):Validate the Signin via Facebook")
    @Test
    public void verifyLoginWithFacebook() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithFacebook");

        isStepTrue = loginPage.loginWithFacebook(params.get("email"), params.get("password"), params.get("expectedUserName"),params.get("htAccountsURL"));
        Assert.assertTrue(isStepTrue, "Login with Facebook Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Facebook Failed!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1282(ios_native):Verify the Sign in link")
    @Test
    public void verifyLoginWithNonSuscribedUser() throws InterruptedException {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithNonSuscribedUser");
        isStepTrue = loginPage.loginWithNonSuscribedUser(paramsMap.values().toArray(new String[5]));
        Assert.assertTrue(isStepTrue, "verifyLoginWithNonSuscribedUser Failed");

    }
    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1283(ios_native):Verify the Sign in link redirection")
    @Test
    public void verifySignInLinkRedirection() throws InterruptedException {
        boolean isStepTrue;
        isStepTrue = loginPage.checkSignInLinkRedirection();
        Assert.assertTrue(isStepTrue, "verifySignInLinkRedirection Failed");

    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1319:Validate plan details in my account")
    @Test
    public void verifyLoginWithSuscribedUser() throws InterruptedException {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithSuscribedUser");
        isStepTrue = loginPage.loginWithSubScribedUser(paramsMap.values().toArray(new String[3]));
        isStepTrue &= loginPage.verifyPlanDetails();
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1713:(Android_native): Verify the Subscribed User login")
    @Test
    public void verifySubscribedUserLogin() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");;
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

}