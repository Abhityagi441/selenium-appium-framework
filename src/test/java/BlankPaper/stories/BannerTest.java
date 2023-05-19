package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonBannerPage;
import com.pages.BlankPaper.genericPages.CommonCollectionPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonStandardStoryPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.BannerPage;
import com.pages.BlankPaper.webdesktop.stories.CollectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class BannerTest {
    private static CommonBannerPage bannerPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonStandardStoryPage standardStoryPage;
    SoftAssert softAssert = new SoftAssert();

    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        globalVars.setBpTenant(property);
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        bannerPage = CommonBannerPage.getInstance();
        standardStoryPage = CommonStandardStoryPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnAllElement();
    }

    @Author(name = "Raj")
    @Description("QAAUT-3122: Input fields should be displayed for Banner name , landing URL, and image section for both uploading new image and selecting from gallery.")
    @Test
    public void verifyInputFieldsShouldBeDisplayedForBanner() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = bannerPage.checkInputFieldsShouldBeDisplayedForBanner();
        Assert.assertTrue(isResult, "Input fields are not displayed for Banner : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3123: User should be able to create banner - Affiliate - Banner Management")
    @Test
    public void verifyUserShouldBeAbleToCreateBanner() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyUserShouldBeAbleToCreateBanner" , property);
        String bannerName = paramsMap.get("BannerName")+commonFunctions.generateRandomNum();
        String metaBannerName = paramsMap.get("MetaBannerName")+commonFunctions.generateRandomNum();
        isResult = bannerPage.checkUserShouldBeAbleToCreateBanner(bannerName, paramsMap.get("BannerLandingUrl"), metaBannerName, paramsMap.get("MetaTags"), paramsMap.get("MetaExternalUrl"));
        Assert.assertTrue(isResult, "User is not able to create banner : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
        if (globalVars.isProdRun()) {
            dashboardPage.clickOnAllElement();
            dashboardPage.elementCleanup(BannerPage.bannerId);
        } else {
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
