package com.pages.LiveMint.genericPages;


import com.pages.LiveMint.ios_native.AdvertisementPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonAdvertisementPage {
    private static CommonAdvertisementPage commonAdvertisementPage;
    private static GlobalVars globalVars;

    public static CommonAdvertisementPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonAdvertisementPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonAdvertisementPage = new com.pages.LiveMint.android_native.AdvertisementPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonAdvertisementPage = new AdvertisementPage();
                    break;

                case Constants.DESKTOP_WEB:
                    commonAdvertisementPage = new com.pages.LiveMint.web.AdvertisementPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonAdvertisementPage = new com.pages.LiveMint.android_amp.AdvertisementPage();
                    break;
                case Constants.IOS_AMP:
                    commonAdvertisementPage = new com.pages.LiveMint.ios_amp.AdvertisementPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonAdvertisementPage = new com.pages.LiveMint.android_mweb.AdvertisementPage();
                    break;
                case Constants.IOS_WEB:
                    commonAdvertisementPage = new com.pages.LiveMint.ios_mweb.AdvertisementPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonAdvertisementPage;
    }

    public abstract boolean checkAdsOnHomePage();

    public abstract boolean checkAdsOnSectionPage();

    public abstract boolean checkSponsoredAd();
    public abstract boolean checkLeadsAdsOnHomePage();
    public abstract boolean checkRemoveAdsFunctionalityAndBackButton();
    public abstract boolean checkSecondAdsRemoveAdsFunctionalityAndBackButton();
    public abstract boolean checkRemoveAdsFunctionalityOnTopicPage();
    public abstract boolean checkRemoveAdsFunctionalityOnLatestAndTrendingPage();
    public abstract boolean checkRemoveAdsFunctionalityOnStoryDetailPage();

    public abstract boolean checkFirstInterstitialAds();

    public abstract boolean checkSecondInterstitialAds();

    public abstract boolean checkAdsOnSubscribedHomePage();
    public abstract  boolean checkAdsOnSubscribedStoryPage();
    public abstract boolean checkAdsOnSubscribedlistingPage(String pageName);
}
