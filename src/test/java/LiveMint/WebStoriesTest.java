package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.web.WebStoriesPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class WebStoriesTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }
    @Author(name = "Arzoo Singh")
    @Description("lm-19943(web):Validate Webstories Landing Page"  )
    @Test
    public void verifyWebStoriesLandingPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyWebStoriesLandingPage");

        isStepTrue = WebStoriesPage.getInstance().checkWebStoriesLandingPage();
        Assert.assertTrue(isStepTrue, "Webstories landing Page verification failed");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-19945(web):Validate Webstories Landing Page"  )
    @Test
    public void verifyLHSOnWebStoriesLandingPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLHSOnWebStoriesLandingPage");

        isStepTrue = WebStoriesPage.getInstance().checkLHSOnWebStoriesLandingPage();
        Assert.assertTrue(isStepTrue, "LHS Widgets verification failed");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-20074(web):Validate l1 Nav On Webstories Landing Page"  )
    @Test
    public void verifyL1NavOnWebStoriesPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyL1NavOnWebStoriesPage");

        isStepTrue = WebStoriesPage.getInstance().checkL1NavOnWebStoriesPage();
        Assert.assertTrue(isStepTrue, "L1 Nav verification failed");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-19943(web):Validate Webstories Page Layout"  )
    @Test
    public void verifyWebStoriesPageLayout() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyWebStoriesPageLayout");

        isStepTrue = WebStoriesPage.getInstance().checkWebStoriesPageLayout();
        Assert.assertTrue(isStepTrue, "Page layout verification failed");
    }


}
