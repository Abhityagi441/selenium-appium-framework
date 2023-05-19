package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SectionPageTest extends BaseTest {
    private static CommonSectionPage sectionPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        sectionPage = CommonSectionPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1349(ios_native),QAAUT-1267(android_native):Verify the Auto news section page should not be blank")
    @Test
    public void verifyAutoNewsSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyAutoNewsSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("autoNewsText");
        isStepTrue = sectionPage.checkAutoNewsPage(paramArray);
        Assert.assertTrue(isStepTrue, "AutoNews SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1353(ios_native),QAAUT-1271(android-native) :Verify the Brand post section page should not be blank")
    @Test
    public void verifyBrandPostSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyBrandPostSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("brandPostText");
        isStepTrue = sectionPage.checkBrandPostPage(paramArray);
        Assert.assertTrue(isStepTrue, "BrandPostPage SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1354(ios_native),QAAUT-1272(android_native):Verify the Brand stories section page should not be blank")
    @Test
    public void verifyBrandStoriesSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyBrandStoriesSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("brandStoryText");
        isStepTrue = sectionPage.checkBrandStoriesPage(paramArray);
        Assert.assertTrue(isStepTrue, "Brand Stories SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1348(ios_native),QAAUT-1266(android_native):Verify the Budet 2021 section page should not be blank")
    @Test
    public void verifyBudgetSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyBudgetSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("budgetSectionText");
        isStepTrue = sectionPage.checkBudgetPage(paramArray);
        Assert.assertTrue(isStepTrue, "Budget SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1355(ios_native), QAAUT-1273(android_native):Verify navigation to podcast section page")
    @Test
    public void verifyPodcastSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyPodcastSectionPage");
        String[] paramArray=new String[3];
        paramArray[0]=paramsMap.get("podcastText");
        paramArray[1]=paramsMap.get("browserName");
        paramArray[2]=paramsMap.get("currentUrlContainText");
        isStepTrue = sectionPage.checkPodcastPage(paramArray);
        Assert.assertTrue(isStepTrue, "Podcast SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1346(ios_native):Verify navigation to mint lounge within webview")
    @Test
    public void verifyLoungeSectionPage() {
        boolean isStepTrue;
        isStepTrue = sectionPage.checkLoungePage();
        Assert.assertTrue(isStepTrue, "Lounge SectionPage verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1258(android_native), QAAUT-1340(ios_native):Verify the companies section page should not be blank")
    @Test
    public void verifyCompaniesSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyCompaniesSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("companiesText");
        isStepTrue = sectionPage.checkCompaniesSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Companies SectionPage verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1270(android_native), QAAUT-1352(ios_native):Verify the education section page should not be blank.")
    @Test
    public void verifyEducationSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyEducationSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("educationText");
        isStepTrue = sectionPage.checkEducationSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Education SectionPage verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1257(android_native), QAAUT-1339(ios_native): Verify the Industry section page should not be blank.")
    @Test
    public void verifyIndustrySectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyIndustrySectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("industryText");
        isStepTrue = sectionPage.checkIndustrySectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Industry SectionPage verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1256(android_native), QAAUT-1338(ios_native): Verify the market section page should not be blank.")
    @Test
    public void verifyMarketSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyMarketSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("marketText");
        isStepTrue = sectionPage.checkMarketSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Market SectionPage verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1259(android_native), QAAUT-1341(ios_native): Verify the Technology section page should not be blank.")
    @Test
    public void verifyTechnologySectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyTechnologySectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("technologyText");
        isStepTrue = sectionPage.checkTechnologySectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Technology SectionPage verification failed");
    }

    @Author(name = "Ravinder Singh, Gulshan Tomar")
    @Description("QAAUT-1336(ios_native), QAAUT-1254(android_native):To validate the Quick reads on app")
    @Test
    public void verifyQuickReadsSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyQuickReadsSectionPage");
        String[] paramArray=new String[1];
        //paramArray[0]=paramsMap.get("technologyText");
        isStepTrue = sectionPage.checkQuickReadsPage(paramArray);
        Assert.assertTrue(isStepTrue, "verifyQuickReadsSectionPage verification failed");
    }


    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1268(android_native), QAAUT-1350(ios_native): Verify the sports section page should not be blank.")
    @Test
    public void verifySportsSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySportsSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("sportsText");
        isStepTrue = sectionPage.checkSportsSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Sports SectionPage verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1269(android_native), QAAUT-1351(ios_native): Verify the politics section page should not be blank.")
    @Test
    public void verifyPoliticsSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyPoliticsSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("politicsText");
        isStepTrue = sectionPage.checkPoliticsSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Politics SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1342(ios_native): Verify the Money section page should not be blank")
    @Test
    public void verifyMoneySectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyMoneySectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("moneyText");
        isStepTrue = sectionPage.checkMoneySectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Money SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1345(ios_native),QAAUT-1263: Verify the Insurance section page should not be blank")
    @Test
    public void verifyInsuranceSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyInsuranceSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("insuranceText");
        isStepTrue = sectionPage.checkInsuranceSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Insurance SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1350(ios_native): Verify the sports section page should not be blank.")
    @Test
    public void verifyMFSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyMFSectionPage");
        String[] paramArray=new String[1];
        //paramArray[0]=paramsMap.get("politicsText");
        isStepTrue = sectionPage.checkMutualFundSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Mutual Funds SectionPage verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1265(android_native),QAAUT-1347(ios_native): Verify the opinion section page should not be blank.")
    @Test
    public void verifyOpinionSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyOpinionSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("opinionText");
        isStepTrue = sectionPage.checkOpinionSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Opinions Section Page verification failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1262(android_native): Verify the Mutual Funds section page should not be blank.")
    @Test
    public void verifyMutualFundsSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyMutualFundsSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("MutualFundText");
        isStepTrue = sectionPage.checkMutualFundSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Mutual Funds SectionPage verification failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1343(ios_native),QAAUT-1261(android_native): Verify the photos section page should not be blank.")
    @Test
    public void verifyPhotosSectionPage() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifyPhotosSectionPage");
        String[] paramArray=new String[1];
        paramArray[0]=paramsMap.get("photoText");
        isStepTrue = sectionPage.checkPhotosSectionPage(paramArray);
        Assert.assertTrue(isStepTrue, "Photos Section Page verification failed");
    }

    @Author(name = "Shakeel Alam,Giridhar Raj")
    @Description("QAAUT-1335(ios_native),QAAUT-1253(android_native): Verfiy to play/pause the videos listed on the video page")
    @Test
    public void verifyVideoPage() {
        boolean isStepTrue;
        isStepTrue = sectionPage.videoValidation();
        Assert.assertTrue(isStepTrue, "Video Section Page verification failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1252(android_native): Verify searching by the keywords and navigation is shown results.")
    @Test
    public void verifySearchingNavigation() {
        boolean isStepTrue;
        Map<String, String> paramsMap = globalVars.getParamsDataSinglePropertySingleProperty("verifySearchingNavigation");
        isStepTrue = sectionPage.checkSearchSectionPage(paramsMap.get("search"));
        Assert.assertTrue(isStepTrue, "Video Section Page verification failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1832(android_native):Verify the App Version is showing on the App")
    @Test
    public void verifyAppVersionIsDisplayed() {
        boolean isStepTrue;
        isStepTrue = sectionPage.checkAppVersionDisplayed();
        Assert.assertTrue(isStepTrue, "App Version is not displayed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-4925(Web),QAAUT-4926(Android-Web),QAAUT-4927(iOS-Web),QAAUT-4928(Amp-Android),QAAUT-4929(Amp-iOS), :Validate OPINION section page on Masthead Ad")
    @Test
    public void verifyMastHeadAdIsDisplayedOnOpinionPage() {
        boolean isStepTrue;
        isStepTrue = sectionPage.checkOpinionPageMastHead();
        Assert.assertTrue(isStepTrue, "MastHead Ad is not displayed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-5526(Web),QAAUT-5527(Android-Web),QAAUT-5528(iOS-Web),QAAUT-5529(Amp-Android),QAAUT-5530(Amp-iOS):Verify banking Sub-Section page")
    @Test
    public void verifySubSectionBanking() {
        boolean isStepTrue;
        isStepTrue = sectionPage.checkBankingSubSectionPage();
        Assert.assertTrue(isStepTrue, "Banking SubSection is not displayed");
    }



    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-5531(Web),QAAUT-5532(Android-Web),QAAUT-5533(iOS-Web),QAAUT-5534(Amp-Android),QAAUT-5535(Amp-iOS):Verify banking top nav")
    @Test
    public void verifyBankingTopNav() {
        boolean isStepTrue;
        isStepTrue = sectionPage.checkBankingPageTopNav();
        Assert.assertTrue(isStepTrue, "Banking top nav is not displayed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-5416(Web),QAAUT-5417(Android-Web),QAAUT-5418(iOS-Web),QAAUT-5419(Amp-Android),QAAUT-5420(Amp-iOS):Validate Share Icon on Industry Section page")
    @Test
    public void verifyIndustryPageStoryShareIcons() {
        boolean isStepTrue;
        isStepTrue = sectionPage.checkIndustryPageParagraphShare();
        Assert.assertTrue(isStepTrue, "Industry Page Story Share Icons are not displayed");
    }


    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-5421(Web),QAAUT-5422(Android-Web),QAAUT-5423(iOS-Web),QAAUT-5424(Amp-Android),QAAUT-5425(Amp-iOS):Validate first paragraph on Industry page")
    @Test
    public void verifyIndustryPagePara() {
        boolean isStepTrue;
        isStepTrue = sectionPage.checkIndustryPageParagraphShare();
        Assert.assertTrue(isStepTrue, "Industry Page Para is not displayed");
    }


}

