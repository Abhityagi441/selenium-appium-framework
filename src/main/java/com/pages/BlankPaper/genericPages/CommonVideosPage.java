package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.videos.VideosPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonVideosPage {

    private static CommonVideosPage commonVideosPage;
    private static GlobalVars globalVars;

    public static CommonVideosPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonVideosPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonVideosPage = new VideosPage();
                    break;
            }
        }
        return commonVideosPage;
    }

    public abstract boolean isVideosServiceSearchable();
    public abstract boolean validateVideosStoriesGridView();
    public abstract boolean validateVideosStoriesListView();
    public abstract boolean isVideosStoriesSearchable();
    public abstract boolean validateVideosServicePreviewPopup();
    public abstract boolean validateVideosStoriesPreviewPopup();
    public abstract boolean validateOpenPreviewPageOnVideosStoriesTab();
    public abstract boolean sourceFilter(String dataHT, String dataLM);
    public abstract boolean validateOpenPreviewPageOnVideosServicesTab();

    public abstract boolean CheckIfUserIsAbleToSeeVideosTabPresentInSidebar();

    public abstract boolean CheckIfUserIsAbleToClickOnVideosTabPresentInSidebar();
    public abstract boolean CheckIfUserIsAbleToSeeThreeTabsOnTheVideoPage();
    public abstract boolean CheckIfAllTheThreeTabsAreClickable();
    public abstract boolean CheckIfVideosShouldBePresentWhenUserClickOnAnyOfTheThreeTabs();
    public abstract boolean CheckIfAllVideosPresentUnderTheTabShouldHavePlayIconPresentOnTheRightSide();
    public abstract boolean CheckIfWhenUserClickOnPlayIconVideoPopupShouldOpen();
    public abstract boolean CheckIfVideoPopupHasCrossButton();
    public abstract boolean CheckIfCrossButtonPresentOnThePopupShouldBeWorking();
    public abstract boolean CheckIfHeightOfPopupVideoOfVideoPageShouldBeAccordingToWindowHeight();

}
