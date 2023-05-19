package com.pages.HT_TECH.commonFunctions;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;

import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonFunctionWebHT {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionWebHT commonFunctionsWeb;
    private static CommonFunctionsWeb commonFunctions;
    private static DriverController driverController;

    public static CommonFunctionWebHT getInstance() {
        driverController = DriverController.getInstance();
        if (commonFunctionsWeb == null) {
            commonFunctionsWeb = new CommonFunctionWebHT();
        }
        return commonFunctionsWeb;
    }

    public CommonFunctionWebHT() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        commonFunctions = CommonFunctionsWeb.getInstance();

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

    public boolean isAllElementClickableAndReturns200(List<WebElement> link) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
           commonFunctions.navigateToURL(globalVars.getURL());
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> link, WebElement ele, WebElement ele1) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.clickElement(ele);
            commonFunctions.clickElement(ele1);
            commonFunctions.waitForPageToLoad();
        }
        return isUrlClickable && isLinkReturn200;
    }
    public boolean isElementClickableAndReturns200(List<WebElement> allTopStoriesLink) {
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

    public boolean isAllElementClickableAndReturns200(List<WebElement> link, WebElement ele, WebElement ele1, WebElement ele2) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.clickElement(ele);
            commonFunctions.clickElement(ele1);
            commonFunctions.clickElement(ele2);
            commonFunctions.waitForPageToLoad();
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> link, WebElement ele) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.clickElement(ele);
            commonFunctions.waitForPageToLoad();
        }
        return isUrlClickable && isLinkReturn200;
    }


    public boolean isAllElementClickableAndReturns200(WebElement ele,List<WebElement> link) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.clickElement(ele);
            commonFunctions.waitForPageToLoad();
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean checkRHSWidget(WebElement ele,List<WebElement> link,List<WebElement> link1,WebElement ele2){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(ele);
        int topStoriesSize = link.size();
        isAllElementClickableTrue =isElementClickable(link1,ele2);
        return topStoriesSize == 5 && isAllElementClickableTrue;

    }
    public boolean isElementClickable(List<WebElement> link,WebElement ele) {
        boolean isUrlClickable = false;
        boolean isLinkReturn200 = false;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            commonFunctions.dummyWait(5);
            isUrlClickable = commonFunctions.clickElementWithJS(link.get(i), 10, storyTitle + " story");
            String v= commonFunctions.getCurrentURL();
            if(v.contains("web-stories")){
                String u=commonFunctions.getCurrentPageTile();
                commonFunctions.compareTexts(storyTitle,u);
            }
            else{
                String headline= ele.getText();
                commonFunctions.compareTexts(storyTitle,headline);
            }
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateBack();
        }
        return isUrlClickable && isLinkReturn200;
    }


}
