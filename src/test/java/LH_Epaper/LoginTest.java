package LH_Epaper;

import com.annotation.Author;
import com.base.DriverController;
import com.pages.LH_Epaper.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class LoginTest {
    private static CommonLoginPage loginPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization(){
        globalVars = DriverController.setup(Constants.LH_E_PAPER);
    }

    @BeforeMethod
    public void beforeMethod(){
        loginPage= CommonLoginPage.getInstance();
    }

    @Author(name = "Ankit Mittal")
    @Test
    public void verifyLoginWithMobileOTP() {
        boolean isStepTrue;
        String[] params = globalVars.getParamsDataSingleProperty("verifyLoginWithMobileOTP");
        String email = params[0];
        String apiURI = params[1];
        String auth = params[2];
        String mode = params[3];
        String expectedUserName = params[4];
        isStepTrue = loginPage.loginWithOTP(email, apiURI, auth,mode, expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with OTP failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with OTP failed!!");

    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyLoginWithGoogle() {
        boolean isStepTrue;
        String[] params=globalVars.getParamsDataSingleProperty("verifyLoginWithGoogle");
        String email=params[0];
        String password=params[1];
        String expectedUserName=params[2];
        isStepTrue=loginPage.loginWithGoogle(email, password, expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with google account failed");

        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from google account failed!!");
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyLoginWithFacebook() throws InterruptedException {
        boolean isStepTrue;
        String[] params=globalVars.getParamsDataSingleProperty("verifyLoginWithFacebook");
        String email=params[0];
        String password=params[1];
        String expectedUserName=params[2];
        isStepTrue=loginPage.loginWithFacebook(email, password, expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with Facebook account failed");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from Facebook failed!!");
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyLoginWithEmailAndPassword(){
        boolean isStepTrue;
        String[] params = globalVars.getParamsDataSingleProperty("verifyLoginWithEmailAndPassword");
        String email = params[0];
        String password = params[1];
        String expectedUserName=params[2];
        isStepTrue = loginPage.loginWithPassword(email, password, expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Password Failed!!");
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyLoginWithEmailOTP(){
        boolean isStepTrue;
        String[] params = globalVars.getParamsDataSingleProperty("verifyLoginWithEmailOTP");
        String email = params[0];
        String apiURI = params[1];
        String auth = params[2];
        String mode = params[3];
        String expectedUserName = params[4];
        isStepTrue = loginPage.loginWithOTP(email, apiURI, auth,mode, expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with OTP failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with OTP failed!!");
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyLoginWithAppleID(){
        boolean isStepTrue;
        String[] params = globalVars.getParamsDataSingleProperty("verifyLoginWithAppleID");
        String email = params[0];
        String password = params[1];
        String expectedUserName=params[2];
        isStepTrue = loginPage.loginWithAppleID(email, password,expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with Apple ID failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Apple ID failed!!");
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyLoginWithMobileAndPassword(){
        boolean isStepTrue;
        String[] params = globalVars.getParamsDataSingleProperty("verifyLoginWithMobileAndPassword");
        String phone = params[0];
        String password = params[1];
        String expectedUserName=params[2];
        isStepTrue = loginPage.loginWithPassword(phone, password, expectedUserName);
        Assert.assertTrue(isStepTrue, "Login with Mobile and Password Failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Password Failed!!");

    }

    @AfterSuite
    public void closeDriver(ITestContext context){
        //DriverController.tearDownSuite(context);
    }
}