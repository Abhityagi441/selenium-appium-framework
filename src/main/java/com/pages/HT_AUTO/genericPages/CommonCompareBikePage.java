package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.CompareBikePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCompareBikePage {
    private static CommonCompareBikePage commonCompareBikePage;
    private static GlobalVars globalVars;

    public static CommonCompareBikePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCompareBikePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCompareBikePage = new CompareBikePage();
                    break;
                case Constants.ANDROID_WEB:
                    commonCompareBikePage=new com.pages.HT_AUTO.AndroidWebPages.CompareBikePage();
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCompareBikePage;
    }

    public abstract boolean checkCompareBikePage();
}