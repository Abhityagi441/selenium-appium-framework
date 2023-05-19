package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.commonFunctions.CommonFunctionsMobileLM;
import com.pages.LiveMint.genericPages.CommonHomePage;
import com.pages.LiveMint.genericPages.CommonSectionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SectionPage extends CommonSectionPage {

    private AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private  static CommonFunctionsMobileLM commonFunctionsMobile;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreMenuButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement adCloseButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Technology']")
    private static MobileElement technologyButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement technologyTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> technologyPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brand Stories']")
    private static MobileElement brandStoriesButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quick Reads']")
    private static MobileElement quickReadsButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement quickReadStory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Brand Post']")
    private static MobileElement brandPostButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement brandPostTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/tvAppVersion")
    private static MobileElement appVersion;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement brandStoriesTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> brandStoriesPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Companies']")
    private static MobileElement companiesButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement companiesTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> companiesPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    private static MobileElement educationButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement educationPageTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> educationPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Industry']")
    private static MobileElement industryButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement industryTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> industryPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Markets']")
    private static MobileElement marketsButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement marketsTitle;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> marketsPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Podcast']")
    private static MobileElement podcastButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private static MobileElement privacyPolicyButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> exploreWidgetTextList;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> browserOptions;

    @AndroidFindBy(id = "android:id/button_once")
    private static MobileElement justOnceButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chrome']")
    private static MobileElement chromeBrowser;

    @AndroidFindBy(className = "android.widget.Image")
    private static List<MobileElement> podcastElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sports']")
    private static MobileElement sportsButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> sportsPageElementList;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement sportsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Politics']")
    private static MobileElement polictsButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static List<MobileElement> politcsPageElementList;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement politcsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Auto News']")
    private static MobileElement autoNewsButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> autoNewsPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='AUTO NEWS']")
    private static MobileElement autoNewsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Budget 2022']")
    private static MobileElement budgetButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewNewsHeadline")
    private static List<MobileElement> budgetStoriesPageElementList;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement budgetStoriesTitle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Mutual Funds'])[1]")
    private static MobileElement mutualFundsButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> mutualFundsPageElementList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MUTUAL FUNDS']")
    private static MobileElement mutualFundsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Opinion']")
    private static MobileElement opinionButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private static List<MobileElement> opinionPageElementList;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement opinionTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Insurance']")
    private static MobileElement insuranceButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement insuranceTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Photos']")
    private static MobileElement photosButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PHOTOS']")
    private static MobileElement photosTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Money']")
    private static MobileElement moneyButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement moneyTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lounge']")
    private static MobileElement loungeButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement loungeTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MINT LOUNGE']")
    private static MobileElement loungeLogo;

    @AndroidFindBy(id = "//android.view.View[@content-desc='HT Podcasts']/android.widget.Image")
    private static MobileElement htSmartCastLogoText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign In']")
    private static WebElement signInButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewTitle")
    private static MobileElement searchTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    private static MobileElement searchButton;

    @AndroidFindBy(id = "com.htmedia.mint:id/tv_topic")
    private static MobileElement anotherSearchPageHeadline;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Videos']")
    private static MobileElement videosSection;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='VIDEOS']")
    private static MobileElement videoPageTitle;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private static MobileElement DontAllow;
    @FindBy(id = "com.htmedia.mint:id/txtViewTitleExplore")
    private static MobileElement explorePageText;
    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'nudge')]//android.widget.RelativeLayout/android.widget.ImageView")
    private static MobileElement popUpAdClose;
    @AndroidFindBy(id = "com.htmedia.mint:id/tv_skip")
    private static MobileElement skipAdsButton;
    @AndroidFindBy(id = "com.htmedia.mint:id/btnYes")
    private static MobileElement yesIAmInButton;
    @FindBy(id = "com.htmedia.mint:id/ll_continue")
    private static MobileElement continueAdsPopup;
    @AndroidFindBy(id = "com.htmedia.mint:id/ivExplore")
    private static MobileElement exploreHamburger;
    @FindBy(xpath = "//android.widget.TextView[@text='EXPLORE']")
    private static MobileElement explorePage;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewPodcasts")
    private static MobileElement podcastOption;
    @FindBy(xpath = "//android.widget.TextView[@text='PODCAST']")
    private static MobileElement podcastPage;

    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        this.driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLM.getInstance();
    }


    public boolean isBrandStoriesPageLoading(List<MobileElement> eleList, String elementName) {
        boolean isBrandStoriesPageLoadingTrue = false;
        MobileElement ele;
        try {
            for (int i = 0; i < eleList.size(); i++) {
                ele = eleList.get(i);
                commonFunctions.scrollDownToElement(ele,5);
                if (commonFunctions.isElementDisplayed(ele,10,"list of elements")) {
                    isBrandStoriesPageLoadingTrue = true;
                    Utils.logStepInfo(true, elementName + " page is not blank");
                    break;
                }
            }
        } catch (Exception e) {
            isBrandStoriesPageLoadingTrue = false;
            Utils.logStepInfo(false, elementName + " page is blank");
            e.printStackTrace();
        }
        return isBrandStoriesPageLoadingTrue;
    }

    public boolean isAllElementDisplayed(List<MobileElement> eleList, long timeOutInSecond) {
        boolean isAllElementDisplayedTrue = false;
        WebDriverWait wait;
        try {
            for (MobileElement ele : eleList) {
                wait = new WebDriverWait(driver, timeOutInSecond);
                wait.until(ExpectedConditions.visibilityOfAllElements(ele));
                if (ele.isDisplayed()) {
                    isAllElementDisplayedTrue = true;
                }
            }
        } catch (Exception e) {
            isAllElementDisplayedTrue = false;
            Utils.logStepInfo(false, "All element is not display");
        }
        return isAllElementDisplayedTrue;
    }

    @Override
    public boolean checkCompaniesSectionPage(String[] params) {
        boolean isCompaiesSectionPageNotBlank = true;
        String companiesText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(companiesButton);
        isCompaiesSectionPageNotBlank &= commonFunctions.clickElement(companiesButton, 10, companiesText);
        String titleText = commonFunctions.getElementText(companiesTitle);
        isCompaiesSectionPageNotBlank &= commonFunctions.isCompareTextTrue(titleText, companiesText);
        isCompaiesSectionPageNotBlank &= isBrandStoriesPageLoading(companiesPageElementList, companiesText);
        backToHomepage();
        return isCompaiesSectionPageNotBlank;
    }

    @Override
    public boolean checkEducationSectionPage(String[] params) {
        boolean isEducationSectionPageNotBlank;
        String educationText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(educationButton);
        commonFunctions.dummyWait(2);
        isEducationSectionPageNotBlank = commonFunctions.clickElement(educationButton, 10, educationText);
        String titleText = commonFunctions.getElementText(educationPageTitle);
        isEducationSectionPageNotBlank &= commonFunctions.isCompareTextTrue(titleText, educationText);
        isEducationSectionPageNotBlank &= isBrandStoriesPageLoading(educationPageElementList, educationText);
        backToHomepage();
        return isEducationSectionPageNotBlank;
    }

    @Override
    public boolean checkIndustrySectionPage(String[] params) {
        boolean isIndustrySectionPageNotBlank = true;
        String industryText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(industryButton, industryText);
        isIndustrySectionPageNotBlank &= commonFunctions.clickElement(industryButton, 10, industryText);
        String titleText = commonFunctions.getElementText(industryTitle, 10);
        isIndustrySectionPageNotBlank &= commonFunctions.isCompareTextTrue(titleText, industryText);
        isIndustrySectionPageNotBlank &= isBrandStoriesPageLoading(industryPageElementList, industryText);
        backToHomepage();
        return isIndustrySectionPageNotBlank;
    }

    @Override
    public boolean checkMarketSectionPage(String[] params) {
        boolean isMarketSectionNotBlank = true;
        String marketText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(photosButton);
        commonFunctions.clickElement(marketsButton, 10, "Market Section");
        commonFunctions.isElementDisplayed(marketsTitle, 10, "Markets Page Title");
        isMarketSectionNotBlank= isBrandStoriesPageLoading(marketsPageElementList, marketText);

        return isMarketSectionNotBlank;
    }

    public boolean selectElementFromAvailableOption(List<MobileElement> elementList, String text) {
        boolean isSelectElementFromAvailableOption = false;
        try {
            for (int i = 0; i < elementList.size(); i++) {
                MobileElement ele = elementList.get(i);
                String eleText = ele.getText().trim();
                if (eleText.contains(text)) {
                    isSelectElementFromAvailableOption = commonFunctions.clickElement(ele, 10, text + " button");
                    break;
                }
            }
        } catch (Exception e) {
            isSelectElementFromAvailableOption = false;

        }
        return isSelectElementFromAvailableOption;
    }

    @Override
    public boolean checkTechnologySectionPage(String[] params) {
        boolean isIndustrySectionPageNotBlank = true;
        String technologyText = params[0];
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        commonFunctions.scrollDownSlowToElement(technologyButton,1);
        isIndustrySectionPageNotBlank &= commonFunctions.clickElement(technologyButton, 10, technologyText);
        String titleText = commonFunctions.getElementText(technologyTitle);
        isIndustrySectionPageNotBlank &= commonFunctions.isCompareTextTrue(titleText, technologyText);
        isIndustrySectionPageNotBlank &= isBrandStoriesPageLoading(technologyPageElementList, technologyText);
        backToHomepage();
        return isIndustrySectionPageNotBlank;
    }


    @Override
    public boolean checkSportsSectionPage(String[] params) {
        boolean isSportsSectionPageNotBlank = true;
        String sportsText = params[0];
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        commonFunctions.scrollDownToElement(sportsButton);
        commonFunctions.clickElement(sportsButton, 10, sportsText);
        String titleText = commonFunctions.getElementText(sportsTitle);
        isSportsSectionPageNotBlank &= commonFunctions.isCompareTextTrue(titleText, sportsText);
        isSportsSectionPageNotBlank &= isBrandStoriesPageLoading(sportsPageElementList, sportsText);
        backToHomepage();
        return isSportsSectionPageNotBlank;
    }

    @Override
    public boolean checkPoliticsSectionPage(String[] params) {
        boolean isPoliticsSectionPageNotBlank = true;
        String politicsText = params[0];
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        isPoliticsSectionPageNotBlank= commonFunctions.isElementDisplayed(explorePageText, 10, "explore text");
        commonFunctions.scrollUpToElementDisplayed(educationButton);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(polictsButton, 10, politicsText);
        String titleText = commonFunctions.getElementText(politcsTitle);
        isPoliticsSectionPageNotBlank &= commonFunctions.isCompareTextTrue(titleText, politicsText);
        isPoliticsSectionPageNotBlank &= commonFunctions.isElementDisplayedOfListOfElements(politcsPageElementList, "Politics page headline");
        backToHomepage();
        return isPoliticsSectionPageNotBlank;
    }

    @Override
    public boolean checkInsuranceSectionPage(String[] params) {
        boolean isInsuranceSectionPageNotBlank = true;
        String insuranceText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(insuranceButton);
        commonFunctions.clickElement(insuranceButton, 10, insuranceText);
        String titleText = commonFunctions.getElementText(insuranceTitle);
        isInsuranceSectionPageNotBlank &= commonFunctions.isCompareTextTrue(titleText, insuranceText);
        isInsuranceSectionPageNotBlank &= commonFunctions.isElementDisplayedOfListOfElements(politcsPageElementList, "Insurance page headline");
        backToHomepage();
        return isInsuranceSectionPageNotBlank;
    }

    @Override
    public boolean checkMoneySectionPage(String[] params) {
        boolean isMoneySectionShouldNotBlank = true;
        String autoNewsText = params[0];

         commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        commonFunctions.scrollDownToElement(moneyButton);
        isMoneySectionShouldNotBlank &= commonFunctions.clickElement(moneyButton, 10, autoNewsText);
        String titleText = commonFunctions.getElementText(moneyTitle);
        isMoneySectionShouldNotBlank &= commonFunctions.isCompareTextTrue(titleText, autoNewsText);
        isMoneySectionShouldNotBlank &= isBrandStoriesPageLoading(mutualFundsPageElementList, autoNewsText);

        return isMoneySectionShouldNotBlank;
    }

    @Override
    public boolean checkMutualFundSectionPage(String[] params) {
        boolean isMutualFundSectionShouldNotBlank = true;
        String autoNewsText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(mutualFundsButton);
        isMutualFundSectionShouldNotBlank &= commonFunctions.clickElement(mutualFundsButton, 10, autoNewsText);
        commonFunctions.isElementDisplayed(mutualFundsTitle,10,"Mutual funds title");
        backToHomepage();
        return isMutualFundSectionShouldNotBlank;
    }

    @Override
    public boolean checkOpinionSectionPage(String[] params) {
        boolean isOpinionSectionShouldNotBlank = true;
        String autoNewsText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(opinionButton);
        isOpinionSectionShouldNotBlank &= commonFunctions.clickElement(opinionButton, 10, autoNewsText);
        String titleText = commonFunctions.getElementText(opinionTitle);
        isOpinionSectionShouldNotBlank &= commonFunctions.isCompareTextTrue(titleText, autoNewsText);
        isOpinionSectionShouldNotBlank &= isBrandStoriesPageLoading(opinionPageElementList, autoNewsText);
        backToHomepage();
        return isOpinionSectionShouldNotBlank;
    }

    @Override
    public boolean checkPhotosSectionPage(String[] params) {
        boolean isPhotosSectionPageNotBlank = true;
        String photosText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(insuranceButton);
        commonFunctions.clickElement(photosButton, 10, photosText);
        commonFunctions.isElementDisplayed(photosTitle, 10, "Photos Page Title");
        isPhotosSectionPageNotBlank= commonFunctions.isElementDisplayedOfListOfElements(politcsPageElementList, "Photo page headline");
        backToHomepage();
        return isPhotosSectionPageNotBlank;
    }

    @Override
    public boolean videoValidation() {
        boolean isShowing;
         commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        commonFunctions.scrollDownToElement(videosSection);
        commonFunctions.clickElement(videosSection, 10, "video");
        isShowing = commonFunctions.isElementDisplayed(videoPageTitle, 10, "video page title");
//TODO: Video play and pause button not verified due to loactor is not available in DOM.
        return isShowing;
    }

    @Override
    public boolean checkSearchSectionPage(String serachText) {
        boolean isShowing;
        commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(exploreHamburger, 10, "Explore Menu button");
        isShowing = commonFunctions.isElementDisplayed(explorePage, 10, "explore page");
        isShowing &= commonFunctions.clickElement(searchButton, 10, serachText);
        String titleText = commonFunctions.getElementText(searchTitle);
        isShowing &= commonFunctions.isCompareTextTrue(titleText, serachText);
        commonFunctions.isElementDisplayed(anotherSearchPageHeadline, 10, "One of " + serachText + " page realated headlines");
        return isShowing;
    }

    @Override
    public boolean checkAutoNewsPage(String[] params) {
        boolean isAutoNewsSectionShouldNotBlank = true;
        String autoNewsText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(industryButton);
        commonFunctions.clickElement(autoNewsButton, 10, "Auto News Section");
        commonFunctions.isElementDisplayed(autoNewsTitle, 10, "Auto News Title");
        isAutoNewsSectionShouldNotBlank = isBrandStoriesPageLoading(autoNewsPageElementList, autoNewsText);
        backToHomepage();
        return isAutoNewsSectionShouldNotBlank;
    }

    private void backToHomepage(){
        commonFunctions.navigateBack();
        commonFunctions.dummyWait(3);
        commonFunctions.navigateBack();
    }

    @Override
    public boolean checkPodcastPage(String[] params) {
        boolean isShowing = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        isShowing &= commonFunctionsMobile.clickOnExplorePodcastAndVerifyPage(podcastOption, podcastPage);
        commonFunctions.navigateBack();
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkBrandStoriesPage(String[] params) {
        boolean isBrandStoriesSectionShouldNotBlank = true;
        String brandStoryText = params[0];
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(brandStoriesButton);
        isBrandStoriesSectionShouldNotBlank &= commonFunctions.clickElement(brandStoriesButton, 10, brandStoryText);
        String titleText = commonFunctions.getElementText(brandStoriesTitle);
        isBrandStoriesSectionShouldNotBlank &= commonFunctions.isCompareTextTrue(titleText, brandStoryText);
        isBrandStoriesSectionShouldNotBlank &= isBrandStoriesPageLoading(brandStoriesPageElementList, brandStoryText);
        backToHomepage();
        return isBrandStoriesSectionShouldNotBlank;
    }


    @Override
    public boolean checkBrandPostPage(String[] params) {
        boolean isBrandPostSectionShouldNotBlank;
         commonFunctions.clickElement(homeButton, 10, "Home button");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        commonFunctions.scrollDownToElement(brandPostButton);
        commonFunctions.clickElement(brandPostButton, 10, "Brand Post Button");
        isBrandPostSectionShouldNotBlank = commonFunctions.isElementDisplayed(brandPostTitle, 10, "Brand Post Title");

        return isBrandPostSectionShouldNotBlank;
    }

    @Override
    public boolean checkBudgetPage(String[] params) {
        String brandStoryText = params[0];
        boolean isBudgetSectionShouldNotBlank = commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(budgetButton);
        isBudgetSectionShouldNotBlank &= commonFunctions.clickElement(budgetButton, 10, brandStoryText);
        String titleText = commonFunctions.getElementText(budgetStoriesTitle);
        isBudgetSectionShouldNotBlank &= commonFunctions.isCompareTextTrue(titleText, brandStoryText);
        isBudgetSectionShouldNotBlank &= isBrandStoriesPageLoading(budgetStoriesPageElementList, brandStoryText);
        backToHomepage();
        return isBudgetSectionShouldNotBlank;
    }

    @Override
    public boolean checkLoungePage() {
        boolean isLoungePageTrue;
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(loungeButton);
        isLoungePageTrue = commonFunctions.clickElement(loungeButton, 10, "Lounge button");
        isLoungePageTrue &= commonFunctions.isElementVisible(loungeLogo, 100, "Lounge logo");
        backToHomepage();
        return isLoungePageTrue;
    }

    @Override
    public boolean checkQuickReadsPage(String[] params) {
        boolean isQuickReadsPageShouldNotBlank;

        commonFunctions.clickElementIfDisplayed(yesIAmButton, 10, "Yes I am in button");
        commonFunctions.clickElementIfDisplayed(adCloseButton, 10, "Ad close");
        commonFunctions.clickElement(exploreMenuButton, 10, "Explore Menu button");
        commonFunctions.clickElementIfDisplayed(quickReadsButton, 10, "Quick Reads Button");
        commonFunctions.isElementDisplayed(quickReadStory, 10, "QuickReads Story Headline");
        isQuickReadsPageShouldNotBlank = commonFunctions.clickElement(quickReadStory, 10, "Story Loaded");
        backToHomepage();
        return isQuickReadsPageShouldNotBlank;
    }

    @Override
    public boolean checkAppVersionDisplayed(){
        commonFunctionsMobile.clickOnExploreHamburger(homeButton,exploreHamburger,explorePage);
        commonFunctions.scrollDownToElement(appVersion);
        boolean appVersionDisplayed= commonFunctions.isElementDisplayed(appVersion, 10, "App version details");
       commonFunctions.navigateBack();
        return appVersionDisplayed;
    }

    @Override
    public void clickOnHomeAndExploreTab() {

    }

    @Override
    public boolean checkOpinionPageMastHead() {
        return false;
    }

    @Override
    public boolean checkBankingSubSectionPage() {
        return false;
    }

    @Override
    public boolean checkBankingPageTopNav() {
        return false;
    }

    @Override
    public boolean checkIndustryPageParagraphShare() {
        return false;
    }

}
