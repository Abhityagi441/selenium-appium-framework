package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookmarkPage extends CommonBookmarkPage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    String storyPageTitle;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home'][@selected='true']")
    private static MobileElement HomePageOption;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static MobileElement firstStoryTitle;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static List<MobileElement> bookMarkStories;

    @AndroidFindBy(id = "com.ht.news:id/txt_headlines")
    private static MobileElement headLineOfStoryTxt;

    @AndroidFindBy(id = "com.ht.news:id/bookmark")
    private static MobileElement bookMarkOption;

    @AndroidFindBy(id = "com.ht.news:id/itemNameTv")
    private static MobileElement bookMarkSaved;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index=0]")
    private static MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Explore']/android.widget.FrameLayout/android.widget.ImageView")
    private static MobileElement hamburgerButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ht.news:id/snackbar_text']")
    private static MobileElement savedArticleMsg;

    @AndroidFindBy(id = "com.ht.news:id/snackbar_action")
    private static MobileElement dismissLink;

    @AndroidFindBy(id = "com.ht.news:id/text_view_item_title")
    private static MobileElement savedArticleTitle;

    @AndroidFindBy(xpath = "//android.widget.Toast[@id='com.ht.news:id/snackbar_action']")
    private static MobileElement toastView;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text='Added')]")
    private static MobileElement toastView1;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ht.news:id/ad_view_320_100']")
    private static MobileElement headerAd;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']/android.widget.FrameLayout/android.widget.ImageView")
    private static MobileElement home;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Profile']/android.widget.ImageView")
    private static MobileElement profile;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static List<MobileElement> threeDotButton;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static MobileElement bookMarkIconBookmarkPage;

    @AndroidFindBy(id = "com.ht.news:id/tv_bookmark")
    private static MobileElement bookmarkOptionThreeDot;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share']")
    private static MobileElement shareOptionThreeDot;

    @AndroidFindBy(id = "com.ht.news:id/btn_cancel")
    private static MobileElement cancelOptionThreeDot;

    @AndroidFindBy(accessibility = "Home")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(id = "com.ht.news:id/profile")
    private static MobileElement profileButton;

    @AndroidFindBy(accessibility = "Explore")
    private static MobileElement exploreBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='India']")
    private static MobileElement indiaSectionExplorePage;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement pageHeaderName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bookmarks']")
    private static MobileElement bookmarksProfilePage;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement editUserProfilePageHeader;

    @AndroidFindBy(id = "com.ht.news:id/tv_welcomeBack")
    private static MobileElement welcomeBackLoginUser;

    @AndroidFindBy(id = "com.ht.news:id/bookmark_info")
    private static MobileElement bookmarkPageTextMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BOOKMARKS' and @index='1']")
    private static MobileElement bookmarkCenterAlign;

    @AndroidFindBy(id = "com.ht.news:id/titleSubSection")
    private static MobileElement firstStorySectionName;

    @AndroidFindBy(id = "com.ht.news:id/accountTv")
    private static MobileElement accountProfilePage;

    @AndroidFindBy(id = "com.ht.news:id/bottomNavView")
    private static MobileElement bottomNav;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sports']")
    private static MobileElement sportOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daily Digest']")
    private static MobileElement dailyDigestSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    private static MobileElement photosOption;

    @AndroidFindBy(id = "com.ht.news:id/titleTv")
    private static MobileElement photoStoryTitle;

    @AndroidFindBy(id = "com.ht.news:id/recent_notification")
    private static MobileElement articlesInBookMark;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static MobileElement firstbookMarkIconInBookMarkPage;

    @AndroidFindBy(id = "com.ht.news:id/loginBtn")
    private static MobileElement loginToBookmarkBtn;

    @AndroidFindBy(id = "com.ht.news:id/tv_loginOrResister")
    private static MobileElement loginOrRegisterPage;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup[2]/android.widget.TextView[2]")
    private static MobileElement bookMarkArticleCountInProfileTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text='Removed')]")
    private static MobileElement popUpRemoved;

    @AndroidFindBy(xpath = "//*[@text='Please login to bookmark']")
    private static MobileElement nonLoggedInBookMarkMsg;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout/android.widget.ImageView)[1]")
    private static MobileElement threeDotInFirstStory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']")
    private static MobileElement videosSection;

    @AndroidFindBy(id = "com.ht.news:id/searchLayout")
    private static MobileElement searchField;

    @AndroidFindBy(id = "com.ht.news:id/shareIv")
    private static List<MobileElement> bookmarkOptionBeforeImage;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc]")
    private static List<MobileElement> sectionElement;

    @AndroidFindBy(id = "com.ht.news:id/thumbnailIv")
    private static List<MobileElement> pageStoryList;

    @AndroidFindBy(id = "//android.widget.TextView[@text='Close']")
    private static MobileElement closeAppAdBtn;

    @AndroidFindBy(id = "com.ht.news:id/topicsTv")
    private static MobileElement relatedTopic;

    @AndroidFindBy(id = "com.ht.news:id/topicChip")
    private static List<MobileElement> relatedTopicsList;

    @AndroidFindBy(xpath = "//*[@text='Quickreads']")
    private static MobileElement quickReads;

    public BookmarkPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        /*commonFunctions.clickElementIfDisplayed(continueButton, 3, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 3, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        *//*commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(206, 1950);
        commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available*/
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    public boolean checkHomePageStoryDetails() {
        boolean isHomePageDisplayed;
        boolean isFirstStory;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        commonFunctions.dummyWait(5);
        isHomePageDisplayed = commonFunctions.isElementDisplayed(headerAd, 10, "Header Ad");
        commonFunctions.isElementDisplayed(firstStoryTitle, 5, "first Story title");
        storyPageTitle = firstStoryTitle.getText().trim();
        isFirstStory = commonFunctions.clickElement(firstStoryTitle, 5, "first Story");
        commonFunctions.toGetRidOfAd(bookMarkOption, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        commonFunctions.isElementDisplayed(headLineOfStoryTxt, 5, "head Line of Story Text");
        String storyHeadLinesTxt = headLineOfStoryTxt.getText().trim();
        if (storyPageTitle.equals(storyHeadLinesTxt)) {
            isFirstStory = true;
        }
        Utils.logStepInfo(true,"isHomePageDisplayed = "+isHomePageDisplayed);
        Utils.logStepInfo(true,"isFirstStory = "+isFirstStory);
        return isHomePageDisplayed || isFirstStory;
    }

    public boolean checkBookMarkDisplayed() {
        boolean bookMarkDisplayed;
        bookMarkDisplayed = commonFunctions.isElementDisplayed(bookMarkOption, 5, "bookMarkOption");
        return bookMarkDisplayed;
    }

    public boolean checkBookMarkFunctionality(String[] params) {
        boolean checkBookMark;
        checkBookMark = commonFunctions.clickElement(bookMarkOption, 5, "bookMarkOption");
        return checkBookMark;
    }

    //instead of hamburger, the options are now in profile menu
    public boolean checkHamburgerMenu() {
        boolean returnToHomePage = false;
        boolean isHamburgerButton = false;
        commonFunctions.toGetRidOfAd(homeButton,5);
        returnToHomePage = commonFunctions.isElementDisplayed(homeButton, 5, "HT home button");
//        returnToHomePage = commonFunctions.clickElement(backButton, 5, "backButton");
        isHamburgerButton = commonFunctions.isElementDisplayed(profileButton, 5, "hamburgerButton");
        Utils.logStepInfo(true,"returnToHomePage = "+returnToHomePage);
        Utils.logStepInfo(true,"isHamburgerButton = "+isHamburgerButton);
        return returnToHomePage || isHamburgerButton;
    }

    public boolean checkSavedArticle() {
        boolean clickSavedArticle = false;
        boolean checkSavedArticle = false;
        commonFunctions.clickElement(profile, 5, "hamburgerButton");

        //clickSavedArticle= commonFunctions.scrollTillVisibleTextAndClick("Saved Articles","savedArticles");
        checkSavedArticle = commonFunctions.isElementDisplayed(bookMarkSaved, 5, "savedArticleTitle");
        commonFunctions.clickElement(bookMarkSaved, 5, "savedArticleTitle");
        //saved articles not loaded, hence locator not found
        String savedArticleTitleTxt = savedArticleTitle.getText();
        if (storyPageTitle.equals(savedArticleTitleTxt)) {
            checkSavedArticle = true;
        }
        return clickSavedArticle && checkSavedArticle;
    }

    @Override
    public boolean checkBookMarkWorkingFine(String[] params) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        boolean homePage = checkHomePageStoryDetails();
        boolean bookMarkDisplayed = checkBookMarkDisplayed();
        boolean bookMarkOption = checkBookMarkFunctionality(params);
        boolean hamburgerMenu = checkHamburgerMenu();
        Utils.logStepInfo(true,"homePage = "+homePage);
        Utils.logStepInfo(true,"bookMarkDisplayed = "+bookMarkDisplayed);
        Utils.logStepInfo(true,"bookMarkOption = "+bookMarkOption);
        Utils.logStepInfo(true,"hamburgerMenu = "+hamburgerMenu);
        return homePage && bookMarkDisplayed && bookMarkOption && hamburgerMenu;
    }

    @Override
    public boolean checkRemoveAllLinkBookMarkPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkClickThreeDotDisplayDifferentOptions() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story three dot button");
        boolean shareOptionDisplay = commonFunctions.isElementDisplayed(shareOptionThreeDot, 5, "Share option display after click on three dot");
        boolean bookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        boolean cancelOptionDisplay = commonFunctions.isElementDisplayed(cancelOptionThreeDot, 5, "Cancel option display after click on three dot");
        commonFunctions.pressAndroidBackKey();
        return shareOptionDisplay && bookmarkOptionDisplay && cancelOptionDisplay;
    }

    @Override
    public boolean checkBookMarkRedirectionLoggedInUser() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(exploreBtn, 5, "Explore button");
        commonFunctions.clickElement(indiaSectionExplorePage, 5, "India Section button from Explore");
        boolean isIndiaPageRediretionTrue = commonFunctions.getElementText(pageHeaderName, 5).contains("INDIA");
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story three dot button");
        boolean shareOptionDisplay = commonFunctions.isElementDisplayed(shareOptionThreeDot, 5, "Share option display after click on three dot");
        boolean bookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        boolean cancelOptionDisplay = commonFunctions.isElementDisplayed(cancelOptionThreeDot, 5, "Cancel option display after click on three dot");
        commonFunctions.clickElement(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        commonFunctions.toGetProfileButtonVisibleAndClick(profileButton, 5);
//        commonFunctions.clickElement(profileButton, 5, "Profile button");
        return shareOptionDisplay && bookmarkOptionDisplay && cancelOptionDisplay && isIndiaPageRediretionTrue;
    }

    @Override
    public boolean checkBookMarkRedirectionNonLoggedInUser() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(profileButton, 10, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 10, "BookMark page");
        commonFunctions.clickElement(loginToBookmarkBtn,10,"login To Bookmark Btn");
        boolean isSSOPageDisplayed = commonFunctions.isElementDisplayed(loginOrRegisterPage,5,"login Or Register Page");
        return isSSOPageDisplayed;
    }

    @Override
    public boolean checkOptionsInSettings() {
        return false;
    }

    @Override
    public boolean checkBottomActionPageOnIndiaPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(exploreBtn, 5, "Explore button");
        commonFunctions.clickElement(indiaSectionExplorePage, 5, "India Section button from Explore");
        boolean isIndiaPageRediretionTrue = commonFunctions.getElementText(pageHeaderName, 5).contains("INDIA");
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story three dot button");
        boolean shareOptionDisplay = commonFunctions.isElementDisplayed(shareOptionThreeDot, 5, "Share option display after click on three dot");
        boolean bookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        boolean cancelOptionDisplay = commonFunctions.isElementDisplayed(cancelOptionThreeDot, 5, "Cancel option display after click on three dot");
        commonFunctions.clickElement(cancelOptionThreeDot, 5, "Cancel option display after click on three dot");

        return isIndiaPageRediretionTrue && shareOptionDisplay && bookmarkOptionDisplay && cancelOptionDisplay;
    }

    @Override
    public boolean checkBookmark3DotOption() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTapBackFromBookmarkPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        commonFunctions.clickElement(backButton,5,"Back Arrow");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeButton,5,"Home button") && commonFunctions.isElementDisplayed(firstStoryTitle,5,"first Story title");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(profileButton,5);
        boolean isProfilePageDisplay = commonFunctions.getElementText(accountProfilePage, 5).contains("ACCOUNT");
        return isHomePage && isBookmarkPageDisplay && isProfilePageDisplay;
    }

    @Override
    public boolean checkSomeArticleIsBookmarked() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        boolean isSomeArticleDisplay = toCheckAllStoryDisplay(bookMarkStories);
        return isBookmarkPageDisplay && isSomeArticleDisplay;
    }

    public boolean toCheckAllStoryDisplay(List<MobileElement> elementList) {
        boolean isToCheckAllStoryDisplay = false;
        try {
            for (MobileElement ele : elementList) {
                boolean isStoryDisplay = commonFunctions.isElementDisplayed(ele, 5, commonFunctions.getElementText(ele, 5));
                boolean isStoryHeadlineEmpty = commonFunctions.getElementText(ele, 5).isEmpty();
                if (isStoryDisplay && isStoryHeadlineEmpty == false) {
                    isToCheckAllStoryDisplay = true;
                }
            }
        } catch (Exception e) {
            isToCheckAllStoryDisplay = false;
        }
        return isToCheckAllStoryDisplay;
    }

    @Override
    public boolean checkBookmarkPageHeadingInCenter() {
        //commonFunctions.clickByCoordinates(646,503,"Skip button on story");//Skip/Done pop up on any story
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        boolean isPageHeadingInCenterTrue = commonFunctions.isElementDisplayed(bookmarkCenterAlign, 5, commonFunctions.getElementText(editUserProfilePageHeader, 5) + " at Top of the page and at center alignment");
        return isBookmarkPageDisplay && isPageHeadingInCenterTrue;
    }

    @Override
    public boolean checkTextDisplayAfterBookmarkPageHeading() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        boolean isTextMessageAfterHeadingName = commonFunctions.getElementText(bookmarkPageTextMessage, 5).contains("Find your bookmarked articles here, you can tap on the bookmark icon to remove them from this list.");

        return isBookmarkPageDisplay && isTextMessageAfterHeadingName;
    }

    @Override
    public boolean checkRedirectionStoryPageOnTap() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        String firstStoryTitleText = commonFunctions.getElementText(firstStoryTitle, 5);
        commonFunctions.clickElement(firstStoryTitle, 5, firstStoryTitleText);
        commonFunctions.dummyWait(5);
        Utils.logStepInfo("Clicking on bookmark Skip button to explre story details.");
        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        String storyHeadlineText = commonFunctions.getElementText(headLineOfStoryTxt, 5);
        boolean redirectionStoryPageTrue = commonFunctions.compareTexts(firstStoryTitleText, storyHeadlineText);
        return isBookmarkPageDisplay && redirectionStoryPageTrue;
    }

    @Override
    public boolean checkRedirectionSectionPageOfStoryOnTap() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        String storySectionNameOnBookmarkPage = commonFunctions.getElementText(firstStorySectionName, 5);
        commonFunctions.clickElement(firstStorySectionName, 5, storySectionNameOnBookmarkPage);
        String sectionPageHeaderName = commonFunctions.getElementText(pageHeaderName, 5);
        return commonFunctions.compareTexts(storySectionNameOnBookmarkPage, sectionPageHeaderName) && isBookmarkPageDisplay;
    }

    @Override
    public boolean checkBottomNavDisplayOnBookmarkPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        return commonFunctions.isElementDisplayed(bottomNav, 5, "Bottom nav on Bookmark page") && isBookmarkPageDisplay;
    }

    @Override
    public boolean checkHomeisSelectedBottomNavOnBookmarkPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        boolean isLoginButtonDisplayed = commonFunctions.isElementDisplayed(loginToBookmarkBtn, 5, "Login button in BookMark");
        boolean isHomeSelected = commonFunctions.isElementSelected(homeButton,5,"Home in bottom Navigation");
        return isLoginButtonDisplayed && isBookmarkPageDisplay && isHomeSelected;
    }

    @Override
    public boolean checkBookmarkIconDisplayBeforeImageStory() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
