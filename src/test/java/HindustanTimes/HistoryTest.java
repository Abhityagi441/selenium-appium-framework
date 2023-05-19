package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonHistoryPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class HistoryTest extends BaseTest {
    private static CommonHistoryPage historyPage;
    GlobalVars globalVars= GlobalVars.getInstance();;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        historyPage=CommonHistoryPage.getInstance();
        loginPage=CommonLoginPage.getInstance();
    }


    @Author(name = "Ravi")
    @Description("<QAAUT-505(Web),528(mweb),552(iOSmweb)>To verify myreads has history of all stories read ")
    @Test
    public void verifyMyReadsHasHistoryOfStories()throws Exception {
        boolean isStepTrue=false;
        try{
            Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMyReadsHasHistoryOfStories");
            isStepTrue= loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
            Assert.assertTrue(isStepTrue,"Login with password failed");
            isStepTrue = historyPage.checkMyReadsHasHistoryOfAllStoriesRead(params.get("uri"), params.get("address"));
            Assert.assertTrue(isStepTrue,"My Read History test failed");
        }
        finally {
            isStepTrue = loginPage.logout();
            Assert.assertTrue(isStepTrue, "Logout Failed!!");
        }
    }
}
