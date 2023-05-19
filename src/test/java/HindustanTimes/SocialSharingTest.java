package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonSocialSharingPage;
import com.pages.LiveHindustan.android_mweb.LoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SocialSharingTest extends BaseTest {
    private static CommonSocialSharingPage socialSharingPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        socialSharingPage = CommonSocialSharingPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-514(web), QAAUT-537(mweb), QAAUT-584(android native), QAAUT-623(amp),QAAUT - 561(IOSmweb), QAAUT-645(iOS AMP) : To verify social sharing functionality: Upfront (Copy URL, Twitter, FB, LinkedIn) and Inline (Twitter, FB)")
    @Test
    public void verifySocialSharingFunctionalityUpFrontInline() {
        boolean isStepTrue;
        isStepTrue = socialSharingPage.checkSocialSharingFunctionality();
        Assert.assertTrue(isStepTrue, "checking social sharing functionality has been Failed");
    }

    @Author(name = "Priyanka")
    @Description("QAAUT-604(web) : To verify social sharing functionality: story detail page(Twitter, FB) and sticky header sharing")
    @Test
    public void verifySocialSharingFunctionalityStickyHeader() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySocialSharingFunctionalityStickyHeader");
        boolean isStepTrue;
        isStepTrue = socialSharingPage.socialSharingInStoryPage(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "checking social sharing functionality has been Failed");
    }

    @Author(name = "Sambath Kumar,Imran")
    @Description("QAAUT-892(android native)-To verify social sharing functionality via WhatsApp, Gmail,898:iOS")
    @Test
    public void verifySocialSharingWithGmailAndWhatsapp() {
        boolean isStepTrue;
        isStepTrue = socialSharingPage.checkSocialSharingWithWhatsappAndGmail();
        Assert.assertTrue(isStepTrue, "Social sharing functionality with Gmail & Whatsapp has been Failed");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1447(IOSWeb),QAAUT-1446(Android_MWeb): To verify social sharing icon is clickable")
    @Test
    public void verifySocialSharingIconsClickable() {
        boolean isStepTrue;
        isStepTrue = socialSharingPage.checkSocialSharingIconsClickable();
        Assert.assertTrue(isStepTrue, "checking social sharing icon clickable has been Failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1630(Android-native),QAAUT-1618(iOS): Verify that whatsapp and Twitter option is displayed on the Story details page when user opens the Story details page from the Search")
    @Test
    public void verifyTwitterWhatsappDisplayInStoryPageBySearch() {
        boolean isStepTrue;
        isStepTrue = socialSharingPage.checkTwitterWhatsappDisplayInStoryPageBySearch();
        Assert.assertTrue(isStepTrue, "checking social sharing icon clickable has been Failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1637(Android-native): Verify that whatsapp and Twitter option is displayed on the Story details page when user opens the Story details page from the related topic pageion")
    @Test
    public void verifyTwitterWhatsappDisplayInStoryPageFromRelatedTopics() {
        boolean isStepTrue;
        isStepTrue = socialSharingPage.checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics();
        Assert.assertTrue(isStepTrue, "checking social sharing icon clickable has been Failed");
    }
}
