package com.pages.HindustanTimes.generic;


import com.pages.HindustanTimes.web.HistoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;

public abstract class CommonHistoryPage {
    private static CommonHistoryPage commonHistoryPage;
    private static GlobalVars globalVars;

    public static CommonHistoryPage getInstance(){
        System.out.println("******************* beforeMethod starts here *******************");

        globalVars= GlobalVars.getInstance();
        if(commonHistoryPage==null || !globalVars.getIsLastTestCasePass()){
            switch (globalVars.getPlatformName()){
                case Constants.AMP:
                    //commonLoginPage= new com.pages.HindustanTimes.AMPPages.LoginPage();
                    break;
                case Constants.DESKTOP_WEB:
                    commonHistoryPage= new HistoryPage();
                    break;
                case Constants.ANDROID_AMP:
                    commonHistoryPage= new com.pages.HindustanTimes.android_amp.HistoryPage();
                    break;
                case Constants.IOS_AMP:
                   // commonHistoryPage= new com.pages.HindustanTimes.ios_amp.HistoryPage();
                    break;
                case Constants.ANDROID_WEB:
                    commonHistoryPage= new com.pages.HindustanTimes.android_mweb.HistoryPage();
                    break;
                case Constants.IOS_WEB:
                   commonHistoryPage= new com.pages.HindustanTimes.ios_mweb.HistoryPage();
                    break;
                case Constants.ANDROID_NATIVE:
                    commonHistoryPage= new com.pages.HindustanTimes.android_native.HistoryPage();
                    break;
                case Constants.IOS_NATIVE:
                   // commonBookmarkPage= new com.pages.HindustanTimes.ios_native.BookmarkPage();
                    break;
            }
        }
        System.out.println("******************* beforeMethod ends here *******************");
        return commonHistoryPage;
    }

    public abstract boolean checkMyReadsHasHistoryOfAllStoriesRead(String uri, String address) throws Exception;
}
