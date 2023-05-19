package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.AutoNewsPage;
import com.pages.HT_AUTO.DesktopBrowserPages.LatestNewsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonAutoNewsPage {
    private static CommonAutoNewsPage commonAutoNewsPage ;

    private static GlobalVars globalVars;

    public static CommonAutoNewsPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonAutoNewsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonAutoNewsPage = new AutoNewsPage();
                    break;
                case Constants.ANDROID_WEB:
//                    commonLatestNewsPage= new com.pages.HT_AUTO.AndroidWebPages.LoginPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonAutoNewsPage;
    }

    public abstract boolean navigateToAutoNewsPage(String expectedBreadCrumb, String urlContains);
    public abstract boolean navigateToAutoNewsPage();
    public abstract boolean checkNavigationToHomePageUsingBreadCrumb();
    public abstract boolean checkNavigationToAutoPageUsingBreadCrumb();
}
