package com.pages.HT_AUTO.DesktopBrowserPages;

import bsh.util.Util;
import com.pages.HT_AUTO.commonFunctions.CommonFunctionWebHTAuto;
import com.pages.HT_AUTO.genericPages.CommonHomePage;

import com.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.commonFunctions.CommonFunctionsWeb;

import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonHomePage {
    private static CommonFunctionsWeb commonFunctions;

    private static CommonFunctionWebHTAuto commonFunctionsHt;
    private static WebDriver driver;
    private static GlobalVars globalVars;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(css = ".ltSide a")
    private static List<WebElement> leftSideStoriesAtTheTop;

    @FindBy(css = ".rtSide a")
    private static List<WebElement> rightSideStoriesAtTheTop;

    @FindBy(css = "img[alt=\"HT Auto\"]")
    private static WebElement HTAutoLogo;

    @FindBy(xpath = "//a[text()='Home']")
    private static WebElement Home;

    @FindBy(css = ".mainLi li a")
    private static List<WebElement> homePageOptions;

    @FindBy(xpath = "//li//a[text()='Latest News']")
    private static WebElement latestNewsOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Auto News']")
    private static WebElement autoNewsOption;

    @FindBy(xpath = "//li//a[text()='News']")
    private static WebElement NewsOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Car News']")
    private static WebElement carNewsOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Bike News']")
    private static WebElement bikeNewsOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Electric Vehicle News']")
    private static WebElement electricVehicleNewsOption;

    @FindBy(xpath = "//li//a[text()='Reviews']")
    private static WebElement reviewsOption;

    @FindBy(xpath = "//li//a[text()='How To']")
    private static WebElement howToOption;

    @FindBy(xpath = "//li//a[text()='Find Vehicles']")
    private static WebElement findVehiclesOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Find Bikes']")
    private static WebElement findBikesOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Find Cars']")
    private static WebElement findCarsOption;

    @FindBy(xpath = "//li//a[text()='Compare']")
    private static WebElement compareOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Compare Cars']")
    private static WebElement compareCarsOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Compare Bikes']")
    private static WebElement compareBikesOption;

    @FindBy(xpath = "//ul[@class='mainLi']//li//a[contains(text(),'Offers')]")
    private static WebElement offersOption;

    @FindBy(xpath = "//ul[@class='mainLi']//li//a[text()='Dealers']")
    private static WebElement dealersOption;

    @FindBy(xpath = "//ul[@class='mainLi']//li//a[text()='For You']")
    private static WebElement forYouOption;

    @FindBy(xpath = "//ul[@class='mainLi']//li//a[text()='More']")
    private static WebElement moreOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Videos']")
    private static WebElement videosOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Photos']")
    private static WebElement photosOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Web Stories']")
    private static WebElement webStoriesOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='EMI Calculator']")
    private static WebElement emiCalculatorOption;

    @FindBy(xpath = "//div[@class='dropdownWrapper']//li//a[text()='Trending']")
    private static WebElement trendingOption;

    @FindBy(xpath = "//div[@class='sixRatioNine']//h1")
    private static WebElement topFirstStory;

    @FindBy(css = "a.firstArticle")
    private static WebElement topFirstStoryAnchorTag;

    @FindBy(xpath="(//div[@class='StoryTopContent']//h1)[1]")
    private static WebElement storyTopContentPage;

    @FindBy(xpath="//section[@class='topSectionWrapper']//a//div[@class='title']")
    private static List<WebElement> allTopStoriesList;

    @FindBy(xpath="(//div[@class='rhSection']//div[contains(@id,'google_ads_iframe')])[1]")
    private static WebElement rH1Ad;

    @FindBy(xpath="(//div[@class='rhSection']//div[contains(@id,'google_ads_iframe')])[2]")
    private static WebElement rhs2Ad;

    @FindBy(xpath="(//div[@class='rhSection']//div[contains(@id,'google_ads_iframe')])[3]")
    private static WebElement rhs3Ad;

    @FindBy(xpath="(//div[contains(@id,'google_ads_iframe')])[1]")
    private static WebElement topMostAd;

    @FindBy(xpath="//div[@id='adslot3']//div")
    private static WebElement bottomAd;

    @FindBy(css="section.gadgetsSearch div.h2")
    private static WebElement gadgetSearchBy;

    @FindBy(xpath="//section[@class='popularReview']//h2[text()='Popular Reviews']")
    private static WebElement widgetPopularReviewHeading;

    @FindBy(css="section.photGallery h2 a[data-ga-widget='Widget-PhotoGallery']")
    private static WebElement widgetPhotoGallery;

    @FindBy(xpath="//div[text()='Recommended For You']")
    private static WebElement widgetRecommendedForYou;

    @FindBy(xpath="//div[contains(@class,'headerWrapper')]//div[@class='d-flex']//a[@data-item='fb']")
    private static WebElement fbIcon;

    @FindBy(xpath="//div[contains(@class,'headerWrapper')]//div[@class='d-flex']//a[@data-item='youtube']")
    private static WebElement youTubeIcon;

    @FindBy(xpath="//div[contains(@class,'headerWrapper')]//div[@class='d-flex']//a[contains(@class,'twIcon')]")
    private static WebElement twitterIcon;

    @FindBy(css="[data-ga-widget='Widget-LocateDealers']")
    private static WebElement widgetLocateDealers;

    @FindBy(xpath="//div[@class='brand_city_rt']//div[text()='Select Brand & City']")
    private static WebElement txt_SelectBrandAndCity;

    @FindBy(xpath="//select[@id='brand-list']")
    private static WebElement dropdownBrandList;

    @FindBy(css="select#city-list[disabled='disabled']")
    private static WebElement dropdownCityDisabled;

    @FindBy(css="#city-list")
    private static WebElement dropdownCityList;

    @FindBy(css=".rt_searchbtn #dealer-action")
    private static WebElement btnSearch;

    @FindBy(css=".brandCityDropDown_dealerbox__UqLtx h1")
    private static WebElement headingCarDealersShowroom;

    @FindBy(xpath="//section[@id='top-auto-widget']//h2[text()='Top Automobiles']")
    private static WebElement txt_TopAutomobilesWidget;

    @FindBy(xpath="//section[contains(@class,'automobiles')]//span[@data-id='car']")
    private static WebElement topAutomobilesCarWidget;

    @FindBy(xpath="//section[contains(@class,'automobiles')]//span[@data-id='bike']")
    private static WebElement topAutomobilesBikeWidget;

    @FindBy(css="#top-auto-widget .tabLinksWrapper [data-id='popular']")
    private static WebElement topAutomobilesPopularTab;

    @FindBy(css="#top-auto-widget .tabLinksWrapper [data-id='latest']")
    private static WebElement topAutomobilesLatestTab;

    @FindBy(css="#top-auto-widget .tabLinksWrapper [data-id='upcoming']")
    private static WebElement topAutomobilesUpcomingTab;

    //TO DO :: Verify below locator once get the data in LIST on UI
    @FindBy(css=".automobilesrelative .sliderWrapper .topgadgetscontent a[data-item-category='Widget-TopAutoMobiles-BIKE-Popular']")
    private static List<WebElement> widgetTopAutomobilesBikePopularContentList;

    @FindBy(css=".automobilesrelative .sliderWrapper .topgadgetscontent a[data-ga-widget='Widget-TopAutoMobiles-BIKE-Latest']")
    private static List<WebElement> widgetTopAutomobilesBikeLatestContentList;

    @FindBy(css=".automobilesrelative .sliderWrapper .topgadgetscontent a[data-ga-widget='Widget-TopAutoMobiles-BIKE-Upcoming']")
    private static List<WebElement> widgetTopAutomobilesBikeUpcomingContentList;

    @FindBy(css=".automobilesrelative .sliderWrapper .topgadgetscontent a[data-item-category='Widget-TopAutoMobiles-CAR-Popular']")
    private static List<WebElement> widgetTopAutomobilesCarPopularContentList;

    @FindBy(css=".automobilesrelative .sliderWrapper .topgadgetscontent a[data-ga-widget='Widget-TopAutoMobiles-CAR-Latest']")
    private static List<WebElement> widgetTopAutomobilesCarLatestContentList;

    @FindBy(css=".automobilesrelative .sliderWrapper .topgadgetscontent a[data-ga-widget='Widget-TopAutoMobiles-CAR-Upcoming']")
    private static List<WebElement> widgetTopAutomobilesCarUpcomingContentList;

    @FindBy(css="#findMoreTopAutomobile")
    private static WebElement findMoreTopAutomobilesLink;

    @FindBy(xpath="//section[@id='top-compare-widget']//h2[text()='Top Comparisons']")
    private static WebElement txt_TopComparisonsWidget;

    @FindBy(css="#top-compare-widget .boxTabs [data-id='car']")
    private static WebElement topComparisonsCarWidget;

    @FindBy(css="#top-compare-widget .boxTabs [data-id='bike']")
    private static WebElement topComparisonsBikeWidget;

