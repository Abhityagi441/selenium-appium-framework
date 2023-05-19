package com.pages.BlankPaper.genericPages;

import com.pages.BlankPaper.webdesktop.stories.BannerPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonBannerPage {
    private static CommonBannerPage commonBannerPage;
    private static GlobalVars globalVars;

    public static CommonBannerPage getInstance() {
        globalVars = GlobalVars.getInstance();
        if (commonBannerPage == null) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonBannerPage = new BannerPage();
                    break;
            }
        }
        return commonBannerPage;
    }

    public abstract boolean checkInputFieldsShouldBeDisplayedForBanner();
    public abstract boolean checkUserShouldBeAbleToCreateBanner(String bannerName, String bannerLandingUrl, String metaBannerName, String metaTags, String metaExternalUrl);
}
