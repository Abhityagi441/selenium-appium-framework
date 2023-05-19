package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonCTACarProductDetailPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CTACarProductDetailPage extends CommonCTACarProductDetailPage {
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[1]/a")
    private static WebElement findCars;
    @FindBy(xpath="//ul[@id='ui-id-37']/li/div")
    private static List<WebElement> modelList;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(id = "car-model-selector")
    private static WebElement selectModel;
    @FindBy(xpath = "//div[@id='mdlSearch']/div[2]")
    private static WebElement searchCar;
    @FindBy(xpath = "//div[contains(@class,'priceBtn')]/h2")
    private static WebElement selCarDetails;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public CTACarProductDetailPage() {
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
    public boolean checkCTACarProductDetailPage() {
        boolean isCTACarProductDetail;


        commonFunctions.navigateToHomePage();
        commonFunctions.dummyWait(5);
        commonFunctions.moveElementWithActions(findVehicles,findCars,10,"findVehicles");

        commonFunctions.clickElement(selectBrand, 10, "Select Brand");
        commonFunctions.dummyWait(5);
        String expectedBrand=brandList.get(0).getText();
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(selectModel, 10, "Select Model");
        System.out.println(modelList.size());
        String expectedModel=modelList.get(0).getText();
        commonFunctions.clickElementWithJS(modelList.get(0),10,expectedModel);
        commonFunctions.clickElement(searchCar, 30, "Search Car");
        commonFunctions.scrollToBottom();
        String completeExpectedTxt = commonFunctions.appendTexts(expectedBrand, expectedModel);
        isCTACarProductDetail = commonFunctions.actualCompleteText(selCarDetails, completeExpectedTxt," Key Specs");
        return isCTACarProductDetail;
    }
}