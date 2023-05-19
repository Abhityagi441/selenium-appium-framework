package com.pages.HindustanTimes.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonInlineStoriesPage;
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
//import sun.tools.jconsole.HTMLPane;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class InlineStoriesPage extends CommonInlineStoriesPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    @FindBy(xpath="//div[contains(@class,'cartHolder bigCart')]/h3/a")
    private static WebElement openFullStory;

    @FindBy(xpath = "//a[contains(@class,'closeStory')]")
    private static WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/div/div/a")
    private static WebElement section;

    @FindBy(xpath = "//h1[@class='hdg1']")
    private static WebElement headline;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]//h2")
    private static WebElement summary;

    @FindBy(xpath="(//div[@class='cartHolder bigCart']//h3[@class='hdg3'])[1]")
    private static WebElement openFullStorySaved;

    @FindBy(xpath = "//div[@class='detail']/p") //div[contains(@class,'storyDetails')]//div//p
    private static WebElement paragraph;

    @FindBy(xpath = "//div[@class='shareArticle']//div")
    private static WebElement shareIcons;

    @FindBy(xpath = "//div[@class = 'storyTopics']/div/a")
    private static List<WebElement> topics;

    @FindBy(xpath = "//div[@class='storyBy']")
    private static WebElement leadMediaCaption;

    @FindBy(xpath = "//figure/figcaption")
    private static WebElement captionAndImageCredit;

    @FindBy(xpath = "//div[@class='detail']/p")
    private static List<WebElement> paragraphList;

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
        Utils.logStepInfo(true, "*********** Verification Start for " +path+ " ***********");
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
        value = value.trim();
        text = text.trim();
        Utils.logStepInfo(true, "API response Value is --- " + value + "");
        if (element == section) {
            if(value.equalsIgnoreCase("cities")){
                isStepTrue = true;
                Utils.logStepInfo(true, "Sub Section showing as a city name That's why getting API response as cities");
            }
            else{
            isStepTrue = value.equalsIgnoreCase(text);}
        } else {
            isStepTrue = value.contains(text.substring(0,15));
        }
        Utils.logStepInfo(true, "isStepTrue value is --- "+isStepTrue);
        return isStepTrue;
    }

    public boolean checkInlineStoriesParagraph(List<WebElement> elementList,String uri, String address, String path) {
        boolean isStepTrue = false;
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
            value = paragraph.toString().trim();
            paragraphListAPI = HTMLParser.getParagraphList(value);
        }
        if(paragraphListUI.equals(paragraphListAPI)){
            isStepTrue = true;
            Utils.logStepInfo(isStepTrue, "Paragraph content from UI matched with API response");
        }
        else{
            Utils.logStepInfo(isStepTrue, "Paragraph content from UI are not matched with API response");
        }
        return isStepTrue;
    }



    public boolean checkLeadLineCaptionImageCredit(String uri,String address) {
        boolean isLeadMediaCaptionImageCreditDisp = false;
        boolean captionApi = false;
        boolean imageCredit = false;
        try {
            commonFunctions.scrollToElementView(leadMediaCaption, 20, "leadMediaCaption");
            isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCaption, 20,"Lead Media Caption");
            String captionAndImageCreditText = commonFunctions.getElementText(captionAndImageCredit,10).trim();
            Utils.logStepInfo(true,"captionAndImageCreditText element text is - "+captionAndImageCreditText);

            Response response = getResponseFromAPI(uri, address);
            String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");

            String captionAPI = captionFromAPI.replace("&nbsp;"," ").trim();
            Utils.logStepInfo(true,"Lead Media API Response value is - "+captionAPI);

            if (captionAndImageCreditText.contains(captionAPI.substring(0,15))) {
                Utils.logStepInfo(true, "checked caption successful");
                captionApi = true;
            }
            /*Observation has found sometimes image credit  has not been displayed for some stories.so we are checking API response for Story
             * if image credit found for the current story then only it will check*/

            String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");

            if(imageCreditFromAPI!=null && imageCreditFromAPI !="") {
                if(captionAndImageCreditText.trim().equalsIgnoreCase(imageCreditFromAPI.trim()))
                {
                    imageCredit = true;
                    Utils.logStepInfo(imageCredit, "check imageCredit successful by equalsIgnoreCase");
                }
                else if(captionAndImageCreditText.contains(imageCreditFromAPI.substring(0,15))) {
                    imageCredit = true;
                    Utils.logStepInfo(imageCredit, "check imageCredit successful with contains");
                }
            }else{
                Utils.logStepInfo(imageCredit, "image Credit not displayed for Current Story on UI");
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        if (imageCredit){
        return isLeadMediaCaptionImageCreditDisp && captionApi && imageCredit;
        }
        else {
         return isLeadMediaCaptionImageCreditDisp || captionApi;
        }
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
        System.out.println("*********** Verification start for "+path+" *************");
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
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isReadfullStoryClick = clickReadFullStory();
        boolean isRedirectionSuccessful = checkUrlAfterClickingReadFullStory();
        boolean isSectionDisplayed = checkInlineStoriesElements(section,uri,address,"$.metadata.section");
        boolean isDisplayed = commonFunctions.isElementDisplayed(section, 20, "Section");
        boolean isHeadlineDisplayed = checkInlineStoriesElements(headline,uri,address,"$.headline");
        boolean isSummaryDisplayed = checkInlineStoriesElements(summary,uri,address,"$.summary");
        boolean isLeadMediaDisplayed = checkLeadLineCaptionImageCredit(uri,address);
        boolean isScrolled = commonFunctions.scrollUsingAction(paragraph, "paragraph");
        Utils.logStepInfo(isScrolled, "paragraph is scrolled");
        boolean isParagraphDisplayed = checkInlineStoriesParagraph(paragraphList,uri,address,"$.listElement[0].paragraph");
        boolean isShareIconsDisplayed = checkShareIcons();
        //boolean isTopicDisplayed = checkTopic(topics,uri, address,"$.metadata.topic");
        return isReadfullStoryClick && isRedirectionSuccessful && isSectionDisplayed && isHeadlineDisplayed && isSummaryDisplayed && isLeadMediaDisplayed
                &&  isParagraphDisplayed && isShareIconsDisplayed;
    }

    @Override
    public boolean checkInlineStoriesOpening() {
        return false;
    }
}

