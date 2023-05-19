package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;

import java.util.ArrayList;

public abstract class CommonDashboardPage {
    private static CommonDashboardPage commonDashboardPage;
    private static GlobalVars globalVars;

    public static CommonDashboardPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonDashboardPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonDashboardPage = new DashboardPage();
                    break;
            }
        }
        return commonDashboardPage;
    }
    public abstract void domainSelection(String domain);
    public abstract ArrayList<String> getDropDownDomain();
    public abstract boolean checkSelectedDomain(String checkItem);
    public abstract boolean verifyStroiesExistanceInDashboard();
    public abstract boolean navigateToHomePageDashboard();
    public abstract void clickOnDashboard();
    public abstract void checkStoryType(String storyType);
    public abstract void clickOnBlankPaperLogo();
    public abstract void applyTypeFilterOnDashboard(String storyTypeFilter);
    public abstract void applyStatusFilterOnDashboard(String statusFilter);
    public abstract boolean storyCleanup(String storyIdNumber);
    public abstract void searchStoryByID(String id);
    public abstract boolean openPublishedAndUnlockedStory(String storyType);
    public abstract boolean softPublishStory();
    public abstract boolean clickOnAllElement();
    public abstract boolean clickOnPages();
    public abstract boolean elementCleanup(String elementId);
    public abstract boolean discardElement();
    public abstract boolean findAndDiscardElement(String elementId);
    public abstract boolean verifyPagination();
    public abstract boolean searchElementByID(String id);
    public abstract boolean mobileAndDesktopPreview(String headline);
    public abstract boolean verifyMongoDBConnectionAndStoryDetails(String storyStatus,String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine);
    public abstract boolean verifyMongoDBConnectionAndStoryDetailsOnBackend(String storyStatus,String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, boolean expSoftPubStatus, boolean expKilledStatus);
    public abstract void clearSearch();
    public abstract boolean discardElement(String elementId);
    public abstract void applyStatusFilterOnPages(String statusFilter);
    public abstract boolean copyUrlAndHeadlineOfPublishedStory(String storyType);
    public abstract boolean killStoryAndVerify(String storyIdNumber, String storyURL);
    public abstract boolean publishedStory(String storyType);
    public abstract void  selectStoryCopyUrlOpenNewTab(String username, String password,String storyIDNumber1);
    public abstract boolean changeFirstImageCaptionName(String firstCaption);
    public abstract boolean changeSecondImageCaptionName(String secondCaption);
    public abstract boolean changeThirdImageCaptionName(String thirdCaption);
    public abstract void inputSection(String section);
    public abstract boolean checkImageAfterUploadOnStoryPage();
    public abstract void createdByFilter(String createdBy);
    public abstract boolean changeUrl(String urlHeadline,String domain);
    public abstract boolean checkUserIsAbleToSelectLivehindustanAffiliate();
    public abstract boolean clickOnReports();

    public abstract boolean clickOnUsers();
    public abstract boolean checkIfUserIsAbleSeeTheDashboardAsSelectedAfterRedirectingToTheHomepage(String urlSpace);
    public abstract boolean checkIfUserIsAbleToSelectTenantsFromDropDowns(String property);
    public abstract boolean checkIfUserIsAbleToSeeAllStoriesAndMyWorkspaceTabOnDashboard();
    public abstract boolean checkIfUserIsAbleToSeeAllStoriesTabPreSelectedOnDashboard(String defaultOpeningTab);
    public abstract boolean checkIfUserIsAbleToSeeTableOfAllStoriesTab();

    public abstract boolean checkIfUserIsAbleSeeSevenColumnsInTheTable(String headingOne, String headingTwo, String headingThree, String headingFour, String headingFive, String headingSix, String headingSeven);

    public abstract boolean checkIfTheStatusOfStoryIsPublishedIfUserPublishedTheStory(String requiredStatus);

    public abstract boolean checkIfTextPublishedShouldBeClickable();

    public abstract boolean CheckIfTextPublishedIseClickableAndRedirectedToFrontendStoryLink();

    public abstract boolean CheckIfLinkOutIconIsPresentIfTheStoryStatusIsPublished();

    public abstract boolean CheckIfIconIsPresentAfterPublishedTextIfTheStoryStatusIsPublished();

    public abstract boolean checkIfLinkOutIconIsClickable();

    public abstract boolean CheckIfLinkOutIconIsClickableAndRedirectedToFrontendStoryLink();

    public abstract boolean CheckIfLinkOutRedirectingUrlAndGeneratedUrlInStoryInformationSectionAreSame();

    public abstract boolean CheckIfStatusOfStoryShouldBeCreatedIfUserCreatedTheStory(String requiredStatus);

    public abstract boolean CheckIfLinkOutIconNotPresentIfTheStoryStatusIsCreated();
    public abstract boolean verifyMongoDBConnectionAndHeadinesOnBackend(String storyStatus,String storyID,String property, String env, String headlineFromExcel, String mobileHeadline, String browserHeadline, String facebookHeadline, String twitterHeadline);
    public abstract boolean verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend(String storyStatus,String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, String postTitle, String postBody, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus);
    public abstract boolean verifyMongoDBConnectionAndVideoStoryDetailsOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, String embedUrlExcel, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus);
    public abstract boolean verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String sectionFromExcel, String subSectionFromExcel, String deadlineUrlExcel, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus);
    public abstract boolean verifyMongoDBConnectionAndHighlightsDetailsOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, String highlightsItemExcel, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus);
    public abstract boolean CheckIfOrangeBackgroundColorIsPresentAroundCreatedText(String backgroundColor);
    public abstract boolean CheckIfGreenBackgroundColorIsPresentAroundPublishedText(String backgroundColor);
    public abstract boolean CheckIfTheBackgroundColorOfPublishedTextIsSameAsTextColor(String backgroundColor, String textColor);
    public abstract boolean CheckIfTheBackgroundColorOfCreatedTextIsSameAsTextColor(String backgroundColor, String textColor);
    public abstract boolean CheckIfTheBackgroundColorOfEditedTextIsSameAsTextColor(String backgroundColor, String textColor);
    public abstract boolean CheckIfBlueBackgroundColorShouldBePresentAroundEditedText(String backgroundColor);
    public abstract boolean CheckIfUserIsAbleToSelectTenantsMintGenieOrHtNewFromDropDowns(String property);
    public abstract boolean CheckIfTheBackgroundColorOfFiledTextIsSameAsTextColor(String backgroundColor, String textColor);
    public abstract boolean CheckIfPurpleBackgroundColorShouldBePresentAroundFiledText(String backgroundColor);
    public abstract boolean CheckIfGreyBackgroundColorShouldBePresentAroundKilledText(String backgroundColor);
    public abstract boolean checkIfUserIsAbleToSelectTenantsBanglaFromDropDowns(String property);
    public abstract boolean checkIfUserIsAbleToClickOnCreateStoryButtonForBangla();
    public abstract boolean checkIfUserIsAbleToSeePagesTabPresentInSidebar();
    public abstract boolean checkIftUserIsAbleToClickPagesTabPresentInSidebar(String backgroundColor);
    public abstract boolean checkIfUserIsAbleToClickOnCreateAPageButtonPresentInTheRightCorner();
    public abstract boolean checkIfUserIsAbleToClickOnDashboardTab(String backgroundColor);
    public abstract boolean verifyMongoDBConnectionAndStoryDetailsInDatabase(String created, String storyIdNumber, String property, String environment, String headLine, String summary, String paragraph);

}
