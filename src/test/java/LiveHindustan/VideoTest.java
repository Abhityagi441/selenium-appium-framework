package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.pages.LiveHindustan.genericPages.CommonStoryPage;
import com.pages.LiveHindustan.genericPages.CommonVideoPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;


public class VideoTest extends BaseTest {
    private static CommonVideoPage videoPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            videoPage = CommonVideoPage.getInstance();
            loginPage = CommonLoginPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            videoPage = CommonVideoPage.getInstance();
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

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-2586(Web), QAAUT-3427(Android-MWeb), QAAUT-3422(IOS-MWeb), QAAUT-6024(AMP-Android),QAAUT-6025(AMP-IOS): To verify submenu are clickable on video landing page")
    @Test
    public void verifySubmenusAreClickableOnVideoLandingPage() {
        boolean isStepTrue;
        isStepTrue = videoPage.checkSubmenuAreClickableOnVideoLandingPage();
        Assert.assertTrue(isStepTrue, "Submenu are not clickable or not opening respected pages or not getting 200 status on video landing page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6041(Web), QAAUT-6042(Android-MWeb), QAAUT-6043(IOS-MWeb), QAAUT-6044(AMP-Android),QAAUT-6045(AMP-IOS): To verify breadcrumb redirection and giving 200 status code")
    @Test
    public void verifyBreadcrumbRedirectionGiving200OnVideoWidget() {
        boolean isStepTrue;
        isStepTrue = videoPage.checkBreadcrumbRedirectionGiving200OnVideoWidget();
        Assert.assertTrue(isStepTrue, "Breadcrumb redirection is not proper or not giving 200 status code on video Widget page!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT- 2587 (Web),3269(Android_MWeb),QAAUT-4562(LH-MWeb-IOS): To verify breadcrumb and social sharing is present on video detail page")
    @Test
    public void verifyBreadcrumbAndSocialSharingIsPresentOnVideoDetailPage() {
        boolean isStepTrue;
        isStepTrue = videoPage.checkVideoDetailPage();
        Assert.assertTrue(isStepTrue, "Video detail page failed!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6091(Web), QAAUT-6092(Android-MWeb), QAAUT-6093(IOS-MWeb), QAAUT-6094(AMP-Android),QAAUT-6095(AMP-IOS): To verify sambhandit video gallery is having 4 videos and giving 200 status code")
    @Test
    public void verifySambhanditVideoGalleryHavingFourVideosGiving200Status() {
        boolean isStepTrue;
        isStepTrue = videoPage.checkSambhanditVideoGalleryHavingFourVideosGiving200Status();
        Assert.assertTrue(isStepTrue, "Sambhandit video gallery is not having 4 videos or not giving 200 status code on video page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6108(Web), QAAUT-6109(Android-MWeb), QAAUT-6110(IOS-MWeb), QAAUT-6111(AMP-Android),QAAUT-6112(AMP-IOS): To verify social sharing redirection and giving 200 status code on video detail page")
    @Test
    public void verifySocialSharingRedirectionAndGiving200OnVideoDetail() {
        boolean isStepTrue;
        isStepTrue = videoPage.checkSocialSharingRedirectionAndGiving200OnVideoDetail();
        Assert.assertTrue(isStepTrue, "Social sharing redirection is not proper or not giving 200 status code on video detail page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6113(Web), QAAUT-6114(Android-MWeb), QAAUT-6115(IOS-MWeb), QAAUT-6116(AMP-Android),QAAUT-6117(AMP-IOS): To verify video is playing successfully on video detail page")
    @Test
    public void verifyVideoIsPlayingSuccessfullyOnVideoDetailPage() {
        boolean isStepTrue;
        isStepTrue = videoPage.checkVideoIsPlayingSuccessfullyOnVideoDetailPage();
        Assert.assertTrue(isStepTrue, "video is not playing or pauseing successfully on video detail page!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-6188(Web),QAAUT-6189(Android-MWeb),QAAUT-6190(IOS-MWeb):To verify video gallery widget on Video page is having 5 no of videos and status code is 200")
    @Test
    public void verifyVideoGalleryWidgetIsHaving5StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = videoPage.checkVideoGalleryWidgetIsHaving5StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Video gallery widget is not loading!!!!!!!!");
    }
}
