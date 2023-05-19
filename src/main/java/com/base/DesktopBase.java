package com.base;

import com.utils.Constants;
import com.utils.GlobalVars;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DesktopBase extends DriverController {
    static WebDriver driver;
    static GlobalVars globalVars;
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static String browser;
    static DesiredCapabilities capabilities;

    @Override
    public void initializeDriver() {
        System.out.println("*******************initializeDriver start*******************");
        globalVars=GlobalVars.getInstance();
        browser=globalVars.getBrowser();
        driver=globalVars.getWebDriver();
        if(driver ==null){
            if(globalVars.getIsBrowserStack()){
                initializeDriverWithBrowserStackCapabilities();
            }
            else {
                initializeWebDriver();
            }
        }
    }

    public static void initializeWebDriver(){
        System.out.println("*******************initializeWebDriver start*******************");
        DesiredCapabilities capabilities;
        try{
            switch (browser){
                case Constants.CHROME:
                    WebDriverManager.chromedriver().setup();
                    if(globalVars.getBrowserMode().equalsIgnoreCase("private")){
                        capabilities = DesiredCapabilities.chrome();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--incognito");
                        //options.addArguments("--headless");
                        //options.setHeadless(true);
                        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                        driver = new ChromeDriver(options);
                    }else {
                        String downloadFilepath = System.getProperty("user.dir");
                        HashMap<String, Object> chromePrefs = new HashMap<>();
                        chromePrefs.put("profile.default_content_settings.popups", 0);
                        chromePrefs.put("download.default_directory", downloadFilepath);
                        capabilities = DesiredCapabilities.chrome();
                        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                        ChromeOptions options = new ChromeOptions();
                        //options.addArguments("--headless");
                        //options.setHeadless(true);
                        //options.addArguments("--window-size=1920x1080");
                        options.setExperimentalOption("prefs", chromePrefs);
                        options.merge(capabilities);
                        driver = new ChromeDriver(options);
                    }
                    break;
                case Constants.FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions=new FirefoxOptions();
                    firefoxOptions.setHeadless(false);
                    if(globalVars.getBrowserMode().equalsIgnoreCase("private")){
                        firefoxOptions.addArguments("-private-window");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case Constants.OPERA:
                    WebDriverManager.operadriver().setup();
                    if(globalVars.getBrowserMode().equalsIgnoreCase("private")) {
                        capabilities = DesiredCapabilities.operaBlink();
                        OperaOptions options = new OperaOptions();
                        options.addArguments("private");
                        capabilities.setCapability(OperaOptions.CAPABILITY, options);
                        driver = new OperaDriver(capabilities);
                    }
                    else {
                        driver = new OperaDriver();
                    }
                    break;
                case Constants.IE:
                    WebDriverManager.iedriver().setup();
                    capabilities = DesiredCapabilities.internetExplorer();
                    if(globalVars.getBrowserMode().equalsIgnoreCase("private")) {
                        capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                        capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                        driver = new InternetExplorerDriver(capabilities);
                    }
                    else {
                        driver = new InternetExplorerDriver();
                    }
                    break;
                default:
                    System.out.println("Invalid browser name !!!!!!");
            }

            driver.manage().window().maximize();

            globalVars.setWebDriver(driver);
            navigateToHomePageUrl();
            System.out.println("*******************initializeWebDriver ends*******************");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void navigateToHomePageUrl(){
        driver.get(globalVars.getURL());
        System.out.println("******* Navigated to URL: "+globalVars.getURL());
        System.out.println("*******************navigateToUrl ends*******************");
    }

    private static boolean isWindows() {
        return (OS.contains("win"));
    }

    private static boolean isMac() {
        return (OS.contains("mac"));
    }

    private static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    @Override
    public void closeDriver(){
        driver=globalVars.getWebDriver();
        if(driver !=null) {
            try {
                driver.quit();
            } catch (Exception exception) {
                System.out.println("******** Exception in closeDriver() method! *****");
                System.out.println(exception.getMessage());
            }
            driver=null;
            globalVars.setWebDriver(null);
        }
    }

    public void initializeDriverWithBrowserStackCapabilities() {
        try{

            JSONParser parser = new JSONParser();
            String jsonConfig="src/main/resources/Capabilities/"+globalVars.getProjectName()+"/"+globalVars.getCapabilitiesJsonName()+".conf.json";
            JSONObject config = (JSONObject) parser.parse(new FileReader(jsonConfig));

            capabilities = new DesiredCapabilities();

            Map<String, Object> commonCapabilities = (Map<String, Object>) config.get("capabilities");
            if (globalVars.getIsBrowserStackLocal()){
                commonCapabilities.put("browserstack.local", globalVars.getIsBrowserStackLocal());
            }
            for (Map.Entry<String, Object> pair : commonCapabilities.entrySet()) {
                if (capabilities.getCapability(pair.getKey()) == null) {
                    if (pair.getKey().equalsIgnoreCase("name")) {
                        capabilities.setCapability(pair.getKey(), pair.getValue() + "_" + globalVars.getBuildNumber());
                    } else {
                        capabilities.setCapability(pair.getKey(), pair.getValue());
                    }
                }
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-plugins");
            options.addArguments("--disable-notifications");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            //capabilities.setCapability(Constants.NEW_COMMAND_TIMEOUT, 70000);


            String username = System.getenv("BROWSERSTACK_USERNAME");
            if(username == null) {
                username = (String) config.get("username");
            }

            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
            if(accessKey == null) {
                accessKey = (String) config.get("access_key");
            }

            driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
            System.out.println("Initialized driver successfully");
            driver.manage().window().maximize();
            globalVars.setWebDriver(driver);
            navigateToHomePageUrl();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void navigateToApplicationHomePage(boolean deleteCookieFlag) {
        driver=globalVars.getWebDriver();
        if(globalVars.getProjectName().equalsIgnoreCase(Constants.SSO)){
            if(deleteCookieFlag) driver.manage().deleteAllCookies();
            driver.get(globalVars.getURLMapSSO().get(globalVars.getApplicationName()));
        }
        else {
            navigateToHomePageUrl();
        }
    }
}
