package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonVideoStoryPage;
import com.pages.BlankPaper.genericPages.CommonWebStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.VideoStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

public class WebStoryTest {

    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonWebStoryPage webStoryPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        webStoryPage = CommonWebStoryPage.getInstance();
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

    @Author(name = "Raj")
    @Description("QAAUT-3108: Verify that whatever data we are providing in landing page headline on Web Story the same data is present in metatitle or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInLandingPageHeadlineOnWebStoryTheSameDataIsPresentInMetatitleOrNot(){
        if (this.property.equals("HT NEW")) {
            boolean isResult;
            isResult = webStoryPage.checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetatitle();
            Assert.assertTrue(isResult, "Whatever data we are providing in landing page headline on Web Story the same data is not present in metatitle: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3139: Verify that whatever data we are providing in summary of Web story the same data is present in metadescription or not")
    @Test
    public void verifyThatWhateverDataWeAreProvidingInSummaryOfWebStoryTheSameDataIsPresentInMetadescription(){
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = webStoryPage.checkWhateverDataWeAreProvidingSameDataIsPresentInMetadescription();
        Assert.assertTrue(isResult, "Whatever data we are providing in summary of Web story the same data is not present in metadescription: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3146: Verify Webstory page should open")
    @Test
    public void verifyWebStoryPageShouldOpen(){
        if (this.property.equals("HT NEW")) {
            boolean isResult;
            isResult = webStoryPage.checkWebStoryPageShouldOpen();
            Assert.assertTrue(isResult, "Webstory Page is not opening: " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3145: Verify that after publishing the story with metatitle and meta description on web story the complete data goes to master db")
    @Test
    public void verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnWebStoryTheCompleteDataGoesToMasterDb(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatAfterPublishingTheStoryWithMetatitleAndMetaDescriptionOnWebStoryTheCompleteDataGoesToMasterDb", property);
        if (this.property.equals("HT NEW")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = webStoryPage.checkAfterPublishingWebStoryTheCompleteDataGoesToMasterDb(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
            Assert.assertTrue(isResult, "After publishing the story with metatitle and meta description on Web story the complete data does not go to master db: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3147: User should be able to add a image and text on the slide")
    @Test
    public void verifyUserShouldBeAbleToAddImageAndTextOnSlide(){
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            String imageText = "Automation "+commonFunctions.generateRandomNum();
            isResult = webStoryPage.checkUserShouldBeAbleToAddImageAndTextOnSlide(imageText);
            Assert.assertTrue(isResult, "User is not able to add a image and text on the slide: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3148: User should be able to delete the image from slide")
    @Test
    public void verifyUserShouldBeAbleToDeleteTheImageFromSlide(){
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            isResult = webStoryPage.checkUserShouldBeAbleToDeleteTheImageFromSlide();
            Assert.assertTrue(isResult, "User is not able to delete the image from slide: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3150: User should be able to add multiple slides")
    @Test
    public void verifyUserShouldBeAbleToAddMultipleSlides(){
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            String firstImageText = "Automation "+commonFunctions.generateRandomNum();
            String secoundImageText = "Automation "+commonFunctions.generateRandomNum();
            isResult = webStoryPage.checkUserShouldBeAbleToAddMultipleSlides(firstImageText, secoundImageText);
            Assert.assertTrue(isResult, "User is not able to add multiple slides: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3149: User should be able to delete the text from the slide")
    @Test
    public void verifyUserShouldBeAbleToDeleteTheTextFromTheSlide(){
        boolean isResult;
        if (this.property.equals("HT NEW")) {
            String imageText = "Automation "+commonFunctions.generateRandomNum();
            isResult = webStoryPage.checkUserShouldBeAbleToDeleteTheTextFromTheSlide(imageText);
            Assert.assertTrue(isResult, "User is not able to delete the text from the slide: " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-3151: Verify user is able to delete the added slides")
    @Test
    public void verifyUserIsAbleToDeleteTheAddedSlides(){
        boolean isResult;
        String firstImageText = "Automation "+commonFunctions.generateRandomNum();
        String secondImageText = "Automation "+commonFunctions.generateRandomNum();
        isResult = webStoryPage.isUserAbleToDeleteTheAddedSlides(firstImageText,secondImageText);
        Assert.assertTrue(isResult, "User is not able to delete the text from the slide: " + property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5359: Verify that user is able to Create Story (Web Story)")
    @Test
    public void verifyThatUserIsAbleToCreateWebStory(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyThatUserIsAbleToCreateWebStory", property);
        String headLine = paramsMap.get("title") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = webStoryPage.checkIfUserIsAbleToCreateWebStory(headLine,summary,paramsMap.get("byline"),paramsMap.get("section"),paramsMap.get("subsection"),paramsMap.get("keyword"),paramsMap.get("location"));
        Assert.assertTrue(isResult, "failed to verify if the user is able to create the story: " + property);
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
