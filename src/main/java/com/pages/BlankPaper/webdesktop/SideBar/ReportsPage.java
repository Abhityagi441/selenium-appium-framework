package com.pages.BlankPaper.webdesktop.SideBar;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonReportsPage;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReportsPage extends CommonReportsPage {
    private static CommonSectionPage sectionPage;

    private static DashboardPage dashboardPage;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[8]//i/following-sibling::span")
    private static WebElement ReportsButton;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(id = "defaultOpen")
    private static WebElement ReportsPageHeading;
    @FindBy(xpath = "//div[contains(@class,'tabReport')]/span[1]")
    private static WebElement reportsTab;

    @FindBy(xpath = "//div[contains(@class,'tabReport')]/span[2]")
    private static WebElement ScheduledReportsTab;

    @FindBy(xpath = "//option[@value='plagiarism']")
    private static WebElement plagiarismOption;

    @FindBy(xpath = "//option[@value='quickReads']")
    private static WebElement quickReadsOption;

    @FindBy(id="mydate")
    private static WebElement selectDateRangeOption;

    @FindBy(xpath = "//div[contains(@class,'show-calendar')]")
    private static WebElement calender;

    @FindBy(xpath = "//div[@class='range_inputs']/button[1]")
    private static WebElement applyOption;

    @FindBy(xpath = "//div[@class='range_inputs']/button[2]")
    private static WebElement clearOption;

    @FindBy(xpath = "//div[@class='reportFilter']/ul/li[1]")
    private static WebElement chooseAReportType;

    @FindBy(xpath = "//div[@class='reportFilter']/ul/li[2]")
    private static WebElement selectDateRange;

    @FindBy(xpath = "//div[@class='reportFilter']/button")
    private static WebElement generateReportButton;

    @FindBy(xpath = "//div[contains(@class,'calendar left')]//td[@data-title='r2c2']")
    private static WebElement sampleDateOne;

    @FindBy(xpath = "//div[contains(@class,'calendar right')]//td[@data-title='r2c5']")
    private static WebElement sampleDateTwo;

    @FindBy(xpath = "//div[@class='contentList']")
    private static WebElement contentListTable;

    @FindBy(xpath = "//div[contains(@class,'snotifyToast__body')]")
    private static WebElement reportPopUpMessage;

    @FindBy(xpath = "//div[@class='headingsList']//li[@class='reportType']")
    private static WebElement reportType;

    @FindBy(xpath = "//div[@class='headingsList']//li[@class='dateRange']")
    private static WebElement dateRange;

    @FindBy(xpath = "//th[@class='prev available']")
    private static WebElement previousMonthButton;

    @FindBy(xpath = "//div[@class='headingsList']//li[@class='lastupdae']")
    private static WebElement lastUpdated;

    @FindBy(xpath = "//div[@class='headingsList']//li[@class='generatedBy']")
    private static WebElement generatedByWhom;

    @FindBy(xpath = "//div[@class='headingsList']//li[@class='donwload']")
    private static WebElement downloadOption;

    @FindBy(xpath = "//div[contains(@class,'snotify-success')] | //div[contains(@class,'snotify-error')]")
    private static WebElement reportGenerateStatus;

    @FindBy(xpath = "//div[@class='reportFilter']/button")
    private static WebElement downloadButton;

    @FindBy(xpath = "//div[@class='tableReport']//th[1]")
    private static WebElement columnOneOfScheduledReports;

    @FindBy(xpath = "//div[@class='tableReport']//th[2]")
    private static WebElement columnTwoOfScheduledReports;

    @FindBy(xpath = "//tbody[1]//div[contains(@class,'slider round')]")
    private static WebElement subscribeBtnOne;

    @FindBy(xpath = "//tbody[2]//tr[1]//div[contains(@class,'slider round')]")
    private static WebElement subscribeBtnTwo;

    @FindBy(xpath = "//tbody[2]//tr[2]//div[contains(@class,'slider round')]")
    private static WebElement subscribeBtnThree;



    public ReportsPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        sectionPage= CommonSectionPage.getInstance();
    }


    @Override
    public boolean checkPresenceOfReportsPage(String property) {
        boolean isPresent=commonFunctions.isElementPresent(ReportsButton,10);
        return isPresent;
    }

    @Override
    public boolean checkIfReportsPageClickable(String property) {
        boolean isClickable=commonFunctions.isClickableElementClicked(ReportsButton,10,"clicking reports button");
        return isClickable;
    }

    @Override
    public boolean checkIfReportsTabOpeningReportingModulePage(String ReportsHeadingContent) {
        commonFunctions.clickElementIfDisplayed(ReportsButton,10,"clicking reports button");
        String reportsHeadingText=commonFunctions.getElementText(ReportsPageHeading,10);
        boolean isSame=commonFunctions.checkElementTextWithEqualIgnoreCase(reportsHeadingText,ReportsHeadingContent,"checking if the reports page is open");
        return isSame;
    }

    @Override
    public boolean checkIfReportsTabHaveReportsAndScheduledReports(String property) {
        commonFunctions.clickElementIfDisplayed(ReportsButton,10,"clicking reports button");
        boolean areBothTabsPresent=commonFunctions.isElementPresent(reportsTab,10) &&
                                    commonFunctions.isElementPresent(ScheduledReportsTab,10);
        return areBothTabsPresent;
    }

    @Override
    public boolean checkThatChooseAReportTypeHaveTwoOptionsPlagiarismAndQuickReads() {
        commonFunctions.clickElementIfDisplayed(ReportsButton,10,"clicking reports button");
        commonFunctions.clickElementIfDisplayed(reportsTab,10);
        return commonFunctions.isElementDisplayed(plagiarismOption) &&
                commonFunctions.isElementDisplayed(quickReadsOption);
    }

    @Override
    public boolean checkIfSelectDateRangeOpeningCalendar(){
        commonFunctions.clickElementIfDisplayed(selectDateRangeOption,10);
        return commonFunctions.isElementPresent(calender,10);
    }

    @Override
    public boolean checkIfCalendarHasClearAndApplyOptions() {
        commonFunctions.clickElementIfDisplayed(selectDateRangeOption,10);
        return commonFunctions.isElementPresent(applyOption,10) &&
                commonFunctions.isElementPresent(clearOption,10);
    }

    @Override
    public boolean checkIfReportsTabHasTwoDropDownFieldsAndOneButton(String property) {
        return commonFunctions.isElementPresent(chooseAReportType,10) &&
        commonFunctions.isElementPresent(selectDateRange,10) &&
        commonFunctions.isElementPresent(generateReportButton,10);
    }

    @Override
    public boolean checkIfGenerateReportButtonIsClickable() {
        commonFunctions.clickElementIfDisplayed(reportsTab,10);
        return commonFunctions.isClickableElementClicked(generateReportButton,10,"generate report button");
    }

    @Override
    public boolean checkIfTheApplyButtonIsWorking() {
        String beforeDateSelection=commonFunctions.getElementText(selectDateRangeOption,10);
        commonFunctions.clickElementIfDisplayed(selectDateRangeOption,10);
        commonFunctions.clickElementIfDisplayed(sampleDateOne,5);
        commonFunctions.clickElement(sampleDateTwo,10);
        commonFunctions.clickElement(applyOption);
        String afterDateSelection=commonFunctions.getElementText(selectDateRangeOption,10);
        return !beforeDateSelection.equals(afterDateSelection);
    }

    @Override
    public boolean checkIfTheClearButtonIsWorking() {
        if(checkIfTheApplyButtonIsWorking()){
            String dateSelected=commonFunctions.getElementText(selectDateRangeOption,10);
            commonFunctions.clickElementIfDisplayed(selectDateRangeOption,10);
            commonFunctions.clickElementIfDisplayed(clearOption);
            String isDateCleared=commonFunctions.getElementText(selectDateRangeOption,10);
            return !dateSelected.equals(isDateCleared);


        }
        return false;
    }

    @Override
    public boolean checkIfTableIsPresentBelowTheDropdownFields() {
        commonFunctions.clickElementIfDisplayed(reportsTab);
        return commonFunctions.isElementPresent(contentListTable,10);
    }

    @Override
    public boolean checkTheResponseIfReportTypeIsSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(String reportMessage) {
        commonFunctions.clickElementIfDisplayed(chooseAReportType,10);
        commonFunctions.clickElement(plagiarismOption);
        commonFunctions.clickElement(generateReportButton);
        String message=commonFunctions.waitAndGetElementTextIgnoringStaleElement(reportPopUpMessage,10,"getting element text");
        return message.equals(reportMessage);

    }

    @Override
    public boolean checkTheResponseIfReportTypeIsNotSelectedAndDateRangeIsSelectedAndGenerateTheReport(String reportMessage) {
        commonFunctions.clickElementIfDisplayed(selectDateRangeOption,10);
        commonFunctions.clickElementIfDisplayed(sampleDateOne,5);
        commonFunctions.clickElement(sampleDateTwo,10);
        commonFunctions.clickElement(applyOption);
        commonFunctions.clickElement(generateReportButton);
        String message=commonFunctions.waitAndGetElementTextIgnoringStaleElement(reportPopUpMessage,10,"getting element text");
        return message.equals(reportMessage);
    }

    @Override
    public boolean checkTheResponseIfReportTypeIsNotSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(String reportMessage) {
        commonFunctions.clickElementIfDisplayed(generateReportButton,10);
        String message= commonFunctions.waitAndGetElementTextIgnoringStaleElement(reportPopUpMessage,10,"getting element text");
        return message.equals(reportMessage);
    }

    public String generateReport(){
        commonFunctions.clickElementIfDisplayed(plagiarismOption,10);
        commonFunctions.clickElementIfDisplayed(selectDateRangeOption,10);
        int monthsBack=2;
        while(monthsBack>0){
            commonFunctions.clickElement(previousMonthButton,10);
            monthsBack--;
        }
        commonFunctions.clickElement(sampleDateOne,10);
        commonFunctions.clickElement(sampleDateTwo,10);
        commonFunctions.clickElement(applyOption);
        commonFunctions.clickElement(generateReportButton);
        commonFunctions.waitForElementListToAppear("//div[contains(@class,'snotify-success')] | //div[contains(@class,'snotify-error')]",10,"popup message");
        String message=commonFunctions.waitAndGetElementTextIgnoringStaleElement(reportGenerateStatus,10,"getting element");
        return message;
    }

    @Override
    public boolean checkIfReportIsGeneratingWhenTheDataIsPresent(String successfulMessage, String unsuccessfulMessage) {
        String popUpMessage=generateReport();
        return popUpMessage.equals(successfulMessage) || popUpMessage.equals(unsuccessfulMessage);
    }

    @Override
    public boolean checkIfDownloadIconIsPresentInReportsTable(String successfulMessage, String noReportsMessage) {
        String popUpMessage=generateReport();
        if(popUpMessage.equals(successfulMessage)) return commonFunctions.isElementPresent(downloadButton,10);
        else if(popUpMessage.equals(noReportsMessage)) return true;
        return false;
    }

    @Override
    public boolean checkIfScheduledReportsTabHasReportTypeAndSubscribeOptions(String columnOne, String columnTwo) {
        commonFunctions.clickElementIfDisplayed(ScheduledReportsTab);
        return commonFunctions.waitAndGetElementTextAndCheck(columnOneOfScheduledReports,columnOne,10,"coloum one")
                && commonFunctions.waitAndGetElementTextAndCheck(columnTwoOfScheduledReports,columnTwo,10,"coloum Two");
    }

    @Override
    public boolean checkIfSubscribeColumnHasToggleButtonAndItShouldBeTurnedOffByDefault(String buttonBgColor) {
        commonFunctions.clickElementIfDisplayed(ScheduledReportsTab);
        if(commonFunctions.isElementPresent(subscribeBtnOne,10) && commonFunctions.isElementPresent(subscribeBtnTwo,10) && commonFunctions.isElementPresent(subscribeBtnThree,10))
        {
            return commonFunctions.getBackgroundColorOfWebElement(subscribeBtnOne,10,"plagiarism button","background-color").equalsIgnoreCase(buttonBgColor) &&
                    commonFunctions.getBackgroundColorOfWebElement(subscribeBtnTwo,10,"quick read button","background-color").equalsIgnoreCase(buttonBgColor) &&
                    commonFunctions.getBackgroundColorOfWebElement(subscribeBtnThree,10,"quick read button","background-color").equalsIgnoreCase(buttonBgColor);
        }
        return false;
    }

    @Override
    public boolean checkIfSubscribeToggleButtonsShouldBeWorking(String buttonBgColor) {
        commonFunctions.clickElementIfDisplayed(ScheduledReportsTab);
        commonFunctions.clickElement(subscribeBtnOne,10);
        commonFunctions.clickElement(subscribeBtnTwo,10);
        commonFunctions.clickElement(subscribeBtnThree,10);
        commonFunctions.hardWait(5000);
        boolean result=commonFunctions.getBackgroundColorOfWebElement(subscribeBtnOne,10,"plagiarism button","background-color").equalsIgnoreCase(buttonBgColor) &&
                commonFunctions.getBackgroundColorOfWebElement(subscribeBtnTwo,10,"quick read button","background-color").equalsIgnoreCase(buttonBgColor) &&
                commonFunctions.getBackgroundColorOfWebElement(subscribeBtnThree,10,"notifications button","background-color").equalsIgnoreCase(buttonBgColor);
        commonFunctions.clickElement(subscribeBtnOne,10);
        commonFunctions.clickElement(subscribeBtnTwo,10);
        commonFunctions.clickElement(subscribeBtnThree,10);
        return result;
    }

    @Override
    public boolean checkIfReportTableHaveRequiredFields(String typeHeading, String dateHeading, String generatedDateHeading, String generatedByHeading, String downloadHeading) {
        String type=commonFunctions.getElementText(reportType);
        String date=commonFunctions.getElementText(dateRange);
        String generatedDate=commonFunctions.getElementText(lastUpdated);
        String generatedBy=commonFunctions.getElementText(generatedByWhom);
        String download=commonFunctions.getElementText(downloadOption);
        return type.equals(typeHeading) && date.equals(dateHeading) && generatedDate.equals(generatedDateHeading)
                && generatedBy.equals(generatedByHeading) && download.equals(downloadHeading);
    }

    @Override
    public boolean checkIfDownloadButtonWorkingOrNot() {
        String popUpMessage=generateReport();
        if(popUpMessage.equals("No Reports for selected date found!")) return true;
        commonFunctions.clickElementIfDisplayed(downloadButton,10);
        commonFunctions.hardWait(3000);
        String projectPath =System.getProperty("user.dir");
        return commonFunctions.isFileDownloaded(projectPath,".xlsx");
    }

    @Override
    public boolean checkIfScheduledReportsTabIsClickable() {
        return commonFunctions.isClickableElementClicked(ScheduledReportsTab,10,"scheduled reports tab");
    }

}
