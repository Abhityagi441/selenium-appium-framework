package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonChooseThemePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class ChooseThemeTest extends BaseTest {
    private static CommonChooseThemePage chooseThemePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        chooseThemePage = CommonChooseThemePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1240 and QAAUT-1241(android_native): Verfiy the choose theme button should be clickable (auto/light/dark)")
    @Test
    public void verifyChooseThemePage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyChooseThemePage");
        isStepTrue = chooseThemePage.checkThemeChangesAtChooseWorks();
        Assert.assertTrue(isStepTrue, "Choose Theme functionality failed.");
    }

}



