package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonMoreFromSectionPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class MoreFromSectionTest extends BaseTest {
    private static CommonMoreFromSectionPage moreFromSectionPage;
    GlobalVars globalVars= GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod(){
        moreFromSectionPage=CommonMoreFromSectionPage.getInstance();
    }

    @Author(name = "Harshit")
    @Description("QAAUT-863:Verify More from this section in story detail page (Web only)")
    @Test
    public void verifyMoreFromThisSection(){
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMoreFromThisSection");
        boolean isStepTrue;
        isStepTrue=moreFromSectionPage.clickReadFullStory();
        Assert.assertTrue(isStepTrue,"Click read failed");
        isStepTrue=moreFromSectionPage.checkMoreFromSection(params.get("expectedMoreFromThisSection"));
        Assert.assertTrue(isStepTrue,"check More from this section failed");
        isStepTrue=moreFromSectionPage.checkClose();
        Assert.assertTrue(isStepTrue,"check close failed");

    }
}


