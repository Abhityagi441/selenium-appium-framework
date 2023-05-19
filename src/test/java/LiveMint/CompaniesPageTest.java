package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonCompaniesPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class CompaniesPageTest extends BaseTest {
    private static CommonCompaniesPage companiesPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        companiesPage = CommonCompaniesPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4160(Web), QAAUT-4164(iOS-Amp), QAAUT-4163(android-Amp), QAAUT-4162(iOS-web), QAAUT-4161(android-web):Validate top nav on companies page")
    @Test
    public void verifyCompaniesPageTopNav() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCompaniesPageTopNav");
        isStepTrue = companiesPage.checkCompaniesPageTopNav(params.get("amp"));
        Assert.assertTrue(isStepTrue, "Companies page Top Nav verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4087(Web), QAAUT-4091(iOS-Amp), QAAUT-4090(android-Amp), QAAUT-4089(iOS-web), QAAUT-4088(android-web):Validate Companies section")
    @Test
    public void verifyCompaniesSection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCompaniesSection");
        isStepTrue = companiesPage.checkCompaniesSection(params.get("Link"), params.get("Amp"));
        Assert.assertTrue(isStepTrue, "Companies Section verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4609(Web), QAAUT-4217(iOS-Amp), QAAUT-4216(android-Amp), QAAUT-4607(iOS-web), QAAUT-4608(android-web):Validate share icon on companies story detail page.")
    @Test
    public void verifyShareIconsOnCompaniesPageStory() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyShareIconsOnCompaniesPageStory");
        isStepTrue = companiesPage.checkShareIconsCompanieStoryPage(params.get("Amp"));
        Assert.assertTrue(isStepTrue, "Share icon on companies story detail page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4093(Web), QAAUT-4097(iOS-Amp), QAAUT-4096(android-Amp), QAAUT-4095(iOS-web), QAAUT-4094(android-web):Validate companies page layout")
    @Test
    public void verifyCompaniesPageLayout() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCompaniesPageLayout");
        isStepTrue = companiesPage.checkCompaniesPageLayout(params.get("Amp"));
        Assert.assertTrue(isStepTrue, "Share icon on companies story detail page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4808(Web), QAAUT-4812(iOS-Amp), QAAUT-4811(android-Amp), QAAUT-4810(iOS-web), QAAUT-4809(android-web):Validate Summary on companies story page")
    @Test
    public void verifySummaryOnCompaniesStoryPage() {
        boolean isStepTrue;
        isStepTrue = companiesPage.checkSummaryOnCompaniesStoryPage();
        Assert.assertTrue(isStepTrue, "Summary on companies story page verification failed");
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4803(Web), QAAUT-4806(iOS-Amp), QAAUT-4807(android-Amp), QAAUT-4805(iOS-web), QAAUT-4804(android-web):Validate Paragraph on companies page")
    @Test
    public void verifyParagraphOnCompaniesStoryPage() {
        boolean isStepTrue;
        isStepTrue = companiesPage.checkParagraphOnCompaniesStoryPage();
        Assert.assertTrue(isStepTrue, "Paragraph on companies story page verification failed");
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-5707,5712(Web), QAAUT-5716,5711(iOS-Amp), QAAUT-5715,5710(android-Amp), QAAUT-5714,5709(iOS-web), QAAUT-5713,5708(android-web):Validate Companies sub-section, Validate Start-ups sub-section page")
    @Test
    public void verifyStartUpsCompaniesSubsection() {
        boolean isStepTrue;
        isStepTrue = companiesPage.checkStartUpsSubSection();
        Assert.assertTrue(isStepTrue, "StartUps SubSection verification failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-5750,QAAUT-5748,QAAUT-5747,QAAUT-5746,QAAUT-5745:Validate Startup Top nav")
    @Test
    public void verifyStartUpsCompaniesTopNav() {
        boolean isStepTrue;
        isStepTrue = companiesPage.checkStartUpsTopNav();
        Assert.assertTrue(isStepTrue, "StartUps TopaNav verification failed");
    }

}

