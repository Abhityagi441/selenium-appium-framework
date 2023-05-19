package com.pages.SmartCast.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.SmartCast.generic.CommonHomePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonHomePage {
	private static WebDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsWeb commonFunctions;

	@FindBy(className="logo")
	private static WebElement smartCastLogo;
	@FindBy(xpath="//div/small[@class='liner2']")
	private static WebElement hamburgerLinesOpen;
	@FindBy(xpath="//div/small[@class='liner2']")
	private static WebElement hamburgerLinesClosed;
	@FindBy(xpath = "//nav[@class='primaryMenu']/ul/li/a")
	private static List<WebElement> hamburgerTopmost;
	@FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[1]")
	private static WebElement hamburgerHome;
	@FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[2]")
	private static WebElement hamburgerTrending;
	@FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[3]")
	private static WebElement hamburgerPublishers;
	@FindBy(xpath = "(//nav[@class='primaryMenu']/ul/li/a)[4]")
	private static WebElement hamburgerCategories;
	@FindBy(xpath = "//ul[@class='childMenu']/li/a")
	private static List<WebElement> hamburgerCategoriesList;
	@FindBy(xpath = "//div[@class='myListMenu']/p/a")
	private static WebElement hamburgerMyListMenu;
	@FindBy(xpath = "//nav[contains(@class, 'primaryMenu smart-menu')]/ul/li/a")
	private static List<WebElement> hamburgerBottom;
	@FindBy(xpath = "//li[@class='partner-menu ']/a")
	private static WebElement hamburgerPartner;
	@FindBy(xpath = "//li[@class='aboutUsLink ']/a")
	private static WebElement hamburgerAboutUs;
	@FindBy(xpath = "//div//span[@class='errorThumb']/img")
	private static WebElement error;
	@FindBy(xpath = "(//div[contains(@class, 'owl-item active')]//a/img)[1]")
	private static WebElement latestPodcastImage;
	@FindBy(xpath = "(//div[contains(@class, 'owl-item active')]//a)[1]")
	private static WebElement latestPodcastImageTitle;
	@FindBy(css = "div.large-toggle-btn>i")
	private static WebElement videoPauseButton;
	@FindBy(xpath = "(//div[@class='controls-box']/i)[2]")
	private static WebElement nextTrackButton;
	@FindBy(xpath = "(//div[@class='controls-box']/i)[1]")
	private static WebElement previousTrackButton;
	@FindBy(xpath = "(//a[@class='sharefb'])[1]")
	private static WebElement fbShareIcon;
	@FindBy(xpath = "//input[@id='email']")
	private static WebElement fbUserEmailId;
	@FindBy(xpath = "//input[@id='pass']")
	private static WebElement fbUSerPassword;
	@FindBy(xpath = "//input[@name='login']")
	private static WebElement fbLoginButton;
	@FindBy(xpath = "(//button[@type='submit'])[2]/span")
	private static WebElement fbShareButton;
	@FindBy(xpath = "(//a[@class='sharetw'])[1]")
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
	@FindBy(id = "userName")
	private static WebElement userNameLabelAfterLogin;
	@FindBy(id = "signInBtn")
	private static WebElement singInButton;
	@FindBy(xpath = "//a[@id='addRemoveList']")
	private static WebElement bookmarkIcon;
	@FindBy(xpath = "//h1[@class='blockHeading']")
	private static WebElement MyListHeading;
	@FindBy(xpath = "(//span[@class='addList'])[1]")
	private static WebElement bookmarkedElement;
	@FindBy(xpath = "//input[@id='phoneEmail']")
	private static WebElement emailTextBoxMainSignInPage;
	@FindBy(id = "btSubmit")
	private static WebElement continueButtonSignInPage;
	@FindBy(id = "upass")
	private static WebElement passwordTextBoxMainSignInPage;
	@FindBy(id = "btnLogin")
	private static WebElement signInButtonMainSignInPage;
	@FindBy(xpath = "//div[@class='myListPage']/div/small/a")
	private static WebElement explorePodcast;
	@FindBy(xpath = "//div[@class='shareTools']/div/span")
	private static List<WebElement>  bookmarkedElementToClear;
	@FindBy(xpath = "//h2[@class='blockHeading']")
	private static List<WebElement>  homeSectionTrays;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;
	@FindBy(xpath = "(//h3[@class='heading']/a)[1]")
	private static WebElement podcastImage;
	@FindBy(xpath = "//div[@class='podcastCurrentEpisode']/img")
	private static WebElement podcastInfoImage;
	@FindBy(xpath = "//h1[@class='podcastshow']")
	private static WebElement podcastInfoHeadingText;
    @FindBy(xpath = "//h3[@class='blockHeading']")
    private static List<WebElement>  podcastInfoTrays;
	@FindBy(xpath = "//a[@class='playlist-track']")
	private static List<WebElement>  podcastInfoEpisodesList;
	@FindBy(xpath = "//input[@id='news_email']")
	private static WebElement sharedEmail;
	@FindBy(xpath = "//input[@id='subscribe']")
	private static WebElement sharedEmailSubscribeButton;
	@FindBy(xpath = "//span[@class='closeScroll']")
	private static WebElement sharedEmailSuccess;
    @FindBy(xpath = "//div[@class='myListMenu']/nav/ul/li/a/small")
    private static WebElement bookmarkedElementInMyList;



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
	public String getSmartCastTitle() {
		return commonFunctions.getTitle();
	}

	@Override
	public boolean clickSmartCastLogo() {
		return commonFunctions.clickElementIfDisplayed(smartCastLogo ,5, "smartCast logo");
	}

	@Override
	public boolean checkHamburger() {
		boolean checkHamburgerStatus;
		commonFunctions.navigateToHomePageSC();
		commonFunctions.isElementDisplayed(hamburgerLinesOpen, 10, "Hamburger Lines");
		boolean isHamburgerCategoriesListNotBlank = commonFunctions.checkHamburgerAllListsNotBlank(hamburgerCategoriesList);
		boolean isHamburgerTopmostListNotBlank = commonFunctions.checkHamburgerAllListsNotBlank(hamburgerTopmost);
		boolean isHamburgerBottomListNotBlank = commonFunctions.checkHamburgerAllListsNotBlank(hamburgerBottom);
		boolean checkAllTopMostLinksInHamburgerStatus = commonFunctions.checkAllHamburgerElements(hamburgerTopmost,error);
		boolean checkAllCategoriesLinksInHamburgerStatus = commonFunctions.checkAllHamburgerElements(hamburgerCategoriesList,error);
		boolean checkAllBottomLinksInHamburgerStatus = commonFunctions.checkAllHamburgerElements(hamburgerBottom,error);
		boolean isHamburgerOpensAndCloseStatus = commonFunctions.checkHamburgerOpensAndClose(hamburgerLinesOpen,hamburgerLinesClosed);
		if (isHamburgerCategoriesListNotBlank && checkAllCategoriesLinksInHamburgerStatus && isHamburgerTopmostListNotBlank && isHamburgerBottomListNotBlank && checkAllTopMostLinksInHamburgerStatus && checkAllBottomLinksInHamburgerStatus && isHamburgerOpensAndCloseStatus) {
			checkHamburgerStatus = true;
		} else {
			checkHamburgerStatus = false;
		}
		return checkHamburgerStatus;
	}

	@Override
	public boolean checkFacebookSharingFromLatestPodcast(String email, String password) {
		boolean SocialMediaSharingStatus;
		boolean isFbShareSuccessful=false;
		boolean isElementClickable= false;
		boolean isElementDisplayed= false;
		boolean isURLCorrectStatus= false;
		boolean isPageBrokenStatus= false;

		try{
			commonFunctions.deleteCookiesAndNavigateToHomePage();
			String hrefValue =   commonFunctions.getElementText(latestPodcastImage);
			isElementDisplayed = commonFunctions.isElementDisplayed(latestPodcastImage, 60,"latest Podcast Image");
			isElementClickable = commonFunctions.isElementClickable(latestPodcastImage, 60,"latest Podcast Image");
			commonFunctions.clickElementWithJS(latestPodcastImage,5, " latest Podcast Image");
			isURLCorrectStatus = commonFunctions.checkPageURLSC(hrefValue, 60, "");
			isPageBrokenStatus = commonFunctions.checkElementNotPresent(error);
			commonFunctions.clickElement(fbShareIcon, 10, "FB Share Icon");
			ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
			commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
			commonFunctions.sendKeyBoolean(fbUserEmailId, email, 10, "fbUserEmailId");
			commonFunctions.sendKeyBoolean(fbUSerPassword, password, 10, "fbUSerPassword");
			commonFunctions.clickElement(fbLoginButton, 10, "fbLoginButton ");
			isFbShareSuccessful=commonFunctions.clickElement(fbShareButton, 10, "fbShareButton");
			commonFunctions.switchToWindow(windowsList.get(0));
			commonFunctions.deleteCookiesAndNavigateToHomePage();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		if (isElementClickable && isElementDisplayed && isURLCorrectStatus && isPageBrokenStatus && isFbShareSuccessful) {
			SocialMediaSharingStatus = true;
		} else {
			SocialMediaSharingStatus = false;
		}
		return SocialMediaSharingStatus;
	}

	@Override
	public boolean checkTwitterSharingFromLatestPodcast(String email, String password ) {
		boolean SocialMediaSharingStatus;
		boolean isTweetShareSuccessful=false;
		boolean isElementClickable= false;
		boolean isElementDisplayed= false;
		boolean isURLCorrectStatus= false;
		boolean isPageBrokenStatus= false;

		try{
			commonFunctions.deleteCookiesAndNavigateToHomePage();
			String hrefValue =   commonFunctions.getElementText(latestPodcastImage);
			isElementDisplayed = commonFunctions.isElementDisplayed(latestPodcastImage, 60,"latest Podcast Image");
			isElementClickable = commonFunctions.isElementClickable(latestPodcastImage, 60,"latest Podcast Image");
			commonFunctions.clickElementWithJS(latestPodcastImage,5, " latest Podcast Image");
			isURLCorrectStatus = commonFunctions.checkPageURLSC(hrefValue, 60, "");
			isPageBrokenStatus = commonFunctions.checkElementNotPresent(error);
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
			System.out.println(ex.getMessage());
		}
		if (isElementClickable && isElementDisplayed && isURLCorrectStatus && isPageBrokenStatus && isTweetShareSuccessful) {
			SocialMediaSharingStatus = true;
		} else {
			SocialMediaSharingStatus = false;
		}
		return SocialMediaSharingStatus;
    }

	@Override
	public boolean bookmarkStoryWithLoggedInUser(String propertyName) {
		boolean bookmarkStoryLoggedInUserStatus;
		boolean checkBookMarkIconIsPresentStatus=false;
		boolean checkBookmarkedStoryIdIsAvailableInMyListStatus=false;
		boolean isElementClickable= false;
		boolean isElementDisplayed= false;
		try {
			isElementDisplayed = commonFunctions.isElementDisplayed(latestPodcastImage, 60,"latest Podcast Image");
			isElementClickable = commonFunctions.isElementClickable(latestPodcastImage, 60,"latest Podcast Image");
			commonFunctions.clickElementWithFluentWait(latestPodcastImage,5, " latest Podcast Image");
			commonFunctions.waitForPageToLoad();
			commonFunctions.isElementDisplayed(bookmarkIcon, 60, " BookMark Icon");
			commonFunctions.isElementClickable(bookmarkIcon, 60, " BookMark Icon");
			checkBookMarkIconIsPresentStatus = checkBookMarkIconIsPresent();
			String bookmarkStoryId = commonFunctions.getProperty(bookmarkIcon, propertyName);
			System.out.println("bookmarkStoryId Found: "+ bookmarkStoryId);
			commonFunctions.isElementDisplayedIgnoringStaleElement(bookmarkIcon,10," BookMark Icon");
			commonFunctions.clickElementWithFluentWait(bookmarkIcon, 60, " BookMark Icon");
			commonFunctions.waitForPageToLoad();
			commonFunctions.isElementDisplayed(bookmarkedElementInMyList, 60, "recently BookMarked element");
			commonFunctions.isElementDisplayedIgnoringStaleElement(hamburgerMyListMenu,10," hamburgerMyListMenu Button");
			commonFunctions.isElementClickable(hamburgerMyListMenu, 60, " hamburgerMyListMenu Button");
			commonFunctions.clickElementWithFluentWait(hamburgerMyListMenu, 10, " hamburgerMyListMenu Button");
			commonFunctions.isElementDisplayed(MyListHeading, 60, " My List Heading");
			checkBookmarkedStoryIdIsAvailableInMyListStatus = checkBookmarkedStoryIdInMyListPage(bookmarkStoryId, true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		if (checkBookMarkIconIsPresentStatus && checkBookmarkedStoryIdIsAvailableInMyListStatus && isElementDisplayed && isElementClickable) {
			bookmarkStoryLoggedInUserStatus = true;
		} else {
			bookmarkStoryLoggedInUserStatus = false;
		}
		return bookmarkStoryLoggedInUserStatus;

	}

	@Override
	public boolean clearBookmarkStoryWithLoggedInUser(String propertyName) {
		boolean clearBookmarkedStoryIdInMyListPageStatus;
		boolean isElementCleared = false;

		try {
			for (WebElement bookmarkedIcon : bookmarkedElementToClear){
				String bookmarkStoryIdInMyList = commonFunctions.getProperty(bookmarkedIcon, propertyName);
				Utils.logStepInfo(true,  bookmarkStoryIdInMyList+ " Is BookMark Id Which is available in MyList...Now clearing it ");
				commonFunctions.isElementDisplayed(bookmarkedIcon, 60, "bookmark of Element");
				commonFunctions.isElementClickable(bookmarkedIcon, 60, "bookmark of Element");
				commonFunctions.isElementDisplayedIgnoringStaleElement(bookmarkedIcon,60,"bookmark of Element To be Cleared");
				isElementCleared=commonFunctions.clickElementWithFluentWait(bookmarkedIcon,60," bookmark of Element Cleared");
				commonFunctions.waitForPageToLoad();
				commonFunctions.deleteCookiesAndNavigateToHomePage();

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		if (isElementCleared ) {
			clearBookmarkedStoryIdInMyListPageStatus = true;
		} else {
			clearBookmarkedStoryIdInMyListPageStatus = false;
		}
		return clearBookmarkedStoryIdInMyListPageStatus;
	}

	public boolean checkBookmarkedStoryIdInMyListPage(String bookmarkStoryId, boolean isAvailable) {
		boolean checkBookmarkedStoryIdInMyListPageStatus = false;
		String bookmarkStoryIdInMyList = commonFunctions.getProperty(bookmarkedElement, "data-podid");
		if (isAvailable) {
			if (bookmarkStoryIdInMyList.contains(bookmarkStoryId)) {
				Utils.logStepInfo(true, "BookMarked Story Id is available in MyList");
				checkBookmarkedStoryIdInMyListPageStatus = true;
			} else {
				Utils.logStepInfo(false, "BookMarked Story Id is Not available in MyList");
				checkBookmarkedStoryIdInMyListPageStatus = false;
			}
		}
		return checkBookmarkedStoryIdInMyListPageStatus;
	}

	public boolean checkBookMarkIconIsPresent() {
		boolean checkBookMarkIconIsPresentStatus;
		String classProperty = commonFunctions.getProperty(bookmarkIcon, "class");
		if (!classProperty.contains("addRemoveList")) {
			commonFunctions.clickElement(bookmarkIcon, 60, "BookMark Icon");
			classProperty = commonFunctions.getProperty(bookmarkIcon, "class");
		}
		if (classProperty.contains("addRemoveList")) {
			Utils.logStepInfo(true, "Bookmark Icon class property contains addRemoveList");
			checkBookMarkIconIsPresentStatus = true;
		} else {
			Utils.logStepInfo(false, "Bookmark Icon class property not contains addRemoveList");
			checkBookMarkIconIsPresentStatus = false;
		}
		return checkBookMarkIconIsPresentStatus;
	}

	@Override
	public boolean checkHomeSectionTrays() {
		boolean checkHomeSectionTraysStatus;
		boolean isTrayDisplayed= false;
		try{
			commonFunctions.navigateToHomePageSC();
			isTrayDisplayed=commonFunctions.checkNumberOfTraysInPage(homeSectionTrays,error);
	     } catch (Exception e) {
		   System.out.println(e.getMessage());
	     }
		if (isTrayDisplayed) {
			checkHomeSectionTraysStatus = true;
		} else {
			checkHomeSectionTraysStatus = false;
		}
		return checkHomeSectionTraysStatus;
	}

	@Override
	public boolean checkPodcastPlayerFunctions() {
		boolean checkPodcastFunctionsStatus;
		boolean checkPodcastPlayFunctionalityStatus=false;
		boolean checkPodcastPauseButtonFunctionalityStatus=false;
		boolean checkPodcastNextTrackButtonFunctionalityStatus=false;
		boolean checkPodcastPreviousTrackButtonFunctionalityStatus=false;
		try{
			checkPodcastPlayFunctionalityStatus = checkPodcastPlayFunctionality();
			checkPodcastPauseButtonFunctionalityStatus= commonFunctions.checkPodcastButtonsFunctionality(videoPauseButton,"Video Pause Button");
			checkPodcastNextTrackButtonFunctionalityStatus= commonFunctions.checkPodcastButtonsFunctionality(nextTrackButton,"Next Track Button");
			checkPodcastPreviousTrackButtonFunctionalityStatus= commonFunctions.checkPodcastButtonsFunctionality(previousTrackButton,"Previous Track Button");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (checkPodcastPlayFunctionalityStatus && checkPodcastPauseButtonFunctionalityStatus && checkPodcastNextTrackButtonFunctionalityStatus && checkPodcastPreviousTrackButtonFunctionalityStatus) {
			checkPodcastFunctionsStatus = true;
		} else {
			checkPodcastFunctionsStatus = false;
		}
		return checkPodcastFunctionsStatus;
	}

	public boolean checkPodcastPlayFunctionality(){
		boolean checkPodcastPlayFunctionalityStatus;
		boolean isPodcastAutoPlayed=false;
		boolean isElementClickable= false;
		boolean isURLCorrectStatus= false;
		String hrefValue;
		try{
			hrefValue =  commonFunctions.getElementText(latestPodcastImage);
			isElementClickable = commonFunctions.isElementClickable(latestPodcastImage, 60,"latest Podcast Image");
			commonFunctions.clickElementWithJS(latestPodcastImage,5, " latest Podcast Image");
			isURLCorrectStatus = commonFunctions.checkPageURLSC(hrefValue, 60, "Podcast Url");
			isPodcastAutoPlayed = commonFunctions.isElementClickable(videoPauseButton, 60,"video is Playing");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (isPodcastAutoPlayed && isElementClickable && isURLCorrectStatus) {
			checkPodcastPlayFunctionalityStatus = true;
		} else {
			checkPodcastPlayFunctionalityStatus = false;
		}
		return checkPodcastPlayFunctionalityStatus;
	}

	@Override
	public boolean checkPodcastInformation(String propertyName) {
		boolean checkPodcastInformationStatus;
		boolean isURLCorrectStatus= false;
		String hrefValue;
		String expectedHeading= "";
		String actualHeading = "";
		try{
			commonFunctions.navigateToHomePageSC();
			hrefValue =  commonFunctions.getElementText(latestPodcastImage);
			commonFunctions.isElementClickable(latestPodcastImage, 60,"latest Podcast Image");
			expectedHeading=commonFunctions.getProperty(latestPodcastImageTitle,propertyName);
			commonFunctions.clickElementWithJS(latestPodcastImage,5, " latest Podcast Image");
			isURLCorrectStatus = commonFunctions.checkPageURLSC(hrefValue, 60, "Podcast");
			commonFunctions.isElementDisplayed(podcastInfoImage,30,"Podcast Information Page Image");
			commonFunctions.isElementDisplayed(podcastInfoHeadingText,30,"Podcast Heading");
			actualHeading=commonFunctions.getElementText(podcastInfoHeadingText,10);
			commonFunctions.checkNumberOfTraysInPage(podcastInfoTrays,error);
			commonFunctions.getElementListText(podcastInfoEpisodesList,30);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (isURLCorrectStatus && expectedHeading.equals(actualHeading)) {
			checkPodcastInformationStatus = true;
		} else {
			checkPodcastInformationStatus = false;
		}
		return checkPodcastInformationStatus;
	}

	@Override
	public boolean checkShareEmailFunctionality() {
		boolean checkShareEmailFunctionalityStatus;
		boolean isURLCorrectStatus= false;
		String hrefValue;
		try{
			commonFunctions.navigateToHomePageSC();
			hrefValue=commonFunctions.getElementText(latestPodcastImage);
			commonFunctions.isElementClickable(latestPodcastImage, 60,"latest Podcast Image");
			commonFunctions.clickElementWithJS(latestPodcastImage,5, " latest Podcast Image");
			isURLCorrectStatus=commonFunctions.checkPageURLSC(hrefValue, 60, "Podcast Url");
			commonFunctions.waitForPageToLoad();
			commonFunctions.isElementDisplayed(sharedEmail,30,"Email Text box");
			commonFunctions.sendKeyWithRandomEmail(sharedEmail,10);
			commonFunctions.isElementDisplayed(sharedEmailSubscribeButton,30,"Email Subscribe button");
			commonFunctions.clickElementWithJS(sharedEmailSubscribeButton,30,"Email Subscribe button");
			commonFunctions.isElementDisplayed(sharedEmailSuccess,30,"Email shared success confirmation button");
			commonFunctions.clickElementWithJS(sharedEmailSuccess,30,"Email shared success confirmation button");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (isURLCorrectStatus) {
			checkShareEmailFunctionalityStatus = true;
		} else {
			checkShareEmailFunctionalityStatus = false;
		}
		return checkShareEmailFunctionalityStatus;
	}
}

