package LiveMint;
import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonEducationPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class EducationPageTest extends BaseTest {
    private static CommonEducationPage educationPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        educationPage = CommonEducationPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Arzoo Singh")
    @Description("LM-17499(Web), LM-17501(iOS-web), LM-17500(android-web):Validate Education page Layout")
    @Test
    public void verifyEducationPageLayout() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEducationPageLayout");
        isStepTrue = educationPage.checkEducationPageLayout(params.get("amp"));
        Assert.assertTrue(isStepTrue, "Education page Layout verification failed");
    }

    @Author(name = "Arzoo Singh")
    @Description("LM-17504(Web), LM-17505(Andriod web),LM-17506(ios web): Verify Education Section page")
    @Test
    public void verifyEducationSection() {
        boolean  isStepTrue = educationPage.clickOnEducationsSection();
        Assert.assertTrue(isStepTrue, "Education section page  verification failed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-17509(Web):Validate LHS on education page ")
    @Test
    public void verifyLHSOnEducationPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEducationPageLayout");
        isStepTrue = educationPage.checkLHSMenuOnEducationPage();
        Assert.assertTrue(isStepTrue, "LHS verification failed");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-17511(Web):Validate Education rhs page")
    @Test
    public void verifyRHSOnEducationPage() {
        boolean isStepTrue;
        isStepTrue = educationPage.checkRHSOnEducationPage();
        Assert.assertTrue(isStepTrue, "RHS verification failed");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-17512(Web):Validate top nav Layout")
    @Test
    public void verifyTopNavOnEducationPage() {
        boolean isStepTrue;
        isStepTrue = educationPage.checkTopNavOnEducationPage();
        Assert.assertTrue(isStepTrue, "Top nav verification failed");
    }



}
