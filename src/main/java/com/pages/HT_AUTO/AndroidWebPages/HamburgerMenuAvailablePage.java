package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonHamburgerMenuAvailablePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HamburgerMenuAvailablePage extends CommonHamburgerMenuAvailablePage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "icoMenu")
    private static WebElement hamburgerMenu;
    @FindBy(xpath = "//a[contains(@class,'btnlogin')]//div[2]")
    private static WebElement singInButton;
    @FindBy(xpath = "//a[@class='ePaper clearfix ga']//div[2]")
    private static WebElement notification;
    @FindBy(xpath = "//li[@class='submenu']")
    private static WebElement autoNews;
    @FindBy(css = "img[src='/images/nav-arrow.svg']")
    private static WebElement autoNewsArrwBtn;
    @FindBy(xpath = "//ul[@class='clearfix']//a")
    private static List<WebElement> autoNewsList;
    @FindBy(id = "fixedNav_findcars")
    private static WebElement findCars;
    @FindBy(id = "fixedNav_findcars_bike")
    private static WebElement findBikes;
    @FindBy(id = "fixedNav_comparecars")
    private static WebElement compareCars;
    @FindBy(id = "fixedNav_comparecars_bike")
    private static WebElement compareBikes;
    @FindBy(id = "fixedNav_emi_Calculator")
    private static WebElement emiCalculator;
    @FindBy(xpath = "//a[contains(@class,'btnSearch')]//div[2]")
    private static WebElement searchBtn;
    @FindBy(xpath = "//ul[@class='navCategories'][1]/li")
    private static List<WebElement> topSectionsList;
    @FindBy(xpath = "//ul[@class='navCategories'][2]/li")
    private static List<WebElement> exploreAutoList;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement linkPageHeading;


    public HamburgerMenuAvailablePage() {
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
    public boolean checkHamburgerMenuAvailablePage() {
        boolean isHamburgerMenuAvailable = true;
        boolean isAllLinksAreClickableOfHamburger = true;
        boolean isElementPresent;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        isHamburgerMenuAvailable &= commonFunctionsMobile.isElementDisplayed(hamburgerMenu, 20, "Hamburger menu");
        isHamburgerMenuAvailable &= commonFunctionsMobile.isElementClickable(hamburgerMenu, 20, "Hamburger Menu");
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 10, "hamburger");
        isAllLinksAreClickableOfHamburger &= commonFunctionsMobile.clickElementWithActions(singInButton, 30, "Sign In button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctionsMobile.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctionsMobile.closeAllWindowsExceptMasterTab();
        commonFunctionsMobile.pageRefresh();
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, "hamburger");
        isAllLinksAreClickableOfHamburger &= commonFunctionsMobile.clickElementWithJS(searchBtn, 20, "SearchButton");
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 10, "hamburger");
        isAllLinksAreClickableOfHamburger &= commonFunctionsMobile.clickElementWithJS(notification, 10, "notification");
        isAllLinksAreClickableOfHamburger &= clickOnAllLinksInSequenceInsideAutoNews(autoNewsList, hamburgerMenu,autoNewsArrwBtn, "hamburger");
        isAllLinksAreClickableOfHamburger &= clickOnAllLinksInSequence(topSectionsList, hamburgerMenu, "hamburger");
        isAllLinksAreClickableOfHamburger &= clickOnAllLinksInSequence(exploreAutoList, hamburgerMenu, "hamburger");

        if (isAllLinksAreClickableOfHamburger && isHamburgerMenuAvailable)
            isHamburgerMenuAvailable = true;

        return isHamburgerMenuAvailable;
    }

    @Override
    public boolean checkSearchPresent() {
        boolean isSearchPresent;
        boolean isSearchBtnVisible;
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, "Hamburger Menu");
        isSearchBtnVisible = commonFunctionsMobile.clickElementWithJS(searchBtn, 10, "Search Button visible and clickable.");
        if (isSearchBtnVisible) {
            isSearchPresent = true;
        } else {
            isSearchPresent = false;
        }
        return isSearchPresent;
    }

    public boolean clickOnAllLinksInSequenceInsideAutoNews(List<WebElement> eleList, WebElement hamburgerMenu, WebElement autoNewsArrwBtn,String hambuger) {
        boolean isClickOnAllLinksInSequenceInsideAutoNews = true;
        WebElement ele;
        String text=null;
        String textLowerCase=null;

        try {
            for (int i=0;i<eleList.size();i++) {
                isClickOnAllLinksInSequenceInsideAutoNews &=commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, hambuger);
                isClickOnAllLinksInSequenceInsideAutoNews &=commonFunctionsMobile.clickElementWithJS(autoNewsArrwBtn,20,"arrow expander");
                ele=eleList.get(i);
                text= commonFunctionsMobile.getElementText(ele,20);
                String[] textSplit=text.split(" ");
                if(textSplit.length>1)
                {
                    text=textSplit[0];
                    textLowerCase=text.toLowerCase();
                }
                else
                {
                    textLowerCase=text.toLowerCase();
                }
                commonFunctionsMobile.clickElementWithJS(ele,20,text);
                String currentURl = commonFunctionsMobile.getCurrentURL();
                String pageHeadingText=commonFunctionsMobile.getElementText(linkPageHeading,5);
                String currentTextLowerCase=pageHeadingText.toLowerCase();

                if(!(pageHeadingText.isEmpty() || pageHeadingText==null))
                {
                    if(currentURl.contains(textLowerCase) || currentTextLowerCase.contains(textLowerCase))
                    {
                        isClickOnAllLinksInSequenceInsideAutoNews &=true;
                        Utils.logStepInfo(isClickOnAllLinksInSequenceInsideAutoNews,"After clicking on " + text + " Current URL is " + currentURl+" and current page heading is "+pageHeadingText);
                    }
                }
                else if(currentURl.contains(textLowerCase))
                {
                    isClickOnAllLinksInSequenceInsideAutoNews &=true;
                    Utils.logStepInfo(isClickOnAllLinksInSequenceInsideAutoNews,currentURl+" contains "+text);
                }
            }
        } catch (Exception e) {
            isClickOnAllLinksInSequenceInsideAutoNews = false;
            Utils.logStepInfo(false, "clickOnAllLinksInSequence is failed.");
            e.printStackTrace();
        }
        return isClickOnAllLinksInSequenceInsideAutoNews;
    }

    public boolean clickOnAllLinksInSequence(List<WebElement> eleList, WebElement hamburgerMenu, String hambuger) {
        boolean isClickOnAllLinksInSequence = true;
        WebElement ele;

        try {
            for (int i=0;i<eleList.size();i++) {
                isClickOnAllLinksInSequence &=commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, hambuger);
                ele=eleList.get(i);
                String text= commonFunctionsMobile.getElementText(ele,5);
                commonFunctionsMobile.clickElementWithJS(ele,20,text);
                String currentURl = commonFunctionsMobile.getCurrentURL();
                String currentPageHeadingText=commonFunctionsMobile.getElementText(linkPageHeading,5);

                if(!(currentPageHeadingText.isEmpty()))
                {
                    if(currentURl.contains(text.toLowerCase()) || currentPageHeadingText.contains(text.toLowerCase()))
                    {
                        isClickOnAllLinksInSequence &=true;
                        Utils.logStepInfo(isClickOnAllLinksInSequence,"After clicking on " + text + " Current URL is " + currentURl+" and current page heading is ");
                    }
                }
                else if(currentURl.contains(text.toLowerCase()))
                {
                    isClickOnAllLinksInSequence &=true;
                    Utils.logStepInfo(isClickOnAllLinksInSequence,currentURl+" contains "+text);
                }

            }
        } catch (Exception e) {
            isClickOnAllLinksInSequence = false;
            Utils.logStepInfo(false, "clickOnAllLinksInSequence is failed.");
            e.printStackTrace();
        }
        return isClickOnAllLinksInSequence;
    }
}