
package com.pages.HindustanTimes.web;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.utils.GlobalVars;
import com.utils.Utils;

public class AdvertismentPage extends CommonAdvertismentPage {

	private static WebDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsWeb commonFunctions;

	@FindBy(xpath = "//div[@id='adslot1']")
	private static WebElement sponsoredAd;
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

	@FindBy(xpath = "(//div[@data-vars-orderid='1']//div[@class='readFull']//a)[1]")
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

	@FindBy(xpath = "(//iframe[@title='3rd party ad content'])[2]")//(//iframe[contains(@id,'google_ads')])[2]
	private static WebElement firstAdvertisement;

	@FindBy(xpath = "(//iframe[contains(@id,'google_ads')])[3]")
	private static WebElement secondAdvertisement;

	@FindBy(xpath = "//div[@class='adMinHeight313']/following-sibling::p[count(.|//div[@class='adHeight313'][1]/preceding-sibling::p)=count(//div[@class='adHeight313'][1]/preceding-sibling::p)]")
	private static List<WebElement> paragraphs;

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

	@FindBy(xpath = "//a[text()='Editorials']")
	private static WebElement editorials;

	@FindBy(xpath = "//div/a/em[text()='Cities']")
	private static WebElement cities;

	@FindBy(xpath = "//em[text()='Entertainment']")
	private static WebElement entertainment;

	@FindBy(xpath = "//a[contains(text(),'Entertainment')]")
	private static WebElement entertainmentSection;

	@FindBy(xpath = "//a[contains(text(),'Bollywood')]")
	private static WebElement bollywoodSubSection;

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

	@FindBy(xpath = "//div[contains(@class,'detail')]")
	private static WebElement embeds;

	@FindBy(xpath = "(//div[contains(@id,'google_ads_iframe_')])[2]")
	private static WebElement topAd;

	@FindBy(id = "div-gpt-firstslot-ad")
	private static WebElement pageTopAd;

	@FindBy(id="adslot2")
	private static WebElement pageTopAd2;

	@FindBy(xpath = "(//*[contains(@class,'rgtAdSection')]//div[contains(@id,'google_ads_iframe')])[1]")
	private static WebElement rH1Ad;

	@FindBy(xpath = "//a[@href='/photos']//h2")
	private static WebElement rhsFirstCollection;
	@FindBy(xpath = "//a[@href='/videos']//h2")
	private static WebElement rhsSecondCollection;
	@FindBy(xpath = "//a[@href='/trending']//h2")
	private static WebElement rhsThirdCollection;
	@FindBy(xpath = "//div[@id='adslot1']")
	private static WebElement rhs2Ad;
	@FindBy(xpath = "//div[@id='adslot2']")
	private static WebElement rhs3Ad;
	@FindBy(xpath = "//div[@id='adslot3']")
	private static WebElement rhs4Ad;

	@FindBy(xpath = "//div[@class='bottonAd']")
	private static WebElement rH2Ad;

	@FindBy(xpath = "(//iframe[@title='3rd party ad content'])[3]")
	private static WebElement redirectionOnAd;

	@FindBy(xpath = "(//span[@class='hdgStyle'])[2]")
	private static WebElement topNews;

	@FindBy(xpath = "//section[contains(@class,'worldSection')][1]")
	private static WebElement topNewsCollection;

	@FindBy(xpath = "(//div[@id='dontmiss']//preceding-sibling::div[1])[1]")
	private static WebElement endOfColl;

	@FindBy(xpath = "//body//div[3]")////body//div[3]//google_image_div
	private static WebElement adDispAfterColl;

	@FindBy(xpath = "//div[@id='adslot']")
	private static WebElement beforeFirstAd;

	@FindBy(xpath = "//div[@id='adslot1']//iframe")
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

	@FindBy(xpath = "//div[contains(@id,'adslot')]")
	private static List<WebElement> getAllAdsAfter3Article;

	@FindBy(xpath = "(//img[@class='lazy'])[2]")
	private static WebElement secondPhoto;

	@FindBy(xpath = "//div[@class='GoogleActiveViewInnerContainer']")
	private static List<WebElement> adEndOfCollection;

	@FindBy(xpath = "//div[@id='google_center_div']")
	private static List<WebElement> advAfter3Articles;

    @FindBy(xpath = "//body//div")
    private static WebElement topmostAd;


	public AdvertismentPage() {
		globalVars = GlobalVars.getInstance();
		driver = globalVars.getWebDriver();
		PageFactory.initElements(driver, this);
		commonFunctions = CommonFunctionsWeb.getInstance();
		commonFunctions.clickElementIfDisplayed(acceptCookie, 15, "accept cookie button");
		System.out.println("****************** Test started ******************");
		System.out.println("******************" + globalVars.getProjectName() + "******************");
	}

	public boolean checkAdDisplayingTopAd() {
		boolean isTopAd;
		isTopAd = commonFunctions.isElementDisplayed(topmostAd, 20, "topAd");
		return isTopAd;
	}

	public boolean checkAdDisplayingRH1Ad() {
		boolean isRH1Ad;
		isRH1Ad = commonFunctions.isElementDisplayed(rH1Ad, 20, "rH1Ad");
		return isRH1Ad;
	}

