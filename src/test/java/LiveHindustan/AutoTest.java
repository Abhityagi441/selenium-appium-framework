package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.pages.LiveHindustan.genericPages.CommonAutoPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

public class AutoTest extends BaseTest {
    private static CommonAutoPage autoPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            autoPage = CommonAutoPage.getInstance();
            loginPage = CommonLoginPage.getInstance();

        } else {
            loginPage = CommonLoginPage.getInstance();
            autoPage = CommonAutoPage.getInstance();
            /*Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
            boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
            if (!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                Assert.assertTrue(isStepTrue, "Login with Email and Password failed");
            }*/
        }
    }


    @AfterClass
    public void afterClass() {
        boolean isStepTrue;
        switch (globalVars.getPlatformName()) {
            case Constants.ANDROID_AMP:

            case Constants.IOS_AMP:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                commonFunctionsMobile.waitForPageToLoad();
                break;
            case Constants.ANDROID_WEB:
            case Constants.IOS_WEB:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                commonFunctionsMobile.waitForPageToLoad();
                /*isStepTrue = loginPage.logout();
                if (!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
            case Constants.DESKTOP_WEB:
                commonFunctionsWeb = CommonFunctionsWeb.getInstance();
                commonFunctionsWeb.navigateToURL(globalVars.getURL());
                /*isStepTrue = loginPage.logout();
                if (!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
        }

    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5900(LH-Web-Android), QAAUT-5901(LH-Web-IOS),QAAUT-5899(LH-Web) : To Verify Milti-Julti car widget on Auto Story Page")
    @Test
    public void verifyMiltiJultiCarWidgetOnAutoStoryPage() {
        boolean isStepTrue;
        isStepTrue = autoPage.checkMiltiJultiCarWidgetOnAutoStoryPage();
        Assert.assertTrue(isStepTrue, "Milti-Julti car widget is not displayed");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5902(LH-AMP-Android), QAAUT-5903(LH-AMP-IOS) :To Verify sub-menu on Auto Page")
    @Test
    public void verifySubMenuOnAutoPage() {
        boolean isStepTrue;
        isStepTrue = autoPage.checkSubMenuOnAutoPage();
        Assert.assertTrue(isStepTrue, "Sub-menu's are not functional in auto page");
    }

}