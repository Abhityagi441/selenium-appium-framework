package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonSearchPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends CommonSearchPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static ApiValidation apiValidation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Home']")
    private static MobileElement homeByXpath;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Home']")
    private static MobileElement homeByXpathOnSearchPage;

    @iOSXCUITFindBy(id="Home")
    private static MobileElement homeById;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='World']")
    private static List<MobileElement> world;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='News']")
    private static MobileElement newsLabelOnSearchResultPage;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Photos']")
    private static MobileElement photosLabelOnSearchResultPage;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Videos']")
    private static MobileElement videosLabelOnSearchResultPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='hamburger menu']")
    private static MobileElement hamburgerMenu;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='india']")
    private static MobileElement india;

    @iOSXCUITFindBy(id = "searchNav")
    private static MobileElement searchField;

    @iOSXCUITFindBy(id = "search")
    private static List<MobileElement> searchFieldMain;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'items found')]")
    private static MobileElement itemsFound;

    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement exploreButton;

    @iOSXCUITFindBy(id = "SEARCH")
    private static MobileElement searchHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name='Tab Bar']")
    private static MobileElement bottomNav;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SEARCH']")
    private static MobileElement searchHeaderxPath;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Latest News'])[1]")
    private static MobileElement latestNewsSubHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LATEST NEWS']")
    private static MobileElement latestNewsHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='View All'])[1]")
    private static MobileElement viewAllOnSearchPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Latest News']//parent::XCUIElementTypeTable//XCUIElementTypeCell")
    private static List<MobileElement> listOfStoriesOnLatestNewsPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Profile']")
    private static MobileElement profileButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name ='E-paper']")
    private static MobileElement ePaper;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cricket']")
    private static MobileElement cricketOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Premium']")
    private static MobileElement premiumOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Quickreads']")
    private static MobileElement quickReadsOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Swipe Up For Next Story']")
    private static MobileElement quickreadsPageElement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='back new']")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top News']")
    private static MobileElement topNewsSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='micIconDay']")
    private static MobileElement micIconInSearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    private static MobileElement lensIconInSearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='micIconDay']/preceding-sibling::XCUIElementTypeTextField")
    private static MobileElement textBoxInSearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CRICKET']")
    private static List<MobileElement> listOfSubSectionsInSearchStoriesPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value = 'Type here to search news, photos, videos…']")
    private static MobileElement waterMarkTextInSearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value , 'results for '])")
    private static MobileElement searchResultsTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value = 'India News']")
    private static MobileElement textEnteredInTextBox;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyCaption;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[4]")
    private static MobileElement storyParagraph;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three grey list']")
    private static List<MobileElement> threeDotsInStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Share']")
    private static MobileElement shareOptionInStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CRICKET]")
    private static MobileElement cricketPageHeading;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three grey list']/parent:: XCUIElementTypeCell/XCUIElementTypeButton[2]")
    private static List<MobileElement> sectionListInSearchStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    private static MobileElement pageHeaderInSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name = 'SPORTS']")
    private static List<MobileElement> listOfSebSectionOnPhotos;

    @iOSXCUITFindBy (id = "Trending Topics")
    private static MobileElement trendingTopicsInSearchPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Trending Topics']/parent:: XCUIElementTypeCell/XCUIElementTypeStaticText")
    private static List<MobileElement> listOfTopicsInTrendingTopics;

    @iOSXCUITFindBy(id = "twitter")
    private static MobileElement twitter;

    @iOSXCUITFindBy(id = "share whatsapp")
    private static MobileElement whatsApp;

    @iOSXCUITFindBy(id = "Quickreads")
    private static MobileElement quickreadsById;

    @iOSXCUITFindBy(id = "Premium")
    private static MobileElement premiumTab;

    public SearchPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        apiValidation=ApiValidation.getInstance();
       // Utils.logStepInfo("This is sttarted");
        /*commonFunctions.clickElementIfDisplayed(allowTracking,10,"Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 10, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(continueButton,10,"Continue Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,10,"Later Button");
        commonFunctions.clickElementIfDisplayed(skip,10,"Skip Button");
        commonFunctions.clickElementIfDisplayed(skip,10,"Skip Button"); */
    }

    @Override
    public boolean checkSearchButtonRedirection() {
        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElement(exploreButton, 30, "Explore option");
        commonFunctions.clickElement(searchField, 30, "Search option");
        Utils.logStepInfo("Click on Search Option to open Search Page.");
        boolean searchButtonRedirection=commonFunctions.isElementDisplayed(searchHeader, 30, "Search Page Header");
        return searchButtonRedirection;
    }
    @Override
    public boolean checkSearchButtonRedirectionProfilePage() {
        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElement(profileButton, 20, "Profile");
        commonFunctions.clickElement(searchField, 30, "Search option");
        Utils.logStepInfo("Click on Search Option to open Search Page.");
        boolean searchButtonRedirection=commonFunctions.isElementDisplayed(searchHeader, 30, "Search Page Header");
        return searchButtonRedirection;
    }

    @Override
    public boolean checkEPaperOption() {
        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElement(profileButton, 20, "Profile");
        boolean ePaperPresent=commonFunctions.isElementDisplayed(ePaper, 30, "E Paper on Top");
        return ePaperPresent;
    }

    @Override
    public boolean checkEPaperOptionFromExplore() {
        return false;
    }

    @Override
    public boolean checkSearchOptionInCricketPage() {
        commonFunctions.clickElement(homeById,5,"Home");
        commonFunctions.clickElement(cricketOption,5,"Cricket Option");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchField,5,"Search option");
        if(isSearchOptionDisplayed) {
            commonFunctions.clickElement(searchField, 5, "Search option");
            commonFunctions.hideKeyboard();
        }
        boolean IsSearchPageHeader = commonFunctions.isElementDisplayed(searchHeader, 5, "Search Header");
        return isSearchOptionDisplayed && IsSearchPageHeader;
    }

    @Override
    public boolean checkSearchOptionWhenTabOnBackButton() {
        commonFunctions.clickElement(homeById,5,"Home Button");
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.hideKeyboard();
        boolean isSearchPageDisplayed = commonFunctions.isElementDisplayed(searchHeader, 5,"Search page Header");
        if(isSearchPageDisplayed){
            commonFunctions.clickElement(back,5,"Back Button");
        }
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage;
    }

    @Override
    public boolean checkStoryPageOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeaderxPath, 15).equalsIgnoreCase("SEARCH");
        commonFunctions.clickElementIfDisplayed(listOfStoriesOnLatestNewsPage.get(0),20,"Click on First story on Latest news page");
        commonFunctions.dummyWait(10);
        commonFunctions.tapElementWithCoOrdinates(158,215,"Skip bookmark popup");
        boolean isStoryDisplayed= commonFunctions.isElementDisplayed(storyCaption,10,"Story Caption");
        commonFunctions.scrollUntilElementFound(storyParagraph);
        boolean isParagraphDisplayed = commonFunctions.isElementDisplayed(storyParagraph,20,"Paragraph displayed");
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeById,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage && isStoryDisplayed && isParagraphDisplayed;
    }

    @Override
    public boolean checkViewAllOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeaderxPath, 15).equalsIgnoreCase("SEARCH");
        commonFunctions.clickElementIfDisplayed(viewAllOnSearchPage,10,"click on View All link on Search page");
        boolean isLatestNewsPageDisplayed=commonFunctions.getElementText(latestNewsHeader,10).equalsIgnoreCase("LATEST NEWS");
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeById,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage && isLatestNewsPageDisplayed;
    }

    @Override
    public boolean checkDefaultLatestNewsOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        boolean isSearchPageDisplayed = commonFunctions.getElementText(searchHeaderxPath, 5).equalsIgnoreCase("SEARCH");
        boolean isLatestNewsPageDisplayed= commonFunctions.getElementText(latestNewsSubHeader,10).equalsIgnoreCase("Latest News");
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeById,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isSearchPageDisplayed && isHomePage && isLatestNewsPageDisplayed;
    }

    @Override
    public boolean checkCricketNewsOnSearchPage() {
        boolean isSubsectionCricketDispalyed=true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElementIfDisplayed(world.get(0),20,"World section from header");
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElementIfDisplayed(textBoxInSearch,20,"Click on Search box");
        commonFunctions.sendKeysOnAndroid(textBoxInSearch,"Cricket");
        commonFunctions.clickByCoordinates(338,742,"Enter Key");
        commonFunctions.dummyWait(20);
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                isSubsectionCricketDispalyed&=true;
                Utils.logStepInfo("Message is matched");
            }
            else{
                isSubsectionCricketDispalyed&=false;
            }
        }
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(homeById,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isSubsectionCricketDispalyed && isHomePage;
    }

    @Override
    public boolean checkSearchIsWorkingOnSearchPage() {
        boolean isSearchWorking=true;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElementIfDisplayed(textBoxInSearch,20,"Click on Search box");
        commonFunctions.sendKeysOnAndroid(textBoxInSearch,"Cricket");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(338,742,"Enter Key");
        commonFunctions.dummyWait(20);
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                isSearchWorking&=true;
                Utils.logStepInfo("Message is matched");
            }
            else{
                isSearchWorking&=false;
                Utils.logStepInfo("Message is NOT matched");
            }
        }
        //commonFunctions.clickElement(back,15,"Back Button");
        //commonFunctions.hideKeyboard();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isSearchWorking && isHomePage;
    }

    public boolean checkLensIconTextBoxAndVoiceIcon() {
        commonFunctions.clickElement(homeById,5,"Home Button");
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.hideKeyboard();
        boolean isSearchPageDisplayed = commonFunctions.isElementDisplayed(searchHeader, 5,"Search page Header");
        boolean isIconDisplayed = commonFunctions.isElementDisplayed(micIconInSearch,5,"Mic Icon in Search");
        isIconDisplayed &= commonFunctions.isElementDisplayed(textBoxInSearch,5,"Text Box in Search");
        //isIconDisplayed &= commonFunctions.isElementDisplayed(lensIconInSearch,5,"Lens Icon");
        return isSearchPageDisplayed && isIconDisplayed;
    }

    @Override
    public boolean checkWatermarkRemovedIfEnterAnyChar() {
        commonFunctions.clickElement(homeById,5,"Home Button");
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.hideKeyboard();
        boolean isWanterMarkTextInSearchBox = commonFunctions.isElementDisplayed(waterMarkTextInSearch,5,"TextBox with water amrk in Search");
        commonFunctions.sendKeysOnAndroid(textBoxInSearch,"India News");
        boolean isWaterMarkRemoved = !commonFunctions.isElementDisplayed(waterMarkTextInSearch,5,"Water Mark Text");
        isWaterMarkRemoved &= commonFunctions.isElementDisplayed(textEnteredInTextBox,5,"Entered Text");
        return isWanterMarkTextInSearchBox && isWaterMarkRemoved;
    }

    @Override
    public boolean checkSearchPageRedirectionFromExplore() {
        return false;
    }

    @Override
    public boolean clickOnExplorerMenu() {
        return false;
    }

    @Override
    public boolean clickOnEntertainmentSection() {
        return false;
    }

    @Override
    public boolean checkRedirectionToEntertainmentSection() {
        return false;
    }

    @Override
    public boolean checkSearchButtonDisplayedAndClickable(String[] params) {
        return false;
    }

    @Override
    public boolean checkSearchIsWorking(String text) {
        return false;
    }

    @Override
    public boolean CheckSearchButtonIsWorking(String[] params) {
        return false;
    }

    @Override
    public boolean checkSearchIsWorking(String[] params) {
        boolean clickHamburger= commonFunctions.clickElement(hamburgerMenu);
        Utils.logStepInfo(clickHamburger,"Clicked on Hamburger");

        boolean clickSearch=commonFunctions.clickElement(searchField);
        Utils.logStepInfo(clickSearch,"Clicked search field");

        commonFunctions.sendKey(searchFieldMain.get(1),params[5],10);

        boolean keyBoard=commonFunctions.isKeyboardVisible();
        Utils.logStepInfo(keyBoard,"Keyboard is visible");

        boolean tapSearch=commonFunctions.clickElement(searchFieldMain.get(0));
        Utils.logStepInfo(tapSearch,"Tapped search button on keyboard");

        String valFrontEnd=commonFunctions.getElementText(itemsFound);
        apiValidation.response=apiValidation.getResponseFromURI(params[7],params[6]);

        String valueBackend = JsonPath.parse(apiValidation.response.getBody().asString()).read("$.content.totalResults");

        boolean validation=valFrontEnd.equalsIgnoreCase(valueBackend+" items found");
        Utils.logStepInfo(validation,"Verifying items found");
        return clickHamburger&&clickSearch&&tapSearch&&clickSearch&&validation;
    }

    @Override
    public boolean checkNewsPhotosVideosLabelsOnSearchPage() {
        boolean isLabelDisplayed;
        isLabelDisplayed = newsPhotosVideosOptionDisplayedInSearchResult();
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isLabelDisplayed && isHomePage;
    }

    @Override
    public boolean checkDefaultNewsDisplayedOnSearchPage() {
        boolean isLabelDisplayed;
        isLabelDisplayed = newsPhotosVideosOptionDisplayedInSearchResult();
        boolean isNewsSelected= commonFunctions.isElementSelected(newsLabelOnSearchResultPage,10,"News label");
        boolean isPhotosSelected= commonFunctions.isElementSelected(photosLabelOnSearchResultPage,10,"News label");
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isNewsSelected && isHomePage && !isPhotosSelected;
    }

    @Override
    public boolean checkNumberOfSearchResultsDisplayedOnSearchPage(String expectedMessage) {
        boolean isLabelDisplayed;
        isLabelDisplayed = newsPhotosVideosOptionDisplayedInSearchResult();
        String actualMessage= commonFunctions.getElementText(searchResultsTitle,10);
        actualMessage=actualMessage.replaceAll("[0-9]","").replace("  "," ");
        isLabelDisplayed=actualMessage.equalsIgnoreCase(expectedMessage);
        commonFunctions.pressAndroidBackKey();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeById,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        isHomePage &= commonFunctions.isElementDisplayed(topNewsSection,5,"Top News Option");
        return isLabelDisplayed && isHomePage;
    }

    @Override
    public boolean checkStoryTappableOnSearchPage() {
        boolean isSearchPageDisplayed=commonFunctions.navigateToSearchResultPage("Cricket",homeById,searchField,searchHeader,textBoxInSearch,338,742);
        commonFunctions.clickElementIfDisplayed(listOfStoriesOnLatestNewsPage.get(0),20,"Click on First story on Latest news page");
        commonFunctions.dummyWait(10);
        boolean isStoryDisplayed= commonFunctions.isElementDisplayed(storyCaption,10,"Story Caption");
        commonFunctions.scrollUntilElementFound(storyParagraph);
        boolean isParagraphDisplayed = commonFunctions.isElementDisplayed(storyParagraph,20,"Paragraph displayed");
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isSearchPageDisplayed && isHomePage && isStoryDisplayed && isParagraphDisplayed;
    }

    @Override
    public boolean checkSearchOptionOnHomePage() {
        commonFunctions.clickElement(homeById,5,"Home Button");
        boolean isHomePageDisplayed = commonFunctions.isElementDisplayed(homeById,5,"Home Page");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchField,5,"After E-Paper option Search Option");
        return isHomePageDisplayed && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSearchOptionOnQuickreadsPage() {
            boolean isQuickreadsPageTabHighlighted = checkSelectedBottomNavTab(quickreadsById,"Quickreads Tab");
            boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchField,5,"After E-Paper option Search Option");
            return isQuickreadsPageTabHighlighted && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSearchOptionOnPremiumPage() {
        boolean isPremiumPageTabHighlighted = checkSelectedBottomNavTab(premiumTab,"Premium tab");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchField,5,"After E-Paper option Search Option");
        return isPremiumPageTabHighlighted && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSearchOptionOnExplorePage() {
        boolean isExplorePageTabHighlighted = checkSelectedBottomNavTab(exploreButton,"Explore tab");
        boolean isSearchOptionDisplayed = commonFunctions.isElementDisplayed(searchField,5,"After E-Paper option Search Option");
        return isExplorePageTabHighlighted && isSearchOptionDisplayed;
    }

    @Override
    public boolean checkSelectedBottomNavTab(MobileElement ele, String text) {
        commonFunctions.clickElement(homeById,5,"Home Button");
        commonFunctions.clickElement(ele,5,text);
        boolean isBottomNavTabSelected = commonFunctions.isElementSelected(ele,5,text);
        return isBottomNavTabSelected;
    }

    @Override
    public boolean checkSearchOnCricketPage() {
        boolean isSearchWorking=true;
        boolean isSearchHeaderDisplayed=commonFunctions.navigateToSectionResultPage("Cricket",cricketOption,homeById,searchField,searchHeader,textBoxInSearch,338,742);
        commonFunctions.dummyWait(10);
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                isSearchWorking&=true;
                Utils.logStepInfo("Message is matched");
            }
            else{
                isSearchWorking&=false;
                Utils.logStepInfo("Message is NOT matched");
            }
        }
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isSearchWorking && isHomePage && isSearchHeaderDisplayed;
    }

    @Override
    public boolean checkSearchOnPremiumPage() {
        boolean isSearchWorking=true;
        boolean isSearchHeaderDisplayed=commonFunctions.navigateToSectionResultPage("Cricket",premiumOption,homeById,searchField,searchHeader,textBoxInSearch,338,742);
        commonFunctions.dummyWait(10);
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                isSearchWorking&=true;
                Utils.logStepInfo("Message is matched");
            }
            else{
                isSearchWorking&=false;
                Utils.logStepInfo("Message is NOT matched");
            }
        }
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isSearchWorking && isHomePage && isSearchHeaderDisplayed;
    }

    @Override
    public boolean checkSearchOnQuickReadsPage() {
        boolean isSearchWorking=true;
        boolean isSearchHeaderDisplayed=commonFunctions.navigateToSectionResultPage("Cricket",quickReadsOption,homeById,searchField,searchHeader,textBoxInSearch,338,742);
        commonFunctions.dummyWait(10);
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                isSearchWorking&=true;
                Utils.logStepInfo("Message is matched");
            }
            else{
                isSearchWorking&=false;
                Utils.logStepInfo("Message is NOT matched");
            }
        }
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isSearchWorking && isHomePage && isSearchHeaderDisplayed;
    }

    @Override
    public boolean checkSearchOnHomePage() {
        boolean isSearchWorking=true;
        boolean isSearchHeaderDisplayed=commonFunctions.navigateToSearchResultPage("Cricket",homeById,searchField,searchHeader,textBoxInSearch,338,742);
        commonFunctions.dummyWait(10);
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                isSearchWorking&=true;
                Utils.logStepInfo("Message is matched");
            }
            else{
                isSearchWorking&=false;
                Utils.logStepInfo("Message is NOT matched");
            }
        }
        commonFunctions.clickElement(back,15,"Back Button");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElementIfDisplayed(homeByXpathOnSearchPage,5,"Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById,5,"Home Button");
        return isSearchWorking && isHomePage && isSearchHeaderDisplayed;
    }

    @Override
    public boolean checkBottomNavOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById, 5);
        commonFunctions.clickElement(searchField, 5, "Search Option");
        commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        commonFunctions.hideKeyboard();
        boolean isBottomNavDisplayed = commonFunctions.isElementDisplayed(bottomNav, 10, "Bottom Nav");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeByXpathOnSearchPage, 5, "Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById, 5, "Home Button");
        return isHomePage && isBottomNavDisplayed;
    }

    @Override
    public boolean checkBottomNavNavigationOnSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById, 5);
        commonFunctions.clickElement(searchField, 5, "Search Option");
        commonFunctions.getElementText(searchHeader, 5).equalsIgnoreCase("SEARCH");
        commonFunctions.hideKeyboard();
        boolean isBottomNavDisplayed = commonFunctions.isElementDisplayed(bottomNav, 10, "Bottom Nav");
        commonFunctions.clickElementIfDisplayed(quickReadsOption,10,"QuickRead from Bottom Nav");
        commonFunctions.dummyWait(10);
        boolean isQuickReadPageDisplayed= commonFunctions.isElementDisplayed(quickreadsPageElement,10,"QuickRead page Element");
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(homeByXpathOnSearchPage, 5, "Home Button");
        boolean isHomePage = commonFunctions.isElementDisplayed(homeById, 5, "Home Button");
        return isHomePage && isBottomNavDisplayed && isQuickReadPageDisplayed;
    }

    @Override
    public boolean checkHorizontalLineInEachStoryInNewsOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkShareStoryOptionInSearchPage() {
        return commonFunctions.checkShareOptionInFirstStoryInPage(homeById,searchField,threeDotsInStory,shareOptionInStory);
    }

    @Override
    public boolean checkRedirectToSectionFromSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        String sectionNameInSearchPage = commonFunctions.getElementText(sectionListInSearchStory.get(0),5);
        commonFunctions.clickElement(sectionListInSearchStory.get(0),5,"Section Name In Search Story");
        boolean isRedirectToSubsection = commonFunctions.isElementDisplayed(pageHeaderInSection,5,"Page Heading");
        isRedirectToSubsection &= commonFunctions.getElementText(pageHeaderInSection,5).equalsIgnoreCase(sectionNameInSearchPage);
        return isRedirectToSubsection;
    }

    @Override
    public boolean checkScrollDownInNewsSectionINSearchPage() {
        /*boolean isSearchWorking = true;
        boolean isSearchHeaderDisplayed=commonFunctions.navigateToSearchResultPage("Cricket",homeById,searchField,searchHeader,textBoxInSearch,338,742);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownByCoordinates(cricketOption,425,1760,429,720);
        System.out.println("Total - " +listOfSubSectionsInSearchStoriesPage.size()+ " SubSubsections are available");
        for(int i=0;i<listOfSubSectionsInSearchStoriesPage.size();i++){
            if(listOfSubSectionsInSearchStoriesPage.get(i).getText().equalsIgnoreCase("Cricket")){
                System.out.println(i+1 + "time Sub Section is matching");
                isSearchWorking &= true;
            }
            else{
                System.out.println(i+1 + "time sub section name is not matching");
            }
        }
        System.out.println("isSearchWorking = " +  isSearchWorking + " and isSearchPageDisplayed = " + isSearchHeaderDisplayed);
        return isSearchHeaderDisplayed && isSearchWorking;*/
        return false;
    }

    @Override
    public boolean checkRedirectToPhotosInSearchPage() {
        //return commonFunctions.redirectToPhotosTabInSearchPage(homeById,searchField,searchHeader,textBoxInSearch,338,742,photosLabelOnSearchResultPage,listOfSebSectionOnPhotos);
        boolean isSearchPageDisplayed = commonFunctions.navigateToSearchResultPage("Cricket",homeById,searchField,searchHeader,textBoxInSearch,986,2083);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(photosLabelOnSearchResultPage,5,"Photos Section");
        boolean isPhotosStoriesDisplayed = false;
        if(listOfSebSectionOnPhotos.size()>2){
            Utils.logStepInfo(true,"Photos Stories are displayed in Photos Section in Search tab");
            isPhotosStoriesDisplayed = true;
        }
        else{
            Utils.logStepInfo(false,"Photos Stories are not displayed in Photos Section in Search tab");
        }
        return isSearchPageDisplayed && isPhotosStoriesDisplayed;
    }

    @Override
    public boolean checkPhotosOptionDisplayedAsSelectedInSearchPage() {
        return false;
    }

    @Override
    public boolean checkNumberOfResultInPhotosOnSearchPage(String expectedMessage) {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromPhotosInSearchPag() {
        return false;
    }

    @Override
    public boolean checkRedirectToVideosInSearchPage() {
        return false;
    }

    @Override
    public boolean checkVideosOptionDisplayedAsSelectedInSearchPage() {
        return false;
    }

    @Override
    public boolean checkNumberOfResultInVideosOnSearchPage(String expectedMessage) {
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromVideosInSearchPag() {
        return false;
    }

    @Override
    public boolean checkSearchForNoStoryFoundInSearchPage() {
        boolean isSearchPageDisplayed = commonFunctions.navigateToSearchResultPage("hhhh",homeById,searchField,searchHeader,textBoxInSearch,338,742);
        boolean isResultZero = commonFunctionsMobile.verifySearchResultsZeroDisplayedOnSearchPage(searchResultsTitle);
        return isSearchPageDisplayed && isResultZero;
    }

    @Override
    public boolean checktitleAlsoLikeInNewsTabInSearchPage() {
        return false;
    }

    @Override
    public boolean checkTitleAlsoLikeInPhotosTabInSearchPage() {
        return false;
    }

    @Override
    public boolean checkTitleAlsoLikeInVideosTabInSearchPage() {
        return false;
    }

    @Override
    public boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInNews() {
        return false;
    }

    @Override
    public boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInPhotos() {
        return false;
    }

    @Override
    public boolean checkRedirectToTitleAlsoLikeWhenTabInViewAllInVideos() {
        return false;
    }

    @Override
    public boolean checkScrollDownTillLatestTopicInSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.hideKeyboard();
        commonFunctions.scrollDownToElement(trendingTopicsInSearchPage, "Trending Topics");
        boolean isLatestTopics = commonFunctions.isElementDisplayed(trendingTopicsInSearchPage,5,"Latest Topics");
        return isLatestTopics;
    }

    @Override
    public boolean checkRedirectToStoryFromLatestTopicInSearchPage() {
        boolean isRedirectToTopics = checkScrollDownTillLatestTopicInSearchPage();
        commonFunctions.getElementText(listOfTopicsInTrendingTopics.get(0),5);
        commonFunctions.clickElement(listOfTopicsInTrendingTopics.get(0),5,"Click on topics");
        commonFunctions.clickElement(skip,5,"Skip");
        boolean isTopicsOpened = commonFunctions.isElementDisplayed(whatsApp,5,"Whats up") && commonFunctions.isElementDisplayed(twitter,5,"Twitter");
        return isRedirectToTopics && isTopicsOpened;
    }

    @Override
    public boolean checkLatestTopicNotDisplayIfSearchAnyKey() {
        return false;
    }

    @Override
    public boolean checkRedirectToSearchIfTabOnBackBtnFromLatestTopicStory() {
        boolean isRedirectToTopics = checkRedirectToStoryFromLatestTopicInSearchPage();
        commonFunctions.clickElement(back,5,"Back Btn");
        boolean isSearchPageDisplayed = commonFunctions.isElementDisplayed(searchHeader, 30, "Search Page Header");
        return isRedirectToTopics && isSearchPageDisplayed;
    }

    @Override
    public boolean checkRedirectToLatestNewsViewAllInSearchPage() {
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElement(viewAllOnSearchPage,5,"View All in Latest News");
        boolean isLatestNewsPageDisplayed = commonFunctions.getElementText(latestNewsHeader,10).equalsIgnoreCase("LATEST NEWS");
        return isLatestNewsPageDisplayed;
    }

    @Override
    public boolean checkResultDataWithSearchKeyword(String searchPageUrl, String name) {
        return false;
    }

    @Override
    public boolean checkTrendingNews(String searchPageUrl) {
        return false;
    }

    public boolean newsPhotosVideosOptionDisplayedInSearchResult(){
        boolean isLabelDisplayed;
        commonFunctions.toGetRidOfAdBeAndCTapHomeBtn(homeById,5);
        commonFunctions.clickElement(searchField,5,"Search Option");
        commonFunctions.clickElementIfDisplayed(textBoxInSearch,20,"Click on Search box");
        commonFunctions.sendKeysOnAndroid(textBoxInSearch,"Cricket");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(338,742,"Enter Key");
        commonFunctions.dummyWait(10);
        isLabelDisplayed = commonFunctions.getElementText(newsLabelOnSearchResultPage, 5).equalsIgnoreCase("News") && commonFunctions.getElementText(photosLabelOnSearchResultPage, 5).equalsIgnoreCase("Photos") && commonFunctions.getElementText(videosLabelOnSearchResultPage, 5).equalsIgnoreCase("Videos");
        return isLabelDisplayed;
    }
}
