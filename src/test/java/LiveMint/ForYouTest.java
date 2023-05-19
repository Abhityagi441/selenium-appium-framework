package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonForYouPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

class ForYouTest extends BaseTest {
    private static CommonForYouPage forYouPage;
    private static CommonLoginPage loginPage;

    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        forYouPage = CommonForYouPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2705,2709(android_native),QAAUT-2734,2722(ios_native): verify ForYou Page and icon ")
    @Test
    public void verifyForYouPageAndIcon() {
        boolean   isTrue = forYouPage.checkForYouPageAndIcon();
        Assert.assertTrue(isTrue, "ForYou page and icon verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2706(android_native),QAAUT-2735(ios_native): verify No Banner Story On ForYou Page ")
    @Test
    public void verifyNoBannerStoryOnForYouPage() {
        boolean   isTrue = forYouPage.checkBannerStory();
        Assert.assertTrue(isTrue, "Banner story verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2710(android_native),QAAUT-2723(ios_native): verify ForYou Icon is Inactive ")
    @Test
    public void verifyForYouIconInactive() {
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyForYouIconInactive");

        boolean  isTrue = forYouPage.checkForYouIconInactive(paramsMap.get("forYouText"));
        Assert.assertTrue(isTrue, "ForYou Icon is Inactive verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2714,2716(android_native),QAAUT-2727,2729 (ios_native):: verify Share And Bookmark Icon for each story on ForYou Page ")
    @Test
    public void verifyShareAndBookmarkIconOnForYouPage() {
        boolean  isTrue = forYouPage.checkShareAndBookmarkIconOnForYouPage();
        Assert.assertTrue(isTrue, "Share & Bookmark icon verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2715,2717(android_native),QAAUT-2728,2730 (ios_native): verify Share And Bookmark On Story Detail Page")
    @Test
    public void verifyShareAndBookmarkOnStoryDetailPage() {
        boolean  isTrue = forYouPage.checkShareAndBookmarkStoryDetailPage();
        Assert.assertTrue(isTrue, "Share & Bookmark on story detail page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2713(android_native),QAAUT-2726 (ios_native): verify TextToSpeech Icon On Story Detail Page")
    @Test
    public void verifyTextToSpeechDetailPage() {
        boolean  isTrue = forYouPage.checkTextToSpeechOnStoryDetailPage();
        Assert.assertTrue(isTrue, "Text to speech on story detail page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2740 (android_native),QAAUT-2747 (ios_native) : verify no Ads on For you page for Subscribed user ")
    @Test
    public void verifyNoAdsOnSectionPageSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(params.get("email"), params.get("apiURI"), params.get("accessAccount") , params.get("Cookie"),params.get("refreshAPI"),params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = forYouPage.checkAdsOnForYouPage();
        Assert.assertTrue(isStepTrue, "Ads on For you page for Subscribed user verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2742(android_native),QAAUT-2749 (ios_native):: verify ads on story detail page ")
    @Test
    public void verifyAdOnStoryDetailPage() {
        boolean  isTrue = forYouPage.checkAdOnStoryDetailPage();
        Assert.assertTrue(isTrue, "ads on story detail page verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2731 (ios_native).QAAUT-2718 (android_native):: verify Ads on For you page for Non Subscribed user ")
    @Test
    public void verifyAdsOnForYouPageForNonSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(params.get("email"), params.get("apiURI"), params.get("accessAccount") , params.get("Cookie"),params.get("refreshAPI"),params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = forYouPage.checkAdsOnForYouPage();
        Assert.assertTrue(isStepTrue, "Ads on For you page for Non Subscribed user verification failed*****");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2721 (ios_native):: verify For You - No of Stories ")
    @Test
    public void verifyForYouNoOfStories() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyForYouNoOfStories");

        isStepTrue = forYouPage.checkForYouNoOfStories(paramsMap.get("noOfStories"));
        Assert.assertTrue(isStepTrue, "For You - No of Stories verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("QAAUT-3311(web),QAAUT-3318(android_web),QAAUT-3321(ios_mweb),QAAUT-3323(android_amp),QAAUT-3322(ios_amp): verify For You Page layout ")
    @Test
    public void verifyForYouPageLayout() {
        boolean isTrue= forYouPage.checkForYouLayout();
        Assert.assertTrue(isTrue, "For You Page layout verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("QAAUT-3337(web),QAAUT-3339(android_web),QAAUT-3340(ios_mweb),QAAUT-3341(android_amp),QAAUT-3342(ios_amp): verify For You LHS NAV links")
    @Test
    public void verifyLHSNAVLinks() {
        boolean isTrue= forYouPage.lHSNAVLinks();
        Assert.assertTrue(isTrue, " LHS NAV links On Home Page verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("QAAUT-3361(web): verify For You RHS NAV links  ")
    @Test
    public void verifyRHSNAVLinks() {
        boolean isTrue= forYouPage.rHSNAVLinks();
        Assert.assertTrue(isTrue, " RHS NAV links On FOR YOU Page verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-16786(web),LM-16787(android_web),LM-16788(ios_mweb): Verify For you page Layout- top nav for subscribed user  ")
    @Test
    public void verifycheckForYouLayoutsubScribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckForYouLayoutsubScribedUser");
        isStepTrue= loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue,"Login failed ForYou Layout Subscribed user");
        isStepTrue= forYouPage.checkForYouLayoutsubScribedUser();
        Assert.assertTrue(isStepTrue, "Subscribed user For You Page layout verification failed !!!!!!!");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue,"Subscribed user For You Page layout logout failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-16857(web),LM-16855(MwebAndroid),LM-16857(MwebiOS): verify For You RHS NAV links  ")
    @Test
    public void verifychecklHSNAVLinksforSubscribeduser() {
        boolean isStepTrue;

        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifychecklHSNAVLinksforSubscribeduser");
        isStepTrue=loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue,"Login failed for LHS");
        isStepTrue = forYouPage.checklHSNAVLinksforSubscribeduser();
        Assert.assertTrue(isStepTrue, "LHS NAV Links for Subscribeduser For You Page verification failed !!!!!!!");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue,"LHS logout failed");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-16847(web): verify For You RHS NAV links subscribed user  ")
    @Test
    public void verifycheckrHSNAVLinksforSubscribeduser() {
        boolean isStepTrue;

        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckrHSNAVLinksforSubscribeduser");
        isStepTrue=loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue,"Login failed for RHS");
        isStepTrue= forYouPage.checkrHSNAVLinksforSubscribeduser();
        Assert.assertTrue(isStepTrue, "RHS NAV Links for Subscribeduser For You Page verification failed !!!!!!!");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue,"RHS logout failed");

    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3663,3664(android_native),QAAUT-3674,3675(ios_native):: verify Story Detail page- Font Size at top & Bottom ")
    @Test
    public void verifyFontSizeAtTopAndBottomOnStoryDetailPage() {
        boolean  isTrue = forYouPage.checkFontSizeAtTopAndBottomOnStoryDetailPage();
        Assert.assertTrue(isTrue, "Story Detail page- Font Size at top & Bottom verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description(" LM-17611 (web),LM-17652(MwebAndroid),LM-17653(MwebiOS),LM-17654(AMP Android),LM-17703(AMP iOS): verify For You Story")
    @Test
    public void verifycheckFirstStoryForYou()
    {
        boolean isTrue = forYouPage.checkFirstStoryForYou();
        Assert.assertTrue(isTrue, "FOR YOU Story verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17704(web),LM-17705(MwebiOS),LM-17829(MwebAndroid): verify For You page story and tilte  subscribed user  ")
    @Test
    public void verifycheckFirstStoryForYouforSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckFirstStoryForYouforSubscribedUser");
        isStepTrue=loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue,"Login failed for RHS");
        isStepTrue= forYouPage.checkFirstStoryForYouforSubscribedUser();
        Assert.assertTrue(isStepTrue, "First story and tilte for Subscribeduser For You Page verification failed !!!!!!!");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue,"RHS logout failed");
    }


}