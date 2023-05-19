package Subscription;

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

public class EditProfileTest extends BaseTest {
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

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5981(android_native): verify user is able to edit the profile - Add/ update email/ mobile")
    @Test
    public void verifyEditProfile() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        boolean isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Non-Subscribed user login verification Failed*******");

        isStepTrue = homePage.checkEditProfileGender();
        Assert.assertTrue(isStepTrue, "profile gender verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6213(android_native): To ensure paywalls and ads are shown to a non subscribed user only")
    @Test
    public void verifyPaywallAdsAds() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        boolean isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Non-Subscribed user login verification Failed*******");

        isStepTrue = premiumStoryPage.checkPaywallAndAds();
        Assert.assertTrue(isStepTrue, "paywall & ads verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-6214(android_native): To ensure paywalls and ads are not shown to a subscribed user")
    @Test
    public void verifyNoPaywallAdsAdsForSubscribedUser() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        boolean isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = premiumStoryPage.checkNoPaywallAndAdsForSubscribedUser();
        Assert.assertTrue(isStepTrue, "paywall & ads verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout failed!!");
    }


}