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

public class HindustanWidgetOnHomePageTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-1122(web):Validate widgets on Home page")
    @Test
    public void verifyHindustanWidgetOnHomePage() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyHindustanWidgetOnHomePage");
        String[] paramArrays= new String[5];
        paramArrays[0]=params.get("param1");
        isStepTrue = homePage.checkHindustanWidgetHomePage(paramArrays);
        Assert.assertTrue(isStepTrue, "Hindustan Widget on web home page verification failed");
    }
}

