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

public class TopicTest {

    private static CommonTopicPage topicPage;
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
        topicPage = CommonTopicPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnPages();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-176 :This test case will Verify Publish , Edit and Refresh pages")
    @Test
    public void verifyPublishEditAndRefreshOnTopic() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnTopic", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = topicPage.publishTopicPage(paramsMap.get("topicName") + urlIndex, paramsMap.get("topicAlias") + generatedString);
        Assert.assertTrue(isResult, "Publish topic not verified :" + property);

        isResult = subsectionPage.editAndRefreshPage(paramsMap.get("topicEditName") + urlIndex);
        Assert.assertTrue(isResult, "Edit and Refresh topic not verified :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-695, QAAUT-175 :This test case will Verify all validation to crete topic page")
    @Test
    public void verifyAllValidationToCreateTopicPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAllValidationToCreateTopicPage", property);

        isResult = topicPage.allValidationToCreateTopicPage(paramsMap.get("topicName") + globalVars.getCurrentTimeStamp(), paramsMap.get("topicAlias") + globalVars.getCurrentTimeStamp());
        Assert.assertTrue(isResult, "All verification not verified :" + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-4982 : Verify that the user is able to Create A Page (Topic) with Livehindustan Affiliate tanent")
    @Test
    public void verifyUserIsAbleToCreateTopicPageWithLivehindustanAffiliateTanent() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserIsAbleToCreateTopicPageWithLivehindustanAffiliateTanent", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            Random randomNo = new Random();
            int urlIndex = randomNo.nextInt(1000);
            String generatedString = RandomStringUtils.randomAlphabetic(5);

            isResult = topicPage.checkCreateTopicWithLivehindustanAffiliate(this.property, paramsMap.get("topicName") + urlIndex, paramsMap.get("topicAlias") + generatedString);
            Assert.assertTrue(isResult, "User is not able to Create A Page (Topic) with Livehindustan Affiliate tanent:" + property);
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