//    @FindBy(css=".TopComparisonsrelative #top-compare-container .compareBtnWrapper")
//div[@id='top-compare-container']//a//span[text()='Compare Now']
    @FindBy(xpath="//div[@id='top-compare-container']//a//span[text()='Compare Now']")
    private static List<WebElement> topComparisonsGadgetsContentList;

    @FindBy(css="#viewAllTopComparison")
    private static WebElement findMoreTopComparisonsLink;

    @FindBy(css=".TopComparisonsrelative .rightArrow")
    private static WebElement topComparisonsGadgetsRightArrow;

    @FindBy(css = ".SearcWidgethWrapper [placeholder='Search for news, cars, bikes']")
    private static WebElement searchTextBoxOnTrendingNewsPage;
    @FindBy(css = ".searchWrapper #staticSearch[placeholder='Search for news, cars, bikes']")
    private static WebElement searchTextBox;
    @FindBy(id = "searchSubmitBtn")
    private static WebElement searchBtnTabText;

    @FindBy(xpath = "//h2[text()='Trending News']")
    private static WebElement txt_TrendingNews;

    @FindBy(css = ".SearchResultTitle")
    private static WebElement searchResultTitle;

    @FindBy(css = ".noresult_img")
    private static WebElement noSearchResultText;

    @FindBy(xpath="//h3[contains(text(),'Editor')]//following-sibling::div/div/div[contains(@class,'title')]/a")
    private static List<WebElement> editorPickList;

    @FindBy(xpath="//h3[contains(text(),'Editor')]")
    private static WebElement editorPickHead;

    @FindBy(xpath="//h3[text()='Trending this Week']//following-sibling::div/div/div[contains(@class,'title')]/a")
    private static List<WebElement> trendingThisWeekList;

    @FindBy(xpath="//h3[text()='Trending this Week']")
    private static WebElement trendingThisWeekHead;

    @FindBy(xpath="//h3[@class='rtHeading']//a[text()='Latest News']//parent::h3//following-sibling::div/div/div[contains(@class,'title')]/a")
    private static List<WebElement> latestNewsList;

    @FindBy(xpath="//h3[@class='rtHeading']//a[text()='Latest News']")
    private static WebElement latestNewsHead;

    @FindBy(xpath="//h3[@class='rtHeading']//a[contains(text(),'Explore Car EMI’s')]//parent::h3//following-sibling::div/div/div[@class='caremitext']/a")
    private static List<WebElement> exploreCarEMIHeadList;

    @FindBy(xpath="//a[contains(text(),'Explore Car EMI')]")
    private static WebElement exploreCarEMIHead;

    @FindBy(css="#searchByWidget #brand-toggle span[data-id='car']")
    private static WebElement widgetSearchByCarToggle;

    @FindBy(css="#searchByWidget #brand-toggle span[data-id='bike']")
    private static WebElement widgetSearchByBikeToggle;

    @FindBy(css="a[data-id='brand']")
    private static WebElement widgetSearchByBrandTab;

    @FindBy(css="a[data-id='budget']")
    private static WebElement widgetSearchByBudgetTab;

    @FindBy(css="a[data-id='bodytype']")
    private static WebElement widgetSearchByBodyTypeTab;

    @FindBy(css=".viewMore")
    private static WebElement widgetSearchByBrandViewMoreButton;

    @FindBy(css="#search-by-tab .logoBoxInner div:nth-child(2) a[data-item-category='Widget_SearchBy-Cars-']")
    private static List<WebElement> widgetSearchByBrandAndBodyTypeCarList;

    @FindBy(css="#search-by-tab .logoBoxInner div:nth-child(2) a[data-item-category='Widget_SearchBy-Bikes-']")
    private static List<WebElement> widgetSearchByBrandAndBodyTypeBikeList;

    @FindBy(css="#search-by-tab .model-name a[data-item-category='Widget_SearchBy-Bikes-']")
    private static List<WebElement> widgetSearchByBudgetBikeList;

    @FindBy(css="#search-by-tab .model-name a[data-item-category='Widget_SearchBy-Cars-']")
    private static List<WebElement> widgetSearchByBudgetCarList;

    @FindBy(css="#popular-review a[data-item-category='Widget-PopularReviews-'].viewAllWrapper")
    private static List<WebElement> popularReviewsList;

    @FindBy(xpath="//section[@class='videoSection']//div[@class='wrapAll']//a")
    private static List<WebElement> latestVideosList;

    @FindBy(css="section.videoSection a[data-ga-widget='Widget-LatestVideos']")
    private static WebElement latestVideosHead;

    @FindBy(css="section.photGallery div.title a[data-item-category='Widget-PhotoGallery']")
    private static List<WebElement> photoGalleryList;

    @FindBy(xpath="//h3[text()='Web Stories']//following-sibling::a")
    private static WebElement webStoriesSeeAll;

    @FindBy(xpath="//section[contains(@class,'WebStoriesWidget')]//a[@data-item-action='Widget-Webstory Story Clicked']")
    private static List<WebElement> webStoriesList;

    @FindBy(xpath="//section[contains(@class,'ElectricVehicle')]//div[@class='wrapAll']//a")
    private static List<WebElement> electricVehicleList;

    @FindBy(css="section.ElectricVehicle h2 a[data-ga-widget='Widget-ElectricVehicle']")
    private static WebElement electricVehicleNewsHead;

    @FindBy(xpath="//section[@data-vars-widgettype='recommendedForYou']//div[@class='wrapAll']//a")
    private static List<WebElement> recommenderForYouList;

    @FindBy(css="a[data-ga-action='Widget-Recommended For You View All']")
    private static WebElement recommendViewAllButton;

    public HomePage(){
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this) ;
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsHt = new CommonFunctionWebHTAuto().getInstance();

