package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonForYouPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonNewsPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

class NewsTest extends BaseTest {
    private static CommonNewsPage newsPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        newsPage = CommonNewsPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2783(ios_native),QAAUT-2767(android_native): verify news section")
    @Test
    public void verifyNewsSection() {
        boolean   isTrue = newsPage.checkNewsSection();
        Assert.assertTrue(isTrue, "News Section verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2784(ios_native),QAAUT-2768(android_native): verify news section position ")
    @Test
    public void verifyNewsSectionPosition() {
        boolean   isTrue = newsPage.checkNewsSectionPosition();
        Assert.assertTrue(isTrue, "News Section position verification failed !!!!!!!");
    }


    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2786(ios_native),QAAUT-2770(android_native): verify news section stories ")
    @Test
    public void verifyNewsSectionStoriesIsFree() {
        boolean   isTrue = newsPage.checkNewsSectionStoriesIsFree();
        Assert.assertTrue(isTrue, "News Section free story verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-1225(android_native),QAAUT-4737 (ios_native):Verify in story functionality for text to speech")
    @Test
    public void verifyStoryFunctionalityTextToSpeech() {
        boolean  isTrue = newsPage.checkStoryFunctionalityTextToSpeech();
        Assert.assertTrue(isTrue, "story functionality for text to speech verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5941(android_native):Verify that the end of the Notification story detail shows Recommended for You")
    @Test
    public void verifyRecommendedForYou() {
        boolean isStepTrue = newsPage.checkRecommendedForYouOnStoryDetailPage();
        Assert.assertTrue(isStepTrue, "Recommended For You verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5942(android_native):Verify story detail swipe popup")
    @Test
    public void verifyStoryDetailSwipePopup() {
        boolean isStepTrue = newsPage.checkStoryDetailSwipePopup();
        Assert.assertTrue(isStepTrue, "story detail swipe popup verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5928(android_native):Verify story detail all field")
    @Test
    public void verifyStoryDetailAllField() {
        boolean isStepTrue = newsPage.checkStoryDetailAllField();
        Assert.assertTrue(isStepTrue, "story detail all field verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5943,5944(android_native):Verify home Page next article")
    @Test
    public void verifyHomePageNextArticle() {
        boolean isStepTrue = newsPage.checkStoryDetailHomePage();
        Assert.assertTrue(isStepTrue, "home page next article verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5920(android_native):Verify story detail page")
    @Test
    public void verifyStoryDetailPage() {
        boolean isStepTrue = newsPage.checkStoryDetailPageAfterClickOnListingStory();
        Assert.assertTrue(isStepTrue, "story detail page verification failed*****");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-5921(android_native):Verify Horizontally swipe for next story")
    @Test
    public void verifyHorizontallySwipeForNextStory() {
        boolean isStepTrue = newsPage.checkHorizontallySwipeForNextStory();
        Assert.assertTrue(isStepTrue, "story detail page verification failed*****");
    }


}