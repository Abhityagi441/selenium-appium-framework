package com.pages.HT_TECH.generic;
import com.pages.HT_TECH.web.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;
public abstract class CommonHomePage {
    private static CommonHomePage commonHomePage;
    private static GlobalVars globalVars;
    public static CommonHomePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonHomePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {

                case Constants.DESKTOP_WEB:
                    commonHomePage = new HomePage();
                    break;

            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonHomePage;
    }
    public abstract boolean checkLeftTopWidget();
    public abstract boolean checkRightTopWidget();
    public abstract boolean checkHTAutoRedirection();

    public abstract boolean checkFirstHeadline();

    public abstract boolean checkRightStoriesWidget();

    public abstract boolean checkTopStoriesWidget();

    public abstract boolean checkFbIcon();

    public abstract boolean checkTwitterIcon();

    public abstract boolean checkyoutubeIcon();

    public abstract boolean checkTopGadgetLaptop();

    public abstract boolean checkTopGadgetTablet();

    public abstract boolean checkTopGadgetMobiles();

    public abstract boolean checkGadgetSearchMobilesBrand();

    public abstract boolean checkGadgetSearchTablets();

    public abstract boolean checkGadgetSearchLaptops();

    public abstract boolean checkGadgetComparisonMobile();

    public abstract boolean checkPopularReviews();

    public abstract boolean checkLatestVideo();

    public abstract boolean checkPhotoGallery();

    public abstract boolean checkWebStory();

    public abstract boolean checkLatestNews();

    public abstract boolean checkRecommenderForYou();

    public abstract boolean checkSponsoredLink();

    public abstract boolean checkTipTrick();

    public abstract boolean checkEditorPick();

    public abstract boolean checkHomePageRHSAdsAreDisplayed();

    public abstract boolean checkAdDisplayingTopAd();

    public abstract boolean checkBottomAdDisplaying();






}
