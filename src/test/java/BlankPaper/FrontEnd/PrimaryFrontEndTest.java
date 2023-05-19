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

public class PrimaryFrontEndTest {

    private static CommonPrimaryPage primaryPage;
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
        primaryPage = CommonPrimaryPage.getInstance();
        videoStoryPage = CommonVideoStoryPage.getInstance();
        sectionPage = CommonSectionPage.getInstance();
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1357 :This test case will Verify edit page primary name and verify on Frontend")
    @Test
    public void verifyPublishEditAndRefreshOnPrimaryWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyPublishEditAndRefreshOnPrimaryWithUi", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headlineText = paramsMap.get("headline") + urlIndex;
        String pagePrimaryName = paramsMap.get("primaryName") + globalVars.getCurrentTimeStamp();
        String newPrimaryName = paramsMap.get("primaryEditName") + globalVars.getCurrentTimeStamp();
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = videoStoryPage.createVideoStoryAndVerify(headlineText, summary, paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Video Story is not created : " + property);

        isResult = videoStoryPage.verifyPublishVideoStory();
        Assert.assertTrue(isResult, "Video Story is not publish : " + property);

        isResult = primaryPage.createDragAndDropStoryAndPublishPrimary(pagePrimaryName, paramsMap.get("primaryAlias") +globalVars.getCurrentTimeStamp(),headlineText );
        Assert.assertTrue(isResult, "Publish Primary not verified :" + property);

        isResult = commonFrontEndPage.checkSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), pagePrimaryName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText);
        Assert.assertTrue(isResult, "******* Primary Name on Front End not verified ******** : " + property);

        isResult = sectionPage.editPageNameAndPublish(newPrimaryName, SubSectionPage.id);
        Assert.assertTrue(isResult, "Edit Primary name not verified :" + property);

        isResult = commonFrontEndPage.checkSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), newPrimaryName, SectionPage.sectionUrl,paramsMap.get("subsection"),headlineText);
        Assert.assertTrue(isResult, "******* Edit Primary Name on Front End not verified ******** : " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
    }


}
