package com.base;

import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class IOSBase extends DriverController {
    static DesiredCapabilities capabilities;
    static String driverUrl;
    static GlobalVars globalVars;
    static AppiumDriver driver;
    static String platformName;

    @Override
    public void initializeDriver() {
        globalVars=GlobalVars.getInstance();
        platformName=globalVars.getPlatformName();
        driverUrl="http://"+globalVars.getAppiumServerIp()+":"+globalVars.getAppiumServerPort()+"/wd/hub";
        capabilities=new DesiredCapabilities();
        driver=globalVars.getAppiumDriver();
        if(driver==null){

            if(globalVars.getIsBrowserStack()) {
                initializeDriverWithBrowserStackCapabilities();
            }
            else {
                if(platformName.equalsIgnoreCase(Constants.IOS_WEB) || platformName.equalsIgnoreCase(Constants.IOS_AMP)){
                    initializeIOSWebDriverWithCapabilities();
                }
                else if (platformName.equalsIgnoreCase(Constants.IOS_NATIVE)){
                    initializeIOSNativeDriverWithCapabilities();
                }
            }

        }

        else {
            if(globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_WEB)){

                driver.get(globalVars.getURL());
            }

        }

    }


    public void initializeDriverWithBrowserStackCapabilities() {
        try{

            JSONParser parser = new JSONParser();
            String jsonConfig;//="src/main/resources/Capabilities/"+globalVars.getProjectName()+"/"+globalVars.getCapabilitiesJsonName()+".conf.json";
            if(globalVars.getApplicationName()!=null && globalVars.getProjectName().equalsIgnoreCase(Constants.SSO)) {
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
                }
            }


            String username = System.getenv("BROWSERSTACK_USERNAME");
            if(username == null) {
                username = (String) config.get("username");
            }

            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
            if(accessKey == null) {
                accessKey = (String) config.get("access_key");
            }


            capabilities.setCapability("nativeWebTap", true);


            globalVars.setAppiumDriver(driver = new IOSDriver<IOSElement>(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities));
            driver = globalVars.getAppiumDriver();

            //****** Extra step to navigate to URL in case of android web ********
            if(globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_WEB)){
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PROD)){
                    driver.get(globalVars.getURL());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.STG)){
                    driver.get(globalVars.getStgUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.QA)){
                    driver.get(globalVars.getQAUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PRE_PROD_URL)){
                    driver.get(globalVars.getQAUrl());}

            }
            else if(globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_AMP)){
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PROD)){
                    driver.get(globalVars.getURL());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.STG)){
                    driver.get(globalVars.getStgUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.QA)){
                    driver.get(globalVars.getAMPQAUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.PRE_PROD_AMP_URL)){
                    driver.get(globalVars.getAMPQAUrl());}
                if(globalVars.getEnvironment().equalsIgnoreCase(Constants.STG_AMP_URL)){
                    driver.get(globalVars.getStgAMPUrl());}

            }


//            driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void initializeIOSNativeDriverWithCapabilities() {
        try
        {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, globalVars.getDeviceNameIOS());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, globalVars.getPlatformVersionIOS());
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(MobileCapabilityType.UDID, globalVars.getUdid());
            capabilities.setCapability(Constants.BUNDLE_ID, globalVars.getUpdateWDABundleId());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Constants.IOS.toUpperCase());
            capabilities.setCapability(MobileCapabilityType.APP, "/Users/Rohini/Documents/iOS app/Hindustan Times.app");
            if(driver==null){
                globalVars.setAppiumDriver(new IOSDriver<>(new URL(driverUrl), capabilities));
                driver = globalVars.getAppiumDriver();
                driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void initializeIOSWebDriverWithCapabilities() {
        try
        {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, globalVars.getDeviceNameIOS());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, globalVars.getPlatformVersionIOS());
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            //capabilities.setCapability(MobileCapabilityType.UDID, globalVars.getUdid());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Constants.IOS.toUpperCase());
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, globalVars.getBrowser());
            if(driver==null){
                globalVars.setAppiumDriver(new IOSDriver<>(new URL(driverUrl), capabilities));
                driver = globalVars.getAppiumDriver();
                navigateToHomePageUrl();
                driver.manage().timeouts().implicitlyWait(globalVars.getImplicitWait(), TimeUnit.SECONDS);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private static void navigateToHomePageUrl(){

        String URLToNavigate=globalVars.getURL();
        if(platformName.equalsIgnoreCase(Constants.IOS_AMP)){
            if(!URLToNavigate.contains("/amp")) {
                URLToNavigate = URLToNavigate + "/amp";
            }
        }

        driver.get(URLToNavigate);
        System.out.println("******* Navigated to URL: "+URLToNavigate);

    }
    @Override
    public void closeDriver(){
        System.out.println("Inside IOS close driver");
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

    @Override
    public void navigateToApplicationHomePage(boolean deleteCookieFlag) {
        driver=globalVars.getAppiumDriver();
        //if((!globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE))||(!globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE))) {
        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_WEB) || globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_AMP)) {
            if (globalVars.getProjectName().equalsIgnoreCase(Constants.SSO)) {
                if (deleteCookieFlag) driver.manage().deleteAllCookies();
                driver.get(globalVars.getURLMapSSO().get(globalVars.getApplicationName()));
                System.out.println("Navigating to URl - " + globalVars.getURLMapSSO().get(globalVars.getApplicationName()));
            } else {
                navigateToHomePageUrl();
            }
        }
        else{
            closeDriver();
            initializeDriver();
        }
    }

}
