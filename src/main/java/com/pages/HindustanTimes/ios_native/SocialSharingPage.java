package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonSocialSharingPage;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SocialSharingPage extends CommonSocialSharingPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement hamburgerMenu;

//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='india'][1]")
//    private static MobileElement india;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='India']")
    private static MobileElement india;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='E-Paper']")
    private static MobileElement ePaperCTA;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='banner']/XCUIElementTypeOther[3]/XCUIElementTypeImage")
    private static WebElement homeEpaper;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Photos']")
    private static MobileElement photos;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Videos']")
    private static MobileElement videos;

    @iOSXCUITFindBy(id = "Videos")
    private static MobileElement videoOnVideosPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='play new'])[1]/preceding-sibling:: XCUIElementTypeStaticText")
    private static MobileElement videoStroyTitle;

    @iOSXCUITFindBy(id = "play new")
    private static MobileElement playButton;

    @iOSXCUITFindBy(accessibility = "Photos")
    private static MobileElement allPhoto;

    @iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[contains(@name,'Photos:')])[1]")
    private static MobileElement photoStory;

    @iOSXCUITFindBy(id = "back new")
    private static MobileElement backButton;

    @iOSXCUITFindBy(id="btn next enabled")
    private static MobileElement buttonnext;

    @iOSXCUITFindBy(id="share default")
    private static MobileElement shareDefault;

    @iOSXCUITFindBy(accessibility = "you may also like...")
    private static MobileElement youMayAlsoLike;

    @iOSXCUITFindBy(accessibility = "next story")
    private static MobileElement nextStory;

    @iOSXCUITFindBy(accessibility = "watch more...")
    private static MobileElement watchMore;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Tokyo')]")
    private static MobileElement sports;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Cities']")
    private static MobileElement cities;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Elections']")
    private static MobileElement elections;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Opinion']")
    private static MobileElement opinion;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='World']")
    private static MobileElement world;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'1/')]")
    private static MobileElement noOfNext;

    @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
    private static MobileElement storyText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Video')]")
    private static MobileElement videoPlayer;

    @iOSXCUITFindBy(id="Label")
    private static MobileElement storyContents;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='share whatsapp']/following-sibling:: XCUIElementTypeStaticText")
    private static MobileElement storyDetails;

    @iOSXCUITFindBy(id="play new")
    private static List<MobileElement> noOfVideos;

    @iOSXCUITFindBy(id="share default")
    private static List<MobileElement> shareDefaultList;

    @iOSXCUITFindBy(id="UIActivityContentView")
    private static MobileElement headLineOnShare;

    @iOSXCUITFindBy(id="AirDrop")
    private static MobileElement availableApps;

    @iOSXCUITFindBy(id="Done")
    private static MobileElement closeShareOptions;

    @iOSXCUITFindBy(id="Messages")
    private static MobileElement messages;

    @iOSXCUITFindBy(id="Cancel")
    private static MobileElement cancelMessages;

    @iOSXCUITFindBy(id="New Message")
    private static MobileElement newMessage;

    @iOSXCUITFindBy(id="return")
    private static MobileElement keyboardOnMessages;

    @iOSXCUITFindBy(id="Close")
    private static MobileElement closeShareWindow;

    @iOSXCUITFindBy(id="Label")
    private static MobileElement storyDetailPage;

    @iOSXCUITFindBy(id = "ht nav logo")
    private static MobileElement htLogo;


    private static String youMayAlsoLikeString="you may also like...";

    @iOSXCUITFindBy(id="Home")
    private static MobileElement home;

    @iOSXCUITFindBy(accessibility = "searchNav")
    private static MobileElement searchButton;

    @iOSXCUITFindBy(id = "twitter")
    private static MobileElement twitterOption;

    @iOSXCUITFindBy(id = "share whatsapp")
    private static MobileElement whatsappOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static MobileElement threeDots;

    @iOSXCUITFindBy(id = "Bookmark")
    private static MobileElement bottomActionSheet;

    @iOSXCUITFindBy(id = "Share")
    private static MobileElement shareStory;

    @iOSXCUITFindBy(id = "share day")
    private static MobileElement shareOpenStory;

    public SocialSharingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
       // Utils.logStepInfo("This is sttarted");
        /*commonFunctions.clickElementIfDisplayed(allowTracking,15,"Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 15, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(continueButton,30,"Continue Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,30,"Later Button");
        commonFunctions.clickElementIfDisplayed(skip,30,"Skip Button");
        commonFunctions.clickElementIfDisplayed(skip,30,"Skip Button");*/
        }


    @Override
    public boolean checkSocialSharingFunctionality() {
        return false;
    }

    public boolean checkShareFunctionality(){

        boolean verifyHeadlineOnShare=commonFunctions.isElementDisplayed(headLineOnShare,5,"headline on share");

        boolean verifyAvailableApp=commonFunctions.isElementDisplayed(availableApps,5,"Available apps for sharing");

        boolean tapOnAvailableApp=commonFunctions.clickElement(availableApps,5,"Clicked on available app");
        commonFunctions.dummyWait(10);
        boolean closeShare=commonFunctions.clickElement(closeShareOptions,5,"close share options");

        boolean clickMessages=commonFunctions.clickElement(messages,5,"Message");

        boolean checkKeyBoardOnMessagesScreen=commonFunctions.isElementDisplayed(newMessage,5,"Message app");

        boolean clickCancelOnMessages=commonFunctions.clickElement(cancelMessages,5,"Cancel button on message screen");

        boolean closeShareWindows=commonFunctions.clickElement(closeShareWindow,5,"close share window and land on home page");

        return  verifyHeadlineOnShare && clickMessages&& checkKeyBoardOnMessagesScreen && clickCancelOnMessages && verifyAvailableApp && tapOnAvailableApp && closeShare && closeShareWindows;
    }


    @Override
    public boolean checkSocialSharingWithWhatsappAndGmail() {

        //boolean checkSharingOption=checkSharingOption();
        commonFunctions.clickElement(home,5,"Home Tab");
        commonFunctions.clickElementIfDisplayed(threeDots,5,"Three DOts");
        boolean tapShare=commonFunctions.clickElement(shareStory,5,"Share icon");

        boolean checkSharingOnHome=checkShareFunctionality();

        boolean checkHomePage=commonFunctions.isElementDisplayed(htLogo,5,"Home page");

        commonFunctions.tapByCoordinate(180,360,"story page");
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");
        boolean onStoryPage=commonFunctions.isElementDisplayed(storyDetailPage,10,"Story page");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(threeDots,10,"Three DOts");
        boolean tapShareOpenStory=commonFunctions.clickElement(shareOpenStory,5,"Share icon");
        boolean checkSharingOnStory=checkShareFunctionality();
        commonFunctions.killAppAndReLaunch(notificationLater,4,"Later");
        return checkSharingOnHome && checkSharingOnStory && checkHomePage && onStoryPage && tapShare && tapShareOpenStory;
    }

    private boolean checkSharingOption() {
        boolean isStep=false;
        for(int i=0;i<2;i++)
        {
           isStep= commonFunctions.scrollToMobileElement(shareDefaultList.get(i));
        }

        return isStep;
    }

    @Override
    public boolean socialSharingInStoryPage(String params[]) {
        return false;
    }

    @Override
    public boolean checkSocialSharingIconsClickable() {
        return false;
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageBySearch() {
        commonFunctions.clickElement(home, 5, "Home button");
        commonFunctions.clickElement(searchButton, 5, "Search button");
        //commonFunctions.clickElement(searchPageStoryTitle, 60, "Search page first story");
        commonFunctions.clickElementWithCoordinates(280,340);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(skip,5,"Skip");
        boolean twitterDisplay = commonFunctions.isElementDisplayed(twitterOption, 10, "Twitter option on story page");
        boolean whatsappDisplay = commonFunctions.isElementDisplayed(whatsappOption, 10, "Whatsapp option on story page");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return twitterDisplay && whatsappDisplay;
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics() {
        return false;
    }
}
