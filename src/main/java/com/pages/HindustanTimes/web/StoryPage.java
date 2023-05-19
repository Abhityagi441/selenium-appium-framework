
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.HTMLParser;
import com.utils.Utils;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



public class StoryPage extends CommonStoryPage {
	private static WebDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsWeb commonFunctions;
	private static ApiValidation apiValidation;
	String storyID;
	Response response = null;
	HTMLParser parser = new HTMLParser();


	@FindBy(xpath = "(//a[@class='sign-in'])[1]")
	private static WebElement singInButton;
	@FindBy(id = "customBtn")
	private static WebElement continueWithGoogleButton;
	@FindBy(xpath = "//a[text()='Sign in with Apple']")
	private static WebElement continueWithAppleID;
	@FindBy(id = "fbmBtn")
	private static WebElement continueWithFacebookButton;
	@FindBy(id = "phoneEmail") // uemail
	private static WebElement emailTextBoxMainSignInPage;
	@FindBy(id = "btSubmit")
	private static WebElement continueButtonSignInPage;
	@FindBy(id = "upass")
	private static WebElement passwordTextBoxMainSignInPage;
	@FindBy(id = "btnLogin") // login
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
	@FindBy(xpath = "//input[@type='submit']") // input[@value='Log In']
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

	@FindBy(xpath = "//h1/a/img")
	private static WebElement htLogo;

	@FindBy(xpath = "//a[@data-id='Quickreads,2']")
	private static WebElement quickReads;

	@FindBy(xpath = "//div[@id='india-news-slider']")
	private static WebElement indiaNewsCarousel;
	@FindBy(xpath = "//a[@data-id='Entertainment,3']")
	private static WebElement entertainmentCarousel;

	@FindBy(xpath = "//ul[@data-section='India News']//img['1']")
	private static WebElement indiaNewsStory;
	@FindBy(xpath = "//a[contains(text(),'Read Full Story')]")
	private static List<WebElement> listOfFullReadStoryOption;
	@FindBy(xpath = "//ul[@data-section='Entertainment']//img['1']")
	private static WebElement entertainmentStory;
	@FindBy(xpath = "//section[@class='mainContainer']")
	private static WebElement entertainmentFullReadStory;

	@FindBy(xpath = "//a[normalize-space()='World']")
	private static WebElement worldSection;
	@FindBy(xpath = "//div[contains(@class,'bigCart')]/h3/a")
	private static WebElement storyHeadline;
	@FindBy(xpath = "//section[@id='dataHolder']/section[1]/div[1]/div[1]/h3")
	private static WebElement openStoryHeadline;

	@FindBy(xpath = "//div[@class='nav-sec']//li[14]//a")
	private static WebElement photos;

	@FindBy(xpath = "//div[@class='skip']")
	private static WebElement skipPopup;

	@FindBy(xpath = "(//img[@class='lazy'])[1]")
	private static WebElement firstphoto;

	@FindBy(xpath = "//div[@class='stroyPub']")
	private static WebElement authorName;

	@FindBy(xpath = "//span[contains(@class,'share-candidate')]")
	private static List<WebElement> shareIconBookMark;

	@FindBy(xpath = "(//span[contains(@class,'share-candidate')])[2]")
	private static WebElement secondShareIcon;

	@FindBy(xpath = "(//span[@class='bookmark bookmark-candidate'])[1]")
	private static WebElement bookMarkPhoto;

	@FindBy(xpath = "(//span[@class='share share-candidate'])[1]")
	private static WebElement shareIconPhoto;

	@FindBy(xpath = "(//em[starts-with(text(),'Photos')]//parent::a)")
	private static WebElement viewAllPhotos;

	@FindBy(xpath = "(//h4[@class='hdg4'])[1]")
	private static WebElement captionOfStory;

	@FindBy(xpath = "//h1[@class='hdg1']/a")
	private static WebElement headLineOfStory;

	@FindBy(xpath = "//div[1]//div[1]//div[1]//h3[1]//a[1]")
	private static WebElement firstHeadline;

	@FindBy(xpath = "//div[contains(@class,'bigCart')]/h3/a")
	private static WebElement firstStoryHeadline;

	@FindBy(xpath = "//section[1]/aside[1]/div[1]/div/div[1]/h3/a")
	private static WebElement latestFirstHeadline;

	@FindBy(xpath = "//div[contains(@class,'new__newsletter__signup')]")
	private static WebElement capsuleBanner;

	@FindBy(xpath = "//input[@type='text']")
	private static WebElement enterEmail;

	@FindBy(xpath = "//button[@class='story-subscribe-newsletter']")
	private static WebElement buttonSubscribe;

	@FindBy(xpath = "//div[contains(@class,'toast-following')][contains(text(),'Subscribed to newsletter')]")
	private static WebElement subscribedMsg;

	@FindBy(xpath = "//div[@class='shortText']")
	private static WebElement summaryLineOfPhoto;

	@FindBy(xpath = "//p[@class='shortText']")
	private static WebElement summaryLineOfPhotoP;

	@FindBy(xpath = "//div[@class='flexElement']")
	private static List<WebElement> imageCredits;

	@FindBy(xpath = "(//div[@class='photoGallerySec']/h1)[2]")
	private static WebElement nextGallery;

	@FindBy(xpath = "(//img[@class='lazy'])[2]")
	private static WebElement secondPhoto;

	@FindBy(xpath = "//div[@class='btnExplore']")
	private static WebElement exploremenu;

	@FindBy(xpath = "//div[contains(@class,'fullStory cartHolder')]//h1[@class='hdg1']")
	private static WebElement headLineCricket;

	@FindBy(xpath = "//div[contains(@class,'fullStory cartHolder')]//div[@class='sortDec']")
	private static WebElement summaryCricket;

	@FindBy(xpath = "(//div[@class='sortDec']/following-sibling::figure//img)[1]")
	private static WebElement leadMediaCaption;

	@FindBy(xpath = "(//section[@class='mainContainer']//p[2])[1]")
	private static WebElement paragraphCricket;

	@FindBy(xpath = "(//div[@class='shareArticle']//div)[1]")
	private static WebElement shareIconCricket;

	@FindBy(xpath = "//div[contains(@class,'storyTopics')]")
	private static WebElement topicCricket;

	@FindBy(xpath = "(//div[@class='scrollMenu']//a[contains(@data-id,'videos')]//em)[1]")
	private static WebElement clickOnVideosHamburgerMenu;

	@FindBy(xpath = "//div[@class='videoDetail']/h1")
	private static WebElement checkHeadLineOfStory;

	@FindBy(xpath = "//section[@class='ht-ad-holder'][2]//h3[@class='hdg3']")
	private static WebElement clickOnSecondArticleVideoSection;

	@FindBy(xpath = "//section[@class='ht-ad-holder'][1]//h3[@class='hdg3']//a")
	private static WebElement clickOnFirstArticleVideoSection;

