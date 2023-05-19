package HT_TECH;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HT_TECH.generic.CommonMobileNewsPage;
import com.pages.HT_TECH.generic.CommonNewsPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobileNewsTest extends BaseTest {
    private static CommonMobileNewsPage mobileNewsPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        mobileNewsPage = CommonMobileNewsPage.getInstance();
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3830 Web || To verify breadcrumb is displayed on Mobile News Section")
    @Test
    public void verifyBreadcrumbMobileNews() {
        boolean isBreadCrumbvisible = mobileNewsPage.checkBreadCrumbsOnMobileNews();
        Assert.assertTrue(isBreadCrumbvisible, "Breadcrumb of MobileNews failed");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3841 Web || To verify Mobile News widget is having 10 stories and status is 200")
    @Test
    public void verifyTopMobileNews() {
        boolean istopNewsClickable = mobileNewsPage.checkTopStoriesWidgetOnMobileNews();
        Assert.assertTrue(istopNewsClickable, "Top Mobilenews not clikable and not giving 200 status");
    }


    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-3843 Web || To verify RHS ads are displayed on the Mobile News page")
    @Test
    public void verifyNewsRHSAds() {
        boolean isRHSAdDispalyed = mobileNewsPage.checkNewsPageRHSAdsAreDisplayed();
        Assert.assertTrue(isRHSAdDispalyed, "Mobile News page RHS ads are not displayed");
    }

}
