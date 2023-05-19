package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonTopNavigationPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class TopNavigationTest extends BaseTest {
    private static CommonTopNavigationPage topNavigationPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        topNavigationPage = CommonTopNavigationPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-996(Android-MWeb): Verify top nav.")
    @Test
    public void verifyTopNavigationPage() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopNavigationPage");
        isStepTrue = topNavigationPage.checkTopNavigation(params.get("attributeName"),params.get("attributeValue"));
        Assert.assertTrue(isStepTrue, "Top Navigation failed.");
    }


}
