package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonNewsPage;
import com.pages.LiveMint.genericPages.CommonPodCastPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

class PodCastTest extends BaseTest {
    private static CommonPodCastPage podCastPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        podCastPage = CommonPodCastPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2968(android_native),QAAUT-3000(ios_native): verify Pod Cast Design - Carousel")
    @Test
    public void verifyPodCastCarousel() {
        boolean isTrue = podCastPage.checkPodCastCarousel();
        Assert.assertTrue(isTrue, "Pod Cast Design - Carousel verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2970(android_native),QAAUT-3002(ios_native): verify podCast position ")
    @Test
    public void verifyPodCastCarouselViewAll() {
        boolean isTrue = podCastPage.checkPodCastCarouselViewAll();
        Assert.assertTrue(isTrue, "podCast position verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2972(android_native),QAAUT-3004(ios_native): verify release date podCast ")
    @Test
    public void verifyPodCastReleaseDate() {
        boolean isTrue = podCastPage.checkPodCastReleaseDate();
        Assert.assertTrue(isTrue, "podCast release date verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2979,2981,2980(android_native),QAAUT-3009,3011,3010(ios_native): verify vieAll functionality and entry point ")
    @Test
    public void verifyPodCastViewAllFunctionality() {
        boolean isTrue = podCastPage.checkPodCastViewAllFunctionality();
        Assert.assertTrue(isTrue, "view all verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2982(android_native),QAAUT-3012(ios_native): verify Pod Cast page Back button ")
    @Test
    public void verifyPodCastPageBackBtnFunctionality() {
        boolean isTrue = podCastPage.checkPodCastPageBackBtnFunctionality();
        Assert.assertTrue(isTrue, "Pod Cast page Back button verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2987(android_native),QAAUT-3017(ios_native): verify play button on episode page")
    @Test
    public void verifyPodCastEpisodePagePlayButton() {
        boolean isTrue = podCastPage.checkPodCastEpisodePagePlayButton();
        Assert.assertTrue(isTrue, "play button on episode page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2997(android_native),QAAUT-3025(ios_native): verify buttom msg")
    @Test
    public void verifyPodCastPageButtonMsg() {
        boolean isTrue = podCastPage.checkPodCastBottonMsg();
        Assert.assertTrue(isTrue, "buttom msg verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2975(android_native),QAAUT-3007(ios_native): verify PodCast View All button")
    @Test
    public void verifyPodCastViewAllButton() {
        boolean isTrue = podCastPage.checkPodCastViewAll();
        Assert.assertTrue(isTrue, "PodCast View All button verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2988(android_native),QAAUT-3018(ios_native): verify PodCast episode page story name")
    @Test
    public void verifyPodCastEpisodePageStoryName() {
        boolean isTrue = podCastPage.checkPodCastEpisodePageStoryName();
        Assert.assertTrue(isTrue, "PodCast episode page story name verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3031(ios_native),QAAUT-2983(android_native): verify PodCast page MastHead Ad")
    @Test
    public void verifyPodCastPageMastHeadAd() {
        boolean isTrue = podCastPage.checkPodCastPageMastHeadAd();
        Assert.assertTrue(isTrue, "PodCast page MastHead Ad verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2966,2967(android_native),QAAUT-2998(ios_native):: verify PodCast carousel for subscribed and non subscribed user")
    @Test
    public void verifyPodCastCarouselForSubscribedAndNonSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = podCastPage.checkPodCastCarousel();
        Assert.assertTrue(isStepTrue, "PodCast carousel verification failed !!!!!!!");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");

        if (globalVars.isIosRun()) {
            isStepTrue = podCastPage.relaunchApp();
            Assert.assertTrue(isStepTrue, "app re-launch verification failed !!!!!!!");
        }

        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(params.get("email"), params.get("apiURI"), params.get("accessAccount"), params.get("Cookie"), params.get("refreshAPI"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = podCastPage.checkPodCastCarousel();
        Assert.assertTrue(isStepTrue, "PodCast carousel verification failed !!!!!!!");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2974(android_native),QAAUT-3006(ios_native): verify PodCast card Swipe")
    @Test
    public void verifyPodCastCardSwipe() {
        boolean isTrue = podCastPage.checkPodCastCardSwipe();
        Assert.assertTrue(isTrue, "PodCast cars Swipe verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3015(ios_native),QAAUT-2985(android_native): verify PodCast episode page square box")
    @Test
    public void verifyPodCastCardEpisodePageSquareBox() {
        boolean isTrue = podCastPage.checkPodCastCardEpisodePageSquareBox();
        Assert.assertTrue(isTrue, "square box verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3014(ios_native),QAAUT-2984(android_native): verify PodCast Episode listing story")
    @Test
    public void verifyPodCastCardEpisodeListing() {
        boolean isTrue = podCastPage.checkPodCastCardEpisodeListing();
        Assert.assertTrue(isTrue, "episode page listing story verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3003(ios_native),QAAUT-2971(android_native): verify PodCast card play button")
    @Test
    public void verifyPodCastCardPlayButton() {
        boolean isTrue = podCastPage.checkPodCastCardPlayButton();
        Assert.assertTrue(isTrue, "PodCast card play button verification failed !!!!!!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-2991(android_native) : Verify that the All users Non Logged are able to play Free eposides")
    @Test
    public void verifyPodCastFreeEpisodeNonLogged() {
        boolean isTrue = podCastPage.checkPodCastFreeEpisodePage();
        Assert.assertTrue(isTrue, "View any one Free eposides verification failed !!!!!!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-3538(android_native), QAAUT-3539(Android_native),QAAUT-3792(ios_native) : Verify that the All users Looged in/Non Subscribed are able to play Free eposides")
    @Test
    public void verifyPodCastFreeEpisodeLoggedInNonSubscribeb() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");
        boolean isTrue = podCastPage.checkPodCastFreeEpisodePage();
        Assert.assertTrue(isTrue, "View any one Free eposides verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-3005(ios_native),QAAUT-2973(Android_native): verify PodCast card Episode Name and Number")
    @Test
    public void verifyPodCastCardEpisodeNameandNumber() {
        boolean isTrue = podCastPage.checkPodCastCardEpisodeNameandNumber();
        Assert.assertTrue(isTrue, "PodCast card Episode Name and Number verification failed !!!!!!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-3008(ios_native),QAAUT-2978(Android_native): Verify that the selected episode story is getting played by tapping on the Play button and this Play button is replaced with Stop/Pause button")
    @Test
    public void verifyPodCastPlayButton() {
        boolean isTrue = podCastPage.checkPodcastPlayButton();
        Assert.assertTrue(isTrue, "PodCast Play Button verification failed !!!!!!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-3016(ios_native),QAAUT-2986(Android_native): verify PodCast Episode Page Square Card Contains")
    @Test
    public void verifyPodCastEpisodePageDescriptionSeeAllIcon() {
        boolean isTrue = podCastPage.checkPodCastEpisodePageDescriptionSeeAllIcon();
        Assert.assertTrue(isTrue, "PodCast Episode Page Square Card Contains verification failed !!!!!!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-3021(ios_native): verify Pod Cast Free Episode- Before Log in")
    @Test
    public void verifyPodCastFreeEpisodeBeforeLogIn() {
        boolean isTrue = podCastPage.checkPodCastFreeEpisodeBeforeLogIn();
        Assert.assertTrue(isTrue, "Pod Cast Free Episode- Before Log in verification failed !!!!!!!");

    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-3791(ios_native): Verify that the All users (Login but Non Subscribed User) are able to play Free episodes")
    @Test
    public void verifyPodCastFreeEpisodeNonSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyPodCastFreeEpisodeNonSubscribedUser");
        isStepTrue = loginPage.loginWithNonSubscribedUser(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login Failed!!");
        boolean isTrue = podCastPage.checkPodCastFreeEpisodeNonSubscribedUser();
        Assert.assertTrue(isTrue, "Pod Cast Non Subscribed User verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");

    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4334(android_native),QAAUT-4344(ios_native): verify Pod Cast section by explore")
    @Test
    public void verifyPodCastSection() {
        boolean isTrue = podCastPage.checkPodCastSectionByExplore();
        Assert.assertTrue(isTrue, "Pod Cast Design - Carousel verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4335(android_native)QAAUT-4345(ios_native): verify Access Podcast Listing page from Homepage")
    @Test
    public void verifyAccessPodcastListingPageFromHomepage() {
        boolean isTrue = podCastPage.checkAccessPodcastListingPageFromHomepage();
        Assert.assertTrue(isTrue, "Access Podcast Listing page from Homepage verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4339(android_native)QAAUT-4346(ios_native): verify Podcast series listing")
    @Test
    public void verifyPodcastSeriesListing() {
        boolean isTrue = podCastPage.checkPodcastSeriesListing();
        Assert.assertTrue(isTrue, "Podcast series listing verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4342,4343(android_native),QAAUT-4349,4348(ios_native): verify Podcast detail - See more (Main & Episodes playlist)")
    @Test
    public void verifyPodcastDetailSeeMoreMainPlaylistAndEpisodesPlaylist() {
        boolean isTrue = podCastPage.checkPodcastDetailSeeMoreMainPlaylistAndEpisodesPlaylist();
        Assert.assertTrue(isTrue, "Podcast series listing verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4410,4411(android_native),QAAUT-4429(ios_native): verify Play button change with Listen Now")
    @Test
    public void verifyPlayButtonChangesListenNow() {
        boolean isTrue = podCastPage.checkPlayButtonChangesListenNow();
        Assert.assertTrue(isTrue, "Play button change listen now verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4409(android_native),QAAUT-4427(ios_native): verify podcast Episode In Two By Tow Grid")
    @Test
    public void verifyEpisodeInTwoByTowGrid() {
        boolean isTrue = podCastPage.checkEpisodeInTwoByTowGrid();
        Assert.assertTrue(isTrue, "podcast Episode In Two By Tow Grid verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5786(android_native): verify explore podcast Episode Page")
    @Test
    public void verifyExplorePodcastSection() {
        boolean isTrue = podCastPage.checkPodCastSectionByExplore();
        Assert.assertTrue(isTrue, "podcast verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5787(android_native): verify podcast page by tapping on view All")
    @Test
    public void verifyPodcastPageByViewAll() {
        boolean isTrue = podCastPage.checkPodcastPageByViewAll();
        Assert.assertTrue(isTrue, "podcast page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5788,5789(android_native): verify podcast episode page not displayed bu title & displayed by thumbnail")
    @Test
    public void verifyPodcastEpisodeListingPageNotDisplayedByTitleDisplayedByThumbnail() {
        boolean isTrue = podCastPage.checkPodcastEpisodeListingPageByTitleNotDisplayed();
        Assert.assertTrue(isTrue, "podcast episode page displayed verification failed !!!!!!!");

        isTrue = podCastPage.checkPodcastEpisodeListingPageByThumbnailDisplayed();
        Assert.assertTrue(isTrue, "podcast episode page Not displayed verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5790(android_native): through podcast episode title episode not played")
    @Test
    public void verifyThroughTitleEpisodeNotPlay() {
      boolean  isTrue = podCastPage.checkThroughTitleEpisodeNotPlayed();
        Assert.assertTrue(isTrue, "podcast episode not played verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5791(android_native): podcast episode play button not displayed")
    @Test
    public void verifyPodcastEpisodePlayButtonNotDisplay() {
        boolean  isTrue = podCastPage.checkPodcastEpisodePlayButtonNotDisplay();
        Assert.assertTrue(isTrue, "podcast episode play button displayed verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5800,5766(android_native): podcast see more main and episode playlist")
    @Test
    public void verifySeeMoreMainAndEpisodePlaylistOnPodcastEpisodePage() {
        boolean  isTrue = podCastPage.checkSeeMoreMainAndEpisodePlaylistOnPodcastEpisodePage();
        Assert.assertTrue(isTrue, "podcast see more main and episode playlist not displayed verification failed !!!!!!!");
    }


}