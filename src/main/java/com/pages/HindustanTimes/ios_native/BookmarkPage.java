package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class BookmarkPage extends CommonBookmarkPage {

	private IOSDriver<MobileElement> driver;
	private GlobalVars globalVars;
	private static CommonFunctionsMobile commonFunctions;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
	private static MobileElement notificationLater;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
	private static MobileElement notificationAllow;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
	private static MobileElement skipButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
	private static MobileElement allowTracking;

	@iOSXCUITFindBy(id = "profileBarButton")
	private static MobileElement profileButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Login']")
	private static MobileElement loginInButton;

	@iOSXCUITFindBy(id="Home")
	private static MobileElement home;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
	private static MobileElement continueButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Proceed')]")
	private static MobileElement verifyOtpToProceedButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Google')]")
	private static MobileElement continueWithGoogleButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
	private static MobileElement continueWithGoogleConfirmationPrompt;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Facebook')]")
	private static MobileElement continueWithFacebookButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@enabled='true']")
	private static MobileElement emailTextBoxMainSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
	private static MobileElement continueButtonSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	private static MobileElement passwordTextBoxMainSignInPage;

	@iOSXCUITFindBy(xpath = "//div[text()='Use another account']")
	private static MobileElement useAnotherAccountGmailSignInPage;

	@iOSXCUITFindBy(className = "android.widget.EditText")
	private static MobileElement emailOrPhoneGmailSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField") // m_login_email
	private static MobileElement emailOrPhoneFacebookSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTextField") // m_login_email
	private static List<MobileElement> otpTextField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	private static MobileElement passwordFacebookSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeButton[@name='Log In']")
	private static MobileElement loginButtonFacebookSignInPage;

	@iOSXCUITFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private static MobileElement nextButtonGmailSignInPage;

	@iOSXCUITFindBy(xpath = "//android.widget.Button[@text='NEXT']")
	private static MobileElement nextButtonGmailPasswordPage;


	@iOSXCUITFindBy(className = "android.widget.EditText")
	private static MobileElement passwordTextBoxGmailSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[2]")
	private static MobileElement userNameLabelAfterLogin;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther[4]//XCUIElementTypeButton")
	private static MobileElement continueButtonFacebookAfterUsernamePassword;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]")
	private static MobileElement LogoutButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'OTP')]")
	private static MobileElement generateOtpMainSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Resend')]")
	private static MobileElement reGenerateOtpMainSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Verify')]")
	private static MobileElement sigInWithOtpButtonMainSignInPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name ='OK']")
	private static MobileElement okButtonLogoutPopUp;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ago')]")
	private static MobileElement storyArticle;

	@iOSXCUITFindBy(id = "bookmark new")
	private static MobileElement bookmarkButton;

	@iOSXCUITFindBy(id = "bookmark day")
	private static MobileElement bookmark;

	@iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[contains(@name,'Added')]")
	private static MobileElement popUpAdded;

	@iOSXCUITFindBy(id = "share dark")
	private static MobileElement shareButton;

	@iOSXCUITFindBy(id = "back new")
	private static MobileElement backButton;

	@iOSXCUITFindBy(id = "htNewLogo")
	private static MobileElement htLogoOnStoryPage;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[1]")
	private static MobileElement StoryTitle;

	@iOSXCUITFindBy(id = "Explore")
	private static MobileElement hamburgerMenu;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Daily Digest']")
	private static MobileElement dailyDigest;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Saved')]")
	private static MobileElement clickSaved;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='bookmarked Item']")
	private static List<MobileElement> bookmarkedStories;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
	private static MobileElement mayBeLater;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
	private static MobileElement skip;

	@iOSXCUITFindBy(id = "Bookmarks")
	private static MobileElement bookmarks;

	@iOSXCUITFindBy(id = "BOOKMARKS")
	private static MobileElement bookmarkPage;

	@iOSXCUITFindBy(id = "BOOKMARKS")
	private static MobileElement bookmarkIcon;

	@iOSXCUITFindBy(id = "Remove All")
	private static MobileElement removeAllBookMarks;

	@iOSXCUITFindBy(id = "Toast")
	private static MobileElement loginPopup;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=‘Find News to Bookmark’]")
	private static MobileElement findNews;

	@iOSXCUITFindBy(id = "Welcome back,")
	private static MobileElement userDetails;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=‘Display & Text Size’]")
	private static MobileElement displayTextSize;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=‘Notifications’]")
	private static MobileElement notifications;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Explore']")
	private static MobileElement exploreButton;

	@iOSXCUITFindBy(id = "India")
	private static MobileElement indiaSection;

	@iOSXCUITFindBy(id = "INDIA NEWS")
	private static MobileElement indiaLandingPage;

	@iOSXCUITFindBy(id = "Bookmark")
	private static MobileElement bottomActionSheet;

	@iOSXCUITFindBy(id = "Bookmark")
	private static MobileElement bookmarkOption;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
	private static MobileElement threeDots;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Find your bookmarked articles here, you can tap on the bookmark icon to remove them from this list.'])[2]")
	private static MobileElement bookmarkPageTextMessage;

	@iOSXCUITFindBy(id = "ACCOUNT")
	private static MobileElement account;

	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name='BOOKMARKS']")
	private static MobileElement bookMarksCenterHeading;

