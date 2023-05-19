package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonEmbedPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class EmbedPage extends CommonEmbedPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String embedID;
    private static CommonDashboardPage commonDashboardPage;

    @FindBy(xpath = "//button[@class='createCard']")
    private static WebElement createElementButton;

    @FindBy(xpath = "//button[contains(text(),'Create Embed')]")
    private static WebElement createEmbedButton;

    @FindBy(xpath = "//div[contains(@class,'unlockStory')]")
    private static WebElement embedPopup;

    @FindBy(css = "input[placeholder='Search Elements here...']")
    private static WebElement searchAllElementsText;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//span[text()='All Elements']")
    private static WebElement allElementsField;

    @FindBy(xpath = "(//textarea[contains(@placeholder,'Facebook, tweet')])[1]")
    private static WebElement embedTextbox;

    @FindBy(xpath = "//button[contains(@type,'button') and contains(@name,'unlock')]")
    private static WebElement doneButtonOnPopup;

    @FindBy(xpath = "//button[contains(@type,'button') and contains(@name,'cancel')]")
    private static WebElement cancelButtonOnPopup;

    @FindBy(xpath = "//input[contains(@placeholder,'Add element name')]")
    private static WebElement nameUnderMetaData;

    @FindBy(xpath = " //input[contains(@placeholder,'Add tag')]")
    private static WebElement tagsUnderMetaData;


    @FindBy(xpath = " (//span[@class='tagit-label'])[2]")
    private static WebElement tagDataText;

    @FindBy(xpath = " //input[contains(@placeholder,'Add external Url')]")
    private static WebElement externalURLUnderMetaData;

    @FindBy(xpath = " //input[contains(@placeholder,'Add element Title')]")
    private static WebElement titleUnderMetaData;

    @FindBy(xpath = " //input[contains(@placeholder,'Add json')]")
    private static WebElement jsonSourceURLUnderMetaData;

    @FindBy(xpath = " //input[contains(@placeholder,'Add Subtype')]")
    private static WebElement subtypeUnderMetaData;

    @FindBy(xpath = " //button[contains(@class,'green')]")
    private static WebElement publishButton;

    @FindBy(xpath = "//div[contains(text(),'Updated and published')]")
    private static WebElement publishMessage;

    @FindBy(xpath = " //section[contains(@class,'mainContainer')]//aside[@class='leftMenu']")
    private static WebElement collapsedLeftMenu;

    @FindBy(xpath = "(//label[contains(text(),'Embed Code')])[1]")
    private static WebElement embedVideoComponent;

    @FindBy(xpath = "(//span[contains(@class,'editBtn')])[1]")
    private static WebElement embedVideoEditLink;

    @FindBy(xpath = "//div[contains(@class,'unlockStory')]")
    private static List<WebElement> embedPopupList;

    @FindBy(xpath = "//iframe[@title='YouTube video player']")
    private static WebElement embedVideoIframe;

    @FindBy(xpath = "//div[contains(@class,'head')]")
    private static WebElement metaDataHeader;

    @FindBy(xpath = "//div[contains(text(),'Changes will not')]")
    private static WebElement changesNotSavedPopup;

    @FindBy(xpath = "//span[contains(@class,'created')]")
    private static WebElement autoSavedChangesLabel;

    @FindBy(xpath = "//div[@class='storyListing']//small")
    private static List<WebElement> listOfAllElements;

    @FindBy(xpath = "//div[@class='footerPagination']")
    private static WebElement footerPagination;

    @FindBy(xpath = "//span[contains(@id,'defaultOpen')]")
    private static WebElement createAEmbedLabel;

    @FindBy(xpath = "//div[contains(@class,'pageContainer')]//span[@class='threedots']")
    private static WebElement threeDots;

    @FindBy(xpath = "//div[contains(@class,'pageContainer')]//button[text()='Discard Element']")
    private static WebElement discardElements;

    @FindBy(xpath = "//button[@aria-label='Play']")
    private static WebElement videoPlayButton;

    public static String EMBED_VIDEO = "//div[contains(@style,'%s')]";
    public static String CREATED_EMBED = "//div[contains(@class,'storyListing')]//*[text()='%s']";
    public static String CREATED_EMBED_STATUS = "//div[contains(@class,'storyListing')]//*[text()='%s']/ancestor::li/following-sibling::li[contains(@class,'status')]";
    @FindBy(xpath = "//div[contains(text(),'Showing 1 result')]")
    private static WebElement singleRecordConformation;
    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;
    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;
    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//li[@class='active']")
    private static WebElement suggestionAppear;


    @FindBy(xpath = "//input[@id='inputAddTagType']")
    private static WebElement tagTypeField;

    public EmbedPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonDashboardPage= CommonDashboardPage.getInstance();
    }

    private void selectCreateEmbedButton() {
        commonFunctions.clickElement(createElementButton, 20, "Create Element button");
        commonFunctions.clickElementWithJS(createEmbedButton, 25, "Create Embed button");
    }
    @Override
    public void selectEmbedButtonAndSwitchToNewWindow() {
        selectCreateEmbedButton();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        }

        //Commenting this method from here as it already exists in the DashboardPage class
