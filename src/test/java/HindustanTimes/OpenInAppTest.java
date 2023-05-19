package HindustanTimes;


import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonOpenInAppPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class OpenInAppTest extends BaseTest {
    private static CommonOpenInAppPage openInAppPage;
	private static CommonLoginPage loginPage;
	GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod(){
        openInAppPage=CommonOpenInAppPage.getInstance();
		loginPage = CommonLoginPage.getInstance();
	}
    
    @Author(name = "Sambath Kumar")
	@Description("QAAUT-542(mWeb),QAAUT-628(amp), QAAUT-650(ios-amp): To verify Open mobile app CTA is displayed on story pages")
	@Test
	public void verifyOpenMobileAppCTA() {

		boolean isStepTrue;
		Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyOpenMobileAppCTA");
		isStepTrue = openInAppPage.checkRedirectionBetweenApp(params.get("ampUrl"),params.get("mwebUrl"), params.get("appName"));
		Assert.assertTrue(isStepTrue, "Open mobile app CTA is displaying has been Failed");

	}
	@Author(name = "Shakeel Alam,Ravinder Singh, Harsh Sharma")
	@Description("QAAUT-1523(ios-web),QAAUT-1546(Android AMP),QAAUT-1501(Android_MWeb): To verify open app button is displayed on mweb story pages")
	@Test
	public void verifyOpenAppButton() {

		boolean isStepTrue;isStepTrue = openInAppPage.checkOpenAppButton();
		Assert.assertTrue(isStepTrue, "Open mobile app CTA is displaying has been Failed");

	}
	@Author(name = "Shakeel Alam,Ravinder Singh,Harsh Sharma")
	@Description("QAAUT-1524(ios-web),QAAUT-1547(Android AMP),QAAUT-1502(Android_MWeb): To verify open app button is displayed in header")
	@Test
	public void verifyOpenAppButtonTop() {

		boolean isStepTrue;isStepTrue = openInAppPage.checkOpenAppButtonTop();
		Assert.assertTrue(isStepTrue, "Open mobile app CTA is displaying has been Failed");

	}
	@Author(name = "Shakeel Alam,Ravinder Singh,Harsh Sharma")
	@Description("QAAUT-1525(ios-web),QAAUT-1548(Android amp),QAAUT-1503(Android_MWeb): To verify open app button is displayed after each story")
	@Test
	public void verifyOpenAppButtonAfterEachStory() {
		boolean isStepTrue=false;
		isStepTrue = openInAppPage.checkOpenAppButtonAfterEachStory();
		Assert.assertTrue(isStepTrue, "Open mobile app CTA is displaying has been Failed");
	}

	@Author(name = "Shakeel Alam,Ravinder Singh")
	@Description("QAAUT-1526(ios-web)To verify when user clicks on openapp button and app is not installed it will reach the play/app store")
	@Test
	public void verifyOpenAppButtonRedirectsToAppStore() {
		Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyOpenAppButtonRedirectsToAppStore");
		boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
		Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
		isStepTrue = openInAppPage.checkOpenAppButtonRedirectsToAppStore();
		Assert.assertTrue(isStepTrue, "Open mobile app CTA is displaying has been Failed");
		isStepTrue = loginPage.logout();
		Assert.assertTrue(isStepTrue, "Log out failed");


	}
}
