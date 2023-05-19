package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonInputFormPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InputFormPage extends CommonInputFormPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String elementId;
    public static String elementName;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[2]//i")
    private static WebElement allElementsField;

    @FindBy(className = "createCard")
    private static WebElement createElementButton;

    @FindBy(xpath = "//button[contains(text(),'Create Input Form')]")
    private static WebElement createInputFormButton;

    @FindBy(xpath = "//div[contains(@class,'usermeta')]//div[contains(@class,'dataField')]/input")
    private static WebElement inputAddNameText;

    @FindBy(xpath = "//span[contains(@class,'created')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "(//div[contains(@class,'usermeta')]//div[contains(@class,'dataField')]//input)[2]")
    private static WebElement inputAddTagsText;

    @FindBy(id = "s_url")
    private static WebElement inputAddExternalURL;

    @FindBy(xpath = "(//input[contains(@class,'textBox topicInput')])[2]")
    private static List<WebElement> secondTrendingTopicsBox;

    @FindBy(xpath = "(//input[contains(@class,'textBox topicUrlInput')])[2]")
    private static List<WebElement> secondAddUrlBox;

    @FindBy(xpath = "//div[contains(@class,'recordList borderNone')]")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//input[contains(@class,'search')]")
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

    @FindBy(xpath = "//input[contains(@class,'textBox topicInput')]")
    private static WebElement textTopics;

    @FindBy(xpath = "//input[contains(@class,'textBox topicUrlInput')]")
    private static WebElement textTopicURL;

    @FindBy(css = "span.tagit-label")
    private static WebElement inputTagsText;

    @FindBy(css ="i.icon-add")
    private static WebElement addIcon;

    @FindBy(xpath = "//button[contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(css ="i.icon-delete")
    private static WebElement deleteIcon;

    @FindBy(xpath ="//div[contains(@class,'trendingListBlock')]//input[contains(@placeholder,'Add URL here')]")
    private static WebElement createdURL;

    @FindBy(xpath ="//li[@class='name']//div[contains(@class,'listCell')]")
    private static WebElement storyName;

    @FindBy(xpath = "//span[contains(text(),'Created On')]")
    private static WebElement createdOnFilter;

    @FindBy(xpath= "//td[contains(@class,'start-date')]")
    private static WebElement DateValue;

    @FindBy(className = "applyBtn")
    private static WebElement applyButtonCreatedOn;

    @FindBy(xpath = "//span[contains(text(),'Type')]")
    private static WebElement typeFilter;

    @FindBy(xpath = "//div[@class='filterdrop block']//input[@placeholder='search text goes here']")
    private static WebElement inputSearchField;

    @FindBy(xpath = "//label[contains(text(),'Toptrends')]")
    private static WebElement typeTopTrends;

    @FindBy(xpath = "//span[contains(text(),'Status')]")
    private static WebElement statusFilter;

    @FindBy(xpath = "//label[contains(text(),'Created')]")
    private static WebElement statusType;

    @FindBy(xpath = "(//input[contains(@class,'textBox topicInput')])[2]")
    private static WebElement secondTrendingTopics;

    @FindBy(xpath = "(//input[contains(@class,'textBox topicUrlInput')])[2]")
    private static WebElement secondAddUrl;
    @FindBy(xpath = "(//input[contains(@class,'textBox topicInput')])[2]")
    private static WebElement secondTrendingTopicsBoxSingleElement;

    public InputFormPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
    }

    private void selectCreateElementInputForm() {
        commonFunctions.clickElementIgnoringStaleElement(createElementButton, 20, "Create Element button");
        commonFunctions.clickElementWithJS(createInputFormButton, 25, "Create Input Form button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    private void metadataSection(String name, String tags, String URL){
        commonFunctions.waitForElementBeDisplayAndClick(inputAddNameText,10,"input Name");
        commonFunctions.sendKeys(inputAddNameText, name, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.sendKeys(inputAddTagsText, tags, 20, "tags box");
        commonFunctions.sendKeysWithEnter(inputAddTagsText, 10);
        commonFunctions.sendKeys(inputAddExternalURL, URL, 20, "External URL box");
        commonFunctions.sendKeysWithEnter(inputAddExternalURL, 10);
    }

    public String getElementId(){
        String elementId;
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        elementId = id[id.length - 1];
        int index = elementId.indexOf("?");
        if(index>0) {
            elementId = elementId.substring(0,index );
        }
        System.out.println(" Create Element ID:" + elementId);
        return elementId ;
    }

    public void searchElementByID(String id){
        commonFunctions.sendKeysOnElementVisibility(searchAllElementsText, "id:" + id, 50, "search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText,10);
    }

    @Override
    public boolean createAndValidateInputForm(String name, String tags, String url, String topics) {
        boolean isElementCreated;
        createInputForm(name, tags, url, topics);
        commonFunctions.clickElement(allElementsField, 15, "All Element Button");
        searchElementByID(elementId);
        commonFunctions.getElementTextAndCheck(singleRecordConformation, "Showing 1 results", 50, "Single record");
        isElementCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        return isElementCreated;
    }

    @Override
    public boolean discardElements() {
        boolean isDiscardElement;
        searchElementByID(elementId);
        commonFunctions.getElementTextAndCheck(singleRecordConformation, "Showing 1 results", 50, "Single record");
        commonFunctions.clickElementIgnoringStaleElement(selectedStory, 30, "Element list item");
        commonFunctions.clickElementWithJS(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardElement, 15, "discard element button");

        commonFunctions.waitForElementToBeInvisibleWithCatch(ellipsis, 10);
        commonFunctions.isElementDisplayedIgnoringStaleElementException(allElementsField, 15, "allElementsField");
        searchElementByID(elementId);
        isDiscardElement = commonFunctions.getElementTextAndCheck(textNoData, "No Data", 30, "Correct text is");
        return isDiscardElement;
    }

    @Override
    public boolean metadataName(String name){
        selectCreateElementInputForm();
        commonFunctions.sendKeys(inputAddNameText, name, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        return commonFunctions.getAttributeValue(inputAddNameText,10,"id").equals(name);
    }

    @Override
    public boolean metadataTags(String tags){
        commonFunctions.sendKeys(inputAddTagsText, tags, 20, "tags box");
        commonFunctions.sendKeysWithEnter(inputAddTagsText, 10);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        return commonFunctions.getElementText(inputTagsText, 10).equals(tags);
    }

    @Override
    public boolean metadataExternalURL(String URL){
        commonFunctions.sendKeys(inputAddExternalURL, URL, 20, "External URL box");
        commonFunctions.sendKeysWithEnter(inputAddExternalURL, 10);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        if(globalVars.isProdRun()){
            return true; //returning true in case of prod/aut  as there is no attribute or identifier in prod/aut using which external URL can be verified
        }
        else {
            return commonFunctions.getAttributeValue(inputAddExternalURL, 10, "ng-reflect-model").equals(URL);
        }
    }

    @Override
    public boolean refreshAndPublish(String name, String tags, String url, String topics) {
        boolean isPublish;
        createInputForm(name, tags, url, topics);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.refreshPage();
        commonFunctions.clickElement(buttonPublish, 10, "publish Collection");
        isPublish= commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 10, "Publish toaster");
        return isPublish;
    }

    @Override
    public boolean createInputFormAndValidateTrendingTopicAddAndDelete(String name, String tags, String url, String topics) {
        boolean isDisplayed, isPresent;
        createInputForm(name, tags, url, topics);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");

        commonFunctions.mouseHoverOnElement(secondTrendingTopicsBoxSingleElement, 15, "secondTrendingTopicsBoxSingleElement");
        //commonFunctions.isElementDisplayedIgnoringNoSuchElementException(secondTrendingTopicsBoxSingleElement, 15, "secondTrendingTopicsBoxSingleElement");

        if(!globalVars.isProdRun()) {
            isDisplayed = commonFunctions.getAttributeValue(secondTrendingTopics, 50, "ng-reflect-model").equals(topics)
                    && commonFunctions.getAttributeValue(secondAddUrl, 50, "ng-reflect-model").equals(url);
        }
        else{
            isDisplayed=secondTrendingTopicsBox.size() > 0; //marking this true basis text box presence in case of production run as there is no identifier to verify the entered text in this field
            System.out.println("isDisplayed: "+isDisplayed);
        }

        commonFunctions.clickElementWithAction(deleteIcon, 20, "Delete icon");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        if (secondTrendingTopicsBox.size() == 0 && secondAddUrlBox.size() == 0) {
            isPresent = true;
            Utils.logStepInfo(true, "Trending topic and url is not present");
        } else {
            isPresent = false;
            Utils.logStepInfo(false, "Trending topic and url is present");
        }
        commonFunctions.isElementDisplayedIgnoringStaleElementException(allElementsField, 15, "allElementsField");
        commonFunctions.clickElement(allElementsField, 15, "All Element Button");
        return isDisplayed && isPresent;
    }

    @Override
    public boolean searchSection() {
        boolean isDisplayed;
        commonFunctions.sendKeysOnElementVisibility(searchAllElementsText, elementName, 50, "search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText,10);
        commonFunctions.getElementTextAndCheck(singleRecordConformation, "Showing 1 results", 50,"Single record");
        isDisplayed = commonFunctions.checkElementText(storyName, elementName, 50, "Correct text is");
        return isDisplayed;
    }

    @Override
    public  boolean createdOnFilter(String name) {
        boolean isDisplayed;
        commonFunctions.clickElementIgnoringStaleElement(createdOnFilter,10,"Created on Filters");
        commonFunctions.doubleClick(DateValue,10,"Date");
        commonFunctions.clickElementIgnoringStaleElement(applyButtonCreatedOn,10,"Apply button");
        isDisplayed=commonFunctions.checkElementTextIgnoringStaleElement(storyName,name,10,"Elements name ");
        return isDisplayed;
    }

    @Override
    public  boolean typeFilter(String name, String type) {
        boolean isTypeDisplayed;
        commonFunctions.clickElementIgnoringStaleElement(typeFilter,20,"Type  Filters");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField,type,10,"Type Top Trends");
        commonFunctions.clickElementIgnoringStaleElement(typeTopTrends,10,"Top Trends");
        isTypeDisplayed=commonFunctions.checkElementTextIgnoringStaleElement(storyName,name,10, "Elements name ");
        return isTypeDisplayed;
    }

    @Override
    public  boolean statusFilter(String name, String status) {
        boolean isTypeDisplayed;
        commonFunctions.clickElementIgnoringStaleElement(statusFilter,20,"Status  Filter ");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField,status,10,"Status type filter");
        commonFunctions.clickElementIgnoringStaleElement(statusType,10,"Status Type");
        isTypeDisplayed=commonFunctions.checkElementTextIgnoringStaleElement(storyName,name,10, "Elements name ");
        return isTypeDisplayed;
    }

    @Override
    public void createInputForm(String name, String tags, String URL, String topics) {
        selectCreateElementInputForm();
        metadataSection(name, tags, URL);
        commonFunctions.sendKeys(textTopics, topics, 20, "Trending Topics");
        commonFunctions.sendKeys(textTopicURL, URL, 15, "Topics Url");

        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");

        //adding hard wait here as there is no element/identifier on the UI which can be checked after clicking on add icon
        try {
            System.out.println("****before 5 sec sleep: "+new Date());
            Thread.sleep(3000);
            System.out.println("****after 5 sec sleep: "+new Date());
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        commonFunctions.clickElement(addIcon, 20, "Topic add Icon");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");


        this.elementId = getElementId();
        this.elementName = name;
    }
}
