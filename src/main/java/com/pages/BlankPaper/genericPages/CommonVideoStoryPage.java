package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.VideoStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonVideoStoryPage {
    private static CommonVideoStoryPage commonVideoStoryPage;
    private static GlobalVars globalVars;

    public static CommonVideoStoryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonVideoStoryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonVideoStoryPage = new VideoStoryPage();
                    break;
            }
        }
        return commonVideoStoryPage;
    }

    public abstract boolean createVideoStoryAndVerify(String headline, String summary, String byline, String section, String subsection, String keyword, String location) ;
//    public abstract boolean createVideoStoryAndVerifyStatus(String headline, String summary, String byline, String section, String subsection, String keyword, String location) ;
    public abstract boolean discardVideoStoryAndVerify();
    public abstract boolean editVideoStoryAndVerify(String editHeadline);
    public abstract boolean scheduleVideoStoryAndVerify();
    public abstract boolean verifyPublishVideoStory();
    public abstract boolean softPublishVideoStoryAndVerify();
    public abstract boolean killVideoStoryAndVerify();
    public abstract boolean purgeVideoStoryAndVerify();
    public abstract boolean verifyCreateVideoStory(String headline, String summary,  String byline, String section, String subsection, String keyword, String location) ;
    public abstract boolean publishVideoStory();
    public abstract boolean changeUrlVideoStory();
    public abstract boolean verifyDeleteVideoStoryContent();
    public abstract boolean verifyUploadImage();
    public abstract boolean verifyImageCropping();
    public abstract boolean updateCustomHeading(String landing, String mobile, String browser, String facebook, String twitter, String newsletter, String platform);
    public abstract boolean embedCodeValidation(String embedUrl);
    public abstract boolean videoTranslateLanguage(String embedUrl,String headline , String domain);
    public abstract boolean popupEmbedPage(String embedUrl);
    public abstract boolean softPublishWithNewHeadline(String newHeadline);
    public abstract boolean changeUrlVideoStory(String changeUrlHeadline);
    public abstract boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetatitle(String embedUrl);
    public abstract boolean checkWhateverDataWeAreProvidingSameDataIsPresentInMetadescription(String embedUrl);

    public abstract boolean checkAfterPublishingVideoStoryTheCompleteDataGoesToMasterDb(String embededUrl, String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkCreateVideoStoryWithLiveHindustanAffiliateTenant(String embededUrl, String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkVideoDurationField(String embededUrl, String property);
    public abstract boolean checkVideoDurationFieldValidationWithAlphaCharacter(String embededUrl, String property);
    public abstract boolean checkVideoDurationFieldValidationWithNumericValue(String embededUrl, String property, String min, String sec);
    public abstract boolean checkIfUserCanCreateVideoStory(String property, String headLine, String summary, String embedCode, String byline, String section, String subsection, String keyword, String location);
}