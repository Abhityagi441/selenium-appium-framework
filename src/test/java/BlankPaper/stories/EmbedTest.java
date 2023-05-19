package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonEmbedPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.EmbedPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class EmbedTest {

    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonEmbedPage embedPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property=property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(this.property);
        embedPage = EmbedPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnAllElement();
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-147: To verify create embed publishing status")
    @Test
    public void verifyCreateEmbedPublishingStatus(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateEmbedPublishingStatus", property);
        Random r = new Random();
        int result = r.nextInt(100-1);
        String name=paramsMap.get("name")+result;
        Assert.assertTrue(embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
        Assert.assertTrue(embedPage.fillMetaDataAndVerifyEmbedPublishingStatus(name, paramsMap.get("tags"),paramsMap.get("externalURL"),paramsMap.get("title"),paramsMap.get("jsonSourceURL"),paramsMap.get("subtype")), "Publishing status is not displayed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-148: To verify create embed creating status")
    @Test
    public void verifyCreateEmbedCreationStatus(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateEmbedCreationStatus", property);
        Random r = new Random();
        int result = r.nextInt(100-1);
        String name=paramsMap.get("name")+result;
        Assert.assertTrue( embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
        Assert.assertTrue(embedPage.fillMetaDataAndVerifyEmbedCreationStatus(name, paramsMap.get("tags"),paramsMap.get("externalURL"),paramsMap.get("title"),paramsMap.get("jsonSourceURL"),paramsMap.get("subtype")),"Embed status is not CREATED");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-144: To verify editable existing embed")
    @Test
    public void verifyCreatedEmbedEditable(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreatedEmbedEditable", property);
        Random r = new Random();
        int result = r.nextInt(100-1);
        String name=paramsMap.get("name")+result;
        Assert.assertTrue(embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
        Assert.assertTrue(embedPage.fillMetaDataAndVerifyEmbedPublishingStatus(name, paramsMap.get("tags"),paramsMap.get("externalURL"),paramsMap.get("title"),paramsMap.get("jsonSourceURL"),paramsMap.get("subtype")), "Publishing status is not displayed");
        Assert.assertTrue(embedPage.clickEditLinkOnEmbedVideoAndVerifyEmbedPopup(),"Edit Embed popup is not displayed on click of Edit button");
    }

    @Author(name = "Ravinder Singh")
    @Test
    @Description("QAAUT-150: To verify cancel button")
    public void verifyCancelButtonOnEmbedPopup(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCancelButtonOnEmbedPopup", property);
        Assert.assertTrue(embedPage.fillEmbedCodeAndClickCancelButtonAndVerifyEmbedPopUpClosed(paramsMap.get("embedCode")),"Embed Popup Not closed after click on 'Cancel' button");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-149: To verify create embed editing status")
    @Test
    public void verifyEmbedIsEditable(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyEmbedIsEditable", property);
        Assert.assertTrue(embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
        Assert.assertTrue(embedPage.clickEditLinkOnEmbedVideoAndVerifyEmbedPopup(),"Edit Embed popup is not displayed on click of Edit button");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-142: To verify embed code validation")
    @Test
    public void verifyEmbedPagevalidation(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyEmbedPagevalidation", property);
        Assert.assertTrue(embedPage.createEmbedAndVerifyEmbedValidationMessagePresent(paramsMap.get("embedCodeTextMessage")));
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-143: To verify embed a code page")
    @Test
    public void verifyEmbedPageIsACodePage(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyEmbedPageIsACodePage", property);
        Assert.assertTrue( embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-146: To verify discard element")
    @Test
    public void verifyDiscardElementFunctionality(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDiscardElementFunctionality", property);
        Random r = new Random();
        int result = r.nextInt(100-1);
        String name=paramsMap.get("name")+result;
        Assert.assertTrue(embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
        Assert.assertTrue(embedPage.createAndDiscardEmbed(name, paramsMap.get("tags"),paramsMap.get("externalURL"),paramsMap.get("title"),paramsMap.get("jsonSourceURL"),paramsMap.get("subtype")),"User isn't on Create Embed landing page");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-152: Verify complete json Embed creation flow")
    @Test
    public void verifyCompleteCreatedEmbedStatus(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCompleteCreatedEmbedStatus", property);
        boolean status=false;
        Random r = new Random();
        int result = r.nextInt(100-1);
        String name=paramsMap.get("name")+result;
        Assert.assertTrue(embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
        Assert.assertTrue(embedPage.fillMetaDataAndVerifyEmbedCreationStatus(name, paramsMap.get("tags"),paramsMap.get("externalURL"),paramsMap.get("title"),paramsMap.get("jsonSourceURL"),paramsMap.get("subtype")),"Embed status is not CREATED");
        Assert.assertTrue(embedPage.openCreatedEmbedAndPublishIt(),"Embed published massage not displayed");
        status= embedPage.navigateToAllElementsAndVerifyEmbedPublishingStatus(name);
        Assert.assertTrue(status,"Created Embed Status is not Publishing");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-156: To verify metadata section")
    @Test
    public void verifyMetaDataSectionValidation(){
        Map<String, String> paramsMap=globalVars.getParamsData("verifyMetaDataSectionValidation", property);
        Assert.assertTrue( embedPage.createEmbedAndVerifyMetaDataValidation(paramsMap.get("embedCode")),"Meta Data Validations not displayed");
        Assert.assertTrue(embedPage.enterNameAndDiscardEmbed("test"), "discard element failed!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-196 :To verify create,publish & edit - refresh page")
    @Test
    public void verifyEmbedCreatePublishEditRefreshPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyEmbedCreatePublishEditRefreshPage", property);
        Random r = new Random();
        int result = r.nextInt(100-1);
        String name=paramsMap.get("name")+result;
        Assert.assertTrue(embedPage.createEmbedInPopupAndVerifyEmbedVideoDisplayed(paramsMap.get("embedCode"),paramsMap.get("embedVideoCode")),"Embed Video not displayed");
        Assert.assertTrue(embedPage.fillMetaDataAndVerifyEmbedPublishingStatus(name, paramsMap.get("tags"),paramsMap.get("externalURL"),paramsMap.get("title"),paramsMap.get("jsonSourceURL"),paramsMap.get("subtype")), "Publishing status is not displayed");
        Assert.assertTrue(embedPage.editMetaDataAndRefreshAndVerifyChangedData(paramsMap.get("editedName"),paramsMap.get("editedTags"), paramsMap.get("editedExternalURL"),paramsMap.get("editedTitle"),paramsMap.get("editedJsonSourceURL"),paramsMap.get("editedSubtype")), "Edited Fields not saved");
    }

    @Author(name = "voggu seshasai")
    @Description("QAAUT-5204 :verifyThatTheFieldTagTypeAppIsPresentInMetaDataForEmbed")
    @Test
    public void verifyThatTheFieldTagTypeAppIsPresentInMetaDataForEmbed() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheFieldTagTypeAppIsPresentInMetaDataForEmbed", property);
            isResult=embedPage.checkIfTheFieldTagTypeAppIsPresentInMetaDataForEmbed(paramsMap.get("embedText"),paramsMap.get("tagFieldType"));
            Assert.assertTrue(isResult,"failed to verify dTagTypeAppIsPresentInMetaDataForEmbed");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "voggu seshasai")
    @Description("QAAUT-5205 :verifyAllTheDropDownOptionsPresentInTagTypeSelectionField")
    @Test
    public void verifyAllTheDropDownOptionsPresentInTagTypeSelectionField() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyAllTheDropDownOptionsPresentInTagTypeSelectionField", property);
            isResult=embedPage.checkIfAllTheDropDownOptionsPresentInTagTypeSelectionField(paramsMap.get("embedText")
                    ,paramsMap.get("option1"),paramsMap.get("option2"),paramsMap.get("option3")
                    ,paramsMap.get("option4"),paramsMap.get("option5"),paramsMap.get("option6")
                    ,paramsMap.get("option7"),paramsMap.get("option8"),paramsMap.get("option9")
                    ,paramsMap.get("option10"),paramsMap.get("option11"));
            Assert.assertTrue(isResult,"failed to verify");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);

    }

    @Author(name = "voggu seshasai")
    @Description("QAAUT-5206 :verifyThatUserIsAbleToSelectAnyOfTheDropDownOptionsFromTagTypeAppField")
    @Test
    public void verifyThatUserIsAbleToSelectAnyOfTheDropDownOptionsFromTagTypeAppField() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToSelectAnyOfTheDropDownOptionsFromTagTypeAppField", property);
            isResult=embedPage.checkIfUserIsAbleToSelectAnyOfTheDropDownOptionsFromTagTypeAppField(paramsMap.get("embedText"),paramsMap.get("OneOfTheOption"));
            Assert.assertTrue(isResult,"failed to verify");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "voggu seshasai")
    @Description("QAAUT-5207 :verifyThatDataIsGoingTillMasterForTheInputGivenForTagTypeAppField")
    @Test
    public void verifyThatDataIsGoingTillMasterForTheInputGivenForTagTypeAppField() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatDataIsGoingTillMasterForTheInputGivenForTagTypeAppField", property);
            isResult=embedPage.checkIfDataIsGoingTillMasterForTheInputGivenForTagTypeAppField(paramsMap.get("embedText"),paramsMap.get("name"),paramsMap.get("OneOfTheOption"));
            Assert.assertTrue(isResult,"failed to verify");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "voggu seshasai")
    @Description("QAAUT-5208 :Verify that tag type app field is not mandatory.")
    @Test
    public void verifyThatTagTypeAppFieldIsNotMandatory() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTagTypeAppFieldIsNotMandatory", property);
            isResult=embedPage.checkIfTagTypeAppFieldIsNotMandatory(paramsMap.get("embedText"),paramsMap.get("name"));
            Assert.assertTrue(isResult,"failed to verify if tag type app field is not mandatory");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);
    }


    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }


}
