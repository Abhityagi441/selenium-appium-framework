package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.pages.LiveHindustan.genericPages.CommonStatePage;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class StateTest extends BaseTest {
    private static CommonStatePage statePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            statePage = CommonStatePage.getInstance();
            loginPage = CommonLoginPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            statePage = CommonStatePage.getInstance();
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
                if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
            case Constants.DESKTOP_WEB:
                commonFunctionsWeb = CommonFunctionsWeb.getInstance();
                commonFunctionsWeb.navigateToURL(globalVars.getURL());
                /*isStepTrue = loginPage.logout();
                if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
        }

    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-5995 (Web), QAAUT-5996(Android_MWeb), QAAUT-5997(IOS_MWeb) :To verify L2 Sub-Menu are present and giving 200 status code on State Page")
    @Test
    public void verifyL2SubMenuPresentAndGiving200Status() {
        boolean isStepTrue;
        isStepTrue = statePage.checkL2SubMenuPresentAndGiving200Status();
        Assert.assertTrue(isStepTrue, "L2 Sub-Menu are not present or not giving 200 status code on State Page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6005 (Web), QAAUT-6006(Android_MWeb), QAAUT-6007(IOS_MWeb) :To verify L2 Sub-Menu are clickable and giving 200 status code for Uttar Pradesh State Page")
    @Test
    public void verifyL2SubMenuPresentAndGiving200UttarPradeshState() {
        boolean isStepTrue;
        isStepTrue = statePage.checkL2SubMenuPresentAndGiving200UttarPradeshState();
        Assert.assertTrue(isStepTrue, "L2 Sub-Menu are not present or not giving 200 status code on Uttar Pradesh State Page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6011 (Web), QAAUT-6012(Android_MWeb), QAAUT-6013(IOS_MWeb) :To verify L2 Sub-Menu are clickable and giving 200 status code for Bihar State Page")
    @Test
    public void verifyL2SubMenuPresentAndGiving200BiharState() {
        boolean isStepTrue;
        isStepTrue = statePage.checkL2SubMenuPresentAndGiving200BiharState();
        Assert.assertTrue(isStepTrue, "L2 Sub-Menu are not present or not giving 200 status code on Bihar State Page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6014 (Web), QAAUT-6015(Android_MWeb), QAAUT-6016(IOS_MWeb) :To verify L2 Sub-Menu are clickable and giving 200 status code for NCR State Page")
    @Test
    public void verifyL2SubMenuPresentAndGiving200NcrState() {
        boolean isStepTrue;
        isStepTrue = statePage.checkL2SubMenuPresentAndGiving200NcrState();
        Assert.assertTrue(isStepTrue, "L2 Sub-Menu are not present or not giving 200 status code on NCR State Page!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-6000 (Web), QAAUT-5999(Android_MWeb), QAAUT-5998(IOS_MWeb) :To verify Uttar Pradesh News widget is having 6 stories and status is 200")
    @Test
    public void verifyUttarPradeshNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkUttarPradeshNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Uttar Pradesh News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-6055 (Web), QAAUT-6056(Android_MWeb), QAAUT-6057(IOS_MWeb),:To verify NCR News widget is having 6 stories and status is 200")
    @Test
    public void verifyNCRNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkNCRNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "NCR News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-6058 (Web), QAAUT-6059(Android_MWeb), QAAUT-6060(IOS_MWeb):To verify Bihar News widget is having 6 stories and status is 200")
    @Test
    public void verifyBiharNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkBiharNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Bihar News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT-6099(Web), QAAUT-6100(Android_MWeb), QAAUT-6101(IOS_MWeb):To verify Uttarakhand News widget is having 6 stories and status is 200")
    @Test
    public void verifyUttarakhandNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkUttarakhandNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Uttarakhand News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT-6102(Web), QAAUT-6103(Android_MWeb), QAAUT-6104(IOS_MWeb):To verify Jharkhand News widget is having 6 stories and status is 200")
    @Test
    public void verifyJharkhandNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkJharkhandNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Jharkhand News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT-6105(Web), QAAUT-6106(Android_MWeb), QAAUT-6107(IOS_MWeb):To verify Chhattisgarh News widget is having 6 stories and status is 200")
    @Test
    public void verifyChhattisgarhNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkChhattisgarhNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Chhattisgarh News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT-6096(Web), QAAUT-6097(Android_MWeb), QAAUT-6098(IOS_MWeb):To verify Madhya Pradesh News widget is having 6 stories and status is 200")
    @Test
    public void verifyMadhyaPradeshNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkMadhyaPradeshNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Madhya Pradesh News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT-6118(Web), QAAUT-6119(Android_MWeb), QAAUT-6120(IOS_MWeb):To verify Maharashtra News widget is having 6 stories and status is 200")
    @Test
    public void verifyMaharashtraNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkMaharashtraNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Maharashtra News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT-6121(Web), QAAUT-6122(Android_MWeb), QAAUT-6123(IOS_MWeb):To verify Rajasthan News widget is having 6 stories and status is 200")
    @Test
    public void verifyRajasthanNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkRajasthanNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Rajasthan News widget is not loading!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT-6124(Web), QAAUT-6125(Android_MWeb), QAAUT-6126(IOS_MWeb):To verify Haryana News widget is having 6 stories and status is 200")
    @Test
    public void verifyHaryanaNewsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = statePage.checkHaryanaNewsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Haryana News widget is not loading!!!!!!!!");
    }

}

