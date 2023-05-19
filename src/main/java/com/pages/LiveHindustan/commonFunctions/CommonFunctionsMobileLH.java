package com.pages.LiveHindustan.commonFunctions;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.expression.spel.ast.Literal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CommonFunctionsMobileLH {
    private static AppiumDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobileLH commonFunctionsMobile;
    private static CommonFunctionsMobile commonFunctions;
    private static DriverController driverController;

    public static CommonFunctionsMobileLH getInstance() {
        if (commonFunctionsMobile == null) {
            commonFunctionsMobile = new CommonFunctionsMobileLH();
        }
        driver = globalVars.getAppiumDriver();
        driverController = DriverController.getInstance();
        return commonFunctionsMobile;
    }

    public CommonFunctionsMobileLH() {
        globalVars = GlobalVars.getInstance();
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    public boolean socialSharingOnSlideStory(List<WebElement> socialSharing) {
        boolean isSocialSharingclickable = false;
        boolean isRespectivePagesOpened = true;
        for (int i = socialSharing.size() - 1; i >= 0; i--) {
            commonFunctions.moveToElementWithActions(socialSharing.get(i), 10, "Social sharing options");
            String sharingOptionsType = commonFunctions.getAttributeValue(socialSharing.get(i), 10, "type");
            isSocialSharingclickable = commonFunctions.clickElementWithJS(socialSharing.get(i), 10, "Sharing Options");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            isRespectivePagesOpened &= commonFunctions.getCurrentURL().contains(sharingOptionsType);
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        return isSocialSharingclickable && isRespectivePagesOpened;
    }

    public boolean breadcrumbOnSlideStory(WebElement breadCrumbText, String entertainmentHindi, WebElement FirstStoryHeadingInBreadCrumb, WebElement stroyTitle) {
        boolean isTitleMatch;
        boolean isBreadCrumbContainsManoranjan;
        isBreadCrumbContainsManoranjan = commonFunctions.checkElementText(breadCrumbText, entertainmentHindi, 10, "entertainment");
        String storyTitleInBreadCrumb = commonFunctions.getElementText(FirstStoryHeadingInBreadCrumb, 10);
        String storyTitle = commonFunctions.getElementText(stroyTitle, 10);
        isTitleMatch = commonFunctions.compareTexts(storyTitleInBreadCrumb, storyTitle);

        return isBreadCrumbContainsManoranjan && isTitleMatch;
    }

    public boolean miltiJultiCarWidgetOnAutoStoryPage(WebElement autoPage, WebElement firstStory, WebElement miltiJultiSection, WebElement miltiJultiLink, String autoUrl) {
        boolean isMiltiJultiSectionDisplayed;
        boolean redirectedAutoUrl;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(autoPage, "auto page");
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(autoPage, 10, "auto page");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(firstStory, 10, "first story");
        commonFunctions.dummyWait(5);
        for(int k =0;k<5;k++) {
            commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
            commonFunctions.dummyWait(1);
        }
        commonFunctions.scrollToElementView(miltiJultiSection, 10, "milti-Julti Section");
        commonFunctions.dummyWait(2);
        isMiltiJultiSectionDisplayed = commonFunctions.isElementDisplayed(miltiJultiSection, 10, "milti-Julti Section");
        commonFunctions.scrollToElement(miltiJultiLink,  "on raod price link");
        commonFunctions.dummyWait(2);
        commonFunctions.scrollToElementView(miltiJultiSection, 10, "milti-Julti Section");
        commonFunctions.dummyWait(2);
        //commonFunctions.isElementDisplayed(miltiJultiLink, 10, "on raod price");
        commonFunctions.clickElement(miltiJultiLink, 10, "on raod price link");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        redirectedAutoUrl = commonFunctions.getCurrentURL().contains(autoUrl);
        commonFunctions.closeAllWindowsExceptMasterTab();

        return isMiltiJultiSectionDisplayed && redirectedAutoUrl;
    }

    public boolean subMenuOnAutoPage(WebElement autoPage, List<WebElement> subMenus, String columnName) {
        boolean isAutoPageClickable;
        boolean isLinkReturn200 = true;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.moveToElementWithActions(autoPage, 10, "auto page");
        isAutoPageClickable = commonFunctions.clickElement(autoPage, 10, "auto page");
        for (int i = startingPoint; i <= subMenus.size() - 1; i = i+increasingPoint) {
            commonFunctions.clickElementWithJS(subMenus.get(i), 10, "sub menus link " + subMenus.get(i).getText());
            commonFunctions.dummyWait(5);
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        }
        return isAutoPageClickable && isLinkReturn200;
    }

    public boolean allTabsAndHeadingOnAnyTopicPage(WebElement firstTopicOnHomePage, WebElement topicPageHeading, List<WebElement> tabsOnTopicPage) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        boolean isTabClickable = false;
        String topicTitle = firstTopicOnHomePage.getAttribute("title");
        topicTitle = topicTitle.replaceAll("#", "");
        commonFunctions.clickElementWithJS(firstTopicOnHomePage);
        commonFunctions.waitForPageToLoad();
        boolean isTopicTitleSame = commonFunctions.checkElementText(topicPageHeading, topicTitle, 5, "Topic page Title");
        for (int i = 0; i < 3; i++) {
            isTabClickable = commonFunctions.isElementClickable(tabsOnTopicPage.get(i), 5, tabsOnTopicPage.get(i).getText() + " Tab on topic Page");
            commonFunctions.clickElementWithJS(tabsOnTopicPage.get(i));
            commonFunctions.waitForPageToLoad();
            Utils.logStepInfo(true, "Clicked on the " + tabsOnTopicPage.get(i).getText() + " tab successfully");
        }
        return isTopicTitleSame && isTabClickable;
    }
    public boolean isAllElementsClickableAndNavigatedToCorrectURL(WebElement storySection,List<WebElement> menuOptions,int widgetStoriesSize, String columnName) {

        boolean isUrlMatches = true;
        boolean isLinkReturn200 = true;
        boolean isLinkClickable = true;
        boolean storiesSize = false;
        int widgetStoriesCount = 0;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        String cUrl = commonFunctions.getCurrentURL();
        commonFunctions.isElementDisplayed(storySection,10,storySection.getText() +" Widget");
        commonFunctions.scrollDownToElement(storySection);
        commonFunctions.moveToElementWithActions(storySection, 10, "story");
        commonFunctions.dummyWait(3);
        int allStoriesSize = menuOptions.size();
        if (widgetStoriesSize == allStoriesSize) {
            for (int i = startingPoint; i <= allStoriesSize-1; i = i+increasingPoint) {
                widgetStoriesCount++;
                commonFunctions.isElementDisplayed(storySection,10,storySection.getText() +" Widget");
                commonFunctions.scrollDownToElement(storySection);
                commonFunctions.moveToElementWithActions(storySection, 10, "story");
                commonFunctions.dummyWait(3);
                commonFunctions.moveToElementWithActions(menuOptions.get(i), 10, menuOptions.get(i).getText() + "link");
                commonFunctions.scrollToElementView(menuOptions.get(i), 10, "next element");
                commonFunctions.dummyWait(3);
                String linkTitle = commonFunctions.getElementText(menuOptions.get(i), 5);
                String urlContains = commonFunctions.getAttributeValue(menuOptions.get(i), 10, "href");
                commonFunctions.moveToElementWithActions(menuOptions.get(i), 10, linkTitle);
                commonFunctions.scrollToElementView(menuOptions.get(i), 10, "next element");
                isLinkClickable &= commonFunctions.clickElementWithJS(menuOptions.get(i), 10, linkTitle);
                commonFunctions.dummyWait(5);
                ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
                int windowSize = windowsList.size();
                if (windowSize > 1) {
                    commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
                    Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                    isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                    isUrlMatches &= commonFunctions.getCurrentURL().contains(urlContains);
                    commonFunctions.closeAllWindowsExceptMasterTab();
                    commonFunctions.dummyWait(5);
                } else {
                    Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                    isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                    if (linkTitle.equalsIgnoreCase("जरूर पढ़ें"))
                        isUrlMatches &= commonFunctions.getCurrentURL().contains("national");
                    else
                        isUrlMatches &= commonFunctions.getCurrentURL().contains(urlContains);
                    commonFunctions.navigateToURL(cUrl);
                    commonFunctions.waitForPageToLoad();
                    commonFunctions.dummyWait(5);
                }
            }
            if (allStoriesSize == widgetStoriesSize)
                storiesSize = true;
        } else {
            Utils.logStepInfo(false, "Mismatch in expected and actual widget story size");
        }
        return isLinkClickable && isLinkReturn200 && isUrlMatches && storiesSize;
    }

    public boolean isAllElementsClickableAndNavigatedToCorrectUrlForIos(WebElement storySection,List<WebElement> menuOptions,int widgetStoriesSize, String columnName) {

        boolean isUrlMatches = true;
        boolean isLinkReturn200 = true;
        boolean isLinkClickable = true;
        boolean storiesSize = false;
        int widgetStoriesCount = 0;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        String cUrl = commonFunctions.getCurrentURL();
        commonFunctions.isElementDisplayed(storySection,10,storySection.getText() +" Widget");
        commonFunctions.scrollDownToElement(storySection);
        commonFunctions.moveToElementWithActions(storySection, 10, "story");
        commonFunctions.dummyWait(3);
        int allStoriesSize = menuOptions.size();
        if (widgetStoriesSize == allStoriesSize) {
            for (int i = startingPoint; i <= allStoriesSize-1; i = i+increasingPoint) {
                widgetStoriesCount++;
                int k = 0;
                if(i!=0){
                    k = 1;
                }
                commonFunctions.isElementDisplayed(storySection,10,storySection.getText() +" Widget");
                commonFunctions.scrollDownToElement(storySection);
                commonFunctions.moveToElementWithActions(storySection, 10, "story");
                commonFunctions.dummyWait(5);
                commonFunctions.moveToElementWithActions(menuOptions.get(i-k), 10, menuOptions.get(i).getText() + "link");
                commonFunctions.scrollToElementView(menuOptions.get(i-k), 10, "next element");
                commonFunctions.dummyWait(3);
                String linkTitle = commonFunctions.getElementText(menuOptions.get(i), 5);
                String urlContains = commonFunctions.getAttributeValue(menuOptions.get(i), 10, "href");
                commonFunctions.moveToElementWithActions(menuOptions.get(i-k), 10, linkTitle);
                commonFunctions.scrollToElementView(menuOptions.get(i-k), 10, "next element");
                isLinkClickable &= commonFunctions.clickElement(menuOptions.get(i), 10, linkTitle);
                commonFunctions.dummyWait(15);
                ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
                int windowSize = windowsList.size();
                if (windowSize > 1) {
                    commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
                    Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                    isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                    isUrlMatches &= commonFunctions.getCurrentURL().contains(urlContains);
                    //commonFunctions.closeAllWindowsExceptMasterTab();
                    driver.close();
                    commonFunctions.switchToDefaultContent();
                    commonFunctions.dummyWait(5);
                    commonFunctions.navigateToURL(cUrl);
                    commonFunctions.waitForPageToLoad();
                    commonFunctions.dummyWait(5);
                } else {
                    Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                    isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                    if (linkTitle.equalsIgnoreCase("जरूर पढ़ें"))
                        isUrlMatches &= commonFunctions.getCurrentURL().contains("national");
                    else
                        isUrlMatches &= commonFunctions.getCurrentURL().contains(urlContains);
                    commonFunctions.navigateToURL(cUrl);
                    commonFunctions.waitForPageToLoad();
                    commonFunctions.dummyWait(5);
                }
            }
            if (allStoriesSize == widgetStoriesSize)
                storiesSize = true;
        } else {
            Utils.logStepInfo(false, "Mismatch in expected and actual widget story size");
        }
        return isLinkClickable && isLinkReturn200 && isUrlMatches && storiesSize;
    }

    public boolean pramukhKhabreWidget(List<WebElement> allPramukhStoriesLink, WebElement sponsoredLink, String env) {
        boolean isAllElementClickableTrue;
        int pramukhStoriesSize = 0;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(2);
        if (env.equalsIgnoreCase("AMP")) {
            pramukhStoriesSize = allPramukhStoriesLink.size();
        } else {
            commonFunctions.scrollToViewElement(sponsoredLink, "sponsored link", 10);
            if (commonFunctions.isElementDisplayed(sponsoredLink, 10, "sponsored link")) {
                pramukhStoriesSize = allPramukhStoriesLink.size();
            }
        }
        isAllElementClickableTrue = isAllElementClickableAndReturns200(allPramukhStoriesLink, "WidgitValuesForRandomNumber");

        boolean pramukhStoriesSizeStatus = pramukhStoriesSize == 10 || pramukhStoriesSize == 9;

        return pramukhStoriesSizeStatus && isAllElementClickableTrue;
    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> allStoriesLink, String columnName) {
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        for (int i = startingPoint; i <= allStoriesLink.size() - 1; i = i+increasingPoint) {
            String storyTitle = allStoriesLink.get(i).getText();
            commonFunctions.moveToElementWithActions(allStoriesLink.get(i), 10, storyTitle);
            isUrlClickable &= commonFunctions.clickElementWithJS(allStoriesLink.get(i), 10, storyTitle);
            commonFunctions.dummyWait(5);
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.dummyWait(5);
        }
        return isUrlClickable && isLinkReturn200;
    }

    public boolean checkTheListViewAndPagesNumberAtFooterOnTagPage(WebElement firstPramukhStory, WebElement firstTag, WebElement tagPageHeading, List<WebElement> listOnTagsPage, List<WebElement> pagesNumberAtTagPage) {
        boolean isListPresentOnTagsPage = true;
        boolean isPagesNumberAtTagPagePresent = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.clickElementWithJS(firstPramukhStory, 10, "First pramukh khabar on Home page");
        commonFunctions.dummyWait(5);
        String tagText = firstTag.getText();
        commonFunctions.moveToElementWithActions(firstTag, 10, firstTag.getText());
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(firstTag);
        commonFunctions.closeAllWindowsExceptMasterTab();
        if (!tagPageHeading.isDisplayed()) {
            commonFunctions.refreshPage();
            commonFunctions.clickElementWithJS(firstTag);
        }
        commonFunctions.waitForPageToLoad();
        boolean isTagTextSame = commonFunctions.checkTextContains(tagText, commonFunctions.getElementText(tagPageHeading), tagPageHeading.getText());
        if (listOnTagsPage.size() == 10) {
            for (int i = 0; i < listOnTagsPage.size(); i++)
                isListPresentOnTagsPage &= commonFunctions.isElementDisplayedAndPresent(listOnTagsPage.get(i), 10, listOnTagsPage.get(i).getText());
        } else isListPresentOnTagsPage = false;
        if (pagesNumberAtTagPage.size() == 4) {
            for (int i = 0; i < pagesNumberAtTagPage.size(); i++)
                isPagesNumberAtTagPagePresent &= commonFunctions.isElementDisplayedAndPresent(pagesNumberAtTagPage.get(i), 10, pagesNumberAtTagPage.get(i).getText());
        } else isPagesNumberAtTagPagePresent = false;
        return isTagTextSame && isListPresentOnTagsPage && isPagesNumberAtTagPagePresent;
    }

    public boolean aglaLekhDisappearsInWebStoryPagesWhenScrolledDownFromAglaLekhHeading(WebElement shareThruSocialMedia, WebElement aglelekhpadeText) {
        commonFunctions.scrollToElementView(shareThruSocialMedia, 10, "share thru social media section");
        boolean agleLekhPadeFooterSectionNotDisplayed = commonFunctions.isElementNotDisplayed(aglelekhpadeText, 10, "अगला लेख पढ़ें alert");

        return agleLekhPadeFooterSectionNotDisplayed;
    }

    public boolean isReadNextArticleVisible(WebElement homePageStory, WebElement agleLekhSection, WebElement recommendedSection, WebElement aglelekhpadeText) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(homePageStory, 10, "First story");
        commonFunctions.dummyWait(5);
        for(int k =0;k<5;k++) {
            commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
            commonFunctions.dummyWait(1);
        }
        commonFunctions.scrollToElementView(agleLekhSection, 10, "अगला लेख section");
        commonFunctions.moveToElementWithActions(recommendedSection, 10, "Recommended section");

        return commonFunctions.isElementDisplayed(aglelekhpadeText, 10, "अगला लेख पढ़ें alert");
    }

    public boolean checkEntertainmentLandingPage(List<WebElement> entertainmentNews) {
        boolean getStatusCode200 = true;
        boolean isUrlClickable = true;
        boolean isAllLandingPageAreRelated = true;
        if (entertainmentNews.size() == 6) {
            for (int i = 0; i < entertainmentNews.size(); i++) {
                commonFunctions.moveToElementWithActions(entertainmentNews.get(i), 5, "Entertainment News links");
                String expectedUrl = commonFunctions.getAttributeValue(entertainmentNews.get(i), 5, "href");
                isUrlClickable &= commonFunctions.clickElementWithJS(entertainmentNews.get(i), 5, "Entertainment News Link " + i);
                commonFunctions.dummyWait(5);
                getStatusCode200 &= commonFunctions.getResponseCode(expectedUrl) == 200;
                isAllLandingPageAreRelated &= commonFunctions.getCurrentURL().contains(expectedUrl);
                driver.navigate().back();
                commonFunctions.waitForPageToLoad();
                commonFunctions.dummyWait(2);
            }
        } else {
            getStatusCode200 = false;
            isUrlClickable = false;
            isAllLandingPageAreRelated = false;
        }

        return isUrlClickable && getStatusCode200 && isAllLandingPageAreRelated;
    }

    public boolean checkEntertainmentLandingPageOnAMP(WebElement ampEntertainmentMenu, List<WebElement> entertainmentStories) {
        boolean getStatusCode200 = true;
        boolean isUrlClickable = true;
        boolean isAllLandingPageAreRelated = true;
        boolean storiesClickableStatus = false;
        commonFunctions.scrollToElement(ampEntertainmentMenu, 5, "Entertainment Menu");
        commonFunctions.dummyWait(1);
        commonFunctions.clickElementWithJS(ampEntertainmentMenu, 5, "Entertainment Menu");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(1);
        boolean storiesSizeCount = entertainmentStories.size() > 0;
        if (storiesSizeCount) {
            for (int i = 0; i < 10; i++) {
                commonFunctions.moveToElementWithActions(entertainmentStories.get(i), 5, "Link " + i + " on Entertainment Page");
                String url = commonFunctions.getAttributeValue(entertainmentStories.get(i), 5, "href");
                isUrlClickable &= commonFunctions.clickElementWithJS(entertainmentStories.get(i), 5, url);
                commonFunctions.dummyWait(5);
                getStatusCode200 &= commonFunctions.getResponseCode(url) == 200;
                isAllLandingPageAreRelated &= commonFunctions.getCurrentURL().contains(url);
                driver.navigate().back();
                commonFunctions.waitForPageToLoad();
                commonFunctions.dummyWait(2);
            }
            commonFunctions.dummyWait(1);
            storiesClickableStatus = commonFunctions.isAllElementClickable(entertainmentStories);
        } else {
            getStatusCode200 = false;
            isUrlClickable = false;
            isAllLandingPageAreRelated = false;
        }
        return storiesClickableStatus && isAllLandingPageAreRelated && getStatusCode200 && isUrlClickable;
    }

    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElement(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public boolean checkRashiFalLinksForMweb(List<WebElement> topMenuOptions, String entertainmentHindi, WebElement rashifalWidgetHeading, List<WebElement> rashifalWidgetLinks, WebElement firstRashiPuraPadheyLink, WebElement rashifalLink) {
        boolean isAllRashifalLinksPresent = true;
        clickElementWithGivenTextWithJS(topMenuOptions, entertainmentHindi);
        commonFunctions.dummyWait(5);
        commonFunctions.waitForPageToLoad();
        for(int k =0;k<4;k++) {
            commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
            commonFunctions.dummyWait(1);
        }
        commonFunctions.moveToElementWithActions(rashifalWidgetHeading, 10, rashifalWidgetHeading.getText());
        commonFunctions.dummyWait(2);
        boolean isRashifalWidgetPresent = commonFunctions.isElementDisplayedAndPresent(rashifalWidgetHeading, 10, rashifalWidgetHeading.getText());
        if (rashifalWidgetLinks.size() == 12) {
            for (int i = 0; i < rashifalWidgetLinks.size(); i++)
                isAllRashifalLinksPresent &= commonFunctions.isElementDisplayed(rashifalWidgetLinks.get(i), 10, rashifalWidgetLinks.get(i).getText().trim());
        } else {
            isAllRashifalLinksPresent = false;
        }
        String expectedURL = commonFunctions.getAttributeValue(rashifalWidgetLinks.get(0), 5, "href");

        commonFunctions.moveToElementWithActions(firstRashiPuraPadheyLink, 5, firstRashiPuraPadheyLink.getText());
        commonFunctions.clickElementWithJS(firstRashiPuraPadheyLink);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(3);
        boolean isURLCorrect = commonFunctions.getCurrentURL().contains(expectedURL);
        boolean isRashiFalActive = commonFunctions.compareTexts(rashifalLink.getAttribute("class"), "active");
        return isRashifalWidgetPresent && isAllRashifalLinksPresent && isURLCorrect && isRashiFalActive;
    }

    public boolean checRashiFalPageOnMweb(WebElement breadcrumbLastWord, List<WebElement> puraPadheyLinks) {
        boolean isUrlChangesTrue = commonFunctions.getCurrentURL().contains("astrology/rashifal/");
        boolean isLandingOnToRashiFalPageTrue = commonFunctions.getElementText(breadcrumbLastWord, 15).trim().contains("राशिफल");
        String urlBeforeClickOnPuraPadheyLink = commonFunctions.getCurrentURL();
        commonFunctions.moveToElementWithActions(puraPadheyLinks.get(0), 10, "First " + puraPadheyLinks.get(0).getText());
        commonFunctions.clickElementWithJS(puraPadheyLinks.get(0), 10, "First " + puraPadheyLinks.get(0).getText());
        commonFunctions.dummyWait(5);
        boolean isUrlChangedAfterClickOnPuraPadheyLink = !commonFunctions.getCurrentURL().equalsIgnoreCase(urlBeforeClickOnPuraPadheyLink);
        return isUrlChangesTrue && isLandingOnToRashiFalPageTrue && isUrlChangedAfterClickOnPuraPadheyLink;
    }

    public boolean hindustanPahalLinkWidgetRedirectionAndStatusCodeIs200(WebElement hindustanPahal, WebElement hindustanPahalUrl, WebElement hindustanPahalLink) {
        boolean isHindustanSectionDisplayed;
        boolean isHindustanSectionClickable;
        boolean isURLMatched;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(hindustanPahal, "hindustan section");
        String url = commonFunctions.getAttributeValue(hindustanPahalUrl, 10, "href");
        isHindustanSectionDisplayed = commonFunctions.isElementDisplayed(hindustanPahal, 10, "hindustan section");
        isHindustanSectionClickable = commonFunctions.clickElement(hindustanPahalLink, 10, "hindustan link");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isURLMatched = commonFunctions.getCurrentURL().equals(url);
        System.out.println(commonFunctions.getCurrentURL());
        return isHindustanSectionDisplayed && isHindustanSectionClickable && isURLMatched;
    }

    public boolean isAllElementsClickableAndNavigatedToCorrectURL(List<WebElement> allStories,int elementSize, String navigateUrl, String columnName) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);

        System.out.println("startingPoint:- "+startingPoint);
        System.out.println("increasingPoint:- "+increasingPoint);

        for (int i = startingPoint; i < elementSize; i = i+increasingPoint) {
            commonFunctions.scrollToElement(allStories.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
            String menuTitle = allStories.get(i).getText().trim();

            isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, menuTitle);
            if(isUrlClickable == false){
                System.out.println(menuTitle+" is not clickable");
                Utils.logStepInfo(false, menuTitle+" is not clickable");
                break;
            }
            commonFunctions.dummyWait(5);
            System.out.println("url " +commonFunctions.getCurrentURL());
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(menuTitle+" Status code is not 200");
                Utils.logStepInfo(false, menuTitle+" Status code is not 200");
                break;
            }

            if(menuTitle.equalsIgnoreCase("गौरीगंज")){
                isUrlMatches &= commonFunctions.getCurrentURL().contains("amethi");
            }else if(menuTitle.equalsIgnoreCase("ट्रांस हिंडन")){
                isUrlMatches &= commonFunctions.getCurrentURL().contains("ghaziabad");
            } else {
                isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
            }
            if(isUrlMatches == false){
                System.out.println(menuTitle+" href is not matching with current url");
                Utils.logStepInfo(false, menuTitle+" href is not matching with current url");
                break;
            }
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }

        return isUrlMatches && isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementsClickableAndGiving200Status(List<WebElement> allStories,int elementSize, String navigateUrl, WebElement brdCrumredFirst, WebElement brdCrumredSec, WebElement brdCrumredThird) {
        boolean isMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;

        for (int i = 0; i < elementSize; i++) {
            commonFunctions.scrollToElement(allStories.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String menuTitle = allStories.get(i).getText().trim();

            isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, menuTitle);
            if(isUrlClickable == false){
                System.out.println(menuTitle+" is not clickable");
                Utils.logStepInfo(false, menuTitle+" is not clickable");
                break;
            }
            commonFunctions.dummyWait(5);

            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(menuTitle+" Status code is not 200");
                Utils.logStepInfo(false, menuTitle+" Status code is not 200");
                break;
            }

            if(i==0){
                System.out.println("brdCrumredFirst:- "+brdCrumredFirst.getText());
                isMatches &= brdCrumredFirst.getText().trim().contains("Hindi News");
            }else if(i==1){
                System.out.println("brdCrumredSec:- "+brdCrumredSec.getText());
                isMatches &= brdCrumredSec.getText().trim().contains(menuTitle.trim());
            }else if(i==2){
                System.out.println("brdCrumredThird:- "+brdCrumredThird.getText());
                isMatches &= brdCrumredThird.getText().trim().contains(menuTitle.trim());
            }

            if(isMatches == false){
                System.out.println(menuTitle+" BrdCurm is not redirecting to respected page");
                Utils.logStepInfo(false, menuTitle+" BrdCurm is not redirecting to respected page");
                break;
            }
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }

        return isMatches && isUrlClickable && isLinkReturn200;
    }

    public boolean checkRelatedNewsWidgetOnStoryDetailOnMweb(WebElement firstPramukhStory, WebElement firstSambandhitKhabreWidget, List<WebElement> listOfSambahanditKhabre) {
        commonFunctions.clickElementWithJS(firstPramukhStory, 10, commonFunctions.getElementText(firstPramukhStory, 5));
        commonFunctions.dummyWait(5);
        for(int k =0;k<5;k++) {
            commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
            commonFunctions.dummyWait(1);
        }
        commonFunctions.moveToElementWithActions(firstSambandhitKhabreWidget, 10, "संबंधित खबरें Widget");
        commonFunctions.dummyWait(2);
        String actualText = firstSambandhitKhabreWidget.getText().trim();
        boolean isSambhanditKhabreWidgetPresent = commonFunctions.checkTextContains(actualText, "संबंधित खबरें", firstSambandhitKhabreWidget.getText());
        boolean isSambhanditKhabreHave4Stories = listOfSambahanditKhabre.size() == 4;
        boolean isSambhanditKhabrePresent = commonFunctions.isElementDisplayed(firstSambandhitKhabreWidget, 10, commonFunctions.getElementText(firstSambandhitKhabreWidget, 5));
        return isSambhanditKhabreWidgetPresent && isSambhanditKhabreHave4Stories && isSambhanditKhabrePresent;
    }

    public boolean checkListViewInSambahanditKhabreWidgetInStoryPagesOnMweb(WebElement firstPramukhStory, WebElement sambahanditKhabre, List<WebElement> listOfSambahanditKhabre) {
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on Home page");
        commonFunctions.dummyWait(2);
        commonFunctions.waitForPageToLoad();
        commonFunctions.moveToElementWithActions(sambahanditKhabre,10,sambahanditKhabre.getText());
        commonFunctions.dummyWait(2);
        commonFunctions.isElementPresent(sambahanditKhabre, 10, sambahanditKhabre.getText());
        Utils.logStepInfo("Sambahandit Khabre Widget is present");
        //commonFunctions.moveToElementWithActions(sambahanditKhabre, 10, "ListInsambahanditKhabre");
        boolean sambahanditKhabreInListView = listOfSambahanditKhabre.size()==4;
        return sambahanditKhabreInListView;
    }

    public boolean checkStoryTagsOnAMP(List<WebElement> tagsList,WebElement firstPramukhStory)
    {
        boolean isURLCorrect = true;
        boolean isRedirectionCorrect = true;
        int tagSize = tagsList.size();
        for(int i=0;i<tagSize;i++){
            int j= i+1;
            clickFirstPramukhStory(firstPramukhStory);
            commonFunctions.dummyWait(2);
            commonFunctions.scrollToElement(tagsList.get(i), 10, "Tag List:- "+j);
            commonFunctions.dummyWait(2);
            String expectedUrl = commonFunctions.getAtribute(tagsList.get(i),"href");
            commonFunctions.clickElementWithJS(tagsList.get(i), 10, "Tag List:- "+j);
            commonFunctions.dummyWait(5);
            commonFunctions.waitForPageToLoad();
            String currentUrl = commonFunctions.getCurrentURL();
            isRedirectionCorrect = commonFunctions.compareTexts(expectedUrl,currentUrl);
            isURLCorrect &= currentUrl.contains("/tags/");
            isURLCorrect &= currentUrl.contains("amp_");
        }
        return isURLCorrect && isRedirectionCorrect;
    }
    public void clickFirstPramukhStory(WebElement firstPramukhStory)
    {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(firstPramukhStory);
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on home page");
    }

    public boolean checkStoryTagsOnMweb(List<WebElement> tagNameOnCurrentPage)
    {
        boolean isFirstTagIsClickable = true;
        boolean isTagRedirectionCorrect = true;
        for(int i=0;i<tagNameOnCurrentPage.size();i++) {
            commonFunctions.scrollToElementView(tagNameOnCurrentPage.get(i), 10, "Tag Name");
            String expectedURL = tagNameOnCurrentPage.get(i).getAttribute("href");
            isFirstTagIsClickable &= commonFunctions.isElementClickable(tagNameOnCurrentPage.get(i), 10, commonFunctions.getElementText(tagNameOnCurrentPage.get(i)));
            commonFunctions.moveToElementToClick(tagNameOnCurrentPage.get(i));
            commonFunctions.waitForPageToLoad();
            isTagRedirectionCorrect &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            isTagRedirectionCorrect &= commonFunctions.getCurrentURL().contains(expectedURL);
            commonFunctions.dummyWait(2);
            commonFunctions.navigateBack(2);
            commonFunctions.dummyWait(2);
            commonFunctions.waitForPageToLoad();
        }
        return isFirstTagIsClickable && isTagRedirectionCorrect;
    }

    public void navigateToStatePage(WebElement stateMenu, WebElement stateWdgt){
        commonFunctions.navigateToURL(globalVars.getURL());
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("StateNavigateUrl");
        String stUrl = params.get("StateUrl");
        commonFunctions.navigateToURL(stUrl);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(stateWdgt, 10, "State Wdgt");
    }

    public void navigateToPhotoPage(WebElement photoMenu, WebElement photoWdgt, String env, String url){
        commonFunctions.navigateToURL(globalVars.getURL());
        if(env.equalsIgnoreCase("AMP")){
            commonFunctions.navigateToURL(url);
        }else {
            commonFunctions.waitForPageToLoad();
            commonFunctions.dummyWait(5);
            commonFunctions.scrollToElement(photoMenu, "Photo Menu");
            commonFunctions.clickElementWithJS(photoMenu, 10, "Photo Menu");
        }
        commonFunctions.isElementDisplayed(photoWdgt, 10, "Photo Wdgt");
    }

    public boolean isAllElementsClickableAndNavigatedToCorrectURLForAMP(List<WebElement> allStories,int elementSize, String navigateUrl, String columnName) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        for (int i = startingPoint; i < elementSize; i = i+increasingPoint) {
            commonFunctions.scrollToElement(allStories.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
            String[] str = url.split("/");
            url = str[str.length-1].trim();
            System.out.println("URL After Split:- "+url);
            String menuTitle = allStories.get(i).getText().trim();

            isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, menuTitle);
            if(isUrlClickable == false){
                System.out.println(menuTitle+" is not clickable");
                Utils.logStepInfo(false, menuTitle+" is not clickable");
                break;
            }
            commonFunctions.dummyWait(5);
            System.out.println("url " +commonFunctions.getCurrentURL());
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(menuTitle+" Status code is not 200");
                Utils.logStepInfo(false, menuTitle+" Status code is not 200");
                break;
            }

            if(menuTitle.equalsIgnoreCase("गौरीगंज")){
                isUrlMatches &= commonFunctions.getCurrentURL().contains("amethi");
            }else if(menuTitle.equalsIgnoreCase("ट्रांस हिंडन")){
                isUrlMatches &= commonFunctions.getCurrentURL().contains("ghaziabad");
            } else {
                isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
            }
            if(isUrlMatches == false){
                System.out.println(menuTitle+" href is not matching with current url");
                Utils.logStepInfo(false, menuTitle+" href is not matching with current url");
                break;
            }
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }

        return isUrlMatches && isUrlClickable && isLinkReturn200;
    }

    public boolean validateSocialSharingIconFunctionality(WebElement element, String matchingStr, String navigateUrl, String iconName){
        boolean socialFlag = false;
        boolean isLinkReturn200 = false;
        ArrayList<String> windowsList = null;
        try{
            commonFunctions.waitForPageToLoad();
            commonFunctions.moveToElementWithActions(element,10,"sharing");
            commonFunctions.scrollToElement(element, iconName);
            commonFunctions.dummyWait(5);
            commonFunctions.clickElementWithJS(element, 10, iconName);
            commonFunctions.dummyWait(5);
            windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            socialFlag = commonFunctions.getCurrentURL().contains(matchingStr);
            if(socialFlag == false){
                System.out.println(iconName+" Icon is not redirecting proper page");
                Utils.logStepInfo(false, iconName+" Icon is not redirecting proper page");
            }
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(iconName+" Status code is not 200");
                Utils.logStepInfo(false, iconName+" Status code is not 200");
            }
            commonFunctions.closeAllWindowsExceptMasterTab();
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(2);
        }catch(Exception e){
        }
        return socialFlag && isLinkReturn200;
    }

    public boolean sharingOptionForPhotoGallery(WebElement firstPhoto,WebElement currentPageFirstHeading,WebElement twitterIcon,WebElement facebookIcon,WebElement photoMainMenu){
        boolean isTwitterOpened = false;
        boolean isFacebookOpened = false;
        boolean isLandingPageOnPhotos=navigateToPhotoPage(photoMainMenu);
        String firstPhotoText=commonFunctions.getElementText(firstPhoto,10);
        commonFunctions.clickElementWithJS(firstPhoto,10,firstPhotoText);
        String firstPhotoHeading=commonFunctions.getElementText(currentPageFirstHeading,10);
        boolean isSamePhotoDisplayed=commonFunctions.compareTexts(firstPhotoText,firstPhotoHeading);
        commonFunctions.moveToElementWithActions(twitterIcon,10,"share section");
        commonFunctions.clickElementWithJS(twitterIcon);
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList1 = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList1.get(windowsList1.size() - 1));
        System.out.println(commonFunctions.getCurrentURL());
        isTwitterOpened = commonFunctions.getCurrentURL().contains("twitter");
        commonFunctions.closeAllWindowsExceptMasterTab();
        commonFunctions.clickElementWithJS(facebookIcon,10,"Facebook icon");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isFacebookOpened = commonFunctions.getCurrentURL().contains("facebook");

        return isLandingPageOnPhotos && isSamePhotoDisplayed && isTwitterOpened && isFacebookOpened;

    }

    public boolean navigateToPhotoPage(WebElement photoMainMenu){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(photoMainMenu,10,"photo main menu");
        commonFunctions.dummyWait(5);
        return commonFunctions.getCurrentURL().contains("/photos");
    }

    public boolean checkBreadcrumbAndSocialSharingIsPresentOnMweb(List<WebElement> photoPageMainTitles,WebElement firstStoryBreadCrumb,WebElement currentPageFirstHeading,WebElement twitterIcon,WebElement facebookIcon,List<WebElement>firstPhotoStoryRelatedImages,List<WebElement>adsOnAnyPage)
    {
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 20, firstMainPhotoTextOfThePage);
        String openedStoryPageBreadCrumb = commonFunctions.getElementText(firstStoryBreadCrumb, 10);
        boolean isGalleryBreadcrumbTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, openedStoryPageBreadCrumb);
        String currentPageStoryHeadline = commonFunctions.getElementText(currentPageFirstHeading, 10);
        boolean isCurrentPageHeadlineTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, currentPageStoryHeadline);
        boolean isTwitterIconDisplay = commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter icon");
        boolean isFacebookIconDisplay = commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook icon");
        commonFunctions.refreshPage();
        boolean isURLChangesWhileScrolling = isURLChangesWhileScrollingPhotos(firstPhotoStoryRelatedImages,adsOnAnyPage);
        return isLandingPageIsOfPhotos && isURLChangesWhileScrolling && isGalleryBreadcrumbTrue && isCurrentPageHeadlineTrue && isTwitterIconDisplay && isFacebookIconDisplay;
    }

    public boolean checkBreadcrumbAndSocialSharingIsPresentOnMwebForIos(List<WebElement> photoPageMainTitles,WebElement firstStoryBreadCrumb,WebElement currentPageFirstHeading,WebElement twitterIcon,WebElement facebookIcon,List<WebElement>firstPhotoStoryRelatedImages,List<WebElement>adsOnAnyPage)
    {
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 20, firstMainPhotoTextOfThePage);
        String openedStoryPageBreadCrumb = commonFunctions.getElementText(firstStoryBreadCrumb, 10);
        boolean isGalleryBreadcrumbTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, openedStoryPageBreadCrumb);
        String currentPageStoryHeadline = commonFunctions.getElementText(currentPageFirstHeading, 10);
        boolean isCurrentPageHeadlineTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, currentPageStoryHeadline);
        boolean isTwitterIconDisplay = commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter icon");
        boolean isFacebookIconDisplay = commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook icon");
        commonFunctions.refreshPage();
        boolean isURLChangesWhileScrolling = isURLChangesWhileScrollingPhotosForIos(firstPhotoStoryRelatedImages,adsOnAnyPage);
        return isLandingPageIsOfPhotos && isURLChangesWhileScrolling && isGalleryBreadcrumbTrue && isCurrentPageHeadlineTrue && isTwitterIconDisplay && isFacebookIconDisplay;
    }

    public boolean isURLChangesWhileScrollingPhotos(List<WebElement> firstPhotoStoryRelatedImages,List<WebElement> adsOnAnyPage) {
        boolean isURLChangesWhileScrollingPhotosTrue = true;
        String firstUrlText = commonFunctions.getCurrentURL();
        String nextUrlText;
        for (int i = 0; i < firstPhotoStoryRelatedImages.size(); i++) {
            if (i < firstPhotoStoryRelatedImages.size() - 1) {
                commonFunctions.dummyWait(2);
                commonFunctions.scrollToElementView(firstPhotoStoryRelatedImages.get(i + 1), 10, "Opened story pictures");
                commonFunctions.dummyWait(2);
                nextUrlText = commonFunctions.getCurrentURL();
                if (!commonFunctions.compareTexts(firstUrlText, nextUrlText)) {
                    isURLChangesWhileScrollingPhotosTrue &= true;
                } else if (isAnyElementFromListDisplayed(adsOnAnyPage, "Ads")) {
                    commonFunctions.scrollToElementView(firstPhotoStoryRelatedImages.get(i + 2), 10, "Opened story pictures");
                } else {
                    isURLChangesWhileScrollingPhotosTrue &= false;
                }
                firstUrlText = nextUrlText;
            } else
                break;
        }
        return isURLChangesWhileScrollingPhotosTrue;
    }

    public boolean isURLChangesWhileScrollingPhotosForIos(List<WebElement> firstPhotoStoryRelatedImages,List<WebElement> adsOnAnyPage) {
        boolean isURLChangesWhileScrollingPhotosTrue = true;
        String firstUrlText = commonFunctions.getCurrentURL();
        String nextUrlText;
        for (int i = 0; i < firstPhotoStoryRelatedImages.size(); i++) {
            if (i < firstPhotoStoryRelatedImages.size() - 1) {
                commonFunctions.dummyWait(2);
                commonFunctions.scrollToElementView(firstPhotoStoryRelatedImages.get(i + 1), 10, "Opened story pictures");
                commonFunctions.dummyWait(5);
                nextUrlText = commonFunctions.getCurrentURL();
                if (!commonFunctions.compareTexts(firstUrlText, nextUrlText)) {
                    isURLChangesWhileScrollingPhotosTrue &= true;
                } else if (isAnyElementFromListDisplayed(adsOnAnyPage, "Ads")) {
                    commonFunctions.scrollToElementView(firstPhotoStoryRelatedImages.get(i + 2), 10, "Opened story pictures");
                } else {
                    isURLChangesWhileScrollingPhotosTrue &= false;
                }
                firstUrlText = nextUrlText;
            } else
                break;
        }
        return isURLChangesWhileScrollingPhotosTrue;
    }

    public static boolean isAnyElementFromListDisplayed(List<WebElement> elementList, String text) {
        for (WebElement ele : elementList) {
            if (commonFunctions.isElementDisplayed(ele, 10, text + " related")) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBreadcrumbAndSocialSharingIsPresentInAMP(WebElement photoPageMainTitles,WebElement firstStoryBreadCrumb,WebElement currentPageFirstHeading,WebElement twitterIcon,WebElement facebookIcon,WebElement whatsappIcon,WebElement humeFollowKreIcon)
    {
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles, 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles, 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        String openedStoryPageBreadCrumb = commonFunctions.getElementText(firstStoryBreadCrumb, 10);
        boolean isGalleryBreadcrumbTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, openedStoryPageBreadCrumb);
        String currentPageStoryHeadline = commonFunctions.getElementText(currentPageFirstHeading, 10);
        boolean isCurrentPageHeadlineTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, currentPageStoryHeadline);
        commonFunctions.moveToElementWithActions(twitterIcon, 10, "Twitter icon");
        commonFunctions.dummyWait(2);
        boolean isTwitterIconDisplay = commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter icon");
        boolean isFacebookIconDisplay = commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook icon");
        boolean isWhatsappIconDisplay = commonFunctions.isElementDisplayed(whatsappIcon, 10, "Whatsapp icon");
        boolean isHumeFollowKreIconDisplay = commonFunctions.isElementDisplayed(humeFollowKreIcon, 10, "Hume Follow Kre icon");
        return isLandingPageIsOfPhotos && isGalleryBreadcrumbTrue && isCurrentPageHeadlineTrue && isTwitterIconDisplay && isFacebookIconDisplay && isWhatsappIconDisplay && isHumeFollowKreIconDisplay;
    }
    public boolean validatePlayAndPauseButton(WebElement ytplayerFrame, WebElement videoState, WebElement player, String attributeStr){
        boolean playerStatus=true;
        commonFunctions.dummyWait(5);
        commonFunctions.switchToFrame(ytplayerFrame, 10);
        commonFunctions.scrollToElement(videoState, "video");
        String videoStateValue = commonFunctions.getAtribute(videoState, attributeStr);
        if(videoStateValue.trim().equalsIgnoreCase("Play")){
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Pause");
            if(playerStatus == false){
                System.out.println("Play is not working");
                Utils.logStepInfo("Play is not working");
            }
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Play");
            if(playerStatus == false){
                System.out.println("Pause is not working");
                Utils.logStepInfo("Pause is not working");
            }
        }else if(videoStateValue.trim().equalsIgnoreCase("Pause")){
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Play");
            if(playerStatus == false){
                System.out.println("Pause is not working");
                Utils.logStepInfo("Pause is not working");
            }
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Pause");
            if(playerStatus == false){
                System.out.println("Play is not working");
                Utils.logStepInfo("Play is not working");
            }
        }

        commonFunctions.switchToDefaultContent();


        return playerStatus;
    }

    public boolean validateSocialSharingIconFunctionalityIos(WebElement element, String matchingStr, String navigateUrl, String iconName){
        boolean socialFlag = false;
        boolean isLinkReturn200 = false;
        try{
            commonFunctions.waitForPageToLoad();
            //commonFunctions.scrollToElement(element, iconName);
            //commonFunctions.dummyWait(5);
            commonFunctions.clickElement(element, 10, iconName);
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            socialFlag = commonFunctions.getCurrentURL().contains(matchingStr);
            if(socialFlag == false){
                System.out.println(iconName+" Icon is not redirecting proper page");
                Utils.logStepInfo(false, iconName+" Icon is not redirecting proper page");
            }
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(iconName+" Status code is not 200");
                Utils.logStepInfo(false, iconName+" Status code is not 200");
            }
            commonFunctions.closeAllWindowsExceptMasterTab();
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }catch(Exception e){
            commonFunctions.closeAllWindowsExceptMasterTab();
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }
        return socialFlag && isLinkReturn200;
    }

    public boolean isAllElementsClickableAndNavigatedToCorrectURLWithBrdCurm(List<WebElement> allStories,int elementSize, String navigateUrl, WebElement brdCurms, String columnName) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        boolean isBrdCurmPresent = true;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        for (int i = startingPoint; i < elementSize; i = i+increasingPoint) {
            commonFunctions.scrollToElement(allStories.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
            String menuTitle = allStories.get(i).getText().trim();

            isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, menuTitle);
            if(isUrlClickable == false){
                System.out.println(menuTitle+" is not clickable");
                Utils.logStepInfo(false, menuTitle+" is not clickable");
                break;
            }
            commonFunctions.dummyWait(5);
            System.out.println("url " +commonFunctions.getCurrentURL());
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(menuTitle+" Status code is not 200");
                Utils.logStepInfo(false, menuTitle+" Status code is not 200");
                break;
            }

            isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
            if(isUrlMatches == false){
                System.out.println(menuTitle+" href is not matching with current url");
                Utils.logStepInfo(false, menuTitle+" href is not matching with current url");
                break;
            }

            commonFunctions.scrollToElement(brdCurms, "breadcrumb");
            commonFunctions.dummyWait(2);
            isBrdCurmPresent &= commonFunctions.isElementDisplayed(brdCurms, 5, "breadcrumb");
            if(isBrdCurmPresent == false){
                System.out.println("Breadcrumb is present is not present on :-"+commonFunctions.getCurrentURL());
                Utils.logStepInfo("Breadcrumb is present is not present on :-"+commonFunctions.getCurrentURL());
                break;
            }

            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }

        return isUrlMatches && isUrlClickable && isLinkReturn200 && isBrdCurmPresent;
    }

    public boolean checkBreadcrumbAndSocialSharingOnPhotoGalleryOnMweb(List<WebElement> photoPageMainTitles,WebElement breadcrumbTitle,WebElement facebookIcon,WebElement twitterIcon,WebElement whatsappIcon,List<WebElement> breadCrumbFirstPhotoGallery,WebElement brdCrumRedFirst,WebElement brdCrumRedSecound,WebElement brdCrumRedThird)
    {
        boolean isTwitterWorkingFine = false, isFacebookWorkingFine = false, isWhatsappWorkingFine = false;
        commonFunctions.dummyWait(2);
        String firstStoryTitleOnPhotoLandingPage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.moveToElementWithActions(photoPageMainTitles.get(0),10, firstStoryTitleOnPhotoLandingPage);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 10, firstStoryTitleOnPhotoLandingPage);
        commonFunctions.dummyWait(2);
        String landingPageBreadcrumbTitle = commonFunctions.getElementText(breadcrumbTitle, 5);
        boolean isOpenedDetailPageRelated = commonFunctions.compareTexts(firstStoryTitleOnPhotoLandingPage.trim(), landingPageBreadcrumbTitle.trim());
        String photoDetailUrl = commonFunctions.getCurrentURL();
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBreadcrumbAndSocialSharingRedirectionOnPhotoGalleryDetailPage");
        if(commonFunctions.isElementDisplayed(facebookIcon,5,"FaceBook Icon"))
        {
            isFacebookWorkingFine = validateSocialSharingIconFunctionality(facebookIcon,params.get("Facebook"),photoDetailUrl,"FaceBook Icon");
        }
        if(commonFunctions.isElementDisplayed(twitterIcon,5,"Twitter Icon")) {
            isTwitterWorkingFine = validateSocialSharingIconFunctionality(twitterIcon, params.get("Twitter"), photoDetailUrl, "Twitter Icon");
        }

        //comented for whatsup because server side error is coming while clicking on whatsup icon

        /*if(commonFunctions.isElementDisplayed(twitterIcon,5,"Whatsapp Icon"))
        {
            isWhatsappWorkingFine = validateSocialSharingIconFunctionality(whatsappIcon, params.get("Whatsapp"), photoDetailUrl, "Whatsapp Icon");
        }*/
        boolean brdCrumStatus = isAllElementsClickableAndGiving200Status(breadCrumbFirstPhotoGallery,3,photoDetailUrl,brdCrumRedFirst,brdCrumRedSecound,brdCrumRedThird);
        return isOpenedDetailPageRelated && isTwitterWorkingFine && isFacebookWorkingFine /*&& isWhatsappWorkingFine*/ && brdCrumStatus;
    }

    public boolean checkClickingOnAnyRashiRedirectsToCorrectURLOnRashifalDetailPageOnMweb(List<WebElement> allSubOptionOnDharamPage, List<WebElement> rashiCountList,WebElement firstRashiReadMoreButton)
    {
        boolean isRashiCountTwelve;
        commonFunctions.dummyWait(5);
        commonFunctions.waitForPageToLoad();
        clickElementWithGivenTextWithJS(allSubOptionOnDharamPage, "राशिफल");
        commonFunctions.dummyWait(5);
        commonFunctions.moveToElementWithActions(rashiCountList.get(0),10,"First Rashi on Astrology Page");
        commonFunctions.dummyWait(2);
        int rashiCount = rashiCountList.size();
        if(rashiCount==12);
        {
            isRashiCountTwelve = true;
        }
        String expectedURL = commonFunctions.getAttributeValue(firstRashiReadMoreButton,2,"href");
        commonFunctions.moveToElementWithActions(firstRashiReadMoreButton,5,"First Rashi Read more button");
        commonFunctions.clickElementWithJS(firstRashiReadMoreButton,5,"First Rashi Read more button");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        boolean redirectionToRashiPage = commonFunctions.compareTexts(commonFunctions.getCurrentURL(),expectedURL);

        return isRashiCountTwelve && redirectionToRashiPage;
    }

    public boolean sharingOptionForPhotoGalleryIOS(WebElement firstPhoto,WebElement currentPageFirstHeading,WebElement twitterIcon,WebElement facebookIcon,WebElement photoMainMenu){
        boolean isTwitterOpened = false;
        boolean isFacebookOpened = false;
        boolean isLandingPageOnPhotos=navigateToPhotoPage(photoMainMenu);
        String firstPhotoText=commonFunctions.getElementText(firstPhoto,10);
        commonFunctions.clickElementWithJS(firstPhoto,10,firstPhotoText);
        String firstPhotoHeading=commonFunctions.getElementText(currentPageFirstHeading,10);
        boolean isSamePhotoDisplayed=commonFunctions.compareTexts(firstPhotoText,firstPhotoHeading);
        commonFunctions.scrollToElement(twitterIcon,"twitter");
        commonFunctions.dummyWait(2);
//        boolean b=commonFunctions.clickElementIfDisplayed(twitterIcon,10,"share section");
//        commonFunctions.swipeElementUsingTouchAction(214,560,214,310);

        //commonFunctions.dummyWait(5);
//        commonFunctions.clickByCoordinates(364,525);
        commonFunctions.moveToElementToClick(twitterIcon);
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList1 = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList1.get(windowsList1.size() - 1));
        System.out.println(commonFunctions.getCurrentURL());
        isTwitterOpened = commonFunctions.getCurrentURL().contains("twitter");
        System.out.println("twitter isRespectivePagesOpened" +isTwitterOpened);
        commonFunctions.closeAllWindowsExceptMasterTab();

        commonFunctions.clickElementWithJS(facebookIcon,10,"Facebook icon");
