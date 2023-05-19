package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonHomePage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonPhotosPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class PhotosTest extends BaseTest {
    private static CommonPhotosPage photosTest;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        photosTest = CommonPhotosPage.getInstance();
        loginPage = CommonLoginPage.getInstance();

    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Web-Photos || All card and list stories must have count of images at lead image")
    @Test
    public void verifyCountInLeadImageInPhotosSection() {
        boolean isStepTrue = photosTest.CheckCountInLeadImageInPhotosSection();
        Assert.assertTrue(isStepTrue,"All topic should give 200 success code failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT- (Web): Web-Photo Gallery || 'Follow us' on google must be present below the summary")
    @Test
    public void verifyFollowUsInPhotoStory() {
        boolean isStepTrue = photosTest.CheckFollowUsInPhotoStory();
        Assert.assertTrue(isStepTrue,"'Follow us' on google present below the summary failed");
    }
}
