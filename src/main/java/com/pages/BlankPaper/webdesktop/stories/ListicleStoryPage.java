package com.pages.BlankPaper.webdesktop.stories;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonListicleStoryPage;
import com.pages.BlankPaper.genericPages.CommonLoginPage;
import com.pages.BlankPaper.genericPages.CommonStandardStoryPage;
import com.utils.DbUtils;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class ListicleStoryPage extends CommonListicleStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;
    public static String imageSrcValue;
    public static CommonLoginPage loginPage;
    public static DbUtils dbUtils;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(id = "selectListicle")
    private static WebElement selectStory;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[2]/div")
    private static WebElement addSummaryText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[3]/div/p")
    private static WebElement addParagraphText;

    @FindBy(id = "inputAddSubSectionText")
    private static WebElement inputAddSubSectionText;

    @FindBy(id = "textAllChangesSaved")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(id = "inputAddByLineText")
    private static WebElement inputAddByLineText;

    @FindBy(id = "inputAddTopicText")
    private static WebElement inputAddTopicText;

    @FindBy(xpath = "//li[contains(@class,'active')]")
    private static WebElement topicValueSelect;

    @FindBy(id = "inputAddKeywordText")
    private static WebElement inputAddKeywordText;

    @FindBy(id = "saveButton")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(id = "inputAddLocationText")
    private static WebElement inputAddLocationText;

    @FindBy(id = "buttonPublish")
    private static WebElement buttonPublish;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement buttonYes;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement popupPublishButton;

    @FindBy(xpath = "//span[@id='storyUrl']/..")
    private static WebElement generatedUrl;

    public ListicleStoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
        dbUtils = DbUtils.getInstance();
    }

    @Override
    public boolean checkUserCanCreateListicleStoryWithHindustanAffiliateTenant(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        return createListicleStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
    }

    @Override
    public boolean checkIfUserCanCreateListicleStory(String property, String headLine, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location, String topic) {
        boolean isResult=createListicleStory(headLine, summary, paragraph, byline, section, subsection, keyword, location, topic);
        if(isResult){
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElementViewAndClick(generatedUrl,10,"url generated");
            Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3);
            if(windowsList.size()==3) return true;
        }
        return false;
    }

    public boolean createListicleStory(String headLine, String summary, String paragraph, String byline, String section, String subsection, String  keyword, String  location, String  topic){
        selectListicleStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputHeadline(headLine);
        inputSummary(summary);
        inputParagraph(paragraph);
        inputSection(section);
        inputSubSection(subsection);
        inputByLine(byline);
        inputTopic(topic);
        inputKeywords(keyword);
        inputLocation(location);
        saveStandardStoryAndVerify();
        setStoryId();
        commonFunctions.clickElementWithJS(buttonPublish, 20, "publish story");
        if(commonFunctions.isElementPresentWithTryCatch(buttonYes, 3)) {
            commonFunctions.clickElement(buttonYes, 10, "Yes Button");
        }
        return commonFunctions.isElementPresent(popupPublishButton, 20);
    }

    private void selectListicleStory() {
        commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectStory, 30, "Listicle story button");
    }

    private void inputHeadline(String headline) {
        commonFunctions.isElementDisplayedAndPresent(enterHeadlineText, 20, "headline field");
        commonFunctions.sendKeyWithActions(enterHeadlineText, headline);
    }

    private void inputSummary(String summary) {
        commonFunctions.sendKeys(addSummaryText, summary, 25, "summary box");
    }

    private void inputParagraph(String paragraph) {
        commonFunctions.isElementDisplayedAndPresent(addParagraphText, 30, "paragraph");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        commonFunctions.sendKey(addParagraphText, paragraph, 25);
        commonFunctions.checkElementTextWithTryCatch(allChangesSaved, "SAVING CHANGES...",7, "wait for saving changes ");
        commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "all changes are saved");
        //commonFunctions.sendKey(addParagraphText, paragraph);
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }

    private void inputSubSection(String subsection) {
        commonFunctions.sendKeys(inputAddSubSectionText, subsection, 30, "sub-section box");
        commonFunctions.sendKeysWithEnter(inputAddSubSectionText, 10);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 30, "wait for Save changes text");
    }

    private void inputByLine(String byline) {
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for changes saved label ");
        commonFunctions.sendKeyBoolean(inputAddByLineText, byline, 20, "byline box");
        commonFunctions.sendKeysWithEnter(inputAddByLineText, 20);
    }

    private void inputTopic(String topic) {
        String actualText=null;
        if(!globalVars.getBpTenant().equalsIgnoreCase("Live Mint") && !globalVars.getBpTenant().equalsIgnoreCase("Tech")) {
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
            if (commonFunctions.isElementDisplayedAndPresent(inputAddTopicText, 20, "topic box")) {
                commonFunctions.clickElementIfDisplayed(inputAddTopicText,10,"Topic input box");
                commonFunctions.sendKeyWithActions(inputAddTopicText, topic);
                //commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
                //commonFunctions.clickElementWithJS(topicValueSelect, "Topic Value Click", 10);
                commonFunctions.isElementDisplayed(topicValueSelect, 30, "topic text") ;
                actualText=commonFunctions.getElementText(topicValueSelect,20);
                if(actualText.equalsIgnoreCase(topic))
                    commonFunctions.clickElementWithJS(topicValueSelect,20,"topic value");
            }
        }
    }

    private void inputKeywords(String keyword) {
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 50, "Correct text is");
        commonFunctions.sendKeys(inputAddKeywordText, keyword, 20, "keyword box");
        commonFunctions.sendKeysWithEnter(inputAddKeywordText, 10);
    }

    private void saveStandardStoryAndVerify() {
        commonFunctions.clickElement(saveButton, 30, "save story button");
        commonFunctions.isElementDisplayed(toastSaveButton, 20, "Toast message for saved status is");
    }

    private void inputLocation(String location) {
        if (commonFunctions.isElementDisplayedAndPresent(inputAddLocationText, 5, "location box")) {
            commonFunctions.sendKeys(inputAddLocationText, location, 20, "location box");
            commonFunctions.sendKeysWithEnter(inputAddLocationText, 10);
            commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 20, "Correct text is");
        }
    }

    public void setStoryId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        storyIdNumber = id[id.length - 1];
        System.out.println("STORY ID:" + storyIdNumber);
    }

}
