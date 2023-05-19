package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonHomePage {
    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//div[contains(@class, 'pl10 custom-style pr10')]/preceding-sibling::div[@class='new_ads_unit']//amp-ad")
    private static WebElement epaperCTA;

    @FindBy(xpath = "//amp-social-share[@type='twitter']")
    private static WebElement twitterShareOptionInlineStory;

    @FindBy(xpath = "(//span[text()='View All'])[16]")
    private static WebElement viewAll;
    @FindBy(css = ".navIco")
    private static WebElement explore;

    @FindBy(xpath = "//span[text()='view more']")
    private static WebElement viewMore;

    @FindBy(xpath = "//div[@class='btnExplore']/button")
    private  static  WebElement hamburger;

    @FindBy(xpath=" //ul[@class='leftFixedNav']")
    private static WebElement fixedNavBar;

    @FindBy(xpath="(//div[@class='secHdg'])[1]/div")
    private static WebElement topNews;

    @FindBy(className="searchLink")
    private static WebElement searchHere;

    @FindBy(xpath = "//button[@class='crossicon']")
    private static WebElement closeOption;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[6]/a")
    private static WebElement entertainmentSection;

    @FindBy(xpath = "//div[@class='nav-footer']")
    private static WebElement footerOption;

    @FindBy(xpath = "//div[@class='sidenav-heaer']")
    private static WebElement sideNavigation;

    @FindBy(xpath = "//div[@class='logo']//a")
    private static WebElement HtLogo;

    @FindBy(xpath="//a[text()='Latest']")
    private static WebElement latest;
    @FindBy(xpath="//ul[@class='leftFixedNav']//li[3]//a[1]")
    private static WebElement indiaNews;

    @FindBy(xpath="//div[@class='nav-sec']//li[3]//a")
    private static WebElement entertainmentOption;

    @FindBy(xpath="(//a[@class='view'])[2]")
    private static WebElement viewMoreButton;

    @FindBy(xpath = "//a[@data-vars-event-label='India News']")
    private static WebElement sectionIndiaNews;

    @FindBy(xpath ="//div[@class='listPagination']")
    private static WebElement listPagination;

    @FindBy(xpath="//ul[@class='leftFixedNav']//li[10]/a")
    private static WebElement editorials;
    @FindBy(xpath="//div[@class='logo']//a")
    private static WebElement htLogo;

    @FindBy(xpath = "//a[text()='My Reads']")
    private static  WebElement mostRead;
    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean checkTopNewsAvailabilty(){
        boolean isTopNewsAvailable=false;
        isTopNewsAvailable=commonFunctions.isElementDisplayed(topNews,20);
        Utils.logStepInfo(true,"Tops News Available");
        return isTopNewsAvailable ;
    }

    public boolean checkTopNavBarAvailabilty(){
        boolean isTopNavBarAvailable=false;
        isTopNavBarAvailable=commonFunctions.isElementDisplayed(fixedNavBar,20);
        isTopNavBarAvailable &=commonFunctions.isElementDisplayed(latest, 10, "Latest");
        boolean isEditorialDisplayed =commonFunctions.isElementDisplayed(editorials,10,"Editorial Displayed");
        Utils.logStepInfo(true,"Fixed Nav Bar Latest,Exclusive Displayed");
        return isTopNavBarAvailable && isEditorialDisplayed;
    }

    public boolean checkExistingOptionVisible() {
        boolean isViewMoreDisplayed;
        commonFunctions.clickElementWithJS(closeOption,10,"Close Successfully");
        commonFunctions.clickElementWithJS(latest, 10, "LATEST");
        commonFunctions.scrollToBottomWorked();
        isViewMoreDisplayed = commonFunctions.isElementDisplayed(viewMoreButton, 25, "View More");
        Utils.logStepInfo(true, "Loading is working Successfully and footer is not displayed");
        return isViewMoreDisplayed;
    }

    public boolean navigateIndiaNews() {
        boolean isViewMoreDisplayed;
        commonFunctions.clickElement(closeOption);
        commonFunctions.clickElementWithJS(sectionIndiaNews);
        commonFunctions.scrollDownToBottom();
        isViewMoreDisplayed = commonFunctions.isElementDisplayed(viewMore, 25, "View More");
        Utils.logStepInfo(true, "Loading is working Successfully and footer is not displayed");
        return isViewMoreDisplayed;
    }


    public boolean checkHtLogoAndReloading() {
        boolean isReloadingSuccessful = false;
        try {
            commonFunctions.clickElementWithJS(HtLogo, 15, "Hindustan Times Logo");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.contains(globalVars.getAmpUrl())) {
                isReloadingSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReloadingSuccessful;
    }
    public boolean checkExploreOptionOpening() {
        boolean isExploreOptionDisplayed;
        commonFunctions.navigateURl(globalVars.getAmpUrl());
        isExploreOptionDisplayed= commonFunctions.clickElementWithJS(explore, 25, "Explore Option");
        Utils.logStepInfo(true, "Explore Option is Opening");
        return isExploreOptionDisplayed;
    }

    public boolean isNavigatedToArtPage(String params[]) {
        boolean isNavigatedToArtPage=false;
        commonFunctions.navigateToURL(globalVars.getURL()+params[3]);
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if (currentURL.equals(globalVars.getURL()+params[0])) {
            isNavigatedToArtPage = true;
        }
        return isNavigatedToArtPage;
    }

    public boolean scrollDownTheStory() {
        boolean isScrollDownPageSuccessful=false;
        isScrollDownPageSuccessful = commonFunctions.scrollToElementView(twitterShareOptionInlineStory, 20, "twitterShareOptionInlineStory");
        return isScrollDownPageSuccessful;
    }

    public boolean checkEpaperCTADisplayed() {
        boolean isEPaperCTADisplayed=false;
        isEPaperCTADisplayed = commonFunctions.isElementDisplayed(epaperCTA, 20, "epaperCTA");
        return isEPaperCTADisplayed;
    }
    public boolean checkEpaperCTARedirection(String params[]) {
        boolean isEPaperCTARedirectionSuccessful=false;
        isEPaperCTARedirectionSuccessful = commonFunctions.clickElement(epaperCTA, 20, "epaperCTA");
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if (currentURL.contains(params[1])) {
            isEPaperCTARedirectionSuccessful = true;
        }
        return isEPaperCTARedirectionSuccessful;
    }
    @Override
    public boolean checkAdDisplayingHomePage() {
        return false;
    }

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
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean checkHtLogoAndReloading = checkHtLogoAndReloading();
        boolean checkExploreOptionOpening = checkExploreOptionOpening();
        boolean checkExistingOption = checkExistingOption();
        return checkExistingOption && checkHtLogoAndReloading && checkExploreOptionOpening  ;
    }

    public boolean checkExistingOption() {
        boolean isExistingOption = false;
        commonFunctions.scrollDownToBottom();
        boolean isViewMoreDisplayed = commonFunctions.isElementDisplayed(viewMore, 25, "View More");
        Utils.logStepInfo(true, "Loading is working Successfully");
        if (!(commonFunctions.isElementDisplayed(footerOption, 25,"Footer Option"))) {
            isExistingOption = true;
            Utils.logStepInfo(true, "Footer Option is Not available at the Bottom of Webpage");
        }
        return isExistingOption && isViewMoreDisplayed;
    }


    @Override
    public boolean checkTopAdsClickable() {
        return false;
    }

    @Override
    public boolean checkHamburgerMenuAllOptionDisplayed() throws Exception {
        return false;
    }

    @Override
    public boolean checkLiveblogPaginationEmbeds(String title) {
        return false;
    }

    @Override
    public boolean checkHomePageLoadingVerification() {
        commonFunctions.navigateURl(globalVars.getAmpUrl());
        boolean isShowing= commonFunctions.isElementDisplayed(topNews, 20, "Top News");
        isShowing &=commonFunctions.isElementDisplayed(fixedNavBar, 20, "Fixed Nav Bar");
        isShowing &=commonFunctions.isElementDisplayed(latest, 20, "Latest option Fixed Nav Bar");
        isShowing &=commonFunctions.isElementDisplayed(editorials, 20, "Editorials Option Fixed Nav Bar");
        isShowing &= commonFunctions.clickElementWithJS(htLogo, 10, "Ht Logo");
        isShowing &= commonFunctions.checkPageUrlContainsText("amp" , 15, "Reload Verfified");
        isShowing &= commonFunctions.clickElementWithJS(explore, 10, "Explore");
        isShowing &= commonFunctions.clickElementWithJS(closeOption, 10, "Close Hamburger Menu");
        isShowing &= commonFunctions.clickElementWithJS(entertainmentSection, 10, "Entertainment");
        commonFunctions.scrollToBottom();
        isShowing &= commonFunctions.isElementDisplayed(viewMoreButton, 20, "View More button");
        return isShowing;
    }

    @Override
    public boolean checkLeftPaneDisplayed() {
        return false;
    }

    @Override
    public boolean checkEpaperCta(String[] params) {
        return false;
    }

    @Override
    public boolean checkHomePageItems() {
        return false;
    }

    @Override
    public boolean checkPremiumArtExclusiveTag() {
        return false;
    }

    @Override
    public boolean checkHTAutoRedirection() {
        return false;
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
