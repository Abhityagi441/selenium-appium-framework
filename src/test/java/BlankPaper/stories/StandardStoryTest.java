package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonStandardStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.StandardStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.util.Map;
import java.util.Random;

import static com.pages.BlankPaper.genericPages.CommonStandardStoryPage.getInstance;

public class StandardStoryTest {
    private static CommonStandardStoryPage standardStoryPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        globalVars.setBpTenant(property);
        standardStoryPage = getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    public void ensureHomePageVisibility() {
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Deepesh Saini")
    @Test
    public void verifySearchTabOnTop() {
        Map<String, String> paramsMap = globalVars.getParamsData("verifySearchTabOnTop", property);
        boolean isResult = standardStoryPage.verifyKeywordSearchTabOnTop(paramsMap.get("searchKeyword"));
        Assert.assertTrue(isResult, "Search is not matched for keyword : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-8:")
    @Test(priority = -1)
    public void verifyStandardStoryCreation() {
        Map<String, String> paramsMap=globalVars.getParamsData("verifyStandardStoryCreation", property);
        boolean isResult = standardStoryPage.createStoryAndVerify(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000000);
        String headline = paramsMap.get("headline") + urlIndex+commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + urlIndex+commonFunctions.generateRandomNum()+"aw";

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-9:")
    @Test
    public void verifyStandardStoryEdit() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyStandardStoryEdit", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000000);
        String headline = paramsMap.get("headline") + urlIndex+commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + urlIndex+commonFunctions.generateRandomNum()+"aw";

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);

        isResult = standardStoryPage.editStoryAndVerify(paramsMap.get("editHeadline"));
        Assert.assertTrue(isResult, "Standard Story is not edited : " + property);

        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), paramsMap.get("editHeadline"), summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);
    }


    @Author(name = "Deepesh Saini")
    @Test
    public void verifyStandardStoryPublish() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyStandardStoryPublish", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000000);
        String headline = paramsMap.get("headline") + urlIndex+commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + urlIndex+commonFunctions.generateRandomNum()+"aw";

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline,summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-22:")
    @Test
    public void verifyPurgeStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPurgeStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);

        isResult = standardStoryPage.purgeStoryAndVerify();
        Assert.assertTrue(isResult, "Story is not purged : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-59:")
    @Test
    public void verifySoftPublish() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySoftPublish", property);
        String headLine = null;
        String summary = null;

        if (!globalVars.isProdRun()) {
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
            summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);
        }

        isResult = standardStoryPage.softPublishAndVerify();
        Assert.assertTrue(isResult, "Standard Story is not soft published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), true, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-80:")
    @Test
    public void verifyChangeUrlOnStandardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyChangeUrlOnStandardStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);

        String changeUrl = paramsMap.get("UrlHeadline") + commonFunctions.generateRandomNum();
        isResult = standardStoryPage.checkChangeUrl(changeUrl);
        Assert.assertTrue(isResult, "Story url is not changed : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-101")
    @Test
    public void verifyKillStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyKillStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);

        isResult = standardStoryPage.killStoryAndVerify();
        Assert.assertTrue(isResult, "Story is not killed : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, true);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-468:")
    @Test
    public void verifyMouseHoverOnLeftPanel() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyLoginWithGoogle", property);

        isResult = standardStoryPage.mouseHoverOnLeftPannelAndVerifyElementsAndUser(paramsMap.get("expectedUserName"));
        Assert.assertTrue(isResult, "Mouse hover is not verified : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-469:")
    @Test
    public void verifyCustomHeadlineTextStandardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyCustomHeadlineTextStandardStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if (!globalVars.isProdRun()) {
            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = standardStoryPage.updateCustomHeadline(paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"), paramsMap.get("newsletterHeadline"), this.property);
        Assert.assertTrue(isResult, "Coustom headline is not verified : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHeadinesOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"));
        Assert.assertTrue(isResult, "Updated Headlines Data not verified from MongoDB : " + property);

    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-15:")
    @Test
    public void verifySchedulePublishStandardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySchedulePublishStandardStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        isResult = standardStoryPage.schedulePublishAndVerify();
        Assert.assertTrue(isResult, "Schedule publish is failed : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-78: To verify scrolling function with pagaination hits on console")
    @Test
    public void verifyPaginationStandardStory() {
        boolean isResult;
        isResult = dashboardPage.verifyPagination();
        Assert.assertTrue(isResult, "Pagination is not verified : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-261: To verify scrolling function with pagination hits on console")
    @Test
    public void verifyUploadMultipleImagesStandardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUploadMultipleImagesStandardStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if (!globalVars.isProdRun()) {
            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }
        isResult = standardStoryPage.verifyUploadMultipleImages();
        Assert.assertTrue(isResult, "Image is not uploaded: " + property);
        commonFunctions.hardWait(10000);//We have given this wait because without this wait an unwanted js pop up is displaying and because of this others test cases are skipping.
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-94:")
    @Test
    public void verifyDeleteStoryContent() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyDeleteStoryContent", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if (!globalVars.isProdRun()) {
            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = standardStoryPage.deleteStoryContentAndVerify();
        Assert.assertTrue(isResult, "Story content is not deleted : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-24:")
    @Test
    public void verifyDragAndDropFeatureStandardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyDragAndDropFeatureStandardStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if (!globalVars.isProdRun()) {
            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        //TODO: embed url is still hardcoded inside verifyInsertEmbed() method, need to take this from test data sheet
        isResult = standardStoryPage.verifyInsertEmbed();
        Assert.assertTrue(isResult, "Embed is not uploaded : " + property);

        isResult = standardStoryPage.verifyInsertRelatedStory();
        Assert.assertTrue(isResult, "Related story id not uploaded : " + property);

        //TODO: after drag and drop verification is missing
        isResult = standardStoryPage.verifyDragAndDrop();
        Assert.assertTrue(isResult, "Related story id not uploaded : " + property);
    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-9:")
    @Test
    public void verifyEditStoryContent() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyEditStoryContent", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        headLine = headLine + " " + commonFunctions.generateRandomNum()+"aw";
        summary = summary + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkEditStory(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Story content is not edited : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Edited Data not verified from MongoDB : " + property);


    }

    @Author(name = "Deepesh Saini")
    @Description("QAAUT-16:")
    @Test
    public void verifyDiscardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyDiscardStory", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        if (!globalVars.isProdRun()) {
            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }
        isResult = standardStoryPage.discardStoryAndVerify();
        Assert.assertTrue(isResult, "Story is not discarded : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data is verified from MongoDB : " + property);

    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-92: This test case will create a standard story and verify the preview of story")
    @Test
    public void verifyPreviewOfMobileAndDesktopOnStandardStoryPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPreviewOfMobileAndDesktopOnStandardStoryPage", property);
        String headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        //TODO: verify the headline text of mobile and desktop preview
        isResult = dashboardPage.mobileAndDesktopPreview(paramsMap.get("headline"));
        Assert.assertTrue(isResult, "preview functionality is not working : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1381 ,1397: This test case will create a standard story and verify in line elements")
    @Test
    public void verifyStandardStoryCreationWithAllInlineElementsWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStandardStoryCreationWithAllInlineElementsWithUi", property);
        String headLine;

        if (this.property.equals("Live Mint") || this.property.equals("Bangla")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.createStoryWithAllInLineElements(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("embedUrl"), paramsMap.get("companyName"), paramsMap.get("tableInputData"), paramsMap.get("imageCaption"), this.property);
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = standardStoryPage.changeUrlAndPublishStory(paramsMap.get("urlHeadline"), this.property);
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);

            //TODO:: Frontend for Bangla tenants is Partially verified due to unstability of elements on FE
            isResult = commonFrontEndPage.dataValidationStandardStoryWithAllInLineEmbedOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), StandardStoryPage.storyIdNumber, paramsMap.get("srcEmbed"), StandardStoryPage.imageSrcValue, paramsMap.get("imageCaption"), paramsMap.get("tableInputData"), paramsMap.get("companyName"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story data not verified On FrontEnd : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1384 ,1580: This test case will create a standard story and verify paragraph with in line embed")
    @Test
    public void verifyParagraphScenariosWithStoryBodyWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyParagraphScenariosWithStoryBodyWithUi", property);

        if (this.property.equals("Live Mint") || this.property.equals("Bangla")) {
            isResult = standardStoryPage.createStandardStoryWithAddingInLineEmbedInBetweenParagraph(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("firstParagraphData"), paramsMap.get("secondParagraphData"), paramsMap.get("embedUrl"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("topic"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "Create Story With inLine Embed Verification Fail !!!!!! : " + property);

            isResult = standardStoryPage.changeUrlAndPublishStory(paramsMap.get("urlHeadline"), this.property);
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);

            //TODO: Bangla tenants frontend showing an error massage, hence we can't validate
            isResult = commonFrontEndPage.dataValidationStandardStoryParagraphWithInLineEmbedOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("firstParagraphData"), paramsMap.get("secondParagraphData"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), StandardStoryPage.storyIdNumber, paramsMap.get("srcEmbed"));
            Assert.assertTrue(isResult, "Standard Story data not verified On FrontEnd : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1386,1581: This test case will create a standard story and verify last verify info of published story")
    @Test
    public void verifyLastModifiedInfoOfAnyStandardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyLastModifiedInfoOfAnyStandardStory", property);

        if (this.property.equals("Live Mint") || this.property.equals("Bangla")) {
            isResult = standardStoryPage.selectPublishedStoryAndVerifyLastModifiedInfo(paramsMap.get("userIdG"), paramsMap.get("passwordG"), paramsMap.get("expectedUserNameG"), paramsMap.get("userIdQA"), paramsMap.get("passQA"), paramsMap.get("eUserNameQA"), paramsMap.get("storyType"), paramsMap.get("newHeadline"), paramsMap.get("createdBy"), this.property);
            Assert.assertTrue(isResult, "Last modified info verification Fail !!!!!! : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1582: This test case will create a standard story and publish it and verify metadata values on Frontend")
    @Test
    public void verifyStandardStoryMetaDataValuesWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStandardStoryMetaDataValuesWithUi", property);
        String headLine;

        if (this.property.equals("Bangla")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = standardStoryPage.metaDataValues(headLine, summary);
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);

            isResult = standardStoryPage.changeUrlAndPublishStory(paramsMap.get("urlHeadline"), this.property);
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);

            //TODO: Bangla tenants frontend showing an error massage, hence we can't validate the FE part

        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Lav Kumar")
    @Description("QAAUT-3029: This test case will create a standard story and enable the Editors pick toggle button")
    @Test
    public void verifyStandardStoryEditorMetaDataValues() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStandardStoryEditorMetaDataValues", property);
        String headLine;

        if (this.property.equals("Auto") || this.property.equals("Tech")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = standardStoryPage.EditorMetaDataValues(headLine, summary);
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");

        }
    }

    @Author(name = "Lav Kumar")
    @Description("QAAUT-3075 and 3074: This test case will create a standard story and enable the Blog toggle button")
    @Test
    public void verifyStandardStoryBlogMetaDataValues() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStandardStoryBlogMetaDataValues", property);
        String headLine;

        if (this.property.equals("Tech")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }
            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = standardStoryPage.BlogMetaDataValues(headLine, summary);
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");

        }
    }

    @Author(name = "Divya Lakhera")
    @Description("QAAUT-3066: This test case will create a standard story and enable the Premium toggle button")
    @Test
    public void verifyStandardStoryPremiumMetaDataValues() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStandardStoryPremiumMetaDataValues", property);
        String headLine;

        if (this.property.equals("Live Mint")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

            isResult = standardStoryPage.createStoryAndVerify(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = standardStoryPage.PremiumMetaDataValues(headLine, summary);
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");

        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3067:Verify that user can add lead image for video tasks")
    @Test
    public void verifyThatUserCanAddLeadImageForVideoTasks() {
        if (this.property.equals("HT NEW")) {
            boolean isResult;
            isResult = standardStoryPage.verifyThatUserCanAddLeadImageForVideoTasks();
            Assert.assertTrue(isResult, "user can not add lead image for video tasks" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3116:Username to be shown with each version")
    @Test
    public void verifyUsernameToBeShownWithEachVersion() {
        if (this.property.equals("HT NEW")) {
            boolean isResult;
            Map<String, String> paramsMap = globalVars.getParamsData("verifyUsernameToBeShownWithEachVersion", property);
            isResult = standardStoryPage.checkUsernameToBeShownWithEachVersion(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("loggedUserName"));
            Assert.assertTrue(isResult, "user name is not showing with each version" + property);
        }else {
        Utils.logStepInfo("Test case is not valid for this Domain!!!");
    }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3124:Resize images in 4:3 Aspect ratio")
    @Test
    public void verifyResizeImagesInFourAndThreeAspectRatio() {
        if (this.property.equals("Tech")) {
            boolean isResult;
            isResult = standardStoryPage.checkResizeImagesInFourAndThreeAspectRatio();
            Assert.assertTrue(isResult, "Resize images in 4:3 Aspect ratio is not displaying" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3134:Related Stories section to show How To type selected by default")
    @Test
    public void VerifyThatUserCanSelectOneOrMultipleStoriesFromTheListOfStories() {
        if (this.property.equals("Tech")) {
            boolean isResult;
            isResult = standardStoryPage.checkThatUserCanSelectOneOrMultipleStoriesFromTheListOfStories();
            Assert.assertTrue(isResult, "Related Story section multi selection functionality not working properly" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3099:Verify that whatever data we are providing in landing page headline on stadard story the same data is present in metatitle or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInLandingPageHeadlineOnStadardStoryTheSameDataIsPresentInMetatitleOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = standardStoryPage.checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnStadardStoryTheSameDataIsPresentInMetatitleOrNot();
        Assert.assertTrue(isResult, "Whatever data we are providing in landing page headline on stadard story the same data is not present in metatitle" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3110:Verify that whatever data we are providing in summary of standard story the same data is present in metadescription or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInSummaryOfStandardStoryTheSameDataIsPresentInMetadescriptionOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = standardStoryPage.checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription();
        Assert.assertTrue(isResult, "Whatever data we are providing in summary of standard story the same data is not present in metadescription" + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3140:Verify that after publishing the story with metatitle and meta description on standard story the complete data goes to master db")
    @Test
    public void verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnStandardStoryTheCompleteDataGoesToMasterDb() {
        boolean isResult;

        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnStandardStoryTheCompleteDataGoesToMasterDb", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkThatStandardStoryDataGoesToMasterDb(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "After publishing the story with metatitle and meta description on standard story the complete data does not go to master db" + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3118:Verify that user can edit disclaimer")
    @Test
    public void verifyThatUserCanEditDisclaimer() {
        boolean isResult;

        if (this.property.equals("Tech")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserCanEditDisclaimer", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String disclaimer = "Automation Testing Disclaimer "+commonFunctions.generateRandomNum();
            isResult = standardStoryPage.checkThatUserCanEditDisclaimer(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), disclaimer);
            Assert.assertTrue(isResult, "User can not edit disclaimer" + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3125:Podcast carousel should be present")
    @Test
    public void verifyPodcastCarouselShouldBePresent() {
        boolean isResult;
        if (this.property.equals("Live Mint")) {
            isResult = standardStoryPage.checkPodcastCarouselShouldBePresent();
            Assert.assertTrue(isResult, "Podcast carousel is not present: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3126:Podcast should be added to the story successfully")
    @Test
    public void verifyPodcastShouldBeAddedToTheStory() {
        boolean isResult;
        if (this.property.equals("Live Mint")) {
            isResult = standardStoryPage.checkPodcastShouldBeAddedToTheStory();
            Assert.assertTrue(isResult, "Podcast is not added to the story: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3132:Icon for 'Insert how to story' should be present in the inline elements")
    @Test
    public void verifyIconInsertHowToStoryShouldBePresentInTheInlineElements() {
        boolean isResult;

        if (this.property.equals("Auto") || this.property.equals("Tech")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyIconInsertHowToStoryShouldBePresentInTheInlineElements", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkIconInsertHowToStoryPresentInTheInlineElements(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Icon for 'Insert how to story' is not present in the inline elements: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3133:All how to stories should be displayed in listing")
    @Test
    public void verifyAllHowToStoriesShouldBeDisplayedInListing() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAllHowToStoriesShouldBeDisplayedInListing", property);
        if (this.property.equals("Auto") || this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkAllHowToStoriesDisplayedInListing(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "All how to stories are not displayed in listing: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3135:User should be able to add how to story")
    @Test
    public void verifyUserShouldBeAbleToAddHowToStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserShouldBeAbleToAddHowToStory", property);
        if (this.property.equals("Auto") || this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkUserShouldBeAbleToAddHowToStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "User is not able to add how to story: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }


    @Author(name = "Lav Kumar Singh")
    @Description("QAAUT-3071: This test case will verify the alert for story with same headline and summary")
    @Test
    public void verifyAlertForSameStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAlertForSameStory", property);
        String headLine;
        if (this.property.equals("HT NEW")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";

            isResult = standardStoryPage.createStoryAndVerify(headLine.trim(), summary.trim(), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);

            isResult = standardStoryPage.createStoryAndVerify(headLine.trim(), summary.trim(), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);


            isResult = standardStoryPage.StoryMatchPopup(headLine.trim(), summary.trim());
            Assert.assertTrue(isResult, "Story Matching validation message not found : " + property);
        } else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");

        }

        }

    @Author(name = "Raj")
    @Description("QAAUT-3131:Text boxes with headers H2 and H3 should be present")
    @Test
    public void verifyTextBoxesWithHeadersH2AndH3() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyTextBoxesWithHeadersH2AndH3", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkTextBoxesWithHeadersH2AndH3(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Text boxes with headers H2 and H3 are not present: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4911:Verify that the user is able to create story (Standard)")
    @Test
    public void verifyThatTheUserIsAbleToCreateStandardStoryWithHindustanAffiliateTenant () {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheUserIsAbleToCreateStandardStoryWithHindustanAffiliateTenant", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.verifyUserCanCreateStandardStoryWithHindustanAffiliateTenant(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "User is not able to create story (Standard): " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4988:Verify Quick read max and Min limit for automated quick read")
    @Test
    public void verifyQuickReadMaxAndMinLimitForAutomatedQuickRead() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyQuickReadMaxAndMinLimitForAutomatedQuickRead", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkQuickReadMaxAndMinLimitForAutomatedQuickRead(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("oneWord"), paramsMap.get("fourtyNineWord"), paramsMap.get("fiftyWord"), paramsMap.get("hundredWord"), paramsMap.get("hundredAndOneWord"));
            Assert.assertTrue(isResult, "Quick read max and Min limit is not working as expected : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4986: Verify Quick read minimum limit 50")
    @Test
    public void verifyQuickReadMinimumLimitFifty() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyQuickReadMinimumLimitFifty", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkQuickReadMinimumLimitFifty(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("fourtyNineWord"));
            Assert.assertTrue(isResult, "Quick read minimum limit 50 is not working as expected : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4987: Verify Quick read maximum limit 100")
    @Test
    public void verifyQuickReadMaximumLimitHundred() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyQuickReadMaximumLimitHundred", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkQuickReadMaximumLimitHundred(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("hundredAndOneWord"));
            Assert.assertTrue(isResult, "Quick read maximum limit 100 is not working as expected : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3152: verify recipe icon on inline element bar")
    @Test
    public void verifyRecipeIconOnInlineElementBar() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyRecipeIconOnInlineElementBar", property);
        isResult = standardStoryPage.checkRecipeIconOnInlineElementBar(this.property, paramsMap.get("paragraph"));
        Assert.assertTrue(isResult, "Recipe icon is not available on inline element bar : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3153: verify mandatory field validation for recipe")
    @Test
    public void verifyMandatoryFieldValidationForRecipe() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyMandatoryFieldValidationForRecipe", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String recipeName = paramsMap.get("recipeName") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkMandatoryFieldValidationForRecipe(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), recipeName, paramsMap.get("stepInformation"), paramsMap.get("nameErrorMsg"), paramsMap.get("stepErrorMsg"));
        Assert.assertTrue(isResult, "Mandatory field validation for recipe is not proper : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3154: verify element saving for recipe")
    @Test
    public void verifyElementSavingForRecipe() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyElementSavingForRecipe", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String recipeName = paramsMap.get("recipeName") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkElementSavingForRecipe(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), recipeName, paramsMap.get("stepInformation"), paramsMap.get("recipeDescription"), paramsMap.get("recipeYield"), paramsMap.get("recipePreparationHour"), paramsMap.get("recipePreparationMinute"), paramsMap.get("recipeCookingHour"), paramsMap.get("recipeCookingMinute"), paramsMap.get("recipeTotalHour"), paramsMap.get("recipeTotalMinute"), paramsMap.get("recipeIngredients"), paramsMap.get("recipeCuisine"), paramsMap.get("recipeCategory"), paramsMap.get("recipeKeywords"));
        Assert.assertTrue(isResult, "Elements are not saving for recipe : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3155: verify changes are saving for recipe")
    @Test
    public void verifyChangesAreSavingForRecipe() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyChangesAreSavingForRecipe", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        String recipeName = paramsMap.get("recipeName") + commonFunctions.generateRandomNum()+"aw";
        String recipeUpdateName = paramsMap.get("recipeName") + commonFunctions.generateRandomNum()+"aw";
        String recipeUpdateDesc = paramsMap.get("recipeDescription") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkChangesAreSavingForRecipe(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), recipeName, paramsMap.get("stepInformation"), paramsMap.get("recipeDescription"), paramsMap.get("recipeYield"), paramsMap.get("recipePreparationHour"), paramsMap.get("recipePreparationMinute"), paramsMap.get("recipeCookingHour"), paramsMap.get("recipeCookingMinute"), paramsMap.get("recipeTotalHour"), paramsMap.get("recipeTotalMinute"), paramsMap.get("recipeIngredients"), paramsMap.get("recipeCuisine"), paramsMap.get("recipeCategory"), paramsMap.get("recipeKeywords"), recipeUpdateName, recipeUpdateDesc);
        Assert.assertTrue(isResult, "Updated elements are not saving for recipe : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5035: Verify that Send Notification link is clickable")
    @Test
    public void verifySendNotificationLinkIsClickable() {
        if(!this.property.equals("Smart 24")) {
            boolean isResult;
            Map<String, String> paramsMap = globalVars.getParamsData("verifySendNotificationLinkIsClickable", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkSendNotificationLinkIsClickable(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Send Notification link is not clickable : " + property);
        }
        else Utils.logStepInfo(true, "Test case is not valid for this Domain!!!"+property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3085: Validate photo uploaded or not")
    @Test
    public void verifyPhotoUploaded() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPhotoUploaded", property);
        if (this.property.equals("Auto")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkPhotoUploaded(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Photos are not uploaded : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5032: Verify that user is able to Create Story")
    @Test
    public void verifyUserIsAbleToCreateStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserIsAbleToCreateStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkUserIsAbleToCreateStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "User is not able to Create Story: " + property);

    }

    @Author(name = "Raj")
    @Description("QAAUT-5033: Verify that Social Notification section is present in Create Story form")
    @Test
    public void verifySocialNotificationSectionIsPresentInCreateStoryForm() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint")) {
            isResult = standardStoryPage.checkSocialNotificationSectionIsPresent(this.property);
            Assert.assertTrue(isResult, "Social Notification section is not present in Create Story form: " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW and Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5034: Send Notification link should be present in Social Notification section")
    @Test
    public void verifySendNotificationLinkShouldBePresentInSocialNotificationSection() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifySendNotificationLinkShouldBePresentInSocialNotificationSection", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkSendNotificationLinkPresence(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Send Notification link is not Present : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW and Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5036: Verify that on clicking Send Notification link popup should open")
    @Test
    public void verifyClickingSendNotificationLinkPopupShouldOpen() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyClickingSendNotificationLinkPopupShouldOpen", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkSendNotificationPopupShouldOpen(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Send Notification Pop Up is not Opening : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW and Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5037: Verify that Send Notification popup have Image Url field")
    @Test
    public void verifySendNotificationPopupHaveImageUrlField() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifySendNotificationPopupHaveImageUrlField", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkSendNotificationPopupHaveImageUrlField(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Send Notification popup does not have Image Url field : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW and Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5038: Verify that Image Url field should not be kept empty")
    @Test
    public void verifyImageUrlFieldShouldNotBeKeptEmpty() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyImageUrlFieldShouldNotBeKeptEmpty", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkImageUrlFieldShouldNotBeKeptEmpty(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Image Url field is empty : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW and Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5039: Verify Send & Cancel button on Send Notification popup")
    @Test
    public void verifySendAndCancelButtonOnSendNotificationPopup() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifySendAndCancelButtonOnSendNotificationPopup", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkSendAndCancelButtonOnSendNotificationPopup(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Send & Cancel button is not present on Send Notification popup : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW and Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5040: Verify that Send button is working")
    @Test
    public void verifySendButtonIsWorking() {
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifySendButtonIsWorking", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkSendButtonIsWorking(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Send button is not working : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW and Live Mint Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("QAAUT-3086: Option to add Photo stories on pictures")
    @Test
    public void verifyAddPhotoStoriesButtonOnPictures() {
        boolean isResult;
        if (this.property.equals("Auto")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyAddPhotoStoriesButtonOnPictures", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkAddPhotoStoriesButtonIsAvailable(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "add/replace related stories button is not available : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Auto Domain!!! but currently selected domain is "+ property);

    }
    @Author(name = "Raj")
    @Description("QAAUT-5009: Verify that user can select the desired story to hyperlink from the list of related stories available")
    @Test
    public void verifyUserCanSelectTheDesiredStoryToHyperlink() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserCanSelectTheDesiredStoryToHyperlink", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkUserCanSelectDesiredStoryToHyperlink(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "User can not select the desired story to hyperlink from the list of related stories available : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5007: Verify Hyperlink Story text icon should be displayed")
    @Test
    public void verifyHyperlinkStoryTextIconShouldBeDisplayed() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyHyperlinkStoryTextIconShouldBeDisplayed", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkHyperlinkStoryTextIcon(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Hyperlink Story text icon is not displaying : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5008: Verify the action on click of Hyperlink story text icon")
    @Test
    public void verifyTheActionOnClickOfHyperlinkStoryTextIcon() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyTheActionOnClickOfHyperlinkStoryTextIcon", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkActionOnClickOfHyperlinkStoryTextIcon(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Stories related to the hyperlinked text is not displaying from the search results of dashboard : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5012: Verify that proper message is displayed if there is no matching data for hyperlinked text")
    @Test
    public void verifyProperValidationMessageIfNoMatchingDataForHyperlinkedText() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyProperValidationMessageIfNoMatchingDataForHyperlinkedText", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String paraTextNoMatching = "TextNoMatching"+commonFunctions.generateRandomNum()+commonFunctions.generateRandomNum();
            isResult = standardStoryPage.checkProperValidationMessageIfNoMatchingData(this.property, headLine, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paraTextNoMatching, paramsMap.get("expValidationMessage"));
            Assert.assertTrue(isResult, "Proper message is not displaying for no matching data for hyperlinked text : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5013: Verify that user can select more than one words to hyperlink")
    @Test
    public void verifyUserCanSelectMoreThanOneWordsToHyperlink() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserCanSelectMoreThanOneWordsToHyperlink", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String paragraph = paramsMap.get("paragraph");
            isResult = standardStoryPage.checkUserCanSelectMoreThanOneWordsToHyperlink(this.property, headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "User can not select more than one words to hyperlink : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5011: Verify that the words hyperlinked are redirected to the right story")
    @Test
    public void verifyWordsHyperlinkedAreRedirectedToTheRightStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyWordsHyperlinkedAreRedirectedToTheRightStory", property);
        if (this.property.equals("Live Mint")) {
            String paraText = "Automation12345"+commonFunctions.generateRandomNum()+commonFunctions.generateRandomNum();
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String paragraph = paramsMap.get("paragraph") +" "+ paraText + " " + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkWordsHyperlinkedAreRedirectedToTheRightStory(this.property, headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paraText);
            Assert.assertTrue(isResult, "Words hyperlinked are not redirecting to the right story : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5015: Verify that once hyperlinked , user can edit the hyperlink")
    @Test
    public void verifyOnceHyperlinkedUserCanEditTheHyperlink() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyOnceHyperlinkedUserCanEditTheHyperlink", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkOnceHyperlinkedUserCanEditTheHyperlink(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("url"));
            Assert.assertTrue(isResult, "Once hyperlinked , user can not edit the hyperlink : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5016: Verify that user can unlink the hyperlinked word")
    @Test
    public void verifyUserCanUnlinkTheHyperlinkedWord() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserCanUnlinkTheHyperlinkedWord", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkUserCanUnlinkTheHyperlinkedWord(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "User can not unlink the hyperlinked word : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5041: Verify that Cancel button should be working")
    @Test
    public void verifyCancelButtonIsWorking() {
        boolean isResult;
        if (this.property.equals("Live Mint") || this.property.equals("HT NEW")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyCancelButtonIsWorking", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkCancelButtonIsWorking(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Cancel button is not working : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Mint & HT NEW Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5042: Verify that Notification Bell icon is present on Dashboard")
    @Test
    public void verifyNotificationBellIconIsPresentOnDashboard() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyNotificationBellIconIsPresentOnDashboard", property);
        if (this.property.equals("Live Mint") || this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkNotificationBellIconIsPresentOnDashboard(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Notification Bell icon is not present on Dashboard : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5058: Verify that image uploaded for one tenant is visible in other tenants as well under cross tenant tab")
    @Test
    public void verifyImageUploadedForOneTenantIsVisibleInOtherTenantUnderCrossTenantTab() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyImageUploadedForOneTenantIsVisibleInOtherTenantUnderCrossTenantTab", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkImageUploadedForOneTenantIsVisibleInOtherTenant(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("OtherTenent"));
            Assert.assertTrue(isResult, "Image uploaded for one tenant is not visible in other tenants under cross tenant tab : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5069: Verify that user can upload lead image from cross tenant tab")
    @Test
    public void verifyUploadImageDisplayedUnderCrossDomainTab() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUploadImageDisplayedUnderCrossDomainTab", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkUploadImageDisplayedUnderCrossDomainTab(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("OtherTenent"), paramsMap.get("OtherByLine"));
            Assert.assertTrue(isResult, "User can not upload the image displayed under cross domain tab : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5068: Verify that user can upload the image displayed under cross domain tab from inline element")
    @Test
    public void verifyUploadImageDisplayedUnderCrossDomainTabFromInline() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUploadImageDisplayedUnderCrossDomainTabFromInline", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkUploadImageDisplayedUnderCrossDomainTabFromInline(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("OtherTenent"), paramsMap.get("OtherByLine"));
            Assert.assertTrue(isResult, "User can not upload the image displayed under cross domain tab from inline element : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5070: The image if uploaded once for a story , should be displayed in internal tab for that particular tenant")
    @Test
    public void verifyUploadedImageShouldBeDisplayedInInternalTab() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUploadedImageShouldBeDisplayedInInternalTab", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkUploadedImageShouldBeDisplayedInInternalTab(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("ImgSrc"));
            Assert.assertTrue(isResult, "Uploaded image once for a story , is not displaying in internal tab for that particular tenant : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3088: Verify story headline is showing or not")
    @Test
    public void verifyRelatedStoryHeadline() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyRelatedStoryHeadline", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkRelatedStoryHeadline(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Related story headline is not showing : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5140: Verify that H button is present while Creating Story (Standard) in Paragraph section")
    @Test
    public void verifyHButtonPresentWhileCreatingStandardStoryInParagraphSection() {
        boolean isResult;
        isResult = standardStoryPage.checkHButtonPresentWhileCreatingStandardStory(this.property);
        Assert.assertTrue(isResult, "H button is not present while Creating Story (Standard) in Paragraph section : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5141: Verify that H button has 3 options: a. Headline 2 b. Headline 3 c. Paragraph")
    @Test
    public void verifyHButtonHasThreeOptionsForParagraph() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyHButtonHasThreeOptionsForParagraph", property);
        isResult = standardStoryPage.checkHButtonHasThreeOptionsForParagraph(this.property, paramsMap.get("ParaOne"), paramsMap.get("ParaTwo"), paramsMap.get("ParaThree"));
        Assert.assertTrue(isResult, "H button does not has 3 options: a. Headline 2 b. Headline 3 c. Paragraph : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5142: Verify that 3 options should be selectable For Paragraph")
    @Test
    public void verifyHButtonOptionsAreSelectable() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyHButtonOptionsAreSelectable", property);
        isResult = standardStoryPage.checkHButtonOptionsAreSelectable(this.property, paramsMap.get("ParaOne"), paramsMap.get("ParaTwo"), paramsMap.get("ParaThree"));
        Assert.assertTrue(isResult, "H button options are not selectable For Paragraph : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3069: Add and Verify City Filter in Dashboard")
    @Test
    public void verifyCityFilterInDashboard() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyCityFilterInDashboard", property);
        if (this.property.equals("Smart 24")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkCityFilterInDashboard(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "City Filter in Dashboard is not working : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5144: Verify that hovering mouse on (Paragraph, Headline 2, Headline 3) options, background color should be grey")
    @Test
    public void verifyHoveringMouseOnOptionsBackgroundColorShouldBeGrey() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyHoveringMouseOnOptionsBackgroundColorShouldBeGrey", property);
        isResult = standardStoryPage.checkHoveringMouseOnOptionsBackColorShouldBeGrey(this.property, paramsMap.get("HoverColor"));
        Assert.assertTrue(isResult, "Hovering mouse on (Paragraph, Headline 2, Headline 3) options, background color is not grey : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5145: Verify that selecting on (Paragraph, Headline 2, Headline 3), background color should be blue")
    @Test
    public void verifySelectingOnOptionsBackgroundColorShouldBlue() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectingOnOptionsBackgroundColorShouldBlue", property);
        isResult = standardStoryPage.checkSelectingOnOptionsBackgroundColorShouldBlue(this.property, paramsMap.get("SelectingColor"));
        Assert.assertTrue(isResult, "Selecting on (Paragraph, Headline 2, Headline 3) options, background color is not blue : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5146: Verify that selecting on (Paragraph, Headline 2, Headline 3), paragraph should be changed accordingly")
    @Test
    public void verifySelectingOnOptionsParagraphShouldBeChangedAccordingly() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectingOnOptionsParagraphShouldBeChangedAccordingly", property);
        isResult = standardStoryPage.checkOptionsParagraphShouldBeChangedAccordingly(this.property, paramsMap.get("paragraph"));
        Assert.assertTrue(isResult, "Selecting on (Paragraph, Headline 2, Headline 3) options, paragraph is not changing accordingly : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5147: Verify that sentences should be displayed in form of Headline 2 after selecting the Headline 2 option")
    @Test
    public void verifySelectingOnHeadingTwoSentencesShouldBeDisplayedInFormOfHeadlineTwo() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectingOnHeadingTwoSentencesShouldBeDisplayedInFormOfHeadlineTwo", property);
        isResult = standardStoryPage.checkSentencesIsDisplayedInFormOfHeadlineTwo(this.property, paramsMap.get("Headline"), paramsMap.get("Summary"), paramsMap.get("Paragraph"));
        Assert.assertTrue(isResult, "Sentences is not displaying in form of Headline 2 after selecting the Headline 2 option : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5148: Verify that sentences should be displayed in form of Headline 3 after selecting the Headline 3 option")
    @Test
    public void verifySelectingOnHeadingThreeSentencesShouldBeDisplayedInFormOfHeadlineThree() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectingOnHeadingThreeSentencesShouldBeDisplayedInFormOfHeadlineThree", property);
        isResult = standardStoryPage.checkSentencesIsDisplayedInFormOfHeadlineThree(this.property, paramsMap.get("Headline"), paramsMap.get("Summary"), paramsMap.get("Paragraph"));
        Assert.assertTrue(isResult, "Sentences is not displaying in form of Headline 3 after selecting the Headline 3 option : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3031: Verify video and image is added or not")
    @Test
    public void verifyVideoAndImageAreAdded() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            isResult = standardStoryPage.checkVideoAndImageAreAdded(this.property);
            Assert.assertTrue(isResult, "Video and image are not added : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3032: Verify video and image is added or not With Caption")
    @Test
    public void verifyVideoAndImageAreAddedWithCaption() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            isResult = standardStoryPage.checkVideoAndImageAreAddedWithCaption(this.property);
            Assert.assertTrue(isResult, "Video and image are not added With Caption : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("QAAUT-5165: Outdated Flag toggle button")
    @Test
    public void verifyOutdatedFlagToggleButton() {
        boolean isResult;
        if (this.property.equals("Tech")) {
            isResult = standardStoryPage.checkOutdatedFlagToggleButton(this.property);
            Assert.assertTrue(isResult, "Outdated flag toggle button is not working : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("QAAUT-5168: Verify outdated flag validity time field")
    @Test
    public void verifyOutdatedFlagTimeFiled() {
        boolean isResult;
        if (this.property.equals("Tech")) {
            isResult = standardStoryPage.checkOutdatedFlagTimeFiled(this.property);
            Assert.assertTrue(isResult, "Mis match in date&time display in Default date and current system date : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5162: Verify that sentences should be displayed in form of paragraph after selecting the paragraph option")
    @Test
    public void verifySelectingOnParagraphSentencesShouldBeDisplayedInFormOfParagraph() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectingOnParagraphSentencesShouldBeDisplayedInFormOfParagraph", property);
        isResult = standardStoryPage.checkSentencesIsDisplayedInFormOfParagraph(this.property, paramsMap.get("Headline"), paramsMap.get("Summary"), paramsMap.get("Paragraph"));
        Assert.assertTrue(isResult, "Sentences is not displaying in form of Paragraph after selecting the paragraph option : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5163: Verify that whole sentence should be affected if the user selects any options like Headline 2, Headline 3, and Paragraph")
    @Test
    public void verifyWholeSentenceShouldBeAffectedIfTheUserSelectsAnyOptions() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyWholeSentenceShouldBeAffectedIfTheUserSelectsAnyOptions", property);
        isResult = standardStoryPage.checkWholeSentenceShouldBeAffected(this.property, paramsMap.get("Headline"), paramsMap.get("Summary"), paramsMap.get("Paragraph"));
        Assert.assertTrue(isResult, "Whole sentence has not affected if the user selects any options like Headline 2, Headline 3, and Paragraph : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5164: Verify that any sentence of the paragraph should not be affected if the user apply Headline 2, Headline 3 for the heading only")
    @Test
    public void verifyOnlyHeadingShouldBeAffected() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyOnlyHeadingShouldBeAffected", property);
        isResult = standardStoryPage.checkOnlyHeadingShouldBeAffected(this.property, paramsMap.get("Headline"), paramsMap.get("Summary"), paramsMap.get("Paragraph"));
        Assert.assertTrue(isResult, "All sentence of the paragraph has affected if the user apply Headline 2, Headline 3 for the heading only : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5166: User should be able to paste paragraph or write manually")
    @Test
    public void verifyUserCanEnterParagraph() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserCanEnterParagraph", property);
        isResult = standardStoryPage.checkUserCanEnterParagraph(this.property, paramsMap.get("Headline"), paramsMap.get("Summary"), paramsMap.get("Paragraph"));
        Assert.assertTrue(isResult, "User is not able to paste paragraph or write manually : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5167: H button should float along with three buttons (Alignment button, Delete button & Six dot icon) according to line of paragraph")
    @Test
    public void verifyHButtonFloatingAlongWithThreeButtons() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyHButtonFloatingAlongWithThreeButtons", property);
        isResult = standardStoryPage.checkHButtonFloatingAlongWithThreeButtons(this.property, paramsMap.get("Headline"), paramsMap.get("Summary"), paramsMap.get("Paragraph"));
        Assert.assertTrue(isResult, "H button is not floating along with three buttons : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5169: User should able to edit Paragraph of Published story and H button along with three buttons (Alignment button, Delete button & Six dot icon) should also float according to line of paragraph")
    @Test
    public void verifyEditParagraphOfPublishedStoryAndHButtonFloatingAlongWithThreeButtons() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyEditParagraphOfPublishedStoryAndHButtonFloatingAlongWithThreeButtons", property);
        String headLine = paramsMap.get("headline")+" "+commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary")+" "+commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkEditParagraphAndHButtonFloatingWithThreeButtons(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "User is not able to edit Paragraph of Published story and H button along with three buttons (Alignment button, Delete button & Six dot icon) are not floating according to line of paragraph : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5170: Verify by changing the value in validity time field")
    @Test
    public void verifyChangingTheValueInValidityTimeField() {
        boolean isResult;
        if (this.property.equals("Tech")) {
            isResult = standardStoryPage.checkChangingTheValueInValidityTimeField(this.property);
            Assert.assertTrue(isResult, "Not able to edit validity time field : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5171: Verify the outdated flag value in DB")
    @Test
    public void verifyOutdatedFlagValueInDb() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyOutdatedFlagValueInDb", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline")+" "+commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary")+" "+commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkOutdatedFlagValueInDb(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Outdated flag value is not present in DB : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5153: Verify Auto backlink details in DB")
    @Test
    public void verifyAutoBacklinkDetailsInDb() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyAutoBacklinkDetailsInDb", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline")+" "+commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary")+" "+commonFunctions.generateRandomNum()+"aw";
            String paragraph = paramsMap.get("paragraph")+" "+paramsMap.get("ValidParagraph")+" "+"aw";
            paragraph = paragraph + " " + commonFunctions.generateRandomNum() + Keys.chord(Keys.ENTER) + paragraph + " " + commonFunctions.generateRandomNum();
            isResult = standardStoryPage.checkAutoBacklinkDetailsInDb(this.property, headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("AutoBacklinkSuccessMessage"));
            Assert.assertTrue(isResult, "Auto Backlink details is not present in DB : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5188: Verify that the name convention for moengage notification sent is of the naming convention")
    @Test
    public void verifyTheNameConventionForMoengageNotification() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyTheNameConventionForMoengageNotification", property);
        String headLine = paramsMap.get("headline")+" "+commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary")+" "+commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkTheNameConventionForMoengageNotification(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("MoengageUrl"), paramsMap.get("MoengageUserName"), paramsMap.get("MoengagePassword"));
        Assert.assertTrue(isResult, "The name convention for moengage notification is not proper : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-5189: Verify the naming convention is as expected in case of scheduled notifications")
    @Test
    public void verifyTheNameConventionForScheduledNotification() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyTheNameConventionForScheduledNotification", property);
        String headLine = paramsMap.get("headline")+" "+commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary")+" "+commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkTheNameConventionForScheduledNotification(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("MoengageUrl"), paramsMap.get("MoengageUserName"), paramsMap.get("MoengagePassword"));
        Assert.assertTrue(isResult, "The name convention for Scheduled notification is not proper : " + property);
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("QAAUT-5183: Verify slug option in Notification window")
    @Test
    public void verifySlugOptionInNotificationWindows() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySlugOptionInNotificationWindows", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkSlugOptionInNotificationWindows(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("notificationtype"));
            Assert.assertTrue(isResult, "Slug option is not available : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("QAAUT-5184: Verify notification type as slug")
    @Test
    public void verifyNotificationTypeAsSlug() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyNotificationTypeAsSlug", property);
        if (this.property.equals("Live Mint")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkNotificationTypeAsSlug(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("notificationtype"));
            Assert.assertTrue(isResult, "Slug option is not available : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5200: Verify that user is able to select related stories mutiple times in a story.")
    @Test
    public void verifySelectRelatedStoriesMutipleTimesInStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectRelatedStoriesMutipleTimesInStory", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkSelectRelatedStoriesMutipleTimesInStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "User is not able to select related stories mutiple times in a story : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5201: Verify related story already selected is shown ticked and user can select other stories from the list displayed")
    @Test
    public void verifySelectOtherRelatedStories() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectOtherRelatedStories", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkSelectOtherRelatedStories(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Related story already selected is not shown ticked and user can not select other stories from the list displayed : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-5202: Verify that user can select same related story in other posts for single story.")
    @Test
    public void verifySelectSameRelatedStoryInOtherPostsForSingleStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySelectSameRelatedStoryInOtherPostsForSingleStory", property);
        if (this.property.equals("Tech")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = standardStoryPage.checkSelectSameRelatedStoryInOtherPostsForSingleStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"), paramsMap.get("CSSName"), paramsMap.get("CSSValue"));
            Assert.assertTrue(isResult, "User can not select same related story in other posts for single story : " + property);
        } else {
            Utils.logStepInfo(true, "Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5175: verifySeoScorePrePublish")
    @Test
    public void verifySeoScorePrePublish() {
        boolean isResult;
        if (this.property.equals("Live Mint")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifySeoScorePrePublish", property);
            isResult=standardStoryPage.checkIfSeoScorePrePublish(
                    paramsMap.get("headLine"),paramsMap.get("summary"),paramsMap.get("paragraph")
                    ,paramsMap.get("byline"),paramsMap.get("section"),paramsMap.get("subsection")
                    ,paramsMap.get("keyword1"),paramsMap.get("keyword2"));
            Assert.assertTrue(isResult, "failed to verify seo score pre publish for" + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Mint Domain!!! but currently selected domain is "+ property);


    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5176: verifySeoScorePostPublish")
    @Test
    public void verifySeoScorePostPublish() {
        boolean isResult;
        if(this.property.equals("Live Mint")){
            Map<String, String> paramsMap = globalVars.getParamsData("verifySeoScorePostPublish", property);
            isResult=standardStoryPage.checkIfSeoScorePostPublish(
                    paramsMap.get("headLine"),paramsMap.get("summary"),paramsMap.get("paragraph")
                    ,paramsMap.get("byline"),paramsMap.get("section"),paramsMap.get("subsection")
                    ,paramsMap.get("keyword1"),paramsMap.get("keyword2"));
            Assert.assertTrue(isResult, "failed to verify seo score post publish for" + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Mint Domain!!! but currently selected domain is "+ property);

    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5292: Verify that 'Watch:' as prefix is displayed in bold above video embed")
    @Test
    public void verifyThatWatchAsPrefixIsDisplayedInBoldAboveVideoEmbed() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatWatchAsPrefixIsDisplayedInBoldAboveVideoEmbed", property);
        isResult=standardStoryPage.checkIfWatchAsPrefixIsDisplayedInBoldAboveVideoEmbed(paramsMap.get("preText"));
        Assert.assertTrue(isResult, "failed to verify the prefix" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5322: verify that user is able to Create Story (Standard)")
    @Test
    public void verifyThatUserIsAbleToCreateStandardStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateStandardStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfUserIsAbleToCreateStandardStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "failed to verify the generated url after standard story creation" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QUAAT5329- verifyThatUserIsAbleToAddHyperLinkToRequiredWord")
    @Test
    public void verifyThatUserIsAbleToAddHyperLinkToRequiredWord(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToAddHyperLinkToRequiredWord", property);
        isResult = standardStoryPage.checkIfUserIsAbleToAddHyperLinkToRequiredWord(paramsMap.get("hyperLink"),paramsMap.get("paragraphText"));
        Assert.assertTrue(isResult, "failed to check if user is able to upload images from image library for " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5360: Verify that when generated URL is clicked it should open correct URL on frontend for all published story")
    @Test
    public void verifyThatGeneratedUrlRedirectingToTheCorrectFrontendStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateStandardStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfGeneratedUrlRedirectingToTheCorrectFrontendStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "failed to verify that url is redirecting to the correct frontend story" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5470: verifyThatTheStatusColumnShouldDisplayCreatedTextIfUserCreatedTheStory")
    @Test
    public void verifyThatTheStatusColumnShouldDisplayCreatedTextIfUserCreatedTheStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheStatusColumnShouldDisplayCreatedTextIfUserCreatedTheStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfTheStatusColumnIsDisplayedCreatedTextIfUserCreatedTheStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("captionName"),paramsMap.get("leadMediaCaption"));
        Assert.assertTrue(isResult, "failed to verify the status of the story is created if the story is saved" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5473- VerifyThatTheStatusColumnShouldDisplayEditedTextIfUserDoNotApplyScheduleTimeToPublishTheStory")
    @Test
    public void VerifyThatTheStatusColumnShouldDisplayEditedTextIfUserDoNotApplyScheduleTimeToPublishTheStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("VerifyThatTheStatusColumnShouldDisplayEditedTextIfUserDoNotApplyScheduleTimeToPublishTheStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfTheStatusColumnShouldDisplayEditedTextIfUserDoNotApplyScheduleTimeToPublishTheStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("captionName"),paramsMap.get("leadMediaCaption"));
        Assert.assertTrue(isResult, "failed to verify the status is edited for " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5476- verifyThatTheStatusColumnShouldDisplayScheduledTextIfUserScheduleFixTimeToPublishTheStory")
    @Test
    public void verifyThatTheStatusColumnShouldDisplayScheduledTextIfUserScheduleFixTimeToPublishTheStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheStatusColumnShouldDisplayScheduledTextIfUserScheduleFixTimeToPublishTheStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfTheStatusColumnShouldDisplayScheduledTextIfUserScheduleFixTimeToPublishTheStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("captionName"),paramsMap.get("leadMediaCaption"));
        Assert.assertTrue(isResult, "failed to verify the status is Scheduled for " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5477- verifyThatTheBackgroundColorOfScheduledTextIsSameAsTextColor")
    @Test
    public void verifyThatTheBackgroundColorOfScheduledTextIsSameAsTextColor(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheBackgroundColorOfScheduledTextIsSameAsTextColor", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfTheBackgroundColorOfScheduledTextIsSameAsTextColor(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("captionName"),paramsMap.get("leadMediaCaption"),paramsMap.get("backgroundColor"),paramsMap.get("textColor"));
        Assert.assertTrue(isResult, "failed to verify text color and background color for " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5478 - VerifyThatGreyBackgroundColorShouldBePresentAroundScheduledText")
    @Test()
    public void VerifyThatGreyBackgroundColorShouldBePresentAroundScheduledText() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("VerifyThatGreyBackgroundColorShouldBePresentAroundScheduledText", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.CheckIfGreyBackgroundColorShouldBePresentAroundScheduledText(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("captionName"),paramsMap.get("leadMediaCaption"),paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to verify scheduled status background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5493- verifyThatTheStatusColumnShouldDisplayFiledTextIfStoryIsOnlyFiled")
    @Test
    public void verifyThatTheStatusColumnShouldDisplayFiledTextIfStoryIsOnlyFiled(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatTheStatusColumnShouldDisplayFiledTextIfStoryIsOnlyFiled", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfTheStatusColumnShouldDisplayFiledTextIfStoryIsOnlyFiled(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"),paramsMap.get("captionName"),paramsMap.get("leadMediaCaption"));
        Assert.assertTrue(isResult, "failed to verify the status is FILED for " + property);
    }
    @Author(name = "seshasai voggu")
    @Description("QAAUT5496- verifyThatUserIsAbleToKillThePublishedStory")
    @Test
    public void verifyThatUserIsAbleToKillThePublishedStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToKillThePublishedStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfUserIsAbleToKillThePublishedStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "failed to kill the story for the tenant " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5480- verifyThatUserIsAbleToOpenStoryOfMintGenieTenant")
    @Test
    public void verifyThatUserIsAbleToOpenStoryOfMintGenieTenant(){
        boolean isResult;
        isResult = standardStoryPage.checkIftUserIsAbleToOpenStoryOfMintGenieTenant();
        Assert.assertTrue(isResult, "failed to open the story for the tenant " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5603- verifyThatInsertSampleImagesElementIsPresentInInlineElements")
    @Test
    public void verifyThatInsertSampleImagesElementIsPresentInInlineElements(){
        boolean isResult;
        isResult = standardStoryPage.checkIfInsertSampleImagesElementIsPresentInInlineElements();
        Assert.assertTrue(isResult, "failed to verify sample image element for  " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5604- verifyTheActionOnClickOfClickInsertSampleImagesElementIcon")
    @Test
    public void verifyTheActionOnClickOfClickInsertSampleImagesElementIcon(){
        boolean isResult;
        isResult = standardStoryPage.checkActionOnClickOfClickInsertSampleImagesElementIcon();
        Assert.assertTrue(isResult, "failed to check the result on clicking the sample images element  " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5611- verifyThatUserShouldBeAbleToUploadFilesUsingPickFromGalleryButton")
    @Test
    public void verifyThatUserShouldBeAbleToUploadFilesUsingPickFromGalleryButton(){
        boolean isResult;
        isResult = standardStoryPage.checkIfUserIsAbleToUploadFilesUsingPickFromGalleryButton();
        Assert.assertTrue(isResult, "failed to check if user is able to upload images from image library for " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5613- verifyThatSampleImageIdsPresentInMasterDb")
    @Test
    public void verifyThatSampleImageIdsPresentInMasterDb(){
        boolean isResult;
        isResult = standardStoryPage.checkIfSampleImageIdsPresentInMasterDb();
        Assert.assertTrue(isResult, "failed to check if sample image ids present in db " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5669- verifyThatUserIsAbleToClickOnStandardStory")
    @Test
    public void verifyThatUserIsAbleToClickOnStandardStory(){
        boolean isResult;
        isResult = standardStoryPage.checkIfUserIsAbleToClickOnStandardStory();
        Assert.assertTrue(isResult, "failed to check if user is able to click on standard story " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5672- verifyUserIsAbleToSeeSubSectionL2FieldInMetaDataSection")
    @Test
    public void verifyUserIsAbleToSeeSubSectionL2FieldInMetaDataSection(){
        boolean isResult;
        isResult = standardStoryPage.checkIfUserIsAbleToSeeSubSectionL2FieldInMetaDataSection();
        Assert.assertTrue(isResult, "failed to check if sub section l2 present in metadata section " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5684- verify That User Is Able To Create StandardStory After Filling SubSectionL2 Field")
    @Test
    public void verifyThatUserIsAbleToCreateStandardStoryAfterFillingSubSectionL2Field(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateStandardStoryAfterFillingSubSectionL2Field", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfUserIsAbleToCreateStandardStoryAfterFillingSubSectionL2Field(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("subsectionL2"));
        Assert.assertTrue(isResult, "failed to check if story published by filling sub section l2 " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5685- verify That SubSectionl2 Should Not Be Used To Create Url Of The Story")
    @Test
    public void verifyThatSubSectionl2ShouldNotBeUsedToCreateUrlOfTheStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatSubSectionl2ShouldNotBeUsedToCreateUrlOfTheStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.checkIfSubSectionl2ShouldNotBeUsedToCreateUrlOfTheStory(headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"),paramsMap.get("subsectionL2"));
        Assert.assertTrue(isResult, "failed to check if sub section l2 not present in url  " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5717- Verify that user is able to see Headline,Summary & Paragraph fields in the story creation page")
    @Test
    public void verifyUserCanSeeHeadlineSummaryAndParagraphInNewStory(){
        boolean isResult;
        isResult = standardStoryPage.checkIfUserCanSeeHeadlineSummaryAndParagraphInNewStory();
        Assert.assertTrue(isResult, "failed to check if user can see headline summary and paragraph " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5718- Verify that user is able to add headline in the story")
    @Test
    public void verifyThatUserIsAbleToAddHeadlineToStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToAddHeadlineToStory", property);
        isResult = standardStoryPage.checkIfUserIsAbleToAddHeadlineToStory(paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw");
        Assert.assertTrue(isResult, "failed to check if user can add headline " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5719- Verify that user is able to add Summary in the story")
    @Test
    public void verifyThatUserIsAbleToAddSummaryToStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToAddSummaryToStory", property);
        isResult = standardStoryPage.checkIfUserIsAbleToAddSummaryToStory(paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw");
        Assert.assertTrue(isResult, "failed to check if user can add summary " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5720- Verify that user is able to add Paragraph in the story")
    @Test
    public void verifyThatUserIsAbleToAddParagraphToStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToAddParagraphToStory", property);
        isResult = standardStoryPage.checkIfUserIsAbleToAddParagraphToStory(paramsMap.get("paragraph"));
        Assert.assertTrue(isResult, "failed to check if user can add paragraph " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5721- Verify that user is able to see headline,summary & paragraph in the database")
    @Test
    public void verifyThatUserIsAbleToSeeHeadlineSummaryParagraphInDb(){
        boolean isResult;
        if (this.property.equals("HT NEW") || this.property.equals("Live Mint") ||
                this.property.equals("Tech") || this.property.equals("Auto") ||
                this.property.equals("Smart 24") || this.property.equals("Mint Lounge")||
                this.property.equals("Bangla")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToSeeHeadlineSummaryParagraphInDb", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum() + "aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum() + "aw";
            isResult = standardStoryPage.checkIfUserIsAbleToSeeHeadlineSummaryParagraphInDb(headLine, summary, paramsMap.get("paragraph"));
            Assert.assertTrue(isResult, "failed to check if user can add headline,summary,paragraph " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsInDatabase("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paramsMap.get("paragraph"));
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);
        }
        else { Utils.logStepInfo(true, " Test case is not valid for this Domain!!!"+property);}

    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5293-  Verify that new paragraph element is created for video title while picking video embed.")
    @Test
    public void verifyNewParagraphElementCreatedAfterInsertingVideo(){
        if (!this.property.equals("Smart 24")) {
            boolean isResult;
            isResult = standardStoryPage.checkIfParagraphElementCreatedAfterInsertingVideo();
            Assert.assertTrue(isResult, "failed to check if user can add paragraph " + property);
        }
        else { Utils.logStepInfo(true, " Test case is not valid for this Domain!!!"+property);}

    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5610-Verify that user can upload images from upload new files option")
    @Test
    public void verifyUserCanUploadImagesFromUploadNewFilesOptionInInline(){
        boolean isResult;
        isResult = standardStoryPage.checkIfUserCanUploadImagesFromUploadNewFilesOptionInInline();
        Assert.assertTrue(isResult, "failed to upload image " + property);
    }

    @Author(name = "Divya Lakhera")
    @Description("QAAUT-3130: This test case will create a standard story and enable the Specials toggle button")
    @Test
    public void verifyStandardStorySpecialsMetaDataValues() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStandardStorySpecialsMetaDataValues", property);
        if (this.property.equals("HT NEW")) {

            isResult = standardStoryPage.createStoryAndVerify(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);

            isResult = standardStoryPage.specialsMetaDataValues(paramsMap.get("headline"), paramsMap.get("summary"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        } else {
            Utils.logStepInfo(true, " Test case is not valid for this Domain!!!");


        }
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
            dashboardPage.storyCleanup(StandardStoryPage.storyIdNumber);
        } else {
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
