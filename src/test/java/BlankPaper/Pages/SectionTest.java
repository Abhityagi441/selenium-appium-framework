package BlankPaper.Pages;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.pages.BlankPaper.genericPages.CommonSubSectionPage;
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

public class SectionTest {

    private static CommonSectionPage sectionPage;
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
        sectionPage = CommonSectionPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnPages();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-178 :This test case will Verify Publish , Edit and Refresh pages")
    @Test
    public void verifyPublishEditAndRefreshOnSection() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnSection", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = sectionPage.publishSectionPage(paramsMap.get("sectionName") + urlIndex, paramsMap.get("sectionAlias") + generatedString);
        Assert.assertTrue(isResult, "Publish section not verified :" + property);

        isResult = subsectionPage.editAndRefreshPage(paramsMap.get("sectionEditName") + urlIndex);
        Assert.assertTrue(isResult, "Edit and Refresh section not verified :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-697 :This test case will Verify all validation to crete section page")
    @Test
    public void verifyAllValidationToCreateSectionPage(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAllValidationToCreateSectionPage", property);

        isResult = sectionPage.allValidationToCreateSectionPage(paramsMap.get("sectionName") + globalVars.getCurrentTimeStamp(), paramsMap.get("sectionAlias") + globalVars.getCurrentTimeStamp());
        Assert.assertTrue(isResult, "All verification not verified :" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-3127: Enable Prefix and Suffix for Title and Description for Section Pages")
    @Test
    @Parameters("property")
    public void enablePrefixAndSuffixForTitleAndDescriptionForSectionAndSubSectionPages() {
        boolean isResult;
        if (this.property.equals("Live Mint")) {
            this.property = property;
            isResult = sectionPage.prefixAndSuffixForTitleAndDescriptionForSectionAndSubSectionPages(property);
            Assert.assertTrue(isResult, "verification of meta fields unsuccessful in" + property + " with type Section and Subsection");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Mint Domain!!! but currently selected domain is "+ property);

        }

    @Author(name = "Raj")
    @Description("QAAUT-4983 : Verify that the user is able to Create A Page (Section) with Livehindustan Affiliate tanent")
    @Test
    public void verifyThatUserIsAbleToCreateSectionPageWithLivehindustanAffiliateTanent() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateSectionPageWithLivehindustanAffiliateTanent", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            Random randomNo = new Random();
            int urlIndex = randomNo.nextInt(1000);
            String generatedString = RandomStringUtils.randomAlphabetic(5);

            isResult = sectionPage.checkCreateSectionPageWithLivehindustanAffiliateTanent(this.property, paramsMap.get("sectionName") + urlIndex, paramsMap.get("sectionAlias") + generatedString);
            Assert.assertTrue(isResult, "User is not able to Create A Page (Section) with Livehindustan Affiliate tanent :" + property);
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