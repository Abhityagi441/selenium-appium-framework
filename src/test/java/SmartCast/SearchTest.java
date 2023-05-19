package SmartCast;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.SmartCast.generic.CommonSearchPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchTest extends BaseTest {
	private static CommonSearchPage SearchPage;
	GlobalVars globalVars= GlobalVars.getInstance();

	@BeforeMethod
	public void beforeMethod() {
		SearchPage = CommonSearchPage.getInstance();
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-954, QAAUT-1153(android-mweb): To verify Search functionality of HT SmartCast")
	@Test
	public void verifySearchResults(){
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifySearchResults");
		isStepTrue = SearchPage.getSearchResults(paramsMap.get("expectedText"));
		Assert.assertTrue(isStepTrue,"Actual and Expected Searched Text for Shows Or Episodes are not matched");
	}

}
