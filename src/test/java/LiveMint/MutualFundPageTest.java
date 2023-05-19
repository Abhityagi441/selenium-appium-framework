package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonMutualFundPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class MutualFundPageTest extends BaseTest {
    private static CommonMutualFundPage mutualFundPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        mutualFundPage = CommonMutualFundPage.getInstance();

    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16791:Validate Mutual fund widget. Web, LM-16792:Validate Mutual fund widget. mWeb Android, LM-16793:Validate Mutual fund widget. mWeb iOS")
    @Test
    public void VerifyMutualFundWidget() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyMutualFundWidget");
        isStepTrue = mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget validation failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16796 : Validate Categories of mutual fund in swiper in mutual fund widget, LM-16797: Validate Categories of mutual fund in swiper in mutual fund widget. mweb Android, LM-16798:Validate Categories of mutual fund in swiper in mutual fund widget. mweb iOS")
    @Test
    public void verifyMutualFundWidgetCategories() {
        boolean isCategoriesStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyMutualFundWidgetCategories");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed *******");
        isCategoriesStepTrue = mutualFundPage.checkCategoriesInMFWidget(params.get("header"),params.get("categories"));
        Assert.assertTrue(isCategoriesStepTrue, "Mutual Fund Widget categories validation failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16801,LM-16802(Android mweb), LM-16803(ios mweb):Validate Mutual widget in category in selected state for Debt.")
    @Test
    public void verifyDebtMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Debt Selected state validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16890, LM-16891(Android mweb),LM-16892(iOS mweb) :Validate Mutual widget have Commodities in category in selected state.")
    @Test
    public void verifyCommoditiesMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCommoditiesMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16908, LM-16909(Android mweb),LM-16910(iOS mweb): Validate Mutual widget have Solution oriented funds in category in selected state.")
    @Test
    public void verifySolutionsOrientedMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySolutionsOrientedMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16893, LM-16894(Android mweb), LM-16895(ios mweb):Validate Mutual widget have Equity in category in selected state.")
    @Test
    public void verifyEquityMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEquityMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16899, LM-16900(Android mweb), LM-16901(iOS mweb):Validate Mutual widget have Hybrid in category in selected state.")
    @Test
    public void verifyHybridMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyHybridMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16896, LM-16897(android mweb), LM-16898(ios mweb):Validate Mutual widget have GFoF in category in selected state.")
    @Test
    public void verifyGlobalFundOfFundsMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyGlobalFundOfFundsMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16902, LM-16903(Android mweb), LM-16904(ios mweb):Validate Mutual widget have index funds in category in selected state.")
    @Test
    public void verifyIndexFundMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndexFundMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16905 , LM-16905(android mweb) LM-16905(ios mweb) :Validate Mutual widget have other funds in category in selected state.")
    @Test
    public void verifyOtherMutualFundInWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyOtherMutualFundInWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16806 LM-16807(Android mweb) LM-16808(ios mweb): Validate number of listing for Debt category in MF widget.")
    @Test
    public void verifyListingForDebtMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForDebtMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Selected state validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16959 LM-16960(Android mweb) LM-16961(ios mweb): Validate number of listing for Commodity category in MF widget.")
    @Test
    public void verifyListingForCommoditiesMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForCommoditiesMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Listing counting for Commodities failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16962 , LM-16963(Android mweb), LM-16964(ios mweb): Validate number of listing for Equity category in MF widget.")
    @Test
    public void verifyListingForEquityMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForEquityMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Listing counting for Equity failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16965, LM-16966(android mweb), LM-16067(ios mweb): Validate number of listing for GFoF category in MF widget.")
    @Test
    public void verifyListingForGlobalFundsOfFundMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForGlobalFundsOfFundMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Listing counting for Global funds of fund failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16968 LM-16969(Android mweb) LM-16970 (ios mweb):Validate number of listing for Hybrid category in MF widget.")
    @Test
    public void verifyListingForHybridMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForHybridMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Listing counting for Hybrid failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16971, LM-16972(Android mweb), LM-16973(ios mweb):Validate number of listing for index fund category in MF widget.")
    @Test
    public void verifyListingForIndexFundMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForIndexFundMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Listing counting for Index fund failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16974, LM-16975(Android mweb) , LM-16976(ios mweb):Validate number of listing for other category in MF widget.")
    @Test
    public void verifyListingForOtherMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForOtherMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Listing counting for Other failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16977 , LM-16978(Android mweb) LM-16979(iOS mweb):Validate number of listing for Solution Oriented category in MF widget.")
    @Test
    public void verifyListingForSolutionOrientedMFinWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingForSolutionOrientedMFinWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingCountinWidget(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Listing counting for Solution Oriented failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16810 LM-16811(Android mweb), LM-16812(ios mweb) :Validate Asset size for Debt mutual fund are being displayed")
    @Test
    public void verifyAssetFieldDebtsInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldDebtsInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Debts asset size  validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16914 LM-16915(Android mweb) LM-16916(iOS mweb) : Validate Asset size for Commodities mutual fund are being displayed")
    @Test
    public void verifyAssetFieldCommoditiesInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldCommoditiesInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Commodities asset size  validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16919, LM-16918(Android mweb) , LM-16917(ios mweb) :  Validate Asset size for Equity mutual fund are being displayed. ")
    @Test
    public void verifyAssetFieldEquityInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldEquityInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Equity asset size  validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description(" LM-16920, LM-16921(Android mweb), LM-16922(ios Mweb): Validate Asset size for GOGF mutual fund are being displayed. ")
    @Test
    public void verifyAssetFieldGlobalFundOfFundsInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldGlobalFundOfFundsInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Global Funds of Fund asset size  validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16925, LM-16924(Android mweb, LM-16923(ios mWeb): Validate Asset size for Hybrid mutual fund are being displayed. ")
    @Test
    public void verifyAssetFieldHybridInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldHybridInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Hybrid asset size  validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16926 , LM-16927(Android mweb) , LM-16928(ios Web): Validate Asset size for Index fund mutual fund are being displayed. ")
    @Test
    public void verifyAssetFieldIndexFundInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldIndexFundInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Index Fund asset size  validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16929 , LM-16930(Android mweb) , LM-16931(ios Web): Validate Asset size for other mutual fund are being displayed.")
    @Test
    public void verifyAssetFieldOtherInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldOtherInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Other asset size  validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16932 , LM-16934(Android mweb) , LM-16935(ios Web): Validate Asset size for Solution oriented mutual fund are being displayed.")
    @Test
    public void verifyAssetFieldSolutionOrientedInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAssetFieldSolutionOrientedInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkAssetsizeFieldInMFWidget(params.get("Category"),params.get("key"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Solution Oriented asset size  validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-16815 , LM-16816(Android mweb), LM-16817(ios Mweb):Validate the field headers for MF listing Rows for Debt MF")
    @Test
    public void verifyListingHeadsDebtsInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsDebtsInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Debts listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16937 , LM-16938(Android mweb), LM-16939(ios Mweb):Validate the field headers for MF listing Rows for Commodity MF")
    @Test
    public void verifyListingHeadsCommoditiesInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsCommoditiesInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Commodities listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16940 , LM-16941(Android mweb), LM-16942(ios Mweb):Validate the field headers for MF listing Rows for Equity MF")
    @Test
    public void verifyListingHeadsEquityInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsEquityInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Equity listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16943 , LM-16944(Android mweb), LM-16945(ios Mweb):Validate the field headers for MF listing Rows for GOGF MF")
    @Test
    public void verifyListingHeadsGlobalFundsofFundInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsGlobalFundsofFundInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Global Funds of Fund listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16946 , LM-16947(Android mweb), LM-16948(ios Mweb):Validate the field headers for MF listing Rows for Hybrid MF")
    @Test
    public void verifyListingHeadsHybridInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsHybridInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Hybrid listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16949 , LM-16950(Android mweb), LM-16951(ios Mweb):Validate the field headers for MF listing Rows for Index fund MF")
    @Test
    public void verifyListingHeadsIndexFundsInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsIndexFundsInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Index Funds listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16953 , LM-16954(Android mweb), LM-16955(ios Mweb):Validate the field headers for MF listing Rows for Other MF")
    @Test
    public void verifyListingHeadsOtherInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsOtherInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Other listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-16955 , LM-16956(Android mweb), LM-16957(ios Mweb):Validate the field headers for MF listing Rows for Solution Oriented MF")
    @Test
    public void verifyListingHeadsSolutionOrientedInMFWidget() {
        boolean isStepTrue;
        boolean isHeaderStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyListingHeadsSolutionOrientedInMFWidget");
        isHeaderStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isHeaderStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue = mutualFundPage.checkMFListingDataheaders(params.get("Category"),params.get("listingHead"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget Solution Oriented listing field headings validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-17484, 17485(Android mweb) :Validate listed Debt >Corporate Bond MF on selection matches with the API data")
    @Test
    public void verifyCrprtBondMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyCrprtBondMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17488 , LM-17601(Android mweb):Validate listed Debt >Floating rate MF on selection matches with the API data")
    @Test
    public void verifyFloatingRateMFListedMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyFloatingRateMFListedMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17489,17602(Android mweb) :Validate listed Debt >FMI-Term Bond MF on selection matches with the API data.")
    @Test
    public void verifyFMITermBondMFListedMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyFMITermBondMFListedMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17554 WEB, 17603(Android mweb) :Validate listed Debt >Dynamic bond MF on selection matches with the API data.")
    @Test
    public void verifyDebtDynamicBondMFListedMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtDynamicBondMFListedMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17555 WEB, 17604(android mweb) :Validate listed Debt >Ultra Short Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtUSDurationMFListedMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtUSDurationMFListedMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17556 WEB, LM-17605(Android mweb) :Validate listed Debt > Short Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtShortDurationMFListedMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtShortDurationMFListedMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-17630 WEB, LM-17631(Android mweb) :Validate listed Debt > 10 Yr Govt Bond MF on selection matches with the API data.")
    @Test
    public void verifyDebt10yrGovtBondMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebt10yrGovtBondMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17633 WEB, LM-17634(Android mweb) :Validate listed Debt > Govt bond MF on selection matches with the API data.")
    @Test
    public void verifyDebtGovtBondMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtGovtBondMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17635 WEB, LM-17636(Android mweb) :Validate listed Debt > Money Market MF on selection matches with the API data.")
    @Test
    public void verifyDebtMoneyMarketMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtMoneyMarketMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-17637 WEB, LM-17638(Android mweb) :Validate listed Debt > Long Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtLongDurationMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtLongDurationMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17639 WEB, LM-17640(Android mweb) :Validate listed Debt > Other Bond MF on selection matches with the API data.")
    @Test
    public void verifyDebtOtherDurationMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtOtherDurationMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17641 WEB, LM-17642(Android mweb) :Validate listed Debt > Low Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtLowDurationMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtLowDurationMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17866 WEB, LM-17867(Android mweb) :Validate listed Debt > Low Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtCreditRiskMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtCreditRiskMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17868 WEB, LM-17869(Android mweb) :Validate listed Debt > Low Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtBankingNpsuMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtBankingNpsuMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17870 WEB, LM-17871(Android mweb) :Validate listed Debt > Low Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtMedToLongDurationMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtMedToLongDurationMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17872WEB, LM-17873(Android mweb) :Validate listed Debt > Low Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtFixedMaturityshortTermMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtFixedMaturityshortTermMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }
    @Author(name = "Kapil Sisodia")
    @Description("LM-17874 WEB, LM-17875(Android mweb) :Validate listed Debt > Low Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtMedDurationMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtMedDurationMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Kapil Sisodia")
    @Description("LM-17870 WEB, LM-17871(Android mweb) :Validate listed Debt > Low Duration MF on selection matches with the API data.")
    @Test
    public void verifyDebtFxdMaturityUSBMFmatchwithAPIdata() {
        boolean isStepTrue;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyDebtFxdMaturityUSBMFmatchwithAPIdata");
        isStepTrue=mutualFundPage.checkWidgetHeader(params.get("header"),params.get("URL"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget header validation failed ********");
        isStepTrue=mutualFundPage.selectCategory(params.get("Category"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Widget category selection failed ********");
        isStepTrue = mutualFundPage.checkMFListedDisplayedForSelectedMF(params.get("Category"),params.get("subCategory"),params.get("mfAPIUrl"));
        Assert.assertTrue(isStepTrue, "Listed Mutual fund category validation  failed *******");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-5552 WEB, QAAUT-5551 (iOS-Mweb),QAAUT-5550(Android mweb),QAAUT-5549 (iOS-Amp),QAAUT-6054 (Android-Amp):Validate MF section in hamburger")
    @Test
    public void VerifyMutualFundsInHamburger() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyMutualFundsInHamburger");
        isStepTrue=mutualFundPage.checkMFSectionInHamburger(params.get("Offer"));
        Assert.assertTrue(isStepTrue, "Mutual Fund Section validation failed ********");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-5646 WEB, QAAUT-6053 (iOS-Mweb),QAAUT-5647(Android mweb),QAAUT-6052 (iOS-Amp),QAAUT-5649 (Android-Amp) :Validate News subsection in hamburger")
    @Test
    public void VerifyMFNewsInHamburger() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("VerifyMFNewsInHamburger");
        isStepTrue=mutualFundPage.checkMFNewsSubSectionInHamburger(params.get("Offer"));
        Assert.assertTrue(isStepTrue, "Mutual Fund News Section validation failed ********");
    }

}




