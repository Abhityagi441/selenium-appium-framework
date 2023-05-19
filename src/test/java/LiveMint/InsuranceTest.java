package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonInsurancePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

class InsuranceTest extends BaseTest {
      private static CommonInsurancePage insurancePage;
         private static CommonLoginPage loginPage;

         GlobalVars globalVars = GlobalVars.getInstance();

         @BeforeMethod
         public void beforeMethod() {
             insurancePage = CommonInsurancePage.getInstance();
             loginPage = CommonLoginPage.getInstance();
         }
     @Author(name = "Arzoo Singh")
     @Description("LM-17982(Web):Validate Top Nav On Insurance Layout")
     @Test
     public void verifyInsuranceTopnav() {
             boolean isStepTrue = insurancePage.checkTopNavOnInsurancePage();
             Assert.assertTrue(isStepTrue, "Insurance Verification Failed  ******");
         }
     @Author(name = "Arzoo Singh")
     @Description("LM-17984(Web):Validate LHS On Insurance page Layout")
     @Test
     public void verifyLHSOnInsurancePage() {
         boolean isStepTrue = insurancePage.checkLHSOnInsurancePage();
         Assert.assertTrue(isStepTrue, "LHS on Insurance Verification Failed  ******");
     }
     @Author(name = "Arzoo Singh")
     @Description("LM-179859(Web):Validate Insurance Section page ")
     @Test
     public void verifyInsuranceSection() {
         boolean isStepTrue = insurancePage.clickOnInsuranceSection();
         Assert.assertTrue(isStepTrue, "Insurance Section Page Verification Failed  ******");
     }
    @Author(name = "Arzoo Singh")
    @Description("LM-18173(Web):verifyRHSOnInsuranceSection")
    @Test
    public void verifyRHSOnInsuranceSection() {
        boolean isStepTrue = insurancePage.checkRHSOnInsurancePage();
        Assert.assertTrue(isStepTrue, "Insurance RHS  Verification Failed  ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-18174(Web):verifyShareIconVisibilityOnInsuranceSection")
    @Test
    public void verifyShareIconVisibilityOnInsuranceSection() {
        boolean isStepTrue = insurancePage.checkshareIconVisibility();
        Assert.assertTrue(isStepTrue, "Share Icon Visibility Verification Failed  ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-18175(Web):verifyInsurancePageLayout")
    @Test
    public void verifyInsurancePageLayout() {

        boolean isStepTrue = insurancePage.checkInsurancePageLayout();
        Assert.assertTrue(isStepTrue, "Insurance Page Layout Verification Failed  ******");
    }
     }