	@FindBy(xpath = "//div[@data-vars-orderid='1']//figure//a")
	private static WebElement firstArticleVideoSection;

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

	@FindBy(xpath = "//div[@class='info info_detail']//h2[@class='hideData']")
	private static WebElement checkSummaryVideo;

	@FindBy(xpath = "(//button[@class='viewAllData'])[1]")
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

	@FindBy(xpath = "//div[@class='btnExplore']")
	private static WebElement exploreButton;

	@FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
	private static WebElement openFullStory;

	@FindBy(xpath = "//div[contains(@class,'fullStory')]")
	private static WebElement openStory;

	@FindBy(xpath = "//div[@class='htsHeader']/div")
	private static WebElement trendingCarousel;

//	@FindBy(xpath="//h2[@class='hdg3']")
//	private static WebElement openFullStory;

	@FindBy(xpath = "//div[contains(@class,'fullStory')]/h3")
	private static WebElement title;

	@FindBy(xpath = "//div[@class='secHdg']//h1")
	private static WebElement section;

	@FindBy(xpath = "//div[@class='sortDec']")
	private static WebElement summaryOfFirstStory;

	@FindBy(xpath = "(//figure/span/img)")
	private static WebElement leadImage;

	@FindBy(xpath = "//div[@data-vars-cardtype='top-news']//img[1]")
	private static WebElement firstLeadImage;

	@FindBy(xpath = "//div[contains(@class,'fullStory')]")
	private static WebElement fullStoryHeading;

	@FindBy(xpath = "//div[contains(@class,'cartHolder')]/h3/a")
	private static WebElement headLineStoriesLink;

	@FindBy(xpath = "//ul[@class='leftFixedNav']//li[2]/a")
	private static WebElement sectionPageList;

	@FindBy(xpath = "//div[@class='storyDetails']//p[parent::div[not(contains(@class,'slideStory'))]]")
	private static List<WebElement> fullStoryParagraphs;

	@FindBy(xpath = "(//div[@id='section_news']//li[1]//p[1]//a[1]")
	private static WebElement sliderCarousel;

	@FindBy(xpath = "(//div[@id='section_news']//li[2]//p[1]//a[1]")
	private static WebElement otherStoryInCarousel;

	@FindBy(xpath="//div[@id='section_news']//li[3]//p[1]")
	private static List<WebElement> paragraphsInOtherStoryInCarousel;

	@FindBy(xpath = "(//div[@class='detail']/p)[1]")
	private static WebElement paragraphIndiaNews;

	@FindBy(xpath = "(//figcaption)[1]")
	private static WebElement caption;

	@FindBy(xpath = "//div[@class='storyBy']")
	private static List<WebElement> imageCredit;

	@FindBy(xpath = "(//a[@class='closeStory close-btn'])[1]")
	private static WebElement close;

	@FindBy(xpath = "//div[@class='shareIcons']")
	private static List<WebElement> shareIcons;

	@FindBy(xpath = "//div[contains(@class,'storyTopics')]")
	private static WebElement topics;

	@FindBy(xpath = "//a[@href='/india-news']//em")
	private static WebElement indiaNews;

	@FindBy(xpath = "//div[@class='dateTime']")
	private static List<WebElement> dateTime;

//	@FindBy(xpath = "//div[@class='storyShortDetail']")
//	private static List<WebElement> stories;

	@FindBy(xpath = "//div[@class='actionDiv']//div[@class='dateTime']")
	private static WebElement stories;
	
//	@FindBy(xpath = "//iframe[contains(@src,'https://cdn.jwplayer.com/players/')]")
//	private static WebElement videoIframe;

	@FindBy(xpath ="//div[@class='videoBox']//iframe")
	private static WebElement videoIframe;


	@FindBy(xpath = "//div[@class='videoAdUiSkipButtonExperimentalText']")
	private static WebElement skipAdButton;

	@FindBy(xpath = "//div[contains(@class,'jw-text-elapsed')]")
	private static WebElement elapsedTime;

	@FindBy(xpath = "(//figcaption)[1]")
	private static WebElement captionAndImageCredit;
	
	@FindBy(xpath = "//div[@class='socialEl']")
	private static WebElement shareAndBookMarkVisibility;

	@FindBy(xpath="//div[@class='storyTopics']")
	private static WebElement sectionTopic;

	@FindBy(xpath ="//div[@class='m_ads_unit']/div/div")
	private static WebElement firstAdv;

	@FindBy(xpath = "(//div[@data-vars-storytype='gallery'])[1]//img")
	private static WebElement viewFirstArticleImage;

	@FindBy(xpath = "//h1[contains(text(),'Photos')]")
	private static WebElement photosSection;

	@FindBy(xpath = "//button[@class='close']")
	private static WebElement skipOrSignIn;

	@FindBy(xpath = "(//a[normalize-space()='India News'])[1]")
	private static WebElement indiaNewsOptionInQuickRead;
	@FindBy(xpath = "//li[@class='moreNav mHide']")
	private static WebElement l2More;
	@FindBy(xpath = "(//a[text()='HT Premium'])[2]")
	private static WebElement l2MoreHTPremium;
	@FindBy(xpath = "//div[contains(@class,'cartHolder ')]//h3[@class='hdg3']/a")
	private static List<WebElement> allStory;
	@FindBy(xpath = "//h1[@class='hdg1']")
	private static WebElement storyDetailPageHeadline;
	@FindBy(className = "cardLogin")
	private static WebElement paywallSignIn;
	@FindBy(xpath = "//div[@class='storyTopics']")
	private static WebElement topic;


	public StoryPage() {
		globalVars = GlobalVars.getInstance();
		driver = globalVars.getWebDriver();
		PageFactory.initElements(driver, this);
		commonFunctions = CommonFunctionsWeb.getInstance();
		apiValidation = ApiValidation.getInstance();
		commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
		System.out.println("****************** Test started ******************");
		System.out.println("******************" + globalVars.getProjectName() + "******************");
	}

	public boolean checkUrlAfterClickingOnViewAllphotos() {
		String currentUrl = commonFunctions.getCurrentURL("");
		String storyId = commonFunctions.extractStoryID(currentUrl);
		return currentUrl.contains(storyId) && currentUrl.contains("photos") && currentUrl.endsWith(".html");
	}

	public boolean checkContentOfPhotoStory(WebElement element, String path, Response response) {
		boolean assertion = false;
		commonFunctions.isElementDisplayed(element, 20);
		String actualVal = commonFunctions.getElementText(element, 20);
		if(path.contains("caption")){
			String value = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
			String refactorValue = value.replaceAll("\\<.*?\\>", "");
			String[] pc = actualVal.split(" ");
			assertion = refactorValue.startsWith(pc[0]);
		}
		else{
		String value = response.jsonPath().get(path).toString();
		String refactorValue = value.replaceAll("\\<.*?\\>", "");
		commonFunctions.textToReport(value);
		assertion = refactorValue.replaceAll("\\s+", " ").replaceAll("amp;","").equalsIgnoreCase(actualVal.replaceAll("\\s+", " "));
		}
		return assertion;
	}

