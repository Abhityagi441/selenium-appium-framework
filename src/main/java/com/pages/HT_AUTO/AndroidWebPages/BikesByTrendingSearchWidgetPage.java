package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonBikeByTrendingSearchWidgetPage;
import com.pages.HT_AUTO.genericPages.CommonCarByTrendingPopularBudgetPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class BikesByTrendingSearchWidgetPage extends CommonBikeByTrendingSearchWidgetPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "icoMenu")
    private static WebElement hamburgerMenu;
    @FindBy(xpath = "//li/a[@id='fixedNav_findcars_bike']")
    private static WebElement findBikes;
    @FindBy(xpath = "//div[@class='secHdg']/h2")
    private static WebElement trendingBikeTextIcon;
    @FindBy(xpath = "//div[@class='trendingHeading']/h3")
    private static List<WebElement> searchBrandAndBudgetTextIcon;
    @FindBy(xpath = "//div[@id='brands']//a[@id='pBrand']")
    private static List<WebElement> searchAllNewBikeBrands;
    @FindBy(xpath = "//div[@id='latestCarSlider']//child::a[@class='fill-btn ga']")
    private static List<WebElement> bikeListBudgets;
    @FindBy(id = "hideShowText")
    private static WebElement viewMoreBikeBrands;


    public BikesByTrendingSearchWidgetPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        commonFunctionsMobile = CommonFunctionsMobile.getInstance();

        boolean isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkBikeByTrendingSearchWidget(String expectedTrendingBikeText, String expectedSearchBikeBrandsText, String expectedBikeByBudgetText) {
        boolean isBikeByTrendingSearchWidget = true;
        String trendingCarTextVisible;
        boolean isElementPresent;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, "Hamburger menu button.");
        commonFunctionsMobile.clickElementWithJS(findBikes, 20, "Find bike");
        commonFunctionsMobile.scrollToBottom();
        commonFunctionsMobile.scrollToViewElement(trendingBikeTextIcon, "Trending Bike", 20);
        trendingCarTextVisible = commonFunctionsMobile.getElementText(trendingBikeTextIcon, 10);
        isBikeByTrendingSearchWidget &= commonFunctionsMobile.compareTexts(trendingCarTextVisible, expectedTrendingBikeText);
        isBikeByTrendingSearchWidget &= commonFunctionsMobile.scrollToViewListOfWebElmentToCompareText(searchBrandAndBudgetTextIcon, 30, expectedSearchBikeBrandsText);
        isBikeByTrendingSearchWidget &= commonFunctionsMobile.scrollToViewListOfWebElmentToCompareText(searchBrandAndBudgetTextIcon, 30, expectedBikeByBudgetText);
        commonFunctionsMobile.clickElementWithJS(viewMoreBikeBrands, 30, "View More Bike Brands");
        isBikeByTrendingSearchWidget &= commonFunctionsMobile.getElementsClickable(searchAllNewBikeBrands, 50, "All new bike brands");
        isBikeByTrendingSearchWidget &= commonFunctionsMobile.getElementsClickable(bikeListBudgets, 40, "Bike list by dudget");

        return isBikeByTrendingSearchWidget;
    }
}