package com.pages.HT_AUTO.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonBikeDetailsPage;
import com.pages.HT_AUTO.genericPages.CommonShareFunctionalityPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShareFunctionalityPage extends CommonShareFunctionalityPage {
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//div[@id='mylistView']//child::div[@class='linkclick-candidate']")
    private static List<WebElement> storiesWebPageList;
    @FindBy(xpath = "//div[@id='socialHolder']//following-sibling::div[2]")
    private static List<WebElement> allShareBtnList;
    @FindBy(xpath = "(//div[@class='icoShare iconSprite share-candidate'])[1]")
    private static WebElement shareBtn;

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    public ShareFunctionalityPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctions.clickElementIfDisplayed(acceptCookie, 10,"acceptCookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkShareFunctionality() {
        boolean isShareFunctionalityTrue=false;

//        commonFunctions.isAllElementVisible()
        return isShareFunctionalityTrue;
    }
}