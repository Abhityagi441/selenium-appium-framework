package com.pages.HindustanTimes.android_amp;

import com.pages.HindustanTimes.commonFunctions.CommonFunctionsWebHt;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BreadCrumbsPage extends CommonBreadCrumbsPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebHt commonFunctionsWebHt;


    public BreadCrumbsPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWebHt =CommonFunctionsWebHt.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @FindBy(xpath = "//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "//a[text()='Most Read']")
    private static WebElement popularStory;

    @FindBy(xpath = "//div[@class='container']//button")
    private static WebElement hamBurger;

    @FindBy(xpath = "//div[@class = 'btnExplore']/button")
    private static WebElement exploreButton;

    @FindBy(xpath = "//section[@class = 'mainContainer ']/div[2]")
    private static WebElement breadCrumbsName;
    @FindBy(css = ".navIco")
    private static WebElement explore;
    @FindBy(xpath = "(//a[contains(@data-id,'cities')])[1]")
    private static WebElement hamburgerCities;
    @FindBy(xpath = "(//a[contains(@data-id,'cricket')])[1]")
    private static WebElement hamburgerCricket;
    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[3]/a")
    private static WebElement india;
    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbName;
    @FindBy(xpath = "//div[@class='breadcrumbs']//a")
    private static WebElement breadCrumbsHome;
    @FindBy(id = "deny")
    private static WebElement doItLater;
    @FindBy(xpath = "//a[contains(@data-id,'Latest')]")
    private static WebElement latest;

    @FindBy(xpath = "//div[@class='nav-sec']//li[2]/a")
    private static WebElement indiaNews;

    @FindBy(xpath = "//a[@href = '/cricket']")
    private static WebElement cricket;

    @FindBy(xpath="(//button[@class='subscribe'])[1]")
    private static WebElement doThisLaterButton;

    @FindBy(xpath = "//input[@type='search']")
    private static WebElement googleSearchInputBox;

    @FindBy(xpath = "//a[contains(@data-amp,'india-news')]/div[contains(text(),'India News')]")
    private static WebElement indiaNewsGoogleSearchResult;

    @FindBy(xpath = "//section[contains(@Class,'mainContainer')]/div[@class='breadcrumbs'][contains(.,'India News')]")
    private static WebElement indiaNewsBreadcrumbOnStoryDetail;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[10]/a")
    private static WebElement editorials;

    @FindBy(xpath = "//em[text()='Cities']")
    private static WebElement cities;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[6]//a")
    private static WebElement entertainment;

    @FindBy(xpath = "//ul[@class='leftFixedNav']/li/a")
    private static WebElement redirectToHomepage;


    public boolean breadCrumbIndiaNews(WebElement element,String home) {
        commonFunctions.clickElementWithJS(hamBurger,20,"Hamburger clicked");
        commonFunctions.clickElementWithJS(element, 20, "india-news");
        boolean isBreadCrumbsNameDisplayed = commonFunctions.isElementDisplayed(breadCrumbsName,20);
        if(isBreadCrumbsNameDisplayed) {
            Utils.logStepInfo(true, "IndiaNews BreadCrumb available");
        } else {
            Utils.logStepInfo(false, "IndiaNews BreadCrumb not available");
        }
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean checkIndiaNewsURL(){
        String currentURL = commonFunctions.getCurrentURL("URL","india-news URL successful");
         return currentURL.contains("india-news");
    }

    public boolean redirectToHomepageFromInd(WebElement element){
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL","India News URL successful");
        return currentURL.equalsIgnoreCase(globalVars.getAmpUrl());
    }

    public boolean breadCrumbNews(WebElement element, String home){
        commonFunctions.clickElementWithJS(element,20,"clicked on element");
        boolean isBreadCrumbsNameDisplayed = commonFunctions.isElementDisplayed(breadCrumbsName,20);
        if(isBreadCrumbsNameDisplayed) {
            Utils.logStepInfo(true, "Latest BreadCrumb available");
        } else {
            Utils.logStepInfo(false, "Latest BreadCrumb not available");
        }
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean checkLatestNewsURL(){
        String currentURL = commonFunctions.getCurrentURL("URL","latest-news URL successful");
        return currentURL.contains("latest-news");
    }

    public boolean redirectToHomepage(WebElement element){
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL","Latest News URL successful");
        return currentURL.equals(globalVars.getAmpUrl());
    }

    public boolean breadCrumbPopularStory(WebElement element,String home){
        commonFunctions.clickElement(element,20,"Most Read");
        boolean isBreadCrumsNameDisplayed = commonFunctions.isElementDisplayed(breadCrumbsName,20);
        if(isBreadCrumsNameDisplayed) {
            Utils.logStepInfo(true, "popular BreadCrumb available");
        } else {
            Utils.logStepInfo(false, "popular BreadCrumb not available");
        }
        String crumbvalue=commonFunctions.getElementText(breadCrumbsName,10).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean checkPopularNewsURL(){
        String currentURL = commonFunctions.getCurrentURL("URL","popular-news URL successful");
       return currentURL.contains("mostpopular");
    }


    public boolean redirectToHomepageFromPopular(WebElement element){
        commonFunctions.clickElement(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL","Latest News URL successful");
        return currentURL.equals(globalVars.getAmpUrl());
    }

    public boolean breadCrumbCricketNews(String home){
        commonFunctions.clickElementWithJS(exploreButton,20,"Explore icon clicked");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(cricket,20,"Cricket");
        boolean isBreadCrumbsNameDisplayed = commonFunctions.isElementDisplayed(breadCrumbsName,20,"breadCrumbs Name");
        commonFunctions.getElementText(breadCrumbsName,10);
        if(isBreadCrumbsNameDisplayed) {
            Utils.logStepInfo(true, "Cricket BreadCrumb available");
        } else {
            Utils.logStepInfo(false, "Cricket BreadCrumb not available");
        }
        String crumbValue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbValue.equalsIgnoreCase(home);
    }


    public boolean checkCricketNewsURL(){
        String currentURL = commonFunctions.getCurrentURL("URL","cricket-news URL successful");
        return currentURL.contains("cricket");
    }


    public boolean redirectToHomepageFromCricket(WebElement element){
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL","cricket News URL successful");
       return currentURL.equals(globalVars.getAmpUrl());
    }


    public boolean checkEditorialNewsURL(){
        String currentURL = commonFunctions.getCurrentURL("URL","editorial-news URL successful");
       return currentURL.contains("editorials");
    }


    public boolean redirectToHomepageFromEdit(WebElement element){
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL","Editorial News URL successful");
       return currentURL.equals(globalVars.getAmpUrl());
    }


    public boolean breadCrumbEntertainmentNews(WebElement element,String home){
        commonFunctions.clickElementWithJS(hamBurger,20,"Explore icon");
        commonFunctions.scrollToElementViewAndClick(element,20,"entertainment");
        boolean isBreadCrumbsNameDisplayed = commonFunctions.isElementDisplayed(breadCrumbsName,20);
        if(isBreadCrumbsNameDisplayed) {
            Utils.logStepInfo(true, "Entertainment BreadCrumb available");
        } else {
            Utils.logStepInfo(false, "Entertainment BreadCrumb not available");
        }
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }


    public boolean checkEntertainmentNewsURL(){
        String currentURL = commonFunctions.getCurrentURL("URL","entertainment-news URL successful");
        return currentURL.contains("entertainment");
    }


    public boolean redirectToHomepageEnt(WebElement element){
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL","entertainment News URL successful");
       return currentURL.equals(globalVars.getAmpUrl());
    }

    public boolean breadCrumbCitiesNews(WebElement element, String home){
        commonFunctions.clickElementWithJS(hamBurger,20,"Explore icon clicked");
        commonFunctions.clickElementWithJS(element,20,"clicked on cities");
        boolean isBreadCrumbsNameDisplayed = commonFunctions.isElementDisplayed(breadCrumbsName,20);
        if(isBreadCrumbsNameDisplayed) {
            Utils.logStepInfo(true, "Cities BreadCrumb available");
        } else {
            Utils.logStepInfo(false, "Cities BreadCrumb not available");
        }
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }


    public boolean checkCitiesNewsURL(){
        String currentURL = commonFunctions.getCurrentURL("URL","cities-news URL successful");
         return currentURL.contains("cities");
    }


    public boolean redirectToHomepageCity(WebElement element){
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL","cities News URL successful");
        return currentURL.equals(globalVars.getAmpUrl());
    }

    @Override
    public boolean breadcrumbDisplayedOtherThanHomePage() {return false; }

    @Override
    public boolean checkNavigationIndiaNews() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing= commonFunctions.clickElementWithJS(india, 10, "India News");
        String Breadcrumb= commonFunctions.getElementText(breadCrumbName, 20);
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("India News");;
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("india-news", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadCrumbsHome, 15, "Breadcrumb Home");
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbName, 15, "Redirected to Homepage");
        return isShowing & Breadcrumbs;
    }

    @Override
    public boolean checkNavigationPopularNews() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean popularNews=breadCrumbPopularStory(popularStory,"Home / Most Popular");
        boolean newsUrl=checkPopularNewsURL();
        boolean popularHome =redirectToHomepageFromPopular(redirectToHomepage);

        return popularHome && newsUrl&& popularNews;
    }

    @Override
    public boolean checkNavigationCricketNews() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing= commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.clickElementWithJS(hamburgerCricket, 15, "Cricket in explore menu");
        String Breadcrumb= commonFunctions.getElementText(breadCrumbName, 20);
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("Cricket");;
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("cricket", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadCrumbsHome, 15, "Breadcrumb Home");
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");
        return isShowing & Breadcrumbs;
    }

    @Override
    public boolean checkNavigationEditorialNews() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing =commonFunctions.clickElementWithJS(editorials, 15, "Editorials");
        String Breadcrumb= commonFunctions.getElementText(breadCrumbName, 20).trim();
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("Editorials");;
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("editorials", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadCrumbsHome, 15, "Breadcrumb Home");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");
        return isShowing & Breadcrumbs;
    }

    @Override
    public boolean checkNavigationEntertainmentNews() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing= commonFunctions.clickElementWithJS(entertainment, 10, "Entertainment");
        String Breadcrumb= commonFunctions.getElementText(breadCrumbName, 20);
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("Entertainment");;
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("entertainment", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadCrumbsHome, 15, "Breadcrumb Home");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");;
        return isShowing & Breadcrumbs;
    }

    @Override
    public boolean checkNavigationCitiesNews() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        commonFunctions.clickElementIfDisplayed(doItLater, 10, "Later Popup");
        boolean isShowing= commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &=commonFunctions.clickElementWithJS(hamburgerCities, 15, "Cities in explore menu");
        String Breadcrumb= commonFunctions.getElementText(breadCrumbName, 20);
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("Cities");;
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("cities", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadCrumbsHome, 15, "Breadcrumb Home");
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");;
        return isShowing & Breadcrumbs;
    }

    @Override
    public boolean checkBreadcrumbVisible() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Do this later button on push notification");
        boolean popularNews = breadCrumbCricketNews("Home / Cricket");
        boolean newsUrl = checkCricketNewsURL();
        redirectToHomepageFromCricket(redirectToHomepage);
        return popularNews && newsUrl;
    }

    @Override
    public boolean checkBreadcrumbVisibleWhenUserLandsFromGoogleEtc(String googleUrl, String searchText) {
        return false;
    }

    @Override
    public boolean checkBreadcrumbVisibleViaGoogle() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL("https://www.google.co.in");
        searchViaGoogle("hindustan times india news");
        boolean breadcrumbDisplayed=commonFunctions.isElementDisplayed(indiaNewsBreadcrumbOnStoryDetail,20,"India News BreadCrumb displayed");
        String currentURL=commonFunctions.getCurrentURL();
        boolean currentURLValidation=false;
        if(currentURL.contains("india-news")){
            currentURLValidation=true;
        }
        return currentURLValidation && breadcrumbDisplayed;
    }

    @Override
    public boolean checkBreadcrumbAndClickRedirection() {
        return false;
    }

    public void searchViaGoogle(String term){
        commonFunctions.pageRefresh();
        commonFunctions.isElementDisplayed(googleSearchInputBox,10,"Google search box");
        commonFunctions.clickElementWithJS(googleSearchInputBox,10,"Google SearchBox");
        commonFunctions.sendKey(googleSearchInputBox,term);
        googleSearchInputBox.submit();
        commonFunctions.isElementDisplayed(indiaNewsGoogleSearchResult,20,"Wait for India News to be displayed");
        commonFunctions.clickElementWithJS(indiaNewsGoogleSearchResult,10,"India News google result");
    }

    @Override
    public boolean checkNavigationLatestNews() {
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean isShowing =commonFunctions.clickElementWithJS(latest, 15, "Latest");
        String Breadcrumb= commonFunctions.getElementText(breadCrumbName, 20).trim();
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("Latest");;
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("latest-news", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadCrumbsHome, 15, "Breadcrumb Home");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");
        return isShowing & Breadcrumbs;

    }

}
    


