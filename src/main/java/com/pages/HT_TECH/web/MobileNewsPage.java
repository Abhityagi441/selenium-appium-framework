package com.pages.HT_TECH.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_TECH.commonFunctions.CommonFunctionWebHT;
import com.pages.HT_TECH.generic.CommonMobileNewsPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MobileNewsPage extends CommonMobileNewsPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionWebHT commonFunctionsHt;

    public static MobileNewsPage mobileNewsPage;
    public static MobileNewsPage getInstance(){
        if(mobileNewsPage==null){
            mobileNewsPage= new MobileNewsPage();
        }
        return mobileNewsPage;
    }

    public MobileNewsPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt=CommonFunctionWebHT.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @FindBy(xpath="((//li[@class='dropdownMenu'])[1]//li)[1]")
    private static WebElement mobileNews;

    @FindBy(xpath="(//li[@class='dropdownMenu'])[1]")
    private static WebElement mobile;

    @FindBy(xpath="//div[@class='breadcrumb']")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "//a[text()='HOME']")
    private static WebElement redirectToHomepage;

    @FindBy(xpath="//section[@class='topSectionWrapper']//a")
    private static List<WebElement> allTopStoriesLink;

    @FindBy(id="adslot1")
    private static WebElement rH1Ad;

    @FindBy(id="adslot2")
    private static WebElement rhs2Ad;

    @FindBy(id="adslot3")
    private static WebElement rhs3Ad;

    @FindBy(xpath="//section[@class='topGadgetsWrapper']//h2")
    private static WebElement topMobile;

    @FindBy(xpath="//section[@class='comparison']//h2")
    private static WebElement mobileComparison;


    @Override
    public boolean checkBreadCrumbsOnMobileNews() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean latestNewsBol = breadCrumbNews(mobileNews, "Home > Mobile > Mobile News", "mobile/news");
        System.out.println(latestNewsBol);
        boolean newsUrl = commonFunctionsHt.checkCatogeriesNewsURL("mobile/news");
        System.out.println(newsUrl);
        boolean homepageLatest = commonFunctionsHt.redirectToHomepageFromCategories(redirectToHomepage, "mobile/news");
        System.out.println(homepageLatest);
        return latestNewsBol && newsUrl && homepageLatest;
    }
    public boolean breadCrumbNews(WebElement element, String home, String category) {
        commonFunctions.mouseHoverOnElement(mobile,5,"Mobile");
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

    @Override
    public boolean checkTopStoriesWidgetOnMobileNews(){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.mouseHoverOnElement(mobile,5,"mobile");
        commonFunctions.clickElement(mobileNews);
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
    public boolean checkNewsPageRHSAdsAreDisplayed() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.mouseHoverOnElement(mobile,5,"mobile");
        commonFunctions.clickElement(mobileNews);
        commonFunctions.scrollWithCoOrdinates(0,30);
        boolean checkRHS1Ad=commonFunctions.isElementDisplayed(rH1Ad, 10, "RHS First Ad");
        commonFunctions.scrollToElement(topMobile,"2nd ad");
        boolean checkRHS2Ad=commonFunctions.isElementDisplayed(rhs2Ad, 10,"RSH Second Ad");
        commonFunctions.scrollToElement(mobileComparison,"scrolled to gadgetComparison");
        boolean checkRHS3Ad=commonFunctions.isElementDisplayed(rhs3Ad, 10,"RSH Third Ad");
        return checkRHS1Ad && checkRHS2Ad && checkRHS3Ad;
    }





}
