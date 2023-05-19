package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonHighlightsPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.HighlightsPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class HighlightsFrontEndTest {
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonHighlightsPage highlightsPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property ="";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property =property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        highlightsPage = CommonHighlightsPage.getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    public void ensureHomePageVisibility(){
        dashboardPage.navigateToHomePageDashboard();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1187: This test case will create and publish a story and verify data on Front end Ui")
    @Test
    public void verifyPublishForHighlightsStoryWithUi() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPublishForHighlightsStoryWithUi", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLightStory(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.dataValidationHighlightsStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("location"), HighlightsPage.storyIdNumber);
        Assert.assertTrue(isResult, "Highlights Story data not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1188: This test case will create and publish a story and change url and verify data on Front end Ui")
    @Test
    public void checkChangeUrlStoryForHighlightsWithUi() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("checkChangeUrlStoryForHighlightsWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String changeUrlHeadline = paramsMap.get("UrlHeadline") + urlIndex;
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLightStory(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/


        isResult = commonFrontEndPage.dataValidationHighlightsStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("location"), HighlightsPage.storyIdNumber);
        Assert.assertTrue(isResult, "Highlights Story data not verified On FrontEnd : " + property);

        isResult = highlightsPage.checkChangeUrl(changeUrlHeadline);
        Assert.assertTrue(isResult, "Highlights Story url is not changed : " + property);

        isResult = commonFrontEndPage.dataValidationHighlightsStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), changeUrlHeadline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("location"), HighlightsPage.storyIdNumber);
        Assert.assertTrue(isResult, "Change URL Highlights Story data not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1189: This test case will create and schedule publish a story and verify data on Front end Ui")
    @Test
    public void verifySchedulePublishForHighlightsWithUi() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySchedulePublishForHighlightsWithUi", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLightStory(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.scheduleHighLightAndVerify();
        Assert.assertTrue(isResult, "Scheduled publish is failed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, true);
        Assert.assertTrue(isResult, "Schedule Data not verified from MongoDB : " + property);

        isResult = commonFrontEndPage.waitForSchedulePublishToPublished(HighlightsPage.storyIdNumber);
        Assert.assertTrue(isResult, "Schedule publish to published verification failed : " + property);

        isResult = commonFrontEndPage.dataValidationHighlightsStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("location"), HighlightsPage.storyIdNumber);
        Assert.assertTrue(isResult, "Highlights Story data not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1190: This test case will create and soft publish a story and verify data on Front end Ui")
    @Test
    public void verifySoftPublishForHighlightsWithUi() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySoftPublishForHighlightsWithUi", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLightStory(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        String newHeadline = paramsMap.get("newHeadline")+" "+commonFunctions.generateRandomNum()+"aw";
        isResult = highlightsPage.softPublishWithNewHeadline(newHeadline);
        Assert.assertTrue(isResult, "Standard Story is not soft published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), newHeadline, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), true, false, 0, false);
        Assert.assertTrue(isResult, "Soft Publish Data not verified from MongoDB : " + property);

        isResult = commonFrontEndPage.dataValidationWithPublishTimeStandardStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), newHeadline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("location"), HighlightsPage.storyIdNumber, HighlightsPage.timeOnPublishedStory);
        Assert.assertTrue(isResult, "Highlights Story data not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1369: This test case will kill story verify data on Front end Ui")
    @Test
    public void verifyKillStoryForHighlightsWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyKillStoryForHighlightsWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = dashboardPage.copyUrlAndHeadlineOfPublishedStory(paramsMap.get("storyType"));
        Assert.assertTrue(isResult, "Story headline and url not copied : " + property);

        isResult = highlightsPage.createHighLightStory(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = dashboardPage.killStoryAndVerify(HighlightsPage.storyIdNumber, DashboardPage.storyUrl);
        Assert.assertTrue(isResult, "Story is not killed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, true, 0, false);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);

        isResult = commonFrontEndPage.killHighlightsStoryDataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), DashboardPage.storyHeadlineText, HighlightsPage.storyIdNumber);
        Assert.assertTrue(isResult, "Standard Story kill story not verified On FrontEnd : " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

}
