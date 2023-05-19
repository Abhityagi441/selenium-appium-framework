package com.pages.HT_AUTO.commonFunctions;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;

import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.*;

import java.util.List;

public class CommonFunctionWebHTAuto {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionWebHTAuto commonFunctionsWeb;
    private static CommonFunctionsWeb commonFunctions;
    private static DriverController driverController;

    public static CommonFunctionWebHTAuto getInstance() {
        driverController = DriverController.getInstance();
        if (commonFunctionsWeb == null) {
            commonFunctionsWeb = new CommonFunctionWebHTAuto();
        }
        return commonFunctionsWeb;
    }

    public CommonFunctionWebHTAuto() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        commonFunctions = CommonFunctionsWeb.getInstance();

    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> link) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = false;
            for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " element");
            //   commonFunctions.dummyWait(10);
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(!isLinkReturn200){
                    Utils.logStepInfo(false,commonFunctions.getCurrentURL()+" throwing other than 200 response code");
                    return isLinkReturn200;
            }
            commonFunctions.navigateBack();
            waitForPageLoading();
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200UsingNavigateToBack(List<WebElement> link) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = false;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            //   commonFunctions.dummyWait(10);
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(!isLinkReturn200){
                Utils.logStepInfo(false,"Response Code -> "+commonFunctions.getResponseCode(commonFunctions.getCurrentURL()));
                Utils.logStepInfo(false,"Current URL is not clickable -> "+commonFunctions.getCurrentURL());
                return false;
            }
            commonFunctions.navigateBack();
            commonFunctions.waitForPageLoading();
            commonFunctions.dummyWait(2);
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> link, WebElement ele, WebElement ele1) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = false;
        commonFunctions.dummyWait(5);
            for (int i = 0; i <= link.size() - 1; i++) {
                String storyTitle = link.get(i).getText();
                isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " element");
                //   commonFunctions.dummyWait(10);
                isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                if(!isLinkReturn200){
                    Utils.logStepInfo(false,commonFunctions.getCurrentURL()+" throwing other than 200 response code");
                    return isLinkReturn200;
                }
                commonFunctions.navigateToURL(globalVars.getURL());
                waitForPageLoading();
                commonFunctions.clickElement(ele);
                commonFunctions.dummyWait(1);
                commonFunctions.clickElement(ele1);
                commonFunctions.dummyWait(1);
            }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200InList(List<WebElement> link, WebElement ele, WebElement ele1) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = false;
        commonFunctions.dummyWait(2);
        int sizeOfList = link.size();
        if(link.isEmpty()){
            Utils.logStepInfo(false,"List is Empty");
            return false;
        }else if(sizeOfList>10){
            Utils.logStepInfo(true,"List size updated to 10");
            sizeOfList=10;
        }
        for (int i = 0; i <= sizeOfList - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            //   commonFunctions.dummyWait(10);
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(!isLinkReturn200){
                Utils.logStepInfo(false,commonFunctions.getCurrentURL()+" throwing other than 200 response code");
                return isLinkReturn200;
            }
            commonFunctions.navigateToURL(globalVars.getURL());
                waitForPageLoading();
            commonFunctions.clickElement(ele);
            commonFunctions.dummyWait(1);
            commonFunctions.clickElement(ele1);
            commonFunctions.dummyWait(1);
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200InList(List<WebElement> link, WebElement ele, WebElement ele1, WebElement ele2) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = false;
        int sizeOfList = link.size();
        if(link.isEmpty()){
            Utils.logStepInfo(false,"List is Empty");
            return false;
        }else if(sizeOfList>10){
            Utils.logStepInfo(true,"List size updated to 10");
            sizeOfList=10;
        }
        for (int i = 0; i <= sizeOfList - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            //   commonFunctions.dummyWait(10);
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(!isLinkReturn200){
                Utils.logStepInfo(false,commonFunctions.getCurrentURL()+" throwing other than 200 response code");
                return isLinkReturn200;
            }
            commonFunctions.navigateToURL(globalVars.getURL());
            waitForPageLoading();
            commonFunctions.clickElement(ele);
            commonFunctions.dummyWait(1);
            commonFunctions.clickElement(ele1);
            commonFunctions.dummyWait(1);
            commonFunctions.clickElement(ele2);
            commonFunctions.dummyWait(1);
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> link, WebElement ele, WebElement ele1, WebElement ele2) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = false;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " element");
            //   commonFunctions.dummyWait(10);
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(!isLinkReturn200){
                Utils.logStepInfo(false,commonFunctions.getCurrentURL()+" throwing other than 200 response code");
                return isLinkReturn200;
            }
            commonFunctions.navigateToURL(globalVars.getURL());
            waitForPageLoading();
            commonFunctions.clickElement(ele);
            commonFunctions.dummyWait(1);
            commonFunctions.clickElement(ele1);
            commonFunctions.dummyWait(1);
            commonFunctions.clickElement(ele2);
            waitForPageLoading();
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> link, WebElement ele) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = false;
        commonFunctions.dummyWait(5);
            for (int i = 0; i <= link.size() - 1; i++) {
                String storyTitle = link.get(i).getText();
                isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " element");
                // commonFunctions.dummyWait(10);
                isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                if(!isLinkReturn200){
                    Utils.logStepInfo(false,commonFunctions.getCurrentURL()+" throwing other than 200 response code");
                    return isLinkReturn200;
                }
                commonFunctions.navigateBack();
                waitForPageLoading();
                commonFunctions.clickElement(ele);
                waitForPageLoading();
            }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200(WebElement ele,List<WebElement> link) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        for (int i = 0; i <= link.size() - 1; i++) {
            String storyTitle = link.get(i).getText();
            isUrlClickable &= commonFunctions.clickElementWithJS(link.get(i), 15, storyTitle + " story");
            // commonFunctions.dummyWait(10);
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.clickElement(ele);
            commonFunctions.waitForPageToLoad();
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isElementClickableAndReturns200(WebElement ele,String msg) {
        boolean isElementClickable = commonFunctions.clickElement(ele,10,msg);
        boolean isLinkReturn200 = true;
        isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL())==200;
        if(!isLinkReturn200){
            Utils.logStepInfo(false,commonFunctions.getCurrentURL()+" throwing other than 200 response code");
        }
        return isElementClickable && isLinkReturn200;
    }

    public String setBreadCrumbValuesFromUI(String value1) {
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

    public void waitForPageLoading() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page loaded competely");
            commonFunctions.dummyWait(2);
        }
    }




}