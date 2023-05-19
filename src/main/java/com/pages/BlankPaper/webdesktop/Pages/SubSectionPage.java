package com.pages.BlankPaper.webdesktop.Pages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonInputFormPage;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.pages.BlankPaper.genericPages.CommonSubSectionPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubSectionPage extends CommonSubSectionPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonInputFormPage createInputFormPage;
    private static CommonDashboardPage dashboardPage;
    public static String id;
    private static CommonSectionPage sectionPage;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[3]//i")
    private static WebElement pagesButton;

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'Subsection')]")
    private static WebElement subSectionButton;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[1]")
    private static WebElement pageSectionNameText;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[2]")
    private static WebElement pageSectionAliasText;

    @FindBy(css = "button.add")
    private static WebElement pageCreateButton;

    @FindBy(css = "input[placeholder='Add page name here…']")
    private static WebElement subSectionNameField;

    @FindBy(xpath = "//button[contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[contains(text(),'published successfully')]")
    private static WebElement popupPublishSectionMassage;

    @FindBy(xpath = "//em[contains(@class,'publish')]")
    private static WebElement publishIconOnPages;

    @FindBy(xpath = "//ul[contains(@class,'listingul active')]")
    private static WebElement pageStatus;

    @FindBy(xpath = "//span[contains(@class,'created')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//a[contains(@tabindex,'0')]//li[contains(@class,'name')]//div//div")
    private static WebElement subsectionNameOnPage;

    @FindBy(css = "input[placeholder='Search Pages here...']")
    private static WebElement searchAllElementsText;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(id = "sectionBox")
    private static WebElement sectionBox;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[4]")
    private static WebElement subSectionBox;

    @FindBy(xpath = "//li[contains(@class,'active')]//span")
    private static WebElement sectionBoxData;

    @FindBy(xpath = "//button[@disabled]")
    private static WebElement createButtonDisable;

    @FindBy(xpath = "//li[@class='name']//div[contains(@class,'listCell')]")
    private static WebElement storyName;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;



    public SubSectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        createInputFormPage = CommonInputFormPage.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        sectionPage= CommonSectionPage.getInstance();
    }

    public boolean publish() {
        boolean isDisplayed;
        commonFunctions.clickElementWithJS(subSectionNameField, 30, " Sub-section name field");
        commonFunctions.clickElementWithJS(buttonPublish, 30, "publish button");
        commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishSectionMassage, 30, "Publish toaster");
        id = createInputFormPage.getElementId();
        commonFunctions.clickElementWithJS(pagesButton, 30, " Pages button ");
        commonFunctions.sendKeysOnElementVisibility(searchAllElementsText, "id:" + id, 30, "id in search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText, 20);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 10, "Single record");
        isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(publishIconOnPages, 30, "Published icon displayed");
        return isDisplayed;
    }

    @Override
    public boolean publishSubSectionPage(String subSectionName, String subSectionAlias) {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionButton, 30, "Sub-Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, subSectionName, 30, "Page Sub-Section Name ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, subSectionAlias, 30, "Page Sub-Section Alias ");
        commonFunctions.clickElementWithJS(sectionBox, 30, "section name");
        commonFunctions.hardWait(2000);
        commonFunctions.clickElementWithJS(sectionBoxData, 30, "section value");
        commonFunctions.scrollPageWithJS(pageCreateButton, 10);
        commonFunctions.clickElementWithJS(pageCreateButton, 30, "Create button ");
        commonFunctions.hardWait(5000);
        return publish();
    }

    @Override
    public boolean editAndRefreshPage(String subSectionEditName){
        boolean isDisplayed,isPresent;
        commonFunctions.waitAndClickForElementIgnoringStaleElement(subsectionNameOnPage, 30, "Story status");
        commonFunctions.sendKeys(subSectionNameField, subSectionEditName, 50, " Sub-section name field");
        isPresent = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.refreshPage();
        isDisplayed = commonFunctions.getAttributeValue(subSectionNameField, 30, "id").equalsIgnoreCase(subSectionEditName);
        String id = createInputFormPage.getElementId();
        commonFunctions.clickElementWithJS(pagesButton, 50, "Pages button");
        dashboardPage.searchElementByID(id);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 20, "showing one result");
        isDisplayed = isDisplayed && commonFunctions.checkElementText(subsectionNameOnPage, subSectionEditName, 30, "Su-Section Name on Page");
        return isDisplayed && isPresent;
    }

    @Override
    public boolean allValidationToCreateSubsectionPage(String subSectionName, String subSectionAlias) {
        boolean isDisable, isShowing;
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page");
        commonFunctions.clickElementWithJS(subSectionButton, 30, "Sub-Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, subSectionName, 30, "Page Sub-Section Name");
        isDisable = commonFunctions.isElementDisplayedWithoutTryCatch(createButtonDisable, 30, "disable create button");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, subSectionAlias, 30, "Page Sub-Section Alias");
        isDisable = isDisable && commonFunctions.isElementDisplayedWithoutTryCatch(createButtonDisable, 30, "disable create button");
        commonFunctions.clickElementWithJS(sectionBox, 30, "section name box");
        commonFunctions.clickElementWithJS(sectionBoxData, 30, "section value");
        isShowing = createPageAndValidate(subSectionName);
        return isDisable && isShowing;
    }

    @Override
    public boolean createPageAndValidate(String subSectionName) {
        boolean isDisplayed, isShowing;
        commonFunctions.scrollToElement(pageCreateButton, "create button");
        commonFunctions.clickElementWithJS(pageCreateButton, 30, "create button");
        commonFunctions.clickElementWithJS(subSectionNameField, 30, "metadata name field");
        isDisplayed = commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        String id = createInputFormPage.getElementId();
        commonFunctions.clickElementWithJS(pagesButton, 50, "Pages button");
        dashboardPage.searchElementByID(id);
        isShowing= commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 10, "Single record");
        isDisplayed = isDisplayed && commonFunctions.getElementTextAndCheck(storyName, subSectionName, 50, "Correct text is");
        return isDisplayed && isShowing;
    }

    @Override
    public boolean createDragAndDropStoryAndPublishSection(String pageSubSectionName, String pageSubSectionAlias,String section, String headline) {
        boolean isDragAndDropVerify, isPublishVerify;
        commonFunctions.clickElementWithJS(pagesButton, 20, "Page field");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionButton, 30, "Sub-Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, pageSubSectionName, 30, "Page Sub-Section Name ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, pageSubSectionAlias, 30, "Page Sub-Section Alias ");
        commonFunctions.clickElementWithJS(sectionBox, 30, "section name");
        commonFunctions.isElementDisplayed(sectionBoxData,30,"list view");
        commonFunctions.sendKeys(sectionBox, section, 30, "page section name");
        commonFunctions.clickElementWithJS(sectionBoxData, 30, "section value");
        commonFunctions.clickElementWithJS(pageCreateButton, 30, "Create button ");
        isDragAndDropVerify= sectionPage.dragAndDropStory(headline);
        isPublishVerify = publish();
        return isDragAndDropVerify && isPublishVerify;
    }

    public boolean checkCreateSubSectionPageWithLivehindustanAffiliateTanent(String property, String subSectionName, String subSectionAlias){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionButton, 30, "Sub-Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, subSectionName, 30, "Page Sub-Section Name ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, subSectionAlias, 30, "Page Sub-Section Alias ");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElementWithJS(sectionBox, 30, "section name");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(sectionBoxData, 30, "section value");
        commonFunctions.dummyWait(3);
        commonFunctions.clickElementWithJS(pageCreateButton, 30, "Create button ");
        return publish();

    }



}

