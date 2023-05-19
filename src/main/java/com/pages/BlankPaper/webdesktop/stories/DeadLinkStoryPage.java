package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonDeadLinkStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DeadLinkStoryPage extends CommonDeadLinkStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;

    public DeadLinkStoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//div//descendant::label[contains(text(),'Landing page headline')]")
    private static WebElement storyButton;

    @FindBy(xpath = "//div[@class='storytype']//li//child::button[contains(text(),'Deadlink')]")
    private static WebElement selectDeadlinkStory;

    @FindBy(xpath = "//div[@class='contentList']/div[1]//child::ul//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")  //ul[@class='storyuL']//child::li[contains(@class,'headline')]//descendant::quill-editor//descendant::div/p
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "//*[@data-placeholder='Enter the summary..' or @data-placeholder='Enter Summary']")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static WebElement inputAddSectionText;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(xpath = "//input[@placeholder='Add Deadlink URL here']")
    private static WebElement inputAddDeadlinkUrlText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and contains(text(),'Save')]")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//div[@class='storybtnContent']//button[@class='purple' and contains(text(),'File Story')]")
    private static WebElement buttonFileStoryForEdit;

    @FindBy(xpath = "//div[@class='storybtnContent']//button[@class='blue' and contains(text(),'Finished Editing')]")
    private static WebElement buttonFinishedEditing;

    @FindBy(xpath = "//div/span[@class='created' and contains(text(),'EDITED')]")
    private static WebElement statusEdited;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and text()='Publish']")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//span[@class='threedots']")
    private static WebElement buttonThreeDots;

    @FindBy(xpath = "//div[@class='dataField bdrfill']//descendant::ckeditor[contains(@class,'ng-touched')]")
    private static WebElement storyId;

    @FindBy(xpath = "//div//descendant::button[contains(text(),'Discard Story')]")
    private static WebElement buttonDiscardStory;

    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;

    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;

    @FindBy(xpath = "//div[@class='dataField']//descendant::i[@class='icon-image']")
    private static WebElement iconForImageUpload;

    @FindBy(xpath = "//div[@class='search-results']/ul//li[@class='image']//img")
    private static List<WebElement> listOfImagesInListTab;

    @FindBy(xpath = "//div[@class='imageAction block']//descendant::div[@class='pickimage']/span[@class='pickimageBtn']")
    private static WebElement imagePicFromLib;

    @FindBy(xpath = "//div[@class='internaldisplayView fl100']//descendant::li/i[@class='icon-list']")
    private static WebElement imageListViewIcon;

    @FindBy(xpath = "//div[@class='imagecontain']/span[@class='hover']//child::button[@class='blue']")
    private static WebElement buttonUseImage;

    @FindBy(xpath = "//div[@class='search-results']/ul[1]")
    private static WebElement listImageSearchResult;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> popupConfirmImageSize;

    @FindBy(xpath = "//button[contains(@class,'ml10') and contains(text(),'Done')]")
    private static WebElement buttonCropingDone;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Cropped successfully')]")
    private static WebElement toastCropingDone;

    @FindBy(xpath = "//div[@class='storyaction']//span[@class='cropimage']//child::i[@class='icon-crop']")
    private static WebElement buttonCropIcon;

    @FindBy(xpath = "//div[@class='unlockStory']//following::div[contains(@class,'ptb15')]")
    private static WebElement scrollToDivForCropping;

    @FindBy(xpath = "//div[@class='crop169']//div[contains(@class,'fr')]/input")
    private static WebElement imageCropRatio;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement addTitleForImage;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='editimage']//child::li[3]//child::div[@class='wid50 fl padr20']//descendant::input")
    private static WebElement addNameForImage;

    @FindBy(xpath = "//button[@class='save blue' and text()='Done']")
    private static WebElement captionSubmitButton;

    @FindBy(xpath = "//div[@class='fr wid100 right']")
    private static WebElement divAreaForScrollView;

    @FindBy(xpath = "//div[@class='leadMedia']//descendant::div[@class='storyaction']/span[contains(@class,'editBtn')]/i[@class='icon-pickup']")
    private static WebElement buttonImageEditIcon;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Purge Story')]")
    private static WebElement buttonPurgeStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Purge request accepted')]")
    private static WebElement toastPurgeStory;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Kill Story')]")
    private static WebElement buttonKillStory;

    @FindBy(xpath = "//textarea[@placeholder='Enter Redirect URL here…']")
    private static WebElement addUrlForKillStory;

    @FindBy(xpath = "//div[contains(@class,'fr wid')]//button[contains(@class,'add blue')]")
    private static WebElement submitUrlForKillStory;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Story Killed')]")
    private static WebElement toastKillStory;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Change URL')]")
    private static WebElement buttonChangeUrl;

    @FindBy(xpath = "//textarea[@placeholder='Enter URL body here…']")
    private static WebElement addUrlForHeadline;

    @FindBy(xpath = "//div[contains(@class,'fr wid100')]//button[contains(@class,'blue ml10')]")
    private static WebElement buttonSubmitUrlForHeadline;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'URL changed successfuly')]")
    private static WebElement toastChangeUrl;

    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::button[contains(text(),'Soft Publish')]")
    private static WebElement buttonSoftPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Soft Published successfully')]")
    private static WebElement toastSoftPublish;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//div[@class='form']//label[contains(text(),'Format')]/parent::li//span")
    private static WebElement formatLabelValue;

    @FindBy(xpath = "//span[contains(@class,'exact')]")
    private static WebElement exactAllStoriesButton;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(xpath = "//div[contains(@class,'secondary')]//span[@class='threedots']")
    private static WebElement ellipsis;

    @FindBy(xpath = "//div[@class='search-results']/ul[1]//li/img")
    private static WebElement firstImage;

    @FindBy(xpath = "//label[contains(text(),'Caption')]")
    private static WebElement captionLabelImage;

    @FindBy(xpath = "(//ckeditor//div/div[2]/div/p)[2]")
    private static WebElement imageCaption;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='domainselect']")
    private static WebElement hoverOnLeftPanel;

    @FindBy(xpath = "//section[@class='mainContainer']//ul[@class='menuContent']//descendant::span")
    private static List<WebElement> leftPanelMenuContent;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement labelUserNameAfterLogin;

    @FindBy(xpath = "//section[@class='mainContainer']//div[@class='userProfile']//div[@class='userName spImg']//span[@class='displayname']")
    private static WebElement userName;

    @FindBy(xpath = "//span[@id='summary1']")
    private static WebElement buttonDeleteSummary;
    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement dropDownRecordListInPagination;

    @FindBy(xpath = "(//div[contains(@class,'imageratio')])[1]")
    private static WebElement imageRatio;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//ul[@class='leadMediaIcon']/li/span/i")
    private static WebElement imgIcon;

    @FindBy(xpath = "//div[@class='imageAction block']/div/div//span[@class='pickimageBtn']")
    private static WebElement chouseIcon;

    @FindBy(xpath = "(//div[@class='imagecontain']/img)[1]")
    private static WebElement recentImage;

    @FindBy(xpath = "(//button[@class='blue' and contains(text(), 'Use')])[1]")
    private static WebElement useImage;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement yesButton;

    @FindBy(xpath = "//button[@name='saveStory']")
    private static WebElement saveImageButton;

    @FindBy(id = "buttonCropingDone")
    private static WebElement doneButton;

    @FindBy(xpath = "//div[@class='imageblock']/img")
    private static WebElement selectedImage;



    @Override
    public boolean  createDeadLinkAndVerify(String headline, String summary, String section, String subsection, String url) {
        boolean isStoryCreated;
        createDeadLink(headline, summary, section, subsection, url);
        searchStoryByID(storyIdNumber);
        isStoryCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        dashboardPage.clearSearch();
        return isStoryCreated;
    }

    private void createDeadLink(String headline, String summary, String section, String subsection, String url) {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectDeadlinkStory, 25, "deadlink story button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        //commonFunctions.sendKeys(enterHeadlineText, headline, 25, "headline box");
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        for(int i=0;i<=1;i++){
            commonFunctions.clickElementWithActions(enterHeadlineText);
            commonFunctions.clickElementWithActions(addSummaryText);
            commonFunctions.sendKey(enterHeadlineText,headline);
            commonFunctions.clickElementWithActions(addSummaryText);
        }
        commonFunctions.sendKey(addSummaryText,summary);
        dashboardPage.inputSection(section);
        commonFunctions.sendKeysIgnoringStaleElement(inputAddSubSectionText, subsection, 20, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.sendKeys(inputAddDeadlinkUrlText, url, 20, "url box");
        commonFunctions.clickElement(saveButton, 10, "save story button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        setStoryId();
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
    }

    private void searchStoryByIDAndSelect(String id){
        searchStoryByID(id);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 10, "Single record");
        commonFunctions.isElementDisplayedAndPresent(selectedStory, 15, "dashboard item");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 20, "deadlink list item");
    }

    private void searchStoryByID(String id) {
        commonFunctions.sendKeys(searchAllStoriesText, "id:" + id, 10, "search box");
        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
    }

    @Override
    public boolean publishForDeadLinkAndVerify(){
        boolean isPublished;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonPublish, 10, "publish story");
        commonFunctions.isElementPresentWithTryCatch(popupPublishButton, 30);
        isPublished = commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 5, "Publish toaster");
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isPublished = isPublished && commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isPublished;
    }

    @Override
    public boolean purgeDeadLinkAndVerify() {
        boolean isStoryPurged;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonPurgeStory, 15, "purge story button");
        isStoryPurged = commonFunctions.checkElementText(toastPurgeStory, "Purge request accepted", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        //TODO: to check with BP team whether purged story has a different status or not on the BP dashboard, if yes the verify that status
        commonFunctions.clickElement(appLogo, 20);
        return isStoryPurged;
    }

    @Override
    public boolean killDeadLinkAndVerify() {
        boolean isStoryKilled;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonKillStory, 15, "kill story button ");
        commonFunctions.clickElement(submitUrlForKillStory, 20, "submit url button");
        isStoryKilled = commonFunctions.getElementTextAndCheck(toastKillStory, "Story Killed", 30, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isStoryKilled = isStoryKilled && commonFunctions.checkElementText(storyStatus, "KILLED", 30, "Correct text is");
        return isStoryKilled;
    }

    @Override
    public boolean changeUrlDeadLinkAndVerify() {
        boolean isStoryUrlChanged;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(ellipsis, 10, "three dot button");
        commonFunctions.clickElement(buttonChangeUrl, 15, "change url button ");
        commonFunctions.sendKeys(addUrlForHeadline, "automationtesting", 20, "url box");
        commonFunctions.clickElement(buttonSubmitUrlForHeadline, 20, "submit change url button");
        isStoryUrlChanged = commonFunctions.checkElementText(toastChangeUrl, "URL changed successfuly", 30, "Correct text is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(appLogo, 20);
        return isStoryUrlChanged;
    }

    @Override
    public boolean softPublishDeadLinkAndVerify() {
        if(globalVars.isProdRun()){
//            Select dropDown = new Select(dropDownRecordListInPagination);
//            dropDown.selectByVisibleText("200");
            commonFunctions.selectOptionFromDropDown(dropDownRecordListInPagination, 20,"200", "dropDownRecordListInPagination");
            dashboardPage.openPublishedAndUnlockedStory("Deadlink");
        }else {
            searchStoryByIDAndSelect(storyIdNumber);
        }
        return dashboardPage.softPublishStory();
    }

    @Override
    public boolean verifyUploadImageForDeadlinkStory() {
        boolean isStorySavedStatus;
        boolean isConfirmImageSize;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(iconForImageUpload, 25, "image icon");
        commonFunctions.clickElement(imagePicFromLib, 25, "image library button");
        commonFunctions.clickElementWithActions(imageListViewIcon, 25, "image listview icon button");
        //commonFunctions.clickElementWithJS(firstImage, 40, "image records of result list item");
        commonFunctions.isElementDisplayedAndPresent(listOfImagesInListTab,20,"images loading");
        for(int i=0;i<=listOfImagesInListTab.size()-1;i++){
            if((listOfImagesInListTab.get(i).getAttribute("src").contains("amazonaws"))){
                commonFunctions.clickElementIfDisplayed(listOfImagesInListTab.get(i),20,"Click on Image having src tab");
                break;
            }
        }
        isConfirmImageSize = commonFunctions.isElementDisplayedAndPresent(popupConfirmImageSize, 15, "Correct Text is");
        if (isConfirmImageSize) {
            commonFunctions.clickElements(popupConfirmImageSize, 20, "popup confirm button");
        }
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 30);
        commonFunctions.checkElementText(imageRatio, "16:9 Ratio", 20, "image size");
        commonFunctions.clickElement(buttonCropingDone, 25, "crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        commonFunctions.clickElementWithJS(captionSubmitButton, 10, "caption submit button");
        isStorySavedStatus = dashboardPage.checkImageAfterUploadOnStoryPage();
        isStorySavedStatus &= commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStorySavedStatus;    }

    @Override
    public boolean verifyEditDeadlinkStoryContent() {
        return false;
    }

    @Override
    public boolean verifyImageCroppingForDeadlinkStory() {
        boolean isStorySavedStatus;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonCropIcon, 30, "crop icon button");
        commonFunctions.moveSlider(imageCropRatio, 15, "right side");
        commonFunctions.scrollPageWithJS(scrollToDivForCropping, 10);
        commonFunctions.clickElementWithJS(buttonCropingDone, 25, "submit crop button");
        commonFunctions.checkElementText(toastCropingDone, "Cropped successfully", 30, "Correct text is");
        isStorySavedStatus = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isStorySavedStatus;
    }

    @Override
    public boolean discardDeadlinkAndVerify() {
        boolean isDiscardStory;
        searchStoryByIDAndSelect(storyIdNumber);
        discardStory();
        searchStoryByID(storyIdNumber);
        isDiscardStory = commonFunctions.checkElementText(textNoData, "No Data", 30, "Correct text is");
        dashboardPage.clearSearch();
        return isDiscardStory;
    }

    private void discardStory() {
        commonFunctions.clickElement(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardStory, 15, "discard story button");
    }

    @Override
    public boolean mouseHoverOnLeftPanelAndVerifyElementsAndUser(String expectedUserName) {
        boolean isLeftPanelMouseHover = true;
        commonFunctions.clickElementWithActions(hoverOnLeftPanel, 10, "left panel area");
        for (WebElement traverseElement : leftPanelMenuContent) {
            String elementName = commonFunctions.getElementText(traverseElement, 10);
            if(commonFunctions.isElementEnabledWithCatch(traverseElement, 20, elementName)){
                Utils.logStepInfo(true, elementName + " is enabled");
            }else{
                isLeftPanelMouseHover = false;
                Utils.logStepInfo(false, elementName + " is disabled FAILURE");
            }
        }
        commonFunctions.clickElementWithActions(labelUserNameAfterLogin, 55, "user name label");
        isLeftPanelMouseHover = isLeftPanelMouseHover && commonFunctions.checkElementText(userName, expectedUserName, 15, "Correct text is");
        return isLeftPanelMouseHover;
    }

    private void saveDeadLinkStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        List<WebElement> elements = new ArrayList<>();
        elements.add(toastSaveButton);
        commonFunctions.isElementDisplayed(elements, 10, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
    }

    @Override
    public boolean deleteDeadLinkContent() {
        boolean isElementTextDeleted;
        searchStoryByIDAndSelect(storyIdNumber);
        commonFunctions.clickElement(buttonDeleteSummary, 15, "delete summary ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        saveDeadLinkStoryAndVerify();
        commonFunctions.refreshPage();
        isElementTextDeleted = commonFunctions.getElementTextAndCheck(addSummaryText, "", 20, "Summary text deletion");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 35, "text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 10);
        return isElementTextDeleted;
    }

    public void setStoryId(){
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
    }

    @Override
    public boolean validateDeadLinkURLAndFormat(String expectedURL) {
        boolean isDeadLinkURLAndFormatMatch=true;
        searchStoryByIDAndSelect(storyIdNumber);
        isDeadLinkURLAndFormatMatch &= commonFunctions.getElementText(formatLabelValue,20).equalsIgnoreCase("deadlink");
         String urlFromUI=commonFunctions.getAttributeValue(inputAddDeadlinkUrlText,30,"ng-reflect-model");
        isDeadLinkURLAndFormatMatch &= expectedURL.contains(urlFromUI);
        return isDeadLinkURLAndFormatMatch;
    }

    @Override
    public void clickOnBlankPaperLogo(){
        commonFunctions.clickElementIfDisplayed(appLogo, 10);
    }

    @Override
    public boolean checkSelectedImageShouldBeUploadedForDeadlink(String headline, String summary, String section, String subSection, String url){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        createDeadLinkStory(headline, summary, section, subSection, url);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        return commonFunctions.isElementPresentWithTryCatch(selectedImage, 20);
    }

    private void createDeadLinkStory(String headline, String summary, String section, String subsection, String url) {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectDeadlinkStory, 25, "deadlink story button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(2);
        for(int i=0;i<=5;i++) {
            commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
            commonFunctions.sendKeys(enterHeadlineText, headline, 10, "HeadLine");
            commonFunctions.isElementDisplayedAndPresent(addSummaryText, 20, "Summary field");
            commonFunctions.clickElement(addSummaryText, 10, "Summary");
            commonFunctions.dummyWait(5);
            if(commonFunctions.getElementText(enterHeadlineText, 5).equalsIgnoreCase(headline)){
                break;
            }
        }
        commonFunctions.isElementDisplayedAndPresent(addSummaryText, 20, "Summary field");
        commonFunctions.sendKeys(addSummaryText, summary, 10, "Summary");
        dashboardPage.inputSection(section);
        commonFunctions.sendKeysIgnoringStaleElement(inputAddSubSectionText, subsection, 20, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.sendKeys(inputAddDeadlinkUrlText, url, 20, "url box");
        commonFunctions.clickElement(saveButton, 10, "save story button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        setStoryId();
    }


}
