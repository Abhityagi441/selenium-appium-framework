package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {
    private static CommonLoginPage loginPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = CommonLoginPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-979, QAAUT-994(Android-mweb): Verify that user is able to login/sign up in the HT Auto website")
    @Test
    public void verifyLoginWithMobileAndPassword() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithMobileAndPassword");
        isStepTrue = loginPage.loginWithMobileAndPassword(params.get("mobile"), params.get("password"), params.get("expectedUserName"));

        Assert.assertTrue(isStepTrue, "Login with Mobile and Password Failed");

        isStepTrue = loginPage.logout();

        Assert.assertTrue(isStepTrue, "Logout with Mobile and Password Failed!!");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1039: Verify that user is able to login/sign up in the HT Auto website(Facebook)")
    @Test
    public void verifyLoginWithFacebook() {
        boolean isStepTrue = true;

        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithFacebook");

        isStepTrue &= loginPage.loginWithFacebook(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Facebook and Password Failed!");

        isStepTrue &= loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Facebook and password failed.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1038: Verify that user is able to login/sign up in the HT Auto website(Google Login)")
    @Test
    public void verifyLoginWithGoogle() {
        boolean isStepTrue = true;

        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithGoogle");
        isStepTrue &= loginPage.loginWithGoogleAndPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Google and Password Failed");

        isStepTrue &= loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Google Failed!!");

    }


}