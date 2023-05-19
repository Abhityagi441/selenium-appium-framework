
package com.pages.HindustanTimes.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsWebHt;
import com.pages.HindustanTimes.generic.CommonStandardStoryPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StandardStoryPage extends CommonStandardStoryPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebHt commonFunctionsWeb;

    @FindBy(xpath = "//div[contains(@class,'cartHolder ')]//h3[@class='hdg3']/a")
    private static List<WebElement> allStory;
    @FindBy(xpath = "//a[contains(@data-id,'India')]")
    private static WebElement l1India;
    @FindBy(xpath = "//h1[@class='hdg1']")
    private static WebElement storyDetailPageHeadline;
    @FindBy(xpath = "//h1[text()='India News']")
    private static WebElement latestNewsOnDetailPage;
    @FindBy(xpath = "//div[@class='new__newsletter__signup']/following-sibling::div[@data-vars-widget-name='Taboola']")
    private static WebElement taboolaOnDetailPage;
    @FindBy(xpath = "(//div[@class='detail ']/p)[1]/following-sibling::div[contains(@class,'ad')]")
    private static List<WebElement> adAfterFirstParagraph;
    @FindBy(id = "followUs")
    private static List<WebElement> followUs;
    @FindBy(xpath = "//a[text()='MOST READ']")
    private static WebElement mostRead;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(xpath = "(//div[contains(@class,'fullStory')]//img)[1]")
    private static WebElement leadImage;


    public StandardStoryPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWeb = CommonFunctionsWebHt.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkSectionPageOnDetailPage(String indiaNewsUrl) {
        boolean isShowing = checkStoryDetailPage(indiaNewsUrl);
        commonFunctions.scrollUsingAction(adAfterFirstParagraph.get(0), "first ad");
        commonFunctions.dummyWait(2);
        commonFunctions.scrollUsingAction(mostRead, "most read");
        commonFunctions.scrollUsingAction(latestNewsOnDetailPage, "indian news");
        isShowing &= commonFunctions.isElementDisplayed(latestNewsOnDetailPage, 10, "India news on story detail page");
        return isShowing;
    }

    public boolean checkStoryDetailPage(String indiaNewsUrl) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(l1India, 20, "L1: India");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(l1India, 10, "L1: India");
        isShowing &= commonFunctions.checkCurrentPageUrlEqualToExpectedUrl(indiaNewsUrl, "India news page");
        commonFunctions.dummyWait(3);
        commonFunctions.scrollUsingAction(allStory.get(0),"first story");
        isShowing &= commonFunctions.isElementDisplayed(allStory.get(0), 10, "first Story");
        commonFunctions.clickElement(allStory.get(0), 10, "first Story");
        commonFunctions.dummyWait(2);
        commonFunctions.scrollUsingAction(storyDetailPageHeadline, "story headline");
        isShowing &= commonFunctions.isElementDisplayed(storyDetailPageHeadline, 10, "story detail page");
        return isShowing;
    }

    @Override
    public boolean checkTaboolaWidgets(String indiaNewsUrl) {
        boolean isShowing = checkStoryDetailPage(indiaNewsUrl);
        commonFunctions.dummyWait(2);
        commonFunctions.scrollUsingAction(adAfterFirstParagraph.get(0), "first ad");
        commonFunctions.dummyWait(2);
        commonFunctions.scrollUsingAction(mostRead, "most read");
        commonFunctions.scrollUsingAction(taboolaOnDetailPage, "taboola widget");
        isShowing &= commonFunctions.isElementDisplayed(taboolaOnDetailPage, 10, "taboola widget end of story");
        return isShowing;
    }

    @Override
    public boolean checkAdsAfterFirstParagraph(String indiaNewsUrl) {
        boolean isShowing = checkStoryDetailPage(indiaNewsUrl);
        commonFunctions.scrollUsingAction(adAfterFirstParagraph.get(0), "ads");
        isShowing &= commonFunctions.isElementDisplayed(adAfterFirstParagraph, 10, "ads after first paragraph");
        return isShowing;
    }

    @Override
    public boolean checkFollowUsRedirection(String indiaNewsUrl,String followUsUrl) {
        boolean isShowing = checkStoryDetailPage(indiaNewsUrl);
        commonFunctions.scrollUsingAction(followUs.get(0), "follow us");
        commonFunctions.dummyWait(1);
        commonFunctions.clickElement(followUs.get(0),10,"follow us");
        commonFunctions.switchToChildWindowsExceptMasterTab();
        isShowing &= commonFunctions.checkCurrentPageUrlEqualToExpectedUrl(followUsUrl, "Follow Us page");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        return isShowing;
    }

    @Override
    public boolean checkLeadImageOfStory(String indiaNewsUrl) {
        boolean isShowing = checkStoryDetailPage(indiaNewsUrl);
        commonFunctions.scrollUsingAction(leadImage, "lead image");
        isShowing &= commonFunctions.isElementDisplayed(leadImage, 10, "lead image of story");
        return isShowing;
    }

}

