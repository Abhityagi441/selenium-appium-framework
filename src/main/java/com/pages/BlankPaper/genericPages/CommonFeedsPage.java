package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.feeds.FeedsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonFeedsPage {

    private static CommonFeedsPage commonFeedsPage;
    private static GlobalVars globalVars;

    public static CommonFeedsPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonFeedsPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonFeedsPage = new FeedsPage();
                    break;
            }
        }
        return commonFeedsPage;
    }

    public abstract boolean isFeedsExpandable();
    public abstract boolean checkAgencyAndSectionFilters(String agency, String section);
    public abstract boolean checkPublishedFilter();
    public abstract boolean isFeedsExpandableForPrintFeed();
    public abstract boolean isNotificationAndCreateStoryButtonDisplayedOnPrintFeedTab();
    public abstract boolean isOptionsDisplayedUnderCreateStory(String property);
    public abstract boolean isEditFeedsOnAgencyFeedsTab();
    public abstract boolean isStoriesSearchableOnAgencyFeedsTab();

    public abstract boolean validatePrintFeedStoryPopup();
    public abstract boolean isStoryEditableOnClickOfPickStoryButtonOnPrintFeedStoryPopup(String heading);

    public abstract boolean checkCopiedForPublishAndPickAsStoryEnableButton();
    public abstract boolean afterPickAsStoryRedirectOnStoryPage();
    public abstract boolean sectionFilter(String section);
    public abstract boolean statusFilter(String status);
    public abstract boolean islhgalleryoptionpresent();
    public abstract boolean islhgallerydatapresent();
    public  abstract boolean checkUserIsAbleToPreviewTheStoryFromLhGalleryFeedAndPickFromThere();
    public  abstract boolean checkThatUserIsAbleToDoPickAsStoryFromTheStoriesPresentOnLhGalleryFeedAndCheckTheDataOnTheNewTabOpensOnBlankpaper();
    public  abstract  boolean checkThatUserIsAbleToCreateStoryFromLhGalleryFeedThenPublishTheSame(String byline);
    public abstract boolean isUserAbleToPreviewTheStoryLhGalleryFeed();
    public abstract boolean checkIfUserIsAbleToSeeFeedsTabPresentInTheSidebar();
    public abstract boolean checkIfUserIsAbleToClickOnFeedsTabPresentInSidebar();
    public abstract boolean checkIfUserIsAbleToSelectPrintFeedTab(String borderColor);

    public abstract boolean checkIfUserIsAbleSeeFiveColumnsInTheTable(String headingOne, String headingTwo, String headingThree, String headingFour, String headingFive);

}
