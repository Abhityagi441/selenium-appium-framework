package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonBikeListingPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class  BikeListingTest  extends BaseTest {
    private static CommonBikeListingPage bikeListingPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        bikeListingPage = CommonBikeListingPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-987: Verify the bike listing page")
    @Test
    public void verifyBikeListing() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBikeListing");
        isStepTrue = bikeListingPage.checkBikeListingPage();
        Assert.assertTrue(isStepTrue, "Bike listing details on mouse hover details verification failed");
    }


}