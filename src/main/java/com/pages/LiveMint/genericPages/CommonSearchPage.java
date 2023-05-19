package com.pages.LiveMint.generic;

import com.pages.LiveMint.ios_native.SearchPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonSearchPage {
    private static CommonSearchPage commonSearchPage;
    private static GlobalVars globalVars;

    public static CommonSearchPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonSearchPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    break;
                case Constants.ANDROID_AMP:
                    break;
                case Constants.IOS_AMP:
                    break;
                case Constants.ANDROID_WEB:
                    break;
                case Constants.IOS_WEB:
                    break;
                case Constants.ANDROID_NATIVE:
                    //commonSearchPage = new com.pages.LiveMint.android_native.SubscriptionPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonSearchPage = new SearchPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonSearchPage;
    }

    public abstract boolean checkSearchIsWorking(String[] params);
}
