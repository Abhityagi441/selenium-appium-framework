package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonWebStoriesPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WebStoriesPage extends CommonWebStoriesPage {

        private static WebDriver driver;
        private static GlobalVars globalVars;
        private static CommonFunctionsWeb commonFunctions;
        private static CommonFunctionsWebLM commonFunctionsWebLM;



        public WebStoriesPage() {
                globalVars = GlobalVars.getInstance();
                driver = globalVars.getWebDriver();
                globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                PageFactory.initElements(driver, this);
                commonFunctions = CommonFunctionsWeb.getInstance();
                commonFunctionsWebLM=CommonFunctionsWebLM.getInstance();
                System.out.println("****************** Test started ******************");
                System.out.println("******************" + globalVars.getProjectName() + "******************");
        }


        @FindBy(xpath = "//nav[@class='navNew']")
        private static WebElement navVisibility;

        @FindBy(xpath = "//*[@id='fixedNav_web stories']")
        private static WebElement webStoriesClick;

        @FindBy(xpath = "//div[@id='lhsgainerloser']")
        private static WebElement gainerLooserWidgets;

        @FindBy(xpath = "//div[@id='lhsyearhighlow']")
        private static WebElement highLowWidgets;

        @FindBy(xpath = "//div[@id='lastBlock']")
        private static WebElement activeStocksWidget;

        @FindBy(xpath = "//a[@id='fixedNav_home']")
        private static WebElement homeNav;
        @FindBy(xpath = "//a[@id='fixedNav_latest']")
        private static WebElement latestNav;
        @FindBy(xpath = "//a[@id='fixedNav_news']")
        private static WebElement newsnav;

        @FindBy(xpath = "//a[@id='fixedNav_markets']")
        private static WebElement marketsNav;

        @FindBy(xpath = "//a[@id='fixedNav_premium']")
        private static WebElement premiumNav;

        @FindBy(xpath = "//a[@id='fixedNav_money']")
        private static WebElement moneyNav;

        @FindBy(xpath = "//a[@id='fixedNav_mutual fund']")
        private static WebElement mutualFundsNav;

        @FindBy(xpath = "//a[@id='fixedNav_industry']")
        private static WebElement industryNav;

        @FindBy(xpath = "//a[@id='fixedNav_companies']")
        private static WebElement companiesNav;

        @FindBy(xpath = "//a[@id='fixedNav_technology']")
        private static WebElement technologyNav;

        @FindBy(xpath = "//a[@id='fixedNav_opinion']")
        private static WebElement opinionNav;

        @FindBy(xpath = "//a[@id='fixedNav_web stories']")
        private static WebElement webStoriesNav;

        @FindBy(xpath = "//div[@id='hamburgerElement']")
        private static WebElement exploreIcon;

        @FindBy(xpath = "//div[@onclick='topSearch()']")
        private static WebElement searchIcon;

        @FindBy(xpath = "//a[@href='/notifications']")
        private static WebElement notificationBellIcon;

        @FindBy(xpath = "//a[@id='ePaperIconId']")
        private static WebElement epaperIcon;

        @FindBy(xpath = "//div[@id='hamburgerElement']")
        private static WebElement signInCTA;

        @FindBy(xpath = "//a[@title='mint']")
        private static WebElement pageTitle;

        @Override
        public boolean checkWebStoriesLandingPage() {
                commonFunctions.navigateToURL(globalVars.getProdUrl());
                boolean isShowing=commonFunctions.isElementDisplayed(navVisibility, 10, "Header visibility");
                isShowing &=commonFunctions.clickElementWithJS(webStoriesClick, 10, "Web stories Should be clickable");
                return isShowing;

        }
        @Override
        public boolean checkLHSOnWebStoriesLandingPage(){
                commonFunctions.navigateToURL(globalVars.getProdUrl());
                boolean isShowing=commonFunctions.clickElementWithJS(webStoriesClick, 10, "Web stories Should be clickable");
                commonFunctions.waitForPageLoading();
                 isShowing &=commonFunctions.isElementDisplayed(gainerLooserWidgets,10,"Gainer looser widgets visibility");
                isShowing &=commonFunctions.isElementDisplayed(highLowWidgets,10,"52 week high low widgets");
                isShowing &=commonFunctions.isElementDisplayed(activeStocksWidget,10,"Active Stocks Widget Visibility");
                return isShowing;
        }

        @Override
        public boolean checkL1NavOnWebStoriesPage(){
                commonFunctions.navigateToURL(globalVars.getProdUrl());
                commonFunctions.clickElementWithJS(webStoriesClick, 10, "Web stories Should be clickable");
                commonFunctions.waitForPageLoading();
                boolean l1Visibility=commonFunctionsWebLM.checkL1NavMenu(pageTitle,homeNav,latestNav,newsnav,marketsNav,premiumNav,moneyNav,mutualFundsNav,industryNav,companiesNav,technologyNav,opinionNav,webStoriesNav);
                return l1Visibility;
        }
        @Override
        public boolean checkWebStoriesPageLayout(){
                commonFunctions.navigateToURL(globalVars.getProdUrl());
                boolean isShowing=commonFunctions.clickElementWithJS(webStoriesClick, 10, "Web stories Should be clickable");
                isShowing &=commonFunctions.isElementDisplayed(exploreIcon,10,"explore icon visibility");
                isShowing &=commonFunctions.isElementDisplayed(searchIcon,10,"search icon visibility");
                isShowing &=commonFunctions.isElementDisplayed(notificationBellIcon,10,"notification bell icon visibility");
                isShowing &=commonFunctions.isElementDisplayed(epaperIcon,10,"epaper icon visibility");
                return isShowing;
        }
}


