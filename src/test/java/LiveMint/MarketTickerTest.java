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

import java.util.Map;

public class MarketTickerTest  extends BaseTest {
    private static CommonHomePage homePage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        homePage = CommonHomePage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }
    @Author(name = "Ravikumar Makam, Manoj Patil")
    @Description("QAAUT-778(web), 789(MWeb-Android), 800(MWeb-IOS), 820(ios_native), 829(AMP-Android),839(AMP-IOS), 811(android_native) :Validate the market ticker navigation")
    @Test
    public void verifyMarketTicker() {
        boolean isStepTrue;
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketTicker");
        String[] paramArray= new String[17];
        paramArray[0]= params.get("marketStatsURL");
        paramArray[1]=params.get("bseSensex");
        paramArray[2]= params.get("nifty50");
        paramArray[3]= params.get("niftyBank");
        paramArray[4]=params.get("bsemidcap");
        paramArray[5]= params.get("gold");
        paramArray[6]= params.get("silver");
        paramArray[7]=params.get("bseSensexLandingPage");
        paramArray[8]=params.get("niftyLandingPage");
        paramArray[9]=params.get("niftybankLandingPage");
        paramArray[10]=params.get("bsemidcapLandingpage");
        paramArray[11]=params.get("goldLandingPage");
        paramArray[12]=params.get("silverLandingPage");
        paramArray[13]= params.get("bseMidcapLandingPage");
        paramArray[14]=params.get("nifty50App");
        paramArray[15]=params.get("niftyBankApp");
        paramArray[16]= params.get("marketStatsAMPURL");
        isStepTrue = homePage.marketTicker(paramArray);
        Assert.assertTrue(isStepTrue, "MarketTicker verification failed");
    }

}

