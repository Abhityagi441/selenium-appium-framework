package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonPodCastPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PodCastPage extends CommonPodCastPage {

    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCASTS']")
    private static MobileElement podCastCarousel;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCASTS']/ancestor::*[@resource-id='com.htmedia.mint:id/header_layout']")
    private static MobileElement getPodCastCarouselSection;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCASTS']/following-sibling::android.widget.TextView[@text='View All']")
    private static MobileElement podCastViewAllSection;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/tv_time'])[1]")
    private static MobileElement podCastSectionReleaseDate;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_desc")
    private static List<MobileElement> podCastSectionStoryHeadline;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/tv_title']")
    private static List<MobileElement> podCastPageStoryName;
    @AndroidFindBy(id = "com.htmedia.mint:id/videoPreviewPlayButton")
    private static List<MobileElement> podCastPageStoryPlayButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='back']")
    private static MobileElement podCastPageBackButton;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout")
    private static List<MobileElement> listOfStoriesOnPodCastPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_bottom")
    private static MobileElement bottomMsgOnPodCastPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_bottom_url")
    private static MobileElement bottomUrlOnPodCastPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/btn_play")
    private static MobileElement playBtnOnImageEpisodePage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCAST EPISODES']")
    private static MobileElement podCastEpisodesPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_title")
    private static List<MobileElement> podCastEpisodesPageStoryName;
    @FindBy(xpath = "//android.widget.TextView[@text='Advertisement']")
    private static MobileElement AdAdvertisementLabel;
    @FindBy(xpath = "//android.widget.TextView[@text='MINT SNAPVIEW']")
    private static MobileElement snapView;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/mediaPreview']")
    private static List<MobileElement> podCastPlayButton;
    @FindBy(id = "com.htmedia.mint:id/tv_desc")
    private static List<MobileElement> podCastStoryText;
    @FindBy(id = "com.htmedia.mint:id/rl_wave")
    private static MobileElement squareBoxEpisodePage;
    @FindBy(id = "com.htmedia.mint:id/rl_list")
    private static MobileElement episodePageListingStory;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCASTS']/following-sibling::android.widget.TextView[@text='View All']")
    private static MobileElement podCastViewAllIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCAST']")
    private static MobileElement podCastViewAllPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCAST EPISODES']")
    private static MobileElement podCastEpisodesTitlePage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow display over other apps']")
    private static MobileElement podcastAllowdisplay;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/tv_desc'])[1]")
    private static MobileElement podCastEpisodeNameAndNumber;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PODCAST']")
    private static MobileElement podCastPage;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/mediaPreview'])[1]")
    private static MobileElement podCastCarouselPlayButton;

    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/container'])[2]")
    private static MobileElement popupAfterReadMore;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreHamburger;
    @AndroidFindBy(id = "com.htmedia.mint:id/iv_close")
    private static MobileElement exploreCloseIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Podcast']")
    private static MobileElement explorePodcastOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='back']")
    private static MobileElement backButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.htmedia.mint:id/tv_dateTime']")
    private static List<MobileElement> allEpisodeOnEpisodePage;
    @AndroidFindBy(id = "com.htmedia.mint:id/iv_cross")
    private static MobileElement episodePageSeeMoreDetailPageCrossIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_headline")
    private static MobileElement episodePageSeeMoreDetailPageHeadline;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_desc")
    private static MobileElement episodePageSeeMoreDetailPageDesc;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/tv_desc'])[1]")
    private static MobileElement episodePageMainPlayListSeeMore;
    @AndroidFindBy(xpath = "(//*[@resource-id='com.htmedia.mint:id/tv_desc'])[2]")
    private static MobileElement episodePageEpisodeSeeMore;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Listen Now']")
    private static List<MobileElement> listenNow;
    @AndroidFindBy(id = "com.htmedia.mint:id/collection_container")
    private static MobileElement firstGrid;
    @AndroidFindBy(id = "com.htmedia.mint:id/collection_container2")
    private static MobileElement secondGrid;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/rl_container']")
    private static List<MobileElement> episodeCard;
    @FindBy(xpath= "(//*[@id='videoPreviewPlayButton'])[1]")
    private static MobileElement podCastEpisodePlayButton;
    @FindBy(xpath= "//*[@resource-id='com.htmedia.mint:id/frame_layout']")
    private static List<MobileElement> podCastPageThumbnail;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewPodcasts")
    private static MobileElement podcastOption;


    public PodCastPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
    }

    @Override
    public boolean checkPodCastCarousel() {
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.scrollToElementDown(getPodCastCarouselSection);
        commonFunctions.checkElementVisibilityByScrolling(getPodCastCarouselSection,"podcast Carousel section");
        return commonFunctions.checkElementVisibilityByScrolling(podCastCarousel, "podCast section");
    }

    @Override
    public boolean checkPodCastCarouselViewAll() {
       boolean isShowing;
        isShowing = commonFunctions.clickElement(homeButton, 10, "Home Tab");
        commonFunctions. scrollToElementDown(getPodCastCarouselSection);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(getPodCastCarouselSection,"podcast Carousel section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(podCastViewAllSection, "podCast section view all");
        return isShowing;
    }

    @Override
    public boolean checkPodCastReleaseDate() {
        boolean isShowing;
        isShowing = checkPodCastCarousel();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(podCastSectionReleaseDate,"release date");
        return isShowing;
    }

    @Override
    public boolean checkPodCastViewAllFunctionality() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 2, "stories list");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastPageBackBtnFunctionality() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        isShowing &= commonFunctions.isElementDisplayed(podCastViewAllSection, 10, "podCast view all");
        return isShowing;
    }

    @Override
    public boolean checkPodCastEpisodePagePlayButton() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(playBtnOnImageEpisodePage, 10, "play button on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastBottonMsg() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.scrollToBottomForAndroidNative();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(bottomMsgOnPodCastPage, "bottom msg");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(bottomUrlOnPodCastPage, "bottom URL");
        commonFunctions.navigateBack();
        return isShowing;
    }

    private boolean checkPodCastPage() {
        boolean isShowing;
        isShowing = checkPodCastCarouselViewAll();
        commonFunctions.clickElement(podCastViewAllSection, 10, "view all");
        isShowing &= commonFunctions.isElementDisplayed(podCastPage, 10, "podCast Page title");
        return isShowing;
    }

    @Override
    public boolean checkPodCastViewAll() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 3, "stories list");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastEpisodePageStoryName() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(podCastEpisodesPageStoryName.get(1), 10, "play button on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastPageMastHeadAd() {
        boolean isShowing;
        isShowing = checkPodCastCarouselViewAll();
        commonFunctions.clickElement(podCastViewAllSection, 10, "view all");
        isShowing &= commonFunctions.isElementNotDisplayed(AdAdvertisementLabel, 10, "ad on podCast page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button on episode page");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCardSwipe() {
        boolean isShowing;
        isShowing = checkPodCastCarousel();
//        commonFunctions.scrollDownToElement(podCastPlayButton.get(1));
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(podCastPlayButton,0,"podCast first play button");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(podCastPlayButton,1,"podCast second play button");
        String secondStoryText = commonFunctions.getElementText(podCastStoryText.get(1), 10);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        String thirdStoryText = commonFunctions.getElementText(podCastStoryText.get(1), 10);
        if (secondStoryText != thirdStoryText) {
            isShowing &= true;
            Utils.logStepInfo(true, "card swipe successfully*****");
        } else {
            isShowing = false;
            Utils.logStepInfo(false, "card Not swipe failed!!!!");
        }
        return isShowing;
    }

    @Override
    public boolean relaunchApp() {
        return false;
    }

    @Override
    public boolean checkPodCastCardEpisodePageSquareBox() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(squareBoxEpisodePage, 10, "square box on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button on podCst page");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCardEpisodeListing() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(episodePageListingStory, 10, "listing story on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button on podCst page");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCardPlayButton() {
        boolean isShowing;
        commonFunctions.swipeElementUsingTouchAction(395, 1609, 462, 988);
        isShowing = checkPodCastCarousel();
        isShowing &= commonFunctions.isElementDisplayed(podCastPlayButton.get(1), 10, "first play button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastFreeEpisodePage() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 2, "podCast stories list");
//        commonFunctions.clickByCoordinates(245, 905);//Click on any podCast Episode
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(podCastEpisodesTitlePage, 10, "podCast ViewAll Episodes Page");
        return isShowing;

    }

    @Override
    public boolean checkPodCastCardEpisodeNameandNumber() {
        boolean isShowing;
        isShowing = checkPodCastCarousel();
        isShowing &= commonFunctions.isElementDisplayed(podCastEpisodeNameAndNumber, 10, "podCast Episode Name & Number");
        return isShowing;
    }

    @Override
    public boolean checkPodcastPlayButton() {
        boolean isShowing;
        isShowing = checkPodCastCarousel();
        isShowing &= commonFunctions.clickElement(podCastCarouselPlayButton, 10, "Podcast Play Button");
        isShowing &= commonFunctions.isElementDisplayed(podcastAllowdisplay, 10, "podcast Allow display");
        return isShowing;
    }

    @Override
    public boolean checkPodCastEpisodePageDescriptionSeeAllIcon() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 2, "podCast stories list");
        commonFunctions.clickByCoordinates(245, 905);//Click on any podCast Episode
        commonFunctions.clickByCoordinates(874, 1352);//Click on read more option
        isShowing &= commonFunctions.isElementDisplayed(popupAfterReadMore, 10, "Popup After Click On ReadMoreRead More");
        return isShowing;
    }

    @Override
    public boolean checkPodCastFreeEpisodeBeforeLogIn() {
        return false;
    }

    @Override
    public boolean checkPodCastFreeEpisodeNonSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkPodCastSectionByExplore(){
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "home tab");
        commonFunctions.clickElement(exploreHamburger, 10, "explore hamburger");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(explorePodcastOption, "podcast option");
        commonFunctions.clickElement(explorePodcastOption, 10, "podcast");
        isShowing &= commonFunctions.isElementDisplayed(podCastPage, 10, "podcast page");
        commonFunctions.navigateBack();
        isShowing &= commonFunctions.isElementDisplayed(explorePage, 10, "explore page");
        commonFunctions.clickElement(exploreCloseIcon, 10, "explore close icon");
        return isShowing;
    }

    @Override
    public boolean checkAccessPodcastListingPageFromHomepage() {
        return checkPodCastPage();
    }

    @Override
    public boolean checkPodcastSeriesListing() {
        boolean isShowing = checkPodCastPage();
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(podCastEpisodesPage, 10, "episode page");
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(allEpisodeOnEpisodePage,"list of series");
        return isShowing;
    }

    @Override
    public boolean checkPlayingAnEpisodeOnEpisodeDetailPage() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(playBtnOnImageEpisodePage, 10, "play button on episode page");
        commonFunctions.clickElement(playBtnOnImageEpisodePage, 10, "play button");
        return isShowing;
    }

    private boolean seeMoreDescriptionPopup() {
        boolean isShowing = commonFunctions.isElementDisplayed(episodePageSeeMoreDetailPageDesc, 10, "description popup");
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(1);
        return isShowing;
    }

    @Override
    public boolean checkPodcastDetailSeeMoreMainPlaylistAndEpisodesPlaylist() {
        boolean isShowing = checkPodCastPage();
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(podCastEpisodesPage, 10, "episode page");
        commonFunctions.clickElement(episodePageMainPlayListSeeMore, 10, "main playlist see more");
        isShowing &= seeMoreDescriptionPopup();
        commonFunctions.dummyWait(5);
        commonFunctions.checkElementVisibilityByScrolling(episodePageEpisodeSeeMore, "episodes playlist see more");
        commonFunctions.clickElement(episodePageEpisodeSeeMore, 10, "episodes playlist see more");
        isShowing &= seeMoreDescriptionPopup();
        return isShowing;
    }

    @Override
    public boolean checkPlayButtonChangesListenNow() {
        boolean isShowing = checkPodCastCarousel();
        isShowing &=  commonFunctions.isElementNotDisplayed(podCastEpisodePlayButton,5,"play button");
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(listenNow, "listen now");
        return isShowing;
    }

    @Override
    public boolean checkEpisodeInTwoByTowGrid() {
        boolean isShowing = checkPodCastCarousel();
        isShowing &=  commonFunctions.isElementDisplayed(firstGrid,10,"first grid");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(secondGrid,"second grid");
        if (episodeCard.size()==4) {
            isShowing &= true;
            Utils.logStepInfo(true, "4 podcast episode display successfully *****");
        } else {
            isShowing = false;
            Utils.logStepInfo(false, "4 podcast episode Not display failed !!!!!");
        }
        return isShowing;
    }

    @Override
    public boolean checkPodcastPageByViewAll() {
        return checkPodCastPage();
    }

    @Override
    public boolean checkPodcastEpisodeListingPageByTitleNotDisplayed() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        isShowing &= commonFunctionsMobile.clickOnExplorePodcastAndVerifyPage(podcastOption, podCastPage);
        commonFunctions.clickElement(podCastPageStoryName.get(1), 10, "podcast listing title");
        isShowing &= commonFunctions.isElementNotDisplayed(podCastEpisodesPage, 5, "podcast episode page");
        return isShowing;
    }

    @Override
    public boolean checkPodcastEpisodeListingPageByThumbnailDisplayed() {
        commonFunctions.clickElement(podCastPageThumbnail.get(1), 10, "podcast listing page thumbnail");
        boolean isShowing = commonFunctions.isElementDisplayed(podCastEpisodesPage, 5, "podcast episode page");
        commonFunctionsMobile.doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkThroughTitleEpisodeNotPlayed() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        isShowing &= commonFunctionsMobile.clickOnExplorePodcastAndVerifyPage(podcastOption, podCastPage);
        commonFunctions.clickElement(podCastPageStoryName.get(1), 10, "podcast listing title");
        isShowing &= commonFunctions.isElementNotDisplayed(podCastEpisodesPage, 5, "podcast episode page");
        commonFunctionsMobile.doubleBackToHomePage();
        return isShowing;
    }

    @Override
    public boolean checkPodcastEpisodePlayButtonNotDisplay() {
        boolean isShowing = checkPodCastCarouselViewAll();
        isShowing &=  commonFunctions.isElementNotDisplayed(podCastEpisodePlayButton,5,"play button on podcast carousel");
        return isShowing;
    }

    @Override
    public boolean checkSeeMoreMainAndEpisodePlaylistOnPodcastEpisodePage() {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton, exploreHamburger, explorePage);
        isShowing &= commonFunctionsMobile.clickOnExplorePodcastAndVerifyPage(podcastOption, podCastPage);
        commonFunctions.clickElement(listOfStoriesOnPodCastPage.get(1), 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(podCastEpisodesPage, 10, "episode page");
        commonFunctions.clickElement(episodePageMainPlayListSeeMore, 10, "Main playlist: see more");
        isShowing &= seeMoreDescriptionPopup();
        commonFunctions.dummyWait(2);
        commonFunctions.checkElementVisibilityByScrolling(episodePageEpisodeSeeMore, "episodes playlist see more");
        commonFunctions.clickElement(episodePageEpisodeSeeMore, 10, "Episodes playlist: see more");
        isShowing &= seeMoreDescriptionPopup();
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(1);
        commonFunctionsMobile.doubleBackToHomePage();
        return isShowing;
    }



}

