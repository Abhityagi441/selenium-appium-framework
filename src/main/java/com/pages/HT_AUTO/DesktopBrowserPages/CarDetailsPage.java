package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonCarDetailsPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarDetailsPage extends CommonCarDetailsPage {
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath="//ul[@id='ui-id-37']/li/div")
    private static List<WebElement> modelList;
    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[1]/a")
    private static WebElement findCars;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "//div[@id='mdlSearch']/div[2]/input")
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
    private static List<WebElement>     keySpecList;
    @FindBy(xpath = "//div[@class='model']/div/span")
    private static List<WebElement> variantPriceList;

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public CarDetailsPage() {
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
    public boolean checkCarDetails() {
        boolean isCarDetails=true;
        String priceSpecFeatureText;
        String completeCarName;
        String priceList_Spec_Ftr_Text="Price List, Specifications and Features";
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.dummyWait(2);
        commonFunctions.moveElementWithActions(findVehicles,findCars,10,"findVehicles");
        commonFunctions.dummyWait(2);

        commonFunctions.clickElementWithJS(selectBrand, 10, "Select Brand");
        String expectedBrand=brandList.get(0).getText();
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(2);

        commonFunctions.clickElement(selectModel, 10, "Select Model");
        System.out.println(modelList.size());
        String expectedModel=modelList.get(0).getText();
        commonFunctions.clickElementWithJS(modelList.get(0),10,expectedModel);
        commonFunctions.clickElementWithJS(searchCar, 10, "Search Car");
        commonFunctions.getTextsFromList(keySpecList, 10);
        priceSpecFeatureText = commonFunctions.getElementText(priceSpecFeat, 10);
        isCarDetails &=commonFunctions.compareTexts(priceSpecFeatureText,expectedBrand+" "+expectedModel+" "+priceList_Spec_Ftr_Text);
        commonFunctions.getTextsFromList(variantPriceList, 10);
        completeCarName = commonFunctions.appendTexts(expectedBrand, expectedModel);

        isCarDetails &= commonFunctions.actualCompleteText(keySpec, completeCarName," Key Specs");

        return isCarDetails;
    }
}