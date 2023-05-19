package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonCompareBikePage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompareBikePage extends CommonCompareBikePage {

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath="//ul[@class='mainLi']/li[7]/a")
    private static WebElement compareButton;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[4]//li[2]/a")
    private static WebElement compareBikes;
    @FindBy(id = "_1CarBtn")
    private static WebElement addBike1;
    @FindBy(xpath = "//div[@id='_2CarBtn']")
    private static WebElement addBike2;
    @FindBy(xpath = "(//div[@class='modal-form-group']/input)[1]")
    private static WebElement searchBrandTextBox;
    @FindBy(id = "compareNowBTN")
    private static WebElement compareBikesButton;
    @FindBy(id = "btnSelect")
    private static WebElement doneButton;
    @FindBy(xpath="//div[@id='manufacturer']/ul/li/a")
    private static List<WebElement> manufacturerList;
    @FindBy(xpath="//div[@id='models']/ul/li/a")
    private static List<WebElement> modelsList;
    @FindBy(xpath="//div[@id='variants']/ul/li/a")
    private static List<WebElement> variantList;
    @FindBy(xpath = "//div[@class='cardheading compare-heading']/h1")
    private static WebElement actualFinalPageText;
    @FindBy(xpath = "//div[@id='manufacturer']/ul/li/a")
    private static List<WebElement> bikesBrandList;
    @FindBy(xpath = "//div[@id='models']/ul/li/a")
    private static List<WebElement> bikesModelList;
    @FindBy(xpath = "//div[@id='variants']//child::a")
    private static List<WebElement> bikesVariantList;
    @FindBy(xpath = "//div[@class='tblCompare']/div[@class='compRow']")
    private static List<WebElement> compareRowsList;
    @FindBy(xpath = "//div[@class='tblCompare']/div[@class='compCol']/div[@class='col1']")
    private static List<WebElement> compareColmn1;
    @FindBy(xpath = "//div[@class='tblCompare']/div[@class='compCol']/div[@class='col2']")
    private static List<WebElement> compareColmn2;
    @FindBy(xpath = "(//div[normalize-space()='Engine'])[1]")
    private static WebElement tebularRow;
    @FindBy(xpath = "(//div[@class='compCol']/div)[1]")
    private static WebElement tebularCol1;
    @FindBy(xpath = "(//div[normalize-space()='Engine'])[1]")
    private static WebElement tebularCol2;

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public CompareBikePage() {
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
    public boolean checkCompareBikePage() {
        boolean isCompareBikePage;

        boolean isCompareCar = true;
        String firstBikeBrandModel;
        String secondBikeBrandModel2;
        String brd1="";
        String brd2="";
        String mod1="";
        String mod2="";
        String var1="";
        String var2="";


        commonFunctions.navigateToHomePage();
        boolean isElementPresent=commonFunctions.isElementDisplayedAndPresent(acceptCookie,5,"Accept Cookie");
        if(isElementPresent)
        {
            commonFunctions.clickElementIfDisplayed(acceptCookie,10,"acceptCookie");
        }
        commonFunctions.dummyWait(5);
        commonFunctions.moveElementWithActions(compareButton,compareBikes,5,"compareButton");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(addBike1, 10, "Add Bike 1");
        commonFunctions.clickElement(searchBrandTextBox, 10, "Search Brand 1");
        brd1=manufacturerList.get(1).getText();
        commonFunctions.clickElementWithJS(manufacturerList.get(1),10,brd1);
        commonFunctions.dummyWait(2);
        mod1=modelsList.get(1).getText();
        commonFunctions.clickElementWithJS(modelsList.get(1),10,mod1);
        commonFunctions.dummyWait(2);
        var1=variantList.get(1).getText();
        commonFunctions.clickElementWithJS(variantList.get(1),10,var1);
        commonFunctions.clickWhenElementIsEnabled(doneButton,20,"Done button.");
        commonFunctions.clickElementWithJS(addBike2, 10, "Add Car 2");
        commonFunctions.clickElement(searchBrandTextBox, 10, "Search Brand 2");
        brd2=manufacturerList.get(2).getText();
        commonFunctions.clickElementWithJS(manufacturerList.get(2),10,brd2);
        commonFunctions.dummyWait(2);
        mod2=modelsList.get(2).getText();
        commonFunctions.clickElementWithJS(modelsList.get(2),10,mod2);
        commonFunctions.dummyWait(2);
        var2=variantList.get(1).getText();
        commonFunctions.clickElementWithJS(variantList.get(1),10,var2);
        commonFunctions.clickWhenElementIsEnabled(doneButton,20,"Done button.");
        commonFunctions.clickElement(compareBikesButton, 20, "Compare Button");
        isCompareCar &=commonFunctions.validateGetTextByTabular(compareRowsList,"Comparing Cars specification via row.");
        isCompareCar &=commonFunctions.validateGetTextByTabular(compareColmn1,brd1+" Car1 with specifications in Col1 of Tabular data");
        isCompareCar &=commonFunctions.validateGetTextByTabular(compareColmn2,brd2+" Car2 with specifications in Col2 of Tabular data");
        firstBikeBrandModel = commonFunctions.appendTexts(brd1, mod1);
        secondBikeBrandModel2 = commonFunctions.appendTexts(brd2, mod2);
        isCompareCar &=commonFunctions.compareActualTextForCompareCars(actualFinalPageText, "Bike Comparison", firstBikeBrandModel, secondBikeBrandModel2);

        return isCompareCar;
    }
}