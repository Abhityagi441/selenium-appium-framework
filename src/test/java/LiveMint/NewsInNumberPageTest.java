
package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonNewsInNumberPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


class NewsInNumberPageTest extends BaseTest {
    private static CommonNewsInNumberPage newsInNumberPage;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        newsInNumberPage = CommonNewsInNumberPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5847(android_native): Verify that there a widget on Home page for News in Number.")
    @Test
    public void verifyWidgetNewsInNumberOnHomepage() {
        boolean isStepTrue = newsInNumberPage.checkNewsInNumberWidgetOnHomePage();
        Assert.assertTrue(isStepTrue, "widget news in number verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5865(android_native):Verify that only one card is visible on news in number listing page")
    @Test
    public void verifyOnlyOneCardVisibleOnNewsInNumberListingPage() {
        boolean isStepTrue = newsInNumberPage.checkOnlyOneCardVisibleOnNewsInNumberListingPage();
        Assert.assertTrue(isStepTrue, "only one card is not visible verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5862,5863(android_native):Verify Three Dots And Back Functionality On News In Number Listing Page")
    @Test
    public void verifyThreeDotsAndBackFunctionalityOnNewsInNumberListingPage() {
        boolean isStepTrue = newsInNumberPage.checkThreeDotsAndBackFunctionalityOnNewsInNumberListingPage();
        Assert.assertTrue(isStepTrue, "Three dots & back not visible verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5864(android_native):Verify title and sub title On News In Number Listing Page")
    @Test
    public void verifyTitleAndSubTitleOnNewsInNumberListingPage() {
        boolean isStepTrue = newsInNumberPage.checkTitleAndSubTitleOnNewsInNumberListingPage();
        Assert.assertTrue(isStepTrue, "title & sub title not showing verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5852(android_native):Verify that there are different types of cards with different type of information.")
    @Test
    public void verifyDiffCardInfoOnWidgetNewsInNumber() {
        boolean isStepTrue = newsInNumberPage.checkDiffCardInfoOnWidgetNewsInNumber();
        Assert.assertTrue(isStepTrue, "Diff card info not showing verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5851,5850(android_native):Verify that there is a Tag with Widget Title -”New” on the top of this widget")
    @Test
    public void verifyTitleNewTagOnWidgetNewsInNumber() {
        boolean isStepTrue = newsInNumberPage.checkNewTagAndTitleOnWidgetNewsInNumber();
        Assert.assertTrue(isStepTrue, "New tag not showing verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5854,5855(android_native):Verify share icon and its functionality")
    @Test
    public void verifyShareIconAndFunctionalityOnNewsInNumberListingPage() {
        boolean isStepTrue = newsInNumberPage.checkShareIconAndFunctionalityOnNewsInNumberListingPage();
        Assert.assertTrue(isStepTrue, "share icon not showing verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5849(android_native):Verify latest data on news in number widget")
    @Test
    public void verifyNewsInNumberWidgetData() {
        boolean isStepTrue = newsInNumberPage.checkLatestDataOnNewsInNumberWidget();
        Assert.assertTrue(isStepTrue, "latest data is not showing verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5859(android_native):Verify card visibility on news in number widget")
    @Test
    public void verifyNewsInNumberWidgetCardVisibility() {
        boolean isStepTrue = newsInNumberPage.checkCardVisibilityOnNewsInNumberWidget();
        Assert.assertTrue(isStepTrue, "card visibility verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5858,5857(android_native):Verify view all functionality")
    @Test
    public void verifyViewAllFunctionality() {
        boolean isStepTrue = newsInNumberPage.checkViewAllFunctionality();
        Assert.assertTrue(isStepTrue, "view all functionality verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5860(android_native):Verify card swipe functionality")
    @Test
    public void verifyCardSwipeFunctionality() {
        boolean isStepTrue = newsInNumberPage.checkCardSwipeFunctionality();
        Assert.assertTrue(isStepTrue, "card swipe functionality verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5868,5869(android_native):Verify read full story & functionality")
    @Test
    public void verifyReadFullStoryButtonAndFunctionality() {
        boolean isStepTrue = newsInNumberPage.checkReadFullStoryButtonAndFunctionality();
        Assert.assertTrue(isStepTrue, "read full story functionality verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5870(android_native):Verify Swipe Text at the bottom")
    @Test
    public void verifySwipeTextAtButton() {
        boolean isStepTrue = newsInNumberPage.checkSwipeTextAtButton();
        Assert.assertTrue(isStepTrue, "Swipe Text at the bottom verification failed*****");
    }

}