	public boolean checkCaptionOfPhotoStory(String uri, String address, Response response) {
		boolean captionPhoto = false;
		commonFunctions.isElementDisplayed(captionOfStory, 20);
		String caption = commonFunctions.getElementText(captionOfStory, 20);
		String value = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
		String[] pc = caption.split(" ");
		captionPhoto = value.startsWith(pc[0]);
		return captionPhoto;
	}

	public boolean checkShareIconAndBookMark() {
		int iconsCount = shareIconBookMark.size();

		for (int i = 0; iconsCount > i; i++) {
			boolean isStep = commonFunctions.isElementDisplayed(shareIconBookMark.get(i));
			Utils.logStepInfo(isStep, i+" Photo Share icon and book mark");
		}
		return commonFunctions.isElementDisplayed(shareIconBookMark.get(0), 20, "ShareIcon and BookMark");
	}

	public boolean checkUrlAfterClickingOnSecondphoto() {
		commonFunctions.scrollToElementView(secondPhoto, 20, "Second Photo");
		commonFunctions.scrollToElementView(secondShareIcon,10,"Scrolling to second Share Icon");
		commonFunctions.dummyWait(10);
		String url = commonFunctions.getCurrentURL(" ");
		return url.contains("2.html");
	}

	public boolean checkNavigatedToIndiaNewsPage() {
		commonFunctions.clickElementWithActions(exploremenu, 10, "Explore Menu");
		commonFunctions.clickElementWithActions(indiaNews, 10, "India News");
		String currentUrl = commonFunctions.getCurrentURL("URL");
		return	currentUrl.equalsIgnoreCase(Utils.getUrl() + "india-news");
	}

