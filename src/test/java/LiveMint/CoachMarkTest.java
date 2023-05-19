package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.base.DriverController;
import com.pages.LiveMint.genericPages.CommonCoachMarkPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


class CoachMarkTest extends BaseTest {
    private static CommonCoachMarkPage coachMarkPage;
    private static DriverController driverController = null;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        coachMarkPage = CommonCoachMarkPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT2794-(ios_native): verify coach mark on first launch")
    @Test
    public void verifyCoachMarkOnFirstLaunch() {
        boolean isTrue = coachMarkPage.checkCoachMarkOnFirstLaunch();
        Assert.assertTrue(isTrue, "coach mark on first launch verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT2795-(ios_native): verify coach mark skip button")
    @Test
    public void verifyCoachMarkSkipButton() {
        boolean isTrue = coachMarkPage.checkCoachMarkSkipButton();
        Assert.assertTrue(isTrue, "coach mark skip button verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT2796-(ios_native): verify coach mark next button")
    @Test
    public void verifyCoachMarkNextButton() {
        boolean isTrue = coachMarkPage.checkCoachMarkNextButton();
        Assert.assertTrue(isTrue, "coach mark next button verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2797(ios_native): verify coach mark done button")
    @Test
    public void verifyCoachMarkDoneButton() {
        boolean isTrue = coachMarkPage.checkCoachMarkDoneButton();
        Assert.assertTrue(isTrue, "coach mark done button verification failed !!!!!!!");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-2793(ios_native): verify news and explore coach mark ")
    @Test
    public void verifyCoachMark() {
        boolean isTrue = coachMarkPage.checkNewsAndExploreCoachMark();
        Assert.assertTrue(isTrue, "news and explore coach mark verification failed !!!!!!!");
    }

    @AfterMethod
    public void afterMethod() {
        if (globalVars.isIosRun()) {
            driverController = DriverController.getInstance();
            driverController.closeDriver();
            driverController.initializeDriver();
            coachMarkPage.checkAllNotification();
        }
    }

}