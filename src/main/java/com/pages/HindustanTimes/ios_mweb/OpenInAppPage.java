package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonOpenInAppPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenInAppPage extends CommonOpenInAppPage {
    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(className = "openAppButton")
    private static WebElement openApp;

    @iOSXCUITFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement htApp;

    @iOSXCUITFindBy(className ="android.widget.Button")
    private static MobileElement playStoreAppSignInButton;

    @FindBy(xpath = "//div[contains(@class,'bigCart')]/h3/a")
    private static WebElement headLineOfStory;

    @FindBy(xpath = "//div[contains(@class,'getApp')]")
    private static WebElement openAppTop;

    @FindBy(xpath = "(//ul[@class='hts']/li//p)[1]")
    private static WebElement headLineOfInlineStory;

    @FindBy(id = "section_news")
    private static WebElement inlineStories;



    public OpenInAppPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean checkOpenAppOptionDisplayed(String mwebUrl) {
        boolean isScrollDownSuccessful;
        commonFunctions.navigateURl(mwebUrl);
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
    public boolean checkRedirectionBetweenApp(String ampUrl, String mwebUrl, String appName) {
        boolean isScrollDownSuccessful = checkOpenAppOptionDisplayed(mwebUrl);
        boolean isRedirectionSuccessful = checkRedirectionOfOpenApp(appName);
        return isScrollDownSuccessful && isRedirectionSuccessful;
    }
    @Override
    public boolean checkOpenAppButton() {
        boolean isOpenAppButtonDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForURLToBe(globalVars.getURL());
        commonFunctions.isElementDisplayed(headLineOfStory, 20, "Headline");
        commonFunctions.clickElementWithJS(headLineOfStory, 20, "Headline");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.navigateToURL(currentUrl);
        commonFunctions.waitForURLContains(".html");
        commonFunctions.dummyWait(10);
        isOpenAppButtonDisplayed = commonFunctions.isElementDisplayed(openApp, 15, "Open App Button");
        return isOpenAppButtonDisplayed;
    }
    @Override
    public boolean checkOpenAppButtonTop() {
        boolean isOpenAppButtonDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForURLContains(globalVars.getURL());
        isOpenAppButtonDisplayed = commonFunctions.isElementDisplayed(openAppTop, 15, "Open App Button");
        return isOpenAppButtonDisplayed;
    }
    @Override
    public boolean checkOpenAppButtonAfterEachStory() {
        boolean isOpenAppButtonDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(headLineOfStory, 20, "Headline");
        commonFunctions.clickElement(headLineOfStory, 20, "Headline");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.navigateToURL(currentUrl);
        commonFunctions.waitForURLContains(".html");
        commonFunctions.scrollUntilElementFound(inlineStories);
        commonFunctions.clickElement(headLineOfInlineStory, 20, "Headline Inline Story");
        isOpenAppButtonDisplayed = commonFunctions.isElementDisplayed(openApp, 15, "Open App Button");
        return isOpenAppButtonDisplayed;
    }

    @Override
    public boolean checkOpenAppButtonRedirectsToAppStore() {
        boolean isOpenAppButtonDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(headLineOfStory, 20, "Headline");
        commonFunctions.clickElement(headLineOfStory, 20, "Headline");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.navigateToURL(currentUrl);
        commonFunctions.waitForURLContains(".html");
        commonFunctions.isElementDisplayed(openApp, 15, "Open App Button");
        isOpenAppButtonDisplayed = commonFunctions.clickElementWithJS(openApp, 15, "Open App Button");
        commonFunctions.changeContextToWeb();
        //check for app store redirection here
        return isOpenAppButtonDisplayed;
    }

}
