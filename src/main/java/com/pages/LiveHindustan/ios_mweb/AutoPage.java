package com.pages.LiveHindustan.ios_mweb;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonAutoPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AutoPage extends CommonAutoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobileLH;

    @FindBy(xpath = "//a[@title='ऑटो']")
    private static WebElement autoPage;

    @FindBy(xpath = "//div[@class='brd-crum']//a")
    private static List<WebElement> breadCrumb;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(xpath = "(//h3[@class='big-news-title'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "//div[@class='wdgt-hdng']//a")
    private static WebElement miltiJultiSection;

    @FindBy(xpath = "(//div[@class='ato-txt']//following-sibling::a)[4]")
    private static WebElement miltiJultiLink;

    private static final String autoUrl = "auto.hindustantimes.com";

    public AutoPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsMobileLH=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
//        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
//        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    @Override
    public boolean checkMiltiJultiCarWidgetOnAutoStoryPage() {
        return commonFunctionsMobileLH.miltiJultiCarWidgetOnAutoStoryPage(autoPage,firstStory,miltiJultiSection,miltiJultiLink,autoUrl);
    }

    @Override
    public boolean checkSubMenuOnAutoPage() {
        return false;
    }
}