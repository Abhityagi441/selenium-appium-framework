package SSO;

import com.annotation.Author;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.SSO.AbstractLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

public class LoginTest extends BaseTest {
    private static AbstractLoginPage loginPage;
    GlobalVars globalVars;

    @BeforeTest
    @Parameters("application")
    public void initialization(String application){
        System.out.println("----------- Inside initialization in BeforeTest ----------");
        globalVars=GlobalVars.getInstance();
        globalVars.setApplicationName(application);
        DriverController driverController = DriverController.getInstance();
        driverController.navigateToApplicationHomePage(false);
    }

    @BeforeMethod
    public void beforeMethod(){
        loginPage=AbstractLoginPage.getInstance();
    }

    @Author(name = "Ataur Rahman")
    @Test
    public void verifyLoginWithGoogle() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithGoogle");

        isStepTrue = loginPage.loginWithGoogle(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));

        Assert.assertTrue(isStepTrue, "Login with google account failed");

        isStepTrue = loginPage.logout();

        Assert.assertTrue(isStepTrue, "Logout from google account failed!!");
    }

    @Author(name = "Ataur Rahman")
    @Test
    public void verifyLoginWithFacebook() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithFacebook");

        isStepTrue = loginPage.loginWithFacebook(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));

        Assert.assertTrue(isStepTrue, "Login with Facebook account failed");
        isStepTrue = loginPage.logout();

        Assert.assertTrue(isStepTrue, "Logout from Facebook failed!!");
    }


    @Author(name = "Bhupesh Mittal")
    @Test
    public void verifyLoginWithEmailAndPassword() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");

        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));

        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = loginPage.logout();

        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");

    }

    @Author(name = "Ankit Mittal")
    @Test
    public void verifyLoginWithEmailOTP() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTP");

        isStepTrue = loginPage.loginWithOTP(paramsMap.get("email"), paramsMap.get("apiURI"), paramsMap.get("auth"), paramsMap.get("mode"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with OTP failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with OTP failed!!");

    }

    @Author(name = "Ankit Mittal")
    @Test
    public void verifyLoginWithMobileOTP() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithMobileOTP");
        isStepTrue = loginPage.loginWithOTP(paramsMap.get("mobile"), paramsMap.get("apiURI"), paramsMap.get("auth"), paramsMap.get("mode"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with OTP failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with OTP failed!!");

    }

    @Author(name = "Ataur Rahman")
    @Test
    public void verifyLoginWithAppleID() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithAppleID");
        isStepTrue = loginPage.loginWithAppleID(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Apple ID failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Apple ID failed!!");
    }

    @Author(name = "Ataur Rahman")
    @Test
    public void verifyLoginWithMobileAndPassword() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithMobileAndPassword");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("phone"), paramsMap.get("password"), paramsMap.get("expectedUserName"));

        Assert.assertTrue(isStepTrue, "Login with Mobile and Password Failed");

        isStepTrue = loginPage.logout();

        Assert.assertTrue(isStepTrue, "Logout with Mobile and Password Failed!!");
    }

}
