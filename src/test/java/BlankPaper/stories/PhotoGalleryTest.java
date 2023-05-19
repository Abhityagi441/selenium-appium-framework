package BlankPaper.stories;

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
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.util.Map;

import static com.pages.BlankPaper.genericPages.CommonPhotoGalleryPage.getInstance;

public class PhotoGalleryTest  {
    private static CommonPhotoGalleryPage photoGalleryPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFrontEndPage commonUiPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        photoGalleryPage = getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonUiPage= CommonFrontEndPage.getInstance(property);
        dashboardPage.domainSelection(this.property);
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
    }

    @Author(name = "Ishank Khatri")
    @Description("QAAUT-45 QAAUT-4: To verify set as lead media image")
    @Test
    public void verifyPhotoGalleryCreation() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryCreation", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";
        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Gallery is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test(priority = -1)
    public void verifyPhotoGalleryCreationStatus() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryCreationStatus", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.verifyCreatePhotoGalleryStatus(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Gallery created Status not verified : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyPhotoGalleryDiscard() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryDiscard", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";
        if(!globalVars.isProdRun()) {
            isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Photo Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        }
        isResult = photoGalleryPage.discardPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not discarded : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data is verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    @Description("QAAUT-27:To verify photo gallery publish status")
    public void verifyPhotoGalleryPublish() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);

    }

    @Author(name = "Ishank Khatri")
    @Test
    @Description("QAAUT-19:To verify soft publish photo gallery")
    public void verifyPhotoGallerySoftPublish() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGallerySoftPublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        if(!globalVars.isProdRun()) {
            isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Photo Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

            isResult = photoGalleryPage.verifyPublishPhotoGallery();
            Assert.assertTrue(isResult, "Photo Story is not published : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
            Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);
        }

        isResult = photoGalleryPage.softPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not Soft published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), true, false);
        Assert.assertTrue(isResult, "Soft Published Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    @Description("QAAUT-81: To verify kill photo gallery")
    public void verifyPhotoGalleryKill() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryKill", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);

        isResult = photoGalleryPage.verifyKillPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not Soft published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, true);
        Assert.assertTrue(isResult, "Killed Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    @Description("QAAUT-42:To purge photo gallery")
    public void verifyPhotoGalleryPurge() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryPurge", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);


        isResult = photoGalleryPage.verifyPurgePhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not purged : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyPhotoGalleryEdit() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryEdit", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        isResult = photoGalleryPage.editedPhotoGalleryAndVerify();
        Assert.assertTrue(isResult, "Photo Story is not edited : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    @Description("QAAUT-35:To verify photo gallery schedule publish status")
    public void verifyPhotoGallerySchedulePublish() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGallerySchedulePublish", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        isResult = photoGalleryPage.verifySchedulePhotoGallery();
        Assert.assertTrue(isResult, "Photo Gallery is not schedule : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyPhotoGalleryDeleteContent() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryDeleteContent", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        if(!globalVars.isProdRun()) {
            isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Photo Story is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = photoGalleryPage.verifyDeleteGalleryContent();
        Assert.assertTrue(isResult, "Photo Gallery content is not deleted : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, "", paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyPhotoGalleryChangeURL() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryChangeURL", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        isResult = photoGalleryPage.verifyPublishPhotoGallery();
        Assert.assertTrue(isResult, "Photo Story is not published : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetails("PUBLISHED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"));
        Assert.assertTrue(isResult, "Published Data not verified from MongoDB : " + property);

        isResult = photoGalleryPage.checkChangeUrlPhotoGallery();
        Assert.assertTrue(isResult, "Photo Gallery URL is not changed: " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    public void verifyPhotoGalleryCustomHeadline() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryCustomHeadline", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";
        if(!globalVars.isProdRun()) {
            isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Photo Gallery is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        }

        isResult = photoGalleryPage.updateCustomHeading(paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"), paramsMap.get("newsletterHeadline"), this.property);
        Assert.assertTrue(isResult, "Photo Gallery headline is not updated : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndHeadinesOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), paramsMap.get("landingPageHeadline"), paramsMap.get("mobileHeadline"), paramsMap.get("browserHeadline"), paramsMap.get("facebookHeadline"), paramsMap.get("twitterHeadline"));
        Assert.assertTrue(isResult, "Updated Headlines Data not verified from MongoDB : " + property);
    }

    @Author(name = "Ishank Khatri")
    @Test
    @Description("QAAUT-471: To verify drag and drop")
    public void verifyPhotoGalleryImageDragAndDrop() {
        boolean isResult;

        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryImageDragAndDrop", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        if(!globalVars.isProdRun()) {
            isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "Photo Gallery is not created : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);

        }

        isResult = photoGalleryPage.imageDragAndDropInPhotoGallery();
        Assert.assertTrue(isResult, "Photo Gallery drag and drop failed : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-104: To verify scrolling function with pagination hits on console")
    @Test
    public void verifyPaginationForPhotoGallery() {
        boolean isResult;
        isResult = dashboardPage.verifyPagination();
        Assert.assertTrue(isResult, "Pagination is not verified : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-105: To verify crop of image and upload multiple images - prod applicable")
    @Test
    public void verifyPhotoGalleryPageImageCropping() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPhotoGalleryPageImageCropping", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";
        isResult = photoGalleryPage.verifyCreatePhotoGalleryWithMultiplePhotos(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Story is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        isResult = photoGalleryPage.verifyMultipleImages();
        Assert.assertTrue(isResult, "No Multiple Images uploaded : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-71: This test case will create a photo gallery story and verify the preview of story")
    @Test
    public void verifyPreviewOfMobileAndDesktopOnPhotoGalleryPage() {
        boolean isResult;

        Map<String, String> paramsMap = globalVars.getParamsData("verifyPreviewOfMobileAndDesktopOnPhotoGalleryPage", property);
        String headLine;
        if(paramsMap.get("headline").length()>25) {
            headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
        }else{
            headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
        }
        String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
        String paragraph = "";

        isResult = photoGalleryPage.createPhotoGallery(headLine, summary, paragraph, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Photo Gallery is not created : " + property);
        isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
        Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);


        //TODO: verify the headline text of mobile and desktop preview
        isResult = dashboardPage.mobileAndDesktopPreview(headLine);
        Assert.assertTrue(isResult, "preview functionality is not working : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1387: This test case will create a photo gallery with default section name")
    @Test
    public void  verifyPhotoGalleryWithDefaultSection() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPhotoGalleryWithDefaultSection", property);

        if (this.property.equals("Live Mint")) {
            isResult = photoGalleryPage.defaultSection(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("secondSectionName"));
            Assert.assertTrue(isResult, "Photo Gallery default section name not verified!!!!!! : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1388: This test case will create a photo gallery with multiple images")
    @Test
    public void  verifyPhotoGalleryDataSavingWithMultipleImages() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPhotoGalleryDataSavingWithMultipleImages", property);
        String headLine;

        String paragraph = "";

        if (this.property.equals("Live Mint")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
            isResult = photoGalleryPage.createPhotoGalleryWithMultiplesImages(paramsMap.get("section"),headLine,summary,paramsMap.get("byline"),paramsMap.get("subsection"),paramsMap.get("keyword"),paramsMap.get("location"));
            Assert.assertTrue(isResult, "Photo Gallery with multiple images not verified!!!!!! : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1405: This test case will create a photo gallery with multiple images caption name")
    @Test
    public void  verifyCaptionDataSavingInMultipleImages() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyCaptionDataSavingInMultipleImages", property);
        String headLine;

        String paragraph = "";

        if (this.property.equals("Live Mint")) {
            if(paramsMap.get("headline").length()>25) {
                headLine = paramsMap.get("headline").substring(0, 25) + " " + commonFunctions.generateRandomNum() + "aw";
            }else{
                headLine = paramsMap.get("headline") + " " + commonFunctions.generateRandomNum() + "aw";
            }

            String summary = paramsMap.get("summary") + " " + commonFunctions.generateRandomNum()+"aw";
            isResult = photoGalleryPage.createPhotoGalleryWithMultiplesImagesCaptionName(paramsMap.get("section"),headLine,summary,paramsMap.get("byline"),paramsMap.get("subsection"),paramsMap.get("keyword"),paramsMap.get("location"),paramsMap.get("firstCaption"),paramsMap.get("secondCaption"),paramsMap.get("thirdCaption"));
            Assert.assertTrue(isResult, "Photo Gallery with multiple images caption name not verified!!!!!! : " + property);
            isResult = dashboardPage.verifyMongoDBConnectionAndStoryDetailsOnBackend("CREATED", PhotoGalleryPage.storyIdNumber, this.property, globalVars.getEnvironment(), headLine, summary, paragraph, paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("location"), paramsMap.get("byline"), false, false);
            Assert.assertTrue(isResult, "Saved Data not verified from MongoDB : " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1428: This test case will Pick any published photo gallery and change the images caption name and verify on Frontend")
    @Test
    public void verifyCaptionDataChangesInImagesReflectingOnFrontend() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyCaptionDataChangesInImagesReflectingOnFrontend", property);

        if (this.property.equals("Live Mint")) {
            isResult = photoGalleryPage.changeImageCaptionName(paramsMap.get("storyType"),paramsMap.get("firstCaptionName"));
            Assert.assertTrue(isResult, "Photo Gallery with multiple images caption name not verified!!!!!! : " + property);

            isResult = photoGalleryPage.verifyPublishPhotoGallery();
            Assert.assertTrue(isResult, "Photo Story is not published : " + property);

            isResult = commonFrontEndPage.dataValidationImageCaptionName(paramsMap.get("username"),paramsMap.get("password"),PhotoGalleryPage.storyIdNumber,paramsMap.get("firstCaptionName"),PhotoGalleryPage.storyHeadlineText);
            Assert.assertTrue(isResult, "Photo Story image caption name not verified !!!!! : " + property);

        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3100: Verify that whatever data we are providing in landing page headline on Photo gallery the same data is present in metatitle or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoGalleryTheSameDataIsPresentInMetatitleOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = photoGalleryPage.checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoGalleryTheSameDataIsPresentInMetatitleOrNot();
        Assert.assertTrue(isResult, "Whatever data we are providing in landing page headline on Photo gallery the same data is not present in metatitle: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3113: Verify that whatever data we are providing in summary of Photo Gallery story the same data is present in metadescription or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInSummaryOfPhotoGalleryStoryTheSameDataIsPresentInMetadescriptionOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = photoGalleryPage.checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription();
        Assert.assertTrue(isResult, "Whatever data we are providing in summary of Photo Gallery story the same data is not present in metadescription: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3114: Verify that whatever data we are providing in summary of Photo Gallery story the same data is present in metadescription or not")
    @Test
    public void verifyThatWhateverDataWeProvidingInSummaryOfPhotoGalleryStoryTheSameDataIsPresentInMetadescriptionOrNot() {
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            isResult = photoGalleryPage.checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription();
            Assert.assertTrue(isResult, "Whatever data we are providing in summary of Photo Gallery story the same data is not present in metadescription: " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for HT NEW Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3141: Verify that after publishing the story with metatitle and meta description on photo gallery story the complete data goes to master db")
    @Test
    public void verifyMasterDbMetaTitleAndMetaDescriptionComesForPhotoGalleryStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyMasterDbMetaTitleAndMetaDescriptionComesForPhotoGalleryStory", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = photoGalleryPage.checkMasterDbMetaTitleAndMetaDescriptionComesForPhotoGalleryStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "After publishing the story with metatitle and meta description on photo gallery story the complete data do not goes to master db: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4912: User should be able to create Photo Gallery")
    @Test
    public void verifyUserShouldBeAbleToCreatePhotoGalleryStoryWithLiveHindustanAffiliateTenant() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserShouldBeAbleToCreatePhotoGalleryStoryWithLiveHindustanAffiliateTenant", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = photoGalleryPage.checkCreatePhotoGalleryStoryWithLiveHindustanAffiliateTenant(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "User is not able to create Photo Gallery for: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5191: Verify the naming convention while sending the notification second time for a published story")
    @Test
    public void verifyTheNamingConventionWhileSendingTheNotificationSecondTimeForAPublishedStory() throws InterruptedException {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyTheNamingConventionWhileSendingTheNotificationSecondTimeForAPublishedStory", property);
        System.out.println(paramsMap.get("url"));
        isResult=photoGalleryPage.checkIfTheNamingConventionWhileSendingTheNotificationSecondTimeForAPublishedStory(paramsMap.get("url"),paramsMap.get("email"),paramsMap.get("password"));
        Assert.assertTrue(isResult,"failed to verify");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5190: verifyTheNamingConventionWhileSendingTheNotificationToMoEngageForAPublishedStory")
    @Test
    public void verifyTheNamingConventionWhileSendingTheNotificationToMoEngageForAPublishedStory() throws InterruptedException {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyTheNamingConventionWhileSendingTheNotificationToMoEngageForAPublishedStory", property);
        System.out.println(paramsMap.get("url"));
        isResult=photoGalleryPage.checkIfTheNamingConventionWhileSendingTheNotificationToMoEngageForAPublishedStory(paramsMap.get("url"),paramsMap.get("email"),paramsMap.get("password"));
        Assert.assertTrue(isResult,"failed to verify");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5185: verifyTitleFieldDropdownValuesWithSlugOption")
    @Test
    public void verifyTitleFieldDropdownValuesWithSlugOption(){
        boolean isResult;
        isResult=photoGalleryPage.checkIfTitleFieldDropdownValuesWithSlugOption();
        Assert.assertTrue(isResult,"failed to verify");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5290-Verify that user is able to add more than 10 images in photo gallery smoothly.")
    @Test
    public void verifyThatUserIsAbleToAddMoreThanTenImagesInPhotoGallerySmoothly(){
        boolean isResult;
        isResult=photoGalleryPage.checkIfUserIsAbleToAddMoreThanTenImagesInPhotoGallerySmoothly();
        Assert.assertTrue(isResult,"failed to verify adding of multiple images for: "+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5323- Verify that user is able to Create Story (Photo Gallery)")
    @Test
    public void verifyThatUserIsAbleToCreateStoryPhotoGallery(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateStoryPhotoGallery", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = photoGalleryPage.checkIfUserIsAbleToCreateStoryPhotoGallery(this.property, headLine,summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("caption"));
        Assert.assertTrue(isResult, "failed to create photo gallery story" + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5575- verifyThatUserIsAbleToClickOnPhotoGalleryOptionFromCreateStoryDropDown")
    @Test
    public void verifyThatUserIsAbleToClickOnPhotoGalleryOptionFromCreateStoryDropDown(){
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfUserIsAbleToClickOnPhotoGalleryOptionFromCreateStoryDropDown();
            Assert.assertTrue(isResult, "failed to click on photo gallery story button : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5576 - verifyThatUserIsRedirectedToPhotoGalleryPage")
    @Test()
    public void verifyThatUserIsRedirectedToPhotoGalleryPage() {
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfUserIsRedirectedToPhotoGalleryPage();
            Assert.assertTrue(isResult, "failed to redirect to photo gallery story : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5577 - verifyThatUserIsAbleToSeeUploadANewImageOrPickFromImageLibraryOption")
    @Test()
    public void verifyThatUserIsAbleToSeeUploadANewImageOrPickFromImageLibraryOption() {
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfUserIsAbleToSeeUploadANewImageOrPickFromImageLibraryOption();
            Assert.assertTrue(isResult, "failed to check image upload options : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5580 - verifyThatUserIsAbleToSelectMultipleImageFromPickFromImageGalleryOption")
    @Test()
    public void verifyThatUserIsAbleToSelectMultipleImageFromPickFromImageGalleryOption() {
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfUserIsAbleToSelectMultipleImageFromPickFromImageGalleryOption();
            Assert.assertTrue(isResult, "failed to select multiple images : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5581 - verifyThatImageIsUploadedWhenUserClickOnChooseImagesButtonOnPopup")
    @Test()
    public void verifyThatImageIsUploadedWhenUserClickOnChooseImagesButtonOnPopup() {
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfImageIsUploadedWhenUserClickOnChooseImagesButtonOnPopup();
            Assert.assertTrue(isResult, "failed to choose image : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5582 - verifyThatUploadedImageIsEditableWhenUserClickOnEditButtonForParticularImage")
    @Test()
    public void verifyThatUploadedImageIsEditableWhenUserClickOnEditButtonForParticularImage() {
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfUploadedImageIsEditableWhenUserClickOnEditButtonForParticularImage();
            Assert.assertTrue(isResult, "failed to choose image : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5583 - verifyThatUserIsAbleToAddCaptionInTheImage")
    @Test()
    public void verifyThatUserIsAbleToAddCaptionInTheImage(){
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfUserIsAbleToAddCaptionInTheImage();
            Assert.assertTrue(isResult, "failed to add caption to image : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5584 - verifyThatUserIsAbleToAddHyperLinkToCaptionInTheImage")
    @Test()
    public void verifyThatUserIsAbleToAddHyperLinkToCaptionInTheImage(){
        boolean isResult;
        if (this.property.equals("Bangla")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToAddHyperLinkToCaptionInTheImage", property);
            isResult = photoGalleryPage.checkIfUserIsAbleToAddHyperLinkToCaptionInTheImage(paramsMap.get("hyperLink"),paramsMap.get("paragraphText"));
            Assert.assertTrue(isResult, "failed to add hyper link in image caption : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5586 - verifyThatClickOnCaptionHyperlinkIsRedirectedToTheSameLinkInNewTab")
    @Test()
    public void verifyThatClickOnCaptionHyperlinkIsRedirectedToTheSameLinkInNewTab(){
        boolean isResult;
        if (this.property.equals("Bangla")) {
            Map<String, String> paramsMap = globalVars.getParamsData("verifyThatClickOnCaptionHyperlinkIsRedirectedToTheSameLinkInNewTab", property);
            isResult = photoGalleryPage.checkIfClickOnCaptionHyperlinkIsRedirectedToTheSameLinkInNewTab(paramsMap.get("hyperLink"),paramsMap.get("paragraphText"));
            Assert.assertTrue(isResult, "failed to check hyper link in new tab : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5578 - VerifyIfPickFromImageLibraryIsworking")
    @Test()
    public void VerifyIfPickFromImageLibraryIsworking(){
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = photoGalleryPage.checkIfPickFromImageLibraryIsworking();
            Assert.assertTrue(isResult, "failed to check hyper link in new tab : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5579-Verify that User is able to select image from Upload a new image option")
    @Test
    public void verifyUserIsAbleToSelectImageWithUploadANewImageOption(){
        boolean isResult;
        isResult = photoGalleryPage.checkIfUserIsAbleToSelectImageWithUploadANewImageOption();
        Assert.assertTrue(isResult, "failed to upload image " + property);
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
            dashboardPage.storyCleanup(PhotoGalleryPage.storyIdNumber);
        }
        else{
            System.out.println("no cleanup done for staging env!!!");
        }
    }

}
