package BlankPaper.stories;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.beust.jcommander.Parameter;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonCollectionPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonStandardStoryPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.pages.BlankPaper.webdesktop.stories.CollectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import java.util.Random;

public class CollectionTest {

    private static CommonCollectionPage collectionPage;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonStandardStoryPage standardStoryPage;
    SoftAssert softAssert = new SoftAssert();

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
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickOnAllElement();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-128 :This test case will create a Standard story and publish them and verify filters")
    @Test(priority = -1)
    public void verifyFilters() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyFilters" ,  property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String headline = paramsMap.get("headline")+ urlIndex;

        if(!globalVars.isProdRun()) {
            isResult=dashboardPage.navigateToHomePageDashboard();
            Assert.assertTrue(isResult, "Dashboard Pge is not Displayed : " + property);
            isResult = standardStoryPage.createStoryAndVerify(headline, paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        }
        isResult= collectionPage.createElementButton();
        Assert.assertTrue(isResult,"Create Element Create Collection not Displayed :" + property);

        isResult = collectionPage.domainFilter(headline,this.property);
        softAssert.assertTrue(isResult, "Domain Filter not Filtered: " + property);

        isResult = collectionPage.byLineFilter(paramsMap.get("byline"), headline);
        softAssert.assertTrue(isResult, "ByLine Filter not Filtered: " + property);

        isResult = collectionPage.createdOnFilter(headline);
        softAssert.assertTrue(isResult, "Created On Filter not Filtered: " + property);

        isResult = collectionPage.typeFilter(headline, paramsMap.get("type"));
        softAssert.assertTrue(isResult, "Type Video not Filtered: " + property);

        isResult = collectionPage.sectionFilter(headline, paramsMap.get("section"));
        softAssert.assertTrue(isResult, "Section not Filtered: " + property);

        isResult = collectionPage.categoryFilter(headline, paramsMap.get("category"));
        softAssert.assertTrue(isResult, "Type Video not Filtered: " + property);

        isResult = collectionPage.topicsFilter(headline,paramsMap.get("topic") ,this.property);
        softAssert.assertTrue(isResult, "Topic not Filtered:" + property);

        isResult = collectionPage.locationFilter(headline,paramsMap.get("location"),this.property);
        softAssert.assertTrue(isResult, "Topic not Filtered:" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-129 :This test case will verify DropDown As Story & Page")
    @Test
    public void verifyDropDownAsStoryAndPage() {
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDropDownAsStoryAndPage" ,  property);

        boolean  isResult = collectionPage.dropDown(paramsMap.get("story"), paramsMap.get("page"));
        Assert.assertTrue(isResult, "DropDown as Story and Page not Displayed :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-132: This test case will verify drag & drop stories")
    @Test
    public void verifyDragAndDropStories() {
        boolean  isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDragAndDropStories" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String headline = paramsMap.get("headline")+ urlIndex;
        if(!globalVars.isProdRun()) {
            isResult = dashboardPage.navigateToHomePageDashboard();
            Assert.assertTrue(isResult, "Dashboard Pge is not Displayed : " + property);
            isResult = standardStoryPage.createStoryAndVerify(headline, paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
            isResult = dashboardPage.clickOnAllElement();
            Assert.assertTrue(isResult, "Click on all Element failed !!! : " + property);
            isResult= collectionPage.createCollectionStatus(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section1"),paramsMap.get("subsection1"));
            Assert.assertTrue(isResult, "Collection creation failed !!! : " + property);
        }
        isResult= collectionPage.dragAndDropStories();
        Assert.assertTrue(isResult, "Story drag and drop failed !!! : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-497: This test case will verify drag & drop stories Delete")
    @Test
    public void verifyDragAndDropStoriesDelete() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDragAndDropStoriesDelete" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String headline = paramsMap.get("headline")+ urlIndex;
        if(!globalVars.isProdRun()) {
            isResult= dashboardPage.navigateToHomePageDashboard();
            Assert.assertTrue(isResult, "Dashboard Pge is not Displayed : " + property);
            isResult = standardStoryPage.createStoryAndVerify(headline, paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);
            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        }
        isResult = dashboardPage.clickOnAllElement();
        Assert.assertTrue(isResult, "Click on all Element failed !!! : " + property);
        isResult= collectionPage.createCollectionStatus(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section"),paramsMap.get("subsection"));
        Assert.assertTrue(isResult, "Collection creation failed !!! : " + property);
        isResult= collectionPage.dragAndDropStories();
        Assert.assertTrue(isResult, "Story drag and drop failed !!! : " + property);
        isResult = collectionPage.deleteStoryFromCollection();
        Assert.assertTrue(isResult, "Story deletion from collection failed :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-137 :This test case will Verify Create Collection Status")
    @Test
    public void verifyCreateCollectionStatus() {
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreateCollectionStatus" , property);

        boolean isResult = collectionPage.createCollectionStatus(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section"),paramsMap.get("subsection"));
        Assert.assertTrue(isResult, "Created Collection not Displayed :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-135 :This test case will Verify Create Collection Status and Discard the Elements")
    @Test
    public void verifyDiscardElement() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyDiscardElement" , property);
        if(!globalVars.isProdRun()) {
            isResult = collectionPage.createCollectionStatus(paramsMap.get("name"), paramsMap.get("tags"), paramsMap.get("URL"), paramsMap.get("section"), paramsMap.get("subsection"));
            Assert.assertTrue(isResult, "Created Collection not Displayed :" + property);
        }

        isResult = dashboardPage.findAndDiscardElement(CollectionPage.collectionId);
        Assert.assertTrue(isResult, "Element not Discarded :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-136 :This test case will Verify Create Collection Status and Verify Collection Publish Status")
    @Test
    public void verifyCollectionPublishStatus() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCollectionPublishStatus" , property);

        isResult = collectionPage.createCollectionStatus(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section"),paramsMap.get("subsection"));
        Assert.assertTrue(isResult, "Created Collection not Displayed :" + property);

        isResult = collectionPage.publishCreateCollection();
        Assert.assertTrue(isResult, "Created Collection not Published :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-131 :This test case will Verify Create Collection Metadata Section")
    @Test
    public void verifyMetadataSection() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyMetadataSection" , property);

        isResult= collectionPage.metadataName(paramsMap.get("name"));
        softAssert.assertTrue(isResult, "Name not Selected:" + property);

        isResult= collectionPage.metadataTags(paramsMap.get("tags"));
        softAssert.assertTrue(isResult, "Tags not Selected:" + property);

        isResult= collectionPage.metadataExternalURL(paramsMap.get("URL"));
        softAssert.assertTrue(isResult, "External URL not Selected:" + property);

        isResult= collectionPage.metadataSection(paramsMap.get("section"),this.property);
        softAssert.assertTrue(isResult, "Section not Selected:" + property);

        isResult= collectionPage.metadataSubsection(paramsMap.get("subsection"),this.property);
        softAssert.assertTrue(isResult, "Sub-section not Selected:" + property);
        //DiscardElement() function call is made to ensure that the junk data gets cleared
        //collectionPage.discardCollection();

        //softAssert.assertTrue(isResult, "Collection deletion failed !!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-133: This test case will verify drag & drop stories Up And Down Position")
    @Test
    public void verifyStoriesUpAndDownPosition() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyStoriesUpAndDownPosition" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        int urlIndex1 = randomNo.nextInt(100);
        if(!globalVars.isProdRun()) {
            isResult = dashboardPage.navigateToHomePageDashboard();
            Assert.assertTrue(isResult, "Dashboard Page is not Displayed : " + property);

            isResult = standardStoryPage.createStoryAndVerify(paramsMap.get("headline") + urlIndex, paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);

            isResult = standardStoryPage.createStoryAndVerify(paramsMap.get("headline") + urlIndex1, paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topic"));
            Assert.assertTrue(isResult, "Standard Story is not created : " + property);

            isResult = standardStoryPage.publishStory();
            Assert.assertTrue(isResult, "Standard Story is not published : " + property);
        }

        isResult = collectionPage.storiesUpAndDownPosition(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section"),paramsMap.get("subsection"));
        Assert.assertTrue(isResult, "Up And Down Story Fail : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-138: This test case will verify drag & drop stories Up And Down Position")
    @Test
    public void verifyCollectionEditStatus() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCollectionEditStatus" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);

        isResult = collectionPage.createCollectionStatus(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section"),paramsMap.get("subsection"));
        Assert.assertTrue(isResult, "Created Collection not Displayed :" + property);

        isResult = collectionPage.editStatus(paramsMap.get("editName")+ urlIndex);
        Assert.assertTrue(isResult, "Collection edit status not Displayed :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-83: This test case will verify Collection Create, Publish and edit and refresh page")
    @Test
    public void verifyCreatePublishEditRefreshPage() {
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCreatePublishEditRefreshPage" , property);

        boolean isResult = collectionPage.createPublishEditRefreshPage(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section"),paramsMap.get("subsection"),paramsMap.get("editName"),this.property);
        Assert.assertTrue(isResult, "After refresh Page Data is lost in CreatePublishEditRefreshPage :" + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-134: This test case will verify Preview stories")
    @Test
    public void verifyPreviewStories() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyPreviewStories" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(1000);
        String headline = paramsMap.get("headline")+urlIndex;

        isResult = dashboardPage.navigateToHomePageDashboard();
        Assert.assertTrue(isResult, "Dashboard Page is not Displayed : " + property);

        isResult = standardStoryPage.createStoryAndVerify(headline, paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = collectionPage.previewStories(headline);
        Assert.assertTrue(isResult, "Preview story not verified : " + property);
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-139: This test case will verify Cancel Button")
    @Test
    public void verifyCancelButton() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyCancelButton" , property);
        Random randomNo = new Random();
        int urlIndex = randomNo.nextInt(10000);
        String pageSectionName = paramsMap.get("pageSectionName")+ urlIndex;

        isResult = dashboardPage.navigateToHomePageDashboard();
        Assert.assertTrue(isResult, "Dashboard Page is not Displayed : " + property);

        isResult = standardStoryPage.createStoryAndVerify(paramsMap.get("headline")+urlIndex, paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"),paramsMap.get("topic"));
        Assert.assertTrue(isResult, "Standard Story is not created : " + property);

        isResult = standardStoryPage.publishStory();
        Assert.assertTrue(isResult, "Standard Story is not published : " + property);

        isResult = collectionPage.createAndPublishPageSection(pageSectionName,paramsMap.get("PageSectionAlias")+ urlIndex);
        Assert.assertTrue(isResult, "Page Section not Created : " + property);

        isResult = collectionPage.cancelButton(paramsMap.get("name"),paramsMap.get("tags"),paramsMap.get("URL"),paramsMap.get("section"),paramsMap.get("subsection"), pageSectionName);
        Assert.assertTrue(isResult, "Cancel Button not verified : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3115: Add option to include product Widgets on HT Auto and Tech")
    @Test
    public void verifyAddOptionToIncludeProductWidgetsOnHtAutoOrTech() {
        if (this.property.equals("Tech")) {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyAddOptionToIncludeProductWidgetsOnHtAutoOrTech" , property);
        Random randomNo = new Random();
        int ranNum = randomNo.nextInt(10000);
        String collectionName = "Automation"+ ranNum;
        isResult = collectionPage.verifyAddOptionToIncludeProductWidgetsOnHtAutoOrTech(collectionName, paramsMap.get("FirstDropdown"), paramsMap.get("SecoundDropdown"), paramsMap.get("ThirdDropdown"));
        Assert.assertTrue(isResult, "Cancel Button not verified : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3060: Toggle switches should be present APP and AMP.")
    @Test
    public void verifyToggleSwitchesShouldBePresentAppAndAmp() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = collectionPage.checkToggleSwitchesShouldBePresentAppAndAmp();
        Assert.assertTrue(isResult, "Toggle switches are not present APP and AMP. : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3061: By default both the buttons should in ON position")
    @Test
    public void verifyByDefaultBothTheButtonsShouldInOnPosition() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyByDefaultBothTheButtonsShouldInOnPosition" , property);
        isResult = collectionPage.checkByDefaultBothTheButtonsShouldInOnPosition(paramsMap.get("BgColorHexCode"));
        Assert.assertTrue(isResult, "By default both the buttons are not in ON position : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3062: User should be able to select one or none from both the options available.")
    @Test
    public void verifyUserShouldBeAbleToSelectOneOrNoneFromBothTheOptionsAvailable() {
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyUserShouldBeAbleToSelectOneOrNoneFromBothTheOptionsAvailable" , property);
        isResult = collectionPage.checkAbleToSelectOneOrNoneFromBothTheOptions(paramsMap.get("AppBgColorHexCodeBeforeSelect"), paramsMap.get("AppBgColorHexCodeAfterSelect"), paramsMap.get("AmpBgColorHexCodeBeforeSelect"), paramsMap.get("AmpBgColorHexCodeAfterSelect"));
        Assert.assertTrue(isResult, "User is not able to select one or none from both the options available. : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-4973-Livehindustan Affiliate on Blankpaper")
    @Test
    public void createACollectionOnLiveHindustanAffiliate() {
        boolean isResult;
        if (this.property.equals("Live Hindustan Affiliate")) {
            Map<String, String> paramsMap = globalVars.getParamsData("createACollectionOnLiveHindustanAffiliate", property);
            isResult = collectionPage.createACollectionOnLiveHindustanAffiliateAndPublish(paramsMap.get("name"), paramsMap.get("tag"), paramsMap.get("url"));
            Assert.assertTrue(isResult, "creation of Collection failed");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Hindustan Affiliate Domain!!! but currently selected domain is "+ property);

    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-4974-Livehindustan Affiliate on Blankpaper-Create Embed")
    @Test
    public void createAnEmbedOnLiveHindustanAffiliate() {
        boolean isResult;
        if (this.property.equals("Live Hindustan Affiliate")) {
            Map<String, String> paramsMap = globalVars.getParamsData("createAnEmbedOnLiveHindustanAffiliate", property);
            isResult = collectionPage.createAnEmbedCollectionOnLiveHindustanAffiliateAndPublish(paramsMap.get("name"), paramsMap.get("codeForTweets"), paramsMap.get("codeForDarkMode"));
            Assert.assertTrue(isResult, "creation of Embed Collection failed");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Hindustan Affiliate Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-4976-LiveHindustan Affiliate on BlankPaper-Create Input form")
    @Test
    public void createInputFormOnLiveHindustanAffiliate() {
        boolean isResult;
        if (this.property.equals("Live Hindustan Affiliate")) {
            Map<String, String> paramsMap = globalVars.getParamsData("createInputFormOnLiveHindustanAffiliate", property);
            isResult = collectionPage.createInputFormOnLiveHindustanAffiliateAndPublish(paramsMap.get("name"), paramsMap.get("topicName"), paramsMap.get("topicURL"));
            Assert.assertTrue(isResult, "creation of Input Form Collection failed");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Hindustan Affiliate Domain!!! but currently selected domain is "+ property);

    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-4978-LiveHindustan Affiliate on BlankPaper-Create Chart")
    @Test
    public void createChartOnLiveHindustanAffiliate() {
        boolean isResult;
        if (this.property.equals("Live Hindustan Affiliate")) {
            Map<String, String> paramsMap = globalVars.getParamsData("createChartOnLiveHindustanAffiliate", property);
            isResult = collectionPage.createChartOnLiveHindustanAffiliateAndPublish(paramsMap.get("name"));
            Assert.assertTrue(isResult, "creation of Input Form Collection failed");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Hindustan Affiliate Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT-4979-LiveHindustan Affiliate on BlankPaper-Create Table")
    @Test
    public void createTableOnLiveHindustanAffiliateAndPublish() {
        boolean isResult;
        if (this.property.equals("Live Hindustan Affiliate")) {
            Map<String, String> paramsMap = globalVars.getParamsData("createTableOnLiveHindustanAffiliateAndPublish", property);
            isResult = collectionPage.createTableOnLiveHindustanAffiliateAndPublish(paramsMap.get("name"));
            Assert.assertTrue(isResult, "creation of Input Form Collection failed");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Live Hindustan Affiliate Domain!!! but currently selected domain is "+ property);
    }
    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    @AfterTest
    public void cleanup(ITestContext context) {
        if (globalVars.isProdRun()) {
            dashboardPage.clickOnAllElement();
            dashboardPage.elementCleanup(CollectionPage.collectionId);
        } else {
            System.out.println("no cleanup done for staging env!!!");
        }
    }


}