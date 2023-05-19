package com.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

//***** This class contains all the global variables to be used across the classes and packages *****

//***** This class will have all the global variables to be used across the classes and packages *****
//***** This class contains all the global variables to be used across the classes and packages *****
public class GlobalVars {
    private static GlobalVars globalVars;
    private String projectName;
    private String platformName;
    private String browser;
    private String browserMode;
    private String browserVersion;
    private AppiumDriver driver;
    private WebDriver webDriver;
    private Properties prop;
    private String qaAMPUrl;
    private String workingDir;
    private String deviceNameAndroid;
    private String platformVersionAndroid;
    private String appiumServerIp;
    private String appiumServerPort;
    private String deviceNameIOS;
    private String ipaFileName;
    private String udid;
    private String xcodeOrgId;
    private String xcodeSigningId;
    private String updateWDABundleId;
    private String platformVersionIOS;
    private List<String> mailRecipientList = new ArrayList<String>();
    private boolean jiraFlag = false;
    private boolean mailFlag = false;
    private boolean isCloudRun = false;
    private boolean isAutoStartAppium = false;
    private String jiraUrl;
    private String url;
    private String jiraUserName;
    private String jiraPassword;
    private String jiraDefectAssignee;
    private List<String> testCaseListRunModeTrue = new ArrayList<>();
    private Map<String, Map<String, String>> testDataElementsMap =new HashMap<>();
    private Map<String, TestConfigElements> testConfigMapping =new HashMap<>();
    private String appPackage;
    private String appActivity;
    private String appWaitPackage;
    private String uatUrl;
    private int maxRetry;
    private long implicitWait;
    private String senderEmailId;
    private String senderEmailPassword;
    private String jiraProjectName;
    private String jiraDefectType;
    private String recordId;
    private String androidAPKFileName;
    private String stgUrl;
    private String autUrl;
    private String preProdUrl;
    private String prodUrl;
    private String qaUrl;
    private String ampUrl;
    private String preProdAMPUrl;
    private String stgAMPUrl;
    private String environment;
    private String platFormName;
    private String executionType;
    private String isBrowserStack;
    private String capabilitiesJsonName;
    private boolean isLastTestCasePass =true;
    private int buildNumber;
    private String spreadsheetId;
    private boolean googleSheetFlag;
    private String bpTenant;
    private String applicationName;
    private Map<String, String> URLMapSSO;
    private String urlLiveBlog;
    private String urlCTALogo;
    private String isBrowserStackLocal;


	public static GlobalVars getInstance() {
        if (globalVars == null)
            globalVars = new GlobalVars();
        return globalVars;
    }

