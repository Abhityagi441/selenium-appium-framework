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

public class PrimaryTest {

    private static CommonPrimaryPage primaryPage;
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
        primaryPage = CommonPrimaryPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnPages();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-174 :This test case will Verify Publish , Edit and Refresh pages")
    @Test
    public void verifyPublishEditAndRefreshOnPrimary() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnPrimary", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = primaryPage.publishPrimaryPage(paramsMap.get("primaryName") + urlIndex, paramsMap.get("primaryAlias") + generatedString);
        Assert.assertTrue(isResult, "Publish primary not verified :" + property);

        isResult = subsectionPage.editAndRefreshPage(paramsMap.get("primaryEditName") + urlIndex);
        Assert.assertTrue(isResult, "Edit and Refresh primary not verified :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-173 :This test case will Verify all validation to crete primary page")
    @Test
    public void verifyAllValidationToCreatePrimaryPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAllValidationToCreatePrimaryPage", property);

        isResult = primaryPage.allValidationToCreatePrimaryPage(paramsMap.get("primaryName") + globalVars.getCurrentTimeStamp(), paramsMap.get("primaryAlias") + globalVars.getCurrentTimeStamp());
        Assert.assertTrue(isResult, "All verification not verified :" + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3121 :Section and sub section fields should be present in meta data for primary pages")
    @Test
    public void verifySectionAndSubSectionFieldsShouldBePresentInMetaDataForPrimaryPages() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySectionAndSubSectionFieldsShouldBePresentInMetaDataForPrimaryPages", property);

        isResult = primaryPage.checkSectionAndSubSectionFieldsForPrimaryPages(paramsMap.get("primaryName") + globalVars.getCurrentTimeStamp(), paramsMap.get("primaryAlias") + globalVars.getCurrentTimeStamp());
        Assert.assertTrue(isResult, "Section and sub section fields are not present in meta data for primary pages :" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-4981 :create primary page on live hindustan affiliate")
    @Test
    public void createPrimaryPageOnLiveHindustanAffiliate() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("createPrimaryPageOnLiveHindustanAffiliate" , property);
        isResult=primaryPage.createPrimaryPageOnLiveHindustanAffiliateAndPublish(paramsMap.get("primaryName")+commonFunctions.generateRandomNum(),paramsMap.get("primaryAlias")+commonFunctions.generateRandomNum());
        Assert.assertTrue(isResult, "Section and sub section fields are not present in meta data for primary pages :" + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

}
