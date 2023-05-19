package com.pages.LiveMint.ios_mweb;
import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonEducationPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EducationPage extends CommonEducationPage {
    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;

    @FindBy(xpath = "//div[@id='hamburgerElement']")
    private static WebElement explore;

    @FindBy(xpath = "//a[@href='/education']")
    private static WebElement education;

    @FindBy(xpath = "//div[@class='linkclick-candidate'][1]")
    private static WebElement educationFirstStory;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]/a")
    private static WebElement educationFirstHeadline;

    @FindBy(xpath = "(//h2[contains(@class,'headline')])[2]/a")
    private static WebElement educationSecondHeadline;
    @FindBy(xpath = "(//div[contains(@class,'listtostory')])[1]")
    private static WebElement educationSecondStory;
    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;
    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement EpaperIcon;

    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
    private static WebElement singInButton;
    @FindBy(xpath = "//div[@class='icoMenu']")
    private static WebElement iconMenu;
    @FindBy(xpath = "//a[@id='getAppId']")
    private static WebElement getApp;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private static WebElement MyAccount;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement pageHeadline;

    public EducationPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkEducationPageLayout(String amp) {
       return commonFunctions.navigateToEducationPageLayout(explore, education, educationFirstStory, educationFirstHeadline, educationSecondStory, educationSecondHeadline, "education");
    }

    @Override
    public boolean clickOnEducationsSection() {
        boolean isShowing;
        commonFunctions.clickElementWithJS(explore, 10, "explore");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(education, 15, "education Section");
        commonFunctions.dummyWait(5);
        isShowing = commonFunctions.clickElement(education, 10, "education");
        isShowing &= commonFunctions.isElementDisplayed(pageHeadline, 10, "education headline");
        return isShowing;
    }

    @Override
    public boolean checkTopNavOnEducationPage() {
        boolean topNavVisibilty = commonFunctions.TopNavOnEducationPage(pageTitle, iconMenu, EpaperIcon);
        topNavVisibilty &=commonFunctions.isElementDisplayed(singInButton, 10, "Sign in button need to be displayed in top nav");
        topNavVisibilty &= commonFunctions.isElementDisplayed(getApp, 10, "get app visibility");
        return topNavVisibilty;
    }

    @Override
    public  boolean checkLHSMenuOnEducationPage(){
        return false;
    }
    @Override
    public boolean checkRHSOnEducationPage(){return false;}
}

