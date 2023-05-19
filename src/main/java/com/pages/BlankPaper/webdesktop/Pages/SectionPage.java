package com.pages.BlankPaper.webdesktop.Pages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonInputFormPage;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SectionPage extends CommonSectionPage {

    private static CommonDashboardPage dashboardPage;
    public static String sectionUrl;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonInputFormPage createInputFormPage;
    private static SubSectionPage subsectionPage = new SubSectionPage() ;

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'Section')]")
    private static WebElement sectionButton;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[1]")
    private static WebElement pageSectionNameText;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[2]")
    private static WebElement pageSectionAliasText;

    @FindBy(css = "button.add")
    private static WebElement pageSectionCreateButton;

    @FindBy(xpath = "//button[@disabled]")
    private static WebElement createButtonDisable;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[3]//i")
    private static WebElement pagesButton;

    @FindBy(xpath = "//input[contains(@class,'search-components')]")
    private static WebElement searchBoxSelectCollection;

    @FindBy(xpath = "//ul//li[@value='0']")
    private static WebElement elementSource;

    @FindBy(xpath = "//div[@class='allLiveList']//div[@id='right']")
    private static WebElement elementTarget;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//div[@class='allcontentList']//li[@value='0']//div[@class='heading pin']//span")
    private static WebElement storyHeadline;

    @FindBy(xpath = "//div[contains(@class,'allLiveList')]//div[contains(@class,'heading pin')]//span[2]")
    private static WebElement elementDropped;

    @FindBy(xpath = "//span[@class='link']")
    private static WebElement copySectionUrl;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result')]")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(css = "input[placeholder='Add page name here…']")
    private static WebElement subSectionNameField;

    @FindBy(xpath = "//button[contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[contains(text(),'published successfully')]")
    private static WebElement popupPublishSectionMassage;

    @FindBy(xpath = "//span[@id='typeFilterSpan']")
    private static WebElement getTypeFilter;

    @FindBy(xpath = "//label[@id='typeFilterValueSection']")
    private static WebElement secOpt;

    @FindBy(xpath = "//label[@id='typeFilterValueSubsection']")
    private static WebElement subSecOpt;

    @FindBy(xpath = "//div[@class='storyListing']")
    private static WebElement selectStory;

    @FindBy(xpath = "//div[contains(@class,'usermeta')]")
    private static WebElement metadataTab;

    @FindBy(xpath = "//div[@class = 'form']/ul[2]/li[12]/new-metadata[1]/li/div/label")
    private static WebElement metaTitlePrefix;

    @FindBy(xpath = "//div[@class = 'form']/ul[2]/li[12]/new-metadata[2]/li/div/label")
    private static WebElement metaTitleSuffix;

    @FindBy(xpath = "//div[@class = 'form']/ul[2]/li[12]/new-metadata[3]/li/div/label")
    private static WebElement metaDescriptionPrefix;

    @FindBy(xpath = "//div[@class = 'form']/ul[2]/li[12]/new-metadata[4]/li/div/label")
    private static WebElement metaDescriptionSuffix;

    @FindBy(xpath = "//a[@id='appLogo']/img")
    private static WebElement backToHomePage;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;



    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        createInputFormPage = CommonInputFormPage.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    @Override
    public boolean publishSectionPage(String sectionName, String sectionAlias) {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(sectionButton, 30, "Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, sectionName, 30, "Page Section Name ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, sectionAlias, 30, "Page Section Alias ");
        commonFunctions.clickElementWithJS(pageSectionCreateButton,30,"Create button ");
        return subsectionPage.publish();
    }

    @Override
    public boolean allValidationToCreateSectionPage(String sectionName, String sectionAlias){
        boolean isDisable, isShowing;
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page");
        commonFunctions.clickElementWithJS(sectionButton, 30, "Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, sectionName, 30, "Page Section Name");
        isDisable = commonFunctions.isElementDisplayedWithoutTryCatch(createButtonDisable, 30, "disable create button");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, sectionAlias, 30, "Page Section Alias");
        isShowing = subsectionPage.createPageAndValidate(sectionName);
        return isDisable && isShowing;
    }

    @Override
    public boolean createDragAndDropStoryAndPublishSection(String pageSectionName, String sectionAlias, String headline) {
        boolean isDragAndDropVerify,isPublishVerify;
        commonFunctions.clickElementWithJS(pagesButton, 20, "Page field");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(sectionButton, 30, "Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, pageSectionName, 30, "Page Section Name ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, sectionAlias, 30, "Page Section Alias ");
        commonFunctions.clickElementWithJS(pageSectionCreateButton, 30, "Create button ");
        isDragAndDropVerify= dragAndDropStory(headline);
        isPublishVerify = subsectionPage.publish();
        return isDragAndDropVerify && isPublishVerify;
    }

    @Override
    public boolean editPageNameAndPublish(String editNewName, String id){
        boolean isDisplayed;
        commonFunctions.clickElementWithJS(pagesButton, 30, " Pages button ");
        dashboardPage.searchElementByID(id);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
        commonFunctions.sendKeys(subSectionNameField, editNewName, 50, " name field");
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved,30,"all changes are saved");
        commonFunctions.clickElementWithJS(buttonPublish, 30, "publish button");
        isDisplayed= commonFunctions.isElementDisplayedWithoutTryCatch(popupPublishSectionMassage, 30, "Publish toaster");
        return isDisplayed ;
    }

    @Override
    public boolean dragAndDropStory(String headline) {
        boolean isDragAndDropVerify;
        commonFunctions.clickElementIfDisplayed(subSectionNameField,30,"section");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 30, "all changes saved");
        commonFunctions.sendKeys(searchBoxSelectCollection, headline, 30, "search box");
        commonFunctions.checkElementText(elementSource, headline, 30, "First stories headline");
        commonFunctions.hardWait(2000);
        commonFunctions.dragAndDropIgnoringStaleElement(elementSource, elementTarget, 30, " Drag And Drop Story ");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 30, "all changes saved");
        commonFunctions.hardWait(2000);
        String FirstHeadline = commonFunctions.getElementText(storyHeadline, 30);
        isDragAndDropVerify = commonFunctions.getElementTextAndCheck(elementDropped, FirstHeadline, 30, "Drag And Drop Story Headline ");
        sectionUrl = commonFunctions.getElementText(copySectionUrl, 50);
        return isDragAndDropVerify;
    }

    public boolean commonFunctionForMetaDataFieldsTest(WebElement filterType){
        commonFunctions.clickElementIfDisplayed(pagesButton, 30, "Pages Label");
        commonFunctions.clickElementIfDisplayed(getTypeFilter,30,"type filter");
        commonFunctions.clickElementIfDisplayed(filterType,30,"section option");
        commonFunctions.waitForElementListToAppear("//div[@class='storyListing']",30,"click on section story when displayed");
        commonFunctions.clickElementIfDisplayed(selectStory,30,"click on section story when displayed");
        commonFunctions.clickElementIfDisplayed(metadataTab,30,"click on metadata section");
        boolean isMetaTitlePrefixEnabled=commonFunctions.isElementPresent(metaTitlePrefix,30);
        boolean isMetaTitleSuffixEnabled=commonFunctions.isElementPresent(metaTitleSuffix,30);
        boolean isMetaDescriptionPrefixEnabled=commonFunctions.isElementPresent(metaDescriptionPrefix,30);
        boolean isMetaDescriptionSuffixEnabled=commonFunctions.isElementPresent(metaDescriptionSuffix,30);
        boolean areMetaFieldsPresent=(isMetaTitlePrefixEnabled && isMetaTitleSuffixEnabled &&
                isMetaDescriptionPrefixEnabled && isMetaDescriptionSuffixEnabled);

        return areMetaFieldsPresent;
    }

    @Override
    public boolean prefixAndSuffixForTitleAndDescriptionForSectionAndSubSectionPages(String domainName) {
        dashboardPage.domainSelection(domainName);
        boolean areSectionMetaFieldsPresent=commonFunctionForMetaDataFieldsTest(secOpt);
        commonFunctions.clickElement(backToHomePage,10,"click BlankPaper icon to go back to Home page");
        boolean areSubSectionMetaFieldsPresent=commonFunctionForMetaDataFieldsTest(subSecOpt);
        return areSectionMetaFieldsPresent && areSubSectionMetaFieldsPresent;


    }

    @Override
    public boolean checkCreateSectionPageWithLivehindustanAffiliateTanent(String property, String sectionName, String sectionAlias){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(sectionButton, 30, "Section button ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionNameText, sectionName, 30, "Page Section Name ");
        commonFunctions.sendKeysOnElementVisibility(pageSectionAliasText, sectionAlias, 30, "Page Section Alias ");
        commonFunctions.clickElementWithJS(pageSectionCreateButton,30,"Create button ");
        return subsectionPage.publish();
    }


}