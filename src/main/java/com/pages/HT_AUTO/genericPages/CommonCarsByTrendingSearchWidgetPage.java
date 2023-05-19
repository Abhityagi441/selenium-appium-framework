package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.AndroidWebPages.CarsByTrendingSearchWidgetPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCarsByTrendingSearchWidgetPage {
    private static CommonCarsByTrendingSearchWidgetPage commonCarsByTrendingSearchWidgetPage;
    private static GlobalVars globalVars;

    public static CommonCarsByTrendingSearchWidgetPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCarsByTrendingSearchWidgetPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
//                case Constants.AMP:
//                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
//                    break;
                case Constants.DESKTOP_WEB:
//                    commonBikeByTrendingSearchWidgetPage = new BikesByTrendingSearchWidgetPage();
//                    break;
                case Constants.ANDROID_WEB:
                    commonCarsByTrendingSearchWidgetPage = new CarsByTrendingSearchWidgetPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCarsByTrendingSearchWidgetPage;
    }

    public abstract boolean checkCarsByTrendingSearchWidget(String expectedTrendingCarText, String expectedSearchCarBrandsText, String expectedCarByBudgetText, String expectedCarByBodyTypeText, String expectedUpcommingCarText);

}