package com.pages.BlankPaper.webdesktop.images;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonImagesPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;


public class ImagesPage extends CommonImagesPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    private static CommonDashboardPage dashboardPage;


    @FindBy(xpath = "(//ul[contains(@class,'imagelist')]//div//img)[1]")
    private static WebElement firstImageonImagesPage;

    @FindBy(xpath = "(//button[contains(text(),'Download')])[1]")
    private static WebElement downloadButtonOnFirstImage;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'imagespopup')]//li//button")
    private static List<WebElement> listOfDownloadButtonOnFirstImageOnWires;

    @FindBy(xpath = "(//div[contains(@id,'myWorkspace')]//div[contains(@class,'imagespopup')]//li//p[1])")
    private static List<WebElement> listOfImages;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//li[contains(@class,'images')]")
    private static WebElement imagesLink;

    @FindBy(xpath = "//div[contains(@class,'tabs')]//span[contains(.,'Wires')]")
    private static WebElement wiresTab;

    @FindBy(xpath = "//div[contains(@class,'notificationBtn')]//span[contains(text(),'Send Notification')]")
    private static WebElement sendNotificationButton;

    @FindBy(xpath = "//div[@class='rightBlock']//button[contains(@class,'createStory')]")
    private static WebElement createAStoryButton;

    @FindBy(xpath = "//div[contains(@class,'image')]//input[contains(@class,'search-com')]")
    private static WebElement searchInputBox;

    @FindBy(xpath = "(//div[contains(@id,'allStories')]//div[contains(@class,'searchtxt')]//input[contains(@class,'search-com')])[1]")
    private static WebElement searchInputBoxInternalTab;

    @FindBy(xpath = "//div[@id='allStories']//i[contains(@class,'icon-search')]")
    private static WebElement searchIcon;

    @FindBy(xpath = "//div[contains(@class,'searchfilter')]")
    private static WebElement searchFilter;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'imagespopup')]//li")
    private static List<WebElement> imagesListOnWiresTab;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'imagespopup')]//li/div")
    private static List<WebElement> imagesListOnInternalTab;

    @FindBy(xpath = "//div[contains(@class,'search-results')]//ul")
    private static List<WebElement> imagesListOnInternalTabListView;

    @FindBy(xpath = "//ul[contains(@class,'imagelist')]")
    private static WebElement imagesListOnInternalTabBlock;

    @FindBy(xpath = "//div[contains(@class,'search-results')]")
    private static WebElement imagesListOnInternalTabBlockListView;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'imagespopup')]//li//label[contains(text(),'Caption')]")
    private static List<WebElement> listOfImagesCaption;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'imagespopup')]//li//label[contains(text(),'Caption')]")
    private static List<WebElement> internalTabListOfImagesCaption;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'imagespopup')]//li//label[contains(text(),'Created On')]")
    private static List<WebElement> listOfImagesCreatedOn;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'imagespopup')]//li//label[contains(text(),'Created On')]")
    private static List<WebElement> internalTabListOfImagesCreatedOn;

    @FindBy(xpath = "(//div[contains(@id,'allStories')]//div[contains(@class,'imagespopup')]//li//p[1])")
    private static List<WebElement> internalTabListOfImagesInfoText;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'imagespopup')]//li//button[text()='Download']")
    private static List<WebElement> listOfImagesDownloadButton;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'imagespopup')]//li//button[text()='Download']")
    private static List<WebElement> internalTabListOfImagesDownloadButton;

    @FindBy(xpath = "//div[contains(@class,'tabs')]//span[contains(.,'Internal')]")
    private static WebElement internalTab;

    @FindBy(xpath = "//ul[contains(@class,'tabdisplay')]//i[@class='icon-list']")
    private static WebElement listViewIcon;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//span[@class='viewEye']//i")
    private static List<WebElement> previewImageList;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//span[@class='viewEye']//i")
    private static List<WebElement> internalTabPreviewImageList;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'imagespopup')]//li")
    private static List<WebElement> internalTabImagesList;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'detialimageViw')]")
    private static List<WebElement> previewImagePopupList;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'detialimageViw')]")
    private static List<WebElement> internalTabPreviewImagePopupList;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'detialimageViw')]//label[contains(text(),'caption')]")
    private static List<WebElement> previewImagePopupCaptionList;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'detialimageViw')]//label[contains(text(),'caption')]")
    private static List<WebElement> internalTabPreviewImagePopupCaptionList;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'detialimageViw')]//label[contains(text(),'Created On')]")
    private static List<WebElement> previewImagePopupCreatedOnList;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'detialimageViw')]//label[contains(text(),'Created On')]")
    private static List<WebElement> internalTabPreviewImagePopupCreatedOnList;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'detialimageViw')]//button[contains(text(),'Download')]")
    private static List<WebElement> previewImagePopupDownloadButtonList;

    @FindBy(xpath = "//div[contains(@id,'allStories')]//div[contains(@class,'detialimageViw')]//button[contains(text(),'Download')]")
    private static List<WebElement> internalTabPreviewImagePopupDownloadButtonList;

    @FindBy(xpath = "//div[contains(@class,'lightBox')]//div[contains(@class,'close')]")
    private static List<WebElement> previewImagePopupCloseButtonList;

    @FindBy(xpath = "//div[contains(@id,'myWorkspace')]//div[contains(@class,'imagespopup')]//li")
    private static List<WebElement> imagesList;

    @FindBy(xpath = "(//div[contains(@id,myWorkspace)]//ul[contains(@class,'imagelist')]/div//img)[1]")
    private static WebElement firstImageonImagesPageOnWiresTab;

    @FindBy(xpath = "(//div[@id='myWorkspace']//ul[contains(@class,'imagelist')]//li//button[contains(text(),'Download')])[1]")
    private static WebElement downloadButtonOnFirstImageOnWiresTab;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='storytype']//li//button[@class='standard' and text()='Standard']")
    private static WebElement selectStory;

    @FindBy(xpath = "//ul[@class='leadMediaIcon']/li/span/i")
    private static WebElement imgIcon;

    @FindBy(xpath = "//div[@class='imageAction block']/div/div//span[@class='pickimageBtn']")
    private static WebElement chouseIcon;

    @FindBy(xpath = "(//div[@class='imagecontain']//img)[1]")
    private static WebElement recentImage;

    @FindBy(xpath = "(//button[@class='blue' and contains(text(), 'Use')])[1]")
    private static WebElement useImage;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement yesButton;

    @FindBy(id = "editImageName")
    private static WebElement editImageNameText;

    @FindBy(id = "buttonCropingDone" )
    private static WebElement doneButton;

    @FindBy(xpath = "//div[@class='imageblock']/img" )
    private static WebElement imageAfterDone;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[2]/div")
    private static WebElement addSummaryText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/p")
    private static WebElement addParagraphText;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//ul[@id='myTags']//li[@class='tagit-new']//input[contains(@placeholder,'Byline')]")
    private static WebElement inputAddByLineText;

    @FindBy(xpath = "//input[@placeholder='Add Location here..']")
    private static WebElement inputAddLocationText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and text()='Save']")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//button[@name='saveStory']")
    private static WebElement saveImageButton;

    @FindBy(id = "buttonPublish")
    private static WebElement publishButton;

    @FindBy(id = "inputAddTopicText")
    private static WebElement topicText;

    @FindBy(xpath = "//div[@class='imageblock']/img")
    private static WebElement waterMarkWithTopic;

    @FindBy(xpath = "//div[@class='imageblock']/img")
    private static WebElement waterMarkWithSubSection;


    public ImagesPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        FileFilter filter = file -> (file.getName().endsWith(".jpg") || (file.getName().endsWith(".jpeg") || (file.getName().endsWith(".jfif"))));
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles(filter);

        for (int i = 0; i < dirContents.length; i++) {
            if (fileName.contains(dirContents[i].getName().split("\\.")[0])) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    public boolean isFileDownloadedWithExtension(String downloadPath, String fileNameExtension,String fileName) {
        FileFilter filter = file -> (file.getName().endsWith(".jpg") || (file.getName().endsWith(".jpeg") || (file.getName().endsWith(".jfif"))));
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles(filter);

        for (int i = 0; i < dirContents.length; i++) {
            String[] extension = dirContents[i].getName().split("\\.");
            if (fileNameExtension.equalsIgnoreCase(extension[extension.length-1])) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean clickDownloadOnFirstImageAndVerifyDownloadedImageInternalTab() throws InterruptedException {
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(firstImageonImagesPage, 20, "Mouse Hover to First Image");
        commonFunctions.moveToElementWithActions(firstImageonImagesPage, 20, "Mouse Hover to First Image");
        commonFunctions.clickElementWithJS(downloadButtonOnFirstImage, 20, "Click on First Image");
        Thread.sleep(10000);
        String src = firstImageonImagesPage.getAttribute("src");
        String arr1[] = src.split("/");
        String fileName = arr1[arr1.length - 1];
        String fileNameWithoutExtension = fileName.split("\\.")[0];
        String downloadedPath = System.getProperty("user.dir");
        boolean isFileDownloaded = isFileDownloaded(downloadedPath, fileNameWithoutExtension);
        return isFileDownloaded;
    }

    @Override
    public boolean isImagesWiresSearchable() {
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(wiresTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(wiresTab, 20, "Click on Wires tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(imagesListOnWiresTab, 30, "Image List");
        commonFunctions.moveToElementWithActions(imagesListOnWiresTab.get(1), 20, "Mouse Hover to First Image");
        String imageDetail = getTextFromImages(1);
        commonFunctions.isElementDisplayedAndPresent(searchInputBox, 20, "Wait for Search input box to be displayed");
        commonFunctions.clickElementIfDisplayed(searchInputBox,20,"Search input box");
        char imageText[] = imageDetail.toCharArray();
        for (int i = 0; i <= imageText.length - 1; i++) {
            commonFunctions.sendKeyWithActions(searchInputBox, Character.toString(imageText[i]));
        }
        commonFunctions.clickElement(searchInputBox, 20, "Search Input");
        commonFunctions.waitForElementIgnoringStaleElement(imagesListOnWiresTab.get(0), 30, "Image List");
        commonFunctions.isElementDisplayedAndPresent(listOfImages.get(0), 20, "wait for search results");
        commonFunctions.moveToElementWithActions(imagesListOnWiresTab.get(0), 20, "Mouse Hover to First Image");
        return listOfImages.size() > 0 && listOfImages.get(0).getText().equalsIgnoreCase(imageDetail);
    }

    public String getTextFromImages(int index) {
        return listOfImages.get(index).getText();
    }

    private void selectImagesLink() {
        commonFunctions.isElementDisplayedAndPresent(imagesLink, 20, "wait for Videos link to be displayed");
        commonFunctions.scrollPageWithJS(imagesLink, 10);
        boolean flag = commonFunctions.clickElement(imagesLink, 25, "Images Link button");
        if(flag == false){
            commonFunctions.clickElementWithJS(imagesLink);
        }
    }

    @Override
    public boolean isNotificationAndCreateStoryButtonDisplayed() {
        boolean isNotificationButtonDisplayed, isCreateStoryButtonDisplayed;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(wiresTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(wiresTab, 20, "Click on Wires tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(imagesListOnWiresTab, 20, "Wait for Images to be loaded");
        isNotificationButtonDisplayed = commonFunctions.isElementDisplayedAndPresent(sendNotificationButton, 30, "Send Notification button");
        isCreateStoryButtonDisplayed = commonFunctions.isElementDisplayedAndPresent(createAStoryButton, 30, "Create A Story button");
        return isNotificationButtonDisplayed && isCreateStoryButtonDisplayed;
    }

    @Override
    public boolean isNotificationAndCreateStoryButtonDisplayedOnInternalTab() {
        boolean isNotificationButtonDisplayed, isCreateStoryButtonDisplayed;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(imagesListOnInternalTab, 20, "Wait for Images to be loaded");
        isNotificationButtonDisplayed = commonFunctions.isElementDisplayedAndPresent(sendNotificationButton, 30, "Send Notification button");
        isCreateStoryButtonDisplayed = commonFunctions.isElementDisplayedAndPresent(createAStoryButton, 30, "Create A Story button");
        return isNotificationButtonDisplayed && isCreateStoryButtonDisplayed;
    }

    @Override
    public boolean isImagesDetailsAndDownloadButtonDisplayed() {
        boolean isDisplayed = true;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(wiresTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(wiresTab, 20, "Click on Wires tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(imagesList, 30, "Image List");
        //Executing the loop till 5 images as images keep on loading while going down the images
        for (int i = 0; i <= 4; i++) {
            commonFunctions.moveToElementWithActions(imagesList.get(i), 20, "Mouse Hover to " + (i + 1) + " Image");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(listOfImagesCaption.get(i), 20, "Wait for Images caption to be displayed");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(listOfImagesCreatedOn.get(i), 20, "Wait for Images caption to be displayed");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(listOfImagesDownloadButton.get(i), 20, "Wait for Download button to be displayed");
            commonFunctions.moveToElementWithActions(wiresTab, 15, "Move to Wires tab to avoid caption overlap to next image");
        }
        return isDisplayed;
    }

    @Override
    public boolean isImagesDetailsAndDownloadButtonDisplayedOnInternalTab() {
        boolean isDisplayed = true;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(internalTab, 20, "Wait for Internal tab to be displayed");
        commonFunctions.clickElement(internalTab, 20, "Click on Internal tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(internalTabImagesList, 30, "Image List");
        //Executing the loop till 5 images as images keep on loading while going down the images
        for (int i = 0; i <= 4; i++) {
            commonFunctions.moveToElementWithActions(internalTabImagesList.get(i), 20, "Mouse Hover to " + (i + 1) + " Image");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(internalTabListOfImagesCaption.get(i), 20, "Wait for Images caption to be displayed");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(internalTabListOfImagesCreatedOn.get(i), 20, "Wait for Images caption to be displayed");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(internalTabListOfImagesDownloadButton.get(i), 20, "Wait for Download button to be displayed");
            commonFunctions.moveToElementWithActions(internalTab, 20, "Move to Internal tab to avoid caption overlap to next image");
        }
        return isDisplayed;

    }


    @Override
    public boolean isImagesPreviewWindowDetailsAndDownloadButtonDisplayed() {
        boolean isPopUpDisplayed = true;
        boolean isCaptionDisplayed = true;
        boolean isCreatedOnDisplayed = true;
        boolean isDownloadBtnDisplayed = true;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(wiresTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(wiresTab, 20, "Click on Wires tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(imagesList, 30, "Image List");
        //Executing the loop till 5 images as images keep on loading while going down the images
        for (int i = 0; i <= 4; i++) {
            commonFunctions.clickElementIfDisplayed(previewImageList.get(i), 30, "Click on preview button of " + (i + 1) + " Image");
            commonFunctions.isElementDisplayedAndPresent(previewImagePopupCloseButtonList.get(i), 20, "Wait for Close button on Preview image popup");
            isPopUpDisplayed &= commonFunctions.isElementDisplayedAndPresent(previewImagePopupList.get(i), 30, "Preview image popup displayed");
            isCaptionDisplayed &= commonFunctions.isElementDisplayedAndPresent(previewImagePopupCaptionList.get(i), 30, "Preview image popup caption text displayed");
            isCreatedOnDisplayed &= commonFunctions.isElementDisplayedAndPresent(previewImagePopupCreatedOnList.get(i), 30, "Preview image popup Created On text displayed");
            isDownloadBtnDisplayed &= commonFunctions.isElementPresentWithTryCatch(previewImagePopupDownloadButtonList.get(i), 5) || commonFunctions.isElementPresentWithTryCatch(previewImagePopupDownloadButtonList.get(i+1), 5) || commonFunctions.isElementPresentWithTryCatch(previewImagePopupDownloadButtonList.get(i+2), 5) || commonFunctions.isElementPresentWithTryCatch(previewImagePopupDownloadButtonList.get(i+3), 5) || commonFunctions.isElementPresentWithTryCatch(previewImagePopupDownloadButtonList.get(i+4), 5);
            commonFunctions.clickElementIfDisplayed(previewImagePopupCloseButtonList.get(i), 20, "Close Preview image popup");
            commonFunctions.isElementDisplayedAndPresent(imagesList, 10, "Wait for Image list to be loaded");
        }
        return isPopUpDisplayed && isCaptionDisplayed && isCreatedOnDisplayed && isDownloadBtnDisplayed;
    }

    @Override
    public boolean isImagesPreviewWindowDetailsAndDownloadButtonDisplayedOnInternalTab() {
        boolean isDisplayed = true;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(internalTab, 20, "Wait for Internal tab to be displayed");
        commonFunctions.clickElement(internalTab, 20, "Click on Internal tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(internalTabImagesList, 30, "Image List");
        //Executing the loop till 5 images as images keep on loading while going down the images
        for (int i = 0; i <= 4; i++) {
            commonFunctions.clickElementIfDisplayed(internalTabPreviewImageList.get(i), 30, "Click on preview button of " + (i + 1) + " Image");
            commonFunctions.isElementDisplayedAndPresent(previewImagePopupCloseButtonList.get(i), 20, "Wait for Close button on Preview image popup");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(internalTabPreviewImagePopupList.get(i), 30, "Preview image popup displayed");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(internalTabPreviewImagePopupCaptionList.get(i), 30, "Preview image popup caption text displayed");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(internalTabPreviewImagePopupCreatedOnList.get(i), 30, "Preview image popup Created On text displayed");
            isDisplayed &= commonFunctions.isElementDisplayedAndPresent(internalTabPreviewImagePopupDownloadButtonList.get(i), 30, "Preview image popup Download button displayed");
            commonFunctions.clickElementIfDisplayed(previewImagePopupCloseButtonList.get(i), 20, "Close Preview image popup");
            commonFunctions.isElementDisplayedAndPresent(internalTabImagesList, 15, "Wait for Image list to be loaded");
        }
        return isDisplayed;
    }

    @Override
    public boolean clickDownloadOnFirstImageAndVerifyDownloadedImageOnWiresTab() {
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(wiresTab, 20, "wait for Wires tab to be displayed");
        commonFunctions.clickElementIfDisplayed(wiresTab, 20, "click on Wires tab");
        commonFunctions.isElementDisplayedAndPresent(firstImageonImagesPageOnWiresTab, 20, "Mouse Hover to First Image");
        commonFunctions.moveToElementWithActions(firstImageonImagesPageOnWiresTab, 20, "Mouse Hover to First Image");
        commonFunctions.clickElementWithJS(downloadButtonOnFirstImageOnWiresTab, 20, "Click on First Image");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        String src = firstImageonImagesPageOnWiresTab.getAttribute("src");
        String arr1[] = src.split("/");
        String fileName = arr1[arr1.length - 1];
        String fileNameWithoutExtension = fileName.split("\\.")[0];
        String fileNameExtension= fileName.split("\\.")[1];
        String downloadedPath = System.getProperty("user.dir");
        boolean isFileDownloaded = isFileDownloadedWithExtension(downloadedPath, fileNameExtension,fileNameWithoutExtension);
        return isFileDownloaded;
    }

    @Override
    public boolean isImagesInternalSearchable() {
        String imageDetail = "";
        boolean isTextMatched=true;
        selectImagesLink();
        commonFunctions.hardWait(5000);
        commonFunctions.isElementDisplayedAndPresent(internalTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(internalTab, 20, "Click on Wires tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(imagesListOnInternalTab, 30, "Image List");

        for (int i = 0; i < imagesListOnInternalTab.size() - 10; i++) {
            commonFunctions.moveToElementWithActions(internalTab, 20, "move to internal tab");
            commonFunctions.hardWait(2000);
            commonFunctions.moveToElementWithActions(imagesListOnInternalTab.get(i), 20, "Mouse Hover to First Image");
            if (!internalTabListOfImagesInfoText.get(i).getText().isEmpty()) {
                imageDetail = internalTabListOfImagesInfoText.get(i).getText();
                break;
            }
        }
        if(!imageDetail.isEmpty()) {
            commonFunctions.scrollPageWithJS(searchInputBoxInternalTab, 20);
            commonFunctions.isElementDisplayedAndPresent(searchInputBoxInternalTab, 20, "Wait for Search input box to be displayed");
            commonFunctions.clickElementIfDisplayed(searchInputBoxInternalTab, 20, "Search input box");
            if (imageDetail.length() > 25) {
                imageDetail = imageDetail.substring(0, 25);
            }
            commonFunctions.sendKeys(searchInputBoxInternalTab, imageDetail.trim(), 10, "imageDetail");

            commonFunctions.clickElementIfDisplayed(searchInputBoxInternalTab, 20, "Search Input");
            commonFunctions.isElementDisplayedAndPresent(searchIcon, 20, "is Search Icon to be displayed");
            commonFunctions.clickElementIfDisplayed(searchIcon, 20, "Search Icon");
            commonFunctions.hardWait(10000);
            commonFunctions.isElementDisplayedAndPresent(imagesListOnInternalTab, 20, "wait for internal images to be displayed");
            commonFunctions.isElementDisplayedAndPresent(searchInputBox, 20, "Wait for Search input box to be displayed");

            for (int i = 0; i < imagesListOnInternalTab.size() - 10; i++) {
                commonFunctions.moveToElementWithActions(internalTab, 20, "move to internal tab");
                commonFunctions.hardWait(2000);
                commonFunctions.moveToElementWithActions(imagesListOnInternalTab.get(i), 20, "Mouse Hover to First Image");
                if (!imageDetail.isEmpty()) {
                    isTextMatched &= internalTabListOfImagesInfoText.get(i).getText().trim().toLowerCase().contains(imageDetail.trim().toLowerCase());
                    System.out.println(internalTabListOfImagesInfoText.get(i).getText());
                }
            }
        }
        return isTextMatched;
        }

    @Override
    public boolean validateListViewOnInternalImages() {
        boolean isListViewDisplayed;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(internalTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(internalTab, 20, "Click on Internal tab under Images page");
        commonFunctions.clickElementIfDisplayed(listViewIcon,30,"Click on List View");
        commonFunctions.isElementDisplayedAndPresent(imagesListOnInternalTabListView, 30, "Image List");
        isListViewDisplayed= commonFunctions.checkForXpathInsideWebElement(imagesListOnInternalTabBlockListView,"ul",20);
        return isListViewDisplayed;
    }

    @Override
    public boolean validateGridViewOnInternalImages() {
        boolean isGridViewDisplayed;
        selectImagesLink();
        commonFunctions.isElementDisplayedAndPresent(internalTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(internalTab, 20, "Click on Internal tab under Images page");
        commonFunctions.isElementDisplayedAndPresent(imagesListOnInternalTab, 30, "Image List");
        isGridViewDisplayed= commonFunctions.checkForXpathInsideWebElement(imagesListOnInternalTabBlock,"li",20);
        return isGridViewDisplayed;
    }


    @Override
    public boolean checkEditImageNameIsPresentInTheCropperWindow(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(imgIcon, 10, "Image");
        commonFunctions.clickElement(imgIcon, 10, "Image");

        commonFunctions.isElementDisplayed(chouseIcon, 10, "Lib Image");
        commonFunctions.clickElement(chouseIcon, 10, "Lib Image");

        commonFunctions.isElementDisplayed(recentImage, 10, "Lib Image");
        commonFunctions.mouseHoverOnElement(recentImage, 10, "Lib Image");

        commonFunctions.isElementDisplayed(useImage, 10, "Use Button");
        commonFunctions.clickElement(useImage, 10, "Use Button");

        if(commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")){
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }

        return commonFunctions.isElementDisplayed(editImageNameText, 10, "Edit Image Name Text Box");
    }

    private void selectStandardStory() {
        commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectStory, 30, " standard story button");
    }

    @Override
    public boolean checkImageNameShouldBeEditable(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(imgIcon, 10, "Image");
        commonFunctions.clickElement(imgIcon, 10, "Image");

        commonFunctions.isElementDisplayed(chouseIcon, 10, "Lib Image");
        commonFunctions.clickElement(chouseIcon, 10, "Lib Image");

        commonFunctions.isElementDisplayed(recentImage, 10, "Lib Image");
        commonFunctions.mouseHoverOnElement(recentImage, 10, "Lib Image");

        commonFunctions.isElementDisplayed(useImage, 10, "Use Button");
        commonFunctions.clickElement(useImage, 10, "Use Button");

        if(commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")){
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }

        String imageName = "Automation_Image_"+commonFunctions.generateRandomNum();

        commonFunctions.isElementDisplayed(editImageNameText, 10, "Edit Image Name Text Box");
        commonFunctions.sendKeys(editImageNameText, imageName, 10, "Edit Image Name Text Box");

        commonFunctions.isElementDisplayed(doneButton, 10, "Done Button");
        commonFunctions.clickElement(doneButton, 10, "Done Button");

        return commonFunctions.isElementDisplayed(imageAfterDone, 20, "Image After Done");
    }

    @Override
    public boolean checkWatermarkOnImagesWithTopic(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Live Mint", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        String storyId=commonFunctions.createStory(headline, summary,  paragraph,  subsection,  byline,
                keyword, location,
                allChangesSaved,  enterHeadlineText,  addSummaryText,
                addParagraphText,  inputAddSubSectionText,  inputAddByLineText,
                inputAddLocationText,  inputAddKeywordText,
                saveButton,  toastSaveButton);
        commonFunctions.inputTopic(topic, topicText, allChangesSaved);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        if(commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")){
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }

        commonFunctions.dummyWait(5);
        commonFunctions.refreshPage();
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(waterMarkWithTopic, 20, "Water Mark With Topic");

    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }

    @Override
    public boolean checkWatermarkOnImagesWithSubSection(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Live Mint", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        String storyId=commonFunctions.createStory(headline, summary,  paragraph,  subsection,  byline,
                keyword, location,
                allChangesSaved,  enterHeadlineText,  addSummaryText,
                addParagraphText,  inputAddSubSectionText,  inputAddByLineText,
                inputAddLocationText,  inputAddKeywordText,
                saveButton,  toastSaveButton);
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        if(commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")){
            commonFunctions.clickElement(yesButton, 10, "Yes Button");
        }

        commonFunctions.dummyWait(5);
        commonFunctions.refreshPage();
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementDisplayed(waterMarkWithSubSection, 20, "Water Mark With Sub Section");

    }


}



