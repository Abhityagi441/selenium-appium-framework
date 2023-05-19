package com.pages.BlankPaper.webdesktop.stories;


import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonPhotoStoryPage;
import com.utils.DbUtils;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PhotoStoryPage extends CommonPhotoStoryPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;

    public static DbUtils dbUtils;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[1]/div")
    private static WebElement enterHeadlineTextBox;

    @FindBy(id = "inputAddMetaTitleText")
    private static WebElement metaTitleText;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[2]")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='storytype']//li//button[@class='standard' and text()='Photo Story']")
    private static WebElement selectPhotoStory;

    @FindBy(xpath = "//textarea[@placeholder='Enter meta description here…']")
    private static WebElement metaDescText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement toastPublish;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and text()='Save']")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//ul[@id='myTags']//li[@class='tagit-new']//input[contains(@placeholder,'Byline')]")
    private static WebElement inputAddByLineText;

    @FindBy(xpath = "//button[contains(@class,'ml10') and contains(text(),'Done')]")
    private static WebElement buttonCropingDone;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Cropped successfully')]")
    private static WebElement toastCropingDone;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "//span[@class='pickimageBtn']")
    private static WebElement imagePicFromLib;

    @FindBy(xpath = "//ul[@class='imagelist search-results']//li//img")
    private static List<WebElement> imgInLibList;

    @FindBy(xpath = "//span[@class='hover']/button[@class='blue']")
    private static List<WebElement> useInLibList;

    @FindBy(xpath = "//input[@placeholder='Add Location here..']")
    private static WebElement inputAddLocationText;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[3]")
    private static WebElement enterAddSlideDescription;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(id = "iconForImageUpload")
    private static WebElement slideImageIcon;

    @FindBy(xpath = "//div[@class='dataField']/button[@name='createCard']")
    private static WebElement addSlideButton;

    @FindBy(xpath = "//div[@class='dataField bdrfill']//span[@class='threedots']")
    private static WebElement threeDots;

    @FindBy(xpath = "//div[@class='revertStoryBlock']/ul/li/button[text()='Edit']")
    private static WebElement threeDotsEdit;

    @FindBy(xpath = "//li[@class='selectlead']//span[@class='slider round']")
    private static WebElement leadMediaSlider;

    @FindBy(xpath = "//button[@name='saveStory']")
    private static WebElement slideDoneButton;

    @FindBy(xpath = "//span[@id='storyUrl']/..")
    private static WebElement generatedUrl;


    @FindBy(xpath = "(//div[contains(@class,'ck-content')])[4]")
    private static WebElement addCaptionText1;

    @FindBy(id="addCaptionText")
    private static WebElement addCaptionText2;

    @FindBy(xpath = "(//div[contains(@class,'ck-content')])[4]/p")
    private static WebElement addCaptionTextArea;


    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//button[@name='saveStory']")
    private static WebElement editDoneButton;

    @FindBy(xpath = "//div[@id='addCaptionForImage']/input")
    private static WebElement firstImageCaption;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//label")
    private static WebElement firstImageCaptionNameData;

    @FindBy(xpath = "//div[contains(@class,'snotify-error')]")
    private static WebElement croppingDoneError;



    public PhotoStoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage= CommonDashboardPage.getInstance();
        dbUtils = DbUtils.getInstance();
    }

    private void selectPhotoStory() {
        commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectPhotoStory, 30, " Photo story button");
    }

    @Override
    public  boolean checkThatWhateverDataWeAreProvidingInLandingPageHeadlineOnPhotoStoryTheSameDataIsPresentInMetatitleOrNot(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectPhotoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        String inputHeadingText = "Test Meta Title "+commonFunctions.generateRandomNum();
        commonFunctions.inputHeadline(inputHeadingText,enterHeadlineTextBox);
        commonFunctions.inputSummary(inputHeadingText,addSummaryText);
        commonFunctions.scrollToElement(metaTitleText, "Meta Title Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaTitleText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Title");

    }

    @Override
    public boolean checkThatSummaryOfPhotoStorySameIsPresentInMetadescription(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectPhotoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        String inputHeadingText = "Test Meta Summary "+commonFunctions.generateRandomNum();
        commonFunctions.inputSummary(inputHeadingText,addSummaryText);
        commonFunctions.scrollToElement(metaDescText, "Meta Desc Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaDescText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Description");

    }

    @Override
    public boolean checkMasterDbMetaTitleAndMetaDescriptionComesForPhotoStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String slideDesc){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectPhotoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        createPhotoStoryAndPublish(headLine, summary, section, subsection, keyword, location, byline, slideDesc);
        return dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", storyIdNumber, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline);
    }

    public boolean createPhotoStoryAndPublish(String headline, String summary, String section, String subsection, String keyword, String location, String byline, String slideDesc){
        inputHeadline(headline);
        inputSummary(summary);
        inputSection(section);
        inputSubSection(subsection);
        inputKeyWords(keyword);
        inputLocation(location);
        selectImageFromLibrary();
        addSlide(slideDesc);
        setAsLeadMedia();
        inputByLine(byline);
        savePhotoGalleryAndVerify();
        setStoryId();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        return commonFunctions.isElementPresentWithTryCatch(toastPublish, 20);
    }

    public void setAsLeadMedia(){
        commonFunctions.scrollPageWithJS(threeDots, 10);
        commonFunctions.clickElementWithJS(threeDots, 10, "Three Dots");
        commonFunctions.isElementDisplayed(threeDotsEdit, 10, "Edit Link");
        commonFunctions.clickElement(threeDotsEdit, 10, "Edit Link");
        commonFunctions.hardWait(5000);
        commonFunctions.isElementDisplayed(leadMediaSlider, 10, "Lead Media Slider");
        commonFunctions.scrollUsingAction(leadMediaSlider, "Lead Media Slider");
        commonFunctions.clickElement(leadMediaSlider, 10, "Lead Media Slider");
        commonFunctions.hardWait(5000);
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.isElementDisplayedAndPresent(buttonCropingDone, 10,"done button");
        commonFunctions.clickElement(buttonCropingDone, 10,"done button");
        commonFunctions.checkElementText(allChangesSaved, "SAVING CHANGES...",20, "wait for saving changes ");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED",20, "wait for all changed are saved");
        commonFunctions.isElementDisplayedAndPresent(slideDoneButton, 10,"Done button");
        commonFunctions.clickElement(slideDoneButton, 10,"Done button");
    }

    public void addSlide(String slideDesc){
        commonFunctions.isElementDisplayedAndPresent(enterAddSlideDescription,20,"wait for Add Slide to be displayed");
        commonFunctions.sendKey(enterAddSlideDescription, slideDesc);
        commonFunctions.isElementDisplayedAndPresent(addSlideButton,20,"wait for Add Slide button to be displayed");
        commonFunctions.clickElement(addSlideButton,20,"Add Slide button");
    }

    public boolean addImageCaption(String caption) {
        commonFunctions.isElementDisplayedAndPresent(threeDots, 20, "three Dots First Image");
        commonFunctions.scrollPageWithJS(threeDots, 20);
        commonFunctions.clickElementWithJS(threeDots, 20, "three Dots First Image");
        commonFunctions.clickElementWithJS(threeDotsEdit, 20, "edit Image");
        commonFunctions.isElementDisplayedAndPresent(firstImageCaption, 10, "image caption");
        commonFunctions.clickElementIfDisplayed(firstImageCaption, 10, "image caption");
        if (firstImageCaption.getText().length() > 0) {
            firstImageCaption.clear();
        }
        commonFunctions.clickElementIfDisplayed(firstImageCaption);
        commonFunctions.sendKeyWithActions(firstImageCaption, caption);
        commonFunctions.scrollPageWithJS(editDoneButton, 5);
        commonFunctions.hardWait(2000);
        commonFunctions.clickElementWithJS(editDoneButton, 10, "first image done button");
        boolean isShowing = commonFunctions.checkElementText(firstImageCaptionNameData, "image caption", 15, "first image Caption name");
        return isShowing;
    }


    public void setStoryId(){
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
    }

    private void savePhotoGalleryAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        List<WebElement> elements = new ArrayList<>();
        elements.add(toastSaveButton);
        commonFunctions.isElementDisplayed(elements, 10, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
    }

    private void inputByLine(String byline) {
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved,20,"wait for changes saved label ");
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
    }

    private void imageCroppingAndVerify() {
        if(commonFunctions.isElementPresentWithTryCatch(buttonCropingDone, 30)) {
            commonFunctions.scrollPageWithJS(buttonCropingDone, 10);
            commonFunctions.clickElementWithJS(buttonCropingDone, 20, "done Button");
            if(commonFunctions.isElementDisplayedWithExceptionHandling(croppingDoneError,10,"error in cropping")){
                commonFunctions.dummyWait(5);
                commonFunctions.clickElementIfDisplayed(buttonCropingDone, 20, "done Button");
            }
            commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 20, "Cropped Successfully message is present");
            commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED",20, "wait for all changed are saved");
        }
    }

    private void selectImageFromLibrary() {
        commonFunctions.clickElement(slideImageIcon, 10, "Slide Image Icon");
        commonFunctions.clickElement(imagePicFromLib, 10, "Picture from Image Library");
        commonFunctions.isElementDisplayedAndPresent(imgInLibList,20,"Wait for list to be loaded");

        for(int i=0;i<=imgInLibList.size()-1;i++){
            if(imgInLibList.get(i).getAttribute("src").contains("amazonaws")){
                commonFunctions.mouseHoverOnElement(imgInLibList.get(i),10,"Image having Src value");
                commonFunctions.clickElementIfDisplayed(useInLibList.get(i),10,"click on Image having Src value");
                break;
            }
        }

        commonFunctions.isElementDisplayedAndPresent(buttonCropingDone, 4,"done button");
        commonFunctions.clickElement(buttonCropingDone, 4,"done button");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED",20, "wait for all changed are saved");
        imageCroppingAndVerify();
    }

    private void inputLocation(String location) {
        if(commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 10, "location box")) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
        }
    }


    private void inputHeadline(String headline) {
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText,20,"Wait for headline to be displayed");
        char[] summaryChar = headline.toCharArray();
        for(int i=0;i<=summaryChar.length-1;i++){
            commonFunctions.sendKeyWithActions(enterHeadlineText,Character.toString(summaryChar[i]));
        }
    }

    private void inputSummary(String summary) {
        commonFunctions.isElementDisplayedAndPresent(addSummaryText,20,"wait for summary to be displayed");
        commonFunctions.sendKey(addSummaryText, summary);
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }

    private void inputSubSection(String subsection) {
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 20, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved,20,"wait for Save changes text");
    }

    private void inputKeyWords(String keyword) {
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved,20,"wait for Save changes text");
    }

    @Override
    public boolean checkCreatePhotoStoryWithLiveHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String slideDesc){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        selectPhotoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return createPhotoStoryAndPublish(headLine, summary, section, subsection, keyword, location, byline, slideDesc);
    }

    @Override
    public boolean checkCIfUserIsAbleToCreatePhotoStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String slideDesc, String imageCaption, String caption) {
        selectPhotoStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        selectImageFromLibrary();
        addSlide(slideDesc);
        commonFunctions.hardWait(5000);
        boolean result=addImageCaption(caption);
        if(result){
            setAsLeadMedia();
            commonFunctions.hardWait(5000);
            inputSummary(summary);
            inputByLine(byline);
            inputSection(section);
            inputSubSection(subsection);
            inputKeyWords(keyword);
            inputLocation(location);
            commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
            if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
                commonFunctions.clickElement(buttonYes, 10, "Yes Button");
            }
            boolean isResult= commonFunctions.isElementPresent(toastPublish, 20);
            if(isResult){
                commonFunctions.hardWait(2000);
                commonFunctions.scrollToElementViewAndClick(generatedUrl,10,"url generated");
                Set<String> windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
                if(windowsList1.size()==3) return true;
            }
        }
        return false;
    }
}
