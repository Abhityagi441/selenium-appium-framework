package LiveMint;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.LiveMint.genericPages.CommonLoginPage;
import com.pages.LiveMint.genericPages.CommonPhotosPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

class PhotosPageTest extends BaseTest {
    private static CommonPhotosPage photosPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {
        photosPage=CommonPhotosPage.getInstance();
        loginPage=CommonLoginPage.getInstance();
    }
    @Author(name = "NIshant Nayan")
    @Description("LM-19958(web),LM-19974(MwebAndroid),LM-19987(MwebiOS): verify Photos Page layout ")
    @Test
    public void verifyPhotosPageLayout() {
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPhotosPageLayout");
        boolean isTrue = photosPage.checkPhotoPagelayout(params.get("URL"));
        Assert.assertTrue(isTrue, "Photos Page layout verification failed !!!!!!!");
    }

    @Author(name = "NIshant Nayan")
    @Description("LM-19986(web),LM-19988(MwebAndroid),LM-17497(MwebiOS): verify Photos Page layout ")
    @Test
    public void verifyPhotosView() {
        Map<String,String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPhotosView");
        boolean isTrue = photosPage.checkPhotosView(params.get("URL"));
        Assert.assertTrue(isTrue, "Photos card view verification failed !!!!!!!");
    }
    }

