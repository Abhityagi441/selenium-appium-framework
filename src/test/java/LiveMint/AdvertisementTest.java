package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonAdvertisementPage;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

class AdvertisementTest extends BaseTest {
    private static CommonAdvertisementPage advertisementPage;
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;

    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        advertisementPage = CommonAdvertisementPage.getInstance();
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();

    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-1726(android_native), QAAUT-1725(ios_native): Verify the Ads on Home page ")
    @Test
    public void verifyAdsOnHomePage() {
        boolean isStepTrue;
        isStepTrue = advertisementPage.checkAdsOnHomePage();
        Assert.assertTrue(isStepTrue, "Ads on homepage is not present after Recommended Carousel");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1728(android_native): Verify the Ads on Section page")
    @Test
    public void verifyAdsOnSectionPage() {
        boolean isStepTrue;
        isStepTrue = advertisementPage.checkAdsOnSectionPage();
        Assert.assertTrue(isStepTrue, "Ads on Section Page is not displayed after stories");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1781(android_native): Tap on Sponsered Story")
    @Test
    public void verifySponsoredAds() {
        boolean isStepTrue;
        isStepTrue = advertisementPage.checkSponsoredAd();
        Assert.assertTrue(isStepTrue, "Sponsored Ads verification failed");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1997(ios_native), QAAUT-2051(android_native): Verify Leads ads on the home page")
    @Test
    public void verifyTheLeadAdsOnHomePage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyTheLeadAdsOnHomePage");

        isStepTrue = advertisementPage.checkLeadsAdsOnHomePage();
        Assert.assertTrue(isStepTrue, "Leads ads on home page verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1998,1999(ios_native), QAAUT-2052,2053(android_native): Verify Remove ads functionality and back button")
    @Test
    public void verifyRemoveAdsFunctionalityAndBackButtonOnPlanPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRemoveAdsFunctionalityAndBackButtonOnPlanPage");

        isStepTrue = advertisementPage.checkRemoveAdsFunctionalityAndBackButton();
        Assert.assertTrue(isStepTrue, "remove ads functionality and back button verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2002,2003(ios_native), QAAUT-2054,2055(android_native): Verify banner ads (story Listing page between the stories)Remove ads functionality and back button")
    @Test
    public void verifySecondAdsRemoveAdsFunctionalityAndBackButtonOnPlanPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySecondAdsRemoveAdsFunctionalityAndBackButtonOnPlanPage");

        isStepTrue = advertisementPage.checkSecondAdsRemoveAdsFunctionalityAndBackButton();
        Assert.assertTrue(isStepTrue, "second ads remove ads functionality and back button verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2005(ios_native), QAAUT-2056(android_native): Verify Remove ads functionality and back button on company section")
    @Test
    public void verifyRemoveAdsFunctionalityOnCompanyPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRemoveAdsFunctionalityOnCompanyPage");

        isStepTrue = advertisementPage.checkRemoveAdsFunctionalityOnTopicPage();
        Assert.assertTrue(isStepTrue, "Remove ads functionality Company page verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2009(ios_native), QAAUT-2102(android_native): Verify Remove ads functionality and back button on section page (latest,trending)")
    @Test
    public void verifyRemoveAdsFunctionalityOnLatestAndTrendingPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRemoveAdsFunctionalityOnLatestAndTrendingPage");

        isStepTrue = advertisementPage.checkRemoveAdsFunctionalityOnLatestAndTrendingPage();
        Assert.assertTrue(isStepTrue, "Remove ads functionality latest & Tending page verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-2017(ios_native), QAAUT-2100(android_native): Verify Remove ads functionality and back button on story Detail page (latest,trending)")
    @Test
    public void verifyRemoveAdsFunctionalityOnStoryDetailPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRemoveAdsFunctionalityOnStoryDetailPage");

        isStepTrue = advertisementPage.checkRemoveAdsFunctionalityOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Remove ads functionality story Detail page verification failed ******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-14876: Verify Subscribed user Ads on web Home page")
    @Test
    public void VerifySubscribedUserAdsOnWebHomePage() {
        boolean isStepTrue;
        SoftAssert sa = new SoftAssert();
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("VerifySubscribedUserAdsOnWebHomePage");
        isStepTrue = loginPage.loginWithOTP(paramsMap.get("email"), paramsMap.get("apiURI"), paramsMap.get("accessAccount") , paramsMap.get("Cookie"),paramsMap.get("refreshAPI"));
        Assert.assertTrue(isStepTrue, "Login  feature on Home page failed ******");
        isStepTrue = advertisementPage.checkAdsOnSubscribedHomePage();
        sa.assertTrue(isStepTrue, "Subscriber Ads feature on Home page failed ******");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout  feature on Home page failed ******");
        sa.assertAll();
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-14876: Verify Subscribed user Ads on web story page")
    @Test
    public void VerifySubscribedUserAdsOnWebStoryPage() {
        boolean isStepTrue;
        SoftAssert sa = new SoftAssert();
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("VerifySubscribedUserAdsOnWebStoryPage");
        isStepTrue = loginPage.loginWithOTP(paramsMap.get("email"), paramsMap.get("apiURI"), paramsMap.get("accessAccount") , paramsMap.get("Cookie"),paramsMap.get("refreshAPI"));
        Assert.assertTrue(isStepTrue, "Login  feature on Home page failed ******");
        isStepTrue = advertisementPage.checkAdsOnSubscribedStoryPage();
        sa.assertTrue(isStepTrue, "Subscriber Ads feature on Story page failed ******");
        sa.assertAll();
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout feature on story page failed ******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-14876: Verify Subscribed user Ads on web latest page")
    @Test
    public void VerifySubscribedUserAdsOnWebLatestPage() {
        boolean isStepTrue;
        SoftAssert sa = new SoftAssert();
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("VerifySubscribedUserAdsOnWebLatestPage");
        isStepTrue = loginPage.loginWithOTP(paramsMap.get("email"), paramsMap.get("apiURI"), paramsMap.get("accessAccount") , paramsMap.get("Cookie"),paramsMap.get("refreshAPI"));
        Assert.assertTrue(isStepTrue, "Login  feature on Home page failed ******");
        isStepTrue = advertisementPage.checkAdsOnSubscribedlistingPage("latest");
        sa.assertTrue(isStepTrue, "Subscriber Ads feature on Latest page failed ******");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout feature on latest page failed ******");
        sa.assertAll();
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-14876: Verify Subscribed user Ads on web premium page")
    @Test
    public void VerifySubscribedUserAdsOnWebPremiumPage() {
        boolean isStepTrue;
        SoftAssert sa = new SoftAssert();
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("VerifySubscribedUserAdsOnWebPremiumPage");
        isStepTrue = loginPage.loginWithOTP(paramsMap.get("email"), paramsMap.get("apiURI"), paramsMap.get("accessAccount") , paramsMap.get("Cookie"),paramsMap.get("refreshAPI"));
        Assert.assertTrue(isStepTrue, "Login feature on Home page failed ******");
        isStepTrue = advertisementPage.checkAdsOnSubscribedlistingPage("premium");
        sa.assertTrue(isStepTrue, "Subscriber Ads feature on Premium page failed ******");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout feature on premium page failed ******");
        sa.assertAll();
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-14876: Verify Subscribed user Ads on web news page")
    @Test
    public void VerifySubscribedUserAdsOnWebNewsPage() {
        boolean isStepTrue;
        SoftAssert sa = new SoftAssert();
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("VerifySubscribedUserAdsOnWebPremiumPage");
        isStepTrue = loginPage.loginWithOTP(paramsMap.get("email"), paramsMap.get("apiURI"), paramsMap.get("accessAccount") , paramsMap.get("Cookie"),paramsMap.get("refreshAPI"));
        Assert.assertTrue(isStepTrue, "Login feature on Home page failed ******");
        isStepTrue = advertisementPage.checkAdsOnSubscribedlistingPage("News");
        sa.assertTrue(isStepTrue, "Subscriber Ads feature on News page failed ******");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout feature on news page failed ******");
        sa.assertAll();
    }

    @Author(name = "Gulshan Tomar,Giridhar raj")
    @Description("QAAUT-2212 (android_native),QAAUT-2249, 2259,2260, 2255 (ios_native): Verify that the first Interstitial Ads is showing on tapping of Second story.")
    @Test
    public void verifyFirstInterstitialAds() {
        boolean isStepTrue;
        isStepTrue = advertisementPage.checkFirstInterstitialAds();
        Assert.assertTrue(isStepTrue, "First Interstitial Ads verification failed ******");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-2230, 2231 (android_native),QAAUT-2259,2260(ios_native): Verify that there is an Interstitial Ads showing full screen after pre-define intervals/Verify that there are 2 Interstitial Ads add showing on the App per session")
    @Test
    public void verifySecondInterstitialAds() {
        boolean isStepTrue;
        isStepTrue = advertisementPage.checkSecondInterstitialAds();
        Assert.assertTrue(isStepTrue, "Second Interstitial Ads verification failed ******");
    }

    @Author(name = "Gulshan Tomar,Giridhar Raj")
    @Description("QAAUT-2236 (android_native),QAAUT-2255(ios_native): Verify that the second Interstitial Ads is showing on tapping of 6th Story")
    @Test
    public void verifySecondInterstitialAd() {
        boolean isStepTrue;
        isStepTrue = advertisementPage.checkSecondInterstitialAds();
        Assert.assertTrue(isStepTrue, "Second Interstitial Ad verification after 6th story failed ******");
    }

}