package com.pages.HindustanTimes.android_mweb;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

import java.util.List;
import java.util.Locale;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonFunctions.CommonFunctionsMobile;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.pages.HindustanTimes.generic.CommonSearchPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class SearchPage extends CommonSearchPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;
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

    @FindBy(id="searchbox2")
    private static WebElement searchBarInput;

    @FindBy(xpath="//div[@class='btnExplore']")
    private static WebElement hamburgerButton;

    @FindBy(xpath="//a[@href='/entertainment']/em")
    private static WebElement entertainmentOption;

    Response response=null;

    @FindBy(xpath="(//div[@data-vars-storytype='story']//h2//a)[1]")
    private static WebElement titleArticle;

    @FindBy(xpath="(//div[contains(@class,'catName')]//a)[1]")
    private static WebElement sectionSubSection;

    @FindBy(xpath="//div[@data-vars-orderid=1]//div[@class='sortDec']")
    private static WebElement summaryArticle;

    @FindBy(className="breadcrumbs")
    private static WebElement breadcrumb;

    @FindBy(xpath="//div[@data-vars-orderid=7]//div[contains(@class,'catName')]//a")
    private static WebElement subSection;

    @FindBy(xpath = "(//div[@class='viewAll']//a)[1]")
    private static WebElement openFullStory;

    public SearchPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        apiValidation = ApiValidation.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean clickOnHamburgerMenu() {
        boolean isExplorermenuClickSuccessful=false;
        try{
            isExplorermenuClickSuccessful= commonFunctions.clickElementWithJS(hamburgerButton, 20,"hamburgerButton");
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
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL Successful");
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

        try{
           isCheckSearchBarDisplayed=commonFunctions.isElementDisplayed(searchButtonHamburgerMenu,10,"searchBarHamburgerMenu");
            commonFunctions.isElementEnabled(searchButtonHamburgerMenu,10,"searchBarInput");
            commonFunctions.clickElementWithActions(searchButtonHamburgerMenu,20,"searchBarInput");
            isKeyEntered=commonFunctions.sendKey(searchBarInput,"Latest",20);
            isEnterKeyPressed=commonFunctions.sendKeyBoolean(searchBarInput, String.valueOf(Keys.ENTER));
            commonFunctions.dummyWait(10);
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(currentURL.equals(globalVars.getProdUrl()+"search?q=Latest")) {
                isCheckSearchBarDisplayed = true;
            }
            response = apiValidation.getResponseFromURIWithParams(params[0]+params[1], params[2]);
            commonFunctions.isElementDisplayed(titleArticle,20,"titleArticle");
            titleString=commonFunctions.getElementText(titleArticle);
            String titleFromAPI = JsonPath.parse(response.getBody().asString()).read("$.content[0].mobileHeadline");
            System.out.println(titleFromAPI+" :API Responses");
            System.out.println(titleString +" :UI response");
            if(titleFromAPI.contains(titleString)) {
                commonFunctions.textToReport("check title successful");
                titleApi = true;
            }
            //Commented extra code which is not required as per the jira id
/*
            commonFunctions.scrollToElementViewAndClick(openFullStory,20,"openFullStory");
            if(commonFunctions.isElementDisplayed(summaryArticle,20,"summaryArticle")) {
                String summaryFromUI = commonFunctions.getElementText(summaryArticle);
                if (null != summaryFromUI && !summaryFromUI.isEmpty()) {
                    String summaryFromAPI = JsonPath.parse(response.getBody().asString()).read("$.content[0].summary");
                    if (summaryFromAPI.contains(summaryFromUI)) {
                        commonFunctions.textToReport("check summary successful");
                        summaryApi = true;
                    }
                }else{
                    commonFunctions.textToReport("summary has not been displayed on UI");
                }
            }

            commonFunctions.clickElement(sectionSubSection,20,"sectionSubSection");
            if(commonFunctions.isElementDisplayed(breadcrumb,20,"breadcrumb") ) {
                String breadCrumbText = commonFunctions.getElementText(breadcrumb);
                String getBreadCrumbText[] = breadCrumbText.split("/");
                String sectionFromUI= getBreadCrumbText[1];
                if (null != sectionFromUI && !sectionFromUI.isEmpty()) {
                    String sectionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.content[0].metadata.section");
                    if (sectionFromUI.toLowerCase(Locale.ROOT).contains(sectionFromAPI)) {
                        commonFunctions.textToReport("check section successful");
                        sectionApi = true;
                    }
                }else{
                    commonFunctions.textToReport("section has not been found on UI");
                }
            }*/

            /* here subSection is optional if subSection has found on UI then only it will check
             * Latest search article always not been having subSection */
            /*if(commonFunctions.isElementDisplayed(breadcrumb,20,"breadcrumb") ) {
                String breadCrumbTxt = commonFunctions.getElementText(breadcrumb);
                String getBreadCrumbTxt[] = breadCrumbTxt.split("/");
                if(getBreadCrumbTxt.length >2) {
                    String subSectionFromUI = getBreadCrumbTxt[2];
                    if (null != subSectionFromUI && !subSectionFromUI.isEmpty()) {
                        boolean subSectionApi=false;
                        String subSectionFromAPI = JsonPath.parse(response.getBody().asString()).read("$.content[0].metadata.subSection");
                        if (subSectionFromUI.toLowerCase(Locale.ROOT).contains(subSectionFromAPI)) {
                            commonFunctions.textToReport("check subSection successful");
                            subSectionApi = true;
                        }
                        return subSectionApi;
                    }
                }else{
                    commonFunctions.textToReport("subsection has not been found on UI");
                }
            }*/
        }catch(Exception e){
            e.printStackTrace();
        }
        return isCheckSearchBarDisplayed && titleApi && isKeyEntered && isEnterKeyPressed;
    }

	@Override
	public boolean checkSearchIsWorking(String params[]) {
        commonFunctions.navigateToURL(globalVars.getURL());
        //boolean hamburgerMenu = clickOnHamburgerMenu();
        boolean searchButton = checkSearchButtonDisplayedAndClickable(params);
        return searchButton;
	}

	@Override
	public boolean clickOnExplorerMenu() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkSearchIsWorking(String text) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean CheckSearchButtonIsWorking(String[] params) {
        return false;
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
        return false;}

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
    public boolean checkResultDataWithSearchKeyword(String searchPageUrl, String name) {
        return false;
    }

    @Override
    public boolean checkTrendingNews(String searchPageUrl) {
        return false;
    }
}
