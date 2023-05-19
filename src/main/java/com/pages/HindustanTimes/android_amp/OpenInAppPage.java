package com.pages.HindustanTimes.android_amp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonOpenInAppPage;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OpenInAppPage extends CommonOpenInAppPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(className = "openAppButton")
    private static WebElement openApp;

    @FindBy(xpath = "(//div[contains(@class,'cartHolder')]//h3[@class='hdg3']/a)[1]")
    private static WebElement headLineOfStory;

    @FindBy(xpath="(//button[@class='subscribe'])[1]")
    private static WebElement doThisLaterButton;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement htApp;

    @AndroidFindBy(className ="android.widget.Button")
    private static MobileElement playStoreAppSignInButton;

    @FindBy(xpath = "//div[contains(@class,'getApp')]")
    private static WebElement openAppTop;

    @FindBy(xpath = "(//div[@class='htsWrapper'])[1]")
    private static WebElement inlineStoriesFirstCarousel;

    @FindBy(xpath = "//div[@class='htsWrapper']//div[contains(@class,'slideStory')]//p//a[@data-vars-event-label='related_story_1']")
    private static WebElement inlineStoriesFirstHeadlineInCarousel;

    public OpenInAppPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    public boolean checkOpenAppOptionDisplayed(String ampUrl) {
        boolean isScrollDownSuccessful;
        commonFunctions.navigateURl(ampUrl);
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
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isScrollDownSuccessful = checkOpenAppOptionDisplayed(ampUrl);
        boolean isRedirectionSuccessful = checkRedirectionOfOpenApp(appName);
        return isScrollDownSuccessful && isRedirectionSuccessful;
    }

    @Override
    public boolean checkOpenAppButton() {
        boolean isOpenAppButtonDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.isElementDisplayed(headLineOfStory, 20, "Headline");
        commonFunctions.clickElementWithJS(headLineOfStory, 20, "Headline");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.refreshPage();
        commonFunctions.waitForURLContains(".html");
        isOpenAppButtonDisplayed = commonFunctions.isElementDisplayed(openApp, 15, "Open App Button");
        return isOpenAppButtonDisplayed;
    }

    @Override
    public boolean checkOpenAppButtonTop() {
        boolean isOpenAppButtonDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.waitForURLContains(globalVars.getAmpUrl());
        isOpenAppButtonDisplayed = commonFunctions.isElementDisplayed(openAppTop, 15, "Open App Button");
        return isOpenAppButtonDisplayed;
    }

    @Override
    public boolean checkOpenAppButtonAfterEachStory() {
        boolean isOpenAppButtonDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.isElementDisplayed(headLineOfStory, 20, "Headline");
        commonFunctions.clickElementWithJS(headLineOfStory, 20, "Headline");
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.refreshPage();
        commonFunctions.scrollUntilElementFound(inlineStoriesFirstCarousel);
        commonFunctions.clickElementWithJS(inlineStoriesFirstHeadlineInCarousel, 20, "Headline Inline Story");
        commonFunctions.waitForURLContains(".html");

        isOpenAppButtonDisplayed = commonFunctions.isElementDisplayed(openApp, 15, "Open App Button");
        return isOpenAppButtonDisplayed;
    }

    @Override
    public boolean checkOpenAppButtonRedirectsToAppStore() {
        return false;
    }
}
