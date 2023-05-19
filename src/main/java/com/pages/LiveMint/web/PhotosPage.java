package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPhotosPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotosPage extends CommonPhotosPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsLM;

    @FindBy(xpath = "//a[@class='logo']")
    private static WebElement pageTitle;

    @FindBy(id = "hamburgerElement")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//li[@id='sectionp_photos']")
    private WebElement photosec;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement epaperIcon;

    @FindBy(id = "showCurrentDateTime")
    private static WebElement timestamp;

    @FindBy(xpath = "//a[@class='icoBell iconSprite']")
    private static WebElement NotificationIcon;
    @FindBy(xpath = "//div[@class='icoSearch websearch iconSprite']")
    private static WebElement Searchicon;
    @FindBy(xpath = "//h1[@class='listheading']")
    private static WebElement pagetitelPhoto;

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
        driver = globalVars.getWebDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(driver, this);
        commonFunctions =CommonFunctionsWeb.getInstance();
        commonFunctionsLM= CommonFunctionsWebLM.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
    @Override
    public boolean checkPhotoPagelayout(String URL)
    {
    commonFunctions.navigateToUrl(globalVars.getURL()+URL);
        boolean checkNonLoginPageLayout=commonFunctionsLM.topNavElments(pageTitle,exploreMenu,epaperIcon,Searchicon);
        commonFunctions.isElementDisplayed(NotificationIcon,10,"Notification icon need to be displayed on top Nav");
        commonFunctions.isElementDisplayed(timestamp,10,"Current Date and time need to be displayed under the epaper");
        commonFunctions.isElementDisplayed(pagetitelPhoto,10,"Photos");
       return checkNonLoginPageLayout;
    }

    @Override
    public boolean checkPhotosView (String URL)
    {
        commonFunctions.navigateToUrl(globalVars.getURL()+URL);
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
