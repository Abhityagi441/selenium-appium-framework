package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonHomePage;
import com.pages.LiveHindustan.genericPages.CommonLandingPage;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class LandingTest extends BaseTest {

    private static CommonLandingPage landingPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            landingPage = CommonLandingPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            landingPage = CommonLandingPage.getInstance();
            /*Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
            boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
            if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                Assert.assertTrue(isStepTrue, "Login with Email and Password failed");
            }*/
        }
    }

    @AfterClass
    public void afterClass() {
        boolean isStepTrue;
        switch (globalVars.getPlatformName()) {
            case Constants.ANDROID_WEB:
            case Constants.IOS_WEB:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                /*isStepTrue = loginPage.logout();
                if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
            case Constants.DESKTOP_WEB:
                commonFunctionsWeb = CommonFunctionsWeb.getInstance();
                commonFunctionsWeb.navigateToURL(globalVars.getURL());
                /*isStepTrue = loginPage.logout();
                Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");*/
                break;
            case Constants.ANDROID_AMP:
            case Constants.IOS_AMP:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                break;
        }
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-6010(LH-Web),QAAUT-6009(LH-IOS-Mweb),QAAUT-6008(LH-Android-Mweb),QAAUT-3614(Android_AMP),QAAUT-4589(IOS_AMP) :To verify entertainment Landing page")
    @Test
    public void verifyEntertainmentLandingPage() {
        boolean isStepTrue;
        isStepTrue = landingPage.checkLandingPage();
        Assert.assertTrue(isStepTrue, "Landing page is not working properly!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Regression || QAAUT-3615(Android_AMP) QAAUT-4590(IOS_AMP) :Verify landing page sub menu")
    @Test
    public void verifyLandingPageSubMenu() {
        boolean isStepTrue;
        isStepTrue = landingPage.checkLandingPageSubMenu();
        Assert.assertTrue(isStepTrue, "landing page sub menus are not working properly!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-3616(Android_AMP), QAAUT-4591(IOS_AMP) :To verify aur padhe button on National landing page")
    @Test
    public void verifyAurPadheButtonOnNationalLandingPage() {
        boolean isStepTrue;
        isStepTrue = landingPage.checkAurPadheButtonOnLandingPage();
        Assert.assertTrue(isStepTrue, "aur padhe button is not working properly!!!!!!!!");
    }

}
