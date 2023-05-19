package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonInlineStoriesPage;
import com.utils.GlobalVars;
import com.utils.HTMLParser;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class InlineStoriesPage extends CommonInlineStoriesPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @FindBy(xpath="//div[@class='cartHolder bigCart']//h3[@class='hdg3']")
    private static WebElement openFullStory;

    @FindBy(xpath = "//a[contains(@class,'closeStory')]")
    private static WebElement closeButton;

    @FindBy(xpath = "//div[@class='catName pt10']/a")
    private static WebElement section;

    @FindBy(xpath = "//h1[@class='hdg1']")
    private static WebElement headline;

    @FindBy(xpath = "//div[@class='sortDec']")
    private static WebElement summary;

    @FindBy(xpath = "//a[contains(text(),'READ')]")
    private static WebElement openFullStorySaved;

    @FindBy(xpath = "//div[contains(@class,'storyDetails')]//div//p")
    private static WebElement paragraph;

    @FindBy(xpath = "//div[@class='detail']/p")
    private static List<WebElement> paragraphList;

    @FindBy(xpath = "//div[@class='shareArticle']//div")
    private static WebElement shareIcons;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static List<WebElement> topics;

    @FindBy(xpath = "//div[@class='storyBy']")
    private static WebElement leadMediaCaption;

    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement captionAndImageCredit;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(xpath = "//div[@class='secHdg']")
    private static List<WebElement> sectionHeading;

    @FindBy(xpath = "//p//b")
    private static WebElement highlightedLink;

    @FindBy(xpath="//li//a[text()='Home']")
    private static WebElement home;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;


    public InlineStoriesPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver)globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    public boolean clickReadFullStory() {
        boolean isReadfullStoryClick;
        commonFunctions.scrollToElementView(openFullStory, 25,"Read Full Story");
        isReadfullStoryClick = commonFunctions.isElementDisplayed(openFullStory, 25, "read full story");
        commonFunctions.clickElementWithJS(openFullStory);
        return isReadfullStoryClick;
    }

    public boolean checkUrlAfterClickingReadFullStory() {
        String url = commonFunctions.getCurrentURL("News section", "URL");
        String id = commonFunctions.extractStoryID(url);
        return url.endsWith("amp.html") && url.contains(id);
    }

    public Response getResponseFromAPI(String uri, String address) {
        String currentUrl = commonFunctions.getCurrentURL("India News", "URL");
        Utils.logStepInfo("CurrentUrl " + currentUrl);
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Utils.logStepInfo("StoryID " + storyid);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        return response;
    }

    public boolean checkInlineStoriesElements(WebElement element,String uri, String address, String path) {
        boolean isStepTrue;
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
            isStepTrue = value.equalsIgnoreCase(text);
        } else {
            isStepTrue = value.contains(text);
        }
        return isStepTrue;
    }

    /*Observation has found sometimes image credit  has not been displayed for some stories.so we are checking API response for Story
     * if image credit found for the current story then only it will check*/

    public boolean checkLeadLineCaptionImageCredit(String uri,String address) {
        boolean isLeadMediaCaptionImageCreditDisp = false;
        boolean captionApi = false;
        boolean imageCredit = false;

        try {
            commonFunctions.scrollToElementView(leadMediaCaption, 20, "leadMediaCaption");
            isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCaption, 20);
            String captionAndImageCreditText = commonFunctions.getElementText(captionAndImageCredit);
            Response response = getResponseFromAPI(uri, address);
            String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
            String captionAPI = captionFromAPI.replace("&nbsp;"," ");
            Utils.logStepInfo(captionAPI);
            if (captionAndImageCreditText.contains(captionAPI)) {
                Utils.logStepInfo("check caption successful");
                captionApi = true;
            }
            String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
            if(imageCreditFromAPI!=null && imageCreditFromAPI !="") {

                if (captionAndImageCreditText.contains(imageCreditFromAPI)) {
                    imageCredit = true;
                    Utils.logStepInfo("check imageCredit successful");
                }
                return imageCredit;
            }else{
                Utils.logStepInfo("image Credit not displayed for Current Story on UI");
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        if (imageCredit){
            return isLeadMediaCaptionImageCreditDisp && captionApi && imageCredit;
        }
        else {
            return isLeadMediaCaptionImageCreditDisp && captionApi;
        }
    }

    public boolean checkInlineStoriesParagraph(List<WebElement> elementList,String uri, String address, String path) {
        boolean isStepTrue;
        String value = "";
        List<String> paragraphListUI=new ArrayList<>();
        List<String> paragraphListAPI=new ArrayList<>();

        for(WebElement element: elementList){
            String paragraphText =  commonFunctions.getElementText(element).trim();
            if (!paragraphText.isEmpty()){
                paragraphListUI.add(paragraphText);
            }
        }

        Response response = getResponseFromAPI(uri, address);
        if (path.contains("paragraph")) {
            LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read(path);
            value = paragraph.toString();
            paragraphListAPI = HTMLParser.getParagraphList(value);
        }
        isStepTrue=paragraphListUI.equals(paragraphListAPI);
        Utils.logStepInfo(true, "Paragraph content from UI matched with API response");
        return isStepTrue;
    }

    public boolean checkShareIcons() {
        boolean isShareIconsDisplayed;
        commonFunctions.scrollToElementView(shareIcons, 25,"share icons");
        isShareIconsDisplayed = commonFunctions.isElementDisplayed(shareIcons);
        Utils.logStepInfo(isShareIconsDisplayed, "check share icon successful");
        return isShareIconsDisplayed;

    }

    public boolean checkTopic(List<WebElement> elementList,String uri,String address,String path) {
        boolean isTopicDisplayed = false;
        boolean isStepTrue = false;
        List<String> topicsListUI = new ArrayList<>();
        List<String> topicsListAPI = new ArrayList<>();
        try {
            Response response = getResponseFromAPI(uri, address);
            topicsListAPI = JsonPath.parse(response.getBody().asString()).read(path);
            if (topicsListAPI == null) {
                Utils.logStepInfo(true, "Topics is not present in this particular story");
                isStepTrue = true;
            } else {
                for (WebElement element : elementList) {
                    String topicsText = commonFunctions.getElementText(element).trim();
                    if (!topicsText.isEmpty()) {
                        topicsListUI.add(topicsText);
                    }
                }
                isTopicDisplayed = topicsListUI.contains(topicsListAPI);
                Utils.logStepInfo(true,"Topics is available for this story");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isStepTrue){
            return isStepTrue;
        }else {
            return isTopicDisplayed;
        }
    }

    @Override
    public boolean checkInlineStoriesCases(String uri,String address){
        boolean isReadfullStoryClick = clickReadFullStory();
        boolean isRedirectionSuccessful = checkUrlAfterClickingReadFullStory();
        boolean isSectionDisplayed = checkInlineStoriesElements(section,uri,address,"$.metadata.section");
        boolean isDisplayed = commonFunctions.isElementDisplayed(section, 20, "Section");
        Utils.logStepInfo(isDisplayed, "section is displayed");
        boolean isHeadlineDisplayed = checkInlineStoriesElements(headline,uri,address,"$.headline");
        boolean isSummaryDisplayed = checkInlineStoriesElements(summary,uri,address,"$.summary");
        boolean isLeadMediaDisplayed = checkLeadLineCaptionImageCredit(uri,address);
        boolean isScrolled = commonFunctions.scrollUsingAction(paragraph, "paragraph");
        Utils.logStepInfo(isScrolled, "paragraph is scrolled");
        boolean isParagraphDisplayed = checkInlineStoriesParagraph(paragraphList,uri,address,"$.listElement[0].paragraph");
        boolean isShareIconsDisplayed = checkShareIcons();
        boolean isTopicDisplayed = checkTopic(topics,uri, address,"$.metadata.topic");

        return isReadfullStoryClick && isRedirectionSuccessful && isSectionDisplayed && isHeadlineDisplayed && isSummaryDisplayed && isLeadMediaDisplayed
                &&  isParagraphDisplayed && isShareIconsDisplayed && isTopicDisplayed;
    }

    public boolean checkHomepageLoadedProperly(){
        return commonFunctions.isElementDisplayed(hamBurger,20,"Home page properly loaded");
    }


    public boolean checkStoryCompletelyLoaded(){
        return commonFunctions.isElementDisplayed(summary,20,"Storypage completely loaded");
    }

    public boolean scrollTopToBottomOfStory(){
        boolean isScrollToBottom=false;
        isScrollToBottom=commonFunctions.scrollToElementView(shareIcons,20,"ShareIcons");
        return isScrollToBottom;
    }

    public boolean navigationToHighlightedLink(){
        boolean isHighlightedElement;
        try {
            commonFunctions.scrollToElementView(highlightedLink, 20, "Highlighted Link");
            if(highlightedLink.isDisplayed()){
                isHighlightedElement=commonFunctions.clickElement(highlightedLink,10,"Highlighted Element");
            }
            else{
                isHighlightedElement=false;
                Utils.logStepInfo("Highlighted Element not displayed");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            isHighlightedElement=false;
        }
        return isHighlightedElement;
    }


    public boolean checkRedirectionToHomePage(){
        boolean isRedirection;
        isRedirection =commonFunctions.scrollToElementViewAndClick( home,10,"Home Button");
        return isRedirection;
    }



    @Override
    public boolean checkInlineStoriesOpening(){
        boolean homePageLoading = checkHomepageLoadedProperly();
        boolean clickOnStory = clickReadFullStory();
        boolean redirectionSuccessful= checkUrlAfterClickingReadFullStory();
        boolean storyCompletelyLoaded = checkStoryCompletelyLoaded();
        boolean scrollToBottomOfStory = scrollTopToBottomOfStory();
        boolean navigateToHighlightedLink= navigationToHighlightedLink();
        boolean redirectToHome = checkRedirectionToHomePage();


        return  homePageLoading && clickOnStory && redirectionSuccessful && storyCompletelyLoaded &&
                scrollToBottomOfStory && navigateToHighlightedLink && redirectToHome;
    }
}

