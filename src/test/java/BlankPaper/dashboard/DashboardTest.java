package BlankPaper.dashboard;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class DashboardTest {

    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    GlobalVars globalVars;

    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property=property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = DashboardPage.getInstance();
        dashboardPage.domainSelection(this.property);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.navigateToHomePageDashboard();
    }


    @Author(name = "Deepesh Saini")
    @Test()
    public void verifyStoriesExistenceInDashboardOfEachDomain() {
        boolean isResult;
        ArrayList<String> arrayElement = dashboardPage.getDropDownDomain();
        for (String traverseElement : arrayElement) {
            dashboardPage.domainSelection(traverseElement);
            isResult = dashboardPage.verifyStroiesExistanceInDashboard();
            Assert.assertTrue(isResult, "failed to verify stories existence for domain : " + traverseElement);
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-4910: Verify that the user is able to select Livehindustan Affiliate on Blankpaper")
    @Test()
    public void verifyThatTheUserIsAbleToSelectLivehindustanAffiliateOnBlankpaper() {
        if (this.property.equals("Live Hindustan Affiliate")) {
        boolean isResult;
        isResult = dashboardPage.checkUserIsAbleToSelectLivehindustanAffiliate();
        Assert.assertTrue(isResult, "The user is not able to select Livehindustan Affiliate on Blankpaper");
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5276,5462,5598 - Verify that user is able see the Dashboard as selected after redirecting to the homepage")
    @Test()
    public void verifyThatUserIsAbleSeeTheDashboardAsSelectedAfterRedirectingToTheHomepage() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatUserIsAbleSeeTheDashboardAsSelectedAfterRedirectingToTheHomepage", property);
        isResult = dashboardPage.checkIfUserIsAbleSeeTheDashboardAsSelectedAfterRedirectingToTheHomepage( paramsMap.get("urlSpace"));
        Assert.assertTrue(isResult, "failed to verify of landing on home page.");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5277,5463,5599 - Verify that user is able to select tenants from drop downs")
    @Test()
    public void verifyThatUserIsAbleToSelectTenantsFromDropDowns() {
        boolean isResult;
        isResult = dashboardPage.checkIfUserIsAbleToSelectTenantsFromDropDowns(property);
        Assert.assertTrue(isResult, "failed to verify of selecting the desired tenant");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5278 - Verify that user is able to see All Stories & My Workspace Tab on dashboard")
    @Test()
    public void verifyThatUserIsAbleToSeeAllStoriesAndMyWorkspaceTabOnDashboard() {
        boolean isResult;
        isResult = dashboardPage.checkIfUserIsAbleToSeeAllStoriesAndMyWorkspaceTabOnDashboard();
        Assert.assertTrue(isResult, "failed to verify presence of all sotries and My workspace");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5301,5464 - Verify that if the user is able to see All stories Tab pre selected on dashboard")
    @Test()
    public void verifyIfTheUserIsAbleToSeeAllStoriesTabPreSelectedOnDashboard() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyIfTheUserIsAbleToSeeAllStoriesTabPreSelectedOnDashboard", property);
        isResult = dashboardPage.checkIfUserIsAbleToSeeAllStoriesTabPreSelectedOnDashboard(paramsMap.get("defaultOpeningTab"));
        Assert.assertTrue(isResult, "failed to verify if all stories tab pre selected or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5302,5465 - VerifyThatIfTheUserIsAbleToSeeTableOfAllStoriesTab")
    @Test()
    public void VerifyThatIfTheUserIsAbleToSeeTableOfAllStoriesTab() {
        boolean isResult;
        isResult=dashboardPage.checkIfUserIsAbleToSeeTableOfAllStoriesTab();
        Assert.assertTrue(isResult, "failed to verify table present or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5303,5466 - Verify that user is able see 7 columns in the table")
    @Test()
    public void verifyThatUserIsAbleSeeSevenColumnsInTheTable() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatUserIsAbleSeeSevenColumnsInTheTable", property);
        isResult = dashboardPage.checkIfUserIsAbleSeeSevenColumnsInTheTable(
                paramsMap.get("headingOne"),paramsMap.get("headingTwo"),paramsMap.get("headingThree"),
                paramsMap.get("headingFour"),paramsMap.get("headingFive"),paramsMap.get("headingSix"),
                paramsMap.get("headingSeven"));
        Assert.assertTrue(isResult, "failed to verify table headings");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5304,5467 - Verify that the status of story should be published if user published the story")
    @Test()
    public void verifyThatTheStatusOfStoryShouldBePublishedIfUserPublishedTheStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatTheStatusOfStoryShouldBePublishedIfUserPublishedTheStory", property);
        isResult=dashboardPage.checkIfTheStatusOfStoryIsPublishedIfUserPublishedTheStory(paramsMap.get("requiredStatus"));
        Assert.assertTrue(isResult, "failed to verify status of story");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5305 - Verify that text Published should be clickable")
    @Test()
    public void VerifyThatTextPublishedShouldBeClickable() {
        boolean isResult;
        isResult=dashboardPage.checkIfTextPublishedShouldBeClickable();
        Assert.assertTrue(isResult, "failed to verify published text clickable or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5306 - Verify that text Published should be clickable & redirected to frontend story link")
    @Test()
    public void verifyThatTextPublishedShouldBeClickableAndRedirectedToFrontendStoryLink() {
        boolean isResult;
        isResult=dashboardPage.CheckIfTextPublishedIseClickableAndRedirectedToFrontendStoryLink();
        Assert.assertTrue(isResult, "failed to verify published text click redirection working or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5307 - Verify that Link Out icon should be present if the story status is published")
    @Test()
    public void VerifyThatLinkOutIconShouldBePresentIfTheStoryStatusIsPublished() {
        boolean isResult;
        isResult=dashboardPage.CheckIfLinkOutIconIsPresentIfTheStoryStatusIsPublished();
        Assert.assertTrue(isResult, "failed to verify Link out icon present or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5308 - Verify that Link Out icon should be present after Published text if the story status is published")
    @Test()
    public void verifyThatLinkOutIconShouldBePresentAfterPublishedTextIfTheStoryStatusIsPublished() {
        boolean isResult;
        isResult=dashboardPage.CheckIfIconIsPresentAfterPublishedTextIfTheStoryStatusIsPublished();
        Assert.assertTrue(isResult, "failed to verify Link out icon present after published text or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5309 - Verify that link out icon should be clickable")
    @Test()
    public void verifyThatLinkOutIconShouldBeClickable() {
        boolean isResult;
        isResult=dashboardPage.checkIfLinkOutIconIsClickable();
        Assert.assertTrue(isResult, "failed to verify Link out icon clickable or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5310 - Verify that text Published should be clickable & redirected to frontend story link")
    @Test()
    public void verifyThatLinkOutIconShouldBeClickableAndRedirectedToFrontendStoryLink() {
        boolean isResult;
        isResult=dashboardPage.CheckIfLinkOutIconIsClickableAndRedirectedToFrontendStoryLink();
        Assert.assertTrue(isResult, "failed to verify Link out icon redirection working or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5311 - Verify that URL of link out icon of particular published story & generated URL of that published story should be same")
    @Test()
    public void verifyThatLinkOutRedirectingUrlAndGeneratedUrlInStoryInformationSectionAreSame() {
        boolean isResult;
        isResult=dashboardPage.CheckIfLinkOutRedirectingUrlAndGeneratedUrlInStoryInformationSectionAreSame();
        Assert.assertTrue(isResult, "failed to verify links matched or not");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5312 - verifyThatTheStatusOfStoryShouldBeCreatedIfUserCreatedTheStory")
    @Test()
    public void verifyThatTheStatusOfStoryShouldBeCreatedIfUserCreatedTheStory() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatTheStatusOfStoryShouldBeCreatedIfUserCreatedTheStory", property);
        isResult=dashboardPage.CheckIfStatusOfStoryShouldBeCreatedIfUserCreatedTheStory(paramsMap.get("requiredStatus"));
        Assert.assertTrue(isResult, "failed to verify created status");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5313 - verifyThatLinkOutIconShouldNotPresentIfTheStoryStatusIsCreated")
    @Test()
    public void verifyThatLinkOutIconShouldNotPresentIfTheStoryStatusIsCreated() {
        boolean isResult;
        isResult=dashboardPage.CheckIfLinkOutIconNotPresentIfTheStoryStatusIsCreated();
        Assert.assertTrue(isResult, "failed to verify created status");
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5468 - VerifyThatTheBackgroundColorOfPublishedTextIsSameAsTextColor")
    @Test()
    public void VerifyThatTheBackgroundColorOfPublishedTextIsSameAsTextColor() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("VerifyThatTheBackgroundColorOfPublishedTextIsSameAsTextColor", property);
        isResult=dashboardPage.CheckIfTheBackgroundColorOfPublishedTextIsSameAsTextColor(paramsMap.get("backgroundColor"),paramsMap.get("textColor"));
        Assert.assertTrue(isResult, "failed to verify text color and background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5469 - verifyThatGreenBackgroundColorShouldBePresentAroundPublishedText")
    @Test()
    public void verifyThatGreenBackgroundColorShouldBePresentAroundPublishedText() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatGreenBackgroundColorShouldBePresentAroundPublishedText", property);
        isResult=dashboardPage.CheckIfGreenBackgroundColorIsPresentAroundPublishedText(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to verify published status background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5471 - VerifyThatTheBackgroundColorOfCreatedTextIsSameAsTextColor")
    @Test()
    public void VerifyThatTheBackgroundColorOfCreatedTextIsSameAsTextColor() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("VerifyThatTheBackgroundColorOfCreatedTextIsSameAsTextColor", property);
        isResult=dashboardPage.CheckIfTheBackgroundColorOfCreatedTextIsSameAsTextColor(paramsMap.get("backgroundColor"),paramsMap.get("textColor"));
        Assert.assertTrue(isResult, "failed to verify text color and background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5472 - verifyThatOrangeBackgroundColorShouldBePresentAroundCreatedText")
    @Test()
    public void verifyThatOrangeBackgroundColorShouldBePresentAroundCreatedText() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatOrangeBackgroundColorShouldBePresentAroundCreatedText", property);
        isResult=dashboardPage.CheckIfOrangeBackgroundColorIsPresentAroundCreatedText(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to verify created status background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5474 - verifyThatTheBackgroundColorOfEditedTextIsSameAsTextColor")
    @Test()
    public void verifyThatTheBackgroundColorOfEditedTextIsSameAsTextColor() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatTheBackgroundColorOfEditedTextIsSameAsTextColor", property);
        isResult=dashboardPage.CheckIfTheBackgroundColorOfEditedTextIsSameAsTextColor(paramsMap.get("backgroundColor"),paramsMap.get("textColor"));
        Assert.assertTrue(isResult, "failed to verify text color and background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5475 - verifyThatBlueBackgroundColorShouldBePresentAroundEditedText")
    @Test()
    public void verifyThatBlueBackgroundColorShouldBePresentAroundEditedText() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatBlueBackgroundColorShouldBePresentAroundEditedText", property);
        isResult=dashboardPage.CheckIfBlueBackgroundColorShouldBePresentAroundEditedText(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to verify edited status background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5479 - verifyThatUserIsAbleToSelectTenantsMintGenieOrHtNewFromDropDowns")
    @Test()
    public void verifyThatUserIsAbleToSelectTenantsMintGenieFromDropDowns() {
        boolean isResult;
        if (this.property.equals("MintGenie")) {
            Map<String, String> paramsMap=globalVars.getParamsData("verifyThatUserIsAbleToSelectTenantsMintGenieFromDropDowns", property);
            isResult=dashboardPage.CheckIfUserIsAbleToSelectTenantsMintGenieOrHtNewFromDropDowns(property);
            Assert.assertTrue(isResult, "failed to select the required tenants");
        }
        else Utils.logStepInfo(true, "This Test case is valid only for MintGenie Domain!!! but currently selected domain is "+ property);

    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5494 - verifyThatTheBackgroundColorOfFiledTextIsSameAsTextColor")
    @Test()
    public void verifyThatTheBackgroundColorOfFiledTextIsSameAsTextColor() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatTheBackgroundColorOfFiledTextIsSameAsTextColor", property);
        isResult=dashboardPage.CheckIfTheBackgroundColorOfFiledTextIsSameAsTextColor(paramsMap.get("backgroundColor"),paramsMap.get("textColor"));
        Assert.assertTrue(isResult, "failed to verify text color and background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5495 - verifyThatPurpleBackgroundColorShouldBePresentAroundFiledText")
    @Test()
    public void verifyThatPurpleBackgroundColorShouldBePresentAroundFiledText() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatPurpleBackgroundColorShouldBePresentAroundFiledText", property);
        isResult=dashboardPage.CheckIfPurpleBackgroundColorShouldBePresentAroundFiledText(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to verify Filed status background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5497 - verifyThatGreyBackgroundColorShouldBePresentAroundKilledText")
    @Test()
    public void verifyThatGreyBackgroundColorShouldBePresentAroundKilledText() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatGreyBackgroundColorShouldBePresentAroundKilledText", property);
        isResult=dashboardPage.CheckIfGreyBackgroundColorShouldBePresentAroundKilledText(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to verify Killed status background color");
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5573 - verifyThatUserIsAbleToSelectTenantsBanglaFromDropDowns")
    @Test()
    public void verifyThatUserIsAbleToSelectTenantsBanglaFromDropDowns() {
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = dashboardPage.checkIfUserIsAbleToSelectTenantsBanglaFromDropDowns(this.property);
            Assert.assertTrue(isResult, "failed to verify selected domain : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }

    @Author(name = "seshasai voggu")
    @Description("QAAUT5574 - verifyThatUserIsAbleToClickOnCreateStoryButtonForBangla")
    @Test()
    public void verifyThatUserIsAbleToClickOnCreateStoryButtonForBangla() {
        boolean isResult;
        if (this.property.equals("Bangla")) {
            isResult = dashboardPage.checkIfUserIsAbleToClickOnCreateStoryButtonForBangla();
            Assert.assertTrue(isResult, "failed to click on create story button : " + property);
        }
        else Utils.logStepInfo(true, "This Test case is valid only for Bangla Domain!!! but currently selected domain is "+ property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5636 - verifyThatUserIsAbleToSeePagesTabPresentInSidebar")
    @Test()
    public void verifyThatUserIsAbleToSeePagesTabPresentInSidebar() {
        boolean isResult;
        isResult = dashboardPage.checkIfUserIsAbleToSeePagesTabPresentInSidebar();
        Assert.assertTrue(isResult, "failed to check pages tab on the dashboard : " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5637 - verifyThatUserIsAbleToClickPagesTabPresentInSidebar")
    @Test()
    public void verifyThatUserIsAbleToClickPagesTabPresentInSidebar() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatUserIsAbleToClickPagesTabPresentInSidebar", property);
        isResult = dashboardPage.checkIftUserIsAbleToClickPagesTabPresentInSidebar(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to check pages tab is clicked on the dashboard : " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5638 - verifyThatUserIsAbleToClickOnCreateAPageButtonPresentInTheRightCorner")
    @Test()
    public void verifyThatUserIsAbleToClickOnCreateAPageButtonPresentInTheRightCorner() {
        boolean isResult;
        isResult = dashboardPage.checkIfUserIsAbleToClickOnCreateAPageButtonPresentInTheRightCorner();
        Assert.assertTrue(isResult, "failed to click create pages button: " + property);
    }


    @Author(name = "seshasai voggu")
    @Description("QAAUT5667 - verify That User Is Able To Click On Dashboard Tab")
    @Test()
    public void verifyThatUserIsAbleToClickOnDashboardTab() {
        boolean isResult;
        Map<String, String> paramsMap=globalVars.getParamsData("verifyThatUserIsAbleToClickOnDashboardTab", property);
        isResult = dashboardPage.checkIfUserIsAbleToClickOnDashboardTab(paramsMap.get("backgroundColor"));
        Assert.assertTrue(isResult, "failed to click create pages button: " + property);
    }
    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

}
