package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCompareCarPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CompareCarsTest extends BaseTest {
    private static CommonCompareCarPage commonCompareCarPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        commonCompareCarPage = CommonCompareCarPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-990, QAAUT-1004(Android_mweb): Verify that Compare Cars page is working")
    @Test
    public void verifyCompareCars() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCompareCars");

        isStepTrue = commonCompareCarPage.checkCompareCar();
        Assert.assertTrue(isStepTrue, "The comparison data between the two cars are not showing in tabular form.");
    }


}