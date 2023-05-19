package com.pages.HindustanTimes.commonFunctions;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.jayway.jsonpath.JsonPath;
import com.utils.ApiValidation;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.restassured.response.Response;
import org.openqa.selenium.*;

import java.util.List;

public class CommonFunctionsWebHt {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWebHt commonFunctionsWeb;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsMobile commonFunctionsMobile;
    private static DriverController driverController;
    private static ApiValidation apiValidation;

    public static CommonFunctionsWebHt getInstance() {
        driverController = DriverController.getInstance();
        if (commonFunctionsWeb == null) {
            commonFunctionsWeb = new CommonFunctionsWebHt();
        }
        return commonFunctionsWeb;
    }

    public CommonFunctionsWebHt() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsMobile = CommonFunctionsMobile.getInstance();
        apiValidation = ApiValidation.getInstance();
    }

    public boolean checkSectionLandingPage(WebElement landingPageElement, String landingPageElementName, int timeOut) {
        boolean checkLandingPageStatus = false;
        commonFunctions.dummyWait(10);
        String actualLandingPageName = commonFunctions.getElementText(landingPageElement, timeOut);
        if (actualLandingPageName.equalsIgnoreCase(landingPageElementName) || landingPageElementName.toLowerCase().contains(actualLandingPageName.toLowerCase())) {
            checkLandingPageStatus = true;
            Utils.logStepInfo(true, landingPageElementName + " Landing Page displayed successfully");
        } else {
            Utils.logStepInfo(false, landingPageElementName + " Landing Page is not displayed");
        }
        return checkLandingPageStatus;
    }

    public boolean verifyTopicLandingPage(List<WebElement> topics,WebElement landingPage, int topicIndex){
        String landingPageElementName = topics.get(topicIndex).getText();
        commonFunctions.clickElement(topics.get(topicIndex), 10, landingPageElementName+" - Topic");
        boolean checkTopicLandingPageStatus = checkSectionLandingPage(landingPage, landingPageElementName, 10);
        commonFunctions.navigateBack();
        return checkTopicLandingPageStatus;
    }

    public boolean verifyMyReadsHasHistory(String uri, String address, WebElement closeHamburger,WebElement openFullStory, WebElement hamBurger,
    WebElement myAccountButton, WebElement myRead, WebElement myReadsFirstHeadLine, MobileElement storyTitleInMyRead) {
        boolean isStep = false;
        String headlineFromAPI = "";
        commonFunctionsMobile.navigateToURL(globalVars.getURL());
        commonFunctionsMobile.clickElementWithJS(closeHamburger);
        commonFunctionsMobile.scrollToElementViewAndClick(openFullStory, 20, "openFullStory located");
        commonFunctionsMobile.waitForURLContains(".html");
        commonFunctionsMobile.dummyWait(10);
        String url = commonFunctionsMobile.getCurrentURL("First Article"," URL");
        String storyid = commonFunctionsMobile.extractStoryID(url);
        System.out.println("extractStoryID(url) = " + storyid);
        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_WEB)){
            if(!(storyid.equals(null) || storyid.equals(""))) {
                Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
                headlineFromAPI = JsonPath.parse(response.getBody().asString()).read("$.mobileHeadline");
            }
            else {Utils.logStepInfo("Story Id is not coming");}
            System.out.println("extractStoryID(url) = " + storyid);}
        else if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_WEB)) {
            Response response = apiValidation.getResponseFromURI(uri, address + storyid);
            commonFunctionsMobile.dummyWait(20);
            headlineFromAPI = apiValidation.getNodeFromResponse(response, "mobileHeadline");
            System.out.println("key value received from json response is" + headlineFromAPI);
        }
        commonFunctionsMobile.scrollToTop();
        commonFunctionsMobile.clickElementWithJS(hamBurger, 20, "Hamburger");
        commonFunctionsMobile.clickElement(myAccountButton, 10, "My Account");
        commonFunctionsMobile.clickElement(myRead, 5, "MyReads in left navigation");
        commonFunctionsMobile.waitForURLContains("myreads");
        String title = commonFunctionsMobile.getElementText(myReadsFirstHeadLine, 20);
        if(title.equals(null) || title.equals("")){
            commonFunctionsMobile.scrollDownToElement(storyTitleInMyRead,"Story Title in My Read");
            title = commonFunctionsMobile.getElementText(storyTitleInMyRead, 20);
            if(!(title.equals(null) || title.equals(""))){
                isStep = true;
                Utils.logStepInfo(isStep, "Getting 404 error but Story display in My Read ");
            }}
        else{ isStep = title.equalsIgnoreCase(headlineFromAPI);}
        return isStep;
    }
}

