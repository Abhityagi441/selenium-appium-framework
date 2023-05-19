package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {
    static CommonLoginPage loginPage;
    GlobalVars globalVars;

    @BeforeClass
    public void initialization() {
        globalVars = DriverController.setup(Constants.LIVE_HINDUSTAN);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Ishank Khatri")
    @Description("Sanity || QAAUT-5951(LH-Web),QAAUT-5953(Android_Mweb),QAAUT-5954(IOS_Mweb): To verify Login With Email And Password")
    @Test
    public void verifyLoginWithGoogle() {
        boolean isStepTrue;

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from google account failed!!");

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithGoogle");
        isStepTrue = loginPage.loginWithGoogleAccount(params.get("email"), params.get("password"), params.get("expectedUserName"), params.get("backupCodeWeb"), params.get("backupCodeAndroidWeb"), params.get("backupCodeIosWeb"));
        Assert.assertTrue(isStepTrue, "Login with google account failed");
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyLoginWithFacebook() throws InterruptedException {
        boolean isStepTrue;

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from Facebook failed!!");

        String[] params = globalVars.getParamsDataSingleProperty("verifyLoginWithFacebook");
        String email = params[0];
        String password = params[1];
        String expectedUserName = params[2];
        isStepTrue = loginPage.loginWithFacebook(email, password, expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with Facebook account failed");
    }

    /*@Author(name = "Ishank Khatri")
    @Description("Sanity || QAAUT-5952(LH-Web),QAAUT-5956(Android_Mweb),QAAUT-5955(IOS_Mweb): To verify Login With Email And Password")
    @Test
    public void verifyLoginWithEmailAndPassword() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password failed");

        *//*isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");*//*
    }*/


}
