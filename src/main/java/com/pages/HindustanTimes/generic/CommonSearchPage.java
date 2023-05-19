package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.BreadCrumbsPage;
import com.pages.HindustanTimes.web.SearchPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;

public abstract class CommonSearchPage {
    private static CommonSearchPage commonSearchPage;
    private static GlobalVars globalVars;

    public static CommonSearchPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonSearchPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonSearchPage= new SearchPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonSearchPage= new com.pages.HindustanTimes.android_amp.SearchPage();
                    break;
                case Constants.IOS_AMP:
                    commonSearchPage= new com.pages.HindustanTimes.ios_amp.SearchPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonSearchPage= new com.pages.HindustanTimes.android_mweb.SearchPage();
                    break;
                case Constants.IOS_WEB:
                  commonSearchPage= new com.pages.HindustanTimes.ios_mweb.SearchPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonSearchPage= new com.pages.HindustanTimes.android_native.SearchPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonSearchPage= new com.pages.HindustanTimes.ios_native.SearchPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSearchPage;
    }

    public abstract boolean checkSearchIsWorking(String params[]);

    public abstract boolean clickOnExplorerMenu();

    public abstract boolean clickOnEntertainmentSection();

    public abstract boolean checkRedirectionToEntertainmentSection();

    public abstract boolean checkSearchButtonDisplayedAndClickable(String params[]);

    public abstract boolean checkSearchIsWorking(String text);

    public abstract boolean CheckSearchButtonIsWorking(String params[]);

    public abstract boolean checkSearchButtonRedirection();

    public abstract boolean checkSearchPageRedirectionFromExplore();

    public abstract boolean checkSearchButtonRedirectionProfilePage();

    public abstract boolean checkEPaperOption();

    public abstract boolean checkEPaperOptionFromExplore();

    public abstract boolean checkSearchOptionInCricketPage();

    public abstract boolean checkSearchOptionWhenTabOnBackButton();

    public abstract boolean checkStoryPageOnSearchPage();

    public abstract boolean checkViewAllOnSearchPage();

    public abstract boolean checkDefaultLatestNewsOnSearchPage();

    public abstract boolean checkCricketNewsOnSearchPage();

    public abstract boolean checkSearchIsWorkingOnSearchPage();

    public abstract boolean checkLensIconTextBoxAndVoiceIcon();

    public abstract boolean checkWatermarkRemovedIfEnterAnyChar();

    public abstract boolean checkNewsPhotosVideosLabelsOnSearchPage();

    public abstract boolean checkDefaultNewsDisplayedOnSearchPage();

    public abstract boolean checkNumberOfSearchResultsDisplayedOnSearchPage(String expectedMessage);

    public abstract boolean checkStoryTappableOnSearchPage();

    public abstract boolean checkSearchOptionOnHomePage();

    public abstract boolean checkSearchOptionOnQuickreadsPage();

    public abstract boolean checkSearchOptionOnPremiumPage();

    public abstract boolean checkSearchOptionOnExplorePage();

    public abstract boolean checkSelectedBottomNavTab(MobileElement ele, String text);

    public abstract boolean checkSearchOnCricketPage();

    public abstract boolean checkSearchOnPremiumPage();

    public abstract boolean checkSearchOnQuickReadsPage();

    public abstract boolean checkSearchOnHomePage();

    public abstract boolean checkBottomNavOnSearchPage();

    public abstract boolean checkBottomNavNavigationOnSearchPage();

    public abstract boolean checkHorizontalLineInEachStoryInNewsOnSearchPage();

    public abstract boolean checkShareStoryOptionInSearchPage();

    public abstract boolean checkRedirectToSectionFromSearchPage();

    public abstract boolean checkScrollDownInNewsSectionINSearchPage();

    public abstract boolean checkRedirectToPhotosInSearchPage();

    public abstract boolean checkPhotosOptionDisplayedAsSelectedInSearchPage();

    public abstract boolean checkNumberOfResultInPhotosOnSearchPage(String expectedMessage);

    public abstract boolean checkRedirectToStoryFromPhotosInSearchPag();

    public abstract boolean checkRedirectToVideosInSearchPage();

    public abstract boolean checkVideosOptionDisplayedAsSelectedInSearchPage();

    public abstract boolean checkNumberOfResultInVideosOnSearchPage(String expectedMessage);

    public abstract boolean checkRedirectToStoryFromVideosInSearchPag();

    public abstract boolean checkSearchForNoStoryFoundInSearchPage();

    public abstract boolean checktitleAlsoLikeInNewsTabInSearchPage();

    public abstract boolean checkTitleAlsoLikeInPhotosTabInSearchPage();

    public abstract boolean checkTitleAlsoLikeInVideosTabInSearchPage();

    public abstract boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInNews();

    public abstract boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInPhotos();

    public abstract boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInVideos();

    public abstract boolean checkScrollDownTillLatestTopicInSearchPage();

    public abstract boolean checkRedirectToStoryFromLatestTopicInSearchPage();

    public abstract boolean checkLatestTopicNotDisplayIfSearchAnyKey();

    public abstract boolean checkRedirectToSearchIfTabOnBackBtnFromLatestTopicStory();

    public abstract boolean checkRedirectToLatestNewsViewAllInSearchPage();

    public abstract boolean checkTrendingNews(String searchPageUrl);

    public abstract boolean checkResultDataWithSearchKeyword(String searchPageUrl, String name);
}
