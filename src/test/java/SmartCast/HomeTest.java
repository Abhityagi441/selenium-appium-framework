package SmartCast;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.SmartCast.generic.CommonHomePage;
import com.pages.SmartCast.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class HomeTest extends BaseTest {
	private static CommonHomePage homePage;
	private static CommonLoginPage loginPage;
	GlobalVars globalVars= GlobalVars.getInstance();


	@BeforeMethod
	public void beforeMethod() {
		homePage = CommonHomePage.getInstance();
		loginPage = CommonLoginPage.getInstance();
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-873,QAAUT-1147(Android-mweb): To verify Page Title of HT Smartcast")
	@Test
	public void verifyGetHomePageTitleTest() {
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyGetHomePageTitleTest");
		String expectedTitle = paramsMap.get("expectedTitle");
		String actualTitle = homePage.getSmartCastTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Actual and Expected Title is not matched");
	}
	
	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-929, QAAUT-1148(Android-mweb): To verify Logo of HT Smartcast")
	@Test
	public void verifyClickSmartCastLogoImageTest() {
		boolean isDisplayed = homePage.clickSmartCastLogo();
		Assert.assertTrue(isDisplayed , "Logo is not Clickable");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-963: To verify Hamburger Menu and its components.")
	@Test
	public void verifyHamburger() {
		boolean isStepTrue;
		isStepTrue = homePage.checkHamburger();
		Assert.assertTrue(isStepTrue, "Hamburger Options are empty");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1041: To verify the Share Latest Podcast Episode on Facebook")
	@Test
	public void verifyFacebookSharingFromLatestPodcast() {
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyFacebookSharingFromLatestPodcast");
		isStepTrue = homePage.checkFacebookSharingFromLatestPodcast(paramsMap.get("email"), paramsMap.get("password"));
		Assert.assertTrue(isStepTrue, "Sharing podcast with Facebook is failed");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1043: To verify the Share Latest Podcast Episode on Twitter")
	@Test
	public void verifyTwitterSharingFromLatestPodcast() {
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyTwitterSharingFromLatestPodcast");
		isStepTrue = homePage.checkTwitterSharingFromLatestPodcast(paramsMap.get("email"), paramsMap.get("password"));
		Assert.assertTrue(isStepTrue, "Sharing podcast with Twitter is failed");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1056: To verify Bookmark Story (My List) functionality")
	@Test
	public void verifyBookmarkStory() {
		boolean isStepTrue;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyBookmarkStory");
		isStepTrue = loginPage.loginWithEmailAndPassword(paramsMap.get("email"), paramsMap.get("password"),paramsMap.get("expectedUserName"));
		Assert.assertTrue(isStepTrue, "Login with Email and Password Fail");
		isStepTrue = homePage.bookmarkStoryWithLoggedInUser(paramsMap.get("propertyName"));
		Assert.assertTrue(isStepTrue, "Bookmark Story Failed");
		isStepTrue = homePage.clearBookmarkStoryWithLoggedInUser(paramsMap.get("propertyName"));
		Assert.assertTrue(isStepTrue, "Clear Bookmark Story Failed");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1118: To verify Home Section Trays")
	@Test
	public void verifyHomeSectionTrays() {
		boolean isDisplayed = homePage.checkHomeSectionTrays();
		Assert.assertTrue(isDisplayed , "Home Section Trays not available");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1126: To verify Podcast player button functions")
	@Test
	public void verifyPodcastPlayerFunctions() {
		boolean isPodcastFunctionalityCorrect = homePage.checkPodcastPlayerFunctions();
		Assert.assertTrue(isPodcastFunctionalityCorrect , "verification of Podcast player button functions failed ");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1128: To verify Podcast Information")
	@Test
	public void verifyPodcastInformation() {
		boolean isPodcastFunctionalityCorrect;
		Map<String, String> paramsMap=globalVars.getParamsDataSinglePropertySingleProperty("verifyPodcastInformation");
		isPodcastFunctionalityCorrect = homePage.checkPodcastInformation(paramsMap.get("propertyName"));
		Assert.assertTrue(isPodcastFunctionalityCorrect , "verification of Podcast Information page failed ");
	}

	@Author(name = "Chaitanya Shastry")
	@Description("QAAUT-1129: To verify share email functionality")
	@Test
	public void verifyShareEmailFunctionality() {
		boolean isShareEmailFunctionalityCorrect;
		isShareEmailFunctionalityCorrect = homePage.checkShareEmailFunctionality();
		Assert.assertTrue(isShareEmailFunctionalityCorrect , "Email sharing failed ");
	}

}
