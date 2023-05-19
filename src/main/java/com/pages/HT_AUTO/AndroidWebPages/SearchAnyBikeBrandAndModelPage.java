package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonSearchAnyBikeBrandAndModelPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchAnyBikeBrandAndModelPage extends CommonSearchAnyBikeBrandAndModelPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "icoMenu")
    private static WebElement hamburgerMenu;
    @FindBy(xpath = "//li/a[@id='fixedNav_findcars_bike']")
    private static WebElement findBikes;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "(//input[@type='submit'])[1]")
    private static WebElement searchBike;
    @FindBy(xpath = "//h1[@class='fl']")
    private static WebElement expectedText;
    @FindBy(xpath = "(//div[contains(@class,'priceBtnCompare')]//h2)[2]")
    private static WebElement keysSpec;


    public SearchAnyBikeBrandAndModelPage() {
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
    public boolean checkSearchAnyBikeBrandAndModel(String expectedBrand, String expectedModel, String expectedText) {
        boolean isSearchSuccessful = true;
        boolean isCurrentPageCorrect = true;
        boolean isSearchAnyBikeBrandModle = false;
        String detailsText;
        boolean isElementPresent;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 10, "Hambuger menu");
        commonFunctionsMobile.clickElementWithJS(findBikes, 20, "Find bikes");
        commonFunctionsMobile.clickElementWithJS(selectBrand, 30, "Select Brand");
        isSearchSuccessful &= commonFunctionsMobile.checkSelectElement(selectBrand, expectedBrand);
        commonFunctionsMobile.clickElementWithJS(selectModel, 30, "Select Model");
        isSearchSuccessful &= commonFunctionsMobile.checkSelectElement(selectModel, expectedModel);
        isSearchSuccessful &= commonFunctionsMobile.clickElementWithJS(searchBike, 30, "Search Bike");
        isCurrentPageCorrect &= commonFunctionsMobile.checkTextContainByCurrentURL(expectedBrand, "Brand containing");
        isCurrentPageCorrect &= commonFunctionsMobile.checkTextContainByCurrentURL(expectedModel, "Model containing");
        detailsText = commonFunctionsMobile.getElementText(keysSpec, 20);
        isCurrentPageCorrect &= commonFunctionsMobile.isTextContains(detailsText, expectedText);

        if (isCurrentPageCorrect && isSearchSuccessful)
            isSearchAnyBikeBrandModle = true;

        return isSearchAnyBikeBrandModle;
    }
}