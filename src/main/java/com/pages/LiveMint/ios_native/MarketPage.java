package com.pages.LiveMint.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonMarketPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketPage extends CommonMarketPage {

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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Continue'`]")
    private static MobileElement continueAdsFreeUserExp;
    @iOSXCUITFindBy(id = "BSE SENSEX")
    private static MobileElement marketTickerBseSenSex;
    @iOSXCUITFindBy(id = "NIFTY 50")
    private static MobileElement marketTickerNifty50;
    @iOSXCUITFindBy(id = "Nifty 50")
    private static MobileElement marketTickerNifty50LandingPage;
    @iOSXCUITFindBy(id = "NIFTY BANK")
    private static MobileElement marketTickerNiftyBank;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'back'`]")
    private static MobileElement backButton;
    @iOSXCUITFindBy(id = "Nifty Bank")
    private static MobileElement marketTickerNiftyBankLandingPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'MINT PREMIUM'`][1]")
    private static MobileElement homePageMintPremium;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Advertisement'`][1]")
    private static MobileElement firstAdsAdvertisementLabel;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Remove Ad'`]")
    private static MobileElement firstAdsRemoveAdButton;
    @iOSXCUITFindBy(id = "Choose a plan")
    private static MobileElement planPage;
    @iOSXCUITFindBy(id = "Markets")
    private static MobileElement marketTab;
    @iOSXCUITFindBy(accessibility = "MARKETS")
    private static MobileElement marketTickerPage;
    @iOSXCUITFindBy(id = "NIFTY Bank")
    private static MobileElement marketTickerPageNiftyBank;
    @iOSXCUITFindBy(id = "S&P BSE SENSEX")
    private static MobileElement marketTickerPageSensex;
    @iOSXCUITFindBy(id = "S&P BSE Midcap")
    private static MobileElement marketTickerPageMindCap;
    @iOSXCUITFindBy(id = "NIFTY 50")
    private static MobileElement marketTickerPageNifty50;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'NIFTY Bank'`][2]")
    private static MobileElement marketTickerPageNiftyBankDetailPage;
    @iOSXCUITFindBy(id = "For You")
    private static MobileElement forYouTab;
    @iOSXCUITFindBy(accessibility = "FOR YOU")
    private static MobileElement forYouPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All'`][1]")
    private static MobileElement viewAllMarketPage;
    @iOSXCUITFindBy(accessibility = "INDIAN INDICES")
    private static MobileElement indianIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfElementOnIndianIndicesPage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='S&P BSE 500']")
    private static MobileElement secondIndianIndices;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='S&P BSE 500'])[1]")
    private static MobileElement secondIndianIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '5D'`]")
    private static MobileElement fiveDOnIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '1M'`]")
    private static MobileElement oneMOnIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '1Y'`]")
    private static MobileElement oneYOnIndicesPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == '5Y'`]")
    private static MobileElement fiveYOnIndicesPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'%')])[5]")
    private static MobileElement priceChangeInPercentage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,',')])[2]")
    private static MobileElement latestPrice;
    @iOSXCUITFindBy(accessibility = "GAINERS & LOSERS")
    private static MobileElement gainerAndLosers;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`][1]")
    private static MobileElement gainerAndLosersBse;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`][1]")
    private static MobileElement gainerAndLosersNse;
    @iOSXCUITFindBy(accessibility = "Top Gainers")
    private static MobileElement topGainer;
    @iOSXCUITFindBy(accessibility = "Top Losers")
    private static MobileElement topLoser;
    @iOSXCUITFindBy(accessibility = "S&P BSE 100")
    private static MobileElement firstIndianIndices;
    @iOSXCUITFindBy(accessibility = "S&P BSE 500")
    private static MobileElement thirdIndianIndices;
    @iOSXCUITFindBy(accessibility = "S&P BSE Bankex")
    private static MobileElement fourthIndianIndices;
    @iOSXCUITFindBy(accessibility = "NEWS - S&P BSE 100")
    private static MobileElement NewsBse100;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'View All'`][2]")
    private static MobileElement topLoserViewAll;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'View All'`][3]")
    private static MobileElement topGainerViewAll;
    @iOSXCUITFindBy(accessibility = "TOP GAINERS")
    private static MobileElement topGainerDetailPage;
    @iOSXCUITFindBy(accessibility = "TOP LOSERS")
    private static MobileElement topLoserDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfElementOnTopGainersPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfElementOnTopLosersPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'Updated')])[1]")
    private static MobileElement gainersLoserUpdateStatus;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`][1]")
    private static MobileElement gainersLoserBseTab;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`][1]")
    private static MobileElement gainersLoserNseTab;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='View All'])[2]/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listOfElementOnGainerLoserSection;
    @iOSXCUITFindBy(id = "MOST ACTIVE BY VOLUME")
    private static MobileElement mostActiveByVolume;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`][2]")
    private static MobileElement mostActiveByVolumeBseTab;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`][2]")
    private static MobileElement mostActiveByVolumeNseTab;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]")
    private static MobileElement mostActiveByVolumeUpdateStatus;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All'`][4]")
    private static MobileElement mostActiveByVolumeViewAll;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSegmentedControl)[2]/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listOfElementOnMostActiveByVolumeSection;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[2]")
    private static MobileElement mostActiveByVolumeFirstHighestLevel;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[4]")
    private static MobileElement mostActiveByVolumeSecondHighestLevel;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[5]")
    private static MobileElement mostActiveByVolumeThirdHighestLevel;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeStaticText[contains(@name,'Updated')])[2]/following-sibling::XCUIElementTypeStaticText)[7]")
    private static MobileElement mostActiveByVolumeFourthHighestLevel;
    @iOSXCUITFindBy(id = "SECURITY")
    private static MobileElement mostActiveByVolumeSecurity;
    @iOSXCUITFindBy(id = "VOL(000’S)")
    private static MobileElement mostActiveByVolumeVol;
    @iOSXCUITFindBy(id = "CHANGE")
    private static MobileElement mostActiveByVolumeChange;
    @iOSXCUITFindBy(id = "MOST ACTIVE BY VOLUME")
    private static MobileElement mostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell")
    private static List<MobileElement> listOfCompanyOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'NSE'`]")
    private static MobileElement nseTabOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'BSE'`]")
    private static MobileElement bseTabOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='NSE']/following-sibling::XCUIElementTypeStaticText)[3]")
    private static MobileElement companyShortNameOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='NSE']/following-sibling::XCUIElementTypeStaticText)[4]")
    private static MobileElement companyFullNameOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='NSE']/following-sibling::XCUIElementTypeStaticText)[4]")
    private static MobileElement stockPriceOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText)[2]")
    private static MobileElement firstCompanyVolumeOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeCell)[3]/XCUIElementTypeStaticText)[2]")
    private static MobileElement secondCompanyVolumeOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeCell)[4]/XCUIElementTypeStaticText)[2]")
    private static MobileElement thirdCompanyVolumeOnMostActiveByVolumeDetailPage;
    @iOSXCUITFindBy(xpath = "((//XCUIElementTypeSegmentedControl)[2]/following-sibling::XCUIElementTypeStaticText)[2]")
    private static MobileElement firstCompanyNameOnMostActiveByVolume;
    @iOSXCUITFindBy(id = "Prv close")
    private static MobileElement previousCloseSection;
    @iOSXCUITFindBy(id = "Open price")
    private static MobileElement openPriceSection;
    @iOSXCUITFindBy(id = "Day high")
    private static MobileElement dayHighSection;
    @iOSXCUITFindBy(id = "Day low")
    private static MobileElement dayLowSection;
    @iOSXCUITFindBy(id = "52 week low")
    private static MobileElement Week52LowSection;
    @iOSXCUITFindBy(id = "52 week high")
    private static MobileElement Week52HighSection;
    @iOSXCUITFindBy(id = "Bid quantity")
    private static MobileElement BidQuantitySection;
    @iOSXCUITFindBy(id = "Volume")
    private static MobileElement volumeSection;
    @iOSXCUITFindBy(id = "FINANCIALS")
    private static MobileElement finanicalSection;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Balance sheet'`]")
    private static MobileElement BalanceSheetSection;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Income statement'`]")
    private static MobileElement incomeStatementSection;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DATE']/following-sibling::XCUIElementTypeTextField")
    private static MobileElement dateDropDownSection;
    @iOSXCUITFindBy(id = "Standalone")
    private static MobileElement standaloneSection;
    @iOSXCUITFindBy(id = "Total Revenue ")
    private static MobileElement totalRevenueTag;
    @iOSXCUITFindBy(id = "Cash ")
    private static MobileElement cashTag;
    @iOSXCUITFindBy(id = "COMPANY INFORMATION")
    private static MobileElement companyInfoSection;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'About ')]")
    private static MobileElement companyInfoAboutSection;
    @iOSXCUITFindBy(id = "Management")
    private static MobileElement companyInfoManagementSection;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == '+'`][1]")
    private static MobileElement companyInfoAboutPlusButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == '+'`][2]")
    private static MobileElement companyInfoManagementPlusButton;
    @iOSXCUITFindBy(id = "Industry")
    private static MobileElement companyInfoAboutInDetail;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == '-'`][3]")
    private static MobileElement companyInfoAboutCollepsedButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Chief ')]")
    private static MobileElement companyInfoManagementInDetail;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='gainersId'])[1]")
    private static MobileElement topGainerFirstCompanyName;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[2]//XCUIElementTypeStaticText)[5]")
    private static MobileElement FirstCompanyDetailNameGainerDetailPage;
    @iOSXCUITFindBy(id = "Line Chart. 1 dataset. ")
    private static MobileElement lineGraph;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'%')])[3]")
    private static MobileElement priceChangeInPercentageOnDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,',')])[5]")
    private static MobileElement latestPriceOnDetailPage;
    @iOSXCUITFindBy(id = "OPEN PRICE")
    private static MobileElement openPriceTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "PREVIOUS CLOSE")
    private static MobileElement preCloseTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "DAY HIGH")
    private static MobileElement dayHighTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "DAY LOW")
    private static MobileElement dayLowTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "52 WEEK HIGH")
    private static MobileElement week52HighTagOnIndicesDetailPage;
    @iOSXCUITFindBy(id = "52 WEEK LOW")
    private static MobileElement week52LowTagOnIndicesDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'.')])[1]")
    private static MobileElement niftyLatestChangesPrice;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'%')])[3]")
    private static MobileElement niftyLatestChangesPriceInPercentage;
    @iOSXCUITFindBy(id = "News")
    private static MobileElement newsTab;
    @iOSXCUITFindBy(id = "MINT SNAPVIEW")
    private static MobileElement mintSnapView;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Read Now'`]")
    private static MobileElement newsLetterReadNow;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[13]")
    private static MobileElement storyListSize;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[14]")
    private static MobileElement newsLetterPosition;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[14]/XCUIElementTypeOther[1]")
    private static MobileElement newsLetterTopSpace;
    @iOSXCUITFindBy(id = "TOP OF THE")
    private static MobileElement topOfTheWebView;
    @iOSXCUITFindBy(id = "MORNING")
    private static MobileElement morningWebView;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Close'`]")
    private static MobileElement webViewCloseButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[2])[1]")
    private static MobileElement secondStoryOnHomePage ;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='storyHeadlineId'])[1]")
    private static MobileElement storyDetailPageHeadline;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All '`][1]")
    private static MobileElement mintPremiumViewAllStoryDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
    private static MobileElement firstStoryOnHomePage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'View All '`][2]")
    private static MobileElement secondViewAllStoryDetailPage;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='aa'])[2]")
    private static MobileElement fontSizeOnStoryDetailPage;
    @iOSXCUITFindBy(id = "ic close")
    private static MobileElement exploreCloseIcon;
    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement exploreBottomNavigation;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    private static MobileElement marketTicker;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='TOP PERFORMING MUTUAL FUNDS'])[1]")
    private static MobileElement mutualFundTPMF;
    @iOSXCUITFindBy(iOSClassChain = "//XCUIElementTypeOther[@name='TOP PERFORMING MUTUAL FUNDS']/XCUIElementTypeTextField")
    private static MobileElement mutualFundTPMFDropDown;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Debt'])[1]")
    private static MobileElement mutualFundDebtCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Equity'])[1]")
    private static MobileElement mutualFundEquityCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Global Fund of Funds'])[1]")
    private static MobileElement mutualFundGlobalFundCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Hybrid'])[1]")
    private static MobileElement mutualFundHybridCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Index Funds'])[1]")
    private static MobileElement mutualFundIndexFundCategory;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Commodities'])[1]")
    private static MobileElement mutualFundCommoditiesCategory;
    @iOSXCUITFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Index Funds']")
    private static MobileElement mutualFundIndexFundsCategory;
    @iOSXCUITFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Other']")
    private static MobileElement mutualFundOtherCategory;
    @iOSXCUITFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Solutions Oriented']")
    private static MobileElement mutualFundSolutionsOrientedCategory;
    @iOSXCUITFindBy(iOSClassChain= "**/XCUIElementTypeButton[`label == 'View All'`][5]")
    private static MobileElement mutualFundViewAll;
    @iOSXCUITFindBy(iOSClassChain= "(//XCUIElementTypeStaticText[@name='Asset Size:'])[1]")
    private static MobileElement mutualFundFirstFundSection;
    @iOSXCUITFindBy(id= "Regular")
    private static MobileElement mutualFundDetailPage;
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeStaticText[contains(@name,'₹ ')]")
    private static MobileElement mutualFundDetailPageRupees;
    @iOSXCUITFindBy(id= "Benchmark")
    private static MobileElement mutualFundDetailBenchmark;
    @iOSXCUITFindBy(id= "Dividend")
    private static MobileElement mutualFundDetailDividend;
    @iOSXCUITFindBy(id= "Category")
    private static MobileElement mutualFundDetailCategory;
    @iOSXCUITFindBy(id= "Launch Date")
    private static MobileElement mutualFundDetailLaunchDate;
    @iOSXCUITFindBy(id= "Minimum SIP")
    private static MobileElement mutualFundDetailMinimumSIP;
    @iOSXCUITFindBy(id= "Expense Ratio")
    private static MobileElement mutualFundDetailExpenseRatio;


    public MarketPage() {
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
    public boolean checkTopGainersViewAll() {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAll() {
        return false;
    }

    @Override
    public boolean checkMostActByVolViewAll() {
        return false;
    }

    @Override
    public boolean checkSnPBseMidcapStockTable(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeMarketDashbaord(String Link, String Color, String URI, String Companies) {
        return false;
    }

    @Override
    public boolean checkTopGainerMarketDashbaord(String Link, String Color, String URI, String Gainers) {
        return false;
    }

    @Override
    public boolean checkTopLoserMarketDashbaord(String Link, String Color, String URI, String Losers) {
        return false;
    }

    @Override
    public boolean checkStockTableNiftyBank(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkStockTableBseSensex(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkStockTableBseSensexViewAll(String Link, String Header, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkStockTableBseSensexViewAllAmp(String Link, String Header, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesPageAmp(String Link) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesTable(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAll(String Link, String Header, String URI, String ID, String URL) {
        return false;
    }

    @Override
    public boolean checkNiftyBankStocksViewAll(String Link, String Link1, String Header, String URI, String ID, String URL, String stocks) {
        return false;
    }

    @Override
    public boolean checkStockNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnBseSensex(String Link, String Header, String URI, String ID, String URL) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnNiftyBank(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnBseMidcap(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAllBseMidcap(String Link, String Header, String URI, String ID, String stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAllNiftyBank(String Link, String Header, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAllOnBseSensex(String Link, String Amp, String Header, String URI, String ID, String Stocks, String ampURL, String webURL, String url3) {
        return false;
    }

    @Override
    public boolean checkStocksTableOnIndicePage(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkStocksTableOnIndicePageAMP(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkMarketsTopNaV(String Link, String Link2) {
        return false;
    }

    @Override
    public boolean checkSubscribeBannerForYouPage(String Link, String Link2, String Name) {
        return false;
    }

    @Override
    public boolean checkMaketPageScroll(String Link, String Page) {
        return false;
    }

    @Override
    public boolean checkIndicesDetails(String Link, String URI, String ID) {
        return false;
    }

    @Override
    public boolean checkLeftNavOnMarketPage() {
        return false;
    }

    @Override
    public boolean checkTopNavOnMarketPageSubscribedUser() {
        return false;
    }

    @Override
    public boolean checkMarketPageLayout() {
        return false;
    }

    @Override
    public boolean checkMarketPageMastHeadAd() {
        return false;
    }

    @Override
    public boolean checkNewsSectionInExplore() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        return false;
    }

    @Override
    public boolean checkNiftyBankGraph(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkGraphOnIndianIndicesPage(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkGraphOnNifty50Page(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkGraphOnBseSensexPage(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAll(String Link, String amp) {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAll(String Link, String amp) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        commonFunctions.clickElement(viewAllMarketPage, 10, "view all");
        commonFunctions.isElementDisplayed(indianIndicesPage, 10, "indian Indices Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnIndianIndicesPage, 10, "list Of Element On Indian Indices Page");
        return isShowing;
    }

    @Override
    public boolean checkGainerLosersDesign(String gainerLoserText) {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.isElementDisplayed(gainersLoserUpdateStatus, 10, "update status Gainer & Losers");
        isShowing &= commonFunctions.isElementDisplayed(gainersLoserBseTab, 10, "Bse Tab");
        isShowing &= commonFunctions.isElementDisplayed(gainersLoserNseTab, 10, "Nse Tab");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.swipeElementUsingTouchAction(360, 318, 50, 277);
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnGainerLoserSection, 30, "list Of company On top Losers and Top Gainers Page");
        return isShowing;
    }

    @Override
    public boolean checkBseTabsGainerLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.clickElement(gainersLoserBseTab, 10, "Bse tab");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnGainerLoserSection, 30, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkNseTabsGainerLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.clickElement(gainersLoserNseTab, 10, "Nse tab");
        commonFunctions.swipeElementUsingTouchAction(360, 318, 50, 277);
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnGainerLoserSection, 30, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkTopLosersViewAllFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.swipeElementUsingTouchAction(360, 318, 50, 277);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topLoserViewAll, "top losers view all");
        commonFunctions.clickElement(topLoserViewAll, 10, "Top Losers View All");
        isShowing &= commonFunctions.isElementDisplayed(topLoserDetailPage, 10, "top Losers Detail Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnTopLosersPage, 10, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkTopGainersViewAllFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerViewAll, "top gainer view all");
        commonFunctions.clickElement(topGainerViewAll, 10, "top gainers View All");
        commonFunctions.isElementDisplayed(topGainerDetailPage, 10, "top Gainer Detail Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnTopGainersPage, 10, "list Of company On top Losers and Top Gainers Page");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesList() {
        boolean isShowing;
        isShowing = checkTickerStockMarketNiftyAndSenSex();
        isShowing &= commonFunctions.isElementDisplayed(firstIndianIndices, 10, "first indian indices");
        isShowing &= commonFunctions.isElementDisplayed(secondIndianIndices, 10, "second indian indices");
        isShowing &= commonFunctions.isElementDisplayed(thirdIndianIndices, 10, "third indian indices");
        isShowing &= commonFunctions.isElementDisplayed(fourthIndianIndices, 10, "fourth indian indices");
        commonFunctions.clickElement(viewAllMarketPage, 10, "viewAll indian indices section");
        isShowing &= commonFunctions.isElementDisplayed(indianIndicesPage, 10, "indian Indices Page");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnIndianIndicesPage, 10, "list Of company On top Losers and Top Gainers Page");
        return isShowing;
    }

    public boolean clickOnMarketTabAndVerifyMarketPage() {
        commonFunctions.clickElement(marketTab, 10, "market tab");
        return commonFunctions.isElementDisplayed(marketTickerPage, 10, "market ticker Page");
    }

    @Override
    public boolean checkIndicesSection() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(secondIndianIndices, 10, "second indian indices name");
        isShowing &= commonFunctions.isElementDisplayed(priceChangeInPercentage, 10, "price Change In Percentage");
        isShowing &= commonFunctions.isElementDisplayed(latestPrice, 10, "latest price");
        return isShowing;
    }

    @Override
    public boolean checkNseTop4GainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesPage(String url) {
        return false;
    }

    @Override
    public boolean checkMarketDashboardPage(String url) {
        return false;
    }

    @Override
    public boolean checkMarketSnPBseMidcapLandingPage( ) {
        return false;
    }

    @Override
    public boolean checkMarketNifty50LandingPage(String url, String Header) {
        return false;
    }

    @Override
    public boolean checkMarketNifty50Graph(String[] params) {
        return false;
    }

    @Override
    public boolean checkSnPBseSensexGraph(String[] params) {
        return false;
    }

    @Override
    public boolean checkNiftyBankGraph(String[] params) {
        return false;
    }

    @Override
    public boolean checkSnPBseMidcapGraph(String[] params) {
        return false;
    }

    @Override
    public boolean checkMostActiveVolViewAll() {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAll(String[] params) {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAll(String[] params) {
        return false;
    }

    @Override
    public boolean checkMFDetailPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesGraph(String Link, String Color) {
        return false;
    }

    @Override
    public boolean checkBseTop4GainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkGainersAndLosers() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(gainerAndLosers, 10, "gainer and loser");
        isShowing &= commonFunctions.isElementDisplayed(gainerAndLosersBse, 10, "gainer and loser Bse");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainer, "top gainer");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topLoser, "top gainer");
        commonFunctions.clickElement(gainerAndLosersNse, 10, "gainer and loser Nse");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainer, "top gainer");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topLoser, "top gainer");
        return isShowing;
    }

    @Override
    public boolean checkBse100NewsSection() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(firstIndianIndices, 10, "first indian indices");
        String text = commonFunctions.getElementText(firstIndianIndices, 10);
        commonFunctions.clickElement(firstIndianIndices, 10, "first indian indices");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(secondIndianIndicesPage, text, 10, "second Indian Indices");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(NewsBse100, "News S&P Bse100");
        return isShowing;
    }

    @Override
    public boolean checkIndicesRedirectionFunctionality() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        String text1 = commonFunctions.getElementText(secondIndianIndices, 10);
        commonFunctions.clickElement(secondIndianIndices, 10, "second option Indian Indices");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(secondIndianIndicesPage, text1, 10, "second Indian Indices");
        isShowing &= commonFunctions.isElementDisplayed(fiveDOnIndicesPage, 10, "5D On Indices Page");
        isShowing &= commonFunctions.isElementDisplayed(oneMOnIndicesPage, 10, "1M On Indices Page");
        isShowing &= commonFunctions.isElementDisplayed(oneYOnIndicesPage, 10, "1Y On Indices Page");
        isShowing &= commonFunctions.isElementDisplayed(fiveYOnIndicesPage, 10, "5Y On Indices Page");
        return isShowing;
    }

    @Override
    public boolean checkTickerStockMarketNiftyAndSenSex() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(marketTickerPageNiftyBank, 10, "market ticker Page Nifty Bank");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerPageSensex, 10, "market ticker Page SenSex");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailLineGraph() {
        return false;
    }

    @Override
    public boolean checkDetailPageOfNseAndBse() {
        return false;
    }

    @Override
    public boolean checkMarketTickerNiftyBankDetailPage() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnNiftyAndCheckDetailPage();
        commonFunctions.clickElement(backButton, 10, "back to market page");
        return isShowing;
    }

    private boolean clickOnNiftyAndCheckDetailPage() {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(marketTickerPageNiftyBank, 10, "market ticker Page Nifty Bank");
        commonFunctions.clickElement(marketTickerPageNiftyBank, 10, "Nifty bank category");
        isShowing &= commonFunctions.isElementDisplayed(marketTickerPageNiftyBankDetailPage, 10, "Nifty Bank detail Page");
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolume() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        int v1 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeFirstHighestLevel, 10));
        int v2 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeSecondHighestLevel, 10));
        int v3 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeThirdHighestLevel, 10));
        int v4 = Integer.parseInt(commonFunctions.getElementText(mostActiveByVolumeFourthHighestLevel, 10));
        if ((isShowing &= v1 > v2) && (v2 > v3) && (v3 > v4)) {
            isShowing &= true;
            Utils.logStepInfo(true, " most active by volume stock volume displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "most active by volume stock volume displayed *****failed*****");
        }
        isShowing = commonFunctions.compareWithSizeListOfElements(listOfElementOnMostActiveByVolumeSection, 4, "MostActiveByVolume list of 4 stock");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeUpdateStatus, 10, "update status");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeBseTab, 10, "BSE tab");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeNseTab, 10, "NSE tab");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeSecurity, 10, "security coloum");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeVol, 10, "volume coloum");
        isShowing &= commonFunctions.isElementDisplayed(mostActiveByVolumeChange, 10, "Change coloum");
        isShowing &= commonFunctions.compareWithSizeListOfElements(listOfElementOnMostActiveByVolumeSection, 4, "MostActiveByVolume list of 4 stock");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkMostActiveByVolumeViewAll() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        commonFunctions.clickElement(mostActiveByVolumeViewAll, 10, "view all");
        commonFunctions.isElementDisplayed(mostActiveByVolumeDetailPage, 10, "mostActiveByVolume Detail page");
        commonFunctions.compareWithSizeListOfElements(listOfCompanyOnMostActiveByVolumeDetailPage, 10, "list of stock company");
        int v1 = Integer.parseInt(commonFunctions.getElementText(firstCompanyVolumeOnMostActiveByVolumeDetailPage, 10));
        int v2 = Integer.parseInt(commonFunctions.getElementText(secondCompanyVolumeOnMostActiveByVolumeDetailPage, 10));
        int v3 = Integer.parseInt(commonFunctions.getElementText(thirdCompanyVolumeOnMostActiveByVolumeDetailPage, 10));
        if ((isShowing &= v1 > v2) && (v2 > v3)) {
            isShowing &= true;
            Utils.logStepInfo(true, " most active by volume stock volume in Descending order displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "most active by volume stock volume in Descending order displayed *****failed*****");
        }
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;

    }

    private boolean clickOnFirstCompanyMostByVolume() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        commonFunctions.clickElement(firstCompanyNameOnMostActiveByVolume, 10);
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolume, "most active by volume section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mostActiveByVolumeViewAll, "View All most active by volume section");
        String cName = commonFunctions.getElementText(firstCompanyNameOnMostActiveByVolume, 10);
        commonFunctions.clickElement(mostActiveByVolumeFirstHighestLevel, 10, "first stock company");
        isShowing &= checkDesignAndLineGraph(cName);
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkDesignAndLineGraph(String cName) {
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(companyShortNameOnMostActiveByVolumeDetailPage, 10, "company short name");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(companyFullNameOnMostActiveByVolumeDetailPage, cName, 10, "company Full name");
        isShowing &= commonFunctions.isElementDisplayed(stockPriceOnMostActiveByVolumeDetailPage, 10, "stock price on detail page");
        commonFunctions.clickElement(fiveDOnIndicesPage, 10, "5D On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneMOnIndicesPage, 10, "1M On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneYOnIndicesPage, 10, "1Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(fiveYOnIndicesPage, 10, "5Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageInfo() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyMostByVolume();
        isShowing &= checkCompanyInfo();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    public boolean checkCompanyInfo() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(companyInfoSection, "company Information section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoAboutSection, "company Information About section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoManagementSection, "company Information Management section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoManagementPlusButton, "company Information collapse button");
        commonFunctions.clickElement(companyInfoManagementPlusButton, 10, "company management plus collapse button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoManagementInDetail, "company management in Detail");
        commonFunctions.scrollUpUntilElementFound(companyInfoAboutPlusButton);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoAboutPlusButton, "company Information plus collapse button");
        commonFunctions.clickElement(companyInfoAboutPlusButton, 10, "company Information plus collapse button");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(companyInfoAboutInDetail, "company Information in Detail");
        return isShowing;
    }

    @Override
    public boolean checkFinancialStandalone() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyMostByVolume();
        isShowing &= checkFinancialSectionStandalone();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkFinancialSectionStandalone() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(finanicalSection, "financial section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dateDropDownSection, "dropdown year");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(incomeStatementSection, "income statement");
        commonFunctions.clickElement(incomeStatementSection, 10, "income Statement Section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(totalRevenueTag, "income related information");
        commonFunctions.scrollUpUntilElementFound(BalanceSheetSection);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(BalanceSheetSection, "Balance sheet");
        commonFunctions.clickElement(BalanceSheetSection, 10, "Balance sheet Section");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(cashTag, "Balance sheet related information");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPagePriceHistoryGainerLoser() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeBelowGainernLoser() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesSection() {
        return false;
    }

    @Override
    public boolean checkGainersAndLosersBelowIndianIndices() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPagePriceHistory() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyMostByVolume();
        isShowing &= checkPriceHistory();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkPriceHistory() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(previousCloseSection, "previous Close");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(openPriceSection, "open Price");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dayHighSection, "day High");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(dayLowSection, "day Low");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(Week52LowSection, "Week 52 Low");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(Week52HighSection, "Week 52 High");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(BidQuantitySection, "Bid Quantity");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(volumeSection, "volume");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageGainerLoser() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerFirstCompanyName, "gainer & loser first company name");
        String text = commonFunctions.getElementText(topGainerFirstCompanyName, 10);
        commonFunctions.clickElement(topGainerFirstCompanyName, 10, "top Gainer First Company Name");
        isShowing &= commonFunctions.checkElementText(FirstCompanyDetailNameGainerDetailPage, text, 10, "Company Detail Name on Gainer loser  Detail Page");
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean clickOnFirstCompanyGainerLoser() {
        boolean isShowing;
        isShowing = commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerFirstCompanyName, "top gainer first company name");
        commonFunctions.clickElement(topGainerFirstCompanyName, 10, "top Gainer First Company Name");
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageCompanyInfo() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= checkCompanyInfo();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserFinancialStandalone() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= checkFinancialSectionStandalone();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPagePriceHistory() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnFirstCompanyGainerLoser();
        isShowing &= checkPriceHistory();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageDesign() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(gainerAndLosers, "gainer & loser");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(topGainerFirstCompanyName, "gainer & loser first company name");
        String cName = commonFunctions.getElementText(topGainerFirstCompanyName, 10);
        commonFunctions.clickElement(topGainerFirstCompanyName, 10, "top Gainer First Company Name");
        isShowing &= checkDesignAndLineGraph(cName);
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageSpecificIndianIndices() {
        boolean isShowing;
        isShowing = checkIndicesRedirectionFunctionality();
        isShowing &= commonFunctions.isElementDisplayed(openPriceTagOnIndicesDetailPage, 10, "open price");
        isShowing &= commonFunctions.isElementDisplayed(preCloseTagOnIndicesDetailPage, 10, "pre close");
        isShowing &= commonFunctions.isElementDisplayed(dayHighTagOnIndicesDetailPage, 10, "day high");
        isShowing &= commonFunctions.isElementDisplayed(dayLowTagOnIndicesDetailPage, 10, "day low");
        isShowing &= commonFunctions.isElementDisplayed(week52HighTagOnIndicesDetailPage, 10, "52 week high tag");
        isShowing &= commonFunctions.isElementDisplayed(week52LowTagOnIndicesDetailPage, 10, "52 week low tag");
        isShowing &= checkDetailPage();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    private boolean checkDetailPage() {
        boolean isShowing;
        commonFunctions.isElementDisplayed(priceChangeInPercentageOnDetailPage, 10, "price in percentage");
        commonFunctions.isElementDisplayed(latestPriceOnDetailPage, 10, "latest price");
        commonFunctions.clickElement(fiveDOnIndicesPage, 10, "5D On Detail Page");
        isShowing = commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneMOnIndicesPage, 10, "1M On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(oneYOnIndicesPage, 10, "1Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        commonFunctions.clickElement(fiveYOnIndicesPage, 10, "5Y On Detail Page");
        isShowing &= commonFunctions.isElementDisplayed(lineGraph, 10, "line graph");
        return isShowing;
    }

    @Override
    public boolean checkTickerDetailPage() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= clickOnNiftyAndCheckDetailPage();
        isShowing &= commonFunctions.isElementDisplayed(openPriceTagOnIndicesDetailPage, 10, "open price");
        isShowing &= commonFunctions.isElementDisplayed(preCloseTagOnIndicesDetailPage, 10, "pre close");
        isShowing &= commonFunctions.isElementDisplayed(dayHighTagOnIndicesDetailPage, 10, "day high");
        isShowing &= commonFunctions.isElementDisplayed(dayLowTagOnIndicesDetailPage, 10, "day low");
        isShowing &= commonFunctions.isElementDisplayed(week52HighTagOnIndicesDetailPage, 10, "52 week high tag");
        isShowing &= commonFunctions.isElementDisplayed(week52LowTagOnIndicesDetailPage, 10, "52 week low tag");
        isShowing &= checkDetailPage();
        commonFunctions.clickElement(marketTicker, 10, "market ticker");
        commonFunctions.scrollToTopOniOSNative();
        return isShowing;
    }

    @Override
    public boolean checkTickerPriceAndPercentage() {
        boolean isShowing;
        isShowing = clickOnMarketTabAndVerifyMarketPage();
        isShowing &= commonFunctions.isElementDisplayed(niftyLatestChangesPrice, 10, "change price");
        isShowing &= commonFunctions.isElementDisplayed(niftyLatestChangesPriceInPercentage, 10, "price change percentage");
        return isShowing;
    }

    @Override
    public boolean checkMarket() {
        return clickOnMarketTabAndVerifyMarketPage();
    }

    @Override
    public boolean checkMutualFundsWidgetAndSubCategoryDropDown() {
        return false;

    }

    private boolean checkMarketPage() {
        commonFunctions.clickElement(marketTab, 10, "market tab");
        return commonFunctions.isElementDisplayed(marketTickerPage, 10, "market page");
    }

    @Override
    public boolean checkMutualFundWidgetTitle() {
        boolean isShowing= checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMF, "mutual fund widgets title");
        return isShowing;
    }

    @Override
    public boolean checkSubCategoryDropDown() {
        boolean isShowing= checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMFDropDown, "mutual fund DropDown");
        return isShowing;
    }

    @Override
    public boolean checkSubCategoryDefaultSection() {
        boolean isShowing;
        isShowing = checkMarketPage();
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMF, "mutual fund widgets");
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(mutualFundTPMFDropDown, "dropDown");
        String text1 = commonFunctions.getElementText(mutualFundTPMFDropDown, 10);
        if (text1 != null) {
            Utils.logStepInfo(true, "DropDown verified successfully");
            isShowing &= true;
        } else {
            Utils.logStepInfo(false, "DropDown ********verification failed *******");
            isShowing &= false;
        }
        return isShowing;
    }

    @Override
    public boolean checkMutualFundCategoryTabs() {
        return false;
    }

    @Override
    public boolean checkMutualFundDetailPage() {
        return false;
    }

    @Override
    public boolean checkDefaultSelectionCategoryTab() {
        return false;
    }

    @Override
    public boolean checkMutualFundListingPageTitle() {
        return false;
    }

    @Override
    public boolean checkMutualFundNavValue() {
        return false;
    }

    @Override
    public boolean checkMutualFundDetailPageTopSectionTitle() {
        return false;
    }

    @Override
    public boolean checkMutualFundStories() {
        return false;
    }

    @Override
    public boolean checkMutualFundReturnType() {
        return false;
    }

    @Override
    public boolean checkMutualFundReturnTable() {
        return false;
    }

    @Override
    public boolean checkTopHoldingSection() {
        return false;
    }

    @Override
    public boolean checkPortfolioSection() {
      commonFunctions.clickElement(marketTab);
      commonFunctions.scrollToBottomOniOSNative();
      return true;
    }

    @Override
    public boolean checkNavPriceGraph() {
        return false;
    }

    @Override
    public boolean checkLiveBlogPage(String Amp, String Link, String LinkAmp) {
        return false;
    }

    @Override
    public boolean checkLiveBlogLeadImagenCaption(String Amp, String Link, String LinkAmp) {
        return false;
    }

    @Override
    public boolean checkLiveBlogSocialnBookmarkIcons(String Amp) {
        return false;
    }

    @Override
    public boolean checkLiveBlogPageTitle(String Amp, String Link, String LinkAmp, String Title) {
        return false;
    }

    @Override
    public boolean checkSubCategoryAvailableOption() {
        return false;
    }

    @Override
    public boolean checkFundDetailPageAboutFund() {
        return false;
    }

    @Override
    public boolean CheckFundSectionDesign() {
        return false;
    }

    @Override
    public boolean checkMarketPageContent(String Amp) {
        return false;
    }

    @Override
    public boolean checkTopRightAdMarketPage() {
        return false;
    }

    @Override
    public boolean checkOpenAppInStory(String Amp) {
        return false;
    }

    @Override
    public boolean checkOpenAppSectionPage(String Amp) {
        return false;
    }

    @Override
    public boolean checkOpenAppSubSectionPage(String Amp) {
        return false;
    }

    @Override
    public boolean checkShareIconsPoliticsPage() {
        return false;
    }

    @Override
    public boolean checkMutualFundMaximumFundListing() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeDetailPageAndBackBtn() {
        return false;
    }

    @Override
    public boolean checkStockDetailPageL1Tab() {
        return false;
    }

    @Override
    public boolean checkStockTitleWithShareIcon() {
        return false;
    }

    @Override
    public boolean checkStockAddToWatchList() {
        return false;
    }

    @Override
    public boolean checkStockPrice() {
        return false;
    }

    @Override
    public boolean checkStockPriceBSENSE() {
        return false;
    }

    @Override
    public boolean checkStockPriceGraph() {
        return false;
    }

    @Override
    public boolean checkStockPriceRange() {
        return false;
    }

    @Override
    public boolean checkStockKeyMatrics() {
        return false;
    }

    @Override
    public boolean checkStockAnaysis() {
        return false;
    }

    @Override
    public boolean checkStockRiskMeter() {
        return false;
    }

    @Override
    public boolean checkStockRecos() {
        return false;
    }

    @Override
    public boolean checkStockForecast() {
        return false;
    }

    @Override
    public boolean checkStockFinancials() {
        return false;
    }

    @Override
    public boolean checkStockTechnical() {
        return false;
    }

    @Override
    public boolean checkStockPeersSection() {
        return false;
    }

    @Override
    public boolean checkStockAboutCompany() {
        return false;
    }

    @Override
    public boolean checkL1TabOverview() {
        return false;
    }

    @Override
    public boolean checkL1TabScrollable() {
        return false;
    }

    @Override
    public boolean checkNewsSectionOnDetailPage() {
        return false;
    }

    @Override
    public boolean checkTrendingStockLeftAndRightSwipeFunctionality() {
        return false;
    }

    @Override
    public boolean checkTrendingStocksMarketDashboard() {
        return false;
    }

    @Override
    public boolean checkTrendingGainerStockDetailPage() {
        return false;
    }

    @Override
    public boolean checkTrendingStocksWidgetTop3Loser() {
        return false;
    }

    @Override
    public boolean checkTrendingLoserStockDetailPage() {
        return false;
    }

    @Override
    public boolean checkHomeTrendingStocksWidget() {
        return false;
    }

    @Override
    public boolean checkTrendingStocksWidgetTop3Gainer() {
        return false;
    }

    @Override
    public boolean checkNewsDesignAndNewsCount() {
        return false;
    }

    @Override
    public boolean checkWatchlistViewStockAndToasterMassage(String expText) {
        return false;
    }

    @Override
    public boolean checkWatchlistNewsSectionNotDisplayed() {
        return false;
    }

    @Override
    public boolean checkWatchlistIconAndStocks() {
        return false;
    }
}

