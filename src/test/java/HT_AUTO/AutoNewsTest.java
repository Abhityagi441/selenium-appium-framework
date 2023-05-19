package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonAutoNewsPage;
import com.pages.HT_AUTO.genericPages.CommonHomePage;
import com.pages.HT_AUTO.genericPages.CommonLatestNewsPage;
import com.pages.HT_AUTO.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class AutoNewsTest extends BaseTest {

    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage ;
    private static CommonLatestNewsPage latestNewsPage ;
    private static CommonAutoNewsPage autoNewsPage ;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        latestNewsPage = CommonLatestNewsPage.getInstance();
        autoNewsPage = CommonAutoNewsPage.getInstance();
    }

    @Author(name = "Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify user is able to navigate to Auto News page")
    @Test
    public void verifyUserAbleToNavigateToAutoNewsPage() {
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyUserAbleToNavigateToAutoNewsPage");
        boolean isExpectedBreadCrumbDisplayed = autoNewsPage.navigateToAutoNewsPage(params.get("expectedBreadCrumb"),params.get("URLContains"));
        Assert.assertTrue(isExpectedBreadCrumbDisplayed,"Expected BreadCrumb is not Displayed");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify the pagination all top stories are clickable & returns status code as 200 till Page 3")
    @Test
    public void verifyAllTopStoriesWidgetAreClickableAndGivingOkStatusCodeTillPage3OnAutoNewsPage(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAllTopStoriesWidgetAreClickableAndGivingOkStatusCodeTillPage3OnAutoNewsPage");
        int noOfStories = Integer.parseInt(params.get("noOfStories"));
        boolean isAutoNewsPage = autoNewsPage.navigateToAutoNewsPage();
        Assert.assertTrue(isAutoNewsPage,"FAILED to navigate to Auto News Page");
        boolean isStepTrue = latestNewsPage.checkPagination(noOfStories,params.get("URLContains"));
        Assert.assertTrue(isStepTrue, "Pagination FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify advertisement is displayed at the TOP of auto news page")
    @Test
    public void verifyTopAdsDisplayedOnAutoNewsPage(){
        boolean isAutoNewsPage = autoNewsPage.navigateToAutoNewsPage();
        Assert.assertTrue(isAutoNewsPage,"FAILED to navigate to Auto News Page");
        boolean isStepTrue = latestNewsPage.checkTopAdDisplaying_2();
        Assert.assertTrue(isStepTrue, "Top Header Ads not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify advertisement is displayed at the BOTTOM of auto news page")
    @Test
    public void verifyBottomAdsDisplayedOnAutoNewsPage(){
        boolean isAutoNewsPage = autoNewsPage.navigateToAutoNewsPage();
        Assert.assertTrue(isAutoNewsPage,"FAILED to navigate to Auto News Page");
        boolean isStepTrue = latestNewsPage.checkBottomAdsDisplaying_3();
        Assert.assertTrue(isStepTrue, "Bottom Ads not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify three advertisements are displayed at the RHS of auto news page")
    @Test
    public void verifyRHSAdsDisplayedOnAutoNewsPage(){
        boolean isAutoNewsPage = autoNewsPage.navigateToAutoNewsPage();
        Assert.assertTrue(isAutoNewsPage,"FAILED to navigate to Auto News Page");
        boolean isStepTrue = latestNewsPage.checkHomePageRHSAdsAreDisplayed_1();
        Assert.assertTrue(isStepTrue, "Right hand side Ads are not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify the top automobiles, top comparisons & search by widgets are displaying on auto news page")
    @Test
    public void verifyAllWidgetsAreDisplayingOnAutoNewsPage(){
        boolean isAutoNewsPage = autoNewsPage.navigateToAutoNewsPage();
        Assert.assertTrue(isAutoNewsPage,"FAILED to navigate to Auto News Page");
        boolean isStepTrue = latestNewsPage.checkAllWidgetsAreDisplaying();
        Assert.assertTrue(isStepTrue, "All widgets are not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify user is able to navigation to home page using breadcrumb link from auto news page")
    @Test
    public void verifyNavigationToHomePageUsingBreadCrumbOnAutoNewsPage(){
        boolean isStepTrue = autoNewsPage.checkNavigationToHomePageUsingBreadCrumb();
        Assert.assertTrue(isStepTrue, "FAILED to navigate to Home Page");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3525 || WEB || HTAuto Sanity - To verify user is able to navigation to auto page using breadcrumb link from auto news page")
    @Test
    public void verifyNavigationToAutoPageUsingBreadCrumbOnAutoNewsPage(){
        boolean isStepTrue = autoNewsPage.checkNavigationToAutoPageUsingBreadCrumb();
        Assert.assertTrue(isStepTrue, "FAILED to navigate to Auto Page");
    }
}
