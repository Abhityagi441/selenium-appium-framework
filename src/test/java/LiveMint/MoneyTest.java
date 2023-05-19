package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonMoneyPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;


class MoneyTest extends BaseTest {
    private static CommonMoneyPage MoneyPage;
    private static CommonLoginPage loginPage;

    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        MoneyPage=CommonMoneyPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17909(web),LM-17910(MwebAndroid),LM-17912(MwebiOS),LM-17931(AMP Android),LM-17932(AMP iOS): verify Money Page layout ")
    @Test
    public void verifyMoneyPageLayout() {
        boolean isTrue = MoneyPage.checkMoneyPagelayout();
        Assert.assertTrue(isTrue, "Money layout verification failed !!!!!!!");
    }
    @Author(name = "NIshant Nayan")
    @Description("LM-17952(web),: verify LHS On Money Page")
    @Test
    public void verifychecklshMoneyPage() {
        boolean isTrue = MoneyPage.checklshMoneyPage();
        Assert.assertTrue(isTrue, "LHS On Money Page verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17956(Mweb-Android),LM-17957(Mweb-iOS),LM-17931(AMP-Android),LM-17932(AMP-iOS): verify TOP NAV On Money Page")
    @Test
    public void verifycheckTopNavLink()
    {
        boolean isTrue = MoneyPage.checkTopNavLink();

        Assert.assertTrue(isTrue, "TOP NAV Money Page verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17986 (Web): verify RHS NAV On Money Page")
    @Test
    public void verifycheckrhsMoneyPage()
    {
        boolean isTrue = MoneyPage.checkrhsMoneyPage();
        Assert.assertTrue(isTrue, "RHS NAV Money Page verification failed !!!!!!!");
    }
    @Author(name = "NIshant Nayan")
    @Description("LM-17987 (Web),LM-17996(MwebAndroid),LM-17997(Mweb iOS): verify Page layour for subscribed user  ")
    @Test
    public void verifychecMoneyPagelayoutSubscribedUSer() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifychecMoneyPagelayoutSubscribedUSer");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for RHS");
        isStepTrue = MoneyPage.checMoneyPagelayoutSubscribedUSer();
        Assert.assertTrue(isStepTrue, "Money Page layour for subscribed user verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Moneuy Page layour for subscribed user verification failde");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17988 (Web),: verify Money Page LHS for subscribed user  ")
    @Test
    public void verifychecklshMoneyPageforSubscribedUser() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifychecklshMoneyPageforSubscribedUser");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for RHS");
        isStepTrue = MoneyPage.checklshMoneyPageforSubscribedUser();
        Assert.assertTrue(isStepTrue, "Money Page LHS for subscribed user verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Moneuy Page LHS for subscribed user verification failde");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-17991 (Web),: verify RHS for subscribed user  ")
    @Test
    public void verifycheckrHSNAVLinksforSubscribeduserMoney() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckrHSNAVLinksforSubscribeduserMoney");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for RHS");
        isStepTrue = MoneyPage.checkrHSNAVLinksforSubscribeduserMoney();
        Assert.assertTrue(isStepTrue, "Money Page RHS for subscribed user verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Money Page RHS for subscribed user verification failde");
    }
    @Author(name = "NIshant Nayan")
    @Description("LM-17993 (Web),: verify First story")
    @Test
    public void verifycheckFirstStoryMoney() {

        boolean isStepTrue = MoneyPage.checkFirstStoryMoney();
        Assert.assertTrue(isStepTrue, "Money Page First story verification failed !!!!!!!");

    }
    @Author(name = "NIshant Nayan")
    @Description("LM-17995 (Web),: verify First story for subscribed user  ")
    @Test
    public void verifycheckcheckFirstStoryMoneyforsubscribeusder() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifycheckcheckFirstStoryMoneyforsubscribeusder");
        isStepTrue = loginPage.loginWithPassword(paramsMap.get("email"), paramsMap.get("password"), paramsMap.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login failed for Story");
        isStepTrue = MoneyPage.checkFirstStoryMoneyforsubscribeusder();
        Assert.assertTrue(isStepTrue, "Money Page First story  for subscribed user verification failed !!!!!!!");
        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Money Page First story  for subscribed user verification failde");
    }
}