//        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(acceptCookie, 10, "Accept Cookie");
//        if (isElementPresent) {
//            commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "acceptCookie");
//        }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    @Override
    public boolean verifyLeftStoriesAreDisplayed(){
        boolean isLeftStoriesAtTheTop = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementDisplayed(leftSideStoriesAtTheTop,10,"Left Top Stories");
        int sizeofLeftTopStories = leftSideStoriesAtTheTop.size();
        if(sizeofLeftTopStories == 3){
            isLeftStoriesAtTheTop = true;
        }
        return isLeftStoriesAtTheTop;
    }

    @Override
    public boolean verifyRightStoriesAreDisplayed(){
        boolean isRightStoriesAtTheTop = false;
        commonFunctions.isElementDisplayed(rightSideStoriesAtTheTop,10,"Right Top Stories");
        int sizeofRightTopStories = rightSideStoriesAtTheTop.size();
        if(sizeofRightTopStories == 5){
            isRightStoriesAtTheTop = true;
        }
        return isRightStoriesAtTheTop;
    }

    @Override
    public boolean verifyHTAutoLogoRedirection(){
        boolean isReloadingSuccessful = false;
        try {
            commonFunctions.isElementDisplayed(HTAutoLogo, 10,"HtAutoLogo");
            commonFunctions.clickElement(HTAutoLogo, 10, "Hindustan Times Auto Logo");
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
    public boolean verifyHomePageRedirectionInList(){
        boolean isReloadingSuccessful = false;
        try {
            commonFunctions.isElementDisplayed(Home, 10,"Home Link");
            commonFunctions.clickElement(Home, 10, "Home Link");
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
    public boolean verifyHomePageOptions(ArrayList<String> homeOptionsInList) {
        boolean isHomeOptionsDisplayed = false;
        if(homeOptionsInList.size()==homePageOptions.size() && !homePageOptions.isEmpty()){
            for(int i=0 ; i<homePageOptions.size() ; i++){
                String options =homePageOptions.get(i).getText().replace("\n"," ");
                commonFunctions.mouseHoverOnElement(homePageOptions.get(i),10,options);
                if(!options.isEmpty() && homeOptionsInList.contains(options) && homePageOptions.get(i).isDisplayed()){
                    Utils.logStepInfo(true,options+" option contains/displayed in provided list");
                    isHomeOptionsDisplayed = true;
                }else{
                    Utils.logStepInfo(false,options+" option does not contains/displayed in provided list");
                    return false;
                }
            }
            return isHomeOptionsDisplayed;
        }
        Utils.logStepInfo(false,"Menu option does not displayed on home page");
        return isHomeOptionsDisplayed;
    }

    @Override
    public boolean verifyHomePageOptionsAreClickable(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        boolean isLatestNewsClicked = clickOnLatestNewsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isAutoNewsClicked = clickOnAutoNewsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isCarNewsClicked = clickOnCarNewsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isBikeNewsClicked = clickOnBikeNewsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isElectricVehicleClicked = clickOnElectricVehicleNewsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isReviewClicked = clickOnReviewsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isHowToClicked = clickOnHowToOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isFindCarsClicked = clickOnFindCarsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isFindBikesClicked = clickOnFindBikesOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isCompareCarsClicked = clickOnCompareCarsOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isCompareBikesClicked = clickOnCompareBikesOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isOffersClicked = clickOnOffersOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isDealersClicked = clickOnDealersOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isForYouClicked = clickOnForYouOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isPhotosClicked = clickOnPhotosOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isVideosClicked = clickOnVideosOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isWebStoriesClicked = clickOnWebStoriesOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isEMICalculatorClicked = clickOnEMICalculatorOption();
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean isTrendingClicked = clickOnTrendingOption();
        commonFunctions.navigateToURL(globalVars.getURL());

        return isLatestNewsClicked && isAutoNewsClicked && isCarNewsClicked &&
                isBikeNewsClicked && isElectricVehicleClicked && isReviewClicked &&
                isHowToClicked && isFindBikesClicked && isFindCarsClicked && isCompareCarsClicked &&
                isCompareBikesClicked && isOffersClicked && isDealersClicked && isForYouClicked &&
                isPhotosClicked && isVideosClicked && isWebStoriesClicked && isEMICalculatorClicked &&
                isTrendingClicked;

    }

    public boolean clickOnLatestNewsOption(){
        boolean isElementClickable = commonFunctionsHt.isElementClickableAndReturns200(latestNewsOption,"Latest News Option on Home Page");
        return isElementClickable ;
    }

    public boolean clickOnAutoNewsOption(){
        commonFunctions.mouseHoverOnElement(NewsOption,10,"Auto News Option on Home Page");
        boolean isElementClickable = commonFunctionsHt.isElementClickableAndReturns200(autoNewsOption,"Auto News Option on Home Page");
        return isElementClickable;
    }

    public boolean clickOnCarNewsOption(){
        commonFunctions.mouseHoverOnElement(NewsOption,10,"Car News Option on Home Page");
        boolean isElementClickable = commonFunctionsHt.isElementClickableAndReturns200(carNewsOption,"Car News Option on Home Page");
        return isElementClickable;
    }

    public boolean clickOnBikeNewsOption(){
        commonFunctions.mouseHoverOnElement(NewsOption,10,"Bike News Option on Home Page");
        boolean isElementClickable = commonFunctionsHt.isElementClickableAndReturns200(bikeNewsOption,"Bike News Option on Home Page");
        return isElementClickable;
    }

    public boolean clickOnElectricVehicleNewsOption(){
        commonFunctions.mouseHoverOnElement(NewsOption,10,"Electric Vehicle News Option on Home Page");
        boolean isElementClickable = commonFunctionsHt.isElementClickableAndReturns200(electricVehicleNewsOption,"Electric Vehicle News Option on Home Page");
        return isElementClickable;
    }

    public boolean clickOnFindCarsOption(){
        commonFunctions.mouseHoverOnElement(findVehiclesOption,10,"Find Vehicle Option on Home Page");
        boolean isElementClickable = commonFunctionsHt.isElementClickableAndReturns200(findCarsOption,"Find Cars Option on Home Page");
        return isElementClickable;
    }

    public boolean clickOnFindBikesOption(){
        commonFunctions.mouseHoverOnElement(findVehiclesOption,10,"Find Vehicle Option on Home Page");
        boolean isElementClickable = commonFunctionsHt.isElementClickableAndReturns200(findBikesOption,"Find Bikes Option on Home Page");
        return isElementClickable;
    }

    public boolean clickOnReviewsOption(){
        return commonFunctionsHt.isElementClickableAndReturns200(reviewsOption,"Reviews Option on Home Page");
    }

    public boolean clickOnHowToOption(){
        return commonFunctionsHt.isElementClickableAndReturns200(howToOption,"How To Option on Home Page");
    }

    public boolean clickOnCompareCarsOption(){
        commonFunctions.mouseHoverOnElement(compareOption,10,"Compare Option on Home Page");
        return commonFunctionsHt.isElementClickableAndReturns200(compareCarsOption,"Compare Cars Option on Home Page");
    }

    public boolean clickOnCompareBikesOption(){
        commonFunctions.mouseHoverOnElement(compareOption,10,"Compare Option on Home Page");
        return commonFunctionsHt.isElementClickableAndReturns200(compareBikesOption,"Compare Bikes Option on Home Page");
    }

    public boolean clickOnOffersOption(){
        return commonFunctionsHt.isElementClickableAndReturns200(offersOption,"Offers Option on Home Page");
    }

    public boolean clickOnDealersOption(){
        return commonFunctionsHt.isElementClickableAndReturns200(dealersOption,"Dealers Option on Home Page");
    }

    public boolean clickOnForYouOption(){
        return commonFunctionsHt.isElementClickableAndReturns200(forYouOption,"For You Option on Home Page");
    }

    public boolean clickOnVideosOption(){
        commonFunctions.mouseHoverOnElement(moreOption,10,"More Option on Home Page");
        return commonFunctionsHt.isElementClickableAndReturns200(videosOption,"Videos Option on Home Page");
    }

    public boolean clickOnWebStoriesOption(){
        commonFunctions.mouseHoverOnElement(moreOption,10,"More Option on Home Page");
        return commonFunctionsHt.isElementClickableAndReturns200(webStoriesOption,"Web Stories Option on Home Page");
    }

    public boolean clickOnPhotosOption(){
        commonFunctions.mouseHoverOnElement(moreOption,10,"More Option on Home Page");
        return commonFunctionsHt.isElementClickableAndReturns200(photosOption,"Photos Option on Home Page");
    }

    public boolean clickOnEMICalculatorOption(){
        commonFunctions.mouseHoverOnElement(moreOption,10,"More Option on Home Page");
        return commonFunctionsHt.isElementClickableAndReturns200(emiCalculatorOption,"EMI Calculator Option on Home Page");
    }

    public boolean clickOnTrendingOption(){
        commonFunctions.mouseHoverOnElement(moreOption,10,"More Option on Home Page");
        return commonFunctionsHt.isElementClickableAndReturns200(trendingOption,"Trending Option on Home Page");
    }

    public boolean checkTopFirstStandardImageStory(){
        boolean topFirstStandardImageStoryStatus;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        String expectedHeadline = commonFunctions.getElementText(topFirstStory);
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(topFirstStoryAnchorTag,10,"Top First Story");
        commonFunctions.waitForURLContains(".html");
        String actualHeadline = commonFunctions.getElementText(storyTopContentPage);
        commonFunctions.navigateToHomePage();

        topFirstStandardImageStoryStatus = commonFunctions.checkTextContains(expectedHeadline, actualHeadline, "Top First Story Headline in UI");

        return topFirstStandardImageStoryStatus;
    }

    public boolean checkAllTopStoriesTitle(){
        boolean isAllElementClickable;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!allTopStoriesList.isEmpty() && allTopStoriesList.size()==7){
            isAllElementClickable = commonFunctionsHt.isAllElementClickableAndReturns200(allTopStoriesList);
        }else{
            Utils.logStepInfo(false,"Either NO TOP Story displayed or "+allTopStoriesList.size()+" stories are displaying instead of 7");
            isAllElementClickable = false;
            return isAllElementClickable;
        }
        return isAllElementClickable;
    }

    public boolean checkHomePageRHSAdsAreDisplayed_1() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"scroll to HT Logo");
        commonFunctions.dummyWait(2);
        boolean checkRHS1Ad=commonFunctions.isElementDisplayed(rH1Ad, 20, "HomePage RHS First Ad");
        commonFunctions.scrollToElement(gadgetSearchBy,"2nd ad");
        commonFunctions.waitForPageLoading();
        boolean checkRHS2Ad=commonFunctions.isElementDisplayed(rhs2Ad, 20,"RSH Second Ad");
        commonFunctions.scrollToElement(widgetPhotoGallery,"scrolled to photoGallery");
        commonFunctions.waitForPageLoading();
        boolean checkRHS3Ad=commonFunctions.isElementDisplayed(rhs3Ad, 20,"RSH Third Ad");
        return checkRHS1Ad && checkRHS2Ad && checkRHS3Ad;
    }

    public boolean checkTopAdDisplaying_2() {
        boolean isTopAd;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        isTopAd = commonFunctions.isElementDisplayed(topMostAd, 20, "topAd");
        return isTopAd;
    }

    public boolean checkBottomAdsDisplaying_3() {
        boolean isTopAd;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(gadgetSearchBy,"2nd ad");
        commonFunctions.scrollToElement(widgetPhotoGallery,"scrolled to photoGallery");
        commonFunctions.scrollToElement(widgetRecommendedForYou,"scrolled to footer");
        commonFunctions.dummyWait(2);
        isTopAd = commonFunctions.isElementDisplayed(bottomAd, 20, "bottomAd");
        return isTopAd;
    }

    public boolean verifyFBIcon() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
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

    public boolean verifyTwitterIcon() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(3);
        commonFunctions.isElementDisplayed(searchTextBox,10);
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

    public boolean verifyYoutubeIcon() {

        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(3);
        boolean isYoutubeLinkClickable = commonFunctions.isElementClickable(youTubeIcon, 10, "youtube button");
        commonFunctions.mouseHoverOnElement(youTubeIcon,10,"Youtube button");
        commonFunctions.clickElement(youTubeIcon, 10, "youtube button");
        commonFunctions.dummyWait(5);
        ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
        boolean isCurrentUrlOfYoutube = commonFunctions.getCurrentURL().contains("youtube");
        commonFunctions.closeAllWindowsExceptMasterTabOnly();
        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 2));
        return  isYoutubeLinkClickable && isCurrentUrlOfYoutube;
    }

    public boolean verifyLocateDealerWidgetRedirectionToDealerPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.isElementDisplayed(widgetLocateDealers,10,"Widget Locate Dealers");
        commonFunctions.clickElement(widgetLocateDealers,10,"Widget Locate Dealers");
        boolean checkResponseCode = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) ==200;
        return commonFunctions.getCurrentURL().contains("car-dealers") && checkResponseCode;
    }

    public boolean searchCarDealersBySelectingBrandAndCity(String brand, String city){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        commonFunctions.waitForPageLoading();
        commonFunctions.dummyWait(2);
        boolean isTextDisplayed = commonFunctions.isElementDisplayed(txt_SelectBrandAndCity,10,"Text Select Brand and City under widget Locate Dealers");
        commonFunctions.isElementDisplayed(dropdownCityDisabled,10);
        commonFunctions.selectOptionFromDropDown(dropdownBrandList,10,brand,"Select brand from dropdown");
        commonFunctions.dummyWait(10);
        commonFunctions.selectOptionFromDropDown(dropdownCityList,10,city,"Select city from dropdown");
        boolean isElementClickable = commonFunctions.clickElement(btnSearch,10,"Search button");
        commonFunctions.waitForPageToLoad();
        boolean checkResponseCode = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) ==200;
        String actualHeading = commonFunctions.getElementText(headingCarDealersShowroom);
        String expectedHeading = brand+" Car Dealer Showrooms in "+city;
        boolean checkHeading = commonFunctions.compareTexts(expectedHeading,actualHeading);
        return isTextDisplayed && isElementClickable && checkHeading && checkResponseCode;
    }
    @Override
    public boolean checkTopAutomobilesCarPopularWidget(int noOfCards){
        boolean isPopularElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        boolean isTopAutomobilesDisplay = commonFunctions.isElementDisplayed(txt_TopAutomobilesWidget,10,"Top Automobiles Widget Text");
        Utils.logStepInfo(isTopAutomobilesDisplay,"isTopAutomobilesDisplay");
        commonFunctions.waitForElementBeDisplayAndClick(topAutomobilesPopularTab,10,"topAutomobilesPopularTab");
        if(widgetTopAutomobilesCarPopularContentList.size()==noOfCards){
            Utils.logStepInfo(true,widgetTopAutomobilesCarPopularContentList.size()+" cards are populating under Top Automobiles Car Popular Widget");
            isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetTopAutomobilesCarPopularContentList,topAutomobilesPopularTab);
        }else{
            Utils.logStepInfo(false,widgetTopAutomobilesCarPopularContentList.size()+" cards are populating under Top Automobiles Car Popular Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopAutomobilesClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopAutomobilesLink,"findMoreTopAutomobilesLink");
        return isPopularElementClickableTrue && isTopAutomobilesDisplay && isFindMoreTopAutomobilesClickable;
    }

    @Override
    public boolean checkTopAutomobilesCarLatestWidget(int noOfCards){
        boolean isLatestElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        boolean isTopAutomobilesDisplay = commonFunctions.isElementDisplayed(txt_TopAutomobilesWidget,10,"Top Automobiles Widget Text");
        Utils.logStepInfo(isTopAutomobilesDisplay,"isTopAutomobilesDisplay");
        commonFunctions.clickElement(topAutomobilesLatestTab,10,"topAutomobilesLatestTab");
        commonFunctions.dummyWait(1);
        if(widgetTopAutomobilesCarLatestContentList.size()==noOfCards){
            Utils.logStepInfo(true,widgetTopAutomobilesCarLatestContentList.size()+" cards are populating under Top Automobiles Car Latest Widget");
            isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetTopAutomobilesCarLatestContentList,topAutomobilesLatestTab);
        }else{
            Utils.logStepInfo(false,widgetTopAutomobilesCarLatestContentList.size()+" cards are populating under Top Automobiles Car Latest Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopAutomobilesClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopAutomobilesLink,"findMoreTopAutomobilesLink");
        return isLatestElementClickableTrue && isTopAutomobilesDisplay && isFindMoreTopAutomobilesClickable;
    }

    @Override
    public boolean checkTopAutomobilesCarUpcomingWidget(int noOfCards){
        boolean isUpcomingElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        boolean isTopAutomobilesDisplay = commonFunctions.isElementDisplayed(txt_TopAutomobilesWidget,10,"Top Automobiles Widget Text");
        Utils.logStepInfo(isTopAutomobilesDisplay,"isTopAutomobilesDisplay");
        commonFunctions.clickElement(topAutomobilesUpcomingTab,10,"topAutomobilesUpcomingTab");
        commonFunctions.dummyWait(1);
        if(widgetTopAutomobilesCarUpcomingContentList.size()==noOfCards){
            Utils.logStepInfo(true,widgetTopAutomobilesCarUpcomingContentList.size()+" cards are populating under Top Automobiles Car Latest Widget");
            isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetTopAutomobilesCarUpcomingContentList,topAutomobilesUpcomingTab);
        }else{
            Utils.logStepInfo(false,widgetTopAutomobilesCarUpcomingContentList.size()+" cards are populating under Top Automobiles Car Latest Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopAutomobilesClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopAutomobilesLink,"findMoreTopAutomobilesLink");
        Utils.logStepInfo(isFindMoreTopAutomobilesClickable,"isFindMoreTopAutomobilesClickable");
        return isUpcomingElementClickableTrue && isTopAutomobilesDisplay && isFindMoreTopAutomobilesClickable;
    }

    @Override
    public boolean checkTopAutomobilesBikePopularWidget(int noOfCards){
        boolean isPopularElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        clickOnBikeToggleForTopAutomobiles();
        commonFunctions.dummyWait(1);
        commonFunctions.waitForElementBeDisplayAndClick(topAutomobilesPopularTab,10,"topAutomobilesPopularTab");
        commonFunctions.dummyWait(1);
        if(widgetTopAutomobilesBikePopularContentList.size()==noOfCards){
            Utils.logStepInfo(true,widgetTopAutomobilesBikePopularContentList.size()+" cards are populating under Top Automobiles Bike Popular Widget");
            isPopularElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetTopAutomobilesBikePopularContentList,topAutomobilesBikeWidget,topAutomobilesPopularTab);
        }else{
            Utils.logStepInfo(false,widgetTopAutomobilesBikePopularContentList.size()+" cards are populating under Top Automobiles Bike Popular Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopAutomobilesClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopAutomobilesLink,"findMoreTopAutomobilesLink");
        return isPopularElementClickableTrue && isFindMoreTopAutomobilesClickable;
    }

    @Override
    public boolean checkTopAutomobilesBikeLatestWidget(int noOfCards){
        boolean isLatestElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        clickOnBikeToggleForTopAutomobiles();
        commonFunctions.dummyWait(1);
        commonFunctions.clickElement(topAutomobilesLatestTab,10,"topAutomobilesLatestTab");
        commonFunctions.dummyWait(1);
        if(widgetTopAutomobilesBikeLatestContentList.size()==noOfCards){
            Utils.logStepInfo(true,widgetTopAutomobilesBikeLatestContentList.size()+" cards are populating under Top Automobiles Car Latest Widget");
            isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetTopAutomobilesBikeLatestContentList,topAutomobilesBikeWidget,topAutomobilesLatestTab);
        }else{
            Utils.logStepInfo(false,widgetTopAutomobilesBikeLatestContentList.size()+" cards are populating under Top Automobiles Car Latest Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopAutomobilesClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopAutomobilesLink,"findMoreTopAutomobilesLink");
        return isLatestElementClickableTrue && isFindMoreTopAutomobilesClickable;
    }

    @Override
    public boolean checkTopAutomobilesBikeUpcomingWidget(int noOfCards){
        boolean isUpcomingElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(HTAutoLogo,"HTAutoLogo");
        clickOnBikeToggleForTopAutomobiles();
        commonFunctions.dummyWait(1);
        commonFunctions.clickElement(topAutomobilesUpcomingTab,10,"topAutomobilesUpcomingTab");
        commonFunctions.dummyWait(1);
        if(widgetTopAutomobilesBikeUpcomingContentList.size()==noOfCards){
            Utils.logStepInfo(true,widgetTopAutomobilesBikeUpcomingContentList.size()+" cards are populating under Top Automobiles Car Latest Widget");
            isUpcomingElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetTopAutomobilesBikeUpcomingContentList,topAutomobilesBikeWidget,topAutomobilesUpcomingTab);
        }else{
            Utils.logStepInfo(false,widgetTopAutomobilesBikeUpcomingContentList.size()+" cards are populating under Top Automobiles Car Latest Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopAutomobilesClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopAutomobilesLink,"findMoreTopAutomobilesLink");
        Utils.logStepInfo(isFindMoreTopAutomobilesClickable,"isFindMoreTopAutomobilesClickable");
        return isUpcomingElementClickableTrue && isFindMoreTopAutomobilesClickable;
    }

    public boolean clickOnBikeToggleForTopAutomobiles(){
        boolean isTopAutomobilesDisplay = commonFunctions.isElementDisplayed(txt_TopAutomobilesWidget,10,"Top Automobiles Widget Text");
        commonFunctions.waitForElementBeDisplayAndClick(topAutomobilesBikeWidget,10,"topAutomobilesBikeWidget");
        return isTopAutomobilesDisplay;
    }

    @Override
    public boolean checkTopComparisonsCarWidget(int noOfCards){
        boolean isCompareNowElementClickableTrue = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(editorPickHead,"Scroll to editorPickHead");
        commonFunctions.isElementDisplayed(txt_TopComparisonsWidget,10,"Top Comparisons Widget Text");
        commonFunctions.clickElement(topComparisonsCarWidget,10,"topComparisonsCarWidget");
        commonFunctions.dummyWait(2);
        if(!topComparisonsGadgetsContentList.isEmpty() && topComparisonsGadgetsContentList.size()==noOfCards){
            Utils.logStepInfo(true,topComparisonsGadgetsContentList.size()+" cards are populating under Top Comparisons Car Widget");
             isCompareNowElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topComparisonsGadgetsContentList);
        }else{
            Utils.logStepInfo(false,topComparisonsGadgetsContentList.size()+" cards are populating under Top Comparisons Car Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopComparisonsClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopComparisonsLink,"findMoreTopComparisonsLink");
        return isCompareNowElementClickableTrue
                && isFindMoreTopComparisonsClickable;
    }
    @Override
    public boolean checkTopComparisonsBikeWidget(int noOfCards){
        boolean isCompareNowElementClickableTrue = false;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(editorPickHead,"Scroll to editorPickHead");
        commonFunctions.isElementDisplayed(txt_TopComparisonsWidget,10,"Top Comparisons Widget Text");
        commonFunctions.clickElement(topComparisonsBikeWidget,10,"topComparisonsBikeWidget");
        commonFunctions.dummyWait(2);
        if(!topComparisonsGadgetsContentList.isEmpty() && topComparisonsGadgetsContentList.size()==noOfCards){
            Utils.logStepInfo(true,topComparisonsGadgetsContentList.size()+" cards are populating under Top Comparisons Bike Widget");
            isCompareNowElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(topComparisonsGadgetsContentList,topComparisonsBikeWidget);
        }else{
            Utils.logStepInfo(false,topComparisonsGadgetsContentList.size()+" cards are populating under Top Comparisons Bike Widget instead of "+noOfCards);
            return false;
        }
        boolean isFindMoreTopComparisonsClickable = commonFunctionsHt.isElementClickableAndReturns200(findMoreTopComparisonsLink,"findMoreTopComparisonsLink");
        return  isCompareNowElementClickableTrue && isFindMoreTopComparisonsClickable;
    }

    public boolean checkTrendingNewsHeadingOnClickingSearchBox(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        boolean isElementClickable = commonFunctions.isElementClickable(searchTextBox, 10, "Search TextBox");
        boolean isElementClicked = commonFunctions.clickElement(searchTextBox,10,"searchTextBox");
        boolean isElementDisplayed = commonFunctions.isElementDisplayed(txt_TrendingNews,10,"txt_TrendingNews");
        boolean isSearchTextBoxDisplayed = commonFunctions.isElementDisplayed(searchTextBoxOnTrendingNewsPage,10,"searchTextBoxOnTrendingNewsPage");
        return  isElementClickable && isElementClicked && isSearchTextBoxDisplayed && isElementDisplayed;
    }

    public boolean searchAnyProductUsingValidKeyword(String keyword){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.clickElement(searchTextBox,10,"searchTextBox");
        commonFunctions.isElementDisplayed(searchTextBoxOnTrendingNewsPage,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.sendKeys(searchTextBoxOnTrendingNewsPage,keyword,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.clickElement(searchBtnTabText,10,"searchBtnTabText");
        commonFunctions.waitForURLContains(keyword);
        String actualSearchResult = commonFunctions.getElementText(searchResultTitle,10);
        String expectedSearchResult = "Search Results for \""+keyword+"\"";
        return commonFunctions.compareTexts(actualSearchResult,expectedSearchResult);
    }

    public boolean searchAnyProductUsingInValidKeyword(String keyword){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.clickElement(searchTextBox,10,"searchTextBox");
        commonFunctions.isElementDisplayed(searchTextBoxOnTrendingNewsPage,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.sendKeys(searchTextBoxOnTrendingNewsPage,keyword,10,"searchTextBoxOnTrendingNewsPage");
        commonFunctions.clickElement(searchBtnTabText,10,"searchBtnTabText");
        commonFunctions.waitForURLContains(keyword);
        String actualSearchResult = commonFunctions.getElementText(noSearchResultText,10);
        String expectedSearchResult = "It seems like there aren't many great matches for your search query";
        return commonFunctions.checkTextContains(expectedSearchResult,actualSearchResult,"Invalid Search result message");
    }

    public boolean checkEditorPick(int noOfStories){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!editorPickList.isEmpty() && editorPickList.size()==noOfStories){
            Utils.logStepInfo(true,editorPickList.size()+" cards are populating under Editors Pick Widget");
            commonFunctions.scrollToElement(editorPickHead,"editorPick");
            isAllElementClickableTrue = commonFunctionsHt.isAllElementClickableAndReturns200(editorPickList);
        }else{
            Utils.logStepInfo(false,editorPickList.size()+" cards are populating under Editors Pick Widget instead of "+noOfStories);
            return false;
        }
        return  isAllElementClickableTrue;
    }

    public boolean checkTrendingThisWeek(int noOfStories){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!trendingThisWeekList.isEmpty() && trendingThisWeekList.size()==noOfStories){
            Utils.logStepInfo(true,trendingThisWeekList.size()+" cards are populating under Trending this week Widget");
            commonFunctions.scrollToElement(trendingThisWeekHead,"trendingThisWeekHead");
            isAllElementClickableTrue = commonFunctionsHt.isAllElementClickableAndReturns200(trendingThisWeekList);
        }else{
            Utils.logStepInfo(false,trendingThisWeekList.size()+" cards are populating under Trending this week Widget instead of "+noOfStories);
            return false;
        }
        return isAllElementClickableTrue;
    }

    public boolean checkLatestNews(int noOfStories){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!latestNewsList.isEmpty() && latestNewsList.size()==noOfStories){
            Utils.logStepInfo(true,latestNewsList.size()+" cards are populating under Latest News RHS Widget");
            commonFunctions.scrollToElement(latestNewsHead,"latestNewsHead");
            isAllElementClickableTrue = commonFunctionsHt.isAllElementClickableAndReturns200(latestNewsList);
        }else{
            Utils.logStepInfo(false,latestNewsList.size()+" cards are populating under Latest News RHS Widget instead of "+noOfStories);
            return false;
        }
        return isAllElementClickableTrue;
    }

    public boolean verifyOnClickingLatestNewsCardHeadingRedirectionToLatestNewsPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(gadgetSearchBy,"gadgetSearchBy");
        commonFunctions.isElementDisplayed(latestNewsHead,10,"Latest News Heading");
        commonFunctions.clickElement(latestNewsHead,10,"Latest News Heading");
        boolean checkResponseCode = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) ==200;
        return commonFunctions.getCurrentURL().contains("latest-news") && checkResponseCode;
    }

    public boolean checkExploreCarEMI(int noOfStories){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!exploreCarEMIHeadList.isEmpty() && exploreCarEMIHeadList.size()==noOfStories){
            Utils.logStepInfo(true,exploreCarEMIHeadList.size()+" cards are populating under Explore car EMI Widget");
            commonFunctions.scrollToElement(exploreCarEMIHead,"exploreCarEMIHead");
            isAllElementClickableTrue = commonFunctionsHt.isAllElementClickableAndReturns200(exploreCarEMIHeadList);
        }else{
            Utils.logStepInfo(false,exploreCarEMIHeadList.size()+" cards are populating under Explore car EMI Widget instead of "+noOfStories);
            return false;
        }
        return isAllElementClickableTrue;
    }

    public boolean verifyOnClickingExploreCarEMICardHeadingRedirectionToCarLoanEMICalculatorPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(widgetPopularReviewHeading,"widgetPopularReviewHeading");
        commonFunctions.isElementDisplayed(exploreCarEMIHead,10,"Explore Card EMI Heading");
        commonFunctions.clickElement(exploreCarEMIHead,10,"Explore Card EMI Heading");
        boolean checkResponseCode = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) ==200;
        return commonFunctions.getCurrentURL().contains("car-loan-emi-calculator") && checkResponseCode;
    }

    public boolean checkSearchCarByBrandWidget(int noOfBrands){
        boolean isBrandElementClickableTrue ;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();
        commonFunctions.clickElement(widgetSearchByBrandTab,10,"widgetSearchByBrandTab");
        commonFunctions.clickElement(widgetSearchByBrandViewMoreButton,10,"widgetSearchByBrandViewMoreButton");
        commonFunctions.dummyWait(1);
        if(widgetSearchByBrandAndBodyTypeCarList.size()==noOfBrands){
            Utils.logStepInfo(true,widgetSearchByBrandAndBodyTypeCarList.size()+" brands are populating under Search car Widget");
            isBrandElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetSearchByBrandAndBodyTypeCarList,widgetSearchByBrandTab,widgetSearchByBrandViewMoreButton);
        }else{
            Utils.logStepInfo(false,widgetSearchByBrandAndBodyTypeCarList.size()+" brands are populating under Search car Widget instead of "+noOfBrands);
            return false;
        }
        return isBrandElementClickableTrue;
    }

    public boolean checkSearchCarByBudgetWidget(int noOfBudget){
        boolean isLatestElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();
        commonFunctions.clickElement(widgetSearchByBudgetTab,10,"widgetSearchByBudgetTab");
        commonFunctions.dummyWait(1);
        if(widgetSearchByBudgetCarList.size()==noOfBudget){
            Utils.logStepInfo(true,widgetSearchByBudgetCarList.size()+" budget options are populating under Search car Widget");
            isLatestElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetSearchByBudgetCarList,widgetSearchByBudgetTab);
        }else{
            Utils.logStepInfo(false,widgetSearchByBudgetCarList.size()+" budget options are populating under Search car Widget instead of "+noOfBudget);
            return false;
        }
        return isLatestElementClickableTrue;
    }

    public boolean checkSearchCarByBodyTypeWidget(int noOfBodyType){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();
        commonFunctions.clickElement(widgetSearchByBodyTypeTab,10,"widgetSearchByBodyTypeTab");
        commonFunctions.dummyWait(1);
        if(widgetSearchByBrandAndBodyTypeCarList.size()==noOfBodyType){
            Utils.logStepInfo(true,widgetSearchByBrandAndBodyTypeCarList.size()+" body type options are populating under Search car Widget");
            isAllElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetSearchByBrandAndBodyTypeCarList,widgetSearchByBodyTypeTab);
        }else{
            Utils.logStepInfo(false,widgetSearchByBrandAndBodyTypeCarList.size()+" body type options are populating under Search car Widget instead of "+noOfBodyType);
            return false;
        }
        return isAllElementClickableTrue;
    }

    public boolean clickOnBikeToggleToSearch(){
        boolean isElementClickable;
//        commonFunctions.scrollToElement(trendingThisWeekHead,"trendingThisWeekHead");
        isElementClickable = commonFunctions.clickElement(widgetSearchByBikeToggle,10,"widgetSearchByBikeToggle");
        return  isElementClickable;
    }

    public boolean checkSearchBikeByBrandWidget(int noOfBrands){
        boolean isBrandElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();
        clickOnBikeToggleToSearch();
        commonFunctions.dummyWait(1);
        commonFunctions.waitForElementBeDisplayAndClick(widgetSearchByBrandTab,10,"widgetSearchByBrandTab");
        commonFunctions.dummyWait(1);
        commonFunctions.waitForElementBeDisplayAndClick(widgetSearchByBrandViewMoreButton,10,"widgetSearchByBrandViewMoreButton");
        commonFunctions.dummyWait(1);
        if(widgetSearchByBrandAndBodyTypeBikeList.size()==noOfBrands){
            Utils.logStepInfo(true,widgetSearchByBrandAndBodyTypeBikeList.size()+" brands are populating under Search BIKE Widget");
            isBrandElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetSearchByBrandAndBodyTypeBikeList,widgetSearchByBikeToggle,widgetSearchByBrandTab,widgetSearchByBrandViewMoreButton);
        }else{
            Utils.logStepInfo(false,widgetSearchByBrandAndBodyTypeBikeList.size()+" brands are populating under Search BIKE Widget instead of "+noOfBrands);
            return false;
        }
        return isBrandElementClickableTrue;
    }

    public boolean checkSearchBikeByBudgetWidget(int noOfBudget){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();
        clickOnBikeToggleToSearch();
        commonFunctions.dummyWait(1);
        commonFunctions.clickElement(widgetSearchByBudgetTab,10,"widgetSearchByBudgetTab");
        commonFunctions.dummyWait(1);
        if(widgetSearchByBudgetBikeList.size()==noOfBudget){
            Utils.logStepInfo(true,widgetSearchByBudgetBikeList.size()+" budget options are populating under Search BIKE Widget");
            isAllElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetSearchByBudgetBikeList,widgetSearchByBikeToggle,widgetSearchByBudgetTab);
        }else{
            Utils.logStepInfo(false,widgetSearchByBudgetBikeList.size()+" budget options are populating under Search BIKE Widget instead of "+noOfBudget);
            return false;
        }
        return isAllElementClickableTrue;
    }

    public boolean checkSearchBikeByBodyTypeWidget(int noOfBodyType){
        boolean isAllElementClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToBottom();
        commonFunctions.scrollToTop();
        clickOnBikeToggleToSearch();
        commonFunctions.dummyWait(1);
        commonFunctions.clickElement(widgetSearchByBodyTypeTab,10,"widgetSearchByBodyTypeTab");
        commonFunctions.dummyWait(1);
        if(widgetSearchByBrandAndBodyTypeBikeList.size()==noOfBodyType){
            Utils.logStepInfo(true,widgetSearchByBrandAndBodyTypeBikeList.size()+" body type options are populating under Search BIKE Widget");
            isAllElementClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(widgetSearchByBrandAndBodyTypeBikeList,widgetSearchByBikeToggle,widgetSearchByBodyTypeTab);
        }else{
            Utils.logStepInfo(false,widgetSearchByBrandAndBodyTypeBikeList.size()+" body type options are populating under Search BIKE Widget instead of "+noOfBodyType);
            return false;
        }
        return isAllElementClickableTrue;
    }

    public boolean checkPopularReviews(int noOfStories){
        boolean isPopularMobileClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.scrollToElement(widgetPopularReviewHeading,"widgetPopularReviewHeading");
        if(!popularReviewsList.isEmpty() && popularReviewsList.size()==noOfStories){
            Utils.logStepInfo(true,popularReviewsList.size()+" cards are populating under Popular review Widget");
            isPopularMobileClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(popularReviewsList);
        }else{
            Utils.logStepInfo(false,popularReviewsList.size()+" cards are populating under Popular review Widget instead of "+noOfStories);
            return false;
        }
        return isPopularMobileClickableTrue;
    }

    public boolean checkLatestVideo(int noOfStories){
        boolean isLatestVideosClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!latestVideosList.isEmpty() && latestVideosList.size()==noOfStories){
            Utils.logStepInfo(true,latestVideosList.size()+" cards are populating under Latest Video Widget");
            isLatestVideosClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(latestVideosList);
        }else{
            Utils.logStepInfo(false,latestVideosList.size()+" cards are populating under Latest Video Widget instead of "+noOfStories);
            return false;
        }
        return isLatestVideosClickableTrue;
    }

    public boolean checkPhotoGallery(int noOfStories){
        boolean isPhotoGalleryClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!photoGalleryList.isEmpty() && photoGalleryList.size()==noOfStories){
            Utils.logStepInfo(true,photoGalleryList.size()+" cards are populating under Photo Gallery Widget");
            isPhotoGalleryClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(photoGalleryList);

        }else{
            Utils.logStepInfo(false,photoGalleryList.size()+" cards are populating under Photo Gallery Widget instead of "+noOfStories);
            return false;
        }
        return isPhotoGalleryClickableTrue;
    }

    @Override
    public boolean checkWebStory(int noOfStories){
        boolean isWebStoryClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        commonFunctions.clickElement(webStoriesSeeAll,10,"WebStoriesSeeAllButton");
        commonFunctions.navigateToHomePage();
        if(!webStoriesList.isEmpty() && webStoriesList.size()==noOfStories){
            Utils.logStepInfo(true,webStoriesList.size()+" cards are populating under Web Stories Widget");
            isWebStoryClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(webStoriesList);
        }else{
            Utils.logStepInfo(false,webStoriesList.size()+" cards are populating under Web Stories Widget instead of "+noOfStories);
            return false;
        }
        return isWebStoryClickableTrue;
    }

    public boolean checkElectricVehicleNews(int noOfStories){
        boolean isWebStoryClickableTrue;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
        if(!electricVehicleList.isEmpty() && electricVehicleList.size()==noOfStories){
            Utils.logStepInfo(true,electricVehicleList.size()+" cards are populating under Electric Vehicle News Widget");
            isWebStoryClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(electricVehicleList);
        }else{
            Utils.logStepInfo(false,electricVehicleList.size()+" cards are populating under Electric Vehicle News Widget instead of "+noOfStories);
            return false;
        }
        return isWebStoryClickableTrue;
    }

    @Override
    public boolean checkRecommenderForYou(int noOfStories){
        boolean isRecommenderClickableTrue = false;
        boolean isListSize;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollToElement(recommendViewAllButton,"recommendViewAllButton");
        commonFunctions.dummyWait(10);
        if(!recommenderForYouList.isEmpty() && recommenderForYouList.size()==noOfStories){
            isListSize = true;
            Utils.logStepInfo(true,recommenderForYouList.size()+" cards are populating under Recommender For You Widget");
            isRecommenderClickableTrue =commonFunctionsHt.isAllElementClickableAndReturns200(recommenderForYouList);
        }else{
            Utils.logStepInfo(false,recommenderForYouList.size()+" cards are populating under Recommender For You Widget instead of "+noOfStories);
            isListSize = false;
        }
        return isRecommenderClickableTrue && isListSize;
    }

    public boolean verifyOnClickingLatestVideoHeadingRedirectionToVideosStoryPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
