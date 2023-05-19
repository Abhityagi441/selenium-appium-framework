package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.PDPLinkModelNamePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonPDPLinkModelNamePage {
    private static CommonPDPLinkModelNamePage commonPDPLinkModelNamePage;
    private static GlobalVars globalVars;

    public static CommonPDPLinkModelNamePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonPDPLinkModelNamePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonPDPLinkModelNamePage = new PDPLinkModelNamePage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonPDPLinkModelNamePage;
    }

    public abstract boolean checkPDPLinkModelNamePage();

}