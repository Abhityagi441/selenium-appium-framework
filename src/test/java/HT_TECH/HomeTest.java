package HT_TECH;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HT_TECH.generic.CommonHomePage;
import com.pages.HT_TECH.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private static CommonHomePage homePage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();

    }

    @Author(name="Farheen")
    @Description("Sanity")
    @Test
    public void verifyLeftTopWidget(){
       boolean actual1= homePage.checkLeftTopWidget();
        Assert.assertTrue(actual1,"leftTopWidget size is not 3");

    }

    @Author(name="Farheen")
    @Description("Sanity--widget")
    @Test
    public void verifyRightTopWidget(){
        boolean actual1= homePage.checkRightTopWidget();
        Assert.assertTrue(actual1,"rightTopWidget size is not 4");
    }

    @Author(name="Farheen")
    @Description("Sanity--widget")
    @Test
    public void verifySponsoredLink(){

        boolean actual1= homePage.checkSponsoredLink();
        Assert.assertTrue(actual1,"sponsored link not clickable");
    }

    @Author(name="Farheen")
    @Description("homepage-sanity")
    @Test
    public void verifyHTLogoAndReloading(){
        boolean isStepTrue= homePage.checkHTAutoRedirection();
        Assert.assertTrue(isStepTrue,"HTLogo reloading failed");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyTopStoriesWidgetOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkTopStoriesWidget();
        Assert.assertTrue(isStepTrue, "Top Stories widget is failed!!!!!!!!");
    }


    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyRightWidgetOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkRightStoriesWidget();
        Assert.assertTrue(isStepTrue, "Top Stories widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyMobileGadgetsOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkTopGadgetMobiles();
        Assert.assertTrue(isStepTrue, "Top Mobile widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyLaptopGadgetsOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkTopGadgetLaptop();
        Assert.assertTrue(isStepTrue, "Top Mobile widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyMobileGadgetSearchOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkGadgetSearchMobilesBrand();
        Assert.assertTrue(isStepTrue, "Mobile Gadget Search widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyTabletGadgetSearchOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkGadgetSearchTablets();
        Assert.assertTrue(isStepTrue, "Tablet Gadget Search widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyLaptopGadgetSearchOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkGadgetSearchLaptops();
        Assert.assertTrue(isStepTrue, "Laptop Gadget Search widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyPopularReviewsOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkPopularReviews();
        Assert.assertTrue(isStepTrue, "Popular review widget is failed!!!!!!!!");
    }


    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyLatestVideosOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkLatestVideo();
        Assert.assertTrue(isStepTrue, "Latest video widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyWebStoryOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkWebStory();
        Assert.assertTrue(isStepTrue, "WebStorywidget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyLatestNewsOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkLatestNews();
        Assert.assertTrue(isStepTrue, "Latest news widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyTipsAndTrick(){
        boolean isStepTrue;
        isStepTrue = homePage.checkTipTrick();
        Assert.assertTrue(isStepTrue, "Tips and trick is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyEditorPick(){
        boolean isStepTrue;
        isStepTrue = homePage.checkEditorPick();
        Assert.assertTrue(isStepTrue, "editor pick is failed!!!!!!!!");
    }
    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyRHSAdDisplayed(){
        boolean isStepTrue;
        isStepTrue = homePage.checkHomePageRHSAdsAreDisplayed();
        Assert.assertTrue(isStepTrue, " RHS Advertisement load is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyTopAdDisplayed(){
        boolean isStepTrue;
        isStepTrue = homePage.checkAdDisplayingTopAd();
        Assert.assertTrue(isStepTrue, "Top ad load is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyBottomAdDisplayed(){
        boolean isStepTrue;
        isStepTrue = homePage.checkAdDisplayingTopAd();
        Assert.assertTrue(isStepTrue, "Bottom ad load is failed!!!!!!!!");
    }




    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyPhotoGalleryOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkPhotoGallery();
        Assert.assertTrue(isStepTrue, "Latest video widget is failed!!!!!!!!");
    }
    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyGadgetComparisonOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkGadgetComparisonMobile();
        Assert.assertTrue(isStepTrue, "Gadget Comparison widget is failed!!!!!!!!");
    }

    @Author(name="Farheen")
    @Description("sanity homepage")
    @Test
    public void verifyTabletGadgetsOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        isStepTrue = homePage.checkTopGadgetTablet();
        Assert.assertTrue(isStepTrue, "Latest Tablet widget is failed!!!!!!!!");
    }

    @Author(name = "Farheen Naaz")
    @Description("Sanity ||  To verify fbIcon on home page")
    @Test
    public void verifyFbIcon() {
        boolean isStepTrue;
        isStepTrue = homePage.checkFbIcon();
        Assert.assertTrue(isStepTrue, "FbIcon clicked failed!!!!!!!!");
    }

    @Author(name = "Farheen Naaz")
    @Description("Sanity ||  To verify twitter on home page")
    @Test
    public void verifyTwitterIcon() {
        boolean isStepTrue;
        isStepTrue = homePage.checkTwitterIcon();
        Assert.assertTrue(isStepTrue, "TwitterIcon clicked failed!!!!!!!!");
    }

    @Author(name = "Farheen Naaz")
    @Description("Sanity ||  To verify yotube on home page")
    @Test
    public void verifyyoutubeIcon() {
        boolean isStepTrue;
        isStepTrue = homePage.checkyoutubeIcon();
        Assert.assertTrue(isStepTrue, "youtube clicked failed!!!!!!!!");
    }



}
