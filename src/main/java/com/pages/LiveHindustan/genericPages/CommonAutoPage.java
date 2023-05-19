package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.android_mweb.AutoPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonAutoPage {
    private static CommonAutoPage autoPage;
    private static GlobalVars globalVars;


    public static CommonAutoPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (autoPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.DESKTOP_WEB:
                    autoPage=new com.pages.LiveHindustan.DesktopBrowserPages.AutoPage();
                    break;
                case Constants.AMP:
                case Constants.ANDROID_AMP:
                    autoPage=new com.pages.LiveHindustan.android_amp.AutoPage();
                    break;
                case Constants.IOS_AMP:
                    autoPage=new com.pages.LiveHindustan.ios_amp.AutoPage();
                    break;
                case Constants.ANDROID_WEB:
                    autoPage = new com.pages.LiveHindustan.android_mweb.AutoPage();
                    break;
                case Constants.IOS_WEB:
                    autoPage = new com.pages.LiveHindustan.ios_mweb.AutoPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return autoPage;
    }

    public abstract boolean checkMiltiJultiCarWidgetOnAutoStoryPage();

    public abstract boolean checkSubMenuOnAutoPage();
}
