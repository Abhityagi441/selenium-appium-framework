
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BreadCrumbsPage extends CommonBreadCrumbsPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "//a[contains(@data-id,'Entertainment')]")
    private static WebElement entertainment;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//ul[@class='leftFixedNav']/li[2]/a")
    private static WebElement latestNews;

    @FindBy(xpath = "//ul[@class='leftFixedNav']/li[4]/a")
    private static WebElement worldNews;

    @FindBy(xpath = "//strong[text()='Explore']")
    private static WebElement exploremenu;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "//a[contains(@data-id,'India')]")
    private static WebElement indiaNews;

    @FindBy(xpath = "//a[contains(@data-id,'Cricket')]")
    private static WebElement cricket;

    @FindBy(xpath = "//a[contains(text(),'Cricket')]")
    private static WebElement cricketBreadcrumb;

    @FindBy(xpath = "//h1[normalize-space()='Cricket']")
    private static WebElement cricketPageHeader;

    @FindBy(xpath = "//a[text()='Editorials']")
    private static WebElement editorials;

    @FindBy(xpath = "//li[@class='collapse'][2]//a")
    private static WebElement cities;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;

    @FindBy(xpath = "//input[@title='Search']")
    private static WebElement googleSearchBox;
    @FindBy(xpath = "(//input[@name='btnK'])[2]")
    private static WebElement googleSearchButton;
    @FindBy(xpath = "//div[@id='rso']/div[1]")
    private static WebElement googleSearchResultList;
    @FindBy(partialLinkText = "India News")
    private static WebElement googleSearchIndiaNews;
    @FindBy(xpath = "//div[@class='breadcrumbs']/a")
    private static WebElement homeBreadCrumbs;


    public BreadCrumbsPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean breadcrumbDisplayedOtherThanHomePage() {
        return true;
    }

    public boolean breadCrumbLatestNews(WebElement element, String home, String category) {
        commonFunctions.clickElement(element, 20, "clicked on " + category);
        commonFunctions.isElementDisplayed(breadCrumbsName, 10);
        Utils.logStepInfo(true, "Latest BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean breadCrumbEditorialNews(WebElement element, String home, String category) {
        commonFunctions.clickElement(element, 20, "clicked on " + category);
        commonFunctions.isElementDisplayed(breadCrumbsName, 10);
        Utils.logStepInfo(true, "Editorials BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean breadCrumbPopularStory(WebElement element, String home, String category) {
        commonFunctions.clickElement(element, 10, "clicked on " + category);
        commonFunctions.isElementDisplayed(breadCrumbsName, 10);
        Utils.logStepInfo(true, "WorldNews BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 10).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean redirectToHomepageFromCategories(WebElement element, String category) {
        commonFunctions.clickElement(element, 10, "Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL(category + " News URL successful");
        String urlVariable = globalVars.getEnvironment() + "Url";
        if (urlVariable == "stgUrl"){
            return currentURL.equals(globalVars.getStgUrl());
        }
        else {
            return currentURL.equals(globalVars.getURL());
        }
    }

    public boolean checkCatogeriesNewsURL(String category) {
        String currentURL = commonFunctions.getCurrentURL(category + " news URL successful");
        String urlVariable = globalVars.getEnvironment() + "Url";
        if (urlVariable == "stgUrl"){
            return currentURL.equals(globalVars.getStgUrl() + category);
        }
        else {
            return currentURL.equals(Utils.getUrl() + category);
        }

    }

    public boolean breadCrumbCategoriesNews(WebElement element,String home, String category) {
        //commonFunctions.clickElement(exploremenu,20,"Explore icon");
        commonFunctions.clickElementWithActions(element,20,"clicked on " + category);
        commonFunctions.isElementDisplayed(breadCrumbsName,20);
        Utils.logStepInfo(true, category +" BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean breadCrumbCricketNews(WebElement element,String home, String category) {
        commonFunctions.clickElementWithActions(element,20,"clicked on " + category);
        commonFunctions.isElementDisplayed(breadCrumbsName,20);
        Utils.logStepInfo(true, category +" BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    @Override
    public boolean checkNavigationIndiaNews() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean breadIndia = breadCrumbCategoriesNews(indiaNews, "Home / India News", "india news");
        boolean newsURL = checkCatogeriesNewsURL("india-news");
        boolean homepageIndia = redirectToHomepageFromCategories(redirectToHomepage, "india news");

        return breadIndia && newsURL && homepageIndia;
    }

    @Override
    public boolean checkNavigationPopularNews() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean popularStoryNews = breadCrumbPopularStory(worldNews, "Home / World News", "worldnews");
        boolean newsUrl = checkCatogeriesNewsURL("world-news");
        boolean popularNews = redirectToHomepageFromCategories(redirectToHomepage, "worldnews");

        return popularNews && newsUrl && popularStoryNews;
    }

    @Override
    public boolean checkNavigationCricketNews(){
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean cricketNews = breadCrumbCricketNews(cricket, "Home / Cricket", "cricket");
        boolean newsUrl = checkCatogeriesNewsURL("cricket");
        boolean homepageCricket = redirectToHomepageFromCategories(redirectToHomepage, "cricket");

        return cricketNews && newsUrl && homepageCricket;
    }
    @Override
    public boolean checkNavigationLatestNews() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean latestNewsBol = breadCrumbLatestNews(latestNews, "Home / Latest News", "latest-news");
        boolean newsUrl = checkCatogeriesNewsURL("latest-news");
        boolean homepageLatest = redirectToHomepageFromCategories(redirectToHomepage, "latest-news");

        return latestNewsBol && newsUrl && homepageLatest;
    }

    @Override
    public boolean checkBreadcrumbVisible() {
       commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(cricketBreadcrumb, 20, "Cricket BreadCrumb");
        boolean isBreadCrumbDisplayed=commonFunctions.isElementDisplayed(cricketPageHeader, 10, "Cricket Page Header");
        commonFunctions.dummyWait(10);
        commonFunctions.navigateToHomePage();
        return isBreadCrumbDisplayed;
    }

    @Override
    public boolean checkBreadcrumbVisibleWhenUserLandsFromGoogleEtc(String googleUrl, String searchText) {
       commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(googleUrl);
        commonFunctions.dummyWait(10);
        commonFunctions.sendKeyBoolean(googleSearchBox,searchText,30,"Google search box");
        commonFunctions.sendKeysWithEnter(googleSearchBox,30);
        commonFunctions.isElementDisplayed(googleSearchResultList, 20, "Google Search Results");
        commonFunctions.isElementDisplayed(googleSearchIndiaNews, 20, "India News Google Search");
        commonFunctions.clickElement(googleSearchIndiaNews, 30,"click on India News search Link");
        commonFunctions.pageRefresh();
        commonFunctions.waitForPageLoad();
        String GoogleSearchUrl=commonFunctions.getCurrentURL();
        boolean isBreadcrumbVisibleWhenUserLandsFromGoogleEtcTrue =commonFunctions.checkTextContains("india-news", GoogleSearchUrl, "India-News BreadCrumb Url");
        return isBreadcrumbVisibleWhenUserLandsFromGoogleEtcTrue;
    }

    @Override
    public boolean checkBreadcrumbVisibleViaGoogle() {
        return false;
    }

    @Override
    public boolean checkNavigationEditorialNews(){
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean editorialNews = breadCrumbEditorialNews(editorials, "Home / Editorials", "editorial");
        boolean newsUrl = checkCatogeriesNewsURL("editorials");
        boolean editorialHome = redirectToHomepageFromCategories(redirectToHomepage, "editorial");

        return editorialNews && newsUrl && editorialHome;
    }

    @Override
    public boolean checkNavigationEntertainmentNews() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean entertainmentNews = breadCrumbCategoriesNews(entertainment, "Home / Entertainment", "entertainment");
        boolean entertainmentUrl = checkCatogeriesNewsURL("entertainment");
        boolean homeEntertainment = redirectToHomepageFromCategories(redirectToHomepage, "entertainment");

        return entertainmentNews && entertainmentUrl && homeEntertainment;
    }

    @Override
    public boolean checkNavigationCitiesNews() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean citiesNews = breadCrumbCategoriesNews(cities, "Home / Cities", "cities");
        boolean citiesUrl = checkCatogeriesNewsURL("cities");
        boolean citiesHome = redirectToHomepageFromCategories(redirectToHomepage, "cities");
        return citiesNews && citiesUrl && citiesHome;
    }

    @Override
    public boolean checkBreadcrumbAndClickRedirection() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(indiaNews, 20, "L1: India");
        commonFunctions.clickElement(indiaNews, 10, "L1: India");
        isShowing &= commonFunctions.isElementDisplayed(breadCrumbsName, 10, "breadCrumbs Name");
        commonFunctions.clickElement(homeBreadCrumbs, 10, "BreadCrumbs: Home");
        if (isShowing &= commonFunctions.getCurrentURL().equals(globalVars.getURL())) {
            isShowing &= true;
            Utils.logStepInfo(true, "Home page displayed successfully");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "Home page Not displayed verification Failed");
        }
        return isShowing;
    }

}
