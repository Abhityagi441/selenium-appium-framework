package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonSkipPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SkipTest  extends BaseTest {
    private static CommonSkipPage skipPage;

    @BeforeMethod
    public void beforeMethod() {
        skipPage = CommonSkipPage.getInstance();
    }

    @Author(name = "Ravikumar Makam, Manoj Patil")
    @Description("QAAUT-781(Web), 792(MWeb-Android), 803(MWeb-IOS), 812(android_native):Validate the bookmark functionality when user is logged in")
    @Test
    public void verifySkipPage() {
        boolean isStepTrue;
        isStepTrue = skipPage.checkSkipPage();
        Assert.assertTrue(isStepTrue, "Bookmark Story for Logged In User verification failed");
    }
}

