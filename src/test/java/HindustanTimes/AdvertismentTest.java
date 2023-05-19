package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdvertismentTest extends BaseTest {
    private static CommonAdvertismentPage advertismentPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        advertismentPage = CommonAdvertismentPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Ravi,Priyanka,Imran")
    @Description("< QAAUT-510(Web), 533(mweb),619(AMP),557(iOSMweb),641(iOS-amp) >To verify ad are displaying: Inline Stories")
    @Test
    public void verifyAdsInlineStories() {
        boolean isStepTrue;
        isStepTrue = advertismentPage.checkAdsDisplayInLineStory();
        Assert.assertTrue(isStepTrue, "Ads in InLineStory not been Displayed");
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-507(web),QAAUT-887(android), 600(iOS),896(mWeb) : To verify ad are displaying: Home Page - Top Ad, RHS 2 Ads")
    @Test
    public void verifyAdDisplayingInHomePage() {
        boolean isStepTrue = false;
        isStepTrue = advertismentPage.checkAdDisplayingHomePage();
        Assert.assertTrue(isStepTrue, "checking ad displaying home Page has been Failed");
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-531(mweb), QAAUT-617(amp), QAAUT-889(web) : To verify ad are displaying: After every collection there should be an Ad")
    @Test
    public void verifyAdDisplayingAfterCollection() {
        boolean isStepTrue = false;
        isStepTrue = advertismentPage.checkAdDisplayingAtEndOfFirstCollection();
        Assert.assertTrue(isStepTrue, "Scroll down to first Collection has been Failed");
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-508, QAAUT-531(mweb), QAAUT-618(amp),QAAUT - 556(iOSmweb), QAAUT-640(ios-amp) : To verify ad are displaying: Section Pages: After every 3 stories")
    @Test
    public void verifyAdDisplayingAfterEveryCollection() {
        boolean isStepTrue = false;
        isStepTrue = advertismentPage.checkAdDisplayingAfterEveryCollection();
        Assert.assertTrue(isStepTrue, "checking ad displaying after every collection has been Failed");
    }

    @Author(name = "Mahantesh , Priyanka,Imran")
    @Description("QAAUT-885(amp),530(mweb), QAAUT-888,QAAUT -555(IOSmWeb)639(iOS-amp) : To verify ad are displaying: Home Page - Top Ad")
    @Test
    public void verifyAdDisplayingHomePageTopAd() {
        boolean isStepTrue = false;
        isStepTrue = advertismentPage.checkAdDisplayingAtEndOfFirstCollection();
        Assert.assertTrue(isStepTrue, "check Top Ad displaying has been Failed");
    }

    @Author(name = "Sambath kumar")
    @Description("QAAUT-879(Web) : To verify ad are displaying: Home page, Right hand side ads")
    @Test
    public void verifyAdsAreDisplayed() {
        boolean isStepTrue;
        isStepTrue = advertismentPage.checkAdsAreDisplayed();
        Assert.assertTrue(isStepTrue, "After every collection Ad has not been Displayed");
    }

    @Author(name = "Ravi")
    @Description("QAAUT- 886(AMP),QAAUT - 897(IOSmweb) 900 (iOS-amp): To verify ad are displaying: Home Page - Top Ad, RHS 2 Ads")
    @Test
    public void verifyAdDisplayWordCountAndAdRedirection() {
        boolean isStepTrue = false;
        isStepTrue = advertismentPage.checkAdDisplayWordCountAndAdRedirection();
        Assert.assertTrue(isStepTrue, " Ads Display and Redirection to Advertisement page failed");
    }

    @Author(name = "Shakeel Alam, Gulshan Tomar, Ravinder Singh,Harsh Sharma")
    @Description("QAAUT-1530(ios-mweb), QAAUT-1486(Web), QAAUT-1553(Android-amp),QAAUT-1508(Android-MWeb): To verify ad is displayed on top mast head on homepage , section page and subsection")
    @Test
    public void verifyHeaderAdsAreDisplayed() {
        boolean isStepTrue;
        isStepTrue = advertismentPage.checkHeaderAdsAreDisplayed();
        Assert.assertTrue(isStepTrue, "Header Ad has not been Displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1488(Web): To verify ads are displayed on RHS of the page")
    @Test
    public void verifyHomePageRHSAdsAreDisplayed() {
        boolean isStepTrue;
        isStepTrue = advertismentPage.checkHomePageRHSAdsAreDisplayed();
        Assert.assertTrue(isStepTrue, "HomePage RHS Ad has not been Displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1658(Android-Native): Verify that after the Header, Header Ad is displayed")
    @Test
    public void verifyHeaderAdDisplayed() {
        boolean isStepTrue;
        isStepTrue = advertismentPage.checkHeaderAdisDisplayed();
        Assert.assertTrue(isStepTrue, "Header Ad has not been Displayed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1824(Android-Native), QAAUT-1870(iOS): Verify that Top Ad is displayed on every Section Page.")
    @Test
    public void verifyTopAdDisplayOnEverySection() {
        boolean isStepTrue;
        isStepTrue = advertismentPage.checkTopAdDisplayOnEverySection();
        Assert.assertTrue(isStepTrue, "Top Ad is not displaying!!!!!");
    }
}
