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

public class HamburgerTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam")
    @Description("QQAAUT-779(web), 790(MWeb-Android), 836(AMP-IOS), 801(MWeb-IOS):Validate the hamburger options")
    @Test
    public void verifyHamburger() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHamburger();
        Assert.assertTrue(isStepTrue, "Hamburger Options are empty");
    }

}

