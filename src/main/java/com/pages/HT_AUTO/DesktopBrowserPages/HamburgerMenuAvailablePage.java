package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonHamburgerMenuAvailablePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HamburgerMenuAvailablePage extends CommonHamburgerMenuAvailablePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath="//section[contains(@class,'editorPick')]/div")
    private static WebElement historyText;
    @FindBy(xpath="//li[contains(@class,'submenu')]/ul/li/a")
    private static List<WebElement> subMenuList;
    @FindBy(xpath="//div[contains(@class,'story-container')]/h1")
    private static WebElement pageHeading;
    @FindBy(xpath="//section[@class='mainSec']//h1")
    private static WebElement nextHeading;
    @FindBy(xpath = "//ul[@class='mainLi']/li[6]/a")
    private static WebElement findVehicles;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//div[@class='clearfix']/a")
    private static WebElement explore;
    @FindBy(xpath = "//a[contains(@class,'btnlogin')]//div[2]")
    private static WebElement singInButton;
    @FindBy(xpath = "//nav[@id='Sidenav']/a[3]")
    private static WebElement notification;
    @FindBy(xpath = "//div[@class='subnavArrow']")
    private static WebElement autoNews;
    @FindBy(xpath = "//div[@class='subnavArrow']")
    private static WebElement autoNewsArrwBtn;
    @FindBy(xpath = "//ul[@class='clearfix']/li/a")
    private static List<WebElement> autoNewsList;
    @FindBy(xpath = "(//div[@class='dropdownWrapper'])[3]//ul/li[1]/a")
    private static WebElement findCars;
    @FindBy(xpath="//ul[@class='navCategories']/li[3]/a")
    private static WebElement findCarsNavigate;
    @FindBy(xpath = "//li/a[@id='fixedNav_findcars_bike']")
    private static WebElement findBikes;
    @FindBy(xpath = "//li/a[@id='fixedNav_comparecars']")
    private static WebElement compareCars;
    @FindBy(xpath = "//li/a[@id='fixedNav_comparecars_bike']")
    private static WebElement compareBikes;
    @FindBy(xpath = "//li/a[@id='fixedNav_emi_Calculator']")
    private static WebElement emiCalculator;
    @FindBy(xpath = "//li/a[@id='fixedNav_fasttag']")
    private static WebElement fastTag;
    @FindBy(xpath = "//aside[@class='headerIcon']/div/a[@title='Search']")
    private static WebElement searchBtn;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement linkPageHeading;
    @FindBy(xpath="//ul[@class='navCategories']/li/a")
    private static List<WebElement> listNav;

    public HamburgerMenuAvailablePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        boolean isElementPresent=commonFunctions.isElementDisplayedAndPresent(acceptCookie,10,"Accept Cookie");
        if(isElementPresent)
        {
            commonFunctions.clickElement(acceptCookie,10,"Explore button");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkHamburgerMenuAvailablePage() {
        boolean isHamburgerMenuAvailable = true;
        boolean isAllLinksAreClickableOfHamburger = true;

        commonFunctions.waitForPageToLoad();
        commonFunctions.navigateToHomePage();
        boolean isElementPresent=commonFunctions.isElementDisplayedAndPresent(acceptCookie,5,"Accept Cookie");
        if(isElementPresent)
        {
            commonFunctions.clickElement(acceptCookie,10,"Explore button");
        }
        commonFunctions.moveElementWithActions(findVehicles,findCars,10,"findVehicles");

        isHamburgerMenuAvailable &=commonFunctions.clickElement(explore, 10, "hamburger");
        commonFunctions.dummyWait(2);
        isAllLinksAreClickableOfHamburger &=commonFunctions.clickElementWithJS(notification, 10, "notification");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(explore, 10, "hamburger");
        isAllLinksAreClickableOfHamburger &=clickOnAllLinksInSequenceInsideAutoNews(autoNewsList, explore, autoNewsArrwBtn,"hamburger");
        openExplore();
        for(int i=1;i<listNav.size()-2;i++){
            String text=commonFunctions.getElementText(listNav.get(i));
            isHamburgerMenuAvailable&= commonFunctions.clickElementWithJS(listNav.get(i),5,listNav.get(i).getText());
            commonFunctions.dummyWait(5);

            System.out.println(text);
            if(text.equalsIgnoreCase("DEALERS")){
                    break;
            }
            else{
                commonFunctions.clickElementWithJS(explore, 10, "explore");
            }

        }

        return isHamburgerMenuAvailable && isAllLinksAreClickableOfHamburger;
    }

    public void openExplore(){
        if(!commonFunctions.isElementDisplayed(explore,10,"explore")){
            commonFunctions.moveElementWithActions(findVehicles,findCars,10,"findVehicles");

        }
        commonFunctions.clickElementWithJS(explore, 10, "hamburger");
    }
    @Override
    public boolean checkSearchPresent() {
        boolean isSearchPresent;
        boolean isSearchBtnVisible;
        isSearchBtnVisible = commonFunctions.clickElement (searchBtn, 10, "Search Button visible and clickable.");
        if (isSearchBtnVisible) {
            isSearchPresent = true;
        } else {
            isSearchPresent = false;
        }
        return isSearchPresent;
    }

    public boolean clickOnAllLinksInSequenceInsideAutoNews(List<WebElement> eleList, WebElement hamburgerMenu, WebElement autoNewsArrwBtn,String hambuger) {

        boolean isStep=true;
        String heading="";
        commonFunctions.clickElementIfDisplayed(autoNewsArrwBtn,10,"autoNews");
        System.out.println(subMenuList.size());

        for(int i=0;i<subMenuList.size();i++){
            String expectedText = subMenuList.get(i).getText().split(" ")[0].trim();
            commonFunctions.clickElementIfDisplayed(subMenuList.get(i),5,expectedText);

            if(expectedText.equalsIgnoreCase("My")){
                expectedText="History";
            }
            if(expectedText.equalsIgnoreCase("Electric")){
                heading=commonFunctions.getElementText(nextHeading,10).split(" ")[0].trim();

            }
            else if(expectedText.equalsIgnoreCase("History")){
                    heading=commonFunctions.getElementText(historyText,10).split(" ")[0].trim();

                }

            else {
                heading = commonFunctions.getElementText(pageHeading, 10).split(" ")[0].trim();
            }
            isStep&=heading.equalsIgnoreCase(expectedText);
            if(!commonFunctions.isElementDisplayed(hamburgerMenu,5,"hamburgerMenu")) {
                commonFunctions.moveElementWithActions(findVehicles, findCars, 10, "findVehicles");
            }
            commonFunctions.dummyWait(5);
            commonFunctions.clickElementIfDisplayed(hamburgerMenu,5,"hamburger");
            commonFunctions.clickElementIfDisplayed(autoNewsArrwBtn,10,"autoNews");


        }
        commonFunctions.navigateToHomePage();
        return isStep;
    }
}