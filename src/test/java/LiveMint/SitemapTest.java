package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SitemapTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-835(Web), 841(MWeb-iOS), 845(MWeb-Android):Validate Sitemap Page")
    @Test
    public void verifySiteMap() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySiteMap");
        isStepTrue = homePage.siteMap(params.get("siteMapURL"));
        Assert.assertTrue(isStepTrue, "Site Map verification failed");
    }
}

