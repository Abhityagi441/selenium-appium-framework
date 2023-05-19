package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HamburgerPage extends CommonHamburgerPage {
	private static AndroidDriver driver;
	private static GlobalVars globalVars;
	private static CommonFunctionsMobile commonFunctions;
	private static ApiValidation apiValidation;


	@AndroidFindBy(id = "com.ht.news:id/tv_section_name")
	private static List<MobileElement> entertainmentNews;

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Home']")
	private static MobileElement home;

	@AndroidFindBy(id = "com.ht.news:id/toolbarText")
	private static MobileElement pageHeading;

	@AndroidFindBy(className = "android.widget.CheckedTextView[@resource-id='com.ht.news:id/design_menu_item_text']")
	private static List<MobileElement> hamburgerMenuOptions;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Entertainment']/android.widget.TextView")
	private static MobileElement highLightingHome;

	@AndroidFindBy(id = "com.ht.news:id/tvSkip")
	private static MobileElement skipButton;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Explore']/android.widget.FrameLayout/android.widget.ImageView")
	private static MobileElement exploreMenu;

	@AndroidFindBy(accessibility = "Interstitial close button")
	private  static  MobileElement adPopUpInApp;

	@AndroidFindBy(id = "com.ht.news:id/continueBtn")
	private static MobileElement continueButton;

	@AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
	private static MobileElement laterButton;

	@AndroidFindBy(id = "com.ht.news:id/btn_continue")
	private static MobileElement startReadingNews;

	@AndroidFindBy(accessibility = "Home")
	private static MobileElement homeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Entertainment']")
	private static MobileElement entertainmentOption;



	public HamburgerPage() {
		globalVars = GlobalVars.getInstance();
		driver = (AndroidDriver) globalVars.getAppiumDriver();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		commonFunctions = CommonFunctionsMobile.getInstance();
		commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
		commonFunctions.clickElementIfDisplayed(laterButton, 5, "Later Button");
		commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
		/*commonFunctions.dummyWait(5);
		commonFunctions.clickByCoordinates(206, 1950);
		commonFunctions.clickByCoordinates(650, 515);
		commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available*/
		apiValidation = ApiValidation.getInstance();
		System.out.println("****************** Test started ******************");
		System.out.println("******************" +globalVars.getProjectName()  + "******************");

	}

	@Override
	public boolean clickOnExplorerMenu() {

		return commonFunctions.clickElement(exploreMenu, 5, "Explore Menu");
	}

	@Override
	public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() {

		return commonFunctions.isElementDisplayed(entertainmentNews.get(6), 5, "Entertainment News");

	}

	@Override
	public boolean clickWorldNewsSectionOnHamburgerMenu() {
		return false;
	}

	@Override
	public boolean checkExploreHTOptionDisplayedOnHamburgerMenu() {
		return false;
	}

	@Override
	public boolean checkPopularSectionsDisplayed() {
		return false;
	}

	@Override
	public boolean checkSectionsDisplayed() {
		return false;
	}

	@Override
	public boolean clickOnEntertainmentSection() {
		return commonFunctions.clickElement(entertainmentNews.get(6), 5, "Entertainment news");
	}

	@Override
	public boolean checkRedirectionToEntertainmentSection() {
		return commonFunctions.isElementDisplayed(pageHeading, 5, "Entertainment Sub section visible in Entertainment page");
	}

	@Override
	public boolean checkAnySectionPage() {
		return false;
	}

	@Override
	public boolean checkIndiaNewsPageScrollable() {
		return false;
	}

	@Override
	public boolean checkHamburgerMenuAllOptionDisplayed() {
		return false;
	}

	@Override
	public boolean checkNavigationIndiaNews() {
		return false;
	}

	@Override
	public boolean breadcrumbDisplayedOtherThanHomePage() {
		return false;
	}

	@Override
	public boolean checkNavigationPopularNews() {
		return false;
	}

	@Override
	public boolean checkNavigationCricketNews() {
		return false;
	}

	@Override
	public boolean checkNavigationEditorialNews() {
		return false;
	}

	@Override
	public boolean checkNavigationEntertainmentNews() {
		return false;
	}

	@Override
	public boolean checkNavigationCitiesNews() {
		return false;
	}

	@Override
	public boolean checkNavigationLatestNews() {
		return false;
	}

	@Override
	public boolean checkHamburgerElementsClickable() {
		commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
		boolean explore = clickOnExplorerMenu();
		commonFunctions.clickElement(entertainmentOption,5,"Entertainment Option");
		boolean entertainment = commonFunctions.getElementText(pageHeading,5).equalsIgnoreCase("ENTERTAINMENT");
		return explore && entertainment;
	}

	@Override
	public boolean checkHamberburgerCases() {
		// TODO Auto-generated method stub
		return false;
	}
}
