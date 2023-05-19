package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonCTACarProductDetailPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CTACarProductDetailsTest extends BaseTest {
    private static CommonCTACarProductDetailPage cTACarProductDetailPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        cTACarProductDetailPage = CommonCTACarProductDetailPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-986: Verify the CTA  on Car Product Detail Page.")
    @Test
    public void verifyCTACarProductDetailPage() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCTACarProductDetailPage");
        isStepTrue = cTACarProductDetailPage.checkCTACarProductDetailPage();
        Assert.assertTrue(isStepTrue, "CTA on Car details verification failed");
    }


}