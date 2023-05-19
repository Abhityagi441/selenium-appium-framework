package HT_TECH;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HT_TECH.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {
    private static CommonLoginPage loginPage;
    GlobalVars globalVars=GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod(){
        loginPage=CommonLoginPage.getInstance();
    }

    @Author(name = "Farheen Naaz")
    @Description("Sanity : To verify Login With Email And Password")
    @Test
    public void verifyLoginWithEmailAndPassword() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

    }
}
