package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.android_native.PodCastPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPodCastPage {
    private static CommonPodCastPage commonPodCastPage;
    private static GlobalVars globalVars;

    public static CommonPodCastPage getInstance() {
        System.out.println("******************* beforeMethod 'PodCast Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonPodCastPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonPodCastPage = new PodCastPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonPodCastPage = new com.pages.LiveMint.ios_native.PodCastPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod 'PodCast Page' ends here *******************");
        return commonPodCastPage;
    }
    public abstract boolean checkPodCastCarousel();
    public abstract boolean checkPodCastCarouselViewAll();
    public abstract boolean checkPodCastReleaseDate();
    public abstract boolean checkPodCastViewAllFunctionality();
    public abstract boolean checkPodCastPageBackBtnFunctionality();
    public abstract boolean checkPodCastEpisodePagePlayButton();
    public abstract boolean checkPodCastBottonMsg();
    public abstract boolean checkPodCastViewAll();
    public abstract boolean checkPodCastEpisodePageStoryName();
    public abstract boolean checkPodCastPageMastHeadAd();
    public abstract boolean checkPodCastCardSwipe();
    public abstract boolean relaunchApp();
    public abstract boolean checkPodCastCardEpisodePageSquareBox();
    public abstract boolean checkPodCastCardEpisodeListing();
    public abstract boolean checkPodCastCardPlayButton();

    public  abstract boolean checkPodCastFreeEpisodePage();

    public abstract boolean checkPodCastCardEpisodeNameandNumber();

    public abstract boolean checkPodcastPlayButton();

    public abstract boolean checkPodCastEpisodePageDescriptionSeeAllIcon();

    public abstract boolean checkPodCastFreeEpisodeBeforeLogIn();

    public abstract boolean checkPodCastFreeEpisodeNonSubscribedUser();
    public abstract boolean checkPodCastSectionByExplore();
    public abstract boolean checkAccessPodcastListingPageFromHomepage();
    public abstract boolean checkPodcastSeriesListing();
    public abstract boolean checkPlayingAnEpisodeOnEpisodeDetailPage();
    public abstract boolean checkPodcastDetailSeeMoreMainPlaylistAndEpisodesPlaylist();


    public abstract boolean checkPlayButtonChangesListenNow();

    public abstract boolean checkEpisodeInTwoByTowGrid();

    public abstract boolean checkPodcastPageByViewAll();

    public abstract boolean checkPodcastEpisodeListingPageByTitleNotDisplayed();

    public abstract boolean checkPodcastEpisodeListingPageByThumbnailDisplayed();

    public abstract boolean checkThroughTitleEpisodeNotPlayed();

    public abstract boolean checkPodcastEpisodePlayButtonNotDisplay();

    public abstract boolean checkSeeMoreMainAndEpisodePlaylistOnPodcastEpisodePage();
}

