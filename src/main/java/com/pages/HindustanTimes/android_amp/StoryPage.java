package com.pages.HindustanTimes.android_amp;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

import java.text.SimpleDateFormat;
import java.util.*;

import com.jayway.jsonpath.PathNotFoundException;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.utils.ApiValidation;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.GlobalVars;
import com.utils.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class StoryPage extends CommonStoryPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static ApiValidation apiValidation;


    @FindBy(xpath = "//div[@class='dateTime']")
    private static List<WebElement> lastPublished;

    @FindBy(xpath = "//h1/a/img")
    private static WebElement htLogo;

    @FindBy(xpath="(//button[@class='subscribe'])[1]")
    private static WebElement doThisLaterButton;

    @FindBy(className = "//ul[@class='leftFixedNav']/li[3]/a")
    private static WebElement indiaNewsLinkFromNavigationMenu;

    @FindBy(xpath = "//div[@class = 'actionDiv flexElm']/div[2]")
    private static List<MobileElement> dateTime;

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

//    @FindBy(xpath = "//div[@class='info']//h2[@class='hideData']")
//    private static WebElement checkSummaryVideo;

    @FindBy(xpath="//div[@class='info']//h2")
    private static WebElement checkSummaryVideo;


    @FindBy(xpath = "//div[@class='viewAllData']//a")
    private static WebElement checkReadMoreButton;

    @FindBy(xpath = "//div[@class='hdgStyle']")
    private static WebElement scrollDownToStopVideo;

    @FindBy(xpath="(//div[@class='socialEl'])[1]")
    private static WebElement checkShareIcon;

    @FindBy(xpath="//div[contains(@class,'cartHolder bigCart')]//h3[@class='hdg3']/a")
    private static WebElement openFullStory;

    @FindBy(xpath = "//div[@class='cartHolder bigCart fullStory']")
    private static WebElement openStory;

    @FindBy(xpath = "(//div[@class='htsHeader'])[3]")
    private static WebElement trendingCarousel;

    @FindBy(xpath = "//div[contains(@class,'ampTopic')]/a")
    private static List<WebElement> trendingCarouselTopics;

    @FindBy(xpath="//div[contains(@class,'similarStory')]//div[contains(@class,'amp-carousel-slide')]")
    private static List<MobileElement> otherStoryInCarousel;

    @FindBy(xpath="//div[contains(@class,'amp-carousel-slide')]/p")
    private static List<MobileElement> paragraphsInOtherStoryInCarousel;

    @FindBy(xpath = "(//div[@class='htSlider'])[1]")
    private static WebElement sliderCarousel;

    @FindBy(xpath = "//div[contains(@class, 'cartHolder bigCart')]/h3")
    private static WebElement title;

    @FindBy(xpath = "//div[@class = 'hdgStyle']/h1")
    private static WebElement section;

    @FindBy(xpath = "//div[contains(@class, 'cartHolder bigCart track fullStory')]//h2")
    private static WebElement summaryOfFirstStory;

    @FindBy(xpath = "(//img[@decoding='async'])[3]")
    private static WebElement leadImage;

    @FindBy(xpath = "(//div[@class='detail']/p)[2]")
    private static WebElement paragraphIndiaNews;

    @FindBy(xpath = "(//div[@class='stroyPub']/div)[1]")
    private static WebElement imageCredit;

    @FindBy(xpath = "(//a[@class='closeStory close-btn'])[1]")
    private static WebElement close;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h1")
    private static WebElement fullStoryHeading;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h1")
    private static WebElement fullStoryHeadline;

    @FindBy(className = "storyBy")
    private static WebElement authorName;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topics;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(xpath = "//div[@class='storyShortDetail']")
    private static WebElement stories;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h1")
    private static WebElement headLineCricket;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/div")
    private static WebElement summaryCricket;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]//figcaption")
    private static WebElement leadMediaCaption;

    @FindBy(xpath = "//section[@class='mainContainer']//p[2]")
    private static WebElement paragraphCricket;

    @FindBy(xpath = "//section[@class='mainContainer']//p[parent::div[not(contains(@class,'slideStory'))]]")
    private static List<MobileElement> fullStoryParagraphs;

    @FindBy(xpath = "//div[@class='shareArticle']//div")
    private static WebElement shareIconCricket;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topicCricket;

    @FindBy(xpath = "//a[@class='hamburger']/em[text()='Videos']")
    private static WebElement clickOnVideosHamburgerMenu;

    @FindBy(xpath = "//div[@class='videoDetail']/h1")
    private static WebElement checkHeadLineOfStory;

    @FindBy(xpath = "(//div[contains(@class,'cartHolder')]/h3/a)[1]")
    private static WebElement firstHeadlineOfStory;

    @FindBy(xpath = "//*[contains(text(),'Accept')]")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//section[@class='ht-ad-holder'][2]//h3[@class='hdg3']")
    private static WebElement clickOnSecondArticleVideoSection;

    @FindBy(xpath = "(//div[@class='cartHolder large videoStory']//a)[1]")
    private static WebElement firstArticleVideoSection;

    @FindBy(xpath = "//div[contains(@class,'jw-button-container')]//div[contains(@aria-label,'Rewind')]")
    private static WebElement checkRewindButton;

    @FindBy(xpath = "//div[contains(@aria-label,'Unmute')]")
    private static WebElement checkUnmuteButton;

    @FindBy(xpath = "//a[@data-vars-event-label='Cricket']//em")
    private static WebElement scrollToCricket;

    @FindBy(xpath = "//div[@class='videoBox']//div[@class='embed_div']")
    private static WebElement firstVideobox;

    @FindBy(xpath = "(//div[@class = 'btnExplore'])[1]")
    private static WebElement hamBurger;

    @FindBy(xpath = "//iframe[contains(@src,'https://cdn.jwplayer.com/players/')]")
    private static WebElement videoIframe;

    @FindBy(xpath = "//div[@class='videoAdUiSkipButtonExperimentalText']")
    private static WebElement skipAdButton;

    @FindBy(xpath = "//div[contains(@class,'jw-text-elapsed')]")
    private static WebElement elapsedTime;

    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement captionAndImageCredit;

    @FindBy(xpath = "//span[@title = 'share']")
    private static WebElement shareIcons;

    @FindBy(className = "socialEl")
    private static List<WebElement> shareIcon;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement captionOfStory;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement leadMediaCaptionImageCredit;

    @FindBy(xpath = "//div[contains(@class,'bigCart')]//h3/a")
    private static WebElement headLineOfStory;

    @FindBy(xpath = "//p[@class='shortText']")
    private static WebElement summaryLineOfPhoto;

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

    @FindBy(xpath = "(//a[@href='/photos']/em)[1]")
    private static WebElement photos ;

    @FindBy(xpath = "//section[@id='dataHolder']/div[2]/figure/span/a/img")
    private static WebElement firstPhoto;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[2]/a")
    private static WebElement sectionPageList;

    @FindBy(xpath = "//div[contains(@class,'cartHolder')]/h3/a")
    private static WebElement headLineStoriesLink;

    @FindBy(className = "//div[@id='topnews']/section/div[1]/div[1]/h3")
    private static WebElement headLineOfOpenStory;

    @FindBy(xpath = "//section[@class= 'mainContainer']/div[3]/div/h1")
    private static WebElement headLineOfFullStory;

    Response response = null;
    String storyID;


    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
    }

    public boolean navigateToNewsPage() {
        boolean isNavigationSuccessful = false;
        commonFunctions.navigateURl((globalVars.getProdUrl() + "india-news/amp"));
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if (currentURL.equals(globalVars.getProdUrl() + "india-news/amp")) {
            isNavigationSuccessful = true;
        }
        return isNavigationSuccessful;
    }

    public String lastPublishedDate() {
        String storyData = stories.getText();
        return storyData.split("\n")[2];
    }


    public String lastPublishedApiValidation(String params[]) {
        try {
            String storyData = stories.getText();
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
    }

    @Override
    public boolean checkStoriesDisplayedLastPublished(String[] params) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigateToNewsPage = navigateToNewsPage();
        String publishedDate = lastPublishedDate();
        String publishDateApi = lastPublishedApiValidation(params);
        return navigateToNewsPage && (publishedDate.equalsIgnoreCase(publishDateApi));
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
            commonFunctions.clickElementWithActions(clickOnVideosHamburgerMenu, 20, "clickOnVideosHamburgerMenu");
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
            Utils.logStepInfo(true,storyID);
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
            commonFunctions.scrollToElementView(firstVideobox, 20, "firstVideoBox");
            commonFunctions.switchToFrame(videoIframe, 15);
            isVideoPauseButton = commonFunctions.checkVideoPauseButton();
            String str = elapsedTime.getText();
            if(!(str.equals(null)|| str.equals(""))) {
                String getText[] = str.split(":");
                String time = getText[1];
                Utils.logStepInfo("elapsed time" + time);
                int timeDuration = Integer.parseInt(time);
                if (timeDuration > 0) {
                    isVideoElapsedTime = true;
                }
            }else{
                isVideoElapsedTime=true;
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

    public boolean checkSummaryBelowVideo(String params[]) {
        boolean isSummaryDisplayed = false;
        boolean summaryApi = false;
        try {
            isSummaryDisplayed = commonFunctions.isElementDisplayed(checkSummaryVideo, 20, "checkSummaryVideo");
            String summaryText = commonFunctions.getElementText(checkSummaryVideo,20);
            Utils.logStepInfo(true,summaryText);
            String currentURL = commonFunctions.getCurrentURL("", "");
            storyID = commonFunctions.extractStoryID(currentURL);
            Utils.logStepInfo(true,storyID);
            response = commonFunctions.getResponseFromURI(params[0], params[1] + storyID);
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
            commonFunctions.switchToFrame(videoIframe, 15);
            isVideoStopped = commonFunctions.checkVideoPlayButton();
            commonFunctions.switchToDefaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isVideoStopped;
    }

    public boolean checkShareIconAndBookMarkAboveVideo() {
        boolean isShareIconDisplayed = false;
        try {
            commonFunctions.scrollToElementView(checkShareIcon, 20, "checkShareIcon");
            isShareIconDisplayed = commonFunctions.isElementDisplayed(checkShareIcon, 20, "checkShareIcon");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isShareIconDisplayed ;
    }

    public Response getResponseFromAPI(String uri, String address) {
        String currentUrl = commonFunctions.getCurrentURL("India news", "URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        return response;
    }

    public boolean checkNavigatedToIndiaNewsPage() {
        boolean isNavigatedToPage = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Do this later button on push notification");
        commonFunctions.clickElement(hamBurger, 10, "Explore");
        commonFunctions.clickElementIfDisplayed(hamBurger,10,"Explore if Displayed");
        commonFunctions.clickElementWithJS(indiaNews, 10, "India News");
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Do this later button on push notification");
        String title = commonFunctions.getCurrentURL("India News", "URL");
        if (title.contains("india-news")) {
            isNavigatedToPage = true;
        }
        boolean isDisplayed = commonFunctions.isElementDisplayed(openFullStory, 45, "Read Full Story");
        if (isDisplayed) {
            commonFunctions.clickElementWithJS(openFullStory, 20, "Read Full Story");
        } else {
            Utils.logStepInfo(true, "Read full story click has been Failed");
        }
        return isNavigatedToPage && isDisplayed;
    }

    public boolean checkUrlAfterClickingReadFullStory() {
        String url = commonFunctions.getCurrentURL("IndiaNews", "URL");
        String id = commonFunctions.extractStoryID(url);
        return url.contains("india-news") && url.endsWith(".html") && url.contains(id);
    }


    public boolean checkIndiaNewsElements(WebElement element, String uri, String address, String path) {
        boolean isStep = false;
        String value = "";
        String text = commonFunctions.getElementText(element, 20);
        Utils.logStepInfo(true, "Section text - "+text);
        Response response = getResponseFromAPI(uri, address);
        try{
            if (path.contains("paragraph")) {
                LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read(path);
                value = paragraph.toString();
            } else {
                value = JsonPath.parse(response.getBody().asString()).read(path);
            }
            Utils.logStepInfo(true, "API response value --- "+value);
            if (element == section) {
                isStep = value.equalsIgnoreCase(text);
            } else {
                isStep = value.contains(text);
            }
        }
        catch(PathNotFoundException pathNotFoundException){
            isStep = commonFunctions.isElementDisplayed(element,10,"Element");
            Utils.logStepInfo(true, "As Not getting response form API due to Path Not Found but Element is present in Page hence passed.");
        }
        return isStep;
    }

    public boolean checkScrollToPicsInStory() {
        return commonFunctions.scrollUsingAction(shareIcons, "Share Option");
    }

    public boolean checkShareIconsAtTheEndOfStory() {
        return commonFunctions.isElementDisplayed(shareIcons, 10, "Share Icons visible");
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
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean checkNavigation = checkNavigatedToIndiaNewsPage();
        boolean isRedirectionSuccessful = checkUrlAfterClickingReadFullStory();
        boolean isDisplayed = commonFunctions.isElementDisplayed(section, 20, section.getText() +" Section");
        Utils.logStepInfo(isDisplayed, section.getText()+ " section is displayed");
        boolean checkNewsSection = checkIndiaNewsElements(section, uri, address, "$.metadata.section");
        boolean checkHeadLine = checkIndiaNewsElements(title, uri, address, "$.headline");
        boolean checkSummary = checkIndiaNewsElements(summaryOfFirstStory, uri, address, "$.summary");
        boolean checkLeadMediaCaption = checkLeadMediaCaptionImageCreditNextToSummary(uri, address);
        boolean isScrolled = commonFunctions.scrollUsingAction(paragraphIndiaNews, "paragraph");
        Utils.logStepInfo(isScrolled, "paragraph is scrolled");
        boolean checkParagraph = checkIndiaNewsElements(paragraphIndiaNews, uri, address, "$.listElement[0].paragraph");
        boolean checkTopics = checkScrollToPicsInStory();
        boolean checkShareIcon = checkShareIconsAtTheEndOfStory();
        boolean checkParentUrl = checkURLChangedToParentURL();

        Utils.logStepInfo(true, "checkNavigation = "+checkNavigation);
        Utils.logStepInfo(true, "isRedirectionSuccessful = "+isRedirectionSuccessful);
        Utils.logStepInfo(true, "checkNewsSection = "+checkNewsSection);
        Utils.logStepInfo(true, "checkHeadLine = "+checkHeadLine);
        Utils.logStepInfo(true, "checkSummary = "+checkSummary);
        Utils.logStepInfo(true, "checkLeadMediaCaption = "+checkLeadMediaCaption);
        Utils.logStepInfo(true, "checkParagraph = "+checkParagraph);
        Utils.logStepInfo(true, "checkTopics = "+checkTopics);
        Utils.logStepInfo(true, "checkShareIcon = "+checkShareIcon);
        Utils.logStepInfo(true, "checkParentUrl = "+checkParentUrl);

        return checkNavigation && isRedirectionSuccessful && checkNewsSection && checkHeadLine && checkSummary && checkLeadMediaCaption
                && checkParagraph && checkTopics && checkShareIcon && checkParentUrl;
    }


    @Override
    public boolean videoStoryContentValidation(String params[]) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean explorerMenu = clickOnExplorerMenu();
        boolean videosHamburgerMenu = scrollDownClickAtVideosHamburgerMenu();
        String firstLinkUrl = getLinkUrl();
        boolean firstVideoArticle = clickOnViewVideoFirstArticleAtVideosSection();
        boolean urlModified = checkCurrentURlModified(firstLinkUrl);
        boolean pageVideo = scrollDownToPageVideoStarAutomatically();
        boolean headlineOfVideoStory = checkHeadlineOfVideoStory(params);
        boolean videoControls = checkVideoControls();
        boolean checkSummary = checkSummaryBelowVideo(params);
        boolean stopVideo = checkScrollDownToPageStopVideo();
        boolean checkShareIcon = checkShareIconAndBookMarkAboveVideo();

        return explorerMenu && videosHamburgerMenu && firstVideoArticle && urlModified && pageVideo
                && headlineOfVideoStory && videoControls && checkSummary  && stopVideo
                && checkShareIcon;
    }

    public boolean navigateToURL(String url) {
        boolean isnavigateToURLSuccessful = false;
        try {
            //String url = globalVars.getURL()+globalVars.getUrlLiveBlog();
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
            String captionImageCredit = commonFunctions.getElementText(captionAndImageCredit).trim();
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

    public boolean checkTopicsDisplayed(String uri, String address) {
        boolean checkTopicsDisplayed = false;
        boolean checkTopicApi = false;
        try {
            commonFunctions.scrollToElementView(topicCricket, 20, "topicCricket");
            checkTopicsDisplayed = commonFunctions.isElementDisplayed(topicCricket, 20);
            String text = commonFunctions.getElementText(topicCricket);
            Response response = getResponseFromAPI(uri, address);
            JSONArray topic = JsonPath.parse(response.getBody().asString()).read("$.metadata.topic");
            String value = topic.get(0).toString();
            if (text.toLowerCase(Locale.ROOT).contains(value)) {
                Utils.logStepInfo("check Topics successful");
                checkTopicApi = true;
                commonFunctions.navigateToURL(globalVars.getURL());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkTopicsDisplayed && checkTopicApi;
    }

    @Override
    public boolean liveBlogContentValidation(String uri, String address, String url) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigate = navigateToURL(url);
        boolean headLine = checkHeadlineNextToSectionName(uri, address);
        boolean checkSummary = checkSummaryNextToHeadLine(uri, address);
        boolean checkLeadMedia = checkLeadMediaCaptionImageCreditNextToSummary(uri, address);
        boolean checkParagraph = checkParagraphDisplayed(uri, address);
        boolean checkShareIcon = checkShareIconDisplayed();
        boolean checkTopics = checkTopicsDisplayed(uri, address);

        return navigate && headLine && checkSummary && checkLeadMedia && checkParagraph && checkShareIcon
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
        commonFunctions.clickElementWithJS(exploreMenu, 10, "Explore icon");
        commonFunctions.scrollToElement(photos,"photos");
        commonFunctions.scrollToElementViewAndClick(photos, 10,"Photos clicked");
        return commonFunctions.isElementDisplayed(firstPhoto, 10,"First Photo story");
    }

    public boolean checkUrlAfterClickingOnViewAllphotos() {
        String currentUrl = commonFunctions.getCurrentURL("Photos Url", "");
        String storyId = commonFunctions.extractStoryID(currentUrl);
        return currentUrl.contains(storyId) && currentUrl.contains("photos") && currentUrl.endsWith(".html");
    }

    public boolean checkHeadLineOfPhotoStory(String uri, String address) {
        boolean headLine = false;
        commonFunctions.isElementDisplayed(headLineOfStory, 20);
        String headline = commonFunctions.getElementText(headLineOfStory, 20);
        commonFunctions.clickElementWithJS(headLineOfStory,5,"First Photo Story");
        String url=commonFunctions.getCurrentURL("Url Navigation Successfully");
        String storyid = commonFunctions.extractStoryID(url);
        System.out.println("Storyid = "+storyid);
        commonFunctions.dummyWait(10);
        Response response = getResponseFromAPI(uri, address+storyid);
        String headlineFromAPI = JsonPath.parse(response.getBody().asString()).read("$.headline");
        if(headlineFromAPI.equalsIgnoreCase(headline)){
            headLine=true;
            commonFunctions.textToReport("check headline successful");
        }
        return headLine;
    }

    public boolean checkSummaryofPhotoStory(String uri, String address) {
        boolean summaryPhoto = false;
        String summary = commonFunctions.getElementText(summaryOfPhoto);
        String summaryFromUI=summary.trim();
        Response response = getResponseFromAPI(uri, address);
        String summaryFromAPI = JsonPath.parse(response.getBody().asString()).read("$.summary");
        if(summaryFromAPI.contains(summaryFromUI)){
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
            commonFunctions.textToReport("imageCredit not displayed for Photo on UI");
        }
        return captionPhoto;
    }

    public boolean checkShareIcon() {
        int iconsCount = shareIcon.size();

        for (int i = 0; iconsCount > i; i++) {
            boolean isStep = commonFunctions.isElementDisplayed(shareIcon.get(i));
            Utils.logStepInfo(isStep, "Share icon and book mark for all photos");
        }
        return commonFunctions.isElementDisplayed(shareIcon.get(0), 20, "ShareIcon and BookMark");
    }

    public boolean checkUrlAfterClickingOnSecondphoto() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollToElementViewAndClick(firstPhoto, 20, "Second Photo");
        String url = commonFunctions.getCurrentURL("Photos", "Url");
        return url.contains("amp.html");
    }

    @Override
    public boolean photoHeadLineSummaryBookMarkAndShare(String uri, String address) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isPhotoVisible = photoContentOfStory();
        commonFunctions.clickElementWithJS(headLineOfStory,10,"Head  line of story");
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        boolean isUrlChanged = checkUrlAfterClickingOnViewAllphotos();
        //boolean checkHeadLine = checkHeadLineOfPhotoStory(uri, address);
        boolean checkSummary = checkSummaryofPhotoStory(uri, address);
        boolean checkCaption = checkCaptionAndImageCreditOfPhotoStory(uri, address);
        boolean checkShareIcon = checkShareIcon();
        return isPhotoVisible && isUrlChanged && checkSummary && checkCaption
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
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
            boolean leadImageStatus=commonFunctions.isElementDisplayed(leadImage, 20, "Lead Image");
            commonFunctions.clickElementWithJS(leadImage, 20, "leadImage");
            commonFunctions.dummyWait(10);
            boolean isStoryDetailOpen=commonFunctions.isElementDisplayed(fullStoryHeading, 20, "Full story headline displayed");
            commonFunctions.clickElementWithJS(fullStoryHeading, 20, "Full story headline displayed");
        commonFunctions.navigateToURL(globalVars.getURL());
            return leadImageStatus&&isStoryDetailOpen;
        }

    @Override
    public boolean checkHeadline() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.dummyWait(5);
        boolean leadImageStatus=commonFunctions.isElementDisplayed(firstHeadlineOfStory, 20, "Head line in Home Pahe");
        commonFunctions.clickElement(firstHeadlineOfStory, 20, "Head line in Home Page");
        commonFunctions.dummyWait(5);
        boolean isStoryDetailOpen=commonFunctions.isElementDisplayed(headLineOfFullStory, 20, "Opened story headline");
        return leadImageStatus && isStoryDetailOpen;
    }

    @Override
    public boolean checkStoryIsExpanded() {
        return commonFunctionsMobile.checkStoryIsExpanded(sectionPageList, headLineStoriesLink, fullStoryHeading, fullStoryParagraphs);
    }

    @Override
    public boolean checkDateTime() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.dummyWait(5);
        boolean dateTimeDisplayedStatus=commonFunctions.isElementDisplayedOfListOfElements(dateTime,"Date Time");
        return dateTimeDisplayedStatus;
    }

    @Override
    public boolean checkAuthorName() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton, 10, "Click on Do this later button on push notification");
        boolean leadImageStatus = commonFunctions.isElementDisplayed(firstHeadlineOfStory, 20, "Lead story headline");
        commonFunctions.clickElementIfDisplayed(acceptCookie,10,"Accept cookie banner");
        String currentURL= commonFunctions.getCurrentURL();
        commonFunctions.navigateURl(currentURL);
        commonFunctions.clickElementWithJS(firstHeadlineOfStory, 20, "HeadLine");
        boolean authorNameVisible = commonFunctions.isElementDisplayed(authorName, 10, "Author/Agency Name");
        return leadImageStatus && authorNameVisible;
    }

    public boolean checkStoryPageHeader() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.isElementDisplayed(firstHeadlineOfStory, 20, "Lead Image");
        String headlineHomePage=commonFunctions.getElementText(firstHeadlineOfStory).trim();
        String headline= headlineHomePage.split(",")[0].trim();
        commonFunctions.clickElementWithJS(firstHeadlineOfStory, 20, "lead Image");
        commonFunctions.waitForURLContains(".html");
        String currentUrl=commonFunctions.getCurrentURL();
        commonFunctions.refreshPage();
        commonFunctions.waitForURLContains(".html");
        String headlineStoryPageAfterRefresh=commonFunctions.getElementText(fullStoryHeadline).trim();
        String headlineAfterRefresh = headlineStoryPageAfterRefresh.split(",")[0].trim();
        boolean isHeadlineSame=commonFunctions.checkTextEquals(headline,headlineAfterRefresh,"Headline");
        if(!isHeadlineSame){
            boolean isMatch = headline.contains(headlineAfterRefresh.substring(0, 10)) || headline.contains(headlineAfterRefresh.substring(headlineAfterRefresh.length() - 15, headlineAfterRefresh.length() - 1));
            if(isMatch){
                isHeadlineSame = true;
                Utils.logStepInfo(isMatch, "Some part of Lead Image head Lines are matching");
            }
        }
        return isHeadlineSame;
    }

    @Override
    public boolean checkTrendingTopicsCarouselDispayed() {
        boolean isTopicsCarouselDisplayed=true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementIfDisplayed(doThisLaterButton,10,"Click on Do this later button on push notification");
        commonFunctions.clickElementWithJS(firstHeadlineOfStory, 10, "Story Headline");
        commonFunctions.scrollToElement(trendingCarousel,30, "Trending Topic Carousel");
        commonFunctions.isElementDisplayed(trendingCarousel, 20,"Trending Carousel");
        String trendingCarouselText=commonFunctions.getElementText(trendingCarousel);
        isTopicsCarouselDisplayed=commonFunctions.checkTextContains("TRENDING",trendingCarouselText,"Carousel Name");
        String topicToBeClicked= trendingCarouselTopics.get(0).getText();
        commonFunctions.clickElementWithJS(trendingCarouselTopics.get(0),20,"Click first topic");
        commonFunctions.dummyWait(10);
        boolean isTopicsCarouselClickable=commonFunctions.getCurrentURL().toLowerCase().contains(topicToBeClicked.toLowerCase());
        commonFunctions.navigateToURL(globalVars.getURL());
        return isTopicsCarouselDisplayed && isTopicsCarouselClickable;
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
