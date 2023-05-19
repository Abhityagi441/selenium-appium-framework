package com.pages.HT_AUTO.genericPages;

import com.pages.HT_AUTO.AndroidWebPages.SearchAnyBikeBrandAndModelPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSearchAnyBikeBrandAndModelPage {
    private static CommonSearchAnyBikeBrandAndModelPage commonSearchAnyBikeBrandAndModelPage;
    private static GlobalVars globalVars;

    public static CommonSearchAnyBikeBrandAndModelPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonSearchAnyBikeBrandAndModelPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
//                    commonSearchAnyBikeBrandAndModelPage = new SearchAnyBikeBrandAndModelPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonSearchAnyBikeBrandAndModelPage = new SearchAnyBikeBrandAndModelPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSearchAnyBikeBrandAndModelPage;
    }

    public abstract boolean checkSearchAnyBikeBrandAndModel(String expectedBrand, String expectedModel,String expectedText);

}