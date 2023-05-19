package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.CompareCarsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCompareCarPage {
    private static CommonCompareCarPage commonCompareCarPage;
    private static GlobalVars globalVars;

    public static CommonCompareCarPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCompareCarPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCompareCarPage = new CompareCarsPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonCompareCarPage = new com.pages.HT_AUTO.AndroidWebPages.CompareCarsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCompareCarPage;
    }

    public abstract boolean checkCompareCar();

}