package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonBikeListingPage;
import com.pages.HT_AUTO.genericPages.CommonPDPLinkOnBikeModlePage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PDPLinkOnBikeModlePage extends CommonPDPLinkOnBikeModlePage {
    @FindBy(xpath="//ul[@id='ui-id-1']//li/div")
    private static List<WebElement> brandList;
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[2]/a")
    private static WebElement findBikes;
    @FindBy(id = "car-brand-selector")
    private static WebElement selectBrand;
    @FindBy(xpath = "(//input[@type='submit'])[1]")
    private static WebElement searchBike;
    @FindBy(xpath = "//span[@id='modelSearchResult']/div")
    private static List<WebElement> bikeModelList;
    @FindBy(id="bike-model-selector")
    private static WebElement selectModle;


    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public PDPLinkOnBikeModlePage() {
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
    public boolean checkPDPLinkOnBikeModle() {
        boolean isPDPLinkOnBikeModle= true;
        String currentURLText;

        commonFunctions.deleteCookiesAndNavigateToHomePage();
        commonFunctions.dummyWait(2);
        commonFunctions.moveElementWithActions(findVehicles,findBikes,10,"findVehicles");
        commonFunctions.clickElementWithJS(selectBrand, 10, "Select Brand");
        commonFunctions.dummyWait(5);
        String expectedBrand=brandList.get(0).getText();
        commonFunctions.clickElementWithJS(brandList.get(0),10,expectedBrand);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElement(searchBike, 10, "Search Bikes");
        currentURLText=commonFunctions.getCurrentURL();
        isPDPLinkOnBikeModle &=commonFunctions.compareTexts(currentURLText,globalVars.getURL()+"new-bikes/"+expectedBrand);
        isPDPLinkOnBikeModle &=commonFunctions.moveToElementWithActions(bikeModelList);

        return isPDPLinkOnBikeModle;
    }
}