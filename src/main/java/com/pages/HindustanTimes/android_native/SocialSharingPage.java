package com.pages.HindustanTimes.android_native;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonSocialSharingPage;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import javax.rmi.CORBA.Util;

public class SocialSharingPage extends CommonSocialSharingPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(id = "com.ht.news:id/imagefav")
    private static MobileElement shareIcon;

    @AndroidFindBy(id = "android:id/content_preview_text")
    private static MobileElement storyHeadline;

    @AndroidFindBy(xpath = "//*[@text='News Feed']")
    private static MobileElement faceBookShare;

    @AndroidFindBy(xpath = "//*[@text='Tweet']")
    private static MobileElement twitterShare;

    @AndroidFindBy(xpath = "//*[@text='Share in a post']")
    private static MobileElement linkedInShare;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ht.news:id/title']")
    private static List<MobileElement> anyStory;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement afterClickStoryTitle;

    @AndroidFindBy(id = "com.ht.news:id/share_in_story")
    private static MobileElement storyShare;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static List<MobileElement> shareOption;

    @AndroidFindBy(id = "com.ht.news:id/imagefav")
    private static MobileElement shareViaOption;

    @AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_skip")
    private static MobileElement gmailSkipButton;

    @AndroidFindBy(id = "com.google.android.gm:id/setup_addresses_add_another")
    private static MobileElement addEmailAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Google']")
    private static MobileElement googleOption;

    @AndroidFindBy(id = "com.google.android.gm:id/suc_layout_title")
    private static MobileElement setupEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose Bluetooth device']")
    private static MobileElement chooseBluetoothDevice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private static MobileElement messageOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth']")
    private static MobileElement bluetoothOption;

    @AndroidFindBy(id = "android:id/button1")
    private static MobileElement turnOnButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Drive')]")
    private static MobileElement driveOption;

    @AndroidFindBy(id = "android:id/title")
    private static MobileElement shareTitle;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> storyTitles;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement storyDetailPage;

    @AndroidFindBy(accessibility = "Share")
    private static MobileElement topStoryShare;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WhatsApp']")
    private static MobileElement whatsappShare;

    @AndroidFindBy(id = "com.ht.news:id/toolbar")
    private static MobileElement homepage;

    @AndroidFindBy(id = "com.ht.news:id/whatsapp_share_in_story")
    private static MobileElement shareWithWhatsapp;

    @AndroidFindBy(accessibility = "Home")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static List<MobileElement> pageStoryList;

    @AndroidFindBy(id = "com.ht.news:id/topicChip")
    private static List<MobileElement> relatedTopicList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Related Topics']")
    private static MobileElement relatedTopic;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNewsButton;

    @AndroidFindBy(id = "com.ht.news:id/search")
    private static MobileElement searchButton;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static MobileElement searchPageStoryTitle;

    @AndroidFindBy(id = "com.ht.news:id/twitter_share_in_story")
    private static MobileElement twitterOption;

    @AndroidFindBy(id = "com.ht.news:id/whatsapp_share_in_story")
    private static MobileElement whatsappOption;

    @AndroidFindBy(id = "//android.widget.TextView[@text='Close']")
    private static MobileElement closeAppAdBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Share']")
    private static MobileElement shareOptionUnderThreeDots;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    private static MobileElement gmailShareOption;

    @AndroidFindBy(id = "com.ht.news:id/btn_cancel")
    private static MobileElement cancelInShareOption;

    @AndroidFindBy(id = "com.ht.news:id/bookmark")
    private static MobileElement bookMark;

    public SocialSharingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
