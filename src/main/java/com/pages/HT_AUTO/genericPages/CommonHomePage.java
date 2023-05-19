package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonHomePage {
    private static CommonHomePage commonHomePageNew;
    private static GlobalVars globalVars;

    public static CommonHomePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonHomePageNew == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonHomePageNew = new HomePage();
                    break;
                case Constants.ANDROID_WEB:
//                    commonHomePageNew = new HomePageNew();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonHomePageNew;
    }


    public abstract boolean verifyLeftStoriesAreDisplayed();

    public abstract boolean verifyRightStoriesAreDisplayed();

    public abstract boolean verifyHTAutoLogoRedirection();

    public abstract boolean verifyHomePageRedirectionInList();

    public abstract boolean verifyHomePageOptions(ArrayList<String> homePageOptions);

    public abstract boolean verifyHomePageOptionsAreClickable();

    public abstract boolean checkTopFirstStandardImageStory();

    public abstract boolean checkAllTopStoriesTitle();

    public abstract boolean checkBottomAdsDisplaying_3();

    public abstract boolean checkTopAdDisplaying_2();

    public abstract boolean checkHomePageRHSAdsAreDisplayed_1();

    public abstract boolean verifyFBIcon();

    public abstract boolean verifyTwitterIcon();

    public abstract boolean verifyYoutubeIcon();

    public abstract boolean verifyLocateDealerWidgetRedirectionToDealerPage();

    public abstract boolean searchCarDealersBySelectingBrandAndCity(String brand, String city);

    public abstract boolean checkTopAutomobilesBikePopularWidget(int noOfCards);

    public abstract boolean checkTopAutomobilesBikeLatestWidget(int noOfCards);

    public abstract boolean checkTopAutomobilesBikeUpcomingWidget(int noOfCards);

    public abstract boolean checkTopAutomobilesCarPopularWidget(int noOfCards);

    public abstract boolean checkTopAutomobilesCarLatestWidget(int noOfCards);

    public abstract boolean checkTopAutomobilesCarUpcomingWidget(int noOfCards);

    public abstract boolean checkTopComparisonsCarWidget(int noOfCards);

    public abstract boolean checkTopComparisonsBikeWidget(int noOfCards);

    public abstract boolean checkTrendingNewsHeadingOnClickingSearchBox();

    public abstract boolean searchAnyProductUsingValidKeyword(String str);

    public abstract boolean searchAnyProductUsingInValidKeyword(String str);

    public abstract boolean checkEditorPick(int noOfStories);

    public abstract boolean checkTrendingThisWeek(int noOfStories);

    public abstract boolean checkLatestNews(int noOfStories);

    public abstract boolean checkExploreCarEMI(int noOfStories);

    public abstract boolean verifyOnClickingLatestNewsCardHeadingRedirectionToLatestNewsPage();

    public abstract boolean verifyOnClickingExploreCarEMICardHeadingRedirectionToCarLoanEMICalculatorPage();

    public abstract boolean checkSearchCarByBrandWidget(int noOfBrands);
    public abstract boolean checkSearchCarByBudgetWidget(int noOfBudget);
    public abstract boolean checkSearchCarByBodyTypeWidget(int noOfBodyType);

    public abstract boolean checkSearchBikeByBrandWidget(int noOfBrands);
    public abstract boolean checkSearchBikeByBudgetWidget(int noOfBudget);
    public abstract boolean checkSearchBikeByBodyTypeWidget(int noOfBodyType);
    public abstract boolean checkPopularReviews(int noOfStories);

    public abstract boolean checkLatestVideo(int noOfStories);

    public abstract boolean checkPhotoGallery(int noOfStories);

    public abstract boolean checkWebStory(int noOfStories);

    public abstract boolean checkElectricVehicleNews(int noOfStories);

    public abstract boolean checkRecommenderForYou(int noOfStories);

    public abstract boolean verifyOnClickingLatestVideoHeadingRedirectionToVideosStoryPage();

    public abstract boolean verifyOnClickingPhotoGalleryHeadingRedirectionToPhotosStoryPage();

    public abstract boolean verifyOnClickingElectricVehicleNewsHeadingRedirectionToElectricVehicleStoryPage();
}