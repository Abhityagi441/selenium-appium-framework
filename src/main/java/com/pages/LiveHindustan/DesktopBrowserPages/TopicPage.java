package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonTopicPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopicPage extends CommonTopicPage
{
    private static WebDriver driver;
    private static GlobalVars globalVars;

    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(xpath = "(//a[contains(@href,'topic')])[1]")
    private static WebElement firstTopicOnHomePage;

    @FindBy(xpath = "//h1[@class='page-hdng']")
    private static WebElement topicPageHeading;

    @FindBy(xpath = "//section[contains(@class,'listing article')]//div//a")
    private static List<WebElement> tabsOnTopicPage;

    public TopicPage() {
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
    public boolean checkAllTabsAndHeadingOnAnyTopicPage()
    {
        boolean isTabClickable = false;
        String topicTitle = firstTopicOnHomePage.getAttribute("title");
        topicTitle = topicTitle.replaceAll("#","");
        commonFunctions.clickElement(firstTopicOnHomePage);
        boolean isTopicTitleSame = commonFunctions.checkElementText(topicPageHeading,topicTitle,5,"Topic page Title");
        for(int i=0;i<3;i++)
        {
            tabsOnTopicPage.get(i).click();
            isTabClickable = commonFunctions.isClickableElementClicked(tabsOnTopicPage.get(i),5,tabsOnTopicPage.get(i).getText()+" Tab on topic Page");
            Utils.logStepInfo(true,"Clicked on the "+tabsOnTopicPage.get(i).getText()+" tab successfully");
        }
        return isTopicTitleSame && isTabClickable;
    }
}



