package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class NotificationTest  extends BaseTest {
    private static CommonHomePage homePage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
    }

    @Author(name = "Ravikumar Makam")
    @Description("QAAUT-777:Validate the notifications")
    @Test
    public void verifyNotification() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyNotification");

        isStepTrue = homePage.notification(params.get("apiURL"), params.get("faviconURL"));
        Assert.assertTrue(isStepTrue, "Notification verification failed");
    }
}