	public boolean checkUrlAfterClickingReadFullStory() {
		boolean isClicked=commonFunctions.clickElementWithActions(openFullStory, 20, "Read Full Story");
//		commonFunctions.scrollToElementView(firstAdv,10,"First Advertisement");
		String currentURL = commonFunctions.getCurrentURL(" ");
		Utils.logStepInfo(true,currentURL);
		try{
			if (!currentURL.isEmpty() && currentURL.contains(".html")) {
				isClicked = true;
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return isClicked;
	}

	public Response getResponseFromAPI(String uri, String address) {
		String currentUrl = commonFunctions.getCurrentURL("URL");
		String storyid = commonFunctions.extractStoryID(currentUrl);
		commonFunctions.dummyWait(10);
		Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
		return response;
	}


	public boolean checkIndiaNewsElements(WebElement element, String path,Response response) {

		boolean isStep;
		String value = "";
		String text = commonFunctions.getElementText(element, 20);
		commonFunctions.isElementDisplayed(section,10);
		if (path.contains("paragraph")) {
			LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read(path);
			value = paragraph.toString();
		} else {
			value = JsonPath.parse(response.getBody().asString()).read(path);
		}
		Utils.logStepInfo(true, "" + value + "");
		if (element == section) {
			isStep = value.equalsIgnoreCase(text);
		} else {
			isStep = value.contains(text);
		}
		return isStep;
	}

	public boolean checkIndiaNewsElements(WebElement element, String uri, String address, String path) {

		boolean isStep;
		HashMap data = new HashMap();
		String value = "";
		String text = commonFunctions.getElementText(element, 20);
		commonFunctions.isElementDisplayed(section,10);

		String currentUrl = commonFunctions.getURL();
		String storyId = commonFunctions.extractStoryID(currentUrl);
		Utils.logStepInfo(true,storyId);
		Response response = commonFunctions.getResponseFromURI(uri, address+storyId);

		if (path.contains("paragraph")) {
			value = data.get(path).toString();
		} else if (path.contains("section")){
			data= response.jsonPath().getJsonObject("metadata");
			value = data.get(path).toString();
		}
		else{
			value =response.jsonPath().get(path).toString();
		}

		Utils.logStepInfo(true, "" + value + "");
		if(path.contains("summary")){
			isStep=value.contains(text.replaceAll("\\s+",""));
		}
		else{
			isStep = value.equalsIgnoreCase(text);
		}
		return isStep;
	}

	public boolean checkHeadlineNextToSectionNameIndiaNews(String uri, String address) {
		boolean isHeadLineDisplayed = false;
		String mobileheadline = commonFunctions.getElementText(title, 20);
		String currentUrl = commonFunctions.getURL();
		String storyid = commonFunctions.extractStoryID(currentUrl);
		Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
		String value = JsonPath.parse(response.getBody().asString()).read("$.headline");
		String[] headlineStartsWith=value.split(" ");
		isHeadLineDisplayed = mobileheadline.startsWith(headlineStartsWith[0]);
		return isHeadLineDisplayed;

	}

	public boolean checkSummaryIndiaNews(String uri, String address) {
		boolean isSummaryDisplayed = false;
		String summary = commonFunctions.getElementText(summaryOfFirstStory, 20);
		String currentUrl = commonFunctions.getURL();
		String storyid = commonFunctions.extractStoryID(currentUrl);
		Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
		String value = JsonPath.parse(response.getBody().asString()).read("$.summary");
		commonFunctions.textToReport(value);
		isSummaryDisplayed = value.contains(summary);
		return isSummaryDisplayed;
	}

	public boolean checkLeadImageIndiaNews() {

		return commonFunctions.isElementDisplayed(leadImage, 20, "Lead Image");
	}

	public boolean checkParagraphBelowLeadImage(String uri, String address) {
		boolean isStep = false;
		commonFunctions.scrollUsingAction(paragraphIndiaNews, "paragraph");
		String text = commonFunctions.getElementText(paragraphIndiaNews);
		String currentUrl = commonFunctions.getURL();
		String storyid = commonFunctions.extractStoryID(currentUrl);
		Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
		LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read("$.listElement[0].paragraph");
		String value = paragraph.toString();
		value=Utils.formatAPIText(value);
		Utils.logStepInfo(true, "" + value + "");
		isStep = value.contains(text);
		return isStep;
	}

	public boolean checkScrollToPicsInStory() {
		return commonFunctions.scrollUsingAction(shareIcons.get(0), "Topics");
	}

	public boolean checkShareIconsAtTheEndOfStory() {
		return commonFunctions.isElementDisplayed(shareIcons.get(1), 10, "ShareIcons visible");
	}

	public boolean checkCloseButton() {
		boolean isCloseDisplayed = false;
		isCloseDisplayed = commonFunctions.isElementDisplayed(close, 10, "Close button");
		commonFunctions.clickElement(close, 20, "Close");
		return isCloseDisplayed;
	}

	public boolean checkURLchangedToParentURL() {
		boolean isURLchanged = false;
		String url = commonFunctions.getCurrentURL("Parent URL");
		if (url.equals(Utils.getUrl() + "india-news")) {
			isURLchanged = true;
		}
		return isURLchanged;
	}

	@Override
	public boolean checkStoriesDisplayedLastPublished(String[] params) {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean navigateToNewsPage = navigateToNewsPage();
		String publishDateApi = lastPublishedApiValidation(params);
		String publishedDate = lastPublishedDate();
		return navigateToNewsPage && (publishedDate.equalsIgnoreCase(publishDateApi));
	}

	@Override
	public boolean checkStandardStoriesAreDisplayed(String uri, String address) {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean checkNavigation = checkNavigatedToIndiaNewsPage();
		boolean checkUrl = checkUrlAfterClickingReadFullStory();

		boolean checkNewsSection = checkIndiaNewsElements(section, uri, address, "section");
		boolean checkHeadLine = checkIndiaNewsElements(title, uri, address, "mobileHeadline");
		boolean checkSummary = checkIndiaNewsElements(summaryOfFirstStory, uri, address, "summary");
		boolean checkLeadMediaCaption = checkLeadMediaCaptionImageCreditNextToSummary(uri, address);
		boolean checkParagraph = checkParagraphBelowLeadImage(uri, address);
		boolean checkTopics = checkScrollToPicsInStory();
		boolean checkShareIcon = checkShareIconsAtTheEndOfStory();
		boolean checkCloseButton = checkCloseButton();
		boolean checkParentUrl = checkURLchangedToParentURL();

		return checkNavigation && checkNewsSection && checkHeadLine && checkSummary && checkLeadMediaCaption && checkUrl
				&& checkParagraph && checkTopics && checkShareIcon && checkCloseButton && checkParentUrl;
	}

	@Override
	public boolean videoStoryContentValidation(String params[]) {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean explorerMenu = clickOnExplorerMenu();
		boolean videosHamburgerMenu = scrollDownClickAtVideosHamburgerMenu();
		String firstLinkUrl = getLinkUrl();
		boolean firstVideoArticle = clickOnViewVideoFirstArticleAtVideosSection();
		boolean urlModified = checkCurrentUrlModified(firstLinkUrl);
		boolean pageVideo = scrollDownToPageVideoStarAutomatically();
		boolean headlineOfVideoStory = checkHeadlineOfVideoStory(params);
		boolean videoControls = checkVideoControls();
		boolean checkSummary = checkSummaryBelowVideo(params);
		boolean readMoreButton = checkReadMoreButtonBelowVideo();
		boolean stopVideo = checkScrollDownToPageStopVideo();
		boolean checkShareIcon = checkShareIconAndBookMarkAboveVideo();

		return explorerMenu && videosHamburgerMenu && firstVideoArticle && urlModified && pageVideo
				&& headlineOfVideoStory && videoControls && checkSummary && readMoreButton && stopVideo
				&& checkShareIcon;
	}

	@Override
	public boolean liveBlogContentValidation(String uri, String address, String url) {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean navigate = navigateToURL();
		boolean headLine = checkHeadlineNextToSectionName(uri, address);
		boolean checkSummary = checkSummaryNextToHeadLine();
		boolean checkLeadMedia = checkLeadMediaCaptionImageCreditNextToSummary(uri , address);
		boolean checkParagraph = checkParagraphDisplayed();
		boolean checkShareIcon = checkShareIconDisplayed();
		boolean checkTopics = checkTopicsDisplayed();

		return navigate && headLine && checkSummary && checkLeadMedia && checkParagraph && checkShareIcon
				&& checkTopics;
	}



	@Override
	public boolean checkLastPublishedDate(String[] params) {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean navigateToNewsPage = navigateToNewsPage();
		String publishDateApi = lastPublishedApiValidation(params);
		String publishedDate = lastPublishedDate();
		boolean step = publishedDate.equalsIgnoreCase(publishDateApi);
		//.replaceAll(":\\d+","").trim()
		//.replaceAll(":\\d+","").replaceAll("IST","").trim()
		return navigateToNewsPage && step;
	}

	@Override
	public boolean photosGalleryContentValidation() {
		return false;
	}

	@Override
	public boolean photoHeadLineSummaryBookMarkAndShare(String uri, String address) {
		boolean checkSummary= false;
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean isPhotoVisible = photoContentOfStory();
		boolean isUrlChanged = checkUrlAfterClickingOnViewAllphotos();
		String currentUrl = commonFunctions.getURL();
		String storyId = commonFunctions.extractStoryID(currentUrl);
		Response response = commonFunctions.getResponseFromURI(uri, address + storyId);
		boolean checkHeadLine = checkContentOfPhotoStory(headLineOfStory, "headline",response);
		if(commonFunctions.isElementDisplayed(summaryLineOfPhoto)) {
			  checkSummary = checkContentOfPhotoStory(summaryLineOfPhoto, "summary", response);
		}
		else if(commonFunctions.isElementDisplayed(summaryLineOfPhotoP))
		{
			  checkSummary = checkContentOfPhotoStory(summaryLineOfPhotoP, "summary", response);

		}
		boolean checkCaption = checkContentOfPhotoStory(captionOfStory,"$.leadMedia.image.caption",response);
		boolean checkShareIcon = checkShareIconAndBookMark();
		boolean checkUrlSecondPhoto = checkUrlAfterClickingOnSecondphoto();

		return isPhotoVisible && isUrlChanged && checkHeadLine && checkSummary && checkCaption && checkShareIcon
				&& checkUrlSecondPhoto;
	}


	public boolean checkStandardStoryPagination(String uri, String address) {
		return false;
	}

	@Override
	public boolean checkContentImagesAndEmbeds(String[] params) {
		return true;
	}

	@Override
	public boolean checkSignInWallOnStoryPage() {
		return false;
	}

	@Override
	public boolean checkReadFullStoryClickable(String quickReadURL, String readSFullStoryText) {return false;	}

	@Override
	public boolean checkReadFullStoryClickableinQuickReads() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.navigateToURL(globalVars.getURL()+"/quick-read");
		commonFunctions.clickElement(indiaNewsOptionInQuickRead,5,"India News In Quick Reads");
		boolean readFullStoryOptionInIndiaNews = false;
		if(listOfFullReadStoryOption.size()>1){
			Utils.logStepInfo(listOfFullReadStoryOption.size() + " - times Read Full Story are available for India News Section under Quick Reads");
			readFullStoryOptionInIndiaNews = true;
			Utils.logStepInfo(readFullStoryOptionInIndiaNews,"Read Full Story Option displayed in India News");
		}
		commonFunctions.clickElement(entertainmentCarousel,5,"India News In Quick Reads");
		if(listOfFullReadStoryOption.size()>1){
			Utils.logStepInfo(listOfFullReadStoryOption.size() + " - times Read Full Story are available for entertainment Section under Quick Reads");
			readFullStoryOptionInIndiaNews = true;
			Utils.logStepInfo(readFullStoryOptionInIndiaNews,"Read Full Story Option displayed in entertainment News");
		}
		boolean isReadFullStoryClickable = commonFunctions.isElementClickable(listOfFullReadStoryOption.get(0),5,"First Read Full Story Option");
		return readFullStoryOptionInIndiaNews && isReadFullStoryClickable;
	}

	@Override
	public boolean checkSignInWallOnStoryPage(String readtext, String premium, String saveArticles, String signIn, String signUp, String skip) {
		return false;
	}


	@Override
	public boolean checkLeadImage() {
		boolean isLeadImageDisplayedAndClickable;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.scrollToElement(firstLeadImage, "FirstStory Lead Image");
		commonFunctions.clickElementWithJS(firstLeadImage, 20, "FirstStory Lead Image");
		commonFunctions.clickElementIfDisplayed(skipPopup, 15,"Sign In Popup");
		commonFunctions.dummyWait(10);
		isLeadImageDisplayedAndClickable=commonFunctions.isElementDisplayed(fullStoryHeading, 20, "Full story headline displayed");
		commonFunctions.navigateToURL(globalVars.getURL());
		return isLeadImageDisplayedAndClickable;
	}


	@Override
	public boolean checkHeadline() {
		boolean isStoryDetailOpen=true;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.clickElementWithJS(firstStoryHeadline, 20, "Headline");
		commonFunctions.dummyWait(5);
		isStoryDetailOpen=commonFunctions.isElementDisplayed(openStory, 20, "Full story headline");
		commonFunctions.navigateToURL(globalVars.getURL());
		return isStoryDetailOpen;
	}

	@Override
	public boolean checkStoryIsExpanded() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.clickElementWithJS(sectionPageList, 20, sectionPageList.getText().trim());
		commonFunctions.scrollDownOnce();
		boolean leadImageStatus = commonFunctions.isElementDisplayed(headLineStoriesLink, 20, "Lead story headline");
		commonFunctions.clickElementWithJS(headLineStoriesLink, 50, "HeadLine");
		commonFunctions.waitForURLContains(".html");
		boolean isFullStoryOpen = commonFunctions.isElementDisplayed(fullStoryHeading, 10, "Full story");
		int listSize = fullStoryParagraphs.size();
		boolean isOtherStoryDetailOpen;
		if (listSize > 1) {
			isOtherStoryDetailOpen = true;
			Utils.logStepInfo(true, "full Story Paragraphs are displayed");
		} else {
			isOtherStoryDetailOpen = false;
			Utils.logStepInfo(false, "full Story Paragraphs are not displayed - Failed");
		}
		return leadImageStatus && isOtherStoryDetailOpen & isFullStoryOpen;
	}

