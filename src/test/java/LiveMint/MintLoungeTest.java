package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonMintLoungePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


class MintLoungeTest extends BaseTest {
    private static CommonMintLoungePage mintLoungePage;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        mintLoungePage = CommonMintLoungePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3179,3180(android_native): verify mintLounge logo - Carousel")
    @Test
    public void verifyMintLoungeCarousel() {
        boolean isTrue = mintLoungePage.checkMintLoungeCarousel();
        Assert.assertTrue(isTrue, "mint lounge - Carousel verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3181(android_native),QAAUT-3201 (ios_native): verify mintLounge Story Card design")
    @Test
    public void verifyMintLoungeStoryCardDesign() {
        boolean isTrue = mintLoungePage.checkMintLoungeStoryCardDesign();
        Assert.assertTrue(isTrue, "mint lounge Story Card design verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3183(android_native): verify mintLounge Story Card sizes")
    @Test
    public void verifyAllMintLoungeStoryCardSizeSame() {
        boolean isTrue = mintLoungePage.checkAllMintLoungeStoryCardSizeSame();
        Assert.assertTrue(isTrue, "mint lounge Story Card sizes verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3184,3185,3187,3188(android_native),QAAUT-3204,3205,3212,3188(ios_native): verify mintLounge viewAll and viewAll functionality")
    @Test
    public void verifyMintLoungeViewAllFunctionality() {
        boolean isTrue = mintLoungePage.checkMintLoungeVewAllFunctionality();
        Assert.assertTrue(isTrue, "mint lounge ViewAll functionality verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3189,3190(android_native),QAAUT-3206,3214(ios_native): verify mintLounge page Entry point & Back button")
    @Test
    public void verifyMintLoungePageEntryPointAndBackButton() {
        boolean isTrue;
        isTrue = mintLoungePage.checkMintLoungePageAndBackButtonByHomePage();
        Assert.assertTrue(isTrue, "mint lounge page by home page verification failed !!!!!!!");

        isTrue = mintLoungePage.checkMintLoungePageAndBackButtonByExploreHamburger();
        Assert.assertTrue(isTrue, "mint lounge page by explore hamburger verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3182(android_native),QAAUT-3202(ios_native): verify mintLounge card slider")
    @Test
    public void verifyMintLoungeCarouselSlider() {
        boolean isTrue;
        isTrue = mintLoungePage.checkMintLoungeCarouselSlider();
        Assert.assertTrue(isTrue, "mint lounge card slider verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3186(android_native),QAAUT-3211(ios_native): verify mintLounge bookmark")
    @Test
    public void verifyBookmarkIcon() {
        boolean isTrue;
        isTrue = mintLoungePage.checkBookmarkIcon();
        Assert.assertTrue(isTrue, "mint lounge bookmark verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3191(android_native),QAAUT-3207 (ios_native): verify mintLounge listing page")
    @Test
    public void verifyMintLoungeListingPage() {
        boolean isTrue;
        isTrue = mintLoungePage.checkMintLoungeListingPage();
        Assert.assertTrue(isTrue, "mint lounge listing page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3192(android_native),QAAUT-3208(ios_native): verify mintLounge listing page no bookmark icon")
    @Test
    public void verifyNoBookmarkIconOnMintLoungeListingPage() {
        boolean isTrue;
        isTrue = mintLoungePage.checkNoBookmarkIconOnMintLoungeListingPage();
        Assert.assertTrue(isTrue, "mint lounge listing page no bookmark icon verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3193(android_native),QAAUT-3209(ios_native): verify mintLounge listing page share icon all available option")
    @Test
    public void verifyShareIconAllAvailableOptionOnMintLoungeListingPage() {
        boolean isTrue;
        isTrue = mintLoungePage.checkShareIconAllAvailableOptionOnMintLoungeListingPage();
        Assert.assertTrue(isTrue, "mint lounge listing page share icon all available option verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3194(android_native),QAAUT-3210(ios_native): verify ad on listing page")
    @Test
    public void verifyAdsOnMintLoungeListingPage() {
        boolean isTrue;
        isTrue = mintLoungePage.checkAdsOnListingPage();
        Assert.assertTrue(isTrue, "ads on listing page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3195,3196(android_native),QAAUT-3216,3215 (ios_native): verify story detail page")
    @Test
    public void verifyStoryDetailPage() {
        boolean isTrue;
        isTrue = mintLoungePage.checkStoryDetailPage();
        Assert.assertTrue(isTrue, "verify story detail page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3197(android_native),QAAUT-3217 (ios_native): verify story detail page share icon all option")
    @Test
    public void verifyStoryDetailPageShareIconAllOption() {
        boolean isTrue;
        isTrue = mintLoungePage.checkStoryDetailPageShareFunctionality();
        Assert.assertTrue(isTrue, "verify story detail page share icon all option verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3198(android_native),QAAUT-3218(ios_native): verify story detail page Font size")
    @Test
    public void verifyStoryDetailPageFontSize() {
        boolean isTrue;
        isTrue = mintLoungePage.checkStoryDetailPageFontSize();
        Assert.assertTrue(isTrue, "verify story detail page Font size verification failed !!!!!!!");
    }


}