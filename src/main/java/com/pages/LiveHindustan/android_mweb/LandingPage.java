package com.pages.LiveHindustan.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonLandingPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
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
    @FindBy(id = "deny")
    private static WebElement notificationDeny;
    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;
    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;
    @FindBy(xpath = "//section[@class='main-wdgt']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> entertainmentNews;
    private static final String entertainmentHindi = "मनोरंजन";

    public LandingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
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
        commonFunctionsMobileLH.clickElementWithGivenText(topMenuOptions, entertainmentHindi);
        commonFunctions.waitForPageToLoad();
        return commonFunctionsMobileLH.checkEntertainmentLandingPage(entertainmentNews);
    }
}