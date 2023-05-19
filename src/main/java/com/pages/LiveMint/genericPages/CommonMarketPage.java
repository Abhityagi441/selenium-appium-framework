package com.pages.LiveMint.genericPages;


import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMarketPage {
    private static CommonMarketPage commonMarketPage;
    private static GlobalVars globalVars;

    public static CommonMarketPage getInstance() {
        System.out.println("******************* beforeMethod MarketPage starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonMarketPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonMarketPage = new com.pages.LiveMint.android_native.MarketPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonMarketPage = new com.pages.LiveMint.ios_native.MarketPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonMarketPage = new com.pages.LiveMint.web.Market();
                    break;
                case Constants.ANDROID_WEB:
                    commonMarketPage = new com.pages.LiveMint.android_mweb.MarketPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonMarketPage = new com.pages.LiveMint.android_amp.MarketPage();
                    break;
                case Constants.IOS_WEB:
                    commonMarketPage = new com.pages.LiveMint.ios_mweb.MarketPage();
                    break;
                case Constants.IOS_AMP:
                    commonMarketPage = new com.pages.LiveMint.ios_amp.MarketPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod MarketPage ends here *******************");
        return commonMarketPage;
    }


    public abstract boolean checkIndianIndicesPage(String url);

    public abstract boolean checkMarketDashboardPage(String url);

    public abstract boolean checkMarketSnPBseMidcapLandingPage();

    public abstract boolean checkMarketNifty50LandingPage(String url, String Header);

    public abstract boolean checkMarketNifty50Graph(String[] params);

    public abstract boolean checkSnPBseSensexGraph(String[] params);

    public abstract boolean checkNiftyBankGraph(String[] params);

    public abstract boolean checkSnPBseMidcapGraph(String[] params);

    public abstract boolean checkMostActiveVolViewAll();

    public abstract boolean checkTopLosersViewAll(String[] params);

    public abstract boolean checkTopGainersViewAll(String[] params);

    public abstract boolean checkMFDetailPage(String[] params);

    public abstract boolean checkIndianIndicesGraph(String Link, String Color);

    public abstract boolean checkBseTop4GainersAndLosers();

    public abstract boolean checkNseTop4GainersAndLosers();

    public abstract boolean checkTopGainersViewAll();

    public abstract boolean checkTopLosersViewAll();

    public abstract boolean checkMostActByVolViewAll();

    public abstract boolean checkSnPBseMidcapStockTable(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkMostActiveByVolumeMarketDashbaord(String Link, String Color, String URI, String Companies);

    public abstract boolean checkTopGainerMarketDashbaord(String Link, String Color, String URI, String Gainers);

    public abstract boolean checkTopLoserMarketDashbaord(String Link, String Color, String URI, String Losers);

    public abstract boolean checkStockTableNiftyBank(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkStockTableBseSensex(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkStockTableBseSensexViewAll(String Link, String Header, String URI, String ID);

    public abstract boolean checkStockTableBseSensexViewAllAmp(String Link, String Header, String URI, String ID);

    public abstract boolean checkIndianIndicesPageAmp(String Link);

    public abstract boolean checkIndianIndicesTable(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkIndianIndicesViewAll(String Link, String Header, String URI, String ID, String URL);

    public abstract boolean checkNiftyBankStocksViewAll(String Link, String Link1, String Header, String URI, String ID, String URL, String stocks);

    public abstract boolean checkStockNifty50(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkIndianIndicesOnBseSensex(String Link, String Header, String URI, String ID, String URL);

    public abstract boolean checkIndianIndicesOnNiftyBank(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkIndianIndicesOnBseMidcap(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkIndianIndicesOnNifty50(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkIndianIndicesViewAllBseMidcap(String Link, String Header, String URI, String ID, String stocks);

    public abstract boolean checkIndianIndicesViewAllNiftyBank(String Link, String Header, String URI, String ID);

    public abstract boolean checkIndianIndicesViewAllOnBseSensex(String Link, String Amp, String Header, String URI, String ID, String Stocks, String ampURL, String webURL, String url3);

    public abstract boolean checkStocksTableOnIndicePage(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkStocksTableOnIndicePageAMP(String Link, String Header, String URI, String ID, String Stocks);

    public abstract boolean checkMarketsTopNaV(String Link, String Link2);


    public abstract boolean checkSubscribeBannerForYouPage(String Link, String Link2, String Name);

    public abstract boolean checkMaketPageScroll(String Link, String Page);

    public abstract boolean checkIndicesDetails(String Link, String URI, String ID);

    public abstract boolean checkLeftNavOnMarketPage();

    public abstract boolean checkTopNavOnMarketPageSubscribedUser();

    public abstract boolean checkMarketPageLayout();

    public abstract boolean checkMarketPageMastHeadAd();

    public abstract boolean checkNewsSectionInExplore();

    public abstract boolean checkCompanyDetailPageRelatedNewsListing();
    public abstract boolean checkNiftyBankGraph(String Link, String Color);

    public abstract boolean checkGraphOnIndianIndicesPage(String Link, String Color);

    public abstract boolean checkGraphOnNifty50Page(String Link, String Color);

    public abstract boolean checkGraphOnBseSensexPage(String Link, String Color);

    public abstract boolean checkTopGainersViewAll(String Link, String amp);

    public abstract boolean checkTopLosersViewAll(String Link, String amp);
    public abstract boolean checkTickerStockMarketNiftyAndSenSex();
    public abstract boolean checkCompanyDetailLineGraph();

    public abstract boolean checkDetailPageOfNseAndBse();

    public abstract boolean checkMarketTickerNiftyBankDetailPage();

    public abstract boolean checkIndicesRedirectionFunctionality();

    public abstract boolean checkIndianIndicesViewAll();

    public abstract boolean checkGainersAndLosers();

    public abstract boolean checkIndianIndicesList();

    public abstract boolean checkIndicesSection();

    public abstract boolean checkBse100NewsSection();

    public abstract boolean checkTopGainersViewAllFunctionality();

    public abstract boolean checkTopLosersViewAllFunctionality();

    public abstract boolean checkBseTabsGainerLosers();

    public abstract boolean checkNseTabsGainerLosers();

    public abstract boolean checkGainerLosersDesign(String gainerLoserText);

    public abstract boolean checkMostActiveByVolume();

    public abstract boolean checkMostActiveByVolumeDesign();

    public abstract boolean checkCompanyDetailPageDesign();

    public abstract boolean checkMostActiveByVolumeViewAll();

    public abstract boolean checkCompanyDetailPageInfo();

    public abstract boolean checkFinancialStandalone();

    public abstract boolean checkCompanyDetailPagePriceHistory();

    public abstract boolean checkCompanyDetailPageGainerLoser();

    public abstract boolean checkCompanyDetailPagePriceHistoryGainerLoser();

    public abstract boolean checkMostActiveByVolumeBelowGainernLoser();

    public abstract boolean checkIndianIndicesSection();

    public abstract boolean checkGainersAndLosersBelowIndianIndices();

    public abstract boolean checkGainerLoserCompanyDetailPageCompanyInfo();

    public abstract boolean checkGainerLoserFinancialStandalone();

    public abstract boolean checkGainerLoserCompanyDetailPagePriceHistory();

    public abstract boolean checkGainerLoserCompanyDetailPageDesign();

    public abstract boolean checkCompanyDetailPageSpecificIndianIndices();

    public abstract boolean checkTickerDetailPage();

    public abstract boolean checkTickerPriceAndPercentage();

    public abstract boolean checkMarket();
    public abstract boolean checkMutualFundsWidgetAndSubCategoryDropDown();
    public abstract boolean checkMutualFundWidgetTitle();
    public abstract boolean checkSubCategoryDropDown();
    public abstract boolean checkSubCategoryDefaultSection();
    public abstract boolean checkMutualFundCategoryTabs();
    public abstract boolean checkMutualFundDetailPage();
    public abstract boolean checkDefaultSelectionCategoryTab();
    public abstract boolean checkMutualFundListingPageTitle();
    public abstract boolean checkMutualFundNavValue();
    public abstract boolean checkMutualFundDetailPageTopSectionTitle();
    public abstract boolean checkMutualFundStories();
    public abstract boolean checkMutualFundReturnType();
    public abstract boolean checkMutualFundReturnTable();
    public abstract boolean checkTopHoldingSection();
    public abstract boolean checkPortfolioSection();
    public abstract boolean checkNavPriceGraph();
    public abstract boolean checkLiveBlogPage(String Amp, String Link, String LinkAmp);
    public abstract boolean checkLiveBlogLeadImagenCaption(String Amp, String Link, String LinkAmp);
    public abstract boolean checkLiveBlogSocialnBookmarkIcons(String Amp);
    public abstract boolean checkSubCategoryAvailableOption();
    public abstract boolean checkFundDetailPageAboutFund();
    public abstract  boolean CheckFundSectionDesign();
    public abstract boolean checkLiveBlogPageTitle(String Amp, String Link, String LinkAmp, String Title);

    public abstract boolean checkMarketPageContent(String Amp);

    public abstract boolean checkTopRightAdMarketPage();

    public abstract boolean checkOpenAppInStory(String Amp);

    public abstract boolean checkOpenAppSectionPage(String Amp);

    public abstract boolean checkOpenAppSubSectionPage(String Amp);

    public abstract boolean checkShareIconsPoliticsPage();

    public abstract boolean checkMutualFundMaximumFundListing();

    public abstract boolean checkMostActiveByVolumeDetailPageAndBackBtn();

    public abstract boolean checkStockDetailPageL1Tab();

    public abstract boolean checkStockTitleWithShareIcon();

    public abstract boolean checkStockAddToWatchList();

    public abstract boolean checkStockPrice();

    public abstract boolean checkStockPriceBSENSE();

    public abstract boolean checkStockPriceGraph();

    public abstract boolean checkStockPriceRange();

    public abstract boolean checkStockKeyMatrics();

    public abstract boolean checkStockAnaysis();

    public abstract boolean checkStockRiskMeter();

    public abstract boolean checkStockRecos();

    public abstract boolean checkStockForecast();

    public abstract boolean checkStockFinancials();

    public abstract boolean checkStockTechnical();

    public abstract boolean checkStockPeersSection();

    public abstract boolean checkStockAboutCompany();

    public abstract boolean checkL1TabOverview();

    public abstract boolean checkL1TabScrollable();

    public abstract boolean checkNewsSectionOnDetailPage();

    public abstract boolean checkWatchlistIconAndStocks();

    public abstract boolean checkWatchlistNewsSectionNotDisplayed();

    public abstract boolean checkWatchlistViewStockAndToasterMassage(String expText);

    public abstract boolean checkNewsDesignAndNewsCount();

    public abstract boolean checkHomeTrendingStocksWidget();

    public abstract boolean checkTrendingStocksWidgetTop3Gainer();

    public abstract boolean checkTrendingLoserStockDetailPage();

    public abstract boolean checkTrendingStocksWidgetTop3Loser();

    public abstract boolean checkTrendingGainerStockDetailPage();

    public abstract boolean checkTrendingStocksMarketDashboard();

    public abstract boolean checkTrendingStockLeftAndRightSwipeFunctionality();
}


