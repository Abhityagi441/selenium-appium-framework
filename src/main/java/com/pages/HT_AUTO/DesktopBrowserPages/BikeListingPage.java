package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonBikeListingPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BikeListingPage extends CommonBikeListingPage {
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[2]/a")

    private static WebElement findBikes;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "//div[@id='mdlSearch']/div[2]")
    private static WebElement searchBike;
    @FindBy(xpath = "//span[@id='modelSearchResult']/div")
    private static List<WebElement> bikeModelList;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public BikeListingPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "acceptCookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkBikeListingPage() {
        boolean isBikeListingPage = true;

        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.dummyWait(2);
        commonFunctions.moveElementWithActions(findVehicles,findBikes,10,"findVehicles");
        commonFunctions.clickElement(selectBrand, 10, "Select Tab of Bike Brand");
        commonFunctions.clickElementWithJS(selectBrand, 10, "Select Brand");
        String expectedBrand=brandList.get(0).getText();
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(searchBike, 10, "Search Bikes");
        isBikeListingPage &= commonFunctions.moveToElementWithActions(bikeModelList);
        isBikeListingPage &= commonFunctions.validateGetTextByTabular(bikeModelList, "List of bikes");

        return isBikeListingPage;
    }
}