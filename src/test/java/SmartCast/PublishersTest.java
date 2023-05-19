package SmartCast;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.SmartCast.generic.CommonPublishersPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class PublishersTest extends BaseTest {
	private static CommonPublishersPage publishersPage;
	GlobalVars globalVars= GlobalVars.getInstance();


	@BeforeMethod
	public void beforeMethod() {
		publishersPage = CommonPublishersPage.getInstance();
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1131 QAAUT-1155(android-mweb): To verify Publishers section")
	@Test
	public void verifyPublishersSection(){
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyPublishersSection");
		String expectedTitle=paramsMap.get("expectedTitle");
		isStepTrue = publishersPage.navigateToPublishersPage();
		Assert.assertTrue(isStepTrue,"User is not navigated to Publishers Page");
		String actualTitle = publishersPage.getSmartCastTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Actual and Expected Title is not matched");
		isStepTrue = publishersPage.checkPublishersSection();
		Assert.assertTrue(isStepTrue,"verification of Publishers Section Failed");

	}



}
