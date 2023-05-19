package com.pages.LiveHindustan.DesktopBrowserPages;


import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonVideoPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class VideoPage extends CommonVideoPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLH commonFunctionsWebLH;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//nav[contains(@class, 'hdr-menu')]/a[contains(@title, 'वीडियो')]")
    private static WebElement videoeMenu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[contains(text(), 'वीडियो')]")
    private static WebElement videoWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> videoL2Menu;

    @FindBy(xpath = "(//div[@class='wdgt-lft'])[1]/a")
    private static WebElement firstVideoWeight;

    @FindBy(xpath = "//div[@class='brd-crum']/a")
    private static List<WebElement> brdCrumList;

    @FindBy(xpath = "//h1[contains(@class, 'wdgt-hdng')]/span")
    private static WebElement brdCrumRedFirst;

    @FindBy(xpath = "(//div[@class='wdgt-hdng']//a)[1]")
    private static WebElement brdCrumRedSecound;

    @FindBy(xpath = "(//h1[@class='wdgt-hdng']//a)[1]")
    private static WebElement brdCrumRedThird;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;

    @FindBy(xpath = "//div[@class='wdgt-lft']")
    private static List<WebElement> videoPageMainTitles;

    @FindBy(xpath = "//div[@class='vd-cnt']/h1")
    private static WebElement storyHeadLine;

    @FindBy(xpath = "//div[@class='brd-crum']/a")
    private static List<WebElement> breadCrumbCurrentPage;

    @FindBy(xpath = "//a[contains(@class,'shre-icn twt-icn')]")
    private static WebElement twitterIcon;

    @FindBy(xpath = "//a[contains(@class,'shre-icn fb-icn')]")
    private static WebElement facebookIcon;

    @FindBy(xpath = "//div[contains(@class,'main-wdgt glry-bg')]/h2/a")
    private static WebElement currnetStoryRelatedWidget;

    @FindBy(xpath = "//div[@class='scroll-owl']/a")
    private static List<WebElement> sambandhitWidget;

    @FindBy(xpath = "//div[@class='shre-innr']/a[contains(@class, 'fb-icn')]")
    private static WebElement socialSharingFaceBookIcon;

    @FindBy(xpath = "//div[@class='shre-innr']/a[contains(@class, 'twt-icn')]")
    private static WebElement socialSharingTwitterIcon;

    @FindBy(xpath = "//div[@class='shre-innr']/a[contains(@class, 'gogle-follow')]")
    private static WebElement socialSharingHameFollowIcon;

    @FindBy(id = "ytplayer")
    private static WebElement ytplayerFrame;

    @FindBy(xpath = "//button[@class= 'ytp-play-button ytp-button']")
    private static WebElement videoState;

    @FindBy(id = "player")
    private static WebElement player;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='वीडियो गैलरी']")
    private static WebElement videoGallerySection;
    @FindBy(xpath = "//a[@title='वीडियो गैलरी']//ancestor::section[@class='pht-vde-lnd']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> videoGalleryLinks;




    public VideoPage() {
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

    private static final String videoHindi = "वीडियो";

    @Override
    public boolean checkSubmenuAreClickableOnVideoLandingPage() {
        navigateToVideoPage();
        String videoUrl = commonFunctions.getCurrentURL();
        int videoL2MenuSize = videoL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(videoL2Menu, videoL2MenuSize, videoUrl);
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkBreadcrumbRedirectionGiving200OnVideoWidget(){
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollPageWithJS(firstVideoWeight, 5);
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumList, 10, "Brd Crum List");
        String videoWeightUrl = commonFunctions.getCurrentURL();
        int videoBreadCrumSize = brdCrumList.size();
        boolean brdCrumStatus = commonFunctionsWebLH.isAllElementsClickableAndGiving200Status(brdCrumList, videoBreadCrumSize, videoWeightUrl, brdCrumRedFirst, brdCrumRedSecound, brdCrumRedThird);
        return brdCrumStatus && videoBreadCrumSize == 3;
    }

    @Override
    public boolean checkSambhanditVideoGalleryHavingFourVideosGiving200Status(){
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollPageWithJS(firstVideoWeight, 5);
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumList, 10, "Brd Crum List");
        String videoWeightUrl = commonFunctions.getCurrentURL();
        int videoSambandhitSize = sambandhitWidget.size();
        boolean isAllElementClickableTrue = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(sambandhitWidget, videoSambandhitSize, videoWeightUrl);
        return isAllElementClickableTrue && videoSambandhitSize == 4;
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
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, videoHindi);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("videos");
        String storyPageTitle = commonFunctions.getElementText(videoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(videoPageMainTitles.get(0), 10, storyPageTitle);
        String storyPageHeadline = commonFunctions.getElementText(storyHeadLine, 10);
        boolean openedRightStory = commonFunctions.compareTexts(storyPageTitle, storyPageHeadline);
        boolean isBreadCrumbContainsVideo = checkIfListContainsText(breadCrumbCurrentPage, videoHindi);
        boolean isTwitterIconDisplay = commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter icon");
        boolean isFacebookIconDisplay = commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook icon");
        commonFunctions.moveToElementWithActions(currnetStoryRelatedWidget, 10, currnetStoryRelatedWidget.getText());
        boolean isRelatedPageVideoGalleryTrue = commonFunctions.isElementDisplayed(currnetStoryRelatedWidget, 10, currnetStoryRelatedWidget.getText());
        return isLandingPageIsOfPhotos && openedRightStory && isBreadCrumbContainsVideo && isTwitterIconDisplay && isFacebookIconDisplay && isRelatedPageVideoGalleryTrue;
    }

    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElement(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public boolean checkIfListContainsText(List<WebElement> elementList, String expectedText) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedText)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkSocialSharingRedirectionAndGiving200OnVideoDetail(){
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollPageWithJS(firstVideoWeight, 5);
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumList, 10, "Brd Crum List");
        String videoWeightUrl = commonFunctions.getCurrentURL();
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySocialSharingRedirectionAndGiving200OnVideoDetail");
        boolean facebookFlag = commonFunctionsWebLH.validateSocialSharingIconFunctionality(socialSharingFaceBookIcon, params.get("Facebook"), videoWeightUrl, "Facebook");
        boolean twitterFlag = commonFunctionsWebLH.validateSocialSharingIconFunctionality(socialSharingTwitterIcon, params.get("Twitter"), videoWeightUrl, "Twitter");
        boolean hamefollowFlag = commonFunctionsWebLH.validateSocialSharingIconFunctionality(socialSharingHameFollowIcon, params.get("HameFlowKare"), videoWeightUrl, "HameFlowKare");
        return facebookFlag && twitterFlag && hamefollowFlag;
    }

    @Override
    public boolean checkVideoIsPlayingSuccessfullyOnVideoDetailPage() {
        navigateToVideoPage();
        commonFunctions.isElementDisplayed(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.scrollPageWithJS(firstVideoWeight, 5);
        commonFunctions.clickElementWithJS(firstVideoWeight, 5, "First Video Weight");
        commonFunctions.isElementDisplayed(brdCrumList, 10, "Brd Crum List");
        boolean playerStatue = commonFunctionsWebLH.validatePlayAndPauseButton(ytplayerFrame, videoState, player, "data-title-no-tooltip");
        return playerStatue;
    }
    public boolean checkVideoGalleryWidgetIsHaving5StoriesAndStatusIs200()
    {
        int videoGalleryWidgetSize = 5;
        navigateToVideoPage();
        commonFunctions.waitForPageToLoad();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(videoGallerySection,videoGalleryLinks,videoGalleryWidgetSize);
    }
}
