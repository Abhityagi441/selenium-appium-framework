package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.LatestNewsPage;
import com.pages.HT_AUTO.DesktopBrowserPages.LoginPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLatestNewsPage {

    private static CommonLatestNewsPage commonLatestNewsPage ;

    private static GlobalVars globalVars;

    public static CommonLatestNewsPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonLatestNewsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonLatestNewsPage = new LatestNewsPage();
                    break;
                case Constants.ANDROID_WEB:
//                    commonLatestNewsPage= new com.pages.HT_AUTO.AndroidWebPages.LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLatestNewsPage;
    }

    public abstract boolean navigateToLatestNewsPage(String expectedBreadCrumb, String urlContains);

    public abstract boolean navigateToLatestNewsPage();

    public abstract boolean checkTopStoriesWidget(int noOfStories);

    public abstract boolean checkBottomAdsDisplaying_3();

    public abstract boolean checkTopAdDisplaying_2();

    public abstract boolean checkHomePageRHSAdsAreDisplayed_1();

    public abstract boolean checkNavigationToHomePageUsingBreadCrumb();

    public abstract boolean checkPagination(int noOfStories,String urlContains);

    public abstract boolean checkAllWidgetsAreDisplaying();


}
