package com.pages.Healthshots.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.Healthshots.generic.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage extends CommonHomePage {
	private static WebDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsWeb commonFunctions;

	@FindBy(xpath = "(//ul[@class='primary']/li/a)[1]")
	private static WebElement category;
	@FindBy(xpath = "(//h2[@class='storyHeading-dual']/a)[1]")
	private static WebElement stories;
	@FindBy(xpath = "//div//span[@class='errorThumb']/img")
	private static WebElement error;
	@FindBy(xpath = "//ul[@class='storyShare']/li[1]/a")
	private static WebElement ShareButton;
	@FindBy(xpath = "/html/body/div[8]/section/div[1]/div[3]/ul/li[1]/ul/li[1]")
	private static WebElement fbShareIcon;
	@FindBy(xpath = "//input[@id='email']")
	private static WebElement fbUserEmailId;
	@FindBy(xpath = "//input[@id='pass']")
	private static WebElement fbUSerPassword;
	@FindBy(xpath = "//input[@name='login']")
	private static WebElement fbLoginButton;
	@FindBy(xpath = "//span[text() = \"Post to Facebook\"]")
	private static WebElement fbShareButton;
	@FindBy(xpath = "/html/body/div[8]/section/div[1]/div[3]/ul/li[1]/ul/li[2]")
	private static WebElement twitterShareIcon;
	@FindBy(xpath = "//input[@autocapitalize='none'and@type='text']")
	private static WebElement twitterEmailId;
	@FindBy(xpath = "//input[@autocapitalize='none'and@type='password']")
	private static WebElement twitterPassword;
	@FindBy(xpath = "(//div[@role='button'])[2]")
	private static WebElement twitterLoginButton;
	@FindBy(xpath = "//div[@role='button'and@data-testid='tweetButton']")
	private static WebElement tweetButton;
	@FindBy(xpath = "(//div[@role='alert']//div)[5]")
	private static WebElement twitterError;

	@FindBy(xpath = "//button[@id='optInText']")
	private static WebElement allow;

	public HomePage(){
        globalVars= GlobalVars.getInstance();
        driver =globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions= CommonFunctionsWeb.getInstance();
		long t1=System.currentTimeMillis();
		commonFunctions.clickElementIfDisplayed(allow, 10,"Allow Notifications");
		long t2=System.currentTimeMillis();
		System.out.println("Cookie time for "+globalVars.getProjectName()+" >> "+(t2-t1));
		System.out.println("****************** Test started for :"+globalVars.getProjectName());

    }


	@Override
	public boolean checkFacebookSharingFromLatestStory(String email, String password) {
		boolean SocialMediaSharingStatus;
		boolean isFbShareSuccessful=false;
		boolean isElementClickable= false;
		boolean isElementDisplayed= false;

		try{
			commonFunctions.deleteCookiesAndNavigateToHomePage();
			isElementDisplayed = commonFunctions.isElementDisplayed(category, 10,"Category Name");
			isElementClickable = commonFunctions.isElementClickable(category, 10,"Category Name");
			commonFunctions.clickElementWithFluentWait(category,20, " Category Name");
			commonFunctions.waitForPageToLoad();
			isElementDisplayed = commonFunctions.isElementDisplayed(stories, 10,"Story Name");
			isElementClickable = commonFunctions.isElementClickable(stories, 10,"Story Name");
			commonFunctions.clickElementWithFluentWait(stories,5, " Story Name");
			commonFunctions.waitForPageToLoad();
			isElementDisplayed = commonFunctions.isElementDisplayed(ShareButton, 10,"Share Icon");
			isElementClickable = commonFunctions.isElementClickable(ShareButton, 10,"Share Icon");
			commonFunctions.clickElement(ShareButton, 10, "Share Icon");
			isElementDisplayed = commonFunctions.isElementDisplayed(fbShareIcon, 10,"Fb Share Icon");
			isElementClickable = commonFunctions.isElementClickable(fbShareIcon, 10,"Fb Share Icon");
			commonFunctions.clickElement(fbShareIcon, 10, "FB Share Icon");
			ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			commonFunctions.sendKeyBoolean(fbUserEmailId, email, 10, "fbUserEmailId");
			commonFunctions.sendKeyBoolean(fbUSerPassword, password, 10, "fbUSerPassword");
			commonFunctions.clickElement(fbLoginButton, 10, "fbLoginButton ");
			isFbShareSuccessful=commonFunctions.clickElement(fbShareButton, 10, "fbShareButton");
			commonFunctions.waitForPageToLoad();
			commonFunctions.switchToWindow(windowsList.get(0));
			commonFunctions.deleteCookiesAndNavigateToHomePage();

		} catch (Exception ex) {
			Utils.logStepInfo(ex.getMessage());
		}

		return isElementClickable && isElementDisplayed && isFbShareSuccessful;
	}

	@Override
	public boolean checkTwitterSharingFromLatestStory(String email, String password ) {
		boolean SocialMediaSharingStatus;
		boolean isTweetShareSuccessful=false;
		boolean isElementClickable= false;
		boolean isElementDisplayed= false;
		boolean isURLCorrectStatus= false;
		boolean isPageBrokenStatus= false;

		try{
			commonFunctions.deleteCookiesAndNavigateToHomePage();
			commonFunctions.deleteCookiesAndNavigateToHomePage();
			isElementDisplayed = commonFunctions.isElementDisplayed(category, 10,"Category Name");
			isElementClickable = commonFunctions.isElementClickable(category, 10,"Category Name");
			commonFunctions.clickElementWithFluentWait(category,10, " Category Name");
			commonFunctions.waitForPageToLoad();
			isElementDisplayed = commonFunctions.isElementDisplayed(stories, 10,"Story Name");
			isElementClickable = commonFunctions.isElementClickable(stories, 10,"Story Name");
			commonFunctions.clickElementWithFluentWait(stories,5, " Story Name");
			commonFunctions.waitForPageToLoad();
			isElementDisplayed = commonFunctions.isElementDisplayed(ShareButton, 10,"Share Icon");
			isElementClickable = commonFunctions.isElementClickable(ShareButton, 10,"Share Icon");
			commonFunctions.clickElement(ShareButton, 10, "Share Icon");
			commonFunctions.clickElement(twitterShareIcon, 10, "Twitter Share Icon");
			ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			commonFunctions.sendKeyBoolean(twitterEmailId, email, 10, "Twitter EmailId");
			commonFunctions.sendKeyBoolean(twitterPassword, password, 10, "Twitter Password");
			commonFunctions.clickElement(twitterLoginButton, 10, "Twitter Login Button ");
			isTweetShareSuccessful=commonFunctions.clickElement(tweetButton, 10, "Tweet Button");
			commonFunctions.closeAllWindowsExceptMasterTab();
			commonFunctions.deleteCookiesAndNavigateToHomePage();

		} catch (Exception ex) {
			Utils.logStepInfo(ex.getMessage());
		}
		return isElementClickable && isElementDisplayed && isURLCorrectStatus && isPageBrokenStatus && isTweetShareSuccessful;

	}

}
