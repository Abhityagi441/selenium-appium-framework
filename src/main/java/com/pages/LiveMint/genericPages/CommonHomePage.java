package com.pages.LiveMint.genericPages;


import com.pages.LiveMint.android_native.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHomePage {
    private static CommonHomePage commonHomePage;
    private static GlobalVars globalVars;

    public static CommonHomePage getInstance() {
        System.out.println("******************* beforeMethod HomePage starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonHomePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonHomePage = new com.pages.LiveMint.web.HomePage();
                    break;
                case Constants.ANDROID_AMP:
                    commonHomePage = new com.pages.LiveMint.android_amp.HomePage();
                    break;
                case Constants.IOS_AMP:
                    commonHomePage = new com.pages.LiveMint.ios_amp.HomePage();
                    break;
                case Constants.ANDROID_WEB:
                    commonHomePage = new com.pages.LiveMint.android_mweb.HomePage();
                    break;
                case Constants.IOS_WEB:
                    commonHomePage = new com.pages.LiveMint.ios_mweb.HomePage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonHomePage = new HomePage();
                    break;
                case Constants.IOS_NATIVE:
                    commonHomePage = new com.pages.LiveMint.ios_native.HomePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod HomePage ends here *******************");
        return commonHomePage;
    }

    public abstract boolean notification(String apiURL, String faviconURL);

    public abstract boolean marketTicker(String[] marketTickerTestData);

    public abstract boolean storyPage();

    public abstract boolean shareStory();

    public abstract boolean bookmarkStory();

    public abstract boolean bookmarkStoryLoggedInUser();

    public abstract boolean apiForFirstStory(String[] apiForFirstStoryTestData);

    public abstract boolean pageTitle();

    public abstract boolean nonSubscribedUserPaywall(String apiURL);

    public abstract boolean pageContent(String apiURL);

    public abstract boolean shareStoryFunctionality();

    public abstract boolean siteMap(String siteMapURL);

    public abstract boolean checkHamburger();

    public abstract boolean myAccountFunctionality(String password, String newPassword, String expectedUserName, String newName, String email, String manageProfileURL);

    public abstract boolean subscribedUserPaywall();

    public abstract boolean checkDuplicateEntriesForLatestNews();

    public abstract boolean checkStoryPageWidgets();

    public abstract boolean checkLMPremiumPage(String[] params);

    public abstract boolean checkRHSWidgetsHomePage(String[] params);

    public abstract boolean listenToArticle();

    public abstract boolean checkHindustanWidgetHomePage(String[] params);

    public abstract boolean checkMintEPaperBanner();

    public abstract boolean checkHomePageSrollsTillEnd();

    public abstract boolean checkEPaperSubscribedUser();

    public abstract boolean checkEPaperNonSubscribedUser();

    public abstract boolean checkMintLogo();

    public abstract boolean checkMintLogoLocation();

    public abstract boolean checkBottomNavigation();

    public abstract boolean checkBottomNavigationAllPages();

    public abstract boolean checkBottomNavigationFocus();

    public abstract boolean clickAndVerifyMintLoungeStory();

    public abstract boolean checkMintGenieBanner();

    public abstract boolean checkViewAllButtonOnMintPremium();

    public abstract boolean checkAndVerifyViewAllOnMintPremiumCarousel();

    public abstract boolean checkAndVerifyViewAllOnWSJCarousel();

    public abstract boolean checkAndVerifyStoryOnWSJCarousel();

    public abstract boolean checkAndVerifyViewAllOnMintLoungeCarousel();

    public abstract boolean checkSignInLink();

    public abstract boolean checkSubscribeLink();

    public abstract boolean checkSubscribeRedirection(String choosePlan);

    public abstract boolean checkSignInLinkRedirection(String loginRegisterText, String google, String facebook, String apple, String emailOrMobile);

    public abstract boolean checkStoryNavigationWSJCrousel(String text);

    public abstract boolean checkBottomNavigationSection();

    public abstract boolean checkMyAccountLink();

    public abstract void clickOnHomeButtonWithHandlingDarkMode();

    public abstract boolean subscribedUserAdsFreeHomepage();

    public abstract boolean checkHomePage();

    public abstract boolean subscribedUserAdsFreeApp();

    public abstract boolean sponsoredStory();

    public abstract boolean checkBookmarkBeforeLogin();

    public abstract boolean checkBrandedContent();

    public abstract boolean checkAppRefreshFunctionality();

    public abstract boolean checkNewArticlesOnlyOnHomePage();

    public abstract boolean checkInVisibilityOfNewArticleOnHomePageAfterClickOnNewArticle();

    public abstract boolean checkInVisibilityOfNewArticleAfterRefreshedHomePage();

    public abstract boolean checkInVisibilityOfSponsoredStoryBookmarkButtonHomePage();

    public abstract boolean checkInVisibilityOfSponsoredStoryOnHomePage();

    public abstract boolean checkVisibilityOfSponsoredStoryOnHomePage();

    public abstract boolean checkInVisibilityOfSponsoredStoryOn();

    public abstract boolean checkAdvertisementLabelAndRemoveAdsButtonPosition(String advertisement, String removeAd);

    public abstract boolean checkRemoveAdButtonFunctionality();

    public abstract boolean checkExploreHamburgerPosition(String iosExplorePos, String androidExplorePos);

    public abstract boolean checkNewsSectionReplacingLatestSection();

    public abstract boolean checkNoAdsOnHomePage();

    public abstract boolean newsLetterFunctionalityAndDesign();

    public abstract boolean checkAdOnHomePage();

    public abstract boolean checkAdOnStoryDetailPagePage();

    public abstract boolean checkExploreAsHamburger();

    public abstract boolean checkExploreRemoveFromNavigation();

    public abstract boolean checkEPaperIcon();

    public abstract boolean checkSubscribeIcon();

    public abstract boolean checkMyaccountIcon();

    public abstract boolean checkNewsLetterBanner();

    public abstract boolean checkPositionOfNewsLetterForSubscribedUser();

    public abstract boolean checkSubscribedUser();
    public abstract boolean checkSqureCardContainsForThatStory();

     public abstract boolean checkMarketCardtypePagefunctionality();

    public abstract boolean checkMutualFundsWidgetAndSubCategoryDropDown();

    public abstract boolean checkCompanyDetailPageRelatedNewsListing();

    public abstract boolean checkMutualFundWidgetTitle();

    public abstract boolean checkSubCategoryDropDown();
    public abstract boolean checkSubCategoryDefaultSection();

    public abstract boolean checkMutualFundCategoryTabs();

    public abstract boolean checkSubTitleoFMutualFundPage();

    public abstract boolean checkTopLosersViewAllFunctionality();

    public abstract boolean checkTopGainersViewAllFunctionality();

    public abstract boolean checkIndianIndicesList();

    public abstract boolean checkIndicesSection();

    public abstract boolean checkNseTop4GainersAndLosers();

    public abstract boolean checkBseTop4GainersAndLosers();

    public abstract boolean checkGainersAndLosers();

    public abstract boolean checkTopGainersViewAll();

    public abstract boolean checkIndianIndicesViewAll();

    public abstract boolean checkGainerLosersDesign(String gainerLoserText);

    public abstract boolean checkBseTabsGainerLosers();

    public abstract boolean checkNseTabsGainerLosers();

    public abstract boolean checkBse100NewsSection();

    public abstract boolean checkIndicesRedirectionFunctionality();

    public abstract boolean checkTickerStockMarketNiftyAndSenSex();

    public abstract boolean checkCompanyDetailLineGraph();

    public abstract boolean checkDetailPageOfNseAndBse();

    public abstract boolean checkMostActiveByVolume();

    public abstract boolean checkMostActiveByVolumeDesign();

    public abstract boolean checkMostActiveByVolumeViewAll();

    public abstract boolean checkCompanyDetailPageDesign();

    public abstract boolean checkCompanyDetailPageInfo();

    public abstract boolean checkFinancialStandalone();

    public abstract boolean checkCompanyDetailPagePriceHistoryGainerLoser();

    public abstract boolean checkMostActiveByVolumeBelowGainernLoser();

    public abstract boolean checkIndianIndicesSection();

    public abstract boolean checkGainersAndLosersBelowIndianIndices();

    public abstract boolean checkCompanyDetailPagePriceHistory();

    public abstract boolean checkCompanyDetailPageGainerLoser();
    public abstract boolean checkGainerLoserCompanyDetailPageCompanyInfo();

    public abstract boolean checkGainerLoserFinancialStandalone();
    public abstract boolean checkGainerLoserCompanyDetailPagePriceHistory();
    public abstract boolean checkGainerLoserCompanyDetailPageDesign();
    public abstract boolean checkCompanyDetailPageSpecificIndianIndices();
    public abstract boolean checkTickerDetailPage();
    public abstract boolean checkTickerPriceAndPercentage();
    public abstract boolean checkMarket();
    public abstract boolean checkMarketTickerNiftyBankDetailPage();


    public abstract boolean checkNewEpaperIconOnTop();

    public abstract boolean checkNewSignInIconOnTop();

    public abstract boolean checkNewSubscribeIconOnTop();

    public abstract boolean checkL1TabOnHomePage();

    public abstract boolean checkL1TabSelection();

    public abstract boolean checkL1TabBackButtonFunctionality();

    public abstract boolean checkFocusOnL1TabClickingOnHomeButton();

    public abstract boolean checkL1MenuSelectionBySwipingTheHomePage();

    public abstract boolean checkTickerCategoryD();

    public abstract boolean checkSectionNameWithListedStory();

    public abstract boolean checkTickerArrow();

    public abstract boolean checkLatestScrollOnLatestNewsPage();

    public abstract boolean checkMintTop50MF(String pageTitle);

    public abstract boolean checkMintTop50MFForSubscribedUsers(String pageTitle);

    public abstract boolean checkL1TabSelectionDiffStory();

    public abstract boolean checkColumnsSubSectionInTopNav();

    public abstract boolean checkMFSectionInTopNav();

    public abstract boolean checkNewsSubsectionUnderMFInTopNav();

    public abstract boolean checkViewsSubsectionUnderOpinionInTopNav();

    public abstract boolean checkViewsSubsectionStoryPage();

    public abstract boolean checkViewsSubsectionPageLayout();

    public abstract boolean checkOpinionsSectionInTopNav();

    public abstract boolean checkIndustryPageLayout();

    public abstract boolean checkBreadcrumbOnCompaniesPage();

    public abstract boolean checkTwitterPageWhenTapOnTwitterIcon();

    public abstract  boolean checkLinkedinPageWhenTapOnLinkedinIcon();

    public abstract boolean checkFacebookPageWhenTapOnFacebookIcon();

    public abstract boolean checkOpinionSectionStoryDetails();

    public abstract boolean checkShareholdingWidget();

    public abstract boolean checkCompaniesLandingPage();
    public abstract boolean checkAppLaunch();
    public abstract boolean checkHeaderElements();

    public abstract boolean checkPremiumIconOnBottom();

    public abstract boolean checkPlanPageAllActivePlan();

    public abstract boolean checkApplyCouponAndSignInOption();

    public abstract boolean checkHeaderNavigationOfEachTab();

    public abstract boolean checkPodcastEpisodePage();

    public abstract boolean checkPodcastEpisode();

    public abstract boolean checkVideoListingLandingPageStructure();

    public abstract boolean checkLoginInPage();

    public abstract boolean checkEditProfileGender();

    public abstract boolean checkHomePageAsExpected();

    public abstract boolean checkSubscriptionInformation();

    public abstract boolean checkAuthorDetailsPage();

    public abstract boolean checkAuthorPageLayout();

    public abstract boolean checkSportsLandingPage();

    public abstract boolean checkL1NavInSportsLandingPage();

    public abstract boolean checkLHSGainerLoserWidget(String pageName, String widgetName);

    public abstract boolean checkMintPremiumCarousel();

    public abstract boolean checkSummaryOnSportsStoryPage();

    public abstract boolean checkParagraphOnSportsPage();
}
