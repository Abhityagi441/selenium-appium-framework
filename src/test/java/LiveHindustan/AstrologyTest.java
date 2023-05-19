package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonAastrologyPage;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

public class AstrologyTest extends BaseTest {
    private static CommonAastrologyPage astrologyPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        loginPage = CommonLoginPage.getInstance();
        astrologyPage = CommonAastrologyPage.getInstance();
        /*Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
            Assert.assertTrue(isStepTrue, "Login with Email and Password failed");
        }*/
    }

    @AfterClass
    public void afterClass() {
        switch (globalVars.getPlatformName()) {
            case Constants.ANDROID_WEB:
            case Constants.IOS_WEB:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                commonFunctionsMobile.waitForPageToLoad();
                break;
            case Constants.DESKTOP_WEB:
                commonFunctionsWeb = CommonFunctionsWeb.getInstance();
                commonFunctionsWeb.navigateToURL(globalVars.getURL());
                break;
        }
        /*boolean isStepTrue = loginPage.logout();
        if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
            Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
        }*/
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-3034 (Web), QAAUT-3515(Android MWeb), QAAUT-4582(LH-MWeb-IOS) :To verify widgets on astrology landing page")
    @Test
    public void verifyWidgetsOnAstrologyLandingPage() {
        boolean isStepTrue;
        isStepTrue = astrologyPage.checkAstrologyLandingPage();
        Assert.assertTrue(isStepTrue, "Astrology landing page not display properly!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-5733(LH-Web),QAAUT-5737(LH-MWeb-Android),QAAUT-6023(LH-Mweb-IOS):To verify redirection to rashifal page from rashifal widget from Astrology page ")
    @Test
    public void verifyRedirectionToRashifalPageFromRashifalWidgetFromAstrologyPage() {
        boolean isStepTrue;
        isStepTrue = astrologyPage.checkRashiFalLinks();
        Assert.assertTrue(isStepTrue, "Rashifal link is failed!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT- 3157 (Web),3517(Android_MWeb),QAAUT-4573(LH-MWeb-IOS): To verify URL is getting changed according to Rashi from astrology page")
    @Test
    public void verifyURLIsGettingChangedAccordingToRashiFromAstrologyPage() {
        boolean isStepTrue;
        isStepTrue = astrologyPage.checkRashiFalPage();
        Assert.assertTrue(isStepTrue, "Pura padhey link is failed!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6168 (Web), QAAUT-6169(Android MWeb), QAAUT-6170(MWeb-IOS) :All L2 Sub-Menu are present and giving 200 status code on Astrology Page")
    @Test
    public void verifyAllSubMenuArePresentAndGiving200StatusCodeOnAstrologyPage() {
        boolean isStepTrue;
        isStepTrue = astrologyPage.checkAllSubMenuArePresentAndGiving200StatusCodeOnAstrologyPage();
        Assert.assertTrue(isStepTrue, "All L2 Sub-Menu are not present or not giving 200 status code on Astrology Page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6171 (Web), QAAUT-6172(Android MWeb), QAAUT-6173(MWeb-IOS) :To verify data is getting displayed under different tabs on selected rashi")
    @Test
    public void verifyDataIsDisplayedUnderDifferentTabsOnSelectedRashi() {
        boolean isStepTrue;
        isStepTrue = astrologyPage.checkDataIsDisplayedUnderDifferentTabsOnSelectedRashi();
        Assert.assertTrue(isStepTrue, "Data is not getting displayed under different tabs on selected rashi!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT- 6182(Web),QAAUT-6129(Android_MWeb),QAAUT-6130(LH-MWeb-IOS):To verify clicking on any rashi redirects to correct URL on rashifal detail page")
    @Test
    public void verifyClickingOnAnyRashiRedirectsToCorrectURLOnRashifalDetailPage() {
        boolean isStepTrue;
        isStepTrue = astrologyPage.checkClickingOnAnyRashiRedirectsToCorrectURLOnRashifalDetailPage();
        Assert.assertTrue(isStepTrue, "Rashi redirects to correct URL on rashifal detail page is failed!!!!!!!!");
    }

}
