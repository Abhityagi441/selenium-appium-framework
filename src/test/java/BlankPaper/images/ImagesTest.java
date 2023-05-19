package BlankPaper.images;

import com.annotation.Author;
import com.annotation.Description;
import com.base.DriverController;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonImagesPage;
import com.pages.BlankPaper.webdesktop.dashboard.DashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

public class ImagesTest {

    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
    private static CommonImagesPage commonImagesPage;

    GlobalVars globalVars;
    String property = "";

    @BeforeTest
    @Parameters("property")
    public void initialization(String property) {
        this.property = property;
        globalVars = DriverController.setup(Constants.BLANK_PAPER);
        dashboardPage = DashboardPage.getInstance();
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage.domainSelection(property);
        commonImagesPage = CommonImagesPage.getInstance();
    }

    @BeforeMethod
    @Description("In case of failure this method will navigate to Dashboard")
    public void ensureHomePageVisibility(){
        commonFunctions.refreshPage();
        dashboardPage.clickOnBlankPaperLogo();
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-224 Verify image download feature")
    @Test
    public void verifyImageDownloaded() throws IOException, InterruptedException {
        boolean isResult;
        isResult = commonImagesPage.clickDownloadOnFirstImageAndVerifyDownloadedImageInternalTab();
        Assert.assertTrue(isResult, "Image is not downloaded : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-229 Verify search functionality")
    @Test
    public void verifyImagesWiresSearch(){
        boolean isResult;
        isResult = commonImagesPage.isImagesWiresSearchable();
        Assert.assertTrue(isResult, "Images are not searchable : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-233 Verify Create a Story and Send notification buttons are present on top right")
    @Test
    public void verifyButtonsOnTopOnImagesWiresTab(){
        boolean isResult;
        if(this.property.equals("HT NEW") || this.property.equals("Live Mint") || this.property.equals("Auto") || this.property.equals("Tech")) {
            isResult = commonImagesPage.isNotificationAndCreateStoryButtonDisplayed();
            Assert.assertTrue(isResult, "Notification button and Create A story are not searchable : " + property);
        }
        else{
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-227 Verify Create a Story and Send notification buttons are present on top right")
    @Test
    public void verifyButtonsOnTopOnImagesInternalTab(){
        boolean isResult;
        if(this.property.equals("HT NEW") || this.property.equals("Live Mint") || this.property.equals("Auto") || this.property.equals("Tech")) {
            isResult = commonImagesPage.isNotificationAndCreateStoryButtonDisplayedOnInternalTab();
            Assert.assertTrue(isResult, "Notification button and Create A story are not searchable : " + property);
        }
        else{
            Utils.logStepInfo(true, "Test case is not valid for this Domain");
            Assert.assertTrue(true, "Test case is not valid for this Domain");
        }
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-231 Verify Image details")
    @Test
    public void verifyImagesDetailAndDownloadButton() {
        boolean isResult;
        isResult = commonImagesPage.isImagesDetailsAndDownloadButtonDisplayed();
        Assert.assertTrue(isResult, "Images detail and download button are not displayed : " + property);
    }


    @Author(name = "Ravinder Singh")
    @Description("QAAUT-232 Verify image preview window with details and download button is visible")
    @Test
    public void verifyImagesPreviewWindowDetailAndDownloadButton() {
        boolean isResult;
        isResult = commonImagesPage.isImagesPreviewWindowDetailsAndDownloadButtonDisplayed();
        Assert.assertTrue(isResult, "Preview window and Download button not displayed : " + property);
            }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-226 Verify image preview window with details and download button is visible")
    @Test
    public void verifyImagesPreviewWindowDetailDownloadButtonOnInternalTab() {
        boolean isResult;
        isResult = commonImagesPage.isImagesPreviewWindowDetailsAndDownloadButtonDisplayedOnInternalTab();
        Assert.assertTrue(isResult, "Preview window and Download button not displayed : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-225 Verify Image details")
    @Test
    public void verifyImagesDetailAndDownloadButtonOnInternalTab() {
        boolean isResult;
        isResult = commonImagesPage.isImagesDetailsAndDownloadButtonDisplayedOnInternalTab();
        Assert.assertTrue(isResult, "Images detail and download button are not displayed : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT:230 Verify image download feature")
    @Test
    public void verifyImageDownloadedOnInternalTab(){
        boolean isResult;
        isResult = commonImagesPage.clickDownloadOnFirstImageAndVerifyDownloadedImageOnWiresTab();
        Assert.assertTrue(isResult, "Image is not downloaded : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-217 Verify search functionality")
    @Test
    public void verifyImagesInternalSearch(){
        boolean isResult;
        isResult = commonImagesPage.isImagesInternalSearchable();
        Assert.assertTrue(isResult, "Images are not searchable : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-222 Verify list view")
    @Test
    public void verifyListViewOnInternalSearch(){
        boolean isResult;
        isResult = commonImagesPage.validateListViewOnInternalImages();
        Assert.assertTrue(isResult, "Images Internal is not list view on : " + property);
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-759 Verify grid view")
    @Test
    public void verifyGridViewOnInternalSearch(){
        boolean isResult;
        isResult = commonImagesPage.validateGridViewOnInternalImages();
        Assert.assertTrue(isResult, "Images Internal is not list view on : " + property);
    }

    @Author(name = "Raj")
    @Description("QAAUT-3128:Image name should be editable")
    @Test
    public void verifyEditImageNameIsPresentInTheCropperWindow(){
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = commonImagesPage.checkEditImageNameIsPresentInTheCropperWindow();
        Assert.assertTrue(isResult, "Edit Image Name is not present in the cropper window : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3129:Image name should be editable")
    @Test
    public void verifyImageNameShouldBeEditable(){
        if (this.property.equals("HT NEW")) {
        boolean isResult;
        isResult = commonImagesPage.checkImageNameShouldBeEditable();
        Assert.assertTrue(isResult, "Image name is not editable : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3119:Add Watermark on images with topic")
    @Test
    public void verifyWatermarkOnImagesWithTopic(){
        if (this.property.equals("Live Mint")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyWatermarkOnImagesWithTopic", property);
        isResult = commonImagesPage.checkWatermarkOnImagesWithTopic(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"), paramsMap.get("topicName"));
        Assert.assertTrue(isResult, "Watermark on images with topic functionality not working : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @Author(name = "Raj")
    @Description("QAAUT-3120:Add Watermark on images with subsection")
    @Test
    public void verifyWatermarkOnImagesWithSubSection(){
        if (this.property.equals("Live Mint")) {
        boolean isResult;
        Map<String, String> paramsMap = globalVars.getParamsData("verifyWatermarkOnImagesWithSubSection", property);
        isResult = commonImagesPage.checkWatermarkOnImagesWithSubSection(paramsMap.get("headline"), paramsMap.get("summary"), paramsMap.get("paragraph"), paramsMap.get("byline"), paramsMap.get("section"), paramsMap.get("subsection"), paramsMap.get("keyword"), paramsMap.get("location"));
        Assert.assertTrue(isResult, "Watermark on images with Sub Section functionality not working : " + property);
        }else {
            Utils.logStepInfo("Test case is not valid for this Domain!!!");
        }
    }

    @AfterMethod
    public void closeOtherOpenTabs() {
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }


}
