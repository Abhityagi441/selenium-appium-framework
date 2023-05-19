package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.DesktopBrowserPages.OnSiteSearchPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonOnSiteSearchPage {
    private static CommonOnSiteSearchPage commonOnSiteSearchPage;
    private static GlobalVars globalVars;

    public static CommonOnSiteSearchPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonOnSiteSearchPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    commonOnSiteSearchPage = new OnSiteSearchPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonOnSiteSearchPage;
    }

    public abstract boolean checkOnSiteSearchWithRespectToCar(String expectedCarBrand, String carBrandList);

}