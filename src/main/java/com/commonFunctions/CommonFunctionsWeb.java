package com.commonFunctions;

import com.base.DriverController;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunctionsWeb {
    private static int tryCount = 0;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static DriverController driverController;
    int tabCount = 0;
    String storyIdNumber;

    private CommonFunctionsWeb() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
    }

    public static CommonFunctionsWeb getInstance() {
        driverController = DriverController.getInstance();
        boolean isSessionId;
        if (driver instanceof RemoteWebDriver)
            isSessionId = (((RemoteWebDriver) driver).getSessionId() != null);
        else
            isSessionId = true;
        if (commonFunctionsWeb == null || driver == null || !isSessionId) {
            commonFunctionsWeb = new CommonFunctionsWeb();
        }
        return commonFunctionsWeb;
    }

    public static void clickUsingJavascript() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('google_image_div').click();");

    }

    public static Date getMassagedDestinationDateTimeVideoNew(String destinationDateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy, HH:mm", Locale.ENGLISH);
        Date date = null;
        try {
            //date = formatter.parse(destinationDateTime.replace("UPDATED ON","").replace("PUBLISHED ON","").trim());
            date = formatter.parse(destinationDateTime.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getPublishedDateTime(String destinationDateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm , MMM d, yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON", "").replace("PUBLISHED AT", "").replace("HRS", "").trim());
            //date = formatter.parse(destinationDateTime.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getPublishedDateTimeForLiveBlog(String destinationDateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy HH:mm", Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON", "").replace("PUBLISHED AT", "").replace("HRS", "").replace("[", "").replace("]", "").trim());
            //date = formatter.parse(destinationDateTime.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getPublishedDateTimeFromFrontEnd(String destinationDateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON", "").replace("Published on", "").replace("IST", "").replace("1 Photos", "").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getPublishedDateTimeHighlightsFromFrontEnd(String destinationDateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(destinationDateTime.replace("UPDATED ON", "").replace("Updated:", "").replace("Published on", "").replace("IST", "").replace("1 Photos", "").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
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

    public boolean clickElementIfDisplayed(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementClicked = false;

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            isElementClicked = true;
            Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");

        } catch (Exception e) {
            System.out.println("****** Unable to find " + elementName + " within " + timeOutInSecond + " seconds *****");
        }
        return isElementClicked;
    }

    public boolean clickElementIfDisplayed(String xPath, int timeOutInSecond) {
        boolean isElementClicked = false;

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPath))));
            driver.findElement(By.xpath(xPath)).click();
            isElementClicked = true;
            Utils.logStepInfo(true, "Clicked on element successfully");

        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, "element not clicked successfully");
        }
        return isElementClicked;
    }

    public boolean clickElementIfDisplayed(WebElement element, int timeOutInSecond) {
        boolean isElementClicked = false;

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isElementClicked = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean isElementDisplayedOfListOfElements(List<WebElement> eleList, String elementName) {
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

    public boolean scrollUntilElementFound(WebElement elementToScroll) {
        boolean isElementDisplayed = false;
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;

        try {
            for (int i = 0; i < 6; i++) {
                new TouchAction((PerformsTouchActions) driver).press(PointOption.point(width / 2, height / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                        moveTo(PointOption.point(width / 2, height / 10)).release().perform();
                if (isElementDisplayed(elementToScroll, 5)) {
                    isElementDisplayed = true;
                    break;
                }
            }
        } catch (Exception e) {
            isElementDisplayed = false;
        }
        return isElementDisplayed;
    }

    public boolean clickElementIfDisplayed(WebElement element) {
        boolean isElementClicked = false;
        long t1 = System.currentTimeMillis();
        if (element.isDisplayed()) {
            element.click();
            isElementClicked = true;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("clickElementIfDisplayed for : " + globalVars.getProjectName() + " | Time: " + (t2 - t1) + " | Result: " + isElementClicked);
        return isElementClicked;
    }

    public boolean clickElement(WebElement element, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return true;
    }

    public boolean clickElement(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementSuccessfullyClick;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            Utils.logStepInfo(true, "clicked on " + elementName + " successfully");
            isElementSuccessfullyClick = true;
        } catch (Exception e) {
            Utils.logStepInfo(true, "clicked on " + elementName + " unsuccessful.");
            isElementSuccessfullyClick = false;
            e.printStackTrace();
        }
        return isElementSuccessfullyClick;
    }

    public boolean clickElementReload(WebElement element, int timeOutInSecond, String elementName) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            Thread.sleep(5000);
            Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
        } catch (Exception e) {

        }
        return true;
    }

    public boolean clickElementWithActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        return true;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public boolean clickElementWithJS(WebElement element, String elementName, int timeOutInSecond) {
        boolean isElementClicked = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", element);
            isElementClicked = true;
            Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
        } catch (Exception e) {
            Utils.logStepInfo(false, "Failed to click on " + elementName);
            System.out.println("******* Exception occurred: " + e.getMessage());
        }
        return isElementClicked;
    }

    public boolean moveElementWithActions(WebElement element, int timeOutInSecond, String elementName) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).build().perform();
        return true;
    }

    public boolean clickNMoveElementWithActions(WebElement element, WebElement secondElement, int timeOutInSecond, String elementName) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.click(element).moveToElement(secondElement).click().build().perform();
        return true;
    }

    public boolean moveElementWithActions(WebElement element, WebElement secondElement, int timeOutInSecond, String elementName) {
        boolean isStep = false;
        Actions actions = new Actions(driver);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element).build().perform();
            actions.moveToElement(secondElement).click(secondElement).build().perform();

            isStep = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isStep;
    }

    public int generateRandomNum() {
        Random randomNo = new Random();
        int index = randomNo.nextInt(1000);
        return index;
    }

    public boolean clickElementWithJS(WebElement element) {
        boolean isElementClicked = false;
        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", element);
            isElementClicked = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClicked;
    }

    public boolean clickElementWithJS(WebElement element, int timeOutInSecond) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);

        return true;
    }

    public boolean clickElementWithJS(WebElement element, int timeOutInSecond, String elementName) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);

        Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
        return true;
    }

    public void scrollUsingAction(WebElement Elmnt) {
        Actions actions = new Actions(driver);
        actions.moveToElement(Elmnt);
        actions.perform();


    }

    public boolean clickElementWithActions(WebElement element, int timeOutInSecond) {
        Actions actions;

        WebDriverWait wait;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        actions.moveToElement(element).click().build().perform();

        return true;
    }

    public void sendKey(WebElement element, String key) {
        element.clear();
        dummyWait(3);
        element.sendKeys(key);
    }

    public boolean sendKeyBoolean(WebElement element, String key) {
        try {
            element.sendKeys(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean sendKeyBoolean(WebElement element, String key, int timeOutInSecond) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);

        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);

        return true;
    }

    public boolean sendKeyBoolean(WebElement element, String key, int timeOutInSecond, String elementName) {

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(key);
        Utils.logStepInfo(true, "SendKeys '" + key + "' to " + elementName + " successfully");
        return true;
    }

    public boolean validateSendKey(WebElement element, String key, int timeOut) {
        boolean isStepTrue = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(key);
            isStepTrue = true;
            Utils.logStepInfo(true, "keyWord Entered");
        } catch (Exception e) {
            Utils.logStepInfo(false, "keyWord Not Entered");
            e.printStackTrace();
        }
        return isStepTrue;
    }

    public void sendKey(WebElement element, String key, int timeOutInSecond) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(key);
        } catch (StaleElementReferenceException staleElementReferenceException) {
            System.out.println("****** Found StaleElementReferenceException *******");
            if (tryCount < 1) {
                tryCount++;
                Utils.logStepInfo(false, "Found StaleElementReferenceException Retrying");
                sendKey(element, key, timeOutInSecond);
                tryCount = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeyWithActions(WebElement element, String key) {
        Actions actions;
        try {
            actions = new Actions(driver);
            actions.moveToElement(element).sendKeys(key).build().perform();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            System.out.println("****** Found StaleElementReferenceException *******");
            tryCount++;
            if (tryCount < 1) {
                tryCount++;
                Utils.logStepInfo(false, "Found StaleElementReferenceException Retrying");
                sendKeyWithActions(element, key);
                tryCount = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollToElement(WebElement element, String elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        Utils.logStepInfo(true, "Scrolled To element: " + elementName);
        waitForPageLoading();
    }

    public void closePopupIfExist(WebElement element, String elementName) {
        closePopupIfExist(element, elementName, 0);
    }

    public boolean isElementEnabledReload(WebElement element, int timeOut, String elementName) {
        boolean isElementEnabled = false;
        WebDriverWait wait;
        try {
            Thread.sleep(10000);
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

    public String getProperty(WebElement element, String propertyName) {
        String value = null;
        try {
            value = element.getAttribute(propertyName);
        } catch (Exception e) {
        }
        return value;
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

    public boolean isElementDisplayed(WebElement element) {
        boolean isElementDisplayed = false;
        try {
            isElementDisplayed = element.isDisplayed();

        } catch (StaleElementReferenceException staleElementReferenceException) {
            System.out.println("****** Found StaleElementReferenceException *******");
            if (tryCount < 1) {
                tryCount++;
                Utils.logStepInfo(false, "Found StaleElementReferenceException Retrying");
                isElementDisplayed = isElementDisplayed(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tryCount = 0;
        return isElementDisplayed;
    }

    public boolean isElementDisplayed(WebElement element, int timeOutInSecond) {
        boolean isElementDisplayed;

        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        isElementDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        isElementDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        return isElementDisplayed;
    }

    public void waitForElementToBeInvisible(WebElement element, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean isElementDisplayedWithoutTryCatch(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        isElementDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        Utils.logStepInfo(true, elementName + " available");
        return isElementDisplayed;
    }

    public void isElementNotDisplayed(WebElement element, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean isElementDisplayedWithCatch(WebElement element, int timeOutInSecond) {
        boolean isElementDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            isElementDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementDisplayed;
    }

    public boolean isElementDisplayed(List<WebElement> elements, int timeOutInSecond) {
        boolean isElementDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        for (WebElement element : elements) {
            isElementDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            if (!isElementDisplayed) {
                return isElementDisplayed;
            }
        }
        return isElementDisplayed;
    }

    public boolean isElementDisplayed(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            isElementDisplayed = element.isDisplayed();
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementDisplayed;

    }

    public boolean isElementDisplayedReload(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;

        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }

        isElementDisplayed = element.isDisplayed();
        Utils.logStepInfo(true, elementName + " available");

        return isElementDisplayed;
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getElementText(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    public String getElementText(WebElement element, int timeOutInSecond) {
        String text = "";
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            text = element.getText().trim();
            Utils.logStepInfo(true, "Get text from element successfully");
            Utils.logStepInfo(true, "Text found: " + text);
        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, "Not Able to get text from element");
        }
        return text;
    }

    public void waitForPageLoad() {
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    public String getElementText(WebElement element, String expectedText, int timeOutInSecond) {
        String text = "";
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));


        text = element.getText().trim();
        Utils.logStepInfo(true, "Get text from element successfully");
        Utils.logStepInfo(true, "Text found: " + text);

        return text;
    }

    public boolean checkElementText(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        } catch (Exception e) {
            isElementWithTextExist = false;
        }
        if (isElementWithTextExist) {
            Utils.logStepInfo(true, elementName + " verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
        }

        return isElementWithTextExist;
    }

    public void switchToWindow(String window) {
        try {
            System.out.println("************ Windows: " + window);
            driver.switchTo().window(window);
            //driver.getTitle();
        } catch (Exception e) {
            System.out.println("******* No such window found *******");
            //e.printStackTrace();
        }
    }

    public Set<String> getWindowHandles() {
        Set<String> handles = new HashSet<>();
        try {

            handles = driver.getWindowHandles();
            new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(2));

            handles = driver.getWindowHandles();

        } catch (Exception e) {
            System.out.println("Exception in *****getWindowHandles*****");
            e.printStackTrace();
        }

        return handles;
    }

    public Set<String> getWindowHandlesWithExpectedNumberOfWindows(int expectedNumberOfWindows) {
        Set<String> handles = new HashSet<>();
        try {

            handles = driver.getWindowHandles();
            new WebDriverWait(driver, 20).until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));

            handles = driver.getWindowHandles();

        } catch (Exception e) {
            System.out.println("Exception in *****getWindowHandles*****");
            e.printStackTrace();
        }

        return handles;
    }

    public Set<String> getWindowHandles(int expectedNoOfWindows) {
        Set<String> handles = new HashSet<>();
        try {
            for (int i = 0; i < 5; i++) {
                handles = driver.getWindowHandles();
                System.out.println("****** Inside getWindowHandles method with expected *****" + handles.size());
                if (handles.size() >= expectedNoOfWindows) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("********* Exception in getWindowHandlesWithExpectedNumberOfWindows() method *****");
            System.out.println("******* No. of windows available is: " + handles.size() + " ***********");
            //e.printStackTrace();
        }

        return handles;
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

    public void waitForWindow(int expectedNoOfWindows) {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.numberOfWindowsToBe(expectedNoOfWindows));
            Utils.logStepInfo(true, expectedNoOfWindows + " windows available");
        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, expectedNoOfWindows + " windows not available");
        }
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

    public Set<String> getWindowHandlesAll() {
        Set<String> handles = new LinkedHashSet<>();
        try {
            handles = driver.getWindowHandles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return handles;
    }

    public void deleteCookiesAndNavigateToHomePage() {
        System.out.println("*******************deleteCookiesAndNavigateToHomePage start*******************");
        try {
            closeAllWindowsExceptMasterTab();
            driver = globalVars.getWebDriver();

            //In order to navigate to home page after test case failure
            //DriverController driverController=DriverController.getInstance();
            //driverController.initializeDriver();
            driverController.navigateToApplicationHomePage(true);

            System.out.println("*******************deleteCookiesAndNavigateToHomePage ends*******************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFacebookCookies() {
        try {
            driver = globalVars.getWebDriver();
            driver.get("https://www.facebook.com/");
            driver.manage().deleteAllCookies();
            globalVars.setWebDriver(driver);
//            String urlVariable = globalVars.getEnvironment() + "Url";
//            String url = globalVars.getProp().getProperty(urlVariable);
//            driver.get(url);
            driver.get(globalVars.getURLMapSSO().get(globalVars.getApplicationName()));
            //**** reinitializing this class object so that the new driver can be attached to this class object
            commonFunctionsWeb = new CommonFunctionsWeb();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGoogleCookies() {
        try {
            driver = globalVars.getWebDriver();
            driver.get("https://myaccount.google.com/");
            driver.manage().deleteAllCookies();
            globalVars.setWebDriver(driver);
//            String urlVariable = globalVars.getEnvironment() + "Url";
//            String url = globalVars.getProp().getProperty(urlVariable);
//            driver.get(url);
            driver.get(globalVars.getURLMapSSO().get(globalVars.getApplicationName()));

            //**** reinitializing this class object so that the new driver can be attached to this class object
            commonFunctionsWeb = new CommonFunctionsWeb();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToTab(String oldTab) {
        try {
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            System.out.println("old tab value is :" + oldTab);
            newTab.remove(oldTab);
            System.out.println("current tab value is :" + tabCount);
            driver.switchTo().window(newTab.get(tabCount));
            tabCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeAllWindowsExceptMasterTabOnly() {
        Set<String> handleSet = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>(handleSet);
        try {
            if (windowsList.size() > 1) {
                switchToWindow(windowsList.get(0));
                String originalHandle = driver.getWindowHandle();
                for (String handle : handleSet) {
                    if (!handle.equals(originalHandle)) {
                        driver.switchTo().window(handle);
                        driver.close();
                    }
                }
                driver.switchTo().window(originalHandle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToMasterTab(String oldTab) {
        try {
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            System.out.println("master old tab value is :" + oldTab);
            newTab.remove(oldTab);
            driver.switchTo().window(newTab.get(0));
            System.out.println("master current tab value is :" + tabCount);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void inputHeadline(String headline, WebElement enterHeadlineText) {
        isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        clickElementIfDisplayed(enterHeadlineText);
        sendKeys(enterHeadlineText, headline, 10, "headline text");

    }

    public void inputSummary(String summary, WebElement addSummaryText) {
        sendKeys(addSummaryText, summary, 25, "summary box");
    }

    private void inputParagraph(String paragraph, WebElement addParagraphText) {
        isElementDisplayedAndPresent(addParagraphText, 20, "wait for intro para to be displayed");
        dummyWait(3);
        clickElement(addParagraphText, 10, "Paragraph");
        sendKeyWithActions(addParagraphText, paragraph);
    }

    private void inputPost(String postTitle, String postBody, WebElement addPostTitleText, WebElement addPostBodyText, WebElement buttonAddPost, WebElement allChangesSaved) {
        scrollPageWithJS(addPostTitleText, 20);
        isElementDisplayedAndPresent(addPostTitleText, 20, "wait for title displayed");
        isElementDisplayedAndPresent(addPostBodyText, 20, "wait for Body to be displayed");
        sendKeys(addPostTitleText, postTitle, 25, "post title box");
        scrollPageWithJS(addPostBodyText, 20);
        sendKeys(addPostBodyText, postBody, 25, "post body box");
        scrollPageWithJS(buttonAddPost, 10);
        clickElement(buttonAddPost, 25, "button add post");
        checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
        checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
    }

    public void inputSubSection(String subsection, WebElement inputAddSubSectionText, WebElement allChangesSaved) {
        sendKeys(inputAddSubSectionText, subsection, 20, "sub-section box");
        sendKeysWithEnter(inputAddSubSectionText, 10);
        checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
    }

    public void inputSection(String section, WebElement inputAddSectionText, WebElement allChangesSaved) {
        sendKeys(inputAddSectionText, section, 20, "section box");
        sendKeysWithEnter(inputAddSectionText, 10);
        checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 7, "wait for saving changes ");
    }

    public void inputTopic(String topic, WebElement inputTopicText, WebElement allChangesSaved) {
        sendKeys(inputTopicText, topic, 20, "sub-section box");
        sendKeysWithEnter(inputTopicText, 10);
        checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...", 10, "wait for saving changes ");
    }

    public void inputByLine(String byline, WebElement inputAddByLineText) {
        sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        dummyWait(5);
        sendKeysWithEnter(inputAddByLineText, 20);
    }

    public void inputKeyWords(String keyword, WebElement inputAddLocationText, WebElement inputAddKeywordText) {
        isElementDisplayedAndPresent(inputAddLocationText, 10, "location box");
        sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        sendKeysWithEnter(inputAddKeywordText, 10);
    }

    public void inputLocation(String location, WebElement inputAddLocationText) {
        if (isElementDisplayedAndPresent(inputAddLocationText, 3, "location box")) {
            sendKeys(inputAddLocationText, location, 20, "location box");
            sendKeysWithEnter(inputAddLocationText, 10);
        }
    }

    public void saveStoryAndVerify(WebElement saveButton, WebElement toastSaveButton, WebElement allChangesSaved) {
        clickElement(saveButton, 10, "save story button");
        isElementDisplayedWithoutTryCatch(toastSaveButton, 40, "Toast message on saved status");
        checkElementTextWithTryCatch(allChangesSaved, "ALL CHANGES ARE SAVED", 10, "wait for all changed are saved");
    }

    public String setStoryId() {
        String url = getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
        return storyIdNumber;
    }

    public String createStory(String headline, String summary, String paragraph, String postTitle,
                              String postBody, String section, String subsection, String byline,
                              String keyword, String location,
                              WebElement addPostTitleText, WebElement addPostBodyText, WebElement buttonAddPost,
                              WebElement allChangesSaved, WebElement enterHeadlineText, WebElement addSummaryText,
                              WebElement addParagraphText, WebElement inputAddSubSectionText, WebElement inputAddByLineText,
                              WebElement inputAddLocationText, WebElement inputAddKeywordText,
                              WebElement saveButton, WebElement toastSaveButton) {


        inputHeadline(headline, enterHeadlineText);
        inputSummary(summary, addSummaryText);
        inputParagraph(paragraph, addParagraphText);
        inputPost(postTitle, postBody, addPostTitleText, addPostBodyText, buttonAddPost, allChangesSaved);

        inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        inputByLine(byline, inputAddByLineText);
        inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        inputLocation(location, inputAddLocationText);
        saveStoryAndVerify(saveButton, toastSaveButton, allChangesSaved);
        return setStoryId();


    }

    public String createStory(String headline, String summary, String paragraph,
                              String subsection, String byline,
                              String keyword, String location,

                              WebElement allChangesSaved, WebElement enterHeadlineText, WebElement addSummaryText,
                              WebElement addParagraphText, WebElement inputAddSubSectionText, WebElement inputAddByLineText,
                              WebElement inputAddLocationText, WebElement inputAddKeywordText,
                              WebElement saveButton, WebElement toastSaveButton) {


        inputHeadline(headline + generateRandomNum() + "aw", enterHeadlineText);
        inputSummary(summary + generateRandomNum() + "aw", addSummaryText);
        inputParagraph(paragraph, addParagraphText);

        inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        inputByLine(byline, inputAddByLineText);
        inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        inputLocation(location, inputAddLocationText);
        saveStoryAndVerify(saveButton, toastSaveButton, allChangesSaved);
        return setStoryId();


    }

    public List<String> createStoryForNotification(String headline, String summary, String paragraph,
                                                   String subsection, String byline,
                                                   String keyword, String location,

                                                   WebElement allChangesSaved, WebElement enterHeadlineText, WebElement addSummaryText,
                                                   WebElement addParagraphText, WebElement inputAddSubSectionText, WebElement inputAddByLineText,
                                                   WebElement inputAddLocationText, WebElement inputAddKeywordText,
                                                   WebElement saveButton, WebElement toastSaveButton) {

        List<String> valueList = new ArrayList<String>();
        String headLine = generateRandomNum() + headline + "aw";
        valueList.add(headLine);
        inputHeadline(headLine, enterHeadlineText);
        inputSummary(summary + generateRandomNum() + "aw", addSummaryText);
        inputParagraph(paragraph, addParagraphText);

        inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        inputByLine(byline, inputAddByLineText);
        inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        inputLocation(location, inputAddLocationText);
        saveStoryAndVerify(saveButton, toastSaveButton, allChangesSaved);
        valueList.add(setStoryId());
        return valueList;


    }

    public void selectImage(WebElement elemnet, WebElement libElement, WebElement recUseElement, WebElement useElement, WebElement doneElement, WebElement yesButton, WebElement saveImageButton) {
        isElementDisplayed(elemnet, 10, "Image");
        clickElement(elemnet, 10, "Image");

        isElementDisplayed(libElement, 10, "Lib Image");
        clickElement(libElement, 10, "Lib Image");

        isElementDisplayed(recUseElement, 10, "Lib Image");
        mouseHoverOnElement(recUseElement, 10, "Lib Image");

        isElementDisplayed(useElement, 10, "Use Button");
        clickElement(useElement, 10, "Use Button");

        if (isElementDisplayed(yesButton, 10, "Yes Button")) {
            clickElement(yesButton, 10, "Yes Button");
        }

        isElementDisplayed(doneElement, 10, "Done Button");
        clickElement(doneElement, 10, "Done Button");

        isElementDisplayed(saveImageButton, 10, "Save Button");
        clickElementWithJS(saveImageButton, 10, "Save Button");

    }

    public void selectStory(String value, WebElement searchTextBox, WebElement searchButton, List<WebElement> resultList) {
        isElementDisplayed(searchTextBox, 10, "Search Text Box");
        sendKeys(searchTextBox, value, 10, "Search Text Box");

        isElementDisplayed(searchButton, 10, "Search Button");
        clickElementWithJS(searchButton, 10, "Search Button");
        hardWait(5000);
        System.out.println("value:- " + value);
        System.out.println("value text:- " + resultList.get(0).getText());
        System.out.println("Status Text:- " + resultList.get(2).getText());
        if ((resultList.get(0).getText().trim()).contains(value.trim()) && resultList.get(2).getText().trim().equalsIgnoreCase("PUBLISHED")) {
            clickElementWithJS(resultList.get(0), 10, "Search Story");
        }


    }

    public void sendKeys(WebElement element, String key, int timeOutInSecond, String elementName) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        hardWait(5000);
        element.sendKeys(key);
        Utils.logStepInfo(true, "SendKeys '" + key + "' to " + elementName + " successfully");
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

    public boolean switchToFrame(int index, int timeOut) {
        boolean isSwitchSuccessful = false;
        WebDriverWait wait;
        try {
            driver.switchTo().parentFrame();
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
            driver.switchTo().frame(index);
            isSwitchSuccessful = true;
        } catch (Exception exception) {
            System.out.println("****** Exception in switchToFrame() method: " + exception.getMessage());
        }

        return isSwitchSuccessful;
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void sendKeysOnElementVisibility(WebElement element, String key, int timeOutInSecond, String elementName) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(key);
        Utils.logStepInfo(true, "SendKeys '" + key + "' to " + elementName + " successfully");
    }

    public void sendKeysWithEnter(WebElement element, int timeOutInSecond) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ENTER);
    }

    public ArrayList<String> handleStaleElement(List<WebElement> element) {
        int count = 0;
        ArrayList<String> arrayElement = new ArrayList<String>();
        //It will try 4 times to find same element using name.
        while (count < 4) {
            try {
                for (WebElement traverseElement : element) {
                    arrayElement.add(traverseElement.getText());
                }
                return arrayElement;
            } catch (StaleElementReferenceException e) {
                e.toString();
                count = count + 1;
            }
//            count = count + 1;
        }
        return arrayElement;
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

    public boolean isElementEnabledWithoutTryCatch(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementEnabled;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        isElementEnabled = wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
        Utils.logStepInfo(true, elementName + " is enabled and  verified successfully");
        return isElementEnabled;
    }

    public boolean isElementEnabledWithCatch(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementEnabled;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            isElementEnabled = wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
        } catch (Exception ex) {
            isElementEnabled = false;
        }
        return isElementEnabled;
    }

    public boolean isElementPresent(WebElement element, int timeOutInSecond) {
        driver.manage().timeouts().implicitlyWait(timeOutInSecond, TimeUnit.SECONDS);
        return element.isDisplayed();
    }

    public boolean isElementPresentWithTryCatch(WebElement element, int timeOutInSecond) {
        boolean flag;
        driver.manage().timeouts().implicitlyWait(timeOutInSecond, TimeUnit.SECONDS);
        try {
            flag = element.isDisplayed();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean isElementPresentWithTryCatch(List<WebElement> element, int timeOutInSecond) {
        boolean flag;
        driver.manage().timeouts().implicitlyWait(timeOutInSecond, TimeUnit.SECONDS);
        try {
            flag = element.get(0).isDisplayed();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public boolean getElementTextAndCheck(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
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
            Utils.logStepInfo(false, elementName + " verification failed");
            return false;
        }
    }

    public boolean getElementTextWithGetAttributeValue(WebElement element, String expectedText, int timeOutInSecond, String elementAttr, String elementName) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        text = element.getAttribute(elementAttr);
        Utils.logStepInfo(true, "Get text from element successfully");
        if (text.trim().equals(expectedText)) {
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
            return false;
        }
    }

    public boolean waitForElementBeDisplayAndClick(WebElement element, int timeOutInSecond, String elementName) {
        try {
            Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", element);
            Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public String getCurrentDateAndTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSSZ");
        Date date = new Date();
        return formatter.format(date).toString();
    }

    public void selectOptionFromDropDown(WebElement element, int timeOutInSecond, String selectedValue, String elementName) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            Select dropDown = new Select(element);
            dropDown.selectByValue(selectedValue);
            Utils.logStepInfo(true, elementName + " is selected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectOptionFromDropDownWithVisibleText(WebElement element, int timeOutInSecond, String selectedValue, String elementName) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(selectedValue);
            Utils.logStepInfo(true, elementName + " is selected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isElementDisplayedAndPresent(List<WebElement> elements, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed = false;
        int listSize = 0;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            Utils.logStepInfo(true, elementName + " available");
            listSize = elements.size();
            if (listSize > 0) {
                isElementDisplayed = true;
                return isElementDisplayed;
            }

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            isElementDisplayed = false;
            return isElementDisplayed;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            isElementDisplayed = false;
            return isElementDisplayed;
        }
        return isElementDisplayed;
    }


    public boolean isElementDisplayedAndPresent(String xPath, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath(xPath))));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xPath)))).isDisplayed();
            Utils.logStepInfo(true, elementName + " available");
            isElementDisplayed = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isElementDisplayed;
    }

    public ArrayList<String> getSelectedOption(WebElement element, int timeOutInSecond, String elementName) {
        ArrayList<String> arrayElement = new ArrayList<String>();
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            Utils.logStepInfo(true, elementName + " available");
            Select dropDown = new Select(element);
            List<WebElement> listOfWebElement = dropDown.getOptions();
            for (WebElement traverseElement : listOfWebElement) {
                arrayElement.add(traverseElement.getText());
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return arrayElement;
    }

    public boolean clickElements(List<WebElement> elements, int timeOutInSecond, String elementName) {
        List<WebElement> allOptions = elements;
        for (WebElement webElement : allOptions) {
            Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(webElement)));
            webElement.click();
        }
        Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
        return true;
    }

    public boolean isElementDisplayed(List<WebElement> elements, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        List<WebElement> allOptions = elements;
        for (WebElement webElement : allOptions) {
            try {
                wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
                webElement.isDisplayed();
                isElementDisplayed = true;
            } catch (StaleElementReferenceException staleElementReferenceException) {
                if (tryCount < 1) {
                    tryCount++;
                    isElementDisplayed = isElementDisplayed(webElement);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tryCount = 0;
        Utils.logStepInfo(true, elementName + " available");
        return isElementDisplayed;
    }

    public boolean dragAndDrop(WebElement elementSource, WebElement elementTarget, int timeOutInSecond, String elementName) {
        WebDriverWait wait;
        boolean isDragAndDrop = false;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(elementSource));
            wait.until(ExpectedConditions.visibilityOf(elementTarget));
            Actions builder = new Actions(driver);
            Action dragAndDrop = builder.clickAndHold(elementSource)
                    .moveToElement(elementTarget)
                    .release(elementTarget)
                    .build();
            dragAndDrop.perform();
            Utils.logStepInfo("Elements" + elementName + "successfully");
            isDragAndDrop = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isDragAndDrop;
    }

    public boolean moveSlider(WebElement element, int timeOutInSecond, String elementName) {
        WebDriverWait wait;
        boolean isMoveSlider = false;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            Actions moveSlider = new Actions(driver);
            Action action = moveSlider.dragAndDropBy(element, 30, 0).build();
            action.perform();
            Utils.logStepInfo("slider moved " + elementName + " successfully");
            isMoveSlider = true;
            Utils.logStepInfo("slider moved " + elementName + " successfully");
            return isMoveSlider;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return isMoveSlider;
        }

    }

    public boolean clickElementWithAction(WebElement element, int timeOutInSecond, String elementName) {
        Actions actions;
        WebDriverWait wait;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).click().build().perform();
        Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
        return true;
    }

    public boolean isElementDisplayedWithExceptionHandling(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed = false;

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            isElementDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception exception) {
            Utils.logStepInfo(false, elementName + " not available");
            System.out.println(elementName + " not visible within " + timeOutInSecond + " seconds");
        }
        return isElementDisplayed;
    }

    public String getURLWithoutCatch() {
        return driver.getCurrentUrl();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void navigateToURl(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public boolean clickElementIgnoringStaleElement(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        element.click();
        Utils.logStepInfo(true, elementName + " available and clicked successfully");
        return true;
    }

    public boolean clickElementIgnoringStaleElement(String xPath, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPath)))));
        driver.findElement(By.xpath(xPath)).click();
        Utils.logStepInfo(true, elementName + " available");
        return true;
    }

    public boolean checkElementTextIgnoringStaleElement(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElement(element, expectedText)));
        Utils.logStepInfo(true, "expectedText For " + elementName + " is " + expectedText);
        return true;
    }

    public void waitForElementIgnoringStaleElement(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));

                Utils.logStepInfo(true, elementName + " available");
                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
    }

    public boolean clickForElementIgnoringStaleElement(String xPath, int timeOutInSecond, String elementName) {
        boolean isElementClicked = false;
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPath))));
                driver.findElement(By.xpath(xPath)).click();
                isElementClicked = true;
                Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
        return isElementClicked;
    }

    public void waitAndClickForElementIgnoringStaleElement(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
                element.click();
                Utils.logStepInfo(true, elementName + " available");
                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
    }

    public boolean waitAndGetElementTextAndCheck(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        String text = "";
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
                wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
                text = element.getText().trim();
                Utils.logStepInfo(true, "Text found: " + text);
                Utils.logStepInfo(true, elementName + " available");
                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
        return true;
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
            e.printStackTrace();
            return null;
        }
    }

    public boolean doubleClick(WebElement element, int timeOutInSecond, String elementName) {
        Actions actions;
        WebDriverWait wait;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.doubleClick(element).perform();
        Utils.logStepInfo(true, "Clicked on " + elementName + " successfully");
        return true;
    }

//    public void navigateToHomePageBlankpaper() {
//        String currentURL = driver.getCurrentUrl();
//        String urlVariable = globalVars.getEnvironment() + "Url";
//        if (!currentURL.equals(urlVariable)) {
//            driver.get(globalVars.getProp().getProperty(urlVariable));
//        }
//    }

    public boolean checkForXpathInsideWebElement(WebElement element, String cssSelector, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOf(element.findElement(By.cssSelector(cssSelector))));
            return true;
        } catch (Exception e) {
            System.out.println("***** element with xpath: " + cssSelector + " not visible ****");
            System.out.println("***** exception message: " + e.getMessage());
            return false;
        }
    }

    public void waitUntilSize(int timeOutInSecond, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(locator), 0));
    }

    public String getAttributeValueWithExplicitWait(WebElement element, int timeOutInSecond, String attribute) {
        String value = "";
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        for (int i = 0; i < 10; i++) {
            System.out.println("**** Iteration: " + i);
            value = element.getAttribute(attribute);
            if (value != null) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        Utils.logStepInfo(true, "Get Attribute from element successfully");
        Utils.logStepInfo(true, "Text found: " + value);
        return value;
    }

    public boolean checkElementTextWithTryCatch(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
            Utils.logStepInfo(true, elementName + " verified successfully, Element Text is : " + expectedText);
        } catch (Exception e) {
            System.out.println("********* Exception occurred in checkElementTextWithTryCatch() method: " + e.getMessage());
            Utils.logStepInfo(false, elementName + " Element Text : " + expectedText + " verification failed!!");
        }
        return isElementWithTextExist;
    }

    public void waitForElementToBeVisibleAndClickable(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));

        Utils.logStepInfo(true, elementName + " available");
    }


    public String waitAndGetElementTextIgnoringStaleElement(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        String text = "";
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
                text = element.getText().trim();
                Utils.logStepInfo(true, elementName + " Text found: " + text);
                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
        return text;
    }

    public boolean sendKeysIgnoringStaleElement(WebElement element, String key, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
                element.clear();
                element.sendKeys(key);
                Utils.logStepInfo(true, "SendKeys '" + key + "' to " + elementName + " successfully");

                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
        return true;
    }

    public void newTabWithUrl(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank');");
        Utils.logStepInfo(true, "new tab open successfully");
        Utils.logStepInfo(true, "url navigated successfully");

    }

    public String urlAuthenticationHandling(String expUrl, String username, String password) {
        Pattern pattern = Pattern.compile("(https?://)([^:^/]*)(:\\d*)?(.*)?");
        Matcher matcher = pattern.matcher(expUrl);
        matcher.find();
        String protocol = matcher.group(1);
        String domain = matcher.group(2);
        String uri = matcher.group(4);
        System.out.println("protocol: " + (protocol != null ? protocol : ""));
        System.out.println("domain: " + (domain != null ? domain : ""));
        System.out.println("uri: " + (uri != null ? uri : ""));
        String actualUrl = "http://" + username + ":" + password + "@" + domain + uri;
        System.out.println("Execution URL: " + actualUrl);
        return actualUrl;
    }

    public boolean isElementDisplayedIgnoringStaleElementException(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(element));
        Utils.logStepInfo(true, "isElementDisplayed() successful for " + elementName);
        return element.isDisplayed();
    }

    public boolean isElementDisplayedIgnoringNoSuchElementException(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Utils.logStepInfo(true, "isElementDisplayed() successful for " + elementName);
        return element.isDisplayed();
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

    public boolean checkElementTextWithEqualIgnoreCase(String text, String expText, String elementName) {
        if (text.equalsIgnoreCase(expText)) {
            Utils.logStepInfo(true, "Text found: " + text);
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " !*!*!*!* verification failed !*!*!*!*");
            return false;
        }
    }

    public void mouseHoverOnElement(WebElement element, int timeOutInSecond, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Utils.logStepInfo(true, "Moved to " + elementName + " successfully");
    }

    public void waitForElementToBeInvisibleWithCatch(WebElement element, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.out.println("*** exception at waitForElementToBeInvisibleWithCatch() method:" + e.getMessage());
        }
    }

    public boolean getElementTextAndCheckIgnoringStaleElementException(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        String text = "";
        try {
            Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(element));
            text = element.getText().trim();
            Utils.logStepInfo(true, "Get text from element successfully");
            Utils.logStepInfo(true, "Text found: " + text);
        } catch (Exception e) {
            System.out.println("****** Exception occurred at getElementTextAndCheckIgnoringStaleElementException() method: " + e.getMessage());
        }

        if (text.trim().equals(expectedText)) {
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
            return false;
        }
    }

    public boolean getElementTextAndCheck(String xPath, String expectedText, int timeOutInSecond, String elementName) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        text = driver.findElement(By.xpath(xPath)).getText().trim();
        Utils.logStepInfo(true, "Get text from element successfully");
        Utils.logStepInfo(true, "Text found: " + text);
        if (text.trim().equals(expectedText)) {
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " ********verification failed ********");
            return false;
        }
    }

    public boolean getElementTextAndCheck(String xPath, String expectedText, int timeOutInSecond, String elementName, int index) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        text = driver.findElements(By.xpath(xPath)).get(index).getText().trim();
        Utils.logStepInfo(true, "Get text from element successfully");
        Utils.logStepInfo(true, "Text found: " + text);
        if (text.trim().equals(expectedText)) {
            Utils.logStepInfo(true, elementName + " verified successfully");
            return true;
        } else {
            Utils.logStepInfo(false, elementName + " ********verification failed ********");
            return false;
        }
    }

    public boolean getElementTextAndCheckWithEqualIgnoreCase(String xPath, String expectedText, int timeOutInSecond, String elementName) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        text = driver.findElement(By.xpath(xPath)).getText().trim();
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

    public boolean dragAndDropIgnoringStaleElement(WebElement elementSource, WebElement elementTarget, int timeOutInSecond, String elementName) {
        boolean isDragAndDrop = false;
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.visibilityOf(elementSource));
                wait.until(ExpectedConditions.visibilityOf(elementTarget));
                Actions builder = new Actions(driver);
                builder.dragAndDrop(elementSource, elementTarget).build().perform();
                Utils.logStepInfo(true, "Elements " + elementName + " successfully");
                isDragAndDrop = true;
                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
        return isDragAndDrop;
    }

    public boolean elementIsNotPresent(String xPath, int timeOutInSecond, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
            List<WebElement> storyList = driver.findElements(By.xpath(xPath));
            storyList.isEmpty();
            Utils.logStepInfo(true, elementName + " not present");
            Utils.logStepInfo(true, elementName + " ******** verification Successfully *******");
            return true;
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " is present");
            Utils.logStepInfo(false, elementName + " ********verification failed *******");
            return false;
        }
    }


    public boolean isElementDisplayed(String xPath, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).isDisplayed();
            Utils.logStepInfo(true, elementName + " available");
            isElementDisplayed = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isElementDisplayed;
    }

    public boolean clickElementIfDisplayed(String xPath, int timeOutInSecond, String elementName) {
        boolean isElementClicked = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).isDisplayed();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
            driver.findElement(By.xpath(xPath)).click();
            isElementClicked = true;
            Utils.logStepInfo(true, elementName + "Clicked on element successfully");

        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, elementName + "element not clicked successfully");
        }
        return isElementClicked;
    }

    public boolean waitForElementListToAppear(String xpath, int timeOutInSecond, String elementName) {
        boolean isElementSizeGreaterThanOne = false;
        try {
            Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpath), 0));

