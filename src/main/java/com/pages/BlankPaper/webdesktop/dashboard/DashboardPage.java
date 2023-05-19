package com.pages.BlankPaper.webdesktop.dashboard;

import com.commonFunctions.CommonFunctionsWeb;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import com.utils.dbUtils.DbConnection;
import com.utils.dbUtils.backend.BlankPaperStoryDataBackend;
import com.utils.dbUtils.backend.highlightsData.ListicleStory;
import com.utils.dbUtils.backend.paragraphData.ParagraphInCreatedStory;
import com.utils.dbUtils.backend.postData.PostCreatedStory;
import com.utils.dbUtils.backend.videoData.VideoStory;
import com.utils.dbUtils.frontend.BlankPaperStoryData;
import com.utils.dbUtils.frontend.ListElement;
import org.bson.Document;
import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.List;

public class DashboardPage extends CommonDashboardPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    public static String  storyUrl;
    public static String  storyHeadlineText;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;
    @FindBy(xpath = "//div[@class='mlogo']/a")
    private static WebElement appLogo;
    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//div[@class='domainselect']//select[contains(@class,'select')]")
    private static WebElement dropDownForDomainsSection;
    @FindBy(xpath = "//div[contains(@class,'tabBlue')]//span[contains(text(),'My Workspace')]")
    private static WebElement myWorkspaceTab;
    @FindBy(xpath = "//div[@class='contentList']/div[@class='storyListing']")
    private static List<WebElement> storiesListing;
    @FindBy(xpath = "//span[@id='defaultOpen' and text()='All Stories']") //defaultOpen
    private static WebElement allStoriesLabelHomePage;
    @FindBy(xpath = "//span[text()='Dashboard']")
    private static WebElement dashboardLabel;
    @FindBy(xpath = "//div[@id='inputAddSectionActiveText']//span")
    private static List<WebElement> sectionInputValue;
    @FindBy(xpath = "//a[@href='/dash/workspace']")
    private static WebElement blankPaperLogo;
    @FindBy(xpath = "//span[@class='tab' and contains(text(),'Type')]") //filter[@ng-reflect-display-name='Type']
    private static WebElement typeFilter;
    @FindBy(xpath = "//label[@class='checkblock' and contains(text(),'Photo Gallery')]")
    private static WebElement typeFilterValuePhotoGallery;
    @FindBy(xpath = "//label[@class='checkblock' and contains(text(),'Live Blog')]")
    private static WebElement typeFilterValueLiveBlog;
    @FindBy(xpath = "(//label[@class='checkblock' and contains(text(),'Video')])[1]")
    private static WebElement typeFilterValueVideo;
    @FindBy(xpath = "//label[@class='checkblock' and contains(text(),'Highlights')]")
    private static WebElement typeFilterValueHighlights;
    @FindBy(xpath = "//label[@class='checkblock' and contains(text(),'Deadlink')]")
    private static WebElement typeFilterValueDeadlink;
    public static String typeFilterValueXpath = "//label[@class='checkblock' and contains(text(),'%s')]";
    @FindBy(xpath = "//label[@class='checkblock' and contains(text(),'Standard')]")
    private static WebElement typeFilterValueStandardStory;
    @FindBy(xpath = "//span[@id='moreFilter']")
    private static WebElement moreFilter;
    @FindBy(xpath = "//span[contains(@class,'morefilterdrop') and contains(text(),'less')]")
    private static WebElement lessFilter;
    @FindBy(xpath = "//span[@class='tab' and contains(text(),'Status')]")
    private static WebElement statusFilterDropdown;
    @FindBy(xpath = "(//label[@class='checkblock' and contains(text(),'Published')])[1]")
    private static WebElement statusFilterValuePublished;
    @FindBy(xpath = "(//label[@class='checkblock' and contains(text(),'Created')])[1]")
    private static WebElement statusFilterValueCreated;
    @FindBy(xpath = "(//label[@class='checkblock' and contains(text(),'Killed')])[1]")
    private static WebElement statusFilterValueKilled;
    @FindBy(xpath = "//div[@id='allStories']//descendant::input[@placeholder='Search Stories here...']")
    private static WebElement searchAllStoriesText;
    @FindBy(xpath = "//div[@id='allStories']//descendant::div['searchfilter']//span[contains(@class,'exact')]")
    private static WebElement exactAllStoriesButton;
    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;
    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;
    @FindBy(xpath = "//div[contains(text(),'No Data')]")
    private static WebElement textNoData;
    @FindBy(xpath = "//div[contains(@class,'secondaryCta')]//span[@class='threedots']")
    //div[@class='storybtnContent']//span[@class='threedots']
    private static WebElement ellipsis;
    @FindBy(xpath = "//div//descendant::button[contains(text(),'Discard Story')]")
    private static WebElement buttonDiscardStory;
    @FindBy(xpath = "//div[@class='contentList']/div[@class='storyListing']")
    private static List<WebElement> storyContentsListInPagination;
    @FindBy(xpath = "//div[@class='pagination']//descendant::li") //div[@class='pagination']//descendant::li[5]
    private static List<WebElement> lastPageInPagination;
    @FindBy(xpath = "//div[@class='revertStoryBlock']//descendant::li//button[contains(text(),'Soft')]")
    private static WebElement buttonSoftPublish;
    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    //div[@class='snotifyToast__body' and contains(text(),'Soft Published successfully')]
    private static WebElement toastSoftPublish;
    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[ contains(text(),'Yes')]")
    private static List<WebElement> buttonYesForHtNewPopup;
    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[2]//i")    //span[text()='All Elements']
    private static WebElement allElementsField;
    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//span[text()='All Elements']")
    private static WebElement allElementsText;
    @FindBy(id = "defaultOpen")
    private static WebElement elementsText;
    @FindBy(xpath = "//input[contains(@class,'search')]")
    private static WebElement searchAllElementsText;
    @FindBy(xpath = "//button[contains(text(),'Discard Element')]")
    private static WebElement buttonDiscardElement;
    @FindBy(xpath = "//section//aside[@class='leftMenu']//ul//li[3]//i/following-sibling::span")
    private static WebElement pagesButton;
    @FindBy(xpath = "(//li[@id='allCardsLink'])[4]")
    private static WebElement ReportsButton;

    @FindBy(xpath = "(//li[@id='usersLink'])[2]")
    private static WebElement UsersButton;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//span[text()='Pages']")
    private static WebElement pagesText;
    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//child::div[@class='recordList']")
    private static WebElement noOfRecordInPagination;
    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement dropDownRecordListInPagination;
    @FindBy(xpath = "//div[@class='pagination']//descendant::li[1]")
    private static List<WebElement> pageOneInPagination;
    @FindBy(xpath = "//div[@class='pagination']//descendant::li[2]")
    private static List<WebElement> pageTwoInPagination;
    @FindBy(xpath = "//div[@class='pagination']//descendant::li[3]")
    private static List<WebElement> pageThreeInPagination;
    @FindBy(css = "span.molineLink")
    private static WebElement previewMobileButton;
    @FindBy(xpath = "//div[contains(@class,'Preview')]//div[contains(@class,'close')]")
    private static WebElement previewCloseButton;
    @FindBy(css = "span.desktopLink")
    private static WebElement previewDesktopButton;
    //TODO write xpath for preview mobile and desktop headline page
    @FindBy(xpath = "")
    private static WebElement previewHeadlineText;

    @FindBy(xpath = "//div[contains(@class,'recordList')]")
    private static WebElement recordConformation;
    @FindBy(xpath = "//span[contains(@class,'created')]")
    private static WebElement textAllChangesSaved;
    @FindBy(xpath = "//span[contains(@class,'morefilter')]")
    private static WebElement moreFilterButton;
    @FindBy(xpath = "//div[contains(@class,'filterdrop ')]//input[contains(@class,'textBox')]")
    private static WebElement typeFilterSearchBox;
    @FindBy(xpath = "//div[@class='filterdrop block']//ul//label")
    private static WebElement typeFilterValue;
    @FindBy(xpath = "//label[@id='typeFilterValuePublished']")
    private static WebElement statusFilterValue;
    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li[@class='status']")
    private static WebElement storyStatus;
    @FindBy(xpath = "//span[contains(@class,'link')]")
    private static WebElement copyStoryUrl;
    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement headlineText;
    @FindBy(xpath = "//button[contains(text(),'Kill Story')]")
    private static WebElement buttonKillStory;
    @FindBy(xpath = "//textarea[contains(@placeholder,'URL')]")
    private static WebElement submitUrlForKillStory;
    @FindBy(xpath = "//div[contains(@class,'fr wid')]//button[contains(@class,'add blue')]")
    private static WebElement doneButtonForKillStory;
    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Story Killed')]")
    private static WebElement toastKillStory;
    @FindBy(xpath = "(//div[@class='contentList']//li[@class='headline spImg']//div[@class='listCell'])[1]")
    private static WebElement firstStoryHeadlineText;
    @FindBy(xpath = "//span[contains(@class,'link')]")
    private static WebElement copyTextUrl;
    @FindBy(css = "button[id=agree]")
    private static WebElement cookiesContinueButton;

    @FindBy(xpath = "//div[@id='addCaptionForImage']//div[@role='textbox'] | //div[@id='addCaptionForImage']/input")
    private static WebElement firstImageCaption;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[2]//div/p")
    private static WebElement secondImageCaption;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[3]//div/p")
    private static WebElement thirdImageCaption;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//button[@name='saveStory']")
    private static WebElement firstImageDoneButton;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[2]//button[@name='saveStory']")
    private static WebElement secondImageDoneButton;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[3]//button[@name='saveStory']")
    private static WebElement thirdImageDoneButton;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement firstImageTitle;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[3]//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement thirdImageTitle;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[2]//descendant::div[@class='editimage']//child::li[2]//child::div[@class='dataField']/input")
    private static WebElement secondImageTitle;

    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[1]")
    private static WebElement firstImage;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[2]")
    private static WebElement secondImage;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[3]")
    private static WebElement thirdImage;

    @FindBy(xpath = "(//div[contains(@tabindex,'0')])[1]//span[@class='editBtn']/i")
    private static WebElement firstEditImage;
    @FindBy(xpath = "(//div[contains(@tabindex,'0')])[3]//span[@class='editBtn']/i")
    private static WebElement thirdEditImage;
    @FindBy(xpath = "(//div[contains(@tabindex,'0')])[2]//span[@class='editBtn']/i")
    private static WebElement secondEditImage;

    @FindBy(xpath = "((//div[contains(@class,'leadimage')])[1]//input)[1] | (//div[contains(@class,'leadimage')])[1]//label[contains(@class, 'wrap')]")
    private static WebElement firstImageCaptionNameData;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[2]//label")
    private static WebElement secondImageCaptionNameData;
    @FindBy(xpath = "(//div[contains(@class,'leadimage')])[3]//label")
    private static WebElement thirdImageCaptionNameData;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Cropped successfully')]")
    private static WebElement toastCropingDone;
    @FindBy(xpath = "//input[@placeholder='Add Section here.']")
    private static WebElement inputAddSectionText;
    @FindBy(xpath = "//div[contains(@class,'autosuggestion')]//ul//span[not(contains(.,'No Results'))]")
    private static WebElement inputAddByLineSuggestionPopup;
    @FindBy(xpath = "//div[contains(@class,'imageblock')]/img")
    private static List<WebElement> imageSrcStoryPage;
    @FindBy(id = "created byFilter")
    private static WebElement createdFilter;
    @FindBy(className = "icon-add-headline")
    private static WebElement addHeadlineIcon;
    @FindBy(xpath = "//span[@class='fieldValidation']")
    private static WebElement pleaseEnterEnglishCharOnlyText;
    @FindBy(xpath = "(//li/div//textarea)[2]")
    private static WebElement landingPageHeadline;
    private static String  pleaseEnterEnglishCharOnly ="//span[@class='fieldValidation']";
    @FindBy(xpath = "//button[@class='save blue' and text()='Save']")
    private static WebElement saveButtonHeadline;
    @FindBy(xpath = "//span[@class='editBtn']/i")
    private static WebElement threeDotsFirstImage;
    @FindBy(xpath = "//button[text()='Edit']")
    private static WebElement editImage;
    @FindBy(xpath = "(//span[@class='threedots'])[4]")
    private static WebElement threeDotsSecondImage;
    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;
    @FindBy(xpath = "//span[@id='defaultOpen']" )
    private static WebElement getDefaultTabText;
    @FindBy(xpath = "//div[@id='allStories']" )
    private static WebElement allStoriesTable;
    @FindBy(xpath = "(//div[@class='headingsList'])[1]//ul/li")
    private static List<WebElement> HeadingList;

    @FindBy(xpath = "//span[@id='statusFilter']")
    private static WebElement statusFilter;

    @FindBy(xpath = "(//ul[contains(@class,'listingul')]//li/span[contains(text(),'PUBLISHED')])[1]")
    private static WebElement publishedStoryStatus;
    @FindBy(xpath = "(//em[@class='redirectLink'])[1]")
    private static WebElement reDirectLinkIcon;

    @FindBy(xpath = "(//span[@class='published']//em[@class='redirectLink'])[1]")
    private static WebElement isIconPresentAfterPublishWord;

    @FindBy(xpath = "(//div[@class='storyListing']//li[contains(@class,'headline')])[1]")
    private static WebElement publishedStory;

    @FindBy(xpath = "//span[@id='storyUrl']")
    private static WebElement generatedUrl;

    @FindBy(xpath = "(//span[@class='created'])[1]")
    private static WebElement publishedStoryStatusCreated;

    @FindBy(xpath = "(//span[@class='edited'])[1]")
    private static WebElement StoryStatusEdited;

    @FindBy(xpath = "(//span[@class='filed'])[1]")
    private static WebElement StoryStatusFiled;

    @FindBy(xpath = "(//span[@class='killed'])[1]")
    private static WebElement StoryStatusKilled;

    @FindBy(xpath = "//label[@id='typeFilterValueCreated']")
    private static WebElement statusCreated;

    @FindBy(xpath = "//label[@id='typeFilterValueEdited']")
    private static WebElement statusEdited;

    @FindBy(xpath = "//label[@id='typeFilterValueScheduled']")
    private static WebElement statusScheduled;

     @FindBy(id = "saveButton")
     private static WebElement saveButton;

    @FindBy(xpath = "//label[@id='typeFilterValueFiled']")
    private static WebElement statusFiled;

    @FindBy(xpath = "//label[@id='typeFilterValueKilled']")
    private static WebElement statusKilled;

    @FindBy(xpath = "(//li[@id='pagesLink'])[2]")
    private static WebElement PagesTab;

    @FindBy(xpath = "(//li[@id='dashboardLink'])[2]")
    private static WebElement dashboardButton;






    public DashboardPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
    }

    @Override
    public boolean navigateToHomePageDashboard() {
        boolean dashboardNavigationFlag = false;
        if (!commonFunctions.isElementDisplayedWithExceptionHandling(allStoriesLabelHomePage, 5, "All Story Label")) {
            String urlVariable=globalVars.getEnvironment()+"Url";
            String URLToNavigate=globalVars.getProp().getProperty(urlVariable).replace("login", "dash/workspace");
            commonFunctions.navigateToUrl(URLToNavigate);
            //commonFunctions.navigateToUrl("https://blankpaper-staging-mt.htmedia.in/dash/workspace");
            dashboardNavigationFlag = commonFunctions.clickElementIfDisplayed(blankPaperLogo, 5, "Dashboard Label");
        }
        return dashboardNavigationFlag;
    }

    @Override
    public void domainSelection(String domain) {
        System.out.println("Inside domain selection method");
        if (commonFunctions.isElementDisplayedWithoutTryCatch(dropDownForDomainsSection, 30, domain + " Domain is")) {
            Select dropDown = new Select(dropDownForDomainsSection);
            dropDown.selectByVisibleText(domain);
        }
    }

    @Override
    public ArrayList<String> getDropDownDomain() {
        ArrayList<String> arrayElement = new ArrayList<String>();
        Select dropDown = new Select(dropDownForDomainsSection);
        List<WebElement> listOfWebElement = dropDown.getOptions();
        for (WebElement traverseElement : listOfWebElement) {
            arrayElement.add(traverseElement.getText());
        }
        return arrayElement;
    }

    public String getElementTextParsed(WebElement element, int timeOutInSecond) {
        String text = "";
        WebDriverWait wait;
        wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        text = element.getText().trim();
        return text;
    }

    public boolean checkSelectedDomain(String checkItem) {
        List<String> listElement = new ArrayList<String>();
        String selectedDomainValue = "";
        Select dropDown = new Select(dropDownForDomainsSection);
        selectedDomainValue = dropDown.getFirstSelectedOption().getText();
        if (selectedDomainValue.toLowerCase().trim().equals(checkItem.toLowerCase().trim())) {
            Utils.logStepInfo(true, selectedDomainValue + " is selected successfully");
            return true;
        }
        return false;
    }

    @Override
    public void checkStoryType(String storyType) {
        List<String> listElement = new ArrayList<String>();
        String selectedDomainValue = "";
        commonFunctions.clickElementIfDisplayed(typeFilter, 20, "Click on 'Type' filter");
        commonFunctions.clickElementIfDisplayed(String.format(typeFilterValueXpath, storyType), 20);
        commonFunctions.clickElementIfDisplayed(typeFilter, 20, "Click on 'Type' filter");
    }

    public void sectionValue(List<WebElement> elementList,String sectionText) {
        String actualText=null;
        try {
            for(WebElement ele: elementList){
                actualText=commonFunctions.getElementText(ele,20);
                if(actualText.equalsIgnoreCase(sectionText)){
                   commonFunctions.clickElementWithJS(ele,20,"section value");
                   break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean verifyStroiesExistanceInDashboard() {
        boolean isStoriesDisplayed = false;
        int storyCount = 0;
        isStoriesDisplayed = commonFunctions.isElementDisplayedAndPresent(storiesListing, 20, "Story listing is ");
        if (isStoriesDisplayed) {
            storyCount = storiesListing.size();
            if (storyCount > 0) {
                // System.out.println("Stories list count is " + totalNoOfRecords + " for selected domain");
                Utils.logStepInfo(true, "Stories list count is " + storyCount + " for selected domain");
                isStoriesDisplayed = true;
                return isStoriesDisplayed;
            }
        } else {
            // System.out.println("Stories list count is " + totalNoOfRecords + " for selected domain");
            Utils.logStepInfo(false, "No stories are available for selected domain");
            isStoriesDisplayed = false;
        }
        return isStoriesDisplayed;
    }

    @Override
    public void clickOnDashboard() {
        commonFunctions.clickElementIfDisplayed(blankPaperLogo, 10, "Dashboard Label");
    }

    @Override
    public void applyTypeFilterOnDashboard(String storyTypeFilter) {
        String filterValueXpath = "//label[@class='checkblock' and contains(text(),'" + storyTypeFilter + "')]";
        commonFunctions.clickElement(typeFilter, 30, "type filter");

        commonFunctions.clickElementIgnoringStaleElement(filterValueXpath, 20, storyTypeFilter);

        commonFunctions.clickElement(typeFilter, 30, "type filter");
    }

    @Override
    public void applyStatusFilterOnDashboard(String statusFilter) {

        commonFunctions.clickElement(moreFilter, 15, "more filter");
        commonFunctions.clickElement(statusFilterDropdown, 15, "status filter");

        switch (statusFilter) {
            case "Published":
                commonFunctions.clickElement(statusFilterValuePublished, 20, "statusFilterValuePublished");
                break;
            case "Created":
                commonFunctions.clickElement(statusFilterValueCreated, 20, "statusFilterValuePublished");
            case "Killed":
                commonFunctions.clickElement(statusFilterValueKilled, 20, "statusFilterValueKilled");
        }
        commonFunctions.clickElement(statusFilterDropdown, 15, "status filter");
        commonFunctions.clickElement(lessFilter, 15, "less filter");
    }

    @Override
    public void clickOnBlankPaperLogo() {
        if(commonFunctions.isElementPresentWithTryCatch(saveButton, 10)) {
            commonFunctions.checkElementsTextWithTryCatch(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        }
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        if(commonFunctions.isElementPresentWithTryCatch(saveButton, 10)) {
            commonFunctions.checkElementsTextWithTryCatch(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        }
        commonFunctions.clickElementIfDisplay(appLogo, 20);
        commonFunctions.isElementPresentWithTryCatch(myWorkspaceTab,30);
    }

    @Override
    public boolean storyCleanup(String storyIdNumber) {
        boolean isDiscardStory;
        searchStoryByID(storyIdNumber);
        if (commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 15, "singleRecordConformation")) {
            commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 25, "story list item");
            discardStory();
        }
        searchStoryByID(storyIdNumber);
        isDiscardStory = commonFunctions.checkElementText(textNoData, "No Data", 30, "Correct text is");
        clearSearch();
        return isDiscardStory;
    }

    @Override
    public void searchStoryByID(String id) {
        String storyListingXpath="//div[@class='contentList']/div[@class='storyListing']";
        commonFunctions.isElementDisplayed(searchAllStoriesText, 20);

        commonFunctions.waitForElementListToAppear(storyListingXpath, 30, "story listing");
        commonFunctions.isElementDisplayedWithExceptionHandling(dropDownRecordListInPagination, 5, "pagination drop down");

        searchAllStoriesText.clear();
        commonFunctions.sendKeys(searchAllStoriesText, "id:" + id, 10, "search box");
        commonFunctions.clickElement(exactAllStoriesButton, 15, "exact icon button");
    }

    private void discardStory() {
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonDiscardStory, 10, "Discard button");
    }

    @Override
    public boolean openPublishedAndUnlockedStory(String storyType) {
        boolean stepFlag = false;
        String cssSelector = "em.publishlockedIcon";
        String cssSelectorPublished="em.publishIcon.icon-published";
        applyTypeFilterOnDashboard(storyType);
        commonFunctions.isElementDisplayedIgnoringStaleElementException(storyContentsListInPagination.get(0), 15, "pagination");
        applyStatusFilterOnDashboard("Published");
        int size=lastPageInPagination.size();
        if(size>0) {
            commonFunctions.clickElement(lastPageInPagination.get(size - 1), 15, "last page");
            //adding hard wait deliberately here as sometimes selenium clicks on the already available story before the page refreshes after clicking on last page
            try {
                Thread.sleep(3000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        for (WebElement element : storyContentsListInPagination) {
            if (!commonFunctions.checkForXpathInsideWebElement(element, cssSelector, 5) &&
                    commonFunctions.checkForXpathInsideWebElement(element, cssSelectorPublished, 5)) {
                stepFlag = commonFunctions.clickElementIgnoringStaleElement(element, 10, "unlocked story");
                break;
            }
        }
        return stepFlag;
    }

    @Override
    public boolean softPublishStory() {
        boolean isSoftPublished;
        boolean isReadabilityPopupAvailable;
        commonFunctions.clickElement(ellipsis, 10, "three dots ");
        commonFunctions.clickElement(buttonSoftPublish, 10, "soft publish button");
        isSoftPublished = commonFunctions.isElementDisplayedAndPresent(toastSoftPublish, 10, "soft publish toaster");
        if (!isSoftPublished) {
            isReadabilityPopupAvailable = commonFunctions.isElementDisplayedAndPresent(buttonYesForHtNewPopup, 7, "Popup for HTNew domain is");
            if (isReadabilityPopupAvailable) {
                commonFunctions.clickElements(buttonYesForHtNewPopup, 10, "Yes button on popup ");
                isSoftPublished = commonFunctions.checkElementText(toastSoftPublish, "Published successfully", 7, "Correct text is"); //Soft Published successfully replaced with Published successfully as in case of HighLights it comes as "Soft Published successfully" but in case of DeadLink the message comes as "Published Successfully"
            }
        }
        commonFunctions.checkElementText(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
        commonFunctions.clickElementIfDisplayed(appLogo, 20);
        return isSoftPublished;
    }

    @Override
    public boolean clickOnAllElement() {
        boolean isAllElementsDisplayed;
        if (!commonFunctions.getElementTextAndCheckIgnoringStaleElementException(elementsText, "Elements", 5, "Elements Text")) {
            String urlVariable=globalVars.getEnvironment()+"Url";
            String URLToNavigate=globalVars.getProp().getProperty(urlVariable).replace("login", "dash/elements");
            commonFunctions.navigateToUrl(URLToNavigate);
            commonFunctions.clickElementIfDisplayed(allElementsField, 30, "All Elements Label");
        }
        String text = commonFunctions.getElementText(allElementsText, 15);
        isAllElementsDisplayed = text.equalsIgnoreCase("All Elements");
        return isAllElementsDisplayed;
    }

    @Override
    public boolean elementCleanup(String elementId) {
        boolean isDiscardElement;
        commonFunctions.sendKeysIgnoringStaleElement(searchAllElementsText, "id:" + elementId, 30, "search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText, 30);
        commonFunctions.isElementDisplayedWithCatch(recordConformation, 30);

        if (commonFunctions.isElementDisplayedWithCatch(singleRecordConformation, 10)) { //searchElementByID(elementId)
            //commonFunctions.isElementDisplayed(singleRecordConformation, 10, "Single record");
            commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 15, "Element list item");
            commonFunctions.clickElementWithJS(ellipsis, 10, "Three dot button");
            commonFunctions.clickElement(buttonDiscardElement, 15, "discard element button");
            commonFunctions.waitForElementToBeInvisibleWithCatch(ellipsis, 10);
            clickOnAllElement();
            searchElementByID(elementId);
        }
        isDiscardElement = commonFunctions.checkElementTextWithTryCatch(textNoData, "No Data", 15, "Correct text is");
        return isDiscardElement;
    }

    @Override
    public boolean searchElementByID(String id) {
        commonFunctions.sendKeysIgnoringStaleElement(searchAllElementsText, "id:" + id, 30, "search box");
        //commonFunctions.sendKeyBoolean(searchAllElementsText, "id:" + id, 10, "search box");
        commonFunctions.sendKeysWithEnter(searchAllElementsText, 30);
        commonFunctions.isElementDisplayedAndPresent(recordConformation, 30, "record Conformation");
        return commonFunctions.isElementDisplayedAndPresent(selectedStory, 30, "element");
    }

    @Override
    public boolean discardElement() {
        boolean isDiscardElement;
        String elementId = getElementId();
        commonFunctions.clickElementWithJS(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardElement, 15, "discard element button");

        commonFunctions.waitForElementToBeInvisibleWithCatch(ellipsis, 10);
        commonFunctions.isElementDisplayedIgnoringStaleElementException(allElementsField, 15, "allElementsField");
        clickOnAllElement();
        searchElementByID(elementId);
        isDiscardElement = commonFunctions.checkElementText(textNoData, "No Data", 30, "Correct text is");
        return isDiscardElement;
    }

    public String getElementId() {
        String url = commonFunctions.getURLWithoutCatch();
        String[] id = url.split("/");
        String elementId = id[id.length - 1];
        System.out.println("ELEMENT ID:" + elementId);
        return elementId;
    }

    @Override
    public boolean findAndDiscardElement(String elementId) {
        boolean isDiscardElement;
        searchElementByID(elementId);
        commonFunctions.getElementTextAndCheck(singleRecordConformation, "Showing 1 results", 50, "Single record");
        commonFunctions.clickElementIgnoringStaleElement(selectedStory, 15, "Element list item");
        commonFunctions.clickElementWithJS(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardElement, 15, "discard element button");

        commonFunctions.isElementDisplayedIgnoringNoSuchElementException(searchAllElementsText, 20, "search field");
        clickOnAllElement();
        commonFunctions.waitForElementIgnoringStaleElement(searchAllElementsText, 10, "search field");
        searchElementByID(elementId);
        isDiscardElement = commonFunctions.checkElementText(textNoData, "No Data", 15, "Correct text is");
        return isDiscardElement;
    }

    @Override
    public boolean clickOnPages() {
        boolean isDisplayed;
        if (!commonFunctions.getElementTextAndCheck(elementsText, "Page", 5, "Pages Text")) {
            String urlVariable=globalVars.getEnvironment()+"Url";
            String URLToNavigate=globalVars.getProp().getProperty(urlVariable).replace("login", "dash/pages");
            commonFunctions.navigateToUrl(URLToNavigate);
            commonFunctions.clickElementIfDisplayed(pagesButton, 30, "Pages Label");
        }
        String text = commonFunctions.getElementText(pagesButton, 15);
        isDisplayed = text.equalsIgnoreCase("Pages");
        return isDisplayed;
    }

    @Override
    public boolean verifyPagination() {
        boolean isRecordsMatchedWithPagination = false;
        int noOfStories = 0;
        String[] noOfRecords = {};
        String noOfRecordsText = "";
        int totalNoOfRecords = 0;
        ArrayList<String> arrayElement;
        clearSearch();
        noOfRecordsText = commonFunctions.getElementText(noOfRecordInPagination, 30);
        noOfRecords = noOfRecordsText.split("results of");
        totalNoOfRecords = Integer.parseInt(noOfRecords[1].trim());
        if (totalNoOfRecords >= 600) {
            arrayElement = commonFunctions.getSelectedOption(dropDownRecordListInPagination, 30, "Records is");
            for (String traverseElement : arrayElement) {
                Select dropDown = new Select(dropDownRecordListInPagination);
                dropDown.selectByVisibleText(traverseElement);
                commonFunctions.clickElements(pageOneInPagination, 15, "page one");
                commonFunctions.clickElements(pageTwoInPagination, 15, "page two");
                commonFunctions.clickElements(pageThreeInPagination, 15, "page three");
                commonFunctions.isElementDisplayed(storyContentsListInPagination, 20, "Story listing");
                noOfStories = storyContentsListInPagination.size();
                if (noOfStories == Integer.parseInt(traverseElement.trim())) {
                    Utils.logStepInfo(true, "Records are matched");
                    isRecordsMatchedWithPagination = true;
                } else {
                    Utils.logStepInfo(false, "Records are not matched");
                    isRecordsMatchedWithPagination = false;
                }
            }
        } else if (totalNoOfRecords >= 200) {
            arrayElement = commonFunctions.getSelectedOption(dropDownRecordListInPagination, 30, "Records is");
            for (String traverseElement : arrayElement) {
                isRecordsMatchedWithPagination = selectPaginationDropDown(traverseElement);
            }
            return isRecordsMatchedWithPagination;
        } else if (totalNoOfRecords >= 150) {
            arrayElement = commonFunctions.getSelectedOption(dropDownRecordListInPagination, 30, "Records is");
            for (String traverseElement : arrayElement) {
                if (!traverseElement.equals("200")) {
                    isRecordsMatchedWithPagination = selectPaginationDropDown(traverseElement);
                }
            }
            return isRecordsMatchedWithPagination;
        } else if (totalNoOfRecords >= 100) {
            arrayElement = commonFunctions.getSelectedOption(dropDownRecordListInPagination, 30, "Records is");
            for (String traverseElement : arrayElement) {
                if (!traverseElement.equals("200") && !traverseElement.equals("150")) {
                    isRecordsMatchedWithPagination = selectPaginationDropDown(traverseElement);
                }
            }
            return isRecordsMatchedWithPagination;
        } else if (totalNoOfRecords >= 50) {
            arrayElement = commonFunctions.getSelectedOption(dropDownRecordListInPagination, 30, "Records is");
            for (String traverseElement : arrayElement) {
                if (!traverseElement.equals("200") && !traverseElement.equals("150") && !traverseElement.equals("100")) {
                    isRecordsMatchedWithPagination = selectPaginationDropDown(traverseElement);
                }
            }
            return isRecordsMatchedWithPagination;
        } else {
            Utils.logStepInfo(true, "Records are less than 50 so pagination test can not be completed");

        }
        clearSearch();
        return isRecordsMatchedWithPagination;
    }

    public boolean selectPaginationDropDown(String selectDropDownValue) {
        boolean isStepTrue;
        Select dropDown = new Select(dropDownRecordListInPagination);
        dropDown.selectByVisibleText(selectDropDownValue);
        commonFunctions.clickElements(pageOneInPagination, 30, "page one");
        commonFunctions.isElementDisplayed(storyContentsListInPagination, 20, "Story listing");
        int noOfStories = storyContentsListInPagination.size();
        if (noOfStories == Integer.parseInt(selectDropDownValue.trim())) {
            Utils.logStepInfo(true, "Records are matched");
            isStepTrue = true;
        } else {
            Utils.logStepInfo(false, "Records are not matched");
            isStepTrue = false;
        }
        return isStepTrue;
    }

    @Override
    public boolean mobileAndDesktopPreview(String headline) {
        boolean isDisplayed;
        commonFunctions.isElementDisplayedAndPresent(singleRecordConformation, 30, "Single record");
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "video list item");
        commonFunctions.clickElementWithJS(previewMobileButton, 50, "preview mobile button");
//TODO: GET HEADLINE TEXT AND VERIFY
        isDisplayed = commonFunctions.getElementTextAndCheck(previewHeadlineText, headline, 50, "headline matched");
        commonFunctions.clickElementWithJS(previewCloseButton, 50, "preview close mobile");
        commonFunctions.clickElementWithJS(previewDesktopButton, 50, "preview desktop button");
//TODO: GET HEADLINE TEXT AND VERIFY
        isDisplayed = isDisplayed && commonFunctions.getElementTextAndCheck(previewHeadlineText, headline, 50, "headline matched");
        commonFunctions.clickElementWithJS(previewCloseButton, 50, "preview close mobile");
        commonFunctions.clickElementWithJS(appLogo, 50, "blankPaper logo");
        return isDisplayed;
    }

    public boolean verifyMongoDBConnectionAndStoryDetails(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine) {
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = null;
            for (int i = 0; i <= 10; i++) {
                bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
                Iterator it = bp.iterator();
                if (it.hasNext()) {
                    break;
                } else {
                    commonFunctions.hardWait(10000);
                }
            }
            String finalTextUri = textUri;
            String finalDatabase = database;
            String finalCollection = collection;
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    try {
                        Gson gs = new Gson();
                        BlankPaperStoryData dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryData.class);
                        String headline;
                        String paragraphElementID = dataFromDocument.getElements().get(0).get$numberLong();
                        long elementIdInLong = Long.parseLong(paragraphElementID);
                        if (storyStatus.equals("PUBLISHED")) {
                            headline = dataFromDocument.getHeadline();
                        } else {
                            headline = dataFromDocument.getTitle();
                        }
                        System.out.println("HeadLine from MongoDB is: " + headline);
                        String section = dataFromDocument.getMetadata().getSection();
                        System.out.println("section from MongoDB is: " + section);
                        String summary = dataFromDocument.getSummary();
                        String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                        System.out.println("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                        String paragraphWithoutHTMLTags = null;
                        switch (property) {
                            case Constants.HT_NEW:
                                try {
                                    List<ListElement> paragraph = dataFromDocument.getListElement();
                                    String paragraphBody = paragraph.get(0).getParagraph().getBody();
                                    paragraphWithoutHTMLTags = Jsoup.parse(paragraphBody).text();
                                }catch(Exception e){
                                    BasicDBObject whereQuery = new BasicDBObject();
                                    whereQuery.put("_id", elementIdInLong);
                                    paragraphWithoutHTMLTags = getParagraphValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);
                                }
                                break;
                            case Constants.TECH:
                            case Constants.LIVEMINT:
                            case Constants.MINT_LOUNGE:
                            case Constants.AUTO:
                            case Constants.BANGLA:
                            case Constants.SMART_24:
                                BasicDBObject whereQuery = new BasicDBObject();
                                whereQuery.put("_id", elementIdInLong);
                                paragraphWithoutHTMLTags = getParagraphValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);
                                break;
                        }
                        System.out.println("Paragraph from MongoDB is: " + paragraphWithoutHTMLTags);
                        String subSection = dataFromDocument.getMetadata().getSubSection();
                        System.out.println("SubSection from MongoDB is: " + subSection);
                        String byLine1 = null;
                        if (property.equals(Constants.HT_NEW)) {
                            byLine1 = dataFromDocument.getMetadata().getAuthorsList().get(0).getName();
                        } else if ((property.equals(Constants.BANGLA)) || (property.equals(Constants.LIVEMINT)) || (property.equals(Constants.AUTO)) || (property.equals(Constants.TECH)) || (property.equals(Constants.MINT_LOUNGE)) || (property.equals(Constants.SMART_24))) {
                            byLine1 = dataFromDocument.getMetadata().getAuthors().toString().replace("[", "").replace("]", "").trim();
                        }
                        System.out.println("byLine from MongoDB is: " + byLine);
                        boolean locationStatus = true;
                        if (!property.equals(Constants.MINT_LOUNGE) && !property.equals(Constants.TECH)) {
                            if(property.equals(Constants.SMART_24)){
                                String location = dataFromDocument.getMetadata().getPrimaryLocation();
                                if(location.toLowerCase().contains(locationFromExcel.toLowerCase())){
                                    locationStatus = true;
                                }else{
                                    locationStatus = false;
                                }
                            }else {
                                List<String> location = dataFromDocument.getMetadata().getLocation();
                                System.out.println("Location from MongoDB is: " + location);

                                if (location.get(0).equals(locationFromExcel)) {
                                    locationStatus = true;
                                } else {
                                    locationStatus = false;
                                }
                            }
                        }

                        boolean headlineStatus = true;
                        if(headline.trim().equalsIgnoreCase(headlineFromExcel.trim()) || headlineFromExcel.toLowerCase().trim().contains(headline.toLowerCase().trim()) || headline.toLowerCase().trim().contains(headlineFromExcel.toLowerCase().trim())){
                            headlineStatus = true;
                        }else{
                            headlineStatus = false;
                            Utils.logStepInfo("Headline is not matching with DB as expected:- "+headlineFromExcel.trim()+" but found:- "+headline.trim());
                            System.out.println("Headline is not matching with DB as expected:- "+headlineFromExcel.trim()+" but found:- "+headline.trim());
                        }

                        boolean paraStatus = true;
                        if(paragraphWithoutHTMLTags.trim().equalsIgnoreCase(paragraphFromExcel.trim()) || paragraphFromExcel.isEmpty() || paragraphFromExcel.equals("") || paragraphFromExcel.equals(" ")){
                            paraStatus = true;
                        }else{
                            paraStatus = false;
                            Utils.logStepInfo("Paragraph is not matching with DB as expected:- "+paragraphFromExcel.trim()+" but found:- "+paragraphWithoutHTMLTags.trim());
                            System.out.println("Paragraph is not matching with DB as expected:- "+paragraphFromExcel.trim()+" but found:- "+paragraphWithoutHTMLTags.trim());
                        }

                        isResultMatched[0] = headlineStatus && summaryWithoutHTMLTags.equalsIgnoreCase(summaryFromExcel) && section.equals(sectionFromExcel) && subSection.toLowerCase().contains(subSectionFromExcel.toLowerCase()) && locationStatus && byLine1.toLowerCase().contains(byLine.toLowerCase()) && paraStatus;
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            });
        }else{
            isResultMatched[0] = true;
        }
        return isResultMatched[0];
    }

    public boolean verifyMongoDBConnectionAndStoryDetailsOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, boolean expSoftPubStatus, boolean expKilledStatus) {
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = null;
            for (int i = 0; i <= 10; i++) {
                bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
                Iterator it = bp.iterator();
                if (it.hasNext()) {
                    break;
                } else {
                    commonFunctions.hardWait(10000);
                }
            }
            String finalTextUri = textUri;
            String finalDatabase = database;
            String finalCollection = collection;
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    try {
                        Gson gs = new Gson();
                        BlankPaperStoryDataBackend dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryDataBackend.class);
                        String headline;
                        String paragraphElementID = dataFromDocument.getElements().get(0).get$numberLong();
                        long elementIdInLong = Long.parseLong(paragraphElementID);

                        headline = dataFromDocument.getTitle();
                        System.out.println("HeadLine from MongoDB is: " + headline);
                        String section = dataFromDocument.getMetadata().getSection();
                        System.out.println("section from MongoDB is: " + section);
                        String summary = dataFromDocument.getSummary();
                        String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                        System.out.println("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                        String subSection = dataFromDocument.getMetadata().getSubSection();
                        System.out.println("SubSection from MongoDB is: " + subSection);
                        boolean softPub = dataFromDocument.getSoftPublished();
                        System.out.println("softPublish from MongoDB is: " + softPub);
                        boolean killedStatus = dataFromDocument.getMetadata().getKilled();
                        System.out.println("killedStatus from MongoDB is: " + killedStatus);
                        String byLine1 = null;
                        if (property.equals(Constants.HT_NEW)) {
                            byLine1 = dataFromDocument.getMetadata().getAuthorsList().get(0).getName();
                        } else if ((property.equals(Constants.BANGLA)) || (property.equals(Constants.LIVEMINT)) || (property.equals(Constants.AUTO)) || (property.equals(Constants.TECH)) || (property.equals(Constants.MINT_LOUNGE)) || (property.equals(Constants.SMART_24))) {
                            byLine1 = dataFromDocument.getMetadata().getAuthors().toString().replace("[", "").replace("]", "").trim();
                        }
                        System.out.println("byLine from MongoDB is: " + byLine);
                        boolean locationStatus = true;
                        if (!property.equals(Constants.MINT_LOUNGE) && !property.equals(Constants.TECH)) {
                            if(property.equals(Constants.SMART_24)){
                                String location = dataFromDocument.getMetadata().getPrimaryLocation();
                                System.out.println("Location from MongoDB is: " + location);
                                if(location.toLowerCase().contains(locationFromExcel.toLowerCase())){
                                    locationStatus = true;
                                }else{
                                    locationStatus = false;
                                }
                            }else {
                                List<String> location = dataFromDocument.getMetadata().getLocation();
                                System.out.println("Location from MongoDB is: " + location);

                                if (location.get(0).trim().equals(locationFromExcel.trim())) {
                                    locationStatus = true;
                                } else {
                                    locationStatus = false;
                                }
                            }
                        }
                        BasicDBObject whereQuery = new BasicDBObject();
                        whereQuery.put("_id", elementIdInLong);
                        String paragraph = getParagraphValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);
                        System.out.println("paragraph:- " + paragraph);

                        boolean headlineStatus = true;
                        if(headline.trim().equalsIgnoreCase(headlineFromExcel.trim()) || headlineFromExcel.toLowerCase().trim().contains(headline.toLowerCase().trim())){
                            headlineStatus = true;
                        }else{
                            headlineStatus = false;
                            Utils.logStepInfo("Headline is not matching with DB as expected:- "+headlineFromExcel.trim()+" but found:- "+headline.trim());
                            System.out.println("Headline is not matching with DB as expected:- "+headlineFromExcel.trim()+" but found:- "+headline.trim());
                        }

                        boolean summaryStatus= true;
                        if(summaryWithoutHTMLTags.trim().equalsIgnoreCase(summaryFromExcel.trim())){
                            summaryStatus = true;
                        }else{
                            summaryStatus = false;
                            Utils.logStepInfo("Summary is not matching with DB as expected:- "+summaryFromExcel.trim()+" but found:- "+summaryWithoutHTMLTags.trim());
                            System.out.println("Summary is not matching with DB as expected:- "+summaryFromExcel.trim()+" but found:- "+summaryWithoutHTMLTags.trim());
                        }

                        boolean sectionStatus=true;
                        if(section.trim().equalsIgnoreCase(sectionFromExcel.trim())){
                            sectionStatus=true;
                        }else{
                            sectionStatus=false;
                            Utils.logStepInfo("Section is not matching with DB as expected:- "+sectionFromExcel.trim()+" but found:- "+section.trim());
                            System.out.println("Section is not matching with DB as expected:- "+sectionFromExcel.trim()+" but found:- "+section.trim());
                        }

                        boolean subSectionStatus= true;
                        if(subSection.toLowerCase().trim().contains(subSectionFromExcel.toLowerCase().trim())){
                            subSectionStatus= true;
                        }else{
                            subSectionStatus= false;
                            Utils.logStepInfo("SubSection is not matching with DB as expected:- "+subSectionFromExcel.toLowerCase().trim()+" but found:- "+subSection.toLowerCase().trim());
                            System.out.println("SubSection is not matching with DB as expected:- "+subSectionFromExcel.toLowerCase().trim()+" but found:- "+subSection.toLowerCase().trim());
                        }

                        boolean bylineStatu= true;
                        if(byLine1.toLowerCase().trim().contains(byLine.toLowerCase().trim())){
                            bylineStatu= true;
                        }else{
                            bylineStatu= false;
                            Utils.logStepInfo("ByLine is not matching with DB as expected:- "+byLine.toLowerCase().trim()+" but found:- "+byLine1.toLowerCase().trim());
                            System.out.println("ByLine is not matching with DB as expected:- "+byLine.toLowerCase().trim()+" but found:- "+byLine1.toLowerCase().trim());
                        }

                        boolean paraStatus=true;
                        if(paragraph.trim().equalsIgnoreCase(paragraphFromExcel.trim()) || paragraphFromExcel.isEmpty() || paragraphFromExcel.equals("") || paragraphFromExcel.equals(" ")){
                            paraStatus=true;
                        }else{
                            paraStatus = false;
                            Utils.logStepInfo("Paragraph is not matching with DB as expected:- "+paragraphFromExcel.trim()+" but found:- "+paragraph.trim());
                            System.out.println("Paragraph is not matching with DB as expected:- "+paragraphFromExcel.trim()+" but found:- "+paragraph.trim());
                        }

                        isResultMatched[0] =  headlineStatus && summaryStatus && sectionStatus && subSectionStatus && locationStatus && bylineStatu && paraStatus;
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            });
        }else{
            isResultMatched[0] = true;
        }
        return isResultMatched[0];
    }

    @Override
    public void clearSearch() {
        clickOnAllElement();
        clickOnDashboard();
    }

    public String getParagraphValue(DbConnection db,BasicDBObject whereQuery,String textUri,String database,String collection) {
        final String[] paragraphWithHTMLTags = new String[1];
        paragraphWithHTMLTags[0] = "";
        FindIterable<Document> bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
        bp.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                try {
                    Gson gs = new Gson();
                    ParagraphInCreatedStory dataFromDocument = gs.fromJson(document.toJson(), ParagraphInCreatedStory.class);
                    String headline;
                    String paragraph=dataFromDocument.getParagraph().getBody();
                    paragraphWithHTMLTags[0] =Jsoup.parse(paragraph).text();
                } catch (Exception e) {
                    System.out.println("Exception in getting paragraph from Mongo DB");
                }
            }
        });
        return paragraphWithHTMLTags[0];
    }

    @Override
    public boolean discardElement(String elementId) {
        boolean isDiscardElement;
        commonFunctions.clickElementWithJS(ellipsis, 10, "Three dot button");
        commonFunctions.clickElement(buttonDiscardElement, 15, "discard element button");
        clickOnAllElement();
        searchElementByID(elementId);
        isDiscardElement = commonFunctions.checkElementText(textNoData, "No Data", 30, "Correct text is");
        return isDiscardElement;
    }

    @Override
    public void applyStatusFilterOnPages(String statusFilter) {
        commonFunctions.clickElement(statusFilterDropdown, 15, "status filter");

        switch (statusFilter) {
            case "Published":
                commonFunctions.clickElement(statusFilterValuePublished, 20, "statusFilterValuePublished");
                break;
            case "Created":
                commonFunctions.clickElement(statusFilterValueCreated, 20, "statusFilterValuePublished");
        }
        commonFunctions.clickElement(statusFilterDropdown, 15, "status filter");
        commonFunctions.waitForElementToBeInvisible(statusFilterValuePublished, 10);

    }

    @Override
    public boolean copyUrlAndHeadlineOfPublishedStory(String storyType) {
        boolean isPublished;
        isPublished= publishedStory(storyType);
        storyHeadlineText = commonFunctions.getElementText(firstStoryHeadlineText, 30);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(firstStoryHeadlineText, 30, "story");
        storyUrl = commonFunctions.getElementText(copyStoryUrl, 50);
        commonFunctions.clickElementWithJS(blankPaperLogo,30,"blankpaper logo");
        return isPublished;
    }

    @Override
    public boolean killStoryAndVerify(String storyIdNumber, String storyURL) {
        boolean isStoryKilled;
        searchStoryByID(storyIdNumber);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
        commonFunctions.clickElement(ellipsis, 15, "three dots ");
        commonFunctions.clickElement(buttonKillStory, 10, "Kill button");
        commonFunctions.sendKeysOnElementVisibility(submitUrlForKillStory,storyURL,30,"story url");
        commonFunctions.clickElement(doneButtonForKillStory, 10, "done button");
        commonFunctions.isElementDisplayedAndPresent(toastKillStory, 10, "kill story toaster");
        commonFunctions.clickElement(appLogo, 20);
        searchStoryByID(storyIdNumber);
        isStoryKilled = commonFunctions.checkElementTextIgnoringStaleElement(storyStatus, "KILLED", 30, "Correct text is");
        return isStoryKilled;
    }

    public boolean publishedStory(String storyType){
        boolean isPublished;
        commonFunctions.isElementDisplayed(typeFilter,30,"Type Filter");
        commonFunctions.clickElementWithJS(typeFilter, 30, "type filter");
        commonFunctions.sendKeysOnElementVisibility(typeFilterSearchBox, storyType, 30, "story type");
        commonFunctions.getElementText(typeFilterValue, storyType, 30);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(typeFilterValue, 30, "story type");
        commonFunctions.clickElementWithJS(typeFilter, 30, "type filter");
        commonFunctions.clickElementWithJS(moreFilterButton, 30, "more button");
        commonFunctions.clickElement(statusFilterDropdown, 15, "status filter");
        commonFunctions.clickElementWithJS(statusFilterValue, 30, "Published");
        commonFunctions.clickElement(statusFilterDropdown, 15, "status filter");
        isPublished = commonFunctions.checkElementText(storyStatus, "PUBLISHED", 30, "Correct text is");
        return isPublished;
    }

    public void selectStoryCopyUrlOpenNewTab(String username, String password,String storyIDNumber1){
        searchStoryByIDAndSelect(storyIDNumber1);
        String text = commonFunctions.getElementText(copyTextUrl, 50);
        String url = commonFunctions.urlAuthenticationHandling(text, username, password);
        commonFunctions.newTabWithUrl(url);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
    }

    private void searchStoryByIDAndSelect(String id) {
        searchStoryByID(id);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
    }

    @Override
    public boolean changeFirstImageCaptionName(String firstCaption) {
        boolean isShowing;
        commonFunctions.scrollPageWithJS(firstImage, 10);
        if (!commonFunctions.isElementDisplayedAndPresent(firstImageCaption, 10, "image caption")) {
            if(commonFunctions.isElementDisplayedAndPresent(firstEditImage, 10, "first Edit Image")){
                commonFunctions.scrollPageWithJS(firstEditImage, 20);
                commonFunctions.clickElementWithJS(firstEditImage, 20, "first image edit icon");
            }else {
                commonFunctions.isElementDisplayedAndPresent(threeDotsFirstImage, 20, "three Dots First Image");
                commonFunctions.scrollPageWithJS(threeDotsFirstImage, 20);
                commonFunctions.clickElementWithJS(threeDotsFirstImage, 20, "three Dots First Image");
                if(commonFunctions.isElementPresentWithTryCatch(editImage, 5)) {
                    commonFunctions.clickElementWithJS(editImage, 20, "edit Image");
                }
            }
        }
        commonFunctions.isElementDisplayedAndPresent(firstImageCaption, 10, "image caption");
        commonFunctions.clickElementIfDisplayed(firstImageTitle, 20, "first image title");
        commonFunctions.clickElementIfDisplayed(firstImageCaption, 10, "image caption");
        if (firstImageCaption.getText().length() > 0) {
            firstImageCaption.clear();
        }
        commonFunctions.clickElementIfDisplayed(firstImageCaption);
        char[] summaryChar = firstCaption.toCharArray();
        for (int i = 0; i <= summaryChar.length - 1; i++) {
            commonFunctions.sendKeyWithActions(firstImageCaption, Character.toString(summaryChar[i]));
        }
        commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 7, "image cropping done");
        commonFunctions.scrollPageWithJS(firstImageDoneButton, 10);
        commonFunctions.clickElementWithJS(firstImageDoneButton, 20, "first image done button");
        commonFunctions.clickElementIfDisplayed(firstImageDoneButton, 10, "first image done button");
        commonFunctions.hardWait(5000);
        boolean matchingFlag = false;
        if(!commonFunctions.getAttrValue(firstImageCaptionNameData, 10, "ng-reflect-model").equals("")) {
            matchingFlag = commonFunctions.matchWords(commonFunctions.getAttrValue(firstImageCaptionNameData, 10, "ng-reflect-model").trim(), firstCaption.trim(), " ");
        }
        isShowing = commonFunctions.checkEleText(firstImageCaptionNameData, firstCaption, 15, "first image Caption name") || matchingFlag;
        return isShowing;
    }

    public boolean changeSecondImageCaptionName(String secondCaption) {
        boolean isShowing;
        commonFunctions.scrollPageWithJS(secondImage, 10);
        if (!commonFunctions.isElementDisplayedAndPresent(secondImageCaption, 10, "second image caption")) {
            if (commonFunctions.isElementDisplayedAndPresent(secondEditImage, 10, "second image caption")) {
                commonFunctions.scrollPageWithJS(secondEditImage, 20);
                commonFunctions.clickElementWithJS(secondEditImage, 20, "second image edit icon");
            } else {
                commonFunctions.isElementDisplayedAndPresent(threeDotsSecondImage, 20, "three Dots second Image");
                commonFunctions.scrollPageWithJS(threeDotsSecondImage, 20);
                commonFunctions.clickElementWithJS(threeDotsSecondImage, 20, "three Dots second Image");
                commonFunctions.clickElementWithJS(editImage, 20, "edit Image");
            }
        }
        commonFunctions.isElementDisplayedAndPresent(secondImageCaption, 10, "second image caption");
        commonFunctions.clickElementIfDisplayed(secondImageTitle, 20, "second image title");
        commonFunctions.clickElementIfDisplayed(secondImageCaption, 10, "second image caption");
        if (secondImageCaption.getText().length() > 0) {
            secondImageCaption.clear();
        }
        commonFunctions.sendKey(secondImageCaption, secondCaption);
        commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 7, "image cropping done");
        commonFunctions.scrollPageWithJS(secondImageDoneButton, 10);
        commonFunctions.clickElementWithJS(secondImageDoneButton, 20, "second image done button");
        commonFunctions.clickElementIfDisplayed(secondImageDoneButton, 10, "second image done button");
        isShowing = commonFunctions.checkElementText(secondImageCaptionNameData, secondCaption, 15, "second image Caption name");
        return isShowing;
    }

    public boolean changeThirdImageCaptionName(String thirdCaption) {
        boolean isShowing;
        commonFunctions.scrollPageWithJS(thirdImage, 10);
        if (!commonFunctions.isElementDisplayedAndPresent(thirdImageCaption, 10, "third image caption")) {
            commonFunctions.scrollPageWithJS(thirdEditImage, 20);
            commonFunctions.clickElementWithJS(thirdEditImage, 20, "third image edit icon");
        }
        commonFunctions.isElementDisplayedAndPresent(thirdImageCaption, 10, "third image caption");
        commonFunctions.clickElementIfDisplayed(thirdImageTitle, 20, "third image title");
        commonFunctions.clickElementIfDisplayed(thirdImageCaption, 10, "third image caption");
        if (thirdImageCaption.getText().length() > 0) {
            thirdImageCaption.clear();
        }
        commonFunctions.sendKey(thirdImageCaption, thirdCaption);
        commonFunctions.isElementDisplayedAndPresent(toastCropingDone, 7, "image cropping done");
        commonFunctions.scrollPageWithJS(thirdImageDoneButton, 10);
        commonFunctions.clickElementWithJS(thirdImageDoneButton, 20, "third image done button");
        commonFunctions.clickElementIfDisplayed(thirdImageDoneButton, 20, "third image done button");
        commonFunctions.clickElementIfDisplayed(secondImageDoneButton, 10, "second image done button");
        isShowing = commonFunctions.checkElementText(thirdImageCaptionNameData, thirdCaption, 15, "third image Caption name");
        return isShowing;
    }

    @Override
    public void inputSection(String section) {
        commonFunctions.isElementDisplayedAndPresent(inputAddSectionText, 20, "wait for Element display");
        commonFunctions.clickElementIfDisplayed(inputAddSectionText, 20, "wait for Suggestion popuplist");
        commonFunctions.isElementDisplayedAndPresent(inputAddByLineSuggestionPopup, 80, "Wait for Auto Sugestion popup displayed");
        commonFunctions.sendKeys(inputAddSectionText, section, 20, "Input Section");
        //commonFunctions.sendKeysWithEnter(inputAddSectionText, 10);
        sectionValue(sectionInputValue,section);
        commonFunctions.isElementDisplayedAndPresent(textAllChangesSaved, 20, "wait for Save changes text");
    }

    @Override
    public boolean checkImageAfterUploadOnStoryPage() {
        boolean isShowing = false;
//        isShowing = commonFunctions.getAttributeValue(imageSrcStoryPage, 20, "src").contains("amazonaws");
        commonFunctions.isElementDisplayedAndPresent(imageSrcStoryPage, 20, "images loading");
        for (int i = 0; i <= imageSrcStoryPage.size() - 1; i++) {
            if (isShowing = imageSrcStoryPage.get(i).getAttribute("src").contains("amazonaws")) {
                isShowing &= true;
                Utils.logStepInfo(true, "image is available");
            } else {
                isShowing &= false;
                Utils.logStepInfo(false, "image is Not available !!!!!!!!");
            }
        }
            return isShowing;
        }


    @Override
    public void createdByFilter(String createdBy){
            commonFunctions.clickElementWithJS(createdFilter, 20, "created by filter");
            commonFunctions.sendKeysOnElementVisibility(typeFilterSearchBox, createdBy, 30, "created By");
            commonFunctions.getElementText(typeFilterValue, createdBy, 30);
            commonFunctions.waitAndClickForElementIgnoringStaleElement(typeFilterValue, 30, "created type");
            commonFunctions.clickElementWithJS(createdFilter, 30, "created By filter");
        }

        public boolean changeUrl(String urlHeadline,String domain) {
            boolean isShowing = false;
            if (domain.equals("Bangla")) {
                commonFunctions.clickElement(addHeadlineIcon, 15, "headline add button");
                isShowing = commonFunctions.checkElementText(pleaseEnterEnglishCharOnlyText, "Please Enter English Characters Only", 20, "English Validation Text");
                commonFunctions.sendKeys(landingPageHeadline, urlHeadline, 10, "landing page headline");
                isShowing &= commonFunctions.elementIsNotPresent(pleaseEnterEnglishCharOnly, 20, "please enter english char only");
//TODO: in automation env there is no any attribute to validate the given urlHeadline value.

//           isShowing &= urlHeadline.contains(commonFunctions.getAttributeValue(landingPageHeadline, 20, "ng-reflect-model"));
                commonFunctions.clickElement(saveButtonHeadline, 10, "save button");
                commonFunctions.isElementDisplayedWithoutTryCatch(textAllChangesSaved, 20, "wait for Save changes text");
            }
            return isShowing;
        }

        @Override
        public boolean checkUserIsAbleToSelectLivehindustanAffiliate(){
            return commonFunctions.checkAndSelectTanentOption(tenantDrpDown, 20, "Live Hindustan Affiliate", "tenant");
        }

    @Override
    public boolean clickOnReports() {
        boolean isDisplayed;
        if (!commonFunctions.getElementTextAndCheck(elementsText, "Page", 5, "Reports Text")) {
            String urlVariable=globalVars.getEnvironment()+"Url";
            String URLToNavigate=globalVars.getProp().getProperty(urlVariable).replace("login", "dash/reports");
            commonFunctions.navigateToUrl(URLToNavigate);
            commonFunctions.clickElementWithJS(ReportsButton, 30, "Reports Label");
        }
        String text = commonFunctions.getElementText(ReportsButton, 15);
        isDisplayed = text.equalsIgnoreCase("Reports");
        return isDisplayed;
    }

    @Override
    public boolean clickOnUsers() {
        boolean isDisplayed;
        if (!commonFunctions.getElementTextAndCheck(elementsText, "Page", 5, "Users Text")) {
            String urlVariable=globalVars.getEnvironment()+"Url";
            String URLToNavigate=globalVars.getProp().getProperty(urlVariable).replace("login", "dash/users");
            commonFunctions.navigateToUrl(URLToNavigate);
            commonFunctions.clickElementWithJS(UsersButton, 30, "Users Label");
        }
        String text = commonFunctions.getElementText(UsersButton, 15);
        isDisplayed = text.equalsIgnoreCase("Users");
        return isDisplayed;
    }

    @Override
    public boolean checkIfUserIsAbleSeeTheDashboardAsSelectedAfterRedirectingToTheHomepage(String urlSpace) {
        String path[]=commonFunctions.getURL().split("/");
        return path[path.length-1].equals(urlSpace);
    }

    @Override
    public boolean checkIfUserIsAbleToSelectTenantsFromDropDowns(String property) {
       return checkSelectedDomain(property);
    }

    @Override
    public boolean checkIfUserIsAbleToSeeAllStoriesAndMyWorkspaceTabOnDashboard() {
        commonFunctions.hardWait(5000);
        return commonFunctions.isElementDisplayed(allStoriesLabelHomePage,10) &&
                commonFunctions.isElementDisplayed(myWorkspaceTab,10);
    }

    @Override
    public boolean checkIfUserIsAbleToSeeAllStoriesTabPreSelectedOnDashboard(String defaultOpeningTab) {
        return commonFunctions.getElementTextAndCheck(getDefaultTabText,defaultOpeningTab,10,"all stories");
    }

    @Override
    public boolean checkIfUserIsAbleToSeeTableOfAllStoriesTab() {
        return commonFunctions.isElementDisplayed(allStoriesTable,10);
    }

    @Override
    public boolean checkIfUserIsAbleSeeSevenColumnsInTheTable(String headingOne, String headingTwo, String headingThree, String headingFour, String headingFive, String headingSix, String headingSeven) {
        List<WebElement> listOfHeadings=HeadingList;
        String temp="";
        boolean resultIs=true;
        List<String> headingList= Arrays.asList(headingOne,headingTwo,headingThree,headingFour,headingFive,headingSix,headingSeven);
        for(WebElement ei: listOfHeadings){
            temp=commonFunctions.getElementText(ei,10);
            if(!headingList.contains(temp)) return false;
        }
        return resultIs;
    }

    public void filterPublishedStories(){
        commonFunctions.clickElementIfDisplayed(moreFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilterValue,10);
    }

    public void filterCreatedStories(){
        commonFunctions.clickElementIfDisplayed(moreFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(statusCreated,10);
    }

    public void filterEditedStories(){
        commonFunctions.clickElementIfDisplayed(moreFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(statusEdited,10);
    }

    public void filterScheduledStories(){
        commonFunctions.clickElementIfDisplayed(moreFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(statusScheduled,10);
    }

    public void filterFiledStories(){
        commonFunctions.clickElementIfDisplayed(moreFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFiled,10);
    }

    public void filterKilledStories(){
        commonFunctions.clickElementIfDisplayed(moreFilter,10);
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(statusKilled,10);
    }


    @Override
    public boolean checkIfTheStatusOfStoryIsPublishedIfUserPublishedTheStory(String requiredStatus) {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        boolean isStatusPublished=commonFunctions.waitAndGetElementTextAndCheck(publishedStoryStatus,requiredStatus,10,"status");
        return isStatusPublished;
    }

    @Override
    public boolean checkIfTextPublishedShouldBeClickable() {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(publishedStoryStatus,10);
        return commonFunctions.isClickableElementClicked(publishedStoryStatus,10,"published link");

    }

    @Override
    public boolean CheckIfTextPublishedIseClickableAndRedirectedToFrontendStoryLink() {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(publishedStoryStatus,10);
        Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        return windowsList.size()==2;
    }

    @Override
    public boolean CheckIfLinkOutIconIsPresentIfTheStoryStatusIsPublished() {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.hardWait(2000);
        return commonFunctions.isElementDisplayed(reDirectLinkIcon,10);
    }

    @Override
    public boolean CheckIfIconIsPresentAfterPublishedTextIfTheStoryStatusIsPublished() {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        return commonFunctions.clickElementIfDisplayed(isIconPresentAfterPublishWord,10);
    }

    @Override
    public boolean checkIfLinkOutIconIsClickable() {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        return commonFunctions.isClickableElementClicked(reDirectLinkIcon,10,"link out icon or redirect icon");
    }

    @Override
    public boolean CheckIfLinkOutIconIsClickableAndRedirectedToFrontendStoryLink() {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(reDirectLinkIcon,10);
        Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        return windowsList.size()==2;
    }

    @Override
    public boolean CheckIfLinkOutRedirectingUrlAndGeneratedUrlInStoryInformationSectionAreSame() {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.clickElementIfDisplayed(publishedStoryStatus,10);
        Set<String> windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        commonFunctions.switchToLastWindow(windowsList);
        String redirectedPageUrl=commonFunctions.getURL();
        ArrayList<String> windowsList1 = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList1.get(windowsList1.size() - 2));
        commonFunctions.waitAndClickForElementIgnoringStaleElement(publishedStory, 25, "story list item");
        commonFunctions.scrollToElementView(generatedUrl,10,"URL generated");
        String generatedUrlLinkText=commonFunctions.getElementText(generatedUrl);
        return generatedUrlLinkText.equals(redirectedPageUrl);
    }

    @Override
    public boolean CheckIfStatusOfStoryShouldBeCreatedIfUserCreatedTheStory(String requiredStatus) {
        filterCreatedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        return commonFunctions.isElementPresent(publishedStoryStatusCreated,10);
    }

    @Override
    public boolean CheckIfLinkOutIconNotPresentIfTheStoryStatusIsCreated() {
        filterCreatedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        commonFunctions.dummyWait(2);
        boolean result=commonFunctions.isElementPresentWithTryCatch(reDirectLinkIcon,10);
        return !result;
    }

    public boolean verifyMongoDBConnectionAndHeadinesOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String mobileHeadline, String browserHeadline, String facebookHeadline, String twitterHeadline) {
        commonFunctions.hardWait(10000);
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
            String finalTextUri = textUri;
            String finalDatabase = database;
            String finalCollection = collection;
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    try {
                        Gson gs = new Gson();
                        BlankPaperStoryDataBackend dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryDataBackend.class);
                        String headline;
                        String paragraphElementID = dataFromDocument.getElements().get(0).get$numberLong();
                        long elementIdInLong = Long.parseLong(paragraphElementID);
                        if(property.trim().equalsIgnoreCase("Bangla") || property.trim().equalsIgnoreCase("Smart 24")){
                            headline = dataFromDocument.getHeadline();
                        }else {
                            headline = dataFromDocument.getUrlHeadline();
                        }
                        System.out.println("HeadLine from MongoDB is: " + headline);
                        String mobHeadline = dataFromDocument.getMobileAppNotificationHeadline();
                        System.out.println("mobHeadline from MongoDB is: " + mobHeadline);
                        String broHeadline = dataFromDocument.getBrowserNotificationHeadline();
                        System.out.println("broHeadline from MongoDB is: " + broHeadline);
                        String facHeadline = dataFromDocument.getFacebookHeadline();
                        System.out.println("facHeadline from MongoDB is: " + facHeadline);
                        String twiHeadline = dataFromDocument.getTwitterHeadline();
                        System.out.println("twiHeadline from MongoDB is: " + twiHeadline);

                        boolean headlineUpdatedStatus = false;
                        if (headline.trim().equalsIgnoreCase(headlineFromExcel.trim())) {
                            headlineUpdatedStatus = true;
                        } else {
                            Utils.logStepInfo("Headline are not matching as expected:- " + headlineFromExcel.trim() + " But Found:- " + headline.trim());
                            System.out.println("Headline are not matching as expected:- " + headlineFromExcel.trim() + " But Found:- " + headline.trim());
                        }

                        boolean mobHeadlineStatus = false;
                        if (mobHeadline.trim().equalsIgnoreCase(mobileHeadline.trim())) {
                            mobHeadlineStatus = true;
                        } else {
                            Utils.logStepInfo("MobHeadline are not matching as expected:- " + mobileHeadline.trim() + " But Found:- " + mobHeadline.trim());
                            System.out.println("MobHeadline are not matching as expected:- " + mobileHeadline.trim() + " But Found:- " + mobHeadline.trim());
                        }

                        boolean broHeadlineStatus = false;
                        if (broHeadline.trim().equalsIgnoreCase(browserHeadline.trim())) {
                            broHeadlineStatus = true;
                        } else {
                            Utils.logStepInfo("BroHeadline are not matching as expected:- " + browserHeadline.trim() + " But Found:- " + broHeadline.trim());
                            System.out.println("BroHeadline are not matching as expected:- " + browserHeadline.trim() + " But Found:- " + broHeadline.trim());
                        }

                        boolean facHeadlineStatus = false;
                        if (facHeadline.trim().equalsIgnoreCase(facebookHeadline.trim())) {
                            facHeadlineStatus = true;
                        } else {
                            Utils.logStepInfo("FacHeadline are not matching as expected:- " + facebookHeadline.trim() + " But Found:- " + facHeadline.trim());
                            System.out.println("FacHeadline are not matching as expected:- " + facebookHeadline.trim() + " But Found:- " + facHeadline.trim());
                        }

                        boolean twiHeadlineStatus = false;
                        if (twiHeadline.trim().equalsIgnoreCase(twitterHeadline.trim())) {
                            twiHeadlineStatus = true;
                        } else {
                            Utils.logStepInfo("TwiHeadline are not matching as expected:- " + twitterHeadline.trim() + " But Found:- " + twiHeadline.trim());
                            System.out.println("TwiHeadline are not matching as expected:- " + twitterHeadline.trim() + " But Found:- " + twiHeadline.trim());
                        }


                        BasicDBObject whereQuery = new BasicDBObject();
                        whereQuery.put("_id", elementIdInLong);
                        //String paragraph=getParagraphValue(db,whereQuery,finalTextUri,finalDatabase,finalCollection);
                        isResultMatched[0] = headlineUpdatedStatus && mobHeadlineStatus && broHeadlineStatus && facHeadlineStatus && twiHeadlineStatus;
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            });
        }else{
            isResultMatched[0] = true;
        }
        return isResultMatched[0];
    }

    public boolean verifyMongoDBConnectionAndLiveBlogStoryDetailsWithPostValueOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, String postTitleExcel, String postBodyExcel, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus) {
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = null;
            for (int i = 0; i <= 10; i++) {
                bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
                Iterator it = bp.iterator();
                if (it.hasNext()) {
                    break;
                } else {
                    commonFunctions.hardWait(10000);
                }
            }
            String finalTextUri = textUri;
            String finalDatabase = database;
            String finalCollection = collection;
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    try {
                        Gson gs = new Gson();
                        BlankPaperStoryDataBackend dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryDataBackend.class);
                        String headline;
                        String postElementID = dataFromDocument.getElements().get(0).get$numberLong();
                        long elementIdInLong = Long.parseLong(postElementID);

                        headline = dataFromDocument.getTitle();
                        System.out.println("HeadLine from MongoDB is: " + headline);
                        String section = dataFromDocument.getMetadata().getSection();
                        System.out.println("section from MongoDB is: " + section);
                        String summary = dataFromDocument.getSummary();
                        String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                        System.out.println("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                        String subSection = dataFromDocument.getMetadata().getSubSection();
                        System.out.println("SubSection from MongoDB is: " + subSection);
                        boolean softPub = false;
                        boolean killedStatus = false;
                        int deleteValue = 0;
                        String schValue = null;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            softPub = dataFromDocument.getSoftPublished();
                            System.out.println("softPublish from MongoDB is: " + softPub);
                            killedStatus = dataFromDocument.getMetadata().getKilled();
                            System.out.println("killedStatus from MongoDB is: " + killedStatus);
                            deleteValue = dataFromDocument.getIsDeleted();
                            System.out.println("deleteValue from MongoDB is: " + deleteValue);
                            if (scheduleStatus) {
                                schValue = dataFromDocument.getMetadata().getStatus();
                                System.out.println("Schedule Published from MongoDB is: " + schValue);
                            }
                        }
                        String byLine1 = null;
                        if (property.equals(Constants.HT_NEW)) {
                            byLine1 = dataFromDocument.getMetadata().getAuthorsList().get(0).getName();
                        } else if ((property.equals(Constants.BANGLA)) || (property.equals(Constants.LIVEMINT)) || (property.equals(Constants.AUTO)) || (property.equals(Constants.TECH)) || (property.equals(Constants.MINT_LOUNGE)) || (property.equals(Constants.SMART_24))) {
                            byLine1 = dataFromDocument.getMetadata().getAuthors().toString().replace("[", "").replace("]", "").trim();
                        }
                        System.out.println("byLine from MongoDB is: " + byLine);
                        List<String> location = null;
                        if (!property.equals(Constants.MINT_LOUNGE) && !property.equals(Constants.TECH) && !property.equals(Constants.SMART_24)) {
                            location = dataFromDocument.getMetadata().getLocation();
                            System.out.println("Location from MongoDB is: " + location);
                        }
                        String paragraph = dataFromDocument.getIntroBody();
                        paragraph = Jsoup.parse(paragraph).text();
                        System.out.println("paragraph:- " + paragraph);

                        BasicDBObject whereQuery = new BasicDBObject();
                        whereQuery.put("_id", elementIdInLong);
                        String[] postValue = getPostValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);

                        boolean headlineStatus = false;
                        if (headline.equalsIgnoreCase(headlineFromExcel)) {
                            headlineStatus = true;
                            Utils.logStepInfo("Headline is matching");
                        } else {
                            Utils.logStepInfo("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                            System.out.println("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                        }

                        boolean summaryStatus = false;
                        if (summaryWithoutHTMLTags.equalsIgnoreCase(summaryFromExcel)) {
                            summaryStatus = true;
                            Utils.logStepInfo("Summary is matching");
                        } else {
                            Utils.logStepInfo("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                            System.out.println("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                        }

                        boolean sectionStatus = false;
                        if (section.equalsIgnoreCase(sectionFromExcel)) {
                            sectionStatus = true;
                            Utils.logStepInfo("Section is matching");
                        } else {
                            Utils.logStepInfo("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                            System.out.println("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                        }

                        boolean subSectionStatus = false;
                        if (subSection.toLowerCase().contains(subSectionFromExcel.toLowerCase())) {
                            subSectionStatus = true;
                            Utils.logStepInfo("Sub Section is matching");
                        } else {
                            Utils.logStepInfo("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                            System.out.println("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                        }

                        boolean locationStatus = true;
                        if (!property.equals(Constants.MINT_LOUNGE) && !property.equals(Constants.TECH)) {
                            if(property.equals(Constants.SMART_24)){
                                String locationValue = dataFromDocument.getMetadata().getPrimaryLocation();
                                if(locationValue.toLowerCase().contains(locationFromExcel.toLowerCase())){
                                    locationStatus = true;
                                }else{
                                    locationStatus = false;
                                    Utils.logStepInfo("Location is not matching as expected:- " + locationFromExcel + " But found:- " + locationValue);
                                }
                            }else {
                                if (location.get(0).equals(locationFromExcel)) {
                                    locationStatus = true;
                                    Utils.logStepInfo("Location is matching");
                                } else {
                                    locationStatus = false;
                                    Utils.logStepInfo("Location is not matching as expected:- " + locationFromExcel + " But found:- " + location.get(0));
                                    System.out.println("Location is not matching as expected:- " + locationFromExcel + " But found:- " + location.get(0));
                                }
                            }
                        }

                        boolean byLineStatus = false;
                        if (byLine1.toLowerCase().contains(byLine.toLowerCase())) {
                            byLineStatus = true;
                            Utils.logStepInfo("By Line is matching");
                        } else {
                            Utils.logStepInfo("By Line is not matching as expected:- " + byLine.toLowerCase() + " But found:- " + byLine1.toLowerCase());
                            System.out.println("By Line is not matching as expected:- " + byLine.toLowerCase() + " But found:- " + byLine1.toLowerCase());
                        }

                        boolean paragraphStatus = false;
                        if (paragraph.equals(paragraphFromExcel) || paragraphFromExcel.isEmpty() || paragraphFromExcel.equals("") || paragraphFromExcel.equals(" ")) {
                            paragraphStatus = true;
                            Utils.logStepInfo("Paragraph is matching");
                        } else {
                            Utils.logStepInfo("Paragraph is not matching as expected:- " + paragraphFromExcel + " but found:- " + paragraph);
                            System.out.println("Paragraph is not matching as expected:- " + paragraphFromExcel + " but found:- " + paragraph);
                        }

                        boolean postTitleStatus = false;
                        if (postValue[0].equalsIgnoreCase(postTitleExcel)) {
                            postTitleStatus = true;
                            Utils.logStepInfo("Post Title is matching");
                        } else {
                            Utils.logStepInfo("Post Title is not matching as expected:- " + postTitleExcel + " but found:- " + postValue[0]);
                            System.out.println("Post Title is not matching as expected:- " + postTitleExcel + " but found:- " + postValue[0]);
                        }

                        boolean postBodyStatus = false;
                        if (postValue[1].equalsIgnoreCase(postBodyExcel)) {
                            postBodyStatus = true;
                            Utils.logStepInfo("Post Body is matching");
                        } else {
                            Utils.logStepInfo("Post Body is not matching as expected:- " + postBodyExcel + " But found:- " + postValue[1]);
                            System.out.println("Post Body is not matching as expected:- " + postBodyExcel + " But found:- " + postValue[1]);
                        }

                        boolean softPublishedStatus = true;
                        boolean killedBooleanStatus = true;
                        boolean deleteStatus = true;
                        boolean schedulePublishedStatus = true;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            if (expSoftPubStatus == softPub) {
                                softPublishedStatus = true;
                                Utils.logStepInfo("Soft Publish is matching");
                            } else {
                                softPublishedStatus = false;
                                Utils.logStepInfo("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                                System.out.println("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                            }

                            if (killedStatus == expKilledStatus) {
                                killedBooleanStatus = true;
                                Utils.logStepInfo("Killed Status is matching");
                            } else {
                                killedBooleanStatus = false;
                                Utils.logStepInfo("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                                System.out.println("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                            }

                            if (deleteValue == expDeleteValue) {
                                deleteStatus = true;
                                Utils.logStepInfo("Delete Value is matching");
                            } else {
                                deleteStatus = false;
                                Utils.logStepInfo("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                                System.out.println("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                            }

                            if (scheduleStatus) {
                                if (schValue.equalsIgnoreCase("SCHEDULED")) {
                                    schedulePublishedStatus = true;
                                    Utils.logStepInfo("SCHEDULED Value is matching");
                                } else {
                                    schedulePublishedStatus = false;
                                    Utils.logStepInfo("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                    System.out.println("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                }
                            }
                        }

                        isResultMatched[0] = headlineStatus && summaryStatus && sectionStatus && subSectionStatus && locationStatus && byLineStatus && paragraphStatus && softPublishedStatus && killedBooleanStatus && postTitleStatus && postBodyStatus && deleteStatus && schedulePublishedStatus;
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            });
        }else{
            isResultMatched[0] = true;
        }
        return isResultMatched[0];
    }

    public String[] getPostValue(DbConnection db,BasicDBObject whereQuery,String textUri,String database,String collection) {
        final String[] postValue = new String[2];
        FindIterable<Document> bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
        bp.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                try {
                    Gson gs = new Gson();
                    PostCreatedStory dataFromDocument = gs.fromJson(document.toJson(), PostCreatedStory.class);
                    String title = dataFromDocument.getTitle();
                    title = Jsoup.parse(title).text();
                    System.out.println("Post Title:- "+title);
                    String postBody=dataFromDocument.getLiveBlog().getBody();
                    postBody = Jsoup.parse(postBody).text();
                    System.out.println("Post Body:- "+postBody);
                    postValue[0] = title.trim();
                    postValue[1] = postBody.trim();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        return postValue;
    }

    public boolean verifyMongoDBConnectionAndVideoStoryDetailsOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, String embedUrlExcel, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus) {
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = null;
            for (int i = 0; i <= 10; i++) {
                bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
                Iterator it = bp.iterator();
                if (it.hasNext()) {
                    break;
                } else {
                    commonFunctions.hardWait(10000);
                }
            }
            String finalTextUri = textUri;
            String finalDatabase = database;
            String finalCollection = collection;
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    try {
                        Gson gs = new Gson();
                        BlankPaperStoryDataBackend dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryDataBackend.class);
                        String headline;
                        String postElementID = dataFromDocument.getElements().get(0).get$numberLong();
                        long elementIdInLong = Long.parseLong(postElementID);

                        headline = dataFromDocument.getTitle();
                        System.out.println("HeadLine from MongoDB is: " + headline);
                        String section = dataFromDocument.getMetadata().getSection();
                        System.out.println("section from MongoDB is: " + section);
                        String summary = dataFromDocument.getSummary();
                        String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                        System.out.println("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                        String subSection = dataFromDocument.getMetadata().getSubSection();
                        System.out.println("SubSection from MongoDB is: " + subSection);
                        boolean softPub = false;
                        boolean killedStatus = false;
                        int deleteValue = 0;
                        String schValue = null;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            softPub = dataFromDocument.getSoftPublished();
                            System.out.println("softPublish from MongoDB is: " + softPub);
                            killedStatus = dataFromDocument.getMetadata().getKilled();
                            System.out.println("killedStatus from MongoDB is: " + killedStatus);
                            deleteValue = dataFromDocument.getIsDeleted();
                            System.out.println("deleteValue from MongoDB is: " + deleteValue);
                            if (scheduleStatus) {
                                schValue = dataFromDocument.getMetadata().getStatus();
                                System.out.println("Schedule Published from MongoDB is: " + schValue);
                            }
                        }
                        String byLine1 = null;
                        if (property.equals(Constants.HT_NEW)) {
                            byLine1 = dataFromDocument.getMetadata().getAuthorsList().get(0).getName();
                        } else if ((property.equals(Constants.BANGLA)) || (property.equals(Constants.LIVEMINT)) || (property.equals(Constants.AUTO)) || (property.equals(Constants.TECH)) || (property.equals(Constants.MINT_LOUNGE)) || (property.equals(Constants.SMART_24))) {
                            byLine1 = dataFromDocument.getMetadata().getAuthors().toString().replace("[", "").replace("]", "").trim();
                        }
                        System.out.println("byLine from MongoDB is: " + byLine);
                        List<String> location = dataFromDocument.getMetadata().getLocation();
                        System.out.println("Location from MongoDB is: " + location);

                        BasicDBObject whereQuery = new BasicDBObject();
                        whereQuery.put("_id", elementIdInLong);
                        String[] videoValue = getVideoValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);

                        boolean headlineStatus = false;
                        if (headline.equalsIgnoreCase(headlineFromExcel)) {
                            headlineStatus = true;
                            Utils.logStepInfo("Headline is matching");
                        } else {
                            Utils.logStepInfo("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                            System.out.println("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                        }

                        boolean summaryStatus = false;
                        if (summaryWithoutHTMLTags.equalsIgnoreCase(summaryFromExcel)) {
                            summaryStatus = true;
                            Utils.logStepInfo("Summary is matching");
                        } else {
                            Utils.logStepInfo("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                            System.out.println("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                        }

                        boolean sectionStatus = false;
                        if (section.equalsIgnoreCase(sectionFromExcel)) {
                            sectionStatus = true;
                            Utils.logStepInfo("Section is matching");
                        } else {
                            Utils.logStepInfo("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                            System.out.println("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                        }

                        boolean subSectionStatus = false;
                        if (subSection.toLowerCase().contains(subSectionFromExcel.toLowerCase())) {
                            subSectionStatus = true;
                            Utils.logStepInfo("Sub Section is matching");
                        } else {
                            Utils.logStepInfo("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                            System.out.println("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                        }

                        boolean locationStatus = true;
                        if (!property.equals(Constants.MINT_LOUNGE) && !property.equals(Constants.TECH)) {
                            if(property.equals(Constants.SMART_24)){
                                String locationValue = dataFromDocument.getMetadata().getPrimaryLocation();
                                if(locationValue.toLowerCase().contains(locationFromExcel.toLowerCase())){
                                    locationStatus = true;
                                }else{
                                    locationStatus = false;
                                    Utils.logStepInfo("Location is not matching as expected:- " + locationFromExcel + " But found:- " + locationValue);
                                }
                            }else {
                                if (location.get(0).equals(locationFromExcel)) {
                                    locationStatus = true;
                                    Utils.logStepInfo("Location is matching");
                                } else {
                                    locationStatus = false;
                                    Utils.logStepInfo("Location is not matching as expected:- " + locationFromExcel + " But found:- " + location.get(0));
                                    System.out.println("Location is not matching as expected:- " + locationFromExcel + " But found:- " + location.get(0));
                                }
                            }
                        }

                        boolean byLineStatus = false;
                        if (byLine1.toLowerCase().contains(byLine.toLowerCase())) {
                            byLineStatus = true;
                            Utils.logStepInfo("By Line is matching");
                        } else {
                            Utils.logStepInfo("By Line is not matching as expected:- " + byLine.toLowerCase() + " But found:- " + byLine1.toLowerCase());
                            System.out.println("By Line is not matching as expected:- " + byLine.toLowerCase() + " But found:- " + byLine1.toLowerCase());
                        }

                        boolean videoBodyStatus = false;
                        if (videoValue[0].contains(embedUrlExcel)) {
                            videoBodyStatus = true;
                            Utils.logStepInfo("Video body is matching");
                        } else {
                            Utils.logStepInfo("Video body is not matching as expected:- " + embedUrlExcel + " but found:- " + videoValue[0]);
                            System.out.println("Video body is not matching as expected:- " + embedUrlExcel + " but found:- " + videoValue[0]);
                        }

                        boolean videoEmbedUrlStatus = false;
                        if (videoValue[1].equalsIgnoreCase(embedUrlExcel)) {
                            videoEmbedUrlStatus = true;
                            Utils.logStepInfo("EmbedUrl is matching");
                        } else {
                            Utils.logStepInfo("EmbedUrl is not matching as expected:- " + embedUrlExcel + " But found:- " + videoValue[1]);
                            System.out.println("EmbedUrl is not matching as expected:- " + embedUrlExcel + " But found:- " + videoValue[1]);
                        }

                        boolean softPublishedStatus = true;
                        boolean killedBooleanStatus = true;
                        boolean deleteStatus = true;
                        boolean schedulePublishedStatus = true;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            if (expSoftPubStatus == softPub) {
                                softPublishedStatus = true;
                                Utils.logStepInfo("Soft Publish is matching");
                            } else {
                                softPublishedStatus = false;
                                Utils.logStepInfo("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                                System.out.println("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                            }

                            if (killedStatus == expKilledStatus) {
                                killedBooleanStatus = true;
                                Utils.logStepInfo("Killed Status is matching");
                            } else {
                                killedBooleanStatus = false;
                                Utils.logStepInfo("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                                System.out.println("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                            }

                            if (deleteValue == expDeleteValue) {
                                deleteStatus = true;
                                Utils.logStepInfo("Delete Value is matching");
                            } else {
                                deleteStatus = false;
                                Utils.logStepInfo("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                                System.out.println("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                            }

                            if (scheduleStatus) {
                                if (schValue.equalsIgnoreCase("SCHEDULED")) {
                                    schedulePublishedStatus = true;
                                    Utils.logStepInfo("SCHEDULED Value is matching");
                                } else {
                                    schedulePublishedStatus = false;
                                    Utils.logStepInfo("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                    System.out.println("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                }
                            }
                        }

                        isResultMatched[0] = headlineStatus && summaryStatus && sectionStatus && subSectionStatus && locationStatus && byLineStatus && softPublishedStatus && killedBooleanStatus && videoBodyStatus && videoEmbedUrlStatus && deleteStatus && schedulePublishedStatus;
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            });
        }else{
            isResultMatched[0] = true;
        }
        return isResultMatched[0];
    }

    public String[] getVideoValue(DbConnection db,BasicDBObject whereQuery,String textUri,String database,String collection) {
        final String[] postValue = new String[2];
        FindIterable<Document> bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
        bp.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                try {
                    Gson gs = new Gson();
                    VideoStory dataFromDocument = gs.fromJson(document.toJson(), VideoStory.class);
                    String body = dataFromDocument.getVideo().getBody();
                    //body = Jsoup.parse(body).text();
                    System.out.println("Video Body:- "+body);
                    String embedUrl=dataFromDocument.getVideo().getEmbedUrl();
                    embedUrl = Jsoup.parse(embedUrl).text();
                    System.out.println("EmbedUrl:- "+embedUrl);
                    postValue[0] = body.trim();
                    postValue[1] = embedUrl.trim();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        return postValue;
    }

    public boolean verifyMongoDBConnectionAndDeadlinkStoryDetailsOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String sectionFromExcel, String subSectionFromExcel, String deadlinkSUrlExcel, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus) {
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = null;
            for (int i = 0; i <= 10; i++) {
                bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
                Iterator it = bp.iterator();
                if (it.hasNext()) {
                    break;
                } else {
                    commonFunctions.hardWait(10000);
                }
            }
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    try {
                        Gson gs = new Gson();
                        BlankPaperStoryDataBackend dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryDataBackend.class);
                        String headline;

                        headline = dataFromDocument.getTitle();
                        System.out.println("HeadLine from MongoDB is: " + headline);
                        String section = dataFromDocument.getMetadata().getSection();
                        System.out.println("section from MongoDB is: " + section);
                        String summary = dataFromDocument.getSummary();
                        String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                        System.out.println("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                        String subSection = dataFromDocument.getMetadata().getSubSection();
                        System.out.println("SubSection from MongoDB is: " + subSection);
                        String deadlinkUrl = dataFromDocument.getMetadata().getDeadLinkUrl();
                        System.out.println("deadlinkUrl from MongoDB is: " + deadlinkUrl);
                        boolean softPub = false;
                        boolean killedStatus = false;
                        int deleteValue = 0;
                        String schValue = null;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            softPub = dataFromDocument.getSoftPublished();
                            System.out.println("softPublish from MongoDB is: " + softPub);
                            killedStatus = dataFromDocument.getMetadata().getKilled();
                            System.out.println("killedStatus from MongoDB is: " + killedStatus);
                            deleteValue = dataFromDocument.getIsDeleted();
                            System.out.println("deleteValue from MongoDB is: " + deleteValue);
                            if (scheduleStatus) {
                                schValue = dataFromDocument.getMetadata().getStatus();
                                System.out.println("Schedule Published from MongoDB is: " + schValue);
                            }
                        }
                        boolean headlineStatus = false;
                        if (headline.equalsIgnoreCase(headlineFromExcel)) {
                            headlineStatus = true;
                            Utils.logStepInfo("Headline is matching");
                        } else {
                            Utils.logStepInfo("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                            System.out.println("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                        }

                        boolean summaryStatus = false;
                        if (summaryWithoutHTMLTags.equalsIgnoreCase(summaryFromExcel)) {
                            summaryStatus = true;
                            Utils.logStepInfo("Summary is matching");
                        } else {
                            Utils.logStepInfo("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                            System.out.println("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                        }

                        boolean sectionStatus = false;
                        if (section.equalsIgnoreCase(sectionFromExcel)) {
                            sectionStatus = true;
                            Utils.logStepInfo("Section is matching");
                        } else {
                            Utils.logStepInfo("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                            System.out.println("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                        }

                        boolean subSectionStatus = false;
                        if (subSection.toLowerCase().contains(subSectionFromExcel.toLowerCase())) {
                            subSectionStatus = true;
                            Utils.logStepInfo("Sub Section is matching");
                        } else {
                            Utils.logStepInfo("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                            System.out.println("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                        }

                        boolean deadlinkUrlStatus = false;
                        if (deadlinkUrl.trim().equalsIgnoreCase(deadlinkSUrlExcel.trim())) {
                            deadlinkUrlStatus = true;
                            Utils.logStepInfo("DeadlinkUrl is matching");
                        } else {
                            Utils.logStepInfo("DeadlinkUrl is not matching as expected:- " + deadlinkSUrlExcel + " But found:- " + deadlinkUrl);
                            System.out.println("DeadlinkUrl is not matching as expected:- " + deadlinkSUrlExcel + " But found:- " + deadlinkUrl);
                        }

                        boolean softPublishedStatus = true;
                        boolean killedBooleanStatus = true;
                        boolean deleteStatus = true;
                        boolean schedulePublishedStatus = true;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            if (expSoftPubStatus == softPub) {
                                softPublishedStatus = true;
                                Utils.logStepInfo("Soft Publish is matching");
                            } else {
                                softPublishedStatus = false;
                                Utils.logStepInfo("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                                System.out.println("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                            }

                            if (killedStatus == expKilledStatus) {
                                killedBooleanStatus = true;
                                Utils.logStepInfo("Killed Status is matching");
                            } else {
                                killedBooleanStatus = false;
                                Utils.logStepInfo("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                                System.out.println("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                            }

                            if (deleteValue == expDeleteValue) {
                                deleteStatus = true;
                                Utils.logStepInfo("Delete Value is matching");
                            } else {
                                deleteStatus = false;
                                Utils.logStepInfo("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                                System.out.println("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                            }

                            if (scheduleStatus) {
                                if (schValue.equalsIgnoreCase("SCHEDULED")) {
                                    schedulePublishedStatus = true;
                                    Utils.logStepInfo("SCHEDULED Value is matching");
                                } else {
                                    schedulePublishedStatus = false;
                                    Utils.logStepInfo("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                    System.out.println("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                }
                            }
                        }

                        isResultMatched[0] = headlineStatus && summaryStatus && sectionStatus && subSectionStatus && softPublishedStatus && killedBooleanStatus && deleteStatus && schedulePublishedStatus && deadlinkUrlStatus;
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            });
        }else{
            isResultMatched[0] = true;
        }
        return isResultMatched[0];
    }

    public boolean verifyMongoDBConnectionAndHighlightsDetailsOnBackend(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String sectionFromExcel, String subSectionFromExcel, String locationFromExcel, String byLine, String highlightsItemExcel, boolean expSoftPubStatus, boolean expKilledStatus, int expDeleteValue, boolean scheduleStatus) {
        final boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = null;
            for (int i = 0; i <= 10; i++) {
                bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
                Iterator it = bp.iterator();
                if (it.hasNext()) {
                    break;
                } else {
                    commonFunctions.hardWait(10000);
                }
            }
            String finalTextUri = textUri;
            String finalDatabase = database;
            String finalCollection = collection;
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    try {
                        Gson gs = new Gson();
                        BlankPaperStoryDataBackend dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryDataBackend.class);
                        String headline;
                        String highlightsElementID = dataFromDocument.getElements().get(0).get$numberLong();
                        long elementIdInLong = Long.parseLong(highlightsElementID);

                        headline = dataFromDocument.getTitle();
                        System.out.println("HeadLine from MongoDB is: " + headline);
                        String section = dataFromDocument.getMetadata().getSection();
                        System.out.println("section from MongoDB is: " + section);
                        String summary = dataFromDocument.getSummary();
                        String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                        System.out.println("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                        String subSection = dataFromDocument.getMetadata().getSubSection();
                        System.out.println("SubSection from MongoDB is: " + subSection);
                        boolean softPub = false;
                        boolean killedStatus = false;
                        int deleteValue = 0;
                        String schValue = null;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            softPub = dataFromDocument.getSoftPublished();
                            System.out.println("softPublish from MongoDB is: " + softPub);
                            killedStatus = dataFromDocument.getMetadata().getKilled();
                            System.out.println("killedStatus from MongoDB is: " + killedStatus);
                            deleteValue = dataFromDocument.getIsDeleted();
                            System.out.println("deleteValue from MongoDB is: " + deleteValue);
                            if (scheduleStatus) {
                                schValue = dataFromDocument.getMetadata().getStatus();
                                System.out.println("Schedule Published from MongoDB is: " + schValue);
                            }
                        }
                        String byLine1 = null;
                        if (property.equals(Constants.HT_NEW)) {
                            byLine1 = dataFromDocument.getMetadata().getAuthorsList().get(0).getName();
                        } else if ((property.equals(Constants.BANGLA)) || (property.equals(Constants.LIVEMINT)) || (property.equals(Constants.AUTO)) || (property.equals(Constants.TECH)) || (property.equals(Constants.MINT_LOUNGE)) || (property.equals(Constants.SMART_24))) {
                            byLine1 = dataFromDocument.getMetadata().getAuthors().toString().replace("[", "").replace("]", "").trim();
                        }
                        System.out.println("byLine from MongoDB is: " + byLine1);
                        List<String> location = dataFromDocument.getMetadata().getLocation();
                        System.out.println("Location from MongoDB is: " + location);

                        BasicDBObject whereQuery = new BasicDBObject();
                        whereQuery.put("_id", elementIdInLong);
                        String[] highlightsValue = getHighlightsValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);

                        boolean headlineStatus = false;
                        if (headline.equalsIgnoreCase(headlineFromExcel)) {
                            headlineStatus = true;
                            Utils.logStepInfo("Headline is matching");
                        } else {
                            Utils.logStepInfo("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                            System.out.println("Headline is not matching as Expected:- " + headlineFromExcel + " But found:- " + headline);
                        }

                        boolean summaryStatus = false;
                        if (summaryWithoutHTMLTags.equalsIgnoreCase(summaryFromExcel)) {
                            summaryStatus = true;
                            Utils.logStepInfo("Summary is matching");
                        } else {
                            Utils.logStepInfo("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                            System.out.println("Summary is not matching as Expected:- " + summaryFromExcel + " But found:- " + summaryWithoutHTMLTags);
                        }

                        boolean sectionStatus = false;
                        if (section.equalsIgnoreCase(sectionFromExcel)) {
                            sectionStatus = true;
                            Utils.logStepInfo("Section is matching");
                        } else {
                            Utils.logStepInfo("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                            System.out.println("Section is not matching as Expected:- " + sectionFromExcel + " But found:- " + section);
                        }

                        boolean subSectionStatus = false;
                        if (subSection.toLowerCase().contains(subSectionFromExcel.toLowerCase())) {
                            subSectionStatus = true;
                            Utils.logStepInfo("Sub Section is matching");
                        } else {
                            Utils.logStepInfo("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                            System.out.println("Sub Section is not matching as Expected:- " + subSectionFromExcel.toLowerCase() + " But found:- " + subSection.toLowerCase());
                        }

                        boolean locationStatus = true;
                        if (!property.equals(Constants.MINT_LOUNGE) && !property.equals(Constants.TECH)) {
                            if(property.equals(Constants.SMART_24)){
                                String locationValue = dataFromDocument.getMetadata().getPrimaryLocation();
                                if(locationValue.toLowerCase().contains(locationFromExcel.toLowerCase())){
                                    locationStatus = true;
                                }else{
                                    locationStatus = false;
                                    Utils.logStepInfo("Location is not matching as expected:- " + locationFromExcel + " But found:- " + locationValue);
                                }
                            }else {
                                if (location.get(0).equals(locationFromExcel)) {
                                    locationStatus = true;
                                    Utils.logStepInfo("Location is matching");
                                } else {
                                    locationStatus = false;
                                    Utils.logStepInfo("Location is not matching as expected:- " + locationFromExcel + " But found:- " + location.get(0));
                                    System.out.println("Location is not matching as expected:- " + locationFromExcel + " But found:- " + location.get(0));
                                }
                            }
                        }

                        boolean byLineStatus = false;
                        if (byLine1.toLowerCase().contains(byLine.toLowerCase())) {
                            byLineStatus = true;
                            Utils.logStepInfo("By Line is matching");
                        } else {
                            Utils.logStepInfo("By Line is not matching as expected:- " + byLine.toLowerCase() + " But found:- " + byLine1.toLowerCase());
                            System.out.println("By Line is not matching as expected:- " + byLine.toLowerCase() + " But found:- " + byLine1.toLowerCase());
                        }

                        boolean highlightsStatus = false;
                        if (highlightsValue[0].contains(highlightsItemExcel)) {
                            highlightsStatus = true;
                            Utils.logStepInfo("Video body is matching");
                        } else {
                            Utils.logStepInfo("Highlights value is not matching as expected:- " + highlightsItemExcel + " but found:- " + highlightsValue[0]);
                            System.out.println("Highlights value is not matching as expected:- " + highlightsItemExcel + " but found:- " + highlightsValue[0]);
                        }


                        boolean softPublishedStatus = true;
                        boolean killedBooleanStatus = true;
                        boolean deleteStatus = true;
                        boolean schedulePublishedStatus = true;
                        if (storyStatus.equalsIgnoreCase("CREATED")) {
                            if (expSoftPubStatus == softPub) {
                                softPublishedStatus = true;
                                Utils.logStepInfo("Soft Publish is matching");
                            } else {
                                softPublishedStatus = false;
                                Utils.logStepInfo("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                                System.out.println("Soft Publish is not matching as expected:- " + expSoftPubStatus + " but found:- " + softPub);
                            }

                            if (killedStatus == expKilledStatus) {
                                killedBooleanStatus = true;
                                Utils.logStepInfo("Killed Status is matching");
                            } else {
                                killedBooleanStatus = false;
                                Utils.logStepInfo("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                                System.out.println("Killed Status is not matching as expected:- " + expKilledStatus + " But found:- " + killedStatus);
                            }

                            if (deleteValue == expDeleteValue) {
                                deleteStatus = true;
                                Utils.logStepInfo("Delete Value is matching");
                            } else {
                                deleteStatus = false;
                                Utils.logStepInfo("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                                System.out.println("Delete Value is not matching as expected:- " + expDeleteValue + " But Found:- " + deleteValue);
                            }

                            if (scheduleStatus) {
                                if (schValue.equalsIgnoreCase("SCHEDULED")) {
                                    schedulePublishedStatus = true;
                                    Utils.logStepInfo("SCHEDULED Value is matching");
                                } else {
                                    schedulePublishedStatus = false;
                                    Utils.logStepInfo("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                    System.out.println("SCHEDULED Value is not matching as expected:- SCHEDULED but found:- " + schValue);
                                }
                            }
                        }

                        isResultMatched[0] = headlineStatus && summaryStatus && sectionStatus && subSectionStatus && locationStatus && byLineStatus && softPublishedStatus && killedBooleanStatus && highlightsStatus && deleteStatus && schedulePublishedStatus;
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

            });
        }else{
            isResultMatched[0] = true;
        }
        return isResultMatched[0];
    }

    public String[] getHighlightsValue(DbConnection db,BasicDBObject whereQuery,String textUri,String database,String collection) {
        final String[] postValue = new String[1];
        FindIterable<Document> bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
        bp.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
                try {
                    Gson gs = new Gson();
                    ListicleStory dataFromDocument = gs.fromJson(document.toJson(), ListicleStory.class);
                    String body = dataFromDocument.getListicle().getBody();
                    body = Jsoup.parse(body).text();
                    System.out.println("Listicle Body:- "+body);
                    postValue[0] = body.trim();
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        return postValue;
    }

    @Override
    public boolean CheckIfOrangeBackgroundColorIsPresentAroundCreatedText(String backgroundColor) {
        filterCreatedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        return commonFunctions.getBackgroundColorOfWebElement(publishedStoryStatusCreated,10,"created status","background-color").equalsIgnoreCase(backgroundColor);
    }

    @Override
    public boolean CheckIfGreenBackgroundColorIsPresentAroundPublishedText(String backgroundColor) {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        return commonFunctions.getBackgroundColorOfWebElement(publishedStoryStatus,10,"published status","background-color").equalsIgnoreCase(backgroundColor);
    }

    @Override
    public boolean CheckIfTheBackgroundColorOfPublishedTextIsSameAsTextColor(String backgroundColor, String textColor) {
        filterPublishedStories();
        commonFunctions.clickElementIfDisplayed(statusFilter,10);
        boolean isBgColorSame=commonFunctions.getBackgroundColorOfWebElement(publishedStoryStatus,10,"published status","background-color").equalsIgnoreCase(backgroundColor);
        boolean isColorSame=commonFunctions.getColorOfWebElement(publishedStoryStatus,10,"published status","color").equalsIgnoreCase(textColor);
        return isBgColorSame && isColorSame;
    }

    @Override
    public boolean CheckIfTheBackgroundColorOfCreatedTextIsSameAsTextColor(String backgroundColor, String textColor) {
        filterCreatedStories();
        boolean isBgColorSame=commonFunctions.getBackgroundColorOfWebElement(publishedStoryStatusCreated,10,"created status","background-color").equalsIgnoreCase(backgroundColor);
        boolean isColorSame=commonFunctions.getColorOfWebElement(publishedStoryStatusCreated,10,"created status","color").equalsIgnoreCase(textColor);
        return isBgColorSame && isColorSame;
    }

    @Override
    public boolean CheckIfTheBackgroundColorOfEditedTextIsSameAsTextColor(String backgroundColor, String textColor) {
        filterEditedStories();
        boolean isBgColorSame=commonFunctions.getBackgroundColorOfWebElement(StoryStatusEdited,10,"edited status","background-color").equalsIgnoreCase(backgroundColor);
        boolean isColorSame=commonFunctions.getColorOfWebElement(StoryStatusEdited,10,"edited status","color").equalsIgnoreCase(textColor);
        return isBgColorSame && isColorSame;
    }

    @Override
    public boolean CheckIfBlueBackgroundColorShouldBePresentAroundEditedText(String backgroundColor) {
        filterEditedStories();
        commonFunctions.clickElement(typeFilter, 30, "type filter");
        return commonFunctions.getBackgroundColorOfWebElement(StoryStatusEdited,10,"edited status","background-color").equalsIgnoreCase(backgroundColor);
    }

    @Override
    public boolean CheckIfUserIsAbleToSelectTenantsMintGenieOrHtNewFromDropDowns(String property) {
        return checkSelectedDomain(property);
    }

    @Override
    public boolean CheckIfTheBackgroundColorOfFiledTextIsSameAsTextColor(String backgroundColor, String textColor) {
        filterFiledStories();
        boolean isBgColorSame=commonFunctions.getBackgroundColorOfWebElement(StoryStatusFiled,10,"filed status","background-color").equalsIgnoreCase(backgroundColor);
        boolean isColorSame=commonFunctions.getColorOfWebElement(StoryStatusFiled,10,"filed status","color").equalsIgnoreCase(textColor);
        return isBgColorSame && isColorSame;
    }

    @Override
    public boolean CheckIfPurpleBackgroundColorShouldBePresentAroundFiledText(String backgroundColor) {
        filterFiledStories();
        commonFunctions.clickElement(typeFilter, 30, "type filter");
        return commonFunctions.getBackgroundColorOfWebElement(StoryStatusFiled,10,"filed status","background-color").equalsIgnoreCase(backgroundColor);
    }

    @Override
    public boolean CheckIfGreyBackgroundColorShouldBePresentAroundKilledText(String backgroundColor) {
        filterKilledStories();
        commonFunctions.clickElement(typeFilter, 30, "type filter");
        return commonFunctions.getBackgroundColorOfWebElement(StoryStatusKilled,10,"killed status","background-color").equalsIgnoreCase(backgroundColor);

    }

    @Override
    public boolean checkIfUserIsAbleToSelectTenantsBanglaFromDropDowns(String property) {
        return checkSelectedDomain(property);
    }

    @Override
    public boolean checkIfUserIsAbleToClickOnCreateStoryButtonForBangla() {
        boolean isResult=commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        return isResult;
    }

    @Override
    public boolean checkIfUserIsAbleToSeePagesTabPresentInSidebar() {
        return commonFunctions.isElementDisplayed(pagesButton,10,"pages tab");
    }

    @Override
    public boolean checkIftUserIsAbleToClickPagesTabPresentInSidebar(String backgroundColor) {
        commonFunctions.clickElementIfDisplayed(PagesTab,10,"pages tab");
        String bgColor=commonFunctions.getBackgroundColorOfWebElement(PagesTab,10,"backgroundColor","background-color");
        return bgColor.equals(backgroundColor);
    }

    @Override
    public boolean checkIfUserIsAbleToClickOnCreateAPageButtonPresentInTheRightCorner() {
        commonFunctions.clickElementIfDisplayed(PagesTab,10,"pages tab");
        boolean isResult=commonFunctions.clickElementWithAction(createStoryButton, 20, "story type menu button");
        return isResult;
    }

    @Override
    public boolean checkIfUserIsAbleToClickOnDashboardTab(String backgroundColor) {
        commonFunctions.clickElementIfDisplayed(PagesTab,10,"pages tab");
        commonFunctions.clickElementIfDisplayed(dashboardButton,10,"dashboard button");
        String bgColor=commonFunctions.getBackgroundColorOfWebElement(dashboardButton,10,"bashboard button color","background-color");
        return bgColor.equals(backgroundColor);
    }

    @Override
    public boolean verifyMongoDBConnectionAndStoryDetailsInDatabase(String storyStatus, String storyID,String property, String env, String headlineFromExcel, String summaryFromExcel, String paragraphFromExcel) {
        boolean[] isResultMatched = {false};
        String textUri = null;
        String database = null;
        String collection = null;
        long storyIdInLong = Long.parseLong(storyID);
        DbConnection db = new DbConnection();
        boolean flag = db.setConnectionStrings(storyStatus, env,property);
        if(flag) {
            textUri = db.getTextUri();
            database = db.getDatabase();
            collection = db.getCollection();
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", storyIdInLong);
            FindIterable<Document> bp = null;
            for (int i = 0; i <= 10; i++) {
                bp = db.makeMongoDBConnection(whereQuery, textUri, database, collection);
                Iterator it = bp.iterator();
                if (it.hasNext()) {
                    break;
                } else {
                    commonFunctions.hardWait(10000);
                }
            }
            String finalTextUri = textUri;
            String finalDatabase = database;
            String finalCollection = collection;
            bp.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                    Gson gs = new Gson();
                    BlankPaperStoryData dataFromDocument = gs.fromJson(document.toJson(), BlankPaperStoryData.class);
                    String headline;
                    String paragraphElementID = dataFromDocument.getElements().get(0).get$numberLong();
                    long elementIdInLong = Long.parseLong(paragraphElementID);
                    if (storyStatus.equals("PUBLISHED")) {
                        headline = dataFromDocument.getHeadline();
                    } else {
                        headline = dataFromDocument.getTitle();
                    }
                    Utils.logStepInfo("HeadLine from MongoDB is: " + headline);
                    String summary = dataFromDocument.getSummary();
                    String summaryWithoutHTMLTags = Jsoup.parse(summary).text();
                    Utils.logStepInfo("Summary from MongoDB is: " + summaryWithoutHTMLTags);
                    String paragraphWithoutHTMLTags = null;
                    switch (property) {
                        case Constants.HT_NEW:
                            try {
                                List<ListElement> paragraph = dataFromDocument.getListElement();
                                String paragraphBody = paragraph.get(0).getParagraph().getBody();
                                paragraphWithoutHTMLTags = Jsoup.parse(paragraphBody).text();
                            }catch(Exception e){
                                BasicDBObject whereQuery = new BasicDBObject();
                                whereQuery.put("_id", elementIdInLong);
                                paragraphWithoutHTMLTags = getParagraphValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);
                            }
                            break;
                        case Constants.TECH:
                        case Constants.LIVEMINT:
                        case Constants.MINT_LOUNGE:
                        case Constants.AUTO:
                        case Constants.BANGLA:
                        case Constants.SMART_24:
                            BasicDBObject whereQuery = new BasicDBObject();
                            whereQuery.put("_id", elementIdInLong);
                            paragraphWithoutHTMLTags = getParagraphValue(db, whereQuery, finalTextUri, finalDatabase, finalCollection);
                            break;
                    }
                    Utils.logStepInfo("Paragraph from MongoDB is: " + paragraphWithoutHTMLTags);
                    isResultMatched[0]=(headline.equalsIgnoreCase(headlineFromExcel)
                                        && summaryWithoutHTMLTags.equals(summaryFromExcel))
                                        && paragraphWithoutHTMLTags.equals(paragraphFromExcel);
                }
            });
        }
        return isResultMatched[0];
    }

}

