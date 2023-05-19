
package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.android_native.MarketPage;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonSubscriptionPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

class HomePageTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    private static CommonSubscriptionPage subscriptionPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        subscriptionPage = CommonSubscriptionPage.getInstance();
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1193(android_native): Verify Livemint logo is present")
    @Test
    public void verifyLiveMintLogoPresent() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLiveMintLogoPresent");
        isStepTrue = homePage.checkMintLogo();
        Assert.assertTrue(isStepTrue, "Live Mint logo is not present");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1194(android_native): Verify the Mint logo location.")
    @Test
    public void verifyLiveMintLogoLocation() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLiveMintLogoLocation");
        isStepTrue = homePage.checkMintLogoLocation();
        Assert.assertTrue(isStepTrue, "Live Mint logo location is failed.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1195(android_native): Verify the Epaper link.")
    @Test
    public void verifyEpaperLink() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyEpaperLink");
        isStepTrue = homePage.checkMintEPaperBanner();
        Assert.assertTrue(isStepTrue, "E-paper link verification is failed.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1196(android_native): Verify the Subscription.")
    @Test
    public void verifySubscriptionPlan() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySubscriptionPlan");
        isStepTrue = homePage.checkEPaperNonSubscribedUser();
        Assert.assertTrue(isStepTrue, "Subscription verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1200(android_native): Verify the SignIn Link.")
    @Test
    public void verifySignInLink() {
        boolean isStepTrue;
        isStepTrue = homePage.checkSignInLink();
        Assert.assertTrue(isStepTrue, "Sign In Link verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1198(android_native): Verify the Subscribe Link.")
    @Test
    public void verifySubscribeLinkOnHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkSubscribeLink();
        Assert.assertTrue(isStepTrue, "Subscribe Link verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1199(android_native): Verify the Subscribe Redirection.")
    @Test
    public void verifySubscribeRedirection() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySubscribeRedirection");
        isStepTrue = homePage.checkSubscribeRedirection(paramsMap.get("choosePlan"));
        Assert.assertTrue(isStepTrue, "Subscribe Redirection verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1201(android_native): Verify the Sign in Link Redirection.")
    @Test
    public void verifySignInLinkRedirectionFlow() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySignInLinkRedirectionFlow");
        isStepTrue = homePage.checkSignInLinkRedirection(paramsMap.get("loginRegisterText"), paramsMap.get("google"), paramsMap.get("facebook"), paramsMap.get("apple"), paramsMap.get("emailOrMobile"));
        Assert.assertTrue(isStepTrue, "Sign in Link Redirection verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1211(android_native): Verify the WSJ listed story navigation.")
    @Test
    public void VerifyListedStoryNavigationWSJCarausol() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("VerifyListedStoryNavigationWSJCarausol");
        isStepTrue = homePage.checkStoryNavigationWSJCrousel(paramsMap.get("text"));
        Assert.assertTrue(isStepTrue, "WSJ Listed story navigation verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1218(android_native): Verify Bottom navigation.")
    @Test
    public void VerifyBottomNavigation() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBottomNavigationSection();
        Assert.assertTrue(isStepTrue, "Bottom navigation verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1202(android_native): Verify My account Link.")
    @Test
    public void VerifyMyAccountLink() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkMyAccountLink();
        Assert.assertTrue(isStepTrue, "My account Link verification is failed.");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1203(android_native): Verify Subscribe Link For UnSubscribe User")
    @Test
    public void VerifySubscribeLinkForUnSubscribeUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1206(android_native): Verify Subscribed User ads free home page")
    @Test
    public void VerifySubscribedUserAdsFreeHomepage() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = homePage.subscribedUserAdsFreeHomepage();
        Assert.assertTrue(isStepTrue, "Subscribed user ads free home page verification is failed.");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1217,1197(android_native): Verify EPaper for Subscribe User")
    @Test
    public void verifyEPaperSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkEPaperSubscribedUser();
        Assert.assertTrue(isStepTrue, "E Paper for Subscribed User verification failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1207(android_native): Verify different story on home page")
    @Test
    public void verifyDifferentStoryForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");

        isStepTrue = subscriptionPage.checkNonLoggedInUserStories();
        Assert.assertTrue(isStepTrue, "Non loggedIn user story verification is failed.");

        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = subscriptionPage.checkSubscribedUserStories();
        Assert.assertTrue(isStepTrue, "subscribed user story verification failed");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1297 :Verify navigation by clicking on the mint genie banner")
    @Test
    public void verifyMintGenieBannerNavigation() {
        boolean isStepTrue;
        isStepTrue = homePage.checkMintGenieBanner();
        Assert.assertTrue(isStepTrue, "Mint Genie verification failed");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1711(ios_native),QAAUT-1710 (Android Native: Verify home page")
    @Test
    public void verifyHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePage();
        Assert.assertTrue(isStepTrue, "Home Page verification failed");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1712(ios_native) QAAUT-2004 (android_native): Validate subscribed user ads free app")
    @Test
    public void verifySubscribedUserLoginAdsFreeApp() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");
        isStepTrue = homePage.subscribedUserAdsFreeApp();
        Assert.assertTrue(isStepTrue, "Ads Free app for Subscribed user verification failed*****");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1780(ios_native), QAAUT-2010(android_native): Verify sponsored story")
    @Test
    public void verifySponsoredStory() {
        boolean isStepTrue;
        isStepTrue = homePage.sponsoredStory();
        Assert.assertTrue(isStepTrue, "Home Page Sponsored story verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1833(android_native): Verify the Bookmark functionality before Login")
    @Test
    public void verifyBookmarkFunctionalityBeforeLogin() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBookmarkBeforeLogin();
        Assert.assertTrue(isStepTrue, "Bookmark Functionality before login failed");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-1771(android_native),QAAUT-2157,2187(ios_native): Verify the Branded content on Home page with non-logged user")
    @Test
    public void verifyBrandedContent() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBrandedContent();
        Assert.assertTrue(isStepTrue, "Branded Content is not Displayed");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1990(ios_native), QAAUT-2011(android_native): Verify app refresh functionality")
    @Test
    public void verifyRefreshFunctionality() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRefreshFunctionality");

        isStepTrue = homePage.checkAppRefreshFunctionality();
        Assert.assertTrue(isStepTrue, "App refresh verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1992(ios_native), QAAUT-2012(android_native): Verify app refresh functionality on home page")
    @Test
    public void verifyNewArticlesOnHomePageOnly() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNewArticlesOnHomePageOnly");

        isStepTrue = homePage.checkNewArticlesOnlyOnHomePage();
        Assert.assertTrue(isStepTrue, "New Articles verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1993,1995(ios_native), QAAUT-2013,2014(android_native): Verify InVisibility Of NewArticle On Home Page After Click On NewArticle")
    @Test
    public void verifyInVisibilityOfNewArticlesOnHomePageAfterClick() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyInVisibilityOfNewArticlesOnHomePageAfterClick");

        isStepTrue = homePage.checkInVisibilityOfNewArticleOnHomePageAfterClickOnNewArticle();
        Assert.assertTrue(isStepTrue, "New Articles invisibility verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1994(ios_native), QAAUT-2015(android_native): Verify InVisibility Of NewArticle On Home Page After refreshing the home page")
    @Test
    public void verifyInVisibilityOfNewArticlesAfterRefreshingHomePage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyInVisibilityOfNewArticlesAfterRefreshingHomePage");

        isStepTrue = homePage.checkInVisibilityOfNewArticleAfterRefreshedHomePage();
        Assert.assertTrue(isStepTrue, "New Articles invisibility after refresh home page verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2153(ios_native), QAAUT-2188(android_native): verify the bookmark button on home page sponsored story")
    @Test
    public void verifyTheBookmarkButtonSponsoredStory() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyTheBookmarkButtonSponsoredStory");

        isStepTrue = homePage.checkInVisibilityOfSponsoredStoryBookmarkButtonHomePage();
        Assert.assertTrue(isStepTrue, "Sponsored story Bookmark button on home page verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2155(ios_native), QAAUT-2189(android_native): verify the sponsored story on home page with subscribed user")
    @Test
    public void verifySponsoredStoryWithSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");
        isStepTrue = homePage.checkInVisibilityOfSponsoredStoryOnHomePage();
        Assert.assertTrue(isStepTrue, "Sponsored story displayed verification failed*****");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2156(ios_native), QAAUT-2190(android_native): verify the sponsored story on home page with non-subscribed user")
    @Test
    public void verifySponsoredStoryWithNonSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySponsoredStoryWithNonSubscribedUser");

        isStepTrue = loginPage.loginWithNonSubScribedUser(paramsMap.values().toArray(new String[3]));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");
        isStepTrue = homePage.checkVisibilityOfSponsoredStoryOnHomePage();
        Assert.assertTrue(isStepTrue, "Sponsored story displayed verification failed*****");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2174(ios_native), QAAUT-2191(android_native): verify the sponsored story not on latest and trending")
    @Test
    public void verifySponsoredStoryOnTopicSectionAndStoryDetailPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySponsoredStoryOnTopicSectionAndStoryDetailPage");

        isStepTrue = homePage.checkInVisibilityOfSponsoredStoryOn();
        Assert.assertTrue(isStepTrue, "Sponsored story displayed verification failed*****");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2203,2204(ios_native), QAAUT-2207,2208 (android_native): verify the Advertisement And Remove Ads Position on first ads ")
    @Test
    public void verifyAdvertisementAndRemoveAdsPosition() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyAdvertisementAndRemoveAdsPosition");

        isStepTrue = homePage.checkAdvertisementLabelAndRemoveAdsButtonPosition(paramsMap.get("advertisement"), paramsMap.get("removeAd"));
        Assert.assertTrue(isStepTrue, "Advertisement and Remove ads position verification failed*****");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2206(ios_native), QAAUT-2209 (android_native) : verify remove ad button functionality ")
    @Test
    public void verifyRemoveAdButtonFunctionality() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRemoveAdButtonFunctionality");

        isStepTrue = homePage.checkRemoveAdButtonFunctionality();
        Assert.assertTrue(isStepTrue, "Remove Ad Button Functionality verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2773 (android_native),QAAUT-2789 (ios_native) : verify explore position ")
    @Test
    public void verifyExplorePosition() {
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyExplorePosition");
        boolean isStepTrue = homePage.checkExploreHamburgerPosition(paramsMap.get("iosExplorePos"), paramsMap.get("androidExplorePos"));
        Assert.assertTrue(isStepTrue, "Explore position verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2769 (android_native),QAAUT-2785 (ios_native) : verify news section ")
    @Test
    public void verifyNewsSectionReplacingLatestSection() {
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNewsSectionReplacingLatestSection");
        boolean isStepTrue = homePage.checkNewsSectionReplacingLatestSection();
        Assert.assertTrue(isStepTrue, "news section verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2739 (android_native),QAAUT-2746 (ios_native) : verify no ads on Home page for subscribed user ")
    @Test
    public void verifyNoAdsOnHomePageForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkNoAdsOnHomePage();
        Assert.assertTrue(isStepTrue, "ads on home page verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2764,2763,2761,2760,2759 (ios_native),QAAUT-2756,2753,2751,2752,2755(android_native) : verify news letter functionality and design ")
    @Test
    public void verifyNewsLetterFunctionalityAndDesign() {
        boolean isStepTrue = homePage.newsLetterFunctionalityAndDesign();
        Assert.assertTrue(isStepTrue, "news letters verification failed*****");

    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2744(ios_native),QAAUT-2737(android_native) : Ad for Subscribed user -Home Page")
    @Test
    public void verifyAdForSubscribedUserHomePage() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkAdOnHomePage();
        Assert.assertTrue(isStepTrue, "ads on home page verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2750,,2748(ios_native),QAAUT-2743,2741(android_native) : Ad on Story Detail page for Subscribed User for one and two story")
    @Test
    public void verifyAdOnStoryDetailPageForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkAdOnStoryDetailPagePage();
        Assert.assertTrue(isStepTrue, "Ad on Story Detail page for Subscribed User verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2772(android_native),QAAUT-2788(ios_native) : Explore as Hamburger")
    @Test
    public void verifyExploreAsHamburger() {
        boolean isTrue = homePage.checkExploreAsHamburger();
        Assert.assertTrue(isTrue, "Explore as Hamburger verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2771(android_native),QAAUT-2787(ios_native) : verify Explore remove from navigation")
    @Test
    public void verifyExploreRemoveFromNavigation() {
        boolean isTrue = homePage.checkExploreRemoveFromNavigation();
        Assert.assertTrue(isTrue, "Explore remove from navigation verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2775(android_native),QAAUT-2791(ios_native) : verify E-Paper Icon")
    @Test
    public void verifyEPaperIcon() {
        boolean isTrue = homePage.checkEPaperIcon();
        Assert.assertTrue(isTrue, "E-Paper Icon verification failed*****");

    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-2774(android_native) : verify Android - Subscribe icon")
    @Test
    public void verifySubscribeIcon() {
        boolean isTrue = homePage.checkSubscribeIcon();
        Assert.assertTrue(isTrue, "Is Subscribe Icon verification failed*****");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT- 2738(android_native) : Android - Subscribed user ")
    @Test
    public void verifySubscribedUser() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAdForSubscribedUserHomePage");

        boolean isStepTrue = homePage.checkSubscribeIcon();
        Assert.assertTrue(isStepTrue, "Subscribe Icon verification failed*****");

        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password failed");

        isStepTrue = homePage.checkSubscribedUser();
        Assert.assertTrue(isStepTrue, "Subscribe Icon and Ad verification on home page failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from LiveMint App failed!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2558 (android_native) : Android- Analytics- Verify that there is a Click event added on the News Letter Banner for Screen View")
    @Test
    public void verifyNewsLetterBanner() {
        boolean isStepTrue = homePage.checkNewsLetterBanner();
        Assert.assertTrue(isStepTrue, "Is Subscribe Icon verification failed*****");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2754 (android_native) : Android- Position of News Letter for Subscribed user")
    @Test
    public void verifyPositionOfNewsLetterForSubscribedUser() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAdForSubscribedUserHomePage");
        boolean isStepTrue;
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password failed");
        isStepTrue = homePage.checkPositionOfNewsLetterForSubscribedUser();
        Assert.assertTrue(isStepTrue, "News Letter position not present*****");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout from LiveMint App failed!!");
    }

    @Author(name = "Javed Alam")
    @Description("QAAUT-2402 (android_native),QAAUT-2412(ios_native) : Verify that the company related news is listing just below the Company info section")
    @Test
    public void verifycheckCompanyDetailPageRelatedNewsListing() {
        boolean isStepTrue = homePage.checkCompanyDetailPageRelatedNewsListing();
        Assert.assertTrue(isStepTrue, "Verify the company related news is listing just below the Company info section verification failed*****");
    }
    @Author(name = "Javed Alam")
    @Description("QAAUT-4105(android_native),QAAUT-4135(ios_native) : Verify that the Sub-title of Mutual fund page is Mutual Funds- top performers")
    @Test
    public void verifyverifycheckSubTitleoFMutualFundPage() {
        boolean isStepTrue = homePage.checkSubTitleoFMutualFundPage();
        Assert.assertTrue(isStepTrue, "Verify Sub-title of Mutual fund page is Mutual Funds- top performers verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4397(android_native),QAAUT-4415(ios_native): Verify New E-Paper icon")
    @Test
    public void verifyNewEPaperIcon() {
        boolean isStepTrue = homePage.checkNewEpaperIconOnTop();
        Assert.assertTrue(isStepTrue, "e-Paper icon verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4399(android_native),QAAUT-4417(ios_native): Verify New signIn icon")
    @Test
    public void verifyNewSignInIconOnTop() {
        boolean isStepTrue = homePage.checkNewSignInIconOnTop();
        Assert.assertTrue(isStepTrue, "sign-in icon verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4398(android_native),QAAUT-4416(ios_native): Verify New subscribe icon")
    @Test
    public void verifyNewSubscribeIconOnTop() {
        boolean isStepTrue = homePage.checkNewSubscribeIconOnTop();
        Assert.assertTrue(isStepTrue, "subscribe icon verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4400,4404(android_native),QAAUT-4418,4422(ios_native): Verify L1 Menu and all option with scrolling")
    @Test
    public void verifyL1TabOnHomePage() {
        boolean isStepTrue = homePage.checkL1TabOnHomePage();
        Assert.assertTrue(isStepTrue, "L1 Menu and all option verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4401(android_native),QAAUT-4419(ios_native): Verify L1 Tab selection")
    @Test
    public void verifyL1TabSelection() {
        boolean isStepTrue = homePage.checkL1TabSelection();
        Assert.assertTrue(isStepTrue, "L1 tab selection verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4402(android_native): Verify  L1 - Back button functionality")
    @Test
    public void verifyL1TabBackButtonFunctionality() {
        boolean isStepTrue = homePage.checkL1TabBackButtonFunctionality();
        Assert.assertTrue(isStepTrue, " L1 - Back button functionality verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4403(android_native),QAAUT-4421(ios_native): Verify  L1 - Tapping on Home - Bottom navigation")
    @Test
    public void verifyFocusOnL1TabClickingOnHomeButton() {
        boolean isStepTrue = homePage.checkFocusOnL1TabClickingOnHomeButton();
        Assert.assertTrue(isStepTrue, " L1- Tapping on Home - Bottom navigation verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4423(ios_native),QAAUT-4405(android_native): Verify  Left right Swipe on Home page")
    @Test
    public void verifyL1MenuSelectionBySwipingTheHomePage() {
        boolean isStepTrue = homePage.checkL1MenuSelectionBySwipingTheHomePage();
        Assert.assertTrue(isStepTrue, "Left right Swipe on Home page - Bottom navigation verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2378(android_native),QAAUT-4734(ios_native): Verify Ticker Category D")
    @Test
    public void verifyTickerCategoryD() {
        boolean isStepTrue = homePage.checkTickerCategoryD();
        Assert.assertTrue(isStepTrue, "Ticker Category D verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4408(android_native),QAAUT-4426(ios_native): Verify Section Name with all listed story")
    @Test
    public void verifySectionNameWithListedStory() {
        boolean isStepTrue = homePage.checkSectionNameWithListedStory();
        Assert.assertTrue(isStepTrue, "Section Name with all listed story verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2374(android_native): Verify Ticker Arrow")
    @Test
    public void verifyTickerArrow() {
        boolean isStepTrue = homePage.checkTickerArrow();
        Assert.assertTrue(isStepTrue, "Ticker arrow verification failed*****");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3226,QAAUT-3229,QAAUT-3219,QAAUT-3224,QAAUT-3227: Validate latest page scroll- iOS-Mweb")
    @Test
    public void verifyLatestPageScroll() {
        boolean isStepTrue = homePage.checkLatestScrollOnLatestNewsPage();
        Assert.assertTrue(isStepTrue, "Scroll Latest News verification failed*****");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-5753,QAAUT-5751,QAAUT-5752,QAAUT-5749,QAAUT-5744: Validate \"Mint 50 Top Mutual Funds\" topic page in hamburger")
    @Test
    public void verifyMintTop50MF() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMintTop50MF");
        boolean isStepTrue = homePage.checkMintTop50MF(params.get("pageTitle"));
        Assert.assertTrue(isStepTrue, "Mint Top 50 Mutual Funds News verification failed*****");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-5757,QAAUT-5758,QAAUT-5754,QAAUT-5761,QAAUT-5762: Validate \"Mint 50 Top Mutual Funds\" topic page in hamburger for subscribed")
    @Test
    public void verifyMintTop50MFForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyMintTop50MFForSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkMintTop50MFForSubscribedUsers(param.get("pageTitle"));
        Assert.assertTrue(isStepTrue, "Mint Top 50 Mutual Funds News for Subscribed user verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4753(android_native): Verify L1 Tab selection different story showing")
    @Test
    public void verifyL1TabSelectionDiffStory() {
        boolean isStepTrue = homePage.checkL1TabSelectionDiffStory();
        Assert.assertTrue(isStepTrue, "L1 tab selection verification failed*****");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-5484,QAAUT-5485,QAAUT-5486,QAAUT-5487,QAAUT-5488 : Validate columns Sub-section in TOP nav")
    @Test
    public void verifyColumnsSubSectionInTopNav() {
        boolean isStepTrue = homePage.checkColumnsSubSectionInTopNav();
        Assert.assertTrue(isStepTrue,"Columns sub-section is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-5597,QAAUT-5596,QAAUT-5595,QAAUT-5594: Validate MF section in TOP nav")
    @Test
    public void verifyMFSectionInTopNav() {
        boolean isStepTrue = homePage.checkMFSectionInTopNav();
        Assert.assertTrue(isStepTrue,"Mutual Funds section is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-5699,QAAUT-5700,QAAUT-5701,QAAUT-5702: Validate News subsection in Top Nav")
    @Test
    public void verifyNewsSubSectionUnderMFInTopNav() {
        boolean isStepTrue = homePage.checkNewsSubsectionUnderMFInTopNav();
        Assert.assertTrue(isStepTrue,"News sub-section is not validated");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-5411,QAAUT-5412,QAAUT-5413,QAAUT-5414,QAAUT-5415: Validate Industry page layout")
    @Test
    public void verifyIndustryPageLayout() {
        boolean isStepTrue = homePage.checkIndustryPageLayout();
        Assert.assertTrue(isStepTrue,"Industry section is not validated");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-5128,QAAUT-5127,QAAUT-5005,QAAUT-5006: Validate Views Sub-section page Top Nav")
    @Test
    public void verifyViewsSubsectionPage() {
        boolean isStepTrue = homePage.checkViewsSubsectionUnderOpinionInTopNav();
        Assert.assertTrue(isStepTrue,"Views sub-section is not validated");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-5139,QAAUT-5138,QAAUT-5137,QAAUT-5136, QAAUT-5135: Validate Views Sub-section page story details")
    @Test
    public void verifyViewsSubsectionStoryPage() {
        boolean isStepTrue = homePage.checkViewsSubsectionStoryPage();
        Assert.assertTrue(isStepTrue,"Views sub-section story page is not validated");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-4999,QAAUT-4998,QAAUT-4997,QAAUT-4996,QAAUT-4994: Validate Views Sub-section page layout")
    @Test
    public void verifyViewsSubsectionPageLayout() {
        boolean isStepTrue = homePage.checkViewsSubsectionPageLayout();
        Assert.assertTrue(isStepTrue,"Views sub-section page layout is not validated");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-4742,QAAUT-4741,QAAUT-4740,QAAUT-4739: Validate OPINION section in TOP nav")
    @Test
    public void verifyOpinionsectionTopNav() {
        boolean isStepTrue = homePage.checkOpinionsSectionInTopNav();
        Assert.assertTrue(isStepTrue,"Opinion section in top nav is not validated");
    }

    @Author(name = "Ravinder Kuamr")
    @Description("QAAUT-4218,QAAUT-4219,QAAUT-4220,QAAUT-4221,QAAUT-4222: Validate breadcrumb functionality on companies page")
    @Test
    public void verifyBreadcrumbOnCompaniesPage() {
        boolean isStepTrue = homePage.checkBreadcrumbOnCompaniesPage();
        Assert.assertTrue(isStepTrue,"Breadcrumb functionality on companies page is not validate");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-3777,QAAUT-3778,QAAUT-3779: Validate clicking on Twitter icon open Twitter pop up")
    @Test
    public void verifyTwitterPageWhenTapOnTwitterIcon() {
        boolean isStepTrue = homePage.checkTwitterPageWhenTapOnTwitterIcon();
        Assert.assertTrue(isStepTrue,"Twitter page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-3780,QAAUT-3781,QAAUT-3782: Validate clicking on linked in icon open linked in pop up")
    @Test
    public void verifyLinkedinPageWhenTapOnLinkedinIcon() {
        boolean isStepTrue = homePage.checkLinkedinPageWhenTapOnLinkedinIcon();
        Assert.assertTrue(isStepTrue,"Linkedin page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-3774,QAAUT-3775,QAAUT-3776: Validate clicking on facebook icon open facebook pop up")
    @Test
    public void verifyFacebookPageWhenTapOnFacebookIcon() {
        boolean isStepTrue = homePage.checkFacebookPageWhenTapOnFacebookIcon();
        Assert.assertTrue(isStepTrue,"Facebook page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-4704,QAAUT-4705,QAAUT-4918,QAAUT-4917,QAAUT-4919: Validate OPINION section story details")
    @Test
    public void verifyOpinionSectionStoryDetails() {
        boolean isStepTrue = homePage.checkOpinionSectionStoryDetails();
        Assert.assertTrue(isStepTrue,"Facebook page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-5832,QAAUT-5833,QAAUT-5834: Validate Shareholding widget")
    @Test
    public void verifyShareholdingWidget() {
        boolean isStepTrue = homePage.checkShareholdingWidget();
        Assert.assertTrue(isStepTrue,"Shareholding widget is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-4208,QAAUT-4209,QAAUT-4210,QAAUT-4211,QAAUT-4212: Validate Companies landing Page")
    @Test
    public void verifyCompaniesLandingPage() {
        boolean isStepTrue = homePage.checkCompaniesLandingPage();
        Assert.assertTrue(isStepTrue,"Companies landing page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-4202,QAAUT-4203,QAAUT-4204: Validate Podcast Episode page")
    @Test
    public void verifyPodcastEpisodePage() {
        boolean isStepTrue = homePage.checkPodcastEpisodePage();
        Assert.assertTrue(isStepTrue,"Podcast episode page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-4205,QAAUT-4206,QAAUT-4207: Validate Podcast Episode")
    @Test
    public void verifyPodcastEpisode() {
        boolean isStepTrue = homePage.checkPodcastEpisode();
        Assert.assertTrue(isStepTrue,"Podcast episode is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-4943,QAAUT-4944,QAAUT-4945,QAAUT-4946,QAAUT-4947: Validate video listing landing page's structure")
    @Test
    public void verifyVideoListingLandingPageStructure() {
        boolean isStepTrue = homePage.checkVideoListingLandingPageStructure();
        Assert.assertTrue(isStepTrue,"Video listing structure is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-6228,QAAUT-6229,QAAUT-6230: Validate Author details page")
    @Test
    public void verifyAuthorDetailsPage() {
        boolean isStepTrue = homePage.checkAuthorDetailsPage();
        Assert.assertTrue(isStepTrue,"Author details page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-6225,QAAUT-6226,QAAUT-6227,LM-20003(Bug): Validate Author page layout")
    @Test
    public void verifyAuthorPageLayout() {
        boolean isStepTrue = homePage.checkAuthorPageLayout();
        Assert.assertTrue(isStepTrue,"Author page layout is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-6235,QAAUT-6236,QAAUT-6237,QAAUT-6238,QAAUT-6239: Validate Sports landing Page")
    @Test
    public void verifySportsLandingPage() {
        boolean isStepTrue = homePage.checkSportsLandingPage();
        Assert.assertTrue(isStepTrue,"Sports landing page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-6241,QAAUT-6242,QAAUT-6243,QAAUT-6244,QAAUT-6245: Verify l1 nav on sports Landing Page")
    @Test
    public void verifyL1NavInSportsLandingPage() {
        boolean isStepTrue = homePage.checkL1NavInSportsLandingPage();
        Assert.assertTrue(isStepTrue,"L1 nav on sports landing page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-6026,QAAUT-6027,QAAUT-6028,QAAUT-6029,QAAUT-6030: Validate the Mint Premium carousel on home page")
    @Test
    public void verifyMintPremiumCarousel() {
        boolean isStepTrue = homePage.checkMintPremiumCarousel();
        Assert.assertTrue(isStepTrue,"Mint premium carousel on home page is not displaying");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-6271,QAAUT-6272,QAAUT-6273,QAAUT-6274,QAAUT-6275: Validate Summary on sports story page")
    @Test
    public void verifySummaryOnSportsStoryPage() {
        boolean isStepTrue = homePage.checkSummaryOnSportsStoryPage();
        Assert.assertTrue(isStepTrue,"Summary on sports story page verification failed");
    }

    @Author(name = "Ravinder Kumar")
    @Description("QAAUT-6266,QAAUT-6267,QAAUT-6268,QAAUT-6269,QAAUT-6270: Validate Paragraph on sports page")
    @Test
    public void verifyParagraphOnSportsPage() {
        boolean isStepTrue = homePage.checkParagraphOnSportsPage();
        Assert.assertTrue(isStepTrue,"Paragraph on sports story page verification failed");
    }
}
