package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonPoliticsPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class PoliticsPageTest extends BaseTest {
    private static CommonPoliticsPage politicsPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        politicsPage = CommonPoliticsPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3907(Web), QAAUT-3910(iOS-Amp), QAAUT-3911(android-Amp), QAAUT-3909(iOS-web), QAAUT-3908(android-web):Validate Politics page Layout")
    @Test
    public void verifyPoliticsPageLayout() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPoliticsPageLayout");
        isStepTrue = politicsPage.checkPoliticsPageLayout(params.get("amp"));
        Assert.assertTrue(isStepTrue, "Politics page Layout verification failed");
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-3907(Web) :Validate LHS on politics page")
    @Test
    public void verifyLHSMenuPoliticsPage() {
        boolean isStepTrue;
        isStepTrue = politicsPage.checkLHSMenuOnPoliticsPage();
        Assert.assertTrue(isStepTrue, "LHS on politics page verification failed");
    }

  @Author(name = "Gulshan Tomar")
  @Description("QAAUT-3907(Web) :Validate RHS on Politics Page")
  @Test
  public void verifyRHSMenuPoliticsPage() {
    boolean isStepTrue;
    isStepTrue = politicsPage.checkRHSMenuOnPoliticsPage();
    Assert.assertTrue(isStepTrue, "RHS on politics page verification failed");
  }


  @Author(name = "Gulshan Tomar")
  @Description("QAAUT-4604(Web), QAAUT-3919(iOS-Amp), QAAUT-3918(android-Amp), QAAUT-4605(iOS-web), QAAUT-4606(android-web):Validate Share Icons on Politics page")
  @Test
  public void verifyShareIconsOnPoliticsPageStory() {
    boolean isStepTrue;
    Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyShareIconsOnPoliticsPageStory");
    isStepTrue = politicsPage.checkPoliticsPageLayout(params.get("Amp"));
    Assert.assertTrue(isStepTrue, "Politics page Layout verification failed");
  }



  @Author(name = "Gulshan Tomar")
  @Description("QAAUT-4678(Web), QAAUT-4682(iOS-Amp), QAAUT-4681(android-Amp), QAAUT-4680(iOS-web), QAAUT-4679(android-web):Validate first paragraph on politics page")
  @Test
  public void verifyParagraphOnPoliticsStoryPage() {
    boolean isStepTrue;
    isStepTrue = politicsPage.checkParagraphOnPoliticsStoryPage();
    Assert.assertTrue(isStepTrue, "Paragraph on Politics story page verification failed");
  }


  @Author(name = "Gulshan Tomar")
  @Description("QAAUT-4684(Web), QAAUT-4688(iOS-Amp), QAAUT-4687(android-Amp), QAAUT-4686(iOS-web), QAAUT-4685(android-web):Validate Summary on politics story page")
  @Test
  public void verifySummaryOnPoliticsStoryPage() {
    boolean isStepTrue;
    isStepTrue = politicsPage.checkSummaryOnPoliticsStoryPage();
    Assert.assertTrue(isStepTrue, "Summary on Politics story page verification failed");
  }




}

