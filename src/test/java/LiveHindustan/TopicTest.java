package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.pages.LiveHindustan.genericPages.CommonTopicPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class TopicTest extends BaseTest
{
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonTopicPage topicPage;
    private static CommonLoginPage loginPage;
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            topicPage = CommonTopicPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            topicPage = CommonTopicPage.getInstance();
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
    @Description("Sanity || QAAUT-5880(LH-Web),QAAUT-5881(MWeb_Android),QAAUT-5891(MWeb_IOS):To verify all tabs and heading on topic page")
    @Test
    public void verifyAllTabsAndHeadingOnTopicPage() {
        boolean isStepTrue;
        isStepTrue = topicPage.checkAllTabsAndHeadingOnAnyTopicPage();
        Assert.assertTrue(isStepTrue, "All tabs and heading on topic page not working fine!!!!!!!!");
    }

}
