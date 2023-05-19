package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonMarketPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class MarketPageTest extends BaseTest {
    private static CommonMarketPage marketPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        marketPage = CommonMarketPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2425 (web), QAAUT-2554 (android_web), (QAAUT-2555, 2472-iOS-web):Validate market indian indices page")
    @Test
    public void verifyIndianIndicesPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesPage");
        isStepTrue = marketPage.checkIndianIndicesPage(params.get("url"));
        Assert.assertTrue(isStepTrue, "Indian Indices page verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2424 (web):Validate market dashboard page, QAAUT-2428 (WEB): Validate market company page")
    @Test
    public void verifyMarketDashboardPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketDashboardPage");
        isStepTrue = marketPage.checkMarketDashboardPage(params.get("Url"));
        Assert.assertTrue(isStepTrue, "Market company page verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2480 (web):Validate market S&P BSE MIDCAP Landing page")
    @Test
    public void verifyMarketSnPBseMidcapLandingPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketSnPBseMidcapLandingPage");
        isStepTrue = marketPage.checkMarketSnPBseMidcapLandingPage();
        Assert.assertTrue(isStepTrue, "S&P BSE MIDCAP Landing page verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2514 (web):Validate market nifty 50 Landing page")
    @Test
    public void verifyMarketNifty50LandingPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketNifty50LandingPage");
        isStepTrue = marketPage.checkMarketNifty50LandingPage(params.get("Url"), params.get("Header"));
        Assert.assertTrue(isStepTrue, "Nifty 50 Landing page verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2631 (web), QAAUT-2647 (android-mweb):Validate graph on nifty 50 Landing page")
    @Test
    public void verifyNifty50Graph() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNifty50Graph");
        String[] paramArray = new String[1];
        paramArray[0] = paramsMap.get("HighlitedColor");
        isStepTrue = marketPage.checkMarketNifty50Graph(paramArray);
        Assert.assertTrue(isStepTrue, "Nifty 50 Graph verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2588 (web):Validate Graph details on S&P BSE SENSEX landing page")
    @Test
    public void verifySnPBseSensexGraph() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySnPBseSensexGraph");
        String[] paramArray = new String[1];
        paramArray[0] = paramsMap.get("HighlitedColor");
        isStepTrue = marketPage.checkSnPBseSensexGraph(paramArray);
        Assert.assertTrue(isStepTrue, "S&P BSE SENSEX Graph verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2623 (web):Validate Graph details on S&P BSE Midcap landing page")
    @Test
    public void verifySnPBseMidcapGraph() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySnPBseMidcapGraph");
        String[] paramArray = new String[1];
        paramArray[0] = paramsMap.get("HighlitedColor");
        isStepTrue = marketPage.checkSnPBseMidcapGraph(paramArray);
        Assert.assertTrue(isStepTrue, "S&P BSE Midcap Graph verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2546 (web):Verify the graph on the NIFTY BANK landing page")
    @Test
    public void verifyNiftyBankGraph() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNiftyBankGraph");
        String[] paramArray = new String[1];
        paramArray[0] = paramsMap.get("HighlitedColor");
        isStepTrue = marketPage.checkNiftyBankGraph(paramArray);
        Assert.assertTrue(isStepTrue, "NIFTY BANK Graph verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2569 (web):Validate MOST ACTIVE BY VOLUME View All page")
    @Test
    public void verifyMostActiveByVolViewAll() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMostActiveVolViewAll();
        Assert.assertTrue(isStepTrue, "MOST ACTIVE BY VOLUME View All verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2537 (web):Validate TOP LOSERS View All page")
    @Test
    public void verifyTopLoserViewAll() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopLoserViewAll");
        String[] paramArray = new String[1];
        paramArray[0] = paramsMap.get("Link");
        isStepTrue = marketPage.checkTopLosersViewAll(paramArray);
        Assert.assertTrue(isStepTrue, "TOP LOSERS View All Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2530 (web):Validate TOP GAINER View All page")
    @Test
    public void verifyTopGainerViewAll() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopGainerViewAll");
        String[] paramArray = new String[1];
        paramArray[0] = paramsMap.get("Link");
        isStepTrue = marketPage.checkTopGainersViewAll(paramArray);
        Assert.assertTrue(isStepTrue, "TOP GAINER View All Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2513 (web), QAAUT-2516 (android-mweb)::Validate MF details page")
    @Test
    public void verifyMFDetailPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyMFDetailPage");
        String[] paramArray = new String[1];
        paramArray[0] = paramsMap.get("Link");
        isStepTrue = marketPage.checkMFDetailPage(paramArray);
        Assert.assertTrue(isStepTrue, "TOP GAINER View All Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2529 (web), QAAUT-2560 (android-mweb), QAAUT-2561 (iOS-mweb):Verify the graph on the Indices landing page")
    @Test
    public void verifyIndianIndicesGraph() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesGraph");
        isStepTrue = marketPage.checkIndianIndicesGraph(params.get("Link"), params.get("Color"));
        Assert.assertTrue(isStepTrue, "Indices Graph verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2628 (web), QAAUT-2676 (android-mweb), QAAUT-2677(iOS-Web) :Validate Stocks table on market S&P BSE MIDCAP Landing page")
    @Test
    public void verifySnPMidcapStockTable() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySnPMidcapStockTable");
        isStepTrue = marketPage.checkSnPBseMidcapStockTable(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Stocks table on market S&P BSE MIDCAP Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2531 (android_native):Validate TOP GAINER View All page")
    @Test
    public void verifyTopGainersViewAllFunction() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTopGainersViewAll();
        Assert.assertTrue(isStepTrue, "TOP GAINER View All Page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2543 (android_native):Validate TOP LOSERS View All page")
    @Test
    public void verifyTopLosersViewAllFunction() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTopLosersViewAll();
        Assert.assertTrue(isStepTrue, "TOP LOSERS View All Page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2570 (android_native):Validate Most Active By Volume View All page")
    @Test
    public void verifyMostActByVolumeViewAllFunction() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMostActByVolViewAll();
        Assert.assertTrue(isStepTrue, "Most Active By Volume View All Page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2449 (web):Validate MOST ACTIVE BY VOLUME On Market Dashboard page")
    @Test
    public void verifyMostActiveByVolumeOnMarket() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMostActiveByVolumeOnMarket");
        isStepTrue = marketPage.checkMostActiveByVolumeMarketDashbaord(params.get("Link"), params.get("Color"), params.get("URI"), params.get("Companies"));
        Assert.assertTrue(isStepTrue, "MOST ACTIVE BY VOLUME On Market Dashboard Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2440 (web):Validate TOP GAINER widget on Market dashboard")
    @Test
    public void verifyTopGainersWidgetOnMarket() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopGainersWidgetOnMarket");
        isStepTrue = marketPage.checkTopGainerMarketDashbaord(params.get("Link"), params.get("Color"), params.get("URI"), params.get("Gainers"));
        Assert.assertTrue(isStepTrue, "TOP GAINER widget On Market Dashboard Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2534 (web):Validate TOP Losers widget on Market dashboard")
    @Test
    public void verifyTopLosersWidgetOnMarket() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopLosersWidgetOnMarket");
        isStepTrue = marketPage.checkTopLoserMarketDashbaord(params.get("Link"), params.get("Color"), params.get("URI"), params.get("Losers"));
        Assert.assertTrue(isStepTrue, "TOP Losers widget On Market Dashboard Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2548 (web), QAAUT-2604 (android-mweb), QAAUT-2605 (iOS-mweb) :Verify Stocks table on NIFTY BANK landing page")
    @Test
    public void verifyStockTableNiftyBank() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStockTableNiftyBank");
        isStepTrue = marketPage.checkStockTableNiftyBank(params.get("Link"),params.get("Header"),params.get("URI"),params.get("ID"),params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Nifty Bank Stock Table verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2590 (web), QAAUT-3169, QAAUT-2661 (android-mweb):Validate stocks table on S&P BSE SENSEX landing page")
    @Test
    public void verifyStockTableBseSensex() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStockTableBseSensex");
        isStepTrue = marketPage.checkStockTableBseSensex(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "S&P BSE SENSEX Stock Table verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2593 (web), QAAUT-2667 (android-mweb):Validate S&P BSE SENSEX STOCKS View All CTA on S&P BSE SENSEX landing page")
    @Test
    public void verifyStockTableBseSensexViewAll() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStockTableBseSensexViewAll");
        isStepTrue = marketPage.checkStockTableBseSensexViewAll(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"));
        Assert.assertTrue(isStepTrue, "SS&P BSE SENSEX STOCKS View All Table verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2538 (web):Verify indian indices tabel on indices landing page")
    @Test
    public void verifyIndianIndiceTable() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndiceTable");
        isStepTrue = marketPage.checkIndianIndicesTable(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Indian indices tabel Table verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2549 (web), QAAUT-2693 (android-mweb), QAAUT-2694 (iOS-mweb):Validate Indian indices View All page")
    @Test
    public void verifyIndianIndiceViewAll() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndiceViewAll");
        isStepTrue = marketPage.checkIndianIndicesViewAll(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("URL"));
        Assert.assertTrue(isStepTrue, "Indian indices View All verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2552 (web), QAAUT-2610 (android-mweb), QAAUT-2608 (iOS-mweb):Validate NIFTY BANK STOCKS View All CTA on NIFTY BANK landing page")
    @Test
    public void verifyNiftyBankStocksViewAll() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNiftyBankStocksViewAll");
        isStepTrue = marketPage.checkNiftyBankStocksViewAll(params.get("Link"), params.get("Link1"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("URL"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "NIFTY BANK STOCKS View All verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2633 (web), QAAUT-2638 (android-mweb):Verify stock table on market nifty 50 Landing page")
    @Test
    public void verifyStockTableNifty50() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStockTableNifty50");
        isStepTrue = marketPage.checkStockNifty50(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Nifty 50 Stock Table verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2589 (web), QAAUT-2658 (android-mweb), QAAUT-2659 (iOS-mweb):Validate Indian Indices tabel on S&P BSE SENSEX landing page")
    @Test
    public void verifyIndianIndicesOnBseSensex() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnBseSensex");
        isStepTrue = marketPage.checkIndianIndicesOnBseSensex(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("URL"));
        Assert.assertTrue(isStepTrue, "Indian Indices tabel on S&P BSE SENSEX verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2547 (web), QAAUT-2601 (android-mweb), QAAUT-2602 (iOS-mweb):Verify Indian indices table on NIFTY BANK landing page")
    @Test
    public void verifyIndianIndicesOnNiftyBank() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnNiftyBank");
        isStepTrue = marketPage.checkIndianIndicesOnNiftyBank(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Indian Indices tabel on NIFTY BANK Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2627 (web), QAAUT-2673 (android-mweb), QAAUT-2674 (iOS-web):Validate Indian Indices table on market S&P BSE MIDCAP Landing page")
    @Test
    public void verifyIndianIndicesOnBseMidcap() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnBseMidcap");
        isStepTrue = marketPage.checkIndianIndicesOnBseMidcap(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Indian Indices tabel on S&P BSE MIDCAP Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2632 (web), QAAUT-2644 (android-mweb):Validate Indian indices table on market nifty 50 Landing page")
    @Test
    public void verifyIndianIndicesOnNifty50() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnNifty50");
        isStepTrue = marketPage.checkIndianIndicesOnNifty50(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Indian Indices tabel on Nifty 50 Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2619 (web), QAAUT-2620 (android-mweb), QAAUT-2621 (iOS-web):Validate Indian indices View All CTA on S&P BSE MIDCAP landing page")
    @Test
    public void verifyIndianIndicesViewAllBseMidcap() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesViewAllBseMidcap");
        isStepTrue = marketPage.checkIndianIndicesViewAllBseMidcap(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Indian Indices View All on Bse Midcap Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2551 (web), QAAUT-2607 (android-mweb), QAAUT-2608 (iOS-mweb):Validate Indian indices View All CTA on NIFTY BANK landing page")
    @Test
    public void verifyIndianIndicesViewAllNiftyBank() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesViewAllNiftyBank");
        isStepTrue = marketPage.checkIndianIndicesViewAllNiftyBank(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"));
        Assert.assertTrue(isStepTrue, "Indian Indices View All on NiftyBank Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2592 (web), QAAUT-2664 (android-mweb), QAAUT-2665 (iOS-mweb), QAAUT-2666 (android-amp), QAAUT-3386 (iOS-amp):Validate Indian indices View All CTA on S&P BSE SENSEX landing page")
    @Test
    public void verifyIndianIndicesViewAllBseSensex() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesViewAllBseSensex");
        isStepTrue = marketPage.checkIndianIndicesViewAllOnBseSensex(params.get("Link"), params.get("Amp"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"), params.get("ampURL"),params.get("webURL"), params.get("URL3"));
        Assert.assertTrue(isStepTrue, "Indian Indices View All CTA on S&P BSE SENSEX verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2695 (android-Amp):Validate Indian indices View All page")
    @Test
    public void verifyIndianIndiceAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndiceAmp");
        isStepTrue = marketPage.checkIndianIndicesViewAll(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("URL"));
        Assert.assertTrue(isStepTrue, "Indian indices Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2669 (android-Amp), QAAUT-3613 (iOS-Amp) :Validate S&P BSE SENSEX STOCKS View All CTA on S&P BSE SENSEX landing page")
    @Test
    public void verifyStockTableBseSensexViewAllAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStockTableBseSensexViewAllAmp");
        isStepTrue = marketPage.checkStockTableBseSensexViewAllAmp(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"));
        Assert.assertTrue(isStepTrue, "S&P BSE SENSEX STOCKS View All Table verification failed");
    }
    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2556 (android-Amp):Validate market indian indices page")
    @Test
    public void verifyIndianIndicesPageAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesPageAmp");
        isStepTrue = marketPage.checkIndianIndicesPageAmp(params.get("Link"));
        Assert.assertTrue(isStepTrue, "Market indian indices page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2539 (web), QAAUT-2895 (android_web), QAAUT-2896 (iOS_web):Verify Stocks table on indices landing page")
    @Test
    public void verifyStocksTableOnIndicesPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStocksTableOnIndicesPage");
        isStepTrue = marketPage.checkStocksTableOnIndicePage(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Stocks table on indices page verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2897 (android_AMP), QAAUT-3448, 3788 (amp_iOS):Verify Stocks table on indices landing page")
    @Test
    public void verifyStocksTableOnIndicesPageAMP() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStocksTableOnIndicesPageAMP");
        isStepTrue = marketPage.checkStocksTableOnIndicePageAMP(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Stocks table on indices page verification failed*****");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2660 (android-AMP):Validate Indian Indices tabel on S&P BSE SENSEX landing page")
    @Test
    public void verifyIndianIndicesOnBseSensexAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnBseSensexAmp");
        isStepTrue = marketPage.checkIndianIndicesOnBseSensex(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("URL"));
        Assert.assertTrue(isStepTrue, "Indian Indices tabel on S&P BSE SENSEX verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2646 (AMP-android), QAAUT-3373(AMP-iOS):Validate Indian indices table on market nifty 50 Landing page")
    @Test
    public void verifyIndianIndicesOnNifty50Amp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnNifty50Amp");
        isStepTrue = marketPage.checkIndianIndicesOnNifty50(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Indian Indices tabel on Nifty 50 Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2678 (amp-android), QAAUT-3388 (amp-iOS):Validate Stocks table on market S&P BSE MIDCAP Landing page")
    @Test
    public void verifySnPMidcapStockTableAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySnPMidcapStockTableAmp");
        isStepTrue = marketPage.checkSnPBseMidcapStockTable(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Stocks table on market S&P BSE MIDCAP Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3334(AMP-iOS), QAAUT-3333(AMP-android), QAAUT-3331(Mweb-android), QAAUT-3332(Mweb-iOS):Verify Subscription banner on for you page")
    @Test
    public void verifySubscriptionBannerForYouPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySubscriptionBannerForYouPage");
        isStepTrue = marketPage.checkSubscribeBannerForYouPage(params.get("Link"), params.get("Link2"), params.get("Name"));
        Assert.assertTrue(isStepTrue, "Stocks table on market S&P BSE MIDCAP Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3481(Web), QAAUT-3490(AMP-iOS), QAAUT-3493(AMP-android), QAAUT-3482(Mweb-android), QAAUT-3486(Mweb-iOS):Validate on scroll listing page on market page")
    @Test
    public void verifyMarketPageScroll() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketPageScroll");
        isStepTrue = marketPage.checkMaketPageScroll(params.get("Link"), params.get("Page"));
        Assert.assertTrue(isStepTrue, "Scroll on market page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2559 (AMP-android), QAAUT-3374(AMP-iOS):Validate Indices details on Indices landing page")
    @Test
    public void verifyIndianIndicesDetailsAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesDetailsAmp");
        isStepTrue = marketPage.checkIndicesDetails(params.get("Link"), params.get("URI"), params.get("ID"));
        Assert.assertTrue(isStepTrue, "Validate Indices details on Indices Page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2603 (AMP-android), QAAUT-3376(AMP-iOS):Verify Indian indices table on NIFTY BANK landing page")
    @Test
    public void verifyIndianIndicesOnNiftyBankAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnNiftyBankAmp");
        isStepTrue = marketPage.checkIndianIndicesOnNifty50(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Verify Indian indices table on NIFTY BANK Page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2675 (AMP-android), QAAUT-3387(AMP-iOS):Validate Indian Indices table on market S&P BSE MIDCAP Landing page")
    @Test
    public void verifyIndianIndicesOnBseMidcapAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesOnBseMidcapAmp");
        isStepTrue = marketPage.checkIndianIndicesOnNifty50(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Validate Indian Indices table on market S&P BSE MIDCAP Landing page failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2663 (amp-android), QAAUT-3385 (amp-iOS):Validate Stocks table on market S&P BSE Sensex Landing page")
    @Test
    public void verifyBseSensexStockTableAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBseSensexStockTableAmp");
        isStepTrue = marketPage.checkSnPBseMidcapStockTable(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Stocks table on market S&P BSE Sensex Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2606 (amp-android), QAAUT-3377 (amp-iOS):Verify Stocks table on NIFTY BANK landing page")
    @Test
    public void verifyNiftyBankStockTableAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNiftyBankStockTableAmp");
        isStepTrue = marketPage.checkSnPBseMidcapStockTable(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Verify Stocks table on NIFTY BANK landing page failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2609 (AMP-android), QAAUT-3378, QAAUT-3612 (AMP-iOS):Validate Indian indices View All CTA on NIFTY BANK landing page")
    @Test
    public void verifyIndianIndicesViewAllNiftyBankAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesViewAllNiftyBankAmp");
        isStepTrue = marketPage.checkIndianIndicesViewAllNiftyBank(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"));
        Assert.assertTrue(isStepTrue, "Indian Indices View All on NiftyBank Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT- 2622 (android-AMP), QAAUT-3381 (iOS-AMP):Validate Indian indices View All CTA on S&P BSE MIDCAP landing page")
    @Test
    public void verifyIndianIndicesViewAllBseMidcapAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndianIndicesViewAllBseMidcapAmp");
        isStepTrue = marketPage.checkIndianIndicesViewAllBseMidcap(params.get("Link"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "Indian Indices View All on Bse Midcap Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2612 (android-AMP), QAAUT-3379 (iOS-AMP):Validate NIFTY BANK STOCKS View All CTA on NIFTY BANK landing page")
    @Test
    public void verifyNiftyBankStocksViewAllAmp() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNiftyBankStocksViewAllAmp");
        isStepTrue = marketPage.checkNiftyBankStocksViewAll(params.get("Link"),params.get("Link1"), params.get("Header"), params.get("URI"), params.get("ID"), params.get("URL"), params.get("Stocks"));
        Assert.assertTrue(isStepTrue, "NIFTY BANK STOCKS View All verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3255 (Web):Validate LHS ON market page")
    @Test
    public void verifyMarketPageLeftNav() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkLeftNavOnMarketPage();
        Assert.assertTrue(isStepTrue, "LHS ON market page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3248 (Web),QAAUT-3249 (Android-Web), QAAUT-3251 (Web) :Validate market Top Nav for Subscribed users")
    @Test
    public void verifyMarketPageToNavSubscribedUser() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketPageToNavSubscribedUser");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = marketPage.checkTopNavOnMarketPageSubscribedUser();
        Assert.assertTrue(isStepTrue, "Top Nav ON market page verification failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3220(Web), QAAUT-3223(iOS-Amp), QAAUT-3228(android-Amp), QAAUT-3230(iOS-web), QAAUT-3221(android-web):Validate market page layout")
    @Test
    public void verifyMarketPageLayout() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMarketPageLayout();
        Assert.assertTrue(isStepTrue, "Market page Layout verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3491(Web), QAAUT-3499(iOS-Amp), QAAUT-3497(android-Amp), QAAUT-3498(iOS-web), QAAUT-3496(android-web):Validate market page on Masthead add")
    @Test
    public void verifyMarketPageMastHeadAd() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMarketPageMastHeadAd();
        Assert.assertTrue(isStepTrue, "Market page Mast Head Ad verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3459 (Web) :Validate LHS ON market page for Subscribed Users")
    @Test
    public void verifyLHSForSubscribedUser() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLHSForSubscribedUser");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = marketPage.checkLeftNavOnMarketPage();
        Assert.assertTrue(isStepTrue, "LHS ON market page verification failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-2402 (android_native) : Verify that the company related news is listing just below the Company info section")
    @Test
    public void verifycheckCompanyDetailPageRelatedNewsListing() {
        boolean isStepTrue = marketPage.checkCompanyDetailPageRelatedNewsListing();
        Assert.assertTrue(isStepTrue, "Verify the company related news is listing just below the Company info section verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2599 (iOS-mweb), QAAUT-2598 (android-mweb) :Verify the graph on the Indices landing page")
    @Test
    public void verifyNiftyBankPageGraph() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNiftyBankPageGraph");
        isStepTrue = marketPage.checkNiftyBankGraph(params.get("Link"), params.get("Color"));
        Assert.assertTrue(isStepTrue, "Indices Graph verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4183 (android-web), QAAUT-4184 (iOS-mweb):Verify the graph on the Indices landing page")
    @Test
    public void verifyGraphOnIndianIndicesPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyGraphOnIndianIndicesPage");
        isStepTrue = marketPage.checkGraphOnIndianIndicesPage(params.get("Link"), params.get("Color"));
        Assert.assertTrue(isStepTrue, "Indices Graph verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4185 (android-web), QAAUT-2648 (iOS-mweb):Verify graph on nifty 50 Landing page.")
    @Test
    public void verifyGraphOnNifty50Page() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyGraphOnNifty50Page");
        isStepTrue = marketPage.checkGraphOnNifty50Page(params.get("Link"), params.get("Color"));
        Assert.assertTrue(isStepTrue, "Nifty 50 Graph verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2655 (android-web), QAAUT-2656 (iOS-mweb):Validate Graph details on S&P BSE SENSEX landing page")
    @Test
    public void verifyGraphOnBseSensexPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyGraphOnBseSensexPage");
        isStepTrue = marketPage.checkGraphOnBseSensexPage(params.get("Link"), params.get("Color"));
        Assert.assertTrue(isStepTrue, "Bse Sensex Graph verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT- 3902, 4186 (android-web), QAAUT-2532 (iOS-mweb):Validate TOP GAINER View All page")
    @Test
    public void verifyTopGainersViewAllPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopGainersViewAllPage");
        isStepTrue = marketPage.checkTopGainersViewAll(params.get("Link"), params.get("amp"));
        Assert.assertTrue(isStepTrue, "TOP GAINER View All page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT- 3903 (android-web), QAAUT-2542 (iOS-mweb):Validate TOP LOSERS View All page")
    @Test
    public void verifyTopLosersViewAllPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopLosersViewAllPage");
        isStepTrue = marketPage.checkTopLosersViewAll(params.get("Link"), params.get("amp"));
        Assert.assertTrue(isStepTrue, "TOP LOSERS View All page verification failed");
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3904 (iOS-amp), QAAUT- 2544 (android-amp), QAAUT-3905 (AMP-iOS):Validate TOP LOSERS View All page")
    @Test
    public void verifyTopLosersPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopLosersPage");
        isStepTrue = marketPage.checkTopLosersViewAll(params.get("Link"), params.get("amp"));
        Assert.assertTrue(isStepTrue, "TOP LOSERS View All page verification failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3901 (iOS-amp), QAAUT- 2533 (android-amp):Validate TOP GAINER View All page")
    @Test
    public void verifyTopGainersPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopGainersPage");
        isStepTrue = marketPage.checkTopLosersViewAll(params.get("Link"), params.get("amp"));
        Assert.assertTrue(isStepTrue, "TOP GAINER View All page verification failed");
    }


    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2261 (ios_native), QAAUT-2266 (android_native):Verify stock market (NIfty and Sensex)" )
    @Test
    public void verifyTickerStockMarkets() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTickerStockMarkets");

        isStepTrue = marketPage.checkTickerStockMarketNiftyAndSenSex();
        Assert.assertTrue(isStepTrue, "Market Ticker nifty and sensex verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2524 (android_native):Verify that selecting the BSE tab is showing the top 4 Gainers and losers list" )
    @Test
    public void verifyTopFourGainersAndLosersBse() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkBseTop4GainersAndLosers();
        Assert.assertTrue(isStepTrue, "BSE tab verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2525 (android_native):Verify that selecting the NSE tab is showing the top 4 Gainers and losers list" )
    @Test
    public void verifyTopFourGainersAndLosersNse() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkNseTop4GainersAndLosers();
        Assert.assertTrue(isStepTrue, "NSE tab verification failed*****");
    }
    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2527 (android_native):Verify functionality of View All button of Top Gainers" )
    @Test
    public void verifyViewAllTopGainers() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTopGainersViewAll();
        Assert.assertTrue(isStepTrue, "Company Detail page - Line Graph verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2528 (android_native):Company Detail page - Line Graph" )
    @Test
    public void verifyCompanyLineGraph() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkCompanyDetailLineGraph();
        Assert.assertTrue(isStepTrue, "Company Detail page - Line Graph verification failed*****");
    }


    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2264 (ios_native), QAAUT-2267 (android_native):verify Market Ticker Nifty Bank Detail Page" )
    @Test
    public void verifyMarketTickerNiftyBankDetailPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketTickerNiftyBankDetailPage");

        isStepTrue = marketPage.checkMarketTickerNiftyBankDetailPage();
        Assert.assertTrue(isStepTrue, "Market Ticker nifty bank detail page verification failed*****");
    }

    @Author(name = "Gulshan Tomar,Giridhar raj")
    @Description("QAAUT-2275 (android_native),QAAUT-2293 (ios_native):Verify that tapping on any indices is opening a new page for that particular indices with complete details" )
    @Test
    public void verifyIndiceRedirectionFunctionality() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkIndicesRedirectionFunctionality();
        Assert.assertTrue(isStepTrue, "Indice Redirection Functionality verification failed*****");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-2277 (android_native),QAAUT-2281 (ios_native):Verify that Taping on View All opens an Indian Indices page with all the available Indices list" )
    @Test
    public void verifyIndianIndicesViewAll() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkIndianIndicesViewAll();
        Assert.assertTrue(isStepTrue, "Indian Indices View All Functionality verification failed*****");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-2279 (android_native),QAAUT-2368 (ios_native):Verify that there is a Gainers & Losers section just below the Indian Indices - Verify that it's showing top 4 Gainer and Losers for both BSE and NSE" )
    @Test
    public void verifyGainersAndLosers() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkGainersAndLosers();
        Assert.assertTrue(isStepTrue, "Gainers & Losers section verification failed*****");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-2286 (android_native),QAAUT-2383 (ios_native):Verify that there are many types of Indices( List of different shares) showing in Indian Indices section." )
    @Test
    public void verifyIndianIndicesList() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkIndianIndicesList();
        Assert.assertTrue(isStepTrue, "Indian Indices verification failed*****");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-2287 (android_native),QAAUT-2294 (ios_native):Verify that there are 2 coloumns on the Indices section" )
    @Test
    public void verifyIndicesColumns() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkIndicesSection();
        Assert.assertTrue(isStepTrue, "Indian Indices Columns verification failed*****");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-2278 (android_native),QAAUT-2387 (ios_native):Verify that there is a News section about the selected Indices which can be accessed by scrolling the screen up" )
    @Test
    public void verifyBse100NewsSection() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkBse100NewsSection();
        Assert.assertTrue(isStepTrue, "Bse100 News section verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2458 (android_native),QAAUT-2393 (ios_native):Verify top Gainers view all" )
    @Test
    public void verifyTopGainersViewAll() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTopGainersViewAllFunctionality();
        Assert.assertTrue(isStepTrue, "Top Gainers view all verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2457 (android_native),QAAUT-2394 (ios_native):Verify top Losers view all" )
    @Test
    public void verifyTopLosersViewAll() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTopLosersViewAllFunctionality();
        Assert.assertTrue(isStepTrue, "Top Losers view all verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2461 (android_native),QAAUT-2389 (ios_native):Verify Gainers & Losers - BSE tabs" )
    @Test
    public void verifyGainersLosersBSETabs() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkBseTabsGainerLosers();
        Assert.assertTrue(isStepTrue, "Gainers & Losers - BSE tabs verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2460 (android_native),QAAUT-2391 (ios_native):Verify Gainers & Losers - NSE tabs" )
    @Test
    public void verifyGainersLosersNSETabs() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkNseTabsGainerLosers();
        Assert.assertTrue(isStepTrue, "Gainers & Losers - NSE tabs verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2459 (android_native),QAAUT-2392 (ios_native):Verify Gainers & Losers design" )
    @Test
    public void verifyGainersLosersDesign() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyGainersLosersDesign");

        isStepTrue = marketPage.checkGainerLosersDesign(params.get("gainer&loserText"));
        Assert.assertTrue(isStepTrue, "Gainers & Losers design verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2545 (android_native):Ticker - Detail page of NSE & BSE" )
    @Test
    public void verifyDetailPageBseNse() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkDetailPageOfNseAndBse();
        Assert.assertTrue(isStepTrue, "Detail page Bse & Nse verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2403 (ios_native),QAAUT-2452 (android_native):Most Active by Volume" )
    @Test
    public void verifyMostActiveByVolume() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMostActiveByVolume();
        Assert.assertTrue(isStepTrue, "Most Active by Volume verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2404 (ios_native),QAAUT-2451 (android_native):Most Active by Volume design" )
    @Test
    public void verifyMostActiveByVolumeDesign() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMostActiveByVolumeDesign();
        Assert.assertTrue(isStepTrue, "Most Active by Volume Design verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2405 (ios_native),QAAUT-2450 (android_native):Most Active by Volume View All" )
    @Test
    public void verifyMostActiveByVolumeViewAll() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMostActiveByVolumeViewAll();
        Assert.assertTrue(isStepTrue, "Most Active by Volume View All verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2406,2407 (ios_native),QAAUT-2448,2446 (android_native):Company Detail page - Design and line Graph" )
    @Test
    public void verifyCompanyDetailPageDesign() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkCompanyDetailPageDesign();
        Assert.assertTrue(isStepTrue, "Company Detail page - Design verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2411 (ios_native),QAAUT-2442 (android_native):Company Detail page - Company information" )
    @Test
    public void verifyCompanyDetailPageCompanyInfo() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkCompanyDetailPageInfo();
        Assert.assertTrue(isStepTrue, "Company Detail page - information verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2410,2409 (ios_native),QAAUT-2443,2444 (android_native):Financial - Standalone and Company Detail page - Financials " )
    @Test
    public void verifyFinancialStandalone() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkFinancialStandalone();
        Assert.assertTrue(isStepTrue, "Company Detail page - information verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2408 (ios_native),QAAUT-2445 (android_native):Company Detail page - price history" )
    @Test
    public void verifyCompanyDetailPagePriceHistory() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkCompanyDetailPagePriceHistory();
        Assert.assertTrue(isStepTrue, "Company Detail page - price history verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2395 (ios_native):Company Detail page - gainer and loser" )
    @Test
    public void verifyCompanyDetailPageGainerAndLoser() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkCompanyDetailPageGainerLoser();
        Assert.assertTrue(isStepTrue, "Company Detail page - gainer & loser verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2456 (android_native):Company Detail page - price history" )
    @Test
    public void verifyCompanyDetailPagePriceHistoryGainerLoser() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkCompanyDetailPagePriceHistoryGainerLoser();
        Assert.assertTrue(isStepTrue, "Company Detail page - price history verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2401 (ios_native),QAAUT-2453 (android_native):Company Detail page - Company information" )
    @Test
    public void verifyGainerLoserCompanyDetailPageCompanyInfo() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkGainerLoserCompanyDetailPageCompanyInfo();
        Assert.assertTrue(isStepTrue, "Company Detail page - information verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2400,2399 (ios_native),QAAUT-2455 (android_native):Financial - Standalone and Company Detail page - Financials " )
    @Test
    public void verifyGainerLoserFinancialStandalone() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkGainerLoserFinancialStandalone();
        Assert.assertTrue(isStepTrue, "Company Detail page - information verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2398 (ios_native):Company Detail page - price history" )
    @Test
    public void verifyGainerLoserCompanyDetailPagePriceHistory() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkGainerLoserCompanyDetailPagePriceHistory();
        Assert.assertTrue(isStepTrue, "Company Detail page - price history verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2396,2397 (ios_native):Company Detail page - Design and line Graph" )
    @Test
    public void verifyCompanyDetailPageDesignAndLineGraph() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkGainerLoserCompanyDetailPageDesign();
        Assert.assertTrue(isStepTrue, "Company Detail page - Design verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2699 (android_native):Verify Most Active by Volume is below the Gainer and Loser" )
    @Test
    public void verifyMostActiveByVolumeBelowGainernLoser() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMostActiveByVolumeBelowGainernLoser();
        Assert.assertTrue(isStepTrue, "Most Active by Volume below the Gainer and Loser Section verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2700 (android_native):Verify Indian Indices section" )
    @Test
    public void verifyIndianIndicesSection() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkIndianIndicesList();
        Assert.assertTrue(isStepTrue, "Indian Indices section verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-2701 (android_native): Verify Gainers & Losers below Indian Indices" )
    @Test
    public void verifyGainersAndLosersBelowIndianIndices() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkGainersAndLosersBelowIndianIndices();
        Assert.assertTrue(isStepTrue, "Gainers & Losers section below Indian Indices verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2386(ios_native):Company Detail page - specific Indices" )
    @Test
    public void verifyCompanyDetailPageDesignSpecificIndianIndices() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkCompanyDetailPageSpecificIndianIndices();
        Assert.assertTrue(isStepTrue, "Company Detail page - specific Indices verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2379(ios_native):Company Detail page - ticker" )
    @Test
    public void verifyTickerDetailPage() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTickerDetailPage();
        Assert.assertTrue(isStepTrue, "Company Detail page -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2371(ios_native):Ticker- Price, Changes & Percentage" )
    @Test
    public void verifyTickerPriceChangeAndPercentage() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTickerPriceAndPercentage();
        Assert.assertTrue(isStepTrue, "Ticker- Price, Changes & Percentage -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2719(android_native),QAAUT-2732(ios_native):verify market" )
    @Test
    public void verifyMarkets() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMarket();
        Assert.assertTrue(isStepTrue, "Market -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3968,3972(android_native),QAAUT-3974,3978(ios_native):verify mutual Funds Widget And Sub Category DropDown" )
    @Test
    public void verifyMutualFundsWidgetAndSubCategoryDropDown() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundsWidgetAndSubCategoryDropDown();
        Assert.assertTrue(isStepTrue, "mutual Funds -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3969(android_native),QAAUT-3975(ios_native):verify mutual Funds title" )
    @Test
    public void verifyMutualFundWidgetTitle() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundWidgetTitle();
        Assert.assertTrue(isStepTrue, "mutual Funds title -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3971,4190(android_native),QAAUT-3977(ios_native):verify mutual Funds Sub Category DropDown" )
    @Test
    public void verifySubCategoryDropDown() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkSubCategoryDropDown();
        Assert.assertTrue(isStepTrue, "mutual Funds Sub Category DropDown -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3973,4111(android_native),QAAUT-3979(ios_native):verify mutual Funds Sub Category default section" )
    @Test
    public void verifySubCategoryDefaultSection() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkSubCategoryDefaultSection();
        Assert.assertTrue(isStepTrue, "mutual Funds Sub Category default section -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3970,4107,4106(android_native):verify mutual Funds Sub Category default section" )
    @Test
    public void verifyCategoryTabs() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundCategoryTabs();
        Assert.assertTrue(isStepTrue, "mutual Funds Category tags -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4119(android_native):verify mutual Funds Nav Value" )
    @Test
    public void verifyMutualFundNavValue() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundNavValue();
        Assert.assertTrue(isStepTrue, "mutual Funds Nav Value -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4108(android_native):verify mutual Funds Category Tab- Default selection" )
    @Test
    public void verifyDefaultSelectionCategoryTab() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkDefaultSelectionCategoryTab();
        Assert.assertTrue(isStepTrue, "mutual Funds Category Tab- Default selection -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4104,4103(android_native):verify mutual Funds title page" )
    @Test
    public void verifyMutualFundListingPageTitle() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundListingPageTitle();
        Assert.assertTrue(isStepTrue, "mutual Funds title page -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4102(android_native):verify mutual Funds detail page" )
    @Test
    public void verifyMutualFundDetailPage() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundDetailPage();
        Assert.assertTrue(isStepTrue, "mutual Funds detail page -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4118,4117(android_native):verify mutual Funds detail page title" )
    @Test
    public void verifyMutualFundDetailPageTopSectionTitle() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundDetailPageTopSectionTitle();
        Assert.assertTrue(isStepTrue, "mutual Funds detail page title-verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4116(android_native):verify mutual Funds stories" )
    @Test
    public void verifyMutualFundStories() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundDetailPageTopSectionTitle();
        Assert.assertTrue(isStepTrue, "mutual Funds stories -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4115(android_native):verify mutual Funds return type" )
    @Test
    public void verifyMutualFundReturnType() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundDetailPageTopSectionTitle();
        Assert.assertTrue(isStepTrue, "mutual Funds return type -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4128(android_native):verify mutual Funds return table" )
    @Test
    public void verifyMutualFundReturnTable() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkMutualFundReturnTable();
        Assert.assertTrue(isStepTrue, "mutual Funds return table -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4127(android_native):verify mutual Funds Top Holding Section" )
    @Test
    public void verifyTopHoldingSection() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTopHoldingSection();
        Assert.assertTrue(isStepTrue, "mutual Funds Top Holding Section -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4126,4125(android_native):verify mutual Funds portfolio Section" )
    @Test
    public void verifyPortfolioSection() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkPortfolioSection();
        Assert.assertTrue(isStepTrue, "mutual Funds portfolio Section -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4121(android_native):verify mutual Funds Nav price graph" )
    @Test
    public void verifyNavPriceGraph() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkNavPriceGraph();
        Assert.assertTrue(isStepTrue, "mutual Funds nav price graph -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4120(android_native):verify mutual Funds Detail page - About Fund" )
    @Test
    public void verifyFundDetailPageAboutFund() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkFundDetailPageAboutFund();
        Assert.assertTrue(isStepTrue, "mutual Fund Detail page - About Fund -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4110(android_native):verify Sub-Category available options may vary " )
    @Test
    public void verifySubCategoryAvailableOption() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkSubCategoryAvailableOption();
        Assert.assertTrue(isStepTrue, "mutual Funds Sub Category may vary -verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4113(android_native):verify Fund Section Design " )
    @Test
    public void verifyFundSectionDesign() {
        boolean isStepTrue;
        isStepTrue = marketPage.CheckFundSectionDesign();
        Assert.assertTrue(isStepTrue, "mutual Fund Section Design -verification failed*****");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3469 (Web), QAAUT-4238(iOS-Amp), QAAUT-4237(android-Amp), QAAUT-3267(android_Web), QAAUT-3268(ios_Web):Validate Live blog landing page Title and URL" )
    @Test
    public void verifyLiveBlogPageTitle() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLiveBlogPageTitle");
        isStepTrue = marketPage.checkLiveBlogPageTitle(params.get("Amp"), params.get("Link"), params.get("LinkAmp"), params.get("Title"));
        Assert.assertTrue(isStepTrue, "Live blog landing page Title and URL verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3468 (Web), QAAUT-3474(iOS-Amp), QAAUT-4237(android-Amp), QAAUT-3471(android_Web), QAAUT-3472(ios_Web):Verify page content on market page" )
    @Test
    public void verifyMarketPageContent() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketPageContent");
        isStepTrue = marketPage.checkMarketPageContent(params.get("Amp"));
        Assert.assertTrue(isStepTrue, "Market Page Content verification failed*****");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3500 (Web):Validate market RHS First Ad" )
    @Test
    public void verifyTopRightAdOnMarketPage() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkTopRightAdMarketPage();
        Assert.assertTrue(isStepTrue, "Market Page RHS First Ad verification failed*****");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4015(iOS-Amp), QAAUT-4014(android-Amp), QAAUT-4463(android_Web), QAAUT-4464(ios_Web):Validate Open App in story page" )
    @Test
    public void verifyOpenAppInStoryPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyOpenAppInStoryPage");
        isStepTrue = marketPage.checkOpenAppInStory(params.get("Amp"));
        Assert.assertTrue(isStepTrue, "Open App in Story Page verification failed*****");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4529(iOS-Amp), QAAUT-4530(android-Amp), QAAUT-4016(android_Web), QAAUT-4017(ios_Web):Validate Open App in Section page" )
    @Test
    public void verifyOpenAppInSectionPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyOpenAppInSectionPage");
        isStepTrue = marketPage.checkOpenAppSectionPage(params.get("Amp"));
        Assert.assertTrue(isStepTrue, "Open App iin Section page verification failed*****");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4192(iOS-Amp), QAAUT-4193(android-Amp), QAAUT-4191(android_Web), QAAUT-4190(ios_Web):Validate Open App in story page" )
    @Test
    public void verifyOpenAppInSubSectionPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyOpenAppInSubSectionPage");
        isStepTrue = marketPage.checkOpenAppSubSectionPage(params.get("Amp"));
        Assert.assertTrue(isStepTrue, "Open App in Story Page verification failed*****");
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3234 (Web), QAAUT-3245(iOS-Amp), QAAUT-3241(android-Amp), QAAUT-3237(android_Web), QAAUT-3239(ios_Web):Validate markets Top nav for non-subscribed" )
    @Test
    public void verifyMarketsTopNav() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketsTopNav");
        isStepTrue = marketPage.checkMarketsTopNaV(params.get("Link"), params.get("Link2"));
        Assert.assertTrue(isStepTrue, "Validate markets Top nav for non-subscribed verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3915 (Web), QAAUT-3916 (Android-Web), QAAUT-3917(iOS-Web), QAAUT-4549(iOS_Amp), QAAUT-4548(iOS_Amp): Validate Share Icon on politics Section page" )
    @Test
    public void verifyShareIconsOnPoliticsPage() {
        boolean isStepTrue;
        isStepTrue = marketPage.checkShareIconsPoliticsPage();
        Assert.assertTrue(isStepTrue, "Share Icon on politics Section page verification failed*****");
    }

    @Author(name = "Javed Alam")
   @Description("QAAUT-4099(android_native): Verify that the maximum 5 funds are showing on each Category & Sub category selection")
    @Test
    public void verifyMutualFundMaximumFundListing() {
        boolean isStepTrue = marketPage.checkMutualFundMaximumFundListing();
        Assert.assertTrue(isStepTrue, "Verify that the maximum 5 funds are showing on each Category & Sub category selection verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4750,4751(android_native): Verify ")
    @Test
    public void verifyMostActiveByVolumeDetailPageAndBackBtn() {
        boolean isStepTrue = marketPage.checkMostActiveByVolumeDetailPageAndBackBtn();
        Assert.assertTrue(isStepTrue, "Verify  verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4752,4756(android_native): Verify Stock Detail Page L1 Tab")
    @Test
    public void verifyStockDetailPageL1Tab() {
        boolean isStepTrue = marketPage.checkStockDetailPageL1Tab();
        Assert.assertTrue(isStepTrue, "Stock Detail Page L1 Tab verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4757,4758(android_native): Verify Stock title and share option")
    @Test
    public void verifyStockTitleWithShareIcon() {
        boolean isStepTrue = marketPage.checkStockTitleWithShareIcon();
        Assert.assertTrue(isStepTrue, "Stock title and share option verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4759(android_native): Verify Stock add to watchlist")
    @Test
    public void verifyStockAddToWatchList() {
        boolean isStepTrue = marketPage.checkStockAddToWatchList();
        Assert.assertTrue(isStepTrue, "Stock add to watchlist verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4760(android_native): Verify Stock price")
    @Test
    public void verifyStockPrice() {
        boolean isStepTrue = marketPage.checkStockPrice();
        Assert.assertTrue(isStepTrue, "Stock price verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4761(android_native): Verify Stock bse and nse")
    @Test
    public void verifyStockPriceBSENSE() {
        boolean isStepTrue = marketPage.checkStockPriceBSENSE();
        Assert.assertTrue(isStepTrue, "Stock bse and nse verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4762(android_native): Verify Stock price graph")
    @Test
    public void verifyStockPriceGraph() {
        boolean isStepTrue = marketPage.checkStockPriceGraph();
        Assert.assertTrue(isStepTrue, "Stock price graph verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4764(android_native): Verify Stock price range")
    @Test
    public void verifyStockPriceRange() {
        boolean isStepTrue = marketPage.checkStockPriceRange();
        Assert.assertTrue(isStepTrue, "Stock price range verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4765(android_native): Verify Stock key matrics")
    @Test
    public void verifyStockKeyMatrics() {
        boolean isStepTrue = marketPage.checkStockKeyMatrics();
        Assert.assertTrue(isStepTrue, "Stock key matrics verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4766(android_native): Verify Stock analysis")
    @Test
    public void verifyStockAnaysis() {
        boolean isStepTrue = marketPage.checkStockAnaysis();
        Assert.assertTrue(isStepTrue, "Stock analysis verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4767(android_native): Verify Stock risk meter")
    @Test
    public void verifyStockRiskMeter() {
        boolean isStepTrue = marketPage.checkStockRiskMeter();
        Assert.assertTrue(isStepTrue, "Stock risk meter verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4768(android_native): Verify Stock recos")
    @Test
    public void verifyStockRecos() {
        boolean isStepTrue = marketPage.checkStockRecos();
        Assert.assertTrue(isStepTrue, "Stock recos verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4770(android_native): Verify Stock forecast")
    @Test
    public void verifyStockForecast() {
        boolean isStepTrue = marketPage.checkStockForecast();
        Assert.assertTrue(isStepTrue, "Stock forecast verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4771(android_native): Verify Stock financials")
    @Test
    public void verifyStockFinancials() {
        boolean isStepTrue = marketPage.checkStockFinancials();
        Assert.assertTrue(isStepTrue, "Stock financials verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4772(android_native): Verify Stock technicals")
    @Test
    public void verifyStockTechnical() {
        boolean isStepTrue = marketPage.checkStockTechnical();
        Assert.assertTrue(isStepTrue, "Stock technicals verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4773(android_native): Verify Stock peers section")
    @Test
    public void verifyStockPeersSection() {
        boolean isStepTrue = marketPage.checkStockPeersSection();
        Assert.assertTrue(isStepTrue, "Stock peers section verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4774(android_native): Verify Stock about company")
    @Test
    public void verifyStockAboutCompany() {
        boolean isStepTrue = marketPage.checkStockAboutCompany();
        Assert.assertTrue(isStepTrue, "Stock about company verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4755(android_native): Verify Stock L1 tab overview")
    @Test
    public void verifyL1TabOverview() {
        boolean isStepTrue = marketPage.checkL1TabOverview();
        Assert.assertTrue(isStepTrue, "Stock L1 tab overview verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4754(android_native): Verify Stock L1 tab scrollable")
    @Test
    public void verifyL1TabScrollable() {
        boolean isStepTrue = marketPage.checkL1TabScrollable();
        Assert.assertTrue(isStepTrue, "Stock L1 tab scrollable verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4769(android_native): Verify Stock news section")
    @Test
    public void verifyNewsSection() {
        boolean isStepTrue = marketPage.checkNewsSectionOnDetailPage();
        Assert.assertTrue(isStepTrue, "news section verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5804,5805,5806,5812(android_native): Verify watchlist icon,watchlist stocks & Three dots")
    @Test
    public void verifyWatchlistIconAndStocksAndThreeDots() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
       boolean isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Non Subscribed user login verification Failed*******");

        isStepTrue = marketPage.checkWatchlistIconAndStocks();
        Assert.assertTrue(isStepTrue, "watchlist icon & stocks verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5808(android_native): Verify watchlist news section not displayed")
    @Test
    public void verifyWatchlistNewsSectionNotDisplayed() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        boolean isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Non Subscribed user login verification Failed*******");

        isStepTrue = marketPage.checkWatchlistNewsSectionNotDisplayed();
        Assert.assertTrue(isStepTrue, "watchlist news section displayed verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5811,5813,5814(android_native): Verify watchlist news toast massage and view stock")
    @Test
    public void verifyWatchlistViewStockSpecificStockPageAndNewsToasterMassage() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyWatchlistViewStockSpecificStockPageAndNewsToasterMassage");
        boolean isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Non Subscribed user login verification Failed*******");

        isStepTrue = marketPage.checkWatchlistViewStockAndToasterMassage(params.get("expText"));
        Assert.assertTrue(isStepTrue, "watchlist news toaster massage & view stock verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5807,5808(android_native): Verify watchlist news section not displayed")
    @Test
    public void verifyWatchlistNewsDesignAndNewsCount() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        boolean isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Non Subscribed user login verification Failed*******");

        isStepTrue = marketPage.checkNewsDesignAndNewsCount();
        Assert.assertTrue(isStepTrue, "watchlist no. of news & design not displayed verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

}

