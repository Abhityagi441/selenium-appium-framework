package com.pages.HindustanTimes.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonInlineStoriesPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.HTMLParser;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class InlineStoriesPage extends CommonInlineStoriesPage {
    public HTMLParser htmlParser;
    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
    private static WebElement openFullStory;

    @FindBy(xpath = "//div[@id='topnews']/section/div[1]/div[1]/div[3]/a")
    private static WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h3")
    private static WebElement section;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/h3")
    private static WebElement headline;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/div[2]")
    private static WebElement summary;

    @FindBy(xpath = "//a[contains(text(),'READ')]")
    private static WebElement openFullStorySaved;

    @FindBy(xpath = "//div[contains(@class,'storyDetails')]//div//p")
    private static WebElement paragraph;

    @FindBy(xpath = "//div[contains(@class,'shareIcons')]")
    private static WebElement shareIcons;

    @FindBy(xpath = "//div[@class = 'storyTopics']/div[1]/a[1]")
    private static WebElement topics;

    @FindBy(xpath = "//div[@class = 'storyTopics']")
    private static WebElement topicsSection;

    @FindBy(xpath = "(//div[@class='storyBy'])[1]")
    private static WebElement leadMediaCaption;

    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement captionAndImageCredit;

    public InlineStoriesPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean clickReadFullStory() {
        boolean isReadfullStoryClick;
        commonFunctions.scrollToElementView(openFullStory, 20, "Read Full Story");
        isReadfullStoryClick = commonFunctions.isElementDisplayed(openFullStory, 10, "read full story");
        commonFunctions.clickElementWithJS(openFullStory, 15, "Read Full Story");
        return isReadfullStoryClick;
    }

    public boolean checkUrlAfterClickingReadFullStory() {
        String url = commonFunctions.getCurrentURL("URL");

        return  url.endsWith(".html");
    }

    public Response getResponseFromAPI(String uri, String address) {
        String currentUrl = commonFunctions.getCurrentURL("URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);

        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        return response;
    }

    public boolean checkInlineStoriesElements(WebElement element,Response response, String path) {
        boolean isStepTrue= false;
        HashMap data = new HashMap();
        String value = "";
        htmlParser = new HTMLParser();
        String text = commonFunctions.getElementText(element, 20);

        if (path.contains("paragraph")) {
            LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read(path);
            List<String> para= HTMLParser.getParagraphList(paragraph.toString());
            value = para.get(0);

        } else if (path.contains("section")){
            data= response.jsonPath().getJsonObject("metadata");
            value = data.get(path).toString();
        }
        else{
            value =response.jsonPath().get(path).toString().replaceAll("\\<[^>]*>","");
        }
        if(path.toLowerCase().contains("headline")||path.toLowerCase().contains("summary")){
            isStepTrue= value.equalsIgnoreCase(text);
        }
        else {
            isStepTrue = text.equalsIgnoreCase(value);
        }

        return isStepTrue;
    }


    public boolean checkLeadLineCaptionImageCredit(Response response) {
        boolean isLeadMediaCaptionImageCreditDisp = false;
        boolean captionApi = false;
        try {
            commonFunctions.scrollToElementView(leadMediaCaption, 20, "leadMediaCaption");
            isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCaption, 20,"Lead Media Caption");
            String captionAndImageCreditText = commonFunctions.getElementText(captionAndImageCredit,10).trim();
            String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption").toString().replaceAll("&nbsp;","").trim();
            Utils.logStepInfo(true,"Caption and image Credit Text -- "+captionAndImageCreditText+ "\n caption From API response --" +captionFromAPI);
            if (captionAndImageCreditText.contains(captionFromAPI)) {
                captionApi = true;
                Utils.logStepInfo(captionApi,"Caption checked successful");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLeadMediaCaptionImageCreditDisp || captionApi;
    }

    public boolean checkShareIcons() {
        boolean isShareIconsDisplayed;
        commonFunctions.scrollUsingAction(shareIcons, "share icons");
        isShareIconsDisplayed = commonFunctions.isElementDisplayed(shareIcons);
        Utils.logStepInfo(isShareIconsDisplayed, "check share icon successful");
        return isShareIconsDisplayed;

    }

    public boolean checkTopic(Response response) {
        boolean isTopicDisplayed;
        try {
            boolean isScrollToTopic = commonFunctions.scrollToElementView(topicsSection, 20,"topic Section");
            String text = commonFunctions.getElementText(topics);
            JSONArray topic = JsonPath.parse(response.getBody().asString()).read("$.metadata.topic");
            String value = topic.get(0).toString();
            isTopicDisplayed = text.toLowerCase(Locale.ROOT).contains(value);
        }
        catch (Exception e) {
            isTopicDisplayed = true;
            Utils.logStepInfo(true,"Topics is not present on this page");
        }
        return isTopicDisplayed;
    }

    public boolean checkCloseButton() {
        boolean isCloseDisplayed;
        isCloseDisplayed = commonFunctions.isElementDisplayed(closeButton, 10, "Close button");
        String  storyURL = commonFunctions.getCurrentURL("News section","URL");
        commonFunctions.clickElementWithJS(closeButton, 20, "Close button");
        String parentURL = commonFunctions.getCurrentURL("Home Page","URL");
        if (!parentURL.equalsIgnoreCase(storyURL) && parentURL.equalsIgnoreCase(globalVars.getURL())){
            isCloseDisplayed = true;
        }

        return isCloseDisplayed;
    }

    @Override
    public boolean checkInlineStoriesCases(String uri,String address){
        ApiValidation api = new ApiValidation();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isReadfullStoryClick = clickReadFullStory();
        boolean isDisplayed = commonFunctions.isElementDisplayed(section, 20, "Section");
        Utils.logStepInfo(isDisplayed, "section is displayed");
        String url = commonFunctions.getCurrentURL("URL");
        boolean isRedirectionSuccessful= url.endsWith(".html");
        String id = commonFunctions.extractStoryID(url);

        Response response = api.getResponseFromURI(uri, address+id);
        boolean isHeadlineDisplayed = checkInlineStoriesElements(headline, response,"mobileHeadline");
        boolean isSummaryDisplayed = checkInlineStoriesElements(summary, response, "summary");
        boolean isLeadMediaDisplayed = checkLeadLineCaptionImageCredit(response);
        boolean isScrolled = commonFunctions.scrollUsingAction(paragraph, "paragraph");
        Utils.logStepInfo(isScrolled, "paragraph is scrolled");
        boolean isParagraphDisplayed = checkInlineStoriesElements(paragraph, response, "$.listElement[0].paragraph");
        //boolean isTopicDisplayed = checkTopic(response);
        boolean isCloseDisplayed = checkCloseButton();
        Utils.logStepInfo(isReadfullStoryClick , "isReadfullStoryClick value is = "+isReadfullStoryClick);
        Utils.logStepInfo(isRedirectionSuccessful , "isRedirectionSuccessful value is = "+isRedirectionSuccessful);
        Utils.logStepInfo(isHeadlineDisplayed , "isHeadlineDisplayed value is = "+isHeadlineDisplayed);
        Utils.logStepInfo(isSummaryDisplayed , "isSummaryDisplayed value is = "+isSummaryDisplayed);
        Utils.logStepInfo(isCloseDisplayed , "isCloseDisplayed value is = "+isCloseDisplayed);
        Utils.logStepInfo(isParagraphDisplayed , "isParagraphDisplayed value is = "+isParagraphDisplayed);
        Utils.logStepInfo(isLeadMediaDisplayed , "isLeadMediaDisplayed value is = "+isLeadMediaDisplayed);
        return isReadfullStoryClick && isRedirectionSuccessful &&  isHeadlineDisplayed && isSummaryDisplayed || isCloseDisplayed && isParagraphDisplayed && isLeadMediaDisplayed;
    }

    @Override
    public boolean checkInlineStoriesOpening() {
        return false;
    }
}
