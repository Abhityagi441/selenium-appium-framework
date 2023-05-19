package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.android_mweb.LoginPage;
import com.pages.LiveHindustan.genericPages.CommonLandingPage;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;


public class StoryTest extends BaseTest {
    private static CommonStoryPage storyPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            storyPage = CommonStoryPage.getInstance();
            loginPage = CommonLoginPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            storyPage = CommonStoryPage.getInstance();
            /*Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
            boolean isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
            if (!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                Assert.assertTrue(isStepTrue, "Login with Email and Password failed");
            }*/
        }
    }

    @AfterClass
    public void afterClass() {
        boolean isStepTrue;
        switch (globalVars.getPlatformName()) {
            case Constants.ANDROID_AMP:
            case Constants.IOS_AMP:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                commonFunctionsMobile.waitForPageToLoad();
                break;
            case Constants.ANDROID_WEB:
            case Constants.IOS_WEB:
                commonFunctionsMobile = CommonFunctionsMobile.getInstance();
                commonFunctionsMobile.navigateToURL(globalVars.getURL());
                commonFunctionsMobile.waitForPageToLoad();
                /*isStepTrue = loginPage.logout();
                if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
            case Constants.DESKTOP_WEB:
                commonFunctionsWeb = CommonFunctionsWeb.getInstance();
                commonFunctionsWeb.navigateToURL(globalVars.getURL());
                /*isStepTrue = loginPage.logout();
                if(!globalVars.getPlatformName().equals(Constants.IOS_WEB)) {
                    Assert.assertTrue(isStepTrue, "Logout from LiveHindustan failed!!");
                }*/
                break;
        }

    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT-2884 (Web):To verify headline, image byline, and RHS widgets on story detail page")
    @Test
    public void verifyHeadlineImageBylineAndRHSWidgetsOnStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Story page not display properly!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-2883(Web),QAAUT-3273(Android_MWeb),QAAUT-6184(LH-IOS_MWeb),QAAUT-3794(AMP-Android),QAAUT-4593(AMP-IOS):To verify story page breadcrumb redirection to respective pages")
    @Test
    public void verifyStoryPageBreadcrumbRedirectionToRespectivePages() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryPageBreadcrumb();
        Assert.assertTrue(isStepTrue, "Story detail breadcrumbs redirection failed!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-2886(Web),3274(Android_MWeb),QAAUT-6038(LH-IOS_MWeb),QAAUT-3799(AMP-Android), QAAUT-4598(AMP-IOS): To verify tags redirection from Story pages")
    @Test
    public void verifyTagsRedirectionFromStoryPages() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryTags();
        Assert.assertTrue(isStepTrue, "Story tags redirection failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT-2882 (Web),3501(Android_MWeb), 4555(IOS_MWeb): To verify 2nd and 3rd Ad with 120 Words")
    @Test
    public void verifyAdFor2ndAnd3rdByNumberOfWords() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAdFor2ndAnd3rdByNumberOfWords();
        Assert.assertTrue(isStepTrue, "Ad don't come after and before 120 words count!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT-2565 (Web),3262(Android_MWeb),QAAUT-4559(LH-MWeb-IOS): To verify the first ad comes after the first paragraph")
    @Test
    public void verifyFirstAdComesAfterFirstParagraph() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkFirstAdComesAfterFirstParagraph();
        Assert.assertTrue(isStepTrue, "Ad don't come after and before 120 words count!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT-2568 (Web),3264(Android_MWeb),QAAUT-4560(LH-MWeb-IOS),QAAUT-6185(AMP-Android),QAAUT-6186(AMP-IOS):To verify summary is displayed on story detail page")
    @Test
    public void verifySummaryIsDisplayedOnStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkSummaryOfTheStoryPage();
        Assert.assertTrue(isStepTrue, "Summary is empty or not present for the story!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT-2566 (Web),3362(Android_MWeb):To verify story page ")
    @Test
    public void verifyStoryPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryPage();
        Assert.assertTrue(isStepTrue, "Not landing on the same page after page refresh!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT-2976 (Web),3363(Android_MWeb):To Verify listing page for National")
    @Test
    public void verifyListingPageForNational() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkListingPageForNational();
        Assert.assertTrue(isStepTrue, "Listing of news of rashtreeye news failed!!!!!!!!");
    }


    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT-3158 (Web),QAAUT-3365(Android_MWeb),QAAUT-6187(IOS_MWeb):To verify next story gets appended after scrolling on story page")
    @Test
    public void verifyNextStoryGetsAppendedAfterScrollingOnStoryPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkNextPageAppending();
        Assert.assertTrue(isStepTrue, "Appended story on second page is not present!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT-2890 (Web),3366(Android_MWeb) :To verify story page RHS")
    @Test
    public void verifyStoryPageRHS() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryPageRHS();
        Assert.assertTrue(isStepTrue, "Story details page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-3263(Android_MWeb),4546(IOS_MWeb) :To verify story page one-tap functionality")
    @Test
    public void verifyStoryPageOneTapFunctionality() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryPageOneTapFunctionality();
        Assert.assertTrue(isStepTrue, "Story page one-tap functionality is not working!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Regression || QAAUT-4556(IOS_MWeb), QAAUT-2337(Android_MWeb) :To verify Web story detail page")
    @Test
    public void verifyWebStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkWebStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Web story detail functionality is not working!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("QAAUT-3795(AMP-Android),QAAUT-4594(AMP-IOS) To verify App per padhe functionality(App Already Installed)")
    @Test
    public void verifyAppPerPadheFunctionalityInstalled() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAppPerPadheFunctionalityInstalled();
        Assert.assertTrue(isStepTrue, "App per padhe functionality is not working!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("QAAUT-3796(AMP-Android),QAAUT-4595(AMP-IOS) To verify App per padhe functionality(App Not Installed)")
    @Test
    public void verifyAppPerPadheFunctionalityNotInstalled() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAppPerPadheFunctionalityNotInstalled();
        Assert.assertTrue(isStepTrue, "App per padhe functionality is not working!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT- 2892(Web),3505(Android_MWeb),QAAUT-4569(LH-MWeb-IOS),QAAUT-3797(AMP-Android), QAAUT-4596(AMP-IOS) : To verify related news widget on story detail ")
    @Test
    public void verifyRelatedNewsWidgetOnStoryDetail () {
        boolean isStepTrue;
        isStepTrue = storyPage.checkRelatedNewsWidgetOnStoryDetail();
        Assert.assertTrue(isStepTrue, "Sambandhit khabre widgit not displaying!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-3800(AMP-Android),QAAUT-4599(AMP-IOS) : To verify section gets appended on scroll on story page")
    @Test
    public void verifySectionGetsAppendedOnScrollOnStoryPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkUrlMustChange();
        Assert.assertTrue(isStepTrue, "URL change functionality is not working!!!!!!!!");
    }
    @Author(name = "Raj")
    @Description("Sanity || QAAUT-3801(AMP-Android),QAAUT-4600(AMP-IOS): To verify Aur padhe button on story page")
    @Test
    public void verifyAurPadheButtonOnStoryPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAurPadheButtonOnAmpStoryPage();
        Assert.assertTrue(isStepTrue, "Aur padhe button on AMP story page functionality is not working!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-5729(Web),QAAUT-6039(LH-MWeb-Android),QAAUT-6040(LH-MWeb-IOS):To verify list view in Sambahandit khabre widget in story Pages")
    @Test
    public void verifyListViewInSambahanditKhabreWidgetInStoryPages() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkListViewInSambahanditKhabreWidgetInStoryPages();
        Assert.assertTrue(isStepTrue, "List view in Sambahandit khabre widget in story Pages is not working fine !!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5725(LH-MWeb-Android),QAAUT-5993(LH-MWeb-IOS): To verify Agla lekh disappears in web story pages when scrolled down from Agla lekh Heading")
    @Test
    public void verifyAglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading();
        Assert.assertTrue(isStepTrue, "Agla Lekh alert is not dis-appeared !!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Regression || QAAUT-5728(LH-MWeb-Android), To verify Agla lekh in web story pages as sticky bottom")
    @Test
    public void verifyAglaLekhInWebStoryPagesAsStickyBottom() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAglaLekhInWebStoryPagesAsStickyBottom();
        Assert.assertTrue(isStepTrue, "Agla Lekh alert is not displayed !!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5882(LH-Web),QAAUT-5883(LH-MWeb-Android),QAAUT-5889(LH-MWeb-IOS) : To verify URL should change while scrolling on Slide Story")
    @Test
    public void verifyURLShouldChangeWhileScrollingOnSlideStory() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyURLShouldChangeWhileScrollingOnSlideStory");
        isStepTrue = storyPage.checkURLShouldChangeWhileScrollingOnSlideStory(params.get("slideStoryUrl"));
        Assert.assertTrue(isStepTrue, "URL is not changed !!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5884(AMP-Android),QAAUT-5888(AMP-IOS) : To verify breadcrumb on slide story")
    @Test
    public void verifyBreadcrumbOnSlideStory() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBreadcrumbOnSlideStory");
        isStepTrue = storyPage.checkBreadcrumbOnSlideStory(params.get("slideStoryUrl"));
        Assert.assertTrue(isStepTrue, "Breadcrumb data is incorrect !!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-5886(LH-Web),QAAUT-5887(LH-MWeb-Android),QAAUT-5890(LH-MWeb-IOS) : To verify the List view and pages number at footer on Tag page")
    @Test
    public void verifyTheListViewAndPagesNumberAtFooterOnTagPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkTheListViewAndPagesNumberAtFooterOnTagPage();
        Assert.assertTrue(isStepTrue, "The List view and pages number at footer on Tag page is not displaying!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5917(AMP-Android),QAAUT-5918(AMP-IOS) To verify social sharing on slide story")
    @Test
    public void verifySocialSharingOnSlideStory() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySocialSharingOnSlideStory");
        isStepTrue = storyPage.checkSocialSharingOnSlideStory(params.get("slideStoryUrl"));
        Assert.assertTrue(isStepTrue, "Social sharing options are not working !!!");
    }
    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT- 2891 (Web),3504(Android_MWeb),QAAUT-4568(LH-MWeb-IOS),QAAUT-3798(AMP-Android), QAAUT-4597(AMP-IOS): To verify social sharing redirection on story detail page")
    @Test
    public void verifySocialSharingRedirectionOnStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkSocialSharingRedirectionOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Social sharing icon not display!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-3272(Android_MWeb),QAAUT-3677(Android AMP),QAAUT-4592(IOS AMP):To verify headline and image byline on story detail page")
    @Test
    public void verifyHeadlineAndImageBylineOnStoryDetailPage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkHeadlineAndImageBylineOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Headline and image byline on story detail page does not display!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5994(LH-Web) - To verify Agla lekh footer gets highlighted")
    @Test
    public void verifyAglaLekhFooterGetsHighlighted() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAglaLekhFooterGetsHighlighted();
        Assert.assertTrue(isStepTrue, "Agla Lekh footer is not displayed !!!!!!!!");
    }

}