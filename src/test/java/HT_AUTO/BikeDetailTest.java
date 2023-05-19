package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonBikeDetailsPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class BikeDetailTest extends BaseTest {
    private static CommonBikeDetailsPage bikeDetailsPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        bikeDetailsPage = CommonBikeDetailsPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1003(Android-MWeb) and QAAUT-989: Verify that Bike detail page is working.")
    @Test
    public void verifyBikeDetailPage() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBikeDetailPage");
        isStepTrue = bikeDetailsPage.checkBikeDetailPage(params.get("expectedBrand"), params.get("expectedModel"));
        Assert.assertTrue(isStepTrue, "Bike details verification failed");
    }


}
