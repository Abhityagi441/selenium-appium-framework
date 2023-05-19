package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonOpenInAppPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OpenInAppPage extends CommonOpenInAppPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;


    public OpenInAppPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElement(skipButton, 8);
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }




    @Override
    public boolean checkRedirectionBetweenApp(String ampUrl, String mwebUrl,String appName) {
        return true;
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
