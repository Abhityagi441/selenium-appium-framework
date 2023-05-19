package com.pages.HindustanTimes.generic;


import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonProfilePage {
    private static CommonProfilePage commonProfilePage;
    private static GlobalVars globalVars;

    public static CommonProfilePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonProfilePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonProfilePage = new com.pages.HindustanTimes.android_native.ProfilePage();
                    break;
                case Constants.IOS_NATIVE:
                    commonProfilePage = new com.pages.HindustanTimes.ios_native.ProfilePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonProfilePage;
    }

    public abstract boolean checkEditProfilePage(String password, String newPassword);

    public abstract boolean checkPasswordRevert(String password, String newPassword);

    public abstract boolean checkEditGender();

    public abstract boolean checkPencilButton();

    public abstract boolean checkEditName(String newUserName, String expectedUserName);

    public abstract boolean checkAboutUsRedirection();

    public abstract boolean checkAboutHTOptions();

    public abstract boolean checkRedirectionForMintAppByTapDownload();

    public abstract boolean checkRedirectionForHindustanAppByTapDownload();

    public abstract boolean checkRedirectionForHealthShotsAppByTapDownload();

    public abstract boolean checkExploreAppsPageDisplayHindustanLiveMintHealthshotsApp();

    public abstract boolean checkRedirectionTapOnExploreApps();

    public abstract boolean checkRedirectionTapOnContactUs();

    public abstract boolean checkRedirectionTapOnPrivacyPolicy();

    public abstract boolean checkRedirectionTapOnAboutUs();

    public abstract boolean checkAboutHindustanTimesHaveAboutUsPrivacyPolicyContactUs();

    public abstract boolean checkRedirectionByBackArrowFromDisplayAndTextSizePage();

    public abstract boolean selectDarkThemeAndBackToHomePage();

    public abstract boolean checkDefaultTextSize();

    public abstract boolean checkBuildVersionDisplay();

    public abstract boolean checkDefaultTextSizeIsMedium();

    public abstract boolean checkBuildVersionDisplayed();

    public abstract boolean checkExploreAppsOption();

    public abstract boolean checkLikedAppSection();

    public abstract boolean checkBookmarkOptionOnProfilePage();

    public abstract boolean checkBookmarkOptionRedirectionPage();

    public abstract boolean checkBookmarkOptionRedirectionHaveNoBookmarks();
}