//        commonFunctions.clickElement(firstStoryTitle, 5, "First story of the Bookmark page");
//        commonFunctions.dummyWait(5);
//        Utils.logStepInfo("Clicking on bookmark Skip button to explre story details.");
//        commonFunctions.clickByCoordinates(540, 521);//As skip/next button in the prompt locator is not available
        boolean isBookmarkIconDisplay = commonFunctions.isElementDisplayed(bookmarkOptionBeforeImage.get(0), 5, "Bookmark icon before Image story");
        return isBookmarkIconDisplay && isBookmarkPageDisplay;
    }

    @Override
    public boolean checkTapOnBookmarkIconAtBookmarkPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        String firstStoryTitleName = commonFunctions.getElementText(firstStoryTitle, 5);
        commonFunctions.clickElement(bookMarkIconBookmarkPage, 5, "First story bookmark icon");
        String firstStoryTitleNameAfterTapOnBookmarkIcon = commonFunctions.getElementText(firstStoryTitle, 5);
        return !commonFunctions.compareTexts(firstStoryTitleNameAfterTapOnBookmarkIcon, firstStoryTitleName) && isBookmarkPageDisplay;
    }

    @Override
    public boolean checkBookmarkStoryDisplay() {
        boolean isStoryBookMarked;
        //Articles before bookmarked ...
        checkArticlesCountInBookMark();
        int countOfArticlesBeforeBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Final Value of Artical after removing = " + countOfArticlesBeforeBookMarked);

        //BookMark story from Home Page
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story Three dot icon");
        boolean isBookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        commonFunctions.clickElement(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");

        //Verify Article in bookMark section after bookmarked story---
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookMarked);
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        return  isBookmarkOptionDisplay && isStoryBookMarked;
    }

    @Override
    public boolean checkBookmarkStoryDisplayForAnySectionSavedArticles() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        Utils.logStepInfo("To Open any section page.");
        //MobileElement sectionElement = commonFunctions.toGetMobileElementByVisibilityText("IPL 2022");
        commonFunctions.clickElement(sectionElement.get(4), 5, "Any section");
        String firstStoryTitleName = commonFunctions.getElementText(firstStoryTitle, 5);
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story of the HT any section");
//        commonFunctions.toGetRidOfAd(homeButton, 5);
//        commonFunctions.dummyWait(5);
//        commonFunctions.clickByCoordinates(645, 517);//As skip/next button in the prompt locator is not available
        commonFunctions.clickElement(bookmarkOptionThreeDot, 5, "Bookmark option on the current story section page");
