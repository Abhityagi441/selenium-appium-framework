package com.pages.HT_TECH.generic;

import com.pages.HT_TECH.web.PhotoPage;
import com.pages.HT_TECH.web.VideoPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonVideoPage {
    private static CommonVideoPage commonVideoPage;
    private static GlobalVars globalVars;
    public static CommonVideoPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars = GlobalVars.getInstance();
        if (commonVideoPage == null || !globalVars.getIsLastTestCasePass()) {
            switch (globalVars.getPlatformName()) {

                case Constants.DESKTOP_WEB:
                    commonVideoPage = new VideoPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonVideoPage;
    }
    public abstract boolean checkVideoOnListingPage();
    public abstract boolean checkLatestStoriesOnVideoPage();
    public abstract boolean checkVideoDetailPage();

    public abstract boolean checkTrendingStoriesOnVideoPage();

}