	public boolean checkAdDisplayingRH2Ad() {
		boolean isRH2Ad;
		isRH2Ad = commonFunctions.isElementDisplayed(rH2Ad, 20, "rH2Ad");
		return isRH2Ad;
	}

	/*public boolean scrollDownToFirstCollectionTopNews() {
		boolean isTopNewsDisplayed;
		commonFunctions.scrollToElementView(topNews, 20, "topNews");
		isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNews, 20, "topNews");
		return isTopNewsDisplayed;
	}*/

	/*public boolean scrollDownToEndOfCollection() {
		boolean isScrollTOEndOfColl;
		commonFunctions.scrollToElementView(beforeFirstAd, 20, "beforeFirstAd");
		commonFunctions.scrollToElementView(adDispAfterColl, 20, "adDispAfterColl");
		isScrollTOEndOfColl = commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
		return isScrollTOEndOfColl;
	}
*/
	/*public boolean adDisplayingAfterEndOfCollection() {
		boolean isAdDispAfterEndOfColl;
		commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
		isAdDispAfterEndOfColl = commonFunctions.isElementDisplayed(adDispAfterColl, 35, "adDispAfterColl");
		return isAdDispAfterEndOfColl;
	}*/

	public boolean adAfterEveryThreeArt() {
		boolean isAdDispAfterEvery3Art = false;
		try {
			int countOfAdsAfter3Art = getAllAdsAfter3Article.size();
			for (int i = 0; i < 5; i++) {
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
			commonFunctions.scrollToElementView(beforeFirstAd, 40, "beforeFirstAd");
			isFirstAdRedirectionSuccessful = commonFunctions.scrollToElementView(firstAdAfter3Art, 20,
					"firstAdAfter3Art");
			isFirstAdRedirectionSuccessful = commonFunctions.isElementEnabled(firstAdAfter3Art, 20, "firstAdAfter3Art");
			if (commonFunctions.isElementDisplayed(firstAdAfter3Art, 20, "firstAdAfter3Art")) {
				isFirstAdRedirectionSuccessful = commonFunctions.clickElement(firstAdAfter3Art, 20, "firstAdAfter3Art");
			}commonFunctions.waitForWindow(2, "new window");
			ArrayList<String> windowsList = new ArrayList<>(
					commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty()) {
				isFirstAdRedirectionSuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return isFirstAdRedirectionSuccessful;
	}

	/*public boolean isRedirectedToAdPage() {
		boolean isRedirectionSuccessful = false;
		//TODO: Before clicking on rh2Ad, please capture href attribute value and validate it is same as the navigated URL.
		driver.switchTo().frame(redirectionOnAd);
		commonFunctions.scrollToElementView(redirectionOnAd, 10, "Ad redirection");
		String adURL = redirectionOnAd.getAttribute("src");
		commonFunctions.clickElement(redirectionOnAd,10,"Ad redirection");
		String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
		if (adURL.contains(currentURL)) {
			isRedirectionSuccessful = true;
		}
		return isRedirectionSuccessful;
	}*/

	@Override
	public boolean checkAdsInlineStories() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean a = checkfirstAdVisibility();
		boolean b = wordCountInBetweenAds();
		boolean c = checkSecondAdvisiblity();

		return a && b && c;
	}

	@Override
	public boolean checkAdDisplayingHomePage() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean checkTopAd = checkAdDisplayingTopAd();
		boolean checkRh1Ad = checkAdDisplayingRH1Ad();
		return checkTopAd && checkRh1Ad;
	}

	@Override
	public boolean checkAdDisplayingAfterEveryCollection() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean navigateToAdpage = isNavigatedToAdPage();
		boolean adAfterThreeArt = adAfterEveryThreeArt();
		return navigateToAdpage && adAfterThreeArt;
	}

