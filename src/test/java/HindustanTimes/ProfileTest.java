package HindustanTimes;

import com.annotation.Author;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonProfilePage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;
import com.annotation.Description;

import java.util.Map;

public class ProfileTest extends BaseTest {
    private static CommonProfilePage profilePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        profilePage = CommonProfilePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1733, 1735(iOS), QAAUT-1734(Anddroid_native):Verify that user can edit the password from Edit Profile")
    @Test
    public void verifyEditPassword() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEditPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        Map<String, String> params2 = globalVars.getParamsDataSinglePropertySingleProperty("verifyEditPassword");
        isStepTrue = profilePage.checkEditProfilePage(params2.get("password"), params2.get("newPassword"));
        Assert.assertTrue(isStepTrue, "Reset Password Failed!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
        /*isStepTrue = loginPage.loginWithPassword(params2.get("email"), params2.get("newPassword"), params2.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and New Password Failed");
        isStepTrue = profilePage.checkPasswordRevert(params2.get("password"), params2.get("newPassword"));
        Assert.assertTrue(isStepTrue, "Reset to Original Password Failed!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");*/
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1748(iOS),QAAUT-1749(Android-native): Verify that user can change the gender to female")
    @Test
    public void verifyEditGender() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = profilePage.checkEditGender();
        Assert.assertTrue(isStepTrue, "Edit Gender Failed!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1742(iOS-Native):Verify that pencil button is displayed for Mobile number when the user is logged in with mobile number")
    @Test
    public void verifyPencilButtonDisplayedMobileNumber() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPencilButtonDisplayedMobileNumber");
        isStepTrue = loginPage.loginWithOTP(params.get("mobile"), params.get("apiURI"), params.get("auth"), params.get("mode"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with OTP failed");
        isStepTrue = profilePage.checkPencilButton();
        Assert.assertTrue(isStepTrue, "PencilButton Display Failed!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with OTP failed!!");

    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1741(iOS),QAAUT-1740(Android-Native): Verify that when user is edit their name then the changes will be displayed in the Profile")
    @Test
    public void verifyEditName() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEditName");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        isStepTrue = profilePage.checkEditName(params.get("newUserName"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Edit Gender Failed!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1809(iOS): Verify the redirection on tapping About Us")
    @Test
    public void verifyAboutUsRedirection() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkAboutUsRedirection();
        Assert.assertTrue(isStepTrue, "Edit Gender Failed!!");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1804(iOS): Verify that in About Hindustan Times section three options like About us, Privacy Policy, Contact US is displayed")
    @Test
    public void verifyAboutHTOptions() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkAboutHTOptions();
        Assert.assertTrue(isStepTrue, "Edit Gender Failed!!");

    }

    @Author(name = "Harsh Sharma,Ravinder Singh")
    @Description("QAAUT-1836(Android-native),QAAUT-1853: Verify the redirection on tapping Download Now button for Mint when app is installed.")
    @Test
    public void verifyRedirectionForMintAppByTapDownload() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionForMintAppByTapDownload();
        Assert.assertTrue(isStepTrue, "Redirection on Live is failed.");

    }

