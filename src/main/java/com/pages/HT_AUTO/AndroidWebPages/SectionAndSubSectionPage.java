package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonSectionAndSubSectionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SectionAndSubSectionPage extends CommonSectionAndSubSectionPage {
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
    private static WebElement autoNewsExpand;
    @FindBy(xpath = "//div[@class='subnavArrow']/img")
    private static WebElement autoNewsArrwBtn;
    @FindBy(xpath = "//ul[@class='clearfix']/li/a")
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
    @FindBy(xpath = "//nav[@id='leftNav']/a")
    private static List<WebElement> sectionElementList;
    @FindBy(xpath = "//nav[@id='SecLeftNav']/a")
    private static List<WebElement> subSectionElementList;
    @FindBy(xpath = "//div[contains(@class,'icoShare')]")
    private static List<WebElement> storyButtons;
    @FindBy(id = "topic_Bike News")
    private static WebElement bikeNews;
    @FindBy(id = "topic_Auto News")
    private static WebElement autoNews;
    @FindBy(id = "topic_Photos")
    private static WebElement photosNews;
    @FindBy(id = "topic_Videos")
    private static WebElement videosNews;
    @FindBy(id = "topic_Electric Vehicles")
    private static WebElement electricVehicle;
    @FindBy(id = "topic_Trending")
    private static WebElement trendingNews;
    @FindBy(className = "headlineSec")
    private static List<WebElement> headLines;
    @FindBy(xpath = "//section[@class='mainSec']//h1")
    private static WebElement linkPageHeading;
    @FindBy(xpath = "//ul[@class='navCategories'][1]/li")
    private static List<WebElement> topSectionsList;
    @FindBy(xpath = "//ul[@class='navCategories'][2]/li")
    private static List<WebElement> exploreAutoList;


    public SectionAndSubSectionPage() {
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
    public boolean checkSectionAndSubSection(String hambuger, String notific, String autoN, String findC, String findB, String comC, String comB, String emi, String fastAg,String urlSubString) {
        boolean isElementPresent;
        boolean isHamburgerMenuAvailable = true;
        boolean isAllLinksAreClickableOfHamburger = true;
        boolean isAllSectionClickable = true;
        boolean isAllSubsectionClickable = true;
        boolean isPaginationTrue = true;

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        isHamburgerMenuAvailable &= commonFunctionsMobile.isElementDisplayed(hamburgerMenu, 20, hambuger);
        isHamburgerMenuAvailable &= commonFunctionsMobile.isElementClickable(hamburgerMenu, 20, hambuger);
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 10, hambuger);
        isAllLinksAreClickableOfHamburger &= commonFunctionsMobile.clickElementWithActions(singInButton, 30, "Sign In button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctionsMobile.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctionsMobile.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctionsMobile.closeAllWindowsExceptMasterTab();
        commonFunctionsMobile.pageRefresh();
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, hambuger);
        isAllLinksAreClickableOfHamburger &= commonFunctionsMobile.clickElementWithJS(searchBtn, 20, "SearchButton");
        commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 10, hambuger);
        isAllLinksAreClickableOfHamburger &= commonFunctionsMobile.clickElementWithJS(notification, 10, notific);
        isAllLinksAreClickableOfHamburger &= clickOnAllLinksInSequenceInsideAutoNews(autoNewsList, hamburgerMenu, autoNewsArrwBtn,hambuger);

        isAllLinksAreClickableOfHamburger &= clickOnAllLinksInSequenceInsideAutoNews(autoNewsList, hamburgerMenu,autoNewsArrwBtn, hambuger);
        isAllLinksAreClickableOfHamburger &= clickOnAllLinksInSequence(topSectionsList, hamburgerMenu, hambuger);
        isAllLinksAreClickableOfHamburger &= clickOnAllLinksInSequence(exploreAutoList, hamburgerMenu, hambuger);

        isAllSectionClickable &= commonFunctionsMobile.getElementsClickable(sectionElementList, 30, "Section Elements");
        isAllSubsectionClickable &= commonFunctionsMobile.getElementsClickable(subSectionElementList, 30, "Subsection Elements");
        commonFunctionsMobile.navigateToHomePage();
        commonFunctionsMobile.clickElementWithJS(bikeNews, 30, "Subsection Element");
        commonFunctionsMobile.innerScrollLeftToRightForListOfElement(sectionElementList, 30, "Section elements");
        commonFunctionsMobile.innerScrollLeftToRightForListOfElement(subSectionElementList, 30, "Subsection element");
        commonFunctionsMobile.getElementsClickable(storyButtons, 50, "All the stories button on the Section and Subsection page");
        isPaginationTrue &= scrollToCheckPagination1(headLines, bikeNews, urlSubString);
        isPaginationTrue &= scrollToCheckPagination1(headLines, autoNews, urlSubString);
        isPaginationTrue &= scrollToCheckPagination1(headLines, photosNews, urlSubString);
        isPaginationTrue &= scrollToCheckPagination1(headLines, videosNews, urlSubString);
        isPaginationTrue &= scrollToCheckPagination1(headLines, electricVehicle, urlSubString);
        isPaginationTrue &= scrollToCheckPagination1(headLines, trendingNews, urlSubString);

        return isAllSubsectionClickable && isPaginationTrue && isAllLinksAreClickableOfHamburger && isAllSectionClickable && isHamburgerMenuAvailable;
    }

    public boolean clickOnAllLinksInSequenceInsideAutoNews(List<WebElement> eleList, WebElement hamburgerMenu, WebElement autoNewsArrwBtn,String hambuger) {
        boolean isClickOnAllLinksInSequenceInsideAutoNews = true;
        WebElement ele;

        try {
            for (int i=0;i<eleList.size();i++) {
                isClickOnAllLinksInSequenceInsideAutoNews &=commonFunctionsMobile.clickElementWithJS(hamburgerMenu, 20, hambuger);
                isClickOnAllLinksInSequenceInsideAutoNews &=commonFunctionsMobile.clickElementWithJS(autoNewsArrwBtn,20,"arrow expander");
                ele=eleList.get(i);
                String text= commonFunctionsMobile.getElementText(ele,20);
                commonFunctionsMobile.clickElementWithJS(ele,20,text);
                String currentURl = commonFunctionsMobile.getCurrentURL();
                String currentPageHeadingText=commonFunctionsMobile.getElementText(linkPageHeading,30);
                if(!(currentPageHeadingText.isEmpty()))
                {
                    if(currentURl.contains(text.toLowerCase()) || currentPageHeadingText.contains(text.toLowerCase()))
                    {
                        isClickOnAllLinksInSequenceInsideAutoNews &=true;
                        Utils.logStepInfo(isClickOnAllLinksInSequenceInsideAutoNews,"After clicking on " + text + " Current URL is " + currentURl+" and current page heading is "+currentPageHeadingText);
                    }
                }
                else if(currentURl.contains(text.toLowerCase()))
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
                String text= commonFunctionsMobile.getElementText(ele,20);
                commonFunctionsMobile.clickElementWithJS(ele,20,text);
                String currentURl = commonFunctionsMobile.getCurrentURL();
                String currentPageHeadingText=commonFunctionsMobile.getElementText(linkPageHeading,30);

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

    public boolean scrollToCheckPagination1(List<WebElement> eleList, WebElement element, String page) {
        boolean isScrollToCheckPaginationTrue = false;
        String currentUrl = null;
        String elementText = null;
        boolean isSrollTrue;
        Actions actions;

        try {
            commonFunctionsMobile.navigateToHomePage();
            boolean isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
            if (isElementPresent) {
                commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
            }
            elementText = element.getText().trim();
            actions = new Actions(driver);
            commonFunctionsMobile.clickElementWithJS(element, 20, elementText + " name Subsection element");
            for (WebElement ele : eleList) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
                actions.moveToElement(ele).build().perform();
                currentUrl = commonFunctionsMobile.getCurrentURL();
                if (currentUrl.contains(page) && ele.isDisplayed())//      "/page-"
                {
                    isScrollToCheckPaginationTrue = true;
                    Utils.logStepInfo(true, "Pagination is working for " + elementText + " section.");
                    break;
                }
            }
        } catch (Exception e) {
            isScrollToCheckPaginationTrue = false;
            Utils.logStepInfo(false, "Pagination is not working for " + elementText + " section.");
            e.printStackTrace();
        }
        return isScrollToCheckPaginationTrue;
    }
}