package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.StandardStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

import java.awt.*;

public abstract class CommonStandardStoryPage {
    private static CommonStandardStoryPage commonStandardStoryPage;
    private static GlobalVars globalVars;

    public static CommonStandardStoryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonStandardStoryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonStandardStoryPage = new StandardStoryPage();
                    break;
            }
        }
        return commonStandardStoryPage;
    }


    public abstract boolean verifyExactMatchSearchTabOnTop(String exactMatch);
    public abstract boolean verifyKeywordSearchTabOnTop(String searchKeyword);
    public abstract boolean verifySpecialCharMatchSearchTabOnTop();
    public abstract boolean verifyMinCharMatchSearchTabOnTop(String minCharMatch);
    public abstract boolean verifyMaxCharMatchSearchTabOnTop(String maxCharMatch);
    public abstract boolean createStoryAndVerify(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location,String topic);
    public abstract boolean editStoryAndVerify(String editHeadline);
    public abstract boolean publishStory();
    public abstract boolean purgeStoryAndVerify();
    public abstract boolean killStoryAndVerify();
    public abstract boolean checkChangeUrl(String changeUrlName);
    public abstract boolean softPublishAndVerify();
    public abstract boolean discardStoryAndVerify();
    public abstract boolean deleteStoryContentAndVerify();
    public abstract boolean updateCustomHeadline(String landing, String mobile, String browser, String facebook, String twitter, String newsletter, String platform);
    public abstract boolean mouseHoverOnLeftPannelAndVerifyElementsAndUser(String expectedUserName);
    public abstract boolean schedulePublishAndVerify();
    public abstract boolean verifyUploadImage(String storyId);
    public abstract boolean verifyImageCropping();
    public abstract boolean verifyUploadMultipleImages();
    public abstract boolean verifyInsertEmbed();
    public abstract boolean verifyInsertRelatedStory();
    public abstract boolean checkEditStoryContent(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location,String topic);
    public abstract boolean verifyDragAndDrop();
    public abstract boolean verifyMultipleImages();
    public abstract boolean softPublishWithNewHeadline(String newHeadline);
    public abstract boolean createStoryWithAllInLineElements(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic,String embedUrl,String companyName,String tableInputData,String imageCaption,String domain);
    public abstract boolean selectPublishedStoryAndVerifyLastModifiedInfo(String userIdG,String passwordG, String expectedUserNameG,String userIdQA,String passQA, String eUserNameQA,String storyType,String newHeadline,String createdBy,String domain);
    public abstract boolean createStandardStoryWithAddingInLineEmbedInBetweenParagraph(String headline,String summary,String firstParagraphData,String secondParagraphData,String embedUrl,String section,String subsection,String topic,String keyword,String location,String byline);
    public abstract boolean changeUrlAndPublishStory(String urlHeadline,String domain);
    public abstract boolean metaDataValues(String headline,String summary);
    public abstract boolean EditorMetaDataValues(String headline,String summary);
    public abstract boolean BlogMetaDataValues(String headline,String summary);
    public abstract boolean PremiumMetaDataValues(String headline,String summary);
    public abstract boolean specialsMetaDataValues(String headline,String summary);


    public  abstract  boolean verifyThatUserCanAddLeadImageForVideoTasks();

    public  abstract  boolean checkUsernameToBeShownWithEachVersion(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String userName);

    public abstract  boolean checkResizeImagesInFourAndThreeAspectRatio();

    public abstract  boolean checkThatUserCanSelectOneOrMultipleStoriesFromTheListOfStories();
    public  abstract boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnStadardStoryTheSameDataIsPresentInMetatitleOrNot();

    public  abstract boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription();
    public abstract boolean checkThatStandardStoryDataGoesToMasterDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkThatUserCanEditDisclaimer(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String disclaimer);
    public abstract boolean checkPodcastCarouselShouldBePresent();
    public abstract boolean checkPodcastShouldBeAddedToTheStory();
    public abstract boolean checkIconInsertHowToStoryPresentInTheInlineElements(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic);
    public abstract boolean checkAllHowToStoriesDisplayedInListing(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic);
    public abstract boolean checkUserShouldBeAbleToAddHowToStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic);
