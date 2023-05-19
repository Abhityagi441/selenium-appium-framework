package com.pages.HindustanTimes.android_native;

import java.util.List;

import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonSearchPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage extends CommonSearchPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static ApiValidation apiValidation;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private static MobileElement hamBurger;

    @AndroidFindBy(id = "com.ht.news:id/searchLayout")
    private static MobileElement searchField;

    @AndroidFindBy(id = "com.ht.news:id/navigation_cricket")
    private static MobileElement cricketOnBottomNav;

    @AndroidFindBy(id = "com.ht.news:id/navigation_premium")
    private static MobileElement premiumOnBottomNav;

    @AndroidFindBy(id = "com.ht.news:id/navigation_quickread")
    private static MobileElement quickreadOnBottomNav;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id='com.ht.news:id/innerLayout'])[1]")
    private static MobileElement searchBar;

    @AndroidFindBy(id = "com.ht.news:id/txtSearchResultCount")
    private static MobileElement resultCountPerPage;

    @AndroidFindBy(className = "android.widget.LinearLayout")
    private static MobileElement relatedStory;

    @AndroidFindBy(id = "com.ht.news:id/dismiss")
    private static MobileElement dismissButton;


    @AndroidFindBy(id = "com.ht.news:id/search_bar")
    private static MobileElement searchIcon;

    @AndroidFindBy(id = "com.ht.news:id/search_drawer")
    private static MobileElement searchTab;

    @AndroidFindBy(id = "com.ht.news:id/txt_news_headline")
    private static List<MobileElement> listOfStories;

    @AndroidFindBy(id = "com.ht.news:id/layoutParent")
    private static List<MobileElement> listOfStoriesOnLatestNewsPage;

    @AndroidFindBy(id = "com.ht.news:id/titleSubSection")
    private static List<MobileElement> listOfSubSectionsInSearchStoriesPage;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement headLine;

    @AndroidFindBy(id = "com.ht.news:id/img_news")
    private static MobileElement leadImage;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement caption;

    @AndroidFindBy(id = "android.view.View")
    private static List<MobileElement> paragraph;

    @AndroidFindBy(id = "com.ht.news:id/paragraphTv")
    private static MobileElement storyParagraph;

    @AndroidFindBy(id = "com.ht.news:id/viewAllTv")
    private static MobileElement viewAllOnSearchPage;

    @AndroidFindBy(id = "com.ht.news:id/txt_caption")
    private static MobileElement storyCaption;

    @AndroidFindBy(id = "com.ht.news:id/img_news")
    private static MobileElement storyImage;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement storyHeadline;

    @AndroidFindBy(id = "com.ht.news:id/img_share")
    private static MobileElement shareIcon;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='ad-container']")
    private static MobileElement AdvertisementAtBottom;

    @AndroidFindBy(id = "com.ht.news:id/bookmark")
    private static MobileElement bookMark;

    @AndroidFindBy(id = "com.ht.news:id/navigation_home_section")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement searchHeader;

    @AndroidFindBy(id = "com.ht.news:id/bottomNavView")
    private static MobileElement bottomNav;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement latestNewsHeader;

    @AndroidFindBy(id = "com.ht.news:id/recent_notification1")
    private static MobileElement latestNewsSubHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='World']")
    private static MobileElement worldNewsOnHomeHeader;

    @AndroidFindBy(id = "com.ht.news:id/etSearch")
    private static MobileElement searchTextBox;

    @AndroidFindBy(id = "com.ht.news:id/search")
    private static MobileElement searchButton;

    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreButton;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement sectionPageHeader;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Profile']/android.widget.ImageView")
    private static MobileElement profile;

    @AndroidFindBy(id = "com.ht.news:id/profile")
    private static MobileElement profileButton;

    @AndroidFindBy(id = "com.ht.news:id/ep_txt")
    private static MobileElement ePaper;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Chrome')]")
    private static MobileElement chromeOption;

    @AndroidFindBy(id = "android:id/button_once")
    private static MobileElement onceOptionWeb;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private static MobileElement epaperMwebUrlBar;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private static MobileElement epaperWebUrlBox;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Hindustan Time epaper 13 Feb 2022']/android.widget.Image")
    private static MobileElement htEpaperWebLogo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Cricket']")
    private static MobileElement cricketOption;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private static MobileElement back;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Top News']")
    private static MobileElement topNewsSection;

    @AndroidFindBy(id = "com.ht.news:id/etSearch")
    private static MobileElement searchInputTextBox;

    @AndroidFindBy(id = "com.ht.news:id/tv_titleResults")
    private static MobileElement searchResultsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'News']")
    private static MobileElement newsLabelOnSearchResultPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Photos']")
    private static MobileElement photosLabelOnSearchResultPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Videos']")
    private static MobileElement videosLabelOnSearchResultPage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'Type here to search news, photos, videos…']")
    private static MobileElement waterMarkTextInSearch;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text = 'India News']")
    private static MobileElement textEnterInSearchTextBox;

    @AndroidFindBy(id = "com.ht.news:id/navigation_quickread")
    private static MobileElement quickreadsButton;

    @AndroidFindBy(id = "com.ht.news:id/tvQuickreadsNextStory")
    private static MobileElement quickreadsPageElement;

    @AndroidFindBy(id = "com.ht.news:id/navigation_premium")
    private static MobileElement premiumButton;

    @AndroidFindBy(id = "com.ht.news:id/viewbg")
    private static List<MobileElement> horizontalLineInEachStory;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static List<MobileElement> threeDotButton;

    @AndroidFindBy(id = "com.ht.news:id/share_layout")
    private static MobileElement shareOptionInThreeDot;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static List<MobileElement> listOfStoriesInSearchPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Photos' and @selected = 'true']")
    private static MobileElement photosTabAsSelected;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> listOfStoriesInSearch;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement storyTitle;

    @AndroidFindBy(id = "com.ht.news:id/tv_titleAlsoLike")
    private static MobileElement titleAlsoLikeInSearchResult;

    @AndroidFindBy(id = "com.ht.news:id/trendingTopics")
    private static MobileElement latestTopicsInSearchPage;

    @AndroidFindBy(id ="com.ht.news:id/topicChip")
    private static List<MobileElement> listOfLatestTopicsStories;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    public SearchPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
