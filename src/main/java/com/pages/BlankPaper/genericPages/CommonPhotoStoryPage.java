package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.PhotoStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPhotoStoryPage {

    private static CommonPhotoStoryPage commonPhotoStoryPage;
    private static GlobalVars globalVars;

    public static CommonPhotoStoryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonPhotoStoryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonPhotoStoryPage = new PhotoStoryPage();
                    break;
            }
        }
        return commonPhotoStoryPage;
    }

    public abstract boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoStoryTheSameDataIsPresentInMetatitleOrNot();

    public  abstract boolean checkThatSummaryOfPhotoStorySameIsPresentInMetadescription();
    public abstract boolean checkMasterDbMetaTitleAndMetaDescriptionComesForPhotoStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String slideDesc);
    public abstract boolean checkCreatePhotoStoryWithLiveHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String slideDesc);

    public abstract boolean checkCIfUserIsAbleToCreatePhotoStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String slideDesc, String imageCaption, String caption);
}
