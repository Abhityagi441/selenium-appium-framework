package com.pages.LiveHindustan.android_mweb;

import com.commonFunctions.CommonFunctionsWeb;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonAutoPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AutoPage extends CommonAutoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobLH;

    @FindBy(xpath = "//a[@title='ऑटो']")
    private static WebElement autoPage;

    @FindBy(xpath = "(//h3[@class='big-news-title'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "(//div[@class='wdgt-hdng']//a)[1]")
    private static WebElement miltiJultiSection;

    @FindBy(xpath = "(//div[@class='ato-txt']//following-sibling::a)[4]")
    private static WebElement miltiJultiLink;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    private static final String autoUrl = "auto.hindustantimes.com";


    public AutoPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobLH=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    @Override
    public boolean checkMiltiJultiCarWidgetOnAutoStoryPage() {
        return commonFunctionsMobLH.miltiJultiCarWidgetOnAutoStoryPage(autoPage,firstStory,miltiJultiSection,miltiJultiLink,autoUrl);
    }

    @Override
    public boolean checkSubMenuOnAutoPage() {
        return false;
    }
}