package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.WebStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonWebStoryPage {

    private static CommonWebStoryPage commonWebStoryPage;
    private static GlobalVars globalVars;

    public static CommonWebStoryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonWebStoryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonWebStoryPage = new WebStoryPage();
                    break;
            }
        }
        return commonWebStoryPage;
    }

    public abstract boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetatitle();
    public abstract boolean checkWhateverDataWeAreProvidingSameDataIsPresentInMetadescription();
    public abstract boolean checkWebStoryPageShouldOpen();
    public abstract boolean checkAfterPublishingWebStoryTheCompleteDataGoesToMasterDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkUserShouldBeAbleToAddImageAndTextOnSlide(String imageText);
    public  abstract boolean checkUserShouldBeAbleToDeleteTheImageFromSlide();
    public abstract boolean checkUserShouldBeAbleToAddMultipleSlides(String firstImageText, String secoundImageText);
    public abstract boolean checkUserShouldBeAbleToDeleteTheTextFromTheSlide(String imageText);
    public abstract boolean isUserAbleToDeleteTheAddedSlides(String firstImageText, String secondImageText);
    public abstract boolean checkIfUserIsAbleToCreateWebStory(String headLine, String summary, String byline, String section, String subsection,String keyword,String location);
}
