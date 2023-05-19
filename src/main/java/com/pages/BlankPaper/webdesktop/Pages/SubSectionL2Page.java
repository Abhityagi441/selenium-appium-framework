package com.pages.BlankPaper.webdesktop.Pages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonInputFormPage;
import com.pages.BlankPaper.genericPages.CommonSubSectionL2Page;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SubSectionL2Page extends CommonSubSectionL2Page {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonInputFormPage createInputFormPage;
    private static CommonDashboardPage dashboardPage;
    public static String id;

    public SubSectionL2Page() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'Section')]")
    private static WebElement sectionButton;

    @FindBy(xpath = "//button[contains(text(),'Subsection')]")
    private static WebElement subSectionButton;

    @FindBy(xpath = "//div[@class='lightContent']")
    private static WebElement subSectionL2PopUp;

    @FindBy(xpath = "//div[contains(@class,'autosuggestion')]//li[1]")
    private static WebElement SelectFirstOption;

    @FindBy(xpath = "//button[contains(@ng-reflect-router-link,'SUBSECTION_L2')]")
    private static WebElement subSectionL2Button;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[1]")
    private static WebElement pageSectionNameText;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[2]")
    private static WebElement pageSectionAliasText;

    @FindBy(xpath = "//input[@id='sectionBox']")
    private static WebElement sectionBox;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[4]")
    private static WebElement subSectionBox;

    @FindBy(xpath="//div/button[@name='add']")
    private static WebElement pageCreateButton;

    @FindBy(id="pageCreateButton")
    private static WebElement subSectionPageCreateButton;

    @FindBy(xpath = "//input[contains(@placeholder,'Add Section here')]")
    private static WebElement inputAddSectionText;

    @FindBy(id="textAllChangesSaved")
    private static WebElement textAllChangesSaved;

    @FindBy(id = "buttonPublish")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'published successfully')]")
    private static WebElement toastPublish;

    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(id = "selectStory")
    private static WebElement selectStory;

    @FindBy(xpath = "(//input[@id='inputAddSubSectionText'])[1]")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "(//input[@id='inputAddSubSectionText'])[2]")
    private static WebElement inputAddSubSectionL2Text;

    @FindBy(xpath = "//div[@class='autosuggestion block']//span")
    private static WebElement resultSuggestion;

    @FindBy(xpath = "//div[contains(@class,'close fl spImg')]")
    private static WebElement intoImageToClosePopUp;



    @Override
    public boolean checkIfUserIsAbleToClickOnSubSectionL2PageFromDropDowns() {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionL2Button, 30, "subSection-L2 button ");
        boolean isResult= commonFunctions.isElementDisplayed(pageSectionNameText,10,"new subSection-L2 page");
        commonFunctions.clickElement(intoImageToClosePopUp,10);
        return isResult;
    }

    @Override
    public boolean checkIfSubSectionl2PopupAppearsOnceThisOptionIsClicked() {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionL2Button, 30, "subSection-L2 button ");
        boolean isResult= commonFunctions.isElementDisplayed(subSectionL2PopUp,10,"new subSection-L2 page");
        commonFunctions.clickElement(intoImageToClosePopUp,10);
        return isResult;
    }

    public static void fillSubSectionL2DetailsInPopUp(String name,String alias){
        commonFunctions.clickElementIfDisplayed(pageSectionNameText,10,"Name field");
        commonFunctions.sendKeys(pageSectionNameText,name,10,"name field");
        commonFunctions.clickElementIfDisplayed(pageSectionAliasText,10,"Alias field");
        commonFunctions.sendKeys(pageSectionAliasText,alias,10,"Alias field");
        commonFunctions.clickElementIfDisplayed(sectionBox,10,"section box");
        commonFunctions.sendKeys(sectionBox,"UI Section",10,"section field");
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementIfDisplayed(SelectFirstOption,10,"option 1 in section");
        commonFunctions.clickElementIfDisplayed(subSectionBox,10,"section box");
        commonFunctions.sendKeys(subSectionBox,"UI Sub Section",10,"sub section field");
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementIfDisplayed(SelectFirstOption,10,"option 1 in sub section");
        commonFunctions.hardWait(10000);
    }

    @Override
    public boolean checkIfUserIsAbleToAddNameAlisaSectionAndSubsectionField(String name, String alias,String backgroundColor) {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionL2Button, 30, "subSection-L2 button ");
        fillSubSectionL2DetailsInPopUp(name,alias);
        String bgColor=commonFunctions.getBackgroundColorOfWebElement(pageCreateButton,10,"create button","background-color");
        boolean isResult= bgColor.equals(backgroundColor);
        commonFunctions.clickElement(intoImageToClosePopUp,10);
        return isResult;
    }

    @Override
    public boolean checkIfUserIsAbleToAddNameAlisaSectionAndSubsectionFieldAndCreate(String name, String alias) {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionL2Button, 30, "subSection-L2 button ");
        fillSubSectionL2DetailsInPopUp(name,alias);
        commonFunctions.hardWait(5000);
        commonFunctions.clickElementIfDisplayed(pageCreateButton,10,"create button");
        return commonFunctions.isElementDisplayed(buttonPublish,10,"publish button is ");
    }

    public void selectSubSectionL2Page(){
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionL2Button,10,"sub section button");
    }

    private void inputSubSection(String subsection) {
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 30, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "wait for Save changes text");
    }

    private void inputSubSectionL2(String subsectionL2) {
        commonFunctions.sendKeys(inputAddSubSectionL2Text, subsectionL2, 30, "sub-section L2 box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionL2Text, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "wait for Save changes text");
    }

    private void openStandardStory() {
        commonFunctions.clickElement(appLogo);
        commonFunctions.hardWait(2000);
        commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectStory, 30, " standard story button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    private String selectSection(WebElement sectionBox, WebElement selectFirstOption) {
        commonFunctions.clickElementIfDisplayed(sectionBox,10,"section box");
        commonFunctions.sendKeys(sectionBox,"UI Section",10,"section field");
        String sectionText=commonFunctions.getElementText(SelectFirstOption,10);
        commonFunctions.clickElementIfDisplayed(SelectFirstOption,10,"option 1 in section");
        return sectionText;
    }

    private String selectSubSection(WebElement SubSectionBox, WebElement selectFirstOption) {
        commonFunctions.clickElementIfDisplayed(subSectionBox,10,"sub section box");
        commonFunctions.sendKeys(subSectionBox,"UI Sub Section",10,"sub section field");
        String sectionText=commonFunctions.getElementText(SelectFirstOption,10);
        commonFunctions.clickElementIfDisplayed(SelectFirstOption,10,"option 1 in section");
        return sectionText;
    }

    @Override
    public boolean SubSectionPageAndCheckThatInANewStdStorySubSectionField(String name, String alias) {
        boolean result=false;
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(subSectionButton,10,"sub section button");
        commonFunctions.clickElementIfDisplayed(pageSectionNameText,10,"Name field");
        name=name+commonFunctions.generateRandomNum();
        commonFunctions.sendKeys(pageSectionNameText,name,10,"name field");
        commonFunctions.clickElementIfDisplayed(pageSectionAliasText,10,"Alias field");
        commonFunctions.sendKeys(pageSectionAliasText,name,10,"Alias field");
        String sectionText=selectSection(sectionBox,SelectFirstOption);
        commonFunctions.clickElementIfDisplayed(pageCreateButton,10,"create button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for Save changes text");
        commonFunctions.clickElement(buttonPublish,10,"publish button");
        boolean isSubSectionPagePublished=commonFunctions.isElementDisplayedWithExceptionHandling(toastPublish,10,"publish message");
        if(isSubSectionPagePublished){
            openStandardStory();
            dashboardPage.inputSection(sectionText);
            commonFunctions.sendKeys(inputAddSubSectionText, name, 30, "sub-section box");
            result=commonFunctions.getElementTextAndCheck(resultSuggestion,name,10,"sub section result");
        }
        return result;
    }

    @Override
    public boolean SubSectionL2PageAndCheckThatInANewStdStorySubSectionL2Field(String name, String alias) {
        boolean result=false;
        selectSubSectionL2Page();
        commonFunctions.clickElementIfDisplayed(pageSectionNameText,10,"Name field");
        name=name+commonFunctions.generateRandomNum();
        commonFunctions.sendKeys(pageSectionNameText,name,10,"name field");
        commonFunctions.clickElementIfDisplayed(pageSectionAliasText,10,"Alias field");
        commonFunctions.sendKeys(pageSectionAliasText,name,10,"Alias field");
        String sectionText=selectSection(sectionBox,SelectFirstOption);
        String subSectionText=selectSubSection(subSectionBox,SelectFirstOption);
        commonFunctions.clickElementIfDisplayed(pageCreateButton,10,"create button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for Save changes text");
        commonFunctions.clickElement(buttonPublish,10);
        boolean isSubSectionPagePublished=commonFunctions.isElementDisplayedWithExceptionHandling(toastPublish,10,"publish message");
        if(isSubSectionPagePublished){
            openStandardStory();
            dashboardPage.inputSection(sectionText);
            inputSubSection(subSectionText);
            commonFunctions.sendKeys(inputAddSubSectionL2Text, name, 30, "sub-section box");
            result=commonFunctions.getElementTextAndCheck(resultSuggestion,name,10,"sub section result");
        }
        return result;
    }

    @Override
    public boolean SubSectionL2PageAndSelectThatInANewStdStorySubSectionL2Field(String name, String alias) {
        boolean result=false;
        String filedText="";
        selectSubSectionL2Page();
        commonFunctions.clickElementIfDisplayed(pageSectionNameText,10,"Name field");
        name=name+commonFunctions.generateRandomNum();
        commonFunctions.sendKeys(pageSectionNameText,name,10,"name field");
        commonFunctions.clickElementIfDisplayed(pageSectionAliasText,10,"Alias field");
        commonFunctions.sendKeys(pageSectionAliasText,name,10,"Alias field");
        String sectionText=selectSection(sectionBox,SelectFirstOption);
        String subSectionText=selectSubSection(subSectionBox,SelectFirstOption);
        commonFunctions.clickElementIfDisplayed(pageCreateButton,10,"create button");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "wait for Save changes text");
        commonFunctions.clickElement(buttonPublish,10);
        boolean isSubSectionPagePublished=commonFunctions.isElementDisplayedWithExceptionHandling(toastPublish,10,"publish message");
        if(isSubSectionPagePublished){
            openStandardStory();
            dashboardPage.inputSection(sectionText);
            inputSubSection(subSectionText);
            inputSubSectionL2(name);
            filedText=inputAddSubSectionL2Text.getAttribute("ng-reflect-model");
        }
        return filedText.equals(name);
    }
}
