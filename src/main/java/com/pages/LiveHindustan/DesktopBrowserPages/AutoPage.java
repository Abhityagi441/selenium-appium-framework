package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonAutoPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AutoPage extends CommonAutoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

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
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    @Override
    public boolean checkMiltiJultiCarWidgetOnAutoStoryPage() {
        boolean isMiltiJultiSectionDisplayed;
        boolean redirectedAutoUrl;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(autoPage,10,"auto page");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(firstStory,10,"first story");
        commonFunctions.dummyWait(10);
        commonFunctions.scrollToElementView(miltiJultiSection,10,"milti-Julti Section");
        isMiltiJultiSectionDisplayed = commonFunctions.isElementDisplayed(miltiJultiSection,10,"milti-Julti Section");
        commonFunctions.scrollToElementView(miltiJultiLink,10,"on raod price link");
        commonFunctions.isElementDisplayed(miltiJultiLink,10,"on raod price");
        commonFunctions.clickElementWithJS(miltiJultiLink,20,"on raod price");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        redirectedAutoUrl=commonFunctions.getCurrentURL().contains(autoUrl);

        return isMiltiJultiSectionDisplayed && redirectedAutoUrl;
    }

    @Override
    public boolean checkSubMenuOnAutoPage() {
        return false;
    }
}

