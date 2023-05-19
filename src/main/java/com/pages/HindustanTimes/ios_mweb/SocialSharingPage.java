package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonSocialSharingPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SocialSharingPage extends CommonSocialSharingPage {

    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;

    @FindBy(xpath = "//div[@class='shareIcons']//a[2]")
    private static WebElement twitterSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']//a[3]")
    private static WebElement facebookSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']//a[4]")
    private static WebElement linkedinSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareArticle']//a[@class='tw']")
    private static WebElement twitterShareOptionInlineStory;

    @FindBy(xpath = "//div[@class='shareArticle']//a[@class='fb']")
    private static WebElement facebookShareOptionInlineStory;

    @FindBy(xpath = "//a[@data-id='Home,1']")
    private static WebElement HomeOption;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "(//div[contains(@class,'cartHolder')]//h3[@class='hdg3']/a)[1]")
    private static WebElement firstStoryTitle;

    @FindBy(xpath = "(//span[contains(@class,'share')])[1]")
    private static WebElement firstStoryShareAllOptions;

    @FindBy(xpath = "//div[@class='new__socialIcons']/div[2]/div/div[2]/div[2]")
    private static WebElement copyUrlToShareAllOptions;

    @FindBy(xpath = "//em[text()='India News']")
    private static WebElement indiaNews;

    @FindBy(className = "btnExplore")
    private static WebElement explore;

    @FindBy(xpath = "(//span[@class = 'share share-candidate'])[1]")
    private static WebElement shareIcon;

    @FindBy(xpath = "//div[@class='new__socialIcons']/div[2]/div/div[1]/div[2]/a")
    private static List<WebElement> listOfSharingOption;

    public SocialSharingPage(){
        globalVars =GlobalVars.getInstance();
        driver =(IOSDriver)globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions =CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************"+globalVars.getProjectName()+"******************");
    }

    public boolean backToHomePage() {
        boolean isBackToHomePageSuccessful = false;
        try {
            isBackToHomePageSuccessful = commonFunctions.scrollToElementViewAndClick(HomeOption, 20, "HomeOption");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty() && currentURL.contains(Utils.getUrl())) {
                isBackToHomePageSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isBackToHomePageSuccessful;
    }

    public boolean checkSharingStoryOnTwitter() {
        boolean isSharingStoryTwitterSuccessful = false;
        try {
            commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStoryTwitterSuccessful = commonFunctions.clickElementIfDisplayed(twitterSharingAllOptions, 20,
                    "twitterSharingAllOptions");
            commonFunctions.waitForWindow(3, "new window");
            ArrayList<String> windowsList = new ArrayList<>(
                    commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(3));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty() && currentURL.contains("twitter.com")) {
                isSharingStoryTwitterSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStoryTwitterSuccessful;
    }

    public boolean checkSharingStoryOnFacebook() {
        boolean isSharingStoryFacebookSuccessful = false;
        try {
            commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStoryFacebookSuccessful = commonFunctions.clickElementIfDisplayed(facebookSharingAllOptions, 20,
                    "facebookSharingAllOptions");
            commonFunctions.waitForWindow(2, "new window");
            ArrayList<String> windowsList = new ArrayList<>(
                    commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty() && currentURL.contains("facebook.com")) {
                isSharingStoryFacebookSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStoryFacebookSuccessful;
    }

    public boolean checkSharingStoryOnLinkedin() {
        boolean isSharingStoryLinkedinSuccessful = false;
        try {
            commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStoryLinkedinSuccessful = commonFunctions.clickElementIfDisplayed(linkedinSharingAllOptions, 20,
                    "linkedinSharingAllOptions");
            commonFunctions.waitForWindow(2, "new window");
            ArrayList<String> windowsList = new ArrayList<>(
                    commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty() && currentURL.contains("linkedin.com")) {
                isSharingStoryLinkedinSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStoryLinkedinSuccessful;
    }

    public boolean checkSharingInlineStoryOnTwitter() {
        boolean isSharingInlineStoryTwSuccessful = false;
        try {
            isSharingInlineStoryTwSuccessful = commonFunctions
                    .scrollToElementViewAndClick(twitterShareOptionInlineStory, 20, "twitterShareOptionInlineStory");
            commonFunctions.waitForWindow(2, "new window");
            ArrayList<String> windowsList = new ArrayList<>(
                    commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty() && currentURL.contains("twitter.com")) {
                isSharingInlineStoryTwSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingInlineStoryTwSuccessful;
    }

    public boolean checkSharingInlineStoryOnFacebook() {
        boolean isSharingInlineStoryFbSuccessful = false;
        try {
            isSharingInlineStoryFbSuccessful = commonFunctions
                    .scrollToElementViewAndClick(facebookShareOptionInlineStory, 20, "facebookShareOptionInlineStory");
            commonFunctions.waitForWindow(2, "new window");
            ArrayList<String> windowsList = new ArrayList<>(
                    commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty() && currentURL.contains("facebook.com")) {
                isSharingInlineStoryFbSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingInlineStoryFbSuccessful;
    }


    @Override
    public boolean checkSocialSharingFunctionality() {
        boolean firstStory = commonFunctionsMobile.clickOnFirstStory(firstStoryTitle);
        boolean backToHomePage = backToHomePage();
        boolean copyUrl = commonFunctionsMobile.clickOnCopyIconAndCheckUrlCopied(shareIcon,copyUrlToShareAllOptions);
        boolean sharingTwitter = checkSharingStoryOnTwitter();
        boolean sharingFacebook = checkSharingStoryOnFacebook();
        boolean sharingLinkedin = checkSharingStoryOnLinkedin();
        boolean firstStory1 = commonFunctionsMobile.clickOnFirstStory(firstStoryTitle);
        boolean inLineStoryTwitter = checkSharingInlineStoryOnTwitter();
        boolean inLineStoryFacebook = checkSharingInlineStoryOnFacebook();

        return firstStory && backToHomePage && copyUrl && sharingTwitter && sharingFacebook && sharingLinkedin
                && firstStory1 && inLineStoryTwitter && inLineStoryFacebook;
    }

    @Override
    public boolean checkSocialSharingWithWhatsappAndGmail() {
        return false;
    }

    @Override
    public boolean socialSharingInStoryPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkSocialSharingIconsClickable() {
        return commonFunctionsMobile.checkSocialSharingIconsClickableMWeb(explore, indiaNews, firstStoryTitle, shareIcon, listOfSharingOption, copyUrlToShareAllOptions);
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageBySearch() {
        return false;
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics() {
        return false;
    }
}
