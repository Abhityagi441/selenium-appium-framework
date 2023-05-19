package com.pages.HT_TECH.web;

import com.pages.HT_TECH.commonFunctions.CommonFunctionWebHT;
import com.pages.HT_TECH.generic.CommonHomePage;
import com.commonFunctions.CommonFunctionsWeb;
import com.utils.GlobalVars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonHomePage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    private static CommonFunctionWebHT commonFunctionsHt;
    public static String storyName;

    @FindBy(xpath = "//div[@class='ltSide']/a")
    private static List<WebElement> topLeftWidget;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath="//div[@class='rtSide']/a")
    private static List<WebElement> topRightWidget;

    @FindBy(xpath="//div[@class='sponsoredBox']")
    private static WebElement sponsoredLink;

    @FindBy(xpath = "//div[@class='logoDateWrapper']//a")
    private static WebElement HtLogo;

    @FindBy(xpath="(//div[@class='storyContent']//h1)[1]")
    private static WebElement firstStoryDetailPage;

    @FindBy(xpath = "//div[@class='sixRatioNine']//h1")
    private static WebElement firstStory;

    @FindBy(xpath="//section[@class='topSectionWrapper']//a")
    private static List<WebElement> allTopStoriesLink;

    @FindBy(xpath="(//div[@class='rtSide']//a)[1]")
    private static WebElement rightFistStory;

    @FindBy(xpath="//div[@class='rtSide']//a")
    private static List<WebElement> rightStoryLink;

    @FindBy(xpath="//div[@class='headerMainWrapper']//div[@class='d-flex']//a[@title='facebook']")
    private static WebElement fbIcon;

    @FindBy(xpath="//div[@class='headerMainWrapper']//div[@class='d-flex']//a[@title='twitter']")
    private static WebElement twitterIcon;

    @FindBy(xpath="//div[@class='headerMainWrapper']//div[@class='d-flex']//a[@title='youtube']")
    private static WebElement youtubeIcon;

    @FindBy(xpath="//section[@class='topGadgetsWrapper allProductsAvailable']//span[@data-current='Mobiles']")
    private static WebElement topGadgetMobile;

    @FindBy(xpath="//section[@class='topGadgetsWrapper allProductsAvailable']//span[@data-current='Tablets']")
    private static WebElement topGadgetTablet;

    @FindBy(xpath="//section[@class='topGadgetsWrapper allProductsAvailable']//span[@data-current='Laptops']")
    private static WebElement topGadgetLaptop;

    @FindBy(xpath="//section[@class='topGadgetsWrapper allProductsAvailable']//a[@data-current='popular']")
    private static WebElement topGadgetPopular;

    @FindBy(xpath="//section[@class='topGadgetsWrapper allProductsAvailable']//a[@data-current='latest']")
    private static WebElement topGadgetLatest;

    @FindBy(xpath="//section[@class='topGadgetsWrapper allProductsAvailable']//a[@data-current='upcoming']")
    private static WebElement topGadgetUpcoming;

    @FindBy(xpath="//div[@id='topGadgets']//a[@class='parentWrapper']")
    private static List<WebElement> topGadgetLinks;

    @FindBy(xpath="//section[@class='gadgetsSearch allProductsAvailable']//span[@data-current='Mobiles']")
    private static WebElement gadgetSearchMobile;

    @FindBy(xpath="//section[@class='gadgetsSearch allProductsAvailable']//span[@data-current='Tablets']")
    private static WebElement gadgetSearchTablet;

    @FindBy(xpath="//section[@class='gadgetsSearch allProductsAvailable']//span[@data-current='Laptops']")
    private static WebElement gadgetSearchLaptops;

    @FindBy(xpath="//section[@class='gadgetsSearch allProductsAvailable']//a[@data-current='brand']")
    private static WebElement gadgetSearchBrand;

    @FindBy(xpath="//section[@class='gadgetsSearch allProductsAvailable']//a[@data-current='budget']")
    private static WebElement gadgetSearchBudget;

    @FindBy(xpath="//section[@class='gadgetsSearch allProductsAvailable']//a[@data-current='features']")
    private static WebElement gadgetSearchFeature;

    @FindBy(xpath="//div[@id='gadgetsSearch']//a")
    private static List<WebElement> gadgetSearchMobileBudgetFeaturesLinks;

    @FindBy(xpath="//div[@id='gadgetsSearch']//div[@class='logoBoxInner']/div/a")
    private static List<WebElement> gadgetSearchMobileBrandLinks;

    @FindBy(xpath="//section[@class='comparison allProductsAvailable']//a[@data-current='Mobiles']")
    private static WebElement gadgetComparisonMobile;

    @FindBy(xpath="//section[@class='comparison allProductsAvailable']//a[@data-current='Tablets']")
    private static WebElement gadgetComparisonTablet;

    @FindBy(xpath="//section[@class='comparison allProductsAvailable']//a[@data-current='Laptops']")
    private static WebElement gadgetComparisonLaptop;

    @FindBy(xpath="//section[@class='comparison allProductsAvailable']//div[@id='mobileComparison']//a")
    private static List<WebElement> gadgetMobileComparisonLinks;

    @FindBy(xpath="//section[@class='comparison allProductsAvailable']//div[@id='tabletComparison']//a")
    private static List<WebElement> gadgetTabletComparisonLinks;

    @FindBy(xpath="//section[@class='comparison allProductsAvailable']//div[@id='laptopComparison']//a")
    private static List<WebElement> gadgetLaptopComparisonLinks;

    @FindBy(xpath="//section[@class='popularReview']//a[@data-anchor='mobile_popuparReview']")
    private static WebElement popularReviewsMobile;

    @FindBy(xpath="//section[@class='popularReview']//a[@data-anchor='gaming_popuparReview']")
    private static WebElement popularReviewsGaming;

    @FindBy(xpath="//section[@class='popularReview']//a[@data-anchor='home-appliances_popuparReview']")
    private static WebElement popularReviewsHomeAppliances;

    @FindBy(xpath="//section[@class='popularReview']//a[@data-anchor='laptops-pc_popuparReview']")
    private static WebElement popularReviewsLaptops;

    @FindBy(xpath="//section[@class='popularReview']//a[@data-anchor='tv_popuparReview']")
    private static WebElement popularReviewsTV;

    @FindBy(xpath="//section[@class='popularReview']//a[@data-anchor='wearables_popuparReview']")
    private static WebElement popularReviewsWearables;

    @FindBy(xpath="//section[@class='popularReview']//a[@class='sliderBox mobile_popuparReview']")
    private static List<WebElement> popularReviewsMobileLinks;

    @FindBy(xpath="//section[@class='popularReview']//a[@class='sliderBox gaming_popuparReview']")
    private static List<WebElement> popularReviewsGamingLinks;

    @FindBy(xpath="//section[@class='popularReview']//a[@class='sliderBox home-appliances_popuparReview']")
    private static List<WebElement> popularReviewsHomeAppliancesLinks;

    @FindBy(xpath="//section[@class='popularReview']//a[@class='sliderBox laptops-pc_popuparReview']")
    private static List<WebElement> popularReviewsLaptopsLinks;

    @FindBy(xpath="//section[@class='popularReview']//a[@class='sliderBox tv_popuparReview']")
    private static List<WebElement> popularReviewsTVLinks;

    @FindBy(xpath="//section[@class='popularReview']//a[@class='sliderBox wearables_popuparReview']")
    private static List<WebElement> popularReviewsWearablesLinks;

    @FindBy(xpath="//h3[text()='Latest Videos']")
    private static WebElement LatestVideo;

    @FindBy(xpath="//div[@class='sectionTitle']/a[@class='viewAllBtn greyArrow']")
    private static WebElement latestVideoViewAll;

    @FindBy(xpath="//section[@class='videoSection']//div[@class='wrapAll']//a")
    private static List<WebElement> latestVideosLink;

    @FindBy(xpath="//div[@id='gadgetsSearch']//a[contains(@class,'viewMoreBrand')]")
    private static WebElement brandsViewAllButton;

    @FindBy(xpath="//section[@class='photGallery']//h3[text()='Photo Gallery']//following-sibling::a")
    private static WebElement photoGalleryViewAll;

    @FindBy(xpath="(//section[@class='photGallery'])[1]//div[@class='sliderWrapper scrollView']//a")
    private static List<WebElement> photoGalleryLink;

    @FindBy(xpath="//section[@class='webStories']//h3[text()='Web Stories']//following-sibling::a")
    private static WebElement webStoriesSeeAll;

    @FindBy(xpath="//section[@class='webStories']//div[@class='sliderWrapper scrollView']//a")
    private static List<WebElement> webStoriesLink;

    @FindBy(xpath="(//section[@class='photGallery'])//h3[text()='Latest News']//following-sibling::a")
    private static WebElement latestNewsViewall;

    @FindBy(xpath="(//section[@class='photGallery'])[2]//div[@class='sliderWrapper scrollView']//a")
    private static List<WebElement> latestNewsLink;

    @FindBy(css="[data-vars-widget-name=RecommendedForYou] a.viewAllBtn")
    private static WebElement recommenderViewAll;

   // @FindBy(xpath="//h3[text()='Recommended For You']")
    @FindBy(css="[data-vars-widget-name='RecommendedForYou'] h3")
    private static WebElement recommender;

   // @FindBy(xpath="//section[@class='photGallery widgetTracking similarstorysliderecommended']//div[@class='wrapAll']//a")
    @FindBy(xpath="//section[@data-vars-widgettype='recommendedForYou']//div[@class='wrapAll']//a")
    private static List<WebElement> recommenderForYouLink;

    @FindBy(xpath="(//div[@class='rtCard'])[1]//following-sibling::a")
    private static List<WebElement> tipsAndTrick;

    @FindBy(xpath="//h3[text()='Editor’s Pick']//following-sibling::div/a")
    private static List<WebElement> editorPick;

    @FindBy(xpath="//h3[text()='Editor’s Pick']")
    private static WebElement editorPickHead;

    @FindBy(xpath="//a[text()='Tips & Tricks']")
    private static WebElement headingTip;

    @FindBy(xpath="//div[@id='topGadgets']/a")
    private static WebElement viewPopularTab;

    @FindBy(xpath="//div[@id='desktop-header-ad']")
    private static WebElement toMostAd;

    @FindBy(xpath="//div[@id='adslot4']")
    private static WebElement bottomAd;

    @FindBy(xpath="//div[@id='adslot1']")
    private static WebElement rH1Ad;

    @FindBy(xpath="//div[@id='adslot2']")
    private static WebElement rhs2Ad;

    @FindBy(xpath="//div[@id='adslot3']")
    private static WebElement rhs3Ad;

    public static HomePage homePage;
    public static HomePage getInstance(){
        if(homePage==null){
            homePage= new HomePage();
        }
        return homePage;
    }

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt=CommonFunctionWebHT.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
    @Override
    public boolean checkLeftTopWidget(){
        boolean isLeftTopWidgetPresent=true;
       commonFunctions.isElementDisplayed(topLeftWidget,10,"leftTopWidget");
       int leftWidgetSize= topLeftWidget.size();
       if(leftWidgetSize==3){
           isLeftTopWidgetPresent=true;
       }
       else
           isLeftTopWidgetPresent=false;
       return isLeftTopWidgetPresent;
    }

    @Override
    public boolean checkRightTopWidget(){
        boolean isRightTopWidgetPresent=true;
        commonFunctions.isElementDisplayed(topRightWidget,10,"rightTopWidget");
        int rightWidgetSize= topRightWidget.size();
        if(rightWidgetSize==4){
            isRightTopWidgetPresent=true;
        }
        else
            isRightTopWidgetPresent=false;
        return isRightTopWidgetPresent;
    }

    @Override
    public boolean checkHTAutoRedirection(){
        boolean isReloadingSuccessful = false;
        try {
            commonFunctions.isElementDisplayed(HtLogo, 20,"HtLogo");
            commonFunctions.clickElement(HtLogo, 20, "Hindustan Times Logo");
            String currentURL = commonFunctions.getCurrentURL("getCurrentURL successful");
            if (currentURL.equals(globalVars.getURL())) {
                isReloadingSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReloadingSuccessful;
    }
    @Override
    public boolean checkFirstHeadline(){
        boolean checkFirstHeadlineStatus;
        String expectedHeadline = commonFunctions.getElementText(firstStory);
        commonFunctions.clickElement(firstStory, 10, "First Story");
        commonFunctions.waitForURLContains(".html");
        String actualHeadline = commonFunctions.getElementText(firstStoryDetailPage);
        commonFunctions.navigateToHomePage();
        checkFirstHeadlineStatus = commonFunctions.checkTextContains(expectedHeadline, actualHeadline, "First Story Headline in UI");
        return checkFirstHeadlineStatus;
    }
    @Override
    public boolean checkHomePageRHSAdsAreDisplayed() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollDownOnce();
        commonFunctions.scrollUp();
        commonFunctions.scrollToElement(rightFistStory,"scroll to first story");
        boolean checkRHS1Ad=commonFunctions.isElementDisplayed(rH1Ad, 20, "HomePage RHS First Ad");
        commonFunctions.scrollToElement(editorPickHead,"2nd ad");
        boolean checkRHS2Ad=commonFunctions.isElementDisplayed(rhs2Ad, 20,"RSH Second Ad");
        commonFunctions.scrollToElement(photoGalleryViewAll,"scrolled to photoGallery");
        boolean checkRHS3Ad=commonFunctions.isElementDisplayed(rhs3Ad, 20,"RSH Third Ad");
        return checkRHS1Ad && checkRHS2Ad && checkRHS3Ad;
    }
@Override
    public boolean checkAdDisplayingTopAd() {
        boolean isTopAd;
        isTopAd = commonFunctions.isElementDisplayed(toMostAd, 20, "topAd");
        return isTopAd;
    }

    @Override
    public boolean checkBottomAdDisplaying() {
        boolean isTopAd;
        commonFunctions.scrollDownOnce();
        isTopAd = commonFunctions.isElementDisplayed(bottomAd, 20, "bottomAd");
        return isTopAd;
    }


    @Override
    public boolean checkTopStoriesWidget(){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        int topStoriesSize = allTopStoriesLink.size();
        isAllElementClickableTrue = commonFunctionsHt.isAllElementClickableAndReturns200(allTopStoriesLink);
        return topStoriesSize == 8 && isAllElementClickableTrue;
    }

    @Override
    public boolean checkTipTrick(){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        int tipTrickSize = tipsAndTrick.size();
        commonFunctions.scrollToElement(headingTip,"tip and trick");
        isAllElementClickableTrue = commonFunctionsHt.isAllElementClickableAndReturns200(tipsAndTrick);
        return tipTrickSize == 5 && isAllElementClickableTrue;
    }

    @Override
    public boolean checkEditorPick(){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        int tipTrickSize = editorPick.size();
        commonFunctions.scrollToElement(editorPickHead,"editorPick");
        isAllElementClickableTrue = commonFunctionsHt.isAllElementClickableAndReturns200(editorPick);
        return tipTrickSize == 5 && isAllElementClickableTrue;

    }

    @Override
    public boolean checkRightStoriesWidget(){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        isAllElementClickableTrue = isAllElementClickableAndReturns200(topRightWidget);
        return  isAllElementClickableTrue;
    }

    @Override
    public boolean checkSponsoredLink(){
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        commonFunctions.scrollDownOnce();
        commonFunctions.scrollUp();
        isUrlClickable &= commonFunctions.clickElementWithJS(sponsoredLink, 5, "sponsoredLink");
        isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        commonFunctions.navigateToURL(globalVars.getURL());
        return isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementClickableAndReturns200(List<WebElement> allTopStoriesLink){
        boolean isUrlClickable = true;
        boolean isLinkReturn200=true;
        for (int i = 0; i <= allTopStoriesLink.size() - 1; i++) {
            String storyTitle = allTopStoriesLink.get(i).getText();
            commonFunctions.dummyWait(5);
            isUrlClickable &= commonFunctions.clickElementWithJS(allTopStoriesLink.get(i), 15, storyTitle + " story");
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            commonFunctions.navigateToURL(globalVars.getURL());
        }
        return  isUrlClickable && isLinkReturn200;
    }



    @Override
    public boolean checkFbIcon() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        boolean isFbLinkClickable = commonFunctions.isElementClickable(fbIcon, 10, "fb button");
        commonFunctions.clickElement(fbIcon, 10, "fb button");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean isCurrentUrlOfFb = commonFunctions.getCurrentURL().contains("facebook");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 2));
        return  isFbLinkClickable && isCurrentUrlOfFb;
    }

    @Override
    public boolean checkTwitterIcon() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        boolean isTwitterLinkClickable = commonFunctions.isElementClickable(twitterIcon, 10, "twitter button");
        commonFunctions.clickElement(twitterIcon, 10, "twitter button");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean isCurrentUrlOfTwitter = commonFunctions.getCurrentURL().contains("twitter");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 2));
        return  isTwitterLinkClickable && isCurrentUrlOfTwitter;
    }

    @Override
    public boolean checkyoutubeIcon() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isYoutubeLinkClickable = commonFunctions.isElementClickable(youtubeIcon, 10, "youtube button");
        commonFunctions.clickElement(youtubeIcon, 10, "youtube button");
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean isCurrentUrlOfYoutube = commonFunctions.getCurrentURL().contains("youtube");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 2));
        return  isYoutubeLinkClickable && isCurrentUrlOfYoutube;
    }

    @Override
    public boolean checkTopGadgetTablet(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(topGadgetTablet,10,"topGadgetTablet");
        commonFunctions.clickElement(topGadgetPopular,10,"topGadgetPopular");
        boolean isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetTablet,topGadgetPopular);
        commonFunctions.clickElement(topGadgetLatest,10,"topGadgetLatest");
        boolean isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetTablet,topGadgetLatest);
        commonFunctions.clickElement(topGadgetUpcoming,10,"topGadgetLatest");
        boolean isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetTablet,topGadgetUpcoming);
        return isPopularElementClickableTrue && isLatestElementClickableTrue && isUpcomingElementClickableTrue;
    }

    @Override
    public boolean checkTopGadgetLaptop(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(topGadgetLaptop,10,"topGadgetLaptop");
        commonFunctions.clickElement(topGadgetPopular,10,"topGadgetPopular");
        boolean isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetLaptop,topGadgetPopular);
        commonFunctions.clickElement(topGadgetLatest,10,"topGadgetLatest");
        boolean isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetLaptop,topGadgetLatest);
        commonFunctions.clickElement(topGadgetUpcoming,10,"topGadgetLatest");
        boolean isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetLaptop,topGadgetUpcoming);
        return isPopularElementClickableTrue && isLatestElementClickableTrue && isUpcomingElementClickableTrue;
    }

    @Override
    public boolean checkTopGadgetMobiles(){
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetMobile,topGadgetPopular);
        commonFunctions.clickElement(topGadgetLatest,10,"topGadgetLatest");
        boolean isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetMobile,topGadgetLatest);
       commonFunctions.clickElement(topGadgetUpcoming,10,"topGadgetLatest");
        boolean isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topGadgetLinks,topGadgetMobile,topGadgetUpcoming);
        return isPopularElementClickableTrue && isLatestElementClickableTrue && isUpcomingElementClickableTrue;
    }

    @Override
    public boolean checkGadgetSearchMobilesBrand(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(10);
        commonFunctions.clickElement(gadgetSearchBrand,10,"gadgetSearchBrand");
        boolean isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBrandLinks,gadgetSearchBrand,brandsViewAllButton);
        commonFunctions.clickElement(gadgetSearchBudget,10,"gadgetSearchBudget");
        boolean isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBudgetFeaturesLinks,gadgetSearchMobile,gadgetSearchBudget);
        commonFunctions.clickElement(gadgetSearchFeature,10,"gadgetSearchFeature");
        boolean isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBudgetFeaturesLinks,gadgetSearchMobile,gadgetSearchFeature);
        return isPopularElementClickableTrue && isLatestElementClickableTrue && isUpcomingElementClickableTrue;
    }

    @Override
    public boolean checkGadgetSearchTablets(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(gadgetSearchTablet,10,"GadgetSearchTablet");
        commonFunctions.clickElement(gadgetSearchBrand,10,"gadgetSearchBrand");
        boolean isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBrandLinks,gadgetSearchTablet,gadgetSearchBrand,brandsViewAllButton);
        commonFunctions.clickElement(gadgetSearchTablet,10,"GadgetSearchTablet");
        commonFunctions.clickElement(gadgetSearchBudget,10,"gadgetSearchBudget");
        boolean isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBudgetFeaturesLinks,gadgetSearchTablet,gadgetSearchBudget);
        commonFunctions.clickElement(gadgetSearchTablet,10,"GadgetSearchTablet");
        commonFunctions.clickElement(gadgetSearchFeature,10,"gadgetSearchFeature");
        boolean isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBudgetFeaturesLinks,gadgetSearchTablet,gadgetSearchFeature);
        return isPopularElementClickableTrue && isLatestElementClickableTrue && isUpcomingElementClickableTrue;
    }

    @Override
    public boolean checkGadgetSearchLaptops(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(gadgetSearchLaptops,10,"GadgetSearchLaptops");
        commonFunctions.clickElement(gadgetSearchBrand,10,"gadgetSearchBrand");
        boolean isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBrandLinks,gadgetSearchLaptops,gadgetSearchBrand,brandsViewAllButton);
        commonFunctions.clickElement(gadgetSearchLaptops,10,"GadgetSearchLaptops");
        commonFunctions.clickElement(gadgetSearchBudget,10,"gadgetSearchBudget");
        boolean isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBudgetFeaturesLinks,gadgetSearchLaptops,gadgetSearchBudget);
        commonFunctions.clickElement(gadgetSearchLaptops,10,"GadgetSearchLaptops");
        commonFunctions.clickElement(gadgetSearchFeature,10,"gadgetSearchFeature");
        boolean isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetSearchMobileBudgetFeaturesLinks,gadgetSearchLaptops,gadgetSearchFeature);
        return isPopularElementClickableTrue && isLatestElementClickableTrue && isUpcomingElementClickableTrue;
    }

    @Override
    public boolean checkGadgetComparisonMobile(){
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetMobileComparisonLinks,gadgetComparisonMobile);
        commonFunctions.isElementDisplayed(gadgetComparisonTablet);
        commonFunctions.clickElement(gadgetComparisonTablet,10,"GadgetComparisonTablet");
        boolean isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetTabletComparisonLinks,gadgetComparisonTablet);
        commonFunctions.clickElement(gadgetComparisonLaptop,10,"GadgetComparisonLaptop");
        boolean isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(gadgetLaptopComparisonLinks,gadgetComparisonLaptop);
        return isPopularElementClickableTrue && isLatestElementClickableTrue && isUpcomingElementClickableTrue;
    }

    @Override
    public boolean checkPopularReviews(){
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isPopularMobileClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(popularReviewsMobile,popularReviewsMobileLinks);
        commonFunctions.clickElement(popularReviewsGaming,10,"PopularReviewsGaming");
        boolean isPopularGamingClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(popularReviewsGaming,popularReviewsGamingLinks);
        commonFunctions.clickElement(popularReviewsHomeAppliances,10,"PoplarReviewHomeAppliances");
        boolean isPopularHomeAppliancesClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(popularReviewsHomeAppliances,popularReviewsHomeAppliancesLinks);
        commonFunctions.clickElement(popularReviewsLaptops,10,"PopularReviewsLaptops");
        boolean isPopularalptopsClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(popularReviewsLaptops,popularReviewsLaptopsLinks);
        commonFunctions.clickElement(popularReviewsTV,10,"PopularReviewsTV");
        boolean isPopularTVClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(popularReviewsTV,popularReviewsTVLinks);
        commonFunctions.clickElement(popularReviewsWearables,10,"PopularReviewsWearables");
        boolean isPopularWearablesClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(popularReviewsWearables,popularReviewsWearablesLinks);
        return isPopularMobileClickableTrue && isPopularGamingClickableTrue && isPopularHomeAppliancesClickableTrue && isPopularalptopsClickableTrue && isPopularTVClickableTrue && isPopularWearablesClickableTrue;
    }

    @Override
    public boolean checkLatestVideo(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(latestVideoViewAll,10,"LatestVideoViewAllButton");
        commonFunctions.navigateToHomePage();
        boolean isLatestVideosClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(latestVideosLink);
        return isLatestVideosClickableTrue;
    }


    @Override
    public boolean checkPhotoGallery(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(photoGalleryViewAll,10,"PhotoGalleryViewAllButton");
        commonFunctions.navigateToHomePage();
        boolean isPhotoGalleryClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(photoGalleryLink);
        return isPhotoGalleryClickableTrue;
    }

    @Override
    public boolean checkWebStory(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(webStoriesSeeAll,10,"WebStoriesSeeAllButton");
        commonFunctions.navigateToHomePage();
        boolean isWebStoryClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(webStoriesLink);
        return isWebStoryClickableTrue;
    }

    @Override
    public boolean checkLatestNews(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElement(latestNewsViewall,10,"LatestNewsViewAllButton");
        commonFunctions.navigateToHomePage();
        boolean isLatestNewsClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(latestNewsLink);
        return isLatestNewsClickableTrue;
    }

    @Override
    public boolean checkRecommenderForYou(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollToElement(latestNewsViewall,"latestnews");
        commonFunctions.dummyWait(10);
        boolean isRecommenderClickableTrue =isAllElementClickableAndReturns200(recommenderForYouLink);
        return isRecommenderClickableTrue;
    }





}
