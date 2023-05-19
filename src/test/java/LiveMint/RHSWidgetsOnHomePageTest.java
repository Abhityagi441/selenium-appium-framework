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

public class RHSWidgetsOnHomePageTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-831(web):Verify RHS widgets on web home page")
    @Test
    public void verifyRHSWidgetsOnHomePage() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyRHSWidgetsOnHomePage");
        String [] paramsArray= new String[10];
        paramsArray[0] = params.get("trending");
        paramsArray[1] = params.get("latest");
        paramsArray[2] = params.get("primer");
        paramsArray[3] = params.get("longStory");
        paramsArray[4] = params.get("premium");
        paramsArray[5] = params.get("popularVideos");
        paramsArray[6] = params.get("companies");
        paramsArray[7] = params.get("theWallStreetJournal");
        paramsArray[8] = params.get("personalFinance");
        isStepTrue = homePage.checkRHSWidgetsHomePage(paramsArray);
        Assert.assertTrue(isStepTrue, "RHS widgets on web home page verification failed");
    }
}

