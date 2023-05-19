package com.utils;

import com.browserstack.local.Local;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BrowserStackLocal {
    public static Local bsLocal;
    static GlobalVars globalVars;
    static DesiredCapabilities capabilities;
    static DesiredCapabilities caps;

    public static void bsLocalStart() {
        /*     try {
            globalVars = GlobalVars.getInstance();
            JSONParser parser = new JSONParser();
            String jsonConfig="src/main/resources/Capabilities/"+globalVars.getProjectName()+"/"+globalVars.getCapabilitiesJsonName()+".conf.json";
            System.out.println("Capability file path is --- "+jsonConfig);
            JSONObject config = (JSONObject) parser.parse(new FileReader(jsonConfig));
            String accessKey = null;
            if(accessKey == null) {
                accessKey = (String) config.get("access_key");
            }

            String UserName = null;
            if(UserName == null) {
                UserName = (String) config.get("username");
            }

            *//*DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserstack.local", bsLocalCapability);
            System.out.println("User Name of Browser Stack Local ---- "+UserName);
        bsLocal = new Local();
        HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
        bsLocalArgs.put("key", accessKey);
        bsLocalArgs.put("force", "true");
        bsLocalArgs.put("forcelocal", "true");
        *//*bsLocalArgs.put("localProxyHost", "127.0.0.1");
        bsLocalArgs.put("localProxyPort", "8000");
        bsLocalArgs.put("-localProxyUser", UserName);
        bsLocalArgs.put("-localProxyPass", accessKey);*//*
        bsLocal.start(bsLocalArgs);
        System.out.println("Browser Stack Local Running Status --- " +bsLocal.isRunning());
        } catch (org.openqa.selenium.SessionNotCreatedException e) {
            System.out.println("isBrowserStachLocal is set as true but VPN is not connected " +e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File Not Found - "+e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public static void bsLocalStop(){
        try {
            bsLocal.stop();
            System.out.println("****** Broswer Stack Local Stopped ******");
        }
        catch(NullPointerException nullPointerException){
            Utils.logStepInfo(true,"Please correct isBrowserStackLocal Flag in TestNG file");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean BrowserStackLocalStatus(){
        boolean isBSLocalStatus = false;
        try {
            isBSLocalStatus = bsLocal.isRunning();
            if(isBSLocalStatus) {
                System.out.println("***** Browser Stack Local is Running Mode *****");
            }
            else{
                System.out.println("***** Browser Stack Local is not Running Mode *****");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isBSLocalStatus;
    }
}
