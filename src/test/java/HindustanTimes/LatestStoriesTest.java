package HindustanTimes;

import com.base.DriverController;
import com.pages.HindustanTimes.generic.CommonLatestStoriesPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class LatestStoriesTest {
    private static CommonLatestStoriesPage latestStoriesPage;
    GlobalVars globalVars;

    @BeforeSuite
    public void initialization(){
        globalVars = DriverController.setup(Constants.HINDUSTAN_TIMES);
    }

    @BeforeMethod
    public void beforeMethod(){
        latestStoriesPage=CommonLatestStoriesPage.getInstance();
    }


    
}
