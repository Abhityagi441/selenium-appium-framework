package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.AstrologyPage;
import com.pages.LiveHindustan.DesktopBrowserPages.HomePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonAastrologyPage {
    private static CommonAastrologyPage commoAastrologyPage;
    private static GlobalVars globalVars;


    public static CommonAastrologyPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commoAastrologyPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commoAastrologyPage = new AstrologyPage();
                    break;
                case Constants.ANDROID_AMP:
                    //commoAastrologyPage = new com.pages.LiveHindustan.android_amp.AstrologyPage();
                    break;
                case Constants.IOS_AMP:
                case Constants.ANDROID_WEB:
                    commoAastrologyPage = new com.pages.LiveHindustan.android_mweb.AstrologyPage();
                    break;
                case Constants.IOS_WEB:
                    commoAastrologyPage = new com.pages.LiveHindustan.ios_mweb.AstrologyPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commoAastrologyPage;
    }

    public abstract boolean checkAstrologyLandingPage();

    public abstract boolean checkRashiFalLinks();
    public abstract boolean checkRashiFalPage();
    public abstract boolean checkAllSubMenuArePresentAndGiving200StatusCodeOnAstrologyPage();
    public abstract boolean checkDataIsDisplayedUnderDifferentTabsOnSelectedRashi();
    public abstract boolean checkClickingOnAnyRashiRedirectsToCorrectURLOnRashifalDetailPage();

}