    public String getEnvironment() {
        return environment;
    }
    public String getPlatFormName(){
        return platformName;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setPlatFormName(String platformName) {
        this.platformName = platformName;
    }

    public boolean isCloudRun() {
        return isCloudRun;
    }

    public void setCloudRun(boolean cloudRun) {
        isCloudRun = cloudRun;
    }

    public void setAutoStartAppium(boolean autoStartAppium) {
        isAutoStartAppium = autoStartAppium;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
    public String getBrowser() {
        return browser;
    }

    public void setBrowserMode(String browserMode) {
        this.browserMode = browserMode;
    }
    public String getBrowserMode() {
        return browserMode;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public boolean isJiraFlag() {
        return jiraFlag;
    }

    public boolean isMailFlag() {
        return mailFlag;
    }

    public void setMailFlag(boolean mailFlag) {
        this.mailFlag = mailFlag;
    }

    public boolean isAutoStartAppium() {
        return isAutoStartAppium;
    }

    public String getAndroidAPKFileName() {
        return androidAPKFileName;
    }

    public void setAndroidAPKFileName(String androidAPKFileName) {
        this.androidAPKFileName = androidAPKFileName;
    }

    public String getStgUrl() {
        return stgUrl;
    }

    public String getAutUrl() {
        return autUrl;
    }

    public void setStgUrl(String stgUrl) {
        this.stgUrl = stgUrl;
    }

    public void setQAUrl(String qaUrl) {
        this.qaUrl = qaUrl;
    }
    public String getQAUrl( ) {
        return this.qaUrl;
    }

    public void setAMPQAUrl(String qaAMPUrl) {
        this.qaAMPUrl = qaAMPUrl;
    }
    public String getAMPQAUrl( ) {
        return this.qaAMPUrl;
    }

    public void setAutUrl(String autUrl) {
        this.autUrl = autUrl;
    }

    public String getPreProdUrl() {
        return preProdUrl;
    }

    public void setPreProdUrl(String preProdUrl) {
        this.preProdUrl = preProdUrl;
    }

    public String getProdUrl() {
        return prodUrl;
    }

    public String getAmpUrl() {
        return ampUrl;
    }

    public void setProdUrl(String prodUrl) {
        this.prodUrl = prodUrl;
    }

    public void setAmpUrl(String ampUrl) {
        this.ampUrl = ampUrl;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public AppiumDriver getAppiumDriver() {
        return driver;
    }

    public void setAppiumDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getDeviceNameAndroid() {
        return deviceNameAndroid;
    }

    public void setDeviceNameAndroid(String deviceNameAndroid) {
        this.deviceNameAndroid = deviceNameAndroid;
    }

    public String getPlatformVersionAndroid() {
        return platformVersionAndroid;
    }

    public void setPlatformVersionAndroid(String platformVersionAndroid) {
        this.platformVersionAndroid = platformVersionAndroid;
    }

    public String getAppiumServerIp() {
        return appiumServerIp;
    }

    public void setAppiumServerIp(String appiumServerIp) {
        this.appiumServerIp = appiumServerIp;
    }

    public String getAppiumServerPort() {
        return appiumServerPort;
    }

    public void setAppiumServerPort(String appiumServerPort) {
        this.appiumServerPort = appiumServerPort;
    }

    public String getDeviceNameIOS() {
        return deviceNameIOS;
    }

    public void setDeviceNameIOS(String deviceNameIOS) {
        this.deviceNameIOS = deviceNameIOS;
    }

    public String getIpaFileName() {
        return ipaFileName;
    }

    public void setIpaFileName(String ipaFileName) {
        this.ipaFileName = ipaFileName;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getXcodeOrgId() {
        return xcodeOrgId;
    }

    public void setXcodeOrgId(String xcodeOrgId) {
        this.xcodeOrgId = xcodeOrgId;
    }

    public String getXcodeSigningId() {
        return xcodeSigningId;
    }

    public void setXcodeSigningId(String xcodeSigningId) {
        this.xcodeSigningId = xcodeSigningId;
    }

    public String getUpdateWDABundleId() {
        return updateWDABundleId;
    }

    public void setUpdateWDABundleId(String updateWDABundleId) {
        this.updateWDABundleId = updateWDABundleId;
    }

    public String getPlatformVersionIOS() {
        return platformVersionIOS;
    }

    public void setPlatformVersionIOS(String platformVersionIOS) {
        this.platformVersionIOS = platformVersionIOS;
    }

    public boolean getJiraFlag() {
        return jiraFlag;
    }

    public void setJiraFlag(boolean jiraFlag) {
        this.jiraFlag = jiraFlag;
    }

    public boolean getIsAutoStartAppium() {
        return isAutoStartAppium;
    }

    public void setIsAutoStartAppium(boolean isAutoStartAppium) {
        this.isAutoStartAppium = isAutoStartAppium;
    }

    public String getJiraUrl() {
        return jiraUrl;
    }

    public void setJiraUrl(String jiraUrl) {
        this.jiraUrl = jiraUrl;
    }

    public void setPreProdAMPUrl(String preProdAMPUrl) {
        this.preProdAMPUrl = preProdAMPUrl;
    }

    public String getPreProdAMPUrl() {
        return preProdAMPUrl;
    }

    public void setStgAMPUrl(String stgAMPUrl) {
        this.stgAMPUrl = stgAMPUrl;
    }

    public String getStgAMPUrl() {
        return stgAMPUrl;
    }

    public String getJiraUserName() {
        return jiraUserName;
    }

    public void setJiraUserName(String jiraUserName) {
        this.jiraUserName = jiraUserName;
    }

    public String getJiraPassword() {
        return jiraPassword;
    }

    public void setJiraPassword(String jiraPassword) {
        this.jiraPassword = jiraPassword;
    }

    public String getJiraDefectAssignee() {
        return jiraDefectAssignee;
    }

    public void setJiraDefectAssignee(String jiraDefectAssignee) {
        this.jiraDefectAssignee = jiraDefectAssignee;
    }

    public List<String> getTestCaseListRunModeTrue() {
        return testCaseListRunModeTrue;
    }

    public void setTestCaseListRunModeTrue(String testCaseListRunModeTrue) {
        this.testCaseListRunModeTrue.add(testCaseListRunModeTrue);
    }

//    public Map<String, Map<String, String>> getTestDataElementsMap() {
//        return testDataElementsMap;
//    }

    public void setTestDataElementsMap(Map<String, Map<String, String>> testDataElementsMap) {
        this.testDataElementsMap=testDataElementsMap;
    }

    public String getLog4jPath() {
        return getWorkingDir() + "/log4j.xml";
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getAppWaitPackage() {
        return appWaitPackage;
    }

    public void setAppWaitPackage(String appWaitPackage) {
        this.appWaitPackage = appWaitPackage;
    }

    public String getWebDriverPath() {
        return getWorkingDir() + "/src/main/resources/BrowserDrivers/";
    }

    public String getUatUrl() {
        return uatUrl;
    }

    public void setUatUrl(String uatUrl) {
        this.uatUrl = uatUrl;
    }

    public int getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public long getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(long implicitWait) {
        this.implicitWait = implicitWait;
    }
    public void setWebDriverImplicitWait(long implicitWait) {
        this.webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }
    public void setWebDriverPageLoadTimeOut(long timeOut) {
        this.webDriver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
    }

    public String getJiraProjectName() {
        return jiraProjectName;
    }

    public void setJiraProjectName(String jiraProjectName) {
        this.jiraProjectName = jiraProjectName;
    }

    public String getJiraDefectType() {
        return jiraDefectType;
    }

    public void setJiraDefectType(String jiraDefectType) {
        this.jiraDefectType = jiraDefectType;
    }

    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public String[] getParamsData(String methodName) {
        //return getTestDataElementsMap().get(methodName).getModule().trim().split(",,");
        return null;
    }

    public Map<String, String> getParamsData(String methodName, String property) {
        System.out.println("******* "+methodName+" started *******");
        return Utils.getParamsMap(testDataElementsMap.get(methodName).get(property));
    }

    public Map<String, String> getParamsData1(String methodName) {
        return Utils.getParamsMap(testDataElementsMap.get(methodName).entrySet().iterator().next().getValue());
    }




    public String[] getParamsDataSingleProperty(String methodName) {
        //return getTestDataElementsMap().get(methodName).getModule().trim().split(",,");
        return null;
    }

    public Map<String, String> getParamsDataSingleProperty(String methodName, String property) {
        System.out.println("******* "+methodName+" started *******");

        return Utils.getParamsMap(testDataElementsMap.get(methodName).get(property));
    }
    public Map<String, String> getParamsDataSinglePropertySingleProperty(String methodName) {
        System.out.println("******* "+methodName+" started *******");
        Map<String,String> v =testDataElementsMap.get(methodName);

        String val =testDataElementsMap.get(methodName).get(globalVars.getApplicationName());
        return Utils.getParamsMap(testDataElementsMap.get(methodName).get(globalVars.getApplicationName()));
    }

    public Map<String, String> getParamsDataSingleProperty1(String methodName) {
        return Utils.getParamsMap(testDataElementsMap.get(methodName).entrySet().iterator().next().getValue());
    }

    public boolean getIsBrowserStack() {
        boolean isBrowserStackFlag=false;
        try {
            isBrowserStackFlag=Boolean.parseBoolean(isBrowserStack);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isBrowserStackFlag;
    }

    public void setIsBrowserStack(String isBrowserStack) {
        this.isBrowserStack = isBrowserStack;
    }

    public String getCapabilitiesJsonName() {
        return capabilitiesJsonName;
    }

    public void setCapabilitiesJsonName(String capabilitiesJsonName) {
        this.capabilitiesJsonName = capabilitiesJsonName;
    }

    public boolean getIsLastTestCasePass() {
        return isLastTestCasePass;
    }

    public void setLastTestCasePass(boolean lastTestCasePass) {
        isLastTestCasePass = lastTestCasePass;
    }

    public int getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        try {
            this.buildNumber = Integer.parseInt(buildNumber);
        }
        catch (NumberFormatException ne){
            System.out.println("Exception in setbuildNumber function: message: "+ne.getMessage());
        }

    }

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }

    public Map<String, TestConfigElements> getTestConfigMapping() {
        return testConfigMapping;
    }

    public void setTestConfigMapping(Map<String, TestConfigElements> testConfigMapping) {
        this.testConfigMapping = testConfigMapping;
    }

    public boolean getGoogleSheetFlag() {
        return googleSheetFlag;
    }

    public void setGoogleSheetFlag(String googleSheetFlag) {
        try {
            this.googleSheetFlag=Boolean.parseBoolean(googleSheetFlag);
        } catch (Exception exception) {
            System.out.println("****** Exception occurred at setGoogleSheetFlag() method: "+exception.getMessage());
        }
    }

    public boolean isProdRun() {
        return getEnvironment().equalsIgnoreCase(Constants.PROD);
    }
    public boolean isIosRun() {
        return getPlatFormName().equalsIgnoreCase(Constants.IOS_NATIVE);
    }
    public boolean isStgRun() {
        return getEnvironment().equalsIgnoreCase(Constants.STG);
    }

    public String getCurrentTimeStamp(){
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
    }

    public String getBpTenant() {
        return bpTenant;
    }

    public void setBpTenant(String bpTenant) {
        this.bpTenant = bpTenant;
    }
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Map<String, String> getURLMapSSO() {
        return URLMapSSO;
    }

    public void setURLMapSSO(Map<String, String> URLMapSSO) {
        this.URLMapSSO = URLMapSSO;
    }

    public String getUrlLiveBlog() {
        return urlLiveBlog;
    }

    public void setUrlLiveBlog(String urlLiveBlog) {
        this.urlLiveBlog = urlLiveBlog;
    }

    public String getUrlCTALogo() {
        return urlCTALogo;
    }
    public String getURL(){
        return this.url;
    }

    public void setURL(String url){
        this.url=url;
    }
    public void setUrlCTALogo(String urlCTALogo) {
        this.urlCTALogo = urlCTALogo;
    }

    public boolean getIsBrowserStackLocal() {
        boolean isBrowserStackLocalFlag=false;
        try {
            isBrowserStackLocalFlag=Boolean.parseBoolean(isBrowserStackLocal);
        } catch (Exception e) {
            System.out.println("Browser Stack Local status is ---- " +isBrowserStackLocalFlag);
        }
        return isBrowserStackLocalFlag;
    }

    public void setIsBrowserStackLocal(String isBrowserStackLocal) {
        this.isBrowserStackLocal = isBrowserStackLocal;
    }

}
