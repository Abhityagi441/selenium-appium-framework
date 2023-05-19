package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.VideoPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonVideoPage {
    private static CommonVideoPage commonVideoPage;
    private static GlobalVars globalVars;

    public static CommonVideoPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonVideoPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                case Constants.DESKTOP_WEB:
                    commonVideoPage = new VideoPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonVideoPage = new com.pages.LiveHindustan.android_amp.VideoPage();
                    break;
                case Constants.IOS_AMP:
                    commonVideoPage = new com.pages.LiveHindustan.ios_amp.VideoPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonVideoPage = new com.pages.LiveHindustan.android_mweb.VideoPage();
                    break;
                case Constants.IOS_WEB:
                    commonVideoPage = new com.pages.LiveHindustan.ios_mweb.VideoPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonVideoPage;
    }

    public abstract boolean checkSubmenuAreClickableOnVideoLandingPage();
    public abstract boolean checkBreadcrumbRedirectionGiving200OnVideoWidget();
    public abstract boolean checkVideoDetailPage();

    public abstract boolean checkSambhanditVideoGalleryHavingFourVideosGiving200Status();

    public abstract boolean checkSocialSharingRedirectionAndGiving200OnVideoDetail();

    public abstract boolean checkVideoIsPlayingSuccessfullyOnVideoDetailPage();
    public abstract boolean checkVideoGalleryWidgetIsHaving5StoriesAndStatusIs200();
}
