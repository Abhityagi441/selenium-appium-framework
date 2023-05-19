package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.VideoPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonNewsBriefPage {

    private static CommonNewsBriefPage commonNewsBriefPage;
    private static GlobalVars globalVars;

    public static CommonNewsBriefPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonNewsBriefPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                case Constants.DESKTOP_WEB:
                    //commonNewsBriefPage = new NewsBriefPage();
                    break;
                case Constants.ANDROID_AMP:
                    //commonNewsBriefPage = new com.pages.LiveHindustan.android_amp.NewsBriefPage();
                    break;
                case Constants.IOS_AMP:
                    //commonNewsBriefPage = new com.pages.LiveHindustan.ios_amp.NewsBriefPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonNewsBriefPage = new com.pages.LiveHindustan.android_mweb.NewsBriefPage();
                    break;
                case Constants.IOS_WEB:
                    commonNewsBriefPage = new com.pages.LiveHindustan.ios_mweb.NewsBriefPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonNewsBriefPage;
    }

    public abstract boolean checkAllCategoriesAndGiving200StatusCodeOnNewsBriefPage();
    public abstract boolean checkNewsBriefPageIsGiving200StatusCodeAfterLanding();
    public abstract boolean checkAllRelatedNewsArePresentForThatParticularCategory();
    public abstract boolean checkWhileSwipingTheStoriesUrlShouldChange();
    public abstract boolean checkSocialSharingRedirectionOnNewsBriefPage();
    public abstract boolean checkRedirectionOfPuriKhabarPadheOnNewsBriefPage();
}
