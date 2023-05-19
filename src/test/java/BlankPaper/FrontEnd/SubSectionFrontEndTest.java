package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.pages.BlankPaper.genericPages.CommonSubSectionPage;
import com.pages.BlankPaper.genericPages.CommonVideoStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.Pages.SectionPage;
import com.pages.BlankPaper.webdesktop.Pages.SubSectionPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class SubSectionFrontEndTest {

    private static CommonSubSectionPage subsectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonVideoStoryPage videoStoryPage;
    private static CommonFrontEndPage commonFrontEndPage;
    private static CommonSectionPage sectionPage;
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
        subsectionPage = CommonSubSectionPage.getInstance();
        videoStoryPage = CommonVideoStoryPage.getInstance();
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
        sectionPage = CommonSectionPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1356 :This test case will Verify edit page subsection name and verify on Frontend")
    @Test
    public void verifyPublishEditAndRefreshOnSubSectionWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnSubSectionWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headlineText = paramsMap.get("headline") + urlIndex;
        String pageSubSectionName = paramsMap.get("subsectionName") + globalVars.getCurrentTimeStamp();
        String newPageSubSectionName = paramsMap.get("pageSubSectionEditName") + globalVars.getCurrentTimeStamp();
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headlineText, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);

        isResult = subsectionPage.createDragAndDropStoryAndPublishSection(pageSubSectionName, paramsMap.get("subSectionAlias") +globalVars.getCurrentTimeStamp(),paramsMap.get("section"),headlineText );
        Assert.assertTrue(isResult, "Publish Sub-section not verified :" + property);

        isResult = commonFrontEndPage.checkSubSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), pageSubSectionName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText,paramsMap.get("section"));
        Assert.assertTrue(isResult, "******* New Sub-section Name on Front End not verified ******** : " + property);

        isResult = sectionPage.editPageNameAndPublish(newPageSubSectionName, SubSectionPage.id);
        Assert.assertTrue(isResult, "Edit Sub-section name not verified :" + property);

        isResult = commonFrontEndPage.checkSubSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), newPageSubSectionName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText,paramsMap.get("section"));
        Assert.assertTrue(isResult, "******* Edit Sub-section Name on Front End not verified ******** : " + property);
    }


    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }


}