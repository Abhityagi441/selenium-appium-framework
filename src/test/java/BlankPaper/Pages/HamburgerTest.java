

package BlankPaper.Pages;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonCollectionPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonExternalPage;
import com.pages.BlankPaper.genericPages.CommonHamburgerPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.Random;

public class HamburgerTest {

    private static CommonHamburgerPage hamburgerPage;
    private static CommonCollectionPage CollectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonExternalPage externalPage;

    SoftAssert softAssert = new SoftAssert();

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
        hamburgerPage = CommonHamburgerPage.getInstance();
        CollectionPage = CommonCollectionPage.getInstance();
        externalPage = CommonExternalPage.getInstance();
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
        dashboardPage.clickOnPages();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-188 :This test case will Verify Filters")
    @Test
    public void verifyHamburgerPageFilters() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyHamburgerPageFilters", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        if(!globalVars.isProdRun()) {
            isResult = CollectionPage.createAndPublishPageSection(paramsMap.get("sectionName") + urlIndex, paramsMap.get("sectionAlias") + generatedString);
            Assert.assertTrue(isResult, "Create and Publish page section not verified :" + property);
        }
        isResult = hamburgerPage.typeFilter(paramsMap.get("type"),paramsMap.get("sectionName") + urlIndex);
        softAssert.assertTrue(isResult, "Type Filter not working :" + property);

        if(!globalVars.isProdRun()) { //Since there is no surety of any new section being published on prod, hence this step is marked NA for prod runs
            isResult = hamburgerPage.publishedFilter(paramsMap.get("sectionName") + urlIndex);
            softAssert.assertTrue(isResult, "Published Filter not working :" + property);
        }
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-191 :This test case will Verify Drag And Drop on Hamburger Page")
    @Test
    public void verifyDragAndDropHamburgerPage() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDragAndDropHamburgerPage", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = CollectionPage.createAndPublishPageSection(paramsMap.get("sectionName") + urlIndex,paramsMap.get("sectionAlias") + generatedString);
        Assert.assertTrue(isResult, "Create and Publish page section not verified :" + property);

        isResult = hamburgerPage.dragAndDrop(paramsMap.get("type"),paramsMap.get("sectionName") + urlIndex);
        Assert.assertTrue(isResult, "Drag And Drop on Hamburger Page not verify :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-187 :This test case will Verify Search field on Hamburger Page ")
    @Test
    public void verifySearchOnHamburgerPage() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifySearchOnHamburgerPage", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        if(!globalVars.isProdRun()) {
            isResult = CollectionPage.createAndPublishPageSection(paramsMap.get("sectionName") + urlIndex, paramsMap.get("sectionAlias") + generatedString);
            Assert.assertTrue(isResult, "Create and Publish page section not verified :" + property);
        }

        isResult = hamburgerPage.searchOnHamburgerPage( paramsMap.get("sectionName") + urlIndex);
        Assert.assertTrue(isResult, "Search Field not working properly on Hamburger Page :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-186 :This test case will Verify Section Line-up text and column on Hamburger Page ")
    @Test
    public void verifyHamburgerPageSectionLineUp() {
        boolean  isResult = hamburgerPage.hamburgerPageSectionLineUp();
        Assert.assertTrue(isResult, "Section Line-up text and column is not present in Hamburger Page :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-189 :This test case will Verify Preview of Icon on Hamburger Page ")
    @Test
    public void verifyPreviewOfIconOnHamburgerPage() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPreviewOfIconOnHamburgerPage", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = CollectionPage.createAndPublishPageSection(paramsMap.get("sectionName") + urlIndex,paramsMap.get("sectionAlias") + generatedString);
        Assert.assertTrue(isResult, "Create and Publish page section not verified :" + property);

        isResult = hamburgerPage.hamburgerPagePreviewOfIcon(paramsMap.get("sectionName") + urlIndex);
        Assert.assertTrue(isResult, "Preview of Icon is not working on Hamburger Page :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-190 :This test case will Verify delete section name on Hamburger Page after and drop ")
    @Test
    public void verifyDragAndDropAndDeleteOnHamburgerPage() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDragAndDropAndDeleteOnHamburgerPage", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = CollectionPage.createAndPublishPageSection(paramsMap.get("sectionName") + urlIndex,paramsMap.get("sectionAlias") + generatedString);
        Assert.assertTrue(isResult, "Create and Publish page section not verified :" + property);

        isResult = hamburgerPage.dragAndDropDelete(paramsMap.get("type"), paramsMap.get("sectionName") + urlIndex);
        Assert.assertTrue(isResult, "section name not deleted after drag and drop :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-195 :This test case will Verify Up and down position after drag and drop on hamburger page ")
    @Test
    public void verifyUpAndDownPositionOnHamburgerPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyUpAndDownPositionOnHamburgerPage", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = hamburgerPage.upAndDownPosition(paramsMap.get("pageSectionName") + urlIndex,paramsMap.get("pageSectionAlias") + generatedString,paramsMap.get("pageSectionName1") + urlIndex,paramsMap.get("pageSectionAlias1") + generatedString);
        Assert.assertTrue(isResult, "Up and Down position not verified :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-704 ,QAAUT-194 ,QAAUT-705 :This test case will Verify Drag And Drop and published on Hamburger Page")
    @Test
    public void verifyPublishOnHamburgerPage() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPublishOnHamburgerPage", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        isResult = CollectionPage.createAndPublishPageSection(paramsMap.get("sectionName") + urlIndex,paramsMap.get("sectionAlias") + generatedString);
        Assert.assertTrue(isResult, "Create and Publish page section not verified :" + property);

        isResult = hamburgerPage.publishHamburgerPage(paramsMap.get("type"),paramsMap.get("sectionName") + urlIndex);
        Assert.assertTrue(isResult, "Published on Hamburger Page not verify :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-186 :This test case will Verify Section Line-up text and column on Hamburger Page ")
    @Test
    public void verifyAllTopicsAndSectionOnHamburgerPage() {
        boolean  isResult = hamburgerPage.allTopicsAndSection();
        Assert.assertTrue(isResult, "All Topics And Section text and column is not present in Hamburger Page :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-121 :This test case will create external page, Drag And Drop and published and edit refresh page on Hamburger Page")
    @Test
    public void verifyCreatePublishAndEditRefreshPageOnHamburgerPage() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyCreatePublishAndEditRefreshPageOnHamburgerPage", property);

        String num = globalVars.getCurrentTimeStamp();

        isResult = CollectionPage.createAndPublishPageSection(paramsMap.get("sectionName") + num, paramsMap.get("sectionAlias") + num);
        Assert.assertTrue(isResult, "Create and Publish page section not verified :" + property);

        isResult = hamburgerPage.publishHamburgerPage(paramsMap.get("type"), paramsMap.get("sectionName") + num);
        Assert.assertTrue(isResult, "Published on Hamburger Page not verify :" + property);

        isResult = hamburgerPage.editAndRefreshPage(paramsMap.get("sectionName") + num);
        Assert.assertTrue(isResult, "edit and refresh page on Hamburger Page not verify :" + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() { commonFunctions.closeAllWindowsExceptMasterTabOnly();}


}

