package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonCarDetailsPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class CarDetailsPage extends CommonCarDetailsPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "(//nav[@id='leftNav']/a)[3]")
    private static WebElement findCars;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "(//input[@type='submit'])[1]")
    private static WebElement searchCar;
    @FindBy(xpath = "(//div[contains(@class,'PriceTotalRow')]/div[1])[1]")
    private static WebElement onRoadPrice;
    @FindBy(xpath = "(//ul[@id='ui-id-1']/li/div)")
    private static List<WebElement> locationOpt;
    @FindBy(xpath = "//div[@class='priceBtnCompare pdpCompareR']/h2")
    private static WebElement keySpec;
    @FindBy(xpath = "//div[@class='variantSearch']/h2")
    private static WebElement priceSpecFeat;
    @FindBy(xpath = "//div[@class='quickDetails']/div/span")
    private static List<WebElement> keySpecList;
    @FindBy(xpath = "//div[@class='model']/div/span")
    private static List<WebElement> variantPriceList;

    public CarDetailsPage() {
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
    public boolean checkCarDetails() {
        boolean isCarDetails=true;
        String priceSpecFeatureText;
        boolean isElementPresent;
        String completeCarName;
        String expectedBrand="";
        String expectedModel="";
        String priceList_Spec_Ftr_Text="";
        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }

        commonFunctionsMobile.clickElementWithJS(selectBrand, 30, "Select Brand");
        commonFunctionsMobile.selectElement(selectBrand, expectedBrand);
        commonFunctionsMobile.clickElementWithJS(selectModel, 30, "Select Model");
        commonFunctionsMobile.selectElement(selectModel, expectedModel);
        isCarDetails &=commonFunctionsMobile.clickElementWithJS(searchCar, 30, "Search Car");
        commonFunctionsMobile.scrollToBottom();
        completeCarName = commonFunctionsMobile.appendTexts(expectedBrand, expectedModel);
        commonFunctionsMobile.getTextsFromList(keySpecList, 10,"Keys Spec of "+completeCarName);
        commonFunctionsMobile.scrollToViewElement(priceSpecFeat,"Price specifiacation feature",30);
        priceSpecFeatureText = commonFunctionsMobile.getElementText(priceSpecFeat, 10);
        isCarDetails &=commonFunctionsMobile.compareTexts(priceSpecFeatureText,priceList_Spec_Ftr_Text);
        commonFunctionsMobile.getTextsFromList(variantPriceList, 10,"Car Variant Price related to "+completeCarName);
        isCarDetails &= commonFunctionsMobile.actualCompleteText(keySpec, completeCarName," Key Specs");

        return isCarDetails;
    }
}