//        commonFunctions.clickElement(skipButton, 5,);
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNewsButton, 5, "Start Reading News");
        /*commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(206, 1950);
        commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available*/
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }


    public boolean checkSharingOption() {
        int shareOptionCount = shareOption.size();
        boolean displayed = false;
        for (int i = 0; i < shareOptionCount; i++) {
            displayed = shareOption.get(i).isDisplayed();
        }
        Utils.logStepInfo(displayed, "Share Icon Displayed bottom of the story");
        Utils.logStepInfo(true,"displayed = "+displayed);
        return displayed;
    }

    public boolean availableShareOption() {
        boolean isBluetooth = commonFunctions.isElementDisplayed(bluetoothOption, 5, "Bluetooth Share Option");
        boolean isMessage = commonFunctions.isElementDisplayed(messageOption, 5, "Message Share Option");
        boolean isDrive = commonFunctions.isElementDisplayed(driveOption, 5, "Drive Share Option");
        Utils.logStepInfo(true,"isBluetooth = "+isBluetooth);
        Utils.logStepInfo(true,"isDrive = "+isDrive);
        Utils.logStepInfo(true,"isMessage = "+isMessage);
        return isBluetooth && isDrive && isMessage;
    }

    public boolean checkRedirectionToSelectedApp() {
        boolean isDisplayed = commonFunctions.isElementDisplayed(bluetoothOption, 5, "Bluetooth App");
        commonFunctions.clickElement(bluetoothOption, 5, "Bluetooth option");
        commonFunctions.clickElementIfDisplayed(turnOnButton, 5, "Turn On Button");
        boolean isDeviceDisplayed = commonFunctions.isElementDisplayed(chooseBluetoothDevice, 5, "Choose Bluetooh devices");
        commonFunctions.pressAndroidBackKey();
        return isDisplayed && isDeviceDisplayed;
    }

    public boolean checkHeadlineWithShareOption() {
        boolean isAppDisplayed = commonFunctions.isElementDisplayed(bluetoothOption, 5, "Bluetooth App");
        //boolean isHeadlineDisplayed = commonFunctions.isElementDisplayed(storyHeadline, 5, "Story Headline");
        boolean isShareDisplayed = commonFunctions.isElementDisplayed(shareTitle, 5, "Share Title");
        commonFunctions.pressAndroidBackKey();
        return isShareDisplayed && isAppDisplayed;
    }

    public boolean checkHomeStoryRedirection() {
        boolean isRedirectToStory = false;
        String actualTitle = storyTitles.get(0).getText().trim();
        Utils.logStepInfo(true,"actualTitle before open = "+actualTitle);
        commonFunctions.clickElement(storyTitles.get(0), 5, "First Story Title");
        commonFunctions.toGetRidOfAd(bookMark,5);
        commonFunctions.dummyWait(4);
        commonFunctions.clickByCoordinates(543, 515);
        isRedirectToStory = commonFunctions.getElementText(storyDetailPage, 5).equalsIgnoreCase(actualTitle);
        return isRedirectToStory;
    }


    @Override
    public boolean checkSocialSharingWithWhatsappAndGmail() {
        boolean checkSharingOption = checkSharingOption();
        commonFunctions.clickElement(shareOption.get(0), 5, "Three Dots in First Story");
        commonFunctions.clickElement(shareOptionUnderThreeDots,5,"Share Options under Three Dots");
        boolean isOptionDisplayed = availableShareOption();
        boolean homeStoryRedirection = checkRedirectionToSelectedApp();
        commonFunctions.clickElement(shareOptionUnderThreeDots, 5, "Share Options under Three Dots");
        boolean isHeadlineDisplayed = checkHeadlineWithShareOption();
        commonFunctions.clickElement(cancelInShareOption,5,"Cancel Option In Share Option");
        boolean isRedirection = checkHomeStoryRedirection();
        commonFunctions.clickElement(topStoryShare, 5, "Top share Icon");
        boolean checkAllShareOptionDisplayed = availableShareOption();
        boolean isStoryDetailRedirection = checkRedirectionToSelectedApp();
        commonFunctions.clickElement(topStoryShare, 5, "Top share Icon");
        boolean checkDetailStorySharing = checkHeadlineWithShareOption();
        Utils.logStepInfo(true,"checkSharingOption = "+checkSharingOption);
        Utils.logStepInfo(true,"isOptionDisplayed = "+isOptionDisplayed);
        Utils.logStepInfo(true,"isHeadlineDisplayed = "+isHeadlineDisplayed);
        Utils.logStepInfo(true,"isRedirection = "+isRedirection);
        Utils.logStepInfo(true,"homeStoryRedirection = "+homeStoryRedirection);
        Utils.logStepInfo(true,"checkAllShareOptionDisplayed = "+checkAllShareOptionDisplayed);
        Utils.logStepInfo(true,"isStoryDetailRedirection = "+isStoryDetailRedirection);
        Utils.logStepInfo(true,"checkDetailStorySharing = "+checkDetailStorySharing);

        return checkSharingOption && isOptionDisplayed && isHeadlineDisplayed && isRedirection && homeStoryRedirection &&
                checkAllShareOptionDisplayed && isStoryDetailRedirection && checkDetailStorySharing;
    }

    @Override
    public boolean checkSocialSharingFunctionality() {
        commonFunctions.clickElement(shareViaOption, 5, "Share Via Option");
        boolean isShareOption = checkRedirectionToSelectedApp();
        commonFunctions.clickElement(shareViaOption, 5, "Share Via Option");
        boolean isHeadline = checkHeadlineWithShareOption();
        boolean isRedirection = checkHomeStoryRedirection();
        commonFunctions.clickElement(topStoryShare, 5, "Top share Icon");
        boolean isStoryShare = checkRedirectionToSelectedApp();
        commonFunctions.clickElement(topStoryShare, 5, "Top share Icon");
        boolean isRedirectionHeadline = checkHeadlineWithShareOption();
        return isRedirection && isHeadline && isRedirectionHeadline && isShareOption && isStoryShare;
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
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(searchButton, 5, "Search button");
        commonFunctions.clickElement(searchPageStoryTitle, 5, "Search page first story");
        commonFunctions.toGetRidOfAd(bookMark,5);
        boolean twitterDisplay = commonFunctions.isElementDisplayed(twitterOption, 5, "Twitter option on story page");
        boolean whatsappDisply = commonFunctions.isElementDisplayed(whatsappOption, 5, "Whatsapp option on story page");
        return twitterDisplay && whatsappDisply;
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(pageStoryList.get(0), 5, "First Story of the current page");
        commonFunctions.clickElementIfDisplayed(closeAppAdBtn,5,"Another application close button");
        Utils.logStepInfo("Click of skip button should be performed to continue further app interaction.");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(649, 514);
        boolean relatedTopicDisplay = commonFunctions.scrollDownToElement(relatedTopic,homeButton);
        commonFunctions.clickElement(relatedTopicList.get(0), 5, "First topic from Related Topic");
        commonFunctions.clickElement(pageStoryList.get(0), 5, "First Story of the current page");
        boolean twitterDisplay = commonFunctions.isElementDisplayed(twitterOption, 5, "Twitter option on story page");
        boolean whatsappDisply = commonFunctions.isElementDisplayed(whatsappOption, 5, "Whatsapp option on story page");

        return twitterDisplay && whatsappDisply && relatedTopicDisplay;
    }

}
