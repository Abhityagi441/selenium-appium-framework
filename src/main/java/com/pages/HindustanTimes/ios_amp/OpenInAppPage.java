package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonOpenInAppPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenInAppPage extends CommonOpenInAppPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(className = "openAppButton")
    private static WebElement openApp;

    @FindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement htApp;

    @FindBy(className ="android.widget.Button")
    private static MobileElement playStoreAppSignInButton;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    public OpenInAppPage() {
        globalVars = GlobalVars.getInstance();
        driver =(IOSDriver)globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    public boolean checkOpenAppOptionDisplayed(String ampUrl) {
        boolean isScrollDownSuccessful;
        commonFunctions.navigateURl(globalVars.getURL()+ampUrl);
        commonFunctions.scrollDownToBottom();
        isScrollDownSuccessful = commonFunctions.isElementDisplayed(openApp, 15, "Open App Button");

        return isScrollDownSuccessful;

    }

    public boolean checkRedirectionOfOpenApp(String appName) {
        boolean isRedirectionSuccessful = false;
        isRedirectionSuccessful = commonFunctions.isElementDisplayed(openApp, 35);
        commonFunctions.clickElement(openApp, 25, "Open App button");
        commonFunctions.switchToNative();
        try {
            boolean isDisplayed = commonFunctions.isElementDisplayed(htApp, 25, "HT Application");
            if (isDisplayed) {
                Utils.logStepInfo(true, "User  Redirected to HT Application");
            } else {
               boolean isElementDisplayed = commonFunctions.isElementDisplayed(playStoreAppSignInButton, 40, "PlayStore App Sign In Button");
                String redirectionApp = commonFunctions.getElementText(playStoreAppSignInButton, 40);
                if (redirectionApp.equalsIgnoreCase(appName)) {
                    Utils.logStepInfo(isElementDisplayed, "User Redirected to AppStore ");
                } else {
                    Utils.logStepInfo("User redirection on AppStore has been Failed");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRedirectionSuccessful;
    }


    @Override
    public boolean checkRedirectionBetweenApp(String ampUrl,String mwebUrl,String appName) {
        boolean isScrollDownSuccessful = checkOpenAppOptionDisplayed(ampUrl);
       boolean isRedirectionSuccessful = checkRedirectionOfOpenApp(appName);
        return isScrollDownSuccessful && isRedirectionSuccessful;
    }

    @Override
    public boolean checkOpenAppButton() {
        return false;
    }

    @Override
    public boolean checkOpenAppButtonTop() {
        return false;
    }

    @Override
    public boolean checkOpenAppButtonAfterEachStory() {
        return false;
    }

    @Override
    public boolean checkOpenAppButtonRedirectsToAppStore() {
        return false;
    }
}
