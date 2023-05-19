package com.pages.HindustanTimes.android_mweb;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import com.jayway.jsonpath.PathNotFoundException;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.utils.ApiValidation;
import com.utils.HTMLParser;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
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

import javax.rmi.CORBA.Util;

public class StoryPage extends CommonStoryPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static ApiValidation apiValidation;
    String storyID;
    Response response = null;

    @FindBy(className = "navIco")
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

    @FindBy(xpath = "//div[@class='info info_detail']//h2[@class='hideData']")
    private static WebElement checkSummaryVideo;

    @FindBy(xpath = "//div[@class='viewAllData']//a")
    private static WebElement checkReadMoreButton;

    @FindBy(xpath = "//span[@class='hdgStyle']")
    private static WebElement scrollDownToStopVideo;

    @FindBy(xpath = "//div[@class='videoDetail']//span[contains(@class,'share')]")
    private static WebElement checkShareIcon;

    @FindBy(xpath = "//div[@id='topnews']/section/div[1]/div[1]/h3/a")
    private static WebElement openFullStory;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h3")
    private static WebElement title;

    @FindBy(xpath = "//div[@class='secHdg']//h1")
    private static WebElement section;

    @FindBy(xpath = "(//h2[@class='sortDec'])[1]")
    private static WebElement summaryOfFirstStory;

    @FindBy(xpath = "//div[@id='topnews']/section/div[1]/div[1]/figure/span/a/img")
    private static WebElement leadImage;

    @FindBy(xpath = "//div[@class='detail']/p[1]")
    private static WebElement paragraphIndiaNews;

    @FindBy(xpath = "(//a[contains(@class,'closeStory')])[1]")
    private static WebElement close;

    @FindBy(xpath = "(//a[@class='closeStory close-btn'])[1]")
    private static MobileElement closeMobile;

    @FindBy(xpath = "//button[@id='closepopup']//span")
    private static WebElement closePopUP;

    @FindBy(xpath = "//div[@class='socialEl']/span")
    private static List<WebElement> shareIcons;

    @FindBy(className = "shareArticle")
    private static WebElement shareArticle;

    @FindBy(xpath = "(//section[@id='sidenav']//a)[4]")
    private static WebElement indiaNews;

    @FindBy(xpath = "//div[@class='scrollMenu']")
    private static WebElement scrollToHamburgermenu;

    @FindBy(xpath = "//div[contains(@class,'videoStory')]//a")
    private static WebElement firstArticleVideoSection;

    @FindBy(xpath = "//div[@class='videoDetail']/h1")
    private static WebElement checkHeadLineOfStory;

    @FindBy(xpath = "//div[@class='videoBox']//div[@class='embed_div']")
    private static WebElement firstVideobox;

    @FindBy(xpath = "//div[contains(@class,'jw-text-elapsed')]")
    private static WebElement elapsedTime;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h1")
    private static WebElement headLineCricket;

    @FindBy(xpath = "//div[@class='actionDiv']//div[@class='dateTime']")
    private static WebElement stories;

    @FindBy(xpath = "(//h2[@class='sortDec'])[1]")
    private static WebElement summaryCricket;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]//figcaption")
    private static WebElement leadMediaCricket;

    @FindBy(xpath = "(//div[contains(@class,'fullStory')]//p[2])[1]")
    private static WebElement paragraphCricket;

    @FindBy(xpath = "(//span[@title='share'])[1]")
    private static WebElement shareIconCricket;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topicCricket;

    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement captionAndImageCredit;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement captionOfStory;

    @FindBy(xpath = "(//h4[@class='hdg4'])[1]")
    private static WebElement leadMediaCaptionImageCredit;

    @FindBy(xpath = "//div[@id='itemHolder']/h1")
    private static WebElement headLineOfStory;

    @FindBy(xpath = "//div[contains(@class,'cartHolder')]/h3/a")
    private static WebElement headLineStoriesLink;

    @FindBy(xpath="(//div[contains(@class,'cartHolder bigCart')]//h3[@class='hdg3']/a)[1]")
    private static WebElement headLineStory;

    @FindBy(xpath = "(//div[@id='itemHolder']//ul/li)[1]")
    private static WebElement summaryLineOfPhoto;

    @FindBy(xpath = "//div[@id='itemHolder']/p")
    private static WebElement summaryLineOfPhotoP;

    @FindBy(xpath = "//*[@class='shortText']")
    private static WebElement summaryLineOfPhoto2;

    @FindBy(xpath = "//div[@class='shortText']//ul//li")
    private static WebElement summaryOfPhoto;

    @FindBy(xpath = "//button[@class='showText']")
    private static WebElement summaryReadMoreButton;

    @FindBy(xpath = "//div[@class='flexElement']")
    private static List<WebElement> imageCredits;

    @FindBy(xpath = "(//div[@class='photoGallerySec']/h1)[2]")
    private static WebElement nextGallery;

    @FindBy(xpath = "(//div[@class='photoGallery'])[2]")
    private static WebElement secondPhoto;
    @FindBy(xpath = "(//h4[@id='item2'])[1]")
    private static WebElement secondPhotopara;

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement exploremenu;

    @FindBy(xpath = "(//img[@class='lazy'])[1]")
    private static WebElement firstphoto;

    @FindBy(className = "socialEl")
    private static List<WebElement> shareIconBookMark;

    @FindBy(xpath = "//li[@class='collapse'][8]//a")
    private static WebElement photos;

    @FindBy(xpath = "(//figure)[1]//img")
    private static WebElement viewFirstArticleImage;

    @FindBy(xpath = "//div[@class='socialEl']")
    private static WebElement shareAndBookMarkVisibility;

    @FindBy(xpath = "(//div[@class='shareIcons'])[4]")
    private static WebElement secondShareIcon;

    @FindBy(xpath = "//div[@class='logo']")
    private static WebElement htLogo;

    @FindBy(xpath = "//div[@class = 'actionDiv flexElm']/div[2]")
    private static List<MobileElement> dateTime;

    @FindBy(xpath = "//section[@id='dataHolder']/div[2]/h3")
    private static WebElement fullStoryHeading;

    @FindBy(xpath = "//div[contains(@class,'storyDetails')]//p")
    private static List<MobileElement> fullStoryParagraphs;

    @FindBy(xpath = "//div[contains(@class,'liveBlog')]")
    private static WebElement liveButton;

    //@FindBy(xpath = "//div[@class='storyBy' and contains(.,'Written by')] | //div[@class='storyBy']")
    @FindBy(xpath = "(//div[@class='storyBy'])[1]")
    private static WebElement authorName;

    @FindBy(xpath = "(//div[contains(@class,'cartHolder')]//h3/a)[1]")
    private static WebElement firstStory;
    @FindBy(xpath = "(//div[contains(@class,'storyAd')])[2]")
    private static WebElement advert;

    @FindBy(xpath = "//div[contains(@class,'new__newsletter__signup')]")
    private static WebElement capsuleBanner;

    @FindBy(xpath = "//input[@class ='user_email']")
    private static WebElement enterEmail;

    @FindBy(xpath = "//button[@class='story-subscribe-newsletter']")
    private static WebElement buttonSubscribe;

    @FindBy(xpath = "//div[contains(@class,'toast-following')][contains(text(),'Subscribed to newsletter')]")
    private static WebElement subscribedMsg;

    @FindBy(xpath = "//div[contains(@class,'toast-following')][contains(text(),'Already Subscribed with')]")
    private static WebElement alreadySubscribedMsg;

    @FindBy(xpath = "//div[@class='htsHeader']")
    private static WebElement trendingTopic;

    @FindBy(xpath = "(//div[contains(@class,'cartHolder')]/h3[@class = 'hdg3'])[1]")
    private static WebElement firstStoryHeadLine;

    @FindBy(xpath = "//ul[@class = 'leftFixedNav']/li[1]/a")
    private static WebElement homeTab;

    @FindBy(xpath = "//ul[@class = 'leftFixedNav']/li[3]/a")
    private static WebElement indiaNewsInNavigation;

    @FindBy(className = "storyAd ht-dfp-ad1")
    private static WebElement firstAdInOpenedStory;

    @FindBy (xpath = "//section[@id='dataHolder']/div[2]/h3/a")
    private static WebElement firstStoryInIndiaSection;

    @FindBy(xpath = "//section[@id='dataHolder']/div[2]/figure/span/img")
    private static WebElement leadImageOfIndiaNewsSection;

    public StoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    public boolean checkNavigatedToIndiaNewsPage() {
        boolean isNavigatedToPage = false;
        commonFunctions.clickElementWithJS(exploreButton, 20, "Explore Menu");
        commonFunctions.clickElementWithJS(indiaNews, 10, "India News");
        String title = commonFunctions.getCurrentURL("URL");
        if (title.equalsIgnoreCase(Utils.getUrl() + "india-news")) {
            isNavigatedToPage = true;

        }
        commonFunctions.clickElementWithJS(openFullStory, 20, "Read Full Story");
        return isNavigatedToPage;
    }

    public boolean checkUrlAfterClickingReadFullStory() {
        String url = commonFunctions.getCurrentURL(" ");
        String id = commonFunctions.extractStoryID(url);
        Utils.logStepInfo(true,"id in Opened India News story url is - "+id);
        return url.contains("india-news") && url.endsWith(".html") && url.contains(id);
    }


    public Response getResponseFromAPI(String uri, String address) {

        String currentUrl = commonFunctions.getCurrentURL("URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        return response;
    }

    public boolean checkSectionNameIndiaNews(Response response) {
        boolean isSectionNameDisplayed;
        try{
        String text = commonFunctions.getElementText(section, 10);
        String value = JsonPath.parse(response.getBody().asString()).read("$.metadata.section");
        isSectionNameDisplayed = value.equalsIgnoreCase(text);}
        catch (PathNotFoundException pathNotFoundException){
            Utils.logStepInfo(true, "There is some issue with API response so path not found.");
            isSectionNameDisplayed = true;
        }
        return isSectionNameDisplayed;
    }

    public boolean checkHeadlineNextToSectionNameIndiaNews(Response response) {
        boolean isHeadLineDisplayed;
        String mobileHeadline = commonFunctions.getElementText(title, 40);
        Utils.logStepInfo(true,"mobileHeadline = "+ mobileHeadline);
        String value = JsonPath.parse(response.getBody().asString()).read("$.mobileHeadline");
        Utils.logStepInfo(true, "API Response value -- "+value);
        isHeadLineDisplayed = commonFunctions.checkTextContains(value,mobileHeadline,"Head line next to section Name India News");
        return isHeadLineDisplayed;
    }

    public boolean checkSummaryIndiaNews(Response response) {
        boolean isSummaryDisplayed;
        String summary = commonFunctions.getElementText(summaryOfFirstStory, 20);
        String value = JsonPath.parse(response.getBody().asString()).read("$.summary");
        Utils.logStepInfo(value);
        isSummaryDisplayed = value.contains(summary);
        return isSummaryDisplayed;
    }

    public boolean checkLeadImageIndiaNews() {

        return commonFunctions.isElementDisplayed(leadImageOfIndiaNewsSection, 20, "Lead Image");
    }


    public boolean checkParagraphBelowLeadImage(Response response) {
        boolean isStep;
        commonFunctions.scrollToElementView(paragraphIndiaNews, 10, "paragraph");
        String text = commonFunctions.getElementText(paragraphIndiaNews);
        LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read("$.listElement[0].paragraph");
        String value = paragraph.toString();
        value = Utils.formatAPIText(value);
        String [] Value1= value.split("=");
        String Value2= Value1[1];
        /*value.substring(6);*/
        Utils.logStepInfo(true, "" + Value2 + "");
        isStep = Value2.contains(text);
        return isStep;
    }

    public boolean checkScrollToPicsInStory() {
        return commonFunctions.scrollUsingAction(shareIcons.get(0), "Topics");
    }

    public boolean checkShareIconsAtTheEndOfStory() {
        return commonFunctions.isElementDisplayed(shareArticle, 10, "ShareIcons visible");
    }

    public boolean checkCloseButton() {
        boolean isCloseDisplayed =commonFunctions.scrollToElementView(close, 20, "Close Button");
        /*isCloseDisplayed = commonFunctions.isElementDisplayed(close, 10, "Close button");*/
        commonFunctions.clickElementWithJS(close, 20, "Close");
        return isCloseDisplayed;
    }

    public boolean checkURLChangedToParentURL() {
        boolean isURLChanged = false;
        String url = commonFunctions.getCurrentURL("India News", "Parent URL");
        if (url.equals("https://www.hindustantimes.com/india-news")) {
            isURLChanged = true;
        }
        return isURLChanged;
    }


    public boolean clickOnExplorerMenu() {
        boolean isExplorerMenuClickSuccessful = false;
        try {
            isExplorerMenuClickSuccessful = commonFunctions.clickElement(exploreButton, 20, "exploreButton");
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
        String href = " ";
        try {
            commonFunctions.scrollToElementView(firstArticleVideoSection, 30, "firstArticleVideoSection");
            href = firstArticleVideoSection.getAttribute("href");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            commonFunctions.scrollToElementView(firstVideobox, 20, "firstVideobox");
            commonFunctions.switchToFrame(videoIframe, 10);
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
        boolean checkSummary = checkSummaryBelowVideo();
        boolean readMoreButton = checkReadMoreButtonBelowVideo();
        boolean stopVideo = checkScrollDownToPageStopVideo();
        boolean checkShareIcon = checkShareIconAndBookMarkAboveVideo();

        return explorerMenu && videosHamburgerMenu && firstVideoArticle && urlModified && pageVideo
                && headlineOfVideoStory && videoControls && checkSummary && readMoreButton && stopVideo
                && checkShareIcon;
    }

    public boolean navigateToNewsPage() {
        boolean isNavigationSuccessful = false;
        commonFunctions.getURL(globalVars.getURL() + "india-news");
        String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
        if (currentURL.equals(globalVars.getURL() + "india-news")) {
            isNavigationSuccessful = true;
        }
        return isNavigationSuccessful;
    }

    public String lastPublishedDate() {
        String storyData = stories.getText();
        return storyData.split("on ")[1];
    }

    public String lastPublishedApiValidation(String params[]) {
        try {
            String storyData = stories.getText();
            String title = storyData.split("on ")[1];
            String query = params[0];
            Response response = apiValidation.getResponseFromURI(params[3], query);
            Filter myFilter = filter(where("title").is(title));
            String fields = response.jsonPath().get("lastPublishedDate").toString();
            long millisecond = Long.parseLong(fields);
            String dateString = new SimpleDateFormat("MM dd, yyyy hh:mm").format(new Date(millisecond));
		/*	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = df.parse(fields.toString());
			String actual_date= df.format(date);
*/

            return dateString;
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
        //String publishDateApi = lastPublishedApiValidation(params);
        return navigateToNewsPage /*&& (publishedDate.equalsIgnoreCase(publishDateApi))*/;
    }

    @Override
    public boolean checkStandardStoriesAreDisplayed(String uri, String address) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean checkNavigation = checkNavigatedToIndiaNewsPage();
        boolean isRedirectionSuccessful = checkUrlAfterClickingReadFullStory();
        String url = commonFunctions.getCurrentURL(" ");
        String id = commonFunctions.extractStoryID(url);
        apiValidation = new ApiValidation();
        Response response = apiValidation.getResponseFromURI(uri, address + id);
        boolean checkNewsSection = checkSectionNameIndiaNews(response);
        boolean checkHeadLine = checkHeadlineNextToSectionNameIndiaNews(response);
        boolean checkSummary = checkSummaryIndiaNews(response);
        boolean checkLeadImage = checkLeadImageIndiaNews();
        boolean isShowing = commonFunctions.isElementDisplayed(shareIconCricket, 15, "Share Icon Below Paragraph");
        isShowing &= checkParagraphBelowLeadImage(response);
        isShowing &= checkCloseButton();
        isShowing &= checkURLChangedToParentURL();
        Utils.logStepInfo(true,"checkNavigation = "+checkNavigation);
        Utils.logStepInfo(true,"isRedirectionSuccessful = "+isRedirectionSuccessful);
        Utils.logStepInfo(true,"checkNewsSection = "+checkNewsSection);
        Utils.logStepInfo(true,"checkHeadLine = "+checkHeadLine);
        Utils.logStepInfo(true,"checkSummary = "+checkSummary);
        Utils.logStepInfo(true,"checkLeadImage = "+checkLeadImage);
        Utils.logStepInfo(true,"isShowing = "+isShowing);
        return checkNavigation && isRedirectionSuccessful && checkNewsSection && checkHeadLine && checkSummary && checkLeadImage || isShowing;
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

    public boolean checkHeadlineNextToSectionName(Response response) {
        boolean isHeadlinenextToSectionName = false;
        boolean headLineApi = false;
        try {
            commonFunctions.scrollToElementView(headLineCricket, 20, "headLineCricket");
            isHeadlinenextToSectionName = commonFunctions.isElementDisplayed(headLineCricket, 20, "headLineCricket");
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

    public boolean checkSummaryNextToHeadLine(Response response) {
        boolean isSummaryNextToHeadLine = false;
        boolean summaryApi = false;
        try {
            commonFunctions.scrollToElementView(summaryCricket, 20, "summaryCricket");
            isSummaryNextToHeadLine = commonFunctions.isElementDisplayed(summaryCricket, 20, "summaryCricket");
            String summaryText = commonFunctions.getElementText(summaryCricket);
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

    public boolean checkLeadMediaCaptionImageCreditNextToSummary(Response response) {
        boolean isLeadMediaCaptionImageCreditDisp = false;
        boolean captionApi = false;
        boolean imageCreditApi = false;
        try {
            commonFunctions.scrollToElementView(leadMediaCricket, 20, "leadMediaCricket");
            isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCricket, 20);
            String captionAndImageCreditText = commonFunctions.getElementText(captionAndImageCredit);
            String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
            if (captionAndImageCreditText.contains(captionFromAPI)) {
                Utils.logStepInfo("check caption successful");
                captionApi = true;
            }
            String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
            if (captionAndImageCreditText.contains(imageCreditFromAPI)) {
                Utils.logStepInfo("check imageCredit successful");
                imageCreditApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLeadMediaCaptionImageCreditDisp && captionApi && imageCreditApi;
    }

    public boolean checkParagraphDisplayed(Response response) {
        boolean isParagraphDisplayed = false;
        boolean paragraphApi = false;
        try {
            commonFunctions.scrollToElementView(paragraphCricket, 20, "paragraphCricket");
            isParagraphDisplayed = commonFunctions.isElementDisplayed(paragraphCricket, 20);
            String text = commonFunctions.getElementText(paragraphCricket);
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

    public boolean checkTopicsDisplayed(Response response) {
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
        ApiValidation api = new ApiValidation();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigate = navigateToURL();
        String id = commonFunctions.extractStoryID(url);
        Response response = api.getResponseFromURI(uri, address + id);
        boolean headLine = checkHeadlineNextToSectionName(response);
        boolean checkSummary = checkSummaryNextToHeadLine(response);
        boolean checkLeadMedia = checkLeadMediaCaptionImageCreditNextToSummary(response);
        boolean checkParagraph = checkParagraphDisplayed(response);
        boolean checkShareIcon = checkShareIconDisplayed();
        boolean checkTopics = checkTopicsDisplayed(response);

        return navigate && headLine && checkSummary && checkLeadMedia && checkParagraph && checkShareIcon
                && checkTopics;
    }

    @Override
    public boolean checkLastPublishedDate(String[] params) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean photosGalleryContentValidation() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean checkStandardStoryPagination(String uri, String address) {
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
    public boolean checkHeadline() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean leadImageStatus = commonFunctions.isElementDisplayed(headLineStory, 10, "Lead Story Image");
        String storyTitle = commonFunctions.getElementText(headLineStory,5);
        commonFunctions.clickElementWithJS(headLineStory, 10, "lead Story Image");
        commonFunctions.dummyWait(10);
        boolean isStoryDetailOpen = commonFunctions.isElementDisplayed(firstStoryHeadLine,10,"Open Story Heading");
        String openStoryHeadLine = commonFunctions.getElementText(firstStoryHeadLine,5);
        isStoryDetailOpen &= commonFunctions.compareTexts(storyTitle,openStoryHeadLine);
        return leadImageStatus || isStoryDetailOpen;
    }

    @FindBy(xpath = "//ul[@class='leftFixedNav']//li[2]/a")
    private static WebElement sectionPageList;

    public boolean checkStoryIsExpanded() {
        return commonFunctionsMobile.checkStoryIsExpanded(sectionPageList, headLineStoriesLink, fullStoryHeading, fullStoryParagraphs);
    }

    @Override
    public boolean checkDateTime() {
        return commonFunctionsMobile.checkDateTimeMWeb(indiaNewsInNavigation, dateTime);
    }

    @Override
    public boolean checkAuthorName() {
        return commonFunctionsMobile.checkAuthorName(headLineStory, authorName);
    }

    public boolean checkStoryPageHeader() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(firstStoryHeadLine, 20, "First Story");
        commonFunctions.isElementDisplayed(leadImage, 20, "Lead Image");
        String headlineHomePage = commonFunctions.getElementText(firstStoryHeadLine);
        commonFunctions.waitForURLContains(".html");
        String currentUrl = commonFunctions.getCurrentURL();
        commonFunctions.navigateToURL(currentUrl);
        commonFunctions.waitForURLContains(".html");
        String headlineStoryPageAfterRefresh = commonFunctions.getElementText(firstStoryHeadLine);
        boolean isHeadlineSame = commonFunctions.checkTextEquals(headlineHomePage, headlineStoryPageAfterRefresh, "Headline");
        return isHeadlineSame;
    }

    @Override
    public boolean checkTrendingTopicsCarouselDispayed() {
        commonFunctions.navigateToURL(globalVars.getProdUrl());
        boolean isShowing=commonFunctions.clickElementWithJS(firstStory, 20, "First story");
        commonFunctions.dummyWait(4);
        commonFunctions.scrollDownToElement(trendingTopic);
        isShowing &=commonFunctions.isElementDisplayed(trendingTopic, 30, "Trending Topic");
        return isShowing;
    }

    @Override
    public boolean checkFullStoryCloseButton() {
        boolean isFullStoryCloseButtonTrue = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(firstStory, 20, "First story");
        isFullStoryCloseButtonTrue = commonFunctions.scrollToElementView(close,20,"close Story Button");
        commonFunctions.clickElementWithJS(close, 20, "Close story button");
        if (commonFunctions.scrollDownToElement(close) == false || commonFunctions.getCurrentURL().equalsIgnoreCase(Utils.getUrl())) {
            isFullStoryCloseButtonTrue = true;
        }
        return isFullStoryCloseButtonTrue;
    }

    @Override
    public boolean checkNewsletterBannerDisplayed() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForURLContains(Utils.getUrl());
        commonFunctions.clickElementWithJS(openFullStory, 20, "HeadLine");
        commonFunctions.waitForURLContains(".html");
        String currentUrl = commonFunctions.getCurrentURL();
        Utils.logStepInfo(true, currentUrl);
        commonFunctions.navigateToURL(currentUrl);
        commonFunctions.waitForURLContains(".html");
        boolean NewsletterBannerDisplayed = commonFunctions.scrollUsingAction(capsuleBanner,"Capsule Banner");
        commonFunctions.clickElementWithJS(enterEmail, 15, "Email");
        commonFunctions.sendKeyWithAction("shakyfb@gmail.com","enterEmail");
        commonFunctions.clickElementWithJS(buttonSubscribe, 5, "Subscribe");
        boolean isHomeTab = commonFunctions.isElementDisplayedAndPresent(homeTab,5,"Home Page");
        return NewsletterBannerDisplayed && isHomeTab;
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

    public boolean photoContentOfStory() {
        boolean photoContent;
        commonFunctions.clickElementWithJS(exploremenu, 10, "Explore icon");
        commonFunctions.scrollToElementViewAndClick(photos, 10, "Photos clicked");
        commonFunctions.scrollToElementViewAndClick(viewFirstArticleImage, 15, "Click on View all photos");
        photoContent = commonFunctions.isElementPresent(firstphoto, 10, "firstphoto");
        boolean photo1_story = commonFunctions.isElementDisplayed(firstphoto, 20);
        boolean share_BookMark = commonFunctions.isElementDisplayed(shareAndBookMarkVisibility, 20);
        commonFunctions.getElementText(headLineOfStory, 20);
        commonFunctions.getElementText(captionOfStory, 20);
        commonFunctions.getElementText(summaryLineOfPhoto, 20);

        if (photo1_story && share_BookMark) {
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
        String summary = "";
        if (commonFunctions.isElementDisplayed(summaryLineOfPhoto)) {
            summary = commonFunctions.getElementText(summaryLineOfPhoto, 20).trim();

        } else if (commonFunctions.isElementDisplayed(summaryLineOfPhotoP)) {
            summary = commonFunctions.getElementText(summaryLineOfPhotoP, 20).trim();

        }
        Utils.logStepInfo(true,"summary in UI - " +summary);
        String text = JsonPath.parse(response.getBody().asString()).read("$.summary");
        commonFunctions.textToReport(text);
        String t = text.replaceAll("&nbsp;", "").replaceAll("amp;", "").replaceAll("<[^>]*>", "");
        Utils.logStepInfo(true,"Summary response form API -- "+t);
        summaryPhoto = t.contains(summary);
        return summaryPhoto;
    }

    public boolean checkCaptionOfPhotoStory(String uri, String address) {
        boolean captionPhoto = false;
        commonFunctions.isElementDisplayed(captionOfStory, 20);
        String caption = commonFunctions.getElementText(captionOfStory, 20);
        String currentUrl = commonFunctions.getURL();
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        String value = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
        String[] pc = value.split(" ");
        captionPhoto = value.startsWith(pc[0]);
        return captionPhoto;
    }

    public boolean checkCaptionAndImageCreditOfPhotoStory(Response response) {
        boolean captionPhoto = false;
        commonFunctions.isElementDisplayed(captionOfStory, 20);
        /* String caption = commonFunctions.getElementText(captionOfStory, 20);*/
        String captionImageCredit = commonFunctions.getElementText(leadMediaCaptionImageCredit, 20).trim();
        String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
        String caption = captionFromAPI.replaceAll("&nbsp;", "").replaceAll("&amp", "").trim();
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


    public boolean checkShareIconAndBookMark() {
        int iconsCount = shareIconBookMark.size();

        for (int i = 0; iconsCount > i; i++) {
            boolean isStep = commonFunctions.isElementDisplayed(shareIconBookMark.get(i));
            Utils.logStepInfo(isStep, i + " Photo Share icon and book mark");
        }
        return commonFunctions.isElementDisplayed(shareIconBookMark.get(0), 20, "ShareIcon and BookMark");
    }

    public boolean checkUrlAfterClickingOnSecondphoto() {
        commonFunctions.scrollToElementView(secondPhotopara, 20, "Second Photo Para");
        commonFunctions.isElementDisplayed(secondPhoto, 10, "Second Photo");
        commonFunctions.isElementDisplayed(secondShareIcon, 10, "Second Share Icon");
        commonFunctions.dummyWait(5);
        String url = commonFunctions.getCurrentURL(" ");
        Utils.logStepInfo(true,"URl = "+url);
        return url.contains("2.html");
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
        boolean checkShareIcon = checkShareIconAndBookMark();
        boolean checkUrlSecondPhoto = checkUrlAfterClickingOnSecondphoto();
        Utils.logStepInfo(true,"isPhotoVisible = " +isPhotoVisible);
        Utils.logStepInfo(true,"isUrlChanged = " +isUrlChanged);
        Utils.logStepInfo(true,"checkHeadLine = " +checkHeadLine);
        Utils.logStepInfo(true,"checkSummary = " +checkSummary);
        Utils.logStepInfo(true,"checkCaption = " +checkCaption);
        Utils.logStepInfo(true,"checkShareIcon = " +checkShareIcon);
        Utils.logStepInfo(true,"checkUrlSecondPhoto = " +checkUrlSecondPhoto);
        return isPhotoVisible && isUrlChanged && checkHeadLine && checkSummary || checkCaption
                && checkShareIcon && checkUrlSecondPhoto;
    }

    @Override
    public boolean checkLeadImage() {
        boolean isLeadImageDisplayTru = true;

        commonFunctions.navigateToURL(globalVars.getURL());
        boolean leadImageStatus = commonFunctions.isElementDisplayed(leadImage, 20, "Lead Image");
        commonFunctions.clickElementWithJS(leadImage, 20, "leadImage");
        commonFunctions.dummyWait(10);
        commonFunctions.scrollDownOnce();
        //commonFunctions.clickElementIfDisplayed(closePopUP, 20, "Sign In continue reading.");
        commonFunctions.scrollToElementView(firstAdInOpenedStory, 20, "first Ad in Story");
        boolean isStoryDetailOpen = commonFunctions.isElementDisplayed(close, 20, "Story Detail Page");
        Utils.logStepInfo(true,"leadImageStatus = "+leadImageStatus);
        Utils.logStepInfo(true,"isStoryDetailOpen = "+isStoryDetailOpen);
        isLeadImageDisplayTru &= leadImageStatus && isStoryDetailOpen;
        return isLeadImageDisplayTru;
    }

    @Override
    public boolean checkRedirectionWhenUserTapsOnStoryInCitiesSection() { return false; }

    @Override
    public boolean checkSubscriptionPaywall(String HTPremiumPageUrl, String email, String password) {
        return false;
    }
}
