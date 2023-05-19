
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonListingPage;
import com.utils.GlobalVars;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListingPage extends CommonListingPage {
	private static WebDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsWeb commonFunctions;

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

	@FindBy(xpath = "//div[@class='btnExplore']/strong")
	private static WebElement exploreButton;

	@FindBy(xpath = "(//section[@id='sidenav']//a)[6]")
	private static WebElement entertainmentOption;

	@FindBy(xpath = "(//section[@id='sidenav']//a)[4]")
	private static WebElement indiaNewsHamburgerMenu;

	@FindBy(xpath = "(//div[@class='listPagination']//a)[1]")
	private static WebElement clickAtNumber2Page;

	@FindBy(xpath = "//div[@class='listPagination']")
	private static WebElement scrollDownToListPagination;

	public ListingPage() {
		globalVars = GlobalVars.getInstance();
		driver = globalVars.getWebDriver();
		PageFactory.initElements(driver, this);
		commonFunctions = CommonFunctionsWeb.getInstance();

		commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
		System.out.println("****************** Test started ******************");
		System.out.println("******************" + globalVars.getProjectName() + "******************");
	}

	@Override
	public boolean clickOnExplorerMenu() {
		boolean isExplorermenuClickSuccessful = false;
		try {
			isExplorermenuClickSuccessful = commonFunctions.clickElementWithJS(exploreButton, 20, "exploreButton");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isExplorermenuClickSuccessful;
	}

	@Override
	public boolean checkViewMoreButton() {

		boolean isStepTrue = false;

		try {

			isStepTrue = clickOnExplorerMenu();
			isStepTrue = clickOnEntertainmentSection();
			isStepTrue = checkRedirectionToEntertainmentSection();
			isStepTrue = scrollDownToBottomOfTheEntertainmentPage();
			isStepTrue = clickAtNumber2PaginationOption();
			isStepTrue = checkRedirectionToTopOfThePage2OfSameSection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isStepTrue;
	}

	@Override
	public boolean scrollDownToBottomOfTheWorldNewsPage() {
		return false;
	}

	public boolean clickOnEntertainmentSection() {
		boolean isClickOnEntertainmentSuccessful = false;
		try {
			if (!commonFunctions.isElementDisplayed(entertainmentOption)) {
				commonFunctions.scrollUsingAction(entertainmentOption, "entertainmentOption");
			}
			isClickOnEntertainmentSuccessful = commonFunctions.clickElementWithJS(entertainmentOption, 20,
					"entertainmentOption");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isClickOnEntertainmentSuccessful;
	}

	@Override
	public boolean checkRedirectionToEntertainmentSection() {
		boolean isRedirectToEntertainmentSuccessful = false;
		try {
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (currentURL.equals(globalVars.getProdUrl() + "entertainment")) {
				isRedirectToEntertainmentSuccessful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isRedirectToEntertainmentSuccessful;
	}

	@Override
	public boolean scrollDownToBottomOfTheEntertainmentPage() {
		boolean isScrollDownToBottomOfPage = false;
		try {
			commonFunctions.scrollToBottom();
			//commonFunctions.scrollToElementView(scrollDownToListPagination, 20, "scrollDownToListPagination");
			isScrollDownToBottomOfPage = commonFunctions.scrollToElementView(scrollDownToListPagination, 20,
					"scrollDownToListPagination");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isScrollDownToBottomOfPage;
	}

	@Override
	public boolean checkViewMoreButtonOnListingPages() {
		return false;
	}

	@Override
	public boolean clickAtNumber2PaginationOption() {
		boolean isClickOnPage2paginationSuccessful = false;
		try {
			commonFunctions.scrollDown();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", clickAtNumber2Page);
			commonFunctions.clickElementWithJS(clickAtNumber2Page, 10, "Page 2");
			isClickOnPage2paginationSuccessful = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isClickOnPage2paginationSuccessful;
	}

	@Override
	public boolean checkRedirectionToTopOfThePage2OfSameSection() {
		boolean isRedirectionToPage2Successful = false;
		try {
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
			if (currentURL.equals(globalVars.getProdUrl() + "entertainment/page-2")) {
				isRedirectionToPage2Successful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isRedirectionToPage2Successful;
	}

	@Override
	public boolean checkPaginationWorkingOnListingPages() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean clickExploreMenu = clickOnExplorerMenu();
		boolean checkEntertainmentSection = clickOnEntertainmentSection();
		commonFunctions.dummyWait(5);
		boolean checkRedirection = checkRedirectionToEntertainmentSection();
		commonFunctions.dummyWait(5);
		boolean scrollBottomOfPage = scrollDownToBottomOfTheEntertainmentPage();
		commonFunctions.dummyWait(5);
		boolean clickOnPage2 = clickAtNumber2PaginationOption();
		commonFunctions.dummyWait(5);
		boolean checkRedirectionOfPage2 = checkRedirectionToTopOfThePage2OfSameSection();

		return clickExploreMenu && checkEntertainmentSection && checkRedirection && scrollBottomOfPage && clickOnPage2
				&& checkRedirectionOfPage2;
	}

}
