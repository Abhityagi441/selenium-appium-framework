package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonBikeListingPage;
import com.pages.HT_AUTO.genericPages.CommonCarListingPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarListingPage extends CommonCarListingPage {


    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[1]/a")
    private static WebElement findCars;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(xpath = "//div[@id='mdlSearch']/div[2]/input")
    private static WebElement searchCar;
    @FindBy(xpath = "//div[@class='name']//child::h2")
    private static List<WebElement> carModelList;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public CarListingPage() {
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
    public boolean checkCarListingPage() {
        boolean isCarListingPage = true;
        commonFunctions.navigateToUrl(globalVars.getURL());
        commonFunctions.dummyWait(2);
        commonFunctions.moveElementWithActions(findVehicles,findCars,10,"findVehicles");
        commonFunctions.dummyWait(2);

        commonFunctions.clickElementWithJS(selectBrand, 10, "Select Brand");
         String expectedBrand=brandList.get(0).getText();
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(searchCar, 10, "Search Car");
        isCarListingPage &= commonFunctions.isAllElementVisible(carModelList, 20);

        return isCarListingPage;
    }
}