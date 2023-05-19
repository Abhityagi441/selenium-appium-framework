package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.images.ImagesPage;
import com.utils.Constants;
import com.utils.GlobalVars;

import java.io.IOException;

public abstract  class CommonImagesPage {

    private static CommonImagesPage commonImagesPage;
    private static GlobalVars globalVars;

    public static CommonImagesPage getInstance(){
        globalVars= GlobalVars.getInstance();
        if(commonImagesPage ==null){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonImagesPage = new ImagesPage();
                    break;
            }
        }
        return commonImagesPage;
    }

    public abstract boolean clickDownloadOnFirstImageAndVerifyDownloadedImageInternalTab() throws IOException, InterruptedException;
    public abstract boolean isImagesWiresSearchable();
    public abstract boolean isImagesInternalSearchable();
    public abstract boolean isNotificationAndCreateStoryButtonDisplayed();
    public abstract boolean isNotificationAndCreateStoryButtonDisplayedOnInternalTab();
    public abstract boolean isImagesDetailsAndDownloadButtonDisplayed();
    public abstract boolean isImagesDetailsAndDownloadButtonDisplayedOnInternalTab();
    public abstract boolean isImagesPreviewWindowDetailsAndDownloadButtonDisplayed();
    public abstract boolean isImagesPreviewWindowDetailsAndDownloadButtonDisplayedOnInternalTab();
    public abstract boolean clickDownloadOnFirstImageAndVerifyDownloadedImageOnWiresTab();
    public abstract boolean validateListViewOnInternalImages();
    public abstract boolean validateGridViewOnInternalImages();

    public  abstract  boolean checkEditImageNameIsPresentInTheCropperWindow();

    public abstract boolean checkImageNameShouldBeEditable();

    public  abstract boolean checkWatermarkOnImagesWithTopic(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic);

    public  abstract  boolean checkWatermarkOnImagesWithSubSection(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location);
}
