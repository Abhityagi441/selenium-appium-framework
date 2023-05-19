package com.pages.LiveHindustan.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonVideoPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class VideoPage extends CommonVideoPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWeb commonFunctionsWeb;
    private CommonFunctionsWebLH commonFunctionsWebLH;
    private CommonFunctionsMobileLH commonFunctionsMobile;


    @FindBy(xpath = "//div[@id= 'home-top-menu']/a[contains(text(), 'वीडियो')]")
    private static WebElement videoeMenu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[contains(text(), 'वीडियो')]")
    private static WebElement videoWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> videoL2Menu;

    @FindBy(xpath = "//figure[@class='storyimg']/a")
    private static WebElement firstVideoWeight;

    @FindBy(xpath = "//div[@class='bread-crumbs']/a")
    private static List<WebElement> brdCrumList;

    @FindBy(xpath = "//div[contains(@class, 'wdgt-title')]/h1/a")
    private static WebElement brdCrumRedFirst;

    @FindBy(xpath = "//div[contains(@class, 'wdgt-title')]/h1/a")
    private static WebElement brdCrumRedSecound;

    @FindBy(xpath = "//div[contains(@class, 'wdgt-title')]/h1/a")
    private static WebElement brdCrumRedThird;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[1]")
    private static WebElement brdCrumHeading;

    @FindBy(xpath = "//div[@class='rlt-list']/a")
    private static List<WebElement> sambandhitWidget;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[1]")
    private static WebElement brdCrumFirst;

    @FindBy(xpath = "//div[@class='socialbutton']/amp-social-share[@type='facebook']")
    private static WebElement socialSharingFaceBookIcon;

    @FindBy(xpath = "//div[@class='socialbutton']/amp-social-share[@type='twitter']")
    private static WebElement socialSharingTwitterIcon;

    @FindBy(xpath = "//div[@class='socialbutton']/a[contains(@class, 'gnewsicn')]")
    private static WebElement socialSharingHameFollowIcon;

    @FindBy(xpath = "//div[@class='socialbutton']/amp-social-share[@type='whatsapp']")
    private static WebElement socialSharingWhatsAppIcon;

    @FindBy(xpath = "//iframe[contains(@allow, 'autoplay')]")
    private static WebElement ytplayerFrame;

    @FindBy(xpath = "//button[@class= 'ytp-play-button ytp-button']")
    private static WebElement videoState;

    @FindBy(id = "player")
    private static WebElement player;


    public VideoPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWeb=CommonFunctionsWeb.getInstance();
        commonFunctionsMobile=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkSubmenuAreClickableOnVideoLandingPage() {
        navigateToVideoPage();
        String videoUrl = commonFunctions.getCurrentURL();
        int videoL2MenuSize = videoL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(videoL2Menu, videoL2MenuSize, videoUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkBreadcrumbRedirectionGiving200OnVideoWidget(){
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollToElement(firstVideoWeight, "First Video Weight");
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumHeading, 10, "Brd Crum Heading");
        String videoWeightUrl = commonFunctions.getCurrentURL();
        int videoBreadCrumSize = brdCrumList.size();
        boolean brdCrumStatus = commonFunctionsMobile.isAllElementsClickableAndGiving200Status(brdCrumList, videoBreadCrumSize, videoWeightUrl, brdCrumRedFirst, brdCrumRedSecound, brdCrumRedThird);
        return brdCrumStatus && videoBreadCrumSize == 3;
    }

    public void navigateToVideoPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(videoeMenu, "Video Menu");
        commonFunctions.clickElementWithJS(videoeMenu, 10, "Video Menu");
        commonFunctions.isElementDisplayed(videoWdgt, 10, "Video Wdgt");
    }

    @Override
    public boolean checkVideoDetailPage() {
        return false;
    }

    @Override
    public boolean checkSambhanditVideoGalleryHavingFourVideosGiving200Status(){
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollToElement(firstVideoWeight, "First Video Weight");
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumFirst, 10, "Brd Crum List");
        String videoWeightUrl = commonFunctions.getCurrentURL();
        int videoSambandhitSize = sambandhitWidget.size();
        boolean isAllElementClickableTrue = commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURLForAMP(sambandhitWidget, videoSambandhitSize, videoWeightUrl, "WidgitValuesForRandomNumber");
        return isAllElementClickableTrue && videoSambandhitSize == 5;
    }

    @Override
    public boolean checkSocialSharingRedirectionAndGiving200OnVideoDetail(){
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollToElement(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumFirst, 10, "Brd Crum List");
        String videoWeightUrl = commonFunctions.getCurrentURL();
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySocialSharingRedirectionAndGiving200OnVideoDetail");
        boolean whatsAppFlag = commonFunctionsMobile.validateSocialSharingIconFunctionality(socialSharingWhatsAppIcon, params.get("WhatsApp"), videoWeightUrl, "WhatsApp");
        boolean facebookFlag = commonFunctionsMobile.validateSocialSharingIconFunctionality(socialSharingFaceBookIcon, params.get("Facebook"), videoWeightUrl, "Facebook");
        boolean twitterFlag = commonFunctionsMobile.validateSocialSharingIconFunctionality(socialSharingTwitterIcon, params.get("Twitter"), videoWeightUrl, "Twitter");
        boolean hamefollowFlag = commonFunctionsMobile.validateSocialSharingIconFunctionality(socialSharingHameFollowIcon, params.get("HameFlowKare"), videoWeightUrl, "HameFlowKare");
        return facebookFlag && twitterFlag && hamefollowFlag && whatsAppFlag;
    }

    @Override
    public boolean checkVideoIsPlayingSuccessfullyOnVideoDetailPage() {
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollToElement(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumFirst, 10, "Brd Crum List");
        boolean playerStatue = commonFunctionsMobile.validatePlayAndPauseButton(ytplayerFrame, videoState, player, "data-title-no-tooltip");
        return playerStatue;
    }
    public boolean checkVideoGalleryWidgetIsHaving5StoriesAndStatusIs200()
    {
        return false;
    }
}
