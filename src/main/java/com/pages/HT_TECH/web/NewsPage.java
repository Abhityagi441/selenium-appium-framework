package com.pages.HT_TECH.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_TECH.commonFunctions.CommonFunctionWebHT;
import com.pages.HT_TECH.generic.CommonNewsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsPage extends CommonNewsPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionWebHT commonFunctionsHt;

    @FindBy(xpath = "//ul[@class='mainLi']/li[2]/a")
    private static WebElement latestNews;

    @FindBy(className = "breadcrumb")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "//a[text()='HOME']")
    private static WebElement redirectToHomepage;

    @FindBy(xpath="//section[@class='topSectionWrapper']//a")
    private static List<WebElement> allTopStoriesLink;
    @FindBy(xpath="//ul[@class='mainLi']/li[2]")
    private static WebElement news;

    @FindBy(xpath="(//div[@class='breadcrumb']/a[3])[1]")
    private static WebElement breadcrumNews;

    @FindBy(id="adslot1")
    private static WebElement rH1Ad;

    @FindBy(id="adslot2")
    private static WebElement rhs2Ad;

    @FindBy(id="adslot3")
    private static WebElement rhs3Ad;

    @FindBy(xpath="//h2[text()='Top Gadgets']")
    private static WebElement topGadget;

    @FindBy(xpath="//h2[text()='Gadgets Comparisons']")
    private static WebElement gadgetComparison;

    @FindBy(xpath="//div[@class='searchWrapper']/input[@id='searchParameter']")
    private static WebElement searchTextBox;

    @FindBy(xpath="//div[@class='searchInput']//input[@id='findText']")
    private static WebElement searchTextBoxOnTrendingNewsPage;

    @FindBy(xpath="//h3[text()='Trending News']")
    private static WebElement trendingNewsText;

    @FindBy(xpath="//div[@class='searchInput']//a[@id='searchIconPopup']")
    private static WebElement searchBtnTabText;

    @FindBy(xpath="//div[@class='searchTitle']")
    private static WebElement searchResultTitle;

    @FindBy(xpath="//div[@id='errorMsg']")
    private static WebElement errorMsg;

    @Override
    public boolean searchUsingSpecialKeyword(String keyword){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(news);
        commonFunctions.clickElement(searchTextBox,10,"searchTextBox");
        commonFunctions.isElementDisplayed(searchTextBoxOnTrendingNewsPage,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.sendKeys(searchTextBoxOnTrendingNewsPage,keyword,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.clickElement(searchBtnTabText,10,"searchBtnTabText");
        String actualSearchResult = commonFunctions.getElementText(errorMsg,10);
        String expectedSearchResult = "Only alphanumeric keywords are allowed";
        return commonFunctions.compareTexts(expectedSearchResult,actualSearchResult);
    }



    @Override
    public boolean searchAnyProductUsingValidKeyword(String keyword){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(news);
        commonFunctions.waitForPageToLoad();
        commonFunctions.clickElement(searchTextBox,10,"searchTextBox");
        commonFunctions.isElementDisplayed(searchTextBoxOnTrendingNewsPage,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.sendKeys(searchTextBoxOnTrendingNewsPage,keyword,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.clickElement(searchBtnTabText,10,"searchBtnTabText");
        commonFunctions.waitForURLContains(keyword);
        String SearchResult = commonFunctions.getElementText(searchResultTitle,10);
        String actualSearchResult=value1(SearchResult);
        String expectedSearchResult = "Search Results for \""+keyword+"\"";
        return commonFunctions.compareTexts(actualSearchResult,expectedSearchResult);
    }
    public static String value1(String value1) {
        String[] lines = value1.split("\\R");
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < lines.length; i++) {
            s.append(lines[i]);
        }
        return s.toString();
    }
    @Override
    public boolean checkTrendingNewsHeadingOnClickingSearchBox(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(news);
        boolean isElementClickable = commonFunctions.isElementClickable(searchTextBox, 5, "Search TextBox");
        boolean isElementClicked = commonFunctions.clickElement(searchTextBox,5,"searchTextBox");
        boolean isElementDisplayed = commonFunctions.isElementDisplayed(trendingNewsText,5,"txt_TrendingNews");
        boolean isSearchTextBoxDisplayed = commonFunctions.isElementDisplayed(searchTextBoxOnTrendingNewsPage,5,"searchTextBoxOnTrendingNewsPage");
        return  isElementClickable && isElementClicked && isSearchTextBoxDisplayed && isElementDisplayed;
    }

    @Override
    public boolean checkNewsPageRHSAdsAreDisplayed() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(news);
        commonFunctions.scrollWithCoOrdinates(0,30);
        boolean checkRHS1Ad=commonFunctions.isElementDisplayed(rH1Ad, 10, "RHS First Ad");
        commonFunctions.scrollToElement(topGadget,"2nd ad");
        boolean checkRHS2Ad=commonFunctions.isElementDisplayed(rhs2Ad, 10,"RSH Second Ad");
        commonFunctions.scrollToElement(gadgetComparison,"scrolled to gadgetComparison");
        boolean checkRHS3Ad=commonFunctions.isElementDisplayed(rhs3Ad, 10,"RSH Third Ad");
        return checkRHS1Ad && checkRHS2Ad && checkRHS3Ad;
    }

    @Override
    public boolean checkTopStoriesWidget(){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(news);
        int topStoriesSize = allTopStoriesLink.size();
        isAllElementClickableTrue =isAllElementClickableAndReturns200(allTopStoriesLink);
        return topStoriesSize == 10 && isAllElementClickableTrue;
    }
    public boolean isAllElementClickableAndReturns200(List<WebElement> allTopStoriesLink) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        for (int i = 0; i <= allTopStoriesLink.size() - 1; i++) {
            String storyTitle = allTopStoriesLink.get(i).getText();
            commonFunctions.dummyWait(5);
            isUrlClickable &= commonFunctions.clickElementWithJS(allTopStoriesLink.get(i), 10, storyTitle + " story");
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateBack();
        }
            return isUrlClickable && isLinkReturn200;
    }

    @Override
    public boolean checkNavigationLatestNews() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean latestNewsBol = breadCrumbNews(latestNews, "Home > Tech > Tech News", "tech/news");
        System.out.println(latestNewsBol);
        boolean newsUrl = commonFunctionsHt.checkCatogeriesNewsURL("tech/news");
        System.out.println(newsUrl);
        boolean homepageLatest = commonFunctionsHt.redirectToHomepageFromCategories(redirectToHomepage, "tech/news");
        System.out.println(homepageLatest);
        return latestNewsBol && newsUrl && homepageLatest;
    }


    public boolean breadCrumbNews(WebElement element, String home, String category) {
        commonFunctions.clickElement(element, 20, "clicked on " + category);
        commonFunctions.isElementDisplayed(breadCrumbsName, 10);
        Utils.logStepInfo(true, "Latest BreadCrumb available");
        String crumbvalue = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        String actualCrumValue = value(crumbvalue);
        return actualCrumValue.equalsIgnoreCase(home);
    }

    public static String value(String value1) {
        String[] lines = value1.split("\\R");
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < lines.length; i++) {
            s.append(lines[i]);
            if (i != lines.length - 1) {
                s.append(" > ");
            }
        }
        return s.toString();
    }



    public static NewsPage newsPage;
    public static NewsPage getInstance(){
        if(newsPage==null){
            newsPage= new NewsPage();
        }
        return newsPage;
    }

    public NewsPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt=CommonFunctionWebHT.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
}
