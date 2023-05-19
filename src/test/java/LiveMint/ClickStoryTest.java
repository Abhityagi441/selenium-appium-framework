package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonClickStoryPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickStoryTest extends BaseTest {
    private static CommonClickStoryPage clickStoryPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        clickStoryPage = CommonClickStoryPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1224(android_native): Verify story detail page by clicking on any story.")
    @Test
    public void verifyClickStoryPage() {
        boolean isStepTrue;
        isStepTrue = clickStoryPage.checkStoryPage();
        Assert.assertTrue(isStepTrue, "Click Story page failed.");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1229(android_native): Verify navigation by clicking on more from this section widget to the same section story.")
    @Test
    public void verifySectionPage() {
        boolean isStepTrue;
        isStepTrue = clickStoryPage.checkSectionPage();
        Assert.assertTrue(isStepTrue, "Section page load failed.");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1209(android_native):Verify listing story navigation")
    @Test
    public void verifyNavigationToListedStory() {
        boolean isStepTrue;
        isStepTrue = clickStoryPage.checkNavigationToPremiumListedStory();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1208(android_native):ViewWall navigation")
    @Test
    public void verifyNavigationToPremiumViewAll() {
        boolean isStepTrue;
        isStepTrue = clickStoryPage.checkNavigationToPremiumViewAll();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1204(android_native):Verify the Click Here option")
    @Test
    public void verifyRemoveAdOption() {
        boolean isStepTrue;
        isStepTrue = clickStoryPage.checkRemoveAdOption();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1213(android_native):Verify navigation by clicking on listed story on widget")
    @Test
    public void verifyNavigationToLoungeStory() {
        boolean isStepTrue;
        isStepTrue = clickStoryPage.checkNavigationToLoungeListedStory();
        Assert.assertTrue(isStepTrue, "Plan Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1210(android_native): Verify ViewWall Navigation(WSJ crousel)")
    @Test
    public void verifyNavigationToWsjViewAll() {
        boolean isStepTrue;
        isStepTrue = clickStoryPage.checkNavigationToWsjViewAll();
        Assert.assertTrue(isStepTrue, "Click Story page failed.");
    }

}



