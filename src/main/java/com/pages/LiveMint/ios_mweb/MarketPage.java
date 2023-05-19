package com.pages.LiveMint.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonMarketPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import com.utils.ApiValidation;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MarketPage extends CommonMarketPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsMobile;
    private static CommonFunctionsWebLM commonFunctionsWeb;
    private static ApiValidation apiValidation;
    private static CommonLoginPage loginPage;

    @FindBy(xpath = "//a[@title='Notification']/span")
    private static WebElement notificationBell;

    @FindBy(id = "noTCounter")
    private static WebElement notificationBadge;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static WebElement notificationHeading;

    @FindBy(id = "notification_new")
    private static WebElement notificationNew;

    @FindBy(xpath = "(//div[@class='tableBox'])[1]//a[@class='newlink']")
    private static List<WebElement> nifty50IndicesList;
    @FindBy(xpath = "//section[2]//ol/li[1]")
    private static List<WebElement> indianIndiceList;

    @FindBy(xpath = "(//div[@class='btnViewAll'])[2]")
    private static WebElement topLosersViewAll;
    @FindBy(xpath = "(//div[@class='btnViewAll'])[1]")
    private static WebElement topGainersViewAll;
    @FindBy(xpath = "(//div[@class='clearfix'])[3]")
    private static WebElement topGainersViewHeader;
    @FindBy(xpath = "//div[@id='NSEGainer']//a")
    private static List <WebElement> topGainersListing;
    @FindBy(xpath = "//div[@id='BSEGainer']")
    private static WebElement topGainersBseListing;
    @FindBy(xpath = "//div[@class='buttons fr']/a[2]")
    private static WebElement topGainersNse;
    @FindBy(xpath = "(//li[@class='noBorder'])[2]")
    private static WebElement topGainersNsePrice;
    @FindBy(xpath = "(//li[@class='noBorder'])[1]")
    private static WebElement topGainersNseCompany;



    @FindBy(xpath = "//section[2]//a[1]//li[1]")
    private static WebElement indianIndiceName;
    @FindBy(xpath = "//section[2]//a[1]//li[2]")
    private static WebElement indianIndicePnChange;
    @FindBy(xpath = "//li[text()='S&P BSE 500']")
    private static WebElement bse500Indice;
    @FindBy(xpath = "//h4[@class='cardheading']")
    private static WebElement bseSensexStockTableHeader;
    @FindBy(xpath = "//a[@class='btnViewAll analytics-readmore']")
    private static WebElement bse500TableViewAll;
    @FindBy(xpath = "//a[contains(@class,'anchorhover2 clearfix')]")
    private static List<WebElement> bseSensexAllStocksList;

    @FindBy(xpath = "//section[2]//a[1]//li[1]")
    private static WebElement niftyBankStock;
    @FindBy(xpath = "//section[2]//a[1]//li[2]")
    private static WebElement niftyBankStockPChange;
    @FindBy(xpath = "//ol[@class='up clearfix']")
    private static List<WebElement> expandedIndicesList;
    @FindBy(xpath = "//section[2]//h1")
    private static WebElement expandedIndianIndicesHeader;
    @FindBy(xpath = "//section[2]/div/a")
    private static WebElement indianIndicesViewAll;
    @FindBy(xpath = "(//a[@class='btnViewAll'])[1]")
    private static WebElement indianIndicesViewAllSensex;
    @FindBy(xpath = "(//div[@id='marketTicker']//ol)[4]")
    private static WebElement bseMidcapTicker;
    @FindBy(xpath = "//a[@class='newlink']")
    private static List<WebElement> indianIndList;
    @FindBy(xpath = "(//a[@class='newlink']//li[3])[1]")
    private static WebElement indianIndStockPercent;
    @FindBy(xpath = "(//a[@class='newlink']//li[2])[1]")
    private static WebElement indianIndStockPrice;
    @FindBy(xpath = "(//a[@class='newlink']//li[1])[1]")
    private static WebElement indianIndStock;
    @FindBy(xpath = "(//h2[@class='cardheading'])[1]")
    private static WebElement headerIndianIndices;
    @FindBy(xpath = "(//div[@id='marketTicker']//ol)[1]")
    private static WebElement bseSensexTicker;
    @FindBy(xpath = "(//div[@id='marketTicker']//ol)[2]")
    private static WebElement niftyFiftyTicker;
    @FindBy(id = "marketTicker")
    private static WebElement marketTicker;
    @FindBy(xpath = "(//ol[@class='slider'])[2]")
    private static WebElement marketTickerSnPBseMidcap;
    @FindBy(xpath = "(//h4[@class='cardheading'])[1]")
    private static WebElement BseSnPMidcap;
    @FindBy(xpath = "//h1[@class='cardheading delay']")
    private static WebElement BseSnPMidcapHead;
    @FindBy(xpath = "//a[@class='anchorhover2']")
    private static List<WebElement> BseSnPMidcapStocksList;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[1]")
    private static WebElement BseSnPMidcapCompany;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[2]")
    private static WebElement BseSnPMidcapCompanyPrice;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[3]")
    private static WebElement BseMidcapPnChange;
    @FindBy(xpath = "(//ol[@class='down clearfix'])")
    private static List<MobileElement> indicesStockList;
    @FindBy(xpath = "//li[text()='S&P BSE 100']")
    private static WebElement bse100;
    @FindBy(xpath = "(//div[@id='graphHolder'])")
    private static WebElement graphBse100;
    @FindBy(xpath = "(//div[@id='graphHolder'])[1]")
    private static WebElement graph;
    @FindBy(xpath = "//button[@id='1d']")
    private static WebElement button1D;
    @FindBy(xpath = "//button[@id='5d']")
    private static WebElement button5D;
    @FindBy(xpath = "(//*[@class='headline'])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//div/aside)[2]")
    private static WebElement iconsBox;
    @FindBy(id = "sectionp_politics")
    private static WebElement politics;

    @FindBy(xpath = "//button[@id='1m']")
    private static WebElement button1M;

    @FindBy(xpath = "//button[@id='1y']")
    private static WebElement button1Y;

    @FindBy(xpath = "//button[@id='5y']")
    private static WebElement button5Y;
    @FindBy(xpath = "//h1[@class='cardheading delay']")
    private static WebElement bse100PageHeader;
    @FindBy(xpath = "(//div[@id='marketTicker']//ol)[3]")
    private static WebElement niftyBankTicker;
    @FindBy(xpath = "(//a[contains(@class,'btnViewAll')])[2]")
    private static WebElement niftyBankViewAll;
    @FindBy(xpath = "//h1[@class='cardheading']")
    private static WebElement niftyBankPageHeader;
    @FindBy(xpath = "//section[4]/h4")
    private static WebElement niftyBankTableHeader;
    @FindBy(xpath = "//a[@class='anchorhover2']")
    private static List<WebElement> niftyBankStockList;
    @FindBy(xpath = "//section[4]//a[1]//li[1]")
    private static WebElement niftyBankStockName;
    @FindBy(xpath = "//section[4]//a[1]//li[2]")
    private static WebElement niftyBankStockPrice;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[3]")
    private static WebElement niftyBankStockPriceChange;

    @FindBy(xpath = "//button[@class='subscribe'][1]")
    private static WebElement doItLater;
    @FindBy(xpath = "//a[@id='fixedNav_foryou']")
    private static WebElement forYou;
    @FindBy(xpath = "//div[@class='offerMob']//a")
    private static WebElement subscribe;
    @FindBy(xpath = "//div[@class='offerMob']")
    private static WebElement offer;
    @FindBy(xpath = "(//a[@id='fixedNav_popular'])[1]")
    private static WebElement markets;
    @FindBy(xpath = "//div[@class='mobileAd']")
    private static WebElement headAdMarkets;
    @FindBy(xpath = "(//div[@class='listtostory clearfix'])[17]")
    private static WebElement marketsPageLStory;
    @FindBy(xpath = "(//div[@class='listtostory clearfix'])[28]")
    private static MobileElement marketsPage2Story;
    @FindBy(xpath = "//img[@id='headerMintLogo']")
    private static WebElement mintLogo;
    @FindBy(id = "hamburgerElement")
    private static WebElement explore;
    @FindBy(xpath = "//li[@id='sectionp_news']/a")
    private static WebElement news;
    @FindBy(xpath = "(//a[@href='/market'])[1]")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "(//section[contains(@class,'cardHolder')])[1]")
    private static WebElement marketsFirstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement marketsFirstHeadline;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement marketsSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement marketsSecondStory;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement liveBlogTitle;
    @FindBy(xpath = "//span[contains(@class,'dblock')]//img")
    private static WebElement firstImage;
    @FindBy(xpath = "((//aside[@class='fl'])[1]//a)[1]")
    private static WebElement firstStoryBookmark;
    @FindBy(xpath = "(//div[@onclick='share(this)'])[1]")
    private static WebElement firstStoryShare;
    @FindBy(xpath = "//div[@class='openinApp']")
    private static WebElement openApp;
    @FindBy(xpath = "(//div[@class='subnavArrow'])[1]")
    private static WebElement companiesDown;
    @FindBy(id = "sectionsub_companies_news")
    private static WebElement companiesNews;
    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getApp;
    @FindBy(xpath = "//a[contains(@class,'Signin')]")
    private static WebElement signIn;



    @FindBy(xpath = "(//aside[@class='fl'])[1]/a")
    private static List <WebElement> iconsList;

    @FindBy(xpath = "(//div[@class='subnavArrow'])[3]")
    private static WebElement expandMarkets;
    @FindBy(id = "sectionsub_markets_live blog")
    private static WebElement liveBlog;
    @FindBy(xpath = "(//h2[@class='headline'])[1]")
    private static WebElement blogHeadline;
    @FindBy(xpath = "(//h1[@class='headline'])[1]")
    private static WebElement blogOpenHeadline;
    @FindBy(xpath = "//figure[@data-vars-mediatype='image']")
    private static WebElement leadImage;
    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement caption;
    @FindBy(xpath = "//div[contains(@class,'bcrumb')]")
    private static WebElement breadcrumb;


    @FindBy(xpath = "//a[@class='btnSearch clearfix']")
    private static WebElement search;
    @FindBy(xpath = "(//a[@href='/notifications'])[2]")
    private static WebElement notification;
    @FindBy(xpath = "//span[@id='mobNavTab']/a[1]")
    private static WebElement epaperIcon;
    @FindBy(xpath = "(//div[@class='fr'])[1]")
    private static WebElement myAccount;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//div[@id='hamburgerElement']")
    private static WebElement exploreMenu;
    @FindBy(xpath = "//div[@id='topnav-myaccount']/a")
    private static WebElement MyAccount;
    @FindBy(xpath = "//a[@id='ePaperIconId']")
    private static WebElement iconEpaper;


    public MarketPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        loginPage = CommonLoginPage.getInstance();
        apiValidation = ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkIndianIndicesPage(String url) {
        commonFunctions.navigateToURL(url);
        boolean isShowing = commonFunctions.isElementDisplayedOfListOfElements(indicesStockList, "Indian Indices List");
        commonFunctions.scrollToTop();
        String Indice = commonFunctions.getElementText(bse100);
        isShowing &= commonFunctions.clickElementWithJS(bse100, 10, "BSE 100");
        isShowing &= commonFunctions.checkElementText(bse100PageHeader, Indice, 10, "BSE 100 Header");
        return isShowing;
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
        commonFunctions.navigateToURL(Link);

        commonFunctions.scrollToElementView(bse100, 10, "S&P BSE100");
        commonFunctions.clickElementWithJS(bse100, 10, "S&P BSE100");
        boolean isShowing = commonFunctions.scrollToElementView(graphBse100, 10, "S&P BSE100 graph");
        commonFunctions.scrollUp();
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "1D Graph");
        String Button1D = button1D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1D, "1D Button Highlighted");
        commonFunctions.clickElementWithJS(button5D, 10, "Button 5D");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "5D Graph");
        String Button5D = button5D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button5D, "5D Button Highlighted");
        commonFunctions.clickElementWithJS(button1M, 10, "Button 1M");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "1M Graph");
        String Button1M = button1M.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1M, "1M Button Highlighted");
        commonFunctions.clickElementWithJS(button1Y, 10, "Button 1Y");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "1Y Graph");
        String Button1Y = button1Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1Y, "1Y Button Highlighted");
        commonFunctions.clickElementWithJS(button5Y, 10, "Button 5Y");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "5Y Graph");
        String Button5Y = button5Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button5Y, "5Y Button Highlighted");
        return isShowing;
    }

    @Override
    public boolean checkBseTop4GainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkNseTop4GainersAndLosers() {
        return false;
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
//        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(marketTickerSnPBseMidcap, 10, "S&P BSE Midcap Ticker");
        commonFunctions.scrollToElementView(BseSnPMidcapHead, 10, "S&P BSE Midcap Stock Table Header");
        String Midcap = commonFunctions.getElementText(BseSnPMidcapHead);
        commonFunctions.scrollToElementView(BseSnPMidcap, 10, "S&P BSE Midcap Stock Table Header");
        boolean isShowing = commonFunctions.checkTextEquals(Midcap, Header, "S&P BSE Midcap Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String Name = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        isShowing &= commonFunctions.checkElementText(BseSnPMidcapCompany, Name, 10, "company name");
        String priceValue = String.valueOf(JsonPath.parse(response.getBody().asString()).read("$.[0].price").toString().trim());
        if (BseSnPMidcapCompanyPrice.getText().trim().replace(",", "").equals(priceValue)) {
            Utils.logStepInfo(true, "Company price verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Company price not verified !!!!");
        }
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PriceChange = String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
        String PriceChange1 = BseMidcapPnChange.getText().replace(" ", "").replace(",", "");
//        isShowing &= commonFunctions.checkTextEquals((PriceChange1.replace("\n", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StockList = BseSnPMidcapStocksList.size();
        System.out.println("Stocks in List are =" + StockList);
        for (int i = 0; i < StockList; i++) {
            isShowing &= commonFunctions.isElementClickable(BseSnPMidcapStocksList.get(i), 10, "Bse Midcap Stock List");
        }
        return isShowing;
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
//        commonFunctions.navigateToURL(Link);
        boolean isShowing = commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(niftyBankTableHeader, 10, "Nifty Bank Stock Table Header");
        if (niftyBankTableHeader.getText().trim().equals(Header)) {
            Utils.logStepInfo(true, "Nifty Bank Table Header verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Nifty Bank Table Header verification Failed!!!");
        }
        ;
        int StocksList = niftyBankStockList.size();
        if (String.valueOf(StocksList).trim().equals(Stocks)) {
            Utils.logStepInfo(true, "Nifty Bank Stock list verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Nifty Bank Stock list verification Failed!!!");
        }
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStockName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = niftyBankStockPrice.getText();
//        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Price).trim(), CompanyPrice, "Company Price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PercentChange = String.valueOf(Pchange).trim() + " (" + String.valueOf(Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(niftyBankStockPriceChange);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Stocks1 = niftyBankStockList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Stocks1), Stocks, "Stocks are 6");
        for (int i = 0; i < StocksList; i++) {
            isShowing &= commonFunctions.isElementClickable(niftyBankStockList.get(i), 10, "Bse Sensex Stock List");
        }
        return isShowing;
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
        commonFunctions.navigateToURL(Link);
        commonFunctions.scrollToElementView(indianIndicesViewAll, 10, "Indian Indices View All");
        boolean isShowing = commonFunctions.clickElementWithJS(indianIndicesViewAll, 10, "Indian Indices View All");
        if ((commonFunctions.getCurrentURL().equals(URL))) {
            Utils.logStepInfo(true, "Indian Indices View ALl Functionality verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Indian Indices View ALl Functionality verification Failed!!!");
        }
        isShowing &= commonFunctions.checkElementText(expandedIndianIndicesHeader, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndiceName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChange = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
        String PriceChange1 = indianIndicePnChange.getText().replace(" ", "").replace("\n", "");
        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), PriceChange.replace(".", "").trim(), "Company Price");
        int StocksList = indianIndiceList.size();
        System.out.println("Indian Indices diplayed are =" + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkNiftyBankStocksViewAll(String Link, String Link1, String Header, String URI, String ID, String URL, String Stocks) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(niftyBankViewAll, 10, "Nifty Bank Stocks View All");
        boolean isShowing = commonFunctions.clickElementWithJS(niftyBankViewAll, 10, "Nifty Bank Stocks View All");
        if ((commonFunctions.getCurrentURL().equals(URL))) {
            Utils.logStepInfo(true, "Nifty Bank Stocks View All Functionality verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Nifty Bank Stocks View All Functionality verification Failed!!!");
        }
        isShowing &= commonFunctions.checkElementText(niftyBankPageHeader, Header, 10, "Nifty Bank Stocks Page Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStock.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PriceChange = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
        String PriceChange1 = niftyBankStockPChange.getText().replace(" ", "").replace("\n", "");
        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StocksList = indianIndiceList.size();
        commonFunctions.checkTextEquals(Stocks, String.valueOf(StocksList), "Stocks in List are 12");
        return isShowing;
    }

    @Override
    public boolean checkStockNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkIndianIndicesOnBseSensex(String Link, String Header, String URI, String ID, String URL) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(bseSensexTicker, 10, "BSE Sensex Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(headerIndianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = indianIndStockPrice.getText();
        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        System.out.println("Total no of indices in list are " + String.valueOf(+Indices));
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndList.get(i), 10, "Indian Indices On Bse Sensex Stock List");
        }
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensex, 10, "Indian Indices View All");
        String URL1 = commonFunctions.getCurrentURL();
        isShowing &= commonFunctions.checkTextEquals(URL, URL1, "Indian Indices View all redirection");
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesOnNiftyBank(String Link, String Header, String URI, String ID, String Stocks) {
//        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndList.get(i), 10, "Indian Indices On Bse Sensex Stock List");
        }
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesOnBseMidcap(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(bseMidcapTicker, 10, "Bse Midcap Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = indianIndStockPrice.getText();
        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();

        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(indianIndList.get(i), 10, "Indian Indices Stock List");
        }
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesOnNifty50(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(niftyFiftyTicker, 10, "Nifty Fifty Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 10, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = indianIndStockPrice.getText();
        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = nifty50IndicesList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(nifty50IndicesList.get(i), 10, "Indian Indices Stock List");
        }
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllBseMidcap(String Link, String Header, String URI, String ID, String stocks) {
//        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(bseMidcapTicker, 10, "Bse Midcap Ticker");
        commonFunctions.scrollToElementView(indianIndicesViewAllSensex, 20, "Indices View All");
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensex, 20, "Indices View All");
        boolean isShowing = commonFunctions.isElementDisplayed(expandedIndianIndicesHeader, 10, "Indian Indices page Header");
        isShowing &= commonFunctions.checkElementText(expandedIndianIndicesHeader, Header, 20, "Indices Header Verified");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndiceName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChange = Price.trim() + Pchange.trim() + "(" + Percent.trim() + "%)";
        String PriceChange1 = indianIndicePnChange.getText().replace(" ", "").replace("\n", "");
//        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        String StocksList = String.valueOf(indianIndiceList.size());
        isShowing &= commonFunctions.checkTextEquals("110", StocksList, "No. of Indices are 110.");
        System.out.println("Total no.of Indices in list are " + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllNiftyBank(String Link, String Header, String URI, String ID) {
//        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Indices Header");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElementView(indianIndicesViewAllSensex, 10, "Indices View All");
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensex, 10, "Indices View All");
        boolean isShowing = commonFunctions.isElementDisplayed(expandedIndianIndicesHeader, 10, "Indian Indices page Header");
        isShowing &= commonFunctions.checkElementText(expandedIndianIndicesHeader, Header, 10, "Indices Header Verified");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = niftyBankStock.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChange = Price.trim() + Pchange.trim() + "(" + Percent.trim() + "%)";
        String PriceChange1 = niftyBankStockPChange.getText().replace(" ", "").replace("\n", "");
//        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StocksList = expandedIndicesList.size();
        System.out.println("Total no.of Indices in list are " + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllOnBseSensex(String Link, String Amp, String Header, String URI, String ID, String Stocks, String ampURL, String webURL, String url3) {
//        commonFunctions.navigateToURL(globalVars.getURL() + Link);
        commonFunctions.clickElementWithJS(bseSensexTicker, 10, "BSE Sensex Ticker");
        commonFunctions.scrollToElementView(headerIndianIndices, 10, "Header Indian Indices");
        boolean isShowing = commonFunctions.checkElementText(headerIndianIndices, Header, 20, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextContains((CompanyPrice.replace(",", "").replace(".", "")), ((Price).replace(".", "").trim()), "Company Price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextContains(PercentChange, Changepercent, "Company Price");
        int Indices = indianIndList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensex, 10, "View All Indices");
        commonFunctions.dummyWait(5);
        String URL1 = commonFunctions.getCurrentURL();
        isShowing &= commonFunctions.checkTextEquals(URL1, webURL, "View All page Url Verified");
        return isShowing;
    }

    @Override
    public boolean checkStocksTableOnIndicePage(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURL(Link);
        boolean isShowing = commonFunctions.clickElementWithJS(bse500Indice, 10, "BSE 500 Indice");
        commonFunctions.scrollToElementView(bseSensexStockTableHeader, 10, "Header BSE 500 Stocks Table");
        isShowing &= commonFunctions.checkElementText(bseSensexStockTableHeader, Header, 20, "BSE 500 Stocks Header");
        commonFunctions.scrollToElementView(bse500TableViewAll, 10, "BSE 500 Stocks Table View All");
        commonFunctions.clickElementWithJS(bse500TableViewAll, 10, "BSE 500 Indice Table View All");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PriceChange = String.valueOf(Price).trim() + String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
        String PriceChange1 = niftyBankStockPChange.getText().replace(" ", "").replace("\n", "").replace(",", "").replace("+", "").replace("-", "");
//        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StocksList = bseSensexAllStocksList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(StocksList), Stocks, "Stock List is 100");
        for (int i = 0; i < StocksList; i++) {
            isShowing &= commonFunctions.isElementClickable(bseSensexAllStocksList.get(i), 10, "Bse 500 Stocks List");
        }
        return isShowing;
    }

    @Override
    public boolean checkStocksTableOnIndicePageAMP(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkMarketsTopNaV(String Link, String Link2) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(mintLogo, 10, "mint logo");
        commonFunctions.clickElementWithJS(exploreMenu, 10, "Click on Exp");
        if (commonFunctions.isElementDisplayedAndPresent(MyAccount, 20, "My account")) {
            loginPage.logout();
        }else {
            commonFunctions.pageRefresh();
        }
        boolean isShowing =commonFunctionsMobile.checkMarketsTopNav(markets, mintLogo, explore, getApp, iconEpaper, signIn);
        return isShowing;
    }

    @Override
    public boolean checkSubscribeBannerForYouPage(String Link, String Link2, String Name) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "I'll Do this Later Popup");
        boolean isShowing = commonFunctions.clickElement(forYou, 10, "For You Link");
        String Subscribe = commonFunctions.getElementText(subscribe).trim();
        isShowing &= commonFunctions.checkTextEquals(Subscribe, Name, "Subscribe Banner");
        isShowing &= commonFunctions.isElementDisplayed(offer, 10, "For you subscibe offer");
        String Offer = commonFunctions.getElementText(offer);
        System.out.println(Offer);
        return isShowing;
    }

    @Override
    public boolean checkMaketPageScroll(String Link, String Page) {
        boolean isShowing = commonFunctions.clickElement(markets, 10, "Markets Section");
        commonFunctions.scrollToElementView(marketsPageLStory, 15, "Last story on Page 1");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(marketsPage2Story);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownOnce();
        isShowing &= commonFunctions.checkPageUrlContainsText(Page, 10, "Page 2");
        return isShowing;
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
        boolean isShowing = commonFunctions.clickElementWithJS(markets, 10, "Markets Section");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(mintLogo, 20, "Mint Logo");
        isShowing &= commonFunctions.isElementDisplayed(epaperIcon, 10, "Epaper");
        isShowing &= commonFunctions.isElementDisplayed(myAccount, 10, "MyAccount");
        isShowing &= commonFunctions.isElementDisplayed(explore, 10, "Explore");
        isShowing &= commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &= commonFunctions.isElementDisplayed(search, 10, "Search");
        isShowing &= commonFunctions.isElementDisplayed(notification, 10, "Notification Bell");
        return isShowing;
    }

    @Override
    public boolean checkMarketPageLayout() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        commonFunctions.clickElementWithJS(explore, 10, "Explore");
        boolean isShowing = commonFunctions.clickElementWithJS(exploreMarkets, 10, "Markets");
        isShowing &= commonFunctions.isElementDisplayed(marketsFirstStory, 10, "First Story");
        String Headline = commonFunctions.getElementText(marketsFirstStory);
        String Header = commonFunctions.getElementText(marketsFirstHeadline);
        isShowing &= commonFunctions.checkTextContains(Header, Headline, "First Story verified card view");
        isShowing &= commonFunctions.isElementDisplayed(marketsSecondStory, 10, "Second Story");
        String Headline1 = commonFunctions.getElementText(marketsSecondStory);
        String Heading = commonFunctions.getElementText(marketsSecondHeadline);
        isShowing &= commonFunctions.checkTextContains(Heading, Headline1, "Second Story verified list view");
        return isShowing;
    }

    @Override
    public boolean checkMarketPageMastHeadAd() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        commonFunctions.clickElementWithJS(mintLogo, 10, "mint logo");
        commonFunctions.clickElementWithJS(exploreMenu, 10, "Click on Exp");
        if (commonFunctions.isElementDisplayedAndPresent(MyAccount, 20, "My account")) {
            loginPage.logout();
        }else {
            commonFunctions.pageRefresh();
        }
        boolean isShowing = commonFunctions.clickElementWithJS(markets, 10, "Markets Section");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(headAdMarkets, 10, "Mast Head Ad on Markets Page");
        return isShowing;
    }


    @Override
    public boolean checkNewsSectionInExplore() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing = commonFunctions.clickElement(explore, 10, "Explore menu");
        commonFunctions.dummyWait(5);
        isShowing &= commonFunctions.isElementDisplayed(news, 10, "News section in explore menu");
        return isShowing;
    }


    @Override
    public boolean checkNiftyBankGraph(String Link, String Color) {
        commonFunctions.navigateToURL(globalVars.getURL() + Link);
        commonFunctions.scrollToElementView(niftyBankTicker, 10, "Nifty Bank Ticker");
        boolean isShowing = commonFunctions.clickElementWithJS(niftyBankTicker, 10, "Nifty Bank Ticker");
        checkGraphButtonsHighlight(Color);
        return isShowing;
    }

    private boolean checkGraphButtonsHighlight(String Color) {
        boolean isShowing = commonFunctions.scrollToElementView(graphBse100, 10, "Graph");
        commonFunctions.scrollUp();
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "1D Graph");
        String Button1D = button1D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1D, "1D Button Highlighted");
        commonFunctions.clickElementWithJS(button5D, 10, "Button 5D");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "5D Graph");
        String Button5D = button5D.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button5D, "5D Button Highlighted");
        commonFunctions.clickElementWithJS(button1M, 10, "Button 1M");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "1M Graph");
        String Button1M = button1M.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1M, "1M Button Highlighted");
        commonFunctions.clickElementWithJS(button1Y, 10, "Button 1Y");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "1Y Graph");
        String Button1Y = button1Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button1Y, "1Y Button Highlighted");
        commonFunctions.clickElementWithJS(button5Y, 10, "Button 5Y");
        isShowing &= commonFunctions.isElementDisplayed(graph, 10, "5Y Graph");
        String Button5Y = button5Y.getCssValue("background-color");
        isShowing &= commonFunctions.checkTextEquals(Color, Button5Y, "5Y Button Highlighted");
        return isShowing;
    }

    @Override
    public boolean checkCompanyDetailPageRelatedNewsListing() {
        return false;
    }

    @Override
    public boolean checkGraphOnIndianIndicesPage(String Link, String Color) {

        commonFunctions.navigateToURL(globalVars.getURL() + Link);
        commonFunctions.scrollToElementView(bse100, 10, "S&P BSE100");
        boolean isShowing =commonFunctions.clickElementWithJS(bse100, 10, "S&P BSE100");
        isShowing &= checkGraphButtonsHighlight(Color);
        return isShowing;
    }

    @Override
    public boolean checkGraphOnNifty50Page(String Link, String Color) {
        boolean isShowing =commonFunctions.checkGraphOnPage(bseSensexTicker, Link);
        commonFunctions.clickElementWithJS(niftyFiftyTicker, 10, "Ticker");
        isShowing &= checkGraphButtonsHighlight(Color);
        return isShowing;
    }


    @Override
    public boolean checkGraphOnBseSensexPage(String Link, String Color) {
        boolean isShowing= commonFunctions.checkGraphOnPage(bseSensexTicker, Link);
        commonFunctions.clickElementWithJS(bseSensexTicker, 10, "Ticker");
        isShowing &= checkGraphButtonsHighlight(Color);
        return isShowing;
    }


    @Override
    public boolean checkTopGainersViewAll(String Link, String amp) {
        boolean isShowing=commonFunctions.checkTopGainersViewAll(topGainersListing, topGainersViewAll, topGainersViewHeader, topGainersBseListing, topGainersNse, topGainersNseCompany, topGainersNsePrice, Link);
        return isShowing;
    }

    @Override
    public boolean checkTopLosersViewAll(String Link, String amp) {
        boolean isShowing=commonFunctions.checkTopLosersViewAll(topGainersListing, topLosersViewAll, topGainersViewHeader, topGainersBseListing, topGainersNse, topGainersNseCompany, topGainersNsePrice, Link);
        return isShowing;
    }

    @Override
    public boolean checkTickerStockMarketNiftyAndSenSex() {
        return false;
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
        return false;
    }

    @Override
    public boolean checkIndicesRedirectionFunctionality() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesViewAll() {
        return false;
    }

    @Override
    public boolean checkGainersAndLosers() {
        return false;
    }

    @Override
    public boolean checkIndianIndicesList() {
        return false;
    }

    @Override
    public boolean checkIndicesSection() {
        return false;
    }

    @Override
    public boolean checkBse100NewsSection() {
        return false;
    }

    @Override
    public boolean checkTopGainersViewAllFunctionality() {
        return false;
    }

    @Override
    public boolean checkTopLosersViewAllFunctionality() {
        return false;
    }

    @Override
    public boolean checkBseTabsGainerLosers() {
        return false;
    }

    @Override
    public boolean checkNseTabsGainerLosers() {
        return false;
    }

    @Override
    public boolean checkGainerLosersDesign(String gainerLoserText) {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolume() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeDesign() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageDesign() {
        return false;
    }

    @Override
    public boolean checkMostActiveByVolumeViewAll() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageInfo() {
        return false;
    }

    @Override
    public boolean checkFinancialStandalone() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPagePriceHistory() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageGainerLoser() {
        return false;
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
    public boolean checkGainerLoserCompanyDetailPageCompanyInfo() {
        return false;
    }

    @Override
    public boolean checkGainerLoserFinancialStandalone() {
        return false;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPagePriceHistory() {
        return false;
    }

    @Override
    public boolean checkGainerLoserCompanyDetailPageDesign() {
        return false;
    }

    @Override
    public boolean checkCompanyDetailPageSpecificIndianIndices() {
        return false;
    }

    @Override
    public boolean checkTickerDetailPage() {
        return false;
    }

    @Override
    public boolean checkTickerPriceAndPercentage() {
        return false;
    }

    @Override
    public boolean checkMarket() {
        return false;
    }

    @Override
    public boolean checkMutualFundsWidgetAndSubCategoryDropDown() {
        return false;
    }

    @Override
    public boolean checkMutualFundWidgetTitle() {
        return false;
    }

    @Override
    public boolean checkSubCategoryDropDown() {
        return false;
    }

    @Override
    public boolean checkSubCategoryDefaultSection() {
        return false;
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
        return false;
    }

    @Override
    public boolean checkNavPriceGraph() {
        return false;
    }


    @Override
    public boolean checkLiveBlogPage(String Amp, String Link, String LinkAmp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        commonFunctions.checkTextContains(Link, Page, "Page Url");
        commonFunctions.checkFirstLiveBlog(blogHeadline, blogOpenHeadline, liveBlog);
        return false;
    }

    @Override
    public boolean checkLiveBlogLeadImagenCaption(String Amp, String Link, String LinkAmp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        isShowing &=commonFunctions.checkTextContains(Link, Page, "Page Url");
        isShowing &=commonFunctions.checkFirstLiveBlog(blogHeadline, blogOpenHeadline, liveBlog);
        isShowing &=commonFunctions.checkLiveBlogImagenCaption(leadImage, caption);
        return isShowing;
    }


    @Override
    public boolean checkLiveBlogSocialnBookmarkIcons(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        isShowing &=commonFunctions.checkLiveBlogSocialIcons(iconsList);
        return isShowing;
    }

    @Override
    public boolean checkLiveBlogPageTitle(String Amp, String Link, String LinkAmp, String Title) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        isShowing &=commonFunctions.checkTextContains(Link, Page, "Page Url");
        isShowing &=commonFunctions.checkLiveBlogPageTitle(liveBlogTitle, Title);
        return isShowing;
    }

    @Override
    public boolean checkMarketPageContent(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctions.checkMarketPageContentMethod(markets, liveBlogTitle, firstImage, blogHeadline, breadcrumb, firstStoryBookmark, firstStoryShare);
        return isShowing;
    }

    @Override
    public boolean checkTopRightAdMarketPage() {
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
    public boolean checkOpenAppInStory(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsMobile.checkOpenAppStory(firstImage, openApp);
        return isShowing;
    }

    @Override
    public boolean checkOpenAppSectionPage(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsMobile.checkOpenAppSection(markets, openApp);
        return isShowing;
    }

    @Override
    public boolean checkOpenAppSubSectionPage(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsMobile.checkOpenAppSubSection(explore, companiesDown, companiesNews, openApp);
        return isShowing;
    }


    @Override
    public boolean checkShareIconsPoliticsPage() {
//        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsWeb.checkShareIconsPolitics(explore, politics, firstStory, iconsBox, iconsList);
        return isShowing;
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


