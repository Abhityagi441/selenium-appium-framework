package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.commonFunctions.CommonFunctionWebHTAuto;
import com.pages.HT_AUTO.genericPages.CommonAutoNewsPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoNewsPage extends CommonAutoNewsPage {
    private static CommonFunctionsWeb commonFunctions;

    private static CommonFunctionWebHTAuto commonFunctionsHt;
    private static WebDriver driver;
    private static GlobalVars globalVars;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Auto News']")
    private static WebElement autoNewsOption;

    @FindBy(xpath = "//li//a[text()='News']")
    private static WebElement NewsOption;

    @FindBy(xpath = "//h1[text()='Auto News']")
    private static WebElement autoNewsHeading;

    @FindBy(xpath = "//div[@class='breadcrumb']")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "(//div[@class='breadcrumb']//a)[1]")
    private static WebElement homeBreadCrumbs;

    @FindBy(xpath = "(//div[@class='breadcrumb']//a)[2]")
    private static WebElement autoBreadCrumbs;

    public AutoNewsPage(){
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
    public boolean navigateToAutoNewsPage(String expectedBreadCrumb, String urlContains) {
        navigateToAutoNewsPage();
        boolean isURLContains = commonFunctions.getCurrentURL().contains(urlContains);
        commonFunctions.isElementDisplayed(breadCrumbsName,10);
        String breadCrumbValueFromUI = commonFunctions.getElementText(breadCrumbsName, 20).trim();
        String actualBreadCrumb = commonFunctionsHt.setBreadCrumbValuesFromUI(breadCrumbValueFromUI);
        return isURLContains && actualBreadCrumb.equalsIgnoreCase(expectedBreadCrumb);
    }

    @Override
    public boolean navigateToAutoNewsPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.mouseHoverOnElement(NewsOption,10,"Mouse Hover to News Option on Home Page");
        commonFunctions.isElementDisplayed(autoNewsOption,10,"AutoNewsOption");
        boolean isElementClickable = commonFunctions.clickElement(autoNewsOption,10,"AutoNewsOptions");
        commonFunctions.waitForPageLoading();
        boolean isElementDisplayed = commonFunctions.isElementDisplayed(autoNewsHeading,10,"AutoNewsHeading");
        return isElementClickable && isElementDisplayed;
    }

    @Override
    public boolean checkNavigationToHomePageUsingBreadCrumb() {
        navigateToAutoNewsPage();
        commonFunctions.isElementDisplayed(homeBreadCrumbs,10,"homeBreadCrumbs");
        commonFunctions.clickElement(homeBreadCrumbs,10,"homeBreadCrumbs");
        commonFunctions.waitForPageLoading();
        return commonFunctions.getCurrentURL().equals(globalVars.getURL());
    }

    @Override
    public boolean checkNavigationToAutoPageUsingBreadCrumb() {
        navigateToAutoNewsPage();
        commonFunctions.isElementDisplayed(autoBreadCrumbs,10,"homeBreadCrumbs");
        commonFunctions.clickElement(autoBreadCrumbs,10,"homeBreadCrumbs");
        commonFunctions.waitForPageLoading();
        return commonFunctions.getCurrentURL().equals(globalVars.getURL()+"auto");
    }
}
