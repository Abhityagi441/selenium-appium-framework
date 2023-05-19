package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonIndiaUsSitePage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndiaUsSiteTest extends BaseTest {
    private static CommonIndiaUsSitePage indiaUsSitePage;
    GlobalVars globalVars= GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod(){
        indiaUsSitePage=CommonIndiaUsSitePage.getInstance();
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-520(web),544(mweb) : To verify india/US toggle in hamburger is working")
    @Test
    public void verifyIndiaUsToggleHamburgerIsWorking() {
        boolean isStepTrue = false;
        isStepTrue = indiaUsSitePage.checkIndiaUsToggleWorking();
        Assert.assertTrue(isStepTrue, "check India USA toggle on Hamburger Menu has been Failed");
    }
}
