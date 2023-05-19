package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonCarRoadPricePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CarRoadPricePage extends CommonCarRoadPricePage {
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath="//ul[@id='ui-id-37']/li/div")
    private static List<WebElement> modelList;
    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[1]/a")
    private static WebElement findCars;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "//div[@id='mdlSearch']/div[2]/input")
    private static WebElement searchCar;
    @FindBy(xpath = "//div[@class='cardheading clearfix']//child::a")
    private static WebElement changeCity;
    @FindBy(xpath = "//div[@class='customCityRadio']/label")
    private static List<WebElement> selectCityList;
    @FindBy(xpath = "//div[contains(@class,'priceBtn')]/h2")
    private static WebElement selCarDetails;
    @FindBy(id = "cityAutoSuggest")
    private static WebElement cityTextBox;
    @FindBy(xpath = "//span[@class='city']")
    private static WebElement carNameCityName;
    @FindBy(xpath = "(//div[contains(@class,'PriceTotalRow')]/div[1])[1]")
    private static WebElement onRoadPrice;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public CarRoadPricePage() {
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

    public boolean checkCarRoadPrice(boolean selection,String expectedCity,String expectedRoadPriceText){
        boolean isStep;

        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.moveElementWithActions(findVehicles,findCars,10,"findVehicles");
        commonFunctions.clickElementWithJS(selectBrand, 10, "Select Brand");
        commonFunctions.dummyWait(2);
        String expectedBrand=brandList.get(0).getText();
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(2);

        commonFunctions.clickElement(selectModel, 10, "Select Model");
        System.out.println(modelList.size());
        String expectedModel=modelList.get(0).getText();
        commonFunctions.clickElementWithJS(modelList.get(0),10,expectedModel);
        commonFunctions.clickElementWithJS(searchCar, 30, "Search Car");
        commonFunctions.isClickableElementClicked(changeCity, 10, "Change City");
        if(selection) {
            commonFunctions.sendKeyBooleanWithExpectedElement(cityTextBox, expectedCity, "City name");
        }
        else{
            commonFunctions.clickElement(selectCityList.get(0),10,"selectCityList");
        }
        commonFunctions.isElementDisplayedIgnoringStaleElement(onRoadPrice,10,"onRoadPrice");
        String onRoadPriceText = commonFunctions.getElementText(onRoadPrice, 10);
        isStep= commonFunctions.compareTexts(onRoadPriceText, expectedRoadPriceText);
        return isStep;
    }
    @Override
    public boolean checkCarRoadPriceWithCitySelection(String expectedCity, String expectedRoadPriceText) {

        return checkCarRoadPrice(true,expectedCity,expectedRoadPriceText);

    }

    @Override
    public boolean checkCarRoadPriceWithCityFromList(String expectedCity, String expectedRoadPriceText) {

       return  checkCarRoadPrice(false,expectedCity,expectedRoadPriceText);

    }
}