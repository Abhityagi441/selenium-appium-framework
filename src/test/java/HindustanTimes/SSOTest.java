package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonSSOPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SSOTest extends BaseTest {
	private static CommonSSOPage ssoPage;
	GlobalVars globalVars= GlobalVars.getInstance();

	@BeforeMethod
	public void beforeMethod() {
		ssoPage = CommonSSOPage.getInstance();
	}

	@Author(name = "Shakeel Alam")
	@Description("QAAUT-1665, QAAUT-1667(iOS native)")
	@Test
	public void verifyInvalidSSOMobileEmail() {
		boolean isStepTrue;
		Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyInvalidSSOMobileEmail");
		isStepTrue = ssoPage.checkInvalidSSOMobileEmail(params.get("email"),params.get("mobile"));
		Assert.assertTrue(isStepTrue, "SSO Page Verification failed");
	}
	@Author(name = "Shakeel Alam")
	@Description("QAAUT-1669(iOS native):Verify that tapping on continue button on the SSO page Login page is displayed where user can enter the password")
	@Test
	public void verifyLoginSuccessful(){
		boolean isStepTrue;
		Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
		isStepTrue = ssoPage.checkLoginSuccessful(params.get("email"), params.get("password"), params.get("expectedUserName"));
		Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
		isStepTrue = ssoPage.logout();
		Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
	}
	@Author(name = "Shakeel Alam")
	@Description("QAAUT-1666, QAAUT-1675, QAAUT-1865(iOS native) : Verify that tapping on the Forgot Password option, Validate OTP page is dispayed")
	@Test
	public void verifyForgotPasswordPage() {
		boolean isStepTrue;
		Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
		isStepTrue = ssoPage.checkForgotPassword(params.get("email"));
		Assert.assertTrue(isStepTrue, "SSO Page Verification failed");
	}
}
