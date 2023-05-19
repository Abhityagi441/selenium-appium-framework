package com.utils;

import com.annotation.Author;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reporter.ExtentManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

public class Utils {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static GlobalVars globalVars;
    private static final String OS = System.getProperty("os.name").toLowerCase();

    /*This function will initialize the ExtentReport object*/
    public static void initializeExtentReport() {
        globalVars = GlobalVars.getInstance();
        extentReports = ExtentManager.getReporter();
    }

    /*This function will initialize the ExtentTest object*/
    public static void initializeExtentTest(String methodName) {
        initializeExtentReport();
        globalVars = GlobalVars.getInstance();
        extentTest = extentReports.createTest(methodName + " | " + globalVars.getProjectName(), globalVars.getProjectName());
    }

    public static void renameExtentTest(String methodName) {
        extentTest.getModel().setName(methodName + " | " + globalVars.getProjectName());
    }

    /*
     * This function will be called after every test method
     */
    public static void closeExtentTest() {
        extentTest.getExtent().flush();
    }

    /*This function will log each step of a test case*/
    public static void logStepInfo(String message) {
        extentTest.log(Status.PASS, message);
        Reporter.log(message);
    }

    public static void logFailedStepThrowableAndAddScreenshot(Throwable throwable, ITestResult iTestResult) {
        extentTest.fail(throwable);
        extentTest.log(Status.FAIL, throwable.getMessage() + extentTest.addScreenCaptureFromBase64String(takeScreenShot(iTestResult.getName()), "error"));

    }

    public static void setAuthorInExtentReport(ITestResult iTestResult) {
        String testCaseAuthor = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Author.class).name();
        extentTest.assignAuthor(testCaseAuthor);
    }


    public static String formatHexValue(String color) {
        try {
            String formatColor = color.substring(color.indexOf("(") + 1, color.indexOf(")")).replaceAll(" ", "");
            String[] rgb = formatColor.split(",");
            return String.format("#%s%s%s", getHexValue(Integer.parseInt(rgb[0])), getHexValue(Integer.parseInt(rgb[1])), getHexValue(Integer.parseInt(rgb[2])));
        } catch (Exception e) {
            System.out.println("got exception in formatHexValue for color: " + color);
            return null;
        }
    }

    private static String getHexValue(int number) {
        try {
            StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
            while (builder.length() < 2) {
                builder.append("0");
            }
            return builder.toString();
        } catch (Exception e) {
            System.out.println("got exception in getHexValue for number: " + number);
            return null;
        }
    }

    /*Function to log the steps info in extent report*/
    public static void logStepInfo(boolean isResult, String stepInfo) {

        System.out.println("-" + stepInfo);
        if (isResult) {
            extentTest.log(Status.PASS, "-" + stepInfo);
        } else {
            extentTest.log(Status.FAIL, "-" + stepInfo);
            // extentTest.log(Status.FAIL, extentTest.addScreenCaptureFromBase64String(takeScreenShot()));
            //extentTest.log(Status.FAIL, extentTest.addScreenCaptureFromBase64String(takeScreenShot()));
        }
    }

    /*Function to log the action method steps info in extent report*/
    public static void logActionMethodsInfo(String stepInfo) {
        extentTest.log(Status.INFO, stepInfo);
    }

    /*Function to log the action method steps info in extent report*/
