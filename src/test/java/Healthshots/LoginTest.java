package Healthshots;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.Healthshots.generic.CommonLoginPage;
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

    @Author(name = "Manisha Bhagat")
    @Description("Verify Login with Facebook functionality of Healthshots")
    @Test
    public void verifyLoginWithFacebook(){
        boolean isStepTrue;
        Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithFacebook");
        isStepTrue=loginPage.loginWithFacebook(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Facebook and Password Failed");
        isStepTrue = loginPage.signOut();
        Assert.assertTrue(isStepTrue, "Logout with Facebook and Password Failed!!");

    }

    @Author(name = "Manisha Bhagat")
    @Description("To verify Login with Email functionality of Healthshots")
    @Test
    public void verifyLoginWithEmailAndPassword(){
        boolean isStepTrue;
      Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
       isStepTrue=loginPage.loginWithEmailAndPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
      //  isStepTrue=loginPage.loginWithEmailAndPassword(defaultusername, defaultpassword,defaultexpectedusername );
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = loginPage.signOut();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Manisha Bhagat")
    @Description("To verify Login with Mobile No. functionality of Healthshotst")
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
