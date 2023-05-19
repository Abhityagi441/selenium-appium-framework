package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.android_native.ForYouPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonForYouPage {
    private static CommonForYouPage commonForYouPage;
    private static GlobalVars globalVars;

    public static CommonForYouPage getInstance() {
        System.out.println("******************* beforeMethod 'ForYou Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonForYouPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonForYouPage = new ForYouPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonForYouPage = new com.pages.LiveMint.ios_native.ForYouPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonForYouPage = new com.pages.LiveMint.web.ForYouPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonForYouPage = new com.pages.LiveMint.android_mweb.ForYouPage();
                    break;

                case Constants.IOS_WEB:
                    commonForYouPage = new com.pages.LiveMint.ios_mweb.ForYouPage();
                    break;

                case Constants.ANDROID_AMP:
                    commonForYouPage = new com.pages.LiveMint.android_amp.ForYouPage();
                    break;
                case Constants.IOS_AMP:
                    commonForYouPage = new com.pages.LiveMint.ios_amp.ForYouPage();
                    break;

            }
        }
        System.out.println("******************* beforeMethod 'ForYou Page' ends here *******************");
        return commonForYouPage;
    }
    public abstract boolean checkBannerStory();
    public abstract boolean checkForYouIconInactive(String forYouText);
    public abstract boolean checkShareAndBookmarkIconOnForYouPage();
    public abstract boolean checkShareAndBookmarkStoryDetailPage();
    public abstract boolean checkForYouPageAndIcon();
    public abstract boolean checkTextToSpeechOnStoryDetailPage();
    public abstract boolean checkAdsOnForYouPage();
    public abstract boolean checkAdOnStoryDetailPage();
    public abstract boolean checkForYouNoOfStories(String noOfStories);
    public abstract boolean checkForYouLayout();
    public abstract boolean lHSNAVLinks();
    public abstract boolean rHSNAVLinks();
    public abstract boolean checkFontSizeAtTopAndBottomOnStoryDetailPage();
    public abstract boolean checkForYouLayoutsubScribedUser();
    public abstract boolean checklHSNAVLinksforSubscribeduser();
    public abstract boolean checkrHSNAVLinksforSubscribeduser();
    public abstract boolean checkFirstStoryForYou();
    public abstract boolean checkFirstStoryForYouforSubscribedUser();
}
