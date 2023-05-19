package com.pages.HindustanTimes.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonIndiaUsSitePage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IndiaUsSitePage extends CommonIndiaUsSitePage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    public IndiaUsSitePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkIndiaUsToggleWorking() {
    	return false;
    }

    @Override
    public boolean clickOnExplorerMenu() throws Exception {
        return false;
    }

    @Override
    public boolean clickOnUsaOnTopHamburger() throws Exception {
        return false;
    }

    @Override
    public boolean checkUSPageDisplayed() throws Exception {
        return false;
    }

    @Override
    public boolean goToIndiaPageHamburgerMenu() throws Exception {
        return false;
    }
}
