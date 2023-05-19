package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCarDetailsPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CarDetailsTest extends BaseTest {
    private static CommonCarDetailsPage carDetailsPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        carDetailsPage = CommonCarDetailsPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-984,QAAUT-1000(Androind_mweb): Verify that Car detail page is working.")
    @Test
    public void verifyCarDetails() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCarDetails");
        isStepTrue = carDetailsPage.checkCarDetails();
        Assert.assertTrue(isStepTrue, "Car details verification failed");
    }


}