//    public static void logActionMethodsInfo(String stepInfo)
//    {
//        String[] messages=stepInfo.split(",,");
//        for(String message: messages) {
//            extentTest.log(Status.INFO, "-"+message);
//        }
//    }

    public static String takeScreenShot(String testName) {
        String platformName = globalVars.getPlatformName();
        TakesScreenshot takesScreenshot;
        String dest;
        String base64 = "";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
        Date date = new Date();

        if (platformName.contains(Constants.ANDROID) || platformName.contains(Constants.IOS)) {
            takesScreenshot = globalVars.getAppiumDriver();
        } else {
            takesScreenshot = (TakesScreenshot) globalVars.getWebDriver();
        }

        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        dest = System.getProperty("user.dir") + "/src/main/resources/screenshots/screenshot_" + testName + dateFormat.format(date)
                + ".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);

            InputStream inputStream = Files.newInputStream(Paths.get(dest));
            byte[] imageBytes = IOUtils.toByteArray(inputStream);
            base64 = Base64.getEncoder().encodeToString(imageBytes);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return base64;
    }

    public static String getOSName() {
        if (isWindows()) {
            return "Windows";
        } else if (isUnix()) {
            return "Unix";
        } else if (isMac()) {
            return "MAC";
        }

        return "";
    }

    private static boolean isWindows() {

        return (OS.contains("win"));

    }

    private static boolean isMac() {

        return (OS.contains("mac"));

    }

    private static boolean isUnix() {

        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);

    }

    public static String formatAPIText(String text) {
        try {

            if (text.contains("target=\"_blank\" ")) {
                text = text.replaceAll("target=\"_blank\" ", "");

            }
            //
            if (text.contains("<a href=")) {
                int beginIndexForFullText = text.lastIndexOf("<a href=");
                int endIndexForFullText = text.lastIndexOf("</a>") + 4;
                String subtextFull = text.substring(beginIndexForFullText, endIndexForFullText);

                int beginIndexForPartialText = text.lastIndexOf("\">") + 2;
                int endIndexForPartialText = text.lastIndexOf("</a>");
                String subtextPartial = text.substring(beginIndexForPartialText, endIndexForPartialText);

                text = text.replaceAll(subtextFull, subtextPartial);
            }
            if (text.contains("<em>")) {

                int beginIndexForFullText = text.lastIndexOf("<em>");
                int endIndexForFullText = text.lastIndexOf("</em>") + 5;
                String subtextFull = text.substring(beginIndexForFullText, endIndexForFullText);

                int beginIndexForPartialText = text.lastIndexOf("<em>") + 4;
                int endIndexForPartialText = text.lastIndexOf("</em>");
                String subtextPartial = text.substring(beginIndexForPartialText, endIndexForPartialText);

                text = text.replaceAll(subtextFull, subtextPartial);
            }
            text = text.replaceAll(" <span class='webrupee'>₹</span>", "₹");
            text = text.replaceAll(" <span class=\"webrupee\">₹</span>", "₹");
            text = text.replaceAll("<ul><li>", "");
            text = text.replaceAll("</li></ul>", "");
            text = text.replaceAll("</li><li>", "");
            text = text.replaceAll("amp;", "");
            text = text.replaceAll("<p>", "");
            text = text.replaceAll("</p>", "").trim();
            text = text.replaceAll("”", "\"");
            text = text.replaceAll("<i>", "");
            text = text.replaceAll("</i>", "");
            text = text.replaceAll("&nbsp;", " ");
            text = text.replaceAll("<strong>", "");
            text = text.replaceAll("</strong>", "");
            text = text.replaceAll(" ", " ");
            text = text.replaceAll("body=<p>", "");
            text = text.replaceAll("</p><p>}", "");
            text = text.replaceAll("</p><p>", "");
            text = text.replaceAll("\n\n", "");
            text = text.replaceAll("&gt;", ">");
            text = text.replaceAll("<br>", "");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void markTestResultOnBrowserStack(String message, boolean failTestExists) {
        JavascriptExecutor jse;
        if (globalVars.getPlatformName().equalsIgnoreCase(Constants.DESKTOP_WEB)) {
            jse = (JavascriptExecutor) globalVars.getWebDriver();
        } else {
            jse = globalVars.getAppiumDriver();
        }
        message = message.replaceAll("'", "");

        if (jse != null) {
            try {
                if (failTestExists) {
                    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"" + message + "\"}}");

                } else {
                    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"All test cases passed!!!\"}}");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            System.out.println("Unable to mark Test result on Browserstack as driver instance not found!!!");
    }

    /**
     * @param params :
     * @return HashMap<String, String>
     * Description This function takes a String having parameters as required in a particular test case, split it on || basis and store
     * it in a map and return the map having key value pair of params
     * @author Ataur
     */
    public static HashMap<String, String> getParamsMap(String params) {
        HashMap<String, String> paramsMap = new HashMap<>();
        try {
            if (!params.equalsIgnoreCase(Constants.NA) && !params.isEmpty()) {
                String[] paramsArray = params.split("\\|\\|");
                for (String param : paramsArray) {
                    if (param.contains("::")) {
                        paramsMap.put(param.split("::")[0].trim(), param.split("::")[1].trim());
                    } else {
                        System.out.println("****** param key value separator : missing !!! *********");
                        System.out.println("****** param key-value: " + param);
                    }
                }
            } else {
                System.out.println("******** either params data is empty or N/A !!! *********");
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("***** No params data found ******");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paramsMap;
    }

    public static boolean getSSORunFlag() {
        String callingClass = null;
        globalVars = GlobalVars.getInstance();
        try {
            callingClass = new Throwable().getStackTrace()[2].getClassName();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (callingClass != null) {
            return !callingClass.contains("BaseTest") || !globalVars.getProjectName().equalsIgnoreCase(Constants.SSO);

        }

        return true;
    }

    public static String getUrl() {
        String urlVariable;
        String URLToNavigate;
        if (globalVars.getProjectName().equalsIgnoreCase("SSO")) {
            URLToNavigate = globalVars.getURLMapSSO().get(globalVars.getApplicationName());
            System.out.println("******* SSO Current Environment URL :- " + URLToNavigate);
        } else {
            urlVariable = globalVars.getEnvironment() + "Url";
            URLToNavigate = globalVars.getProp().getProperty(urlVariable);
            System.out.println("******* Current Environment URL :- " + URLToNavigate);
        }
        return URLToNavigate;
    }

    public static void lamdaTestStatus(String lamdaTestStatus) {
        RemoteWebDriver driver;
        if (globalVars.getPlatformName().equalsIgnoreCase(Constants.DESKTOP_WEB)) {
            driver = (RemoteWebDriver) globalVars.getWebDriver();
        } else {
            driver = globalVars.getAppiumDriver();
        }
        driver.executeScript("lambda-status=" + lamdaTestStatus);
    }

    public static void testInfo(String testMethodName) {
        logStepInfo(true, "*********** " + testMethodName + " started ***********");
    }

}
