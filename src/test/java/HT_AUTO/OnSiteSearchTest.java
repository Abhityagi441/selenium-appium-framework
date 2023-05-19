package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonOnSiteSearchPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class OnSiteSearchTest extends BaseTest {
    private static CommonOnSiteSearchPage onSiteSearchTest;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        onSiteSearchTest = CommonOnSiteSearchPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-980: On site search.")
    @Test
    public void verifyOnSiteSearch() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyOnSiteSearch");
        isStepTrue = onSiteSearchTest.checkOnSiteSearchWithRespectToCar(params.get("expectedCarBrand"), params.get("carBrandList"));
        Assert.assertTrue(isStepTrue, "On Site Search for Car failed");
    }


}