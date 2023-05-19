package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.PhotoPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPhotoPage {
    private static CommonPhotoPage commonPhotoPage;
    private static GlobalVars globalVars;


    public static CommonPhotoPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonPhotoPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                case Constants.DESKTOP_WEB:
                    commonPhotoPage = new PhotoPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonPhotoPage = new com.pages.LiveHindustan.android_amp.PhotoPage();
                    break;
                case Constants.IOS_AMP:
                    commonPhotoPage = new com.pages.LiveHindustan.ios_amp.PhotoPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonPhotoPage = new com.pages.LiveHindustan.android_mweb.PhotoPage();
                    break;
                case Constants.IOS_WEB:
                    commonPhotoPage = new com.pages.LiveHindustan.ios_mweb.PhotoPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonPhotoPage;
    }

    public abstract boolean checkExpandPhotoDetailAndFunctionality();

    public abstract boolean checkPhotoDetailePage();

    public abstract boolean checkBreadcrumbAndSocialSharingIsPresent();

    public abstract boolean checkPhotoGalleryLandingPage();

    public abstract boolean checkPhotoGalleryLandingPageSubMenuClickable();
    public abstract boolean checkPhotoGalleryLandingPageSubMenu();
    public abstract boolean checkL2SubMenuArePresentAndGivingOkStatusCode();
    public abstract boolean checkAurPadheButtonOnAmpPhotoLandingPage();
    public abstract boolean checkBreadcrumbAndSocialSharingOnPhotoGallery();
    public abstract boolean checkPhotoGalleryAurPhotoDekheTabOnAmp();

    public abstract boolean checkSharingOptionForPhotoGallery();

    public abstract boolean checkNextAndPreviousForPhotoGallery();

    public abstract boolean checkChhodDePhotoGallery();
    public abstract boolean checkNextPreviousButtonFunctionalityOnPhotoExpandView();
    public abstract boolean checkSwipeFunctionalityOnPhotoExpandView();
    public abstract boolean checkPhotoGalleryWidgetIsHaving5StoriesAndStatusIs200();
    public abstract boolean checkShuruSeDekhenButtonFunctionalityOnPhotoDetailPage();
    public abstract boolean checkInfiniteScrollFunctionalityOnPhotoDetailPage();
    public abstract boolean checkRelatedPhotoGalleryWidgetOnPhotoDetailPageWithApi();

    public abstract boolean checkBaneRaheFunctionalityOnExpandViewOnPhotoDetailPage();

    public abstract boolean checkAgliGalleryOptionShouldBePresentAndAfterClickingShouldMoveToNextGallery();

    public abstract boolean checkPauseOrPlayFunctionalityOnExpandViewOnPhotoDetailPage();

    public abstract boolean checkPhotoGalleryWidget();
}