    @Author(name = "Harsh Sharma, Ravinder Singh")
    @Description("QAAUT-1834(Android-native),QAAUT-1830: Verify the redirection on tapping Download Now button for Hindustan when app is not installed.")
    @Test
    public void verifyRedirectionForHindustanAppByTapDownload() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionForHindustanAppByTapDownload();
        Assert.assertTrue(isStepTrue, "Redirection to App Store/Play Store is failed.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1828(Android-native): Verify that when user taps on Explore Apps than Hindustan, Mint and Healthshots option is displayed.")
    @Test
    public void verifyExploreAppsPageDisplayHindustanLiveMintHealthshotsApp() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkExploreAppsPageDisplayHindustanLiveMintHealthshotsApp();
        Assert.assertTrue(isStepTrue, "Hindustan, Mint and Healthshots app is not display on Explore Apps page.");

    }

    @Author(name = "Harsh Sharma,Ravinder Singh")
    @Description("QAAUT-1857(Android-native),QAAUT-1855: Verify the redirection on tapping Download Now button for Healthshots when app is not installed.")
    @Test
    public void verifyRedirectionForHealthShotsAppByTapDownload() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionForHealthShotsAppByTapDownload();
        Assert.assertTrue(isStepTrue, "Redirection to App Store/Play Store is failed.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1826(Android-native): Verify the redirection on tapping Explore Apps.")
    @Test
    public void verifyRedirectionTapOnExploreApps() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionTapOnExploreApps();
        Assert.assertTrue(isStepTrue, "Explore Apps redirection is failed.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1822(Android-native), QAAUT-1821(iOS): Verify the redirection on tapping Contact Us.")
    @Test
    public void verifyRedirectionTapOnContactUs() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionTapOnContactUs();
        Assert.assertTrue(isStepTrue, "Contact Us redirection is failed.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1820(Android-native), QAAUT-1819(iOS): Verify the redirection on tapping Privacy Policy.")
    @Test
    public void verifyRedirectionTapOnPrivacyPolicy() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionTapOnPrivacyPolicy();
        Assert.assertTrue(isStepTrue, "Privacy Policy redirection is failed.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1810(Android-native): Verify the redirection on tapping About Us.")
    @Test
    public void verifyRedirectionTapOnAboutUs() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionTapOnAboutUs();
        Assert.assertTrue(isStepTrue, "About Us redirection is failed.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1805(Android-native): Verify that in About Hindustan Times section three options like About us, Privacy Policy, Contact US is displayed.")
    @Test
    public void verifyAboutHindustanTimesHaveAboutUsPrivacyPolicyContactUs() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkAboutHindustanTimesHaveAboutUsPrivacyPolicyContactUs();
        Assert.assertTrue(isStepTrue, "About Hindustan Times section do not have any option available.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1791(Android-native): Verify the redirection on tapping back arrow on Display & Text Size page.")
    @Test
    public void verifyRedirectionByBackArrowFromDisplayAndTextSizePage() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkRedirectionByBackArrowFromDisplayAndTextSizePage();
        Assert.assertTrue(isStepTrue, "Redirection for Profile page display is failed.");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1796, QAAUT-1790 :: (iOS): Verify that by default Text Size is Medium")
    @Test
    public void verifyDefaultTextSize() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkDefaultTextSize();
        Assert.assertTrue(isStepTrue, "Verify Default Text Size Failed!!");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1861(Android-Native): Verify that after the Liked the App section, Build Version is displayed.")
    @Test
    public void verifyBuildVersionDisplay() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkBuildVersionDisplay();
        Assert.assertTrue(isStepTrue, "Build version is not displaying.");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1797(Android-Native): Verify that by dafalut Text Size is Medium.")
    @Test
    public void verifyDefaultTextSizeIsMedium() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkDefaultTextSizeIsMedium();
        Assert.assertTrue(isStepTrue, "Default text size in not medium!!!!!!");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1860(iOS): Verify that after the Liked the App section, Build Version is displayed")
    @Test
    public void verifyBuildVersionDisplayed() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkBuildVersionDisplayed();
        Assert.assertTrue(isStepTrue, "Build Version Display Failed!!");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1827, QAAUT-1825(iOS): Verify that when user taps on Explore Apps than Hindustan, Mint and Healthshots option is displayed")
    @Test
    public void verifyExploreAppsOption() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkExploreAppsOption();
        Assert.assertTrue(isStepTrue, "Explore Apps Verification Failed!!");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1823 (iOS): Verify that Liked the App section has four options like Share App, Rate App, Explore Apps, Feedback")
    @Test
    public void verifyLikedAppSection() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkLikedAppSection();
        Assert.assertTrue(isStepTrue, "Liked App SectionVerification Failed!!");

    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2022 (Android-native) ,QAAUT-2107(iOS) : Verify that Bookmarks option is displayed on the Profile Page under the My Feed")
    @Test
    public void verifyBookmarkOptionOnProfilePage() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkBookmarkOptionOnProfilePage();
        Assert.assertTrue(isStepTrue, "Bookmarks option is not displaying!!!");

    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2025 (Android-native), QAAUT-2178 (iOS): Verify the redirection when user taps on the Bookmarks option")
    @Test
    public void verifyBookmarkOptionRedirectionPage() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkBookmarkOptionRedirectionPage();
        Assert.assertTrue(isStepTrue, "Bookmarks redirection is failed!!!");

    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-2028 (Android-native), QAAUT-2028(iOS): Verify the appearance of the Bookmark page when no Article is saved")
    @Test
    public void verifyBookmarkOptionRedirectionHaveNoBookmarks() {
        boolean isStepTrue;
        isStepTrue = profilePage.checkBookmarkOptionRedirectionHaveNoBookmarks();
        Assert.assertTrue(isStepTrue, "Bookmarks redirection Page is not empty!!!");

    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1859(Android-native): Verify that on the Dark Mode, Images of the Hindustan, Mint and Healthshots should match with the design")
    @Test
    public void verifyDarkModeOfExploreAppsPage() {
        boolean isStepTrue,isDarkThemeSelected,isExploreAppsImagesDisplayed;
        isStepTrue = profilePage.checkRedirectionByBackArrowFromDisplayAndTextSizePage();
        Assert.assertTrue(isStepTrue, "Redirection for Profile page display is failed.");
        isDarkThemeSelected = profilePage.selectDarkThemeAndBackToHomePage();
        Assert.assertTrue(isDarkThemeSelected, "Redirection for Home page from Dark theme display is failed.");
        isExploreAppsImagesDisplayed = profilePage.checkExploreAppsPageDisplayHindustanLiveMintHealthshotsApp();
        Assert.assertTrue(isExploreAppsImagesDisplayed, "Hindustan, Mint and Healthshots app is not display on Explore Apps page.");

    }
}
