package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonVideoStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.LiveBlogPage;
import com.pages.BlankPaper.webdesktop.stories.VideoStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

public class VideoStoryTest {

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

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-85: This test case will create a video story and verify by id")
    @Test
    public void verifyVideoStoryCreation() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryCreation", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }


    @Author(name = "Ishank Khatri")
    @Description("QAAUT-193: This test case will create a video story and verify by CREATED status on dashboard")
    @Test(priority = -1)
    public void verifyVideoStoryCreationStatus() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryCreationStatus", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created with Created Status: " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-97: This test case will create a video story and discard it and verify by searching via id to check No data is coming")
    @Test
    public void verifyVideoStoryDiscard() {
        boolean isResult;
        String embedUrl = null;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryDiscard", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if (!globalVars.isProdRun()) {
            isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Video Story is not created : " + property);
            embedUrl = VideoStoryPage.embedUrl;
            embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
            isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = videoStoryPage.discardVideoStoryAndVerify();
        Assert.assertTrue(isResult, "Video Story is not discarded : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 1, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-90 ,QAAUT-14 : This test case will create a video story and file it and verify by searching via id to check EDITED status")
    @Test
    public void verifyVideoStoryEdit() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryEdit", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        headLine = paramsMap.get("editHeadline") +" "+commonFunctions.generateRandomNum()+"aw";
        isResult = videoStoryPage.editVideoStoryAndVerify(headLine);
        Assert.assertTrue(isResult, "Video Story is not edited : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Edited Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-96:This test case will create a video story and schedule it and verify by searching via id to check SCHEDULE status")
    @Test
    public void verifyVideoStorySchedule() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStorySchedule", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = videoStoryPage.scheduleVideoStoryAndVerify();
        Assert.assertTrue(isResult, "Video Story is not schedule : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, true);
        Assert.assertTrue(isResult, "Schedule Data not verified from MongoDB : " + property);

    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-192:This test case will create a video story and Publish it and verify by searching via id to check PUBLISHED status")
    @Test
    public void verifyVideoStoryPublish() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-39:This test case will create a video story and soft Publish it and verify by soft publish toaster message")
    @Test
    public void verifyVideoStorySoftPublish() {
        boolean isResult;
        String embedUrl = null;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStorySoftPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if (!globalVars.isProdRun()) {
            isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Video Story is not created : " + property);
            embedUrl = VideoStoryPage.embedUrl;
            embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
            isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = videoStoryPage.verifyPublishVideoStory();
            Assert.assertTrue(isResult, "Video Story is not publish : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
            Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        }

        isResult = videoStoryPage.softPublishVideoStoryAndVerify();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, true, false, 0, false);
        Assert.assertTrue(isResult, "Soft PUBLISHED Data not verified from MongoDB : " + property);

    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-119:This test case will create a video story and kill it and verify by searching via id to check KILLED status")
    @Test
    public void verifyVideoStoryKill() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStorySoftPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        isResult = videoStoryPage.killVideoStoryAndVerify();
        Assert.assertTrue(isResult, "Video Story is not killed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, true, 0, false);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-62:This test case will create a video story and purge it and verify by purge toaster message")
    @Test
    public void verifyVideoStoryPurge() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryPurge", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        isResult = videoStoryPage.purgeVideoStoryAndVerify();
        Assert.assertTrue(isResult, "Video Story is not purged : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-486:This test case will create a video story and assign custom headline for different platform and social media")
    @Test
    public void verifyVideoStoryCustomHeadline() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryCustomHeadline", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if (!globalVars.isProdRun()) {
            isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Video Story is not created : " + property);
            String embedUrl = VideoStoryPage.embedUrl;
            embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
            isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = videoStoryPage.updateCustomHeading(paramsMap.get("landingHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"), paramsMap.get("newsletterHeadline"), this.property);
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHeadinesOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), paramsMap.get("landingHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"));
        Assert.assertTrue(isResult, "Updated Headlines Data not verified from MongoDB : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Test
    @Description("QAAUT-485 VIDEO STORY CHANGE URL")
    public void verifyVideoStoryChangeURL() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryChangeURL", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.verifyCreateVideoStory(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = videoStoryPage.publishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("PUBLISHED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        isResult = videoStoryPage.changeUrlVideoStory();
        Assert.assertTrue(isResult, "Video Gallery URL is not changed: " + property);

    }

    @Author(name = "Giridhar Raj")
    @Test
    public void verifyVideoStoryDeleteContent() {
        boolean isResult;
        String embedUrl = null;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoStoryDeleteContent", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if (!globalVars.isProdRun()) {
            isResult = videoStoryPage.verifyCreateVideoStory(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Video Story is not created : " + property);
            embedUrl = VideoStoryPage.embedUrl;
            embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
            isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = videoStoryPage.verifyDeleteVideoStoryContent();
        Assert.assertTrue(isResult, "Video Story content is not deleted : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, "", paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "DeleteVideoStoryContent Data not verified from MongoDB : " + property);

    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-122: To verify crop of imag and upload image")
    @Test
    public void verifyImageCroppingVideoStoryPage() {
        boolean isResult;
        String embedUrl = null;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyImageCroppingVideoStoryPage", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if (!globalVars.isProdRun()) {
            isResult = videoStoryPage.verifyCreateVideoStory(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Video Story is not created : " + property);
            embedUrl = VideoStoryPage.embedUrl;
            embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
            isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = videoStoryPage.verifyUploadImage();
        Assert.assertTrue(isResult, "Image upload is failed : " + property);

        isResult = videoStoryPage.verifyImageCropping();
        Assert.assertTrue(isResult, "Image cropping is failed : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-38: To verify scrolling function with pagaination hits on console")
    @Test
    public void verifyPaginationForVideoStory() {
        boolean isResult;
//        dashboardPage.clearSearch();
        isResult = dashboardPage.verifyPagination();
        Assert.assertTrue(isResult, "Pagination is not verified : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-86: This test case will verify the validation Embed code")
    @Test
    public void verifyEmbedCodeValidationVideoStory() {
        Map<String, String> paramsMap = globalVars.getParamsData("verifyEmbedCodeValidationVideoStory", property);

        boolean isResult = videoStoryPage.embedCodeValidation(paramsMap.get("embedUrl"));
        Assert.assertTrue(isResult, "Embed code not validate : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-758: This test case will verify the validation of headline in English")
    @Test
    public void verifyVideoTranslateLanguageOnVideoStory() {
        if (this.property.equals("Smart 24") || this.property.equals("Bangla")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoTranslateLanguageOnVideoStory", property);

            boolean isResult = videoStoryPage.videoTranslateLanguage(paramsMap.get("embedUrl"), paramsMap.get("headline"), this.property);
            Assert.assertTrue(isResult, "Translate Language not verified : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-465: This test case will verify the popup Add video Embed page")
    @Test
    public void verifyPopupEmbedPageOnVideoStory() {
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPopupEmbedPageOnVideoStory", property);

        boolean isResult = videoStoryPage.popupEmbedPage(paramsMap.get("embedUrl"));
        Assert.assertTrue(isResult, "Add Video Embed page popup not verified : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-110: This test case will create a video story and verify the preview of story")
    @Test
    public void verifyPreviewOfMobileAndDesktopOnVideoPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPreviewOfMobileAndDesktopOnVideoPage", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = videoStoryPage.createVideoStoryAndVerify(headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);
        String embedUrl = VideoStoryPage.embedUrl;
        embedUrl = embedUrl.substring(embedUrl.indexOf("http"), embedUrl.indexOf("title")-2).trim();
        isResult = dashboardPage.verifyMongoDBConnectionAndVideoStoryDetailsOnBackend("CREATED", VideoStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), embedUrl, false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        //TODO: verify the headline text of mobile and desktop preview
        isResult = dashboardPage.mobileAndDesktopPreview(headLine);
        Assert.assertTrue(isResult, "preview functionality is not working : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3106: Verify that whatever data we are providing in landing page headline on Video story the same data is present in metatitle or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInLandingPageHeadlineOnVideoStoryTheSameDataIsPresentInMetatitleOrNot(){
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatWhateverDataWeAreProvidingInLandingPageHeadlineOnVideoStoryTheSameDataIsPresentInMetatitleOrNot", property);
        isResult = videoStoryPage.checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetatitle(paramsMap.get("EmbedUrl"));
        Assert.assertTrue(isResult, "Whatever data we are providing in landing page headline on Video story the same data is not present in metatitle: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3138: Verify that whatever data we are providing in summary of Video story the same data is present in metadescription or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInSummaryOfVideoStoryTheSameDataIsPresentInMetadescription(){
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatWhateverDataWeAreProvidingInSummaryOfVideoStoryTheSameDataIsPresentInMetadescription", property);
        isResult = videoStoryPage.checkWhateverDataWeAreProvidingSameDataIsPresentInMetadescription(paramsMap.get("EmbedUrl"));
        Assert.assertTrue(isResult, "Whatever data we are providing in summary of Video story the same data is not present in metadescription: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3144: Verify that after publishing the story with metatitle and meta description on video story the complete data goes to master db")
    @Test
    public void verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnVideoStoryTheCompleteDataGoesToMasterDb(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnVideoStoryTheCompleteDataGoesToMasterDb", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = videoStoryPage.checkAfterPublishingVideoStoryTheCompleteDataGoesToMasterDb(paramsMap.get("embededUrl"), this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "After publishing the story with metatitle and meta description on video story the complete data does not go to master db: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4916: Verify that the user is able to create story (Video) with Live Hindustan Affiliate tenant")
    @Test
    public void verifyThatTheUserIsAbleToCreateVideoStoryWithLiveHindustanAffiliateTenant(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheUserIsAbleToCreateVideoStoryWithLiveHindustanAffiliateTenant", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = videoStoryPage.checkCreateVideoStoryWithLiveHindustanAffiliateTenant(paramsMap.get("embededUrl"), this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "User is not able to create story (Video) with Live Hindustan Affiliate tenant: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4989: Verify video duration field")
    @Test
    public void verifyVideoDurationField(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoDurationField", property);
        if (this.property.equals("Live Mint") || this.property.equals("HT NEW")) {
            isResult = videoStoryPage.checkVideoDurationField(paramsMap.get("embededUrl"), this.property);
            Assert.assertTrue(isResult, "Video duration field is not displaying: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4990: Verify video duration field values validation with alpha character")
    @Test
    public void verifyVideoDurationFieldValuesValidationWithAlphaCharacter(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoDurationFieldValuesValidationWithAlphaCharacter", property);
        if (this.property.equals("Live Mint") || this.property.equals("HT NEW")) {
            isResult = videoStoryPage.checkVideoDurationFieldValidationWithAlphaCharacter(paramsMap.get("embededUrl"), this.property);
            Assert.assertTrue(isResult, "Video duration field is accepting Alpha Character: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4991: Verify video duration field values validation with numeric value")
    @Test
    public void verifyVideoDurationFieldValuesValidationWithNumericValue(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyVideoDurationFieldValuesValidationWithNumericValue", property);
        if (this.property.equals("Live Mint") || this.property.equals("HT NEW")) {
            isResult = videoStoryPage.checkVideoDurationFieldValidationWithNumericValue(paramsMap.get("embededUrl"), this.property, paramsMap.get("min"), paramsMap.get("sec"));
            Assert.assertTrue(isResult, "Video duration field is accepting more then 2 Numeric Value: " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5327: Verify that user is able to Create Story (Video)")
    @Test
    public void verifyThatUserIsAbleToCreateVideoStory(){
        boolean isResult;
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateVideoStory", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = videoStoryPage.checkIfUserCanCreateVideoStory(this.property, headLine, summary,paramsMap.get("embedCode"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "User is not able to create video story: " + property);
    }


    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
        if (globalVars.isProdRun()) {
            dashboardPage.clickOnBlankPaperLogo();
            dashboardPage.storyCleanup(VideoStoryPage.storyIdNumber);
        } else {
            System.out.println("no cleanup done for staging env!!!");
        }
    }


}
