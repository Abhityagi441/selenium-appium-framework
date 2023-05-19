package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.BookmarkPage;
import com.pages.HindustanTimes.web.LoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBookmarkPage {
    private static CommonBookmarkPage commonBookmarkPage;
    private static GlobalVars globalVars;

    public static CommonBookmarkPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonBookmarkPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonBookmarkPage = new BookmarkPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonBookmarkPage = new com.pages.HindustanTimes.android_amp.BookmarkPage();
                    break;
                case Constants.IOS_AMP:
                    //ios amp constructor to be added here
                    break;

                case Constants.ANDROID_WEB:
                    commonBookmarkPage = new com.pages.HindustanTimes.android_mweb.BookmarkPage();
                    break;
                case Constants.IOS_WEB:
                    commonBookmarkPage = new com.pages.HindustanTimes.ios_mweb.BookmarkPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonBookmarkPage = new com.pages.HindustanTimes.android_native.BookmarkPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonBookmarkPage = new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonBookmarkPage;
    }

    public abstract boolean checkAdToBookmarkAndVerify(String uri, String address);

    public abstract boolean checkBookmarkIconIsClickableAndDisplay(String uri, String address);

    public abstract boolean checkBookMarkWorkingFine(String[] params);

    public abstract boolean checkRemoveAllLinkBookMarkPage(String[] params);

    public abstract boolean checkClickThreeDotDisplayDifferentOptions();

    public abstract boolean checkBookMarkRedirectionLoggedInUser();

    public abstract boolean checkBookMarkRedirectionNonLoggedInUser();

    public abstract boolean checkOptionsInSettings();

    public abstract boolean checkBottomActionPageOnIndiaPage();

    public abstract boolean checkBookmark3DotOption();

    public abstract boolean checkRedirectionOnTapBackFromBookmarkPage();

    public abstract boolean checkSomeArticleIsBookmarked();

    public abstract boolean checkBookmarkPageHeadingInCenter();

    public abstract boolean checkTextDisplayAfterBookmarkPageHeading();

    public abstract boolean checkRedirectionStoryPageOnTap();

    public abstract boolean checkRedirectionSectionPageOfStoryOnTap();

    public abstract boolean checkBottomNavDisplayOnBookmarkPage();

    public abstract boolean checkHomeisSelectedBottomNavOnBookmarkPage();

    public abstract boolean checkBookmarkIconDisplayBeforeImageStory();

    public abstract boolean checkTapOnBookmarkIconAtBookmarkPage();

    public abstract boolean checkBookmarkStoryDisplay();

    public abstract boolean checkBookmarkStoryDisplayForAnySectionSavedArticles();

    public abstract boolean bookMarkStoryFromSportsSection();

    public abstract boolean sportStoryInBookMarkedArtical();

    public abstract boolean bookMarkStoryFromPhotosSection();

    public abstract boolean photoStoryInBookMarkedArtical();

    public abstract boolean checkCountOfBookMarkedStoriesSame();

    public abstract boolean checkBookMarkMsgForLoggedInUser();

    public abstract boolean checkBookMarkMsgBoxForNonLoggedInUser();

    public abstract boolean checkUnBookMarkStoryOfVideoSection();

    public abstract boolean checkBookMarkedStoryFromVideoSection();

    public abstract boolean checkUnBookMarkStoryOfPhotosSection();

    public abstract boolean checkBookMarkStoryFromSectionListingPage();

    public abstract boolean checkBookMarkStoryInBookmarkSectionFromSectionListingPage();

    public abstract boolean checkBackRedirectionFromBookmarkPage();

    public abstract boolean checkBookMarkStoryFromSearchPage();

    public abstract boolean checkUnBookMarkStoryFromSearchPage();

    public abstract boolean checkSearchBookMarkStoryDisplayedInBookMarkSection();

    public abstract boolean checkDailyDigestBookMarkStoryDisplayedInBookMarkSection();

    public abstract boolean checkDailyDigestUnBookMarkStoryDisplayedInBookMarkSection();

    public abstract boolean checkBookMarkStoryFromTopicPage();

    public abstract boolean checkUnBookMarkStoryFromTopicPage();

    public abstract boolean checkTopicBookMarkStoryDisplayedInBookMarkSection();

    public abstract boolean checkBookMarkedStoryFromDailyDigest();
}