public abstract boolean StoryMatchPopup(String headline, String summary);
    public abstract boolean checkTextBoxesWithHeadersH2AndH3(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic);
    public abstract boolean verifyUserCanCreateStandardStoryWithHindustanAffiliateTenant (String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic);
    public abstract boolean checkQuickReadMaxAndMinLimitForAutomatedQuickRead(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic, String oneWord, String fourtyNineWord, String fiftyWord, String hundredWord, String hundredAndOneWord);
    public abstract boolean checkQuickReadMinimumLimitFifty(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic, String fourtyNineWord);
    public abstract boolean checkQuickReadMaximumLimitHundred(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic, String hundredAndOneWord);
    public abstract boolean checkRecipeIconOnInlineElementBar(String property, String paragraph);
    public abstract boolean checkMandatoryFieldValidationForRecipe(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String recipeName, String stepInformation, String nameErrorMsg, String stepErrorMsg);
    public abstract boolean checkElementSavingForRecipe(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String recipeName, String stepInformation, String recipeDescription, String recipeYield, String recipePreparationHour, String recipePreparationMinute, String recipeCookingHour, String recipeCookingMinute, String recipeTotalHour, String recipeTotalMinute, String recipeIngredients, String recipeCuisine, String recipeCategory, String recipeKeywords);
    public abstract boolean checkChangesAreSavingForRecipe(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String recipeName, String stepInformation, String recipeDescription, String recipeYield, String recipePreparationHour, String recipePreparationMinute, String recipeCookingHour, String recipeCookingMinute, String recipeTotalHour, String recipeTotalMinute, String recipeIngredients, String recipeCuisine, String recipeCategory, String recipeKeywords, String recipeUpdateName, String recipeUpdateDesc);
    public abstract boolean checkSendNotificationLinkIsClickable(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkPhotoUploaded(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public  abstract boolean checkUserIsAbleToCreateStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public  abstract boolean checkSocialNotificationSectionIsPresent(String property);
    public abstract boolean checkSendNotificationLinkPresence(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkSendNotificationPopupShouldOpen(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkSendNotificationPopupHaveImageUrlField(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkImageUrlFieldShouldNotBeKeptEmpty(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkSendAndCancelButtonOnSendNotificationPopup(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkSendButtonIsWorking(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkAddPhotoStoriesButtonIsAvailable(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkUserCanSelectDesiredStoryToHyperlink(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkHyperlinkStoryTextIcon(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkActionOnClickOfHyperlinkStoryTextIcon(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkProperValidationMessageIfNoMatchingData(String property, String headLine, String summary, String byline, String section, String subsection, String keyword, String location, String topic, String paraTextNoMatching, String expValidationMessage);
    public abstract boolean checkUserCanSelectMoreThanOneWordsToHyperlink(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkWordsHyperlinkedAreRedirectedToTheRightStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String paraText);
    public abstract boolean checkOnceHyperlinkedUserCanEditTheHyperlink(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String url);
    public abstract boolean checkUserCanUnlinkTheHyperlinkedWord(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkCancelButtonIsWorking(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkNotificationBellIconIsPresentOnDashboard(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkImageUploadedForOneTenantIsVisibleInOtherTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String otherTenent);
    public abstract boolean checkUploadImageDisplayedUnderCrossDomainTab(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String otherTenent, String otherByLine);
    public abstract boolean checkUploadImageDisplayedUnderCrossDomainTabFromInline(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String otherTenent, String otherByLine);
    public abstract boolean checkUploadedImageShouldBeDisplayedInInternalTab(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String imgSrc);
    public abstract boolean checkRelatedStoryHeadline(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkHButtonPresentWhileCreatingStandardStory(String property);
    public abstract boolean checkHButtonHasThreeOptionsForParagraph(String property, String paraOne, String paraTwo, String paraThree);
    public abstract boolean checkHButtonOptionsAreSelectable(String property, String paraOne, String paraTwo, String paraThree);
    public abstract boolean checkCityFilterInDashboard(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkHoveringMouseOnOptionsBackColorShouldBeGrey(String property, String hoverColor);
    public abstract boolean checkSelectingOnOptionsBackgroundColorShouldBlue(String property, String selectingColor);
    public abstract boolean checkOptionsParagraphShouldBeChangedAccordingly(String property, String paragraph);
    public abstract boolean checkSentencesIsDisplayedInFormOfHeadlineTwo(String property, String headline, String summary, String paragraph);
    public abstract boolean checkSentencesIsDisplayedInFormOfHeadlineThree(String property, String headline, String summary, String paragraph);
    public abstract boolean checkVideoAndImageAreAdded(String property);
    public abstract boolean checkVideoAndImageAreAddedWithCaption(String property);
    public abstract boolean checkOutdatedFlagToggleButton(String property);
    public abstract boolean checkOutdatedFlagTimeFiled(String property);
    public abstract boolean checkSentencesIsDisplayedInFormOfParagraph(String property, String headline, String summary, String paragraph);
    public abstract boolean checkWholeSentenceShouldBeAffected(String property, String headline, String summary, String paragraph);
    public abstract boolean checkOnlyHeadingShouldBeAffected(String property, String headline, String summary, String paragraph);
    public abstract boolean checkUserCanEnterParagraph(String property, String headline, String summary, String paragraph);
    public abstract boolean checkHButtonFloatingAlongWithThreeButtons(String property, String headline, String summary, String paragraph);
    public abstract boolean checkEditParagraphAndHButtonFloatingWithThreeButtons(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkChangingTheValueInValidityTimeField(String property);
    public abstract boolean checkOutdatedFlagValueInDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkAutoBacklinkDetailsInDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String expMessage);
    public abstract boolean checkTheNameConventionForMoengageNotification(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String moengageUrl, String moengageLoginUserName, String moengageLoginPassword);
    public abstract boolean checkTheNameConventionForScheduledNotification(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String moengageUrl, String moengageLoginUserName, String moengageLoginPassword);
    public abstract boolean checkSlugOptionInNotificationWindows(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic,String notificationtype);
    public abstract boolean checkNotificationTypeAsSlug(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic,String notificationtype);
    public abstract boolean checkSelectRelatedStoriesMutipleTimesInStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkSelectOtherRelatedStories(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkSelectSameRelatedStoryInOtherPostsForSingleStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String cssName, String cssValue);
    public abstract boolean checkIfSeoScorePrePublish(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword1, String keyword2);
    public abstract boolean checkIfSeoScorePostPublish(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword1, String keyword2);
    public abstract boolean checkIfWatchAsPrefixIsDisplayedInBoldAboveVideoEmbed(String preText);

    public abstract boolean checkIfUserIsAbleToCreateStandardStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);

    public abstract boolean checkIfGeneratedUrlRedirectingToTheCorrectFrontendStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkEditStory(String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkIfTheStatusColumnIsDisplayedCreatedTextIfUserCreatedTheStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String embedUrl);
    public abstract boolean checkIfTheStatusColumnShouldDisplayEditedTextIfUserDoNotApplyScheduleTimeToPublishTheStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption);
    public abstract boolean checkIfTheStatusColumnShouldDisplayScheduledTextIfUserScheduleFixTimeToPublishTheStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption);
    public abstract boolean checkIfTheStatusColumnShouldDisplayFiledTextIfStoryIsOnlyFiled(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption);
    public abstract boolean checkIfUserIsAbleToKillThePublishedStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);
    public abstract boolean checkIftUserIsAbleToOpenStoryOfMintGenieTenant();
    public abstract boolean checkIfTheBackgroundColorOfScheduledTextIsSameAsTextColor(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption, String backgroundColor, String textColor);
    public abstract boolean CheckIfGreyBackgroundColorShouldBePresentAroundScheduledText(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic, String captionName, String leadMediaCaption, String backgroundColor);
    public abstract boolean checkIfInsertSampleImagesElementIsPresentInInlineElements();
    public abstract boolean checkActionOnClickOfClickInsertSampleImagesElementIcon();
    public abstract boolean checkIfUserIsAbleToUploadFilesUsingPickFromGalleryButton();
    public abstract boolean checkIfUserIsAbleToAddHyperLinkToRequiredWord(String hyperLink, String paragraphText);
    public abstract boolean checkIfUserIsAbleToSeeSubSectionL2FieldInMetaDataSection();
    public abstract boolean checkIfUserIsAbleToCreateStandardStoryAfterFillingSubSectionL2Field(String headLine, String summary, String paragraph, String byline, String section, String subsection, String subsectionL2);
    public abstract boolean checkIfSubSectionl2ShouldNotBeUsedToCreateUrlOfTheStory(String headLine, String summary, String paragraph, String byline, String section, String subsection, String subsectionL2);
    public abstract boolean checkIfUserIsAbleToClickOnStandardStory();
    public abstract boolean checkIfSampleImageIdsPresentInMasterDb();
    public abstract boolean checkIfUserCanSeeHeadlineSummaryAndParagraphInNewStory();
    public abstract boolean checkIfUserIsAbleToAddHeadlineToStory(String headline);
    public abstract boolean checkIfUserIsAbleToAddSummaryToStory(String summary);
    public abstract boolean checkIfUserIsAbleToAddParagraphToStory(String paragraph);
    public abstract boolean checkIfUserIsAbleToSeeHeadlineSummaryParagraphInDb(String headline, String summary, String paragraph);
    public abstract boolean checkIfParagraphElementCreatedAfterInsertingVideo();
    public abstract boolean checkIfUserCanUploadImagesFromUploadNewFilesOptionInInline();


}