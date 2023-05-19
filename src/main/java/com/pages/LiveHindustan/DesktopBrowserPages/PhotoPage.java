package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.ConstantPackage.LHConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import com.pages.LiveHindustan.ConstantPackage.LHConstants;


import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonPhotoPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PhotoPage extends CommonPhotoPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLH commonFunctionsWebLH;

    @FindBy(xpath = "//a[@title='साइन इन']")
    private static WebElement singInButton;

    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;

    @FindBy(id = "agree")
    private static WebElement continueButtonCookie;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//img[contains(@class,'logo-img')]")
    private static WebElement pageHeader;

    @FindBy(xpath = "//a[@class='big-news-title']")
    private static WebElement firstPramukhStory;

    @FindBy(xpath = "//div[@class='theiaStickySidebar']//h2/a")
    private static List<WebElement> allRHSWidgets;

    @FindBy(xpath = "//div[@class='wdgt-wrap']//h3/a")
    private static List<WebElement> allPramukhStoriesLink;

    @FindBy(xpath = "//div[@class='strtbtn-pht']/a[text()='शुरू से देखें']")
    private static WebElement suruseDekheButton;

    @FindBy(xpath = "//a[@class='ctgry']")
    private static List<WebElement> allPramuckStoriesGeoName;

    @FindBy(className = "ftr-cpyrgt")
    private static WebElement homePageFooter;

    @FindBy(xpath = "//section[contains(@class,'lft-cont')]//h2/a")
    private static List<WebElement> homePageTopics;

    @FindBy(className = "bid-ads-top")
    private static WebElement topAd;

    @FindBy(xpath = "//a[@id='srch-lnk']")
    private static WebElement serachButton;

    @FindBy(xpath = "//a[@title='ई-पेपर']")
    private static WebElement ePaperLink;

    @FindBy(xpath = "//section[@id='sehr-chune']/h3")
    private static WebElement sheharChuneSection;

    @FindBy(id = "sehr-chune-link")
    private static WebElement sheharChuneLink;

    @FindBy(xpath = "//input[@id='search-field']")
    private static WebElement searchField;

    @FindBy(xpath = "//span[@id='cls-sehr']")
    private static WebElement closeSheharChune;

    @FindBy(className = "closebtn btn")
    private static WebElement googlePopUpCloseButton;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;

    @FindBy(xpath = "(//div[@class='ft-sctn'])[4]//a")
    private static List<WebElement> partnerSites;

    @FindBy(xpath = "//div[contains(@class,'wdgt-nav')]//a")
    private static List<WebElement> pageSubMenuTitles;

    @FindBy(xpath = "//a[text()='टॉप वीडियो']")
    private static WebElement videoLinkHomePage;

    @FindBy(xpath = "//p[@class='moregallery']")
    private static WebElement aanyaGalleryIcon;

    @FindBy(xpath = "(//button[@id='pause-slide'])[1]")
    private static WebElement pausePhoto;

    @FindBy(xpath = "//button[@class='pausesvgbtn']")
    private static WebElement playPhoto;

    @FindBy(xpath = "(//div[@class='glry-cnt']//div)[1]")
    private static WebElement pauseStatus;

    @FindBy(xpath = "(//div[@class='glry-cps'])[1]")
    private static WebElement aagliGalleryTitle;

    @FindBy(xpath = "//a[@id='nxt-btn']")
    private static WebElement aagliGallery;

    @FindBy(xpath = "(//i[@class='epndicon'])[1]")
    private static WebElement expandIcon;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']")
    private static WebElement photoSubMenu;

    @FindBy(xpath = "//small[@class='glry-dgt']")
    private static List<WebElement> imageCount;

    @FindBy(xpath = "//span[contains(@class,'close cursor')]")
    private static WebElement aanyaGalleryCloseButton;

    @FindBy(xpath = "(//span[contains(@class,'close cursor')])[2]")
    private static WebElement agaleGalleryCloseButton;

    @FindBy(xpath = "(//div[@class='prmt-actn']//span)[1]")
    private static WebElement chhodDeButton;

    @FindBy(xpath = "(//div[@class='prmt-actn']//span)[2]")
    private static WebElement baneRaheButton;

    @FindBy(xpath = "//p[@id='tp-title']")
    private static WebElement photoTitle;

    @FindBy(xpath = "//a[@id='nxt-btn']")
    private static WebElement aanyaGalleryButton;

    @FindBy(xpath = "//button[@class='owl-prev']")
    private static WebElement prevButtonSlider;

    @FindBy(xpath = "//button[@class='owl-next']")
    private static WebElement nextButtonSlider;

    @FindBy(xpath = "//div[@class='wdgt-lft card-lg-2']/a[2]")
    private static List<WebElement> photoPageMainTitles;

    @FindBy(xpath = "(//div[@class='wdgt-lft card-lg-2']/a[2])[1]")
    private static WebElement firstPhoto;

    @FindBy(xpath = "(//small[@class='glry-dgt'])[3]")
    private static WebElement thirdPhoto;

    @FindBy(xpath = "//i[@class='epndicon']")
    private static List<WebElement> expandIconsOnPhotoPage;

    @FindBy(xpath = "//a[contains(@class,'shre-icn twt-icn')]")
    private static WebElement twitterIcon;

    @FindBy(xpath = "//a[contains(@class,'shre-icn fb-icn')]")
    private static WebElement facebookIcon;

    @FindBy(xpath = "//div[@class='brd-crum']/a")
    private static List<WebElement> breadCrumbCurrentPage;

    @FindBy(xpath = "//div[@class='tags']/a")
    private static List<WebElement> currentPageStoryRelatedWidgets;

    @FindBy(xpath = "//div[@class='vd-cnt']/h1")
    private static WebElement storyHeadLine;

    @FindBy(xpath = "//div[contains(@class,'main-wdgt glry-bg')]/h2/a")
    private static WebElement currnetStoryRelatedWidget;

    @FindBy(xpath = "//div[@class='moreglryflxwrap']//p")
    private static List<WebElement> photoGallery5;

    @FindBy(xpath = "(//div[contains(@class,'phtdtl-wrap content')])[1]//img[@class='owlslideimg']")
    private static List<WebElement> firstPhotoStoryRelatedImages;

    @FindBy(xpath = "(//a[@title='फोटो'])[1]")
    private static WebElement photoMainMenu;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(xpath = "//span[contains(@class,'closebtn cursor')]")
    private static WebElement photoGallery5CloseButton;

    @FindBy(xpath = "(//h1[@class='page-hdng'])[1]")
    private static WebElement currentPageFirstHeading;

    @FindBy(xpath = "(//span[@class='brd-crum-last'])[1]")
    private static WebElement firstStoryBreadCrumb;

    @FindBy(xpath = "//div[contains(@class,'wdgt-nav pg-nav')]//a")
    private static List<WebElement> allCurrentPageSubMenuOptions;

    @FindBy(xpath = "(//div[@class='stry-bdy'])[1]")
    private static WebElement firstSambandhitKhabreWidget;

    @FindBy(xpath = "//nav[contains(@class, 'hdr-menu')]/a[contains(@title, 'फोटो')]")
    private static WebElement photoMenu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[contains(text(), 'फोटो')]")
    private static WebElement photoWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> photoL2Menu;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='फोटो गैलरी']")
    private static WebElement photoGallerySection;
    @FindBy(xpath = "//a[@title='फोटो गैलरी']//ancestor::section[@class='pht-lndg-wrp']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> photoGalleryLinks;
    @FindBy(xpath = "(//h1[@class='page-hdng'])[1]")
    private static WebElement breadcrumbTitle;
    @FindBy(xpath = "(//div[@class='phtdtl-wrap content'])[1]//div[@class='brd-crum']/a")
    private static List<WebElement> breadCrumbFirstPhotoGallery;

    @FindBy(xpath = "//h1[contains(@class, 'wdgt-hdng')]/span")
    private static WebElement brdCrumRedFirst;

    @FindBy(xpath = "(//div[@class='wdgt-hdng']//a)[1]")
    private static WebElement brdCrumRedSecound;

    @FindBy(xpath = "(//h1[@class='wdgt-hdng']//a)[1]")
    private static WebElement brdCrumRedThird;

    @FindBy(xpath = "//div[contains(@class, 'nxt-artcl')]")
    private static List<WebElement> nextArticle;

    @FindBy(xpath = "(//div[contains(@class, 'article current')])[2]/div/div[contains(@class, 'img-cont')]")
    private static List<WebElement> nextArticlePhotos;

    @FindBy(xpath = "(//section[@class='podcast stryrltd'])[1]/div/div/a")
    private static List<WebElement> sambandhitPhotosUrl;
    @FindBy(xpath = "//span[@class='stryprv display']//i")
    private static WebElement photoGalleryPreviousBtn;
    @FindBy(xpath = "//span[@class='strynxt display']//i")
    private static WebElement photoGalleryNextBtn;



    public PhotoPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLH = CommonFunctionsWebLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    private static final String sheharChuneHindi = "शहर चुनें";
    private static final String signInHindi = "साइन इन";
    private static final String videoHindi = "वीडियो";
    private static final String cricketHindi = "क्रिकेट";
    private static final String photoHindi = "फोटो";


    @Override
    public boolean checkExpandPhotoDetailAndFunctionality() {
        commonFunctions.deleteCookiesAndNavigateToHomePage();
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isAanyaGalleryDisplay = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अगली गैलरी button");
        commonFunctions.clickElement(aanyaGalleryIcon, 20, "Close button for aanya gallery");
        boolean isAll5PhotoGalleryDisplay = isAllElementClickable(photoGallery5);
        commonFunctions.clickElement(photoGallery5CloseButton, 10, "Close button of 5 photo with aanya gallery on top");
        commonFunctions.clickElement(aanyaGalleryCloseButton, 20, "Close button for aanya gallery");
        String firstMainPhotoTextOfThePageAfterCloseButton = commonFunctions.getElementText(currentPageFirstHeading, 10);
        boolean isWholeExecutionForTheSameStoryTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, firstMainPhotoTextOfThePageAfterCloseButton);

        return isLandingPageIsOfPhotos && isAanyaGalleryDisplay && isAll5PhotoGalleryDisplay && isWholeExecutionForTheSameStoryTrue;
    }

    @Override
    public boolean checkPhotoDetailePage() {
        boolean isSliderButtonDisplay = true;
        boolean isUrlChangedIfPhotoSliderChanges = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isAanyaGalleryDisplay = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अगली गैलरी button");
        isSliderButtonDisplay &= commonFunctions.isElementDisplayed(prevButtonSlider, 10, "Previous slider button");
        isSliderButtonDisplay &= commonFunctions.isElementDisplayed(nextButtonSlider, 10, "Next slider button");
        String firstUrlAddress = commonFunctions.getCurrentURL();
        commonFunctions.clickElement(nextButtonSlider, 10);
        commonFunctions.dummyWait(1);
        String secondUrlAddress = commonFunctions.getCurrentURL();
        if (!commonFunctions.compareTexts(firstUrlAddress, secondUrlAddress)) {
            Utils.logStepInfo("During फोटो gallery slider URL have been changed");
            isUrlChangedIfPhotoSliderChanges = true;
        }
        return isLandingPageIsOfPhotos && isAanyaGalleryDisplay && isSliderButtonDisplay && isUrlChangedIfPhotoSliderChanges;
    }

    @Override
    public boolean checkBreadcrumbAndSocialSharingIsPresent() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        String openedStoryPageBreadCrumb = commonFunctions.getElementText(firstStoryBreadCrumb, 10);
        boolean isGalleryBreadcrumbTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, openedStoryPageBreadCrumb);
        String currentPageStoryHeadline = commonFunctions.getElementText(currentPageFirstHeading, 10);
        boolean isCurrentPageHeadlineTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, currentPageStoryHeadline);
        boolean isTwitterIconDisplay = commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter icon");
        boolean isFacebookIconDisplay = commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook icon");
        commonFunctions.refreshPage();
        boolean isURLChangesWhileScrollingPhotosTrue = isURLChangesWhileScrollingPhotos();
        return isLandingPageIsOfPhotos && isURLChangesWhileScrollingPhotosTrue && isGalleryBreadcrumbTrue && isCurrentPageHeadlineTrue && isTwitterIconDisplay && isFacebookIconDisplay;
    }

    @Override
    public boolean checkPhotoGalleryLandingPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        boolean isPageLoadProperly = !commonFunctions.getElementText(photoPageMainTitles.get(0), 10).isEmpty();

        return isLandingPageIsOfPhotos && isPageLoadProperly;
    }

    @Override
    public boolean checkPhotoGalleryLandingPageSubMenuClickable() {
        boolean isLandingOnPhotoGalleryPage = checkPhotoGalleryLandingPage();
        boolean isAllPhotoGallerySubMenuClickable = isAllElementClickable(allCurrentPageSubMenuOptions);
        return isLandingOnPhotoGalleryPage && isAllPhotoGallerySubMenuClickable;
    }
    @Override
    public boolean checkPhotoGalleryLandingPageSubMenu(){
        return false;
    }

    @Override
    public boolean checkL2SubMenuArePresentAndGivingOkStatusCode() {
        commonFunctionsWebLH.navigateToPhotoPage(photoMenu, photoWdgt, "WEB", "");
        String photoUrl = commonFunctions.getCurrentURL();
        int photoL2MenuSize = photoL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(photoL2Menu, photoL2MenuSize, photoUrl);
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkAurPadheButtonOnAmpPhotoLandingPage(){
        return false;
    }

    @Override
    public boolean checkBreadcrumbAndSocialSharingOnPhotoGallery(){
        boolean facebookFlag = false,twitterFlag=false;
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isLandingPageOnPhotos=navigateToPhotoPage();
        String firstStoryTitleOnPhotoLandingPage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstStoryTitleOnPhotoLandingPage);
        commonFunctions.dummyWait(5);
        String landingPageBreadcrumbTitle = commonFunctions.getElementText(breadcrumbTitle, 5);
        boolean isOpenedDetailPageRelated = commonFunctions.compareTexts(firstStoryTitleOnPhotoLandingPage.trim(), landingPageBreadcrumbTitle.trim());
        String photoDetailUrl = commonFunctions.getCurrentURL();

        if(commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook share option")) {
            commonFunctions.clickElementWithJS(facebookIcon, 10, "FaceBook Icon");
            commonFunctions.dummyWait(10);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 2));
            facebookFlag = commonFunctions.getCurrentURL().contains("facebook");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }
        if(commonFunctions.isElementDisplayed(twitterIcon, 10, "Twitter share option")) {
            commonFunctions.clickElementWithJS(twitterIcon, 10, "Twitter Icon");
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList1 = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList1.get(windowsList1.size() - 2));
            twitterFlag = commonFunctions.getCurrentURL().contains("twitter");
            commonFunctions.closeAllWindowsExceptMasterTab();
        }

        boolean brdCrumStatus = commonFunctionsWebLH.isAllElementsClickableAndGiving200Status(breadCrumbFirstPhotoGallery,3,photoDetailUrl,brdCrumRedFirst,brdCrumRedSecound,brdCrumRedThird);

        return isLandingPageOnPhotos && isOpenedDetailPageRelated && facebookFlag && twitterFlag && brdCrumStatus;
    }

    @Override
    public boolean checkPhotoGalleryAurPhotoDekheTabOnAmp(){
        return false;
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

    public boolean isAllElementClickable(List<WebElement> elementList) {
        boolean isAllelementClickableTrue = true;
        for (WebElement ele : elementList) {
            commonFunctions.moveToElementWithActions(ele, 10, commonFunctions.getElementText(ele, 5));
            if (commonFunctions.isElementClickable(ele, 10, "Pramukh stories")) {
                isAllelementClickableTrue &= true;
            } else {
                isAllelementClickableTrue &= false;
            }
        }
        return isAllelementClickableTrue;
    }

    public boolean isURLChangesWhileScrollingPhotos() {
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
                } else {
                    isURLChangesWhileScrollingPhotosTrue &= false;
                }
                firstUrlText = nextUrlText;
            } else
                break;
        }
        return isURLChangesWhileScrollingPhotosTrue;
    }

    public boolean checkSharingOptionForPhotoGallery(){
        boolean isTwitterOpened = false;
        boolean isFacebookOpened = false;
        boolean isLandingPageOnPhotos=navigateToPhotoPage();
        String firstPhotoText=commonFunctions.getElementText(photoPageMainTitles.get(0),10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10,firstPhotoText);
        String firstPhotoHeading=commonFunctions.getElementText(currentPageFirstHeading,10);
        boolean isSamePhotoDisplayed=commonFunctions.compareTexts(firstPhotoText,firstPhotoHeading);
        commonFunctions.scrollToElement(expandIcon,firstPhotoHeading);
        commonFunctions.clickElementWithActions(expandIcon,10,firstPhotoHeading);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithJS(twitterIcon,10,"Twitter icon");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList1 = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList1.get(windowsList1.size() - 2));
        System.out.println(commonFunctions.getCurrentURL());
        isTwitterOpened = commonFunctions.getCurrentURL().contains("twitter");
        commonFunctions.closeAllWindowsExceptMasterTab();

        commonFunctions.clickElementWithJS(facebookIcon,10,"Facebook icon");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 2));
        isFacebookOpened = commonFunctions.getCurrentURL().contains("facebook");
        System.out.println(commonFunctions.getCurrentURL());
        commonFunctions.closeAllWindowsExceptMasterTab();

        return isLandingPageOnPhotos && isSamePhotoDisplayed && isTwitterOpened && isFacebookOpened;

    }

    public boolean navigateToPhotoPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(photoMainMenu,10,"photo main menu");
        return commonFunctions.getCurrentURL().contains("/photos");
        }

    public boolean checkNextAndPreviousForPhotoGallery(){
        boolean isLandingPageOnPhotos=navigateToPhotoPage();
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        String firstGalleryUrl = commonFunctions.getCurrentURL();
        boolean isNextPreviousBtnPresent = commonFunctions.isElementDisplayed(photoGalleryPreviousBtn,5,"Previous Button");
        isNextPreviousBtnPresent &= commonFunctions.isElementDisplayed(photoGalleryNextBtn,5,"Next Button");
        commonFunctions.clickElementWithJS(photoGalleryNextBtn,5,"Next Button clicked");
        commonFunctions.dummyWait(10);
        String secondGalleryUrl = commonFunctions.getCurrentURL();
        boolean isUrlChanging = !commonFunctions.compareTexts(firstGalleryUrl,secondGalleryUrl);
        return isLandingPageOnPhotos && isNextPreviousBtnPresent && isUrlChanging;
    }

    public boolean checkChhodDePhotoGallery(){
        boolean isLandingPageOnPhotos=navigateToPhotoPage();
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isCloseButtonClicked=commonFunctions.clickElement(agaleGalleryCloseButton, 20, "Close button for agali gallery");
        boolean isChhodDeButtonClicked=commonFunctions.clickElement(chhodDeButton,10,"chhod-De Button");
        boolean photoBreadCrumb=commonFunctions.isElementDisplayed(photoSubMenu,10,"photo sub menu");

        return isLandingPageOnPhotos && isCloseButtonClicked && isChhodDeButtonClicked && photoBreadCrumb;
    }
    @Override
    public boolean checkNextPreviousButtonFunctionalityOnPhotoExpandView() {
        boolean isUrlChanged = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        String firstUrlAddress = commonFunctions.getCurrentURL();
        commonFunctions.clickElement(nextButtonSlider, 10);
        commonFunctions.dummyWait(1);
        String secondUrlAddress = commonFunctions.getCurrentURL();
        if (!commonFunctions.compareTexts(firstUrlAddress, secondUrlAddress)) {
            Utils.logStepInfo("During फोटो gallery slider URL have been changed");
            isUrlChanged = true;
        }
        clickNextSliderButtonTillNotDisabled();
        boolean isSliderWorking = commonFunctions.isElementDisplayed(aanyaGalleryButton, 10, "अगली गैलरी button");
        commonFunctions.clickElement(aanyaGalleryCloseButton, 10, "Close button for aanya gallery");
        return isLandingPageIsOfPhotos && isSliderWorking && isUrlChanged;
    }
    public void clickNextSliderButtonTillNotDisabled() {
        while (!commonFunctions.isElementDisplayed(aanyaGalleryButton, 10, "class")) {
            commonFunctions.clickElement(nextButtonSlider, 10);
        }
    }

    public boolean checkSwipeFunctionalityOnPhotoExpandView()
    {
        return false;
    }
    public boolean checkPhotoGalleryWidgetIsHaving5StoriesAndStatusIs200()
    {
        int photoGalleryWidgetSize = 6;
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        commonFunctions.dummyWait(5);
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(photoGallerySection,photoGalleryLinks,photoGalleryWidgetSize);
    }

    @Override
    public boolean checkShuruSeDekhenButtonFunctionalityOnPhotoDetailPage(){
        boolean urlChangeStatus = false;
        boolean isPhotoPageDisplayed=navigateToPhotoPage();
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(firstPhoto, 10);
        commonFunctions.clickElementWithJS(firstPhoto, 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToViewElement(thirdPhoto,"photo 3",10);
        commonFunctions.dummyWait(3);
        String thirdPhotoURL=commonFunctions.getCurrentURL();
        commonFunctions.refreshPage();
        boolean thirdPhotoURLAfterPageRefresh=commonFunctions.getCurrentURL().equals(thirdPhotoURL);
        commonFunctions.scrollToElement(suruseDekheButton, "Suruse Dekhe Button");
        boolean issuruSeDekheButtonDisplayed = commonFunctions.isElementDisplayed(suruseDekheButton, 5, "Suruse Dekhe Button");
        boolean issuruSeDekheButtonClickable=commonFunctions.clickElementWithJS(suruseDekheButton, 10, "Suruse Dekhe Button");
        commonFunctions.dummyWait(5);
        urlChangeStatus = commonFunctions.getCurrentURL().contains("-1-");

        return isPhotoPageDisplayed && urlChangeStatus && thirdPhotoURLAfterPageRefresh && issuruSeDekheButtonDisplayed && issuruSeDekheButtonClickable && urlChangeStatus;
    }

    @Override
    public boolean checkInfiniteScrollFunctionalityOnPhotoDetailPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        clickElementWithGivenText(topMenuOptions, LHConstants.PHOTO_HINDI);
        commonFunctions.dummyWait(5);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        String photoUrl = commonFunctions.getCurrentURL();
        commonFunctions.scrollToElement(nextArticle.get(0), "Next Article");
        commonFunctions.dummyWait(2);
        commonFunctions.scrollUntilElementFound(nextArticlePhotos.get(1));
        commonFunctions.dummyWait(2);
        String photoUrlAfterSwipe = commonFunctions.getCurrentURL();
        boolean infiniteScrollStatus = !photoUrl.equals(photoUrlAfterSwipe);
        if(infiniteScrollStatus == false){
            System.out.println("After infinite scroll url is not changing as before scroll url is:- "+photoUrl+" And after scroll url is:- "+photoUrlAfterSwipe);
            Utils.logStepInfo(infiniteScrollStatus, "After infinite scroll url is not changing as before scroll url is:- "+photoUrl+" And after scroll url is:- "+photoUrlAfterSwipe);
        }

        return infiniteScrollStatus && isLandingPageIsOfPhotos;
    }

    @Override
    public boolean checkRelatedPhotoGalleryWidgetOnPhotoDetailPageWithApi(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        clickElementWithGivenText(topMenuOptions, LHConstants.PHOTO_HINDI);
        commonFunctions.dummyWait(5);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        String photoUrl = commonFunctions.getCurrentURL();
        String str[] = photoUrl.split("-");
        String storyId = str[str.length-1];
        System.out.println("storyId:- "+storyId);
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyRelatedPhotoGalleryWidgetOnPhotoDetailPageWithApi");
        String apiUrl = params.get("DesktopApi");
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
        int photoSize = sambandhitPhotosUrl.size();
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
        boolean isPhotoDisplayedInExpandView=commonFunctionsWebLH.photoInExpandView(photoMainMenu,firstPhoto,expandIcon,aanyaGalleryIcon);
        boolean isBaneRaheWorking = baneRaheFunctionalityOnExpandViewOnPhotoDetailPage(aanyaGalleryCloseButton,baneRaheButton,aanyaGalleryIcon);

        return isPhotoDisplayedInExpandView && isBaneRaheWorking;
    }

    public boolean baneRaheFunctionalityOnExpandViewOnPhotoDetailPage(WebElement aanyaGalleryCloseButton,WebElement baneRaheButton,WebElement aanyaGalleryIcon){
        commonFunctions.moveToElementWithActions(aanyaGalleryCloseButton,10,"Close");
        boolean isCloseButtonClickable = commonFunctions.clickElement(aanyaGalleryCloseButton, 10, "Close button");
        boolean isBaneRaheClickable=commonFunctions.clickElement(baneRaheButton, 10, "bane rahe button");
        boolean isBaneRaheNotDisplayed = commonFunctions.isElementNotDisplayed(baneRaheButton, 10, "bane rahe");
        boolean isAanyaGalleryDisplayed = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरीी button");
        return isCloseButtonClickable && isBaneRaheClickable && isBaneRaheNotDisplayed && isAanyaGalleryDisplayed;
    }

    @Override
    public boolean checkAgliGalleryOptionShouldBePresentAndAfterClickingShouldMoveToNextGallery() {
        boolean isLandingPageOnPhotos=navigateToPhotoPage();
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(firstPhoto, 10);
        commonFunctions.clickElementWithJS(firstPhoto, 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isAanyaGalleryDisplayed = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरीी button");
        clickNextSliderButtonTillNotDisabled();
        boolean isAgliGalleryButtonDisplayed=commonFunctions.clickElement(aagliGallery,10,"अगली गैलरी button");
        commonFunctions.clickElement(pausePhoto,10,"pause photo");
        String nextGalleryTitle=commonFunctions.getElementText(aagliGalleryTitle);
        boolean compareTitles=commonFunctions.checkTextNotEquals(firstMainPhotoTextOfThePage,nextGalleryTitle,"photo title");

        return isAgliGalleryButtonDisplayed && isLandingPageOnPhotos && isAanyaGalleryDisplayed && compareTitles;
    }

    public boolean checkPauseOrPlayFunctionalityOnExpandViewOnPhotoDetailPage() {
        boolean pauseButtonStatus=false;
        boolean playButtonStatus=false;
        boolean isPhotoDisplayedInExpandView=commonFunctionsWebLH.photoInExpandView(photoMainMenu,firstPhoto,expandIcon,aanyaGalleryIcon);
        boolean isPausePhotoClickable=commonFunctions.clickElement(pausePhoto,10,"play button");
        String pausePhotoStatus=commonFunctions.getAttributeValue(pauseStatus,10,"class");
        if(pausePhotoStatus.contains("play"))
            pauseButtonStatus=true;
        boolean isPlayPhotoClickable=commonFunctions.clickElement(playPhoto,10,"pause button");
        String playPhotoStatus=commonFunctions.getAttributeValue(pauseStatus,10,"class");
        if(playPhotoStatus.contains("stop"))
            playButtonStatus=true;
       return isPhotoDisplayedInExpandView && isPausePhotoClickable && pauseButtonStatus && isPlayPhotoClickable && playButtonStatus;
    }
    @Override
    public boolean checkPhotoGalleryWidget() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isAanyaGalleryIcondDisplayTrue = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरी");
        commonFunctions.clickElement(aanyaGalleryCloseButton, 10, "Close button for aanya gallery");
        return isLandingPageIsOfPhotos && isAanyaGalleryIcondDisplayTrue;
    }
}

