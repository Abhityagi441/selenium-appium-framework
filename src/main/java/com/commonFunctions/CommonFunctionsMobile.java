package com.commonFunctions;

import com.base.DriverController;
import com.sun.javafx.scene.traversal.Direction;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.*;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.xmlbeans.impl.schema.StscChecker;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunctionsMobile {
    private static AppiumDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;
    private static DriverController driverController;

    public static CommonFunctionsMobile getInstance() {
        if (commonFunctionsMobile == null || driver==null || driver.getSessionId()==null) {
            commonFunctionsMobile = new CommonFunctionsMobile();
        }
        return commonFunctionsMobile;
    }

    public CommonFunctionsMobile() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getAppiumDriver();
        driverController = DriverController.getInstance();
    }

    public boolean clickElement(WebElement element) {
        boolean isElementClicked = false;
        try {
            element.click();
            isElementClicked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElement(MobileElement element) {
        boolean isElementClicked = false;
        try {
            element.click();
            isElementClicked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean isElementDisplayedUnlclickable(MobileElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = false;
        try {

            if (element.isDisplayed()) {
                isElementDisplayed = true;
                Utils.logStepInfo(true, elementName + " displayed successfully");
            }
        } catch (Exception e) {
            Utils.logStepInfo(elementName + " not  displayed");

        }
        return isElementDisplayed;
    }

    public boolean clickElementNoException(MobileElement element, String locator) {
        boolean isElementClicked = false;
        try {
            element.click();
            isElementClicked = true;
        } catch (Exception e) {
            Utils.logStepInfo(locator + " not present");
        }
        return isElementClicked;
    }

    public boolean isKeyboardVisible() {
        boolean isKeyboardShown = ((IOSDriver) driver).isKeyboardShown();
        return isKeyboardShown;
    }

    public MobileElement getElement(String name) {
        MobileElement element = ((IOSDriver<MobileElement>) driver).findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + name + "']"));
        return element;
    }

    public MobileElement getElementByNameContains(String name) {

        MobileElement element = (MobileElement) driver.findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'" + name + "')]"));
        return element;
    }

    public boolean clickElementWithJS(WebElement element) {
        boolean isElementClicked = false;
        try {
            Thread.sleep(1000);
            JavascriptExecutor jse = driver;
            jse.executeScript("arguments[0].click();", element);
            isElementClicked = true;
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElementWithJS(WebElement element, int timeOutInSec) {
        boolean isElementClicked = false;
        try {
            // Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor jse = driver;
            jse.executeScript("arguments[0].click();", element);
            isElementClicked = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElementWithJS(WebElement element, int timeOutInSec, String elementName) {
        boolean isElementClicked = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor jse = driver;
            jse.executeScript("arguments[0].click();", element);
            isElementClicked = true;
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(true, "click on " + elementName + " failed");
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean checkPageUrlContainsText(String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementPageURLExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        dummyWait(10);
        String getPageUrl = driver.getCurrentUrl();
        isElementPageURLExist = getPageUrl.contains(expectedText);
        if (isElementPageURLExist) {
            Utils.logStepInfo(true, elementName + " URL verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " URL verification failed. Expected:" + expectedText + ", Actual:" + getPageUrl);
        }
        return isElementPageURLExist;
    }

    public static void launchChromeApp(String url) {

        String appPackage = "com.android.chrome";
        String appActivity = "com.google.android.apps.chrome.IntentDispatcher";
        String appwaitActivity = "20000";
        Activity activity = new Activity(appPackage, appActivity);
        activity.setStopApp(false);
        ((AndroidDriver<AndroidElement>) driver).startActivity(activity);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public boolean clickElementUsingTouchAction(WebElement element, String elementName) {
        boolean isElementClicked = false;
        try {
            // TouchActions actions=new TouchActions(driver);
            TouchAction action = new TouchAction(driver);
            PointOption pointOption = PointOption.point(element.getLocation());
            action.moveTo(pointOption).tap(pointOption).perform();
            isElementClicked = true;
            Thread.sleep(500);
            Utils.logStepInfo(true, "tap  " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(true, "tap " + elementName + " failed");
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElementUsingTouchAction(MobileElement element, String elementName) {
        boolean isElementClicked = false;
        try {
            // TouchActions actions=new TouchActions(driver);
            TouchAction action = new TouchAction(driver);
            PointOption pointOption = PointOption.point(element.getLocation());
            action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(pointOption).tap(pointOption).perform();
            isElementClicked = true;
            Thread.sleep(500);
            Utils.logStepInfo(true, "tap  " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(true, "tap " + elementName + " failed");
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public void elementToElementDisplayed(WebElement elementName) {
        Utils.logStepInfo(true, elementName + " displayed");
    }

    public boolean scrollTillVisibleTextAndClick(String text, String elementName) {
        boolean isScrollAndTapSuccessful = false;
        try {
            ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));").click();
            isScrollAndTapSuccessful = true;

            Utils.logStepInfo(true, "text visible and tap on   " + elementName + " successful");
        } catch (Exception e) {
            Utils.logStepInfo(false, "text visible and tap on  " + elementName + "  failed");

        }
        return isScrollAndTapSuccessful;
    }

    public boolean scrollTillVisibleText(String text, String elementName) {
        boolean isScrollSuccessful = false;
        try {
            ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
            isScrollSuccessful = true;

            Utils.logStepInfo(true, "text visible   " + elementName + " successful");
        } catch (Exception e) {
            Utils.logStepInfo(false, "text not visible   " + elementName + "  failed");

        }
        return isScrollSuccessful;
    }

    public boolean scrollToTillVisibleText(String text, String elementName, int timeout) {
        boolean isScrollSuccessful = false;
        try {
            ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
            isScrollSuccessful = true;

            Utils.logStepInfo(true, "text visible   " + elementName + " successful");
        } catch (Exception e) {
            Utils.logStepInfo(false, "text not visible   " + elementName + "  failed");

        }
        return isScrollSuccessful;
    }

    public boolean ScrollToElement(WebElement element, String elementName) {
        boolean isScrollSuccessful = false;
        try {
            int count = 0;
            while (!element.isDisplayed()) {
                TouchActions action = new TouchActions(driver);
                action.scroll(element, 10, 100);
                action.perform();
                count++;
                if (count == 10) {
                    System.out.println("Element is not displayed");
                    break;
                }
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, "element not found   " + elementName + "  failed");
        }
        return isScrollSuccessful;
    }

    public static void scrollDown() {
        try {
            TouchAction action = new TouchAction(driver);
            Dimension size = driver.manage().window().getSize();
            action.press(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.40)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.10))).release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollUp() {
        try {
            TouchAction action = new TouchAction(driver);
            Dimension size = driver.manage().window().getSize();
            action.press(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.20)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.80))).release()
                    .perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean scrollElementUsingTouchAction(WebElement element, String elementName) {
        boolean isScrollSuccessful = false;
        try {
            // TouchActions actions=new TouchActions(driver);
            TouchAction action = new TouchAction(driver);
            PointOption pointOption = PointOption.point(element.getLocation());
            action.moveTo(pointOption).perform();
            isScrollSuccessful = true;
            Thread.sleep(500);
            Utils.logStepInfo(true, "scroll  " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(true, "scroll " + elementName + " failed");
            e.printStackTrace();
        }
        return isScrollSuccessful;
    }

    public boolean clickElement(WebElement element, int timeOut) {
        boolean isElementClicked = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isElementClicked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElement(MobileElement element, int timeOut) {
        boolean isElementClicked = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isElementClicked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElement(MobileElement element, int timeOut, String elementName) {
        boolean isElementClickableTrue;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isElementClickableTrue = true;
            Utils.logStepInfo(true, "Successfully tap on " + elementName);
        } catch (Exception e) {
            isElementClickableTrue = false;
            Utils.logStepInfo(false, "Tap on " + elementName + " is failed.");
            e.printStackTrace();
        }
        return isElementClickableTrue;
    }

    public boolean clickElementReload(MobileElement element, int timeOut, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Thread.sleep(5000);
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean clickElementFluentWait(MobileElement element, int timeOut, String elementName) {

        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOut)).ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        if (element.isEnabled()) {
            element.click();
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
        } else {
            Utils.logStepInfo(true, "click on " + elementName + " failed");
        }
        return true;
    }

    public boolean clickElementFluentWait(WebElement element, int timeOut, String elementName) {
        try {
            Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOut)).ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(2));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
            if (element.isEnabled()) {
                element.click();
                Utils.logStepInfo(true, "click on " + elementName + " successfully");
            } else {
                Utils.logStepInfo(false, "click on " + elementName + " failed");
            }
        } catch (Exception e) {
            System.out.println("Exception occur " + e.getMessage());
        }
        return true;
    }

    public boolean clickElementAfterReload(WebElement element, int timeOut, String elementName) {
        try {
            //TODO: Need to remove this thread
            Thread.sleep(20000);
        } catch (InterruptedException e) {

        }
        element.click();
        Utils.logStepInfo(true, "click on " + elementName + " successfully");
        return true;
    }

    public boolean clickElementAfterReload(MobileElement element, int timeOut, String elementName) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {

        }
        element.click();
        Utils.logStepInfo(true, "click on " + elementName + " successfully");
        return true;
    }

    public boolean clickElementIfDisplayed(MobileElement element, int timeOut, String elementName) {

        boolean isElementClicked = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isElementClicked = true;
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
        } catch (Exception e) {
            System.out.println("****** Unable to find " + elementName + " within " + timeOut + " seconds *****" + e);

            //Utils.logStepInfo(false, "click on " + elementName + " failed");
            //e.printStackTrace();
            isElementClicked = false;
        }
        return isElementClicked;
    }

    public String getAtribute(MobileElement element, String name) {
        String valueAttribute = element.getAttribute(name);
        return valueAttribute;

    }


    public boolean clickElement(WebElement element, int timeOut, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Utils.logStepInfo(true, "click on " + elementName + " successfully");
        return true;
    }

    public boolean clickElementWithActions(WebElement element, int timeOut) {
        boolean isElementClicked = false;
        WebDriverWait wait;
        Actions actions;
        try {
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element).click().build().perform();
            isElementClicked = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public void waitForWindow(int expectedNoOfWindows, String elementName) {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.numberOfWindowsToBe(expectedNoOfWindows));
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, elementName + " has not been displayed");
        }
    }

    public void closeAllWindowsExceptMasterTabGen() {
        try {
            String title = driver.getTitle();
            if (driver.getWindowHandles().size() > 1) {
                driver.close();
            }

            ArrayList<String> handleList = new ArrayList<>(driver.getWindowHandles());

            if (handleList.size() > 1) {

                for (int i = 1; i < handleList.size(); i++) {
                    driver.switchTo().window(handleList.get(i));
                    driver.close();
                }

            }
            driver.switchTo().window(handleList.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateToURL(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean clickElementIfDisplayed(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementClicked = false;

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            clickElementWithJS(element);
            isElementClicked = true;
            Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");

        } catch (Exception e) {
            System.out
                    .println("****** Unable to find " + elementName + " within " + timeOutInSecond + " seconds *****");
        }
        return isElementClicked;
    }

    public boolean clickElementWithActions(WebElement element, int timeOut, String elementName) {
        boolean isElementClicked = false;
        WebDriverWait wait;
        Actions actions;
        try {
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element).click().build().perform();
            isElementClicked = true;
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(false, "click on " + elementName + " failed");
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public void switchToWindow(String window) {
        try {
            driver.switchTo().window(window);
            // driver.getTitle();
        } catch (Exception e) {
            System.out.println("Exception capture " + e.getMessage());
            ;
        }
    }

    public void switchToFrame(String frame) {
        try {
            driver.switchTo().frame(frame);
        } catch (Exception e) {
            System.out.println("Exception capture " + e.getMessage());
        }
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("Exception capture " + e.getMessage());
        }
    }

    public void sendKey(WebElement element, String key) {
        try {
            element.sendKeys(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sendKey(WebElement element, String key, int timeOut) {
        boolean isStepTrue = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(key);
            isStepTrue = true;
            Utils.logStepInfo(true, "keyWord Entered - " + key);
        } catch (Exception e) {
            Utils.logStepInfo(false, "keyWord Not Entered - " + key);
            e.printStackTrace();
        }
        return isStepTrue;
    }

    public boolean sendKeyBoolean(WebElement element, String key) {
        try {
            element.sendKeys(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void pressAndroidBackKey() {

        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        Utils.logStepInfo("Back  button clicked successfully ");
    }

    public boolean sendKeyBoolean(WebElement element, String key, int timeOut) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendKeyBoolean(WebElement element, String key, int timeOut, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(key);
        Utils.logStepInfo(true, "Send " + key + " to " + elementName + " successfully");
        return true;
    }

    public boolean sendKeyWithAction(String key, String elementName) {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(key).build().perform();
            Utils.logStepInfo(true, "Send " + key + " to " + elementName + " successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, "Send " + key + " to " + elementName + " failed");
            return false;
        }
        return true;
    }

    public boolean isElementDisplayed(WebElement element) {
        boolean isElementDisplayed = false;
        try {
            isElementDisplayed = element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementDisplayed;
    }

    public boolean isElementDisplayed(WebElement element, int timeOut) {
        boolean isElementDisplayed;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementDisplayed = element.isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return isElementDisplayed;
    }

    public boolean isElementDisplayed(WebElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isDisplayed()) {
                isElementDisplayed = true;
                Utils.logStepInfo(true, elementName + " displayed successfully");
            } else {
                Utils.logStepInfo(false, elementName + " displayed failed");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " displayed failed");
            System.out.println("************** Exception in isElementDisplayed() method : " + e.getMessage());
            System.out.println("************** Exception in isElementDisplayed() method : " + e.getMessage());
        }
        return isElementDisplayed;
    }

    public boolean isElementPresent(WebElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                isElementDisplayed = true;
                Utils.logStepInfo(true, elementName + " displayed successfully");
            } else {
                Utils.logStepInfo(false, elementName + " displayed failed");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " displayed failed");
            System.out.println("************** Exception in isElementDisplayed() method : " + e.getMessage());
        }
        return isElementDisplayed;
    }

    public boolean isElementDisplayed(MobileElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isDisplayed()) {
                isElementDisplayed = true;
                Utils.logStepInfo(true, elementName + " displayed successfully !!!!!!!");
            } else {
                Utils.logStepInfo(false, elementName + " displayed *****failed*****");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " displayed ******failed******");
            //System.out.println("************** Exception in isElementDisplayed() method : " + e.getMessage());
        }
        return isElementDisplayed;
    }

    public boolean isElementEnabled(WebElement element, int timeOut, String elementName) {
        boolean isElementEnabled = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isEnabled()) {
                isElementEnabled = true;
                Utils.logStepInfo(true, elementName + " Enabled successfully");
            } else {
                Utils.logStepInfo(false, elementName + " displayed failed");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " displayed failed");
            System.out.println("************** Exception in isElementDisplayed() method : " + e.getMessage());
        }
        return isElementEnabled;
    }

    public boolean isElementEnabledReload(WebElement element, int timeOut, String elementName) {
        boolean isElementEnabled = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isEnabled()) {
                isElementEnabled = true;
                Utils.logStepInfo(true, elementName + " Enabled successfully");
            } else {
                Utils.logStepInfo(false, elementName + " Enabled failed");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " displayed failed");
            System.out.println("Exception captured: " + e.getMessage());
        }
        return isElementEnabled;
    }

    public boolean isElementDisplayedByXpath(String xpath, int timeOut, String elementName) {
        boolean isElementDisplayed;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
            isElementDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
            Utils.logStepInfo(true, elementName + " displayed successfully !!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
            isElementDisplayed = false;
            Utils.logStepInfo(false, elementName + " displayed ******failed******");
        }
        return isElementDisplayed;
    }

    public String getElementText(WebElement element) {
        String text = "";
        try {
            text = element.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public String getElementText(WebElement element, int timeOut) {
        String text = "";
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            text = element.getText().trim();
            Utils.logStepInfo(true, "text got from element: " + text + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(false, "get text from element failed");
            e.printStackTrace();
        }
        return text;
    }

    public WebElement getElementByXpath(String xpath) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xpath));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }

    public List<WebElement> getElementsByXpath(String xpath) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(By.xpath(xpath));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
    }

    public boolean checkElementText(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        System.out.println("********** Expected element text: " + expectedText);
        System.out.println("******** Actual element text found: " + element.getText());
        isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        if (isElementWithTextExist) {
            Utils.logStepInfo(true, elementName + " verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
        }
        Utils.logStepInfo(isElementWithTextExist, elementName + " found: " + element.getText().trim());

        return isElementWithTextExist;
    }

    public boolean checkElementText(MobileElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist;

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        System.out.println("********** Expected element text: " + expectedText);
        System.out.println("******** Actual element text found: " + element.getText());
        if (isElementWithTextExist) {
            Utils.logStepInfo(true, elementName + " verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
        }
//        Utils.logStepInfo(isElementWithTextExist, elementName + " found: " + element.getText().trim());

        return isElementWithTextExist;
    }

    public boolean checkElementTextException(WebElement element, String expectedText, int timeOutInSecond,
                                             String elementName) {
        boolean isElementWithTextExist;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
            isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            if (isElementWithTextExist) {
                Utils.logStepInfo(true, elementName + " verified successfully");
            } else {
                Utils.logStepInfo(false, elementName + " verification failed");
            }
            Utils.logStepInfo(isElementWithTextExist, elementName + " found: " + element.getText().trim());
        } catch (Exception ex) {
            return false;
        }
        return isElementWithTextExist;
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void textToReport(String text) {
        Utils.logStepInfo(true, "" + text + "");
    }

    public boolean scrollUpToElementDisplayed(WebElement element) {
        boolean scrolledToElement = false;
        TouchAction action = new TouchAction(driver);
        Dimension size = ((WebDriver) driver).manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        while (2 > 1) {
            try {
                action.press(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.90)))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.10))).release()
                        .perform();
                if (!element.isDisplayed()) {
                    action.press(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.90)))
                            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                            .moveTo(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.10))).release()
                            .perform();

                } else {
                    scrolledToElement = true;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return scrolledToElement;
    }

    public void deleteCookiesAndNavigateToHomePage() {
        System.out.println("******************* deleteCookiesAndNavigateToHomePage starts here *******************");
        try {
            if (globalVars.getProjectName().contains("web")) {
                closeAllWindowsExceptMasterTab();
            }
            driver = globalVars.getAppiumDriver();

            //In order to navigate to home page after test case failure
            driverController.navigateToApplicationHomePage(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("******************* deleteCookiesAndNavigateToHomePage() ends here *******************");
    }

    public void deleteFacebookCookies() {
        try {

            driver = globalVars.getAppiumDriver();
            driver.get("https://www.facebook.com/");
            driver.manage().deleteAllCookies();

            globalVars.setWebDriver(driver);
            driverController.navigateToApplicationHomePage(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGoogleCookies() {
        try {
            driver.get("https://myaccount.google.com/");
            driver.manage().deleteAllCookies();
            driverController.navigateToApplicationHomePage(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<String> getWindowHandles() {
        Set<String> handles = new HashSet<>();
        try {
            handles = driver.getWindowHandles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return handles;
    }

    public String getWindowHandle() {
        String handle = "";
        try {
            handle = driver.getWindowHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return handle;
    }

    public Set<String> getWindowHandlesWithExpectedNumberOfWindows(int expectedNumberOfWindows) {
        Set<String> handles = new HashSet<>();
        try {

            handles = driver.getWindowHandles();
            new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));

            handles = driver.getWindowHandles();

        } catch (Exception e) {
            System.out.println("********* Exception in getWindowHandlesWithExpectedNumberOfWindows() method *****");
            System.out.println("******* No. of windows available are: " + handles.size() + " ***********");
        }

        return handles;
    }

    public boolean isElementDisplayedIgnoringStaleElementReferenceException(WebElement element, int timeOutInSecond,
                                                                            String elementName) {
        boolean isElementDisplayed;

        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond))
                .ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        isElementDisplayed = element.isDisplayed();
        Utils.logStepInfo(true, elementName + " available");

        return isElementDisplayed;
    }

    public void waitForPageLoading() {
        waitForPageLoading(0);
    }

    public void waitForPageLoading(int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
        } catch (Exception e) {
        }
    }

    public boolean isElementClickable(MobileElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementDisplayed = element.isEnabled();
            Utils.logStepInfo(true, elementName + " clickable");
        } catch (Exception e) {
            isElementDisplayed = false;
        }
        return isElementDisplayed;
    }

    public boolean isElementClickable(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            isElementDisplayed = element.isEnabled();
            Utils.logStepInfo(true, elementName + " clickable");
        } catch (Exception e) {
            isElementDisplayed = false;
        }
        return isElementDisplayed;
    }

    public void waitForURLContains(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains(text));
        } catch (Exception e) {
        }
    }

    public boolean waitForTheURLContains(String text) {
        boolean isURLContainsTrue;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.urlContains(text));
            Utils.logStepInfo(true, text + " is available in the URL");
            isURLContainsTrue = true;
        } catch (Exception e) {
            Utils.logStepInfo(false, text + " is not available in the URL");
            isURLContainsTrue = false;
        }
        return isURLContainsTrue;
    }

    public String getCurrentURL() {
//		waitForPageLoading();
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public boolean checkTextNotEquals(String expectedText, String actualText, String elementName) {
        boolean verification = false;
        try {
            if (!actualText.equals(expectedText)) {
                Utils.logStepInfo(true, elementName + " verified text not equals successful. This is expected");
                verification = true;
            } else {
                Utils.logStepInfo(false, elementName + " verification of text not equals failed. Expected: " + expectedText + ", Actual: " + actualText);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " verification of text not equals failed. Expected: " + expectedText + ", Actual: " + actualText);
        }
        return verification;
    }

    public void scrollToElement(WebElement element, String elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Utils.logStepInfo(true, "Scrolled To element: " + elementName);
        waitForPageLoading();
    }

    public void scrollToElement(WebElement element, int timeout, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        Utils.logStepInfo(true, "Scrolled To element: " + elementName);
        waitForPageLoading();
    }

    public String getStoryIdFromURL() {
        commonFunctionsMobile.waitForURLContains(".html");
        String currentUrl = driver.getCurrentUrl();
        int index = currentUrl.lastIndexOf("-");
        int lastIndex = currentUrl.lastIndexOf(".");
        String storyId = currentUrl.substring(index + 1, lastIndex);
        System.out.println("Story id :" +storyId);
        return storyId;
    }

    public boolean checkTextContains(String expectedText, String actualText, String elementName) {
        boolean verification = false;
        try {
            if (actualText.contains(expectedText)) {
                Utils.logStepInfo(true, elementName + " verified text contains successfully");
                verification = true;
            } else {
                Utils.logStepInfo(false, elementName + " verification of text contains failed. Expected: " + expectedText + ", Actual: " + actualText);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " verification of text contains failed. Expected: " + expectedText + ", Actual: " + actualText);
        }
        return verification;
    }

    public boolean checkTextEquals(String expectedText, String actualText, String elementName) {
        boolean verification = false;
        try {
            if (actualText.equals(expectedText)) {
                Utils.logStepInfo(true, elementName + " verified text equals successfully");
                verification = true;
            } else {
                Utils.logStepInfo(false, elementName + " verification of text equals failed. Expected: " + expectedText + ", Actual: " + actualText);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " verification of text equals failed. Expected: " + expectedText + ", Actual: " + actualText);
        }
        return verification;
    }

    public boolean checkPageURL(String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementPageURLExist;
        waitForURLContains(expectedText);
        dummyWait(timeOutInSecond);
        String getPageUrl = driver.getCurrentUrl();
        dummyWait(timeOutInSecond);
        isElementPageURLExist = getPageUrl.contains(expectedText);
        if (isElementPageURLExist) {
            Utils.logStepInfo(true, elementName + " URL verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " URL verification failed. Expected:" + expectedText + ", Actual:" + getPageUrl);
        }
        return isElementPageURLExist;
    }

    public boolean checkPageTitle(String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementPageTitleExist;
        waitForURLContains(".html");
        dummyWait(timeOutInSecond);
        String getPageTitle = driver.getTitle();
        dummyWait(timeOutInSecond);
        isElementPageTitleExist = getPageTitle.contains(expectedText);
        if (isElementPageTitleExist) {
            Utils.logStepInfo(true, elementName + " verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
        }
        Utils.logStepInfo(isElementPageTitleExist, elementName + " Actual:: " + getPageTitle + "," + "Expected::" + expectedText);

        return isElementPageTitleExist;
    }

    public boolean checkCSSProperty(WebElement element, String propertyName, String propertyValue, String elementName) {
        boolean verification = false;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.attributeContains(element, propertyName, propertyValue));
        String actualPropertyValue = element.getCssValue(propertyName);
        try {
            if (actualPropertyValue.contains(propertyValue)) {
                Utils.logStepInfo(true, "Verified css property successfully for " + elementName + ". PropertyName: " + propertyName + ", PropertyValue:" + propertyValue);
                verification = true;
            } else {
                Utils.logStepInfo(false, "Verification css property failed for " + elementName + ". Expected PropertyName: " + propertyName + ", Expected PropertyValue:" + propertyValue + ", Actual PropertyValue:" + actualPropertyValue);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, "Verification css property failed for " + elementName + ". Expected PropertyName: " + propertyName + ", Expected PropertyValue:" + propertyValue + ", Actual PropertyValue:" + actualPropertyValue);
        }
        return verification;
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
        Utils.logStepInfo(true, "Scrolled To Top ");
        waitForPageLoading();
    }

    public void scrollWithCoOrdinates(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + ", " + y + ")");
        Utils.logStepInfo(true, "Scrolled To Coordinates: " + x + ", " + y);
        waitForPageLoading();
    }

    public void closePopupIfExist(WebElement element, String elementName) {
        closePopupIfExist(element, elementName, 0);
    }

    public void closePopupIfExist(WebElement element, String elementName, int timeOut) {
        try {
            if (timeOut == 0) {
                timeOut = 15;
            }
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isDisplayed()) {
                element.click();
                Utils.logStepInfo(elementName + " Popup closed");
            }
        } catch (Exception e) {

        }
    }

    public String getProperty(MobileElement element, String propertyName) {
        String value = null;
        try {
            value = element.getAttribute(propertyName);
        } catch (Exception e) {
        }
        return value;
    }

    public String getProperty(WebElement element, String propertyName) {
        String value = null;
        try {
            value = element.getAttribute(propertyName);
        } catch (Exception e) {
        }
        return value;
    }


    public String getTitle() {
        String value = null;
        try {
            value = driver.getTitle();
        } catch (Exception e) {
        }
        return value;
    }


    public boolean checkPropertyContains(WebElement element, String propertyName, String propertyValue, String elementName) {
        boolean verification = false;
        String actualPropertyValue = element.getAttribute(propertyName);
        try {
            if (actualPropertyValue.contains(propertyValue)) {
                Utils.logStepInfo(true, "Verified property contains successfully for " + elementName + ". PropertyName: " + propertyName + ", PropertyValue:" + propertyValue);
                verification = true;
            } else {
                Utils.logStepInfo(false, "Verification property contains failed for " + elementName + ". Expected PropertyName: " + propertyName + ", Expected PropertyValue:" + propertyValue + ", Actual PropertyValue:" + actualPropertyValue);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, "Verification property contains failed for " + elementName + ". Expected PropertyName: " + propertyName + ", Expected PropertyValue:" + propertyValue + ", Actual PropertyValue:" + actualPropertyValue);
        }
        return verification;
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        try {
            Actions action = new Actions(driver);
            action.dragAndDrop(source, target).build().perform();
            Utils.logStepInfo(true, "drag and drop, source: " + source + ", target: " + target);
            isElementDisplayed(source, 3);
        } catch (Exception e) {
            Utils.logStepInfo("exception in drag and drop, source: " + source + ", target: " + target);
        }
    }

    public boolean clickElementWithCoordinates(int x1, int y1) {
        boolean isElementClicked = false;
        try {
            TouchAction action = new TouchAction(driver)
                    .press(PointOption.point(x1, y1))
                    .release().perform();
            isElementClicked = true;
            Utils.logStepInfo(true, "Element clicked successfully");
        } catch (Exception e) {
            System.out.println("Exception capture " + e.getMessage());
        }
        return isElementClicked;
    }

    public boolean isElementNotDisplayed(WebElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = true;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementDisplayed = false;
            Utils.logStepInfo(false, elementName + " displayed.This is not expected.Element should not be visible");
        } catch (Exception e) {
            isElementDisplayed = true;
            Utils.logStepInfo(true, elementName + " not displayed.This is expected");
        }
        return isElementDisplayed;
    }

    public boolean isElementNotDisplayed(MobileElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = true;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementDisplayed = false;
            Utils.logStepInfo(false, elementName + " displayed. This is not expected. Element should not be visible");
        } catch (Exception e) {
            Utils.logStepInfo(true, elementName + " not displayed. This is expected");
        }
        return isElementDisplayed;
    }


    public boolean swipeElementUsingTouchAction(int x1, int y1, int x2, int y2) {
        boolean isElementClicked = false;
        try {
            TouchAction action = new TouchAction(driver);
            PointOption startPoint = PointOption.point(x1, y1);
            PointOption endPoint = PointOption.point(x2, y2);
            action.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).moveTo(endPoint).release().perform();
            isElementClicked = true;
            System.out.println("Done swipe action: " + x1 + ", " + y1 + ", " + x2 + ", " + y2);
        } catch (Exception e) {
            System.out.println("Exception in swipe action: " + e.getMessage());
            System.out.println("Unable to swipe action with coordinates: " + x1 + ", " + y1 + ", " + x2 + ", " + y2);
        }
        return isElementClicked;
    }


    public boolean tapElementWithCoOrdinates(int x, int y) {
        boolean isElementClicked = false;
        try {
            TouchAction action = new TouchAction(driver);
            PointOption pointOption = PointOption.point(x, y);
            action.tap(pointOption).perform();
            isElementClicked = true;
            dummyWait(2);
            Utils.logStepInfo(true, "Tap Element Done With CoOrdinates");
        } catch (Exception e) {
            System.out.println("Exception in tapElementWithCoOrdinates " + e.getMessage());
        }
        return isElementClicked;
    }

    public boolean tapElementWithCoOrdinates(int x, int y, String elementName) {
        boolean isElementClicked = false;
        try {
            TouchAction action = new TouchAction(driver);
            PointOption pointOption = PointOption.point(x, y);
            action.tap(pointOption).perform();
            isElementClicked = true;
            dummyWait(2);
            Utils.logStepInfo(true, "Tap Element Done With CoOrdinates, ElementName: " + elementName + ", CoOrdinates:" + x + ", " + y);
        } catch (Exception e) {
            Utils.logStepInfo(false, "Exception in tapElementWithCoOrdinates " + e.getMessage());
        }
        return isElementClicked;
    }

    public void sendKeyStroke(Keys key) {
        try {
            globalVars.getAppiumDriver().getKeyboard().sendKeys(key);
            Utils.logStepInfo(true, "Key send successfully: " + key);
        } catch (Exception e) {

        }
    }

    public boolean checkElementTextReload(MobileElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist = false;
        String actualText = null;
        try {
            dummyWait(2);
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
//        isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            actualText = element.getText();
            System.out.println("********** Expected element text: " + expectedText);
            System.out.println("******** Actual element text found: " + actualText);
            if (actualText.equalsIgnoreCase(expectedText)) {
                Utils.logStepInfo(true, elementName + " verified successfully");
                isElementWithTextExist = true;
            } else {
                Utils.logStepInfo(false, elementName + " verification failed. Expected: " + expectedText + ", Actual:" + actualText);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " verification failed. Expected: " + expectedText + ", Actual:" + actualText);
        }
//        Utils.logStepInfo(isElementWithTextExist, elementName + " found: " + element.getText().trim());
        return isElementWithTextExist;
    }

    public String getAlertText(String alertName, int timeOut) {
        String text = "";
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.alertIsPresent());
            text = driver.switchTo().alert().getText();
            Utils.logStepInfo(true, "Text captured from alert: " + text);
        } catch (Exception e) {
            Utils.logStepInfo("Got Exception while capturing text from alert: " + alertName);
            e.printStackTrace();
        }
        return text;
    }


    public WebElement returnElementByXpath(String xpath) {
        globalVars.getAppiumDriver().findElement(By.xpath(xpath));
        return null;
    }

    public void pageRefresh() {
        driver.navigate().refresh();
        waitForPageLoading();
    }

    public boolean switchToFrame(WebElement element, int timeOut, String elementName) {
        boolean isSwitchSuccessful = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            driver.switchTo().frame(element);
            isSwitchSuccessful = true;
            System.out.println("switchToFrame: " + elementName);
        } catch (Exception exception) {
            System.out.println(elementName + " frame is not available: " + elementName + exception.getMessage());
        }
        return isSwitchSuccessful;
    }

    public String getCSSProperty(WebElement element, String propertyName, String elementName) {
        String value = null;

        try {
            value = element.getCssValue(propertyName);
            Utils.logStepInfo(true, "Capture css property for " + elementName + ". PropertyName: " + propertyName + ", PropertyValue:" + value);
        } catch (Exception e) {
            Utils.logStepInfo(false, "Unable Capture css property for " + elementName + ". PropertyName: " + propertyName + ", PropertyValue:" + value);
        }
        return value;
    }

    public boolean navigateBack() {
        boolean isBack = false;
        driver.navigate().back();
        System.out.println("Navigate back is successfully");
        return isBack;
    }


    public TouchAction clickByCoordinates(int x, int y) {
        TouchAction isClicked;
        isClicked = new TouchAction(driver).tap(PointOption.point(x, y)).release().perform();
        Utils.logStepInfo(true,"****** Clicked by coordinates - " +x+ " && " +y+ " *******");
        return isClicked;
    }

    public void clear(MobileElement element, String elementName) {

        try {
            element.clear();
            System.out.println("cleared the text field: " + elementName);
        } catch (Exception e) {
            System.out.println("unable to clear the text field: " + elementName);
        }

    }

    public WebElement getFocus() {
        waitForPageLoading();
        WebElement element = driver.switchTo().activeElement();
        return element;
    }

    public boolean checkFocus(String focus, String newFocus, String elementName) {
        boolean isFocus = false;
        try {
            if (focus.equals(newFocus)) {
                Utils.logStepInfo(true, elementName + " is same");
                isFocus = true;
            } else {
                Utils.logStepInfo(true, elementName + " is not the same");
            }
        } catch (Exception e) {
            Utils.logStepInfo(true, elementName + " is not the same");
        }
        return isFocus;
    }

    public boolean switchToWindowWithTitle(String title) {
        boolean isSwitchSuccessful = false;
        try {
            Set<String> allHandles = driver.getWindowHandles();
            for (String handle : allHandles) {
                driver.switchTo().window(handle);
                String actualTitle = driver.getTitle();
                if (actualTitle.toLowerCase().contains(title.toLowerCase())) {
                    Utils.logStepInfo(true, "switched to window with title: " + title);
                    isSwitchSuccessful = true;
                    break;
                }
            }
            if (!isSwitchSuccessful) {
                System.out.println("Can not find the window with title: " + title);
                driver.switchTo().defaultContent();
            }
        } catch (Exception e) {
            System.out.println("Got exception while switching to window with title: " + title);
            e.printStackTrace();
        }
        return isSwitchSuccessful;
    }


    public boolean switchToWindowWithTitle(String title, int timeOut, int numberOfWindows) {
        boolean isSwitchSuccessful = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
            Set<String> allHandles = driver.getWindowHandles();
            for (String handle : allHandles) {
                driver.switchTo().window(handle);
                String actualTitle = driver.getTitle();
                if (actualTitle.toLowerCase().contains(title.toLowerCase())) {
                    Utils.logStepInfo(true, "switched to window with title: " + title);
                    isSwitchSuccessful = true;
                    break;
                }
            }
            if (!isSwitchSuccessful) {
                Utils.logStepInfo(true, "Can not find the window with title: " + title);
                driver.switchTo().defaultContent();
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, "Got exception while switching to window with title: " + title);
            e.printStackTrace();
        }
        return isSwitchSuccessful;

    }

    public boolean dragAndDrop2(MobileElement source, MobileElement target) {
        boolean result = false;
        Actions action = new Actions(driver);
        action.moveToElement(source).click(source).clickAndHold(source)
                .moveToElement(target).release(target).click().build().perform();
        boolean isDragFailed = isElementDisplayed(source, 10);
        for (int i = 1; i <= 5; i++) {
            if (isDragFailed) {
                System.out.println("Drag Failed, iteration : " + i);
                action = new Actions(driver);
                action.moveToElement(source).click(source).clickAndHold(source)
                        .moveToElement(target).release(target).click().build().perform();
                isDragFailed = isElementDisplayed(source, 10);
            } else {
                System.out.println("Drag Passed, iteration : " + i);
                result = true;
                break;
            }
        }
        return result;

    }

    public boolean switchToFrame(WebElement element, int timeOut) {
        boolean isSwitchSuccessful = false;
        WebDriverWait wait;
        try {
            driver.switchTo().parentFrame();
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            driver.switchTo().frame(element);
            isSwitchSuccessful = true;
        } catch (Exception exception) {
            System.out.println("****** Exception in switchToFrame() method: " + exception.getMessage());
        }

        return isSwitchSuccessful;
    }

    public boolean switchToFrame(String frame, int timeOut) {
        boolean isSwitchSuccessful = false;
        WebDriverWait wait;
        try {
            driver.switchTo().parentFrame();
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
            driver.switchTo().frame(frame);
            isSwitchSuccessful = true;
        } catch (Exception exception) {
            System.out.println("****** Exception in switchToFrame() method: " + exception.getMessage());
        }

        return isSwitchSuccessful;
    }

    public void sendKey(WebElement element, String key, int timeOut, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(key);
        Utils.logStepInfo(true, "Send " + key + " to " + elementName + " successfully");
    }

