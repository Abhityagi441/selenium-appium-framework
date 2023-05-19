package com.pages.LiveHindustan.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonAutoPage;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AutoPage extends CommonAutoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private CommonFunctionsMobileLH commonFunctionsMobile;

    @FindBy(xpath = "//a[@title='ऑटो']")
    private static WebElement autoPage;

    @FindBy(xpath = "(//h3[@class='big-news-title'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "//nav[@id='sub-nv']//a")
    private static List<WebElement> subMenus;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    private static final String autoUrl = "auto.hindustantimes.com";

    public AutoPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkMiltiJultiCarWidgetOnAutoStoryPage() {
        return false;
    }

    @Override
    public boolean checkSubMenuOnAutoPage() {
        return commonFunctionsMobile.subMenuOnAutoPage(autoPage,subMenus, "AutoMenuValuesForRandomNumber");
    }

}