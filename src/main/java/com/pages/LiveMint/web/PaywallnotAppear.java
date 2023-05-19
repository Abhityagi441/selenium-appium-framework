package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonPaywallnotAppear;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaywallnotAppear extends CommonPaywallnotAppear {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static ApiValidation apiValidation;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsLM;

    @FindBy(xpath = "//img[@title='mint']")
    private static WebElement mintTitle;
    @FindBy(xpath = "(//div[contains(@class, 'listtostory')])[1]")
    private static WebElement pageContent;
    @FindBy(xpath="//a[@id='exclusive']")
    private static WebElement premiumPage;
    @FindBy(xpath = "(//img[contains(@class,'lozad')])[1]")
    private static WebElement imageOtherPagesfirstStory;

    @FindBy(xpath = "(//span[contains(@class,'exclusive')])[1]")
    private static WebElement premiumText;

    public PaywallnotAppear()
    {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(driver, this);
        commonFunctions =CommonFunctionsWeb.getInstance();
        commonFunctionsLM= CommonFunctionsWebLM.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    public boolean CheckPaywallnotAppearSubscribedUser(String apiURL)
    {
        boolean SubscribedUserPaywallStatus = false;
        commonFunctions.clickElement(mintTitle, 10, "Mint Title");
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(pageContent, 10, "Premium Page");
        commonFunctions.clickElement(premiumPage, 10, "Premium");
        commonFunctions.waitForURLToBe(Utils.getUrl() + "premium");
        boolean checkPremiumPageStatus = commonFunctions.checkPageURL(Utils.getUrl() + "premium", 10, "Premium Landing Page");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementWithJS(imageOtherPagesfirstStory, 10, "First Title in Premium Page");
        commonFunctions.waitForURLContains(".html");
        boolean checkPremiumLabel = commonFunctions.checkElementText(premiumText, "PREMIUM", 10, "Premium Label");
        boolean premiumStoryStatus = checkDataUsingStoryAPI("verifyNonSubscribedUserPaywall", "true", "Premium Story in API", "content[0].metadata.premiumStory", apiURL);
        //commonFunctions.scrollToElement(scrollBeforePayWall, "Scroll Subscribe ");
       // boolean payWallPresentStatus = commonFunctions.isElementDisplayed(subscriptionPaywall, 10, "Subscription paywall is displayed for this user ");
        commonFunctions.dummyWait(10);
        return SubscribedUserPaywallStatus;
    }

    public boolean checkDataUsingStoryAPI(String methodName, String expectedValue, String elementName, String jsonPath, String apiURL) {
        boolean checkDataUsingStoryAPIStatus;
        String storyId = commonFunctions.getStoryIdFromURL();
        Response response = RestUtils.sendGetRequest(apiURL, storyId);
        String actualValueFromAPI = RestUtils.getValueFromResponse(response, jsonPath);
        actualValueFromAPI = Utils.formatAPIText(actualValueFromAPI);
        System.out.println(actualValueFromAPI);

        checkDataUsingStoryAPIStatus = commonFunctions.checkTextContains(expectedValue, actualValueFromAPI, elementName);
        return checkDataUsingStoryAPIStatus;
    }

    @Override
    public boolean PaywallnotAppear() {
        return false;
    }
}