//	public void closeAppAndRelaunch() {
//		System.out.println("******************* closeAppAndRelaunch() starts here ********");
//		try {
//			driver = globalVars.getAppiumDriver();
//			if (driver != null) {
//				driver.quit();
//				globalVars.setAppiumDriver(null);
//			}
//			    TestBase testBase = TestBase.getInstance();
//				testBase.initializeDriver();
//		} catch (Exception exception) {
//			exception.printStackTrace();
//		}
//		System.out.println("******************* closeAppAndRelaunch() ends here ********");
//	}

    public boolean sendKeysOnAndroid(MobileElement element, String text) {
        boolean isTextDisplayed = false;
        element.sendKeys(text);
        return isTextDisplayed;
    }

    public void tapOnTop() {

        TouchAction touch = new TouchAction(driver);
        touch.tap(PointOption.point(505, 605)).perform();

    }

    public void chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("w3c", false);
    }

    public boolean isVisible(MobileElement element) {
        try {
            element.isDisplayed();
            Utils.logStepInfo(true,"Element is Visible");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(MobileElement element, long timeOutInSecond, String elementName) {
        boolean isElementVisibileTrue = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            Utils.logStepInfo(true, elementName + " available");
            isElementVisibileTrue = true;
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " is not available");
            isElementVisibileTrue = false;
        }
        return isElementVisibileTrue;
    }

    public boolean scrollUpToElementDisplayed(MobileElement element) {
        boolean isElementVisibileTrue = false;
        TouchAction action = new TouchAction(driver);
        Dimension size = ((WebDriver) driver).manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        boolean isDisplayed = isVisible(element);
        while (!isDisplayed) {
            action.press(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.90)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.10))).release()
                    .perform();
            isDisplayed = isVisible(element);
        }
        return isElementVisibileTrue;
    }

    public void scrollDownToPage(double x, double y) {

        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        action.press(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * x)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * y))).release().perform();
    }

    public boolean scrollUsingAction(WebElement element, String elementName) {
        try {
            Actions actions = new Actions(driver);
            Thread.sleep(10000);
            actions.moveToElement(element).build().perform();
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getCurrentURL(String title, String elementName) {
        try {
            title = driver.getCurrentUrl();
            Utils.logStepInfo(true, elementName + " URL Available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }

    public boolean scrollToElementView(WebElement element, int timeOutInSecond, String elementName) {
        boolean isStepTrue = false;
        try {
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            isStepTrue = true;
            Utils.logStepInfo(true, elementName + " scroll down and available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isStepTrue;

    }

    public boolean scrollToElementViewAndClick(WebElement element, int timeOutInSecond, String elementName) {
        boolean isStepTrue = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            executor.executeScript("arguments[0].click();", element);
            isStepTrue = true;
            Utils.logStepInfo(true, elementName + " available and clicked on successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isStepTrue;
    }

    public void elementToTextDisplayed(String elementName) {
        Utils.logStepInfo(true, elementName + " displayed");
    }

    public boolean scrollUsingResourceID(MobileElement element, String elementName) {
        boolean isScrolled = false;
        try {
            ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"" + element + "\"));");
            isScrolled = true;
            Utils.logStepInfo(true, "Scrolled to Element " + elementName + " successful");
        } catch (Exception e) {
            System.out.println("element not found");
            Utils.logStepInfo(false, "Scrolled to Element " + elementName + " failed");
        }
        return isScrolled;
    }

    public void changeDriverContextToNative() {

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE")) {
                driver.context(contextName);
            }
        }

    }

    public void changeContextToWeb() {

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW_chrome")) {
                driver.context(contextName);
            }
        }

    }

    public void changeDriverContextToWeb(AppiumDriver<MobileElement> driver) throws InterruptedException {
        Thread.sleep(8000);
        Set<String> allContext = ((AppiumDriver<MobileElement>) driver).getContextHandles();
        for (String context : allContext) {
            if (context.contains("WEBVIEW_chrome")) {
                try {
                    driver.context(context);
                } catch (Exception e) {
                    System.out.println("Exception Occured " + e.getMessage());
                }
                System.out.println(context);
            }
        }

        System.out.println("Completed");

    }

    public void tapByCoordinate(int x, int y, String elementName) {
        TouchAction touch = new TouchAction(driver);
        touch.tap(PointOption.point(x, y)).perform();
        Utils.logStepInfo(elementName + "  Clicked Successfully");
    }

    public boolean pressEnterKey() {
        boolean isElementEnterKey = false;
        AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) driver;
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        // driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.logStepInfo(true, "Enter button clicked successfully");
        return isElementEnterKey;
    }


    public boolean OpenKeyBoard() {
        try {
            ((HasOnScreenKeyboard) driver).isKeyboardShown();
            Utils.logStepInfo(true, "Mobile KeyBoard is Open");
        } catch (Exception e) {
            e.getMessage();
        }
        return true;
    }

    public static void changeContextToNative() {
        //driver.activateApp("com.imurchie.SafariLauncher");
        Set<String> allContext = driver.getContextHandles();
        for (String context : allContext) {
            if (context.contains("NATIVE_APP"))
                driver.context(context);

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utils.logStepInfo("Successfully Switched to Native");
        }
    }

    public static void changeDriverContextToWeb() {
        Set<String> allContext = driver.getContextHandles();
        for (String context : allContext) {
            if (context.contains("WEBVIEW"))
                driver.context(context);
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Utils.logStepInfo("Successfully Switched to webview");
        }
    }

    public boolean toastMessage(WebElement element) {
        boolean isElementfound = false;
        try {
            WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
            String text = toastView.getAttribute("popup");
            System.out.println("toast message text : " + text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementfound;
    }

    public String extractStoryID(String s) {

        String storyID = "";
        Pattern p;
        if (s.contains("-amp.")) {
            p = Pattern.compile("\\-([0-9]+)");
        } else {
            p = Pattern.compile("\\-([0-9]+)\\.");
        }
        Matcher m = p.matcher(s);

        while (m.find()) {
            storyID = m.group(1);
        }
        return storyID;
    }


    public Response getResponseFromURI(String uri, String code) {
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(code);
        return response;
    }

    public boolean checkVideoPauseButton() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            Thread.sleep(10000);
            executor.executeScript("jwplayer().pause();");
            Thread.sleep(10000);
            Utils.logStepInfo(true, "video pause button available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkVideoPlayButton() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            Thread.sleep(10000);
            executor.executeScript("jwplayer().play();");
            Thread.sleep(10000);
            Utils.logStepInfo(true, "video play button available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkVideoMuteAndVolumeButton() {
        try {
            JavascriptExecutor executor = driver;
            Thread.sleep(4000);
            executor.executeScript("jwplayer().getMute();");
            Thread.sleep(4000);
            executor.executeScript("jwplayer().getVolume;");
            Thread.sleep(4000);
            Utils.logStepInfo(true, "Mute and Volume buttons available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getURL(String url) {
        driver.get(url);
        Utils.logStepInfo(url + "  launched successfully");
        return url;
    }

    public void navigateURl(String text) {

        driver.navigate().to(text);
        Utils.logStepInfo("Successfully redirected to the Given URL");
    }

    public void scrollDownToBottom() {

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Utils.logStepInfo("Successfully scrolled to Bottom of the Page");

    }

    public void switchToNative() {

        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {

            driver.context("NATIVE_APP");
            Utils.logStepInfo("Successfully switched to Native App");

        }

    }

    public void scrollUpToTop() {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Utils.logStepInfo("Successfully scrolled to Bottom of the Page");

    }

    public String getURL() {
        String url = null;
        try {
            url = driver.getCurrentUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public void pressBackKey() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        Utils.logStepInfo(true, "Back button clicked successfully");
    }

    public boolean scrollTillVisibleText(MobileElement text, String elementName) {
        boolean isScrollAndVisible = false;
        try {
            ((AndroidDriver<AndroidElement>) driver).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
            isScrollAndVisible = true;
            Utils.logStepInfo(true, "text visible  " + elementName + " successful");
        } catch (Exception e) {
            Utils.logStepInfo(false, "text visible" + elementName + "  failed");
        }
        return isScrollAndVisible;
    }

    public void scrollToBottom() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        action.press(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.95)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.10))).release().perform();
    }

    public void scrollToBottomOniOSNative() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
        Utils.logStepInfo("Page is scrolled to Bottom successfully !!!!!!");
    }

    public void scrollToTopOniOSNative() {
        JavascriptExecutor js = driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: scroll", scrollObject);
        Utils.logStepInfo(true, " Page is scrolled to top successfully !!!!!!");
    }

    public boolean scrollToMobileElement(MobileElement element) {
        boolean isElementFound = false;
        int i = 15;
        while (i > 0) {
            if (commonFunctionsMobile.isElementDisplayed(element)) {
                isElementFound = true;
                break;
            } else {
                commonFunctionsMobile.scrollDown();
                i--;
            }

        }
        return isElementFound;

    }

    public void scrollUsingNameiOS(String name) {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "down");
        args.put("name", name);
        driver.executeScript("mobile: scroll", args);

    }

    public void scrollUsingValueiOS(String value) {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "up");
        args.put("name", value);
        driver.executeScript("mobile: scroll", args);

    }

    public void goToURL(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCurrentURL(String url, int timeUnit) {
        String title = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeUnit);
            wait.until(ExpectedConditions.urlContains(url));
            title = driver.getCurrentUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }

    public String getCurrentURL(String elementName) {
        String title = null;
        try {
            title = driver.getCurrentUrl();
            Utils.logStepInfo(true, elementName + " URL Available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }

    public void scrollDownOnce() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Utils.logStepInfo(true, "Scrolled Down");
    }

    public void waitForURLToBe(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.urlToBe(text));
        } catch (Exception e) {

        }

    }


    public boolean dummyWait(int timeOut) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Dummy")));
        } catch (Exception e) {
            System.out.println("Wait for " + timeOut + " sec");
        }
        return isElementDisplayed;
    }

    public boolean scrollUntilElementFound(WebElement elementToScroll) {
        boolean isElementDisplayed = false;
        try {
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        if (isElementDisplayed(elementToScroll,5)){
            isElementDisplayed = true;
            Utils.logStepInfo(true, " Element is displaying.");
        }
        else{
            for (int i = 0; i < 6; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                    if (isElementDisplayed(elementToScroll, 5)) {
                        isElementDisplayed = true;
                        Utils.logStepInfo(true, " Element is displaying.");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            isElementDisplayed = false;
            Utils.logStepInfo(false, " Element is Not displayed");
        }
        return isElementDisplayed;
    }

    public boolean scrollUpUntilElementFound(WebElement elementToScroll) {
        boolean isElementDisplayed = false;
        for (int i = 0; i < 4; i++) {
            new TouchAction(driver).press(PointOption.point(500, 400)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                    moveTo(PointOption.point(500, 700)).release().perform();
            if (isElementDisplayed(elementToScroll, 5)) {
                isElementDisplayed = true;
                break;
            }
        }
        return isElementDisplayed;
    }

    public boolean scrollDownToElement(MobileElement elementToScroll) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            if (isElementClickable(elementToScroll, 5, "Element looking for is")){
                isScrollDownToElement = true;
            }
            else{
            for (int i = 0; i < 20; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                System.out.println(i + 1 + " Time Scrolling for element.");
                if (isElementClickable(elementToScroll, 5, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }}
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public boolean scrollDownToElement(MobileElement elementToScroll, MobileElement homeSectionElementLocator) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < 20; i++) {
                if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE) && globalVars.getApplicationName().equalsIgnoreCase(Constants.HINDUSTAN_TIMES) && i < 4) {
                    toGetRidOfAd(homeSectionElementLocator, 2);
                }
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                System.out.println(i + 1 + " Time Scrolling for element.");
                if (isElementClickable(elementToScroll, 2, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public boolean scrollDownToElementWithWhile(MobileElement elementToScroll) {
        boolean isScrollDownToElement = false;
        int i = 0;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;

            boolean isDisplayed = isVisible(elementToScroll);
            while (!isDisplayed && i <= 20) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                isDisplayed = isVisible(elementToScroll);
                i++;
            }
            isScrollDownToElement = isDisplayed;
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public boolean scrollToBottomForAndroidNative() {

        int x = driver.manage().window().getSize().width / 2;
        int start_y = (int) (driver.manage().window().getSize().height * 0.2);
        int end_y = (int) (driver.manage().window().getSize().height * 0.8);
        TouchAction dragNDrop = new TouchAction(driver)
                .press(PointOption.point(x, end_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, start_y))
                .release();
        dragNDrop.perform();
        return true;
    }

    public boolean scrollDownToElement(WebElement elementToScroll) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < 10; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                if (isElementClickable(elementToScroll, 5, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public String getStringWithoutAngularBrackets(String str) {
        String finalStr = str;
        finalStr = finalStr.replaceAll("\\<(.*?)\\>", "");
        return finalStr;
    }

    public void clearText(WebElement element, String elementName) {

        try {
            element.clear();
            System.out.println("cleared the text field: " + elementName);
        } catch (Exception e) {
            System.out.println("unable to clear the text field: " + elementName);
        }

    }

    public boolean isCompareTextTrue(String actualText, String expectedText) {
        boolean isCompareTextTrue = false;
        try {
            if (actualText.equalsIgnoreCase(expectedText)) {
                isCompareTextTrue = true;
                Utils.logStepInfo(true, actualText + " matching with " + expectedText);
            }
        } catch (Exception e) {
            isCompareTextTrue = false;
            Utils.logStepInfo(false, actualText + " not matching with " + expectedText);
            e.printStackTrace();
        }
        return isCompareTextTrue;
    }

    public boolean scrollDownToElement(MobileElement elementToScroll, String text) {
        boolean isScrollDownToElement = false;
        String elementName = null;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < 10; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 2, height / 9)).release().perform();
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 2, height / 9)).release().perform();
                elementName = elementToScroll.getText().trim();
                if (isElementClickable(elementToScroll, 5, "text") && elementName.equalsIgnoreCase(text) && elementToScroll.isDisplayed()) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public void tapBackButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public boolean isElementDisplayedOfListOfElements(List<MobileElement> eleList, String elementName) {
        boolean isElementsDisplayedTrue = false;
        try {
            for (MobileElement ele : eleList) {
                if (ele.isDisplayed()) {
                    isElementsDisplayedTrue = true;
                    Utils.logStepInfo(true, elementName + " are all displaying.");

                }
            }
        } catch (Exception e) {
            isElementsDisplayedTrue = false;
            Utils.logStepInfo(false, elementName + " are not displaying.");
            e.printStackTrace();
        }
        return isElementsDisplayedTrue;
    }

    public boolean isElementDisplayedOfListOfWebElements(List<WebElement> eleList, String elementName) {
        boolean isElementsDisplayedTrue = false;
        try {
            for (WebElement ele : eleList) {
                if (ele.isDisplayed()) {
                    isElementsDisplayedTrue = true;
                    Utils.logStepInfo(true, elementName + " are all displaying.");

                }
            }
        } catch (Exception e) {
            isElementsDisplayedTrue = false;
            Utils.logStepInfo(false, elementName + " are not displaying.");
            e.printStackTrace();
        }
        return isElementsDisplayedTrue;
    }

    public void clickElementIgnoringStaleElementReferenceException(WebElement element, int timeOut, String elementName) {

        Actions actions = new Actions(driver);
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOut)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        actions.moveToElement(element).click().build().perform();
        //element.click();
        Utils.logStepInfo(true, "click on " + elementName + " successfully");
    }

    public void closeAllWindowsExceptMasterTab() {
        try {
            ArrayList<String> handleList = new ArrayList<>(driver.getWindowHandles());

            if (handleList.size() > 1) {

                for (int i = 1; i < handleList.size(); i++) {
                    driver.switchTo().window(handleList.get(i));
                    driver.close();
                }
                driver.switchTo().window(handleList.get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickElementAndHoldWithActions(WebElement elementToBeClicked, WebElement elementToBeVisible, int timeOut, String elementName) {

        WebDriverWait wait = new WebDriverWait(driver, timeOut / 4);

        try {
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.hdr-hmcnt")));
            for (int i = 0; i < 4; i++) {
                //wait.until(ExpectedConditions.visibilityOf(elementToBeClicked));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.menu-hdr")));
                Thread.sleep(3000);
                Actions actions = new Actions(driver);
                actions.clickAndHold(elementToBeClicked).release().perform();
                if (isElementDisplayed(elementToBeVisible)) {
                    break;
                }
            }

        } catch (Exception exception) {
            System.out.println("************* Exception in clickElementAndHoldWithActions() method : " + exception.getMessage());
        }

        Utils.logStepInfo(true, "click on " + elementName + " successfully");

    }

    public void navigateToHomePage() {
        commonFunctionsMobile.navigateToURL(globalVars.getURL());
    }

    public void switchToNewFrame(String frame, WebElement ele) {
        String parent = driver.getWindowHandle();
        driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
        clickElement(ele, 60);
        driver.switchTo().window(parent);
    }

    //returns true if signButton is present on the home page i.e. preset is already true else it will do the preset and return false
    public boolean presetHomePage(WebElement signInButton) {
        closeAllWindowsExceptMasterTab();
        driver = globalVars.getAppiumDriver();
        if (isElementDisplayed(signInButton, 10)) {
            return true;
        } else {
            driverController.navigateToApplicationHomePage(true);
            return false;
        }
    }

    // SMARTCAST COMMON FUNCTIONS

    public boolean isElementDisplayedAndPresent(WebElement elements, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            Utils.logStepInfo(true, elementName + " available");
            isElementDisplayed = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isElementDisplayed;
    }


    public void selectElement(WebElement ele, String byVisbilityText) {
        Select sel = new Select(ele);
        try {
            sel.selectByVisibleText(byVisbilityText);
            Utils.logStepInfo(true, "selecting values as " + byVisbilityText + " selected");
        } catch (Exception e) {
            Utils.logStepInfo(false, "selecting values as " + byVisbilityText + " is not selected");
            e.printStackTrace();
        }
    }


    public boolean checkSelectElement(WebElement ele, String byVisbilityText) {
        boolean isOptionSelected;
        Select sel = new Select(ele);
        try {
            sel.selectByVisibleText(byVisbilityText);
            isOptionSelected = true;
            Utils.logStepInfo(true, "selecting values as " + byVisbilityText + " selected");
        } catch (Exception e) {
            Utils.logStepInfo(false, "selecting values as " + byVisbilityText + " is not selected");
            isOptionSelected = false;
            e.printStackTrace();
        }
        return isOptionSelected;
    }


    public String appendTexts(String firstText, String secondText) {
        String text = "";
        try {
            text = firstText + " " + secondText;
            Utils.logStepInfo(true, text + " is made of " + firstText + " and " + secondText);
        } catch (Exception e) {
            Utils.logStepInfo(false, text + " is made of " + firstText + " and " + secondText);
            e.printStackTrace();
        }
        return text;
    }


    public boolean actualCompleteText(WebElement ele, String completeExpectedTxt, String removeText) {
        boolean isActualCompleteText = false;
        String text;
        try {
            text = ele.getText().trim().replace(removeText, "");
            if (text.equalsIgnoreCase(completeExpectedTxt)) {
                isActualCompleteText = true;
                Utils.logStepInfo(isActualCompleteText, completeExpectedTxt + " is matching with " + text);
            }
        } catch (Exception e) {
            isActualCompleteText = false;
            System.out.println("-----------------actualCompleteText Failed>>>>>>>>>>>>>>" + e.getMessage());
            Utils.logStepInfo(isActualCompleteText, completeExpectedTxt + " is not matching.");
            e.printStackTrace();
        }
        return isActualCompleteText;
    }

    public boolean scrollToViewElement(WebElement ele, String elementName, int timeOutInSecond) {
        boolean isScrollToViewElement;
        String eleText;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(ele));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
            eleText = ele.getText().trim();
            isScrollToViewElement = true;
            Utils.logStepInfo(true, elementName + " is available as " + eleText);
        } catch (Exception e) {
            isScrollToViewElement = false;
            Utils.logStepInfo(false, elementName + " is not available.");
            e.printStackTrace();
        }
        return isScrollToViewElement;
    }


    public boolean validateGetTextByTabular(List<WebElement> eleList, String elementsName) {
        boolean isValidateGetTextByTabular = false;
        JavascriptExecutor js;
        String text;
        try {
            js = (JavascriptExecutor) driver;
            for (WebElement ele : eleList) {
                text = (String) js.executeScript("return jQuery(arguments[0]).text();", ele);
                if (!text.isEmpty()) {
                    isValidateGetTextByTabular = true;
                    Utils.logStepInfo(true, text + " found " + elementsName);
                } else {
                    isValidateGetTextByTabular = false;
                }
            }
            if (isValidateGetTextByTabular == true) {
                Utils.logStepInfo(isValidateGetTextByTabular, "Text value is availbale for all " + elementsName);
            } else {
                Utils.logStepInfo(isValidateGetTextByTabular, "Text value is not availbale for all " + elementsName);
            }
        } catch (Exception e) {
            Utils.logStepInfo("=====================> validateGetTextByTabular <===============");
            e.printStackTrace();
        }
        return isValidateGetTextByTabular;
    }


    public boolean scrollToBottomWorked() {
        boolean isScrollToBottomTrue;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Utils.logStepInfo(true, "Scrolled To Bottom worked");
            waitForPageLoading();
            isScrollToBottomTrue = true;
        } catch (Exception e) {
            isScrollToBottomTrue = false;
            Utils.logStepInfo(false, "Scrolled To Bottom did not happen.");
            e.printStackTrace();
        }
        return isScrollToBottomTrue;
    }

    public String getCurrentPageTile() {
        return driver.getTitle().trim();
    }

    public boolean checkTextContainByCurrentURL(String textToCompareWith, String instantName) {
        boolean isTextContainsTrue = false;
        String actualText = "";
        try {
            actualText = getCurrentPageTile();
            if (Pattern.compile(Pattern.quote(textToCompareWith), Pattern.CASE_INSENSITIVE).matcher(actualText).find()) {
                isTextContainsTrue = true;
                Utils.logStepInfo(true, instantName + " is verified.");
            }
        } catch (Exception e) {
            isTextContainsTrue = true;
            Utils.logStepInfo(true, instantName + " is not verified.");
        }
        return isTextContainsTrue;
    }


    public boolean isTextContains(String actualContainingText, String expectedText) {
        boolean isTextContainsTrue = false;
        try {
            if (actualContainingText.contains(expectedText)) {
                isTextContainsTrue = true;
                Utils.logStepInfo(true, expectedText + " is contained by " + actualContainingText);
            }
        } catch (Exception e) {
            isTextContainsTrue = false;
            Utils.logStepInfo(false, expectedText + " is not contained by " + actualContainingText);
        }
        return isTextContainsTrue;
    }

    public String getTextsFromList(List<WebElement> eleList, int timeOutInSecond, String elementName) {
        String str = null;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            for (WebElement ele : eleList) {
                str = getElementText(ele, 10);
                Utils.logStepInfo(true, "Successfully Found " + elementName + ":\n" + str);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, "Either element is not present or it could not have any text value.");
            e.printStackTrace();
        }
        return str;
    }

    public boolean compareTexts(String firstText, String secondText) {
        boolean isCompareTexts = false;
        try {
            if (firstText.equalsIgnoreCase(secondText)) {
                isCompareTexts = true;
                Utils.logStepInfo(isCompareTexts, firstText + " and " + secondText + " both are matching.");
            }
        } catch (Exception e) {
            isCompareTexts = false;
            Utils.logStepInfo(isCompareTexts, "Strings are not matching.");
            e.printStackTrace();
        }
        return isCompareTexts;
    }


    public boolean getElementsClickable(List<WebElement> elementList, int timeOutInSecond, String elementName) {
        boolean isGetElementClickable = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        Actions actions = new Actions(driver);
        try {
            for (WebElement ele : elementList) {
                actions.moveToElement(ele).build().perform();
                wait.until(ExpectedConditions.elementToBeClickable(ele));
                isGetElementClickable = true;
            }
            Utils.logStepInfo(isGetElementClickable, elementName + " are clickable.");
        } catch (Exception e) {
            isGetElementClickable = false;
            Utils.logStepInfo(isGetElementClickable, elementName + " are not clickable.");
            e.printStackTrace();
        }
        return isGetElementClickable;
    }


    public boolean scrollToViewListOfWebElmentToCompareText(List<WebElement> eleList, int timeOutInSecond, String compareText) {
        boolean isScrollToViewListOfWebElment = false;
        WebDriverWait wait;
        String eleText;
        try {
            for (WebElement ele : eleList) {
                wait = new WebDriverWait(driver, timeOutInSecond);
                wait.until(ExpectedConditions.visibilityOf(ele));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
                eleText = ele.getText().trim();
                if (eleText.equalsIgnoreCase(compareText)) {
                    Utils.logStepInfo(true, eleText + " found as it matches with " + eleText);
                    isScrollToViewListOfWebElment = true;
                }
            }
        } catch (Exception e) {
            isScrollToViewListOfWebElment = false;
            Utils.logStepInfo(false, compareText + " did not matched.");
            e.printStackTrace();
        }
        return isScrollToViewListOfWebElment;
    }


    public void selectElementFromList(List<WebElement> eleList, String expectedText, int timeOutInSecond) {
        String text;
        try {
            for (WebElement ele : eleList) {
                text = ele.getText().trim();
                if (text.equalsIgnoreCase(expectedText)) {
                    clickElementWithJS(ele, timeOutInSecond, "Element related to " + expectedText + " got clicked.");
                }
            }
            Utils.logStepInfo(true, expectedText + " get clicked.");
        } catch (Exception e) {
            Utils.logStepInfo(false, expectedText + " did not get clicked.");
            e.printStackTrace();
        }
    }


    public boolean compareActualTextForCompareCars(WebElement ele, String textToBeRemoved, String text1, String text2) {
        boolean isCompareActualTextForCompareCars = false;
        String str1;
        String[] strArray;
        try {
            str1 = ele.getText().trim().replace(textToBeRemoved, "");
            strArray = str1.split(" vs ");
            if (strArray[0].equalsIgnoreCase(text1) && strArray[1].equalsIgnoreCase(text2)) {
                isCompareActualTextForCompareCars = true;
                Utils.logStepInfo("Text is visible as " + str1);
            }
        } catch (Exception e) {
            Utils.logStepInfo("================> compareActualTextForCompareCars ==========");
            e.printStackTrace();
        }
        return isCompareActualTextForCompareCars;
    }

    public boolean innerScrollLeftToRight(WebDriver driver, WebElement ele, String elementName) {
        boolean isInnerScrollLeftToRightTrue;
        Actions actions;
        try {
            actions = new Actions(driver);
            actions.moveToElement(ele).clickAndHold().moveByOffset(0, 250).release().perform();
            isInnerScrollLeftToRightTrue = true;
            Utils.logStepInfo(true, elementName + " is found during slide");
        } catch (Exception ex) {
            isInnerScrollLeftToRightTrue = false;
            Utils.logStepInfo(false, elementName + " is not found during slide");
            ex.printStackTrace();
        }
        return isInnerScrollLeftToRightTrue;
    }


    public boolean innerScrollLeftToRightForListOfElement(List<WebElement> eleList, long timeOutInSecond, String elementName) {
        boolean isInnerScrollLeftToRightForListOfElement = false;
        boolean isScrollTrue;
        boolean isElementClickableTrue;
        String text = "";
        try {
            for (WebElement ele : eleList) {
                text = ele.getText().trim();
                isScrollTrue = innerScrollLeftToRight(driver, ele, elementName + " with >>" + text);
                isElementClickableTrue = isElementClickable(ele, 20, elementName + " with >>" + text);
                if (isScrollTrue && isElementClickableTrue) {
                    isInnerScrollLeftToRightForListOfElement = true;
                }
            }
            Utils.logStepInfo(true, elementName + " are slidable");
        } catch (Exception e) {
            isInnerScrollLeftToRightForListOfElement = false;
            Utils.logStepInfo(false, elementName + " are not slidable");
            e.printStackTrace();
        }
        return isInnerScrollLeftToRightForListOfElement;
    }


    public String getValueByAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName).trim();
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public boolean checkPageURL(int timeOutInSecond) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            String getPageUrl = driver.getCurrentUrl();
            Utils.logStepInfo(true, " PageUrl found: " + getPageUrl);
        } catch (Exception e) {
            System.out.println("******* PageUrl Not Found ******* " + e);
            e.printStackTrace();
        }
        return true;
    }

    public boolean navigateToSpecificPage(WebElement element, int timeOutInSecond, String elementName) {
        boolean navigateToSpecificPageStatus;
        boolean isUserNavigated = false;
        try {
            isElementDisplayed(element, timeOutInSecond, elementName);
            clickElement(element, timeOutInSecond, elementName);
            isUserNavigated = checkPageURL(timeOutInSecond);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isUserNavigated) {
            navigateToSpecificPageStatus = true;
        } else {
            navigateToSpecificPageStatus = false;
        }
        return navigateToSpecificPageStatus;
    }

    public boolean clickElementsListAndNavigateBack(List<WebElement> eleList1, List<WebElement> eleList2, int timeOutInSecond, String elementName) {
        boolean clickElementListAndNavigateBackStatus;
        boolean isUserNavigated = false;
        WebDriverWait wait;
        try {
            for (int i = 0; i < eleList1.size(); i++) {
                wait = new WebDriverWait(driver, timeOutInSecond);
                wait.until(ExpectedConditions.visibilityOf(eleList1.get(i)));
                wait.until(ExpectedConditions.elementToBeClickable(eleList1.get(i)));
                eleList1.get(i).click();
                Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
                waitForPageToLoad();
                isUserNavigated = checkPageURL(timeOutInSecond);
                getElementListText(eleList2, timeOutInSecond);
                navigateBack(timeOutInSecond);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (isUserNavigated) {
            clickElementListAndNavigateBackStatus = true;
        } else {
            clickElementListAndNavigateBackStatus = false;
        }
        return clickElementListAndNavigateBackStatus;
    }

    public void navigateBack(int timeOutInSecond) {
        try {
            Utils.logStepInfo(true, "********** Navigate back Starts *************");
            driver.navigate().back();
            checkPageURL(timeOutInSecond);
            Utils.logStepInfo(true, "********** Navigate back ends ***************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean checkElementNotPresent(WebElement element) {
        boolean isElementStatus;
        try {
            if (!element.isDisplayed()) {
                isElementStatus = true;
                Utils.logStepInfo("Page not broken");
            } else {
                isElementStatus = false;
                Utils.logStepInfo("Page broken");
            }
        } catch (Exception e) {
            isElementStatus = true;
            Utils.logStepInfo("Page not broken");
        }
        return isElementStatus;
    }


    public boolean checkAllImagesInElements(List<WebElement> eleList, WebElement ele, int timeOutInSecond) {
        boolean checkAllImagesInElementsStatus;
        boolean isLinkClickable = false;
        boolean isLinkDisplayed = false;
        boolean isPageBrokenStatus = false;
        String hrefValue;
        String propValue;

        try {
            for (int i = 0; i < eleList.size(); i++) {
                hrefValue = eleList.get(i).getAttribute("src");
                Utils.logStepInfo(true, "url is " + hrefValue);
                propValue = eleList.get(i).getAttribute("alt").toLowerCase();
                isLinkDisplayed = isElementDisplayed(eleList.get(i), timeOutInSecond, propValue);
                isLinkClickable = isElementClickable(eleList.get(i), timeOutInSecond, propValue);
                isPageBrokenStatus = checkElementNotPresent(ele);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (isLinkClickable && isLinkDisplayed && isPageBrokenStatus) {
            checkAllImagesInElementsStatus = true;
        } else {
            checkAllImagesInElementsStatus = false;
        }
        return checkAllImagesInElementsStatus;
    }

    public boolean checkNumberOfTraysInPage(List<WebElement> eleList, WebElement ele) {
        boolean checkNumberOfTraysInPageStatus;
        boolean isTrayDisplayed = false;
        boolean isPageBrokenStatus = false;
        String trays;
        try {
            for (int i = 0; i < eleList.size(); i++) {
                trays = eleList.get(i).getText().toLowerCase();
                isTrayDisplayed = isElementDisplayed(eleList.get(i), 60, trays);
                isPageBrokenStatus = checkElementNotPresent(ele);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (isTrayDisplayed && isPageBrokenStatus) {
            checkNumberOfTraysInPageStatus = true;
        } else {
            checkNumberOfTraysInPageStatus = false;
        }
        return checkNumberOfTraysInPageStatus;
    }

    public boolean getElementListText(List<WebElement> eleList, int timeOutInSecond) {
        boolean getElementListTextStatus;
        boolean isTextDisplayed = false;
        WebDriverWait wait;
        String text;
        try {
            for (int i = 0; i < eleList.size(); i++) {
                wait = new WebDriverWait(driver, timeOutInSecond);
                wait.until(ExpectedConditions.visibilityOf(eleList.get(i)));
                text = eleList.get(i).getText().toLowerCase();
                isTextDisplayed = isElementDisplayed(eleList.get(i), 60, text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (isTextDisplayed) {
            getElementListTextStatus = true;
        } else {
            getElementListTextStatus = false;
        }
        return getElementListTextStatus;
    }

    public void sendKeysWithEnter(WebElement element, String key, int timeOutInSecond, String elementName) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(key);
            element.sendKeys(Keys.ENTER);
            Utils.logStepInfo(true, "send  " + key + " on " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(false, "send  " + key + " on " + elementName + " failed");
            e.printStackTrace();
        }
    }

    public boolean getElementTextAndCheckWithEqualIgnoreCase(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        text = element.getText().trim();
        Utils.logStepInfo(true, "Get text from element successfully");
        Utils.logStepInfo(true, "Text found: " + text);
        if (text.trim().equalsIgnoreCase(expectedText)) {
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " ********verification failed *******");
            return false;
        }
    }

    public boolean scrollTillText(String text, String elementName) {
        boolean isScrollSuccessful = false;
        try {
            ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                    "scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))");
            isScrollSuccessful = true;
            Utils.logStepInfo(true, "text visible   " + elementName + " successful !!!!!!!!!!");
        } catch (Exception e) {
            Utils.logStepInfo(false, "text not visible   " + elementName + " *******failed*****");
            e.printStackTrace();
        }
        return isScrollSuccessful;
    }

    public boolean isElementSelected(MobileElement element, int timeOut, String elementName) {
        boolean isElementSelected = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeSelected(element));
            if (element.isSelected()) {
                isElementSelected = true;
                Utils.logStepInfo(true, elementName + " selected successfully !!!!!!!");
            } else {
                Utils.logStepInfo(false, elementName + " selected *****failed*****");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " selected ******failed******");
        }
        return isElementSelected;
    }

    public void scrollUpToElementDisplayedWithCoordinates(MobileElement element) {

        TouchAction action = new TouchAction(driver);
        Dimension size = ((WebDriver) driver).manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        int startX = (int) (width * 0.5);
        int startY = (int) (height * 0.2);
        int endX = (int) (width * 0.2);
        int endY = (int) (height * 0.5);
        boolean isDisplayed = isVisible(element);
        while (!isDisplayed) {
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX, endY)).release()
                    .perform();
            isDisplayed = isVisible(element);
        }
    }

    public boolean isElementEnabled(WebElement element, String elementName) {
        boolean isElementEnabled = false;
        try {
            if (element.isEnabled()) {
                isElementEnabled = true;
                Utils.logStepInfo(true, elementName + " Enabled successfully !!!!!!!!");
            } else {
                Utils.logStepInfo(false, elementName + " displayed failed");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " displayed failed *******");
        }
        return isElementEnabled;
    }

    public boolean getElementTextAndCheckWithContains(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        text = element.getText().trim();
        Utils.logStepInfo(true, "Get text from element successfully");
        Utils.logStepInfo(true, "Text found: " + text);
        if (text.contains(expectedText)) {
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " ********verification failed *******");
            return false;
        }
    }

    public boolean checkElementVisibilityByScrolling(MobileElement element, String elementName) {
        boolean isShowing;
        isShowing = isElementDisplayed(element, 5, elementName);
        if (!isShowing) {
            scrollToElementDown(element);
            isShowing = isElementDisplayed(element, 5, elementName);
            if (!isShowing) {
                scrollUpUntilElementFound(element);
                isShowing = isElementDisplayed(element, 5, elementName);
            }
        }
        return isShowing;
    }

    public void launchAppFromBackground(int timeOutInSecond) {
        driver.runAppInBackground(Duration.ofSeconds(timeOutInSecond));
        System.out.println("App launch from background successfully");
    }

    public void toGetRidOfAd(MobileElement ele, int timeOutInSecond) {
        int count=0;
        while (!isElementDisplayed(ele, timeOutInSecond, "Element")) {
            pressAndroidBackKey();
            count++;
            Utils.logStepInfo(count + " time Searching for element...");
            if(count > 10){
                Utils.logStepInfo(true,ele+ " is not visible in 10 times !!!");
                driver.resetApp();
                break;
            }
        }
    }

    public void toGetRidOfAdBeAndCTapHomeBtn(MobileElement ele, int timeOutInSecond) {
        int i = 0;
        while (!isElementDisplayed(ele, timeOutInSecond, "Home button") && i <= 5) {
            pressAndroidBackKey();
            i++;
            Utils.logStepInfo(true,i+ " time search for Element");
        }
        clickElementIfDisplayed(ele, timeOutInSecond, "HT home button");
    }

    public MobileElement toGetMobileElementByVisibilityText(String text) {
        return (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public void toGetProfileButtonVisibleAndClick(MobileElement ele, int timeOutInSecond) {
        int i = 0;
        while (!isElementDisplayed(ele, timeOutInSecond, "Profile button top right corner of HT homepage") && i <= 10) {
            pressAndroidBackKey();
            i++;
        }
        clickElementIfDisplayed(ele, timeOutInSecond, "HT Profile button");
    }

    public void killAppAndReLaunch() {
        driver.resetApp();
        System.out.println("App Kill And ReLaunch Again");
    }

    public boolean getElementTextAndCheck(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        text = element.getText().trim();
        Utils.logStepInfo(true, "Get text from element successfully");
        Utils.logStepInfo(true, "Text found: " + text);
        if (text.equals(expectedText)) {
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " ********verification failed *******");
            return false;
        }
    }

    public boolean compareWithSizeListOfElements(List<MobileElement> element, int elementSize, String elementName) {
        boolean isShowing;
        if (isShowing = element.size() >= elementSize) {
            isShowing &= true;
            Utils.logStepInfo(true, elementName + " displayed successfully !!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, elementName + " Not displayed *****failed*****");
        }
        return isShowing;
    }

    public boolean scrollToTopForAndroidNative() {

        int x = driver.manage().window().getSize().width / 2;
        int end_y = (int) (driver.manage().window().getSize().height * 0.2);
        int start_y = (int) (driver.manage().window().getSize().height * 0.8);
        TouchAction dragNDrop = new TouchAction(driver)
                .press(PointOption.point(x, end_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, start_y))
                .release();
        dragNDrop.perform();
        return true;
    }

    public void swipeElementAndroid(MobileElement el, Direction dir) {
        System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Rectangle rect = el.getRect();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 0;

        switch (dir) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public void swipeByElementSizeFromRightToLeft(MobileElement ele) {
        Dimension dimension = ele.getSize();
        int anchor = dimension.getHeight() / 2;
        int scrollStart = (int) (dimension.getWidth() * 0.8);
        int scrollEnd = (int) (dimension.getWidth() * 0.5);

        TouchAction action = new TouchAction(driver);
        PointOption startPoint = PointOption.point(scrollStart, anchor);
        PointOption endPoint = PointOption.point(scrollEnd, anchor);
        action.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000))).moveTo(endPoint).release().perform();
    }

    public boolean scrollDownSlowToElement(MobileElement elementToScroll, int scrollingCount) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            if (isElementClickable(elementToScroll, 5, "Element looking for is")) {
                isScrollDownToElement = true;
            }
            else
            {
            for (int i = 0; i < scrollingCount; i++) {
                if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)){
                    if(i % 2 == 0 && i>1){
                    swipeElementUsingTouchAction(468,1253,499,373);
                }}
                new TouchAction(driver).press(PointOption.point(width / 3, height / 3)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 3, height / 10)).release().perform();
                System.out.println(i + 1 + " Time slow Scrolling for element.");
                if (isElementClickable(elementToScroll, 5, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }}
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public TouchAction clickByCoordinates(int x, int y, String elementName) {
        TouchAction isClicked;
        isClicked = new TouchAction(driver).tap(PointOption.point(x, y)).release().perform();
        System.out.println(elementName + " clicked successfully");
        return isClicked;
    }

    public boolean isElementDisplayedIgnoringStaleElement(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        isElementDisplayed = element.isDisplayed();
        Utils.logStepInfo(true, elementName + " available");
        return isElementDisplayed;
    }

    public void moveToElementWithActions(WebElement element, int timeOutInSecond, String elementName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Utils.logStepInfo(true, "Moved to " + elementName + " successfully");
    }

    public void moveToElementToClick(WebElement ele) {
        Actions actions;
        try {
            actions = new Actions(driver);
            actions.moveToElement(ele).click().build().perform();
            Utils.logStepInfo("Click action took place");
        } catch (Exception e) {
            Utils.logStepInfo("Click action did not take place");
            e.printStackTrace();
        }
    }

    public int getResponseCode(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            Utils.logStepInfo(true, huc.getResponseCode() + " is the real status code");
            return huc.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getAttributeValue(WebElement element, int timeOutInSecond, String attribute) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            String value = element.getAttribute(attribute);
            Utils.logStepInfo(true, "Get Attribute from element successfully");
            Utils.logStepInfo(true, "Text found: " + value);
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean scrollToElementDown(MobileElement elementToScroll) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < 20; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                System.out.println(i + 1 + " Time Scrolling for element.");
                if (isElementClickable(elementToScroll, 2, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public boolean scrollDownSlowToElement(MobileElement elementToScroll, MobileElement homeSectionElementLocator, MobileElement backButton) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < 20; i++) {
                if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE) && globalVars.getApplicationName().equalsIgnoreCase(Constants.HINDUSTAN_TIMES) && i < 4) {
                    toGetRidOfAd(homeSectionElementLocator, 5);
                    clickElementIfDisplayed(backButton, 5, "Back Button");
                }
                new TouchAction(driver).press(PointOption.point(width / 3, height / 3)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 3, height / 10)).release().perform();
                System.out.println((i + 1) + " Time slow Scrolling for element.");
                if (isElementClickable(elementToScroll, 5, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }


    public boolean swipeElementToLeftByList(List<MobileElement> elementList, MobileElement ele1, String text) {
        for (MobileElement ele : elementList) {
            boolean isElementDisplay = isElementDisplayed(ele1, 5, text);
            if (isElementDisplay == false) {
                swipeElementAndroid(ele, Direction.LEFT);
                this.swipeElementToLeftByList(elementList, ele1, text);
            }
        }
        return true;
    }

    public boolean navigateToSearchResultPage(String searchTerm, MobileElement homeButton, MobileElement searchField, MobileElement searchHeader, MobileElement searchInputBox, int xCordinate, int ycordinate) {
        toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        clickElement(searchField, 5, "Search Option");
        boolean isSearchPageDisplayed = getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        clickElementIfDisplayed(searchInputBox, 20, "Click on Search box");
        sendKeysOnAndroid(searchInputBox, searchTerm);
        dummyWait(5);
        clickByCoordinates(xCordinate, ycordinate, "Enter Key");
        dummyWait(10);
        Utils.logStepInfo(true, "isSearchPageDisplayed = "+isSearchPageDisplayed);
        return isSearchPageDisplayed;
    }

    public boolean isRelatedTopicHeaderDisplayed(MobileElement relatedTopic, List<MobileElement> relatedTopicsList, MobileElement relatedTopicPageHeader) {
        boolean isPageTitleDisplay = getElementText(relatedTopic, 10).equalsIgnoreCase("Related Topics");
        scrollDownSlowToElement(relatedTopicsList.get(0), 10);
        String expectedTopicToBeClicked = getElementText(relatedTopicsList.get(0), 10);
        Utils.logStepInfo(true,"clicked on Topic: " + expectedTopicToBeClicked);
        clickElementIfDisplayed(relatedTopicsList.get(0), 10, "First topic of Related story");
        dummyWait(10);
        Utils.logStepInfo(true,"relatedTopicPageHeader = "+relatedTopicPageHeader.getText());
        Utils.logStepInfo(true,"expectedTopicToBeClicked = "+expectedTopicToBeClicked);
        boolean isTopicMatched = getElementText(relatedTopicPageHeader, 10).equalsIgnoreCase(expectedTopicToBeClicked);
        Utils.logStepInfo(true,"isPageTitleDisplay = "+isPageTitleDisplay);
        Utils.logStepInfo(true,"isTopicMatched = "+isTopicMatched);
        return isPageTitleDisplay && isTopicMatched;
    }

    public boolean navigateToPageThroughExploremenu(WebElement explore, WebElement pagetoOpen, String pageName) {
        boolean newsLetterpageOpened;
        navigateToURL(globalVars.getURL());
        newsLetterpageOpened = clickElementWithJS(explore, 10, "Explore link");
        newsLetterpageOpened &= clickElementWithJS(pagetoOpen, 10, pageName + " link in Explore Menu");
        return newsLetterpageOpened;
    }

    public boolean newslettersCardContentVisiblity(WebElement pageTitle, WebElement NewsletterHeadContent, WebElement FreeNewsletters, WebElement SubscriberOnlyNewsletters) {
        boolean headerContentVisibility = false;
        isElementDisplayed(pageTitle, 10, "mint logo");
        isElementDisplayed(NewsletterHeadContent, 10, "Newsletter Header content displayed ");
        isElementDisplayed(FreeNewsletters, 10, "Free Newsletters Displayed");
        headerContentVisibility = isElementDisplayed(SubscriberOnlyNewsletters, 10, "Subscriber Only Newsletter Displayed");


        return true;


    }

    public boolean navigateToSectionResultPage(String searchTerm, MobileElement cricketSection, MobileElement homeButton, MobileElement searchField, MobileElement searchHeader, MobileElement searchInputBox, int xCordinate, int ycordinate) {
        toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        clickElementIfDisplayed(cricketSection, 10, "Cricket section on botton nav");
        clickElement(searchField, 5, "Search Option");
        boolean isSearchPageDisplayed = getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        clickElementIfDisplayed(searchInputBox, 20, "Click on Search box");
        sendKeysOnAndroid(searchInputBox, searchTerm);
        dummyWait(5);
        clickByCoordinates(xCordinate, ycordinate, "Enter Key");
        dummyWait(10);
        return isSearchPageDisplayed;
    }

    public boolean navigateToEducationPageLayout(WebElement explore, WebElement education, WebElement educationFirstStory, WebElement educationFirstHeadline, WebElement educationSecondStory, WebElement educationSecondHeadline, String pageName) {
        navigateToURL(globalVars.getURL());
        clickElementWithJS(explore, 10, "Explore Menu");
//        checkTextContainByCurrentURL(pageName, pageName);
       dummyWait(5);
        scrollToElement(education, "Education Section");
       dummyWait(5);
        boolean isShowing = clickElementWithJS(education, 10, "Education Section");
       dummyWait(5);
        isShowing &= isElementDisplayed(educationFirstStory, 10, "First Story");
        String Headline = getElementText(educationFirstStory);
        String Header = getElementText(educationFirstHeadline);
        isShowing &= checkTextContains(Header, Headline, "First Story verified card view");
        isShowing &= isElementDisplayed(educationSecondStory, 10, "Second Story");
        String Headline1 = getElementText(educationSecondStory);
        String Heading = getElementText(educationSecondHeadline);
        isShowing &= checkTextContains(Heading, Headline1, "Second Story verified list view");
        return isShowing;
    }

    public static int[] getElementXYCoordinate(MobileElement element) {
        String p1 = element.getLocation().toString().replaceAll("[()]", "");
        return getXYCoordinate(p1);
    }

    public static int[] getListOfElementXYCoordinate(List<MobileElement> element, int index, String elementName) {
        String p1 = element.get(index).getLocation().toString().replaceAll("[()]", "");
        return getXYCoordinate(p1);
    }

    private static int[] getXYCoordinate(String p1) {
        String[] Ele1 = p1.split(",", 2);
        String firstEleX = Ele1[Ele1.length - 2].trim();
        int X = Integer.parseInt(firstEleX);
        String firstEleY = Ele1[Ele1.length - 1].trim();
        int Y = Integer.parseInt(firstEleY);
        return new int[]{X, Y};
    }

    public boolean checkTopGainersViewAll(List<WebElement> topGainersListing, WebElement topGainersViewAll, WebElement topGainersViewHeader, WebElement topGainersBseListing, WebElement topGainersNse, WebElement topGainersNseCompany, WebElement topGainersNsePrice, String Link) {
        navigateToURL(globalVars.getURL() + Link);
        scrollToElement(topGainersViewAll, 10, "View All");
        boolean isShowing = clickElementWithJS(topGainersViewAll, 10, "View All");
        isShowing &= isElementDisplayed(topGainersViewHeader, 10, "Top Gainers View All Header");
        isShowing &= isElementDisplayed(topGainersBseListing, 10, "Top Gainers Listing");
        isShowing &= clickElementWithJS(topGainersNse, 10, "Top Gainers Nse");
        int StocksList = topGainersListing.size();
        for (int i = 0; i < StocksList; i++) {
            isShowing &= isElementClickable(topGainersListing.get(i), 10, "Bse 500 Stocks List");
        }
        scrollToTop();
        isShowing &= isElementDisplayed(topGainersNseCompany, 10, "Top Gainers Company Name");
        isShowing &= isElementDisplayed(topGainersNsePrice, 10, "Top Gainers Company Price & change percent");
        return isShowing;
    }

    public boolean checkGraphOnPage(WebElement bseSensexTicker, String Link) {
        boolean isShowing = true;
        navigateToURL(globalVars.getURL() + Link);
        scrollToElement(bseSensexTicker, "Market Dashbaord");
        return isShowing;
    }


    public boolean checkTopLosersViewAll(List<WebElement> topGainersListing, WebElement topLosersViewAll, WebElement topGainersViewHeader, WebElement topGainersBseListing, WebElement topGainersNse, WebElement topGainersNseCompany, WebElement topGainersNsePrice, String Link) {
        navigateToURL(globalVars.getURL() + Link);
        scrollToElement(topLosersViewAll, 10, "View All");
        boolean isShowing = clickElementWithJS(topLosersViewAll, 10, "View All");
        isShowing &= isElementDisplayed(topGainersViewHeader, 10, "Top Gainers View All Header");
        isShowing &= isElementDisplayed(topGainersBseListing, 10, "Top Gainers Listing");
        isShowing &= clickElementWithJS(topGainersNse, 10, "Top Gainers Nse");
        int StocksList = topGainersListing.size();
        for (int i = 0; i < StocksList; i++) {
            isShowing &= isElementClickable(topGainersListing.get(i), 10, "Bse 500 Stocks List");
        }
        scrollToTop();
        isShowing &= isElementDisplayed(topGainersNseCompany, 10, "Top Gainers Company Name");
        isShowing &= isElementDisplayed(topGainersNsePrice, 10, "Top Gainers Company Price & change percent");
        return isShowing;
    }

    public void clickOnReadNowInNewsLetter(List<MobileElement> readNowInNewsLetter, int index) {
        if (isElementDisplayed(readNowInNewsLetter.get(index), 5, "Read Now")) {
            clickElement(readNowInNewsLetter.get(index), 5, "Read Now");
        } else {
            scrollDownSlowToElement(readNowInNewsLetter.get(index), 2);
            clickElement(readNowInNewsLetter.get(index), 5, "Read Now");
        }
    }

    public boolean checkTopLosersVAll(WebElement topGainViewHeader, WebElement topGainBseList, WebElement topGainNse, WebElement topGainNseCompany, WebElement topGainNsePrice) {
        boolean isShowing = isElementDisplayed(topGainViewHeader, 10, "Header");
        isShowing &= isElementDisplayed(topGainBseList, 10, "Listing");
        isShowing &= clickElementWithJS(topGainNse, 10, "Nse");
        isShowing &= isElementClickable(topGainNseCompany, 10, "Company");
        scrollToTop();
        isShowing &= isElementDisplayed(topGainNseCompany, 10, "Company Name");
        isShowing &= isElementDisplayed(topGainNsePrice, 10, "Company Price & change percent");
        return isShowing;
    }

    public boolean checkCompaniesPageTopNav(WebElement explore, WebElement companies, WebElement mintLogo, WebElement epaper, WebElement signIn, WebElement getApp) {
        boolean isShowing = clickElementWithJS(explore, 10, "Explore");
        isShowing &= clickElementWithJS(companies, 10, "Companies");
        isShowing &= isElementDisplayed(mintLogo, 10, "mintLogo");
        isShowing &= isElementDisplayed(epaper, 10, "Epaper");
        isShowing &= isElementClickable(signIn, 10, "Sign In");
        isShowing &= isElementDisplayed(getApp, 10, "Get App");
        return isShowing;
    }

    public boolean checkCompaniesSectionPage(WebElement explore, WebElement companies) {
        boolean isShowing = clickElementWithJS(explore, 10, "Explore");
        isShowing &= clickElementWithJS(companies, 10, "Companies");
        dummyWait(10);
        return isShowing;
    }


    public boolean verifyStoryBookMarked(MobileElement articlesInBookMark, int countOfArticlesBeforeBookMarked) {
        boolean isStoryBookMarked = false;
        int countOfArticlesAfterAdded = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Value of Article after bookmarked = " + countOfArticlesAfterAdded);
        if (countOfArticlesBeforeBookMarked == countOfArticlesAfterAdded - 1) {
            System.out.println("Story is BookMarked and Article Value is incressed by one");
            isStoryBookMarked = true;
        } else if (countOfArticlesBeforeBookMarked == countOfArticlesAfterAdded + 1) {
            System.out.println("Story is already BookMarked so removed from BookMarked article");
            isStoryBookMarked = true;
        } else {
            System.out.println("Failed to bookMark Story from Photos Section");
        }
        Utils.logStepInfo(true,"isStoryBookMarked = "+isStoryBookMarked);
        return isStoryBookMarked;
    }

    public boolean checkForYouLayoutsubSub(WebElement pageTitle, WebElement exploreMenu, WebElement SUbepaper, WebElement SUbgetapp, WebElement Myaccount, WebElement ForuYou) {
        boolean checkForYouLayoutsubSubUserLogin;
        boolean isLinkDisplayed = false;
        try {
            navigateToURL(globalVars.getURL());
            dummyWait(10);
            clickElement(ForuYou, 10, "ForYouNav");
            isLinkDisplayed = isElementDisplayed(pageTitle, 10, "Submint logo");
            isLinkDisplayed &= isElementDisplayed(exploreMenu, 10, "SubExplore menu ");
            isLinkDisplayed &= isElementDisplayed(SUbepaper, 10, "Sub-epaper");
            isLinkDisplayed &= isElementDisplayed(SUbgetapp, 10, "getAppCTA");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (isLinkDisplayed) {
            checkForYouLayoutsubSubUserLogin = true;
        } else {
            checkForYouLayoutsubSubUserLogin = false;
        }
        return checkForYouLayoutsubSubUserLogin;

    }

    public boolean checklHSNAVLinksforSub(WebElement LHSHome, WebElement LHSLatest, WebElement LHSMarkets, WebElement LHSPremium, WebElement LHSForYou, WebElement ForuYou) {
        boolean checklHSNAVLinksforSubLogin;
        boolean isLinkDisplayed = false;
        try {
            navigateToURL(globalVars.getURL());
            dummyWait(10);
            clickElement(ForuYou, 10, "ForYouNav");
            dummyWait(5);
            isLinkDisplayed = isElementDisplayedAndPresent(LHSHome, 10, "Sub HOME Button");
            isLinkDisplayed &= isElementDisplayed(LHSLatest, 10, "Sub LATEST Button");
            isLinkDisplayed &= isElementDisplayed(LHSMarkets, 10, "Sub MARKET Button");
            isLinkDisplayed &= isElementDisplayed(LHSPremium, 10, "Sub PREMIUM Button");
            isLinkDisplayed &= isElementDisplayed(LHSForYou, 10, "Sub FOR YOY Button");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        if (isLinkDisplayed) {
            checklHSNAVLinksforSubLogin = true;
        } else {
            checklHSNAVLinksforSubLogin = false;
        }

        return checklHSNAVLinksforSubLogin;
    }

    public boolean checkOpenAppButton(WebElement mintLogo, WebElement openApp) {
        boolean isShowing = clickElementWithJS(mintLogo, 10, "Mint Logo For HomePage");
        isShowing &= isElementClickable(openApp, 10, "Open App Button");
        return isShowing;
    }

    public boolean checkOpenAppButtonInStory(WebElement mintLogo, WebElement firstStory, WebElement openApp) {
        clickElementWithJS(mintLogo, 10, "Mint Logo For HomePage");
        boolean isShowing = clickElementWithJS(firstStory, 10, "First Story");
        isShowing &= isElementClickable(openApp, 10, "Open App Button");
        return isShowing;
    }

    public String getTextsFromMobileElementList(List<MobileElement> eleList, int timeOutInSecond, String elementName) {
        String str = null;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            for (WebElement ele : eleList) {
                str = getElementText(ele, 10);
                Utils.logStepInfo(true, "Successfully Found " + elementName + ":\n" + str);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, "Either element is not present or it could not have any text value.");
            e.printStackTrace();
        }
        return str;
    }

    public boolean checkShareOptionInFirstStoryInPage(MobileElement homePage, MobileElement inPage, List<MobileElement> threeDots, MobileElement shareOption) {
        toGetRidOfAdBeAndCTapHomeBtn(homePage, 5);
        clickElement(inPage, 5, "Search Option");
        clickElement(threeDots.get(0), 5, "Three Dots in first Story");
        boolean isShareOptionDisplayed = isElementDisplayed(shareOption, 5, "Share Option");
        return isShareOptionDisplayed;
    }


    public boolean checkWSJ(WebElement pagelogo, WebElement exploreMenu, WebElement ePaper, WebElement getAppCta) {

        boolean isLinkDisplayed = false;
        try {

            isLinkDisplayed = isElementDisplayed(pagelogo, 10, "Mintlogo");
            isLinkDisplayed &= isElementDisplayed(exploreMenu, 10, "Exploremenu ");
            isLinkDisplayed &= isElementDisplayed(ePaper, 10, "Epaper CTA");
            isLinkDisplayed &= isElementDisplayed(getAppCta, 10, "Get App");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isLinkDisplayed;

    }

    public boolean TopNavOnEducationPage(WebElement pageTitle, WebElement iconMenu, WebElement EpaperIcon) {
        boolean isShowing = isElementDisplayed(pageTitle, 10, "mint logo");
        isShowing &= isElementDisplayed(iconMenu, 30, "Icon Menu should be displayed");
        isShowing &= isElementDisplayed(EpaperIcon, 30, "Epaper icon need to be displayed in top Nav");
        return isShowing;
    }

    public boolean scrollDownByCoordinates(MobileElement element, int xOffSet, int yOffSet, int moveToxOffSet, int moveToyOffSet) {
        boolean isScrollDownToElement = false;
        (new TouchAction(driver))
                .press(PointOption.point(xOffSet, yOffSet)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(moveToxOffSet, moveToyOffSet)).release().perform();
        if (isElementDisplayed(element, 5)) {
            System.out.println("Scroll down Successfully with given co-ordinates");
            isScrollDownToElement = true;
        }
        return isScrollDownToElement;
    }

    public boolean redirectToPhotosTabInSearchPage(
            MobileElement homeButton, MobileElement searchField, MobileElement searchHeader, MobileElement searchInputTextBox,
            int xCordinate, int yCordinate, MobileElement photosLabelOnSearchResultPage, List<MobileElement> listOfStoriesInPhotosTab) {
        boolean isSearchPageDisplayed = navigateToSearchResultPage("Cricket", homeButton, searchField, searchHeader, searchInputTextBox, 986, 2083);
        dummyWait(5);
        clickElement(photosLabelOnSearchResultPage, 5, "Photos Section");
        boolean isPhotosStoriesDisplayed = false;
        if (listOfStoriesInPhotosTab.size() > 2) {
            Utils.logStepInfo(true, "Photos Stories are displayed in Photos Section in Search tab");
            isPhotosStoriesDisplayed = true;
        } else {
            Utils.logStepInfo(false, "Photos Stories are not displayed in Photos Section in Search tab");
        }
        return isSearchPageDisplayed && isPhotosStoriesDisplayed;
    }

    public boolean checkTopNAVLinksWSJ(WebElement TopHome, WebElement TopLatest, WebElement TopMarkets, WebElement TopPremium, WebElement TopForYou) {
        boolean isLinkDisplayed = false;
        try {

            isLinkDisplayed = isElementDisplayed(TopHome, 10, "HOME Button");
            isLinkDisplayed &= isElementDisplayed(TopLatest, 10, "LATEST Button");
            isLinkDisplayed &= isElementDisplayed(TopMarkets, 10, "MARKET Button");
            isLinkDisplayed &= isElementDisplayed(TopPremium, 10, "PREMIUM Button");
            isLinkDisplayed &= isElementDisplayed(TopForYou, 10, "FOR YOY Button");

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return isLinkDisplayed;
    }


    public boolean checkLiveBlogLandingPage(WebElement explore, WebElement expandMarkets, WebElement liveBlog) {
        boolean isShowing = clickElementWithJS(explore, 10, "Explore Section");
        isShowing &= clickElementWithJS(expandMarkets, 10, "Expand Markets");
        isShowing &= clickElementWithJS(liveBlog, 10, "Live blog");
        return isShowing;
    }

    public boolean checkFirstLiveBlog(WebElement blogHeadline, WebElement blogOpenHeadline, WebElement liveBlog) {
        String Headline = blogHeadline.getText();
        boolean isShowing = clickElementWithJS(blogHeadline, 10, "Blog Headline");
        String Headline1 = blogOpenHeadline.getText();
        checkTextContains(Headline, Headline1, "Live Blog Headline");
        return isShowing;
    }

    public boolean checkLiveBlogImagenCaption(WebElement leadImage, WebElement caption) {
        boolean isShowing = isElementDisplayed(leadImage, 10, "Lead Image");
        isShowing &= isElementDisplayed(caption, 10, "Lead Image Caption");
        return isShowing;
    }

    public boolean checkLiveBlogSocialIcons(List<WebElement> iconsList) {
        boolean isShowing = isElementDisplayedOfListOfWebElements(iconsList, "Bookmark & Social Icons");
        return isShowing;
    }

    public boolean checkLiveBlogPageTitle(WebElement liveBlogTitle, String Title) {
        boolean isShowing = getElementTextAndCheckWithEqualIgnoreCase(liveBlogTitle, Title, 20, "Live Blog Page Title");
        return isShowing;
    }

    public boolean checkMarketPageContentMethod(WebElement markets, WebElement liveBlogTitle, WebElement firstImage, WebElement blogHeadline, WebElement breadcrumb, WebElement firstStoryBookmark, WebElement firstStoryShare) {
        boolean isShowing=clickElementWithJS(markets, 10, "Markets" );
        isShowing &=isElementDisplayed(liveBlogTitle, 10, "Page Title");
        isShowing &=isElementDisplayed(firstImage, 10, "First Story Image");
        isShowing &=isElementDisplayed(blogHeadline, 10, "First Story Headline");
        isShowing &=isElementDisplayed(breadcrumb, 10, "Market Page Breadcrumb");
        isShowing &=isElementDisplayed(firstStoryBookmark, 10, "First Story Bookmark");
        isShowing &=isElementDisplayed(firstStoryShare,10, "First Story Share");
        return isShowing;
    }

    public boolean checkMarketPageContents(WebElement markets, WebElement liveBlogTitle, WebElement firstImage, WebElement blogHeadline, WebElement breadcrumb) {
        boolean isShowing=clickElementWithJS(markets, 10, "Markets" );
        isShowing &=isElementDisplayed(liveBlogTitle, 10, "Page Title");
        isShowing &=isElementDisplayed(firstImage, 10, "First Story Image");
        isShowing &=isElementDisplayed(blogHeadline, 10, "First Story Headline");
        isShowing &=isElementDisplayed(breadcrumb, 10, "Market Page Breadcrumb");
        return isShowing;
    }

    public boolean checkStory(WebElement FistStory,WebElement FirstStoryHeadline)
    {
        boolean isShowing= isElementDisplayed(FistStory,10,"Page On First Story");
        String Headline = getElementText(FistStory);
        String Header = getElementText(FirstStoryHeadline);
        isShowing = checkTextContains(Header,Headline,"First Story verified list view");

        return isShowing;
    }

    public boolean navigateToPageThroughTopNav(WebElement pagetoOpen, String pageName) {
        navigateToURL(globalVars.getURL());
        return clickElementWithJS(pagetoOpen, 10, pageName + " link in Top Nav");
    }

    public boolean isAllElementClickable(List<WebElement> elementList) {
        boolean isAllelementClickableTrue = true;
        for (WebElement ele : elementList) {
            String elementTxt = getElementText(ele, 10);
            moveToElementWithActions(ele, 10, elementTxt);
            if (isElementClickable(ele, 10, elementTxt)) {
                isAllelementClickableTrue &= true;
            } else if (elementTxt.isEmpty()) {
                isAllelementClickableTrue &= true;
            } else {
                isAllelementClickableTrue &= false;
            }
        }
        return isAllelementClickableTrue;
    }

    public boolean isAllElementClickable(List<WebElement> elementList, String elementString) {
        boolean isAllelementClickableTrue = true;
        for (WebElement ele : elementList) {
            if (isElementClickable(ele, 10, elementString)) {
                isAllelementClickableTrue &= true;
            }else {
                isAllelementClickableTrue &= false;
            }
        }
        return isAllelementClickableTrue;
    }

    public boolean isAllRelatedLandingPageTrue(List<WebElement> listOfLinks, WebElement menuButton, WebElement closeButton) {
        String linkTitle;
        String urlContains;
        boolean isAllLandingPageAreRelated = true;
        int linkSize=listOfLinks.size();
        for (int i=0;i<linkSize;i=i+2) {
            if(i!=0) {
                clickElementWithJS(menuButton, 20, "Home hamburger button");
            }
            linkTitle = getElementText(listOfLinks.get(i), 10);
            urlContains = getAttributeValue(listOfLinks.get(i), 20, "href");
            moveToElementWithActions(listOfLinks.get(i), 10, linkTitle);
            if(linkTitle.equalsIgnoreCase("हिन्दुस्तान स्मार्ट") || linkTitle.equalsIgnoreCase("Podcast") || linkTitle.equalsIgnoreCase("ई-पेपर") || linkTitle.equalsIgnoreCase("अन्य राज्य")){
                clickElementWithJS(closeButton, 20, "Close");
                continue;
            }else{
                if (urlContains.contains("https://") || urlContains.contains("http://")) {
                    clickElementWithJS(listOfLinks.get(i), 10, linkTitle);
                    waitForPageToLoad();
                    isAllLandingPageAreRelated &= getCurrentURL().contains(urlContains);
                    if(!isAllLandingPageAreRelated){
                        System.out.println("After Click URL:- "+getCurrentURL());
                        break;
                    }
                    driver.navigate().back();
                    waitForPageToLoad();
                } else {
                    clickElementWithJS(listOfLinks.get(i), 10, linkTitle);
                    waitForPageToLoad();
                    isAllLandingPageAreRelated &= getCurrentURL().contains(urlContains);
                    if(!isAllLandingPageAreRelated){
                        System.out.println("After Click URL:- "+getCurrentURL());
                        break;
                    }
                }
            }
        }
        return isAllLandingPageAreRelated;
    }

    public boolean scrollToViewElementWithLinks(List<WebElement> elementList)
    {
        boolean isElementDisplayTrue = false;
        String text=null;
        for(WebElement ele: elementList)
        {
            text=getElementText(ele,20);
            scrollToElement(ele,text);
            if(ele.isDisplayed())
            {
                isElementDisplayTrue=true;
                Utils.logStepInfo(isElementDisplayTrue, "element is displayed");
            }
            else
            {
                Utils.logStepInfo(isElementDisplayTrue, "element is not displayed");
            }
        }return isElementDisplayTrue;
    }

    public boolean isElementDisplayedWithoutTryCatch(MobileElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if (element.isDisplayed()) {
                isElementDisplayed = true;
                Utils.logStepInfo(true, elementName + " displayed successfully !!!!!!!");
            } else {
                Utils.logStepInfo(false, elementName + " displayed *****failed*****");
            }
        return isElementDisplayed;
    }

    public boolean isElementDisappeared(MobileElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = true;

        //WebDriverWait w = new WebDriverWait(driver,5);
        // invisibilityOfElementLocated condition
        //w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='mui-btn']")));

        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.invisibilityOf(element));
        if (element.isDisplayed()) {
            isElementDisplayed = false;
            Utils.logStepInfo(false, elementName + " displayed successfully !!!!!!!");
        } else {
            Utils.logStepInfo(true, elementName + " displayed *****failed*****");
        }
        return isElementDisplayed;
    }

    public boolean scrollDownToElement(MobileElement elementToScroll, MobileElement homeSectionElementLocator, int numberOfTimeScroll) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < numberOfTimeScroll; i++) {
                if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE) && globalVars.getApplicationName().equalsIgnoreCase(Constants.HINDUSTAN_TIMES) && i <= 4) {
                    toGetRidOfAd(homeSectionElementLocator, 2);
                }
                if(i % 2 == 0){
                    swipeElementUsingTouchAction(468,1253,499,373);
                    Utils.logStepInfo(true,"scroll by swipeElementUsingTouchAction");
                }
                else {
                    new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                            moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                }
                System.out.println(i + 1 + " Time Scrolling for element.");
                if (isElementClickable(elementToScroll, 2, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public boolean swipeElementUsingTouchAction(int x1, int x2, MobileElement fromElement, int numberOfTimesSwipe, MobileElement elementToSwipe) {
        boolean isSwipeToElement = false;
        int y = 0;
        try {
            TouchAction action = new TouchAction(driver);
            Point point = fromElement.getLocation();
            y = point.getY();
            System.out.println("y value =================================== " +y);
            PointOption startPoint = PointOption.point(x1, y);
            PointOption endPoint = PointOption.point(x2, y);
            for(int i =0; i<numberOfTimesSwipe;i++) {
                action.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).moveTo(endPoint).release().perform();
                System.out.println((i+1)+ " - time Done swipe action: " + x1 + ", " + y + ", " + x2 + ", " + y +" for Element - " +elementToSwipe);
                if (isElementDisplayed(elementToSwipe, 3, "Element looking for is")) {
                    isSwipeToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in swipe action: " + e.getMessage());
            System.out.println("Unable to swipe action with coordinates: " + x1 + ", " + y + ", " + x2 + ", " + y);
        }
        return isSwipeToElement;
    }

    public boolean scrollDownToElement(MobileElement elementToScroll, int scrollingCount) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < scrollingCount; i++) {
                new TouchAction(driver).press(PointOption.point(width / 3, height / 3)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 3, height / 10)).release().perform();
                System.out.println(i + 1 + " Time slow Scrolling for element.");
                if (isElementClickable(elementToScroll, 5, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public boolean clickBreadCrumbsAndVerifyLanding(WebElement element, int timeOut, String elementName, WebElement landingElement){
        boolean flag = false;
        try {
            WebDriverWait wait;
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            clickElementWithJS(element, 10, elementName);
            dummyWait(5);
            wait.until(ExpectedConditions.visibilityOf(landingElement));
            if(getElementText(landingElement, 10).trim().contains(elementName.trim())){
                flag = true;
            }
        }catch(Exception e){
            flag = false;
        }
        
        return flag;
    }

    public void scrollAccordingToGivenCount(int count) {
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;

        try {
            for (int i = 0; i < count; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
            }
        } catch (Exception e) {
            Utils.logStepInfo( "Page is not scrolling");
        }
    }

    public boolean isElementPresentWithTryCatch(WebElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                isElementDisplayed = true;
                Utils.logStepInfo(true, elementName + " displayed successfully");
            } else {
                Utils.logStepInfo(false, elementName + " displayed failed");
            }
        } catch (Exception e) {
            isElementDisplayed = false;
        }
        return isElementDisplayed;
    }

    public boolean clickElementWithJSTryCatch(WebElement element, int timeOutInSec, String elementName) {
        boolean isElementClicked = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor jse = driver;
            jse.executeScript("arguments[0].click();", element);
            isElementClicked = true;
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(true, "click on " + elementName + " failed");
            System.out.println("click on " + elementName + " failed");
        }
        return isElementClicked;
    }

    public boolean scrollDownToElementInBottom(MobileElement elementToScroll, int scrollingCount) {
        boolean isScrollDownToElement = false;
        try {
            int height = driver.manage().window().getSize().height;
            int width = driver.manage().window().getSize().width;
            for (int i = 0; i < scrollingCount; i++) {
                new TouchAction(driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                System.out.println(i + 1 + "Scrolling for element.");
                if (isElementClickable(elementToScroll, 5, "Element looking for is")) {
                    isScrollDownToElement = true;
                    break;
                }
            }
        } catch (Exception e) {
            isScrollDownToElement = false;
        }
        return isScrollDownToElement;
    }

    public void scrollToTopOniOSNative(int scrollCount) {
        JavascriptExecutor js = driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", "up");
        for(int i = 0; i<scrollCount; i++) {
            js.executeScript("mobile: scroll", scrollObject);
            Utils.logStepInfo(true,(i+1) +" -- time Scrolling up..!!");
        }
        Utils.logStepInfo(true, " Page is scrolled to top successfully !!!!!!");
    }

    public boolean clickElementWithAction(WebElement element, int timeOut, String elementName) {
        boolean isElementClicked = false;
        WebDriverWait wait;
        Actions actions;
        try {
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            actions.moveToElement(element).click().build().perform();
            isElementClicked = true;
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(false, "click on " + elementName + " failed");
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public String getAttributeValue(WebElement element, String attribute) {
        try {
            dummyWait(5);
            String value = element.getAttribute(attribute);
            Utils.logStepInfo(true, "Get Attribute from element successfully");
            Utils.logStepInfo(true, "Text found: " + value);
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    public void killAppAndReLaunch(MobileElement clickElementIfDisplayed, int timeOut, String ElementName) {
        driver.resetApp();
        System.out.println("App Kill And ReLaunch Again");
        clickElementIfDisplayed(clickElementIfDisplayed,timeOut,ElementName);
    }

    public boolean checkPageSourceContainsText(String expectedText,String elementName) {
        boolean isElementPageSourceExist;
        String getPageSource = driver.getPageSource();
        isElementPageSourceExist = getPageSource.contains(expectedText);
        if (isElementPageSourceExist) {
            Utils.logStepInfo(true, elementName + " present in page source verified successfully !!!!!!!!");
        } else {
            Utils.logStepInfo(true, elementName + " Not present in page source verification failed ********");
        }
        return isElementPageSourceExist;
    }

    public boolean clickElementsByList(List<MobileElement> eleList1,int firstIndex, int lastIndex, int timeOutInSecond, String elementName) {
        boolean isElementClicked = false;
        WebDriverWait wait;
        try {
            for (int i = firstIndex; i<=lastIndex; i++) {
                wait = new WebDriverWait(driver, timeOutInSecond);
                wait.until(ExpectedConditions.visibilityOf(eleList1.get(i)));
                wait.until(ExpectedConditions.elementToBeClickable(eleList1.get(i)));
                eleList1.get(i).click();
                isElementClicked = true;
                Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
            }
        } catch (Exception e) {
            System.out.println("****** Unable to find " + elementName + " within " + timeOutInSecond + " seconds *****" + e);
            isElementClicked = false;
        }
        return isElementClicked;
    }

    public String getAtribute(WebElement element, String name) {
        String valueAttribute = element.getAttribute(name);
        return valueAttribute;
    }

    public void scrollPageWithJS(WebElement element, int timeOutInSecond) {
        WebDriverWait wait;
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            Utils.logStepInfo(true, "Element is found successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean clickElement(WebElement element, String elementName) {
        element.click();
        Utils.logStepInfo(true, "click on " + elementName + " successfully");
        return true;
    }

    public boolean matchTwoSet(HashSet<String> hSet1, HashSet<String> hSet2){
        boolean flag=true;
        for (String element : hSet1) {
            // if second set has the current element
            if (hSet2.contains(element)) {
                flag &=true;
            }else{
                System.out.println(element+" :is not available in: "+hSet2);
                flag &=false;
            }
        }
        return flag;
    }

    public JSONObject getResponseFromGetApi(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            Utils.logStepInfo(true, huc.getResponseCode() + " is the real status code");

            int responseCode = huc.getResponseCode();
            JSONObject jsonObject = null;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                try {
                    jsonObject = new JSONObject(response.toString());
                    //System.out.println("jsonObject:- "+jsonObject);
                } catch (JSONException err) {
                    err.toString();
                }

            } else {
                System.out.println("GET request did not work.");
            }


            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean elementNotDisplayByScrolling(MobileElement element,int count,String ElementName){
        boolean isShowing;
        if (isShowing=!scrollDownToElement(element, count)){
            isShowing &= true;
            Utils.logStepInfo(true, ElementName+" Not display successfully *****");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, ElementName+" display failed !!!!!");
        }
        return isShowing;
    }

    public void closeCurrentWindowAndSwitchToDefaultContent(){
        driver.close();
        switchToDefaultContent();
    }
}