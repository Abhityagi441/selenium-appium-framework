package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.CarListingPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCarListingPage {
    private static CommonCarListingPage commonCarListingPage;
    private static GlobalVars globalVars;

    public static CommonCarListingPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCarListingPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCarListingPage = new CarListingPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCarListingPage;
    }

    public abstract boolean checkCarListingPage();

}