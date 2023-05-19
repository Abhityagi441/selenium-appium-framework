package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.ShareFunctionalityPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonShareFunctionalityPage {
    private static CommonShareFunctionalityPage commonShareFunctionalityPage;
    private static GlobalVars globalVars;

    public static CommonShareFunctionalityPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonShareFunctionalityPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonShareFunctionalityPage = new ShareFunctionalityPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonShareFunctionalityPage=new com.pages.HT_AUTO.AndroidWebPages.ShareFunctionalityPage();
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonShareFunctionalityPage;
    }

    public abstract boolean checkShareFunctionality();

}