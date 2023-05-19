package BlankPaper.SideBar;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonReportsPage;
import com.pages.BlankPaper.genericPages.CommonSubSectionPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

public class ReportsTest {
    private static CommonReportsPage reportsPage;
    private static CommonSubSectionPage subsectionPage;
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
        subsectionPage = CommonSubSectionPage.getInstance();
        reportsPage = CommonReportsPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnReports();
    }

    @Author(name = "seshasai vooggu")
    @Description("QAAUT-5043 :check Reports page present or not")
    @Test
    public void verifyReportsPage() {
        boolean isResult;
        isResult = reportsPage.checkPresenceOfReportsPage(property);
        Assert.assertTrue(isResult, "All verification not verified :" + property);
    }

    @Author(name = "seshasai vooggu")
    @Description("QAAUT-5044 :check Reports page present or not")
    @Test
    public void verifyReportsPageClickable() {
        boolean isResult;
        isResult = reportsPage.checkIfReportsPageClickable(property);
        Assert.assertTrue(isResult, "All verification not verified :" + property);
    }

    @Author(name = "seshasai vooggu")
    @Description("QAAUT-5045 :verifyReportsTabShouldOpenReportingModulePage")
    @Test
    public void verifyReportsTabShouldOpenReportingModulePage() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyReportsTabShouldOpenReportingModulePage" , property);
        isResult = reportsPage.checkIfReportsTabOpeningReportingModulePage(paramsMap.get("ReportHeadingContent"));
        Assert.assertTrue(isResult, "All verification not verified");
    }

    @Author(name = "seshasai vooggu")
    @Description("QAAUT-5046 :verifyReportsTabShouldOpenReportingModulePage")
    @Test
    public void verifyReportsTabShouldHaveReportsAndScheduledReports() {
        boolean isResult;
        isResult = reportsPage.checkIfReportsTabHaveReportsAndScheduledReports(property);
        Assert.assertTrue(isResult, "failed to verity the presence of tabs"+property);
    }

    @Author(name = "seshasai vooggu")
    @Description("QAAUT-5047 :verifyReportsTabShouldHaveTwoDropDownFieldsAndOneButton")
    @Test
    public void verifyReportsTabShouldHaveTwoDropDownFieldsAndOneButton() {
        boolean isResult;
        isResult = reportsPage.checkIfReportsTabHasTwoDropDownFieldsAndOneButton(property);
        Assert.assertTrue(isResult, "failed to verify all the fields"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5048 :VerifyThatChooseAReportTypeHaveTwoOptionsPlagiarismAndQuickReads")
    @Test
    public void verifyThatChooseAReportTypeHaveTwoOptionsPlagiarismAndQuickReads(){
        boolean isResult;
        isResult=reportsPage.checkThatChooseAReportTypeHaveTwoOptionsPlagiarismAndQuickReads();
        Assert.assertTrue(isResult,"failed to check the options"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5049 :verifyThatSelectDateRangeShouldOpenCalendar")
    @Test
    public void verifyThatSelectDateRangeShouldOpenCalendar(){
        boolean isResult;
        isResult=reportsPage.checkIfSelectDateRangeOpeningCalendar();
        Assert.assertTrue(isResult,"failed to check the calender menu"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5050 :verifyThatCalendarHasClearAndApplyOptions")
    @Test
    public void verifyThatCalendarHasClearAndApplyOptions(){
        boolean isResult;
        isResult=reportsPage.checkIfCalendarHasClearAndApplyOptions();
        Assert.assertTrue(isResult,"failed to check the apply and  clear options in calender"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5051 :verifyThatApplyButtonShouldBeWorking")
    @Test
    public void verifyThatApplyButtonShouldBeWorking(){
        boolean isResult;
        isResult=reportsPage.checkIfTheApplyButtonIsWorking();
        Assert.assertTrue(isResult,"failed to check apply button is clickable or not");
    }

    @Author(name = "seshassai voggu")
    @Description("QAAUT5052 :verifyThatClearButtonShouldBeWorking")
    @Test
    public void verifyThatClearButtonShouldBeWorking(){
        boolean isResult;
        isResult=reportsPage.checkIfTheClearButtonIsWorking();
        Assert.assertTrue(isResult,"failed to check apply button is clickable or not");
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5053 :verifyThatGenerateReportButtonIsClickable")
    @Test
    public void verifyThatGenerateReportButtonIsClickable(){
        boolean isResult;
        isResult=reportsPage.checkIfGenerateReportButtonIsClickable();
        Assert.assertTrue(isResult,"failed to check generate report button is clickable or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5054 :verifyThatTableIsPresentBelowTheDropdownFields")
    @Test
    public void verifyThatTableIsPresentBelowTheDropdownFields(){
        boolean isResult;
        isResult=reportsPage.checkIfTableIsPresentBelowTheDropdownFields();
        Assert.assertTrue(isResult,"failed to verify if the table is present below the dropdown fields");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5055 :verifyTheResponseIfReportTypeIsSelectedAndDateRangeIsNotSelectedAndGenerateTheReport")
    @Test
    public void verifyTheResponseIfReportTypeIsSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyTheResponseIfReportTypeIsSelectedAndDateRangeIsNotSelectedAndGenerateTheReport" , property);
        isResult=reportsPage.checkTheResponseIfReportTypeIsSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(paramsMap.get("reportMessage"));
        Assert.assertTrue(isResult,"failed to verify the response");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5056 :verifyTheResponseIfReportTypeIsNotSelectedAndDateRangeIsSelectedAndGenerateTheReport")
    @Test
    public void verifyTheResponseIfReportTypeIsNotSelectedAndDateRangeIsSelectedAndGenerateTheReport(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyTheResponseIfReportTypeIsNotSelectedAndDateRangeIsSelectedAndGenerateTheReport" , property);
        isResult=reportsPage.checkTheResponseIfReportTypeIsNotSelectedAndDateRangeIsSelectedAndGenerateTheReport(paramsMap.get("reportMessage"));
        Assert.assertTrue(isResult,"failed to verify the response");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5057 :verifyTheResponseIfReportTypeIsNotSelectedAndDateRangeIsNotSelectedAndGenerateTheReport")
    @Test
    public void verifyTheResponseIfReportTypeIsNotSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyTheResponseIfReportTypeIsNotSelectedAndDateRangeIsNotSelectedAndGenerateTheReport" , property);
        isResult=reportsPage.checkTheResponseIfReportTypeIsNotSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(paramsMap.get("reportMessage"));
        Assert.assertTrue(isResult,"failed to verify the response");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5059 :verifyThatReportIsGeneratingIfTheDataIsPresent")
    @Test
    public void verifyThatReportIsGeneratingWhenTheDataIsPresent(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatReportIsGeneratingWhenTheDataIsPresent" , property);
        isResult=reportsPage.checkIfReportIsGeneratingWhenTheDataIsPresent(paramsMap.get("successfulMessage"),paramsMap.get("unsuccessfulMessage"));
        Assert.assertTrue(isResult,"failed to verify the report is generating or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5060 :verifyThatReportTableShouldHaveRequiredFields")
    @Test
    public void verifyThatReportTableShouldHaveRequiredFields(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatReportTableShouldHaveRequiredFields" , property);
        isResult=reportsPage.checkIfReportTableHaveRequiredFields(paramsMap.get("typeHeading"),paramsMap.get("dateHeading"),paramsMap.get("generatedDateHeading"),paramsMap.get("generatedByHeading"),paramsMap.get("downloadHeading"));
        Assert.assertTrue(isResult,"failed to verify required fields in reports table");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5061 :verifyThatDownloadIconIsPresentInReportsTable")
    @Test
    public void verifyThatDownloadIconIsPresentInReportsTable(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatDownloadIconIsPresentInReportsTable" , property);
        isResult=reportsPage.checkIfDownloadIconIsPresentInReportsTable(paramsMap.get("successfulMessage"),paramsMap.get("noReportsFoundMessage"));
        Assert.assertTrue(isResult,"failed to verify the download icon in reports table");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5062 :verifyDownloadButtonWorkingOrNot")
    @Test
    public void verifyDownloadButtonWorkingOrNot(){
        boolean isResult;
        isResult=reportsPage.checkIfDownloadButtonWorkingOrNot();
        Assert.assertTrue(isResult,"failed to verify the download button is working or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5063 :verifyThatScheduledReportsTabIsClickable")
    @Test
    public void verifyThatScheduledReportsTabIsClickable(){
        boolean isResult;
        isResult=reportsPage.checkIfScheduledReportsTabIsClickable();
        Assert.assertTrue(isResult,"failed to verify scheduledReports tab is clickable or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5064 :verifyThatScheduledReportsTabHasReportTypeAndSubscribeOptions")
    @Test
    public void verifyThatScheduledReportsTabHasReportTypeAndSubscribeOptions(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatScheduledReportsTabHasReportTypeAndSubscribeOptions" , property);
        isResult=reportsPage.checkIfScheduledReportsTabHasReportTypeAndSubscribeOptions(paramsMap.get("columnOne"),paramsMap.get("columnTwo"));
        Assert.assertTrue(isResult,"failed to verify the options");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5065 :verifyThatSubscribeColumnShouldHaveToggleButtonAndItShouldBeTurnedOffByDefault")
    @Test
    public void verifyThatSubscribeColumnShouldHaveToggleButtonAndItShouldBeTurnedOffByDefault(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatSubscribeColumnShouldHaveToggleButtonAndItShouldBeTurnedOffByDefault" , property);
        isResult=reportsPage.checkIfSubscribeColumnHasToggleButtonAndItShouldBeTurnedOffByDefault(paramsMap.get("buttonBgColor"));
        Assert.assertTrue(isResult,"failed to verify the toggle button of"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5066 :verifyThatSubscribeToggleButtonsShouldBeWorking")
    @Test
    public void verifyThatSubscribeToggleButtonsShouldBeWorking(){
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatSubscribeToggleButtonsShouldBeWorking" , property);
        isResult=reportsPage.checkIfSubscribeToggleButtonsShouldBeWorking(paramsMap.get("buttonBgColor"));
        Assert.assertTrue(isResult,"failed to verify the toggle button is working or not");
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

}
