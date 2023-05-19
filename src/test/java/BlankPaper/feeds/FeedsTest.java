package BlankPaper.feeds;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonFeedsPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.feeds.FeedsPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

public class FeedsTest {

    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFeedsPage commonFeedsPage;

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
        commonFeedsPage = CommonFeedsPage.getInstance();
    }

    @BeforeMethod
    @Description("In case of failure this method will navigate to Dashboard")
    public void ensureHomePageVisibility(){
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-709 Verify filters, pagination, edit feeds, click to expand view")
    @Test
    public void verifyExpandFeedsForAgencyFeedTab(){
        boolean isResult;
        isResult = commonFeedsPage.isFeedsExpandable();
        Assert.assertTrue(isResult, "Feeds are not expandable: " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-931: Verify pagination of agency feeds page")
    @Test
    public void verifyPaginationForAgencyFeedsPage() {
        boolean isResult;
        isResult = dashboardPage.verifyPagination();
        Assert.assertTrue(isResult, "Pagination is not verified : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-930: Verify filters of agency feeds page")
    @Test
    public void verifyFiltersForAgencyFeedsPage() {
        boolean isDateFilterWorking, isAgencyAndSectionFilterWorking;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyFiltersForAgencyFeedsPage", property);

        isAgencyAndSectionFilterWorking = commonFeedsPage.checkAgencyAndSectionFilters(paramsMap.get("agency"), paramsMap.get("section"));
        Assert.assertTrue(isAgencyAndSectionFilterWorking, "Agency and Section Filters are not verified : " + property);

        isDateFilterWorking = commonFeedsPage.checkPublishedFilter();
        Assert.assertTrue(isDateFilterWorking, "Published Filters are not verified : " + property);


    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-711 To verify after click -show story pop up page")
    @Test
    public void verifyExpandFeedsForPrintFeedTab(){
        boolean isResult;
        if(this.property.equals("HT NEW") || this.property.equals("Mint Lounge")) {
            isResult = commonFeedsPage.isFeedsExpandableForPrintFeed();
            Assert.assertTrue(isResult, "Feeds are not expandable: " + property);
        }
        else{
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT:209 Verify Create a Story and Send notification buttons are present on top right")
    @Test
    public void verifyButtonsOnTopOnFeedsPrintTab() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            isResult = commonFeedsPage.isNotificationAndCreateStoryButtonDisplayedOnPrintFeedTab();
            Assert.assertTrue(isResult, "Notification button and Create A story are not displayed : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT:201 To verify enable create story button with all options as create story,video,listicle,livebolg,photogallery")
    @Test
    public void verifyOptionsOfCreateStoryOnAgencyFeedTab() {
        boolean isResult;
        isResult = commonFeedsPage.isOptionsDisplayedUnderCreateStory(property);
        Assert.assertTrue(isResult, "All Options are not displayed: " + property);
    }

    @Author(name = "Satej Punj")
    @Description("QAAUT-3073 Verify the presence of LH Gallery Feed tab for HT Domain under feeds section")
    @Test
    public void verifyLHgalleryfeedspresence() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("HT Kannada")) {
            isResult = commonFeedsPage.islhgalleryoptionpresent();
            Assert.assertTrue(isResult, "LH Gallery feed is not present " + property);
        }
    }

    @Author(name = "Satej Punj")
    @Description("QAAUT-3078 Verify after clicking on LH Gallery feed tab the data is present or not under the LH Gallery feed")
    @Test
    public void verifyLHgalleryfeedsdatapresence() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("HT Kannada")){
            isResult = commonFeedsPage.islhgallerydatapresent();
            Assert.assertTrue(isResult, "LH Gallery feed data is not present " + property);
        }
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-932 Verify edit feeds of agency feeds page")
    @Test
    public void verifyEditFeedsOnAgencyFeedTab() {
        boolean isResult;
        isResult = commonFeedsPage.isEditFeedsOnAgencyFeedsTab();
        Assert.assertTrue(isResult, "Feeds are not editable for : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-202 Verify search wire stories")
    @Test
    public void verifyAgencyFeedsStoriesSearchable() {
        boolean isResult;
        isResult = commonFeedsPage.isStoriesSearchableOnAgencyFeedsTab();
        Assert.assertTrue(isResult, "Feeds are not editable for : " + property);
    }


    @Author(name = "Ravinder Singh")
    @Description("QAAUT-205 To verify enable copy for publish & pick as story button on pop up page")
    @Test
    public void verifyPublishAndPickStoryButtonOnPrintFeedStoryPopup(){
        boolean isResult;
        if(this.property.equals("HT NEW") || this.property.equals("Mint Lounge")) {
            isResult = commonFeedsPage.validatePrintFeedStoryPopup();
            Assert.assertTrue(isResult, "Buttons are not available: " + property);
        }
        else{
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-206 To verify after pick as story and redirect on story page with all editable page")
    @Test
    public void verifyClickOnPickStoryButtonOnPrintFeedStoryPopup() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyClickOnPickStoryButtonOnPrintFeedStoryPopup", property);
        if (this.property.equals("HT NEW") || this.property.equals("Mint Lounge")) {
            isResult = commonFeedsPage.isStoryEditableOnClickOfPickStoryButtonOnPrintFeedStoryPopup(paramsMap.get("heading"));
            Assert.assertTrue(isResult, "Buttons are not available: " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }


    @Author(name = "Giridhar Raj")
    @Description("QAAUT-199: verify Copied For Publish And Pick As Story Enable Button ")
    @Test
    public void verifyCopyForPublishAndPickAsStoryEnableButton(){
        boolean isResult;
        isResult = commonFeedsPage.checkCopiedForPublishAndPickAsStoryEnableButton();
        Assert.assertTrue(isResult, "Button not enabled: " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-200: verify after Pick As Story Redirect On Story Page ")
    @Test
    public void verifyAfterPickAsStoryRedirectOnStoryPage(){
        boolean isResult;
        isResult = commonFeedsPage.afterPickAsStoryRedirectOnStoryPage();
        Assert.assertTrue(isResult, "Pick as story not working: " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-712: verify section and Status filter and click on Pick as Story and redirect on story page")
    @Test
    public void verifyFiltersOnPrintFeedAndClickOnPickAsStory() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Mint Lounge")) {

            Map<String, String> paramsMap = globalVars.getParamsData("verifyFiltersOnPrintFeedAndClickOnPickAsStory", property);

            isResult = commonFeedsPage.sectionFilter(paramsMap.get("section"));
            Assert.assertTrue(isResult, "Section Filter not working: " + property);

            isResult = commonFeedsPage.statusFilter(paramsMap.get("status"));
            Assert.assertTrue(isResult, "Status Filter not working: " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3084: Verify user is able to preview the story from LH Gallery Feed and pick from there.")
    @Test
    public void verifyUserIsAbleToPreviewTheStoryFromLhGalleryFeedAndPickFromThere(){
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            isResult = commonFeedsPage.checkUserIsAbleToPreviewTheStoryFromLhGalleryFeedAndPickFromThere();
            Assert.assertTrue(isResult, "user is not able to preview the story from LH Gallery Feed: " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3095: Verify that user is able to do pick as story from the stories present on LH Gallery Feed and check the data on the new tab opens on blankpaper")
    @Test
    public void verifyThatUserIsAbleToDoPickAsStoryFromTheStoriesPresentOnLhGalleryFeedAndCheckTheDataOnTheNewTabOpensOnBlankpaper(){
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = commonFeedsPage.checkThatUserIsAbleToDoPickAsStoryFromTheStoriesPresentOnLhGalleryFeedAndCheckTheDataOnTheNewTabOpensOnBlankpaper();
        Assert.assertTrue(isResult, "User is not able to do pick as story from the stories present on LH Gallery Feed: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3098: Verify that user is able to create a story from LH Gallery feed then publish the same")
    @Test
    public void verifyThatUserIsAbleToCreateStoryFromLhGalleryFeedThenPublishTheSame(){
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateStoryFromLhGalleryFeedThenPublishTheSame", property);
        isResult = commonFeedsPage.checkThatUserIsAbleToCreateStoryFromLhGalleryFeedThenPublishTheSame(paramsMap.get("byline"));
        Assert.assertTrue(isResult, "User is not able to create a story from LH Gallery feed then publish the same: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-3081 Verify user is able to preview the story from LH Gallery Feed")
    @Test
    public void verifyUserIsAbleToPreviewTheStoryLhGalleryFeed(){
        if (this.property.equals("HT NEW")) {
            boolean isResult;
            isResult = commonFeedsPage.isUserAbleToPreviewTheStoryLhGalleryFeed();
            Assert.assertTrue(isResult, "LH Gallery feed data preview not working with " + property);
        }
        else Utils.logStepInfo("Test case is valid only for HT NEW Domain!!! but currently selected domain is"+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5314 - verifyThatUserIsAbleToSeeFeedsTabPresentInTheSidebar")
    @Test()
    public void verifyThatUserIsAbleToSeeFeedsTabPresentInTheSidebar() {
        boolean isResult;
        isResult=commonFeedsPage.checkIfUserIsAbleToSeeFeedsTabPresentInTheSidebar();
        Assert.assertTrue(isResult, "failed to verify created status");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5315 - verifyThatUserIsAbleToClickOnFeedsTabPresentInSidebar")
    @Test()
    public void verifyThatUserIsAbleToClickOnFeedsTabPresentInSidebar() {
        boolean isResult;
        isResult=commonFeedsPage.checkIfUserIsAbleToClickOnFeedsTabPresentInSidebar();
        Assert.assertTrue(isResult, "failed to verify created status");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5316 - VerifyThatUserIsAbleToSelectPrintFeedTab")
    @Test()
    public void VerifyThatUserIsAbleToSelectPrintFeedTab() {
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint") || this.property.equals("Mint Lounge")) {
            boolean isResult;
            Map<String, String> paramsMap = globalVars.getParamsData("VerifyThatUserIsAbleToSelectPrintFeedTab", property);
            isResult = commonFeedsPage.checkIfUserIsAbleToSelectPrintFeedTab(paramsMap.get("borderColor"));
            Assert.assertTrue(isResult, "failed to verify selection of print feeds");
        }
        else Utils.logStepInfo("Test case is valid only for HT NEW,LM,Mint Lounge Domain!!! but currently selected domain is"+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5317 - Verify that user is able see 5 columns in the table")
    @Test()
    public void verifyThatUserIsAbleSeeFiveColumnsInTheTable() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatUserIsAbleSeeFiveColumnsInTheTable", property);
        isResult = commonFeedsPage.checkIfUserIsAbleSeeFiveColumnsInTheTable(paramsMap.get("headingOne"),paramsMap.get("headingTwo"),paramsMap.get("headingThree"), paramsMap.get("headingFour"),paramsMap.get("headingFive"));
        Assert.assertTrue(isResult, "failed to verify table headings");
    }

        @AfterMethod
        public void closeOtherOpenTabs() {
            commonFunctions.closeAllWindowsExceptMasterTabOnly();
            commonFunctions.refreshPage();
        }

    }


