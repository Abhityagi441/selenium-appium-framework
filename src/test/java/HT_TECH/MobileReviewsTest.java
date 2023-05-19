package HT_TECH;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HT_TECH.generic.CommonMobileNewsPage;
import com.pages.HT_TECH.generic.CommonMobileReviewsPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobileReviewsTest extends BaseTest {
    private static CommonMobileReviewsPage mobileReviewsPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        mobileReviewsPage = CommonMobileReviewsPage.getInstance();
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3840 Web || To verify breadcrumb is displayed on Mobile Reviews sectionn")
    @Test
    public void verifyBreadcrumbMobileNews() {
        boolean isBreadCrumbvisible = mobileReviewsPage.checkBreadCrumbsOnMobileReviews();
        Assert.assertTrue(isBreadCrumbvisible, "Breadcrumb of MobileReviews failed");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3841 Web || To verify Mobile News widget is having 10 stories and status is 200")
    @Test
    public void verifyTopMobileReviews() {
        boolean istopNewsClickable = mobileReviewsPage.checkTopStoriesWidgetOnMobileReviews();
        Assert.assertTrue(istopNewsClickable, "Top MobileReviews not clikable and not giving 200 status");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3843 Web || To verify RHS ads are displayed on the Mobile News page")
    @Test
    public void verifyMobileReviewsRHSAds() {
        boolean isRHSAdDispalyed = mobileReviewsPage.checkMobileReviewsPageRHSAdsAreDisplayed();
        Assert.assertTrue(isRHSAdDispalyed, "Mobile Reviews page RHS ads are not displayed");
    }
}
