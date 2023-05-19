package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonPDPLinkOnBikeModlePage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class PDPLinkOnBikeModleTest extends BaseTest {
    private static CommonPDPLinkOnBikeModlePage pDPLinkOnBikeModlePage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        pDPLinkOnBikeModlePage = CommonPDPLinkOnBikeModlePage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-988: Verify PDP link on model name")
    @Test
    public void verifyBikePDPLink() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBikePDPLink");
        isStepTrue = pDPLinkOnBikeModlePage.checkPDPLinkOnBikeModle();
        Assert.assertTrue(isStepTrue, "Bike listing details on mouse hover details verification failed");
    }


}