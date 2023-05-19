package HT_AUTO;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.HT_AUTO.genericPages.CommonBikeDetailsPage;
import com.pages.HT_AUTO.genericPages.CommonHomePage;
import com.pages.HT_AUTO.genericPages.CommonLoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class HomePageTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage ;
    GlobalVars globalVars;

    @BeforeTest
    public void initialization() {
        globalVars = DriverController.setup(Constants.HT_AUTO);
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }


    @Author(name = "Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify left top stories widget is having 3 stories & all the stories are displayed")
    @Test
    public void verifyLeftSideStoriesOnHomePageAtTheTopDisplayed() {
        boolean isLeftStoriesDisplayed = homePage.verifyLeftStoriesAreDisplayed();
        Assert.assertTrue(isLeftStoriesDisplayed,"Left Top Stories size is not 3");
    }

    @Author(name = "Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify right top stories widget is having 5 stories & all the stories are displayed")
    @Test
    public void verifyRightSideStoriesOnHomePageAtTheTopDisplayed() {
        boolean isRightStoriesDisplayed = homePage.verifyRightStoriesAreDisplayed();
        Assert.assertTrue(isRightStoriesDisplayed,"Right Top Stories size is not 5");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the redirection to home page when user clicks on HTAuto logo")
    @Test
    public void verifyHTAutoLogoAndReloading(){
        boolean isStepTrue= homePage.verifyHTAutoLogoRedirection();
        Assert.assertTrue(isStepTrue,"HTAuto Logo reloading failed");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the redirection to home page when user clicks on Home option")
    @Test
    public void verifyHomePageInListAndReloading(){
        boolean isStepTrue= homePage.verifyHomePageRedirectionInList();
        Assert.assertTrue(isStepTrue,"Failed to clicked on Home Link on Home Page");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity -To verify the menu options are displayed such as HOME, Latest News, News and so on")
    @Test
    public void verifyHomePageOptionsAreDisplayed(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyHomePageOptionsAreDisplayed");
        String[] strSplit = params.get("homePageOptions").split(",");
        // Now convert string into ArrayList
        ArrayList<String> homeOptionsList = new ArrayList<String>(Arrays.asList(strSplit));

        boolean isStepTrue = homePage.verifyHomePageOptions(homeOptionsList);
        Assert.assertTrue(isStepTrue, "Either Home Page option list size not matched or Getting empty options as string");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify all menu options are clickable & status code is 200")
    @Test
    public void verifyHomePageOptionsAreClickableAndReturns200(){
        boolean isStepTrue = homePage.verifyHomePageOptionsAreClickable();
        Assert.assertTrue(isStepTrue, "Home Page option is not clickable and not getting 200 status code");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the title of top first image story on home page")
    @Test
    public void verifyTopFirstImageStoryTitle(){
        boolean isStepTrue = homePage.checkTopFirstStandardImageStory();
        Assert.assertTrue(isStepTrue, "Top first image story title not matched");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify all top stories widget are clickable & returns status code as 200")
    @Test
    public void verifyAllTopStoriesTitle(){
        boolean isStepTrue = homePage.checkAllTopStoriesTitle();
        Assert.assertTrue(isStepTrue, "Either Top Stories are not clickable or Stories are not equal to 7");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify advertisement is displayed at the TOP of home page")
    @Test
    public void verifyTopAdsDisplayed(){
        boolean isStepTrue = homePage.checkTopAdDisplaying_2();
        Assert.assertTrue(isStepTrue, "Top Header Ads not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify advertisement is displayed at the BOTTOM of home page")
    @Test
    public void verifyBottomAdsDisplayed(){
        boolean isStepTrue = homePage.checkBottomAdsDisplaying_3();
        Assert.assertTrue(isStepTrue, "Bottom Ads not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify three advertisements are displayed at the RHS of home page")
    @Test
    public void verifyRHSAdsDisplayed(){
        boolean isStepTrue = homePage.checkHomePageRHSAdsAreDisplayed_1();
        Assert.assertTrue(isStepTrue, "Right hand side Ads are not displaying");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user is able to click on Facebook icon")
    @Test
    public void verifyFaceBookIconClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyFBIcon();
        Assert.assertTrue(isStepTrue, "Facebook Icon is not clickable");
    }
    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user is able to click on YouTube icon")
    @Test
    public void verifyYouTubeIconClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyYoutubeIcon();
        Assert.assertTrue(isStepTrue, "Youtube Icon is not clickable");
    }
    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user is able to click on Twitter icon")
    @Test
    public void verifyTwitterIconClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyTwitterIcon();
        Assert.assertTrue(isStepTrue, "Twitter Icon is not clickable");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user redirects to car dealers page on clicking Locate Dealer widget")
    @Test
    public void verifyLocateDealersWidgetClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyLocateDealerWidgetRedirectionToDealerPage();
        Assert.assertTrue(isStepTrue, "Locate dealers widget is not clickable");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user is able to search car dealers by selecting brand and city from Locate Dealer widget")
    @Test
    public void searchCarDealersBySelectingBrandAndCity(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("searchCarDealersBySelectingBrandAndCity");
        boolean isStepTrue = homePage.searchCarDealersBySelectingBrandAndCity(params.get("ExpectedBrand"),params.get("ExpectedCity"));
        Assert.assertTrue(isStepTrue, "Not able to search the Car dealers");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top automobiles car gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyPopularCarUnderTopAutomobilesGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopAutomobilesCarGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue = homePage.checkTopAutomobilesCarPopularWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue, "Either Top Automobiles Popular Car widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top automobiles car gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyLatestCarUnderTopAutomobilesGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopAutomobilesCarGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue1 = homePage.checkTopAutomobilesCarLatestWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue1, "Either Top Automobiles Latest Car widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top automobiles car gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyUpcomingCarUnderTopAutomobilesGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopAutomobilesCarGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue2 = homePage.checkTopAutomobilesCarUpcomingWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue2, "Either Top Automobiles Upcoming Car widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top automobiles bike gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyPopularBikeUnderTopAutomobilesGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopAutomobilesBikeGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue = homePage.checkTopAutomobilesBikePopularWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue, "Either Top Automobiles Popular Bike widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top automobiles bike gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyLatestBikeUnderTopAutomobilesGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopAutomobilesBikeGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue1 = homePage.checkTopAutomobilesBikeLatestWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue1, "Either Top Automobiles Latest Bike widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top automobiles bike gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyUpcomingBikeUnderTopAutomobilesGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopAutomobilesBikeGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue2 = homePage.checkTopAutomobilesBikeUpcomingWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue2, "Either Top Automobiles Upcoming Bike widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top comparisons car gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyTopComparisonsCarGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopComparisonsCarGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue = homePage.checkTopComparisonsCarWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue, "Either Top Comparisons Car widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify top comparisons car gadgets links are clickable & returns status code as 200")
    @Test
    public void verifyTopComparisonsBikeGadgetsOnHomePageAndGivingOkStatusCode(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopComparisonsBikeGadgetsOnHomePageAndGivingOkStatusCode");
        boolean isStepTrue = homePage.checkTopComparisonsBikeWidget(Integer.parseInt(params.get("noOfCards")));
        Assert.assertTrue(isStepTrue, "Either Top Comparisons Bike widget is not clickable or not giving OK status");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify Trending news heading at the click of search bar")
    @Test
    public void verifyTrendingNewsHeadingOnClickingSearchBox(){
        boolean isStepTrue = homePage.checkTrendingNewsHeadingOnClickingSearchBox();
        Assert.assertTrue(isStepTrue, "Trending News Heading not displayed On Clicking Search Box");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify search bar by entering the Valid keyword")
    @Test
    public void searchAnyProductUsingValidKeyword(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("searchAnyProductUsingValidKeyword");
        boolean isStepTrue = homePage.searchAnyProductUsingValidKeyword(params.get("ExpectedBrand"));
        Assert.assertTrue(isStepTrue, "Not able to search any product");
    }

    @Author(name="Ayush")
    @Description("HT Auto Sanity Desktop - searchAnyProductUsingInValidKeyword")
    @Test
    public void searchAnyProductUsingInValidKeyword(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("searchAnyProductUsingInValidKeyword");
        boolean isStepTrue = homePage.searchAnyProductUsingInValidKeyword(params.get("ExpectedBrand"));
        Assert.assertTrue(isStepTrue, "No Search result text has not been matched");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify editor’s pick card links are clickable & returns status code as 200")
    @Test
    public void verifyEditorsPickCardAtRHS(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEditorsPickCardAtRHS");
        boolean isStepTrue = homePage.checkEditorPick(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Editors Pick widget FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify Trending this week card links are clickable & returns status code as 200")
    @Test
    public void verifyTrendingThisWeekCardAtRHS(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTrendingThisWeekCardAtRHS");
        boolean isStepTrue = homePage.checkTrendingThisWeek(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Trending this week card is not displayed");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify Latest News card links are clickable & returns status code as 200")
    @Test
    public void verifyLatestNewsCardAtRHS(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLatestNewsCardAtRHS");
        boolean isStepTrue = homePage.checkLatestNews(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Latest News card is not displayed");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify Explore car EMI card links are clickable & returns status code as 200")
    @Test
    public void verifyExploreCarEMICardAtRHS(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyExploreCarEMICardAtRHS");
        boolean isStepTrue = homePage.checkExploreCarEMI(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Explore Car EMI card is not displayed");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user redirects to latest news page on clicking Latest News card heading")
    @Test
    public void verifyLatestNewsCardHeadingClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyOnClickingLatestNewsCardHeadingRedirectionToLatestNewsPage();
        Assert.assertTrue(isStepTrue, "Latest News Card Heading is not clickable");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user redirects to car loan EMI calculator page on clicking Explore car EMI card heading")
    @Test
    public void verifyExploreCarEMICardHeadingClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyOnClickingExploreCarEMICardHeadingRedirectionToCarLoanEMICalculatorPage();
        Assert.assertTrue(isStepTrue, "Explore Car EMI card Heading is not clickable");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify search car by brand, budget & body type widget links are clickable & returns status code as 200")
    @Test
    public void verifySearchCarByBrandWidget(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchCarByBrandWidget");
        boolean isStepTrue = homePage.checkSearchCarByBrandWidget(Integer.parseInt(params.get("noOfBrands")));
        Assert.assertTrue(isStepTrue, "Search by Car brand is FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify search car by brand, budget & body type widget links are clickable & returns status code as 200")
    @Test
    public void verifySearchCarByBudgetWidget(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchCarByBudgetWidget");
        boolean isStepTrue = homePage.checkSearchCarByBudgetWidget(Integer.parseInt(params.get("noOfBudget")));
        Assert.assertTrue(isStepTrue, "Search by Car budget is FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify search car by brand, budget & body type widget links are clickable & returns status code as 200")
    @Test
    public void verifySearchCarByBodyTypeWidget(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchCarByBodyTypeWidget");
        boolean isStepTrue = homePage.checkSearchCarByBodyTypeWidget(Integer.parseInt(params.get("noOfBodyType")));
        Assert.assertTrue(isStepTrue, "Search by Car body type is FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify search bike by brand, budget & body type widget links are clickable & returns status code as 200")
    @Test
    public void verifySearchBikeByBrandWidget(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchBikeByBrandWidget");
        boolean isStepTrue = homePage.checkSearchBikeByBrandWidget(Integer.parseInt(params.get("noOfBrands")));
        Assert.assertTrue(isStepTrue, "Search by Bike brand is FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify search bike by brand, budget & body type widget links are clickable & returns status code as 200")
    @Test
    public void verifySearchBikeByBudgetWidget(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchBikeByBudgetWidget");
        boolean isStepTrue = homePage.checkSearchBikeByBudgetWidget(Integer.parseInt(params.get("noOfBudget")));
        Assert.assertTrue(isStepTrue, "Search by Bike budget is FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify search bike by brand, budget & body type widget links are clickable & returns status code as 200")
    @Test
    public void verifySearchBikeByBodyTypeWidget(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchBikeByBodyTypeWidget");
        boolean isStepTrue = homePage.checkSearchBikeByBodyTypeWidget(Integer.parseInt(params.get("noOfBodyType")));
        Assert.assertTrue(isStepTrue, "Search by Bike body type is FAILED!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify photo gallery links are clickable & returns status code as 200")
    @Test
    public void verifyPhotoGalleryOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPhotoGalleryOnHomePageAndGivingOkStatusCode");
        isStepTrue = homePage.checkPhotoGallery(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Photo Gallery widget is failed!!!!!!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify popular reviews links are clickable & returns status code as 200")
    @Test
    public void verifyPopularReviewsOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPopularReviewsOnHomePageAndGivingOkStatusCode");
        isStepTrue = homePage.checkPopularReviews(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Popular Reviews widget is failed!!!!!!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify latest videos links are clickable & returns status code as 200")
    @Test
    public void verifyLatestVideoOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLatestVideoOnHomePageAndGivingOkStatusCode");
        isStepTrue = homePage.checkLatestVideo(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Latest Video widget is failed!!!!!!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify web story links are clickable & returns status code as 200")
    @Test
    public void verifyWebStoryOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyWebStoryOnHomePageAndGivingOkStatusCode");
        isStepTrue = homePage.checkWebStory(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Web Story widget is failed!!!!!!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify electric vehicle news links are clickable & returns status code as 200")
    @Test
    public void verifyElectricVehicleNewsOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyElectricVehicleNewsOnHomePageAndGivingOkStatusCode");
        isStepTrue = homePage.checkElectricVehicleNews(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Electric Vehicle News widget is failed!!!!!!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify recommender for you links are clickable & returns status code as 200")
    @Test
    public void verifyRecommenderForYouOnHomePageAndGivingOkStatusCode(){
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyRecommenderForYouOnHomePageAndGivingOkStatusCode");
        isStepTrue = homePage.checkRecommenderForYou(Integer.parseInt(params.get("noOfStories")));
        Assert.assertTrue(isStepTrue, "Recommender For You widget is failed!!!!!!!!");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user redirects to photos page on clicking photo gallery heading")
    @Test
    public void verifyPhotoGalleryHeadingClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyOnClickingPhotoGalleryHeadingRedirectionToPhotosStoryPage();
        Assert.assertTrue(isStepTrue, "Photo Gallery Heading is not clickable");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user redirects to videos page on clicking Latest videos card heading")
    @Test
    public void verifyLatestVideosHeadingClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyOnClickingLatestVideoHeadingRedirectionToVideosStoryPage();
        Assert.assertTrue(isStepTrue, "Latest Videos Heading is not clickable");
    }

    @Author(name="Ayush")
    @Description("HTAUT-3521 || WEB || HTAuto Sanity - To verify the user redirects to electric vehicles page on clicking electric vehicle news heading")
    @Test
    public void verifyElectricVehicleNewsHeadingClickableAndDisplayed(){
        boolean isStepTrue = homePage.verifyOnClickingElectricVehicleNewsHeadingRedirectionToElectricVehicleStoryPage();
        Assert.assertTrue(isStepTrue, "Electric Vehicle News Heading is not clickable");
    }

}