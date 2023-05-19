package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.StatePage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonStatePage {
    private static CommonStatePage commonStatePage;
    private static GlobalVars globalVars;

    public static CommonStatePage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonStatePage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                case Constants.DESKTOP_WEB:
                    commonStatePage = new StatePage();
                    break;
                case Constants.ANDROID_AMP:
                    commonStatePage = new com.pages.LiveHindustan.android_amp.StatePage();
                    break;
                case Constants.IOS_AMP:
                    commonStatePage = new com.pages.LiveHindustan.ios_amp.StatePage();
                    break;
                case Constants.ANDROID_WEB:
                    commonStatePage = new com.pages.LiveHindustan.android_mweb.StatePage();
                    break;
                case Constants.IOS_WEB:
                    commonStatePage = new com.pages.LiveHindustan.ios_mweb.StatePage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonStatePage;
    }

    public abstract boolean checkL2SubMenuPresentAndGiving200Status();
    public abstract boolean checkL2SubMenuPresentAndGiving200UttarPradeshState();
    public abstract boolean checkL2SubMenuPresentAndGiving200BiharState();
    public abstract boolean checkL2SubMenuPresentAndGiving200NcrState();
    public abstract boolean checkUttarPradeshNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkNCRNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkBiharNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkUttarakhandNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkJharkhandNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkChhattisgarhNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkMadhyaPradeshNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkMaharashtraNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkRajasthanNewsWidgetIsHaving6StoriesAndStatusIs200();
    public abstract boolean checkHaryanaNewsWidgetIsHaving6StoriesAndStatusIs200();
}
