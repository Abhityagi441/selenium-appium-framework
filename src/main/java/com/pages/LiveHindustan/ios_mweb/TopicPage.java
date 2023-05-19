package com.pages.LiveHindustan.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonTopicPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopicPage extends CommonTopicPage
{
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private CommonFunctionsMobileLH commonFunctionsMobile;

    @FindBy(xpath = "(//a[contains(@href,'topic')])[1]")
    private static WebElement firstTopicOnHomePage;
    @FindBy(xpath = "//h1[@class='page-hdng']")
    private static WebElement topicPageHeading;
    @FindBy(xpath = "//section[contains(@class,'listing article')]//div//a")
    private static List<WebElement> tabsOnTopicPage;

    public TopicPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkAllTabsAndHeadingOnAnyTopicPage()
    {
        return commonFunctionsMobile.allTabsAndHeadingOnAnyTopicPage(firstTopicOnHomePage,topicPageHeading,tabsOnTopicPage);
    }
}
