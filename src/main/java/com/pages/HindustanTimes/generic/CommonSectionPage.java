package com.pages.HindustanTimes.generic;

import com.pages.HindustanTimes.ios_mweb.SectionPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSectionPage {
    private static CommonSectionPage commonSectionPage;
    private static GlobalVars globalVars;

    public static CommonSectionPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonSectionPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.IOS_WEB:
                    commonSectionPage = new SectionPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonSectionPage = new com.pages.HindustanTimes.android_amp.SectionPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonSectionPage = new com.pages.HindustanTimes.android_mweb.SectionPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonSectionPage = new com.pages.HindustanTimes.ios_native.SectionPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonSectionPage = new com.pages.HindustanTimes.web.SectionPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonSectionPage = new com.pages.HindustanTimes.android_native.SectionPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSectionPage;
    }

    public abstract boolean checkIsSectionIndiaNewsScrollable();

    public abstract boolean checkIsSectionIndiaNewsDisplayedClickable();

    public abstract boolean checkFullStoryVisisbleAndClickableInQuickRead(String quickReadURL, String readSFullStoryText, String target1, String target2);

    public abstract boolean checkTopicPage(String topicURL);

    public abstract boolean checkTopicLandingPage(String topicURL);

    public abstract boolean checkL1LandingPage();

    public abstract boolean checkBreadcrumbDisplayedFromGoogle(String url, String searchText);

    public abstract boolean checkL2NewTag();

    public abstract boolean checkAppLaunchDisplayTopSection();

    public abstract boolean checkBottomNavHomeSelected();

    public abstract boolean checkBottomNavDispalyFromAnotherSectionPage();

    public abstract boolean checkSectionRedirectionPage();

    public abstract boolean checkBusinessSection();

    public abstract boolean checkSudokuSection();

    public abstract boolean checkClickCityDisplayCitiesInExplore();

    public abstract boolean checkClickExplorePageAppearAgain();

    public abstract boolean checkCitiesSectionNameisDispayed();

    public abstract boolean checkNoidaSubSectionNameisDispayed();

    public abstract boolean checkPopularSectionsDisplayed();

    public abstract boolean checkSectionNamesDisplayed();

    public abstract boolean checkSectionLiveBlogWithRedDotOnStory();

    public abstract boolean checkRedirectionFromExploreToPhotos();

    public abstract boolean checkRedirectionFromExploreToVideos();

    public abstract boolean checkPremiumStoryInsideSectionPage();

    public abstract boolean checkUserScrollToBottomOfTopNewsPage();

    public abstract boolean checkForLiveBlogForTopNewsPage();

    public abstract boolean checkRedirectionFromWorld();

    public abstract boolean checkRedirectionFromCities();

    public abstract boolean checkRedirectionFromIndia();

    public abstract boolean SubSectionNameInCitiesSection();

    public abstract boolean WorldSectionInDarkMode();

    public abstract boolean opinionSectionRedirection();

    public abstract boolean checkScrollingOnOpinion();

    public abstract boolean redirectToStoryFromOpinion();

    public abstract boolean checkAdAfterFiveStories();

    public abstract boolean redirectToCricketSection();

    public abstract boolean redirectToEntertainmentSection();

    public abstract boolean redirectToStoryFromEntertainment();

    public abstract boolean subSectionInEntertainment();

    public abstract boolean redirectToSubSectionInEntertainment();

    public abstract boolean redirectToToTrendingSection();

    public abstract boolean redirectToStoryFromTrendingSection();

    public abstract boolean redirectOnVideoSection();

    public abstract boolean subSectionNamesInVideoPage();

    public abstract boolean appearanceOfVideoSectionPage();

    public abstract boolean redirectToStoryFromVideoSectionPage();

    public abstract boolean redirectToSubsectionOfVideoSection();

    public abstract boolean redirectOnLifeStyleSection();

    public abstract boolean redirectToSubSectionOfLifeStyle();

    public abstract boolean storyInLifeStyleSection();

    public abstract boolean redirectToEducationSection();

    public abstract boolean subSectionOnEducationSection();

    public abstract boolean redirectionOnSportSection();

    public abstract boolean redirectToSubSectionFromSportSection();

    public abstract boolean redirectToStoryFromSportSection();

    public abstract boolean redirectToPhotosSection();

    public abstract boolean shareStoryFromSportsSection();

    public abstract boolean appearanceOfPhotosSection();

    public abstract boolean photoSectionInDarkMode();

    public abstract boolean redirectToPhotoSectionStory();

    public abstract boolean redirectToStoryFromPhotosSection();

    public abstract boolean shareStoryFromPhotoSection();

    public abstract boolean marketStatWidgetAfterFirstStory();

    public abstract boolean redirectToBusinessSection();

    public abstract boolean marketStatWidgetFourOptions();

    public abstract boolean checkValuesInMarketStatWidget();

    public abstract boolean redirectToMumbaiNewsSection();

    public abstract boolean storyDisplayedAfterMarketStatWidget();

    public abstract boolean checkRedirectToBusinessStory();

    public abstract boolean checkRedirectToDelhiNewsSection();

    public abstract boolean redirectToStoryOfMumbaiNewsSection();

    public abstract boolean checkRedirectToStoryFromDelhiNewsSection();

    public abstract boolean checkRedirectToTvNewsSection();

    public abstract boolean checkRedirectToStoryFromTTvNewsSection();

    public abstract boolean checkCameraIconWithNumberOfPhotosInPhotosSection();

    public abstract boolean countInleadStoryInPhotosSection();

    public abstract boolean checkWebStoriesSectionFromTopSection();

    public abstract boolean checkWebStoriesSectionFromExplore();

    public abstract boolean checkImagesHorizontalLinesInWebStories();

    public abstract boolean checkAppLogoInWebStories();

    public abstract boolean checkThreeDotsDislpayedInWebStories();

    public abstract boolean checkRedirectionOnForYouSection();

    public abstract boolean checkEditProfilePageInDarkMode();

    public abstract boolean checkTextOnCityPopUp();

    public abstract boolean checkRedirectionOnCitiesSection();

    public abstract boolean checkRedirectionWhenTapOnGotItButton();

    public abstract boolean checkNoRedirectionWhenTapOnWhenAnyWhereExceptGotItButton();

    public abstract boolean checkPlusSignDisplayBeforeCityName();

    public abstract boolean checkHorizontalLinesAtEndOfCityName();

    public abstract boolean checkMayBeLaterAndSaveChangesButton();

    public abstract boolean checkOthersOptionInCities();

    public abstract boolean checkBehaviourWhenUserTapsOnPlusButtonBeforeCityName();

    public abstract boolean checkBehaviourWhenUserTapsOnMayBeLaterButton();

    public abstract boolean checkBehaviourNoCitySelectedAndTapsOnSaveChangesButton();

    public abstract boolean checkPopUpWhenSelectAnyCity();

    public abstract boolean checkSelectedCityShownUnderCitiesSection();

    public abstract boolean checkBehaviourWhenUserSelectAnyCityAndTapsOnMayBeLaterButton();

    public abstract boolean checkDateInCitiesAfterSelectedCity();

    public abstract boolean checkTemperatureDisplayedInCitiesSection();

    public abstract boolean checkCityNameDisplayedAfterAdWithNews();

    public abstract boolean checkRedirectionWhenTapOnOtherSelectedCities();

    public abstract boolean checkRedirectionWhenTapOnMultipleCities();

    public abstract boolean checkBehaviourWhenUserDeselectAnySelectedCity();

    public abstract boolean checkFirstStoryInCardView();

    public abstract boolean checkFourthStoryPartneredStory();

    public abstract boolean checkAdsAfterEveryThreeStory();

    public abstract boolean checkThirtyStoryOnSectionPage(String worldNewsUrl);

    public abstract boolean checkPagination(String secondPageUrl,String worldNewsUrl);

    public abstract boolean checkLHSAndRHSData(String indiaNewsUrl);

    public abstract boolean checkMatchCard(String cricketUrl);

    public abstract boolean checkViewFullScorecard(String cricketUrl, String liveScorecard);
}


