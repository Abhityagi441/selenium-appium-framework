package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
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

public class LatestNewsTest extends BaseTest {

    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage ;

    private static CommonLatestNewsPage latestNewsPage ;
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
    }

    @Author(name = "Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify user is able to navigate to LatestNewsPage")
    @Test
    public void verifyUserAbleToNavigateToLatestNewsPage() {
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyUserAbleToNavigateToLatestNewsPage");
        boolean isExpectedBreadCrumbDisplayed = latestNewsPage.navigateToLatestNewsPage(params.get("expectedBreadCrumb"),params.get("URLContains"));
        Assert.assertTrue(isExpectedBreadCrumbDisplayed,"Expected BreadCrumb is not Displayed");
    }

    @Author(name = "Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify all top 10 stories widget are clickable & status code is 200")
    @Test
    public void verifyAllTopStoriesWidgetAreClickableAndGivingOkStatusCode() {
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAllTopStoriesWidgetAreClickableAndGivingOkStatusCode");
        int noOfStories = Integer.parseInt(params.get("noOfStories"));
        boolean isLatestNewsPage = latestNewsPage.navigateToLatestNewsPage();
        Assert.assertTrue(isLatestNewsPage,"FAILED to navigate to Latest News Page");
        boolean isAllStoriesClickable = latestNewsPage.checkTopStoriesWidget(noOfStories);
        Assert.assertTrue(isAllStoriesClickable,"All top stories are not clickable");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify advertisement is displayed at the TOP of latest news page")
    @Test
    public void verifyTopAdsDisplayedOnLatestNewsPage(){
        boolean isLatestNewsPage = latestNewsPage.navigateToLatestNewsPage();
        Assert.assertTrue(isLatestNewsPage,"FAILED to navigate to Latest News Page");
        boolean isStepTrue = latestNewsPage.checkTopAdDisplaying_2();
        Assert.assertTrue(isStepTrue, "Top Header Ads not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify advertisement is displayed at the BOTTOM of latest news page")
    @Test
    public void verifyBottomAdsDisplayedOnLatestNewsPage(){
        boolean isLatestNewsPage = latestNewsPage.navigateToLatestNewsPage();
        Assert.assertTrue(isLatestNewsPage,"FAILED to navigate to Latest News Page");
        boolean isStepTrue = latestNewsPage.checkBottomAdsDisplaying_3();
        Assert.assertTrue(isStepTrue, "Bottom Ads not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify three advertisements are displayed at the RHS of latest news page")
    @Test
    public void verifyRHSAdsDisplayedOnLatestNewsPage(){
        boolean isLatestNewsPage = latestNewsPage.navigateToLatestNewsPage();
        Assert.assertTrue(isLatestNewsPage,"FAILED to navigate to Latest News Page");
        boolean isStepTrue = latestNewsPage.checkHomePageRHSAdsAreDisplayed_1();
        Assert.assertTrue(isStepTrue, "Right hand side Ads are not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify user is able to navigation to home page using breadcrumb link")
    @Test
    public void verifyNavigationToHomePageUsingBreadCrumb(){
        boolean isStepTrue = latestNewsPage.checkNavigationToHomePageUsingBreadCrumb();
        Assert.assertTrue(isStepTrue, "FAILED to navigate to Home Page");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify the pagination all top stories are clickable & returns status code as 200 on Page 2 & Page 3")
    @Test
    public void verifyAllTopStoriesWidgetAreClickableAndGivingOkStatusCodeOnPage2AndPage3(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAllTopStoriesWidgetAreClickableAndGivingOkStatusCode");
        int noOfStories = Integer.parseInt(params.get("noOfStories"));
        boolean isLatestNewsPage = latestNewsPage.navigateToLatestNewsPage();
        Assert.assertTrue(isLatestNewsPage,"FAILED to navigate to Latest News Page");
        boolean isStepTrue = latestNewsPage.checkPagination(noOfStories,params.get("URLContains"));
        Assert.assertTrue(isStepTrue, "Pagination FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3522 || WEB || HTAuto Sanity - To verify the top automobiles, top comparisons & search by widgets are displaying on latest news page")
    @Test
    public void verifyAllWidgetsAreDisplaying(){
        boolean isLatestNewsPage = latestNewsPage.navigateToLatestNewsPage();
        Assert.assertTrue(isLatestNewsPage,"FAILED to navigate to Latest News Page");
        boolean isStepTrue = latestNewsPage.checkAllWidgetsAreDisplaying();
        Assert.assertTrue(isStepTrue, "All widgets are not displaying");
    }
}
