package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonInputFormPage;
import com.pages.BlankPaper.genericPages.CommonJsonEmbedPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class JsonEmbedPage extends CommonJsonEmbedPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonInputFormPage createInputFormPage;
    public static String jsonEmbedId;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[2]//i")
    private static WebElement allElementsField;

    @FindBy(className = "createCard")
    private static WebElement createElementButton;

    @FindBy(xpath = "//button[contains(text(),'Create Json Embed')]")
    private static WebElement createJsonEmbedButton;

    @FindBy(css = "input[placeholder='Add element name here…']")
    private static WebElement inputAddNameText;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(css = "input[placeholder='Add tag here..']")
    private static WebElement inputAddTagsText;


    @FindBy(xpath = "(//span[@class='tagit-label'])[1]")
    private static WebElement addedTagText;

    @FindBy(id = "s_url")
    private static WebElement inputAddExternalURL;

    @FindBy(css = "input[placeholder='Add jsonSourceUrl here…']")
    private static WebElement inputAddJsonSourceUrl;

    @FindBy(css = "input[placeholder='Add SubType here.']")
    private static WebElement inputAddSubType;

    @FindBy(css = "textarea[placeholder='Enter for the Facebook, tweet, etc here…']")
    private static WebElement inputAddJson;

    @FindBy(xpath = "//button[contains(text(),'Done')]")
    private static WebElement addJsonDoneButton;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result')]")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//input[@placeholder='Search Elements here...']")
    private static WebElement searchAllElementsText;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//div[contains(@class,'secondary')]//span[@class='threedots']")
    private static WebElement ellipsis;

    @FindBy(xpath = "//button[contains(text(),'Discard Element')]")
    private static WebElement buttonDiscardElement;

    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;

    @FindBy(xpath = "//button[contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(css = "button.cancel")
    private static WebElement cancelButton;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Please enter either embed code or JSON Source Url')]")
    private static WebElement popupJsonCode;

    @FindBy(xpath = "//h3[contains(text(),'Add JSON')]")
    private static WebElement textAddJson;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Please enter a valid JSON')]")
    private static WebElement popupValidJsonCode;

    @FindBy(xpath = "//div[contains(@class,'dataField')]//p")
    private static WebElement JsonCodePage;

    @FindBy(xpath = "//div[contains(@class,'storyListing')]//*[contains(@class,'name')]")
    private static WebElement editedStoryHeadline;

    @FindBy(css = "span.editBtn")
    private static WebElement embedCodeEditIcon;

    @FindBy(xpath = "//label[contains(text(),'Embed Code')]")
    private static WebElement embedCode;
    @FindBy(xpath = "(//div[contains(@class,'autosuggestion')]//li/span)[1]")
    private static WebElement inputSubTypeActiveText;
    @FindBy(xpath = "//div[@class='snotifyToast__body']")
    private static WebElement jsonEmbedNameWarningPopup;

    @FindBy(xpath = "//input[@id='inputAddTagType']")
    private static WebElement tagTypeField;



    public JsonEmbedPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        createInputFormPage = CommonInputFormPage.getInstance();
    }


    private void clickOnCreateJsonEmbed() {
        commonFunctions.clickElementWithActions(createElementButton, 20, "Create Element button");
        commonFunctions.clickElementWithJS(createJsonEmbedButton, 25, "create Json Embed button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    private void metadataSection(String name, String tags, String externalURL, String jsonSourceURL, String subType) {
        commonFunctions.waitForElementBeDisplayAndClick(inputAddNameText, 10, "input Name");
        commonFunctions.sendKeys(inputAddNameText, name, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.waitForElementToBeInvisibleWithCatch(jsonEmbedNameWarningPopup, 10);
        commonFunctions.sendKeys(inputAddTagsText, tags, 20, "tags box");
        commonFunctions.sendKeysWithEnter(inputAddTagsText, 10);
        commonFunctions.sendKeys(inputAddExternalURL, externalURL, 20, "External URL box");
        commonFunctions.sendKeys(inputAddJsonSourceUrl, jsonSourceURL, 20, "json Source Url box");
        commonFunctions.clickElementIgnoringStaleElement(inputAddSubType, 10, "inputSubTypeActiveText");
//        commonFunctions.sendKeys(inputAddSubType, subType, 20, "sub type box");
//        commonFunctions.sendKeysWithEnter(inputAddSubType,10);
        commonFunctions.waitAndGetElementTextIgnoringStaleElement(inputSubTypeActiveText, 20, "sub-Section Active Text");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElementIgnoringStaleElement(inputSubTypeActiveText, 10, "inputSubTypeActiveText");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...",7, "wait for saving changes ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
    }

    @Override
    public boolean createJsonEmbed(String addJsonURL, String name, String tags, String externalURL, String jsonSourceURL, String subType) {
        boolean isElementCreated;
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonURL, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        metadataSection(name, tags, externalURL, jsonSourceURL, subType);
        String id = createInputFormPage.getElementId();
        jsonEmbedId=id;
        commonFunctions.clickElement(allElementsField, 15, "All Element Button");
        createInputFormPage.searchElementByID(id);
        commonFunctions.checkElementText(storyStatus, "CREATED", 10, "Correct text is");
        isElementCreated = commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 10, "Single record");
        return isElementCreated;
    }

    @Override
    public boolean publishJsonEmbed() {
        boolean isPublished;
        commonFunctions.clickElementIgnoringStaleElement(selectedStory, 25, "Element list item");
        commonFunctions.clickElement(buttonPublish, 30, "publish ");
        commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 20, "Publish toaster");
        String id = createInputFormPage.getElementId();
        commonFunctions.clickElement(allElementsField, 15, "All Element Button");
        createInputFormPage.searchElementByID(id);
        isPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isPublished;
    }

    @Override
    public boolean metadataName(String addJsonURL,String name){
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonURL, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        commonFunctions.sendKeys(inputAddNameText, name, 20, "Name box");

        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");

        //commonFunctions.waitForElementToBeInvisible(jsonEmbedNameWarningPopup, 15);
        commonFunctions.waitForElementToBeInvisibleWithCatch(jsonEmbedNameWarningPopup, 30);
        return commonFunctions.getAttributeValue(inputAddNameText,10,"id").equals(name);
    }

    @Override
    public boolean metadataJsonSourceURL(String jsonSourceURL) {
        commonFunctions.sendKeys(inputAddJsonSourceUrl, jsonSourceURL, 20, "jsonSource URL box");
        commonFunctions.sendKeysWithEnter(inputAddJsonSourceUrl, 10);
        if(globalVars.isProdRun()){
            return true; //returning true in case of prod/aut as there is no attribute or identifier in prod/aut using which external URL can be verified
        }
        else {
            return commonFunctions.getAttributeValue(inputAddJsonSourceUrl, 10, "ng-reflect-model").equals(jsonSourceURL);
        }
    }

    @Override
    public boolean metadataSubType(String subType, String domain) {
        boolean isStepTrue;
        if (true) {   //domain.equals(Constants.LIVE_MINT)
            commonFunctions.clickElementIgnoringStaleElement(inputAddSubType, 10, "inputSubTypeActiveText");
            commonFunctions.waitAndGetElementTextIgnoringStaleElement(inputSubTypeActiveText, 20, "sub-Section Active Text");
            commonFunctions.clickElementIgnoringStaleElement(inputSubTypeActiveText, 10, "inputSubTypeActiveText");

            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");

            if(globalVars.isProdRun()){
                isStepTrue= true; //returning true in case of prod/aut as there is no attribute or identifier in prod/aut using which entered URL can be verified
            }
            else {
                isStepTrue= commonFunctions.getAttributeValue(inputAddSubType, 10, "ng-reflect-model").equals(subType);
            }
            discardJsonEmbed();

        }
        else {
            Utils.logStepInfo(true, "input subType is not applicable for this tenant");
            isStepTrue= true;
        }

        return isStepTrue;
    }

    @Override
    public boolean cancelButton(){
        boolean isDisplayed;
        clickOnCreateJsonEmbed();
        isDisplayed = commonFunctions.getElementTextAndCheck(cancelButton,"Cancel",20,"cancel button");
        return  isDisplayed;
    }

    private boolean refreshAndVerifyMetadataSectionInput(String name, String tags, String URL, String jsonSourceURL, String subType, String domain) {
        boolean isShowing;
        commonFunctions.refreshPage();
        isShowing = commonFunctions.getAttributeValue(inputAddNameText,20,"ng-reflect-model").equalsIgnoreCase(name);
        isShowing &= commonFunctions.getElementText(addedTagText, 30).equals(tags);
        commonFunctions.getAttributeValue(inputAddExternalURL, 30, "ng-reflect-model").equals(URL);
        commonFunctions.getAttributeValue(inputAddJsonSourceUrl, 20, "ng-reflect-model").equals(jsonSourceURL);
        if (domain.equals(Constants.LIVE_MINT)) {
            isShowing = commonFunctions.getAttributeValue(inputAddSubType, 30, "ng-reflect-model").equals(subType);
        }
        return isShowing;
    }

    @Override
    public boolean createPublishEditRefreshPage(String addJsonURL,String name,String editName, String tags, String externalURL, String jsonSourceURL,String subType,String domain){
        boolean isDisplayed;
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonURL, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        metadataSection(name,tags,externalURL,jsonSourceURL,subType);
        refreshAndVerifyMetadataSectionInput(name,tags,externalURL,jsonSourceURL,subType,domain);
        commonFunctions.clickElement(buttonPublish, 30, "publish ");
        commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 30, "Publish toaster");
        refreshAndVerifyMetadataSectionInput(name,tags,externalURL,jsonSourceURL,subType,domain);
        commonFunctions.sendKeys(inputAddNameText, editName, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        isDisplayed = refreshAndVerifyMetadataSectionInput(editName,tags,externalURL,jsonSourceURL,subType,domain);
        return isDisplayed;
    }

    @Override
    public boolean jsonCodeValidation(String addJsonURL) {
        boolean isDisplayed;
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonURL, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        commonFunctions.isElementDisplayedWithoutTryCatch(popupValidJsonCode,30,"valid JSON toaster massage");
        commonFunctions.refreshPage();
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(popupJsonCode, 30, "json code toaster");
        return isDisplayed;
    }

    @Override
    public boolean jsonEmbedCodePage(String addJsonURL) {
        boolean isDisplayed;
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonURL, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        isDisplayed= commonFunctions.getElementTextAndCheck(JsonCodePage, addJsonURL,30, "Embed code page text ");
        return isDisplayed;
    }

    @Override
    public boolean editJsonEmbed(String editName){
        boolean isDisplayed;
        commonFunctions.clickElementIgnoringStaleElement(selectedStory, 25, "Element list item");
        commonFunctions.sendKeys(inputAddNameText, editName, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        String id = createInputFormPage.getElementId();
        commonFunctions.clickElement(allElementsField, 15, "All Element Button");
        createInputFormPage.searchElementByID(id);
        isDisplayed = commonFunctions.getElementTextAndCheck(editedStoryHeadline,editName,10,"Edited Story Name ");
        return  isDisplayed;
    }

    @Override
    public boolean editableExistingJson(String addJsonURL,String editAddJsonURL){
        boolean isDisplayed;
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonURL, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        commonFunctions.moveToElementWithActions(embedCode,30,"embed code");
        commonFunctions.clickElementIfDisplayed(embedCodeEditIcon,20,"edit icon click");
        commonFunctions.sendKeys(inputAddJson, editAddJsonURL, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        isDisplayed= commonFunctions.getElementTextAndCheck(JsonCodePage, editAddJsonURL,30, "Embed code page text ");
        return isDisplayed;

    }

    @Override
    public boolean checkIfTheFieldTagTypeAppIsPresentInMetaDataForJsonEmbed(String addJsonData, String name, String jsonSourceUrl, String tagFieldCheck) {
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonData, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        return commonFunctions.isElementDisplayed(tagTypeField);
    }

    @Override
    public boolean checkIfeUserIsAbleToCreateJsonEmbed(String addJsonData, String name, String jsonSourceUrl, String subtype) {
        clickOnCreateJsonEmbed();
        commonFunctions.sendKeys(inputAddJson, addJsonData, 30, "add Json URL");
        commonFunctions.clickElement(addJsonDoneButton, 20, "Add Json Done button");
        commonFunctions.sendKeys(inputAddNameText,name,10,"name field");
        commonFunctions.sendKeys(inputAddJsonSourceUrl,jsonSourceUrl,10,"source url");
        commonFunctions.sendKeys(inputAddSubType,subtype,10,"subtype field");
        commonFunctions.sendKeysWithEnter(inputAddSubType,10);
        commonFunctions.clickElement(buttonPublish, 30, "publish ");
        commonFunctions.hardWait(1000);
        return commonFunctions.isElementDisplayedWithExceptionHandling(popupPublishButton, 20, "Publish toaster");

    }

    public String setJsonEmbedId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        String elementId = id[id.length - 1];
        System.out.println("JSON Embed ID:" + elementId);
        jsonEmbedId=elementId;
        return elementId;
    }

    public boolean discardJsonEmbed() {
        boolean isDiscardElement;
        setJsonEmbedId();
        commonFunctions.clickElementWithJS(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardElement, 15, "discard element button");
        isDiscardElement = commonFunctions.isElementDisplayedWithoutTryCatch(searchAllElementsText, 30, "searchAllElementsText");
        return isDiscardElement;
    }
}

