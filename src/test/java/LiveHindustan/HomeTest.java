package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.pages.LiveHindustan.genericPages.CommonHomePage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;


public class HomeTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            homePage = CommonHomePage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            homePage = CommonHomePage.getInstance();
            /*Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
            boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
            if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                Assert.assertTrue(isStepTrue, "Login with Email and Password failed");
            }*/
        }
    }

    @AfterClass
    public void afterClass() {
        boolean isStepTrue;
        switch (globalVars.getPlatformName()) {
            case Constants.ANDROID_WEB:
            case Constants.IOS_WEB:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                /*isStepTrue = loginPage.logout();
                if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
            case Constants.DESKTOP_WEB:
                commonFunctionsWeb = CommonFunctionsWeb.getInstance();
                commonFunctionsWeb.navigateToURL(globalVars.getURL());
                /*isStepTrue = loginPage.logout();
                Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");*/
                break;
            case Constants.ANDROID_AMP:
            case Constants.IOS_AMP:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                break;
        }
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-2326(Web), 3418(Android_MWeb), QAAUT-5963(IOS_Mweb),QAAUT- 5991(LH-AMP-Android), QAAUT-5992(LH-AMP-IOS) :To verify hindustan image on home page")
    @Test
    public void verifyHindustanImageOnHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHeaderDisplay();
        Assert.assertTrue(isStepTrue, "Header is not displaying!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT-2327(Web),3419(Android_MWeb): Verify Home page RHS widgets")
    @Test
    public void verifyHomePageRHSWidgets() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePageRHSWidgets();
        Assert.assertTrue(isStepTrue, "Home page RHS widgets are not displaying!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-2329(Web),3480(Android_MWeb), 3523(Android AMP),QAAUT-4564(LH-MWeb-IOS),QAAUT-4584(LH-AMP-IOS): To verify Pramukh khabre widget on home page and giving 200 status code")
    @Test
    public void verifyPramukhKhabreWidgetOnHomePageAndGivingOkStatusCode() {
        boolean isStepTrue;
        isStepTrue = homePage.checkPramukhKhabreWidget();
        Assert.assertTrue(isStepTrue, "Pramukh khabre widget is failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT-2333(Web),3423(Android_MWeb): To verify Scroll on home page")
    @Test
    public void verifyScrollOnHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkScrollOnHomePage();
        Assert.assertTrue(isStepTrue, "Scroll on home page failed!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-2332(Web),3258(Android_MWeb),QAAUT-4557(LH-MWeb-IOS),QAAUT- 3524(LH-AMP-Android), QAAUT-4585(LH-AMP-IOS): To verify top nav bar on home page")
    @Test
    public void verifyTopNavBarOnHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkTopNevBar();
        Assert.assertTrue(isStepTrue, "Top nav bar functionality failed!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-2334(Web),3425(Android_MWeb), QAAUT-3525(AMP Android) QAAUT-4586(AMP IOS),QAAUT-5962(LH-MWeb-IOS): To verify All L1 Menu are present and giving 200 status code")
    @Test
    public void verifyAllL1MenuArePresentAndGivingOkStatusCode() {
        boolean isStepTrue;
        isStepTrue = homePage.checkTopMenuBar();
        Assert.assertTrue(isStepTrue, "Top Menu bar functionality failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2336 (Web): To external widgets on home page")
    @Test
    public void verifyWidgetOnHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkWidgetOnHomePage();
        Assert.assertTrue(isStepTrue, "External widgets on home page failed!!!!!!!!");
    }
    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2887 (Web),3271(Android_MWeb): To verify aapke liye khash widget on story detail page")
    @Test
    public void verifyApkeLiaKhasWidgetsAndStoryClickable() {
        boolean isStepTrue;
        isStepTrue = homePage.checkApkeLiaKhasWidgetsAndStoryClickable();
        Assert.assertTrue(isStepTrue, "Apke Lia widgets not display!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2885 (Web),3502(Android_MWeb): To verify story page text to speech  ")
    @Test
    public void verifyTextToSpeechPlayAndPauseFunctionality() {
        boolean isStepTrue;
        isStepTrue = homePage.checkTextToSpeechPlayAndPauseFunctionality();
        Assert.assertTrue(isStepTrue, "Text to speech functionality failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2876 (Web),3485(Android_MWeb),QAAUT-4565(LH-MWeb-IOS): To verify page top and bottom ad load")
    @Test
    public void verifyTopAdAndBottomAdLoadProperly() {
        boolean isStepTrue;
        isStepTrue = homePage.checkTopAdAndBottomAdLoadProperly();
        Assert.assertTrue(isStepTrue, "Top and Bottom Ad not load properly!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2563 (Web),3528,3260(Anroid_MWeb),QAAUT-4558(LH-MWeb-IOS): To verify page load")
    @Test
    public void verifyAllPageAreLoadingProperly() {
        boolean isStepTrue;
        isStepTrue = homePage.checkAllPageAreLoadingProperly();
        Assert.assertTrue(isStepTrue, "All page not load properly!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2574 (Web),3265(Android_MWeb),QAAUT-4561(LH-MWeb-IOS): To Verify photo gallery landing page In Home Page")
    @Test
    public void verifyPhotoGalleryLandingPage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkPhotoGalleryLandingPage();
        Assert.assertTrue(isStepTrue, "Landing for photo gallery is not correct!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2877 (Web),3530(Android_Mweb): To verify Home page RHS ad load")
    @Test
    public void verifyRHSAdLoadProperly() {
        boolean isStepTrue;
        isStepTrue = homePage.checkRHSAdLoadProperly();
        Assert.assertTrue(isStepTrue, "RHS page not loading properly!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2878 (Web),3487(Android_MWeb),QAAUT-4566(LH-MWeb-IOS): To verify between widgets ads load")
    @Test
    public void verifyBetweenWidgetsAdsLoad() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBetweenWidgetsAdsLoad();
        Assert.assertTrue(isStepTrue, "Ads are not loading in between widgets!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT- 2881 (Web),3494(Android_MWeb),QAAUT-4567(LH-MWeb-IOS): Verify RFU widget on Home page")
    @Test
    public void verifyHomePageRFUWidgets() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePageRFUWidgets();
        Assert.assertTrue(isStepTrue, "RFU widget not loading!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 3033 (Web), 3514(Android_MWeb),QAAUT-4571(LH-MWeb-IOS): To verify astrology landing page sub menu")
    @Test
    public void verifyAstrologyLandingPageSubMenu() {
        boolean isStepTrue;
        isStepTrue = homePage.checkAstrologyLandingPageSubMenu();
        Assert.assertTrue(isStepTrue, "Astrology landing page sub menu failed!!!!!!!!");
    }
    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2567(Web):To verify story page RHS widgets ")
    @Test
    public void verifyRHSWidgets() {
        boolean isStepTrue;
        isStepTrue = homePage.checkRHSWidgets();
        Assert.assertTrue(isStepTrue, "Home page widgets are not displaying!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Regression || QAAUT- 3533(Android_MWeb):To verify Home page and widgets ")
    @Test
    public void verifyHomePageAndWidgets() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePageAndWidgets();
        Assert.assertTrue(isStepTrue, "Home page and widgets are not displaying!!!!!!!!");
    }


    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 3156(Web),3516(Android_MWeb),QAAUT-4572(LH-MWeb-IOS):To verify numerology page")
    @Test
    public void verifyNumerologyPage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkNumerologyPage();
        Assert.assertTrue(isStepTrue, "Numerology page landing failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT- 3164(Web),3518(Android_MWeb),QAAUT-4574(IOS_Mweb) : To verify live-blog button on home page")
    @Test
    public void verifyLiveBlogButtonOnHome() {
        boolean isStepTrue;
        isStepTrue = homePage.checkLiveBlogButtonOnHome();
        Assert.assertTrue(isStepTrue, "Live blog story landing page failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 3166(Web),3520(Android_MWeb),QAAUT-4576(LH-MWeb-IOS): To verify refresh button on liveblog detail page")
    @Test
    public void verifyRefreshButtonOnLiveblogDetailPage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkRefreshButtonOnLiveBlogDetailPage();
        Assert.assertTrue(isStepTrue, "Refresh functionality failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 3165(Web),3519(Android_MWeb),QAAUT-4575(LH-MWeb-IOS): To verify live-blog live update button on detail page")
    @Test
    public void verifyLivBlogLiveUpdateButtonOnDetailPage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkLivBlogLiveUpdateButtonOnDetailPage();
        Assert.assertTrue(isStepTrue, "Live Update is not visible!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 3165(Web): To verify live-blog live update button on detail page")
    @Test
    public void verifyWebStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkWebStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Live Update is not visible!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT- 3522(Android_AMP): To verify every widget on home page is having specified no of stories and status code is 200")
    @Test
    public void verifyEveryWidgetOnHomePageIsHavingSpecifiedNoOfStoriesAndStatusCodeIsOk() {
        boolean isStepTrue;
        isStepTrue = homePage.checkAmpHomePage();
        Assert.assertTrue(isStepTrue, "Home page load failed!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-3521(Android MWeb),QAAUT-4583(LH-MWeb-IOS):To verify Hamburger menu Functionality on Home page")
    @Test
    public void verifyHamburgerMenuFunctionalityOnHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkAllHamburgerLinksFunctionality();
        Assert.assertTrue(isStepTrue, "All hamburger menu links are not functional!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Regression || QAAUT- 3529(LH-Web): To verify Home page RHS ad load")
    @Test
    public void verifyHomePageRhsAdLoad() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePageRhsAdLoad();
        Utils.logStepInfo(isStepTrue, "Home page RHS ad Load functionality!!!!!!!!");
        Assert.assertTrue(isStepTrue, "Home page RHS ads are not loaded!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Regression || QAAUT- 3489(LH-Web-Android), QAAUT-4547(LH-Web-Ios): Verify mweb Home page RFU widget")
    @Test
    public void verifyMwebHomePageRfuWidget() {
        boolean isStepTrue;
        isStepTrue = homePage.checkMwebHomePageRfuWidget();
        Utils.logStepInfo(isStepTrue, "mweb Home page RFU widget!!!!!!!!");
        Assert.assertTrue(isStepTrue, "mweb Home page RFU widget is not displayed!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Regression || QAAUT- 3484(LH-MWeb-Android),QAAUT-4579(LH-AMP-IOS): To verify mweb video landing page")
    @Test
    public void verifyMwebVideoLandingPage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkMwebVideoLandingPage();
        Utils.logStepInfo(isStepTrue, "mweb video landing page!!!!!!!!");
        Assert.assertTrue(isStepTrue, "mweb video landing page is not loading properly!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Regression || QAAUT-3603(LH-AMP-Android), QAAUT-4588(LH-AMP-IOS): Verify News brief on AMP")
    @Test
    public void verifyNewsBriefOnAmp() {
        boolean isStepTrue;
        isStepTrue = homePage.checkNewsBriefOnAmp();
        Utils.logStepInfo(isStepTrue, "News brief on AMP Functionality!!!!!!!!");
        Assert.assertTrue(isStepTrue, "News brief on AMP Functionality is not working properly!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-4577(LH-AMP-IOS): To verify AMP home page widgets")
    @Test
    public void verifyIosAmpHomePage() {
        boolean isStepTrue;
        isStepTrue = homePage.checkIosAmpHomePage();
        Utils.logStepInfo(isStepTrue, "Home Page on AMP Functionality!!!!!!!!");
        Assert.assertTrue(isStepTrue, "Home Page on AMP Functionality is not working properly!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Regression || QAAUT - 3259(MWEB-Android), QAAUT - 4578(MWEB-IOS): To verify SEO content on the pages")
    @Test
    public void verifySeoContentOnThePages() {
        boolean isStepTrue;
        isStepTrue = homePage.checkSeoContentOnThePages();
        Assert.assertTrue(isStepTrue, "SEO contents are not displaying properly properly!!!!!!!!");
    }
    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5978(LH-Web),QAAUT-5979(LH-MWeb-Android),QAAUT-5980(LH-MWeb-IOS): To verify all topic are giving 200 status code")
    @Test
    public void verifyAllTopicAreGiving200StatusCode() {
        boolean isStepTrue;
        isStepTrue = homePage.checkAllTopicAreGiving200StatusCode();
        Assert.assertTrue(isStepTrue, "Topics are not returning 200");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5988(Web),QAAUT-5989(Android_MWeb),QAAUT-5990(LH-MWeb-IOS),QAAUT-3522(LH-AMP-Android): To verify entertainment widget is having 6 stories and status is 200")
    @Test
    public void verifyEntertainmentWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkEntertainmentWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Entertainment widget is not loading");
    }
    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6001(LH-Web),QAAUT-6002(Android_MWeb),QAAUT-6003(LH-MWeb-IOS): To verify photo gallery widget is having 6 stories and status is 200")
    @Test
    public void verifyPhotoGalleryWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkPhotoGalleryWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Photo gallery widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6017(LH-Web),QAAUT-6018(Android_MWeb),QAAUT-6019(LH-MWeb-IOS): To verify Hindustan Pahal link widget redirection and status code is 200")
    @Test
    public void verifyHindustanPahalLinkWidgetRedirectionAndStatusCodeIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHindustanPahalLinkWidgetRedirectionAndStatusCodeIs200();
        Assert.assertTrue(isStepTrue, "Hindustan pahal widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6020(LH-Web),QAAUT-6021(Android_MWeb),QAAUT-6022(LH-MWeb-IOS): To verify dharm gallery widget is having 6 stories and status is 200")
    @Test
    public void verifyDharmWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkDharmWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Dharm widget is not loading");
    }


    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6031(LH-Web),QAAUT-6032(Android_MWeb),QAAUT-6033(LH-MWeb-IOS): To verify cricket widget is having 6 stories and status is 200")
    @Test
    public void verifyCricketWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkCricketWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Cricket widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6034(LH-Web),QAAUT-6035(Android_MWeb),QAAUT-6036(LH-MWeb-IOS): To verify national widget is having 6 stories and status is 200")
    @Test
    public void verifyNationalWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkNationalWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "National widget is not loading");
    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT-3026 (Web),3364(Android_MWeb),QAAUT-5904 (Mweb_IOS):To verify infinite scroll on listing page and URL changes while scrolling")
    @Test
    public void verifyInfiniteScrollOnListingPageAndURLChangesWhileScrolling() {
        boolean isStepTrue;
        isStepTrue = homePage.checkInfiniteScrollingOnListingPage();
        Assert.assertTrue(isStepTrue, "Infinite scroll to listing page failed!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6046(LH-Web),QAAUT-6047(Android_MWeb),QAAUT-6048(LH-MWeb-IOS): To verify business widget is having 6 stories and status is 200")
    @Test
    public void verifyBusinessWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBusinessWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Business widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6049(LH-Web),QAAUT-6050(Android_MWeb),QAAUT-6051(LH-MWeb-IOS): To verify career widget is having 6 stories and status is 200")
    @Test
    public void verifyCareerWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkCareerWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Career widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6064(LH-Web),QAAUT-6065(Android_MWeb),QAAUT-6066(LH-MWeb-IOS): To verify gadgets widget is having 6 stories and status is 200")
    @Test
    public void verifyGadgetsWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkGadgetsWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Gadgets widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6061(LH-Web),QAAUT-6062(Android_MWeb),QAAUT-6063(LH-MWeb-IOS): To verify top video widget is having 5 stories and status is 200")
    @Test
    public void verifyTopVideoWidgetIsHaving5StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkTopVideoWidgetIsHaving5StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Top video widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6070(LH-Web),QAAUT-6071(Android_MWeb),QAAUT-6072(LH-MWeb-IOS): To verify auto widget is having 6 stories and status is 200")
    @Test
    public void verifyAutoWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkAutoWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Auto widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6073(LH-Web),QAAUT-6074(Android_MWeb),QAAUT-6075(LH-MWeb-IOS): To verify apna sheher chune widget is having 6 stories and status is 200")
    @Test
    public void verifyApnaSheherChuneWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkApnaSheherChuneWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Choose city widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6076(LH-Web),QAAUT-6077(Android_MWeb),QAAUT-6078(LH-MWeb-IOS): To verify lifestyle widget is having 6 stories and status is 200")
    @Test
    public void verifyLifestyleWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkLifestyleWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Life style widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6079(LH-Web),QAAUT-6080(Android_MWeb),QAAUT-6081(LH-MWeb-IOS): To verify HT widget is having 6 stories and status is 200")
    @Test
    public void verifyHTWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHTWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Hindustan Times widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6082(LH-Web),QAAUT-6083(Android_MWeb),QAAUT-6084(LH-MWeb-IOS): To verify LM widget is having 6 stories and status is 200")
    @Test
    public void verifyLMWidgetIsHaving6StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkLMWidgetIsHaving6StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Live Mint widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6131(LH-Web): To verify khabre,photo and video should have news listed under it on searching")
    @Test
    public void verifyKhabrePhotoAndVideoShouldHaveNewsListedUnderItOnSearching() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyKhabrePhotoAndVideoShouldHaveNewsListedUnderItOnSearching");
        isStepTrue = homePage.checkKhabrePhotoAndVideoShouldHaveNewsListedUnderItOnSearching(params.get("searchKeyword"),params.get("section1"),params.get("section2"),params.get("section3"));
        Assert.assertTrue(isStepTrue, "Searched news is not listed");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6069(LH-Web),QAAUT-6068(Android_MWeb),QAAUT-6067(LH-MWeb-IOS): To verify news brief widget is having 7 stories and status is 200")
    @Test
    public void verifyNewsBriefWidgetIsHaving7StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkNewsBriefWidgetIsHaving7StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "News brief widget is not loading");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6085(LH-Web),QAAUT-6086(Android_MWeb),QAAUT-6087(LH-MWeb-IOS): To verify rashifal widget is having 12 rashi present and status is 200")
    @Test
    public void verifyRashifalWidgetIsHaving12RashiPresentAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = homePage.checkRashifalWidgetIsHaving12RashiPresentAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Rashifal widget is not loading");
    }


}