//        commonFunctions.scrollToElement(latestVideosHead,"latestVideosHead");
        commonFunctions.isElementDisplayed(latestVideosHead,10,"Latest Videos Heading");
        commonFunctions.clickElement(latestVideosHead,10,"Latest Videos Heading");
        boolean checkResponseCode = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) ==200;
        return commonFunctions.getCurrentURL().contains("videos") && checkResponseCode;
    }

    public boolean verifyOnClickingPhotoGalleryHeadingRedirectionToPhotosStoryPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
//        commonFunctions.scrollToElement(widgetPhotoGallery,"widgetPhotoGallery");
        commonFunctions.isElementDisplayed(widgetPhotoGallery,10,"Photo Gallery Heading");
        commonFunctions.clickElement(widgetPhotoGallery,10,"Photo Gallery Heading");
        boolean checkResponseCode = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) ==200;
        return commonFunctions.getCurrentURL().contains("photos") && checkResponseCode;
    }

    public boolean verifyOnClickingElectricVehicleNewsHeadingRedirectionToElectricVehicleStoryPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsHt.waitForPageLoading();
//        commonFunctions.scrollToElement(electricVehicleNewsHead,"electricVehicleNewsHead");
        commonFunctions.isElementDisplayed(electricVehicleNewsHead,10,"Electric Vehicle News Heading");
        commonFunctions.clickElement(electricVehicleNewsHead,10,"Electric Vehicle News Heading");
        boolean checkResponseCode = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) ==200;
        return commonFunctions.getCurrentURL().contains("electric-vehicles") && checkResponseCode;
    }
}