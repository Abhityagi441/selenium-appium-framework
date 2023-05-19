package com.pages.HindustanTimes.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BreadCrumbsPage extends CommonBreadCrumbsPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;



    public BreadCrumbsPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();

        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @FindBy(xpath = "//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "//a[text()='World']")
    private static WebElement worldNews;

    @FindBy(className = "navIco")
    private static WebElement exploreMenu;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(xpath = "//em[text()='Cricket']")
    private static WebElement cricket;

    @FindBy(xpath = "//a[text()='Editorials']")
    private static WebElement editorials;

    @FindBy(xpath = "(//section[@id='sidenav']//a)[14]")
    private static WebElement cities;

    @FindBy(xpath = "//em[text()='Entertainment']")
    private static WebElement entertainment;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploremenu;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//a")
    private static List<WebElement> sectionList;

    @FindBy(name = "q")
    private static WebElement googleSearchBox;

    @FindBy(xpath = "//div[contains(@class,'Lgnr0e J88qA vgnU9e BmP5tf')]//a/div")
    private static List<WebElement> googleSearchResultList;

    public boolean breadcrumbDisplayedOtherThanHomePage(){return true;}

    /*public boolean breadCrumbLatestNews(WebElement element,String home,String category){
        commonFunctions.clickElement(element,20,"clicked on "+category);
        commonFunctions.isElementDisplayed(breadCrumbsName,10);
        Utils.logStepInfo(true, "Latest BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }
    public boolean breadCrumbPopularStory(WebElement element,String home,String category){
        commonFunctions.clickElement(element,10,"clicked on "+category);
        commonFunctions.isElementDisplayed(breadCrumbsName,10);
        Utils.logStepInfo(true, "popular BreadCrumb available");
        String crumbvalue=commonFunctions.getElementText(breadCrumbsName,10).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }*/

    public boolean redirectToHomepageFromCategories(WebElement element, String category) {
        commonFunctions.clickElement(element,20,"Clicked on home to redirect");
        String currentURL = commonFunctions.getCurrentURL("URL",category + " News URL successful");
        return currentURL.equals(globalVars.getProdUrl());
    }

    public boolean checkCatogeriesNewsURL(String category){
        String currentURL = commonFunctions.getCurrentURL("URL",category + " news URL successful");
        return currentURL.equals(globalVars.getProdUrl()+category);
    }

    public boolean breadCrumbCategoriesNews(WebElement element,String home, String category) {
        if( !(element.getText().equals("Latest")||element.getText().equals("World News")||element.getText().equals("Editorials"))){
            commonFunctions.clickElementWithJS(exploremenu,20,"Explore icon");
        }
        commonFunctions.clickElementWithJS(element,65,"clicked on " + category);
        commonFunctions.isElementDisplayed(breadCrumbsName,20);
        Utils.logStepInfo(true, category +" BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean checkNavigationIndiaNews(){
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean breadIndia =breadCrumbCategoriesNews(indiaNews,"Home / India News","india news");
        boolean newsURL=checkCatogeriesNewsURL("india-news");
        boolean homepageIndia =redirectToHomepageFromCategories(redirectToHomepage,"india news");

        return breadIndia && newsURL && homepageIndia;
    }

    public boolean checkNavigationPopularNews()
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        //boolean popularStoryNews=breadCrumbPopularStory(popularStory, "Home / Most Popular","mostpopular");
        boolean popularStoryNews=breadCrumbPopularStory(worldNews, "Home / World News","worldnews");
        //boolean popularStoryNews=breadCrumbCategoriesNews(worldNews, "Home / World News","worldnews");
        boolean newsUrl=checkCatogeriesNewsURL("world-news");
        boolean popularNews =redirectToHomepageFromCategories(redirectToHomepage,"worldnews");

        return popularNews && newsUrl && popularStoryNews;
    }
    public boolean breadCrumbPopularStory(WebElement element,String home,String category){
        commonFunctions.clickElement(element,10,"clicked on "+category);
        commonFunctions.isElementDisplayed(breadCrumbsName,10);
        Utils.logStepInfo(true, "WorldNews BreadCrumb available");
        String crumbvalue=commonFunctions.getElementText(breadCrumbsName,10).trim();
        return crumbvalue.equalsIgnoreCase(home);
    }

    public boolean checkNavigationCricketNews(){

        commonFunctions.navigateToURL(globalVars.getURL());
        boolean cricketNews=breadCrumbCategoriesNews(cricket, "Home / Cricket","cricket");
        boolean newsUrl=checkCatogeriesNewsURL("cricket");
        boolean homepageCricket=redirectToHomepageFromCategories(redirectToHomepage,"cricket");

        return cricketNews && newsUrl && homepageCricket;
    }
    public boolean checkNavigationLatestNews(){
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean latestNewsBol=breadCrumbCategoriesNews(latestNews,"Home / Latest News","latest-news");
        boolean newsUrl=checkCatogeriesNewsURL("latest-news");
        boolean homepageLatest=redirectToHomepageFromCategories(redirectToHomepage,"latest-news");

        return latestNewsBol && newsUrl && homepageLatest;
    }

   @Override
    public boolean checkBreadcrumbVisible() {
        boolean isBreadcrumbVisible = false;

        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(sectionList,"India",20);
        String currentUrl = commonFunctions.getCurrentURL();
        String completeBreadCrumbText=getBreadCrumbsText();
        if(currentUrl.contains(completeBreadCrumbText))
        {
            isBreadcrumbVisible=true;
        }

        return isBreadcrumbVisible;
    }


    @Override
    public boolean checkBreadcrumbVisibleWhenUserLandsFromGoogleEtc(String googleUrl, String searchText) {
        boolean isBreadcrumbVisibleWhenUserLandsFromGoogleEtcTrue = false;

        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(googleUrl);
        commonFunctions.dummyWait(10);
        commonFunctions.sendKeyBoolean(googleSearchBox,searchText,30,"Google search box");
        commonFunctions.pressEnterKey();
        String completeText = searchText.split(" ")[2] + "-" + searchText.split(" ")[3];
        clickElementWithGivenText(googleSearchResultList,completeText,20);
        String currentUrl = commonFunctions.getCurrentURL();
        String completeBreadCrumbText=getBreadCrumbsText();
        if(currentUrl.contains(completeBreadCrumbText))
        {
            isBreadcrumbVisibleWhenUserLandsFromGoogleEtcTrue=true;
        }
        return isBreadcrumbVisibleWhenUserLandsFromGoogleEtcTrue;
    }

    public String getBreadCrumbsText()
    {
        String breadCrumbsNameText = commonFunctions.getElementText(breadCrumbsName, 20);
        String[] breadCrumsSplitText = breadCrumbsNameText.split("/");
        return breadCrumsSplitText[1].trim().replaceAll(" ", "-").toLowerCase();
    }

    public void clickElementWithGivenText(List<WebElement> elementList,String text, int timeOutInSec)
    {
        String actualText=null;
        for(WebElement ele: elementList)
        {
            actualText=ele.getText();
            if(actualText.equalsIgnoreCase(text))
            {
                commonFunctions.clickElementWithJS(ele,timeOutInSec,actualText.trim());
                break;
            }
        }
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

        commonFunctions.navigateToURL(globalVars.getURL());
        boolean editorialNews=breadCrumbCategoriesNews(editorials,"Home / Editorials","editorial");
        boolean newsUrl=checkCatogeriesNewsURL("editorials");
        boolean editorialHome=redirectToHomepageFromCategories(redirectToHomepage,"editorial");

        return editorialNews && newsUrl&& editorialHome;
    }

    public boolean checkNavigationEntertainmentNews(){

        commonFunctions.navigateToURL(globalVars.getURL());
        boolean entertainmentNews=breadCrumbCategoriesNews(entertainment, "Home / Entertainment","entertainment");
        boolean entertainmentUrl=checkCatogeriesNewsURL("entertainment");
        boolean homeEntertainment=redirectToHomepageFromCategories(redirectToHomepage,"entertainment");

        return entertainmentNews && entertainmentUrl && homeEntertainment;
    }

    public boolean checkNavigationCitiesNews(){
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean citiesNews=breadCrumbCategoriesNews(cities,"Home / Cities", "cities");
        boolean citiesUrl=checkCatogeriesNewsURL("cities");
        boolean citiesHome=redirectToHomepageFromCategories(redirectToHomepage, "cities");
        return citiesNews && citiesUrl && citiesHome;
    }


}
