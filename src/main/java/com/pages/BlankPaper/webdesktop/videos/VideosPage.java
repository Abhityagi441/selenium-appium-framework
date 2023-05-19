package com.pages.BlankPaper.webdesktop.videos;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonVideosPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VideosPage extends CommonVideosPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//li[contains(@class,'videos')]")
    private static WebElement videosLink;

    @FindBy(xpath = "//div[contains(@class,'tabs')]//span[contains(text(),'Video Stories')]")
    private static WebElement videosStoriesTab;

    @FindBy(xpath="(//div[contains(@class,'tabs tabBlue')])/span[3]")
    private static WebElement youTubeStoriesTab;

    @FindBy(xpath = "//div[contains(@class,'headingsList')]")
    private static WebElement videosStoriesHeading;

    @FindBy(xpath = "//i[contains(@class,'icon-grid')]")
    private static WebElement videosStoriesGridIcon;

    @FindBy(xpath = "//div[contains(@class,'videoslistBlock')]//ul[contains(@class,'videolist')]")
    private static List<WebElement> videosStoriesGridRows;

    @FindBy(xpath = "//div[contains(@class,'contentList')]//div[contains(@class,'storyListing')]")
    private static List<WebElement> videosStoriesListRows;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[2]")
    private static List<WebElement> pageTwoInPagination;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement videosStoriesRecordsDropdown;

    @FindBy(xpath = "//i[contains(@class,'icon-list')]")
    private static WebElement videosStoriesListIcon;

    @FindBy(xpath = "//div[contains(@class,'videoslistBlock')]//li")
    private static List<WebElement> listOfVideosService;

    @FindBy(xpath = " //div[contains(@class,'videoslistBlock')]//li//span[@class='video_icon']")
    private static List<WebElement> listOfVideosServicePreviewIcon;

    @FindBy(xpath = "//div[contains(@class,'videoslistBlock')]//li//span[@class='edit']")
    private static List<WebElement> listOfVideosEditVideoIcon;


    @FindBy(xpath = "//span[@class='video_icon']")
    private static List<WebElement> listOfVideosPlayVideoIcon;

    @FindBy(xpath = "//div[contains(@class,'listgrid')]//li")
    private static List<WebElement> listOfVideosOnSelectVideoPopup;

    @FindBy(xpath = "//div[contains(@class,'listgrid')]//li//div[@class='imageInfo']")
    private static List<WebElement> listOfVideosInfoOnSelectVideoPopup;

    @FindBy(xpath = "//div[contains(@class,'listgrid')]//li//button[contains(text(),'Use')]")
    private static List<WebElement> listOfUseVideoButtonOnSelectVideoPopup;



    @FindBy(xpath = "(//div[contains(@class,'videoslistBlock')]//li//div[contains(@class,'imageInfo')]/div[1])")
    private static List<WebElement> listOfVideosServiceImageInfo;

    @FindBy(xpath = "//div[contains(@class,'videoslistBlock')]//li//div[contains(@class,'imageInfo')]/div[contains(@class,'heading')]")
    private static List<WebElement> listOfVideosStoriesImageInfo;

    @FindBy(xpath = "//div[contains(@class,'searchBlock')]//input[contains(@class,'search-com')]")
    private static WebElement searchInputBox;

    @FindBy(xpath = "//div[contains(@class,'footer')]/div[contains(@class,'recordList') and contains(text(),'results')]")
    private static WebElement showingResult;

    @FindBy(xpath = "//button[contains(@name,'Insert Video')]")
    private static WebElement insertVideoButton;

    @FindBy(xpath = "//button[contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[contains(@class,'videoComponent')]")
    private static WebElement videoComponentOnStoryPage;

    @FindBy(xpath = "//div[contains(@class,'videoComponent')]//i[contains(@class,'icon-delete')]")
    private static WebElement deleteButtonOnVideoComponentOnStoryPage;

    @FindBy(xpath = "//div[contains(@class,'videoStoryOption')]")
    private static WebElement deleteVideoComponentBlock;

    @FindBy(xpath = "//button[contains(text(),'Pick from Library')]")
    private static WebElement pickUpStoryButton;

    @FindBy(xpath = "//div[contains(@aria-label,'Video Player')]//div[contains(@class,'jw-title-primary')]")
    private static WebElement textOfVideoUsed;

    @FindBy(xpath = "//div[contains(@class,'respVideo')]//iframe")
    private static WebElement iframeOnVideoComponent;

    @FindBy(xpath = "//div[contains(@class,'detialimageViw')]")
    private static WebElement storyPreviewPopup;

    @FindBy(xpath = "//div[contains(@class,'detialimageViw')]//h3")
    private static WebElement storyPreviewPopupHeading;

    @FindBy(xpath = "//div[contains(@class,'detialimageViw')]//label")
    private static List<WebElement> storyPreviewPopupContents;

    @FindBy(id = "defaultOpen")
    private static WebElement videoServiceText;

    @FindBy(xpath = "(//div[contains(@class,'heading')])[1]")
    private static WebElement videoServiceFirstHeadlineText;

    @FindBy(css = "span[tabindex='0']")
    private static WebElement sourceFilter;

    private static String sourceDropdownValue = "//li//label[contains(text(),'%s')]";

    @FindBy(css = "input.search-components ")
    private static WebElement SearchBox;

    @FindBy(css = "div[class='recordList borderNone']")
    private static WebElement recordConformation;

    @FindBy(xpath = "//div[contains(@class,'contentList')]/div")
    private static WebElement textNoData;

    @FindBy(xpath = "(//input[contains(@class,'textBox')])[2]")
    private static WebElement filterSourceInputBox;

    @FindBy(xpath = "//div[contains(@class,'close fl')]")
    private static WebElement closePreview;

    @FindBy(xpath = "//*[@class='imagesPart']/iframe")
    private static WebElement previewVideo;




    public VideosPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
    }

    @Override
    public boolean isVideosServiceSearchable(){
        selectVideosLink();
        commonFunctions.isElementDisplayedAndPresent(listOfVideosService,30,"Image List");
        String videoDetail= getTextFromVidoes(1);
        commonFunctions.isElementDisplayedAndPresent(searchInputBox,20,"Wait for Search input box to be displayed");
        char imageText[]=videoDetail.toCharArray();
        for(int i=0;i<=imageText.length-1;i++){
            commonFunctions.sendKeyWithActions(searchInputBox,Character.toString(imageText[i]));
        }
        commonFunctions.clickElement(searchInputBox,20,"Click Search");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        commonFunctions.isElementDisplayedAndPresent(showingResult,20,"Wait for Showing results");
        commonFunctions.waitForElementIgnoringStaleElement(listOfVideosServiceImageInfo.get(0),30,"Image List");
        commonFunctions.isElementDisplayedAndPresent(listOfVideosServiceImageInfo.get(0),30,"wait for search results");
        boolean flag = listOfVideosServiceImageInfo.get(0).getAttribute("textContent").equalsIgnoreCase(videoDetail) || listOfVideosServiceImageInfo.get(1).getAttribute("textContent").equalsIgnoreCase(videoDetail) || listOfVideosServiceImageInfo.get(2).getAttribute("textContent").equalsIgnoreCase(videoDetail);
        return listOfVideosServiceImageInfo.size() > 0 && flag;
    }

    @Override
    public boolean isVideosStoriesSearchable(){
        selectVideosLink();
        commonFunctions.clickElementIfDisplayed(videosStoriesTab,20,"Video Stories tab");
        commonFunctions.isElementDisplayedAndPresent(listOfVideosService,30,"Image List");
        String videoDetail=listOfVideosStoriesImageInfo.get(1).getText();
        commonFunctions.isElementDisplayedAndPresent(searchInputBox,20,"Wait for Search input box to be displayed");
        char imageText[]=videoDetail.toCharArray();
        for(int i=0;i<=imageText.length-1;i++){
            commonFunctions.sendKey(searchInputBox,Character.toString(imageText[i]));
        }
        commonFunctions.clickElement(searchInputBox,20,"Click Search");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        commonFunctions.isElementDisplayedAndPresent(showingResult,20,"Wait for Showing results");
        commonFunctions.waitForElementIgnoringStaleElement(listOfVideosStoriesImageInfo.get(0),30,"Image List");
        commonFunctions.isElementDisplayedAndPresent(listOfVideosStoriesImageInfo.get(0),30,"wait for search results");
        return listOfVideosStoriesImageInfo.size() > 0 && listOfVideosStoriesImageInfo.get(0).getAttribute("textContent").equalsIgnoreCase(videoDetail);
    }



    public String getTextFromVidoes(int index){
        return listOfVideosServiceImageInfo.get(index).getAttribute("textContent");
    }

    private void selectVideosLink() {
        commonFunctions.isElementDisplayedAndPresent(videosLink,20,"wait for Videos link to be displayed");
        commonFunctions.clickElement(videosLink, 25, "Videos Link button");
    }

    @Override
    public boolean validateVideosStoriesGridView(){
        boolean isGridView;
        selectVideosLink();
        commonFunctions.isElementDisplayedAndPresent(videosStoriesTab,20,"Video Stories tab");
        commonFunctions.clickElement(videosStoriesTab,20,"Video Stories tab");
        commonFunctions.clickElement(videosStoriesGridIcon,20,"Grid Icon");
        commonFunctions.isElementDisplayedAndPresent(videosStoriesGridRows,20,"Wait for Grid Rows to be displayed");
        commonFunctions.isElementDisplayedAndPresent(videosStoriesRecordsDropdown,20,"wait for dropdown to be displayed");
        isGridView= videosStoriesGridRows.size()==13; //50 divides by 4 upper ceiling is 13 so it confirms in Grid view
        Select rowsDropdown = new Select(videosStoriesRecordsDropdown);
        rowsDropdown.selectByVisibleText("100"); //100 records
        commonFunctions.isElementDisplayedAndPresent(videosStoriesGridRows,20,"Wait for Grid Rows to be displayed");
        isGridView= videosStoriesGridRows.size()==25; //100 divides by 4 upper ceiling is 13 so it confirms in Grid view
        rowsDropdown.selectByVisibleText("50"); //back to 50 records
        commonFunctions.isElementDisplayedAndPresent(videosStoriesGridRows,20,"Wait for Grid Rows to be displayed");
        isGridView= videosStoriesGridRows.size()==13;
        commonFunctions.clickElements(pageTwoInPagination, 15, "second page");
        commonFunctions.isElementDisplayedAndPresent(videosStoriesGridRows,20,"Wait for Grid Rows to be displayed");
        isGridView= videosStoriesGridRows.size()==25;
        return isGridView;
    }

    @Override
    public boolean validateVideosStoriesListView(){
        boolean isListView;
        selectVideosLink();
        commonFunctions.isElementDisplayedAndPresent(videosStoriesTab,20,"Video Stories tab");
        commonFunctions.clickElement(videosStoriesTab,20,"Video Stories tab");
        commonFunctions.clickElement(videosStoriesListIcon,20,"List Icon");
        commonFunctions.isElementDisplayedAndPresent(videosStoriesHeading,20,"Wait for Video Stories Heading");
        commonFunctions.isElementDisplayedAndPresent(videosStoriesListRows, 20, "Story listing");
        if(pageTwoInPagination.size()>0){
        isListView= videosStoriesListRows.size()==50;
        commonFunctions.isElementDisplayedAndPresent(videosStoriesRecordsDropdown,30,"wait for dropdown to be displayed");
        Select rowsDropdown = new Select(videosStoriesRecordsDropdown);
        rowsDropdown.selectByVisibleText("100"); //Select 100 dropdown
        commonFunctions.isElementDisplayedAndPresent(videosStoriesListRows,20,"Wait for video stories loading after change in dropdown");
        isListView= videosStoriesListRows.size()==100;
        rowsDropdown.selectByVisibleText("50"); //back to 50 records
        commonFunctions.isElementDisplayedAndPresent(videosStoriesListRows,20,"Wait for video stories loading after change in dropdown");
        isListView= videosStoriesListRows.size()==50;
        commonFunctions.clickElements(pageTwoInPagination, 15, "second page");
        commonFunctions.isElementDisplayedAndPresent(videosStoriesListRows,20,"Wait for video stories loading after change in dropdown");
        isListView= videosStoriesListRows.size()==50;}
        else {
            commonFunctions.isElementDisplayedAndPresent(videosStoriesListRows, 20, "Story listing");
            isListView= videosStoriesListRows.size()>13; //If number of records are less than 50 and wants to verify lists view then maximum records in grid is 13 for single page
        }
        return isListView;
    }

    @Override
    public boolean validateVideosServicePreviewPopup() {
        selectVideosLink();
        commonFunctions.isElementDisplayedAndPresent(listOfVideosService, 30, "Video List Available");
        commonFunctions.clickElementIfDisplayed(listOfVideosServicePreviewIcon.get(0), 20, "Click on Preview 1st Video Service");
        commonFunctions.clickElementIfDisplayed(insertVideoButton, 20, "Click on Insert Video button on Preview Popup");
        boolean isPublishButtonDisplayed = commonFunctions.isElementDisplayedAndPresent(buttonPublish, 30, "Wait for Publish button to be displayed");
        boolean isNavigatedToStory = commonFunctions.getURLWithoutCatch().contains("/dash/story");
        return isPublishButtonDisplayed && isNavigatedToStory;
    }

    @Override
    public boolean validateVideosStoriesPreviewPopup() {
        selectVideosLink();
        commonFunctions.clickElementIfDisplayed(videosStoriesTab,20,"Stories Tab");
        commonFunctions.isElementDisplayedAndPresent(listOfVideosService, 30, "Video List Available");
        commonFunctions.clickElementIfDisplayed(listOfVideosEditVideoIcon.get(0), 20, "Click on Edit button 1st Video Story");
        commonFunctions.isElementDisplayedAndPresent(buttonPublish, 30, "Wait for Publish button to be displayed");
        commonFunctions.isElementDisplayedAndPresent(videoComponentOnStoryPage,20,"Wait for Video Component to be displayed on story page");
        commonFunctions.clickElementIfDisplayed(deleteButtonOnVideoComponentOnStoryPage, 20, "Click on delete icon on Video component on story page");
        commonFunctions.isElementDisplayedAndPresent(deleteVideoComponentBlock,20,"wait for delete video component block to be displayed");
        commonFunctions.clickElementIfDisplayed(pickUpStoryButton,20,"Click on pick up story button");
        commonFunctions.isElementDisplayedAndPresent(listOfVideosOnSelectVideoPopup,30,"wait for videos to be displayed");
        String imageInfo= commonFunctions.getElementText(listOfVideosInfoOnSelectVideoPopup.get(0)).toLowerCase();
        commonFunctions.moveToElementWithActions(listOfVideosOnSelectVideoPopup.get(0),20,"Mouse hover to First video");
        commonFunctions.clickElementIfDisplayed(listOfUseVideoButtonOnSelectVideoPopup.get(0),20,"Click on Use Video button on First image");
        commonFunctions.isElementDisplayedAndPresent(videoComponentOnStoryPage,20,"Wait for Video Component to be displayed on story page");
        commonFunctions.isElementDisplayedAndPresent(deleteButtonOnVideoComponentOnStoryPage, 20, "Click on delete icon on Video component on story page");
        commonFunctions.moveToElementWithActions(deleteButtonOnVideoComponentOnStoryPage,20,"Move to Delete button");
        commonFunctions.switchToFrame(iframeOnVideoComponent,20);
        String usedImageInfo=textOfVideoUsed.getAttribute("textContent").toLowerCase();
        commonFunctions.switchToParentFrame();
        return usedImageInfo.contains(imageInfo);
    }

    @Override
    public boolean validateOpenPreviewPageOnVideosStoriesTab() {
        boolean validateImagePreviewPopup=true;
        selectVideosLink();
        commonFunctions.clickElementIfDisplayed(videosStoriesTab,20,"Stories Tab");
        commonFunctions.isElementDisplayedAndPresent(listOfVideosService, 30, "Video List Available");
        commonFunctions.clickElementIfDisplayed(listOfVideosServicePreviewIcon.get(0), 20, "Click on Preview 1st Video Service");
        validateImagePreviewPopup &= commonFunctions.isElementDisplayedAndPresent(storyPreviewPopup,20,"Story Preview Popup Displayed");
        validateImagePreviewPopup &= storyPreviewPopupContents.get(0).getText().equalsIgnoreCase(Constants.VIDEO_PREVIEW_POPUP_CREATED);
        validateImagePreviewPopup &= storyPreviewPopupContents.get(1).getText().equalsIgnoreCase(Constants.VIDEO_PREVIEW_POPUP_CHANNEL);
        validateImagePreviewPopup &= storyPreviewPopupContents.get(2).getText().equalsIgnoreCase(Constants.VIDEO_PREVIEW_POPUP_TAGS);
        return validateImagePreviewPopup;
    }

    @Override
    public boolean sourceFilter(String dataHT, String dataLM) {
        boolean isDisplayed;
        selectVideosLink();
        commonFunctions.waitAndClickForElementIgnoringStaleElement(videoServiceText, 20, "Video Service Text");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(sourceFilter, 30, "Source Filter");
        commonFunctions.sendKeysOnElementVisibility(filterSourceInputBox, dataHT, 20, "input box");
        commonFunctions.clickElementIfDisplayed(String.format(sourceDropdownValue, dataHT), 20);
        commonFunctions.isElementDisplayed(sourceDropdownValue, 10, "source");
        String FirstHeadlineText = commonFunctions.waitAndGetElementTextIgnoringStaleElement(videoServiceFirstHeadlineText, 30, "headline 01 position");
        commonFunctions.clickElementIfDisplayed(String.format(sourceDropdownValue, dataHT), 20);
        commonFunctions.sendKeys(filterSourceInputBox, dataLM, 20, "input box");
        commonFunctions.clickElementIfDisplayed(String.format(sourceDropdownValue, dataLM), 20);
        commonFunctions.sendKeys(SearchBox, FirstHeadlineText, 20, "Search Box");
        isDisplayed = commonFunctions.checkElementText(recordConformation, "Showing 0 results", 20, "record conformation");
        isDisplayed = isDisplayed && commonFunctions.getElementTextAndCheck(textNoData, "No Data", 30, "Record Conformation: No Data :");
        return isDisplayed;
    }

    @Override
    public boolean validateOpenPreviewPageOnVideosServicesTab() {
        boolean validateImagePreviewPopup=true;
        selectVideosLink();
        commonFunctions.isElementDisplayedAndPresent(listOfVideosService, 30, "Video List Available");
        commonFunctions.clickElementIfDisplayed(listOfVideosServicePreviewIcon.get(0), 20, "Click on Preview 1st Video Service");
        validateImagePreviewPopup &= commonFunctions.isElementDisplayedAndPresent(storyPreviewPopup,20,"Story Preview Popup Displayed");
        validateImagePreviewPopup &= storyPreviewPopupContents.get(0).getText().equalsIgnoreCase(Constants.VIDEO_PREVIEW_POPUP_CREATED);
        validateImagePreviewPopup &= storyPreviewPopupContents.get(1).getText().equalsIgnoreCase(Constants.VIDEO_PREVIEW_POPUP_CHANNEL);
        validateImagePreviewPopup &= storyPreviewPopupContents.get(2).getText().equalsIgnoreCase(Constants.VIDEO_PREVIEW_POPUP_TAGS);
        validateImagePreviewPopup &= commonFunctions.isElementDisplayedAndPresent(insertVideoButton,20,"Verify Insert Video button displayed");
        return validateImagePreviewPopup;
    }

    @Override
    public boolean CheckIfUserIsAbleToSeeVideosTabPresentInSidebar() {
        return commonFunctions.isElementPresentWithTryCatch(videosLink,10);

    }
    @Override
    public boolean CheckIfUserIsAbleToClickOnVideosTabPresentInSidebar() {
        return commonFunctions.clickElementWithJS(videosLink,10,"videos tab");
    }

    public boolean openVideosTab(){
        return commonFunctions.clickElementWithJS(videosLink,10,"videos tab");
    }

    public boolean playVideoAndClose(WebElement PlayVideo){
        boolean isResult=true;
        if(commonFunctions.isClickableElementClicked(listOfVideosPlayVideoIcon.get(0),10,"play video icon")){
            isResult&=commonFunctions.isElementDisplayedAndPresent(storyPreviewPopup,10,"video preview pop up");
            commonFunctions.clickElement(closePreview);
        }
        return isResult;
    }
    public boolean openRequiredVideoTab(WebElement videoTab){
        boolean isResult=true;
        String tabName=videoTab.getText();
        isResult&=commonFunctions.isClickableElementClicked(videoTab,10,tabName);
        return isResult;
    }

    public boolean crossButtonInVideoPreview(){
        boolean isResult=true;
        if(commonFunctions.isClickableElementClicked(listOfVideosPlayVideoIcon.get(0),10,"play video icon")){
            isResult&=commonFunctions.isElementDisplayedAndPresent(closePreview,10,"cross or close button");
            commonFunctions.clickElement(closePreview);
        }
        return isResult;
    }

    @Override
    public boolean CheckIfUserIsAbleToSeeThreeTabsOnTheVideoPage() {
        boolean isResult=true;
        isResult&=openVideosTab();
        isResult&=commonFunctions.isElementDisplayedAndPresent(videoServiceText,10,"video services tab");
        isResult&=commonFunctions.isElementDisplayedAndPresent(videosStoriesTab,10,"video stories tab");
        isResult&=commonFunctions.isElementDisplayedAndPresent(youTubeStoriesTab,10,"video stories tab");
        return isResult;
    }

    @Override
    public boolean CheckIfAllTheThreeTabsAreClickable() {
        boolean isResult=true;
        isResult&=openVideosTab();
        isResult&=openRequiredVideoTab(videoServiceText);
        isResult&=openRequiredVideoTab(videosStoriesTab);
        isResult&=openRequiredVideoTab(youTubeStoriesTab);
        return isResult;
    }

    @Override
    public boolean CheckIfVideosShouldBePresentWhenUserClickOnAnyOfTheThreeTabs() {

        boolean isResult=true;
        isResult&=openVideosTab();
        isResult&=commonFunctions.isClickableElementClicked(videoServiceText,10,"video services tab");
        isResult&=commonFunctions.isElementDisplayedAndPresent(listOfVideosService,10,"video list");
        isResult&=commonFunctions.isClickableElementClicked(videosStoriesTab,10,"video stories tab");
        isResult&=commonFunctions.isElementDisplayedAndPresent(listOfVideosService,10,"video list");
        isResult&=commonFunctions.isClickableElementClicked(youTubeStoriesTab,10,"youtube tab");
        isResult&=commonFunctions.isElementDisplayedAndPresent(listOfVideosService,10,"video list");
        return isResult;
    }

    @Override
    public boolean CheckIfAllVideosPresentUnderTheTabShouldHavePlayIconPresentOnTheRightSide() {
        boolean isResult=true;
        openVideosTab();
        openRequiredVideoTab(videoServiceText);
        isResult&=listOfVideosPlayVideoIcon.size()==50;
        openRequiredVideoTab(videosStoriesTab);
        isResult&=listOfVideosPlayVideoIcon.size()==50;
        openRequiredVideoTab(youTubeStoriesTab);
        isResult&=listOfVideosPlayVideoIcon.size()==50;
        return isResult;
    }

    @Override
    public boolean CheckIfWhenUserClickOnPlayIconVideoPopupShouldOpen() {
        boolean isResult=true;
        openVideosTab();
        openRequiredVideoTab(videoServiceText);
        isResult&= playVideoAndClose(listOfVideosPlayVideoIcon.get(0));
        openRequiredVideoTab(videosStoriesTab);
        isResult&= playVideoAndClose(listOfVideosPlayVideoIcon.get(0));
        openRequiredVideoTab(youTubeStoriesTab);
        isResult&= playVideoAndClose(listOfVideosPlayVideoIcon.get(0));
        return isResult;
    }

    @Override
    public boolean CheckIfVideoPopupHasCrossButton() {
        boolean isResult=true;
        openVideosTab();
        openRequiredVideoTab(videoServiceText);
        isResult&=crossButtonInVideoPreview();
        openRequiredVideoTab(videosStoriesTab);
        isResult&=crossButtonInVideoPreview();
        openRequiredVideoTab(youTubeStoriesTab);
        isResult&=crossButtonInVideoPreview();
        return isResult;
    }

    @Override
    public boolean CheckIfCrossButtonPresentOnThePopupShouldBeWorking() {
        boolean isResult=true;
        openVideosTab();
        openRequiredVideoTab(videoServiceText);
        isResult&= playVideoAndClose(listOfVideosPlayVideoIcon.get(0));
        openRequiredVideoTab(videosStoriesTab);
        isResult&= playVideoAndClose(listOfVideosPlayVideoIcon.get(0));
        openRequiredVideoTab(youTubeStoriesTab);
        isResult&= playVideoAndClose(listOfVideosPlayVideoIcon.get(0));
        return isResult;
    }

    @Override
    public boolean CheckIfHeightOfPopupVideoOfVideoPageShouldBeAccordingToWindowHeight() {
        String position="",margin="";
        openVideosTab();
        openRequiredVideoTab(videoServiceText);
        commonFunctions.isClickableElementClicked(listOfVideosPlayVideoIcon.get(0),10,"play video icon");
        driver.switchTo().frame(previewVideo);
        position=driver.findElement(By.xpath("//video[@class='jw-video jw-reset']")).getCssValue("position");
        margin=driver.findElement(By.xpath("//video[@class='jw-video jw-reset']")).getCssValue("margin");
        return position.equalsIgnoreCase("absolute")&&margin.equalsIgnoreCase("0px");
    }
}
