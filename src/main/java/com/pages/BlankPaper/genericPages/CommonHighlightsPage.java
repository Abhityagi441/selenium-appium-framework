package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.HighlightsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHighlightsPage {
    private static CommonHighlightsPage commonHighlightsPage;
    private static GlobalVars globalVars;

    public static CommonHighlightsPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonHighlightsPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonHighlightsPage = new HighlightsPage();
                    break;
            }
        }
        return commonHighlightsPage;
    }

    public abstract boolean createHighLight(String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkHighlightsStoryWithLiveHindustanAffiliateTenant(String property, String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean publishHighLightAndVerify();
    public abstract boolean verifyPurgeStory();
    public abstract boolean verifyKillStory();
    public abstract boolean checkChangeUrl();
    public abstract boolean scheduleHighLightAndVerify();
    public abstract boolean verifySoftPublish();
    public abstract boolean verifyUploadImage();
    public abstract boolean verifyEditStoryContent();
    public abstract boolean verifyImageCropping();
    public abstract boolean discardHighLightAndVerify();
    public abstract boolean updateCustomHeadline(String landing, String mobile, String browser, String facebook, String twitter, String newsletter);
    public abstract boolean verifyUrlHeadlineForLanguages(String headline);
    public abstract boolean mouseHoverOnLeftPannelAndVerifyElementsAndUser(String expectedUserName);
    public abstract boolean deleteHighlightContent();
    public abstract boolean editHighLightAndVerify();
    public abstract void clickOnBlankPaperLogo();
    public abstract boolean createHighLightStory(String headline, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkChangeUrl(String newHeadline);
    public abstract boolean softPublishWithNewHeadline(String newHeadline);

    public abstract boolean checkIfUserAbleToCreateHighlightsStory(String property, String heading, String summary, String paragraph, String highlightsItem, String byline, String section, String subsection, String keyword, String location);
}