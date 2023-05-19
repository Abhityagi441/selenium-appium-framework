package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.LiveBlogPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLiveBlogPage {

    private static CommonLiveBlogPage commonLiveBlogPage;
    private static GlobalVars globalVars;

    public static CommonLiveBlogPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonLiveBlogPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonLiveBlogPage = new LiveBlogPage();
                    break;
            }
        }
        return commonLiveBlogPage;
    }

    public abstract boolean createAndVerifyLiveBlog(String headline, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean editLiveBlogAndVerify(String editHeadline);
    public abstract boolean publishStoryAndVerify();
    public abstract boolean purgeStoryAndVerify();
    public abstract boolean verifyKillStory();
    public abstract boolean checkChangeUrl();
    public abstract boolean schedulePublishAndVerify();
    public abstract boolean softPublish();
    public abstract boolean uploadLiveBlogImage();
    public abstract boolean verifyEditStoryContent(String storyId);
    public abstract boolean verifyImageCropping();
    public abstract boolean discardLiveBlogAndVerify();
    public abstract boolean updateCustomHeading(String landing, String mobile, String browser, String facebook, String twitter, String newsletter, String domain);
    public abstract boolean urlHeadlineForLanguages(String englishHeadline);
    public abstract boolean mouseHoverOnLeftPannelAndVerifyElementsAndUser(String expectedUserName);
    public abstract boolean verifyUploadImage();
    public abstract boolean deleteLiveBlogContent();
    public abstract boolean softPublish(String newHeadline);
    public abstract boolean checkChangeUrl(String newUrlHeadline);
    public abstract boolean addingMultipleElementsInSinglePostAndPublishPost(String headline, String summary, String paragraph, String section, String subsection, String byline, String keyword, String location, String postTitle, String postBody,String urlHeadline,String domain,String firstCaption,String secondCaption );
public abstract boolean addingMultipleElementsInSinglePost(String postTitle, String postBody );
public abstract boolean addingCombinationOfDifferentElementInSinglePost(String embedUrl ,String src,String postTitle,String postBody);
public abstract boolean pinMultiplePostAndAllPost();
    public abstract boolean addingMultipleEmbedInSinglePost(String embedUrl ,String src,String postTitle,String postBody);

    public abstract boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnLiveBlogTheSameDataIsPresentInMetatitleOrNot();
    public abstract boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription();
    public abstract boolean checkAfterPublishingLiveBlogStoryDataGoesToMasterDb(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkLiveBlogPostImageCroppingOption(String property);
    public abstract boolean checkCreateLiveBlogStoryWithLiveHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkLoadMoreButtonIsAppearingAfterFivePostsInliveBlog(String property);
    public abstract boolean checkLoadMoreButtonFunctionality(String property);
    public abstract boolean checkElementIsAddedForCricketScoreboard(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkAddMultipleIntroEmbed(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkEditIntroEmbed(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkIntroEmbedInDb(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String emText);
    public abstract boolean checkLiveBlogOptionIsVisible(String property);
    public abstract boolean checkPublishStoryWithoutEnteringHeadline(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String emText);
    public abstract boolean checkPublishStoryWithoutSelectingLeadMedia(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String errorMessage);
    public abstract boolean checkPublishStoryWithoutSummaryField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String errorMessage);
    public abstract boolean checkPublishStoryWithoutSectionField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String errorMessage);
    public abstract boolean checkPublishStoryWithoutSubSectionField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String errorMessage);
    public abstract boolean checkPublishStoryWithoutBylineField(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String errorMessage);
    public abstract boolean checkPublishStoryWithoutPost(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location, String errorMessage);
    public abstract boolean checkPublishLiveBlog(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkUrlIsGeneratedInStoryInfoSection(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkUrlIsGeneratedInStoryInfoSectionIsClickable(String property, String headLine, String summary, String paragraph, String postTitle, String postBody, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkIfTheHeadingEndLiveBlogButtonShouldAppearInBackend(String property, String headLine, String summary, String paragraph,String title,String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption);
    public abstract boolean checkIfEndLiveBlogButtonIsBeClickableAndShowsCalendar(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption);
    public abstract boolean checkIfTheLiveUpdateRadioButtonAppearsOnFrontendAlongWithPublishedBlog(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption);
    public abstract boolean checkIfUserIsAbleToCreateStoryLiveBlog(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption);
    public abstract boolean checkIfEndLiveBlogButtonConvertsIntoChangeEndTimeButtonOnceTimeIsSet(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption);
    public abstract boolean checkIfEndLiveBlogButtonConvertIntoTextAfterCertainTimeDurationAfterBlogEnds(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption);
    public abstract boolean checkIfTheLiveUpdateRadioButtonIsAbleToDisappearFromThePostAfterGivenCertainTimeDurationOnFrontend(String property, String headLine, String summary, String paragraph, String title, String titleBody, String byline, String section, String subsection, String keyword, String location, String leadMediaCaption, String postImageCaption);
}
