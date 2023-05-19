package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonPhotoGalleryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.PhotoGalleryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class PhotoGalleryStoryFrontEndTest {
    private static CommonPhotoGalleryPage photoGalleryPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFrontEndPage commonUiPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        photoGalleryPage = CommonPhotoGalleryPage.getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonUiPage= CommonFrontEndPage.getInstance(property);
        dashboardPage.domainSelection(this.property);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
    }


    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1140 : To verify photo gallery publish status and Front end UI")
    @Test
    public void verifyPhotoGalleryPublishWithUI() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryPublishWithUI", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationPhotoGalleryStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paragraph, summary, PhotoGalleryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* PhotoGallery Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1141 : To verify photo gallery soft publish status and Front end UI")
    @Test
    public void verifyPhotoGallerySoftPublishWithUI() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGallerySoftPublishWithUI", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);*/

        headLine = headLine + commonFunctions.generateRandomNum()+"aw";
        isResult = photoGalleryPage.softPublishPhotoGallery(headLine);
        Assert.assertTrue(isResult, "Photo Story is not Soft published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), true, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationOnSoftPublishPhotoGalleryStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paragraph, summary, PhotoGalleryPage.storyIdNumber,PhotoGalleryPage.timeOnPublishedStory);
        Assert.assertTrue(isResult, "******* PhotoGallery Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1142 : To verify photo gallery Schedule publish status and Front end UI")
    @Test
    public void verifyPhotoGalleryScheduleWithUI() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryScheduleWithUI", property);

        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;
        String paragraph = "";


        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = photoGalleryPage.verifySchedulePhotoGallery();
        Assert.assertTrue(isResult, "Photo Gallery is not schedule : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.waitForPublished(PhotoGalleryPage.storyIdNumber);
        Assert.assertTrue(isResult, "Schedule publish to published verification failed : " + property);
        dashboardPage.clickOnBlankPaperLogo();
        commonFunctions.hardWait(5000);

        isResult = commonUiPage.dataValidationPhotoGalleryStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paragraph, summary, PhotoGalleryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* PhotoGallery Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1169 : To verify photo gallery change url status and Front end UI")
    @Test
    public void verifyPhotoGalleryChangeUrlWithUI() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryChangeUrlWithUI", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String changeUrlHeadline = paramsMap.get("UrlHeadline") + urlIndex;
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationPhotoGalleryStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), headLine, paramsMap.get("section"), paramsMap.get("subsection"),paragraph, summary, PhotoGalleryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* PhotoGallery Story data on Front End not verified ******** : " + property);

        isResult = photoGalleryPage.checkChangeUrlPhotoGallery(changeUrlHeadline);
        Assert.assertTrue(isResult, "Photo Story is not Soft published : " + property);

        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), changeUrlHeadline, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationPhotoGalleryStoryOnFrontEnd(paramsMap.get("username"), paramsMap.get("password"), changeUrlHeadline, paramsMap.get("section"), paramsMap.get("subsection"),paragraph, summary, PhotoGalleryPage.storyIdNumber);
        Assert.assertTrue(isResult, "******* PhotoGallery Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1365: To verify photo gallery kill story status and Front end UI")
    @Test
    public void verifyPhotoGalleryKillStoryWithUI() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPhotoGalleryKillStoryWithUI", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headLine = paramsMap.get("headline") + urlIndex;
        String summary = paramsMap.get("summary") + urlIndex;
        String paragraph = "";


        isResult = dashboardPage.copyUrlAndHeadlineOfPublishedStory(paramsMap.get("storyType"));
        Assert.assertTrue(isResult, "Story headline and url not copied : " + property);

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);*/

        isResult = dashboardPage.killStoryAndVerify(PhotoGalleryPage.storyIdNumber, DashboardPage.storyUrl);
        Assert.assertTrue(isResult, "Story is not killed : " + property);
        /*isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, true);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);*/

        isResult = commonUiPage.dataValidationOnFrontEndUI(paramsMap.get("username"), paramsMap.get("password"), DashboardPage.storyHeadlineText, PhotoGalleryPage.storyIdNumber);
        Assert.assertTrue(isResult, "PhotoGallery kill story not verified On FrontEnd : " + property);
    }

        @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

}
