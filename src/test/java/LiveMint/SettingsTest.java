package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.generic.CommonSettingsPage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsTest  extends BaseTest {
    private static CommonSettingsPage settingsPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        settingsPage = CommonSettingsPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1321(ios_native),QAAUT-1239(android_native):Verfiy the push notification button should be clickable (enable/disable)")
    @Test
    public void verifyNotificationToggleIsWorking() {
        boolean isStepTrue;
        isStepTrue = settingsPage.checkNotificationToggle();
        Assert.assertTrue(isStepTrue, "Push notification button verification failed");
    }

    @Author(name = "Shakeel Alam,Giridhar Raj")
    @Description("QAAUT-1324(ios_native),QAAUT-1242(android_native):Verify font selection should be clickable (small/medium/large)")
    @Test
    public void verifyFontSelectionIsWorking() {
        boolean isStepTrue;
        isStepTrue = settingsPage.checkFontSelection();
        Assert.assertTrue(isStepTrue, "FontSelection button verification failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-3655,3662(android_native),QAAUT-3666,3673(ios_native):Verify font Size option")
    @Test
    public void verifyFontSizeOption() {
        boolean isStepTrue;
        isStepTrue = settingsPage.checkFontSizeOption();
        Assert.assertTrue(isStepTrue, "Font Size option verification failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT-4413,4414(android_native),QAAUT-4431,4432(ios_native): Verify explore setting icon and page")
    @Test
    public void verifyExploreSettingIconAndPage() {
        boolean isStepTrue;
        isStepTrue = settingsPage.checkExploreSettingIconAndPage();
        Assert.assertTrue(isStepTrue, "setting icon and page verification failed");
    }
}

