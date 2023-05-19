package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.AndroidWebPages.TopNavigationPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonTopNavigationPage {
    private static CommonTopNavigationPage commonTopNavigationPage;
    private static GlobalVars globalVars;

    public static CommonTopNavigationPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonTopNavigationPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
//                    commonBikeByTrendingSearchWidgetPage = new BikesByTrendingSearchWidgetPage();
//                    break;
                case Constants.ANDROID_WEB:
                    commonTopNavigationPage = new TopNavigationPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonTopNavigationPage;
    }

    public abstract boolean checkTopNavigation(String attributeName,String attributeValue);

}