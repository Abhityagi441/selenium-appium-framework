package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonInlineStoriesPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class InlineStoriesTest extends BaseTest {
    private static CommonInlineStoriesPage inlineStoriesPage;
    GlobalVars globalVars= GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod(){
        inlineStoriesPage=CommonInlineStoriesPage.getInstance();
    }



    @Author(name = "Imran Sayyed")
    @Description("QAAUT-513(web),QAAUT-536(mWeb),QAAUT-622(amp),560(ios-mWeb),644(ios-amp):To verify stories are opening: Verify complete inline view including Embeds, end of story, URL, close button and url change on close")
    @Test
    public void verifyStoryDetailPage(){
        boolean isStepTrue;
        Map<String,String> params =globalVars.getParamsDataSinglePropertySingleProperty("verifyStoryDetailPage");
        isStepTrue=inlineStoriesPage.checkInlineStoriesCases(params.get("uri"),params.get("address"));
        Assert.assertTrue(isStepTrue,"In line Story test failed");
    }
    
    @Author(name = "Ravi")
    @Description("QAUTH - 603(iOSAMP),QAAUT - 891: To verify stories are opening: Verify complete inline view including Embeds, Most popular, end of story, URL, close button and url change on close")
    @Test
    public void verifyCompleteInlineViewEmbeds(){
        boolean isStepTrue;
        Map<String,String> params =globalVars.getParamsDataSinglePropertySingleProperty("verifyStoryDetailPage");
        isStepTrue=inlineStoriesPage.checkInlineStoriesCases(params.get("uri"),params.get("address"));
        Assert.assertTrue(isStepTrue," Stories Are Opening Complete Details Page Embeds You may also like failed ");
    }

    @Author(name="Priyanka")
    @Description("QAUTH-603 :To verify stories are opening: Verify complete inline view including Embeds, Most popular, end of story, URL, close button and url change on close")
    @Test
    public void verifyInlineStoriesOpening(){
        boolean isStepTrue;
        isStepTrue =inlineStoriesPage.checkInlineStoriesOpening();
        Assert.assertTrue(isStepTrue," Stories Are Opening Complete Details Page Embeds You may also like failed ");

    }

}
