package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class StoryPage extends CommonStoryPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    String storyID;
    Response response = null;

    @FindBy(xpath = "(//img[@class='lazy'])[3]")
    private static WebElement secondPhoto;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploremenu;

    @FindBy(xpath = "(//img[@class='lazy'])[1]")
    private static WebElement firstphoto;

    @FindBy(className = "socialEl")
    private static List<WebElement> shareIconBookMark;

    @FindBy(xpath = "//em[text()='Photos']")
    private static WebElement photos;

    @FindBy(xpath = "(//figure//span//a//img)[1]")
    private static WebElement viewAllPhotos;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement captionOfStory;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement leadMediaCaptionImageCredit;

    @FindBy(xpath="//div[@id='topnews']/section/div[1]/div[1]/h3/a")
    private static WebElement headLineOfStory;

    @FindBy(xpath = "(//h1[@class='hdg1']/a)[1]")
    private static WebElement photoHeadLineOfStory;

    @FindBy(xpath = "//div[@class='shortText']")
    private static WebElement summaryLineOfPhoto;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h1[@class='hdg1']")
    private static WebElement headLineCricket;

    @FindBy(xpath = "//section[@class='mainContainer']/div[3]/div[1]/div[1]")
    private static WebElement summaryCricket;

    @FindBy(xpath = "//section[@class='mainContainer']//p[2]")
    private static MobileElement paragraphCricket;

    @FindBy(xpath = "//section[@class='mainContainer']//p[2]")
    private static List<MobileElement> paragraphs;

    @FindBy(xpath = "//div[@class='shareArticle']//div")
    private static WebElement shareIconCricket;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topicCricket;

    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement captionAndImageCredit;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "(//h1[@class='hdg1'])[1]")
    private static WebElement title;

    @FindBy(xpath = "(//div[contains(@class,'catName')]/a)[1]")
    private static WebElement section;

    @FindBy(xpath = "(//div[@class='sortDec'])[1]")
    private static WebElement summaryOfFirstStory;

    @FindBy(xpath = "(//figure/span/a/img)[1]")
    private static WebElement leadImageMainPage;

    @FindBy(xpath = "(//div[@class='detail ']/p)[1]")
    private static WebElement paragraphIndiaNews;

    @FindBy(xpath = "(//a[contains(@class,'closeStory')])[1]")
    private static WebElement close;

    @FindBy(xpath = "(//div[@class='shareIcons'])[1]")
    private static List<WebElement> shareIcons;

    @FindBy(xpath = "//ul[@class = 'leftFixedNav']/li[3]/a")
    private static WebElement indiaNews;

    @FindBy(xpath = "//h3[@class='hdg3']//a")
    private static List<WebElement> stories;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement hamBurgerOption;

    @FindBy(xpath = "//div[@class='scrollMenu']//a[@href='/videos']")
    private static WebElement clickOnVideosHamburgerMenu;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploreButton;

    @FindBy(xpath = "//div[@class='scrollMenu']//a[@href='/podcasts']")
    private static WebElement scrollToPodCasts;

    @FindBy(xpath = "//iframe[contains(@src,'https://cdn.jwplayer.com/players/')]")
    private static WebElement videoIframe;

    @FindBy(xpath = "//div[@class='videoDetail']//span[@title='bookmark']")
    private static WebElement checkBookMark;

    @FindBy(xpath = "//div[contains(@class,'info')]//h2[@class='hideData']")
    private static WebElement checkSummaryVideo;

    @FindBy(xpath = "//button[@class='viewAllData']")
    private static WebElement checkReadMoreButton;

    @FindBy(xpath = "//div[@class='storyBy']")
    private static WebElement leadMediaCaption;

    @FindBy(xpath = "//div[@class='hdg2']")
    private static WebElement scrollDownToStopVideo;

    @FindBy(xpath = "//div[@class='videoDetail']//span[contains(@class,'share')]")
    private static WebElement checkShareIcon;

    @FindBy(xpath = "//div[@class='scrollMenu']")
    private static WebElement scrollToHamburgermenu;

    @FindBy(xpath = "(//div[contains(@class,'videoStory')][1]/figure/a)[1]")
    private static WebElement firstArticleVideoSection;

    @FindBy(xpath = "//div[@class='videoAdUiSkipButtonExperimentalText']")
    private static WebElement skipAdButton;

    @FindBy(xpath = "//div[@class='videoDetail']/h1")
    private static WebElement checkHeadLineOfStory;

    @FindBy(xpath = "//div[@class='videoBox']//div[@class='embed_div']")
    private static WebElement firstVideobox;

    @FindBy(xpath = "//div[contains(@class,'jw-text-elapsed')]")
    private static WebElement elapsedTime;

    @FindBy(xpath = "//div[@class ='logo']/h1/a/img")
    private static WebElement htLogo;

    @FindBy(xpath = "//div[@class = 'actionDiv flexElm']/div[2]")
    private static List<MobileElement> dateTime;

    @FindBy(xpath = "(//span[contains(@class,'share')])[1]")
    private static WebElement firstStoryShareAllOptions;

    @FindBy(xpath = "//section[@id='dataHolder']/div[2]/h3")
    private static WebElement fullStoryHeading;

    @FindBy(xpath = "//div[contains(@class,'storyDetails')]//p")
    private static List<MobileElement> fullStoryParagraphs;

    @FindBy(xpath = "(//div[@class='htSlider'])[1]")
    private static WebElement sliderCarousel;

    @FindBy(xpath="//div[@class='htSlider']//div[contains(@class,'webstories')]")
    private static List<MobileElement> otherStoryInCarousel;

    @FindBy(xpath="//div[@class='htSlider']//div[contains(@class,'gradient')]/h3")
    private static List<MobileElement> paragraphsInOtherStoryInCarousel;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h1")
    private static WebElement fullStoryHeadline;

    @FindBy(xpath = "//div[@class='storyBy' and contains(.,'Written by')] | //div[@class='storyBy']")
    private static WebElement authorName;

    @FindBy(xpath = "//div[contains(@class,'liveBlog')]")
    private static WebElement liveButton;

    @FindBy(xpath = "//div[@class='loggedout subscribe-sec subscribe']")
    private static WebElement capsuleBanner;

    @FindBy(xpath = "//input[@type='text']")
    private static WebElement enterEmail;

    @FindBy(xpath = "//button[@class='subscribeBtn']")
    private static WebElement buttonSubscribe;

    @FindBy(xpath = "//div[@class='subscribed-successfully']")
    private static WebElement subscribedMsg;

    @FindBy(xpath = "//a[@href='/latest-news']")
    private static WebElement sectionPageList;

    @FindBy(xpath = "//section[@id='dataHolder']/div[2]/h3/a")
    private static WebElement headLineStoriesLink;

    @FindBy (xpath = "//div[@id='topnews']/section/div[1]/div[1]/h3")
    private static WebElement headLineOfOpenStory;

    public StoryPage() {
    globalVars =GlobalVars.getInstance();
    driver =(IOSDriver)globalVars.getAppiumDriver();
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    commonFunctions =CommonFunctionsMobile.getInstance();
    commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
    commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************"+globalVars.getProjectName()+"******************");
}

       public boolean photoContentOfStory() {
        commonFunctions.clickElement(exploremenu, 20, "Explore icon");
        commonFunctions.scrollDownOnce();
        commonFunctions.scrollToElementViewAndClick(photos,10,"photos option");
        commonFunctions.scrollToElementViewAndClick(viewAllPhotos, 20, "View all photos");
        return commonFunctions.isElementDisplayed(firstphoto, 20);
    }

    public boolean checkUrlAfterClickingOnViewAllphotos() {
        String currentUrl = commonFunctions.getCurrentURL("Photos Url", "");
        return !currentUrl.equalsIgnoreCase(Utils.getUrl()+"photos");
    }

    public boolean checkHeadLineOfPhotoStory(String uri, String address) {
        boolean headLine = false;
        commonFunctions.isElementDisplayed(photoHeadLineOfStory, 20);
        String headline = commonFunctions.getElementText(photoHeadLineOfStory, 20);
        Response response = getResponseFromAPI(uri, address);
        String headlineFromAPI = JsonPath.parse(response.getBody().asString()).read("$.title");
        if(headlineFromAPI.equalsIgnoreCase(headline)){
            headLine=true;
            commonFunctions.textToReport("check headline successful");
        }
        return headLine;
    }

    public boolean checkSummaryofPhotoStory(String uri, String address) {
        boolean summaryPhoto = false;
        String summary = commonFunctions.getElementText(summaryLineOfPhoto);
        Response response = getResponseFromAPI(uri, address);
        String summaryFromAPI = JsonPath.parse(response.getBody().asString()).read("$.summary");
        if(summaryFromAPI.contains(summary)){
            summaryPhoto=true;
            commonFunctions.textToReport("check summary successful");
        }

        return summaryPhoto;
    }

    public boolean checkCaptionAndImageCreditOfPhotoStory(String uri, String address) {
        boolean captionPhoto = false;
        commonFunctions.isElementDisplayed(captionOfStory, 20);
        String captionImageCredit = commonFunctions.getElementText(leadMediaCaptionImageCredit, 20);
        Response response = getResponseFromAPI(uri, address);
        String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
        if(captionImageCredit.contains(captionFromAPI)){
            captionPhoto=true;
            commonFunctions.textToReport("check caption successful");
        }

        /*Observation has found that sometimes image credit for the photo has not been displayed so we are checking API response imageCredit
         * if image credit found then only it will check*/
        String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
        if(imageCreditFromAPI!=null && imageCreditFromAPI !="") {
            boolean imageCredit = false;
            if (captionImageCredit.contains(imageCreditFromAPI)) {
                imageCredit = true;
                commonFunctions.textToReport("check imageCredit successful");
            }
            return imageCredit;
        }else{
            commonFunctions.textToReport("image Credit not displayed for Photo on UI");
        }
        return captionPhoto;
    }
    public Response getResponseFromAPI(String uri, String address) {

        String currentUrl = commonFunctions.getCurrentURL("India News", "URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        return response;
    }


    public boolean checkShareIconAndBookMark() {
        int iconsCount = shareIconBookMark.size();

        for (int i = 0; i<10; i++) {
            boolean isStep = commonFunctions.isElementDisplayed(shareIconBookMark.get(i));
            Utils.logStepInfo(isStep, "Share icon and book mark for all photos");
        }
        return commonFunctions.isElementDisplayed(shareIconBookMark.get(0), 20, "ShareIcon and BookMark");
    }

    public boolean checkUrlAfterClickingOnthirdphoto() {
        commonFunctions.scrollUpToElementDisplayed(secondPhoto);
        String url = commonFunctions.getCurrentURL("Photos", "Url");
        return url.endsWith("2.html");
    }

    @Override
    public boolean photoHeadLineSummaryBookMarkAndShare(String uri, String address) {
        boolean isPhotoVisible = photoContentOfStory();
        boolean isUrlChanged = checkUrlAfterClickingOnViewAllphotos();
        boolean checkHeadLine = checkHeadLineOfPhotoStory(uri, address);
        boolean checkSummary = checkSummaryofPhotoStory(uri, address);
        boolean checkCaption = checkCaptionAndImageCreditOfPhotoStory(uri, address);
        boolean checkShareIcon = checkShareIconAndBookMark();
        boolean checkUrlSecondPhoto = checkUrlAfterClickingOnthirdphoto();

        return isPhotoVisible && isUrlChanged && checkHeadLine && checkSummary && checkCaption
                && checkShareIcon && checkUrlSecondPhoto;
    }

    @Override
    public boolean checkStoriesDisplayedLastPublished(String[] params) {
        boolean navigateToNewsPage = navigateToNewsPage();
        String publishedDate = lastPublishedDate();
        String publishDateApi = lastPublishedApiValidation(params);
        return navigateToNewsPage && (publishedDate.equalsIgnoreCase(publishDateApi));
    }


    public boolean checkSectionNameIndiaNews(String uri, String address) {
        boolean isSectionNameDispayed = false;
        String text = commonFunctions.getElementText(section, 20);
        String currentUrl = commonFunctions.getCurrentURL("India News", "URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        String value = JsonPath.parse(response.getBody().asString()).read("$.metadata.section");
        commonFunctions.textToReport(value);
        isSectionNameDispayed = value.equalsIgnoreCase(text);
        return isSectionNameDispayed;
    }

   /* public boolean checkHeadlineNextToSectionNameIndiaNews(String uri, String address) {
        boolean isHeadLineDisplayed = false;
        String mobileheadline = commonFunctions.getElementText(title, 20);
        String currentUrl = commonFunctions.getURL();
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        String value = JsonPath.parse(response.getBody().asString()).read("$.headline");
        isHeadLineDisplayed = value.contains(mobileheadline);
        return isHeadLineDisplayed;

    }

    public boolean checkSummaryIndiaNews(String uri, String address) {
        boolean isSummaryDisplayed = false;
        String summary = commonFunctions.getElementText(summaryOfFirstStory, 20);
        String currentUrl = commonFunctions.getURL();
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        String value = JsonPath.parse(response.getBody().asString()).read("$.summary");
        commonFunctions.textToReport(value);
        isSummaryDisplayed = value.contains(summary);
        return isSummaryDisplayed;
    }


    public boolean checkParagraphBelowLeadImage(String uri, String address) {
        boolean isStep = false;
        commonFunctions.scrollUsingAction(paragraphIndiaNews, "paragraph");
        String text = commonFunctions.getElementText(paragraphIndiaNews);
        String currentUrl = commonFunctions.getURL();
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read("$.listElement[0].paragraph");
        String value = paragraph.toString();
        Utils.logStepInfo(true, "" + value + "");
        isStep = value.contains(text);
        return isStep;
    }*/


   public boolean checkCloseButton() {
        boolean isCloseDisplayed = false;
        isCloseDisplayed = commonFunctions.isElementDisplayed(close, 10, "Close button");
        commonFunctions.clickElement(close, 20, "Close");
        return isCloseDisplayed;
    }
 /*
    public boolean checkURLchangedToParentURL() {
        boolean isURLchanged = false;
        String url = commonFunctions.getCurrentURL("India News", "Parent URL");
        if (url.equals(Utils.getUrl() + "india-news")) {
            isURLchanged = true;
        }
        return isURLchanged;
    }
*/

    @Override
    public boolean checkStandardStoriesAreDisplayed(String uri, String address) {
        boolean checkNavigation = checkNavigatedToIndiaNewsPage();
        boolean isRedirectionSuccessful = checkUrlAfterClickingReadFullStory();
        boolean isDisplayed = commonFunctions.isElementDisplayed(section, 20, "Section");
        Utils.logStepInfo(isDisplayed, "section is displayed");
        boolean checkNewsSection = checkIndiaNewsElements(section, uri, address, "$.metadata.section");
        boolean checkHeadLine = checkIndiaNewsElements(title, uri, address, "$.title");
        boolean checkSummary = checkIndiaNewsElements(summaryOfFirstStory, uri, address, "$.summary");
        boolean checkLeadMediaCaption = checkLeadMediaCaptionImageCreditNextToSummary(uri, address);
        boolean isScrolled = commonFunctions.scrollUsingAction(paragraphIndiaNews, "paragraph");
        Utils.logStepInfo(isScrolled, "paragraph is scrolled");
        boolean checkParagraph = checkIndiaNewsElements(paragraphIndiaNews, uri, address, "$.listElement[0].paragraph");
        boolean checkTopics = checkScrollToPicsInStory();
        boolean checkShareIcon = checkShareIconsAtTheEndOfStory();
        boolean checkParentUrl = checkURLChangedToParentURL();
        boolean checkCloseButton = checkCloseButton();

        return checkNavigation && isRedirectionSuccessful && checkNewsSection && checkHeadLine && checkSummary && checkLeadMediaCaption
                && checkParagraph && checkTopics && checkShareIcon && checkParentUrl && checkCloseButton;
    }


    public boolean checkNavigatedToIndiaNewsPage() {
        boolean isNavigatedToPage = false;
        commonFunctions.clickElementWithJS(exploremenu, 10, "Explore Menu");
        commonFunctions.clickElementWithJS(indiaNews, 10, "India News");
        String title = commonFunctions.getCurrentURL("India News", "URL");
        if (title.contains("india-news")) {
            isNavigatedToPage = true;
        }
        boolean isDisplayed = commonFunctions.isElementDisplayed(headLineOfStory, 45, "Read Full Story");
        if (isDisplayed) {
            commonFunctions.clickElementWithJS(headLineOfStory, 10, "Read Full Story");
        } else {
            Utils.logStepInfo("Read full story click has been Failed");
        }
        return isNavigatedToPage && isDisplayed;
    }

    public boolean checkUrlAfterClickingReadFullStory() {
        String url = commonFunctions.getCurrentURL("IndiaNews", "URL");
        String id = commonFunctions.extractStoryID(url);
        return url.contains("india-news") && url.endsWith(".html") && url.contains(id);
    }


    public boolean checkIndiaNewsElements(WebElement element, String uri, String address, String path) {
        boolean isStep;
        String value = "";
        String text = commonFunctions.getElementText(element, 20);
        Response response = getResponseFromAPI(uri, address);
        if (path.contains("paragraph")) {
            LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read(path);
            value = paragraph.toString();
        } else {
            value = JsonPath.parse(response.getBody().asString()).read(path);
        }
        Utils.logStepInfo(true, "" + value + "");
        if (element == section) {
            isStep = value.equalsIgnoreCase(text);
        } else {
            isStep = text.contains(value);
        }
        return isStep;
    }

    public boolean checkScrollToPicsInStory() {
        return commonFunctions.scrollUsingAction(shareIcons.get(0), "Topics");
    }

    public boolean checkShareIconsAtTheEndOfStory() {
        return commonFunctions.isElementDisplayed(shareIcons.get(0), 10, "ShareIcons visible");
    }

    public boolean checkURLChangedToParentURL() {
        boolean isURLChanged = false;
        String url = commonFunctions.getCurrentURL("India News", "Parent URL");
        if (url.contains("india-news")) {
            isURLChanged = true;
        }
        return isURLChanged;
    }


    public boolean clickOnExplorerMenu() {
        boolean isExplorerMenuClickSuccessful = false;
        try {
            isExplorerMenuClickSuccessful = commonFunctions.clickElementWithJS(exploreButton, 20, "exploreButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExplorerMenuClickSuccessful;
    }

    public boolean scrollDownClickAtVideosHamburgerMenu() {
        boolean isScrollDownToVideosSuccessful = false;
        try {
            commonFunctions.scrollToElementView(scrollToHamburgermenu, 20, "scrollToHamburgerMenu");
            commonFunctions.scrollToElementView(scrollToPodCasts, 20, "scrollToPodCasts");
            isScrollDownToVideosSuccessful = commonFunctions.scrollToElementViewAndClick(clickOnVideosHamburgerMenu, 20, "clickOnVideosHamburgerMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isScrollDownToVideosSuccessful;
    }

    public String getLinkUrl() {
        commonFunctions.scrollToElementView(firstArticleVideoSection, 20, "firstArticleVideoSection");
        String href = firstArticleVideoSection.getAttribute("href");
        return href;
    }

    public boolean clickOnViewVideoFirstArticleAtVideosSection() {
        boolean isClickOnFirstVideoArt = false;
        try {
            isClickOnFirstVideoArt = commonFunctions.scrollToElementViewAndClick(firstArticleVideoSection, 20, "firstArticleVideoSection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnFirstVideoArt;
    }

    public boolean checkCurrentURlModified(String firstLinkUrl) {
        boolean isCurrentURLModified = false;
        try {
            commonFunctions.scrollToElementView(exploreButton, 20, "exploreButton");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL Successful");
            if (!currentURL.isEmpty() && currentURL.contains(firstLinkUrl)) {
                isCurrentURLModified = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isCurrentURLModified;
    }

    public boolean scrollDownToPageVideoStarAutomatically() {
        boolean isVideoPlaying = false;
        try {
            commonFunctions.switchToFrame(videoIframe, 40);
            isVideoPlaying = commonFunctions.checkVideoPauseButton();
            commonFunctions.switchToDefaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isVideoPlaying;
    }

    public boolean checkHeadlineOfVideoStory(String params[]) {
        boolean isHeadLineOfStoryDisplayed = false;
        boolean headLineApi = false;
        try {
            commonFunctions.scrollToElementView(checkHeadLineOfStory, 20, "chechHeadLineOfVideoStory");
            isHeadLineOfStoryDisplayed = commonFunctions.isElementDisplayed(checkHeadLineOfStory, 20, "chechHeadLineOfVideoStory");
            String currentURL = commonFunctions.getCurrentURL("Videos page", "URL");
            storyID = commonFunctions.extractStoryID(currentURL);
            response = commonFunctions.getResponseFromURI(params[0], params[1] + storyID);
            String headLineValue = JsonPath.parse(response.getBody().asString()).read("$.title");
            String headLineText = commonFunctions.getElementText(checkHeadLineOfStory);
            if (headLineText.equalsIgnoreCase(headLineValue)) {
                Utils.logStepInfo("check headline successful");
                headLineApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isHeadLineOfStoryDisplayed && headLineApi;
    }

    public boolean checkVideoControls() {
        boolean isVideoPlayButton = false;
        boolean isVideoPauseButton = false;
        boolean isVideoMuteAndVolumeButtons = false;
        boolean isVideoElapsedTime = false;
        try {
            commonFunctions.scrollToElementView(checkBookMark, 20, "checkBookMark");
            commonFunctions.scrollToElementView(firstVideobox, 20, "firstVideobox");
            commonFunctions.switchToFrame(videoIframe, 35);
            isVideoPauseButton = commonFunctions.checkVideoPauseButton();
            String str = elapsedTime.getText();
            String getText[] = str.split(":");
            String time = getText[1];
            System.out.println("elapsed time" + time);
            int timeDuration = Integer.parseInt(time);
            if (timeDuration > 4) {
                isVideoElapsedTime = true;
            }
            isVideoPlayButton = commonFunctions.checkVideoPlayButton();
            isVideoMuteAndVolumeButtons = commonFunctions.checkVideoMuteAndVolumeButton();
            commonFunctions.checkVideoPlayButton();
            commonFunctions.switchToDefaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isVideoPauseButton && isVideoPlayButton && isVideoMuteAndVolumeButtons && isVideoElapsedTime;
    }

    public boolean checkSummaryBelowVideo() {
        boolean isSummaryDisplayed = false;
        boolean summaryApi = false;
        try {
            isSummaryDisplayed = commonFunctions.isElementDisplayed(checkSummaryVideo, 65, "checkSummaryVideo");
            String summaryText = commonFunctions.getElementText(checkSummaryVideo);
            String summaryValue = JsonPath.parse(response.getBody().asString()).read("$.summary");
            if (summaryValue.contains(summaryText)) {
                Utils.logStepInfo("check summary successful");
                summaryApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSummaryDisplayed && summaryApi;
    }

    public boolean checkReadMoreButtonBelowVideo() {
        boolean isReadMoreButtonDisplayed = false;
        try {
            if (commonFunctions.isElementDisplayed(checkReadMoreButton, 20, "checkReadMoreButton")) {
                isReadMoreButtonDisplayed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReadMoreButtonDisplayed;
    }

    public boolean checkScrollDownToPageStopVideo() {
        boolean isVideoStopped;
        commonFunctions.scrollToElementView(scrollDownToStopVideo, 20, "scrollDownToStopVideo");
        commonFunctions.switchToFrame(videoIframe, 25);
        isVideoStopped = commonFunctions.checkVideoPlayButton();
        commonFunctions.switchToDefaultContent();
        return isVideoStopped;
    }

    public boolean checkShareIconAndBookMarkAboveVideo() {
        boolean isShareIconDisplayed;
        boolean isBookMarkDisplayed;
        commonFunctions.scrollToElementView(checkShareIcon, 20, "checkShareIcon");
        isShareIconDisplayed = commonFunctions.isElementDisplayed(checkShareIcon, 20, "checkShareIcon");
        isBookMarkDisplayed = commonFunctions.isElementDisplayed(checkBookMark, 20, "checkBookMark");
        return isShareIconDisplayed && isBookMarkDisplayed;
    }


    @Override
    public boolean videoStoryContentValidation(String[] params) {
            boolean explorerMenu = clickOnExplorerMenu();
            boolean videosHamburgerMenu = scrollDownClickAtVideosHamburgerMenu();
            String firstLinkUrl = getLinkUrl();
            boolean firstVideoArticle = clickOnViewVideoFirstArticleAtVideosSection();
            boolean urlModified = checkCurrentURlModified(firstLinkUrl);
            boolean pageVideo = scrollDownToPageVideoStarAutomatically();
            boolean headlineOfVideoStory = checkHeadlineOfVideoStory(params);
            boolean videoControls = checkVideoControls();
            boolean checkSummary = checkSummaryBelowVideo();
            boolean readMoreButton = checkReadMoreButtonBelowVideo();
            boolean stopVideo = checkScrollDownToPageStopVideo();
            boolean checkShareIcon = checkShareIconAndBookMarkAboveVideo();

            return explorerMenu && videosHamburgerMenu && firstVideoArticle && urlModified && pageVideo
                    && headlineOfVideoStory && videoControls && checkSummary && readMoreButton && stopVideo
                    && checkShareIcon;

    }


    public boolean navigateToURL() {
        boolean isnavigateToURLSuccessful = false;
        try {
            String url = globalVars.getURL()+globalVars.getURL()+globalVars.getUrlLiveBlog();
            commonFunctions.navigateToURL(url);
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equals(url)) {
                isnavigateToURLSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isnavigateToURLSuccessful;
    }

    public boolean checkHeadlineNextToSectionName(String url, String endPoint) {
        boolean isHeadlinenextToSectionName = false;
        boolean headLineApi = false;
        try {
            commonFunctions.scrollToElementView(headLineCricket, 20, "headLineCricket");
            isHeadlinenextToSectionName = commonFunctions.isElementDisplayed(headLineCricket, 20, "headLineCricket");
            String currentURL = commonFunctions.getURL();
            storyID = commonFunctions.extractStoryID(currentURL);
            response = commonFunctions.getResponseFromURI(url, endPoint + storyID);
            String headLineValue = JsonPath.parse(response.getBody().asString()).read("$.headline");
            String text = commonFunctions.getElementText(headLineCricket);
            String getText[] = text.split(":");
            String headLineText = getText[0];
            if (headLineValue.contains(headLineText)) {
                Utils.logStepInfo("check headline successful");
                headLineApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isHeadlinenextToSectionName && headLineApi;
    }

    public boolean checkSummaryNextToHeadLine() {
        boolean isSummaryNextToHeadLine = false;
        boolean summaryApi = false;
        try {
            commonFunctions.scrollToElementView(summaryCricket, 20, "summaryCricket");
            isSummaryNextToHeadLine = commonFunctions.isElementDisplayed(summaryCricket, 20, "summaryCricket");
            String summaryText = commonFunctions.getElementText(summaryCricket);
            String summaryValue = JsonPath.parse(response.getBody().asString()).read("$.summary");
            if (summaryValue.contains(summaryText)) {
                commonFunctions.textToReport("check summary successful");
                summaryApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSummaryNextToHeadLine && summaryApi;
    }

    public boolean checkLeadMediaCaptionImageCreditNextToSummary(String uri,String address) {
        boolean isLeadMediaCaptionImageCreditDisp = false;
        boolean captionApi = false;
        try {
            commonFunctions.scrollToElementView(leadMediaCaption, 20, "leadMediaCaption");
            isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCaption, 20);
            String captionImageCredit = commonFunctions.getElementText(captionAndImageCredit);
            Response response = getResponseFromAPI(uri, address);
            String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
            if (captionImageCredit.contains(captionFromAPI)) {
                Utils.logStepInfo("check caption successful");
                captionApi = true;
            }
            /*Observation has found sometimes image credit for the story has not been displayed so we are checking API response
             * if image credit found then only it will check*/
            String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
            if (imageCreditFromAPI != null && imageCreditFromAPI != "") {
                boolean imageCredit = false;
                if (captionImageCredit.contains(imageCreditFromAPI)) {
                    imageCredit = true;
                    Utils.logStepInfo("check imageCredit successful");
                }
                return imageCredit;
            } else {
                Utils.logStepInfo("image Credit not displayed for Story on UI");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLeadMediaCaptionImageCreditDisp && captionApi;
    }

    public boolean checkParagraphDisplayed() {
        boolean isParagraphDisplayed = false;
        boolean paragraphApi = false;
        try {
            commonFunctions.scrollToElementView(paragraphCricket, 20, "paragraphCricket");
            isParagraphDisplayed = commonFunctions.isElementDisplayed(paragraphCricket, 20);
            String text = commonFunctions.getElementText(paragraphCricket);
            String value = JsonPath.parse(response.getBody().asString()).read("$.introBody");
            String getText[] = text.split(":");
            String paragraphText = getText[0];
            if (text.contains(paragraphText)) {
                Utils.logStepInfo("check paragraph successful");
                paragraphApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isParagraphDisplayed && paragraphApi;
    }

    public boolean checkShareIconDisplayed() {
        boolean checkShareIconDisplayed = false;
        try {
            commonFunctions.scrollToElementView(shareIconCricket, 20, "shareIconCricket");
            checkShareIconDisplayed = commonFunctions.isElementDisplayed(shareIconCricket, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkShareIconDisplayed;
    }

    public boolean checkTopicsDisplayed() {
        boolean checkTopicsDisplayed = false;
        boolean checkTopicApi = false;
        try {
            commonFunctions.scrollToElementView(topicCricket, 20, "topicCricket");
            checkTopicsDisplayed = commonFunctions.isElementDisplayed(topicCricket, 20);
            String text = commonFunctions.getElementText(topicCricket);
            JSONArray topic = JsonPath.parse(response.getBody().asString()).read("$.metadata.topic");
            String value = topic.get(0).toString();
            if (text.toLowerCase(Locale.ROOT).contains(value)) {
                Utils.logStepInfo("check Topics successful");
                checkTopicApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkTopicsDisplayed && checkTopicApi;
    }

    @Override
    public boolean liveBlogContentValidation(String uri, String address, String url) {
        boolean navigate = navigateToURL();
        boolean headLine = checkHeadlineNextToSectionName(globalVars.getURL()+uri, address);
        boolean checkSummary = checkSummaryNextToHeadLine();
        boolean checkLeadMedia = checkLeadMediaCaptionImageCreditNextToSummary(globalVars.getURL()+uri, address);
        boolean checkParagraph = checkParagraphDisplayed();
        boolean checkShareIcon = checkShareIconDisplayed();
        boolean checkTopics = checkTopicsDisplayed();
        return navigate && headLine && checkSummary && checkLeadMedia && checkParagraph && checkShareIcon
                && checkTopics;
    }

    public boolean navigateToNewsPage() {
        boolean isNavigationSuccessful = false;
        commonFunctions.getURL(globalVars.getURL() + "india-news");
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if (currentURL.equals(globalVars.getURL() + "india-news")) {
            isNavigationSuccessful = true;
        }
        return isNavigationSuccessful;
    }

    public String lastPublishedDate() {
        String storyData = stories.get(0).getText();
        //return storyData.split("\n")[2];
        return storyData;
    }

    public String lastPublishedApiValidation(String params[]) {
        try {
            String storyData = stories.get(0).getText();
            //String title = storyData.split("\n")[1];
            String title = storyData;
            String query = params[4];
            Response response = commonFunctions.getResponseFromURI(params[2], query);
            Filter myFilter = filter(where("title").is(title));
            JSONArray fields = JsonPath.parse(response.getBody().asString()).read("$.listElement[?].lastPublishedDate", myFilter);
            String dateFromAPI = fields.get(0).toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = sdf.parse(dateFromAPI);
            sdf = new SimpleDateFormat("MMM dd, YYYY hh:mm a");
            return "PUBLISHED ON " + sdf.format(date) + " IST";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean checkLastPublishedDate(String[] params) {
       return false;
    }

    @Override
    public boolean photosGalleryContentValidation() {
        return false;
    }

    @Override
    public boolean checkStandardStoryPagination(String uri, String address) {
        return false;
    }

    @Override
    public boolean checkContentImagesAndEmbeds(String[] params) {
        return false;
    }

    @Override
    public boolean checkSignInWallOnStoryPage() {
        return false;
    }

    @Override
    public boolean checkReadFullStoryClickable(String quickReadURL, String readSFullStoryText) {
        return false;
    }

    @Override
    public boolean checkReadFullStoryClickableinQuickReads() {
        return false;
    }

    @Override
    public boolean checkSignInWallOnStoryPage(String readtext, String premium, String saveArticles, String signIn, String signUp, String skip) {
        return false;
    }
    @Override
    public boolean checkLeadImage() {
        commonFunctions.navigateURl(globalVars.getURL());
        boolean leadImageStatus=commonFunctions.isElementDisplayed(leadImageMainPage, 20, "Lead Image");
        commonFunctions.clickElementWithJS(leadImageMainPage, 20, "lead Image");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.scrollToElementView(close,20,"close button");
        commonFunctions.dummyWait(10);
        boolean isStoryDetailOpen = commonFunctions.isElementDisplayed(close, 20, "Story Detail Page Close Button");
        commonFunctions.clickElementWithJS(close, 20, "Close Story Detail Page");
        return leadImageStatus && isStoryDetailOpen;
    }
    @Override
    public boolean checkHeadline() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForURLToBe(globalVars.getURL());
        boolean leadImageStatus = commonFunctions.isElementDisplayed(headLineOfStory, 20, "Lead Image");
        commonFunctions.clickElementWithJS(headLineOfStory, 20, "leadImage");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.dummyWait(5);
        boolean isStoryDetailOpen = commonFunctions.isElementDisplayed(headLineOfOpenStory, 20, "Head Line of Story Detail Page");
        return leadImageStatus && isStoryDetailOpen;
    }
    @Override
    public boolean checkStoryIsExpanded() {
        return commonFunctionsMobile.checkStoryIsExpanded(sectionPageList, headLineStoriesLink, fullStoryHeading, fullStoryParagraphs);
    }

    public boolean checkStoryIsExpanded_backup() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean leadImageStatus=commonFunctions.isElementDisplayed(headLineOfStory, 20, "Lead Image");
        commonFunctions.clickElement(headLineOfStory, 20, "HeadLine");
        commonFunctions.scrollUsingAction(firstStoryShareAllOptions,"First Story");
        boolean isFirstStoryDetailOpen=commonFunctions.isElementDisplayed(paragraphCricket,20,"First Story Expanded");
        int listSize= paragraphs.size();
        boolean isOtherStoryDetailOpen;
        if(listSize>1){
            isOtherStoryDetailOpen=false;
        }
        else
            isOtherStoryDetailOpen=true;
        commonFunctions.clickElement(close, 20, "Close Story Detail Page");
        return leadImageStatus&&isFirstStoryDetailOpen&&isOtherStoryDetailOpen;
    }
    @Override
    public boolean checkDateTime() {
        return commonFunctionsMobile.checkDateTimeMWeb(indiaNews, dateTime);
    }

    @Override
    public boolean checkAuthorName() {
        return commonFunctionsMobile.checkAuthorName(headLineOfStory, authorName);
    }

    @Override
    public boolean checkStoryPageHeader() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.isElementDisplayed(headLineOfStory, 20, "HeadLine");
        String headlineHomePage=commonFunctions.getElementText(headLineOfStory);
        commonFunctions.clickElementWithJS(headLineOfStory, 20, "Headline");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.navigateToURL(currentUrl);
        commonFunctions.waitForURLContains(".html");
        String headlineStoryPageAfterRefresh=commonFunctions.getElementText(fullStoryHeadline);
        boolean isHeadlineSame=commonFunctions.checkTextEquals(headlineHomePage,headlineStoryPageAfterRefresh,"Headline");
        //commonFunctions.clickElement(close, 20, "Close Story Detail Page");
        return isHeadlineSame;
    }

    @Override
    public boolean checkTrendingTopicsCarouselDispayed() {
        return false;
    }

    @Override
    public boolean checkFullStoryCloseButton() {
        return false;
    }

    @Override
    public boolean checkNewsletterBannerDisplayed() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForURLContains(globalVars.getProdUrl());
        commonFunctions.clickElementWithJS(headLineOfStory, 20, "HeadLine");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.navigateToURL(currentUrl);
        commonFunctions.waitForURLContains(".html");
        commonFunctions.scrollUntilElementFound(capsuleBanner);
        commonFunctions.clickElementWithJS(enterEmail, 20, "Email");
        commonFunctions.sendKey(enterEmail, "shakyfb@gmail.com");
        commonFunctions.clickElementWithJS(buttonSubscribe, 20, "Subscribe");
        boolean checkNewsletterBannerDisplayed = commonFunctions.isElementDisplayed(subscribedMsg, 10, "Newsletter Banner");
        return checkNewsletterBannerDisplayed;
    }

    @Override
    public boolean checkImagePremiumDisplayed() {
        return false;
    }

    @Override
    public boolean checkLeadImage3DotOption() {
        return false;
    }

    @Override
    public boolean checkAfterHeaderAdFirstStoryIsDisplayed() {
        return false;
    }

    @Override
    public boolean checkWhatsAppTwitterRelatedTopicPage() {
        return false;
    }

    @Override
    public boolean checkSectionNameisDispayed() {
        return false;
    }

    @Override
    public boolean checkSubSectionNameisDispayed() {
        return false;
    }

    @Override
    public boolean checkShareStory3DotOption() {
        return false;
    }

    @Override
    public boolean checkActionSheetCancelOption() {
        return false;
    }

    @Override
    public boolean checkIndiaPageThreeDotTapDisplayBottomAction() {
        return false;
    }

    @Override
    public boolean checkIndiaPageRedirectionFromExplore() {
        return false;
    }

    @Override
    public boolean checkCloseTabCloseBottomActionSheet() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTappingAnyStoryOnIndiaPage() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromStoryDetailsPageOnTappingAnyStoryOnIndiaPage() {
        return false;
    }

    @Override
    public boolean checkShareStoryFromIndia() {
        return false;
    }

    @Override
    public boolean checkAllStoriesArePremiumOnPremmiumPage() {
        return false;
    }

    @Override
    public boolean checkPremiumPageDisplay() {
        return false;
    }

    @Override
    public boolean checkPremiumPageHTPremiumDisplay() {
        return false;
    }

    @Override
    public boolean checkFirstStoryDisplayAfterTitle() {
        return false;
    }

    @Override
    public boolean checkFirstStoryImageDisplayWithPremiumTag() {
        return false;
    }

    @Override
    public boolean checkOtherStoryAreAlsoPremium() {
        return false;
    }

    @Override
    public boolean checkAllOtherStoryHavePremiumTagAtBottom() {
        return false;
    }

    @Override
    public boolean checkStoryHaveSubSectionBelowTitle() {
        return false;
    }

    @Override
    public boolean checkStoryDisplayOnItsSectionPage() {
        return false;
    }

    @Override
    public boolean checkNonLoggedUserOnPremiumPage() {
        return false;
    }

    @Override
    public boolean checkRelatedTopicHeadingDisplayed() {
        return false;
    }

    @Override
    public boolean checkRelatedTopicsDisplayed() {
        return false;
    }

    @Override
    public boolean checkRelatedTopicsRedirection() {
        return false;
    }

    @Override
    public boolean checkRelatedTopicsPageStoryRedirection() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTopicStoryIfTabOnbBackBtn() {
        return false;
    }

    @Override
    public boolean checkShareStoryFromTopicScreen() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnStoryIfTabOnSectionName() {
        return false;
    }

    @Override
    public boolean checkReadAloudOptionInStoryPage() {
        return false;
    }

    @Override
    public boolean checkRedirectionWhenUserTapsOnStoryInCitiesSection() { return false; }

    @Override
    public boolean checkSubscriptionPaywall(String HTPremiumPageUrl, String email, String password) {
        return false;
    }
}
