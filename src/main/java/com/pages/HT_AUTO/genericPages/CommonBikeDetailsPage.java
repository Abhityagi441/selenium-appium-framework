package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.BikeDetailsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBikeDetailsPage {
    private static CommonBikeDetailsPage commonBikeDetailsPage;
    private static GlobalVars globalVars;

    public static CommonBikeDetailsPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonBikeDetailsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonBikeDetailsPage = new BikeDetailsPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonBikeDetailsPage = new com.pages.HT_AUTO.AndroidWebPages.BikeDetailsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonBikeDetailsPage;
    }

    public abstract boolean checkBikeDetailPage(String expectedBrand, String expectedModel);

}