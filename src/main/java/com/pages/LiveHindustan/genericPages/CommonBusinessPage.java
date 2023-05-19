package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.BusinessPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBusinessPage {
    private static CommonBusinessPage businessPage;
    private static GlobalVars globalVars;


    public static CommonBusinessPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (businessPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    businessPage = new BusinessPage();
                    break;
                case Constants.AMP:
                case Constants.ANDROID_AMP:
                case Constants.IOS_AMP:
                case Constants.ANDROID_WEB:
                case Constants.IOS_WEB:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return businessPage;
    }

    public abstract boolean checkTheIFCSCodeSubMenuByEnteringTheIFSCCodeOnBusinessPage(String ifscCode);
    public abstract boolean checkIFCSCodeSubMenuByEnteringLocationOnBusinessPage(String bankName, String stateName, String districtName, String branchName, String ifscCode);
}
