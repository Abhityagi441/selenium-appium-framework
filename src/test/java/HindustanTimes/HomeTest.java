package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class HomeTest extends BaseTest {
    private static CommonHomePage homePage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();

    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-511(web),QAAUT-534(mweb), QAAUT-620(amp), QAAUT-581(android native),601(iOS),558(IOSmWeb),642(iOSAMP): To verify epaper CTA: Logo, Redirection")
    @Test
    public void verifyEpaperCTALogoRedirection() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEpaperCTALogoRedirection");
        isStepTrue = homePage.checkEpaperCTALogoRedirection(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "checking epaper CTA logo has been Failed");
    }

    @Author(name = "Sambath Kumar,Priyanka Mittal")
    @Description("QAAUT-506(web),QAAUT-615(amp),QAAUT-529(mWeb), QAAUT-576(Android-Native),596(iOS),553(iOSMweb),637(iOSAMP): Home page loading verification: Verify left menu, HT logo, Hamburger, top news, scroll and Footer")
    @Test
    public void verifyHomePageLoadingVerification() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyHomePageLoadingVerification");
        isStepTrue = homePage.checkHomePageLoaded(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "HomePage Loaded has been Failed");
    }

    @Author(name = "Priyanka Mittal")
    @Description("QAAUT-899(iOSAMP): Home page loading verification: Verify left menu, HT logo, Hamburger, top news, scroll and Footer")
    @Test
    public void verifyHomePageLoadedVerification() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePageLoadingVerification();
        Assert.assertTrue(isStepTrue, "HomePage Loaded has been Failed");
    }


    @Author(name = " Ravi")
    @Description("QAAUT - 893: Liveblog: Verify content, pagination, popular and Embeds")
    @Test
    public void verifyLiveblogPaginationAndEmbeds() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLiveblogPaginationAndEmbeds");
        boolean isStepTrue = homePage.checkLiveblogPaginationEmbeds(params.get("title"));
        Assert.assertTrue(isStepTrue, "LiveBlog verification and Embeds not displayed");

    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-923: Premum Articles||Verify the Premium/Exclusive articles")
    @Test
    public void verifyPremiumArticlesExclusiveTag() {
        boolean isStepTrue = homePage.checkPremiumArtExclusiveTag();
        Assert.assertTrue(isStepTrue, "check Premium Articles Exclusive Tag has been failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1419 (WEB): To verify the L1")
    @Test
    public void verifyLeftPaneDisplayed() {
        boolean isStepTrue = homePage.checkLeftPaneDisplayed();
        Assert.assertTrue(isStepTrue, "Left Pane Displayed Failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1487 (WEB): To verify ads are clickable")
    @Test
    public void verifyTopAdAreClickable() {
        boolean isStepTrue = homePage.checkTopAdsClickable();
        Assert.assertTrue(isStepTrue, "Ads Displayed And Clickable Failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1607(iOs-web): HT AUTO Verify apperarance and on click event - on click of content and 'view all' button")
    @Test
    public void verifyHTAutoRedirection() {
        boolean isStepTrue = homePage.checkHTAutoRedirection();
        Assert.assertTrue(isStepTrue, "HT AUTO Verify apperarance and on click event - on click of content and 'view all' button failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1625(Android-native): Verify the behavior when user tap on the Maybe Later option")
    @Test
    public void verifyMayBeLaterOptionBehaviour() {
        boolean isStepTrue = homePage.checkMayBeLaterOptionBehaviour();
        Assert.assertTrue(isStepTrue, "Maybe Later option behavior failed.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1612(Android-native): Verify the redirection on tapping Profile option on the bottom nav")
    @Test
    public void verifyRedirectionOnTappingProfileNav() {
        boolean isStepTrue = homePage.checkRedirectionOnTappingProfile();
        Assert.assertTrue(isStepTrue, "The redirection on tapping Profile option on the bottom nav is failed.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1627(Android-native): Verify that when user enters the data in the Text Box then Text 'Email or Mobile Number' is displayed on the upper of the text box")
    @Test
    public void verifyEmailTextArea() {
        boolean isStepTrue = homePage.checkEmailTextArea();
        Assert.assertTrue(isStepTrue, "Login text area don't contains 'Email or Mobile Number'.");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1628(Android-native): Verify that user is able to enter the valid password in the Password type text box")
    @Test
    public void verifyPasswordTextArea() {
        boolean isStepTrue;
        isStepTrue = homePage.checkPasswordTextArea();
        Assert.assertTrue(isStepTrue, "Password text area not working");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1614(Android-native): Verify that on the top of the Profile page, HT Logo and Text Hindustan Times is displayed on the top right corner of the page")
    @Test
    public void verifyHindustanTimesLogo() {
        boolean isStepTrue = homePage.checkHindustanTimesLogoDisplayed();
        Assert.assertTrue(isStepTrue, "HindustanTimes Logo is not Diplayed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1642(Android-native): Verify the redirection on tapping Explore from the Home")
    @Test
    public void verifyRedirectionOnTappingExplore() {
        boolean isStepTrue = homePage.checkRedirectionOnTappingExplore();
        Assert.assertTrue(isStepTrue, "Redirection page of Explore button is failed.");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1645(Android-native):Verify that E-Paper and Search option is displayed on the Home Tab on the top right corner of the Home Tab")
    @Test
    public void verifyEpaperAndSearchOption() {
        boolean isStepTrue = homePage.checkEpaperAndSearchDisplayed();
        Assert.assertTrue(isStepTrue, "Epaper & Search Option are not Diplayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1646(Android-native):Verify that Header of the Home tab is displayed after the HT LOGO, E-Paper and Search option with Section Names")
    @Test
    public void verifyHomeTabHeader() {
        boolean isStepTrue = homePage.checkHomeTabHeader();
        Assert.assertTrue(isStepTrue, "HomeTab Section Name Header is not Diplayed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1681(iOS-native), QAAUT-1674(Android-native):Verify the redirection when user tap on Videos from Explore")
    @Test
    public void verifyRedirectionOnVideoFromExplore() {
        boolean isStepTrue = homePage.checkRedirectionOnVideoFromExplore();
        Assert.assertTrue(isStepTrue, "Redirection to Videos failed from Explore.");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1680(iOS-native), QAAUT-1673(Android-native):Verify the redirection when user tap on Photos from Explore")
    @Test
    public void verifyRedirectionOnPhotosFromExplore() {
        boolean isStepTrue = homePage.checkRedirectionOnPhotosFromExplore();
        Assert.assertTrue(isStepTrue, "Redirection to Photos failed from Explore.");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1869(Android-native), QAAUT-1868(iOS):Verify that for any section Home is highlighted in the Bottom nav.")
    @Test
    public void verifySectionHomeIsHighlightedInBottomNav() {
        boolean isStepTrue = homePage.checkSectionHomeIsHighlightedInBottomNav();
        Assert.assertTrue(isStepTrue, "Home button is not selected.");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1963(iOS-native), QAAUT-1996, 2836(Android-native), QAAUT-2354(iOS-Native):Verify the redirection on tapping Quickread from the Home")
    @Test
    public void verifyQuickReadsRedirection() {
        boolean isStepTrue = homePage.checkQuickReadsRedirection();
        Assert.assertTrue(isStepTrue, "redirection on tapping Quickread failed.");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1967(iOS-native),QAAUT-2000(Android-native):Verify the redirection on tapping Premium from the Home")
    @Test
    public void verifyPremiumRedirection() {
        boolean isStepTrue = homePage.checkPremiumRedirection();
        Assert.assertTrue(isStepTrue, "redirection on tapping Premium failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-1969 (iOS-native), QAAUT-2903 (Android-Native):Verify the redirection on tapping Profile from the Home")
    @Test
    public void verifyProfileRedirection() {
        boolean isStepTrue = homePage.checkProfileRedirection();
        Assert.assertTrue(isStepTrue, "redirection on tapping Profile failed.");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1970(iOS-native), QAAUT-2001(Android-native):Verify the redirection on tapping Explore from the Home, Verify that user can scroll from top to bottom on Top News section")
    @Test
    public void verifyExploreRedirection() {
        boolean isStepTrue = homePage.checkExploreRedirection();
        Assert.assertTrue(isStepTrue, "redirection on tapping Explore failed.");
    }


    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-1867(Android-native), QAAUT-1864(iOS):Verify that for any section Home is highlighted in the Bottom nav.")
    @Test
    public void verifySectionIndiaHighlit() {
        boolean isStepTrue = homePage.checkSectionIndiaHighlit();
        Assert.assertTrue(isStepTrue, "Home button is not selected.");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1988(Android-native), QAAUT-1899(iOS) :Verify that Get Personalized Experience Page is not displayed on every launching.")
    @Test
    public void verifyGetPersonalizedExperiencePageNotDisplay() {
        boolean isStepTrue = homePage.checkGetPersonalizedExperiencePageNotDisplay();
        Assert.assertTrue(isStepTrue, "Get Personalized Experience Page is Displaying!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1991(Android-native),QAAUT-1904(iOS) :Verify that on the Home Page, five Nav module like Home, Quickreads, Premium, Profile and Explore options are displayed.")
    @Test
    public void verifyAllBottomNavDisplay() {
        boolean isStepTrue = homePage.checkAllBottomNavDisplay();
        Assert.assertTrue(isStepTrue, "All bottom nav modules are not displaying!!!!!!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1866: (iOS-native):Verify that Trending Topics carousel is displayed on the Home Page")
    @Test
    public void verifyTrendingTopicsCarouselIsDispayed() {
        boolean isStepTrue = homePage.checkTrendingTopicsCarousel();
        Assert.assertTrue(isStepTrue, "TrendingTopicsCarousel verification failed.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2018(Android-native):Verify that tapping on Section or Subsection within the Story will be redirected to that Section.")
    @Test
    public void verifyTapOnSectionSubsectionRedirectToSectionPage() {
        boolean isStepTrue = homePage.checkTapOnSectionSubsectionRedirectToSectionPage();
        Assert.assertTrue(isStepTrue, "All subsection and section display is failed!!!!!!!");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-2044(iOS-native):Verify that after the Story on the Quickread Page, Text Swipe Up For Next Story is displayed")
    @Test
    public void verifyQuickReadsFunctionality() {
        boolean isStepTrue = homePage.checkQuickReadsFunctionality();
        Assert.assertTrue(isStepTrue, "Quickreads verification failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-2076, QAAUT-2092(iOS-native), QAAUT-2917 (Android-Native):Verify that second section on the Home Page is Don't Miss")
    @Test
    public void verifyDontMissOption() {
        boolean isStepTrue = homePage.checkDontMissOption();
        Assert.assertTrue(isStepTrue, "Don't Miss verification failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-2080(iOS-native), QAAUT-2082(Android-Native) :Verify that after the Second Ad, Cricket Section is displayed")
    @Test
    public void verifyCricketSection() {
        boolean isStepTrue = homePage.checkCricketSection();
        Assert.assertTrue(isStepTrue, "Cricket Section verification failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-2087(iOS-native), QAAUT-2924 (Android-Native):Verify that Photos section is displayed on the Home Page")
    @Test
    public void verifyPhotosSection() {
        boolean isStepTrue = homePage.checkPhotosSection();
        Assert.assertTrue(isStepTrue, "Photos Section verification failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-2088(iOS-native), QAAUT-2927 (Android-Native):Verify that Web Stories Carousel is displayed on the Home Page")
    @Test
    public void verifyWebStoriesSection() {
        boolean isStepTrue = homePage.checkWebStoriesSection();
        Assert.assertTrue(isStepTrue, "Web Stories Section verification failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-2090, QAAUT-2091 (iOS-native), QAAUT-2904 (Android-Native) :Verify that when user taps on three dots then a message box is displayed at the bottom of the Page")
    @Test
    public void verify3DotMsgBoxDisplayed() {
        boolean isStepTrue = homePage.check3DotMsgBoxDisplayed();
        Assert.assertTrue(isStepTrue, "Msg Box verification failed.");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-2095(iOS-native):Verify the behaviour when user taps on the \"X\" option on the Subscribe to Newsletter")
    @Test
    public void verifySubscribeToNewsletterBehaviour() {
        boolean isStepTrue = homePage.checkSubscribeToNewsletterBehaviour();
        Assert.assertTrue(isStepTrue, "Subscribe To Newsletter Behaviour verification failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhauliya")
    @Description("QAAUT-2093(iOS-native), QAAUT-2936(Android-native) : Verify that Most Read section is displayed on the Home Page")
    @Test
    public void verifyMostReadSection() {
        boolean isStepTrue = homePage.checkMostReadSection();
        Assert.assertTrue(isStepTrue, "Most read Section verification failed.");
    }

    @Author(name = "Shakeel Alam, Rohitashva Budhualiya")
    @Description("QAAUT-2094, QAAUT-2909(iOS-Native), QAAUT-2910 (Android-Native): Verify the behaviour when user taps on the Share option on Message Box")
    @Test
    public void verifyShareOption() {
        boolean isStepTrue = homePage.checkShareOption();
        Assert.assertTrue(isStepTrue, "Share Option verification failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhualiya")
    @Description("QAAUT-2838(Android-Native), QAAUT-2356(iOS-Native): Verify that only one story is displayed on the Quickread Page")
    @Test
    public void verifyQuickReadHaveOneStoryAtATime() {
        boolean isStepTrue = homePage.checkQuickReadHaveOneStoryAtATime();
        Assert.assertTrue(isStepTrue, "Quickread page contains more than one story!!!!!!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliuya")
    @Description("QAAUT-2851,2845 (Android-Native), QAAUT-2844, QAAUT-2850 (iOS-Native): Verify the behaviour when user swipe up from the First story >> Swipe down from the second story")
    @Test
    public void verifyQuickReadFirstAndSecondWithSwipe() {
        boolean isStepTrue = homePage.checkQuickReadFirstAndSecondWithSwipe();
        Assert.assertTrue(isStepTrue, "Swipe functionality for story on Quickread is failed!!!!!!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2843,2840 (Android-Native), QAAUT-2362, QAAUT-2358 (iOS-Native): Verify the redirection when user taps on the Read Full Story")
    @Test
    public void verifyQuickReadReadFullStoryRedirection() {
        boolean isStepTrue = homePage.checkQuickReadReadFullStoryRedirection();
        Assert.assertTrue(isStepTrue, "Read Full story redirection failed!!!!!!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2849 (Android-Native), QAAUT-2848 (iOS-Native): Verify that after swiping four story, a Ad is displayed")
    @Test
    public void verifyFirstAdAfter4StoriesInQuickReadPage() {
        boolean isStepTrue = homePage.checkFirstAdAfter4StoriesInQuickReadPage();
        Assert.assertTrue(isStepTrue, "Ad display after 4 story!!!!!!!!!!!!");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3681 (Android Native): Verify the behaviour when non logged in user taps on Subscribe button for Daily News CapsuleVerify the behaviour when non logged in user taps on Subscribe button for Daily News Capsule (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for Daily News Capsule")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnDailyNewsCapsule(){
    boolean isStepTrue;
    isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnDailyNewsCapsule();
    Assert.assertTrue(isStepTrue,"Daily news Capsule Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3682 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for Daily News Capsule")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnDailyNewsCapsule() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnDailyNewsCapsule");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnDailyNewsCapsule(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3683 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for @HT_Ed Calling")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnHTEdCalling(){
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourNonLoggedInUserSubscribeButtonOnHTEdCalling");
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnHTEdCalling();
        Assert.assertTrue(isStepTrue,"@HT_Ed Calling Subscribe button failed");
        }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3684 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for @HT_Ed Calling")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnHTEdCalling() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnHTEdCalling");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnHTEdCalling(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on @HT_Ed Calling failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
 }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3685 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for HT Wknd")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnHTWknd(){
        boolean isStepTrue;
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnHTWknd();
        Assert.assertTrue(isStepTrue,"HT Wknd Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3686 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for HT Wknd")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnHTWknd(){
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnHTWknd");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnHTWknd(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on HT Wknd failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }


    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT- 2837(Android-Native), QAAUT-2355 (iOS-Native): Verify the redirection when user taps on the View All link displayed on the Quickread carousel on the Home Page")
    @Test
    public void verifyViewAllLinkRightToQuickread() {
        boolean isStepTrue = homePage.checkViewAllLinkRightToQuickread();
        Assert.assertTrue(isStepTrue, "Quickreads redirection from HT home page is failed!!!!!!!!!!!!");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT- 2842(Android-Native), QAAUT-2360 (iOS-Native): Verify the redirection when user goes to the story details page from the quickread page and tap on the back button from the story details page")
    @Test
    public void verifyQuickreadsReadFullStoryRedirectionForBackpress() {
        boolean isStepTrue = homePage.checkQuickreadsReadFullStoryRedirectionForBackpress();
        Assert.assertTrue(isStepTrue, "Redirection back to Quickreads page is failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2359 (iOS-Native): Verify that after the share option on the Quickread Page, Description of the Story is displayed")
    @Test
    public void verifyShareOptionInQuickRead() {
        boolean isStepTrue = homePage.checkShareOptionInQuickRead();
        Assert.assertTrue(isStepTrue, "Share option on the Quickread Page failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2081 (iOS-Native), QAAUT- 2083(Android-Native): Verify the redirection on tapping view All link on Latest Video Carousel")
    @Test
    public void verifyTappingOnViewAllOnLatestVideoCarousel() {
        boolean isStepTrue = homePage.checkTappingOnViewAllOnLatestVideoCarousel();
        Assert.assertTrue(isStepTrue, "Redirection failed on tapping view All link on Latest Video Carousel!!!!!!!!!!!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1751- Verify the redirection when user taps on the E-Paper option when logged in")
    @Test
    public void verifyEPaperRedirectionOnHeaderForSignedInUser() {
        boolean isStepTrue;
        boolean iSEaperOpened;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        iSEaperOpened = homePage.checkEPaperOptionFromHeader();
        Assert.assertTrue(iSEaperOpened, "EPaper Opened Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2084 (iOS-Native), QAAUT- 2085(Android-Native): Verify the appearance of Latest Video carousel on Home Page")
    @Test
    public void verifyAppearanceOfLatestVideoCarousel() {
        boolean isStepTrue = homePage.checkAppearanceOfLatestVideoCarousel();
        Assert.assertTrue(isStepTrue, "Appearance Failed of Latest Video carousel on Home Page!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2078 (iOS-native), QAAUT-2079 (Android-Native)): Verify that at the End of the Don't Miss Section, Ad is displayed")
    @Test
    public void verifyAdAfterDontMissSection() {
        boolean isStepTrue = homePage.checkAdAfterDontMissSection();
        Assert.assertTrue(isStepTrue, "Ad display failed at the End of the Don't Miss Section.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2911 (iOS-native), QAAUT-2912 (Android-Native)): Verify that tapping on the Story, it is redirected to the respective Story details page")
    @Test
    public void verifyRedirectToRespectiveStory() {
        boolean isStepTrue = homePage.checkRedirectToRespectiveStory();
        Assert.assertTrue(isStepTrue, "Redirected to the respective Story details page failed!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2922 (iOS-Native), QAAUT- 2923(Android-Native): Verify the redirection on tapping any story on the Latest Video Carousel")
    @Test
    public void verifyRedirectToStoryFromLatestVideoCarousel() {
        boolean isStepTrue = homePage.checkRedirectToStoryFromLatestVideoCarousel();
        Assert.assertTrue(isStepTrue, "redirection failed on tapping any story on the Latest Video Carousel!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2925 (iOS-Native), QAAUT-2926(Android-Native): Verify the redirection on tappng any story inside the Latest Photos section on the Home Page Turn on screen reader support")
    @Test
    public void verifyRedirectToStoryFromPhotoCarousel() {
        boolean isStepTrue = homePage.checkRedirectToStoryFromPhotoCarousel();
        Assert.assertTrue(isStepTrue, "Redirection Failed on tappng any story inside the Latest Photos section on the Home Page Turn on screen reader support!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2930 (iOS-Native), QAAUT-2931 (Android-Native): Verify the redirection on tapping any story on the Web Stories Carousel")
    @Test
    public void verifyRedirectToStoryFromWebStoriesCarousel() {
        boolean isStepTrue = homePage.checkRedirectToStoryFromWebStoriesCarousel();
        Assert.assertTrue(isStepTrue, "Redirection Failed on tapping any story on the Web Stories Carousel!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2928 (iOS-Native), QAAUT-2929 (Android-Native): Verify the redirection on tapping View All link for Web Stories Carousel on the Home Page")
    @Test
    public void verifyViewAllFromWebStoriesCarousel() {
        boolean isStepTrue = homePage.checkViewAllFromWebStoriesCarousel();
        Assert.assertTrue(isStepTrue, "Redirection Failed on tapping any story on the Web Stories Carousel!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhualiya")
    @Description("QAAUT-2932 (iOS-native), QAAUT-2933 (Android-native) :Verify that Quickreads craousel is displayed on the Home Page")
    @Test
    public void verifyQuickReadsCraouselDisplayedOnHome() {
        boolean isStepTrue = homePage.checkQuickReadsCraouselDisplayedOnHome();
        Assert.assertTrue(isStepTrue, "Quickreads craousel is displayed on the Home Page failed !!!!!!!!!!!.");
    }

    @Author(name = "Rohitashva Budhualiya")
    @Description("QAAUT-2934 (iOS-native), QAAUT-2935 (Android-native) :Verify the redirection when user taps on any story displayed on Quickread carousel")
    @Test
    public void verifyRedirectToStoryFromQuickReadsCraousel() {
        boolean isStepTrue = homePage.checkRedirectToStoryFromQuickReadsCraousel();
        Assert.assertTrue(isStepTrue, "Redirection failed when user taps on any story displayed on Quickread carousel !!!!!!!!!!!.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3550(iOS-native), QAAUT-3551(Android-native) : Verify that Newsletters Carousel is displayed on the Home Page")
    @Test
    public void verifyNewslettersCarouselDisplayed() {
        boolean isStepTrue = homePage.checkNewslettersCarouselDisplayed();
        Assert.assertTrue(isStepTrue, "Newsletters Carousel display failed!!!!!.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3552(iOS-native), QAAUT-3553(Android-native) : Verify that user is able to scroll right to left and left to right on Newsletter Carousel")
    @Test
    public void verifyScrollRightToLeftAndLeftToRightOnNewsletters() {
        boolean isStepTrue = homePage.checkScrollrightToLeftAndLeftToRightOnNewsletters();
        Assert.assertTrue(isStepTrue, "Scroll right to left and left to right on Newsletter Carousel failed!!!!!.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3554(iOS-native), QAAUT-3555(Android-native) : Verify that first card is Daily News Capsule")
    @Test
    public void verifyFirstCardIsDailyNewsCapsuleOnNewsletters() {
        boolean isStepTrue = homePage.checkFirstCardIsDailyNewsCapsuleOnNewsletters();
        Assert.assertTrue(isStepTrue, "First card is Daily News Capsule failed!!!!!.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3556(iOS-native), QAAUT-3557(Android-native) : Verify that second card is @HT_ED Calling")
    @Test
    public void verifySecondCardIsHTEDCallingOnNewsletters() {
        boolean isStepTrue = homePage.checkSecondCardIsHTEDCallingOnNewsletters();
        Assert.assertTrue(isStepTrue, "Second card is @HT_ED Calling failed!!!!!.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3558(iOS-native), QAAUT-3559(Android-native) : Verify the redirection when uuser taps on Read Now")
    @Test
    public void verifyRedirectionWhenTabOnReadNowOnNewsletters() {
        boolean isStepTrue = homePage.checkRedirectionWhenTabOnReadNowOnNewsletters();
        Assert.assertTrue(isStepTrue, "Redirection when uuser taps on Read Now failed!!!!!.");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3816 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for HT Week Ahead")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnHTWeekAhead(){
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourNonLoggedInUserSubscribeButtonOnHTWeekAhead");
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnHTWeekAhead();
        Assert.assertTrue(isStepTrue,"HT Week Ahead Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3809 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for HT Week Ahead")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnHTWeekAhead() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnHTWeekAhead");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnHTWeekAhead(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on HT Week Ahead failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
 }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3811 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for HT Capital Letters")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnHTCapitalLetters(){
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourNonLoggedInUserSubscribeButtonOnHTCapitalLetters");
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnHTCapitalLetters();
        Assert.assertTrue(isStepTrue,"HT Capital Letters Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3813 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for HT Capital Letters")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnHTCapitalLetters() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnHTCapitalLetters");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnHTCapitalLetters(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on HT Capital Letters failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3815 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for Wired Wisdom")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnWiredWisdom(){
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourNonLoggedInUserSubscribeButtonOnWiredWisdom");
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnWiredWisdom();
        Assert.assertTrue(isStepTrue,"Wired Wisdom Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3810 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for Wired Wisdom")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnWiredWisdom() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnWiredWisdom");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnWiredWisdom(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on Wired Wisdom failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3812 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for HT City")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnHTCity(){
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourNonLoggedInUserSubscribeButtonOnHTCity");
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnHTCity();
        Assert.assertTrue(isStepTrue,"HT City Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3814 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for HT City")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnHTCity() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnHTCity");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnHTCity(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on HT City failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3914 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for HT Mind the Gap")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnHTMindTheGap() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourNonLoggedInUserSubscribeButtonOnHTMindTheGap");
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnHTMindTheGap();
        Assert.assertTrue(isStepTrue, "HT Mind the Gap Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3980 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for HT Mind the Gap")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnHTMindTheGap() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnHTMindTheGap");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnHTMindTheGap(params.get("email"));
        Assert.assertTrue(isStepTrue,"Subscribe on HT Mind the Gap failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3983 (Android_Native): Verify the behaviour when non logged in user taps on Subscribe button for HT Kick Off")
    @Test
    public void verifyBehaviourNonLoggedInUserSubscribeButtonOnHTKickOff() {
        boolean isStepTrue;
        isStepTrue = homePage.checkNonLoggedUserSubscribeButtonOnHTKickOff();
        Assert.assertTrue(isStepTrue, "HT Kick Off Subscribe button failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3984 (Android_Native): Verify the behaviour when logged in (Via Email ID) user taps on Subscribe button for HT KIck Off")
    @Test
    public void verifyBehaviourLoggedInUserSubscribeButtonOnHTKickOff() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserSubscribeButtonOnHTKickOff");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnHTKickOff(params.get("email"));
        Assert.assertTrue(isStepTrue,"Subscribe on HT Kick Off failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4002 (Android-Native) - QAAUT-4354 (iOS-Native): Verify that Recommended for you carousel is displayed in Home Page")
    @Test
    public void verifyRecommendedForYouCarouselOnHome() {
        boolean isStepTrue = homePage.checkRecommendedForYouCarouselOnHome();
        Assert.assertTrue(isStepTrue,"Recommended for You Section failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4003 (Android-Native) - QAAUT-4355 (iOS-Native): Verify that View All link is displayed on Recommended for You carousel")
    @Test
    public void verifyViewAllLinkOnRecommendedForYouCarousel() {
        boolean isStepTrue = homePage.checkViewAllLinkOnRecommendedForYouCarousel();
        Assert.assertTrue(isStepTrue,"View All link on Recommended for you page failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4004 (Android-Native) - QAAUT-4356 (iOS-Native): Verify the redirection when user taps on View All link for RFU Carousel")
    @Test
    public void verifyRedirectionWhenTapOnViewAllLinkFromRecommendedForYouCarousel() {
        boolean isStepTrue = homePage.checkRedirectionWhenTapOnViewAllLinkFromRecommendedForYouCarousel();
        Assert.assertTrue(isStepTrue,"Redirection on For You listing page failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4005 (Android-Native) - QAAUT-4357 (iOS-Native): Verify that For You Section is displayed in L1")
    @Test
    public void verifyForYouTabOnL1() {
        boolean isStepTrue = homePage.checkForYouTabOnL1();
        Assert.assertTrue(isStepTrue,"For you tab display failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4006 (Android-Native), QAAUT-4358(iOS--Native): Verify the redirection when user taps on any story displayed inside the RFU Carousel")
    @Test
    public void verifyRedirectionWhenTapOnStoryFromRecommendedForYouCarousel() {
        boolean isStepTrue = homePage.checkRedirectionWhenTapOnStoryFromRecommendedForYouCarousel();
        Assert.assertTrue(isStepTrue,"Redirection to Story from Recommended For You failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3880(Android),QAAUT-3879- Verify the behavior when logged in user taps on E-Paper option from Quickread Page")
    @Test
    public void verifyEPaperRedirectionFromQuickreadsPageOnHeaderForSignedInUser() {
        boolean isStepTrue;
        boolean iSEaperOpened;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        iSEaperOpened = homePage.checkEPaperOptionFromQuickReadHeader();
        Assert.assertTrue(iSEaperOpened, "EPaper Opened Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3878(Android)-QAAUT-3877(iOS native)  Verify the behavior when logged in user taps on E-Paper option from Home Page")
    @Test
        public void verifyEPaperRedirectionFromHomePageOnHeaderForSignedInUser() {
        boolean isStepTrue;
        boolean iSEaperOpened;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        iSEaperOpened = homePage.checkEPaperOptionFromHeader();
        Assert.assertTrue(iSEaperOpened, "EPaper Opened Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3874(Android), QAAUT-3873(iOS native)-  Verify the redirection on tapping back button from Daily Digest listing page")
    @Test
    public void verifyDailyDigestRedirection() {
        boolean isStepTrue;
        isStepTrue = homePage.checkDailyDigestRedirection();
        Assert.assertTrue(isStepTrue, "Daily Digest redirection Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3876(Android)- QAAUT-3875(iOS native)- Verify the redirection on tapping back button from Daily Digest listing page")
    @Test
    public void verifyDailyDigestSectionRedirection() {
        boolean isStepTrue;
        isStepTrue = homePage.checkDailyDigestSectionRedirection();
        Assert.assertTrue(isStepTrue, "Daily Digest section redirection Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3872(Android)-QAAUT-3871(iOS native)-   Verify the redirection on tapping any story on Daily Digest listing page")
    @Test
    public void verifyDailyDigestStoryRedirection() {
        boolean isStepTrue;
        isStepTrue = homePage.checkDailyDigestStoryRedirection();
        Assert.assertTrue(isStepTrue, "Daily Digest story redirection Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3870(Android)-QAAUT-3869(iOS native)-  Verify user able to share story from Daily Digest listing page\t\n")
    @Test
    public void verifyDailyDigestStoryShare() {
        boolean isStepTrue;
        isStepTrue = homePage.checkDailyDigestStoryShare();
        Assert.assertTrue(isStepTrue, "Daily Digest story share Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3820 (Android_Native), QAAUT-3819(iOS-native): Verify the behaviour when logged in user taps on 'x' after tapping on Subscribe button")
    @Test
    public void verifyBehaviourLoggedInUserOnCancelButtonOnDailyNewsCapsule() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserOnCancelButtonOnDailyNewsCapsule");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserCloseButtonOnDailyNewsCapsule();
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3838 (Android_Native), QAAUT-3837(iOS-native): Verify the redirection when user taps on back button from Daily News Capsule page")
    @Test
    public void verifyBehaviourLoggedInUserOnBackButtonOnDailyNewsCapsule() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBehaviourLoggedInUserOnBackButtonOnDailyNewsCapsule");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserBackButtonOnDailyNewsCapsule();
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3817(iOS-native), QAAUT-3818(AndroidNative):Verify the behaviour when non logged in user taps on \"x\" after tapping on Subscribe button")
    @Test
    public void verifyTabOnXInSubscribeToNewsletterBehaviour() {
        boolean isStepTrue = homePage.checkTabOnXInSubscribeToNewsletterBehaviour();
        Assert.assertTrue(isStepTrue, "behaviour when non logged in user taps on x after tapping on Subscribe button failed.");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3868 (Android_Native): Verify the redirection when user taps on Privacy Policy link displayed in bottom action sheet after tapping on subscibe button")
    @Test
    public void verifyPrivacyPolicyLinkOnDailyNewsCapsule() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPrivacyPolicyLinkOnDailyNewsCapsule");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkPrivacyPolicyLinkOnDailyNewsCapsule();
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3832 (Android_Native): Verify the content in bottom action sheet displayed after tapping on Subscribe button for logged in user")
    @Test
    public void verifyEmailAddressNewsLetterTextOnDailyNewsCapsule() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEmailAddressNewsLetterTextOnDailyNewsCapsule");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkEmailAddressNewslettersTextOnDailyNewsCapsule();
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3830 (Android_Native): Verify that if user is logged in with Email ID then after tapping on Subscribe button, email id is prefilled in the text box")
    @Test
    public void verifyEmailAddressIsPrefilledOnDailyNewsCapsule() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEmailAddressIsPrefilledOnDailyNewsCapsule");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkEmailIsPreFilledTextOnDailyNewsCapsule(params.get("email"));
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue,"Logout Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3834 (Android_Native), QAAUT-3833 (iOS_Native): Verify the content in bottom action sheet displayed after tapping on Subscribe button for non logged in user")
    @Test
    public void verifyTextOnSubscribeNewsLetterForNonLoggedInUser() {
        boolean isStepTrue;
        isStepTrue = homePage.checkTextOnNewsLetterForNonLoggedInUser();
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3830 (Android_Native): Verify that if user is logged in with Email ID then after tapping on Subscribe button, email id is prefilled in the text box")
    @Test
    public void verifyNewsLetterSubscribeOnDailyNewsCapsuleForMobileNumberLoggedInUser() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNewsLetterSubscribeOnDailyNewsCapsuleForMobileNumberLoggedInUser");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with email failed");
        isStepTrue = homePage.checkLoggedInUserSubscribeButtonOnDailyNewsCapsule(params.get("emailId"));
        Assert.assertTrue(isStepTrue, "Subscribe on Daily News Capsule failed");
        //isStepTrue = loginPage.logout();
    }

    @Author(name = "Ravinder Singh, Rohitashva Budhauliya")
    @Description("QAAUT-4043(Android-native),QAAUT-4042(iOS native):Quickread L1 - Verify that user is able to tap on Entertainment section")
    @Test
    public void verifyQuickReadsEntertainmentRedirection() {
        boolean isStepTrue = homePage.checkQuickReadsEntertainmentRedirection();
        Assert.assertTrue(isStepTrue, "redirection on Quickread Entertainment tab failed.");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-4041(Android-native), QAAUT-4041(iOS native) :Quickread L1 - Verify that user is able to tap on Entertainment section")
    @Test
    public void verifyQuickReadsAllTabRedirection() {
        boolean isStepTrue = homePage.checkQuickReadsAllTabRedirection();
        Assert.assertTrue(isStepTrue, "redirection on Quickreads All tab failed.");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-4039(Android-native),QAAUT-4038(iOS native):Quickread L1 - Verify the redirection when user taps on India News section")
    @Test
    public void verifyQuickReadsIndiaNewsTabRedirection() {
        boolean isStepTrue = homePage.checkQuickReadsIndiaNewsTabRedirection();
        Assert.assertTrue(isStepTrue, "redirection on Quickreads India News tab failed.");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-4057(Android-native),QAAUT-4056(iOS native):Verify that in Quickreads Page Business section is displayed")
    @Test
    public void verifyQuickReadsBusinessTabRedirection() {
        boolean isStepTrue = homePage.checkQuickReadsBusinessTabRedirection();
        Assert.assertTrue(isStepTrue, "redirection on Quickreads Business tab failed.");
    }

    @Author(name = "Ravinder Singh, Rohitashva Budhauliya")
    @Description("QAAUT-4055(Android-native),QAAUT-4054(iOS-native):Verify that in Quickreads Page Sports section is displayed")
    @Test
    public void verifyQuickReadsSportsTabRedirection() {
        boolean isStepTrue = homePage.checkQuickReadsSportsTabRedirection();
        Assert.assertTrue(isStepTrue, "redirection on Quickreads Sports tab failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4033(Android-native), QAAUT-4032(iOS-native):Quickread L1 - Verify that in Quickreads Page Astrology section is displayed")
    @Test
    public void verifyAstrologySectionAfterLifestyleInQuickReads() {
        boolean isStepTrue = homePage.checkAstrologySectionAfterLifestyleInQuickReads();
        Assert.assertTrue(isStepTrue, "redirection on Quickreads Astrology tab failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3859 (iOS-native), QAAUT-3860 (AndroidNative) : Verify that Daily Digest displayed on the Explore Page")
    @Test
    public void verifyDailyDigestDisplayedOnExplore() {
        boolean isStepTrue = homePage.checkDailyDigestDisplayedOnExplore();
        Assert.assertTrue(isStepTrue, "Daily Digest displayed on the Explore Page failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4045 (Android-native), QAAUT-4044 (iOS-native):Quickread L1 - Verify that user is able to tap on Cricket Section")
    @Test
    public void verifyRedirectToCricketSectionFromQuickReads() {
        boolean isStepTrue = homePage.checkRedirectToCricketSectionFromQuickReads();
        Assert.assertTrue(isStepTrue, "Redirection on QuickReads Cricket tab failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4047 (Android-native), QAAUT-4046 (iOS-native): Quickread L1 - Verify that user is able to tap on Cities section")
    @Test
    public void verifyRedirectToCitySectionFromQuickReads() {
        boolean isStepTrue = homePage.checkRedirectToCitiesSectionFromQuickReads();
        Assert.assertTrue(isStepTrue, "Redirection on QuickReads City tab failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4049 (Android-native), QAAUT-4048 (iOS-native): Quickread L1 - Verify that user is able to tap on World News section")
    @Test
    public void verifyRedirectToWorldNewsSectionFromQuickReads() {
        boolean isStepTrue = homePage.checkRedirectToWorldNewsSectionFromQuickReads();
        Assert.assertTrue(isStepTrue, "Redirection on QuickReads WorldNews tab failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4051 (Android-native), QAAUT-4050 (iOS-native): Quickread L1 - Verify that user is able to tap on Lifestyle section")
    @Test
    public void verifyRedirectToLifeStyleSectionFromQuickReads() {
        boolean isStepTrue = homePage.checkRedirectToLifeStyleSectionFromQuickReads();
        Assert.assertTrue(isStepTrue, "Redirection on QuickReads LifeStyle tab failed.");
    }

    @Author(name = "Ravinder Singh, Rohitashva Budhauliya")
    @Description("QAAUT-4053(Android-native), , QAAUT-4052 (iOS-Native):Quickread L1 - Verify that user is able to tap on Astrology section")
    @Test
    public void verifyRedirectToAstrologyTabFromQuickRead() {
        boolean isStepTrue = homePage.checkRedirectToAstrologyTabFromQuickRead();
        Assert.assertTrue(isStepTrue, "user is able to tap on Astrology section failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4029 (Android-native), QAAUT-4028 (iOS-Native): Quickread L1 - Verify that in Quickreads Page World News section is displayed")
    @Test
    public void verifyWorldNewsDisplayedAfterCitiesSectionInQuickReads() {
        boolean isStepTrue = homePage.checkWorldNewsDisplayedAfterCitiesSectionInQuickReads();
        Assert.assertTrue(isStepTrue, "World News Displayed After Cities Section failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4019(Android-native), QAAUT-4018 (iOS-Native) : Quickread L1 - Verify that in Quickreads Page All section is displayed")
    @Test
    public void verifyAllTabInQuickRead() {
        boolean isStepTrue = homePage.checkAllTabInQuickRead();
        Assert.assertTrue(isStepTrue, "All section is displayed failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4031 (Android-native), QAAUT-4030 (iOS-Native): QuickRead L1 - Verify that in QuickReads Page Lifestyle section is displayed")
    @Test
    public void verifyLifeStyleSectionAfterWorldNewsInQuickReads() {
        boolean isStepTrue = homePage.checkLifeStyleSectionAfterWorldNewsInQuickReads();
        Assert.assertTrue(isStepTrue, "Lifestyle section is displayed after World News failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4037 (Android-native), QAAUT-4036 (iOS-Native): Quickread L1 - Verify that in QuickReads Page Business section is displayed")
    @Test
    public void verifyBusinessSectionAfterSportsInQuickReads() {
        boolean isStepTrue = homePage.checkBusinessSectionAfterSportsInQuickReads();
        Assert.assertTrue(isStepTrue, "Business section is displayed after Sports failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4021 (Android-native), QAAUT-4021 (iOS-Native): Quickread L1 - Verify that in QuickReads Page India News section is displayed")
    @Test
    public void verifyIndiaNewsSectionAfterAllTabInQuickReads() {
        boolean isStepTrue = homePage.checkIndiaNewsSectionAfterAllTabInQuickReads();
        Assert.assertTrue(isStepTrue, "India News section is displayed after All Tab failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4023 (Android-native), QAAUT-4022 (iOS-Native): Quickread L1 - Verify that in Quickreads Page Entertainment section is displayed")
    @Test
    public void verifyEntertainmentSectionAfterIndiaNewsInQuickReads() {
        boolean isStepTrue = homePage.checkEntertainmentSectionAfterIndiaNewsInQuickReads();
        Assert.assertTrue(isStepTrue, "Entertainment section is displayed after India News Tab failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4025 (Android-native), QAAUT-4024 (iOS-Native): Quickread L1 - Verify that in Quickreads Page Cricket section is displayed")
    @Test
    public void verifyCricketSectionAfterEntertainmentInQuickReads() {
        boolean isStepTrue = homePage.checkCricketSectionAfterEntertainmentInQuickReads();
        Assert.assertTrue(isStepTrue, "Cricket Section is displayed after Entertainment section failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4027 (Android-native): Quickread L1 - Verify that in Quickreads Page Cities section is displayed")
    @Test
    public void verifyCitiesSectionAfterCricketInQuickReads() {
        boolean isStepTrue = homePage.checkCitiesSectionAfterCricketInQuickReads();
        Assert.assertTrue(isStepTrue, "Cities Section is displayed after  Cricket Section failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4035 (Android-native), QAAUT-4034 (iOS-Native): Quickread L1 - Verify that in Quickreads Page Sports section is displayed")
    @Test
    public void verifySportsSectionAfterAstrologyInQuickReads() {
        boolean isStepTrue = homePage.checkSportsSectionAfterAstrologyInQuickReads();
        Assert.assertTrue(isStepTrue, "Sports Section is displayed after Astrology Section failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4059 (Android-native), QAAUT-4058 (iOS-Native): Quickread L1 - Verify that text Swipe Up For Next Story is displayed below the Ad")
    @Test
    public void verifySwipeUpAndAdAfter4StoriesInQuickReads() {
        boolean isStepTrue = homePage.checkSwipeUpAndAdAfter4StoriesInQuickReads();
        Assert.assertTrue(isStepTrue, "text Swipe Up For Next Story is displayed failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4061 (Android-native), QAAUT-4060 (iOS-Native): Quickread L1 - Verify that user can go to the other section by swiping left to right")
    @Test
    public void verifyOtherSectionBySwipingLeftToRightInQuickReads() {
        boolean isStepTrue = homePage.checkOtherSectionBySwipingLeftToRightInQuickReads();
        Assert.assertTrue(isStepTrue, "Other section by swiping left to right failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4064 (Android-native), QAAUT-4062 (iOS-Native): Quickread L1 - Verify that user can go to the other section by swiping right to left")
    @Test
    public void verifyOtherSectionBySwipingRightToLeftInQuickReads() {
        boolean isStepTrue = homePage.checkOtherSectionBySwipingRightToLeftInQuickReads();
        Assert.assertTrue(isStepTrue, "Other section by swiping right to left failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4065 (Android-native), QAAUT-4063 (iOS-Native): Quickread L1 - Verify that user able to swipe story from top to bottom on any section")
    @Test
    public void verifySwipeTopToBottomInQuickReads() {
        boolean isStepTrue = homePage.checkSwipeTopToBottomInQuickReads();
        Assert.assertTrue(isStepTrue, "Swipe story from top to bottom on any section Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4067 (Android-native), QAAUT-4066 (iOS-Native): Quickread L1 - Verify that user able to swipe story from bottom to top on any section")
    @Test
    public void verifySwipeBottomToTopInQuickReads() {
        boolean isStepTrue = homePage.checkSwipeBottomToTopInQuickReads();
        Assert.assertTrue(isStepTrue, "Swipe story from bottom to top on any section Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4069 (Android-native), QAAUT-4068 (iOS-Native): Quickread L1 - Verify that after 8 swipe of story on any section, second ad is displayed")
    @Test
    public void verifySecondAdAfter8SwipeInQuickReads() {
        boolean isStepTrue = homePage.checkSecondAdAfter8SwipeInQuickReads();
        Assert.assertTrue(isStepTrue, "second ad is displayed Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4071 (Android-native), QAAUT-4070 (iOS-Native): Quickread L1 - Verify that on Ad, just above text Swipe Up For Next Story up arrow icon is displayed")
    @Test
    public void verifySwipeUpOptionInFirstAdInQuickReads() {
        boolean isStepTrue = homePage.checkSwipeUpOptionInFirstAdInQuickReads();
        Assert.assertTrue(isStepTrue, "second ad is displayed Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4073 (Android-native), QAAUT-4072 (iOS-Native): Quickread L1 - Verify the redirection when user taps on blank space displayed after and before the text Swipe Up For Next Story")
    @Test
    public void verifyRedirectToStoryIfTabOnBlankSpaceInQuickReads() {
        boolean isStepTrue = homePage.checkRedirectToStoryIfTabOnBlankSpaceInQuickReads();
        Assert.assertTrue(isStepTrue, "User taps on blank space displayed after and before the text Swipe Up For Next Story Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3882(Android),QAAUT-3881- Verify the behavior when logged in user taps on E-Paper option from Cricket Page")
    @Test
    public void verifyEPaperRedirectionFromCricketPageOnHeader() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        boolean isEPaperOpened = homePage.checkEPaperOptionFromCricketHeader();
        Assert.assertTrue(isEPaperOpened, "EPaper Opened Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3884(Android),QAAUT-3883- Verify the behavior when logged in user taps on E-Paper option from Premium Page")
    @Test
    public void verifyEPaperRedirectionFromPremiumPageOnHeader() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        boolean isEPaperOpened = homePage.checkEPaperOptionFromPremiumHeader();
        Assert.assertTrue(isEPaperOpened, "EPaper Opened Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3886(Android),QAAUT-3885- Verify the behavior when logged in user taps on E-Paper option from Explore Page")
    @Test
    public void verifyEPaperRedirectionFromExploreOnHeader() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
        boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");
        boolean isEPaperOpened = homePage.checkEPaperOptionFromExploreHeader();
        Assert.assertTrue(isEPaperOpened, "EPaper Opened Failed");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3862(Android-Native), QAAUT-3861(iOS native) - Verify the redirection when user taps on Daily Digest on the Explore Page")
    @Test
    public void verifyRedirectToDailyDigestFromExplore() {
        boolean isStepTrue;
        isStepTrue = homePage.checkRedirectToDailyDigestFromExplore();
        Assert.assertTrue(isStepTrue, "Daily Digest redirection Failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5845(Android-Native),QAAUT-5846(iOS-Native): Verify that after fresh installing the build city news section are shown in the home page")
    @Test
    public void verifyCityNewsInHomepageDisplayed() {
        boolean isStepTrue = homePage.checkCityNewsInHomepageDisplayed();
        Assert.assertTrue(isStepTrue,"City news is not displaying");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5871(Android-Native),QAAUT-5872(iOS-Native): Verify that all the cities are shown in the Home page even when user does not select any city from the City section page")
    @Test
    public void verifyListOfCitiesInCityNewsDisplayed() {
        boolean isStepTrue = homePage.checkListOfCitiesInCityNewsDisplayed();
        Assert.assertTrue(isStepTrue,"List of cities in city news is not displaying");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5876(Android-Native),QAAUT-5877(iOS-Native): Verify the redirection on tapping view all link when the user does not select any city from the city section page")
    @Test
    public void verifyRedirectionWhenUserTapsOnViewAllInCityNews() {
        boolean isStepTrue = homePage.checkRedirectionWhenUserTapsOnViewAllInCityNews();
        Assert.assertTrue(isStepTrue,"Redirection to cities section failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5914(Android-Native),QAAUT-5915(iOS-Native): Verify that if the user select any city from the city section page then that city should be displayed in Home Page")
    @Test
    public void verifySectionPageSelectedCityShownInHomePage() {
        boolean isStepTrue = homePage.checkSectionPageSelectedCityShownInHomePage();
        Assert.assertTrue(isStepTrue,"Selected city in home page not displaying");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5975(Android-Native),QAAUT-5976(iOS-Native): Verify that if the user select any city from the Home Page then that city should be displayed in city section page")
    @Test
    public void verifyHomePageSelectedCityShownInSectionPage() {
        boolean isStepTrue = homePage.checkHomePageSelectedCityShownInSectionPage();
        Assert.assertTrue(isStepTrue,"Selected city in section page not displaying");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-6250 (Web): All L1 Sub-Menu are present and giving 200 status code")
    @Test
    public void verifyAllL1SubMenuPresentAnd200StatusCode() {
        boolean isStepTrue = homePage.checkAllL1SubMenuPresentAnd200StatusCode();
        Assert.assertTrue(isStepTrue,"L1 Sub-Menu are present and giving 200 status code failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): All L2 Sub-Menu are present and giving 200 status code")
    @Test
    public void verifyAllL2SubMenuPresentAnd200StatusCode() {
        boolean isStepTrue = homePage.checkAllL2SubMenuPresentAnd200StatusCode();
        Assert.assertTrue(isStepTrue,"L2 Sub-Menu are present and giving 200 status code failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): First collection type must be 'Top News'")
    @Test
    public void verifyFirstCollectionTopNews() {
        boolean isStepTrue = homePage.checkFirstCollectionTopNews();
        Assert.assertTrue(isStepTrue,"First collection type must be 'Top News' failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Header ad must load properly")
    @Test
    public void verifyHeaderTopAd() {
        boolean isStepTrue = homePage.checkHeaderTopAd();
        Assert.assertTrue(isStepTrue,"Header ad must load properly failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): '+More' Drop down in L2")
    @Test
    public void verifyMoreOptionInL2() {
        boolean isStepTrue = homePage.checkMoreOptionInL2();
        Assert.assertTrue(isStepTrue,"'+More' Drop down in L2 failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): LHS and RHS collection must load and contains stories")
    @Test
    public void verifyLHSAndRHSCollectionAndStories() {
        boolean isStepTrue = homePage.checkLHSAndRHSCollectionAndStories();
        Assert.assertTrue(isStepTrue,"LHS and RHS collection load and contains stories failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Ads in top and after every collection in RHS")
    @Test
    public void verifyAdInTopAndAfterCollectionInRHS() {
        boolean isStepTrue = homePage.checkAdInTopAndAfterCollectionInRHS();
        Assert.assertTrue(isStepTrue,"Ads in top and after every collection in RHS failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Footer must be present and contains data")
    @Test
    public void verifyFooterAndData() {
        boolean isStepTrue = homePage.checkFooterAndData();
        Assert.assertTrue(isStepTrue,"Footer must be present and contains data failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Web-Topic Page || Verify ads after every collection present in middle layer")
    @Test
    public void verifyAdsAfterEveryCollectionInMiddleLayer() {
        boolean isStepTrue = homePage.checkAdsAfterEveryCollectionInMiddleLayer();
        Assert.assertTrue(isStepTrue,"Ads after every collection in middle layer failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Web-Topic Page || L3 must be there with success code 200")
    @Test
    public void verifyL3SubMenuAnd200SuccessCode() {
        boolean isStepTrue = homePage.checkL3SubMenuAnd200SuccessCode();
        Assert.assertTrue(isStepTrue,"L3 must be there with success code 200 failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Web-Topic Page || All topic should give 200 success code")
    @Test
    public void verifyAllTopicSuccessCode200() {
        boolean isStepTrue = homePage.checkAllTopicSuccessCode200();
        Assert.assertTrue(isStepTrue,"All topic should give 200 success code failed");
    }
}
