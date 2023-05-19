package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonDeadLinkStoryPage;
import com.pages.BlankPaper.genericPages.CommonHighlightsPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.DeadLinkStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

public class DeadLinkStoryTest {
    private static CommonDashboardPage dashboardPage;
    private static CommonDeadLinkStoryPage deadLinkStoryPage;
    private static CommonHighlightsPage highlightsStoryPage;
    private static CommonFunctionsWeb commonFunctions;
    GlobalVars globalVars;
    String property ="";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property=property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        commonFunctions = CommonFunctionsWeb.getInstance();
        deadLinkStoryPage = CommonDeadLinkStoryPage.getInstance();
        highlightsStoryPage = CommonHighlightsPage.getInstance();
        dashboardPage = DashboardPage.getInstance();
        dashboardPage.domainSelection(property);
    }

    @BeforeMethod
    public void ensureHomePageVisibility(){
        dashboardPage.navigateToHomePageDashboard();
    }

    @Author(name = "Deepesh Saini")
    @Test(priority = -1)
    public void verifyDeadLinkStoryCreation() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDeadLinkStoryCreation", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyDeadLinkStoryPublishStatus() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDeadLinkStoryPublishStatus", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = deadLinkStoryPage.publishForDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Deadlink Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("PUBLISHED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyPurgeDeadLinkStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPurgeDeadLinkStory", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = deadLinkStoryPage.publishForDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Deadlink Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("PUBLISHED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        isResult = deadLinkStoryPage.purgeDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Deadlink Story is not purged : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyKillDeadLinkStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyKillDeadLinkStory", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = deadLinkStoryPage.publishForDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Deadlink Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("PUBLISHED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        isResult = deadLinkStoryPage.killDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Deadlink Story is not killed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, true, 0, false);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void checkChangeUrlDeadLinkStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("checkChangeUrlDeadLinkStory", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = deadLinkStoryPage.publishForDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("PUBLISHED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);

        isResult = deadLinkStoryPage.changeUrlDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Highlights Story url is not changed : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyDeadLinkStorySoftPublish() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDeadLinkStorySoftPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
            Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = deadLinkStoryPage.publishForDeadLinkAndVerify();
            Assert.assertTrue(isResult, "Highlights Story is not published : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("PUBLISHED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
            Assert.assertTrue(isResult, "PUBLISHED Data not verified from MongoDB : " + property);
        }

        isResult = deadLinkStoryPage.softPublishDeadLinkAndVerify();
        Assert.assertTrue(isResult, "Highlights Story is not soft published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), true, false, 0, false);
        Assert.assertTrue(isResult, "Soft Published Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyDiscardDeadLinkStory() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyDiscardDeadLinkStory", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
            Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = deadLinkStoryPage.discardDeadlinkAndVerify();
        Assert.assertTrue(isResult, "Deadlink Story is not discarded : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 1, false);
        Assert.assertTrue(isResult, "Discard Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyImageUploadAndImageCroppingDeadLinkStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyImageUploadAndImageCroppingDeadLinkStory", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        if(!globalVars.isProdRun()) {
            isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
            Assert.assertTrue(isResult, "DeadLink Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = deadLinkStoryPage.verifyUploadImageForDeadlinkStory();
        Assert.assertTrue(isResult, "Image is not uploaded : " + property);
        isResult = deadLinkStoryPage.verifyImageCroppingForDeadlinkStory();
        Assert.assertTrue(isResult, "Image is not cropped : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyDeadLinkStoryPagination() {
        boolean isResult;

        //TODO: to change this method to make it parametrized and call in different steps with different numbers
        //TODO: also to move this method to dashboard page class and remove from all the other page classes as it is redundant piece of code present in all page classes
        isResult = dashboardPage.verifyPagination();
        Assert.assertTrue(isResult, "Pagination is not varified : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifyMouseHoverOnLeftPanelDeadLink() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyLoginWithGoogle", property);

        isResult = deadLinkStoryPage.mouseHoverOnLeftPanelAndVerifyElementsAndUser(paramsMap.get("expectedUserName"));
        Assert.assertTrue(isResult, "Mouse hover is not verified : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-488: To verify delete")
    @Test
    public void verifyDeadLinkStoryDeleteContent() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDeadLinkStoryDeleteContent", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if(!globalVars.isProdRun()) {
            isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
            Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = deadLinkStoryPage.deleteDeadLinkContent();
        Assert.assertTrue(isResult, "Video Story content is not deleted : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, "", paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Delete Summary Data not verified from MongoDB : " + property);

    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-31: This test case will create a DeadLink story and verify the preview of story")
    @Test
    public void verifyPreviewOfMobileAndDesktopOnDeadLinkPage() {
        boolean isResult;

        Map<String, String> paramsMap = globalVars.getParamsData("verifyPreviewOfMobileAndDesktopOnDeadLinkPage", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult = deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        Assert.assertTrue(isResult, "DeadLink Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        //TODO: verify the headline text of mobile and desktop preview
        isResult = dashboardPage.mobileAndDesktopPreview(headLine);
        Assert.assertTrue(isResult, "preview functionality is not working : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-125 To verify story info fields like URL,format and word count")
    @Test
    public void verifyDeadLinkStoryURLAndFormat() {
        boolean isResult=true;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDeadLinkStoryURLAndFormat", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }

        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

        isResult &= deadLinkStoryPage.createDeadLinkAndVerify(headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        isResult &= dashboardPage.verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend("CREATED", DeadLinkStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"), false, false, 0, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult &= deadLinkStoryPage.validateDeadLinkURLAndFormat(paramsMap.get("url"));
        Assert.assertTrue(isResult, "Deadlink Story is not created : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3117 : Selected image should be uploaded for Deadlink")
    @Test
    public void verifySelectedImageShouldBeUploadedForDeadlink() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySelectedImageShouldBeUploadedForDeadlink", property);
        String head = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String sum = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = deadLinkStoryPage.checkSelectedImageShouldBeUploadedForDeadlink(head, sum, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("url"));
        Assert.assertTrue(isResult, "Selected image is not uploaded for Deadlink : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
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
            dashboardPage.storyCleanup(DeadLinkStoryPage.storyIdNumber);
        }
        else{
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
