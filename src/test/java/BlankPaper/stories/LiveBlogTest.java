package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonLiveBlogPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.LiveBlogPage;
import com.pages.BlankPaper.webdesktop.stories.StandardStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;


public class LiveBlogTest {
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

    @Author(name = "Deepesh Saini")
    @Test(priority = -1)
    public void verifyLiveBlogCreation() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLiveBlogCreation", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT:74 QAAUT-49 :")
    @Test
    public void verifyLiveBlogEdit() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLiveBlogEdit", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        if(paramsMap.get("editHeadline").length()>25) {
            headLine = paramsMap.get("editHeadline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("editHeadline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        isResult = liveBlogPage.editLiveBlogAndVerify(headLine);
        Assert.assertTrue(isResult, "Live Blog Story is not edited : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyLiveBlogPublish() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLiveBlogPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyLiveBlogPurge() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLiveBlogPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.purgeStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not purged : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyKillLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyKillLiveBlog", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);


        isResult = liveBlogPage.verifyKillStory();
        Assert.assertTrue(isResult, "Live Blog Story is not killed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, true, 0, false);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void checkChangeUrlLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("checkChangeUrlLiveBlog", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.publishStoryAndVerify();
        Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.checkChangeUrl();
        Assert.assertTrue(isResult, "Live Blog Story url is not changed : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifySoftPublishLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySoftPublishLiveBlog", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = liveBlogPage.uploadLiveBlogImage();
            Assert.assertTrue(isResult, "Image is not uploaded : " + property);

            isResult = liveBlogPage.publishStoryAndVerify();
            Assert.assertTrue(isResult, "Live Blog Story is not published : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("PUBLISHED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        }

        isResult = liveBlogPage.softPublish();
        Assert.assertTrue(isResult, "Live Blog Story is not soft published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), true, false, 0, false);
        Assert.assertTrue(isResult, "Soft Published Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyScheduledPublishLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyScheduledPublishLiveBlog", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.uploadLiveBlogImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

        isResult = liveBlogPage.schedulePublishAndVerify();
        Assert.assertTrue(isResult, "Schedule publish is failed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, true);
        Assert.assertTrue(isResult, "Schedule publish Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    @Description("QAAUT-23:To verify crop of image")
    public void verifyImageCroppingLiveBLog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyImageCroppingLiveBLog", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = liveBlogPage.verifyUploadImage();
        Assert.assertTrue(isResult, "Image upload is failed : " + property);

        isResult = liveBlogPage.verifyImageCropping();
        Assert.assertTrue(isResult, "Image cropping is failed : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyDiscardLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDiscardLiveBlog", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if(!globalVars.isProdRun()) {
            isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = liveBlogPage.discardLiveBlogAndVerify();
        Assert.assertTrue(isResult, "Story is not discarded : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 1, false);
        Assert.assertTrue(isResult, "Discarded Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyCustomHeadlineTextLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCustomHeadlineTextLiveBlog", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if(!globalVars.isProdRun()) {
            isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        }

        isResult = liveBlogPage.updateCustomHeading(paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"), paramsMap.get("newsletterHeadline"), this.property);
        Assert.assertTrue(isResult, "Custom headline is not verified : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHeadinesOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"));
        Assert.assertTrue(isResult, "Updated Headlines Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-50: This test case will verify the validation of headline in English")
    @Test
    public void verifyUrlHeadlineTranslateLanguage() {
        if(this.property.equals("Bangla")||this.property.equals("Smart 24")) {
            boolean isResult;
            Map<String, String> paramsMap=globalVars.getParamsData("verifyUrlHeadlineTranslateLanguage", property);
            String headLine;
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
            if(!globalVars.isProdRun()) {
                isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
                Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
                isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
                Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
            }

            isResult = liveBlogPage.uploadLiveBlogImage();
            Assert.assertTrue(isResult, "Image is not uploaded : " + property);

            isResult = liveBlogPage.urlHeadlineForLanguages(paramsMap.get("englishHeadline"));
            Assert.assertTrue(isResult, "Custom headline title is not changed : " + property);
        }else{
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyMouseHoverOnLeftPanelLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLoginWithGoogle", property);

        //TODO: 1) this method needs to be moved to dashboard page class instead of having them in various page classes such as PhotoGalleryPage, StandardStoryPage classes etc. repeatedly
        //TODO: 2) Also this method needs to be parametrized with the element name and it should be called the same number of times as the number of elements in left panel with different parameters
        isResult = liveBlogPage.mouseHoverOnLeftPannelAndVerifyElementsAndUser(paramsMap.get("expectedUserName"));
        Assert.assertTrue(isResult, "Mouse hover is not verified : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyPaginationLiveBLog() {
        boolean isResult;
        //TODO: this method needs to be moved to dashboard page class instead of having them in various page classes such as PhotoGalleryPage, StandardStoryPage classes etc. repeatedly
        //Done
        isResult = dashboardPage.verifyPagination();
        Assert.assertTrue(isResult, "Pagination is not verified : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-73: To verify delete content")
    @Test
    public void verifyLiveBlogStoryDeleteContent() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLiveBlogStoryDeleteContent", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if(!globalVars.isProdRun()) {
            isResult = liveBlogPage.createAndVerifyLiveBlog(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Live Blog Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = liveBlogPage.deleteLiveBlogContent();
        Assert.assertTrue(isResult, "Live Blog Story content is not deleted : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, "", paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

    }


    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1597: This test case will verify multiple post")
    @Test
    public void verifyLiveBlogMultipleElementsInSinglePost() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyLiveBlogMultipleElementsInSinglePost", property);
        String headLine;

        if (this.property.equals("Bangla")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.addingMultipleElementsInSinglePostAndPublishPost(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("byline"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("urlHeadline"), this.property, paramsMap.get("firstCaption"), paramsMap.get("secondCaption"));
        Assert.assertTrue(isResult, "adding Multiple Elements In Single Post not Verified !!!!!!!!!!! " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = liveBlogPage.addingMultipleElementsInSinglePost(paramsMap.get("postTitle"), paramsMap.get("postBody"));
        Assert.assertTrue(isResult, "adding Multiple Elements In Single Post and Publish Post not Verified !!!!!!!!!!! " + property);

        isResult = liveBlogPage.addingCombinationOfDifferentElementInSinglePost(paramsMap.get("embedUrl"), paramsMap.get("srcEmbed"), paramsMap.get("postTitle"), paramsMap.get("postBody"));
        Assert.assertTrue(isResult, "adding Combination Of Different Elements In Single Post not Verified !!!!!!!!!!! " + property);

        isResult = liveBlogPage.pinMultiplePostAndAllPost();
        Assert.assertTrue(isResult, "Pin Multiple Post and All Post not Verified !!!!!!!!!!! " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Lav Kumar Singh")
    @Description("QAAUT-3027: This test case will verify multiple image in single post")
    @Test
    public void verifyLiveBlogMultipleImageSinglePost() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyLiveBlogMultipleImageSinglePost", property);
        String headLine;

        if (this.property.equals("Bangla")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

            isResult = liveBlogPage.addingMultipleElementsInSinglePostAndPublishPost(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("byline"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("urlHeadline"), this.property, paramsMap.get("firstCaption"), paramsMap.get("secondCaption"));
            Assert.assertTrue(isResult, "adding Multiple Elements In Single Post not Verified !!!!!!!!!!! " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = liveBlogPage.addingMultipleElementsInSinglePost(paramsMap.get("postTitle"), paramsMap.get("postBody"));
            Assert.assertTrue(isResult, "adding Multiple Elements In Single Post and Publish Post not Verified !!!!!!!!!!! " + property);

        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }
    @Author(name = "Lav Kumar Singh")
    @Description("QAAUT-3028: This test case will verify multiple embed in single post")
    @Test
    public void verifyLiveBlogMultipleEmbedSinglePost() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyLiveBlogMultipleEmbedSinglePost", property);
        String headLine;

        if (this.property.equals("Bangla")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

            isResult = liveBlogPage.addingMultipleElementsInSinglePostAndPublishPost(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("byline"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("postTitle"), paramsMap.get("postBody"), paramsMap.get("urlHeadline"), this.property, paramsMap.get("firstCaption"), paramsMap.get("secondCaption"));
            Assert.assertTrue(isResult, "adding Multiple Elements In Single Post not Verified !!!!!!!!!!! " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend("CREATED", LiveBlogPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("postTitle"), paramsMap.get("postBody"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = liveBlogPage.addingMultipleEmbedInSinglePost(paramsMap.get("embedUrl"), paramsMap.get("srcEmbed"), paramsMap.get("postTitle"), paramsMap.get("postBody"));
            Assert.assertTrue(isResult, "adding Different embed In Single Post not Verified !!!!!!!!!!! " + property);


        } else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }


    @Author(name = "Raj")
    @Description("QAAUT-3104: Verify that whatever data we are providing in landing page headline on Live Blog the same data is present in metatitle or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInLandingPageHeadlineOnLiveBlogTheSameDataIsPresentInMetatitleOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = liveBlogPage.checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnLiveBlogTheSameDataIsPresentInMetatitleOrNot();
        Assert.assertTrue(isResult, "Whatever data we are providing in landing page headline on Live Blog the same data is not present in metatitle: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3137: Verify that whatever data we are providing in summary of Live blog story the same data is present in metadescription or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInSummaryOfLiveBlogStoryTheSameDataIsPresentInMetadescriptionOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = liveBlogPage.checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription();
        Assert.assertTrue(isResult, "Whatever data we are providing in summary of Live blog story the same data is not present in metadescription: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3143: Verify that after publishing the story with metatitle and meta description on live blog story the complete data goes to master db")
    @Test
    public void verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnLiveBlogStoryTheCompleteDataGoesToMasterDb() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnLiveBlogStoryTheCompleteDataGoesToMasterDb", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
            String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
            isResult = liveBlogPage.checkAfterPublishingLiveBlogStoryDataGoesToMasterDb(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "After publishing the story with metatitle and meta description on live blog story the complete data does not go to master db: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4908: Verify that for live blog post , there is an image cropping option present")
    @Test
    public void verifyThatForLiveBlogPostThereIsAnImageCroppingOptionPresent() {
        boolean isResult;
        if (this.property.equals("Auto")) {
            isResult = liveBlogPage.checkLiveBlogPostImageCroppingOption(this.property);
            Assert.assertTrue(isResult, "For live blog post , there is an image cropping option is not present: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4914: Verify that the user is able to create story (Live Blog) with Live Hindustan Affiliate tenant")
    @Test
    public void verifyUserIsAbleToCreateLiveBlogStoryWithLiveHindustanAffiliateTenant() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserIsAbleToCreateLiveBlogStoryWithLiveHindustanAffiliateTenant", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
            String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
            isResult = liveBlogPage.checkCreateLiveBlogStoryWithLiveHindustanAffiliateTenant(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "user is not able to create story (Live Blog) with Live Hindustan Affiliate tenant: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4952: Verify that load more button is appearing after 5posts in a live blog")
    @Test
    public void verifyThatLoadMoreButtonIsAppearingAfterFivePostsInliveBlog() {
        boolean isResult;
        if (this.property.equals("Live Mint")) {
            isResult = liveBlogPage.checkLoadMoreButtonIsAppearingAfterFivePostsInliveBlog(this.property);
            Assert.assertTrue(isResult, "Load more button is not appearing after 5posts in a live blog: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4953: Verify that after clicking load more button all the posts should be displayed")
    @Test
    public void verifyThatAfterClickingLoadMoreButtonAllThePostsShouldBeDisplayed() {
        boolean isResult;
        if (this.property.equals("Live Mint")) {
            isResult = liveBlogPage.checkLoadMoreButtonFunctionality(this.property);
            Assert.assertTrue(isResult, "After clicking load more button all the posts are not displaying: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5149: Validate element is added for cricket scoreboard")
    @Test
    public void verifyElementIsAddedForCricketScoreboard() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyElementIsAddedForCricketScoreboard", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
            String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
            isResult = liveBlogPage.checkElementIsAddedForCricketScoreboard(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Element is not added for cricket scoreboard: " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5150: Add multiple intro embed")
    @Test
    public void verifyAddMultipleIntroEmbed() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAddMultipleIntroEmbed", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
            String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
            isResult = liveBlogPage.checkAddMultipleIntroEmbed(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Multiple intro elements are not added: " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5151: Edit Intro Embed")
    @Test
    public void verifyEditIntroEmbed() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyEditIntroEmbed", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
            String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
            isResult = liveBlogPage.checkEditIntroEmbed(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "EditIntroEmbed functionality is not working properly: " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5152: Intro embed check in DB")
    @Test
    public void verifyIntroEmbedInDb() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyIntroEmbedInDb", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
            String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
            isResult = liveBlogPage.checkIntroEmbedInDb(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("EmbedText"));
            Assert.assertTrue(isResult, "IntroEmbed is not displaying in DB: " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5172: Verify that Live blog option is visible in Create Story drop down")
    @Test
    public void verifyLiveBlogOptionIsVisible() {
        boolean isResult;
        isResult = liveBlogPage.checkLiveBlogOptionIsVisible(this.property);
        Assert.assertTrue(isResult, "Live blog option is not visible in Create Story drop down: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5173: Verify that user is not able to Publish story without entering Headline")
    @Test
    public void verifyPublishStoryWithoutEnteringHeadline() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishStoryWithoutEnteringHeadline", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishStoryWithoutEnteringHeadline(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("ErrorMessage"));
        Assert.assertTrue(isResult, "validation message Headline cannot be Untitled Story is not displaying: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5174: Verify that user is not able to Publish story without selecting Lead Media")
    @Test
    public void verifyPublishStoryWithoutSelectingLeadMedia() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishStoryWithoutSelectingLeadMedia", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishStoryWithoutSelectingLeadMedia(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("ErrorMessage"));
        Assert.assertTrue(isResult, "validation message Add Lead Media is not displaying: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5192: Verify that user is not able to Publish story without Summary Field")
    @Test
    public void verifyPublishStoryWithoutSummaryField() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishStoryWithoutSummaryField", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishStoryWithoutSummaryField(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("ErrorMessage"));
        Assert.assertTrue(isResult, "validation message Fill Summary is not displaying: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5193: Verify that user is not able to Publish story without Section Field")
    @Test
    public void verifyPublishStoryWithoutSectionField() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishStoryWithoutSectionField", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        String section = "";
        String subSection = "Data not present" + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishStoryWithoutSectionField(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), section, subSection, paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("ErrorMessage"));
        Assert.assertTrue(isResult, "validation message Fill Section is not displaying: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5194: Verify that user is not able to Publish story without Sub Section Field")
    @Test
    public void verifyPublishStoryWithoutSubSectionField() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishStoryWithoutSubSectionField", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        String subSection = "Data not present" + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishStoryWithoutSubSectionField(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), subSection, paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("ErrorMessage"));
        Assert.assertTrue(isResult, "validation message Fill Sub Section is not displaying: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5195: Verify that user is not able to Publish story without Byline Field")
    @Test
    public void verifyPublishStoryWithoutBylineField() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishStoryWithoutBylineField", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        String byLine = paramsMap.get("byline") + commonFunctions.generateRandomNum()+"aw" + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishStoryWithoutBylineField(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, byLine, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("ErrorMessage"));
        Assert.assertTrue(isResult, "validation message Fill Byline is not displaying: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5196: Verify that user is not able to Publish story without Post")
    @Test
    public void verifyPublishStoryWithoutPost() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishStoryWithoutPost", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishStoryWithoutPost(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("ErrorMessage"));
        Assert.assertTrue(isResult, "validation message Please enter at least 1 post before Publishing is not displaying: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5197: Verify that user is able to Publish Live Blog")
    @Test
    public void verifyPublishLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishLiveBlog", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkPublishLiveBlog(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "User is not able to Publish Live Blog: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5198: Verify that URL is generated in Story Info section after publishing Live Blog")
    @Test
    public void verifyUrlIsGeneratedInStoryInfoSection() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUrlIsGeneratedInStoryInfoSection", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkUrlIsGeneratedInStoryInfoSection(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "URL is not generated in Story Info section after publishing Live Blog: " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5199: Verify that URL is generated in Story Info section after publishing Live Blog and clickable")
    @Test
    public void verifyUrlIsGeneratedInStoryInfoSectionIsClickable() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUrlIsGeneratedInStoryInfoSectionIsClickable", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String postTitle = paramsMap.get("postTitle") + commonFunctions.generateRandomNum()+"aw";
        String postBody = paramsMap.get("postBody") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkUrlIsGeneratedInStoryInfoSectionIsClickable(this.property, headLine, summary, paramsMap.get("paragraph"), postTitle, postBody, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "URL is not clickable, generated in Story Info section after publishing Live Blog: " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5294: verifyIfTheLiveUpdateRadioButtonAppearsOnFrontendAlongWithPublishedBlog")
    @Test
    public void verifyIfTheLiveUpdateRadioButtonAppearsOnFrontendAlongWithPublishedBlog() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyIfTheLiveUpdateRadioButtonAppearsOnFrontendAlongWithPublishedBlog", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkIfTheLiveUpdateRadioButtonAppearsOnFrontendAlongWithPublishedBlog(this.property, headLine, summary, paramsMap.get("paragraph"),paramsMap.get("title"),paramsMap.get("titleBody"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("leadMediaCaption"),paramsMap.get("postImageCaption"));
        Assert.assertTrue(isResult, "failed to verify if If The Live Update Radio Button Appears On Frontend Along With Published Blog for the tenant " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5295: Verify that above the Heading - End Live Blog button should appear in backend")
    @Test
    public void verifyThatAboveTheHeadingEndLiveBlogButtonShouldAppearInBackend() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatAboveTheHeadingEndLiveBlogButtonShouldAppearInBackend", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkIfTheHeadingEndLiveBlogButtonShouldAppearInBackend(this.property, headLine, summary, paramsMap.get("paragraph"),paramsMap.get("title"),paramsMap.get("titleBody"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("leadMediaCaption"),paramsMap.get("postImageCaption"));
        Assert.assertTrue(isResult, "failed to verify if the the live blog is present above the heading after publishing for the tenant " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5296," +
                       "5297: " +
                       "verifyThatEndLiveBlogButtonShouldBeClickableAndShowsCalendar")
    @Test
    public void verifyThatEndLiveBlogButtonShouldBeClickableAndShowsCalendar() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatEndLiveBlogButtonShouldBeClickableAndShowsCalendar", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkIfEndLiveBlogButtonIsBeClickableAndShowsCalendar(this.property, headLine, summary, paramsMap.get("paragraph"),paramsMap.get("title"),paramsMap.get("titleBody"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("leadMediaCaption"),paramsMap.get("postImageCaption"));
        Assert.assertTrue(isResult, "failed to verify liveblog button for the tenant: " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5298: verifyThatEndLiveBlogButtonShouldConvertIntoChangeEndTimeButtonOnceTimeIsSet")
    @Test
    public void verifyThatEndLiveBlogButtonShouldConvertIntoChangeEndTimeButtonOnceTimeIsSet() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatEndLiveBlogButtonShouldConvertIntoChangeEndTimeButtonOnceTimeIsSet", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkIfEndLiveBlogButtonConvertsIntoChangeEndTimeButtonOnceTimeIsSet(this.property, headLine, summary, paramsMap.get("paragraph"),paramsMap.get("title"),paramsMap.get("titleBody"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("leadMediaCaption"),paramsMap.get("postImageCaption"));
        Assert.assertTrue(isResult, "failed to check If End LiveBlog Button Converts Into Change EndTime Button Once Time Is Set for the tenant " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5299: VerifyThatEndLiveBlogButtonShouldConvertIntoTextAfterCertainTimeDurationAfterBlogEnds")
    @Test
    public void VerifyThatEndLiveBlogButtonShouldConvertIntoTextAfterCertainTimeDurationAfterBlogEnds() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("VerifyThatEndLiveBlogButtonShouldConvertIntoTextAfterCertainTimeDurationAfterBlogEnds", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkIfEndLiveBlogButtonConvertIntoTextAfterCertainTimeDurationAfterBlogEnds(this.property, headLine, summary, paramsMap.get("paragraph"),paramsMap.get("title"),paramsMap.get("titleBody"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("leadMediaCaption"),paramsMap.get("postImageCaption"));
        Assert.assertTrue(isResult, "failed to check If EndLiveBlog Button Convert Into Text After Certain Time Duration After Blog Ends for the tenant " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5300: verifyThatIfTheLiveUpdateRadioButtonIsAbleToDisappearFromThePostAfterGivenCertainTimeDurationOnFrontend")
    @Test
    public void verifyThatIfTheLiveUpdateRadioButtonIsAbleToDisappearFromThePostAfterGivenCertainTimeDurationOnFrontend() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatIfTheLiveUpdateRadioButtonIsAbleToDisappearFromThePostAfterGivenCertainTimeDurationOnFrontend", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkIfTheLiveUpdateRadioButtonIsAbleToDisappearFromThePostAfterGivenCertainTimeDurationOnFrontend(this.property, headLine, summary, paramsMap.get("paragraph"),paramsMap.get("title"),paramsMap.get("titleBody"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("leadMediaCaption"),paramsMap.get("postImageCaption"));
        Assert.assertTrue(isResult, "failed to check If The Live UpdateRadioButtonIsAbleToDisappear for the tenant " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5325: verifyThatUserIsAbleToCreateStoryLiveBlog")
    @Test
    public void verifyThatUserIsAbleToCreateStoryLiveBlog() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateStoryLiveBlog", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = liveBlogPage.checkIfUserIsAbleToCreateStoryLiveBlog(this.property, headLine, summary, paramsMap.get("paragraph"),paramsMap.get("title"),paramsMap.get("titleBody"),paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("leadMediaCaption"),paramsMap.get("postImageCaption"));
        Assert.assertTrue(isResult, "failed to verify if the the live blog is created and published for the tenant " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
        if(globalVars.isProdRun()) {
            dashboardPage.navigateToHomePageDashboard();
            dashboardPage.storyCleanup(LiveBlogPage.storyIdNumber);
        }
        else{
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
