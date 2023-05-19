package com.pages.LiveHindustan.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.ConstantPackage.LHConstants;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonPhotoPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class PhotoPage extends CommonPhotoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    private static CommonFunctionsMobileLH commonFunctionsMobileLH;

    private static String photoAMPURL = "https://www.livehindustan.com/amp_photos/";
    @FindBy(xpath = "(//div[@class='newscardbig']/a)[1]")
    private static WebElement firstPramukhStory;

    @FindBy(xpath = "//div[@id='home-top-menu']/a")
    private static List<WebElement> topMenuOptions;

    @FindBy(xpath = "//div[@class='news-title']//a")
    private static WebElement photoPageMainTitles;

    @FindBy(xpath = "//a[@class='thembtn']")
    private static WebElement aurPadheButton;

    @FindBy(xpath = "(//p[@class='wdgt-subtitle1'])[1]")
    private static WebElement firstPhotoGalleryStoryTitle;

    @FindBy(xpath = "(//h1[@class='stry-title'])[1]")
    private static WebElement breadcrumbTitle;

    @FindBy(xpath = "(//div[@class='story-content pht-dtl'])[1]/figure/amp-img")
    private static List<WebElement> allPhotoAvailableForGalleryDetailPage;

    @FindBy(xpath = "//div[@class='socialbutton']/amp-social-share[@type='whatsapp']")
    private static WebElement socialWhatsup;

    @FindBy(xpath = "//div[@class='bread-crumbs']")
    private static WebElement breadcrumbDetailPage;

    @FindBy(xpath = "//div[@class='socialbutton']/amp-social-share[@type='facebook']")
    private static WebElement socialFacebook;

    @FindBy(xpath = "//div[@class='socialbutton']/amp-social-share[@type='twitter']")
    private static WebElement socialTwitter;

    @FindBy(xpath = "//div[@class='socialbutton']/a")
    private static WebElement socialHameFollowKare;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[2]")
    private static WebElement breadCrumbsCategory;

    @FindBy(xpath = "(//*[@class='wdgt-title']//a)[1]")
    private static WebElement breadCrumbsCategoryNameNew;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[3]")
    private static WebElement breadCrumbsSection;

    @FindBy(xpath = "(//*[@class='wdgt-hdng']//a)[1]")
    private static WebElement breadCrumbsCategoryName;

    @FindBy(xpath = "(//div[@class='bread-crumbs']/a)[1]")
    private static WebElement breadCrumbsHindiNews;

    @FindBy(xpath = "//div[@class='wdgt-title']/h1/a")
    private static WebElement breadCrumbsCategoryNameHomePage;

    @FindBy(xpath = "//a[@class='thembtn' and text()='और फोटो देखें ']")
    private static WebElement aurPhotoDekheButton;

    @FindBy(xpath = "//div[contains(@class, 'lhs-menu')]/a[contains(@title, 'फोटो')]")
    private static WebElement photoMenu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[contains(text(), 'फोटो')]")
    private static WebElement photoWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> photoL2Menu;
    @FindBy(xpath = "//div[@class='bread-crumbs']//span")
    private static WebElement firstStoryBreadCrumb;
    @FindBy(xpath = "(//h1[@class='stry-title'])[1]")
    private static WebElement currentPageFirstHeading;
    @FindBy(xpath = "//amp-social-share[@type='twitter']")
    private static WebElement twitterIcon;
    @FindBy(xpath = "//amp-social-share[@type='facebook']")
    private static WebElement facebookIcon;
    @FindBy(xpath = "//amp-social-share[@type='whatsapp']")
    private static WebElement whatsappIcon;
    @FindBy(xpath = "//a[text()='हमें फॉलो करें']")
    private static WebElement humeFollowKreIcon;

    @FindBy(xpath = "//div[@class='itemcont']/p[contains(@class, 'wdgt-subtitle')]/a")
    private static List<WebElement> sambandhitPhotosUrl;

    @FindBy(xpath = "(//div[@class='story-content pht-dtl']/a)[1]")
    private static WebElement aurPhotoDekhe;

    @FindBy(xpath = "//div[@class='news-title']//a")
    private static WebElement photoPageMainTitle;

    private static final String photoHindi = "फोटो";

    public PhotoPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkExpandPhotoDetailAndFunctionality() {
        return false;
    }

    @Override
    public boolean checkPhotoDetailePage() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbAndSocialSharingIsPresent() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(photoAMPURL);
        return commonFunctionsMobileLH.checkBreadcrumbAndSocialSharingIsPresentInAMP(photoPageMainTitles,firstStoryBreadCrumb,currentPageFirstHeading,twitterIcon,facebookIcon,whatsappIcon,humeFollowKreIcon);
    }

    @Override
    public boolean checkPhotoGalleryLandingPage() {
        return false;
    }

    @Override
    public boolean checkPhotoGalleryLandingPageSubMenuClickable() {
        return false;
    }
    @Override
    public boolean checkPhotoGalleryLandingPageSubMenu() {
        return false;
    }

    @Override
    public boolean checkL2SubMenuArePresentAndGivingOkStatusCode() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyAllL2SubMenuArePresentAndGivingOkStatusCode");
        commonFunctionsMobileLH.navigateToPhotoPage(photoMenu, photoWdgt, "AMP", params.get("PhotoAmpUrl"));
        String photoUrl = commonFunctions.getCurrentURL();
        int photoL2MenuSize = photoL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(photoL2Menu, photoL2MenuSize, photoUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkAurPadheButtonOnAmpPhotoLandingPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(photoAMPURL);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(aurPadheButton, 5, "Aur Padhe Button");
        commonFunctions.clickElementWithJS(aurPadheButton, 5, "Aur Padhe Button");
        commonFunctions.dummyWait(5);
        String currentUrl = commonFunctions.getCurrentURL();
        return currentUrl.contains("page-2") && !currentUrl.contains("/amp");
    }

    @Override
    public boolean checkBreadcrumbAndSocialSharingOnPhotoGallery(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(photoAMPURL);
        commonFunctions.scrollDownToElement(firstPhotoGalleryStoryTitle);
        String firstStoryTitleOnPhotoLandingPage = commonFunctions.getElementText(firstPhotoGalleryStoryTitle, 5);
        commonFunctions.clickElementWithJS(firstPhotoGalleryStoryTitle, 5, firstStoryTitleOnPhotoLandingPage);
        String landingPageBreadcrumbTitle = commonFunctions.getElementText(breadcrumbTitle, 5);
        boolean isOpenedDetailPageRelated = commonFunctions.compareTexts(firstStoryTitleOnPhotoLandingPage.trim(), landingPageBreadcrumbTitle.trim());
        boolean allPhotoIsVisibleOfTheOpenedGallery = isAllElementsVisible(allPhotoAvailableForGalleryDetailPage);
        boolean breadcrumbDetailPageStatus = commonFunctions.isElementDisplayed(breadcrumbDetailPage, 5, "Breadcrumb On Detail Page");
        String photoGallleryUrl = commonFunctions.getCurrentURL();
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBreadcrumbAndSocialSharingRedirectionOnPhotoGalleryDetailPage");
        boolean socialStatus = commonFunctions.isElementDisplayed(socialWhatsup, 5, "Whatsup");
        socialStatus &= commonFunctions.isElementDisplayed(socialFacebook, 5, "Facebook");
        socialStatus &= commonFunctions.isElementDisplayed(socialTwitter, 5, "Twitter");
        socialStatus &= commonFunctions.isElementDisplayed(socialHameFollowKare, 5, "Hame Follow Kare");
        boolean socialSharingRedirection = commonFunctionsMobileLH.validateSocialSharingIconFunctionality(socialWhatsup, params.get("WhatsApp"), photoGallleryUrl, "WhatsApp");
        socialSharingRedirection &= commonFunctionsMobileLH.validateSocialSharingIconFunctionality(socialFacebook, params.get("Facebook"), photoGallleryUrl, "Facebook");
        socialSharingRedirection &= commonFunctionsMobileLH.validateSocialSharingIconFunctionality(socialTwitter, params.get("Twitter"), photoGallleryUrl, "Twitter");
        boolean breadCrumbsCatflag = commonFunctions.clickBreadCrumbsAndVerifyLanding(breadCrumbsCategory, 5, commonFunctions.getElementText(breadCrumbsCategory, 5).trim(), breadCrumbsCategoryNameNew);
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(photoAMPURL);
        commonFunctions.scrollDownToElement(firstPhotoGalleryStoryTitle);
        commonFunctions.clickElementWithJS(firstPhotoGalleryStoryTitle, 5, firstStoryTitleOnPhotoLandingPage);
        boolean breadCrumbsSecflag = commonFunctions.clickBreadCrumbsAndVerifyLanding(breadCrumbsSection, 5, commonFunctions.getElementText(breadCrumbsSection, 5).trim(), breadCrumbsCategoryNameNew);
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(photoAMPURL);
        commonFunctions.scrollDownToElement(firstPhotoGalleryStoryTitle);
        commonFunctions.clickElementWithJS(firstPhotoGalleryStoryTitle, 5, firstStoryTitleOnPhotoLandingPage);
        boolean breadCrumbsHomeflag = commonFunctions.clickBreadCrumbsAndVerifyLanding(breadCrumbsHindiNews, 10, "Hindi News", breadCrumbsCategoryNameHomePage);
        boolean breadCrumbsUrlflag = commonFunctions.getCurrentURL().trim().equals(globalVars.getURL().trim());
        return isOpenedDetailPageRelated && allPhotoIsVisibleOfTheOpenedGallery && breadcrumbDetailPageStatus && socialStatus && breadCrumbsCatflag && breadCrumbsSecflag && breadCrumbsHomeflag && breadCrumbsUrlflag && socialSharingRedirection;
    }

    @Override
    public boolean checkPhotoGalleryAurPhotoDekheTabOnAmp(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(photoAMPURL);
        commonFunctions.scrollDownToElement(firstPhotoGalleryStoryTitle);
        String firstStoryTitleOnPhotoLandingPage = commonFunctions.getElementText(firstPhotoGalleryStoryTitle, 5);
        commonFunctions.clickElementWithJS(firstPhotoGalleryStoryTitle, 5, firstStoryTitleOnPhotoLandingPage);
        String landingPageBreadcrumbTitle = commonFunctions.getElementText(breadcrumbTitle, 5);
        boolean isOpenedDetailPageRelated = commonFunctions.compareTexts(firstStoryTitleOnPhotoLandingPage.trim(), landingPageBreadcrumbTitle.trim());
        commonFunctions.scrollToElement(aurPhotoDekheButton, 5, "Aur Photo Dekhe Button");
        commonFunctions.clickElementWithJS(aurPhotoDekheButton, 5, "Aur Photo Dekhe Button");
        commonFunctions.dummyWait(3);
        String currentUrl = commonFunctions.getCurrentURL();
        return currentUrl.contains("-6-") && !currentUrl.contains("amp");
    }

    @Override
    public boolean checkSharingOptionForPhotoGallery() {
        return false;
    }

    @Override
    public boolean checkNextAndPreviousForPhotoGallery() {
        return false;
    }

    @Override
    public boolean checkChhodDePhotoGallery() {
        return false;
    }

    public void clickFirstPramukhStory() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(firstPramukhStory);
        commonFunctions.clickElement(firstPramukhStory, 10, "First pramukh khabar on home page");
    }

    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElementWithJS(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public boolean isAllElementsVisible(List<WebElement> elementList) {
        boolean isAllElementDisplay = false;
        for (int i = 0; i < elementList.size(); i++) {
            if (commonFunctions.scrollToElementView(elementList.get(i), 10, commonFunctions.getElementText(elementList.get(i), 5))) {
                Utils.logStepInfo(elementList.get(i).getText() + " display successfully.");
                isAllElementDisplay = true;
            } else {
                isAllElementDisplay = false;
            }
        }
        return isAllElementDisplay;
    }

    public boolean checkNextPreviousButtonFunctionalityOnPhotoExpandView() {
        return false;
    }
    public boolean checkSwipeFunctionalityOnPhotoExpandView()
    {
        return false;
    }
    public boolean checkPhotoGalleryWidgetIsHaving5StoriesAndStatusIs200()
    {
        return false;
    }

    @Override
    public boolean checkShuruSeDekhenButtonFunctionalityOnPhotoDetailPage(){
        return false;
    }

    @Override
    public boolean checkInfiniteScrollFunctionalityOnPhotoDetailPage(){
        return false;
    }


    @Override
    public boolean checkRelatedPhotoGalleryWidgetOnPhotoDetailPageWithApi(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.navigateToURL(photoAMPURL);
        commonFunctions.dummyWait(5);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitle, 10);
        commonFunctions.clickElementWithJS(photoPageMainTitle, 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        String photoUrl = commonFunctions.getCurrentURL();
        String str[] = photoUrl.split("-");
        String storyId = str[str.length-1];
        System.out.println("storyId:- "+storyId);
        String str1[] = storyId.split(".amp.");
        storyId = str1[0];
        System.out.println("storyId:- "+storyId);
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyRelatedPhotoGalleryWidgetOnPhotoDetailPageWithApi");
        String apiUrl = params.get("AndroidAmpApi");
        System.out.println("apiUrl:- "+apiUrl);
        apiUrl = apiUrl.replace("+stid+", storyId);
        System.out.println("apiUrl:- "+apiUrl);
        JSONObject apiResponce = commonFunctions.getResponseFromGetApi(apiUrl);
        JSONArray jsonArray = apiResponce.getJSONArray("items");

        HashSet<String> storyUrlSetApi = new HashSet<String>();
        HashSet<String> headlinelSetApi = new HashSet<String>();
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jObj = jsonArray.getJSONObject(i);
            storyUrlSetApi.add(jObj.getString("storyURL").trim());
            headlinelSetApi.add(jObj.getString("headline").trim().replace("\u200B", ""));
        }

        System.out.println("storyUrlSetApi:- "+storyUrlSetApi);
        System.out.println("headlinelSetApi:- "+headlinelSetApi);

        HashSet<String> storyUrlSetUi = new HashSet<String>();
        HashSet<String> headlinelSetUi = new HashSet<String>();
        commonFunctions.scrollUntilElementFound(aurPhotoDekhe);
        commonFunctions.scrollToElement(aurPhotoDekhe, "Aur Photo Dekhe");
        int photoSize = sambandhitPhotosUrl.size();
        System.out.println("photoSize:- "+photoSize);
        for(int j=0;j<photoSize;j++){
            commonFunctions.scrollToElement(sambandhitPhotosUrl.get(j), "Sambandhit Photos");
            commonFunctions.dummyWait(2);
            storyUrlSetUi.add(commonFunctions.getAttributeValue(sambandhitPhotosUrl.get(j), 10, "href").trim());
            headlinelSetUi.add(commonFunctions.getElementText(sambandhitPhotosUrl.get(j), 10).trim().replace("\u200B", ""));
        }

        System.out.println("storyUrlSetUi:- "+storyUrlSetUi);
        System.out.println("headlinelSetUi:- "+headlinelSetUi);

        boolean urlStatus = commonFunctions.matchTwoSet(storyUrlSetApi, storyUrlSetUi);
        urlStatus &= storyUrlSetApi.size()>0 && storyUrlSetUi.size()>0;
        if(!urlStatus){
            System.out.println("Related photo gallery widget is not displaying photos according to the API response as expected urls:- "+storyUrlSetApi+" but found:- "+storyUrlSetUi);
            Utils.logStepInfo(urlStatus, "Related photo gallery widget is not displaying photos according to the API response as expected urls:- "+storyUrlSetApi+" but found:- "+storyUrlSetUi);
        }

        boolean headlineStatus = commonFunctions.matchTwoSet(headlinelSetApi, headlinelSetUi);
        headlineStatus &= headlinelSetApi.size()>0 && headlinelSetUi.size()>0;
        if(!headlineStatus){
            System.out.println("Related photo gallery widget is not displaying photos according to the API response as expected headline:- "+headlinelSetApi+" but found:- "+headlinelSetUi);
            Utils.logStepInfo(headlineStatus, "Related photo gallery widget is not displaying photos according to the API response as expected headline:- "+headlinelSetApi+" but found:- "+headlinelSetUi);
        }

        return isLandingPageIsOfPhotos && urlStatus && headlineStatus;
    }

    @Override
    public boolean checkBaneRaheFunctionalityOnExpandViewOnPhotoDetailPage() {
        return false;
    }

    @Override
    public boolean checkAgliGalleryOptionShouldBePresentAndAfterClickingShouldMoveToNextGallery() {
        return false;
    }

    @Override
    public boolean checkPauseOrPlayFunctionalityOnExpandViewOnPhotoDetailPage() {
        return false;
    }
    @Override
    public boolean checkPhotoGalleryWidget() {
        return false;
    }
}