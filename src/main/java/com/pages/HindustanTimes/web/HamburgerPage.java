
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamburgerPage extends CommonHamburgerPage {
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
	@FindBy(xpath = "//a[@href='/india-news']//em")
	private static WebElement indiaNewsSection;
	@FindBy(xpath = "//h1[text()='India News']")
	private static WebElement indiaNewsSectionHeader;

	@FindBy(xpath = "//span[@class='navIco']")
	private static WebElement exploreButton;

	@FindBy(xpath = "//div[@class='listPagination']")
	private static WebElement listPagination;

	@FindBy(xpath = "//div[@class='nav-sec']//a//em")
	private static List<WebElement> hamburgerMenuOptions;

	@FindBy(xpath = "(//a/em[text()='Entertainment'])[1]")
	private static WebElement entertainmentOption;
	@FindBy(xpath="//ul[contains(@class,'nav-expanded')]//li//a[@href]")
	private static List<WebElement> exploreHTList;

	@FindBy(xpath="//ul[contains(@class,'nav-expanded')]")
	private static WebElement exploreHT;

	public HamburgerPage() {
		globalVars = GlobalVars.getInstance();
		driver = globalVars.getWebDriver();
		PageFactory.initElements(driver, this);
		commonFunctions = CommonFunctionsWeb.getInstance();

		commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
		System.out.println("****************** Test started ******************");
		System.out.println("******************" + globalVars.getProjectName() + "******************");
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

	public boolean checkHamburgerMenuAllOptionDisplayed() {
		boolean isHamburgerMenuAllOptionsDisplayed = false;
		try {
			int menuNamesCount = hamburgerMenuOptions.size();
			for (int i = 0; i < menuNamesCount; i++) {
				String menuName = hamburgerMenuOptions.get(i).getText();
				if (!menuName.isEmpty()) {
					hamburgerMenuOptions.get(i).isDisplayed();
					commonFunctions.elementToTextDisplayed(menuName);
					isHamburgerMenuAllOptionsDisplayed = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utils.logStepInfo(true,"isHamburgerMenuAllOptionsDisplayed = "+isHamburgerMenuAllOptionsDisplayed);
		return isHamburgerMenuAllOptionsDisplayed;
	}

	public boolean clickOnEntertainmentSection() {
		boolean isClickOnEntertainmentSuccessful = false;
		try {
			commonFunctions.scrollUsingAction(entertainmentOption, "entertainmentOption");
			isClickOnEntertainmentSuccessful = commonFunctions.clickElement(entertainmentOption, 10, "entertainmentOption");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isClickOnEntertainmentSuccessful;
	}

	public boolean checkRedirectionToEntertainmentSection() {
		boolean isRedirectToEntertainmentSuccessful = false;
		try {
			String currentURL = commonFunctions.getCurrentURL("getCurrentURL Successful");
			if (currentURL.equals(Utils.getUrl() + "entertainment")) {
				isRedirectToEntertainmentSuccessful = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utils.logStepInfo(true,"isRedirectToEntertainmentSuccessful = "+isRedirectToEntertainmentSuccessful);
		return isRedirectToEntertainmentSuccessful;
	}

	@Override
	public boolean checkHamburgerElementsClickable() {
		commonFunctions.navigateToURL(globalVars.getURL());
		boolean clickOnExplorer = clickOnExplorerMenu();
		boolean checkHamburgerMenuOptions = checkHamburgerMenuAllOptionDisplayed();
		boolean clickEntertainmentSection = clickOnEntertainmentSection();
		boolean checkEntertainmentRedirection = checkRedirectionToEntertainmentSection();
		Utils.logStepInfo(true,"clickOnExplorer = "+clickOnExplorer);
		Utils.logStepInfo(true,"checkHamburgerMenuOptions = "+checkHamburgerMenuOptions);
		Utils.logStepInfo(true,"clickEntertainmentSection = "+clickEntertainmentSection);
		Utils.logStepInfo(true,"checkEntertainmentRedirection = "+checkEntertainmentRedirection);
		return clickOnExplorer && checkHamburgerMenuOptions && clickEntertainmentSection
				&& checkEntertainmentRedirection;
	}

	public boolean checkHamberburgerCases() {
		boolean explore = clickOnExplorerMenu();
		boolean alloption = checkHamburgerMenuAllOptionDisplayed();
		boolean entertainmentSection = clickOnEntertainmentSection();

		return explore && alloption && entertainmentSection;
	}

	@Override
	public boolean checkAnySectionPage() {
		boolean isSectionPageLoad=true;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.dummyWait(10);
		commonFunctions.clickElementWithJS(exploreButton, 15, "Hamburger Menu");
		commonFunctions.clickElement(indiaNewsSection, 15, "India News Section Menu");
		commonFunctions.isElementDisplayed(indiaNewsSectionHeader, 30, "India News Page Header");
		isSectionPageLoad=commonFunctions.checkElementText(indiaNewsSectionHeader, "INDIA NEWS", 15, "India News Page Header");
		return isSectionPageLoad;
	}

	@Override
	public boolean checkIndiaNewsPageScrollable() {
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.dummyWait(10);
		commonFunctions.clickElementWithJS(exploreButton, 40, "clicked on explore");
		commonFunctions.clickElementWithJS(indiaNewsSection, 10, "clicked on india News");
		commonFunctions.scrollToBottom();
		commonFunctions.dummyWait(5);
		boolean scrollIndiaNews = commonFunctions.isElementDisplayed(listPagination, 10, "Bottom of Page");
		return scrollIndiaNews;
	}

	@Override
	public boolean checkNavigationIndiaNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean breadcrumbDisplayedOtherThanHomePage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationPopularNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationCricketNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationEditorialNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationEntertainmentNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationCitiesNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationLatestNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean clickWorldNewsSectionOnHamburgerMenu() {
		return false;
	}

	@Override
	public boolean checkExploreHTOptionDisplayedOnHamburgerMenu() {
		boolean isCheckExploreHTOptionDisplayedOnHamburgerMenu=true;
		commonFunctions.navigateToURL(globalVars.getURL());
		commonFunctions.clickElementWithJS(exploreButton);
		commonFunctions.scrollToElement(exploreHT,"Explore HT options");
		isCheckExploreHTOptionDisplayedOnHamburgerMenu &= commonFunctions.isElementDisplayed(exploreHT,20,"Explore HT");
		isCheckExploreHTOptionDisplayedOnHamburgerMenu &= scrollToViewElementWithLinks(exploreHTList);
		return isCheckExploreHTOptionDisplayedOnHamburgerMenu;
	}

	@Override
	public boolean checkPopularSectionsDisplayed() {
		return false;
	}

	@Override
	public boolean checkSectionsDisplayed() {
		return false;
	}

	public boolean scrollToViewElementWithLinks(List<WebElement> elementList)
	{
		boolean isElementDisplayTrue = false;
		String text=null;
		for(WebElement ele: elementList)
		{
			text=commonFunctions.getElementText(ele,20);
			commonFunctions.scrollToElement(ele,text);
			if(ele.isDisplayed())
			{
				isElementDisplayTrue=true;
			}
			else
			{
				isElementDisplayTrue=false;
			}
		}
		return isElementDisplayTrue;
	}
	}


