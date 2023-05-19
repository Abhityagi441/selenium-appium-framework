

package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonCollectionPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonHamburgerPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.Pages.HamburgerPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;

public class HamburgerTestFrontEndTest {

    private static CommonHamburgerPage hamburgerPage;
    private static CommonCollectionPage CollectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonFrontEndPage commonFrontEndPage;
    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        globalVars.setBpTenant(property);
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        hamburgerPage = CommonHamburgerPage.getInstance();
        CollectionPage = CommonCollectionPage.getInstance();
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnPages();
    }


    @Author(name = "Giridhar Raj")
    @Description("QAAUT- 1179,1180,1183 :This test case will Verify Drag And Drop and publish and check on frontend")
    @Test
    public void verifyDragAndDropAndDeleteHamburgerPageWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyDragAndDropAndDeleteHamburgerPageWithUi", property);
        String sectionName = paramsMap.get("sectionName") + globalVars.getCurrentTimeStamp();
        String sectionAlias = paramsMap.get("sectionAlias") + globalVars.getCurrentTimeStamp();

        isResult = CollectionPage.createAndPublishPageSection(sectionName, sectionAlias);
        Assert.assertTrue(isResult, "Create and Publish page section verified :" + property);

        isResult = hamburgerPage.publishHamburgerPage(paramsMap.get("type"), sectionName);
        Assert.assertTrue(isResult, "Drag And Drop and publish on Hamburger Page not verify :" + property);

        isResult = commonFrontEndPage.checkHamburgerSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), sectionName);
        Assert.assertTrue(isResult, "Drag And Drop on Hamburger page and check on FrontEnd not verify :" + property);

        isResult = hamburgerPage.deleteSection(sectionName);
        Assert.assertTrue(isResult, "Drag And Drop Delete and publish on Hamburger Page not verify :" + property);

        isResult = commonFrontEndPage.checkHamburgerDeletedSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"),sectionName);
        Assert.assertTrue(isResult, "Drag And Drop Delete on Hamburger page and check on FrontEnd not verify :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1184 :This test case will Verify Drag And Drop and publish and edit section name and check on frontend")
    @Test
    public void verifyCreatePublishAndEditRefreshPageOnHamburgerPageWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyCreatePublishAndEditRefreshPageOnHamburgerPageWithUi", property);
        String sectionName = paramsMap.get("sectionName") + globalVars.getCurrentTimeStamp();
        String sectionAlias = paramsMap.get("sectionAlias") + globalVars.getCurrentTimeStamp();
        String newSectionName = paramsMap.get("editSectionName") + globalVars.getCurrentTimeStamp();

        isResult = CollectionPage.createAndPublishPageSection(sectionName, sectionAlias);
        Assert.assertTrue(isResult, "Create and Publish page section verified :" + property);

        isResult = hamburgerPage.publishHamburgerPage(paramsMap.get("type"), sectionName);
        Assert.assertTrue(isResult, "Drag And Drop and publish on Hamburger Page not verify :" + property);

        isResult = commonFrontEndPage.checkHamburgerSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), sectionName);
        Assert.assertTrue(isResult, "Drag And Drop on Hamburger page and check on FrontEnd not verify :" + property);

        isResult = hamburgerPage.editSectionName(sectionName,newSectionName);
        Assert.assertTrue(isResult, "section name edit not verify :" + property);

        isResult = commonFrontEndPage.checkHamburgerSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), newSectionName);
        Assert.assertTrue(isResult, "Edited section name not verified on Frontend :" + property);

        hamburgerPage. deleteCreatedSection(newSectionName);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1185 :This test case will Verify Up and Down position and publish and check on frontend")
    @Test
    public void verifyUpAndDownPositionOnHamburgerPageWithUi() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUpAndDownPositionOnHamburgerPageWithUi", property);

        isResult =  hamburgerPage.sectionNameUpAndDownPosition( paramsMap.get("sectionName") + globalVars.getCurrentTimeStamp(),  paramsMap.get("sectionAlias") + globalVars.getCurrentTimeStamp(), paramsMap.get("secondSectionName") + globalVars.getCurrentTimeStamp(), paramsMap.get("secondSectionAlias") + globalVars.getCurrentTimeStamp());
        Assert.assertTrue(isResult, "Create and Publish page section verified :" + property);

        isResult = commonFrontEndPage.checkHamburgerUpAndDownPositionSectionNameOnFrontEnd(paramsMap.get("userAndPasswordURL"), HamburgerPage.firstSectionName);
        Assert.assertTrue(isResult, "*****Up and Down section name not verified on Frontend:*****" + property);
    }


    @AfterMethod
    public void closeOtherOpenTabs() { commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
    }


}

