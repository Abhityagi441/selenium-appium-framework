package com.pages.HindustanTimes.android_amp;

import java.util.List;
import java.util.NoSuchElementException;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends CommonHomePage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    public static String storyName;

    @FindBy(xpath = "(//a[@class='sign-in'])[1]")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(xpath = "(//div[@class='secHdg'])[1]")
    private static WebElement topNews;
    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin") //login
    private static WebElement signInButtonMainSignInPage;
    @FindBy(xpath = "//div[text()='Use another account']")
    private static WebElement useAnotherAccountGmailSignInPage;
    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;
    @FindBy(id = "account_name_text_field")
    private static WebElement emailAppleSignInPage;
    @FindBy(id = "password_text_field")
    private static WebElement passwordAppleSignInPage;
    @FindBy(id = "sign-in")
    private static WebElement appleSignInNextButton;
    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;
    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;
    @FindBy(xpath = "//input[@type='submit']") //input[@value='Log In']
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "(//div[@class='logged-in']//span[2])[1]")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "(//a[@class='sign-out'])[1]")
    private static WebElement LogoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(xpath = "//span[@class='bookmark bookmark-candidate']")
    private static WebElement bookmarkButton;
    @FindBy(xpath = "//a[text()='Saved']")
    private static WebElement savedLink;

    @FindBy(xpath="//span[@class='bookmark bookmark-candidate']//preceding::h3//a")
    private static WebElement storyTitle;

    @FindBy(xpath = "//span[@class='bookmark morebm bookmark-candidate saved']//preceding::h3//a")
    private static WebElement savedStoryTitle;

    @FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
    private static WebElement openFullStory;
    @FindBy(xpath="//div[@class='storyShortDetail']//div[contains(@class,'catName')]")
    private static WebElement section;

    @FindBy(xpath="//div[@class='storyShortDetail']//h3[@class='hdg3']")
    private static WebElement headline;

    @FindBy(xpath = "//div[@class='storyShortDetail']//div[@class='sortDec']")
    private static WebElement summary;

    @FindBy(xpath="(//div[@class='cartHolder bigCart']//h3[@class='hdg3'])[1]")
    private static WebElement openFullStorySaved;

    @FindBy(xpath="//div[contains(@class,'storyDetails')]//div//p")
    private static WebElement paragraph;

    @FindBy(xpath = "//div[contains(@class,'shareIcons')]")
    private static WebElement shareIcons;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private  static WebElement topics;

    @FindBy(xpath="//a[contains(@class,'closeStory')]")
    private static WebElement closeButton;

    @FindBy(xpath="//div[@class='storyBy']")
    private static WebElement storyBy;

    @FindBy(xpath = "//div[@class='new_ads_unit']")
    private static WebElement epaperCTA;

    @FindBy(xpath = "//amp-social-share[@type='twitter']")
    private static WebElement twitterShareOptionInlineStory;
    
    @FindBy(xpath = "//img[@alt='Hindustan Times News']")
    private static WebElement HtLogo;

    @FindBy(xpath = "//div[@class='container']//button")
    private static WebElement hamBurger;

    @FindBy(className = "searchLink")
    private static WebElement searchHere;


    @FindBy(xpath = "//button[@class='crossicon']")
    private static WebElement closeOption;

    @FindBy(xpath = "//div[@class='nav-footer']")
    private static WebElement footerOption;

    @FindBy(xpath = "//a[text()='Latest']")
    private static WebElement latestSection;

    @FindBy(xpath = "//div[@class='secHdg']")
    private static WebElement latestNews;

    @FindBy(xpath = "//span[text()='view more']")
    private static WebElement viewMore;

    @FindBy(xpath="//figure/a/amp-img")
    private static WebElement lazyLoadingImage;


    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean isNavigatedToArtPage(String params[]) {
        boolean isNavigatedToArtPage=false;
        try {
            commonFunctions.navigateToURL(params[3]);
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(params[3])) {
                isNavigatedToArtPage = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isNavigatedToArtPage;
    }

    public boolean scrollDownTheStory() {
        boolean isScrollDownPageSuccessful=false;
        try {
            isScrollDownPageSuccessful =commonFunctions.scrollToElementView(twitterShareOptionInlineStory, 120, "twitterShareOptionInlineStory");

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isScrollDownPageSuccessful;
    }

    public boolean checkEpaperCTADisplayed() {
        boolean isEPaperCTADisplayed=false;
        try {
            isEPaperCTADisplayed = commonFunctions.isElementDisplayed(epaperCTA, 10, "epaperCTA");

        }
        catch(Exception e){
            isEPaperCTADisplayed=false;
        }
        return isEPaperCTADisplayed;
    }

    public boolean checkEpaperCTARedirection(String params[]) {
        boolean isEPaperCTARedirectionSuccessful=false;
        try {
            isEPaperCTARedirectionSuccessful = commonFunctions.clickElement(epaperCTA, 40,"epaperCTA");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.contains(params[1])) {
                isEPaperCTARedirectionSuccessful = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isEPaperCTARedirectionSuccessful;
    }

    public boolean verifyLazyLoading() throws InterruptedException {
        By elementLocator = By.xpath("//figure/a/amp-img");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Initial element count
        int elementCount = driver.findElements(elementLocator).size();
        System.out.println("element 1 "+elementCount);

        while (true) {
            System.out.println("scroll");
            commonFunctions.scrollToElementViewAndClick(lazyLoadingImage, 20, "LazyLoadingImage");
            System.out.println("scrollend");

            // javascriptexecutor to scroll the page
            //js.executeScript("window.scrollTo(0, document.body.scrollHeight || document.documentElement.scrollHeight)","");
            js.executeScript("window.scrollBy(0,350)", "");
            wait.ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
        System.out.println("Test");
            // Wait to load the new elements
            Thread.sleep(2000);
            System.out.println("Scrolllinngg");

            // Check if the last fetch element count is same as new count,
            // If it's same then we already have fetch all the elements on the page.
            if (driver.findElements(elementLocator).size() == elementCount)
                break;

            // fetch the latest elements count
            elementCount = driver.findElements(elementLocator).size();
        }
        return false;

    }






    @Override
    public boolean checkEpaperCTALogoRedirection(String params[]) {
        boolean checkEpaperRedirection = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollToElement(topNews,"topNews");
        commonFunctions.clickElementWithJS(openFullStory,20,"Clicked on ReadFull Story");
        boolean scrollDownStory = scrollDownTheStory();
        boolean checkEpaper = checkEpaperCTADisplayed();
        if(checkEpaper) {
            checkEpaperRedirection = checkEpaperCTARedirection(params);
        }
        else{
            Utils.logStepInfo("Epaper not found");
            checkEpaperRedirection =true;
        }

        return  scrollDownStory && checkEpaperRedirection ;
    }

    @Override
    public boolean checkAdDisplayingHomePage() {
        return false;
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



    public boolean checkHtLogoAndReloading() {
        boolean isReloadingSuccessful = false;
        try {
            commonFunctions.getURL(globalVars.getAmpUrl());
            commonFunctions.isElementDisplayed(HtLogo, 25);
            commonFunctions.clickElementWithJS(HtLogo, 25, "Hindustan Times Logo");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getURL())) {
                isReloadingSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReloadingSuccessful;



    }

    public boolean checkExploreOptionOpening() {
        boolean isExploreOptionDisplayed;
        commonFunctions.isElementDisplayed(searchHere, 25);
        commonFunctions.clickElementWithJS(hamBurger, 25, "Explore Option");
        commonFunctions.clickElementWithJS(closeOption, 25, "Close Option");
        commonFunctions.clickElementWithJS(latestSection,25,"Latest Section");
        isExploreOptionDisplayed = commonFunctions.isElementDisplayed(latestNews,25,"Latest News");
        return isExploreOptionDisplayed;
    }



    @Override
    public boolean checkHomePageLoaded(String[] params) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean checkHtLogoAndReloading = checkHtLogoAndReloading();
        boolean checkExploreOptionOpening = checkExploreOptionOpening();
        boolean checkExistingOption = checkExistingOption();
        return checkExistingOption && checkHtLogoAndReloading && checkExploreOptionOpening  ;
    }

    @Override
    public boolean checkTopAdsClickable() {
        return false;
    }

    @Override
	public boolean checkHamburgerMenuAllOptionDisplayed() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkLiveblogPaginationEmbeds(String title) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean checkHomePageLoadingVerification() {
        return false;
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
        return false;}

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
