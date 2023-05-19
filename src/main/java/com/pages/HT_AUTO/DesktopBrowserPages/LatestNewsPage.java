package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.commonFunctions.CommonFunctionWebHTAuto;
import com.pages.HT_AUTO.genericPages.CommonLatestNewsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LatestNewsPage extends CommonLatestNewsPage {

    private static CommonFunctionsWeb commonFunctions;

    private static CommonFunctionWebHTAuto commonFunctionsHt;
    private static WebDriver driver;
    private static GlobalVars globalVars;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//li//a[text()='Latest News']")
    private static WebElement latestNewsOption;

    @FindBy(xpath = "//h1[text()='Latest News']")
    private static WebElement latestNewsHeading;

    @FindBy(xpath = "//div[@class='breadcrumb']")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "//div[@class='breadcrumb']//a")
    private static WebElement homeBreadCrumbs;

    @FindBy(xpath="//section[@class='topSectionWrapper']//a")
    private static List<WebElement> allTopStoriesLink;

    @FindBy(xpath="//div[@class='pagination ']//a[@class!='prev' and @class!='next ']")
    private static List<WebElement> pageNumberLink;

    @FindBy(xpath="//div[@class='pagination ']//a[@class='next ']")
    private static WebElement nextPageButton;

    @FindBy(xpath="//div[@class='pagination ']//a[@class='prev']")
    private static WebElement prevPageButton;

    @FindBy(xpath="(//div[@class='rhSection']//div[contains(@id,'google_ads_iframe')])[1]")
    private static WebElement rH1Ad;

    @FindBy(xpath="(//div[@class='rhSection']//div[contains(@id,'google_ads_iframe')])[2]")
    private static WebElement rhs2Ad;

    @FindBy(xpath="(//div[@class='rhSection']//div[contains(@id,'google_ads_iframe')])[3]")
    private static WebElement rhs3Ad;

    @FindBy(xpath="(//div[contains(@id,'google_ads_iframe')])[1]")
    private static WebElement topMostAd;

    @FindBy(xpath="//div[@id='adslot3']")
    private static WebElement bottomAd;

    @FindBy(css="section.gadgetsSearch div.h2")
    private static WebElement gadgetSearchBy;

    @FindBy(xpath="//section[@id='top-compare-widget']//h2[text()='Top Comparisons']")
    private static WebElement txt_TopComparisonsWidget;

    @FindBy(xpath="//h3[text()='Trending this Week']")
    private static WebElement trendingThisWeekHead;

    @FindBy(xpath="//a[@id='viewAllTopComparison']")
    private static WebElement findMoreTopComparisonsLink;

    @FindBy(xpath="//section[@id='top-auto-widget']//h2[text()='Top Automobiles']")
    private static WebElement txt_TopAutomobilesWidget;

    @FindBy(css = "img[alt='HT Auto']")
    private static WebElement HTAutoLogo;

    @FindBy(xpath="//h3[@class='rtHeading']//a[text()='Latest News']")
    private static WebElement latestNewsCardHeading;

    public LatestNewsPage(){
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this) ;
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt = new CommonFunctionWebHTAuto().getInstance();

