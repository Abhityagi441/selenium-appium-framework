package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCarsByTrendingSearchWidgetPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CarsByTrendingSearchWidgetTest extends BaseTest {
    private static CommonCarsByTrendingSearchWidgetPage carByTrendingSearchWidgetPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        carByTrendingSearchWidgetPage = CommonCarsByTrendingSearchWidgetPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-998(Androind_mweb): Verify all the widgets that are present on the find cars page.")
    @Test
    public void verifyCarByTrendingSearchWidget() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCarByTrendingSearchWidget");
        isStepTrue = carByTrendingSearchWidgetPage.checkCarsByTrendingSearchWidget(params.get("expectedTrendingCarText"),params.get("expectedSearchCarBrandsText"),params.get("expectedCarByBudgetText"), params.get("expectedCarByBodyTypeText"), params.get("expectedUpcommingCarText"));
        Assert.assertTrue(isStepTrue, "Car page's all widget presence verification is failed.");
    }


}
