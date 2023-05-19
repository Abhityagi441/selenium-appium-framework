package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonBusinessPage;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Map;


public class BusinessTest extends BaseTest {
    private static CommonBusinessPage businessPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            businessPage = CommonBusinessPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            businessPage = CommonBusinessPage.getInstance();
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
    @Description("Sanity || QAAUT-5885(LH-Web) : To verify the IFCS code sub-menu by entering the IFSC code on Business Page")
    @Test
    public void verifyTheIFCSCodeSubMenuByEnteringTheIFSCCodeOnBusinessPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTheIFCSCodeSubMenuByEnteringTheIFSCCodeOnBusinessPage");
        isStepTrue = businessPage.checkTheIFCSCodeSubMenuByEnteringTheIFSCCodeOnBusinessPage(params.get("ifscCode"));
        Assert.assertTrue(isStepTrue, "IFSC code related details are not displayed correct!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-5908(LH-Web) : To verify the IFCS code sub-menu by entering location details on Business Page")
    @Test
    public void verifyIFCSCodeSubMenuByEnteringLocationOnBusinessPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIFCSCodeSubMenuByEnteringLocationOnBusinessPage");
        isStepTrue = businessPage.checkIFCSCodeSubMenuByEnteringLocationOnBusinessPage(params.get("BankName"), params.get("StateName"), params.get("DistrictName"), params.get("BranchName"), params.get("IFSCCODE"));
        Assert.assertTrue(isStepTrue, "IFSC code related details are not displayed correct!!!!!!!!");
    }

}