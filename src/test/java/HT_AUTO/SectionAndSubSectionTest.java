package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonSectionAndSubSectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class SectionAndSubSectionTest extends BaseTest {
    private static CommonSectionAndSubSectionPage hamburgerSectionAndSubSectionPage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        hamburgerSectionAndSubSectionPage = CommonSectionAndSubSectionPage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-995(Android-mweb): Verify Section and subsection")
    @Test
    public void verifySectionAndSection() throws InterruptedException {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySectionAndSection");
        isStepTrue = hamburgerSectionAndSubSectionPage.checkSectionAndSubSection(params.get("hamburger"), params.get("notification"), params.get("autoNews"), params.get("findCars"), params.get("findBikes"), params.get("comCars"), params.get("comBikes"), params.get("emiCal"), params.get("fasTag"),params.get("urlSubString"));
        Assert.assertTrue(isStepTrue, "Section and Subsection related functionality failed.");

    }


}