package BlankPaper.Pages;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.*;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class SubSectionTest {

    private static CommonSubSectionPage subsectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        subsectionPage = CommonSubSectionPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnPages();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-180 :This test case will Verify Publish , Edit and Refresh pages")
    @Test
    public void verifyPublishEditAndRefreshOnSubSection() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnSubSection", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = subsectionPage.publishSubSectionPage(paramsMap.get("subSectionName") + urlIndex, paramsMap.get("subSectionAlias") + generatedString);
        Assert.assertTrue(isResult, "Publish Sub-section not verified :" + property);

        isResult = subsectionPage.editAndRefreshPage(paramsMap.get("subSectionEditName") + urlIndex);
        Assert.assertTrue(isResult, "Edit and Refresh Sub-section not verified :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-699 :This test case will Verify all validation to crete subsection page")
    @Test
    public void verifyAllValidationToCreateSubsectionPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAllValidationToCreateSubsectionPage", property);

        isResult = subsectionPage.allValidationToCreateSubsectionPage(paramsMap.get("subSectionName") + globalVars.getCurrentTimeStamp(), paramsMap.get("subSectionAlias") + globalVars.getCurrentTimeStamp());
        Assert.assertTrue(isResult, "All verification not verified :" + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-4984 : Verify that the user is able to Create A Page (SubSection) with Livehindustan Affiliate Tanent")
    @Test
    public void verifyUserIsAbleToCreateASubSectionPageWithLivehindustanAffiliateTanent() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserIsAbleToCreateASubSectionPageWithLivehindustanAffiliateTanent", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            Random randomNo = new Random();
            int urlIndex = randomNo.nextInt(1000);
            String generatedString = RandomStringUtils.randomAlphabetic(5);

            isResult = subsectionPage.checkCreateSubSectionPageWithLivehindustanAffiliateTanent(this.property, paramsMap.get("subSectionName") + urlIndex, paramsMap.get("subSectionAlias") + generatedString);
            Assert.assertTrue(isResult, "User is not able to Create A Page (SubSection) with Livehindustan Affiliate Tanent :" + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }



    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }


}