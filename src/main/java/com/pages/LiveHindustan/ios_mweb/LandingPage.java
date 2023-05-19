package com.pages.LiveHindustan.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonLandingPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LandingPage extends CommonLandingPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobileLH;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;
    @FindBy(xpath = "//section[@class='main-wdgt']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> entertainmentNews;
    private static final String entertainmentHindi = "मनोरंजन";

    public LandingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkLandingPageSubMenu() {
        return false;
    }

    @Override
    public boolean checkAurPadheButtonOnLandingPage() {
        return false;
    }

    @Override
    public boolean checkLandingPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(2);
        commonFunctionsMobileLH.clickElementWithGivenTextWithJS(topMenuOptions, entertainmentHindi);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return commonFunctionsMobileLH.checkEntertainmentLandingPage(entertainmentNews);
    }
}