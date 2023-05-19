package com.pages.HindustanTimes.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
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

    @FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
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

    @FindBy(xpath = "//div[contains(@class,'storyAd')]")
    private static WebElement firstAdvertisement;

    @FindBy(xpath = "(//div[contains(@class,'storyAd')])[2]")
    private static WebElement secondAdvertisement;

    @FindBy(xpath = "//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "(//div[@class='storyAd']//amp-ad)[2]")
    private static WebElement adFrame;

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

    @FindBy(xpath = "//div[contains(@class,'mb10')]")
    private static WebElement rH1Ad;

    @FindBy(xpath = "//div[@class='bottonAd']")
    private static WebElement rH2Ad;

    @FindBy(xpath = "(//div[@class='secHdg']//h2)[1]")
    private static WebElement topNews;

    @FindBy(xpath = "//section[contains(@class,'worldSection')][1]")
    private static WebElement topNewsCollection;

    @FindBy(xpath = "//div[@class='viewMoreButton'][1]")
    private static WebElement endOfColl;

    @FindBy(xpath = "(//div[@class='storyAd']/amp-ad)[2]")
    private static WebElement adDispAfterColl;

    @FindBy(xpath = "(//div[@class='storyAd']//amp-ad)[1]")
    private static WebElement beforeFirstAd;

    @FindBy(xpath = "(//div[@class='storyAd']//amp-ad)[1]")
    private static WebElement firstAdAfter3Art;


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

    @FindBy(xpath = "//div[@class='btnExplore']/strong")
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

    @FindBy(xpath = "//button[@id='searchbtn']")
    private static WebElement searchButtonHamburgerMenu;

    @FindBy(xpath = "//div[@class='searchBar']//input")
    private static WebElement searchBarInput;

    @FindBy(xpath = "//div[@class='storyAd']//amp-ad")
    private static List<WebElement> getAllAdsAfter3Article;

    @FindBy(xpath = "(//img[@class='lazy'])[2]")
    private static WebElement secondPhoto;

    @FindBy(xpath = "//div[@class='detail']/p")
    private static List<WebElement> paragraphs;

    @FindBy(xpath = "//div[@class='detail']/section")
    private static List<WebElement> AdAfterPara;

    @FindBy(xpath="(//button[@class='subscribe'])[1]")
    private static WebElement doThisLaterButton;

    public AdvertismentPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean scrollDowntoEndOfCollection()  {
        boolean isScrollTOEndOfColl = false;
        try {
            isScrollTOEndOfColl=commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollTOEndOfColl;
    }

    public boolean adDisplayingAfterEndofCollection()  {
        boolean isAdDispAfterEndOfColl = false;
        try {
            isAdDispAfterEndOfColl = commonFunctions.scrollToElementView(adDispAfterColl, 20, "adDispAfterColl");
            commonFunctions.navigateToURL(globalVars.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdDispAfterEndOfColl;
    }


    public boolean scrollDowntoFirstCollectionTopNews()  {
        boolean isTopNewsDisplayed = false;
        try {
            commonFunctions.scrollToElementView(topNews, 20, "topNews");
            isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNews, 20, "topNews");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isTopNewsDisplayed;
    }

    public void preSetInitializationForFaceBook(){
        commonFunctions.deleteFacebookCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preSetInitializationForGoogle(){
        commonFunctions.deleteGoogleCookies();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public boolean checkAdDisplayingHomePage() {

        boolean TopAdv=checkAdDisplayingTopAd();
        boolean FirstCollection=scrollDownToFirstCollectionTopNews();
        boolean EndOfCollection=scrollDownToEndOfCollection();
        boolean AdvAtTheEndOfCollection=adDisplayingAfterEndOfCollection();
        boolean FirstAd=checkFirstAdVisibility();
        boolean CorrectWordCount=wordCountInBetweenAds();
        boolean SecondAd=checkSecondAdvisiblity();
        boolean RedirectionToAdv=checkAdvRedirection();

        return TopAdv && FirstCollection && EndOfCollection && AdvAtTheEndOfCollection &&
                FirstAd && CorrectWordCount && SecondAd && RedirectionToAdv;
    }

    @Override
    public boolean checkAdsInlineStories() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingAfterEveryCollection() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigateToIndiaNewspage = isNavigatedToIndiaNewsPage();
        boolean adAfterThreeArt = adAfterEveryThreeArt();
        boolean firstAd = scrollDownToFirstAdAfter3ArtClickVerify();

        return navigateToIndiaNewspage && adAfterThreeArt && firstAd;
    }

    @Override
    public boolean checkAdDisplayingAfterCollection() {
        boolean homePageLoad=scrollDowntoFirstCollectionTopNews();
        boolean HeaderFooterAds=scrollDowntoEndOfCollection();
        boolean firstAd=adDisplayingAfterEndofCollection();
        return homePageLoad && HeaderFooterAds && firstAd ;
    }

    @Override
    public boolean checkAdsDisplayInLineStory() {
        boolean firstAd = checkFirstAdVisibility();
             boolean correctWordCount = wordCountInBetweenAds();
                boolean secondAd = checkSecondAdvisiblity();
                return firstAd && correctWordCount && secondAd;
    }


    public boolean adAfterEveryThreeArt() {
        boolean isAdDispAfterEvery3Art = false;
        try {
            int countOfAdsAfter3Art = getAllAdsAfter3Article.size();
            for (int i = 0; i < countOfAdsAfter3Art; i++) {
                WebElement ad = getAllAdsAfter3Article.get(i);
                commonFunctions.scrollToElementView(getAllAdsAfter3Article.get(i), 20, "getAllAdsAfter3Article");
                if (ad.isEnabled() && ad.isDisplayed()) {
                    isAdDispAfterEvery3Art = true;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return isAdDispAfterEvery3Art;
    }

    public boolean scrollDownToFirstAdAfter3ArtClickVerify() {
        boolean isfirstAdVisible=false;
        boolean isFirstAdRedirectionSuccessful = false;
        try {
            isfirstAdVisible = commonFunctions.scrollToElementView(firstAdAfter3Art, 20,"firstAdAfter3Art");
            if (commonFunctions.isElementDisplayed(firstAdAfter3Art, 20, "firstAdAfter3Art")) {
                commonFunctions.clickElement(firstAdAfter3Art, 20, "firstAdAfter3Art");
            }
            commonFunctions.waitForWindow(2, "new window");
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            //TODO: Please capture the value of href attribute before clicking on the ad and validate the same
            // with currentUrl after navigation.
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty()) {
                isFirstAdRedirectionSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isFirstAdRedirectionSuccessful && isfirstAdVisible;
    }

    public boolean isNavigatedToIndiaNewsPage() {
        boolean isIndiaNewsClicked = false;
        try {
            commonFunctions.navigateToURL(globalVars.getProdUrl() + "india-news/amp");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(globalVars.getProdUrl() + "india-news/amp")) {
                isIndiaNewsClicked = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIndiaNewsClicked;
    }

	@Override
	public boolean checkAdsAreDisplayed() { return false; }

    @Override
    public boolean checkAdDisplayingHomePageTopAd() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingAtEndOfFirstCollection() {
       commonFunctions.navigateToURL(globalVars.getAmpUrl());
        boolean firstAd = adDisplayingAfterEndofCollection();
        return   firstAd;
    }

    public boolean checkAdDisplayingTopAd() {
        boolean isTopAd;
        isTopAd = commonFunctions.isElementDisplayed(topAd, 20, "topAd");
        return isTopAd;
    }

    public boolean scrollDownToFirstCollectionTopNews() {
        boolean isTopNewsDisplayed;
        commonFunctions.scrollToElementView(topNews, 20, "topNews");
        isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNews, 20, "topNews");
        return isTopNewsDisplayed;
    }

    public boolean scrollDownToEndOfCollection() {
        boolean isScrollTOEndOfColl;
        //commonFunctions.scrollToElementView(beforeFirstAd, 20, "beforeFirstAd");
        commonFunctions.scrollToElementView(adDispAfterColl, 20, "adDispAfterColl");
        isScrollTOEndOfColl = commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
        return isScrollTOEndOfColl;
    }

    public boolean adDisplayingAfterEndOfCollection() {
        boolean isAdDispAfterEndOfColl;
        commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
        isAdDispAfterEndOfColl = commonFunctions.isElementDisplayed(adDispAfterColl, 65, "adDispAfterColl");
        return isAdDispAfterEndOfColl;
    }

    public boolean checkFirstAdVisibility() {
        boolean firstAdv;
        commonFunctions.scrollToElement(topNews,"topNews");
        commonFunctions.clickElementWithJS(openFullStory,20,"Clicked on ReadFull Story");
        commonFunctions.scrollDownOnce();
        firstAdv = commonFunctions.isElementDisplayed(firstAdvertisement, 20);
        return firstAdv;
    }

    public boolean wordCountInBetweenAds() {
        boolean count = false;
        boolean isEmbedDisplayed = false;
        try {
            isEmbedDisplayed = commonFunctions.isElementDisplayed(embeds, 10, "Embed In Story");
            Utils.logStepInfo(true, "Embed Available");
        } catch (Exception e) {

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

    public boolean checkSecondAdvisiblity() {
        boolean secondAd;
        commonFunctions.scrollToElementView(secondAdvertisement, 20,"Second Advertise after 120 words");
        int size=AdAfterPara.size();
        Utils.logStepInfo("Second Ad using updated locater "+size);
        return commonFunctions.isElementDisplayed(secondAdvertisement, 20);
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
    
    public boolean checkAdvRedirection(){
        boolean isRedirectionSuccessful;
        commonFunctions.scrollToElementView(firstAdvertisement, 10, "Ad redirection");
        isRedirectionSuccessful= commonFunctions.clickElementWithActions(firstAdvertisement,20);
        commonFunctions.waitForWindow(2,"new window");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if(!currentURL.isEmpty()) {
            isRedirectionSuccessful = true;
        }
        commonFunctions.closeAllWindowsExceptMasterTabGen();
        return isRedirectionSuccessful ;
    }

    @Override
    public boolean checkAdDisplayWordCountAndAdRedirection(){
        boolean TopAdv= checkAdDisplayingTopAd();
        boolean FirstCollection=scrollDownToFirstCollectionTopNews();
        boolean EndOfCollection=scrollDownToEndOfCollection();
        boolean AdvAtTheEndOfCollection=adDisplayingAfterEndOfCollection();
        boolean FirstAd=checkfirstAdVisibility();
        boolean CorrectWordCount=wordCountInBetweenAds();
        boolean secondAd=checkSecondAdvisibility();
        boolean RedirectionToAdv=checkAdvRedirection();

        return TopAdv && FirstCollection && EndOfCollection && AdvAtTheEndOfCollection &&
                FirstAd && secondAd &&CorrectWordCount && RedirectionToAdv;
    }
    public boolean checkfirstAdVisibility() {
        boolean firstAdv = false;
        commonFunctions.scrollToElementViewAndClick(openFullStory,10,"Read FullStory");
        commonFunctions.isElementDisplayed(topAd, 15, "First Ad");
        firstAdv =commonFunctions.scrollToElementView(firstAdvertisement,15,"Ad after 1st Para");
        return firstAdv;
    }
    public boolean checkSecondAdvisibility() {
        commonFunctions.scrollToElementView(secondAdvertisement, 20,"Second Advertise after 120 words");
        int size=paragraphs.size();
        Utils.logStepInfo("Second Ad using updated locater "+size);
        return commonFunctions.isElementDisplayed(secondAdvertisement, 20);
    }


    @Override
    public boolean checkHeaderAdsAreDisplayed() {
       commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Click on Do this later button on push notification");
        boolean topAdvHomePage=checkAdDisplayingTopAd();
        commonFunctions.navigateToURL("https://hindustantimes.com/entertainment/amp");
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Click on Do this later button on push notification");
        boolean topAdvSectionPage=checkAdDisplayingTopAd();
        commonFunctions.navigateToURL("https://hindustantimes.com/entertainment/bollywood/amp");
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Click on Do this later button on push notification");
        boolean topAdvSubSectionPage=checkAdDisplayingTopAd();

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
}
