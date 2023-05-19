package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.AdvertismentPage;
import com.pages.HindustanTimes.web.LatestStoriesPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonLatestStoriesPage {
    private static CommonLatestStoriesPage commonLatestStoriesPage;
    private static GlobalVars globalVars;

    public static CommonLatestStoriesPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonLatestStoriesPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonLatestStoriesPage= new LatestStoriesPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonLatestStoriesPage= new com.pages.HindustanTimes.android_amp.LatestStoriesPage();
                    break;
                case Constants.IOS_AMP:
                case Constants.ANDROID_WEB:
                    commonLatestStoriesPage= new com.pages.HindustanTimes.android_mweb.LatestStoriesPage();
                    break;
                case Constants.IOS_WEB:
                  //  commonHistoryPage= new com.pages.HindustanTimes.ios_mweb.BookmarkPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonLatestStoriesPage= new com.pages.HindustanTimes.android_native.LatestStoriesPage();
                    break;
                case Constants.IOS_NATIVE:
                   // commonBookmarkPage= new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonLatestStoriesPage;
    }


    public abstract boolean checkStoriesPublishedOnDateDisplayedOnTopOfPage() throws Exception;
}
