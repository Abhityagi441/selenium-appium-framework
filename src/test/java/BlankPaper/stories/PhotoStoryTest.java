package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonPhotoStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.PhotoGalleryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

import static com.pages.BlankPaper.genericPages.CommonPhotoGalleryPage.getInstance;

public class PhotoStoryTest {

    private static CommonPhotoStoryPage photoStoryPage;
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
        photoStoryPage = CommonPhotoStoryPage.getInstance();
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

    @Author(name = "Raj")
    @Description("QAAUT-3101: Verify that whatever data we are providing in landing page headline on Photo story the same data is present in metatitle or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoStoryTheSameDataIsPresentInMetatitleOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = photoStoryPage.checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoStoryTheSameDataIsPresentInMetatitleOrNot();
        Assert.assertTrue(isResult, "Whatever data we are providing in landing page headline on Photo Story the same data is not present in metatitle: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3136: Verify that whatever data we are providing in summary of Photo story the same data is present in metadescription or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInSummaryOfPhotoStoryTheSameDataIsPresentInMetadescriptionOrNot() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = photoStoryPage.checkThatSummaryOfPhotoStorySameIsPresentInMetadescription();
        Assert.assertTrue(isResult, "Whatever data we are providing in summary of Photo story the same data is not present in metadescription: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3142: Verify that after publishing the story with metatitle and meta description on photo story the complete data goes to master db")
    @Test
    public void verifyMasterDbMetaTitleAndMetaDescriptionComesForPhotoStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyMasterDbMetaTitleAndMetaDescriptionComesForPhotoStory", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String slideDesc = "Automation Testing "+ commonFunctions.generateRandomNum()+"aw";
            isResult = photoStoryPage.checkMasterDbMetaTitleAndMetaDescriptionComesForPhotoStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), slideDesc);
            Assert.assertTrue(isResult, "After publishing the story with metatitle and meta description on photo story the complete data do not goes to master db: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4913: User should be able to create Photo Story with Live Hindustan Affiliate tenant")
    @Test
    public void verifyUserShouldBeAbleToCreatePhotoStoryWithLiveHindustanAffiliateTenant() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserShouldBeAbleToCreatePhotoStoryWithLiveHindustanAffiliateTenant", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String slideDesc = "Automation Testing "+ commonFunctions.generateRandomNum()+"aw";
            isResult = photoStoryPage.checkCreatePhotoStoryWithLiveHindustanAffiliateTenant(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), slideDesc);
            Assert.assertTrue(isResult, "User is not able to create Photo Story with: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5324: Verify that user is able to Create Photo Story")
    @Test
    public void verifyThatUserIsAbleToCreatePhotoStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreatePhotoStory", property);
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            String slideDesc = "Automation Testing "+ commonFunctions.generateRandomNum()+"aw";
            isResult = photoStoryPage.checkCIfUserIsAbleToCreatePhotoStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), slideDesc,paramsMap.get("imageCaption"),paramsMap.get("caption"));
            Assert.assertTrue(isResult, "User is not able to create Photo Story with: " + property);
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
