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

public class ShareTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }


    @Author(name = "Shakeel Alam, Manoj Patil")
    @Description("QAAUT-782(web), 813(android_native), 822(ios_native), 832(AMP-Android), 793(MWeb-Android):Validate the functionality of sharing icon, Modified by- Kapil Sisodia for AMP android"  )
    @Test
    public void verifyShareFunctionality() {
        boolean isStepTrue;
        isStepTrue = homePage.shareStoryFunctionality();
        Assert.assertTrue(isStepTrue, "Share Story icon verification failed");
    }
}

