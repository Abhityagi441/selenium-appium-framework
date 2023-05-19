package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonLatestStoriesPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LatestStoriesPage extends CommonLatestStoriesPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;



    public LatestStoriesPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElement(skipButton, 8);
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }


    @Override
    public boolean checkStoriesPublishedOnDateDisplayedOnTopOfPage() throws Exception {
        return false;
    }
}
