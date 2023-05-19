package HT_TECH;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HT_TECH.generic.CommonNewsPage;
import com.pages.HT_TECH.web.NewsPage;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class NewsTest extends BaseTest {

    private static CommonNewsPage newsPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        newsPage = CommonNewsPage.getInstance();
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3831 Web || To verify breadcrumb is displayed on News Page")
    @Test
    public void verifyBreadcrumbNavigationNews() {
        boolean isBreadCrumbvisible = newsPage.checkNavigationLatestNews();
        Assert.assertTrue(isBreadCrumbvisible, "Navigation to News failed");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3833 Web || To verify News widget is having 10 stories and status is 200")
    @Test
    public void verifyTopNews() {
        boolean istopNewsClickable = newsPage.checkTopStoriesWidget();
        Assert.assertTrue(istopNewsClickable, "Top news not clikable and not giving 200 status");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3832 Web || To verify RHS ads are displayed on the News page")
    @Test
    public void verifyNewsRHSAds() {
        boolean istopNewsClickable = newsPage.checkNewsPageRHSAdsAreDisplayed();
        Assert.assertTrue(istopNewsClickable, "News page RHS ads are not displayed");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3835 Web || To verify Trending News heading at the click of search bar on News page")
    @Test
    public void verifyTrendingNewsHeading() {
        boolean isTrendingNewsHeadingVisible = newsPage.checkTrendingNewsHeadingOnClickingSearchBox();
        Assert.assertTrue(isTrendingNewsHeadingVisible, "Trending news heading not on search box");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3836 Web || To verify search bar on News page by giving valid keyword")
    @Test
    public void verifySearchUsingValidKeyword() {
        boolean isSearchValid;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchUsingValidKeyword");
        isSearchValid= newsPage.searchAnyProductUsingValidKeyword(params.get("ExpectedKeyword"));
        Assert.assertTrue(isSearchValid, "Search result not found");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3837 Web || To verify search bar on News page by giving special character")
    @Test
    public void verifySearchUsingSpecialCharacter() {
        boolean isErrorMsgDisplayed;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchUsingSpecialCharacter");
        isErrorMsgDisplayed= newsPage.searchUsingSpecialKeyword(params.get("SpecialCharacter"));
        Assert.assertTrue(isErrorMsgDisplayed, "Error msg not displayed");
    }



}
