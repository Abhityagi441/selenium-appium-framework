package HT_TECH;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HT_TECH.generic.CommonNewsPage;
import com.pages.HT_TECH.generic.CommonPhotoPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhotoTest extends BaseTest {
    private static CommonPhotoPage photoPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        photoPage = CommonPhotoPage.getInstance();
    }

    @Author(name = "Farheen")
    @Description("Sanity ||  HTTECH-T643 Web || To verify pagination to page 2 is working on Photo Page")
    @Test
    public void verifyPaginationOnPhotoPage() {
        boolean ispaginationWorking = photoPage.checkPagination();
        Assert.assertTrue(ispaginationWorking, "Pagination of Photo page failed");
    }

    @Author(name = "Farheen")
    @Description("Sanity ||  HTTECH-T644 Web || To verify stories of Photo Page")
    @Test
    public void verifyStoriesOnPhotoPage() {
        boolean isStoryClickable = photoPage.checkPhotosStories();
        Assert.assertTrue(isStoryClickable, "Url of Story of Photo page failed");
    }

    @Author(name = "Farheen")
    @Description("Sanity || HTTECH-T645 Web || To verify URL change while scroll  of Photo Page")
    @Test
    public void verifyURLChangeOnScrollOnPhotoPage() {
        boolean isStoryClickable = photoPage.checkURLChange();
        Assert.assertTrue(isStoryClickable, "Url change while scroll of Photo page failed");
    }
}
