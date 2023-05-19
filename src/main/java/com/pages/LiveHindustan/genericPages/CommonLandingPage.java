package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.LandingPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLandingPage {

    private static CommonLandingPage commonLandingPage;
    private static GlobalVars globalVars;

    public static CommonLandingPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonLandingPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                    break;
                case Constants.DESKTOP_WEB:
                    commonLandingPage = new LandingPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonLandingPage = new com.pages.LiveHindustan.android_amp.LandingPage();
                    break;
                case Constants.IOS_AMP:
                    commonLandingPage = new com.pages.LiveHindustan.ios_amp.LandingPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonLandingPage = new com.pages.LiveHindustan.android_mweb.LandingPage();
                    break;
                case Constants.IOS_WEB:
                    commonLandingPage = new com.pages.LiveHindustan.ios_mweb.LandingPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonLandingPage;
    }

    public abstract boolean checkLandingPage();

    public abstract boolean checkLandingPageSubMenu();

    public abstract  boolean checkAurPadheButtonOnLandingPage();
}
