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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginWithPassTest extends BaseTest {
    static CommonLoginPage loginPage;
    GlobalVars globalVars;

    @BeforeTest
    public void resetLogin() {
        CommonLoginPage.resetCommonLoginPage();
    }

    @BeforeClass
    public void initialization() {
        globalVars = DriverController.setup(Constants.LIVE_HINDUSTAN);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = CommonLoginPage.getInstance();
    }


    @Author(name = "Ishank Khatri")
    @Description("Sanity || QAAUT-5952(LH-Web),QAAUT-5956(Android_Mweb),QAAUT-5955(IOS_Mweb): To verify Login With Email And Password")
    @Test
    public void verifyLoginWithEmailAndPassword() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password failed");

        /*isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");*/
    }


}
