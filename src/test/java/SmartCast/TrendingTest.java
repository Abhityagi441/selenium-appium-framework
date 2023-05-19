package SmartCast;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.SmartCast.generic.CommonTrendingPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class TrendingTest extends BaseTest {
	private static CommonTrendingPage trendingPage;
	GlobalVars globalVars= GlobalVars.getInstance();


	@BeforeMethod
	public void beforeMethod() {
		trendingPage = CommonTrendingPage.getInstance();
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1130,QAAUT-1154(android-mweb): To verify Trending section")
	@Test
	public void verifyTrendingSection(){
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyTrendingSection");
		String expectedTitle=paramsMap.get("expectedTitle");
		isStepTrue = trendingPage.navigateToTrendingPage();
		Assert.assertTrue(isStepTrue,"User is not navigated to trending Page");
		String actualTitle = trendingPage.getSmartCastTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Actual and Expected Title is not matched");
		isStepTrue = trendingPage.checkTrendingSection(paramsMap.get("expectedTextForShows"),paramsMap.get("expectedTextForEpisodes"));
		Assert.assertTrue(isStepTrue,"verification of trending Section Failed");

	}


}
