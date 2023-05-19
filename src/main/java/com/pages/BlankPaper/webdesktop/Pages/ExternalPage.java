package com.pages.BlankPaper.webdesktop.Pages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonExternalPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExternalPage extends CommonExternalPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static SubSectionPage subsectionPage = new SubSectionPage() ;

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'External')]")
    private static WebElement externalButton;

    @FindBy(css = "input[placeholder='Add page’s name here']")
    private static WebElement pageExternalNameText;

    @FindBy(css = "input[placeholder='Add URL here']")
    private static WebElement pageExternalURL;

    @FindBy(css = "button.add")
    private static WebElement pageExternalCreateButton;

    @FindBy(css = "input[placeholder='Search Pages here...']")
    private static WebElement searchAllElementsText;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result')]")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//em[contains(@class,'publish')]")
    private static WebElement publishIconOnPages;

    @FindBy(xpath = "//a[contains(@tabindex,'0')]//li[contains(@class,'name')]//div//div")
    private static WebElement externalNameOnPage;

    @FindBy(xpath = "//span[text()='Type']")
    private static WebElement typeFilter;

    @FindBy(xpath = "(//input[contains(@placeholder,'search text goes here')])[1]")
    private static WebElement typeFilterInputBox;

    @FindBy(xpath = "(//label[contains(@class,'checkblock')])[1]")
    private static WebElement typeFilterData;

    @FindBy(xpath = "//div[contains(text(),'Page Updated successfully')]")
    private static WebElement toasterMassagePageUpdated;

    @FindBy(xpath = "//div[contains(text(),'Page created successfully')]")
    private static WebElement toasterMassagePageCreated;

    public ExternalPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
    }

    @Override
    public boolean createAndPublishExternalPage(String externalName, String externalURL, String typeFilterValue) {
        boolean isDisplayed;
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(externalButton, 30, "External button ");
        commonFunctions.sendKeysOnElementVisibility(pageExternalNameText, externalName, 30, "Page External Name ");
        commonFunctions.sendKeysOnElementVisibility(pageExternalURL, externalURL, 30, "Page External url ");
        commonFunctions.clickElementWithJS(pageExternalCreateButton, 30, "Create button ");
        commonFunctions.isElementDisplayedWithoutTryCatch(toasterMassagePageCreated, 50, "External created toaster massage");
        commonFunctions.clickElementWithJS(typeFilter, 50, "type filter");
        commonFunctions.sendKeysOnElementVisibility(typeFilterInputBox, typeFilterValue, 50, "type filter value");
        commonFunctions.clickElementWithJS(typeFilterData, 40, "type filter data");
        commonFunctions.sendKeysOnElementVisibility(searchAllElementsText, externalName, 30, "external name in search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText, 20);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "showing one result");
        isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(publishIconOnPages, 30, "Published icon displayed");
        return isDisplayed;
    }

    @Override
    public boolean editExternal(String editExternalName,String typeFilterValue) {
        boolean isDisplayed;
        commonFunctions.clickElementWithJS(externalNameOnPage, 30, "Story status");
        commonFunctions.sendKeys(pageExternalNameText, editExternalName, 30, "Edit External Name ");
        commonFunctions.clickElementWithJS(pageExternalCreateButton, 30, "Create button ");
        commonFunctions.getElementTextAndCheck(toasterMassagePageUpdated, "Page Updated successfully", 50, "toaster massage");
        commonFunctions.clickElementWithJS(typeFilter, 50, "type filter");
        commonFunctions.sendKeysOnElementVisibility(typeFilterInputBox, typeFilterValue, 50, "type filter value");
        commonFunctions.clickElementWithJS(typeFilterData, 40, "type filter data");
        commonFunctions.sendKeysOnElementVisibility(searchAllElementsText, editExternalName, 30, "External name in search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText, 20);
        commonFunctions.isElementDisplayedWithoutTryCatch(singleRecordConformation, 30, "showing one result");
        isDisplayed= commonFunctions.getElementTextAndCheck(externalNameOnPage, editExternalName, 50, "edit name matched");
        return isDisplayed;
    }

}
