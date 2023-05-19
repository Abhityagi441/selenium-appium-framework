package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonCompareCarPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class CompareCarsPage extends CommonCompareCarPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "(//nav[@id='leftNav']/a)[5]")
    private static WebElement compareCar;
    @FindBy(id = "_1CarBtn")
    private static WebElement addCar1;
    @FindBy(xpath = "//div[@id='_2CarBtn']")
    private static WebElement addCar2;
    @FindBy(xpath = "(//div[@class='modal-form-group']/input)[1]")
    private static WebElement searchBrandTextBox;
    @FindBy(id = "compareNowBTN")
    private static WebElement compareCarsButton;
    @FindBy(id = "btnSelect")
    private static WebElement doneButton;
    @FindBy(xpath = "//div[contains(@class,'cardheading')]/h1")
    private static WebElement actualFinalPageText;
    @FindBy(xpath = "//div[@id='manufacturer']/ul/li/a")
    private static List<WebElement> carBrandList;
    @FindBy(xpath = "//div[@id='models']/ul/li/a")
    private static List<WebElement> carModelList;
    @FindBy(xpath = "//div[@id='variants']//child::a")
    private static List<WebElement> carVariantList;
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


    public CompareCarsPage() {
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
    public boolean checkCompareCar() {
        boolean isCompareCar = true;
        String firstCarBrandModel;
        String secondCarBrandModel2;
        String brd1="";
        String brd2="";
        String mod1="";
        String mod2="";
        String var1="";
        String var2="";
        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        boolean isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        isCompareCar &=commonFunctionsMobile.clickElement(compareCar, 10, "Compare Car");
        isCompareCar &=commonFunctionsMobile.clickElement(addCar1, 10, "Add Car 1");
        isCompareCar &=commonFunctionsMobile.clickElement(searchBrandTextBox, 10, "Search Brand 1");
        commonFunctionsMobile.selectElementFromList(carBrandList, brd1,30);
        commonFunctionsMobile.selectElementFromList(carModelList, mod1,30);
        commonFunctionsMobile.selectElementFromList(carVariantList, var1,30);
        commonFunctionsMobile.clickElementIfDisplayed(doneButton,20,"Done button.");
        isCompareCar &=commonFunctionsMobile.clickElement(addCar2, 10, "Add Car 2");
        isCompareCar &=commonFunctionsMobile.clickElement(searchBrandTextBox, 10, "Search Brand 2");
        commonFunctionsMobile.selectElementFromList(carBrandList, brd2,30);
        commonFunctionsMobile.selectElementFromList(carModelList, mod2,30);
        commonFunctionsMobile.selectElementFromList(carVariantList, var2,30);
        commonFunctionsMobile.clickElementIfDisplayed(doneButton,20,"Done button.");
        isCompareCar &=commonFunctionsMobile.clickElement(compareCarsButton, 20, "Compare Button");
        isCompareCar &=commonFunctionsMobile.validateGetTextByTabular(compareRowsList,"Comparing Cars specification via row.");
        isCompareCar &=commonFunctionsMobile.validateGetTextByTabular(compareColmn1,brd1+" Car1 with specifications in Col1 of Tabular data");
        isCompareCar &=commonFunctionsMobile.validateGetTextByTabular(compareColmn2,brd2+" Car2 with specifications in Col2 of Tabular data");
        firstCarBrandModel = commonFunctionsMobile.appendTexts(brd1, mod1);
        secondCarBrandModel2 = commonFunctionsMobile.appendTexts(brd2, mod2);
        isCompareCar &=commonFunctionsMobile.compareActualTextForCompareCars(actualFinalPageText, "Car Compare", firstCarBrandModel, secondCarBrandModel2);

        return isCompareCar;
    }
}