package com.pages.HindustanTimes.commonFunctions;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.sun.javafx.scene.traversal.Direction;
import com.utils.Constants;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonFunctionsMobileHt {
    private static AppiumDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static CommonFunctionsMobile commonFunctions;
    private static DriverController driverController;

    public static CommonFunctionsMobileHt getInstance() {
        if (commonFunctionsMobile == null) {
            commonFunctionsMobile = new CommonFunctionsMobileHt();
        }
        driver = globalVars.getAppiumDriver();
        driverController = DriverController.getInstance();
        return commonFunctionsMobile;
    }

    public CommonFunctionsMobileHt() {

        globalVars = GlobalVars.getInstance();
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    public boolean verifySearchResultsDisplayedOnSearchPage(String expectedMessage, MobileElement searchResultsTitle) {
        boolean isLabelDisplayed = true;
        String actualMessage= commonFunctions.getElementText(searchResultsTitle,10);
        actualMessage = (actualMessage.replaceAll("[0-9]","").replace("  "," ")).trim();
        isLabelDisplayed=actualMessage.equalsIgnoreCase(expectedMessage);
        return isLabelDisplayed;
    }

    public boolean verifySearchResultsZeroDisplayedOnSearchPage(MobileElement searchResultsTitle) {
        boolean isLabelDisplayed = true;
        String actualMessage= commonFunctions.getElementText(searchResultsTitle,10);
        System.out.println(actualMessage +" - Actual Result");
        actualMessage = actualMessage.substring(7,10).trim();
        int recordsFound = Integer.parseInt(actualMessage);
        if(recordsFound == 0){
            isLabelDisplayed = true;
            Utils.logStepInfo(true,"Zero Records Found given search String");
        }
        else{
            isLabelDisplayed = false;
            Utils.logStepInfo(false,"Some Records founds for Search String");
        }
        return isLabelDisplayed;
    }

    public boolean redirectToTabInSearchPage(
            MobileElement inWhichSectionNeedToRedirtect,MobileElement homeButton, MobileElement searchField,
            MobileElement searchHeader, MobileElement searchInputTextBox, int xCordinates, int yCordinates, List<MobileElement> listOfStoriesInPhotosTab, String searchString){
        boolean isSearchPageDisplayed = commonFunctions.navigateToSearchResultPage(searchString,homeButton,searchField,searchHeader,searchInputTextBox,xCordinates,yCordinates);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(inWhichSectionNeedToRedirtect,5,inWhichSectionNeedToRedirtect.getText()+" - Section");
        boolean isRespectiveStoriesDisplayed = false;
        if(listOfStoriesInPhotosTab.size()>2){
            Utils.logStepInfo(true,"Stories are displayed in "+inWhichSectionNeedToRedirtect.getText()+" - Section in Search tab");
            isRespectiveStoriesDisplayed = true;
        }
        else{
            Utils.logStepInfo(false,"Stories are not displayed in Photos Section in Search tab");
        }
        Utils.logStepInfo(true, "isSearchPageDisplayed = "+isSearchPageDisplayed);
        Utils.logStepInfo(true, "isRespectiveStoriesDisplayed = "+isRespectiveStoriesDisplayed);
        return isSearchPageDisplayed && isRespectiveStoriesDisplayed;
    }

    public boolean redirectToPageWhenTabViewAllInSearchPage(MobileElement inWhichSectionNeedToRedirtect,MobileElement homeButton, MobileElement searchField,
                                                            MobileElement searchHeader, MobileElement searchInputTextBox, int xCordinates, int yCordinates, List<MobileElement> listOfStoriesInPhotosTab, String searchString, MobileElement viewAllOnSearchPage,String expectedHeader){
        boolean isRedirectToTab =  redirectToTabInSearchPage(
                inWhichSectionNeedToRedirtect, homeButton,  searchField,
                 searchHeader,  searchInputTextBox,  xCordinates,  yCordinates,  listOfStoriesInPhotosTab, searchString);
        isRedirectToTab &= commonFunctions.getAtribute(inWhichSectionNeedToRedirtect,"selected").equalsIgnoreCase("true");
        commonFunctions.clickElement(viewAllOnSearchPage,5,"View All in - "+inWhichSectionNeedToRedirtect.getText() );
        boolean isViewAllHeaderValidate = commonFunctions.getElementText(searchHeader,5).equalsIgnoreCase(expectedHeader);
        return isViewAllHeaderValidate && isRedirectToTab;
    }

    public boolean dailyDigestOptionDisplayedInExplore(MobileElement homeButton, MobileElement exploreMenu, MobileElement dailyDigestSection){
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton,5);
        commonFunctions.clickElement(exploreMenu,5,"Explore Button");
        boolean isDailyDigestOption = commonFunctions.isElementDisplayed(dailyDigestSection,5,"Daily Digest Section");
        if (globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE)) {
            commonFunctions.killAppAndReLaunch();
        }
        return isDailyDigestOption;
    }

    public boolean redirectToQuickReadTab(MobileElement home,MobileElement topNewsSection, MobileElement homeButton, MobileElement quickReads, MobileElement quickReadsMenu){
        commonFunctions.clickElement(home, 5, "HT home button");
        boolean isTopNewsSelected = commonFunctions.isElementSelected(topNewsSection, 5, "HT home page Top News Section");
        boolean isHTHomeButtonSelected = commonFunctions.isElementSelected(homeButton, 5, "HT home button");
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(quickReadsMenu, 5, "Quick reads page");
        return isTopNewsSelected && isHTHomeButtonSelected && isRedirectionTrue;
    }

    public boolean redirectToSectionFromQuickReads(MobileElement sectionNameToRedirect, boolean isSwipeForSection, int NumberOfTimesSwipe,MobileElement home,MobileElement topNewsSection, MobileElement homeButton, MobileElement quickReads, MobileElement quickReadsMenu){
        boolean isSectionSelected = false;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(quickReadsMenu, 5, "Quick reads page");
        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)){
            if(isSwipeForSection){
                for(int i=0; i<NumberOfTimesSwipe;i++) {
                    commonFunctions.swipeElementUsingTouchAction(945, 300, 200, 300);
                }
            }
            commonFunctions.clickElementIfDisplayed(sectionNameToRedirect,10,sectionNameToRedirect.getText()+" Tab under QuickRead page");
            isSectionSelected = commonFunctions.isElementSelected(sectionNameToRedirect,10,sectionNameToRedirect.getText()+ " tab");
        }
        else if(globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE)){
            if(isSwipeForSection){
                for (int i = 0; i < NumberOfTimesSwipe; i++) {
                    commonFunctions.swipeElementUsingTouchAction(320, 110, 110, 51);
                }
            }
            commonFunctions.clickElementIfDisplayed(sectionNameToRedirect,10,sectionNameToRedirect.getText()+" Tab under QuickRead page");
        //As IsSelected attribute is not available for iOS-Native application so validated with isDisplayed.
        isSectionSelected = commonFunctions.isElementDisplayed(sectionNameToRedirect,10,sectionNameToRedirect.getText()+ " tab");
        }
        Utils.logStepInfo(true,"isRedirectionTrue = "+isRedirectionTrue);
        Utils.logStepInfo(true,"isSectionSelected = "+isSectionSelected);
        return isRedirectionTrue && isSectionSelected;
    }

    public boolean verifySectionDisplayAfterSectionInQuickReads(String sectionDisplay, String afterSection, List<MobileElement> listOfSection, boolean isSwipeForSection, int NumberOfTimesSwipe,MobileElement home,MobileElement topNewsSection, MobileElement homeButton, MobileElement quickReads, MobileElement quickReadsMenu){
        boolean isSectionDisplayedAfterSection = false;
        commonFunctions.clickElement(home, 5, "HT home button");
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(quickReadsMenu, 5, "Quick reads page");
        if(isSwipeForSection && globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)){
            for(int i=0; i<NumberOfTimesSwipe;i++) {
                commonFunctions.swipeElementUsingTouchAction(945, 300, 200, 300);
            }
        }
        else if(isSwipeForSection && globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE)){
            for (int i = 0; i < NumberOfTimesSwipe; i++) {
                commonFunctions.swipeElementUsingTouchAction(320, 110, 110, 51);
            }
        }
        for (int j=0;j<listOfSection.size();j++){
            if(listOfSection.get(j).getText().equalsIgnoreCase(sectionDisplay) && listOfSection.get(j-1).getText().equalsIgnoreCase(afterSection)){
                isSectionDisplayedAfterSection = true;
                Utils.logStepInfo(isSectionDisplayedAfterSection, sectionDisplay + " is Displayed After " + afterSection + " successfully.");
                break;
            }
        }
        Utils.logStepInfo(true,"isSectionDisplayedAfterSection = "+isSectionDisplayedAfterSection);
        Utils.logStepInfo(true,"isRedirectionTrue = "+isRedirectionTrue);
        return isSectionDisplayedAfterSection && isRedirectionTrue;
    }

    public boolean verifyEPaperOptionInSectionForAndroid(MobileElement sectionToRedirect, MobileElement homeButton,MobileElement ePaperButtonOnHeader, MobileElement chromeOption, MobileElement onceOptionWeb,MobileElement epaperWebUrlBox){
        boolean isEPaperOpened = false;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElementIfDisplayed(sectionToRedirect, 5, sectionToRedirect.getText()+" Page");
        commonFunctions.clickElement(ePaperButtonOnHeader, 10, "E-paper on top");
        commonFunctions.clickElementIfDisplayed(chromeOption, 5, "Select chrome option for web");
        commonFunctions.clickElementIfDisplayed(onceOptionWeb, 5, "Select once option for web");
        isEPaperOpened = epaperWebUrlBox.isDisplayed();
        commonFunctions.pressAndroidBackKey();
        return isEPaperOpened;
    }

    public boolean verifyEPaperOptionInSectionForIos(MobileElement sectionToRedirect, MobileElement homeButton,MobileElement ePaperButtonOnHeader){
        boolean isEPaperOpened;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeButton, 5);
        commonFunctions.clickElementIfDisplayed(sectionToRedirect, 5, sectionToRedirect.getText()+" Page");
        isEPaperOpened = commonFunctions.isElementDisplayed(ePaperButtonOnHeader, 10, "E-paper on top");
        return isEPaperOpened;
    }

    public boolean checkFullStoryVisibleAndClickableMWeb(String quickReadURL, String readSFullStoryText, String target1, String target2, List<WebElement> carousalTargetList, List<WebElement> readFullStoryInQuickRead) {
        boolean isFullStoryVisibleAndClickableTrue = true;
        commonFunctions.navigateToHomePage();
        commonFunctions.navigateToURL(globalVars.getURL()+quickReadURL);
        commonFunctions.clickElementWithJS(getElementWithDesiredText(carousalTargetList, target1), 10, target1);
        isFullStoryVisibleAndClickableTrue &= getReadFullStoryIsVisibleAndClickable(readFullStoryInQuickRead, 10, readSFullStoryText);
        commonFunctions.clickElementWithJS(getElementWithDesiredText(carousalTargetList, target2), 10, target2);
        isFullStoryVisibleAndClickableTrue &= getReadFullStoryIsVisibleAndClickable(readFullStoryInQuickRead, 10, readSFullStoryText);
        return isFullStoryVisibleAndClickableTrue;
    }

    public WebElement getElementWithDesiredText(List<WebElement> elementList, String expectedText) {
        WebElement element = null;
        for (WebElement ele : elementList) {
            if (ele.getText().trim().equalsIgnoreCase(expectedText)) {
                element = ele;
                break;
            }
        }
        return element;
    }

    public boolean getReadFullStoryIsVisibleAndClickable(List<WebElement> elementList, long timeOutInSecond, String expectedText) {
        boolean isGetReadFullStoryIsVisibleAndClickableTrue = false;
        String text = null;
        try {
            for (WebElement ele : elementList) {
                new WebDriverWait(driver, timeOutInSecond).until(ExpectedConditions.elementToBeClickable(ele));
                text = ele.getText().trim();
                if (text.equalsIgnoreCase(expectedText) && commonFunctions.isElementClickable(ele, 20, text)) {
                    isGetReadFullStoryIsVisibleAndClickableTrue = true;
                    Utils.logStepInfo(true, text + " is visible and clickable");
                    break;
                }
            }
        } catch (Exception e) {
            isGetReadFullStoryIsVisibleAndClickableTrue = false;
            Utils.logStepInfo(false, text + " is not visible and clickable");
        }
        return isGetReadFullStoryIsVisibleAndClickableTrue;
    }

    public boolean checkSocialSharingIconsClickableMWeb(WebElement explore, WebElement indiaNews, WebElement firstStoryTitle, WebElement shareIcon,
                                                    List<WebElement> listOfSharingOption, WebElement copyUrlToShareAllOptions) {
        commonFunctions.clickElementWithJS(explore,10,"clicked on explore");
        commonFunctions.clickElementWithJS(indiaNews,10,"clicked on india News");
        commonFunctions.dummyWait(10);
        boolean firstStory = clickOnFirstStory(firstStoryTitle);
        commonFunctions.scrollToElementViewAndClick(shareIcon, 20, "Share Icon");
        boolean isSharingIconTwitterClickable = commonFunctions.isElementDisplayed(listOfSharingOption.get(2), 10,
                "twitterSharingAllOptions");
        boolean isSharingIconFacebookClickable = commonFunctions.isElementDisplayed(listOfSharingOption.get(1), 10,
                "facebookSharingAllOptions");
        boolean isSharingIconLinkedInClickable = commonFunctions.isElementDisplayed(listOfSharingOption.get(3), 10,
                "LinkedInSharingAllOptions");
        boolean isSharingIconWhatsAppClickable = commonFunctions.isElementDisplayed(listOfSharingOption.get(0), 10,
                "WhatsAppSharingAllOptions");
        boolean copyUrl = clickOnCopyIconAndCheckUrlCopied(shareIcon, copyUrlToShareAllOptions);
        return firstStory && copyUrl && isSharingIconTwitterClickable && isSharingIconFacebookClickable && isSharingIconLinkedInClickable
                && isSharingIconWhatsAppClickable;
    }

    public boolean clickOnFirstStory(WebElement firstStoryTitle) {
        boolean isClickOnFirstStory=false;
        try {
            isClickOnFirstStory=commonFunctions.scrollToElementViewAndClick(firstStoryTitle, 20, "firstStoryTitle");
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains(".html")) {
                isClickOnFirstStory = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnFirstStory;
    }

    public boolean clickOnCopyIconAndCheckUrlCopied( WebElement shareIcon, WebElement copyUrlToShareAllOptions) {
        boolean isCopyIconClickedAndUrlCopied = false;
        try {
            commonFunctions.clickElementIfDisplayed(shareIcon,5,"Share icon");
            String elementText = commonFunctions.getAttributeValue(copyUrlToShareAllOptions,5,"data-title");
            if(elementText.contains(globalVars.getURL())) {
                isCopyIconClickedAndUrlCopied = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isCopyIconClickedAndUrlCopied;
    }

    public boolean checkAuthorName(WebElement headLineStory, WebElement authorName) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(headLineStory, 20, "Head line");
        commonFunctions.scrollUsingAction(authorName,"Author Name");
        boolean authorNameVisible = commonFunctions.isElementDisplayed(authorName, 20, "Author/Agency Name");
        Utils.logStepInfo(true,"Author Name Visible = "+authorName.getText());
        return authorNameVisible;
    }

    public boolean checkDateTimeMWeb(WebElement indiaNews, List<MobileElement> dateTime) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(indiaNews,10,"clicked on india News");
        commonFunctions.dummyWait(20);
        boolean dateTimeDisplayedStatus=commonFunctions.isElementDisplayedOfListOfElements(dateTime,"Date Time");
        return dateTimeDisplayedStatus;
    }

    public boolean checkStoryIsExpanded(WebElement sectionPageList, WebElement headLineStoriesLink, WebElement fullStoryHeading, List<MobileElement> fullStoryParagraphs) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(sectionPageList, 20, sectionPageList.getText().trim());
        commonFunctions.scrollDownOnce();
        boolean leadImageStatus = commonFunctions.isElementDisplayed(headLineStoriesLink, 20, "Lead story headline");
        commonFunctions.clickElementWithJS(headLineStoriesLink, 50, "HeadLine");
        commonFunctions.waitForURLContains(".html");
        commonFunctions.dummyWait(5);
        boolean isFullStoryOpen = commonFunctions.isElementDisplayed(fullStoryHeading, 10, "Full story");
        commonFunctions.dummyWait(5);
        int listSize = fullStoryParagraphs.size();
        boolean isOtherStoryDetailOpen;
        if (listSize > 1) {
            isOtherStoryDetailOpen = true;
            Utils.logStepInfo(isOtherStoryDetailOpen, "Full Story Paragraphs are available.");
        } else {
            isOtherStoryDetailOpen = false;
            Utils.logStepInfo(isOtherStoryDetailOpen, "Full Story Paragraphs are not available.");
        }
        return leadImageStatus && isOtherStoryDetailOpen & isFullStoryOpen;
    }

    public boolean verifyExploreOptionsInHamburger(WebElement hamburgerButton, WebElement exploreHT, List<WebElement> exploreHTList) {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(hamburgerButton, 20,"hamburgerButton");
        commonFunctions.scrollToElement(exploreHT,"Explore HT options");
        boolean isCheckExploreHTOptionDisplayedOnHamburgerMenu = commonFunctions.isElementDisplayed(exploreHT,20,"Explore HT");
        isCheckExploreHTOptionDisplayedOnHamburgerMenu &= commonFunctions.scrollToViewElementWithLinks(exploreHTList);
        return isCheckExploreHTOptionDisplayedOnHamburgerMenu;
    }

    public boolean verifySectionNameAfterAnotherSectionName(String sectionDisplay,String afterSection,List<MobileElement> listOfSection,MobileElement lastTab,MobileElement sectionElement,MobileElement lastSection,MobileElement home,MobileElement quickReads,MobileElement quickReadsMenu) {
        boolean isSectionDisplayedAfterSection = false;
        commonFunctions.clickElement(home, 5, "HT home button");
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(quickReadsMenu, 5, "Quick reads page");
        commonFunctions.clickElement(lastTab, 10, "Last element");
        boolean isElementDisplayed = commonFunctions.isElementDisplayed(sectionElement, 10, sectionDisplay);
        if (isElementDisplayed == true) {
            for (int j = 0; j < listOfSection.size(); j++) {
                if (listOfSection.get(j).getText().equalsIgnoreCase(sectionDisplay) && listOfSection.get(j - 1).getText().equalsIgnoreCase(afterSection)) {
                    isSectionDisplayedAfterSection = true;
                    Utils.logStepInfo(isSectionDisplayedAfterSection, sectionDisplay + " is Displayed After " + afterSection + " successfully.");
                    break;
                }
            }
        } else {
            commonFunctions.clickElement(lastSection,10,"Last section after first tap");
            for (int j = 0; j < listOfSection.size(); j++) {
                if (listOfSection.get(j).getText().equalsIgnoreCase(sectionDisplay) && listOfSection.get(j - 1).getText().equalsIgnoreCase(afterSection)) {
                    isSectionDisplayedAfterSection = true;
                    Utils.logStepInfo(isSectionDisplayedAfterSection, sectionDisplay + " is Displayed After " + afterSection + " successfully.");
                    break;
                }
            }
        }
        return isSectionDisplayedAfterSection && isRedirectionTrue;

    }

    public boolean getTabRedirectionInQuickreads(MobileElement sectionNameToRedirect,MobileElement lastTab,MobileElement lastSection,MobileElement home,MobileElement quickReads,MobileElement quickReadsMenu) {
        boolean isSectionSelected = false;
        commonFunctions.clickElement(home, 5, "HT home button");
        Utils.logStepInfo("Tap on QuickReads");
        commonFunctions.clickElement(quickReads, 5, "Quick reads on Home page");
        boolean isRedirectionTrue = commonFunctions.isElementDisplayed(quickReadsMenu, 5, "Quick reads page");
        commonFunctions.clickElement(lastTab, 10, "Last element");
        boolean isElementDisplayed = commonFunctions.isElementDisplayed(sectionNameToRedirect, 10, sectionNameToRedirect.getText()+" Tab under QuickRead page");
        if(isElementDisplayed == true) {
            isSectionSelected = commonFunctions.isElementDisplayed(sectionNameToRedirect,10,sectionNameToRedirect.getText()+ " tab");
        } else {
            commonFunctions.clickElement(lastSection,10,"Last section after first tap");
            isSectionSelected = commonFunctions.isElementDisplayed(sectionNameToRedirect,10,sectionNameToRedirect.getText()+ " tab");
        }
        return isRedirectionTrue && isSectionSelected;
    }

    public boolean getRedirectionToSectionFromRightToLeft(MobileElement ele, String elementName) {
        boolean isElementDisplay = false;
        for(int i=0; i<=5; i++) {
            if (commonFunctions.isElementNotDisplayed(ele,5,elementName)) {
                if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
                    commonFunctions.swipeElementUsingTouchAction(830, 275, 400, 275);
                } else if (globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE)) {
                    commonFunctions.swipeElementUsingTouchAction(300, 105, 150, 105);
                }
            } else if (commonFunctions.isElementDisplayed(ele,5,elementName)) {
                commonFunctions.clickElement(ele,5,elementName);
                isElementDisplay =true;
                break;
            }
        }
        return isElementDisplay;
    }

    public boolean getRedirectionToSectionFromLeftToRight(MobileElement ele,String elementName) {
        boolean isElementDisplay = false;
        for(int i=0; i<=5; i++) {
            if (commonFunctions.isElementNotDisplayed(ele,5,elementName)) {
                if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
                    commonFunctions.swipeElementUsingTouchAction(400, 275, 830, 275);
                } else if (globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE)) {
                    commonFunctions.swipeElementUsingTouchAction(150,105,300,105);
                }
            } else if (commonFunctions.isElementDisplayed(ele,5,elementName)) {
                commonFunctions.clickElement(ele,5,elementName);
                isElementDisplay = true;
                break;
            }
        }
        return isElementDisplay;
    }

    public boolean checkTextOnCitiesSection(MobileElement home,MobileElement citiesSection,MobileElement gotItButton,MobileElement mayBeLaterButton,MobileElement addCitiesOption) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        boolean isSectionDisplay = getRedirectionToSectionFromRightToLeft(citiesSection,"Cities");
        commonFunctions.clickElementIfDisplayed(gotItButton,5,"Got it");
        if(commonFunctions.isElementNotDisplayed(mayBeLaterButton,5,"May be later")) {
            commonFunctions.clickElement(addCitiesOption,5,"Add cities");
            if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
                commonFunctions.scrollDownSlowToElement(mayBeLaterButton,5);
            }
        }
        boolean isElementDisplay = commonFunctions.isElementDisplayed(mayBeLaterButton,5,"May be later");
        return isSectionDisplay && isElementDisplay;
    }

    public boolean selectFirstCity(MobileElement selectCityButton,String cityName,MobileElement mayBeLaterButton,MobileElement saveChangesButton,MobileElement addFavouriteCities) {
        if (globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
            commonFunctions.clickElement(selectCityButton,5,cityName);
            commonFunctions.checkElementVisibilityByScrolling(mayBeLaterButton,"May be later");
            if(commonFunctions.isElementClickable(saveChangesButton,5,"Save changes")) {
                commonFunctions.clickElement(saveChangesButton,5,"Save changes");
            }
            else {
                commonFunctions.clickElement(selectCityButton,5,cityName);
                commonFunctions.checkElementVisibilityByScrolling(mayBeLaterButton,"May be later");
                commonFunctions.clickElement(saveChangesButton,5,"Save changes");
            }
            if(commonFunctions.isElementDisplayed(addFavouriteCities,5,"Add favourite cities")) {
                commonFunctions.clickElement(mayBeLaterButton,5,"May be later");
            }
        } if (globalVars.getPlatformName().equalsIgnoreCase(Constants.IOS_NATIVE)) {
            if(commonFunctions.isElementClickable(saveChangesButton,5,"Save changes")) {
                commonFunctions.clickElement(saveChangesButton,5,"Save changes");
            }
            else {
                commonFunctions.clickElement(selectCityButton,5,cityName);
                commonFunctions.clickElement(saveChangesButton,5,"Save changes");
            }
        }
        boolean isSelectedCityDisplayed = commonFunctions.isElementDisplayed(selectCityButton,5,cityName);
        return isSelectedCityDisplayed;
    }

    public void getBackToTopInAndroid(MobileElement home,MobileElement quickreads) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
        commonFunctions.clickElement(quickreads,5,"Quickreads in bottom nav");
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home,5);
    }

    public boolean selectOrDeselectSecondCity(MobileElement addCities,MobileElement mayBeLater,MobileElement secondCity,String secondCityName,MobileElement saveChanges) {
        boolean isElementDisplay = true;
        isElementDisplay = commonFunctions.clickElementIfDisplayed(addCities,5,"Add cities");
        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_NATIVE)) {
            commonFunctions.scrollDownSlowToElement(mayBeLater,5);
        }
        isElementDisplay &= commonFunctions.clickElement(secondCity,5,secondCityName);
        isElementDisplay &= commonFunctions.clickElementIfDisplayed(saveChanges,5,"Save changes");
        return isElementDisplay;
    }

    public boolean scrollAndClickToSectionInExplore(MobileElement home,MobileElement exploreButton,MobileElement section,String sectionName,MobileElement sectionToDisplay,String sectionDisplayName) {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(home, 5);
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.scrollDownSlowToElement(section,5);
        commonFunctions.clickElementIfDisplayed(section, 5, sectionName);
        boolean isElementDisplayed = commonFunctions.isElementDisplayed(sectionToDisplay, 5, sectionDisplayName+" landing page");
        return isElementDisplayed;
    }
}