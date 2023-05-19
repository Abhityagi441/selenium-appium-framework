package SmartCast;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.SmartCast.generic.CommonCategoriesPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class CategoriesTest extends BaseTest {
	private static CommonCategoriesPage categoriesPage;
	GlobalVars globalVars= GlobalVars.getInstance();

	@BeforeMethod
	public void beforeMethod() {
		categoriesPage = CommonCategoriesPage.getInstance();
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1132: To verify Categories section")
	@Test
	public void verifyCategoriesSection(){
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyCategoriesSection");
		String expectedTitle=paramsMap.get("expectedTitle");
		isStepTrue=categoriesPage.navigateToCategoriesPage();
		Assert.assertTrue(isStepTrue,"User is not navigated to Categories Page");
		String actualTitle = categoriesPage.getSmartCastTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"Actual and Expected Title not matched");
		isStepTrue = categoriesPage.checkCategoriesSection();
		Assert.assertTrue(isStepTrue,"verification of Categories Section Failed");
	}

}
