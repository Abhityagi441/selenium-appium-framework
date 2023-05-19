package com.pages.HT_AUTO.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HT_AUTO.genericPages.CommonTopNavigationPage;
import com.utils.GlobalVars;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class TopNavigationPage extends CommonTopNavigationPage {
    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "//a[@class='logo']")
    private static WebElement logoHT_AUTOLogo;
    @FindBy(xpath = "//nav[@id='leftNav']/a")
    private static List<WebElement> navSliderList;


    public TopNavigationPage() {
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
    public boolean checkTopNavigation(String attributeName,String attributeValue) {
        boolean isTopNavigationTrue=true;
        boolean isTopNavigationSlidableTrue=true;
        boolean isElementPresent;
        String logoText="";

        commonFunctionsMobile.waitForPageToLoad();
        commonFunctionsMobile.navigateToHomePage();
        isElementPresent = commonFunctionsMobile.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
        if (isElementPresent) {
            commonFunctionsMobile.clickElementWithJS(acceptCookie, 10, "Accept cookie");
        }
        logoText=commonFunctionsMobile.getValueByAttribute(logoHT_AUTOLogo,attributeName);
        isTopNavigationTrue &=commonFunctionsMobile.compareTexts(logoText,attributeValue);
        isTopNavigationTrue &=commonFunctionsMobile.isElementDisplayedAndPresent(logoHT_AUTOLogo,20,"HT Auto Logo icon");
        isTopNavigationTrue &=commonFunctionsMobile.clickElementWithJS(logoHT_AUTOLogo,20,"HT Auto Logo icon");
        isTopNavigationSlidableTrue &=commonFunctionsMobile.innerScrollLeftToRightForListOfElement(navSliderList,50,"Top Navigation slider");
        if(isTopNavigationSlidableTrue && isTopNavigationTrue)
        {
            isTopNavigationTrue=true;
        }
        return isTopNavigationTrue;
    }
}