
package BlankPaper.SideBar;
import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonUsersPage;
import com.pages.BlankPaper.genericPages.CommonSubSectionPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;
public class UsersTest {

    private static CommonUsersPage UsersPage;
    private static CommonSubSectionPage subsectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        System.out.println(property);
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        subsectionPage = CommonSubSectionPage.getInstance();
        UsersPage = CommonUsersPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnUsers();
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5540 - verify That User Is Able To See Users Tab Present In Sidebar")
    @Test()
    public void verifyThatUserIsAbleToSeeUsersTabPresentInSidebar() {
        boolean isResult;
        isResult=UsersPage.CheckIfUserIsAbleToSeeUsersTabPresentInSidebar();
        Assert.assertTrue(isResult, "failed to check if user can see users tab"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5540 - verifyThatUserIsAbleToClickOnUsersTabPresentInSidebar")
    @Test()
    public void verifyThatUserIsAbleToClickOnUsersTabPresentInSidebar() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatUserIsAbleToClickOnUsersTabPresentInSidebar", property);
        isResult=UsersPage.CheckIfUserIsAbleToClickOnUsersTabPresentInSidebar(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to click on users tab in the sidebar for tenant"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5541 - verifyThatUserIsAbleToSeeFifteenHorizontalTabsOnTheUsersPage")
    @Test()
    public void verifyThatUserIsAbleToSeeFifteenHorizontalTabsOnTheUsersPage() {
        boolean isResult;
        isResult=UsersPage.CheckIfUserIsAbleToSeeFifteenHorizontalTabsOnTheUsersPage();
        Assert.assertTrue(isResult, "failed to check 15 tabs inside users tab"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5542,43 - verifyThatAllTheFifteenTabsShouldBeClickable" +
            "verifyThatBackgroundColorShouldBecomeWhiteWhenUserClickOnAnyOfTheTab")
    @Test()
    public void verifyThatBackgroundColorShouldBecomeWhiteWhenUserClickOnAnyOfTheTab() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatBackgroundColorShouldBecomeWhiteWhenUserClickOnAnyOfTheTab", property);
        isResult=UsersPage.CheckIfBackgroundColorShouldBecomeWhiteWhenUserClickOnAnyOfTheTab(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to check bg color of 15 tabs inside users tab"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5544 - verifyThatOutlineColorShouldBecomeBlueWhenUserClickOnAnyOfTheTab")
    @Test()
    public void verifyThatOutlineColorShouldBecomeBlueWhenUserClickOnAnyOfTheTab() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatOutlineColorShouldBecomeBlueWhenUserClickOnAnyOfTheTab", property);
        isResult=UsersPage.CheckIfOutlineColorShouldBecomeBlueWhenUserClickOnAnyOfTheTab(paramsMap.get("borderColor"));
        Assert.assertTrue(isResult, "failed to check bg color of 15 tabs inside users tab"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5545 - verifyThatAllTheEightFieldShouldBePresentOnUsersPage")
    @Test()
    public void verifyThatAllTheEightFieldShouldBePresentOnUsersPage() {
        boolean isResult;
        isResult=UsersPage.CheckIfAllTheEightFieldShouldBePresentOnUsersPage();
        Assert.assertTrue(isResult, "failed to check all 8 fields inside users tab"+property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5546 - verifyThatAllTheEightFieldsShouldBeClickable")
    @Test()
    public void verifyThatAllTheEightFieldsShouldBeClickable() {
        boolean isResult;
        isResult=UsersPage.CheckIfAllTheEightFieldsShouldBeClickable();
        Assert.assertTrue(isResult, "failed to click on some or all of 8 fields inside users tab"+property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }
}