//        commonFunctions.clickByCoordinates(327,525);
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        isFacebookOpened = commonFunctions.getCurrentURL().contains("facebook");
        System.out.println(commonFunctions.getCurrentURL());
        System.out.println("facebook isRespectivePagesOpened" +isFacebookOpened);
        commonFunctions.closeAllWindowsExceptMasterTab();

        return isLandingPageOnPhotos && isSamePhotoDisplayed && isTwitterOpened && isFacebookOpened;

    }

    public boolean clickActiveAndInactiveElements(List<WebElement> allStories,int storySize, String columnName) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        boolean storiesSize = false;
        int widgetStoriesCount = 0;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        int widgetStoriesSize = allStories.size();
        if (widgetStoriesSize == storySize) {
            widgetStoriesCount++;
            for (int i = startingPoint; i <= allStories.size() - 1; i = i+increasingPoint) {
                commonFunctions.scrollToElement(allStories.get(i),"next story");
                commonFunctions.moveToElementWithActions(allStories.get(i), 10, "next element");
                String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
                commonFunctions.moveToElementWithActions(allStories.get(i), 10, "next element");
                isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, allStories.get(i).getText());
                commonFunctions.dummyWait(5);
                Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
                commonFunctions.navigateBack(2);
                commonFunctions.dummyWait(2);
            }
            if (widgetStoriesSize == storySize)
                storiesSize = true;
        } else {
            Utils.logStepInfo(false, "Mismatch in expected and actual widget story size");
        }
        return isUrlClickable && isLinkReturn200 && isUrlMatches && storiesSize;
    }

    public boolean allLinksClickable(WebElement storySection,List<WebElement> allStories,int storySize, String columnName) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        boolean storiesSize = false;
        int widgetStoriesCount = 0;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;

        randomList = generateRandomNumberAccordingToCondition(columnName);
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);


        commonFunctions.scrollDownToElement(storySection);
        commonFunctions.dummyWait(5);
        if (commonFunctions.isElementDisplayed(storySection, 10, storySection.getText() + " Widget")) {
            int widgetStoriesSize = allStories.size();
            if (widgetStoriesSize == storySize) {
                for (int i = startingPoint; i <= widgetStoriesSize - 1; i =i+increasingPoint) {
                    widgetStoriesCount++;
                    commonFunctions.scrollDownToElement(storySection);
                    String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
                    isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, allStories.get(i).getText());
                    commonFunctions.dummyWait(5);
                    Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                    isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                    isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
                    commonFunctions.navigateToURL(globalVars.getURL());
                    commonFunctions.dummyWait(5);
                }
                if (widgetStoriesSize == storySize)
                    storiesSize = true;
            } else {
                Utils.logStepInfo(false, "Mismatch in expected and actual widget story size");
            }
        } else {
            Utils.logStepInfo(false, "Story section " + storySection.getText() + " is not displayed");
        }
        return isUrlClickable && isLinkReturn200 && isUrlMatches && storiesSize;
    }

    public boolean photoInExpandViewAndriod(WebElement photoMainMenu,WebElement firstPhotoTitle,WebElement expandIcon,WebElement aanyaGalleryIcon){
        boolean isLandingPageOnPhotos=navigateToPhotoPage(photoMainMenu);
        String firstPhotoText=commonFunctions.getElementText(firstPhotoTitle,10);
        commonFunctions.clickElementWithJS(firstPhotoTitle,10,firstPhotoText);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstPhotoText);
        boolean isAanyaGalleryDisplayed = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरीी button");
        return isLandingPageOnPhotos && isAanyaGalleryDisplayed;
    }

    public boolean photoInExpandViewIOS(WebElement photoMainMenu,WebElement firstPhotoTitle,WebElement expandIcon,WebElement aanyaGalleryIcon){
        boolean isLandingPageOnPhotos=navigateToPhotoPage(photoMainMenu);
        String firstPhotoText=commonFunctions.getElementText(firstPhotoTitle,10);
        commonFunctions.clickElementWithJS(firstPhotoTitle,10,firstPhotoText);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElementView(expandIcon,10,"expand");
        commonFunctions.clickElement(expandIcon, 10, "Expand button for " + firstPhotoText);
        commonFunctions.dummyWait(5);
        boolean isAanyaGalleryDisplayed = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरीी button");
        return isLandingPageOnPhotos && isAanyaGalleryDisplayed;
    }

    public int returnRandomInt(int min, int max){
        Random r = new Random();
        int low = min;
        int high = max;
        int result = r.nextInt(high-low) + low;
        System.out.println("Random Number "+result);
        return result;
    }

    public void clickElementWithGivenTextWithJS(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.scrollToElement(elementList.get(i), elementList.get(i).getText());
            commonFunctions.dummyWait(2);
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElementWithJS(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public ArrayList<Integer> generateRandomNumberAccordingToCondition(String columnName){
        ArrayList<Integer> randomList = new ArrayList<Integer>();

        int startingPoint;
        int increasingPoint;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty(columnName);
        String startingMinValue = params.get("StartingMinValue");
        String startingMaxValue = params.get("StartingMaxValue");
        String incresingMinValue = params.get("IncresingMinValue");
        String incresingMaxValue = params.get("IncresingMaxValue");
        String startingDefaultValue = params.get("StartingDefaultValue");
        String increasingDefaultValue = params.get("IncreasingDefaultValue");

        String randomFlag = params.get("RandomFlagValue");

        if(randomFlag.trim().equalsIgnoreCase("y")) {

            int startingMin = Integer.parseInt(startingMinValue);
            int startingMax = Integer.parseInt(startingMaxValue);
            int incresingMin = Integer.parseInt(incresingMinValue);
            int incresingMax = Integer.parseInt(incresingMaxValue);
            int startingDefault = Integer.parseInt(startingDefaultValue);
            int increasingDefault = Integer.parseInt(increasingDefaultValue);

            if (startingMin == startingMax || startingMin > startingMax) {
                startingPoint = startingDefault;
            } else {
                startingPoint = returnRandomInt(startingMin, startingMax);
            }

            if (incresingMin == incresingMax || incresingMin > incresingMax) {
                increasingPoint = increasingDefault;
            } else {
                increasingPoint = returnRandomInt(incresingMin, incresingMax);
                if (increasingPoint == 0) {
                    increasingPoint = increasingDefault;
                }
            }

            if (increasingPoint == 0) {
                increasingPoint = 1;
            }
        }else{
            startingPoint = 0;
            increasingPoint = 1;
        }

        randomList.add(startingPoint);
        randomList.add(increasingPoint);

        return randomList;
    }
}



