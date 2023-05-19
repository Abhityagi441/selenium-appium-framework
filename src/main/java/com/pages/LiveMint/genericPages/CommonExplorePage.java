package com.pages.LiveMint.genericPages;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonExplorePage {
    private static CommonExplorePage commonExplorePage;
    private static GlobalVars globalVars;

    public static CommonExplorePage getInstance() {
        System.out.println("******************* beforeMethod 'Explore Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonExplorePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.IOS_NATIVE:
                    commonExplorePage = new com.pages.LiveMint.ios_native.ExplorePage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonExplorePage = new com.pages.LiveMint.android_native.ExplorePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod 'Explore Page' ends here *******************");
        return commonExplorePage;
    }

    public abstract boolean checkMarketDashboardPage();
    public abstract boolean checkMintPremiumPage();
    public abstract boolean checkPodcastPage();
    public abstract boolean checkShareAppOption();
    public abstract boolean checkRateApp();
    public abstract boolean checkRateAppLaterButton();
    public abstract boolean checkRateAppSubmitButton();
    public abstract boolean checkRateAppWithFiveStarRating();
    public abstract boolean checkRateAppWithBelowFiveStarRating();

    public abstract boolean checkSignInButtonFromExplore();

    public abstract boolean checkBackExplorePageToHomePage();

    public abstract boolean checkSignInButtonFromEpaper();

    public abstract boolean checkBackToHomePageFromEpaperSubscribeNow();

    public abstract boolean checkEpaperPage();

    public abstract boolean checkSubscribeNowButtonFromEpaper();
}
