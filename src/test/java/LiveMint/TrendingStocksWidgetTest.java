
package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonMarketPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public  class TrendingStocksWidgetTest extends BaseTest {
    private static CommonMarketPage marketPage;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        marketPage = CommonMarketPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5892: Verify Home - Trending stocks widget")
    @Test
    public void verifyHomeTrendingStocksWidget() {
        boolean  isTrue = marketPage.checkHomeTrendingStocksWidget();
        Assert.assertTrue(isTrue, "Home - Trending stocks widget verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5893: Verify Home - Trending stocks- top 3 Gainer")
    @Test
    public void verifyHomeTrendingStocksWidgetTop3Gainer() {
        boolean  isTrue = marketPage.checkTrendingStocksWidgetTop3Gainer();
        Assert.assertTrue(isTrue, "top 3 gainer verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5897: Verify that when user clicks on Loser stock, it should go to that loser stock detail page")
    @Test
    public void verifyTrendingLoserStockDetailPage() {
        boolean  isTrue = marketPage.checkTrendingLoserStockDetailPage();
        Assert.assertTrue(isTrue, "top 3 loser & detail page verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5893: Verify Home - Trending stocks- top 3 Loser")
    @Test
    public void verifyHomeTrendingStocksWidgetTop3Loser() {
        boolean  isTrue = marketPage.checkTrendingStocksWidgetTop3Loser();
        Assert.assertTrue(isTrue, "top 3 Loser verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5896: Verify that when user clicks on Gainer stock, it should go to that loser stock detail page")
    @Test
    public void verifyTrendingGainerStockDetailPage() {
        boolean  isTrue = marketPage.checkTrendingGainerStockDetailPage();
        Assert.assertTrue(isTrue, "top 3 Gainer & detail page verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5898: Verify that when user clicks on Market Dashboard button, it should land them to Market Dashboard")
    @Test
    public void verifyTrendingStocksMarketDashboard() {
        boolean  isTrue = marketPage.checkTrendingStocksMarketDashboard();
        Assert.assertTrue(isTrue, "marketDashboard detail page verification failed !!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5895: Verify that when user clicks on Market Dashboard button, it should land them to Market Dashboard")
    @Test
    public void verifyTrendingStockLeftAndRightSwipeFunctionality() {
        boolean  isTrue = marketPage.checkTrendingStockLeftAndRightSwipeFunctionality();
        Assert.assertTrue(isTrue, "swipe functionality verification failed !!!!!!");
    }


}
