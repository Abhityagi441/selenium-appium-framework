package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonBikeDetailsPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class BikeDetailsPage extends CommonBikeDetailsPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(className = "icoMenu")
    private static WebElement hamburger;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(id = "fixedNav_findcars_bike")
    private static WebElement findBikes;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "(//input[@type='submit'])[1]")
    private static WebElement searchBike;
    @FindBy(xpath = "//h1[@class='fl']")
    private static WebElement expectedText;
    @FindBy(xpath = "//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal']")
    private static List<WebElement> widgetListAvailable;

    public BikeDetailsPage() {
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
    public boolean checkBikeDetailPage(String expectedBrand, String expectedModel) {
        boolean isBikeDetailsSuccessful = true;
        boolean isElementPresent;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 2, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        commonFunctionsMobile.clickElementWithJS(hamburger,10,"hamburger");
        commonFunctionsMobile.clickElementWithJS(findBikes, 10, "Find Bike");
        commonFunctionsMobile.clickElementWithJS(selectBrand, 10, "Select Brand");
        commonFunctionsMobile.selectElement(selectBrand, expectedBrand);
        commonFunctionsMobile.clickElementWithJS(selectModel, 30, "Select Model");
        commonFunctionsMobile.selectElement(selectModel, expectedModel);
        isBikeDetailsSuccessful &= commonFunctionsMobile.clickElementWithJS(searchBike, 30, "Search Bike");
        isBikeDetailsSuccessful &= commonFunctionsMobile.scrollToBottomWorked();

        return isBikeDetailsSuccessful;
    }
}