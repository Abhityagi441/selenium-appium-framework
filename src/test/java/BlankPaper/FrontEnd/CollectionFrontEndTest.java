package BlankPaper.FrontEnd;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonCollectionPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonStandardStoryPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Map;
import java.util.Random;

public class CollectionFrontEndTest  {

    private static CommonCollectionPage collectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonStandardStoryPage standardStoryPage;
    private static CommonFrontEndPage commonFrontEndPage;
    public static String collectionName;
    public static String id;
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
        collectionPage = CommonCollectionPage.getInstance();
        standardStoryPage = CommonStandardStoryPage.getInstance();
        commonFrontEndPage = CommonFrontEndPage.getInstance(this.property);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
    }


    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1166: This test case will verify drag & drop stories and verify on Frontend")
    @Test
    public void verifyStoriesUpdatingOnFrontend() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyStoriesUpdatingOnFrontend", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headline = paramsMap.get("headline") + urlIndex;
        String headline1 = paramsMap.get("headline1") + urlIndex;
        collectionName = paramsMap.get("name") + urlIndex;
        id= paramsMap.get("id");
        String summary = paramsMap.get("summary") + urlIndex;
        String summary1 = paramsMap.get("summary1") + urlIndex;

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = dashboardPage.clickOnAllElement();
        Assert.assertTrue(isResult, "Click on all Element failed !!! : " + property);

        isResult = collectionPage.createCollectionStatus(collectionName, paramsMap.get("tags"), paramsMap.get("URL"), paramsMap.get("section1"), paramsMap.get("subsection1"));
        Assert.assertTrue(isResult, "Collection creation failed !!! : " + property);

        isResult = collectionPage.dragAndDropFirstStoriesAndPublish(headline);
        Assert.assertTrue(isResult, "First Story drag and drop failed !!! : " + property);

        isResult = collectionPage.pagesPublishCollection(id,collectionName,headline);
        Assert.assertTrue(isResult, "collection drag and drop  and publish failed !!! : " + property);

        isResult = commonFrontEndPage.dataValidationFirstStoriesCollectionOnFrontEnd(paramsMap.get("userAndPasswordURL"), collectionName,headline,paramsMap.get("section"),paramsMap.get("subsection"),summary,paramsMap.get("byline"),paramsMap.get("location"),paramsMap.get("paragraph"),paramsMap.get("topic"));
        Assert.assertTrue(isResult, "******* First Story data on Front End not verified ******** : " + property);

        isResult = standardStoryPage.createStoryAndVerify(headline1, summary1, paramsMap.get("paragraph1"), paramsMap.get("byline1"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location1"), paramsMap.get("topic1"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = collectionPage.dragAndDropSecondStoriesAndPublish(headline1,headline);
        Assert.assertTrue(isResult, "Second Story drag and drop failed !!! : " + property);

        isResult = commonFrontEndPage.dataValidationSecondStoriesCollectionOnFrontEnd(paramsMap.get("userAndPasswordURL"), collectionName,headline,paramsMap.get("section"),paramsMap.get("subsection"),summary1,paramsMap.get("byline1"),paramsMap.get("location1"),paramsMap.get("paragraph1"),paramsMap.get("topic1"),headline1);
        Assert.assertTrue(isResult, "******* Second Story data on Front End not verified ******** : " + property);

        isResult = collectionPage.deleteStoryFromCollection(headline1);
        Assert.assertTrue(isResult, "Delete Story failed !!! : " + property);

        isResult = commonFrontEndPage.deleteStoryFromCollectionAndCheckOnFrontEnd(paramsMap.get("userAndPasswordURL"), collectionName,headline,headline1);
        Assert.assertTrue(isResult, "******* Second Story data on Front End not verified ******** : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT: This test case will verify position Up and Down of drag & drop stories and verify on Frontend")
    @Test
    public void verifyCollectionUpAndDownPositionOnFrontend() {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyCollectionUpAndDownPositionOnFrontend", property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headline = paramsMap.get("headline") + urlIndex;
        String headline1 = paramsMap.get("headline1") + urlIndex;
        collectionName = paramsMap.get("name") + urlIndex;
        id= paramsMap.get("id");
        String summary = paramsMap.get("summary") + urlIndex;
        String summary1 = paramsMap.get("summary1") + urlIndex;

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = standardStoryPage.createStoryAndVerify(headline1, summary1, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = dashboardPage.clickOnAllElement();
        Assert.assertTrue(isResult, "Click on all Element failed !!! : " + property);

        isResult = collectionPage.createCollectionStatus(collectionName, paramsMap.get("tags"), paramsMap.get("URL"), paramsMap.get("section1"), paramsMap.get("subsection1"));
        Assert.assertTrue(isResult, "Collection creation failed !!! : " + property);

        isResult = collectionPage.dragAndDropFirstStoriesAndPublish(headline);
        Assert.assertTrue(isResult, "First Story drag and drop failed !!! : " + property);

        isResult = collectionPage.dragAndDropSecondStoriesAndPublish(headline1,headline);
        Assert.assertTrue(isResult, "Second Story drag and drop failed !!! : " + property);

        isResult = collectionPage.pagesPublishCollection(id,collectionName,headline);
        Assert.assertTrue(isResult, "collection drag and drop  and publish failed !!! : " + property);

        isResult = commonFrontEndPage.dataValidationSecondStoriesCollectionOnFrontEnd(paramsMap.get("userAndPasswordURL"), collectionName,headline,paramsMap.get("section"),paramsMap.get("subsection"),summary1,paramsMap.get("byline"),paramsMap.get("location"),paramsMap.get("paragraph"),paramsMap.get("topic"),headline1);
        Assert.assertTrue(isResult, "******* Second Story data on Front End not verified ******** : " + property);

        isResult = collectionPage.storiesUpAndDownPositionOnPages(headline,headline1,collectionName);
        Assert.assertTrue(isResult, "******* Stories Not dragged up and down ******** : " + property);

        isResult = commonFrontEndPage.dataValidationSecondStoriesPositionUpAndDownCollectionOnFrontEnd(paramsMap.get("userAndPasswordURL"),collectionName,headline,headline1);
        Assert.assertTrue(isResult, "******* Stories Not correctly positioned up and down ******** : " + property);
    }

    @Author(name = "Giridhar  Raj")
    @Description("QAAUT- 1186: This test case will verify edit collection and check on Frontend")
    @Test
    public void verifyCollectionCreatePublishEditRefreshPageWithUi() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCollectionCreatePublishEditRefreshPageWithUi" ,  property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(100000);
        String headline = paramsMap.get("headline") + urlIndex;
        String firstCollectionName = paramsMap.get("newCollectionName") + urlIndex;
        collectionName = paramsMap.get("editCollectionName") + urlIndex;
        id= paramsMap.get("id");
        String summary = paramsMap.get("summary") + urlIndex;

        isResult = standardStoryPage.createStoryAndVerify(headline, summary, paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = dashboardPage.clickOnAllElement();
        Assert.assertTrue(isResult, "Click on all Element failed !!! : " + property);

        isResult = collectionPage.createCollectionStatus(firstCollectionName, paramsMap.get("tags"), paramsMap.get("URL"), paramsMap.get("section1"), paramsMap.get("subsection1"));
        Assert.assertTrue(isResult, "Collection creation failed !!! : " + property);

        isResult = collectionPage.dragAndDropFirstStoriesAndPublish(headline);
        Assert.assertTrue(isResult, "First Story drag and drop failed !!! : " + property);

        isResult = collectionPage.pagesPublishCollection(id,firstCollectionName,headline);
        Assert.assertTrue(isResult, "collection drag and drop  and publish failed !!! : " + property);

        isResult = commonFrontEndPage.dataValidationFirstStoriesCollectionOnFrontEnd(paramsMap.get("userAndPasswordURL"), firstCollectionName,headline,paramsMap.get("section"),paramsMap.get("subsection"),summary,paramsMap.get("byline"),paramsMap.get("location"),paramsMap.get("paragraph"),paramsMap.get("topic"));
        Assert.assertTrue(isResult, "******* First Story data on Front End not verified ******** : " + property);

        isResult = collectionPage.editCollectionName(collectionName);
        Assert.assertTrue(isResult, "edit collection name and publish failed !!! : " + property);

        isResult = commonFrontEndPage.dataValidationFirstStoriesCollectionOnFrontEnd(paramsMap.get("userAndPasswordURL"), collectionName,headline,paramsMap.get("section"),paramsMap.get("subsection"),summary,paramsMap.get("byline"),paramsMap.get("location"),paramsMap.get("paragraph"),paramsMap.get("topic"));
        Assert.assertTrue(isResult, "******* First Story data on Front End not verified ******** : " + property);
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
     collectionPage.deleteCollectionOnPages(this.id, this.collectionName);
    }


}