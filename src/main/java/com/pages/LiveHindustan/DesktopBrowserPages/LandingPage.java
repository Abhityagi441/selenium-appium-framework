package com.pages.LiveHindustan.DesktopBrowserPages;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonLandingPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LandingPage extends CommonLandingPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLH commonFunctionsWebLH;

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
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLH = CommonFunctionsWebLH.getInstance();
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
        boolean getStatusCode200 = true;
        boolean isUrlClickable = true;
        boolean isAllLandingPageAreRelated = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctionsWebLH.clickElementWithGivenText(topMenuOptions, entertainmentHindi);
        commonFunctions.waitForPageToLoad();
        if (entertainmentNews.size() == 6)
        {
            for (int i = 0; i < entertainmentNews.size(); i++) {
                commonFunctions.moveToElementWithActions(entertainmentNews.get(i), 5, "Entertainment News links");
                String expectedUrl = commonFunctions.getAttributeValue(entertainmentNews.get(i), 5, "href");
                isUrlClickable &= commonFunctions.clickElementWithJS(entertainmentNews.get(i), 5, "Entertainment News Link " + i);
                commonFunctions.dummyWait(5);
                getStatusCode200 &= commonFunctions.getResponseCode(expectedUrl) == 200;
                isAllLandingPageAreRelated &= commonFunctions.getCurrentURL().contains(expectedUrl);
                driver.navigate().back();
                commonFunctions.waitForPageToLoad();
                commonFunctions.dummyWait(5);
            }
        }
        else
        {
            getStatusCode200 = false;
            isUrlClickable = false;
            isAllLandingPageAreRelated = false;
        }
        return isUrlClickable && getStatusCode200 && isAllLandingPageAreRelated;
    }
}