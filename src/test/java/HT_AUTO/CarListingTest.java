package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCarListingPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CarListingTest extends BaseTest {
    private static CommonCarListingPage carListingPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        carListingPage = CommonCarListingPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-982: Verify the car listing page.")
    @Test
    public void verifyCarListing() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCarListing");
        isStepTrue = carListingPage.checkCarListingPage();
        Assert.assertTrue(isStepTrue, "Car listing details on mouse hover details verification failed");
    }


}