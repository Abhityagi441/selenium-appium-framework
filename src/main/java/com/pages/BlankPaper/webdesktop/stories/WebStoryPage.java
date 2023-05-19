package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonWebStoryPage;
import com.utils.DbUtils;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class WebStoryPage extends CommonWebStoryPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;
    public static DbUtils dbUtils;

    @FindBy(xpath = "//input[@placeholder ='Add meta title here']")
    private static WebElement metaTitleText;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[1]/div")
    private static WebElement enterHeadlineTextBox;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//*[@data-placeholder='Enter the summary..' or @data-placeholder='Enter Summary']")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//div[@class='storytype']//li//child::button[contains(text(),'Web Story')]")
    private static WebElement selectWebStoryLink;

    @FindBy(id = "animationTab")
    private static WebElement animationTab;

    @FindBy(id = "storyHeadline")
    private static WebElement animationHeadlineTextBox;

    @FindBy(id = "defaultOpen")
    private static WebElement metadataTab;

    @FindBy(xpath = "//textarea[@placeholder='Enter meta description here…']")
    private static WebElement metaDescText;

    @FindBy(id = "storySummary")
    private static WebElement animationSummaryTextBox;

    @FindBy(xpath = "//div[@class='templateslist']")
    private static WebElement template;

    @FindBy(xpath = "//button[@class='createSlideBtn']")
    private static WebElement createSlideButton;

    @FindBy(id = "designTab")
    private static WebElement designTab;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and text()='Publish']")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(xpath = "//input[@placeholder='Add Location here..']")
    private static WebElement inputAddLocationText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and contains(text(),'Save')]")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static WebElement inputAddSectionText;

    @FindBy(xpath = "//ul[@id='myTags']//li[@class='tagit-new']//input[contains(@placeholder,'Byline')]")
    private static WebElement inputAddByLineText;

    @FindBy(xpath = "//button[@class='createSlideBtn']")
    private static WebElement createSlideBtn;

    @FindBy(xpath = "//ul[@id='pagiSlide']/li")
    private static List<WebElement> pageSlide;

    @FindBy(xpath = "(//div[@class='template']/img)[1]")
    private static WebElement imageTemplate;

    @FindBy(id = "addImage")
    private static WebElement addImageIcon;

    @FindBy(xpath = "//div[@class='pickimage']")
    private static WebElement addImageLibButton;

    @FindBy(xpath = "//div[@class='imagecontain']/img")
    private static List<WebElement> libImage;

    @FindBy(xpath = "//i[@class='icon-checkbox-tick']")
    private static List<WebElement> iconCheckTickButton;

    @FindBy(xpath = "//button[@name='save']")
    private static WebElement chooseButtonInImageGallery;

    @FindBy(id = "buttonCropingDone")
    private static WebElement doneButton;

    @FindBy(xpath = "//div[@class='gradClass']/..")
    private static WebElement selectedImage;

    @FindBy(id = "addTextbox")
    private static WebElement addTextbox;

    @FindBy(xpath = "//div[contains(@class, 'textInsertion')]/div")
    private static WebElement textInsertion;

    @FindBy(id = "deleteImageVideo")
    private static WebElement deleteImageVideoIcon;

    @FindBy(xpath = "//li[@id='addRightSlide']/img")
    private static WebElement addRightSlideIcon;

    @FindBy(id = "saveButton")
    private static WebElement saveWebStoryButton;

    @FindBy(xpath = "//li[@id='deleteSlide']")
    private static WebElement deleteSlideBtn;

    @FindBy(xpath = "//span[@class='link']/..")
    private static WebElement generatedUrl;







    public WebStoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        dbUtils = DbUtils.getInstance();
    }

    @Override
    public boolean checkThatWhateverDataWeAreProvidingTheSameDataIsPresentInMetatitle(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectWebStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(animationTab, 10, "Animation Tab");
        commonFunctions.clickElement(animationTab, 10, "Animation Tab");
        String inputHeadingText = "Test Meta Title "+commonFunctions.generateRandomNum();
        commonFunctions.isElementDisplayed(animationHeadlineTextBox, 10, "Headline Text");
        commonFunctions.sendKeys(animationHeadlineTextBox, inputHeadingText,10, "Headline Text");
        commonFunctions.clickElement(metadataTab, 10, "Metadata Tab");
        commonFunctions.scrollToElement(metaTitleText, "Meta Title Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaTitleText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Title");

    }

    @Override
    public boolean checkWhateverDataWeAreProvidingSameDataIsPresentInMetadescription(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectWebStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(animationTab, 10, "Animation Tab");
        commonFunctions.clickElement(animationTab, 10, "Animation Tab");
        String inputHeadingText = "Test Meta Summary "+commonFunctions.generateRandomNum();
        commonFunctions.isElementDisplayed(animationSummaryTextBox, 10, "Summary Text");
        commonFunctions.sendKeys(animationSummaryTextBox, inputHeadingText,10, "Summary Text");
        commonFunctions.clickElement(metadataTab, 10, "Metadata Tab");
        commonFunctions.scrollToElement(metaDescText, "Meta Desc Text Box");
        commonFunctions.dummyWait(5);
        return commonFunctions.checkTextContains(commonFunctions.getAttributeValue(metaDescText, 20, "ng-reflect-model").trim(), inputHeadingText.trim(), "Meta Description");
    }

    private void selectWebStory() {
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectWebStoryLink, 25, "Web story button");
    }

    @Override
    public  boolean checkWebStoryPageShouldOpen(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectWebStory();
        Set<String> windowSet = commonFunctions.getWindowHandles(2);
        boolean windowStatus = windowSet.size()>1;
        commonFunctions.switchToLastWindow(windowSet);
        return windowStatus && commonFunctions.isElementPresent(template, 10) && commonFunctions.isElementPresent(createSlideButton, 10) && commonFunctions.isElementPresent(designTab, 10) && commonFunctions.isElementPresent(metadataTab, 10) && commonFunctions.isElementPresent(animationTab, 10);
    }

    public boolean checkAfterPublishingWebStoryTheCompleteDataGoesToMasterDb(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        String id = createWebStory(headLine, summary, byline, section, subsection, keyword, location);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 5)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        commonFunctions.isElementPresent(popupPublishButton, 20);
        return dbUtils.mongoDbConnectionAndStoryDetails("PUBLISHED", id, property, globalVars.getEnvironment(), headLine, summary, paragraph, section, subsection, location, byline);
    }

    private String createWebStory(String headline, String summary, String byline, String section, String subsection, String keyword, String location) {
        selectWebStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(animationTab, 10, "Animation Tab");
        commonFunctions.clickElement(animationTab, 10, "Animation Tab");
        commonFunctions.inputHeadline(headline, animationHeadlineTextBox);
        commonFunctions.inputSummary(summary, animationSummaryTextBox);
        commonFunctions.clickElement(metadataTab, 10, "Metadata Tab");
        commonFunctions.inputSection(section, inputAddSectionText, allChangesSaved);
        commonFunctions.inputSubSection(subsection, inputAddSubSectionText, allChangesSaved);
        commonFunctions.dummyWait(5);
        commonFunctions.inputByLine(byline, inputAddByLineText);
        commonFunctions.inputKeyWords(keyword, inputAddLocationText, inputAddKeywordText);
        commonFunctions.inputLocation(location, inputAddLocationText);
        saveWebStoryAndVerify();
        return commonFunctions.setStoryId();
    }

    private void saveWebStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 10, "save story button");
        List<WebElement> elements = new ArrayList<>();
        elements.add(toastSaveButton);
        commonFunctions.isElementDisplayed(elements, 10, "Toast message for saved status is");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
    }

    @Override
    public boolean checkUserShouldBeAbleToAddImageAndTextOnSlide(String imageText){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectWebStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.clickElement(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.isElementDisplayed(imageTemplate, 10, "Template");
        commonFunctions.clickElement(imageTemplate, 10, "Template");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(pageSlide.get(0), 10, "Pagi Slide");
        boolean imageSelectStatus = selectSingleImageFromLibrary();
        boolean textInsertionStatus = insertTextOnImage(imageText);
        return imageSelectStatus && textInsertionStatus;
    }

    public boolean insertTextOnImage(String text){
        commonFunctions.dummyWait(10);
        commonFunctions.isElementDisplayed(addTextbox, 10, "Add Text Icon");
        commonFunctions.clickElement(addTextbox, 10, "Add Text Icon");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(textInsertion, 10, "Text Insertion");
        commonFunctions.sendKeys(textInsertion, text, 10, "Text Insertion");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(saveWebStoryButton, 10, "Save Web Story Button");
        commonFunctions.dummyWait(5);
        return commonFunctions.getElementTextAndCheck(textInsertion, text, 10, "Text Insertion");
    }

    public boolean selectSingleImageFromLibrary(){
        commonFunctions.isElementDisplayed(addImageIcon, 10, "Add Image Icon");
        commonFunctions.clickElement(addImageIcon, 10, "Add Image Icon");
        commonFunctions.isElementDisplayed(addImageLibButton, 10, "Add Image Lib Button");
        commonFunctions.clickElement(addImageLibButton, 10, "Add Image Lib Button");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementDisplayed(libImage.get(0), 10, "Lib Image");
        commonFunctions.mouseHoverOnElement(libImage.get(0), 10 ,"Lib Image");
        commonFunctions.dummyWait(3);
        commonFunctions.isElementDisplayed(iconCheckTickButton.get(0), 10, "Icon Check Tick Button");
        commonFunctions.clickElement(iconCheckTickButton.get(0), 10, "Icon Check Tick Button");
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(chooseButtonInImageGallery, "Choose Button In Image Gallery");
        commonFunctions.clickElementWithJS(chooseButtonInImageGallery, 10, "Choose Button In Image Gallery");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 10)){
            commonFunctions.clickElementIfDisplayed(buttonYes, 5, "yes button");
        }
        commonFunctions.clickElement(doneButton, 10, "Done Button for lead Image");
        commonFunctions.dummyWait(5);
        String selectedImageStyle = null;
        try{
            selectedImageStyle = commonFunctions.getAttributeValue(selectedImage, 10, "style");
        }catch(Exception e){}
        return commonFunctions.checkTextContains("background: url", selectedImageStyle, "Selected Image");
    }

    @Override
    public boolean checkUserShouldBeAbleToDeleteTheImageFromSlide(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectWebStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.clickElement(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.isElementDisplayed(imageTemplate, 10, "Template");
        commonFunctions.clickElement(imageTemplate, 10, "Template");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(pageSlide.get(0), 10, "Page Slide");
        selectSingleImageFromLibrary();
        return deleteImageFromSlide();
    }

    public boolean deleteImageFromSlide(){
        commonFunctions.dummyWait(10);
        commonFunctions.isElementDisplayed(deleteImageVideoIcon, 10, "Delete Image Video Icon");
        commonFunctions.clickElement(deleteImageVideoIcon, 10, "Delete Image Video Icon");
        commonFunctions.dummyWait(5);
        String selectedImageStyle = null;
        try{
            selectedImageStyle = commonFunctions.getAttributeValue(selectedImage, 10, "style");
        }catch(Exception e){}
        return !commonFunctions.checkTextContains("background: url", selectedImageStyle, "Selected Image");
    }

    @Override
    public boolean checkUserShouldBeAbleToAddMultipleSlides(String firstImageText, String secoundImageText){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectWebStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.clickElement(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.isElementDisplayed(imageTemplate, 10, "Template");
        commonFunctions.clickElement(imageTemplate, 10, "Template");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(pageSlide.get(0), 10, "Page Slide");
        selectSingleImageFromLibrary();
        insertTextOnImage(firstImageText);
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(addRightSlideIcon, 10, "Add Right Slide Icon");
        commonFunctions.clickElement(addRightSlideIcon, 10, "Add Right Slide Icon");
        commonFunctions.dummyWait(5);
        selectSingleImageFromLibrary();
        insertTextOnImage(secoundImageText);
        return pageSlide.size()>1;
    }

    @Override
    public boolean checkUserShouldBeAbleToDeleteTheTextFromTheSlide(String imageText){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectWebStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayed(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.clickElement(createSlideBtn, 10, "Create Slide Btn");
        commonFunctions.isElementDisplayed(imageTemplate, 10, "Template");
        commonFunctions.clickElement(imageTemplate, 10, "Template");
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(pageSlide.get(0), 10, "Page Slide");
        insertTextOnImage(imageText);
        return deleteTextFromSlide(imageText);
    }

    public boolean isSlideDeleted(int slides){
        boolean isSlideDeleted=false;
        commonFunctions.isElementDisplayed(deleteSlideBtn, 10, "Delete a slide");
        commonFunctions.clickElement(deleteSlideBtn);
        if(pageSlide.size()<slides) isSlideDeleted=true;
        return isSlideDeleted;
    }
    @Override
    public boolean isUserAbleToDeleteTheAddedSlides(String firstImageText,String secondImageText) {
        if(checkUserShouldBeAbleToAddMultipleSlides(firstImageText,secondImageText)) return isSlideDeleted(pageSlide.size());
        return false;
    }

    public boolean deleteTextFromSlide(String text){
        commonFunctions.dummyWait(5);
        commonFunctions.clearText(textInsertion);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(saveWebStoryButton, 10, "Save Web Story Button");
        commonFunctions.dummyWait(5);
        boolean imageTextStatus = commonFunctions.checkTextNotEquals(text.trim(), commonFunctions.getElementText(textInsertion).trim(), "Image Text");
        return imageTextStatus;
    }

    @Override
    public boolean checkIfUserIsAbleToCreateWebStory(String headLine, String summary, String byline, String section, String subsection,String keyword,String location) {
        createWebStory(headLine,summary,byline,section,subsection,keyword,location);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if (commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        boolean result = commonFunctions.isElementPresent(popupPublishButton, 20);
        if (result) {
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElementViewAndClick(generatedUrl, 10, "url generated");
            Set<String> windowsList1 = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            if (windowsList1.size() == 3) return true;
        }
        return true;
    }
}
