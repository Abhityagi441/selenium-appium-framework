package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1300(ios_native):Verify the Bottom Navigation")
    @Test
    public void verifyBottomNavigation() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBottomNavigation();
        Assert.assertTrue(isStepTrue, "Bottom Navigation verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1301(ios_native),QAAUT-1219(android_native):Verify the Bottom navigation-2")
    @Test
    public void verifyBottomNavigationAllPages() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBottomNavigationAllPages();
        Assert.assertTrue(isStepTrue, "Bottom Navigation verification failed");
    }

    @Author(name = "Shakeel Alam,Giridhar Raj")
    @Description("QAAUT-1302(ios_native),QAAUT-1220(android_native):Verify the focus")
    @Test
    public void verifyBottomNavigationFocus() {
        boolean isStepTrue;
        isStepTrue = homePage.checkBottomNavigationFocus();
        Assert.assertTrue(isStepTrue, "Bottom Navigation focus verification failed");
    }

}

