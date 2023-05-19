package HT_TECH;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HT_TECH.generic.CommonPhotoPage;
import com.pages.HT_TECH.generic.CommonVideoPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VideoTest extends BaseTest {
    private static CommonVideoPage videoPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        videoPage = CommonVideoPage.getInstance();
    }
    @Author(name = "Farheen")
    @Description("Sanity ||  HTTECH-T646 Web || Web || To verify video page is having 10 videos and status is 200")
    @Test
    public void verifyStoriesOnVideoPage() {
        boolean isStoryClickable = videoPage.checkVideoOnListingPage();
        Assert.assertTrue(isStoryClickable, "Url of Story of video page failed");
    }


    @Author(name = "Farheen")
    @Description("Sanity ||  HTTECH-3647 Web || To verify latest stories on the video page")
    @Test
    public void verifyLatestStoriesOnVideoPage() {
        boolean isStoryClickable = videoPage.checkLatestStoriesOnVideoPage();
        Assert.assertTrue(isStoryClickable, "Url of Latest Story of video page failed");
    }

    @Author(name = "Farheen")
    @Description("Sanity ||  HTTECH-T649 Web || To verify video detail page")
    @Test
    public void verifyVideoDetailPage() {
        boolean isStoryClickable = videoPage.checkVideoDetailPage();
        Assert.assertTrue(isStoryClickable, "verification of video detail page failed");
    }

    @Author(name = "Farheen")
    @Description("Sanity ||  HTTECH-T648 Web || To verify trending stories on video page")
    @Test
    public void verifyTrendingStoriesOnVideoDetailPage() {
        boolean isStoryClickable = videoPage.checkTrendingStoriesOnVideoPage();
        Assert.assertTrue(isStoryClickable, "Url of Trending Story of video page failed");
    }



}
