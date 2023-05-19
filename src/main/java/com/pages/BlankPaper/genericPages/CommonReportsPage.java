package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.SideBar.ReportsPage;
import com.utils.Constants;
import com.utils.GlobalVars;
public abstract class CommonReportsPage {

    private static CommonReportsPage commonReportsPage;
    private static GlobalVars globalVars;

    public static CommonReportsPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonReportsPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonReportsPage = new ReportsPage();
                    break;
            }
        }
        return commonReportsPage;
    }

    public abstract boolean checkPresenceOfReportsPage(String property);

    public abstract boolean checkIfReportsPageClickable(String property);

    public abstract boolean checkIfReportsTabOpeningReportingModulePage(String ReportsHeadingContent);

    public abstract boolean checkIfReportsTabHaveReportsAndScheduledReports(String property);

    public abstract boolean checkThatChooseAReportTypeHaveTwoOptionsPlagiarismAndQuickReads();

    public abstract boolean checkIfSelectDateRangeOpeningCalendar();

    public abstract boolean checkIfCalendarHasClearAndApplyOptions();

    public abstract boolean checkIfReportsTabHasTwoDropDownFieldsAndOneButton(String property);

    public abstract boolean checkIfGenerateReportButtonIsClickable();

    public abstract boolean checkIfTheApplyButtonIsWorking();

    public abstract boolean checkIfTheClearButtonIsWorking();

    public abstract boolean checkIfTableIsPresentBelowTheDropdownFields();

    public abstract boolean checkTheResponseIfReportTypeIsSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(String reportMessage);

    public abstract boolean checkTheResponseIfReportTypeIsNotSelectedAndDateRangeIsSelectedAndGenerateTheReport(String reportMessage);

    public abstract boolean checkTheResponseIfReportTypeIsNotSelectedAndDateRangeIsNotSelectedAndGenerateTheReport(String reportMessage);

    public abstract boolean checkIfReportTableHaveRequiredFields(String typeHeading, String dateHeading, String generatedDateHeading, String generatedByHeading, String downloadHeading);

    public abstract boolean checkIfScheduledReportsTabIsClickable();

    public abstract boolean checkIfReportIsGeneratingWhenTheDataIsPresent(String successfulMessage, String unsuccessfulMessage);

    public abstract boolean checkIfDownloadIconIsPresentInReportsTable(String successfulMessage, String noReportsMessage);

    public abstract boolean checkIfScheduledReportsTabHasReportTypeAndSubscribeOptions(String columnOne, String columnTwo);

    public abstract boolean checkIfSubscribeColumnHasToggleButtonAndItShouldBeTurnedOffByDefault(String buttonBgColor);

    public abstract boolean checkIfSubscribeToggleButtonsShouldBeWorking(String buttonBgColor);

    public abstract boolean checkIfDownloadButtonWorkingOrNot();
}
