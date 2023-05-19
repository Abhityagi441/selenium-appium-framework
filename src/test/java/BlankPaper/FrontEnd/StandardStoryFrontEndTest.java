package BlankPaper.FrontEnd;

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
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

import static com.pages.BlankPaper.genericPages.CommonStandardStoryPage.getInstance;

public class StandardStoryFrontEndTest {
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


    @Author(name = "Giridhar Raj")
    @Description(" This test case will create and publish a standard story and verify data on Front end Ui")
    @Test
    public void verifyDataOfCreateAndPublishStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyDataOfCreateAndPublishStory", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000000);
        String headline = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;


            isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);

            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

            String urlHead = paramsMap.get("urlHeadline")+commonFunctions.generateRandomNum()+"aw";
            isResult = commonFrontEndPage.changeUrl(urlHead, StandardStoryPage.storyIdNumber);
            Assert.assertTrue(isResult, "url not changed : " + property);

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);

            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline,summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

            isResult = commonFrontEndPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), headline, paramsMap.get("section"), paramsMap.get("subsection"), summary, paramsMap.get("byline"), paramsMap.get("paragraph"), paramsMap.get("location"), paramsMap.get("topic"), StandardStoryPage.storyIdNumber);
            Assert.assertTrue(isResult, "Standard Story data not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description(" QAAUT-1133: This test case will create and publish a standard story and verify data on Front end Ui")
    @Test
    public void verifyStandardStoryPublishWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStandardStoryPublishWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000000);
        String headline = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

            isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline,summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), headline, paramsMap.get("section"), paramsMap.get("subsection"), summary, paramsMap.get("byline"), paramsMap.get("paragraph"), paramsMap.get("location"), paramsMap.get("topic"), StandardStoryPage.storyIdNumber);
            Assert.assertTrue(isResult, "Standard Story data not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar raj")
    @Description("QAAUT-1136: This test case will create, publish and soft publish a standard story and verify data on Front end Ui")
    @Test
    public void verifySoftPublishWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySoftPublishWithUi", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000000);
        String headline = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline,summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published not verified from MongoDB : " + property);*/

        headline = paramsMap.get("newHeadline")+commonFunctions.generateRandomNum()+"aw";
        isResult = standardStoryPage.softPublishWithNewHeadline(headline);
        Assert.assertTrue(isResult, "Standard Story is not soft published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), true, false);
        Assert.assertTrue(isResult, "Soft Published not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.dataValidationWithPublishTimeStandardStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headline, paramsMap.get("section"), paramsMap.get("subsection"), summary, paramsMap.get("byline"), paramsMap.get("paragraph"), paramsMap.get("location"), paramsMap.get("topic"), StandardStoryPage.storyIdNumber, StandardStoryPage.timeOnPublishedStory);
        Assert.assertTrue(isResult, "******* Standard Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1138:")
    @Test
    public void verifySchedulePublishStandardStoryWithUi() {
        boolean isResult;
            Map<String, String> paramsMap = globalVars.getParamsData("verifySchedulePublishStandardStoryWithUi", property);

           Random randomNo = new Random();
           int urlIndex = randomNo.nextInt(1000000);
           String headline = paramsMap.get("headline") + urlIndex;
           String summary = paramsMap.get("summary") + urlIndex;


            isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/


            isResult = standardStoryPage.schedulePublishAndVerify();
            Assert.assertTrue(isResult, "Schedule publish is failed : " + property);
            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

            isResult = commonFrontEndPage.waitForPublished(StandardStoryPage.storyIdNumber);
            Assert.assertTrue(isResult, "Schedule publish to published verification failed : " + property);
            dashboardPage.clickOnBlankPaperLogo();
            commonFunctions.hardWait(5000);

            isResult = commonFrontEndPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), headline, paramsMap.get("section"), paramsMap.get("subsection"), summary, paramsMap.get("byline"), paramsMap.get("paragraph"), paramsMap.get("location"), paramsMap.get("topic"), StandardStoryPage.storyIdNumber);
            Assert.assertTrue(isResult, "Standard Story data not verified On FrontEnd : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1137: This test case will change the url of standard story and verify data on Front end Ui")
    @Test
    public void verifyChangeUrlOnStandardStoryWithUi() {
        boolean isResult;
            Map<String, String> paramsMap = globalVars.getParamsData("verifyChangeUrlOnStandardStoryWithUi", property);
            Random randomNo = new Random();
            int urlIndex = randomNo.nextInt(1000000);
            String changeUrlHeadline = paramsMap.get("UrlHeadline") + urlIndex;
            String headline = paramsMap.get("headline") + urlIndex;
            String summary = paramsMap.get("summary") + urlIndex;

            isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/


            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline,summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "PUBLISHED not verified from MongoDB : " + property);*/

            isResult = commonFrontEndPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), headline, paramsMap.get("section"), paramsMap.get("subsection"), summary, paramsMap.get("byline"), paramsMap.get("paragraph"), paramsMap.get("location"), paramsMap.get("topic"), StandardStoryPage.storyIdNumber);
            Assert.assertTrue(isResult, "Standard Story data not verified On FrontEnd : " + property);

            isResult = standardStoryPage.checkChangeUrl(changeUrlHeadline);
            Assert.assertTrue(isResult, "Story url is not changed : " + property);

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
            /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), changeUrlHeadline,summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "PUBLISHED not verified from MongoDB : " + property);*/

            isResult = commonFrontEndPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), changeUrlHeadline, paramsMap.get("section"), paramsMap.get("subsection"), summary, paramsMap.get("byline"), paramsMap.get("paragraph"), paramsMap.get("location"), paramsMap.get("topic"), StandardStoryPage.storyIdNumber);
            Assert.assertTrue(isResult, "Standard Story data not verified On FrontEnd : " + property);
        }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1363: This test case will kill standard story and verify data on Front end Ui")
    @Test
    public void verifyKillStoryStandardStoryWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyKillStoryStandardStoryWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000000);
        String headline = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = dashboardPage.copyUrlAndHeadlineOfPublishedStory(paramsMap.get("storyType"));
        Assert.assertTrue(isResult, "Story headline and url not copied : " + property);

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline,summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

        isResult = dashboardPage.killStoryAndVerify(StandardStoryPage.storyIdNumber, DashboardPage.storyUrl);
        Assert.assertTrue(isResult, "Story is not killed : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", StandardStoryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headline, summary, paramsMap.get("paragraph"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, true);
        Assert.assertTrue(isResult, "Data not verified from MongoDB : " + property);*/

        isResult = commonFrontEndPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), DashboardPage.storyHeadlineText, StandardStoryPage.storyIdNumber);
        Assert.assertTrue(isResult, "Standard Story kill story not verified On FrontEnd : " + property);
    }



    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

}
