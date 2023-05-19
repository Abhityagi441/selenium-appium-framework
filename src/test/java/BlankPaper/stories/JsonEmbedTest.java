package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonInputFormPage;
import com.pages.BlankPaper.genericPages.CommonJsonEmbedPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.JsonEmbedPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.Random;

public class JsonEmbedTest {

    private static CommonInputFormPage createInputFormPage;
    private static CommonJsonEmbedPage createJsonEmbedPage ;
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
        createJsonEmbedPage = CommonJsonEmbedPage.getInstance();
        createInputFormPage = CommonInputFormPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnAllElement();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-159 :This test case will create Json Embed and verify the status ")
    @Test(priority = -1)
    public void verifyCreateJsonEmbed() {
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateJsonEmbed" , property);
        boolean isResult = createJsonEmbedPage.createJsonEmbed(paramsMap.get("addJsonURL"), paramsMap.get("name") + globalVars.getCurrentTimeStamp(), paramsMap.get("tags"), paramsMap.get("externalURL"), paramsMap.get("jsonSourceURL"),paramsMap.get("subType"));
        Assert.assertTrue(isResult, "Json Embed not created : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-158 :This test case will create Json Embed and Publish and verify the status ")
    @Test
    public void verifyPublishCreateJsonEmbed() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPublishCreateJsonEmbed" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);

        isResult = createJsonEmbedPage.createJsonEmbed(paramsMap.get("addJsonURL"), paramsMap.get("name")+ urlIndex,paramsMap.get("tags"), paramsMap.get("externalURL"), paramsMap.get("jsonSourceURL"),paramsMap.get("subType"));
        Assert.assertTrue(isResult, "Json Embed not created : " + property);

        isResult = createJsonEmbedPage.publishJsonEmbed();
        Assert.assertTrue(isResult, "Json Embed not published : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-157 :This test case will create Json Embed and Discard the created Element ")
    @Test
    public void verifyDiscardCreateJsonEmbed() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDiscardCreateJsonEmbed" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        if(!globalVars.isProdRun()) {
            isResult = createJsonEmbedPage.createJsonEmbed(paramsMap.get("addJsonURL"), paramsMap.get("name") + urlIndex, paramsMap.get("tags"), paramsMap.get("externalURL"), paramsMap.get("jsonSourceURL"), paramsMap.get("subType"));
            Assert.assertTrue(isResult, "Json Embed not created : " + property);
        }

        isResult=dashboardPage.findAndDiscardElement(JsonEmbedPage.jsonEmbedId);
        Assert.assertTrue(isResult, "Element not Discarded :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-145 :This test case will Verify Create JsonEmbed Metadata Section")
    @Test
    public void verifyCreateJsonEmbedMetadataSection() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateJsonEmbedMetadataSection" , property);

        isResult=createJsonEmbedPage.metadataName( paramsMap.get("addJsonURL"),paramsMap.get("name"));
        softAssert.assertTrue(isResult, "Name not Selected:" + property);

        isResult=createInputFormPage.metadataTags(paramsMap.get("tags"));
        softAssert.assertTrue(isResult, "Tags not Selected:" + property);

        isResult=createInputFormPage.metadataExternalURL(paramsMap.get("externalURL"));
        softAssert.assertTrue(isResult, "External URL not Selected:" + property);

        isResult=createJsonEmbedPage.metadataJsonSourceURL(paramsMap.get("jsonSourceURL"));
        softAssert.assertTrue(isResult, "JsonSourceURL not Selected:" + property);

