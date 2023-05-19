package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;

public abstract class CommonHomePage {
    private static CommonHomePage commonHomePage;
    private static GlobalVars globalVars;

    public static CommonHomePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonHomePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonHomePage = new HomePage();
                    break;
                case Constants.ANDROID_AMP:
                    commonHomePage = new com.pages.HindustanTimes.android_amp.HomePage();
                    break;
                case Constants.IOS_AMP:
                    commonHomePage = new com.pages.HindustanTimes.ios_amp.HomePage();
                    break;
                case Constants.ANDROID_WEB:
                    commonHomePage = new com.pages.HindustanTimes.android_mweb.HomePage();
                    break;
                case Constants.IOS_WEB:
                    commonHomePage = new com.pages.HindustanTimes.ios_mweb.HomePage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonHomePage = new com.pages.HindustanTimes.android_native.HomePage();
                    break;
                case Constants.IOS_NATIVE:
                    commonHomePage = new com.pages.HindustanTimes.ios_native.HomePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonHomePage;
    }


    public abstract boolean checkAdDisplayingHomePage();

    public abstract boolean checkEpaperCTALogoRedirection(String params[]);

    public abstract boolean checkHomePageLoaded(String[] params);

    public abstract boolean checkTopAdsClickable();

    public abstract boolean checkHamburgerMenuAllOptionDisplayed() throws Exception;

    public abstract boolean checkLiveblogPaginationEmbeds(String title);

    public abstract boolean checkHomePageLoadingVerification();

    public abstract boolean checkLeftPaneDisplayed();

    public abstract boolean checkEpaperCta(String[] params);

    public abstract boolean checkHomePageItems();

    public abstract boolean checkPremiumArtExclusiveTag();

    public abstract boolean checkHTAutoRedirection();

    public abstract boolean checkRedirectionOnTappingProfile();

    public abstract boolean checkMayBeLaterOptionBehaviour();

    public abstract boolean checkEmailTextArea();

    public abstract boolean checkPasswordTextArea();

    public abstract boolean checkHindustanTimesLogoDisplayed();

    public abstract boolean checkRedirectionOnTappingExplore();

    public abstract boolean checkEpaperAndSearchDisplayed();

    public abstract boolean checkHomeTabHeader();

    public abstract boolean checkRedirectionOnVideoFromExplore();

    public abstract boolean checkRedirectionOnPhotosFromExplore();

    public abstract boolean checkSectionHomeIsHighlightedInBottomNav();

    public abstract boolean checkQuickReadsRedirection();

    public abstract boolean checkPremiumRedirection();

    public abstract boolean checkProfileRedirection();

    public abstract boolean checkExploreRedirection();

    public abstract boolean checkSectionIndiaHighlit();

    public abstract boolean checkGetPersonalizedExperiencePageNotDisplay();

    public abstract boolean checkAllBottomNavDisplay();

    public abstract boolean checkTrendingTopicsCarousel();

    public abstract boolean checkTapOnSectionSubsectionRedirectToSectionPage();

    public abstract boolean checkQuickReadsFunctionality();

    public abstract boolean checkDontMissOption();

    public abstract boolean checkCricketSection();

    public abstract boolean checkPhotosSection();

    public abstract boolean checkWebStoriesSection();

    public abstract boolean check3DotMsgBoxDisplayed();

    public abstract boolean checkMostReadSection();

    public abstract boolean checkSubscribeToNewsletterBehaviour();

    public abstract boolean checkShareOption();

    public abstract boolean checkQuickReadHaveOneStoryAtATime();

    public abstract boolean checkQuickReadFirstAndSecondWithSwipe();

    public abstract boolean checkQuickReadReadFullStoryRedirection();

    public abstract boolean checkFirstAdAfter4StoriesInQuickReadPage();

    public abstract boolean checkNonLoggedUserSubscribeButtonOnDailyNewsCapsule();

    public abstract boolean checkLoggedInUserSubscribeButtonOnDailyNewsCapsule(String email);

    public abstract boolean checkNonLoggedUserSubscribeButtonOnHTEdCalling();

    public abstract boolean checkLoggedInUserSubscribeButtonOnHTEdCalling(String email);

    public abstract boolean checkNonLoggedUserSubscribeButtonOnHTWknd();

    public abstract boolean checkLoggedInUserSubscribeButtonOnHTWknd(String email);


    public abstract boolean checkViewAllLinkRightToQuickread();

    public abstract boolean checkQuickreadsReadFullStoryRedirectionForBackpress();

    public abstract boolean checkShareOptionInQuickRead();

    public abstract boolean checkTappingOnViewAllOnLatestVideoCarousel();

    public abstract boolean checkEPaperOptionFromHeader();

    public abstract boolean checkEPaperOptionFromQuickReadHeader();

    public abstract boolean checkAppearanceOfLatestVideoCarousel();

    public abstract boolean checkAdAfterDontMissSection();

    public abstract boolean checkRedirectToRespectiveStory();

    public abstract boolean checkRedirectToStoryFromLatestVideoCarousel();

    public abstract boolean checkRedirectToStoryFromPhotoCarousel();

    public abstract boolean checkRedirectToStoryFromWebStoriesCarousel();

    public abstract boolean checkViewAllFromWebStoriesCarousel();

    public abstract boolean checkQuickReadsCraouselDisplayedOnHome();

    public abstract boolean checkRedirectToStoryFromQuickReadsCraousel();

    public abstract boolean checkNewslettersCarouselDisplayed();

    public abstract boolean checkScrollrightToLeftAndLeftToRightOnNewsletters();

    public abstract boolean checkFirstCardIsDailyNewsCapsuleOnNewsletters();

    public abstract boolean checkSecondCardIsHTEDCallingOnNewsletters();

    public abstract boolean checkRedirectionWhenTabOnReadNowOnNewsletters();
    public abstract boolean checkEmailIdPrefilled(String email);

    public abstract boolean  checkNewsletterScroll(MobileElement ele);

    public abstract boolean checkNonLoggedUserSubscribeButtonOnHTWeekAhead();

    public abstract boolean checkLoggedInUserSubscribeButtonOnHTWeekAhead(String email);

    public abstract boolean checkNonLoggedUserSubscribeButtonOnHTCapitalLetters();

    public abstract boolean checkLoggedInUserSubscribeButtonOnHTCapitalLetters(String email);

    public abstract boolean checkNonLoggedUserSubscribeButtonOnWiredWisdom();

    public abstract boolean checkLoggedInUserSubscribeButtonOnWiredWisdom(String email);

    public abstract boolean checkNonLoggedUserSubscribeButtonOnHTCity();

    public abstract boolean checkLoggedInUserSubscribeButtonOnHTCity(String email);

    public abstract boolean checkRegisterNowButton();

    public abstract boolean checkSubscribeSuccessfully();

    public abstract boolean checkNonLoggedUserSubscribeButtonOnHTMindTheGap();

    public abstract boolean checkLoggedInUserSubscribeButtonOnHTMindTheGap(String email);

    public abstract boolean checkNonLoggedUserSubscribeButtonOnHTKickOff();

    public abstract boolean checkLoggedInUserSubscribeButtonOnHTKickOff(String email);
    public abstract boolean checkRecommendedForYouCarouselOnHome();

    public abstract boolean checkViewAllLinkOnRecommendedForYouCarousel();

    public abstract boolean checkRedirectionWhenTapOnViewAllLinkFromRecommendedForYouCarousel();

    public abstract boolean checkForYouTabOnL1();

    public abstract boolean checkRedirectionWhenTapOnStoryFromRecommendedForYouCarousel();

    public abstract boolean checkDailyDigestRedirection();

    public abstract boolean checkDailyDigestSectionRedirection();

    public abstract boolean checkDailyDigestStoryRedirection();

    public abstract boolean checkDailyDigestStoryShare();

    public abstract boolean checkLoggedInUserCloseButtonOnDailyNewsCapsule();

    public abstract boolean checkLoggedInUserBackButtonOnDailyNewsCapsule();

    public abstract boolean checkTabOnXInSubscribeToNewsletterBehaviour();

    public abstract boolean checkPrivacyPolicyLinkOnDailyNewsCapsule();

    public abstract boolean checkEmailAddressNewslettersTextOnDailyNewsCapsule();

    public abstract boolean checkEmailIsPreFilledTextOnDailyNewsCapsule(String email);

    public abstract boolean checkTextOnNewsLetterForNonLoggedInUser();

    public abstract boolean checkQuickReadsEntertainmentRedirection();

    public abstract boolean checkQuickReadsAllTabRedirection();

    public abstract boolean checkQuickReadsIndiaNewsTabRedirection();

    public abstract boolean checkQuickReadsBusinessTabRedirection();

    public abstract boolean checkQuickReadsSportsTabRedirection();

    public abstract boolean checkAstrologySectionAfterLifestyleInQuickReads();

    public abstract boolean checkDailyDigestDisplayedOnExplore();

    public abstract boolean checkRedirectToCricketSectionFromQuickReads();

    public abstract boolean checkRedirectToCitiesSectionFromQuickReads();

    public abstract boolean checkRedirectToWorldNewsSectionFromQuickReads();

    public abstract boolean checkRedirectToLifeStyleSectionFromQuickReads();

    public abstract boolean checkRedirectToAstrologyTabFromQuickRead();

    public abstract boolean checkWorldNewsDisplayedAfterCitiesSectionInQuickReads();

    public abstract boolean checkAllTabInQuickRead();

    public abstract boolean checkLifeStyleSectionAfterWorldNewsInQuickReads();

    public abstract boolean checkBusinessSectionAfterSportsInQuickReads();

    public abstract boolean checkIndiaNewsSectionAfterAllTabInQuickReads();

    public abstract boolean checkEntertainmentSectionAfterIndiaNewsInQuickReads();

    public abstract boolean checkCricketSectionAfterEntertainmentInQuickReads();

    public abstract boolean checkCitiesSectionAfterCricketInQuickReads();

    public abstract boolean checkSportsSectionAfterAstrologyInQuickReads();

    public abstract boolean checkSwipeUpAndAdAfter4StoriesInQuickReads();

    public abstract boolean checkOtherSectionBySwipingLeftToRightInQuickReads();

    public abstract boolean checkOtherSectionBySwipingRightToLeftInQuickReads();

    public abstract boolean checkSwipeTopToBottomInQuickReads();

    public abstract boolean checkSwipeBottomToTopInQuickReads();

    public abstract boolean checkSecondAdAfter8SwipeInQuickReads();

    public abstract boolean checkSwipeUpOptionInFirstAdInQuickReads();

    public abstract boolean checkRedirectToStoryIfTabOnBlankSpaceInQuickReads();

    public abstract boolean checkEPaperOptionFromCricketHeader();

    public abstract boolean checkEPaperOptionFromPremiumHeader();

    public abstract boolean checkEPaperOptionFromExploreHeader();

    public abstract boolean checkRedirectToDailyDigestFromExplore();

    public abstract boolean checkCityNewsInHomepageDisplayed();

    public abstract boolean checkListOfCitiesInCityNewsDisplayed();

    public abstract boolean checkRedirectionWhenUserTapsOnViewAllInCityNews();

    public abstract boolean checkSectionPageSelectedCityShownInHomePage();

    public abstract boolean checkHomePageSelectedCityShownInSectionPage();

    public abstract boolean checkAllL1SubMenuPresentAnd200StatusCode();

    public abstract boolean checkAllL2SubMenuPresentAnd200StatusCode();

    public abstract boolean checkFirstCollectionTopNews();

    public abstract boolean checkHeaderTopAd();

    public abstract boolean checkMoreOptionInL2();

    public abstract boolean checkLHSAndRHSCollectionAndStories();

    public abstract boolean checkAdInTopAndAfterCollectionInRHS();

    public abstract boolean checkFooterAndData();

    public abstract boolean checkAdsAfterEveryCollectionInMiddleLayer();

    public abstract boolean checkL3SubMenuAnd200SuccessCode();

    public abstract boolean checkAllTopicSuccessCode200();
}