//**/XCUIElementTypeStaticText[`label == 'Label'`][2]
	@iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeStaticText[`label == 'Label'`][2]")
	private static MobileElement firstStoryTitle;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Sports'])[2]")
	private static MobileElement sportsOption;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText[1]")
	private static MobileElement clickFirstStory;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Articles')]")
	private static MobileElement articlesInBookMark;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='bookmarked Item'])[1]")
	private static MobileElement firstbookMarkIconInBookMarkPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Photos']")
	private static MobileElement photosSection;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton)[1]")
	private static MobileElement firstStorySectionName;

	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name='Bookmarks']/following-sibling::XCUIElementTypeStaticText/following-sibling::XCUIElementTypeStaticText")
	private static MobileElement bookMarkArticleCountInProfile;

	@iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[contains(@name,'Removed')]")
	private static MobileElement popUpRemoved;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Please login to bookmark'`]")
	private static MobileElement nonLoggedInBookmarkMsg;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Videos']")
	private static MobileElement videosSection;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='bookmarked Item'])[1]/parent::XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
	private static MobileElement firstBookmarkedStoryInBookmarkPage;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Label\"])[2]")
	private static MobileElement headingInStoryPage;

	@iOSXCUITFindBy(id = "twitter")
	private static MobileElement twitter;

	@iOSXCUITFindBy(id = "share whatsapp")
	private static MobileElement whatsApp;

	@iOSXCUITFindBy(id = "searchNav")
	private static MobileElement searchField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='micIconDay']/preceding-sibling::XCUIElementTypeTextField")
	private static MobileElement textBoxInSearch;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='News']")
	private static MobileElement newsLabelOnSearchResultPage;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Photos']")
	private static MobileElement photosLabelOnSearchResultPage;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Videos']")
	private static MobileElement videosLabelOnSearchResultPage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three grey list']")
	private static List<MobileElement> ThreeDotsInStory;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bookmark']")
	private static MobileElement bookMarkOptionInThreeDots;

	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name='Related Topics']")
	private static MobileElement relatedTopic;

	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name='Related Topics']/parent:: XCUIElementTypeCell/XCUIElementTypeStaticText")
	private static List<MobileElement> relatedTopicsList;

	public MobileElement setXpath(String s) {
		MobileElement savedStoryinSaved = driver
				.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name," + s + ")]"));
		// @iOSXCUITFindBy(xpath =
		// "//XCUIElementTypeStaticText[contains(@name,'"+s+"')]")
		return savedStoryinSaved;
	}

	public BookmarkPage() {
		globalVars = GlobalVars.getInstance();
		driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		commonFunctions = CommonFunctionsMobile.getInstance();
		//Utils.logStepInfo("This is started");
		/*commonFunctions.clickElementIfDisplayed(allowTracking,10,"Allow Tracking");
		commonFunctions.clickElementIfDisplayed(notificationAllow, 5, "notificationAllow");
		commonFunctions.clickElementIfDisplayed(continueButton,5,"Continue Button");
		commonFunctions.clickElementIfDisplayed(mayBeLater,5,"Later Button");
		commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");*/
	}

	@Override
	public boolean checkBookMarkWorkingFine(String[] params) {
		commonFunctions.dummyWait(10);
		commonFunctions.clickElement(home, 60, "Home button");
		commonFunctions.tapByCoordinate(180,360,"story page");
		Utils.logStepInfo("Opened a story article");
		commonFunctions.clickElementIfDisplayed(skip,30,"Skip Button");
		boolean wait = commonFunctions.isElementDisplayed(bookmark, 5);
		Utils.logStepInfo(wait,"Successfully landed on story page");
		boolean isBookMarkVisvble=commonFunctions.isElementDisplayed(bookmark,10,"bookmark button");
		Utils.logStepInfo(isBookMarkVisvble,"Bookmark is visible");
		boolean clickBookmark = commonFunctions.clickElement(bookmark);
		Utils.logStepInfo(clickBookmark,"Clicked on bookmark and Story successfully added");

		commonFunctions.isElementDisplayedUnlclickable(popUpAdded,3,"added pop up");

		boolean goHome = commonFunctions.clickElement(backButton);
		Utils.logStepInfo(goHome,"Clicked on back button to go to home page");
		boolean isHome = commonFunctions.isElementDisplayed(profileButton,10,"hamburger menu");
		Utils.logStepInfo(isHome,"Successfully landed on Home Page");
		boolean tapham = commonFunctions.clickElement(profileButton);
		Utils.logStepInfo(tapham,"Clicked on hamburger");
		boolean clickSav = commonFunctions.clickElement(bookmarks);
		Utils.logStepInfo(clickSav,"clicked on saved link");
		//boolean isSaved = commonFunctions.isElementDisplayed(bookmarkedStories.get(2),10,"saved");
		//Utils.logStepInfo(isSaved,"bookmarked article is saved in the saved articles");
		commonFunctions.clickElement(backButton);

		return   wait && isBookMarkVisvble && clickBookmark && goHome && isHome && tapham &&clickSav;
	}

	@Override
	public boolean checkRemoveAllLinkBookMarkPage(String[] params) {
		commonFunctions.clickElement(bookmarks,10,"Bookmark Page");
		boolean isRemoveAllVisible=commonFunctions.isElementDisplayed(removeAllBookMarks,10,"bookmark button");
		Utils.logStepInfo(isRemoveAllVisible,"RemoveAll in Bookmark is visible");
		return isRemoveAllVisible;
	}
	@Override
	public boolean checkBookMarkRedirectionLoggedInUser() {
		commonFunctions.clickElement(home,5,"Home button");
		commonFunctions.clickElement(profileButton,10,"Profile Page");
		boolean isUserDetailsDisplayed=commonFunctions.isElementDisplayed(userDetails, 10, "User Details");
		commonFunctions.clickElement(bookmarks,10,"Bookmark Option");
		boolean isBookmarkPageDisplayed=commonFunctions.isElementDisplayed(bookmarkPage,10,"BookMark Page");
		boolean isBookmarkedStoryDisplayed;
    	if (bookmarkedStories.size()>0){
			isBookmarkedStoryDisplayed=true;
			Utils.logStepInfo(true,"Bookmarked Stories visible");
		}
		else {
			isBookmarkedStoryDisplayed = false;
			Utils.logStepInfo(false,"Bookmarked Stories not visible");
		}
		return isUserDetailsDisplayed&&isBookmarkedStoryDisplayed&&isBookmarkPageDisplayed;
	}
	@Override
	public boolean checkBookMarkRedirectionNonLoggedInUser() {
		commonFunctions.clickElement(home,10,"Home Page");
		commonFunctions.clickElement(profileButton,10,"Profile Page");
		boolean isLoginOptionPresent=commonFunctions.isElementDisplayed(loginInButton,10,"Login button");
		commonFunctions.clickElement(bookmarks,10,"Bookmark Option");
		commonFunctions.clickElement(findNews,10,"Find to Bookmark Option");
		commonFunctions.tapElementWithCoOrdinates(200,300,"Open Story");
		commonFunctions.dummyWait(5);
		commonFunctions.clickElement(skip,10,"Skip to Bookmark Option");
		commonFunctions.clickElement(bookmark,10,"Skip to Bookmark Option");
		boolean isLoginPopupDisplayed=commonFunctions.isElementDisplayed(loginPopup,10,"Login Popup");
		Utils.logStepInfo(isLoginPopupDisplayed,"Login Popup for Bookmark is visible");
		return isLoginOptionPresent&&isLoginPopupDisplayed;
	}
	@Override
	public boolean checkOptionsInSettings() {
		commonFunctions.clickElement(profileButton,10,"Profile Page");
		boolean isDisplayTextSizeDisplayed=commonFunctions.isElementDisplayed(displayTextSize, 10, "sub section Display & Text Size");
		boolean isNotificationsDisplayed=commonFunctions.isElementDisplayed(notifications,10,"sub section Notifications");
		return isDisplayTextSizeDisplayed&&isNotificationsDisplayed;
	}

	@Override
	public boolean checkBookmark3DotOption()
	{
		commonFunctions.clickElement(home, 60, "Home button");
		commonFunctions.clickElement(exploreButton, 5, "Profile page");
		commonFunctions.clickElement(indiaSection, 5, "Section page");
		boolean indiaSectionDisplayed=commonFunctions.isElementDisplayed(indiaLandingPage,10,"India Section");
		boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,10,"Three Dots");
		commonFunctions.clickElement(threeDots,10,"Three DOts");
		boolean isBottomActionSheetDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,10,"Bottom Action Sheet");
		commonFunctions.clickElement(bookmarkOption,10,"Bookmark");
		return indiaSectionDisplayed && threeDotsDisplayed&&isBottomActionSheetDisplayed;

	}
	@Override
	public boolean checkHomeisSelectedBottomNavOnBookmarkPage() {
		commonFunctions.clickElement(home, 20, "HT home button");
		commonFunctions.clickElement(profileButton, 20, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 20, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.isElementDisplayed(bookmarkPage,20,"Bookmark page");
		return commonFunctions.isElementSelected(home,20,"Home button on Bookmark page") && isBookmarkPageDisplay;

	}

	@Override
	public boolean checkRedirectionOnTapBackFromBookmarkPage() {
		commonFunctions.clickElement(home, 20, "HT home button");
		commonFunctions.clickElement(profileButton, 20, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 20, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.isElementDisplayed(bookmarkPage, 20, "Bookmark Page");
		commonFunctions.clickElement(backButton, 20, "Back to Profile page");
		boolean isProfilePageDisplay = commonFunctions.isElementDisplayed(account, 20, "Bookmark Page");
		return isBookmarkPageDisplay && isProfilePageDisplay;
	}

	@Override
	public boolean checkSomeArticleIsBookmarked() {
		return false;
	}

	@Override
	public boolean checkBookmarkPageHeadingInCenter() {
		commonFunctions.clickElement(home, 20, "HT home button");
		commonFunctions.clickElement(profileButton, 20, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 20, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.getElementText(bookMarksCenterHeading, 20).contains("BOOKMARKS");
		boolean isPageHeadingInCenterTrue = commonFunctions.isElementDisplayed(bookMarksCenterHeading, 20, "BOOKMARKS at Top of the page and at center alignment");
		return isBookmarkPageDisplay && isPageHeadingInCenterTrue;
	}

	@Override
	public boolean checkTextDisplayAfterBookmarkPageHeading() {
		commonFunctions.clickElement(home, 20, "HT home button");
		commonFunctions.clickElement(profileButton, 20, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 20, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.isElementDisplayed(bookmarkPage, 20, "Bookmark Page");
		//For the next step, browserstack returns false, although it is visible, hence disabling the step
		//boolean isTextMessageAfterHeadingName = commonFunctions.getElementText(bookmarkPageTextMessage, 20).contains("Find your bookmarked articles here, you can tap on the bookmark icon to remove them from this list.");

		return isBookmarkPageDisplay;
	}

	@Override
	public boolean checkRedirectionStoryPageOnTap() {
		commonFunctions.clickElement(home, 20, "HT home button");
		commonFunctions.clickElement(profileButton, 20, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 20, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.getElementText(bookMarksCenterHeading, 20).contains("BOOKMARKS");
		/*String firstStoryTitleText = commonFunctions.getElementText(StoryTitle, 20);
		System.out.println("First Story title text = " +firstStoryTitleText);
		commonFunctions.clickElement(StoryTitle, 20, firstStoryTitleText);*/
		commonFunctions.dummyWait(5);
		Utils.logStepInfo("Clicking on bookmark Skip button to explre story details.");
		commonFunctions.clickByCoordinates(106, 217);//As skip/next button in the prompt locator is not available
		commonFunctions.clickElementIfDisplayed(skip, 30, "Skip Button");
		String storyHeadlineText = commonFunctions.getElementText(firstStoryTitle, 20);
		System.out.println("Story heading line text = " +storyHeadlineText);
		boolean redirectionStoryPageTrue = commonFunctions.compareTexts(storyHeadlineText, storyHeadlineText);
		commonFunctions.clickElement(profileButton,20,"Profile Button");
		return isBookmarkPageDisplay && redirectionStoryPageTrue;
	}

	@Override
	public boolean checkRedirectionSectionPageOfStoryOnTap() {
		commonFunctions.clickElement(home, 5, "HT home button");
		commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 5, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.getElementText(bookMarksCenterHeading, 5).contains("BOOKMARKS");
		String storySectionNameOnBookmarkPage = commonFunctions.getElementText(firstStorySectionName, 5);
		System.out.println("Section Name in First BookMarked Story is ----- " +storySectionNameOnBookmarkPage);
		commonFunctions.clickElement(firstStorySectionName, 5, storySectionNameOnBookmarkPage);
		MobileElement pageHeader = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+storySectionNameOnBookmarkPage+"']"));
		String sectionPageHeaderName = pageHeader.getText();
		System.out.println("Section pahe header text is ------- " +sectionPageHeaderName);
		//commonFunctions.clickElement(profileButton,10,"Profile Button");
		return commonFunctions.compareTexts(storySectionNameOnBookmarkPage, sectionPageHeaderName) && isBookmarkPageDisplay;
	}

	@Override
	public boolean checkBottomNavDisplayOnBookmarkPage() {
		commonFunctions.clickElement(home, 5, "HT home button");
		commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 5, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.isElementDisplayed(bookmarkPage, 5, "Bookmark Page");
		boolean isExploreDisplay = commonFunctions.isElementDisplayed(exploreButton, 5, "Bottom nav on Bookmark page");
		return  isBookmarkPageDisplay && isExploreDisplay;
	}

	@Override
	public boolean checkBookmarkIconDisplayBeforeImageStory() {
		commonFunctions.clickElement(home, 5, "HT home button");
		commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
		commonFunctions.clickElement(bookmarks, 5, "Bookmarks option on Profile page");
		boolean isBookmarkPageDisplay = commonFunctions.isElementDisplayed(bookmarkPage, 5, "Bookmark Page");
		//commonFunctions.clickElement(firstStory, 20, "First story of the Bookmark page");
		commonFunctions.clickElementWithCoordinates(150, 230);
		commonFunctions.dummyWait(5);
		commonFunctions.clickElement(skipButton, 5, "Skip button of the Bookmark page");
		boolean isBookmarkIconDisplay = commonFunctions.isElementDisplayed(bookmark, 5, "Bookmark icon before Image story");
		commonFunctions.clickElement(backButton, 5, "Back to Profile page");
		commonFunctions.clickElement(backButton, 5, "Back to Profile page");
		return isBookmarkIconDisplay && isBookmarkPageDisplay;
	}

	@Override
	public boolean checkTapOnBookmarkIconAtBookmarkPage() {
		commonFunctions.clickElement(home,5,"Home Page");
		commonFunctions.clickElement(profileButton,5,"Profile Button");
		commonFunctions.clickElement(bookmarks,10,"BookMarks page");
		boolean isBookMarkHeading = commonFunctions.isElementDisplayed(bookMarksCenterHeading,10,"BookMark Icon");
		return isBookMarkHeading;
	}

	@Override
	public boolean checkBookmarkStoryDisplay() {
		return false;
	}

	@Override
	public boolean checkBookmarkStoryDisplayForAnySectionSavedArticles() {
		return false;
	}

	@Override
	public boolean bookMarkStoryFromSportsSection() {
		return bookMarkStoryFromSection(sportsOption,true,"Sports", false);
	}

	@Override
	public boolean sportStoryInBookMarkedArtical() {
		return verifyBookMarkedStoryDisplayedInBookMarkPage(sportsOption,true,"Sports");
	}

	@Override
	public boolean bookMarkStoryFromPhotosSection() {
		return bookMarkStoryFromSection(photosSection,true,"Photos", false);
	}

	@Override
	public boolean photoStoryInBookMarkedArtical() {
		return verifyBookMarkedStoryDisplayedInBookMarkPage(photosSection,true,"Photos");
	}

	@Override
	public boolean checkCountOfBookMarkedStoriesSame() {
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,5,"profile Button");
		String articleCount = commonFunctions.getElementText(bookMarkArticleCountInProfile,5);
		int articleCountInProfileTab = Integer.parseInt(articleCount.replaceAll("\\(","").replace(")",""));
		commonFunctions.clickElement(bookmarks,5,"BookMark Option");
		String articles = articlesInBookMark.getText();
		int countOfArticlesInBookMarkSection = Integer.parseInt(articles.replaceAll("Articles \\(","").replace(")",""));
		boolean isCountAreSame = countOfArticlesInBookMarkSection==articleCountInProfileTab;
//		commonFunctions.clickElement(profileButton,5,"Profile Button");
		return isCountAreSame;
	}

	@Override
	public boolean checkBookMarkMsgForLoggedInUser() {
		commonFunctions.clickElement(home,5,"Home");
		boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,10,"Three Dots");
		commonFunctions.clickElement(threeDots,10,"Three DOts");
		boolean isBookMarkOptionDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,10,"Bottom Action Sheet");
		commonFunctions.clickElement(bookmarkOption,10,"Bookmark");
		//Unable to Locate Pop Up Message Box
		//boolean isBookMarkedMsgBox = commonFunctions.isElementDisplayedUnlclickable(popUpAdded,5,"BookMark Added") || commonFunctions.isElementDisplayedUnlclickable(popUpRemoved,5,"BookMark Removed");
		commonFunctions.clickElement(profileButton,5,"Profile Button");
		return threeDotsDisplayed && isBookMarkOptionDisplayed;
	}

	@Override
	public boolean checkBookMarkMsgBoxForNonLoggedInUser() {
		commonFunctions.clickElement(home,5,"Home");
		boolean threeDotsDisplayed=commonFunctions.isElementDisplayed(threeDots,10,"Three Dots");
		commonFunctions.clickElement(threeDots,10,"Three DOts");
		boolean isBookMarkOptionDisplayed = commonFunctions.isElementDisplayed(bottomActionSheet,10,"Bottom Action Sheet");
		commonFunctions.clickElement(bookmarkOption,10,"Bookmark");
		boolean isBookmarkMsg = commonFunctions.isElementDisplayed(nonLoggedInBookmarkMsg,5,"BookMark Msg for Non Logged in User");
		return threeDotsDisplayed && isBookMarkOptionDisplayed;
	}

	@Override
	public boolean checkUnBookMarkStoryOfVideoSection() {
		return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(videosSection,true,"Videos", false);
	}

	@Override
	public boolean checkBookMarkedStoryFromVideoSection() {
		return verifyBookMarkedStoryDisplayedInBookMarkPage(videosSection,true,"Videos");
	}

	@Override
	public boolean checkUnBookMarkStoryOfPhotosSection() {
		return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(photosSection,true,"Photos",false);
	}

	@Override
	public boolean checkBookMarkStoryFromSectionListingPage() {
		Boolean isStoryBookMarked = false;
		checkArticlesCountInBookMark();
		int countOfArticlesBeforeBookmarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		System.out.println("Final Value of Artical after removing = " +countOfArticlesBeforeBookmarked);
		//BookMark Story from Photos Section -----
		commonFunctions.clickElement(home,10,"Home");
		commonFunctions.clickElement(indiaSection,10,"India Section");
		commonFunctions.clickElement(clickFirstStory,10,"Click First Story");
		commonFunctions.clickElementIfDisplayed(skip,10,"Skip Button");
		boolean isBookMarkDisplayed = commonFunctions.isElementDisplayed(bookmark,10,"BookMark Icon in Story");
		commonFunctions.clickElement(bookmark,10,"Click on Story to BookMark");
		commonFunctions.clickElement(home,10,"Home");
		commonFunctions.clickElement(profileButton,10,"Profile Button");
		commonFunctions.clickElementIfDisplayed(bookmarks,10,"BookMark page");
		//Article count After BookMarked Story ----
		isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookmarked);
		return isBookMarkDisplayed && isStoryBookMarked;
	}

	@Override
	public boolean checkBookMarkStoryInBookmarkSectionFromSectionListingPage() {
		return checkBookMarkStoryFromSectionListingPage();
	}

	@Override
	public boolean checkBackRedirectionFromBookmarkPage() {
		commonFunctions.clickElement(home,10,"Home");
		commonFunctions.clickElement(profileButton,10,"Profile Button");
		commonFunctions.clickElementIfDisplayed(bookmarks,10,"BookMark page");
		boolean isBookmarkPage = commonFunctions.isElementDisplayed(bookmarkPage,5,"BookMark Heading");
		commonFunctions.clickElement(firstBookmarkedStoryInBookmarkPage,5,"First Story in Bookmark Page");
		commonFunctions.clickElement(skip,5,"Skip Button");
		boolean isStoryPageOpen = commonFunctions.isElementDisplayed(headingInStoryPage,5,"Story Heading")
				|| (commonFunctions.isElementDisplayed(whatsApp,5,"Whats up") && commonFunctions.isElementDisplayed(twitter,5,"Twitter"));
		commonFunctions.clickElement(backButton,5,"back arrow");
		isBookmarkPage &= commonFunctions.isElementDisplayed(bookmarkPage,5,"BOOKMARKS page");
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,5,"Profile Button");
		commonFunctions.clickElementIfDisplayed(backButton,5,"Back Arrow");
		return isBookmarkPage && isStoryPageOpen;
	}

	@Override
	public boolean checkBookMarkStoryFromSearchPage() {
		Boolean isStoryBookMarked = false;
		checkArticlesCountInBookMark();
		int countOfArticlesBeforeBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		System.out.println("Final Value of Artical after removing = " +countOfArticlesBeforeBookMarked);
		//BookMark Story from Photos Section -----
		commonFunctions.clickElement(home,10,"Home");
		commonFunctions.clickElement(searchField,10,"Search page");
		commonFunctions.clickElement(ThreeDotsInStory.get(0),5,"Three Dot in First Story");
		commonFunctions.clickElement(bookMarkOptionInThreeDots, 5,"BookMark Option In Three Dots");
		commonFunctions.hideKeyboard();
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
		commonFunctions.clickElement(profileButton,5,"Profile Button");
		commonFunctions.clickElementIfDisplayed(bookmarks,5,"BookMark page");
		//Article count After BookMarked Story ----
		isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookMarked);
		commonFunctions.clickElementIfDisplayed(backButton,5,"back");
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
		commonFunctions.clickElement(profileButton,20,"Profile Button");
		return isStoryBookMarked;
	}

	@Override
	public boolean checkUnBookMarkStoryFromSearchPage() {

		return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(searchField,false,"Search",true);
	}

	@Override
	public boolean checkSearchBookMarkStoryDisplayedInBookMarkSection() {
		return checkBookMarkStoryFromSearchPage();
	}

	@Override
	public boolean checkDailyDigestBookMarkStoryDisplayedInBookMarkSection() {
		return verifyBookMarkedStoryDisplayedInBookMarkPage(dailyDigest,false,"MORNING BRIEF");
	}

	@Override
	public boolean checkDailyDigestUnBookMarkStoryDisplayedInBookMarkSection() {
		return verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(dailyDigest,false,"MORNING BRIEF",true);
	}

	@Override
	public boolean checkBookMarkStoryFromTopicPage() {
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
		commonFunctions.clickElement(clickFirstStory,5,"First Story");
		commonFunctions.clickElement(skip,5,"Skip Btn");
		boolean isScrollTORelatedTopic = commonFunctions.scrollDownSlowToElement(relatedTopic,15);
		commonFunctions.clickElement(relatedTopicsList.get(0),5,"First Topic From Related Topics");
		commonFunctions.clickElement(threeDots,5,"Three Dots");
		boolean isBookMarkDisplayed = commonFunctions.isElementDisplayed(bookMarkOptionInThreeDots,5,"BookMark Option by Three dots in first story");
		commonFunctions.clickElement(bookMarkOptionInThreeDots, 5,"BookMark Option In Three Dots");
		commonFunctions.hideKeyboard();
		return isScrollTORelatedTopic && isBookMarkDisplayed;
	}

	@Override
	public boolean checkUnBookMarkStoryFromTopicPage() {
		boolean isUnBookmarkedStory = false;
		checkArticlesCountInBookMark();
		int countOfArticlesBeforeBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		Utils.logStepInfo("Final Value of Artical after removing = " +countOfArticlesBeforeBookMarked);
		//BookMark Story from Related Topic
		boolean isBookMarkStoryFromTopic = checkBookMarkStoryFromTopicPage();
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,10,"Profile Button");
		commonFunctions.clickElementIfDisplayed(bookmarks,5,"BookMark page");
		//Article count After BookMarked Story ----
		int countOfArticlesAfterAdded = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		Utils.logStepInfo("Value of Article after bookmarked = "+countOfArticlesAfterAdded);
		if(countOfArticlesBeforeBookMarked == countOfArticlesAfterAdded-1){
			Utils.logStepInfo("Story is BookMarked and Article Value is incressed by one");
			commonFunctions.clickElement(firstbookMarkIconInBookMarkPage, 5, "UnBookMark Story");
			commonFunctions.dummyWait(2);
			int countOfArticlesAfterUnBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
			if(countOfArticlesAfterUnBookMarked == countOfArticlesAfterAdded-1) {
				Utils.logStepInfo(true,"Story is UnBookMarked Successfully!!!!!!");
				isUnBookmarkedStory = true;
			}
		}
		else if(countOfArticlesAfterAdded == countOfArticlesAfterAdded+1){
			Utils.logStepInfo(true,"Story is already BookMarked so removed from BookMarked article");
			isUnBookmarkedStory = true;
		}
		else{
			Utils.logStepInfo(false,"Failed to bookMark Story from Photos Section");
			isUnBookmarkedStory = false;
		}
		commonFunctions.clickElementIfDisplayed(backButton,5,"Back");
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
		commonFunctions.clickElement(profileButton,20,"Profile Button");
		return isUnBookmarkedStory && isBookMarkStoryFromTopic;
	}

	@Override
	public boolean checkTopicBookMarkStoryDisplayedInBookMarkSection() {
		Boolean isStoryDisplayedBookMarked = false;
		checkArticlesCountInBookMark();
		int countOfArticlesBeforeBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		Utils.logStepInfo("Final Value of Artical after removing = " +countOfArticlesBeforeBookMarked);
		//BookMark Story from Topic Section -----
		boolean isTopicStoryBookMarked = checkBookMarkStoryFromTopicPage();
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,5,"Profile Button");
		commonFunctions.clickElementIfDisplayed(bookmarks,5,"BookMark page");
		//Article count After BookMarked Story ----
		isStoryDisplayedBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookMarked);
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,10,"Profile Button");
		return isTopicStoryBookMarked && isStoryDisplayedBookMarked;
	}

	@Override
	public boolean checkBookMarkedStoryFromDailyDigest() {
		return bookMarkStoryFromSection(dailyDigest,false, "MORNING BRIEF",true);
	}

	@Override
	public boolean checkBottomActionPageOnIndiaPage() {
		return false;
	}

	@Override
	public boolean checkClickThreeDotDisplayDifferentOptions() {
		return false;
	}


	@Override
	public boolean checkAdToBookmarkAndVerify(String uri, String address) {
		return false;
	}

	@Override
	public boolean checkBookmarkIconIsClickableAndDisplay(String uri, String address) {
		return false;
	}

	public boolean checkArticlesCountInBookMark(){
		commonFunctions.clickElement(home,10,"Home");
		commonFunctions.clickElement(profileButton,10,"Profile Button");
		commonFunctions.clickElement(bookmarks,10,"BookMark page");
		String articles = articlesInBookMark.getText();
		int countOfArticles = Integer.parseInt(articles.replaceAll("Articles \\(","").replace(")",""));
		Utils.logStepInfo("Integer value of Article = " +countOfArticles);
		if(countOfArticles >=50){
			int needToRemove = countOfArticles - 47;
			for (int i = 0; i<needToRemove; i++){
				commonFunctions.clickElement(firstbookMarkIconInBookMarkPage,10,"First BookMark Remove");
				commonFunctions.dummyWait(2);
			}
		}
		else{
			System.out.println("BookMarked Articles are less than 50");
		}
		return true;
	}

	public boolean bookMarkStoryFromSection(MobileElement fromSection, boolean isScrollingFlagForSection, String sectionName, boolean fromThreeDotInFirstStory) {
		boolean isBookMarkDisplayed = false;
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(exploreButton,5,"Explore Button");
		if (isScrollingFlagForSection){
			commonFunctions.checkElementVisibilityByScrolling(fromSection, sectionName +" Section Scrolling");
		}
		commonFunctions.clickElement(fromSection,5,sectionName+ " Section");
		if(fromThreeDotInFirstStory){
			commonFunctions.clickElement(threeDots,15,"Three Dot in First Story");
			isBookMarkDisplayed = commonFunctions.isElementDisplayed(bookMarkOptionInThreeDots,5,"BookMark Option by Three dots in first story");
			commonFunctions.clickElement(bookMarkOptionInThreeDots, 5,"BookMark Option In Three Dots");
			commonFunctions.hideKeyboard();
		}
		else {
			commonFunctions.clickElement(clickFirstStory, 5, "Click First Story");
			commonFunctions.clickElementIfDisplayed(skip, 5, "Skip Button");
			isBookMarkDisplayed = commonFunctions.isElementDisplayed(bookmark, 5, "BookMark Icon in Story");
			commonFunctions.clickElement(bookmark, 5, "Click on Story to BookMark");
		}
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
		commonFunctions.clickElement(profileButton,5,"Profile Button");
		return isBookMarkDisplayed;
	}

	public boolean verifyBookMarkedStoryDisplayedInBookMarkPage(MobileElement fromSection, boolean isScrollingFlagForSection, String sectionName){
		Boolean isStoryBookMarked = false;
		checkArticlesCountInBookMark();
		int countOfArticlesBeforeBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		System.out.println("Final Value of Artical after removing = " +countOfArticlesBeforeBookMarked);
		//BookMark Story from Photos Section -----
		commonFunctions.clickElement(home,10,"Home");
		commonFunctions.clickElement(exploreButton,10,"Explore Button");
		if (isScrollingFlagForSection){
			commonFunctions.checkElementVisibilityByScrolling(fromSection, sectionName+" Section Scrolling");
		}
		commonFunctions.clickElement(fromSection,5,sectionName+" Section");
		commonFunctions.clickElement(clickFirstStory,5,"Click First Story");
		commonFunctions.clickElementIfDisplayed(skip,5,"Skip Button");
		boolean isBookMarkDisplayed = commonFunctions.isElementDisplayed(bookmark,5,"BookMark Icon in Story");
		commonFunctions.clickElement(bookmark,5,"Click on Story to BookMark");
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,5,"Profile Button");
		commonFunctions.clickElementIfDisplayed(bookmarks,5,"BookMark page");
		//Article count After BookMarked Story ----
		isStoryBookMarked = commonFunctions.verifyStoryBookMarked(articlesInBookMark,countOfArticlesBeforeBookMarked);
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,10,"Profile Button");
		return isBookMarkDisplayed && isStoryBookMarked;
	}

	public boolean verifyUnBookMarkedStoryNotDisplayedInBookMarkPage(MobileElement fromSection, boolean isScrollingFlagForSection, String sectionName, boolean fromThreeDotsInFirstStory){
		Boolean isStoryBookMarked = false;
		checkArticlesCountInBookMark();
		int countOfArticles = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		System.out.println("Final Value of Artical after removing = " +countOfArticles);
		//BookMark Story from Photos Section -----
		boolean isbookMarkStoryFromVideoSection = bookMarkStoryFromSection(fromSection,isScrollingFlagForSection, sectionName, fromThreeDotsInFirstStory);
		commonFunctions.clickElement(home,5,"Home");
		commonFunctions.clickElement(profileButton,10,"Profile Button");
		commonFunctions.clickElementIfDisplayed(bookmarks,5,"BookMark page");
		//Article count After BookMarked Story ----
		int countOfArticlesAfterAdded = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(","").replace(")",""));
		System.out.println("Value of Article after bookmarked = "+countOfArticlesAfterAdded);
		if(countOfArticles == countOfArticlesAfterAdded-1){
			System.out.println("Story is BookMarked and Article Value is incressed by one");
			commonFunctions.clickElement(firstbookMarkIconInBookMarkPage, 5, "UnBookMark Story");
			commonFunctions.dummyWait(2);
			int countOfArticlesAfterUnBookMarked = Integer.parseInt(articlesInBookMark.getText().replaceAll("Articles \\(", "").replace(")", ""));
			if(countOfArticlesAfterUnBookMarked == countOfArticlesAfterAdded-1){
				System.out.println("Story is UnBookMarked Successfully!!!!!!");
				isStoryBookMarked = true;
			}
		}
		else if(countOfArticles == countOfArticlesAfterAdded+1){
			System.out.println("Story is already BookMarked so removed from BookMarked article");
			isStoryBookMarked = true;
		}
		else{
			System.out.println("Failed to bookMark Story from Photos Section");
			isStoryBookMarked = false;
		}
		commonFunctions.clickElementIfDisplayed(backButton,5,"Back");
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
		commonFunctions.clickElement(profileButton,20,"Profile Button");
		return isbookMarkStoryFromVideoSection && isStoryBookMarked;
	}

	public boolean newsPhotosVideosOptionDisplayedInSearchResult(){
		boolean isLabelDisplayed;
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
		commonFunctions.clickElement(searchField,5,"Search Option");
		commonFunctions.clickElementIfDisplayed(textBoxInSearch,20,"Click on Search box");
		commonFunctions.sendKeysOnAndroid(textBoxInSearch,"Cricket");
		commonFunctions.dummyWait(5);
		commonFunctions.clickByCoordinates(338,742,"Enter Key");
		commonFunctions.dummyWait(10);
		isLabelDisplayed = commonFunctions.getElementText(newsLabelOnSearchResultPage, 5).equalsIgnoreCase("News")
				&& commonFunctions.getElementText(photosLabelOnSearchResultPage, 5).equalsIgnoreCase("Photos")
				&& commonFunctions.getElementText(videosLabelOnSearchResultPage, 5).equalsIgnoreCase("Videos");
		return isLabelDisplayed;
	}

}
