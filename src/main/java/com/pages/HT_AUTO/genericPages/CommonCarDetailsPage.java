package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.AndroidWebPages.SearchAnyBikeBrandAndModelPage;
import com.pages.HT_AUTO.DesktopBrowserPages.CarDetailsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonCarDetailsPage {
    private static CommonCarDetailsPage commonCarDetailsPage;
    private static GlobalVars globalVars;

    public static CommonCarDetailsPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonCarDetailsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_WEB:
                    commonCarDetailsPage = new com.pages.HT_AUTO.AndroidWebPages.CarDetailsPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonCarDetailsPage = new CarDetailsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonCarDetailsPage;
    }

    public abstract boolean checkCarDetails();

}