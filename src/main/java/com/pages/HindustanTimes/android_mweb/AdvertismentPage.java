package com.pages.HindustanTimes.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AdvertismentPage extends CommonAdvertismentPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


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
    @FindBy(className = "contentSec2")
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(xpath = "(//div[@class='cartHolder bigCart']//h3[@class='hdg3'])[1]")
    private static WebElement openFullStory;

    @FindBy(xpath = "(//div[@class='storyShortDetail'])[2]")
    private static WebElement topics;

    @FindBy(xpath = "(//span[text()='RECOMMENDED'])[1]")
    private static WebElement recommended;

    @FindBy(xpath = "(//h3[@class='hdg3'])[1]")
    private static WebElement firstStory;

    @FindBy(xpath = "//a[text()='My Reads']")
    private static WebElement myRead;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;


    @FindBy(id = "allow")
    private static WebElement allowButton;

    @FindBy(xpath = "(//iframe[@title='3rd party ad content'])[2]")
    private static WebElement firstAdvertisement;

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads')])[3]")
    private static WebElement secondAdvertisement;

    @FindBy(xpath = "//div[@class='adMinHeight313'][1]//iframe")
    private static WebElement firstAdInLineStory;

    @FindBy(xpath = "//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "//a[text()='Most Read']")
    private static WebElement popularStory;

    @FindBy(xpath = "//strong[text()='Explore']")
    private static WebElement exploremenu;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(xpath = "//a[@data-id='cricket,9']/em")
    private static WebElement cricket;

    @FindBy(xpath = "//em[text()='Editorials']")
    private static WebElement editorials;

    @FindBy(xpath = "//em[text()='Cities']")
    private static WebElement cities;

    @FindBy(xpath = "//em[text()='Entertainment']")
    private static WebElement entertainment;

    @FindBy(xpath = "//a//em[text()='Photos']")
    private static WebElement photos;

    @FindBy(xpath = "(//img[@class='lazy'])[1]")
    private static WebElement firstphoto;

    @FindBy(xpath = "//div[@class='socialEl']")
    private static WebElement shareAndBookMarkVisibility;

    @FindBy(xpath = "(//a[contains(text(),'ALL PHOTOS')])[1]")
    private static WebElement viewAllPhotos;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement captionOfStory;

    @FindBy(xpath = "//h1[@class='hdg1']/a")
    private static WebElement headLineOfStory;

    @FindBy(xpath = "//div[@class='shortText']/ul/li")
    private static WebElement summaryLineOfPhoto;

    @FindBy(xpath = "(//h1)[2]")
    private static WebElement nextGallery;


    @FindBy(xpath = "//div[contains(@class,'embed')]")
    private static WebElement embeds;


    @FindBy(xpath = "//section[@class='mainContainer']/div")
    private static WebElement topAd;

    @FindBy(xpath = "(//section[contains(@class,'mainContainer')]/div)[1]")
    private static WebElement topAdAvailable;

    @FindBy(xpath = "//div[contains(@class,'mb10')]")
    private static WebElement rH1Ad;

    @FindBy(xpath = "//div[@class='bottonAd']")
    private static WebElement rH2Ad;

    @FindBy(xpath = "//*[@id='dataHolder']/section[1]/h2/span[2]")
    private static WebElement topNews;

    @FindBy(xpath = "//section[contains(@class,'worldSection')][1]")
    private static WebElement topNewsCollection;

    @FindBy(xpath = "//section[1]//section[1]//section[1]//div[@class='viewMoreButton']")
    private static WebElement endOfColl;

    @FindBy(xpath = "//body//div[3]") ////div[@class='adHeight313'][1]
    private static WebElement adDispAfterColl;

    @FindBy(xpath = "//div[@id='adslot1']")
    private static WebElement beforeFirstAd;

    @FindBy(xpath = "(//div[@class='storyShortDetail']//h2)[3]")
    private static WebElement beforeSponsoredAd;

    @FindBy(className = "sponsor-ad")
    private static WebElement sponsoredAd;

    @FindBy(xpath = "//div[@id='adslot3']")
    private static WebElement beforeAd;

    @FindBy(xpath = "//div[@id='adslot2']")
    private static WebElement beforeFirstNormalAd;

    @FindBy(xpath = "//div[@id='adslot1']//iframe")
    private static WebElement firstAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot2']//iframe")
    private static WebElement normalAd;

    @FindBy(xpath = "//div[@id='adslot2']")
    private static WebElement beforeSecondAd;

    @FindBy(xpath = "//div[@id='adslot2']//iframe")
    private static WebElement secondAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot3']")
    private static WebElement beforeThirdAd;

    @FindBy(xpath = "//div[@id='adslot3']//iframe")
    private static WebElement thirdAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot4']")
    private static WebElement beforeFourthAd;

    @FindBy(xpath = "//div[@id='adslot4']//iframe")
    private static WebElement fourthAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot5']")
    private static WebElement beforeFifthAd;

    @FindBy(xpath = "//div[@id='adslot5']//iframe")
    private static WebElement fifthAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot6']")
    private static WebElement beforeSixthAd;

    @FindBy(xpath = "//div[@id='adslot6']//iframe")
    private static WebElement sixthAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot7']")
    private static WebElement beforeSeventhAd;

    @FindBy(xpath = "//div[@id='adslot7']//iframe")
    private static WebElement seventhAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot8']")
    private static WebElement beforeEighthAd;

    @FindBy(xpath = "//div[@id='adslot8']//iframe")
    private static WebElement eighthAdAfter3Art;

    @FindBy(xpath = "//div[@id='adslot9']")
    private static WebElement beforeNinthAd;

    @FindBy(xpath = "//div[@id='adslot9']//iframe")
    private static WebElement ninthAdAfter3Art;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploreButton;

    @FindBy(xpath = "//a[contains(@class,'usa')]")
    private static WebElement toggleUSA;

    @FindBy(xpath = "//div[@class='nav-sec']")
    private static WebElement checkHamburgerMenuOptions;

    @FindBy(xpath = "//a[@href='/entertainment']/em")
    private static WebElement entertainmentOption;

    @FindBy(xpath = "//a[@href='/india-news']/em")
    private static WebElement indiaNewsHamburgerMenu;

    @FindBy(xpath = "//a[@class='india']")
    private static WebElement toggleIndia;

    @FindBy(xpath = "//div[contains(@class,'storyShortDetail')]/h1[@class='hdg1']")
    private static WebElement headLineCricket;

    @FindBy(xpath = "//section[@class='mainContainer']/div[3]/div[1]/div[1]/div[1]")
    private static WebElement summaryCricket;

    @FindBy(xpath = "//section[@class='mainContainer']/div[3]/div[1]/div[1]/div[4]/div[1]")
    private static WebElement leadMediaCricket;

    @FindBy(xpath = "//section[@class='mainContainer']//p[2]")
    private static WebElement paragraphCricket;

    @FindBy(xpath = "//div[@class='shareArticle']//div")
    private static WebElement shareIconCricket;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topicCricket;

    @FindBy(xpath = "//div[@class='scrollMenu']//a[@href='/videos']")
    private static WebElement clickOnVideosHamburgerMenu;

    @FindBy(xpath = "//div[@class='videoDetail']/h1")
    private static WebElement checkHeadLineOfStory;

    @FindBy(xpath = "//section[@class='ht-ad-holder'][2]//h3[@class='hdg3']")
    private static WebElement clickOnSecondArticleVideoSection;

    @FindBy(xpath = "//section[@class='ht-ad-holder'][1]//h3[@class='hdg3']//a")
    private static WebElement clickOnFirstArticleVideoSection;

    @FindBy(xpath = "//div[@class='info']//h2[@class='hideData']")
    private static WebElement checkHeadLineOfVideoStory;

    @FindBy(xpath = "///div[contains(@class,'jw-controlbar')]//div[@aria-label='Play']")
    private static WebElement checkPlayButton;

    @FindBy(xpath = "//div[contains(@class,'jw-controlbar')]//div[@aria-label='Pause']")
    private static WebElement checkPauseButton;

    @FindBy(xpath = "//div[contains(@class,'jw-button-container')]//div[contains(@aria-label,'Rewind')]")
    private static WebElement checkRewindButton;

    @FindBy(xpath = "//div[contains(@aria-label,'Unmute')]")
    private static WebElement checkUnmuteButton;

    @FindBy(xpath = "//div[contains(@aria-label,'Unmute')]//div[@aria-label='Volume']")
    private static WebElement checkVolumeButton;

    @FindBy(xpath = "//div[@class='info']//h2[@class='hideData']")
    private static WebElement checkSummaryVideo;

    @FindBy(xpath = "//div[@class='viewAllData']//a")
    private static WebElement checkReadMoreButton;

    @FindBy(xpath = "//span[@class='hdgStyle']")
    private static WebElement scrollDownToStopVideo;

    @FindBy(xpath = "//div[@class='videoDetail']//span[contains(@class,'share')]")
    private static WebElement checkShareIcon;

    @FindBy(xpath = "//div[@class='videoDetail']//span[@title='bookmark']")
    private static WebElement checkBookMark;

    @FindBy(xpath = "//div[@class='scrollMenu']")
    private static WebElement scrollToHamburgermenu;

    @FindBy(xpath = "//div[@class='scrollMenu']//a[@href='/podcasts']")
    private static WebElement scrollToPodCasts;

    @FindBy(xpath = "//div[@class='videoBox']//div[@class='embed_div']")
    private static WebElement firstVideobox;

    @FindBy(xpath = "//div[@class='nav-sec']//a//em")
    private static List<WebElement> hamburgerMenuOptions;

    @FindBy(xpath = "//li[not(@class='next')]//a[@href='/entertainment/page-2']")
    private static WebElement clickAtNumber2Page;

    @FindBy(xpath = "//div[@class='listPagination']")
    private static WebElement scrollDownToListPagination;

    @FindBy(xpath = "//div[@class='searchBar']")
    private static WebElement searchBarHamburgerMenu;

    @FindBy(xpath = "//div[@class='adMinHeight313']/following-sibling::p[count(.|//div[@class='adHeight313'][1]/preceding-sibling::p)=count(//div[@class='adHeight313'][1]/preceding-sibling::p)]")
    private static List<WebElement> paragraphs;

    @FindBy(xpath = "(//span[text()='View All'])[1]")
    private static WebElement viewAllText;

    @FindBy(xpath = "//button[@id='searchbtn']")
    private static WebElement searchButtonHamburgerMenu;

    @FindBy(xpath = "//div[@class='searchBar']//input")
    private static WebElement searchBarInput;

    @FindBy(xpath = "//div[contains(@id,'adslot')]")
    private static List<WebElement> getAllAdsAfter3Article;

    @FindBy(xpath = "//div[@class='storyShortDetail']//h2")
    private static List<WebElement> articles;

    @FindBy(xpath = "(//img[@class='lazy'])[2]")
    private static WebElement secondPhoto;

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads_iframe')])[3]")
    private static WebElement clickAdRedirection;

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads_iframe')])[3]")
    private static WebElement adFrame;

    public AdvertismentPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public void preSetInitializationForFaceBook() {
        commonFunctions.deleteFacebookCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preSetInitializationForGoogle() {
        commonFunctions.deleteGoogleCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean scrollDowntoFirstCollectionTopNews() {
        boolean isTopNewsDisplayed = false;
        try {
            commonFunctions.scrollToElementView(topNews, 20, "topNews");
            isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNews, 20, "topNews");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isTopNewsDisplayed;
    }

    public boolean scrollDowntoEndOfCollection() {
        boolean isScrollTOEndOfColl = false;
        try {
            commonFunctions.dummyWait(10);
            commonFunctions.scrollToElementView(beforeFirstAd, 20, "beforeFirstAd");
            commonFunctions.scrollToElementView(topAd, 20, "adDispAfterColl");
            isScrollTOEndOfColl = commonFunctions.scrollToElementView(topAd, 20, "endOfColl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollTOEndOfColl;
    }

    public boolean adDisplayingAfterEndofCollection() {
        boolean isAdDispAfterEndOfColl = false;
        try {

            isAdDispAfterEndOfColl = commonFunctions.isElementDisplayed(adDispAfterColl, 20, "adDispAfterColl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdDispAfterEndOfColl;
    }

    public boolean isRedirectedToAdPage() {
        boolean isRedirectionSuccessful;
        commonFunctions.scrollToElementView(viewAllText, 20, "ViewAll Button");
        commonFunctions.isElementDisplayed(viewAllText, 20, "View all Button");
        commonFunctions.scrollToElementView(clickAdRedirection, 10, "Ad redirection");
        commonFunctions.switchToFrame(adFrame, 10);
        isRedirectionSuccessful = commonFunctions.scrollToElementViewAndClick(clickAdRedirection, 10, "Ad redirection");
        commonFunctions.switchToDefaultContent();
        commonFunctions.waitForWindow(2, "new window");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if (!currentURL.isEmpty()) {
            isRedirectionSuccessful = true;
        }
        commonFunctions.closeAllWindowsExceptMasterTabGen();

        return isRedirectionSuccessful;
    }

    @Override
    public boolean checkAdDisplayingHomePage() {

        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isScrollToFirst = scrollDowntoFirstCollectionTopNews();
        boolean isScrollToEnd = scrollDowntoEndOfCollection();
        boolean isAdDisplayedEnd = adDisplayingAfterEndofCollection();
        boolean isReadFullStoryAd = checkfirstAdVisibilityReadFullStory();
        boolean isCountDisplayed = wordCountInBetweenAds();
        boolean isRedirectedSuccessful = isRedirectedToAdPage();

        return isScrollToFirst && isScrollToEnd && isAdDisplayedEnd && isReadFullStoryAd
                && isCountDisplayed && isRedirectedSuccessful;

    }

    public boolean checkfirstAdVisibilityReadFullStory() {
        boolean firstAdv = false;
        commonFunctions.scrollUsingAction(openFullStory, "Read FullStory");
        commonFunctions.clickElementWithActions(openFullStory, 70);
        commonFunctions.scrollUsingAction(firstAdvertisement, "First Advertise visible beneath the Lead Image");
        firstAdv = commonFunctions.isElementDisplayed(firstAdvertisement, 20);
        return firstAdv;

    }
/*@Override
    public boolean checkAdDisplayingAfterEveryCollection() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigateToIndiaNewspage = isNavigatedToIndiaNewsPage();
        boolean checkSponsoredAdAndNormalAd = checkAfter3ArtSponsoredAndNormalAd();
        boolean adAfterThreeArt = adAfterEveryThreeArt();
        boolean firstAd = scrollDownToFirstAdAfter3ArtClickVerify();
        return navigateToIndiaNewspage && checkSponsoredAdAndNormalAd && adAfterThreeArt && firstAd;
    }*/

    @Override
    public boolean checkAdDisplayingAfterEveryCollection() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigateToAdpage = isNavigatedToAdPage();
        boolean adAfterThreeArt = adAfterEveryThreeArt();
        boolean firstAd = scrollDownToFirstAdAfter3ArtClickVerify();
        return navigateToAdpage && adAfterThreeArt && firstAd;
    }

    public boolean isNavigatedToAdPage() {
        boolean isIndiaNewsClicked = false;
        try {
            commonFunctions.navigateToURL(globalVars.getURL() + "india-news");
            commonFunctions.waitForURLToBe(globalVars.getProdUrl() + "india-news");
            String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
            if (currentURL.equals(globalVars.getProdUrl() + "india-news")) {
                isIndiaNewsClicked = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIndiaNewsClicked;
    }

    @Override
    public boolean checkAdDisplayingAfterCollection() {
        boolean homePageLoad = scrollDowntoFirstCollectionTopNews();
        boolean HeaderFooterAds = scrollDowntoEndOfCollection();
        boolean firstAd = adDisplayingAfterEndofCollection();
        return homePageLoad && HeaderFooterAds && firstAd;
    }

    @Override
    public boolean checkAdsDisplayInLineStory() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean firstAd = checkfirstAdVisibility();
        boolean correctWordCount = wordCountInBetweenAds();
        boolean secondAd = checkSecondAdvisiblity();

        return firstAd && correctWordCount && secondAd;
    }

    @Override
    public boolean checkAdsInlineStories() {
        return false;
    }

    public boolean checkAfter3ArtSponsoredAndNormalAd() {
        boolean checkSponsoredAd = false;
        boolean checkNormalAd = false;
        try {
            int countArticles = articles.size();
            for (int i = 1; i < countArticles; i++) {
                if (i % 3 == 0) {
                    commonFunctions.scrollToElementView(beforeSponsoredAd, 20, "beforeSponsoreAd");
                    checkSponsoredAd = commonFunctions.isElementDisplayed(sponsoredAd, 20, "sponsoredAd");
                    commonFunctions.scrollToElementView(normalAd, 20, "normalAd");
                    checkNormalAd = commonFunctions.isElementDisplayed(normalAd, 20, "normalAd");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkSponsoredAd && checkNormalAd;
    }

    /*public boolean adAfterEveryThreeArt() {
        boolean isAdDispAfterEvery3Art = false;
        try {
            int countOfAdsAfter3Art = getAllAdsAfter3Article.size();
            for (int i = 0; i < countOfAdsAfter3Art-1; i++) {
                if(i>=2) {
                    int countArticles=articles.size();
                    for(int x =0; x< countArticles-1;x=x+3) {
                        if (x % 3 == 0) {
                            WebElement ad = getAllAdsAfter3Article.get(i);
                            commonFunctions.scrollToElementView(getAllAdsAfter3Article.get(i), 20, "getAllAdsAfter3Article");
                            if (ad.isEnabled() && ad.isDisplayed()) {
                                isAdDispAfterEvery3Art = true;
                                i++;
                                if(i== countOfAdsAfter3Art){
                                    break;
                                }
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdDispAfterEvery3Art;
    }*/
    public boolean adAfterEveryThreeArt() {
        boolean isAdDispAfterEvery3Art = false;
        try {
            int countOfAdsAfter3Art = getAllAdsAfter3Article.size();
            for (int i = 1; i <= countOfAdsAfter3Art; i++) {
                WebElement ad = getAllAdsAfter3Article.get(i);
                commonFunctions.scrollToElementView(getAllAdsAfter3Article.get(i), 20, "getAllAdsAfter3Article");
                if (ad.isEnabled() && ad.isDisplayed()) {
                    commonFunctions.elementToElementDisplayed(ad);
                    isAdDispAfterEvery3Art = true;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return isAdDispAfterEvery3Art;
    }

    public boolean scrollDownToFirstAdAfter3ArtClickVerify() {

        boolean isFirstAdRedirectionSuccessful = false;
        try {
            commonFunctions.dummyWait(10);
            commonFunctions.scrollToElementView(beforeFirstAd, 20, "beforeFirstAd");
            isFirstAdRedirectionSuccessful = commonFunctions.scrollToElementView(firstAdAfter3Art, 20, "thirdAdAfter3Art");
            isFirstAdRedirectionSuccessful = commonFunctions.isElementEnabled(firstAdAfter3Art, 20, "thirdAdAfter3Art");
            if (commonFunctions.isElementDisplayed(firstAdAfter3Art, 20, "thirdAdAfter3Art")) {
                isFirstAdRedirectionSuccessful = commonFunctions.clickElement(firstAdAfter3Art, 20, "thirdAdAfter3Art");
            }
            commonFunctions.waitForWindow(2, "new window");
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty()) {
                isFirstAdRedirectionSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isFirstAdRedirectionSuccessful;
    }

    public boolean isNavigatedToIndiaNewsPage() {
        boolean isIndiaNewsClicked = false;
        try {
            commonFunctions.navigateToURL(globalVars.getURL() + "india-news");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getURL() + "india-news")) {
                isIndiaNewsClicked = true;

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return isIndiaNewsClicked;
    }

    public boolean checkfirstAdVisibility() {
        boolean firstAdv = false;
        commonFunctions.scrollUsingAction(openFullStory, "Read FullStory");
        commonFunctions.clickElementWithActions(openFullStory, 70);
        commonFunctions.scrollUsingAction(firstAdvertisement, "First Advertise visible beneath the Lead Image");
        firstAdv = commonFunctions.isElementDisplayed(firstAdvertisement, 20);
        return firstAdv;
    }

    public boolean wordCountInBetweenAds() {
        boolean count = false;
        boolean isEmbedDisplayed = false;
        try {
            isEmbedDisplayed = commonFunctions.isElementDisplayed(embeds, 70, "Embed In Story");
        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, "Embed Not Available");
        }
        if (!isEmbedDisplayed == true) {

            String[] words = getWords();
            int wordLength = words.length;
            if (wordLength >= 120) {
                Utils.logStepInfo(true, "words in between ads are " + wordLength);
                count = true;
            }
        } else {
            String[] words = getWords();
            int wordLength = words.length + 80;
            Utils.logStepInfo(true, "words in between ads are " + wordLength);
            count = true;
        }
        return count;
    }

    public String[] getWords() {
        int numberOfParagraphs = paragraphs.size();
        String wordCount = "";
        for (int i = 0; numberOfParagraphs > i; i++) {
            String temp = commonFunctions.getElementText(paragraphs.get(i));
            wordCount = wordCount + temp;
        }
        String[] words = wordCount.split(" ");
        return words;
    }

    public boolean checkSecondAdvisiblity() {
        commonFunctions.scrollToElementView(secondAdvertisement, 20, "Second Advertise after 120 words");
        return commonFunctions.isElementDisplayed(secondAdvertisement, 20);
    }


    @Override
    public boolean checkAdsAreDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean checkAdDisplayingHomePageTopAd() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingAtEndOfFirstCollection() {
        /*commonFunctions.navigateToURL(globalVars.getURL());
        boolean firstAd = adDisplayingAfterEndofCollection();
        return   firstAd;*/
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean homePageLoad = scrollDowntoFirstCollectionTopNews();
        boolean HeaderFooterAds = scrollDowntoEndOfCollection();
        boolean firstAd = adDisplayingAfterEndofCollection();
        return homePageLoad && HeaderFooterAds && firstAd;
    }

    @Override
    public boolean checkAdDisplayWordCountAndAdRedirection() {
        return false;
    }

    @Override
    public boolean checkHeaderAdsAreDisplayed() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean topAdvHomePage = checkAdDisplayingTopAd();
        commonFunctions.navigateToURL(globalVars.getURL() + "entertainment");
        boolean topAdvSectionPage = checkAdDisplayingTopAd();
        commonFunctions.navigateToURL(globalVars.getURL() + "entertainment/bollywood");
        boolean topAdvSubSectionPage = checkAdDisplayingTopAd();

        return topAdvHomePage && topAdvSectionPage && topAdvSubSectionPage;
    }

    @Override
    public boolean checkHeaderAdisDisplayed() {
        return false;
    }

    @Override
    public boolean checkHomePageRHSAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkTopAdDisplayOnEverySection() {
        return false;
    }

    public boolean checkAdDisplayingTopAd() {
       return commonFunctions.isElementDisplayed(topAdAvailable, 20, "topAd");
    }
}
