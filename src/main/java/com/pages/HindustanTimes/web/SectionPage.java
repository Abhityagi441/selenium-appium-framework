
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsWebHt;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SectionPage extends CommonSectionPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebHt commonFunctionsWeb;

    @FindBy(xpath = "(//a[@class='sign-in'])[1]")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail")
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin")
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
    @FindBy(xpath = "//input[@type='submit']")
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
    @FindBy(className = "contentSec2") // div[@class='notification']
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;
    @FindBy(xpath = "//em[normalize-space()='India News']")
    private static WebElement indiaNewsSection;
    @FindBy(xpath = "//h1[normalize-space()='India News']")
    private static WebElement indiaNewsSectionHeader;

    @FindBy(xpath = "//div[contains(@class,'actionDiv')]/div[1]/a")
    private static List<WebElement> indiaNewsSectionName;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploreButton;
    @FindBy(xpath = "//a[@href='/india-news']//em")
    private static WebElement indiaNews;
    @FindBy(xpath = "//div[@class='listPagination']")
    private static WebElement listPagination;

    @FindBy(xpath = "//div[@class='nav-sec']//a//em")
    private static List<WebElement> hamburgerMenuOptions;

    @FindBy(xpath = "//div[@class='nav-sec']//li[3]//a")
    private static WebElement entertainmentOption;
    @FindBy(xpath = "//ul[contains(@class,'nav-expanded')]//li//a[@href]")
    private static List<WebElement> exploreHTList;

    @FindBy(xpath = "//li[contains(@class,'menuhead')]")
    private static WebElement exploreHT;

    @FindBy(xpath = "//div[@class='tpcTags']/a")
    private static List<WebElement> topics;

    @FindBy(xpath = "//div[@class='hdgStyle']//h1")
    private static WebElement landingPage;

    @FindBy(xpath = "//section[@id='dataHolder']/div[1]/div/h1")
    private static WebElement sectionPageHeader;
    @FindBy(xpath = "//div[contains(@class,'cartHolder bigCart')]")
    private static WebElement firstStory;
    @FindBy(xpath = "//a[contains(@data-id,'India')]")
    private static WebElement l1India;
    @FindBy(xpath = "(//section[@id='dataHolder']/div[contains(@class,'cartHolder') or contains(@class,'adHeight200')])[4]")
    private static WebElement fourthStory;
    @FindBy(xpath = "//a[text()='PARTNERED']")
    private static WebElement partneredStory;
    @FindBy(xpath = "//section[@id='dataHolder']/div[contains(@class,'cartHolder') or contains(@class,'adHeight313')]")
    private static List<WebElement> listOfAllStory;
    @FindBy(xpath = "//section[@id='dataHolder']/div[contains(@class,'cartHolder') or contains(@class,'adHeight200')]")
    private static List<WebElement> listOfStoryIncludingPartnered;
    @FindBy(xpath = "//a[contains(@data-id,'World')]")
    private static WebElement l1World;
    @FindBy(xpath = "//h1[text()='World News']")
    private static WebElement worldNewsPage;
    @FindBy(className = "div.listPagination")
    private static WebElement pagination;
    @FindBy(xpath = "//a[@data-page='2' and text()='2']")
    private static WebElement secondPagination;
    @FindBy(xpath = "//div[@class='row track']/h3")
    private static List<WebElement> listOfStoryLHS;
    @FindBy(xpath = "//div[contains(@class,'photoStory track')]/h3")
    private static List<WebElement> listOfStoryRHS;
    @FindBy(xpath = "//a[contains(@data-id,'Cricket')]")
    private static WebElement l1Cricket;
    @FindBy(xpath = "//div[contains(@class,'crickets prediction')]")
    private static List<WebElement> cricketPred;
    @FindBy(xpath = "(//div[@class='predic-head'])[5]")
    private static WebElement cricketSPredHead;
    @FindBy(xpath = "(//div[@class='cricket-score'])[5]")
    private static WebElement cricketScore;
    @FindBy(xpath = "(//div[@class='predic-head']/div[@class='live'])[1]")
    private static WebElement cricketScoreLive;
    @FindBy(xpath = "(//span[@class='vewFullScoreCard'])[5]")
    private static WebElement viewFullScorecard;


    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWeb = CommonFunctionsWebHt.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkIsSectionIndiaNewsScrollable() {
        return false;
    }

    @Override
    public boolean checkIsSectionIndiaNewsDisplayedClickable() {
        boolean isIndiaNewsSectionClickable = false, isPageRefreshAfterClickingOnLink = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(exploreButton, 10, "clicked on explore");
        commonFunctions.clickElementWithJS(indiaNews, 10, "clicked on india News");
        boolean isListOfIndiaNewsDisplayed = commonFunctions.isElementDisplayedOfListOfElements(indiaNewsSectionName, "India News Section name in every story");
        if(isListOfIndiaNewsDisplayed){
            commonFunctions.scrollToViewElement(indiaNewsSectionName.get(1),"India News Section",10);
            isIndiaNewsSectionClickable = commonFunctions.getAttributeValue(indiaNewsSectionName.get(0),5,"href").contains("/india-news");
            if(isIndiaNewsSectionClickable){
                commonFunctions.clickElementWithJS(indiaNewsSectionName.get(0),5, "India Section");
                isPageRefreshAfterClickingOnLink = commonFunctions.getElementText(sectionPageHeader,5).equalsIgnoreCase("INDIA NEWS");
                }
            }
        return isListOfIndiaNewsDisplayed && isIndiaNewsSectionClickable && isPageRefreshAfterClickingOnLink;
    }

    @Override
    public boolean checkFullStoryVisisbleAndClickableInQuickRead(String quickReadURL, String readSFullStoryText, String target1, String target2) {
        return false;
    }

    @Override
    public boolean checkTopicPage(String topicURL) {
        boolean isTop200TrendingTopicDisplayed = true;
        commonFunctions.navigateToURL(globalVars.getURL() + topicURL);
        int topicSize = topics.size();
        Utils.logStepInfo(true,"Topic size is = "+topicSize);
        if (topicSize == 200) {
            isTop200TrendingTopicDisplayed = true;
            Utils.logStepInfo(isTop200TrendingTopicDisplayed,"Top 200 trending topic displayed. This is expected");
        } else
            isTop200TrendingTopicDisplayed = false;
        Utils.logStepInfo(isTop200TrendingTopicDisplayed, "Top 200 trending topic not displayed");
        return isTop200TrendingTopicDisplayed;
    }

    @Override
    public boolean checkTopicLandingPage(String topicURL) {
        commonFunctions.navigateToURL(globalVars.getURL() + topicURL);
        boolean topicLandingPageStatus = commonFunctionsWeb.verifyTopicLandingPage(topics,landingPage,10);
        topicLandingPageStatus &= commonFunctionsWeb.verifyTopicLandingPage(topics,landingPage,12);
        topicLandingPageStatus &= commonFunctionsWeb.verifyTopicLandingPage(topics,landingPage,20);
        return topicLandingPageStatus;
    }

    @Override
    public boolean checkL1LandingPage() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbDisplayedFromGoogle(String url, String searchText) {
        return false;
    }

    @Override
    public boolean checkL2NewTag() {
        return false;
    }

    @Override
    public boolean checkAppLaunchDisplayTopSection() {
        return false;
    }

    @Override
    public boolean checkBottomNavHomeSelected() {
        return false;
    }

    @Override
    public boolean checkBottomNavDispalyFromAnotherSectionPage() {
        return false;
    }

    @Override
    public boolean checkSectionRedirectionPage() {
        return false;
    }

    @Override
    public boolean checkBusinessSection() {
        return false;
    }

    @Override
    public boolean checkSudokuSection() {
        return false;
    }

    @Override
    public boolean checkClickCityDisplayCitiesInExplore() {
        return false;
    }

    @Override
    public boolean checkClickExplorePageAppearAgain() {
        return false;
    }

    @Override
    public boolean checkCitiesSectionNameisDispayed() {
        return false;
    }

    @Override
    public boolean checkNoidaSubSectionNameisDispayed() {
        return false;
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionNamesDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionLiveBlogWithRedDotOnStory() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromExploreToPhotos() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromExploreToVideos() {
        return false;
    }

    @Override
    public boolean checkPremiumStoryInsideSectionPage() {
        return false;
    }

    @Override
    public boolean checkUserScrollToBottomOfTopNewsPage() {
        return false;
    }

    @Override
    public boolean checkForLiveBlogForTopNewsPage() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromWorld() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromCities() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromIndia() {
        return false;
    }

    @Override
    public boolean SubSectionNameInCitiesSection() {
        return false;
    }

    @Override
    public boolean WorldSectionInDarkMode() {
        return false;
    }

    @Override
    public boolean opinionSectionRedirection() {
        return false;
    }

    @Override
    public boolean checkScrollingOnOpinion() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromOpinion() {
        return false;
    }

    @Override
    public boolean checkAdAfterFiveStories() {
        return false;
    }

    @Override
    public boolean redirectToCricketSection() {
        return false;
    }

    @Override
    public boolean redirectToEntertainmentSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromEntertainment() {
        return false;
    }

    @Override
    public boolean subSectionInEntertainment() {
        return false;
    }

    @Override
    public boolean redirectToSubSectionInEntertainment() {
        return false;
    }

    @Override
    public boolean redirectToToTrendingSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromTrendingSection() {
        return false;
    }

    @Override
    public boolean redirectOnVideoSection() {
        return false;
    }

    @Override
    public boolean subSectionNamesInVideoPage() {
        return false;
    }

    @Override
    public boolean appearanceOfVideoSectionPage() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromVideoSectionPage() {
        return false;
    }

    @Override
    public boolean redirectToSubsectionOfVideoSection() {
        return false;
    }

    @Override
    public boolean redirectOnLifeStyleSection() {
        return false;
    }

    @Override
    public boolean redirectToSubSectionOfLifeStyle() {
        return false;
    }

    @Override
    public boolean storyInLifeStyleSection() {
        return false;
    }

    @Override
    public boolean redirectToEducationSection() {
        return false;
    }

    @Override
    public boolean subSectionOnEducationSection() {
        return false;
    }

    @Override
    public boolean redirectionOnSportSection() {
        return false;
    }

    @Override
    public boolean redirectToSubSectionFromSportSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromSportSection() {
        return false;
    }

    @Override
    public boolean redirectToPhotosSection() {
        return false;
    }

    @Override
    public boolean shareStoryFromSportsSection() {
        return false;
    }

    @Override
    public boolean appearanceOfPhotosSection() {
        return false;
    }

    @Override
    public boolean photoSectionInDarkMode() {
        return false;
    }

    @Override
    public boolean redirectToPhotoSectionStory() {
        return false;
    }

    @Override
    public boolean redirectToStoryFromPhotosSection() {
        return false;
    }

    @Override
    public boolean shareStoryFromPhotoSection() {
        return false;
    }

    @Override
    public boolean marketStatWidgetAfterFirstStory() {
        return false;
    }

    @Override
    public boolean redirectToBusinessSection() {
        return false;
    }

    @Override
    public boolean marketStatWidgetFourOptions() {
        return false;
    }

    @Override
    public boolean checkValuesInMarketStatWidget() {
        return false;
    }

    @Override
    public boolean redirectToMumbaiNewsSection() {
        return false;
    }

	@Override
	public boolean storyDisplayedAfterMarketStatWidget() {
		return false;
	}

    @Override
    public boolean checkRedirectToBusinessStory() {
        return false;
    }

    @Override
    public boolean checkRedirectToDelhiNewsSection() {
        return false;
    }

    @Override
    public boolean redirectToStoryOfMumbaiNewsSection() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromDelhiNewsSection() {
        return false;
    }

    @Override
    public boolean checkRedirectToTvNewsSection() {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromTTvNewsSection() {
        return false;
    }

    @Override
    public boolean checkCameraIconWithNumberOfPhotosInPhotosSection() {
        return false;
    }

    @Override
    public boolean countInleadStoryInPhotosSection() {
        return false;
    }

    @Override
    public boolean checkWebStoriesSectionFromTopSection() {
        return false;
    }

    @Override
    public boolean checkWebStoriesSectionFromExplore() {
        return false;
    }

    @Override
    public boolean checkImagesHorizontalLinesInWebStories() {
        return false;
    }

    @Override
    public boolean checkAppLogoInWebStories() {
        return false;
    }

    @Override
    public boolean checkThreeDotsDislpayedInWebStories() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnForYouSection() { return false; }

    @Override
    public boolean checkEditProfilePageInDarkMode() {
        return false;
    }

    @Override
    public boolean checkTextOnCityPopUp() { return false; }

    @Override
    public boolean checkRedirectionOnCitiesSection() { return false; }

    @Override
    public boolean checkRedirectionWhenTapOnGotItButton() { return false; }

    @Override
    public boolean  checkNoRedirectionWhenTapOnWhenAnyWhereExceptGotItButton() { return false; }

    @Override
    public boolean checkPlusSignDisplayBeforeCityName() { return false; }

    @Override
    public boolean checkHorizontalLinesAtEndOfCityName() { return false; }

    @Override
    public boolean checkMayBeLaterAndSaveChangesButton() { return false; }

    @Override
    public boolean checkOthersOptionInCities() { return false; }

    @Override
    public boolean checkBehaviourWhenUserTapsOnPlusButtonBeforeCityName() {
        return false;
    }

    @Override
    public boolean checkBehaviourWhenUserTapsOnMayBeLaterButton() { return false; }

    @Override
    public boolean checkBehaviourNoCitySelectedAndTapsOnSaveChangesButton() { return false; }

    @Override
    public boolean checkPopUpWhenSelectAnyCity() { return false; }

    @Override
    public boolean checkSelectedCityShownUnderCitiesSection() { return false; }

    @Override
    public boolean checkBehaviourWhenUserSelectAnyCityAndTapsOnMayBeLaterButton() { return false; }

    @Override
    public boolean checkDateInCitiesAfterSelectedCity() { return false; }

    @Override
    public boolean checkTemperatureDisplayedInCitiesSection() { return false; }

    @Override
    public boolean checkCityNameDisplayedAfterAdWithNews() { return false; }

    @Override
    public boolean checkRedirectionWhenTapOnOtherSelectedCities() { return false; }

    @Override
    public boolean checkRedirectionWhenTapOnMultipleCities() { return false; }

    @Override
    public boolean checkBehaviourWhenUserDeselectAnySelectedCity() { return false; }

    @Override
    public boolean checkFirstStoryInCardView() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(l1India, 20, "L1: India");
        commonFunctions.clickElement(l1India, 10, "L1: India");
        isShowing &= commonFunctions.isElementDisplayed(firstStory, 10, "first Story card view");
        return isShowing;
    }

    @Override
    public boolean checkFourthStoryPartneredStory() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(l1India, 20, "L1: India");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(l1India, 10, "L1: India");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollUsingAction(fourthStory, "fourth story: PARTNERED");
        isShowing &= commonFunctions.isElementDisplayed(fourthStory, 10, "fourth story");
        commonFunctions.dummyWait(10);
        commonFunctions.switchToFrame(3, 10);
        isShowing &= commonFunctions.isElementDisplayed(partneredStory, 5, "partnered story");
        return isShowing;
    }

    @Override
    public boolean checkAdsAfterEveryThreeStory() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(l1India, 20, "L1: India");
        commonFunctions.clickElement(l1India, 10, "L1: India");
        commonFunctions.scrollUsingAction(listOfAllStory.get(3), "fourth position");
        isShowing &= commonFunctions.isElementDisplayed(listOfAllStory.get(3), 5, "fourth position: ads");
        isShowing &= commonFunctions.checkElementText(listOfAllStory.get(3), "", 2, "Ads After Every Three Story");
        commonFunctions.scrollUsingAction(listOfAllStory.get(7), "eight position");
        isShowing &= commonFunctions.isElementDisplayed(listOfAllStory.get(7), 5, "eight position: ads");
        isShowing &= commonFunctions.checkElementText(listOfAllStory.get(7), "", 2, "Ads After Every Three Story");
        commonFunctions.scrollUsingAction(listOfAllStory.get(11), "twelve position");
        isShowing &= commonFunctions.isElementDisplayed(listOfAllStory.get(11), 5, "twelve position: ads");
        isShowing &= commonFunctions.checkElementText(listOfAllStory.get(11), "", 2, "Ads After Every Three Story");
        return isShowing;
    }

    @Override
    public boolean checkThirtyStoryOnSectionPage(String worldNewsUrl) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(l1World, 20, "L1: World");
        commonFunctions.clickElement(l1World, 10, "L1: World");
        isShowing &= commonFunctions.isElementDisplayed(worldNewsPage, 10, "world news page");
        if (isShowing &= listOfStoryIncludingPartnered.size() == 30 && commonFunctions.getCurrentURL().equals(worldNewsUrl)) {
            isShowing &= true;
            Utils.logStepInfo(true, "all story count is 30 verified successfully !!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "all story count is " + listOfStoryIncludingPartnered.size() + "expected size 30 are Not same verification failed *******");
        }
        return isShowing;
    }

    @Override
    public boolean checkPagination(String secondPageUrl,String worldNewsUrl) {
        boolean isShowing = checkThirtyStoryOnSectionPage(worldNewsUrl);
        commonFunctions.scrollUsingAction(pagination, "pagination");
        commonFunctions.clickElement(secondPagination, 10, "page no: 2");
       isShowing &= commonFunctions.checkCurrentPageUrlEqualToExpectedUrl(secondPageUrl,"second page");
        return isShowing;
    }

    @Override
    public boolean checkLHSAndRHSData(String indiaNewsUrl) {
        boolean isShowing = checkFirstStoryInCardView();
        isShowing &= commonFunctions.checkCurrentPageUrlEqualToExpectedUrl(indiaNewsUrl, "India news page");
        commonFunctions.dummyWait(5);
        if (isShowing &= listOfStoryLHS.size() >= 1 && listOfStoryRHS.size() >= 1) {
            isShowing &= true;
            Utils.logStepInfo(true, "collection story is  displayed successfully");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "collection story Not displayed verification Failed");
        }
        return isShowing;
    }

    @Override
    public boolean checkMatchCard(String cricketUrl) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(l1Cricket, 20, "L1: Cricket");
        commonFunctions.clickElement(l1Cricket, 10, "L1: Cricket");
        isShowing &= commonFunctions.checkCurrentPageUrlEqualToExpectedUrl(cricketUrl, "cricket page");
        commonFunctions.scrollUsingAction(cricketPred.get(0),"match card");
        isShowing &= commonFunctions.isElementDisplayed(cricketPred.get(0), 10, "match card");
        isShowing &= commonFunctions.isElementDisplayed(cricketSPredHead, 10, "cricket Pred Head");
        isShowing &= commonFunctions.isElementDisplayedIgnoringStaleElement(cricketScore, 10, "cricket score");
        return isShowing;
    }

    @Override
    public boolean checkViewFullScorecard(String cricketUrl,String liveScorecard) {
        boolean isShowing = checkMatchCard(cricketUrl);
        if ( commonFunctions.isElementDisplayedAndPresent(cricketScoreLive, 10, "cricket score: Live")){
            commonFunctions.clickElement(viewFullScorecard, 10, "viewFull Scorecard");
            isShowing = commonFunctions.checkPageURLSC(liveScorecard, 5, "scorecard page");
        }
        return isShowing;
    }

}

