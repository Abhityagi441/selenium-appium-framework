package com.pages.BlankPaper.genericPages.ForntEndUiPage;

import com.pages.BlankPaper.webdesktop.FrontEndUi.*;
import com.utils.Constants;
import com.utils.GlobalVars;

import java.util.Date;

public abstract class CommonFrontEndPage {
    private static CommonFrontEndPage commonFrontEndPage;
    private static GlobalVars globalVars;

    public static CommonFrontEndPage getInstance(String property) {
        globalVars = GlobalVars.getInstance();
        if (commonFrontEndPage == null) {
            switch (property) {
                case Constants.HT_NEW:
                    commonFrontEndPage = new HT_FrontEndPage();
                    break;
                case Constants.LIVE_MINT:
                case Constants.LIVEMINT:
                    commonFrontEndPage = new LiveMint_FrontEndPage();
                    break;
                case Constants.BANGLA:
                    commonFrontEndPage = new Bangla_FrontEndPage();
                    break;
            }
        }
        return commonFrontEndPage;
    }

    public abstract boolean dataValidationOnFrontEndUI(String username, String password, String headline, String subsection, String summary, String byline, String paragraph, String location, String storyIDNumber);
    public abstract boolean waitForSchedulePublishToPublished(String storyIdNumber);
    public abstract boolean dataValidationVideoStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String summary, String storyIdNumber);
    public abstract boolean dataValidationPhotoGalleryStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String summary, String storyIdNumber);
    public abstract boolean dataValidationOnSoftPublishPhotoGalleryStoryOnFrontEnd(String username, String password, String newHeadline, String section, String subsection, String paragraph, String summary, String storyIdNumber, Date time);
    public abstract boolean dataValidationOnFrontEndUI(String username, String password, String headline, String section, String subsection, String summary, String byline, String paragraph, String location, String topic, String storyIDNumber);
    public abstract boolean changeUrl(String urlHeadline, String storyIDNumber1);
    public abstract boolean dataValidationWithPublishTimeVideoStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String summary, String storyIdNumber, Date time);
public abstract boolean dataValidationFirstStoriesCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String section, String subsection, String summary, String byline, String location, String paragraph, String topic);
public abstract boolean dataValidationSecondStoriesCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String section, String subsection, String summary1, String byline1, String location1, String paragraph1, String topic1, String headline1);
    public abstract boolean dataValidationWithPublishTimeStandardStoryOnFrontEnd(String username, String password, String newHeadline, String section,String subsection, String summary, String byline, String paragraph, String location, String topic, String storyIDNumber1,Date time);
    public abstract boolean dataValidationLiveBlogStoryOnFrontEnd(String username, String password, String headline, String section,String subsection, String paragraph, String postTitle, String postBody, String storyIdNumber);
    public abstract boolean dataValidationSoftPublishLiveBlogStoryOnFrontEnd(String username, String password, String headline, String section,String subsection, String paragraph, String postTitle, String postBody, String storyIdNumber, Date publishedStoryTiming);
public abstract boolean deleteStoryFromCollectionAndCheckOnFrontEnd(String userAndPasswordURL,String collectionName,String headline,String headline1);
public abstract boolean dataValidationSecondStoriesPositionUpAndDownCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String headline1);
public abstract boolean checkHamburgerSectionNameOnFrontEnd(String userAndPasswordURL, String sectionName);
public abstract boolean checkHamburgerDeletedSectionNameOnFrontEnd(String userAndPasswordURL,String sectionName);
public abstract boolean checkHamburgerUpAndDownPositionSectionNameOnFrontEnd(String userAndPasswordURL,String sectionName);
public abstract boolean dataValidationHighlightsStoryOnFrontEnd(String username, String password, String headline, String summary,String paragraph, String byline,String highlightsItem,String section, String subsection,String location, String storyIdNumber);
public abstract boolean checkSectionNameOnFrontEnd(String userAndPasswordURL,String pageSectionName,String sectionUrl,String subsection,String headlineText);
public abstract boolean checkSubSectionNameOnFrontEnd(String userAndPasswordURL,String pageSectionName,String sectionUrl,String subsection,String headlineText,String section);
public abstract boolean dataValidationOnFrontEndUI(String username, String password, String storyHeadlineText, String storyIDNumber1);
public abstract boolean killHighlightsStoryDataValidationOnFrontEndUI(String username, String password, String storyHeadlineText, String storyIDNumber1);
public abstract boolean dataValidationStandardStoryParagraphWithInLineEmbedOnFrontEnd(String username, String password, String headline, String summary,String firstParagraphData,String secondParagraphData, String byline,String section, String subsection,String location, String storyIdNumber,String srcEmbed);
public abstract boolean dataValidationStandardStoryWithAllInLineEmbedOnFrontEnd(String username, String password, String headline, String summary,String paragraphData, String byline,String section, String subsection,String location, String storyIdNumber,String srcEmbed,String imageSrcValue,String captionName,String tableInputData,String companyName,String topic);
public abstract boolean dataValidationImageCaptionName(String username, String password,String storyIDNumber1,String firstCaptionName,String storyHeadlineText);
    public abstract boolean waitForPublished(String storyIdNumber);
}
