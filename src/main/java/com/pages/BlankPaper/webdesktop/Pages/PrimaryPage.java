package com.pages.BlankPaper.webdesktop.Pages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonPrimaryPage;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrimaryPage extends CommonPrimaryPage {

    private static CommonSectionPage sectionPage;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static SubSectionPage subsectionPage = new SubSectionPage() ;

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'Primary')]")
    private static WebElement primaryButton;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[1]")
    private static WebElement pagePrimaryNameText;

    @FindBy(xpath= "(//div[contains(@class,'addUser')]//input)[2]")
    private static WebElement pagePrimaryAliasText;

    @FindBy(css = "button.add")
    private static WebElement pageSectionCreateButton;

    @FindBy(xpath = "//button[@disabled]")
    private static WebElement createButtonDisable;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[3]//i")
    private static WebElement pagesButton;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "(//div[@class='storyListing']/ul/a/li)[1]")
    private static WebElement primaryStoryData;

    @FindBy(id = "inputAddSectionText")
    private static WebElement primaryStorySection;

    @FindBy(id = "inputAddSubSectionText")
    private static WebElement primaryStorySubSection;


    public PrimaryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        sectionPage= CommonSectionPage.getInstance();
    }

    @Override
    public boolean publishPrimaryPage(String primaryName, String primaryAlias) {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(primaryButton, 30, "primary button ");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryNameText, primaryName, 30, "Page primary Name ");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryAliasText, primaryAlias, 30, "Page primary Alias ");
        commonFunctions.clickElementWithJS(pageSectionCreateButton,30,"Create button ");
        return subsectionPage.publish();
    }

    @Override
    public boolean allValidationToCreatePrimaryPage(String primaryName, String primaryAlias) {
        boolean isDisable, isShowing;
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page");
        commonFunctions.clickElementWithJS(primaryButton, 30, "primary button ");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryNameText, primaryName, 30, "Page primary Name");
        isDisable = commonFunctions.isElementDisplayedWithoutTryCatch(createButtonDisable, 30, "disable create button");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryAliasText, primaryAlias, 30, "Page primary Alias");
        isShowing = subsectionPage.createPageAndValidate(primaryName);
        return isDisable && isShowing;
    }

    @Override
    public boolean createDragAndDropStoryAndPublishPrimary(String primaryName, String primaryAlias, String headline){
        boolean isDragAndDropVerify, isPublishVerify;
        commonFunctions.clickElementWithJS(pagesButton, 20, "Page field");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(primaryButton, 30, "primary button ");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryNameText, primaryName, 30, "Page primary Name ");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryAliasText, primaryAlias, 30, "Page primary Alias ");
        commonFunctions.clickElementWithJS(pageSectionCreateButton,30,"Create button ");
        isDragAndDropVerify= sectionPage.dragAndDropStory(headline);
        isPublishVerify= subsectionPage.publish();
        return isDragAndDropVerify && isPublishVerify;
    }

    @Override
    public boolean checkSectionAndSubSectionFieldsForPrimaryPages(String primaryName, String primaryAlias){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 20, "Create a Page");
        commonFunctions.clickElementWithJS(primaryButton, 20, "primary button ");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryNameText, primaryName, 20, "Page primary Name");
        commonFunctions.sendKeysOnElementVisibility(pagePrimaryAliasText, primaryAlias, 20, "Page primary Alias");
        subsectionPage.createPageAndValidate(primaryName);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementIfDisplayed(primaryStoryData, 10, "Primary Data");
        commonFunctions.dummyWait(5);
        return commonFunctions.isElementPresentWithTryCatch(primaryStorySubSection, 10) && commonFunctions.isElementPresentWithTryCatch(primaryStorySection, 10);
    }
    @Override
    public boolean createPrimaryPageOnLiveHindustanAffiliateAndPublish(String primaryName, String primaryAlias) {
        return publishPrimaryPage(primaryName,primaryAlias);
    }
}
