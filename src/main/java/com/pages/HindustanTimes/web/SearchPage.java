
package com.pages.HindustanTimes.web;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

import java.util.List;

import com.utils.Utils;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsWeb;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonSearchPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;

import io.restassured.response.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends CommonSearchPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static ApiValidation apiValidation;
    String storyID;
    Response response=null;
    String titleString;

    @FindBy(xpath = "(//a[@class='sign-in'])[1]")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin") //login
    private static WebElement signInButtonMainSignInPage;
    @FindBy(xpath = "//div[text()='Use another account']")
    private static WebElement useAnotherAccountGmailSignInPage;
    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;
    @FindBy(id = "account_name_text_field")
    private static WebElement emailAppleSignInPage;
    @FindBy(id = "password_text_field")
    private static WebElement passwordAppleSignInPage;
    @FindBy(id = "sign-in")
    private static WebElement appleSignInNextButton;
    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;
    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;
    @FindBy(xpath = "//input[@type='submit']") //input[@value='Log In']
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "(//div[@class='logged-in']//span[2])[1]")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "(//a[@class='sign-out'])[1]")
    private static WebElement LogoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(xpath="//div[@class='searchBar']")
    private static WebElement searchBarHamburgerMenu;

    @FindBy(xpath="//div[@class='searchLink']//a")
    private static WebElement searchButtonHamburgerMenu;

    @FindBy(xpath="//div[@class='searchInput']//input")
    private static WebElement searchBarInput;

    @FindBy(xpath="//div[@class='btnExplore']/strong")
    private static WebElement exploreButton;

    @FindBy(xpath="//a[@href='/entertainment']/em")
    private static WebElement entertainmentOption;

    @FindBy(className = "close")
    private static WebElement clsButton;

    @FindBy(xpath="//div[@id='oldSearch']//h3[@class='hdg3']/a")
    private static WebElement titleArticle;

    @FindBy(xpath="//div[contains(@class,'fullStory')]/div[2]")
    private static WebElement summaryArticle;

    @FindBy(xpath="//div[contains(@class,'fullStory')]/div[2]//li")
    private static WebElement summaryLiArticle;


    @FindBy(xpath="//div[@data-vars-orderid=1]//div[contains(@class,'catName')]//a")
    private static WebElement section;

    @FindBy(xpath="//div[@data-vars-orderid=7]//div[contains(@class,'catName')]//a")
    private static WebElement subSection;

    @FindBy(xpath="/html/body/section[1]/section/div[2]/a[2]")
    private static WebElement sectionSubSection;

    @FindBy(className="breadcrumbs")
    private static WebElement breadcrumb;

    @FindBy(xpath="//div[contains(@class,'cartHolder')]/h3/a")
    private static WebElement openFullStory;

    @FindBy(id="loadResult")
    private static WebElement searchResult;
    @FindBy(xpath="(//span[text()='Trending News'])[1]")
    private static WebElement trendingNews;
    @FindBy(id="searchbox2")
    private static WebElement searchInputBox;
    @FindBy(xpath="//div[@id='newSearchId']//h3[@class='hdg3']/a")
    private static List<WebElement> ListOfStoryAfterSearch;

    public SearchPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        apiValidation = ApiValidation.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");

        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean clickOnExplorerMenu() {
        boolean isExplorermenuClickSuccessful=false;
        try{
            isExplorermenuClickSuccessful= commonFunctions.clickElementWithJS(exploreButton, 20,"exploreButton");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExplorermenuClickSuccessful;
    }

    public boolean clickOnEntertainmentSection() {

        boolean isClickOnEntertainmentSuccessful=false;
        try{
        isClickOnEntertainmentSuccessful = commonFunctions.clickElement(entertainmentOption, 20,"entertainmentOption");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isClickOnEntertainmentSuccessful;
    }

    public boolean checkRedirectionToEntertainmentSection() {

        boolean isRedirectToEntertainmentSuccessful=false;
        try{
        String currentURL = commonFunctions.getCurrentURL("getCurrentURL Successful");
        if(currentURL.equals(globalVars.getProdUrl()+"entertainment")) {
            isRedirectToEntertainmentSuccessful = true;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isRedirectToEntertainmentSuccessful;
    }

    public boolean checkSearchButtonDisplayedAndClickable(String params[]) {
        boolean isCheckSearchBarDisplayed=false;
        boolean isKeyEntered=false;
        boolean isEnterKeyPressed=false;
        boolean titleApi=false;
        boolean summaryApi=false;
        String summaryFromUI="";

        try{
            isCheckSearchBarDisplayed=commonFunctions.isElementDisplayed(searchButtonHamburgerMenu,20,"searchBarHamburgerMenu");
            commonFunctions.isElementEnabled(searchButtonHamburgerMenu,20,"searchBarInput");
            commonFunctions.clickElementWithActions(searchButtonHamburgerMenu,20,"searchBarInput");
            isKeyEntered=commonFunctions.validateSendKey(searchBarInput,"Latest",20);
            isEnterKeyPressed=commonFunctions.sendKeyBoolean(searchBarInput, String.valueOf(Keys.ENTER));
            commonFunctions.dummyWait(10);
            String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
            if(currentURL.equals(globalVars.getProdUrl()+"search?q=Latest")) {
                isCheckSearchBarDisplayed = true;
            }
            response = apiValidation.getResponseFromURIWithParams(params[6]+params[7], params[4]);
            titleString=commonFunctions.getElementText(titleArticle);
            String titleFromAPI = JsonPath.parse(response.getBody().asString()).read("$.content[0].mobileHeadline");
            String t= titleFromAPI.replaceAll("amp;","").replaceAll("&nbsp;","");
            if(t.contains(titleString.trim())) {
                commonFunctions.textToReport("check title successful");
                titleApi = true;
            }
            commonFunctions.scrollToElementViewAndClick(openFullStory,20,"openFullStory");
            commonFunctions.dummyWait(10);

            String id = commonFunctions.extractStoryID(commonFunctions.getCurrentURL());
            response = apiValidation.getResponseFromURI(params[6],params[3]+id);
            if(commonFunctions.isElementDisplayed(summaryArticle,20,"summaryArticle")) {
                  summaryFromUI = commonFunctions.getElementText(summaryArticle);
            }
            else if (commonFunctions.isElementDisplayed(summaryLiArticle,10,"summaryLiArticle")) {
                  summaryFromUI = commonFunctions.getElementText(summaryLiArticle);
            }
                if (null != summaryFromUI && !summaryFromUI.isEmpty()) {
                    String summaryFromAPI = JsonPath.parse(response.getBody().asString()).read("$.summary");
                    String s = summaryFromAPI.replaceAll("&nbsp","");
                    if (s.contains(summaryFromUI)) {
                        commonFunctions.textToReport("check summary successful");
                        summaryApi = true;
                    }
                }else{
                    commonFunctions.textToReport("summary has not been displayed on UI");
                }


        }catch(Exception e){
            e.printStackTrace();
        }

        return isCheckSearchBarDisplayed && titleApi && summaryApi && isKeyEntered && isEnterKeyPressed ;
    }
    @Override
    public boolean checkSearchIsWorking(String params[]) {
       commonFunctions.navigateToURL(globalVars.getURL());
//        boolean explorerMenu = clickOnExplorerMenu();
        boolean searchButton = checkSearchButtonDisplayedAndClickable(params);
        return searchButton;
    }

	@Override
	public boolean checkSearchIsWorking(String text) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean CheckSearchButtonIsWorking(String params[]) {
       commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(searchButtonHamburgerMenu,20,"searchBarHamburgerMenu");
        commonFunctions.isElementEnabled(searchButtonHamburgerMenu,20,"searchBarInput");
        commonFunctions.clickElementWithActions(searchButtonHamburgerMenu,20,"searchBarInput");
        commonFunctions.validateSendKey(searchBarInput,"Latest",20);
        commonFunctions.sendKeyBoolean(searchBarInput, String.valueOf(Keys.ENTER));
        commonFunctions.dummyWait(5);
        String searchResultText = commonFunctions.getElementText(searchResult,5);
        boolean isSearchResultPageDisplayed=commonFunctions.checkTextContains("Showing result for Latest...", searchResultText, "Result Page");
        return isSearchResultPageDisplayed;
    }

    @Override
    public boolean checkSearchButtonRedirection() {
        return false;
    }

    @Override
    public boolean checkSearchPageRedirectionFromExplore() {
        return false;
    }

    @Override
    public boolean checkSearchButtonRedirectionProfilePage() {
        return false;
    }

    @Override
    public boolean checkEPaperOption() {
        return false;
    }

    @Override
    public boolean checkEPaperOptionFromExplore() {
        return false;
    }

    @Override
    public boolean checkSearchOptionInCricketPage() {
        return false;
    }

    @Override
    public boolean checkSearchOptionWhenTabOnBackButton() {
        return false;
    }

    @Override
    public boolean checkStoryPageOnSearchPage() {
        return false;
    }
    public boolean checkLensIconTextBoxAndVoiceIcon() {
        return false;
    }

    @Override
    public boolean checkViewAllOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkDefaultLatestNewsOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkCricketNewsOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkSearchIsWorkingOnSearchPage() {
        return false;
    }

    public boolean checkWatermarkRemovedIfEnterAnyChar() {
        return false;
    }

    @Override
    public boolean checkNewsPhotosVideosLabelsOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkDefaultNewsDisplayedOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkNumberOfSearchResultsDisplayedOnSearchPage(String expectedMessage) {
        return false;
    }

    @Override
    public boolean checkStoryTappableOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkSearchOptionOnHomePage() { return false; }

    @Override
    public boolean checkSearchOptionOnQuickreadsPage() { return false; }

    @Override
    public boolean checkSearchOptionOnPremiumPage() { return false; }

    @Override
    public boolean checkSearchOptionOnExplorePage() { return false; }

    @Override
    public boolean  checkSelectedBottomNavTab(MobileElement ele, String text) { return false; }

    @Override
    public boolean checkSearchOnCricketPage() {
        return false;
    }

    @Override
    public boolean checkSearchOnPremiumPage() {
        return false;
    }

    @Override
    public boolean checkSearchOnQuickReadsPage() {
        return false;
    }

    @Override
    public boolean checkSearchOnHomePage() {
        return false;
    }

    @Override
    public boolean checkBottomNavOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkBottomNavNavigationOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkHorizontalLineInEachStoryInNewsOnSearchPage() {
        return false;
    }

    @Override
    public boolean checkShareStoryOptionInSearchPage() {
        return false;
    }

    @Override
    public boolean checkRedirectToSectionFromSearchPage() {
        return false;
    }

    @Override
    public boolean checkScrollDownInNewsSectionINSearchPage() {
        return false;
    }

    @Override
    public boolean checkRedirectToPhotosInSearchPage() {
        return false;
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
        return false;
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
        return false;
    }

    @Override
    public boolean checkRedirectToStoryFromLatestTopicInSearchPage() {
        return false;
    }

    @Override
    public boolean checkLatestTopicNotDisplayIfSearchAnyKey() {
        return false;
    }

    @Override
    public boolean checkRedirectToSearchIfTabOnBackBtnFromLatestTopicStory() {
        return false;
    }

    @Override
    public boolean checkRedirectToLatestNewsViewAllInSearchPage() {
        return false;
    }

    @Override
    public boolean checkTrendingNews(String searchPageUrl) {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isShowing = commonFunctions.isElementDisplayed(searchButtonHamburgerMenu, 10, "search menu");
        commonFunctions.clickElement(searchButtonHamburgerMenu, 10, "search menu");
        isShowing &= commonFunctions.checkCurrentPageUrlEqualToExpectedUrl(searchPageUrl, "Search page");
        commonFunctions.scrollUsingAction(trendingNews, "trending news");
        isShowing &= commonFunctions.isElementDisplayed(trendingNews, 10, "trending news on search page");
        return isShowing;
    }

    @Override
    public boolean checkResultDataWithSearchKeyword(String searchPageUrl,String name) {
        boolean isShowing = checkTrendingNews(searchPageUrl);
        commonFunctions.sendKey(searchInputBox, name, 10);
        commonFunctions.sendKeysWithEnter(searchInputBox, 5);
        commonFunctions.dummyWait(5);
            for (WebElement ele : ListOfStoryAfterSearch) {
                String str = ele.getText();
               if (str.contains(name)){
                   isShowing &=true;
                   Utils.logStepInfo(true, "Found: " + name + " Story");
                   break;
               }else {
                   isShowing &=false;
                   Utils.logStepInfo(false, "Not Found: " + name + " Story");
               }
            }
        return isShowing;
    }

}
