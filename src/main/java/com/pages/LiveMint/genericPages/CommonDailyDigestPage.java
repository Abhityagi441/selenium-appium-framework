package com.pages.LiveMint.genericPages;

import com.pages.LiveMint.android_native.DailyDigestPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonDailyDigestPage {
    private static CommonDailyDigestPage commonForYouPage;
    private static GlobalVars globalVars;

    public static CommonDailyDigestPage getInstance() {
        System.out.println("******************* beforeMethod 'Daily-Digest Page' starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonForYouPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.ANDROID_NATIVE:
                    commonForYouPage = new DailyDigestPage();
                    break;
                case Constants.IOS_NATIVE:
                    commonForYouPage = new com.pages.LiveMint.ios_native.DailyDigestPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod 'Daily-Digest Page' ends here *******************");
        return commonForYouPage;
    }

    public abstract boolean checkYourDailyDigestPage();

    public abstract boolean checkDailyDigestBannerMorningAndDailyDigestPage();

    public abstract boolean checkDailyDigestBannerEveningAndDailyDigestPage();
}
