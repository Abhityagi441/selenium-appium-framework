package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonCollectionPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CollectionPage extends CommonCollectionPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String collectionId;
    private static CommonDashboardPage dashboardPage;


    @FindBy(xpath = "//button[text()='Create Element']")
    private static WebElement createElementButton;

    @FindBy(xpath = "//button[text()='Create Collection']")
    private static WebElement createCollectionButton;

    @FindBy(id = "createEmbedButton")
    private static WebElement createEmbedButton;

    @FindBy(id = "defaultOpen")
    private static WebElement allStoriesLabelHomePage;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[2]//i")    //span[text()='All Elements']
    private static WebElement allElementsField;

    @FindBy(xpath = "//span[contains(text(),'Byline')]")
    private static WebElement buttonByLine;

    @FindBy(xpath = "//span[contains(text(),'Domain')]")
    private static WebElement buttonDomain;

    @FindBy(xpath = "//span[contains(text(),'Created On')]")
    private static WebElement buttonCreatedOn;

    @FindBy(xpath = "//span[contains(text(),'Type')]")
    private static WebElement buttonType;

    @FindBy(xpath = "//span[contains(text(),'Section')]")
    private static WebElement buttonSection;

    @FindBy(xpath = "//span[contains(text(),'Created by')]")
    private static WebElement buttonCreatedBy;

    @FindBy(xpath = "//span[contains(text(),'Category')]")
    private static WebElement buttonCategory;

    @FindBy(xpath = "//label[contains(text(),'Arnab Sen')]")
    private static WebElement byLineFieldValue;

    @FindBy(xpath = "//li[@value='0']//div[1]//span")
    private static WebElement headlineField;

    @FindBy(css = "(//span[text()='QA-Auto'])[1]")
    private static WebElement statusField;

    @FindBy(xpath = "//div[@class='filterdrop block']//input[@placeholder='search text goes here']")
    private static WebElement inputSearchField;

    @FindBy(className = "applyBtn")
    private static WebElement applyButtonCreatedOn;

    @FindBy(xpath = "//ul[@id='byline']//li[1]")
    private static WebElement byLineValue;

    @FindBy(xpath = "//label[contains(text(),'Ht New')]")
    private static WebElement domainHtNew;

    @FindBy(xpath = "//label[contains(text(),'Live Mint')]")
    private static WebElement domainLiveMint;

    @FindBy(xpath = "//label[contains(text(),'Video')]//span")
    private static WebElement typeVideoValue;

    @FindBy(xpath = "//label[contains(text(),'Standard')]//span")
    private static WebElement typeStandardStory;

    @FindBy(xpath = "//ul[@id='section']//li//label[@class='checkblock']//span[@class='checkmark']")
    private static WebElement sectionValue;

    @FindBy(xpath = "//span[text()='more']")
    private static WebElement moreButtonField;

    @FindBy(xpath = "//ul[@id='flags']//span")
    private static WebElement categoryValue;

    @FindBy(css = "select[id='category']")
    private static WebElement dropdownBox;

    @FindBy(css = "option[value='story']")
    private static WebElement storyDropDown;

    @FindBy(css = "option[value='page']")
    private static WebElement pageDropDown;

    @FindBy(xpath = "//span[contains(text(),'Topics')]")
    private static WebElement topicsButton;

    @FindBy(xpath = "//span[contains(text(),'Location')]")
    private static WebElement locationButton;

    @FindBy(xpath = "//ul[@id='topics']//span")
    private static WebElement topicsValue;

    @FindBy(xpath = "//ul[@id='location']//span")
    private static WebElement locationValue;

    @FindBy(xpath = "//ul[@id='topics']//label")
    private static WebElement topicsValueDisplayed;

    @FindBy(xpath = "//ul[@id='location']//label")
    private static WebElement locationValueDisplayed;

    @FindBy(xpath = "//td[contains(@class,'start-date')]")
    private static WebElement DateValue;

    @FindBy(xpath = "//a[@href='/dash/workspace']")
    private static WebElement blankPaperLogo;

    @FindBy(css = "input[placeholder='Add element name here…']")
    private static WebElement inputAddNameText;

    @FindBy(id = "inputAddNameText")
    private static WebElement inputAddNameTextData;

    @FindBy(xpath = "//ul//li[@value='0']")
    private static WebElement elementSource;

    @FindBy(xpath = "//ul//li[@value='1']")
    private static WebElement elementSecondSource;

    @FindBy(xpath = "//div[@id='right']//li[@value='0']")
    private static WebElement elementSourceRightSide;

    @FindBy(xpath = "//div[@id='right']//li[@value='1']")
    private static WebElement elementTargetRightSide;

    @FindBy(xpath = "//div[@class='allLiveList']//div")
    private static WebElement elementTarget;

    @FindBy(xpath = "//div[contains(@class,'allLiveList')]//div[contains(@class,'heading pin')]//span[2]")
    // //span[@class='number' and contains(text(),'1')]
    private static WebElement elementDropped;

    @FindBy(xpath = "//div[@class='allcontentList']//li[@value='0']//div[@class='heading pin']//span")
    private static WebElement storyHeadline;

    @FindBy(xpath = "//div[contains(@class,'livePage')]//h4")
    private static WebElement createdCollectionName;

    @FindBy(className = "icon-delete")
    private static WebElement buttonDeleteStories;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(css = "input[placeholder='Add Section here.']")
    private static WebElement inputAddSectionText;

    @FindBy(css = "div.autosuggestion.block")  //div[@class='autosuggestion block']//li  //span[@class='name']
    private static WebElement inputAddSectionActiveText;

    @FindBy(css = "input[placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "//div[@class='autosuggestion block']//li")
    private static WebElement inputAddSubSectionActiveText;

    @FindBy(css = "input[placeholder='Search Elements here...']")
    private static WebElement searchAllElementsText;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result')]")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private static WebElement dashboard;

    @FindBy(id = "defaultOpen")
    private static WebElement createCollection;

    @FindBy(css = "input[placeholder='Add tag here..']")
    private static WebElement inputAddTagsText;

    @FindBy(css = "span.tagit-label")
    private static WebElement inputTagsText;

    @FindBy(id = "s_url")
    private static WebElement inputAddExternalURL;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

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

    @FindBy(xpath = "//div[contains(text(),'published successfully')]")
    private static WebElement popupPublishSectionButton;

    @FindBy(css = "div.head")
    private static WebElement textMetadata;

    @FindBy(xpath = "//li[1]//span[contains(text(),'story')]")
    private static WebElement typeStory;

    @FindBy(xpath = "//li[1]//label[contains(text(),'Photo')]")
    private static WebElement typeGallery;

    @FindBy(xpath = "//li[1]//span[text()='gallery']")
    private static WebElement typePhotoGallery;

    @FindBy(xpath = "//div[@id='right']//li[@value='1']//div[2]//li[3]")
    private static WebElement targetPhotoGallery;

    @FindBy(xpath = "//div[@id='right']//li[@value='0']//span[2]")
    private static WebElement storySourceDroppedHeadline;

    @FindBy(xpath = "//div[@id='right']//li[@value='1']//span[2]")
    private static WebElement storyTargetDroppedHeadline;

    @FindBy(xpath = "//div[contains(@class,'storyListing')]//*[contains(@class,'name')]")
    private static WebElement editedStoryHeadline;

    @FindBy(xpath = "//div[contains(@id,'right')]//div[contains(@class,'heading')]")
    private static WebElement subsectionAfterRefresh;

    @FindBy(xpath = "//ul//li[@value='0']//span[contains(@class,'viewEye')]")
    private static WebElement viewEye;

    @FindBy(xpath = "//li[contains(@class,'headline')]//div/p")
    private static WebElement storyPageStoryHeadline;

    @FindBy(xpath = "//button[contains(text(),' No ')]")
    private static WebElement ButtonNo;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[3]//i")
    private static WebElement pagesButton;

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'Section')]")
    private static WebElement pageSectionButton;

    @FindBy(css = "input[placeholder='Add  name.']")
    private static WebElement pageSectionNameText;

    @FindBy(css = "input[placeholder='Enter Alias here']")
    private static WebElement pageSectionAliasText;

    @FindBy(id = "pageSectionCreateButton")
    private static WebElement pageSectionCreateButton;

    @FindBy(css = "input[placeholder='Search Stories & Elements...']")
    private static WebElement searchStoryCollectionPage;

    @FindBy(xpath = "//li[contains(@type,'SECTION')]")
    private static WebElement elementPageSource;

    @FindBy(id = "defaultOpen")
    private static WebElement createdPageSourceSectionName;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//span[text()='All Elements']")
    private static WebElement allElementsText;

    @FindBy(css = "input[placeholder='Add Byline here..']")
    private static WebElement sectionByLine;

    @FindBy(css = "input[placeholder='Add page name here…']")
    private static WebElement sectionNameField;

    @FindBy(xpath = "//div[contains(@class,'heading pin')]//span")
    private static WebElement sectionHeadlineNamePage;
    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;
    @FindBy(xpath = "//span[contains(@class,'exact')]")
    private static WebElement exactAllStoriesButton;
    @FindBy(xpath = "//li[@class='author']//div[@class='listCell']")
    private static WebElement bylineNameDashboard;

    @FindBy(xpath = "(//div[contains(@class,'text-card')])[3]/div[contains(@class,'settingTemp')]//i[contains(@class,'icon-pickup')]")
    private static WebElement pageEditIcon;

    @FindBy(xpath = "//input[contains(@class,'search-components')]")
    private static WebElement searchBoxSelectCollection;

    private static String COLLECTION_NAME= "//li[@value='0']//div[@class='heading pin']//span[contains(text(),'%s')]";

    @FindBy(xpath = "//li[@value='0']/div[@class='heading pin']/span")
    private static WebElement createdCollectionElementSource;

    @FindBy(xpath = "//div[contains(@class,'container relative')]")
    private static WebElement createdCollectionTargetSource;

    @FindBy(xpath = "//button[@class='save blue']")
    private static WebElement createdCollectionSaveButton;

    private static String afterSearchingFirstStoriesTextHeadline = "//li[@value='0']//div[@class='heading pin']//span[contains(text(),'%s')]";

    private static String secondStoriesAfterDropped = "//div[@class='allLiveList']//div[contains(@class,'heading pin')]//span[contains(text(),'%s')]";
    private static String afterSearchingStoriesTextHeadline = "//div[contains(@class,'allcontentList')]//li[@value='0']//div[@class='heading pin']//span[contains(text(),'%s')]";
    private static String afterDroppedCollectionTextName = "//div[contains(@class,'container relative')]//span[text()='%s']";
    private static String deleteStoryIcon = "//div[@class='allLiveList']//li[contains(.,'%s')]//div[@class='status']//span[@class='deleteHeadline']";

    public static String secondStoryAfterDropped = "//div[@class='allLiveList']//div[contains(@class,'heading pin')]//span[contains(text(),'%s')]";

    @FindBy(xpath = "//div[contains(@class,'allcontentList')]//li[@value='0']")
    private static WebElement elementSource1;

    @FindBy(xpath = "(//div[@class='allLiveList']//li)[1]")
    private static WebElement elementTarget1;

    @FindBy(xpath = "//div[contains(@class,'snotifyToast__buttons')]/button[contains(text(),'Yes')]")
    private static WebElement popupYesForLockedStoryOnPage;

    @FindBy(xpath = "//div[@class='allLiveList']//div[contains(@class,'status')]//span/i[contains(@class,'icon-delete')]")
    private static WebElement deleteButtonFirstStory;

    @FindBy(xpath = "(//div[contains(@class,'text-card')])[3]//span/i[contains(@class,'icon-delete')]")
    private static List<WebElement> deleteButtonOnPages;

    @FindBy(id = "createElementButton")
    private static WebElement elementButton;

    @FindBy(id = "createCollectionButton")
    private static WebElement collectionButton;

    @FindBy(id = "inputAddNameText")
    private static WebElement addNameText;

    @FindBy(id = "buttonPublish")
    private static WebElement publishButton;

    @FindBy(xpath = "//*[contains(text(), 'published successfully')]")
    private static WebElement successMessage;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//div[@class='searchtxt']/input" )
    private static WebElement searchText;

    @FindBy(xpath = "//ul[@class='listingul active']/a/li" )
    private static List<WebElement> searchCollection;

    @FindBy(xpath = "//label[contains(text(), 'Collection')]/../div/input" )
    private static WebElement collectionText;

    @FindBy(xpath = "//span[@class='name']" )
    private static List<WebElement> listOfValue;

    @FindBy(xpath = "(//label[@class='switch']/span[@class='slider round'])[1]")
    private static WebElement appToggleSwitche;

    @FindBy(xpath = "(//label[@class='switch']/span[@class='slider round'])[2]")
    private static WebElement ampToggleSwitche;

    @FindBy(xpath = "//div[@id='right']/li[1]")
    private static WebElement droppedStoryElement;

    @FindBy(xpath ="//ul[@id='myTags']/li[1]")
    private static WebElement collectionTag;

    @FindBy(xpath = "//textarea[1]")
    private static WebElement embedCodeForVidAndTweets;

    @FindBy(xpath = "//textarea[2]")
    private static WebElement embedCodeForDarkMode;

    @FindBy(xpath = "//button[@id='addJsonDoneButton']")
    private static WebElement embedCodeDoneButton;


    @FindBy(id = "createInputFormButton")
    private static WebElement createInputFormButton;


    @FindBy(id = "createChartButton")
    private static WebElement createChartButton;


    @FindBy(id = "createTableButton")
    private static WebElement createTableButton;

    @FindBy(id = "textTopics")
    private static WebElement inputAddTopicName;


    @FindBy(id = "textTopicURL")
    private static WebElement inputAddTopicUrl;


    @FindBy(id = "addIcon")
    private static WebElement addInputFormTopic;

    @FindBy(xpath = "//div[contains(@class,'ck-dropdown')]")
    private static WebElement tableCreationButton;


    //we can use any div between div[1] to div[100] to select cells
    @FindBy(xpath = "//div[contains(@class,'dropdown')]//div[45]")
    private static WebElement clickOnCell;

    @FindBy(xpath = "//button[contains(@class,'add')]")
    private static WebElement buttonDone;


    private static String pagesCollectionDeleteButton = "(//div[contains(@class,'text-card')])[3]/div[contains(text(),'%s')]//span/i[contains(@class,'icon-delete')]";

    public CollectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    private void selectCreateCollection() {
        commonFunctions.clickElement(createElementButton, 20, "Create Element button");
        commonFunctions.clickElementWithJS(createCollectionButton, 25, "Create Collection button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    private void selectCollectionType(WebElement collectionType) {
        commonFunctions.clickElement(createElementButton, 10, "Create Element button");
        commonFunctions.clickElementWithJS(collectionType, 10, "Create Collection button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    @Override
    public boolean createElementButton() {
        boolean isElementDisplay;
        commonFunctions.clickElementIfDisplayed(allElementsField, 10, "All Elements Label");
        selectCreateCollection();
        isElementDisplay = commonFunctions.isElementDisplayedAndPresent(createCollection, 10, "Create a Collection");
        return isElementDisplay;
    }

    @Override
    public boolean byLineFilter(String byline, String headline) {
        boolean isHeadlineDisplayed;
        commonFunctions.clickElementWithJS(buttonByLine, 10, "ByLine field");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField, byline, 10, "byline input Label");
        commonFunctions.getElementText(byLineValue, byline, 10);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(byLineValue, 10, "byline value");
        commonFunctions.clickElementWithJS(buttonByLine, 10, "ByLine field");

        if (globalVars.isProdRun()) {
            String filterHeadline = commonFunctions.getElementText(headlineField, 20);
            dashboardPage.clickOnDashboard();
            commonFunctions.sendKeysOnElementVisibility(searchAllStoriesText, filterHeadline, 10, "search box");
            commonFunctions.sendKeysWithEnter(searchAllStoriesText, 10);
            commonFunctions.clickElementIgnoringStaleElement(exactAllStoriesButton, 15, "exact icon button");
            isHeadlineDisplayed = commonFunctions.getElementText(bylineNameDashboard, 15).equalsIgnoreCase(byline);
            dashboardPage.clearSearch();

        } else {
            isHeadlineDisplayed = commonFunctions.waitAndGetElementTextAndCheck(headlineField, headline, 10, "ByLine Filter Headline");
        }
        return isHeadlineDisplayed;
    }

    @Override
    public boolean domainFilter(String headline, String domain) {
        boolean isDisplayed;
        if (commonFunctions.isElementDisplayedAndPresent(buttonDomain, 6, "Section Box")) {
            commonFunctions.clickElementWithJS(buttonDomain, "Domain field", 10);
            if(domain.equalsIgnoreCase("HT NEW"))
            {
                commonFunctions.clickElementIfDisplayed(domainHtNew, 10);
            }
            else {
                commonFunctions.clickElementIfDisplayed(domainLiveMint, 30);
            }
            isDisplayed = commonFunctions.waitAndGetElementTextAndCheck(headlineField, headline, 10, "Domain Headline ");
        } else {
            isDisplayed = true;
            Utils.logStepInfo(true, " Domain not available for property: " + domain);
        }
        return isDisplayed;

    }

    @Override
    public boolean createdOnFilter(String headline) {
        boolean isDisplayed;
        commonFunctions.clickElementIfDisplayed(buttonCreatedOn, 10, "Created on");
        commonFunctions.doubleClick(DateValue, 10, "Date");
        commonFunctions.clickElementIgnoringStaleElement(applyButtonCreatedOn, 10, "Apply button");
        commonFunctions.clickElementIfDisplayed(buttonCreatedOn, 10, "Created on");
        isDisplayed = commonFunctions.waitAndGetElementTextAndCheck(headlineField, headline, 10, "Created On Headline ");
        return isDisplayed;
    }

    @Override
    public boolean typeFilter(String headline, String type) {
        boolean isTypeDisplayed;
        commonFunctions.isElementDisplayedAndPresent(buttonType,20,"Type  field");
        commonFunctions.clickElementIgnoringStaleElement(buttonType,20,"Type  field");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField,type,10,"Type Video Lable");
        commonFunctions.clickElementIgnoringStaleElement(typeStandardStory,10,"Type Standard select");
        commonFunctions.clickElementIgnoringStaleElement(buttonType,20,"Type  field");
        isTypeDisplayed=commonFunctions.waitAndGetElementTextAndCheck(headlineField,headline,10, "Type Headline ");
        commonFunctions.clickElementWithJS(moreButtonField,10,"More Button");

        return isTypeDisplayed;
    }

    @Override
    public  boolean typeFilterForCollection(String headline, String type) {
        boolean isTypeDisplayed;
        searchElementByID(collectionId);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        commonFunctions.isElementDisplayedAndPresent(buttonType,20,"Type  field");
        commonFunctions.clickElementIgnoringStaleElement(buttonType,20,"Type  field");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField,type,10,"Type Video Lable");
        commonFunctions.clickElementIgnoringStaleElement(typeStandardStory,10,"Type Standard select");
        commonFunctions.clickElementIgnoringStaleElement(buttonType,20,"Type  field");
        isTypeDisplayed=commonFunctions.waitAndGetElementTextAndCheck(headlineField,headline,20, "Type Headline ");
        commonFunctions.clickElementWithJS(moreButtonField,10,"More Button");
        return isTypeDisplayed;
    }

    @Override
    public  boolean sectionFilter(String headline, String section) {
        boolean isSectionDisplayed;
        commonFunctions.clickElementWithJS(buttonSection, 10, "Section  field");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField, section, 10, "Section Lable");
        commonFunctions.clickElementIfDisplayed(sectionValue, 10);
        isSectionDisplayed = commonFunctions.checkElementText(headlineField, headline, 10, "Section Headline ");
        return isSectionDisplayed;
    }

    @Override
    public boolean categoryFilter(String headline, String category) {
        boolean isCategoryDisplayed;
        commonFunctions.clickElementWithJS(buttonCategory, 10, "Category  field");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField, category, 10, "Category Lable");
        commonFunctions.clickElementIgnoringStaleElement(categoryValue, 10, "category label None");
        isCategoryDisplayed = commonFunctions.checkElementTextIgnoringStaleElement(headlineField, headline, 10, "Category Headline ");
        return isCategoryDisplayed;
    }

    @Override
    public boolean topicsFilter(String headline, String topic, String domain) {
        boolean isTopicsDisplayed;
        if ((domain.equals(Constants.HT_NEW))) {
            commonFunctions.clickElementWithJS(topicsButton, 10, "Topics  field");
            commonFunctions.sendKeysOnElementVisibility(inputSearchField, topic, 10, "Toipics Lable");
            commonFunctions.checkElementText(topicsValueDisplayed, topic, 10, "Topics Value Displayed");
            commonFunctions.clickElementIfDisplayed(topicsValue, 10);
            isTopicsDisplayed = commonFunctions.waitAndGetElementTextAndCheck(headlineField, headline, 10, "Topics Headline ");
        } else {
            isTopicsDisplayed = true;
            Utils.logStepInfo(true, " Topics not available for property " + domain);
        }
        return isTopicsDisplayed;
    }

    @Override
    public boolean locationFilter(String headline, String location, String domain) {
        boolean isLocationDisplayed;
        if ((domain.equals(Constants.SMART_24))) {
            commonFunctions.clickElementWithJS(locationButton, 10, "Location  field");
            commonFunctions.sendKeysOnElementVisibility(inputSearchField, location, 10, "Location Label");
            commonFunctions.clickElementIfDisplayed(locationValue, 10);
            isLocationDisplayed = commonFunctions.waitAndGetElementTextAndCheck(headlineField, headline, 10, "Topics Headline ");
        } else {
            isLocationDisplayed = true;
            Utils.logStepInfo(true, " Location not available for property " + domain);
        }
        return isLocationDisplayed;
    }

    @Override
    public boolean dropDown(String story, String page) {
        selectCreateCollection();
        commonFunctions.clickElementIfDisplayed(dropdownBox, 10, "Story And Page dropdown");
        commonFunctions.checkElementText(storyDropDown, story, 10, "Story");
        commonFunctions.checkElementText(pageDropDown, page, 10, "Page");
        return true;
    }

    @Override
    public boolean dragAndDropStories() {
        boolean isDragAndDropVerify;
//        commonFunctions.clickElementIfDisplayed(allElementsField, 10, "All Elements Label");
//        selectCreateCollection();
//        inputName(name);
//        inputTags(tags);
//        inputExternalURL(URL);
//        inputSection(section);
//        inputSubSection(subsection);
//        commonFunctions.getElementTextAndCheck(createdCollectionName,name,10,"Created Metadata Section Name");
        searchElementByID(collectionId);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        selectStoryFromDropDownOnCollectionPage();
        commonFunctions.dragAndDrop(elementSource, elementTarget, 30, " Drag And Drop Story ");
        String headline = commonFunctions.getElementText(storyHeadline, 30);
        isDragAndDropVerify = commonFunctions.getElementTextAndCheck(elementDropped, headline, 30, "Drag And Drop Story Headline ");
        return isDragAndDropVerify;
    }

    private void inputName(String name) {
        commonFunctions.waitForElementBeDisplayAndClick(inputAddNameText, 30, "input Name");
        commonFunctions.sendKeys(inputAddNameText, name, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
    }

    private void inputNameTextField(String name) {
        commonFunctions.waitForElementBeDisplayAndClick(inputAddNameTextData, 10, "input Name");
        commonFunctions.sendKeys(inputAddNameTextData, name, 10, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
    }

    @Override
    public boolean deleteStoryFromCollection() {
        boolean isElementTextDeleted;
        //dragAndDropStories(name, tags, URL, section, subsection);
        commonFunctions.clickElement(buttonDeleteStories, 30, "delete Stories");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "text is");
        isElementTextDeleted = commonFunctions.getElementTextAndCheck(elementTarget, "", 20, "Drag and Drop Stories text deletion");
        return isElementTextDeleted;
    }

    private void inputTags(String tags) {
        commonFunctions.sendKeys(inputAddTagsText, tags, 20, "tags box");
        commonFunctions.sendKeysWithEnter(inputAddTagsText, 10);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
    }


    private void inputExternalURL(String URL) {
        commonFunctions.sendKeys(inputAddExternalURL, URL, 20, "externalURL box");
        commonFunctions.sendKeysWithEnter(inputAddExternalURL, 10);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
    }

    private void inputSection(String section) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddSectionText, 10, "section box")) {
            commonFunctions.sendKeys(inputAddSectionText, section, 20, "section box");
            commonFunctions.waitForElementBeDisplayAndClick(inputAddSectionActiveText, 20, "Section Active Text");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        }
    }

    private void inputSubSection(String subsection) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddSubSectionText, 5, "subsection box")) {
            commonFunctions.sendKeys(inputAddSubSectionText, subsection, 20, "sub-section box");
            commonFunctions.waitForElementBeDisplayAndClick(inputAddSubSectionActiveText, 20, "SubSection Active Text");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        }
    }

    @Override
    public boolean createCollection(String name, String tags, String URL, String section, String subsection) {
        boolean collectionCreationFlag;
        inputName(name);
        inputTags(tags);
        inputExternalURL(URL);
        inputSection(section);
        inputSubSection(subsection);
        getCollectionId();
        collectionCreationFlag = commonFunctions.getElementTextAndCheck(createdCollectionName, name, 10, "Created Metadata Section Name");
        commonFunctions.clickElement(allElementsField, 30, "All Element Button");
        return collectionCreationFlag;
    }

    @Override
    public boolean createCollectionStatus(String name, String tags, String URL, String section, String subsection) {
        boolean isCollectionCreated;
        selectCreateCollection();
        createCollection(name, tags, URL, section, subsection);
        searchElementByID(collectionId);
        isCollectionCreated = commonFunctions.checkElementText(storyStatus, "CREATED", 30, "Correct text is");
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        return isCollectionCreated;
    }

    private void searchElementByID(String id) {
        commonFunctions.sendKeysOnElementVisibility(searchAllElementsText, "id:" + id, 30, "search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText, 10);
    }

    public void getCollectionId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        collectionId = id[id.length - 1];
        System.out.println("COLLECTION ID:" + collectionId);
    }