//        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
//        if (isElementPresent) {
//            commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "acceptCookie");
//        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    @Override
    public boolean navigateToLatestNewsPage(String expectedBreadCrumb, String urlContains) {
        navigateToLatestNewsPage();
        boolean isURLContains = commonFunctions.getCurrentURL().contains(urlContains);
        commonFunctions.isElementDisplayed(breadCrumbsName,10);
        String breadCrumbValueFromUI = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        String actualBreadCrumb = commonFunctionsHt.setBreadCrumbValuesFromUI(breadCrumbValueFromUI);
        return isURLContains && actualBreadCrumb.equalsIgnoreCase(expectedBreadCrumb);
    }

    @Override
    public boolean navigateToLatestNewsPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.isElementDisplayed(latestNewsOption,10,"latestNewsOption");
        boolean isElementClickable = commonFunctions.clickElement(latestNewsOption,10,"latestNewsOptions");
        commonFunctions.waitForPageLoading();
        boolean isElementDisplayed = commonFunctions.isElementDisplayed(latestNewsHeading,10,"latestNewsHeading");
        return isElementClickable && isElementDisplayed;
    }

    @Override
    public boolean checkTopStoriesWidget(int noOfStories){
        int topStoriesSize = allTopStoriesLink.size();
        boolean isAllElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200UsingNavigateToBack(allTopStoriesLink);
        return topStoriesSize == noOfStories && isAllElementClickableTrue;
    }
    @Override
    public boolean checkHomePageRHSAdsAreDisplayed_1() {
        commonFunctions.scrollWithCoOrdinates(0,30);
        commonFunctions.dummyWait(2);
        boolean checkRHS1Ad=commonFunctions.isElementDisplayed(rH1Ad, 20, "HomePage RHS First Ad");
        commonFunctions.scrollToElement(txt_TopAutomobilesWidget,"2nd ad");
        commonFunctions.waitForPageLoading();
        boolean checkRHS2Ad=commonFunctions.isElementDisplayed(rhs2Ad, 20,"RSH Second Ad");
        commonFunctions.scrollToElement(gadgetSearchBy,"scrolled to photoGallery");
        commonFunctions.waitForPageLoading();
        boolean checkRHS3Ad=commonFunctions.isElementDisplayed(rhs3Ad, 20,"RSH Third Ad");
        return checkRHS1Ad && checkRHS2Ad && checkRHS3Ad;
    }

    @Override
    public boolean checkTopAdDisplaying_2() {
        boolean isTopAd;
        isTopAd = commonFunctions.isElementDisplayed(topMostAd, 20, "topAd");
        return isTopAd;
    }

    @Override
    public boolean checkBottomAdsDisplaying_3() {
        boolean isTopAd;
        commonFunctions.scrollToBottom();
        commonFunctions.dummyWait(1);
        commonFunctions.scrollToTop();
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(1);
        commonFunctions.scrollToElement(gadgetSearchBy,"scrolled to gadgetSearchBy");
        commonFunctions.dummyWait(1);
        commonFunctions.scrollToElement(findMoreTopComparisonsLink,"scrolled to txt_TopComparisonsWidget");
        commonFunctions.dummyWait(2);
        isTopAd = commonFunctions.isElementDisplayed(bottomAd, 20, "bottomAd");
        return isTopAd;
    }

    @Override
    public boolean checkNavigationToHomePageUsingBreadCrumb() {
        navigateToLatestNewsPage();
        commonFunctions.isElementDisplayed(homeBreadCrumbs,10,"homeBreadCrumbs");
        commonFunctions.clickElement(homeBreadCrumbs,10,"homeBreadCrumbs");
        commonFunctions.waitForPageLoading();
        return commonFunctions.getCurrentURL().equals(globalVars.getURL());
    }

    @Override
    public boolean checkPagination(int noOfStories,String urlContains) {
        boolean isAllElementClickableTrue;
//        navigateToLatestNewsPage();
        int paginationListSize = pageNumberLink.size();
        for(int i=0 ; i<3 ; i++){
            commonFunctions.scrollToElement(HTAutoLogo,"scroll to HT Logo");
            commonFunctionsHt.waitForPageLoading();
            int topStoriesSize = allTopStoriesLink.size();
            if(allTopStoriesLink.size()==noOfStories){
                Utils.logStepInfo(true,allTopStoriesLink.size()+" stories are displaying on UI");
                isAllElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200UsingNavigateToBack(allTopStoriesLink);
            }else{
                Utils.logStepInfo(false,allTopStoriesLink.size()+" stories are displaying on UI instead of "+noOfStories);
                return false;
            }
            commonFunctions.scrollToElement(latestNewsCardHeading,"Scroll to latestNewsRHSCardHeading");
            String attributeValue = commonFunctions.getAttributeValue(pageNumberLink.get(i),10,"class");
            boolean isValueTrue = attributeValue.equals("active");
            if(i>0){
                commonFunctions.isElementDisplayed(prevPageButton);
                commonFunctions.isElementDisplayed(nextPageButton);
            }else{
                commonFunctions.isElementDisplayed(nextPageButton);
            }
            if(!isValueTrue && !isAllElementClickableTrue && !(topStoriesSize==noOfStories)){
                Utils.logStepInfo(false,"Either expected page not found or Stories status/size not matched");
                return  false;
            }
            commonFunctions.clickElement(pageNumberLink.get(i+1),10,"Click on Pagination");
            commonFunctions.waitForURLContains(urlContains+"/page-"+(i+2));
        }
        return paginationListSize==5;
    }

    @Override
    public boolean checkAllWidgetsAreDisplaying(){
        commonFunctions.scrollToElement(HTAutoLogo,"scroll to HT Logo");
        boolean isElement1 = commonFunctions.isElementDisplayed(latestNewsCardHeading,10,"latestNewsCardHeading");
        boolean isElement2 = commonFunctions.isElementDisplayed(txt_TopAutomobilesWidget,10,"txt_TopAutomobilesWidget");
        boolean isElement3 = commonFunctions.isElementDisplayed(gadgetSearchBy,10,"gadgetSearchBy");
        boolean isElement4 = commonFunctions.isElementDisplayed(trendingThisWeekHead,10,"trendingThisWeekHead");
        boolean isElement5 = commonFunctions.isElementDisplayed(txt_TopComparisonsWidget,10,"txt_TopComparisonsWidget");
            return isElement5 && isElement4 && isElement3 && isElement2 && isElement1;
    }
}
