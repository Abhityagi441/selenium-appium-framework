package BlankPaper.notifications;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonNotificationsPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.notifications.NotificationsPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

import static com.pages.BlankPaper.genericPages.CommonStandardStoryPage.getInstance;

public class NotificationsTest {

    private static CommonNotificationsPage notificationsPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property ="";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property=property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        globalVars.setBpTenant(property);
        notificationsPage = CommonNotificationsPage.getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }
    @BeforeMethod
    public void ensureHomePageVisibility(){
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Raj")
    @Description("QAAUT-3068:Verify that user is able to send notifications for Tamil tenants.")
    @Test
    public void verifyThatUserIsAbleToSendNotificationsForTamilTenants() {
        if (this.property.equals("Tamil")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToSendNotificationsForTamilTenants", property);
        isResult = notificationsPage.checkThatUserIsAbleToSendNotificationsForTamilTenants(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "user can not send notification for Tamil tenants" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3111:Verify that user is able to send notifications for Marathi tenant.")
    @Test
    public void verifyThatUserIsAbleToSendNotificationsForMarathiTenants() {
        if (this.property.equals("Marathi")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToSendNotificationsForMarathiTenants", property);
        isResult = notificationsPage.checkThatUserIsAbleToSendNotificationsForMarathiTenants(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "user can not send notification for Marathi tenants" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3112:Verify that user is able to send notifications for Telugu tenant.")
    @Test
    public void verifyThatUserIsAbleToSendNotificationsForTeluguTenants() {
        if (this.property.equals("Telugu")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToSendNotificationsForTeluguTenants", property);
        isResult = notificationsPage.checkThatUserIsAbleToSendNotificationsForTeluguTenants(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "user can not send notification for Telugu tenants" + property);
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
        if(globalVars.isProdRun()) {
            dashboardPage.clickOnBlankPaperLogo();
            dashboardPage.storyCleanup(NotificationsPage.storyIdNumber);
        }
        else{
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
