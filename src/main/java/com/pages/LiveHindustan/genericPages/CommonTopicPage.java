package com.pages.LiveHindustan.genericPages;

import com.pages.LiveHindustan.DesktopBrowserPages.PhotoPage;
import com.pages.LiveHindustan.DesktopBrowserPages.TopicPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonTopicPage
{
    private static CommonTopicPage commonTopicPage;
    private static GlobalVars globalVars;

    public static CommonTopicPage getInstance() {
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonTopicPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {
                case Constants.AMP:
                case Constants.DESKTOP_WEB:
                    commonTopicPage = new TopicPage();
                    break;
                case Constants.ANDROID_AMP:
                    //commonTopicPage = new com.pages.LiveHindustan.android_amp.PhotoPage();
                    break;
                case Constants.IOS_AMP:
                    //commonTopicPage = new com.pages.LiveHindustan.ios_amp.PhotoPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonTopicPage = new com.pages.LiveHindustan.android_mweb.TopicPage();
                    break;
                case Constants.IOS_WEB:
                    commonTopicPage = new com.pages.LiveHindustan.ios_mweb.TopicPage();
                    break;
                case Constants.ANDROID_NATIVE:
                case Constants.IOS_NATIVE:
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");

        return commonTopicPage;
    }

    public abstract boolean checkAllTabsAndHeadingOnAnyTopicPage();
}
