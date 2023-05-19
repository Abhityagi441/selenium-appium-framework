package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonCarByTrendingPopularBudgetPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarByTrendingPopularBudgetPage extends CommonCarByTrendingPopularBudgetPage {

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//div[@class='secHdg']/h2")
    private static WebElement trendingCarText;
    @FindBy(xpath = "//div[@class='name']")
    private static List<WebElement> listTrendingCars;
    @FindBy(xpath = "//div[@id='brands']//h3")
    private static WebElement popularBrandText;
    @FindBy(xpath = "//div[@class='brand-wr']/a")
    private static List<WebElement> listPopularCarBrands;
    @FindBy(xpath = "(//nav[@id='leftNav']/a)[2]")
    private static WebElement findCars;
    @FindBy(xpath = "(//div[@class='trendingHeading']/h3)[2]")
    private static WebElement carByBudgetText;
    @FindBy(xpath = "(//div[@class='trendingHeading']/h3)[3]")
    private static WebElement carByBodyText;
    @FindBy(xpath = "//article[@class='trendArticle']//a")
    private static List<WebElement> carbyBodyAndBudgetList;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public CarByTrendingPopularBudgetPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        boolean isElementPresent=commonFunctions.isElementDisplayedAndPresent(acceptCookie,10,"Accept Cookie");
        if(isElementPresent)
        {
            commonFunctions.clickElementIfDisplayed(acceptCookie,10,"acceptCookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkCarByTrendingPopularBudget(String expectedTrendingCarText) {
        boolean isBikeDetailsSuccessful = true;
        String trendingCarTextVisible;

        commonFunctions.waitForPageToLoad();
        commonFunctions.navigateToHomePage();
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToViewElement(trendingCarText, "Trending Car", 20);
        trendingCarTextVisible = commonFunctions.getElementText(trendingCarText, 10);
        isBikeDetailsSuccessful &= commonFunctions.compareTexts(trendingCarTextVisible, expectedTrendingCarText);
        isBikeDetailsSuccessful &= commonFunctions.validateGetTextByTabular(listTrendingCars, "List of Trending Cars");
        commonFunctions.scrollToViewElement(popularBrandText, "Popular car brand", 20);
        commonFunctions.clickElement(popularBrandText, 10);
        isBikeDetailsSuccessful &= commonFunctions.validateGetTextByTabular(listPopularCarBrands, "List of Popular brand cars");
        isBikeDetailsSuccessful &= commonFunctions.getElementsClickable(listPopularCarBrands, 30, "List of Popular brand cars");
        commonFunctions.clickElement(findCars, 20, "Find Car Tab");
        commonFunctions.scrollToViewElement(carByBudgetText, "Car by Budget", 20);
        commonFunctions.scrollToViewElement(carByBodyText, "Car by Body", 20);
        isBikeDetailsSuccessful &= commonFunctions.validateGetTextByTabular(carbyBodyAndBudgetList, "Car by Body and Budget");
        isBikeDetailsSuccessful &= commonFunctions.getElementsClickable(carbyBodyAndBudgetList, 30, "Car by Body and Budget");

        return isBikeDetailsSuccessful;
    }
}