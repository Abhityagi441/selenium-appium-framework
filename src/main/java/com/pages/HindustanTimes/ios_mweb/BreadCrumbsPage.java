package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
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

    @FindBy(xpath = "//a[text()='Entertainment']")
    private static WebElement entertainment;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "//a[text()='Quickreads']")
    private static WebElement popularStory;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploremenu;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "(//a[contains(@data-id,'cities')])[1]")
    private static WebElement citiesHamburgerMenu;
    @FindBy(xpath = "//li//a/em[text()='India News']")
    private static WebElement indiaNews;
    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[6]/a")
    private static WebElement entertainmentNews;
    @FindBy(xpath = "//div[@class='breadcrumbs']")
    private static WebElement breadcrumbs;
    @FindBy(xpath = "//div[@class='breadcrumbs']//a")
    private static WebElement breadcrumbsHome;

    //@FindBy(xpath = "//div/a[@data-id='cricket,10']")
    @FindBy(xpath = "//li//a[text()='Cricket']")
    private static WebElement cricket;

    @FindBy(xpath = "//li/a[text()='Editorials']")
    private static WebElement editorials;

    @FindBy(xpath = "//div/a/em[text()='Cities']")
    private static WebElement cities;
    @FindBy(xpath = "//span[@class='navIco']")
    private static WebElement explore;
    @FindBy(xpath = "(//a[contains(@data-id,'cricket')])[2]")
    private static WebElement hamburgerCricket;
    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbName;
    @FindBy(xpath = "//div[@class='breadcrumbs']//a")
    private static WebElement breadCrumbsHome;
    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[3]/a")
    private static WebElement india;


    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;

    @FindBy(xpath = "//div[contains(@class,'adHeight')]")
    private static WebElement homeAdv;


    public BreadCrumbsPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean breadcrumbDisplayedOtherThanHomePage(){return true;}

    public boolean redirectToHomepageFromCategories(WebElement element, String category) {
        commonFunctions.clickElementWithJS(element,20,"Clicked on home to redirect");
        commonFunctions.isElementPresent(homeAdv, 10, "HomePage Adv ");
        String currentURL = commonFunctions.getCurrentURL("URL",category + " news URL successful");
        Utils.logStepInfo(currentURL);
        return currentURL.equals(Utils.getUrl());

    }

    public boolean checkCatogeriesNewsURL(String category){
        String currentURL = commonFunctions.getCurrentURL("URL",category + " news URL successful");
        Utils.logStepInfo(currentURL);
        return currentURL.contains(category);
    }

    public boolean breadCrumbCategoriesNews(WebElement element,String home, String category) {
        if(!(element.getText().equals("Latest")||element.getText().equals("Most Read")||element.getText().equals("Editorials"))) {
            commonFunctions.clickElementWithJS(exploremenu,10,"Explore icon");
        } else {
            commonFunctions.clickElementWithJS(element,10,"clicked on "+category);
        }
        commonFunctions.scrollToElementViewAndClick(element,10," on "+category);
        commonFunctions.isElementDisplayed(breadCrumbsName,10);
        Utils.logStepInfo(true, category +" BreadCrumb available");
        String crumbValue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbValue.equalsIgnoreCase(home);
    }

    public boolean breadCrumbLatestNews(WebElement element,String home,String category){
        commonFunctions.clickElement(element,20,"clicked on "+category);
        commonFunctions.isElementDisplayed(breadCrumbsName,20);
        Utils.logStepInfo(true, category+" BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }
    public boolean breadCrumbPopularStory(WebElement element,String home,String category){
        commonFunctions.scrollToElementViewAndClick(element,10,"clicked on "+category);
        commonFunctions.isElementDisplayed(breadCrumbsName,10,"BreadCrumb");
        Utils.logStepInfo(true, category+" BreadCrumb available");
        String crumbvalue=commonFunctions.getElementText(breadCrumbsName,10).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean breadCrumbEditorialStory(WebElement element,String home,String category){
        commonFunctions.scrollToElementViewAndClick(element,10,"clicked on "+category);
        commonFunctions.isElementDisplayed(breadCrumbsName,10);
        Utils.logStepInfo(true, category+" BreadCrumb available");
        String crumbvalue=commonFunctions.getElementText(breadCrumbsName,10).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean checkNavigationIndiaNews(){
        commonFunctions.navigateToURL(globalVars.getProdUrl());
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

    public boolean checkNavigationPopularNews()
    {
        boolean popularStoryNews=breadCrumbPopularStory(popularStory, "Home / Most Popular","mostpopular");
        boolean newsUrl=checkCatogeriesNewsURL("mostpopular");
        boolean popularNews =redirectToHomepageFromCategories(redirectToHomepage,"mostpopular");

        return popularNews && newsUrl && popularStoryNews;
    }

    public boolean checkNavigationCricketNews(){
        commonFunctions.navigateToURL(globalVars.getProdUrl());
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
        boolean latestNewsBol=breadCrumbLatestNews(latestNews,"Home / Latest News","latest-news");
        boolean newsUrl=checkCatogeriesNewsURL("latest-news");
        boolean homepageLatest=redirectToHomepageFromCategories(redirectToHomepage,"latest-news");

        return latestNewsBol && newsUrl && homepageLatest;
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

        boolean editorialNews=breadCrumbEditorialStory(editorials,"Home / Editorials","editorials");
        boolean newsUrl=checkCatogeriesNewsURL("editorials");
        boolean editorialHome=redirectToHomepageFromCategories(redirectToHomepage,"editorials");

        return editorialNews && newsUrl&& editorialHome;
    }

    public boolean checkNavigationEntertainmentNews(){
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing= commonFunctions.clickElementWithJS(entertainmentNews, 10, "Entertainment");
        String Breadcrumb= commonFunctions.getElementText(breadcrumbs, 20);
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("Entertainment");
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("entertainment", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadcrumbsHome, 15, "Breadcrumb Home");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementNotDisplayed(breadcrumbsHome, 10, "Redirected to Homepage");;
        return isShowing & Breadcrumbs;
    }

    public boolean checkNavigationCitiesNews(){
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing= commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &= commonFunctions.clickElementWithJS(citiesHamburgerMenu, 10, "cities");
        String Breadcrumb= commonFunctions.getElementText(breadcrumbs, 20);
        boolean Breadcrumbs = false;
        try {
            Breadcrumbs = Breadcrumb.contains("Cities");
            Utils.logStepInfo(true, "Breadcrumbs Name Displayed");
        } catch (Exception e) {

            Utils.logStepInfo(false, "Breadcrumbs Name Display Failed");
        }
        isShowing &=commonFunctions.checkPageUrlContainsText("cities", 15, "Page URL");
        commonFunctions.clickElementWithJS(breadcrumbsHome, 15, "Breadcrumb Home");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementNotDisplayed(breadcrumbsHome, 10, "Redirected to Homepage");;
        return isShowing & Breadcrumbs;
    }
}