	@Override
	public boolean checkAdDisplayingAfterCollection() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean homePageLoad = scrollDowntoFirstCollectionTopNews();
		boolean HeaderFooterAds = scrollDowntoEndOfCollection();
		boolean firstAd = adDisplayingAfterEndofCollection();
		return homePageLoad && HeaderFooterAds && firstAd;
	}

	@Override
	public boolean checkAdsAreDisplayed() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean isRh1Ad = checkAdDisplayingRH1Ad();
		return  isRh1Ad;

	}

	@Override
	public boolean checkAdsDisplayInLineStory() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean firstAd = checkfirstAdVisibility();
		boolean correctWordCount = wordCountInBetweenAds();
		boolean secondAd = checkSecondAdvisiblity();
		return firstAd && correctWordCount && secondAd;
	}

	public boolean scrollDowntoFirstCollectionTopNews() {
			commonFunctions.scrollToElementView(topNews, 20, "Scrolled to TopNews");
			return commonFunctions.isElementDisplayed(topNews, 20, "TopNews Displayed");
	}

	public boolean 	scrollDowntoEndOfCollection() {
		boolean isScrollTOEndOfColl = false;
		try {
			commonFunctions.scrollToElementView(topAd, 20, "adDispAfterColl");
			isScrollTOEndOfColl = commonFunctions.scrollToElementView(topAd, 20, "endOfColl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isScrollTOEndOfColl;
	}

	public boolean adDisplayingAfterEndofCollection() {
			return commonFunctions.isElementDisplayed(adDispAfterColl, 20, "Advertisement is Displayed at end of Collection");
	}

	public boolean isNavigatedToAdPage() {
		boolean isIndiaNewsClicked = false;
		try {
			commonFunctions.navigateToURL(globalVars.getURL() + "india-news");
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (currentURL.equals(Utils.getUrl() + "india-news")) {
				isIndiaNewsClicked = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isIndiaNewsClicked;
	}


	public boolean checkAdDisplayingHomePageTopAd() {
		return	commonFunctions.isElementDisplayed(topAd, 20, "topAd");
	}

	@Override
	public boolean checkAdDisplayingAtEndOfFirstCollection() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean homePageLoad = scrollDowntoFirstCollectionTopNews();
		boolean adAfterCollection = scrollDowntoEndOfCollection();

		return homePageLoad && adAfterCollection;
	}

	@Override
	public boolean checkAdDisplayWordCountAndAdRedirection() {
		return false;
	}

	@Override
	public boolean checkHeaderAdsAreDisplayed() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.dummyWait(5);
		commonFunctions.scrollToElementView(pageTopAd, 20, "Homepage Top Ad");
		boolean checkHomeAd=commonFunctions.isElementDisplayed(pageTopAd, 20, "HomePage Top Most Ad");
		commonFunctions.clickElementWithJS(entertainmentSection, 20,"Entertainment Section");
		commonFunctions.waitForURLContains("entertainment");
		commonFunctions.scrollToElementView(pageTopAd2, 20, "entertainment Top Ad");
		boolean checkEntertainmentTopAd = commonFunctions.isElementDisplayed(pageTopAd2, 20, "Entertainment Page Top Most Ad");
		commonFunctions.clickElementWithJS(entertainmentSection, 5,"Entertainment Section");
		commonFunctions.clickElement(bollywoodSubSection, 10, "Bollywood Subsection");
		commonFunctions.waitForURLContains("bollywood");
		commonFunctions.scrollToElementView(pageTopAd2, 20, "entertainment Top Ad");
		boolean checkBollywoodTopAd =commonFunctions.isElementDisplayed(pageTopAd2, 10, "SubSection Bollywood Page Top Most Ad");
		return checkHomeAd && checkEntertainmentTopAd || checkBollywoodTopAd;
	}

	@Override
	public boolean checkHeaderAdisDisplayed() {
		return false;
	}


	public boolean checkfirstAdVisibility() {
		boolean firstAdv;
		//commonFunctions.scrollToElementView(openFullStory,20, "Read FullStory");
		commonFunctions.clickElementWithJS(openFullStory,20,"open Fullstory");
		commonFunctions.scrollUsingWait(firstAdvertisement, "First Advertise visible beneath the Lead Image",20);
		firstAdv = commonFunctions.isElementDisplayed(firstAdvertisement, 20, "firstAdvertisement");
		return firstAdv;
	}

	public boolean wordCountInBetweenAds() {
		boolean count = false;
		boolean isEmbedDisplayed = false;
		try {
			isEmbedDisplayed = commonFunctions.isElementDisplayed(embeds, 20, "Embed In Story");
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
		commonFunctions.scrollToElementView(secondAdvertisement, 20,"Second Advertise after 120 words");
		return commonFunctions.isElementDisplayed(secondAdvertisement, 20);
	}

	@Override
	public boolean checkHomePageRHSAdsAreDisplayed() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean checkRHS1Ad=commonFunctions.isElementDisplayed(rH1Ad, 20, "HomePage RHS First Ad");
		commonFunctions.isElementDisplayed(rhsFirstCollection, 10,"HomePage RHS First Collection");
		commonFunctions.scrollToElementView(rhs2Ad, 10,"RSH Second Ad after first collection");
		boolean checkRHS2Ad=commonFunctions.isElementDisplayed(rhs2Ad, 10,"RSH Second Ad after first collection");
		commonFunctions.isElementDisplayed(rhsSecondCollection, 10, "HomePage RHS Second Collection");
		commonFunctions.scrollToElementView(rhs3Ad, 10,"RSH Third Ad after Second collection");
		boolean checkRHS3Ad=commonFunctions.isElementDisplayed(rhs3Ad, 10,"RSH Third Ad after Second collection");
		commonFunctions.isElementDisplayed(rhsThirdCollection, 10, "HomePage RHS Third Collection");
		commonFunctions.scrollToElementView(rhs4Ad, 10, "RSH Fourth Ad after Third collection");
		boolean checkRHS4Ad=commonFunctions.isElementDisplayed(rhs4Ad, 10, "RSH Fourth Ad after Third collection");

		return checkRHS1Ad && checkRHS2Ad && checkRHS3Ad && checkRHS4Ad;
	}

	@Override
	public boolean checkTopAdDisplayOnEverySection() {
		return false;
	}
}
