package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonPremiumStoryPage;
import com.pages.LiveMint.genericPages.CommonStoryPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class StoryPageTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    private static CommonStoryPage storyPage;
    private static CommonPremiumStoryPage premiumStoryPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        storyPage = CommonStoryPage.getInstance();
        premiumStoryPage = CommonPremiumStoryPage.getInstance();
    }

    @Author(name = "Ravikumar Makam, Manoj Patil")
    @Description("QAAUT-776(Web), 787(MWeb-Android), 798(MWeb-IOS), 809(android_native), 818(ios_native), 827(AMP-Android), 837(AMP-IOS):Validate the story page")
    @Test
    public void verifyStoryPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStoryPage");
        String[] paramArray= new String[5];
        paramArray[0]=params.get("apiURL");
        isStepTrue = homePage.storyPage();
        Assert.assertTrue(isStepTrue, "Story Page verification failed");
        isStepTrue = homePage.apiForFirstStory(paramArray);
        Assert.assertTrue(isStepTrue, "API for First Story verification failed");
        isStepTrue = homePage.shareStory();
        Assert.assertTrue(isStepTrue, "Share Story icon verification failed");
        isStepTrue = homePage.bookmarkStory();
        Assert.assertTrue(isStepTrue, "Bookmark Story icon verification failed");
    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-819(web):Validate duplicate story entries should not be displayed in Latest News")
    @Test
    public void verifyDuplicateEntriesForLatestNews() {
        boolean isStepTrue;
        isStepTrue = homePage.checkDuplicateEntriesForLatestNews();
        Assert.assertTrue(isStepTrue, "Duplicate story entries in Latest News verification failed");
    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-810(web):Validation for story page widgets")
    @Test
    public void verifyStoryPageWidgets() {
        boolean isStepTrue;
        isStepTrue = homePage.checkStoryPageWidgets();
        Assert.assertTrue(isStepTrue, "Story Page Widgets verification failed");
        //No logout required here
        /*isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Story logout failed");*/
    }


    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1310(ios_native), QAAUT-1228(android_native):Verify in story functionality for text size selection")
    @Test
    public void verifyStoryPageTextSelector() {
        boolean isStepTrue;
        isStepTrue = storyPage.storyPageTextSizeSelection();
        Assert.assertTrue(isStepTrue, "story functionality for text size selection verification failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1312(ios_native),QAAUT-1230(android_native):Verify navigation by clicking on mint premium widget")
    @Test
    public void verifyMintPremiumWidget() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyMintPremiumWidget");
        isStepTrue = premiumStoryPage.mintPremiumWidget(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("text"));
        Assert.assertTrue(isStepTrue, "Navigation by clicking on mint premium widget verification failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1238(android_native):Verify no paywall shown to subscribed user for premium story.")
    @Test
    public void verifyNoPayWallToSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNoPayWallToSubscribedUser");
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = premiumStoryPage.checkNoPayWallToSubscribedUser(paramsMap.get("email"), paramsMap.get("password"));
        Assert.assertTrue(isStepTrue, "Pay wall is still showing to subscribed user.");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1311(ios_native):Verify navigation by clicking on more from this section widget to the same section story")
    @Test
    public void verifyMoreFromSectionWidget() {
        boolean isStepTrue;
        isStepTrue = storyPage.moreFromSectionWidget();
        Assert.assertTrue(isStepTrue, "More From Section Widget verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1231(android_native):Verify navigation by clicking on any story listed in similar story widget")
    @Test
    public void verifySimilarStoryWidget() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkSimilarStoryWidget();
        Assert.assertTrue(isStepTrue, "story functionality for text size selection verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1331(ios_native):Verify Ads are not Visible on Premium Story Detail page for subscribed user")
    @Test
    public void verifyAdsRemovedSubscribedUserPremiumPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyAdsRemovedSubscribedUserPremiumPage");
        isStepTrue = loginPage.loginWithSubScribedUser(paramsMap.values().toArray(new String[3]));
        Assert.assertTrue(isStepTrue, "Login failed");
        isStepTrue = premiumStoryPage.checkAdsRemovedPremiumPage();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1327(ios_native):Verify Ads are Visible on Premium Story Detail page for unsubscribed user")
    @Test
    public void verifyAdsPresentPremiumPage() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkAdsPresentPremiumPage();
        Assert.assertTrue(isStepTrue, "More From Section Widget verification failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1333(ios_native),QAAUT-1251(android_native):Verify the open page after switching the screen")
    @Test
    public void verifyPageSwitching() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyPageSwitching");
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = premiumStoryPage.checkPageSwitching(paramsMap.get("email"),paramsMap.get("password"),paramsMap.get("premiumText"));
        Assert.assertTrue(isStepTrue, "Page Switching verification failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Facebook Failed!!");
    }

    @Author(name = "Shakeel Alam,Giridhar Raj")
    @Description("QAAUT-1309(ios_native),QAAUT-1227(android_native):Verify text to speech feature not available on premium story")
    @Test
    public void verifyTextToSpeechNotPresent() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkTextToSpeechNotPresent();
        Assert.assertTrue(isStepTrue, "Text to Speech verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1307(ios_native):Verify in story functionality for text to speech")
    @Test
    public void verifyTextToSpeechPresent() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkTextToSpeechPresent();
        Assert.assertTrue(isStepTrue, "Text to Speech verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1291(ios_native):Verify listing story navigation")
    @Test
    public void verifyMintPremiumWidgetListingStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.mintPremiumWidgetListingStory();
        Assert.assertTrue(isStepTrue, "Text to Speech verification failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1226(android_native):Verify text to speech feature not available on story with paywall")
    @Test
    public void verifyTextToSpeechFeatureNotAvailableOnStoryWithPaywall() {
        boolean isStepTrue;
        isStepTrue = storyPage.TextToSpeechFeatureNotPresentOnStoryWithPaywall();
        Assert.assertTrue(isStepTrue, "Text to Speech verification failed");
    }



}

