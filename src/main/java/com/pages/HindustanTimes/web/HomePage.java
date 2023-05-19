
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.MobileElement;
import org.apache.xpath.res.XPATHErrorResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomePage extends CommonHomePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyName;
    @FindBy(xpath = "(//a[@class='sign-in'])[1]")
    private static WebElement singInButton;
    @FindBy(className ="skip")
    private static WebElement skipPrompt;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
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
    @FindBy(xpath = "//a[@href='/ht-wknd']//span[contains(text(),'View All')]")
    private static WebElement scrollBottomOfPage;
    @FindBy(xpath = "//a[normalize-space()='India']")
    private static WebElement verifyLeftNav;
    @FindBy(xpath = "//img[@alt='Hindustan Times News']")
    private static WebElement clickOnHtLogo;
    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement clikExploreOption;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private static WebElement homeOption;
    @FindBy(xpath = "//a[normalize-space()='Latest News']")
    private static WebElement latestOption;
    @FindBy(xpath = "//a[normalize-space()='India']")
    private static WebElement indiaOption;
    @FindBy(xpath = "//a[normalize-space()='World']")
    private static WebElement worldOption;
    @FindBy(xpath = "//a[contains(text(),'Mumbai')]")
    private static WebElement mumbaiOption;
    @FindBy(xpath = "//ul[@class='leftFixedNav']//a[normalize-space()='Entertainment']")
    private static WebElement entertainmentOption;
    @FindBy(xpath = "//a[contains(text(),'Cricket')]")
    private static WebElement cricketOption;
    @FindBy(xpath = "//a[contains(text(),'Lifestyle')]")
    private static WebElement lifestyleOption;
    @FindBy(xpath = "//a[contains(text(),'Astrology')]")
    private static WebElement astrologyOption;
    @FindBy(xpath = "//a[normalize-space()='Editorials']")
    private static WebElement editorialsOption;
    @FindBy(xpath = "//a[contains(text(),'For You')]")
    private static WebElement forYouOption;
    @FindBy(xpath = "//div[@class='detail ']/p[7]")
    private static WebElement epaperCTA;

    @FindBy(xpath="//div[contains(@class,'epaper-ad')]")
    private static WebElement epaperAd;

    @FindBy(xpath="//div[@id='google_image_div']")
    private static WebElement epaperNavigation;

    @FindBy(xpath="//iframe[contains(@id,'HindustanTimes_Desktop_Epaper')]")
    private static WebElement frameEpaper;
    @FindBy(xpath = "//div[@class='shareArticle']")
    private static WebElement twitterShareOptionInlineStory;

    @FindBy(xpath = "//a[contains(text(),'Shop Now')]")
    private static WebElement shopNow;
    @FindBy(xpath = "(//iframe[contains(@aria-label,'Advertisement')])[1]")
    private static WebElement topAd;

    @FindBy(xpath = "//div[@class='logo']//a")
    private static WebElement HtLogo;

    @FindBy(xpath = "//span[@class='navIco']")
    private static WebElement exploreOption;

    @FindBy(xpath = "//div[@class='searchLink']/a")
    private static WebElement searchHere;

    @FindBy(className = "weather")
    private static WebElement weatherReport;

    @FindBy(xpath = "//span[@class='crossicon']")
    private static WebElement closeOption;

    @FindBy(className = "footer__ht__links")
    private static WebElement footerOption;

    @FindBy(xpath = "(//div[@class='viewMoreButton'])[10]")
    private static WebElement viewAll;

    @FindBy(xpath = "//span[@class='bookmark bookmark-candidate']")
    private static WebElement bookmarkButton;
    @FindBy(xpath = "//a[text()='Saved']")
    private static WebElement savedLink;

    @FindBy(xpath="//span[@class='bookmark bookmark-candidate']//preceding::h3//a")
    private static WebElement storyTitle;

    @FindBy(xpath = "//span[@class='bookmark morebm bookmark-candidate saved']//preceding::h3//a")
    private static WebElement savedStoryTitle;

    @FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
    public static WebElement openFullStory;
    @FindBy(xpath="//div[@class='storyShortDetail']//div[contains(@class,'catName')]")
    private static WebElement section;

    @FindBy(xpath="//div[@class='storyShortDetail']//h3[@class='hdg3']")
    private static WebElement headline;

    @FindBy(xpath = "//div[@class='storyShortDetail']//div[@class='sortDec']")
    private static WebElement summary;

    @FindBy(xpath="//a[text()='READ FULL STORY']")
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

    @FindBy(xpath = "//span[@class='crossicon']")
    private static WebElement closeExplore;

    @FindBy(xpath = "//div[@class='main-trend-topics']//a")
    private static WebElement trendingCarousel;

    @FindBy(id = "div-gpt-firstslot-ad")
    private static WebElement pageTopAd;

    @FindBy(xpath = "//div[@class = 'headMenu']/div/ul[1]/li")
    private static List<WebElement> l1SubMenuOptions;

    @FindBy(xpath = "//div[@class = 'headMenu']/div/ul[2]/li/a")
    private static List<WebElement> l2SubMenuOptions;

    @FindBy(xpath = "//a[contains(text(),'more')]")
    private static WebElement moreOptionInL2SubMenu;

    @FindBy(xpath = "//ul[@id='subnav_more']/li/a")
    private static List<WebElement> l2SubMenuMoreOptions;

    @FindBy(xpath = "//*[@id='topnews']/section/h2/span[2]")
    private static WebElement topNewsHeading;

    @FindBy(xpath = "//div[contains(@class,'desktopAd')]//div[contains(@id,'div-gpt-ad')]/div/iframe")
    private static WebElement headerTopAd;

    @FindBy(xpath = "//aside[@class = 'leftNav']/div/div/div/div")
    private static List<WebElement> listOfStoriesInLHS;

    @FindBy(xpath = "//div[@id='divphotosRight']/div/div[2]/div/h3")
    private static List<WebElement> listOfStoriesInRHS;

    @FindBy(xpath = "//aside[@class = 'rgtAdSection']/div")
    private static List<WebElement> listOfAdsAndCollectionInRHS;

    @FindBy(xpath = "//footer/div[@class = 'container']")
    private static WebElement firstFooter;

    @FindBy(xpath = "//div[@class = 'footer__ht__links']")
    private static WebElement secondFooter;

    @FindBy(xpath = "//footer/div/div[3]/ul/li/a")
    private static List<WebElement> firstFooterOptions;

    @FindBy(xpath = "//div[@class = 'footer__ht__links']//div[1]/ul/li")
    private static List<WebElement> secondFooterOptions;

    @FindBy(id = "topnews")
    private static WebElement topNewsCollection;

    @FindBy(xpath = "//*[@id='topnews']/div[2]/div[@id = 'div-gpt-firstslot-ad']")
    private static WebElement firstAdAfterTopNewsSection;

    @FindBy(xpath = "//*[@id='cricketnews']")
    private static WebElement cricketNewsCollection;

    @FindBy(xpath = "//*[@id='cricketnews']/div[2]/div[contains(@id,'adslot')]")
    private static WebElement AdAfterCricketSection;

    @FindBy(xpath = "//section[@class = 'mainContainer']//section/following-sibling::div[contains(@class,'adHeight')]")
    private static List<WebElement> listOfAdsInMiddleLayer;

    @FindBy(xpath = "//section[@class = 'mainContainer']//section")
    private static List<WebElement> listOfSectionInMiddleLayer;

    @FindBy(xpath = "//section[@id='dataHolder']/h1/span[2]")
    private static WebElement topicHeading;

    @FindBy(xpath = "//section[@id='dataHolder']/div[2]/nav/ul/li/span/a")
    private static List<WebElement> listOfL3SubMenu;

    @FindBy(xpath = "//section[@id='dataHolder']/div/a")
    private static List<WebElement> listOfAllTopics;

    public static HomePage homePage;
    public static HomePage getInstance(){
        if(homePage==null){
            homePage= new HomePage();
        }
        return homePage;
    }

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean  addToBookmarkandverify()
    {boolean isStep;

       commonFunctions.scrollUsingAction(openFullStory);
       isStep=commonFunctions.clickElement(bookmarkButton);
       String text=commonFunctions.getElementText(storyTitle);
       isStep=commonFunctions.clickElement(savedLink);
       commonFunctions.scrollUsingAction(openFullStorySaved);
        isStep=commonFunctions.getElementText(savedStoryTitle).equalsIgnoreCase(text);


       return isStep;
    }

    public  boolean clickReadFullStory(){
        boolean isStep=false;
        commonFunctions.scrollUsingAction(openFullStory);
        storyName=commonFunctions.getElementText(storyTitle);
        isStep=commonFunctions.clickElement(openFullStory);
        return isStep;
    }

    public  boolean checkCurrentUrlAsPerStory(){
        boolean isStep=false;

        String currentURL = commonFunctions.giveCurrentUrl();
        if(currentURL.isEmpty())
            isStep=false;
        else
            isStep=true;
        return isStep;
    }

    public boolean isNavigatedToArtPage(String params[]) {
        boolean isNavigatedToArtPage=false;
        try {
            commonFunctions.navigateToURL(globalVars.getURL()+params[0]);
            String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
            if (currentURL.equals(globalVars.getURL()+params[0])) {
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
            isScrollDownPageSuccessful = commonFunctions.scrollToElementView(epaperCTA, 20, "epaperCTA");

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isScrollDownPageSuccessful;
    }

    public boolean checkEpaperCTADisplayed() {
        boolean isEPaperCTADisplayed=false;
        try {
            isEPaperCTADisplayed = commonFunctions.scrollToElementView(epaperCTA, 20, "epaperCTA");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isEPaperCTADisplayed;
    }
    
    public boolean checkURLChangedOrNot(){
        boolean isUrlChangedSuccessful = false;
        try {
            isUrlChangedSuccessful = commonFunctions.scrollToElementViewAndClick(epaperCTA, 20, "epaperCTA");
            String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
            if (currentURL.contains("https://epaper.hindustantimes.com/")) {
                isUrlChangedSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUrlChangedSuccessful;



    }

    public boolean checkEpaperCTARedirection(String params[]) {
        boolean isEPaperCTARedirectionSuccessful=false;
        try {
           // isEPaperCTARedirectionSuccessful = commonFunctions.scrollToElementViewAndClick(epaperCTA, 20, "epaperCTA");
//            isNavigatedToArtPage(params);
//            commonFunctions.pageRefresh();
            commonFunctions.scrollToElementView(epaperCTA,10,"epaperCTA");
            if(!commonFunctions.isElementDisplayed(frameEpaper,10,"frameEpaper")){
                commonFunctions.pageRefresh();
                commonFunctions.scrollToElementView(epaperCTA,10,"epaperCTA");

            }
            commonFunctions.switchToFrame("google_ads_iframe_/3106570/HindustanTimes_Desktop_Epaper/HT_Desk_Story_Epaper_Banner_0");

            if(commonFunctions.isElementDisplayed(epaperNavigation)) {
               isEPaperCTARedirectionSuccessful = commonFunctions.clickElement(epaperNavigation, 10, "epaperNavigation");
               String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
               if (currentURL.contains(params[1])) {
                   isEPaperCTARedirectionSuccessful = true;
               }
           }
           else{
               Utils.logStepInfo("No epaper found");
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isEPaperCTARedirectionSuccessful;
    }



    public  boolean checkSection(){
        boolean isStep=false;
        isStep=commonFunctions.isElementDisplayed(section);
        return isStep;
    }

    public  boolean checkheadline(){
        boolean isStep=false;
        isStep=commonFunctions.isElementDisplayed(headline);
        return isStep;
    }

    public  boolean checkSummary(){
        boolean isStep=false;
        isStep=commonFunctions.isElementDisplayed(summary);
        return isStep;
    }

    public boolean checkExistingOption() {
    	
        boolean isExistingOptionDisplayed = false;
        try {
        commonFunctions.scrollDown(viewAll);
        commonFunctions.isElementDisplayed(viewAll,20,"View All");
        Utils.logStepInfo(true,"Loading is working Successfully");
        commonFunctions.scrollToElementView(shopNow, 20,"savedOption");
        isExistingOptionDisplayed = commonFunctions.clickElement(shopNow, 20, "Saved Option");
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return isExistingOptionDisplayed;
    }
    
    public boolean checkHtLogoAndReloading() {

        boolean isReloadingSuccessful = false;
        try {
            commonFunctions.isElementDisplayed(HtLogo, 20,"HtLogo");
            commonFunctions.clickElement(HtLogo, 20, "Hindustan Times Logo");
            String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
            if (currentURL.equals(globalVars.getURL())) {
                isReloadingSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isReloadingSuccessful;
    }

    public boolean checkExploreOptionOpening() {
        boolean isExploreOptionDisplayed = false;
        try {
        commonFunctions.clickElementWithJS(exploreOption, 20, "Explore Option");
        commonFunctions.isElementDisplayed(weatherReport, 20, "Weather");
        Utils.logStepInfo(true, "Explore Option is Opening");
        isExploreOptionDisplayed = commonFunctions.clickElement(closeOption, 20, "Close Option");
            commonFunctions.scrollToElementView(footerOption,10, "footerOption");
            commonFunctions.isElementDisplayed(footerOption, 20, "footerOption");
        Utils.logStepInfo(true, "Footer Option is available at the Bottom of Webpage");
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return isExploreOptionDisplayed;
    }

    @Override
    public boolean checkHomePageLoaded(String[] params) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean checkExistingOption = checkExistingOption();
        boolean checkHtLogoAndReloading = checkHtLogoAndReloading();
        boolean checkExploreOptionOpening = checkExploreOptionOpening();
        return checkExistingOption && checkHtLogoAndReloading && checkExploreOptionOpening;
    }

    @Override
    public boolean checkHomePageLoadingVerification() {
        boolean isVerificationSuccessful = false;
        commonFunctions.scrollToElementView(scrollBottomOfPage,10, "view all");
        commonFunctions.clickElement(verifyLeftNav, 10, "india option");
        commonFunctions.isElementDisplayed(verifyLeftNav, 10,"india option");
        String currentUrlBeforeClick =  commonFunctions.getURL();
        commonFunctions.clickElement(clickOnHtLogo, 10,"Hindustan Times logo");
        String currentUrlAfterClick = commonFunctions.getURL();
        Utils.logStepInfo(currentUrlAfterClick.equalsIgnoreCase(currentUrlBeforeClick),"Redirection is working successful");
        commonFunctions.clickElement(clikExploreOption, 10, "explore option");
        Utils.logStepInfo("explore option clicked successfully");
        isVerificationSuccessful = commonFunctions.isElementDisplayed(singInButton, 20);
        Utils.logStepInfo(isVerificationSuccessful,"explore option is opening");
        commonFunctions.clickElement(closeExplore, 10, "closeExplore");
        return isVerificationSuccessful;

    }

    @Override
    public boolean checkLeftPaneDisplayed() {
        boolean isLeftPaneOptionsDisplayed=true;
        isLeftPaneOptionsDisplayed &= commonFunctions.isElementEnabled(homeOption, 5, "Home Option is Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(latestOption, 5, "Latest Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(indiaOption, 5, "India Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(worldOption, 5, "World Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(mumbaiOption, 5, "Mumbai Cities Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(entertainmentOption, 5, "Entertainment Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(cricketOption, 5, "Cricket Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(lifestyleOption, 5, "Lifestlye Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(astrologyOption, 5, "Astrology Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(editorialsOption, 5, "Editorials Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(forYouOption, 5, "For Yoy Option Enabled & Displayed");
        isLeftPaneOptionsDisplayed &=commonFunctions.isElementEnabled(shopNow, 5, "Shop Now Option Enabled & Displayed");
        return isLeftPaneOptionsDisplayed;
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
        boolean isTrendingCarouselDisplayed=false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollToElement(trendingCarousel, "Trending Carousel");
        commonFunctions.isElementDisplayed(trendingCarousel, 20,"Trending Carousel");
        String trendingCarouselText=commonFunctions.getElementText(trendingCarousel);
        isTrendingCarouselDisplayed=commonFunctions.checkTextContains("Trending News",trendingCarouselText,"Carousel Name");
        return isTrendingCarouselDisplayed;
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


    public  boolean checkLeadLineCaptionImageCredit(){
        boolean isStep=false;
        isStep= commonFunctions.isElementDisplayed(storyBy);

        return isStep;
    }

    public  boolean checkParagraph(){

        boolean isStep=false;
        commonFunctions.scrollUsingAction(paragraph);
        isStep=commonFunctions.isElementDisplayed(paragraph);
        return isStep;
    }

    public  boolean checkShareIcons(){
        boolean isStep=false;
        commonFunctions.scrollUsingAction(shareIcons);
        isStep=commonFunctions.isElementDisplayed(shareIcons);
        return isStep;

    }

    public  boolean checkTopic(){
        boolean isStep=false;
        commonFunctions.scrollUsingAction(topics);
        isStep=commonFunctions.isElementDisplayed(topics);
        return isStep;
    }

    public  boolean checkclose(){

        boolean isStep=false;
        isStep=commonFunctions.clickElement(closeButton);
        return isStep;
    }
    
    @Override
    public boolean checkEpaperCTALogoRedirection(String params[]) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigateToURL = isNavigatedToArtPage(params);
        commonFunctions.clickElementIfDisplayed(skipPrompt,10,"skipPrompt");
       // boolean scrollDownStory = scrollDownTheStory();
       // boolean checkEpaper = checkEpaperCTADisplayed();
        boolean checkEpaperRedirection = checkEpaperCTARedirection(params);

        return navigateToURL &&  checkEpaperRedirection;
    }



    @Override
	public boolean checkAdDisplayingHomePage() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean checkTopAdsClickable() {
        boolean isTopAdsClickable=true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(pageTopAd, 10, "Top Ad");
        isTopAdsClickable=commonFunctions.clickElementWithActions(pageTopAd, 20,"Homepage Top Ad");
        commonFunctions.dummyWait(5);
        return isTopAdsClickable;
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
        return false;}

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
        boolean isResponseCode200 = true;
        boolean isL1SubMenuPresent = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(HtLogo,5,"HT Logo");
        for (int i =0; i<l1SubMenuOptions.size();i++) {
            isL1SubMenuPresent &= commonFunctions.isElementDisplayed(l1SubMenuOptions.get(i),5,l1SubMenuOptions.get(i).getText());
            commonFunctions.clickElementWithJS(l1SubMenuOptions.get(i),5,l1SubMenuOptions.get(i).getText());
            isResponseCode200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        }
        return isResponseCode200 & isL1SubMenuPresent;
    }

    @Override
    public boolean checkAllL2SubMenuPresentAnd200StatusCode() {
        boolean isResponseCode200 = true;
        boolean isL2SubMenuPresent = true;
        int l2SubMenuCount = l2SubMenuOptions.size();
        commonFunctions.navigateToURL(globalVars.getURL());
        Utils.logStepInfo(true,"Value = "+l2SubMenuOptions.get(l2SubMenuOptions.size()-1).getText());
        if (l2SubMenuOptions.get(l2SubMenuOptions.size()-1).getText().contains(" More"))
        {
            Utils.logStepInfo(true,"value of more = " +l2SubMenuOptions.get(l2SubMenuOptions.size()-1).getText().substring(2,4).trim());
            int numberOfMoreOptionInSubMenu = Integer.parseInt(l2SubMenuOptions.get(l2SubMenuOptions.size()-1).getText().substring(2,4).trim());
            Utils.logStepInfo(true,"numberOfMoreOptionInSubMenu = "+numberOfMoreOptionInSubMenu);
            l2SubMenuCount = l2SubMenuOptions.size()-numberOfMoreOptionInSubMenu-1;
            commonFunctions.mouseHoverOnElement(moreOptionInL2SubMenu,5,"More option");
            for (int i = 0; i < numberOfMoreOptionInSubMenu; i++) {
                isL2SubMenuPresent &= commonFunctions.isElementDisplayed(l2SubMenuMoreOptions.get(i),5,l2SubMenuMoreOptions.get(i).getText());
                String url = commonFunctions.getAttributeValue(l2SubMenuMoreOptions.get(i),5,"href");
                isResponseCode200 &= commonFunctions.getResponseCode(url) == 200;
            }
        }
        for (int i = 0; i < l2SubMenuCount; i++) {
            isL2SubMenuPresent &= commonFunctions.isElementDisplayed(l2SubMenuOptions.get(i),5,l2SubMenuOptions.get(i).getText());
            String url = commonFunctions.getAttributeValue(l2SubMenuOptions.get(i),5,"href");
            isResponseCode200 &= commonFunctions.getResponseCode(url) == 200;
        }
        return isResponseCode200 & isL2SubMenuPresent;
    }

    @Override
    public boolean checkFirstCollectionTopNews() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNewsHeading,5,"Top News");
        return isTopNewsDisplayed;
    }

    @Override
    public boolean checkHeaderTopAd() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(10);
        boolean isHeaderTopAd = commonFunctions.isElementDisplayed(headerTopAd,5,"Top Header Ad");
        return isHeaderTopAd;
    }

    @Override
    public boolean checkMoreOptionInL2() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isMoreOptionDisplayedInL2 = false;
        if(l2SubMenuOptions.get(l2SubMenuOptions.size()-1).getText().contains(" More") && l2SubMenuOptions.get(l2SubMenuOptions.size()-1).getText().contains("+")){
            isMoreOptionDisplayedInL2 = true;
            Utils.logStepInfo(true,"  '+ More' Option Displayed Successfully in L2 Sub Menu");
        }
        else
        {
            Utils.logStepInfo(false,"  '+ More' Option not Displayed in L2 Sub Menu");
        }
        return isMoreOptionDisplayedInL2;
    }

    @Override
    public boolean checkLHSAndRHSCollectionAndStories() {
        boolean isStoryDisplayedInLHSAndRHS = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        if(listOfStoriesInLHS.size() > 1 && listOfStoriesInRHS.size() > 1){
            isStoryDisplayedInLHSAndRHS = true;
            Utils.logStepInfo(true,"LHS and RHS collection loaded and contains stories");
        }
        else{
            Utils.logStepInfo(false,"LHS and RHS collection loaded and contains stories Failed");
        }
        return isStoryDisplayedInLHSAndRHS;
    }

    @Override
    public boolean checkAdInTopAndAfterCollectionInRHS() {
        boolean isTopAdInRHS = false;
        boolean isAdAfterCollectionInRHS = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        Utils.logStepInfo(true,"listOfAdsAndCollectionInRHS.size() = "+listOfAdsAndCollectionInRHS.size());
        for (int i = 0; i<listOfAdsAndCollectionInRHS.size()-1; i++){
            Utils.logStepInfo(true,"i = "+i);
            if (i==0){
                isTopAdInRHS = commonFunctions.getAttributeValue(listOfAdsAndCollectionInRHS.get(i),5,"class").contains("right-top-ad");
                Utils.logStepInfo(true,"isTopAdInRHS = " +isTopAdInRHS);
            }
            else if (i%2==0){
                isAdAfterCollectionInRHS &= (commonFunctions.getAttributeValue(listOfAdsAndCollectionInRHS.get(i),5,"class").contains("adHeight")
                        || (commonFunctions.getAttributeValue(listOfAdsAndCollectionInRHS.get(i),5,"class").contains("adMinHeight")));
                Utils.logStepInfo(true,"Under Else If condition -- isAdAfterCollectionInRHS = " +isAdAfterCollectionInRHS);
            }
            else{
                isAdAfterCollectionInRHS &= (commonFunctions.getAttributeValue(listOfAdsAndCollectionInRHS.get(i),5,"class").contains("holder-right")
                        && (commonFunctions.getAttributeValue(listOfAdsAndCollectionInRHS.get(i),5,"id").contains("Right")));
                Utils.logStepInfo(true,"Under Else Condition -- isAdAfterCollectionInRHS = " +isAdAfterCollectionInRHS);
            }
        }
        return isTopAdInRHS && isAdAfterCollectionInRHS;
    }

    @Override
    public boolean checkFooterAndData() {
        boolean isFooterDisplayed = true;
        boolean firstFooterOptionsDisplayed = true;
        boolean secondFooterOptionsDisplayed = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElementView(firstFooter,10, "First footer Option");
        isFooterDisplayed &= commonFunctions.isElementDisplayed(firstFooter, 5, "First footer Option");
        for(int i = 0; i<firstFooterOptions.size(); i++){
            Utils.logStepInfo(true, "First footer Option value at "+(i+1) +" place is --- " +firstFooterOptions.get(i).getText());
            if (firstFooterOptions.get(i).getText() != null || firstFooterOptions.get(i).getText().equals("")) {
                firstFooterOptionsDisplayed &= true;
                if(i>30){
                    break;
                }
            }
            else{
                firstFooterOptionsDisplayed = false;
                Utils.logStepInfo(false, "Data not available in first Footer");
                break;
            }
        }
        commonFunctions.scrollToElementView(secondFooter,10, "Second footer Option");
        isFooterDisplayed &= commonFunctions.isElementDisplayed(secondFooter, 5, "Second footer Option");
        for(int i = 0; i<secondFooterOptions.size(); i++){
            Utils.logStepInfo(true, "Second footer Option value at "+(i+1) +" place is --- " +secondFooterOptions.get(i).getText());
            if (secondFooterOptions.get(i).getText() != null || secondFooterOptions.get(i).getText().equals("")) {
                secondFooterOptionsDisplayed &= true;
            }
            else{
                secondFooterOptionsDisplayed = false;
                Utils.logStepInfo(false, "Data not available in Second Footer");
                break;
            }
        }
        commonFunctions.clickElement(HtLogo,5,"HT Logo");
        return isFooterDisplayed && firstFooterOptionsDisplayed && secondFooterOptionsDisplayed;
    }

    @Override
    public boolean checkAdsAfterEveryCollectionInMiddleLayer() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        boolean isCollectionDisplayed = false;
        boolean isAdDisplayedAfterCollection = false;
        isCollectionDisplayed = commonFunctions.isElementDisplayed(topNewsCollection,5,"Top News Collection");
        isAdDisplayedAfterCollection = commonFunctions.isElementDisplayed(firstAdAfterTopNewsSection,5,"First Ad After Top News");
        commonFunctions.scrollToElementView(cricketNewsCollection,5,"Cricket Section");
        isCollectionDisplayed &= commonFunctions.isElementDisplayed(cricketNewsCollection,5,"Cricket News Collection");
        isAdDisplayedAfterCollection &= commonFunctions.isElementDisplayed(AdAfterCricketSection,5,"Ad After Cricket News Collection");
        if(listOfSectionInMiddleLayer.size() >5 && listOfAdsInMiddleLayer.size() > 5){
            isCollectionDisplayed &= true;
            isAdDisplayedAfterCollection &= true;
            Utils.logStepInfo(true,"List Of Sections available are - " +listOfSectionInMiddleLayer.size()+ " and List of Ads present in Middle Layer are - "+listOfAdsInMiddleLayer.size());
        }
        else{
            isCollectionDisplayed = false;
            isAdDisplayedAfterCollection = false;
            Utils.logStepInfo(false,"Ads after every collection in middle layer Failed");
        }
        return isCollectionDisplayed && isAdDisplayedAfterCollection;
    }

    @Override
    public boolean checkL3SubMenuAnd200SuccessCode() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isSuccessCode200 = true;
        commonFunctions.navigateToURL(globalVars.getURL()+"topic");
        //Utils.logStepInfo(true,"topicHeading.getText() = "+topicHeading.getText());
        boolean isTopicPageDisplayed = commonFunctions.isElementDisplayed(topicHeading,5,"Topic Heading");
        commonFunctions.navigateToURL(globalVars.getURL()+"topic/north-india");
        for(int i = 0; i<listOfL3SubMenu.size(); i++){
            commonFunctions.clickElement(listOfL3SubMenu.get(i),5,listOfL3SubMenu.get(i).getText());
            String url = commonFunctions.getCurrentURL();
            isSuccessCode200 &= commonFunctions.getResponseCode(url)==200;
        }
        return isSuccessCode200 && isTopicPageDisplayed;
    }

    @Override
    public boolean checkAllTopicSuccessCode200() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isSuccessCode200 = true;
        Map<String,Integer> topicStatusCodes = new HashMap<String,Integer>();
        commonFunctions.navigateToURL(globalVars.getURL()+"topic");
        commonFunctions.dummyWait(5);
        int totalTopic = listOfAllTopics.size();
        Utils.logStepInfo(true,"Total Topic are ---" +totalTopic);
        for (int i = 0; i<totalTopic; i++){

            Utils.logStepInfo(true,(i+1)+ " - Topic verification...");
            String topicName = listOfAllTopics.get(i).getText();

            commonFunctions.clickElementWithJS(listOfAllTopics.get(i),5,topicName);
            String url = commonFunctions.getCurrentURL();
            int statusCode = commonFunctions.getResponseCode(url);
            isSuccessCode200 &= statusCode == 200;
            if(statusCode != 200) {
                topicStatusCodes.put(topicName, statusCode);
            }
            commonFunctions.navigateBack(1);
            /*if(i>20){
                break;
            }*/
        }
        if(!topicStatusCodes.isEmpty()) {
            Iterator<Map.Entry<String, Integer>> itr = topicStatusCodes.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, Integer> entry = itr.next();
                Utils.logStepInfo(true, "Topic Name - " + entry.getKey() + " and Status Code - " + entry.getValue());
            }
        }
        else{
            Utils.logStepInfo(true, "All topics are working fine as there is no other than 200 status code.");
        }

        return isSuccessCode200;
    }
}
