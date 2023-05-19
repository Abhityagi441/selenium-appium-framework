package BlankPaper.videos;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonVideosPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;


public class VideosTest {
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonVideosPage commonVideosPage;

    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonVideosPage = CommonVideosPage.getInstance();
    }

    @BeforeMethod
    @Description("In case of failure this method will navigate to Dashboard")
    public void ensureHomePageVisibility(){
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT:213 Verify search functionality")
    @Test
    public void verifyVideoServiceSearchable(){
        boolean isResult;
        isResult = commonVideosPage.isVideosServiceSearchable();
        Assert.assertTrue(isResult, "Videos are not searchable: " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT:218 Verify grid view")
    @Test
    public void verifyVideoStoriesGridView(){
        boolean isResult;
        isResult = commonVideosPage.validateVideosStoriesGridView();
        Assert.assertTrue(isResult, "Videos Stories Grid view not correct: " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT:219 Verify List view")
    @Test
    public void verifyVideoStoriesListView(){
        boolean isResult;
        isResult = commonVideosPage.validateVideosStoriesListView();
        Assert.assertTrue(isResult, "Videos Stories List view not correct: " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-760 Verify search functionality--Failed by QAAUT-955")
    @Test
    public void verifyVideoStoriesSearchable(){
        boolean isResult;
        isResult = commonVideosPage.isVideosStoriesSearchable();
        Assert.assertTrue(isResult, "Videos are not searchable: " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-714 Verify preview as popup page with insert video button and redirect on story page")
    @Test
    public void verifyVideoServicesPreviewPopup(){
        boolean isResult;
        isResult = commonVideosPage.validateVideosServicePreviewPopup();
        Assert.assertTrue(isResult, "Videos service popup not verified: " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-762 Verify edit story page functionality | Verify preview as popup page with insert video button and redirect on story page")
    @Test
    public void verifyVideoStoriesPreviewPopup(){
        boolean isResult;
        isResult = commonVideosPage.validateVideosStoriesPreviewPopup();
        Assert.assertTrue(isResult, "Videos stories popup not verified: " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-761 Verify complete open preview page")
    @Test
    public void verifyCompleteOpenPreviewPageOnVideoStoriesTab(){
        boolean isResult;
        isResult = commonVideosPage.validateOpenPreviewPageOnVideosStoriesTab();
        Assert.assertTrue(isResult, "Videos stories preview popup not verified: "+ property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-763 Verify complete open preview page")
    @Test
    public void verifyCompleteOpenPreviewPageOnVideoServicesTab(){
        boolean isResult;
        isResult = commonVideosPage.validateOpenPreviewPageOnVideosServicesTab();
        Assert.assertTrue(isResult, "Videos stories preview popup not verified: "+ property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-210: Verify source filter")
    @Test
    public void verifySourceFilter(){
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifySourceFilter", property);

        isResult = commonVideosPage.sourceFilter(paramsMap.get("dataHT"),paramsMap.get("dataLM"));
        Assert.assertTrue(isResult, "Source filter not verified: "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5547 - verifyThatUserIsAbleToSeeVideosTabPresentInSidebar")
    @Test()
    public void verifyThatUserIsAbleToSeeVideosTabPresentInSidebar() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfUserIsAbleToSeeVideosTabPresentInSidebar();
        Assert.assertTrue(isResult, "failed to check videos tab"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5548 - verifyThatUserIsAbleToClickOnVideosTabPresentInSidebar")
    @Test()
    public void verifyThatUserIsAbleToClickOnVideosTabPresentInSidebar() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfUserIsAbleToClickOnVideosTabPresentInSidebar();
        Assert.assertTrue(isResult, "failed to click videos tab"+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5553 - verifyThatUserIsAbleToSeeThreeTabsOnTheVideoPage")
    @Test()
    public void verifyThatUserIsAbleToSeeThreeTabsOnTheVideoPage() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfUserIsAbleToSeeThreeTabsOnTheVideoPage();
        Assert.assertTrue(isResult, "failed to check inner tabs in videos tab for "+property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5554 - verifyThatAllTheThreeTabsAreClickable")
    @Test()
    public void verifyThatAllTheThreeTabsAreClickable() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfAllTheThreeTabsAreClickable();
        Assert.assertTrue(isResult, "failed to click inner tabs in videos tab for "+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5555 - verifyThatVideosShouldBePresentWhenUserClickOnAnyOfTheThreeTabs")
    @Test()
    public void verifyThatVideosShouldBePresentWhenUserClickOnAnyOfTheThreeTabs() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfVideosShouldBePresentWhenUserClickOnAnyOfTheThreeTabs();
        Assert.assertTrue(isResult, "failed to check stories inside video tabs "+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5556 - verifyThatAllVideosPresentUnderTheTabShouldHavePlayIconPresentOnTheRightSide")
    @Test()
    public void verifyThatAllVideosPresentUnderTheTabShouldHavePlayIconPresentOnTheRightSide() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfAllVideosPresentUnderTheTabShouldHavePlayIconPresentOnTheRightSide();
        Assert.assertTrue(isResult, "failed to check play button for videos in videos tab for "+property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5557 - verifyThatWhenUserClickOnPlayIconVideoPopupShouldOpen")
    @Test()
    public void verifyThatWhenUserClickOnPlayIconVideoPopupShouldOpen() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfWhenUserClickOnPlayIconVideoPopupShouldOpen();
        Assert.assertTrue(isResult, "failed to open video preview on click of play icon in videos tab for "+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5558 - verifyThatHeightOfPopupVideoOfVideoPageShouldBeAccordingToWindowHeight")
    @Test()
    public void verifyThatHeightOfPopupVideoOfVideoPageShouldBeAccordingToWindowHeight() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfHeightOfPopupVideoOfVideoPageShouldBeAccordingToWindowHeight();
        Assert.assertTrue(isResult, "failed to check height adjustment of the video "+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5559 - verifyThatVideoPopupShouldHaveCrossButton")
    @Test()
    public void verifyThatVideoPopupShouldHaveCrossButton() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfVideoPopupHasCrossButton();
        Assert.assertTrue(isResult, "failed to check the cross button "+property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5560 - verifyThatCrossButtonPresentOnThePopupShouldBeWorking")
    @Test()
    public void verifyThatCrossButtonPresentOnThePopupShouldBeWorking() {
        boolean isResult;
        isResult=commonVideosPage.CheckIfCrossButtonPresentOnThePopupShouldBeWorking();
        Assert.assertTrue(isResult, "failed to check cross button functionality "+property);
    }


    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

}
