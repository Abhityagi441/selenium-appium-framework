package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class EPaperTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1279(ios_native):Verify the subscribed user")
    @Test
    public void verifyHomeEPaperSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyHomeEPaperSubscribedUser");
        loginPage.loginWithSubScribedUser(paramsMap.values().toArray(new String[1]));
        isStepTrue = homePage.checkEPaperSubscribedUser();
        Assert.assertTrue(isStepTrue, "E Paper for Subscribed User verification failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1278(ios_native):Verify the Subscription")
    @Test
    public void verifyEPaperNonSubscribedUser() {
        boolean isStepTrue;
        isStepTrue = homePage.checkEPaperNonSubscribedUser();
        Assert.assertTrue(isStepTrue, "E Paper for Non Subscribed User verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1276(ios_native):Verify the Mint logo location")
    @Test
    public void verifyMintLogo() {
        boolean isStepTrue;
        isStepTrue = homePage.checkMintLogo();
        Assert.assertTrue(isStepTrue, "Mint Logo verification failed");
    }
}

