package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonSearchAnyBikeBrandAndModelPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchAnyBikeBrandAndModelTest extends BaseTest {
    private static CommonSearchAnyBikeBrandAndModelPage searchAnyBikeBrandAndModelPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        searchAnyBikeBrandAndModelPage = CommonSearchAnyBikeBrandAndModelPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1002(Android_mweb): Verify that you are able to search any brand and model")
    @Test
    public void verifySearchAnyBikeBrandModle() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchAnyBikeBrandModle");
        isStepTrue = searchAnyBikeBrandAndModelPage.checkSearchAnyBikeBrandAndModel(params.get("expectedBrand"),params.get("expectedModel"),params.get("expectedText"));
        Assert.assertTrue(isStepTrue, "Verification for search any brand and model is failed.");
    }


}