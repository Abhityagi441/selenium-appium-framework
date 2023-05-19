package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCarRoadPricePage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CarRoadPriceTest extends BaseTest {
    private static CommonCarRoadPricePage commonCarRoadPricePage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        commonCarRoadPricePage = CommonCarRoadPricePage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-985: Verify that car on road price page is wokring")
    @Test
    public void verifyCarRoadPrice()  {
        boolean isStepTrue= true;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCarRoadPrice");


        isStepTrue &= commonCarRoadPricePage.checkCarRoadPriceWithCityFromList(params.get("expectedCity"), params.get("expectedOnRoadText"));
        Assert.assertTrue(isStepTrue, "Car details with option selection verification failed");

        isStepTrue &= commonCarRoadPricePage.checkCarRoadPriceWithCitySelection(params.get("expectedCity"), params.get("expectedOnRoadText"));
        Assert.assertTrue(isStepTrue, "Car details with manual city search verification failed");
    }



}