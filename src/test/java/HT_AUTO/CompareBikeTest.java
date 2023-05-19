package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCompareBikePage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CompareBikeTest extends BaseTest {
    private static CommonCompareBikePage compareBikePage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        compareBikePage = CommonCompareBikePage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-991, QAAUT-1005(Android_mweb): Verify that Compare Bikes page is working.")
    @Test
    public void verifyCompareBikePage() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCompareBikePage");

        isStepTrue = compareBikePage.checkCompareBikePage();
        Assert.assertTrue(isStepTrue, "Bike Compare verification failed");

    }


}