package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonPremiumStoryPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class  LMPremiumPageTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    private static CommonPremiumStoryPage premiumStoryPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        premiumStoryPage=CommonPremiumStoryPage.getInstance();
    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-807(mweb ios):Verify LM Premium page")
    @Test
    public void verifyLMPremiumPage() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLMPremiumPage");
        String[] paramsArray =new String[2];
        paramsArray[0]=params.get("expectedBackgroundColorProperty");
        paramsArray[1]=params.get("expectedBorderLeftProperty");
        isStepTrue = homePage.checkLMPremiumPage(paramsArray);
        Assert.assertTrue(isStepTrue, "LM PremiumPage verification failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1247,1245(android_native) :Verify ads present on premium page")
    @Test
    public void verifyAdsVisibleOnPremiumStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue=premiumStoryPage.checkAdsPresentPremiumPage();
        Assert.assertTrue(isStepTrue, "ads present on Premium Page failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1249 (android_native):Verify ads not present on premium story detail page")
    @Test
    public void verifyAdsNotVisibleOnPremiumStoryDetailPage() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");
        isStepTrue = premiumStoryPage.subscribedUserAdsFreePremiumStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Ads free Premium story detail page verification failed..");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1248 (android_native):Verify ads not present on premium listing page")
    @Test
    public void verifyAdsNotVisibleOnPremiumListingPage() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");
        isStepTrue = premiumStoryPage.subscribedUserAdsFreePremiumListingPage();
        Assert.assertTrue(isStepTrue, "Ads free Premium listing page verification failed..");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1244 (android_native):Verify ads not present on premium listing page")
    @Test
    public void verifyAdsRemovedFromPremiumListingPage() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkAdsRemovedPremiumPage();
        Assert.assertTrue(isStepTrue, "Ads free premium page verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1246(android_native) :Verify ads not present on premium listing page for logged user")
    @Test
    public void verifyAdsRemovedFromPremiumListingPageForLoggedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyAdsRemovedFromPremiumListingPageForLoggedUser");
        isStepTrue = loginPage.loginWithNonSubscribedUser(paramsMap.get("email"),paramsMap.get("password"),paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "login with non-Subscribed user verification is failed.");

        isStepTrue = premiumStoryPage.nonSubscribedUserAdsFreePremiumListingPage();
        Assert.assertTrue(isStepTrue, "Ads free premium listing page verification is failed.");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1799: (ios_native)Verify back button")
    @Test
    public void verifyBackButton() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkBackButton();
        Assert.assertTrue(isStepTrue, "Back button verification is failed.");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4318(Web),QAAUT-4319(Android_Web),QAAUT-4320(iOS_Web),QAAUT-4321(Android_Amp),QAAUT-4322(iOS_Amp): Validate Premium page Sub nav tabs")
    @Test
    public void verifySubNavTabsOnPremiumPage() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageSubNavTabs();
        Assert.assertTrue(isStepTrue, "Premium page Sub nav verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5939:(android_native) Verify ads not present on story detail page by subscribed user")
    @Test
    public void verifyAdsNotPresentOnStoryDetailPage() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");
        isStepTrue = premiumStoryPage.checkAdsNotPresentOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Ads not verification is failed.");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5937:(android_native) Verify premium sticker present on story detail page")
    @Test
    public void verifyPremiumStickerOnStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumStickerPresentOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "premium sticker not present verification is failed.");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5937:(android_native) Verify premium sticker not present on story detail page")
    @Test
    public void verifyPremiumStickerDisappearOnStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumStickerDisappearOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "premium sticker present verification is failed.");
    }

}

