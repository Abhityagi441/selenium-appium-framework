package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;

import com.utils.GlobalVars;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.HT_AUTO.genericPages.CommonBikeDetailsPage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BikeDetailsPage extends CommonBikeDetailsPage {
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[2]/a")
    private static WebElement findBikes;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "//div[@id='mdlSearch']/div[2]")
    private static WebElement searchBike;
    @FindBy(xpath="//ul[@id='ui-id-77']/li/div")
    private static List<WebElement> modelList;
    @FindBy(xpath = "//div[contains(@class,'priceBtnCompare')]/h2")
    private static WebElement expectedText;
    @FindBy(xpath = "//span[contains(@class,'light')]")
    private static List<WebElement> varientList;
    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public BikeDetailsPage() {
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
    public boolean checkBikeDetailPage(String expectedBrand, String expectedModel) {
        boolean isBikeDetailsSuccessful;
        boolean isAllVariantsVisibile;


        commonFunctions.navigateToHomePage();
        commonFunctions.dummyWait(5);
        commonFunctions.moveElementWithActions(findVehicles,findBikes,10,"findVehicles");
        commonFunctions.clickElement(selectBrand, 30, "Select Brand");
       // commonFunctions.selectElement(selectBrand, expectedBrand);
        String list="//ul[@id='ui-id-1']//li/div";
        try {
            commonFunctions.waitUntilSize(10, list);
        }
        catch(Exception e){
            commonFunctions.clickElement(selectBrand, 30, "Select Brand");
        }
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(selectModel, 30, "Select Model");
        System.out.println(modelList.size());
        commonFunctions.clickElementWithJS(modelList.get(0),10,expectedModel);
        commonFunctions.clickElement(searchBike, 30, "Search Bike");
        String completeExpectedTxt = commonFunctions.appendTexts(expectedBrand, expectedModel);
        isBikeDetailsSuccessful = commonFunctions.actualCompleteText(expectedText, completeExpectedTxt, " Key Specs");
       /* commonFunctions.isElementDisplayedIgnoringStaleElement(varientList.get(0),10,"variant list");
        isAllVariantsVisibile=commonFunctions.validateGetTextByTabular(varientList,"Variant list elements");
*/
        return isBikeDetailsSuccessful;
    }
}