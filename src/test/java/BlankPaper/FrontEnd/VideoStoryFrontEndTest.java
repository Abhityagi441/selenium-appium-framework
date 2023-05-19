package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonVideoStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.VideoStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class VideoStoryFrontEndTest {

    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonVideoStoryPage videoStoryPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        videoStoryPage = CommonVideoStoryPage.getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    @Description("In case of failure this method will navigate to Dashboard")
    public void ensureHomePageVisibility() {
        dashboardPage.navigateToHomePageDashboard();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1139: This test case will create and publish a video story and verify data on Front end Ui")
    @Test
    public void verifyVideoStoryPublishWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryPublishWithUi", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.dataValidationVideoStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"), summary, VideoStoryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* Video Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1135: This test case will create and publish a video story and verify data on Front end Ui")
    @Test
    public void verifyVideoStorySoftPublishWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStorySoftPublishWithUi", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        headLine = paramsMap.get("newHeadline")+commonFunctions.generateRandomNum()+"aw";
        isResult = videoStoryPage.softPublishWithNewHeadline(headLine);
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, true, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.dataValidationWithPublishTimeVideoStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"), summary, VideoStoryPage.storyIdNumber, VideoStoryPage.timeOnPublishedStory);
        Assert.assertTrue(isResult, "******* Video Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1143: This test case will create a video story and schedule it and verify by searching via id to check SCHEDULE status")
    @Test
    public void verifyVideoStoryScheduleWithUi() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyVideoStoryScheduleWithUi", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = videoStoryPage.scheduleVideoStoryAndVerify();
        Assert.assertTrue(isResult, "Video Story is not schedule : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, true);
        Assert.assertTrue(isResult, "Schedule Data not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.waitForPublished(VideoStoryPage.storyIdNumber);
        Assert.assertTrue(isResult, "Schedule publish to published verification failed : " + property);
        dashboardPage.clickOnBlankPaperLogo();
        commonFunctions.hardWait(5000);

        isResult = commonFrontEndPage.dataValidationVideoStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"), summary, VideoStoryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* Video Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1168: This test case will create a video story and then change url and check on FrontEnd")
    @Test
    public void checkChangeUrlOnVideoStoryWithUi() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("checkChangeUrlOnVideoStoryWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String changeUrlHeadline = paramsMap.get("UrlHeadline") + urlIndex;
        String headline = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headline, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);

        isResult = commonFrontEndPage.dataValidationVideoStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headline, paramsMap.get("section"), paramsMap.get("subsection"), summary, VideoStoryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* Video Story data on Front End not verified ******** : " + property);

        isResult = videoStoryPage.changeUrlVideoStory(changeUrlHeadline);
        Assert.assertTrue(isResult, "Video Gallery URL is not changed: " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);

        isResult = commonFrontEndPage.dataValidationVideoStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), changeUrlHeadline, paramsMap.get("section"), paramsMap.get("subsection"), summary, VideoStoryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* Video Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1364: This test case will kill a video story and verify data on Front end Ui")
    @Test
    public void verifyVideoStoryKillWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryKillWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = dashboardPage.copyUrlAndHeadlineOfPublishedStory(paramsMap.get("storyType"));
        Assert.assertTrue(isResult, "Story headline and url not copied : " + property);

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        isResult = dashboardPage.killStoryAndVerify(VideoStoryPage.storyIdNumber, DashboardPage.storyUrl);
        Assert.assertTrue(isResult, "Story is not killed : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, true, 0, false);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), DashboardPage.storyHeadlineText, VideoStoryPage.storyIdNumber);
        Assert.assertTrue(isResult, "Video Story kill story not verified On FrontEnd : " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

}
