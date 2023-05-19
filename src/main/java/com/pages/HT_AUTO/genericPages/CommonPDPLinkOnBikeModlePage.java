package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.PDPLinkOnBikeModlePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPDPLinkOnBikeModlePage {
    private static CommonPDPLinkOnBikeModlePage commonPDPLinkOnBikeModlePage;
    private static GlobalVars globalVars;

    public static CommonPDPLinkOnBikeModlePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonPDPLinkOnBikeModlePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonPDPLinkOnBikeModlePage = new PDPLinkOnBikeModlePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPDPLinkOnBikeModlePage;
    }

    public abstract boolean checkPDPLinkOnBikeModle();

}