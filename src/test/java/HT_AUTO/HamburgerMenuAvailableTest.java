package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonHamburgerMenuAvailablePage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class HamburgerMenuAvailableTest extends BaseTest {
    private static CommonHamburgerMenuAvailablePage hamburgerMenuAvailablePage;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        hamburgerMenuAvailablePage = CommonHamburgerMenuAvailablePage.getInstance();
    }


    @Author(name = "Harsh Sharma")
    @Description("QAAUT-978,QAAUT-993(Android-mweb): Verify the Hamburger Menu.")
    @Test
    public void verifyHamburgerMenuAvailable() throws InterruptedException {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyHamburgerMenuAvailable");
        isStepTrue = hamburgerMenuAvailablePage.checkHamburgerMenuAvailablePage();
        Assert.assertTrue(isStepTrue, "Hamburger menu is not present.");
}


}