        isResult=createJsonEmbedPage.metadataSubType(paramsMap.get("subType"),this.property);
        softAssert.assertTrue(isResult, "SubType not Selected:" + property);
//        isResult=dashboardPage.discardElement(JsonEmbedPage.jsonEmbedId);
//        softAssert.assertTrue(isResult, "Json Embed deletion failed !!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-161 :This test case will verify cancel button ")
    @Test
    public void verifyCreateJsonEmbedCancelButton() {
        boolean isResult = createJsonEmbedPage.cancelButton();
        Assert.assertTrue(isResult, "Json Embed not created : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-103 :This test case will verify Create ,Publish and Edit Refresh Page ")
    @Test
    public void verifyJsonEmbedCreatePublishEditRefreshPage() {
        Map<String, String> paramsMap = globalVars.getParamsData("verifyJsonEmbedCreatePublishEditRefreshPage", property);
        boolean isResult = createJsonEmbedPage.createPublishEditRefreshPage(paramsMap.get("addJsonURL"),paramsMap.get("name"),paramsMap.get("editName"),paramsMap.get("tags"),paramsMap.get("externalURL"),paramsMap.get("jsonSourceURL"), paramsMap.get("subType"), this.property);
        Assert.assertTrue(isResult, "After refresh a Page Data is lost in Create Publish Edit json Embed : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-153 :This test case will verify json code validation toaster massage")
    @Test
    public void verifyJsonEmbedCodeValidation() {
        Map<String, String> paramsMap = globalVars.getParamsData("verifyJsonEmbedCodeValidation", property);
        boolean isResult = createJsonEmbedPage.jsonCodeValidation(paramsMap.get("addJsonURL"));
        Assert.assertTrue(isResult, "Json Embed code not validate : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-154 :This test case will verify json Embed code page ")
    @Test
    public void verifyJsonEmbedCodePage() {
        Map<String, String> paramsMap = globalVars.getParamsData("verifyJsonEmbedCodePage", property);
        boolean isResult = createJsonEmbedPage.jsonEmbedCodePage(paramsMap.get("addJsonURL"));
        Assert.assertTrue(isResult, "Json Embed Code Page is not available : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-160 :This test case will create Json Embed and edit and verify the status ")
    @Test
    public void verifyCreateJsonEmbedEditStatus() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateJsonEmbedEditStatus" , property);

        isResult = createJsonEmbedPage.createJsonEmbed(paramsMap.get("addJsonURL"), paramsMap.get("name"),paramsMap.get("tags"), paramsMap.get("externalURL"), paramsMap.get("jsonSourceURL"),paramsMap.get("subType"));
        Assert.assertTrue(isResult, "Json Embed not created : " + property);

        isResult = createJsonEmbedPage.editJsonEmbed(paramsMap.get("editName"));
        Assert.assertTrue(isResult, "Json Embed edit status not verified : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-155 :This test case will verify Editable Existing Json Code ")
    @Test
    public void verifyEditableExistingJson() {
        Map<String, String> paramsMap = globalVars.getParamsData("verifyEditableExistingJson", property);
        boolean isResult = createJsonEmbedPage.editableExistingJson(paramsMap.get("addJsonURL"),paramsMap.get("editAddJsonURL"));
        Assert.assertTrue(isResult, "Existing Json Embed Code is not Editable : " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-4975 :verifyThatTheUserIsAbleToCreateJsonEmbed")
    @Test
    public void verifyThatTheUserIsAbleToCreateJsonEmbed() {
        boolean isResult;
        if (this.property.equals("Live Mint")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheUserIsAbleToCreateJsonEmbed", property);
            isResult = createJsonEmbedPage.checkIfeUserIsAbleToCreateJsonEmbed(paramsMap.get("addJsonData"), paramsMap.get("name"), paramsMap.get("jsonSourceUrl"), paramsMap.get("subtype"));
            Assert.assertTrue(isResult, "failed to verify");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5203 :verifyThatTheFieldTag_type_appIsPresentInMetaDataForJsonEmbed")
    @Test
    public void verifyThatTheFieldTagTypeAppIsPresentInMetaDataForJsonEmbed() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheFieldTagTypeAppIsPresentInMetaDataForJsonEmbed", property);
            isResult=createJsonEmbedPage.checkIfTheFieldTagTypeAppIsPresentInMetaDataForJsonEmbed(paramsMap.get("addJsonData"),paramsMap.get("name"),paramsMap.get("jsonSourceUrl"),paramsMap.get("tagFieldCheck"));
            Assert.assertTrue(isResult,"failed to verify");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);

    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
        if (globalVars.isProdRun()) {
            dashboardPage.clickOnAllElement();
            dashboardPage.elementCleanup(JsonEmbedPage.jsonEmbedId);
        } else {
            System.out.println("no cleanup done for staging env!!!");
        }
    }


}