//    @Override
//    public boolean storiesDashboard() {
//        boolean isDashboardDisplay;
//        isDashboardDisplay = commonFunctions.clickElementIfDisplayed(blankPaperLogo, 10, "Dashboard Label");
//        return isDashboardDisplay;
//    }

    @Override
    public boolean discardCollection() {
        boolean isDiscardElement;
        getCollectionId();
        commonFunctions.clickElementWithJS(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardElement, 15, "discard element button");
        isDiscardElement = commonFunctions.isElementDisplayed(searchAllElementsText, 10);
        return isDiscardElement;
    }

    @Override
    public boolean publishCreateCollection() {
        boolean isPublished;
        commonFunctions.clickElementIgnoringStaleElement(selectedStory, 25, "Element list item");
        commonFunctions.clickElement(buttonPublish, 20, "publish Collection");
        commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 20, "Publish toaster");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        commonFunctions.clickElement(allElementsField, 10);
        searchElementByID(collectionId);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        isPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isPublished;
    }

    private void metadata(String name, String tags, String URL, String section, String subsection) {
        inputName(name);
        inputTags(tags);
        inputExternalURL(URL);
        inputSection(section);
        inputSubSection(subsection);
    }

    @Override
    public boolean metadataName(String name) {
        selectCreateCollection();
        commonFunctions.waitForElementBeDisplayAndClick(inputAddNameText, 10, "input Name");
        commonFunctions.sendKeys(inputAddNameText, name, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        getCollectionId();
        return commonFunctions.getAttributeValue(inputAddNameText, 10, "id").equals(name);
    }

    @Override
    public boolean metadataTags(String tags) {
        commonFunctions.sendKeys(inputAddTagsText, tags, 20, "tags box");
        commonFunctions.sendKeysWithEnter(inputAddTagsText, 10);
        return commonFunctions.getElementText(inputTagsText, 10).equals(tags);
    }

    @Override
    public boolean metadataExternalURL(String URL) {
        commonFunctions.sendKeys(inputAddExternalURL, URL, 20, "External URL box");
        commonFunctions.sendKeysWithEnter(inputAddExternalURL, 10);
        if (globalVars.isProdRun()) {
            return true; //returning true in case of prod/aut as there is no attribute or identifier in prod/aut  using which external URL can be verified
        } else {
            return commonFunctions.getAttributeValue(inputAddExternalURL, 10, "ng-reflect-model").equals(URL);
        }
    }

    @Override
    public boolean metadataSection(String section, String domain) {
        boolean isDisplayed;
        if (commonFunctions.isElementDisplayedAndPresent(inputAddSectionText, 5, "Section Box")) {
            commonFunctions.sendKeyBoolean(inputAddSectionText, section, 20, "section box");
            commonFunctions.clickElementIfDisplayed(inputAddSectionActiveText, 10, "Section Active Text");
            isDisplayed = commonFunctions.getAttributeValueWithExplicitWait(inputAddSectionText, 10, "ng-reflect-model").equals(section);
        } else {
            isDisplayed = true;
            Utils.logStepInfo(true, " Section not available for property: " + domain);
        }
        return isDisplayed;
    }

    private boolean metadataSubsectionRefresh(String subsection, String domain) {
        boolean isDisplayed;
        if (commonFunctions.isElementDisplayedAndPresent(subsectionAfterRefresh, 5, "Sub-Section Field after refresh Page ")) {
            isDisplayed = commonFunctions.getElementText(subsectionAfterRefresh, 10).equals(subsection);
        } else {
            isDisplayed = true;
            Utils.logStepInfo(true, " Sub-Section not available for property: " + domain);
        }
        return isDisplayed;
    }

    @Override
    public boolean metadataSubsection(String subsection, String domain) {
        boolean isDisplayed;
        if (commonFunctions.isElementDisplayedAndPresent(inputAddSubSectionText, 6, "Sub-section box")) {
            commonFunctions.sendKeys(inputAddSubSectionText, subsection, 20, "sub-section box");
            commonFunctions.clickElementWithJS(inputAddSubSectionActiveText, 10, "SubSection Active Text");
            isDisplayed = commonFunctions.getAttributeValueWithExplicitWait(inputAddSectionText, 10, "ng-reflect-model").equals(subsection);
        } else {
            isDisplayed = true;
            Utils.logStepInfo(true, " Sub-section not available for property: " + domain);
        }
        return isDisplayed;
    }

    @Override
    public boolean storiesUpAndDownPosition(String name, String tags, String URL, String section, String subsection) {
        boolean isDisplayed;
        createElementButton();
//        dashboardPage.clickOnAllElement();
        metadata(name, tags, URL, section, subsection);
        commonFunctions.dragAndDrop(elementSource, elementTarget, 30, " Drag And Drop Story ");
        commonFunctions.dragAndDrop(elementSecondSource, elementTarget, 30, " Drag And Drop 2nd Story ");
        String storyHeadline = commonFunctions.getElementText(storySourceDroppedHeadline, 30);
        commonFunctions.dragAndDrop(elementSourceRightSide, elementTarget, 30, " Drag And Drop  Right Side ");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        isDisplayed = commonFunctions.getElementTextAndCheck(storyTargetDroppedHeadline, storyHeadline, 50, "Headline ");
        return isDisplayed;
    }

    @Override
    public boolean storiesUpAndDownPositionOnPages(String headline, String headline1, String collectionName) {
        boolean isDisplayed;
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnAllElement();
        dashboardPage.searchElementByID(collectionId);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        commonFunctions.clickElementIfDisplayed(dropdownBox, 20, "Story And Page dropdown");
        commonFunctions.clickElementIfDisplayed(storyDropDown, 20, "storyDropDown");
        commonFunctions.isElementDisplayedAndPresent(deleteButtonFirstStory, 20, "delete button");
        commonFunctions.isElementDisplayedAndPresent(searchBoxSelectCollection, 30, "search box");
        String storyHeadline = commonFunctions.getElementText(storySourceDroppedHeadline, 30);
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.dragAndDrop(elementSourceRightSide, elementTarget, 30, " Drag And Drop  Right Side ");
        isDisplayed = commonFunctions.getElementTextAndCheck(storyTargetDroppedHeadline, storyHeadline, 50, "Headline ");
        commonFunctions.clickElement(buttonPublish, 20, "publish Collection");
        isDisplayed &= commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 20, "Publish toaster");
        return isDisplayed;
    }


    @Override
    public boolean editStatus(String editName) {
        boolean isDisplayed;
        commonFunctions.clickElementIgnoringStaleElement(selectedStory, 30, "Element list item");
        commonFunctions.sendKeys(inputAddNameText, editName, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.clickElement(allElementsField, 30);
        searchElementByID(collectionId);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        isDisplayed = commonFunctions.getElementTextAndCheck(editedStoryHeadline, editName, 50, "Edited Story Name ");
        return isDisplayed;
    }

    private boolean refreshMetadataSection(String name, String tags, String URL, String subsection, String domain) {
        boolean isDisplayed;
        commonFunctions.refreshPage();
        isDisplayed = commonFunctions.getAttributeValue(inputAddNameText, 30, "id").equals(name);
        isDisplayed &= commonFunctions.getElementText(inputTagsText, 30).equals(tags);
        //TODO: in case of aut env as there is no attribute or identifier in aut env using which external URL can be verified
//        isDisplayed &= commonFunctions.getAttributeValue(inputAddExternalURL, 30, "ng-reflect-model").equals(URL);
        metadataSubsectionRefresh(subsection, domain);
        return isDisplayed;
    }

    @Override
    public boolean createPublishEditRefreshPage(String name, String tags, String URL, String section, String subsection, String editname, String domain) {
        boolean isDisplayed;
//        createElementButton();
//        dashboardPage.clickOnAllElement();
        selectCreateCollection();
        metadata(name, tags, URL, section, subsection);
        refreshMetadataSection(name, tags, URL, subsection, domain);
        commonFunctions.clickElement(buttonPublish, 10, "publish Collection");
        commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 10, "Publish toaster");
        refreshMetadataSection(name, tags, URL, subsection, domain);
        commonFunctions.sendKeys(inputAddNameText, editname, 20, "Name box");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        isDisplayed = refreshMetadataSection(name, tags, URL, subsection, domain);
        return isDisplayed;
    }

    @Override
    public boolean previewStories(String headline) {
        boolean isDisplayed;
        createElementButton();
//        dashboardPage.clickOnAllElement();
        commonFunctions.clickElementWithJS(viewEye, 20, "Preview button");
        isDisplayed = commonFunctions.checkElementText(storyPageStoryHeadline, headline, 25, "headline box");
        return isDisplayed;
    }

    @Override
    public boolean cancelButton(String name, String tags, String URL, String section, String subsection, String PageSectionName) {
        boolean isDisplayed;
        commonFunctions.clickElementIfDisplayed(allElementsField, 10, "All Elements Label");
        selectCreateCollection();
        metadata(name, tags, URL, section, subsection);
        commonFunctions.dragAndDrop(elementSource, elementTarget, 10, "Drag And Drop Story ");
        commonFunctions.clickElementIfDisplayed(dropdownBox, 10, "Story And Page dropdown");
        commonFunctions.clickElementIgnoringStaleElement(pageDropDown, 10, "Page");
        commonFunctions.sendKeysOnElementVisibility(searchStoryCollectionPage, PageSectionName, 10, "Story search ");
//        commonFunctions.waitAndGetElementTextAndCheck(sectionHeadlineNamePage,PageSectionName,30,"page section");
        commonFunctions.dragAndDrop(elementPageSource, elementTarget, 10, "Drag and Drop Section story ");
        isDisplayed = commonFunctions.isElementDisplayedAndPresent(ButtonNo, 10, "Cancel button ");
        return isDisplayed;
    }

    @Override
    public boolean createAndPublishPageSection(String pageSectionName, String pageSectionAlias) {
        boolean isDisplayed;
        commonFunctions.clickElementWithJS(pagesButton, 10, " Pages button ");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 10, "Create a Page ");
        commonFunctions.clickElementWithJS(pageSectionButton, 10, "Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, pageSectionName, 10, "Page Section Name ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, pageSectionAlias, 10, "Page Section Alias ");
        commonFunctions.scrollPageWithJS(pageSectionCreateButton, 10);
        commonFunctions.clickElementWithJS(pageSectionCreateButton, 10, "Create button ");
        commonFunctions.clickElementWithJS(sectionNameField, 10, " section name field");
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish section page");
        isDisplayed = commonFunctions.isElementDisplayedAndPresent(popupPublishSectionButton, 20, "Publish toaster");
