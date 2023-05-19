package com.pages.LiveHindustan.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.ConstantPackage.LHConstants;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonPhotoPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
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

    @FindBy(xpath = "(//h1[@class='page-hdng'])[1]")
    private static WebElement currentPageFirstHeading;

    @FindBy(xpath = "(//div[@class='wdgt-lft card-lg-2']/a[2])[1]")
    private static WebElement firstPhoto;

    @FindBy(xpath = "(//a[@title='फोटो'])[1]")
    private static WebElement photoMainMenu;

    @FindBy(xpath = "//span[contains(@class,'close cursor')]")
    private static WebElement aanyaGalleryCloseButton;

    @FindBy(xpath = "//a[@title='फोटो']")
    private static WebElement photoMegaMenu;

    @FindBy(xpath = "//div[@class='wdgt-lft card-lg-2']/a[2]")
    private static List<WebElement> photoPageMainTitles;

    @FindBy(xpath = "(//i[@class='epndicon'])[1]")
    private static WebElement expandIcon;

    @FindBy(xpath = "(//div[@class='glry-cps'])[1]")
    private static WebElement aagliGalleryTitle;

    @FindBy(xpath = "//div[@class='glry-cnt']/div[@class='plybtnsvg play']")
    private static WebElement pauseStatus;

    @FindBy(xpath = "//div[@class='glry-cnt']/div[@class='plybtnsvg stop']")
    private static WebElement pauseStatus1;

    @FindBy(xpath = "//button[@class='pausesvgbtn']")
    private static WebElement playPhoto;

    @FindBy(xpath = "(//button[@id='pause-slide'])[1]")
    private static WebElement pausePhoto;

    @FindBy(xpath = "//a[@id='nxt-btn']")
    private static WebElement aagliGallery;

    @FindBy(xpath = "//div[contains(@class,'wdgt-nav pg-nav')]//a")
    private static List<WebElement> allCurrentPageSubMenuOptions;

    @FindBy(xpath = "//a[@class='big-news-title']")
    private static WebElement firstPramukhStory;

    @FindBy(xpath = "(//div[@class='stry-bdy'])[1]")
    private static WebElement firstSambandhitKhabreWidget;

    @FindBy(xpath = "//p[@class='moregallery']")
    private static WebElement aanyaGalleryIcon;

    @FindBy(xpath = "(//div[@class='prmt-actn']//span)[2]")
    private static WebElement baneRaheButton;

    @FindBy(xpath = "//div[@class='moreglryflxwrap']//p")
    private static List<WebElement> photoGallery5;

    @FindBy(xpath = "//span[contains(@class,'closebtn cursor')]")
    private static WebElement photoGallery5CloseButton;

    @FindBy(xpath = "//nav[contains(@class, 'hdr-menu')]/a[contains(@title, 'फोटो')]")
    private static WebElement photoMenus;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[contains(text(), 'फोटो')]")
    private static WebElement photoWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> photoL2Menu;
    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;
    @FindBy(xpath = "//button[@class='owl-next']")
    private static WebElement nextButtonSlider;
    @FindBy(xpath = "//a[@id='nxt-btn']")
    private static WebElement aanyaGalleryButton;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='फोटो गैलरी']")
    private static WebElement photoGallerySection;
    @FindBy(xpath = "//a[@title='फोटो गैलरी']//ancestor::section[@class='pht-lndg-wrp']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> photoGalleryLinks;
    @FindBy(xpath = "(//span[@class='brd-crum-last'])[1]")
    private static WebElement firstStoryBreadCrumb;
    @FindBy(xpath = "//a[contains(@class,'shre-icn twt-icn')]")
    private static WebElement twitterIcon;
    @FindBy(xpath = "//a[contains(@class,'shre-icn fb-icn')]")
    private static WebElement facebookIcon;

    @FindBy(xpath = "(//div[contains(@class,'phtdtl-wrap content')])[1]//img[@class='owlslideimg']")
    private static List<WebElement> firstPhotoStoryRelatedImages;
    @FindBy(xpath = "//div[@class='ads']")
    private static List<WebElement> adsOnAnyPage;
    @FindBy(xpath = "(//div[@class='phtdtl-wrap content'])[1]//div[@class='brd-crum']/a")
    private static List<WebElement> breadCrumbFirstPhotoGallery;

    @FindBy(xpath = "//h1[contains(@class, 'wdgt-hdng')]/span")
    private static WebElement brdCrumRedFirst;

    @FindBy(xpath = "(//div[@class='wdgt-hdng']//a)[1]")
    private static WebElement brdCrumRedSecound;

    @FindBy(xpath = "(//h1[@class='wdgt-hdng']//a)[1]")
    private static WebElement brdCrumRedThird;
    @FindBy(xpath = "(//h1[@class='page-hdng'])[1]")
    private static WebElement breadcrumbTitle;
    @FindBy(xpath = "//a[contains(@class,'shre-icn wtsp-icn')]")
    private static WebElement whatsappIcon;
    @FindBy(xpath = "(//a[@title='फोटो'])[1]")
    private static WebElement photoMainMenu1;
    @FindBy(xpath = "(//span[contains(@class,'close cursor')])[2]")
    private static WebElement agaleGalleryCloseButton;

    @FindBy(xpath = "(//div[@class='prmt-actn']//span)[1]")
    private static WebElement chhodDeButton;
    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']")
    private static WebElement photoSubMenu;

    @FindBy(xpath = "//div[@class='strtbtn-pht']/a[text()='शुरू से देखें']")
    private static WebElement suruseDekheButton;

    @FindBy(xpath = "//div[contains(@class, 'nxt-artcl')]")
    private static List<WebElement> nextArticle;

    @FindBy(xpath = "(//section[@class='podcast stryrltd'])[1]/div/div/a")
    private static List<WebElement> sambandhitPhotosUrl;

    @FindBy(xpath = "//div[@id='anya-gallery']")
    private static WebElement aanyaGallery;

    private static final String photoHindi = "फोटो";


    public PhotoPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkExpandPhotoDetailAndFunctionality() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(photoMegaMenu, 10, "photo main menu");
        commonFunctions.dummyWait(5);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.moveToElementWithActions(expandIcon, 10, "Expand button ");
        commonFunctions.clickElementWithJS(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        boolean isAanyaGalleryDisplay = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अगली गैलरी button");
        commonFunctions.clickElementWithJS(aanyaGalleryIcon, 10, "अगली गैलरी button for aanya gallery");
        boolean isAll5PhotoGalleryDisplay = isAllElementClickable(photoGallery5);
        commonFunctions.moveToElementWithActions(photoGallery5CloseButton, 10, "close icon");
        commonFunctions.clickElementWithJS(photoGallery5CloseButton, 20, "Close button of 5 photo with aanya gallery on top");
        commonFunctions.moveToElementToClick(aanyaGalleryCloseButton);
        String firstMainPhotoTextOfThePageAfterCloseButton = commonFunctions.getElementText(currentPageFirstHeading, 10);
        boolean isWholeExecutionForTheSameStoryTrue = commonFunctions.compareTexts(firstMainPhotoTextOfThePage, firstMainPhotoTextOfThePageAfterCloseButton);

        return isLandingPageIsOfPhotos && isAanyaGalleryDisplay && isAll5PhotoGalleryDisplay && isWholeExecutionForTheSameStoryTrue;
    }

    @Override
    public boolean checkPhotoDetailePage() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbAndSocialSharingIsPresent() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsMobileLH.clickElementWithGivenTextWithJS(topMenuOptions, photoHindi);
        commonFunctions.dummyWait(5);
        return commonFunctionsMobileLH.checkBreadcrumbAndSocialSharingIsPresentOnMwebForIos(photoPageMainTitles,firstStoryBreadCrumb,currentPageFirstHeading,twitterIcon,facebookIcon,firstPhotoStoryRelatedImages,adsOnAnyPage);
    }


    @Override
    public boolean checkPhotoGalleryLandingPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(photoMegaMenu, 10, "photo main menu");
        commonFunctions.dummyWait(5);
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
    public boolean checkPhotoGalleryLandingPageSubMenu() {
        return false;
    }

    @Override
    public boolean checkL2SubMenuArePresentAndGivingOkStatusCode() {
        commonFunctionsMobileLH.navigateToPhotoPage(photoMenus, photoWdgt, "MWEBIOS", "");
        String photoUrl = commonFunctions.getCurrentURL();
        int photoL2MenuSize = photoL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(photoL2Menu, photoL2MenuSize, photoUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkAurPadheButtonOnAmpPhotoLandingPage() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbAndSocialSharingOnPhotoGallery() {
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        return commonFunctionsMobileLH.checkBreadcrumbAndSocialSharingOnPhotoGalleryOnMweb(photoPageMainTitles,breadcrumbTitle,facebookIcon,twitterIcon,whatsappIcon,breadCrumbFirstPhotoGallery,brdCrumRedFirst,brdCrumRedSecound,brdCrumRedThird);

    }

    @Override
    public boolean checkPhotoGalleryAurPhotoDekheTabOnAmp() {
        return false;
    }

    @Override
    public boolean checkSharingOptionForPhotoGallery() {
        return commonFunctionsMobileLH.sharingOptionForPhotoGalleryIOS(firstPhoto,currentPageFirstHeading,twitterIcon,facebookIcon,photoMainMenu);
    }

    @Override
    public boolean checkNextAndPreviousForPhotoGallery() {
        return false;
    }

    @Override
    public boolean checkChhodDePhotoGallery() {
        boolean isLandingPageOnPhotos = navigateToPhotoPage();
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElement(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isCloseButtonClicked = commonFunctions.clickElement(agaleGalleryCloseButton, 20, "Close button for agali gallery");
        boolean isChhodDeButtonClicked = commonFunctions.clickElement(chhodDeButton, 10, "chhod-De Button");
        boolean photoBreadCrumb = commonFunctions.isElementDisplayed(photoSubMenu, 10, "photo sub menu");

        return isLandingPageOnPhotos && isCloseButtonClicked && isChhodDeButtonClicked && photoBreadCrumb;
    }
    public boolean navigateToPhotoPage() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(photoMainMenu, 10, "photo main menu");
        return commonFunctions.getCurrentURL().contains("/photos");
    }

    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.isElementDisplayed(elementList.get(i), 10);
                commonFunctions.clickElementWithJS(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public boolean isAllElementClickable(List<WebElement> elementList) {
        boolean isAllElementClickableTrue = true;
        for (WebElement ele : elementList) {
            commonFunctions.moveToElementWithActions(ele, 10, commonFunctions.getElementText(ele, 20));
            if (commonFunctions.isElementClickable(ele, 10, "Pramukh stories")) {
                isAllElementClickableTrue &= true;
            } else {
                isAllElementClickableTrue &= false;
            }
        }
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkNextPreviousButtonFunctionalityOnPhotoExpandView() {
        return false;
    }

    @Override
    public boolean checkSwipeFunctionalityOnPhotoExpandView() {
        boolean isUrlChanged = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, LHConstants.PHOTO_HINDI);
        commonFunctions.dummyWait(2);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
        commonFunctions.dummyWait(1);
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 40, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollDownToElement(expandIcon);
        commonFunctions.clickElementWithJS(expandIcon, 20, "Expand button for " + firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        String firstUrlAddress = commonFunctions.getCurrentURL();
        commonFunctions.dummyWait(5);
        commonFunctions.swipeElementUsingTouchAction(0, 0, 0, 100);
        commonFunctions.dummyWait(15);
        String secondUrlAddress = commonFunctions.getCurrentURL();
        System.out.println("firstUrlAddress:- "+firstUrlAddress);
        System.out.println("secondUrlAddress:- "+secondUrlAddress);
        if (!commonFunctions.compareTexts(firstUrlAddress, secondUrlAddress)) {
            Utils.logStepInfo("During फोटो gallery slider URL have been changed");
            isUrlChanged = true;
        }
        boolean isSliderWorking = commonFunctions.isElementDisplayed(aanyaGallery);
        return isLandingPageIsOfPhotos && isSliderWorking && isUrlChanged;
    }
    public boolean checkPhotoGalleryWidgetIsHaving5StoriesAndStatusIs200()
    {
        int photoGalleryWidgetSize = 6;
        commonFunctions.navigateToURL(globalVars.getURL());
        clickElementWithGivenText(topMenuOptions, photoHindi);
        commonFunctions.dummyWait(5);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(photoGallerySection,photoGalleryLinks,photoGalleryWidgetSize, "WidgitValuesForRandomNumber");
    }


    @Override
    public boolean checkShuruSeDekhenButtonFunctionalityOnPhotoDetailPage(){
        boolean urlChangeStatus = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        clickElementWithGivenText(topMenuOptions, LHConstants.PHOTO_HINDI);
        commonFunctions.dummyWait(5);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        for(int k = 0; k < 6; k++) {
            commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
            commonFunctions.dummyWait(5);
        }

        commonFunctions.refreshPage();
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(10);
        try {
            commonFunctions.scrollToElement(suruseDekheButton, "Suruse Dekhe Button");
        }catch(Exception e){
            System.out.println("Suruse Dekhe Button is not displaying");
            Utils.logStepInfo("Suruse Dekhe Button is not displaying");
        }
        boolean suruSeDekheButtonStatus = commonFunctions.isElementDisplayed(suruseDekheButton, 5, "Suruse Dekhe Button");
        if(suruSeDekheButtonStatus == false){
            System.out.println("Suruse Dekhe Button is not displaying");
            Utils.logStepInfo("Suruse Dekhe Button is not displaying");
        }else{
            commonFunctions.clickElementWithJS(suruseDekheButton, 10, "Suruse Dekhe Button");
            commonFunctions.waitForPageToLoad();
            commonFunctions.dummyWait(5);
            System.out.println("URL:- "+commonFunctions.getCurrentURL());
            urlChangeStatus = commonFunctions.getCurrentURL().contains("-1-");
            if(urlChangeStatus == false){
                System.out.println("Shuru se dekhen button is not navigated to 1st image");
                Utils.logStepInfo("Shuru se dekhen button is not navigated to 1st image");
            }
        }
        return urlChangeStatus && isLandingPageIsOfPhotos && suruSeDekheButtonStatus;
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
        for(int k = 0; k < 3; k++) {
            commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
            commonFunctions.dummyWait(5);
        }
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
        String apiUrl = params.get("IosWebApi");
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
        boolean isPhotoDisplayedInExpandView=commonFunctionsMobileLH.photoInExpandViewIOS(photoMainMenu,firstPhoto,expandIcon,aanyaGalleryIcon);
        boolean isBaneRaheWorking = baneRaheFunctionalityOnExpandViewOnPhotoDetailPageIOS(aanyaGalleryCloseButton,baneRaheButton,aanyaGalleryIcon);

        return isPhotoDisplayedInExpandView && isBaneRaheWorking;
    }

    public boolean checkAgliGalleryOptionShouldBePresentAndAfterClickingShouldMoveToNextGallery() {
        navigateToPhotoPage();
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(firstPhoto, 10);
        commonFunctions.clickElementWithJS(firstPhoto, 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElementView(expandIcon,10,"expand");
        commonFunctions.clickElement(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isAanyaGalleryDisplayed = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरीी button");
        commonFunctions.dummyWait(40);
        if(!commonFunctions.isElementDisplayed(aagliGallery,20,"अगली गैलरी button")){
            commonFunctions.dummyWait(30);
        }
        commonFunctions.isElementDisplayed(aagliGallery,20,"अगली गैलरी button");
        boolean isAgliGalleryButtonDisplayed=commonFunctions.clickElementWithJS(aagliGallery,10,"अगली गैलरी button");
        String nextGalleryTitle=commonFunctions.getElementText(aagliGalleryTitle);
        boolean compareTitles=commonFunctions.checkTextNotEquals(firstMainPhotoTextOfThePage,nextGalleryTitle,"photo title");

        return isAgliGalleryButtonDisplayed && isAanyaGalleryDisplayed && compareTitles;
    }

    public boolean checkPauseOrPlayFunctionalityOnExpandViewOnPhotoDetailPage() {
        boolean pauseButtonStatus=false;
        boolean playButtonStatus=false;
        boolean isPhotoDisplayedInExpandView=commonFunctionsMobileLH.photoInExpandViewIOS(photoMainMenu,firstPhoto,expandIcon,aanyaGalleryIcon);
        boolean isPausePhotoClickable=commonFunctions.clickElementWithJS(pausePhoto);
        String pausePhotoStatus=commonFunctions.getAttributeValue(pausePhoto,"class");
        if(pausePhotoStatus.contains("ply"))
            pauseButtonStatus=true;
        boolean isPlayPhotoClickable=commonFunctions.clickElementWithJS(playPhoto);
        String playPhotoStatus=commonFunctions.getAttributeValue(pauseStatus1,"class");
        if(playPhotoStatus.contains("stop"))
            playButtonStatus=true;
        return isPhotoDisplayedInExpandView && isPausePhotoClickable && pauseButtonStatus && isPlayPhotoClickable && playButtonStatus;
    }

    public boolean baneRaheFunctionalityOnExpandViewOnPhotoDetailPageIOS(WebElement aanyaGalleryCloseButton,WebElement baneRaheButton,WebElement aanyaGalleryIcon){
        commonFunctions.clickElement(aanyaGalleryCloseButton);
        boolean isBaneRaheClickable=commonFunctions.clickElement(baneRaheButton, 10, "bane rahe button");
        boolean isBaneRaheNotDisplayed = commonFunctions.isElementNotDisplayed(baneRaheButton, 10, "bane rahe");
        boolean isAanyaGalleryDisplayed = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरीी button");
        return isBaneRaheClickable && isBaneRaheNotDisplayed && isAanyaGalleryDisplayed;
    }
    @Override
    public boolean checkPhotoGalleryWidget() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsMobileLH.clickElementWithGivenTextWithJS(topMenuOptions, LHConstants.PHOTO_HINDI);
        commonFunctions.dummyWait(5);
        boolean isLandingPageIsOfPhotos = commonFunctions.getCurrentURL().contains("photos");

        commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
        commonFunctions.dummyWait(1);

        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(photoPageMainTitles.get(0), 10);
        commonFunctions.scrollToElementView(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.clickElementWithJS(photoPageMainTitles.get(0), 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);

        commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
        commonFunctions.dummyWait(5);

        commonFunctions.clickElementWithJS(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        boolean isAanyaGalleryIcondDisplayTrue = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरी");
        commonFunctions.clickElementWithJS(aanyaGalleryCloseButton, 10, "Close button for aanya gallery");
        return isLandingPageIsOfPhotos && isAanyaGalleryIcondDisplayTrue;
    }
}
