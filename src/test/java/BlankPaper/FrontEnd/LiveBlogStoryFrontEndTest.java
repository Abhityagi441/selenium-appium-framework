package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonLiveBlogPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.LiveBlogPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class LiveBlogStoryFrontEndTest {
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonLiveBlogPage liveBlogPage;
    private static CommonFrontEndPage commonUiPage;
    GlobalVars globalVars;
    String property ="";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property =property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        liveBlogPage = CommonLiveBlogPage.getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonUiPage= CommonFrontEndPage.getInstance(property);
    }

    @BeforeMethod
    public void ensureHomePageVisibility(){
        dashboardPage.navigateToHomePageDashboard();
    }


    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1164:To verify live blog publish status and Verify UI frontend")
    @Test
    public void verifyLiveBlogPublishAndVerifyFrontend() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLiveBlogPublishAndVerifyFrontend", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationLiveBlogStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("paragraph"), paramsMap.get("postTitle"),paramsMap.get("postBody"), LiveBlogPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* LiveBlog Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1165: To verify live blog schedule publish status and Verify Frontend UI ")
    @Test
    public void verifyScheduledPublishLiveBlogAndVerifyFrontEnd() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyScheduledPublishLiveBlogAndVerifyFrontEnd", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.schedulePublishAndVerify();
        Assert.assertTrue(isResult, "Schedule publish is failed : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, true);
        Assert.assertTrue(isResult, "Scheduled Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.waitForPublished(LiveBlogPage.storyIdNumber);
        Assert.assertTrue(isResult, "Schedule publish to published verification failed : " + property);
        dashboardPage.clickOnBlankPaperLogo();
        commonFunctions.hardWait(5000);


        isResult = commonUiPage.dataValidationLiveBlogStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("paragraph"), paramsMap.get("postTitle"),paramsMap.get("postBody"), LiveBlogPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* LiveBlog Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description(" : To verify photo gallery soft publish status and Front end UI")
    @Test
    public void verifyLiveBlogSoftPublishWithUI() {
        boolean isResult;

        Map<String, String> paramsMap = globalVars.getParamsData("verifyLiveBlogSoftPublishWithUI", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        headLine = headLine+commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.softPublish(headLine);
        Assert.assertTrue(isResult, "Live Blog Story is not soft published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), true, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationSoftPublishLiveBlogStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("paragraph"), paramsMap.get("postTitle"),paramsMap.get("postBody"), LiveBlogPage.storyIdNumber,LiveBlogPage.timeOnPublishedStory);
        Assert.assertTrue(isResult, "******* LiveBlog Story data on Front End not verified ******** : " + property);

    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1368: To verify liveBlog kill status and Front end UI")
    @Test
    public void verifyLiveBlogKillWithUI() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyLiveBlogKillWithUI", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = dashboardPage.copyUrlAndHeadlineOfPublishedStory(paramsMap.get("storyType"));
        Assert.assertTrue(isResult, "Story headline and url not copied : " + property);

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        isResult = dashboardPage.killStoryAndVerify(LiveBlogPage.storyIdNumber, DashboardPage.storyUrl);
        Assert.assertTrue(isResult, "Story is not killed : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, true, 0, false);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), DashboardPage.storyHeadlineText, LiveBlogPage.storyIdNumber);
        Assert.assertTrue(isResult, "PhotoGallery kill story not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1370: To verify liveBlog change url status and Front end UI")
    @Test
    public void verifyLiveBlogChangeUrlWithUI() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyLiveBlogChangeUrlWithUI", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String newUrlHeadline = paramsMap.get("UrlHeadline") + urlIndex;
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationLiveBlogStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("paragraph"), paramsMap.get("postTitle"),paramsMap.get("postBody"), LiveBlogPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* LiveBlog Story data on Front End not verified ******** : " + property);

        isResult = liveBlogPage.checkChangeUrl(newUrlHeadline);
        Assert.assertTrue(isResult, "LiveBlog Story url is not changed : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);

        isResult = commonUiPage.dataValidationLiveBlogStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), newUrlHeadline, paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("paragraph"), paramsMap.get("postTitle"),paramsMap.get("postBody"), LiveBlogPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* LiveBlog Story data on Front End not verified ******** : " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

}
