package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.StoryPage;
import com.pages.LiveHindustan.android_mweb.LoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonStoryPage {
    private static CommonStoryPage commonStoryPage;
    private static GlobalVars globalVars;


    public static CommonStoryPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonStoryPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                case Constants.DESKTOP_WEB:
                    commonStoryPage = new StoryPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonStoryPage = new com.pages.LiveHindustan.android_amp.StoryPage();
                    break;
                case Constants.IOS_AMP:
                    commonStoryPage = new com.pages.LiveHindustan.ios_amp.StoryPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonStoryPage = new com.pages.LiveHindustan.android_mweb.StoryPage();
                    break;
                case Constants.IOS_WEB:
                    commonStoryPage = new com.pages.LiveHindustan.ios_mweb.StoryPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonStoryPage;
    }

    public abstract boolean checkStoryDetailPage();

    public abstract boolean checkStoryPageBreadcrumb();

    public abstract boolean checkStoryTags();

    public abstract boolean checkAdFor2ndAnd3rdByNumberOfWords();

    public abstract boolean checkFirstAdComesAfterFirstParagraph();

    public abstract boolean checkSummaryOfTheStoryPage();

    public abstract boolean checkStoryPage();

    public abstract boolean checkListingPageForNational();


    public abstract boolean checkNextPageAppending();

    public abstract boolean checkStoryPageRHS();

    public abstract boolean checkStoryPageOneTapFunctionality();

    public abstract boolean checkWebStoryDetailPage();

    public abstract boolean checkAppPerPadheFunctionalityInstalled();
    public abstract boolean checkAppPerPadheFunctionalityNotInstalled();
    public abstract boolean checkRelatedNewsWidgetOnStoryDetail();
    public abstract boolean checkUrlMustChange();
    public abstract boolean checkAurPadheButtonOnAmpStoryPage();

    public abstract boolean checkListViewInSambahanditKhabreWidgetInStoryPages();

    public abstract boolean checkAglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading();

    public abstract boolean checkAglaLekhInWebStoryPagesAsStickyBottom();

    public abstract boolean checkURLShouldChangeWhileScrollingOnSlideStory(String slideStoryUrl);

    public abstract boolean checkBreadcrumbOnSlideStory(String slideStoryUrl);

    public abstract boolean checkTheListViewAndPagesNumberAtFooterOnTagPage();

    public abstract boolean checkSocialSharingOnSlideStory(String slideStoryUrl);
    public abstract boolean checkSocialSharingRedirectionOnStoryDetailPage();
    public abstract boolean checkHeadlineAndImageBylineOnStoryDetailPage();

    public abstract boolean checkAglaLekhFooterGetsHighlighted();

}
