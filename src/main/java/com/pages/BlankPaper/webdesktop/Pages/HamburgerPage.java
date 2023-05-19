package com.pages.BlankPaper.webdesktop.Pages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonCollectionPage;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonHamburgerPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HamburgerPage extends CommonHamburgerPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonCollectionPage CollectionPage;
    private static CommonDashboardPage dashboardPage;
    private static String sectionNameProd;
    public static String firstSectionName;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[3]//i")
    private static WebElement pagesButton;

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'External')]")
    private static WebElement pageExternalButton;

    @FindBy(css = "input[placeholder='Add page’s name here']")
    private static WebElement externalPageNameText;

    @FindBy(css = "input[placeholder='Add URL here']")
    private static WebElement externalPageExternalURLText;

    @FindBy(css = "button.add")
    private static WebElement externalPageCreateButton;

    @FindBy(xpath = "//button[contains(text(),'Hamburger')]")
    private static WebElement hamburgerButton;

    @FindBy(xpath = "//span[contains(text(),'Hamburger')]")
    private static WebElement hamburgerPageText;

    @FindBy(xpath = "//span[contains(text(),'Type')]")
    private static WebElement buttonType;

    @FindBy(xpath = "//div[@class='filterdrop block']//input[@placeholder='search text goes here']")
    private static WebElement inputSearchField;

    @FindBy(xpath = "//label[contains(text(),'EXTERNAL')]")
    private static WebElement typeExternal;

    @FindBy(xpath = "//label[contains(text(),' SECTION')]")
    private static WebElement typeSection;

    @FindBy(xpath = "//div[@id='left']//li[@value='0']//div[1]")
    private static WebElement headlineField;

    @FindBy(xpath = "//span[contains(text(),'Published')]")
    private static WebElement buttonPublished;

    @FindBy(xpath = "//td[contains(@class,'start-date')]")
    private static WebElement DateValue;

    @FindBy(className = "applyBtn")
    private static WebElement applyButtonPublished;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//span[text()='Pages']")
    private static WebElement pagesText;

    @FindBy(xpath = "//ul//li[@value='0']")
    private static WebElement firstElementSourceLeftSide;

    @FindBy(xpath = "//ul//li[@value='1']")
    private static WebElement secondElementSourceLeftSide;

    @FindBy(xpath = "//div[@class='allLiveList']")
    private static WebElement elementTarget;

    private static String elementsTargetXpath = "//div[@class='allLiveList']//li[@type='SECTION']";

    private static String elementSectionName = "//div[contains(@class,'livePage')]//div[contains(@class,'heading pin')]//span[text()[contains(., '')]]/following-sibling::text()[contains(.,'%s')]";

    private static String deleteButtons = "(//i[@class='icon-delete'])[3]";

    @FindBy(xpath = "//div[contains(@class,'allLiveList')]//li[@value='2']//div[contains(@class,'heading pin')]")
    private static WebElement elementTargetHeadline;

    @FindBy(className = "search-components")
    private static WebElement searchStory;

    @FindBy(xpath = "//h4[text()='Section Line-up']")
    private static WebElement sectionLine_upText;

    @FindBy(xpath = "//div[contains(@class,'livePage')]//div")
    private static WebElement sectionLine_upColumn;

    @FindBy(xpath = "//ul//li[@value='0']//span[contains(@class,'viewEye')]")
    private static WebElement viewEye;

    @FindBy(css = "input[placeholder='Add page name here…']")
    private static WebElement metadataSectionName;

    @FindBy(className = "icon-delete")
    private static WebElement buttonDeleteStories;

    @FindBy(xpath = "//span[contains(text(),'ALL CHANGES ARE SAVED')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//div[@id='right']//li[@value='1']")
    private static WebElement secondElementSourceRightSide;

    @FindBy(xpath = "//div[@id='right']//li[@value='0']")
    private static WebElement firstElementTargetRightSide;

    @FindBy(xpath = "//div[@id='right']//li[@value='0']//div[contains(@class,'heading pin')]")
    private static WebElement firstElementHeadlineRightSide;

    @FindBy(xpath = "//div[@id='right']//li[@value='1']//div[contains(@class,'heading pin')]")
    private static WebElement secondElementHeadlineRightSide;

    @FindBy(xpath = "//button[contains(text(),'Publish')]")
    private static WebElement buttonPublish;

    @FindBy(xpath = "//div[contains(text(),'published successfully')]")
    private static WebElement publishToasterMassageHamburger;

    @FindBy(xpath = "//h4[text()='All Topics & Sections']")
    private static WebElement allTopicsAndSectionText;

    @FindBy(xpath = "//div[contains(@class,'allContent')]")
    private static WebElement allTopicsAndSectionColumn;

    @FindBy(xpath = "//li[@class='name']//div[@class='listCell']")
    private static List<WebElement> pageElementNameList;

    @FindBy(xpath = "(//div[@id='left']//span[@class='sectioncollection'])[1]")
    private static WebElement hamburgerPageTypeName;

    @FindBy(xpath = "//input[contains(@class,'search')]")
    private static WebElement searchAllElementsText;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result')]")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "(//div[@class='form']//input[contains(@class,'textBox')])[3]")
    private static WebElement sectionNameBox;

    @FindBy(xpath = "//div[contains(text(),'published successfully')]")
    private static WebElement popupPublishSectionButton;

    private static String sectionLineUpSectionName = "//div[@class='allLiveList']//li//div[@class='heading pin']";




    public HamburgerPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        CollectionPage = CommonCollectionPage.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    @Override
    public boolean clickOnPages() {
        boolean isDisplayed;
        commonFunctions.clickElement(pagesButton, 10, "Page Label");
        isDisplayed = commonFunctions.checkElementText(pagesText, "Pages", 20, "Pages text ");
        return isDisplayed;
    }

    private boolean openHamburgerPage() {
        boolean isDisplayed;
        commonFunctions.clickElement(hamburgerButton, 20, "Hamburger Button");
        //ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        //commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isDisplayed = commonFunctions.checkElementText(hamburgerPageText, "Hamburger", 20, "hamburger Page Text ");
        return isDisplayed;
    }

    @Override
    public boolean typeFilter(String type, String pageSectionName) {
        boolean isTypeDisplayed;
        commonFunctions.clickElementWithJS(pagesButton, 20, "Page field");
        if (globalVars.isProdRun()) {
            dashboardPage.applyTypeFilterOnDashboard("Section");
            dashboardPage.applyStatusFilterOnPages("Published");
            pageSectionName = commonFunctions.getElementText(pageElementNameList.get(0), 20);
            sectionNameProd = pageSectionName;
        }

        openHamburgerPage();
        commonFunctions.clickElementWithJS(buttonType, 20, "Type  filter");
        commonFunctions.sendKeysOnElementVisibility(inputSearchField, type, 20, "Type filter");
        commonFunctions.clickElementIgnoringStaleElement(typeSection, 20, "Type SECTION select");
        commonFunctions.clickElementIgnoringStaleElement(buttonType, 20, "Type  filter");
//        String pSectionName =pageSectionName.toLowerCase();
        //isTypeDisplayed=  commonFunctions.waitAndGetElementTextAndCheck(headlineField,pSectionName,30,"headline");
        commonFunctions.waitAndGetElementTextAndCheck(hamburgerPageTypeName,type.toUpperCase(),30,"section name");
        String actualSectionName=commonFunctions.waitAndGetElementTextIgnoringStaleElement(headlineField, 30,"Type filter Headline");
        isTypeDisplayed=actualSectionName.equalsIgnoreCase(pageSectionName);
//        isTypeDisplayed = commonFunctions.waitAndGetElementTextAndCheck(headlineField, pageSectionName, 20, "Type filter Headline ");
        return isTypeDisplayed;
    }

    @Override
    public boolean publishedFilter(String pageSectionName) {
        boolean isDisplayed;
        if (globalVars.isProdRun()) {
            pageSectionName = sectionNameProd;
        }
        commonFunctions.clickElementIfDisplayed(buttonPublished, 30, "Published Filter ");
        commonFunctions.doubleClick(DateValue, 30, "Date");
        commonFunctions.clickElementIgnoringStaleElement(applyButtonPublished, 20, "Apply button ");
        //isDisplayed = commonFunctions.checkElementTextIgnoringStaleElement(headlineField, pageSectionName, 20, "Published filter ");
        String actualSectionName=commonFunctions.waitAndGetElementTextIgnoringStaleElement(headlineField, 30,"headline name");
        isDisplayed=actualSectionName.equalsIgnoreCase(pageSectionName);
        //isDisplayed = commonFunctions.checkElementTextIgnoringStaleElement(headlineField, pageSectionName, 20, "Published filter ");
        return isDisplayed;
    }

    @Override
    public boolean dragAndDrop(String type, String pageSectionName) {
        boolean isDragAndDropVerify = false;
        typeFilter(type, pageSectionName);
        commonFunctions.dragAndDrop(firstElementSourceLeftSide, elementTarget, 10, "Drag And Drop External");
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        List<WebElement> elements = driver.findElements(By.xpath(elementsTargetXpath));
        for (WebElement webElement : elements) {
            String headlines = webElement.getText().trim();
            if (headlines.contains(pageSectionName)) {
                isDragAndDropVerify = true;
                Utils.logStepInfo(true, "DragAndDrop  name: " + pageSectionName + " matched successfully");
                break;
            }else {
                isDragAndDropVerify = false;
                Utils.logStepInfo(false, "DragAndDrop  name: " + pageSectionName + " not matched ");
            }
        }
        return isDragAndDropVerify;
    }

    @Override
    public boolean searchOnHamburgerPage(String pageSectionName) {
        boolean isDisplayed;
        commonFunctions.clickElementWithJS(pagesButton, 20, "Page field");
        if (globalVars.isProdRun()) {
            commonFunctions.refreshPage();
            dashboardPage.applyTypeFilterOnDashboard("Section");
            dashboardPage.applyStatusFilterOnPages("Published");
            pageSectionName = commonFunctions.getElementText(pageElementNameList.get(0), 20);
            sectionNameProd = pageSectionName;
        }
        openHamburgerPage();
        commonFunctions.sendKeys(searchStory, pageSectionName, 20, "Search story and elements box ");
        commonFunctions.sendKeysWithEnter(searchStory, 10);
        commonFunctions.waitAndGetElementTextAndCheck(hamburgerPageTypeName,"SECTION",30,"section name");
        String actualSectionName=commonFunctions.waitAndGetElementTextIgnoringStaleElement(headlineField, 20,"headline");
        isDisplayed=actualSectionName.equalsIgnoreCase(pageSectionName);
        return isDisplayed;
    }

    @Override
    public boolean hamburgerPageSectionLineUp() {
        openHamburgerPage();
        commonFunctions.isElementDisplayedWithoutTryCatch(sectionLine_upText, 30, "section line-up text");
        return commonFunctions.isElementPresent(sectionLine_upColumn, 30);
    }

    @Override
    public boolean hamburgerPagePreviewOfIcon(String pageSectionName) {
        searchOnHamburgerPage(pageSectionName);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(viewEye, 10, "Preview button");
        return commonFunctions.getAttributeValue(metadataSectionName, 30, "id").equals(pageSectionName);
    }

    @Override
    public boolean dragAndDropDelete(String type, String pageSectionName) {
        boolean isVerify;
        typeFilter(type, pageSectionName);
        commonFunctions.dragAndDrop(firstElementSourceLeftSide, elementTarget, 10, "Drag And Drop External");
        isVerify = commonFunctions.clickElementIfDisplayed(String.format(deleteButtons, pageSectionName), 30);
        if (isVerify &=!commonFunctions.isElementDisplayedAndPresent(String.format(elementSectionName, pageSectionName), 20, "section name")) {
            isVerify =true;
            Utils.logStepInfo(true, "section name: " + pageSectionName + " deleted successfully");
        }else {
            isVerify=false;
            Utils.logStepInfo(false, "section name: " + pageSectionName + " Not deleted !!!!!");

        }
        return isVerify;
    }

    @Override
    public boolean upAndDownPosition(String pageSectionName, String pageSectionAlias, String pageSectionName1, String pageSectionAlias1) {
        boolean isDisplayed = false;
        openHamburgerPage();
        List<WebElement> elements = driver.findElements(By.xpath(elementsTargetXpath));
        int length = elements.size();
        if (length >= 2) {
            String[] secondHeadline = commonFunctions.getElementText(secondElementHeadlineRightSide, 20).split("\\R");
            String headline2 = secondHeadline[secondHeadline.length - 1];
            commonFunctions.dragAndDrop(secondElementSourceRightSide, firstElementTargetRightSide, 30, "Drag And Drop  Right Side");
            String[] FirstHeadline = commonFunctions.getElementText(firstElementHeadlineRightSide, 20).split("\\R");
            String headline1 = FirstHeadline[FirstHeadline.length - 1];
            if (headline1.equals(headline2)) {
                isDisplayed = true;
                Utils.logStepInfo(true, "Up and Down section name: " + headline2 + " :: " + headline1 + " :matched successfully");
            }
        } else if (length <= 1) {
            CollectionPage.createAndPublishPageSection(pageSectionName, pageSectionAlias);
            CollectionPage.createAndPublishPageSection(pageSectionName1, pageSectionAlias1);
            commonFunctions.closeAllWindowsExceptMasterTabOnly();
            openHamburgerPage();
            commonFunctions.dragAndDrop(firstElementSourceLeftSide, elementTarget, 30, "Drag And Drop first section");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
            commonFunctions.dragAndDrop(secondElementSourceLeftSide, elementTarget, 30, "Drag And Drop second section");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
            String[] secondHeadline = commonFunctions.getElementText(secondElementHeadlineRightSide, 20).split("\\R");
            String headline2 = secondHeadline[secondHeadline.length - 1];
            commonFunctions.dragAndDrop(secondElementSourceRightSide, firstElementTargetRightSide, 10, "Drag And Drop  Right Side");
            String[] FirstHeadline = commonFunctions.getElementText(firstElementHeadlineRightSide, 20).split("\\R");
            String headline1 = FirstHeadline[FirstHeadline.length - 1];
            if (headline1.equals(headline2)) {
                isDisplayed = true;
                Utils.logStepInfo(true, "Up and Down section name: " + headline2 + " :: " + headline1 + " :matched successfully");
            }
        }
        return isDisplayed;
    }

    @Override
    public boolean publishHamburgerPage(String type, String pageSectionName) {
        dragAndDrop(type, pageSectionName);
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish button on hamburger page");
        return commonFunctions.isElementDisplayedWithoutTryCatch(publishToasterMassageHamburger, 50, "Publish toaster");
    }

    @Override
    public boolean allTopicsAndSection() {
        openHamburgerPage();
        commonFunctions.isElementDisplayedWithoutTryCatch(allTopicsAndSectionText, 30, "all Topics And Section Text");
        return commonFunctions.isElementDisplayedWithoutTryCatch(allTopicsAndSectionColumn, 30, "all Topics And Section Column");
    }

    @Override
    public boolean editAndRefreshPage(String sectionName) {
        boolean isNotDisplay, isVerify;
        isVerify = commonFunctions.clickForElementIgnoringStaleElement(String.format(deleteButtons, sectionName), 50, "delete button");
        commonFunctions.refreshPage();
        if (isNotDisplay = !commonFunctions.isElementDisplayedAndPresent(String.format(elementSectionName, sectionName), 50, "section name")) {
            isNotDisplay = true;
            Utils.logStepInfo(true, "Section name: " + sectionName + " deleted successfully");
        }else {
            isNotDisplay = false;
            Utils.logStepInfo(false, "Section name: " + sectionName + " Not deleted !!!!!! ");
        }
        return isVerify && isNotDisplay;
    }

    @Override
    public boolean deleteSection(String pageSectionName) {
        boolean isVerify = true;
//        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.clickElementWithJS(pagesButton, 30, " Pages button ");
        openHamburgerPage();
        isVerify &= commonFunctions.clickElementIfDisplayed(String.format(deleteButtons, pageSectionName), 30);
        isVerify &= commonFunctions.elementIsNotPresent(String.format(elementSectionName, pageSectionName), 20, "section name");
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish button on hamburger page");
        isVerify &=  commonFunctions.isElementDisplayedWithoutTryCatch(publishToasterMassageHamburger, 50, "Publish toaster");
        commonFunctions.clickElementWithJS(pagesButton, 30, "Pages Label");
        return isVerify;
    }

    @Override
    public boolean editSectionName(String pageSectionName,String newSectionName) {
        boolean isDisplayed;
        commonFunctions.clickElementWithJS(pagesButton, 30, " Pages button ");
        commonFunctions.sendKeysIgnoringStaleElement(searchAllElementsText,pageSectionName , 30, "search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText, 30);
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 35, "singleRecordConformation");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 25, "story list item");
        commonFunctions.sendKeysOnElementVisibility(sectionNameBox, newSectionName, 30, "new Section Name ");
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish section page");
        isDisplayed = commonFunctions.isElementDisplayedAndPresent(popupPublishSectionButton, 20, "Publish toaster");
        return isDisplayed;
    }

    @Override
    public boolean deleteCreatedSection(String pageSectionName) {
        boolean isVerify = true;
        try {
            commonFunctions.clickElementWithJS(pagesButton, 30, " Pages button ");
            openHamburgerPage();
            isVerify &= commonFunctions.clickElementIfDisplayed(String.format(deleteButtons, pageSectionName), 30);
            isVerify &= commonFunctions.elementIsNotPresent(String.format(elementSectionName, pageSectionName), 20, "section name");
            commonFunctions.clickElementWithJS(buttonPublish, 20, "publish button on hamburger page");
            isVerify &= commonFunctions.isElementDisplayedWithoutTryCatch(publishToasterMassageHamburger, 50, "Publish toaster");
            commonFunctions.clickElementWithJS(pagesButton, 30, "Pages Label");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isVerify;
    }

    @Override
    public boolean sectionNameUpAndDownPosition(String pageSectionName, String pageSectionAlias,String pageSectionName1,String pageSectionAlias1){
        boolean isDisplayed = false;
        openHamburgerPage();
        List<WebElement> elements = driver.findElements(By.xpath(sectionLineUpSectionName));
        int length = elements.size();
        if (length >= 2) {
            String[] secondHeadline = commonFunctions.getElementText(secondElementHeadlineRightSide, 20).split("\\R");
            String headline2 = secondHeadline[secondHeadline.length - 1];
            commonFunctions.dragAndDrop(secondElementSourceRightSide, firstElementTargetRightSide, 30, "Drag And Drop  Right Side");
            String[] FirstHeadline = commonFunctions.getElementText(firstElementHeadlineRightSide, 20).split("\\R");
            String headline1 = FirstHeadline[FirstHeadline.length - 1];
            if (headline1.equals(headline2)) {
                isDisplayed = true;
                Utils.logStepInfo(true, "Up and Down section name: " + headline2 + " :: " + headline1 + " :matched successfully");
            } else {
                isDisplayed = false;
                Utils.logStepInfo(false, "Up and Down section name: " + headline2 + " :: " + headline1 + " :not matched ");
            }
            String[] firstIndex = driver.findElements(By.xpath(sectionLineUpSectionName)).get(0).getText().trim().split("\\R");
            firstSectionName = firstIndex[firstIndex.length - 1];
            System.out.println("first position section name on Hamburger page:" + firstSectionName);
            commonFunctions.clickElementWithJS(buttonPublish, 20, "publish button on hamburger page");
            isDisplayed &=  commonFunctions.isElementDisplayedWithoutTryCatch(publishToasterMassageHamburger, 50, "Publish toaster");
        }
        else if (length <= 1) {
            CollectionPage.createAndPublishPageSection(pageSectionName, pageSectionAlias);
            CollectionPage.createAndPublishPageSection(pageSectionName1, pageSectionAlias1);
            commonFunctions.closeAllWindowsExceptMasterTabOnly();
            commonFunctions.clickElementWithJS(pagesButton, 20, "Page field");
            openHamburgerPage();
            commonFunctions.dragAndDrop(firstElementSourceLeftSide, elementTarget, 30, "Drag And Drop first section");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
            commonFunctions.dragAndDrop(secondElementSourceLeftSide, elementTarget, 30, "Drag And Drop second section");
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
            String[] secondHeadline = commonFunctions.getElementText(secondElementHeadlineRightSide, 20).split("\\R");
            String headline2 = secondHeadline[secondHeadline.length - 1];
            commonFunctions.dragAndDrop(secondElementSourceRightSide, firstElementTargetRightSide, 10, "Drag And Drop  Right Side");
            String[] FirstHeadline = commonFunctions.getElementText(firstElementHeadlineRightSide, 20).split("\\R");
            String headline1 = FirstHeadline[FirstHeadline.length - 1];
            if (headline1.equals(headline2)) {
                isDisplayed = true;
                Utils.logStepInfo(true, "Up and Down section name: " + headline2 + " :: " + headline1 + " :matched successfully");
            } else {
                isDisplayed = false;
                Utils.logStepInfo(false, "Up and Down section name: " + headline2 + " :: " + headline1 + " :not matched ");
            }
            String[] firstIndex = driver.findElements(By.xpath(sectionLineUpSectionName)).get(0).getText().trim().split("\\R");
            firstSectionName = firstIndex[firstIndex.length - 1];
            System.out.println("first position section name on Hamburger page:" + firstSectionName);
            commonFunctions.clickElementWithJS(buttonPublish, 20, "publish button on hamburger page");
            isDisplayed &= commonFunctions.isElementDisplayedWithoutTryCatch(publishToasterMassageHamburger, 50, "Publish toaster");
        }
        return isDisplayed;
    }

}

