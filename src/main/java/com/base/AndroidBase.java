package com.base;

import com.google.common.collect.ImmutableMap;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AndroidBase extends DriverController {
    static String driverUrl;
    static DesiredCapabilities capabilities;
    static GlobalVars globalVars;
    static AppiumDriver driver;

    @Override
    public void initializeDriver() {
        globalVars=GlobalVars.getInstance();
        capabilities=new DesiredCapabilities();
        driverUrl="http://"+globalVars.getAppiumServerIp()+":"+globalVars.getAppiumServerPort()+"/wd/hub";
        driver=globalVars.getAppiumDriver();
        if(driver==null){
            if(globalVars.getIsBrowserStack())
                initializeDriverWithBrowserStackCapabilities();
            else
                initializeDriverWithCapabilities();
        }
    }


    public void initializeDriverWithBrowserStackCapabilities() {
        try{


            JSONParser parser = new JSONParser();
            String jsonConfig;
            if(globalVars.getProjectName().equalsIgnoreCase(Constants.SSO)) {
                jsonConfig = "src/main/resources/Capabilities/" + globalVars.getProjectName() + "/" + globalVars.getCapabilitiesJsonName() + ".conf.json";
            }
            else{
                jsonConfig = "src/main/resources/Capabilities/" + globalVars.getProjectName() + "/" + globalVars.getCapabilitiesJsonName() + ".conf.json";
            }
            JSONObject config = (JSONObject) parser.parse(new FileReader(jsonConfig));

            capabilities = new DesiredCapabilities();

            JSONArray envs = (JSONArray) config.get("environments");
            Map<String, String> envCapabilities = (Map<String, String>) envs.get(0);
            Iterator it = envCapabilities.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }

            Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
            if (globalVars.getIsBrowserStackLocal()){
                commonCapabilities.put("browserstack.local", String.valueOf(globalVars.getIsBrowserStackLocal()));
            }
            it = commonCapabilities.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(capabilities.getCapability(pair.getKey().toString()) == null){

                    if(pair.getKey().toString().equalsIgnoreCase("name")){
                        //******* To append build number in the session name on browserstack
                        capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString()+"_"+globalVars.getBuildNumber());
                    }
                    else {
                        capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
                    }
                    //capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
                }
            }

            disableChromeNotification();

            String username = System.getenv("BROWSERSTACK_USERNAME");
            if(username == null) {
                username = (String) config.get("username");
            }

            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
            if(accessKey == null) {
                accessKey = (String) config.get("access_key");
            }


            globalVars.setAppiumDriver(driver = new AndroidDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities));
            driver = globalVars.getAppiumDriver();

            //****** Extra step to navigate to URL in case of android web ********
            if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_WEB)){
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PROD)){
                    driver.get(globalVars.getURL());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.STG)){
                    driver.get(globalVars.getStgUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.QA)){
                    driver.get(globalVars.getQAUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PRE_PROD_URL)){
                    driver.get(globalVars.getQAUrl());}

            }
            else if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_AMP)){
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PROD)){
                    driver.get(globalVars.getURL());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.STG)){
                    driver.get(globalVars.getStgUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.STG_AMP_URL)){
                    driver.get(globalVars.getStgAMPUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.QA)){
                    driver.get(globalVars.getAMPQAUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PRE_PROD_AMP_URL)){
                    driver.get(globalVars.getAMPQAUrl());}

            }

//            driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void initializeDriverWithCapabilities() {
        try{
            capabilities.setCapability(Constants.DEVICE_NAME, globalVars.getDeviceNameAndroid());
            capabilities.setCapability(Constants.PLATFORM_VERSION, globalVars.getPlatformVersionAndroid());

            capabilities.setCapability(Constants.PLATFORM_NAME, Constants.ANDROID);

            capabilities.setCapability(Constants.NEW_COMMAND_TIMEOUT, 50000);
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, globalVars.getBrowser());
            capabilities.setCapability(Constants.NO_RESET, Constants.TRUE);

            System.setProperty(Constants.WEB_DRIVER_CHROME, globalVars.getWebDriverPath()+"chromedriver_mobile");

            disableChromeNotification();

            if(!globalVars.getPlatformName().contains(Constants.WEB)) {
                capabilities.setCapability(Constants.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability(Constants.LOCATION_SERVICES_AUTHORIZED, Constants.TRUE);
                capabilities.setCapability(Constants.AUTO_GRANT_PERMISSIONS, Constants.TRUE);
                //capabilities.setCapability(Constants.APP_PACKAGE, globalVars.getAppPackage());
                //capabilities.setCapability(Constants.APP_ACTIVITY, globalVars.getAppActivity());

                capabilities.setCapability(MobileCapabilityType.APP, globalVars.getAndroidAPKFileName());

                capabilities.setCapability("adbExecTimeout", 55000);
                capabilities.setCapability("autoDismissAlerts", true);

                //capabilities.setCapability(Constants.APP_WAIT_PACKAGE, globalVars.getAppWaitPackage());
            }

            if(driver == null){
                globalVars.setAppiumDriver(driver=new AndroidDriver(new URL(driverUrl), capabilities));
                driver=globalVars.getAppiumDriver();

                //****** Extra step to navigate to URL in case of android web ********
                if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_WEB)){
                    navigateToHomePageUrl();
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
        }
    }


    @Override
    public void closeDriver(){
        System.out.println("Inside Android close driver");
        if(driver!=null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("******** Exception in closeDriver() method! *****");
                System.out.println(e.getMessage());
            }
            driver=null;
            globalVars.setAppiumDriver(null);
        }

    }

    public void disableChromeNotification(){

        if(globalVars.getPlatformName().contains(Constants.WEB)) {

            if (globalVars.getBrowser().equalsIgnoreCase(Constants.CHROME)) {
                capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                //options.addArguments("--disable-experimental-accessibility-chromevox-search-menus");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            }
        }
    }

    public static void navigateToHomePageUrl(){
        String urlVariable=globalVars.getEnvironment()+"Url";
        String URLToNavigate=globalVars.getProp().getProperty(urlVariable);
        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_AMP)){
            URLToNavigate=URLToNavigate+"/amp";
        }

        driver.get(URLToNavigate);
        System.out.println("******* Navigated to URL: "+URLToNavigate);
    }

    @Override
    public void navigateToApplicationHomePage(boolean deleteCookieFlag) {
        driver=globalVars.getAppiumDriver();
        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_WEB) || globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_AMP)){
            //if((!globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE))||(!globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE))) {
            if (globalVars.getProjectName().equalsIgnoreCase(Constants.SSO)) {
                if (deleteCookieFlag) driver.manage().deleteAllCookies();
                driver.get(globalVars.getURLMapSSO().get(globalVars.getApplicationName()));
            }else {
                navigateToHomePageUrl();
            }
        }else{
            closeDriver();
            initializeDriver();
        }

    }

}
