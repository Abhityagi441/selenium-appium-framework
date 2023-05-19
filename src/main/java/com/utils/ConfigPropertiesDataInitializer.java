package com.utils;

import com.base.DriverController;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigPropertiesDataInitializer {
    private static GlobalVars globalVars;
    static InputStream input = null;
    private static Properties prop;
    private static ConfigPropertiesDataInitializer configPropertiesDataInitializer;

    public static ConfigPropertiesDataInitializer getInstance(){
        if(configPropertiesDataInitializer==null){
            configPropertiesDataInitializer=new ConfigPropertiesDataInitializer();
            globalVars=GlobalVars.getInstance();
        }
        return configPropertiesDataInitializer;
    }

    public void initializeConfigPropertiesVariables(){
        try {
            String projectName=globalVars.getProjectName();
            globalVars.setProp(new Properties());
            prop=globalVars.getProp();
            globalVars.setWorkingDir(System.getProperty("user.dir"));
            input = DriverController.class.getClassLoader().getResourceAsStream(projectName+"_config.properties");
            prop.load(input);
            initializeConfigPropertiesData();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeConfigPropertiesData(){

        boolean isPlatformAndroidNative=globalVars.getPlatformName().contains(Constants.ANDROID);
        boolean isPlatformIOSNative=globalVars.getPlatformName().contains(Constants.IOS);

        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_AMP)||globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_AMP)){
            globalVars.setURL(prop.getProperty(globalVars.getEnvironment()+Constants.URL)+"amp");

        }
        else{
            globalVars.setURL(prop.getProperty(globalVars.getEnvironment()+Constants.URL));

        }
         globalVars.setUatUrl(prop.getProperty(Constants.UAT_URL));
        globalVars.setStgUrl(prop.getProperty(Constants.STG_URL));
        globalVars.setQAUrl(prop.getProperty(Constants.QA_URL));
        globalVars.setAMPQAUrl(prop.getProperty(Constants.QA_AMP_URL));
        globalVars.setPreProdAMPUrl(prop.getProperty(Constants.PRE_PROD_AMP_URL));
        globalVars.setStgAMPUrl(prop.getProperty(Constants.STG_AMP_URL));
        globalVars.setPreProdUrl(prop.getProperty(Constants.PRE_PROD_URL));
        globalVars.setProdUrl(prop.getProperty(Constants.PROD_URL));
        globalVars.setUrlLiveBlog(prop.getProperty(Constants.URL_LIVEBLOG));
        globalVars.setAmpUrl(prop.getProperty(Constants.AMP_URL));
        globalVars.setAmpUrl(prop.getProperty(Constants.AMP_URL));
        globalVars.setAutUrl(prop.getProperty(Constants.AUT_URL));
        globalVars.setIsAutoStartAppium(Boolean.parseBoolean(prop.getProperty(Constants.IS_AUTO_START_APPIUM)));
        globalVars.setJiraUrl(prop.getProperty(Constants.JIRA_URL));
        globalVars.setJiraUserName(prop.getProperty(Constants.JIRA_USERNAME));
        globalVars.setJiraPassword(prop.getProperty(Constants.JIRA_PASSWORD));
        globalVars.setJiraDefectAssignee(prop.getProperty(Constants.JIRA_DEFECT_ASSIGNEE));
        globalVars.setMaxRetry(Integer.parseInt(prop.getProperty(Constants.MAX_RETRY)));
        globalVars.setImplicitWait(Integer.parseInt(prop.getProperty(Constants.IMPLICIT_WAIT)));
        globalVars.setJiraProjectName(prop.getProperty(Constants.JIRA_PROJECT_NAME));
        globalVars.setJiraDefectType(prop.getProperty(Constants.JIRA_DEFECT_TYPE));
        globalVars.setAppiumServerIp(prop.getProperty(Constants.APPIUM_SERVER_IP));
        globalVars.setAppiumServerPort(prop.getProperty(Constants.APPIUM_SERVER_PORT));
        globalVars.setSpreadsheetId(prop.getProperty(Constants.SPREADSHEET_ID));

        if(isPlatformAndroidNative){
            initializeAndroidSpecificConfigData();
        }
        else if(isPlatformIOSNative){
            initializeIOSSpecificConfigData();
        }
        if(globalVars.getProjectName().equalsIgnoreCase(Constants.SSO)){
            initializeSSOSpecificURLConfig();
        }
    }


    private void initializeAndroidSpecificConfigData(){
        globalVars.setAndroidAPKFileName(prop.getProperty(Constants.ANDROID_APK_FILE_NAME));
        globalVars.setAppPackage(prop.getProperty(Constants.APP_PACKAGE));
        globalVars.setAppActivity(prop.getProperty(Constants.APP_ACTIVITY));
        globalVars.setAppWaitPackage(prop.getProperty(Constants.APP_WAIT_PACKAGE));
        globalVars.setDeviceNameAndroid(prop.getProperty(Constants.DEVICE_NAME_ANDROID));
        globalVars.setPlatformVersionAndroid(prop.getProperty(Constants.PLATFORM_VERSION_ANDROID));
    }

    private void initializeIOSSpecificConfigData(){
        globalVars.setJiraDefectType(prop.getProperty(Constants.IPA_FILE_NAME));
        globalVars.setJiraDefectType(prop.getProperty(Constants.UDID));
        globalVars.setJiraDefectType(prop.getProperty(Constants.XCODE_ORG_ID));
        globalVars.setJiraDefectType(prop.getProperty(Constants.UPDATE_WDA_BUNDLE_ID));
        globalVars.setJiraDefectType(prop.getProperty(Constants.XCODE_SIGNING_ID));
        globalVars.setDeviceNameIOS(prop.getProperty(Constants.DEVICE_NAME_IOS));
        globalVars.setPlatformVersionIOS(prop.getProperty(Constants.PLATFORM_VERSION_IOS));
    }

    private void initializeSSOSpecificURLConfig(){
        Map<String, String> urlMap=new HashMap<>();
        String envSuffix=globalVars.getEnvironment().substring(0,1).toUpperCase()+globalVars.getEnvironment().substring(1)+"Url";

        urlMap.put(Constants.HINDUSTAN_TIMES, prop.getProperty(Constants.HINDUSTAN_TIMES+envSuffix));
        urlMap.put(Constants.LIVE_MINT, prop.getProperty(Constants.LIVE_MINT+envSuffix));
        urlMap.put(Constants.LIVE_HINDUSTAN, prop.getProperty(Constants.LIVE_HINDUSTAN+envSuffix));
        urlMap.put(Constants.HT_E_PAPER, prop.getProperty(Constants.HT_E_PAPER+envSuffix));
        urlMap.put(Constants.LM_E_PAPER, prop.getProperty(Constants.LM_E_PAPER+envSuffix));
        urlMap.put(Constants.LH_E_PAPER, prop.getProperty(Constants.LH_E_PAPER+envSuffix));

        globalVars.setURLMapSSO(urlMap);
    }
}
