package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.PhotoGalleryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

import java.awt.*;

public abstract class CommonPhotoGalleryPage {
    private static CommonPhotoGalleryPage commonPhotoGalleryPage;
    private static GlobalVars globalVars;

    public static CommonPhotoGalleryPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonPhotoGalleryPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonPhotoGalleryPage = new PhotoGalleryPage();
                    break;
            }
        }
        return commonPhotoGalleryPage;
    }

    public abstract boolean createPhotoGallery(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean verifyCreatePhotoGalleryWithMultiplePhotos(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean verifyCreatePhotoGalleryStatus(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean discardPhotoGallery();
    public abstract boolean verifyPublishPhotoGallery();
    public abstract boolean softPublishPhotoGallery();
    public abstract boolean verifyKillPhotoGallery();
    public abstract boolean verifyPurgePhotoGallery();
    public abstract boolean editedPhotoGalleryAndVerify();
    public abstract boolean verifySchedulePhotoGallery();
    public abstract boolean verifyDeleteGalleryContent();
    public abstract boolean checkChangeUrlPhotoGallery();
    public abstract boolean updateCustomHeading(String landing, String mobile, String browser, String facebook, String twitter, String newsletter, String platform);
    public abstract boolean imageDragAndDropInPhotoGallery();
    public abstract boolean verifyMultipleImages();
    public abstract boolean softPublishPhotoGallery(String newHeadline);
    public abstract boolean checkChangeUrlPhotoGallery(String changeUrlHeadline);
    public abstract boolean defaultSection(String headline,String summary,String section,String subsection,String secondSectionName);
    public abstract boolean createPhotoGalleryWithMultiplesImages(String section,String headline, String summary, String byline, String subsection, String keyword, String location);
    public abstract boolean createPhotoGalleryWithMultiplesImagesCaptionName(String section,String headline, String summary, String byline, String subsection, String keyword, String location,String firstCaption,String secondCaption,String thirdCaption);
    public abstract boolean changeImageCaptionName(String storyType, String firstCaption);
    public abstract boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoGalleryTheSameDataIsPresentInMetatitleOrNot();

    public abstract boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetadescription();

    public abstract boolean checkMasterDbMetaTitleAndMetaDescriptionComesForPhotoGalleryStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkCreatePhotoGalleryStoryWithLiveHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
    public abstract boolean checkIfTheNamingConventionWhileSendingTheNotificationSecondTimeForAPublishedStory(String url, String email, String password) throws InterruptedException;
    public abstract boolean checkIfTheNamingConventionWhileSendingTheNotificationToMoEngageForAPublishedStory(String url, String email, String password) throws InterruptedException;
    public abstract boolean checkIfTitleFieldDropdownValuesWithSlugOption();
    public abstract boolean checkIfUserIsAbleToAddMoreThanTenImagesInPhotoGallerySmoothly();
    public abstract boolean checkIfUserIsAbleToCreateStoryPhotoGallery(String property, String headLine, String summary, String byline, String section, String subsection, String keyword, String location,String Caption);
    public abstract boolean checkIfUserIsAbleToClickOnPhotoGalleryOptionFromCreateStoryDropDown();
    public abstract boolean checkIfUserIsRedirectedToPhotoGalleryPage();
    public abstract boolean checkIfUserIsAbleToSeeUploadANewImageOrPickFromImageLibraryOption();
    public abstract boolean checkIfUserIsAbleToSelectMultipleImageFromPickFromImageGalleryOption();
    public abstract boolean checkIfImageIsUploadedWhenUserClickOnChooseImagesButtonOnPopup();
    public abstract boolean checkIfUploadedImageIsEditableWhenUserClickOnEditButtonForParticularImage();
    public abstract boolean checkIfUserIsAbleToAddCaptionInTheImage();
    public abstract boolean checkIfUserIsAbleToAddHyperLinkToCaptionInTheImage(String hyperLink, String paragraphText);
    public abstract boolean checkIfClickOnCaptionHyperlinkIsRedirectedToTheSameLinkInNewTab(String hyperLink, String paragraphText);
    public abstract boolean checkIfPickFromImageLibraryIsworking();
    public abstract boolean checkIfUserIsAbleToSelectImageWithUploadANewImageOption();

}