
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonSocialSharingPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SocialSharingPage extends CommonSocialSharingPage {
	private static WebDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsWeb commonFunctions;
	private static HomePage homePage;

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
	@FindBy(className = "close")
	private static WebElement closeBtn;
	@FindBy(xpath = "//div[@class='btnExplore']")
	private static WebElement explore;
	@FindBy(xpath = "//a[@href='/india-news']/em")
	private static WebElement indiaNews;
	@FindBy(xpath = "//section[contains(@class,'ht-ad-holder')][1]//h3[@class='hdg3'][1]//a")
	private static WebElement firstStoryTitle;
	@FindBy(xpath = "//section[@id='dataHolder']/div[2]/h3/a")
	private static WebElement storyTitle;

	@FindBy(xpath = "//section[contains(@class,'ht-ad-holder')][1]//div[@data-vars-orderid='1']//span[@title='share']")
	private static WebElement firstStoryShareAllOptions;
	@FindBy(xpath = "//section//div[3]/div[2]/span[1]")
	private static WebElement firstStoryShareAllOptionsSocialSharing;

	@FindBy(xpath="(//div[@class='shareIcons'])[1]")
	private static WebElement shareAllIcons;

	@FindBy(xpath = "//div[@class='shareIcons']//a")
	private static List<WebElement> sharingOptionsTwFb;

	@FindBy(xpath = "//div[@class='copyLink']")
	private static WebElement copyUrlToShareAllOptions;
	@FindBy(xpath = "//div[contains(@class,'cartHolder bigCart fullStory')]//div[@class='copyLink']")
	private static WebElement copyUrlToShareOption;


	@FindBy(xpath ="//div[@class='shareSticky']")
	private static WebElement stickyHeader;

	@FindBy(xpath ="//div[@class='shareSticky' and contains(@style,'display') ]//a[contains(@title,'Twitter')]")
	private static WebElement stickyHeaderTwitter;

	@FindBy(xpath ="//div[@class='shareSticky' and contains(@style,'display') ]//a[contains(@title,'Facebook')]")
	private static WebElement stickyHeaderFacebook;

	@FindBy(xpath = "//div[@class='shareIcons']//a[2]")
	private static WebElement twitterSharingAllOptions;
	@FindBy(xpath = "//section[@id='dataHolder']/div[2]/div[3]//a[3]")
	private static WebElement twitterShareOption;
	@FindBy(xpath = "//section[@id='dataHolder']/div[2]/div[3]//a[4]")
	private static WebElement linkedinShareOption;
	@FindBy(xpath = "//section[@id='dataHolder']/div[2]/div[3]//a[2]")
	private static WebElement facebookShareOption;
	@FindBy(xpath = "//section[@id='dataHolder']/div[2]/div[3]//a[1]")
	private static WebElement whatsappShareOption;

	@FindBy(xpath = "//div[@class='shareIcons']//a[3]")
	private static WebElement facebookSharingAllOptions;

	@FindBy(xpath = "//div[@class='shareIcons']//a[4]")
	private static WebElement linkedinSharingAllOptions;

	@FindBy(xpath = "(//div[@class='shareArticle']//a[@class='tw'])[1]")
	private static WebElement twitterShareOptionInlineStory;

	@FindBy(xpath = "(//div[@class='shareArticle']//a[@class='fb'])[1]")
	private static WebElement facebookShareOptionInlineStory;

	@FindBy(xpath = "//a[@data-id='Home,1']")
	private static WebElement HomeOption;

	public SocialSharingPage() {
		globalVars = GlobalVars.getInstance();
		homePage=HomePage.getInstance();
		driver = globalVars.getWebDriver();
		PageFactory.initElements(driver, this);
		commonFunctions = CommonFunctionsWeb.getInstance();

		commonFunctions.clickElementIfDisplayed(acceptCookie, 15, "accept cookie button");
		System.out.println("****************** Test started ******************");
		System.out.println("******************" + globalVars.getProjectName() + "******************");
	}

	public boolean clickOnFirstStory() {
		boolean isClickOnFirstStory = false;
		try {
			isClickOnFirstStory = commonFunctions.scrollToElementViewAndClick(firstStoryTitle, 20, "firstStoryTitle");
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty() && currentURL.contains(".html")) {
				isClickOnFirstStory = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isClickOnFirstStory;
	}

	public boolean backToHomePage() {
		boolean isBackToHomePageSuccessful = false;
		try {
			isBackToHomePageSuccessful = commonFunctions.scrollToElementViewAndClick(HomeOption, 20, "HomeOption");
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty() && currentURL.contains(globalVars.getProdUrl())) {
				isBackToHomePageSuccessful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isBackToHomePageSuccessful;
	}

	public boolean clickOnCopyIconAndCheckUrlCopied() {
		boolean isCopyIconClickedAndUrlCopied = false;
		try {
			commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
			isCopyIconClickedAndUrlCopied = commonFunctions.clickElementIfDisplayed(copyUrlToShareAllOptions, 20,
					"copyUrlToShareAllOptions");
			String elementText = copyUrlToShareAllOptions.getText();
			if (elementText.contains(globalVars.getProdUrl())) {
				isCopyIconClickedAndUrlCopied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopyIconClickedAndUrlCopied;
	}

	public boolean checkSharingStoryOnTwitter() {
		boolean isSharingStoryTwitterSuccessful = false;
		try {
			commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
			isSharingStoryTwitterSuccessful = commonFunctions.clickElementIfDisplayed(twitterSharingAllOptions, 20,
					"twitterSharingAllOptions");
			commonFunctions.waitForWindow(2, "new window");
			ArrayList<String> windowsList = new ArrayList<>(
					commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty() && currentURL.contains("twitter.com")) {
				isSharingStoryTwitterSuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSharingStoryTwitterSuccessful;
	}

	public boolean checkSharingStoryOnFacebook() {
		boolean isSharingStoryFacebookSuccessful = false;
		try {
			commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
			isSharingStoryFacebookSuccessful = commonFunctions.clickElementIfDisplayed(facebookSharingAllOptions, 20,
					"facebookSharingAllOptions");
			commonFunctions.waitForWindow(2, "new window");
			ArrayList<String> windowsList = new ArrayList<>(
					commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty() && currentURL.contains("facebook.com")) {
				isSharingStoryFacebookSuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSharingStoryFacebookSuccessful;
	}

	public boolean checkSharingStoryOnLinkedin() {
		boolean isSharingStoryLinkedinSuccessful = false;
		try {
			commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
			isSharingStoryLinkedinSuccessful = commonFunctions.clickElementIfDisplayed(linkedinSharingAllOptions, 20,
					"linkedinSharingAllOptions");
			commonFunctions.waitForWindow(2, "new window");
			ArrayList<String> windowsList = new ArrayList<>(
					commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty() && currentURL.contains("linkedin.com")) {
				isSharingStoryLinkedinSuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSharingStoryLinkedinSuccessful;
	}

	public boolean checkSharingInlineStoryOnTwitter() {
		boolean isSharingInlineStoryTwSuccessful = false;
		try {
			isSharingInlineStoryTwSuccessful = commonFunctions
					.scrollToElementViewAndClick(twitterShareOptionInlineStory, 20, "twitterShareOptionInlineStory");
			commonFunctions.waitForWindow(2, "new window");
			ArrayList<String> windowsList = new ArrayList<>(
					commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty() && currentURL.contains("twitter.com")) {
				isSharingInlineStoryTwSuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSharingInlineStoryTwSuccessful;
	}

	public boolean checkSharingInlineStoryOnFacebook() {
		boolean isSharingInlineStoryFbSuccessful = false;
		try {
			isSharingInlineStoryFbSuccessful = commonFunctions
					.scrollToElementViewAndClick(facebookShareOptionInlineStory, 20, "facebookShareOptionInlineStory");
			commonFunctions.waitForWindow(2, "new window");
			ArrayList<String> windowsList = new ArrayList<>(
					commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (!currentURL.isEmpty() && currentURL.contains("facebook.com")) {
				isSharingInlineStoryFbSuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSharingInlineStoryFbSuccessful;
	}

	@Override
	public boolean checkSocialSharingFunctionality() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean firstStory = clickOnFirstStory();
		boolean inLineStoryTwitter = checkSharingInlineStoryOnTwitter();
		boolean inLineStoryFacebook = checkSharingInlineStoryOnFacebook();
		return firstStory && inLineStoryFacebook && inLineStoryTwitter;
	}
	public boolean checkSharingStickyStoryOnSocialMedia(WebElement webElement, String element, String title){
		boolean isSharingStickyMediaSuccessful = false;
		try {
			commonFunctions.scrollToElementView(twitterShareOptionInlineStory, 20, "twitterShareOptionInlineStory");
			isSharingStickyMediaSuccessful=commonFunctions.scrollToElementViewAndClick(webElement, 40, element);
			commonFunctions.waitForWindow(2,"new window");
			ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if(!currentURL.isEmpty()&& currentURL.contains(title)) {
				isSharingStickyMediaSuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSharingStickyMediaSuccessful;
	}

	public boolean checkSharingInlineStoryOnSocialMedia(WebElement webElement, String element, String title ) {
		boolean isSharingInlineStorySuccessful = false;
		try {
			isSharingInlineStorySuccessful=commonFunctions.scrollToElementViewAndClick(webElement, 20, element);
			commonFunctions.waitForWindow(2,"new window");
			ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if(!currentURL.isEmpty()&& currentURL.contains(title)) {
				isSharingInlineStorySuccessful = true;
			}
			commonFunctions.closeAllWindowsExceptMasterTabGen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSharingInlineStorySuccessful;
	}

	public boolean isNavigatedToUrlPage(String params[]) {
		boolean isNavigatedToUrlPage=false;
		try {
			commonFunctions.navigateToURL(globalVars.getURL()+params[0]);
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (currentURL.equals(globalVars.getURL()+params[0])) {
				isNavigatedToUrlPage = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return isNavigatedToUrlPage;
	}

	@Override
	public boolean checkSocialSharingWithWhatsappAndGmail() {
		return true;
	}

	@Override
	public boolean socialSharingInStoryPage(String params[]) {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.clickElement(homePage.openFullStory,20);
		commonFunctions.clickElementIfDisplayed(closeBtn,30,"closeBtn");
		boolean stickyHeaderSocialMediaTwitter=checkSharingStickyStoryOnSocialMedia(stickyHeaderTwitter,"stickyHeaderTwitter","twitter.com");
		boolean stickyHeaderSocialMediaFacebook = checkSharingStickyStoryOnSocialMedia(stickyHeaderFacebook,"stickyHeaderFacebook","facebook.com");
		boolean shareMediaTwitter=checkSharingInlineStoryOnSocialMedia(twitterShareOptionInlineStory, "twitterShareOptionInlineStory", "twitter.com");
		boolean shareMediaFacebook=checkSharingInlineStoryOnSocialMedia(facebookShareOptionInlineStory, "twitterShareOptionInlineStory", "facebook.com");
		return  stickyHeaderSocialMediaTwitter && stickyHeaderSocialMediaFacebook && shareMediaTwitter && shareMediaFacebook;

	}

	@Override
	public boolean checkSocialSharingIconsClickable() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.clickElementWithJS(explore,10,"clicked on explore");
		commonFunctions.clickElementWithJS(indiaNews,10,"clicked on india News");
		commonFunctions.waitForPageLoad();
		boolean firstStory = commonFunctions.clickElementWithJS(storyTitle, 20, "First Story Title");
		commonFunctions.scrollToBottom();
		commonFunctions.scrollToTop();
		commonFunctions.scrollUntilElementFound(firstStoryShareAllOptionsSocialSharing);
		commonFunctions.clickElementWithJS(firstStoryShareAllOptionsSocialSharing, 20, "firstStoryShareAllOptions");
		boolean isSharingIconTwitterClickable = commonFunctions.isElementDisplayed(twitterShareOption, 30,"Twitter Option");
		boolean isSharingIconFacebookClickable = commonFunctions.isElementDisplayed(facebookShareOption,30,"Facebook Option");
		boolean isSharingIconLinkedInClickable = commonFunctions.isElementDisplayed(linkedinShareOption,30,"LinkedIn Option");
		commonFunctions.dummyWait(10);
		boolean copyUrl = clickCopyIconAndCheckUrlCopied();

		return firstStory && copyUrl && isSharingIconTwitterClickable && isSharingIconFacebookClickable && isSharingIconLinkedInClickable;
	}

	@Override
	public boolean checkTwitterWhatsappDisplayInStoryPageBySearch() {
		return false;
	}

	@Override
	public boolean checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics() {
		return false;
	}

	public boolean clickCopyIconAndCheckUrlCopied() {
		boolean isCopyIconClickedAndUrlCopied = false;
		try {
			commonFunctions.isElementDisplayed(firstStoryShareAllOptionsSocialSharing, 20, "firstStoryShareAllOptions");
			isCopyIconClickedAndUrlCopied = commonFunctions.clickElementIfDisplayed(copyUrlToShareOption, 20,"copyUrlToShareAllOptions");
			String elementText = copyUrlToShareOption.getText();
			if (elementText.contains(globalVars.getProdUrl())) {
				isCopyIconClickedAndUrlCopied = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCopyIconClickedAndUrlCopied;
	}
}