//        commonFunctions.clickElementIfDisplayed(allElementsField, 10, "All Elements Label");
        return isDisplayed;
    }

    public boolean selectStoryFromDropDownOnCollectionPage() {
        commonFunctions.clickElementIfDisplayed(dropdownBox, 20, "Story And Page dropdown");
        return commonFunctions.clickElementIfDisplayed(storyDropDown, 20, "storyDropDown");
    }

    @Override
    public boolean pagesPublishCollection(String id, String collectionName, String headline) {
        boolean isShowing;
        dashboardPage.clickOnPages();
        dashboardPage.searchElementByID(id);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 60,"wait for record loading");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        commonFunctions.clickElementIfDisplayed(popupYesForLockedStoryOnPage, 5, "popup Yes for Locked Stories");
        System.out.println(deleteButtonOnPages.size());
        for (int i = 0; i < deleteButtonOnPages.size(); i++) {
            if (deleteButtonOnPages.size() > 19) {
                commonFunctions.clickElementIfDisplayed(deleteButtonOnPages.get(i), 20, "delete collection");
                Utils.logStepInfo(true, (i + 1) + ":: collection name deleted");
            }
        }
        commonFunctions.clickElementWithJS(pageEditIcon, 30, "edit icon");
        commonFunctions.isElementDisplayedWithoutTryCatch(searchBoxSelectCollection, 30, "search box");
        commonFunctions.sendKeys(searchBoxSelectCollection, collectionName, 30, "search box");
        commonFunctions.isElementDisplayedAndPresent(String.format(COLLECTION_NAME, collectionName),10,"Verify Created Embed name present");
        isShowing = commonFunctions.isElementDisplayed(String.format(afterSearchingFirstStoriesTextHeadline, collectionName), 30, "collection name");
        commonFunctions.dragAndDropIgnoringStaleElement(createdCollectionElementSource, createdCollectionTargetSource, 30, " drag and drop collection ");
        commonFunctions.isElementDisplayed(String.format(afterDroppedCollectionTextName, collectionName), 30, "collection name after dropped");
        commonFunctions.scrollPageWithJS(createdCollectionSaveButton, 30);
        commonFunctions.isElementDisplayedWithoutTryCatch(createdCollectionSaveButton, 30, "done button");
        commonFunctions.clickElement(createdCollectionSaveButton, 20, "done button");
        commonFunctions.clickElementWithJS(buttonPublish, 30, "publish button");
        isShowing &= commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 30, "popup publish massage");
        return isShowing;
    }

    @Override
    public boolean dragAndDropFirstStoriesAndPublish(String headline) {
        boolean isDragAndDropVerify;
        searchElementByID(collectionId);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        commonFunctions.clickElementIfDisplayed(dropdownBox, 20, "Story And Page dropdown");
        commonFunctions.clickElementIfDisplayed(storyDropDown, 20, "storyDropDown");
        commonFunctions.isElementDisplayedWithoutTryCatch(searchBoxSelectCollection, 30, "search box");
        commonFunctions.sendKeys(searchBoxSelectCollection, headline, 30, "search box");
        commonFunctions.isElementDisplayed(String.format(afterSearchingStoriesTextHeadline, headline), 30, "First stories headline");
        commonFunctions.dragAndDropIgnoringStaleElement(elementSource, elementTarget, 30, " Drag And Drop Story ");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 30, "all changes saved");
        commonFunctions.hardWait(5000);
        String FirstHeadline = commonFunctions.getElementText(storyHeadline, 30);
        isDragAndDropVerify = commonFunctions.getElementTextAndCheck(elementDropped, FirstHeadline, 30, "Drag And Drop Story Headline ");
        publishCollection();
        return isDragAndDropVerify;
    }

    @Override
    public boolean dragAndDropStoryTypeAndPublish(){
        boolean isDragAndDropVerify;
        commonFunctions.dragAndDrop(elementSource,elementTarget,30," Drag And Drop Story ");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 30, "all changes saved");
        String headline= commonFunctions.getElementText(storyHeadline,30);
        isDragAndDropVerify = commonFunctions.getElementTextAndCheck(elementDropped,headline,30, "Drag And Drop Story Headline ");
        publishCollection();
        return isDragAndDropVerify;
    }


    public boolean publishCollection(){
        boolean isPublished;
        commonFunctions.clickElement(buttonPublish, 20, "publish Collection");
        commonFunctions.isElementDisplayedAndPresent(popupPublishButton, 20, "Publish toaster");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 30, "all changes saved");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(0));
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.clickElementWithJS(allElementsField, 20, "all Elements");
        searchElementByID(collectionId);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        isPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isPublished;
    }

    @Override
    public boolean dragAndDropSecondStoriesAndPublish(String headline1, String headline) {
        boolean isPublished;
        dashboardPage.clickOnAllElement();
        searchElementByID(collectionId);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        commonFunctions.clickElementIfDisplayed(dropdownBox, 20, "Story And Page dropdown");
        commonFunctions.clickElementIfDisplayed(storyDropDown, 20, "storyDropDown");
        commonFunctions.isElementDisplayedAndPresent(deleteButtonFirstStory, 20, "delete button");
        commonFunctions.isElementDisplayedAndPresent(searchBoxSelectCollection, 30, "search box");
        commonFunctions.sendKeys(searchBoxSelectCollection, headline1, 30, "search box");
        isPublished = commonFunctions.isElementDisplayed(String.format(afterSearchingStoriesTextHeadline, headline1), 30, "second stories headline");
        commonFunctions.dragAndDropIgnoringStaleElement(elementSource1, elementTarget1, 30, " Drag And Drop Second Story ");
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...",7, "wait for saving changes ");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 30, "all changes saved");
        commonFunctions.isElementDisplayed(String.format(secondStoriesAfterDropped, headline1), 30, "second stories headline");
        commonFunctions.clickElement(buttonPublish, 20, "publish Collection");
        isPublished &= commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 20, "Publish toaster");
        return isPublished;
    }

    @Override
    public boolean deleteStoryFromCollection(String headline1) {
        boolean isPublished;
        dashboardPage.clickOnAllElement();
        searchElementByID(collectionId);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        commonFunctions.clickElementIfDisplayed(dropdownBox, 20, "Story And Page dropdown");
        commonFunctions.clickElementIfDisplayed(storyDropDown, 20, "storyDropDown");
        commonFunctions.isElementDisplayedWithoutTryCatch(deleteButtonFirstStory, 20, "delete button");
        commonFunctions.clickForElementIgnoringStaleElement(String.format(deleteStoryIcon, headline1), 30, "headline delete icon");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 30, "all changes saved");
        isPublished = commonFunctions.elementIsNotPresent(String.format(secondStoriesAfterDropped, headline1), 20, "headline");
        commonFunctions.clickElement(buttonPublish, 20, "publish Collection");
        isPublished &= commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishButton, 20, "Publish toaster");
        return isPublished;
    }

    @Override
    public void deleteCollectionOnPages(String Id, String collectionName) {
//        dashboardPage.clickOnPages();
        commonFunctions.clickElementWithJS(pagesButton, 30, " Pages button ");
        dashboardPage.searchElementByID(Id);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 30, "selected Story");
        commonFunctions.clickElementIfDisplayed(popupYesForLockedStoryOnPage, 5, "popup Yes for Locked Stories");
        commonFunctions.clickElementIfDisplayed(String.format(pagesCollectionDeleteButton, collectionName), 30, "collection deleted on pages ");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved,30,"all changes are saved");
        commonFunctions.elementIsNotPresent(String.format(pagesCollectionDeleteButton, collectionName), 20, "collection");
    }

    @Override
    public boolean editCollectionName(String editName){
        boolean isDisplay;
        commonFunctions.clickElement(allElementsField, 30);
        searchElementByID(collectionId);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "Single record");
        isDisplay = editStatus(editName) ;
        isDisplay &= publishCreateCollection();
        return isDisplay;
    }

    @Override
    public boolean verifyAddOptionToIncludeProductWidgetsOnHtAutoOrTech(String collectionName, String firstDropdown, String secoundDropdown, String thirdDropdown){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Tech", "tenant");
        createCollection(collectionName);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        dashboardPage.clickOnAllElement();
        commonFunctions.isElementDisplayed(searchText, 10, "Search Text");
        commonFunctions.sendKeys(searchText, collectionName, 10, "Search Text");
        searchText.sendKeys(Keys.chord(Keys.BACK_SPACE));
        commonFunctions.dummyWait(5);
        if(searchCollection.get(0).getText().trim().equalsIgnoreCase(collectionName.trim()) && searchCollection.get(1).getText().trim().equalsIgnoreCase("PUBLISHED") && searchCollection.get(4).getText().trim().equalsIgnoreCase("Collection")){
            commonFunctions.clickElement(searchCollection.get(0), 10, "Search Collection");
        }

        commonFunctions.isElementDisplayed(collectionText, 10, "Collection Text");
        commonFunctions.clickElement(collectionText, 10, "Collection Text");

        List<String> valueList = new ArrayList<String>();
        valueList.add(listOfValue.get(0).getText().trim());
        valueList.add(listOfValue.get(1).getText().trim());
        valueList.add(listOfValue.get(2).getText().trim());

        boolean flag = false;
        if(valueList.contains(firstDropdown) && valueList.contains(secoundDropdown) && valueList.contains(thirdDropdown)){
            flag = true;
        }

        commonFunctions.clickElement(listOfValue.get(0), 10, "List Value");
        commonFunctions.isElementDisplayed(publishButton, 10, "Publish Button");
        commonFunctions.clickElement(publishButton, 10, "Publish Button");
        commonFunctions.isElementDisplayed(successMessage, 10, "Success Message");

        dashboardPage.clickOnAllElement();
        commonFunctions.isElementDisplayed(searchText, 10, "Search Text");
        commonFunctions.sendKeys(searchText, collectionName, 10, "Search Text");
        commonFunctions.backSpace(searchText);
        commonFunctions.dummyWait(5);
        if(searchCollection.get(0).getText().trim().equalsIgnoreCase(collectionName.trim()) && searchCollection.get(1).getText().trim().equalsIgnoreCase("PUBLISHED") && searchCollection.get(4).getText().trim().equalsIgnoreCase("Collection")){
            commonFunctions.clickElement(searchCollection.get(0), 10, "Search Collection");
        }

        commonFunctions.isElementDisplayed(collectionText, 10, "Collection Text");
        String selectedValue = collectionText.getAttribute("ng-reflect-model").trim();

        Boolean valueStatus = selectedValue.equalsIgnoreCase(firstDropdown) || selectedValue.equalsIgnoreCase(secoundDropdown) || selectedValue.equalsIgnoreCase(thirdDropdown);

        return flag && valueStatus;
    }

    public void createCollection(String collectionName){
        commonFunctions.isElementDisplayed(elementButton, 10, "Create Element Button");
        commonFunctions.clickElement(elementButton, 10, "Create Element Button");

        commonFunctions.isElementDisplayed(collectionButton, 10, "Create Collection Button");
        commonFunctions.clickElement(collectionButton, 10, "Create Collection Button");

        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));

        commonFunctions.isElementDisplayed(addNameText, 10, "Add Name Text");
        commonFunctions.sendKeys(addNameText, collectionName, 10, "Add Name Text");

        commonFunctions.isElementDisplayed(publishButton, 10, "Publish Button");
        commonFunctions.clickElementWithJS(publishButton, 10, "Publish Button");

        commonFunctions.isElementDisplayed(successMessage, 20, "Success Message");
    }

    @Override
    public boolean checkToggleSwitchesShouldBePresentAppAndAmp(){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        commonFunctions.isElementDisplayed(elementButton, 10, "Create Element Button");
        commonFunctions.clickElement(elementButton, 10, "Create Element Button");
        commonFunctions.isElementDisplayed(collectionButton, 10, "Create Collection Button");
        commonFunctions.clickElement(collectionButton, 10, "Create Collection Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.isElementPresentWithTryCatch(appToggleSwitche, 10) && commonFunctions.isElementPresentWithTryCatch(ampToggleSwitche, 10);
    }

    @Override
    public boolean checkByDefaultBothTheButtonsShouldInOnPosition(String expectedBgColorHexCode){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        commonFunctions.isElementDisplayed(elementButton, 10, "Create Element Button");
        commonFunctions.clickElement(elementButton, 10, "Create Element Button");
        commonFunctions.isElementDisplayed(collectionButton, 10, "Create Collection Button");
        commonFunctions.clickElement(collectionButton, 10, "Create Collection Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.getBackgroundColorOfWebElement(appToggleSwitche, 10, "App Toggle", "background-color").trim().equalsIgnoreCase(expectedBgColorHexCode.trim()) && commonFunctions.getBackgroundColorOfWebElement(ampToggleSwitche, 10, "Amp Toggle", "background-color").trim().equalsIgnoreCase(expectedBgColorHexCode.trim());
    }

    @Override
    public boolean checkAbleToSelectOneOrNoneFromBothTheOptions(String appBgColorHexCodeBeforeSelect, String appBgColorHexCodeAfterSelect, String ampBgColorHexCodeBeforeSelect, String ampBgColorHexCodeAfterSelect){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        commonFunctions.isElementDisplayed(elementButton, 10, "Create Element Button");
        commonFunctions.clickElement(elementButton, 10, "Create Element Button");
        commonFunctions.isElementDisplayed(collectionButton, 10, "Create Collection Button");
        commonFunctions.clickElement(collectionButton, 10, "Create Collection Button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean bgColorHexCodeAfterAppSelectStatus = hexCodeAfterAppSelect(appBgColorHexCodeAfterSelect, ampBgColorHexCodeBeforeSelect);
        commonFunctions.refreshPage();
        commonFunctions.dummyWait(5);
        boolean bgColorHexCodeAfterAmpSelectStatus = hexCodeAfterAmpSelect(appBgColorHexCodeBeforeSelect, ampBgColorHexCodeAfterSelect);
        commonFunctions.refreshPage();
        commonFunctions.dummyWait(5);
        boolean bgColorHexCodeAfterAppAndAmpSelectStatus = hexCodeAfterAppAndAmpSelect(appBgColorHexCodeAfterSelect, ampBgColorHexCodeAfterSelect);
        return bgColorHexCodeAfterAppSelectStatus && bgColorHexCodeAfterAmpSelectStatus && bgColorHexCodeAfterAppAndAmpSelectStatus;
    }

    @Override
    public boolean createACollectionOnLiveHindustanAffiliateAndPublish(String name,String tag,String url){
        selectCreateCollection();
        inputName(name);
        boolean isCollectionTitleCreated =commonFunctions.getElementTextAndCheck(createdCollectionName,name,20,"Creation of Metadata Section Name in progress");
        if(isCollectionTitleCreated){
            inputTags(tag);
            inputExternalURL(url);
            commonFunctions.dragAndDrop(elementSource,elementTarget,10,"drag and dropping the story  in progress");
            boolean isStoryDropped=commonFunctions.isElementDisplayed(droppedStoryElement,10);
            if(isStoryDropped) return commonFunctions.isClickableElementClicked(buttonPublish,10,"click on publish button in progress");
            }
        return false;
    }

    @Override
    public boolean createAnEmbedCollectionOnLiveHindustanAffiliateAndPublish(String name,String codeForTweets,String codeForDarkMode) {
        selectCollectionType(createEmbedButton);
        commonFunctions.sendKeys(embedCodeForVidAndTweets,codeForTweets,10,"sending code for video and tweets in progress");
        commonFunctions.sendKeys(embedCodeForDarkMode,codeForDarkMode,10,"sending code for darkmode in progress");
        commonFunctions.clickElement(embedCodeDoneButton,10);
        inputNameTextField(name);
        commonFunctions.clickElement(buttonPublish,10,"publishing the collection");
        boolean isDisplayed = commonFunctions.isElementDisplayedAndPresent(popupPublishSectionButton, 10, "Publish toaster");
        return isDisplayed;
    }

    @Override
    public boolean createInputFormOnLiveHindustanAffiliateAndPublish(String name,String topicName,String topicURL) {
//        dashboardPage.domainSelection(property);
        selectCollectionType(createInputFormButton);
        commonFunctions.sendKeys(inputAddTopicName,topicName,10,"sending topic keys in progress");
        commonFunctions.sendKeys(inputAddTopicUrl,topicURL,10,"sending url keys in progress");
        commonFunctions.clickElement(addInputFormTopic,10,"adding input form topic");
        inputNameTextField(name);
        commonFunctions.clickElement(buttonPublish,10,"publishing the collection");
        boolean isDisplayed = commonFunctions.isElementDisplayedAndPresent(popupPublishSectionButton, 10, "Publish toaster");
        return isDisplayed;
    }

    @Override
    public boolean createChartOnLiveHindustanAffiliateAndPublish(String name) {
        selectCollectionType(createChartButton);
        commonFunctions.clickElement(tableCreationButton,10);
        commonFunctions.clickElement(clickOnCell,10);
        commonFunctions.clickElement(buttonDone,10);
        inputNameTextField(name);
        commonFunctions.clickElement(buttonPublish,10,"publishing the collection");
        boolean isDisplayed = commonFunctions.isElementDisplayedAndPresent(popupPublishSectionButton, 20, "Publish toaster");
        return isDisplayed;
    }

    @Override
    public boolean createTableOnLiveHindustanAffiliateAndPublish(String name) {
        selectCollectionType(createTableButton);
        commonFunctions.clickElement(tableCreationButton,10);
        commonFunctions.clickElement(clickOnCell,10);
        commonFunctions.clickElement(buttonDone,10);
        inputNameTextField(name);
        commonFunctions.clickElement(buttonPublish,10,"publishing the collection");
        boolean isDisplayed = commonFunctions.isElementDisplayedAndPresent(popupPublishSectionButton, 10, "Publish toaster");
        return isDisplayed;
    }


    public boolean hexCodeAfterAppSelect(String appBgColorHexCodeAfterSelect, String ampBgColorHexCodeBeforeSelect){
        commonFunctions.isElementPresentWithTryCatch(appToggleSwitche, 10);
        commonFunctions.clickElement(appToggleSwitche, 10, "App Toggle");
        commonFunctions.dummyWait(5);
        boolean bgColorHexCodeAfterAppSelectStatus = commonFunctions.getBackgroundColorOfWebElement(appToggleSwitche, 10, "App Toggle", "background-color").trim().equalsIgnoreCase(appBgColorHexCodeAfterSelect.trim()) && commonFunctions.getBackgroundColorOfWebElement(ampToggleSwitche, 10, "Amp Toggle", "background-color").trim().equalsIgnoreCase(ampBgColorHexCodeBeforeSelect.trim());
        return bgColorHexCodeAfterAppSelectStatus;
    }

    public boolean hexCodeAfterAmpSelect(String appBgColorHexCodeBeforeSelect, String ampBgColorHexCodeAfterSelect){
        commonFunctions.isElementPresentWithTryCatch(ampToggleSwitche, 10);
        commonFunctions.clickElement(ampToggleSwitche, 10, "Amp Toggle");
        commonFunctions.dummyWait(5);
        boolean bgColorHexCodeAfterAmpSelectStatus = commonFunctions.getBackgroundColorOfWebElement(appToggleSwitche, 10, "App Toggle", "background-color").trim().equalsIgnoreCase(appBgColorHexCodeBeforeSelect.trim()) && commonFunctions.getBackgroundColorOfWebElement(ampToggleSwitche, 10, "Amp Toggle", "background-color").trim().equalsIgnoreCase(ampBgColorHexCodeAfterSelect.trim());
        return bgColorHexCodeAfterAmpSelectStatus;
    }

    public boolean hexCodeAfterAppAndAmpSelect(String appBgColorHexCodeAfterSelect, String ampBgColorHexCodeAfterSelect){
        commonFunctions.isElementPresentWithTryCatch(appToggleSwitche, 10);
        commonFunctions.clickElement(appToggleSwitche, 10, "App Toggle");
        commonFunctions.isElementPresentWithTryCatch(ampToggleSwitche, 10);
        commonFunctions.clickElement(ampToggleSwitche, 10, "Amp Toggle");
        commonFunctions.dummyWait(5);
        boolean bgColorHexCodeAfterAppAndAmpSelectStatus = commonFunctions.getBackgroundColorOfWebElement(appToggleSwitche, 10, "App Toggle", "background-color").trim().equalsIgnoreCase(appBgColorHexCodeAfterSelect.trim()) && commonFunctions.getBackgroundColorOfWebElement(ampToggleSwitche, 10, "Amp Toggle", "background-color").trim().equalsIgnoreCase(ampBgColorHexCodeAfterSelect.trim());
        return bgColorHexCodeAfterAppAndAmpSelectStatus;
    }

}
