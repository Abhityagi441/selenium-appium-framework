package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListenToArticleTest extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1121:Verify \"Listen to article\" feature on stories.")
    @Test
    public void verifyListenToArticle() {
        boolean isStepTrue;
        isStepTrue = homePage.listenToArticle();
        Assert.assertTrue(isStepTrue, "Listen to Article verification failed");
    }
}

