
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonInlineStoriesPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import com.utils.HTMLParser;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Locale;

public class InlineStoriesPage extends CommonInlineStoriesPage {
	public HTMLParser htmlParser;
	private static WebDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsWeb commonFunctions;
	private static ApiValidation apiValidation;

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

	@FindBy(xpath = "//span[contains(@class,'bookmark-candidate')]")
	private static WebElement bookmarkButton;

	@FindBy(xpath = "//a[text()='Saved']")
	private static WebElement savedLink;

	@FindBy(xpath = "//span[contains(@class,'bookmark-candidate')]//preceding::h3//a")
	private static WebElement storyTitle;

	@FindBy(xpath = "//span[contains(@class,'bookmark morebm')]//preceding::h3//a")
	private static WebElement savedStoryTitle;

	@FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
	private static WebElement openFullStory;

	@FindBy(xpath = "//div[contains(@class,'fullStory')]")
	private static WebElement section;

	@FindBy(xpath = "//h1[@class = 'hdg1']")
	private static WebElement headline;

	@FindBy(xpath = "//*[@id='dataHolder']/div[2]/h2")
	private static WebElement summary;

	@FindBy(xpath = "//a[contains(text(),'READ')]")
	private static WebElement openFullStorySaved;

	@FindBy(xpath = "(//div[contains(@class,'storyDetails')]//div//p)[1]")
	private static WebElement paragraph;

	@FindBy(xpath = "//div[contains(@class,'shareIcons')]")
	private static WebElement shareIcons;

	@FindBy(xpath = "//div[contains(@class,'storyTopics')]")
	private static WebElement topics;

	@FindBy(xpath = "//a[contains(@class,'closeStory')]")
	private static WebElement closeButton;

	@FindBy(xpath = "(//div[@class='storyBy'])[1]")
	private static WebElement leadMediaCaption;

	@FindBy(xpath = "(//figcaption)[1]")
	private static WebElement captionAndImageCredit;

	@FindBy(xpath = "//div[@id='webpush-onsite']")
	private static WebElement webPushFrame;

	@FindBy(id = "deny")
	private static WebElement notificationLater;

	public InlineStoriesPage() {
		globalVars = GlobalVars.getInstance();
		driver = globalVars.getWebDriver();
		PageFactory.initElements(driver, this);
		commonFunctions = CommonFunctionsWeb.getInstance();
		apiValidation = ApiValidation.getInstance();

		commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
		System.out.println("****************** Test started ******************");
		System.out.println("******************" + globalVars.getProjectName() + "******************");
	}

	public boolean clickReadFullStory() {
		boolean isReadfullStoryClick;
		commonFunctions.scrollUsingAction(openFullStory, "Read Full Story");
		isReadfullStoryClick= commonFunctions.clickElementWithJS(openFullStory,20,"openFullStory");
		return isReadfullStoryClick;
	}

	public boolean checkUrlAfterClickingReadFullStory() {
		String url = commonFunctions.getCurrentURL("URL");
		String id = commonFunctions.extractStoryID(url);
		return  url.endsWith(".html") && url.contains(id);
	}

	public Response getResponseFromAPI(String uri, String address) {
		String currentUrl = commonFunctions.getCurrentURL("URL");
		String storyid = commonFunctions.extractStoryID(currentUrl);

		Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
		return response;
	}

	public boolean checkInlineStoriesElements(WebElement element,Response response, String path) {
		boolean isStepTrue= false;
		HashMap data = new HashMap();
		String value = "";
		htmlParser = new HTMLParser();
		String text = commonFunctions.getElementText(element, 20);

		if (path.contains("paragraph")) {
			LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read(path);
			List<String> para= HTMLParser.getParagraphList(paragraph.toString());
			value = para.get(0);

		} else if (path.contains("section")){
			data= response.jsonPath().getJsonObject("metadata");
			value = data.get(path).toString();
		}
		else{
			value =response.jsonPath().get(path).toString();
		}
		String formatText = Utils.formatAPIText(text);
		String formatValue = Utils.formatAPIText(value);
		isStepTrue = formatValue.equalsIgnoreCase(formatText);


		return isStepTrue;
	}


