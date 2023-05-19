package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonSearchPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchTest extends BaseTest {
    private static CommonSearchPage searchPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        searchPage = CommonSearchPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-521(web), QAAUT-631(AMP), QAAUT-545(mweb), 610 (iOS), QAAUT-590(android native), QAAUT-653, QAAUT-569(ios-mweb) :To verify search is working")
    @Test
    public void verifySearchIsWorking() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchIsWorking");
        boolean isStepTrue;
        isStepTrue = searchPage.checkSearchIsWorking(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "check search working test case has been failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1411(web):To verify search is working")
    @Test
    public void VerifySearchButtonIsWorking() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchIsWorking");
        boolean isStepTrue;
        isStepTrue = searchPage.CheckSearchButtonIsWorking(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "check search working test case has been failed");
    }

    @Author(name = "Gulshan Tomar, Shakeel Alam")
    @Description("QAAUT-1640(Android-native), QAAUT-1705(iOS): Verify the redirection when user taps on the Search option")
    @Test
    public void verifySearchOptionRedirection() {
        boolean isStepTrue = searchPage.checkSearchButtonRedirection();
        Assert.assertTrue(isStepTrue, "Search Option Redirection Failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1706(Android-native): Verify the redirection on tapping Search option on Explore App")
    @Test
    public void verifySearchPageRedirectionFromExplore() {
        boolean isStepTrue = searchPage.checkSearchPageRedirectionFromExplore();
        Assert.assertTrue(isStepTrue, "Search Option Redirection Failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1714(iOS),QAAUT-1717(Android-native): Verify the redirection on tapping Search option on Profile Page")
    @Test
    public void verifySearchOptionRedirectionProfilePage() {
        boolean isStepTrue = searchPage.checkSearchButtonRedirectionProfilePage();
        Assert.assertTrue(isStepTrue, "Search Option Redirection Failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1719(iOS),QAAUT-1720(Android-Native): Verify the redirection on tapping E-Paper option on the Profile page")
    @Test
    public void verifyEPaperOption() {
        boolean isStepTrue = searchPage.checkEPaperOption();
        Assert.assertTrue(isStepTrue, "E Paper Option Failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1863(Android-Native): Verify the redirection on tapping E-Paper option on Explore Page.")
    @Test
    public void verifyEPaperOptionFromExplore() {
        boolean isStepTrue = searchPage.checkEPaperOptionFromExplore();
        Assert.assertTrue(isStepTrue, "E Paper Option Failed on Explore page!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3575(iOS-Native), QAAUT-3576(Android-Native): Verify that on the Cricket Page, Search option is displayed")
    @Test
    public void verifySearchOptionInCricketPage() {
        boolean isStepTrue = searchPage.checkSearchOptionInCricketPage();
        Assert.assertTrue(isStepTrue, "Search option Displayed in Cricket Page failed !!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3577(iOS-Native), QAAUT-3578(Android-Native): Verify the redirection when user taps on the back button displayed on the Search Page")
    @Test
    public void verifySearchOptionWhenTabOnBackButton() {
        boolean isStepTrue = searchPage.checkSearchOptionWhenTabOnBackButton();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on the back button displayed on the Search Page failed !!!!!!!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3602(Android-Native),QAAUT-3601(iOS-Native: Android Native: Verify the redirection when user taps on any story displayed on the Latest News section on the search page")
    @Test
    public void verifySearchOptionRedirectionOnLatestNewsPage() {
        boolean isStepTrue = searchPage.checkStoryPageOnSearchPage();
        Assert.assertTrue(isStepTrue, "Search Option Redirection Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3609(Android-Native),QAAUT-3599(iOS-Native): Android Native: Verify the redirection when user taps on the View All link displayed for Latest News")
    @Test
    public void verifyViewALlRedirectionOnSearchPage() {
        boolean isStepTrue = searchPage.checkViewAllOnSearchPage();
        Assert.assertTrue(isStepTrue, "Search Option Redirection Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3598(Android-Native),QAAUT-3597(iOS-native): Android Native: Verify that on the search page, by default Latest News is displayed")
    @Test
    public void verifyDefaultLatestNewsOnSearchPage() {
        boolean isStepTrue = searchPage.checkDefaultLatestNewsOnSearchPage();
        Assert.assertTrue(isStepTrue, "Search Option Redirection Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3596(Android-Native),QAAUT-3595(iOS Native): Android Native: Verify that user is able to search when user is on any Section Page")
    @Test
    public void verifyCricketNewsOnSearchPage() {
        boolean isStepTrue = searchPage.checkCricketNewsOnSearchPage();
        Assert.assertTrue(isStepTrue, "Cricket news Option Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3579(iOS-Native), QAAUT-3580(Android-Native): Verify that on the search page, lens icon, Text box and voice icon is displayed")
    @Test
    public void verifyLensIconTextBoxAndVoiceIcon() {
        boolean isStepTrue = searchPage.checkLensIconTextBoxAndVoiceIcon();
        Assert.assertTrue(isStepTrue, "lens icon, Text box and voice icon displayed on the Search Page failed !!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3581(iOS-Native), QAAUT-3582(Android-Native): Verify that when user enter any character then watermark on the text box is removed")
    @Test
    public void verifyWatermarkRemovedIfEnterAnyChar() {
        boolean isStepTrue = searchPage.checkWatermarkRemovedIfEnterAnyChar();
        Assert.assertTrue(isStepTrue, "watermark on the text box is removed failed !!!!!!!!");

    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3698(Android-Native),QAAUT-3697,Verify that when user search, then results appears in full screen ")
    @Test
    public void verifySearchWorkingOnSearchPage() {
        boolean isStepTrue = searchPage.checkSearchIsWorkingOnSearchPage();
        Assert.assertTrue(isStepTrue, "Search is not Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3702(Android-Native),QAAUT-3701,Verify that when user searches then options like News, Photos and Videos is displayed ")
    @Test
    public void verifyLabelsDisplayedOnSearchPage() {
        boolean isStepTrue = searchPage.checkNewsPhotosVideosLabelsOnSearchPage();
        Assert.assertTrue(isStepTrue, "Search is not Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3703(Android-Native),QAAUT-3704,Verify that by default, News is selected")
    @Test
    public void verifyDefaultNewsDisplayedOnSearchPage() {
        boolean isStepTrue = searchPage.checkDefaultNewsDisplayedOnSearchPage();
        Assert.assertTrue(isStepTrue, "Search is not Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3708(Android-Native),QAAUT-3707,Verify that after the horizontal line, Text 'Showing 'number of result' for ' Search Keyword' in News' is displayed")
    @Test
    public void verifyNumberOfSearchResultDisplayedOnSearchPage() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNumberOfSearchResultDisplayedOnSearchPage");
        String expectedMessage=params.get("expectedMessage");
        boolean isStepTrue = searchPage.checkNumberOfSearchResultsDisplayedOnSearchPage(expectedMessage);
        Assert.assertTrue(isStepTrue, "Search is not Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3709(iOS-Native),QAAUT-3710,Verify that user is able to tap on the story")
    @Test
    public void verifyStoriesTappableOnSearchPage() {
        boolean isStepTrue = searchPage.checkStoryTappableOnSearchPage();
        Assert.assertTrue(isStepTrue, "Stories are not tappable");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3989(Android-Native)-QAAUT-4350(iOS-Native), Verify that on the Home Page, Search option is displayed")
    @Test
    public void verifySearchOptionOnHomePage() {
        boolean isStepTrue = searchPage.checkSearchOptionOnHomePage();
        Assert.assertTrue(isStepTrue,"After E-Paper option Search Option display failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3990(Android-Native)-QAAUT-4351(iOS-Native), Verify that on the Quickread Page, Search option is displayed")
    @Test
    public void verifySearchOptionOnQuickreadsPage() {
        boolean isStepTrue = searchPage.checkSearchOptionOnQuickreadsPage();
        Assert.assertTrue(isStepTrue,"After E-Paper option Search Option display failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3991(Android-Native)-QAAUT-4352(iOS-Native), Verify that on the Premium Page, Search option is displayed")
    @Test
    public void verifySearchOptionOnPremiumPage() {
        boolean isStepTrue = searchPage.checkSearchOptionOnPremiumPage();
        Assert.assertTrue(isStepTrue,"After E-Paper option Search Option display failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-3992(Android-Native)-QAAUT-4353(iOS-Native), Verify that on the Quickread Page, Search option is displayed")
    @Test
    public void verifySearchOptionOnExplorePage() {
        boolean isStepTrue = searchPage.checkSearchOptionOnExplorePage();
        Assert.assertTrue(isStepTrue,"After E-Paper option Search Option display failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3594(Android-Native),QAAUT-3593(iOS Native):  Verify that user is able to search when user is on the Cricket Page")
    @Test
    public void verifySearchOnCricketPage() {
        boolean isStepTrue = searchPage.checkSearchOnCricketPage();
        Assert.assertTrue(isStepTrue, "Cricket news Option Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3592(Android-Native),QAAUT-3591(iOS Native):  Verify that user is able to search when user is on the Premium Page")
    @Test
    public void verifySearchOnPremiumPage() {
        boolean isStepTrue = searchPage.checkSearchOnPremiumPage();
        Assert.assertTrue(isStepTrue, "Premium news Option Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3590(Android-Native),QAAUT-3589(iOS Native): Verify that user is able to search when user is on the Quickreads Page")
    @Test
    public void verifySearchOnQuickreadsPage() {
        boolean isStepTrue = searchPage.checkSearchOnQuickReadsPage();
        Assert.assertTrue(isStepTrue, "Quickreads news Option Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3588(Android-Native),QAAUT-3587(iOS Native): Verify that user is able to search when user is on the Home Page")
    @Test
    public void verifySearchOnHomePage() {
        boolean isStepTrue = searchPage.checkSearchOnHomePage();
        Assert.assertTrue(isStepTrue, "Quickreads news Option Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3584(Android-Native),QAAUT-3583(iOS Native): Verify that bottom nav is displayed when user is on the search page")
    @Test
    public void verifyBottomNavOnSearchPage() {
        boolean isStepTrue = searchPage.checkBottomNavOnSearchPage();
        Assert.assertTrue(isStepTrue, "Quickreads news Option Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3586(Android-Native),QAAUT-3585(iOS Native): Verify that user is able to tap on the option displayed on the bottom nav when user is on the Search page")
    @Test
    public void verifyBottomNavNavigationOnSearchPage() {
        boolean isStepTrue = searchPage.checkBottomNavNavigationOnSearchPage();
        Assert.assertTrue(isStepTrue, "Quickreads news Option Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3512(Android-Native): Verify that after each story on the news, a horizontal line should be displayed")
    @Test
    public void verifyHorizontalLineInEachStoryInNewsOnSearchPage() {
        boolean isStepTrue = searchPage.checkHorizontalLineInEachStoryInNewsOnSearchPage();
        Assert.assertTrue(isStepTrue, "horizontal line in each story displayed Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3719 (iOS-Native), QAAUT-3720 (Android-Native): Verify that user is able to share the story from the search page")
    @Test
    public void verifyShareStoryOptionInSearchPage() {
        boolean isStepTrue = searchPage.checkShareStoryOptionInSearchPage();
        Assert.assertTrue(isStepTrue, "User is able to share the story from the search page Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3721 (iOS-Native), QAAUT-3722 (Android-Native): Verify that when user taps on the section displayed on the story then user will be redirected to that section")
    @Test
    public void verifyRedirectToSectionFromSearchPage() {
        boolean isStepTrue = searchPage.checkRedirectToSectionFromSearchPage();
        Assert.assertTrue(isStepTrue, "redirected to that section Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3724 (Android-Native): Verify that user is able to scroll down on the news section to see the story")
    @Test
    public void verifyScrollDownInNewsSectionINSearchPage() {
        boolean isStepTrue = searchPage.checkScrollDownInNewsSectionINSearchPage();
        Assert.assertTrue(isStepTrue, "Scroll down on the news section to see the story Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3726 (Android-Native): Verify the redirection when user taps on the Photos option")
    @Test
    public void verifyRedirectToPhotosInSearchPage() {
        boolean isStepTrue = searchPage.checkRedirectToPhotosInSearchPage();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on the Photos option Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3728 (Android-Native): Verify that when user taps on the Photos option then Photos option is displayed as selected")
    @Test
    public void verifyPhotosOptionDisplayedAsSelectedInSearchPage() {
        boolean isStepTrue = searchPage.checkPhotosOptionDisplayedAsSelectedInSearchPage();
        Assert.assertTrue(isStepTrue, "Photos option is displayed as selected Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3730(Android-Native)- Verify that after the photos option text Showing number of result for Search Keyword in Photos is displayed")
    @Test
    public void verifyNumberOfResultInPhotosOnSearchPage() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNumberOfResultInPhotosOnSearchPage");
        String expectedMessage=params.get("expectedMessage");
        boolean isStepTrue = searchPage.checkNumberOfResultInPhotosOnSearchPage(expectedMessage);
        Assert.assertTrue(isStepTrue, "Text Showing number of result for Search Keyword in Photos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3732 (Android-Native): Verify the redirection when user taps on any story displayed on the Photos")
    @Test
    public void verifyRedirectToStoryFromPhotosInSearchPage() {
        boolean isStepTrue = searchPage.checkRedirectToStoryFromPhotosInSearchPag();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on any story displayed on the Photos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3734(Android-Native): Verify the redirection when user taps on the Video option")
    @Test
    public void verifyRedirectToVideosInSearchPage() {
        boolean isStepTrue = searchPage.checkRedirectToVideosInSearchPage();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on the Video option");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3736 (Android-Native): Verify that when user taps on the Videos option then Videos option is displayed as selected")
    @Test
    public void verifyVideosOptionDisplayedAsSelectedInSearchPage() {
        boolean isStepTrue = searchPage.checkVideosOptionDisplayedAsSelectedInSearchPage();
        Assert.assertTrue(isStepTrue, "Videos option is displayed as selected Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3730(Android-Native)- Verify that after the Videos option text Showing 'number of result' for Search Keyword in Videos is displayed")
    @Test
    public void verifyNumberOfResultInVideosOnSearchPage() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNumberOfResultInVideosOnSearchPage");
        String expectedMessage=params.get("expectedMessage");
        boolean isStepTrue = searchPage.checkNumberOfResultInVideosOnSearchPage(expectedMessage);
        Assert.assertTrue(isStepTrue, "Text Showing number of result for Search Keyword in Videos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3740 (Android-Native): Verify the redirection when user taps on any story displayed on the Videos")
    @Test
    public void verifyRedirectToStoryFromVideosInSearchPage() {
        boolean isStepTrue = searchPage.checkRedirectToStoryFromVideosInSearchPag();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on any story displayed on the Videos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3741 (iOS-Native), QAAUT-3742 (Android-Native): Verify the behaviour when user search with keyword and no story was found")
    @Test
    public void verifySearchForNoStoryFoundInSearchPage() {
        boolean isStepTrue = searchPage.checkSearchForNoStoryFoundInSearchPage();
        Assert.assertTrue(isStepTrue, "Behaviour when user search with keyword and no story was found Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3745 (Android-Native): Verify that if there is no related search story then You May also like stories are displayed in News")
    @Test
    public void verifyTitleAlsoLikeInNewsTabInSearchPage() {
        boolean isStepTrue = searchPage.checktitleAlsoLikeInNewsTabInSearchPage();
        Assert.assertTrue(isStepTrue, "You May also like stories are displayed in News Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3748 (Android-Native): Verify that if there is no related search story then You May also like stories are displayed in Photos")
    @Test
    public void verifyTitleAlsoLikeInPhotosTabInSearchPage() {
        boolean isStepTrue = searchPage.checkTitleAlsoLikeInPhotosTabInSearchPage();
        Assert.assertTrue(isStepTrue, "You May also like stories are displayed in Photos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3748 (Android-Native): Verify that if there is no related search story then You May also like stories are displayed in Videos")
    @Test
    public void verifyTitleAlsoLikeInVideosTabInSearchPage() {
        boolean isStepTrue = searchPage.checkTitleAlsoLikeInVideosTabInSearchPage();
        Assert.assertTrue(isStepTrue, "You May also like stories are displayed in Videos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3753 (Android-Native): Verify the redirection when user taps view all link for You may also like for News")
    @Test
    public void verifyRedirectToTitleAlsoLikeWhenTabInViewAllInNews() {
        boolean isStepTrue = searchPage.checkRedirectToTitleAlsoLikeWhenTabInViewAllInNews();
        Assert.assertTrue(isStepTrue, "redirection when user taps view all link for You may also like for News Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3755 (Android-Native): Verify the redirection when user taps view all link for You may also like for Photos")
    @Test
    public void verifyRedirectToTitleAlsoLikeWhenTabInViewAllInPhotos() {
        boolean isStepTrue = searchPage.checkRedirectToTitleAlsoLikeWhenTabInViewAllInPhotos();
        Assert.assertTrue(isStepTrue, "redirection when user taps view all link for You may also like for Photos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3757 (Android-Native): Verify the redirection when user taps view all link for You may also like for Videos")
    @Test
    public void verifyRedirectToTitleAlsoLikeWhenTabInViewAllInVideos() {
        boolean isStepTrue = searchPage.checkRedirectToTitleAlsoLikeWhenTabInViewAllInVideos();
        Assert.assertTrue(isStepTrue, "redirection when user taps view all link for You may also like for Videos Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3758 (iOS-Native), QAAUT-3759 (Android-Native): Verify that at the end of the Search page - Latest Topics heading is displayed")
    @Test
    public void verifyScrollDownTillLatestTopicInSearchPage() {
        boolean isStepTrue = searchPage.checkScrollDownTillLatestTopicInSearchPage();
        Assert.assertTrue(isStepTrue, "Latest Topics heading is displayed Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3762 (iOS-Native), QAAUT-3763 (Android-Native): Verify the redirection when user taps on any topic displayed in the search page")
    @Test
    public void verifyRedirectToStoryFromLatestTopicInSearchPage() {
        boolean isStepTrue = searchPage.checkRedirectToStoryFromLatestTopicInSearchPage();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on any topic displayed in the search page Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3765 (Android-Native): Verify that when user performed a search then Latest topic should not be displayed")
    @Test
    public void verifyLatestTopicNotDisplayIfSearchAnyKey() {
        boolean isStepTrue = searchPage.checkLatestTopicNotDisplayIfSearchAnyKey();
        Assert.assertTrue(isStepTrue, "User performed a search then Latest topic should not be displayed Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3767 (iOS-Native), QAAUT-3768 (Android-Native): Verify the redirection when user open any story from latest topic and tap on back button")
    @Test
    public void verifyRedirectToSearchIfTabOnBackBtnFromLatestTopicStory() {
        boolean isStepTrue = searchPage.checkRedirectToSearchIfTabOnBackBtnFromLatestTopicStory();
        Assert.assertTrue(isStepTrue, "Redirection when user open any story from latest topic and tap on back button Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3769 (iOS-Native), QAAUT-3770 (Android-Native): Verify the redirection when user taps on view all link for latest news")
    @Test
    public void verifyRedirectToLatestNewsViewAllInSearchPage() {
        boolean isStepTrue = searchPage.checkRedirectToLatestNewsViewAllInSearchPage();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on view all link for latest news Failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify 'trending news' must be there before search anything(session id:85a4993d86f3278ae2c94693fc4eef4dc4fed68d )")
    @Test
    public void verifyTrendingNews() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyTrendingNews");
        boolean isStepTrue = searchPage.checkTrendingNews(param.get("searchPageUrl"));
        Assert.assertTrue(isStepTrue,"trending news failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: VVerify result data must be match with searched keyword(session id:2e22f6b6caaf1157113f783cbbb998c7aca4dcc1 )")
    @Test
    public void verifyResultDataWithSearchKeyword() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyResultDataWithSearchKeyword");
        boolean isStepTrue = searchPage.checkResultDataWithSearchKeyword(param.get("searchPageUrl"),param.get("name"));
        Assert.assertTrue(isStepTrue,"result data not matched failed");
    }
}