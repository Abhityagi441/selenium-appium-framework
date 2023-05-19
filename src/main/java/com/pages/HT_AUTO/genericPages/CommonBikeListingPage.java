package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.BikeListingPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBikeListingPage {
    private static CommonBikeListingPage commonBikeListingPage;
    private static GlobalVars globalVars;

    public static CommonBikeListingPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonBikeListingPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonBikeListingPage = new BikeListingPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonBikeListingPage;
    }

    public abstract boolean checkBikeListingPage();

}