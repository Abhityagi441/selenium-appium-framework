package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonInputFormPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.InputFormPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class InputFormTest {

    private static CommonInputFormPage createInputFormPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    SoftAssert softAssert = new SoftAssert();
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
        createInputFormPage = CommonInputFormPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnAllElement();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-171 :This test case will Verify Filters")
    @Test(priority = -1)
    public void verifyFiltersCreateInputForm() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyFiltersCreateInputForm", property);
        String inputFormName=paramsMap.get("name")+globalVars.getCurrentTimeStamp();

        isResult = createInputFormPage.createAndValidateInputForm(inputFormName,paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("topics"));
        Assert.assertTrue(isResult, "Element not Created :" + property);

        isResult = createInputFormPage.createdOnFilter(inputFormName);
        softAssert.assertTrue(isResult, "Created On Filter not Working:" + property);

        isResult = createInputFormPage.typeFilter( inputFormName, paramsMap.get("type"));
        softAssert.assertTrue(isResult, "Type Filter not Working:" + property);

        isResult = createInputFormPage.statusFilter( inputFormName, paramsMap.get("status"));
        softAssert.assertTrue(isResult, "Status Filter not Working:" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-168 :This test case will Verify Refresh and Publish InputForm Status")
    @Test
    public void verifyRefreshAndPublish() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyRefreshAndPublish", property);

        isResult = createInputFormPage.refreshAndPublish(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("topics"));
        Assert.assertTrue(isResult, "Create Input Form not Published :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-170 :This test case will Verify Search Section on Elements Page")
    @Test
    public void verifySearchSection() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySearchSection", property);

        if(!globalVars.isProdRun()) {
            isResult = createInputFormPage.createAndValidateInputForm(paramsMap.get("name"), paramsMap.get("tags"), paramsMap.get("URL"), paramsMap.get("topics"));
            Assert.assertTrue(isResult, "Element not Created :" + property);
        }
        isResult = createInputFormPage.searchSection();
        Assert.assertTrue(isResult, "Search Section not working :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-169 :This test case will Verify Create InputForm Status and Discard the Element")
    @Test
    public void verifyCreateInputFormDiscardElement() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateInputFormDiscardElement", property);

        if(!globalVars.isProdRun()) {
            isResult = createInputFormPage.createAndValidateInputForm(paramsMap.get("name"), paramsMap.get("tags"), paramsMap.get("URL"), paramsMap.get("topics"));
            Assert.assertTrue(isResult, "Element not Created :" + property);
        }

        isResult = createInputFormPage.discardElements();
        Assert.assertTrue(isResult, "Element not Discarded :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-167 :This test case will Verify Create InputForm Metadata Section")
    @Test
    public void verifyCreateInputFormMetadataSection() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateInputFormMetadataSection", property);

        isResult=createInputFormPage.metadataName(paramsMap.get("name"));
        softAssert.assertTrue(isResult, "Name not Selected:" + property);

        isResult=createInputFormPage.metadataTags(paramsMap.get("tags"));
        softAssert.assertTrue(isResult, "Tags not Selected:" + property);

        isResult=createInputFormPage.metadataExternalURL(paramsMap.get("URL"));
        softAssert.assertTrue(isResult, "External URL not Selected:" + property);
        isResult=dashboardPage.discardElement();
        softAssert.assertTrue(isResult, "Input form deletion failed !!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-165,QAAUT-163, QAAUT-169 :This test case will Verify More Add Trending Topic And Delete")
    @Test
    public void verifyMoreAddTrendingTopicAndDelete() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyMoreAddTrendingTopicAndDelete", property);

        isResult = createInputFormPage.createInputFormAndValidateTrendingTopicAddAndDelete(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("topics"));
        Assert.assertTrue(isResult, "Trending Topic not Deleted :" + property);

        isResult = createInputFormPage.discardElements();
        Assert.assertTrue(isResult, "Element not Discarded :" + property);
    }

     @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
        if (globalVars.isProdRun()) {
            dashboardPage.clickOnAllElement();
            dashboardPage.elementCleanup(InputFormPage.elementId);
        } else {
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
