package BlankPaper.login;

import com.annotation.Author;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.BlankPaper.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {
    private static CommonLoginPage loginPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        loginPage= CommonLoginPage.getInstance();

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyLoginWithGoogle() {
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsData1("verifyLoginWithGoogle");

//        if(globalVars.isProdRun()) {
//            isStepTrue = loginPage.loginWithGoogle(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
//            Assert.assertTrue(isStepTrue, "Login with google account failed");
//        }
        isStepTrue = loginPage.loginWithId(paramsMap.get("userId"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with google account failed");
    }

}
