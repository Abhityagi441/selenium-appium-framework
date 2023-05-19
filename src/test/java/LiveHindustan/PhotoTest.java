package LiveHindustan;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.genericPages.CommonPhotoPage;
import com.pages.LiveHindustan.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;


public class PhotoTest extends BaseTest {
    private static CommonPhotoPage photoPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonFunctionsWeb commonFunctionsWeb;
    private static CommonFunctionsMobile commonFunctionsMobile;

    @BeforeClass
    public void beforeClass() {
        if (globalVars.getPlatformName().equals(Constants.ANDROID_AMP) || globalVars.getPlatformName().equals(Constants.IOS_AMP)) {
            photoPage = CommonPhotoPage.getInstance();
            loginPage = CommonLoginPage.getInstance();
        } else {
            loginPage = CommonLoginPage.getInstance();
            photoPage = CommonPhotoPage.getInstance();
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
    @Description("Sanity || QAAUT- 2679(Web),3270(Android_MWeb), QAAUT-4563(LH-MWeb-IOS):To verify aanya gallery widget functionality")
    @Test
    public void verifyAanyaGalleryWidgetFunctionality() {
        boolean isStepTrue = photoPage.checkExpandPhotoDetailAndFunctionality();
        Assert.assertTrue(isStepTrue, "photo gallery in expand view functionality failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2578(Web),3536(Android_MWeb): To verify photo detail")
    @Test
    public void verifyPhotoDetailePage() {
        boolean isStepTrue = photoPage.checkPhotoDetailePage();
        Assert.assertTrue(isStepTrue, "Photo details verification failed!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT- 2575(Web),QAAUT-3535(Android_MWeb),QAAUT-3266(LH-MWeb-IOS),QAAUT-6176(Android_AMP),QAAUT-6177(IOS_AMP): To verify breadcrumb and social sharing is present")
    @Test
    public void verifyBreadcrumbAndSocialSharingIsPresent() {
        boolean isStepTrue = photoPage.checkBreadcrumbAndSocialSharingIsPresent();
        Assert.assertTrue(isStepTrue, "Breadcrumb and social sharing is not present!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2894(Web),3507(Android_MWeb),QAAUT-4570(LH-MWeb-IOS): To verify widgets and images on gallery landing page")
    @Test
    public void verifyWidgetPhotoGalleryLandingPage() {
        boolean isStepTrue = photoPage.checkPhotoGalleryLandingPage();
        Assert.assertTrue(isStepTrue, "photo gallery landing failed!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Regression || QAAUT- 2893(Web),3537(Android_MWeb),QAAUT-4581(LH-MWeb-IOS): To Verify photo gallery landing page")
    @Test
    public void verifyPhotoGalleryLandingPageSubMenuClickable() {
        boolean isStepTrue = photoPage.checkPhotoGalleryLandingPageSubMenuClickable();
        Assert.assertTrue(isStepTrue, "All sub menu on photo gallery is not clickable!!!!!!!!");
    }
    @Author(name = "Raj")
    @Description("Regression || QAAUT- 3506(Android_MWeb)): To Verify photo gallery landing page sub menu on mweb")
    @Test
    public void verifyPhotoGalleryLandingPageSubMenu() {
        boolean isStepTrue = photoPage.checkPhotoGalleryLandingPageSubMenu();
        Assert.assertTrue(isStepTrue, "photo gallery landing page not visible!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6090(Mweb_IOS),QAAUT-6089(Mweb_Android), QAAUT-6088(Web), QAAUT- 3802(Android_AMP), QAAUT- 4601(IOS_AMP)): To verify All L2 Sub-Menu are present and giving 200 status code")
    @Test
    public void verifyAllL2SubMenuArePresentAndGivingOkStatusCode() {
        boolean isStepTrue = photoPage.checkL2SubMenuArePresentAndGivingOkStatusCode();
        Assert.assertTrue(isStepTrue, "L2 Sub-Menu are not present or not giving 200 status code on Photo Page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT- 3803(Android_AMP) QAAUT- 4602(IOS_AMP)): To verify aur padhe button on AMP photo landing page")
    @Test
    public void verifyAurPadheButtonOnAmpPhotoLandingPage() {
        boolean isStepTrue = photoPage.checkAurPadheButtonOnAmpPhotoLandingPage();
        Assert.assertTrue(isStepTrue, "Aur padhe button on AMP photo landing page not Working!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6178(LH-Web),QAAUT-6179(Android_MWeb),QAAUT-6180(Mweb_IOS),QAAUT- 3804(Android_AMP)), QAAUT- 4603(IOS_AMP): To verify breadcrumb and social sharing redirection on photo gallery detail page")
    @Test
    public void verifyBreadcrumbAndSocialSharingRedirectionOnPhotoGalleryDetailPage() {
        boolean isStepTrue = photoPage.checkBreadcrumbAndSocialSharingOnPhotoGallery();
        Assert.assertTrue(isStepTrue, "Breadcrumb and Social sharing on photo gallery detail page not working!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT- 3805(Android_AMP), QAAUT- 5691(IOS_AMP)): To verify photo gallery aur photo dekhe tab")
    @Test
    public void verifyPhotoGalleryAurPhotoDekheTab() {
        boolean isStepTrue = photoPage.checkPhotoGalleryAurPhotoDekheTabOnAmp();
        Assert.assertTrue(isStepTrue, "Aur Photo Dekhe tab is not Working!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5736(LH-Web),QAAUT-6132(LH-MWeb-Android): To verify social sharing option redirection in expand view for photo gallery")
    @Test
    public void verifySocialSharingOptionRedirectionInExpandViewForPhotoGallery() {
        boolean isStepTrue = photoPage.checkSharingOptionForPhotoGallery();
        Assert.assertTrue(isStepTrue, "Sharing buttons are not working!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5732(LH-Web): To verify Next and previous button on photo gallery page")
    @Test
    public void verifyNextAndPreviousButtonOnPhotoGalleryPage() {
        boolean isStepTrue = photoPage.checkNextAndPreviousForPhotoGallery();
        Assert.assertTrue(isStepTrue, "Next and previous for buttons are not working on photo gallery page!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-5734(LH-Web) ,QAAUT-5735(LH-MWeb-Android),QAAUT-6181(Mweb_IOS):To verify Chhod de option in photo gallery")
    @Test
    public void verifyChhodDeOptionInPhotoGallery() {
        boolean isStepTrue = photoPage.checkChhodDePhotoGallery();
        Assert.assertTrue(isStepTrue, "Next and previous for buttons are not working!!!!!!!!");
    }
    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT- 2584 (Web): To verify next/previous button functionality on photo expand view")
    @Test
    public void verifyNextPreviousButtonFunctionalityOnPhotoExpandView() {
        boolean isStepTrue;
        isStepTrue = photoPage.checkNextPreviousButtonFunctionalityOnPhotoExpandView();
        Assert.assertTrue(isStepTrue, "Photo gallery expand and auto slider failed!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT-3462(Android_MWeb),QAAUT-5967(Mweb_IOS): To verify swipe functionality on photo expand view")
    @Test
    public void verifySwipeFunctionalityOnPhotoExpandView() {
        boolean isStepTrue;
        isStepTrue = photoPage.checkSwipeFunctionalityOnPhotoExpandView();
        Assert.assertTrue(isStepTrue, "Photo gallery expand and auto slider failed!!!!!!!!");
    }

    @Author(name = "Himanshi Aggarwal")
    @Description("Sanity || QAAUT- 6191(Web),QAAUT-6192(Android_MWeb),QAAUT-6193(Mweb_IOS): To verify photo gallery widget on photo page is having 5 no of gallery and status code is 200")
    @Test
    public void verifyPhotoGalleryWidgetIsHaving5StoriesAndStatusIs200() {
        boolean isStepTrue;
        isStepTrue = photoPage.checkPhotoGalleryWidgetIsHaving5StoriesAndStatusIs200();
        Assert.assertTrue(isStepTrue, "Photo gallery widget is not loading!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6145 (Web),QAAUT-6146(Android_MWeb),QAAUT-6147(Mweb_IOS): To verify shuru se dekhen button functionality on photo detail page")
    @Test
    public void verifyShuruSeDekhenButtonFunctionalityOnPhotoDetailPage() {
        boolean isStepTrue;
        isStepTrue = photoPage.checkShuruSeDekhenButtonFunctionalityOnPhotoDetailPage();
        Assert.assertTrue(isStepTrue, "shuru se dekhen button functionality is not working!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6148 (Web),QAAUT-6149(Android_MWeb),QAAUT-6150(Mweb_IOS): To verify infinite scroll functionality on photo detail page")
    @Test
    public void verifyInfiniteScrollFunctionalityOnPhotoDetailPage() {
        boolean isStepTrue;
        isStepTrue = photoPage.checkInfiniteScrollFunctionalityOnPhotoDetailPage();
        Assert.assertTrue(isStepTrue, "infinite scroll functionality is not working for photo detail page!!!!!!!!");
    }

    @Author(name = "Raj")
    @Description("Sanity || QAAUT-6151 (Web),QAAUT-6152(Android_MWeb),QAAUT-6153(Mweb_IOS), QAAUT-6154(AMP_Android), QAAUT-6155(AMP_IOS): To verify related photo gallery widget on photo detail page with API")
    @Test
    public void verifyRelatedPhotoGalleryWidgetOnPhotoDetailPageWithApi() {
        boolean isStepTrue;
        isStepTrue = photoPage.checkRelatedPhotoGalleryWidgetOnPhotoDetailPageWithApi();
        Assert.assertTrue(isStepTrue, "Related photo gallery widgets are not displaying on photo detail page as per API!!!!!!!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6139(Web),QAAUT-6140(Android_MWeb),QAAUT-6141(LH-MWeb-IOS):To verify bane rahe functionality on expand view on photo detail page")
    @Test
    public void verifyBaneRaheFunctionalityOnExpandViewOnPhotoDetailPage() {
        boolean isStepTrue = photoPage.checkBaneRaheFunctionalityOnExpandViewOnPhotoDetailPage();
        Assert.assertTrue(isStepTrue, "Bane rahe functionality failed !!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6142(Web),QAAUT-6143(Android_MWeb),QAAUT-6144(LH-MWeb-IOS):To verify agli gallery option should be present and after clicking, should move to next gallery")
    @Test
    public void verifyAgliGalleryOptionShouldBePresentAndAfterClickingShouldMoveToNextGallery() {
        boolean isStepTrue = photoPage.checkAgliGalleryOptionShouldBePresentAndAfterClickingShouldMoveToNextGallery();
        Assert.assertTrue(isStepTrue, "Agli Gallery functionality is failed !!!");
    }

    @Author(name = "Lakshmi Tejaswi")
    @Description("Sanity || QAAUT-6136(Web),QAAUT-6137(Android_MWeb),QAAUT-6138(LH-MWeb-IOS):To verify pause or play functionality on expand view on photo detail page")
    @Test
    public void verifyPauseOrPlayFunctionalityOnExpandViewOnPhotoDetailPage() {
        boolean isStepTrue = photoPage.checkPauseOrPlayFunctionalityOnExpandViewOnPhotoDetailPage();
        Assert.assertTrue(isStepTrue, "Photo pause or play functionality is failed!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("Sanity || QAAUT- 2585 (Web),QAAUT-3426(Android_MWeb),QAAUT-5966(IOS_Mweb): To verify aanya gallery widget is present on photo detail page")
    @Test
    public void verifyAanyaGalleryWidgetIsPresentOnPhotoDetailPage() {
        boolean isStepTrue;
        isStepTrue = photoPage.checkPhotoGalleryWidget();
        Assert.assertTrue(isStepTrue, "Photo gallery aanya gallery not display!!!!!!!!");
    }
}
