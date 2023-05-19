
package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsWebHt;
import com.pages.HindustanTimes.generic.CommonHistoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage extends CommonHistoryPage {
    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWebHt commonFunctionsWeb;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath="(//div[contains(@class,'cartHolder bigCart')]//h3[@class='hdg3']/a)[1]")
    private static WebElement openFullStory;

    @FindBy(xpath = "(//div[@class='storyShortDetail'])[2]")
    private static WebElement topics;

    @FindBy(xpath = "(//span[text()='RECOMMENDED'])[1]")
    private static WebElement recommended;

    @FindBy(xpath = "(//h3[@class='hdg3'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "//div[contains(@class,'myAccountPop')]/div[6]/a")
    private static WebElement myRead;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;

    @FindBy(xpath = "//div[@id='topnews']/section/div[1]/div[1]/h3/a")
    private static WebElement myReadsFirstHeadLine;

    @FindBy(id = "allow")
    private static WebElement allowButton;

    @FindBy(xpath = "(//a[contains(text(),'READ FULL')])[1]")
    private static WebElement readFullStory;

    @FindBy(xpath = "//ul[@class='leftFixedNav']")
    private static  WebElement leftNavBar;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(xpath ="(//div[@class='logged-in'])[2]")
    private static  WebElement loggedIn;

    @FindBy(xpath = "(//a[contains(text(),'Sign out')])[2]")
    private static WebElement signOut;

    @FindBy(className = "crossicon")
    private static WebElement closeHamburger;

    @FindBy(xpath = "//div[contains(@class,'userName')]")
    private static WebElement myAccountButton;

    @FindBy(xpath = "//section[@id='dataHolder']/div[3]/h3/a")
    private static MobileElement storyTitleInMyRead;

    public HistoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWeb = CommonFunctionsWebHt.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkMyReadsHasHistoryOfAllStoriesRead(String uri,String address) throws Exception{
        return commonFunctionsWeb.verifyMyReadsHasHistory(uri, address, closeHamburger,openFullStory, hamBurger,
                myAccountButton, myRead, myReadsFirstHeadLine, storyTitleInMyRead);
    }
}
