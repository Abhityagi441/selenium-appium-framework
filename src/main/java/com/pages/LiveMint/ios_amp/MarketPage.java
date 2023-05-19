package com.pages.LiveMint.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonMarketPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
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

    @FindBy(xpath = "//a[@title='Notification']/span")
    private static WebElement notificationBell;

    @FindBy(id = "noTCounter")
    private static WebElement notificationBadge;

    @FindBy(xpath = "//div[(text()='Notifications') and (@class='listheading')]")
    private static WebElement notificationHeading;

    @FindBy(id = "notification_new")
    private static WebElement notificationNew;

    @FindBy(xpath = "(//div[@class='btnViewAll'])[2]")
    private static WebElement topLosViewAll;
    @FindBy(xpath = "(//div[@class='btnViewAll'])[1]")
    private static WebElement topGainViewAll;
    @FindBy(xpath = "(//div[@class='clearfix'])[3]")
    private static WebElement topGainViewHeader;
    @FindBy(xpath = "//div[@id='NSEGainer']//a")
    private static List <WebElement> topGainListing;
    @FindBy(xpath = "//div[@id='BSEGainer']")
    private static WebElement topGainBseList;
    @FindBy(xpath = "//div[@class='buttons fr']/a[2]")
    private static WebElement topGainNse;
    @FindBy(xpath = "(//li[@class='noBorder'])[2]")
    private static WebElement topGainNsePrice;
    @FindBy(xpath = "(//a[@class='anchorhover2'])[1]")
    private static WebElement topGainNseCompany;


    @FindBy(xpath = "//div[@class='clearfix']//button")
    private static WebElement explore;
    @FindBy(xpath = "//a[@href='/amp-news']")
    private static WebElement news;
    @FindBy(xpath = "//a[@data-vars-event-label='/market']")
    private static WebElement exploreMarkets;
    @FindBy(xpath = "(//div[contains(@class,'listing')])[1]")
    private static WebElement marketsFirstStory;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement marketsFirstHeadline;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement liveBlogTitle;
    @FindBy(xpath = "//div[contains(@class,'bcrumb')]")
    private static WebElement breadcrumb;
    @FindBy(xpath = "(//a[@class='imgSec'])[1]")
    private static WebElement firstImage;
    @FindBy(xpath = "//div[@class='openinApp']")
    private static WebElement openApp;
    @FindBy(xpath = "(//h6[@role='button'])[1]")
    private static WebElement companiesDown;
    @FindBy(xpath = "(//a[@class='hamburgerTracking'])[3]")
    private static WebElement companiesNews;
    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getApp;
    @FindBy(xpath = "//a[@title='Sign In']")
    private static WebElement signIn;
    @FindBy(xpath = "//img[@title='mint']")
    private static WebElement mintLogo;
    @FindBy(xpath = "//a[@class='epaper2']")
    private static WebElement epaperIcon;

    @FindBy(xpath = "//button[@id='pushNotification']")
    private static WebElement doItLater;
    @FindBy(xpath = "//a[@id='fixedNav_foryou']")
    private static WebElement forYou;
    @FindBy(xpath = "//div[@class='offerMob']//a")
    private static WebElement subscribe;
    @FindBy(xpath = "//div[@class='offerMob']")
    private static WebElement offer;
    @FindBy(xpath = "(//a[@id='fixedNav_popular'])[1]")
    private static WebElement markets;
    @FindBy(xpath = "//div[@class='adHolder']")
    private static WebElement headAdMarkets;
    @FindBy(xpath = "//a[@class='btnAmp']")
    private static WebElement moreButton;


    @FindBy(xpath = "(//h6[@role='button'])[3]")
    private static WebElement expandMarkets;
    @FindBy(xpath = "//a[@href='/market/live-blog']")
    private static WebElement liveBlog;
    @FindBy(xpath = "(//h2[@class='headline'])[1]")
    private static WebElement blogHeadline;
    @FindBy(xpath = "(//h1[@class='headline'])[1]")
    private static WebElement blogOpenHeadline;
    @FindBy(xpath = "//span[@class='ampimgbox']")
    private static WebElement leadImage;
    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement caption;

    @FindBy(xpath = "(//div[@class='gSpecs'])")
    private static List <WebElement> iconsList;

    @FindBy(xpath = "//div[@class='share-icons-box']")
    private static WebElement iconsBox;

    @FindBy(xpath = "//a[@href='/amp-politics']")
    private static WebElement politics;
    @FindBy(xpath = "(//div[contains(@class,'listing clearfix')])[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//a[@class='imgSec'])[1]")
    private static WebElement firstStoryImg;

    @FindBy(xpath = "(//div[@class='tableBox'])[1]//li[@class='down']")
    private static List<WebElement> nifty50IndicesList;
    @FindBy(xpath = "//section[2]//ol/li[1]")
    private static List<WebElement> indianIndiceList;



    @FindBy(xpath = "//section[2]//a[1]//li[1]")
    private static WebElement indianIndiceName;
    @FindBy(xpath = "//section[2]//a[1]//li[2]")
    private static WebElement indianIndicePnChange;

    @FindBy(xpath = "//section[2]//h1")
    private static WebElement expandedIndianIndicesHeader;
    @FindBy(xpath = "//section[2]/div/a")
    private static WebElement indianIndicesViewAll;
    @FindBy(xpath = "(//a[@class='btnViewAll'])[1]")
    private static WebElement indianIndicesViewAllSensex;
    @FindBy(xpath = "//div[@class='cardheading']")
    private static WebElement headerIndndices;
    @FindBy(xpath = "(//h1[@class='cardheading'])[1]")
    private static WebElement headerIndiIndices;
    @FindBy(xpath = "(//strong)[7]")
    private static WebElement bseSensexViewAllCompany;
    @FindBy(xpath = "//a[1]//ol[1]/li[2]")
    private static WebElement bseSenVAllCompanyPricenChange;
    @FindBy(xpath = "//a[contains(@class,'anchorhover2')]")
    private static List<WebElement> bseSensexAllStocksList;
    @FindBy(xpath = "(//div[@id='marketTicker']//ol)[4]")
    private static WebElement bseMidcapTicker;
    @FindBy(xpath = "//a[@class='newlink']")
    private static List<WebElement> indianIndList;
    @FindBy(xpath = "//ul[@class='clearfix']/following-sibling::ul[@class='clearfix']")
    private static List<WebElement> ampIndicesList;
    @FindBy(xpath = "//section[@class='mainSec']//ul[2]//li[3]")
    private static WebElement indianIndStockPercent;
    @FindBy(xpath = "//section[@class='mainSec']//ul[2]//li[2]")
    private static WebElement indianIndStockPrice;
    @FindBy(xpath = "//section[@class='mainSec']//ul[2]//li[1]")
    private static WebElement indianIndStock;
    @FindBy(xpath = "//ol[1]//strong[1]//a[1]")
    private static WebElement indiceName;
    @FindBy(xpath = "//ol[1]/li[2]")
    private static WebElement indicePricenChange;
    @FindBy(xpath = "//ol[contains(@class,'clearfix')]")
    private static List<WebElement> ampExpandIndicesList;
    @FindBy(xpath = "(//div[@class='cardheading'])[1]")
    private static WebElement headerIndianIndices;
    @FindBy(xpath = "(//div[@id='marketTicker']//ol)[1]")
    private static WebElement bseSensexTicker;
    @FindBy(xpath = "(//div[@id='marketTicker']//ol)[2]")
    private static WebElement niftyFiftyTicker;
    @FindBy(id = "marketTicker")
    private static WebElement marketTicker;
    @FindBy(xpath = "(//ol[@class='slider'])[2]")
    private static WebElement marketTickerSnPBseMidcap;
    @FindBy(xpath = "(//div[@class='cardheading'])[2]")
    private static WebElement BseSnPMidcap;
    @FindBy(xpath = "//h1[@class='cardheading delay']")
    private static WebElement BseSnPMidcapHead;
    @FindBy(xpath = "//a[@class='anchorhover2']")
    private static List <WebElement> BseSnPMidcapStocksList;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[1]")
    private static WebElement BseSnPMidcapCompany;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[2]")
    private static WebElement BseSnPMidcapCompanyPrice;
    @FindBy(xpath = "//section[4]//a[1]/ul/li[3]")
    private static WebElement BseMidcapPnChange;
    @FindBy(xpath = "(//ol[@class='down clearfix'])")
    private static List<MobileElement> indicesStockList;
    @FindBy(xpath = "(//strong)[6]")
    private static WebElement bse100;
    @FindBy(xpath = "//h1[@class='cardheading delay']")
    private static WebElement bse100PageHeader;
    @FindBy(xpath = "//a[text()='S&P BSE 500']")
    private static WebElement bse500Indice;
    @FindBy(xpath = "//*[@class='cardheading delay']")
    private static WebElement bse500TableHeader;
    @FindBy(xpath = "(//a[@class='btnViewAll'])[2]")
    private static WebElement bse500TableViewAll;
    @FindBy(xpath = "//a[@class='anchorhover2']")
    private static List<WebElement> niftyBankStockList;
    @FindBy(xpath = "//section[2]//a[1]//li[1]")
    private static WebElement niftyBankStock;
    @FindBy(xpath = "//section[2]//a[1]//li[2]")
    private static WebElement niftyBankStockPChange;
    @FindBy(xpath = "(//a[contains(@class,'btnViewAll')])[2]")
    private static WebElement niftyBankViewAll;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;


    public MarketPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
        commonFunctionsWeb = CommonFunctionsWebLM.getInstance();
        apiValidation = ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
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
        commonFunctions.navigateToURL(Link);
        commonFunctions.scrollToElementView(BseSnPMidcap, 10, "S&P BSE Midcap Stock Table Header");
        boolean isShowing=BseSnPMidcap.getText().replace("Stocks", "").trim().replace(" Stocks", "").equalsIgnoreCase(Header);
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String dName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        isShowing &= commonFunctions.checkElementText(BseSnPMidcapCompany, dName, 10, "company name");
        String priceValue = JsonPath.parse(response.getBody().asString()).read("$.[0].price").toString().trim().replace(".0", "");
        String Price1=commonFunctions.getElementText(BseSnPMidcapCompanyPrice).trim().replace(",", "");