//        added for failed test cases
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmark section on profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(pageHeaderName, 5).contains("BOOKMARKS");
        boolean isRecentBookmarkedDisplay = commonFunctions.scrollTillVisibleText(firstStoryTitleName, "Recently saved article");
        return isBookmarkPageDisplay && isRecentBookmarkedDisplay;
    }

    @Override
    public boolean bookMarkStoryFromSportsSection() {
        return bookMarkStoryFromSection(sportOption, true, "SPORTS");
    }

    @Override
    public boolean sportStoryInBookMarkedArtical() {
        return verifyBookMarkedStoryDisplayedInBookMarkPage(sportOption,true,"SPORTS");
    }

    @Override
    public boolean bookMarkStoryFromPhotosSection() {
        return bookMarkStoryFromSection(photosOption,true,"PHOTOS");
    }

    @Override
    public boolean photoStoryInBookMarkedArtical() {
        return verifyBookMarkedStoryDisplayedInBookMarkPage(photosOption,true,"PHOTOS");
    }

    @Override
    public boolean checkCountOfBookMarkedStoriesSame() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        String countInBookMarkArticlesInProfile = commonFunctions.getElementText(bookMarkArticleCountInProfileTab,5);
        int articleCountInProfileTab = Integer.parseInt(countInBookMarkArticlesInProfile.replaceAll("\\(","").replace(")","").trim());
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        int countOfArticlesInBookMarkSection = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        boolean isCountSame = countOfArticlesInBookMarkSection == articleCountInProfileTab;
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        return isCountSame;
    }

    @Override
    public boolean checkBookMarkMsgForLoggedInUser() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(threeDotInFirstStory, 5, "First story three dot button");
        boolean bookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        commonFunctions.clickElement(bookmarkOptionThreeDot,5, "BookMark");
        //boolean isBookmarkMsgBoc = commonFunctions.isElementDisplayedUnlclickable(toastView1,5, "BookMark Added") || commonFunctions.isElementDisplayedUnlclickable(popUpRemoved,5, "BookMark Removed");
        commonFunctions.clickElement(profileButton,5,"Profile Button");
        return bookmarkOptionDisplay;
    }

    @Override
    public boolean checkBookMarkMsgBoxForNonLoggedInUser() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(threeDotInFirstStory, 5, "First story three dot button");
        boolean bookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option display after click on three dot");
        commonFunctions.clickElement(bookmarkOptionThreeDot,5, "BookMark");
        //Unable to Automate BookMark Pop Up message
        //boolean isBookmarkMsg = commonFunctions.isElementDisplayed(nonLoggedInBookMarkMsg,5,"BookMark Msg for Non Logged in User");
        return bookmarkOptionDisplay;
    }

    @Override
    public boolean checkBookMarkedStoryFromVideoSection(){
        return verifyBookMarkedStoryDisplayedInBookMarkPage(videosSection,true,"VIDEOS");
    }

    @Override
    public boolean checkUnBookMarkStoryOfPhotosSection() {
        return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(photosOption,true,"PHOTOS");
    }

    @Override
    public boolean checkBookMarkStoryFromSectionListingPage() {
        checkArticlesCountInBookMark();
        int countOfArticlesBeforeBookmarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Final Count of Artical  = " + countOfArticlesBeforeBookmarked);
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(indiaSectionExplorePage,5,"India Section");
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story Three dot icon");
        boolean isBookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        commonFunctions.clickElement(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        boolean isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookmarked);
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        return isBookmarkOptionDisplay & isStoryBookMarked;
    }

    @Override
    public boolean checkBookMarkStoryInBookmarkSectionFromSectionListingPage() {
        return checkBookMarkStoryFromSectionListingPage();
    }

    @Override
    public boolean checkBackRedirectionFromBookmarkPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        commonFunctions.clickElement(bookMarkStories.get(0),5,"first Story in BookMark");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(537, 517);//As skip/next button in the prompt locator is not available
        boolean isStoryPage = commonFunctions.isElementDisplayed(headLineOfStoryTxt,5,"Story Title");
        commonFunctions.clickElement(backButton,5,"Back Arrow");
        commonFunctions.toGetRidOfAd(articlesInBookMark,5);
        boolean isBookMarkPage = commonFunctions.isElementDisplayed(articlesInBookMark,5,"Article in BookMark");
        isBookMarkPage &= commonFunctions.isElementDisplayed(bookmarkCenterAlign,5,"BookMark Heading");
        return isStoryPage && isBookMarkPage;
    }

    @Override
    public boolean checkBookMarkStoryFromSearchPage() {
        checkArticlesCountInBookMark();
        int countOfArticlesBeforeBookmarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Final Count of Artical  = " + countOfArticlesBeforeBookmarked);
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(searchField,5,"Search Page");
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story Three dot icon");
        boolean isBookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        commonFunctions.clickElement(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        boolean isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookmarked);
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        return isBookmarkOptionDisplay & isStoryBookMarked;
    }

    @Override
    public boolean checkUnBookMarkStoryFromSearchPage() {
        return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(searchField,false,"SEARCH");
    }

    @Override
    public boolean checkSearchBookMarkStoryDisplayedInBookMarkSection() {
        return checkBookMarkStoryFromSearchPage();
    }

    @Override
    public boolean checkDailyDigestBookMarkStoryDisplayedInBookMarkSection() {
        return verifyBookMarkedStoryDisplayedInBookMarkPage(dailyDigestSection,false,"BRIEF");
    }

    @Override
    public boolean checkDailyDigestUnBookMarkStoryDisplayedInBookMarkSection() {
        return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(dailyDigestSection,false,"BRIEF");
    }

    @Override
    public boolean checkBookMarkStoryFromTopicPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(quickReads,5,"QuickRead option");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(bookMarkStories.get(0), 10, "First Story of the current page");
        commonFunctions.clickElementIfDisplayed(closeAppAdBtn,5,"Another application close button");
        Utils.logStepInfo("Click of skip button should be performed to continue further app interaction.");
        commonFunctions.dummyWait(5);
        commonFunctions.toGetRidOfAd(bookMarkOption,5);
        commonFunctions.clickByCoordinates(537, 517);
        boolean isScrollToRelatedTopic = commonFunctions.scrollDownToElement(relatedTopic, bookMarkOption);
        commonFunctions.clickElement(relatedTopicsList.get(0),5,"Click on Topic");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story Three dot icon");
        boolean isBookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        commonFunctions.clickElement(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        Utils.logStepInfo(true,"isScrollToRelatedTopic = "+isScrollToRelatedTopic);
        Utils.logStepInfo(true,"isBookmarkOptionDisplay = "+isBookmarkOptionDisplay);
        return isScrollToRelatedTopic && isBookmarkOptionDisplay;
    }

    @Override
    public boolean checkUnBookMarkStoryFromTopicPage() {
        Boolean isStoryBookMarked = false;
        checkArticlesCountInBookMark();
        int countOfArticles = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        Utils.logStepInfo("Final Count of Artical  = " + countOfArticles);
        boolean isBookMarkedStory = checkBookMarkStoryFromTopicPage();
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        int countOfArticlesAfterAdded = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        Utils.logStepInfo("Value of Article after bookmarked = " + countOfArticlesAfterAdded);
        if (countOfArticles == countOfArticlesAfterAdded - 1) {
            Utils.logStepInfo("Story is BookMarked and Article Value is incressed by one");
            commonFunctions.clickElement(firstbookMarkIconInBookMarkPage, 5, "UnBookMark Story");
            commonFunctions.dummyWait(2);
            int countOfArticlesAfterUnBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
            if(countOfArticlesAfterUnBookMarked == countOfArticlesAfterAdded-1){
                Utils.logStepInfo(true,"Story is UnBookMarked Successfully!!!!!!");
                isStoryBookMarked = true;
            }
        } else if (countOfArticles == countOfArticlesAfterAdded + 1) {
            Utils.logStepInfo(true, "Story is already BookMarked so UnBookMakred from BookMarked article Successfully!!!!");
            isStoryBookMarked = true;
        } else {
            Utils.logStepInfo(false,"Unable to bookMark Story");
            isStoryBookMarked = false;
        }
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        return isBookMarkedStory && isStoryBookMarked;
    }

    @Override
    public boolean checkTopicBookMarkStoryDisplayedInBookMarkSection() {
        Boolean isStoryBookMarked = false;
        checkArticlesCountInBookMark();
        int countOfArticlesBeforeBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        Utils.logStepInfo("Final Value of Artical after removing = " + countOfArticlesBeforeBookMarked);
        boolean isBookMarkedStory = checkBookMarkStoryFromTopicPage();
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookMarked);
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        return isBookMarkedStory && isStoryBookMarked;
    }

    @Override
    public boolean checkBookMarkedStoryFromDailyDigest() {
        return bookMarkStoryFromSection(dailyDigestSection,false,"BRIEF");
    }

    @Override
    public boolean checkUnBookMarkStoryOfVideoSection() {
        return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(videosSection,true,"VIDEOS");
    }

    @Override
    public boolean checkAdToBookmarkAndVerify(String uri, String address) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean checkBookmarkIconIsClickableAndDisplay(String uri, String address) {
        return false;
    }

    public boolean checkArticlesCountInBookMark() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.toGetProfileButtonVisibleAndClick(profileButton, 5);
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        String articles = commonFunctions.getElementText(articlesInBookMark, 5);
        int countOfArticles = Integer.parseInt(articles.replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Integer value of Article = " + countOfArticles);
        if (countOfArticles >= 50) {
            int needToRemove = countOfArticles - 47;
            for (int i = 0; i < needToRemove; i++) {
                commonFunctions.clickElement(firstbookMarkIconInBookMarkPage, 5, "First BookMark Remove");
                commonFunctions.dummyWait(2);
            }
        } else {
            System.out.println("BookMarked Articles are less than 50");
        }
        return true;
    }

    public boolean bookMarkStoryFromSection(MobileElement fromSection, boolean isScrollingFlagForSection, String pageHeader){
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElement(exploreBtn, 5, "Explore button");
        if (isScrollingFlagForSection){
            commonFunctions.scrollDownSlowToElement(fromSection,10);
        }
        String sectionName = fromSection.getText();
        commonFunctions.clickElement(fromSection, 5, sectionName +" section from top");
        boolean isCurrentPage = commonFunctions.getElementText(pageHeaderName, 5).contains(pageHeader);
        commonFunctions.clickElement(threeDotButton.get(0), 5, "First story Three dot icon");
        boolean isBookmarkOptionDisplay = commonFunctions.isElementDisplayed(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        commonFunctions.clickElement(bookmarkOptionThreeDot, 5, "Bookmark option after click first story three dot icon");
        Utils.logStepInfo(true,"isCurrentPage = "+isCurrentPage);
        Utils.logStepInfo(true,"isBookmarkOptionDisplay = "+isBookmarkOptionDisplay);
        return isCurrentPage && isBookmarkOptionDisplay;
    }

    public boolean verifyBookMarkedStoryDisplayedInBookMarkPage(MobileElement fromSection, boolean isScrollingFlagForSection, String pageHeader){
        Boolean isStoryBookMarked = false;
        checkArticlesCountInBookMark();
        int countOfArticlesBeforeBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Final Value of Artical after removing = " + countOfArticlesBeforeBookMarked);
        boolean isBookMarkedStory = bookMarkStoryFromSection(fromSection,isScrollingFlagForSection, pageHeader);
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookMarked);
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        Utils.logStepInfo(true,"isBookMarkedStory = "+isBookMarkedStory);
        Utils.logStepInfo(true,"isStoryBookMarked = "+isStoryBookMarked);
        return isBookMarkedStory && isStoryBookMarked;
    }

    public boolean verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(MobileElement fromSection, boolean isScrollingFlagForSection, String pageHeaderForVerification){
        Boolean isStoryBookMarked = false;
        checkArticlesCountInBookMark();
        int countOfArticles = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Final Count of Artical  = " + countOfArticles);
        boolean isBookMarkedStory = bookMarkStoryFromSection(fromSection,isScrollingFlagForSection,pageHeaderForVerification);
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "BookMark page");
        int countOfArticlesAfterAdded = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
        System.out.println("Value of Article after bookmarked = " + countOfArticlesAfterAdded);
        if (countOfArticles == countOfArticlesAfterAdded - 1) {
            System.out.println("Story is BookMarked and Article Value is incressed by one");
            commonFunctions.clickElement(firstbookMarkIconInBookMarkPage, 5, "UnBookMark Story");
            commonFunctions.dummyWait(2);
            int countOfArticlesAfterUnBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
            if(countOfArticlesAfterUnBookMarked == countOfArticlesAfterAdded-1){
                System.out.println("Story is UnBookMarked Successfully!!!!!!");
                isStoryBookMarked = true;
            }
        } else if (countOfArticles == countOfArticlesAfterAdded + 1) {
            System.out.println("Story is already BookMarked so UnBookMakred from BookMarked article Successfully!!!!");
            isStoryBookMarked = true;
        } else {
            System.out.println("Unable to bookMark Story");
            isStoryBookMarked = false;
        }
        commonFunctions.clickElement(homeButton, 5, "HT Home button");
        Utils.logStepInfo(true,"isBookMarkedStory = "+isBookMarkedStory);
        Utils.logStepInfo(true,"isStoryBookMarked = "+isStoryBookMarked);
        return isBookMarkedStory && isStoryBookMarked;
    }
}
