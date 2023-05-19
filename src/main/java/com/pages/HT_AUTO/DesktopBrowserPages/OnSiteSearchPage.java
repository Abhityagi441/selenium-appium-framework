package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonOnSiteSearchPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class OnSiteSearchPage extends CommonOnSiteSearchPage {

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//div[@class='searchWrapper']/input")
    private static WebElement searchBtn;
    @FindBy(className = "searchParameter")
    private static WebElement searchTextBox;
    @FindBy(id = "searchSubmitBtn")
    private static WebElement searchBtnTabText;
    @FindBy(xpath = "//div[@class='SearchProductWidget']/div")
    private static List<WebElement> widgeCartList;
    @FindBy(xpath = "//div[@class='info']//child::h3")
    private static List<WebElement> carCTAList;
    @FindBy(xpath = "//div[contains(@class,'cardheading')]//h1")
    private static List<WebElement> brandArticlesList;

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public OnSiteSearchPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctions.clickElementIfDisplayed(acceptCookie, 10,"acceptCookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkOnSiteSearchWithRespectToCar(String expectedCarBrand, String carBrandList) {
        boolean isOnSiteSearchWithRespectToCar = false;
        boolean isSearchBtnNotEnabled;
        boolean isWidgetOfBrandShown;
        boolean isCTAWorking = false;
        boolean isBrandArticlesShowing;

        commonFunctions.waitForPageToLoad();
        commonFunctions.navigateToHomePage();
        commonFunctions.clickElement(searchBtn, 30, "Search icon");
        isSearchBtnNotEnabled = commonFunctions.isEnabledElementVerify(searchBtnTabText, "Search button before entering text.");
        commonFunctions.clickElementWithJS(searchTextBox,5,"searchTextBox");
        commonFunctions.sendKeyBoolean(searchTextBox, expectedCarBrand, 10, "Inserted Car brand name.");
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(searchBtnTabText, 10, "Search button after entering text successfully.");
        isWidgetOfBrandShown = commonFunctions.validateTabularForAllWebElement(widgeCartList, carBrandList);

        if (widgeCartList.size() > 0) {
            isCTAWorking = commonFunctions.clickingOnElementDisable(widgeCartList.get(0), 10, "CTA working.");
        }

        isBrandArticlesShowing = commonFunctions.validateTabularForAllWebElement(brandArticlesList, "Brand Articles.");
        if (isSearchBtnNotEnabled && isWidgetOfBrandShown && isCTAWorking && isBrandArticlesShowing) {
            isOnSiteSearchWithRespectToCar = true;
        }
        return isOnSiteSearchWithRespectToCar;
    }
}