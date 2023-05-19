package com.pages.HT_TECH.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HT_TECH.commonFunctions.CommonFunctionWebHT;
import com.pages.HT_TECH.generic.CommonVideoPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VideoPage extends CommonVideoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionWebHT commonFunctionsHt;
    public static VideoPage videoPage;
    public static VideoPage getInstance(){
        if(videoPage==null){
            videoPage= new VideoPage();
        }
        return videoPage;
    }

    @FindBy(xpath="//a[text()='VIDEOS']")
    private static WebElement video;

    @FindBy(xpath="//section[@class='topSectionWrapper']//a")
    private static List<WebElement> allTopStoriesLink;

    @FindBy(xpath="(//div[@class='rtCard'])[1]//a[@class='title']")
    private static List<WebElement> latestStories;

    @FindBy(xpath="(//div[@class='rtCard'])[2]//a[@class='parentWrapper']")
    private static List<WebElement> trendingStories;

    @FindBy(xpath="(//div[@class='storyContent'])[1]/h1")
    private static WebElement firstStoryHeadline;

    @FindBy(xpath="//div[@class= 'ltSide']/a[1]")
    private static WebElement firstVideoWidgit;

    @FindBy(xpath="(//div[@class='breadcrumb'])[1]/a")
    private static List<WebElement> brdCrumList;

    @FindBy(xpath="//iframe[@class='lazyload']")
    private static WebElement ytplayerFrame;

    @FindBy(xpath="//button[@class='ytp-play-button ytp-button']")
    private static WebElement videoState;

    @FindBy(xpath="(//div[@id='player'])[1]")
    private static WebElement player;

    @FindBy(xpath="(//a[contains(@class,'fbIcon fb  entry')])[1]")
    private static WebElement facebookIcon;

    @FindBy(xpath="(//a[contains(@class,'twIcon tw entry')])[1]")
    private static WebElement twitterIcon;

    @FindBy(xpath="(//a[contains(@class,'whatsAppIcon wp entry')])[1]")
    private static WebElement whatsappIcon;


    @Override
    public boolean checkVideoOnListingPage() {
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(video);
        int topStoriesSize = allTopStoriesLink.size();
        isAllElementClickableTrue =commonFunctionsHt.isElementClickableAndReturns200(allTopStoriesLink);
        return topStoriesSize == 10 && isAllElementClickableTrue;
    }
    @Override
    public boolean checkVideoDetailPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(video);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("videos");
        String storyPageTitle = commonFunctions.getElementText(firstVideoWidgit, 10);
        commonFunctions.clickElement(firstVideoWidgit, 10, storyPageTitle);
        String storyPageHeadline = commonFunctions.getElementText(firstStoryHeadline, 10);
        boolean openedRightStory = commonFunctions.compareTexts(storyPageTitle, storyPageHeadline);
        boolean isBreadCrumbContainsVideo = checkIfListContainsText(brdCrumList, "Videos");
        boolean isTwitterIconDisplay = commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter icon");
        boolean isFacebookIconDisplay = commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook icon");
        boolean isWhatsappIconDisplay = commonFunctions.isElementDisplayed(whatsappIcon, 10, "Whatsapp icon");
        return isFacebookIconDisplay && isWhatsappIconDisplay && isTwitterIconDisplay && openedRightStory && isBreadCrumbContainsVideo && isLandingPageIsOfPhotos;
    }
    public boolean checkIfListContainsText(List<WebElement> elementList, String expectedText) {
        for (WebElement webElement : elementList) {
            commonFunctions.moveToElementWithActions(webElement, 10, webElement.getText());
            if (webElement.getText().trim().contains(expectedText)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkTrendingStoriesOnVideoPage(){
        return commonFunctionsHt.checkRHSWidget(video,trendingStories,allTopStoriesLink,firstStoryHeadline);
    }
    @Override
    public boolean checkLatestStoriesOnVideoPage(){
        return commonFunctionsHt.checkRHSWidget(video,latestStories,allTopStoriesLink,firstStoryHeadline);

    }

    public VideoPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt=CommonFunctionWebHT.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }



}
