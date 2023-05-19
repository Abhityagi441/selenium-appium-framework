package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonCompareBikePage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class CompareBikePage extends CommonCompareBikePage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//nav[contains(@class,'navP')]/a[6]")
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
    @FindBy(xpath = "//div[contains(@class,'compare-heading')]")
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
    @FindBy(xpath = "//div[@class='topcarcomparebtn']")
    private static List<WebElement> topBikeComparisionWidgetList;

    public CompareBikePage() {
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
    public boolean checkCompareBikePage() {
        boolean isCompareBike = true;
        String firstBikeBrandModel;
        String secondBikeBrandModel2;
        String brd1="";
        String brd2="";
        String mod1="";
        String mod2="";
        String var1="";
        String var2="";
        String rmvText="";
        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        boolean isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        isCompareBike &=commonFunctionsMobile.clickElementWithJS(compareBikes, 10, "Compare bike");
        isCompareBike &=commonFunctionsMobile.clickElementWithJS(addBike1, 10, "Add Bike 1");
        isCompareBike &=commonFunctionsMobile.clickElementWithJS(searchBrandTextBox, 10, "Search Brand 1");
        commonFunctionsMobile.selectElementFromList(bikesBrandList, brd1,30);
        commonFunctionsMobile.selectElementFromList(bikesModelList, mod1,30);
        commonFunctionsMobile.selectElementFromList(bikesVariantList, var1,30);
        commonFunctionsMobile.isElementDisplayedAndPresent(doneButton,10,"Done button");
        commonFunctionsMobile.clickElementWithJS(doneButton,30,"Done button");

        isCompareBike &=commonFunctionsMobile.clickElementWithJS(addBike2, 10, "Add Car 2");
        isCompareBike &=commonFunctionsMobile.clickElementWithJS(searchBrandTextBox, 10, "Search Brand 2");
        commonFunctionsMobile.selectElementFromList(bikesBrandList, brd2,30);
        commonFunctionsMobile.selectElementFromList(bikesModelList, mod2,30);
        commonFunctionsMobile.selectElementFromList(bikesVariantList, var2,30);
        commonFunctionsMobile.clickElementWithJS(doneButton,50,"Done button.");

        isCompareBike &=commonFunctionsMobile.clickElementWithJS(compareBikesButton, 20, "Compare Button");
        isCompareBike &=commonFunctionsMobile.validateGetTextByTabular(compareRowsList,"Comparing Cars specification via row.");
        isCompareBike &=commonFunctionsMobile.validateGetTextByTabular(compareColmn1,brd1+" Car1 with specifications in Col1 of Tabular data");
        isCompareBike &=commonFunctionsMobile.validateGetTextByTabular(compareColmn2,brd2+" Car2 with specifications in Col2 of Tabular data");
        firstBikeBrandModel = commonFunctionsMobile.appendTexts(brd1, mod1);
        secondBikeBrandModel2 = commonFunctionsMobile.appendTexts(brd2, mod2);
        isCompareBike &=commonFunctionsMobile.compareActualTextForCompareCars(actualFinalPageText, rmvText, firstBikeBrandModel, secondBikeBrandModel2);
        isCompareBike &=commonFunctionsMobile.getElementsClickable(topBikeComparisionWidgetList,30,"Top Bike Comparison widget");

        return isCompareBike;
    }
}