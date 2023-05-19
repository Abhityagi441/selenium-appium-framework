package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.pages.LiveHindustan.genericPages.CommonNewsBriefPage;
import com.pages.LiveHindustan.genericPages.CommonVideoPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class NewsBriefTest extends BaseTest {

    private static CommonNewsBriefPage newsBriefPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            newsBriefPage = CommonNewsBriefPage.getInstance();
            loginPage = CommonLoginPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            newsBriefPage = CommonNewsBriefPage.getInstance();
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
    @Description("Sanity || QAAUT-6158(Android-MWeb), QAAUT-6159(IOS-MWeb): All categories are present and giving 200 status code on news-brief page")
    @Test
    public void verifyAllCategoriesAndGiving200StatusCodeOnNewsBriefPage() {
        boolean isStepTrue;
        isStepTrue = newsBriefPage.checkAllCategoriesAndGiving200StatusCodeOnNewsBriefPage();
        Assert.assertTrue(isStepTrue, "categories are not present or not giving 200 status code on news-brief page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6156(Android-MWeb), QAAUT-6157(IOS-MWeb): To verify news-brief page is giving 200 status code after landing on it")
    @Test
    public void verifyNewsBriefPageIsGiving200StatusCodeAfterLanding() {
        boolean isStepTrue;
        isStepTrue = newsBriefPage.checkNewsBriefPageIsGiving200StatusCodeAfterLanding();
        Assert.assertTrue(isStepTrue, "news-brief page is not giving 200 status code after landing on it!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6160(Android-MWeb), QAAUT-6161(IOS-MWeb): To verify all related news are present for that particular category")
    @Test
    public void verifyAllRelatedNewsArePresentForThatParticularCategory() {
        boolean isStepTrue;
        isStepTrue = newsBriefPage.checkAllRelatedNewsArePresentForThatParticularCategory();
        Assert.assertTrue(isStepTrue, "All related news are not present for that particular category!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6162(Android-MWeb), QAAUT-6163(IOS-MWeb): To verify while swiping the stories URL should change")
    @Test
    public void verifyWhileSwipingTheStoriesUrlShouldChange() {
        boolean isStepTrue;
        isStepTrue = newsBriefPage.checkWhileSwipingTheStoriesUrlShouldChange();
        Assert.assertTrue(isStepTrue, "while swiping the stories URL is not changing!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6164(Android-MWeb), QAAUT-6165(IOS-MWeb): To verify social sharing redirection on news-brief page")
    @Test
    public void verifySocialSharingRedirectionOnNewsBriefPage() {
        boolean isStepTrue;
        isStepTrue = newsBriefPage.checkSocialSharingRedirectionOnNewsBriefPage();
        Assert.assertTrue(isStepTrue, "social sharing icons are not redirecting respected page on news-brief page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6166(Android-MWeb), QAAUT-6167(IOS-MWeb): To verify redirection of puri khabar padhe on news-brief page")
    @Test
    public void verifyRedirectionOfPuriKhabarPadheOnNewsBriefPage() {
        boolean isStepTrue;
        isStepTrue = newsBriefPage.checkRedirectionOfPuriKhabarPadheOnNewsBriefPage();
        Assert.assertTrue(isStepTrue, "Redirection of puri khabar padhe is not proper on news-brief page!!!!!!!!");
    }
}
