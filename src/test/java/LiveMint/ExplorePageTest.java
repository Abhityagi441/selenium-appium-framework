
package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonExplorePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


class ExplorePageTest extends BaseTest {
    private static CommonExplorePage explorePage;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        explorePage = CommonExplorePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4368,4369(android_native),QAAUT-4433,4434(ios_native): Verify market dashboard option and pages")
    @Test
    public void verifyExploreMarketDashboardPage() {
        boolean  isTrue = explorePage.checkMarketDashboardPage();
        Assert.assertTrue(isTrue, "market dashboard verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4370,4371(android_native),QAAUT-4435,4436(ios_native): Verify mint premium and pages")
    @Test
    public void verifyExploreMintPremiumPage() {
        boolean  isTrue = explorePage.checkMintPremiumPage();
        Assert.assertTrue(isTrue, "mint premium verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4372,4373(android_native),QAAUT-4437,4438(ios_native): Verify podcast and pages")
    @Test
    public void verifyExplorePodcastPage() {
        boolean  isTrue = explorePage.checkPodcastPage();
        Assert.assertTrue(isTrue, "podcast  verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4380,4381(android_native),QAAUT-4445,4446(ios_native): Verify share app all option")
    @Test
    public void verifyShareAppOption() {
        boolean  isTrue = explorePage.checkShareAppOption();
        Assert.assertTrue(isTrue, "share app all option  verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4374,4375(android_native),QAAUT-4439(ios_native): Verify Rate app")
    @Test
    public void verifyRateApp() {
        boolean  isTrue = explorePage.checkRateApp();
        Assert.assertTrue(isTrue, "Rate app  verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4376(android_native): Verify rate app Later button")
    @Test
    public void verifyRateAppLaterButton() {
        boolean  isTrue = explorePage.checkRateAppLaterButton();
        Assert.assertTrue(isTrue, "rate app later button verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4377(android_native): Verify rate app Submit button")
    @Test
    public void verifyRateAppSubmitButton() {
        boolean  isTrue = explorePage.checkRateAppSubmitButton();
        Assert.assertTrue(isTrue, "rate app submit button verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4378(android_native): Verify rate app with 5 start")
    @Test
    public void verifyRateAppWithFiveStarRating() {
        boolean  isTrue = explorePage.checkRateAppWithFiveStarRating();
        Assert.assertTrue(isTrue, "rate app 5 star verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4379(android_native): Verify rate app with below 5 star")
    @Test
    public void verifyRateAppWithBelowFiveStarRating() {
        boolean  isTrue = explorePage.checkRateAppWithBelowFiveStarRating();
        Assert.assertTrue(isTrue, "rate app below 5 star verification failed !!!!!!");
    }


}
