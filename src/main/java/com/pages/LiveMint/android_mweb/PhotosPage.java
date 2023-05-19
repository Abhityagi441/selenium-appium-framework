package com.pages.LiveMint.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonPhotosPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PhotosPage extends CommonPhotosPage {
    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLM commonFunctionsLM;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(id = "hamburgerElement")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement epaperIcon;

    @FindBy(xpath = "//a[@class='headerGetApp']")
    private static WebElement getAppCta;
    @FindBy(xpath = "//div[@class='icoSearch mwebsearch iconSprite']")
    private static WebElement Searchicon;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement pagetitelPhoto;
    @FindBy(xpath = "//div[@class='openinApp']")
    private static WebElement openinApp;
    @FindBy(xpath = "//section[@class='cardHolder images page-view-candidate']")
    private static WebElement FirststoryCardView;
    @FindBy(xpath = "(//h2[contains(@class,'headline')])[1]")
    private static WebElement FirstStoryHeadline;
    @FindBy(xpath = "(//div[@class='listtostory clearfix'][1])")
    private static WebElement SecondStory;

    @FindBy(xpath = "(//div[contains(@class,'headlineSec')])[1]")
    private static WebElement SecondStoryHeadlie;

    public PhotosPage()
    {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsLM= CommonFunctionsMobileLM.getInstance();
         globalVars.getAppiumDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        globalVars.getAppiumDriver().manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkPhotoPagelayout(String URL) {
       commonFunctions.navigateToURL(globalVars.getURL()+URL);
        boolean checkNonLoginPageLayout=commonFunctionsLM.topNavpalace(pageTitle,exploreMenu,epaperIcon,Searchicon);
        commonFunctions.isElementDisplayed(getAppCta,10,"openinApp CTA need to be displayed on top Nav");
        commonFunctions.isElementDisplayed(openinApp,10,"openinApp need to be displayed on listing");
        commonFunctions.isElementDisplayed(pagetitelPhoto,10,"Photos");
        return checkNonLoginPageLayout;
    }
    @Override
    public boolean checkPhotosView(String URL)
    {
        commonFunctions.navigateToURL(globalVars.getURL()+URL);
         boolean story=commonFunctionsLM.checkStory(FirststoryCardView,FirstStoryHeadline);
        commonFunctions.scrollToElementView(SecondStory,10,"Second story in view port");
        commonFunctions.isElementDisplayed(SecondStory,10,"Second story displayed in list view");
        String Headline = commonFunctions.getElementText(SecondStoryHeadlie);
        String Header =commonFunctions.getElementText(SecondStoryHeadlie);
        commonFunctions.checkTextContains(Header,Headline,"Second story title displayed");
        commonFunctions.isElementDisplayed(SecondStoryHeadlie,10,"Second story title displayed");
        commonFunctions.clickElementWithJS(SecondStoryHeadlie,20,"Second story open");
        return story;
    }
}
