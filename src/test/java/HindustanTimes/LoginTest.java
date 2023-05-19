package HindustanTimes;

import com.annotation.Author;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;
import com.annotation.Description;

import java.util.Map;

public class LoginTest extends BaseTest {
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();


    @BeforeMethod
    public void beforeMethod() {
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Ataur Rahman, Shakeel Alam")
    @Description("QAAUT-1613, 1617, 1619, 1620(ios), 1622(Covered in constructor of login page, Skip button is displayed after May Be Later is clicked)")
    @Test
    public void verifyLoginWithEmailAndPassword() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Ankit Mittal")
    @Test
    public void verifyLoginWithEmailOTP() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTP");
        isStepTrue = loginPage.loginWithOTP(params.get("email"), params.get("apiURI"), params.get("auth"), params.get("mode"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with OTP failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with OTP failed!!");

    }

    @Author(name = "Ataur Rahman")
    @Test
    public void verifyLoginWithMobileAndPassword() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithMobileAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("phone"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Mobile and Password Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Mobile and Password Failed!!");
    }

    @Author(name = "Sambath Kumar")
    @Description("QAAUT-572(android native),QAAUT-501(web),QAAUT-612(amp),QAAUT-524(mWeb),592(iOS), 634(iOSamp): To verify SignIn functionality via Facebook")
    @Test
    public void verifyLoginWithFacebook() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithFacebook");
        isStepTrue = loginPage.loginWithFacebook(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Facebook account failed");
    }

    @Author(name = "Sambath kumar")
    @Description("QAAUT-571(android native),QAAUT-500(web),QAAUT-523(mWeb),591(iOS): To verify SignIn functionality via Google login")
    @Test
    public void verifyLoginWithGoogle() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithGoogle");
        isStepTrue = loginPage.loginWithGoogle(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Google account failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Ankit Mittal")
    @Test
    public void verifyLoginWithMobileOTP() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithMobileOTP");
        isStepTrue = loginPage.loginWithOTP(params.get("mobile"), params.get("apiURI"), params.get("auth"), params.get("mode"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with OTP failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with OTP failed!!");

    }

    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1621(ios), QAAUT-1629(Android-native): Verify the redirection on tapping Forgot Password")
    @Test
    public void verifyForgotPassword() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyForgotPassword");
        isStepTrue = loginPage.forgotPassword(params.get("email"));
        Assert.assertTrue(isStepTrue, "Forgot Password Verification Failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1623(ios): Verify that tapping on the Generate OTP option, Validate OTP page is displayed")
    @Test
    public void verifyGenerateOTP() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyGenerateOTP");
        isStepTrue = loginPage.generateOTP(params.get("email"));
        Assert.assertTrue(isStepTrue, "Login with OTP failed");

    }

    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1634,1632(ios), QAAUT-1631(Android-Native):Verify that tapping on the Generate OTP option, Validate OTP page is displayed")
    @Test
    public void VerifyOTPPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyOTPPage");
        isStepTrue = loginPage.validateOTPPage(params.get("email"));
        Assert.assertTrue(isStepTrue, "Verify OTP Page is not displayed");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1626(Android-Native):Verify the redirection when user enters the valid password and tap on the Continue")
    @Test
    public void verifyPasswordRedirection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.checkPasswordRedirection(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Password Redirection Verfification Failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1709(Android-Native):Verify that when user tap on the Login option then Login or Register page is displayed")
    @Test
    public void verifyLoginOrRegisterPageDisplay() {
        boolean isStepTrue;
        isStepTrue = loginPage.checkLoginOrRegisterPageDisplay();
        Assert.assertTrue(isStepTrue, "Login or Register is not displaying.");
    }
    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1715, 1758(ios),QAAUT-1716(Android-native): Verify the redirection when user is logged in and tap on the Edit")
    @Test
    public void verifyEditProfileRedirection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = loginPage.checkEditProfileRedirection();
        Assert.assertTrue(isStepTrue, "Edit Profile Redirection Failed!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }
    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1708, 1721(iOS-Native),QAAUT-1722(Android-native):Verify the redirection on tapping back button on the Login or Register page")
    @Test
    public void verifyLoginOrRegisterPageDisplayBackRedirection() {
        boolean isStepTrue;
        isStepTrue = loginPage.checkLoginOrRegisterPageDisplayBackRedirection();
        Assert.assertTrue(isStepTrue, "Login or Register is not displaying.");
    }
    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1723(iOS-Native),QAAUT-1724(Android-Native):Verify that user is start typing the number then +91 will be added")
    @Test
    public void verifyCountryCodeAdded() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCountryCodeAdded");
        isStepTrue = loginPage.checkCountryCodeAdded(params.get("mobile"));
        Assert.assertTrue(isStepTrue, "+91 is not added");
    }
    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1762(ios): Verify that tapping on forgot password it should be redirected to the Validate OTP screen for registered mobile number user")
    @Test
    public void verifyForgotPasswordMobile() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyForgotPasswordMobile");
        isStepTrue = loginPage.forgotPasswordMobile(params.get("mobile"));
        Assert.assertTrue(isStepTrue, "Forgot Password Verification Failed");
    }
}
