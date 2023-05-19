package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonHighlightsPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.HighlightsPage;
import com.pages.BlankPaper.webdesktop.stories.StandardStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

public class HighlightsTest {
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonHighlightsPage highlightsPage;
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
    }

    @BeforeMethod
    public void ensureHomePageVisibility(){
        dashboardPage.navigateToHomePageDashboard();
    }

    @Author(name = "Deepesh Saini")
    @Test(priority = -1)
    public void verifyHighlightsCreation() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyHighlightsCreation", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyHighlightsEdit() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyHighlightsEdit", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.editHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not edited : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyPublishForHighlightsStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPublishForHighlightsStory", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyPurgeStoryForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPurgeStoryForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.verifyPurgeStory();
        Assert.assertTrue(isResult, "Highlights Story is not purged : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyKillStoryForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyKillStoryForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);


        isResult = highlightsPage.verifyKillStory();
        Assert.assertTrue(isResult, "Highlights Story is not killed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, true, 0, false);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void checkChangeUrlStoryForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("checkChangeUrlStoryForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.publishHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        isResult = highlightsPage.checkChangeUrl();
        Assert.assertTrue(isResult, "Highlights Story url is not changed : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifySoftPublishForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySoftPublishForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if(!globalVars.isProdRun()) {
            isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = highlightsPage.publishHighLightAndVerify();
            Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("PUBLISHED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
            Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);
        }

        isResult = highlightsPage.verifySoftPublish();
        Assert.assertTrue(isResult, "Highlights Story is not soft published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), true, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyMouseHoverOnLeftPanelHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLoginWithGoogle", property);
        isResult = highlightsPage.mouseHoverOnLeftPannelAndVerifyElementsAndUser(paramsMap.get("expectedUserName"));
        Assert.assertTrue(isResult, "Mouse hover is not verified : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyCustomHeadlineTextHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCustomHeadlineTextHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }
        isResult = highlightsPage.updateCustomHeadline(paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"), paramsMap.get("newsletterHeadline"));
        Assert.assertTrue(isResult, "Custom headline is not verified : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHeadinesOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"));
        Assert.assertTrue(isResult, "Updated Headlines Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyImageUploadForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyImageUploadForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = highlightsPage.verifyUploadImage();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyImageCroppingForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyImageCroppingForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = highlightsPage.verifyUploadImage();
        Assert.assertTrue(isResult, "Image upload is failed : " + property);

        isResult = highlightsPage.verifyImageCropping();
        Assert.assertTrue(isResult, "Image is not cropped : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyPaginationForHighlights() {
        boolean isResult;

        isResult = dashboardPage.verifyPagination();
        Assert.assertTrue(isResult, "Pagination is not verified : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyEditStoryContentForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyEditStoryContentForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.verifyEditStoryContent();
        Assert.assertTrue(isResult, "Highlights story is not edited : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, "", paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Edit Data not verified from MongoDB : " + property);
    }


    @Author(name = "Deepesh Saini")
    @Test
    public void verifyDiscardStoryForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDiscardStoryForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = highlightsPage.discardHighLightAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not discarded : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 1, false);
        Assert.assertTrue(isResult, "Disccard Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifySchedulePublishForHighlights() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySchedulePublishForHighlights", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = highlightsPage.scheduleHighLightAndVerify();
        Assert.assertTrue(isResult, "Scheduled publish is failed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, true);
        Assert.assertTrue(isResult, "Schedule Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-478: To verify delete")
    @Test
    public void verifyHighLightsStoryDeleteContent() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyHighLightsStoryDeleteContent", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = highlightsPage.createHighLight(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = highlightsPage.deleteHighlightContent();
        Assert.assertTrue(isResult, "Highlights Story content is not deleted : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHighlightsDetailsOnBackend("CREATED", HighlightsPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, "", paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), paramsMap.get("highlightsItem"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-4971: Verify that the user is able to create story (Highlights) with Live Hindustan Affiliate tenant")
    @Test
    public void verifyUserIsAbleToCreateHighlightsStoryWithLiveHindustanAffiliateTenant() {
        boolean isResult;
        if (this.property.equals("Live Hindustan Affiliate")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyUserIsAbleToCreateHighlightsStoryWithLiveHindustanAffiliateTenant", property);
            String heading = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum() + "aw";
            isResult = highlightsPage.checkHighlightsStoryWithLiveHindustanAffiliateTenant(this.property, heading, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Highlights Story is not created : " + property);
            isResult = highlightsPage.publishHighLightAndVerify();
            Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Hindustan Affiliate Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5328: Verify that user is able to Create Story (Highlights)")
    @Test
    public void verifyUserIsAbleToCreateHighlightsStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyUserIsAbleToCreateHighlightsStory", property);
        String heading = paramsMap.get("headline") + " "+commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " "+commonFunctions.generateRandomNum()+"aw";
        isResult = highlightsPage.checkIfUserAbleToCreateHighlightsStory(this.property, heading, summary, paramsMap.get("paragraph"), paramsMap.get("highlightsItem"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }
    @AfterTest
    public void cleanup(ITestContext context) {
        if(globalVars.isProdRun()) {
            dashboardPage.clickOnBlankPaperLogo();
            dashboardPage.storyCleanup(HighlightsPage.storyIdNumber);
        }
        else{
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
