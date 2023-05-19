package com.pages.HT_TECH.generic;

import com.pages.HT_TECH.web.MobileNewsPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonMobileNewsPage {
    private static CommonMobileNewsPage commonMobileNewsPage;
    private static GlobalVars globalVars;
    public static CommonMobileNewsPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonMobileNewsPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {

                case Constants.DESKTOP_WEB:
                    commonMobileNewsPage=new MobileNewsPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonMobileNewsPage;
    }
    public abstract boolean checkBreadCrumbsOnMobileNews();
    public abstract boolean checkTopStoriesWidgetOnMobileNews();
    public abstract boolean checkNewsPageRHSAdsAreDisplayed();
}
