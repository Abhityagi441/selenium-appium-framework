package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCarByTrendingPopularBudgetPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CarByTrendingPopularBudgetTest extends BaseTest {
    private static CommonCarByTrendingPopularBudgetPage carByTrendingPopularBudget;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        carByTrendingPopularBudget = CommonCarByTrendingPopularBudgetPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-992: Verify that Trending cars, car by budget, car by body type, popular brands widgets are present")
    @Test
    public void verifyCarByTrendingPopularBudget() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCarByTrendingPopularBudget");
        isStepTrue = carByTrendingPopularBudget.checkCarByTrendingPopularBudget(params.get("expectedTrendingCarText"));
        Assert.assertTrue(isStepTrue, "Verifying Car by trending, body and popular brand widgets failed.");
    }


}