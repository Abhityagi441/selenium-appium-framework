package com.pages.HT_TECH.generic;

import com.pages.HT_TECH.web.MobileNewsPage;
import com.pages.HT_TECH.web.MobileReviewsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMobileReviewsPage {
    private static CommonMobileReviewsPage commonMobileReviewsPage;
    private static GlobalVars globalVars;
    public static CommonMobileReviewsPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonMobileReviewsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {

                case Constants.DESKTOP_WEB:
                    commonMobileReviewsPage=new MobileReviewsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonMobileReviewsPage;
    }
    public abstract boolean checkBreadCrumbsOnMobileReviews();
    public abstract boolean checkTopStoriesWidgetOnMobileReviews();
    public abstract boolean checkMobileReviewsPageRHSAdsAreDisplayed();
}
