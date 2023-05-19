
package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonDailyDigestPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


class DailyDigestPageTest extends BaseTest {
    private static CommonDailyDigestPage dailyDigestPage;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        dailyDigestPage = CommonDailyDigestPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5777: Verify Daily Digest option and pages")
    @Test
    public void verifyExploreDailyDigestPage() {
        boolean  isTrue = dailyDigestPage.checkYourDailyDigestPage();
        Assert.assertTrue(isTrue, "Daily Digest page verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5780,5781: Verify Daily Digest banner Morning")
    @Test
    public void verifyDailyDigestBannerMorningAndDailyDigestPage() {
        boolean  isTrue = dailyDigestPage.checkDailyDigestBannerMorningAndDailyDigestPage();
        Assert.assertTrue(isTrue, "Daily Digest banner verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5782,5783,5784: Verify Daily Digest evening and Daily digest pages")
    @Test
    public void verifyDailyDigestBannerEveningAndDailyDigestPage() {
        boolean  isTrue = dailyDigestPage.checkDailyDigestBannerEveningAndDailyDigestPage();
        Assert.assertTrue(isTrue, "Daily Digest page verification failed !!!!!!");
    }

}
