package com.pages.BlankPaper.webdesktop.Pages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonSectionPage;
import com.pages.BlankPaper.genericPages.CommonTopicPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopicPage extends CommonTopicPage {

    private static CommonSectionPage sectionPage;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static SubSectionPage subsectionPage = new SubSectionPage() ;

    @FindBy(css = "button.createStory")
    private static WebElement createPageButton;

    @FindBy(xpath = "//button[contains(text(),'Topic')]")
    private static WebElement topicButton;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[1]")
    private static WebElement pageTopicNameText;

    @FindBy(xpath = "(//div[contains(@class,'addUser')]//input)[2]")
    private static WebElement pageTopicAliasText;

    @FindBy(css = "button.add")
    private static WebElement pageTopicCreateButton;

    @FindBy(id = "sectionBox")
    private static WebElement sectionBox;

    @FindBy(xpath = "//li[contains(@class,'active')]//span")
    private static WebElement sectionBoxData;

    @FindBy(xpath = "//button[@disabled]")
    private static WebElement createButtonDisable;

    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[3]//i")
    private static WebElement pagesButton;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    public TopicPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        sectionPage= CommonSectionPage.getInstance();
    }

    @Override
    public boolean publishTopicPage(String topicName, String topicAlias) {
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(topicButton, 30, "Topic button ");
        commonFunctions.sendKeysOnElementVisibility(pageTopicNameText, topicName, 30, "Page topic Name ");
        commonFunctions.sendKeysOnElementVisibility(pageTopicAliasText, topicAlias, 30, "Page topic Alias ");
        commonFunctions.clickElementWithJS(sectionBox, 30, "topic section name");
        commonFunctions.clickElementWithJS(sectionBoxData, 30, "topic section value");
        commonFunctions.clickElementWithJS(pageTopicCreateButton,30,"Create button ");
        return subsectionPage.publish();
    }

    @Override
    public boolean allValidationToCreateTopicPage(String topicName, String topicAlias) {
        boolean isDisable, isShowing;
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page");
        commonFunctions.clickElementWithJS(topicButton, 30, "topic button ");
        commonFunctions.sendKeysOnElementVisibility(pageTopicNameText, topicName, 30, "Page topic Name");
        isDisable = commonFunctions.isElementDisplayedWithoutTryCatch(createButtonDisable, 30, "disable create button");
        commonFunctions.sendKeysOnElementVisibility(pageTopicAliasText, topicAlias, 30, "Page topic Alias");
        isDisable = isDisable && commonFunctions.isElementDisplayedWithoutTryCatch(createButtonDisable, 30, "disable create button");
        commonFunctions.clickElementWithJS(sectionBox, 30, "topic section name box");
        commonFunctions.clickElementWithJS(sectionBoxData, 30, "topic section value");
        isShowing = subsectionPage.createPageAndValidate(topicName);
        return isDisable && isShowing;
    }

    @Override
    public boolean createDragAndDropStoryAndPublishTopic(String pageTopicName, String pageTopicAlias,String section, String headline) {
        boolean isDragAndDropVerify, isPublishVerify;
        commonFunctions.clickElementWithJS(pagesButton, 20, "Page field");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 30, "Create a Page ");
        commonFunctions.clickElementWithJS(topicButton, 30, "Topic button ");
        commonFunctions.sendKeysOnElementVisibility(pageTopicNameText, pageTopicName, 30, "Page topic Name ");
        commonFunctions.sendKeysOnElementVisibility(pageTopicAliasText, pageTopicAlias, 30, "Page topic Alias ");
        commonFunctions.clickElementWithJS(sectionBox, 30, "topic section name");
        commonFunctions.sendKeys(sectionBox, section, 30, "page section name");
        commonFunctions.clickElementWithJS(sectionBoxData, 30, "section value");
        commonFunctions.clickElementWithJS(pageTopicCreateButton,30,"Create button ");
        isDragAndDropVerify= sectionPage.dragAndDropStory(headline);
        isPublishVerify = subsectionPage.publish();
        return isDragAndDropVerify && isPublishVerify;
    }

    @Override
    public boolean checkCreateTopicWithLivehindustanAffiliate(String property, String topicName, String  topicAlias){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, property, "tenant");
        commonFunctions.clickElementIgnoringStaleElement(createPageButton, 20, "Create a Page ");
        commonFunctions.clickElementWithJS(topicButton, 20, "Topic button ");
        commonFunctions.sendKeysOnElementVisibility(pageTopicNameText, topicName, 20, "Page topic Name ");
        commonFunctions.sendKeysOnElementVisibility(pageTopicAliasText, topicAlias, 20, "Page topic Alias ");
        commonFunctions.clickElementWithJS(sectionBox, 20, "topic section name");
        commonFunctions.clickElementWithJS(sectionBoxData, 20, "topic section value");
        commonFunctions.clickElementWithJS(pageTopicCreateButton,20,"Create button ");
        return subsectionPage.publish();
    }


}
