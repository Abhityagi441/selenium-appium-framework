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

public class ExternalTest {

    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonExternalPage externalPage;
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
        externalPage = CommonExternalPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnPages();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-184 :This test case will Verify Publish and Edit pages")
    @Test
        public void verifyPublishAndEditOnExternal() {
        boolean isResult;

        if (this.property.equals("Bangla") || this.property.equals("HT NEW")){
            Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishAndEditOnExternal", property);
            Random randomNo = new Random();
            int urlIndex = randomNo.nextInt(1000);
            String generatedString = RandomStringUtils.randomAlphabetic(5);

            isResult = externalPage.createAndPublishExternalPage(paramsMap.get("externalName") + urlIndex, paramsMap.get("externalURL") + generatedString, paramsMap.get("typeFilterValue"));
            Assert.assertTrue(isResult, "Publish External not verified :" + property);

            isResult = externalPage.editExternal(paramsMap.get("editExternalName") + urlIndex, paramsMap.get("typeFilterValue"));
            Assert.assertTrue(isResult, "Edit External not verified :" + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }


}

