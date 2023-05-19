package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.*;
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

public class TopicFrontEndTest {

    private static CommonTopicPage topicPage;
    private static CommonSubSectionPage subsectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFrontEndPage commonFrontEndPage;
    private static CommonSectionPage sectionPage;
    private static CommonVideoStoryPage videoStoryPage;
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
        topicPage = CommonTopicPage.getInstance();
        videoStoryPage = CommonVideoStoryPage.getInstance();
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
        sectionPage = CommonSectionPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT- 1362:This test case will Verify edit page section name and verify on Frontend")
    @Test
    public void verifyPublishEditAndRefreshOnTopicWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnTopicWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String headlineText = paramsMap.get("headline") + urlIndex;
        String pageTopicName = paramsMap.get("TopicName") + globalVars.getCurrentTimeStamp();
        String newPageTopicName = paramsMap.get("pageTopicEditName") + globalVars.getCurrentTimeStamp();
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headlineText, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);

        isResult = topicPage.createDragAndDropStoryAndPublishTopic(pageTopicName, paramsMap.get("topicAlias") +globalVars.getCurrentTimeStamp(),paramsMap.get("section"),headlineText );
        Assert.assertTrue(isResult, "Publish Topic not verified :" + property);

        isResult = commonFrontEndPage.checkSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), pageTopicName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText);
        Assert.assertTrue(isResult, "******* Topic Name on Front End not verified ******** : " + property);

        isResult = sectionPage.editPageNameAndPublish(newPageTopicName, SubSectionPage.id);
        Assert.assertTrue(isResult, "Edit Topic name not verified :" + property);

        isResult = commonFrontEndPage.checkSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), newPageTopicName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText);
        Assert.assertTrue(isResult, "******* Edit Topic Name on Front End not verified ******** : " + property);
    }


    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }

}