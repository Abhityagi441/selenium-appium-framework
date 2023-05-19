package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LevelTest extends BaseTest {
    private static CommonSectionPage sectionPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod(){
        sectionPage=CommonSectionPage.getInstance();
    }


    @Author(name="Shakeel Alam")
    @Description("QAAUT-1606(iOS-web):Verify L2 \"NEW\" tag")
    @Test
    public void verifyL2NewTag(){
        boolean isSectionIndiaNewsScrollable =sectionPage.checkL2NewTag();
        Assert.assertTrue(isSectionIndiaNewsScrollable,"L2 New Tag Displayed failed");
    }


}
