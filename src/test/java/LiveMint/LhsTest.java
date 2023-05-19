package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LhsTest extends BaseTest {

    private static CommonHomePage homePage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
    }

    @Author(name = "Kapil Singh Sisodia")
    @Description("LM-19934: verify LHS widget elements")
    @Test
    public void verifyLHSHomepage()
    {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLHSHomepage");
        isStepTrue = homePage.checkLHSGainerLoserWidget(paramsMap.get("pageName"), paramsMap.get("widgetName"));
        Assert.assertTrue(isStepTrue, "LHS gainer Loser Widget validation failed");
    }
}
