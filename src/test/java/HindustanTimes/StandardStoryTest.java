package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.pages.HindustanTimes.generic.CommonStandardStoryPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class StandardStoryTest extends BaseTest {
    private static CommonStandardStoryPage standardStoryPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        standardStoryPage = CommonStandardStoryPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Section page must be present in end of the story")
    @Test
    public void verifySectionPageOnDetailPage() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifySectionPageOnDetailPage");
        boolean isStepTrue = standardStoryPage.checkSectionPageOnDetailPage(param.get("indiaNewsUrl"));
        Assert.assertTrue(isStepTrue,"section page on detail page failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Taboola widget must be present in end of the story ")
    @Test
    public void verifyTaboolaWidgets() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyTaboolaWidgets");
        boolean isStepTrue = standardStoryPage.checkTaboolaWidgets(param.get("indiaNewsUrl"));
        Assert.assertTrue(isStepTrue,"taboola widgets failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify ad after first paragraph in story ")
    @Test
    public void verifyAdsAfterFirstParagraph() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyAdsAfterFirstParagraph");
        boolean isStepTrue = standardStoryPage.checkAdsAfterFirstParagraph(param.get("indiaNewsUrl"));
        Assert.assertTrue(isStepTrue,"ad after first paragraph failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify 'Follow Us' on google button and redirection ")
    @Test
    public void verifyFollowUsButtonRedirection() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyFollowUsButtonRedirection");
        boolean isStepTrue = standardStoryPage.checkFollowUsRedirection(param.get("indiaNewsUrl"),param.get("followUsUrl"));
        Assert.assertTrue(isStepTrue,"follow us redirection failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify Lead image of story(session id: d60d01fd5a6325711217ddcc872db38f5c53340c)")
    @Test
    public void verifyLeadImageOfStory() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyLeadImageOfStory");
        boolean isStepTrue = standardStoryPage.checkLeadImageOfStory(param.get("indiaNewsUrl"));
        Assert.assertTrue(isStepTrue,"Lead image of story failed");
    }

}