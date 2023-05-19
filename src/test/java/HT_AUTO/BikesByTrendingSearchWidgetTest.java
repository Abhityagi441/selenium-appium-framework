package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonBikeByTrendingSearchWidgetPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class BikesByTrendingSearchWidgetTest extends BaseTest {
    private static CommonBikeByTrendingSearchWidgetPage bikeByTrendingSearchWidgetPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        bikeByTrendingSearchWidgetPage = CommonBikeByTrendingSearchWidgetPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1001(Androind_mweb): Verify all the widgets that are present on the find bikes page.")
    @Test
    public void verifyBikeByTrendingSearchWidget() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBikeByTrendingSearchWidget");
        isStepTrue = bikeByTrendingSearchWidgetPage.checkBikeByTrendingSearchWidget(params.get("expectedTrendingBikeText"),params.get("expectedSearchBikeBrandsText"),params.get("expectedBikeByBudgetText"));
        Assert.assertTrue(isStepTrue, "Bike page's all widget presence verification is failed.");
    }


}
