package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonInlineStoriesPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;

public class InlineStoriesPage extends CommonInlineStoriesPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> listOfHeadLines;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static List<MobileElement> tapOnStory;

    @AndroidFindBy(id = "com.ht.news:id/img_news")
    private static MobileElement leadImage;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private static MobileElement backButton;

    @AndroidFindBy(id = "com.ht.news:id/ad_view")
    private static List<MobileElement> ads;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static MobileElement redirectionToHome;

    @AndroidFindBy(id = "//com.ht.news:id/moreFromSectionTv") //com.ht.news:id/afterArticleWidgetTv
    private static MobileElement youMayLikeAlso;

    @AndroidFindBy(id = "com.ht.news:id/swipeUpHint")
    private static MobileElement nextStory;

    @AndroidFindBy(id = "com.ht.news:id/tv_advertisement")
    private static List<MobileElement> AdvAtTheEndOfStory;

    @AndroidFindBy(id = "instagram-embed-0")
    private static MobileElement embedsInStory;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement headLine;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.ht.news:id/titleTv'])[1]")
    private static MobileElement homeTitle;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement summary;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private static MobileElement exploreMenu;

    @AndroidFindBy(id = "com.ht.news:id/search_tv")
    private static MobileElement searchField;

    @AndroidFindBy(id = "com.ht.news:id/search_drawer")
    private static MobileElement searchTab;

    @AndroidFindBy(id = "com.ht.news:id/txt_news_headline")
    private static List<MobileElement> listOfStories;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='search']")
    private static MobileElement searchBar;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ht.news:id/ad_view_320_100']")
    private static MobileElement headerAd;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']/android.widget.ImageView")
    private static MobileElement homeButton;


    public InlineStoriesPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(206, 1950);
        commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }


    public boolean checkHomePageLoadedProperly(){
        return commonFunctions.isElementDisplayed(headerAd,5,"HomePage Properly Loaded");
    }

    public boolean checkClickOnStoryAndRedirection() {
        String text = commonFunctions.getElementText(listOfHeadLines.get(0), 5);
        commonFunctions.clickElement(tapOnStory.get(0), 5, "Story");
        String title = commonFunctions.getElementText(headLine, 5);
        return title.equalsIgnoreCase(text);
    }

    public boolean checkStoryCompletelyLoaded() {
        return commonFunctions.isElementDisplayed(summary, 5, "Storypage completely loaded");
    }

    public boolean scrollTopToBottomOfStory() {
        int sizeOfAd = AdvAtTheEndOfStory.size();
        commonFunctions.scrollUpToElementDisplayed(AdvAtTheEndOfStory.get(sizeOfAd - 1));
        Utils.logStepInfo(true, AdvAtTheEndOfStory.get(sizeOfAd - 1) + " available");
        return commonFunctions.isElementDisplayed(AdvAtTheEndOfStory.get(sizeOfAd - 1));

    }

    public boolean checkAdvisibiltyAtEndOfStory() {
        int sizeOfAd = AdvAtTheEndOfStory.size();
        return commonFunctions.isElementDisplayed(AdvAtTheEndOfStory.get(sizeOfAd - 1), 5, "Advertisement is visible at the end of story");
    }

    public boolean checkNextStoryDisplayed() {
        commonFunctions.scrollToTillVisibleText("next story", "next story", 5);
        return commonFunctions.isElementDisplayed(nextStory, 5, "next Story");
    }

    public boolean checkYouMayLikeSection() {
//        commonFunctions.scrollToTillVisibleText("you may also like...","you may also like...",35);
        commonFunctions.scrollUpToElementDisplayed(youMayLikeAlso);
        return commonFunctions.isElementDisplayed(youMayLikeAlso, 5, "You may also like section");
    }


    public boolean checkRedirectionToHomePage() {
        commonFunctions.clickElement(backButton, 5);
        return commonFunctions.isElementDisplayed(redirectionToHome, 5, "Back to Home Page");
    }

    @Override
    public boolean checkInlineStoriesCases(String uri, String address) {
        commonFunctions.clickElement(homeButton,5,"HomePage");
        boolean homePageLoading = checkHomePageLoadedProperly();
        boolean clickOnStory = checkClickOnStoryAndRedirection();
        boolean storyCompletelyLoaded = checkStoryCompletelyLoaded();
        boolean scrollToBottomOfStory = commonFunctions.scrollToBottomForAndroidNative();//scrollTopToBottomOfStory();
        boolean advAtTheEndOfStory = checkAdvisibiltyAtEndOfStory();
        boolean nextStory = checkNextStoryDisplayed();
        boolean youMayAlsoLike = checkYouMayLikeSection();
        boolean redirectToHome = checkRedirectionToHomePage();


        return homePageLoading && clickOnStory && storyCompletelyLoaded &&
                scrollToBottomOfStory && advAtTheEndOfStory && nextStory && youMayAlsoLike && redirectToHome;
    }

    @Override
    public boolean checkInlineStoriesOpening() {
        return false;
    }

}
