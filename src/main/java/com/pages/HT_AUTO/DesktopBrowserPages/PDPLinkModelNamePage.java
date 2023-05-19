package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonPDPLinkModelNamePage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class PDPLinkModelNamePage extends CommonPDPLinkModelNamePage {
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[1]/a")
    private static WebElement findCars;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(xpath = "//div[@id='mdlSearch']/div[2]")
    private static WebElement searchCar;
    @FindBy(xpath = "//span[@id='modelSearchResult']//div[contains(@class,'carouselBox')]")
    private static List<WebElement> carModelList;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public PDPLinkModelNamePage() {
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
    public boolean checkPDPLinkModelNamePage() {
        boolean isPDPLinkModelNamePage = true;
        String getCurrentURLText;


        commonFunctions.navigateToHomePage();
        boolean isElementPresent=commonFunctions.isElementDisplayedAndPresent(acceptCookie,5,"Accept Cookie");
        if(isElementPresent)
        {
            commonFunctions.clickElementIfDisplayed(acceptCookie,10,"acceptCookie");
        }
        commonFunctions.moveElementWithActions(findVehicles,findCars,10,"findVehicles");

        commonFunctions.clickElement(selectBrand, 10, "Select Brand");
        commonFunctions.dummyWait(5);
        String expectedBrand=brandList.get(0).getText().replaceAll(" ","").toLowerCase();
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(searchCar, 30, "Search Car");
        getCurrentURLText = commonFunctions.getCurrentURL();
        isPDPLinkModelNamePage &= getCurrentURLText.contains(expectedBrand);
        isPDPLinkModelNamePage &= commonFunctions.moveToElementWithActions(carModelList);

        return isPDPLinkModelNamePage;
    }
}