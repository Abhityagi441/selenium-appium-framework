package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.AndroidWebPages.BikesByTrendingSearchWidgetPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBikeByTrendingSearchWidgetPage {
    private static CommonBikeByTrendingSearchWidgetPage commonBikeByTrendingSearchWidgetPage;
    private static GlobalVars globalVars;

    public static CommonBikeByTrendingSearchWidgetPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonBikeByTrendingSearchWidgetPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
//                    commonBikeByTrendingSearchWidgetPage = new BikesByTrendingSearchWidgetPage();
//                    break;
                case Constants.ANDROID_WEB:
                    commonBikeByTrendingSearchWidgetPage = new BikesByTrendingSearchWidgetPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonBikeByTrendingSearchWidgetPage;
    }

    public abstract boolean checkBikeByTrendingSearchWidget(String expectedTrendingBikeText,String expectedSearchBikeBrandsText,String expectedBikeByBudgetText);

}