	@Override
	public boolean checkDateTime() {
		boolean dateTimeDisplayedStatus;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.clickElementWithJS(exploreButton,30,"clicked on explore");
		commonFunctions.clickElementIfDisplayed(skipPopup, 10,"Sign In Popup");
		commonFunctions.clickElementWithJS(indiaNews,30,"clicked on india News");
		commonFunctions.dummyWait(10);
		dateTimeDisplayedStatus=commonFunctions.isElementDisplayedOfListOfElements(dateTime,"Date Time");
		return dateTimeDisplayedStatus;
	}

    @Override
    public boolean checkAuthorName() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.dummyWait(10);
		commonFunctions.clickElementWithJS(firstStoryHeadline, 20, "HeadLine");
		boolean isFullStoryOpen = commonFunctions.isElementDisplayed(fullStoryHeading, 20, "Full story displayed");
		commonFunctions.scrollToElementView(authorName, 30, "Author Name");
		boolean authorNameVisible = commonFunctions.isElementDisplayed(authorName, 20, "Author/Agency Name");
		return isFullStoryOpen && authorNameVisible;
	}

	@Override
	public boolean checkStoryPageHeader() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.isElementDisplayed(storyHeadline, 20, "Story Headline");
		String headlineHomePage=commonFunctions.getElementText(storyHeadline);
		commonFunctions.clickElementWithJS(storyHeadline, 20, "Story Headline");
		commonFunctions.waitForURLContains(".html");
		commonFunctions.pageRefresh();
		commonFunctions.scrollToElement(openStoryHeadline, "Open Story Headline");
		String headlineStoryPageAfterRefresh=commonFunctions.getElementText(openStoryHeadline);
		boolean isHeadlineSame=commonFunctions.checkTextContains(headlineHomePage,headlineStoryPageAfterRefresh,"Headline");
		commonFunctions.navigateToURL(globalVars.getURL());
		return isHeadlineSame;
	}

	@Override
	public boolean checkTrendingTopicsCarouselDispayed() {
		boolean isTopicsCarouselDisplayed=true;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.dummyWait(10);
		commonFunctions.clickElementWithJS(firstStoryHeadline, 10, "Story Headline");
		commonFunctions.isElementDisplayed(openStory, 20, "Full Story");
		commonFunctions.scrollToElement(trendingCarousel, "Trending Topic Carousel");
		commonFunctions.isElementDisplayed(trendingCarousel, 20,"Trending Carousel");
		String trendingCarouselText=commonFunctions.getElementText(trendingCarousel);
		isTopicsCarouselDisplayed=commonFunctions.checkTextContains("HT",trendingCarouselText,"Carousel Name");
		commonFunctions.navigateToHomePage();
		return isTopicsCarouselDisplayed;
	}

	@Override
	public boolean checkFullStoryCloseButton() {
		boolean isCloseStoryButtonClickable=true;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.clickElementWithJS(firstStoryHeadline, 10, "Story Headline");
		commonFunctions.isElementDisplayed(openStory, 20, "Full Story");
		commonFunctions.scrollUntilElementFound(close);
		commonFunctions.clickElementWithJS(close, 20,"Close Story Button");
		isCloseStoryButtonClickable=commonFunctions.isElementNotDisplayed(openStory, 20, "Full Story");
		commonFunctions.navigateToHomePage();
		return isCloseStoryButtonClickable;
	}

	@Override
	public boolean checkNewsletterBannerDisplayed() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.dummyWait(5);
		commonFunctions.scrollToElement(firstStoryHeadline,  "First Story HeadLine");
		commonFunctions.clickElementWithJS(firstStoryHeadline, 10, "First HeadLine");
		commonFunctions.waitForURLContains(".html");
		commonFunctions.clickElementIfDisplayed(skipPopup, 5,"Sign In Popup");
		commonFunctions.scrollToElement(capsuleBanner, "Newsletter Banner");
		commonFunctions.clickElementWithJS(enterEmail, 10, "Email");
		commonFunctions.sendKeyWithRandomEmail(enterEmail,10);
		commonFunctions.clickElementWithJS(buttonSubscribe, 30, "Subscribe");
		boolean checkNewsletterBannerDisplayed = commonFunctions.checkElementText(subscribedMsg, "Subscribed to newsletter successfully", 30, "Subscribed Message");
		return checkNewsletterBannerDisplayed;
	}

	@Override
	public boolean checkImagePremiumDisplayed() {
		return false;
	}

	@Override
	public boolean checkLeadImage3DotOption() {
		return false;
	}

	@Override
	public boolean checkAfterHeaderAdFirstStoryIsDisplayed() {
		return false;
	}

	@Override
	public boolean checkWhatsAppTwitterRelatedTopicPage() {
		return false;
	}

	@Override
	public boolean checkSectionNameisDispayed() {
		return false;
	}

	@Override
	public boolean checkSubSectionNameisDispayed() {
		return false;
	}

	@Override
	public boolean checkShareStory3DotOption() {
		return false;
	}

	@Override
	public boolean checkActionSheetCancelOption() {
		return false;
	}

	@Override
	public boolean checkIndiaPageThreeDotTapDisplayBottomAction() {
		return false;
	}

	@Override
	public boolean checkIndiaPageRedirectionFromExplore() {
		return false;
	}

	@Override
	public boolean checkCloseTabCloseBottomActionSheet() {
		return false;
	}

	@Override
	public boolean checkRedirectionOnTappingAnyStoryOnIndiaPage() {
		return false;
	}

	@Override
	public boolean checkRedirectionFromStoryDetailsPageOnTappingAnyStoryOnIndiaPage() {
		return false;
	}

	@Override
	public boolean checkShareStoryFromIndia() {
		return false;
	}

	@Override
	public boolean checkAllStoriesArePremiumOnPremmiumPage() {
		return false;
	}

	@Override
	public boolean checkPremiumPageDisplay() {
		return false;
	}

	@Override
	public boolean checkPremiumPageHTPremiumDisplay() {
		return false;
	}

	@Override
	public boolean checkFirstStoryDisplayAfterTitle() {
		return false;
	}

	@Override
	public boolean checkFirstStoryImageDisplayWithPremiumTag() {
		return false;
	}

	@Override
	public boolean checkOtherStoryAreAlsoPremium() {
		return false;
	}

	@Override
	public boolean checkAllOtherStoryHavePremiumTagAtBottom() {
		return false;
	}

	@Override
	public boolean checkStoryHaveSubSectionBelowTitle() {
		return false;
	}

	@Override
	public boolean checkStoryDisplayOnItsSectionPage() {
		return false;
	}

	@Override
	public boolean checkNonLoggedUserOnPremiumPage() {
		return false;
	}

	@Override
	public boolean checkRelatedTopicHeadingDisplayed() {
		return false;
	}

	@Override
	public boolean checkRelatedTopicsDisplayed() {
		return false;
	}

	@Override
	public boolean checkRelatedTopicsRedirection() {
		return false;
	}

	@Override
	public boolean checkRelatedTopicsPageStoryRedirection() {
		return false;
	}

	@Override
	public boolean checkRedirectionOnTopicStoryIfTabOnbBackBtn() {
		return false;
	}

	@Override
	public boolean checkShareStoryFromTopicScreen() {
		return false;
	}

	@Override
	public boolean checkRedirectionOnStoryIfTabOnSectionName() {
		return false;
	}

	@Override
	public boolean checkReadAloudOptionInStoryPage() {
		return false;
	}

	public boolean clickOnExplorerMenu() {
		boolean isExplorermenuClickSuccessful = false;
		try {
			isExplorermenuClickSuccessful = commonFunctions.clickElement(exploreButton, 20, "exploreButton");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isExplorermenuClickSuccessful;
	}

	public boolean photoContentOfStory() {
		boolean photoContent = false;

		commonFunctions.clickElement(exploremenu, 20, "Explore icon clicked");
		commonFunctions.scrollToElementViewAndClick(photos, 10, "Click on photos");
		commonFunctions.scrollToElementView(photosSection,10,"Scroll to Photos Section");
		commonFunctions.clickElementWithActions(viewFirstArticleImage, 10, "Click on View all photos");

		photoContent = commonFunctions.isElementDisplayed(firstphoto, 10);
		boolean photo1_story = commonFunctions.isElementDisplayed(firstphoto, 20);
		boolean share_BookMark = commonFunctions.isElementDisplayed(shareAndBookMarkVisibility, 20);
		/*commonFunctions.getElementText(headLineOfStory, 20);
		commonFunctions.getElementText(captionOfStory, 20);
		commonFunctions.getElementText(summaryLineOfPhoto, 20);
*/
		if (photo1_story == share_BookMark) {
			photoContent = true;
		}

		return photoContent;
	}


	public boolean checkHeadLineOfPhotoStory() {
		boolean checkHeadLine = false;
		checkHeadLine = commonFunctions.isElementDisplayed(headLineOfStory, 10);
		return checkHeadLine;
	}

	public boolean checkSummaryOfPhotoStory() {
		boolean checkSummary = false;
		checkSummary = commonFunctions.isElementDisplayed(summaryLineOfPhoto, 10);
		return checkSummary;
	}

	public boolean checkCaptionOfPhotoStory() {
		boolean checkCaption = false;
		checkCaption = commonFunctions.isElementDisplayed(captionOfStory, 20);
		return checkCaption;
	}

	public boolean checkUrlAfterClickingOnViewAllPhotos() {
		String currentUrl = commonFunctions.getCurrentURL("");
		String storyId = commonFunctions.extractStoryID(currentUrl);
		return currentUrl.contains(storyId) && currentUrl.contains("photos") && currentUrl.endsWith(".html");
	}

	public boolean checkUrlAfterClickingOnSecondPhoto() {
		commonFunctions.scrollToElementView(secondPhoto, 20, "Second Photo");
		String url = commonFunctions.getCurrentURL(" ");
		return url.contains("2.html");
	}

	public boolean navigateToURL() {
		boolean isnavigateToURLSuccessful = false;
		try {
			String url = globalVars.getURL()+globalVars.getUrlLiveBlog();
			commonFunctions.navigateToURL(url);
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (currentURL.equals(url)) {
				isnavigateToURLSuccessful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isnavigateToURLSuccessful;
	}

	public boolean checkHeadlineNextToSectionName(String url, String endPoint) {
		boolean isHeadlinenextToSectionName = false;
		boolean headLineApi = false;
		try {
			commonFunctions.scrollToElementView(headLineCricket, 20, "headLineCricket");
			isHeadlinenextToSectionName = commonFunctions.isElementDisplayed(headLineCricket, 20, "headLineCricket");
			String currentURL = commonFunctions.getURL();
			storyID = apiValidation.extractStoryID(currentURL);
			commonFunctions.dummyWait(10);
			response = apiValidation.getResponseFromURI(url, endPoint + storyID);
			String headLineValue = JsonPath.parse(response.getBody().asString()).read("$.headline");
			String text = commonFunctions.getElementText(headLineCricket);
			String getText[] = text.split(":");
			String headLineText = getText[0];
			if (headLineValue.contains(headLineText)) {
				Utils.logStepInfo("check headline successful");
				headLineApi = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isHeadlinenextToSectionName && headLineApi;
	}

	public boolean checkSummaryNextToHeadLine() {
		boolean isSummaryNextToHeadLine = false;
		boolean summaryApi = false;
		try {
			commonFunctions.scrollToElementView(summaryCricket, 20, "summaryCricket");
			isSummaryNextToHeadLine = commonFunctions.isElementDisplayed(summaryCricket, 20, "summaryCricket");
			String summaryText = commonFunctions.getElementText(summaryCricket);
			String summaryValue = JsonPath.parse(response.getBody().asString()).read("$.summary");
			if (summaryValue.contains(summaryText)) {
				commonFunctions.textToReport("check summary successful");
				summaryApi = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSummaryNextToHeadLine && summaryApi;
	}


	public boolean checkLeadMediaCaptionImageCreditNextToSummary(String uri, String address) {
		boolean isLeadMediaCaptionImageCreditDisp = false;
		boolean captionApi = false;
		try {
			commonFunctions.scrollToElementView(leadMediaCaption, 20, "leadMediaCaption");
			isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCaption, 20);
			String captionImageCredit = commonFunctions.getElementText(captionAndImageCredit);
			if (!captionImageCredit.isEmpty()) {
				Response response = getResponseFromAPI(uri, address);
				String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
				if (captionImageCredit.contains(captionFromAPI)) {
					Utils.logStepInfo("check caption successful");
					captionApi = true;
				}
			} else {
				captionApi = true;
				Utils.logStepInfo(true, "Image Credit not available");
			}
			/*Observation has found sometimes image credit for the story has not been displayed so we are checking API response
			 * if image credit found then only it will check*/

				String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
				if (captionImageCredit.contains(imageCreditFromAPI)) {
					boolean imageCredit = true;
					Utils.logStepInfo("check imageCredit successful");
				}
			} catch (Exception NullPointerException) {
				Utils.logStepInfo("Story does not have imageCredit");
			}
			return isLeadMediaCaptionImageCreditDisp && captionApi;
		}


		public boolean checkParagraphDisplayed () {
			boolean isParagraphDisplayed = false;
			boolean paragraphApi = false;
			try {
				commonFunctions.scrollToElementView(paragraphCricket, 20, "paragraphCricket");
				isParagraphDisplayed = commonFunctions.isElementDisplayed(paragraphCricket, 20);
				String text = commonFunctions.getElementText(paragraphCricket);
				String value = JsonPath.parse(response.getBody().asString()).read("$.introBody");
				String getText[] = text.split(":");
				String paragraphText = getText[0];
				if (text.contains(paragraphText)) {
					Utils.logStepInfo("check paragraph successful");
					paragraphApi = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isParagraphDisplayed && paragraphApi;
		}

		public boolean checkShareIconDisplayed () {
			boolean checkShareIconDisplayed = false;
			try {
				commonFunctions.scrollToElementView(shareIconCricket, 20, "shareIconCricket");
				checkShareIconDisplayed = commonFunctions.isElementDisplayed(shareIconCricket, 20);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return checkShareIconDisplayed;
		}

		public boolean checkTopicsDisplayed () {
			boolean checkTopicsDisplayed = false;
			boolean checkTopicApi = false;
			try {
				commonFunctions.scrollToElementView(topicCricket, 20, "topicCricket");
				checkTopicsDisplayed = commonFunctions.isElementDisplayed(topicCricket, 20);
				String text = commonFunctions.getElementText(topicCricket);
				JSONArray topic = JsonPath.parse(response.getBody().asString()).read("$.metadata.topic");
				String value = topic.get(0).toString();
				if (text.toLowerCase(Locale.ROOT).contains(value)) {
					Utils.logStepInfo("check Topics successful");
					checkTopicApi = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return checkTopicsDisplayed && checkTopicApi;
		}

		public boolean scrollDownClickAtVideosHamburgerMenu () {
			boolean isScrollDownToVideosSuccessful = false;
			try {
				commonFunctions.scrollToElementView(scrollToHamburgermenu, 20, "clickOnVideosHamburgerMenu");
				commonFunctions.scrollToElementView(scrollToPodCasts, 20, "clickOnVideosHamburgerMenu");
				isScrollDownToVideosSuccessful = commonFunctions.scrollToElementViewAndClick(clickOnVideosHamburgerMenu, 20, "clickOnVideosHamburgerMenu");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isScrollDownToVideosSuccessful;
		}

		public boolean clickOnViewVideoFirstArticleAtVideosSection () {
			boolean isClickOnFirstVideoArt = false;
			try {
				isClickOnFirstVideoArt = commonFunctions.scrollToElementViewAndClick(firstArticleVideoSection, 20,
						"clickOnFirstArticleVideoSection");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isClickOnFirstVideoArt;
		}

		public boolean checkCurrentUrlModified (String firstLinkUrl){
			boolean isCurrentURLModified = false;
			try {
				commonFunctions.scrollToElementView(exploreButton, 20, "exploreButton");
				String currentURL = commonFunctions.getCurrentURL("getCurrentURL Successful");
				if (!currentURL.isEmpty() && currentURL.contains(firstLinkUrl)) {
					isCurrentURLModified = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isCurrentURLModified;
		}

		public boolean scrollDownToPageVideoStarAutomatically () {
			boolean isVideoPlaying = false;
			try {
				commonFunctions.switchToFrame(videoIframe, 20);
				isVideoPlaying = commonFunctions.checkVideoPauseButton();
				commonFunctions.switchToDefaultContent();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return isVideoPlaying;
		}

		public boolean checkHeadlineOfVideoStory (String params[]){
			boolean isHeadLineOfStoryDisplayed = false;
			boolean headLineApi = false;
			try {
				String headLineText = commonFunctions.getElementText(checkHeadLineOfStory);
				commonFunctions.scrollToElementView(checkHeadLineOfStory, 20, "chechHeadLineOfVideoStory");
				isHeadLineOfStoryDisplayed = commonFunctions.isElementDisplayed(checkHeadLineOfStory, 20,
						"chechHeadLineOfVideoStory");
				String currentURL = commonFunctions.getURL();
				storyID = apiValidation.extractStoryID(currentURL);

				response = apiValidation.getResponseFromURI(params[0], params[1] + storyID);
				String headLineValue = JsonPath.parse(response.getBody().asString()).read("$.headline");

				if (headLineText.equalsIgnoreCase(headLineValue)) {
					commonFunctions.textToReport("check headline successful");
					headLineApi = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isHeadLineOfStoryDisplayed && headLineApi;
		}

		public boolean checkVideoControls () {
			boolean isVideoPlayButton = false;
			boolean isVideoPauseButton = false;
			boolean isVideoMuteAndVolumeButtons = false;
			boolean isVideoElapsedTime = false;
			try {
				commonFunctions.scrollToElementView(checkBookMark, 20, "checkBookMark");
				commonFunctions.scrollToElementView(firstVideobox, 20, "firstVideobox");
				commonFunctions.switchToFrame(videoIframe, 15);
				isVideoPauseButton = commonFunctions.checkVideoPauseButton();
				isVideoPlayButton = commonFunctions.checkVideoPlayButton();
				isVideoMuteAndVolumeButtons = commonFunctions.checkVideoMuteAndVolumeButton();
				commonFunctions.checkVideoPlayButton();
				commonFunctions.switchToDefaultContent();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isVideoPauseButton && isVideoPlayButton && isVideoMuteAndVolumeButtons;
		}

		public boolean checkSummaryBelowVideo (String params[]){
			boolean isSummaryDispalyed = false;
			boolean summaryApi = false;
			try {
				isSummaryDispalyed = commonFunctions.scrollToElementView(checkSummaryVideo, 20, "checkSummaryVideo");
				String summaryText = commonFunctions.getElementText(checkSummaryVideo);
				String currentURL = commonFunctions.getCurrentURL("");
				commonFunctions.dummyWait(10);
				storyID = commonFunctions.extractStoryID(currentURL);
				Utils.logStepInfo(true, storyID);
				commonFunctions.dummyWait(10);
				response = commonFunctions.getResponseFromURI(params[0], params[1] + storyID);
				commonFunctions.dummyWait(10);
				String summaryValue = JsonPath.parse(response.getBody().asString()).read("$.summary");
				commonFunctions.dummyWait(10);
				if (summaryValue.contains(summaryText)) {
					commonFunctions.textToReport("check summary successful");
					summaryApi = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isSummaryDispalyed && summaryApi;
		}

		public boolean checkReadMoreButtonBelowVideo () {
			boolean isReadMoreButtonDispalyed = false;
			try {
				commonFunctions.scrollUp();
				if (commonFunctions.scrollToElementView(checkReadMoreButton, 20, "checkReadMoreButton")) {
					isReadMoreButtonDispalyed = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isReadMoreButtonDispalyed;
		}

		public boolean checkScrollDownToPageStopVideo () {
			boolean isVideoStopped = false;
			try {
				commonFunctions.clickElementIfDisplayed(skipOrSignIn);
				commonFunctions.scrollToElementView(scrollDownToStopVideo, 20, "scrollDownToStopVideo");
				commonFunctions.switchToFrame(videoIframe, 15);
				isVideoStopped = commonFunctions.checkVideoPlayButton();
				commonFunctions.switchToDefaultContent();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isVideoStopped;
		}

		public boolean checkShareIconAndBookMarkAboveVideo () {
			boolean isShareiconDisplayed = false;
			boolean isBookMarkDisplayed = false;
			try {
				commonFunctions.scrollToElementView(checkShareIcon, 20, "checkShareIcon");
				isShareiconDisplayed = commonFunctions.isElementDisplayed(checkShareIcon, 20, "checkShareIcon");
				isBookMarkDisplayed = commonFunctions.isElementDisplayed(checkBookMark, 20, "checkBookMark");

			} catch (Exception e) {
				e.printStackTrace();
			}
			return isShareiconDisplayed && isBookMarkDisplayed;
		}

		public boolean navigateToNewsPage () {
			boolean isNavigationSuccessful = false;
			commonFunctions.navigateToURL(globalVars.getURL() + "india-news");
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (currentURL.equals(Utils.getUrl() + "india-news")) {
				isNavigationSuccessful = true;
			}
			return isNavigationSuccessful;
		}

		public String lastPublishedDate () {
			String storyData = stories.getText();
			return storyData.split("on ")[1];
		}

		public String lastPublishedApiValidation (String params[]){
			try {
				commonFunctions.clickElementWithJS(openFullStory, 20, "openFullStory");
				commonFunctions.dummyWait(10);
				String currentUrl = commonFunctions.getCurrentURL("");
				String storyId = commonFunctions.extractStoryID(currentUrl);
				String query = params[1];
				Response response = apiValidation.getResponseFromURI(params[0], query + storyId);
				commonFunctions.navigateBack();
				List data= response.jsonPath().getList("listElement.lastPublishedDate");
				System.out.println(HTMLParser.getParsedDate(data.get(0).toString()));
				DateFormat utcFormat = new SimpleDateFormat();
				utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				DateFormat indianFormat = new SimpleDateFormat(data.get(0).toString());
				indianFormat .setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
				Date timestamp = utcFormat.parse(data.get(0).toString());
				String output = indianFormat.format(timestamp);


				return "date";
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

		public String getLinkUrl () {
			commonFunctions.scrollToElementView(firstArticleVideoSection, 20, "firstArticleVideoSection");
			String href = firstArticleVideoSection.getAttribute("href");
			return href;
		}

	@Override
	public boolean checkRedirectionWhenUserTapsOnStoryInCitiesSection() { return false; }

	@Override
	public  boolean checkSubscriptionPaywall(String HTPremiumPageUrl,String email,String password) {
		boolean isShowing;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.mouseHoverOnElement(l2More, 10, "L2 more");
		isShowing = commonFunctions.isElementDisplayed(l2MoreHTPremium, 10, "HT Premium");
		commonFunctions.clickElementWithJS(l2MoreHTPremium, 10, "L2 HT Premium");
		isShowing &= commonFunctions.checkCurrentPageUrlEqualToExpectedUrl(HTPremiumPageUrl, "HT Premium page");
		commonFunctions.dummyWait(3);
		commonFunctions.scrollUsingAction(allStory.get(0), "first story");
		isShowing &= commonFunctions.isElementDisplayed(allStory.get(0), 10, "first Story");
		commonFunctions.clickElement(allStory.get(0), 10, "first Story");
		commonFunctions.dummyWait(2);
		commonFunctions.scrollUsingAction(storyDetailPageHeadline, "story headline");
		isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story detail page");
		commonFunctions.scrollUsingAction(paywallSignIn, "paywall signin");
		isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "paywall signin");
		commonFunctions.clickElement(paywallSignIn, 10, "paywall signIn");
		isShowing &= commonFunctions.isElementDisplayed(emailTextBoxMainSignInPage, 10, "Email input box");
		commonFunctions.sendKeyBoolean(emailTextBoxMainSignInPage, email, 10, "Email input box");
		commonFunctions.scrollUsingAction(continueButtonSignInPage, "continue btn");
		commonFunctions.clickElement(continueButtonSignInPage, 10, "continue btn");
		commonFunctions.dummyWait(3);
		commonFunctions.sendKeyBoolean(passwordTextBoxMainSignInPage, password, 10, "password box");
		commonFunctions.clickElement(signInButtonMainSignInPage, 10, "continue btn");
		isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 20, "story detail page");
		isShowing &= commonFunctions.scrollToViewElement(topic, "Full story", 10);
		return isShowing;
	}

}
