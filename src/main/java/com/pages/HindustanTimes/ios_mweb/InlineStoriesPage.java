package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonInlineStoriesPage;
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

import java.util.LinkedHashMap;
import java.util.Locale;

public class InlineStoriesPage extends CommonInlineStoriesPage {

    private static IOSDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath="//div[contains(@class,'cartHolder')]/h3/a")
    private static WebElement  openFullStory;

    @FindBy(xpath = "//a[contains(@class,'closeStory')]")
    private static WebElement closeButton;

    @FindBy(xpath = "(//div[contains(@class,'catName')]/a)[1]")
    private static WebElement section;

    @FindBy(xpath = "(//div[contains(@class,'catName')]//following-sibling::h3[@class='hdg3'])[1]")
    private static WebElement headline;

    @FindBy(xpath = "//div[contains(@class,'fullStory')]/div[2]")
    private static WebElement summary;

    @FindBy(xpath = "//a[contains(text(),'READ')]")
    private static WebElement openFullStorySaved;

    @FindBy(xpath = "//div[contains(@class,'storyDetails')]/div/p")
    private static WebElement paragraph;

    @FindBy(xpath = "//div[contains(@class,'shareSticky')]")
    private static WebElement shareIcons;

    @FindBy(xpath = "//div[@class='storyTopics']")
    private static WebElement topics;

    @FindBy(xpath = "//div[@class='storyBy']")
    private static WebElement leadMediaCaption;

    @FindBy(xpath = "(//figcaption)[1]")
    private static WebElement captionAndImageCredit;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    ApiValidation apiValidation;

    public InlineStoriesPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        apiValidation = new ApiValidation();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean clickReadFullStory() {
        boolean isReadfullStoryClick;
        commonFunctions.navigateToURL(globalVars.getURL());
        isReadfullStoryClick = commonFunctions.scrollToElementViewAndClick(openFullStory, 25, "read full story");
        return isReadfullStoryClick;
    }

    public boolean checkUrlAfterClickingReadFullStory() {
        String url = commonFunctions.getCurrentURL("News section", "URL");
        String id = commonFunctions.extractStoryID(url);
        return  url.endsWith(".html") && url.contains(id);
    }

    public Response getResponseFromAPI(String uri, String address) {
        String currentUrl = commonFunctions.getCurrentURL("India News", "URL");
        String storyid = commonFunctions.extractStoryID(currentUrl);
        Response response = commonFunctions.getResponseFromURI(uri, address + storyid);
        return response;
    }

    public boolean checkInlineStoriesElements(WebElement element,Response response, String path) {
        boolean isStepTrue;
        String value = "";
        String subValue="";
        String text = commonFunctions.getElementText(element, 20);

        if (path.contains("paragraph")) {
            LinkedHashMap paragraph = JsonPath.parse(response.getBody().asString()).read(path);
            value = paragraph.get("body").toString().replaceAll("\\<.*?>","");

        }
        else if(path.contains("section")){
            value = JsonPath.parse(response.getBody().asString()).read(path);
            subValue = JsonPath.parse(response.getBody().asString()).read("$.metadata.subSection");
        }
        else {
            value = JsonPath.parse(response.getBody().asString()).read(path);
        }
        Utils.logStepInfo(true, "" + value + "");
        if (path.contains("section")) {
            isStepTrue = value.equalsIgnoreCase(text) || subValue.equalsIgnoreCase(text) ;
        } else {
            isStepTrue = value.contains(text);
        }
        return isStepTrue;
    }


    public boolean checkLeadLineCaptionImageCredit(Response response) {
        boolean isLeadMediaCaptionImageCreditDisp = false;
        boolean captionApi = false;
        boolean imageCreditApi = false;
        try {
            commonFunctions.scrollToElementView(leadMediaCaption, 20, "leadMediaCaption");
            isLeadMediaCaptionImageCreditDisp = commonFunctions.isElementDisplayed(leadMediaCaption, 20);
            String captionImageCredit = commonFunctions.getElementText(captionAndImageCredit);

            String captionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.caption");
            if (captionImageCredit.contains(captionFromAPI)) {
                Utils.logStepInfo("check caption successful");
                captionApi = true;
            }
            /*Observation has found sometimes image credit for the story has not been displayed so we are checking API response
             * if image credit found then only it will check*/
            String imageCreditFromAPI = JsonPath.parse(response.getBody().asString()).read("$.leadMedia.image.imageCredit");
            if (imageCreditFromAPI != null && imageCreditFromAPI != "") {

                if (captionImageCredit.contains(imageCreditFromAPI)) {
                    imageCreditApi = true;
                    commonFunctions.textToReport("check imageCredit successful");
                }

            } else {
                commonFunctions.textToReport("image Credit not displayed for Story on UI");
                imageCreditApi = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLeadMediaCaptionImageCreditDisp && captionApi && imageCreditApi;
    }

    public boolean checkShareIcons() {
        boolean isShareIconsDisplayed;
        commonFunctions.scrollUsingAction(shareIcons, "share icons");
        isShareIconsDisplayed = commonFunctions.isElementDisplayed(shareIcons);
        Utils.logStepInfo(isShareIconsDisplayed, "check share icon successful");
        return isShareIconsDisplayed;

    }

    public boolean  checkTopic(Response response) {
        boolean isTopicDisplayed = false;
        try {
            commonFunctions.scrollUsingAction(topics, "topics");
            String text = commonFunctions.getElementText(topics);

            JSONArray topic = JsonPath.parse(response.getBody().asString()).read("$.metadata.topic");
            String value = topic.get(0).toString();
            if(value.equals(null)){
                isTopicDisplayed = true;
                Utils.logStepInfo("Topics is not present on this page");

            }
            else{
            isTopicDisplayed = text.toLowerCase().contains(value);
                }
        } catch (Exception e) {
                e.printStackTrace();
        }

        return isTopicDisplayed;
    }

    public boolean checkCloseButton() {
        boolean isCloseDisplayed;
        isCloseDisplayed = commonFunctions.isElementDisplayed(closeButton, 10, "Close button");
        String  storyURL = commonFunctions.getCurrentURL("News section","URL");
        commonFunctions.clickElement(closeButton, 20, "Close button");
        String parentURL = commonFunctions.getCurrentURL("Home Page","URL");
        if (!parentURL.equalsIgnoreCase(storyURL) && parentURL.equalsIgnoreCase(Utils.getUrl())){
            isCloseDisplayed = true;
        }

        return isCloseDisplayed;
    }

    @Override
	public boolean checkInlineStoriesCases(String uri,String address){
        boolean isReadfullStoryClick = clickReadFullStory();
        String url = commonFunctions.getCurrentURL("News section", "URL");
        String id = commonFunctions.extractStoryID(url);
        boolean isRedirectionSuccessful=url.endsWith(".html") && url.contains(id);
        Response response = apiValidation.getResponseFromURI(uri, address+id);
        commonFunctions.dummyWait(10);
        System.out.println(response);
        boolean isSectionDisplayed = checkInlineStoriesElements(section,response,"$.metadata.section");
        boolean isHeadlineDisplayed = checkInlineStoriesElements(headline,response,"$.title");
        boolean isSummaryDisplayed = checkInlineStoriesElements(summary,response,"$.summary");
        boolean isLeadMediaDisplayed = checkLeadLineCaptionImageCredit(response);
        boolean isScrolled = commonFunctions.scrollUsingAction(paragraph, "paragraph");
        Utils.logStepInfo(isScrolled, "paragraph is scrolled");
        boolean isParagraphDisplayed = checkInlineStoriesElements(paragraph, response, "$.listElement[0].paragraph");
        boolean isShareIconsDisplayed = checkShareIcons();
        //topic not present
        //boolean isTopicDisplayed = checkTopic(response);
        boolean isCloseDisplayed = checkCloseButton();

		return isReadfullStoryClick && isRedirectionSuccessful && isSectionDisplayed && isHeadlineDisplayed && isSummaryDisplayed && isLeadMediaDisplayed
                &&  isParagraphDisplayed && isShareIconsDisplayed && isCloseDisplayed;
	}

    @Override
    public boolean checkInlineStoriesOpening() {
        return false;
    }
}
