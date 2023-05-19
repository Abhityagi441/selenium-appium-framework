package SmartCast;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.SmartCast.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {
    private static CommonLoginPage loginPage;
    GlobalVars globalVars= GlobalVars.getInstance();


    @BeforeMethod
    public void beforeMethod(){
        loginPage=CommonLoginPage.getInstance();
    }

    @Author(name = "Chaitanya Shastry")
    @Description("QAAUT-1040,QAAUT-1152(Android-mweb): Verify Login with Facebook functionality")
    @Test
    public void verifyLoginWithFacebook(){
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithFacebook");
        isStepTrue=loginPage.loginWithFacebook(paramsMap.get("phone"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Facebook and Password Failed");
        isStepTrue = loginPage.signOut();
        Assert.assertTrue(isStepTrue, "Logout with Facebook and Password Failed!!");

    }

    @Author(name = "Chaitanya Shastry")
    @Description("QAAUT-935,QAAUT-1150(Android-mweb): To verify Login with Email functionality of HT SmartCast")
    @Test
    public void verifyLoginWithEmailAndPassword(){
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue=loginPage.loginWithEmailAndPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = loginPage.signOut();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Chaitanya Shastry")
    @Description("QAAUT-953,QAAUT-1151(Android-mweb): To verify Login with Mobile No. functionality of HT SmartCast")
    @Test
    public void verifyLoginWithMobileAndPassword(){
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithMobileAndPassword");
        isStepTrue=loginPage.loginWithMobileAndPassword(paramsMap.get("phone"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Mobile and Password Failed");
        isStepTrue = loginPage.signOut();
        Assert.assertTrue(isStepTrue, "Logout with Mobile and Password Failed!!");
    }

}
