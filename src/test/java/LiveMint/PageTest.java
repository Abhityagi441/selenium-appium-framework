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

public class PageTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    private static CommonPremiumStoryPage premiumStoryPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        premiumStoryPage = CommonPremiumStoryPage.getInstance();
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-780(web), 830(AMP-Android), 791(MWeb-Android), 802(MWeb-IOS), 840(AMP-IOS):Verify the page title")
    @Test
    public void verifyPageTitle() {
        boolean isStepTrue;
        isStepTrue = homePage.pageTitle();
        Assert.assertTrue(isStepTrue, "Page Title verification failed");
    }

    @Author(name = "Shakeel Alam, Manoj Patil, Ravikumar Makam")
    @Description("QAAUT-783(web), 814(android_native), 834(AMP-Android), 794(MWeb-Android), 805(MWeb-IOS), 823(ios_native), 843(AMP-IOS):Validate that these pages should not show blank data")
    @Test
    public void verifyPageNotBlank() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPageNotBlank");
        isStepTrue = homePage.pageContent(params.get("apiURL"));
        Assert.assertTrue(isStepTrue, "Page  is empty");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1298 (ios_native):Verify the Subscription pop up is appear to redirect the user on the plan if the new user/unsubscribed user is tapping on the try Epaper banner.")
    @Test
    public void verifyMintEpaperBanner() {
        boolean isStepTrue;
        isStepTrue = homePage.checkMintEPaperBanner();
        Assert.assertTrue(isStepTrue, "Mint Epaper verification failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1296(ios_native) QAAUT-1214(android_native):Verfiy the home page should scroll till the page ends")
    @Test
    public void verifyHomePageScrollsTillEnd() {
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePageSrollsTillEnd();
        Assert.assertTrue(isStepTrue, "Mint Epaper verification failed");
    }

    @Author(name = "Shakeel Alam, Giridhar Raj")
    @Description("QAAUT-1287 (ios_native),,QAAUT-1205(android_native):Verify the redirection flow")
    @Test
    public void verifyRedirectionFlow() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkAdsRedirection();
        Assert.assertTrue(isStepTrue, "redirection flow verification failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1295 (ios_native):Verify navigation by clicking on listed story on widget")
    @Test
    public void verifyStoryOnMintLoungeCarousel() {
        boolean isStepTrue;
        isStepTrue = homePage.clickAndVerifyMintLoungeStory();
        Assert.assertTrue(isStepTrue, "Mint Lounge carousel story verification failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1297(ios_native) :Verify nevigation by clicking on the mint genie banner")
    @Test
    public void verifyMintGenieBanner() {
        boolean isStepTrue;
        isStepTrue = homePage.checkMintGenieBanner();
        Assert.assertTrue(isStepTrue, "Mint Genie verification failed");
    }

    @Author(name = "Ravinder Singh,Giridhar Raj")
    @Description("QAAUT-1332 (ios_native),QAAUT-1250(android_native):Verify Mint Premium Carousel View All button")
    @Test
    public void verifyMintPremiumViewAllButton() {
        boolean isStepTrue;
            isStepTrue=homePage.checkViewAllButtonOnMintPremium();
        Assert.assertTrue(isStepTrue, "Mint Premium Page failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1290 (ios_native):ViewWall navigation")
    @Test
    public void verifyViewWallNavigation() {
        boolean isStepTrue;
        isStepTrue=homePage.checkAndVerifyViewAllOnMintPremiumCarousel();
        Assert.assertTrue(isStepTrue, "Mint Premium Page failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1292(ios_native) :Verify ViewWall Navigation(WSJ crousel)")
    @Test
    public void verifyViewWallNavigationOnWSJCarousel() {
        boolean isStepTrue;
        isStepTrue=homePage.checkAndVerifyViewAllOnWSJCarousel();
        Assert.assertTrue(isStepTrue, "Mint Premium Page failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1293 (ios_native):Verify listed story navigation(WSJ crousel)")
    @Test
    public void verifyStoryOnWSJCarousel() {
        boolean isStepTrue;
        isStepTrue=homePage.checkAndVerifyStoryOnWSJCarousel();
        Assert.assertTrue(isStepTrue, "Mint Premium Page failed");
    }

    @Author(name = "Ravinder Singh,Giridhar Raj")
    @Description("QAAUT-1294(ios_native) :QAAUT-1212(android_native): Verify ViewWall navigation(View All)")
    @Test
    public void verifyViewAllOnMintLoungeCarousel() {
        boolean isStepTrue;
        isStepTrue=homePage.checkAndVerifyViewAllOnMintLoungeCarousel();
        Assert.assertTrue(isStepTrue, "Mint Premium Page failed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4333(Web),QAAUT-4336(Android-Web),QAAUT-4337(iOS-Web),QAAUT-4338(Amp-Android),QAAUT-4340(Amp-iOS):Validate Premium page Companies sub nav have story listing")
    @Test
    public void verifyCompaniesPageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageCompaniesSubNav();
        Assert.assertTrue(isStepTrue, "Comapnies page stories are not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4531(Web),QAAUT-4532(Android-Web),QAAUT-4533(iOS-Web),QAAUT-4534(Amp-Android),QAAUT-4535(Amp-iOS):Validate Premium page Technology sub nav have story listing")
    @Test
    public void verifyTechnologyPageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageTechnologySubNav();
        Assert.assertTrue(isStepTrue, "Technology page stories are not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4878(Web),QAAUT-4879(Android-Web),QAAUT-4880(iOS-Web),QAAUT-4881(Amp-Android),QAAUT-4882(Amp-iOS):Validate Premium page Technology sub nav have story listing")
    @Test
    public void verifyAutoNewsPageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageAutoSubNav();
        Assert.assertTrue(isStepTrue, "Auto News page stories are not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4938(Web),QAAUT-4939(Android-Web),QAAUT-4940(iOS-Web),QAAUT-4941(Amp-Android),QAAUT-4942(Amp-iOS):Validate Premium page Technology sub nav have story listing")
    @Test
    public void verifyPersonalFinancePageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPagePersonalFinanceSubNav();
        Assert.assertTrue(isStepTrue, "Personal Finance page stories are not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4541(Web),QAAUT-4542(Android-Web),QAAUT-4543(iOS-Web),QAAUT-4544(Amp-Android),QAAUT-4545(Amp-iOS):Validate Premium page Money sub nav have story listing")
    @Test
    public void verifyMoneyPageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageMoneySubNav();
        Assert.assertTrue(isStepTrue, "Money page stories are not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4536(Web),QAAUT-4537(Android-Web),QAAUT-4538(iOS-Web),QAAUT-4539(Amp-Android),QAAUT-4540(Amp-iOS):Validate Premium page Market sub nav have story listing")
    @Test
    public void verifyMarketPageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageMarketsSubNav();
        Assert.assertTrue(isStepTrue, "Markets page stories are not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4328(Web),QAAUT-4329(Android-Web),QAAUT-4330(iOS-Web),QAAUT-4331(Amp-Android),QAAUT-4332(Amp-iOS):Validate Premium page Companies sub nav")
    @Test
    public void verifyCompaniesPageDataLoading() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageCompaniesDataLoad();
        Assert.assertTrue(isStepTrue, "Premium page data/stories are not displayed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4722(Web),QAAUT-4723(Android-Web),QAAUT-4724(iOS-Web),QAAUT-4725(Amp-Android),QAAUT-4726(Amp-iOS):Validate Premium page MutualFunds sub nav have story listing")
    @Test
    public void verifyMutualFundsPageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageMutualFundsSubNav();
        Assert.assertTrue(isStepTrue, "MutualFunds page stories are not displayed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4883(Web),QAAUT-4884(Android-Web),QAAUT-4885(iOS-Web),QAAUT-4886(Amp-Android),QAAUT-4887(Amp-iOS):Validate Premium page Industry sub nav have story listing")
    @Test
    public void verifyIndustryPageStory() {
        boolean isStepTrue;
        isStepTrue = premiumStoryPage.checkPremiumPageIndustrySubNav();
        Assert.assertTrue(isStepTrue, "Industry page stories are not displayed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4194(web), 4197(AMP-Android), 4195(MWeb-Android), 4196(MWeb-IOS), 4198(AMP-IOS):Validate Premium widget view all landing page")
    @Test
    public void verifyPremiumWidgetViewAll() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPremiumWidgetViewAll");
        isStepTrue = premiumStoryPage.checkPremiumWidgetViewAll(params.get("Heading"), params.get("Url"), params.get("AmpUrl"));
        Assert.assertTrue(isStepTrue, "Premium widget view all functionality failed");
    }


}