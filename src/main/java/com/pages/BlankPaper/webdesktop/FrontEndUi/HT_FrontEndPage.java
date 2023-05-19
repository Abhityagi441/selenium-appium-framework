package com.pages.BlankPaper.webdesktop.FrontEndUi;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.BlankPaper.genericPages.CommonDashboardPage;
import com.pages.BlankPaper.genericPages.ForntEndUiPage.CommonFrontEndPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;

public class HT_FrontEndPage extends CommonFrontEndPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonDashboardPage dashboardPage;
//    public static String storyIdNumber;


    @FindBy(xpath = "//span[contains(@class,'link')]")
    private static WebElement copyTextUrl;

    @FindBy(css = "h1.hdg1")
    private static WebElement uiHeadline;

    @FindBy(xpath = "(//div[contains(@class,'actionDiv')]//div[contains(@class,'dateTime')])[1]")
    private static WebElement uiDateAndTime;

    @FindBy(xpath = "//div[contains(@class,'actionDiv')]//div[contains(@class,'dateTime')]")
    private static WebElement frontEndStandardStoryDateAndTime;

    @FindBy(css = "button#agree")
    private static WebElement agreeButton;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//div[contains(@class,'breadcrumbs')]/a[3]")
    private static WebElement uiSubSection;

    @FindBy(xpath = "//h2[@class='sortDec']")
    private static WebElement uiSummary;

    @FindBy(xpath = "//div[contains(@class,'detail')]/p")
    private static WebElement uiParagraph;

    @FindBy(xpath = "(//div[contains(@class,'detail')]/p)[2]")
    private static WebElement liveBloguiParagraph;

    @FindBy(xpath = "//div[contains(@class,'blogHeading')]/p")
    private static WebElement liveBlogPostTitle;

    @FindBy(xpath = "//div[contains(@class,'blogInfo')]/p")
    private static WebElement liveBlogPostBody;

    @FindBy(xpath = "//div[contains(text(),'Showing 1 result') and @class = 'recordList borderNone']")
    private static WebElement singleRecordConformation;

    @FindBy(xpath = "//div[@class='contentList']//div[1]//child::ul[1]//descendant::li")
    private static WebElement selectedStory;

    @FindBy(xpath = "//div[contains(@class,'block published')]//div//p[contains(text(),'PUBLISHED')]")
    private static WebElement PublishedText;

    @FindBy(xpath = "//div[contains(@class,'breadcrumbs')]/a[2]")
    private static WebElement VideoStorySectionOnFrontEnd;

    @FindBy(xpath = "//div[contains(@class,'breadcrumbs')]/a[3]")
    private static WebElement VideoStorySubSectionOnFrontEnd;

    @FindBy(xpath = "//h2[contains(@class,'hideData')]")
    private static WebElement VideoStorySummaryOnFrontEnd;

    @FindBy(xpath = "//div[contains(@class,'skip')]/a")
    private static WebElement popupSignInSkipButtonOnFrontEnd;

    @FindBy(xpath = "//div[contains(@class,'viewMoreButton')]//span")
    private static WebElement acceptButton;

    @FindBy(xpath = "(//div[contains(@id,'itemHolder')]//li)[1]")
    private static WebElement photoGalleryStorySummaryOnFrontEnd;

    @FindBy(xpath = "(//div[contains(@class,'tpsList')]/a)[2]")
    private static WebElement topicField;

    @FindBy(xpath = "(//div[contains(@class,'breadcrumbs')]//a)[2]")
    private static WebElement sectionField;

    @FindBy(xpath = "//div[contains(@class,'storyBy')]")
    private static WebElement bylineField;

    @FindBy(xpath = "//div[contains(@class,'storyBy')]//span[contains(text(),'Patna')]")
    private static WebElement locationField;

    @FindBy(xpath = "//section[contains(@class,'worldSection sections ad-holder')]/h2/span[2]")
    private static WebElement zone2collectionName;

    @FindBy(xpath = "//section[contains(@class,'worldSection sections ad-holder')]//div[contains(@class,'viewAll')]")
    private static WebElement collectionViewAll;

    //private static String zone3collectionStoriesHeadline = "//div[@class='secHdg' and contains(.,'%s')]//following-sibling::div//h3/a[contains(text(),'%s')]";
    private static String zone3collectionStoriesHeadline = "//div[@class='rgtWidget' and contains(.,'%s')]//following-sibling::div//h3/a[contains(text(),'%s')]";
    private static String zone3collectionName = "//aside[contains(@class,'rgtAdSection')]//div[contains(@class,'secHdg')]//span[@class='hdgStyle']//h2[contains(text(),'%s')]";
    private static String zone3CollectionStoriesHeadlineList="//div[@class='rgtWidget' and contains(.,'%s')]//following-sibling::div//h3/a[contains(text(),'')]";

    @FindBy(css = "div.btnExplore")
    private static WebElement exploreButton;

    private static String sectionNameText= "//div[@class='nav-sec']//em[contains(text(),'%s')]";

    @FindBy(xpath = "(//div[@class='nav-sec']//em)[2]")
    private static WebElement firstIndexSectionNameTextFrontend;

    @FindBy(xpath = "//div[@class='hdgStyle']/h1")
    private static WebElement sectionNameFrontEnd;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//div[contains(@class,'secName')]/a")
    private static WebElement pageSectionVideoStorySectionName;

    @FindBy(xpath = "//section[contains(@class,'mainContainer')]//h3[@class='hdg3']/a")
    private static WebElement pageSectionVideoStoryHeadlineName;

    @FindBy(xpath = "(//div[@class='breadcrumbs']/a)[2]")
    private static WebElement pageSubSectionSectionName;

    @FindBy(xpath = "//div[@class='errMsg']/span[contains(text(), '404')]")
    private static WebElement errorFourZeroFourMessage;

    @FindBy(css = "button#optInText")
    private static WebElement allowButton;

    @FindBy(css = "button#allow")
    private static WebElement allowsButton;

    @FindBy(xpath = "//div[@class='viewMoreButton']/a/span/img")
    private static WebElement acceptImage;

    @FindBy(xpath = "//button[@name='createCard' and contains(text(), 'Change Schedule')]")
    private static WebElement schPubBtn;

    @FindBy(xpath = "//span[contains(@class,'created')]")
    private static WebElement textAllChangesSaved;

    @FindBy(xpath = "(//div[contains(@class,'flexElement')]//div[contains(@class,'dateTime')])[1]")
    private static WebElement uiDateAndTimeForPhoto;

    @FindBy(id = "saveButton")
    private static WebElement saveButton;

    public HT_FrontEndPage() {

        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        dashboardPage = CommonDashboardPage.getInstance();
    }

    private void searchStoryByIDAndSelect(String id) {
        dashboardPage.searchStoryByID(id);
        commonFunctions.isElementDisplayed(singleRecordConformation, 60);
        commonFunctions.waitAndClickForElementIgnoringStaleElement(selectedStory, 60, "story list item");
    }

    @Override
    public boolean dataValidationOnFrontEndUI(String username, String password, String headline, String section, String subsection, String summary, String byline, String paragraph, String location, String topic, String storyIdNumber) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(acceptButton,20,"Accept Button");
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            isShowing &= standardStoryFrontEndVerification(headline, section, subsection, summary, byline, location, paragraph, topic);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    @Override
    public boolean dataValidationOnFrontEndUI(String username, String password, String headline, String subsection, String summary, String byline, String paragraph, String location, String storyIDNumber) {
        return false;
    }

    @Override
    public boolean waitForSchedulePublishToPublished(String storyIdNumber) {
        boolean isShowing = false;
        searchStoryByIDAndSelect(storyIdNumber);
        int attempts = 0;
        while (attempts < 10) {
            System.out.println("**** Iteration: " + attempts);
            if (!commonFunctions.isElementDisplayedAndPresent(PublishedText, 10, " Timeline published")) {
                commonFunctions.refreshPage();
                if (isShowing = commonFunctions.isElementDisplayedAndPresent(PublishedText, 10, " Timeline Published")) {
                    isShowing = true;
                    break;
                }
            }
            attempts++;
        }
        dashboardPage.clickOnBlankPaperLogo();
        commonFunctions.hardWait(5000);
        return isShowing;
    }

    @Override
    public boolean dataValidationVideoStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String summary, String storyIdNumber) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            commonFunctions.scrollToElementView(uiHeadline, 30, "headline view");
            isShowing &= commonFunctions.getElementTextAndCheck(uiHeadline, headline, 40, "headline");
            isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(VideoStorySectionOnFrontEnd, section, 50, "section");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySubSectionOnFrontEnd, subsection, 50, "subsection");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySummaryOnFrontEnd, summary, 50, "summary");
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationPhotoGalleryStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String summary, String storyIdNumber) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            commonFunctions.scrollToElementView(uiHeadline, 30, "headline element");
            isShowing &= commonFunctions.getElementTextAndCheck(uiHeadline, headline, 30, "headline");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySectionOnFrontEnd, section, 50, "section");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySubSectionOnFrontEnd, subsection, 50, "subsection");
            isShowing &= commonFunctions.getElementTextAndCheck(photoGalleryStorySummaryOnFrontEnd, summary, 50, "summary");
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    public boolean changeUrl(String urlHeadline, String storyIDNumber1) {
        return true;
    }

    @Override
    public boolean dataValidationOnSoftPublishPhotoGalleryStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String summary, String storyIdNumber, Date time) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            String dateFromUIOnHT = uiDateAndTimeForPhoto.getText();
            Date dateFromUI = commonFunctions.getPublishedDateTimeFromFrontEnd(dateFromUIOnHT);
            commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
            isShowing &= commonFunctions.getElementTextAndCheck(uiHeadline, headline, 10, "headline");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySectionOnFrontEnd, section, 50, "section");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySubSectionOnFrontEnd, subsection, 50, "subsection");
            isShowing &= commonFunctions.getElementTextAndCheck(photoGalleryStorySummaryOnFrontEnd, summary, 50, "summary");
            isShowing &= dateFromUI.equals(time);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    @Override
    public boolean dataValidationWithPublishTimeStandardStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String summary, String byline, String paragraph, String location, String topic, String storyIdNumber, Date time) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            commonFunctions.scrollToElement(frontEndStandardStoryDateAndTime, "date element view");
            String dateFromUIOnHT = frontEndStandardStoryDateAndTime.getText();
            Date dateFromUI = commonFunctions.getPublishedDateTimeFromFrontEnd(dateFromUIOnHT);
            isShowing &= standardStoryFrontEndVerification(headline, section, subsection, summary, byline, location, paragraph, topic);
            isShowing &= dateFromUI.equals(time);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    @Override
    public boolean dataValidationLiveBlogStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String postTitle, String postBody, String storyIdNumber) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            isShowing &= commonFunctions.getElementTextAndCheck(uiHeadline, headline, 10, "headline");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySectionOnFrontEnd, section, 50, "section");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySubSectionOnFrontEnd, subsection, 50, "subsection");
            isShowing &= commonFunctions.getElementTextAndCheck(liveBloguiParagraph, paragraph, 20, "paragraph");
            isShowing &= commonFunctions.getElementTextAndCheck(liveBlogPostTitle, postTitle, 20, "Post Title");
            isShowing &= commonFunctions.getElementTextAndCheck(liveBlogPostBody, postBody, 20, "Post Body");
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;

    }

    @Override
    public boolean dataValidationSoftPublishLiveBlogStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String paragraph, String postTitle, String postBody, String storyIdNumber, Date publishedTime) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
            commonFunctions.scrollToElementView(uiDateAndTime, 30, "date view");
            String dateFromUIOnHT = uiDateAndTime.getText();
            Date dateFromUI = commonFunctions.getPublishedDateTimeFromFrontEnd(dateFromUIOnHT);
            commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
            isShowing &= commonFunctions.getElementTextAndCheck(uiHeadline, headline, 10, "headline");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySectionOnFrontEnd, section, 50, "section");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySubSectionOnFrontEnd, subsection, 50, "subsection");
            isShowing &= commonFunctions.getElementTextAndCheck(liveBloguiParagraph, paragraph, 20, "paragraph");
            isShowing &= commonFunctions.getElementTextAndCheck(liveBlogPostTitle, postTitle, 20, "Post Title");
            isShowing &= commonFunctions.getElementTextAndCheck(liveBlogPostBody, postBody, 20, "Post Body");
            isShowing &= dateFromUI.equals(publishedTime);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;

    }

    public boolean dataValidationWithPublishTimeVideoStoryOnFrontEnd(String username, String password, String headline, String section, String subsection, String summary, String storyIdNumber, Date time) {
        boolean isShowing = true;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            String dateFromUIOnHT = frontEndStandardStoryDateAndTime.getText();
            Date dateFromUI = commonFunctions.getPublishedDateTimeFromFrontEnd(dateFromUIOnHT);
            commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
            commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
            isShowing &= commonFunctions.getElementTextAndCheck(uiHeadline, headline, 10, "headline");
            isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(VideoStorySectionOnFrontEnd, section, 50, "section");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySubSectionOnFrontEnd, subsection, 50, "subsection");
            isShowing &= commonFunctions.getElementTextAndCheck(VideoStorySummaryOnFrontEnd, summary, 50, "summary");
            isShowing &= dateFromUI.equals(time);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    @Override
    public boolean dataValidationFirstStoriesCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String section, String subsection, String summary, String byline, String location, String paragraph, String topic) {
        boolean isShowing = true;
        commonFunctions.newTabWithUrl(userAndPasswordURL);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.getURLWithoutCatch().equals(userAndPasswordURL);
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(String.format(zone3collectionName, collectionName), collectionName, 30, "collection Name on FrontEnd");
            isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3collectionStoriesHeadline, collectionName, headline), headline, 30, "headline Zone 3 ");
            commonFunctions.clickElementIfDisplayed(String.format(zone3collectionStoriesHeadline, collectionName, headline), 20, "First story headline");
            isShowing &= standardStoryFrontEndVerification(headline, section, subsection, summary, byline, location, paragraph, topic);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationSecondStoriesCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String section, String subsection, String summary1, String byline1, String location1, String paragraph1, String topic1, String headline1) {
        boolean isShowing = true;
        commonFunctions.newTabWithUrl(userAndPasswordURL);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.getURLWithoutCatch().equals(userAndPasswordURL);
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(String.format(zone3collectionName, collectionName), collectionName, 30, "collection Name on FrontEnd");
            isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3collectionStoriesHeadline, collectionName, headline), headline, 30, "First stories headline Zone 3 ");
            isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3collectionStoriesHeadline, collectionName, headline1), headline1, 30, "Second stories headline Zone 3 ");
            commonFunctions.clickElementIfDisplayed(String.format(zone3collectionStoriesHeadline, collectionName, headline1), 30, "second story headline");
            isShowing &= standardStoryFrontEndVerification(headline1, section, subsection, summary1, byline1, location1, paragraph1, topic1);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationSecondStoriesPositionUpAndDownCollectionOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String headline1) {
        boolean isShowing = true;
        commonFunctions.newTabWithUrl(userAndPasswordURL);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.getURLWithoutCatch().equals(userAndPasswordURL);
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(String.format(zone3collectionName, collectionName), collectionName, 30, "collection Name on FrontEnd");
            //isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3collectionStoriesHeadline, collectionName, headline), headline, 30, "First stories headline Zone 3 ");
            //isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3collectionStoriesHeadline, collectionName, headline1), headline1, 30, "Second stories headline Zone 3 ");
            isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3CollectionStoriesHeadlineList, collectionName), headline, 10, "FirstHeadline", 0);
            isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3CollectionStoriesHeadlineList, collectionName), headline1, 10, "Second Headline", 1);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.clickOnBlankPaperLogo();
        return isShowing;
    }

    public boolean standardStoryFrontEndVerification(String headline, String section, String subsection, String summary, String byline, String location, String paragraph, String topic) {
        boolean isShowing = true;
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElementView(uiHeadline, 30, "headline view");
        commonFunctions.checkElementText(uiHeadline, headline, 60, "headline");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(sectionField, section, 50, "section");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(uiSubSection, subsection, 50, "subsection");
        isShowing &= uiSummary.getText().contains(summary);
        //isShowing &= commonFunctions.getElementTextAndCheck(uiSummary, summary, 50, "summary");
        isShowing &= bylineField.getText().contains(byline);
        //isShowing &= commonFunctions.getElementTextAndCheck(bylineField, byline, 30, "byline");
        String[] text1 = commonFunctions.getElementText(locationField, 10).split(",");
        String locationText = text1[text1.length - 1];
        isShowing &= locationText.contains(location);
        //isShowing &= commonFunctions.checkElementTextWithEqualIgnoreCase(locationText, location, "location");
        isShowing &= commonFunctions.getElementTextAndCheck(uiParagraph, paragraph, 50, "paragraph");
        //commonFunctions.isElementDisplayed(topicField,60,"topic element");
        commonFunctions.scrollToElementView(topicField,60,"topic element view");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(topicField, topic, 20, "topic");
        return isShowing;
    }

    @Override
    public boolean deleteStoryFromCollectionAndCheckOnFrontEnd(String userAndPasswordURL, String collectionName, String headline, String headline1) {
        boolean isShowing = false;
        commonFunctions.newTabWithUrl(userAndPasswordURL);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.getURLWithoutCatch().equals(userAndPasswordURL);
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            isShowing &= commonFunctions.getElementTextAndCheck(String.format(zone3collectionStoriesHeadline, collectionName, headline), headline, 30, "First stories headline Zone 3 ");
            isShowing &= waitForStoryNotShowing(collectionName, headline1);
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    public boolean waitForStoryNotShowing(String collectionName,String headline1) {
        boolean isShowing = false;
        int attempts = 0;
        while (attempts < 10) {
            System.out.println("**** Iteration: " + attempts);
            if (isShowing=commonFunctions.elementIsNotPresent(String.format(zone3collectionStoriesHeadline, collectionName, headline1), 10, "headline")) {
                isShowing = true;
                break;
            }else {
                commonFunctions.refreshPage();
            }
            attempts++;
        }
        return isShowing;
    }

    public boolean checkHamburgerSectionNameOnFrontEnd(String userAndPasswordURL, String sectionName) {
        boolean isShowing = false;
        commonFunctions.newTabWithUrl(userAndPasswordURL);
        ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        if(commonFunctions.isElementPresentWithTryCatch(allowButton, 10)){
            commonFunctions.clickElement(allowButton, 5, "Allow button");
        }

        if(commonFunctions.isElementPresentWithTryCatch(allowsButton, 5)){
            commonFunctions.clickElement(allowsButton, 5, "Allow button");
        }

        if(commonFunctions.isElementPresentWithTryCatch(acceptImage, 10)){
            commonFunctions.clickElement(acceptImage, 5, "Accept button");
        }


        commonFunctions.clickElement(exploreButton, 30, "Explore button");
        int attempts = 0;
        while (attempts < 20) {
            System.out.println("**** Iteration: " + attempts);
            if (isShowing = commonFunctions.isElementDisplayed(String.format(sectionNameText, sectionName), 50, "section name")) {
                isShowing = true;
                break;
            } else {
                commonFunctions.refreshPage();
                System.out.println(" ::Section name is not displaying, hence refreshing the page");
                commonFunctions.waitAndClickForElementIgnoringStaleElement(exploreButton, 30, "Explore button");
            }
            attempts++;
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean checkHamburgerDeletedSectionNameOnFrontEnd(String userAndPasswordURL,String sectionName) {
        boolean isShowing = false;
        commonFunctions.newTabWithUrl(userAndPasswordURL);
        ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElement(exploreButton, 30, "Explore button");
        int attempts = 0;
        while (attempts < 20) {
            System.out.println("**** Iteration: " + attempts);
            if (isShowing = commonFunctions.elementIsNotPresent(String.format(sectionNameText, sectionName), 50, "section name")) {
                isShowing = true;
                break;
            } else {
                commonFunctions.refreshPage();
                System.out.println(" ::Section name is displaying, hence refreshing the page");
                commonFunctions.waitAndClickForElementIgnoringStaleElement(exploreButton, 30, "Explore button");
            }
            attempts++;
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        return isShowing;
    }

    @Override
    public boolean checkHamburgerUpAndDownPositionSectionNameOnFrontEnd(String userAndPasswordURL,String sectionName) {
        boolean isShowing = false;
        commonFunctions.newTabWithUrl(userAndPasswordURL);
        ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.clickElement(exploreButton, 30, "Explore button");
        int attempts = 0;
        while (attempts < 20) {
            System.out.println("**** Iteration: " + attempts);
            if (isShowing = commonFunctions.checkElementTextWithTryCatch(firstIndexSectionNameTextFrontend,sectionName,50,"First index section name")) {
                isShowing = true;
                break;
            } else {
                commonFunctions.refreshPage();
                System.out.println(" ::Section name is not displaying, hence refreshing the page");
                commonFunctions.waitAndClickForElementIgnoringStaleElement(exploreButton, 30, "Explore button");
            }
            attempts++;
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        return isShowing;
    }

    @Override
    public boolean checkSectionNameOnFrontEnd(String userAndPasswordURL,String pageSectionName,String sectionUrl,String subsection,String headlineText) {
        boolean isShowing = true;
        String url = userAndPasswordURL + sectionUrl;
        commonFunctions.newTabWithUrl(url);
        ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.refreshPage();
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(sectionNameFrontEnd, pageSectionName, 30, "section name");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(pageSectionVideoStorySectionName, subsection, 30, "story section name");
        isShowing &= commonFunctions.getElementTextAndCheck(pageSectionVideoStoryHeadlineName, headlineText, 30, "story headline name");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationHighlightsStoryOnFrontEnd(String username, String password, String headline, String summary, String paragraph, String byline, String highlightsItem, String section, String subsection,String location, String storyIdNumber) {
        return false;
    }

    @Override
    public boolean checkSubSectionNameOnFrontEnd(String userAndPasswordURL,String pageSectionName,String sectionUrl,String subsection,String headlineText,String section) {
        boolean isShowing = true;
        String url = userAndPasswordURL + sectionUrl;
        commonFunctions.newTabWithUrl(url);
        ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(pageSubSectionSectionName, section, 30, "section name");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(sectionNameFrontEnd, pageSectionName, 30, "Sub-section name");
        isShowing &= commonFunctions.getElementTextAndCheckWithEqualIgnoreCase(pageSectionVideoStorySectionName, subsection, 30, "story Subsection name");
        isShowing &= commonFunctions.getElementTextAndCheck(pageSectionVideoStoryHeadlineName, headlineText, 30, "story headline name");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean dataValidationOnFrontEndUI(String username, String password, String storyHeadlineText, String storyIdNumber) {
        boolean isShowing = false;
        dashboardPage.selectStoryCopyUrlOpenNewTab( username,  password, storyIdNumber);
        commonFunctions.clickElementIfDisplayed(popupSignInSkipButtonOnFrontEnd, 30, "sign in popup Skip button");
        commonFunctions.clickElementIfDisplayed(agreeButton, 10, "agree button");
        if(commonFunctions.isElementPresentWithTryCatch(errorFourZeroFourMessage, 10)){
            isShowing &= false;
            Utils.logStepInfo(false, "404(Page Not Found) Error Message is displaying");
        }else {
            isShowing = commonFunctions.checkElementText(uiHeadline, storyHeadlineText, 60, "headline");
        }
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        dashboardPage.navigateToHomePageDashboard();
        return isShowing;
    }

    @Override
    public boolean killHighlightsStoryDataValidationOnFrontEndUI(String username, String password, String storyHeadlineText, String storyIDNumber1) {
        return false;
    }

    @Override
    public boolean dataValidationStandardStoryParagraphWithInLineEmbedOnFrontEnd(String username, String password, String headline, String summary, String firstParagraphData, String secondParagraphData, String byline, String section, String subsection, String location, String storyIdNumber, String srcEmbed) {
        return false;
    }

    @Override
    public boolean dataValidationStandardStoryWithAllInLineEmbedOnFrontEnd(String username, String password, String headline, String summary, String paragraphData, String byline, String section, String subsection, String location, String storyIdNumber, String srcEmbed, String imageSrcValue, String captionName, String tableInputData, String companyName,String topic) {
        return false;
    }

    @Override
    public boolean dataValidationImageCaptionName(String username, String password, String storyIDNumber1, String firstCaptionName, String storyHeadlineText) {
        return false;
    }

    @Override
    public boolean waitForPublished(String storyIdNumber) {
        boolean isShowing = false;
        searchStoryByIDAndSelect(storyIdNumber);
        int attempts = 0;
        while (attempts < 50) {
            System.out.println("**** Iteration: " + attempts);
            if (commonFunctions.isElementPresentWithTryCatch(schPubBtn, 10)) {
                if(commonFunctions.isElementPresentWithTryCatch(saveButton, 10)) {
                    commonFunctions.checkElementsTextWithTryCatch(textAllChangesSaved, "ALL CHANGES ARE SAVED", 30, "Correct text is");
                }
                commonFunctions.refreshPage();
                commonFunctions.hardWait(10000);
            }else{
                isShowing = true;
                break;
            }
            attempts++;
        }
        dashboardPage.clickOnBlankPaperLogo();
        commonFunctions.hardWait(5000);
        return isShowing;
    }
}




