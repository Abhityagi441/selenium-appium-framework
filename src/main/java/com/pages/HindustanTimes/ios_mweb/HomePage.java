package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends CommonHomePage {
    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//div[contains(@class,'epaper-ad')]")
    private static WebElement epaperCTA;

    @FindBy(xpath = "//div[@class='shareArticle']//a[@class='tw']")
    private static WebElement twitterShareOptionInlineStory;

    @FindBy(xpath = "(//span[text()='View All'])[16]")
    private static WebElement viewAll;

    @FindBy(xpath ="//div[@class='listPagination']")
     private static WebElement listPagination;

    @FindBy(xpath="//li[@class='last']")
    private static WebElement lastPaginationIcon;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private  static  WebElement hamburger;

    @FindBy(xpath = "//div[contains(@class,'shareArticle')]")
    private static WebElement searchHere;

    @FindBy(xpath = "//span[@class='crossicon']")
    private static WebElement closeOption;

    @FindBy(xpath = "//div[@class='nav-footer']")
    private static WebElement footerOption;

    @FindBy(xpath="//a[@data-id='india-news,1']")
    private static WebElement sectionIndiaNews;

    @FindBy(xpath = "//div[@class='sidenav-heaer']")
    private static WebElement sideNavigation;

    @FindBy(xpath="//a[@href='/latest-news']")
    private static WebElement latest;

    @FindBy(xpath = "//div[@class='logo']")
    private static WebElement HtLogo;

    @FindBy(xpath="//span[text()='view more']")
    private static WebElement viewMore;

    @FindBy(xpath="//div[contains(@class,'htSlider')]//div[contains(text(),'Auto')]")
    private static WebElement htAutoWidget;

    @FindBy(xpath="//div[contains(@class,'htSlider')]//div[contains(text(),'Auto')]/a")
    private static WebElement htAutoWidgetViewAll;

    @FindBy(xpath="//div[@id='targetAuto']/ul/li/div/p")
    private static WebElement htAutoWidgetStoryHeadline;


    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean isNavigatedToArtPage(String params[]) {
        boolean isNavigatedToArtPage=false;
            commonFunctions.navigateToURL(globalVars.getURL()+params[0]);
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getURL()+params[0])) {
                isNavigatedToArtPage = true;
            }
        return isNavigatedToArtPage;
    }

    public boolean scrollDownTheStory() {
        boolean isScrollDownPageSuccessful=false;
            isScrollDownPageSuccessful = commonFunctions.scrollToElementView(twitterShareOptionInlineStory, 20, "twitterShareOptionInlineStory");
            isScrollDownPageSuccessful = commonFunctions.scrollToElementView(epaperCTA, 20, "epaperCTA");
        return isScrollDownPageSuccessful;
    }

    public boolean checkEpaperCTADisplayed() {
        boolean isEPaperCTADisplayed=false;
            isEPaperCTADisplayed = commonFunctions.scrollToElementView(epaperCTA, 20, "epaperCTA");
        return isEPaperCTADisplayed;
    }
    public boolean checkEpaperCTARedirection(String params[]) {
        boolean isEPaperCTARedirectionSuccessful=false;
            isEPaperCTARedirectionSuccessful = commonFunctions.scrollToElementViewAndClick(epaperCTA, 20, "epaperCTA");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.contains(params[1])) {
                isEPaperCTARedirectionSuccessful = true;
            }
        return isEPaperCTARedirectionSuccessful;
    }
    public boolean checkExistingOptionVisible() {
        boolean isViewMoreDisplayed;
        commonFunctions.clickElementWithJS(latest,20,"Latest News in Navigation");
        commonFunctions.scrollDownToElement(listPagination);
         isViewMoreDisplayed = commonFunctions.isElementDisplayed(listPagination, 25, "List Pagination");
        Utils.logStepInfo(true, "Loading is working Successfully and footer is not displayed");

        return isViewMoreDisplayed;
    }
    public boolean checkHtLogoAndReloading() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isReloadingSuccessful = false;
        try {
            commonFunctions.isElementDisplayed(HtLogo, 15);
            commonFunctions.clickElementWithJS(HtLogo, 15, "Hindustan Times Logo");
            commonFunctions.isElementDisplayed(HtLogo,10,"HT Logo");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(Utils.getUrl())) {
                isReloadingSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReloadingSuccessful;
    }
    public boolean checkExploreOptionOpening() {
        boolean isExploreOptionDisplayed;
        commonFunctions.navigateToURL(globalVars.getURL());
        isExploreOptionDisplayed=commonFunctions.clickElementWithJS(hamburger, 10, "Explore Option");
        commonFunctions.isElementDisplayed(searchHere, 10);
        Utils.logStepInfo(true, "Explore Option is Opening");
        commonFunctions.clickElementWithJS(closeOption, 25, "Close Option");

        return isExploreOptionDisplayed;
    }

    @Override
    public boolean checkAdDisplayingHomePage() {return false;}

    @Override
    public boolean checkEpaperCTALogoRedirection(String[] params) {
        boolean navigateToURL = isNavigatedToArtPage(params);
        boolean scrollDownStory = scrollDownTheStory();
        boolean checkEpaper = checkEpaperCTADisplayed();
        boolean checkEpaperRedirection = checkEpaperCTARedirection(params);
        return navigateToURL && scrollDownStory && checkEpaper && checkEpaperRedirection;
    }

    @Override
    public boolean checkHomePageLoaded(String[] params) {
        boolean checkHtLogoAndReloading = checkHtLogoAndReloading();
        boolean checkExploreOptionOpening = checkExploreOptionOpening();
        boolean checkExistingOption = checkExistingOptionVisible();
        return checkExistingOption && checkHtLogoAndReloading && checkExploreOptionOpening;
    }
    @Override
    public boolean checkHTAutoRedirection() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollDownToElement(htAutoWidget);
        boolean scrollDownStory = commonFunctions.scrollDownToElement(htAutoWidget);
        commonFunctions.isElementDisplayed(htAutoWidget,20,"");
        boolean checkHTAutoWidget = commonFunctions.clickElementWithJS(htAutoWidgetViewAll, 20, "HT Auto View All");
        commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        commonFunctions.switchToWindowWithTitle("Auto News India, Car and Bikes News, Launch, Price, Features, Reviews");
        String redirectedUrl=commonFunctions.getCurrentURL();
        if (redirectedUrl.contains("auto.hindustantimes.com")&&redirectedUrl.contains("utm")){
            Utils.logStepInfo(true,"Redirection Successful");
        }
        commonFunctions.switchToWindowWithTitle("News Headlines, English News, Today Headlines, Top Stories | Hindustan Times");
        return  scrollDownStory && checkHTAutoWidget;
    }

    @Override
    public boolean checkRedirectionOnTappingProfile() {
        return false;
    }

    @Override
    public boolean checkMayBeLaterOptionBehaviour() {
        return false;
    }

    @Override
    public boolean checkEmailTextArea() {
        return false;
    }

    @Override
    public boolean checkPasswordTextArea() {
        return false;
    }

    @Override
    public boolean checkHindustanTimesLogoDisplayed() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTappingExplore() {
        return false;
    }

    @Override
    public boolean checkEpaperAndSearchDisplayed() {
        return false;
    }

    @Override
    public boolean checkHomeTabHeader() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnVideoFromExplore() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnPhotosFromExplore() {
        return false;
    }

    @Override
    public boolean checkSectionHomeIsHighlightedInBottomNav() {
        return false;
    }

    @Override
    public boolean checkQuickReadsRedirection() {
        return false;
    }

    @Override
    public boolean checkPremiumRedirection() {
        return false;
    }

    @Override
    public boolean checkProfileRedirection() {
        return false;
    }

    @Override
    public boolean checkExploreRedirection() {
        return false;
    }

    @Override
    public boolean checkSectionIndiaHighlit() {
        return false;
    }

    @Override
    public boolean checkGetPersonalizedExperiencePageNotDisplay() {
        return false;
    }

    @Override
    public boolean checkAllBottomNavDisplay() {
        return false;
    }

    @Override
    public boolean checkTrendingTopicsCarousel() {
        return false;
    }

    @Override
    public boolean checkTapOnSectionSubsectionRedirectToSectionPage() {
        return false;
    }

    @Override
    public boolean checkQuickReadsFunctionality() {
        return false;
    }

    @Override
    public boolean checkDontMissOption() {
        return false;
    }

    @Override
    public boolean checkCricketSection() {
        return false;
    }

    @Override
    public boolean checkPhotosSection() {
        return false;
    }

    @Override
    public boolean checkWebStoriesSection() {
        return false;
    }

    @Override
    public boolean check3DotMsgBoxDisplayed() {
        return false;
    }

    @Override
    public boolean checkMostReadSection() {
        return false;
    }

    @Override
    public boolean checkSubscribeToNewsletterBehaviour() {
        return false;
    }

    @Override
    public boolean checkShareOption() {
        return false;
    }

    @Override
    public boolean checkQuickReadHaveOneStoryAtATime() {
        return false;
    }

    @Override
    public boolean checkQuickReadFirstAndSecondWithSwipe() {
        return false;
    }

    @Override
    public boolean checkQuickReadReadFullStoryRedirection() {
        return false;
    }

    @Override
    public boolean checkFirstAdAfter4StoriesInQuickReadPage() {
        return false;
    }

    @Override
    public boolean checkViewAllLinkRightToQuickread() {
        return false;
    }

    @Override
    public boolean checkQuickreadsReadFullStoryRedirectionForBackpress() {
        return false;
    }

    @Override
    public boolean checkShareOptionInQuickRead() {
        return false;
    }

    @Override
    public boolean checkTappingOnViewAllOnLatestVideoCarousel() {
        return false;
    }

    @Override
    public boolean checkEPaperOptionFromHeader() {
        return false;
    }

    @Override
    public boolean checkEPaperOptionFromQuickReadHeader() {
        return false;
    }

    public boolean checkAppearanceOfLatestVideoCarousel() {
        return false;
    }

    @Override
    public boolean checkAdAfterDontMissSection() {
        return false;
    }

    @Override
    public boolean checkRedirectToRespectiveStory() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromLatestVideoCarousel() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromPhotoCarousel() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromWebStoriesCarousel() {
        return false;
    }

    @Override
    public boolean checkViewAllFromWebStoriesCarousel() {
        return false;
    }

    @Override
    public boolean checkQuickReadsCraouselDisplayedOnHome() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromQuickReadsCraousel() {
        return false;
    }

    @Override
    public boolean checkNewslettersCarouselDisplayed() {
        return false;
    }

    @Override
    public boolean checkScrollrightToLeftAndLeftToRightOnNewsletters() {
        return false;
    }

    @Override
    public boolean checkFirstCardIsDailyNewsCapsuleOnNewsletters() {
        return false;
    }

    @Override
    public boolean checkSecondCardIsHTEDCallingOnNewsletters() {
        return false;
    }

    @Override
    public boolean checkRedirectionWhenTabOnReadNowOnNewsletters() {
        return false;
    }

    @Override
    public boolean checkTopAdsClickable() {
        return false;
    }

    @Override
    public boolean checkHamburgerMenuAllOptionDisplayed() throws Exception {return false;}

    @Override
    public boolean checkLiveblogPaginationEmbeds(String title) {return false;}

    @Override
    public boolean checkHomePageLoadingVerification() {return false;}

    @Override
    public boolean checkLeftPaneDisplayed() {
        return false;
    }

    @Override
    public boolean checkEpaperCta(String[] params) {return false;}

    @Override
    public boolean checkHomePageItems() {return false;}

    @Override
    public boolean checkPremiumArtExclusiveTag() {return false;}

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnDailyNewsCapsule() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnDailyNewsCapsule(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTEdCalling() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTEdCalling(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTWknd() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTWknd(String email) { return false; }

    @Override
    public boolean checkEmailIdPrefilled(String email) {return false; }

    @Override
    public boolean  checkNewsletterScroll(MobileElement ele){return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTWeekAhead() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTWeekAhead(String email) {return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTCapitalLetters() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTCapitalLetters(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnWiredWisdom() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnWiredWisdom(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTCity() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTCity(String email) { return false; }

    @Override
    public boolean checkRegisterNowButton() { return false; }

    @Override
    public boolean checkSubscribeSuccessfully() { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTMindTheGap() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTMindTheGap(String email) { return false; }

    @Override
    public boolean checkNonLoggedUserSubscribeButtonOnHTKickOff() { return false; }

    @Override
    public boolean checkLoggedInUserSubscribeButtonOnHTKickOff(String email) { return false; }

    @Override
    public boolean checkRecommendedForYouCarouselOnHome() {return false; }

    @Override
    public boolean checkViewAllLinkOnRecommendedForYouCarousel() {return false; }

    @Override
    public boolean checkRedirectionWhenTapOnViewAllLinkFromRecommendedForYouCarousel() { return false; }

    @Override
    public boolean checkForYouTabOnL1() { return false; }

    @Override
    public boolean checkRedirectionWhenTapOnStoryFromRecommendedForYouCarousel() { return false; }

    @Override
    public boolean checkDailyDigestRedirection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestSectionRedirection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestStoryRedirection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestStoryShare() {
        return false;
    }

    @Override
    public boolean checkLoggedInUserCloseButtonOnDailyNewsCapsule() {
        return false;
    }

    @Override
    public boolean checkLoggedInUserBackButtonOnDailyNewsCapsule() {
        return false;
    }

    @Override
    public boolean checkTabOnXInSubscribeToNewsletterBehaviour() {
        return false;
    }

    @Override
    public boolean checkPrivacyPolicyLinkOnDailyNewsCapsule() {
        return false;
    }

    @Override
    public boolean checkEmailAddressNewslettersTextOnDailyNewsCapsule() {
        return false;
    }

    @Override
    public boolean checkEmailIsPreFilledTextOnDailyNewsCapsule(String email) {
        return false;
    }

    @Override
    public boolean checkTextOnNewsLetterForNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkQuickReadsEntertainmentRedirection() {
        return false;
    }

    @Override
    public boolean checkQuickReadsAllTabRedirection() {
        return false;
    }

    @Override
    public boolean checkQuickReadsIndiaNewsTabRedirection() {
        return false;
    }

    @Override
    public boolean checkQuickReadsBusinessTabRedirection() {
        return false;
    }

    @Override
    public boolean checkQuickReadsSportsTabRedirection() {
        return false;
    }

    @Override
    public boolean checkAstrologySectionAfterLifestyleInQuickReads() {
        return false;
    }

    @Override
    public boolean checkDailyDigestDisplayedOnExplore() {
        return false;
    }

    @Override
    public boolean checkRedirectToCricketSectionFromQuickReads() {
        return false;
    }

    @Override
    public boolean checkRedirectToCitiesSectionFromQuickReads() {
        return false;
    }

    @Override
    public boolean checkRedirectToWorldNewsSectionFromQuickReads() {
        return false;
    }

    @Override
    public boolean checkRedirectToLifeStyleSectionFromQuickReads() {
        return false;
    }

    @Override
    public boolean checkRedirectToAstrologyTabFromQuickRead() {
        return false;
    }

    @Override
    public boolean checkWorldNewsDisplayedAfterCitiesSectionInQuickReads() {
        return false;
    }

    @Override
    public boolean checkAllTabInQuickRead() {
        return false;
    }

    @Override
    public boolean checkLifeStyleSectionAfterWorldNewsInQuickReads() {
        return false;
    }

    @Override
    public boolean checkBusinessSectionAfterSportsInQuickReads() {
        return false;
    }

    @Override
    public boolean checkIndiaNewsSectionAfterAllTabInQuickReads() {
        return false;
    }

    @Override
    public boolean checkEntertainmentSectionAfterIndiaNewsInQuickReads() {
        return false;
    }

    @Override
    public boolean checkCricketSectionAfterEntertainmentInQuickReads() {
        return false;
    }

    @Override
    public boolean checkCitiesSectionAfterCricketInQuickReads() {
        return false;
    }

    @Override
    public boolean checkSportsSectionAfterAstrologyInQuickReads() {
        return false;
    }

    @Override
    public boolean checkSwipeUpAndAdAfter4StoriesInQuickReads() {
        return false;
    }

    @Override
    public boolean checkOtherSectionBySwipingLeftToRightInQuickReads() {
        return false;
    }

    @Override
    public boolean checkOtherSectionBySwipingRightToLeftInQuickReads() {
        return false;
    }

    @Override
    public boolean checkSwipeTopToBottomInQuickReads() {
        return false;
    }

    @Override
    public boolean checkSwipeBottomToTopInQuickReads() {
        return false;
    }

    @Override
    public boolean checkSecondAdAfter8SwipeInQuickReads() {
        return false;
    }

    @Override
    public boolean checkSwipeUpOptionInFirstAdInQuickReads() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryIfTabOnBlankSpaceInQuickReads() {
        return false;
    }

    @Override
    public boolean checkEPaperOptionFromCricketHeader() {
        return false;
    }

    @Override
    public boolean checkEPaperOptionFromPremiumHeader() {
        return false;
    }

    @Override
    public boolean checkEPaperOptionFromExploreHeader() {
        return false;
    }

    @Override
    public boolean checkRedirectToDailyDigestFromExplore() {
        return false;
    }

    @Override
    public boolean checkCityNewsInHomepageDisplayed() { return false; }

    @Override
    public boolean checkListOfCitiesInCityNewsDisplayed() { return false; }

    @Override
    public boolean checkRedirectionWhenUserTapsOnViewAllInCityNews() { return false;}

    @Override
    public boolean checkSectionPageSelectedCityShownInHomePage() { return false;}

    @Override
    public boolean checkHomePageSelectedCityShownInSectionPage() { return false;}

    @Override
    public boolean checkAllL1SubMenuPresentAnd200StatusCode() {
        return false;
    }

    @Override
    public boolean checkAllL2SubMenuPresentAnd200StatusCode() {
        return false;
    }

    @Override
    public boolean checkFirstCollectionTopNews() {
        return false;
    }

    @Override
    public boolean checkHeaderTopAd() {
        return false;
    }

    @Override
    public boolean checkMoreOptionInL2() {
        return false;
    }

    @Override
    public boolean checkLHSAndRHSCollectionAndStories() {
        return false;
    }

    @Override
    public boolean checkAdInTopAndAfterCollectionInRHS() {
        return false;
    }

    @Override
    public boolean checkFooterAndData() {
        return false;
    }

    @Override
    public boolean checkAdsAfterEveryCollectionInMiddleLayer() {
        return false;
    }

    @Override
    public boolean checkL3SubMenuAnd200SuccessCode() {
        return false;
    }

    @Override
    public boolean checkAllTopicSuccessCode200() {
        return false;
    }
}