//        isShowing &= commonFunctions.checkTextEquals(Price1, priceValue, "Company Price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange").toString().trim();
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage").toString().trim();
        String PercentChange = Pchange.trim() + " (" + Percent.trim() + "%)";
        String Changepercent = commonFunctions.getElementText(BseMidcapPnChange);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int StockSize= niftyBankStockList.size();
        commonFunctions.checkTextEquals(Stocks, String.valueOf(StockSize), "No of Stocks are 6");
        for (int i = 0; i<StockSize; i++) {
            isShowing &= commonFunctions.isElementClickable(niftyBankStockList.get(i), 10, "Bse Midcap Stock List");
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
        commonFunctions.navigateToURL(Link);
        commonFunctions.scrollToElementView(bse500TableViewAll, 10, "S&P Bse Sensex Stock Table View All");
        commonFunctions.clickElementWithJS(bse500TableViewAll, 10, "S&P Bse Sensex Stock Table View All");
        boolean isShowing = commonFunctions.isElementDisplayed(headerIndndices, 10, "Sensex Page Header");
        commonFunctions.checkElementText(headerIndndices, Header, 10, "Sensex Page Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = bseSensexViewAllCompany.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        int Pchange1= Pchange.intValue();
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PriceChange = String.valueOf(Price) + " "+String.valueOf(Pchange1) +" "+ "(" +String.valueOf(Percent) + "%)";
        String PriceChange1 = bseSenVAllCompanyPricenChange.getText().replace("\n", " ").replace("+", "").replace(",", "");
        isShowing &= commonFunctions.checkTextContains((String.valueOf(PriceChange).replace(".", "").trim()), (PriceChange1.replace(",", "").replace(".", "")),"Company Price");
        int StocksList = bseSensexAllStocksList.size();
        System.out.println("Total Number BSE Sensex stocks in table are =" + StocksList);
        return isShowing;
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
    public boolean checkNiftyBankStocksViewAll(String Link, String Link1, String Header, String URI, String ID, String URL, String Stocks) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.scrollToElementView(niftyBankViewAll, 15, "Nifty Bank Stocks View All");
        boolean isShowing = commonFunctions.clickElementWithJS(niftyBankViewAll, 10, "Nifty Bank Stocks View All");
        commonFunctions.dummyWait(5);
        if ((isShowing &= commonFunctions.getCurrentURL().equals(URL))) {
            Utils.logStepInfo(true, "Nifty Bank Stocks View All Functionality verified successfully!!!");
        } else {
            Utils.logStepInfo(false, "Nifty Bank Stocks View All Functionality verification Failed!!!");
        }
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(headerIndiIndices, Header, 20, "View All Page Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStock.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PriceChange = String.valueOf(Price).trim() +String.valueOf(Pchange).trim() + "(" + String.valueOf(Percent).trim() + "%)";
        String PriceChange1 = niftyBankStockPChange.getText().replace(" ", "").replace("\n", "").replace("-", "").replace("+","");
//        isShowing &= commonFunctions.checkTextEquals((PriceChange1.replace(",", "").replace(".", "")), ((PriceChange).replace(".", "")), "Company Price");
        int StocksList = indianIndiceList.size();
        isShowing &= commonFunctions.checkTextEquals(Stocks, String.valueOf(StocksList), "Stocks in List are 12");
        return isShowing;
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
        commonFunctions.navigateToURL(Link);
        commonFunctions.scrollToElementView(headerIndianIndices, 20, "Indices Header");
        boolean isShowing=commonFunctions.checkElementText(headerIndianIndices, Header, 20, "Indices Header");
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
        int StockList= ampIndicesList.size();
        commonFunctions.checkTextEquals(Stocks, String.valueOf(StockList), "No. of Stocks in List are 8");
        int Indices = ampIndicesList.size();
        for (int i = 0; i < Indices; i++) {
            isShowing &= commonFunctions.isElementClickable(ampIndicesList.get(i), 10, "Indian Indices Stock List");
        }
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllBseMidcap(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.scrollToElementView(indianIndicesViewAllSensex, 20, "Indices View All");
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensex, 10, "Indices View All");
        boolean isShowing = commonFunctions.isElementDisplayed(headerIndiIndices, 15, "Indian Indices page Header");
        isShowing &= commonFunctions.checkElementText(headerIndiIndices, Header, 10, "Indices Header Verified");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indiceName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChange = Price.trim() + Pchange.trim() + "(" + Percent.trim() + "%)";
        String PriceChange1 = indicePricenChange.getText().replace(" ", "").replace("\n", "").replace("+", "").replace("-", "");
        isShowing &= commonFunctions.checkTextContains((PriceChange1.replace(",", "").replace(".", "")), (String.valueOf(PriceChange).replace(".", "").trim()), "Company Price");
        int StocksList = ampExpandIndicesList.size();
        isShowing &=commonFunctions.checkTextEquals(Stocks, String.valueOf(StocksList), "No of Stocks in List are 110");
        System.out.println("Total no.of Indices in list are " + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllNiftyBank(String Link, String Header, String URI, String ID) {
        commonFunctions.navigateToURL(Link);
        commonFunctions.scrollToElementView(indianIndicesViewAllSensex, 15, "Indices View All");
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensex, 15, "Indices View All");
        boolean isShowing = commonFunctions.isElementDisplayed(headerIndiIndices, 15, "Indian Indices page Header");
        isShowing &= commonFunctions.checkElementText(headerIndiIndices, Header, 10, "Indices Header Verified");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indiceName.getText();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PriceChange = (Price.trim() + Pchange.trim() + Percent.trim()).replaceAll("[^a-zA-Z0-9]", "");
        String PriceChange1 = indicePricenChange.getText().replaceAll("[^a-zA-Z0-9]", "");
//        isShowing &= commonFunctions.checkTextContains(PriceChange1, PriceChange, "Company Price");
        int StocksList = ampExpandIndicesList.size();
        System.out.println("Total no.of Indices in list are " + StocksList);
        return isShowing;
    }

    @Override
    public boolean checkIndianIndicesViewAllOnBseSensex(String Link, String Amp, String Header, String URI, String ID, String Stocks, String ampURL, String webURL, String url3) {
        commonFunctions.navigateToURL(Amp);
        commonFunctions.scrollToElementView(headerIndianIndices, 20, "Header Indian Indices");
        boolean isShowing = commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(headerIndianIndices, Header, 20, "Indian Indices Header");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indianIndStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String CompanyPrice = indianIndStockPrice.getText();
//        isShowing &= commonFunctions.checkTextEquals(CompanyPrice.replace(",", ""), ((Price).trim()), "Company Price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PercentChange = (Pchange).trim() + " (" + (Percent).trim() + "%)";
        String Changepercent = commonFunctions.getElementText(indianIndStockPercent);
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, Changepercent, "Company Price");
        int Indices = ampIndicesList.size();
        isShowing &= commonFunctions.checkTextEquals(String.valueOf(Indices), Stocks, "Total no. of Indices are 8");
        commonFunctions.scrollToElementView(indianIndicesViewAllSensex, 10, "View All Indices");
        commonFunctions.clickElementWithJS(indianIndicesViewAllSensex, 10, "View All Indices");
        commonFunctions.dummyWait(5);
        String URL1 =commonFunctions.getCurrentURL();
        isShowing &= commonFunctions.checkTextEquals(URL1, ampURL, "View All page Url Verified");
        return isShowing;
    }

    @Override
    public boolean checkStocksTableOnIndicePage(String Link, String Header, String URI, String ID, String Stocks) {
        return false;
    }

    @Override
    public boolean checkStocksTableOnIndicePageAMP(String Link, String Header, String URI, String ID, String Stocks) {
        commonFunctions.navigateToURL(Link);
        boolean isShowing = commonFunctions.clickElementWithJS(bse500Indice, 10, "BSE 500 Indice");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.checkElementText(bse500TableHeader, Header, 20, "Stocks Header");
        commonFunctions.scrollToElementView(bse500TableViewAll, 10, "BSE 500 Table View All");
        commonFunctions.clickElementWithJS(bse500TableViewAll, 10, "BSE 500 Indice Table View All");
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].displayName");
        String CompanyName = niftyBankStock.getText().trim();
        isShowing &= commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        Double Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        Double Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].priceChange");
        Double Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentage");
        String PriceChange = String.valueOf(Price).replace(".", "") + String.valueOf(Pchange).replace(".", "") + "(" + String.valueOf(Percent).replace(".", "") + "%)";
        String PriceChange1 = niftyBankStockPChange.getText().replace("\n", "").replace(",", "").replace(".", "").replace("+", "").replace("-", "");
//        isShowing &= commonFunctions.checkTextContains(PriceChange1.replace(" ", ""), PriceChange.replace(".", "").trim(), "Company Price");
        int StocksList =niftyBankStockList.size();
        isShowing &=commonFunctions.checkTextEquals(String.valueOf(StocksList), Stocks, "Stock List");
        for (int i = 0; i < StocksList; i++) {
            isShowing &= commonFunctions.isElementClickable(niftyBankStockList.get(i), 10, "Bse 500 Stocks List");
        }
        return isShowing;
    }

    @Override
    public boolean checkMarketsTopNaV(String Link, String Link2) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing=commonFunctionsMobile.checkMarketsTopNav(markets, mintLogo, explore, getApp, epaperIcon, signIn);
        return isShowing;
    }

    @Override
    public boolean checkSubscribeBannerForYouPage(String Link, String Link2, String Name) {
        commonFunctions.navigateToURL(Link2);
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "I'll Do this Later Popup");
        boolean isShowing=commonFunctions.clickElement(forYou, 10, "For You Link");
        String Subscribe=commonFunctions.getElementText(subscribe).trim();
        isShowing &= commonFunctions.checkTextEquals(Subscribe, Name, "Subscribe Banner");
        isShowing &=commonFunctions.isElementDisplayed(offer, 10, "For you subscibe offer");
        String Offer=commonFunctions.getElementText(offer);
        System.out.println(Offer);
        return isShowing;
    }

    @Override
    public boolean checkMaketPageScroll(String Link, String Page) {
        commonFunctions.navigateToURL(Link);
        boolean isShowing =commonFunctions.clickElement(markets, 10, "Markets Section");
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "Popup");
        commonFunctions.scrollToBottomWorked();
        commonFunctions.clickElementWithJS(moreButton, 15, "More Button for Page-2");
        commonFunctions.dummyWait(5);
        String Page2= commonFunctions.getCurrentURL();
        isShowing &= commonFunctions.checkTextContains(Page, Page2, "Page 2 Url");
        return isShowing;
    }

    @Override
    public boolean checkIndicesDetails(String Link, String URI, String ID) {
        commonFunctions.navigateToURL(Link);
        Response response = apiValidation.getResponseFromURI(URI, ID);
        String DName = JsonPath.parse(response.getBody().asString()).read("$.[0].name");
        String CompanyName = indiceName.getText().trim();
        boolean isShowing = commonFunctions.checkTextEquals(DName, CompanyName, "Company Name");
        String CompanyPrice = indicePricenChange.getText().replace("\n", "").replace(",", "").replace("+", "").replace("-", "");
        String Price = JsonPath.parse(response.getBody().asString()).read("$.[0].price");
        String Pchange = JsonPath.parse(response.getBody().asString()).read("$.[0].netChange");
        String Percent = JsonPath.parse(response.getBody().asString()).read("$.[0].percentChange");
        String PercentChange = (Price).trim()+(Pchange).trim() + " (" + (Percent).trim() + "%)";
//        isShowing &= commonFunctions.checkTextEquals(PercentChange, CompanyPrice, "Company Price and Change Percent");

        return isShowing;
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
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "DO it Later popup");
        commonFunctions.clickElementWithJS(explore, 10, "Explore");
        boolean isShowing= commonFunctions.clickElementWithJS(exploreMarkets, 10, "Markets");
        isShowing &=commonFunctions.isElementDisplayed(marketsFirstStory, 10, "First Story");
        String Headline= commonFunctions.getElementText(marketsFirstStory);
        String Header=commonFunctions.getElementText(marketsFirstHeadline);
        isShowing &=commonFunctions.checkTextContains(Header, Headline, "First Story verified list view");
        return isShowing;
    }


    @Override
    public boolean checkMarketPageMastHeadAd() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing= commonFunctions.clickElementWithJS(markets, 10, "Markets Section");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementDisplayed(headAdMarkets, 10, "Mast Head Ad on Markets Page");
        return isShowing;
    }

    @Override
    public boolean checkNewsSectionInExplore() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing= commonFunctions.clickElement(explore, 10, "Explore menu");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementDisplayed(news, 10, "News section in explore menu");
        return isShowing;
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
        commonFunctions.navigateToURL(globalVars.getURL()+amp);
        boolean isShowing= commonFunctions.checkTopLosersVAll(topGainViewHeader,topGainBseList,topGainNse,topGainNseCompany,topGainNsePrice);
        return isShowing;
    }

    @Override
    public boolean checkTopLosersViewAll(String Link, String amp) {
        commonFunctions.navigateToURL(globalVars.getURL()+amp);
        boolean isShowing= commonFunctions.checkTopLosersVAll(topGainViewHeader,topGainBseList,topGainNse,topGainNseCompany,topGainNsePrice);
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
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        commonFunctions.checkTextContains(LinkAmp, Page, "Page Url");
        commonFunctions.checkFirstLiveBlog(blogHeadline, blogOpenHeadline, liveBlog);
        return false;
    }

    @Override
    public boolean checkLiveBlogLeadImagenCaption(String Amp, String Link, String LinkAmp) {
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        isShowing &=commonFunctions.checkTextContains(LinkAmp, Page, "Page Url");
        isShowing &=commonFunctions.checkFirstLiveBlog(blogHeadline, blogOpenHeadline, liveBlog);
        isShowing &=commonFunctions.checkLiveBlogImagenCaption(leadImage, caption);
        return isShowing;
    }


    @Override
    public boolean checkLiveBlogSocialnBookmarkIcons(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        isShowing &=commonFunctions.checkLiveBlogSocialIcons(iconsList);
        return isShowing;
    }

    @Override
    public boolean checkLiveBlogPageTitle(String Amp, String Link, String LinkAmp, String Title) {
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctions.checkLiveBlogLandingPage(explore, expandMarkets, liveBlog);
        String Page= commonFunctions.getCurrentURL();
        isShowing &=commonFunctions.checkTextContains(LinkAmp, Page, "Page Url");
        isShowing &=commonFunctions.checkLiveBlogPageTitle(liveBlogTitle, Title);
        return isShowing;
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
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
        boolean isShowing=commonFunctions.checkMarketPageContents(markets, liveBlogTitle, firstImage, blogHeadline, breadcrumb);
        return isShowing;
    }

    @Override
    public boolean checkTopRightAdMarketPage() {
        return false;
    }

    @Override
    public boolean checkOpenAppInStory(String Amp) {
        commonFunctions.navigateToURL(globalVars.getURL()+Amp);
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
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "pop up");
        boolean isShowing=commonFunctionsWeb.checkShareIconsPolitics(explore, politics, firstStoryImg, iconsBox, iconsList);
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

