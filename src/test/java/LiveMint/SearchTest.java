package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.generic.CommonSearchPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchTest  extends BaseTest {
    private static CommonSearchPage sectionPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        sectionPage = CommonSearchPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1334(ios_native):Verify searchcing by the keywords and neviagtion is shown results")
    @Test
    public void verifySearchIsWorking() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchIsWorking");
        isStepTrue = sectionPage.checkSearchIsWorking(paramsMap.values().toArray(new String[1]));
        Assert.assertTrue(isStepTrue, "Search verification failed");
    }
}