//    @Override
//    public boolean navigateToHomePageAllElements() {
//        boolean isAllElementsDisplayed;
//        commonFunctions.clickElementIfDisplayed(allElementsField, 10, "All Elements Label");
//        isAllElementsDisplayed=commonFunctions.isElementDisplayedAndPresent(allElementsField,10,"All Elements Field");
//        return isAllElementsDisplayed;
//    }
    @Override
    public void navigateToHomePageAllElementsViaLeftMenu() {
        commonFunctions.moveToElementWithActions(collapsedLeftMenu,2,"Left Menu");
        commonFunctions.clickElementIfDisplayed(allElementsField, 10, "All Elements Label");
    }

    @Override
    public void fillEmbedCode(String embedCode) {
        commonFunctions.isElementDisplayed(embedTextbox,15);
        commonFunctions.sendKeys(embedTextbox,embedCode,10,"EmbedCode");
    }

    @Override
    public boolean createEmbedAndVerifyEmbedValidationMessagePresent(String embedCodeTextMessage){
        createEmbedInPopup(embedCodeTextMessage);
        //To DO, No Error message is present as of now
        return false;
    }
    @Override
    public boolean isEmbedVideoDisplayed(String embedVideoCodes){
        commonFunctions.clickElement(createAEmbedLabel);
        commonFunctions.switchToFrame(0,20);
        commonFunctions.isElementDisplayedAndPresent(videoPlayButton,10,"Video button");
        boolean flag= commonFunctions.isElementDisplayedAndPresent(String.format(EMBED_VIDEO,embedVideoCodes),20,"Verify Embed Video is Displayed");
        commonFunctions.switchToParentFrame();
        return flag;
    }
    @Override
    public void fillMetaDataOnCreateEmbedPage(String name, String tags,String externalURL,String title,String jsonSourceURL,String subtype){
        commonFunctions.sendKeys(nameUnderMetaData,name,10,"Name");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED",20, "wait for all changed are saved");
        commonFunctions.sendKeys(tagsUnderMetaData,tags,10,"Tags" );
        commonFunctions.sendKeysWithEnter(tagsUnderMetaData,10);
        commonFunctions.sendKeys(externalURLUnderMetaData, externalURL,10,"ExternalURL");
        commonFunctions.sendKeys(titleUnderMetaData,title,10,"Title" );
        commonFunctions.sendKeys(jsonSourceURLUnderMetaData, jsonSourceURL,10,"JSON Source URL");
        commonFunctions.sendKeys(subtypeUnderMetaData, subtype,10,"SubType");
        commonFunctions.isElementDisplayedAndPresent(autoSavedChangesLabel,10,"Wait for Auto Saved changes label before filling metadeta");
        getEmbedId();
    }

    @Override
    public boolean isEmbedCreationStatus(String name) {
        boolean flag;
        searchElementByID(embedID);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        flag = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        return flag;
    }

    @Override
    public boolean navigateToAllElementsAndVerifyEmbedPublishingStatus(String name) {
        boolean flag;
        navigateToHomePageAllElementsViaLeftMenu();
        searchElementByID(embedID);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        flag = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return flag;
    }

    @Override
    public boolean clickEditLinkOnEmbedVideoAndVerifyEmbedPopup(){
       commonFunctions.moveToElementWithActions(embedVideoComponent,10,"Video Component");
       commonFunctions.clickElementIfDisplayed(embedVideoEditLink,20,"Click on Edit link");
        return commonFunctions.isElementDisplayedWithoutTryCatch(embedPopup,20,"Edit Embed Popup");
    }

    @Override
    public boolean fillEmbedCodeAndClickCancelButtonAndVerifyEmbedPopUpClosed(String embedCode){
        selectEmbedButtonAndSwitchToNewWindow();
        fillEmbedCode(embedCode);
        commonFunctions.waitForElementBeDisplayAndClick(cancelButtonOnPopup,10,"Cancel button");
        return isEmbedPopupClosed();
    }

    @Override
    public boolean isEmbedPopupClosed(){
        return !commonFunctions.isElementDisplayedAndPresent(embedPopupList,20,"Video Popup");
    }

    @Override
    public void createEmbedInPopup(String embedCode) {
        selectEmbedButtonAndSwitchToNewWindow();
        fillEmbedCode(embedCode);
        commonFunctions.clickElementIfDisplayed(doneButtonOnPopup,20,"Click on Done button");
    }

    @Override
    public boolean createEmbedInPopupAndVerifyEmbedVideoDisplayed(String embedCode,String embedVideoCodes) {
        createEmbedInPopup(embedCode);
       return isEmbedVideoDisplayed(embedVideoCodes);
    }

    public boolean createEmbedAndVerifyMetaDataValidation(String embedCode){
        createEmbedInPopup(embedCode);
        return commonFunctions.isElementDisplayed(changesNotSavedPopup,2);
    }

    @Override
    public boolean fillMetaDataAndVerifyEmbedPublishingStatus(String name, String tags, String externalURL, String title, String jsonSourceURL, String subtype) {
        boolean isShowing;
        fillMetaDataOnCreateEmbedPage(name, tags, externalURL, title, jsonSourceURL, subtype);
        commonFunctions.clickElementIfDisplayed(publishButton, 20, "Click on Publish Button");
        isShowing = commonFunctions.isElementDisplayedWithoutTryCatch(publishMessage, 20, "publish toaster massage");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for all changed are saved");
        return isShowing;
    }

    @Override
    public boolean fillMetaDataAndVerifyEmbedCreationStatus(String name, String tags, String externalURL, String title, String jsonSourceURL, String subtype) {
        fillMetaDataOnCreateEmbedPage(name, tags, externalURL, title, jsonSourceURL, subtype);
        navigateToHomePageAllElementsViaLeftMenu();
        return isEmbedCreationStatus(name);
    }

    @Override
    public boolean openCreatedEmbedAndPublishIt() {
        boolean isShowing;
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "video list item");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for all changed are saved");
        commonFunctions.clickElementIfDisplayed(publishButton, 20, "Click on Publish Button");
        isShowing = commonFunctions.isElementDisplayedWithoutTryCatch(publishMessage, 20, "publish toaster massage");
        commonFunctions.checkElementText(allChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for all changed are saved");
        return isShowing;
    }


    @Override
    public boolean createAndDiscardEmbed(String name,String tags,String externalURL,String title,String jsonSourceURL,String subtype) {
        fillMetaDataOnCreateEmbedPage(name, tags, externalURL, title, jsonSourceURL, subtype);
        navigateToHomePageAllElementsViaLeftMenu();
        return commonDashboardPage.findAndDiscardElement(embedID);
    }

    @Override
    public void discardCreatedEmbed(){
            commonFunctions.clickElement(threeDots,10,"Click on Three Dots");
            commonFunctions.isElementDisplayedAndPresent(discardElements,20,"wait for Discard button to be displayed");
            commonFunctions.clickElement(discardElements,10,"Click on Discard Element button");
    }
    @Override
    public boolean discardEmbedAndVerifyDiscardEmbedNotDisplayed(String name){
        discardCreatedEmbed();
        navigateToHomePageAllElementsViaLeftMenu();
        if(commonFunctions.isElementDisplayedAndPresent(footerPagination,10,"Wait for Footer Pagination")) {
            for (WebElement e : listOfAllElements) {
                if (e.getAttribute("title").equalsIgnoreCase(name))
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean enterNameAndDiscardEmbed(String name) {
        commonFunctions.sendKeys(nameUnderMetaData,name,10,"Name");
        discardCreatedEmbed();
        return true;
    }

    @Override
    public boolean editMetaDataAndRefreshAndVerifyChangedData(String editedName, String editedTags, String editedExternalURL, String editedTitle, String editedJsonSourceURL, String editedSubtype) {
        boolean isEditedDataMatched=true;
        commonFunctions.isElementDisplayedAndPresent(autoSavedChangesLabel,20,"wait for Auto saved label");
        fillMetaDataOnCreateEmbedPage(editedName, editedTags, editedExternalURL, editedTitle, editedJsonSourceURL, editedSubtype);
        commonFunctions.isElementDisplayedAndPresent(autoSavedChangesLabel,20,"wait for Auto saved label");
        commonFunctions.hardWait(5000);
        commonFunctions.refreshPage();
        commonFunctions.isElementDisplayedAndPresent(autoSavedChangesLabel,20,"wait for Auto saved label");
        isEditedDataMatched &= commonFunctions.getAttributeValue(nameUnderMetaData,20,"ng-reflect-model").equalsIgnoreCase(editedName);
        isEditedDataMatched &= commonFunctions.getElementText(tagDataText,10).equalsIgnoreCase(editedTags);
        isEditedDataMatched &= commonFunctions.getAttributeValue(titleUnderMetaData,20,"ng-reflect-model").equalsIgnoreCase(editedTitle);
        isEditedDataMatched &= commonFunctions.getAttributeValue(externalURLUnderMetaData,20,"ng-reflect-model").equalsIgnoreCase(editedExternalURL);
        isEditedDataMatched &= commonFunctions.getAttributeValue(jsonSourceURLUnderMetaData,20,"ng-reflect-model").equalsIgnoreCase(editedJsonSourceURL);
        isEditedDataMatched &= commonFunctions.getAttributeValue(subtypeUnderMetaData,20,"ng-reflect-model").equalsIgnoreCase(editedSubtype);
        return isEditedDataMatched;
    }

    private void searchElementByID(String id){
        commonFunctions.sendKeysOnElementVisibility(searchAllElementsText, "id:" + id, 10, "search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText,10);
    }

    public void getEmbedId(){
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        embedID = id[id.length - 1];
        System.out.println("EMBED ID:" + embedID);
    }

    @Override
    public boolean checkIfAllTheDropDownOptionsPresentInTagTypeSelectionField(String embedText, String option1, String option2, String option3, String option4, String option5, String option6, String option7, String option8, String option9, String option10, String option11) {
        boolean result=false;
        selectEmbedButtonAndSwitchToNewWindow();
        fillEmbedCode(embedText);
        commonFunctions.clickElementIfDisplayed(doneButtonOnPopup);
        result=TagTypeSelectionVerification(option1);
        result&=TagTypeSelectionVerification(option2);
        result&=TagTypeSelectionVerification(option3);
        result&=TagTypeSelectionVerification(option4);
        result&=TagTypeSelectionVerification(option5);
        result&=TagTypeSelectionVerification(option6);
        result&=TagTypeSelectionVerification(option7);
        result&=TagTypeSelectionVerification(option8);
        result&=TagTypeSelectionVerification(option9);
        result&=TagTypeSelectionVerification(option10);
        result&=TagTypeSelectionVerification(option11);
        return result;
    }

    @Override
    public boolean checkIfUserIsAbleToSelectAnyOfTheDropDownOptionsFromTagTypeAppField(String embedText,String oneOfTheOption){
        boolean result=false;
        selectEmbedButtonAndSwitchToNewWindow();
        fillEmbedCode(embedText);
        commonFunctions.clickElementIfDisplayed(doneButtonOnPopup);
        result=selectAnyTagType(oneOfTheOption);
        return result;
    }

    @Override
    public boolean checkIfDataIsGoingTillMasterForTheInputGivenForTagTypeAppField(String embedText, String name, String oneOfTheOption) {
        selectEmbedButtonAndSwitchToNewWindow();
        fillEmbedCode(embedText);
        commonFunctions.clickElementIfDisplayed(doneButtonOnPopup);
        commonFunctions.sendKeys(nameUnderMetaData,name,10,"date to title field");
        selectAnyTagType(oneOfTheOption);
        commonFunctions.clickElementIfDisplayed(publishButton,10);
        return commonFunctions.isElementDisplayed(publishMessage,10);
        //front end test complete and need to verify The data is going till master.
    }

    public boolean selectAnyTagType(String option){
        commonFunctions.sendKeys(tagTypeField,option,10,"option 1");
        boolean isPresent=commonFunctions.isClickableElementClicked(suggestionAppear,10,"checking element present or not");
        return isPresent;
    }

    public boolean TagTypeSelectionVerification(String option){
        commonFunctions.sendKeys(tagTypeField,option,10,"option 1");
        boolean isPresent=commonFunctions.isElementDisplayed(suggestionAppear,10,"checking element present or not");
        System.out.println("result is "+isPresent+"for "+option);
        commonFunctions.clearText(tagTypeField);
        return isPresent;
    }

    public boolean checkIfTheFieldTagTypeAppIsPresentInMetaDataForEmbed(String embedText,String tagFieldType) {
        selectEmbedButtonAndSwitchToNewWindow();
        fillEmbedCode(embedText);
        commonFunctions.clickElementIfDisplayed(doneButtonOnPopup);
        return commonFunctions.isElementDisplayed(tagTypeField);
    }

    @Override
    public boolean checkIfTagTypeAppFieldIsNotMandatory(String embedText, String name) {
        selectEmbedButtonAndSwitchToNewWindow();
        fillEmbedCode(embedText);
        commonFunctions.clickElementIfDisplayed(doneButtonOnPopup);
        commonFunctions.sendKeys(nameUnderMetaData,name,10,"name keys");
        commonFunctions.clickElementIfDisplayed(tagTypeField,10);
        commonFunctions.clickElementIfDisplayed(publishButton,10);
        return commonFunctions.isElementDisplayed(publishMessage,10);
    }

}
