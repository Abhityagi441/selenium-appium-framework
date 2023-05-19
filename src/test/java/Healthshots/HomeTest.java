package Healthshots;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.Healthshots.generic.CommonHomePage;
import com.pages.Healthshots.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class HomeTest extends BaseTest {
	private static CommonHomePage homePage;
	private static CommonLoginPage loginPage;
	GlobalVars globalVars= GlobalVars.getInstance();


	@BeforeMethod
	public void beforeMethod() {
		homePage = CommonHomePage.getInstance();
		loginPage = CommonLoginPage.getInstance();
	}


	@Author(name = "Manisha Bhagat")
	@Description(": To verify the Share of Latest Story on Facebook")
	@Test
	public void verifyFacebookSharingFromLatestStory() {
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyFacebookSharingFromLatestStory");
		isStepTrue = homePage.checkFacebookSharingFromLatestStory(paramsMap.get("email"), paramsMap.get("password"));
		Assert.assertTrue(isStepTrue, "Sharing Story with Facebook is failed");
	}
	@Author(name = "Manisha Bhagat")
	@Description(": To verify the Share of Latest Story on Twitter")
	@Test
	public void verifyTwitterSharingFromLatestStory() {
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyTwitterSharingFromLatestStory");
		isStepTrue = homePage.checkTwitterSharingFromLatestStory(paramsMap.get("email"), paramsMap.get("password"));
		Assert.assertTrue(isStepTrue, "Sharing Story with Facebook is failed");
	}
}
