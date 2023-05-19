package com.pages.BlankPaper.webdesktop.notifications;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonLoginPage;
import com.pages.BlankPaper.genericPages.CommonNotificationsPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationsPage extends CommonNotificationsPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String storyIdNumber;
    private static CommonDashboardPage dashboardPage;
    public static Date timeOnPublishedStory;
    public static String imageSrcValue;
    public static CommonLoginPage loginPage;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//div[@class='storytype']//li//button[@class='standard' and text()='Standard']")
    private static WebElement selectStory;

    @FindBy(xpath = "//li//span[contains(@class,'created')]")
    private static WebElement allChangesSaved;

    @FindBy(xpath = "(//div[@id='enterHeadlineText']//p)[1]")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[2]/div")
    private static WebElement addSummaryText;

    @FindBy(xpath = "//p[@id='addParagraphText']")
    private static WebElement addParagraphText;

    @FindBy(xpath = "//input[@placeholder='Add SubSection here.']")
    private static WebElement inputAddSubSectionText;

    @FindBy(xpath = "//ul[@id='myTags']//li[@class='tagit-new']//input[contains(@placeholder,'Byline')]")
    private static WebElement inputAddByLineText;

    @FindBy(xpath = "//input[@placeholder='Add Location here..']")
    private static WebElement inputAddLocationText;

    @FindBy(xpath = "//input[@placeholder='Add keywords here..']")
    private static WebElement inputAddKeywordText;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='blue' and text()='Save']")
    private static WebElement saveButton;

    @FindBy(xpath = "//div[@class='snotifyToast__inner']")
    private static WebElement toastSaveButton;

    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static WebElement sectionInput;

    @FindBy(xpath = "//ul[@class='leadMediaIcon']/li/span/i")
    private static WebElement imgIcon;

    @FindBy(xpath = "//div[@class='imageAction block']/div/div//span[@class='pickimageBtn']")
    private static WebElement chouseIcon;


    @FindBy(xpath = "(//div[@class='imagecontain']/img)[1]")
    private static WebElement recentImage;

    @FindBy(xpath = "(//button[@class='blue' and contains(text(), 'Use')])[1]")
    private static WebElement useImage;

    @FindBy(xpath = "//button[@id='buttonCropingDone']")
    private static WebElement doneButton;

    @FindBy(xpath = "(//div[@class='snotifyToast__buttons']/button)[1]")
    private static WebElement yesButton;

    @FindBy(xpath = "//button[@name='saveStory']")
    private static WebElement saveImageButton;

    @FindBy(xpath = "//button[@id='buttonPublish']")
    private static WebElement publishButton;

    @FindBy(xpath = "(//div[@id='storiesListing']/div)[1]/ul/div/li")
    private static List<WebElement> resultList;

    @FindBy(xpath = "//input[@id='searchAllStoriesText']")
    private static WebElement searchTextBox;

    @FindBy(xpath = "//span[@id='exactAllStoriesButton']")
    private static WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(), 'Send Notification')]")
    private static WebElement sendNotificationLink;

    @FindBy(xpath = "//button[@name='send']")
    private static WebElement sendButton;

    @FindBy(xpath = "//*[contains(text(), 'MoEngage Notification Sent Successfully')]")
    private static WebElement notificationSuccessMessage;


    public NotificationsPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    public boolean checkThatUserIsAbleToSendNotificationsForTamilTenants(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Tamil", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        List<String> value=commonFunctions.createStoryForNotification(headline, summary,  paragraph,  subsection,  byline,
                keyword, location,
                allChangesSaved,  enterHeadlineText,  addSummaryText,
                addParagraphText,  inputAddSubSectionText,  inputAddByLineText,
                inputAddLocationText,  inputAddKeywordText,
                saveButton,  toastSaveButton);
        String storyId=value.get(1);
        String heading=value.get(0);
        String[] headingArray = heading.split(" ");
        heading = headingArray[0];
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(5);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Tamil", "tenant");
        commonFunctions.selectStory(heading, searchTextBox, searchButton, resultList);
        commonFunctions.isElementDisplayed(sendNotificationLink, 10, "Send Notification Link");
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "Send Notification Link");

        commonFunctions.isElementDisplayed(sendButton, 10, "Send Button");
        commonFunctions.clickElementWithJS(sendButton, 10, "Send Button");
        return commonFunctions.isElementDisplayed(notificationSuccessMessage, 10, "Notification Success Message");

    }

    public boolean checkThatUserIsAbleToSendNotificationsForMarathiTenants(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Marathi", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        List<String> value=commonFunctions.createStoryForNotification(headline, summary,  paragraph,  subsection,  byline,
                keyword, location,
                allChangesSaved,  enterHeadlineText,  addSummaryText,
                addParagraphText,  inputAddSubSectionText,  inputAddByLineText,
                inputAddLocationText,  inputAddKeywordText,
                saveButton,  toastSaveButton);
        String storyId=value.get(1);
        String heading=value.get(0);
        String[] headingArray = heading.split(" ");
        heading = headingArray[0];
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(5);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Marathi", "tenant");
        commonFunctions.selectStory(heading, searchTextBox, searchButton, resultList);
        commonFunctions.isElementDisplayed(sendNotificationLink, 10, "Send Notification Link");
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "Send Notification Link");

        commonFunctions.isElementDisplayed(sendButton, 10, "Send Button");
        commonFunctions.clickElementWithJS(sendButton, 10, "Send Button");
        return commonFunctions.isElementDisplayed(notificationSuccessMessage, 10, "Notification Success Message");

    }

    public boolean checkThatUserIsAbleToSendNotificationsForTeluguTenants(String headline, String summary, String paragraph, String byline, String section, String subsection, String keyword, String location){
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Telugu", "tenant");
        selectStandardStory();
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        inputSection(section);
        List<String> value=commonFunctions.createStoryForNotification(headline, summary,  paragraph,  subsection,  byline,
                keyword, location,
                allChangesSaved,  enterHeadlineText,  addSummaryText,
                addParagraphText,  inputAddSubSectionText,  inputAddByLineText,
                inputAddLocationText,  inputAddKeywordText,
                saveButton,  toastSaveButton);
        String storyId=value.get(1);
        String heading=value.get(0);
        String[] headingArray = heading.split(" ");
        heading = headingArray[0];
        commonFunctions.selectImage(imgIcon, chouseIcon, recentImage, useImage, doneButton, yesButton, saveImageButton);
        commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
        commonFunctions.clickElement(publishButton, 10, "Publich Button");
        commonFunctions.dummyWait(5);
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.refreshPage();
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "Telugu", "tenant");
        commonFunctions.selectStory(heading, searchTextBox, searchButton, resultList);
        commonFunctions.isElementDisplayed(sendNotificationLink, 10, "Send Notification Link");
        commonFunctions.clickElementWithJS(sendNotificationLink, 10, "Send Notification Link");

        commonFunctions.isElementDisplayed(sendButton, 10, "Send Button");
        commonFunctions.clickElementWithJS(sendButton, 10, "Send Button");
        return commonFunctions.isElementDisplayed(notificationSuccessMessage, 10, "Notification Success Message");

    }

    private void selectStandardStory() {
        commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        commonFunctions.clickElementWithJS(selectStory, 30, " standard story button");
    }

    private void inputSection(String section) {
        dashboardPage.inputSection(section);
    }
}
