package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonListicleStoryPage;
import com.pages.BlankPaper.genericPages.CommonStandardStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.ListicleStoryPage;
import com.pages.BlankPaper.webdesktop.stories.StandardStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

import static com.pages.BlankPaper.genericPages.CommonStandardStoryPage.getInstance;

public class ListicleStoryTest {
    private static CommonListicleStoryPage listicleStoryPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property ="";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property=property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        globalVars.setBpTenant(property);
        listicleStoryPage = CommonListicleStoryPage.getInstance();
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }
    @BeforeMethod
    public void ensureHomePageVisibility(){
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Raj")
    @Description("QAAUT-4915:Verify that the user is able to create story (Listicle) with Live Hindustan Affiliate tenant")
    @Test
    public void verifyUserIsAbleToCreateListicleStoryWithLiveHindustanAffiliateTenant() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserIsAbleToCreateListicleStoryWithLiveHindustanAffiliateTenant", property);
        if (this.property.equals("Live Hindustan Affiliate")) {
            String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
            String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
            isResult = listicleStoryPage.checkUserCanCreateListicleStoryWithHindustanAffiliateTenant(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "User is not able to create story (Listicle): " + property);
        } else {
            System.out.println("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-5326: Verify that user is able to Create Listicle story")
    @Test
    public void verifyUserIsAbleToCreateListicleStory() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUserIsAbleToCreateListicleStory", property);
        String headLine = paramsMap.get("headline") + commonFunctions.generateRandomNum()+"aw";
        String summary = paramsMap.get("summary") + commonFunctions.generateRandomNum()+"aw";
        isResult = listicleStoryPage.checkIfUserCanCreateListicleStory(this.property, headLine, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "unable to publish Listicle story: " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
        if(globalVars.isProdRun()) {
            dashboardPage.clickOnBlankPaperLogo();
            dashboardPage.storyCleanup(ListicleStoryPage.storyIdNumber);
        }
        else{
            System.out.println("no cleanup done for staging env!!!");
        }
    }


}
