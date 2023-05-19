
package BlankPaper.Pages;
import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonSubSectionL2Page;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

public class SubSectionL2Test {

    private static CommonSubSectionL2Page subSectionL2Page;
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
        subSectionL2Page = CommonSubSectionL2Page.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnPages();
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5639 :verifyThatUserIsAbleToClickOnSubSectionL2PageFromDropDowns")
    @Test
    public void verifyThatUserIsAbleToClickOnSubSectionL2PageFromDropDowns() {
        boolean isResult;
        isResult=subSectionL2Page.checkIfUserIsAbleToClickOnSubSectionL2PageFromDropDowns();
        Assert.assertTrue(isResult, "failed to verify if user able to open new sub section L2 type page for :" + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT-5659 :verifyThatSubSectionl2PopupAppearsOnceThisOptionIsClicked")
    @Test
    public void verifyThatSubSectionl2PopupAppearsOnceThisOptionIsClicked() {
        boolean isResult;
        isResult=subSectionL2Page.checkIfSubSectionl2PopupAppearsOnceThisOptionIsClicked();
        Assert.assertTrue(isResult, "failed to verify if user able to see pop up on clicking the sub section l2 page :" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5660 :verifyThatUserIsAbleToAddNameAlisaSectionAndSubsectionField")
    @Test
    public void verifyThatUserIsAbleToAddNameAlisaSectionAndSubsectionField() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToAddNameAlisaSectionAndSubsectionField", property);
        isResult=subSectionL2Page.checkIfUserIsAbleToAddNameAlisaSectionAndSubsectionField(paramsMap.get("name")+commonFunctions.generateRandomNum(),paramsMap.get("alias")+commonFunctions.generateRandomNum(),paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to verify if user able to add data name,alias,section,subsection for :" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5661 :verifyThatUserIsAbleToAddNameAlisaSectionAndSubsectionFieldAndCreate")
    @Test
    public void verifyThatUserIsAbleToAddNameAlisaSectionAndSubsectionFieldAndCreate() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToAddNameAlisaSectionAndSubsectionField", property);
        isResult=subSectionL2Page.checkIfUserIsAbleToAddNameAlisaSectionAndSubsectionFieldAndCreate(paramsMap.get("name")+commonFunctions.generateRandomNum(),paramsMap.get("alias")+commonFunctions.generateRandomNum());
        Assert.assertTrue(isResult, "failed to verify if user able to add data name,alias,section,subsection and create for :" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5671- createSubSectionPageAndCheckThatInANewStdStorySubSectionField")
    @Test
    public void createSubSectionPageAndCheckThatInANewStdStorySubSectionField(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("createSubSectionPageAndCheckThatInANewStdStorySubSectionField", property);
        isResult = subSectionL2Page.SubSectionPageAndCheckThatInANewStdStorySubSectionField(paramsMap.get("name"),paramsMap.get("alias"));
        Assert.assertTrue(isResult, "failed to check sub section in new standard story " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5673- Verify that user is able to see created Sub section l2 in dropdown when one two word is typed")
    @Test
    public void createSubSectionL2PageAndCheckThatInANewStdStorySubSectionL2Field(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("createSubSectionL2PageAndCheckThatInANewStdStorySubSectionL2Field", property);
        isResult = subSectionL2Page.SubSectionL2PageAndCheckThatInANewStdStorySubSectionL2Field(paramsMap.get("name"),paramsMap.get("alias"));
        Assert.assertTrue(isResult, "failed to check sub section l2 in new standard story " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5674- create SubSectionL2 Page And Check That In A New StdStory SubSection Field")
    @Test
    public void createSubSectionL2PageAndSelectThatInANewStdStorySubSectionL2Field(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("createSubSectionL2PageAndSelectThatInANewStdStorySubSectionL2Field", property);
        isResult = subSectionL2Page.SubSectionL2PageAndSelectThatInANewStdStorySubSectionL2Field(paramsMap.get("name"),paramsMap.get("alias"));
        Assert.assertTrue(isResult, "failed to select sub section l2 in new standard story " + property);
    }


    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }
}
