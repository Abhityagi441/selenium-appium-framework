package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_AUTO.genericPages.CommonShareFunctionalityPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ShareFunctionalityPage extends CommonShareFunctionalityPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//div[@id='mylistView']//child::div[@class='linkclick-candidate']")
    private static List<WebElement> storiesWebPageList;
    @FindBy(xpath = "//div[contains(@class,'icoShare')]")
    private static List<WebElement> allShareBtnList;
    @FindBy(xpath = "(//div[contains(@class,'icoShare')])[1]")
    private static WebElement shareBtn;


    public ShareFunctionalityPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        commonFunctionsMobile = CommonFunctionsMobile.getInstance();

        boolean isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkShareFunctionality() {
        boolean isShareFunctionalityTrue=false;

        return isShareFunctionalityTrue;
    }
}