package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonCarsByTrendingSearchWidgetPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class CarsByTrendingSearchWidgetPage extends CommonCarsByTrendingSearchWidgetPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "icoMenu")
    private static WebElement hamburgerMenu;
    @FindBy(id = "fixedNav_findcars")
    private static WebElement findCars;
    @FindBy(xpath = "//div[@class='secHdg']/h2")
    private static WebElement trendingCarTextIcon;
    @FindBy(xpath = "//div[@class='trendingHeading']/h3")
    private static List<WebElement> searchBrandAndBudgetTextIcon;
    @FindBy(xpath = "//div[@id='brands']//a[@id='pBrand']")
    private static List<WebElement> searchAllNewCarsBrands;
    //TODO: Use contains if attribute value has space in it
    @FindBy(xpath = "//div[@id='latestCarSlider']//child::a[contains(@class,'fill-btn')]")
    private static List<WebElement> carListBudgets;
    @FindBy(id = "hideShowText")
    private static WebElement viewMoreCarBrands;
    @FindBy(xpath = "//div[@class='secHdg']//h3")
    private static WebElement upCommingCarsText;


    public CarsByTrendingSearchWidgetPage() {
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
    public boolean checkCarsByTrendingSearchWidget(String expectedTrendingCarText, String expectedSearchCarBrandsText, String expectedCarByBudgetText, String expectedCarByBodyTypeText, String expectedUpcommingCarText) {
        boolean isCarByTrendingSearchWidget = true;
        String trendingCarTextVisible;
        String upCommingCarTextVisibleAs;
        boolean isElementPresent;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, "Hamburger menu button.");
        commonFunctionsMobile.clickElementWithJS(findCars, 20, "Find car");
        commonFunctionsMobile.scrollToBottom();
        commonFunctionsMobile.scrollToViewElement(trendingCarTextIcon, "Trending cars", 20);
        trendingCarTextVisible = commonFunctionsMobile.getElementText(trendingCarTextIcon, 10);commonFunctionsMobile.scrollToViewElement(trendingCarTextIcon, "Trending cars", 20);
        isCarByTrendingSearchWidget &= commonFunctionsMobile.compareTexts(trendingCarTextVisible, expectedTrendingCarText);
        commonFunctionsMobile.scrollToViewElement(upCommingCarsText, "Upcoming cars", 20);
        upCommingCarTextVisibleAs = commonFunctionsMobile.getElementText(upCommingCarsText, 10);
        isCarByTrendingSearchWidget &= commonFunctionsMobile.compareTexts(upCommingCarTextVisibleAs, expectedUpcommingCarText);
        isCarByTrendingSearchWidget &= commonFunctionsMobile.scrollToViewListOfWebElmentToCompareText(searchBrandAndBudgetTextIcon, 30, expectedSearchCarBrandsText);
        isCarByTrendingSearchWidget &= commonFunctionsMobile.scrollToViewListOfWebElmentToCompareText(searchBrandAndBudgetTextIcon, 30, expectedCarByBudgetText);
        isCarByTrendingSearchWidget &= commonFunctionsMobile.scrollToViewListOfWebElmentToCompareText(searchBrandAndBudgetTextIcon, 30, expectedCarByBodyTypeText);
        commonFunctionsMobile.clickElementWithJS(viewMoreCarBrands, 30, "View More Car Brands");
        isCarByTrendingSearchWidget &= commonFunctionsMobile.getElementsClickable(searchAllNewCarsBrands, 50, "All new Car brands");
        isCarByTrendingSearchWidget &= commonFunctionsMobile.getElementsClickable(carListBudgets, 40, "Car list by dudget");

        return isCarByTrendingSearchWidget;
    }
}