//        commonFunctions.clickElement(skipButton, 10);
        /*commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(206, 1950);
        commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available
        */apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }

    @Override
    public boolean clickOnExplorerMenu() {
        return false;
    }

    @Override
    public boolean clickOnEntertainmentSection() {
        return false;
    }

    @Override
    public boolean checkRedirectionToEntertainmentSection() {
        return false;
    }


    @Override
    public boolean checkSearchIsWorking(String text) {
        return false;
    }

    @Override
    public boolean CheckSearchButtonIsWorking(String[] params) {
        return false;
    }

    public boolean clickOnSearchOption() {

        boolean isSearchIsWorking;
        //commonFunctions.clickElement(hamBurger, 5, "Hamburger Option");
        isSearchIsWorking = commonFunctions.clickElement(searchField, 5, "Search Option");
        commonFunctions.clickElement(searchBar, 5);
        boolean isKeyboardShown = commonFunctions.OpenKeyBoard();
        if (isKeyboardShown) {
            commonFunctions.textToReport("KeyBoard is Shown");
        } else {
            commonFunctions.textToReport("KeyBoard is Not Shown");
        }
        return isSearchIsWorking;
    }

    public boolean checkSearchButtonDisplayedAndClickable(String params[]) {
        boolean isTextDisplayed = false;
        commonFunctions.sendKeyWithAction("Engine", "Entered search text");
        //press enter key is not working
        commonFunctions.pressEnterKey();
        //locator not available for resultCountPerPage
        commonFunctions.isElementDisplayed(resultCountPerPage, 5, "result count per page");
        String textFound = resultCountPerPage.getText();
        //api part pending
        apiValidation.response = apiValidation.getResponseFromURI(params[0], params[6]);
        String valueBackend = JsonPath.parse(apiValidation.response.getBody().asString()).read("$.content.itemsperpage");
        isTextDisplayed = textFound.equalsIgnoreCase(valueBackend + "+ items found");
        return isTextDisplayed;
    }

    @Override
    public boolean checkSearchIsWorking(String params[]) {
        boolean clickOnSearchOption = clickOnSearchOption();
        boolean checkSearchButtonDisplayedAndClickable = checkSearchButtonDisplayedAndClickable(params);
        commonFunctions.pressAndroidBackKey();


        return checkSearchButtonDisplayedAndClickable && clickOnSearchOption;

    }

    @Override
    public boolean checkSearchButtonRedirection() {
        commonFunctions.clickElementIfDisplayed(homeButton, 5, "Home Button");
        Utils.logStepInfo("I Click on Search Option tab to open Search Page.");
        commonFunctions.clickElement(searchField, 5, "Search option");
        boolean searchButtonRedirection = commonFunctions.isElementDisplayed(searchHeader, 5, "Search Page Header");

        return searchButtonRedirection;
    }

    @Override
    public boolean checkSearchPageRedirectionFromExplore() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(exploreButton, 5, "Home button");
        commonFunctions.clickElement(searchButton, 5, "Search button on top of explore page");
        return commonFunctions.getElementText(sectionPageHeader, 5).contains("SEARCH");
    }

    @Override
    public boolean checkSearchButtonRedirectionProfilePage() {
        commonFunctions.clickElementIfDisplayed(homeButton, 5, "Home Button");
        commonFunctions.clickElement(profile, 5, "Profile");
        commonFunctions.clickElement(searchField, 5, "Search option");
        Utils.logStepInfo("Click on Search Option to open Search Page.");
        return commonFunctions.isElementDisplayed(searchHeader, 5, "Search Page Header");
    }

    @Override
    public boolean checkEPaperOption() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(ePaper, 5, "E-paper on top");
        commonFunctions.clickElement(chromeOption, 5, "Select chrome option for web");
        commonFunctions.clickElement(onceOptionWeb, 5, "Select once option for web");
        commonFunctions.changeDriverContextToWeb();
        boolean isEpaperWebOpened = commonFunctions.isElementDisplayed(epaperWebUrlBox, 5, "Epaper Url box");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.changeDriverContextToNative();
        return isEpaperWebOpened;
    }

    @Override
    public boolean checkEPaperOptionFromExplore() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(exploreButton, 5, "Profile button");
        commonFunctions.clickElement(ePaper, 5, "E-paper on top");
        commonFunctions.clickElement(chromeOption, 5, "Select chrome option for web");
        commonFunctions.clickElement(onceOptionWeb, 5, "Select once option for web");
        commonFunctions.changeDriverContextToWeb();
        boolean isEpaperWebOpened = commonFunctions.isElementDisplayed(epaperWebUrlBox, 5, "Epaper Url box");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.changeDriverContextToNative();
        return isEpaperWebOpened;
    }

    @Override
    public boolean checkSearchOptionInCricketPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(cricketOption,5,"Cricket Option");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchField,5,"Search option");
        if(isSearchOptionDisplayed) {
            commonFunctions.clickElement(searchField, 5, "Search option");
        }
        boolean IsSearchPageHeader = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        return isSearchOptionDisplayed && IsSearchPageHeader;
    }

    @Override
    public boolean checkSearchOptionWhenTabOnBackButton() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        if(isSearchPageDisplayed){
            commonFunctions.clickElement(back,5,"Back Button");
        }
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage;
    }

    @Override
    public boolean checkStoryPageOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        commonFunctions.clickElementIfDisplayed(listOfStoriesOnLatestNewsPage.get(0),20,"Click on First story on Latest news page");
        commonFunctions.dummyWait(10);
        boolean isStoryDisplayed= commonFunctions.isElementDisplayed(storyCaption,10,"Story Caption") && commonFunctions.isElementDisplayed(storyImage,10,"Story Image") && commonFunctions.isElementDisplayed(storyHeadline,10,"Story Headline");
        commonFunctions.scrollUntilElementFound(storyParagraph);
        boolean isParagraphDisplayed = commonFunctions.isElementDisplayed(storyParagraph,20,"Paragraph displayed");
        commonFunctions.clickByCoordinates(646,503,"Click on Skip button on Bookmark page");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeButton,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage && isStoryDisplayed && isParagraphDisplayed;
    }

    @Override
    public boolean checkViewAllOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        commonFunctions.clickElementIfDisplayed(viewAllOnSearchPage,10,"click on View All link on Search page");
        boolean isLatestNewsPageDisplayed=commonFunctions.getElementText(latestNewsHeader,10).equalsIgnoreCase("LATEST NEWS");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeButton,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage && isLatestNewsPageDisplayed;
    }

    @Override
    public boolean checkDefaultLatestNewsOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        boolean isLatestNewsPageDisplayed= commonFunctions.getElementText(latestNewsSubHeader,10).equalsIgnoreCase("Latest News");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(homeButton,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage && isLatestNewsPageDisplayed;
    }

    @Override
    public boolean checkCricketNewsOnSearchPage() {
        boolean isSubsectionCricketDispalyed=false;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElementIfDisplayed(worldNewsOnHomeHeader,20,"World section from header");
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElementIfDisplayed(searchInputTextBox,20,"Click on Search box");
        commonFunctions.sendKeysOnAndroid(searchInputTextBox,"Cricket");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(986,2083,"Enter Key");
        commonFunctions.dummyWait(5);
        isSubsectionCricketDispalyed = listOfSubSectionsInSearchStoriesPage.get(0).getText().equalsIgnoreCase("Cricket");
        return isSubsectionCricketDispalyed;
    }

    @Override
    public boolean checkSearchIsWorkingOnSearchPage() {
        boolean isSearchWorking=true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElementIfDisplayed(searchInputTextBox,20,"Click on Search box");
        commonFunctions.sendKeysOnAndroid(searchInputTextBox,"Cricket");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(986,2083,"Enter Key");
        commonFunctions.dummyWait(5);
        isSearchWorking = listOfSubSectionsInSearchStoriesPage.get(0).getText().equalsIgnoreCase("Cricket");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(homeButton,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchWorking && isHomePage;
    }

    public boolean checkLensIconTextBoxAndVoiceIcon() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        boolean isSearchTextBox = commonFunctions.isElementDisplayed(searchInputTextBox,5,"Search text Box");
        return isSearchPageDisplayed && isSearchTextBox;
    }

    @Override
    public boolean checkWatermarkRemovedIfEnterAnyChar() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isWanterMarkTextInSearchBox = commonFunctions.isElementDisplayed(waterMarkTextInSearch,5,"TextBox with water amrk in Search");
        commonFunctions.sendKeysOnAndroid(searchInputTextBox,"India News");
        boolean isWaterMarkRemoved = !commonFunctions.isElementDisplayed(waterMarkTextInSearch,5,"Water Mark Text");
        isWaterMarkRemoved &= commonFunctions.isElementDisplayed(textEnterInSearchTextBox,5,"Entered Text");
        return isWanterMarkTextInSearchBox && isWaterMarkRemoved;
    }

    @Override
    public boolean checkNewsPhotosVideosLabelsOnSearchPage() {
        boolean isLabelDisplayed;
        isLabelDisplayed = NewsPhotosVideosLabelsOnSearchPage("Cricket");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(homeButton,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isLabelDisplayed && isHomePage;
    }

    @Override
    public boolean checkDefaultNewsDisplayedOnSearchPage() {
        boolean isLabelDisplayed;
        isLabelDisplayed = NewsPhotosVideosLabelsOnSearchPage("Cricket");
        boolean isNewsSelected= commonFunctions.isElementSelected(newsLabelOnSearchResultPage,10,"News label");
        boolean isPhotosSelected= commonFunctions.isElementSelected(photosLabelOnSearchResultPage,10,"Photos label");
        return isNewsSelected && !isPhotosSelected && isLabelDisplayed;
    }

    @Override
    public boolean checkNumberOfSearchResultsDisplayedOnSearchPage(String expectedMessage) {
        boolean isLabelDisplayed;
        isLabelDisplayed = NewsPhotosVideosLabelsOnSearchPage("Cricket");
        String actualMessage= commonFunctions.getElementText(searchResultsTitle,10);
        actualMessage=actualMessage.replaceAll("[0-9]","").replace("  "," ");
        isLabelDisplayed=actualMessage.equalsIgnoreCase(expectedMessage);
        return isLabelDisplayed && isLabelDisplayed;
    }

    @Override
    public boolean checkStoryTappableOnSearchPage() {
        boolean isSearchPageDisplayed=commonFunctions.navigateToSearchResultPage("Cricket",homeButton,searchField,searchHeader,searchInputTextBox,986,2083);
        commonFunctions.clickElementIfDisplayed(listOfStoriesOnLatestNewsPage.get(0),20,"Click on First story on Latest news page");
        commonFunctions.dummyWait(5);
        boolean isStoryDisplayed= commonFunctions.isElementDisplayed(storyCaption,10,"Story Caption") && commonFunctions.isElementDisplayed(storyImage,10,"Story Image") && commonFunctions.isElementDisplayed(storyHeadline,10,"Story Headline");
        commonFunctions.scrollUntilElementFound(storyParagraph);
        boolean isParagraphDisplayed = commonFunctions.isElementDisplayed(storyParagraph,20,"Paragraph displayed");
        commonFunctions.clickByCoordinates(646,503,"Click on Skip button on Bookmark page");
        return isSearchPageDisplayed && isStoryDisplayed && isParagraphDisplayed;
    }

    @Override
    public boolean checkSearchOptionOnHomePage() {
        commonFunctions.clickElement(homeButton,5,"Home Button");
        boolean isHomePageDisplayed = commonFunctions.isElementDisplayed(homeButton,5,"Home Page");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchButton,5,"After E-Paper option Search Option");
        return isHomePageDisplayed && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSearchOptionOnQuickreadsPage() {
        boolean isQuickreadsPageTabHighlighted = checkSelectedBottomNavTab(quickreadsButton, "Quickreads tab");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchButton,5,"After E-Paper option Search Option");
        return isQuickreadsPageTabHighlighted && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSelectedBottomNavTab(MobileElement ele, String text) {
        commonFunctions.clickElement(homeButton,5,"Home Button");
        commonFunctions.clickElement(ele,5,text);
        boolean isBottomNavTabSelected = commonFunctions.isElementSelected(ele,5,text);
        return isBottomNavTabSelected;
    }
    @Override
    public boolean checkSearchOptionOnPremiumPage() {
        boolean isPremiumPageTabHighlighted = checkSelectedBottomNavTab(premiumButton,"Premium tab");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchButton,5,"After E-Paper option Search Option");
        return isPremiumPageTabHighlighted && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSearchOptionOnExplorePage() {
        boolean isExplorePageTabHighlighted = checkSelectedBottomNavTab(exploreButton,"Explore tab");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchButton,5,"After E-Paper option Search Option");
        return isExplorePageTabHighlighted && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSearchOnCricketPage() {
        boolean isSearchWorking=false;
        boolean isSearchPageDisplayed=commonFunctions.navigateToSectionResultPage("Cricket",cricketOnBottomNav,homeButton,searchField,searchHeader,searchInputTextBox,986,2083);
        commonFunctions.dummyWait(10);
        isSearchWorking = listOfSubSectionsInSearchStoriesPage.get(0).getText().equalsIgnoreCase("Cricket");
        return isSearchWorking && isSearchPageDisplayed;
    }

    @Override
    public boolean checkSearchOnPremiumPage() {
        boolean isSearchWorking=true;
        boolean isSearchPageDisplayed=commonFunctions.navigateToSectionResultPage("Cricket",premiumOnBottomNav,homeButton,searchField,searchHeader,searchInputTextBox,986,2083);
        commonFunctions.dummyWait(10);
        isSearchWorking = listOfSubSectionsInSearchStoriesPage.get(0).getText().equalsIgnoreCase("Cricket");
        return isSearchWorking && isSearchPageDisplayed;
    }

    @Override
    public boolean checkSearchOnQuickReadsPage() {
        boolean isSearchWorking=true;
        boolean isSearchPageDisplayed=commonFunctions.navigateToSectionResultPage("Cricket",quickreadOnBottomNav,homeButton,searchField,searchHeader,searchInputTextBox,986,2083);
        commonFunctions.dummyWait(10);
        isSearchWorking = listOfSubSectionsInSearchStoriesPage.get(0).getText().equalsIgnoreCase("Cricket");
        return isSearchWorking && isSearchPageDisplayed;
    }

    @Override
    public boolean checkSearchOnHomePage() {
        boolean isSearchWorking=true;
        boolean isSearchPageDisplayed=commonFunctions.navigateToSearchResultPage("Cricket",homeButton,searchField,searchHeader,searchInputTextBox,986,2083);
        commonFunctions.dummyWait(10);
        isSearchWorking = listOfSubSectionsInSearchStoriesPage.get(0).getText().equalsIgnoreCase("Cricket");
        return isSearchWorking && isSearchPageDisplayed;
    }

    @Override
    public boolean checkBottomNavOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(searchField, 5, "Search Option");
        boolean IsSearchPageHeader = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        commonFunctions.hideKeyboard();
        boolean isBottomNavDisplayed = commonFunctions.isElementDisplayed(bottomNav, 10, "Bottom Nav");
        return IsSearchPageHeader && isBottomNavDisplayed;
    }

    @Override
    public boolean checkBottomNavNavigationOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(searchField, 5, "Search Option");
        boolean IsSearchPageHeader = commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        commonFunctions.hideKeyboard();
        boolean isBottomNavDisplayed = commonFunctions.isElementDisplayed(bottomNav, 10, "Bottom Nav");
        commonFunctions.clickElementIfDisplayed(quickreadsButton,10,"QuickRead from Bottom Nav");
        commonFunctions.dummyWait(10);
        boolean isQuickReadPageDisplayed= commonFunctions.isElementDisplayed(quickreadsPageElement,10,"QuickRead page Element");
        boolean isQuickReadPageSelected= commonFunctions.isElementSelected(quickreadsButton,10,"QuickRead buttom nav button");
        return IsSearchPageHeader && isBottomNavDisplayed && isQuickReadPageDisplayed && isQuickReadPageSelected;
    }

    @Override
    public boolean checkHorizontalLineInEachStoryInNewsOnSearchPage() {
        boolean isLabelDisplayed;
        isLabelDisplayed = NewsPhotosVideosLabelsOnSearchPage("Cricket");
        boolean isHorizontalLineInEachStory = false;
        if(horizontalLineInEachStory.size() >3){
            isHorizontalLineInEachStory = true;
            Utils.logStepInfo(true,"Horizontal Lines are found in Each Story in search page");
        }
        else{
            Utils.logStepInfo(false,"Horizontal Lines are not found in Each Story in search page");
        }
        return isLabelDisplayed && isHorizontalLineInEachStory;
    }

    @Override
    public boolean checkShareStoryOptionInSearchPage() {
        return commonFunctions.checkShareOptionInFirstStoryInPage(homeButton,searchField,threeDotButton,shareOptionInThreeDot);
    }

    @Override
    public boolean checkRedirectToSectionFromSearchPage() {
        boolean isSearchPageDisplayed = commonFunctions.navigateToSearchResultPage("Cricket",homeButton,searchField,searchHeader,searchInputTextBox,986,2083);
        String subSectionName = commonFunctions.getElementText(listOfSubSectionsInSearchStoriesPage.get(0),5);
        commonFunctions.clickElement(listOfSubSectionsInSearchStoriesPage.get(0),5,"Click on Sub Section");
        boolean isRedirectToSubsection = commonFunctions.getElementText(sectionPageHeader,5).equalsIgnoreCase(subSectionName);
        return isSearchPageDisplayed && isRedirectToSubsection;
    }

    @Override
    public boolean checkScrollDownInNewsSectionINSearchPage() {
        boolean isSearchWorking = true;
        boolean isSearchPageDisplayed = commonFunctions.navigateToSearchResultPage("Cricket",homeButton,searchField,searchHeader,searchInputTextBox,986,2083);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownByCoordinates(cricketOnBottomNav,425,1760,429,720);
        System.out.println("Total - " +listOfSubSectionsInSearchStoriesPage.size()+ " SubSubsections are available");
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                System.out.println(i+1 + "time Sub Section is matching");
                isSearchWorking &= true;
            }
            else{
                System.out.println(i+1 + "time sub section name is not matching");
            }
        }
        return isSearchPageDisplayed && isSearchWorking;
    }

    @Override
    public boolean checkRedirectToPhotosInSearchPage() {
        return commonFunctions.redirectToPhotosTabInSearchPage(homeButton,searchField,searchHeader,searchInputTextBox,986,2083,photosLabelOnSearchResultPage,listOfStoriesInSearchPage);
    }

    @Override
    public boolean checkPhotosOptionDisplayedAsSelectedInSearchPage() {
        boolean isRedirectToPhotosTab = commonFunctions.redirectToPhotosTabInSearchPage(homeButton,searchField,searchHeader,searchInputTextBox,986,2083,photosLabelOnSearchResultPage,listOfStoriesInSearchPage);
        boolean isPhotosTabSelected = commonFunctions.getAtribute(photosLabelOnSearchResultPage,"selected").equalsIgnoreCase("true");
        return isRedirectToPhotosTab && isPhotosTabSelected;
    }

    @Override
    public boolean checkNumberOfResultInPhotosOnSearchPage(String expectedMessage) {
        boolean isRedirectToPhotosTabInSearch = commonFunctions.redirectToPhotosTabInSearchPage(homeButton,searchField,searchHeader,searchInputTextBox,986,2083,photosLabelOnSearchResultPage,listOfStoriesInSearchPage);
        boolean isNumberOfResultInPhotos = commonFunctionsMobile.verifySearchResultsDisplayedOnSearchPage(expectedMessage,searchResultsTitle);
        return isRedirectToPhotosTabInSearch && isNumberOfResultInPhotos;
    }

    @Override
    public boolean checkRedirectToStoryFromPhotosInSearchPag() {
        boolean isRedirectToPhotosTab = checkPhotosOptionDisplayedAsSelectedInSearchPage();
        String firstStory = listOfStoriesInSearch.get(0).getText();
        System.out.println("First Story Heading is --- " + firstStory);
        commonFunctions.clickElement(listOfStoriesInSearch.get(0),5,"Click on First Story");
        commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isStoryTitle = commonFunctions.getElementText(storyTitle, 10).equalsIgnoreCase(firstStory);
        return isStoryTitle && isRedirectToPhotosTab;
    }

    @Override
    public boolean checkRedirectToVideosInSearchPage() {
        return commonFunctionsMobile.redirectToTabInSearchPage(videosLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage,"Cricket");
    }

    @Override
    public boolean checkVideosOptionDisplayedAsSelectedInSearchPage() {
        Boolean isRedirectToVideosTab = commonFunctionsMobile.redirectToTabInSearchPage(videosLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "Cricket");
        boolean isVideosTabSelected = commonFunctions.getAtribute(videosLabelOnSearchResultPage,"selected").equalsIgnoreCase("true");
        Utils.logStepInfo(true, "isRedirectToVideosTab = "+isRedirectToVideosTab);
        Utils.logStepInfo(true, "isVideosTabSelected = "+isVideosTabSelected);
        return isRedirectToVideosTab && isVideosTabSelected;
    }

    @Override
    public boolean checkNumberOfResultInVideosOnSearchPage(String expectedMessage) {
        boolean isRedirectToVideosTab = commonFunctionsMobile.redirectToTabInSearchPage(videosLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "Cricket");
        boolean isNumberOfResultInVideos = commonFunctionsMobile.verifySearchResultsDisplayedOnSearchPage(expectedMessage,searchResultsTitle);
        return isRedirectToVideosTab && isNumberOfResultInVideos;
    }

    @Override
    public boolean checkRedirectToStoryFromVideosInSearchPag() {
        boolean isRedirectToVideosTab = checkVideosOptionDisplayedAsSelectedInSearchPage();
        String firstStory = listOfStoriesInSearch.get(0).getText();
        System.out.println("First Story Heading is --- " + firstStory);
        commonFunctions.clickElement(listOfStoriesInSearch.get(0),5,"Click on First Story");
        //commonFunctions.toGetRidOfAd(bookMark, 5);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isStoryTitle = commonFunctions.getElementText(storyTitle, 10).equalsIgnoreCase(firstStory);
        Utils.logStepInfo(true,"isStoryTitle = "+ isStoryTitle);
        Utils.logStepInfo(true,"isRedirectToVideosTab = "+ isRedirectToVideosTab);
        return isStoryTitle && isRedirectToVideosTab;
    }

    @Override
    public boolean checkSearchForNoStoryFoundInSearchPage() {
        boolean isRedirectToNewsTab = commonFunctionsMobile.redirectToTabInSearchPage(newsLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "hhhh");
        boolean isResultFoundZero = commonFunctionsMobile.verifySearchResultsZeroDisplayedOnSearchPage(searchResultsTitle);
        return isRedirectToNewsTab && isResultFoundZero;
    }

    @Override
    public boolean checktitleAlsoLikeInNewsTabInSearchPage() {
        boolean isRedirectToNewsTab = commonFunctionsMobile.redirectToTabInSearchPage(newsLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "hhhh");
        boolean isTitleDisplayed = commonFunctions.getElementText(titleAlsoLikeInSearchResult,5).equalsIgnoreCase("You May Also Like");
        return isRedirectToNewsTab && isTitleDisplayed;
    }

    @Override
    public boolean checkTitleAlsoLikeInPhotosTabInSearchPage() {
        boolean isRedirectToPhotosTab = commonFunctionsMobile.redirectToTabInSearchPage(photosLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "hhhh");
        isRedirectToPhotosTab &= commonFunctions.getAtribute(photosLabelOnSearchResultPage,"selected").equalsIgnoreCase("true");
        boolean isTitleDisplayed = commonFunctions.getElementText(titleAlsoLikeInSearchResult,5).equalsIgnoreCase("You May Also Like");
        return isRedirectToPhotosTab && isTitleDisplayed;
    }

    @Override
    public boolean checkTitleAlsoLikeInVideosTabInSearchPage() {
        boolean isRedirectToVideosTab = commonFunctionsMobile.redirectToTabInSearchPage(videosLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "hhhh");
        isRedirectToVideosTab &= commonFunctions.getAtribute(videosLabelOnSearchResultPage,"selected").equalsIgnoreCase("true");
        boolean isTitleDisplayed = commonFunctions.getElementText(titleAlsoLikeInSearchResult,5).equalsIgnoreCase("You May Also Like");
        return isRedirectToVideosTab && isTitleDisplayed;
    }

    @Override
    public boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInNews() {
        return commonFunctionsMobile.redirectToPageWhenTabViewAllInSearchPage(newsLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "hhhh",viewAllOnSearchPage,"You May Also Like");
    }

    @Override
    public boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInPhotos() {
        return commonFunctionsMobile.redirectToPageWhenTabViewAllInSearchPage(photosLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "hhhh",viewAllOnSearchPage,"You May Also Like");
    }

    @Override
    public boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInVideos() {
        return commonFunctionsMobile.redirectToPageWhenTabViewAllInSearchPage(videosLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "hhhh",viewAllOnSearchPage,"You May Also Like");
    }

    @Override
    public boolean checkScrollDownTillLatestTopicInSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.scrollDownToElement(latestTopicsInSearchPage,homeButton);
        boolean isLatestTopics = commonFunctions.isElementDisplayed(latestTopicsInSearchPage,5,"Latest Topics");
        return isLatestTopics;
    }

    @Override
    public boolean checkRedirectToStoryFromLatestTopicInSearchPage() {
        boolean isRedirectToTopics = checkScrollDownTillLatestTopicInSearchPage();
        String latestTopicText = commonFunctions.getElementText(listOfLatestTopicsStories.get(0),5);
        commonFunctions.clickElement(listOfLatestTopicsStories.get(0),5,"Click on topics");
        commonFunctions.toGetRidOfAd(bookMark,5);
        if(commonFunctions.isElementDisplayed(latestTopicsInSearchPage,5,"List of Latest Topics")){
            commonFunctions.clickElementIfDisplayed(listOfLatestTopicsStories.get(0),5,"Click on topics");
        }
        Utils.logStepInfo("Tap on skip button on the story details!!!!!!!!!");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        commonFunctions.toGetRidOfAd(bookMark,5);
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "Accept cookie");
        boolean isTopicsOpened = commonFunctions.isElementDisplayed(headLine,5,"Story Headline");
        Utils.logStepInfo(true,"isRedirectToTopics = "+isRedirectToTopics);
        Utils.logStepInfo(true,"isTopicsOpened = "+isTopicsOpened);
        return isRedirectToTopics && isTopicsOpened;
    }

    @Override
    public boolean checkLatestTopicNotDisplayIfSearchAnyKey() {
        boolean isRedirectToNewsTab = commonFunctionsMobile.redirectToTabInSearchPage(newsLabelOnSearchResultPage,homeButton,searchField,searchHeader,searchInputTextBox,986,2083,listOfStoriesInSearchPage, "Cricket");
        commonFunctions.scrollToBottomForAndroidNative();
        boolean isLatestTopicsNotDisplayed = !commonFunctions.isElementDisplayed(latestTopicsInSearchPage,5,"Latest Topic not Displayed");
        return isRedirectToNewsTab && isLatestTopicsNotDisplayed;
    }

    @Override
    public boolean checkRedirectToSearchIfTabOnBackBtnFromLatestTopicStory() {
        boolean  isRedirectToTopics = checkRedirectToStoryFromLatestTopicInSearchPage();
        commonFunctions.clickElement(back,5,"Back");
        boolean isSearchPageDisplayed = commonFunctions.isElementDisplayed(searchHeader,5,"Search Header");
        isSearchPageDisplayed &= commonFunctions.getElementText(sectionPageHeader, 5).contains("SEARCH");
        Utils.logStepInfo(true,"isRedirectToTopics = "+isRedirectToTopics);
        Utils.logStepInfo(true,"isSearchPageDisplayed = "+isSearchPageDisplayed);
        return isRedirectToTopics && isSearchPageDisplayed;
    }

    @Override
    public boolean checkRedirectToLatestNewsViewAllInSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElement(viewAllOnSearchPage,5,"View All on Latest News");
        boolean isLatestNewsPage = commonFunctions.getElementText(searchHeader,5).equalsIgnoreCase("LATEST NEWS");
        return isLatestNewsPage;
    }

    @Override
    public boolean checkResultDataWithSearchKeyword(String searchPageUrl, String name) {
        return false;
    }

    @Override
    public boolean checkTrendingNews(String searchPageUrl) {
        return false;
    }

    public boolean NewsPhotosVideosLabelsOnSearchPage(String sendKeyInSearchBox){
        boolean isLabelDisplayed;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElementIfDisplayed(searchInputTextBox,20,"Click on Search box");
        commonFunctions.sendKeysOnAndroid(searchInputTextBox,sendKeyInSearchBox);
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(986,2083,"Enter Key");
        commonFunctions.dummyWait(10);
        isLabelDisplayed = commonFunctions.getElementText(newsLabelOnSearchResultPage, 5).equalsIgnoreCase("News")
                && commonFunctions.getElementText(photosLabelOnSearchResultPage, 5).equalsIgnoreCase("Photos")
                && commonFunctions.getElementText(videosLabelOnSearchResultPage, 5).equalsIgnoreCase("Videos");
        return isLabelDisplayed;
    }
}