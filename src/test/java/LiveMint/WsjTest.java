package LiveMint;
import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
 import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonWSJPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;


class WsjTest extends BaseTest {
    private static CommonWSJPage wsjPage;
    private static CommonLoginPage loginPage;

    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        wsjPage = CommonWSJPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17342(web),LM-17496(MwebAndroid),LM-17497(MwebiOS): verify Wsj Page layout ")
    @Test
    public void verifyWsjPageLayout() {
        boolean isTrue = wsjPage.checkWSJPagelayout();
        Assert.assertTrue(isTrue, "For You Page layout verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description(" LM-17543 (web): verify Wsj LHS NAv Link")
    @Test
    public void verifyWsjLhslink() {
        boolean isTrue = wsjPage.checklshWSJPage();
        Assert.assertTrue(isTrue, "WSJ LHS NAV LINK  verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description(" LM-17544 (MwebAndroid),LM-17545(MwebiOS): verify Wsj LHS NAv Link ")
    @Test
    public void verifyWsjToplink() {
        boolean isTrue = wsjPage.checkTopNavLink();
        Assert.assertTrue(isTrue, "WSJ TOP NAV LINK  verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description(" LM-LM-17560 (web) : verify Wsj LHS NAv Link ")
    @Test
    public void verifyWsjRHSlink() {
        boolean isTrue = wsjPage.checkrhsWSJPage();
        Assert.assertTrue(isTrue, "WSJ RHS widget and Ad verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17562(web), LM-17563(MwebAndroid),LM-17568(MwebiOS): verify WSJ Page Layout subscribed user  ")
    @Test
    public void verifyWsjPageLayoutForSubscribeUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyWsjPageLayoutForSubscribeUser");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for RHS");
        isStepTrue = wsjPage.checkWSJPagelayoutSubscribedUSer();
        Assert.assertTrue(isStepTrue, "WSJ Page Layout for Subscribeduser For You Page verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "WSJ logout failed");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17569(MwebAndroid),LM-17570(MwebiOS): verify WSJ Top NAV links for subscribed user  ")
    @Test
    public void verifycheckTopNavLinkSubscribeduser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckTopNavLinkSubscribeduser");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for RHS");
        isStepTrue = wsjPage.checkTopNavLinkSubscribeduser();
        Assert.assertTrue(isStepTrue, "WSJ Top Nav for Subscribeduser  verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "WSJ logout failed");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17598(web): verify WSJ LHS NAV links for subscribed user  ")
    @Test
    public void verifychecklshWSJPageforSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifychecklshWSJPageforSubscribedUser");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for RHS");
        isStepTrue = wsjPage.checklshWSJPage();
        Assert.assertTrue(isStepTrue, "WSJ LHS Nav for Subscribeduser  verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "WSJ logout failed");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17606(web): verify WSJ RHS NAV links for subscribed user  ")
    @Test
    public void verifycheckrHSNAVLinksforSubscribeduserWsj() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckrHSNAVLinksforSubscribeduserWsj");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for RHS");
        isStepTrue = wsjPage.checkrHSNAVLinksforSubscribeduserWsj();
        Assert.assertTrue(isStepTrue, "WSJ RHS Nav for Subscribeduser  verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "WSJ logout failed");
    }
    @Author(name = "NIshant Nayan")
    @Description(" LM-17607 (web): verify Wsj Story")
    @Test
    public void verifycheckFirstStory()
    {
        boolean isTrue = wsjPage.checkFirstStory();
        Assert.assertTrue(isTrue, "WSJ Story verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17890(web),LM-17891(mwebAndroid),LM-17892(mwebiOS): verify Story count for subscribed user  ")
    @Test
    public void verifycheckFirstStoryWSjForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckFirstStoryWSjForSubscribedUser");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for Story count");
        isStepTrue = wsjPage.checkFirstStory();
        Assert.assertTrue(isStepTrue, "Story count for Subscribeduser  verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Story count logout failed");
    }

}
