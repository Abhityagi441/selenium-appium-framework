package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonPodCastPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PodCastPage extends CommonPodCastPage {

    static IOSDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ask App')]")
    private static MobileElement notificationAskNotToTrack;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Not Now']")
    private static MobileElement darkThemeNotNow;
    @iOSXCUITFindBy(id = "Don’t Allow")
    private static MobileElement notificationDontAllow;
    @iOSXCUITFindBy(id = "Later")
    private static MobileElement notificationLater;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Skip'`]")
    private static MobileElement SkipAdsFreeUserExp;
    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;
    @iOSXCUITFindBy(id = "PODCASTS")
    private static MobileElement podcastCarousel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PODCASTS']/following-sibling::XCUIElementTypeButton[@name='View All']")
    private static MobileElement podcastCarouselViewAll;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PODCASTS']/following-sibling::XCUIElementTypeStaticText[contains(@name,' 202')]")
    private static List<MobileElement> podCastSectionReleaseDate;
    @iOSXCUITFindBy(id = "PODCAST")
    private static MobileElement podCastPage;
    @iOSXCUITFindBy(id = "PODCASTS")
    private static MobileElement podCastCarousel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private static List<MobileElement> listOfStoriesOnPodCastPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement podCastPageBackButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeButton[2]")
    private static MobileElement firstStoryOnPodCastPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Play Latest'])[1]")
    private static MobileElement playBtnOnImageEpisodePage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'For more Podcasts visit HT Smartcast'`]")
    private static MobileElement bottomMsgOnPodCastPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'www.htsmartcast.com')]")
    private static MobileElement bottomUrlOnPodCastPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Remove Ad'`]")
    private static MobileElement firstAdsRemoveAdButton;
    @iOSXCUITFindBy(id = "MINT SNAPVIEW")
    private static MobileElement mintSnapView;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='logo01Latest'])[2]")
    private static MobileElement mintLogo;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'premiumLiveMintLogo'`][2]")
    private static MobileElement mintPremiumLogo;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PODCASTS']/preceding::XCUIElementTypeButton[2]")
    private static MobileElement secondCardPlayBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PODCASTS']/preceding::XCUIElementTypeButton[6]")
    private static MobileElement firstCardPlayBtn;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PODCASTS']/following-sibling::XCUIElementTypeStaticText[2]")
    private static MobileElement secondCardStoryHeadline;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Play Latest'])[1]/preceding::XCUIElementTypeStaticText[2]")
    private static MobileElement episodePageStoryHeadline;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[2]//following::XCUIElementTypeStaticText)[1]")
    private static MobileElement podCastPageFirstStoryHeadline;
    private static String squareBoxEpisodePage = "//XCUIElementTypeOther[contains(@name,'%s')]";
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
    private static MobileElement episodePageListingStory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='PODCASTS']/preceding-sibling::XCUIElementTypeButton)[2]")
    private static MobileElement podcastSection;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;

    @iOSXCUITFindBy(id = "PODCAST")
    private static MobileElement podCastViewAllPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Mint Equitymaster Investor Hour'`][1]")
    private static MobileElement podCastEpisodeName;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='5 Episodes'])[2]")
    private static MobileElement podCastEpisodeNumber;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PODCAST EPISODES']")
    private static MobileElement podcastEpisodePage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Mint Business News'`][1]")
    private static MobileElement podCastEpisodeTittle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='Mint']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    private static MobileElement popupAfterReadMore;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='ic profile dark'])[2]")
    private static MobileElement loginProfileButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Login or Register']")
    private static  MobileElement loginorRegisterPage;

    @iOSXCUITFindBy(accessibility = "(//XCUIElementTypeStaticText[@name='PODCASTS']/following-sibling::XCUIElementTypeStaticText)[2]")
    private static MobileElement podCastEpisodeNameAndNumber;

    @iOSXCUITFindBy(accessibility = "play Expand")
    private static MobileElement playExpandButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'ic explore dark'`][2]")
    private static MobileElement exploreHamburger;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Back']")
    private static MobileElement backButton;
    @iOSXCUITFindBy(id = "EXPLORE")
    private static MobileElement explorePage;
    @iOSXCUITFindBy(id = "Podcast")
    private static MobileElement ExplorePodcastOption;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,' Read More')])[1]")
    private static MobileElement episodePageMainPlayListSeeMore;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,' Read More')])[2]")
    private static MobileElement episodePageEpisodeSeeMore;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Episode ')]")
    private static List<MobileElement> allEpisodeListing;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,' Episode')])[1]")
    private static MobileElement totalEpisode;
    @iOSXCUITFindBy(id = "podcast close")
    private static MobileElement closeBtnPopup;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='podcast close']//following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> readMorePage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Listen Now']")
    private static List<MobileElement> listenNow;


    public PodCastPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(notificationAskNotToTrack, 10, "notification AskNotToTrack");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationDontAllow, 5, "notification DontAllow");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        commonFunctions.clickElementIfDisplayed(continueAdsFreeUserExp, 5, "continue Ads Free User Exp");
        commonFunctions.clickElementIfDisplayed(darkThemeNotNow, 5, "dark theme Later");
        commonFunctions.clickElementIfDisplayed(notificationLater, 5, "notification Later");
        commonFunctions.clickElementIfDisplayed(SkipAdsFreeUserExp, 5, "SkipAdsFreeUserExp");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkPodCastCarousel() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(podcastSection, "podcast section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(podcastCarousel, "podCast section");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCarouselViewAll() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(podcastSection, "podcast section");
        if (!commonFunctions.isElementDisplayedWithoutTryCatch(podcastCarouselViewAll, 5, "podCast section view all")) {
            commonFunctions.swipeElementUsingTouchAction(160, 198, 161, 409);
        }
        isShowing &= commonFunctions.isElementDisplayed(podcastCarouselViewAll, 5, "podCast section view all");
        return isShowing;
    }

    @Override
    public boolean checkPodCastReleaseDate() {
        boolean isShowing;
        isShowing = checkPodCastCarousel();
        isShowing &= commonFunctions.isElementDisplayed(podCastSectionReleaseDate.get(1), 10, "release date");
        return isShowing;
    }

    private boolean checkPodCastPage() {
        boolean isShowing;
        isShowing = checkPodCastCarouselViewAll();
        commonFunctions.clickElement(podcastCarouselViewAll, 10, "view all");
        isShowing &= commonFunctions.isElementDisplayed(podCastPage, 10, "podCast Page title");
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
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementEnabled(podcastCarousel, "podCast section");
        return isShowing;
    }

    @Override
    public boolean checkPodCastEpisodePagePlayButton() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(firstStoryOnPodCastPage, 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(playBtnOnImageEpisodePage, 10, "play button on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastBottonMsg() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.scrollToBottomOniOSNative();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(bottomMsgOnPodCastPage, "bottom msg");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(bottomUrlOnPodCastPage, "bottom URL");
        commonFunctions.scrollToTopOniOSNative();
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastViewAll() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 10, "stories list");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastEpisodePageStoryName() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        String podCastPageStoryHeadlineText = commonFunctions.getElementText(podCastPageFirstStoryHeadline, 10);
        commonFunctions.clickElement(firstStoryOnPodCastPage, 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(episodePageStoryHeadline, 10, "story headline");
        isShowing &= commonFunctions.getElementTextAndCheck(episodePageStoryHeadline, podCastPageStoryHeadlineText, 10, "story headline text on episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button ");
        return isShowing;
    }

    @Override
    public boolean checkPodCastPageMastHeadAd() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.isElementDisplayed(firstAdsRemoveAdButton, 10, "mast Head ad");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCardSwipe() {
        boolean isShowing;
        isShowing = checkPodCastCarousel();
        int firstEle[] = commonFunctions.getElementXYCoordinate(firstCardPlayBtn);
        int secondEle[] = commonFunctions.getElementXYCoordinate(secondCardPlayBtn);
        String secondStoryText = commonFunctions.getElementText(secondCardStoryHeadline, 10);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        String thirdStoryText = commonFunctions.getElementText(secondCardStoryHeadline, 10);
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
        boolean isShowing;
        commonFunctions.killAppAndReLaunch();
        isShowing = commonFunctions.isElementNotDisplayed(mintPremiumLogo, 2, "mint premium logo");
        isShowing &= commonFunctions.isElementDisplayed(mintLogo, 10, "mint logon");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCardEpisodePageSquareBox() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        String podCastPageStoryHeadlineText = commonFunctions.getElementText(podCastPageFirstStoryHeadline, 10);
        commonFunctions.clickElement(firstStoryOnPodCastPage, 10, "first story on podCast Page");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayedByXpath(String.format(squareBoxEpisodePage, podCastPageStoryHeadlineText), 20, "square box episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button ");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCardEpisodeListing() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(firstStoryOnPodCastPage, 10, "first story on podCast Page");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(episodePageListingStory, "listing story on episode page");
        int storyWidth = episodePageListingStory.getSize().getWidth();
        int storyLength = episodePageListingStory.getSize().getHeight();
        if (storyWidth == 390 || storyLength == 130) {
            Utils.logStepInfo(true, "listing story display Successfully !!!!!");
            isShowing &= true;
        } else {
            Utils.logStepInfo(true, "listing story Not display Verification Failed !!!!!");
            isShowing &= false;
        }
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button episode page");
        commonFunctions.clickElement(podCastPageBackButton, 10, "back button ");
        return isShowing;
    }

    @Override
    public boolean checkPodCastCardPlayButton() {
        boolean isShowing;
        isShowing = checkPodCastCarousel();
        isShowing &= commonFunctions.isElementDisplayed(firstCardPlayBtn, 10, "play button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastFreeEpisodePage() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 2, "podCast stories list");
        commonFunctions.clickByCoordinates(245, 905);//Click on any podCast Episode
        isShowing &= commonFunctions.isElementDisplayed(podcastEpisodePage, 10, "podCast Episodes Page");
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
        commonFunctions.clickByCoordinates(59, 275);//Click on Podcast Play Button
        isShowing &= commonFunctions.isElementDisplayed(playExpandButton,10,"play Expand Button");
        return isShowing;
    }

    @Override
    public boolean checkPodCastEpisodePageDescriptionSeeAllIcon() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 2, "podCast stories list");
        commonFunctions.clickByCoordinates(285, 335);//Click on any podCast Episode
        commonFunctions.clickByCoordinates(329, 615);//Click on read more option
        isShowing &= commonFunctions.isElementDisplayed(popupAfterReadMore, 10, "Popup After Click On ReadMoreRead More");
        return isShowing;
    }

    @Override
    public boolean checkPodCastFreeEpisodeBeforeLogIn() {
        boolean isShowing = commonFunctions.clickElement(loginProfileButton, 15, "Tap On Login Profile Button");
        isShowing &= commonFunctions.isElementDisplayed(loginorRegisterPage, 15, "Verify that the All users Non Looged in");
        commonFunctions.clickElement(podCastPageBackButton,5,"Back");
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 10, "podCast stories list");
        commonFunctions.clickByCoordinates(285, 335);//Click on any podCast Episode
        isShowing &= commonFunctions.isElementDisplayed(podcastEpisodePage, 10, "podCast Tittle Page");
        return isShowing;
    }

    @Override
    public boolean checkPodCastFreeEpisodeNonSubscribedUser() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfStoriesOnPodCastPage, 2, "podCast stories list");
        commonFunctions.clickByCoordinates(285, 335);//Click on any podCast Episode
        isShowing &= commonFunctions.isElementDisplayed(podcastEpisodePage, 10, "podCast Tittle Page");
        return isShowing;
    }

    @Override
    public boolean checkPodCastSectionByExplore() {
        boolean isShowing;
        commonFunctions.clickElement(home, 10, "home tab");
        commonFunctions.clickElement(exploreHamburger, 10, "explore hamburger");
        isShowing = commonFunctions.checkElementVisibilityByScrolling(ExplorePodcastOption, "Podcast option");
        commonFunctions.clickElement(ExplorePodcastOption, 10, "mint lounge");
        isShowing &= commonFunctions.isElementDisplayed(podCastPage, 10, "podCast Page title");
        commonFunctions.clickElement(backButton, 10, "back button mintLounge listing page");
        isShowing &= commonFunctions.isElementDisplayed(explorePage, 10, "explore page");
        commonFunctions.killAppAndReLaunch();
        return isShowing;
    }

    @Override
    public boolean checkAccessPodcastListingPageFromHomepage() {
        return checkPodCastPage();
    }

    @Override
    public boolean checkPodcastSeriesListing() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(firstStoryOnPodCastPage, 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(podcastEpisodePage, 10, "Episode page");
        String[] Ele1 = totalEpisode.getText().split(" ", 2);
        String totalEpisode = Ele1[Ele1.length - 2].trim();
        int totalEpisodeNo = Integer.parseInt(totalEpisode);
        if (isShowing &= allEpisodeListing.size() == totalEpisodeNo) {
            isShowing = true;
            Utils.logStepInfo(true, "total Episode display Successfully !!!!!");
            isShowing &= true;
        } else {
            Utils.logStepInfo(true, "total Episode Not display Verification Failed !!!!!");
            isShowing &= false;
        }
        return isShowing;
    }

    @Override
    public boolean checkPlayingAnEpisodeOnEpisodeDetailPage() {
        return false;
    }

    private boolean readMorePage() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(readMorePage.get(0), 10, "headline");
        isShowing &= commonFunctions.isElementDisplayed(readMorePage.get(1), 10, "description");
        commonFunctions.clickElement(closeBtnPopup, 10, "close btn");
        return isShowing;
    }

    @Override
    public boolean checkPodcastDetailSeeMoreMainPlaylistAndEpisodesPlaylist() {
        boolean isShowing;
        isShowing = checkPodCastPage();
        commonFunctions.clickElement(firstStoryOnPodCastPage, 10, "first story on podCast Page");
        isShowing &= commonFunctions.isElementDisplayed(podcastEpisodePage, 10, "Episode page");
        commonFunctions.clickByCoordinates(309, 565, "read more");//read more clickElement is not working
        isShowing &= readMorePage();
        commonFunctions.clickByCoordinates(298, 692, "list of episode read more");
        isShowing &= readMorePage();
        return isShowing;
    }

    @Override
    public boolean checkPlayButtonChangesListenNow() {
        boolean isShowing = checkPodCastCarousel();
        isShowing &= commonFunctions.isElementDisplayedOfListOfElements(listenNow, "listen now");
        return isShowing;
    }

    @Override
    public boolean checkEpisodeInTwoByTowGrid() {
        boolean isShowing = checkPodCastCarousel();
        if (listenNow.size()==4) {
            isShowing &= true;
            Utils.logStepInfo(true, "4 podcast episode display successfully !!!!!");
        } else {
            isShowing = false;
            Utils.logStepInfo(false, "4 podcast episode Not display failed ********");
        }
        return isShowing;
    }

    @Override
    public boolean checkPodcastPageByViewAll() {
        return false;
    }

    @Override
    public boolean checkPodcastEpisodeListingPageByTitleNotDisplayed() {
        return false;
    }

    @Override
    public boolean checkPodcastEpisodeListingPageByThumbnailDisplayed() {
        return false;
    }

    @Override
    public boolean checkThroughTitleEpisodeNotPlayed() {
        return false;
    }

    @Override
    public boolean checkPodcastEpisodePlayButtonNotDisplay() {
        return false;
    }

    @Override
    public boolean checkSeeMoreMainAndEpisodePlaylistOnPodcastEpisodePage() {
        return false;
    }
}
