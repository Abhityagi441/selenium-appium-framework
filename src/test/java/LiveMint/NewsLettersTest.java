package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonNewsLettersPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;


public class NewsLettersTest extends BaseTest {

    private static CommonNewsLettersPage newslettersPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        newslettersPage = CommonNewsLettersPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }


    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1921,1922,1923,1924(ios_native), QAAUT-1931,1932,1934,1935(android_native):Verify the NewsLetter Page Functionality, top section,News letter types and back button")
    @Test
    public void verifyNewsLetterPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNewsLetterPage");
        isStepTrue = newslettersPage.checkNewsLetterFunctionality();
        Assert.assertTrue(isStepTrue, "NewsLetter Functionality verification failed *******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1926(ios_native), QAAUT-1936(android_native):Verify the first NewsLetter all option")
    @Test
    public void verifyFreeNewsLetterAllOption() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyFreeNewsLetterAllOption");
        isStepTrue = newslettersPage.checkFirstNewsLettersOption();
        Assert.assertTrue(isStepTrue, "Free NewsLetter all option verification failed *******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1927(ios_native), QAAUT-1937(android_native):Verify the Free NewsLetter Types")
    @Test
    public void verifyFreeNewsLetterTypes() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyFreeNewsLetterTypes");
        isStepTrue = newslettersPage.checkFreeNewsLettersTypes();
        Assert.assertTrue(isStepTrue, "Free NewsLetter types verification failed *******");
    }

    @Author(name = "Gulshan Tomar, Giridhar Raj")
    @Description("QAAUT-1947(android_native),QAAUT-1949(ios_native): Verify the Preview functionality for non login user")
    @Test
    public void verifyNewsLetterPreviewFunctionality() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNewsLetterPreviewFunctionality");

        isStepTrue = newslettersPage.checkPreviewFunctionality();
        Assert.assertTrue(isStepTrue, "News Letter Preview Functionality verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1960(ios_native), QAAUT-2106(android_native): Verify the Preview functionality for non Subscribed user")
    @Test
    public void verifyNewsLetterPreviewFunctionalityForNonSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkPreviewFunctionality();
        Assert.assertTrue(isStepTrue, "News Letter Preview Functionality for non subscribed user verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1961(ios_native), QAAUT-2110 (android_native): Verify the Preview functionality for Subscribed user")
    @Test
    public void verifyNewsLetterPreviewFunctionalityForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkPreviewFunctionality();
        Assert.assertTrue(isStepTrue, "News Letter Preview Functionality for subscribed user verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1962(ios_native), QAAUT-2111 (android_native): Verify the subscribed Popup for Free newsLetters")
    @Test
    public void verifyLoginPopForSubscribeFreeNewsLetters() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginPopForSubscribeFreeNewsLetters");

        isStepTrue = newslettersPage.checkLoginPopUpForSubscribeFreeNewsLetters();
        Assert.assertTrue(isStepTrue, "Subscribed button login popup for free newsLetters verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1968(ios_native), QAAUT-2112 (android_native): Verify the subscribed popup for Paid newsLetters")
    @Test
    public void verifyLoginPopUpForSubscribePaidNewsLetters() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginPopUpForSubscribePaidNewsLetters");

        isStepTrue = newslettersPage.checkLoginPopUpForSubscribePaidNewsLetters();
        Assert.assertTrue(isStepTrue, "Subscribed button login popup for Paid newsLetters verification failed ******");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1971(ios_native), QAAUT-2113 (android_native): Verify Plan page for paid new letters unsubscribed user")
    @Test
    public void verifyPlanPageForPaidNewsLetterForUnSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkPlanPageForPaidNewsLettersSubscribeButton();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1972(ios_native), QAAUT-2114(android_native): Verify subscribed tag free letters unsubscribed user")
    @Test
    public void verifySubscribedTagFreeNewsLetterForUnSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkSubscribedTagAndClickOnUnsubscribed();
        Assert.assertTrue(isStepTrue, "unsubscribed tag verification failed ******");
        isStepTrue = newslettersPage.checkSubscribedTagForFreeNewsLetters();
        Assert.assertTrue(isStepTrue, "subscribed Tag verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1973(ios_native), QAAUT-2151, QAAUT- 2167 (android_native): Verify subscribed tag free letters Subscribed user")
    @Test
    public void verifySubscribedTagFreeNewsLetterForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkSubscribedTagAndClickOnUnsubscribed();
        Assert.assertTrue(isStepTrue, "unsubscribed tag verification failed ******");

        isStepTrue = newslettersPage.checkSubscribedTagForFreeNewsLetters();
        Assert.assertTrue(isStepTrue, "subscribed Tag verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1974(ios_native), QAAUT- 2168 (android_native): Verify subscribed tag Paid letters Subscribed user")
    @Test
    public void verifySubscribedTagPaidNewsLetterForSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkSubscribedTagForPaidNewsLetters();
        Assert.assertTrue(isStepTrue, "subscribed Tag verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Giridhar Raj, Gulshan Tomar")
    @Description("QAAUT-1982(ios_native), QAAUT-1946(android_native): Verify privacy policy news letters page")
    @Test
    public void verifyPrivacyPolicyNewsLetterPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyPrivacyPolicyNewsLetterPage");
        isStepTrue = newslettersPage.checkPrivacyPolicyNewsLetters();
        Assert.assertTrue(isStepTrue, "Privacy policy verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1983(ios_native): Verify Re-Login Functionality")
    @Test
    public void verifyReLoginFunctionality() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyReLoginFunctionality");

        isStepTrue = loginPage.loginWithPassword(paramsMap.values().toArray(new String[3]));
        Assert.assertTrue(isStepTrue, "Login failed *********");

        isStepTrue = newslettersPage.checkSubscribedTagForPaidAndFreeNewsLetters();
        Assert.assertTrue(isStepTrue, "subscribed Tag verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");

        isStepTrue = newslettersPage.checkNoSubscribedNewsLettersIsShowing();
        Assert.assertTrue(isStepTrue, "subscribe Tag verification failed ******");

        isStepTrue = loginPage.loginWithPassword(paramsMap.values().toArray(new String[3]));
        Assert.assertTrue(isStepTrue, "Login failed *********");

        isStepTrue = newslettersPage.checkSubscribedTagAndUnSubscribedPaidAndFreeNewsLetters();
        Assert.assertTrue(isStepTrue, "subscribed & unsubscribed Tag verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Arzoo Singh")
    @Description("LM-16721 (Desktop-web),LM-16722 (Andriod-Web),LM-16723 (iOS-Web): Verify Newsletters Page layout.")
    @Test
    public void verifyNewsletterPageLayout() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkNewsletterPageLayout();
        Assert.assertTrue(isStepTrue, "verify Newsletter PageLayout ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16724 (Desktop-web),LM-16725 (Andriod-Web),LM-16726 (ios-Web) :Verify the NewsLetter Page Layout For Subscribed ")
    @Test
    public void verifyNewsletterPageLayoutForSubscribedUsers() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyNewsletterPageLayoutForSubscribedUsers");
        isStepTrue =loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue,"login failed on newsletters page ");
        isStepTrue = newslettersPage.checkNewsletterPageLayoutForSubscribedUsers();
        Assert.assertTrue(isStepTrue, "Newsletter Page Layout for Subscribed Users");
        isStepTrue =loginPage.logout();
        Assert.assertTrue(isStepTrue,"logout failed on newsletters page ");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16782 (Desktop_web): Verify RHS on Newsletter Page .")
    @Test
    public void verifyRHSOnNewslettersSubscribedUsers() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyRHSOnNewslettersSubscribedUsers");
        isStepTrue= loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue,"login failed on newsletters page ");
        isStepTrue = newslettersPage.checkRHSOnNewslettersSubscribedUsers();
        Assert.assertTrue(isStepTrue, "RHS Should be displayed ******");
        isStepTrue=loginPage.logout();
        Assert.assertTrue(isStepTrue,"logout failed on newsletters page ");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16727 (Desktop-Web),LM-16728 (ios_web) ,LM-16729 (andriod_web): Verify Newsletters Top Nav.")
    @Test
    public void verifyNewslettersTopNav() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkNewslettersTopNav();
        Assert.assertTrue(isStepTrue, "Verify Top Nav Should be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16733 ) : Verify LHS On newsletters page.")
    @Test
    public void verifyLHSOnNewslettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkLHSOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "LHS Should be displayed ******");
    }

    @Author(name = "Arzoo Singh")
    @Description("LM-16730 (desktop_web),LM-16732 (andriod_web), LM-16731(ios_web) : Verify Top Of the Morning on newsletter page.")
    @Test
    public void verifyTOTMOnNewslettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkTOTMOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "LHS Should be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16739 (desktop_web),LM-16740 (andriod_web), LM-16741(ios_web): Verify Easynomics on newsletter page .")
    @Test
    public void verifyEasynomicsOnNewslettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkEasynomicsOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16736 (desktop_web),LM-16737 (andriod_web), LM-16738 (ios_web): Verify cryptonotes on newsletter page .")
    @Test
    public void verifyCryptoNotesOnNewslettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkCryptoNotesOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16742 (desktop_web),LM-16743 (andriod_web), LM-16744 (ios_web): Verify Company Outsider on newsletter page .")
    @Test
    public void verifyCompanyOutsiderOnNewslettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkCompanyOutsiderOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16745 (desktop_web),LM-16747 (andriod_web), LM-16748 (ios_web): Verify Ticker on newslette page .")
    @Test
    public void verifyTickerOnNewslettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkTickerOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16749 (desktop_web),LM-16750 (andriod_web), LM-16751 (ios_web): Verify  Saturday Feeling On newsletter page.")
    @Test
    public void verifySaturdayFeelingOnNewslettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkSaturdayFeelingOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16752 (desktop_web),LM-16754 (andriod_web), LM-16755(ios_web): Verify that the first Interstitial Ads is showing on tapping of Second story.")
    @Test
    public void verifyEditorChoiceOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkEditorChoiceOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16759 (desktop_web),LM-16760(andriod_web), LM-16761 (ios_web): Verify that the first Interstitial Ads is showing on tapping of Second story.")
    @Test
    public void verifyMintMoneyOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkMintMoneyOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16763 (desktop_web),LM-16764(andriod_web), LM-16765 (ios_web): Verify Mint Tech on newsleter  page .")
    @Test
    public void verifyMintTechOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkMintTechOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16766 (desktop_web),LM-16767 (andriod_web), LM-16768 (ios_web): Verify Mint Primer on newsletter page.")
    @Test
    public void verifyMintPrimerOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkMintPrimerOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16770 (desktop_web),LM-16771(andriod_web), LM-16772 (ios_web): Verify  Plains Fact On newsletter page.")
    @Test
    public void verifyPlainsFactOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkPlainsFactOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16773 (desktop_web),LM-16774 (andriod_web) LM-16775(ios_web): Verify Mark to Market on newsletter page.")
    @Test
    public void verifyMarkToMarketOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkMarkToMarketOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16776 (deskop_web),LM-16777 (andriod_web), LM-16778 (ios_web): Verify Twich on newsletter page.")
    @Test
    public void verifyTwichOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkTwichOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-16779 (desktop_web),LM-16780 (andriod_web), LM-16781 (ios_web): Verify like share subscribed on newsletter page.")
    @Test
    public void verifyLikeShareSuscribeOnNewslettersPageForSubscriberOnlyNewsletters() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkLikeShareSuscribeOnNewslettersPageForSubscriberOnlyNewsletters();
        Assert.assertTrue(isStepTrue, "Verify that all the content need to be displayed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3617,3618(android_native),QAAUT-3636,3637(ios_native): Verify NewsLetter on Home Page and newsletter title")
    @Test
    public void verifyNewsLetterOnHomePage() {
        boolean  isStepTrue = newslettersPage.checkNewsLetterCarouselTitleOnHomePage();
        Assert.assertTrue(isStepTrue, "News Letter on home page verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3619(android_native),QAAUT-3638(ios_native): Verify NewsLetter viewAll")
    @Test
    public void verifyNewsLetterViewAll() {
        boolean  isStepTrue = newslettersPage.checkNewsLetterViewAllButton();
        Assert.assertTrue(isStepTrue, "News Letter view all verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3620,3621,3622(android_native): Verify NewsLetter card design,card title,card image")
    @Test
    public void verifyNewsletterCardDesign() {
        boolean  isStepTrue = newslettersPage.checkNewsletterCardDesign();
        Assert.assertTrue(isStepTrue, "News Letter card design verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3628(android_native),QAAUT-3647(ios_native): Verify NewsLetter viewAll functionality")
    @Test
    public void verifyNewsLetterViewAllFunctionality() {
        boolean  isStepTrue = newslettersPage.checkNewsLetterViewAllFunctionality();
        Assert.assertTrue(isStepTrue, "News Letter view all functionality verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3626(android_native),QAAUT-3645(ios_native): Verify NewsLetter subscribe button design")
    @Test
    public void verifyNewsLetterSubscribeButtonDesign() {
        boolean  isStepTrue = newslettersPage.checkNewsletterSubscribeButton();
        Assert.assertTrue(isStepTrue, "News Letter subscribe button design verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3625,3629(android_native),QAAUT-3648,3644(ios_native): Verify NewsLetter Read button design and it's functionality")
    @Test
    public void verifyNewsLetterReadButtonAndFunctionality() {
        boolean  isStepTrue = newslettersPage.checkNewsletterReadButtonAndFunctionality();
        Assert.assertTrue(isStepTrue, "News Letter Read button and functionality verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3624(android_native): Verify NewsLetter Free Tag")
    @Test
    public void verifyNewsLetterFreeTag() {
        boolean  isStepTrue = newslettersPage.checkNewsletterFreeTag();
        Assert.assertTrue(isStepTrue, "News Letter Free Tag verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT- 3630 (android_native),QAAUT-3649(ios_native): Verify Free News Letter Subscribe by Non Logged in user")
    @Test
    public void verifyFreeNewsLetterSubscribeByNonLoggedInUser() {
        boolean   isStepTrue = newslettersPage.checkFreeNewsLetterSubscribeByNonLoggedInUser();
        Assert.assertTrue(isStepTrue, "Free News Letter Subscribe by Non Logged in user verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT- 3631 (android_native),QAAUT-3650(ios_native): Verify Free News Letter Subscribe by non-subscribed Logged in user")
    @Test
    public void verifyFreeNewsLetterSubscribeByLoggedInUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithNonSubscribedUser");
        isStepTrue = loginPage.loginWithOTPNonSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "non-Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkSubscribedTagAndClickOnUnsubscribed();
        Assert.assertTrue(isStepTrue, "unsubscribed tag verification failed ******");

        isStepTrue = newslettersPage.checkSubscribedTagByClickingOnSubscribeButton();
        Assert.assertTrue(isStepTrue, "Free News Letter Subscribe by Logged in user verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT- 3632(android_native),QAAUT-3651(ios_native): Verify Free News Letter Subscribe by subscribed user")
    @Test
    public void verifyFreeNewsLetterSubscribeBySubscribedUser() {
        boolean isStepTrue;
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailOTPWithSubscribedUser");
        isStepTrue = loginPage.loginWithOTPSubScribedUser(param.get("email"), param.get("apiURI"), param.get("accessAccount"), param.get("Cookie"), param.get("refreshAPI"), param.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Subscribed user login verification Failed*******");

        isStepTrue = newslettersPage.checkSubscribedTagAndClickOnUnsubscribed();
        Assert.assertTrue(isStepTrue, "unsubscribed tag verification failed ******");

        isStepTrue = newslettersPage.checkSubscribedTagByClickingOnSubscribeButton();
        Assert.assertTrue(isStepTrue, "Free News Letter Subscribe by subscribed user verification failed ******");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout Failed *********");
    }
    @Author(name = "Arzoo Singh")
    @Description("QAAUT- 3630 (android_native): Verify Free News Letter Subscribe by Non Logged in user")
    @Test
    public void verifyFreeSubscriptionFlowInCaseOfNonLoggedInUsers() {
        boolean isStepTrue = newslettersPage.checkFreeSubscriptionFlowInCaseOfNonLoggedInUsers();
        Assert.assertTrue(isStepTrue, "Free News Letter Subscribe by Non Logged in user verification failed ******");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT- 3627(android_native),QAAUT- 3646(ios_native): Verify Free News Letter Swipe functionality")
    @Test
    public void verifyFreeNewsLetterSwipeFunctionality(){
        boolean isTrue = newslettersPage.checkSwipeFunctionality();
        Assert.assertTrue(isTrue, "Free News Letter Swipe functionality verification failed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-17650(Web):Validate RHS for Newsletter page")
    @Test
    public void verifyRHSOnNewsLettersPage() {
        boolean isStepTrue;
        isStepTrue = newslettersPage.checkRHSOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "RHS verification failed");
    }

    @Author(name = "Arzoo Singh")
    @Description("LM-17651(Web): Verify Preview landing ")
    @Test
    public void verifyPreviewLinkOnNewslettersPage() {
        boolean  isStepTrue = newslettersPage.checkPreviewLinkOnNewslettersPage();
        Assert.assertTrue(isStepTrue, "Preview link verification failed ******");
    }
    @Author(name = "Arzoo Singh")
    @Description("LM-178801(Web),LM-17881(ios mweb),LM-17882(Andriod mweb): Verify Free Newsletters Subscription Flow ")
    @Test
    public void verifyFreeNewsLetterSubscriptionByNonLoggedInUser() {
        boolean  isStepTrue = newslettersPage.checkFreeNewsLetterSubscriptionByNonLoggedInUser();
        Assert.assertTrue(isStepTrue, "Free newsletters  link verification failed ******");
    }

    @Author(name = "Arzoo Singh")
    @Description("LM-17883(Web),LM-17884(ios mweb),LM-17889(andriod mweb): Verify Paid Newsletters Subscription Flow ")
    @Test
    public void verifyPaidNewsLetterSubscriptionByNonLoggedInUser() {
        boolean  isStepTrue = newslettersPage.checkPaidNewsLetterSubscriptionByNonLoggedInUser();
        Assert.assertTrue(isStepTrue, "Paid newsletters  link verification failed ******");
    }

    @Author(name = "Giridhar raj")
    @Description("QAAUT-3623(android_native): Verify Preview landing ")
    @Test
    public void verifyPremiumTag() {
        boolean  isStepTrue = newslettersPage.checkPremiumTag();
        Assert.assertTrue(isStepTrue, "Preview link verification failed ******");
    }

}