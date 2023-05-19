package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsWebHt;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BreadCrumbsPage extends CommonBreadCrumbsPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebHt commonFunctionsWebHt;

    @FindBy(xpath = "//a[text()='Entertainment']")
    private static WebElement entertainment;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//li//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "//a[text()='My Reads']")
    private static WebElement popularStory;

    @FindBy(xpath = "//div[@class='btnExplore']/button")
    private static WebElement hamBurger;
    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[3]/a")
    private static WebElement india;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbName;
    @FindBy(xpath = "//div[@class='breadcrumbs']/a")
    private static WebElement breadCrumbsHome;

    /*@FindBy(xpath = "//li//a/em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(xpath = "//div/a[@data-id='cricket,10']")
    private static WebElement cricket;

    @FindBy(xpath = "//li/a/em[text()='Editorials']")
    private static WebElement editorials;

    @FindBy(xpath = "//div/a/em[text()='Cities']")
    private static WebElement cities;*/

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;

    @FindBy(xpath = "//a[text()='India']")
    private static WebElement indiaNews;

    @FindBy(xpath = "//a[text()='Cricket']")
    private static WebElement cricket;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[10]/a")
    private static WebElement editorials;

    @FindBy(xpath = "//ul[@class='leftFixedNav']/li[5]/a")
    private static WebElement cities;

    @FindBy(xpath = "(//a[contains(@data-id,'cities')])[1]")
    private static WebElement hamburgerCities;
    @FindBy(xpath = "(//a[contains(@data-id,'cricket')])[1]")
    private static WebElement hamburgerCricket;
    @FindBy(xpath = "//a[contains(@data-id,'Latest')]")
    private static WebElement latest;

    @FindBy(css = ".navIco")
    private static WebElement explore;

    @FindBy(xpath = "(//div[@class='storyAd'])[1]")
    private static WebElement homeAdv;


    public BreadCrumbsPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWebHt =CommonFunctionsWebHt.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
    public boolean redirectToHomepageFromCategories(WebElement element, String category) {
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        commonFunctions.isElementPresent(homeAdv, 10, "HomePage Adv ");
        String currentURL = commonFunctions.getCurrentURL("URL",category + " news URL successful");
        Utils.logStepInfo(currentURL);
        return currentURL.equals(globalVars.getAmpUrl());

    }

    public boolean checkCatogeriesNewsURL(String category){
        String currentURL = commonFunctions.getCurrentURL("URL",category + " news URL successful");
        Utils.logStepInfo(currentURL);
        return currentURL.contains(category);
    }

    public boolean breadCrumbCategoriesNews(WebElement element,String home, String category) {

        commonFunctions.clickElementWithJS(element,10,"clicked on "+category);
        commonFunctions.scrollToElementViewAndClick(element,10," on "+category);
        commonFunctions.isElementDisplayed(breadCrumbName,10);
        Utils.logStepInfo(true, category +" BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }
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
        commonFunctions.dummyWait(4);
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");
        return isShowing & Breadcrumbs;
    }

    @Override
    public boolean breadcrumbDisplayedOtherThanHomePage() {return false;}

    public boolean checkNavigationPopularNews()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
    	boolean popularStoryNews=breadCrumbCategoriesNews(popularStory, "Home / Most Popular","mostpopular");
        boolean newsUrl=checkCatogeriesNewsURL("mostpopular");
        boolean popularNews =redirectToHomepageFromCategories(redirectToHomepage,"mostpopular");

        return popularNews && newsUrl && popularStoryNews;
    }

    public boolean checkNavigationCricketNews(){
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
    public boolean checkNavigationLatestNews(){
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

    @Override
    public boolean checkBreadcrumbVisible() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbVisibleWhenUserLandsFromGoogleEtc(String googleUrl, String searchText) {
        return false;
    }
    @Override
    public boolean checkBreadcrumbVisibleViaGoogle() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbAndClickRedirection() {
        return false;
    }

    public boolean checkNavigationEditorialNews(){
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
        commonFunctions.dummyWait(4);
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");
        return isShowing & Breadcrumbs;
    }


    public boolean checkNavigationCitiesNews(){
        commonFunctions.navigateToURL(globalVars.getAmpUrl());
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
        commonFunctions.dummyWait(4);
        isShowing &=commonFunctions.isElementNotDisplayed(breadCrumbsHome, 10, "Redirected to Homepage");
        return isShowing & Breadcrumbs;
    }
}