	public boolean checkLeadLineCaptionImageCredit(Response response) {
		boolean isLeadMediaCaptionImageCreditDisp = false;
		boolean captionApi = false;
		boolean imageCreditApi = false;
		try {
			isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCaption, 20);
			String captionAndImageCreditText = commonFunctions.getElementText(captionAndImageCredit);

			if (!captionAndImageCreditText.isEmpty()) {
				String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
				String captionAPI = captionFromAPI.replace("&nbsp;"," ");
				Utils.logStepInfo(captionAPI);
				if (captionAndImageCreditText.contains(captionAPI)) {
					Utils.logStepInfo("check caption successful");
					captionApi = true;
				}
			}

			/*Observation has found sometimes image credit for the story has not been displayed so we are checking API response
			 * if image credit found then only it will check*/

			String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
			if(imageCreditFromAPI!=null && imageCreditFromAPI !="") {
				if (captionAndImageCreditText.contains(imageCreditFromAPI)) {
					Utils.logStepInfo("check imageCredit successful");
					imageCreditApi = true;
				}
			} else{
				Utils.logStepInfo("image Credit not displayed for Current Story on UI");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (imageCreditApi) {
			return isLeadMediaCaptionImageCreditDisp && captionApi && imageCreditApi;
		}
		else {
			return isLeadMediaCaptionImageCreditDisp && captionApi;
		}
	}

	public boolean checkShareIcons() {
		boolean isShareIconsDisplayed;
		commonFunctions.scrollUsingAction(shareIcons, "share icons");
		isShareIconsDisplayed = commonFunctions.isElementDisplayed(shareIcons);
		Utils.logStepInfo(isShareIconsDisplayed, "check share icon successful");
		return isShareIconsDisplayed;

	}

	public boolean checkTopic(String uri,String address) {
		boolean isTopicDisplayed;
		try {
			commonFunctions.scrollUsingAction(topics, "topics");
			String text = commonFunctions.getElementText(topics);
			Response response = getResponseFromAPI(uri,address);
			JSONArray topic = JsonPath.parse(response.getBody().asString()).read("$.metadata.topic");
			String value = topic.get(0).toString();
			isTopicDisplayed = text.toLowerCase(Locale.ROOT).contains(value);
		} catch (Exception e) {
			Utils.logStepInfo("Topics is not present on this page");
			isTopicDisplayed = true;
		}

		return isTopicDisplayed;
	}

	public boolean checkCloseButton() {
		boolean isCloseDisplayed;
		isCloseDisplayed = commonFunctions.isElementDisplayed(closeButton, 10, "Close button");
		String  storyURL = commonFunctions.getCurrentURL("URL");
		commonFunctions.clickElementWithJS(closeButton, 20, "Close button");
		commonFunctions.dummyWait(10);
		String parentURL = commonFunctions.getCurrentURL("URL");
		if (!parentURL.equalsIgnoreCase(storyURL) && parentURL.equalsIgnoreCase(Utils.getUrl())){
			isCloseDisplayed = true;
		}
		return isCloseDisplayed;
	}

	@Override
	public boolean checkInlineStoriesCases(String uri,String address){
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean isReadfullStoryClick = clickReadFullStory();
		Utils.logStepInfo(true,"isReadfullStoryClick = "+isReadfullStoryClick);
		commonFunctions.dummyWait(10);
		boolean isRedirectionSuccessful = checkUrlAfterClickingReadFullStory();
		Utils.logStepInfo(true,"isRedirectionSuccessful = "+isRedirectionSuccessful);
		boolean isDisplayed = commonFunctions.isElementDisplayed(section, 20, "Section");
		Utils.logStepInfo(true,"isDisplayed = "+isDisplayed);
		Utils.logStepInfo(isDisplayed, "section is displayed");
		Response response = getResponseFromAPI(uri, address);
		boolean isHeadlineDisplayed = checkInlineStoriesElements(headline, response,"mobileHeadline");
		Utils.logStepInfo(true,"isHeadlineDisplayed = "+isHeadlineDisplayed);
		boolean isSummaryDisplayed = checkInlineStoriesElements(summary, response, "summary");
		Utils.logStepInfo(true,"isSummaryDisplayed = "+isSummaryDisplayed);
		boolean isLeadMediaDisplayed = checkLeadLineCaptionImageCredit(response);
		Utils.logStepInfo(true,"isLeadMediaDisplayed = "+isLeadMediaDisplayed);
		boolean isScrolled = commonFunctions.scrollUsingAction(paragraph, "paragraph");
		Utils.logStepInfo(true,"isScrolled = "+isScrolled);
		Utils.logStepInfo(isScrolled, "paragraph is scrolled");
		boolean isParagraphDisplayed = checkInlineStoriesElements(paragraph, response, "$.listElement[0].paragraph");
		Utils.logStepInfo(true,"isParagraphDisplayed = "+isParagraphDisplayed);
		boolean isTopicDisplayed = checkTopic(uri, address);
		Utils.logStepInfo(true,"isTopicDisplayed = "+isTopicDisplayed);
		return isReadfullStoryClick && isRedirectionSuccessful &&  isHeadlineDisplayed && isSummaryDisplayed
				&& isParagraphDisplayed && isLeadMediaDisplayed;
	}

	@Override
	public boolean checkInlineStoriesOpening() {
		return false;
	}

}