//            wait.until((ExpectedCondition<Boolean>) driver -> {
//                int elementCount = elementList.size();
//                final boolean sizeFlag;
//                if (elementCount > 1) {
//                    sizeFlag= true;
//                }
//                else {
//                    sizeFlag= false;
//                }
//                return sizeFlag;
//            });
            Utils.logStepInfo(true, elementName + ": element list size greater than one");
            isElementSizeGreaterThanOne = true;

        } catch (Exception e) {
            System.out.println("**** Exception occurred at waitForElementListToAppear(): " + e.getMessage());
            Utils.logStepInfo(false, elementName + ": element list size is not greater than one!!");
        }
        return isElementSizeGreaterThanOne;
    }

    public void uploadFile(String filePath) {
        try {
            //Setting clipboard with file location
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(150);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }


    public boolean isElementDisplayedIgnoringStaleElementWithCatch(WebElement element, int timeOutInSecond, String elementName) {
        boolean isShowing = false;
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
                isShowing = element.isDisplayed();
                isShowing &= true;
                Utils.logStepInfo(true, elementName + " is Present ");
                break;
            } catch (StaleElementReferenceException e) {
                Utils.logStepInfo("***** Ignoring stale element Exception error ******");
            }
            attempts++;
        }
        return isShowing;
    }


    public void closeAllWindowsExceptMasterTab() {
        try {

           /* String title=driver.getTitle();
            if(title.contains("Facebook") && driver.getWindowHandles().size()>1){
                driver.close();
            }*/

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

    public boolean switchToFrame(String frame) {
        boolean isSwitchSuccessful;
        try {
            driver.switchTo().frame(frame);
            isSwitchSuccessful = true;
        } catch (Exception e) {
            isSwitchSuccessful = false;
            System.out.println("***** Exception in switchToFrame() *****: " + e.getMessage());
        }

        return isSwitchSuccessful;
    }

    public boolean isElementDisplayedIgnoringStaleElement(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        isElementDisplayed = element.isDisplayed();
        Utils.logStepInfo(true, elementName + " available");
        return isElementDisplayed;
    }

    public void navigateToHomePage() {

        driverController.navigateToApplicationHomePage(false);
    }

    public boolean clickElementWithFluentWait(WebElement element, int timeOutInSecond, String elementName) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        Utils.logStepInfo(true, "clicked on" + elementName + " successfully");
        return true;
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


    public void selectElementFromList(List<WebElement> eleList, String expectedText, int timeOutInSecond) {
        String text;
        try {
            for (WebElement ele : eleList) {
                scrollToViewElement(ele, ele.getText(), 20);
                text = ele.getText().trim();
                if (text.equalsIgnoreCase(expectedText)) {
                    clickElement(ele, timeOutInSecond, "Element related to " + expectedText + " got clicked.");
                }
            }
            Utils.logStepInfo(true, expectedText + " get clicked.");
        } catch (Exception e) {
            Utils.logStepInfo(false, expectedText + " did not get clicked.");
            e.printStackTrace();
        }
    }

    public void moveToElementWithActions(WebElement element, int timeOutInSecond, String elementName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Utils.logStepInfo(true, "Moved to " + elementName + " successfully");
    }

    public void moveToElementWithActionsThenClick(WebElement element, int timeOutInSecond, String elementName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        Utils.logStepInfo(true, "Moved to " + elementName + " and click successfully");
    }

    public boolean moveToElementWithActions(List<WebElement> ele) {
        boolean isMoveToElementWithActions = false;
        Actions actions = new Actions(driver);
        try {

            for (int i = 0; i < ele.size(); i++) {
                if (ele.get(i).isDisplayed()) {
                    actions.moveToElement(ele.get(i)).perform();
                    Thread.sleep(3000);
                    /*JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].scrollIntoView();", ele.get(i));*/
                    String[] str = ele.get(i).getText().split("\n");
                    isMoveToElementWithActions = true;
                    Utils.logStepInfo(isMoveToElementWithActions, "name is " + str[0] + ".");
                }
            }
        } catch (Exception e) {
            isMoveToElementWithActions = false;
            System.out.println("***** Exception in moveToElementWithActions() *****: " + e.getMessage());
            e.printStackTrace();
        }
        return isMoveToElementWithActions;
    }


    public boolean compareActualTextForCompareCars(WebElement ele, String textToBeRemoved, String text1, String text2) {
        boolean isCompareActualTextForCompareCars = false;
        String str1;
        String[] strArray;
        try {
            str1 = ele.getText().trim().replace(textToBeRemoved, "").replaceAll(" ", "");
            strArray = str1.replaceAll(" ", "").split("vs");
            if (strArray[0].equalsIgnoreCase(text1.replaceAll(" ", "")) && strArray[1].equalsIgnoreCase(text2.replaceAll(" ", ""))) {
                isCompareActualTextForCompareCars = true;
                Utils.logStepInfo("Text is visible as " + str1);
            }
        } catch (Exception e) {
            Utils.logStepInfo("================> compareActualTextForCompareCars ==========");
            e.printStackTrace();
        }
        return isCompareActualTextForCompareCars;
    }


    public String getTextsFromList(List<WebElement> eleList, int timeOutInSecond) {
        String str = null;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            for (WebElement ele : eleList) {
                str = commonFunctionsWeb.getElementText(ele, 10);
                Utils.logStepInfo(true, "Found:\n" + str);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, "Either element is not present or it could not have any text value.");
            e.printStackTrace();
        }
        return str;
    }


    public boolean isEnabledElementVerify(WebElement ele, String elementName) {
        boolean isSelectedElement;
        try {
            if (ele.isEnabled()) {
                isSelectedElement = true;
                Utils.logStepInfo(true, elementName + " is not enabled.");
            } else {
                isSelectedElement = false;
                Utils.logStepInfo(false, elementName + " is enabled already.");
            }
        } catch (Exception e) {
            Utils.logStepInfo("==================>isEnabledElementVerify is failed.=======================");
            isSelectedElement = false;
            e.printStackTrace();
        }
        return isSelectedElement;
    }


    public boolean validateTabularForAllWebElement(List<WebElement> list, String eleListName) {
        boolean isGetVisibitiesOfWebElement = false;
        try {
            if (list.size() > 0) {
                isGetVisibitiesOfWebElement = true;
                Utils.logStepInfo(isGetVisibitiesOfWebElement, eleListName + " is available.");
            } else {
                isGetVisibitiesOfWebElement = false;
                Utils.logStepInfo(isGetVisibitiesOfWebElement, eleListName + " is not available.");
            }
        } catch (Exception e) {
            isGetVisibitiesOfWebElement = false;
            e.printStackTrace();
        }
        return isGetVisibitiesOfWebElement;
    }


    public boolean clickingOnElementDisable(WebElement ele, int timeOutInSecond, String elementName) {
        boolean isClickingOnElementDisable = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            if (ele.isEnabled()) {
                ele.click();
                isClickingOnElementDisable = true;
                Utils.logStepInfo(true, elementName + " is working");
            }
        } catch (Exception e) {
            isClickingOnElementDisable = false;
            Utils.logStepInfo(false, elementName + " is not working");
            e.printStackTrace();
        }
        return isClickingOnElementDisable;
    }

    public boolean isAllElementVisible(List<WebElement> eleList, int timeOutInSecond) {
        boolean isAllElementVisible;
        try {
            WebDriverWait listWait = new WebDriverWait(driver, 10);
            listWait.until(ExpectedConditions.visibilityOfAllElements(eleList));
            isAllElementVisible = true;
            Utils.logStepInfo(isAllElementVisible, "All elements are visible.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            isAllElementVisible = false;
            Utils.logStepInfo(isAllElementVisible, "All elements are not visible.");
            e.printStackTrace();
        }
        return isAllElementVisible;
    }


    public boolean validateGetTextByTabular(List<WebElement> eleList, String elementsName) {
        boolean isValidateGetTextByTabular = false;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text;
        try {
            commonFunctionsWeb.dummyWait(5);
            for (WebElement ele : eleList) {
                text = (String) js.executeScript("return jQuery(arguments[0]).text();", ele);
                if (!text.isEmpty()) {
                    isValidateGetTextByTabular = true;
                    Utils.logStepInfo(true, text + " value is available for all " + elementsName);
                } else {
                    isValidateGetTextByTabular = false;
                    Utils.logStepInfo(false, text + " value is available for all " + elementsName);
                }
            }
            if (isValidateGetTextByTabular = true) {
                Utils.logStepInfo(true, "Text values are available for all " + elementsName);
            } else {
                Utils.logStepInfo(false, "Text value is not availbale for all " + elementsName);
            }
        } catch (Exception e) {
            Utils.logStepInfo("=====================> validateGetTextByTabular <===============");
            e.printStackTrace();
        }
        return isValidateGetTextByTabular;
    }


    public boolean isClickableElementClicked(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementClickable = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            Thread.sleep(5000);
            moveToElementToClick(element);
            isElementClickable = true;
            Utils.logStepInfo(isElementClickable, elementName + " is clicked.");
        } catch (Exception e) {
            isElementClickable = false;
            Utils.logStepInfo(isElementClickable, elementName + " is not clicked.");
            System.out.println("****** Unable to find " + elementName + " within " + timeOutInSecond + " seconds *****");
            e.printStackTrace();
        }
        return isElementClickable;
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

    public boolean scrollToViewElement(WebElement ele, String elementName, int timeOutInSecond) {
        boolean isScrollToViewElement;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
            isScrollToViewElement = true;
            Utils.logStepInfo(true, elementName + " is available.");
        } catch (Exception e) {
            isScrollToViewElement = false;
            Utils.logStepInfo(false, elementName + " is not available.");
            e.printStackTrace();
        }
        return isScrollToViewElement;
    }


    public boolean getElementsClickable(List<WebElement> elementList, int timeOutInSecond, String elementName) {
        boolean isGetElementClickable = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        Actions actions = new Actions(driver);
        WebElement ele;
        try {
            for (int i = 0; i < elementList.size(); i++) {
                ele = elementList.get(i);
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

    public boolean clickWhenElementIsEnabled(WebElement ele, long timeOutInSeconds, String elementName) {
        boolean isSelectedElement;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            clickElement(ele, 20, elementName);
            isSelectedElement = true;
            Utils.logStepInfo(true, elementName + " is enabled and thus got clicked.");
        } catch (Exception e) {
            Utils.logStepInfo(false, "==================>isEnabledElementVerify is failed.=======================");
            isSelectedElement = false;
            e.printStackTrace();
        }
        return isSelectedElement;
    }


    public boolean sendKeyBooleanWithExpectedElement(WebElement element, String key, String elementName) {
        boolean isSendKeyBooleanWithExpectedElement = false;

        try {
            element.clear();
            element.sendKeys(key);
            Thread.sleep(1000);
            element.sendKeys(Keys.ARROW_DOWN);
            element.sendKeys(Keys.ENTER);
            isSendKeyBooleanWithExpectedElement = true;
            Utils.logStepInfo(true, "SendKeys '" + key + "' to " + elementName + " successfully");
        } catch (Exception e) {
            isSendKeyBooleanWithExpectedElement = false;
            Utils.logStepInfo(false, "SendKeys '" + key + "' to " + elementName + " failed");
            e.printStackTrace();
        }
        return isSendKeyBooleanWithExpectedElement;
    }


    //returns true if signButton is present on the home page i.e. preset is already true else it will do the preset and return false
    public boolean presetHomePage(WebElement signInButton) {
        closeAllWindowsExceptMasterTab();
        driver = globalVars.getWebDriver();
        if (isElementDisplayedWithCatch(signInButton, 10)) {
            return true;
        } else {
            driverController.navigateToApplicationHomePage(true);
            return false;
        }
    }


    public boolean checkPageURL(String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementPageURLExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        dummyWait(60);
        String getPageUrl = driver.getCurrentUrl();
        isElementPageURLExist = getPageUrl.contains(expectedText);
        if (isElementPageURLExist) {
            Utils.logStepInfo(true, elementName + " URL verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " URL verification failed. Expected:" + expectedText + ", Actual:" + getPageUrl);
        }
        return isElementPageURLExist;
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

    public String getCurrentURL() {
        waitForPageLoading();
        String currentUrl = driver.getCurrentUrl().trim();
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

    public boolean checkTextContains(String expectedText, String actualText, String elementName) {
        boolean verification = false;
        try {
            if (actualText.contains(expectedText.trim())) {
                Utils.logStepInfo(true, " verification of text contains passed for " + elementName + ". Expected: " + expectedText);
                verification = true;
            } else {
                Utils.logStepInfo(false, elementName + " verification of text contains failed. Expected: " + expectedText + ", Actual: " + actualText);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " verification of text contains failed. Expected: " + expectedText + ", Actual: " + actualText);
        }
        return verification;
    }


    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Utils.logStepInfo(true, "Scrolled To Bottom ");
        waitForPageLoading();
    }

    public boolean checkCSSProperty(WebElement element, String propertyName, String propertyValue, String elementName) {
        boolean verification = false;
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


    public boolean checkTextEquals(String expectedText, String actualText, String elementName) {
        boolean verification = false;
        try {
            if (actualText.equals(expectedText)) {
                Utils.logStepInfo(true, " verification of text equals passed for " + elementName + ". Expected: " + expectedText);
                verification = true;
            } else {
                Utils.logStepInfo(false, elementName + " verification of text equals failed. Expected: " + expectedText + ", Actual: " + actualText);
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " verification of text equals failed. Expected: " + expectedText + ", Actual: " + actualText);
        }
        return verification;
    }

    public String getTitle() {
        String title = "";
        try {
            title = driver.getTitle();
            System.out.println("Title Found : " + title);
        } catch (Exception e) {
            System.out.println("******* Title Not Found ******* " + e);
            e.printStackTrace();
        }
        return title;
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

    public boolean checkPageTitle(String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementPageTitleExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        String getPageTitle = driver.getTitle();
        isElementPageTitleExist = getPageTitle.contains(expectedText);
        if (isElementPageTitleExist) {
            Utils.logStepInfo(true, elementName + " verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
        }
        Utils.logStepInfo(isElementPageTitleExist, elementName + " found: " + getPageTitle);

        return isElementPageTitleExist;
    }

    public boolean clickElementUsingCoordinates(int x1, int y1) {
        boolean isElementClicked = false;
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
            actions.moveByOffset(x1, y1).click().build().perform();
            isElementClicked = true;
        } catch (Exception e) {
            System.out.println("Exception capture " + e.getMessage());
        }
        return isElementClicked;
    }

    public boolean  isElementNotDisplayed(WebElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = true;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementDisplayed = false;
            Utils.logStepInfo(false, elementName + " displayed.This is not expected.Element should not be visible");
        } catch (Exception e) {
            Utils.logStepInfo(true, elementName + " not displayed.This is expected");
        }
        return isElementDisplayed;
    }

    public void switchToChildWindowsExceptMasterTab() {
        try {

            ArrayList<String> handleList = new ArrayList<>(driver.getWindowHandles());
            if (handleList.size() > 1) {
                for (int i = 1; i < handleList.size(); i++) {
                    driver.switchTo().window(handleList.get(i));
                }
            }
            driver.switchTo().window(handleList.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    public boolean isElementClickable(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementDisplayed = element.isEnabled();
            Utils.logStepInfo(true, elementName + " clickable");
        } catch (Exception e) {
            Utils.logStepInfo(elementName + " not clickable");
            isElementDisplayed = false;
        }
        return isElementDisplayed;
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


    public void scrollWithCoOrdinates(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + ", " + y + ")");
        Utils.logStepInfo(true, "Scrolled To Coordinates: " + x + ", " + y);
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

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("***** Exception in switchToDefaultContent() *****: " + e.getMessage());
        }

    }

    public boolean checkVideoPauseButton() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            Thread.sleep(5000);
            executor.executeScript("jwplayer().pause();");
            Thread.sleep(4000);
            Utils.logStepInfo(true, "video pause button available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkVideoPlayButton() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            Thread.sleep(4000);
            executor.executeScript("jwplayer().play();");
            Thread.sleep(4000);
            Utils.logStepInfo(true, "video play button available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean checkVideoMuteAndVolumeButton() {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
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

    public void suggestiveSkipAd(String text) {
        try {
            driver.findElement(By.xpath("//div[contains(text(),'" + text + "')]")).click();

        } catch (Exception e) {
            System.out.println("Skip Add Button not found");
        }
    }

    public boolean clickElementWithActions(WebElement element, int timeOutInSecond, String elementName) {
        Actions actions;

        WebDriverWait wait;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        actions.moveToElement(element).click().build().perform();
        Utils.logStepInfo(true, "clicked on" + elementName + " successfully");

        return true;
    }


    public String giveCurrentUrl() {
        String s = driver.getCurrentUrl();
        return s;

    }

    public boolean scrollUsingAction(WebElement element, String elementName) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean scrollUsingWait(WebElement element, String elementName, int timeOutInSecond) {
        try {
            WebDriverWait wait;
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
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

    public boolean getTitleOfpage(String elementName) {
        try {
            String title = driver.getCurrentUrl();
            System.out.println("title of page" + title);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.logStepInfo(true, elementName + " available");
        return true;
    }

    public boolean scrollToElementViewAndClick(WebElement element, int timeOutInSecond, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            executor.executeScript("arguments[0].click();", element);
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean scrollToElementView(WebElement element, int timeOutInSecond, String elementName) {
        boolean isScrollToElementViewTrue;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView();", element);
            Utils.logStepInfo(true, elementName + " available");
            return isElementDisplayed(element, 10, elementName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean isElementEnabled(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementEnabled = false;
        try {

            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            isElementEnabled = element.isEnabled();
            Utils.logStepInfo(true, elementName + " available");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementEnabled;
    }

    public String getCurrentURL(String elementName) {
        String title = null;
        try {
            title = driver.getCurrentUrl();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
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

    public String getStoryIdFromURL() {
        commonFunctionsWeb.waitForURLContains(".html");
        String currentUrl = driver.getCurrentUrl();
        int index = currentUrl.lastIndexOf("-");
        int lastIndex = currentUrl.lastIndexOf(".");
        String storyId = currentUrl.substring(index + 1, lastIndex);
        return storyId;

    }


    public WebElement getfocus(int timeOutInSecond, String elementName) {

        driver.getCurrentUrl();
        //activeElement() to verify element focused
        WebElement element = driver.switchTo().activeElement();
        Utils.logStepInfo(true, "Current Focus is on" + element);
        return element;

    }

    public void waitForPageLoading() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
        } catch (Exception e) {
        }
    }

    public void elementToTextDisplayed(String elementName) {
        Utils.logStepInfo(true, elementName + " displayed");
    }

    public void elementToElementDisplayed(WebElement elementName) {
        Utils.logStepInfo(true, elementName + " displayed");
    }

    public void scrollDown() {


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Utils.logStepInfo("Successfully scrolled to Bottom of the Page");

    }

    public void scrollDown(WebElement element) {


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Utils.logStepInfo("Successfully scrolled to Bottom of the Page");

    }

    public void textToReport(String text) {
        Utils.logStepInfo(true, "" + text + "");
    }

    public String extractStoryID(String s) {


        String storyID = "";
        Pattern p = Pattern.compile("\\-([0-9]+)\\.");
        Matcher m = p.matcher(s);

        while (m.find()) {
            storyID = m.group(1);
        }
        return storyID;
    }

    public Response getResponseFromURI(String uri, String code) {
        RestAssured.baseURI = uri + code;
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();
        return response;
    }


    public boolean isElementDisplayedIgnoringException(WebElement element, int timeOutInSecond, String elementName) {
        boolean isElementDisplayed;
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        isElementDisplayed = element.isDisplayed();
        Utils.logStepInfo(true, elementName + " available");
        return isElementDisplayed;
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
        Utils.logStepInfo(true, "Scrolled To Top ");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");
        Utils.logStepInfo(true, "Scrolled Up");
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

    public void pageRefresh() {
        driver.navigate().refresh();
    }

    public boolean dummyWait(int timeOut) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Dummy")));
        } catch (Exception e) {
            Utils.logStepInfo(true, "Wait for " + timeOut + " sec");
        }
        return isElementDisplayed;
    }

    public void waitForURLContains(String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.urlContains(text));
        } catch (Exception e) {
        }
    }

    public void clearText(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public boolean checkAllHamburgerElements(List<WebElement> eleList, WebElement ele) {
        boolean checkAllHamburgerElementsStatus;
        boolean isLinkClickable = false;
        boolean isLinkDisplayed = false;
        boolean isURLCorrectStatus = false;
        boolean isPageBrokenStatus = false;
        String hrefValue;
        String propValue;

        try {
            for (int i = 0; i < eleList.size(); i++) {
                hrefValue = eleList.get(i).getAttribute("href");
                propValue = eleList.get(i).getText().toLowerCase();
                isLinkDisplayed = isElementDisplayed(eleList.get(i), 10, propValue);
                isLinkClickable = isElementClickable(eleList.get(i), 10, propValue);
                eleList.get(i).click();
                isURLCorrectStatus = checkPageURLSC(hrefValue, 10, "");
                isPageBrokenStatus = checkElementNotPresent(ele);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (isLinkClickable && isLinkDisplayed && isURLCorrectStatus && isPageBrokenStatus) {
            checkAllHamburgerElementsStatus = true;
        } else {
            checkAllHamburgerElementsStatus = false;
        }
        return checkAllHamburgerElementsStatus;
    }

    public boolean checkHamburgerAllListsNotBlank(List<WebElement> eleList) {
        boolean checkHamburgerAllListsNotBlankStatus = false;
        try {
            if (eleList.size() != 0) {
                checkHamburgerAllListsNotBlankStatus = true;
                Utils.logStepInfo("Hamburger List Not Blank");
            } else {
                checkHamburgerAllListsNotBlankStatus = false;
                Utils.logStepInfo("Hamburger List is Blank");
            }
        } catch (Exception e) {
            System.out.println("Hamburger List Not found in page");
        }
        return checkHamburgerAllListsNotBlankStatus;
    }

    public boolean checkHamburgerOpensAndClose(WebElement ele1, WebElement ele2) {
        boolean isHamburgerOpensAndCloseStatus;
        boolean isLinkClickable = false;
        boolean isLinkDisplayed = false;
        boolean isHamburgerOpen = false;
        boolean isHamburgerClosed = false;
        try {
            isLinkDisplayed = isElementDisplayed(ele1, 10, "HamburgerLines");
            isLinkClickable = isElementClickable(ele1, 10, "HamburgerLines");
            isHamburgerOpen = isElementClickable(ele1, 10, "Hamburger is Open");
            clickElementIfDisplayed(ele1, 10, "Hamburger is Closed");
            isLinkDisplayed = isElementDisplayed(ele2, 10, "HamburgerLines");
            isLinkClickable = isElementClickable(ele2, 10, "HamburgerLines");
            isHamburgerClosed = isElementClickable(ele2, 10, "Hamburger is Closed");
            clickElementIfDisplayed(ele2, 10, "Hamburger is Open");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (isLinkClickable && isLinkDisplayed && isHamburgerOpen && isHamburgerClosed) {
            isHamburgerOpensAndCloseStatus = true;
        } else {
            isHamburgerOpensAndCloseStatus = false;
        }
        return isHamburgerOpensAndCloseStatus;
    }

    public boolean checkPodcastButtonsFunctionality(WebElement ele, String elementName) {
        boolean checkPodcastButtonsFunctionalityStatus;
        boolean isElementClickable = false;
        boolean isPodcastButtonClicked = false;

        try {
            isElementClickable = isElementClickable(ele, 30, elementName);
            isPodcastButtonClicked = clickElementWithJS(ele, 30, elementName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isElementClickable && isPodcastButtonClicked) {
            checkPodcastButtonsFunctionalityStatus = true;
        } else {
            checkPodcastButtonsFunctionalityStatus = false;
        }
        return checkPodcastButtonsFunctionalityStatus;
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

    public void sendKeyWithRandomEmail(WebElement element, int timeOutInSecond) {
        WebDriverWait wait;
        String keys = "testSmart" + System.nanoTime() + "@mailinator.com";
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(keys);
            Utils.logStepInfo(true, "SendKeys " + keys + " to Email text box successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void navigateToHomePageSC() {
        System.out.println("*******************NavigateToHomePage start*******************");
        try {
            driver = globalVars.getWebDriver();
            String urlVariable = globalVars.getEnvironment() + "Url";
            String url = globalVars.getProp().getProperty(urlVariable);
            driver.get(url);
            System.out.println("*******************NavigateToHomePage ends*******************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean checkPageURLSC(String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementPageURLExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        String getPageUrl = driver.getCurrentUrl();
        isElementPageURLExist = getPageUrl.contains(expectedText);
        if (isElementPageURLExist) {
            Utils.logStepInfo(true, elementName + " URL verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " URL verification failed. Expected:" + expectedText + ", Actual:" + getPageUrl);
        }
        return isElementPageURLExist;
    }

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

    public String getStringWithoutAngularBrackets(String str) {
        String finalStr = str;
        finalStr = finalStr.replaceAll("\\<(.*?)\\>", "");
        return finalStr;
    }

    public String getAtribute(WebElement element, String name) {
        String valueAttribute = element.getAttribute(name);
        return valueAttribute;
    }

    public void pressEscButton() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public int getResponseCode(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            Utils.logStepInfo(true, huc.getResponseCode() + " is the real status code for URL -- " + urlString);
            return huc.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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

    public boolean navigateToPageThroughExploremenu(WebElement explore, WebElement pagetoOpen, String pageName) {
        boolean newsLetterpageOpened = false;
        navigateToURL(globalVars.getURL());
        clickElement(explore, 10, "Explore link");
        clickElement(pagetoOpen, 10, pageName + " link in Explore Menu");
        checkTextContainByCurrentURL(pageName, pageName);

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

    public boolean checkForYouLayoutsubSub(WebElement pageTitle, WebElement exploreMenu, WebElement ePaper, WebElement timestamp, WebElement allowNotification, WebElement Myaccount, WebElement ForuYou) {
        boolean checkForYouLayoutsubSubUserLogin;
        boolean isLinkDisplayed = false;
        try {
            navigateToURL(globalVars.getURL());
            dummyWait(10);
            clickElement(ForuYou, 10, "ForYouNav");
            isLinkDisplayed = isElementDisplayed(pageTitle, 10, "Submintlogo");
            isLinkDisplayed &= isElementDisplayed(exploreMenu, 10, "SubExploremenu ");
            isLinkDisplayed &= isElementDisplayed(ePaper, 10, "Subepaper");
            isLinkDisplayed &= isElementDisplayed(timestamp, 10, "Subdatestam");
            isLinkDisplayed &= isElementDisplayed(allowNotification, 10, "Subnotification");
            isLinkDisplayed &= isElementDisplayed(Myaccount, 20, "MyAccount");
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
            isLinkDisplayed = isElementDisplayed(LHSHome, 10, "Sub HOME Button");
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

    public void selectOptionFromDropDownByVisibleText(WebElement element, int timeOutInSecond, String selectedValue, String elementName) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            Select dropDown = new Select(element);
            if (dropDown.getOptions().size() < 1) {
                dummyWait(10);
            }
            dropDown.selectByVisibleText(selectedValue);
            Utils.logStepInfo(true, elementName + " is selected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public boolean checkWSJ(WebElement pageLogo, WebElement exploreMenu, WebElement ePaper, WebElement NotificationIcon, WebElement timestamp) {
        boolean isLinkDisplayed = false;
        try {

            isLinkDisplayed = isElementDisplayed(pageLogo, 10, "Mintlogo");
            isLinkDisplayed &= isElementDisplayed(exploreMenu, 10, "Exploremenu ");
            isLinkDisplayed &= isElementDisplayed(ePaper, 10, "Epaper CTA");
            isLinkDisplayed &= isElementDisplayed(timestamp, 10, "Current Date WSJ");
            isLinkDisplayed &= isElementDisplayed(NotificationIcon, 10, "Notification CAT");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isLinkDisplayed;

    }

    public boolean checklHSNAVLinksWSJ(WebElement LHSHome, WebElement LHSLatest, WebElement LHSMarkets, WebElement LHSPremium, WebElement LHSForYou) {
        boolean isLinkDisplayed = false;
        try {

            isLinkDisplayed = isElementDisplayed(LHSHome, 10, "HOME Button");
            isLinkDisplayed &= isElementDisplayed(LHSLatest, 10, "LATEST Button");
            isLinkDisplayed &= isElementDisplayed(LHSMarkets, 10, "MARKET Button");
            isLinkDisplayed &= isElementDisplayed(LHSPremium, 10, "PREMIUM Button");
            isLinkDisplayed &= isElementDisplayed(LHSForYou, 10, "FOR YOY Button");

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
        isShowing &= checkTextContains(Headline, Headline1, "Live Blog Headline");
        return isShowing;
    }

    public boolean checkLiveBlogImagenCaption(WebElement leadImage, WebElement caption) {
        boolean isShowing = isElementDisplayed(leadImage, 10, "Lead Image");
        isShowing &= isElementDisplayed(caption, 10, "Lead Image Caption");
        return isShowing;
    }

    public boolean checkLiveBlogSocialIcons(List<WebElement> iconsList) {
        boolean isShowing = isElementDisplayedOfListOfElements(iconsList, "Bookmark & Social Icons");
        return isShowing;
    }

    public boolean checkLiveBlogPageTitle(WebElement liveBlogTitle, String Title) {
        boolean isShowing = getElementTextAndCheckWithEqualIgnoreCase(liveBlogTitle, Title, 20, "Live Blog Page Title");
        return isShowing;
    }

    public boolean navigateToPageThroughLhsNav(WebElement pagetoOpen, String pageName) {
        boolean topNavpageOpened = false;
        navigateToURL(globalVars.getURL());
        clickElementWithJS(pagetoOpen, 10, pageName + " link in Top Nav");
        checkTextContainByCurrentURL(pageName, pageName);

        return topNavpageOpened;
    }

    public boolean checkStory(WebElement FistStory, WebElement FirstStoryHeadline) {
        boolean isShowing = isElementDisplayed(FistStory, 10, "Page On First Story");
        String Headline = getElementText(FistStory);
        String Header = getElementText(FirstStoryHeadline);
        isShowing = checkTextContains(Header, Headline, "First Story verified list view");

        return isShowing;
    }

    public void backSpace(WebElement element) {
        element.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }

    public void selectAll(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void deleteAll(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CLEAR));
    }

    public void switchToLastWindow(Set<String> windowSet) {
        Iterator<String> it = windowSet.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
        }
    }


    public String createStoryForLiveBlog(String headline, String summary, String paragraph, String postTitle,
                                         String postBody, String section, String subsection, String byline,
                                         String keyword, String location,
                                         WebElement addPostTitleText, WebElement addPostBodyText, WebElement buttonAddPost,
                                         WebElement allChangesSaved, WebElement enterHeadlineText, WebElement addSummaryText,
                                         WebElement addParagraphText, WebElement inputAddSubSectionText, WebElement inputAddByLineText,
                                         WebElement inputAddLocationText, WebElement inputAddKeywordText,
                                         WebElement saveButton, WebElement toastSaveButton) {


        inputHeadline(headline, enterHeadlineText);
        inputSummary(summary, addSummaryText);
        inputParagraph(paragraph, addParagraphText);
        inputPost(postTitle, postBody, addPostTitleText, addPostBodyText, buttonAddPost, allChangesSaved);

        inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        inputByLine(byline, inputAddByLineText);
        inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        inputLocation(location, inputAddLocationText);
        saveStoryAndVerify(saveButton, toastSaveButton, allChangesSaved);
        return setStoryId();


    }

    public String getBackgroundColorOfWebElement(WebElement element, int timeOutInSecond, String elementName, String cssName) {
        String bgColor = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            bgColor = element.getCssValue(cssName);
            bgColor = Color.fromString(bgColor).asHex();
        } catch (Exception e) {
            System.out.println("Background color is not found for: " + elementName);
        }
        return bgColor;
    }

    public String getColorOfWebElement(WebElement element, int timeOutInSecond, String elementName, String cssName) {
        String color = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            color = element.getCssValue(cssName);
            color = Color.fromString(color).asHex();
            Utils.logStepInfo(color);
        } catch (Exception e) {
            Utils.logStepInfo("color is not found for: " + elementName);
        }
        return color;
    }

    public String getBorderColorOfWebElement(WebElement element, int timeOutInSecond, String elementName, String cssName) {
        String color = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            color = element.getCssValue(cssName);
            color = color.substring(10, 13) + "a" + color.substring(13, 26) + ", 1" + ")";
            color = Color.fromString(color).asHex();
        } catch (Exception e) {
            System.out.println("border color is not found for: " + elementName);
        }
        return color;
    }


    public boolean checkAndSelectTanentOption(WebElement element, int timeOutInSecond, String selectedValue, String elementName) {
        boolean flag = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(selectedValue);
            flag = true;
            Utils.logStepInfo(true, elementName + " is selected");
        } catch (Exception e) {
            flag = false;
            System.out.println(e.getMessage());
        }

        return flag;
    }

    public boolean checkElementEnableDisable(String status, WebElement element, int timeOut, String elementName) {
        boolean flag;
        WebDriverWait wait;
        if (status.equalsIgnoreCase("Enable")) {
            wait = new WebDriverWait(driver, timeOut);
            flag = wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
        } else {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            flag = !element.isEnabled();
        }

        return flag;
    }

    public void doubleClickWithWidth(WebElement element, int xWidth, int yWidth, int timeOut, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));

            Actions action = new Actions(driver);
            action.moveToElement(element, xWidth, yWidth).doubleClick().build().perform();
            Utils.logStepInfo(true, "Double click performed for: " + elementName);
        } catch (Exception e) {
            Utils.logStepInfo(false, "Double click does not performed for: " + elementName);
        }
    }

    public void tripleClickWithWidth(WebElement element, int xWidth, int yWidth, int timeOut, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));

            Actions action = new Actions(driver);
            action.moveToElement(element, xWidth, yWidth).doubleClick().click().build().perform();
            Utils.logStepInfo(true, "Single click performed for: " + elementName);
        } catch (Exception e) {
            Utils.logStepInfo(false, "Single click does not performed for: " + elementName);
        }
    }

    public String selectImageAndReturnImgSrc(WebElement elemnet, WebElement libElement, WebElement recUseElement, WebElement useElement, WebElement doneElement, WebElement yesButton, WebElement saveImageButton, WebElement imageEditDoneButton) {
        isElementDisplayed(elemnet, 10, "Image");
        clickElement(elemnet, 10, "Image");

        isElementDisplayed(libElement, 10, "Lib Image");
        clickElement(libElement, 10, "Lib Image");

        isElementPresentWithTryCatch(recUseElement, 20);
        String imgUrl = getAttributeValue(recUseElement, 10, "src");

        isElementDisplayed(recUseElement, 10, "Lib Image");
        mouseHoverOnElement(recUseElement, 10, "Lib Image");

        isElementDisplayed(useElement, 10, "Use Button");
        clickElement(useElement, 10, "Use Button");

        if (isElementDisplayed(yesButton, 10, "Yes Button")) {
            clickElement(yesButton, 10, "Yes Button");
        }

        isElementDisplayed(doneElement, 10, "Done Button");
        clickElement(doneElement, 10, "Done Button");

        scrollPageWithJS(imageEditDoneButton, 5);
        hardWait(2000);
        clickElementWithJS(imageEditDoneButton, 10, "first image done button");


        isElementDisplayed(saveImageButton, 10, "Save Button");
        clickElementWithJS(saveImageButton, 10, "Save Button");

        return imgUrl;
    }

    public void selectCrossTenantTabImage(WebElement elemnet, WebElement libElement, WebElement recUseElement, WebElement useElement, WebElement doneElement, WebElement yesButton, WebElement saveImageButton, WebElement crossTanentTab) {
        isElementDisplayed(elemnet, 10, "Image");
        clickElement(elemnet, 10, "Image");
        isElementDisplayed(libElement, 10, "Lib Image");
        clickElement(libElement, 10, "Lib Image");
        isElementDisplayed(crossTanentTab, 10, "Cross Tanent Tab");
        clickElement(crossTanentTab, 10, "Cross Tanent Tab");
        isElementDisplayed(recUseElement, 10, "Lib Image");
        mouseHoverOnElement(recUseElement, 10, "Lib Image");
        isElementDisplayed(useElement, 10, "Use Button");
        clickElement(useElement, 10, "Use Button");
        if (isElementDisplayed(yesButton, 10, "Yes Button")) {
            clickElement(yesButton, 10, "Yes Button");
        }
        isElementDisplayed(doneElement, 10, "Done Button");
        clickElement(doneElement, 10, "Done Button");
        isElementDisplayed(saveImageButton, 10, "Save Button");
        clickElementWithJS(saveImageButton, 10, "Save Button");
    }

    public void selectCrossTenantTabImageFromInlineElement(WebElement elemnet, WebElement libElement, WebElement recUseElement, WebElement useElement, WebElement doneElement, WebElement yesButton, WebElement saveImageButton, WebElement crossTanentTab) {
        isElementDisplayed(elemnet, 10, "Image");
        clickElement(elemnet, 10, "Image");
        isElementDisplayed(libElement, 10, "Lib Image");
        clickElement(libElement, 10, "Lib Image");
        isElementDisplayed(crossTanentTab, 10, "Cross Tanent Tab");
        clickElement(crossTanentTab, 10, "Cross Tanent Tab");
        isElementDisplayed(recUseElement, 10, "Lib Image");
        mouseHoverOnElement(recUseElement, 10, "Lib Image");
        isElementDisplayed(useElement, 10, "Use Button");
        clickElement(useElement, 10, "Use Button");
        if (isElementDisplayed(yesButton, 10, "Yes Button")) {
            clickElement(yesButton, 10, "Yes Button");
        }
        isElementDisplayed(doneElement, 10, "Done Button");
        clickElement(doneElement, 10, "Done Button");
        isElementDisplayed(saveImageButton, 10, "Save Button");
        clickElementWithJS(saveImageButton, 10, "Save Button");
    }

    public String getCurrentDate(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }

    public boolean compareTwoLists(List<String> firstList, List<String> SecoundList) {
        boolean flag = false;
        for (int i = 0; i < firstList.size(); i++) {
            flag = false;
            for (int j = 0; j < SecoundList.size(); j++) {
                if (firstList.get(i).trim().equals(SecoundList.get(j).trim())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return flag;
    }

    public String getParticularCssValue(WebElement element, int timeOutInSecond, String elementName, String cssName) {
        String cssValue = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            String computedStylePropertyScript = "return window.document.defaultView"
                    + ".getComputedStyle(arguments[0],null).getPropertyValue(arguments[1]);";
            cssValue = (String) ((JavascriptExecutor) driver).executeScript(computedStylePropertyScript, element, cssName);
            cssValue = Color.fromString(cssValue).asHex();
        } catch (Exception e) {
            Utils.logStepInfo("CSS Value is not found for: " + elementName);
        }
        return cssValue;
    }

    public boolean isFileDownloaded(String projectPath, String fullFileNameOrExtension) {
        boolean flag = false;
        File dir = new File(projectPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) flag = false;
        for (int i = 1; i < files.length; i++) if (files[i].getName().contains(fullFileNameOrExtension)) flag = true;
        return flag;
    }

    public void selectOptionFromDropDownWithIndex(WebElement element, int timeOutInSecond, int index, String elementName) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            Select dropDown = new Select(element);
            dropDown.selectByIndex(index);
            Utils.logStepInfo(true, elementName + " is selected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createStoryForLiveBlogWithoutHeadline(String summary, String paragraph, String postTitle,
                                                      String postBody, String section, String subsection, String byline,
                                                      String keyword, String location,
                                                      WebElement addPostTitleText, WebElement addPostBodyText, WebElement buttonAddPost,
                                                      WebElement allChangesSaved, WebElement addSummaryText,
                                                      WebElement addParagraphText, WebElement inputAddSubSectionText, WebElement inputAddByLineText,
                                                      WebElement inputAddLocationText, WebElement inputAddKeywordText,
                                                      WebElement saveButton, WebElement toastSaveButton) {


        inputSummary(summary, addSummaryText);
        inputParagraph(paragraph, addParagraphText);
        inputPost(postTitle, postBody, addPostTitleText, addPostBodyText, buttonAddPost, allChangesSaved);

        inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        inputByLine(byline, inputAddByLineText);
        inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        inputLocation(location, inputAddLocationText);
        saveStoryAndVerify(saveButton, toastSaveButton, allChangesSaved);
    }

    public String createStoryForLiveBlogWithoutSummary(String headline, String paragraph, String postTitle,
                                                       String postBody, String section, String subsection, String byline,
                                                       String keyword, String location,
                                                       WebElement addPostTitleText, WebElement addPostBodyText, WebElement buttonAddPost,
                                                       WebElement allChangesSaved, WebElement enterHeadlineText,
                                                       WebElement addParagraphText, WebElement inputAddSubSectionText, WebElement inputAddByLineText,
                                                       WebElement inputAddLocationText, WebElement inputAddKeywordText,
                                                       WebElement saveButton, WebElement toastSaveButton) {


        inputHeadline(headline, enterHeadlineText);
        inputParagraph(paragraph, addParagraphText);
        inputPost(postTitle, postBody, addPostTitleText, addPostBodyText, buttonAddPost, allChangesSaved);

        inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        inputByLine(byline, inputAddByLineText);
        inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        inputLocation(location, inputAddLocationText);
        saveStoryAndVerify(saveButton, toastSaveButton, allChangesSaved);
        return setStoryId();


    }

    public void hardWait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

    public String createStoryForLiveBlogWithoutPost(String headline, String summary, String paragraph, String postTitle,
                                                    String postBody, String section, String subsection, String byline,
                                                    String keyword, String location,
                                                    WebElement addPostTitleText, WebElement addPostBodyText, WebElement buttonAddPost,
                                                    WebElement allChangesSaved, WebElement enterHeadlineText, WebElement addSummaryText,
                                                    WebElement addParagraphText, WebElement inputAddSubSectionText, WebElement inputAddByLineText,
                                                    WebElement inputAddLocationText, WebElement inputAddKeywordText,
                                                    WebElement saveButton, WebElement toastSaveButton) {


        inputHeadline(headline, enterHeadlineText);
        inputSummary(summary, addSummaryText);
        inputParagraph(paragraph, addParagraphText);

        inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        inputByLine(byline, inputAddByLineText);
        inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        inputLocation(location, inputAddLocationText);
        saveStoryAndVerify(saveButton, toastSaveButton, allChangesSaved);
        return setStoryId();


    }

    public boolean checkElementsTextWithTryCatch(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
            isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        } catch (Exception e) {
        }
        if (isElementWithTextExist) {
            Utils.logStepInfo(true, elementName + " verified successfully");
        } else {
            Utils.logStepInfo(false, elementName + " verification failed");
        }

        return isElementWithTextExist;
    }

    public void sendKeyWithoutClear(WebElement element, String key) {
        element.sendKeys(key);
    }

    public boolean clickElementIfDisplay(WebElement element, int timeOutInSecond) {
        boolean isElementClicked = false;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isElementClicked = true;
        } catch (Exception e) {
            hardWait(5000);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isElementClicked = true;
        }
        return isElementClicked;
    }

    public boolean checkEleText(WebElement element, String expectedText, int timeOutInSecond, String elementName) {
        boolean isElementWithTextExist;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        try {
            isElementWithTextExist = wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        } catch (Exception e) {
            isElementWithTextExist = false;
        }

        return isElementWithTextExist;
    }

    public String getAttrValue(WebElement element, int timeOutInSecond, String attribute) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOutInSecond);
            wait.until(ExpectedConditions.visibilityOf(element));
            String value = element.getAttribute(attribute);
            if (value == null) {
                value = "";
            }
            Utils.logStepInfo(true, "Get Attribute from element successfully");
            Utils.logStepInfo(true, "Text found: " + value);
            return value;
        } catch (Exception e) {
            return "";
        }
    }

    public boolean matchWords(String firstString, String secoundString, String splitExp) {
        boolean flag = false;
        String[] ch = secoundString.split(splitExp);
        for (int i = 0; i < ch.length; i++) {
            if (firstString.trim().contains(ch[i].trim())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean matchTwoSet(HashSet<String> hSet1, HashSet<String> hSet2) {
        boolean flag = true;
        for (String element : hSet1) {
            // if second set has the current element
            if (hSet2.contains(element)) {
                flag &= true;
            } else {
                System.out.println(element + " :is not available in: " + hSet2);
                flag &= false;
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

    public boolean checkCurrentPageUrlEqualToExpectedUrl(String expectedUrl, String elementName) {
        boolean isShowing;
        if (isShowing = getCurrentURL().equals(expectedUrl)) {
            isShowing &= true;
            Utils.logStepInfo(true, elementName + " url displayed successfully");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, elementName + " url Not displayed as expected, (Actual:" + getCurrentURL() + " verification Failed");
        }
        return isShowing;
    }

}



