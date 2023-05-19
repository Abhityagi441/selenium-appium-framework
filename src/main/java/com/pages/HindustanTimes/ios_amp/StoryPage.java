package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
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
    private static ApiValidation apiValidation;


    @FindBy(xpath = "//div[@class='dateTime']")
    private static List<WebElement> lastPublished;

    @FindBy(xpath = "//a[@class='hamburger']//child::em[text()='Videos']")
    private static WebElement clickOnVideos;

    @FindBy(xpath = "//div[@class='nav-sec']")
    private static WebElement scrollToHamburgerMenu;

    @FindBy(xpath = "//div[@class='nav-sec']//a[@href='/podcasts']")
    private static WebElement scrollToPodCasts;

    @FindBy(xpath = "//section[@class='ht-ad-holder'][1]//h3[@class='hdg3']//a")
    private static WebElement clickOnFirstArticleVideoSection;

    @FindBy(xpath = "//div[@class='videoBox']//div[@class='embed_div']")
    private static WebElement firstVideoBox;


    @FindBy(xpath = "//div[contains(@class,'jw-controlbar')]//div[@aria-label='Play']")
    private static WebElement checkPlayButton;

    @FindBy(xpath = "//div[contains(@class,'jw-controlbar')]//div[@aria-label='Pause']")
    private static WebElement checkPauseButton;


    @FindBy(xpath = "//div[@class='info']//h2[@class='hideData']")
    private static WebElement checkHeadLineOfVideoStory;

    @FindBy(xpath = "//div[@class='videoDetail']//span[@title='bookmark']")
    private static WebElement checkBookMark;


    @FindBy(xpath = "//div[contains(@aria-label,'Unmute')]//div[@aria-label='Volume']")
    private static WebElement checkVolumeButton;

    @FindBy(xpath = "//div[@class='info']//h2[@class='hideData']")
    private static WebElement checkSummaryVideo;

    @FindBy(xpath = "//div[@class='viewAllData']//a")
    private static WebElement checkReadMoreButton;

    @FindBy(xpath = "//span[@class='hdgStyle']")
    private static WebElement scrollDownToStopVideo;

    @FindBy(xpath = "//div[@class='videoDetail']//span[contains(@class,'share')]")
    private static WebElement checkShareIcon;

    @FindBy(xpath = "(//a[contains(text(),'READ FULL STORY')])[1]")
    private static WebElement openFullStory;

    @FindBy(xpath = "//h1[@class='hdg1']")
    private static WebElement title;

    @FindBy(xpath = "(//div[@class='catName pt10']/a)[1]")
    private static WebElement section;

    @FindBy(xpath = "//div[@class='sortDec']")
    private static WebElement summaryOfFirstStory;

    @FindBy(xpath = "(//img[@decoding='async'])[3]")
    private static WebElement leadImage;

    @FindBy(xpath = "(//div[@class='detail']/p)[2]")
    private static WebElement paragraphIndiaNews;

    @FindBy(xpath = "(//div[@class='stroyPub']/div)[1]")
    private static WebElement imageCredit;

    @FindBy(xpath = "(//a[@class='closeStory close-btn'])[1]")
    private static WebElement close;


    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topics;

    @FindBy(xpath = "//a[@class='hamburger' and contains(.,'India News')]")
    private static WebElement indiaNews;


    @FindBy(xpath = "//div[@class='actionDiv']//div[@class='dateTime']")
    private static WebElement stories;

    @FindBy(xpath = "//div[contains(@class,'storyShortDetail')]/h1[@class='hdg1']")
    private static WebElement headLineCricket;

    @FindBy(xpath = "//div[@class='sortDec']")
    private static WebElement summaryCricket;

    @FindBy(xpath = "//div[@class='storyBy']")
    private static WebElement leadMediaCaption;

    @FindBy(xpath = "//section[@class='mainContainer']//p[2]")
    private static WebElement paragraphCricket;

    @FindBy(xpath = "//div[@class='shareArticle']//div")
    private static WebElement shareIconCricket;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topicCricket;

    @FindBy(xpath = "//a[@data-vars-event-label='Videos']//em")
    private static WebElement clickOnVideosHamburgerMenu;

    @FindBy(xpath = "//div[@class='videoDetail']/h1")
    private static WebElement checkHeadLineOfStory;

    @FindBy(xpath = "//section[@class='ht-ad-holder'][2]//h3[@class='hdg3']")
    private static WebElement clickOnSecondArticleVideoSection;

    @FindBy(xpath = "(//div[@class='flexElement']/a)[1]")
    private static WebElement firstArticleVideoSection;

    @FindBy(xpath = "//div[contains(@class,'jw-button-container')]//div[contains(@aria-label,'Rewind')]")
    private static WebElement checkRewindButton;

    @FindBy(xpath = "//div[contains(@aria-label,'Unmute')]")
    private static WebElement checkUnmuteButton;

    @FindBy(xpath = "//a[@data-vars-event-label='Cricket']//em")
    private static WebElement scrollToCricket;

    @FindBy(xpath = "//div[@class='videoBox']//div[@class='embed_div']")
    private static WebElement firstVideobox;

    @FindBy(xpath = "//div[@class='btnExplore']//span")
    private static WebElement hamBurger;

    @FindBy(xpath = "//div[@class='embed_div']//div//iframe[contains(@src,'https://cdn.jwplayer.com/players/')]")
    private static WebElement videoIframe;

    @FindBy(xpath = "//div[@class='videoAdUiSkipButtonExperimentalText']")
    private static WebElement skipAdButton;

    @FindBy(xpath = "//div[contains(@class,'jw-text-elapsed')]")
    private static WebElement elapsedTime;

    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement captionAndImageCredit;

    @FindBy(xpath = "(//div[@class='shareIcons'])[1]")
    private static List<WebElement> shareIcons;

    @FindBy(className = "socialEl")
    private static List<WebElement> shareIcon;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement captionOfStory;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement leadMediaCaptionImageCredit;

    @FindBy(xpath = "//h1[@class='hdg1']/a")
    private static WebElement headLineOfStory;

    @FindBy(xpath = "//p[@class='shortText']")
    private static WebElement summaryLineOfPhoto;

    @FindBy(xpath = "//div[@id='itemHolder']/p")
    private static WebElement summaryLineOfPhotoP;

    @FindBy(xpath = "//div[@class='shortText']")
    private static WebElement summaryOfPhoto;

    @FindBy(xpath = "//p[@class='shortText']//button")
    private static WebElement summaryReadMoreBtn;

    @FindBy(xpath = "//button[@class='showText']")
    private static WebElement summaryReadMoreButton;

    @FindBy(xpath = "(//div[@class='photoGallerySec']/h1)[2]")
    private static WebElement nextGallery;

    @FindBy(xpath = "(//img[@class='lazy'])[2]")
    private static WebElement secondPhoto;

    @FindBy(xpath = "//div[@class='container']//button")
    private static WebElement exploreMenu;

    @FindBy(xpath = "//em[text()='Photos']")
    private static WebElement photos;

    @FindBy(xpath = "//div[contains(@class,'photoStory')]/h3//a")
    private static WebElement viewFirstArticleImage;

    @FindBy(xpath = "//div[@id='itemHolder']/div[3]/figure")
    private static WebElement firstphoto;

    @FindBy(xpath = "(//a[contains(text(),'ALL PHOTOS')])[1]")
    private static WebElement viewAllPhotos;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//div[@class='socialEl']")
    private static WebElement shareAndBookMarkVisibility;

    Response response = null;
    String storyID;


    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        driver =(IOSDriver)globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean navigateToNewsPage() {
        boolean isNavigationSuccessful = false;
        commonFunctions.navigateURl((globalVars.getURL() + "india-news/amp"));
        String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
        if (currentURL.equals(globalVars.getURL() + "india-news/amp")) {
            isNavigationSuccessful = true;
        }
        return isNavigationSuccessful;
    }

    public String lastPublishedDate() {
        String storyData = stories.getText();
        return storyData.split("on ")[1];
    }


    /*public String lastPublishedApiValidation(String params[]) {
        try {
            String storyData = stories.get(0).getText();
            String title = storyData.split("\n")[1];
            String query = params[4];
            Response response = commonFunctions.getResponseFromURI(params[2], query);
            Filter myFilter = filter(where("title").is(title));
            JSONArray fields = JsonPath.parse(response.getBody().asString()).read("$.content[?].lastPublishedDate", myFilter);
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
    }*/

    @Override
    public boolean checkStoriesDisplayedLastPublished(String[] params) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigateToNewsPage = navigateToNewsPage();
        String publishedDate = lastPublishedDate();
        /*boolean isDisplayed = commonFunctions.isElementDisplayed(stories.get(0),20,"Story time");
        Utils.logStepInfo(isDisplayed,"lastpublished time is displayed  "+ lastPublishedDate());
        String publishDateApi = lastPublishedApiValidation(params);*/
        return navigateToNewsPage;

    }


    public boolean clickOnExplorerMenu() {
        boolean isExplorerMenuClickSuccessful = false;
        try {
            isExplorerMenuClickSuccessful = commonFunctions.clickElementWithJS(hamBurger, 20, "exploreButton");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExplorerMenuClickSuccessful;
    }

    public boolean scrollDownClickAtVideosHamburgerMenu() {
        boolean isElementClickedSuccessful = false;
        try {
            commonFunctions.scrollToElementView(scrollToCricket, 20, "scrollToHamburgerMenu");
            isElementClickedSuccessful = commonFunctions.isElementDisplayed(clickOnVideosHamburgerMenu, 10, "Videos menu");
            commonFunctions.scrollToElementViewAndClick(clickOnVideosHamburgerMenu, 20, "clickOnVideosHamburgerMenu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isElementClickedSuccessful;
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
            commonFunctions.scrollToElementView(hamBurger, 20, "exploreButton");
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
            commonFunctions.switchToFrame(videoIframe, 20);
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
            String currentURL = commonFunctions.getCurrentURL("", "");
            storyID = commonFunctions.extractStoryID(currentURL);
            response = commonFunctions.getResponseFromURI(params[0], params[1] + storyID);
            String headLineValue = JsonPath.parse(response.getBody().asString()).read("$.headline");
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
            commonFunctions.scrollToElementView(firstVideobox, 20, "firstVideoBox");
            Thread.sleep(25000);
            commonFunctions.switchToFrame(videoIframe, 15);
            isVideoPauseButton = commonFunctions.checkVideoPauseButton();
            String str = elapsedTime.getText();
            String getText[] = str.split(":");
            String time = getText[1];
            Utils.logStepInfo("elapsed time" + time);
            int timeDuration = Integer.parseInt(time);
            if (timeDuration > 1) {
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
            isSummaryDisplayed = commonFunctions.isElementDisplayed(checkSummaryVideo, 20, "checkSummaryVideo");
            String summaryText = commonFunctions.getElementText(checkSummaryVideo);
            String summaryValue = JsonPath.parse(response.getBody().asString()).read("$.summary");
            if (summaryValue.contains(summaryText)) {
                commonFunctions.textToReport("check summary successful");
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
        boolean isVideoStopped = false;
        try {
            commonFunctions.scrollToElementView(scrollDownToStopVideo, 20, "scrollDownToStopVideo");
            commonFunctions.switchToFrame(videoIframe, 20);
            isVideoStopped = commonFunctions.checkVideoPlayButton();
            commonFunctions.switchToDefaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isVideoStopped;
    }

    public boolean checkShareIconAndBookMarkAboveVideo() {
        boolean isShareIconDisplayed = false;
        boolean isBookMarkDisplayed = false;
        try {
            commonFunctions.scrollToElementView(checkShareIcon, 20, "checkShareIcon");
            isShareIconDisplayed = commonFunctions.isElementDisplayed(checkShareIcon, 20, "checkShareIcon");
            isBookMarkDisplayed = commonFunctions.isElementDisplayed(checkBookMark, 20, "checkBookMark");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isShareIconDisplayed && isBookMarkDisplayed;
    }

    public Response getResponseFromAPI(String uri, String address) {
        String currentUrl = commonFunctions.getCurrentURL("India news", "URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        return response;
    }

    public boolean checkNavigatedToIndiaNewsPage() {
        boolean isNavigatedToPage = false;
        commonFunctions.clickElementWithJS(hamBurger, 10, "Explore Menu");
        commonFunctions.clickElementWithJS(indiaNews, 10, "India News");
        String title = commonFunctions.getCurrentURL("India News", "URL");
        if (title.contains("india-news")) {
            isNavigatedToPage = true;
        }
        boolean isDisplayed = commonFunctions.isElementDisplayed(openFullStory, 45, "Read Full Story");
        if (isDisplayed) {
            commonFunctions.clickElementWithJS(openFullStory, 20, "Read Full Story");
        } else {
            Utils.logStepInfo("Read full story click has been Failed");
        }
        return isNavigatedToPage && isDisplayed;
    }

    public boolean checkUrlAfterClickingReadFullStory() {
        String url = commonFunctions.getCurrentURL("IndiaNews", "URL");
        String id = commonFunctions.extractStoryID(url);
        return url.contains("india-news") && url.endsWith("amp.html") && url.contains(id);
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
            isStep = value.contains(text);
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

    @Override
    public boolean checkStandardStoriesAreDisplayed(String uri, String address) {

        boolean checkNavigation = checkNavigatedToIndiaNewsPage();
        boolean isRedirectionSuccessful = checkUrlAfterClickingReadFullStory();
        boolean isDisplayed = commonFunctions.isElementDisplayed(section, 20, "Section");
        Utils.logStepInfo(isDisplayed, "section is displayed");
        boolean checkNewsSection = checkIndiaNewsElements(section, uri, address, "$.metadata.section");
        boolean checkHeadLine = checkIndiaNewsElements(title, uri, address, "$.headline");
        boolean checkSummary = checkIndiaNewsElements(summaryOfFirstStory, uri, address, "$.summary");
        boolean checkLeadMediaCaption = checkLeadMediaCaptionImageCreditNextToSummary(uri, address);
        boolean isScrolled = commonFunctions.scrollUsingAction(paragraphIndiaNews, "paragraph");
        Utils.logStepInfo(isScrolled, "paragraph is scrolled");
        boolean checkParagraph = checkIndiaNewsElements(paragraphIndiaNews, uri, address, "$.listElement[0].paragraph");
        boolean checkTopics = checkScrollToPicsInStory();
        boolean checkShareIcon = checkShareIconsAtTheEndOfStory();


        return checkNavigation && isRedirectionSuccessful && checkNewsSection && checkHeadLine && checkSummary && checkLeadMediaCaption
                && checkParagraph && checkTopics && checkShareIcon;
    }


    @Override
    public boolean videoStoryContentValidation(String params[]) {
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
            String url = globalVars.getURL()+globalVars.getUrlLiveBlog();
            commonFunctions.navigateToURL(url);
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.equalsIgnoreCase(url)) {
                isnavigateToURLSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isnavigateToURLSuccessful;
    }

    public boolean checkHeadlineNextToSectionName(String uri, String address) {
        boolean isHeadlinenextToSectionName = false;
        boolean headLineApi = false;
        try {
            commonFunctions.scrollToElementView(headLineCricket, 20, "headLineCricket");
            isHeadlinenextToSectionName = commonFunctions.isElementDisplayed(headLineCricket, 20, "headLineCricket");
            Response response = getResponseFromAPI(uri, address);
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

    public boolean checkSummaryNextToHeadLine(String uri, String address) {
        boolean isSummaryNextToHeadLine = false;
        boolean summaryApi = false;
        try {
            commonFunctions.scrollToElementView(summaryCricket, 20, "summaryCricket");
            isSummaryNextToHeadLine = commonFunctions.isElementDisplayed(summaryCricket, 20, "summaryCricket");
            String summaryText = commonFunctions.getElementText(summaryCricket);
            Response response = getResponseFromAPI(uri, address);
            String summaryValue = JsonPath.parse(response.getBody().asString()).read("$.summary");
            if (summaryValue.contains(summaryText)) {
                Utils.logStepInfo("check summary successful");
                summaryApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSummaryNextToHeadLine && summaryApi;
    }

    public boolean checkLeadMediaCaptionImageCreditNextToSummary(String uri, String address) {
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
                    if(captionImageCredit.isEmpty()){

                    }
                    Utils.logStepInfo("image Credit not displayed for Story on UI");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLeadMediaCaptionImageCreditDisp && captionApi;
    }

    public boolean checkParagraphDisplayed(String uri, String address) {
        boolean isParagraphDisplayed = false;
        boolean paragraphApi = false;
        try {
            commonFunctions.scrollToElementView(paragraphCricket, 20, "paragraphCricket");
            isParagraphDisplayed = commonFunctions.isElementDisplayed(paragraphCricket, 20);
            String text = commonFunctions.getElementText(paragraphCricket);
            Response response = getResponseFromAPI(uri, address);
            String value = JsonPath.parse(response.getBody().asString()).read("$.introBody");
            String getText[] = text.split(":");
            String paragraphText = getText[0];
            if (value.contains(paragraphText)) {
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

    public boolean checkTopicsDisplayed(String uri, String address,String url) {
        boolean checkTopicsDisplayed = false;
        boolean checkTopicApi = false;
        try {
            commonFunctions.scrollToElementView(topicCricket, 20, "topicCricket");
            checkTopicsDisplayed = commonFunctions.isElementDisplayed(topicCricket, 20);
            String text = commonFunctions.getElementText(topicCricket);
            Utils.logStepInfo(text);
            //Response response = getResponseFromAPI(uri, address);
            String storyid = commonFunctions.extractStoryID(url);
            Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
            JSONArray topic = JsonPath.parse(response.getBody().asString()).read("$.metadata.topic");
            commonFunctions.isElementDisplayed(topicCricket, 20);
            String value = topic.get(0).toString();
            Utils.logStepInfo(value);
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
        commonFunctions.navigateToURL(globalVars.getURL()+url);
        boolean headLine = checkHeadlineNextToSectionName(globalVars.getURL()+uri, address);
        boolean checkSummary = checkSummaryNextToHeadLine(globalVars.getURL()+uri, address);
        boolean checkLeadMedia = checkLeadMediaCaptionImageCreditNextToSummary(globalVars.getURL()+uri, address);
        boolean checkParagraph = checkParagraphDisplayed(globalVars.getURL()+uri, address);
        boolean checkShareIcon = checkShareIconDisplayed();
        boolean checkTopics = checkTopicsDisplayed(globalVars.getURL()+uri, address,globalVars.getURL()+url);

        return headLine && checkSummary && checkLeadMedia && checkParagraph && checkShareIcon
                && checkTopics;
    }



    @Override
    public boolean checkLastPublishedDate(String params[]) {
        return false;
    }

    @Override
    public boolean photosGalleryContentValidation() {
        return false;
    }

    public boolean photoContentOfStory() {
        boolean photoContent;
        commonFunctions.clickElementWithJS(exploreMenu, 5, "Explore icon");
        commonFunctions.scrollToElementViewAndClick(photos, 5, "Photos clicked");
        commonFunctions.clickElement(viewFirstArticleImage, 5, "Click on View all photos");
        photoContent = commonFunctions.isElementPresent(firstphoto, 10, "firstphoto");
        boolean photo1_story = commonFunctions.isElementDisplayed(firstphoto, 20);
        boolean share_BookMark = commonFunctions.isElementDisplayed(shareAndBookMarkVisibility, 20);
        commonFunctions.getElementText(headLineOfStory, 20);
        commonFunctions.getElementText(captionOfStory, 20);
        commonFunctions.getElementText(summaryLineOfPhoto, 20);

        if (photo1_story == share_BookMark) {
            photoContent = true;
        }

        return photoContent;
    }

    public boolean checkUrlAfterClickingOnViewAllphotos() {
        String currentUrl = commonFunctions.getCurrentURL("");
        String storyId = commonFunctions.extractStoryID(currentUrl);
        return currentUrl.contains(storyId) && currentUrl.contains("photos") && currentUrl.endsWith(".html");
    }

    public boolean checkHeadLineOfPhotoStory(Response response) {
        boolean headLine = false;
        commonFunctions.isElementDisplayed(headLineOfStory, 20);
        String headline = commonFunctions.getElementText(headLineOfStory, 20);
        String currentUrl = commonFunctions.getURL();

        String value = response.jsonPath().get("headline").toString();
        commonFunctions.textToReport(value);
        headLine = value.equalsIgnoreCase(headline);
        return headLine;
    }

    public boolean checkSummaryofPhotoStory(Response response) {
        boolean summaryPhoto = false;
        String summary ="";
        if(commonFunctions.isElementDisplayed(summaryLineOfPhoto)){
            summary = commonFunctions.getElementText(summaryLineOfPhoto, 20).trim();

        }
        else if (commonFunctions.isElementDisplayed(summaryLineOfPhotoP)){
            summary = commonFunctions.getElementText(summaryLineOfPhotoP, 20).trim();

        }

        String text = JsonPath.parse(response.getBody().asString()).read("$.summary");
        commonFunctions.textToReport(text);
        String t = text.replaceAll("&nbsp;","").replaceAll("amp;","").replaceAll("<[^>]*>", "");;
        summaryPhoto = t.contains(summary);
        return summaryPhoto;
    }

    public boolean checkCaptionAndImageCreditOfPhotoStory(Response response) {
        boolean captionPhoto = false;
        commonFunctions.isElementDisplayed(captionOfStory, 20);
        /* String caption = commonFunctions.getElementText(captionOfStory, 20);*/
        String captionImageCredit = commonFunctions.getElementText(leadMediaCaptionImageCredit, 20).trim();
        String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
        String caption = captionFromAPI.replaceAll("&nbsp;","").replaceAll("&amp","").trim();
        if (captionImageCredit.contains(caption)) {
            captionPhoto = true;
            commonFunctions.textToReport("check caption successful");
        }

        /*Observation has found that sometimes image credit for the photo has not been displayed so we are checking API response imageCredit
         * if image credit found then only it will check*/
        String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
        if (imageCreditFromAPI != null && imageCreditFromAPI != "") {
            boolean imageCredit = false;
            if (captionImageCredit.contains(imageCreditFromAPI)) {
                imageCredit = true;
                commonFunctions.textToReport("check imageCredit successful");
            }
            return imageCredit;
        } else {
            commonFunctions.textToReport("image Credit not displayed for Photo on UI");
        }
       /* String[] pc = value.split(" ");
        captionPhoto = value.startsWith(pc[0]);*/
        return captionPhoto;
    }


    public boolean checkShareIcon() {
        int iconsCount = shareIcon.size();

        for (int i = 0; iconsCount > i; i++) {
            boolean isStep = commonFunctions.isElementDisplayed(shareIcon.get(i));
            Utils.logStepInfo(isStep, i + " Photo Share icon and book mark");
        }
        return commonFunctions.isElementDisplayed(shareIcon.get(0), 20, "ShareIcon and BookMark");
    }

    @Override
    public boolean photoHeadLineSummaryBookMarkAndShare(String uri, String address) {
        apiValidation = new ApiValidation();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isPhotoVisible = photoContentOfStory();
        boolean isUrlChanged = checkUrlAfterClickingOnViewAllphotos();
        String currentUrl = commonFunctions.getCurrentURL("");
        String storyId = commonFunctions.extractStoryID(currentUrl);
        Response response = apiValidation.getResponseFromURI(uri, address + storyId);
        boolean checkHeadLine = checkHeadLineOfPhotoStory(response);
        boolean checkSummary = checkSummaryofPhotoStory(response);
        boolean checkCaption = checkCaptionAndImageCreditOfPhotoStory(response);
        boolean checkShareIcon = checkShareIcon();

        return isPhotoVisible && isUrlChanged && checkHeadLine && checkSummary && checkCaption
                && checkShareIcon;
    }

    @Override
    public boolean checkStandardStoryPagination(String uri, String address) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean checkContentImagesAndEmbeds(String[] params) {
        return true;
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
        return false;
    }

    @Override
    public boolean checkHeadline() {
        return false;
    }

    @Override
    public boolean checkStoryIsExpanded() {
        return false;
    }

    @Override
    public boolean checkDateTime() {
        return false;
    }

    @Override
    public boolean checkAuthorName() {
        return false;
    }
    public boolean checkStoryPageHeader() {
        return false;
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
        return false;
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
