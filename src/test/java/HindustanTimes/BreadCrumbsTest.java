package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class BreadCrumbsTest extends BaseTest {
    private static CommonBreadCrumbsPage breadCrumbsPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        breadCrumbsPage = CommonBreadCrumbsPage.getInstance();
    }

    @Author(name = "Ravi")
    @Description("<QAAUT - 661(Web),670(mweb),676(amp),680(IOSWeb),(901-iOS-amp)>To verify breadcrumbs are displayed on all pages other than homepage: Home / India News Also url should also be changed according to breadcrumb")
    @Test
    public void verifyBreadcrumbNavigationIndiaNews() {
        boolean isBreadCrumbvisible = breadCrumbsPage.checkNavigationIndiaNews();
        Assert.assertTrue(isBreadCrumbvisible, "Navigation India news failed");
    }

    @Author(name = "Ravi,Imran")
    @Description("<QAAUT - 655(Web),656(mweb),658(amp),657(iOSweb),659(iOS-amp)>To verify breadcrumbs are displayed on all pages other than homepage: Home / Latest News Also url should also be changed according to breadcrumb")
    @Test
    public void verifyBreadcrumbNavigationLatestNews() {
        boolean isBreadCrumbvisible = breadCrumbsPage.checkNavigationLatestNews();
        Assert.assertTrue(isBreadCrumbvisible, "Navigation to Latest News failed");
    }

    @Author(name = "Ravi")
    @Description("<QAAUT - 660(web),685(mweb),671(amp),677(iOS-amp)>To verify breadcrumbs are displayed on all pages other than homepage: Home / Most Popular Also url should also be changed according to breadcrumb")
    @Test
    public void verifyBreadcrumbNavigationPopularNews() {
        boolean isBreadCrumbvisible = breadCrumbsPage.checkNavigationPopularNews();
        Assert.assertTrue(isBreadCrumbvisible, "Navigation to popular news failed");
    }

    @Author(name = "Ravi")
    @Description("<QAAUT -663(web),687(mweb),674(amp),682(IOSweb),668(iOS-amp) >To verify breadcrumbs are displayed on all pages other than homepage: Home / Cricket Also url should also be changed according to breadcrumb")
    @Test
    public void verifyBreadcrumbNavigationCricketNews() {
        boolean isBreadCrumbvisible = breadCrumbsPage.checkNavigationCricketNews();
        Assert.assertTrue(isBreadCrumbvisible, "Navigation to cricket news failed");
    }

    @Author(name = "Ravi")
    @Description("<QAAUT -664(web),689(mweb),673(amp),665(iOS-amp)>To verify breadcrumbs are displayed on all pages other than homepage: Home / Editorial Also url should also be changed according to breadcrumb")
    @Test
    public void verifyBreadcrumbNavigationEditorialNews() {
        boolean isBreadCrumbvisible;
        isBreadCrumbvisible = breadCrumbsPage.checkNavigationEditorialNews();
        Assert.assertTrue(isBreadCrumbvisible, "BreadCrumb Editorial-News Test Failed");
    }

    @Author(name = "Ravi")
    @Description("<QAAUT -678(web),688(mweb),667(amp),666(iOS-amp) >To verify breadcrumbs are displayed on all pages other than homepage: Home / Entertainment Also url should also be changed according to breadcrumb")
    @Test
    public void verifyBreadcrumbNavigationEntertainmentNews() {
        boolean isBreadCrumbvisible;
        isBreadCrumbvisible = breadCrumbsPage.checkNavigationEntertainmentNews();
        Assert.assertTrue(isBreadCrumbvisible, "BreadCrumb Entertainment-News Test Failed");
    }

    @Author(name = "Ravi")
    @Description("<QAAUT -662(web),686(mweb),675(amp),681(IOSweb)669(iOS-amp) >To verify breadcrumbs are displayed on all pages other than homepage: Home / Cities Also url should also be changed according to breadcrumb")
    @Test
    public void verifyBreadcrumbNavigationCitiesNews() {
        boolean isBreadCrumbvisible;
        isBreadCrumbvisible = breadCrumbsPage.checkNavigationCitiesNews();
        Assert.assertTrue(isBreadCrumbvisible, "BreadCrumb Cities-News Test Failed");
    }

    @Author(name = "Ravinder Singh, Gulshan Tomar")
    @Description("QAAUT-1432, QAAUT-1429 :To verify breadcrumb is displayed when user lands from google etc")
    @Test
    public void verifyBreadcrumbDisplayed() {
        boolean isBreadCrumbvisible;
        isBreadCrumbvisible = breadCrumbsPage.checkBreadcrumbVisible();
        Assert.assertTrue(isBreadCrumbvisible, "BreadCrumb Home and Page Name Test Failed");
    }

    @Author(name = "Harsh Sharma, Gulshan Tomar")
    @Description("QAAUT-1493(Android_MWeb), QAAUT-1479(Web) :To verify breadcrumb is displayed when user lands from google etc")
    @Test
    public void verifyBreadcrumbVisibleWhenUserLandsFromGoogleEtc() {
        boolean isBreadCrumbvisible;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBreadcrumbVisibleWhenUserLandsFromGoogleEtc");
        isBreadCrumbvisible = breadCrumbsPage.checkBreadcrumbVisibleWhenUserLandsFromGoogleEtc(params.get("googleUrl"),params.get("searchText"));
        Assert.assertTrue(isBreadCrumbvisible, "BreadCrumb Home and Page Name Test Failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-1539(Android amp): To verify breadcrumb is displayed when user lands from google etc")
    @Test
    public void verifyBreadcrumbDisplayedFromGoogle() {
        boolean isStepTrue;
        isStepTrue = breadCrumbsPage.checkBreadcrumbVisibleViaGoogle();
        Assert.assertTrue(isStepTrue, "BreadCrumb Home and Page Name Test Failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("(web): Verify Bread Crumb & On click redirection")
    @Test
    public void verifyBreadcrumbAndClickRedirection() {
        boolean isStepTrue;
        isStepTrue = breadCrumbsPage.checkBreadcrumbAndClickRedirection();
        Assert.assertTrue(isStepTrue, "BreadCrumb Home and Page Name Test Failed");
    }

}
