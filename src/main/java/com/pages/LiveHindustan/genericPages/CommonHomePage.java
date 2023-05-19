package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHomePage {
    private static CommonHomePage commonHomePage;
    private static GlobalVars globalVars;


    public static CommonHomePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonHomePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonHomePage = new HomePage();
                    break;
                case Constants.ANDROID_AMP:
                    commonHomePage = new com.pages.LiveHindustan.android_amp.HomePage();
                    break;
                case Constants.IOS_AMP:
                    commonHomePage = new com.pages.LiveHindustan.ios_amp.HomePage();
                    break;
                case Constants.ANDROID_WEB:
                    commonHomePage = new com.pages.LiveHindustan.android_mweb.HomePage();
                    break;
                case Constants.IOS_WEB:
                    commonHomePage = new com.pages.LiveHindustan.ios_mweb.HomePage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonHomePage;
    }

    public abstract boolean checkHeaderDisplay();

    public abstract boolean checkHomePageRHSWidgets();

    public abstract boolean checkPramukhKhabreWidget();

    public abstract boolean checkScrollOnHomePage();

    public abstract boolean checkTopNevBar();

    public abstract boolean checkTopMenuBar();

    public abstract boolean checkWidgetOnHomePage();

    public abstract boolean checkApkeLiaKhasWidgetsAndStoryClickable();

    public abstract boolean checkTextToSpeechPlayAndPauseFunctionality();

    public abstract boolean checkTopAdAndBottomAdLoadProperly();

    public abstract boolean checkAllPageAreLoadingProperly();

    public abstract boolean checkPhotoGalleryLandingPage();

    public abstract boolean checkRHSAdLoadProperly();

    public abstract boolean checkBetweenWidgetsAdsLoad();

    public abstract boolean checkRFUApkeLiaKhasWidget();

    public abstract boolean checkHomePageRFUWidgets();

    public abstract boolean checkNumerologyPage();

    public abstract boolean checkAstrologyLandingPageSubMenu();

    public abstract boolean checkRHSWidgets();

    public abstract boolean checkHomePageAndWidgets();

    public abstract boolean checkLiveBlogButtonOnHome();

    public abstract boolean checkRefreshButtonOnLiveBlogDetailPage();

    public abstract boolean checkLivBlogLiveUpdateButtonOnDetailPage();

    public abstract boolean checkWebStoryDetailPage();

    public abstract boolean checkAmpHomePage();

    public abstract boolean checkAllHamburgerLinksFunctionality();

    public abstract boolean checkHomePageRhsAdLoad();

    public abstract boolean checkMwebHomePageRfuWidget();

    public abstract boolean checkMwebVideoLandingPage();

    public abstract  boolean checkNewsBriefOnAmp();
    public abstract boolean checkIosAmpHomePage();
    public abstract boolean checkSeoContentOnThePages();

    public abstract boolean checkAllTopicAreGiving200StatusCode();

    public abstract boolean checkEntertainmentWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkPhotoGalleryWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkHindustanPahalLinkWidgetRedirectionAndStatusCodeIs200();

    public abstract boolean checkDharmWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkInfiniteScrollingOnListingPage();


    public abstract boolean checkCricketWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkNationalWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkBusinessWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkCareerWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkGadgetsWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkTopVideoWidgetIsHaving5StoriesAndStatusIs200();

    public abstract boolean checkAutoWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkApnaSheherChuneWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkLifestyleWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkHTWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkLMWidgetIsHaving6StoriesAndStatusIs200();

    public abstract boolean checkKhabrePhotoAndVideoShouldHaveNewsListedUnderItOnSearching(String searchKeyword,String section1,String section2,String section3);

    public abstract boolean checkNewsBriefWidgetIsHaving7StoriesAndStatusIs200();

    public abstract boolean checkRashifalWidgetIsHaving12RashiPresentAndStatusIs200();

}
