package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.SocialSharingPage;
import com.pages.HindustanTimes.web.StoryPage;
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
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonStoryPage = new com.pages.HindustanTimes.web.StoryPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonStoryPage = new com.pages.HindustanTimes.android_amp.StoryPage();
                    break;
                case Constants.IOS_AMP:
                    commonStoryPage = new com.pages.HindustanTimes.ios_amp.StoryPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonStoryPage = new com.pages.HindustanTimes.android_mweb.StoryPage();
                    break;
                case Constants.IOS_WEB:
                    commonStoryPage = new com.pages.HindustanTimes.ios_mweb.StoryPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonStoryPage = new com.pages.HindustanTimes.android_native.StoryPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonStoryPage = new com.pages.HindustanTimes.ios_native.StoryPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonStoryPage;
    }


    public abstract boolean photoHeadLineSummaryBookMarkAndShare(String uri, String address);


    public abstract boolean checkStoriesDisplayedLastPublished(String params[]);

    public abstract boolean checkStandardStoriesAreDisplayed(String uri, String address);

    public abstract boolean videoStoryContentValidation(String params[]);

    public abstract boolean liveBlogContentValidation(String uri, String address, String url);

    public abstract boolean checkLastPublishedDate(String params[]);

    public abstract boolean photosGalleryContentValidation();

    public abstract boolean checkStandardStoryPagination(String uri, String address);

    public abstract boolean checkContentImagesAndEmbeds(String[] params);

    public abstract boolean checkSignInWallOnStoryPage();

    public abstract boolean checkReadFullStoryClickable(String quickReadURL, String readSFullStoryText);

    public abstract boolean checkReadFullStoryClickableinQuickReads();

    public abstract boolean checkSignInWallOnStoryPage(String readtext, String premium, String saveArticles, String signIn, String signUp, String skip);

    public abstract boolean checkLeadImage();

    public abstract boolean checkHeadline();

    public abstract boolean checkStoryIsExpanded();

    public abstract boolean checkDateTime();

    public abstract boolean checkAuthorName();

    public abstract boolean checkStoryPageHeader();

    public abstract boolean checkTrendingTopicsCarouselDispayed();

    public abstract boolean checkFullStoryCloseButton();

    public abstract boolean checkNewsletterBannerDisplayed();

    public abstract boolean checkImagePremiumDisplayed();

    public abstract boolean checkLeadImage3DotOption();

    public abstract boolean checkAfterHeaderAdFirstStoryIsDisplayed();

    public abstract boolean checkWhatsAppTwitterRelatedTopicPage();

    public abstract boolean checkSectionNameisDispayed();

    public abstract boolean checkSubSectionNameisDispayed();

    public abstract boolean checkShareStory3DotOption();

    public abstract boolean checkActionSheetCancelOption();

    public abstract boolean checkIndiaPageThreeDotTapDisplayBottomAction();

    public abstract boolean checkIndiaPageRedirectionFromExplore();

    public abstract boolean checkCloseTabCloseBottomActionSheet();

    public abstract boolean checkRedirectionOnTappingAnyStoryOnIndiaPage();

    public abstract boolean checkRedirectionFromStoryDetailsPageOnTappingAnyStoryOnIndiaPage();

    public abstract boolean checkShareStoryFromIndia();

    public abstract boolean checkAllStoriesArePremiumOnPremmiumPage();

    public abstract boolean checkPremiumPageDisplay();

    public abstract boolean checkPremiumPageHTPremiumDisplay();

    public abstract boolean checkFirstStoryDisplayAfterTitle();

    public abstract boolean checkFirstStoryImageDisplayWithPremiumTag();

    public abstract boolean checkOtherStoryAreAlsoPremium();

    public abstract boolean checkAllOtherStoryHavePremiumTagAtBottom();

    public abstract boolean checkStoryHaveSubSectionBelowTitle();

    public abstract boolean checkStoryDisplayOnItsSectionPage();

    public abstract boolean checkNonLoggedUserOnPremiumPage();

    public abstract boolean checkRelatedTopicHeadingDisplayed();

    public abstract boolean checkRelatedTopicsDisplayed();

    public abstract boolean checkRelatedTopicsRedirection();

    public abstract boolean checkRelatedTopicsPageStoryRedirection();

    public abstract boolean checkRedirectionOnTopicStoryIfTabOnbBackBtn();

    public abstract boolean checkShareStoryFromTopicScreen();

    public abstract boolean checkRedirectionOnStoryIfTabOnSectionName();

    public abstract boolean checkReadAloudOptionInStoryPage();

    public abstract boolean checkRedirectionWhenUserTapsOnStoryInCitiesSection();

    public abstract boolean checkSubscriptionPaywall(String HTPremiumPageUrl, String email, String password);
}
