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

public class SectionFrontEndTest {

    private static CommonSectionPage sectionPage;
    private static CommonSubSectionPage subsectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonVideoStoryPage videoStoryPage;
    private static CommonFrontEndPage commonFrontEndPage;

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
        sectionPage = CommonSectionPage.getInstance();
        videoStoryPage = CommonVideoStoryPage.getInstance();
        globalVars.setBpTenant(property);
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1192:This test case will Verify edit page section name and verify on Frontend")
    @Test
    public void verifyPublishEditAndRefreshOnSectionWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnSectionWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headlineText = paramsMap.get("headline") + urlIndex;
        String pageSectionName = paramsMap.get("sectionName") + globalVars.getCurrentTimeStamp();
        String newPageSectionName = paramsMap.get("pageSectionEditName") + globalVars.getCurrentTimeStamp();
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headlineText, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);

        isResult = sectionPage.createDragAndDropStoryAndPublishSection(pageSectionName, paramsMap.get("sectionAlias") + globalVars.getCurrentTimeStamp(),headlineText);
        Assert.assertTrue(isResult, "Publish section not verified :" + property);

        isResult = commonFrontEndPage.checkSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), pageSectionName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText);
        Assert.assertTrue(isResult, "******* Section Name on Front End not verified ******** : " + property);

        isResult = sectionPage.editPageNameAndPublish(newPageSectionName, SubSectionPage.id);
        Assert.assertTrue(isResult, "Edit section name not verified :" + property);

        isResult = commonFrontEndPage.checkSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), newPageSectionName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText);
        Assert.assertTrue(isResult, "******* New Section Name on Front End not verified ******** : " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }


}