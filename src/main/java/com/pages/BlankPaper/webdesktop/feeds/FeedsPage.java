package com.pages.BlankPaper.webdesktop.feeds;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.CommonFeedsPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Converter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FeedsPage extends CommonFeedsPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//li[contains(@class,'feeds')]")
    private static WebElement feedsLink;

    @FindBy(xpath = "//div[contains(text(), 'Live Hindustan')]")
    private static WebElement Lhgallerydata;

    @FindBy(xpath = "//span[contains(text(),'LH Gallery Feed')]")
    private static WebElement LHgalleryfeed;

    @FindBy(xpath = "//div[contains(@class,'tabs')]//span[contains(text(),'Print Feed')]")
    private static WebElement printFeedsTab;

    @FindBy(xpath = "//span[@id='defaultOpen']")
    private static WebElement agencyFeedsTab;

    @FindBy(xpath = "//div[contains(@class,'close fl')]")
    private static WebElement closeButtonAgencyFeedPopup;

    @FindBy(xpath = "//div[contains(@class,'lightBox')]//button[contains(@class,'createCard')]")
    private static WebElement copiedForPublishButton;

    @FindBy(xpath = "//div[contains(@class,'lightBox')]//button[contains(@class,'createStory')]")
    private static WebElement pickAsAStoryPublishButton;

    @FindBy(xpath = "//div[contains(@class,'lightContent')]")
    private static WebElement agencyFeedsPopup;

    @FindBy(xpath = "//span[contains(text(),'Print Feed')]")
    private static WebElement printFeedTab;

    @FindBy(xpath = "//div//button[@class='createStory']")
    private static WebElement createStoryButton;

    @FindBy(xpath = "//*[@class='storytype']//button")
    private static List<WebElement> listOfStoryType;

    @FindBy(xpath = "//div[contains(@class,'contentList')]//ul[contains(@class,'locked')]")
    private static List<WebElement> agencyFeedList;

    @FindBy(xpath = "//div[contains(@class,'contentList')]//ul[contains(@class,'locked')]//li[@class='headline']")
    private static List<WebElement> agencyFeedHeadingList;

    @FindBy(xpath = "//div[contains(@class,'contentList')]//ul[contains(@class,'locked')]//li[@class='pickUp']//span[contains(@class,'pickStory')]")
    private static List<WebElement> pickUpList;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement storyHeadingList;

    @FindBy(xpath = "//li[contains(@class,'receivedAt')]//div[contains(@class,'listCell')]")
    private static List<WebElement> receivedAtList;

    @FindBy(xpath = "//div[contains(@class,'recordList') and contains(text(),'Showing ')]")
    private static WebElement bottomFilteredResults;

    @FindBy(xpath = "//div[contains(@class,'contentList')]//ul[contains(@class,'locked')]//li[contains(@class,'agency')]")
    private static List<WebElement> agencyColumnFeedList;

    @FindBy(xpath = "//div[contains(@class,'contentList')]//ul[contains(@class,'locked')]//li[contains(@class,'section')]")
    private static List<WebElement> sectionColumnFeedList;

    @FindBy(xpath = "//th[contains(@class,'month')]")
    private static List<WebElement> twoMonthsListOnCalendar;

    private static String dateToBeSelected = "//th[@class='month' and contains(text(),'%s')]/ancestor::table//td[(text()='%s')]";

    @FindBy(xpath = "//button[contains(@class,'applyBtn')]")
    private static WebElement applyButtonOnCalendar;

    @FindBy(xpath = "//button[contains(@class,'cancel')]")
    private static WebElement clearButtonOnCalendar;

    @FindBy(xpath = "//th[contains(@class,'prev available')]")
    private static WebElement previousArrow;

    @FindBy(xpath = ".//li[contains(@class,'headline')]")
    private static WebElement headlineColumn;

    @FindBy(xpath = ".//li[contains(@class,'agency')]")
    private static WebElement agencyColumn;

    @FindBy(xpath = ".//li[contains(@class,'section')]")
    private static WebElement sectionColumn;

    @FindBy(xpath = ".//li[contains(@class,'receivedAt')]")
    private static WebElement receivedAtColumn;

    @FindBy(xpath = ".//li[contains(@class,'pickUp')]")
    private static WebElement pickupColumn;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//div[@class='recordList']//following::select[@name='recordList']")
    private static WebElement dropDownRecordListInPagination;

    @FindBy(xpath = "//div[@class='tabcontainer']//div[@class='footerPagination']//child::div[contains(@class,'recordList')]")
    private static WebElement noOfRecordInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[1]")
    private static List<WebElement> pageOneInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[2]")
    private static List<WebElement> pageTwoInPagination;

    @FindBy(xpath = "//div[@class='pagination']//descendant::li[3]")
    private static List<WebElement> pageThreeInPagination;

    @FindBy(xpath = "//div[@class='contentList']/div[@class='storyListing']")
    private static List<WebElement> storyContentsListInPagination;

    @FindBy(xpath = "//span[@class='tab' and contains(text(),'Agency')]")
    private static WebElement agencyFilterDropdown;

    @FindBy(xpath = "//span[contains(@class,'created')]")
    private static WebElement autoSavedChangesLabel;

    @FindBy(xpath = "//div[contains(@class,'searchBlock')]//input[contains(@class,'search-com')]")
    private static WebElement searchInputBox;

    @FindBy(xpath = "//div[contains(@class,'footer')]/div[contains(@class,'recordList') and contains(text(),'results')]")
    private static WebElement showingResult;

    @FindBy(xpath = "//div[contains(@class,'searchfilter')]")
    private static WebElement searchFilter;

    @FindBy(xpath = "//span[@class='tab' and contains(text(),'Section')]")
    private static WebElement sectionFilterDropdown;

    @FindBy(xpath = "//span[@id='mydate' and contains(text(),'Published')]")
    private static WebElement PublishedFilterDropdown;

    @FindBy(xpath = "//div[contains(@class,'filterdrop block')]")
    private static WebElement agencyAndSectionFilterDropdownBlock;

    @FindBy(xpath = "//div[contains(@class,'notificationBtn')]//span[contains(text(),'Send Notification')]")
    private static WebElement sendNotificationButton;

    @FindBy(xpath = "//div[@class='rightBlock']//button[contains(@class,'createStory')]")
    private static WebElement createAStoryButton;

    @FindBy(xpath = "//div[@class='rightBlock']//child::li//button[@class='green' and text()='Publish']")
    private static WebElement buttonPublish;

    private static String agencyDropdownValue = "//li//label[contains(text(),'%s')]";

    private static String sectionDropdownValue = "//ul[@id='section']//li//label[contains(text(),'%s')]";

    @FindBy(xpath = "//div[contains(@class,'contentList')]/ul[1]/li[1]")
    private static WebElement firstStoryAgencyFeed;

    @FindBy(name = "pickedtimes")
    private static WebElement copyForPublishButton;

    @FindBy(name = "pickedstory")
    private static WebElement pickAsAStoryButton;

    @FindBy(xpath = "//div[contains(@class,'contentList')]/ul")
    private static List<WebElement> allStoriesAgencyFeed;

    @FindBy(xpath = "//div[contains(@class,'close fl spImg')]")
    private static WebElement crossIcon;

    @FindBy(xpath = "//filter[contains(@ng-reflect-filter-id,'section')]")
    private static WebElement sectionFilter;

    @FindBy(xpath = "//filter[contains(@ng-reflect-filter-id,'status')]")
    private static WebElement statusFilter;


    @FindBy(xpath = "(//input[contains(@class,'textBox')])[2]")
    private static WebElement filterSectionInputBox;

    @FindBy(xpath = "(//input[contains(@class,'textBox')])[3]")
    private static WebElement filterStatusInputBox;


    @FindBy(xpath = "(//span[contains(@class,'checkmark')])[1]")
    private static WebElement filterSectionCheckBox;

    @FindBy(xpath = "(//span[contains(@class,'checkmark')])[2]")
    private static WebElement filterStatusCheckBox;

    @FindBy(xpath = "//div[contains(@class,'contentList')]//ul[contains(@class,'locked')]//li[contains(@class,'status')]")
    private static List<WebElement> statusColumnFeedList;
    @FindBy(id = "agencyFilterInputBox")
    private static WebElement agencyFilterInputBox;
    @FindBy(xpath = "(//div[contains(@class,'listCell')])[2]")
    private static WebElement firstAgencyName;
    @FindBy(xpath = "(//div[contains(@class,'listCell')])[3]")
    private static WebElement firstSectionName;

    @FindBy(xpath = "//section[@class='mainContainer']//select[@id='dropDownForDomainsSection']" )
    private static WebElement tenantDrpDown;

    @FindBy(xpath = "//span[@id='defaultOpen' and contains(text(), 'LH Gallery Feed')]")
    private static WebElement lhGalleryFeed;

    @FindBy(xpath = "//div[@class='contentList']/ul")
    private static List<WebElement> lhGalleryFeedContent;

    @FindBy(name = "pickedstory")
    private static WebElement pickAsStoryButton;

    @FindBy(xpath = "//div[@class='snotifyToast__buttons']/button[contains(text(), 'Yes')]")
    private static WebElement yesButton;

    @FindBy(xpath = "(//div[@role='textbox']/p)[1]")
    private static WebElement storyTitle;

    @FindBy(xpath = "//div[@class='arrow_box single']/..")
    private static List<WebElement> lhGalleryFeedContentPencilLink;

    @FindBy(xpath = "(//div[contains(@class,'editor')]//p)[1]")
    private static WebElement enterHeadlineText;

    @FindBy(xpath = "(//div[contains(@class,'ck-editor__main')])[2]/div")
    private static WebElement addSummaryText;

    @FindBy(xpath = "(//span[@id='buttonEditForImage']/i)[1]")
    private static WebElement editImagePencilIcon;

    @FindBy(xpath = "//li[@class='selectlead']/div/label/span")
    private static WebElement setAsLeadlMediaToggle;

    @FindBy(id = "buttonCropingDone")
    private static WebElement doneButton;

    @FindBy(name = "saveStory")
    private static WebElement saveStoryDoneButton;

    @FindBy(xpath = "//ul[@id='myTags']//li[@class='tagit-new']//input[contains(@placeholder,'Byline')]")
    private static WebElement inputAddByLineText;

    @FindBy(id = "buttonPublish")
    private static WebElement publishButton;

    @FindBy(xpath = "//div[@class='snotifyToast__body' and contains(text(),'Published successfully')]")
    private static WebElement popupPublishMessage;

    @FindBy(xpath = "//div[contains(@class,'wirePreview')]//div[@class='lightContent']")
    private static WebElement lhPreviewData;

    @FindBy(xpath = "//div[contains(@class,'tabs tabBlue')]")
    private static WebElement feedTypes;

    @FindBy(xpath = "(//div[@class='headingsList'])[1]//ul/li")
    private static List<WebElement> HeadingList;



    public FeedsPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    @Override
    public boolean isFeedsExpandable(){
        boolean isFeedPopupDisplayed;
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(agencyFeedsTab,30,"Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIgnoringStaleElement(agencyFeedsTab,30,"Agency Feed Tab");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,30,"Wait for agency feed list displayed");
        commonFunctions.clickElement(agencyFeedList.get(0),20,"Agency Feed First Row");
        isFeedPopupDisplayed=commonFunctions.isElementDisplayedAndPresent(agencyFeedsPopup,30,"Agency Feed popup displayed");
        commonFunctions.clickElement(closeButtonAgencyFeedPopup,20,"Close button of agency feed popup");
        return isFeedPopupDisplayed;
    }

    @Override
    public boolean islhgallerydatapresent(){
        selectFeedsLink();
        commonFunctions.clickElementIfDisplayed(LHgalleryfeed,20,"LHgallery");
        return commonFunctions.isElementDisplayed(Lhgallerydata,30,"lhgallerydata");
    }

    @Override
    public boolean isFeedsExpandableForPrintFeed(){
        boolean isFeedPopupDisplayed;
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(printFeedsTab,30,"Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIfDisplayed(printFeedsTab,20,"Competition Feed tab");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,30,"Wait for Competition feed list displayed");
        commonFunctions.clickElement(agencyFeedList.get(0),20,"Competition Feed First Row");
        isFeedPopupDisplayed=commonFunctions.isElementDisplayedAndPresent(agencyFeedsPopup,30,"Competition Feed popup displayed");
        commonFunctions.clickElement(closeButtonAgencyFeedPopup,20,"Close button of Competition feed popup");
        return isFeedPopupDisplayed;
    }

    private void selectFeedsLink() {
        commonFunctions.isElementDisplayedAndPresent(feedsLink,20,"wait for Feeds link to be displayed");
        commonFunctions.clickElement(feedsLink, 25, "Feeds Link button");
    }


    @Override
    public boolean checkAgencyAndSectionFilters(String agency, String section) {
        boolean isAgencyValueMatched=false;
        boolean isSectionValueMatched = false;
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(agencyFilterDropdown, 20, "Wait for Agency Dropdown");
        commonFunctions.clickElement(agencyFilterDropdown, 20, "Wait for Agency Dropdown");
        commonFunctions.isElementDisplayedAndPresent(agencyAndSectionFilterDropdownBlock, 20, "Verify agency section block displayed");
       commonFunctions.sendKeys(agencyFilterInputBox,agency,10,"agency filter input box");
        commonFunctions.clickElementIfDisplayed(String.format(agencyDropdownValue, agency), 20);
        commonFunctions.clickElement(agencyFilterDropdown, 20, "Wait for Agency Dropdown");
        commonFunctions.checkElementText(firstAgencyName,agency.toUpperCase(),20,"first Agency Name");
        for (int i = 0; i <= agencyFeedList.size() - 1; i++) {
            if (agencyColumnFeedList.get(i).getText().equalsIgnoreCase(agency)) {
                isAgencyValueMatched = true;
            } else {
                isAgencyValueMatched = false;
                System.out.println("Agency name not available verification fail!!!!!");
                break;
            }
        }
        commonFunctions.clickElement(agencyFilterDropdown, 20, "Wait for Agency Dropdown");
        commonFunctions.clickElementIfDisplayed(String.format(agencyDropdownValue, agency), 20);
        commonFunctions.clickElement(agencyFilterDropdown, 20, "Wait for Agency Dropdown");
        commonFunctions.clickElementIfDisplayed(sectionFilterDropdown, 20, "wait for Section Dropdown");
        commonFunctions.isElementDisplayedAndPresent(agencyAndSectionFilterDropdownBlock, 20, "Verify agency section block displayed");
        commonFunctions.clickElementIfDisplayed(String.format(sectionDropdownValue, section), 20);
        commonFunctions.clickElementIfDisplayed(sectionFilterDropdown, 20, "wait for Section Dropdown");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,30,"wait for list to be updated after filter");
        commonFunctions.checkElementText(firstSectionName,section.toUpperCase(),20,"first Section Name");
        for (int i = 0; i <= sectionColumnFeedList.size() - 1; i++) {
            if (sectionColumnFeedList.get(i).getText().equalsIgnoreCase(section)) {
                isSectionValueMatched = true;
            } else {
                isSectionValueMatched = false;
                System.out.println("Section name not available verification fail!!!!!");
                break;
            }
        }
        commonFunctions.clickElementIfDisplayed(sectionFilterDropdown, 20, "wait for Section Dropdown");
        commonFunctions.isElementDisplayedAndPresent(agencyAndSectionFilterDropdownBlock, 20, "Verify agency section block displayed");
        commonFunctions.clickElementIfDisplayed(String.format(sectionDropdownValue, section), 20);
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,30,"wait for list to be updated after filter");
        return isSectionValueMatched && isAgencyValueMatched;
    }

    @Override
    public boolean checkPublishedFilter(){
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,20,"wait for agency feed list to be displayed");
        String noOfRecordsText = commonFunctions.getElementText(noOfRecordInPagination, 30);
        String noOfRecords[] = noOfRecordsText.split("results of");
        int totalNoOfRecordsBeforeFilter = Integer.parseInt(noOfRecords[1].trim());
        String date=receivedAtList.get(0).getText();
        Date dateFromUI= commonFunctions.getMassagedDestinationDateTimeVideoNew(date);
        String dateFromUIString=dateFromUI.toString();
        String arr1[]=dateFromUIString.split(" ");
        String monthFromFilteredDate=arr1[1];
        String dayFromFilteredDate= arr1[2];
        Calendar cal = Calendar.getInstance();
        String CurrentMonth= new SimpleDateFormat("MMM").format(cal.getTime());
        LocalDate currentDate = LocalDate.now();
        int dom = currentDate.getDayOfMonth();
        int dayBefore= dom-1;
        String PreviousDate=String.valueOf(dayBefore);
        String CurrentDate=String.valueOf(dom);
         commonFunctions.clickElement(PublishedFilterDropdown,20,"click published");
        String currentMonth=twoMonthsListOnCalendar.get(0).getText();
        String nextMonth= twoMonthsListOnCalendar.get(1).getText();
        //TODO: extract 2 common lines of code from if else block and put it outside if else
        if(!currentMonth.contains(monthFromFilteredDate) && !nextMonth.contains(monthFromFilteredDate)){
            commonFunctions.clickElement(previousArrow,20,"Click on Previous arrow to get Month");
            commonFunctions.clickElementIfDisplayed(String.format(dateToBeSelected,monthFromFilteredDate,dayFromFilteredDate),20);
            commonFunctions.clickElementIfDisplayed(String.format(dateToBeSelected,CurrentMonth,CurrentDate),20);
        }
        else{
            commonFunctions.clickElementIfDisplayed(String.format(dateToBeSelected,monthFromFilteredDate,PreviousDate),20);
            commonFunctions.clickElementIfDisplayed(String.format(dateToBeSelected,CurrentMonth,CurrentDate),20);
        }
        commonFunctions.clickElementIfDisplayed(applyButtonOnCalendar,30,"Click on Apply button on Calendar");
        //String noOfRecordsTextAfterFilter = commonFunctions.getElementText(noOfRecordInPagination, 30);
        //String noOfRecords1[] = noOfRecordsTextAfterFilter.split("results of");
        //int totalNoOfRecordsAfterFilter = Integer.parseInt(noOfRecords1[1].trim());
        //commonFunctions.isElementDisplayedAndPresent(noOfRecordInPagination,20,"wait for Showing filtered results label");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,20,"wait for list to be displayed");
        boolean equalDates=receivedAtList.get(0).getText().contains(arr1[1]) && receivedAtList.get(0).getText().contains(arr1[2]);
        commonFunctions.clickElementIfDisplayed(PublishedFilterDropdown,20,"Open Published Dropdown");
        commonFunctions.clickElementIfDisplayed(clearButtonOnCalendar,20,"click clear button to clear filters");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,20,"wait for list to be displayed");
        return equalDates;
    }

    @Override
    public boolean isNotificationAndCreateStoryButtonDisplayedOnPrintFeedTab() {
        boolean isNotificationButtonDisplayed, isCreateStoryButtonDisplayed;
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(printFeedTab, 20, "Wait for Wires tab to be displayed");
        commonFunctions.clickElement(printFeedTab, 20, "Click on Wires tab under Images page");
        isNotificationButtonDisplayed = commonFunctions.isElementDisplayedAndPresent(sendNotificationButton, 30, "Send Notification button");
        isCreateStoryButtonDisplayed = commonFunctions.isElementDisplayedAndPresent(createAStoryButton, 30, "Create A Story button");
        return isNotificationButtonDisplayed && isCreateStoryButtonDisplayed;
    }

    @Override
    public boolean isOptionsDisplayedUnderCreateStory(String propertyName) {
        List<String> HT_NEW_Stories = Arrays.asList("Standard", "Photo Gallery", "Photo Story", "Live Blog", "Video", "Web Story", "Deadlink");
        List<String> LIVE_MINT_Stories = Arrays.asList("Standard", "Photo Gallery", "Photo Story", "Live Blog", "Listicle", "Video", "Highlights", "Mint Lite","Web Story");
        List<String> BANGLA_Stories = Arrays.asList("Standard", "Photo Gallery", "Media Gallery", "Live Blog", "Listicle", "Video","Web Story");
        List<String> AUTO_Stories = Arrays.asList("Standard", "Photo Gallery", "Live Blog", "Listicle", "Video","Web Story");
        List<String> TECH_Stories = Arrays.asList("Standard", "Photo Gallery", "Live Blog", "Video","Web Story");
        List<String> MINT_LOUNGE_Stories = Arrays.asList("Standard", "Photo Gallery", "Photo Story", "Live Blog", "Video","Web Story");
        List<String> SMART_24_Stories = Arrays.asList("Standard", "Photo Gallery", "Live Blog", "Listicle", "Video","Web Story");
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(agencyFeedsTab, 30, "Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIfDisplayed(agencyFeedsTab, 20, "Competition Feed tab");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList, 30, "Wait for Competition feed list displayed");
        commonFunctions.clickElementWithActions(createStoryButton, 20, "story type menu button");
        List<String> actualList = new ArrayList<>();
        listOfStoryType.forEach(product -> actualList.add(product.getText()));
        switch (propertyName) {
            case "HT NEW":
                return actualList.equals(HT_NEW_Stories);
            case "Live Mint":
                return actualList.equals(LIVE_MINT_Stories);
            case "Tech":
                return actualList.equals(TECH_Stories);
            case "Bangla":
                return actualList.equals(BANGLA_Stories);
            case "Auto":
                return actualList.equals(AUTO_Stories);
            case "Smart 24":
                return actualList.equals(SMART_24_Stories);
            case "Mint Lounge":
                return actualList.equals(MINT_LOUNGE_Stories);
            default:
                return false;
        }
    }

    @Override
    public boolean isEditFeedsOnAgencyFeedsTab() {
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(agencyFeedsTab, 30, "Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIfDisplayed(agencyFeedsTab, 20, "Competition Feed tab");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList, 30, "Wait for Competition feed list displayed");
        for(int i=0;i<=agencyFeedList.size()-1;i++){
            commonFunctions.clickElementIfDisplayed(pickUpList.get(i),20,"Click on "+(i+1)+" feed");
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            if(windowsList.size()>1){
                break;
            }
        }
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.isElementDisplayedAndPresent(buttonPublish,30,"Wait for Publish button to be displayed");
    }

    @Override
    public boolean islhgalleryoptionpresent(){
        selectFeedsLink();
        return commonFunctions.isElementDisplayed(LHgalleryfeed, 20, "LHgallery");

    }

    @Override
    public boolean isStoriesSearchableOnAgencyFeedsTab() {
        String searchableHeading = "";
        boolean isTextMatched = true;
        selectFeedsLink();
        commonFunctions.hardWait(5000);
        commonFunctions.isElementDisplayedAndPresent(agencyFeedsTab, 30, "Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIfDisplayed(agencyFeedsTab, 20, "Competition Feed tab");
        commonFunctions.isElementPresentWithTryCatch(agencyFeedList, 30);
        if(agencyFeedList.size()>0) {
            for (int i = 0; i <= agencyFeedList.size() - 1; i++) {
                if (!agencyFeedHeadingList.get(i).getText().isEmpty()) {
                    searchableHeading = agencyFeedHeadingList.get(i).getText();
                    break;
                }
            }
            commonFunctions.sendKeys(searchInputBox, searchableHeading.trim(), 10, "searchInputBox");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            commonFunctions.clickElement(searchInputBox, 20, "Click Search");
            commonFunctions.clickElement(searchFilter, 20, "Click Search Filter");
            commonFunctions.hardWait(5000);
            commonFunctions.isElementDisplayedAndPresent(showingResult, 20, "Wait for Showing results");
            for (int i = 0; i <= agencyFeedHeadingList.size() - 1; i++) {
                isTextMatched &= agencyFeedHeadingList.get(i).getText().toLowerCase().trim().contains(searchableHeading.trim().toLowerCase());
            }
        }
        return isTextMatched;
    }

    @Override
    public boolean validatePrintFeedStoryPopup(){
        boolean isFeedPopupDisplayed=true;
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(printFeedsTab,30,"Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIfDisplayed(printFeedsTab,20,"Print Feed tab");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,30,"Wait for Competition feed list displayed");
        commonFunctions.clickElement(agencyFeedList.get(0),20,"Print Feed First Row");
        isFeedPopupDisplayed &=commonFunctions.isElementDisplayedAndPresent(agencyFeedsPopup,30,"Competition Feed popup displayed");
        isFeedPopupDisplayed &=commonFunctions.isElementDisplayedAndPresent(pickAsAStoryPublishButton,20,"Pick as a story button");
        isFeedPopupDisplayed &=commonFunctions.isElementDisplayedAndPresent(copiedForPublishButton,20,"Copied for Publish button");
        commonFunctions.clickElement(closeButtonAgencyFeedPopup,20,"Close button of Competition feed popup");
        return isFeedPopupDisplayed;
    }


    @Override
    public boolean isStoryEditableOnClickOfPickStoryButtonOnPrintFeedStoryPopup(String heading){
        boolean isStoryEditable;
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(printFeedsTab,30,"Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIfDisplayed(printFeedsTab,20,"Print Feed tab");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList,30,"Wait for Competition feed list displayed");
        commonFunctions.clickElement(agencyFeedList.get(0),20,"Print Feed First Row");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedsPopup,30,"Competition Feed popup displayed");
        commonFunctions.clickElementIfDisplayed(pickAsAStoryPublishButton,20,"Pick as a story button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.isElementDisplayedAndPresent(buttonPublish,20,"wait for Publish button to be displayed");
        storyHeadingList.clear();
        commonFunctions.sendKeys(storyHeadingList,heading,20,"Edit Story headline");
        commonFunctions.hardWait(5000);
        commonFunctions.isElementDisplayedAndPresent(autoSavedChangesLabel,20,"Wait for Auto Saved label");
        commonFunctions.refreshPage();
        commonFunctions.isElementDisplayedAndPresent(autoSavedChangesLabel,20,"Wait for Auto Saved label");
        isStoryEditable=commonFunctions.getElementText(storyHeadingList).contains(heading);
        return isStoryEditable;
    }

    public boolean checkCopiedForPublishAndPickAsStoryEnableButton() {
        boolean isEnable;
        selectFeedsLink();
        commonFunctions.clickElementWithJS(firstStoryAgencyFeed, 50, "First Story list on Agency Feed");
        isEnable = commonFunctions.isElementEnabledWithoutTryCatch(copyForPublishButton, 50, "button Copied for Publish");
        isEnable = isEnable && commonFunctions.isElementEnabledWithoutTryCatch(pickAsAStoryButton, 50, "button Pick As A Story");
        return isEnable;
    }

    @Override
    public boolean afterPickAsStoryRedirectOnStoryPage() {
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(agencyFeedsTab, 30, "Wait for Agency Feed tab displayed");
        commonFunctions.clickElementIfDisplayed(agencyFeedsTab, 20, "Competition Feed tab");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList, 30, "Wait for Competition feed list displayed");
        for(int i=0;i<=agencyFeedList.size()-1;i++) {
            commonFunctions.clickElementIfDisplayed(allStoriesAgencyFeed.get(i), 20, "Click on " + (i + 1) + " feed");
            commonFunctions.clickElementWithJS(pickAsAStoryButton, 10, "button pick as story");
            commonFunctions.clickElementIfDisplayed(crossIcon, 10, "cross icon");
            commonFunctions.isElementDisplayedAndPresent(allStoriesAgencyFeed,20,"all stories present");
            ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
            if (windowsList.size() > 1) {
                break;
            }
        }
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        return commonFunctions.isElementDisplayedAndPresent(buttonPublish,30,"Publish button");
    }

    @Override
    public boolean sectionFilter(String section) {
        boolean isSectionValueMatched = false;
        boolean isDisplayed;
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(printFeedTab, 50, "Print Feed");
        commonFunctions.clickElement(printFeedTab, 50, "Print Feeds");
        commonFunctions.clickElement(sectionFilter, 50, "Filter: Section");
        commonFunctions.sendKeys(filterSectionInputBox, section, 50, "Section filter input box");
        commonFunctions.clickElementIfDisplayed(String.format(agencyDropdownValue, section), 20);
        commonFunctions.clickElement(sectionFilter, 50, "Filter: Section");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList, 30, "Print Feed List");
        for (int i = 0; i <= sectionColumnFeedList.size() - 1; i++) {
            if (sectionColumnFeedList.get(i).getText().equalsIgnoreCase(section)) {
                isSectionValueMatched = true;
                break;
            }
        }
        isDisplayed = clickOnPickAsStoryAndCheckPublishButton();
        return isSectionValueMatched && isDisplayed;
    }

    @Override
    public boolean statusFilter(String status) {
        boolean isStatusValueMatched = false;
        boolean isDisplayed;
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        selectFeedsLink();
        commonFunctions.isElementDisplayedAndPresent(printFeedTab, 50, "Print Feed");
        commonFunctions.clickElement(printFeedTab, 50, "Print Feeds");
        commonFunctions.isElementDisplayedAndPresent(statusFilter, 50, "status filter");
        commonFunctions.clickElementIfDisplayed(statusFilter, 50, "Filter: Status");
        commonFunctions.sendKeys(filterStatusInputBox, status, 50, "Status filter input box");
        commonFunctions.clickElementIfDisplayed(String.format(agencyDropdownValue, status), 20);
        commonFunctions.clickElement(statusFilter, 50, "Filter: Status");
        commonFunctions.isElementDisplayedAndPresent(agencyFeedList, 30, "Print Feed List");
        for (int i = 0; i <= statusColumnFeedList.size() - 1; i++) {
            if (statusColumnFeedList.get(i).getText().equalsIgnoreCase(status)) {
                isStatusValueMatched = true;
                break;
            }
        }
        isDisplayed = clickOnPickAsStoryAndCheckPublishButton();
        return isStatusValueMatched && isDisplayed;
    }

    private boolean clickOnPickAsStoryAndCheckPublishButton() {
        boolean isDisplayed;
        for (int i = 0; i <= agencyFeedList.size() - 1; i++) {
            commonFunctions.clickElementIfDisplayed(pickUpList.get(i), 20, "Click on " + (i + 1) + " feed");
            ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
            if (windowsList.size() > 1) {
                break;
            }
        }
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(buttonPublish, 30, "Publish button displayed");
        return isDisplayed;
    }

    @Override
    public boolean checkUserIsAbleToPreviewTheStoryFromLhGalleryFeedAndPickFromThere(){
        boolean flag=true;
        Set<String> windowsList = null;
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectFeedsLink();
        selectLhGalleryFeed();
        commonFunctions.dummyWait(10);
        if(lhGalleryFeedContent.size()>0){
            commonFunctions.clickElement(lhGalleryFeedContent.get(0), 20, "LH Gallery Contents");
            commonFunctions.clickElement(pickAsStoryButton, 20, "Pick As Story Button");
            if(commonFunctions.isElementDisplayed(yesButton, 20, "Yes Button")){
                commonFunctions.clickElement(yesButton, 20, "Yes Button");
            }
            
            flag = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2).size()>1;
        }
        windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        commonFunctions.switchToLastWindow(windowsList);
        boolean isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(buttonPublish, 30, "Publish button displayed");
        boolean storyTitleDisplayed = !commonFunctions.getElementText(storyTitle, 20).isEmpty();
        return flag && isDisplayed && storyTitleDisplayed;
    }

    @Override
    public boolean checkThatUserIsAbleToDoPickAsStoryFromTheStoriesPresentOnLhGalleryFeedAndCheckTheDataOnTheNewTabOpensOnBlankpaper(){
        boolean flag=true;
        Set<String> windowsList = null;
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectFeedsLink();
        selectLhGalleryFeed();
        commonFunctions.dummyWait(10);
        if(lhGalleryFeedContentPencilLink.size()>0){
            commonFunctions.clickElement(lhGalleryFeedContentPencilLink.get(0), 20, "LH Gallery Pencil");
            if(commonFunctions.isElementDisplayed(yesButton, 20, "Yes Button")){
                commonFunctions.clickElement(yesButton, 20, "Yes Button");
            }

            flag = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2).size()>1;
        }
        windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
        commonFunctions.switchToLastWindow(windowsList);
        boolean isDisplayed = commonFunctions.isElementDisplayedWithoutTryCatch(buttonPublish, 30, "Publish button displayed");
        boolean storyTitleDisplayed = !commonFunctions.getElementText(storyTitle, 20).isEmpty();
        return flag && isDisplayed && storyTitleDisplayed;
    }

    @Override
    public boolean checkThatUserIsAbleToCreateStoryFromLhGalleryFeedThenPublishTheSame(String byline)
    {
        boolean flag = false;
        Set<String> windowsList = null;
        commonFunctions.selectOptionFromDropDownWithVisibleText(tenantDrpDown, 20, "HT NEW", "tenant");
        selectFeedsLink();
        selectLhGalleryFeed();
        commonFunctions.dummyWait(10);
        if(lhGalleryFeedContentPencilLink.size()>0) {
            commonFunctions.clickElement(lhGalleryFeedContentPencilLink.get(0), 20, "LH Gallery Pencil");
            if (commonFunctions.isElementDisplayed(yesButton, 20, "Yes Button")) {
                commonFunctions.clickElement(yesButton, 20, "Yes Button");
            }
            windowsList = commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2);
            commonFunctions.switchToLastWindow(windowsList);
            String headText=commonFunctions.getElementText(enterHeadlineText, 20) + " Automation Test "+commonFunctions.generateRandomNum();
            commonFunctions.inputHeadline(headText,enterHeadlineText);
            commonFunctions.inputSummary(headText,addSummaryText);
            commonFunctions.clickElement(editImagePencilIcon, 20, "Edit Image Pencil Icon");
            commonFunctions.clickElement(setAsLeadlMediaToggle, 20, "Set As Lead Media Toggle");
            commonFunctions.clickElement(doneButton, 20, "Done Button");
            commonFunctions.clickElement(saveStoryDoneButton, 20, "Save Story Done Button");
            commonFunctions.dummyWait(15);
            commonFunctions.inputByLine(byline, inputAddByLineText);
            commonFunctions.isElementDisplayed(publishButton, 10, "Publich Button");
            commonFunctions.clickElement(publishButton, 10, "Publich Button");
            if(commonFunctions.isElementDisplayed(yesButton, 10, "Yes Button")){
                commonFunctions.clickElement(yesButton, 10, "Yes Button");
            }

            if(commonFunctions.isElementDisplayedAndPresent(popupPublishMessage, 10, "Publish Story")){
                flag = true;
            }

        }
        return flag;
    }

    @Override
    public boolean isUserAbleToPreviewTheStoryLhGalleryFeed() {
        selectFeedsLink();
        commonFunctions.clickElementIfDisplayed(LHgalleryfeed,20,"LhGallery");
        commonFunctions.isClickableElementClicked(Lhgallerydata,30,"LhGalleryData");
        return commonFunctions.isElementPresent(lhPreviewData,30);
    }

    public void selectLhGalleryFeed(){
        commonFunctions.isElementDisplayedAndPresent(lhGalleryFeed,20,"wait for LH Gallery Feed to be displayed");
        commonFunctions.clickElement(lhGalleryFeed, 25, "LH Gallery Feed button");
    }

    @Override
    public boolean checkIfUserIsAbleToSeeFeedsTabPresentInTheSidebar() {
        return commonFunctions.isElementPresentWithTryCatch(feedsLink,10);
    }

    @Override
    public boolean checkIfUserIsAbleToClickOnFeedsTabPresentInSidebar() {
        selectFeedsLink();
        return commonFunctions.isElementPresentWithTryCatch(feedTypes,10);
    }

    @Override
    public boolean checkIfUserIsAbleToSelectPrintFeedTab(String borderColor) {
        selectFeedsLink();
        String retrievedBorderColor="";
        if(commonFunctions.isClickableElementClicked(printFeedsTab,10,"print feed tab"))
            retrievedBorderColor=commonFunctions.getBackgroundColorOfWebElement(printFeedsTab,10,"Print Feed page","border");
        return retrievedBorderColor.substring(10,retrievedBorderColor.length()).equalsIgnoreCase(borderColor);
    }

    @Override
    public boolean checkIfUserIsAbleSeeFiveColumnsInTheTable(String headingOne, String headingTwo, String headingThree, String headingFour, String headingFive) {
        selectFeedsLink();
        List<WebElement> listOfHeadings=HeadingList;
        String temp="";
        boolean resultIs=true;
        List<String> headingList= Arrays.asList(headingOne,headingTwo,headingThree,headingFour,headingFive);
        for(WebElement ei: listOfHeadings){
            System.out.println(commonFunctions.getElementText(ei,10));
            temp=commonFunctions.getElementText(ei,10);
            if(!headingList.contains(temp)) return false;
        }
        return resultIs;
    }
}
